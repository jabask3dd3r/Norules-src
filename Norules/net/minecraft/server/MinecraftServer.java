package net.minecraft.server;

import com.mojang.authlib.minecraft.*;
import net.minecraft.util.datafix.*;
import net.minecraft.server.management.*;
import net.minecraft.profiler.*;
import com.mojang.authlib.yggdrasil.*;
import java.security.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.world.storage.*;
import java.nio.charset.*;
import java.net.*;
import org.apache.commons.lang3.*;
import com.google.common.util.concurrent.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.text.*;
import java.text.*;
import javax.imageio.*;
import io.netty.handler.codec.base64.*;
import io.netty.buffer.*;
import java.awt.image.*;
import com.mojang.authlib.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.crash.*;
import net.minecraft.entity.player.*;
import java.awt.*;
import net.minecraft.command.*;
import java.util.concurrent.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.world.chunk.storage.*;
import java.io.*;
import net.minecraft.util.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.advancements.*;

public abstract class MinecraftServer implements IThreadListener, Runnable, ICommandSender, ISnooperInfo
{
    protected final /* synthetic */ Proxy serverProxy;
    public /* synthetic */ long[][] timeOfLastDimensionTick;
    private /* synthetic */ boolean serverStopped;
    private /* synthetic */ boolean canSpawnNPCs;
    private final /* synthetic */ MinecraftSessionService sessionService;
    public final /* synthetic */ ICommandManager commandManager;
    private final /* synthetic */ PlayerProfileCache profileCache;
    public final /* synthetic */ Queue<FutureTask<?>> futureTaskQueue;
    private /* synthetic */ boolean startProfiling;
    private /* synthetic */ String userMessage;
    private /* synthetic */ int maxPlayerIdleMinutes;
    public /* synthetic */ WorldServer[] worldServers;
    private /* synthetic */ boolean isGamemodeForced;
    private static final /* synthetic */ Logger LOG;
    private /* synthetic */ String serverOwner;
    private /* synthetic */ Thread serverThread;
    private /* synthetic */ boolean enableBonusChest;
    public final /* synthetic */ long[] tickTimeArray;
    private /* synthetic */ String motd;
    private final /* synthetic */ ISaveFormat anvilConverterForAnvilFile;
    private final /* synthetic */ DataFixer dataFixer;
    private final /* synthetic */ List<ITickable> tickables;
    public /* synthetic */ String currentTask;
    private /* synthetic */ int serverPort;
    private final /* synthetic */ Snooper usageSnooper;
    private /* synthetic */ boolean isDemo;
    private /* synthetic */ String worldName;
    public /* synthetic */ int percentDone;
    private /* synthetic */ long nanoTimeSinceStatusRefresh;
    private final /* synthetic */ File anvilFile;
    private /* synthetic */ boolean onlineMode;
    private /* synthetic */ boolean worldIconSet;
    private final /* synthetic */ Random random;
    private /* synthetic */ String folderName;
    private /* synthetic */ PlayerList playerList;
    public final /* synthetic */ Profiler theProfiler;
    private final /* synthetic */ NetworkSystem networkSystem;
    private /* synthetic */ boolean allowFlight;
    private /* synthetic */ boolean serverRunning;
    private /* synthetic */ boolean serverIsRunning;
    private /* synthetic */ boolean field_190519_A;
    private /* synthetic */ boolean canSpawnAnimals;
    private final /* synthetic */ YggdrasilAuthenticationService authService;
    private /* synthetic */ String resourcePackHash;
    private /* synthetic */ long currentTime;
    private /* synthetic */ KeyPair serverKeyPair;
    private /* synthetic */ boolean pvpEnabled;
    private /* synthetic */ int tickCounter;
    private /* synthetic */ String resourcePackUrl;
    private final /* synthetic */ ServerStatusResponse statusResponse;
    private /* synthetic */ long timeOfLastWarning;
    private /* synthetic */ int buildLimit;
    private final /* synthetic */ GameProfileRepository profileRepo;
    
    public void initiateShutdown() {
        this.serverRunning = false;
    }
    
    public String getMOTD() {
        return this.motd;
    }
    
    public boolean isServerRunning() {
        return this.serverRunning;
    }
    
    public void setMOTD(final String lllllllllllllIIIIlllIlIllllIllII) {
        this.motd = lllllllllllllIIIIlllIlIllllIllII;
    }
    
    @Nullable
    public Entity getEntityFromUuid(final UUID lllllllllllllIIIIlllIlIllIIIlIII) {
        final long lllllllllllllIIIIlllIlIllIIIIIII;
        final int lllllllllllllIIIIlllIlIllIIIIIIl = ((WorldServer[])(Object)(lllllllllllllIIIIlllIlIllIIIIIII = (long)(Object)this.worldServers)).length;
        for (Exception lllllllllllllIIIIlllIlIllIIIIIlI = (Exception)0; lllllllllllllIIIIlllIlIllIIIIIlI < lllllllllllllIIIIlllIlIllIIIIIIl; ++lllllllllllllIIIIlllIlIllIIIIIlI) {
            final WorldServer lllllllllllllIIIIlllIlIllIIIIlll = lllllllllllllIIIIlllIlIllIIIIIII[lllllllllllllIIIIlllIlIllIIIIIlI];
            if (lllllllllllllIIIIlllIlIllIIIIlll != null) {
                final Entity lllllllllllllIIIIlllIlIllIIIIllI = lllllllllllllIIIIlllIlIllIIIIlll.getEntityFromUuid(lllllllllllllIIIIlllIlIllIIIlIII);
                if (lllllllllllllIIIIlllIlIllIIIIllI != null) {
                    return lllllllllllllIIIIlllIlIllIIIIllI;
                }
            }
        }
        return null;
    }
    
    public void initialWorldChunkLoad() {
        final int lllllllllllllIIIIlllIllllIlIlIIl = 16;
        final int lllllllllllllIIIIlllIllllIlIlIII = 4;
        final int lllllllllllllIIIIlllIllllIlIIlll = 192;
        final int lllllllllllllIIIIlllIllllIlIIllI = 625;
        int lllllllllllllIIIIlllIllllIlIIlIl = 0;
        this.setUserMessage("menu.generatingTerrain");
        final int lllllllllllllIIIIlllIllllIlIIlII = 0;
        MinecraftServer.LOG.info("Preparing start region for level 0");
        final WorldServer lllllllllllllIIIIlllIllllIlIIIll = this.worldServers[0];
        final BlockPos lllllllllllllIIIIlllIllllIlIIIlI = lllllllllllllIIIIlllIllllIlIIIll.getSpawnPoint();
        long lllllllllllllIIIIlllIllllIlIIIIl = getCurrentTimeMillis();
        for (int lllllllllllllIIIIlllIllllIlIIIII = -192; lllllllllllllIIIIlllIllllIlIIIII <= 192 && this.isServerRunning(); lllllllllllllIIIIlllIllllIlIIIII += 16) {
            for (int lllllllllllllIIIIlllIllllIIlllll = -192; lllllllllllllIIIIlllIllllIIlllll <= 192 && this.isServerRunning(); lllllllllllllIIIIlllIllllIIlllll += 16) {
                final long lllllllllllllIIIIlllIllllIIllllI = getCurrentTimeMillis();
                if (lllllllllllllIIIIlllIllllIIllllI - lllllllllllllIIIIlllIllllIlIIIIl > 1000L) {
                    this.outputPercentRemaining("Preparing spawn area", lllllllllllllIIIIlllIllllIlIIlIl * 100 / 625);
                    lllllllllllllIIIIlllIllllIlIIIIl = lllllllllllllIIIIlllIllllIIllllI;
                }
                ++lllllllllllllIIIIlllIllllIlIIlIl;
                lllllllllllllIIIIlllIllllIlIIIll.getChunkProvider().provideChunk(lllllllllllllIIIIlllIllllIlIIIlI.getX() + lllllllllllllIIIIlllIllllIlIIIII >> 4, lllllllllllllIIIIlllIllllIlIIIlI.getZ() + lllllllllllllIIIIlllIllllIIlllll >> 4);
            }
        }
        this.clearCurrentTask();
    }
    
