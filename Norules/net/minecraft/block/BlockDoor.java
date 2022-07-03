package net.minecraft.block;

import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockDoor extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumHingePosition> HINGE;
    protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
    public static final /* synthetic */ PropertyBool OPEN;
    public static final /* synthetic */ PropertyBool POWERED;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    public static final /* synthetic */ PropertyDirection FACING;
    public static final /* synthetic */ PropertyEnum<EnumDoorHalf> HALF;
    protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
    
    static {
        FACING = BlockHorizontal.FACING;
        OPEN = PropertyBool.create("open");
        HINGE = PropertyEnum.create("hinge", EnumHingePosition.class);
        POWERED = PropertyBool.create("powered");
        HALF = PropertyEnum.create("half", EnumDoorHalf.class);
        SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.1875);
        NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.8125, 1.0, 1.0, 1.0);
        WEST_AABB = new AxisAlignedBB(0.8125, 0.0, 0.0, 1.0, 1.0, 1.0);
        EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.1875, 1.0, 1.0);
    }
    
    private Item getItem() {
        if (this == Blocks.IRON_DOOR) {
            return Items.IRON_DOOR;
        }
        if (this == Blocks.SPRUCE_DOOR) {
            return Items.SPRUCE_DOOR;
        }
        if (this == Blocks.BIRCH_DOOR) {
            return Items.BIRCH_DOOR;
        }
        if (this == Blocks.JUNGLE_DOOR) {
            return Items.JUNGLE_DOOR;
        }
        if (this == Blocks.ACACIA_DOOR) {
            return Items.ACACIA_DOOR;
        }
        return (this == Blocks.DARK_OAK_DOOR) ? Items.DARK_OAK_DOOR : Items.OAK_DOOR;
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllllIIIlIIlIIIlllIlII, final IBlockAccess lllllllllllllllIIIlIIlIIIlllIIlI, final BlockPos lllllllllllllllIIIlIIlIIIlllIIIl) {
        if (((IBlockState)lllllllllllllllIIIlIIlIIIlllIlII).getValue(BlockDoor.HALF) == EnumDoorHalf.LOWER) {
            final IBlockState lllllllllllllllIIIlIIlIIIllllIII = lllllllllllllllIIIlIIlIIIlllIIlI.getBlockState(lllllllllllllllIIIlIIlIIIlllIIIl.up());
            if (lllllllllllllllIIIlIIlIIIllllIII.getBlock() == this) {
                lllllllllllllllIIIlIIlIIIlllIlII = ((IBlockState)lllllllllllllllIIIlIIlIIIlllIlII).withProperty(BlockDoor.HINGE, (EnumHingePosition)lllllllllllllllIIIlIIlIIIllllIII.getValue((IProperty<V>)BlockDoor.HINGE)).withProperty((IProperty<Comparable>)BlockDoor.POWERED, (Boolean)lllllllllllllllIIIlIIlIIIllllIII.getValue((IProperty<V>)BlockDoor.POWERED));
            }
        }
        else {
            final IBlockState lllllllllllllllIIIlIIlIIIlllIlll = lllllllllllllllIIIlIIlIIIlllIIlI.getBlockState(lllllllllllllllIIIlIIlIIIlllIIIl.down());
            if (lllllllllllllllIIIlIIlIIIlllIlll.getBlock() == this) {
                lllllllllllllllIIIlIIlIIIlllIlII = ((IBlockState)lllllllllllllllIIIlIIlIIIlllIlII).withProperty((IProperty<Comparable>)BlockDoor.FACING, (EnumFacing)lllllllllllllllIIIlIIlIIIlllIlll.getValue((IProperty<V>)BlockDoor.FACING)).withProperty((IProperty<Comparable>)BlockDoor.OPEN, (Boolean)lllllllllllllllIIIlIIlIIIlllIlll.getValue((IProperty<V>)BlockDoor.OPEN));
            }
        }
        return (IBlockState)lllllllllllllllIIIlIIlIIIlllIlII;
    }
    
    private int getCloseSound() {
        return (this.blockMaterial == Material.IRON) ? 1011 : 1012;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIIIlIIlIlIlIIIIlI) {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIIlIIlIIIlIlIIIl) {
        return ((lllllllllllllllIIIlIIlIIIlIlIIIl & 0x8) > 0) ? this.getDefaultState().withProperty(BlockDoor.HALF, EnumDoorHalf.UPPER).withProperty(BlockDoor.HINGE, ((lllllllllllllllIIIlIIlIIIlIlIIIl & 0x1) > 0) ? EnumHingePosition.RIGHT : EnumHingePosition.LEFT).withProperty((IProperty<Comparable>)BlockDoor.POWERED, (lllllllllllllllIIIlIIlIIIlIlIIIl & 0x2) > 0) : this.getDefaultState().withProperty(BlockDoor.HALF, EnumDoorHalf.LOWER).withProperty((IProperty<Comparable>)BlockDoor.FACING, EnumFacing.getHorizontal(lllllllllllllllIIIlIIlIIIlIlIIIl & 0x3).rotateYCCW()).withProperty((IProperty<Comparable>)BlockDoor.OPEN, (lllllllllllllllIIIlIIlIIIlIlIIIl & 0x4) > 0);
    }
    
    protected static boolean isOpen(final int lllllllllllllllIIIlIIlIIIIIlllll) {
        return (lllllllllllllllIIIlIIlIIIIIlllll & 0x4) != 0x0;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllllllIIIlIIlIIllIIlllI) {
        return EnumPushReaction.DESTROY;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIIIlIIlIIlIlIIlII, final BlockPos lllllllllllllllIIIlIIlIIlIlIIIll, final IBlockState lllllllllllllllIIIlIIlIIlIlIIIlI) {
        return new ItemStack(this.getItem());
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIIIlIIlIIllIlIlII, final BlockPos lllllllllllllllIIIlIIlIIllIlIIll) {
        return lllllllllllllllIIIlIIlIIllIlIIll.getY() < 255 && (lllllllllllllllIIIlIIlIIllIlIlII.getBlockState(lllllllllllllllIIIlIIlIIllIlIIll.down()).isFullyOpaque() && super.canPlaceBlockAt(lllllllllllllllIIIlIIlIIllIlIlII, lllllllllllllllIIIlIIlIIllIlIIll) && super.canPlaceBlockAt(lllllllllllllllIIIlIIlIIllIlIlII, lllllllllllllllIIIlIIlIIllIlIIll.up()));
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIIIlIIlIlIIllIIlI, final IBlockAccess lllllllllllllllIIIlIIlIlIIllIIIl, final BlockPos lllllllllllllllIIIlIIlIlIIllIIII) {
        if (lllllllllllllllIIIlIIlIlIIllIIlI.getBlock() == Blocks.IRON_DOOR) {
            return MapColor.IRON;
        }
        if (lllllllllllllllIIIlIIlIlIIllIIlI.getBlock() == Blocks.OAK_DOOR) {
            return BlockPlanks.EnumType.OAK.getMapColor();
        }
        if (lllllllllllllllIIIlIIlIlIIllIIlI.getBlock() == Blocks.SPRUCE_DOOR) {
            return BlockPlanks.EnumType.SPRUCE.getMapColor();
        }
        if (lllllllllllllllIIIlIIlIlIIllIIlI.getBlock() == Blocks.BIRCH_DOOR) {
            return BlockPlanks.EnumType.BIRCH.getMapColor();
        }
        if (lllllllllllllllIIIlIIlIlIIllIIlI.getBlock() == Blocks.JUNGLE_DOOR) {
            return BlockPlanks.EnumType.JUNGLE.getMapColor();
        }
        if (lllllllllllllllIIIlIIlIlIIllIIlI.getBlock() == Blocks.ACACIA_DOOR) {
            return BlockPlanks.EnumType.ACACIA.getMapColor();
        }
        return (lllllllllllllllIIIlIIlIlIIllIIlI.getBlock() == Blocks.DARK_OAK_DOOR) ? BlockPlanks.EnumType.DARK_OAK.getMapColor() : super.getMapColor(lllllllllllllllIIIlIIlIlIIllIIlI, lllllllllllllllIIIlIIlIlIIllIIIl, lllllllllllllllIIIlIIlIlIIllIIII);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllllIIIlIIlIlIlIIIlll, final BlockPos lllllllllllllllIIIlIIlIlIlIIIlII) {
        return isOpen(combineMetadata(lllllllllllllllIIIlIIlIlIlIIIlll, lllllllllllllllIIIlIIlIlIlIIIlII));
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllIIIlIIlIIlllIlIIl, final World lllllllllllllllIIIlIIlIIllllIlII, final BlockPos lllllllllllllllIIIlIIlIIllllIIll, final Block lllllllllllllllIIIlIIlIIlllIIllI, final BlockPos lllllllllllllllIIIlIIlIIllllIIIl) {
        if (lllllllllllllllIIIlIIlIIlllIlIIl.getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) {
            final BlockPos lllllllllllllllIIIlIIlIIllllIIII = lllllllllllllllIIIlIIlIIllllIIll.down();
            final IBlockState lllllllllllllllIIIlIIlIIlllIllll = lllllllllllllllIIIlIIlIIllllIlII.getBlockState(lllllllllllllllIIIlIIlIIllllIIII);
            if (lllllllllllllllIIIlIIlIIlllIllll.getBlock() != this) {
                lllllllllllllllIIIlIIlIIllllIlII.setBlockToAir(lllllllllllllllIIIlIIlIIllllIIll);
            }
            else if (lllllllllllllllIIIlIIlIIlllIIllI != this) {
                lllllllllllllllIIIlIIlIIlllIllll.neighborChanged(lllllllllllllllIIIlIIlIIllllIlII, lllllllllllllllIIIlIIlIIllllIIII, lllllllllllllllIIIlIIlIIlllIIllI, lllllllllllllllIIIlIIlIIllllIIIl);
            }
        }
        else {
            boolean lllllllllllllllIIIlIIlIIlllIlllI = false;
            final BlockPos lllllllllllllllIIIlIIlIIlllIllIl = lllllllllllllllIIIlIIlIIllllIIll.up();
            final IBlockState lllllllllllllllIIIlIIlIIlllIllII = lllllllllllllllIIIlIIlIIllllIlII.getBlockState(lllllllllllllllIIIlIIlIIlllIllIl);
            if (lllllllllllllllIIIlIIlIIlllIllII.getBlock() != this) {
                lllllllllllllllIIIlIIlIIllllIlII.setBlockToAir(lllllllllllllllIIIlIIlIIllllIIll);
                lllllllllllllllIIIlIIlIIlllIlllI = true;
            }
            if (!lllllllllllllllIIIlIIlIIllllIlII.getBlockState(lllllllllllllllIIIlIIlIIllllIIll.down()).isFullyOpaque()) {
                lllllllllllllllIIIlIIlIIllllIlII.setBlockToAir(lllllllllllllllIIIlIIlIIllllIIll);
                lllllllllllllllIIIlIIlIIlllIlllI = true;
                if (lllllllllllllllIIIlIIlIIlllIllII.getBlock() == this) {
                    lllllllllllllllIIIlIIlIIllllIlII.setBlockToAir(lllllllllllllllIIIlIIlIIlllIllIl);
                }
            }
            if (lllllllllllllllIIIlIIlIIlllIlllI) {
                if (!lllllllllllllllIIIlIIlIIllllIlII.isRemote) {
                    this.dropBlockAsItem(lllllllllllllllIIIlIIlIIllllIlII, lllllllllllllllIIIlIIlIIllllIIll, lllllllllllllllIIIlIIlIIlllIlIIl, 0);
                }
            }
            else {
                final boolean lllllllllllllllIIIlIIlIIlllIlIll = lllllllllllllllIIIlIIlIIllllIlII.isBlockPowered(lllllllllllllllIIIlIIlIIllllIIll) || lllllllllllllllIIIlIIlIIllllIlII.isBlockPowered(lllllllllllllllIIIlIIlIIlllIllIl);
                if (lllllllllllllllIIIlIIlIIlllIIllI != this && (lllllllllllllllIIIlIIlIIlllIlIll || lllllllllllllllIIIlIIlIIlllIIllI.getDefaultState().canProvidePower()) && lllllllllllllllIIIlIIlIIlllIlIll != lllllllllllllllIIIlIIlIIlllIllII.getValue((IProperty<Boolean>)BlockDoor.POWERED)) {
                    lllllllllllllllIIIlIIlIIllllIlII.setBlockState(lllllllllllllllIIIlIIlIIlllIllIl, lllllllllllllllIIIlIIlIIlllIllII.withProperty((IProperty<Comparable>)BlockDoor.POWERED, lllllllllllllllIIIlIIlIIlllIlIll), 2);
                    if (lllllllllllllllIIIlIIlIIlllIlIll != lllllllllllllllIIIlIIlIIlllIlIIl.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
                        lllllllllllllllIIIlIIlIIllllIlII.setBlockState(lllllllllllllllIIIlIIlIIllllIIll, lllllllllllllllIIIlIIlIIlllIlIIl.withProperty((IProperty<Comparable>)BlockDoor.OPEN, lllllllllllllllIIIlIIlIIlllIlIll), 2);
                        lllllllllllllllIIIlIIlIIllllIlII.markBlockRangeForRenderUpdate(lllllllllllllllIIIlIIlIIllllIIll, lllllllllllllllIIIlIIlIIllllIIll);
                        lllllllllllllllIIIlIIlIIllllIlII.playEvent(null, lllllllllllllllIIIlIIlIIlllIlIll ? this.getOpenSound() : this.getCloseSound(), lllllllllllllllIIIlIIlIIllllIIll, 0);
                    }
                }
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIIIlIIlIIllIllIIl, final Random lllllllllllllllIIIlIIlIIllIlllII, final int lllllllllllllllIIIlIIlIIllIllIll) {
        return (lllllllllllllllIIIlIIlIIllIllIIl.getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) ? Items.field_190931_a : this.getItem();
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".name")).replaceAll("tile", "item"));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDoor.HALF, BlockDoor.FACING, BlockDoor.OPEN, BlockDoor.HINGE, BlockDoor.POWERED });
    }
    
    protected static int removeHalfBit(final int lllllllllllllllIIIlIIlIIIIlllllI) {
        return lllllllllllllllIIIlIIlIIIIlllllI & 0x7;
    }
    
    public static EnumFacing getFacing(final int lllllllllllllllIIIlIIlIIIIlIIlII) {
        return EnumFacing.getHorizontal(lllllllllllllllIIIlIIlIIIIlIIlII & 0x3).rotateYCCW();
    }
    
    protected BlockDoor(final Material lllllllllllllllIIIlIIlIlIllIIlIl) {
        super(lllllllllllllllIIIlIIlIlIllIIlIl);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockDoor.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockDoor.OPEN, false).withProperty(BlockDoor.HINGE, EnumHingePosition.LEFT).withProperty((IProperty<Comparable>)BlockDoor.POWERED, false).withProperty(BlockDoor.HALF, EnumDoorHalf.LOWER));
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllIIIlIIlIIIllIlIII, final Rotation lllllllllllllllIIIlIIlIIIllIIllI) {
        return (lllllllllllllllIIIlIIlIIIllIlIII.getValue(BlockDoor.HALF) != EnumDoorHalf.LOWER) ? lllllllllllllllIIIlIIlIIIllIlIII : lllllllllllllllIIIlIIlIIIllIlIII.withProperty((IProperty<Comparable>)BlockDoor.FACING, lllllllllllllllIIIlIIlIIIllIIllI.rotate(lllllllllllllllIIIlIIlIIIllIlIII.getValue((IProperty<EnumFacing>)BlockDoor.FACING)));
    }
    
    public static int combineMetadata(final IBlockAccess lllllllllllllllIIIlIIlIIllIIIIII, final BlockPos lllllllllllllllIIIlIIlIIlIllIIlI) {
        final IBlockState lllllllllllllllIIIlIIlIIlIlllllI = lllllllllllllllIIIlIIlIIllIIIIII.getBlockState(lllllllllllllllIIIlIIlIIlIllIIlI);
        final int lllllllllllllllIIIlIIlIIlIllllIl = lllllllllllllllIIIlIIlIIlIlllllI.getBlock().getMetaFromState(lllllllllllllllIIIlIIlIIlIlllllI);
        final boolean lllllllllllllllIIIlIIlIIlIllllII = isTop(lllllllllllllllIIIlIIlIIlIllllIl);
        final IBlockState lllllllllllllllIIIlIIlIIlIlllIll = lllllllllllllllIIIlIIlIIllIIIIII.getBlockState(lllllllllllllllIIIlIIlIIlIllIIlI.down());
        final int lllllllllllllllIIIlIIlIIlIlllIlI = lllllllllllllllIIIlIIlIIlIlllIll.getBlock().getMetaFromState(lllllllllllllllIIIlIIlIIlIlllIll);
        final int lllllllllllllllIIIlIIlIIlIlllIIl = lllllllllllllllIIIlIIlIIlIllllII ? lllllllllllllllIIIlIIlIIlIlllIlI : lllllllllllllllIIIlIIlIIlIllllIl;
        final IBlockState lllllllllllllllIIIlIIlIIlIlllIII = lllllllllllllllIIIlIIlIIllIIIIII.getBlockState(lllllllllllllllIIIlIIlIIlIllIIlI.up());
        final int lllllllllllllllIIIlIIlIIlIllIlll = lllllllllllllllIIIlIIlIIlIlllIII.getBlock().getMetaFromState(lllllllllllllllIIIlIIlIIlIlllIII);
        final int lllllllllllllllIIIlIIlIIlIllIllI = lllllllllllllllIIIlIIlIIlIllllII ? lllllllllllllllIIIlIIlIIlIllllIl : lllllllllllllllIIIlIIlIIlIllIlll;
        final boolean lllllllllllllllIIIlIIlIIlIllIlIl = (lllllllllllllllIIIlIIlIIlIllIllI & 0x1) != 0x0;
        final boolean lllllllllllllllIIIlIIlIIlIllIlII = (lllllllllllllllIIIlIIlIIlIllIllI & 0x2) != 0x0;
        return removeHalfBit(lllllllllllllllIIIlIIlIIlIlllIIl) | (lllllllllllllllIIIlIIlIIlIllllII ? 8 : 0) | (lllllllllllllllIIIlIIlIIlIllIlIl ? 16 : 0) | (lllllllllllllllIIIlIIlIIlIllIlII ? 32 : 0);
    }
    
    public void toggleDoor(final World lllllllllllllllIIIlIIlIlIIIIllIl, final BlockPos lllllllllllllllIIIlIIlIlIIIIllII, final boolean lllllllllllllllIIIlIIlIlIIIIlIll) {
        final IBlockState lllllllllllllllIIIlIIlIlIIIIlIlI = lllllllllllllllIIIlIIlIlIIIIllIl.getBlockState(lllllllllllllllIIIlIIlIlIIIIllII);
        if (lllllllllllllllIIIlIIlIlIIIIlIlI.getBlock() == this) {
            final BlockPos lllllllllllllllIIIlIIlIlIIIIlIIl = (lllllllllllllllIIIlIIlIlIIIIlIlI.getValue(BlockDoor.HALF) == EnumDoorHalf.LOWER) ? lllllllllllllllIIIlIIlIlIIIIllII : lllllllllllllllIIIlIIlIlIIIIllII.down();
            final IBlockState lllllllllllllllIIIlIIlIlIIIIlIII = (lllllllllllllllIIIlIIlIlIIIIllII == lllllllllllllllIIIlIIlIlIIIIlIIl) ? lllllllllllllllIIIlIIlIlIIIIlIlI : lllllllllllllllIIIlIIlIlIIIIllIl.getBlockState(lllllllllllllllIIIlIIlIlIIIIlIIl);
            if (lllllllllllllllIIIlIIlIlIIIIlIII.getBlock() == this && lllllllllllllllIIIlIIlIlIIIIlIII.getValue((IProperty<Boolean>)BlockDoor.OPEN) != lllllllllllllllIIIlIIlIlIIIIlIll) {
                lllllllllllllllIIIlIIlIlIIIIllIl.setBlockState(lllllllllllllllIIIlIIlIlIIIIlIIl, lllllllllllllllIIIlIIlIlIIIIlIII.withProperty((IProperty<Comparable>)BlockDoor.OPEN, lllllllllllllllIIIlIIlIlIIIIlIll), 10);
                lllllllllllllllIIIlIIlIlIIIIllIl.markBlockRangeForRenderUpdate(lllllllllllllllIIIlIIlIlIIIIlIIl, lllllllllllllllIIIlIIlIlIIIIllII);
                lllllllllllllllIIIlIIlIlIIIIllIl.playEvent(null, lllllllllllllllIIIlIIlIlIIIIlIll ? this.getOpenSound() : this.getCloseSound(), lllllllllllllllIIIlIIlIlIIIIllII, 0);
            }
        }
    }
    
    public static boolean isOpen(final IBlockAccess lllllllllllllllIIIlIIlIIIIllIllI, final BlockPos lllllllllllllllIIIlIIlIIIIllIlIl) {
        return isOpen(combineMetadata(lllllllllllllllIIIlIIlIIIIllIllI, lllllllllllllllIIIlIIlIIIIllIlIl));
    }
    
    public static EnumFacing getFacing(final IBlockAccess lllllllllllllllIIIlIIlIIIIlIlIlI, final BlockPos lllllllllllllllIIIlIIlIIIIlIlIII) {
        return getFacing(combineMetadata(lllllllllllllllIIIlIIlIIIIlIlIlI, lllllllllllllllIIIlIIlIIIIlIlIII));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState lllllllllllllllIIIlIIlIlIlIlIlIl, final IBlockAccess lllllllllllllllIIIlIIlIlIlIllIlI, final BlockPos lllllllllllllllIIIlIIlIlIlIlIIll) {
        lllllllllllllllIIIlIIlIlIlIlIlIl = lllllllllllllllIIIlIIlIlIlIlIlIl.getActualState(lllllllllllllllIIIlIIlIlIlIllIlI, lllllllllllllllIIIlIIlIlIlIlIIll);
        final EnumFacing lllllllllllllllIIIlIIlIlIlIllIII = lllllllllllllllIIIlIIlIlIlIlIlIl.getValue((IProperty<EnumFacing>)BlockDoor.FACING);
        final boolean lllllllllllllllIIIlIIlIlIlIlIlll = !lllllllllllllllIIIlIIlIlIlIlIlIl.getValue((IProperty<Boolean>)BlockDoor.OPEN);
        final boolean lllllllllllllllIIIlIIlIlIlIlIllI = lllllllllllllllIIIlIIlIlIlIlIlIl.getValue(BlockDoor.HINGE) == EnumHingePosition.RIGHT;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllllIIIlIIlIlIlIllIII.ordinal()]) {
            default: {
                return lllllllllllllllIIIlIIlIlIlIlIlll ? BlockDoor.EAST_AABB : (lllllllllllllllIIIlIIlIlIlIlIllI ? BlockDoor.NORTH_AABB : BlockDoor.SOUTH_AABB);
            }
            case 4: {
                return lllllllllllllllIIIlIIlIlIlIlIlll ? BlockDoor.SOUTH_AABB : (lllllllllllllllIIIlIIlIlIlIlIllI ? BlockDoor.EAST_AABB : BlockDoor.WEST_AABB);
            }
            case 5: {
                return lllllllllllllllIIIlIIlIlIlIlIlll ? BlockDoor.WEST_AABB : (lllllllllllllllIIIlIIlIlIlIlIllI ? BlockDoor.SOUTH_AABB : BlockDoor.NORTH_AABB);
            }
            case 3: {
                return lllllllllllllllIIIlIIlIlIlIlIlll ? BlockDoor.NORTH_AABB : (lllllllllllllllIIIlIIlIlIlIlIllI ? BlockDoor.WEST_AABB : BlockDoor.EAST_AABB);
            }
        }
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllllIIIlIIlIIlIIIlllI, final BlockPos lllllllllllllllIIIlIIlIIlIIIllIl, final IBlockState lllllllllllllllIIIlIIlIIlIIlIIll, final EntityPlayer lllllllllllllllIIIlIIlIIlIIIlIll) {
        final BlockPos lllllllllllllllIIIlIIlIIlIIlIIIl = lllllllllllllllIIIlIIlIIlIIIllIl.down();
        final BlockPos lllllllllllllllIIIlIIlIIlIIlIIII = lllllllllllllllIIIlIIlIIlIIIllIl.up();
        if (lllllllllllllllIIIlIIlIIlIIIlIll.capabilities.isCreativeMode && lllllllllllllllIIIlIIlIIlIIlIIll.getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER && lllllllllllllllIIIlIIlIIlIIIlllI.getBlockState(lllllllllllllllIIIlIIlIIlIIlIIIl).getBlock() == this) {
            lllllllllllllllIIIlIIlIIlIIIlllI.setBlockToAir(lllllllllllllllIIIlIIlIIlIIlIIIl);
        }
        if (lllllllllllllllIIIlIIlIIlIIlIIll.getValue(BlockDoor.HALF) == EnumDoorHalf.LOWER && lllllllllllllllIIIlIIlIIlIIIlllI.getBlockState(lllllllllllllllIIIlIIlIIlIIlIIII).getBlock() == this) {
            if (lllllllllllllllIIIlIIlIIlIIIlIll.capabilities.isCreativeMode) {
                lllllllllllllllIIIlIIlIIlIIIlllI.setBlockToAir(lllllllllllllllIIIlIIlIIlIIIllIl);
            }
            lllllllllllllllIIIlIIlIIlIIIlllI.setBlockToAir(lllllllllllllllIIIlIIlIIlIIlIIII);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIlIIlIIIlIIlIlI) {
        int lllllllllllllllIIIlIIlIIIlIIlIIl = 0;
        if (lllllllllllllllIIIlIIlIIIlIIlIlI.getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) {
            lllllllllllllllIIIlIIlIIIlIIlIIl |= 0x8;
            if (lllllllllllllllIIIlIIlIIIlIIlIlI.getValue(BlockDoor.HINGE) == EnumHingePosition.RIGHT) {
                lllllllllllllllIIIlIIlIIIlIIlIIl |= 0x1;
            }
            if (lllllllllllllllIIIlIIlIIIlIIlIlI.getValue((IProperty<Boolean>)BlockDoor.POWERED)) {
                lllllllllllllllIIIlIIlIIIlIIlIIl |= 0x2;
            }
        }
        else {
            lllllllllllllllIIIlIIlIIIlIIlIIl |= lllllllllllllllIIIlIIlIIIlIIlIlI.getValue((IProperty<EnumFacing>)BlockDoor.FACING).rotateY().getHorizontalIndex();
            if (lllllllllllllllIIIlIIlIIIlIIlIlI.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
                lllllllllllllllIIIlIIlIIIlIIlIIl |= 0x4;
            }
        }
        return lllllllllllllllIIIlIIlIIIlIIlIIl;
    }
    
    private int getOpenSound() {
        return (this.blockMaterial == Material.IRON) ? 1005 : 1006;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIIIlIIlIIIIIlIllI, final IBlockState lllllllllllllllIIIlIIlIIIIIlIlII, final BlockPos lllllllllllllllIIIlIIlIIIIIlIIll, final EnumFacing lllllllllllllllIIIlIIlIIIIIlIIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllllIIIlIIlIIIlIlllll, final Mirror lllllllllllllllIIIlIIlIIIlIlllII) {
        return (lllllllllllllllIIIlIIlIIIlIlllII == Mirror.NONE) ? lllllllllllllllIIIlIIlIIIlIlllll : lllllllllllllllIIIlIIlIIIlIlllll.withRotation(lllllllllllllllIIIlIIlIIIlIlllII.toRotation(lllllllllllllllIIIlIIlIIIlIlllll.getValue((IProperty<EnumFacing>)BlockDoor.FACING))).cycleProperty(BlockDoor.HINGE);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIIIlIIlIlIIIllIll, final BlockPos lllllllllllllllIIIlIIlIlIIIllIlI, IBlockState lllllllllllllllIIIlIIlIlIIIllIIl, final EntityPlayer lllllllllllllllIIIlIIlIlIIlIIlII, final EnumHand lllllllllllllllIIIlIIlIlIIlIIIll, final EnumFacing lllllllllllllllIIIlIIlIlIIlIIIlI, final float lllllllllllllllIIIlIIlIlIIlIIIIl, final float lllllllllllllllIIIlIIlIlIIlIIIII, final float lllllllllllllllIIIlIIlIlIIIlllll) {
        if (this.blockMaterial == Material.IRON) {
            return false;
        }
        final BlockPos lllllllllllllllIIIlIIlIlIIIllllI = (lllllllllllllllIIIlIIlIlIIIllIIl.getValue(BlockDoor.HALF) == EnumDoorHalf.LOWER) ? lllllllllllllllIIIlIIlIlIIIllIlI : lllllllllllllllIIIlIIlIlIIIllIlI.down();
        final IBlockState lllllllllllllllIIIlIIlIlIIIlllIl = lllllllllllllllIIIlIIlIlIIIllIlI.equals(lllllllllllllllIIIlIIlIlIIIllllI) ? lllllllllllllllIIIlIIlIlIIIllIIl : lllllllllllllllIIIlIIlIlIIIllIll.getBlockState(lllllllllllllllIIIlIIlIlIIIllllI);
        if (lllllllllllllllIIIlIIlIlIIIlllIl.getBlock() != this) {
            return false;
        }
        lllllllllllllllIIIlIIlIlIIIllIIl = lllllllllllllllIIIlIIlIlIIIlllIl.cycleProperty((IProperty<Comparable>)BlockDoor.OPEN);
        lllllllllllllllIIIlIIlIlIIIllIll.setBlockState(lllllllllllllllIIIlIIlIlIIIllllI, lllllllllllllllIIIlIIlIlIIIllIIl, 10);
        lllllllllllllllIIIlIIlIlIIIllIll.markBlockRangeForRenderUpdate(lllllllllllllllIIIlIIlIlIIIllllI, lllllllllllllllIIIlIIlIlIIIllIlI);
        lllllllllllllllIIIlIIlIlIIIllIll.playEvent(lllllllllllllllIIIlIIlIlIIlIIlII, ((boolean)lllllllllllllllIIIlIIlIlIIIllIIl.getValue((IProperty<Boolean>)BlockDoor.OPEN)) ? this.getOpenSound() : this.getCloseSound(), lllllllllllllllIIIlIIlIlIIIllIlI, 0);
        return true;
    }
    
    protected static boolean isTop(final int lllllllllllllllIIIlIIlIIIIIlllII) {
        return (lllllllllllllllIIIlIIlIIIIIlllII & 0x8) != 0x0;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockDoor.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final float lllllllllllllllIIIlIIlIIIIIIIIIl = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllllIIIlIIlIIIIIIIIIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIIIlIIlIIIIIIIIIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIIIlIIlIIIIIIIIIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIIIlIIlIIIIIIIIIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIIIlIIlIIIIIIIIIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIIIlIIlIIIIIIIIIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockDoor.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllllIIIlIIlIIIIIIIIIl;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIIIlIIlIlIlIIlIll) {
        return false;
    }
    
    public enum EnumDoorHalf implements IStringSerializable
    {
        LOWER("LOWER", 1), 
        UPPER("UPPER", 0);
        
        @Override
        public String toString() {
            return this.getName();
        }
        
        private EnumDoorHalf(final String llllllllllllllIIlIIlIIIlIlIIllIl, final int llllllllllllllIIlIIlIIIlIlIIllII) {
        }
        
        @Override
        public String getName() {
            return (this == EnumDoorHalf.UPPER) ? "upper" : "lower";
        }
    }
    
    public enum EnumHingePosition implements IStringSerializable
    {
        LEFT("LEFT", 0), 
        RIGHT("RIGHT", 1);
        
        private EnumHingePosition(final String llllllllllllllIIIIlllIIlIllllIII, final int llllllllllllllIIIIlllIIlIlllIlll) {
        }
        
        @Override
        public String toString() {
            return this.getName();
        }
        
        @Override
        public String getName() {
            return (this == EnumHingePosition.LEFT) ? "left" : "right";
        }
    }
}
