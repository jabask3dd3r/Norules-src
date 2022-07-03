package net.minecraft.world;

import net.minecraft.world.chunk.*;
import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class ChunkCache implements IBlockAccess
{
    protected /* synthetic */ int chunkX;
    protected /* synthetic */ boolean hasExtendedLevels;
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ Chunk[][] chunkArray;
    protected /* synthetic */ int chunkZ;
    
    @Nullable
    public TileEntity getTileEntity(final BlockPos lllllllllllllIlIllIIIIlIllIlIllI, final Chunk.EnumCreateEntityType lllllllllllllIlIllIIIIlIllIlIIII) {
        final int lllllllllllllIlIllIIIIlIllIlIlII = (lllllllllllllIlIllIIIIlIllIlIllI.getX() >> 4) - this.chunkX;
        final int lllllllllllllIlIllIIIIlIllIlIIll = (lllllllllllllIlIllIIIIlIllIlIllI.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[lllllllllllllIlIllIIIIlIllIlIlII][lllllllllllllIlIllIIIIlIllIlIIll].getTileEntity(lllllllllllllIlIllIIIIlIllIlIllI, lllllllllllllIlIllIIIIlIllIlIIII);
    }
    
    @Override
    public int getCombinedLight(final BlockPos lllllllllllllIlIllIIIIlIllIIIIlI, final int lllllllllllllIlIllIIIIlIllIIIllI) {
        final int lllllllllllllIlIllIIIIlIllIIIlIl = this.getLightForExt(EnumSkyBlock.SKY, lllllllllllllIlIllIIIIlIllIIIIlI);
        int lllllllllllllIlIllIIIIlIllIIIlII = this.getLightForExt(EnumSkyBlock.BLOCK, lllllllllllllIlIllIIIIlIllIIIIlI);
        if (lllllllllllllIlIllIIIIlIllIIIlII < lllllllllllllIlIllIIIIlIllIIIllI) {
            lllllllllllllIlIllIIIIlIllIIIlII = lllllllllllllIlIllIIIIlIllIIIllI;
        }
        return lllllllllllllIlIllIIIIlIllIIIlIl << 20 | lllllllllllllIlIllIIIIlIllIIIlII << 4;
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos lllllllllllllIlIllIIIIlIlIllIIll) {
        if (lllllllllllllIlIllIIIIlIlIllIIll.getY() >= 0 && lllllllllllllIlIllIIIIlIlIllIIll.getY() < 256) {
            final int lllllllllllllIlIllIIIIlIlIllIlll = (lllllllllllllIlIllIIIIlIlIllIIll.getX() >> 4) - this.chunkX;
            final int lllllllllllllIlIllIIIIlIlIllIllI = (lllllllllllllIlIllIIIIlIlIllIIll.getZ() >> 4) - this.chunkZ;
            if (lllllllllllllIlIllIIIIlIlIllIlll >= 0 && lllllllllllllIlIllIIIIlIlIllIlll < this.chunkArray.length && lllllllllllllIlIllIIIIlIlIllIllI >= 0 && lllllllllllllIlIllIIIIlIlIllIllI < this.chunkArray[lllllllllllllIlIllIIIIlIlIllIlll].length) {
                final Chunk lllllllllllllIlIllIIIIlIlIllIlIl = this.chunkArray[lllllllllllllIlIllIIIIlIlIllIlll][lllllllllllllIlIllIIIIlIlIllIllI];
                if (lllllllllllllIlIllIIIIlIlIllIlIl != null) {
                    return lllllllllllllIlIllIIIIlIlIllIlIl.getBlockState(lllllllllllllIlIllIIIIlIlIllIIll);
                }
            }
        }
        return Blocks.AIR.getDefaultState();
    }
    
    @Override
    public Biome getBiome(final BlockPos lllllllllllllIlIllIIIIlIlIlIlIlI) {
        final int lllllllllllllIlIllIIIIlIlIlIlIIl = (lllllllllllllIlIllIIIIlIlIlIlIlI.getX() >> 4) - this.chunkX;
        final int lllllllllllllIlIllIIIIlIlIlIlIII = (lllllllllllllIlIllIIIIlIlIlIlIlI.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[lllllllllllllIlIllIIIIlIlIlIlIIl][lllllllllllllIlIllIIIIlIlIlIlIII].getBiome(lllllllllllllIlIllIIIIlIlIlIlIlI, this.worldObj.getBiomeProvider());
    }
    
    @Nullable
    @Override
    public TileEntity getTileEntity(final BlockPos lllllllllllllIlIllIIIIlIllIlllll) {
        return this.getTileEntity(lllllllllllllIlIllIIIIlIllIlllll, Chunk.EnumCreateEntityType.IMMEDIATE);
    }
    
    @Override
    public int getStrongPower(final BlockPos lllllllllllllIlIllIIIIlIIlllIIII, final EnumFacing lllllllllllllIlIllIIIIlIIllIllII) {
        return this.getBlockState(lllllllllllllIlIllIIIIlIIlllIIII).getStrongPower(this, lllllllllllllIlIllIIIIlIIlllIIII, lllllllllllllIlIllIIIIlIIllIllII);
    }
    
    public int getLightFor(final EnumSkyBlock lllllllllllllIlIllIIIIlIIlllllIl, final BlockPos lllllllllllllIlIllIIIIlIIlllllII) {
        if (lllllllllllllIlIllIIIIlIIlllllII.getY() >= 0 && lllllllllllllIlIllIIIIlIIlllllII.getY() < 256) {
            final int lllllllllllllIlIllIIIIlIIllllIll = (lllllllllllllIlIllIIIIlIIlllllII.getX() >> 4) - this.chunkX;
            final int lllllllllllllIlIllIIIIlIIllllIlI = (lllllllllllllIlIllIIIIlIIlllllII.getZ() >> 4) - this.chunkZ;
            return this.chunkArray[lllllllllllllIlIllIIIIlIIllllIll][lllllllllllllIlIllIIIIlIIllllIlI].getLightFor(lllllllllllllIlIllIIIIlIIlllllIl, lllllllllllllIlIllIIIIlIIlllllII);
        }
        return lllllllllllllIlIllIIIIlIIlllllIl.defaultLightValue;
    }
    
    @Override
    public boolean isAirBlock(final BlockPos lllllllllllllIlIllIIIIlIlIIIIlII) {
        return this.getBlockState(lllllllllllllIlIllIIIIlIlIIIIlII).getMaterial() == Material.AIR;
    }
    
    public ChunkCache(final World lllllllllllllIlIllIIIIlIlllIlllI, final BlockPos lllllllllllllIlIllIIIIlIlllIllIl, final BlockPos lllllllllllllIlIllIIIIlIlllllIII, final int lllllllllllllIlIllIIIIlIllllIlll) {
        this.worldObj = lllllllllllllIlIllIIIIlIlllIlllI;
        this.chunkX = lllllllllllllIlIllIIIIlIlllIllIl.getX() - lllllllllllllIlIllIIIIlIllllIlll >> 4;
        this.chunkZ = lllllllllllllIlIllIIIIlIlllIllIl.getZ() - lllllllllllllIlIllIIIIlIllllIlll >> 4;
        final int lllllllllllllIlIllIIIIlIllllIllI = lllllllllllllIlIllIIIIlIlllllIII.getX() + lllllllllllllIlIllIIIIlIllllIlll >> 4;
        final int lllllllllllllIlIllIIIIlIllllIlIl = lllllllllllllIlIllIIIIlIlllllIII.getZ() + lllllllllllllIlIllIIIIlIllllIlll >> 4;
        this.chunkArray = new Chunk[lllllllllllllIlIllIIIIlIllllIllI - this.chunkX + 1][lllllllllllllIlIllIIIIlIllllIlIl - this.chunkZ + 1];
        this.hasExtendedLevels = true;
        for (int lllllllllllllIlIllIIIIlIllllIlII = this.chunkX; lllllllllllllIlIllIIIIlIllllIlII <= lllllllllllllIlIllIIIIlIllllIllI; ++lllllllllllllIlIllIIIIlIllllIlII) {
            for (int lllllllllllllIlIllIIIIlIllllIIll = this.chunkZ; lllllllllllllIlIllIIIIlIllllIIll <= lllllllllllllIlIllIIIIlIllllIlIl; ++lllllllllllllIlIllIIIIlIllllIIll) {
                this.chunkArray[lllllllllllllIlIllIIIIlIllllIlII - this.chunkX][lllllllllllllIlIllIIIIlIllllIIll - this.chunkZ] = lllllllllllllIlIllIIIIlIlllIlllI.getChunkFromChunkCoords(lllllllllllllIlIllIIIIlIllllIlII, lllllllllllllIlIllIIIIlIllllIIll);
            }
        }
        for (int lllllllllllllIlIllIIIIlIllllIIlI = lllllllllllllIlIllIIIIlIlllIllIl.getX() >> 4; lllllllllllllIlIllIIIIlIllllIIlI <= lllllllllllllIlIllIIIIlIlllllIII.getX() >> 4; ++lllllllllllllIlIllIIIIlIllllIIlI) {
            for (int lllllllllllllIlIllIIIIlIllllIIIl = lllllllllllllIlIllIIIIlIlllIllIl.getZ() >> 4; lllllllllllllIlIllIIIIlIllllIIIl <= lllllllllllllIlIllIIIIlIlllllIII.getZ() >> 4; ++lllllllllllllIlIllIIIIlIllllIIIl) {
                final Chunk lllllllllllllIlIllIIIIlIllllIIII = this.chunkArray[lllllllllllllIlIllIIIIlIllllIIlI - this.chunkX][lllllllllllllIlIllIIIIlIllllIIIl - this.chunkZ];
                if (lllllllllllllIlIllIIIIlIllllIIII != null && !lllllllllllllIlIllIIIIlIllllIIII.getAreLevelsEmpty(lllllllllllllIlIllIIIIlIlllIllIl.getY(), lllllllllllllIlIllIIIIlIlllllIII.getY())) {
                    this.hasExtendedLevels = false;
                }
            }
        }
    }
    
    private int getLightForExt(final EnumSkyBlock lllllllllllllIlIllIIIIlIlIIllIIl, final BlockPos lllllllllllllIlIllIIIIlIlIIllIII) {
        if (lllllllllllllIlIllIIIIlIlIIllIIl == EnumSkyBlock.SKY && !this.worldObj.provider.func_191066_m()) {
            return 0;
        }
        if (lllllllllllllIlIllIIIIlIlIIllIII.getY() < 0 || lllllllllllllIlIllIIIIlIlIIllIII.getY() >= 256) {
            return lllllllllllllIlIllIIIIlIlIIllIIl.defaultLightValue;
        }
        if (this.getBlockState(lllllllllllllIlIllIIIIlIlIIllIII).useNeighborBrightness()) {
            int lllllllllllllIlIllIIIIlIlIIlIlll = 0;
            final double lllllllllllllIlIllIIIIlIlIIIlIll;
            final Exception lllllllllllllIlIllIIIIlIlIIIllII = (Exception)((EnumFacing[])(Object)(lllllllllllllIlIllIIIIlIlIIIlIll = (double)(Object)EnumFacing.values())).length;
            for (short lllllllllllllIlIllIIIIlIlIIIllIl = 0; lllllllllllllIlIllIIIIlIlIIIllIl < lllllllllllllIlIllIIIIlIlIIIllII; ++lllllllllllllIlIllIIIIlIlIIIllIl) {
                final EnumFacing lllllllllllllIlIllIIIIlIlIIlIllI = lllllllllllllIlIllIIIIlIlIIIlIll[lllllllllllllIlIllIIIIlIlIIIllIl];
                final int lllllllllllllIlIllIIIIlIlIIlIlIl = this.getLightFor(lllllllllllllIlIllIIIIlIlIIllIIl, lllllllllllllIlIllIIIIlIlIIllIII.offset(lllllllllllllIlIllIIIIlIlIIlIllI));
                if (lllllllllllllIlIllIIIIlIlIIlIlIl > lllllllllllllIlIllIIIIlIlIIlIlll) {
                    lllllllllllllIlIllIIIIlIlIIlIlll = lllllllllllllIlIllIIIIlIlIIlIlIl;
                }
                if (lllllllllllllIlIllIIIIlIlIIlIlll >= 15) {
                    return lllllllllllllIlIllIIIIlIlIIlIlll;
                }
            }
            return lllllllllllllIlIllIIIIlIlIIlIlll;
        }
        final int lllllllllllllIlIllIIIIlIlIIlIlII = (lllllllllllllIlIllIIIIlIlIIllIII.getX() >> 4) - this.chunkX;
        final int lllllllllllllIlIllIIIIlIlIIlIIll = (lllllllllllllIlIllIIIIlIlIIllIII.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[lllllllllllllIlIllIIIIlIlIIlIlII][lllllllllllllIlIllIIIIlIlIIlIIll].getLightFor(lllllllllllllIlIllIIIIlIlIIllIIl, lllllllllllllIlIllIIIIlIlIIllIII);
    }
    
    @Override
    public WorldType getWorldType() {
        return this.worldObj.getWorldType();
    }
    
    public boolean extendedLevelsInChunkCache() {
        return this.hasExtendedLevels;
    }
}
