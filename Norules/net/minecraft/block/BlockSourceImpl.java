package net.minecraft.block;

import net.minecraft.dispenser.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;

public class BlockSourceImpl implements IBlockSource
{
    private final /* synthetic */ BlockPos pos;
    private final /* synthetic */ World worldObj;
    
    @Override
    public double getZ() {
        return this.pos.getZ() + 0.5;
    }
    
    @Override
    public <T extends TileEntity> T getBlockTileEntity() {
        return (T)this.worldObj.getTileEntity(this.pos);
    }
    
    public BlockSourceImpl(final World lllllllllllllIlIllIlIllIIllIlIll, final BlockPos lllllllllllllIlIllIlIllIIllIllIl) {
        this.worldObj = lllllllllllllIlIllIlIllIIllIlIll;
        this.pos = lllllllllllllIlIllIlIllIIllIllIl;
    }
    
    @Override
    public double getX() {
        return this.pos.getX() + 0.5;
    }
    
    @Override
    public BlockPos getBlockPos() {
        return this.pos;
    }
    
    @Override
    public World getWorld() {
        return this.worldObj;
    }
    
    @Override
    public IBlockState getBlockState() {
        return this.worldObj.getBlockState(this.pos);
    }
    
    @Override
    public double getY() {
        return this.pos.getY() + 0.5;
    }
}