    public void setBuildLimit(final int lllllllllllllIIIIlllIlIllllIIIll) {
        this.buildLimit = lllllllllllllIIIIlllIlIllllIIIll;
    }
    
    public void logWarning(final String lllllllllllllIIIIlllIllIlllIIllI) {
        MinecraftServer.LOG.warn(lllllllllllllIIIIlllIllIlllIIllI);
    }
    
    public ICommandManager getCommandManager() {
        return this.commandManager;
    }
    
    public void setResourcePack(final String lllllllllllllIIIIlllIllIIlIIIIll, final String lllllllllllllIIIIlllIllIIlIIIIlI) {
        this.resourcePackUrl = lllllllllllllIIIIlllIllIIlIIIIll;
        this.resourcePackHash = lllllllllllllIIIIlllIllIIlIIIIlI;
    }
    
    public abstract boolean isCommandBlockEnabled();
    
    public void setCanSpawnAnimals(final boolean lllllllllllllIIIIlllIllIIIIIlllI) {
        this.canSpawnAnimals = lllllllllllllIIIIlllIllIIIIIlllI;
    }
    
    @Nullable
    public synchronized String getUserMessage() {
        return this.userMessage;
    }
    
    public ISaveFormat getActiveAnvilConverter() {
        return this.anvilConverterForAnvilFile;
    }
    
    public void startServerThread() {
        this.serverThread = new Thread(this, "Server thread");
        this.serverThread.start();
    }
    
