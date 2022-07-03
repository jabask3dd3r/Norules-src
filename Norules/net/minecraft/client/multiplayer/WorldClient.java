package net.minecraft.client.multiplayer;

import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.network.*;
import net.minecraft.util.text.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.audio.*;
import net.minecraft.crash.*;
import java.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.nbt.*;
import net.minecraft.client.particle.*;
import net.minecraft.profiler.*;
import com.google.common.collect.*;
import net.minecraft.world.storage.*;
import optifine.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.client.entity.*;

public class WorldClient extends World
{
    private /* synthetic */ ChunkProviderClient clientChunkProvider;
    private /* synthetic */ int ambienceTicks;
    private final /* synthetic */ Set<Entity> entitySpawnQueue;
    private final /* synthetic */ Set<Entity> entityList;
    protected /* synthetic */ Set<ChunkPos> viewableChunks;
    private /* synthetic */ boolean playerUpdate;
    private /* synthetic */ int playerChunkY;
    private final /* synthetic */ Set<ChunkPos> previousActiveChunkSet;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ int playerChunkX;
    private final /* synthetic */ NetHandlerPlayClient connection;
    
    @Override
    public void sendQuittingDisconnectingPacket() {
        this.connection.getNetworkManager().closeChannel(new TextComponentString("Quitting"));
    }
    
    protected void buildChunkCoordList() {
        final int lllllllllllllllIlllIlllIlIlIIIlI = MathHelper.floor(this.mc.player.posX / 16.0);
        final int lllllllllllllllIlllIlllIlIlIIIIl = MathHelper.floor(this.mc.player.posZ / 16.0);
        if (lllllllllllllllIlllIlllIlIlIIIlI != this.playerChunkX || lllllllllllllllIlllIlllIlIlIIIIl != this.playerChunkY) {
            this.playerChunkX = lllllllllllllllIlllIlllIlIlIIIlI;
            this.playerChunkY = lllllllllllllllIlllIlllIlIlIIIIl;
            this.viewableChunks.clear();
            final int lllllllllllllllIlllIlllIlIlIIIII = this.mc.gameSettings.renderDistanceChunks;
            this.theProfiler.startSection("buildList");
            final int lllllllllllllllIlllIlllIlIIlllll = MathHelper.floor(this.mc.player.posX / 16.0);
            final int lllllllllllllllIlllIlllIlIIllllI = MathHelper.floor(this.mc.player.posZ / 16.0);
            for (int lllllllllllllllIlllIlllIlIIlllIl = -lllllllllllllllIlllIlllIlIlIIIII; lllllllllllllllIlllIlllIlIIlllIl <= lllllllllllllllIlllIlllIlIlIIIII; ++lllllllllllllllIlllIlllIlIIlllIl) {
                for (int lllllllllllllllIlllIlllIlIIlllII = -lllllllllllllllIlllIlllIlIlIIIII; lllllllllllllllIlllIlllIlIIlllII <= lllllllllllllllIlllIlllIlIlIIIII; ++lllllllllllllllIlllIlllIlIIlllII) {
                    this.viewableChunks.add(new ChunkPos(lllllllllllllllIlllIlllIlIIlllIl + lllllllllllllllIlllIlllIlIIlllll, lllllllllllllllIlllIlllIlIIlllII + lllllllllllllllIlllIlllIlIIllllI));
                }
            }
            this.theProfiler.endSection();
        }
    }
    
    @Override
    protected void onEntityRemoved(final Entity lllllllllllllllIlllIlllIIlIllIIl) {
        super.onEntityRemoved(lllllllllllllllIlllIlllIIlIllIIl);
        if (this.entityList.contains(lllllllllllllllIlllIlllIIlIllIIl)) {
            if (lllllllllllllllIlllIlllIIlIllIIl.isEntityAlive()) {
                this.entitySpawnQueue.add(lllllllllllllllIlllIlllIIlIllIIl);
            }
            else {
                this.entityList.remove(lllllllllllllllIlllIlllIIlIllIIl);
            }
        }
    }
    
    @Override
    public void tick() {
        super.tick();
        this.setTotalWorldTime(this.getTotalWorldTime() + 1L);
        if (this.getGameRules().getBoolean("doDaylightCycle")) {
            this.setWorldTime(this.getWorldTime() + 1L);
        }
        this.theProfiler.startSection("reEntryProcessing");
        for (int lllllllllllllllIlllIlllIllIIIllI = 0; lllllllllllllllIlllIlllIllIIIllI < 10 && !this.entitySpawnQueue.isEmpty(); ++lllllllllllllllIlllIlllIllIIIllI) {
            final Entity lllllllllllllllIlllIlllIllIIIlIl = this.entitySpawnQueue.iterator().next();
            this.entitySpawnQueue.remove(lllllllllllllllIlllIlllIllIIIlIl);
            if (!this.loadedEntityList.contains(lllllllllllllllIlllIlllIllIIIlIl)) {
                this.spawnEntityInWorld(lllllllllllllllIlllIlllIllIIIlIl);
            }
        }
        this.theProfiler.endStartSection("chunkCache");
        this.clientChunkProvider.unloadQueuedChunks();
        this.theProfiler.endStartSection("blocks");
        this.updateBlocks();
        this.theProfiler.endSection();
    }
    
