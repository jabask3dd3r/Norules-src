package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockStairs extends Block
{
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_BOT_SW;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB AABB_SLAB_BOTTOM;
    private final /* synthetic */ IBlockState modelState;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_BOT_NE;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_BOT_SE;
    public static final /* synthetic */ PropertyEnum<EnumHalf> HALF;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_TOP_EAST;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_TOP_SOUTH;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_TOP_NE;
    public static final /* synthetic */ PropertyEnum<EnumShape> SHAPE;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_BOT_WEST;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_TOP_NORTH;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_BOT_EAST;
    protected static final /* synthetic */ AxisAlignedBB AABB_SLAB_TOP;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_TOP_SW;
    private final /* synthetic */ Block modelBlock;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_TOP_NW;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_BOT_SOUTH;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_BOT_NORTH;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_BOT_NW;
    protected static final /* synthetic */ AxisAlignedBB AABB_QTR_TOP_WEST;
    protected static final /* synthetic */ AxisAlignedBB AABB_OCT_TOP_SE;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockStairs.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final float lllllllllllllIllllIIIIIIllIIIlll = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllIllllIIIIIIllIIIlll[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIIIIIllIIIlll[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIIIIIllIIIlll[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockStairs.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllIllllIIIIIIllIIIlll;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStairs.FACING, BlockStairs.HALF, BlockStairs.SHAPE });
    }
    
    @Override
    public float getExplosionResistance(final Entity lllllllllllllIllllIIIIIllllllllI) {
        return this.modelBlock.getExplosionResistance(lllllllllllllIllllIIIIIllllllllI);
    }
    
    protected BlockStairs(final IBlockState lllllllllllllIllllIIIIlIlIIIlIlI) {
        super(lllllllllllllIllllIIIIlIlIIIlIlI.getBlock().blockMaterial);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH).withProperty(BlockStairs.HALF, EnumHalf.BOTTOM).withProperty(BlockStairs.SHAPE, EnumShape.STRAIGHT));
        this.modelBlock = lllllllllllllIllllIIIIlIlIIIlIlI.getBlock();
        this.modelState = lllllllllllllIllllIIIIlIlIIIlIlI;
        this.setHardness(this.modelBlock.blockHardness);
        this.setResistance(this.modelBlock.blockResistance / 3.0f);
        this.setSoundType(this.modelBlock.blockSoundType);
        this.setLightOpacity(255);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void onBlockClicked(final World lllllllllllllIllllIIIIlIIIlIIIII, final BlockPos lllllllllllllIllllIIIIlIIIIllIll, final EntityPlayer lllllllllllllIllllIIIIlIIIIllllI) {
        this.modelBlock.onBlockClicked(lllllllllllllIllllIIIIlIIIlIIIII, lllllllllllllIllllIIIIlIIIIllIll, lllllllllllllIllllIIIIlIIIIllllI);
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        HALF = PropertyEnum.create("half", EnumHalf.class);
        SHAPE = PropertyEnum.create("shape", EnumShape.class);
        AABB_SLAB_TOP = new AxisAlignedBB(0.0, 0.5, 0.0, 1.0, 1.0, 1.0);
        AABB_QTR_TOP_WEST = new AxisAlignedBB(0.0, 0.5, 0.0, 0.5, 1.0, 1.0);
        AABB_QTR_TOP_EAST = new AxisAlignedBB(0.5, 0.5, 0.0, 1.0, 1.0, 1.0);
        AABB_QTR_TOP_NORTH = new AxisAlignedBB(0.0, 0.5, 0.0, 1.0, 1.0, 0.5);
        AABB_QTR_TOP_SOUTH = new AxisAlignedBB(0.0, 0.5, 0.5, 1.0, 1.0, 1.0);
        AABB_OCT_TOP_NW = new AxisAlignedBB(0.0, 0.5, 0.0, 0.5, 1.0, 0.5);
        AABB_OCT_TOP_NE = new AxisAlignedBB(0.5, 0.5, 0.0, 1.0, 1.0, 0.5);
        AABB_OCT_TOP_SW = new AxisAlignedBB(0.0, 0.5, 0.5, 0.5, 1.0, 1.0);
        AABB_OCT_TOP_SE = new AxisAlignedBB(0.5, 0.5, 0.5, 1.0, 1.0, 1.0);
        AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
        AABB_QTR_BOT_WEST = new AxisAlignedBB(0.0, 0.0, 0.0, 0.5, 0.5, 1.0);
        AABB_QTR_BOT_EAST = new AxisAlignedBB(0.5, 0.0, 0.0, 1.0, 0.5, 1.0);
        AABB_QTR_BOT_NORTH = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 0.5);
        AABB_QTR_BOT_SOUTH = new AxisAlignedBB(0.0, 0.0, 0.5, 1.0, 0.5, 1.0);
        AABB_OCT_BOT_NW = new AxisAlignedBB(0.0, 0.0, 0.0, 0.5, 0.5, 0.5);
        AABB_OCT_BOT_NE = new AxisAlignedBB(0.5, 0.0, 0.0, 1.0, 0.5, 0.5);
        AABB_OCT_BOT_SW = new AxisAlignedBB(0.0, 0.0, 0.5, 0.5, 0.5, 1.0);
        AABB_OCT_BOT_SE = new AxisAlignedBB(0.5, 0.0, 0.5, 1.0, 0.5, 1.0);
    }
    
    @Override
    public Vec3d modifyAcceleration(final World lllllllllllllIllllIIIIIlllIlllll, final BlockPos lllllllllllllIllllIIIIIllllIIIll, final Entity lllllllllllllIllllIIIIIllllIIIlI, final Vec3d lllllllllllllIllllIIIIIllllIIIIl) {
        return this.modelBlock.modifyAcceleration(lllllllllllllIllllIIIIIlllIlllll, lllllllllllllIllllIIIIIllllIIIll, lllllllllllllIllllIIIIIllllIIIlI, lllllllllllllIllllIIIIIllllIIIIl);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIllllIIIIIlIlIlIlII, final BlockPos lllllllllllllIllllIIIIIlIlIlIIll, final EnumFacing lllllllllllllIllllIIIIIlIlIlIIlI, final float lllllllllllllIllllIIIIIlIlIllIll, final float lllllllllllllIllllIIIIIlIlIllIlI, final float lllllllllllllIllllIIIIIlIlIllIIl, final int lllllllllllllIllllIIIIIlIlIllIII, final EntityLivingBase lllllllllllllIllllIIIIIlIlIlIlll) {
        IBlockState lllllllllllllIllllIIIIIlIlIlIllI = super.onBlockPlaced(lllllllllllllIllllIIIIIlIlIlIlII, lllllllllllllIllllIIIIIlIlIlIIll, lllllllllllllIllllIIIIIlIlIlIIlI, lllllllllllllIllllIIIIIlIlIllIll, lllllllllllllIllllIIIIIlIlIllIlI, lllllllllllllIllllIIIIIlIlIllIIl, lllllllllllllIllllIIIIIlIlIllIII, lllllllllllllIllllIIIIIlIlIlIlll);
        lllllllllllllIllllIIIIIlIlIlIllI = lllllllllllllIllllIIIIIlIlIlIllI.withProperty((IProperty<Comparable>)BlockStairs.FACING, lllllllllllllIllllIIIIIlIlIlIlll.getHorizontalFacing()).withProperty(BlockStairs.SHAPE, EnumShape.STRAIGHT);
        return (lllllllllllllIllllIIIIIlIlIlIIlI != EnumFacing.DOWN && (lllllllllllllIllllIIIIIlIlIlIIlI == EnumFacing.UP || lllllllllllllIllllIIIIIlIlIllIlI <= 0.5)) ? lllllllllllllIllllIIIIIlIlIlIllI.withProperty(BlockStairs.HALF, EnumHalf.BOTTOM) : lllllllllllllIllllIIIIIlIlIlIllI.withProperty(BlockStairs.HALF, EnumHalf.TOP);
    }
    
    @Override
    public boolean canCollideCheck(final IBlockState lllllllllllllIllllIIIIIlllIlIIIl, final boolean lllllllllllllIllllIIIIIlllIlIIll) {
        return this.modelBlock.canCollideCheck(lllllllllllllIllllIIIIIlllIlIIIl, lllllllllllllIllllIIIIIlllIlIIll);
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIllllIIIIIllIllIlII, final BlockPos lllllllllllllIllllIIIIIllIllIIll, final IBlockState lllllllllllllIllllIIIIIllIllIllI) {
        this.modelBlock.breakBlock(lllllllllllllIllllIIIIIllIllIlII, lllllllllllllIllllIIIIIllIllIIll, this.modelState);
    }
    
    private static boolean isDifferentStairs(final IBlockState lllllllllllllIllllIIIIIIlllIllIl, final IBlockAccess lllllllllllllIllllIIIIIIllllIIIl, final BlockPos lllllllllllllIllllIIIIIIllllIIII, final EnumFacing lllllllllllllIllllIIIIIIlllIlIlI) {
        final IBlockState lllllllllllllIllllIIIIIIlllIlllI = lllllllllllllIllllIIIIIIllllIIIl.getBlockState(lllllllllllllIllllIIIIIIllllIIII.offset(lllllllllllllIllllIIIIIIlllIlIlI));
        return !isBlockStairs(lllllllllllllIllllIIIIIIlllIlllI) || lllllllllllllIllllIIIIIIlllIlllI.getValue((IProperty<Comparable>)BlockStairs.FACING) != lllllllllllllIllllIIIIIIlllIllIl.getValue((IProperty<Comparable>)BlockStairs.FACING) || lllllllllllllIllllIIIIIIlllIlllI.getValue(BlockStairs.HALF) != lllllllllllllIllllIIIIIIlllIllIl.getValue(BlockStairs.HALF);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIllllIIIIIIlllIIIlI, final Rotation lllllllllllllIllllIIIIIIlllIIIIl) {
        return lllllllllllllIllllIIIIIIlllIIIlI.withProperty((IProperty<Comparable>)BlockStairs.FACING, lllllllllllllIllllIIIIIIlllIIIIl.rotate(lllllllllllllIllllIIIIIIlllIIIlI.getValue((IProperty<EnumFacing>)BlockStairs.FACING)));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape() {
        final int[] $switch_TABLE$net$minecraft$block$BlockStairs$EnumShape = BlockStairs.$SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape;
        if ($switch_TABLE$net$minecraft$block$BlockStairs$EnumShape != null) {
            return $switch_TABLE$net$minecraft$block$BlockStairs$EnumShape;
        }
        final byte lllllllllllllIllllIIIIIIllIIlIIl = (Object)new int[EnumShape.values().length];
        try {
            lllllllllllllIllllIIIIIIllIIlIIl[EnumShape.INNER_LEFT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIIIIIllIIlIIl[EnumShape.INNER_RIGHT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIIIIIllIIlIIl[EnumShape.OUTER_LEFT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIIIIIIllIIlIIl[EnumShape.OUTER_RIGHT.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIllllIIIIIIllIIlIIl[EnumShape.STRAIGHT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return BlockStairs.$SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape = (int[])(Object)lllllllllllllIllllIIIIIIllIIlIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockStairs.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final String lllllllllllllIllllIIIIIIllIIlIll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIllllIIIIIIllIIlIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIIIIIllIIlIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIIIIIllIIlIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIIIIIIllIIlIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIllllIIIIIIllIIlIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIllllIIIIIIllIIlIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockStairs.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIllllIIIIIIllIIlIll;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllIllllIIIIlIIIlIlllI, final World lllllllllllllIllllIIIIlIIIlIllIl, final BlockPos lllllllllllllIllllIIIIlIIIlIllII, final Random lllllllllllllIllllIIIIlIIIlIlIll) {
        this.modelBlock.randomDisplayTick(lllllllllllllIllllIIIIlIIIlIlllI, lllllllllllllIllllIIIIlIIIlIllIl, lllllllllllllIllllIIIIlIIIlIllII, lllllllllllllIllllIIIIlIIIlIlIll);
    }
    
    private static AxisAlignedBB getCollQuarterBlock(final IBlockState lllllllllllllIllllIIIIlIIllIIIII) {
        final boolean lllllllllllllIllllIIIIlIIlIlllll = lllllllllllllIllllIIIIlIIllIIIII.getValue(BlockStairs.HALF) == EnumHalf.TOP;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIllllIIIIlIIllIIIII.getValue((IProperty<EnumFacing>)BlockStairs.FACING).ordinal()]) {
            default: {
                return lllllllllllllIllllIIIIlIIlIlllll ? BlockStairs.AABB_QTR_BOT_NORTH : BlockStairs.AABB_QTR_TOP_NORTH;
            }
            case 4: {
                return lllllllllllllIllllIIIIlIIlIlllll ? BlockStairs.AABB_QTR_BOT_SOUTH : BlockStairs.AABB_QTR_TOP_SOUTH;
            }
            case 5: {
                return lllllllllllllIllllIIIIlIIlIlllll ? BlockStairs.AABB_QTR_BOT_WEST : BlockStairs.AABB_QTR_TOP_WEST;
            }
            case 6: {
                return lllllllllllllIllllIIIIlIIlIlllll ? BlockStairs.AABB_QTR_BOT_EAST : BlockStairs.AABB_QTR_TOP_EAST;
            }
        }
    }
    
    private static EnumShape getStairsShape(final IBlockState lllllllllllllIllllIIIIIIlllllllI, final IBlockAccess lllllllllllllIllllIIIIIIllllllIl, final BlockPos lllllllllllllIllllIIIIIlIIIIIlII) {
        final EnumFacing lllllllllllllIllllIIIIIlIIIIIIll = lllllllllllllIllllIIIIIIlllllllI.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
        final IBlockState lllllllllllllIllllIIIIIlIIIIIIlI = lllllllllllllIllllIIIIIIllllllIl.getBlockState(lllllllllllllIllllIIIIIlIIIIIlII.offset(lllllllllllllIllllIIIIIlIIIIIIll));
        if (isBlockStairs(lllllllllllllIllllIIIIIlIIIIIIlI) && lllllllllllllIllllIIIIIIlllllllI.getValue(BlockStairs.HALF) == lllllllllllllIllllIIIIIlIIIIIIlI.getValue(BlockStairs.HALF)) {
            final EnumFacing lllllllllllllIllllIIIIIlIIIIIIIl = lllllllllllllIllllIIIIIlIIIIIIlI.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
            if (lllllllllllllIllllIIIIIlIIIIIIIl.getAxis() != lllllllllllllIllllIIIIIIlllllllI.getValue((IProperty<EnumFacing>)BlockStairs.FACING).getAxis() && isDifferentStairs(lllllllllllllIllllIIIIIIlllllllI, lllllllllllllIllllIIIIIIllllllIl, lllllllllllllIllllIIIIIlIIIIIlII, lllllllllllllIllllIIIIIlIIIIIIIl.getOpposite())) {
                if (lllllllllllllIllllIIIIIlIIIIIIIl == lllllllllllllIllllIIIIIlIIIIIIll.rotateYCCW()) {
                    return EnumShape.OUTER_LEFT;
                }
                return EnumShape.OUTER_RIGHT;
            }
        }
        final IBlockState lllllllllllllIllllIIIIIlIIIIIIII = lllllllllllllIllllIIIIIIllllllIl.getBlockState(lllllllllllllIllllIIIIIlIIIIIlII.offset(lllllllllllllIllllIIIIIlIIIIIIll.getOpposite()));
        if (isBlockStairs(lllllllllllllIllllIIIIIlIIIIIIII) && lllllllllllllIllllIIIIIIlllllllI.getValue(BlockStairs.HALF) == lllllllllllllIllllIIIIIlIIIIIIII.getValue(BlockStairs.HALF)) {
            final EnumFacing lllllllllllllIllllIIIIIIllllllll = lllllllllllllIllllIIIIIlIIIIIIII.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
            if (lllllllllllllIllllIIIIIIllllllll.getAxis() != lllllllllllllIllllIIIIIIlllllllI.getValue((IProperty<EnumFacing>)BlockStairs.FACING).getAxis() && isDifferentStairs(lllllllllllllIllllIIIIIIlllllllI, lllllllllllllIllllIIIIIIllllllIl, lllllllllllllIllllIIIIIlIIIIIlII, lllllllllllllIllllIIIIIIllllllll)) {
                if (lllllllllllllIllllIIIIIIllllllll == lllllllllllllIllllIIIIIlIIIIIIll.rotateYCCW()) {
                    return EnumShape.INNER_LEFT;
                }
                return EnumShape.INNER_RIGHT;
            }
        }
        return EnumShape.STRAIGHT;
    }
    
    @Override
    public void updateTick(final World lllllllllllllIllllIIIIIllIIllIll, final BlockPos lllllllllllllIllllIIIIIllIIlllll, final IBlockState lllllllllllllIllllIIIIIllIIllIIl, final Random lllllllllllllIllllIIIIIllIIlllIl) {
        this.modelBlock.updateTick(lllllllllllllIllllIIIIIllIIllIll, lllllllllllllIllllIIIIIllIIlllll, lllllllllllllIllllIIIIIllIIllIIl, lllllllllllllIllllIIIIIllIIlllIl);
    }
    
    @Override
    public boolean isCollidable() {
        return this.modelBlock.isCollidable();
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIllllIIIIlIIIllIlll) {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIllllIIIIIlllIIlIll, final BlockPos lllllllllllllIllllIIIIIlllIIlIlI) {
        return this.modelBlock.canPlaceBlockAt(lllllllllllllIllllIIIIIlllIIlIll, lllllllllllllIllllIIIIIlllIIlIlI);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIllllIIIIlIIlIIIlIl, IBlockState lllllllllllllIllllIIIIlIIIllllIl, final BlockPos lllllllllllllIllllIIIIlIIIllllII, final EnumFacing lllllllllllllIllllIIIIlIIlIIIIlI) {
        lllllllllllllIllllIIIIlIIIllllIl = this.getActualState(lllllllllllllIllllIIIIlIIIllllIl, lllllllllllllIllllIIIIlIIlIIIlIl, lllllllllllllIllllIIIIlIIIllllII);
        if (lllllllllllllIllllIIIIlIIlIIIIlI.getAxis() == EnumFacing.Axis.Y) {
            return (lllllllllllllIllllIIIIlIIlIIIIlI == EnumFacing.UP == (lllllllllllllIllllIIIIlIIIllllIl.getValue(BlockStairs.HALF) == EnumHalf.TOP)) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
        }
        final EnumShape lllllllllllllIllllIIIIlIIlIIIIIl = lllllllllllllIllllIIIIlIIIllllIl.getValue(BlockStairs.SHAPE);
        if (lllllllllllllIllllIIIIlIIlIIIIIl == EnumShape.OUTER_LEFT || lllllllllllllIllllIIIIlIIlIIIIIl == EnumShape.OUTER_RIGHT) {
            return BlockFaceShape.UNDEFINED;
        }
        final EnumFacing lllllllllllllIllllIIIIlIIlIIIIII = lllllllllllllIllllIIIIlIIIllllIl.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape()[lllllllllllllIllllIIIIlIIlIIIIIl.ordinal()]) {
            case 3: {
                return (lllllllllllllIllllIIIIlIIlIIIIII != lllllllllllllIllllIIIIlIIlIIIIlI && lllllllllllllIllllIIIIlIIlIIIIII != lllllllllllllIllllIIIIlIIlIIIIlI.rotateYCCW()) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
            }
            case 2: {
                return (lllllllllllllIllllIIIIlIIlIIIIII != lllllllllllllIllllIIIIlIIlIIIIlI && lllllllllllllIllllIIIIlIIlIIIIII != lllllllllllllIllllIIIIlIIlIIIIlI.rotateY()) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
            }
            case 1: {
                return (lllllllllllllIllllIIIIlIIlIIIIII == lllllllllllllIllllIIIIlIIlIIIIlI) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
            }
            default: {
                return BlockFaceShape.UNDEFINED;
            }
        }
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final IBlockState lllllllllllllIllllIIIIIlllllIIII, final World lllllllllllllIllllIIIIIllllIllII, final BlockPos lllllllllllllIllllIIIIIllllIlIll) {
        return this.modelState.getSelectedBoundingBox(lllllllllllllIllllIIIIIllllIllII, lllllllllllllIllllIIIIIllllIlIll);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllllIIIIIlIIIllIll) {
        int lllllllllllllIllllIIIIIlIIIllIlI = 0;
        if (lllllllllllllIllllIIIIIlIIIllIll.getValue(BlockStairs.HALF) == EnumHalf.TOP) {
            lllllllllllllIllllIIIIIlIIIllIlI |= 0x4;
        }
        lllllllllllllIllllIIIIIlIIIllIlI |= 5 - lllllllllllllIllllIIIIIlIIIllIll.getValue((IProperty<EnumFacing>)BlockStairs.FACING).getIndex();
        return lllllllllllllIllllIIIIIlIIIllIlI;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllIllllIIIIIlIIIlIIII, final IBlockAccess lllllllllllllIllllIIIIIlIIIlIIlI, final BlockPos lllllllllllllIllllIIIIIlIIIlIIIl) {
        return lllllllllllllIllllIIIIIlIIIlIIII.withProperty(BlockStairs.SHAPE, getStairsShape(lllllllllllllIllllIIIIIlIIIlIIII, lllllllllllllIllllIIIIIlIIIlIIlI, lllllllllllllIllllIIIIIlIIIlIIIl));
    }
    
    @Override
    public void onEntityWalk(final World lllllllllllllIllllIIIIIllIlIllIl, final BlockPos lllllllllllllIllllIIIIIllIlIlIII, final Entity lllllllllllllIllllIIIIIllIlIIlll) {
        this.modelBlock.onEntityWalk(lllllllllllllIllllIIIIIllIlIllIl, lllllllllllllIllllIIIIIllIlIlIII, lllllllllllllIllllIIIIIllIlIIlll);
    }
    
    @Override
    public int getPackedLightmapCoords(final IBlockState lllllllllllllIllllIIIIlIIIIIlIIl, final IBlockAccess lllllllllllllIllllIIIIlIIIIIlIII, final BlockPos lllllllllllllIllllIIIIlIIIIIIlll) {
        return this.modelState.getPackedLightmapCoords(lllllllllllllIllllIIIIlIIIIIlIII, lllllllllllllIllllIIIIlIIIIIIlll);
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState lllllllllllllIllllIIIIlIIlllIllI, final World lllllllllllllIllllIIIIlIIllllllI, final BlockPos lllllllllllllIllllIIIIlIIlllIlII, final AxisAlignedBB lllllllllllllIllllIIIIlIIlllIIll, final List<AxisAlignedBB> lllllllllllllIllllIIIIlIIllllIll, @Nullable final Entity lllllllllllllIllllIIIIlIIllllIlI, final boolean lllllllllllllIllllIIIIlIIllllIIl) {
        if (!lllllllllllllIllllIIIIlIIllllIIl) {
            lllllllllllllIllllIIIIlIIlllIllI = this.getActualState(lllllllllllllIllllIIIIlIIlllIllI, lllllllllllllIllllIIIIlIIllllllI, lllllllllllllIllllIIIIlIIlllIlII);
        }
        for (final AxisAlignedBB lllllllllllllIllllIIIIlIIllllIII : getCollisionBoxList(lllllllllllllIllllIIIIlIIlllIllI)) {
            Block.addCollisionBoxToList(lllllllllllllIllllIIIIlIIlllIlII, lllllllllllllIllllIIIIlIIlllIIll, lllllllllllllIllllIIIIlIIllllIll, lllllllllllllIllllIIIIlIIllllIII);
        }
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIllllIIIIIllIlllllI, final BlockPos lllllllllllllIllllIIIIIllIllllIl, final IBlockState lllllllllllllIllllIIIIIlllIIIIII) {
        this.modelState.neighborChanged(lllllllllllllIllllIIIIIllIlllllI, lllllllllllllIllllIIIIIllIllllIl, Blocks.AIR, lllllllllllllIllllIIIIIllIllllIl);
        this.modelBlock.onBlockAdded(lllllllllllllIllllIIIIIllIlllllI, lllllllllllllIllllIIIIIllIllllIl, this.modelState);
    }
    
    public static boolean isBlockStairs(final IBlockState lllllllllllllIllllIIIIIIlllIIlll) {
        return lllllllllllllIllllIIIIIIlllIIlll.getBlock() instanceof BlockStairs;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIllllIIIIIIllIlIIll, final Mirror lllllllllllllIllllIIIIIIllIlIlll) {
        final EnumFacing lllllllllllllIllllIIIIIIllIlIllI = lllllllllllllIllllIIIIIIllIlIIll.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
        final EnumShape lllllllllllllIllllIIIIIIllIlIlIl = lllllllllllllIllllIIIIIIllIlIIll.getValue(BlockStairs.SHAPE);
        Label_0346: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllIllllIIIIIIllIlIlll.ordinal()]) {
                case 2: {
                    if (lllllllllllllIllllIIIIIIllIlIllI.getAxis() != EnumFacing.Axis.Z) {
                        break;
                    }
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape()[lllllllllllllIllllIIIIIIllIlIlIl.ordinal()]) {
                        case 4: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.OUTER_RIGHT);
                        }
                        case 5: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.OUTER_LEFT);
                        }
                        case 3: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.INNER_LEFT);
                        }
                        case 2: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.INNER_RIGHT);
                        }
                        default: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180);
                        }
                    }
                    break;
                }
                case 3: {
                    if (lllllllllllllIllllIIIIIIllIlIllI.getAxis() != EnumFacing.Axis.X) {
                        break;
                    }
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape()[lllllllllllllIllllIIIIIIllIlIlIl.ordinal()]) {
                        case 4: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.OUTER_RIGHT);
                        }
                        case 5: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.OUTER_LEFT);
                        }
                        case 3: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.INNER_RIGHT);
                        }
                        case 2: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180).withProperty(BlockStairs.SHAPE, EnumShape.INNER_LEFT);
                        }
                        case 1: {
                            return lllllllllllllIllllIIIIIIllIlIIll.withRotation(Rotation.CLOCKWISE_180);
                        }
                        default: {
                            break Label_0346;
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(lllllllllllllIllllIIIIIIllIlIIll, lllllllllllllIllllIIIIIIllIlIlll);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIllllIIIIIllIIlIIIl, final BlockPos lllllllllllllIllllIIIIIllIIIIllI, final IBlockState lllllllllllllIllllIIIIIllIIIllll, final EntityPlayer lllllllllllllIllllIIIIIllIIIIlIl, final EnumHand lllllllllllllIllllIIIIIllIIIIlII, final EnumFacing lllllllllllllIllllIIIIIllIIIllII, final float lllllllllllllIllllIIIIIllIIIlIll, final float lllllllllllllIllllIIIIIllIIIlIlI, final float lllllllllllllIllllIIIIIllIIIlIIl) {
        return this.modelBlock.onBlockActivated(lllllllllllllIllllIIIIIllIIlIIIl, lllllllllllllIllllIIIIIllIIIIllI, this.modelState, lllllllllllllIllllIIIIIllIIIIlIl, lllllllllllllIllllIIIIIllIIIIlII, EnumFacing.DOWN, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World lllllllllllllIllllIIIIlIIIIlIlII, final BlockPos lllllllllllllIllllIIIIlIIIIIllll, final IBlockState lllllllllllllIllllIIIIlIIIIIlllI) {
        this.modelBlock.onBlockDestroyedByPlayer(lllllllllllllIllllIIIIlIIIIlIlII, lllllllllllllIllllIIIIlIIIIIllll, lllllllllllllIllllIIIIlIIIIIlllI);
    }
    
    @Override
    public int tickRate(final World lllllllllllllIllllIIIIIlllllIlIl) {
        return this.modelBlock.tickRate(lllllllllllllIllllIIIIIlllllIlIl);
    }
    
    @Override
    public void onBlockDestroyedByExplosion(final World lllllllllllllIllllIIIIIlIllllllI, final BlockPos lllllllllllllIllllIIIIIlIllllIIl, final Explosion lllllllllllllIllllIIIIIlIllllIII) {
        this.modelBlock.onBlockDestroyedByExplosion(lllllllllllllIllllIIIIIlIllllllI, lllllllllllllIllllIIIIIlIllllIIl, lllllllllllllIllllIIIIIlIllllIII);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllllIIIIIlIIlIIIll) {
        IBlockState lllllllllllllIllllIIIIIlIIlIIIlI = this.getDefaultState().withProperty(BlockStairs.HALF, ((lllllllllllllIllllIIIIIlIIlIIIll & 0x4) > 0) ? EnumHalf.TOP : EnumHalf.BOTTOM);
        lllllllllllllIllllIIIIIlIIlIIIlI = lllllllllllllIllllIIIIIlIIlIIIlI.withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.getFront(5 - (lllllllllllllIllllIIIIIlIIlIIIll & 0x3)));
        return lllllllllllllIllllIIIIIlIIlIIIlI;
    }
    
    private static List<AxisAlignedBB> getCollisionBoxList(final IBlockState lllllllllllllIllllIIIIlIIllIlIlI) {
        final List<AxisAlignedBB> lllllllllllllIllllIIIIlIIllIlIIl = (List<AxisAlignedBB>)Lists.newArrayList();
        final boolean lllllllllllllIllllIIIIlIIllIlIII = lllllllllllllIllllIIIIlIIllIlIlI.getValue(BlockStairs.HALF) == EnumHalf.TOP;
        lllllllllllllIllllIIIIlIIllIlIIl.add(lllllllllllllIllllIIIIlIIllIlIII ? BlockStairs.AABB_SLAB_TOP : BlockStairs.AABB_SLAB_BOTTOM);
        final EnumShape lllllllllllllIllllIIIIlIIllIIlll = lllllllllllllIllllIIIIlIIllIlIlI.getValue(BlockStairs.SHAPE);
        if (lllllllllllllIllllIIIIlIIllIIlll == EnumShape.STRAIGHT || lllllllllllllIllllIIIIlIIllIIlll == EnumShape.INNER_LEFT || lllllllllllllIllllIIIIlIIllIIlll == EnumShape.INNER_RIGHT) {
            lllllllllllllIllllIIIIlIIllIlIIl.add(getCollQuarterBlock(lllllllllllllIllllIIIIlIIllIlIlI));
        }
        if (lllllllllllllIllllIIIIlIIllIIlll != EnumShape.STRAIGHT) {
            lllllllllllllIllllIIIIlIIllIlIIl.add(getCollEighthBlock(lllllllllllllIllllIIIIlIIllIlIlI));
        }
        return lllllllllllllIllllIIIIlIIllIlIIl;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return this.modelBlock.getBlockLayer();
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIllllIIIIlIIIllIlIl) {
        return false;
    }
    
    @Nullable
    @Override
    public RayTraceResult collisionRayTrace(final IBlockState lllllllllllllIllllIIIIIlIIlllllI, final World lllllllllllllIllllIIIIIlIIllllIl, final BlockPos lllllllllllllIllllIIIIIlIIllIIII, final Vec3d lllllllllllllIllllIIIIIlIIlIllll, final Vec3d lllllllllllllIllllIIIIIlIIlllIlI) {
        final List<RayTraceResult> lllllllllllllIllllIIIIIlIIlllIIl = (List<RayTraceResult>)Lists.newArrayList();
        for (final AxisAlignedBB lllllllllllllIllllIIIIIlIIlllIII : getCollisionBoxList(this.getActualState(lllllllllllllIllllIIIIIlIIlllllI, lllllllllllllIllllIIIIIlIIllllIl, lllllllllllllIllllIIIIIlIIllIIII))) {
            lllllllllllllIllllIIIIIlIIlllIIl.add(this.rayTrace(lllllllllllllIllllIIIIIlIIllIIII, lllllllllllllIllllIIIIIlIIlIllll, lllllllllllllIllllIIIIIlIIlllIlI, lllllllllllllIllllIIIIIlIIlllIII));
        }
        RayTraceResult lllllllllllllIllllIIIIIlIIllIlll = null;
        double lllllllllllllIllllIIIIIlIIllIllI = 0.0;
        for (final RayTraceResult lllllllllllllIllllIIIIIlIIllIlIl : lllllllllllllIllllIIIIIlIIlllIIl) {
            if (lllllllllllllIllllIIIIIlIIllIlIl != null) {
                final double lllllllllllllIllllIIIIIlIIllIlII = lllllllllllllIllllIIIIIlIIllIlIl.hitVec.squareDistanceTo(lllllllllllllIllllIIIIIlIIlllIlI);
                if (lllllllllllllIllllIIIIIlIIllIlII <= lllllllllllllIllllIIIIIlIIllIllI) {
                    continue;
                }
                lllllllllllllIllllIIIIIlIIllIlll = lllllllllllllIllllIIIIIlIIllIlIl;
                lllllllllllllIllllIIIIIlIIllIllI = lllllllllllllIllllIIIIIlIIllIlII;
            }
        }
        return lllllllllllllIllllIIIIIlIIllIlll;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIllllIIIIIlIllIllll, final IBlockAccess lllllllllllllIllllIIIIIlIllIlIll, final BlockPos lllllllllllllIllllIIIIIlIllIlIlI) {
        return this.modelBlock.getMapColor(this.modelState, lllllllllllllIllllIIIIIlIllIlIll, lllllllllllllIllllIIIIIlIllIlIlI);
    }
    
    private static AxisAlignedBB getCollEighthBlock(final IBlockState lllllllllllllIllllIIIIlIIlIlIIIl) {
        final EnumFacing lllllllllllllIllllIIIIlIIlIlIlll = lllllllllllllIllllIIIIlIIlIlIIIl.getValue((IProperty<EnumFacing>)BlockStairs.FACING);
        final EnumFacing lllllllllllllIllllIIIIlIIlIlIIll;
        switch ($SWITCH_TABLE$net$minecraft$block$BlockStairs$EnumShape()[lllllllllllllIllllIIIIlIIlIlIIIl.getValue(BlockStairs.SHAPE).ordinal()]) {
            default: {
                final EnumFacing lllllllllllllIllllIIIIlIIlIlIllI = lllllllllllllIllllIIIIlIIlIlIlll;
                break;
            }
            case 5: {
                final EnumFacing lllllllllllllIllllIIIIlIIlIlIlIl = lllllllllllllIllllIIIIlIIlIlIlll.rotateY();
                break;
            }
            case 3: {
                final EnumFacing lllllllllllllIllllIIIIlIIlIlIlII = lllllllllllllIllllIIIIlIIlIlIlll.getOpposite();
                break;
            }
            case 2: {
                lllllllllllllIllllIIIIlIIlIlIIll = lllllllllllllIllllIIIIlIIlIlIlll.rotateYCCW();
                break;
            }
        }
        final boolean lllllllllllllIllllIIIIlIIlIlIIlI = lllllllllllllIllllIIIIlIIlIlIIIl.getValue(BlockStairs.HALF) == EnumHalf.TOP;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIllllIIIIlIIlIlIIll.ordinal()]) {
            default: {
                return lllllllllllllIllllIIIIlIIlIlIIlI ? BlockStairs.AABB_OCT_BOT_NW : BlockStairs.AABB_OCT_TOP_NW;
            }
            case 4: {
                return lllllllllllllIllllIIIIlIIlIlIIlI ? BlockStairs.AABB_OCT_BOT_SE : BlockStairs.AABB_OCT_TOP_SE;
            }
            case 5: {
                return lllllllllllllIllllIIIIlIIlIlIIlI ? BlockStairs.AABB_OCT_BOT_SW : BlockStairs.AABB_OCT_TOP_SW;
            }
            case 6: {
                return lllllllllllllIllllIIIIlIIlIlIIlI ? BlockStairs.AABB_OCT_BOT_NE : BlockStairs.AABB_OCT_TOP_NE;
            }
        }
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllllIllllIIIIIlIlllIlIl) {
        return lllllllllllllIllllIIIIIlIlllIlIl.getValue(BlockStairs.HALF) == EnumHalf.TOP;
    }
    
    public enum EnumHalf implements IStringSerializable
    {
        private final /* synthetic */ String name;
        
        BOTTOM("BOTTOM", 1, "bottom"), 
        TOP("TOP", 0, "top");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumHalf(final String lllllllllllllIlIlIIlIIlIlIIlllll, final int lllllllllllllIlIlIIlIIlIlIIllllI, final String lllllllllllllIlIlIIlIIlIlIIlllIl) {
            this.name = lllllllllllllIlIlIIlIIlIlIIlllIl;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
    
    public enum EnumShape implements IStringSerializable
    {
        STRAIGHT("STRAIGHT", 0, "straight");
        
        private final /* synthetic */ String name;
        
        OUTER_LEFT("OUTER_LEFT", 3, "outer_left"), 
        INNER_LEFT("INNER_LEFT", 1, "inner_left"), 
        INNER_RIGHT("INNER_RIGHT", 2, "inner_right"), 
        OUTER_RIGHT("OUTER_RIGHT", 4, "outer_right");
        
        private EnumShape(final String lllllllllllllIllIIlIIIlIIlllIlII, final int lllllllllllllIllIIlIIIlIIlllIIll, final String lllllllllllllIllIIlIIIlIIlllIllI) {
            this.name = lllllllllllllIllIIlIIIlIIlllIllI;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
