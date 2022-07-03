package net.minecraft.world;

import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.world.biome.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public interface IBlockAccess
{
    int getCombinedLight(final BlockPos p0, final int p1);
    
    @Nullable
    TileEntity getTileEntity(final BlockPos p0);
    
    boolean isAirBlock(final BlockPos p0);
    
    WorldType getWorldType();
    
    Biome getBiome(final BlockPos p0);
    
    IBlockState getBlockState(final BlockPos p0);
    
    int getStrongPower(final BlockPos p0, final EnumFacing p1);
}