    public void setDifficultyForAllWorlds(final EnumDifficulty lllllllllllllIIIIlllIllIIllIIlIl) {
        final float lllllllllllllIIIIlllIllIIllIIIIl;
        final char lllllllllllllIIIIlllIllIIllIIIlI = (char)((WorldServer[])(Object)(lllllllllllllIIIIlllIllIIllIIIIl = (float)(Object)this.worldServers)).length;
        for (final WorldServer lllllllllllllIIIIlllIllIIllIIlll : lllllllllllllIIIIlllIllIIllIIIIl) {
            if (lllllllllllllIIIIlllIllIIllIIlll != null) {
                if (lllllllllllllIIIIlllIllIIllIIlll.getWorldInfo().isHardcoreModeEnabled()) {
                    lllllllllllllIIIIlllIllIIllIIlll.getWorldInfo().setDifficulty(EnumDifficulty.HARD);
                    lllllllllllllIIIIlllIllIIllIIlll.setAllowedSpawnTypes(true, true);
                }
                else if (this.isSinglePlayer()) {
                    lllllllllllllIIIIlllIllIIllIIlll.getWorldInfo().setDifficulty(lllllllllllllIIIIlllIllIIllIIlIl);
                    lllllllllllllIIIIlllIllIIllIIlll.setAllowedSpawnTypes(lllllllllllllIIIIlllIllIIllIIlll.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                }
                else {
                    lllllllllllllIIIIlllIllIIllIIlll.getWorldInfo().setDifficulty(lllllllllllllIIIIlllIllIIllIIlIl);
                    lllllllllllllIIIIlllIllIIllIIlll.setAllowedSpawnTypes(this.allowSpawnMonsters(), this.canSpawnAnimals);
                }
            }
        }
    }
    
    public String getFolderName() {
        return this.folderName;
    }
    
    public String[] getAllUsernames() {
        return this.playerList.getAllUsernames();
    }
    
    public boolean serverIsInRunLoop() {
        return this.serverIsRunning;
    }
    
    public int getMaxPlayerIdleMinutes() {
        return this.maxPlayerIdleMinutes;
    }
    
    public void enableProfiling() {
        this.startProfiling = true;
    }
    
    public void setPlayerIdleTimeout(final int lllllllllllllIIIIlllIlIllIlIIIlI) {
        this.maxPlayerIdleMinutes = lllllllllllllIIIIlllIlIllIlIIIlI;
    }
    
    public boolean func_190518_ac() {
        return this.field_190519_A;
    }
    
    public KeyPair getKeyPair() {
        return this.serverKeyPair;
    }
    
    public void loadAllWorlds(final String lllllllllllllIIIIlllIlllllIIIIIl, final String lllllllllllllIIIIlllIlllllIIllIl, final long lllllllllllllIIIIlllIllllIllllll, final WorldType lllllllllllllIIIIlllIllllIlllllI, final String lllllllllllllIIIIlllIllllIllllIl) {
        this.convertMapIfNeeded(lllllllllllllIIIIlllIlllllIIIIIl);
        this.setUserMessage("menu.loadingLevel");
        this.worldServers = new WorldServer[3];
        this.timeOfLastDimensionTick = new long[this.worldServers.length][100];
        final ISaveHandler lllllllllllllIIIIlllIlllllIIlIIl = this.anvilConverterForAnvilFile.getSaveLoader(lllllllllllllIIIIlllIlllllIIIIIl, true);
        this.setResourcePackFromWorld(this.getFolderName(), lllllllllllllIIIIlllIlllllIIlIIl);
        WorldInfo lllllllllllllIIIIlllIlllllIIlIII = lllllllllllllIIIIlllIlllllIIlIIl.loadWorldInfo();
        WorldSettings lllllllllllllIIIIlllIlllllIIIlIl;
        if (lllllllllllllIIIIlllIlllllIIlIII == null) {
            WorldSettings lllllllllllllIIIIlllIlllllIIIllI = null;
            if (this.isDemo()) {
                final WorldSettings lllllllllllllIIIIlllIlllllIIIlll = WorldServerDemo.DEMO_WORLD_SETTINGS;
            }
            else {
                lllllllllllllIIIIlllIlllllIIIllI = new WorldSettings(lllllllllllllIIIIlllIllllIllllll, this.getGameType(), this.canStructuresSpawn(), this.isHardcore(), lllllllllllllIIIIlllIllllIlllllI);
                lllllllllllllIIIIlllIlllllIIIllI.setGeneratorOptions(lllllllllllllIIIIlllIllllIllllIl);
                if (this.enableBonusChest) {
                    lllllllllllllIIIIlllIlllllIIIllI.enableBonusChest();
                }
            }
            lllllllllllllIIIIlllIlllllIIlIII = new WorldInfo(lllllllllllllIIIIlllIlllllIIIllI, lllllllllllllIIIIlllIlllllIIllIl);
        }
        else {
            lllllllllllllIIIIlllIlllllIIlIII.setWorldName(lllllllllllllIIIIlllIlllllIIllIl);
            lllllllllllllIIIIlllIlllllIIIlIl = new WorldSettings(lllllllllllllIIIIlllIlllllIIlIII);
        }
        for (int lllllllllllllIIIIlllIlllllIIIlII = 0; lllllllllllllIIIIlllIlllllIIIlII < this.worldServers.length; ++lllllllllllllIIIIlllIlllllIIIlII) {
            int lllllllllllllIIIIlllIlllllIIIIll = 0;
            if (lllllllllllllIIIIlllIlllllIIIlII == 1) {
                lllllllllllllIIIIlllIlllllIIIIll = -1;
            }
            if (lllllllllllllIIIIlllIlllllIIIlII == 2) {
                lllllllllllllIIIIlllIlllllIIIIll = 1;
            }
            if (lllllllllllllIIIIlllIlllllIIIlII == 0) {
                if (this.isDemo()) {
                    this.worldServers[lllllllllllllIIIIlllIlllllIIIlII] = (WorldServer)new WorldServerDemo(this, lllllllllllllIIIIlllIlllllIIlIIl, lllllllllllllIIIIlllIlllllIIlIII, lllllllllllllIIIIlllIlllllIIIIll, this.theProfiler).init();
                }
                else {
                    this.worldServers[lllllllllllllIIIIlllIlllllIIIlII] = (WorldServer)new WorldServer(this, lllllllllllllIIIIlllIlllllIIlIIl, lllllllllllllIIIIlllIlllllIIlIII, lllllllllllllIIIIlllIlllllIIIIll, this.theProfiler).init();
                }
                this.worldServers[lllllllllllllIIIIlllIlllllIIIlII].initialize(lllllllllllllIIIIlllIlllllIIIlIl);
            }
            else {
                this.worldServers[lllllllllllllIIIIlllIlllllIIIlII] = (WorldServer)new WorldServerMulti(this, lllllllllllllIIIIlllIlllllIIlIIl, lllllllllllllIIIIlllIlllllIIIIll, this.worldServers[0], this.theProfiler).init();
            }
            this.worldServers[lllllllllllllIIIIlllIlllllIIIlII].addEventListener(new ServerWorldEventHandler(this, this.worldServers[lllllllllllllIIIIlllIlllllIIIlII]));
            if (!this.isSinglePlayer()) {
                this.worldServers[lllllllllllllIIIIlllIlllllIIIlII].getWorldInfo().setGameType(this.getGameType());
            }
        }
        this.playerList.setPlayerManager(this.worldServers);
        this.setDifficultyForAllWorlds(this.getDifficulty());
        this.initialWorldChunkLoad();
    }
    
    public void setKeyPair(final KeyPair lllllllllllllIIIIlllIllIIlllIIlI) {
        this.serverKeyPair = lllllllllllllIIIIlllIllIIlllIIlI;
    }
    
    public abstract boolean canStructuresSpawn();
    
    public ServerCommandManager createNewCommandManager() {
        return new ServerCommandManager(this);
    }
    
    public WorldServer worldServerForDimension(final int lllllllllllllIIIIlllIllIlllIIIlI) {
        if (lllllllllllllIIIIlllIllIlllIIIlI == -1) {
            return this.worldServers[1];
        }
        return (lllllllllllllIIIIlllIllIlllIIIlI == 1) ? this.worldServers[2] : this.worldServers[0];
    }
    
    public int getSpawnRadius(@Nullable final WorldServer lllllllllllllIIIIlllIlIlIlIllllI) {
        return (lllllllllllllIIIIlllIlIlIlIllllI != null) ? lllllllllllllIIIIlllIlIlIlIllllI.getGameRules().getInt("spawnRadius") : 10;
    }
    
    public int getNetworkCompressionThreshold() {
        return 256;
    }
    
    public boolean isWorldIconSet() {
        this.worldIconSet = (this.worldIconSet || this.getWorldIconFile().isFile());
        return this.worldIconSet;
    }
    
    public MinecraftSessionService getMinecraftSessionService() {
        return this.sessionService;
    }
    
    public void func_193031_aM() {
        if (this.isCallingFromMinecraftThread()) {
            this.getPlayerList().saveAllPlayerData();
            this.worldServers[0].getLootTableManager().reloadLootTables();
            this.func_191949_aK().func_192779_a();
            this.func_193030_aL().func_193059_f();
            this.getPlayerList().func_193244_w();
        }
        else {
            this.addScheduledTask(this::func_193031_aM);
        }
    }
    
    public void setWorldName(final String lllllllllllllIIIIlllIllIIllllIll) {
        this.worldName = lllllllllllllIIIIlllIllIIllllIll;
    }
    
    public void setResourcePackFromWorld(final String lllllllllllllIIIIlllIllllIIIIlIl, final ISaveHandler lllllllllllllIIIIlllIllllIIIIlII) {
        final File lllllllllllllIIIIlllIllllIIIlIII = new File(lllllllllllllIIIIlllIllllIIIIlII.getWorldDirectory(), "resources.zip");
        if (lllllllllllllIIIIlllIllllIIIlIII.isFile()) {
            try {
                this.setResourcePack(String.valueOf(new StringBuilder("level://").append(URLEncoder.encode(lllllllllllllIIIIlllIllllIIIIlIl, StandardCharsets.UTF_8.toString())).append("/").append("resources.zip")), "");
            }
            catch (UnsupportedEncodingException lllllllllllllIIIIlllIllllIIIIlll) {
                MinecraftServer.LOG.warn("Something went wrong url encoding {}", (Object)lllllllllllllIIIIlllIllllIIIIlIl);
            }
        }
    }
    
    public PlayerList getPlayerList() {
        return this.playerList;
    }
    
    public int getBuildLimit() {
        return this.buildLimit;
    }
    
    public boolean isAnvilFileSet() {
        return this.anvilFile != null;
    }
    
    public ServerStatusResponse getServerStatusResponse() {
        return this.statusResponse;
    }
    
    public String getResourcePackHash() {
        return this.resourcePackHash;
    }
    
    public FunctionManager func_193030_aL() {
        return this.worldServers[0].func_193037_A();
    }
    
    public <V> ListenableFuture<V> callFromMainThread(final Callable<V> lllllllllllllIIIIlllIlIlIlllIIlI) {
        Validate.notNull((Object)lllllllllllllIIIIlllIlIlIlllIIlI);
        if (!this.isCallingFromMinecraftThread() && !this.isServerStopped()) {
            final ListenableFutureTask<V> lllllllllllllIIIIlllIlIlIlllIIIl = (ListenableFutureTask<V>)ListenableFutureTask.create((Callable)lllllllllllllIIIIlllIlIlIlllIIlI);
            synchronized (this.futureTaskQueue) {
                this.futureTaskQueue.add((FutureTask<?>)lllllllllllllIIIIlllIlIlIlllIIIl);
                final ListenableFutureTask<V> listenableFutureTask = lllllllllllllIIIIlllIlIlIlllIIIl;
                // monitorexit(this.futureTaskQueue)
                return (ListenableFuture<V>)listenableFutureTask;
            }
        }
        try {
            return (ListenableFuture<V>)Futures.immediateFuture((Object)lllllllllllllIIIIlllIlIlIlllIIlI.call());
        }
        catch (Exception lllllllllllllIIIIlllIlIlIlllIIII) {
            return (ListenableFuture<V>)Futures.immediateFailedCheckedFuture(lllllllllllllIIIIlllIlIlIlllIIII);
        }
    }
    
    @Override
    public void addChatMessage(final ITextComponent lllllllllllllIIIIlllIllIlIIllllI) {
        MinecraftServer.LOG.info(lllllllllllllIIIIlllIllIlIIllllI.getUnformattedText());
    }
    
    public String getMinecraftVersion() {
        return "1.12.2";
    }
    
    protected void clearCurrentTask() {
        this.currentTask = null;
        this.percentDone = 0;
    }
    
    static {
        LOG = LogManager.getLogger();
        USER_CACHE_FILE = new File("usercache.json");
    }
    
    @Override
    public void run() {
        try {
            if (this.startServer()) {
                this.currentTime = getCurrentTimeMillis();
                long lllllllllllllIIIIlllIlllIlIIIlll = 0L;
                this.statusResponse.setServerDescription(new TextComponentString(this.motd));
                this.statusResponse.setVersion(new ServerStatusResponse.Version("1.12.2", 340));
                this.applyServerIconToResponse(this.statusResponse);
                while (this.serverRunning) {
                    final long lllllllllllllIIIIlllIlllIlIIIllI = getCurrentTimeMillis();
                    long lllllllllllllIIIIlllIlllIlIIIlIl = lllllllllllllIIIIlllIlllIlIIIllI - this.currentTime;
                    if (lllllllllllllIIIIlllIlllIlIIIlIl > 2000L && this.currentTime - this.timeOfLastWarning >= 15000L) {
                        MinecraftServer.LOG.warn("Can't keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", (Object)lllllllllllllIIIIlllIlllIlIIIlIl, (Object)(lllllllllllllIIIIlllIlllIlIIIlIl / 50L));
                        lllllllllllllIIIIlllIlllIlIIIlIl = 2000L;
                        this.timeOfLastWarning = this.currentTime;
                    }
                    if (lllllllllllllIIIIlllIlllIlIIIlIl < 0L) {
                        MinecraftServer.LOG.warn("Time ran backwards! Did the system time change?");
                        lllllllllllllIIIIlllIlllIlIIIlIl = 0L;
                    }
                    lllllllllllllIIIIlllIlllIlIIIlll += lllllllllllllIIIIlllIlllIlIIIlIl;
                    this.currentTime = lllllllllllllIIIIlllIlllIlIIIllI;
                    if (this.worldServers[0].areAllPlayersAsleep()) {
                        this.tick();
                        lllllllllllllIIIIlllIlllIlIIIlll = 0L;
                    }
                    else {
                        while (lllllllllllllIIIIlllIlllIlIIIlll > 50L) {
                            lllllllllllllIIIIlllIlllIlIIIlll -= 50L;
                            this.tick();
                        }
                    }
                    Thread.sleep(Math.max(1L, 50L - lllllllllllllIIIIlllIlllIlIIIlll));
                    this.serverIsRunning = true;
                }
            }
            else {
                this.finalTick(null);
            }
        }
        catch (Throwable lllllllllllllIIIIlllIlllIlIIIlII) {
            MinecraftServer.LOG.error("Encountered an unexpected exception", lllllllllllllIIIIlllIlllIlIIIlII);
            CrashReport lllllllllllllIIIIlllIlllIlIIIIll = null;
            if (lllllllllllllIIIIlllIlllIlIIIlII instanceof ReportedException) {
                lllllllllllllIIIIlllIlllIlIIIIll = this.addServerInfoToCrashReport(((ReportedException)lllllllllllllIIIIlllIlllIlIIIlII).getCrashReport());
            }
            else {
                lllllllllllllIIIIlllIlllIlIIIIll = this.addServerInfoToCrashReport(new CrashReport("Exception in server tick loop", lllllllllllllIIIIlllIlllIlIIIlII));
            }
            final File lllllllllllllIIIIlllIlllIlIIIIlI = new File(new File(this.getDataDirectory(), "crash-reports"), String.valueOf(new StringBuilder("crash-").append(new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date())).append("-server.txt")));
            if (lllllllllllllIIIIlllIlllIlIIIIll.saveToFile(lllllllllllllIIIIlllIlllIlIIIIlI)) {
                MinecraftServer.LOG.error("This crash report has been saved to: {}", (Object)lllllllllllllIIIIlllIlllIlIIIIlI.getAbsolutePath());
            }
            else {
                MinecraftServer.LOG.error("We were unable to save this crash report to disk.");
            }
            this.finalTick(lllllllllllllIIIIlllIlllIlIIIIll);
            return;
        }
        finally {
            Label_0503: {
                try {
                    this.serverStopped = true;
                    this.stopServer();
                }
                catch (Throwable lllllllllllllIIIIlllIlllIlIIIIII) {
                    MinecraftServer.LOG.error("Exception stopping the server", lllllllllllllIIIIlllIlllIlIIIIII);
                    this.systemExitNow();
                    break Label_0503;
                }
                finally {
                    this.systemExitNow();
                }
                this.systemExitNow();
            }
        }
        try {
            this.serverStopped = true;
            this.stopServer();
        }
        catch (Throwable lllllllllllllIIIIlllIlllIIllllll) {
            MinecraftServer.LOG.error("Exception stopping the server", lllllllllllllIIIIlllIlllIIllllll);
            return;
        }
        finally {
            this.systemExitNow();
        }
        this.systemExitNow();
    }
    
