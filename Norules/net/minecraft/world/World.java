package net.minecraft.world;

import net.minecraft.tileentity.*;
import net.minecraft.village.*;
import net.minecraft.profiler.*;
import net.minecraft.scoreboard.*;
import net.minecraft.pathfinding.*;
import net.minecraft.advancements.*;
import net.minecraft.world.border.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.crash.*;
import net.minecraft.world.chunk.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.network.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.storage.*;
import com.google.common.base.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.server.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public abstract class World implements IBlockAccess
{
    public final /* synthetic */ List<TileEntity> loadedTileEntityList;
    private /* synthetic */ boolean processingLoadedTiles;
    protected /* synthetic */ VillageCollection villageCollectionObj;
    public final /* synthetic */ List<TileEntity> tickableTileEntities;
    private final /* synthetic */ List<TileEntity> tileEntitiesToBeRemoved;
    private final /* synthetic */ Calendar theCalendar;
    private /* synthetic */ int lastLightningBolt;
    public final /* synthetic */ boolean isRemote;
    public final /* synthetic */ Profiler theProfiler;
    protected /* synthetic */ WorldInfo worldInfo;
    protected /* synthetic */ Scoreboard worldScoreboard;
    public final /* synthetic */ List<EntityPlayer> playerEntities;
    protected /* synthetic */ MapStorage mapStorage;
    /* synthetic */ int[] lightUpdateBlockList;
    protected /* synthetic */ float rainingStrength;
    protected /* synthetic */ boolean spawnHostileMobs;
    public final /* synthetic */ List<Entity> loadedEntityList;
    protected /* synthetic */ List<IWorldEventListener> eventListeners;
    protected /* synthetic */ PathWorldListener pathListener;
    public final /* synthetic */ WorldProvider provider;
    protected /* synthetic */ float prevThunderingStrength;
    protected /* synthetic */ float thunderingStrength;
    public final /* synthetic */ Random rand;
    protected /* synthetic */ IChunkProvider chunkProvider;
    protected /* synthetic */ float prevRainingStrength;
    protected /* synthetic */ boolean spawnPeacefulMobs;
    protected final /* synthetic */ List<Entity> unloadedEntityList;
    private /* synthetic */ int skylightSubtracted;
    public final /* synthetic */ List<Entity> weatherEffects;
    private final /* synthetic */ WorldBorder worldBorder;
    private final /* synthetic */ List<TileEntity> addedTileEntityList;
    protected /* synthetic */ LootTableManager lootTable;
    protected /* synthetic */ int updateLCG;
    protected /* synthetic */ boolean scheduledUpdatesAreImmediate;
    private /* synthetic */ int seaLevel;
    protected final /* synthetic */ IntHashMap<Entity> entitiesById;
    protected final /* synthetic */ ISaveHandler saveHandler;
    
    private boolean isAreaLoaded(int lllllllllllllllIlIIIlllIIlIIIIIl, final int lllllllllllllllIlIIIlllIIlIIlIlI, int lllllllllllllllIlIIIlllIIIllllll, int lllllllllllllllIlIIIlllIIIlllllI, final int lllllllllllllllIlIIIlllIIlIIIlll, int lllllllllllllllIlIIIlllIIIllllII, final boolean lllllllllllllllIlIIIlllIIlIIIlIl) {
        if (lllllllllllllllIlIIIlllIIlIIIlll >= 0 && lllllllllllllllIlIIIlllIIlIIlIlI < 256) {
            lllllllllllllllIlIIIlllIIlIIIIIl >>= 4;
            lllllllllllllllIlIIIlllIIIllllll >>= 4;
            lllllllllllllllIlIIIlllIIIlllllI >>= 4;
            lllllllllllllllIlIIIlllIIIllllII >>= 4;
            for (int lllllllllllllllIlIIIlllIIlIIIlII = lllllllllllllllIlIIIlllIIlIIIIIl; lllllllllllllllIlIIIlllIIlIIIlII <= lllllllllllllllIlIIIlllIIIlllllI; ++lllllllllllllllIlIIIlllIIlIIIlII) {
                for (int lllllllllllllllIlIIIlllIIlIIIIll = lllllllllllllllIlIIIlllIIIllllll; lllllllllllllllIlIIIlllIIlIIIIll <= lllllllllllllllIlIIIlllIIIllllII; ++lllllllllllllllIlIIIlllIIlIIIIll) {
                    if (!this.isChunkLoaded(lllllllllllllllIlIIIlllIIlIIIlII, lllllllllllllllIlIIIlllIIlIIIIll, lllllllllllllllIlIIIlllIIlIIIlIl)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public Biome getBiome(final BlockPos lllllllllllllllIlIIIllllIIIllIll) {
        if (this.isBlockLoaded(lllllllllllllllIlIIIllllIIIllIll)) {
            final Chunk lllllllllllllllIlIIIllllIIlIIIII = this.getChunkFromBlockCoords(lllllllllllllllIlIIIllllIIIllIll);
            try {
                return lllllllllllllllIlIIIllllIIlIIIII.getBiome(lllllllllllllllIlIIIllllIIIllIll, this.provider.getBiomeProvider());
            }
            catch (Throwable lllllllllllllllIlIIIllllIIIlllll) {
                final CrashReport lllllllllllllllIlIIIllllIIIllllI = CrashReport.makeCrashReport(lllllllllllllllIlIIIllllIIIlllll, "Getting biome");
                final CrashReportCategory lllllllllllllllIlIIIllllIIIlllIl = lllllllllllllllIlIIIllllIIIllllI.makeCategory("Coordinates of biome request");
                lllllllllllllllIlIIIllllIIIlllIl.setDetail("Location", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return CrashReportCategory.getCoordinateInfo(lllllllllllllllIlIIIllllIIIllIll);
                    }
                });
                throw new ReportedException(lllllllllllllllIlIIIllllIIIllllI);
            }
        }
        return this.provider.getBiomeProvider().getBiome(lllllllllllllllIlIIIllllIIIllIll, Biomes.PLAINS);
    }
    
    public <T extends Entity> List<T> getEntitiesWithinAABB(final Class<? extends T> lllllllllllllllIlIIIIllIIlIIlIlI, final AxisAlignedBB lllllllllllllllIlIIIIllIIlIIlIIl, @Nullable final Predicate<? super T> lllllllllllllllIlIIIIllIIIllllIl) {
        final int lllllllllllllllIlIIIIllIIlIIIlll = MathHelper.floor((lllllllllllllllIlIIIIllIIlIIlIIl.minX - 2.0) / 16.0);
        final int lllllllllllllllIlIIIIllIIlIIIllI = MathHelper.ceil((lllllllllllllllIlIIIIllIIlIIlIIl.maxX + 2.0) / 16.0);
        final int lllllllllllllllIlIIIIllIIlIIIlIl = MathHelper.floor((lllllllllllllllIlIIIIllIIlIIlIIl.minZ - 2.0) / 16.0);
        final int lllllllllllllllIlIIIIllIIlIIIlII = MathHelper.ceil((lllllllllllllllIlIIIIllIIlIIlIIl.maxZ + 2.0) / 16.0);
        final List<T> lllllllllllllllIlIIIIllIIlIIIIll = (List<T>)Lists.newArrayList();
        for (int lllllllllllllllIlIIIIllIIlIIIIlI = lllllllllllllllIlIIIIllIIlIIIlll; lllllllllllllllIlIIIIllIIlIIIIlI < lllllllllllllllIlIIIIllIIlIIIllI; ++lllllllllllllllIlIIIIllIIlIIIIlI) {
            for (int lllllllllllllllIlIIIIllIIlIIIIIl = lllllllllllllllIlIIIIllIIlIIIlIl; lllllllllllllllIlIIIIllIIlIIIIIl < lllllllllllllllIlIIIIllIIlIIIlII; ++lllllllllllllllIlIIIIllIIlIIIIIl) {
                if (this.isChunkLoaded(lllllllllllllllIlIIIIllIIlIIIIlI, lllllllllllllllIlIIIIllIIlIIIIIl, true)) {
                    this.getChunkFromChunkCoords(lllllllllllllllIlIIIIllIIlIIIIlI, lllllllllllllllIlIIIIllIIlIIIIIl).getEntitiesOfTypeWithinAAAB(lllllllllllllllIlIIIIllIIlIIlIlI, lllllllllllllllIlIIIIllIIlIIlIIl, lllllllllllllllIlIIIIllIIlIIIIll, lllllllllllllllIlIIIIllIIIllllIl);
                }
            }
        }
        return lllllllllllllllIlIIIIllIIlIIIIll;
    }
    
    public boolean isDaytime() {
        return this.skylightSubtracted < 4;
    }
    
    public BlockPos getPrecipitationHeight(final BlockPos lllllllllllllllIlIIIlIIlllllIlll) {
        return this.getChunkFromBlockCoords(lllllllllllllllIlIIIlIIlllllIlll).getPrecipitationHeight(lllllllllllllllIlIIIlIIlllllIlll);
    }
    
    public boolean spawnEntityInWorld(final Entity lllllllllllllllIlIIIlIllIlIIIIIl) {
        final int lllllllllllllllIlIIIlIllIlIIIllI = MathHelper.floor(lllllllllllllllIlIIIlIllIlIIIIIl.posX / 16.0);
        final int lllllllllllllllIlIIIlIllIlIIIlIl = MathHelper.floor(lllllllllllllllIlIIIlIllIlIIIIIl.posZ / 16.0);
        boolean lllllllllllllllIlIIIlIllIlIIIlII = lllllllllllllllIlIIIlIllIlIIIIIl.forceSpawn;
        if (lllllllllllllllIlIIIlIllIlIIIIIl instanceof EntityPlayer) {
            lllllllllllllllIlIIIlIllIlIIIlII = true;
        }
        if (!lllllllllllllllIlIIIlIllIlIIIlII && !this.isChunkLoaded(lllllllllllllllIlIIIlIllIlIIIllI, lllllllllllllllIlIIIlIllIlIIIlIl, false)) {
            return false;
        }
        if (lllllllllllllllIlIIIlIllIlIIIIIl instanceof EntityPlayer) {
            final EntityPlayer lllllllllllllllIlIIIlIllIlIIIIll = (EntityPlayer)lllllllllllllllIlIIIlIllIlIIIIIl;
            this.playerEntities.add(lllllllllllllllIlIIIlIllIlIIIIll);
            this.updateAllPlayersSleepingFlag();
        }
        this.getChunkFromChunkCoords(lllllllllllllllIlIIIlIllIlIIIllI, lllllllllllllllIlIIIlIllIlIIIlIl).addEntity(lllllllllllllllIlIIIlIllIlIIIIIl);
        this.loadedEntityList.add(lllllllllllllllIlIIIlIllIlIIIIIl);
        this.onEntityAdded(lllllllllllllllIlIIIlIllIlIIIIIl);
        return true;
    }
    
    public EnumDifficulty getDifficulty() {
        return this.getWorldInfo().getDifficulty();
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos lllllllllllllllIlIIIllIIlIIlIlll) {
        if (this.isOutsideBuildHeight(lllllllllllllllIlIIIllIIlIIlIlll)) {
            return Blocks.AIR.getDefaultState();
        }
        final Chunk lllllllllllllllIlIIIllIIlIIlIllI = this.getChunkFromBlockCoords(lllllllllllllllIlIIIllIIlIIlIlll);
        return lllllllllllllllIlIIIllIIlIIlIllI.getBlockState(lllllllllllllllIlIIIllIIlIIlIlll);
    }
    
    public void setAllowedSpawnTypes(final boolean lllllllllllllllIlIIIIllllIlIllII, final boolean lllllllllllllllIlIIIIllllIlIlIll) {
        this.spawnHostileMobs = lllllllllllllllIlIIIIllllIlIllII;
        this.spawnPeacefulMobs = lllllllllllllllIlIIIIllllIlIlIll;
    }
    
    public void addTileEntities(final Collection<TileEntity> lllllllllllllllIlIIIlIIllIIIIlII) {
        if (this.processingLoadedTiles) {
            this.addedTileEntityList.addAll(lllllllllllllllIlIIIlIIllIIIIlII);
        }
        else {
            for (final TileEntity lllllllllllllllIlIIIlIIllIIIIllI : lllllllllllllllIlIIIlIIllIIIIlII) {
                this.addTileEntity(lllllllllllllllIlIIIlIIllIIIIllI);
            }
        }
    }
    
    @Override
    public int getCombinedLight(final BlockPos lllllllllllllllIlIIIllIIlIlIIlIl, final int lllllllllllllllIlIIIllIIlIlIlIIl) {
        final int lllllllllllllllIlIIIllIIlIlIlIII = this.getLightFromNeighborsFor(EnumSkyBlock.SKY, lllllllllllllllIlIIIllIIlIlIIlIl);
        int lllllllllllllllIlIIIllIIlIlIIlll = this.getLightFromNeighborsFor(EnumSkyBlock.BLOCK, lllllllllllllllIlIIIllIIlIlIIlIl);
        if (lllllllllllllllIlIIIllIIlIlIIlll < lllllllllllllllIlIIIllIIlIlIlIIl) {
            lllllllllllllllIlIIIllIIlIlIIlll = lllllllllllllllIlIIIllIIlIlIlIIl;
        }
        return lllllllllllllllIlIIIllIIlIlIlIII << 20 | lllllllllllllllIlIIIllIIlIlIIlll << 4;
    }
    
    public void func_190529_b(final BlockPos lllllllllllllllIlIIIllIlIlIllIIl, final Block lllllllllllllllIlIIIllIlIlIllIII, final BlockPos lllllllllllllllIlIIIllIlIlIlIlll) {
        if (!this.isRemote) {
            final IBlockState lllllllllllllllIlIIIllIlIlIlIllI = this.getBlockState(lllllllllllllllIlIIIllIlIlIllIIl);
            if (lllllllllllllllIlIIIllIlIlIlIllI.getBlock() == Blocks.field_190976_dk) {
                try {
                    ((BlockObserver)lllllllllllllllIlIIIllIlIlIlIllI.getBlock()).func_190962_b(lllllllllllllllIlIIIllIlIlIlIllI, this, lllllllllllllllIlIIIllIlIlIllIIl, lllllllllllllllIlIIIllIlIlIllIII, lllllllllllllllIlIIIllIlIlIlIlll);
                }
                catch (Throwable lllllllllllllllIlIIIllIlIlIlIlIl) {
                    final CrashReport lllllllllllllllIlIIIllIlIlIlIlII = CrashReport.makeCrashReport(lllllllllllllllIlIIIllIlIlIlIlIl, "Exception while updating neighbours");
                    final CrashReportCategory lllllllllllllllIlIIIllIlIlIlIIll = lllllllllllllllIlIIIllIlIlIlIlII.makeCategory("Block being updated");
                    lllllllllllllllIlIIIllIlIlIlIIll.setDetail("Source block type", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            try {
                                return String.format("ID #%d (%s // %s)", Block.getIdFromBlock(lllllllllllllllIlIIIllIlIlIllIII), lllllllllllllllIlIIIllIlIlIllIII.getUnlocalizedName(), lllllllllllllllIlIIIllIlIlIllIII.getClass().getCanonicalName());
                            }
                            catch (Throwable lllllllllllllIIlIIIIIIIllIIIIIII) {
                                return String.valueOf(new StringBuilder("ID #").append(Block.getIdFromBlock(lllllllllllllllIlIIIllIlIlIllIII)));
                            }
                        }
                    });
                    CrashReportCategory.addBlockInfo(lllllllllllllllIlIIIllIlIlIlIIll, lllllllllllllllIlIIIllIlIlIllIIl, lllllllllllllllIlIIIllIlIlIlIllI);
                    throw new ReportedException(lllllllllllllllIlIIIllIlIlIlIlII);
                }
            }
        }
    }
    
    public void calculateInitialSkylight() {
        final int lllllllllllllllIlIIIIllllIllIIll = this.calculateSkylightSubtracted(1.0f);
        if (lllllllllllllllIlIIIIllllIllIIll != this.skylightSubtracted) {
            this.skylightSubtracted = lllllllllllllllIlIIIIllllIllIIll;
        }
    }
    
    public void makeFireworks(final double lllllllllllllllIlIIIIIlllIllIlII, final double lllllllllllllllIlIIIIIlllIllIIll, final double lllllllllllllllIlIIIIIlllIllIIlI, final double lllllllllllllllIlIIIIIlllIllIIIl, final double lllllllllllllllIlIIIIIlllIllIIII, final double lllllllllllllllIlIIIIIlllIlIllll, @Nullable final NBTTagCompound lllllllllllllllIlIIIIIlllIlIlllI) {
    }
    
    public boolean canBlockSeeSky(final BlockPos lllllllllllllllIlIIIllIlIIllIllI) {
        if (lllllllllllllllIlIIIllIlIIllIllI.getY() >= this.getSeaLevel()) {
            return this.canSeeSky(lllllllllllllllIlIIIllIlIIllIllI);
        }
        final BlockPos lllllllllllllllIlIIIllIlIIlllIlI = new BlockPos(lllllllllllllllIlIIIllIlIIllIllI.getX(), this.getSeaLevel(), lllllllllllllllIlIIIllIlIIllIllI.getZ());
        if (!this.canSeeSky(lllllllllllllllIlIIIllIlIIlllIlI)) {
            return false;
        }
        for (BlockPos lllllllllllllllIlIIIllIlIIlllIIl = lllllllllllllllIlIIIllIlIIlllIlI.down(); lllllllllllllllIlIIIllIlIIlllIIl.getY() > lllllllllllllllIlIIIllIlIIllIllI.getY(); lllllllllllllllIlIIIllIlIIlllIIl = lllllllllllllllIlIIIllIlIIlllIIl.down()) {
            final IBlockState lllllllllllllllIlIIIllIlIIlllIII = this.getBlockState(lllllllllllllllIlIIIllIlIIlllIIl);
            if (lllllllllllllllIlIIIllIlIIlllIII.getLightOpacity() > 0 && !lllllllllllllllIlIIIllIlIIlllIII.getMaterial().isLiquid()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean func_190527_a(final Block lllllllllllllllIlIIIIlIlllIlIlll, final BlockPos lllllllllllllllIlIIIIlIlllIlIllI, final boolean lllllllllllllllIlIIIIlIlllIlIlIl, final EnumFacing lllllllllllllllIlIIIIlIlllIlIlII, @Nullable final Entity lllllllllllllllIlIIIIlIlllIllIll) {
        final IBlockState lllllllllllllllIlIIIIlIlllIllIlI = this.getBlockState(lllllllllllllllIlIIIIlIlllIlIllI);
        final AxisAlignedBB lllllllllllllllIlIIIIlIlllIllIIl = lllllllllllllllIlIIIIlIlllIlIlIl ? null : lllllllllllllllIlIIIIlIlllIlIlll.getDefaultState().getCollisionBoundingBox(this, lllllllllllllllIlIIIIlIlllIlIllI);
        return (lllllllllllllllIlIIIIlIlllIllIIl == Block.NULL_AABB || this.checkNoEntityCollision(lllllllllllllllIlIIIIlIlllIllIIl.offset(lllllllllllllllIlIIIIlIlllIlIllI), lllllllllllllllIlIIIIlIlllIllIll)) && ((lllllllllllllllIlIIIIlIlllIllIlI.getMaterial() == Material.CIRCUITS && lllllllllllllllIlIIIIlIlllIlIlll == Blocks.ANVIL) || (lllllllllllllllIlIIIIlIlllIllIlI.getMaterial().isReplaceable() && lllllllllllllllIlIIIIlIlllIlIlll.canPlaceBlockOnSide(this, lllllllllllllllIlIIIIlIlllIlIllI, lllllllllllllllIlIIIIlIlllIlIlII)));
    }
    
    public boolean isBlockModifiable(final EntityPlayer lllllllllllllllIlIIIIlIIlIIIlIlI, final BlockPos lllllllllllllllIlIIIIlIIlIIIlIIl) {
        return true;
    }
    
    public void initialize(final WorldSettings lllllllllllllllIlIIIllllIIIlIIIl) {
        this.worldInfo.setServerInitialized(true);
    }
    
    @Nullable
    @Override
    public TileEntity getTileEntity(final BlockPos lllllllllllllllIlIIIIllllllllIlI) {
        if (this.isOutsideBuildHeight(lllllllllllllllIlIIIIllllllllIlI)) {
            return null;
        }
        TileEntity lllllllllllllllIlIIIIlllllllllII = null;
        if (this.processingLoadedTiles) {
            lllllllllllllllIlIIIIlllllllllII = this.getPendingTileEntityAt(lllllllllllllllIlIIIIllllllllIlI);
        }
        if (lllllllllllllllIlIIIIlllllllllII == null) {
            lllllllllllllllIlIIIIlllllllllII = this.getChunkFromBlockCoords(lllllllllllllllIlIIIIllllllllIlI).getTileEntity(lllllllllllllllIlIIIIllllllllIlI, Chunk.EnumCreateEntityType.IMMEDIATE);
        }
        if (lllllllllllllllIlIIIIlllllllllII == null) {
            lllllllllllllllIlIIIIlllllllllII = this.getPendingTileEntityAt(lllllllllllllllIlIIIIllllllllIlI);
        }
        return lllllllllllllllIlIIIIlllllllllII;
    }
    
    public void sendPacketToServer(final Packet<?> lllllllllllllllIlIIIIIllIlIllIIl) {
        throw new UnsupportedOperationException("Can't send packets to server unless you're on the client.");
    }
    
    public Random setRandomSeed(final int lllllllllllllllIlIIIIIlllllIIIlI, final int lllllllllllllllIlIIIIIllllIlllII, final int lllllllllllllllIlIIIIIllllIllIll) {
        final long lllllllllllllllIlIIIIIllllIlllll = lllllllllllllllIlIIIIIlllllIIIlI * 341873128712L + lllllllllllllllIlIIIIIllllIlllII * 132897987541L + this.getWorldInfo().getSeed() + lllllllllllllllIlIIIIIllllIllIll;
        this.rand.setSeed(lllllllllllllllIlIIIIIllllIlllll);
        return this.rand;
    }
    
    @Override
    public int getStrongPower(final BlockPos lllllllllllllllIlIIIIlIlllIIIIII, final EnumFacing lllllllllllllllIlIIIIlIllIllllll) {
        return this.getBlockState(lllllllllllllllIlIIIIlIlllIIIIII).getStrongPower(this, lllllllllllllllIlIIIIlIlllIIIIII, lllllllllllllllIlIIIIlIllIllllll);
    }
    
    public void playSound(@Nullable final EntityPlayer lllllllllllllllIlIIIlIlllllIlIlI, final double lllllllllllllllIlIIIlIlllllIlIIl, final double lllllllllllllllIlIIIlIlllllIlIII, final double lllllllllllllllIlIIIlIlllllIIlll, final SoundEvent lllllllllllllllIlIIIlIllllllIIII, final SoundCategory lllllllllllllllIlIIIlIlllllIIlIl, final float lllllllllllllllIlIIIlIlllllIlllI, final float lllllllllllllllIlIIIlIlllllIIIll) {
        for (int lllllllllllllllIlIIIlIlllllIllII = 0; lllllllllllllllIlIIIlIlllllIllII < this.eventListeners.size(); ++lllllllllllllllIlIIIlIlllllIllII) {
            this.eventListeners.get(lllllllllllllllIlIIIlIlllllIllII).playSoundToAllNearExcept(lllllllllllllllIlIIIlIlllllIlIlI, lllllllllllllllIlIIIlIllllllIIII, lllllllllllllllIlIIIlIlllllIIlIl, lllllllllllllllIlIIIlIlllllIlIIl, lllllllllllllllIlIIIlIlllllIlIII, lllllllllllllllIlIIIlIlllllIIlll, lllllllllllllllIlIIIlIlllllIlllI, lllllllllllllllIlIIIlIlllllIIIll);
        }
    }
    
    public <T extends Entity> List<T> getPlayers(final Class<? extends T> lllllllllllllllIlIIIIllIIllIIlII, final Predicate<? super T> lllllllllllllllIlIIIIllIIllIIIll) {
        final List<T> lllllllllllllllIlIIIIllIIllIIlll = (List<T>)Lists.newArrayList();
        for (final Entity lllllllllllllllIlIIIIllIIllIIllI : this.playerEntities) {
            if (lllllllllllllllIlIIIIllIIllIIlII.isAssignableFrom(lllllllllllllllIlIIIIllIIllIIllI.getClass()) && lllllllllllllllIlIIIIllIIllIIIll.apply((Object)lllllllllllllllIlIIIIllIIllIIllI)) {
                lllllllllllllllIlIIIIllIIllIIlll.add((T)lllllllllllllllIlIIIIllIIllIIllI);
            }
        }
        return lllllllllllllllIlIIIIllIIllIIlll;
    }
    
    public boolean destroyBlock(final BlockPos lllllllllllllllIlIIIllIlllllllll, final boolean lllllllllllllllIlIIIllIllllllIIl) {
        final IBlockState lllllllllllllllIlIIIllIlllllllIl = this.getBlockState(lllllllllllllllIlIIIllIlllllllll);
        final Block lllllllllllllllIlIIIllIlllllllII = lllllllllllllllIlIIIllIlllllllIl.getBlock();
        if (lllllllllllllllIlIIIllIlllllllIl.getMaterial() == Material.AIR) {
            return false;
        }
        this.playEvent(2001, lllllllllllllllIlIIIllIlllllllll, Block.getStateId(lllllllllllllllIlIIIllIlllllllIl));
        if (lllllllllllllllIlIIIllIllllllIIl) {
            lllllllllllllllIlIIIllIlllllllII.dropBlockAsItem(this, lllllllllllllllIlIIIllIlllllllll, lllllllllllllllIlIIIllIlllllllIl, 0);
        }
        return this.setBlockState(lllllllllllllllIlIIIllIlllllllll, Blocks.AIR.getDefaultState(), 3);
    }
    
    @Nullable
    public List<NextTickListEntry> getPendingBlockUpdates(final StructureBoundingBox lllllllllllllllIlIIIIllIlIlIllIl, final boolean lllllllllllllllIlIIIIllIlIlIllII) {
        return null;
    }
    
    public long getWorldTime() {
        return this.worldInfo.getWorldTime();
    }
    
    public GameRules getGameRules() {
        return this.worldInfo.getGameRulesInstance();
    }
    
    public boolean isMaterialInBB(final AxisAlignedBB lllllllllllllllIlIIIlIIIlIIIllII, final Material lllllllllllllllIlIIIlIIIIllllllI) {
        final int lllllllllllllllIlIIIlIIIlIIIlIlI = MathHelper.floor(lllllllllllllllIlIIIlIIIlIIIllII.minX);
        final int lllllllllllllllIlIIIlIIIlIIIlIIl = MathHelper.ceil(lllllllllllllllIlIIIlIIIlIIIllII.maxX);
        final int lllllllllllllllIlIIIlIIIlIIIlIII = MathHelper.floor(lllllllllllllllIlIIIlIIIlIIIllII.minY);
        final int lllllllllllllllIlIIIlIIIlIIIIlll = MathHelper.ceil(lllllllllllllllIlIIIlIIIlIIIllII.maxY);
        final int lllllllllllllllIlIIIlIIIlIIIIllI = MathHelper.floor(lllllllllllllllIlIIIlIIIlIIIllII.minZ);
        final int lllllllllllllllIlIIIlIIIlIIIIlIl = MathHelper.ceil(lllllllllllllllIlIIIlIIIlIIIllII.maxZ);
        final BlockPos.PooledMutableBlockPos lllllllllllllllIlIIIlIIIlIIIIlII = BlockPos.PooledMutableBlockPos.retain();
        for (int lllllllllllllllIlIIIlIIIlIIIIIll = lllllllllllllllIlIIIlIIIlIIIlIlI; lllllllllllllllIlIIIlIIIlIIIIIll < lllllllllllllllIlIIIlIIIlIIIlIIl; ++lllllllllllllllIlIIIlIIIlIIIIIll) {
            for (int lllllllllllllllIlIIIlIIIlIIIIIlI = lllllllllllllllIlIIIlIIIlIIIlIII; lllllllllllllllIlIIIlIIIlIIIIIlI < lllllllllllllllIlIIIlIIIlIIIIlll; ++lllllllllllllllIlIIIlIIIlIIIIIlI) {
                for (int lllllllllllllllIlIIIlIIIlIIIIIIl = lllllllllllllllIlIIIlIIIlIIIIllI; lllllllllllllllIlIIIlIIIlIIIIIIl < lllllllllllllllIlIIIlIIIlIIIIlIl; ++lllllllllllllllIlIIIlIIIlIIIIIIl) {
                    if (this.getBlockState(lllllllllllllllIlIIIlIIIlIIIIlII.setPos(lllllllllllllllIlIIIlIIIlIIIIIll, lllllllllllllllIlIIIlIIIlIIIIIlI, lllllllllllllllIlIIIlIIIlIIIIIIl)).getMaterial() == lllllllllllllllIlIIIlIIIIllllllI) {
                        lllllllllllllllIlIIIlIIIlIIIIlII.release();
                        return true;
                    }
                }
            }
        }
        lllllllllllllllIlIIIlIIIlIIIIlII.release();
        return false;
    }
    
    public boolean canSnowAt(final BlockPos lllllllllllllllIlIIIIlllIlIIlllI, final boolean lllllllllllllllIlIIIIlllIlIIIlll) {
        final Biome lllllllllllllllIlIIIIlllIlIIllII = this.getBiome(lllllllllllllllIlIIIIlllIlIIlllI);
        final float lllllllllllllllIlIIIIlllIlIIlIll = lllllllllllllllIlIIIIlllIlIIllII.getFloatTemperature(lllllllllllllllIlIIIIlllIlIIlllI);
        if (lllllllllllllllIlIIIIlllIlIIlIll >= 0.15f) {
            return false;
        }
        if (!lllllllllllllllIlIIIIlllIlIIIlll) {
            return true;
        }
        if (lllllllllllllllIlIIIIlllIlIIlllI.getY() >= 0 && lllllllllllllllIlIIIIlllIlIIlllI.getY() < 256 && this.getLightFor(EnumSkyBlock.BLOCK, lllllllllllllllIlIIIIlllIlIIlllI) < 10) {
            final IBlockState lllllllllllllllIlIIIIlllIlIIlIlI = this.getBlockState(lllllllllllllllIlIIIIlllIlIIlllI);
            if (lllllllllllllllIlIIIIlllIlIIlIlI.getMaterial() == Material.AIR && Blocks.SNOW_LAYER.canPlaceBlockAt(this, lllllllllllllllIlIIIIlllIlIIlllI)) {
                return true;
            }
        }
        return false;
    }
    
    public float getCelestialAngle(final float lllllllllllllllIlIIIlIlIIIlllIlI) {
        return this.provider.calculateCelestialAngle(this.worldInfo.getWorldTime(), lllllllllllllllIlIIIlIlIIIlllIlI);
    }
    
    protected World(final ISaveHandler lllllllllllllllIlIIIllllIIllIllI, final WorldInfo lllllllllllllllIlIIIllllIIlIllll, final WorldProvider lllllllllllllllIlIIIllllIIllIlII, final Profiler lllllllllllllllIlIIIllllIIllIIll, final boolean lllllllllllllllIlIIIllllIIlIllII) {
        this.seaLevel = 63;
        this.loadedEntityList = (List<Entity>)Lists.newArrayList();
        this.unloadedEntityList = (List<Entity>)Lists.newArrayList();
        this.loadedTileEntityList = (List<TileEntity>)Lists.newArrayList();
        this.tickableTileEntities = (List<TileEntity>)Lists.newArrayList();
        this.addedTileEntityList = (List<TileEntity>)Lists.newArrayList();
        this.tileEntitiesToBeRemoved = (List<TileEntity>)Lists.newArrayList();
        this.playerEntities = (List<EntityPlayer>)Lists.newArrayList();
        this.weatherEffects = (List<Entity>)Lists.newArrayList();
        this.entitiesById = new IntHashMap<Entity>();
        this.updateLCG = new Random().nextInt();
        this.rand = new Random();
        this.pathListener = new PathWorldListener();
        this.eventListeners = (List<IWorldEventListener>)Lists.newArrayList((Object[])new IWorldEventListener[] { this.pathListener });
        this.theCalendar = Calendar.getInstance();
        this.worldScoreboard = new Scoreboard();
        this.spawnHostileMobs = true;
        this.spawnPeacefulMobs = true;
        this.lightUpdateBlockList = new int[32768];
        this.saveHandler = lllllllllllllllIlIIIllllIIllIllI;
        this.theProfiler = lllllllllllllllIlIIIllllIIllIIll;
        this.worldInfo = lllllllllllllllIlIIIllllIIlIllll;
        this.provider = lllllllllllllllIlIIIllllIIllIlII;
        this.isRemote = lllllllllllllllIlIIIllllIIlIllII;
        this.worldBorder = lllllllllllllllIlIIIllllIIllIlII.createWorldBorder();
    }
    
    public boolean checkNoEntityCollision(final AxisAlignedBB lllllllllllllllIlIIIlIIlIlIlllII) {
        return this.checkNoEntityCollision(lllllllllllllllIlIIIlIIlIlIlllII, null);
    }
    
    public boolean func_191503_g(final Entity lllllllllllllllIlIIIlIlIlIlIIIlI) {
        double lllllllllllllllIlIIIlIlIlIlIIIIl = this.worldBorder.minX();
        double lllllllllllllllIlIIIlIlIlIlIIIII = this.worldBorder.minZ();
        double lllllllllllllllIlIIIlIlIlIIlllll = this.worldBorder.maxX();
        double lllllllllllllllIlIIIlIlIlIIllllI = this.worldBorder.maxZ();
        if (lllllllllllllllIlIIIlIlIlIlIIIlI.isOutsideBorder()) {
            ++lllllllllllllllIlIIIlIlIlIlIIIIl;
            ++lllllllllllllllIlIIIlIlIlIlIIIII;
            --lllllllllllllllIlIIIlIlIlIIlllll;
            --lllllllllllllllIlIIIlIlIlIIllllI;
        }
        else {
            --lllllllllllllllIlIIIlIlIlIlIIIIl;
            --lllllllllllllllIlIIIlIlIlIlIIIII;
            ++lllllllllllllllIlIIIlIlIlIIlllll;
            ++lllllllllllllllIlIIIlIlIlIIllllI;
        }
        return lllllllllllllllIlIIIlIlIlIlIIIlI.posX > lllllllllllllllIlIIIlIlIlIlIIIIl && lllllllllllllllIlIIIlIlIlIlIIIlI.posX < lllllllllllllllIlIIIlIlIlIIlllll && lllllllllllllllIlIIIlIlIlIlIIIlI.posZ > lllllllllllllllIlIIIlIlIlIlIIIII && lllllllllllllllIlIIIlIlIlIlIIIlI.posZ < lllllllllllllllIlIIIlIlIlIIllllI;
    }
    
    public Vec3d getSkyColor(final Entity lllllllllllllllIlIIIlIlIIllIIlIl, final float lllllllllllllllIlIIIlIlIIlIIlllI) {
        final float lllllllllllllllIlIIIlIlIIllIIIll = this.getCelestialAngle(lllllllllllllllIlIIIlIlIIlIIlllI);
        float lllllllllllllllIlIIIlIlIIllIIIlI = MathHelper.cos(lllllllllllllllIlIIIlIlIIllIIIll * 6.2831855f) * 2.0f + 0.5f;
        lllllllllllllllIlIIIlIlIIllIIIlI = MathHelper.clamp(lllllllllllllllIlIIIlIlIIllIIIlI, 0.0f, 1.0f);
        final int lllllllllllllllIlIIIlIlIIllIIIIl = MathHelper.floor(lllllllllllllllIlIIIlIlIIllIIlIl.posX);
        final int lllllllllllllllIlIIIlIlIIllIIIII = MathHelper.floor(lllllllllllllllIlIIIlIlIIllIIlIl.posY);
        final int lllllllllllllllIlIIIlIlIIlIlllll = MathHelper.floor(lllllllllllllllIlIIIlIlIIllIIlIl.posZ);
        final BlockPos lllllllllllllllIlIIIlIlIIlIllllI = new BlockPos(lllllllllllllllIlIIIlIlIIllIIIIl, lllllllllllllllIlIIIlIlIIllIIIII, lllllllllllllllIlIIIlIlIIlIlllll);
        final Biome lllllllllllllllIlIIIlIlIIlIlllIl = this.getBiome(lllllllllllllllIlIIIlIlIIlIllllI);
        final float lllllllllllllllIlIIIlIlIIlIlllII = lllllllllllllllIlIIIlIlIIlIlllIl.getFloatTemperature(lllllllllllllllIlIIIlIlIIlIllllI);
        final int lllllllllllllllIlIIIlIlIIlIllIll = lllllllllllllllIlIIIlIlIIlIlllIl.getSkyColorByTemp(lllllllllllllllIlIIIlIlIIlIlllII);
        float lllllllllllllllIlIIIlIlIIlIllIlI = (lllllllllllllllIlIIIlIlIIlIllIll >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllIlIIIlIlIIlIllIIl = (lllllllllllllllIlIIIlIlIIlIllIll >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllIlIIIlIlIIlIllIII = (lllllllllllllllIlIIIlIlIIlIllIll & 0xFF) / 255.0f;
        lllllllllllllllIlIIIlIlIIlIllIlI *= lllllllllllllllIlIIIlIlIIllIIIlI;
        lllllllllllllllIlIIIlIlIIlIllIIl *= lllllllllllllllIlIIIlIlIIllIIIlI;
        lllllllllllllllIlIIIlIlIIlIllIII *= lllllllllllllllIlIIIlIlIIllIIIlI;
        final float lllllllllllllllIlIIIlIlIIlIlIlll = this.getRainStrength(lllllllllllllllIlIIIlIlIIlIIlllI);
        if (lllllllllllllllIlIIIlIlIIlIlIlll > 0.0f) {
            final float lllllllllllllllIlIIIlIlIIlIlIllI = (lllllllllllllllIlIIIlIlIIlIllIlI * 0.3f + lllllllllllllllIlIIIlIlIIlIllIIl * 0.59f + lllllllllllllllIlIIIlIlIIlIllIII * 0.11f) * 0.6f;
            final float lllllllllllllllIlIIIlIlIIlIlIlIl = 1.0f - lllllllllllllllIlIIIlIlIIlIlIlll * 0.75f;
            lllllllllllllllIlIIIlIlIIlIllIlI = lllllllllllllllIlIIIlIlIIlIllIlI * lllllllllllllllIlIIIlIlIIlIlIlIl + lllllllllllllllIlIIIlIlIIlIlIllI * (1.0f - lllllllllllllllIlIIIlIlIIlIlIlIl);
            lllllllllllllllIlIIIlIlIIlIllIIl = lllllllllllllllIlIIIlIlIIlIllIIl * lllllllllllllllIlIIIlIlIIlIlIlIl + lllllllllllllllIlIIIlIlIIlIlIllI * (1.0f - lllllllllllllllIlIIIlIlIIlIlIlIl);
            lllllllllllllllIlIIIlIlIIlIllIII = lllllllllllllllIlIIIlIlIIlIllIII * lllllllllllllllIlIIIlIlIIlIlIlIl + lllllllllllllllIlIIIlIlIIlIlIllI * (1.0f - lllllllllllllllIlIIIlIlIIlIlIlIl);
        }
        final float lllllllllllllllIlIIIlIlIIlIlIlII = this.getThunderStrength(lllllllllllllllIlIIIlIlIIlIIlllI);
        if (lllllllllllllllIlIIIlIlIIlIlIlII > 0.0f) {
            final float lllllllllllllllIlIIIlIlIIlIlIIll = (lllllllllllllllIlIIIlIlIIlIllIlI * 0.3f + lllllllllllllllIlIIIlIlIIlIllIIl * 0.59f + lllllllllllllllIlIIIlIlIIlIllIII * 0.11f) * 0.2f;
            final float lllllllllllllllIlIIIlIlIIlIlIIlI = 1.0f - lllllllllllllllIlIIIlIlIIlIlIlII * 0.75f;
            lllllllllllllllIlIIIlIlIIlIllIlI = lllllllllllllllIlIIIlIlIIlIllIlI * lllllllllllllllIlIIIlIlIIlIlIIlI + lllllllllllllllIlIIIlIlIIlIlIIll * (1.0f - lllllllllllllllIlIIIlIlIIlIlIIlI);
            lllllllllllllllIlIIIlIlIIlIllIIl = lllllllllllllllIlIIIlIlIIlIllIIl * lllllllllllllllIlIIIlIlIIlIlIIlI + lllllllllllllllIlIIIlIlIIlIlIIll * (1.0f - lllllllllllllllIlIIIlIlIIlIlIIlI);
            lllllllllllllllIlIIIlIlIIlIllIII = lllllllllllllllIlIIIlIlIIlIllIII * lllllllllllllllIlIIIlIlIIlIlIIlI + lllllllllllllllIlIIIlIlIIlIlIIll * (1.0f - lllllllllllllllIlIIIlIlIIlIlIIlI);
        }
        if (this.lastLightningBolt > 0) {
            float lllllllllllllllIlIIIlIlIIlIlIIIl = this.lastLightningBolt - lllllllllllllllIlIIIlIlIIlIIlllI;
            if (lllllllllllllllIlIIIlIlIIlIlIIIl > 1.0f) {
                lllllllllllllllIlIIIlIlIIlIlIIIl = 1.0f;
            }
            lllllllllllllllIlIIIlIlIIlIlIIIl *= 0.45f;
            lllllllllllllllIlIIIlIlIIlIllIlI = lllllllllllllllIlIIIlIlIIlIllIlI * (1.0f - lllllllllllllllIlIIIlIlIIlIlIIIl) + 0.8f * lllllllllllllllIlIIIlIlIIlIlIIIl;
            lllllllllllllllIlIIIlIlIIlIllIIl = lllllllllllllllIlIIIlIlIIlIllIIl * (1.0f - lllllllllllllllIlIIIlIlIIlIlIIIl) + 0.8f * lllllllllllllllIlIIIlIlIIlIlIIIl;
            lllllllllllllllIlIIIlIlIIlIllIII = lllllllllllllllIlIIIlIlIIlIllIII * (1.0f - lllllllllllllllIlIIIlIlIIlIlIIIl) + 1.0f * lllllllllllllllIlIIIlIlIIlIlIIIl;
        }
        return new Vec3d(lllllllllllllllIlIIIlIlIIlIllIlI, lllllllllllllllIlIIIlIlIIlIllIIl, lllllllllllllllIlIIIlIlIIlIllIII);
    }
    
    public boolean setBlockState(final BlockPos lllllllllllllllIlIIIlllIIIIllIII, final IBlockState lllllllllllllllIlIIIlllIIIIlIlll, final int lllllllllllllllIlIIIlllIIIIlIllI) {
        if (this.isOutsideBuildHeight(lllllllllllllllIlIIIlllIIIIllIII)) {
            return false;
        }
        if (!this.isRemote && this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            return false;
        }
        final Chunk lllllllllllllllIlIIIlllIIIIlIlIl = this.getChunkFromBlockCoords(lllllllllllllllIlIIIlllIIIIllIII);
        final Block lllllllllllllllIlIIIlllIIIIlIlII = lllllllllllllllIlIIIlllIIIIlIlll.getBlock();
        final IBlockState lllllllllllllllIlIIIlllIIIIlIIll = lllllllllllllllIlIIIlllIIIIlIlIl.setBlockState(lllllllllllllllIlIIIlllIIIIllIII, lllllllllllllllIlIIIlllIIIIlIlll);
        if (lllllllllllllllIlIIIlllIIIIlIIll == null) {
            return false;
        }
        if (lllllllllllllllIlIIIlllIIIIlIlll.getLightOpacity() != lllllllllllllllIlIIIlllIIIIlIIll.getLightOpacity() || lllllllllllllllIlIIIlllIIIIlIlll.getLightValue() != lllllllllllllllIlIIIlllIIIIlIIll.getLightValue()) {
            this.theProfiler.startSection("checkLight");
            this.checkLight(lllllllllllllllIlIIIlllIIIIllIII);
            this.theProfiler.endSection();
        }
        if ((lllllllllllllllIlIIIlllIIIIlIllI & 0x2) != 0x0 && (!this.isRemote || (lllllllllllllllIlIIIlllIIIIlIllI & 0x4) == 0x0) && lllllllllllllllIlIIIlllIIIIlIlIl.isPopulated()) {
            this.notifyBlockUpdate(lllllllllllllllIlIIIlllIIIIllIII, lllllllllllllllIlIIIlllIIIIlIIll, lllllllllllllllIlIIIlllIIIIlIlll, lllllllllllllllIlIIIlllIIIIlIllI);
        }
        if (!this.isRemote && (lllllllllllllllIlIIIlllIIIIlIllI & 0x1) != 0x0) {
            this.notifyNeighborsRespectDebug(lllllllllllllllIlIIIlllIIIIllIII, lllllllllllllllIlIIIlllIIIIlIIll.getBlock(), true);
            if (lllllllllllllllIlIIIlllIIIIlIlll.hasComparatorInputOverride()) {
                this.updateComparatorOutputLevel(lllllllllllllllIlIIIlllIIIIllIII, lllllllllllllllIlIIIlllIIIIlIlII);
            }
        }
        else if (!this.isRemote && (lllllllllllllllIlIIIlllIIIIlIllI & 0x10) == 0x0) {
            this.func_190522_c(lllllllllllllllIlIIIlllIIIIllIII, lllllllllllllllIlIIIlllIIIIlIlII);
        }
        return true;
    }
    
    public Chunk getChunkFromBlockCoords(final BlockPos lllllllllllllllIlIIIlllIIIllIlIl) {
        return this.getChunkFromChunkCoords(lllllllllllllllIlIIIlllIIIllIlIl.getX() >> 4, lllllllllllllllIlIIIlllIIIllIlIl.getZ() >> 4);
    }
    
    public void playBroadcastSound(final int lllllllllllllllIlIIIIlIIIIIlIlIl, final BlockPos lllllllllllllllIlIIIIlIIIIIlIlII, final int lllllllllllllllIlIIIIlIIIIIlIIll) {
        for (int lllllllllllllllIlIIIIlIIIIIlIlll = 0; lllllllllllllllIlIIIIlIIIIIlIlll < this.eventListeners.size(); ++lllllllllllllllIlIIIIlIIIIIlIlll) {
            this.eventListeners.get(lllllllllllllllIlIIIIlIIIIIlIlll).broadcastSound(lllllllllllllllIlIIIIlIIIIIlIlIl, lllllllllllllllIlIIIIlIIIIIlIlII, lllllllllllllllIlIIIIlIIIIIlIIll);
        }
    }
    
    @Deprecated
    public int getChunksLowestHorizon(final int lllllllllllllllIlIIIllIIllllIlII, final int lllllllllllllllIlIIIllIIllllIIll) {
        if (lllllllllllllllIlIIIllIIllllIlII < -30000000 || lllllllllllllllIlIIIllIIllllIIll < -30000000 || lllllllllllllllIlIIIllIIllllIlII >= 30000000 || lllllllllllllllIlIIIllIIllllIIll >= 30000000) {
            return this.getSeaLevel() + 1;
        }
        if (!this.isChunkLoaded(lllllllllllllllIlIIIllIIllllIlII >> 4, lllllllllllllllIlIIIllIIllllIIll >> 4, true)) {
            return 0;
        }
        final Chunk lllllllllllllllIlIIIllIIllllIIlI = this.getChunkFromChunkCoords(lllllllllllllllIlIIIllIIllllIlII >> 4, lllllllllllllllIlIIIllIIllllIIll >> 4);
        return lllllllllllllllIlIIIllIIllllIIlI.getLowestHeight();
    }
    
    public int getLightFor(final EnumSkyBlock lllllllllllllllIlIIIllIIllIIllll, BlockPos lllllllllllllllIlIIIllIIllIIlIlI) {
        if (((Vec3i)lllllllllllllllIlIIIllIIllIIlIlI).getY() < 0) {
            lllllllllllllllIlIIIllIIllIIlIlI = new BlockPos(((Vec3i)lllllllllllllllIlIIIllIIllIIlIlI).getX(), 0, ((Vec3i)lllllllllllllllIlIIIllIIllIIlIlI).getZ());
        }
        if (!this.isValid((BlockPos)lllllllllllllllIlIIIllIIllIIlIlI)) {
            return lllllllllllllllIlIIIllIIllIIllll.defaultLightValue;
        }
        if (!this.isBlockLoaded((BlockPos)lllllllllllllllIlIIIllIIllIIlIlI)) {
            return lllllllllllllllIlIIIllIIllIIllll.defaultLightValue;
        }
        final Chunk lllllllllllllllIlIIIllIIllIIllIl = this.getChunkFromBlockCoords((BlockPos)lllllllllllllllIlIIIllIIllIIlIlI);
        return lllllllllllllllIlIIIllIIllIIllIl.getLightFor(lllllllllllllllIlIIIllIIllIIllll, (BlockPos)lllllllllllllllIlIIIllIIllIIlIlI);
    }
    
    @Nullable
    public EntityPlayer getClosestPlayerToEntity(final Entity lllllllllllllllIlIIIIlIlIllllllI, final double lllllllllllllllIlIIIIlIlIllllIlI) {
        return this.getClosestPlayer(lllllllllllllllIlIIIIlIlIllllllI.posX, lllllllllllllllIlIIIIlIlIllllllI.posY, lllllllllllllllIlIIIIlIlIllllllI.posZ, lllllllllllllllIlIIIIlIlIllllIlI, false);
    }
    
    private boolean func_191504_a(@Nullable final Entity lllllllllllllllIlIIIlIlIllllIIlI, final AxisAlignedBB lllllllllllllllIlIIIlIlIllllIIIl, final boolean lllllllllllllllIlIIIlIlIllIlIlll, @Nullable final List<AxisAlignedBB> lllllllllllllllIlIIIlIlIlllIllll) {
        final int lllllllllllllllIlIIIlIlIlllIlllI = MathHelper.floor(lllllllllllllllIlIIIlIlIllllIIIl.minX) - 1;
        final int lllllllllllllllIlIIIlIlIlllIllIl = MathHelper.ceil(lllllllllllllllIlIIIlIlIllllIIIl.maxX) + 1;
        final int lllllllllllllllIlIIIlIlIlllIllII = MathHelper.floor(lllllllllllllllIlIIIlIlIllllIIIl.minY) - 1;
        final int lllllllllllllllIlIIIlIlIlllIlIll = MathHelper.ceil(lllllllllllllllIlIIIlIlIllllIIIl.maxY) + 1;
        final int lllllllllllllllIlIIIlIlIlllIlIlI = MathHelper.floor(lllllllllllllllIlIIIlIlIllllIIIl.minZ) - 1;
        final int lllllllllllllllIlIIIlIlIlllIlIIl = MathHelper.ceil(lllllllllllllllIlIIIlIlIllllIIIl.maxZ) + 1;
        final WorldBorder lllllllllllllllIlIIIlIlIlllIlIII = this.getWorldBorder();
        final boolean lllllllllllllllIlIIIlIlIlllIIlll = lllllllllllllllIlIIIlIlIllllIIlI != null && lllllllllllllllIlIIIlIlIllllIIlI.isOutsideBorder();
        final boolean lllllllllllllllIlIIIlIlIlllIIllI = lllllllllllllllIlIIIlIlIllllIIlI != null && this.func_191503_g(lllllllllllllllIlIIIlIlIllllIIlI);
        final IBlockState lllllllllllllllIlIIIlIlIlllIIlIl = Blocks.STONE.getDefaultState();
        final BlockPos.PooledMutableBlockPos lllllllllllllllIlIIIlIlIlllIIlII = BlockPos.PooledMutableBlockPos.retain();
        try {
            for (int lllllllllllllllIlIIIlIlIlllIIIll = lllllllllllllllIlIIIlIlIlllIlllI; lllllllllllllllIlIIIlIlIlllIIIll < lllllllllllllllIlIIIlIlIlllIllIl; ++lllllllllllllllIlIIIlIlIlllIIIll) {
                for (int lllllllllllllllIlIIIlIlIlllIIIlI = lllllllllllllllIlIIIlIlIlllIlIlI; lllllllllllllllIlIIIlIlIlllIIIlI < lllllllllllllllIlIIIlIlIlllIlIIl; ++lllllllllllllllIlIIIlIlIlllIIIlI) {
                    final boolean lllllllllllllllIlIIIlIlIlllIIIIl = lllllllllllllllIlIIIlIlIlllIIIll == lllllllllllllllIlIIIlIlIlllIlllI || lllllllllllllllIlIIIlIlIlllIIIll == lllllllllllllllIlIIIlIlIlllIllIl - 1;
                    final boolean lllllllllllllllIlIIIlIlIlllIIIII = lllllllllllllllIlIIIlIlIlllIIIlI == lllllllllllllllIlIIIlIlIlllIlIlI || lllllllllllllllIlIIIlIlIlllIIIlI == lllllllllllllllIlIIIlIlIlllIlIIl - 1;
                    if ((!lllllllllllllllIlIIIlIlIlllIIIIl || !lllllllllllllllIlIIIlIlIlllIIIII) && this.isBlockLoaded(lllllllllllllllIlIIIlIlIlllIIlII.setPos(lllllllllllllllIlIIIlIlIlllIIIll, 64, lllllllllllllllIlIIIlIlIlllIIIlI))) {
                        for (int lllllllllllllllIlIIIlIlIllIlllll = lllllllllllllllIlIIIlIlIlllIllII; lllllllllllllllIlIIIlIlIllIlllll < lllllllllllllllIlIIIlIlIlllIlIll; ++lllllllllllllllIlIIIlIlIllIlllll) {
                            if ((!lllllllllllllllIlIIIlIlIlllIIIIl && !lllllllllllllllIlIIIlIlIlllIIIII) || lllllllllllllllIlIIIlIlIllIlllll != lllllllllllllllIlIIIlIlIlllIlIll - 1) {
                                if (lllllllllllllllIlIIIlIlIllIlIlll) {
                                    if (lllllllllllllllIlIIIlIlIlllIIIll < -30000000 || lllllllllllllllIlIIIlIlIlllIIIll >= 30000000 || lllllllllllllllIlIIIlIlIlllIIIlI < -30000000 || lllllllllllllllIlIIIlIlIlllIIIlI >= 30000000) {
                                        final double lllllllllllllllIlIIIlIlIllIIIIlI;
                                        final boolean lllllllllllllllIlIIIlIlIllIllllI = (lllllllllllllllIlIIIlIlIllIIIIlI = 1) != 0.0;
                                        return lllllllllllllllIlIIIlIlIllIIIIlI != 0.0;
                                    }
                                }
                                else if (lllllllllllllllIlIIIlIlIllllIIlI != null && lllllllllllllllIlIIIlIlIlllIIlll == lllllllllllllllIlIIIlIlIlllIIllI) {
                                    lllllllllllllllIlIIIlIlIllllIIlI.setOutsideBorder(!lllllllllllllllIlIIIlIlIlllIIllI);
                                }
                                lllllllllllllllIlIIIlIlIlllIIlII.setPos(lllllllllllllllIlIIIlIlIlllIIIll, lllllllllllllllIlIIIlIlIllIlllll, lllllllllllllllIlIIIlIlIlllIIIlI);
                                IBlockState lllllllllllllllIlIIIlIlIllIlllII = null;
                                if (!lllllllllllllllIlIIIlIlIllIlIlll && !lllllllllllllllIlIIIlIlIlllIlIII.contains(lllllllllllllllIlIIIlIlIlllIIlII) && lllllllllllllllIlIIIlIlIlllIIllI) {
                                    final IBlockState lllllllllllllllIlIIIlIlIllIlllIl = lllllllllllllllIlIIIlIlIlllIIlIl;
                                }
                                else {
                                    lllllllllllllllIlIIIlIlIllIlllII = this.getBlockState(lllllllllllllllIlIIIlIlIlllIIlII);
                                }
                                lllllllllllllllIlIIIlIlIllIlllII.addCollisionBoxToList(this, lllllllllllllllIlIIIlIlIlllIIlII, lllllllllllllllIlIIIlIlIllllIIIl, lllllllllllllllIlIIIlIlIlllIllll, lllllllllllllllIlIIIlIlIllllIIlI, false);
                                if (lllllllllllllllIlIIIlIlIllIlIlll && !lllllllllllllllIlIIIlIlIlllIllll.isEmpty()) {
                                    final double lllllllllllllllIlIIIlIlIllIIIIlI;
                                    final boolean lllllllllllllllIlIIIlIlIllIllIll = (lllllllllllllllIlIIIlIlIllIIIIlI = 1) != 0.0;
                                    return lllllllllllllllIlIIIlIlIllIIIIlI != 0.0;
                                }
                            }
                        }
                    }
                }
            }
        }
        finally {
            lllllllllllllllIlIIIlIlIlllIIlII.release();
        }
        lllllllllllllllIlIIIlIlIlllIIlII.release();
        return !lllllllllllllllIlIIIlIlIlllIllll.isEmpty();
    }
    
    @Nullable
    public RayTraceResult rayTraceBlocks(Vec3d lllllllllllllllIlIIIllIIIIllIlII, final Vec3d lllllllllllllllIlIIIllIIIlIlIlll, final boolean lllllllllllllllIlIIIllIIIlIlIllI, final boolean lllllllllllllllIlIIIllIIIlIlIlIl, final boolean lllllllllllllllIlIIIllIIIIllIIII) {
        if (Double.isNaN(lllllllllllllllIlIIIllIIIIllIlII.xCoord) || Double.isNaN(lllllllllllllllIlIIIllIIIIllIlII.yCoord) || Double.isNaN(lllllllllllllllIlIIIllIIIIllIlII.zCoord)) {
            return null;
        }
        if (!Double.isNaN(lllllllllllllllIlIIIllIIIlIlIlll.xCoord) && !Double.isNaN(lllllllllllllllIlIIIllIIIlIlIlll.yCoord) && !Double.isNaN(lllllllllllllllIlIIIllIIIlIlIlll.zCoord)) {
            final int lllllllllllllllIlIIIllIIIlIlIIll = MathHelper.floor(lllllllllllllllIlIIIllIIIlIlIlll.xCoord);
            final int lllllllllllllllIlIIIllIIIlIlIIlI = MathHelper.floor(lllllllllllllllIlIIIllIIIlIlIlll.yCoord);
            final int lllllllllllllllIlIIIllIIIlIlIIIl = MathHelper.floor(lllllllllllllllIlIIIllIIIlIlIlll.zCoord);
            int lllllllllllllllIlIIIllIIIlIlIIII = MathHelper.floor(lllllllllllllllIlIIIllIIIIllIlII.xCoord);
            int lllllllllllllllIlIIIllIIIlIIllll = MathHelper.floor(lllllllllllllllIlIIIllIIIIllIlII.yCoord);
            int lllllllllllllllIlIIIllIIIlIIlllI = MathHelper.floor(lllllllllllllllIlIIIllIIIIllIlII.zCoord);
            BlockPos lllllllllllllllIlIIIllIIIlIIllIl = new BlockPos(lllllllllllllllIlIIIllIIIlIlIIII, lllllllllllllllIlIIIllIIIlIIllll, lllllllllllllllIlIIIllIIIlIIlllI);
            final IBlockState lllllllllllllllIlIIIllIIIlIIllII = this.getBlockState(lllllllllllllllIlIIIllIIIlIIllIl);
            final Block lllllllllllllllIlIIIllIIIlIIlIll = lllllllllllllllIlIIIllIIIlIIllII.getBlock();
            if ((!lllllllllllllllIlIIIllIIIlIlIlIl || lllllllllllllllIlIIIllIIIlIIllII.getCollisionBoundingBox(this, lllllllllllllllIlIIIllIIIlIIllIl) != Block.NULL_AABB) && lllllllllllllllIlIIIllIIIlIIlIll.canCollideCheck(lllllllllllllllIlIIIllIIIlIIllII, lllllllllllllllIlIIIllIIIlIlIllI)) {
                final RayTraceResult lllllllllllllllIlIIIllIIIlIIlIlI = lllllllllllllllIlIIIllIIIlIIllII.collisionRayTrace(this, lllllllllllllllIlIIIllIIIlIIllIl, lllllllllllllllIlIIIllIIIIllIlII, lllllllllllllllIlIIIllIIIlIlIlll);
                if (lllllllllllllllIlIIIllIIIlIIlIlI != null) {
                    return lllllllllllllllIlIIIllIIIlIIlIlI;
                }
            }
            RayTraceResult lllllllllllllllIlIIIllIIIlIIlIIl = null;
            int lllllllllllllllIlIIIllIIIlIIlIII = 200;
            while (lllllllllllllllIlIIIllIIIlIIlIII-- >= 0) {
                if (Double.isNaN(lllllllllllllllIlIIIllIIIIllIlII.xCoord) || Double.isNaN(lllllllllllllllIlIIIllIIIIllIlII.yCoord) || Double.isNaN(lllllllllllllllIlIIIllIIIIllIlII.zCoord)) {
                    return null;
                }
                if (lllllllllllllllIlIIIllIIIlIlIIII == lllllllllllllllIlIIIllIIIlIlIIll && lllllllllllllllIlIIIllIIIlIIllll == lllllllllllllllIlIIIllIIIlIlIIlI && lllllllllllllllIlIIIllIIIlIIlllI == lllllllllllllllIlIIIllIIIlIlIIIl) {
                    return lllllllllllllllIlIIIllIIIIllIIII ? lllllllllllllllIlIIIllIIIlIIlIIl : null;
                }
                boolean lllllllllllllllIlIIIllIIIlIIIlll = true;
                boolean lllllllllllllllIlIIIllIIIlIIIllI = true;
                boolean lllllllllllllllIlIIIllIIIlIIIlIl = true;
                double lllllllllllllllIlIIIllIIIlIIIlII = 999.0;
                double lllllllllllllllIlIIIllIIIlIIIIll = 999.0;
                double lllllllllllllllIlIIIllIIIlIIIIlI = 999.0;
                if (lllllllllllllllIlIIIllIIIlIlIIll > lllllllllllllllIlIIIllIIIlIlIIII) {
                    lllllllllllllllIlIIIllIIIlIIIlII = lllllllllllllllIlIIIllIIIlIlIIII + 1.0;
                }
                else if (lllllllllllllllIlIIIllIIIlIlIIll < lllllllllllllllIlIIIllIIIlIlIIII) {
                    lllllllllllllllIlIIIllIIIlIIIlII = lllllllllllllllIlIIIllIIIlIlIIII + 0.0;
                }
                else {
                    lllllllllllllllIlIIIllIIIlIIIlll = false;
                }
                if (lllllllllllllllIlIIIllIIIlIlIIlI > lllllllllllllllIlIIIllIIIlIIllll) {
                    lllllllllllllllIlIIIllIIIlIIIIll = lllllllllllllllIlIIIllIIIlIIllll + 1.0;
                }
                else if (lllllllllllllllIlIIIllIIIlIlIIlI < lllllllllllllllIlIIIllIIIlIIllll) {
                    lllllllllllllllIlIIIllIIIlIIIIll = lllllllllllllllIlIIIllIIIlIIllll + 0.0;
                }
                else {
                    lllllllllllllllIlIIIllIIIlIIIllI = false;
                }
                if (lllllllllllllllIlIIIllIIIlIlIIIl > lllllllllllllllIlIIIllIIIlIIlllI) {
                    lllllllllllllllIlIIIllIIIlIIIIlI = lllllllllllllllIlIIIllIIIlIIlllI + 1.0;
                }
                else if (lllllllllllllllIlIIIllIIIlIlIIIl < lllllllllllllllIlIIIllIIIlIIlllI) {
                    lllllllllllllllIlIIIllIIIlIIIIlI = lllllllllllllllIlIIIllIIIlIIlllI + 0.0;
                }
                else {
                    lllllllllllllllIlIIIllIIIlIIIlIl = false;
                }
                double lllllllllllllllIlIIIllIIIlIIIIIl = 999.0;
                double lllllllllllllllIlIIIllIIIlIIIIII = 999.0;
                double lllllllllllllllIlIIIllIIIIllllll = 999.0;
                final double lllllllllllllllIlIIIllIIIIlllllI = lllllllllllllllIlIIIllIIIlIlIlll.xCoord - lllllllllllllllIlIIIllIIIIllIlII.xCoord;
                final double lllllllllllllllIlIIIllIIIIllllIl = lllllllllllllllIlIIIllIIIlIlIlll.yCoord - lllllllllllllllIlIIIllIIIIllIlII.yCoord;
                final double lllllllllllllllIlIIIllIIIIllllII = lllllllllllllllIlIIIllIIIlIlIlll.zCoord - lllllllllllllllIlIIIllIIIIllIlII.zCoord;
                if (lllllllllllllllIlIIIllIIIlIIIlll) {
                    lllllllllllllllIlIIIllIIIlIIIIIl = (lllllllllllllllIlIIIllIIIlIIIlII - lllllllllllllllIlIIIllIIIIllIlII.xCoord) / lllllllllllllllIlIIIllIIIIlllllI;
                }
                if (lllllllllllllllIlIIIllIIIlIIIllI) {
                    lllllllllllllllIlIIIllIIIlIIIIII = (lllllllllllllllIlIIIllIIIlIIIIll - lllllllllllllllIlIIIllIIIIllIlII.yCoord) / lllllllllllllllIlIIIllIIIIllllIl;
                }
                if (lllllllllllllllIlIIIllIIIlIIIlIl) {
                    lllllllllllllllIlIIIllIIIIllllll = (lllllllllllllllIlIIIllIIIlIIIIlI - lllllllllllllllIlIIIllIIIIllIlII.zCoord) / lllllllllllllllIlIIIllIIIIllllII;
                }
                if (lllllllllllllllIlIIIllIIIlIIIIIl == -0.0) {
                    lllllllllllllllIlIIIllIIIlIIIIIl = -1.0E-4;
                }
                if (lllllllllllllllIlIIIllIIIlIIIIII == -0.0) {
                    lllllllllllllllIlIIIllIIIlIIIIII = -1.0E-4;
                }
                if (lllllllllllllllIlIIIllIIIIllllll == -0.0) {
                    lllllllllllllllIlIIIllIIIIllllll = -1.0E-4;
                }
                EnumFacing lllllllllllllllIlIIIllIIIIlllIIl = null;
                if (lllllllllllllllIlIIIllIIIlIIIIIl < lllllllllllllllIlIIIllIIIlIIIIII && lllllllllllllllIlIIIllIIIlIIIIIl < lllllllllllllllIlIIIllIIIIllllll) {
                    final EnumFacing lllllllllllllllIlIIIllIIIIlllIll = (lllllllllllllllIlIIIllIIIlIlIIll > lllllllllllllllIlIIIllIIIlIlIIII) ? EnumFacing.WEST : EnumFacing.EAST;
                    lllllllllllllllIlIIIllIIIIllIlII = new Vec3d(lllllllllllllllIlIIIllIIIlIIIlII, lllllllllllllllIlIIIllIIIIllIlII.yCoord + lllllllllllllllIlIIIllIIIIllllIl * lllllllllllllllIlIIIllIIIlIIIIIl, lllllllllllllllIlIIIllIIIIllIlII.zCoord + lllllllllllllllIlIIIllIIIIllllII * lllllllllllllllIlIIIllIIIlIIIIIl);
                }
                else if (lllllllllllllllIlIIIllIIIlIIIIII < lllllllllllllllIlIIIllIIIIllllll) {
                    final EnumFacing lllllllllllllllIlIIIllIIIIlllIlI = (lllllllllllllllIlIIIllIIIlIlIIlI > lllllllllllllllIlIIIllIIIlIIllll) ? EnumFacing.DOWN : EnumFacing.UP;
                    lllllllllllllllIlIIIllIIIIllIlII = new Vec3d(lllllllllllllllIlIIIllIIIIllIlII.xCoord + lllllllllllllllIlIIIllIIIIlllllI * lllllllllllllllIlIIIllIIIlIIIIII, lllllllllllllllIlIIIllIIIlIIIIll, lllllllllllllllIlIIIllIIIIllIlII.zCoord + lllllllllllllllIlIIIllIIIIllllII * lllllllllllllllIlIIIllIIIlIIIIII);
                }
                else {
                    lllllllllllllllIlIIIllIIIIlllIIl = ((lllllllllllllllIlIIIllIIIlIlIIIl > lllllllllllllllIlIIIllIIIlIIlllI) ? EnumFacing.NORTH : EnumFacing.SOUTH);
                    lllllllllllllllIlIIIllIIIIllIlII = new Vec3d(lllllllllllllllIlIIIllIIIIllIlII.xCoord + lllllllllllllllIlIIIllIIIIlllllI * lllllllllllllllIlIIIllIIIIllllll, lllllllllllllllIlIIIllIIIIllIlII.yCoord + lllllllllllllllIlIIIllIIIIllllIl * lllllllllllllllIlIIIllIIIIllllll, lllllllllllllllIlIIIllIIIlIIIIlI);
                }
                lllllllllllllllIlIIIllIIIlIlIIII = MathHelper.floor(lllllllllllllllIlIIIllIIIIllIlII.xCoord) - ((lllllllllllllllIlIIIllIIIIlllIIl == EnumFacing.EAST) ? 1 : 0);
                lllllllllllllllIlIIIllIIIlIIllll = MathHelper.floor(lllllllllllllllIlIIIllIIIIllIlII.yCoord) - ((lllllllllllllllIlIIIllIIIIlllIIl == EnumFacing.UP) ? 1 : 0);
                lllllllllllllllIlIIIllIIIlIIlllI = MathHelper.floor(lllllllllllllllIlIIIllIIIIllIlII.zCoord) - ((lllllllllllllllIlIIIllIIIIlllIIl == EnumFacing.SOUTH) ? 1 : 0);
                lllllllllllllllIlIIIllIIIlIIllIl = new BlockPos(lllllllllllllllIlIIIllIIIlIlIIII, lllllllllllllllIlIIIllIIIlIIllll, lllllllllllllllIlIIIllIIIlIIlllI);
                final IBlockState lllllllllllllllIlIIIllIIIIlllIII = this.getBlockState(lllllllllllllllIlIIIllIIIlIIllIl);
                final Block lllllllllllllllIlIIIllIIIIllIlll = lllllllllllllllIlIIIllIIIIlllIII.getBlock();
                if (lllllllllllllllIlIIIllIIIlIlIlIl && lllllllllllllllIlIIIllIIIIlllIII.getMaterial() != Material.PORTAL && lllllllllllllllIlIIIllIIIIlllIII.getCollisionBoundingBox(this, lllllllllllllllIlIIIllIIIlIIllIl) == Block.NULL_AABB) {
                    continue;
                }
                if (lllllllllllllllIlIIIllIIIIllIlll.canCollideCheck(lllllllllllllllIlIIIllIIIIlllIII, lllllllllllllllIlIIIllIIIlIlIllI)) {
                    final RayTraceResult lllllllllllllllIlIIIllIIIIllIllI = lllllllllllllllIlIIIllIIIIlllIII.collisionRayTrace(this, lllllllllllllllIlIIIllIIIlIIllIl, lllllllllllllllIlIIIllIIIIllIlII, lllllllllllllllIlIIIllIIIlIlIlll);
                    if (lllllllllllllllIlIIIllIIIIllIllI != null) {
                        return lllllllllllllllIlIIIllIIIIllIllI;
                    }
                    continue;
                }
                else {
                    lllllllllllllllIlIIIllIIIlIIlIIl = new RayTraceResult(RayTraceResult.Type.MISS, lllllllllllllllIlIIIllIIIIllIlII, lllllllllllllllIlIIIllIIIIlllIIl, lllllllllllllllIlIIIllIIIlIIllIl);
                }
            }
            return lllllllllllllllIlIIIllIIIIllIIII ? lllllllllllllllIlIIIllIIIlIIlIIl : null;
        }
        return null;
    }
    
    public int getUniqueDataId(final String lllllllllllllllIlIIIIlIIIIlIIIll) {
        return this.mapStorage.getUniqueDataId(lllllllllllllllIlIIIIlIIIIlIIIll);
    }
    
    private boolean isOutsideBuildHeight(final BlockPos lllllllllllllllIlIIIlllIllIlIlIl) {
        return lllllllllllllllIlIIIlllIllIlIlIl.getY() < 0 || lllllllllllllllIlIIIlllIllIlIlIl.getY() >= 256;
    }
    
    public void scheduleBlockUpdate(final BlockPos lllllllllllllllIlIIIlIIlllIIlIll, final Block lllllllllllllllIlIIIlIIlllIIlIlI, final int lllllllllllllllIlIIIlIIlllIIlIIl, final int lllllllllllllllIlIIIlIIlllIIlIII) {
    }
    
    public void tick() {
        this.updateWeather();
    }
    
    public void checkSessionLock() throws MinecraftException {
        this.saveHandler.checkSessionLock();
    }
    
    public boolean isAreaLoaded(final BlockPos lllllllllllllllIlIIIlllIlIlIIIlI, final int lllllllllllllllIlIIIlllIlIIlllIl) {
        return this.isAreaLoaded(lllllllllllllllIlIIIlllIlIlIIIlI, lllllllllllllllIlIIIlllIlIIlllIl, true);
    }
    
    public BiomeProvider getBiomeProvider() {
        return this.provider.getBiomeProvider();
    }
    
    public int getLightFromNeighbors(final BlockPos lllllllllllllllIlIIIllIlIIlIIlll) {
        return this.getLight(lllllllllllllllIlIIIllIlIIlIIlll, true);
    }
    
    public float getBlockDensity(final Vec3d lllllllllllllllIlIIIlIIIIIlIIIlI, final AxisAlignedBB lllllllllllllllIlIIIlIIIIIllIIIl) {
        final double lllllllllllllllIlIIIlIIIIIllIIII = 1.0 / ((lllllllllllllllIlIIIlIIIIIllIIIl.maxX - lllllllllllllllIlIIIlIIIIIllIIIl.minX) * 2.0 + 1.0);
        final double lllllllllllllllIlIIIlIIIIIlIllll = 1.0 / ((lllllllllllllllIlIIIlIIIIIllIIIl.maxY - lllllllllllllllIlIIIlIIIIIllIIIl.minY) * 2.0 + 1.0);
        final double lllllllllllllllIlIIIlIIIIIlIlllI = 1.0 / ((lllllllllllllllIlIIIlIIIIIllIIIl.maxZ - lllllllllllllllIlIIIlIIIIIllIIIl.minZ) * 2.0 + 1.0);
        final double lllllllllllllllIlIIIlIIIIIlIllIl = (1.0 - Math.floor(1.0 / lllllllllllllllIlIIIlIIIIIllIIII) * lllllllllllllllIlIIIlIIIIIllIIII) / 2.0;
        final double lllllllllllllllIlIIIlIIIIIlIllII = (1.0 - Math.floor(1.0 / lllllllllllllllIlIIIlIIIIIlIlllI) * lllllllllllllllIlIIIlIIIIIlIlllI) / 2.0;
        if (lllllllllllllllIlIIIlIIIIIllIIII >= 0.0 && lllllllllllllllIlIIIlIIIIIlIllll >= 0.0 && lllllllllllllllIlIIIlIIIIIlIlllI >= 0.0) {
            int lllllllllllllllIlIIIlIIIIIlIlIll = 0;
            int lllllllllllllllIlIIIlIIIIIlIlIlI = 0;
            for (float lllllllllllllllIlIIIlIIIIIlIlIIl = 0.0f; lllllllllllllllIlIIIlIIIIIlIlIIl <= 1.0f; lllllllllllllllIlIIIlIIIIIlIlIIl += (float)lllllllllllllllIlIIIlIIIIIllIIII) {
                for (float lllllllllllllllIlIIIlIIIIIlIlIII = 0.0f; lllllllllllllllIlIIIlIIIIIlIlIII <= 1.0f; lllllllllllllllIlIIIlIIIIIlIlIII += (float)lllllllllllllllIlIIIlIIIIIlIllll) {
                    for (float lllllllllllllllIlIIIlIIIIIlIIlll = 0.0f; lllllllllllllllIlIIIlIIIIIlIIlll <= 1.0f; lllllllllllllllIlIIIlIIIIIlIIlll += (float)lllllllllllllllIlIIIlIIIIIlIlllI) {
                        final double lllllllllllllllIlIIIlIIIIIlIIllI = lllllllllllllllIlIIIlIIIIIllIIIl.minX + (lllllllllllllllIlIIIlIIIIIllIIIl.maxX - lllllllllllllllIlIIIlIIIIIllIIIl.minX) * lllllllllllllllIlIIIlIIIIIlIlIIl;
                        final double lllllllllllllllIlIIIlIIIIIlIIlIl = lllllllllllllllIlIIIlIIIIIllIIIl.minY + (lllllllllllllllIlIIIlIIIIIllIIIl.maxY - lllllllllllllllIlIIIlIIIIIllIIIl.minY) * lllllllllllllllIlIIIlIIIIIlIlIII;
                        final double lllllllllllllllIlIIIlIIIIIlIIlII = lllllllllllllllIlIIIlIIIIIllIIIl.minZ + (lllllllllllllllIlIIIlIIIIIllIIIl.maxZ - lllllllllllllllIlIIIlIIIIIllIIIl.minZ) * lllllllllllllllIlIIIlIIIIIlIIlll;
                        if (this.rayTraceBlocks(new Vec3d(lllllllllllllllIlIIIlIIIIIlIIllI + lllllllllllllllIlIIIlIIIIIlIllIl, lllllllllllllllIlIIIlIIIIIlIIlIl, lllllllllllllllIlIIIlIIIIIlIIlII + lllllllllllllllIlIIIlIIIIIlIllII), lllllllllllllllIlIIIlIIIIIlIIIlI) == null) {
                            ++lllllllllllllllIlIIIlIIIIIlIlIll;
                        }
                        ++lllllllllllllllIlIIIlIIIIIlIlIlI;
                    }
                }
            }
            return lllllllllllllllIlIIIlIIIIIlIlIll / (float)lllllllllllllllIlIIIlIIIIIlIlIlI;
        }
        return 0.0f;
    }
    
    public int getActualHeight() {
        return this.provider.getHasNoSky() ? 128 : 256;
    }
    
    public boolean isRainingAt(final BlockPos lllllllllllllllIlIIIIlIIIlIIIllI) {
        if (!this.isRaining()) {
            return false;
        }
        if (!this.canSeeSky(lllllllllllllllIlIIIIlIIIlIIIllI)) {
            return false;
        }
        if (this.getPrecipitationHeight(lllllllllllllllIlIIIIlIIIlIIIllI).getY() > lllllllllllllllIlIIIIlIIIlIIIllI.getY()) {
            return false;
        }
        final Biome lllllllllllllllIlIIIIlIIIlIIlIII = this.getBiome(lllllllllllllllIlIIIIlIIIlIIIllI);
        return !lllllllllllllllIlIIIIlIIIlIIlIII.getEnableSnow() && !this.canSnowAt(lllllllllllllllIlIIIIlIIIlIIIllI, false) && lllllllllllllllIlIIIIlIIIlIIlIII.canRain();
    }
    
    public void scheduleUpdate(final BlockPos lllllllllllllllIlIIIlIIlllIlIlII, final Block lllllllllllllllIlIIIlIIlllIlIIll, final int lllllllllllllllIlIIIlIIlllIlIIlI) {
    }
    
    @Nullable
    public List<NextTickListEntry> getPendingBlockUpdates(final Chunk lllllllllllllllIlIIIIllIlIllIIII, final boolean lllllllllllllllIlIIIIllIlIlIllll) {
        return null;
    }
    
    protected void onEntityAdded(final Entity lllllllllllllllIlIIIlIllIIlllIII) {
        for (int lllllllllllllllIlIIIlIllIIllIlll = 0; lllllllllllllllIlIIIlIllIIllIlll < this.eventListeners.size(); ++lllllllllllllllIlIIIlIllIIllIlll) {
            this.eventListeners.get(lllllllllllllllIlIIIlIllIIllIlll).onEntityAdded(lllllllllllllllIlIIIlIllIIlllIII);
        }
    }
    
    @Nullable
    public EntityPlayer getNearestAttackablePlayer(final Entity lllllllllllllllIlIIIIlIlIIIlllIl, final double lllllllllllllllIlIIIIlIlIIIllIII, final double lllllllllllllllIlIIIIlIlIIIllIll) {
        return this.getNearestAttackablePlayer(lllllllllllllllIlIIIIlIlIIIlllIl.posX, lllllllllllllllIlIIIIlIlIIIlllIl.posY, lllllllllllllllIlIIIIlIlIIIlllIl.posZ, lllllllllllllllIlIIIIlIlIIIllIII, lllllllllllllllIlIIIIlIlIIIllIll, null, null);
    }
    
    public boolean tickUpdates(final boolean lllllllllllllllIlIIIIllIlIllIIlI) {
        return false;
    }
    
    public void updateComparatorOutputLevel(final BlockPos lllllllllllllllIlIIIIIlllIIlllII, final Block lllllllllllllllIlIIIIIlllIlIIIIl) {
        for (final EnumFacing lllllllllllllllIlIIIIIlllIlIIIII : EnumFacing.Plane.HORIZONTAL) {
            BlockPos lllllllllllllllIlIIIIIlllIIlllll = lllllllllllllllIlIIIIIlllIIlllII.offset(lllllllllllllllIlIIIIIlllIlIIIII);
            if (this.isBlockLoaded(lllllllllllllllIlIIIIIlllIIlllll)) {
                IBlockState lllllllllllllllIlIIIIIlllIIllllI = this.getBlockState(lllllllllllllllIlIIIIIlllIIlllll);
                if (Blocks.UNPOWERED_COMPARATOR.isSameDiode(lllllllllllllllIlIIIIIlllIIllllI)) {
                    lllllllllllllllIlIIIIIlllIIllllI.neighborChanged(this, lllllllllllllllIlIIIIIlllIIlllll, lllllllllllllllIlIIIIIlllIlIIIIl, lllllllllllllllIlIIIIIlllIIlllII);
                }
                else {
                    if (!lllllllllllllllIlIIIIIlllIIllllI.isNormalCube()) {
                        continue;
                    }
                    lllllllllllllllIlIIIIIlllIIlllll = lllllllllllllllIlIIIIIlllIIlllll.offset(lllllllllllllllIlIIIIIlllIlIIIII);
                    lllllllllllllllIlIIIIIlllIIllllI = this.getBlockState(lllllllllllllllIlIIIIIlllIIlllll);
                    if (!Blocks.UNPOWERED_COMPARATOR.isSameDiode(lllllllllllllllIlIIIIIlllIIllllI)) {
                        continue;
                    }
                    lllllllllllllllIlIIIIIlllIIllllI.neighborChanged(this, lllllllllllllllIlIIIIIlllIIlllll, lllllllllllllllIlIIIIIlllIlIIIIl, lllllllllllllllIlIIIIIlllIIlllII);
                }
            }
        }
    }
    
    public void markChunkDirty(final BlockPos lllllllllllllllIlIIIIllIIIIIlIll, final TileEntity lllllllllllllllIlIIIIllIIIIIlIlI) {
        if (this.isBlockLoaded(lllllllllllllllIlIIIIllIIIIIlIll)) {
            this.getChunkFromBlockCoords(lllllllllllllllIlIIIIllIIIIIlIll).setChunkModified();
        }
    }
    
    public void markBlocksDirtyVertical(final int lllllllllllllllIlIIIllIlllIIIIIl, final int lllllllllllllllIlIIIllIlllIIIIII, int lllllllllllllllIlIIIllIllIllllll, int lllllllllllllllIlIIIllIllIlllllI) {
        if (lllllllllllllllIlIIIllIllIllllll > lllllllllllllllIlIIIllIllIlllllI) {
            final int lllllllllllllllIlIIIllIlllIIIlII = lllllllllllllllIlIIIllIllIlllllI;
            lllllllllllllllIlIIIllIllIlllllI = lllllllllllllllIlIIIllIllIllllll;
            lllllllllllllllIlIIIllIllIllllll = lllllllllllllllIlIIIllIlllIIIlII;
        }
        if (this.provider.func_191066_m()) {
            for (int lllllllllllllllIlIIIllIlllIIIIll = lllllllllllllllIlIIIllIllIllllll; lllllllllllllllIlIIIllIlllIIIIll <= lllllllllllllllIlIIIllIllIlllllI; ++lllllllllllllllIlIIIllIlllIIIIll) {
                this.checkLightFor(EnumSkyBlock.SKY, new BlockPos(lllllllllllllllIlIIIllIlllIIIIIl, lllllllllllllllIlIIIllIlllIIIIll, lllllllllllllllIlIIIllIlllIIIIII));
            }
        }
        this.markBlockRangeForRenderUpdate(lllllllllllllllIlIIIllIlllIIIIIl, lllllllllllllllIlIIIllIllIllllll, lllllllllllllllIlIIIllIlllIIIIII, lllllllllllllllIlIIIllIlllIIIIIl, lllllllllllllllIlIIIllIllIlllllI, lllllllllllllllIlIIIllIlllIIIIII);
    }
    
    public boolean checkNoEntityCollision(final AxisAlignedBB lllllllllllllllIlIIIlIIlIlIlIlII, @Nullable final Entity lllllllllllllllIlIIIlIIlIlIIllIl) {
        final List<Entity> lllllllllllllllIlIIIlIIlIlIlIIlI = this.getEntitiesWithinAABBExcludingEntity(null, lllllllllllllllIlIIIlIIlIlIlIlII);
        for (int lllllllllllllllIlIIIlIIlIlIlIIIl = 0; lllllllllllllllIlIIIlIIlIlIlIIIl < lllllllllllllllIlIIIlIIlIlIlIIlI.size(); ++lllllllllllllllIlIIIlIIlIlIlIIIl) {
            final Entity lllllllllllllllIlIIIlIIlIlIlIIII = lllllllllllllllIlIIIlIIlIlIlIIlI.get(lllllllllllllllIlIIIlIIlIlIlIIIl);
            if (!lllllllllllllllIlIIIlIIlIlIlIIII.isDead && lllllllllllllllIlIIIlIIlIlIlIIII.preventEntitySpawning && lllllllllllllllIlIIIlIIlIlIlIIII != lllllllllllllllIlIIIlIIlIlIIllIl && (lllllllllllllllIlIIIlIIlIlIIllIl == null || lllllllllllllllIlIIIlIIlIlIlIIII.isRidingSameEntity(lllllllllllllllIlIIIlIIlIlIIllIl))) {
                return false;
            }
        }
        return true;
    }
    
    protected abstract boolean isChunkLoaded(final int p0, final int p1, final boolean p2);
    
    @Nullable
    public RayTraceResult rayTraceBlocks(final Vec3d lllllllllllllllIlIIIllIIlIIIIIIl, final Vec3d lllllllllllllllIlIIIllIIIlllllII, final boolean lllllllllllllllIlIIIllIIIllllIll) {
        return this.rayTraceBlocks(lllllllllllllllIlIIIllIIlIIIIIIl, lllllllllllllllIlIIIllIIIlllllII, lllllllllllllllIlIIIllIIIllllIll, false, false);
    }
    
    public boolean isAreaLoaded(final BlockPos lllllllllllllllIlIIIlllIlIIIlIII, final int lllllllllllllllIlIIIlllIlIIIIllI, final boolean lllllllllllllllIlIIIlllIlIIIllII) {
        return this.isAreaLoaded(lllllllllllllllIlIIIlllIlIIIlIII.getX() - lllllllllllllllIlIIIlllIlIIIIllI, lllllllllllllllIlIIIlllIlIIIlIII.getY() - lllllllllllllllIlIIIlllIlIIIIllI, lllllllllllllllIlIIIlllIlIIIlIII.getZ() - lllllllllllllllIlIIIlllIlIIIIllI, lllllllllllllllIlIIIlllIlIIIlIII.getX() + lllllllllllllllIlIIIlllIlIIIIllI, lllllllllllllllIlIIIlllIlIIIlIII.getY() + lllllllllllllllIlIIIlllIlIIIIllI, lllllllllllllllIlIIIlllIlIIIlIII.getZ() + lllllllllllllllIlIIIlllIlIIIIllI, lllllllllllllllIlIIIlllIlIIIllII);
    }
    
    public void addEventListener(final IWorldEventListener lllllllllllllllIlIIIlIllIIIlIIll) {
        this.eventListeners.add(lllllllllllllllIlIIIlIllIIIlIIll);
    }
    
    public void notifyNeighborsOfStateChange(final BlockPos lllllllllllllllIlIIIllIllIIIlIIl, final Block lllllllllllllllIlIIIllIllIIIlIII, final boolean lllllllllllllllIlIIIllIllIIIIlll) {
        this.func_190524_a(lllllllllllllllIlIIIllIllIIIlIIl.west(), lllllllllllllllIlIIIllIllIIIlIII, lllllllllllllllIlIIIllIllIIIlIIl);
        this.func_190524_a(lllllllllllllllIlIIIllIllIIIlIIl.east(), lllllllllllllllIlIIIllIllIIIlIII, lllllllllllllllIlIIIllIllIIIlIIl);
        this.func_190524_a(lllllllllllllllIlIIIllIllIIIlIIl.down(), lllllllllllllllIlIIIllIllIIIlIII, lllllllllllllllIlIIIllIllIIIlIIl);
        this.func_190524_a(lllllllllllllllIlIIIllIllIIIlIIl.up(), lllllllllllllllIlIIIllIllIIIlIII, lllllllllllllllIlIIIllIllIIIlIIl);
        this.func_190524_a(lllllllllllllllIlIIIllIllIIIlIIl.north(), lllllllllllllllIlIIIllIllIIIlIII, lllllllllllllllIlIIIllIllIIIlIIl);
        this.func_190524_a(lllllllllllllllIlIIIllIllIIIlIIl.south(), lllllllllllllllIlIIIllIllIIIlIII, lllllllllllllllIlIIIllIllIIIlIIl);
        if (lllllllllllllllIlIIIllIllIIIIlll) {
            this.func_190522_c(lllllllllllllllIlIIIllIllIIIlIIl, lllllllllllllllIlIIIllIllIIIlIII);
        }
    }
    
    public void playEvent(final int lllllllllllllllIlIIIIlIIIIIIlIII, final BlockPos lllllllllllllllIlIIIIlIIIIIIlIll, final int lllllllllllllllIlIIIIlIIIIIIlIlI) {
        this.playEvent(null, lllllllllllllllIlIIIIlIIIIIIlIII, lllllllllllllllIlIIIIlIIIIIIlIll, lllllllllllllllIlIIIIlIIIIIIlIlI);
    }
    
    protected void playMoodSoundAndCheckLight(final int lllllllllllllllIlIIIIllllIIlIIII, final int lllllllllllllllIlIIIIllllIIIllll, final Chunk lllllllllllllllIlIIIIllllIIIllIl) {
        lllllllllllllllIlIIIIllllIIIllIl.enqueueRelightChecks();
    }
    
    @Nullable
    public WorldSavedData loadItemData(final Class<? extends WorldSavedData> lllllllllllllllIlIIIIlIIIIlIlIII, final String lllllllllllllllIlIIIIlIIIIlIIlll) {
        return this.mapStorage.getOrLoadData(lllllllllllllllIlIIIIlIIIIlIlIII, lllllllllllllllIlIIIIlIIIIlIIlll);
    }
    
    @Nullable
    public EntityPlayer getNearestAttackablePlayer(final double lllllllllllllllIlIIIIlIIlllllIlI, final double lllllllllllllllIlIIIIlIIlllIlIlI, final double lllllllllllllllIlIIIIlIIlllIlIIl, final double lllllllllllllllIlIIIIlIIlllIlIII, final double lllllllllllllllIlIIIIlIIllllIllI, @Nullable final Function<EntityPlayer, Double> lllllllllllllllIlIIIIlIIlllIIllI, @Nullable final Predicate<EntityPlayer> lllllllllllllllIlIIIIlIIllllIlII) {
        double lllllllllllllllIlIIIIlIIllllIIll = -1.0;
        EntityPlayer lllllllllllllllIlIIIIlIIllllIIlI = null;
        for (int lllllllllllllllIlIIIIlIIllllIIIl = 0; lllllllllllllllIlIIIIlIIllllIIIl < this.playerEntities.size(); ++lllllllllllllllIlIIIIlIIllllIIIl) {
            final EntityPlayer lllllllllllllllIlIIIIlIIllllIIII = this.playerEntities.get(lllllllllllllllIlIIIIlIIllllIIIl);
            if (!lllllllllllllllIlIIIIlIIllllIIII.capabilities.disableDamage && lllllllllllllllIlIIIIlIIllllIIII.isEntityAlive() && !lllllllllllllllIlIIIIlIIllllIIII.isSpectator() && (lllllllllllllllIlIIIIlIIllllIlII == null || lllllllllllllllIlIIIIlIIllllIlII.apply((Object)lllllllllllllllIlIIIIlIIllllIIII))) {
                final double lllllllllllllllIlIIIIlIIlllIllll = lllllllllllllllIlIIIIlIIllllIIII.getDistanceSq(lllllllllllllllIlIIIIlIIlllllIlI, lllllllllllllllIlIIIIlIIllllIIII.posY, lllllllllllllllIlIIIIlIIlllIlIIl);
                double lllllllllllllllIlIIIIlIIlllIlllI = lllllllllllllllIlIIIIlIIlllIlIII;
                if (lllllllllllllllIlIIIIlIIllllIIII.isSneaking()) {
                    lllllllllllllllIlIIIIlIIlllIlllI = lllllllllllllllIlIIIIlIIlllIlIII * 0.800000011920929;
                }
                if (lllllllllllllllIlIIIIlIIllllIIII.isInvisible()) {
                    float lllllllllllllllIlIIIIlIIlllIllIl = lllllllllllllllIlIIIIlIIllllIIII.getArmorVisibility();
                    if (lllllllllllllllIlIIIIlIIlllIllIl < 0.1f) {
                        lllllllllllllllIlIIIIlIIlllIllIl = 0.1f;
                    }
                    lllllllllllllllIlIIIIlIIlllIlllI *= 0.7f * lllllllllllllllIlIIIIlIIlllIllIl;
                }
                if (lllllllllllllllIlIIIIlIIlllIIllI != null) {
                    lllllllllllllllIlIIIIlIIlllIlllI *= (double)MoreObjects.firstNonNull((Object)lllllllllllllllIlIIIIlIIlllIIllI.apply((Object)lllllllllllllllIlIIIIlIIllllIIII), (Object)1.0);
                }
                if ((lllllllllllllllIlIIIIlIIllllIllI < 0.0 || Math.abs(lllllllllllllllIlIIIIlIIllllIIII.posY - lllllllllllllllIlIIIIlIIlllIlIlI) < lllllllllllllllIlIIIIlIIllllIllI * lllllllllllllllIlIIIIlIIllllIllI) && (lllllllllllllllIlIIIIlIIlllIlIII < 0.0 || lllllllllllllllIlIIIIlIIlllIllll < lllllllllllllllIlIIIIlIIlllIlllI * lllllllllllllllIlIIIIlIIlllIlllI) && (lllllllllllllllIlIIIIlIIllllIIll == -1.0 || lllllllllllllllIlIIIIlIIlllIllll < lllllllllllllllIlIIIIlIIllllIIll)) {
                    lllllllllllllllIlIIIIlIIllllIIll = lllllllllllllllIlIIIIlIIlllIllll;
                    lllllllllllllllIlIIIIlIIllllIIlI = lllllllllllllllIlIIIIlIIllllIIII;
                }
            }
        }
        return lllllllllllllllIlIIIIlIIllllIIlI;
    }
    
    public void updateEntity(final Entity lllllllllllllllIlIIIlIIlIlllllII) {
        this.updateEntityWithOptionalForce(lllllllllllllllIlIIIlIIlIlllllII, true);
    }
    
    public void playEvent(@Nullable final EntityPlayer lllllllllllllllIlIIIIIllllllIIll, final int lllllllllllllllIlIIIIIlllllllIll, final BlockPos lllllllllllllllIlIIIIIlllllllIlI, final int lllllllllllllllIlIIIIIllllllIIII) {
        try {
            for (int lllllllllllllllIlIIIIIlllllllIII = 0; lllllllllllllllIlIIIIIlllllllIII < this.eventListeners.size(); ++lllllllllllllllIlIIIIIlllllllIII) {
                this.eventListeners.get(lllllllllllllllIlIIIIIlllllllIII).playEvent(lllllllllllllllIlIIIIIllllllIIll, lllllllllllllllIlIIIIIlllllllIll, lllllllllllllllIlIIIIIlllllllIlI, lllllllllllllllIlIIIIIllllllIIII);
            }
        }
        catch (Throwable lllllllllllllllIlIIIIIllllllIlll) {
            final CrashReport lllllllllllllllIlIIIIIllllllIllI = CrashReport.makeCrashReport(lllllllllllllllIlIIIIIllllllIlll, "Playing level event");
            final CrashReportCategory lllllllllllllllIlIIIIIllllllIlIl = lllllllllllllllIlIIIIIllllllIllI.makeCategory("Level event being played");
            lllllllllllllllIlIIIIIllllllIlIl.addCrashSection("Block coordinates", CrashReportCategory.getCoordinateInfo(lllllllllllllllIlIIIIIlllllllIlI));
            lllllllllllllllIlIIIIIllllllIlIl.addCrashSection("Event source", lllllllllllllllIlIIIIIllllllIIll);
            lllllllllllllllIlIIIIIllllllIlIl.addCrashSection("Event type", lllllllllllllllIlIIIIIlllllllIll);
            lllllllllllllllIlIIIIIllllllIlIl.addCrashSection("Event data", lllllllllllllllIlIIIIIllllllIIII);
            throw new ReportedException(lllllllllllllllIlIIIIIllllllIllI);
        }
    }
    
    public void spawnParticle(final EnumParticleTypes lllllllllllllllIlIIIlIlllIlllIIl, final double lllllllllllllllIlIIIlIllllIIIIIl, final double lllllllllllllllIlIIIlIllllIIIIII, final double lllllllllllllllIlIIIlIlllIllIllI, final double lllllllllllllllIlIIIlIlllIlllllI, final double lllllllllllllllIlIIIlIlllIllllIl, final double lllllllllllllllIlIIIlIlllIllIIll, final int... lllllllllllllllIlIIIlIlllIlllIll) {
        this.spawnParticle(lllllllllllllllIlIIIlIlllIlllIIl.getParticleID(), lllllllllllllllIlIIIlIlllIlllIIl.getShouldIgnoreRange(), lllllllllllllllIlIIIlIllllIIIIIl, lllllllllllllllIlIIIlIllllIIIIII, lllllllllllllllIlIIIlIlllIllIllI, lllllllllllllllIlIIIlIlllIlllllI, lllllllllllllllIlIIIlIlllIllllIl, lllllllllllllllIlIIIlIlllIllIIll, lllllllllllllllIlIIIlIlllIlllIll);
    }
    
    @Nullable
    public BlockPos func_190528_a(final String lllllllllllllllIlIIIIIllIlIlIlII, final BlockPos lllllllllllllllIlIIIIIllIlIlIIll, final boolean lllllllllllllllIlIIIIIllIlIlIIlI) {
        return null;
    }
    
    public boolean isAreaLoaded(final BlockPos lllllllllllllllIlIIIlllIIllIlllI, final BlockPos lllllllllllllllIlIIIlllIIllIIlll, final boolean lllllllllllllllIlIIIlllIIllIlIlI) {
        return this.isAreaLoaded(lllllllllllllllIlIIIlllIIllIlllI.getX(), lllllllllllllllIlIIIlllIIllIlllI.getY(), lllllllllllllllIlIIIlllIIllIlllI.getZ(), lllllllllllllllIlIIIlllIIllIIlll.getX(), lllllllllllllllIlIIIlllIIllIIlll.getY(), lllllllllllllllIlIIIlllIIllIIlll.getZ(), lllllllllllllllIlIIIlllIIllIlIlI);
    }
    
    public boolean isAreaLoaded(final StructureBoundingBox lllllllllllllllIlIIIlllIIllIIIII) {
        return this.isAreaLoaded(lllllllllllllllIlIIIlllIIllIIIII, true);
    }
    
    public boolean containsAnyLiquid(final AxisAlignedBB lllllllllllllllIlIIIlIIlIIIIIlll) {
        final int lllllllllllllllIlIIIlIIlIIIlIIll = MathHelper.floor(lllllllllllllllIlIIIlIIlIIIIIlll.minX);
        final int lllllllllllllllIlIIIlIIlIIIlIIlI = MathHelper.ceil(lllllllllllllllIlIIIlIIlIIIIIlll.maxX);
        final int lllllllllllllllIlIIIlIIlIIIlIIIl = MathHelper.floor(lllllllllllllllIlIIIlIIlIIIIIlll.minY);
        final int lllllllllllllllIlIIIlIIlIIIlIIII = MathHelper.ceil(lllllllllllllllIlIIIlIIlIIIIIlll.maxY);
        final int lllllllllllllllIlIIIlIIlIIIIllll = MathHelper.floor(lllllllllllllllIlIIIlIIlIIIIIlll.minZ);
        final int lllllllllllllllIlIIIlIIlIIIIlllI = MathHelper.ceil(lllllllllllllllIlIIIlIIlIIIIIlll.maxZ);
        final BlockPos.PooledMutableBlockPos lllllllllllllllIlIIIlIIlIIIIllIl = BlockPos.PooledMutableBlockPos.retain();
        for (int lllllllllllllllIlIIIlIIlIIIIllII = lllllllllllllllIlIIIlIIlIIIlIIll; lllllllllllllllIlIIIlIIlIIIIllII < lllllllllllllllIlIIIlIIlIIIlIIlI; ++lllllllllllllllIlIIIlIIlIIIIllII) {
            for (int lllllllllllllllIlIIIlIIlIIIIlIll = lllllllllllllllIlIIIlIIlIIIlIIIl; lllllllllllllllIlIIIlIIlIIIIlIll < lllllllllllllllIlIIIlIIlIIIlIIII; ++lllllllllllllllIlIIIlIIlIIIIlIll) {
                for (int lllllllllllllllIlIIIlIIlIIIIlIlI = lllllllllllllllIlIIIlIIlIIIIllll; lllllllllllllllIlIIIlIIlIIIIlIlI < lllllllllllllllIlIIIlIIlIIIIlllI; ++lllllllllllllllIlIIIlIIlIIIIlIlI) {
                    final IBlockState lllllllllllllllIlIIIlIIlIIIIlIIl = this.getBlockState(lllllllllllllllIlIIIlIIlIIIIllIl.setPos(lllllllllllllllIlIIIlIIlIIIIllII, lllllllllllllllIlIIIlIIlIIIIlIll, lllllllllllllllIlIIIlIIlIIIIlIlI));
                    if (lllllllllllllllIlIIIlIIlIIIIlIIl.getMaterial().isLiquid()) {
                        lllllllllllllllIlIIIlIIlIIIIllIl.release();
                        return true;
                    }
                }
            }
        }
        lllllllllllllllIlIIIlIIlIIIIllIl.release();
        return false;
    }
    
    public DifficultyInstance getDifficultyForLocation(final BlockPos lllllllllllllllIlIIIIIlllIIlIIIl) {
        long lllllllllllllllIlIIIIIlllIIlIIII = 0L;
        float lllllllllllllllIlIIIIIlllIIIllll = 0.0f;
        if (this.isBlockLoaded(lllllllllllllllIlIIIIIlllIIlIIIl)) {
            lllllllllllllllIlIIIIIlllIIIllll = this.getCurrentMoonPhaseFactor();
            lllllllllllllllIlIIIIIlllIIlIIII = this.getChunkFromBlockCoords(lllllllllllllllIlIIIIIlllIIlIIIl).getInhabitedTime();
        }
        return new DifficultyInstance(this.getDifficulty(), this.getWorldTime(), lllllllllllllllIlIIIIIlllIIlIIII, lllllllllllllllIlIIIIIlllIIIllll);
    }
    
    public boolean handleMaterialAcceleration(final AxisAlignedBB lllllllllllllllIlIIIlIIIllIIIIII, final Material lllllllllllllllIlIIIlIIIlIllllll, final Entity lllllllllllllllIlIIIlIIIlIlIlIlI) {
        final int lllllllllllllllIlIIIlIIIlIllllIl = MathHelper.floor(lllllllllllllllIlIIIlIIIllIIIIII.minX);
        final int lllllllllllllllIlIIIlIIIlIllllII = MathHelper.ceil(lllllllllllllllIlIIIlIIIllIIIIII.maxX);
        final int lllllllllllllllIlIIIlIIIlIlllIll = MathHelper.floor(lllllllllllllllIlIIIlIIIllIIIIII.minY);
        final int lllllllllllllllIlIIIlIIIlIlllIlI = MathHelper.ceil(lllllllllllllllIlIIIlIIIllIIIIII.maxY);
        final int lllllllllllllllIlIIIlIIIlIlllIIl = MathHelper.floor(lllllllllllllllIlIIIlIIIllIIIIII.minZ);
        final int lllllllllllllllIlIIIlIIIlIlllIII = MathHelper.ceil(lllllllllllllllIlIIIlIIIllIIIIII.maxZ);
        if (!this.isAreaLoaded(lllllllllllllllIlIIIlIIIlIllllIl, lllllllllllllllIlIIIlIIIlIlllIll, lllllllllllllllIlIIIlIIIlIlllIIl, lllllllllllllllIlIIIlIIIlIllllII, lllllllllllllllIlIIIlIIIlIlllIlI, lllllllllllllllIlIIIlIIIlIlllIII, true)) {
            return false;
        }
        boolean lllllllllllllllIlIIIlIIIlIllIlll = false;
        Vec3d lllllllllllllllIlIIIlIIIlIllIllI = Vec3d.ZERO;
        final BlockPos.PooledMutableBlockPos lllllllllllllllIlIIIlIIIlIllIlIl = BlockPos.PooledMutableBlockPos.retain();
        for (int lllllllllllllllIlIIIlIIIlIllIlII = lllllllllllllllIlIIIlIIIlIllllIl; lllllllllllllllIlIIIlIIIlIllIlII < lllllllllllllllIlIIIlIIIlIllllII; ++lllllllllllllllIlIIIlIIIlIllIlII) {
            for (int lllllllllllllllIlIIIlIIIlIllIIll = lllllllllllllllIlIIIlIIIlIlllIll; lllllllllllllllIlIIIlIIIlIllIIll < lllllllllllllllIlIIIlIIIlIlllIlI; ++lllllllllllllllIlIIIlIIIlIllIIll) {
                for (int lllllllllllllllIlIIIlIIIlIllIIlI = lllllllllllllllIlIIIlIIIlIlllIIl; lllllllllllllllIlIIIlIIIlIllIIlI < lllllllllllllllIlIIIlIIIlIlllIII; ++lllllllllllllllIlIIIlIIIlIllIIlI) {
                    lllllllllllllllIlIIIlIIIlIllIlIl.setPos(lllllllllllllllIlIIIlIIIlIllIlII, lllllllllllllllIlIIIlIIIlIllIIll, lllllllllllllllIlIIIlIIIlIllIIlI);
                    final IBlockState lllllllllllllllIlIIIlIIIlIllIIIl = this.getBlockState(lllllllllllllllIlIIIlIIIlIllIlIl);
                    final Block lllllllllllllllIlIIIlIIIlIllIIII = lllllllllllllllIlIIIlIIIlIllIIIl.getBlock();
                    if (lllllllllllllllIlIIIlIIIlIllIIIl.getMaterial() == lllllllllllllllIlIIIlIIIlIllllll) {
                        final double lllllllllllllllIlIIIlIIIlIlIllll = lllllllllllllllIlIIIlIIIlIllIIll + 1 - BlockLiquid.getLiquidHeightPercent(lllllllllllllllIlIIIlIIIlIllIIIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL));
                        if (lllllllllllllllIlIIIlIIIlIlllIlI >= lllllllllllllllIlIIIlIIIlIlIllll) {
                            lllllllllllllllIlIIIlIIIlIllIlll = true;
                            lllllllllllllllIlIIIlIIIlIllIllI = lllllllllllllllIlIIIlIIIlIllIIII.modifyAcceleration(this, lllllllllllllllIlIIIlIIIlIllIlIl, lllllllllllllllIlIIIlIIIlIlIlIlI, lllllllllllllllIlIIIlIIIlIllIllI);
                        }
                    }
                }
            }
        }
        lllllllllllllllIlIIIlIIIlIllIlIl.release();
        if (lllllllllllllllIlIIIlIIIlIllIllI.lengthVector() > 0.0 && lllllllllllllllIlIIIlIIIlIlIlIlI.isPushedByWater()) {
            lllllllllllllllIlIIIlIIIlIllIllI = lllllllllllllllIlIIIlIIIlIllIllI.normalize();
            final double lllllllllllllllIlIIIlIIIlIlIlllI = 0.014;
            lllllllllllllllIlIIIlIIIlIlIlIlI.motionX += lllllllllllllllIlIIIlIIIlIllIllI.xCoord * 0.014;
            lllllllllllllllIlIIIlIIIlIlIlIlI.motionY += lllllllllllllllIlIIIlIIIlIllIllI.yCoord * 0.014;
            lllllllllllllllIlIIIlIIIlIlIlIlI.motionZ += lllllllllllllllIlIIIlIIIlIllIllI.zCoord * 0.014;
        }
        return lllllllllllllllIlIIIlIIIlIllIlll;
    }
    
    public boolean isSidePowered(final BlockPos lllllllllllllllIlIIIIlIllIlIlllI, final EnumFacing lllllllllllllllIlIIIIlIllIlIlIlI) {
        return this.getRedstonePower(lllllllllllllllIlIIIIlIllIlIlllI, lllllllllllllllIlIIIIlIllIlIlIlI) > 0;
    }
    
    public int getLightFromNeighborsFor(final EnumSkyBlock lllllllllllllllIlIIIllIIllIllIll, BlockPos lllllllllllllllIlIIIllIIllIllIlI) {
        if (!this.provider.func_191066_m() && lllllllllllllllIlIIIllIIllIllIll == EnumSkyBlock.SKY) {
            return 0;
        }
        if (((Vec3i)lllllllllllllllIlIIIllIIllIllIlI).getY() < 0) {
            lllllllllllllllIlIIIllIIllIllIlI = new BlockPos(((Vec3i)lllllllllllllllIlIIIllIIllIllIlI).getX(), 0, ((Vec3i)lllllllllllllllIlIIIllIIllIllIlI).getZ());
        }
        if (!this.isValid((BlockPos)lllllllllllllllIlIIIllIIllIllIlI)) {
            return lllllllllllllllIlIIIllIIllIllIll.defaultLightValue;
        }
        if (!this.isBlockLoaded((BlockPos)lllllllllllllllIlIIIllIIllIllIlI)) {
            return lllllllllllllllIlIIIllIIllIllIll.defaultLightValue;
        }
        if (this.getBlockState((BlockPos)lllllllllllllllIlIIIllIIllIllIlI).useNeighborBrightness()) {
            int lllllllllllllllIlIIIllIIlllIIIlI = this.getLightFor(lllllllllllllllIlIIIllIIllIllIll, ((BlockPos)lllllllllllllllIlIIIllIIllIllIlI).up());
            final int lllllllllllllllIlIIIllIIlllIIIIl = this.getLightFor(lllllllllllllllIlIIIllIIllIllIll, ((BlockPos)lllllllllllllllIlIIIllIIllIllIlI).east());
            final int lllllllllllllllIlIIIllIIlllIIIII = this.getLightFor(lllllllllllllllIlIIIllIIllIllIll, ((BlockPos)lllllllllllllllIlIIIllIIllIllIlI).west());
            final int lllllllllllllllIlIIIllIIllIlllll = this.getLightFor(lllllllllllllllIlIIIllIIllIllIll, ((BlockPos)lllllllllllllllIlIIIllIIllIllIlI).south());
            final int lllllllllllllllIlIIIllIIllIllllI = this.getLightFor(lllllllllllllllIlIIIllIIllIllIll, ((BlockPos)lllllllllllllllIlIIIllIIllIllIlI).north());
            if (lllllllllllllllIlIIIllIIlllIIIIl > lllllllllllllllIlIIIllIIlllIIIlI) {
                lllllllllllllllIlIIIllIIlllIIIlI = lllllllllllllllIlIIIllIIlllIIIIl;
            }
            if (lllllllllllllllIlIIIllIIlllIIIII > lllllllllllllllIlIIIllIIlllIIIlI) {
                lllllllllllllllIlIIIllIIlllIIIlI = lllllllllllllllIlIIIllIIlllIIIII;
            }
            if (lllllllllllllllIlIIIllIIllIlllll > lllllllllllllllIlIIIllIIlllIIIlI) {
                lllllllllllllllIlIIIllIIlllIIIlI = lllllllllllllllIlIIIllIIllIlllll;
            }
            if (lllllllllllllllIlIIIllIIllIllllI > lllllllllllllllIlIIIllIIlllIIIlI) {
                lllllllllllllllIlIIIllIIlllIIIlI = lllllllllllllllIlIIIllIIllIllllI;
            }
            return lllllllllllllllIlIIIllIIlllIIIlI;
        }
        final Chunk lllllllllllllllIlIIIllIIllIlllIl = this.getChunkFromBlockCoords((BlockPos)lllllllllllllllIlIIIllIIllIllIlI);
        return lllllllllllllllIlIIIllIIllIlllIl.getLightFor(lllllllllllllllIlIIIllIIllIllIll, (BlockPos)lllllllllllllllIlIIIllIIllIllIlI);
    }
    
    public ISaveHandler getSaveHandler() {
        return this.saveHandler;
    }
    
    public void setTotalWorldTime(final long lllllllllllllllIlIIIIlIIlIlllllI) {
        this.worldInfo.setWorldTotalTime(lllllllllllllllIlIIIIlIIlIlllllI);
    }
    
    public void setSeaLevel(final int lllllllllllllllIlIIIIlIlllIIlIII) {
        this.seaLevel = lllllllllllllllIlIIIIlIlllIIlIII;
    }
    
    public String getProviderName() {
        return this.chunkProvider.makeString();
    }
    
    public void markBlockRangeForRenderUpdate(final BlockPos lllllllllllllllIlIIIllIllIlllIII, final BlockPos lllllllllllllllIlIIIllIllIllIlII) {
        this.markBlockRangeForRenderUpdate(lllllllllllllllIlIIIllIllIlllIII.getX(), lllllllllllllllIlIIIllIllIlllIII.getY(), lllllllllllllllIlIIIllIllIlllIII.getZ(), lllllllllllllllIlIIIllIllIllIlII.getX(), lllllllllllllllIlIIIllIllIllIlII.getY(), lllllllllllllllIlIIIllIllIllIlII.getZ());
    }
    
    public WorldInfo getWorldInfo() {
        return this.worldInfo;
    }
    
    public double getHorizon() {
        return (this.worldInfo.getTerrainType() == WorldType.FLAT) ? 0.0 : 63.0;
    }
    
    public boolean isThundering() {
        return this.getThunderStrength(1.0f) > 0.9;
    }
    
    public void unloadEntities(final Collection<Entity> lllllllllllllllIlIIIIlIllllIlIIl) {
        this.unloadedEntityList.addAll(lllllllllllllllIlIIIIlIllllIlIIl);
    }
    
    public void func_190522_c(final BlockPos lllllllllllllllIlIIIllIllIIlIlII, final Block lllllllllllllllIlIIIllIllIIlIllI) {
        this.func_190529_b(lllllllllllllllIlIIIllIllIIlIlII.west(), lllllllllllllllIlIIIllIllIIlIllI, lllllllllllllllIlIIIllIllIIlIlII);
        this.func_190529_b(lllllllllllllllIlIIIllIllIIlIlII.east(), lllllllllllllllIlIIIllIllIIlIllI, lllllllllllllllIlIIIllIllIIlIlII);
        this.func_190529_b(lllllllllllllllIlIIIllIllIIlIlII.down(), lllllllllllllllIlIIIllIllIIlIllI, lllllllllllllllIlIIIllIllIIlIlII);
        this.func_190529_b(lllllllllllllllIlIIIllIllIIlIlII.up(), lllllllllllllllIlIIIllIllIIlIllI, lllllllllllllllIlIIIllIllIIlIlII);
        this.func_190529_b(lllllllllllllllIlIIIllIllIIlIlII.north(), lllllllllllllllIlIIIllIllIIlIllI, lllllllllllllllIlIIIllIllIIlIlII);
        this.func_190529_b(lllllllllllllllIlIIIllIllIIlIlII.south(), lllllllllllllllIlIIIllIllIIlIllI, lllllllllllllllIlIIIllIllIIlIlII);
    }
    
    public boolean isBlockNormalCube(final BlockPos lllllllllllllllIlIIIIllllIlllIlI, final boolean lllllllllllllllIlIIIIllllIlllIIl) {
        if (this.isOutsideBuildHeight(lllllllllllllllIlIIIIllllIlllIlI)) {
            return false;
        }
        final Chunk lllllllllllllllIlIIIIllllIllllIl = this.chunkProvider.getLoadedChunk(lllllllllllllllIlIIIIllllIlllIlI.getX() >> 4, lllllllllllllllIlIIIIllllIlllIlI.getZ() >> 4);
        if (lllllllllllllllIlIIIIllllIllllIl != null && !lllllllllllllllIlIIIIllllIllllIl.isEmpty()) {
            final IBlockState lllllllllllllllIlIIIIllllIllllII = this.getBlockState(lllllllllllllllIlIIIIllllIlllIlI);
            return lllllllllllllllIlIIIIllllIllllII.getMaterial().isOpaque() && lllllllllllllllIlIIIIllllIllllII.isFullCube();
        }
        return lllllllllllllllIlIIIIllllIlllIIl;
    }
    
    public void notifyBlockUpdate(final BlockPos lllllllllllllllIlIIIllIllllIIllI, final IBlockState lllllllllllllllIlIIIllIllllIIlIl, final IBlockState lllllllllllllllIlIIIllIllllIIlII, final int lllllllllllllllIlIIIllIlllIlllIl) {
        for (int lllllllllllllllIlIIIllIllllIIIlI = 0; lllllllllllllllIlIIIllIllllIIIlI < this.eventListeners.size(); ++lllllllllllllllIlIIIllIllllIIIlI) {
            this.eventListeners.get(lllllllllllllllIlIIIllIllllIIIlI).notifyBlockUpdate(this, lllllllllllllllIlIIIllIllllIIllI, lllllllllllllllIlIIIllIllllIIlIl, lllllllllllllllIlIIIllIllllIIlII, lllllllllllllllIlIIIllIlllIlllIl);
        }
    }
    
    protected void updateWeather() {
        if (this.provider.func_191066_m() && !this.isRemote) {
            final boolean lllllllllllllllIlIIIIllllIIllIll = this.getGameRules().getBoolean("doWeatherCycle");
            if (lllllllllllllllIlIIIIllllIIllIll) {
                int lllllllllllllllIlIIIIllllIIllIlI = this.worldInfo.getCleanWeatherTime();
                if (lllllllllllllllIlIIIIllllIIllIlI > 0) {
                    --lllllllllllllllIlIIIIllllIIllIlI;
                    this.worldInfo.setCleanWeatherTime(lllllllllllllllIlIIIIllllIIllIlI);
                    this.worldInfo.setThunderTime(this.worldInfo.isThundering() ? 1 : 2);
                    this.worldInfo.setRainTime(this.worldInfo.isRaining() ? 1 : 2);
                }
                int lllllllllllllllIlIIIIllllIIllIIl = this.worldInfo.getThunderTime();
                if (lllllllllllllllIlIIIIllllIIllIIl <= 0) {
                    if (this.worldInfo.isThundering()) {
                        this.worldInfo.setThunderTime(this.rand.nextInt(12000) + 3600);
                    }
                    else {
                        this.worldInfo.setThunderTime(this.rand.nextInt(168000) + 12000);
                    }
                }
                else {
                    --lllllllllllllllIlIIIIllllIIllIIl;
                    this.worldInfo.setThunderTime(lllllllllllllllIlIIIIllllIIllIIl);
                    if (lllllllllllllllIlIIIIllllIIllIIl <= 0) {
                        this.worldInfo.setThundering(!this.worldInfo.isThundering());
                    }
                }
                int lllllllllllllllIlIIIIllllIIllIII = this.worldInfo.getRainTime();
                if (lllllllllllllllIlIIIIllllIIllIII <= 0) {
                    if (this.worldInfo.isRaining()) {
                        this.worldInfo.setRainTime(this.rand.nextInt(12000) + 12000);
                    }
                    else {
                        this.worldInfo.setRainTime(this.rand.nextInt(168000) + 12000);
                    }
                }
                else {
                    --lllllllllllllllIlIIIIllllIIllIII;
                    this.worldInfo.setRainTime(lllllllllllllllIlIIIIllllIIllIII);
                    if (lllllllllllllllIlIIIIllllIIllIII <= 0) {
                        this.worldInfo.setRaining(!this.worldInfo.isRaining());
                    }
                }
            }
            this.prevThunderingStrength = this.thunderingStrength;
            if (this.worldInfo.isThundering()) {
                this.thunderingStrength += (float)0.01;
            }
            else {
                this.thunderingStrength -= (float)0.01;
            }
            this.thunderingStrength = MathHelper.clamp(this.thunderingStrength, 0.0f, 1.0f);
            this.prevRainingStrength = this.rainingStrength;
            if (this.worldInfo.isRaining()) {
                this.rainingStrength += (float)0.01;
            }
            else {
                this.rainingStrength -= (float)0.01;
            }
            this.rainingStrength = MathHelper.clamp(this.rainingStrength, 0.0f, 1.0f);
        }
    }
    
    public void joinEntityInSurroundings(final Entity lllllllllllllllIlIIIIlIIlIIlIIIl) {
        final int lllllllllllllllIlIIIIlIIlIIlIlll = MathHelper.floor(lllllllllllllllIlIIIIlIIlIIlIIIl.posX / 16.0);
        final int lllllllllllllllIlIIIIlIIlIIlIllI = MathHelper.floor(lllllllllllllllIlIIIIlIIlIIlIIIl.posZ / 16.0);
        final int lllllllllllllllIlIIIIlIIlIIlIlIl = 2;
        for (int lllllllllllllllIlIIIIlIIlIIlIlII = -2; lllllllllllllllIlIIIIlIIlIIlIlII <= 2; ++lllllllllllllllIlIIIIlIIlIIlIlII) {
            for (int lllllllllllllllIlIIIIlIIlIIlIIll = -2; lllllllllllllllIlIIIIlIIlIIlIIll <= 2; ++lllllllllllllllIlIIIIlIIlIIlIIll) {
                this.getChunkFromChunkCoords(lllllllllllllllIlIIIIlIIlIIlIlll + lllllllllllllllIlIIIIlIIlIIlIlII, lllllllllllllllIlIIIIlIIlIIlIllI + lllllllllllllllIlIIIIlIIlIIlIIll);
            }
        }
        if (!this.loadedEntityList.contains(lllllllllllllllIlIIIIlIIlIIlIIIl)) {
            this.loadedEntityList.add(lllllllllllllllIlIIIIlIIlIIlIIIl);
        }
    }
    
    public boolean checkLight(final BlockPos lllllllllllllllIlIIIIlllIIllllll) {
        boolean lllllllllllllllIlIIIIlllIIlllllI = false;
        if (this.provider.func_191066_m()) {
            lllllllllllllllIlIIIIlllIIlllllI |= this.checkLightFor(EnumSkyBlock.SKY, lllllllllllllllIlIIIIlllIIllllll);
        }
        lllllllllllllllIlIIIIlllIIlllllI |= this.checkLightFor(EnumSkyBlock.BLOCK, lllllllllllllllIlIIIIlllIIllllll);
        return lllllllllllllllIlIIIIlllIIlllllI;
    }
    
    public boolean setBlockState(final BlockPos lllllllllllllllIlIIIllIllllIllll, final IBlockState lllllllllllllllIlIIIllIlllllIIIl) {
        return this.setBlockState(lllllllllllllllIlIIIllIllllIllll, lllllllllllllllIlIIIllIlllllIIIl, 3);
    }
    
    public void notifyNeighborsOfStateExcept(final BlockPos lllllllllllllllIlIIIllIllIIIIIIl, final Block lllllllllllllllIlIIIllIllIIIIIII, final EnumFacing lllllllllllllllIlIIIllIlIlllllll) {
        if (lllllllllllllllIlIIIllIlIlllllll != EnumFacing.WEST) {
            this.func_190524_a(lllllllllllllllIlIIIllIllIIIIIIl.west(), lllllllllllllllIlIIIllIllIIIIIII, lllllllllllllllIlIIIllIllIIIIIIl);
        }
        if (lllllllllllllllIlIIIllIlIlllllll != EnumFacing.EAST) {
            this.func_190524_a(lllllllllllllllIlIIIllIllIIIIIIl.east(), lllllllllllllllIlIIIllIllIIIIIII, lllllllllllllllIlIIIllIllIIIIIIl);
        }
        if (lllllllllllllllIlIIIllIlIlllllll != EnumFacing.DOWN) {
            this.func_190524_a(lllllllllllllllIlIIIllIllIIIIIIl.down(), lllllllllllllllIlIIIllIllIIIIIII, lllllllllllllllIlIIIllIllIIIIIIl);
        }
        if (lllllllllllllllIlIIIllIlIlllllll != EnumFacing.UP) {
            this.func_190524_a(lllllllllllllllIlIIIllIllIIIIIIl.up(), lllllllllllllllIlIIIllIllIIIIIII, lllllllllllllllIlIIIllIllIIIIIIl);
        }
        if (lllllllllllllllIlIIIllIlIlllllll != EnumFacing.NORTH) {
            this.func_190524_a(lllllllllllllllIlIIIllIllIIIIIIl.north(), lllllllllllllllIlIIIllIllIIIIIII, lllllllllllllllIlIIIllIllIIIIIIl);
        }
        if (lllllllllllllllIlIIIllIlIlllllll != EnumFacing.SOUTH) {
            this.func_190524_a(lllllllllllllllIlIIIllIllIIIIIIl.south(), lllllllllllllllIlIIIllIllIIIIIII, lllllllllllllllIlIIIllIllIIIIIIl);
        }
    }
    
    public void setLastLightningBolt(final int lllllllllllllllIlIIIIIllIlllIllI) {
        this.lastLightningBolt = lllllllllllllllIlIIIIIllIlllIllI;
    }
    
    public boolean canBlockFreeze(final BlockPos lllllllllllllllIlIIIIlllIllIIIlI, final boolean lllllllllllllllIlIIIIlllIllIIIIl) {
        final Biome lllllllllllllllIlIIIIlllIllIlIII = this.getBiome(lllllllllllllllIlIIIIlllIllIIIlI);
        final float lllllllllllllllIlIIIIlllIllIIlll = lllllllllllllllIlIIIIlllIllIlIII.getFloatTemperature(lllllllllllllllIlIIIIlllIllIIIlI);
        if (lllllllllllllllIlIIIIlllIllIIlll >= 0.15f) {
            return false;
        }
        if (lllllllllllllllIlIIIIlllIllIIIlI.getY() >= 0 && lllllllllllllllIlIIIIlllIllIIIlI.getY() < 256 && this.getLightFor(EnumSkyBlock.BLOCK, lllllllllllllllIlIIIIlllIllIIIlI) < 10) {
            final IBlockState lllllllllllllllIlIIIIlllIllIIllI = this.getBlockState(lllllllllllllllIlIIIIlllIllIIIlI);
            final Block lllllllllllllllIlIIIIlllIllIIlIl = lllllllllllllllIlIIIIlllIllIIllI.getBlock();
            if ((lllllllllllllllIlIIIIlllIllIIlIl == Blocks.WATER || lllllllllllllllIlIIIIlllIllIIlIl == Blocks.FLOWING_WATER) && lllllllllllllllIlIIIIlllIllIIllI.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0) {
                if (!lllllllllllllllIlIIIIlllIllIIIIl) {
                    return true;
                }
                final boolean lllllllllllllllIlIIIIlllIllIIlII = this.isWater(lllllllllllllllIlIIIIlllIllIIIlI.west()) && this.isWater(lllllllllllllllIlIIIIlllIllIIIlI.east()) && this.isWater(lllllllllllllllIlIIIIlllIllIIIlI.north()) && this.isWater(lllllllllllllllIlIIIIlllIllIIIlI.south());
                if (!lllllllllllllllIlIIIIlllIllIIlII) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isRaining() {
        return this.getRainStrength(1.0f) > 0.2;
    }
    
    public void setWorldTime(final long lllllllllllllllIlIIIIlIIlIlIllll) {
        this.worldInfo.setWorldTime(lllllllllllllllIlIIIIlIIlIlIllll);
    }
    
    public void playRecord(final BlockPos lllllllllllllllIlIIIlIllllIlIIll, @Nullable final SoundEvent lllllllllllllllIlIIIlIllllIIlllI) {
        for (int lllllllllllllllIlIIIlIllllIlIIIl = 0; lllllllllllllllIlIIIlIllllIlIIIl < this.eventListeners.size(); ++lllllllllllllllIlIIIlIllllIlIIIl) {
            this.eventListeners.get(lllllllllllllllIlIIIlIllllIlIIIl).playRecord(lllllllllllllllIlIIIlIllllIIlllI, lllllllllllllllIlIIIlIllllIlIIll);
        }
    }
    
    public boolean isBlockTickPending(final BlockPos lllllllllllllllIlIIIllIlIlIIlIIl, final Block lllllllllllllllIlIIIllIlIlIIlIII) {
        return false;
    }
    
    @Override
    public WorldType getWorldType() {
        return this.worldInfo.getTerrainType();
    }
    
    public Explosion newExplosion(@Nullable final Entity lllllllllllllllIlIIIlIIIIlIIlIll, final double lllllllllllllllIlIIIlIIIIlIlIIll, final double lllllllllllllllIlIIIlIIIIlIlIIlI, final double lllllllllllllllIlIIIlIIIIlIIlIII, final float lllllllllllllllIlIIIlIIIIlIIIlll, final boolean lllllllllllllllIlIIIlIIIIlIIIllI, final boolean lllllllllllllllIlIIIlIIIIlIIIlIl) {
        final Explosion lllllllllllllllIlIIIlIIIIlIIllIl = new Explosion(this, lllllllllllllllIlIIIlIIIIlIIlIll, lllllllllllllllIlIIIlIIIIlIlIIll, lllllllllllllllIlIIIlIIIIlIlIIlI, lllllllllllllllIlIIIlIIIIlIIlIII, lllllllllllllllIlIIIlIIIIlIIIlll, lllllllllllllllIlIIIlIIIIlIIIllI, lllllllllllllllIlIIIlIIIIlIIIlIl);
        lllllllllllllllIlIIIlIIIIlIIllIl.doExplosionA();
        lllllllllllllllIlIIIlIIIIlIIllIl.doExplosionB(true);
        return lllllllllllllllIlIIIlIIIIlIIllIl;
    }
    
    public boolean isBlockLoaded(final BlockPos lllllllllllllllIlIIIlllIlIllIIII, final boolean lllllllllllllllIlIIIlllIlIlIlllI) {
        return this.isChunkLoaded(lllllllllllllllIlIIIlllIlIllIIII.getX() >> 4, lllllllllllllllIlIIIlllIlIllIIII.getZ() >> 4, lllllllllllllllIlIIIlllIlIlIlllI);
    }
    
    public boolean checkLightFor(final EnumSkyBlock lllllllllllllllIlIIIIllIllIIllll, final BlockPos lllllllllllllllIlIIIIllIllllIIll) {
        if (!this.isAreaLoaded(lllllllllllllllIlIIIIllIllllIIll, 17, false)) {
            return false;
        }
        int lllllllllllllllIlIIIIllIllllIIlI = 0;
        int lllllllllllllllIlIIIIllIllllIIIl = 0;
        this.theProfiler.startSection("getBrightness");
        final int lllllllllllllllIlIIIIllIllllIIII = this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIllllIIll);
        final int lllllllllllllllIlIIIIllIlllIllll = this.getRawLight(lllllllllllllllIlIIIIllIllllIIll, lllllllllllllllIlIIIIllIllIIllll);
        final int lllllllllllllllIlIIIIllIlllIlllI = lllllllllllllllIlIIIIllIllllIIll.getX();
        final int lllllllllllllllIlIIIIllIlllIllIl = lllllllllllllllIlIIIIllIllllIIll.getY();
        final int lllllllllllllllIlIIIIllIlllIllII = lllllllllllllllIlIIIIllIllllIIll.getZ();
        if (lllllllllllllllIlIIIIllIlllIllll > lllllllllllllllIlIIIIllIllllIIII) {
            this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIIl++] = 133152;
        }
        else if (lllllllllllllllIlIIIIllIlllIllll < lllllllllllllllIlIIIIllIllllIIII) {
            this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIIl++] = (0x20820 | lllllllllllllllIlIIIIllIllllIIII << 18);
            while (lllllllllllllllIlIIIIllIllllIIlI < lllllllllllllllIlIIIIllIllllIIIl) {
                final int lllllllllllllllIlIIIIllIlllIlIll = this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIlI++];
                final int lllllllllllllllIlIIIIllIlllIlIlI = (lllllllllllllllIlIIIIllIlllIlIll & 0x3F) - 32 + lllllllllllllllIlIIIIllIlllIlllI;
                final int lllllllllllllllIlIIIIllIlllIlIIl = (lllllllllllllllIlIIIIllIlllIlIll >> 6 & 0x3F) - 32 + lllllllllllllllIlIIIIllIlllIllIl;
                final int lllllllllllllllIlIIIIllIlllIlIII = (lllllllllllllllIlIIIIllIlllIlIll >> 12 & 0x3F) - 32 + lllllllllllllllIlIIIIllIlllIllII;
                final int lllllllllllllllIlIIIIllIlllIIlll = lllllllllllllllIlIIIIllIlllIlIll >> 18 & 0xF;
                final BlockPos lllllllllllllllIlIIIIllIlllIIllI = new BlockPos(lllllllllllllllIlIIIIllIlllIlIlI, lllllllllllllllIlIIIIllIlllIlIIl, lllllllllllllllIlIIIIllIlllIlIII);
                int lllllllllllllllIlIIIIllIlllIIlIl = this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIlllIIllI);
                if (lllllllllllllllIlIIIIllIlllIIlIl == lllllllllllllllIlIIIIllIlllIIlll) {
                    this.setLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIlllIIllI, 0);
                    if (lllllllllllllllIlIIIIllIlllIIlll <= 0) {
                        continue;
                    }
                    final int lllllllllllllllIlIIIIllIlllIIlII = MathHelper.abs(lllllllllllllllIlIIIIllIlllIlIlI - lllllllllllllllIlIIIIllIlllIlllI);
                    final int lllllllllllllllIlIIIIllIlllIIIll = MathHelper.abs(lllllllllllllllIlIIIIllIlllIlIIl - lllllllllllllllIlIIIIllIlllIllIl);
                    final int lllllllllllllllIlIIIIllIlllIIIlI = MathHelper.abs(lllllllllllllllIlIIIIllIlllIlIII - lllllllllllllllIlIIIIllIlllIllII);
                    if (lllllllllllllllIlIIIIllIlllIIlII + lllllllllllllllIlIIIIllIlllIIIll + lllllllllllllllIlIIIIllIlllIIIlI >= 17) {
                        continue;
                    }
                    final BlockPos.PooledMutableBlockPos lllllllllllllllIlIIIIllIlllIIIIl = BlockPos.PooledMutableBlockPos.retain();
                    final String lllllllllllllllIlIIIIllIlIlllIII;
                    final double lllllllllllllllIlIIIIllIlIlllIIl = ((EnumFacing[])(Object)(lllllllllllllllIlIIIIllIlIlllIII = (String)(Object)EnumFacing.values())).length;
                    for (String lllllllllllllllIlIIIIllIlIlllIlI = (String)0; lllllllllllllllIlIIIIllIlIlllIlI < lllllllllllllllIlIIIIllIlIlllIIl; ++lllllllllllllllIlIIIIllIlIlllIlI) {
                        final EnumFacing lllllllllllllllIlIIIIllIlllIIIII = lllllllllllllllIlIIIIllIlIlllIII[lllllllllllllllIlIIIIllIlIlllIlI];
                        final int lllllllllllllllIlIIIIllIllIlllll = lllllllllllllllIlIIIIllIlllIlIlI + lllllllllllllllIlIIIIllIlllIIIII.getFrontOffsetX();
                        final int lllllllllllllllIlIIIIllIllIllllI = lllllllllllllllIlIIIIllIlllIlIIl + lllllllllllllllIlIIIIllIlllIIIII.getFrontOffsetY();
                        final int lllllllllllllllIlIIIIllIllIlllIl = lllllllllllllllIlIIIIllIlllIlIII + lllllllllllllllIlIIIIllIlllIIIII.getFrontOffsetZ();
                        lllllllllllllllIlIIIIllIlllIIIIl.setPos(lllllllllllllllIlIIIIllIllIlllll, lllllllllllllllIlIIIIllIllIllllI, lllllllllllllllIlIIIIllIllIlllIl);
                        final int lllllllllllllllIlIIIIllIllIlllII = Math.max(1, this.getBlockState(lllllllllllllllIlIIIIllIlllIIIIl).getLightOpacity());
                        lllllllllllllllIlIIIIllIlllIIlIl = this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIlllIIIIl);
                        if (lllllllllllllllIlIIIIllIlllIIlIl == lllllllllllllllIlIIIIllIlllIIlll - lllllllllllllllIlIIIIllIllIlllII && lllllllllllllllIlIIIIllIllllIIIl < this.lightUpdateBlockList.length) {
                            this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIIl++] = (lllllllllllllllIlIIIIllIllIlllll - lllllllllllllllIlIIIIllIlllIlllI + 32 | lllllllllllllllIlIIIIllIllIllllI - lllllllllllllllIlIIIIllIlllIllIl + 32 << 6 | lllllllllllllllIlIIIIllIllIlllIl - lllllllllllllllIlIIIIllIlllIllII + 32 << 12 | lllllllllllllllIlIIIIllIlllIIlll - lllllllllllllllIlIIIIllIllIlllII << 18);
                        }
                    }
                    lllllllllllllllIlIIIIllIlllIIIIl.release();
                }
            }
            lllllllllllllllIlIIIIllIllllIIlI = 0;
        }
        this.theProfiler.endSection();
        this.theProfiler.startSection("checkedPosition < toCheckCount");
        while (lllllllllllllllIlIIIIllIllllIIlI < lllllllllllllllIlIIIIllIllllIIIl) {
            final int lllllllllllllllIlIIIIllIllIllIll = this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIlI++];
            final int lllllllllllllllIlIIIIllIllIllIlI = (lllllllllllllllIlIIIIllIllIllIll & 0x3F) - 32 + lllllllllllllllIlIIIIllIlllIlllI;
            final int lllllllllllllllIlIIIIllIllIllIIl = (lllllllllllllllIlIIIIllIllIllIll >> 6 & 0x3F) - 32 + lllllllllllllllIlIIIIllIlllIllIl;
            final int lllllllllllllllIlIIIIllIllIllIII = (lllllllllllllllIlIIIIllIllIllIll >> 12 & 0x3F) - 32 + lllllllllllllllIlIIIIllIlllIllII;
            final BlockPos lllllllllllllllIlIIIIllIllIlIlll = new BlockPos(lllllllllllllllIlIIIIllIllIllIlI, lllllllllllllllIlIIIIllIllIllIIl, lllllllllllllllIlIIIIllIllIllIII);
            final int lllllllllllllllIlIIIIllIllIlIllI = this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIllIlIlll);
            final int lllllllllllllllIlIIIIllIllIlIlIl = this.getRawLight(lllllllllllllllIlIIIIllIllIlIlll, lllllllllllllllIlIIIIllIllIIllll);
            if (lllllllllllllllIlIIIIllIllIlIlIl != lllllllllllllllIlIIIIllIllIlIllI) {
                this.setLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIllIlIlll, lllllllllllllllIlIIIIllIllIlIlIl);
                if (lllllllllllllllIlIIIIllIllIlIlIl <= lllllllllllllllIlIIIIllIllIlIllI) {
                    continue;
                }
                final int lllllllllllllllIlIIIIllIllIlIlII = Math.abs(lllllllllllllllIlIIIIllIllIllIlI - lllllllllllllllIlIIIIllIlllIlllI);
                final int lllllllllllllllIlIIIIllIllIlIIll = Math.abs(lllllllllllllllIlIIIIllIllIllIIl - lllllllllllllllIlIIIIllIlllIllIl);
                final int lllllllllllllllIlIIIIllIllIlIIlI = Math.abs(lllllllllllllllIlIIIIllIllIllIII - lllllllllllllllIlIIIIllIlllIllII);
                final boolean lllllllllllllllIlIIIIllIllIlIIIl = lllllllllllllllIlIIIIllIllllIIIl < this.lightUpdateBlockList.length - 6;
                if (lllllllllllllllIlIIIIllIllIlIlII + lllllllllllllllIlIIIIllIllIlIIll + lllllllllllllllIlIIIIllIllIlIIlI >= 17 || !lllllllllllllllIlIIIIllIllIlIIIl) {
                    continue;
                }
                if (this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIllIlIlll.west()) < lllllllllllllllIlIIIIllIllIlIlIl) {
                    this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIIl++] = lllllllllllllllIlIIIIllIllIllIlI - 1 - lllllllllllllllIlIIIIllIlllIlllI + 32 + (lllllllllllllllIlIIIIllIllIllIIl - lllllllllllllllIlIIIIllIlllIllIl + 32 << 6) + (lllllllllllllllIlIIIIllIllIllIII - lllllllllllllllIlIIIIllIlllIllII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIllIlIlll.east()) < lllllllllllllllIlIIIIllIllIlIlIl) {
                    this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIIl++] = lllllllllllllllIlIIIIllIllIllIlI + 1 - lllllllllllllllIlIIIIllIlllIlllI + 32 + (lllllllllllllllIlIIIIllIllIllIIl - lllllllllllllllIlIIIIllIlllIllIl + 32 << 6) + (lllllllllllllllIlIIIIllIllIllIII - lllllllllllllllIlIIIIllIlllIllII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIllIlIlll.down()) < lllllllllllllllIlIIIIllIllIlIlIl) {
                    this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIIl++] = lllllllllllllllIlIIIIllIllIllIlI - lllllllllllllllIlIIIIllIlllIlllI + 32 + (lllllllllllllllIlIIIIllIllIllIIl - 1 - lllllllllllllllIlIIIIllIlllIllIl + 32 << 6) + (lllllllllllllllIlIIIIllIllIllIII - lllllllllllllllIlIIIIllIlllIllII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIllIlIlll.up()) < lllllllllllllllIlIIIIllIllIlIlIl) {
                    this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIIl++] = lllllllllllllllIlIIIIllIllIllIlI - lllllllllllllllIlIIIIllIlllIlllI + 32 + (lllllllllllllllIlIIIIllIllIllIIl + 1 - lllllllllllllllIlIIIIllIlllIllIl + 32 << 6) + (lllllllllllllllIlIIIIllIllIllIII - lllllllllllllllIlIIIIllIlllIllII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIllIlIlll.north()) < lllllllllllllllIlIIIIllIllIlIlIl) {
                    this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIIl++] = lllllllllllllllIlIIIIllIllIllIlI - lllllllllllllllIlIIIIllIlllIlllI + 32 + (lllllllllllllllIlIIIIllIllIllIIl - lllllllllllllllIlIIIIllIlllIllIl + 32 << 6) + (lllllllllllllllIlIIIIllIllIllIII - 1 - lllllllllllllllIlIIIIllIlllIllII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllllllIlIIIIllIllIIllll, lllllllllllllllIlIIIIllIllIlIlll.south()) >= lllllllllllllllIlIIIIllIllIlIlIl) {
                    continue;
                }
                this.lightUpdateBlockList[lllllllllllllllIlIIIIllIllllIIIl++] = lllllllllllllllIlIIIIllIllIllIlI - lllllllllllllllIlIIIIllIlllIlllI + 32 + (lllllllllllllllIlIIIIllIllIllIIl - lllllllllllllllIlIIIIllIlllIllIl + 32 << 6) + (lllllllllllllllIlIIIIllIllIllIII + 1 - lllllllllllllllIlIIIIllIlllIllII + 32 << 12);
            }
        }
        this.theProfiler.endSection();
        return true;
    }
    
    public int getHeight() {
        return 256;
    }
    
    @Nullable
    public MinecraftServer getMinecraftServer() {
        return null;
    }
    
    public String getDebugLoadedEntities() {
        return String.valueOf(new StringBuilder("All: ").append(this.loadedEntityList.size()));
    }
    
    public BlockPos getSpawnPoint() {
        BlockPos lllllllllllllllIlIIIIlIIlIlIlIIl = new BlockPos(this.worldInfo.getSpawnX(), this.worldInfo.getSpawnY(), this.worldInfo.getSpawnZ());
        if (!this.getWorldBorder().contains(lllllllllllllllIlIIIIlIIlIlIlIIl)) {
            lllllllllllllllIlIIIIlIIlIlIlIIl = this.getHeight(new BlockPos(this.getWorldBorder().getCenterX(), 0.0, this.getWorldBorder().getCenterZ()));
        }
        return lllllllllllllllIlIIIIlIIlIlIlIIl;
    }
    
    public boolean func_190526_b(final int lllllllllllllllIlIIIlllIIIlIIlIl, final int lllllllllllllllIlIIIlllIIIlIIIIl) {
        return this.isChunkLoaded(lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIIIl, false) || this.chunkProvider.func_191062_e(lllllllllllllllIlIIIlllIIIlIIlIl, lllllllllllllllIlIIIlllIIIlIIIIl);
    }
    
    protected void onEntityRemoved(final Entity lllllllllllllllIlIIIlIllIIlIllll) {
        for (int lllllllllllllllIlIIIlIllIIlIlllI = 0; lllllllllllllllIlIIIlIllIIlIlllI < this.eventListeners.size(); ++lllllllllllllllIlIIIlIllIIlIlllI) {
            this.eventListeners.get(lllllllllllllllIlIIIlIllIIlIlllI).onEntityRemoved(lllllllllllllllIlIIIlIllIIlIllll);
        }
    }
    
    public void sendQuittingDisconnectingPacket() {
    }
    
    public int countEntities(final Class<?> lllllllllllllllIlIIIIllIIIIIIIIl) {
        int lllllllllllllllIlIIIIllIIIIIIIII = 0;
        for (final Entity lllllllllllllllIlIIIIlIlllllllll : this.loadedEntityList) {
            if ((!(lllllllllllllllIlIIIIlIlllllllll instanceof EntityLiving) || !((EntityLiving)lllllllllllllllIlIIIIlIlllllllll).isNoDespawnRequired()) && lllllllllllllllIlIIIIllIIIIIIIIl.isAssignableFrom(lllllllllllllllIlIIIIlIlllllllll.getClass())) {
                ++lllllllllllllllIlIIIIllIIIIIIIII;
            }
        }
        return lllllllllllllllIlIIIIllIIIIIIIII;
    }
    
    public void notifyLightSet(final BlockPos lllllllllllllllIlIIIllIIlIllIIlI) {
        for (int lllllllllllllllIlIIIllIIlIllIlII = 0; lllllllllllllllIlIIIllIIlIllIlII < this.eventListeners.size(); ++lllllllllllllllIlIIIllIIlIllIlII) {
            this.eventListeners.get(lllllllllllllllIlIIIllIIlIllIlII).notifyLightSet(lllllllllllllllIlIIIllIIlIllIIlI);
        }
    }
    
    public void updateEntityWithOptionalForce(final Entity lllllllllllllllIlIIIlIIlIlllIIlI, final boolean lllllllllllllllIlIIIlIIlIllIIlll) {
        if (!(lllllllllllllllIlIIIlIIlIlllIIlI instanceof EntityPlayer)) {
            final int lllllllllllllllIlIIIlIIlIlllIIII = MathHelper.floor(lllllllllllllllIlIIIlIIlIlllIIlI.posX);
            final int lllllllllllllllIlIIIlIIlIllIllll = MathHelper.floor(lllllllllllllllIlIIIlIIlIlllIIlI.posZ);
            final int lllllllllllllllIlIIIlIIlIllIlllI = 32;
            if (lllllllllllllllIlIIIlIIlIllIIlll && !this.isAreaLoaded(lllllllllllllllIlIIIlIIlIlllIIII - 32, 0, lllllllllllllllIlIIIlIIlIllIllll - 32, lllllllllllllllIlIIIlIIlIlllIIII + 32, 0, lllllllllllllllIlIIIlIIlIllIllll + 32, true)) {
                return;
            }
        }
        lllllllllllllllIlIIIlIIlIlllIIlI.lastTickPosX = lllllllllllllllIlIIIlIIlIlllIIlI.posX;
        lllllllllllllllIlIIIlIIlIlllIIlI.lastTickPosY = lllllllllllllllIlIIIlIIlIlllIIlI.posY;
        lllllllllllllllIlIIIlIIlIlllIIlI.lastTickPosZ = lllllllllllllllIlIIIlIIlIlllIIlI.posZ;
        lllllllllllllllIlIIIlIIlIlllIIlI.prevRotationYaw = lllllllllllllllIlIIIlIIlIlllIIlI.rotationYaw;
        lllllllllllllllIlIIIlIIlIlllIIlI.prevRotationPitch = lllllllllllllllIlIIIlIIlIlllIIlI.rotationPitch;
        if (lllllllllllllllIlIIIlIIlIllIIlll && lllllllllllllllIlIIIlIIlIlllIIlI.addedToChunk) {
            ++lllllllllllllllIlIIIlIIlIlllIIlI.ticksExisted;
            if (lllllllllllllllIlIIIlIIlIlllIIlI.isRiding()) {
                lllllllllllllllIlIIIlIIlIlllIIlI.updateRidden();
            }
            else {
                lllllllllllllllIlIIIlIIlIlllIIlI.onUpdate();
            }
        }
        this.theProfiler.startSection("chunkCheck");
        if (Double.isNaN(lllllllllllllllIlIIIlIIlIlllIIlI.posX) || Double.isInfinite(lllllllllllllllIlIIIlIIlIlllIIlI.posX)) {
            lllllllllllllllIlIIIlIIlIlllIIlI.posX = lllllllllllllllIlIIIlIIlIlllIIlI.lastTickPosX;
        }
        if (Double.isNaN(lllllllllllllllIlIIIlIIlIlllIIlI.posY) || Double.isInfinite(lllllllllllllllIlIIIlIIlIlllIIlI.posY)) {
            lllllllllllllllIlIIIlIIlIlllIIlI.posY = lllllllllllllllIlIIIlIIlIlllIIlI.lastTickPosY;
        }
        if (Double.isNaN(lllllllllllllllIlIIIlIIlIlllIIlI.posZ) || Double.isInfinite(lllllllllllllllIlIIIlIIlIlllIIlI.posZ)) {
            lllllllllllllllIlIIIlIIlIlllIIlI.posZ = lllllllllllllllIlIIIlIIlIlllIIlI.lastTickPosZ;
        }
        if (Double.isNaN(lllllllllllllllIlIIIlIIlIlllIIlI.rotationPitch) || Double.isInfinite(lllllllllllllllIlIIIlIIlIlllIIlI.rotationPitch)) {
            lllllllllllllllIlIIIlIIlIlllIIlI.rotationPitch = lllllllllllllllIlIIIlIIlIlllIIlI.prevRotationPitch;
        }
        if (Double.isNaN(lllllllllllllllIlIIIlIIlIlllIIlI.rotationYaw) || Double.isInfinite(lllllllllllllllIlIIIlIIlIlllIIlI.rotationYaw)) {
            lllllllllllllllIlIIIlIIlIlllIIlI.rotationYaw = lllllllllllllllIlIIIlIIlIlllIIlI.prevRotationYaw;
        }
        final int lllllllllllllllIlIIIlIIlIllIllIl = MathHelper.floor(lllllllllllllllIlIIIlIIlIlllIIlI.posX / 16.0);
        final int lllllllllllllllIlIIIlIIlIllIllII = MathHelper.floor(lllllllllllllllIlIIIlIIlIlllIIlI.posY / 16.0);
        final int lllllllllllllllIlIIIlIIlIllIlIll = MathHelper.floor(lllllllllllllllIlIIIlIIlIlllIIlI.posZ / 16.0);
        if (!lllllllllllllllIlIIIlIIlIlllIIlI.addedToChunk || lllllllllllllllIlIIIlIIlIlllIIlI.chunkCoordX != lllllllllllllllIlIIIlIIlIllIllIl || lllllllllllllllIlIIIlIIlIlllIIlI.chunkCoordY != lllllllllllllllIlIIIlIIlIllIllII || lllllllllllllllIlIIIlIIlIlllIIlI.chunkCoordZ != lllllllllllllllIlIIIlIIlIllIlIll) {
            if (lllllllllllllllIlIIIlIIlIlllIIlI.addedToChunk && this.isChunkLoaded(lllllllllllllllIlIIIlIIlIlllIIlI.chunkCoordX, lllllllllllllllIlIIIlIIlIlllIIlI.chunkCoordZ, true)) {
                this.getChunkFromChunkCoords(lllllllllllllllIlIIIlIIlIlllIIlI.chunkCoordX, lllllllllllllllIlIIIlIIlIlllIIlI.chunkCoordZ).removeEntityAtIndex(lllllllllllllllIlIIIlIIlIlllIIlI, lllllllllllllllIlIIIlIIlIlllIIlI.chunkCoordY);
            }
            if (!lllllllllllllllIlIIIlIIlIlllIIlI.setPositionNonDirty() && !this.isChunkLoaded(lllllllllllllllIlIIIlIIlIllIllIl, lllllllllllllllIlIIIlIIlIllIlIll, true)) {
                lllllllllllllllIlIIIlIIlIlllIIlI.addedToChunk = false;
            }
            else {
                this.getChunkFromChunkCoords(lllllllllllllllIlIIIlIIlIllIllIl, lllllllllllllllIlIIIlIIlIllIlIll).addEntity(lllllllllllllllIlIIIlIIlIlllIIlI);
            }
        }
        this.theProfiler.endSection();
        if (lllllllllllllllIlIIIlIIlIllIIlll && lllllllllllllllIlIIIlIIlIlllIIlI.addedToChunk) {
            for (final Entity lllllllllllllllIlIIIlIIlIllIlIlI : lllllllllllllllIlIIIlIIlIlllIIlI.getPassengers()) {
                if (!lllllllllllllllIlIIIlIIlIllIlIlI.isDead && lllllllllllllllIlIIIlIIlIllIlIlI.getRidingEntity() == lllllllllllllllIlIIIlIIlIlllIIlI) {
                    this.updateEntity(lllllllllllllllIlIIIlIIlIllIlIlI);
                }
                else {
                    lllllllllllllllIlIIIlIIlIllIlIlI.dismountRidingEntity();
                }
            }
        }
    }
    
    public int getMoonPhase() {
        return this.provider.getMoonPhase(this.worldInfo.getWorldTime());
    }
    
    public boolean isBlockPowered(final BlockPos lllllllllllllllIlIIIIlIllIIllIlI) {
        return this.getRedstonePower(lllllllllllllllIlIIIIlIllIIllIlI.down(), EnumFacing.DOWN) > 0 || this.getRedstonePower(lllllllllllllllIlIIIIlIllIIllIlI.up(), EnumFacing.UP) > 0 || this.getRedstonePower(lllllllllllllllIlIIIIlIllIIllIlI.north(), EnumFacing.NORTH) > 0 || this.getRedstonePower(lllllllllllllllIlIIIIlIllIIllIlI.south(), EnumFacing.SOUTH) > 0 || this.getRedstonePower(lllllllllllllllIlIIIIlIllIIllIlI.west(), EnumFacing.WEST) > 0 || this.getRedstonePower(lllllllllllllllIlIIIIlIllIIllIlI.east(), EnumFacing.EAST) > 0;
    }
    
    protected abstract IChunkProvider createChunkProvider();
    
    public Chunk getChunkFromChunkCoords(final int lllllllllllllllIlIIIlllIIIlIlllI, final int lllllllllllllllIlIIIlllIIIlIllIl) {
        return this.chunkProvider.provideChunk(lllllllllllllllIlIIIlllIIIlIlllI, lllllllllllllllIlIIIlllIIIlIllIl);
    }
    
    public boolean isBlockLoaded(final BlockPos lllllllllllllllIlIIIlllIllIIIIll) {
        return this.isBlockLoaded(lllllllllllllllIlIIIlllIllIIIIll, true);
    }
    
    public float getStarBrightness(final float lllllllllllllllIlIIIlIIlllIllIll) {
        final float lllllllllllllllIlIIIlIIlllIllllI = this.getCelestialAngle(lllllllllllllllIlIIIlIIlllIllIll);
        float lllllllllllllllIlIIIlIIlllIlllIl = 1.0f - (MathHelper.cos(lllllllllllllllIlIIIlIIlllIllllI * 6.2831855f) * 2.0f + 0.25f);
        lllllllllllllllIlIIIlIIlllIlllIl = MathHelper.clamp(lllllllllllllllIlIIIlIIlllIlllIl, 0.0f, 1.0f);
        return lllllllllllllllIlIIIlIIlllIlllIl * lllllllllllllllIlIIIlIIlllIlllIl * 0.5f;
    }
    
    private int getRawLight(final BlockPos lllllllllllllllIlIIIIlllIIlIIIII, final EnumSkyBlock lllllllllllllllIlIIIIlllIIIlllll) {
        if (lllllllllllllllIlIIIIlllIIIlllll == EnumSkyBlock.SKY && this.canSeeSky(lllllllllllllllIlIIIIlllIIlIIIII)) {
            return 15;
        }
        final IBlockState lllllllllllllllIlIIIIlllIIlIlIII = this.getBlockState(lllllllllllllllIlIIIIlllIIlIIIII);
        int lllllllllllllllIlIIIIlllIIlIIlll = (lllllllllllllllIlIIIIlllIIIlllll == EnumSkyBlock.SKY) ? 0 : lllllllllllllllIlIIIIlllIIlIlIII.getLightValue();
        int lllllllllllllllIlIIIIlllIIlIIllI = lllllllllllllllIlIIIIlllIIlIlIII.getLightOpacity();
        if (lllllllllllllllIlIIIIlllIIlIIllI >= 15 && lllllllllllllllIlIIIIlllIIlIlIII.getLightValue() > 0) {
            lllllllllllllllIlIIIIlllIIlIIllI = 1;
        }
        if (lllllllllllllllIlIIIIlllIIlIIllI < 1) {
            lllllllllllllllIlIIIIlllIIlIIllI = 1;
        }
        if (lllllllllllllllIlIIIIlllIIlIIllI >= 15) {
            return 0;
        }
        if (lllllllllllllllIlIIIIlllIIlIIlll >= 14) {
            return lllllllllllllllIlIIIIlllIIlIIlll;
        }
        final BlockPos.PooledMutableBlockPos lllllllllllllllIlIIIIlllIIlIIlIl = BlockPos.PooledMutableBlockPos.retain();
        try {
            final float lllllllllllllllIlIIIIlllIIIlIlll;
            final int lllllllllllllllIlIIIIlllIIIllIII = ((EnumFacing[])(Object)(lllllllllllllllIlIIIIlllIIIlIlll = (float)(Object)EnumFacing.values())).length;
            for (long lllllllllllllllIlIIIIlllIIIllIIl = 0; lllllllllllllllIlIIIIlllIIIllIIl < lllllllllllllllIlIIIIlllIIIllIII; ++lllllllllllllllIlIIIIlllIIIllIIl) {
                final EnumFacing lllllllllllllllIlIIIIlllIIlIIlII = lllllllllllllllIlIIIIlllIIIlIlll[lllllllllllllllIlIIIIlllIIIllIIl];
                lllllllllllllllIlIIIIlllIIlIIlIl.setPos(lllllllllllllllIlIIIIlllIIlIIIII).move(lllllllllllllllIlIIIIlllIIlIIlII);
                final int lllllllllllllllIlIIIIlllIIlIIIll = this.getLightFor(lllllllllllllllIlIIIIlllIIIlllll, lllllllllllllllIlIIIIlllIIlIIlIl) - lllllllllllllllIlIIIIlllIIlIIllI;
                if (lllllllllllllllIlIIIIlllIIlIIIll > lllllllllllllllIlIIIIlllIIlIIlll) {
                    lllllllllllllllIlIIIIlllIIlIIlll = lllllllllllllllIlIIIIlllIIlIIIll;
                }
                if (lllllllllllllllIlIIIIlllIIlIIlll >= 14) {
                    final boolean lllllllllllllllIlIIIIlllIIIlIIll;
                    final int lllllllllllllllIlIIIIlllIIlIIIlI = (lllllllllllllllIlIIIIlllIIIlIIll = (lllllllllllllllIlIIIIlllIIlIIlll != 0)) ? 1 : 0;
                    return lllllllllllllllIlIIIIlllIIIlIIll ? 1 : 0;
                }
            }
            boolean lllllllllllllllIlIIIIlllIIIlIIll = lllllllllllllllIlIIIIlllIIlIIlll != 0;
            return lllllllllllllllIlIIIIlllIIIlIIll ? 1 : 0;
        }
        finally {
            lllllllllllllllIlIIIIlllIIlIIlIl.release();
        }
    }
    
    protected void calculateInitialWeather() {
        if (this.worldInfo.isRaining()) {
            this.rainingStrength = 1.0f;
            if (this.worldInfo.isThundering()) {
                this.thunderingStrength = 1.0f;
            }
        }
    }
    
    public IBlockState getGroundAboveSeaLevel(final BlockPos lllllllllllllllIlIIIlllIlllIllIl) {
        BlockPos lllllllllllllllIlIIIlllIlllIllII;
        for (lllllllllllllllIlIIIlllIlllIllII = new BlockPos(lllllllllllllllIlIIIlllIlllIllIl.getX(), this.getSeaLevel(), lllllllllllllllIlIIIlllIlllIllIl.getZ()); !this.isAirBlock(lllllllllllllllIlIIIlllIlllIllII.up()); lllllllllllllllIlIIIlllIlllIllII = lllllllllllllllIlIIIlllIlllIllII.up()) {}
        return this.getBlockState(lllllllllllllllIlIIIlllIlllIllII);
    }
    
    public WorldBorder getWorldBorder() {
        return this.worldBorder;
    }
    
    public float getCelestialAngleRadians(final float lllllllllllllllIlIIIlIlIIIlIlIlI) {
        final float lllllllllllllllIlIIIlIlIIIlIllII = this.getCelestialAngle(lllllllllllllllIlIIIlIlIIIlIlIlI);
        return lllllllllllllllIlIIIlIlIIIlIllII * 6.2831855f;
    }
    
    protected void updateBlocks() {
    }
    
    public int calculateSkylightSubtracted(final float lllllllllllllllIlIIIlIlIlIIIllII) {
        final float lllllllllllllllIlIIIlIlIlIIIlIll = this.getCelestialAngle(lllllllllllllllIlIIIlIlIlIIIllII);
        float lllllllllllllllIlIIIlIlIlIIIlIlI = 1.0f - (MathHelper.cos(lllllllllllllllIlIIIlIlIlIIIlIll * 6.2831855f) * 2.0f + 0.5f);
        lllllllllllllllIlIIIlIlIlIIIlIlI = MathHelper.clamp(lllllllllllllllIlIIIlIlIlIIIlIlI, 0.0f, 1.0f);
        lllllllllllllllIlIIIlIlIlIIIlIlI = 1.0f - lllllllllllllllIlIIIlIlIlIIIlIlI;
        lllllllllllllllIlIIIlIlIlIIIlIlI *= (float)(1.0 - this.getRainStrength(lllllllllllllllIlIIIlIlIlIIIllII) * 5.0f / 16.0);
        lllllllllllllllIlIIIlIlIlIIIlIlI *= (float)(1.0 - this.getThunderStrength(lllllllllllllllIlIIIlIlIlIIIllII) * 5.0f / 16.0);
        lllllllllllllllIlIIIlIlIlIIIlIlI = 1.0f - lllllllllllllllIlIIIlIlIlIIIlIlI;
        return (int)(lllllllllllllllIlIIIlIlIlIIIlIlI * 11.0f);
    }
    
    public int getHeight(final int lllllllllllllllIlIIIllIIllllllII, final int lllllllllllllllIlIIIllIIlllllIll) {
        int lllllllllllllllIlIIIllIIlllllllI = 0;
        if (lllllllllllllllIlIIIllIIllllllII >= -30000000 && lllllllllllllllIlIIIllIIlllllIll >= -30000000 && lllllllllllllllIlIIIllIIllllllII < 30000000 && lllllllllllllllIlIIIllIIlllllIll < 30000000) {
            if (this.isChunkLoaded(lllllllllllllllIlIIIllIIllllllII >> 4, lllllllllllllllIlIIIllIIlllllIll >> 4, true)) {
                final int lllllllllllllllIlIIIllIlIIIIIIII = this.getChunkFromChunkCoords(lllllllllllllllIlIIIllIIllllllII >> 4, lllllllllllllllIlIIIllIIlllllIll >> 4).getHeightValue(lllllllllllllllIlIIIllIIllllllII & 0xF, lllllllllllllllIlIIIllIIlllllIll & 0xF);
            }
            else {
                final int lllllllllllllllIlIIIllIIllllllll = 0;
            }
        }
        else {
            lllllllllllllllIlIIIllIIlllllllI = this.getSeaLevel() + 1;
        }
        return lllllllllllllllIlIIIllIIlllllllI;
    }
    
    public boolean setBlockToAir(final BlockPos lllllllllllllllIlIIIlllIIIIIlIII) {
        return this.setBlockState(lllllllllllllllIlIIIlllIIIIIlIII, Blocks.AIR.getDefaultState(), 3);
    }
    
    public Vec3d getFogColor(final float lllllllllllllllIlIIIlIlIIIIIIIIl) {
        final float lllllllllllllllIlIIIlIlIIIIIIIII = this.getCelestialAngle(lllllllllllllllIlIIIlIlIIIIIIIIl);
        return this.provider.getFogColor(lllllllllllllllIlIIIlIlIIIIIIIII, lllllllllllllllIlIIIlIlIIIIIIIIl);
    }
    
    public boolean checkBlockCollision(final AxisAlignedBB lllllllllllllllIlIIIlIIlIIlIlllI) {
        final int lllllllllllllllIlIIIlIIlIIlllIlI = MathHelper.floor(lllllllllllllllIlIIIlIIlIIlIlllI.minX);
        final int lllllllllllllllIlIIIlIIlIIlllIIl = MathHelper.ceil(lllllllllllllllIlIIIlIIlIIlIlllI.maxX);
        final int lllllllllllllllIlIIIlIIlIIlllIII = MathHelper.floor(lllllllllllllllIlIIIlIIlIIlIlllI.minY);
        final int lllllllllllllllIlIIIlIIlIIllIlll = MathHelper.ceil(lllllllllllllllIlIIIlIIlIIlIlllI.maxY);
        final int lllllllllllllllIlIIIlIIlIIllIllI = MathHelper.floor(lllllllllllllllIlIIIlIIlIIlIlllI.minZ);
        final int lllllllllllllllIlIIIlIIlIIllIlIl = MathHelper.ceil(lllllllllllllllIlIIIlIIlIIlIlllI.maxZ);
        final BlockPos.PooledMutableBlockPos lllllllllllllllIlIIIlIIlIIllIlII = BlockPos.PooledMutableBlockPos.retain();
        for (int lllllllllllllllIlIIIlIIlIIllIIll = lllllllllllllllIlIIIlIIlIIlllIlI; lllllllllllllllIlIIIlIIlIIllIIll < lllllllllllllllIlIIIlIIlIIlllIIl; ++lllllllllllllllIlIIIlIIlIIllIIll) {
            for (int lllllllllllllllIlIIIlIIlIIllIIlI = lllllllllllllllIlIIIlIIlIIlllIII; lllllllllllllllIlIIIlIIlIIllIIlI < lllllllllllllllIlIIIlIIlIIllIlll; ++lllllllllllllllIlIIIlIIlIIllIIlI) {
                for (int lllllllllllllllIlIIIlIIlIIllIIIl = lllllllllllllllIlIIIlIIlIIllIllI; lllllllllllllllIlIIIlIIlIIllIIIl < lllllllllllllllIlIIIlIIlIIllIlIl; ++lllllllllllllllIlIIIlIIlIIllIIIl) {
                    final IBlockState lllllllllllllllIlIIIlIIlIIllIIII = this.getBlockState(lllllllllllllllIlIIIlIIlIIllIlII.setPos(lllllllllllllllIlIIIlIIlIIllIIll, lllllllllllllllIlIIIlIIlIIllIIlI, lllllllllllllllIlIIIlIIlIIllIIIl));
                    if (lllllllllllllllIlIIIlIIlIIllIIII.getMaterial() != Material.AIR) {
                        lllllllllllllllIlIIIlIIlIIllIlII.release();
                        return true;
                    }
                }
            }
        }
        lllllllllllllllIlIIIlIIlIIllIlII.release();
        return false;
    }
    
    public BlockPos getTopSolidOrLiquidBlock(final BlockPos lllllllllllllllIlIIIlIIllllIlIIl) {
        final Chunk lllllllllllllllIlIIIlIIllllIlllI = this.getChunkFromBlockCoords(lllllllllllllllIlIIIlIIllllIlIIl);
        BlockPos lllllllllllllllIlIIIlIIllllIllIl;
        BlockPos lllllllllllllllIlIIIlIIllllIllII;
        for (lllllllllllllllIlIIIlIIllllIllIl = new BlockPos(lllllllllllllllIlIIIlIIllllIlIIl.getX(), lllllllllllllllIlIIIlIIllllIlllI.getTopFilledSegment() + 16, lllllllllllllllIlIIIlIIllllIlIIl.getZ()); lllllllllllllllIlIIIlIIllllIllIl.getY() >= 0; lllllllllllllllIlIIIlIIllllIllIl = lllllllllllllllIlIIIlIIllllIllII) {
            lllllllllllllllIlIIIlIIllllIllII = lllllllllllllllIlIIIlIIllllIllIl.down();
            final Material lllllllllllllllIlIIIlIIllllIlIll = lllllllllllllllIlIIIlIIllllIlllI.getBlockState(lllllllllllllllIlIIIlIIllllIllII).getMaterial();
            if (lllllllllllllllIlIIIlIIllllIlIll.blocksMovement() && lllllllllllllllIlIIIlIIllllIlIll != Material.LEAVES) {
                break;
            }
        }
        return lllllllllllllllIlIIIlIIllllIllIl;
    }
    
    public boolean isFlammableWithin(final AxisAlignedBB lllllllllllllllIlIIIlIIIlllIllIl) {
        final int lllllllllllllllIlIIIlIIIlllIllII = MathHelper.floor(lllllllllllllllIlIIIlIIIlllIllIl.minX);
        final int lllllllllllllllIlIIIlIIIlllIlIll = MathHelper.ceil(lllllllllllllllIlIIIlIIIlllIllIl.maxX);
        final int lllllllllllllllIlIIIlIIIlllIlIlI = MathHelper.floor(lllllllllllllllIlIIIlIIIlllIllIl.minY);
        final int lllllllllllllllIlIIIlIIIlllIlIIl = MathHelper.ceil(lllllllllllllllIlIIIlIIIlllIllIl.maxY);
        final int lllllllllllllllIlIIIlIIIlllIlIII = MathHelper.floor(lllllllllllllllIlIIIlIIIlllIllIl.minZ);
        final int lllllllllllllllIlIIIlIIIlllIIlll = MathHelper.ceil(lllllllllllllllIlIIIlIIIlllIllIl.maxZ);
        if (this.isAreaLoaded(lllllllllllllllIlIIIlIIIlllIllII, lllllllllllllllIlIIIlIIIlllIlIlI, lllllllllllllllIlIIIlIIIlllIlIII, lllllllllllllllIlIIIlIIIlllIlIll, lllllllllllllllIlIIIlIIIlllIlIIl, lllllllllllllllIlIIIlIIIlllIIlll, true)) {
            final BlockPos.PooledMutableBlockPos lllllllllllllllIlIIIlIIIlllIIllI = BlockPos.PooledMutableBlockPos.retain();
            for (int lllllllllllllllIlIIIlIIIlllIIlIl = lllllllllllllllIlIIIlIIIlllIllII; lllllllllllllllIlIIIlIIIlllIIlIl < lllllllllllllllIlIIIlIIIlllIlIll; ++lllllllllllllllIlIIIlIIIlllIIlIl) {
                for (int lllllllllllllllIlIIIlIIIlllIIlII = lllllllllllllllIlIIIlIIIlllIlIlI; lllllllllllllllIlIIIlIIIlllIIlII < lllllllllllllllIlIIIlIIIlllIlIIl; ++lllllllllllllllIlIIIlIIIlllIIlII) {
                    for (int lllllllllllllllIlIIIlIIIlllIIIll = lllllllllllllllIlIIIlIIIlllIlIII; lllllllllllllllIlIIIlIIIlllIIIll < lllllllllllllllIlIIIlIIIlllIIlll; ++lllllllllllllllIlIIIlIIIlllIIIll) {
                        final Block lllllllllllllllIlIIIlIIIlllIIIlI = this.getBlockState(lllllllllllllllIlIIIlIIIlllIIllI.setPos(lllllllllllllllIlIIIlIIIlllIIlIl, lllllllllllllllIlIIIlIIIlllIIlII, lllllllllllllllIlIIIlIIIlllIIIll)).getBlock();
                        if (lllllllllllllllIlIIIlIIIlllIIIlI == Blocks.FIRE || lllllllllllllllIlIIIlIIIlllIIIlI == Blocks.FLOWING_LAVA || lllllllllllllllIlIIIlIIIlllIIIlI == Blocks.LAVA) {
                            lllllllllllllllIlIIIlIIIlllIIllI.release();
                            return true;
                        }
                    }
                }
            }
            lllllllllllllllIlIIIlIIIlllIIllI.release();
        }
        return false;
    }
    
    public Explosion createExplosion(@Nullable final Entity lllllllllllllllIlIIIlIIIIllIlIll, final double lllllllllllllllIlIIIlIIIIllIlIlI, final double lllllllllllllllIlIIIlIIIIllIIIlI, final double lllllllllllllllIlIIIlIIIIllIlIII, final float lllllllllllllllIlIIIlIIIIllIIIII, final boolean lllllllllllllllIlIIIlIIIIlIlllll) {
        return this.newExplosion(lllllllllllllllIlIIIlIIIIllIlIll, lllllllllllllllIlIIIlIIIIllIlIlI, lllllllllllllllIlIIIlIIIIllIIIlI, lllllllllllllllIlIIIlIIIIllIlIII, lllllllllllllllIlIIIlIIIIllIIIII, false, lllllllllllllllIlIIIlIIIIlIlllll);
    }
    
    public long getSeed() {
        return this.worldInfo.getSeed();
    }
    
    public void spawnParticle(final EnumParticleTypes lllllllllllllllIlIIIlIlllIIIlIII, final boolean lllllllllllllllIlIIIlIllIlllllIl, final double lllllllllllllllIlIIIlIllIlllllII, final double lllllllllllllllIlIIIlIlllIIIIlIl, final double lllllllllllllllIlIIIlIlllIIIIlII, final double lllllllllllllllIlIIIlIlllIIIIIll, final double lllllllllllllllIlIIIlIlllIIIIIlI, final double lllllllllllllllIlIIIlIlllIIIIIIl, final int... lllllllllllllllIlIIIlIlllIIIIIII) {
        this.spawnParticle(lllllllllllllllIlIIIlIlllIIIlIII.getParticleID(), lllllllllllllllIlIIIlIlllIIIlIII.getShouldIgnoreRange() || lllllllllllllllIlIIIlIllIlllllIl, lllllllllllllllIlIIIlIllIlllllII, lllllllllllllllIlIIIlIlllIIIIlIl, lllllllllllllllIlIIIlIlllIIIIlII, lllllllllllllllIlIIIlIlllIIIIIll, lllllllllllllllIlIIIlIlllIIIIIlI, lllllllllllllllIlIIIlIlllIIIIIIl, lllllllllllllllIlIIIlIlllIIIIIII);
    }
    
    public World init() {
        return this;
    }
    
    public List<Entity> getEntitiesWithinAABBExcludingEntity(@Nullable final Entity lllllllllllllllIlIIIIllIlIlIIlll, final AxisAlignedBB lllllllllllllllIlIIIIllIlIlIIIll) {
        return this.getEntitiesInAABBexcluding(lllllllllllllllIlIIIIllIlIlIIlll, lllllllllllllllIlIIIIllIlIlIIIll, EntitySelectors.NOT_SPECTATING);
    }
    
    @Nullable
    public EntityPlayer getPlayerEntityByName(final String lllllllllllllllIlIIIIlIIllIllIII) {
        for (int lllllllllllllllIlIIIIlIIllIlIlll = 0; lllllllllllllllIlIIIIlIIllIlIlll < this.playerEntities.size(); ++lllllllllllllllIlIIIIlIIllIlIlll) {
            final EntityPlayer lllllllllllllllIlIIIIlIIllIlIllI = this.playerEntities.get(lllllllllllllllIlIIIIlIIllIlIlll);
            if (lllllllllllllllIlIIIIlIIllIllIII.equals(lllllllllllllllIlIIIIlIIllIlIllI.getName())) {
                return lllllllllllllllIlIIIIlIIllIlIllI;
            }
        }
        return null;
    }
    
    public void playSound(@Nullable final EntityPlayer lllllllllllllllIlIIIllIIIIIIllII, final BlockPos lllllllllllllllIlIIIllIIIIIIlIll, final SoundEvent lllllllllllllllIlIIIllIIIIIIlIlI, final SoundCategory lllllllllllllllIlIIIllIIIIIIlIIl, final float lllllllllllllllIlIIIllIIIIIIIIIl, final float lllllllllllllllIlIIIllIIIIIIIIII) {
        this.playSound(lllllllllllllllIlIIIllIIIIIIllII, lllllllllllllllIlIIIllIIIIIIlIll.getX() + 0.5, lllllllllllllllIlIIIllIIIIIIlIll.getY() + 0.5, lllllllllllllllIlIIIllIIIIIIlIll.getZ() + 0.5, lllllllllllllllIlIIIllIIIIIIlIlI, lllllllllllllllIlIIIllIIIIIIlIIl, lllllllllllllllIlIIIllIIIIIIIIIl, lllllllllllllllIlIIIllIIIIIIIIII);
    }
    
    public Vec3d getCloudColour(final float lllllllllllllllIlIIIlIlIIIIlllII) {
        final float lllllllllllllllIlIIIlIlIIIIllIll = this.getCelestialAngle(lllllllllllllllIlIIIlIlIIIIlllII);
        float lllllllllllllllIlIIIlIlIIIIllIlI = MathHelper.cos(lllllllllllllllIlIIIlIlIIIIllIll * 6.2831855f) * 2.0f + 0.5f;
        lllllllllllllllIlIIIlIlIIIIllIlI = MathHelper.clamp(lllllllllllllllIlIIIlIlIIIIllIlI, 0.0f, 1.0f);
        float lllllllllllllllIlIIIlIlIIIIllIIl = 1.0f;
        float lllllllllllllllIlIIIlIlIIIIllIII = 1.0f;
        float lllllllllllllllIlIIIlIlIIIIlIlll = 1.0f;
        final float lllllllllllllllIlIIIlIlIIIIlIllI = this.getRainStrength(lllllllllllllllIlIIIlIlIIIIlllII);
        if (lllllllllllllllIlIIIlIlIIIIlIllI > 0.0f) {
            final float lllllllllllllllIlIIIlIlIIIIlIlIl = (lllllllllllllllIlIIIlIlIIIIllIIl * 0.3f + lllllllllllllllIlIIIlIlIIIIllIII * 0.59f + lllllllllllllllIlIIIlIlIIIIlIlll * 0.11f) * 0.6f;
            final float lllllllllllllllIlIIIlIlIIIIlIlII = 1.0f - lllllllllllllllIlIIIlIlIIIIlIllI * 0.95f;
            lllllllllllllllIlIIIlIlIIIIllIIl = lllllllllllllllIlIIIlIlIIIIllIIl * lllllllllllllllIlIIIlIlIIIIlIlII + lllllllllllllllIlIIIlIlIIIIlIlIl * (1.0f - lllllllllllllllIlIIIlIlIIIIlIlII);
            lllllllllllllllIlIIIlIlIIIIllIII = lllllllllllllllIlIIIlIlIIIIllIII * lllllllllllllllIlIIIlIlIIIIlIlII + lllllllllllllllIlIIIlIlIIIIlIlIl * (1.0f - lllllllllllllllIlIIIlIlIIIIlIlII);
            lllllllllllllllIlIIIlIlIIIIlIlll = lllllllllllllllIlIIIlIlIIIIlIlll * lllllllllllllllIlIIIlIlIIIIlIlII + lllllllllllllllIlIIIlIlIIIIlIlIl * (1.0f - lllllllllllllllIlIIIlIlIIIIlIlII);
        }
        lllllllllllllllIlIIIlIlIIIIllIIl *= lllllllllllllllIlIIIlIlIIIIllIlI * 0.9f + 0.1f;
        lllllllllllllllIlIIIlIlIIIIllIII *= lllllllllllllllIlIIIlIlIIIIllIlI * 0.9f + 0.1f;
        lllllllllllllllIlIIIlIlIIIIlIlll *= lllllllllllllllIlIIIlIlIIIIllIlI * 0.85f + 0.15f;
        final float lllllllllllllllIlIIIlIlIIIIlIIll = this.getThunderStrength(lllllllllllllllIlIIIlIlIIIIlllII);
        if (lllllllllllllllIlIIIlIlIIIIlIIll > 0.0f) {
            final float lllllllllllllllIlIIIlIlIIIIlIIlI = (lllllllllllllllIlIIIlIlIIIIllIIl * 0.3f + lllllllllllllllIlIIIlIlIIIIllIII * 0.59f + lllllllllllllllIlIIIlIlIIIIlIlll * 0.11f) * 0.2f;
            final float lllllllllllllllIlIIIlIlIIIIlIIIl = 1.0f - lllllllllllllllIlIIIlIlIIIIlIIll * 0.95f;
            lllllllllllllllIlIIIlIlIIIIllIIl = lllllllllllllllIlIIIlIlIIIIllIIl * lllllllllllllllIlIIIlIlIIIIlIIIl + lllllllllllllllIlIIIlIlIIIIlIIlI * (1.0f - lllllllllllllllIlIIIlIlIIIIlIIIl);
            lllllllllllllllIlIIIlIlIIIIllIII = lllllllllllllllIlIIIlIlIIIIllIII * lllllllllllllllIlIIIlIlIIIIlIIIl + lllllllllllllllIlIIIlIlIIIIlIIlI * (1.0f - lllllllllllllllIlIIIlIlIIIIlIIIl);
            lllllllllllllllIlIIIlIlIIIIlIlll = lllllllllllllllIlIIIlIlIIIIlIlll * lllllllllllllllIlIIIlIlIIIIlIIIl + lllllllllllllllIlIIIlIlIIIIlIIlI * (1.0f - lllllllllllllllIlIIIlIlIIIIlIIIl);
        }
        return new Vec3d(lllllllllllllllIlIIIlIlIIIIllIIl, lllllllllllllllIlIIIlIlIIIIllIII, lllllllllllllllIlIIIlIlIIIIlIlll);
    }
    
    public void setItemData(final String lllllllllllllllIlIIIIlIIIIllIIIl, final WorldSavedData lllllllllllllllIlIIIIlIIIIllIIll) {
        this.mapStorage.setData(lllllllllllllllIlIIIIlIIIIllIIIl, lllllllllllllllIlIIIIlIIIIllIIll);
    }
    
    public void setTileEntity(final BlockPos lllllllllllllllIlIIIIllllllIIIIl, @Nullable final TileEntity lllllllllllllllIlIIIIllllllIIIII) {
        if (!this.isOutsideBuildHeight(lllllllllllllllIlIIIIllllllIIIIl) && lllllllllllllllIlIIIIllllllIIIII != null && !lllllllllllllllIlIIIIllllllIIIII.isInvalid()) {
            if (this.processingLoadedTiles) {
                lllllllllllllllIlIIIIllllllIIIII.setPos(lllllllllllllllIlIIIIllllllIIIIl);
                final Iterator<TileEntity> lllllllllllllllIlIIIIllllllIIlII = this.addedTileEntityList.iterator();
                while (lllllllllllllllIlIIIIllllllIIlII.hasNext()) {
                    final TileEntity lllllllllllllllIlIIIIllllllIIIll = lllllllllllllllIlIIIIllllllIIlII.next();
                    if (lllllllllllllllIlIIIIllllllIIIll.getPos().equals(lllllllllllllllIlIIIIllllllIIIIl)) {
                        lllllllllllllllIlIIIIllllllIIIll.invalidate();
                        lllllllllllllllIlIIIIllllllIIlII.remove();
                    }
                }
                this.addedTileEntityList.add(lllllllllllllllIlIIIIllllllIIIII);
            }
            else {
                this.getChunkFromBlockCoords(lllllllllllllllIlIIIIllllllIIIIl).addTileEntity(lllllllllllllllIlIIIIllllllIIIIl, lllllllllllllllIlIIIIllllllIIIII);
                this.addTileEntity(lllllllllllllllIlIIIIllllllIIIII);
            }
        }
    }
    
    public float getThunderStrength(final float lllllllllllllllIlIIIIlIIIllIlIII) {
        return (this.prevThunderingStrength + (this.thunderingStrength - this.prevThunderingStrength) * lllllllllllllllIlIIIIlIIIllIlIII) * this.getRainStrength(lllllllllllllllIlIIIIlIIIllIlIII);
    }
    
    public boolean isAreaLoaded(final BlockPos lllllllllllllllIlIIIlllIIllllIlI, final BlockPos lllllllllllllllIlIIIlllIIllllIIl) {
        return this.isAreaLoaded(lllllllllllllllIlIIIlllIIllllIlI, lllllllllllllllIlIIIlllIIllllIIl, true);
    }
    
    public boolean isAreaLoaded(final StructureBoundingBox lllllllllllllllIlIIIlllIIlIllIll, final boolean lllllllllllllllIlIIIlllIIlIllIlI) {
        return this.isAreaLoaded(lllllllllllllllIlIIIlllIIlIllIll.minX, lllllllllllllllIlIIIlllIIlIllIll.minY, lllllllllllllllIlIIIlllIIlIllIll.minZ, lllllllllllllllIlIIIlllIIlIllIll.maxX, lllllllllllllllIlIIIlllIIlIllIll.maxY, lllllllllllllllIlIIIlllIIlIllIll.maxZ, lllllllllllllllIlIIIlllIIlIllIlI);
    }
    
    @Nullable
    public EntityPlayer getNearestPlayerNotCreative(final Entity lllllllllllllllIlIIIIlIlIlllIIlI, final double lllllllllllllllIlIIIIlIlIlllIlII) {
        return this.getClosestPlayer(lllllllllllllllIlIIIIlIlIlllIIlI.posX, lllllllllllllllIlIIIIlIlIlllIIlI.posY, lllllllllllllllIlIIIIlIlIlllIIlI.posZ, lllllllllllllllIlIIIIlIlIlllIlII, true);
    }
    
    public <T extends Entity> List<T> getEntitiesWithinAABB(final Class<? extends T> lllllllllllllllIlIIIIllIIlIllIll, final AxisAlignedBB lllllllllllllllIlIIIIllIIlIllIlI) {
        return this.getEntitiesWithinAABB(lllllllllllllllIlIIIIllIIlIllIll, lllllllllllllllIlIIIIllIIlIllIlI, (com.google.common.base.Predicate<? super T>)EntitySelectors.NOT_SPECTATING);
    }
    
    public boolean extinguishFire(@Nullable final EntityPlayer lllllllllllllllIlIIIlIIIIIIIlIlI, BlockPos lllllllllllllllIlIIIlIIIIIIIlIIl, final EnumFacing lllllllllllllllIlIIIlIIIIIIIlIII) {
        lllllllllllllllIlIIIlIIIIIIIlIIl = (byte)((BlockPos)lllllllllllllllIlIIIlIIIIIIIlIIl).offset(lllllllllllllllIlIIIlIIIIIIIlIII);
        if (this.getBlockState((BlockPos)lllllllllllllllIlIIIlIIIIIIIlIIl).getBlock() == Blocks.FIRE) {
            this.playEvent(lllllllllllllllIlIIIlIIIIIIIlIlI, 1009, (BlockPos)lllllllllllllllIlIIIlIIIIIIIlIIl, 0);
            this.setBlockToAir((BlockPos)lllllllllllllllIlIIIlIIIIIIIlIIl);
            return true;
        }
        return false;
    }
    
    @Nullable
    public EntityPlayer getPlayerEntityByUUID(final UUID lllllllllllllllIlIIIIlIIllIIlIII) {
        for (int lllllllllllllllIlIIIIlIIllIIlIll = 0; lllllllllllllllIlIIIIlIIllIIlIll < this.playerEntities.size(); ++lllllllllllllllIlIIIIlIIllIIlIll) {
            final EntityPlayer lllllllllllllllIlIIIIlIIllIIlIlI = this.playerEntities.get(lllllllllllllllIlIIIIlIIllIIlIll);
            if (lllllllllllllllIlIIIIlIIllIIlIII.equals(lllllllllllllllIlIIIIlIIllIIlIlI.getUniqueID())) {
                return lllllllllllllllIlIIIIlIIllIIlIlI;
            }
        }
        return null;
    }
    
    public int getLastLightningBolt() {
        return this.lastLightningBolt;
    }
    
    public Scoreboard getScoreboard() {
        return this.worldScoreboard;
    }
    
    public void removeTileEntity(final BlockPos lllllllllllllllIlIIIIlllllIllIIl) {
        final TileEntity lllllllllllllllIlIIIIlllllIllIII = this.getTileEntity(lllllllllllllllIlIIIIlllllIllIIl);
        if (lllllllllllllllIlIIIIlllllIllIII != null && this.processingLoadedTiles) {
            lllllllllllllllIlIIIIlllllIllIII.invalidate();
            this.addedTileEntityList.remove(lllllllllllllllIlIIIIlllllIllIII);
        }
        else {
            if (lllllllllllllllIlIIIIlllllIllIII != null) {
                this.addedTileEntityList.remove(lllllllllllllllIlIIIIlllllIllIII);
                this.loadedTileEntityList.remove(lllllllllllllllIlIIIIlllllIllIII);
                this.tickableTileEntities.remove(lllllllllllllllIlIIIIlllllIllIII);
            }
            this.getChunkFromBlockCoords(lllllllllllllllIlIIIIlllllIllIIl).removeTileEntity(lllllllllllllllIlIIIIlllllIllIIl);
        }
    }
    
    public float getCurrentMoonPhaseFactor() {
        return WorldProvider.MOON_PHASE_FACTORS[this.provider.getMoonPhase(this.worldInfo.getWorldTime())];
    }
    
    public void setSkylightSubtracted(final int lllllllllllllllIlIIIIIllIlllllll) {
        this.skylightSubtracted = lllllllllllllllIlIIIIIllIlllllll;
    }
    
    public void updateEntities() {
        this.theProfiler.startSection("entities");
        this.theProfiler.startSection("global");
        for (int lllllllllllllllIlIIIlIIllIllllll = 0; lllllllllllllllIlIIIlIIllIllllll < this.weatherEffects.size(); ++lllllllllllllllIlIIIlIIllIllllll) {
            final Entity lllllllllllllllIlIIIlIIllIlllllI = this.weatherEffects.get(lllllllllllllllIlIIIlIIllIllllll);
            try {
                final Entity entity = lllllllllllllllIlIIIlIIllIlllllI;
                ++entity.ticksExisted;
                lllllllllllllllIlIIIlIIllIlllllI.onUpdate();
            }
            catch (Throwable lllllllllllllllIlIIIlIIllIllllIl) {
                final CrashReport lllllllllllllllIlIIIlIIllIllllII = CrashReport.makeCrashReport(lllllllllllllllIlIIIlIIllIllllIl, "Ticking entity");
                final CrashReportCategory lllllllllllllllIlIIIlIIllIlllIll = lllllllllllllllIlIIIlIIllIllllII.makeCategory("Entity being ticked");
                if (lllllllllllllllIlIIIlIIllIlllllI == null) {
                    lllllllllllllllIlIIIlIIllIlllIll.addCrashSection("Entity", "~~NULL~~");
                }
                else {
                    lllllllllllllllIlIIIlIIllIlllllI.addEntityCrashInfo(lllllllllllllllIlIIIlIIllIlllIll);
                }
                throw new ReportedException(lllllllllllllllIlIIIlIIllIllllII);
            }
            if (lllllllllllllllIlIIIlIIllIlllllI.isDead) {
                this.weatherEffects.remove(lllllllllllllllIlIIIlIIllIllllll--);
            }
        }
        this.theProfiler.endStartSection("remove");
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (int lllllllllllllllIlIIIlIIllIlllIlI = 0; lllllllllllllllIlIIIlIIllIlllIlI < this.unloadedEntityList.size(); ++lllllllllllllllIlIIIlIIllIlllIlI) {
            final Entity lllllllllllllllIlIIIlIIllIlllIIl = this.unloadedEntityList.get(lllllllllllllllIlIIIlIIllIlllIlI);
            final int lllllllllllllllIlIIIlIIllIlllIII = lllllllllllllllIlIIIlIIllIlllIIl.chunkCoordX;
            final int lllllllllllllllIlIIIlIIllIllIlll = lllllllllllllllIlIIIlIIllIlllIIl.chunkCoordZ;
            if (lllllllllllllllIlIIIlIIllIlllIIl.addedToChunk && this.isChunkLoaded(lllllllllllllllIlIIIlIIllIlllIII, lllllllllllllllIlIIIlIIllIllIlll, true)) {
                this.getChunkFromChunkCoords(lllllllllllllllIlIIIlIIllIlllIII, lllllllllllllllIlIIIlIIllIllIlll).removeEntity(lllllllllllllllIlIIIlIIllIlllIIl);
            }
        }
        for (int lllllllllllllllIlIIIlIIllIllIllI = 0; lllllllllllllllIlIIIlIIllIllIllI < this.unloadedEntityList.size(); ++lllllllllllllllIlIIIlIIllIllIllI) {
            this.onEntityRemoved(this.unloadedEntityList.get(lllllllllllllllIlIIIlIIllIllIllI));
        }
        this.unloadedEntityList.clear();
        this.tickPlayers();
        this.theProfiler.endStartSection("regular");
        for (int lllllllllllllllIlIIIlIIllIllIlIl = 0; lllllllllllllllIlIIIlIIllIllIlIl < this.loadedEntityList.size(); ++lllllllllllllllIlIIIlIIllIllIlIl) {
            final Entity lllllllllllllllIlIIIlIIllIllIlII = this.loadedEntityList.get(lllllllllllllllIlIIIlIIllIllIlIl);
            final Entity lllllllllllllllIlIIIlIIllIllIIll = lllllllllllllllIlIIIlIIllIllIlII.getRidingEntity();
            if (lllllllllllllllIlIIIlIIllIllIIll != null) {
                if (!lllllllllllllllIlIIIlIIllIllIIll.isDead && lllllllllllllllIlIIIlIIllIllIIll.isPassenger(lllllllllllllllIlIIIlIIllIllIlII)) {
                    continue;
                }
                lllllllllllllllIlIIIlIIllIllIlII.dismountRidingEntity();
            }
            this.theProfiler.startSection("tick");
            if (!lllllllllllllllIlIIIlIIllIllIlII.isDead && !(lllllllllllllllIlIIIlIIllIllIlII instanceof EntityPlayerMP)) {
                try {
                    this.updateEntity(lllllllllllllllIlIIIlIIllIllIlII);
                }
                catch (Throwable lllllllllllllllIlIIIlIIllIllIIlI) {
                    final CrashReport lllllllllllllllIlIIIlIIllIllIIIl = CrashReport.makeCrashReport(lllllllllllllllIlIIIlIIllIllIIlI, "Ticking entity");
                    final CrashReportCategory lllllllllllllllIlIIIlIIllIllIIII = lllllllllllllllIlIIIlIIllIllIIIl.makeCategory("Entity being ticked");
                    lllllllllllllllIlIIIlIIllIllIlII.addEntityCrashInfo(lllllllllllllllIlIIIlIIllIllIIII);
                    throw new ReportedException(lllllllllllllllIlIIIlIIllIllIIIl);
                }
            }
            this.theProfiler.endSection();
            this.theProfiler.startSection("remove");
            if (lllllllllllllllIlIIIlIIllIllIlII.isDead) {
                final int lllllllllllllllIlIIIlIIllIlIllll = lllllllllllllllIlIIIlIIllIllIlII.chunkCoordX;
                final int lllllllllllllllIlIIIlIIllIlIlllI = lllllllllllllllIlIIIlIIllIllIlII.chunkCoordZ;
                if (lllllllllllllllIlIIIlIIllIllIlII.addedToChunk && this.isChunkLoaded(lllllllllllllllIlIIIlIIllIlIllll, lllllllllllllllIlIIIlIIllIlIlllI, true)) {
                    this.getChunkFromChunkCoords(lllllllllllllllIlIIIlIIllIlIllll, lllllllllllllllIlIIIlIIllIlIlllI).removeEntity(lllllllllllllllIlIIIlIIllIllIlII);
                }
                this.loadedEntityList.remove(lllllllllllllllIlIIIlIIllIllIlIl--);
                this.onEntityRemoved(lllllllllllllllIlIIIlIIllIllIlII);
            }
            this.theProfiler.endSection();
        }
        this.theProfiler.endStartSection("blockEntities");
        if (!this.tileEntitiesToBeRemoved.isEmpty()) {
            this.tickableTileEntities.removeAll(this.tileEntitiesToBeRemoved);
            this.loadedTileEntityList.removeAll(this.tileEntitiesToBeRemoved);
            this.tileEntitiesToBeRemoved.clear();
        }
        this.processingLoadedTiles = true;
        final Iterator<TileEntity> lllllllllllllllIlIIIlIIllIlIllIl = this.tickableTileEntities.iterator();
        while (lllllllllllllllIlIIIlIIllIlIllIl.hasNext()) {
            final TileEntity lllllllllllllllIlIIIlIIllIlIllII = lllllllllllllllIlIIIlIIllIlIllIl.next();
            if (!lllllllllllllllIlIIIlIIllIlIllII.isInvalid() && lllllllllllllllIlIIIlIIllIlIllII.hasWorldObj()) {
                final BlockPos lllllllllllllllIlIIIlIIllIlIlIll = lllllllllllllllIlIIIlIIllIlIllII.getPos();
                if (this.isBlockLoaded(lllllllllllllllIlIIIlIIllIlIlIll) && this.worldBorder.contains(lllllllllllllllIlIIIlIIllIlIlIll)) {
                    try {
                        this.theProfiler.func_194340_a(() -> String.valueOf(TileEntity.func_190559_a(lllllllllllllllIlIIIlIIllIlIllII.getClass())));
                        ((ITickable)lllllllllllllllIlIIIlIIllIlIllII).update();
                        this.theProfiler.endSection();
                    }
                    catch (Throwable lllllllllllllllIlIIIlIIllIlIlIlI) {
                        final CrashReport lllllllllllllllIlIIIlIIllIlIlIIl = CrashReport.makeCrashReport(lllllllllllllllIlIIIlIIllIlIlIlI, "Ticking block entity");
                        final CrashReportCategory lllllllllllllllIlIIIlIIllIlIlIII = lllllllllllllllIlIIIlIIllIlIlIIl.makeCategory("Block entity being ticked");
                        lllllllllllllllIlIIIlIIllIlIllII.addInfoToCrashReport(lllllllllllllllIlIIIlIIllIlIlIII);
                        throw new ReportedException(lllllllllllllllIlIIIlIIllIlIlIIl);
                    }
                }
            }
            if (lllllllllllllllIlIIIlIIllIlIllII.isInvalid()) {
                lllllllllllllllIlIIIlIIllIlIllIl.remove();
                this.loadedTileEntityList.remove(lllllllllllllllIlIIIlIIllIlIllII);
                if (!this.isBlockLoaded(lllllllllllllllIlIIIlIIllIlIllII.getPos())) {
                    continue;
                }
                this.getChunkFromBlockCoords(lllllllllllllllIlIIIlIIllIlIllII.getPos()).removeTileEntity(lllllllllllllllIlIIIlIIllIlIllII.getPos());
            }
        }
        this.processingLoadedTiles = false;
        this.theProfiler.endStartSection("pendingBlockEntities");
        if (!this.addedTileEntityList.isEmpty()) {
            for (int lllllllllllllllIlIIIlIIllIlIIlll = 0; lllllllllllllllIlIIIlIIllIlIIlll < this.addedTileEntityList.size(); ++lllllllllllllllIlIIIlIIllIlIIlll) {
                final TileEntity lllllllllllllllIlIIIlIIllIlIIllI = this.addedTileEntityList.get(lllllllllllllllIlIIIlIIllIlIIlll);
                if (!lllllllllllllllIlIIIlIIllIlIIllI.isInvalid()) {
                    if (!this.loadedTileEntityList.contains(lllllllllllllllIlIIIlIIllIlIIllI)) {
                        this.addTileEntity(lllllllllllllllIlIIIlIIllIlIIllI);
                    }
                    if (this.isBlockLoaded(lllllllllllllllIlIIIlIIllIlIIllI.getPos())) {
                        final Chunk lllllllllllllllIlIIIlIIllIlIIlIl = this.getChunkFromBlockCoords(lllllllllllllllIlIIIlIIllIlIIllI.getPos());
                        final IBlockState lllllllllllllllIlIIIlIIllIlIIlII = lllllllllllllllIlIIIlIIllIlIIlIl.getBlockState(lllllllllllllllIlIIIlIIllIlIIllI.getPos());
                        lllllllllllllllIlIIIlIIllIlIIlIl.addTileEntity(lllllllllllllllIlIIIlIIllIlIIllI.getPos(), lllllllllllllllIlIIIlIIllIlIIllI);
                        this.notifyBlockUpdate(lllllllllllllllIlIIIlIIllIlIIllI.getPos(), lllllllllllllllIlIIIlIIllIlIIlII, lllllllllllllllIlIIIlIIllIlIIlII, 3);
                    }
                }
            }
            this.addedTileEntityList.clear();
        }
        this.theProfiler.endSection();
        this.theProfiler.endSection();
    }
    
    public int getLight(BlockPos lllllllllllllllIlIIIllIlIIIlIlII, final boolean lllllllllllllllIlIIIllIlIIIlllII) {
        if (((Vec3i)lllllllllllllllIlIIIllIlIIIlIlII).getX() < -30000000 || ((Vec3i)lllllllllllllllIlIIIllIlIIIlIlII).getZ() < -30000000 || ((Vec3i)lllllllllllllllIlIIIllIlIIIlIlII).getX() >= 30000000 || ((Vec3i)lllllllllllllllIlIIIllIlIIIlIlII).getZ() >= 30000000) {
            return 15;
        }
        if (lllllllllllllllIlIIIllIlIIIlllII && this.getBlockState((BlockPos)lllllllllllllllIlIIIllIlIIIlIlII).useNeighborBrightness()) {
            int lllllllllllllllIlIIIllIlIIIllIll = this.getLight(((BlockPos)lllllllllllllllIlIIIllIlIIIlIlII).up(), false);
            final int lllllllllllllllIlIIIllIlIIIllIlI = this.getLight(((BlockPos)lllllllllllllllIlIIIllIlIIIlIlII).east(), false);
            final int lllllllllllllllIlIIIllIlIIIllIIl = this.getLight(((BlockPos)lllllllllllllllIlIIIllIlIIIlIlII).west(), false);
            final int lllllllllllllllIlIIIllIlIIIllIII = this.getLight(((BlockPos)lllllllllllllllIlIIIllIlIIIlIlII).south(), false);
            final int lllllllllllllllIlIIIllIlIIIlIlll = this.getLight(((BlockPos)lllllllllllllllIlIIIllIlIIIlIlII).north(), false);
            if (lllllllllllllllIlIIIllIlIIIllIlI > lllllllllllllllIlIIIllIlIIIllIll) {
                lllllllllllllllIlIIIllIlIIIllIll = lllllllllllllllIlIIIllIlIIIllIlI;
            }
            if (lllllllllllllllIlIIIllIlIIIllIIl > lllllllllllllllIlIIIllIlIIIllIll) {
                lllllllllllllllIlIIIllIlIIIllIll = lllllllllllllllIlIIIllIlIIIllIIl;
            }
            if (lllllllllllllllIlIIIllIlIIIllIII > lllllllllllllllIlIIIllIlIIIllIll) {
                lllllllllllllllIlIIIllIlIIIllIll = lllllllllllllllIlIIIllIlIIIllIII;
            }
            if (lllllllllllllllIlIIIllIlIIIlIlll > lllllllllllllllIlIIIllIlIIIllIll) {
                lllllllllllllllIlIIIllIlIIIllIll = lllllllllllllllIlIIIllIlIIIlIlll;
            }
            return lllllllllllllllIlIIIllIlIIIllIll;
        }
        if (((Vec3i)lllllllllllllllIlIIIllIlIIIlIlII).getY() < 0) {
            return 0;
        }
        if (((Vec3i)lllllllllllllllIlIIIllIlIIIlIlII).getY() >= 256) {
            lllllllllllllllIlIIIllIlIIIlIlII = new BlockPos(((Vec3i)lllllllllllllllIlIIIllIlIIIlIlII).getX(), 255, ((Vec3i)lllllllllllllllIlIIIllIlIIIlIlII).getZ());
        }
        final Chunk lllllllllllllllIlIIIllIlIIIlIllI = this.getChunkFromBlockCoords((BlockPos)lllllllllllllllIlIIIllIlIIIlIlII);
        return lllllllllllllllIlIIIllIlIIIlIllI.getLightSubtracted((BlockPos)lllllllllllllllIlIIIllIlIIIlIlII, this.skylightSubtracted);
    }
    
    public IChunkProvider getChunkProvider() {
        return this.chunkProvider;
    }
    
    public int getRedstonePower(final BlockPos lllllllllllllllIlIIIIlIllIlIIIII, final EnumFacing lllllllllllllllIlIIIIlIllIIlllll) {
        final IBlockState lllllllllllllllIlIIIIlIllIlIIIlI = this.getBlockState(lllllllllllllllIlIIIIlIllIlIIIII);
        return lllllllllllllllIlIIIIlIllIlIIIlI.isNormalCube() ? this.getStrongPower(lllllllllllllllIlIIIIlIllIlIIIII) : lllllllllllllllIlIIIIlIllIlIIIlI.getWeakPower(this, lllllllllllllllIlIIIIlIllIlIIIII, lllllllllllllllIlIIIIlIllIIlllll);
    }
    
    public void func_190524_a(final BlockPos lllllllllllllllIlIIIllIlIlllIIIl, final Block lllllllllllllllIlIIIllIlIllIlIII, final BlockPos lllllllllllllllIlIIIllIlIllIllll) {
        if (!this.isRemote) {
            final IBlockState lllllllllllllllIlIIIllIlIllIlllI = this.getBlockState(lllllllllllllllIlIIIllIlIlllIIIl);
            try {
                lllllllllllllllIlIIIllIlIllIlllI.neighborChanged(this, lllllllllllllllIlIIIllIlIlllIIIl, lllllllllllllllIlIIIllIlIllIlIII, lllllllllllllllIlIIIllIlIllIllll);
            }
            catch (Throwable lllllllllllllllIlIIIllIlIllIllIl) {
                final CrashReport lllllllllllllllIlIIIllIlIllIllII = CrashReport.makeCrashReport(lllllllllllllllIlIIIllIlIllIllIl, "Exception while updating neighbours");
                final CrashReportCategory lllllllllllllllIlIIIllIlIllIlIll = lllllllllllllllIlIIIllIlIllIllII.makeCategory("Block being updated");
                lllllllllllllllIlIIIllIlIllIlIll.setDetail("Source block type", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        try {
                            return String.format("ID #%d (%s // %s)", Block.getIdFromBlock(lllllllllllllllIlIIIllIlIllIlIII), lllllllllllllllIlIIIllIlIllIlIII.getUnlocalizedName(), lllllllllllllllIlIIIllIlIllIlIII.getClass().getCanonicalName());
                        }
                        catch (Throwable llllllllllllllIlIlllIlIIllIIIIII) {
                            return String.valueOf(new StringBuilder("ID #").append(Block.getIdFromBlock(lllllllllllllllIlIIIllIlIllIlIII)));
                        }
                    }
                });
                CrashReportCategory.addBlockInfo(lllllllllllllllIlIIIllIlIllIlIll, lllllllllllllllIlIIIllIlIlllIIIl, lllllllllllllllIlIIIllIlIllIlllI);
                throw new ReportedException(lllllllllllllllIlIIIllIlIllIllII);
            }
        }
    }
    
    public float getSunBrightness(final float lllllllllllllllIlIIIlIlIlIIIIIII) {
        final float lllllllllllllllIlIIIlIlIIlllllll = this.getCelestialAngle(lllllllllllllllIlIIIlIlIlIIIIIII);
        float lllllllllllllllIlIIIlIlIIllllllI = 1.0f - (MathHelper.cos(lllllllllllllllIlIIIlIlIIlllllll * 6.2831855f) * 2.0f + 0.2f);
        lllllllllllllllIlIIIlIlIIllllllI = MathHelper.clamp(lllllllllllllllIlIIIlIlIIllllllI, 0.0f, 1.0f);
        lllllllllllllllIlIIIlIlIIllllllI = 1.0f - lllllllllllllllIlIIIlIlIIllllllI;
        lllllllllllllllIlIIIlIlIIllllllI *= (float)(1.0 - this.getRainStrength(lllllllllllllllIlIIIlIlIlIIIIIII) * 5.0f / 16.0);
        lllllllllllllllIlIIIlIlIIllllllI *= (float)(1.0 - this.getThunderStrength(lllllllllllllllIlIIIlIlIlIIIIIII) * 5.0f / 16.0);
        return lllllllllllllllIlIIIlIlIIllllllI * 0.8f + 0.2f;
    }
    
    public void removeEntityDangerously(final Entity lllllllllllllllIlIIIlIllIIIlllll) {
        lllllllllllllllIlIIIlIllIIIlllll.setDropItemsWhenDead(false);
        lllllllllllllllIlIIIlIllIIIlllll.setDead();
        if (lllllllllllllllIlIIIlIllIIIlllll instanceof EntityPlayer) {
            this.playerEntities.remove(lllllllllllllllIlIIIlIllIIIlllll);
            this.updateAllPlayersSleepingFlag();
        }
        final int lllllllllllllllIlIIIlIllIIIllllI = lllllllllllllllIlIIIlIllIIIlllll.chunkCoordX;
        final int lllllllllllllllIlIIIlIllIIIlllIl = lllllllllllllllIlIIIlIllIIIlllll.chunkCoordZ;
        if (lllllllllllllllIlIIIlIllIIIlllll.addedToChunk && this.isChunkLoaded(lllllllllllllllIlIIIlIllIIIllllI, lllllllllllllllIlIIIlIllIIIlllIl, true)) {
            this.getChunkFromChunkCoords(lllllllllllllllIlIIIlIllIIIllllI, lllllllllllllllIlIIIlIllIIIlllIl).removeEntity(lllllllllllllllIlIIIlIllIIIlllll);
        }
        this.loadedEntityList.remove(lllllllllllllllIlIIIlIllIIIlllll);
        this.onEntityRemoved(lllllllllllllllIlIIIlIllIIIlllll);
    }
    
    public float getLightBrightness(final BlockPos lllllllllllllllIlIIIllIIlIIllllI) {
        return this.provider.getLightBrightnessTable()[this.getLightFromNeighbors(lllllllllllllllIlIIIllIIlIIllllI)];
    }
    
    public void setRainStrength(final float lllllllllllllllIlIIIIlIIIlIlIllI) {
        this.prevRainingStrength = lllllllllllllllIlIIIIlIIIlIlIllI;
        this.rainingStrength = lllllllllllllllIlIIIIlIIIlIlIllI;
    }
    
    public boolean isBlockinHighHumidity(final BlockPos lllllllllllllllIlIIIIlIIIlIIIIII) {
        final Biome lllllllllllllllIlIIIIlIIIIllllll = this.getBiome(lllllllllllllllIlIIIIlIIIlIIIIII);
        return lllllllllllllllIlIIIIlIIIIllllll.isHighHumidity();
    }
    
    @Override
    public boolean isAirBlock(final BlockPos lllllllllllllllIlIIIlllIllIIllIl) {
        return this.getBlockState(lllllllllllllllIlIIIlllIllIIllIl).getMaterial() == Material.AIR;
    }
    
    public boolean canBlockFreezeWater(final BlockPos lllllllllllllllIlIIIIlllIlllllII) {
        return this.canBlockFreeze(lllllllllllllllIlIIIIlllIlllllII, false);
    }
    
    public BlockPos getHeight(final BlockPos lllllllllllllllIlIIIllIlIIIIlIlI) {
        return new BlockPos(lllllllllllllllIlIIIllIlIIIIlIlI.getX(), this.getHeight(lllllllllllllllIlIIIllIlIIIIlIlI.getX(), lllllllllllllllIlIIIllIlIIIIlIlI.getZ()), lllllllllllllllIlIIIllIlIIIIlIlI.getZ());
    }
    
    public void setInitialSpawnLocation() {
        this.setSpawnPoint(new BlockPos(8, 64, 8));
    }
    
    public boolean isUpdateScheduled(final BlockPos lllllllllllllllIlIIIlIIlllIlIlll, final Block lllllllllllllllIlIIIlIIlllIlIllI) {
        return true;
    }
    
    public float getRainStrength(final float lllllllllllllllIlIIIIlIIIlIlllII) {
        return this.prevRainingStrength + (this.rainingStrength - this.prevRainingStrength) * lllllllllllllllIlIIIIlIIIlIlllII;
    }
    
    public Calendar getCurrentDate() {
        if (this.getTotalWorldTime() % 600L == 0L) {
            this.theCalendar.setTimeInMillis(MinecraftServer.getCurrentTimeMillis());
        }
        return this.theCalendar;
    }
    
    public List<AxisAlignedBB> getCollisionBoxes(@Nullable final Entity lllllllllllllllIlIIIlIlIlIlllIII, final AxisAlignedBB lllllllllllllllIlIIIlIlIlIlIllll) {
        final List<AxisAlignedBB> lllllllllllllllIlIIIlIlIlIllIllI = (List<AxisAlignedBB>)Lists.newArrayList();
        this.func_191504_a(lllllllllllllllIlIIIlIlIlIlllIII, lllllllllllllllIlIIIlIlIlIlIllll, false, lllllllllllllllIlIIIlIlIlIllIllI);
        if (lllllllllllllllIlIIIlIlIlIlllIII != null) {
            final List<Entity> lllllllllllllllIlIIIlIlIlIllIlIl = this.getEntitiesWithinAABBExcludingEntity(lllllllllllllllIlIIIlIlIlIlllIII, lllllllllllllllIlIIIlIlIlIlIllll.expandXyz(0.25));
            for (int lllllllllllllllIlIIIlIlIlIllIlII = 0; lllllllllllllllIlIIIlIlIlIllIlII < lllllllllllllllIlIIIlIlIlIllIlIl.size(); ++lllllllllllllllIlIIIlIlIlIllIlII) {
                final Entity lllllllllllllllIlIIIlIlIlIllIIll = lllllllllllllllIlIIIlIlIlIllIlIl.get(lllllllllllllllIlIIIlIlIlIllIlII);
                if (!lllllllllllllllIlIIIlIlIlIlllIII.isRidingSameEntity(lllllllllllllllIlIIIlIlIlIllIIll)) {
                    AxisAlignedBB lllllllllllllllIlIIIlIlIlIllIIlI = lllllllllllllllIlIIIlIlIlIllIIll.getCollisionBoundingBox();
                    if (lllllllllllllllIlIIIlIlIlIllIIlI != null && lllllllllllllllIlIIIlIlIlIllIIlI.intersectsWith(lllllllllllllllIlIIIlIlIlIlIllll)) {
                        lllllllllllllllIlIIIlIlIlIllIllI.add(lllllllllllllllIlIIIlIlIlIllIIlI);
                    }
                    lllllllllllllllIlIIIlIlIlIllIIlI = lllllllllllllllIlIIIlIlIlIlllIII.getCollisionBox(lllllllllllllllIlIIIlIlIlIllIIll);
                    if (lllllllllllllllIlIIIlIlIlIllIIlI != null && lllllllllllllllIlIIIlIlIlIllIIlI.intersectsWith(lllllllllllllllIlIIIlIlIlIlIllll)) {
                        lllllllllllllllIlIIIlIlIlIllIllI.add(lllllllllllllllIlIIIlIlIlIllIIlI);
                    }
                }
            }
        }
        return lllllllllllllllIlIIIlIlIlIllIllI;
    }
    
    public void playSound(final double lllllllllllllllIlIIIlIlllllIIIII, final double lllllllllllllllIlIIIlIllllIlllll, final double lllllllllllllllIlIIIlIllllIllllI, final SoundEvent lllllllllllllllIlIIIlIllllIlllIl, final SoundCategory lllllllllllllllIlIIIlIllllIlllII, final float lllllllllllllllIlIIIlIllllIllIll, final float lllllllllllllllIlIIIlIllllIllIlI, final boolean lllllllllllllllIlIIIlIllllIllIIl) {
    }
    
    public void immediateBlockTick(final BlockPos lllllllllllllllIlIIIIllllIIIIIlI, final IBlockState lllllllllllllllIlIIIIllllIIIIIIl, final Random lllllllllllllllIlIIIIllllIIIIlII) {
        this.scheduledUpdatesAreImmediate = true;
        lllllllllllllllIlIIIIllllIIIIIIl.getBlock().updateTick(this, lllllllllllllllIlIIIIllllIIIIIlI, lllllllllllllllIlIIIIllllIIIIIIl, lllllllllllllllIlIIIIllllIIIIlII);
        this.scheduledUpdatesAreImmediate = false;
    }
    
    private boolean isWater(final BlockPos lllllllllllllllIlIIIIlllIlIlIllI) {
        return this.getBlockState(lllllllllllllllIlIIIIlllIlIlIllI).getMaterial() == Material.WATER;
    }
    
    public boolean addWeatherEffect(final Entity lllllllllllllllIlIIIlIllIlIlIIIl) {
        this.weatherEffects.add(lllllllllllllllIlIIIlIllIlIlIIIl);
        return true;
    }
    
    public void markBlockRangeForRenderUpdate(final int lllllllllllllllIlIIIllIllIlIlIlI, final int lllllllllllllllIlIIIllIllIlIIIIl, final int lllllllllllllllIlIIIllIllIlIlIII, final int lllllllllllllllIlIIIllIllIIlllll, final int lllllllllllllllIlIIIllIllIlIIllI, final int lllllllllllllllIlIIIllIllIlIIlIl) {
        for (int lllllllllllllllIlIIIllIllIlIIlII = 0; lllllllllllllllIlIIIllIllIlIIlII < this.eventListeners.size(); ++lllllllllllllllIlIIIllIllIlIIlII) {
            this.eventListeners.get(lllllllllllllllIlIIIllIllIlIIlII).markBlockRangeForRenderUpdate(lllllllllllllllIlIIIllIllIlIlIlI, lllllllllllllllIlIIIllIllIlIIIIl, lllllllllllllllIlIIIllIllIlIlIII, lllllllllllllllIlIIIllIllIIlllll, lllllllllllllllIlIIIllIllIlIIllI, lllllllllllllllIlIIIllIllIlIIlIl);
        }
    }
    
    public void loadEntities(final Collection<Entity> lllllllllllllllIlIIIIlIlllllIIIl) {
        this.loadedEntityList.addAll(lllllllllllllllIlIIIIlIlllllIIIl);
        for (final Entity lllllllllllllllIlIIIIlIlllllIIll : lllllllllllllllIlIIIIlIlllllIIIl) {
            this.onEntityAdded(lllllllllllllllIlIIIIlIlllllIIll);
        }
    }
    
    @Nullable
    public <T extends Entity> T findNearestEntityWithinAABB(final Class<? extends T> lllllllllllllllIlIIIIllIIIlIlIlI, final AxisAlignedBB lllllllllllllllIlIIIIllIIIIlllll, final T lllllllllllllllIlIIIIllIIIlIlIII) {
        final List<T> lllllllllllllllIlIIIIllIIIlIIlll = this.getEntitiesWithinAABB(lllllllllllllllIlIIIIllIIIlIlIlI, lllllllllllllllIlIIIIllIIIIlllll);
        T lllllllllllllllIlIIIIllIIIlIIllI = null;
        double lllllllllllllllIlIIIIllIIIlIIlIl = Double.MAX_VALUE;
        for (int lllllllllllllllIlIIIIllIIIlIIlII = 0; lllllllllllllllIlIIIIllIIIlIIlII < lllllllllllllllIlIIIIllIIIlIIlll.size(); ++lllllllllllllllIlIIIIllIIIlIIlII) {
            final T lllllllllllllllIlIIIIllIIIlIIIll = lllllllllllllllIlIIIIllIIIlIIlll.get(lllllllllllllllIlIIIIllIIIlIIlII);
            if (lllllllllllllllIlIIIIllIIIlIIIll != lllllllllllllllIlIIIIllIIIlIlIII && EntitySelectors.NOT_SPECTATING.apply((Object)lllllllllllllllIlIIIIllIIIlIIIll)) {
                final double lllllllllllllllIlIIIIllIIIlIIIlI = lllllllllllllllIlIIIIllIIIlIlIII.getDistanceSqToEntity(lllllllllllllllIlIIIIllIIIlIIIll);
                if (lllllllllllllllIlIIIIllIIIlIIIlI <= lllllllllllllllIlIIIIllIIIlIIlIl) {
                    lllllllllllllllIlIIIIllIIIlIIllI = lllllllllllllllIlIIIIllIIIlIIIll;
                    lllllllllllllllIlIIIIllIIIlIIlIl = lllllllllllllllIlIIIIllIIIlIIIlI;
                }
            }
        }
        return lllllllllllllllIlIIIIllIIIlIIllI;
    }
    
    private void spawnParticle(final int lllllllllllllllIlIIIlIllIlIlllIl, final boolean lllllllllllllllIlIIIlIllIllIlIII, final double lllllllllllllllIlIIIlIllIllIIlll, final double lllllllllllllllIlIIIlIllIllIIllI, final double lllllllllllllllIlIIIlIllIlIllIIl, final double lllllllllllllllIlIIIlIllIllIIlII, final double lllllllllllllllIlIIIlIllIlIlIlll, final double lllllllllllllllIlIIIlIllIlIlIllI, final int... lllllllllllllllIlIIIlIllIllIIIIl) {
        for (int lllllllllllllllIlIIIlIllIllIIIII = 0; lllllllllllllllIlIIIlIllIllIIIII < this.eventListeners.size(); ++lllllllllllllllIlIIIlIllIllIIIII) {
            this.eventListeners.get(lllllllllllllllIlIIIlIllIllIIIII).spawnParticle(lllllllllllllllIlIIIlIllIlIlllIl, lllllllllllllllIlIIIlIllIllIlIII, lllllllllllllllIlIIIlIllIllIIlll, lllllllllllllllIlIIIlIllIllIIllI, lllllllllllllllIlIIIlIllIlIllIIl, lllllllllllllllIlIIIlIllIllIIlII, lllllllllllllllIlIIIlIllIlIlIlll, lllllllllllllllIlIIIlIllIlIlIllI, lllllllllllllllIlIIIlIllIllIIIIl);
        }
    }
    
    public void updateAllPlayersSleepingFlag() {
    }
    
    public void removeEventListener(final IWorldEventListener lllllllllllllllIlIIIlIllIIIIllIl) {
        this.eventListeners.remove(lllllllllllllllIlIIIlIllIIIIllIl);
    }
    
    public boolean isBlockFullCube(final BlockPos lllllllllllllllIlIIIIlllllIIIlll) {
        final AxisAlignedBB lllllllllllllllIlIIIIlllllIIlIIl = this.getBlockState(lllllllllllllllIlIIIIlllllIIIlll).getCollisionBoundingBox(this, lllllllllllllllIlIIIIlllllIIIlll);
        return lllllllllllllllIlIIIIlllllIIlIIl != Block.NULL_AABB && lllllllllllllllIlIIIIlllllIIlIIl.getAverageEdgeLength() >= 1.0;
    }
    
    public void setSpawnPoint(final BlockPos lllllllllllllllIlIIIIlIIlIlIIIIl) {
        this.worldInfo.setSpawn(lllllllllllllllIlIIIIlIIlIlIIIIl);
    }
    
    public void markTileEntityForRemoval(final TileEntity lllllllllllllllIlIIIIlllllIlIIIl) {
        this.tileEntitiesToBeRemoved.add(lllllllllllllllIlIIIIlllllIlIIIl);
    }
    
    public <T extends Entity> List<T> getEntities(final Class<? extends T> lllllllllllllllIlIIIIllIIllllIlI, final Predicate<? super T> lllllllllllllllIlIIIIllIIllllIIl) {
        final List<T> lllllllllllllllIlIIIIllIIllllIII = (List<T>)Lists.newArrayList();
        for (final Entity lllllllllllllllIlIIIIllIIlllIlll : this.loadedEntityList) {
            if (lllllllllllllllIlIIIIllIIllllIlI.isAssignableFrom(lllllllllllllllIlIIIIllIIlllIlll.getClass()) && lllllllllllllllIlIIIIllIIllllIIl.apply((Object)lllllllllllllllIlIIIIllIIlllIlll)) {
                lllllllllllllllIlIIIIllIIllllIII.add((T)lllllllllllllllIlIIIIllIIlllIlll);
            }
        }
        return lllllllllllllllIlIIIIllIIllllIII;
    }
    
    public boolean canSeeSky(final BlockPos lllllllllllllllIlIIIllIlIlIIIlII) {
        return this.getChunkFromBlockCoords(lllllllllllllllIlIIIllIlIlIIIlII).canSeeSky(lllllllllllllllIlIIIllIlIlIIIlII);
    }
    
    public boolean canBlockFreezeNoWater(final BlockPos lllllllllllllllIlIIIIlllIlllIllI) {
        return this.canBlockFreeze(lllllllllllllllIlIIIIlllIlllIllI, true);
    }
    
    public int getSkylightSubtracted() {
        return this.skylightSubtracted;
    }
    
    public VillageCollection getVillageCollection() {
        return this.villageCollectionObj;
    }
    
    public int getLight(BlockPos lllllllllllllllIlIIIllIlIIlIllIl) {
        if (lllllllllllllllIlIIIllIlIIlIllIl.getY() < 0) {
            return 0;
        }
        if (lllllllllllllllIlIIIllIlIIlIllIl.getY() >= 256) {
            lllllllllllllllIlIIIllIlIIlIllIl = new BlockPos(lllllllllllllllIlIIIllIlIIlIllIl.getX(), 255, lllllllllllllllIlIIIllIlIIlIllIl.getZ());
        }
        return this.getChunkFromBlockCoords(lllllllllllllllIlIIIllIlIIlIllIl).getLightSubtracted(lllllllllllllllIlIIIllIlIIlIllIl, 0);
    }
    
    public boolean isSpawnChunk(final int lllllllllllllllIlIIIIIllIllIIIII, final int lllllllllllllllIlIIIIIllIlIlllll) {
        final BlockPos lllllllllllllllIlIIIIIllIllIIlIl = this.getSpawnPoint();
        final int lllllllllllllllIlIIIIIllIllIIlII = lllllllllllllllIlIIIIIllIllIIIII * 16 + 8 - lllllllllllllllIlIIIIIllIllIIlIl.getX();
        final int lllllllllllllllIlIIIIIllIllIIIll = lllllllllllllllIlIIIIIllIlIlllll * 16 + 8 - lllllllllllllllIlIIIIIllIllIIlIl.getZ();
        final int lllllllllllllllIlIIIIIllIllIIIlI = 128;
        return lllllllllllllllIlIIIIIllIllIIlII >= -128 && lllllllllllllllIlIIIIIllIllIIlII <= 128 && lllllllllllllllIlIIIIIllIllIIIll >= -128 && lllllllllllllllIlIIIIIllIllIIIll <= 128;
    }
    
    public void setEntityState(final Entity lllllllllllllllIlIIIIlIIlIIIIlll, final byte lllllllllllllllIlIIIIlIIlIIIIllI) {
    }
    
    @Nullable
    public EntityPlayer getNearestAttackablePlayer(final BlockPos lllllllllllllllIlIIIIlIlIIIlIIIl, final double lllllllllllllllIlIIIIlIlIIIlIIII, final double lllllllllllllllIlIIIIlIlIIIIllll) {
        return this.getNearestAttackablePlayer(lllllllllllllllIlIIIIlIlIIIlIIIl.getX() + 0.5f, lllllllllllllllIlIIIIlIlIIIlIIIl.getY() + 0.5f, lllllllllllllllIlIIIIlIlIIIlIIIl.getZ() + 0.5f, lllllllllllllllIlIIIIlIlIIIlIIII, lllllllllllllllIlIIIIlIlIIIIllll, null, null);
    }
    
    @Nullable
    private TileEntity getPendingTileEntityAt(final BlockPos lllllllllllllllIlIIIIllllllIllll) {
        for (int lllllllllllllllIlIIIIlllllllIIlI = 0; lllllllllllllllIlIIIIlllllllIIlI < this.addedTileEntityList.size(); ++lllllllllllllllIlIIIIlllllllIIlI) {
            final TileEntity lllllllllllllllIlIIIIlllllllIIIl = this.addedTileEntityList.get(lllllllllllllllIlIIIIlllllllIIlI);
            if (!lllllllllllllllIlIIIIlllllllIIIl.isInvalid() && lllllllllllllllIlIIIIlllllllIIIl.getPos().equals(lllllllllllllllIlIIIIllllllIllll)) {
                return lllllllllllllllIlIIIIlllllllIIIl;
            }
        }
        return null;
    }
    
    public void updateBlockTick(final BlockPos lllllllllllllllIlIIIlIIlllIlIIII, final Block lllllllllllllllIlIIIlIIlllIIllll, final int lllllllllllllllIlIIIlIIlllIIlllI, final int lllllllllllllllIlIIIlIIlllIIllIl) {
    }
    
    public void addBlockEvent(final BlockPos lllllllllllllllIlIIIIlIIIllllIII, final Block lllllllllllllllIlIIIIlIIIlllllII, final int lllllllllllllllIlIIIIlIIIllllIll, final int lllllllllllllllIlIIIIlIIIlllIllI) {
        this.getBlockState(lllllllllllllllIlIIIIlIIIllllIII).onBlockEventReceived(this, lllllllllllllllIlIIIIlIIIllllIII, lllllllllllllllIlIIIIlIIIllllIll, lllllllllllllllIlIIIIlIIIlllIllI);
    }
    
    @Nullable
    public Entity getEntityByID(final int lllllllllllllllIlIIIIllIIIIlIlII) {
        return this.entitiesById.lookup(lllllllllllllllIlIIIIllIIIIlIlII);
    }
    
    public void func_190523_a(final int lllllllllllllllIlIIIlIlllIlIIllI, final double lllllllllllllllIlIIIlIlllIIllIll, final double lllllllllllllllIlIIIlIlllIlIIlII, final double lllllllllllllllIlIIIlIlllIIllIIl, final double lllllllllllllllIlIIIlIlllIIllIII, final double lllllllllllllllIlIIIlIlllIIlIlll, final double lllllllllllllllIlIIIlIlllIlIIIII, final int... lllllllllllllllIlIIIlIlllIIlllll) {
        for (int lllllllllllllllIlIIIlIlllIIllllI = 0; lllllllllllllllIlIIIlIlllIIllllI < this.eventListeners.size(); ++lllllllllllllllIlIIIlIlllIIllllI) {
            this.eventListeners.get(lllllllllllllllIlIIIlIlllIIllllI).func_190570_a(lllllllllllllllIlIIIlIlllIlIIllI, false, true, lllllllllllllllIlIIIlIlllIIllIll, lllllllllllllllIlIIIlIlllIlIIlII, lllllllllllllllIlIIIlIlllIIllIIl, lllllllllllllllIlIIIlIlllIIllIII, lllllllllllllllIlIIIlIlllIIlIlll, lllllllllllllllIlIIIlIlllIlIIIII, lllllllllllllllIlIIIlIlllIIlllll);
        }
    }
    
    public boolean collidesWithAnyBlock(final AxisAlignedBB lllllllllllllllIlIIIlIlIlIIlIlII) {
        return this.func_191504_a(null, lllllllllllllllIlIIIlIlIlIIlIlII, true, Lists.newArrayList());
    }
    
    public int getSeaLevel() {
        return this.seaLevel;
    }
    
    @Nullable
    public EntityPlayer getClosestPlayer(final double lllllllllllllllIlIIIIlIlIllIIIIl, final double lllllllllllllllIlIIIIlIlIllIIlll, final double lllllllllllllllIlIIIIlIlIllIIllI, final double lllllllllllllllIlIIIIlIlIllIIlIl, final boolean lllllllllllllllIlIIIIlIlIlIlllIl) {
        final Predicate<Entity> lllllllllllllllIlIIIIlIlIllIIIll = lllllllllllllllIlIIIIlIlIlIlllIl ? EntitySelectors.CAN_AI_TARGET : EntitySelectors.NOT_SPECTATING;
        return this.func_190525_a(lllllllllllllllIlIIIIlIlIllIIIIl, lllllllllllllllIlIIIIlIlIllIIlll, lllllllllllllllIlIIIIlIlIllIIllI, lllllllllllllllIlIIIIlIlIllIIlIl, lllllllllllllllIlIIIIlIlIllIIIll);
    }
    
    public void removeEntity(final Entity lllllllllllllllIlIIIlIllIIlIIlIl) {
        if (lllllllllllllllIlIIIlIllIIlIIlIl.isBeingRidden()) {
            lllllllllllllllIlIIIlIllIIlIIlIl.removePassengers();
        }
        if (lllllllllllllllIlIIIlIllIIlIIlIl.isRiding()) {
            lllllllllllllllIlIIIlIllIIlIIlIl.dismountRidingEntity();
        }
        lllllllllllllllIlIIIlIllIIlIIlIl.setDead();
        if (lllllllllllllllIlIIIlIllIIlIIlIl instanceof EntityPlayer) {
            this.playerEntities.remove(lllllllllllllllIlIIIlIllIIlIIlIl);
            this.updateAllPlayersSleepingFlag();
            this.onEntityRemoved(lllllllllllllllIlIIIlIllIIlIIlIl);
        }
    }
    
    protected void tickPlayers() {
    }
    
    @Nullable
    public RayTraceResult rayTraceBlocks(final Vec3d lllllllllllllllIlIIIllIIlIIIlIll, final Vec3d lllllllllllllllIlIIIllIIlIIIlIlI) {
        return this.rayTraceBlocks(lllllllllllllllIlIIIllIIlIIIlIll, lllllllllllllllIlIIIllIIlIIIlIlI, false, false, false);
    }
    
    public void setLightFor(final EnumSkyBlock lllllllllllllllIlIIIllIIlIllllIl, final BlockPos lllllllllllllllIlIIIllIIlIllllII, final int lllllllllllllllIlIIIllIIllIIIIII) {
        if (this.isValid(lllllllllllllllIlIIIllIIlIllllII) && this.isBlockLoaded(lllllllllllllllIlIIIllIIlIllllII)) {
            final Chunk lllllllllllllllIlIIIllIIlIllllll = this.getChunkFromBlockCoords(lllllllllllllllIlIIIllIIlIllllII);
            lllllllllllllllIlIIIllIIlIllllll.setLightFor(lllllllllllllllIlIIIllIIlIllllIl, lllllllllllllllIlIIIllIIlIllllII, lllllllllllllllIlIIIllIIllIIIIII);
            this.notifyLightSet(lllllllllllllllIlIIIllIIlIllllII);
        }
    }
    
    public void setThunderStrength(final float lllllllllllllllIlIIIIlIIIllIIIlI) {
        this.prevThunderingStrength = lllllllllllllllIlIIIIlIIIllIIIlI;
        this.thunderingStrength = lllllllllllllllIlIIIIlIIIllIIIlI;
    }
    
    public List<Entity> getLoadedEntityList() {
        return this.loadedEntityList;
    }
    
    public int getStrongPower(final BlockPos lllllllllllllllIlIIIIlIllIllIlII) {
        int lllllllllllllllIlIIIIlIllIllIllI = 0;
        lllllllllllllllIlIIIIlIllIllIllI = Math.max(lllllllllllllllIlIIIIlIllIllIllI, this.getStrongPower(lllllllllllllllIlIIIIlIllIllIlII.down(), EnumFacing.DOWN));
        if (lllllllllllllllIlIIIIlIllIllIllI >= 15) {
            return lllllllllllllllIlIIIIlIllIllIllI;
        }
        lllllllllllllllIlIIIIlIllIllIllI = Math.max(lllllllllllllllIlIIIIlIllIllIllI, this.getStrongPower(lllllllllllllllIlIIIIlIllIllIlII.up(), EnumFacing.UP));
        if (lllllllllllllllIlIIIIlIllIllIllI >= 15) {
            return lllllllllllllllIlIIIIlIllIllIllI;
        }
        lllllllllllllllIlIIIIlIllIllIllI = Math.max(lllllllllllllllIlIIIIlIllIllIllI, this.getStrongPower(lllllllllllllllIlIIIIlIllIllIlII.north(), EnumFacing.NORTH));
        if (lllllllllllllllIlIIIIlIllIllIllI >= 15) {
            return lllllllllllllllIlIIIIlIllIllIllI;
        }
        lllllllllllllllIlIIIIlIllIllIllI = Math.max(lllllllllllllllIlIIIIlIllIllIllI, this.getStrongPower(lllllllllllllllIlIIIIlIllIllIlII.south(), EnumFacing.SOUTH));
        if (lllllllllllllllIlIIIIlIllIllIllI >= 15) {
            return lllllllllllllllIlIIIIlIllIllIllI;
        }
        lllllllllllllllIlIIIIlIllIllIllI = Math.max(lllllllllllllllIlIIIIlIllIllIllI, this.getStrongPower(lllllllllllllllIlIIIIlIllIllIlII.west(), EnumFacing.WEST));
        if (lllllllllllllllIlIIIIlIllIllIllI >= 15) {
            return lllllllllllllllIlIIIIlIllIllIllI;
        }
        lllllllllllllllIlIIIIlIllIllIllI = Math.max(lllllllllllllllIlIIIIlIllIllIllI, this.getStrongPower(lllllllllllllllIlIIIIlIllIllIlII.east(), EnumFacing.EAST));
        return (lllllllllllllllIlIIIIlIllIllIllI >= 15) ? lllllllllllllllIlIIIIlIllIllIllI : lllllllllllllllIlIIIIlIllIllIllI;
    }
    
    public CrashReportCategory addWorldInfoToCrashReport(final CrashReport lllllllllllllllIlIIIIIllllIIllIl) {
        final CrashReportCategory lllllllllllllllIlIIIIIllllIlIIII = lllllllllllllllIlIIIIIllllIIllIl.makeCategoryDepth("Affected level", 1);
        lllllllllllllllIlIIIIIllllIlIIII.addCrashSection("Level name", (this.worldInfo == null) ? "????" : this.worldInfo.getWorldName());
        lllllllllllllllIlIIIIIllllIlIIII.setDetail("All players", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(World.this.playerEntities.size())).append(" total; ").append(World.this.playerEntities));
            }
        });
        lllllllllllllllIlIIIIIllllIlIIII.setDetail("Chunk stats", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return World.this.chunkProvider.makeString();
            }
        });
        try {
            this.worldInfo.addToCrashReport(lllllllllllllllIlIIIIIllllIlIIII);
        }
        catch (Throwable lllllllllllllllIlIIIIIllllIIllll) {
            lllllllllllllllIlIIIIIllllIlIIII.addCrashSectionThrowable("Level Data Unobtainable", lllllllllllllllIlIIIIIllllIIllll);
        }
        return lllllllllllllllIlIIIIIllllIlIIII;
    }
    
    public List<Entity> getEntitiesInAABBexcluding(@Nullable final Entity lllllllllllllllIlIIIIllIlIIlIllI, final AxisAlignedBB lllllllllllllllIlIIIIllIlIIIlIlI, @Nullable final Predicate<? super Entity> lllllllllllllllIlIIIIllIlIIlIlII) {
        final List<Entity> lllllllllllllllIlIIIIllIlIIlIIll = (List<Entity>)Lists.newArrayList();
        final int lllllllllllllllIlIIIIllIlIIlIIlI = MathHelper.floor((lllllllllllllllIlIIIIllIlIIIlIlI.minX - 2.0) / 16.0);
        final int lllllllllllllllIlIIIIllIlIIlIIIl = MathHelper.floor((lllllllllllllllIlIIIIllIlIIIlIlI.maxX + 2.0) / 16.0);
        final int lllllllllllllllIlIIIIllIlIIlIIII = MathHelper.floor((lllllllllllllllIlIIIIllIlIIIlIlI.minZ - 2.0) / 16.0);
        final int lllllllllllllllIlIIIIllIlIIIllll = MathHelper.floor((lllllllllllllllIlIIIIllIlIIIlIlI.maxZ + 2.0) / 16.0);
        for (int lllllllllllllllIlIIIIllIlIIIlllI = lllllllllllllllIlIIIIllIlIIlIIlI; lllllllllllllllIlIIIIllIlIIIlllI <= lllllllllllllllIlIIIIllIlIIlIIIl; ++lllllllllllllllIlIIIIllIlIIIlllI) {
            for (int lllllllllllllllIlIIIIllIlIIIllIl = lllllllllllllllIlIIIIllIlIIlIIII; lllllllllllllllIlIIIIllIlIIIllIl <= lllllllllllllllIlIIIIllIlIIIllll; ++lllllllllllllllIlIIIIllIlIIIllIl) {
                if (this.isChunkLoaded(lllllllllllllllIlIIIIllIlIIIlllI, lllllllllllllllIlIIIIllIlIIIllIl, true)) {
                    this.getChunkFromChunkCoords(lllllllllllllllIlIIIIllIlIIIlllI, lllllllllllllllIlIIIIllIlIIIllIl).getEntitiesWithinAABBForEntity(lllllllllllllllIlIIIIllIlIIlIllI, lllllllllllllllIlIIIIllIlIIIlIlI, lllllllllllllllIlIIIIllIlIIlIIll, lllllllllllllllIlIIIIllIlIIlIlII);
                }
            }
        }
        return lllllllllllllllIlIIIIllIlIIlIIll;
    }
    
    @Nullable
    public EntityPlayer func_190525_a(final double lllllllllllllllIlIIIIlIlIlIIIlII, final double lllllllllllllllIlIIIIlIlIlIIlllI, final double lllllllllllllllIlIIIIlIlIlIIIIlI, final double lllllllllllllllIlIIIIlIlIlIIllII, final Predicate<Entity> lllllllllllllllIlIIIIlIlIlIIlIll) {
        double lllllllllllllllIlIIIIlIlIlIIlIlI = -1.0;
        EntityPlayer lllllllllllllllIlIIIIlIlIlIIlIIl = null;
        for (int lllllllllllllllIlIIIIlIlIlIIlIII = 0; lllllllllllllllIlIIIIlIlIlIIlIII < this.playerEntities.size(); ++lllllllllllllllIlIIIIlIlIlIIlIII) {
            final EntityPlayer lllllllllllllllIlIIIIlIlIlIIIlll = this.playerEntities.get(lllllllllllllllIlIIIIlIlIlIIlIII);
            if (lllllllllllllllIlIIIIlIlIlIIlIll.apply((Object)lllllllllllllllIlIIIIlIlIlIIIlll)) {
                final double lllllllllllllllIlIIIIlIlIlIIIllI = lllllllllllllllIlIIIIlIlIlIIIlll.getDistanceSq(lllllllllllllllIlIIIIlIlIlIIIlII, lllllllllllllllIlIIIIlIlIlIIlllI, lllllllllllllllIlIIIIlIlIlIIIIlI);
                if ((lllllllllllllllIlIIIIlIlIlIIllII < 0.0 || lllllllllllllllIlIIIIlIlIlIIIllI < lllllllllllllllIlIIIIlIlIlIIllII * lllllllllllllllIlIIIIlIlIlIIllII) && (lllllllllllllllIlIIIIlIlIlIIlIlI == -1.0 || lllllllllllllllIlIIIIlIlIlIIIllI < lllllllllllllllIlIIIIlIlIlIIlIlI)) {
                    lllllllllllllllIlIIIIlIlIlIIlIlI = lllllllllllllllIlIIIIlIlIlIIIllI;
                    lllllllllllllllIlIIIIlIlIlIIlIIl = lllllllllllllllIlIIIIlIlIlIIIlll;
                }
            }
        }
        return lllllllllllllllIlIIIIlIlIlIIlIIl;
    }
    
    public boolean isAnyPlayerWithinRangeAt(final double lllllllllllllllIlIIIIlIlIIlIlIIl, final double lllllllllllllllIlIIIIlIlIIlIlIII, final double lllllllllllllllIlIIIIlIlIIlIllll, final double lllllllllllllllIlIIIIlIlIIlIIllI) {
        for (int lllllllllllllllIlIIIIlIlIIlIllIl = 0; lllllllllllllllIlIIIIlIlIIlIllIl < this.playerEntities.size(); ++lllllllllllllllIlIIIIlIlIIlIllIl) {
            final EntityPlayer lllllllllllllllIlIIIIlIlIIlIllII = this.playerEntities.get(lllllllllllllllIlIIIIlIlIIlIllIl);
            if (EntitySelectors.NOT_SPECTATING.apply((Object)lllllllllllllllIlIIIIlIlIIlIllII)) {
                final double lllllllllllllllIlIIIIlIlIIlIlIll = lllllllllllllllIlIIIIlIlIIlIllII.getDistanceSq(lllllllllllllllIlIIIIlIlIIlIlIIl, lllllllllllllllIlIIIIlIlIIlIlIII, lllllllllllllllIlIIIIlIlIIlIllll);
                if (lllllllllllllllIlIIIIlIlIIlIIllI < 0.0 || lllllllllllllllIlIIIIlIlIIlIlIll < lllllllllllllllIlIIIIlIlIIlIIllI * lllllllllllllllIlIIIIlIlIIlIIllI) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void sendBlockBreakProgress(final int lllllllllllllllIlIIIIIllllIIIIll, final BlockPos lllllllllllllllIlIIIIIllllIIIIlI, final int lllllllllllllllIlIIIIIllllIIIIIl) {
        for (int lllllllllllllllIlIIIIIllllIIIIII = 0; lllllllllllllllIlIIIIIllllIIIIII < this.eventListeners.size(); ++lllllllllllllllIlIIIIIllllIIIIII) {
            final IWorldEventListener lllllllllllllllIlIIIIIlllIllllll = this.eventListeners.get(lllllllllllllllIlIIIIIllllIIIIII);
            lllllllllllllllIlIIIIIlllIllllll.sendBlockBreakProgress(lllllllllllllllIlIIIIIllllIIIIll, lllllllllllllllIlIIIIIllllIIIIlI, lllllllllllllllIlIIIIIllllIIIIIl);
        }
    }
    
    @Nullable
    public MapStorage getMapStorage() {
        return this.mapStorage;
    }
    
    public boolean addTileEntity(final TileEntity lllllllllllllllIlIIIlIIllIIlIlIl) {
        final boolean lllllllllllllllIlIIIlIIllIIlIlII = this.loadedTileEntityList.add(lllllllllllllllIlIIIlIIllIIlIlIl);
        if (lllllllllllllllIlIIIlIIllIIlIlII && lllllllllllllllIlIIIlIIllIIlIlIl instanceof ITickable) {
            this.tickableTileEntities.add(lllllllllllllllIlIIIlIIllIIlIlIl);
        }
        if (this.isRemote) {
            final BlockPos lllllllllllllllIlIIIlIIllIIlIIll = lllllllllllllllIlIIIlIIllIIlIlIl.getPos();
            final IBlockState lllllllllllllllIlIIIlIIllIIlIIlI = this.getBlockState(lllllllllllllllIlIIIlIIllIIlIIll);
            this.notifyBlockUpdate(lllllllllllllllIlIIIlIIllIIlIIll, lllllllllllllllIlIIIlIIllIIlIIlI, lllllllllllllllIlIIIlIIllIIlIIlI, 2);
        }
        return lllllllllllllllIlIIIlIIllIIlIlII;
    }
    
    public int isBlockIndirectlyGettingPowered(final BlockPos lllllllllllllllIlIIIIlIllIIIlIIl) {
        int lllllllllllllllIlIIIIlIllIIIllIl = 0;
        final byte lllllllllllllllIlIIIIlIllIIIIlII;
        final boolean lllllllllllllllIlIIIIlIllIIIIlIl = ((EnumFacing[])(Object)(lllllllllllllllIlIIIIlIllIIIIlII = (byte)(Object)EnumFacing.values())).length != 0;
        for (short lllllllllllllllIlIIIIlIllIIIIllI = 0; lllllllllllllllIlIIIIlIllIIIIllI < (lllllllllllllllIlIIIIlIllIIIIlIl ? 1 : 0); ++lllllllllllllllIlIIIIlIllIIIIllI) {
            final EnumFacing lllllllllllllllIlIIIIlIllIIIllII = lllllllllllllllIlIIIIlIllIIIIlII[lllllllllllllllIlIIIIlIllIIIIllI];
            final int lllllllllllllllIlIIIIlIllIIIlIll = this.getRedstonePower(lllllllllllllllIlIIIIlIllIIIlIIl.offset(lllllllllllllllIlIIIIlIllIIIllII), lllllllllllllllIlIIIIlIllIIIllII);
            if (lllllllllllllllIlIIIIlIllIIIlIll >= 15) {
                return 15;
            }
            if (lllllllllllllllIlIIIIlIllIIIlIll > lllllllllllllllIlIIIIlIllIIIllIl) {
                lllllllllllllllIlIIIIlIllIIIllIl = lllllllllllllllIlIIIIlIllIIIlIll;
            }
        }
        return lllllllllllllllIlIIIIlIllIIIllIl;
    }
    
    public void notifyNeighborsRespectDebug(final BlockPos lllllllllllllllIlIIIllIlllIlIllI, final Block lllllllllllllllIlIIIllIlllIlIIIl, final boolean lllllllllllllllIlIIIllIlllIlIlII) {
        if (this.worldInfo.getTerrainType() != WorldType.DEBUG_WORLD) {
            this.notifyNeighborsOfStateChange(lllllllllllllllIlIIIllIlllIlIllI, lllllllllllllllIlIIIllIlllIlIIIl, lllllllllllllllIlIIIllIlllIlIlII);
        }
    }
    
    private boolean isValid(final BlockPos lllllllllllllllIlIIIlllIlllIIlII) {
        return !this.isOutsideBuildHeight(lllllllllllllllIlIIIlllIlllIIlII) && lllllllllllllllIlIIIlllIlllIIlII.getX() >= -30000000 && lllllllllllllllIlIIIlllIlllIIlII.getZ() >= -30000000 && lllllllllllllllIlIIIlllIlllIIlII.getX() < 30000000 && lllllllllllllllIlIIIlllIlllIIlII.getZ() < 30000000;
    }
    
    public long getTotalWorldTime() {
        return this.worldInfo.getWorldTotalTime();
    }
    
    public LootTableManager getLootTableManager() {
        return this.lootTable;
    }
}
