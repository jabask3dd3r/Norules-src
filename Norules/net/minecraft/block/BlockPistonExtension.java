package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class BlockPistonExtension extends BlockDirectional
{
    protected static final /* synthetic */ AxisAlignedBB DOWN_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB field_190965_K;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    protected static final /* synthetic */ AxisAlignedBB EAST_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_DOWN_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB NORTH_ARM_AABB;
    public static final /* synthetic */ PropertyEnum<EnumPistonType> TYPE;
    protected static final /* synthetic */ AxisAlignedBB field_190964_J;
    protected static final /* synthetic */ AxisAlignedBB field_190969_O;
    protected static final /* synthetic */ AxisAlignedBB field_190967_M;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB field_190966_L;
    protected static final /* synthetic */ AxisAlignedBB field_190968_N;
    public static final /* synthetic */ PropertyBool SHORT;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB WEST_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_UP_AABB;
    protected static final /* synthetic */ AxisAlignedBB UP_ARM_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_EXTENSION_WEST_AABB;
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIlIllIIIlllIllllllI, final IBlockState lllllllllllllIlIllIIIlllIllllIlI, final BlockPos lllllllllllllIlIllIIIlllIlllllII, final EnumFacing lllllllllllllIlIllIIIlllIllllIIl) {
        return (lllllllllllllIlIllIIIlllIllllIIl == lllllllllllllIlIllIIIlllIllllIlI.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING)) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIlIllIIIllllIIIllll, final Rotation lllllllllllllIlIllIIIllllIIIllII) {
        return lllllllllllllIlIllIIIllllIIIllll.withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, lllllllllllllIlIllIIIllllIIIllII.rotate(lllllllllllllIlIllIIIllllIIIllll.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING)));
    }
    
    private AxisAlignedBB getArmShape(final IBlockState lllllllllllllIlIllIIlIIIIIIIIIll) {
        final boolean lllllllllllllIlIllIIlIIIIIIIIlII = lllllllllllllIlIllIIlIIIIIIIIIll.getValue((IProperty<Boolean>)BlockPistonExtension.SHORT);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlIllIIlIIIIIIIIIll.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).ordinal()]) {
            default: {
                return lllllllllllllIlIllIIlIIIIIIIIlII ? BlockPistonExtension.field_190965_K : BlockPistonExtension.DOWN_ARM_AABB;
            }
            case 2: {
                return lllllllllllllIlIllIIlIIIIIIIIlII ? BlockPistonExtension.field_190964_J : BlockPistonExtension.UP_ARM_AABB;
            }
            case 3: {
                return lllllllllllllIlIllIIlIIIIIIIIlII ? BlockPistonExtension.field_190967_M : BlockPistonExtension.NORTH_ARM_AABB;
            }
            case 4: {
                return lllllllllllllIlIllIIlIIIIIIIIlII ? BlockPistonExtension.field_190966_L : BlockPistonExtension.SOUTH_ARM_AABB;
            }
            case 5: {
                return lllllllllllllIlIllIIlIIIIIIIIlII ? BlockPistonExtension.field_190969_O : BlockPistonExtension.WEST_ARM_AABB;
            }
            case 6: {
                return lllllllllllllIlIllIIlIIIIIIIIlII ? BlockPistonExtension.field_190968_N : BlockPistonExtension.EAST_ARM_AABB;
            }
        }
    }
    
    static {
        TYPE = PropertyEnum.create("type", EnumPistonType.class);
        SHORT = PropertyBool.create("short");
        PISTON_EXTENSION_EAST_AABB = new AxisAlignedBB(0.75, 0.0, 0.0, 1.0, 1.0, 1.0);
        PISTON_EXTENSION_WEST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.25, 1.0, 1.0);
        PISTON_EXTENSION_SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.75, 1.0, 1.0, 1.0);
        PISTON_EXTENSION_NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.25);
        PISTON_EXTENSION_UP_AABB = new AxisAlignedBB(0.0, 0.75, 0.0, 1.0, 1.0, 1.0);
        PISTON_EXTENSION_DOWN_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0);
        UP_ARM_AABB = new AxisAlignedBB(0.375, -0.25, 0.375, 0.625, 0.75, 0.625);
        DOWN_ARM_AABB = new AxisAlignedBB(0.375, 0.25, 0.375, 0.625, 1.25, 0.625);
        SOUTH_ARM_AABB = new AxisAlignedBB(0.375, 0.375, -0.25, 0.625, 0.625, 0.75);
        NORTH_ARM_AABB = new AxisAlignedBB(0.375, 0.375, 0.25, 0.625, 0.625, 1.25);
        EAST_ARM_AABB = new AxisAlignedBB(-0.25, 0.375, 0.375, 0.75, 0.625, 0.625);
        WEST_ARM_AABB = new AxisAlignedBB(0.25, 0.375, 0.375, 1.25, 0.625, 0.625);
        field_190964_J = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 0.75, 0.625);
        field_190965_K = new AxisAlignedBB(0.375, 0.25, 0.375, 0.625, 1.0, 0.625);
        field_190966_L = new AxisAlignedBB(0.375, 0.375, 0.0, 0.625, 0.625, 0.75);
        field_190967_M = new AxisAlignedBB(0.375, 0.375, 0.25, 0.625, 0.625, 1.0);
        field_190968_N = new AxisAlignedBB(0.0, 0.375, 0.375, 0.75, 0.625, 0.625);
        field_190969_O = new AxisAlignedBB(0.25, 0.375, 0.375, 1.0, 0.625, 0.625);
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllIlIllIIIlllllIIlllI, final BlockPos lllllllllllllIlIllIIIlllllIIllIl, final EnumFacing lllllllllllllIlIllIIIlllllIIllII) {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIlIllIIIlllllIlIIIl, final BlockPos lllllllllllllIlIllIIIlllllIlIIII) {
        return false;
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllIlIllIIIllllllIlllI, final BlockPos lllllllllllllIlIllIIIlllllllIlII, final IBlockState lllllllllllllIlIllIIIlllllllIIll, final EntityPlayer lllllllllllllIlIllIIIllllllIlIll) {
        if (lllllllllllllIlIllIIIllllllIlIll.capabilities.isCreativeMode) {
            final BlockPos lllllllllllllIlIllIIIlllllllIIIl = lllllllllllllIlIllIIIlllllllIlII.offset(lllllllllllllIlIllIIIlllllllIIll.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).getOpposite());
            final Block lllllllllllllIlIllIIIlllllllIIII = lllllllllllllIlIllIIIllllllIlllI.getBlockState(lllllllllllllIlIllIIIlllllllIIIl).getBlock();
            if (lllllllllllllIlIllIIIlllllllIIII == Blocks.PISTON || lllllllllllllIlIllIIIlllllllIIII == Blocks.STICKY_PISTON) {
                lllllllllllllIlIllIIIllllllIlllI.setBlockToAir(lllllllllllllIlIllIIIlllllllIIIl);
            }
        }
        super.onBlockHarvested(lllllllllllllIlIllIIIllllllIlllI, lllllllllllllIlIllIIIlllllllIlII, lllllllllllllIlIllIIIlllllllIIll, lllllllllllllIlIllIIIllllllIlIll);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlIllIIIllllIlIIIll, final BlockPos lllllllllllllIlIllIIIllllIlIIIlI, final IBlockState lllllllllllllIlIllIIIllllIlIIIIl) {
        return new ItemStack((lllllllllllllIlIllIIIllllIlIIIIl.getValue(BlockPistonExtension.TYPE) == EnumPistonType.STICKY) ? Blocks.STICKY_PISTON : Blocks.PISTON);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllIlIllIIIllllIlIllll, final IBlockAccess lllllllllllllIlIllIIIllllIlIlllI, final BlockPos lllllllllllllIlIllIIIllllIlIllIl, final EnumFacing lllllllllllllIlIllIIIllllIlIllII) {
        return true;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIlIllIIIllllIlllIII, final World lllllllllllllIlIllIIIllllIllIlll, final BlockPos lllllllllllllIlIllIIIllllIlllllI, final Block lllllllllllllIlIllIIIllllIllIlIl, final BlockPos lllllllllllllIlIllIIIllllIllllII) {
        final EnumFacing lllllllllllllIlIllIIIllllIlllIll = lllllllllllllIlIllIIIllllIlllIII.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING);
        final BlockPos lllllllllllllIlIllIIIllllIlllIlI = lllllllllllllIlIllIIIllllIlllllI.offset(lllllllllllllIlIllIIIllllIlllIll.getOpposite());
        final IBlockState lllllllllllllIlIllIIIllllIlllIIl = lllllllllllllIlIllIIIllllIllIlll.getBlockState(lllllllllllllIlIllIIIllllIlllIlI);
        if (lllllllllllllIlIllIIIllllIlllIIl.getBlock() != Blocks.PISTON && lllllllllllllIlIllIIIllllIlllIIl.getBlock() != Blocks.STICKY_PISTON) {
            lllllllllllllIlIllIIIllllIllIlll.setBlockToAir(lllllllllllllIlIllIIIllllIlllllI);
        }
        else {
            lllllllllllllIlIllIIIllllIlllIIl.neighborChanged(lllllllllllllIlIllIIIllllIllIlll, lllllllllllllIlIllIIIllllIlllIlI, lllllllllllllIlIllIIIllllIllIlIl, lllllllllllllIlIllIIIllllIllllII);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIllIIIllllIIllIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, getFacing(lllllllllllllIlIllIIIllllIIllIlI)).withProperty(BlockPistonExtension.TYPE, ((lllllllllllllIlIllIIIllllIIllIlI & 0x8) > 0) ? EnumPistonType.STICKY : EnumPistonType.DEFAULT);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIlIllIIIlllllIlIIll) {
        return false;
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllllIlIllIIIlllllllllll) {
        return lllllllllllllIlIllIIIlllllllllll.getValue((IProperty<Comparable>)BlockPistonExtension.FACING) == EnumFacing.UP;
    }
    
    public BlockPistonExtension() {
        super(Material.PISTON);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, EnumFacing.NORTH).withProperty(BlockPistonExtension.TYPE, EnumPistonType.DEFAULT).withProperty((IProperty<Comparable>)BlockPistonExtension.SHORT, false));
        this.setSoundType(SoundType.STONE);
        this.setHardness(0.5f);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIlIllIIIlllllIIlIlI) {
        return 0;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIlIllIIIlllllIllIll, BlockPos lllllllllllllIlIllIIIlllllIllIlI, final IBlockState lllllllllllllIlIllIIIlllllIlllll) {
        super.breakBlock(lllllllllllllIlIllIIIlllllIllIll, lllllllllllllIlIllIIIlllllIllIlI, lllllllllllllIlIllIIIlllllIlllll);
        final EnumFacing lllllllllllllIlIllIIIlllllIllllI = lllllllllllllIlIllIIIlllllIlllll.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).getOpposite();
        lllllllllllllIlIllIIIlllllIllIlI = lllllllllllllIlIllIIIlllllIllIlI.offset(lllllllllllllIlIllIIIlllllIllllI);
        final IBlockState lllllllllllllIlIllIIIlllllIlllIl = lllllllllllllIlIllIIIlllllIllIll.getBlockState(lllllllllllllIlIllIIIlllllIllIlI);
        if ((lllllllllllllIlIllIIIlllllIlllIl.getBlock() == Blocks.PISTON || lllllllllllllIlIllIIIlllllIlllIl.getBlock() == Blocks.STICKY_PISTON) && lllllllllllllIlIllIIIlllllIlllIl.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            lllllllllllllIlIllIIIlllllIlllIl.getBlock().dropBlockAsItem(lllllllllllllIlIllIIIlllllIllIll, lllllllllllllIlIllIIIlllllIllIlI, lllllllllllllIlIllIIIlllllIlllIl, 0);
            lllllllllllllIlIllIIIlllllIllIll.setBlockToAir(lllllllllllllIlIllIIIlllllIllIlI);
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIlIllIIIllllIIIIllI, final Mirror lllllllllllllIlIllIIIllllIIIIlIl) {
        return lllllllllllllIlIllIIIllllIIIIllI.withRotation(lllllllllllllIlIllIIIllllIIIIlIl.toRotation(lllllllllllllIlIllIIIllllIIIIllI.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING)));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIlIllIIIlllllIlIlIl) {
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockPistonExtension.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final int lllllllllllllIlIllIIIlllIlllIlll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIlIllIIIlllIlllIlll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIllIIIlllIlllIlll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIllIIIlllIlllIlll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIllIIIlllIlllIlll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIllIIIlllIlllIlll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlIllIIIlllIlllIlll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockPistonExtension.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIlIllIIIlllIlllIlll;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPistonExtension.FACING, BlockPistonExtension.TYPE, BlockPistonExtension.SHORT });
    }
    
    @Nullable
    public static EnumFacing getFacing(final int lllllllllllllIlIllIIIllllIlIlIIl) {
        final int lllllllllllllIlIllIIIllllIlIlIII = lllllllllllllIlIllIIIllllIlIlIIl & 0x7;
        return (lllllllllllllIlIllIIIllllIlIlIII > 5) ? null : EnumFacing.getFront(lllllllllllllIlIllIIIllllIlIlIII);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIllIIIllllIIlIlII) {
        int lllllllllllllIlIllIIIllllIIlIlIl = 0;
        lllllllllllllIlIllIIIllllIIlIlIl |= lllllllllllllIlIllIIIllllIIlIlII.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).getIndex();
        if (lllllllllllllIlIllIIIllllIIlIlII.getValue(BlockPistonExtension.TYPE) == EnumPistonType.STICKY) {
            lllllllllllllIlIllIIIllllIIlIlIl |= 0x8;
        }
        return lllllllllllllIlIllIIIllllIIlIlIl;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIlIllIIlIIIIIIlllIl, final IBlockAccess lllllllllllllIlIllIIlIIIIIIlllll, final BlockPos lllllllllllllIlIllIIlIIIIIIllllI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlIllIIlIIIIIIlllIl.getValue((IProperty<EnumFacing>)BlockPistonExtension.FACING).ordinal()]) {
            default: {
                return BlockPistonExtension.PISTON_EXTENSION_DOWN_AABB;
            }
            case 2: {
                return BlockPistonExtension.PISTON_EXTENSION_UP_AABB;
            }
            case 3: {
                return BlockPistonExtension.PISTON_EXTENSION_NORTH_AABB;
            }
            case 4: {
                return BlockPistonExtension.PISTON_EXTENSION_SOUTH_AABB;
            }
            case 5: {
                return BlockPistonExtension.PISTON_EXTENSION_WEST_AABB;
            }
            case 6: {
                return BlockPistonExtension.PISTON_EXTENSION_EAST_AABB;
            }
        }
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllllIlIllIIlIIIIIIlIlIl, final World lllllllllllllIlIllIIlIIIIIIIllII, final BlockPos lllllllllllllIlIllIIlIIIIIIIlIll, final AxisAlignedBB lllllllllllllIlIllIIlIIIIIIlIIlI, final List<AxisAlignedBB> lllllllllllllIlIllIIlIIIIIIlIIIl, @Nullable final Entity lllllllllllllIlIllIIlIIIIIIlIIII, final boolean lllllllllllllIlIllIIlIIIIIIIllll) {
        Block.addCollisionBoxToList(lllllllllllllIlIllIIlIIIIIIIlIll, lllllllllllllIlIllIIlIIIIIIlIIlI, lllllllllllllIlIllIIlIIIIIIlIIIl, lllllllllllllIlIllIIlIIIIIIlIlIl.getBoundingBox(lllllllllllllIlIllIIlIIIIIIIllII, lllllllllllllIlIllIIlIIIIIIIlIll));
        Block.addCollisionBoxToList(lllllllllllllIlIllIIlIIIIIIIlIll, lllllllllllllIlIllIIlIIIIIIlIIlI, lllllllllllllIlIllIIlIIIIIIlIIIl, this.getArmShape(lllllllllllllIlIllIIlIIIIIIlIlIl));
    }
    
    public enum EnumPistonType implements IStringSerializable
    {
        STICKY("STICKY", 1, "sticky"), 
        DEFAULT("DEFAULT", 0, "normal");
        
        private final /* synthetic */ String VARIANT;
        
        @Override
        public String getName() {
            return this.VARIANT;
        }
        
        private EnumPistonType(final String llllllllllllllIlIIlIlIlllIllIlII, final int llllllllllllllIlIIlIlIlllIllIIll, final String llllllllllllllIlIIlIlIlllIllIllI) {
            this.VARIANT = llllllllllllllIlIIlIlIlllIllIllI;
        }
        
        @Override
        public String toString() {
            return this.VARIANT;
        }
    }
}