    public void applyServerIconToResponse(final ServerStatusResponse lllllllllllllIIIIlllIlllIIlIIlll) {
        File lllllllllllllIIIIlllIlllIIlIllIl = this.getFile("server-icon.png");
        if (!lllllllllllllIIIIlllIlllIIlIllIl.exists()) {
            lllllllllllllIIIIlllIlllIIlIllIl = this.getActiveAnvilConverter().getFile(this.getFolderName(), "icon.png");
        }
        if (lllllllllllllIIIIlllIlllIIlIllIl.isFile()) {
            final ByteBuf lllllllllllllIIIIlllIlllIIlIllII = Unpooled.buffer();
            try {
                final BufferedImage lllllllllllllIIIIlllIlllIIlIlIll = ImageIO.read(lllllllllllllIIIIlllIlllIIlIllIl);
                Validate.validState(lllllllllllllIIIIlllIlllIIlIlIll.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
                Validate.validState(lllllllllllllIIIIlllIlllIIlIlIll.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
                ImageIO.write(lllllllllllllIIIIlllIlllIIlIlIll, "PNG", (OutputStream)new ByteBufOutputStream(lllllllllllllIIIIlllIlllIIlIllII));
                final ByteBuf lllllllllllllIIIIlllIlllIIlIlIlI = Base64.encode(lllllllllllllIIIIlllIlllIIlIllII);
                lllllllllllllIIIIlllIlllIIlIIlll.setFavicon(String.valueOf(new StringBuilder("data:image/png;base64,").append(lllllllllllllIIIIlllIlllIIlIlIlI.toString(StandardCharsets.UTF_8))));
            }
            catch (Exception lllllllllllllIIIIlllIlllIIlIlIIl) {
                MinecraftServer.LOG.error("Couldn't load server icon", (Throwable)lllllllllllllIIIIlllIlllIIlIlIIl);
                return;
            }
            finally {
                lllllllllllllIIIIlllIlllIIlIllII.release();
            }
            lllllllllllllIIIIlllIlllIIlIllII.release();
        }
    }
    
    public NetworkSystem getNetworkSystem() {
        return this.networkSystem;
    }
    
    public void setCanSpawnNPCs(final boolean lllllllllllllIIIIlllIllIIIIIIlIl) {
        this.canSpawnNPCs = lllllllllllllIIIIlllIllIIIIIIlIl;
    }
    
    public File getWorldIconFile() {
        return this.getActiveAnvilConverter().getFile(this.getFolderName(), "icon.png");
    }
    
    public boolean allowSpawnMonsters() {
        return true;
    }
    
    public int getMaxWorldSize() {
        return 29999984;
    }
    
    public void stopServer() {
        MinecraftServer.LOG.info("Stopping server");
        if (this.getNetworkSystem() != null) {
            this.getNetworkSystem().terminateEndpoints();
        }
        if (this.playerList != null) {
            MinecraftServer.LOG.info("Saving players");
            this.playerList.saveAllPlayerData();
            this.playerList.removeAllPlayers();
        }
        if (this.worldServers != null) {
            MinecraftServer.LOG.info("Saving worlds");
            byte lllllllllllllIIIIlllIlllIlIlIlll;
            short lllllllllllllIIIIlllIlllIlIllIII = (short)((WorldServer[])(Object)(lllllllllllllIIIIlllIlllIlIlIlll = (byte)(Object)this.worldServers)).length;
            for (float lllllllllllllIIIIlllIlllIlIllIIl = 0; lllllllllllllIIIIlllIlllIlIllIIl < lllllllllllllIIIIlllIlllIlIllIII; ++lllllllllllllIIIIlllIlllIlIllIIl) {
                final WorldServer lllllllllllllIIIIlllIlllIlIlllIl = lllllllllllllIIIIlllIlllIlIlIlll[lllllllllllllIIIIlllIlllIlIllIIl];
                if (lllllllllllllIIIIlllIlllIlIlllIl != null) {
                    lllllllllllllIIIIlllIlllIlIlllIl.disableLevelSaving = false;
                }
            }
            this.saveAllWorlds(false);
            lllllllllllllIIIIlllIlllIlIllIII = (short)((WorldServer[])(Object)(lllllllllllllIIIIlllIlllIlIlIlll = (byte)(Object)this.worldServers)).length;
            for (float lllllllllllllIIIIlllIlllIlIllIIl = 0; lllllllllllllIIIIlllIlllIlIllIIl < lllllllllllllIIIIlllIlllIlIllIII; ++lllllllllllllIIIIlllIlllIlIllIIl) {
                final WorldServer lllllllllllllIIIIlllIlllIlIlllII = lllllllllllllIIIIlllIlllIlIlIlll[lllllllllllllIIIIlllIlllIlIllIIl];
                if (lllllllllllllIIIIlllIlllIlIlllII != null) {
                    lllllllllllllIIIIlllIlllIlIlllII.flush();
                }
            }
        }
        if (this.usageSnooper.isSnooperRunning()) {
            this.usageSnooper.stopSnooper();
        }
    }
    
    public GameProfile[] getGameProfiles() {
        return this.playerList.getAllProfiles();
    }
    
    public boolean isFlightAllowed() {
        return this.allowFlight;
    }
    
    public GameProfileRepository getGameProfileRepository() {
        return this.profileRepo;
    }
    
    public void saveAllWorlds(final boolean lllllllllllllIIIIlllIlllIllIlIIl) {
        final double lllllllllllllIIIIlllIlllIllIIlIl;
        final float lllllllllllllIIIIlllIlllIllIIllI = ((WorldServer[])(Object)(lllllllllllllIIIIlllIlllIllIIlIl = (double)(Object)this.worldServers)).length;
        for (boolean lllllllllllllIIIIlllIlllIllIIlll = false; (lllllllllllllIIIIlllIlllIllIIlll ? 1 : 0) < lllllllllllllIIIIlllIlllIllIIllI; ++lllllllllllllIIIIlllIlllIllIIlll) {
            final WorldServer lllllllllllllIIIIlllIlllIllIllII = lllllllllllllIIIIlllIlllIllIIlIl[lllllllllllllIIIIlllIlllIllIIlll];
            if (lllllllllllllIIIIlllIlllIllIllII != null) {
                if (!lllllllllllllIIIIlllIlllIllIlIIl) {
                    MinecraftServer.LOG.info("Saving chunks for level '{}'/{}", (Object)lllllllllllllIIIIlllIlllIllIllII.getWorldInfo().getWorldName(), (Object)lllllllllllllIIIIlllIlllIllIllII.provider.getDimensionType().getName());
                }
                try {
                    lllllllllllllIIIIlllIlllIllIllII.saveAllChunks(true, null);
                }
                catch (MinecraftException lllllllllllllIIIIlllIlllIllIlIll) {
                    MinecraftServer.LOG.warn(lllllllllllllIIIIlllIlllIllIlIll.getMessage());
                }
            }
        }
    }
    
    public String getServerOwner() {
        return this.serverOwner;
    }
    
    @Override
    public void addServerStatsToSnooper(final Snooper lllllllllllllIIIIlllIllIIIllIIII) {
        lllllllllllllIIIIlllIllIIIllIIII.addClientStat("whitelist_enabled", false);
        lllllllllllllIIIIlllIllIIIllIIII.addClientStat("whitelist_count", 0);
        if (this.playerList != null) {
            lllllllllllllIIIIlllIllIIIllIIII.addClientStat("players_current", this.getCurrentPlayerCount());
            lllllllllllllIIIIlllIllIIIllIIII.addClientStat("players_max", this.getMaxPlayers());
            lllllllllllllIIIIlllIllIIIllIIII.addClientStat("players_seen", this.playerList.getAvailablePlayerDat().length);
        }
        lllllllllllllIIIIlllIllIIIllIIII.addClientStat("uses_auth", this.onlineMode);
        lllllllllllllIIIIlllIllIIIllIIII.addClientStat("gui_state", this.getGuiEnabled() ? "enabled" : "disabled");
        lllllllllllllIIIIlllIllIIIllIIII.addClientStat("run_time", (getCurrentTimeMillis() - lllllllllllllIIIIlllIllIIIllIIII.getMinecraftStartTimeMillis()) / 60L * 1000L);
        lllllllllllllIIIIlllIllIIIllIIII.addClientStat("avg_tick_ms", (int)(MathHelper.average(this.tickTimeArray) * 1.0E-6));
        int lllllllllllllIIIIlllIllIIIllIlII = 0;
        if (this.worldServers != null) {
            final String lllllllllllllIIIIlllIllIIIlIlIll;
            final byte lllllllllllllIIIIlllIllIIIlIllII = (byte)((WorldServer[])(Object)(lllllllllllllIIIIlllIllIIIlIlIll = (String)(Object)this.worldServers)).length;
            for (short lllllllllllllIIIIlllIllIIIlIllIl = 0; lllllllllllllIIIIlllIllIIIlIllIl < lllllllllllllIIIIlllIllIIIlIllII; ++lllllllllllllIIIIlllIllIIIlIllIl) {
                final WorldServer lllllllllllllIIIIlllIllIIIllIIll = lllllllllllllIIIIlllIllIIIlIlIll[lllllllllllllIIIIlllIllIIIlIllIl];
                if (lllllllllllllIIIIlllIllIIIllIIll != null) {
                    final WorldInfo lllllllllllllIIIIlllIllIIIllIIlI = lllllllllllllIIIIlllIllIIIllIIll.getWorldInfo();
                    lllllllllllllIIIIlllIllIIIllIIII.addClientStat(String.valueOf(new StringBuilder("world[").append(lllllllllllllIIIIlllIllIIIllIlII).append("][dimension]")), lllllllllllllIIIIlllIllIIIllIIll.provider.getDimensionType().getId());
                    lllllllllllllIIIIlllIllIIIllIIII.addClientStat(String.valueOf(new StringBuilder("world[").append(lllllllllllllIIIIlllIllIIIllIlII).append("][mode]")), lllllllllllllIIIIlllIllIIIllIIlI.getGameType());
                    lllllllllllllIIIIlllIllIIIllIIII.addClientStat(String.valueOf(new StringBuilder("world[").append(lllllllllllllIIIIlllIllIIIllIlII).append("][difficulty]")), lllllllllllllIIIIlllIllIIIllIIll.getDifficulty());
                    lllllllllllllIIIIlllIllIIIllIIII.addClientStat(String.valueOf(new StringBuilder("world[").append(lllllllllllllIIIIlllIllIIIllIlII).append("][hardcore]")), lllllllllllllIIIIlllIllIIIllIIlI.isHardcoreModeEnabled());
                    lllllllllllllIIIIlllIllIIIllIIII.addClientStat(String.valueOf(new StringBuilder("world[").append(lllllllllllllIIIIlllIllIIIllIlII).append("][generator_name]")), lllllllllllllIIIIlllIllIIIllIIlI.getTerrainType().getWorldTypeName());
                    lllllllllllllIIIIlllIllIIIllIIII.addClientStat(String.valueOf(new StringBuilder("world[").append(lllllllllllllIIIIlllIllIIIllIlII).append("][generator_version]")), lllllllllllllIIIIlllIllIIIllIIlI.getTerrainType().getGeneratorVersion());
                    lllllllllllllIIIIlllIllIIIllIIII.addClientStat(String.valueOf(new StringBuilder("world[").append(lllllllllllllIIIIlllIllIIIllIlII).append("][height]")), this.buildLimit);
                    lllllllllllllIIIIlllIllIIIllIIII.addClientStat(String.valueOf(new StringBuilder("world[").append(lllllllllllllIIIIlllIllIIIllIlII).append("][chunks_loaded]")), lllllllllllllIIIIlllIllIIIllIIll.getChunkProvider().getLoadedChunkCount());
                    ++lllllllllllllIIIIlllIllIIIllIlII;
                }
            }
        }
        lllllllllllllIIIIlllIllIIIllIIII.addClientStat("worlds", lllllllllllllIIIIlllIllIIIllIlII);
    }
    
    public abstract EnumDifficulty getDifficulty();
    
    public Proxy getServerProxy() {
        return this.serverProxy;
    }
    
    public void refreshStatusNextTick() {
        this.nanoTimeSinceStatusRefresh = 0L;
    }
    
    public void setPlayerList(final PlayerList lllllllllllllIIIIlllIlIlllIlIlIl) {
        this.playerList = lllllllllllllIIIIlllIlIlllIlIlIl;
    }
    
    @Override
    public MinecraftServer getServer() {
        return this;
    }
    
    public abstract boolean shouldBroadcastConsoleToOps();
    
    @Override
    public boolean sendCommandFeedback() {
        return this.worldServers[0].getGameRules().getBoolean("sendCommandFeedback");
    }
    
    public String getResourcePackUrl() {
        return this.resourcePackUrl;
    }
    
    public PlayerProfileCache getPlayerProfileCache() {
        return this.profileCache;
    }
    
    public Snooper getPlayerUsageSnooper() {
        return this.usageSnooper;
    }
    
    public void setOnlineMode(final boolean lllllllllllllIIIIlllIllIIIIlllII) {
        this.onlineMode = lllllllllllllIIIIlllIllIIIIlllII;
    }
    
    public void setAllowPvp(final boolean lllllllllllllIIIIlllIlIllllllllI) {
        this.pvpEnabled = lllllllllllllIIIIlllIlIllllllllI;
    }
    
    public void setAllowFlight(final boolean lllllllllllllIIIIlllIlIlllllIIll) {
        this.allowFlight = lllllllllllllIIIIlllIlIlllllIIll;
    }
    
    public boolean getCanSpawnNPCs() {
        return this.canSpawnNPCs;
    }
    
    public void tick() {
        final long lllllllllllllIIIIlllIlllIIIlIIIl = System.nanoTime();
        ++this.tickCounter;
        if (this.startProfiling) {
            this.startProfiling = false;
            this.theProfiler.profilingEnabled = true;
            this.theProfiler.clearProfiling();
        }
        this.theProfiler.startSection("root");
        this.updateTimeLightAndEntities();
        if (lllllllllllllIIIIlllIlllIIIlIIIl - this.nanoTimeSinceStatusRefresh >= 5000000000L) {
            this.nanoTimeSinceStatusRefresh = lllllllllllllIIIIlllIlllIIIlIIIl;
            this.statusResponse.setPlayers(new ServerStatusResponse.Players(this.getMaxPlayers(), this.getCurrentPlayerCount()));
            final GameProfile[] lllllllllllllIIIIlllIlllIIIlIIII = new GameProfile[Math.min(this.getCurrentPlayerCount(), 12)];
            final int lllllllllllllIIIIlllIlllIIIIllll = MathHelper.getInt(this.random, 0, this.getCurrentPlayerCount() - lllllllllllllIIIIlllIlllIIIlIIII.length);
            for (int lllllllllllllIIIIlllIlllIIIIlllI = 0; lllllllllllllIIIIlllIlllIIIIlllI < lllllllllllllIIIIlllIlllIIIlIIII.length; ++lllllllllllllIIIIlllIlllIIIIlllI) {
                lllllllllllllIIIIlllIlllIIIlIIII[lllllllllllllIIIIlllIlllIIIIlllI] = this.playerList.getPlayerList().get(lllllllllllllIIIIlllIlllIIIIllll + lllllllllllllIIIIlllIlllIIIIlllI).getGameProfile();
            }
            Collections.shuffle(Arrays.asList(lllllllllllllIIIIlllIlllIIIlIIII));
            this.statusResponse.getPlayers().setPlayers(lllllllllllllIIIIlllIlllIIIlIIII);
        }
        if (this.tickCounter % 900 == 0) {
            this.theProfiler.startSection("save");
            this.playerList.saveAllPlayerData();
            this.saveAllWorlds(true);
            this.theProfiler.endSection();
        }
        this.theProfiler.startSection("tallying");
        this.tickTimeArray[this.tickCounter % 100] = System.nanoTime() - lllllllllllllIIIIlllIlllIIIlIIIl;
        this.theProfiler.endSection();
        this.theProfiler.startSection("snooper");
        if (!this.usageSnooper.isSnooperRunning() && this.tickCounter > 100) {
            this.usageSnooper.startSnooper();
        }
        if (this.tickCounter % 6000 == 0) {
            this.usageSnooper.addMemoryStatsToSnooper();
        }
        this.theProfiler.endSection();
        this.theProfiler.endSection();
    }
    
    public CrashReport addServerInfoToCrashReport(final CrashReport lllllllllllllIIIIlllIllIllIIllII) {
        lllllllllllllIIIIlllIllIllIIllII.getCategory().setDetail("Profiler Position", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return MinecraftServer.this.theProfiler.profilingEnabled ? MinecraftServer.this.theProfiler.getNameOfLastSection() : "N/A (disabled)";
            }
        });
        if (this.playerList != null) {
            lllllllllllllIIIIlllIllIllIIllII.getCategory().setDetail("Player Count", new ICrashReportDetail<String>() {
                @Override
                public String call() {
                    return String.valueOf(new StringBuilder(String.valueOf(MinecraftServer.this.playerList.getCurrentPlayerCount())).append(" / ").append(MinecraftServer.this.playerList.getMaxPlayers()).append("; ").append(MinecraftServer.this.playerList.getPlayerList()));
                }
            });
        }
        return lllllllllllllIIIIlllIllIllIIllII;
    }
    
