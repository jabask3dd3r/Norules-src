package net.minecraft.block;

import net.minecraft.world.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public abstract class BlockBasePressurePlate extends Block
{
    protected static final /* synthetic */ AxisAlignedBB UNPRESSED_AABB;
    protected static final /* synthetic */ AxisAlignedBB PRESSED_AABB;
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllllllllllIIIIIllIIII, final BlockPos lllllllllllllllllllllIIIIIlIllll) {
        return true;
    }
    
    private boolean canBePlacedOn(final World lllllllllllllllllllllIIIIIIlIIIl, final BlockPos lllllllllllllllllllllIIIIIIlIIII) {
        return lllllllllllllllllllllIIIIIIlIIIl.getBlockState(lllllllllllllllllllllIIIIIIlIIII).isFullyOpaque() || lllllllllllllllllllllIIIIIIlIIIl.getBlockState(lllllllllllllllllllllIIIIIIlIIII).getBlock() instanceof BlockFence;
    }
    
    protected BlockBasePressurePlate(final Material lllllllllllllllllllllIIIIlIlIIII) {
        this(lllllllllllllllllllllIIIIlIlIIII, lllllllllllllllllllllIIIIlIlIIII.getMaterialMapColor());
    }
    
    @Override
    public void breakBlock(final World llllllllllllllllllllIlllllIIllIl, final BlockPos llllllllllllllllllllIlllllIIlIII, final IBlockState llllllllllllllllllllIlllllIIlIll) {
        if (this.getRedstoneStrength(llllllllllllllllllllIlllllIIlIll) > 0) {
            this.updateNeighbors(llllllllllllllllllllIlllllIIllIl, llllllllllllllllllllIlllllIIlIII);
        }
        super.breakBlock(llllllllllllllllllllIlllllIIllIl, llllllllllllllllllllIlllllIIlIII, llllllllllllllllllllIlllllIIlIll);
    }
    
    static {
        PRESSED_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.03125, 0.9375);
        UNPRESSED_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.0625, 0.9375);
        PRESSURE_AABB = new AxisAlignedBB(0.125, 0.0, 0.125, 0.875, 0.25, 0.875);
    }
    
    protected void updateNeighbors(final World llllllllllllllllllllIlllllIIIIlI, final BlockPos llllllllllllllllllllIlllllIIIIIl) {
        llllllllllllllllllllIlllllIIIIlI.notifyNeighborsOfStateChange(llllllllllllllllllllIlllllIIIIIl, this, false);
        llllllllllllllllllllIlllllIIIIlI.notifyNeighborsOfStateChange(llllllllllllllllllllIlllllIIIIIl.down(), this, false);
    }
    
    @Override
    public void randomTick(final World lllllllllllllllllllllIIIIIIIlllI, final BlockPos lllllllllllllllllllllIIIIIIIllIl, final IBlockState lllllllllllllllllllllIIIIIIIllII, final Random lllllllllllllllllllllIIIIIIIlIll) {
    }
    
    @Override
    public boolean canProvidePower(final IBlockState llllllllllllllllllllIllllIlIlIII) {
        return true;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllllllllllIIIIIlllIII, final IBlockAccess lllllllllllllllllllllIIIIIllIlll, final BlockPos lllllllllllllllllllllIIIIIllIllI) {
        return BlockBasePressurePlate.NULL_AABB;
    }
    
    @Override
    public int tickRate(final World lllllllllllllllllllllIIIIIlllIlI) {
        return 20;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllllllllIIIIIIlllll, final World lllllllllllllllllllllIIIIIIllIII, final BlockPos lllllllllllllllllllllIIIIIIlIlll, final Block lllllllllllllllllllllIIIIIIlllII, final BlockPos lllllllllllllllllllllIIIIIIllIll) {
        if (!this.canBePlacedOn(lllllllllllllllllllllIIIIIIllIII, lllllllllllllllllllllIIIIIIlIlll.down())) {
            this.dropBlockAsItem(lllllllllllllllllllllIIIIIIllIII, lllllllllllllllllllllIIIIIIlIlll, lllllllllllllllllllllIIIIIIlllll, 0);
            lllllllllllllllllllllIIIIIIllIII.setBlockToAir(lllllllllllllllllllllIIIIIIlIlll);
        }
    }
    
    @Override
    public boolean canSpawnInBlock() {
        return true;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllllllllIIIIIllIIlI) {
        return false;
    }
    
    protected BlockBasePressurePlate(final Material lllllllllllllllllllllIIIIlIIlIII, final MapColor lllllllllllllllllllllIIIIlIIlIlI) {
        super(lllllllllllllllllllllIIIIlIIlIII, lllllllllllllllllllllIIIIlIIlIlI);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setTickRandomly(true);
    }
    
    protected abstract int getRedstoneStrength(final IBlockState p0);
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState llllllllllllllllllllIllllIlIIllI) {
        return EnumPushReaction.DESTROY;
    }
    
    protected abstract int computeRedstoneStrength(final World p0, final BlockPos p1);
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllllllllIIIIIllIlII) {
        return false;
    }
    
    @Override
    public int getStrongPower(final IBlockState llllllllllllllllllllIllllIlIlIll, final IBlockAccess llllllllllllllllllllIllllIlIllll, final BlockPos llllllllllllllllllllIllllIlIlllI, final EnumFacing llllllllllllllllllllIllllIlIllIl) {
        return (llllllllllllllllllllIllllIlIllIl == EnumFacing.UP) ? this.getRedstoneStrength(llllllllllllllllllllIllllIlIlIll) : 0;
    }
    
    @Override
    public void updateTick(final World lllllllllllllllllllllIIIIIIIIlII, final BlockPos lllllllllllllllllllllIIIIIIIIIll, final IBlockState lllllllllllllllllllllIIIIIIIIIlI, final Random lllllllllllllllllllllIIIIIIIIIIl) {
        if (!lllllllllllllllllllllIIIIIIIIlII.isRemote) {
            final int lllllllllllllllllllllIIIIIIIIIII = this.getRedstoneStrength(lllllllllllllllllllllIIIIIIIIIlI);
            if (lllllllllllllllllllllIIIIIIIIIII > 0) {
                this.updateState(lllllllllllllllllllllIIIIIIIIlII, lllllllllllllllllllllIIIIIIIIIll, lllllllllllllllllllllIIIIIIIIIlI, lllllllllllllllllllllIIIIIIIIIII);
            }
        }
    }
    
    protected abstract void playClickOnSound(final World p0, final BlockPos p1);
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllllllllIllllIlIIlII, final IBlockState llllllllllllllllllllIllllIlIIIll, final BlockPos llllllllllllllllllllIllllIlIIIlI, final EnumFacing llllllllllllllllllllIllllIlIIIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllllllllllIllllllIlllI, final BlockPos llllllllllllllllllllIlllllllIIll, final IBlockState llllllllllllllllllllIllllllIllII, final Entity llllllllllllllllllllIlllllllIIIl) {
        if (!llllllllllllllllllllIllllllIlllI.isRemote) {
            final int llllllllllllllllllllIlllllllIIII = this.getRedstoneStrength(llllllllllllllllllllIllllllIllII);
            if (llllllllllllllllllllIlllllllIIII == 0) {
                this.updateState(llllllllllllllllllllIllllllIlllI, llllllllllllllllllllIlllllllIIll, llllllllllllllllllllIllllllIllII, llllllllllllllllllllIlllllllIIII);
            }
        }
    }
    
    protected abstract IBlockState setRedstoneStrength(final IBlockState p0, final int p1);
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllllllllIIIIlIIIIlI, final IBlockAccess lllllllllllllllllllllIIIIlIIIIIl, final BlockPos lllllllllllllllllllllIIIIlIIIIII) {
        final boolean lllllllllllllllllllllIIIIIllllll = this.getRedstoneStrength(lllllllllllllllllllllIIIIlIIIIlI) > 0;
        return lllllllllllllllllllllIIIIIllllll ? BlockBasePressurePlate.PRESSED_AABB : BlockBasePressurePlate.UNPRESSED_AABB;
    }
    
    protected abstract void playClickOffSound(final World p0, final BlockPos p1);
    
    protected void updateState(final World llllllllllllllllllllIllllllIIIIl, final BlockPos llllllllllllllllllllIlllllIllIII, IBlockState llllllllllllllllllllIlllllIlIlll, final int llllllllllllllllllllIlllllIllllI) {
        final int llllllllllllllllllllIlllllIlllIl = this.computeRedstoneStrength(llllllllllllllllllllIllllllIIIIl, llllllllllllllllllllIlllllIllIII);
        final boolean llllllllllllllllllllIlllllIlllII = llllllllllllllllllllIlllllIllllI > 0;
        final boolean llllllllllllllllllllIlllllIllIll = llllllllllllllllllllIlllllIlllIl > 0;
        if (llllllllllllllllllllIlllllIllllI != llllllllllllllllllllIlllllIlllIl) {
            llllllllllllllllllllIlllllIlIlll = (long)this.setRedstoneStrength((IBlockState)llllllllllllllllllllIlllllIlIlll, llllllllllllllllllllIlllllIlllIl);
            llllllllllllllllllllIllllllIIIIl.setBlockState(llllllllllllllllllllIlllllIllIII, (IBlockState)llllllllllllllllllllIlllllIlIlll, 2);
            this.updateNeighbors(llllllllllllllllllllIllllllIIIIl, llllllllllllllllllllIlllllIllIII);
            llllllllllllllllllllIllllllIIIIl.markBlockRangeForRenderUpdate(llllllllllllllllllllIlllllIllIII, llllllllllllllllllllIlllllIllIII);
        }
        if (!llllllllllllllllllllIlllllIllIll && llllllllllllllllllllIlllllIlllII) {
            this.playClickOffSound(llllllllllllllllllllIllllllIIIIl, llllllllllllllllllllIlllllIllIII);
        }
        else if (llllllllllllllllllllIlllllIllIll && !llllllllllllllllllllIlllllIlllII) {
            this.playClickOnSound(llllllllllllllllllllIllllllIIIIl, llllllllllllllllllllIlllllIllIII);
        }
        if (llllllllllllllllllllIlllllIllIll) {
            llllllllllllllllllllIllllllIIIIl.scheduleUpdate(new BlockPos(llllllllllllllllllllIlllllIllIII), this, this.tickRate(llllllllllllllllllllIllllllIIIIl));
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllllllllIIIIIlIIllI, final BlockPos lllllllllllllllllllllIIIIIlIlIII) {
        return this.canBePlacedOn(lllllllllllllllllllllIIIIIlIIllI, lllllllllllllllllllllIIIIIlIlIII.down());
    }
    
    @Override
    public int getWeakPower(final IBlockState llllllllllllllllllllIllllIllIlIl, final IBlockAccess llllllllllllllllllllIllllIlllIIl, final BlockPos llllllllllllllllllllIllllIlllIII, final EnumFacing llllllllllllllllllllIllllIllIlll) {
        return this.getRedstoneStrength(llllllllllllllllllllIllllIllIlIl);
    }
}
