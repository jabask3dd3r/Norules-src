package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class BlockFenceGate extends BlockHorizontal
{
    protected static final /* synthetic */ AxisAlignedBB AABB_COLLIDE_XAXIS;
    protected static final /* synthetic */ AxisAlignedBB AABB_COLLIDE_XAXIS_INWALL;
    protected static final /* synthetic */ AxisAlignedBB AABB_COLLIDE_ZAXIS;
    protected static final /* synthetic */ AxisAlignedBB AABB_CLOSED_SELECTED_ZAXIS;
    protected static final /* synthetic */ AxisAlignedBB AABB_CLOSED_SELECTED_XAXIS;
    public static final /* synthetic */ PropertyBool POWERED;
    public static final /* synthetic */ PropertyBool IN_WALL;
    protected static final /* synthetic */ AxisAlignedBB AABB_COLLIDE_ZAXIS_INWALL;
    public static final /* synthetic */ PropertyBool OPEN;
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIIIlIlIIIlIIlIlIIl, final Mirror lllllllllllllIIIIlIlIIIlIIlIIllI) {
        return lllllllllllllIIIIlIlIIIlIIlIlIIl.withRotation(lllllllllllllIIIIlIlIIIlIIlIIllI.toRotation(lllllllllllllIIIIlIlIIIlIIlIlIIl.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING)));
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllIIIIlIlIIIIllIlIIlI, final IBlockAccess lllllllllllllIIIIlIlIIIIllIlIIIl, final BlockPos lllllllllllllIIIIlIlIIIIllIlIIII, final EnumFacing lllllllllllllIIIIlIlIIIIllIIllll) {
        return true;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFenceGate.FACING, BlockFenceGate.OPEN, BlockFenceGate.POWERED, BlockFenceGate.IN_WALL });
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIIIlIlIIIIllIlllIl, final World lllllllllllllIIIIlIlIIIIllIlllII, final BlockPos lllllllllllllIIIIlIlIIIIllIlIlIl, final Block lllllllllllllIIIIlIlIIIIllIllIlI, final BlockPos lllllllllllllIIIIlIlIIIIllIllIIl) {
        if (!lllllllllllllIIIIlIlIIIIllIlllII.isRemote) {
            final boolean lllllllllllllIIIIlIlIIIIllIllIII = lllllllllllllIIIIlIlIIIIllIlllII.isBlockPowered(lllllllllllllIIIIlIlIIIIllIlIlIl);
            if (lllllllllllllIIIIlIlIIIIllIlllIl.getValue((IProperty<Boolean>)BlockFenceGate.POWERED) != lllllllllllllIIIIlIlIIIIllIllIII) {
                lllllllllllllIIIIlIlIIIIllIlllII.setBlockState(lllllllllllllIIIIlIlIIIIllIlIlIl, lllllllllllllIIIIlIlIIIIllIlllIl.withProperty((IProperty<Comparable>)BlockFenceGate.POWERED, lllllllllllllIIIIlIlIIIIllIllIII).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, lllllllllllllIIIIlIlIIIIllIllIII), 2);
                if (lllllllllllllIIIIlIlIIIIllIlllIl.getValue((IProperty<Boolean>)BlockFenceGate.OPEN) != lllllllllllllIIIIlIlIIIIllIllIII) {
                    lllllllllllllIIIIlIlIIIIllIlllII.playEvent(null, lllllllllllllIIIIlIlIIIIllIllIII ? 1008 : 1014, lllllllllllllIIIIlIlIIIIllIlIlIl, 0);
                }
            }
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState lllllllllllllIIIIlIlIIIlIlIIIIll, final IBlockAccess lllllllllllllIIIIlIlIIIlIlIIIIlI, final BlockPos lllllllllllllIIIIlIlIIIlIlIIIIIl) {
        lllllllllllllIIIIlIlIIIlIlIIIIll = (Exception)this.getActualState((IBlockState)lllllllllllllIIIIlIlIIIlIlIIIIll, lllllllllllllIIIIlIlIIIlIlIIIIlI, lllllllllllllIIIIlIlIIIlIlIIIIIl);
        if (((IBlockState)lllllllllllllIIIIlIlIIIlIlIIIIll).getValue((IProperty<Boolean>)BlockFenceGate.IN_WALL)) {
            return (((IBlockState)lllllllllllllIIIIlIlIIIlIlIIIIll).getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis() == EnumFacing.Axis.X) ? BlockFenceGate.AABB_COLLIDE_XAXIS_INWALL : BlockFenceGate.AABB_COLLIDE_ZAXIS_INWALL;
        }
        return (((IBlockState)lllllllllllllIIIIlIlIIIlIlIIIIll).getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis() == EnumFacing.Axis.X) ? BlockFenceGate.AABB_COLLIDE_XAXIS : BlockFenceGate.AABB_COLLIDE_ZAXIS;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIIIlIlIIIIlIlllIll, final IBlockState lllllllllllllIIIIlIlIIIIlIllIlll, final BlockPos lllllllllllllIIIIlIlIIIIlIlllIIl, final EnumFacing lllllllllllllIIIIlIlIIIIlIllIllI) {
        if (lllllllllllllIIIIlIlIIIIlIllIllI != EnumFacing.UP && lllllllllllllIIIIlIlIIIIlIllIllI != EnumFacing.DOWN) {
            return (lllllllllllllIIIIlIlIIIIlIllIlll.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis() == lllllllllllllIIIIlIlIIIIlIllIllI.rotateY().getAxis()) ? BlockFaceShape.MIDDLE_POLE : BlockFaceShape.UNDEFINED;
        }
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIIIlIlIIIlIIIlIIll) {
        return false;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIIIIlIlIIIlIIIIIlIl, final BlockPos lllllllllllllIIIIlIlIIIIlllllIlI, final EnumFacing lllllllllllllIIIIlIlIIIlIIIIIIll, final float lllllllllllllIIIIlIlIIIlIIIIIIlI, final float lllllllllllllIIIIlIlIIIlIIIIIIIl, final float lllllllllllllIIIIlIlIIIlIIIIIIII, final int lllllllllllllIIIIlIlIIIIllllllll, final EntityLivingBase lllllllllllllIIIIlIlIIIIlllllIIl) {
        final boolean lllllllllllllIIIIlIlIIIIllllllIl = lllllllllllllIIIIlIlIIIlIIIIIlIl.isBlockPowered(lllllllllllllIIIIlIlIIIIlllllIlI);
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFenceGate.FACING, lllllllllllllIIIIlIlIIIIlllllIIl.getHorizontalFacing()).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, lllllllllllllIIIIlIlIIIIllllllIl).withProperty((IProperty<Comparable>)BlockFenceGate.POWERED, lllllllllllllIIIIlIlIIIIllllllIl).withProperty((IProperty<Comparable>)BlockFenceGate.IN_WALL, false);
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllIIIIlIlIIIlIIllIlll, final IBlockAccess lllllllllllllIIIIlIlIIIlIIllIllI, final BlockPos lllllllllllllIIIIlIlIIIlIIllIlIl) {
        final EnumFacing.Axis lllllllllllllIIIIlIlIIIlIIlllIII = ((IBlockState)lllllllllllllIIIIlIlIIIlIIllIlll).getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis();
        if ((lllllllllllllIIIIlIlIIIlIIlllIII == EnumFacing.Axis.Z && (lllllllllllllIIIIlIlIIIlIIllIllI.getBlockState(lllllllllllllIIIIlIlIIIlIIllIlIl.west()).getBlock() == Blocks.COBBLESTONE_WALL || lllllllllllllIIIIlIlIIIlIIllIllI.getBlockState(lllllllllllllIIIIlIlIIIlIIllIlIl.east()).getBlock() == Blocks.COBBLESTONE_WALL)) || (lllllllllllllIIIIlIlIIIlIIlllIII == EnumFacing.Axis.X && (lllllllllllllIIIIlIlIIIlIIllIllI.getBlockState(lllllllllllllIIIIlIlIIIlIIllIlIl.north()).getBlock() == Blocks.COBBLESTONE_WALL || lllllllllllllIIIIlIlIIIlIIllIllI.getBlockState(lllllllllllllIIIIlIlIIIlIIllIlIl.south()).getBlock() == Blocks.COBBLESTONE_WALL))) {
            lllllllllllllIIIIlIlIIIlIIllIlll = ((IBlockState)lllllllllllllIIIIlIlIIIlIIllIlll).withProperty((IProperty<Comparable>)BlockFenceGate.IN_WALL, Boolean.valueOf(true));
        }
        return (IBlockState)lllllllllllllIIIIlIlIIIlIIllIlll;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIIlIlIIIIllIIlIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFenceGate.FACING, EnumFacing.getHorizontal(lllllllllllllIIIIlIlIIIIllIIlIll)).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, (lllllllllllllIIIIlIlIIIIllIIlIll & 0x4) != 0x0).withProperty((IProperty<Comparable>)BlockFenceGate.POWERED, (lllllllllllllIIIIlIlIIIIllIIlIll & 0x8) != 0x0);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIIlIlIIIlIIIlIlIl) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIIIIlIlIIIIlllIIlll, final BlockPos lllllllllllllIIIIlIlIIIIlllIIllI, IBlockState lllllllllllllIIIIlIlIIIIlllIIlIl, final EntityPlayer lllllllllllllIIIIlIlIIIIlllIlllI, final EnumHand lllllllllllllIIIIlIlIIIIlllIllIl, final EnumFacing lllllllllllllIIIIlIlIIIIlllIllII, final float lllllllllllllIIIIlIlIIIIlllIlIll, final float lllllllllllllIIIIlIlIIIIlllIlIlI, final float lllllllllllllIIIIlIlIIIIlllIlIIl) {
        if (((IBlockState)lllllllllllllIIIIlIlIIIIlllIIlIl).getValue((IProperty<Boolean>)BlockFenceGate.OPEN)) {
            lllllllllllllIIIIlIlIIIIlllIIlIl = ((IBlockState)lllllllllllllIIIIlIlIIIIlllIIlIl).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, Boolean.valueOf(false));
            lllllllllllllIIIIlIlIIIIlllIIlll.setBlockState(lllllllllllllIIIIlIlIIIIlllIIllI, (IBlockState)lllllllllllllIIIIlIlIIIIlllIIlIl, 10);
        }
        else {
            final EnumFacing lllllllllllllIIIIlIlIIIIlllIlIII = EnumFacing.fromAngle(lllllllllllllIIIIlIlIIIIlllIlllI.rotationYaw);
            if (((IBlockState)lllllllllllllIIIIlIlIIIIlllIIlIl).getValue((IProperty<Comparable>)BlockFenceGate.FACING) == lllllllllllllIIIIlIlIIIIlllIlIII.getOpposite()) {
                lllllllllllllIIIIlIlIIIIlllIIlIl = ((IBlockState)lllllllllllllIIIIlIlIIIIlllIIlIl).withProperty((IProperty<Comparable>)BlockFenceGate.FACING, lllllllllllllIIIIlIlIIIIlllIlIII);
            }
            lllllllllllllIIIIlIlIIIIlllIIlIl = ((IBlockState)lllllllllllllIIIIlIlIIIIlllIIlIl).withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, Boolean.valueOf(true));
            lllllllllllllIIIIlIlIIIIlllIIlll.setBlockState(lllllllllllllIIIIlIlIIIIlllIIllI, (IBlockState)lllllllllllllIIIIlIlIIIIlllIIlIl, 10);
        }
        lllllllllllllIIIIlIlIIIIlllIIlll.playEvent(lllllllllllllIIIIlIlIIIIlllIlllI, ((boolean)((IBlockState)lllllllllllllIIIIlIlIIIIlllIIlIl).getValue((IProperty<Boolean>)BlockFenceGate.OPEN)) ? 1008 : 1014, lllllllllllllIIIIlIlIIIIlllIIllI, 0);
        return true;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllIIIIlIlIIIlIIIllIlI, final IBlockAccess lllllllllllllIIIIlIlIIIlIIIllIIl, final BlockPos lllllllllllllIIIIlIlIIIlIIIllIII) {
        if (lllllllllllllIIIIlIlIIIlIIIllIlI.getValue((IProperty<Boolean>)BlockFenceGate.OPEN)) {
            return BlockFenceGate.NULL_AABB;
        }
        return (lllllllllllllIIIIlIlIIIlIIIllIlI.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getAxis() == EnumFacing.Axis.Z) ? BlockFenceGate.AABB_CLOSED_SELECTED_ZAXIS : BlockFenceGate.AABB_CLOSED_SELECTED_XAXIS;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIIIIlIlIIIlIIlIIIIl, final BlockPos lllllllllllllIIIIlIlIIIlIIlIIIII) {
        return lllllllllllllIIIIlIlIIIlIIlIIIIl.getBlockState(lllllllllllllIIIIlIlIIIlIIlIIIII.down()).getMaterial().isSolid() && super.canPlaceBlockAt(lllllllllllllIIIIlIlIIIlIIlIIIIl, lllllllllllllIIIIlIlIIIlIIlIIIII);
    }
    
    public BlockFenceGate(final BlockPlanks.EnumType lllllllllllllIIIIlIlIIIlIlIIllIl) {
        super(Material.WOOD, lllllllllllllIIIIlIlIIIlIlIIllIl.getMapColor());
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFenceGate.OPEN, false).withProperty((IProperty<Comparable>)BlockFenceGate.POWERED, false).withProperty((IProperty<Comparable>)BlockFenceGate.IN_WALL, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllIIIIlIlIIIlIIIIllIl, final BlockPos lllllllllllllIIIIlIlIIIlIIIIllII) {
        return lllllllllllllIIIIlIlIIIlIIIIllIl.getBlockState(lllllllllllllIIIIlIlIIIlIIIIllII).getValue((IProperty<Boolean>)BlockFenceGate.OPEN);
    }
    
    static {
        OPEN = PropertyBool.create("open");
        POWERED = PropertyBool.create("powered");
        IN_WALL = PropertyBool.create("in_wall");
        AABB_COLLIDE_ZAXIS = new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.0, 0.625);
        AABB_COLLIDE_XAXIS = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.0, 1.0);
        AABB_COLLIDE_ZAXIS_INWALL = new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 0.8125, 0.625);
        AABB_COLLIDE_XAXIS_INWALL = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 0.8125, 1.0);
        AABB_CLOSED_SELECTED_ZAXIS = new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.5, 0.625);
        AABB_CLOSED_SELECTED_XAXIS = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.5, 1.0);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIIIlIlIIIlIIlIlllI, final Rotation lllllllllllllIIIIlIlIIIlIIlIllll) {
        return lllllllllllllIIIIlIlIIIlIIlIlllI.withProperty((IProperty<Comparable>)BlockFenceGate.FACING, lllllllllllllIIIIlIlIIIlIIlIllll.rotate(lllllllllllllIIIIlIlIIIlIIlIlllI.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIIlIlIIIIllIIIlIl) {
        int lllllllllllllIIIIlIlIIIIllIIIlII = 0;
        lllllllllllllIIIIlIlIIIIllIIIlII |= lllllllllllllIIIIlIlIIIIllIIIlIl.getValue((IProperty<EnumFacing>)BlockFenceGate.FACING).getHorizontalIndex();
        if (lllllllllllllIIIIlIlIIIIllIIIlIl.getValue((IProperty<Boolean>)BlockFenceGate.POWERED)) {
            lllllllllllllIIIIlIlIIIIllIIIlII |= 0x8;
        }
        if (lllllllllllllIIIIlIlIIIIllIIIlIl.getValue((IProperty<Boolean>)BlockFenceGate.OPEN)) {
            lllllllllllllIIIIlIlIIIIllIIIlII |= 0x4;
        }
        return lllllllllllllIIIIlIlIIIIllIIIlII;
    }
}