    public abstract boolean shouldUseNativeTransport();
    
    public void setFolderName(final String lllllllllllllIIIIlllIllIIlllllll) {
        this.folderName = lllllllllllllIIIIlllIllIIlllllll;
    }
    
    public boolean isServerInOnlineMode() {
        return this.onlineMode;
    }
    
    public boolean isBlockProtected(final World lllllllllllllIIIIlllIlIllIllIIIl, final BlockPos lllllllllllllIIIIlllIlIllIllIIII, final EntityPlayer lllllllllllllIIIIlllIlIllIlIllll) {
        return false;
    }
    
    public boolean isDemo() {
        return this.isDemo;
    }
    
    public void convertMapIfNeeded(final String lllllllllllllIIIIlllIllllllIIlII) {
        if (this.getActiveAnvilConverter().isOldMapFormat(lllllllllllllIIIIlllIllllllIIlII)) {
            MinecraftServer.LOG.info("Converting map!");
            this.setUserMessage("menu.convertingLevel");
            this.getActiveAnvilConverter().convertMapFormat(lllllllllllllIIIIlllIllllllIIlII, new IProgressUpdate() {
                private /* synthetic */ long startTime = System.currentTimeMillis();
                
                @Override
                public void displayLoadingString(final String lllllllllllllIlIlIIIllIlIlIlllII) {
                }
                
                @Override
                public void setLoadingProgress(final int lllllllllllllIlIlIIIllIlIllIIIIl) {
                    if (System.currentTimeMillis() - this.startTime >= 1000L) {
                        this.startTime = System.currentTimeMillis();
                        MinecraftServer.LOG.info("Converting... {}%", (Object)lllllllllllllIlIlIIIllIlIllIIIIl);
                    }
                }
                
                @Override
                public void resetProgressAndMessage(final String lllllllllllllIlIlIIIllIlIllIIlIl) {
                }
                
                @Override
                public void setDoneWorking() {
                }
                
                @Override
                public void displaySavingString(final String lllllllllllllIlIlIIIllIlIllIIlll) {
                }
            });
        }
    }
    
