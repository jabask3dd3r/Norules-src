package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.block.state.*;

public class BlockHopper extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
    public static final /* synthetic */ PropertyBool ENABLED;
    protected static final /* synthetic */ AxisAlignedBB BASE_AABB;
    protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllIIIIllIlIIlIIIII) {
        int llllllllllllllllIIIIllIlIIIlllll = 0;
        llllllllllllllllIIIIllIlIIIlllll |= llllllllllllllllIIIIllIlIIlIIIII.getValue((IProperty<EnumFacing>)BlockHopper.FACING).getIndex();
        if (!llllllllllllllllIIIIllIlIIlIIIII.getValue((IProperty<Boolean>)BlockHopper.ENABLED)) {
            llllllllllllllllIIIIllIlIIIlllll |= 0x8;
        }
        return llllllllllllllllIIIIllIlIIIlllll;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllllIIIIllIlllIIlIIl, final IBlockAccess llllllllllllllllIIIIllIlllIIlIII, final BlockPos llllllllllllllllIIIIllIlllIIIlll) {
        return BlockHopper.FULL_BLOCK_AABB;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllllIIIIllIlIlIIIIII) {
        return false;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllllIIIIllIlIIIlIIlI, final Mirror llllllllllllllllIIIIllIlIIIlIIIl) {
        return llllllllllllllllIIIIllIlIIIlIIlI.withRotation(llllllllllllllllIIIIllIlIIIlIIIl.toRotation(llllllllllllllllIIIIllIlIIIlIIlI.getValue((IProperty<EnumFacing>)BlockHopper.FACING)));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockHopper.FACING, BlockHopper.ENABLED });
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState llllllllllllllllIIIIllIlIIllIIll) {
        return true;
    }
    
    public BlockHopper() {
        super(Material.IRON, MapColor.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockHopper.FACING, EnumFacing.DOWN).withProperty((IProperty<Comparable>)BlockHopper.ENABLED, true));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    public static boolean isEnabled(final int llllllllllllllllIIIIllIlIIllIlIl) {
        return (llllllllllllllllIIIIllIlIIllIlIl & 0x8) != 0x8;
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState llllllllllllllllIIIIllIllIIIllll) {
        return true;
    }
    
    @Override
    public void breakBlock(final World llllllllllllllllIIIIllIlIlIIlIIl, final BlockPos llllllllllllllllIIIIllIlIlIIlIII, final IBlockState llllllllllllllllIIIIllIlIlIIIlll) {
        final TileEntity llllllllllllllllIIIIllIlIlIIlIll = llllllllllllllllIIIIllIlIlIIlIIl.getTileEntity(llllllllllllllllIIIIllIlIlIIlIII);
        if (llllllllllllllllIIIIllIlIlIIlIll instanceof TileEntityHopper) {
            InventoryHelper.dropInventoryItems(llllllllllllllllIIIIllIlIlIIlIIl, llllllllllllllllIIIIllIlIlIIlIII, (IInventory)llllllllllllllllIIIIllIlIlIIlIll);
            llllllllllllllllIIIIllIlIlIIlIIl.updateComparatorOutputLevel(llllllllllllllllIIIIllIlIlIIlIII, this);
        }
        super.breakBlock(llllllllllllllllIIIIllIlIlIIlIIl, llllllllllllllllIIIIllIlIlIIlIII, llllllllllllllllIIIIllIlIlIIIlll);
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState llllllllllllllllIIIIllIlllIIIIlI, final World llllllllllllllllIIIIllIlllIIIIIl, final BlockPos llllllllllllllllIIIIllIlllIIIIII, final AxisAlignedBB llllllllllllllllIIIIllIllIllllll, final List<AxisAlignedBB> llllllllllllllllIIIIllIllIlllllI, @Nullable final Entity llllllllllllllllIIIIllIllIllllIl, final boolean llllllllllllllllIIIIllIllIllllII) {
        Block.addCollisionBoxToList(llllllllllllllllIIIIllIlllIIIIII, llllllllllllllllIIIIllIllIllllll, llllllllllllllllIIIIllIllIlllllI, BlockHopper.BASE_AABB);
        Block.addCollisionBoxToList(llllllllllllllllIIIIllIlllIIIIII, llllllllllllllllIIIIllIllIllllll, llllllllllllllllIIIIllIllIlllllI, BlockHopper.EAST_AABB);
        Block.addCollisionBoxToList(llllllllllllllllIIIIllIlllIIIIII, llllllllllllllllIIIIllIllIllllll, llllllllllllllllIIIIllIllIlllllI, BlockHopper.WEST_AABB);
        Block.addCollisionBoxToList(llllllllllllllllIIIIllIlllIIIIII, llllllllllllllllIIIIllIllIllllll, llllllllllllllllIIIIllIllIlllllI, BlockHopper.SOUTH_AABB);
        Block.addCollisionBoxToList(llllllllllllllllIIIIllIlllIIIIII, llllllllllllllllIIIIllIllIllllll, llllllllllllllllIIIIllIllIlllllI, BlockHopper.NORTH_AABB);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllllIIIIllIlIIlllllI, final IBlockAccess llllllllllllllllIIIIllIlIIllllIl, final BlockPos llllllllllllllllIIIIllIlIIllllII, final EnumFacing llllllllllllllllIIIIllIlIIlllIll) {
        return true;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllllIIIIllIllIIlllIl, final BlockPos llllllllllllllllIIIIllIllIIlIlIl, final IBlockState llllllllllllllllIIIIllIllIIllIll, final EntityLivingBase llllllllllllllllIIIIllIllIIllIlI, final ItemStack llllllllllllllllIIIIllIllIIlIIlI) {
        super.onBlockPlacedBy(llllllllllllllllIIIIllIllIIlllIl, llllllllllllllllIIIIllIllIIlIlIl, llllllllllllllllIIIIllIllIIllIll, llllllllllllllllIIIIllIllIIllIlI, llllllllllllllllIIIIllIllIIlIIlI);
        if (llllllllllllllllIIIIllIllIIlIIlI.hasDisplayName()) {
            final TileEntity llllllllllllllllIIIIllIllIIllIII = llllllllllllllllIIIIllIllIIlllIl.getTileEntity(llllllllllllllllIIIIllIllIIlIlIl);
            if (llllllllllllllllIIIIllIllIIllIII instanceof TileEntityHopper) {
                ((TileEntityHopper)llllllllllllllllIIIIllIllIIllIII).func_190575_a(llllllllllllllllIIIIllIllIIlIIlI.getDisplayName());
            }
        }
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllllIIIIllIlIlllIIll, final BlockPos llllllllllllllllIIIIllIlIlllllII, final IBlockState llllllllllllllllIIIIllIlIllllIll, final EntityPlayer llllllllllllllllIIIIllIlIllllIlI, final EnumHand llllllllllllllllIIIIllIlIllllIIl, final EnumFacing llllllllllllllllIIIIllIlIllllIII, final float llllllllllllllllIIIIllIlIlllIlll, final float llllllllllllllllIIIIllIlIlllIllI, final float llllllllllllllllIIIIllIlIlllIlIl) {
        if (llllllllllllllllIIIIllIlIlllIIll.isRemote) {
            return true;
        }
        final TileEntity llllllllllllllllIIIIllIlIlllIlII = llllllllllllllllIIIIllIlIlllIIll.getTileEntity(llllllllllllllllIIIIllIlIlllllII);
        if (llllllllllllllllIIIIllIlIlllIlII instanceof TileEntityHopper) {
            llllllllllllllllIIIIllIlIllllIlI.displayGUIChest((IInventory)llllllllllllllllIIIIllIlIlllIlII);
            llllllllllllllllIIIIllIlIllllIlI.addStat(StatList.HOPPER_INSPECTED);
        }
        return true;
    }
    
    static {
        FACING = PropertyDirection.create("facing", (Predicate<EnumFacing>)new Predicate<EnumFacing>() {
            public boolean apply(@Nullable final EnumFacing llllllllllllllIlllIIllllIIIIIlll) {
                return llllllllllllllIlllIIllllIIIIIlll != EnumFacing.UP;
            }
        });
        ENABLED = PropertyBool.create("enabled");
        BASE_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.625, 1.0);
        SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.125);
        NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.875, 1.0, 1.0, 1.0);
        WEST_AABB = new AxisAlignedBB(0.875, 0.0, 0.0, 1.0, 1.0, 1.0);
        EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.125, 1.0, 1.0);
    }
    
    private void updateState(final World llllllllllllllllIIIIllIlIlIllIII, final BlockPos llllllllllllllllIIIIllIlIlIllIll, final IBlockState llllllllllllllllIIIIllIlIlIlIllI) {
        final boolean llllllllllllllllIIIIllIlIlIllIIl = !llllllllllllllllIIIIllIlIlIllIII.isBlockPowered(llllllllllllllllIIIIllIlIlIllIll);
        if (llllllllllllllllIIIIllIlIlIllIIl != llllllllllllllllIIIIllIlIlIlIllI.getValue((IProperty<Boolean>)BlockHopper.ENABLED)) {
            llllllllllllllllIIIIllIlIlIllIII.setBlockState(llllllllllllllllIIIIllIlIlIllIll, llllllllllllllllIIIIllIlIlIlIllI.withProperty((IProperty<Comparable>)BlockHopper.ENABLED, llllllllllllllllIIIIllIlIlIllIIl), 4);
        }
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllllllIIIIllIlIlIIIlII) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllllIIIIllIllIlIIlll, final int llllllllllllllllIIIIllIllIlIIllI) {
        return new TileEntityHopper();
    }
    
    public static EnumFacing getFacing(final int llllllllllllllllIIIIllIlIIlllIIl) {
        return EnumFacing.getFront(llllllllllllllllIIIIllIlIIlllIIl & 0x7);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllllIIIIllIlIIIllIIl, final Rotation llllllllllllllllIIIIllIlIIIllIII) {
        return llllllllllllllllIIIIllIlIIIllIIl.withProperty((IProperty<Comparable>)BlockHopper.FACING, llllllllllllllllIIIIllIlIIIllIII.rotate(llllllllllllllllIIIIllIlIIIllIIl.getValue((IProperty<EnumFacing>)BlockHopper.FACING)));
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState llllllllllllllllIIIIllIlIIlIllll, final World llllllllllllllllIIIIllIlIIlIllII, final BlockPos llllllllllllllllIIIIllIlIIlIllIl) {
        return Container.calcRedstone(llllllllllllllllIIIIllIlIIlIllII.getTileEntity(llllllllllllllllIIIIllIlIIlIllIl));
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllllIIIIllIllIllIlII, final BlockPos llllllllllllllllIIIIllIllIllIIll, final EnumFacing llllllllllllllllIIIIllIllIllIIlI, final float llllllllllllllllIIIIllIllIllIIIl, final float llllllllllllllllIIIIllIllIllIIII, final float llllllllllllllllIIIIllIllIlIllll, final int llllllllllllllllIIIIllIllIlIlllI, final EntityLivingBase llllllllllllllllIIIIllIllIlIllIl) {
        EnumFacing llllllllllllllllIIIIllIllIlIllII = llllllllllllllllIIIIllIllIllIIlI.getOpposite();
        if (llllllllllllllllIIIIllIllIlIllII == EnumFacing.UP) {
            llllllllllllllllIIIIllIllIlIllII = EnumFacing.DOWN;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockHopper.FACING, llllllllllllllllIIIIllIllIlIllII).withProperty((IProperty<Comparable>)BlockHopper.ENABLED, true);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllllIIIIllIlIlIIIIlI) {
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllllIIIIllIlIllIlIlI, final World llllllllllllllllIIIIllIlIllIlIIl, final BlockPos llllllllllllllllIIIIllIlIllIIIlI, final Block llllllllllllllllIIIIllIlIllIIlll, final BlockPos llllllllllllllllIIIIllIlIllIIllI) {
        this.updateState(llllllllllllllllIIIIllIlIllIlIIl, llllllllllllllllIIIIllIlIllIIIlI, llllllllllllllllIIIIllIlIllIlIlI);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllllIIIIllIlIIIIlIIl, final IBlockState llllllllllllllllIIIIllIlIIIIlIII, final BlockPos llllllllllllllllIIIIllIlIIIIIlll, final EnumFacing llllllllllllllllIIIIllIlIIIIIlIl) {
        return (llllllllllllllllIIIIllIlIIIIIlIl == EnumFacing.UP) ? BlockFaceShape.BOWL : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllllIIIIllIlIIlIIllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockHopper.FACING, getFacing(llllllllllllllllIIIIllIlIIlIIllI)).withProperty((IProperty<Comparable>)BlockHopper.ENABLED, isEnabled(llllllllllllllllIIIIllIlIIlIIllI));
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllllIIIIllIllIIIIlIl, final BlockPos llllllllllllllllIIIIllIllIIIlIII, final IBlockState llllllllllllllllIIIIllIllIIIIlll) {
        this.updateState(llllllllllllllllIIIIllIllIIIIlIl, llllllllllllllllIIIIllIllIIIlIII, llllllllllllllllIIIIllIllIIIIlll);
    }
}
