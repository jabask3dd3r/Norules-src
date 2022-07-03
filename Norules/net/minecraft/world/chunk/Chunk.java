package net.minecraft.world.chunk;

import net.minecraft.world.chunk.storage.*;
import net.minecraft.entity.*;
import java.util.concurrent.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import org.apache.logging.log4j.*;
import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import com.google.common.collect.*;
import net.minecraft.network.*;
import net.minecraft.world.biome.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;
import net.minecraft.world.gen.*;

public class Chunk
{
    private final /* synthetic */ World worldObj;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ int heightMapMinimum;
    private /* synthetic */ boolean chunkTicked;
    private /* synthetic */ int queuedLightChecks;
    private /* synthetic */ long lastSaveTime;
    private /* synthetic */ boolean isModified;
    private /* synthetic */ boolean isTerrainPopulated;
    private /* synthetic */ boolean isChunkLoaded;
    private /* synthetic */ boolean isGapLightingUpdated;
    private /* synthetic */ long inhabitedTime;
    private final /* synthetic */ byte[] blockBiomeArray;
    private /* synthetic */ boolean isLightPopulated;
    private final /* synthetic */ ExtendedBlockStorage[] storageArrays;
    private final /* synthetic */ ClassInheritanceMultiMap<Entity>[] entityLists;
    private final /* synthetic */ ConcurrentLinkedQueue<BlockPos> tileEntityPosQueue;
    private final /* synthetic */ int[] heightMap;
    public final /* synthetic */ int xPosition;
    public final /* synthetic */ int zPosition;
    private final /* synthetic */ Map<BlockPos, TileEntity> chunkTileEntityMap;
    private /* synthetic */ boolean hasEntities;
    public static final /* synthetic */ ExtendedBlockStorage NULL_BLOCK_STORAGE;
    private final /* synthetic */ int[] precipitationHeightMap;
    private final /* synthetic */ boolean[] updateSkylightColumns;
    
    private int getBlockLightOpacity(final int lllllllllllllIlIIlIlIIlIIIlIlIII, final int lllllllllllllIlIIlIlIIlIIIlIIIll, final int lllllllllllllIlIIlIlIIlIIIlIIIlI) {
        return this.getBlockState(lllllllllllllIlIIlIlIIlIIIlIlIII, lllllllllllllIlIIlIlIIlIIIlIIIll, lllllllllllllIlIIlIlIIlIIIlIIIlI).getLightOpacity();
    }
    
    @Nullable
    public TileEntity getTileEntity(final BlockPos lllllllllllllIlIIlIlIIIlIIIlIIII, final EnumCreateEntityType lllllllllllllIlIIlIlIIIlIIIIllll) {
        TileEntity lllllllllllllIlIIlIlIIIlIIIIlllI = this.chunkTileEntityMap.get(lllllllllllllIlIIlIlIIIlIIIlIIII);
        if (lllllllllllllIlIIlIlIIIlIIIIlllI == null) {
            if (lllllllllllllIlIIlIlIIIlIIIIllll == EnumCreateEntityType.IMMEDIATE) {
                lllllllllllllIlIIlIlIIIlIIIIlllI = this.createNewTileEntity(lllllllllllllIlIIlIlIIIlIIIlIIII);
                this.worldObj.setTileEntity(lllllllllllllIlIIlIlIIIlIIIlIIII, lllllllllllllIlIIlIlIIIlIIIIlllI);
            }
            else if (lllllllllllllIlIIlIlIIIlIIIIllll == EnumCreateEntityType.QUEUED) {
                this.tileEntityPosQueue.add(lllllllllllllIlIIlIlIIIlIIIlIIII);
            }
        }
        else if (lllllllllllllIlIIlIlIIIlIIIIlllI.isInvalid()) {
            this.chunkTileEntityMap.remove(lllllllllllllIlIIlIlIIIlIIIlIIII);
            return null;
        }
        return lllllllllllllIlIIlIlIIIlIIIIlllI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        NULL_BLOCK_STORAGE = null;
    }
    
    public void setBiomeArray(final byte[] lllllllllllllIlIIlIIlllllllIIlll) {
        if (this.blockBiomeArray.length != lllllllllllllIlIIlIIlllllllIIlll.length) {
            Chunk.LOGGER.warn("Could not set level chunk biomes, array length is {} instead of {}", (Object)lllllllllllllIlIIlIIlllllllIIlll.length, (Object)this.blockBiomeArray.length);
        }
        else {
            System.arraycopy(lllllllllllllIlIIlIIlllllllIIlll, 0, this.blockBiomeArray, 0, this.blockBiomeArray.length);
        }
    }
    
    public int getBlockLightOpacity(final BlockPos lllllllllllllIlIIlIlIIlIIIllIIII) {
        return this.getBlockState(lllllllllllllIlIIlIlIIlIIIllIIII).getLightOpacity();
    }
    
    public byte[] getBiomeArray() {
        return this.blockBiomeArray;
    }
    