    @Override
    protected IChunkProvider createChunkProvider() {
        this.clientChunkProvider = new ChunkProviderClient(this);
        return this.clientChunkProvider;
    }
    
    @Override
    public int getCombinedLight(final BlockPos lllllllllllllllIlllIllIIlllIlIlI, final int lllllllllllllllIlllIllIIlllIIlIl) {
        int lllllllllllllllIlllIllIIlllIlIII = super.getCombinedLight(lllllllllllllllIlllIllIIlllIlIlI, lllllllllllllllIlllIllIIlllIIlIl);
        if (Config.isDynamicLights()) {
            lllllllllllllllIlllIllIIlllIlIII = DynamicLights.getCombinedLight(lllllllllllllllIlllIllIIlllIlIlI, lllllllllllllllIlllIllIIlllIlIII);
        }
        return lllllllllllllllIlllIllIIlllIlIII;
    }
    
    @Override
    public void playSound(@Nullable final EntityPlayer lllllllllllllllIlllIllIlIllIlIII, final double lllllllllllllllIlllIllIlIllIIlll, final double lllllllllllllllIlllIllIlIllIIllI, final double lllllllllllllllIlllIllIlIllIIlIl, final SoundEvent lllllllllllllllIlllIllIlIllIllIl, final SoundCategory lllllllllllllllIlllIllIlIllIIIll, final float lllllllllllllllIlllIllIlIllIIIlI, final float lllllllllllllllIlllIllIlIllIIIIl) {
        if (lllllllllllllllIlllIllIlIllIlIII == this.mc.player) {
            this.playSound(lllllllllllllllIlllIllIlIllIIlll, lllllllllllllllIlllIllIlIllIIllI, lllllllllllllllIlllIllIlIllIIlIl, lllllllllllllllIlllIllIlIllIllIl, lllllllllllllllIlllIllIlIllIIIll, lllllllllllllllIlllIllIlIllIIIlI, lllllllllllllllIlllIllIlIllIIIIl, false);
        }
    }
    
    private static WorldProvider makeWorldProvider(final int lllllllllllllllIlllIlllIllIlIIlI) {
        return (WorldProvider)(Reflector.DimensionManager_createProviderFor.exists() ? Reflector.call(Reflector.DimensionManager_createProviderFor, lllllllllllllllIlllIlllIllIlIIlI) : DimensionType.getById(lllllllllllllllIlllIlllIllIlIIlI).createDimension());
    }
    
    @Override
    public ChunkProviderClient getChunkProvider() {
        return (ChunkProviderClient)super.getChunkProvider();
    }
    
    @Override
    protected void updateWeather() {
    }
    
    public void doVoidFogParticles(final int lllllllllllllllIlllIllIlllIlIIlI, final int lllllllllllllllIlllIllIlllIIIlll, final int lllllllllllllllIlllIllIlllIIIllI) {
        final int lllllllllllllllIlllIllIlllIIllll = 32;
        final Random lllllllllllllllIlllIllIlllIIlllI = new Random();
        ItemStack lllllllllllllllIlllIllIlllIIllIl = this.mc.player.getHeldItemMainhand();
        if (lllllllllllllllIlllIllIlllIIllIl == null || Block.getBlockFromItem(lllllllllllllllIlllIllIlllIIllIl.getItem()) != Blocks.BARRIER) {
            lllllllllllllllIlllIllIlllIIllIl = this.mc.player.getHeldItemOffhand();
        }
        final boolean lllllllllllllllIlllIllIlllIIllII = this.mc.playerController.getCurrentGameType() == GameType.CREATIVE && !lllllllllllllllIlllIllIlllIIllIl.func_190926_b() && lllllllllllllllIlllIllIlllIIllIl.getItem() == Item.getItemFromBlock(Blocks.BARRIER);
        final BlockPos.MutableBlockPos lllllllllllllllIlllIllIlllIIlIll = new BlockPos.MutableBlockPos();
        for (int lllllllllllllllIlllIllIlllIIlIlI = 0; lllllllllllllllIlllIllIlllIIlIlI < 667; ++lllllllllllllllIlllIllIlllIIlIlI) {
            this.showBarrierParticles(lllllllllllllllIlllIllIlllIlIIlI, lllllllllllllllIlllIllIlllIIIlll, lllllllllllllllIlllIllIlllIIIllI, 16, lllllllllllllllIlllIllIlllIIlllI, lllllllllllllllIlllIllIlllIIllII, lllllllllllllllIlllIllIlllIIlIll);
            this.showBarrierParticles(lllllllllllllllIlllIllIlllIlIIlI, lllllllllllllllIlllIllIlllIIIlll, lllllllllllllllIlllIllIlllIIIllI, 32, lllllllllllllllIlllIllIlllIIlllI, lllllllllllllllIlllIllIlllIIllII, lllllllllllllllIlllIllIlllIIlIll);
        }
    }
    
