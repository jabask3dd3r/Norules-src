package net.minecraft.server.integrated;

import net.minecraft.server.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.command.*;
import net.minecraft.profiler.*;
import net.minecraft.crash.*;
import net.minecraft.client.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import com.google.common.util.concurrent.*;
import java.io.*;
import org.apache.logging.log4j.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.minecraft.*;
import com.mojang.authlib.*;
import net.minecraft.server.management.*;
import optifine.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;

public class IntegratedServer extends MinecraftServer
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ WorldSettings theWorldSettings;
    private /* synthetic */ boolean isPublic;
    private /* synthetic */ boolean isGamePaused;
    private /* synthetic */ ThreadLanServerPing lanServerPing;
    
    @Override
    public void setDifficultyForAllWorlds(final EnumDifficulty lllllllllllllIllIIlIllllIIIlIllI) {
        super.setDifficultyForAllWorlds(lllllllllllllIllIIlIllllIIIlIllI);
        if (this.mc.world != null) {
            this.mc.world.getWorldInfo().setDifficulty(lllllllllllllIllIIlIllllIIIlIllI);
        }
    }
    
    @Override
    public GameType getGameType() {
        return this.theWorldSettings.getGameType();
    }
    
    @Override
    public int getOpPermissionLevel() {
        return 4;
    }
    
    @Override
    public ServerCommandManager createNewCommandManager() {
        return new IntegratedServerCommandManager(this);
    }
    
    @Override
    public boolean shouldBroadcastConsoleToOps() {
        return true;
    }
    
    @Override
    public void stopServer() {
        super.stopServer();
        if (this.lanServerPing != null) {
            this.lanServerPing.interrupt();
            this.lanServerPing = null;
        }
    }
    
    public boolean getPublic() {
        return this.isPublic;
    }
    
    @Override
    public boolean shouldUseNativeTransport() {
        return false;
    }
    
    @Override
    public boolean isCommandBlockEnabled() {
        return true;
    }
    
    @Override
    public void addServerStatsToSnooper(final Snooper lllllllllllllIllIIlIllllIIIlIIII) {
        super.addServerStatsToSnooper(lllllllllllllIllIIlIllllIIIlIIII);
        lllllllllllllIllIIlIllllIIIlIIII.addClientStat("snooper_partner", this.mc.getPlayerUsageSnooper().getUniqueID());
    }
    
    @Override
    public CrashReport addServerInfoToCrashReport(CrashReport lllllllllllllIllIIlIllllIIIlllII) {
        lllllllllllllIllIIlIllllIIIlllII = (long)super.addServerInfoToCrashReport((CrashReport)lllllllllllllIllIIlIllllIIIlllII);
        ((CrashReport)lllllllllllllIllIIlIllllIIIlllII).getCategory().setDetail("Type", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return "Integrated Server (map_client.txt)";
            }
        });
        ((CrashReport)lllllllllllllIllIIlIllllIIIlllII).getCategory().setDetail("Is Modded", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                String lllllllllllllllIIIlIllIIlIIlIlIl = ClientBrandRetriever.getClientModName();
                if (!lllllllllllllllIIIlIllIIlIIlIlIl.equals("vanilla")) {
                    return String.valueOf(new StringBuilder("Definitely; Client brand changed to '").append(lllllllllllllllIIIlIllIIlIIlIlIl).append("'"));
                }
                lllllllllllllllIIIlIllIIlIIlIlIl = IntegratedServer.this.getServerModName();
                if (!"vanilla".equals(lllllllllllllllIIIlIllIIlIIlIlIl)) {
                    return String.valueOf(new StringBuilder("Definitely; Server brand changed to '").append(lllllllllllllllIIIlIllIIlIIlIlIl).append("'"));
                }
                return (Minecraft.class.getSigners() == null) ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and both client + server brands are untouched.";
            }
        });
        return (CrashReport)lllllllllllllIllIIlIllllIIIlllII;
    }
    
    @Override
    public void saveAllWorlds(final boolean lllllllllllllIllIIlIllllIIlIllll) {
        super.saveAllWorlds(lllllllllllllIllIIlIllllIIlIllll);
    }
    
    @Override
    public void initiateShutdown() {
        if (!Reflector.MinecraftForge.exists() || this.isServerRunning()) {
            Futures.getUnchecked((Future)this.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    for (final EntityPlayerMP lllllllllllllIllllllIIlIIIIllIlI : Lists.newArrayList((Iterable)IntegratedServer.this.getPlayerList().getPlayerList())) {
                        if (!lllllllllllllIllllllIIlIIIIllIlI.getUniqueID().equals(IntegratedServer.this.mc.player.getUniqueID())) {
                            IntegratedServer.this.getPlayerList().playerLoggedOut(lllllllllllllIllllllIIlIIIIllIlI);
                        }
                    }
                }
            }));
        }
        super.initiateShutdown();
        if (this.lanServerPing != null) {
            this.lanServerPing.interrupt();
            this.lanServerPing = null;
        }
    }
    
    @Override
    public File getDataDirectory() {
        return this.mc.mcDataDir;
    }
    
    @Override
    public boolean startServer() throws IOException {
        IntegratedServer.LOGGER.info("Starting integrated minecraft server version 1.12.2");
        this.setOnlineMode(true);
        this.setCanSpawnAnimals(true);
        this.setCanSpawnNPCs(true);
        this.setAllowPvp(true);
        this.setAllowFlight(true);
        IntegratedServer.LOGGER.info("Generating keypair");
        this.setKeyPair(CryptManager.generateKeyPair());
        if (Reflector.FMLCommonHandler_handleServerAboutToStart.exists()) {
            final Object lllllllllllllIllIIlIllllIlIlIlll = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            if (!Reflector.callBoolean(lllllllllllllIllIIlIllllIlIlIlll, Reflector.FMLCommonHandler_handleServerAboutToStart, this)) {
                return false;
            }
        }
        this.loadAllWorlds(this.getFolderName(), this.getWorldName(), this.theWorldSettings.getSeed(), this.theWorldSettings.getTerrainType(), this.theWorldSettings.getGeneratorOptions());
        this.setMOTD(String.valueOf(new StringBuilder(String.valueOf(this.getServerOwner())).append(" - ").append(this.worldServers[0].getWorldInfo().getWorldName())));
        if (Reflector.FMLCommonHandler_handleServerStarting.exists()) {
            final Object lllllllllllllIllIIlIllllIlIlIllI = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            if (Reflector.FMLCommonHandler_handleServerStarting.getReturnType() == Boolean.TYPE) {
                return Reflector.callBoolean(lllllllllllllIllIIlIllllIlIlIllI, Reflector.FMLCommonHandler_handleServerStarting, this);
            }
            Reflector.callVoid(lllllllllllllIllIIlIllllIlIlIllI, Reflector.FMLCommonHandler_handleServerStarting, this);
        }
        return true;
    }
    
    @Override
    public boolean isHardcore() {
        return this.theWorldSettings.getHardcoreEnabled();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void tick() {
        final boolean lllllllllllllIllIIlIllllIlIIlIlI = this.isGamePaused;
        this.isGamePaused = (Minecraft.getMinecraft().getConnection() != null && Minecraft.getMinecraft().isGamePaused());
        if (!lllllllllllllIllIIlIllllIlIIlIlI && this.isGamePaused) {
            IntegratedServer.LOGGER.info("Saving and pausing game...");
            this.getPlayerList().saveAllPlayerData();
            this.saveAllWorlds(false);
        }
        if (this.isGamePaused) {
            synchronized (this.futureTaskQueue) {
                while (!this.futureTaskQueue.isEmpty()) {
                    Util.runTask(this.futureTaskQueue.poll(), IntegratedServer.LOGGER);
                }
                // monitorexit(this.futureTaskQueue)
                return;
            }
        }
        super.tick();
        if (this.mc.gameSettings.renderDistanceChunks != this.getPlayerList().getViewDistance()) {
            IntegratedServer.LOGGER.info("Changing view distance to {}, from {}", (Object)this.mc.gameSettings.renderDistanceChunks, (Object)this.getPlayerList().getViewDistance());
            this.getPlayerList().setViewDistance(this.mc.gameSettings.renderDistanceChunks);
        }
        if (this.mc.world != null) {
            final WorldInfo lllllllllllllIllIIlIllllIlIIlIIl = this.worldServers[0].getWorldInfo();
            final WorldInfo lllllllllllllIllIIlIllllIlIIlIII = this.mc.world.getWorldInfo();
            if (!lllllllllllllIllIIlIllllIlIIlIIl.isDifficultyLocked() && lllllllllllllIllIIlIllllIlIIlIII.getDifficulty() != lllllllllllllIllIIlIllllIlIIlIIl.getDifficulty()) {
                IntegratedServer.LOGGER.info("Changing difficulty to {}, from {}", (Object)lllllllllllllIllIIlIllllIlIIlIII.getDifficulty(), (Object)lllllllllllllIllIIlIllllIlIIlIIl.getDifficulty());
                this.setDifficultyForAllWorlds(lllllllllllllIllIIlIllllIlIIlIII.getDifficulty());
            }
            else if (lllllllllllllIllIIlIllllIlIIlIII.isDifficultyLocked() && !lllllllllllllIllIIlIllllIlIIlIIl.isDifficultyLocked()) {
                IntegratedServer.LOGGER.info("Locking difficulty to {}", (Object)lllllllllllllIllIIlIllllIlIIlIII.getDifficulty());
                final float lllllllllllllIllIIlIllllIIllllll;
                final float lllllllllllllIllIIlIllllIlIIIIII = ((WorldServer[])(Object)(lllllllllllllIllIIlIllllIIllllll = (float)(Object)this.worldServers)).length;
                for (boolean lllllllllllllIllIIlIllllIlIIIIIl = false; (lllllllllllllIllIIlIllllIlIIIIIl ? 1 : 0) < lllllllllllllIllIIlIllllIlIIIIII; ++lllllllllllllIllIIlIllllIlIIIIIl) {
                    final WorldServer lllllllllllllIllIIlIllllIlIIIlll = lllllllllllllIllIIlIllllIIllllll[lllllllllllllIllIIlIllllIlIIIIIl];
                    if (lllllllllllllIllIIlIllllIlIIIlll != null) {
                        lllllllllllllIllIIlIllllIlIIIlll.getWorldInfo().setDifficultyLocked(true);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean canStructuresSpawn() {
        return false;
    }
    
    @Override
    public String shareToLAN(final GameType lllllllllllllIllIIlIllllIIIIlIII, final boolean lllllllllllllIllIIlIllllIIIIIIlI) {
        try {
            int lllllllllllllIllIIlIllllIIIIIllI = -1;
            try {
                lllllllllllllIllIIlIllllIIIIIllI = HttpUtil.getSuitableLanPort();
            }
            catch (IOException ex) {}
            if (lllllllllllllIllIIlIllllIIIIIllI <= 0) {
                lllllllllllllIllIIlIllllIIIIIllI = 25564;
            }
            this.getNetworkSystem().addLanEndpoint(null, lllllllllllllIllIIlIllllIIIIIllI);
            IntegratedServer.LOGGER.info("Started on {}", (Object)lllllllllllllIllIIlIllllIIIIIllI);
            this.isPublic = true;
            this.lanServerPing = new ThreadLanServerPing(this.getMOTD(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIIlIllllIIIIIllI))));
            this.lanServerPing.start();
            this.getPlayerList().setGameType(lllllllllllllIllIIlIllllIIIIlIII);
            this.getPlayerList().setCommandsAllowedForAll(lllllllllllllIllIIlIllllIIIIIIlI);
            this.mc.player.setPermissionLevel(lllllllllllllIllIIlIllllIIIIIIlI ? 4 : 0);
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIIlIllllIIIIIllI)));
        }
        catch (IOException lllllllllllllIllIIlIllllIIIIIlIl) {
            return null;
        }
    }
    
    @Override
    public boolean shouldBroadcastRconToOps() {
        return true;
    }
    
    @Override
    public boolean isSnooperEnabled() {
        return Minecraft.getMinecraft().isSnooperEnabled();
    }
    
    public IntegratedServer(final Minecraft lllllllllllllIllIIlIlllllIIlIlll, final String lllllllllllllIllIIlIlllllIIlIllI, final String lllllllllllllIllIIlIlllllIIIllII, final WorldSettings lllllllllllllIllIIlIlllllIIlIlII, final YggdrasilAuthenticationService lllllllllllllIllIIlIlllllIIIlIlI, final MinecraftSessionService lllllllllllllIllIIlIlllllIIlIIlI, final GameProfileRepository lllllllllllllIllIIlIlllllIIlIIIl, final PlayerProfileCache lllllllllllllIllIIlIlllllIIlIIII) {
        super(new File(lllllllllllllIllIIlIlllllIIlIlll.mcDataDir, "saves"), lllllllllllllIllIIlIlllllIIlIlll.getProxy(), lllllllllllllIllIIlIlllllIIlIlll.getDataFixer(), lllllllllllllIllIIlIlllllIIIlIlI, lllllllllllllIllIIlIlllllIIlIIlI, lllllllllllllIllIIlIlllllIIlIIIl, lllllllllllllIllIIlIlllllIIlIIII);
        this.setServerOwner(lllllllllllllIllIIlIlllllIIlIlll.getSession().getUsername());
        this.setFolderName(lllllllllllllIllIIlIlllllIIlIllI);
        this.setWorldName(lllllllllllllIllIIlIlllllIIIllII);
        this.setDemo(lllllllllllllIllIIlIlllllIIlIlll.isDemo());
        this.canCreateBonusChest(lllllllllllllIllIIlIlllllIIlIlII.isBonusChestEnabled());
        this.setBuildLimit(256);
        this.setPlayerList(new IntegratedPlayerList(this));
        this.mc = lllllllllllllIllIIlIlllllIIlIlll;
        this.theWorldSettings = (this.isDemo() ? WorldServerDemo.DEMO_WORLD_SETTINGS : lllllllllllllIllIIlIlllllIIlIlII);
    }
    
    @Override
    public EnumDifficulty getDifficulty() {
        return (this.mc.world == null) ? this.mc.gameSettings.difficulty : this.mc.world.getWorldInfo().getDifficulty();
    }
    
    @Override
    public void finalTick(final CrashReport lllllllllllllIllIIlIllllIIlIIIlI) {
        this.mc.crashed(lllllllllllllIllIIlIllllIIlIIIlI);
    }
    
    @Override
    public void loadAllWorlds(final String lllllllllllllIllIIlIllllIlllIllI, final String lllllllllllllIllIIlIllllIllIIlII, final long lllllllllllllIllIIlIllllIlllIlII, final WorldType lllllllllllllIllIIlIllllIlllIIll, final String lllllllllllllIllIIlIllllIlllIIlI) {
        this.convertMapIfNeeded(lllllllllllllIllIIlIllllIlllIllI);
        final ISaveHandler lllllllllllllIllIIlIllllIlllIIIl = this.getActiveAnvilConverter().getSaveLoader(lllllllllllllIllIIlIllllIlllIllI, true);
        this.setResourcePackFromWorld(this.getFolderName(), lllllllllllllIllIIlIllllIlllIIIl);
        WorldInfo lllllllllllllIllIIlIllllIlllIIII = lllllllllllllIllIIlIllllIlllIIIl.loadWorldInfo();
        if (Reflector.DimensionManager.exists()) {
            final WorldServer lllllllllllllIllIIlIllllIllIllll = (WorldServer)(this.isDemo() ? new WorldServerDemo(this, lllllllllllllIllIIlIllllIlllIIIl, lllllllllllllIllIIlIllllIlllIIII, 0, this.theProfiler).init() : ((WorldServer)new WorldServerOF(this, lllllllllllllIllIIlIllllIlllIIIl, lllllllllllllIllIIlIllllIlllIIII, 0, this.theProfiler).init()));
            lllllllllllllIllIIlIllllIllIllll.initialize(this.theWorldSettings);
            final Integer[] lllllllllllllIllIIlIllllIllIllIl;
            final Integer[] lllllllllllllIllIIlIllllIllIlllI = lllllllllllllIllIIlIllllIllIllIl = (Integer[])Reflector.call(Reflector.DimensionManager_getStaticDimensionIDs, new Object[0]);
            for (int lllllllllllllIllIIlIllllIllIllII = lllllllllllllIllIIlIllllIllIlllI.length, lllllllllllllIllIIlIllllIllIlIll = 0; lllllllllllllIllIIlIllllIllIlIll < lllllllllllllIllIIlIllllIllIllII; ++lllllllllllllIllIIlIllllIllIlIll) {
                final int lllllllllllllIllIIlIllllIllIlIlI = lllllllllllllIllIIlIllllIllIllIl[lllllllllllllIllIIlIllllIllIlIll];
                final WorldServer lllllllllllllIllIIlIllllIllIlIIl = (WorldServer)((lllllllllllllIllIIlIllllIllIlIlI == 0) ? lllllllllllllIllIIlIllllIllIllll : new WorldServerMulti(this, lllllllllllllIllIIlIllllIlllIIIl, lllllllllllllIllIIlIllllIllIlIlI, lllllllllllllIllIIlIllllIllIllll, this.theProfiler).init());
                lllllllllllllIllIIlIllllIllIlIIl.addEventListener(new ServerWorldEventHandler(this, lllllllllllllIllIIlIllllIllIlIIl));
                if (!this.isSinglePlayer()) {
                    lllllllllllllIllIIlIllllIllIlIIl.getWorldInfo().setGameType(this.getGameType());
                }
                if (Reflector.EventBus.exists()) {
                    Reflector.postForgeBusEvent(Reflector.WorldEvent_Load_Constructor, lllllllllllllIllIIlIllllIllIlIIl);
                }
            }
            this.getPlayerList().setPlayerManager(new WorldServer[] { lllllllllllllIllIIlIllllIllIllll });
            if (lllllllllllllIllIIlIllllIllIllll.getWorldInfo().getDifficulty() == null) {
                this.setDifficultyForAllWorlds(this.mc.gameSettings.difficulty);
            }
        }
        else {
            this.worldServers = new WorldServer[3];
            this.timeOfLastDimensionTick = new long[this.worldServers.length][100];
            this.setResourcePackFromWorld(this.getFolderName(), lllllllllllllIllIIlIllllIlllIIIl);
            if (lllllllllllllIllIIlIllllIlllIIII == null) {
                lllllllllllllIllIIlIllllIlllIIII = new WorldInfo(this.theWorldSettings, lllllllllllllIllIIlIllllIllIIlII);
            }
            else {
                lllllllllllllIllIIlIllllIlllIIII.setWorldName(lllllllllllllIllIIlIllllIllIIlII);
            }
            for (int lllllllllllllIllIIlIllllIllIlIII = 0; lllllllllllllIllIIlIllllIllIlIII < this.worldServers.length; ++lllllllllllllIllIIlIllllIllIlIII) {
                int lllllllllllllIllIIlIllllIllIIlll = 0;
                if (lllllllllllllIllIIlIllllIllIlIII == 1) {
                    lllllllllllllIllIIlIllllIllIIlll = -1;
                }
                if (lllllllllllllIllIIlIllllIllIlIII == 2) {
                    lllllllllllllIllIIlIllllIllIIlll = 1;
                }
                if (lllllllllllllIllIIlIllllIllIlIII == 0) {
                    if (this.isDemo()) {
                        this.worldServers[lllllllllllllIllIIlIllllIllIlIII] = (WorldServer)new WorldServerDemo(this, lllllllllllllIllIIlIllllIlllIIIl, lllllllllllllIllIIlIllllIlllIIII, lllllllllllllIllIIlIllllIllIIlll, this.theProfiler).init();
                    }
                    else {
                        this.worldServers[lllllllllllllIllIIlIllllIllIlIII] = (WorldServer)new WorldServerOF(this, lllllllllllllIllIIlIllllIlllIIIl, lllllllllllllIllIIlIllllIlllIIII, lllllllllllllIllIIlIllllIllIIlll, this.theProfiler).init();
                    }
                    this.worldServers[lllllllllllllIllIIlIllllIllIlIII].initialize(this.theWorldSettings);
                }
                else {
                    this.worldServers[lllllllllllllIllIIlIllllIllIlIII] = (WorldServer)new WorldServerMulti(this, lllllllllllllIllIIlIllllIlllIIIl, lllllllllllllIllIIlIllllIllIIlll, this.worldServers[0], this.theProfiler).init();
                }
                this.worldServers[lllllllllllllIllIIlIllllIllIlIII].addEventListener(new ServerWorldEventHandler(this, this.worldServers[lllllllllllllIllIIlIllllIllIlIII]));
            }
            this.getPlayerList().setPlayerManager(this.worldServers);
            if (this.worldServers[0].getWorldInfo().getDifficulty() == null) {
                this.setDifficultyForAllWorlds(this.mc.gameSettings.difficulty);
            }
        }
        this.initialWorldChunkLoad();
    }
    
    @Override
    public boolean isDedicatedServer() {
        return false;
    }
    
    @Override
    public void setGameType(final GameType lllllllllllllIllIIlIlllIllllIIIl) {
        super.setGameType(lllllllllllllIllIIlIlllIllllIIIl);
        this.getPlayerList().setGameType(lllllllllllllIllIIlIlllIllllIIIl);
    }
}