    @Override
    public void addServerTypeToSnooper(final Snooper lllllllllllllIIIIlllIllIIIlIIlII) {
        lllllllllllllIIIIlllIllIIIlIIlII.addStatToSnooper("singleplayer", this.isSinglePlayer());
        lllllllllllllIIIIlllIllIIIlIIlII.addStatToSnooper("server_brand", this.getServerModName());
        lllllllllllllIIIIlllIllIIIlIIlII.addStatToSnooper("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        lllllllllllllIIIIlllIllIIIlIIlII.addStatToSnooper("dedicated", this.isDedicatedServer());
    }
    
    public List<String> getTabCompletions(final ICommandSender lllllllllllllIIIIlllIllIlIllllIl, String lllllllllllllIIIIlllIllIlIlIllll, @Nullable final BlockPos lllllllllllllIIIIlllIllIlIlllIll, final boolean lllllllllllllIIIIlllIllIlIlIllIl) {
        final List<String> lllllllllllllIIIIlllIllIlIlllIIl = (List<String>)Lists.newArrayList();
        final boolean lllllllllllllIIIIlllIllIlIlllIII = lllllllllllllIIIIlllIllIlIlIllll.startsWith("/");
        if (lllllllllllllIIIIlllIllIlIlllIII) {
            lllllllllllllIIIIlllIllIlIlIllll = lllllllllllllIIIIlllIllIlIlIllll.substring(1);
        }
        if (!lllllllllllllIIIIlllIllIlIlllIII && !lllllllllllllIIIIlllIllIlIlIllIl) {
            final String[] lllllllllllllIIIIlllIllIlIllIlll = lllllllllllllIIIIlllIllIlIlIllll.split(" ", -1);
            final String lllllllllllllIIIIlllIllIlIllIllI = lllllllllllllIIIIlllIllIlIllIlll[lllllllllllllIIIIlllIllIlIllIlll.length - 1];
            final float lllllllllllllIIIIlllIllIlIlIIlIl;
            final String lllllllllllllIIIIlllIllIlIlIIllI = (String)((String[])(Object)(lllllllllllllIIIIlllIllIlIlIIlIl = (float)(Object)this.playerList.getAllUsernames())).length;
            for (byte lllllllllllllIIIIlllIllIlIlIIlll = 0; lllllllllllllIIIIlllIllIlIlIIlll < lllllllllllllIIIIlllIllIlIlIIllI; ++lllllllllllllIIIIlllIllIlIlIIlll) {
                final String lllllllllllllIIIIlllIllIlIllIlIl = lllllllllllllIIIIlllIllIlIlIIlIl[lllllllllllllIIIIlllIllIlIlIIlll];
                if (CommandBase.doesStringStartWith(lllllllllllllIIIIlllIllIlIllIllI, lllllllllllllIIIIlllIllIlIllIlIl)) {
                    lllllllllllllIIIIlllIllIlIlllIIl.add(lllllllllllllIIIIlllIllIlIllIlIl);
                }
            }
            return lllllllllllllIIIIlllIllIlIlllIIl;
        }
        final boolean lllllllllllllIIIIlllIllIlIllIlII = !lllllllllllllIIIIlllIllIlIlIllll.contains(" ");
        final List<String> lllllllllllllIIIIlllIllIlIllIIll = this.commandManager.getTabCompletionOptions(lllllllllllllIIIIlllIllIlIllllIl, lllllllllllllIIIIlllIllIlIlIllll, lllllllllllllIIIIlllIllIlIlllIll);
        if (!lllllllllllllIIIIlllIllIlIllIIll.isEmpty()) {
            for (final String lllllllllllllIIIIlllIllIlIllIIlI : lllllllllllllIIIIlllIllIlIllIIll) {
                if (lllllllllllllIIIIlllIllIlIllIlII && !lllllllllllllIIIIlllIllIlIlIllIl) {
                    lllllllllllllIIIIlllIllIlIlllIIl.add(String.valueOf(new StringBuilder("/").append(lllllllllllllIIIIlllIllIlIllIIlI)));
                }
                else {
                    lllllllllllllIIIIlllIllIlIlllIIl.add(lllllllllllllIIIIlllIllIlIllIIlI);
                }
            }
        }
        return lllllllllllllIIIIlllIllIlIlllIIl;
    }
    
    public boolean getAllowNether() {
        return true;
    }
    
    public int getCurrentPlayerCount() {
        return this.playerList.getCurrentPlayerCount();
    }
    
    protected synchronized void setUserMessage(final String lllllllllllllIIIIlllIllllllIIIII) {
        this.userMessage = lllllllllllllIIIIlllIllllllIIIII;
    }
    
    public abstract boolean shouldBroadcastRconToOps();
    
    @Override
    public ListenableFuture<Object> addScheduledTask(final Runnable lllllllllllllIIIIlllIlIlIllIIllI) {
        Validate.notNull((Object)lllllllllllllIIIIlllIlIlIllIIllI);
        return this.callFromMainThread(Executors.callable(lllllllllllllIIIIlllIlIlIllIIllI));
    }
    
    public void finalTick(final CrashReport lllllllllllllIIIIlllIlllIIIllIIl) {
    }
    
    public File getDataDirectory() {
        return new File(".");
    }
    
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
    
    @Override
    public String getName() {
        return "Server";
    }
    
    public boolean getForceGamemode() {
        return this.isGamemodeForced;
    }
    
    @Override
    public World getEntityWorld() {
        return this.worldServers[0];
    }
    
    public abstract String shareToLAN(final GameType p0, final boolean p1);
    
    @Override
    public boolean isCallingFromMinecraftThread() {
        return Thread.currentThread() == this.serverThread;
    }
    
    public void canCreateBonusChest(final boolean lllllllllllllIIIIlllIllIIlIlIIll) {
        this.enableBonusChest = lllllllllllllIIIIlllIllIIlIlIIll;
    }
    
    public boolean getGuiEnabled() {
        return false;
    }
    
    public String getServerModName() {
        return "vanilla";
    }
    
    public boolean isServerStopped() {
        return this.serverStopped;
    }
    
    public MinecraftServer(final File lllllllllllllIIIIlllIlllllllIIll, final Proxy lllllllllllllIIIIlllIllllllllIlI, final DataFixer lllllllllllllIIIIlllIlllllllIIIl, final YggdrasilAuthenticationService lllllllllllllIIIIlllIllllllllIII, final MinecraftSessionService lllllllllllllIIIIlllIllllllIllll, final GameProfileRepository lllllllllllllIIIIlllIllllllIlllI, final PlayerProfileCache lllllllllllllIIIIlllIllllllIllIl) {
        this.usageSnooper = new Snooper("server", this, getCurrentTimeMillis());
        this.tickables = (List<ITickable>)Lists.newArrayList();
        this.theProfiler = new Profiler();
        this.statusResponse = new ServerStatusResponse();
        this.random = new Random();
        this.serverPort = -1;
        this.serverRunning = true;
        this.tickTimeArray = new long[100];
        this.resourcePackUrl = "";
        this.resourcePackHash = "";
        this.futureTaskQueue = (Queue<FutureTask<?>>)Queues.newArrayDeque();
        this.currentTime = getCurrentTimeMillis();
        this.serverProxy = lllllllllllllIIIIlllIllllllllIlI;
        this.authService = lllllllllllllIIIIlllIllllllllIII;
        this.sessionService = lllllllllllllIIIIlllIllllllIllll;
        this.profileRepo = lllllllllllllIIIIlllIllllllIlllI;
        this.profileCache = lllllllllllllIIIIlllIllllllIllIl;
        this.anvilFile = lllllllllllllIIIIlllIlllllllIIll;
        this.networkSystem = new NetworkSystem(this);
        this.commandManager = this.createNewCommandManager();
        this.anvilConverterForAnvilFile = new AnvilSaveConverter(lllllllllllllIIIIlllIlllllllIIll, lllllllllllllIIIIlllIlllllllIIIl);
        this.dataFixer = lllllllllllllIIIIlllIlllllllIIIl;
    }
    
    public void setServerOwner(final String lllllllllllllIIIIlllIllIlIIIllIl) {
        this.serverOwner = lllllllllllllIIIIlllIllIlIIIllIl;
    }
    
    @Override
    public boolean isSnooperEnabled() {
        return true;
    }
    
    public String getWorldName() {
        return this.worldName;
    }
    
    public int getTickCounter() {
        return this.tickCounter;
    }
    
    public void systemExitNow() {
    }
    
    public boolean isPVPEnabled() {
        return this.pvpEnabled;
    }
    
    public void setGameType(final GameType lllllllllllllIIIIlllIlIlllIIlIlI) {
        final String lllllllllllllIIIIlllIlIlllIIIllI;
        final Exception lllllllllllllIIIIlllIlIlllIIIlll = (Exception)((WorldServer[])(Object)(lllllllllllllIIIIlllIlIlllIIIllI = (String)(Object)this.worldServers)).length;
        for (byte lllllllllllllIIIIlllIlIlllIIlIII = 0; lllllllllllllIIIIlllIlIlllIIlIII < lllllllllllllIIIIlllIlIlllIIIlll; ++lllllllllllllIIIIlllIlIlllIIlIII) {
            final WorldServer lllllllllllllIIIIlllIlIlllIIllII = lllllllllllllIIIIlllIlIlllIIIllI[lllllllllllllIIIIlllIlIlllIIlIII];
            lllllllllllllIIIIlllIlIlllIIllII.getWorldInfo().setGameType(lllllllllllllIIIIlllIlIlllIIlIlI);
        }
    }
    
    public abstract int getOpPermissionLevel();
    
    public void setDemo(final boolean lllllllllllllIIIIlllIllIIlIlIlll) {
        this.isDemo = lllllllllllllIIIIlllIllIIlIlIlll;
    }
    
    public abstract boolean isHardcore();
    
    public abstract boolean isDedicatedServer();
    
    public boolean isSinglePlayer() {
        return this.serverOwner != null;
    }
    
    public abstract boolean startServer() throws IOException;
    
    public int getMaxPlayers() {
        return this.playerList.getMaxPlayers();
    }
    
    public boolean getCanSpawnAnimals() {
        return this.canSpawnAnimals;
    }
    
    public void updateTimeLightAndEntities() {
        this.theProfiler.startSection("jobs");
        synchronized (this.futureTaskQueue) {
            while (!this.futureTaskQueue.isEmpty()) {
                Util.runTask(this.futureTaskQueue.poll(), MinecraftServer.LOG);
            }
        }
        // monitorexit(this.futureTaskQueue)
        this.theProfiler.endStartSection("levels");
        for (int lllllllllllllIIIIlllIlllIIIIIIIl = 0; lllllllllllllIIIIlllIlllIIIIIIIl < this.worldServers.length; ++lllllllllllllIIIIlllIlllIIIIIIIl) {
            final long lllllllllllllIIIIlllIlllIIIIIIII = System.nanoTime();
            if (lllllllllllllIIIIlllIlllIIIIIIIl == 0 || this.getAllowNether()) {
                final WorldServer lllllllllllllIIIIlllIllIllllllll = this.worldServers[lllllllllllllIIIIlllIlllIIIIIIIl];
                this.theProfiler.func_194340_a(() -> lllllllllllllIIIIlllIllIllllllll.getWorldInfo().getWorldName());
                if (this.tickCounter % 20 == 0) {
                    this.theProfiler.startSection("timeSync");
                    this.playerList.sendPacketToAllPlayersInDimension(new SPacketTimeUpdate(lllllllllllllIIIIlllIllIllllllll.getTotalWorldTime(), lllllllllllllIIIIlllIllIllllllll.getWorldTime(), lllllllllllllIIIIlllIllIllllllll.getGameRules().getBoolean("doDaylightCycle")), lllllllllllllIIIIlllIllIllllllll.provider.getDimensionType().getId());
                    this.theProfiler.endSection();
                }
                this.theProfiler.startSection("tick");
                try {
                    lllllllllllllIIIIlllIllIllllllll.tick();
                }
                catch (Throwable lllllllllllllIIIIlllIllIlllllllI) {
                    final CrashReport lllllllllllllIIIIlllIllIllllllIl = CrashReport.makeCrashReport(lllllllllllllIIIIlllIllIlllllllI, "Exception ticking world");
                    lllllllllllllIIIIlllIllIllllllll.addWorldInfoToCrashReport(lllllllllllllIIIIlllIllIllllllIl);
                    throw new ReportedException(lllllllllllllIIIIlllIllIllllllIl);
                }
                try {
                    lllllllllllllIIIIlllIllIllllllll.updateEntities();
                }
                catch (Throwable lllllllllllllIIIIlllIllIllllllII) {
                    final CrashReport lllllllllllllIIIIlllIllIlllllIll = CrashReport.makeCrashReport(lllllllllllllIIIIlllIllIllllllII, "Exception ticking world entities");
                    lllllllllllllIIIIlllIllIllllllll.addWorldInfoToCrashReport(lllllllllllllIIIIlllIllIlllllIll);
                    throw new ReportedException(lllllllllllllIIIIlllIllIlllllIll);
                }
                this.theProfiler.endSection();
                this.theProfiler.startSection("tracker");
                lllllllllllllIIIIlllIllIllllllll.getEntityTracker().updateTrackedEntities();
                this.theProfiler.endSection();
                this.theProfiler.endSection();
            }
            this.timeOfLastDimensionTick[lllllllllllllIIIIlllIlllIIIIIIIl][this.tickCounter % 100] = System.nanoTime() - lllllllllllllIIIIlllIlllIIIIIIII;
        }
        this.theProfiler.endStartSection("connection");
        this.getNetworkSystem().networkTick();
        this.theProfiler.endStartSection("players");
        this.playerList.onTick();
        this.theProfiler.endStartSection("commandFunctions");
        this.func_193030_aL().update();
        this.theProfiler.endStartSection("tickables");
        for (int lllllllllllllIIIIlllIllIlllllIlI = 0; lllllllllllllIIIIlllIllIlllllIlI < this.tickables.size(); ++lllllllllllllIIIIlllIllIlllllIlI) {
            this.tickables.get(lllllllllllllIIIIlllIllIlllllIlI).update();
        }
        this.theProfiler.endSection();
    }
    
    public AdvancementManager func_191949_aK() {
        return this.worldServers[0].func_191952_z();
    }
    
    protected void outputPercentRemaining(final String lllllllllllllIIIIlllIlllIllllIlI, final int lllllllllllllIIIIlllIlllIllllIIl) {
        this.currentTask = lllllllllllllIIIIlllIlllIllllIlI;
        this.percentDone = lllllllllllllIIIIlllIlllIllllIIl;
        MinecraftServer.LOG.info("{}: {}%", (Object)lllllllllllllIIIIlllIlllIllllIlI, (Object)lllllllllllllIIIIlllIlllIllllIIl);
    }
    
    public File getFile(final String lllllllllllllIIIIlllIllIlllIlIlI) {
        return new File(this.getDataDirectory(), lllllllllllllIIIIlllIllIlllIlIlI);
    }
    
    public abstract GameType getGameType();
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllllIIIIlllIllIlIIllIll, final String lllllllllllllIIIIlllIllIlIIllIlI) {
        return true;
    }
}
