package optifine;

import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.chunk.*;
import java.util.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.*;

public class ChunkCacheOF implements IBlockAccess
{
    private static /* synthetic */ ArrayCache cacheBlockStates;
    private /* synthetic */ int posX;
    private /* synthetic */ IBlockState[] blockStates;
    private /* synthetic */ int posY;
    private /* synthetic */ int posZ;
    private static /* synthetic */ ArrayCache cacheCombinedLights;
    private /* synthetic */ int[] combinedLights;
    private /* synthetic */ ChunkCache chunkCache;
    
    private int getPositionIndex(final BlockPos llllllllllllllIIIlllIIIIllIIlIll) {
        final int llllllllllllllIIIlllIIIIllIIllll = llllllllllllllIIIlllIIIIllIIlIll.getX() - this.posX;
        final int llllllllllllllIIIlllIIIIllIIlllI = llllllllllllllIIIlllIIIIllIIlIll.getY() - this.posY;
        final int llllllllllllllIIIlllIIIIllIIllIl = llllllllllllllIIIlllIIIIllIIlIll.getZ() - this.posZ;
        return llllllllllllllIIIlllIIIIllIIllll * 400 + llllllllllllllIIIlllIIIIllIIllIl * 20 + llllllllllllllIIIlllIIIIllIIlllI;
    }
    
    public boolean isSideSolid(final BlockPos llllllllllllllIIIlllIIIIIllIlIlI, final EnumFacing llllllllllllllIIIlllIIIIIllIlIII, final boolean llllllllllllllIIIlllIIIIIllIIlll) {
        return Reflector.callBoolean(this.chunkCache, Reflector.ForgeChunkCache_isSideSolid, llllllllllllllIIIlllIIIIIllIlIlI, llllllllllllllIIIlllIIIIIllIlIII, llllllllllllllIIIlllIIIIIllIIlll);
    }
    
    public boolean isEmpty() {
        return this.chunkCache.extendedLevelsInChunkCache();
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos llllllllllllllIIIlllIIIIlllIlIlI) {
        if (this.blockStates == null) {
            return this.chunkCache.getBlockState(llllllllllllllIIIlllIIIIlllIlIlI);
        }
        final int llllllllllllllIIIlllIIIIlllIlIIl = this.getPositionIndex(llllllllllllllIIIlllIIIIlllIlIlI);
        if (llllllllllllllIIIlllIIIIlllIlIIl >= 0 && llllllllllllllIIIlllIIIIlllIlIIl < this.blockStates.length) {
            IBlockState llllllllllllllIIIlllIIIIlllIlIII = this.blockStates[llllllllllllllIIIlllIIIIlllIlIIl];
            if (llllllllllllllIIIlllIIIIlllIlIII == null) {
                llllllllllllllIIIlllIIIIlllIlIII = this.chunkCache.getBlockState(llllllllllllllIIIlllIIIIlllIlIlI);
                this.blockStates[llllllllllllllIIIlllIIIIlllIlIIl] = llllllllllllllIIIlllIIIIlllIlIII;
            }
            return llllllllllllllIIIlllIIIIlllIlIII;
        }
        return this.chunkCache.getBlockState(llllllllllllllIIIlllIIIIlllIlIlI);
    }
    
    @Override
    public boolean isAirBlock(final BlockPos llllllllllllllIIIlllIIIIIlllIlII) {
        return this.chunkCache.isAirBlock(llllllllllllllIIIlllIIIIIlllIlII);
    }
    
    public ChunkCacheOF(final ChunkCache llllllllllllllIIIlllIIIlIIIlllIl, final BlockPos llllllllllllllIIIlllIIIlIIIllIII, final int llllllllllllllIIIlllIIIlIIIlIlll) {
        this.chunkCache = llllllllllllllIIIlllIIIlIIIlllIl;
        this.posX = llllllllllllllIIIlllIIIlIIIllIII.getX() - llllllllllllllIIIlllIIIlIIIlIlll;
        this.posY = llllllllllllllIIIlllIIIlIIIllIII.getY() - llllllllllllllIIIlllIIIlIIIlIlll;
        this.posZ = llllllllllllllIIIlllIIIlIIIllIII.getZ() - llllllllllllllIIIlllIIIlIIIlIlll;
    }
    
    @Override
    public TileEntity getTileEntity(final BlockPos llllllllllllllIIIlllIIIIlIIllIIl) {
        return this.chunkCache.getTileEntity(llllllllllllllIIIlllIIIIlIIllIIl, Chunk.EnumCreateEntityType.CHECK);
    }
    
