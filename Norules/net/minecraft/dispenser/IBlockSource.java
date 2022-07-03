package net.minecraft.dispenser;

import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;

public interface IBlockSource extends ILocatableSource
{
    IBlockState getBlockState();
    
     <T extends TileEntity> T getBlockTileEntity();
    
    double getX();
    
    BlockPos getBlockPos();
    
    double getZ();
    
    double getY();
}
