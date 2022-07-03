package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import javax.annotation.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockTrapDoor extends Block
{
    protected static final /* synthetic */ AxisAlignedBB TOP_AABB;
    protected static final /* synthetic */ AxisAlignedBB EAST_OPEN_AABB;
    public static final /* synthetic */ PropertyBool OPEN;
    public static final /* synthetic */ PropertyEnum<DoorHalf> HALF;
    protected static final /* synthetic */ AxisAlignedBB BOTTOM_AABB;
    protected static final /* synthetic */ AxisAlignedBB NORTH_OPEN_AABB;
    protected static final /* synthetic */ AxisAlignedBB WEST_OPEN_AABB;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_OPEN_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIllIlllIlllIlIlIIII, final Rotation lllllllllllllIllIlllIlllIlIIllIl) {
        return lllllllllllllIllIlllIlllIlIlIIII.withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, lllllllllllllIllIlllIlllIlIIllIl.rotate(lllllllllllllIllIlllIlllIlIlIIII.getValue((IProperty<EnumFacing>)BlockTrapDoor.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllIlllIlllIlIlIlll) {
        int lllllllllllllIllIlllIlllIlIlIllI = 0;
        lllllllllllllIllIlllIlllIlIlIllI |= getMetaForFacing(lllllllllllllIllIlllIlllIlIlIlll.getValue((IProperty<EnumFacing>)BlockTrapDoor.FACING));
        if (lllllllllllllIllIlllIlllIlIlIlll.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN)) {
            lllllllllllllIllIlllIlllIlIlIllI |= 0x4;
        }
        if (lllllllllllllIllIlllIlllIlIlIlll.getValue(BlockTrapDoor.HALF) == DoorHalf.TOP) {
            lllllllllllllIllIlllIlllIlIlIllI |= 0x8;
        }
        return lllllllllllllIllIlllIlllIlIlIllI;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllIllIlllIlllllIIIlII, final BlockPos lllllllllllllIllIlllIlllllIIIIIl) {
        return !lllllllllllllIllIlllIlllllIIIlII.getBlockState(lllllllllllllIllIlllIlllllIIIIIl).getValue((IProperty<Boolean>)BlockTrapDoor.OPEN);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIllIlllIllllIIIlIIl, final World lllllllllllllIllIlllIllllIIlIIII, final BlockPos lllllllllllllIllIlllIllllIIIIlll, final Block lllllllllllllIllIlllIllllIIIIllI, final BlockPos lllllllllllllIllIlllIllllIIIllIl) {
        if (!lllllllllllllIllIlllIllllIIlIIII.isRemote) {
            final boolean lllllllllllllIllIlllIllllIIIllII = lllllllllllllIllIlllIllllIIlIIII.isBlockPowered(lllllllllllllIllIlllIllllIIIIlll);
            if (lllllllllllllIllIlllIllllIIIllII || lllllllllllllIllIlllIllllIIIIllI.getDefaultState().canProvidePower()) {
                final boolean lllllllllllllIllIlllIllllIIIlIll = lllllllllllllIllIlllIllllIIIlIIl.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN);
                if (lllllllllllllIllIlllIllllIIIlIll != lllllllllllllIllIlllIllllIIIllII) {
                    lllllllllllllIllIlllIllllIIlIIII.setBlockState(lllllllllllllIllIlllIllllIIIIlll, lllllllllllllIllIlllIllllIIIlIIl.withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, lllllllllllllIllIlllIllllIIIllII), 2);
                    this.playSound(null, lllllllllllllIllIlllIllllIIlIIII, lllllllllllllIllIlllIllllIIIIlll, lllllllllllllIllIlllIllllIIIllII);
                }
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIllIlllIlllllIIlIlI) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIllIlllIllllIlllIlI, final BlockPos lllllllllllllIllIlllIllllIlIllll, IBlockState lllllllllllllIllIlllIllllIlIlllI, final EntityPlayer lllllllllllllIllIlllIllllIllIlll, final EnumHand lllllllllllllIllIlllIllllIllIllI, final EnumFacing lllllllllllllIllIlllIllllIllIlIl, final float lllllllllllllIllIlllIllllIllIlII, final float lllllllllllllIllIlllIllllIllIIll, final float lllllllllllllIllIlllIllllIllIIlI) {
        if (this.blockMaterial == Material.IRON) {
            return false;
        }
        lllllllllllllIllIlllIllllIlIlllI = lllllllllllllIllIlllIllllIlIlllI.cycleProperty((IProperty<Comparable>)BlockTrapDoor.OPEN);
        lllllllllllllIllIlllIllllIlllIlI.setBlockState(lllllllllllllIllIlllIllllIlIllll, lllllllllllllIllIlllIllllIlIlllI, 2);
        this.playSound(lllllllllllllIllIlllIllllIllIlll, lllllllllllllIllIlllIllllIlllIlI, lllllllllllllIllIlllIllllIlIllll, lllllllllllllIllIlllIllllIlIlllI.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN));
        return true;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockTrapDoor.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short lllllllllllllIllIlllIlllIIlllIII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIllIlllIlllIIlllIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllIlllIlllIIlllIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllIlllIlllIIlllIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllIlllIlllIIlllIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIllIlllIlllIIlllIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIllIlllIlllIIlllIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockTrapDoor.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIllIlllIlllIIlllIII;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIllIlllIlllIIllllll, final IBlockState lllllllllllllIllIlllIlllIIlllIll, final BlockPos lllllllllllllIllIlllIlllIIllllIl, final EnumFacing lllllllllllllIllIlllIlllIIllllII) {
        return (((lllllllllllllIllIlllIlllIIllllII == EnumFacing.UP && lllllllllllllIllIlllIlllIIlllIll.getValue(BlockTrapDoor.HALF) == DoorHalf.TOP) || (lllllllllllllIllIlllIlllIIllllII == EnumFacing.DOWN && lllllllllllllIllIlllIlllIIlllIll.getValue(BlockTrapDoor.HALF) == DoorHalf.BOTTOM)) && !lllllllllllllIllIlllIlllIIlllIll.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN)) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIllIlllIlllllIIlIII) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIllIlllIlllllIlIllI, final IBlockAccess lllllllllllllIllIlllIlllllIlIlIl, final BlockPos lllllllllllllIllIlllIlllllIlIlII) {
        AxisAlignedBB lllllllllllllIllIlllIlllllIIlllI = null;
        if (lllllllllllllIllIlllIlllllIlIllI.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN)) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIllIlllIlllllIlIllI.getValue((IProperty<EnumFacing>)BlockTrapDoor.FACING).ordinal()]) {
                default: {
                    final AxisAlignedBB lllllllllllllIllIlllIlllllIlIIll = BlockTrapDoor.NORTH_OPEN_AABB;
                    break;
                }
                case 4: {
                    final AxisAlignedBB lllllllllllllIllIlllIlllllIlIIlI = BlockTrapDoor.SOUTH_OPEN_AABB;
                    break;
                }
                case 5: {
                    final AxisAlignedBB lllllllllllllIllIlllIlllllIlIIIl = BlockTrapDoor.WEST_OPEN_AABB;
                    break;
                }
                case 6: {
                    final AxisAlignedBB lllllllllllllIllIlllIlllllIlIIII = BlockTrapDoor.EAST_OPEN_AABB;
                    break;
                }
            }
        }
        else if (lllllllllllllIllIlllIlllllIlIllI.getValue(BlockTrapDoor.HALF) == DoorHalf.TOP) {
            final AxisAlignedBB lllllllllllllIllIlllIlllllIIllll = BlockTrapDoor.TOP_AABB;
        }
        else {
            lllllllllllllIllIlllIlllllIIlllI = BlockTrapDoor.BOTTOM_AABB;
        }
        return lllllllllllllIllIlllIlllllIIlllI;
    }
    
    protected void playSound(@Nullable final EntityPlayer lllllllllllllIllIlllIllllIlIIlIl, final World lllllllllllllIllIlllIllllIlIIlII, final BlockPos lllllllllllllIllIlllIllllIIlllII, final boolean lllllllllllllIllIlllIllllIlIIIlI) {
        if (lllllllllllllIllIlllIllllIlIIIlI) {
            final int lllllllllllllIllIlllIllllIlIIIIl = (this.blockMaterial == Material.IRON) ? 1037 : 1007;
            lllllllllllllIllIlllIllllIlIIlII.playEvent(lllllllllllllIllIlllIllllIlIIlIl, lllllllllllllIllIlllIllllIlIIIIl, lllllllllllllIllIlllIllllIIlllII, 0);
        }
        else {
            final int lllllllllllllIllIlllIllllIlIIIII = (this.blockMaterial == Material.IRON) ? 1036 : 1013;
            lllllllllllllIllIlllIllllIlIIlII.playEvent(lllllllllllllIllIlllIllllIlIIlIl, lllllllllllllIllIlllIllllIlIIIII, lllllllllllllIllIlllIllllIIlllII, 0);
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIllIlllIlllIlIIlIIl, final Mirror lllllllllllllIllIlllIlllIlIIIllI) {
        return lllllllllllllIllIlllIlllIlIIlIIl.withRotation(lllllllllllllIllIlllIlllIlIIIllI.toRotation(lllllllllllllIllIlllIlllIlIIlIIl.getValue((IProperty<EnumFacing>)BlockTrapDoor.FACING)));
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllIllIlllIlllIllIlIlI, final BlockPos lllllllllllllIllIlllIlllIllIlIIl, final EnumFacing lllllllllllllIllIlllIlllIllIlIII) {
        return true;
    }
    
    protected static int getMetaForFacing(final EnumFacing lllllllllllllIllIlllIlllIllIIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIllIlllIlllIllIIIlI.ordinal()]) {
            case 3: {
                return 0;
            }
            case 4: {
                return 1;
            }
            case 5: {
                return 2;
            }
            default: {
                return 3;
            }
        }
    }
    
    protected BlockTrapDoor(final Material lllllllllllllIllIlllIlllllIlllII) {
        super(lllllllllllllIllIlllIlllllIlllII);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, false).withProperty(BlockTrapDoor.HALF, DoorHalf.BOTTOM));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIllIlllIlllIllllIll, final BlockPos lllllllllllllIllIlllIlllIllllIlI, final EnumFacing lllllllllllllIllIlllIlllIllIllll, final float lllllllllllllIllIlllIlllIllllIII, final float lllllllllllllIllIlllIlllIlllIlll, final float lllllllllllllIllIlllIlllIlllIllI, final int lllllllllllllIllIlllIlllIlllIlIl, final EntityLivingBase lllllllllllllIllIlllIlllIllIllIl) {
        IBlockState lllllllllllllIllIlllIlllIlllIIll = this.getDefaultState();
        if (lllllllllllllIllIlllIlllIllIllll.getAxis().isHorizontal()) {
            lllllllllllllIllIlllIlllIlllIIll = lllllllllllllIllIlllIlllIlllIIll.withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, lllllllllllllIllIlllIlllIllIllll).withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, false);
            lllllllllllllIllIlllIlllIlllIIll = lllllllllllllIllIlllIlllIlllIIll.withProperty(BlockTrapDoor.HALF, (lllllllllllllIllIlllIlllIlllIlll > 0.5f) ? DoorHalf.TOP : DoorHalf.BOTTOM);
        }
        else {
            lllllllllllllIllIlllIlllIlllIIll = lllllllllllllIllIlllIlllIlllIIll.withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, lllllllllllllIllIlllIlllIllIllIl.getHorizontalFacing().getOpposite()).withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, false);
            lllllllllllllIllIlllIlllIlllIIll = lllllllllllllIllIlllIlllIlllIIll.withProperty(BlockTrapDoor.HALF, (lllllllllllllIllIlllIlllIllIllll == EnumFacing.UP) ? DoorHalf.BOTTOM : DoorHalf.TOP);
        }
        if (lllllllllllllIllIlllIlllIllllIll.isBlockPowered(lllllllllllllIllIlllIlllIllllIlI)) {
            lllllllllllllIllIlllIlllIlllIIll = lllllllllllllIllIlllIlllIlllIIll.withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, true);
        }
        return lllllllllllllIllIlllIlllIlllIIll;
    }
    
    protected static EnumFacing getFacing(final int lllllllllllllIllIlllIlllIllIIlIl) {
        switch (lllllllllllllIllIlllIlllIllIIlIl & 0x3) {
            case 0: {
                return EnumFacing.NORTH;
            }
            case 1: {
                return EnumFacing.SOUTH;
            }
            case 2: {
                return EnumFacing.WEST;
            }
            default: {
                return EnumFacing.EAST;
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTrapDoor.FACING, BlockTrapDoor.OPEN, BlockTrapDoor.HALF });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllIlllIlllIlIlllIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTrapDoor.FACING, getFacing(lllllllllllllIllIlllIlllIlIlllIl)).withProperty((IProperty<Comparable>)BlockTrapDoor.OPEN, (lllllllllllllIllIlllIlllIlIlllIl & 0x4) != 0x0).withProperty(BlockTrapDoor.HALF, ((lllllllllllllIllIlllIlllIlIlllIl & 0x8) == 0x0) ? DoorHalf.BOTTOM : DoorHalf.TOP);
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        OPEN = PropertyBool.create("open");
        HALF = PropertyEnum.create("half", DoorHalf.class);
        EAST_OPEN_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.1875, 1.0, 1.0);
        WEST_OPEN_AABB = new AxisAlignedBB(0.8125, 0.0, 0.0, 1.0, 1.0, 1.0);
        SOUTH_OPEN_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.1875);
        NORTH_OPEN_AABB = new AxisAlignedBB(0.0, 0.0, 0.8125, 1.0, 1.0, 1.0);
        BOTTOM_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.1875, 1.0);
        TOP_AABB = new AxisAlignedBB(0.0, 0.8125, 0.0, 1.0, 1.0, 1.0);
    }
    
    public enum DoorHalf implements IStringSerializable
    {
        TOP("TOP", 0, "top"), 
        BOTTOM("BOTTOM", 1, "bottom");
        
        private final /* synthetic */ String name;
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private DoorHalf(final String lllllllllllllIllllIllIllIlIIllIl, final int lllllllllllllIllllIllIllIlIIllII, final String lllllllllllllIllllIllIllIlIIlIll) {
            this.name = lllllllllllllIllllIllIllIlIIlIll;
        }
    }
}
