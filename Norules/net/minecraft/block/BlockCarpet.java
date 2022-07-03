package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;

public class BlockCarpet extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> COLOR;
    protected static final /* synthetic */ AxisAlignedBB CARPET_AABB;
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIlIlIllIIlIIlIIIIlI, final BlockPos lllllllllllllIlIlIllIIlIIlIIIIIl) {
        return super.canPlaceBlockAt(lllllllllllllIlIlIllIIlIIlIIIIlI, lllllllllllllIlIlIllIIlIIlIIIIIl) && this.canBlockStay(lllllllllllllIlIlIllIIlIIlIIIIlI, lllllllllllllIlIlIllIIlIIlIIIIIl);
    }
    
    private boolean checkForDrop(final World lllllllllllllIlIlIllIIlIIIlIlIIl, final BlockPos lllllllllllllIlIlIllIIlIIIlIlIII, final IBlockState lllllllllllllIlIlIllIIlIIIlIIlll) {
        if (!this.canBlockStay(lllllllllllllIlIlIllIIlIIIlIlIIl, lllllllllllllIlIlIllIIlIIIlIlIII)) {
            this.dropBlockAsItem(lllllllllllllIlIlIllIIlIIIlIlIIl, lllllllllllllIlIlIllIIlIIIlIlIII, lllllllllllllIlIlIllIIlIIIlIIlll, 0);
            lllllllllllllIlIlIllIIlIIIlIlIIl.setBlockToAir(lllllllllllllIlIlIllIIlIIIlIlIII);
            return false;
        }
        return true;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIlIllIIIlllllllll) {
        return this.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.byMetadata(lllllllllllllIlIlIllIIIlllllllll));
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIlIlIllIIlIIIIIlllI) {
        return lllllllllllllIlIlIllIIlIIIIIlllI.getValue(BlockCarpet.COLOR).getMetadata();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIlIlIllIIlIIIIIlIII, final NonNullList<ItemStack> lllllllllllllIlIlIllIIlIIIIIIlll) {
        for (int lllllllllllllIlIlIllIIlIIIIIIllI = 0; lllllllllllllIlIlIllIIlIIIIIIllI < 16; ++lllllllllllllIlIlIllIIlIIIIIIllI) {
            lllllllllllllIlIlIllIIlIIIIIIlll.add(new ItemStack(this, 1, lllllllllllllIlIlIllIIlIIIIIIllI));
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIlIlIllIIlIIlIIlIlI) {
        return false;
    }
    
    private boolean canBlockStay(final World lllllllllllllIlIlIllIIlIIIlIIIll, final BlockPos lllllllllllllIlIlIllIIlIIIlIIIII) {
        return !lllllllllllllIlIlIllIIlIIIlIIIll.isAirBlock(lllllllllllllIlIlIllIIlIIIlIIIII.down());
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIlIlIllIIlIIlIIllII) {
        return false;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIlIllIIIllllllIlI) {
        return lllllllllllllIlIlIllIIIllllllIlI.getValue(BlockCarpet.COLOR).getMetadata();
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllIlIlIllIIlIIIIllIIl, final IBlockAccess lllllllllllllIlIlIllIIlIIIIllIII, final BlockPos lllllllllllllIlIlIllIIlIIIIlIlll, final EnumFacing lllllllllllllIlIlIllIIlIIIIlIIIl) {
        return lllllllllllllIlIlIllIIlIIIIlIIIl == EnumFacing.UP || lllllllllllllIlIlIllIIlIIIIllIII.getBlockState(lllllllllllllIlIlIllIIlIIIIlIlll.offset(lllllllllllllIlIlIllIIlIIIIlIIIl)).getBlock() == this || super.shouldSideBeRendered(lllllllllllllIlIlIllIIlIIIIllIIl, lllllllllllllIlIlIllIIlIIIIllIII, lllllllllllllIlIlIllIIlIIIIlIlll, lllllllllllllIlIlIllIIlIIIIlIIIl);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCarpet.COLOR });
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIlIlIllIIlIIlIlIllI, final IBlockAccess lllllllllllllIlIlIllIIlIIlIlIlIl, final BlockPos lllllllllllllIlIlIllIIlIIlIlIlII) {
        return BlockCarpet.CARPET_AABB;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIlIlIllIIIlllllIIll, final IBlockState lllllllllllllIlIlIllIIIlllllIIlI, final BlockPos lllllllllllllIlIlIllIIIlllllIIIl, final EnumFacing lllllllllllllIlIlIllIIIlllllIIII) {
        return (lllllllllllllIlIlIllIIIlllllIIII == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    static {
        COLOR = PropertyEnum.create("color", EnumDyeColor.class);
        CARPET_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);
    }
    
    protected BlockCarpet() {
        super(Material.CARPET);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIlIlIllIIlIIIlllIll, final World lllllllllllllIlIlIllIIlIIIlllIlI, final BlockPos lllllllllllllIlIlIllIIlIIIlllIIl, final Block lllllllllllllIlIlIllIIlIIIlllIII, final BlockPos lllllllllllllIlIlIllIIlIIIllIlll) {
        this.checkForDrop(lllllllllllllIlIlIllIIlIIIlllIlI, lllllllllllllIlIlIllIIlIIIlllIIl, lllllllllllllIlIlIllIIlIIIlllIll);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIlIlIllIIlIIlIIlllI, final IBlockAccess lllllllllllllIlIlIllIIlIIlIlIIII, final BlockPos lllllllllllllIlIlIllIIlIIlIIllll) {
        return MapColor.func_193558_a(lllllllllllllIlIlIllIIlIIlIIlllI.getValue(BlockCarpet.COLOR));
    }
}