    @Override
    protected boolean isChunkLoaded(final int lllllllllllllllIlllIlllIlIlIlllI, final int lllllllllllllllIlllIlllIlIllIIIl, final boolean lllllllllllllllIlllIlllIlIlIllII) {
        return lllllllllllllllIlllIlllIlIlIllII || !this.getChunkProvider().provideChunk(lllllllllllllllIlllIlllIlIlIlllI, lllllllllllllllIlllIlllIlIllIIIl).isEmpty();
    }
    
    @Override
    public void playSound(final double lllllllllllllllIlllIllIlIIlIIlll, final double lllllllllllllllIlllIllIlIIllIIlI, final double lllllllllllllllIlllIllIlIIllIIIl, final SoundEvent lllllllllllllllIlllIllIlIIlIIlII, final SoundCategory lllllllllllllllIlllIllIlIIlIllll, final float lllllllllllllllIlllIllIlIIlIIIlI, final float lllllllllllllllIlllIllIlIIlIllIl, final boolean lllllllllllllllIlllIllIlIIlIllII) {
        final double lllllllllllllllIlllIllIlIIlIlIll = this.mc.getRenderViewEntity().getDistanceSq(lllllllllllllllIlllIllIlIIlIIlll, lllllllllllllllIlllIllIlIIllIIlI, lllllllllllllllIlllIllIlIIllIIIl);
        final PositionedSoundRecord lllllllllllllllIlllIllIlIIlIlIlI = new PositionedSoundRecord(lllllllllllllllIlllIllIlIIlIIlII, lllllllllllllllIlllIllIlIIlIllll, lllllllllllllllIlllIllIlIIlIIIlI, lllllllllllllllIlllIllIlIIlIllIl, (float)lllllllllllllllIlllIllIlIIlIIlll, (float)lllllllllllllllIlllIllIlIIllIIlI, (float)lllllllllllllllIlllIllIlIIllIIIl);
        if (lllllllllllllllIlllIllIlIIlIllII && lllllllllllllllIlllIllIlIIlIlIll > 100.0) {
            final double lllllllllllllllIlllIllIlIIlIlIIl = Math.sqrt(lllllllllllllllIlllIllIlIIlIlIll) / 40.0;
            this.mc.getSoundHandler().playDelayedSound(lllllllllllllllIlllIllIlIIlIlIlI, (int)(lllllllllllllllIlllIllIlIIlIlIIl * 20.0));
        }
        else {
            this.mc.getSoundHandler().playSound(lllllllllllllllIlllIllIlIIlIlIlI);
        }
    }
    
    @Override
    public boolean setBlockState(final BlockPos lllllllllllllllIlllIllIIllIlllIl, final IBlockState lllllllllllllllIlllIllIIllIlIlll, final int lllllllllllllllIlllIllIIllIllIll) {
        this.playerUpdate = this.isPlayerActing();
        final boolean lllllllllllllllIlllIllIIllIllIlI = super.setBlockState(lllllllllllllllIlllIllIIllIlllIl, lllllllllllllllIlllIllIIllIlIlll, lllllllllllllllIlllIllIIllIllIll);
        this.playerUpdate = false;
        return lllllllllllllllIlllIllIIllIllIlI;
    }
    
    @Override
    public boolean spawnEntityInWorld(final Entity lllllllllllllllIlllIlllIIllIllll) {
        final boolean lllllllllllllllIlllIlllIIllIlllI = super.spawnEntityInWorld(lllllllllllllllIlllIlllIIllIllll);
        this.entityList.add(lllllllllllllllIlllIlllIIllIllll);
        if (lllllllllllllllIlllIlllIIllIlllI) {
            if (lllllllllllllllIlllIlllIIllIllll instanceof EntityMinecart) {
                this.mc.getSoundHandler().playSound(new MovingSoundMinecart((EntityMinecart)lllllllllllllllIlllIlllIIllIllll));
            }
        }
        else {
            this.entitySpawnQueue.add(lllllllllllllllIlllIlllIIllIllll);
        }
        return lllllllllllllllIlllIlllIIllIlllI;
    }
    
