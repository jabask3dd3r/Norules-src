package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import java.util.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.inventory.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockBrewingStand extends BlockContainer
{
    public static final /* synthetic */ PropertyBool[] HAS_BOTTLE;
    protected static final /* synthetic */ AxisAlignedBB STICK_AABB;
    protected static final /* synthetic */ AxisAlignedBB BASE_AABB;
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllIlIlIIIIIllIlIIllIl, final BlockPos lllllllllllllIlIlIIIIIllIlIIllII, final IBlockState lllllllllllllIlIlIIIIIllIlIlIIIl, final EntityLivingBase lllllllllllllIlIlIIIIIllIlIlIIII, final ItemStack lllllllllllllIlIlIIIIIllIlIIlIll) {
        if (lllllllllllllIlIlIIIIIllIlIIlIll.hasDisplayName()) {
            final TileEntity lllllllllllllIlIlIIIIIllIlIIlllI = lllllllllllllIlIlIIIIIllIlIIllIl.getTileEntity(lllllllllllllIlIlIIIIIllIlIIllII);
            if (lllllllllllllIlIlIIIIIllIlIIlllI instanceof TileEntityBrewingStand) {
                ((TileEntityBrewingStand)lllllllllllllIlIlIIIIIllIlIIlllI).setName(lllllllllllllIlIlIIIIIllIlIIlIll.getDisplayName());
            }
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIlIlIIIIIlllIIIIIIl, final int lllllllllllllIlIlIIIIIlllIIIIIII) {
        return new TileEntityBrewingStand();
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.brewingStand.name");
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIlIlIIIIIlIlllllIIl, final IBlockState lllllllllllllIlIlIIIIIlIlllllIII, final BlockPos lllllllllllllIlIlIIIIIlIllllIlll, final EnumFacing lllllllllllllIlIlIIIIIlIllllIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllIlIlIIIIIllIIIlllIl) {
        return true;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIlIlIIIIIllIllllllI) {
        return false;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllIlIlIIIIIllIlIIIIlI, final World lllllllllllllIlIlIIIIIllIIlllIll, final BlockPos lllllllllllllIlIlIIIIIllIIlllIlI, final Random lllllllllllllIlIlIIIIIllIIlllIIl) {
        final double lllllllllllllIlIlIIIIIllIIlllllI = lllllllllllllIlIlIIIIIllIIlllIlI.getX() + 0.4f + lllllllllllllIlIlIIIIIllIIlllIIl.nextFloat() * 0.2f;
        final double lllllllllllllIlIlIIIIIllIIllllIl = lllllllllllllIlIlIIIIIllIIlllIlI.getY() + 0.7f + lllllllllllllIlIlIIIIIllIIlllIIl.nextFloat() * 0.3f;
        final double lllllllllllllIlIlIIIIIllIIllllII = lllllllllllllIlIlIIIIIllIIlllIlI.getZ() + 0.4f + lllllllllllllIlIlIIIIIllIIlllIIl.nextFloat() * 0.2f;
        lllllllllllllIlIlIIIIIllIIlllIll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllIlIlIIIIIllIIlllllI, lllllllllllllIlIlIIIIIllIIllllIl, lllllllllllllIlIlIIIIIllIIllllII, 0.0, 0.0, 0.0, new int[0]);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIlIIIIIllIIIIlIlI) {
        IBlockState lllllllllllllIlIlIIIIIllIIIIllIl = this.getDefaultState();
        for (int lllllllllllllIlIlIIIIIllIIIIllII = 0; lllllllllllllIlIlIIIIIllIIIIllII < 3; ++lllllllllllllIlIlIIIIIllIIIIllII) {
            lllllllllllllIlIlIIIIIllIIIIllIl = lllllllllllllIlIlIIIIIllIIIIllIl.withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[lllllllllllllIlIlIIIIIllIIIIllII], (lllllllllllllIlIlIIIIIllIIIIlIlI & 1 << lllllllllllllIlIlIIIIIllIIIIllII) > 0);
        }
        return lllllllllllllIlIlIIIIIllIIIIllIl;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlIlIIIIIllIIlIIlIl, final Random lllllllllllllIlIlIIIIIllIIlIIlII, final int lllllllllllllIlIlIIIIIllIIlIIIll) {
        return Items.BREWING_STAND;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIlIIIIIllIIIIIIII) {
        int lllllllllllllIlIlIIIIIllIIIIIIlI = 0;
        for (int lllllllllllllIlIlIIIIIllIIIIIIIl = 0; lllllllllllllIlIlIIIIIllIIIIIIIl < 3; ++lllllllllllllIlIlIIIIIllIIIIIIIl) {
            if (lllllllllllllIlIlIIIIIllIIIIIIII.getValue((IProperty<Boolean>)BlockBrewingStand.HAS_BOTTLE[lllllllllllllIlIlIIIIIllIIIIIIIl])) {
                lllllllllllllIlIlIIIIIllIIIIIIlI |= 1 << lllllllllllllIlIlIIIIIllIIIIIIIl;
            }
        }
        return lllllllllllllIlIlIIIIIllIIIIIIlI;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIlIlIIIIIllIlIlllII, final BlockPos lllllllllllllIlIlIIIIIllIlIllIll, final IBlockState lllllllllllllIlIlIIIIIllIllIIlII, final EntityPlayer lllllllllllllIlIlIIIIIllIllIIIll, final EnumHand lllllllllllllIlIlIIIIIllIllIIIlI, final EnumFacing lllllllllllllIlIlIIIIIllIllIIIIl, final float lllllllllllllIlIlIIIIIllIllIIIII, final float lllllllllllllIlIlIIIIIllIlIlllll, final float lllllllllllllIlIlIIIIIllIlIllllI) {
        if (lllllllllllllIlIlIIIIIllIlIlllII.isRemote) {
            return true;
        }
        final TileEntity lllllllllllllIlIlIIIIIllIlIlllIl = lllllllllllllIlIlIIIIIllIlIlllII.getTileEntity(lllllllllllllIlIlIIIIIllIlIllIll);
        if (lllllllllllllIlIlIIIIIllIlIlllIl instanceof TileEntityBrewingStand) {
            lllllllllllllIlIlIIIIIllIllIIIll.displayGUIChest((IInventory)lllllllllllllIlIlIIIIIllIlIlllIl);
            lllllllllllllIlIlIIIIIllIllIIIll.addStat(StatList.BREWINGSTAND_INTERACTION);
        }
        return true;
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllllIlIlIIIIIllIllllIIl, final World lllllllllllllIlIlIIIIIllIllllIII, final BlockPos lllllllllllllIlIlIIIIIllIlllIlll, final AxisAlignedBB lllllllllllllIlIlIIIIIllIlllIIIl, final List<AxisAlignedBB> lllllllllllllIlIlIIIIIllIlllIlIl, @Nullable final Entity lllllllllllllIlIlIIIIIllIlllIlII, final boolean lllllllllllllIlIlIIIIIllIlllIIll) {
        Block.addCollisionBoxToList(lllllllllllllIlIlIIIIIllIlllIlll, lllllllllllllIlIlIIIIIllIlllIIIl, lllllllllllllIlIlIIIIIllIlllIlIl, BlockBrewingStand.STICK_AABB);
        Block.addCollisionBoxToList(lllllllllllllIlIlIIIIIllIlllIlll, lllllllllllllIlIlIIIIIllIlllIIIl, lllllllllllllIlIlIIIIIllIlllIlIl, BlockBrewingStand.BASE_AABB);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIlIlIIIIIllIllIlllI, final IBlockAccess lllllllllllllIlIlIIIIIllIllIllIl, final BlockPos lllllllllllllIlIlIIIIIllIllIllII) {
        return BlockBrewingStand.BASE_AABB;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlIlIIIIIllIIlIIIIl, final BlockPos lllllllllllllIlIlIIIIIllIIlIIIII, final IBlockState lllllllllllllIlIlIIIIIllIIIlllll) {
        return new ItemStack(Items.BREWING_STAND);
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllIlIlIIIIIllIIIllIIl, final World lllllllllllllIlIlIIIIIllIIIlIllI, final BlockPos lllllllllllllIlIlIIIIIllIIIlIlIl) {
        return Container.calcRedstone(lllllllllllllIlIlIIIIIllIIIlIllI.getTileEntity(lllllllllllllIlIlIIIIIllIIIlIlIl));
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIlIlIIIIIllIIlIllll, final BlockPos lllllllllllllIlIlIIIIIllIIlIlllI, final IBlockState lllllllllllllIlIlIIIIIllIIlIlIII) {
        final TileEntity lllllllllllllIlIlIIIIIllIIlIllII = lllllllllllllIlIlIIIIIllIIlIllll.getTileEntity(lllllllllllllIlIlIIIIIllIIlIlllI);
        if (lllllllllllllIlIlIIIIIllIIlIllII instanceof TileEntityBrewingStand) {
            InventoryHelper.dropInventoryItems(lllllllllllllIlIlIIIIIllIIlIllll, lllllllllllllIlIlIIIIIllIIlIlllI, (IInventory)lllllllllllllIlIlIIIIIllIIlIllII);
        }
        super.breakBlock(lllllllllllllIlIlIIIIIllIIlIllll, lllllllllllllIlIlIIIIIllIIlIlllI, lllllllllllllIlIlIIIIIllIIlIlIII);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBrewingStand.HAS_BOTTLE[0], BlockBrewingStand.HAS_BOTTLE[1], BlockBrewingStand.HAS_BOTTLE[2] });
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIlIlIIIIIlllIIIIlIl) {
        return false;
    }
    
    public BlockBrewingStand() {
        super(Material.IRON);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[0], false).withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[1], false).withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[2], false));
    }
    
    static {
        HAS_BOTTLE = new PropertyBool[] { PropertyBool.create("has_bottle_0"), PropertyBool.create("has_bottle_1"), PropertyBool.create("has_bottle_2") };
        BASE_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
        STICK_AABB = new AxisAlignedBB(0.4375, 0.0, 0.4375, 0.5625, 0.875, 0.5625);
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllIlIlIIIIIlllIIIIIll) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}
