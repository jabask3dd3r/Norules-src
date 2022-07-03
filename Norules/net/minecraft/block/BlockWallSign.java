package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public class BlockWallSign extends BlockSign
{
    protected static final /* synthetic */ AxisAlignedBB SIGN_WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB SIGN_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB SIGN_NORTH_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB SIGN_SOUTH_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIlIllllIlIlIllIl) {
        EnumFacing lllllllllllllllIIlIllllIlIlIllll = EnumFacing.getFront(lllllllllllllllIIlIllllIlIlIllIl);
        if (lllllllllllllllIIlIllllIlIlIllll.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllllllIIlIllllIlIlIllll = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockWallSign.FACING, lllllllllllllllIIlIllllIlIlIllll);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockWallSign.FACING });
    }
    
    public BlockWallSign() {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockWallSign.FACING, EnumFacing.NORTH));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIIlIllllIllIIllll, final IBlockAccess lllllllllllllllIIlIllllIllIIlllI, final BlockPos lllllllllllllllIIlIllllIllIIllIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllllIIlIllllIllIIllll.getValue((IProperty<EnumFacing>)BlockWallSign.FACING).ordinal()]) {
            default: {
                return BlockWallSign.SIGN_NORTH_AABB;
            }
            case 4: {
                return BlockWallSign.SIGN_SOUTH_AABB;
            }
            case 5: {
                return BlockWallSign.SIGN_WEST_AABB;
            }
            case 6: {
                return BlockWallSign.SIGN_EAST_AABB;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockWallSign.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final float lllllllllllllllIIlIllllIlIIIIIll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllllIIlIllllIlIIIIIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIIlIllllIlIIIIIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIIlIllllIlIIIIIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIIlIllllIlIIIIIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIIlIllllIlIIIIIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIIlIllllIlIIIIIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockWallSign.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllllIIlIllllIlIIIIIll;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllIIlIllllIllIIIIll, final World lllllllllllllllIIlIllllIlIlllIll, final BlockPos lllllllllllllllIIlIllllIllIIIIIl, final Block lllllllllllllllIIlIllllIlIlllIIl, final BlockPos lllllllllllllllIIlIllllIlIlllIII) {
        final EnumFacing lllllllllllllllIIlIllllIlIlllllI = lllllllllllllllIIlIllllIllIIIIll.getValue((IProperty<EnumFacing>)BlockWallSign.FACING);
        if (!lllllllllllllllIIlIllllIlIlllIll.getBlockState(lllllllllllllllIIlIllllIllIIIIIl.offset(lllllllllllllllIIlIllllIlIlllllI.getOpposite())).getMaterial().isSolid()) {
            this.dropBlockAsItem(lllllllllllllllIIlIllllIlIlllIll, lllllllllllllllIIlIllllIllIIIIIl, lllllllllllllllIIlIllllIllIIIIll, 0);
            lllllllllllllllIIlIllllIlIlllIll.setBlockToAir(lllllllllllllllIIlIllllIllIIIIIl);
        }
        super.neighborChanged(lllllllllllllllIIlIllllIllIIIIll, lllllllllllllllIIlIllllIlIlllIll, lllllllllllllllIIlIllllIllIIIIIl, lllllllllllllllIIlIllllIlIlllIIl, lllllllllllllllIIlIllllIlIlllIII);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllllIIlIllllIlIIlllII, final Mirror lllllllllllllllIIlIllllIlIIlIlll) {
        return lllllllllllllllIIlIllllIlIIlllII.withRotation(lllllllllllllllIIlIllllIlIIlIlll.toRotation(lllllllllllllllIIlIllllIlIIlllII.getValue((IProperty<EnumFacing>)BlockWallSign.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIlIllllIlIlIlIII) {
        return lllllllllllllllIIlIllllIlIlIlIII.getValue((IProperty<EnumFacing>)BlockWallSign.FACING).getIndex();
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllIIlIllllIlIlIIIlI, final Rotation lllllllllllllllIIlIllllIlIlIIIIl) {
        return lllllllllllllllIIlIllllIlIlIIIlI.withProperty((IProperty<Comparable>)BlockWallSign.FACING, lllllllllllllllIIlIllllIlIlIIIIl.rotate(lllllllllllllllIIlIllllIlIlIIIlI.getValue((IProperty<EnumFacing>)BlockWallSign.FACING)));
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        SIGN_EAST_AABB = new AxisAlignedBB(0.0, 0.28125, 0.0, 0.125, 0.78125, 1.0);
        SIGN_WEST_AABB = new AxisAlignedBB(0.875, 0.28125, 0.0, 1.0, 0.78125, 1.0);
        SIGN_SOUTH_AABB = new AxisAlignedBB(0.0, 0.28125, 0.0, 1.0, 0.78125, 0.125);
        SIGN_NORTH_AABB = new AxisAlignedBB(0.0, 0.28125, 0.875, 1.0, 0.78125, 1.0);
    }
}
