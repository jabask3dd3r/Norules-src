package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockLadder extends Block
{
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB LADDER_SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB LADDER_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB LADDER_WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB LADDER_EAST_AABB;
    
    @Override
    public IBlockState withRotation(final IBlockState lllIIIllIllll, final Rotation lllIIIllIlllI) {
        return lllIIIllIllll.withProperty((IProperty<Comparable>)BlockLadder.FACING, lllIIIllIlllI.rotate(lllIIIllIllll.getValue((IProperty<EnumFacing>)BlockLadder.FACING)));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllIIIllllIII) {
        EnumFacing lllIIIllllIlI = EnumFacing.getFront(lllIIIllllIII);
        if (lllIIIllllIlI.getAxis() == EnumFacing.Axis.Y) {
            lllIIIllllIlI = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, lllIIIllllIlI);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllIIIllIIllI, final Mirror lllIIIllIIlIl) {
        return lllIIIllIIllI.withRotation(lllIIIllIIlIl.toRotation(lllIIIllIIllI.getValue((IProperty<EnumFacing>)BlockLadder.FACING)));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockLadder.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final float lllIIIlIllIll = (Object)new int[EnumFacing.values().length];
        try {
            lllIIIlIllIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllIIIlIllIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllIIIlIllIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllIIIlIllIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllIIIlIllIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllIIIlIllIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockLadder.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllIIIlIllIll;
    }
    
    private boolean func_193392_c(final World lllIIlIllIIII, final BlockPos lllIIlIlIllll, final EnumFacing lllIIlIllIIll) {
        final IBlockState lllIIlIllIIlI = lllIIlIllIIII.getBlockState(lllIIlIlIllll);
        final boolean lllIIlIllIIIl = Block.func_193382_c(lllIIlIllIIlI.getBlock());
        return !lllIIlIllIIIl && lllIIlIllIIlI.func_193401_d(lllIIlIllIIII, lllIIlIlIllll, lllIIlIllIIll) == BlockFaceShape.SOLID && !lllIIlIllIIlI.canProvidePower();
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockLadder.FACING });
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllIIllIIllII, final IBlockAccess lllIIllIIlllI, final BlockPos lllIIllIIllIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllIIllIIllII.getValue((IProperty<EnumFacing>)BlockLadder.FACING).ordinal()]) {
            case 3: {
                return BlockLadder.LADDER_NORTH_AABB;
            }
            case 4: {
                return BlockLadder.LADDER_SOUTH_AABB;
            }
            case 5: {
                return BlockLadder.LADDER_WEST_AABB;
            }
            default: {
                return BlockLadder.LADDER_EAST_AABB;
            }
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllIIllIIlIII) {
        return false;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllIIIlllIIll) {
        return lllIIIlllIIll.getValue((IProperty<EnumFacing>)BlockLadder.FACING).getIndex();
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllIIlIlIIlII, final BlockPos lllIIlIIllIIl, final EnumFacing lllIIlIIllIII, final float lllIIlIlIIIIl, final float lllIIlIlIIIII, final float lllIIlIIlllll, final int lllIIlIIllllI, final EntityLivingBase lllIIlIIlllIl) {
        if (lllIIlIIllIII.getAxis().isHorizontal() && this.func_193392_c(lllIIlIlIIlII, lllIIlIIllIIl.offset(lllIIlIIllIII.getOpposite()), lllIIlIIllIII)) {
            return this.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, lllIIlIIllIII);
        }
        for (final EnumFacing lllIIlIIlllII : EnumFacing.Plane.HORIZONTAL) {
            if (this.func_193392_c(lllIIlIlIIlII, lllIIlIIllIIl.offset(lllIIlIIlllII.getOpposite()), lllIIlIIlllII)) {
                return this.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, lllIIlIIlllII);
            }
        }
        return this.getDefaultState();
    }
    
    protected BlockLadder() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.NORTH));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllIIllIIIIlI, final BlockPos lllIIlIllllIl, final EnumFacing lllIIlIllllII) {
        return this.func_193392_c(lllIIllIIIIlI, lllIIlIllllIl.west(), lllIIlIllllII) || this.func_193392_c(lllIIllIIIIlI, lllIIlIllllIl.east(), lllIIlIllllII) || this.func_193392_c(lllIIllIIIIlI, lllIIlIllllIl.north(), lllIIlIllllII) || this.func_193392_c(lllIIllIIIIlI, lllIIlIllllIl.south(), lllIIlIllllII);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllIIIllIIIII, final IBlockState lllIIIlIlllll, final BlockPos lllIIIlIllllI, final EnumFacing lllIIIlIlllIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllIIlIIIllIl, final World lllIIlIIIllII, final BlockPos lllIIlIIIIlII, final Block lllIIlIIIIIll, final BlockPos lllIIlIIIlIIl) {
        final EnumFacing lllIIlIIIlIII = lllIIlIIIllIl.getValue((IProperty<EnumFacing>)BlockLadder.FACING);
        if (!this.func_193392_c(lllIIlIIIllII, lllIIlIIIIlII.offset(lllIIlIIIlIII.getOpposite()), lllIIlIIIlIII)) {
            this.dropBlockAsItem(lllIIlIIIllII, lllIIlIIIIlII, lllIIlIIIllIl, 0);
            lllIIlIIIllII.setBlockToAir(lllIIlIIIIlII);
        }
        super.neighborChanged(lllIIlIIIllIl, lllIIlIIIllII, lllIIlIIIIlII, lllIIlIIIIIll, lllIIlIIIlIIl);
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        LADDER_EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.1875, 1.0, 1.0);
        LADDER_WEST_AABB = new AxisAlignedBB(0.8125, 0.0, 0.0, 1.0, 1.0, 1.0);
        LADDER_SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.1875);
        LADDER_NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.8125, 1.0, 1.0, 1.0);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllIIllIIlIlI) {
        return false;
    }
}