    public void getEntitiesWithinAABBForEntity(@Nullable final Entity lllllllllllllIlIIlIlIIIIlIlllIlI, final AxisAlignedBB lllllllllllllIlIIlIlIIIIllIIIlII, final List<Entity> lllllllllllllIlIIlIlIIIIllIIIIll, final Predicate<? super Entity> lllllllllllllIlIIlIlIIIIlIllIlll) {
        int lllllllllllllIlIIlIlIIIIllIIIIIl = MathHelper.floor((lllllllllllllIlIIlIlIIIIllIIIlII.minY - 2.0) / 16.0);
        int lllllllllllllIlIIlIlIIIIllIIIIII = MathHelper.floor((lllllllllllllIlIIlIlIIIIllIIIlII.maxY + 2.0) / 16.0);
        lllllllllllllIlIIlIlIIIIllIIIIIl = MathHelper.clamp(lllllllllllllIlIIlIlIIIIllIIIIIl, 0, this.entityLists.length - 1);
        lllllllllllllIlIIlIlIIIIllIIIIII = MathHelper.clamp(lllllllllllllIlIIlIlIIIIllIIIIII, 0, this.entityLists.length - 1);
        for (int lllllllllllllIlIIlIlIIIIlIllllll = lllllllllllllIlIIlIlIIIIllIIIIIl; lllllllllllllIlIIlIlIIIIlIllllll <= lllllllllllllIlIIlIlIIIIllIIIIII; ++lllllllllllllIlIIlIlIIIIlIllllll) {
            if (!this.entityLists[lllllllllllllIlIIlIlIIIIlIllllll].isEmpty()) {
                for (final Entity lllllllllllllIlIIlIlIIIIlIlllllI : this.entityLists[lllllllllllllIlIIlIlIIIIlIllllll]) {
                    if (lllllllllllllIlIIlIlIIIIlIlllllI.getEntityBoundingBox().intersectsWith(lllllllllllllIlIIlIlIIIIllIIIlII) && lllllllllllllIlIIlIlIIIIlIlllllI != lllllllllllllIlIIlIlIIIIlIlllIlI) {
                        if (lllllllllllllIlIIlIlIIIIlIllIlll == null || lllllllllllllIlIIlIlIIIIlIllIlll.apply((Object)lllllllllllllIlIIlIlIIIIlIlllllI)) {
                            lllllllllllllIlIIlIlIIIIllIIIIll.add(lllllllllllllIlIIlIlIIIIlIlllllI);
                        }
                        final Entity[] lllllllllllllIlIIlIlIIIIlIllllIl = lllllllllllllIlIIlIlIIIIlIlllllI.getParts();
                        if (lllllllllllllIlIIlIlIIIIlIllllIl == null) {
                            continue;
                        }
                        final char lllllllllllllIlIIlIlIIIIlIlIllIl;
                        final long lllllllllllllIlIIlIlIIIIlIlIlllI = ((Entity[])(Object)(lllllllllllllIlIIlIlIIIIlIlIllIl = (char)(Object)lllllllllllllIlIIlIlIIIIlIllllIl)).length;
                        for (char lllllllllllllIlIIlIlIIIIlIlIllll = '\0'; lllllllllllllIlIIlIlIIIIlIlIllll < lllllllllllllIlIIlIlIIIIlIlIlllI; ++lllllllllllllIlIIlIlIIIIlIlIllll) {
                            final Entity lllllllllllllIlIIlIlIIIIlIllllII = lllllllllllllIlIIlIlIIIIlIlIllIl[lllllllllllllIlIIlIlIIIIlIlIllll];
                            if (lllllllllllllIlIIlIlIIIIlIllllII != lllllllllllllIlIIlIlIIIIlIlllIlI && lllllllllllllIlIIlIlIIIIlIllllII.getEntityBoundingBox().intersectsWith(lllllllllllllIlIIlIlIIIIllIIIlII) && (lllllllllllllIlIIlIlIIIIlIllIlll == null || lllllllllllllIlIIlIlIIIIlIllIlll.apply((Object)lllllllllllllIlIIlIlIIIIlIllllII))) {
                                lllllllllllllIlIIlIlIIIIllIIIIll.add(lllllllllllllIlIIlIlIIIIlIllllII);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void setTerrainPopulated(final boolean lllllllllllllIlIIlIIllllIlIlIlIl) {
        this.isTerrainPopulated = lllllllllllllIlIIlIIllllIlIlIlIl;
    }
    
    public IBlockState getBlockState(final BlockPos lllllllllllllIlIIlIlIIlIIIIllllI) {
        return this.getBlockState(lllllllllllllIlIIlIlIIlIIIIllllI.getX(), lllllllllllllIlIIlIlIIlIIIIllllI.getY(), lllllllllllllIlIIlIlIIlIIIIllllI.getZ());
    }
    
    public void setStorageArrays(final ExtendedBlockStorage[] lllllllllllllIlIIlIlIIIIIIIlllIl) {
        if (this.storageArrays.length != lllllllllllllIlIIlIlIIIIIIIlllIl.length) {
            Chunk.LOGGER.warn("Could not set level chunk sections, array length is {} instead of {}", (Object)lllllllllllllIlIIlIlIIIIIIIlllIl.length, (Object)this.storageArrays.length);
        }
        else {
            System.arraycopy(lllllllllllllIlIIlIlIIIIIIIlllIl, 0, this.storageArrays, 0, this.storageArrays.length);
        }
    }
    
    public boolean isEmpty() {
        return false;
    }
    
    public void setChunkModified() {
        this.isModified = true;
    }
    
    public void resetRelightChecks() {
        this.queuedLightChecks = 0;
    }
    
    public boolean isChunkTicked() {
        return this.chunkTicked;
    }
    
    public void addEntity(final Entity lllllllllllllIlIIlIlIIIlIlIIIIll) {
        this.hasEntities = true;
        final int lllllllllllllIlIIlIlIIIlIlIIIlll = MathHelper.floor(lllllllllllllIlIIlIlIIIlIlIIIIll.posX / 16.0);
        final int lllllllllllllIlIIlIlIIIlIlIIIllI = MathHelper.floor(lllllllllllllIlIIlIlIIIlIlIIIIll.posZ / 16.0);
        if (lllllllllllllIlIIlIlIIIlIlIIIlll != this.xPosition || lllllllllllllIlIIlIlIIIlIlIIIllI != this.zPosition) {
            Chunk.LOGGER.warn("Wrong location! ({}, {}) should be ({}, {}), {}", (Object)lllllllllllllIlIIlIlIIIlIlIIIlll, (Object)lllllllllllllIlIIlIlIIIlIlIIIllI, (Object)this.xPosition, (Object)this.zPosition, (Object)lllllllllllllIlIIlIlIIIlIlIIIIll);
            lllllllllllllIlIIlIlIIIlIlIIIIll.setDead();
        }
        int lllllllllllllIlIIlIlIIIlIlIIIlIl = MathHelper.floor(lllllllllllllIlIIlIlIIIlIlIIIIll.posY / 16.0);
        if (lllllllllllllIlIIlIlIIIlIlIIIlIl < 0) {
            lllllllllllllIlIIlIlIIIlIlIIIlIl = 0;
        }
        if (lllllllllllllIlIIlIlIIIlIlIIIlIl >= this.entityLists.length) {
            lllllllllllllIlIIlIlIIIlIlIIIlIl = this.entityLists.length - 1;
        }
        lllllllllllllIlIIlIlIIIlIlIIIIll.addedToChunk = true;
        lllllllllllllIlIIlIlIIIlIlIIIIll.chunkCoordX = this.xPosition;
        lllllllllllllIlIIlIlIIIlIlIIIIll.chunkCoordY = lllllllllllllIlIIlIlIIIlIlIIIlIl;
        lllllllllllllIlIIlIlIIIlIlIIIIll.chunkCoordZ = this.zPosition;
        this.entityLists[lllllllllllllIlIIlIlIIIlIlIIIlIl].add(lllllllllllllIlIIlIlIIIlIlIIIIll);
    }
    
    public <T extends Entity> void getEntitiesOfTypeWithinAAAB(final Class<? extends T> lllllllllllllIlIIlIlIIIIlIIllIII, final AxisAlignedBB lllllllllllllIlIIlIlIIIIlIlIIIII, final List<T> lllllllllllllIlIIlIlIIIIlIIlllll, final Predicate<? super T> lllllllllllllIlIIlIlIIIIlIIlIlIl) {
        int lllllllllllllIlIIlIlIIIIlIIlllIl = MathHelper.floor((lllllllllllllIlIIlIlIIIIlIlIIIII.minY - 2.0) / 16.0);
        int lllllllllllllIlIIlIlIIIIlIIlllII = MathHelper.floor((lllllllllllllIlIIlIlIIIIlIlIIIII.maxY + 2.0) / 16.0);
        lllllllllllllIlIIlIlIIIIlIIlllIl = MathHelper.clamp(lllllllllllllIlIIlIlIIIIlIIlllIl, 0, this.entityLists.length - 1);
        lllllllllllllIlIIlIlIIIIlIIlllII = MathHelper.clamp(lllllllllllllIlIIlIlIIIIlIIlllII, 0, this.entityLists.length - 1);
        for (int lllllllllllllIlIIlIlIIIIlIIllIll = lllllllllllllIlIIlIlIIIIlIIlllIl; lllllllllllllIlIIlIlIIIIlIIllIll <= lllllllllllllIlIIlIlIIIIlIIlllII; ++lllllllllllllIlIIlIlIIIIlIIllIll) {
            for (final T lllllllllllllIlIIlIlIIIIlIIllIlI : this.entityLists[lllllllllllllIlIIlIlIIIIlIIllIll].getByClass(lllllllllllllIlIIlIlIIIIlIIllIII)) {
                if (lllllllllllllIlIIlIlIIIIlIIllIlI.getEntityBoundingBox().intersectsWith(lllllllllllllIlIIlIlIIIIlIlIIIII) && (lllllllllllllIlIIlIlIIIIlIIlIlIl == null || lllllllllllllIlIIlIlIIIIlIIlIlIl.apply((Object)lllllllllllllIlIIlIlIIIIlIIllIlI))) {
                    lllllllllllllIlIIlIlIIIIlIIlllll.add(lllllllllllllIlIIlIlIIIIlIIllIlI);
                }
            }
        }
    }
    
    public Chunk(final World lllllllllllllIlIIlIlIIllIIIIIlIl, final ChunkPrimer lllllllllllllIlIIlIlIIllIIIIIlII, final int lllllllllllllIlIIlIlIIllIIIIIIll, final int lllllllllllllIlIIlIlIIllIIIIlllI) {
        this(lllllllllllllIlIIlIlIIllIIIIIlIl, lllllllllllllIlIIlIlIIllIIIIIIll, lllllllllllllIlIIlIlIIllIIIIlllI);
        final int lllllllllllllIlIIlIlIIllIIIIllIl = 256;
        final boolean lllllllllllllIlIIlIlIIllIIIIllII = lllllllllllllIlIIlIlIIllIIIIIlIl.provider.func_191066_m();
        for (int lllllllllllllIlIIlIlIIllIIIIlIll = 0; lllllllllllllIlIIlIlIIllIIIIlIll < 16; ++lllllllllllllIlIIlIlIIllIIIIlIll) {
            for (int lllllllllllllIlIIlIlIIllIIIIlIlI = 0; lllllllllllllIlIIlIlIIllIIIIlIlI < 16; ++lllllllllllllIlIIlIlIIllIIIIlIlI) {
                for (int lllllllllllllIlIIlIlIIllIIIIlIIl = 0; lllllllllllllIlIIlIlIIllIIIIlIIl < 256; ++lllllllllllllIlIIlIlIIllIIIIlIIl) {
                    final IBlockState lllllllllllllIlIIlIlIIllIIIIlIII = lllllllllllllIlIIlIlIIllIIIIIlII.getBlockState(lllllllllllllIlIIlIlIIllIIIIlIll, lllllllllllllIlIIlIlIIllIIIIlIIl, lllllllllllllIlIIlIlIIllIIIIlIlI);
                    if (lllllllllllllIlIIlIlIIllIIIIlIII.getMaterial() != Material.AIR) {
                        final int lllllllllllllIlIIlIlIIllIIIIIlll = lllllllllllllIlIIlIlIIllIIIIlIIl >> 4;
                        if (this.storageArrays[lllllllllllllIlIIlIlIIllIIIIIlll] == Chunk.NULL_BLOCK_STORAGE) {
                            this.storageArrays[lllllllllllllIlIIlIlIIllIIIIIlll] = new ExtendedBlockStorage(lllllllllllllIlIIlIlIIllIIIIIlll << 4, lllllllllllllIlIIlIlIIllIIIIllII);
                        }
                        this.storageArrays[lllllllllllllIlIIlIlIIllIIIIIlll].set(lllllllllllllIlIIlIlIIllIIIIlIll, lllllllllllllIlIIlIlIIllIIIIlIIl & 0xF, lllllllllllllIlIIlIlIIllIIIIlIlI, lllllllllllllIlIIlIlIIllIIIIlIII);
                    }
                }
            }
        }
    }
    
    public World getWorld() {
        return this.worldObj;
    }
    
    public Chunk(final World lllllllllllllIlIIlIlIIllIIlIIIlI, final int lllllllllllllIlIIlIlIIllIIlIIllI, final int lllllllllllllIlIIlIlIIllIIlIIIII) {
        this.storageArrays = new ExtendedBlockStorage[16];
        this.blockBiomeArray = new byte[256];
        this.precipitationHeightMap = new int[256];
        this.updateSkylightColumns = new boolean[256];
        this.chunkTileEntityMap = (Map<BlockPos, TileEntity>)Maps.newHashMap();
        this.queuedLightChecks = 4096;
        this.tileEntityPosQueue = (ConcurrentLinkedQueue<BlockPos>)Queues.newConcurrentLinkedQueue();
        this.entityLists = (ClassInheritanceMultiMap<Entity>[])new ClassInheritanceMultiMap[16];
        this.worldObj = lllllllllllllIlIIlIlIIllIIlIIIlI;
        this.xPosition = lllllllllllllIlIIlIlIIllIIlIIllI;
        this.zPosition = lllllllllllllIlIIlIlIIllIIlIIIII;
        this.heightMap = new int[256];
        for (int lllllllllllllIlIIlIlIIllIIlIIlII = 0; lllllllllllllIlIIlIlIIllIIlIIlII < this.entityLists.length; ++lllllllllllllIlIIlIlIIllIIlIIlII) {
            this.entityLists[lllllllllllllIlIIlIlIIllIIlIIlII] = new ClassInheritanceMultiMap<Entity>(Entity.class);
        }
        Arrays.fill(this.precipitationHeightMap, -999);
        Arrays.fill(this.blockBiomeArray, (byte)(-1));
    }
    
    public boolean canSeeSky(final BlockPos lllllllllllllIlIIlIlIIIlIIlIIlIl) {
        final int lllllllllllllIlIIlIlIIIlIIlIlIIl = lllllllllllllIlIIlIlIIIlIIlIIlIl.getX() & 0xF;
        final int lllllllllllllIlIIlIlIIIlIIlIlIII = lllllllllllllIlIIlIlIIIlIIlIIlIl.getY();
        final int lllllllllllllIlIIlIlIIIlIIlIIlll = lllllllllllllIlIIlIlIIIlIIlIIlIl.getZ() & 0xF;
        return lllllllllllllIlIIlIlIIIlIIlIlIII >= this.heightMap[lllllllllllllIlIIlIlIIIlIIlIIlll << 4 | lllllllllllllIlIIlIlIIIlIIlIlIIl];
    }
    
    public int getLightSubtracted(final BlockPos lllllllllllllIlIIlIlIIIlIllIIIll, final int lllllllllllllIlIIlIlIIIlIlIlIlIl) {
        final int lllllllllllllIlIIlIlIIIlIllIIIIl = lllllllllllllIlIIlIlIIIlIllIIIll.getX() & 0xF;
        final int lllllllllllllIlIIlIlIIIlIllIIIII = lllllllllllllIlIIlIlIIIlIllIIIll.getY();
        final int lllllllllllllIlIIlIlIIIlIlIllllI = lllllllllllllIlIIlIlIIIlIllIIIll.getZ() & 0xF;
        final ExtendedBlockStorage lllllllllllllIlIIlIlIIIlIlIlllII = this.storageArrays[lllllllllllllIlIIlIlIIIlIllIIIII >> 4];
        if (lllllllllllllIlIIlIlIIIlIlIlllII == Chunk.NULL_BLOCK_STORAGE) {
            return (this.worldObj.provider.func_191066_m() && lllllllllllllIlIIlIlIIIlIlIlIlIl < EnumSkyBlock.SKY.defaultLightValue) ? (EnumSkyBlock.SKY.defaultLightValue - lllllllllllllIlIIlIlIIIlIlIlIlIl) : 0;
        }
        int lllllllllllllIlIIlIlIIIlIlIllIlI = this.worldObj.provider.func_191066_m() ? lllllllllllllIlIIlIlIIIlIlIlllII.getExtSkylightValue(lllllllllllllIlIIlIlIIIlIllIIIIl, lllllllllllllIlIIlIlIIIlIllIIIII & 0xF, lllllllllllllIlIIlIlIIIlIlIllllI) : 0;
        lllllllllllllIlIIlIlIIIlIlIllIlI -= lllllllllllllIlIIlIlIIIlIlIlIlIl;
        final int lllllllllllllIlIIlIlIIIlIlIllIII = lllllllllllllIlIIlIlIIIlIlIlllII.getExtBlocklightValue(lllllllllllllIlIIlIlIIIlIllIIIIl, lllllllllllllIlIIlIlIIIlIllIIIII & 0xF, lllllllllllllIlIIlIlIIIlIlIllllI);
        if (lllllllllllllIlIIlIlIIIlIlIllIII > lllllllllllllIlIIlIlIIIlIlIllIlI) {
            lllllllllllllIlIIlIlIIIlIlIllIlI = lllllllllllllIlIIlIlIIIlIlIllIII;
        }
        return lllllllllllllIlIIlIlIIIlIlIllIlI;
    }
    
    public BlockPos getPrecipitationHeight(final BlockPos lllllllllllllIlIIlIlIIIIIlIllIIl) {
        final int lllllllllllllIlIIlIlIIIIIlIllIII = lllllllllllllIlIIlIlIIIIIlIllIIl.getX() & 0xF;
        final int lllllllllllllIlIIlIlIIIIIlIlIlll = lllllllllllllIlIIlIlIIIIIlIllIIl.getZ() & 0xF;
        final int lllllllllllllIlIIlIlIIIIIlIlIllI = lllllllllllllIlIIlIlIIIIIlIllIII | lllllllllllllIlIIlIlIIIIIlIlIlll << 4;
        BlockPos lllllllllllllIlIIlIlIIIIIlIlIlIl = new BlockPos(lllllllllllllIlIIlIlIIIIIlIllIIl.getX(), this.precipitationHeightMap[lllllllllllllIlIIlIlIIIIIlIlIllI], lllllllllllllIlIIlIlIIIIIlIllIIl.getZ());
        if (lllllllllllllIlIIlIlIIIIIlIlIlIl.getY() == -999) {
            final int lllllllllllllIlIIlIlIIIIIlIlIlII = this.getTopFilledSegment() + 15;
            lllllllllllllIlIIlIlIIIIIlIlIlIl = new BlockPos(lllllllllllllIlIIlIlIIIIIlIllIIl.getX(), lllllllllllllIlIIlIlIIIIIlIlIlII, lllllllllllllIlIIlIlIIIIIlIllIIl.getZ());
            int lllllllllllllIlIIlIlIIIIIlIlIIll = -1;
            while (lllllllllllllIlIIlIlIIIIIlIlIlIl.getY() > 0 && lllllllllllllIlIIlIlIIIIIlIlIIll == -1) {
                final IBlockState lllllllllllllIlIIlIlIIIIIlIlIIlI = this.getBlockState(lllllllllllllIlIIlIlIIIIIlIlIlIl);
                final Material lllllllllllllIlIIlIlIIIIIlIlIIIl = lllllllllllllIlIIlIlIIIIIlIlIIlI.getMaterial();
                if (!lllllllllllllIlIIlIlIIIIIlIlIIIl.blocksMovement() && !lllllllllllllIlIIlIlIIIIIlIlIIIl.isLiquid()) {
                    lllllllllllllIlIIlIlIIIIIlIlIlIl = lllllllllllllIlIIlIlIIIIIlIlIlIl.down();
                }
                else {
                    lllllllllllllIlIIlIlIIIIIlIlIIll = lllllllllllllIlIIlIlIIIIIlIlIlIl.getY() + 1;
                }
            }
            this.precipitationHeightMap[lllllllllllllIlIIlIlIIIIIlIlIllI] = lllllllllllllIlIIlIlIIIIIlIlIIll;
        }
        return new BlockPos(lllllllllllllIlIIlIlIIIIIlIllIIl.getX(), this.precipitationHeightMap[lllllllllllllIlIIlIlIIIIIlIlIllI], lllllllllllllIlIIlIlIIIIIlIllIIl.getZ());
    }
    
    public void setLastSaveTime(final long lllllllllllllIlIIlIIllllIIlllIII) {
        this.lastSaveTime = lllllllllllllIlIIlIIllllIIlllIII;
    }
    
    private boolean checkLight(final int lllllllllllllIlIIlIIlllllIIIlIII, final int lllllllllllllIlIIlIIlllllIIIIlll) {
        final int lllllllllllllIlIIlIIlllllIIIIllI = this.getTopFilledSegment();
        boolean lllllllllllllIlIIlIIlllllIIIIlIl = false;
        boolean lllllllllllllIlIIlIIlllllIIIIlII = false;
        final BlockPos.MutableBlockPos lllllllllllllIlIIlIIlllllIIIIIll = new BlockPos.MutableBlockPos((this.xPosition << 4) + lllllllllllllIlIIlIIlllllIIIlIII, 0, (this.zPosition << 4) + lllllllllllllIlIIlIIlllllIIIIlll);
        for (int lllllllllllllIlIIlIIlllllIIIIIlI = lllllllllllllIlIIlIIlllllIIIIllI + 16 - 1; lllllllllllllIlIIlIIlllllIIIIIlI > this.worldObj.getSeaLevel() || (lllllllllllllIlIIlIIlllllIIIIIlI > 0 && !lllllllllllllIlIIlIIlllllIIIIlII); --lllllllllllllIlIIlIIlllllIIIIIlI) {
            lllllllllllllIlIIlIIlllllIIIIIll.setPos(lllllllllllllIlIIlIIlllllIIIIIll.getX(), lllllllllllllIlIIlIIlllllIIIIIlI, lllllllllllllIlIIlIIlllllIIIIIll.getZ());
            final int lllllllllllllIlIIlIIlllllIIIIIIl = this.getBlockLightOpacity(lllllllllllllIlIIlIIlllllIIIIIll);
            if (lllllllllllllIlIIlIIlllllIIIIIIl == 255 && lllllllllllllIlIIlIIlllllIIIIIll.getY() < this.worldObj.getSeaLevel()) {
                lllllllllllllIlIIlIIlllllIIIIlII = true;
            }
            if (!lllllllllllllIlIIlIIlllllIIIIlIl && lllllllllllllIlIIlIIlllllIIIIIIl > 0) {
                lllllllllllllIlIIlIIlllllIIIIlIl = true;
            }
            else if (lllllllllllllIlIIlIIlllllIIIIlIl && lllllllllllllIlIIlIIlllllIIIIIIl == 0 && !this.worldObj.checkLight(lllllllllllllIlIIlIIlllllIIIIIll)) {
                return false;
            }
        }
        for (int lllllllllllllIlIIlIIlllllIIIIIII = lllllllllllllIlIIlIIlllllIIIIIll.getY(); lllllllllllllIlIIlIIlllllIIIIIII > 0; --lllllllllllllIlIIlIIlllllIIIIIII) {
            lllllllllllllIlIIlIIlllllIIIIIll.setPos(lllllllllllllIlIIlIIlllllIIIIIll.getX(), lllllllllllllIlIIlIIlllllIIIIIII, lllllllllllllIlIIlIIlllllIIIIIll.getZ());
            if (this.getBlockState(lllllllllllllIlIIlIIlllllIIIIIll).getLightValue() > 0) {
                this.worldObj.checkLight(lllllllllllllIlIIlIIlllllIIIIIll);
            }
        }
        return true;
    }
    
    protected void generateHeightMap() {
        final int lllllllllllllIlIIlIlIIlIllIIllII = this.getTopFilledSegment();
        this.heightMapMinimum = Integer.MAX_VALUE;
        for (int lllllllllllllIlIIlIlIIlIllIIlIll = 0; lllllllllllllIlIIlIlIIlIllIIlIll < 16; ++lllllllllllllIlIIlIlIIlIllIIlIll) {
            for (int lllllllllllllIlIIlIlIIlIllIIlIlI = 0; lllllllllllllIlIIlIlIIlIllIIlIlI < 16; ++lllllllllllllIlIIlIlIIlIllIIlIlI) {
                this.precipitationHeightMap[lllllllllllllIlIIlIlIIlIllIIlIll + (lllllllllllllIlIIlIlIIlIllIIlIlI << 4)] = -999;
                int lllllllllllllIlIIlIlIIlIllIIlIIl = lllllllllllllIlIIlIlIIlIllIIllII + 16;
                while (lllllllllllllIlIIlIlIIlIllIIlIIl > 0) {
                    final IBlockState lllllllllllllIlIIlIlIIlIllIIlIII = this.getBlockState(lllllllllllllIlIIlIlIIlIllIIlIll, lllllllllllllIlIIlIlIIlIllIIlIIl - 1, lllllllllllllIlIIlIlIIlIllIIlIlI);
                    if (lllllllllllllIlIIlIlIIlIllIIlIII.getLightOpacity() != 0) {
                        if ((this.heightMap[lllllllllllllIlIIlIlIIlIllIIlIlI << 4 | lllllllllllllIlIIlIlIIlIllIIlIll] = lllllllllllllIlIIlIlIIlIllIIlIIl) < this.heightMapMinimum) {
                            this.heightMapMinimum = lllllllllllllIlIIlIlIIlIllIIlIIl;
                            break;
                        }
                        break;
                    }
                    else {
                        --lllllllllllllIlIIlIlIIlIllIIlIIl;
                    }
                }
            }
        }
        this.isModified = true;
    }
    
    public boolean isLoaded() {
        return this.isChunkLoaded;
    }
    
    private void relightBlock(final int lllllllllllllIlIIlIlIIlIIlIlIIlI, final int lllllllllllllIlIIlIlIIlIIIlllllI, final int lllllllllllllIlIIlIlIIlIIlIlIIII) {
        int lllllllllllllIlIIlIlIIlIIlIIlllI;
        final int lllllllllllllIlIIlIlIIlIIlIIllll = lllllllllllllIlIIlIlIIlIIlIIlllI = (this.heightMap[lllllllllllllIlIIlIlIIlIIlIlIIII << 4 | lllllllllllllIlIIlIlIIlIIlIlIIlI] & 0xFF);
        if (lllllllllllllIlIIlIlIIlIIIlllllI > lllllllllllllIlIIlIlIIlIIlIIllll) {
            lllllllllllllIlIIlIlIIlIIlIIlllI = lllllllllllllIlIIlIlIIlIIIlllllI;
        }
        while (lllllllllllllIlIIlIlIIlIIlIIlllI > 0 && this.getBlockLightOpacity(lllllllllllllIlIIlIlIIlIIlIlIIlI, lllllllllllllIlIIlIlIIlIIlIIlllI - 1, lllllllllllllIlIIlIlIIlIIlIlIIII) == 0) {
            --lllllllllllllIlIIlIlIIlIIlIIlllI;
        }
        if (lllllllllllllIlIIlIlIIlIIlIIlllI != lllllllllllllIlIIlIlIIlIIlIIllll) {
            this.worldObj.markBlocksDirtyVertical(lllllllllllllIlIIlIlIIlIIlIlIIlI + this.xPosition * 16, lllllllllllllIlIIlIlIIlIIlIlIIII + this.zPosition * 16, lllllllllllllIlIIlIlIIlIIlIIlllI, lllllllllllllIlIIlIlIIlIIlIIllll);
            this.heightMap[lllllllllllllIlIIlIlIIlIIlIlIIII << 4 | lllllllllllllIlIIlIlIIlIIlIlIIlI] = lllllllllllllIlIIlIlIIlIIlIIlllI;
            final int lllllllllllllIlIIlIlIIlIIlIIllIl = this.xPosition * 16 + lllllllllllllIlIIlIlIIlIIlIlIIlI;
            final int lllllllllllllIlIIlIlIIlIIlIIllII = this.zPosition * 16 + lllllllllllllIlIIlIlIIlIIlIlIIII;
            if (this.worldObj.provider.func_191066_m()) {
                if (lllllllllllllIlIIlIlIIlIIlIIlllI < lllllllllllllIlIIlIlIIlIIlIIllll) {
                    for (int lllllllllllllIlIIlIlIIlIIlIIlIll = lllllllllllllIlIIlIlIIlIIlIIlllI; lllllllllllllIlIIlIlIIlIIlIIlIll < lllllllllllllIlIIlIlIIlIIlIIllll; ++lllllllllllllIlIIlIlIIlIIlIIlIll) {
                        final ExtendedBlockStorage lllllllllllllIlIIlIlIIlIIlIIlIlI = this.storageArrays[lllllllllllllIlIIlIlIIlIIlIIlIll >> 4];
                        if (lllllllllllllIlIIlIlIIlIIlIIlIlI != Chunk.NULL_BLOCK_STORAGE) {
                            lllllllllllllIlIIlIlIIlIIlIIlIlI.setExtSkylightValue(lllllllllllllIlIIlIlIIlIIlIlIIlI, lllllllllllllIlIIlIlIIlIIlIIlIll & 0xF, lllllllllllllIlIIlIlIIlIIlIlIIII, 15);
                            this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + lllllllllllllIlIIlIlIIlIIlIlIIlI, lllllllllllllIlIIlIlIIlIIlIIlIll, (this.zPosition << 4) + lllllllllllllIlIIlIlIIlIIlIlIIII));
                        }
                    }
                }
                else {
                    for (int lllllllllllllIlIIlIlIIlIIlIIlIIl = lllllllllllllIlIIlIlIIlIIlIIllll; lllllllllllllIlIIlIlIIlIIlIIlIIl < lllllllllllllIlIIlIlIIlIIlIIlllI; ++lllllllllllllIlIIlIlIIlIIlIIlIIl) {
                        final ExtendedBlockStorage lllllllllllllIlIIlIlIIlIIlIIlIII = this.storageArrays[lllllllllllllIlIIlIlIIlIIlIIlIIl >> 4];
                        if (lllllllllllllIlIIlIlIIlIIlIIlIII != Chunk.NULL_BLOCK_STORAGE) {
                            lllllllllllllIlIIlIlIIlIIlIIlIII.setExtSkylightValue(lllllllllllllIlIIlIlIIlIIlIlIIlI, lllllllllllllIlIIlIlIIlIIlIIlIIl & 0xF, lllllllllllllIlIIlIlIIlIIlIlIIII, 0);
                            this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + lllllllllllllIlIIlIlIIlIIlIlIIlI, lllllllllllllIlIIlIlIIlIIlIIlIIl, (this.zPosition << 4) + lllllllllllllIlIIlIlIIlIIlIlIIII));
                        }
                    }
                }
                int lllllllllllllIlIIlIlIIlIIlIIIlll = 15;
                while (lllllllllllllIlIIlIlIIlIIlIIlllI > 0 && lllllllllllllIlIIlIlIIlIIlIIIlll > 0) {
                    --lllllllllllllIlIIlIlIIlIIlIIlllI;
                    int lllllllllllllIlIIlIlIIlIIlIIIllI = this.getBlockLightOpacity(lllllllllllllIlIIlIlIIlIIlIlIIlI, lllllllllllllIlIIlIlIIlIIlIIlllI, lllllllllllllIlIIlIlIIlIIlIlIIII);
                    if (lllllllllllllIlIIlIlIIlIIlIIIllI == 0) {
                        lllllllllllllIlIIlIlIIlIIlIIIllI = 1;
                    }
                    lllllllllllllIlIIlIlIIlIIlIIIlll -= lllllllllllllIlIIlIlIIlIIlIIIllI;
                    if (lllllllllllllIlIIlIlIIlIIlIIIlll < 0) {
                        lllllllllllllIlIIlIlIIlIIlIIIlll = 0;
                    }
                    final ExtendedBlockStorage lllllllllllllIlIIlIlIIlIIlIIIlIl = this.storageArrays[lllllllllllllIlIIlIlIIlIIlIIlllI >> 4];
                    if (lllllllllllllIlIIlIlIIlIIlIIIlIl != Chunk.NULL_BLOCK_STORAGE) {
                        lllllllllllllIlIIlIlIIlIIlIIIlIl.setExtSkylightValue(lllllllllllllIlIIlIlIIlIIlIlIIlI, lllllllllllllIlIIlIlIIlIIlIIlllI & 0xF, lllllllllllllIlIIlIlIIlIIlIlIIII, lllllllllllllIlIIlIlIIlIIlIIIlll);
                    }
                }
            }
            final int lllllllllllllIlIIlIlIIlIIlIIIlII = this.heightMap[lllllllllllllIlIIlIlIIlIIlIlIIII << 4 | lllllllllllllIlIIlIlIIlIIlIlIIlI];
            int lllllllllllllIlIIlIlIIlIIlIIIIlI;
            int lllllllllllllIlIIlIlIIlIIlIIIIll;
            if ((lllllllllllllIlIIlIlIIlIIlIIIIlI = lllllllllllllIlIIlIlIIlIIlIIIlII) < (lllllllllllllIlIIlIlIIlIIlIIIIll = lllllllllllllIlIIlIlIIlIIlIIllll)) {
                lllllllllllllIlIIlIlIIlIIlIIIIll = lllllllllllllIlIIlIlIIlIIlIIIlII;
                lllllllllllllIlIIlIlIIlIIlIIIIlI = lllllllllllllIlIIlIlIIlIIlIIllll;
            }
            if (lllllllllllllIlIIlIlIIlIIlIIIlII < this.heightMapMinimum) {
                this.heightMapMinimum = lllllllllllllIlIIlIlIIlIIlIIIlII;
            }
            if (this.worldObj.provider.func_191066_m()) {
                for (final EnumFacing lllllllllllllIlIIlIlIIlIIlIIIIIl : EnumFacing.Plane.HORIZONTAL) {
                    this.updateSkylightNeighborHeight(lllllllllllllIlIIlIlIIlIIlIIllIl + lllllllllllllIlIIlIlIIlIIlIIIIIl.getFrontOffsetX(), lllllllllllllIlIIlIlIIlIIlIIllII + lllllllllllllIlIIlIlIIlIIlIIIIIl.getFrontOffsetZ(), lllllllllllllIlIIlIlIIlIIlIIIIll, lllllllllllllIlIIlIlIIlIIlIIIIlI);
                }
                this.updateSkylightNeighborHeight(lllllllllllllIlIIlIlIIlIIlIIllIl, lllllllllllllIlIIlIlIIlIIlIIllII, lllllllllllllIlIIlIlIIlIIlIIIIll, lllllllllllllIlIIlIlIIlIIlIIIIlI);
            }
            this.isModified = true;
        }
    }
    
    public void fillChunk(final PacketBuffer lllllllllllllIlIIlIlIIIIIIIIlIll, final int lllllllllllllIlIIlIlIIIIIIIIlIlI, final boolean lllllllllllllIlIIlIlIIIIIIIIlIIl) {
        final boolean lllllllllllllIlIIlIlIIIIIIIlIIIl = this.worldObj.provider.func_191066_m();
        for (int lllllllllllllIlIIlIlIIIIIIIlIIII = 0; lllllllllllllIlIIlIlIIIIIIIlIIII < this.storageArrays.length; ++lllllllllllllIlIIlIlIIIIIIIlIIII) {
            ExtendedBlockStorage lllllllllllllIlIIlIlIIIIIIIIllll = this.storageArrays[lllllllllllllIlIIlIlIIIIIIIlIIII];
            if ((lllllllllllllIlIIlIlIIIIIIIIlIlI & 1 << lllllllllllllIlIIlIlIIIIIIIlIIII) == 0x0) {
                if (lllllllllllllIlIIlIlIIIIIIIIlIIl && lllllllllllllIlIIlIlIIIIIIIIllll != Chunk.NULL_BLOCK_STORAGE) {
                    this.storageArrays[lllllllllllllIlIIlIlIIIIIIIlIIII] = Chunk.NULL_BLOCK_STORAGE;
                }
            }
            else {
                if (lllllllllllllIlIIlIlIIIIIIIIllll == Chunk.NULL_BLOCK_STORAGE) {
                    lllllllllllllIlIIlIlIIIIIIIIllll = new ExtendedBlockStorage(lllllllllllllIlIIlIlIIIIIIIlIIII << 4, lllllllllllllIlIIlIlIIIIIIIlIIIl);
                    this.storageArrays[lllllllllllllIlIIlIlIIIIIIIlIIII] = lllllllllllllIlIIlIlIIIIIIIIllll;
                }
                lllllllllllllIlIIlIlIIIIIIIIllll.getData().read(lllllllllllllIlIIlIlIIIIIIIIlIll);
                lllllllllllllIlIIlIlIIIIIIIIlIll.readBytes(lllllllllllllIlIIlIlIIIIIIIIllll.getBlocklightArray().getData());
                if (lllllllllllllIlIIlIlIIIIIIIlIIIl) {
                    lllllllllllllIlIIlIlIIIIIIIIlIll.readBytes(lllllllllllllIlIIlIlIIIIIIIIllll.getSkylightArray().getData());
                }
            }
        }
        if (lllllllllllllIlIIlIlIIIIIIIIlIIl) {
            lllllllllllllIlIIlIlIIIIIIIIlIll.readBytes(this.blockBiomeArray);
        }
        for (int lllllllllllllIlIIlIlIIIIIIIIlllI = 0; lllllllllllllIlIIlIlIIIIIIIIlllI < this.storageArrays.length; ++lllllllllllllIlIIlIlIIIIIIIIlllI) {
            if (this.storageArrays[lllllllllllllIlIIlIlIIIIIIIIlllI] != Chunk.NULL_BLOCK_STORAGE && (lllllllllllllIlIIlIlIIIIIIIIlIlI & 1 << lllllllllllllIlIIlIlIIIIIIIIlllI) != 0x0) {
                this.storageArrays[lllllllllllllIlIIlIlIIIIIIIIlllI].removeInvalidBlocks();
            }
        }
        this.isLightPopulated = true;
        this.isTerrainPopulated = true;
        this.generateHeightMap();
        for (final TileEntity lllllllllllllIlIIlIlIIIIIIIIllIl : this.chunkTileEntityMap.values()) {
            lllllllllllllIlIIlIlIIIIIIIIllIl.updateContainingBlockInfo();
        }
    }
    
    public void setInhabitedTime(final long lllllllllllllIlIIlIIllllIIlIlllI) {
        this.inhabitedTime = lllllllllllllIlIIlIIllllIIlIlllI;
    }
    
    public int[] getHeightMap() {
        return this.heightMap;
    }
    
    public boolean needsSaving(final boolean lllllllllllllIlIIlIlIIIIlIIIllII) {
        if (lllllllllllllIlIIlIlIIIIlIIIllII) {
            if ((this.hasEntities && this.worldObj.getTotalWorldTime() != this.lastSaveTime) || this.isModified) {
                return true;
            }
        }
        else if (this.hasEntities && this.worldObj.getTotalWorldTime() >= this.lastSaveTime + 600L) {
            return true;
        }
        return this.isModified;
    }
    
    public void setLightFor(final EnumSkyBlock lllllllllllllIlIIlIlIIIllIIllllI, final BlockPos lllllllllllllIlIIlIlIIIllIlIlIlI, final int lllllllllllllIlIIlIlIIIllIIllIlI) {
        final int lllllllllllllIlIIlIlIIIllIlIIllI = lllllllllllllIlIIlIlIIIllIlIlIlI.getX() & 0xF;
        final int lllllllllllllIlIIlIlIIIllIlIIlII = lllllllllllllIlIIlIlIIIllIlIlIlI.getY();
        final int lllllllllllllIlIIlIlIIIllIlIIIlI = lllllllllllllIlIIlIlIIIllIlIlIlI.getZ() & 0xF;
        ExtendedBlockStorage lllllllllllllIlIIlIlIIIllIlIIIIl = this.storageArrays[lllllllllllllIlIIlIlIIIllIlIIlII >> 4];
        if (lllllllllllllIlIIlIlIIIllIlIIIIl == Chunk.NULL_BLOCK_STORAGE) {
            lllllllllllllIlIIlIlIIIllIlIIIIl = new ExtendedBlockStorage(lllllllllllllIlIIlIlIIIllIlIIlII >> 4 << 4, this.worldObj.provider.func_191066_m());
            this.storageArrays[lllllllllllllIlIIlIlIIIllIlIIlII >> 4] = lllllllllllllIlIIlIlIIIllIlIIIIl;
            this.generateSkylightMap();
        }
        this.isModified = true;
        if (lllllllllllllIlIIlIlIIIllIIllllI == EnumSkyBlock.SKY) {
            if (this.worldObj.provider.func_191066_m()) {
                lllllllllllllIlIIlIlIIIllIlIIIIl.setExtSkylightValue(lllllllllllllIlIIlIlIIIllIlIIllI, lllllllllllllIlIIlIlIIIllIlIIlII & 0xF, lllllllllllllIlIIlIlIIIllIlIIIlI, lllllllllllllIlIIlIlIIIllIIllIlI);
            }
        }
        else if (lllllllllllllIlIIlIlIIIllIIllllI == EnumSkyBlock.BLOCK) {
            lllllllllllllIlIIlIlIIIllIlIIIIl.setExtBlocklightValue(lllllllllllllIlIIlIlIIIllIlIIllI, lllllllllllllIlIIlIlIIIllIlIIlII & 0xF, lllllllllllllIlIIlIlIIIllIlIIIlI, lllllllllllllIlIIlIlIIIllIIllIlI);
        }
    }
    
    public Biome getBiome(final BlockPos lllllllllllllIlIIlIIllllllllllIl, final BiomeProvider lllllllllllllIlIIlIIllllllllllII) {
        final int lllllllllllllIlIIlIIlllllllllIll = lllllllllllllIlIIlIIllllllllllIl.getX() & 0xF;
        final int lllllllllllllIlIIlIIlllllllllIlI = lllllllllllllIlIIlIIllllllllllIl.getZ() & 0xF;
        int lllllllllllllIlIIlIIlllllllllIIl = this.blockBiomeArray[lllllllllllllIlIIlIIlllllllllIlI << 4 | lllllllllllllIlIIlIIlllllllllIll] & 0xFF;
        if (lllllllllllllIlIIlIIlllllllllIIl == 255) {
            final Biome lllllllllllllIlIIlIIlllllllllIII = lllllllllllllIlIIlIIllllllllllII.getBiome(lllllllllllllIlIIlIIllllllllllIl, Biomes.PLAINS);
            lllllllllllllIlIIlIIlllllllllIIl = Biome.getIdForBiome(lllllllllllllIlIIlIIlllllllllIII);
            this.blockBiomeArray[lllllllllllllIlIIlIIlllllllllIlI << 4 | lllllllllllllIlIIlIIlllllllllIll] = (byte)(lllllllllllllIlIIlIIlllllllllIIl & 0xFF);
        }
        final Biome lllllllllllllIlIIlIIllllllllIlll = Biome.getBiome(lllllllllllllIlIIlIIlllllllllIIl);
        return (lllllllllllllIlIIlIIllllllllIlll == null) ? Biomes.PLAINS : lllllllllllllIlIIlIIllllllllIlll;
    }
    
    @Nullable
    private ExtendedBlockStorage getLastExtendedBlockStorage() {
        for (int lllllllllllllIlIIlIlIIlIllIlllll = this.storageArrays.length - 1; lllllllllllllIlIIlIlIIlIllIlllll >= 0; --lllllllllllllIlIIlIlIIlIllIlllll) {
            if (this.storageArrays[lllllllllllllIlIIlIlIIlIllIlllll] != Chunk.NULL_BLOCK_STORAGE) {
                return this.storageArrays[lllllllllllllIlIIlIlIIlIllIlllll];
            }
        }
        return null;
    }
    
    private void checkLightSide(final EnumFacing lllllllllllllIlIIlIIlllllIIlIlII) {
        if (this.isTerrainPopulated) {
            if (lllllllllllllIlIIlIIlllllIIlIlII == EnumFacing.EAST) {
                for (int lllllllllllllIlIIlIIlllllIIllIIl = 0; lllllllllllllIlIIlIIlllllIIllIIl < 16; ++lllllllllllllIlIIlIIlllllIIllIIl) {
                    this.checkLight(15, lllllllllllllIlIIlIIlllllIIllIIl);
                }
            }
            else if (lllllllllllllIlIIlIIlllllIIlIlII == EnumFacing.WEST) {
                for (int lllllllllllllIlIIlIIlllllIIllIII = 0; lllllllllllllIlIIlIIlllllIIllIII < 16; ++lllllllllllllIlIIlIIlllllIIllIII) {
                    this.checkLight(0, lllllllllllllIlIIlIIlllllIIllIII);
                }
            }
            else if (lllllllllllllIlIIlIIlllllIIlIlII == EnumFacing.SOUTH) {
                for (int lllllllllllllIlIIlIIlllllIIlIlll = 0; lllllllllllllIlIIlIIlllllIIlIlll < 16; ++lllllllllllllIlIIlIIlllllIIlIlll) {
                    this.checkLight(lllllllllllllIlIIlIIlllllIIlIlll, 15);
                }
            }
            else if (lllllllllllllIlIIlIIlllllIIlIlII == EnumFacing.NORTH) {
                for (int lllllllllllllIlIIlIIlllllIIlIllI = 0; lllllllllllllIlIIlIIlllllIIlIllI < 16; ++lllllllllllllIlIIlIIlllllIIlIllI) {
                    this.checkLight(lllllllllllllIlIIlIIlllllIIlIllI, 0);
                }
            }
        }
    }
    
    public boolean isPopulated() {
        return this.chunkTicked && this.isTerrainPopulated && this.isLightPopulated;
    }
    
    public void removeEntity(final Entity lllllllllllllIlIIlIlIIIlIIllllII) {
        this.removeEntityAtIndex(lllllllllllllIlIIlIlIIIlIIllllII, lllllllllllllIlIIlIlIIIlIIllllII.chunkCoordY);
    }
    
    @Nullable
    public IBlockState setBlockState(final BlockPos lllllllllllllIlIIlIlIIIllllIIIll, final IBlockState lllllllllllllIlIIlIlIIIlllllIIll) {
        final int lllllllllllllIlIIlIlIIIlllllIIlI = lllllllllllllIlIIlIlIIIllllIIIll.getX() & 0xF;
        final int lllllllllllllIlIIlIlIIIlllllIIIl = lllllllllllllIlIIlIlIIIllllIIIll.getY();
        final int lllllllllllllIlIIlIlIIIlllllIIII = lllllllllllllIlIIlIlIIIllllIIIll.getZ() & 0xF;
        final int lllllllllllllIlIIlIlIIIllllIllll = lllllllllllllIlIIlIlIIIlllllIIII << 4 | lllllllllllllIlIIlIlIIIlllllIIlI;
        if (lllllllllllllIlIIlIlIIIlllllIIIl >= this.precipitationHeightMap[lllllllllllllIlIIlIlIIIllllIllll] - 1) {
            this.precipitationHeightMap[lllllllllllllIlIIlIlIIIllllIllll] = -999;
        }
        final int lllllllllllllIlIIlIlIIIllllIlllI = this.heightMap[lllllllllllllIlIIlIlIIIllllIllll];
        final IBlockState lllllllllllllIlIIlIlIIIllllIllIl = this.getBlockState(lllllllllllllIlIIlIlIIIllllIIIll);
        if (lllllllllllllIlIIlIlIIIllllIllIl == lllllllllllllIlIIlIlIIIlllllIIll) {
            return null;
        }
        final Block lllllllllllllIlIIlIlIIIllllIllII = lllllllllllllIlIIlIlIIIlllllIIll.getBlock();
        final Block lllllllllllllIlIIlIlIIIllllIlIll = lllllllllllllIlIIlIlIIIllllIllIl.getBlock();
        ExtendedBlockStorage lllllllllllllIlIIlIlIIIllllIlIlI = this.storageArrays[lllllllllllllIlIIlIlIIIlllllIIIl >> 4];
        boolean lllllllllllllIlIIlIlIIIllllIlIIl = false;
        if (lllllllllllllIlIIlIlIIIllllIlIlI == Chunk.NULL_BLOCK_STORAGE) {
            if (lllllllllllllIlIIlIlIIIllllIllII == Blocks.AIR) {
                return null;
            }
            lllllllllllllIlIIlIlIIIllllIlIlI = new ExtendedBlockStorage(lllllllllllllIlIIlIlIIIlllllIIIl >> 4 << 4, this.worldObj.provider.func_191066_m());
            this.storageArrays[lllllllllllllIlIIlIlIIIlllllIIIl >> 4] = lllllllllllllIlIIlIlIIIllllIlIlI;
            lllllllllllllIlIIlIlIIIllllIlIIl = (lllllllllllllIlIIlIlIIIlllllIIIl >= lllllllllllllIlIIlIlIIIllllIlllI);
        }
        lllllllllllllIlIIlIlIIIllllIlIlI.set(lllllllllllllIlIIlIlIIIlllllIIlI, lllllllllllllIlIIlIlIIIlllllIIIl & 0xF, lllllllllllllIlIIlIlIIIlllllIIII, lllllllllllllIlIIlIlIIIlllllIIll);
        if (lllllllllllllIlIIlIlIIIllllIlIll != lllllllllllllIlIIlIlIIIllllIllII) {
            if (!this.worldObj.isRemote) {
                lllllllllllllIlIIlIlIIIllllIlIll.breakBlock(this.worldObj, lllllllllllllIlIIlIlIIIllllIIIll, lllllllllllllIlIIlIlIIIllllIllIl);
            }
            else if (lllllllllllllIlIIlIlIIIllllIlIll instanceof ITileEntityProvider) {
                this.worldObj.removeTileEntity(lllllllllllllIlIIlIlIIIllllIIIll);
            }
        }
        if (lllllllllllllIlIIlIlIIIllllIlIlI.get(lllllllllllllIlIIlIlIIIlllllIIlI, lllllllllllllIlIIlIlIIIlllllIIIl & 0xF, lllllllllllllIlIIlIlIIIlllllIIII).getBlock() != lllllllllllllIlIIlIlIIIllllIllII) {
            return null;
        }
        if (lllllllllllllIlIIlIlIIIllllIlIIl) {
            this.generateSkylightMap();
        }
        else {
            final int lllllllllllllIlIIlIlIIIllllIlIII = lllllllllllllIlIIlIlIIIlllllIIll.getLightOpacity();
            final int lllllllllllllIlIIlIlIIIllllIIlll = lllllllllllllIlIIlIlIIIllllIllIl.getLightOpacity();
            if (lllllllllllllIlIIlIlIIIllllIlIII > 0) {
                if (lllllllllllllIlIIlIlIIIlllllIIIl >= lllllllllllllIlIIlIlIIIllllIlllI) {
                    this.relightBlock(lllllllllllllIlIIlIlIIIlllllIIlI, lllllllllllllIlIIlIlIIIlllllIIIl + 1, lllllllllllllIlIIlIlIIIlllllIIII);
                }
            }
            else if (lllllllllllllIlIIlIlIIIlllllIIIl == lllllllllllllIlIIlIlIIIllllIlllI - 1) {
                this.relightBlock(lllllllllllllIlIIlIlIIIlllllIIlI, lllllllllllllIlIIlIlIIIlllllIIIl, lllllllllllllIlIIlIlIIIlllllIIII);
            }
            if (lllllllllllllIlIIlIlIIIllllIlIII != lllllllllllllIlIIlIlIIIllllIIlll && (lllllllllllllIlIIlIlIIIllllIlIII < lllllllllllllIlIIlIlIIIllllIIlll || this.getLightFor(EnumSkyBlock.SKY, lllllllllllllIlIIlIlIIIllllIIIll) > 0 || this.getLightFor(EnumSkyBlock.BLOCK, lllllllllllllIlIIlIlIIIllllIIIll) > 0)) {
                this.propagateSkylightOcclusion(lllllllllllllIlIIlIlIIIlllllIIlI, lllllllllllllIlIIlIlIIIlllllIIII);
            }
        }
        if (lllllllllllllIlIIlIlIIIllllIlIll instanceof ITileEntityProvider) {
            final TileEntity lllllllllllllIlIIlIlIIIllllIIllI = this.getTileEntity(lllllllllllllIlIIlIlIIIllllIIIll, EnumCreateEntityType.CHECK);
            if (lllllllllllllIlIIlIlIIIllllIIllI != null) {
                lllllllllllllIlIIlIlIIIllllIIllI.updateContainingBlockInfo();
            }
        }
        if (!this.worldObj.isRemote && lllllllllllllIlIIlIlIIIllllIlIll != lllllllllllllIlIIlIlIIIllllIllII) {
            lllllllllllllIlIIlIlIIIllllIllII.onBlockAdded(this.worldObj, lllllllllllllIlIIlIlIIIllllIIIll, lllllllllllllIlIIlIlIIIlllllIIll);
        }
        if (lllllllllllllIlIIlIlIIIllllIllII instanceof ITileEntityProvider) {
            TileEntity lllllllllllllIlIIlIlIIIllllIIlIl = this.getTileEntity(lllllllllllllIlIIlIlIIIllllIIIll, EnumCreateEntityType.CHECK);
            if (lllllllllllllIlIIlIlIIIllllIIlIl == null) {
                lllllllllllllIlIIlIlIIIllllIIlIl = ((ITileEntityProvider)lllllllllllllIlIIlIlIIIllllIllII).createNewTileEntity(this.worldObj, lllllllllllllIlIIlIlIIIllllIllII.getMetaFromState(lllllllllllllIlIIlIlIIIlllllIIll));
                this.worldObj.setTileEntity(lllllllllllllIlIIlIlIIIllllIIIll, lllllllllllllIlIIlIlIIIllllIIlIl);
            }
            if (lllllllllllllIlIIlIlIIIllllIIlIl != null) {
                lllllllllllllIlIIlIlIIIllllIIlIl.updateContainingBlockInfo();
            }
        }
        this.isModified = true;
        return lllllllllllllIlIIlIlIIIllllIllIl;
    }
    
    public boolean isLightPopulated() {
        return this.isLightPopulated;
    }
    
    public void setLightPopulated(final boolean lllllllllllllIlIIlIIllllIlIIlIlI) {
        this.isLightPopulated = lllllllllllllIlIIlIIllllIlIIlIlI;
    }
    
    private void checkSkylightNeighborHeight(final int lllllllllllllIlIIlIlIIlIIlllIllI, final int lllllllllllllIlIIlIlIIlIIllllIlI, final int lllllllllllllIlIIlIlIIlIIlllIlII) {
        final int lllllllllllllIlIIlIlIIlIIllllIII = this.worldObj.getHeight(new BlockPos(lllllllllllllIlIIlIlIIlIIlllIllI, 0, lllllllllllllIlIIlIlIIlIIllllIlI)).getY();
        if (lllllllllllllIlIIlIlIIlIIllllIII > lllllllllllllIlIIlIlIIlIIlllIlII) {
            this.updateSkylightNeighborHeight(lllllllllllllIlIIlIlIIlIIlllIllI, lllllllllllllIlIIlIlIIlIIllllIlI, lllllllllllllIlIIlIlIIlIIlllIlII, lllllllllllllIlIIlIlIIlIIllllIII + 1);
        }
        else if (lllllllllllllIlIIlIlIIlIIllllIII < lllllllllllllIlIIlIlIIlIIlllIlII) {
            this.updateSkylightNeighborHeight(lllllllllllllIlIIlIlIIlIIlllIllI, lllllllllllllIlIIlIlIIlIIllllIlI, lllllllllllllIlIIlIlIIlIIllllIII, lllllllllllllIlIIlIlIIlIIlllIlII + 1);
        }
    }
    
    public void setChunkLoaded(final boolean lllllllllllllIlIIlIIllllIlllIIII) {
        this.isChunkLoaded = lllllllllllllIlIIlIIllllIlllIIII;
    }
    
    public int getHeight(final BlockPos lllllllllllllIlIIlIlIIlIlllIlllI) {
        return this.getHeightValue(lllllllllllllIlIIlIlIIlIlllIlllI.getX() & 0xF, lllllllllllllIlIIlIlIIlIlllIlllI.getZ() & 0xF);
    }
    
    public ChunkPos getChunkCoordIntPair() {
        return new ChunkPos(this.xPosition, this.zPosition);
    }
    
    private void recheckGaps(final boolean lllllllllllllIlIIlIlIIlIlIIIlIlI) {
        this.worldObj.theProfiler.startSection("recheckGaps");
        if (this.worldObj.isAreaLoaded(new BlockPos(this.xPosition * 16 + 8, 0, this.zPosition * 16 + 8), 16)) {
            for (int lllllllllllllIlIIlIlIIlIlIIlIIll = 0; lllllllllllllIlIIlIlIIlIlIIlIIll < 16; ++lllllllllllllIlIIlIlIIlIlIIlIIll) {
                for (int lllllllllllllIlIIlIlIIlIlIIlIIlI = 0; lllllllllllllIlIIlIlIIlIlIIlIIlI < 16; ++lllllllllllllIlIIlIlIIlIlIIlIIlI) {
                    if (this.updateSkylightColumns[lllllllllllllIlIIlIlIIlIlIIlIIll + lllllllllllllIlIIlIlIIlIlIIlIIlI * 16]) {
                        this.updateSkylightColumns[lllllllllllllIlIIlIlIIlIlIIlIIll + lllllllllllllIlIIlIlIIlIlIIlIIlI * 16] = false;
                        final int lllllllllllllIlIIlIlIIlIlIIlIIIl = this.getHeightValue(lllllllllllllIlIIlIlIIlIlIIlIIll, lllllllllllllIlIIlIlIIlIlIIlIIlI);
                        final int lllllllllllllIlIIlIlIIlIlIIlIIII = this.xPosition * 16 + lllllllllllllIlIIlIlIIlIlIIlIIll;
                        final int lllllllllllllIlIIlIlIIlIlIIIllll = this.zPosition * 16 + lllllllllllllIlIIlIlIIlIlIIlIIlI;
                        int lllllllllllllIlIIlIlIIlIlIIIlllI = Integer.MAX_VALUE;
                        for (final EnumFacing lllllllllllllIlIIlIlIIlIlIIIllIl : EnumFacing.Plane.HORIZONTAL) {
                            lllllllllllllIlIIlIlIIlIlIIIlllI = Math.min(lllllllllllllIlIIlIlIIlIlIIIlllI, this.worldObj.getChunksLowestHorizon(lllllllllllllIlIIlIlIIlIlIIlIIII + lllllllllllllIlIIlIlIIlIlIIIllIl.getFrontOffsetX(), lllllllllllllIlIIlIlIIlIlIIIllll + lllllllllllllIlIIlIlIIlIlIIIllIl.getFrontOffsetZ()));
                        }
                        this.checkSkylightNeighborHeight(lllllllllllllIlIIlIlIIlIlIIlIIII, lllllllllllllIlIIlIlIIlIlIIIllll, lllllllllllllIlIIlIlIIlIlIIIlllI);
                        for (final EnumFacing lllllllllllllIlIIlIlIIlIlIIIllII : EnumFacing.Plane.HORIZONTAL) {
                            this.checkSkylightNeighborHeight(lllllllllllllIlIIlIlIIlIlIIlIIII + lllllllllllllIlIIlIlIIlIlIIIllII.getFrontOffsetX(), lllllllllllllIlIIlIlIIlIlIIIllll + lllllllllllllIlIIlIlIIlIlIIIllII.getFrontOffsetZ(), lllllllllllllIlIIlIlIIlIlIIlIIIl);
                        }
                        if (lllllllllllllIlIIlIlIIlIlIIIlIlI) {
                            this.worldObj.theProfiler.endSection();
                            return;
                        }
                    }
                }
            }
            this.isGapLightingUpdated = false;
        }
        this.worldObj.theProfiler.endSection();
    }
    
    public boolean getAreLevelsEmpty(int lllllllllllllIlIIlIlIIIIIIlIIllI, int lllllllllllllIlIIlIlIIIIIIlIIlIl) {
        if (lllllllllllllIlIIlIlIIIIIIlIIllI < 0) {
            lllllllllllllIlIIlIlIIIIIIlIIllI = 0;
        }
        if (lllllllllllllIlIIlIlIIIIIIlIIlIl >= 256) {
            lllllllllllllIlIIlIlIIIIIIlIIlIl = 255;
        }
        for (int lllllllllllllIlIIlIlIIIIIIlIlIIl = lllllllllllllIlIIlIlIIIIIIlIIllI; lllllllllllllIlIIlIlIIIIIIlIlIIl <= lllllllllllllIlIIlIlIIIIIIlIIlIl; lllllllllllllIlIIlIlIIIIIIlIlIIl += 16) {
            final ExtendedBlockStorage lllllllllllllIlIIlIlIIIIIIlIlIII = this.storageArrays[lllllllllllllIlIIlIlIIIIIIlIlIIl >> 4];
            if (lllllllllllllIlIIlIlIIIIIIlIlIII != Chunk.NULL_BLOCK_STORAGE && !lllllllllllllIlIIlIlIIIIIIlIlIII.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public Random getRandomWithSeed(final long lllllllllllllIlIIlIlIIIIlIIIIllI) {
        return new Random(this.worldObj.getSeed() + this.xPosition * this.xPosition * 4987142 + this.xPosition * 5947611 + this.zPosition * this.zPosition * 4392871L + this.zPosition * 389711 ^ lllllllllllllIlIIlIlIIIIlIIIIllI);
    }
    
    @Nullable
    private TileEntity createNewTileEntity(final BlockPos lllllllllllllIlIIlIlIIIlIIIllIII) {
        final IBlockState lllllllllllllIlIIlIlIIIlIIIllIll = this.getBlockState(lllllllllllllIlIIlIlIIIlIIIllIII);
        final Block lllllllllllllIlIIlIlIIIlIIIllIlI = lllllllllllllIlIIlIlIIIlIIIllIll.getBlock();
        return lllllllllllllIlIIlIlIIIlIIIllIlI.hasTileEntity() ? ((ITileEntityProvider)lllllllllllllIlIIlIlIIIlIIIllIlI).createNewTileEntity(this.worldObj, lllllllllllllIlIIlIlIIIlIIIllIll.getBlock().getMetaFromState(lllllllllllllIlIIlIlIIIlIIIllIll)) : null;
    }
    
    public void setHasEntities(final boolean lllllllllllllIlIIlIIllllIlIIIIII) {
        this.hasEntities = lllllllllllllIlIIlIIllllIlIIIIII;
    }
    
    public boolean isAtLocation(final int lllllllllllllIlIIlIlIIlIllllIIll, final int lllllllllllllIlIIlIlIIlIllllIlIl) {
        return lllllllllllllIlIIlIlIIlIllllIIll == this.xPosition && lllllllllllllIlIIlIlIIlIllllIlIl == this.zPosition;
    }
    
    public void generateSkylightMap() {
        final int lllllllllllllIlIIlIlIIlIlIlllIII = this.getTopFilledSegment();
        this.heightMapMinimum = Integer.MAX_VALUE;
        for (int lllllllllllllIlIIlIlIIlIlIllIlll = 0; lllllllllllllIlIIlIlIIlIlIllIlll < 16; ++lllllllllllllIlIIlIlIIlIlIllIlll) {
            for (int lllllllllllllIlIIlIlIIlIlIllIllI = 0; lllllllllllllIlIIlIlIIlIlIllIllI < 16; ++lllllllllllllIlIIlIlIIlIlIllIllI) {
                this.precipitationHeightMap[lllllllllllllIlIIlIlIIlIlIllIlll + (lllllllllllllIlIIlIlIIlIlIllIllI << 4)] = -999;
                int lllllllllllllIlIIlIlIIlIlIllIlIl = lllllllllllllIlIIlIlIIlIlIlllIII + 16;
                while (lllllllllllllIlIIlIlIIlIlIllIlIl > 0) {
                    if (this.getBlockLightOpacity(lllllllllllllIlIIlIlIIlIlIllIlll, lllllllllllllIlIIlIlIIlIlIllIlIl - 1, lllllllllllllIlIIlIlIIlIlIllIllI) != 0) {
                        if ((this.heightMap[lllllllllllllIlIIlIlIIlIlIllIllI << 4 | lllllllllllllIlIIlIlIIlIlIllIlll] = lllllllllllllIlIIlIlIIlIlIllIlIl) < this.heightMapMinimum) {
                            this.heightMapMinimum = lllllllllllllIlIIlIlIIlIlIllIlIl;
                            break;
                        }
                        break;
                    }
                    else {
                        --lllllllllllllIlIIlIlIIlIlIllIlIl;
                    }
                }
                if (this.worldObj.provider.func_191066_m()) {
                    int lllllllllllllIlIIlIlIIlIlIllIlII = 15;
                    int lllllllllllllIlIIlIlIIlIlIllIIll = lllllllllllllIlIIlIlIIlIlIlllIII + 16 - 1;
                    do {
                        int lllllllllllllIlIIlIlIIlIlIllIIlI = this.getBlockLightOpacity(lllllllllllllIlIIlIlIIlIlIllIlll, lllllllllllllIlIIlIlIIlIlIllIIll, lllllllllllllIlIIlIlIIlIlIllIllI);
                        if (lllllllllllllIlIIlIlIIlIlIllIIlI == 0 && lllllllllllllIlIIlIlIIlIlIllIlII != 15) {
                            lllllllllllllIlIIlIlIIlIlIllIIlI = 1;
                        }
                        lllllllllllllIlIIlIlIIlIlIllIlII -= lllllllllllllIlIIlIlIIlIlIllIIlI;
                        if (lllllllllllllIlIIlIlIIlIlIllIlII > 0) {
                            final ExtendedBlockStorage lllllllllllllIlIIlIlIIlIlIllIIIl = this.storageArrays[lllllllllllllIlIIlIlIIlIlIllIIll >> 4];
                            if (lllllllllllllIlIIlIlIIlIlIllIIIl == Chunk.NULL_BLOCK_STORAGE) {
                                continue;
                            }
                            lllllllllllllIlIIlIlIIlIlIllIIIl.setExtSkylightValue(lllllllllllllIlIIlIlIIlIlIllIlll, lllllllllllllIlIIlIlIIlIlIllIIll & 0xF, lllllllllllllIlIIlIlIIlIlIllIllI, lllllllllllllIlIIlIlIIlIlIllIlII);
                            this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + lllllllllllllIlIIlIlIIlIlIllIlll, lllllllllllllIlIIlIlIIlIlIllIIll, (this.zPosition << 4) + lllllllllllllIlIIlIlIIlIlIllIllI));
                        }
                    } while (--lllllllllllllIlIIlIlIIlIlIllIIll > 0 && lllllllllllllIlIIlIlIIlIlIllIlII > 0);
                }
            }
        }
        this.isModified = true;
    }
    
    private void setSkylightUpdated() {
        for (int lllllllllllllIlIIlIIlllllIlIIIIl = 0; lllllllllllllIlIIlIIlllllIlIIIIl < this.updateSkylightColumns.length; ++lllllllllllllIlIIlIIlllllIlIIIIl) {
            this.updateSkylightColumns[lllllllllllllIlIIlIIlllllIlIIIIl] = true;
        }
        this.recheckGaps(false);
    }
    
    public long getInhabitedTime() {
        return this.inhabitedTime;
    }
    
    public void onChunkLoad() {
        this.isChunkLoaded = true;
        this.worldObj.addTileEntities(this.chunkTileEntityMap.values());
        final int lllllllllllllIlIIlIlIIIIlllIIllI;
        final long lllllllllllllIlIIlIlIIIIlllIIlll = ((ClassInheritanceMultiMap<Entity>[])(Object)(lllllllllllllIlIIlIlIIIIlllIIllI = (int)(Object)this.entityLists)).length;
        for (final ClassInheritanceMultiMap<Entity> lllllllllllllIlIIlIlIIIIlllIlIll : lllllllllllllIlIIlIlIIIIlllIIllI) {
            this.worldObj.loadEntities(lllllllllllllIlIIlIlIIIIlllIlIll);
        }
    }
    
    public ExtendedBlockStorage[] getBlockStorageArray() {
        return this.storageArrays;
    }
    
    public void onTick(final boolean lllllllllllllIlIIlIlIIIIIlIIIIIl) {
        if (this.isGapLightingUpdated && this.worldObj.provider.func_191066_m() && !lllllllllllllIlIIlIlIIIIIlIIIIIl) {
            this.recheckGaps(this.worldObj.isRemote);
        }
        this.chunkTicked = true;
        if (!this.isLightPopulated && this.isTerrainPopulated) {
            this.checkLight();
        }
        while (!this.tileEntityPosQueue.isEmpty()) {
            final BlockPos lllllllllllllIlIIlIlIIIIIlIIIIII = this.tileEntityPosQueue.poll();
            if (this.getTileEntity(lllllllllllllIlIIlIlIIIIIlIIIIII, EnumCreateEntityType.CHECK) == null && this.getBlockState(lllllllllllllIlIIlIlIIIIIlIIIIII).getBlock().hasTileEntity()) {
                final TileEntity lllllllllllllIlIIlIlIIIIIIllllll = this.createNewTileEntity(lllllllllllllIlIIlIlIIIIIlIIIIII);
                this.worldObj.setTileEntity(lllllllllllllIlIIlIlIIIIIlIIIIII, lllllllllllllIlIIlIlIIIIIIllllll);
                this.worldObj.markBlockRangeForRenderUpdate(lllllllllllllIlIIlIlIIIIIlIIIIII, lllllllllllllIlIIlIlIIIIIlIIIIII);
            }
        }
    }
    
    public void setHeightMap(final int[] lllllllllllllIlIIlIIllllIllIIIlI) {
        if (this.heightMap.length != lllllllllllllIlIIlIIllllIllIIIlI.length) {
            Chunk.LOGGER.warn("Could not set level chunk heightmap, array length is {} instead of {}", (Object)lllllllllllllIlIIlIIllllIllIIIlI.length, (Object)this.heightMap.length);
        }
        else {
            System.arraycopy(lllllllllllllIlIIlIIllllIllIIIlI, 0, this.heightMap, 0, this.heightMap.length);
        }
    }
    
    public void onChunkUnload() {
        this.isChunkLoaded = false;
        for (final TileEntity lllllllllllllIlIIlIlIIIIllIlllll : this.chunkTileEntityMap.values()) {
            this.worldObj.markTileEntityForRemoval(lllllllllllllIlIIlIlIIIIllIlllll);
        }
        char lllllllllllllIlIIlIlIIIIllIllIIl;
        for (Exception lllllllllllllIlIIlIlIIIIllIllIlI = (Exception)((ClassInheritanceMultiMap<Entity>[])(Object)(lllllllllllllIlIIlIlIIIIllIllIIl = (char)(Object)this.entityLists)).length, lllllllllllllIlIIlIlIIIIllIllIll = (Exception)0; lllllllllllllIlIIlIlIIIIllIllIll < lllllllllllllIlIIlIlIIIIllIllIlI; ++lllllllllllllIlIIlIlIIIIllIllIll) {
            final ClassInheritanceMultiMap<Entity> lllllllllllllIlIIlIlIIIIllIllllI = lllllllllllllIlIIlIlIIIIllIllIIl[lllllllllllllIlIIlIlIIIIllIllIll];
            this.worldObj.unloadEntities(lllllllllllllIlIIlIlIIIIllIllllI);
        }
    }
    
    public IBlockState getBlockState(final int lllllllllllllIlIIlIlIIlIIIIIlIlI, final int lllllllllllllIlIIlIlIIlIIIIIlIIl, final int lllllllllllllIlIIlIlIIlIIIIIlIII) {
        if (this.worldObj.getWorldType() == WorldType.DEBUG_WORLD) {
            IBlockState lllllllllllllIlIIlIlIIlIIIIlIIII = null;
            if (lllllllllllllIlIIlIlIIlIIIIIlIIl == 60) {
                lllllllllllllIlIIlIlIIlIIIIlIIII = Blocks.BARRIER.getDefaultState();
            }
            if (lllllllllllllIlIIlIlIIlIIIIIlIIl == 70) {
                lllllllllllllIlIIlIlIIlIIIIlIIII = ChunkGeneratorDebug.getBlockStateFor(lllllllllllllIlIIlIlIIlIIIIIlIlI, lllllllllllllIlIIlIlIIlIIIIIlIII);
            }
            return (lllllllllllllIlIIlIlIIlIIIIlIIII == null) ? Blocks.AIR.getDefaultState() : lllllllllllllIlIIlIlIIlIIIIlIIII;
        }
        try {
            if (lllllllllllllIlIIlIlIIlIIIIIlIIl >= 0 && lllllllllllllIlIIlIlIIlIIIIIlIIl >> 4 < this.storageArrays.length) {
                final ExtendedBlockStorage lllllllllllllIlIIlIlIIlIIIIIllll = this.storageArrays[lllllllllllllIlIIlIlIIlIIIIIlIIl >> 4];
                if (lllllllllllllIlIIlIlIIlIIIIIllll != Chunk.NULL_BLOCK_STORAGE) {
                    return lllllllllllllIlIIlIlIIlIIIIIllll.get(lllllllllllllIlIIlIlIIlIIIIIlIlI & 0xF, lllllllllllllIlIIlIlIIlIIIIIlIIl & 0xF, lllllllllllllIlIIlIlIIlIIIIIlIII & 0xF);
                }
            }
            return Blocks.AIR.getDefaultState();
        }
        catch (Throwable lllllllllllllIlIIlIlIIlIIIIIlllI) {
            final CrashReport lllllllllllllIlIIlIlIIlIIIIIllIl = CrashReport.makeCrashReport(lllllllllllllIlIIlIlIIlIIIIIlllI, "Getting block state");
            final CrashReportCategory lllllllllllllIlIIlIlIIlIIIIIllII = lllllllllllllIlIIlIlIIlIIIIIllIl.makeCategory("Block being got");
            lllllllllllllIlIIlIlIIlIIIIIllII.setDetail("Location", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return CrashReportCategory.getCoordinateInfo(lllllllllllllIlIIlIlIIlIIIIIlIlI, lllllllllllllIlIIlIlIIlIIIIIlIIl, lllllllllllllIlIIlIlIIlIIIIIlIII);
                }
            });
            throw new ReportedException(lllllllllllllIlIIlIlIIlIIIIIllIl);
        }
    }
    
    public Map<BlockPos, TileEntity> getTileEntityMap() {
        return this.chunkTileEntityMap;
    }
    
    public void addTileEntity(final BlockPos lllllllllllllIlIIlIlIIIIllllllII, final TileEntity lllllllllllllIlIIlIlIIIIlllllIll) {
        lllllllllllllIlIIlIlIIIIlllllIll.setWorldObj(this.worldObj);
        lllllllllllllIlIIlIlIIIIlllllIll.setPos(lllllllllllllIlIIlIlIIIIllllllII);
        if (this.getBlockState(lllllllllllllIlIIlIlIIIIllllllII).getBlock() instanceof ITileEntityProvider) {
            if (this.chunkTileEntityMap.containsKey(lllllllllllllIlIIlIlIIIIllllllII)) {
                this.chunkTileEntityMap.get(lllllllllllllIlIIlIlIIIIllllllII).invalidate();
            }
            lllllllllllllIlIIlIlIIIIlllllIll.validate();
            this.chunkTileEntityMap.put(lllllllllllllIlIIlIlIIIIllllllII, lllllllllllllIlIIlIlIIIIlllllIll);
        }
    }
    
    private void propagateSkylightOcclusion(final int lllllllllllllIlIIlIlIIlIlIlIIlII, final int lllllllllllllIlIIlIlIIlIlIlIIIII) {
        this.updateSkylightColumns[lllllllllllllIlIIlIlIIlIlIlIIlII + lllllllllllllIlIIlIlIIlIlIlIIIII * 16] = true;
        this.isGapLightingUpdated = true;
    }
    
    public int getHeightValue(final int lllllllllllllIlIIlIlIIlIlllIIlll, final int lllllllllllllIlIIlIlIIlIlllIIIll) {
        return this.heightMap[lllllllllllllIlIIlIlIIlIlllIIIll << 4 | lllllllllllllIlIIlIlIIlIlllIIlll];
    }
    
    public void removeTileEntity(final BlockPos lllllllllllllIlIIlIlIIIIllllIllI) {
        if (this.isChunkLoaded) {
            final TileEntity lllllllllllllIlIIlIlIIIIllllIlIl = this.chunkTileEntityMap.remove(lllllllllllllIlIIlIlIIIIllllIllI);
            if (lllllllllllllIlIIlIlIIIIllllIlIl != null) {
                lllllllllllllIlIIlIlIIIIllllIlIl.invalidate();
            }
        }
    }
    
    public int getLightFor(final EnumSkyBlock lllllllllllllIlIIlIlIIIlllIIIllI, final BlockPos lllllllllllllIlIIlIlIIIlllIIIlIl) {
        final int lllllllllllllIlIIlIlIIIlllIIlIll = lllllllllllllIlIIlIlIIIlllIIIlIl.getX() & 0xF;
        final int lllllllllllllIlIIlIlIIIlllIIlIlI = lllllllllllllIlIIlIlIIIlllIIIlIl.getY();
        final int lllllllllllllIlIIlIlIIIlllIIlIIl = lllllllllllllIlIIlIlIIIlllIIIlIl.getZ() & 0xF;
        final ExtendedBlockStorage lllllllllllllIlIIlIlIIIlllIIlIII = this.storageArrays[lllllllllllllIlIIlIlIIIlllIIlIlI >> 4];
        if (lllllllllllllIlIIlIlIIIlllIIlIII == Chunk.NULL_BLOCK_STORAGE) {
            return this.canSeeSky(lllllllllllllIlIIlIlIIIlllIIIlIl) ? lllllllllllllIlIIlIlIIIlllIIIllI.defaultLightValue : 0;
        }
        if (lllllllllllllIlIIlIlIIIlllIIIllI == EnumSkyBlock.SKY) {
            return this.worldObj.provider.func_191066_m() ? lllllllllllllIlIIlIlIIIlllIIlIII.getExtSkylightValue(lllllllllllllIlIIlIlIIIlllIIlIll, lllllllllllllIlIIlIlIIIlllIIlIlI & 0xF, lllllllllllllIlIIlIlIIIlllIIlIIl) : 0;
        }
        return (lllllllllllllIlIIlIlIIIlllIIIllI == EnumSkyBlock.BLOCK) ? lllllllllllllIlIIlIlIIIlllIIlIII.getExtBlocklightValue(lllllllllllllIlIIlIlIIIlllIIlIll, lllllllllllllIlIIlIlIIIlllIIlIlI & 0xF, lllllllllllllIlIIlIlIIIlllIIlIIl) : lllllllllllllIlIIlIlIIIlllIIIllI.defaultLightValue;
    }
    
    public void setModified(final boolean lllllllllllllIlIIlIIllllIlIIIlII) {
        this.isModified = lllllllllllllIlIIlIIllllIlIIIlII;
    }
    
    public int getTopFilledSegment() {
        final ExtendedBlockStorage lllllllllllllIlIIlIlIIlIllIllIIl = this.getLastExtendedBlockStorage();
        return (lllllllllllllIlIIlIlIIlIllIllIIl == null) ? 0 : lllllllllllllIlIIlIlIIlIllIllIIl.getYLocation();
    }
    
    public void removeEntityAtIndex(final Entity lllllllllllllIlIIlIlIIIlIIllIlIl, int lllllllllllllIlIIlIlIIIlIIllIIIl) {
        if (lllllllllllllIlIIlIlIIIlIIllIIIl < 0) {
            lllllllllllllIlIIlIlIIIlIIllIIIl = 0;
        }
        if (lllllllllllllIlIIlIlIIIlIIllIIIl >= this.entityLists.length) {
            lllllllllllllIlIIlIlIIIlIIllIIIl = this.entityLists.length - 1;
        }
        this.entityLists[lllllllllllllIlIIlIlIIIlIIllIIIl].remove(lllllllllllllIlIIlIlIIIlIIllIlIl);
    }
    
    public void enqueueRelightChecks() {
        if (this.queuedLightChecks < 4096) {
            final BlockPos lllllllllllllIlIIlIIllllllIlIIIl = new BlockPos(this.xPosition << 4, 0, this.zPosition << 4);
            for (int lllllllllllllIlIIlIIllllllIIllll = 0; lllllllllllllIlIIlIIllllllIIllll < 8; ++lllllllllllllIlIIlIIllllllIIllll) {
                if (this.queuedLightChecks >= 4096) {
                    return;
                }
                final int lllllllllllllIlIIlIIllllllIIllIl = this.queuedLightChecks % 16;
                final int lllllllllllllIlIIlIIllllllIIllII = this.queuedLightChecks / 16 % 16;
                final int lllllllllllllIlIIlIIllllllIIlIlI = this.queuedLightChecks / 256;
                ++this.queuedLightChecks;
                for (int lllllllllllllIlIIlIIllllllIIlIIl = 0; lllllllllllllIlIIlIIllllllIIlIIl < 16; ++lllllllllllllIlIIlIIllllllIIlIIl) {
                    final BlockPos lllllllllllllIlIIlIIllllllIIlIII = lllllllllllllIlIIlIIllllllIlIIIl.add(lllllllllllllIlIIlIIllllllIIllII, (lllllllllllllIlIIlIIllllllIIllIl << 4) + lllllllllllllIlIIlIIllllllIIlIIl, lllllllllllllIlIIlIIllllllIIlIlI);
                    final boolean lllllllllllllIlIIlIIllllllIIIlll = lllllllllllllIlIIlIIllllllIIlIIl == 0 || lllllllllllllIlIIlIIllllllIIlIIl == 15 || lllllllllllllIlIIlIIllllllIIllII == 0 || lllllllllllllIlIIlIIllllllIIllII == 15 || lllllllllllllIlIIlIIllllllIIlIlI == 0 || lllllllllllllIlIIlIIllllllIIlIlI == 15;
                    if ((this.storageArrays[lllllllllllllIlIIlIIllllllIIllIl] == Chunk.NULL_BLOCK_STORAGE && lllllllllllllIlIIlIIllllllIIIlll) || (this.storageArrays[lllllllllllllIlIIlIIllllllIIllIl] != Chunk.NULL_BLOCK_STORAGE && this.storageArrays[lllllllllllllIlIIlIIllllllIIllIl].get(lllllllllllllIlIIlIIllllllIIllII, lllllllllllllIlIIlIIllllllIIlIIl, lllllllllllllIlIIlIIllllllIIlIlI).getMaterial() == Material.AIR)) {
                        final String lllllllllllllIlIIlIIlllllIllIllI;
                        final Exception lllllllllllllIlIIlIIlllllIllIlll = (Exception)((EnumFacing[])(Object)(lllllllllllllIlIIlIIlllllIllIllI = (String)(Object)EnumFacing.values())).length;
                        for (float lllllllllllllIlIIlIIlllllIlllIII = 0; lllllllllllllIlIIlIIlllllIlllIII < lllllllllllllIlIIlIIlllllIllIlll; ++lllllllllllllIlIIlIIlllllIlllIII) {
                            final EnumFacing lllllllllllllIlIIlIIllllllIIIllI = lllllllllllllIlIIlIIlllllIllIllI[lllllllllllllIlIIlIIlllllIlllIII];
                            final BlockPos lllllllllllllIlIIlIIllllllIIIlIl = lllllllllllllIlIIlIIllllllIIlIII.offset(lllllllllllllIlIIlIIllllllIIIllI);
                            if (this.worldObj.getBlockState(lllllllllllllIlIIlIIllllllIIIlIl).getLightValue() > 0) {
                                this.worldObj.checkLight(lllllllllllllIlIIlIIllllllIIIlIl);
                            }
                        }
                        this.worldObj.checkLight(lllllllllllllIlIIlIIllllllIIlIII);
                    }
                }
            }
        }
    }
    
    public void populateChunk(final IChunkProvider lllllllllllllIlIIlIlIIIIIlllIIIl, final IChunkGenerator lllllllllllllIlIIlIlIIIIIllllIII) {
        final Chunk lllllllllllllIlIIlIlIIIIIlllIlll = lllllllllllllIlIIlIlIIIIIlllIIIl.getLoadedChunk(this.xPosition, this.zPosition - 1);
        final Chunk lllllllllllllIlIIlIlIIIIIlllIllI = lllllllllllllIlIIlIlIIIIIlllIIIl.getLoadedChunk(this.xPosition + 1, this.zPosition);
        final Chunk lllllllllllllIlIIlIlIIIIIlllIlIl = lllllllllllllIlIIlIlIIIIIlllIIIl.getLoadedChunk(this.xPosition, this.zPosition + 1);
        final Chunk lllllllllllllIlIIlIlIIIIIlllIlII = lllllllllllllIlIIlIlIIIIIlllIIIl.getLoadedChunk(this.xPosition - 1, this.zPosition);
        if (lllllllllllllIlIIlIlIIIIIlllIllI != null && lllllllllllllIlIIlIlIIIIIlllIlIl != null && lllllllllllllIlIIlIlIIIIIlllIIIl.getLoadedChunk(this.xPosition + 1, this.zPosition + 1) != null) {
            this.populateChunk(lllllllllllllIlIIlIlIIIIIllllIII);
        }
        if (lllllllllllllIlIIlIlIIIIIlllIlII != null && lllllllllllllIlIIlIlIIIIIlllIlIl != null && lllllllllllllIlIIlIlIIIIIlllIIIl.getLoadedChunk(this.xPosition - 1, this.zPosition + 1) != null) {
            lllllllllllllIlIIlIlIIIIIlllIlII.populateChunk(lllllllllllllIlIIlIlIIIIIllllIII);
        }
        if (lllllllllllllIlIIlIlIIIIIlllIlll != null && lllllllllllllIlIIlIlIIIIIlllIllI != null && lllllllllllllIlIIlIlIIIIIlllIIIl.getLoadedChunk(this.xPosition + 1, this.zPosition - 1) != null) {
            lllllllllllllIlIIlIlIIIIIlllIlll.populateChunk(lllllllllllllIlIIlIlIIIIIllllIII);
        }
        if (lllllllllllllIlIIlIlIIIIIlllIlll != null && lllllllllllllIlIIlIlIIIIIlllIlII != null) {
            final Chunk lllllllllllllIlIIlIlIIIIIlllIIll = lllllllllllllIlIIlIlIIIIIlllIIIl.getLoadedChunk(this.xPosition - 1, this.zPosition - 1);
            if (lllllllllllllIlIIlIlIIIIIlllIIll != null) {
                lllllllllllllIlIIlIlIIIIIlllIIll.populateChunk(lllllllllllllIlIIlIlIIIIIllllIII);
            }
        }
    }
    
    public ClassInheritanceMultiMap<Entity>[] getEntityLists() {
        return this.entityLists;
    }
    
    public boolean isTerrainPopulated() {
        return this.isTerrainPopulated;
    }
    
    private void updateSkylightNeighborHeight(final int lllllllllllllIlIIlIlIIlIIllIIlIl, final int lllllllllllllIlIIlIlIIlIIllIIlII, final int lllllllllllllIlIIlIlIIlIIllIIIll, final int lllllllllllllIlIIlIlIIlIIllIlIII) {
        if (lllllllllllllIlIIlIlIIlIIllIlIII > lllllllllllllIlIIlIlIIlIIllIIIll && this.worldObj.isAreaLoaded(new BlockPos(lllllllllllllIlIIlIlIIlIIllIIlIl, 0, lllllllllllllIlIIlIlIIlIIllIIlII), 16)) {
            for (int lllllllllllllIlIIlIlIIlIIllIIlll = lllllllllllllIlIIlIlIIlIIllIIIll; lllllllllllllIlIIlIlIIlIIllIIlll < lllllllllllllIlIIlIlIIlIIllIlIII; ++lllllllllllllIlIIlIlIIlIIllIIlll) {
                this.worldObj.checkLightFor(EnumSkyBlock.SKY, new BlockPos(lllllllllllllIlIIlIlIIlIIllIIlIl, lllllllllllllIlIIlIlIIlIIllIIlll, lllllllllllllIlIIlIlIIlIIllIIlII));
            }
            this.isModified = true;
        }
    }
    
    public void addTileEntity(final TileEntity lllllllllllllIlIIlIlIIIlIIIIIllI) {
        this.addTileEntity(lllllllllllllIlIIlIlIIIlIIIIIllI.getPos(), lllllllllllllIlIIlIlIIIlIIIIIllI);
        if (this.isChunkLoaded) {
            this.worldObj.addTileEntity(lllllllllllllIlIIlIlIIIlIIIIIllI);
        }
    }
    
    protected void populateChunk(final IChunkGenerator lllllllllllllIlIIlIlIIIIIllIIlIl) {
        if (this.isTerrainPopulated()) {
            if (lllllllllllllIlIIlIlIIIIIllIIlIl.generateStructures(this, this.xPosition, this.zPosition)) {
                this.setChunkModified();
            }
        }
        else {
            this.checkLight();
            lllllllllllllIlIIlIlIIIIIllIIlIl.populate(this.xPosition, this.zPosition);
            this.setChunkModified();
        }
    }
    
    public void checkLight() {
        this.isTerrainPopulated = true;
        this.isLightPopulated = true;
        final BlockPos lllllllllllllIlIIlIIlllllIlIlllI = new BlockPos(this.xPosition << 4, 0, this.zPosition << 4);
        if (this.worldObj.provider.func_191066_m()) {
            if (this.worldObj.isAreaLoaded(lllllllllllllIlIIlIIlllllIlIlllI.add(-1, 0, -1), lllllllllllllIlIIlIIlllllIlIlllI.add(16, this.worldObj.getSeaLevel(), 16))) {
            Label_0121:
                for (int lllllllllllllIlIIlIIlllllIlIllIl = 0; lllllllllllllIlIIlIIlllllIlIllIl < 16; ++lllllllllllllIlIIlIIlllllIlIllIl) {
                    for (int lllllllllllllIlIIlIIlllllIlIllII = 0; lllllllllllllIlIIlIIlllllIlIllII < 16; ++lllllllllllllIlIIlIIlllllIlIllII) {
                        if (!this.checkLight(lllllllllllllIlIIlIIlllllIlIllIl, lllllllllllllIlIIlIIlllllIlIllII)) {
                            this.isLightPopulated = false;
                            break Label_0121;
                        }
                    }
                }
                if (this.isLightPopulated) {
                    for (final EnumFacing lllllllllllllIlIIlIIlllllIlIlIll : EnumFacing.Plane.HORIZONTAL) {
                        final int lllllllllllllIlIIlIIlllllIlIlIlI = (lllllllllllllIlIIlIIlllllIlIlIll.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) ? 16 : 1;
                        this.worldObj.getChunkFromBlockCoords(lllllllllllllIlIIlIIlllllIlIlllI.offset(lllllllllllllIlIIlIIlllllIlIlIll, lllllllllllllIlIIlIIlllllIlIlIlI)).checkLightSide(lllllllllllllIlIIlIIlllllIlIlIll.getOpposite());
                    }
                    this.setSkylightUpdated();
                }
            }
            else {
                this.isLightPopulated = false;
            }
        }
    }
    
    public int getLowestHeight() {
        return this.heightMapMinimum;
    }
    
    public enum EnumCreateEntityType
    {
        IMMEDIATE("IMMEDIATE", 0), 
        CHECK("CHECK", 2), 
        QUEUED("QUEUED", 1);
        
        private EnumCreateEntityType(final String llIlIIlllIII, final int llIlIIllIlll) {
        }
    }
}