    public void doPreChunk(final int lllllllllllllllIlllIlllIIllllIlI, final int lllllllllllllllIlllIlllIIllllIIl, final boolean lllllllllllllllIlllIlllIIlllIlII) {
        if (lllllllllllllllIlllIlllIIlllIlII) {
            this.clientChunkProvider.loadChunk(lllllllllllllllIlllIlllIIllllIlI, lllllllllllllllIlllIlllIIllllIIl);
        }
        else {
            this.clientChunkProvider.unloadChunk(lllllllllllllllIlllIlllIIllllIlI, lllllllllllllllIlllIlllIIllllIIl);
            this.markBlockRangeForRenderUpdate(lllllllllllllllIlllIlllIIllllIlI * 16, 0, lllllllllllllllIlllIlllIIllllIIl * 16, lllllllllllllllIlllIlllIIllllIlI * 16 + 15, 256, lllllllllllllllIlllIlllIIllllIIl * 16 + 15);
        }
    }
    
    @Override
    public CrashReportCategory addWorldInfoToCrashReport(final CrashReport lllllllllllllllIlllIllIlIlllllIl) {
        final CrashReportCategory lllllllllllllllIlllIllIlIlllllll = super.addWorldInfoToCrashReport(lllllllllllllllIlllIllIlIlllllIl);
        lllllllllllllllIlllIllIlIlllllll.setDetail("Forced entities", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(WorldClient.this.entityList.size())).append(" total; ").append(WorldClient.this.entityList));
            }
        });
        lllllllllllllllIlllIllIlIlllllll.setDetail("Retry entities", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(WorldClient.this.entitySpawnQueue.size())).append(" total; ").append(WorldClient.this.entitySpawnQueue));
            }
        });
        lllllllllllllllIlllIllIlIlllllll.setDetail("Server brand", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return WorldClient.this.mc.player.getServerBrand();
            }
        });
        lllllllllllllllIlllIllIlIlllllll.setDetail("Server type", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return (WorldClient.this.mc.getIntegratedServer() == null) ? "Non-integrated multiplayer server" : "Integrated singleplayer server";
            }
        });
        return lllllllllllllllIlllIllIlIlllllll;
    }
    
    public void playSound(final BlockPos lllllllllllllllIlllIllIlIlIIllIl, final SoundEvent lllllllllllllllIlllIllIlIlIIllII, final SoundCategory lllllllllllllllIlllIllIlIlIIIlII, final float lllllllllllllllIlllIllIlIlIIlIlI, final float lllllllllllllllIlllIllIlIlIIIIlI, final boolean lllllllllllllllIlllIllIlIlIIlIII) {
        this.playSound(lllllllllllllllIlllIllIlIlIIllIl.getX() + 0.5, lllllllllllllllIlllIllIlIlIIllIl.getY() + 0.5, lllllllllllllllIlllIllIlIlIIllIl.getZ() + 0.5, lllllllllllllllIlllIllIlIlIIllII, lllllllllllllllIlllIllIlIlIIIlII, lllllllllllllllIlllIllIlIlIIlIlI, lllllllllllllllIlllIllIlIlIIIIlI, lllllllllllllllIlllIllIlIlIIlIII);
    }
    
    private boolean isPlayerActing() {
        if (this.mc.playerController instanceof PlayerControllerOF) {
            final PlayerControllerOF lllllllllllllllIlllIllIIllIlIIIl = (PlayerControllerOF)this.mc.playerController;
            return lllllllllllllllIlllIllIIllIlIIIl.isActing();
        }
        return false;
    }
    
    @Override
    protected void updateBlocks() {
        this.buildChunkCoordList();
        if (this.ambienceTicks > 0) {
            --this.ambienceTicks;
        }
        this.previousActiveChunkSet.retainAll(this.viewableChunks);
        if (this.previousActiveChunkSet.size() == this.viewableChunks.size()) {
            this.previousActiveChunkSet.clear();
        }
        int lllllllllllllllIlllIlllIlIIIlIll = 0;
        for (final ChunkPos lllllllllllllllIlllIlllIlIIIlIlI : this.viewableChunks) {
            if (!this.previousActiveChunkSet.contains(lllllllllllllllIlllIlllIlIIIlIlI)) {
                final int lllllllllllllllIlllIlllIlIIIlIIl = lllllllllllllllIlllIlllIlIIIlIlI.chunkXPos * 16;
                final int lllllllllllllllIlllIlllIlIIIlIII = lllllllllllllllIlllIlllIlIIIlIlI.chunkZPos * 16;
                this.theProfiler.startSection("getChunk");
                final Chunk lllllllllllllllIlllIlllIlIIIIlll = this.getChunkFromChunkCoords(lllllllllllllllIlllIlllIlIIIlIlI.chunkXPos, lllllllllllllllIlllIlllIlIIIlIlI.chunkZPos);
                this.playMoodSoundAndCheckLight(lllllllllllllllIlllIlllIlIIIlIIl, lllllllllllllllIlllIlllIlIIIlIII, lllllllllllllllIlllIlllIlIIIIlll);
                this.theProfiler.endSection();
                this.previousActiveChunkSet.add(lllllllllllllllIlllIlllIlIIIlIlI);
                if (++lllllllllllllllIlllIlllIlIIIlIll >= 10) {
                    return;
                }
                continue;
            }
        }
    }
    
    @Override
    public void setWorldTime(long lllllllllllllllIlllIllIIllllIIll) {
        if (lllllllllllllllIlllIllIIllllIIll < 0L) {
            lllllllllllllllIlllIllIIllllIIll = -lllllllllllllllIlllIllIIllllIIll;
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
        }
        else {
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "true");
        }
        super.setWorldTime(lllllllllllllllIlllIllIIllllIIll);
    }
    
    @Override
    public void makeFireworks(final double lllllllllllllllIlllIllIlIIIIlIll, final double lllllllllllllllIlllIllIlIIIIlIlI, final double lllllllllllllllIlllIllIlIIIIlIIl, final double lllllllllllllllIlllIllIlIIIlIIII, final double lllllllllllllllIlllIllIlIIIIllll, final double lllllllllllllllIlllIllIlIIIIlllI, @Nullable final NBTTagCompound lllllllllllllllIlllIllIlIIIIllIl) {
        this.mc.effectRenderer.addEffect(new ParticleFirework.Starter(this, lllllllllllllllIlllIllIlIIIIlIll, lllllllllllllllIlllIllIlIIIIlIlI, lllllllllllllllIlllIllIlIIIIlIIl, lllllllllllllllIlllIllIlIIIlIIII, lllllllllllllllIlllIllIlIIIIllll, lllllllllllllllIlllIllIlIIIIlllI, this.mc.effectRenderer, lllllllllllllllIlllIllIlIIIIllIl));
    }
    
    public boolean isPlayerUpdate() {
        return this.playerUpdate;
    }
    
    public WorldClient(final NetHandlerPlayClient lllllllllllllllIlllIlllIlllIlIIl, final WorldSettings lllllllllllllllIlllIlllIllIlllII, final int lllllllllllllllIlllIlllIllIllIlI, final EnumDifficulty lllllllllllllllIlllIlllIlllIIIll, final Profiler lllllllllllllllIlllIlllIllIllIII) {
        super(new SaveHandlerMP(), new WorldInfo(lllllllllllllllIlllIlllIllIlllII, "MpServer"), makeWorldProvider(lllllllllllllllIlllIlllIllIllIlI), lllllllllllllllIlllIlllIllIllIII, true);
        this.entityList = (Set<Entity>)Sets.newHashSet();
        this.entitySpawnQueue = (Set<Entity>)Sets.newHashSet();
        this.mc = Minecraft.getMinecraft();
        this.previousActiveChunkSet = (Set<ChunkPos>)Sets.newHashSet();
        this.playerChunkX = Integer.MIN_VALUE;
        this.playerChunkY = Integer.MIN_VALUE;
        this.playerUpdate = false;
        this.ambienceTicks = this.rand.nextInt(12000);
        this.viewableChunks = (Set<ChunkPos>)Sets.newHashSet();
        this.connection = lllllllllllllllIlllIlllIlllIlIIl;
        this.getWorldInfo().setDifficulty(lllllllllllllllIlllIlllIlllIIIll);
        this.provider.registerWorld(this);
        this.setSpawnPoint(new BlockPos(8, 64, 8));
        this.chunkProvider = this.createChunkProvider();
        this.mapStorage = new SaveDataMemoryStorage();
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
        Reflector.call(this, Reflector.ForgeWorld_initCapabilities, new Object[0]);
        Reflector.postForgeBusEvent(Reflector.WorldEvent_Load_Constructor, this);
        if (this.mc.playerController != null && this.mc.playerController.getClass() == PlayerControllerMP.class) {
            this.mc.playerController = new PlayerControllerOF(this.mc, lllllllllllllllIlllIlllIlllIlIIl);
            CustomGuis.setPlayerControllerOF((PlayerControllerOF)this.mc.playerController);
        }
    }
    
    public void setWorldScoreboard(final Scoreboard lllllllllllllllIlllIllIIlllllIIl) {
        this.worldScoreboard = lllllllllllllllIlllIllIIlllllIIl;
    }
    
    public void addEntityToWorld(final int lllllllllllllllIlllIlllIIlIlIIll, final Entity lllllllllllllllIlllIlllIIlIIlllI) {
        final Entity lllllllllllllllIlllIlllIIlIlIIIl = this.getEntityByID(lllllllllllllllIlllIlllIIlIlIIll);
        if (lllllllllllllllIlllIlllIIlIlIIIl != null) {
            this.removeEntity(lllllllllllllllIlllIlllIIlIlIIIl);
        }
        this.entityList.add(lllllllllllllllIlllIlllIIlIIlllI);
        lllllllllllllllIlllIlllIIlIIlllI.setEntityId(lllllllllllllllIlllIlllIIlIlIIll);
        if (!this.spawnEntityInWorld(lllllllllllllllIlllIlllIIlIIlllI)) {
            this.entitySpawnQueue.add(lllllllllllllllIlllIlllIIlIIlllI);
        }
        this.entitiesById.addKey(lllllllllllllllIlllIlllIIlIlIIll, lllllllllllllllIlllIlllIIlIIlllI);
    }
    
    @Override
    public void removeEntity(final Entity lllllllllllllllIlllIlllIIllIIlIl) {
        super.removeEntity(lllllllllllllllIlllIlllIIllIIlIl);
        this.entityList.remove(lllllllllllllllIlllIlllIIllIIlIl);
    }
    
    public void showBarrierParticles(final int lllllllllllllllIlllIllIllIlIIllI, final int lllllllllllllllIlllIllIllIllIIIl, final int lllllllllllllllIlllIllIllIllIIII, final int lllllllllllllllIlllIllIllIlIllll, final Random lllllllllllllllIlllIllIllIlIlllI, final boolean lllllllllllllllIlllIllIllIlIllIl, final BlockPos.MutableBlockPos lllllllllllllllIlllIllIllIlIIIII) {
        final int lllllllllllllllIlllIllIllIlIlIll = lllllllllllllllIlllIllIllIlIIllI + this.rand.nextInt(lllllllllllllllIlllIllIllIlIllll) - this.rand.nextInt(lllllllllllllllIlllIllIllIlIllll);
        final int lllllllllllllllIlllIllIllIlIlIlI = lllllllllllllllIlllIllIllIllIIIl + this.rand.nextInt(lllllllllllllllIlllIllIllIlIllll) - this.rand.nextInt(lllllllllllllllIlllIllIllIlIllll);
        final int lllllllllllllllIlllIllIllIlIlIIl = lllllllllllllllIlllIllIllIllIIII + this.rand.nextInt(lllllllllllllllIlllIllIllIlIllll) - this.rand.nextInt(lllllllllllllllIlllIllIllIlIllll);
        lllllllllllllllIlllIllIllIlIIIII.setPos(lllllllllllllllIlllIllIllIlIlIll, lllllllllllllllIlllIllIllIlIlIlI, lllllllllllllllIlllIllIllIlIlIIl);
        final IBlockState lllllllllllllllIlllIllIllIlIlIII = this.getBlockState(lllllllllllllllIlllIllIllIlIIIII);
        lllllllllllllllIlllIllIllIlIlIII.getBlock().randomDisplayTick(lllllllllllllllIlllIllIllIlIlIII, this, lllllllllllllllIlllIllIllIlIIIII, lllllllllllllllIlllIllIllIlIlllI);
        if (lllllllllllllllIlllIllIllIlIllIl && lllllllllllllllIlllIllIllIlIlIII.getBlock() == Blocks.BARRIER) {
            this.spawnParticle(EnumParticleTypes.BARRIER, lllllllllllllllIlllIllIllIlIlIll + 0.5f, lllllllllllllllIlllIllIllIlIlIlI + 0.5f, lllllllllllllllIlllIllIllIlIlIIl + 0.5f, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    public void invalidateBlockReceiveRegion(final int lllllllllllllllIlllIlllIllIIIIII, final int lllllllllllllllIlllIlllIlIllllll, final int lllllllllllllllIlllIlllIlIlllllI, final int lllllllllllllllIlllIlllIlIllllIl, final int lllllllllllllllIlllIlllIlIllllII, final int lllllllllllllllIlllIlllIlIlllIll) {
    }
    
    @Deprecated
    public boolean invalidateRegionAndSetBlock(final BlockPos lllllllllllllllIlllIlllIIIllIIII, final IBlockState lllllllllllllllIlllIlllIIIllIlIl) {
        final int lllllllllllllllIlllIlllIIIllIlII = lllllllllllllllIlllIlllIIIllIIII.getX();
        final int lllllllllllllllIlllIlllIIIllIIll = lllllllllllllllIlllIlllIIIllIIII.getY();
        final int lllllllllllllllIlllIlllIIIllIIlI = lllllllllllllllIlllIlllIIIllIIII.getZ();
        this.invalidateBlockReceiveRegion(lllllllllllllllIlllIlllIIIllIlII, lllllllllllllllIlllIlllIIIllIIll, lllllllllllllllIlllIlllIIIllIIlI, lllllllllllllllIlllIlllIIIllIlII, lllllllllllllllIlllIlllIIIllIIll, lllllllllllllllIlllIlllIIIllIIlI);
        return super.setBlockState(lllllllllllllllIlllIlllIIIllIIII, lllllllllllllllIlllIlllIIIllIlIl, 3);
    }
    
    public void removeAllEntities() {
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (int lllllllllllllllIlllIllIllIIlIlII = 0; lllllllllllllllIlllIllIllIIlIlII < this.unloadedEntityList.size(); ++lllllllllllllllIlllIllIllIIlIlII) {
            final Entity lllllllllllllllIlllIllIllIIlIIll = this.unloadedEntityList.get(lllllllllllllllIlllIllIllIIlIlII);
            final int lllllllllllllllIlllIllIllIIlIIlI = lllllllllllllllIlllIllIllIIlIIll.chunkCoordX;
            final int lllllllllllllllIlllIllIllIIlIIIl = lllllllllllllllIlllIllIllIIlIIll.chunkCoordZ;
            if (lllllllllllllllIlllIllIllIIlIIll.addedToChunk && this.isChunkLoaded(lllllllllllllllIlllIllIllIIlIIlI, lllllllllllllllIlllIllIllIIlIIIl, true)) {
                this.getChunkFromChunkCoords(lllllllllllllllIlllIllIllIIlIIlI, lllllllllllllllIlllIllIllIIlIIIl).removeEntity(lllllllllllllllIlllIllIllIIlIIll);
            }
        }
        for (int lllllllllllllllIlllIllIllIIlIIII = 0; lllllllllllllllIlllIllIllIIlIIII < this.unloadedEntityList.size(); ++lllllllllllllllIlllIllIllIIlIIII) {
            this.onEntityRemoved(this.unloadedEntityList.get(lllllllllllllllIlllIllIllIIlIIII));
        }
        this.unloadedEntityList.clear();
        for (int lllllllllllllllIlllIllIllIIIllll = 0; lllllllllllllllIlllIllIllIIIllll < this.loadedEntityList.size(); ++lllllllllllllllIlllIllIllIIIllll) {
            final Entity lllllllllllllllIlllIllIllIIIlllI = this.loadedEntityList.get(lllllllllllllllIlllIllIllIIIllll);
            final Entity lllllllllllllllIlllIllIllIIIllIl = lllllllllllllllIlllIllIllIIIlllI.getRidingEntity();
            if (lllllllllllllllIlllIllIllIIIllIl != null) {
                if (!lllllllllllllllIlllIllIllIIIllIl.isDead && lllllllllllllllIlllIllIllIIIllIl.isPassenger(lllllllllllllllIlllIllIllIIIlllI)) {
                    continue;
                }
                lllllllllllllllIlllIllIllIIIlllI.dismountRidingEntity();
            }
            if (lllllllllllllllIlllIllIllIIIlllI.isDead) {
                final int lllllllllllllllIlllIllIllIIIllII = lllllllllllllllIlllIllIllIIIlllI.chunkCoordX;
                final int lllllllllllllllIlllIllIllIIIlIll = lllllllllllllllIlllIllIllIIIlllI.chunkCoordZ;
                if (lllllllllllllllIlllIllIllIIIlllI.addedToChunk && this.isChunkLoaded(lllllllllllllllIlllIllIllIIIllII, lllllllllllllllIlllIllIllIIIlIll, true)) {
                    this.getChunkFromChunkCoords(lllllllllllllllIlllIllIllIIIllII, lllllllllllllllIlllIllIllIIIlIll).removeEntity(lllllllllllllllIlllIllIllIIIlllI);
                }
                this.loadedEntityList.remove(lllllllllllllllIlllIllIllIIIllll--);
                this.onEntityRemoved(lllllllllllllllIlllIllIllIIIlllI);
            }
        }
    }
    
    @Override
    public void sendPacketToServer(final Packet<?> lllllllllllllllIlllIllIlIIIIIIIl) {
        this.connection.sendPacket(lllllllllllllllIlllIllIlIIIIIIIl);
    }
    
    public Entity removeEntityFromWorld(final int lllllllllllllllIlllIlllIIlIIIIlI) {
        final Entity lllllllllllllllIlllIlllIIlIIIIIl = this.entitiesById.removeObject(lllllllllllllllIlllIlllIIlIIIIlI);
        if (lllllllllllllllIlllIlllIIlIIIIIl != null) {
            this.entityList.remove(lllllllllllllllIlllIlllIIlIIIIIl);
            this.removeEntity(lllllllllllllllIlllIlllIIlIIIIIl);
        }
        return lllllllllllllllIlllIlllIIlIIIIIl;
    }
    
    @Nullable
    @Override
    public Entity getEntityByID(final int lllllllllllllllIlllIlllIIlIIlIIl) {
        return (lllllllllllllllIlllIlllIIlIIlIIl == this.mc.player.getEntityId()) ? this.mc.player : super.getEntityByID(lllllllllllllllIlllIlllIIlIIlIIl);
    }
    
    @Override
    protected void onEntityAdded(final Entity lllllllllllllllIlllIlllIIllIIIIl) {
        super.onEntityAdded(lllllllllllllllIlllIlllIIllIIIIl);
        if (this.entitySpawnQueue.contains(lllllllllllllllIlllIlllIIllIIIIl)) {
            this.entitySpawnQueue.remove(lllllllllllllllIlllIlllIIllIIIIl);
        }
    }
    
    @Override
    protected void playMoodSoundAndCheckLight(final int lllllllllllllllIlllIllIllllIlIII, final int lllllllllllllllIlllIllIllllIIlll, final Chunk lllllllllllllllIlllIllIllllIIllI) {
        super.playMoodSoundAndCheckLight(lllllllllllllllIlllIllIllllIlIII, lllllllllllllllIlllIllIllllIIlll, lllllllllllllllIlllIllIllllIIllI);
        if (this.ambienceTicks == 0) {
            final EntityPlayerSP lllllllllllllllIlllIllIlllllIIll = this.mc.player;
            if (lllllllllllllllIlllIllIlllllIIll == null) {
                return;
            }
            if (Math.abs(lllllllllllllllIlllIllIlllllIIll.chunkCoordX - lllllllllllllllIlllIllIllllIIllI.xPosition) > 1 || Math.abs(lllllllllllllllIlllIllIlllllIIll.chunkCoordZ - lllllllllllllllIlllIllIllllIIllI.zPosition) > 1) {
                return;
            }
            this.updateLCG = this.updateLCG * 3 + 1013904223;
            final int lllllllllllllllIlllIllIlllllIIIl = this.updateLCG >> 2;
            int lllllllllllllllIlllIllIllllIllll = lllllllllllllllIlllIllIlllllIIIl & 0xF;
            int lllllllllllllllIlllIllIllllIlllI = lllllllllllllllIlllIllIlllllIIIl >> 8 & 0xF;
            int lllllllllllllllIlllIllIllllIllIl = lllllllllllllllIlllIllIlllllIIIl >> 16 & 0xFF;
            lllllllllllllllIlllIllIllllIllIl /= 2;
            if (lllllllllllllllIlllIllIlllllIIll.posY > 160.0) {
                lllllllllllllllIlllIllIllllIllIl += 128;
            }
            else if (lllllllllllllllIlllIllIlllllIIll.posY > 96.0) {
                lllllllllllllllIlllIllIllllIllIl += 64;
            }
            final BlockPos lllllllllllllllIlllIllIllllIllII = new BlockPos(lllllllllllllllIlllIllIllllIllll + lllllllllllllllIlllIllIllllIlIII, lllllllllllllllIlllIllIllllIllIl, lllllllllllllllIlllIllIllllIlllI + lllllllllllllllIlllIllIllllIIlll);
            final IBlockState lllllllllllllllIlllIllIllllIlIll = lllllllllllllllIlllIllIllllIIllI.getBlockState(lllllllllllllllIlllIllIllllIllII);
            lllllllllllllllIlllIllIllllIllll += lllllllllllllllIlllIllIllllIlIII;
            lllllllllllllllIlllIllIllllIlllI += lllllllllllllllIlllIllIllllIIlll;
            final double lllllllllllllllIlllIllIllllIlIlI = this.mc.player.getDistanceSq(lllllllllllllllIlllIllIllllIllll + 0.5, lllllllllllllllIlllIllIllllIllIl + 0.5, lllllllllllllllIlllIllIllllIlllI + 0.5);
            if (lllllllllllllllIlllIllIllllIlIlI < 4.0) {
                return;
            }
            if (lllllllllllllllIlllIllIllllIlIlI > 255.0) {
                return;
            }
            if (lllllllllllllllIlllIllIllllIlIll.getMaterial() == Material.AIR && this.getLight(lllllllllllllllIlllIllIllllIllII) <= this.rand.nextInt(8) && this.getLightFor(EnumSkyBlock.SKY, lllllllllllllllIlllIllIllllIllII) <= 0) {
                this.playSound(lllllllllllllllIlllIllIllllIllll + 0.5, lllllllllllllllIlllIllIllllIllIl + 0.5, lllllllllllllllIlllIllIllllIlllI + 0.5, SoundEvents.AMBIENT_CAVE, SoundCategory.AMBIENT, 0.7f, 0.8f + this.rand.nextFloat() * 0.2f, false);
                this.ambienceTicks = this.rand.nextInt(12000) + 6000;
            }
        }
    }
}
