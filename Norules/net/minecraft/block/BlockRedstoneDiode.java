package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public abstract class BlockRedstoneDiode extends BlockHorizontal
{
    protected static final /* synthetic */ AxisAlignedBB REDSTONE_DIODE_AABB;
    protected final /* synthetic */ boolean isRepeaterPowered;
    
    public boolean isFacingTowardsRepeater(final World lllllllllllllllIlIlIlIIIlIIllIII, final BlockPos lllllllllllllllIlIlIlIIIlIIlIIlI, final IBlockState lllllllllllllllIlIlIlIIIlIIlIllI) {
        final EnumFacing lllllllllllllllIlIlIlIIIlIIlIlIl = lllllllllllllllIlIlIlIIIlIIlIllI.getValue((IProperty<EnumFacing>)BlockRedstoneDiode.FACING).getOpposite();
        final BlockPos lllllllllllllllIlIlIlIIIlIIlIlII = lllllllllllllllIlIlIlIIIlIIlIIlI.offset(lllllllllllllllIlIlIlIIIlIIlIlIl);
        return isDiode(lllllllllllllllIlIlIlIIIlIIllIII.getBlockState(lllllllllllllllIlIlIlIIIlIIlIlII)) && lllllllllllllllIlIlIlIIIlIIllIII.getBlockState(lllllllllllllllIlIlIlIIIlIIlIlII).getValue((IProperty<Comparable>)BlockRedstoneDiode.FACING) != lllllllllllllllIlIlIlIIIlIIlIlIl;
    }
    
    protected abstract IBlockState getPoweredState(final IBlockState p0);
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllllIlIlIlIIllIIlIIIl, final IBlockAccess lllllllllllllllIlIlIlIIllIIlIIII, final BlockPos lllllllllllllllIlIlIlIIllIIIllll, final EnumFacing lllllllllllllllIlIlIlIIllIIIlIlI) {
        return lllllllllllllllIlIlIlIIllIIlIIIl.getWeakPower(lllllllllllllllIlIlIlIIllIIlIIII, lllllllllllllllIlIlIlIIllIIIllll, lllllllllllllllIlIlIlIIllIIIlIlI);
    }
    
    protected boolean shouldBePowered(final World lllllllllllllllIlIlIlIIlIlIIlIII, final BlockPos lllllllllllllllIlIlIlIIlIlIIIlll, final IBlockState lllllllllllllllIlIlIlIIlIlIIIIlI) {
        return this.calculateInputStrength(lllllllllllllllIlIlIlIIlIlIIlIII, lllllllllllllllIlIlIlIIlIlIIIlll, lllllllllllllllIlIlIlIIlIlIIIIlI) > 0;
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllllIlIlIlIIlIllllllI, final IBlockAccess lllllllllllllllIlIlIlIIlIlllllIl, final BlockPos lllllllllllllllIlIlIlIIlIlllllII, final EnumFacing lllllllllllllllIlIlIlIIllIIIIIII) {
        if (!this.isPowered(lllllllllllllllIlIlIlIIlIllllllI)) {
            return 0;
        }
        return (lllllllllllllllIlIlIlIIlIllllllI.getValue((IProperty<Comparable>)BlockRedstoneDiode.FACING) == lllllllllllllllIlIlIlIIllIIIIIII) ? this.getActiveSignal(lllllllllllllllIlIlIlIIlIlllllIl, lllllllllllllllIlIlIlIIlIlllllII, lllllllllllllllIlIlIlIIlIllllllI) : 0;
    }
    
    protected int getTickDelay(final IBlockState lllllllllllllllIlIlIlIIIlIIIlIIl) {
        return this.getDelay(lllllllllllllllIlIlIlIIIlIIIlIIl);
    }
    
    protected BlockRedstoneDiode(final boolean lllllllllllllllIlIlIlIIlllIIllIl) {
        super(Material.CIRCUITS);
        this.isRepeaterPowered = lllllllllllllllIlIlIlIIlllIIllIl;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllllIlIlIlIIllIIlllll, final IBlockAccess lllllllllllllllIlIlIlIIllIIllllI, final BlockPos lllllllllllllllIlIlIlIIllIIlllIl, final EnumFacing lllllllllllllllIlIlIlIIllIIllIll) {
        return lllllllllllllllIlIlIlIIllIIllIll.getAxis() != EnumFacing.Axis.Y;
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World lllllllllllllllIlIlIlIIIlIlllIll, final BlockPos lllllllllllllllIlIlIlIIIlIlllIlI, final IBlockState lllllllllllllllIlIlIlIIIlIlllllI) {
        if (this.isRepeaterPowered) {
            int lllllllllllllllIlIlIlIIIlIllIlIl;
            for (char lllllllllllllllIlIlIlIIIlIllIllI = (char)((EnumFacing[])(Object)(lllllllllllllllIlIlIlIIIlIllIlIl = (int)(Object)EnumFacing.values())).length, lllllllllllllllIlIlIlIIIlIllIlll = '\0'; lllllllllllllllIlIlIlIIIlIllIlll < lllllllllllllllIlIlIlIIIlIllIllI; ++lllllllllllllllIlIlIlIIIlIllIlll) {
                final EnumFacing lllllllllllllllIlIlIlIIIlIllllIl = lllllllllllllllIlIlIlIIIlIllIlIl[lllllllllllllllIlIlIlIIIlIllIlll];
                lllllllllllllllIlIlIlIIIlIlllIll.notifyNeighborsOfStateChange(lllllllllllllllIlIlIlIIIlIlllIlI.offset(lllllllllllllllIlIlIlIIIlIllllIl), this, false);
            }
        }
        super.onBlockDestroyedByPlayer(lllllllllllllllIlIlIlIIIlIlllIll, lllllllllllllllIlIlIlIIIlIlllIlI, lllllllllllllllIlIlIlIIIlIlllllI);
    }
    
    protected abstract IBlockState getUnpoweredState(final IBlockState p0);
    
    @Override
    public void updateTick(final World lllllllllllllllIlIlIlIIllIlIlIll, final BlockPos lllllllllllllllIlIlIlIIllIlIIlII, final IBlockState lllllllllllllllIlIlIlIIllIlIIIll, final Random lllllllllllllllIlIlIlIIllIlIlIII) {
        if (!this.isLocked(lllllllllllllllIlIlIlIIllIlIlIll, lllllllllllllllIlIlIlIIllIlIIlII, lllllllllllllllIlIlIlIIllIlIIIll)) {
            final boolean lllllllllllllllIlIlIlIIllIlIIlll = this.shouldBePowered(lllllllllllllllIlIlIlIIllIlIlIll, lllllllllllllllIlIlIlIIllIlIIlII, lllllllllllllllIlIlIlIIllIlIIIll);
            if (this.isRepeaterPowered && !lllllllllllllllIlIlIlIIllIlIIlll) {
                lllllllllllllllIlIlIlIIllIlIlIll.setBlockState(lllllllllllllllIlIlIlIIllIlIIlII, this.getUnpoweredState(lllllllllllllllIlIlIlIIllIlIIIll), 2);
            }
            else if (!this.isRepeaterPowered) {
                lllllllllllllllIlIlIlIIllIlIlIll.setBlockState(lllllllllllllllIlIlIlIIllIlIIlII, this.getPoweredState(lllllllllllllllIlIlIlIIllIlIIIll), 2);
                if (!lllllllllllllllIlIlIlIIllIlIIlll) {
                    lllllllllllllllIlIlIlIIllIlIlIll.updateBlockTick(lllllllllllllllIlIlIlIIllIlIIlII, this.getPoweredState(lllllllllllllllIlIlIlIIllIlIIIll).getBlock(), this.getTickDelay(lllllllllllllllIlIlIlIIllIlIIIll), -1);
                }
            }
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIlIlIlIIIIlllllll, final IBlockState lllllllllllllllIlIlIlIIIIllllllI, final BlockPos lllllllllllllllIlIlIlIIIIlllllIl, final EnumFacing lllllllllllllllIlIlIlIIIIllllIll) {
        return (lllllllllllllllIlIlIlIIIIllllIll == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    protected int calculateInputStrength(final World lllllllllllllllIlIlIlIIlIIlllIIl, final BlockPos lllllllllllllllIlIlIlIIlIIllIIIl, final IBlockState lllllllllllllllIlIlIlIIlIIllIlll) {
        final EnumFacing lllllllllllllllIlIlIlIIlIIllIllI = lllllllllllllllIlIlIlIIlIIllIlll.getValue((IProperty<EnumFacing>)BlockRedstoneDiode.FACING);
        final BlockPos lllllllllllllllIlIlIlIIlIIllIlIl = lllllllllllllllIlIlIlIIlIIllIIIl.offset(lllllllllllllllIlIlIlIIlIIllIllI);
        final int lllllllllllllllIlIlIlIIlIIllIlII = lllllllllllllllIlIlIlIIlIIlllIIl.getRedstonePower(lllllllllllllllIlIlIlIIlIIllIlIl, lllllllllllllllIlIlIlIIlIIllIllI);
        if (lllllllllllllllIlIlIlIIlIIllIlII >= 15) {
            return lllllllllllllllIlIlIlIIlIIllIlII;
        }
        final IBlockState lllllllllllllllIlIlIlIIlIIllIIll = lllllllllllllllIlIlIlIIlIIlllIIl.getBlockState(lllllllllllllllIlIlIlIIlIIllIlIl);
        return Math.max(lllllllllllllllIlIlIlIIlIIllIlII, (lllllllllllllllIlIlIlIIlIIllIIll.getBlock() == Blocks.REDSTONE_WIRE) ? ((int)lllllllllllllllIlIlIlIIlIIllIIll.getValue((IProperty<Integer>)BlockRedstoneWire.POWER)) : 0);
    }
    
    @Override
    public boolean isAssociatedBlock(final Block lllllllllllllllIlIlIlIIIlIIIIlIl) {
        return this.isSameDiode(lllllllllllllllIlIlIlIIIlIIIIlIl.getDefaultState());
    }
    
    protected boolean isAlternateInput(final IBlockState lllllllllllllllIlIlIlIIIlIllIIII) {
        return lllllllllllllllIlIlIlIIIlIllIIII.canProvidePower();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIlIlIlIIlllIIlIll, final IBlockAccess lllllllllllllllIlIlIlIIlllIIlIlI, final BlockPos lllllllllllllllIlIlIlIIlllIIlIIl) {
        return BlockRedstoneDiode.REDSTONE_DIODE_AABB;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllIlIlIlIIIllllllll, final BlockPos lllllllllllllllIlIlIlIIIlllllllI, final EnumFacing lllllllllllllllIlIlIlIIIllllllIl, final float lllllllllllllllIlIlIlIIIllllllII, final float lllllllllllllllIlIlIlIIIlllllIll, final float lllllllllllllllIlIlIlIIIlllllIlI, final int lllllllllllllllIlIlIlIIIlllllIIl, final EntityLivingBase lllllllllllllllIlIlIlIIIlllllIII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneDiode.FACING, lllllllllllllllIlIlIlIIIlllllIII.getHorizontalFacing().getOpposite());
    }
    
    static {
        REDSTONE_DIODE_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    protected int getPowerOnSide(final IBlockAccess lllllllllllllllIlIlIlIIlIIIIlIIl, final BlockPos lllllllllllllllIlIlIlIIlIIIIlllI, final EnumFacing lllllllllllllllIlIlIlIIlIIIIIlll) {
        final IBlockState lllllllllllllllIlIlIlIIlIIIIllII = lllllllllllllllIlIlIlIIlIIIIlIIl.getBlockState(lllllllllllllllIlIlIlIIlIIIIlllI);
        final Block lllllllllllllllIlIlIlIIlIIIIlIll = lllllllllllllllIlIlIlIIlIIIIllII.getBlock();
        if (!this.isAlternateInput(lllllllllllllllIlIlIlIIlIIIIllII)) {
            return 0;
        }
        if (lllllllllllllllIlIlIlIIlIIIIlIll == Blocks.REDSTONE_BLOCK) {
            return 15;
        }
        return (lllllllllllllllIlIlIlIIlIIIIlIll == Blocks.REDSTONE_WIRE) ? lllllllllllllllIlIlIlIIlIIIIllII.getValue((IProperty<Integer>)BlockRedstoneWire.POWER) : lllllllllllllllIlIlIlIIlIIIIlIIl.getStrongPower(lllllllllllllllIlIlIlIIlIIIIlllI, lllllllllllllllIlIlIlIIlIIIIIlll);
    }
    
    public boolean canBlockStay(final World lllllllllllllllIlIlIlIIllIlllIII, final BlockPos lllllllllllllllIlIlIlIIllIllIlll) {
        return lllllllllllllllIlIlIlIIllIlllIII.getBlockState(lllllllllllllllIlIlIlIIllIllIlll.down()).isFullyOpaque();
    }
    
    public boolean isSameDiode(final IBlockState lllllllllllllllIlIlIlIIIlIlIIIll) {
        final Block lllllllllllllllIlIlIlIIIlIlIIIlI = lllllllllllllllIlIlIlIIIlIlIIIll.getBlock();
        return lllllllllllllllIlIlIlIIIlIlIIIlI == this.getPoweredState(this.getDefaultState()).getBlock() || lllllllllllllllIlIlIlIIIlIlIIIlI == this.getUnpoweredState(this.getDefaultState()).getBlock();
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIlIlIlIIlllIIIlll) {
        return false;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllIlIlIlIIIlllIIIlI, final BlockPos lllllllllllllllIlIlIlIIIlllIIIIl, final IBlockState lllllllllllllllIlIlIlIIIlllIIIII) {
        this.notifyNeighbors(lllllllllllllllIlIlIlIIIlllIIIlI, lllllllllllllllIlIlIlIIIlllIIIIl, lllllllllllllllIlIlIlIIIlllIIIII);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIlIlIlIIllIllllll, final BlockPos lllllllllllllllIlIlIlIIlllIIIIIl) {
        return lllllllllllllllIlIlIlIIllIllllll.getBlockState(lllllllllllllllIlIlIlIIlllIIIIIl.down()).isFullyOpaque() && super.canPlaceBlockAt(lllllllllllllllIlIlIlIIllIllllll, lllllllllllllllIlIlIlIIlllIIIIIl);
    }
    
    protected void updateState(final World lllllllllllllllIlIlIlIIlIlIlllII, final BlockPos lllllllllllllllIlIlIlIIlIlIllIll, final IBlockState lllllllllllllllIlIlIlIIlIlIlIlII) {
        if (!this.isLocked(lllllllllllllllIlIlIlIIlIlIlllII, lllllllllllllllIlIlIlIIlIlIllIll, lllllllllllllllIlIlIlIIlIlIlIlII)) {
            final boolean lllllllllllllllIlIlIlIIlIlIllIIl = this.shouldBePowered(lllllllllllllllIlIlIlIIlIlIlllII, lllllllllllllllIlIlIlIIlIlIllIll, lllllllllllllllIlIlIlIIlIlIlIlII);
            if (this.isRepeaterPowered != lllllllllllllllIlIlIlIIlIlIllIIl && !lllllllllllllllIlIlIlIIlIlIlllII.isBlockTickPending(lllllllllllllllIlIlIlIIlIlIllIll, this)) {
                int lllllllllllllllIlIlIlIIlIlIllIII = -1;
                if (this.isFacingTowardsRepeater(lllllllllllllllIlIlIlIIlIlIlllII, lllllllllllllllIlIlIlIIlIlIllIll, lllllllllllllllIlIlIlIIlIlIlIlII)) {
                    lllllllllllllllIlIlIlIIlIlIllIII = -3;
                }
                else if (this.isRepeaterPowered) {
                    lllllllllllllllIlIlIlIIlIlIllIII = -2;
                }
                lllllllllllllllIlIlIlIIlIlIlllII.updateBlockTick(lllllllllllllllIlIlIlIIlIlIllIll, this, this.getDelay(lllllllllllllllIlIlIlIIlIlIlIlII), lllllllllllllllIlIlIlIIlIlIllIII);
            }
        }
    }
    
    public static boolean isDiode(final IBlockState lllllllllllllllIlIlIlIIIlIlIlIIl) {
        return Blocks.UNPOWERED_REPEATER.isSameDiode(lllllllllllllllIlIlIlIIIlIlIlIIl) || Blocks.UNPOWERED_COMPARATOR.isSameDiode(lllllllllllllllIlIlIlIIIlIlIlIIl);
    }
    
    protected void notifyNeighbors(final World lllllllllllllllIlIlIlIIIllIIlllI, final BlockPos lllllllllllllllIlIlIlIIIllIlIIll, final IBlockState lllllllllllllllIlIlIlIIIllIlIIlI) {
        final EnumFacing lllllllllllllllIlIlIlIIIllIlIIIl = lllllllllllllllIlIlIlIIIllIlIIlI.getValue((IProperty<EnumFacing>)BlockRedstoneDiode.FACING);
        final BlockPos lllllllllllllllIlIlIlIIIllIlIIII = lllllllllllllllIlIlIlIIIllIlIIll.offset(lllllllllllllllIlIlIlIIIllIlIIIl.getOpposite());
        lllllllllllllllIlIlIlIIIllIIlllI.func_190524_a(lllllllllllllllIlIlIlIIIllIlIIII, this, lllllllllllllllIlIlIlIIIllIlIIll);
        lllllllllllllllIlIlIlIIIllIIlllI.notifyNeighborsOfStateExcept(lllllllllllllllIlIlIlIIIllIlIIII, this, lllllllllllllllIlIlIlIIIllIlIIIl);
    }
    
    @Override
    public void randomTick(final World lllllllllllllllIlIlIlIIllIllIlIl, final BlockPos lllllllllllllllIlIlIlIIllIllIlII, final IBlockState lllllllllllllllIlIlIlIIllIllIIll, final Random lllllllllllllllIlIlIlIIllIllIIlI) {
    }
    
    protected int getActiveSignal(final IBlockAccess lllllllllllllllIlIlIlIIIlIlIllIl, final BlockPos lllllllllllllllIlIlIlIIIlIlIllII, final IBlockState lllllllllllllllIlIlIlIIIlIlIlIll) {
        return 15;
    }
    
    protected int getPowerOnSides(final IBlockAccess lllllllllllllllIlIlIlIIlIIIlllII, final BlockPos lllllllllllllllIlIlIlIIlIIIllIll, final IBlockState lllllllllllllllIlIlIlIIlIIIllIlI) {
        final EnumFacing lllllllllllllllIlIlIlIIlIIlIIIII = lllllllllllllllIlIlIlIIlIIIllIlI.getValue((IProperty<EnumFacing>)BlockRedstoneDiode.FACING);
        final EnumFacing lllllllllllllllIlIlIlIIlIIIlllll = lllllllllllllllIlIlIlIIlIIlIIIII.rotateY();
        final EnumFacing lllllllllllllllIlIlIlIIlIIIllllI = lllllllllllllllIlIlIlIIlIIlIIIII.rotateYCCW();
        return Math.max(this.getPowerOnSide(lllllllllllllllIlIlIlIIlIIIlllII, lllllllllllllllIlIlIlIIlIIIllIll.offset(lllllllllllllllIlIlIlIIlIIIlllll), lllllllllllllllIlIlIlIIlIIIlllll), this.getPowerOnSide(lllllllllllllllIlIlIlIIlIIIlllII, lllllllllllllllIlIlIlIIlIIIllIll.offset(lllllllllllllllIlIlIlIIlIIIllllI), lllllllllllllllIlIlIlIIlIIIllllI));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIlIlIlIIIlIllIIll) {
        return false;
    }
    
    protected abstract int getDelay(final IBlockState p0);
    
    protected boolean isPowered(final IBlockState lllllllllllllllIlIlIlIIllIIllIII) {
        return this.isRepeaterPowered;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllllIlIlIlIIIllllIIII, final BlockPos lllllllllllllllIlIlIlIIIlllIllll, final IBlockState lllllllllllllllIlIlIlIIIlllIlIII, final EntityLivingBase lllllllllllllllIlIlIlIIIlllIllIl, final ItemStack lllllllllllllllIlIlIlIIIlllIllII) {
        if (this.shouldBePowered(lllllllllllllllIlIlIlIIIllllIIII, lllllllllllllllIlIlIlIIIlllIllll, lllllllllllllllIlIlIlIIIlllIlIII)) {
            lllllllllllllllIlIlIlIIIllllIIII.scheduleUpdate(lllllllllllllllIlIlIlIIIlllIllll, this, 1);
        }
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllllIlIlIlIIlIIIIIIll) {
        return true;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllIlIlIlIIlIlllIIIl, final World lllllllllllllllIlIlIlIIlIlllIIII, final BlockPos lllllllllllllllIlIlIlIIlIllIlIII, final Block lllllllllllllllIlIlIlIIlIllIlllI, final BlockPos lllllllllllllllIlIlIlIIlIllIllIl) {
        if (this.canBlockStay(lllllllllllllllIlIlIlIIlIlllIIII, lllllllllllllllIlIlIlIIlIllIlIII)) {
            this.updateState(lllllllllllllllIlIlIlIIlIlllIIII, lllllllllllllllIlIlIlIIlIllIlIII, lllllllllllllllIlIlIlIIlIlllIIIl);
        }
        else {
            this.dropBlockAsItem(lllllllllllllllIlIlIlIIlIlllIIII, lllllllllllllllIlIlIlIIlIllIlIII, lllllllllllllllIlIlIlIIlIlllIIIl, 0);
            lllllllllllllllIlIlIlIIlIlllIIII.setBlockToAir(lllllllllllllllIlIlIlIIlIllIlIII);
            final Exception lllllllllllllllIlIlIlIIlIllIIlII;
            final char lllllllllllllllIlIlIlIIlIllIIlIl = (char)((EnumFacing[])(Object)(lllllllllllllllIlIlIlIIlIllIIlII = (Exception)(Object)EnumFacing.values())).length;
            for (double lllllllllllllllIlIlIlIIlIllIIllI = 0; lllllllllllllllIlIlIlIIlIllIIllI < lllllllllllllllIlIlIlIIlIllIIlIl; ++lllllllllllllllIlIlIlIIlIllIIllI) {
                final EnumFacing lllllllllllllllIlIlIlIIlIllIllII = lllllllllllllllIlIlIlIIlIllIIlII[lllllllllllllllIlIlIlIIlIllIIllI];
                lllllllllllllllIlIlIlIIlIlllIIII.notifyNeighborsOfStateChange(lllllllllllllllIlIlIlIIlIllIlIII.offset(lllllllllllllllIlIlIlIIlIllIllII), this, false);
            }
        }
    }
    
    public boolean isLocked(final IBlockAccess lllllllllllllllIlIlIlIIlIlIlIIII, final BlockPos lllllllllllllllIlIlIlIIlIlIIllll, final IBlockState lllllllllllllllIlIlIlIIlIlIIlllI) {
        return false;
    }
}
