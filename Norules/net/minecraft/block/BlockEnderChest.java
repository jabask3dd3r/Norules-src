package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;

public class BlockEnderChest extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB ENDER_CHEST_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIllIllIllIIIIIlIIl, final IBlockAccess llllllllllllllIllIllIllIIIIIlIII, final BlockPos llllllllllllllIllIllIllIIIIIIlll) {
        return BlockEnderChest.ENDER_CHEST_AABB;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllllIllIllIlIllIllIllI, final World llllllllllllllIllIllIlIllIlIIlll, final BlockPos llllllllllllllIllIllIlIllIlIIllI, final Random llllllllllllllIllIllIlIllIllIIll) {
        for (int llllllllllllllIllIllIlIllIllIIlI = 0; llllllllllllllIllIllIlIllIllIIlI < 3; ++llllllllllllllIllIllIlIllIllIIlI) {
            final int llllllllllllllIllIllIlIllIllIIIl = llllllllllllllIllIllIlIllIllIIll.nextInt(2) * 2 - 1;
            final int llllllllllllllIllIllIlIllIllIIII = llllllllllllllIllIllIlIllIllIIll.nextInt(2) * 2 - 1;
            final double llllllllllllllIllIllIlIllIlIllll = llllllllllllllIllIllIlIllIlIIllI.getX() + 0.5 + 0.25 * llllllllllllllIllIllIlIllIllIIIl;
            final double llllllllllllllIllIllIlIllIlIlllI = llllllllllllllIllIllIlIllIlIIllI.getY() + llllllllllllllIllIllIlIllIllIIll.nextFloat();
            final double llllllllllllllIllIllIlIllIlIllIl = llllllllllllllIllIllIlIllIlIIllI.getZ() + 0.5 + 0.25 * llllllllllllllIllIllIlIllIllIIII;
            final double llllllllllllllIllIllIlIllIlIllII = llllllllllllllIllIllIlIllIllIIll.nextFloat() * llllllllllllllIllIllIlIllIllIIIl;
            final double llllllllllllllIllIllIlIllIlIlIll = (llllllllllllllIllIllIlIllIllIIll.nextFloat() - 0.5) * 0.125;
            final double llllllllllllllIllIllIlIllIlIlIlI = llllllllllllllIllIllIlIllIllIIll.nextFloat() * llllllllllllllIllIllIlIllIllIIII;
            llllllllllllllIllIllIlIllIlIIlll.spawnParticle(EnumParticleTypes.PORTAL, llllllllllllllIllIllIlIllIlIllll, llllllllllllllIllIllIlIllIlIlllI, llllllllllllllIllIllIlIllIlIllIl, llllllllllllllIllIllIlIllIlIllII, llllllllllllllIllIllIlIllIlIlIll, llllllllllllllIllIllIlIllIlIlIlI, new int[0]);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIllIllIllIIIIIIlIl) {
        return false;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllIllIllIlIllIIIlIll, final Rotation llllllllllllllIllIllIlIllIIIllII) {
        return llllllllllllllIllIllIlIllIIIlIll.withProperty((IProperty<Comparable>)BlockEnderChest.FACING, llllllllllllllIllIllIlIllIIIllII.rotate(llllllllllllllIllIllIlIllIIIlIll.getValue((IProperty<EnumFacing>)BlockEnderChest.FACING)));
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIllIllIlIllllIIlIl, final BlockPos llllllllllllllIllIllIlIlllIlllll, final IBlockState llllllllllllllIllIllIlIllllIIIll, final EntityLivingBase llllllllllllllIllIllIlIlllIlllIl, final ItemStack llllllllllllllIllIllIlIllllIIIIl) {
        llllllllllllllIllIllIlIllllIIlIl.setBlockState(llllllllllllllIllIllIlIlllIlllll, llllllllllllllIllIllIlIllllIIIll.withProperty((IProperty<Comparable>)BlockEnderChest.FACING, llllllllllllllIllIllIlIlllIlllIl.getHorizontalFacing().getOpposite()), 2);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIllIllIllIIIIIIIll) {
        return false;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllIllIllIlIllIIIIllI, final Mirror llllllllllllllIllIllIlIllIIIIlIl) {
        return llllllllllllllIllIllIlIllIIIIllI.withRotation(llllllllllllllIllIllIlIllIIIIlIl.toRotation(llllllllllllllIllIllIlIllIIIIllI.getValue((IProperty<EnumFacing>)BlockEnderChest.FACING)));
    }
    
    protected BlockEnderChest() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockEnderChest.FACING, EnumFacing.NORTH));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean func_190946_v(final IBlockState llllllllllllllIllIllIllIIIIIIIIl) {
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIllIllIlIlIllllllI, final IBlockState llllllllllllllIllIllIlIlIlllllIl, final BlockPos llllllllllllllIllIllIlIlIlllllII, final EnumFacing llllllllllllllIllIllIlIlIllllIll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIllIllIlIlllllllIl, final Random llllllllllllllIllIllIlIlllllllII, final int llllllllllllllIllIllIlIllllllIll) {
        return Item.getItemFromBlock(Blocks.OBSIDIAN);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIllIllIlIllIIllIIl) {
        EnumFacing llllllllllllllIllIllIlIllIIllIII = EnumFacing.getFront(llllllllllllllIllIllIlIllIIllIIl);
        if (llllllllllllllIllIllIlIllIIllIII.getAxis() == EnumFacing.Axis.Y) {
            llllllllllllllIllIllIlIllIIllIII = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEnderChest.FACING, llllllllllllllIllIllIlIllIIllIII);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIllIllIlIllllllIIl) {
        return 8;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockEnderChest.FACING });
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIllIllIlIlllllIlII, final BlockPos llllllllllllllIllIllIlIlllllIIll, final EnumFacing llllllllllllllIllIllIlIlllllIIlI, final float llllllllllllllIllIllIlIlllllIIIl, final float llllllllllllllIllIllIlIlllllIIII, final float llllllllllllllIllIllIlIllllIllll, final int llllllllllllllIllIllIlIllllIlllI, final EntityLivingBase llllllllllllllIllIllIlIllllIlIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEnderChest.FACING, llllllllllllllIllIllIlIllllIlIll.getHorizontalFacing().getOpposite());
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIllIllIlIllIIlIIIl) {
        return llllllllllllllIllIllIlIllIIlIIIl.getValue((IProperty<EnumFacing>)BlockEnderChest.FACING).getIndex();
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIllIllIlIlllIIIlIl, final int llllllllllllllIllIllIlIlllIIIlII) {
        return new TileEntityEnderChest();
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIllIllIlIlllIIlIll, final BlockPos llllllllllllllIllIllIlIlllIlIlIl, final IBlockState llllllllllllllIllIllIlIlllIlIlII, final EntityPlayer llllllllllllllIllIllIlIlllIIlIIl, final EnumHand llllllllllllllIllIllIlIlllIlIIlI, final EnumFacing llllllllllllllIllIllIlIlllIlIIIl, final float llllllllllllllIllIllIlIlllIlIIII, final float llllllllllllllIllIllIlIlllIIllll, final float llllllllllllllIllIllIlIlllIIlllI) {
        final InventoryEnderChest llllllllllllllIllIllIlIlllIIllIl = llllllllllllllIllIllIlIlllIIlIIl.getInventoryEnderChest();
        final TileEntity llllllllllllllIllIllIlIlllIIllII = llllllllllllllIllIllIlIlllIIlIll.getTileEntity(llllllllllllllIllIllIlIlllIlIlIl);
        if (llllllllllllllIllIllIlIlllIIllIl == null || !(llllllllllllllIllIllIlIlllIIllII instanceof TileEntityEnderChest)) {
            return true;
        }
        if (llllllllllllllIllIllIlIlllIIlIll.getBlockState(llllllllllllllIllIllIlIlllIlIlIl.up()).isNormalCube()) {
            return true;
        }
        if (llllllllllllllIllIllIlIlllIIlIll.isRemote) {
            return true;
        }
        llllllllllllllIllIllIlIlllIIllIl.setChestTileEntity((TileEntityEnderChest)llllllllllllllIllIllIlIlllIIllII);
        llllllllllllllIllIllIlIlllIIlIIl.displayGUIChest(llllllllllllllIllIllIlIlllIIllIl);
        llllllllllllllIllIllIlIlllIIlIIl.addStat(StatList.ENDERCHEST_OPENED);
        return true;
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        ENDER_CHEST_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.875, 0.9375);
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllllIllIllIlIlllllllll) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }
}