    public TileEntity getTileEntity(final BlockPos llllllllllllllIIIlllIIIIlIIIlIll, final Chunk.EnumCreateEntityType llllllllllllllIIIlllIIIIlIIIlIIl) {
        return this.chunkCache.getTileEntity(llllllllllllllIIIlllIIIIlIIIlIll, llllllllllllllIIIlllIIIIlIIIlIIl);
    }
    
    public void renderFinish() {
        ChunkCacheOF.cacheCombinedLights.free(this.combinedLights);
        this.combinedLights = null;
        ChunkCacheOF.cacheBlockStates.free(this.blockStates);
        this.blockStates = null;
    }
    
    public void renderStart() {
        if (this.combinedLights == null) {
            this.combinedLights = (int[])ChunkCacheOF.cacheCombinedLights.allocate(8000);
        }
        Arrays.fill(this.combinedLights, -1);
        if (this.blockStates == null) {
            this.blockStates = (IBlockState[])ChunkCacheOF.cacheBlockStates.allocate(8000);
        }
        Arrays.fill(this.blockStates, null);
    }
    
    @Override
    public Biome getBiome(final BlockPos llllllllllllllIIIlllIIIIlIllIIIl) {
        return this.chunkCache.getBiome(llllllllllllllIIIlllIIIIlIllIIIl);
    }
    
    @Override
    public int getStrongPower(final BlockPos llllllllllllllIIIlllIIIIlIlIIlIl, final EnumFacing llllllllllllllIIIlllIIIIlIlIIlll) {
        return this.chunkCache.getStrongPower(llllllllllllllIIIlllIIIIlIlIIlIl, llllllllllllllIIIlllIIIIlIlIIlll);
    }
    
    static {
        ARRAY_SIZE = 8000;
        ChunkCacheOF.cacheCombinedLights = new ArrayCache(Integer.TYPE, 16);
        ChunkCacheOF.cacheBlockStates = new ArrayCache(IBlockState.class, 16);
    }
    
    @Override
    public int getCombinedLight(final BlockPos llllllllllllllIIIlllIIIlIIIIIlIl, final int llllllllllllllIIIlllIIIIllllIlll) {
        if (this.combinedLights == null) {
            int llllllllllllllIIIlllIIIlIIIIIIIl = this.chunkCache.getCombinedLight(llllllllllllllIIIlllIIIlIIIIIlIl, llllllllllllllIIIlllIIIIllllIlll);
            if (Config.isDynamicLights() && !this.getBlockState(llllllllllllllIIIlllIIIlIIIIIlIl).isOpaqueCube()) {
                llllllllllllllIIIlllIIIlIIIIIIIl = DynamicLights.getCombinedLight(llllllllllllllIIIlllIIIlIIIIIlIl, llllllllllllllIIIlllIIIlIIIIIIIl);
            }
            return llllllllllllllIIIlllIIIlIIIIIIIl;
        }
        final int llllllllllllllIIIlllIIIIllllllll = this.getPositionIndex(llllllllllllllIIIlllIIIlIIIIIlIl);
        if (llllllllllllllIIIlllIIIIllllllll >= 0 && llllllllllllllIIIlllIIIIllllllll < this.combinedLights.length) {
            int llllllllllllllIIIlllIIIIllllllIl = this.combinedLights[llllllllllllllIIIlllIIIIllllllll];
            if (llllllllllllllIIIlllIIIIllllllIl == -1) {
                llllllllllllllIIIlllIIIIllllllIl = this.chunkCache.getCombinedLight(llllllllllllllIIIlllIIIlIIIIIlIl, llllllllllllllIIIlllIIIIllllIlll);
                if (Config.isDynamicLights() && !this.getBlockState(llllllllllllllIIIlllIIIlIIIIIlIl).isOpaqueCube()) {
                    llllllllllllllIIIlllIIIIllllllIl = DynamicLights.getCombinedLight(llllllllllllllIIIlllIIIlIIIIIlIl, llllllllllllllIIIlllIIIIllllllIl);
                }
                this.combinedLights[llllllllllllllIIIlllIIIIllllllll] = llllllllllllllIIIlllIIIIllllllIl;
            }
            return llllllllllllllIIIlllIIIIllllllIl;
        }
        return this.chunkCache.getCombinedLight(llllllllllllllIIIlllIIIlIIIIIlIl, llllllllllllllIIIlllIIIIllllIlll);
    }
    
    @Override
    public WorldType getWorldType() {
        return this.chunkCache.getWorldType();
    }
}
