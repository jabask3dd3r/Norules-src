package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockConcretePowder extends BlockFalling
{
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> field_192426_a;
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIllIIlIIllllIIIllIl, final IBlockAccess lllllllllllllIllIIlIIllllIIIllll, final BlockPos lllllllllllllIllIIlIIllllIIIlllI) {
        return MapColor.func_193558_a(lllllllllllllIllIIlIIllllIIIllIl.getValue(BlockConcretePowder.field_192426_a));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockConcretePowder.field_192426_a });
    }
    
    public BlockConcretePowder() {
        super(Material.SAND);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockConcretePowder.field_192426_a, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    static {
        field_192426_a = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIllIIlIIllllIIllIll, final NonNullList<ItemStack> lllllllllllllIllIIlIIllllIIllIlI) {
        final short lllllllllllllIllIIlIIllllIIlIIll;
        final short lllllllllllllIllIIlIIllllIIlIlII = (short)((EnumDyeColor[])(Object)(lllllllllllllIllIIlIIllllIIlIIll = (short)(Object)EnumDyeColor.values())).length;
        for (Exception lllllllllllllIllIIlIIllllIIlIlIl = (Exception)0; lllllllllllllIllIIlIIllllIIlIlIl < lllllllllllllIllIIlIIllllIIlIlII; ++lllllllllllllIllIIlIIllllIIlIlIl) {
            final EnumDyeColor lllllllllllllIllIIlIIllllIIllIIl = lllllllllllllIllIIlIIllllIIlIIll[lllllllllllllIllIIlIIllllIIlIlIl];
            lllllllllllllIllIIlIIllllIIllIlI.add(new ItemStack(this, 1, lllllllllllllIllIIlIIllllIIllIIl.getMetadata()));
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllIIlIIllllIIIIIll) {
        return lllllllllllllIllIIlIIllllIIIIIll.getValue(BlockConcretePowder.field_192426_a).getMetadata();
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIllIIlIIllllIlIlIIl, final BlockPos lllllllllllllIllIIlIIllllIlIllII, final IBlockState lllllllllllllIllIIlIIllllIlIIlll) {
        if (!this.func_192425_e(lllllllllllllIllIIlIIllllIlIlIIl, lllllllllllllIllIIlIIllllIlIllII, lllllllllllllIllIIlIIllllIlIIlll)) {
            super.onBlockAdded(lllllllllllllIllIIlIIllllIlIlIIl, lllllllllllllIllIIlIIllllIlIllII, lllllllllllllIllIIlIIllllIlIIlll);
        }
    }
    
    @Override
    public void onEndFalling(final World lllllllllllllIllIIlIIllllllIIIIl, final BlockPos lllllllllllllIllIIlIIllllllIIlII, final IBlockState lllllllllllllIllIIlIIlllllIlllll, final IBlockState lllllllllllllIllIIlIIllllllIIIlI) {
        if (lllllllllllllIllIIlIIllllllIIIlI.getMaterial().isLiquid()) {
            lllllllllllllIllIIlIIllllllIIIIl.setBlockState(lllllllllllllIllIIlIIllllllIIlII, Blocks.field_192443_dR.getDefaultState().withProperty(BlockColored.COLOR, (EnumDyeColor)lllllllllllllIllIIlIIlllllIlllll.getValue((IProperty<V>)BlockConcretePowder.field_192426_a)), 3);
        }
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIllIIlIIllllIlIIIll) {
        return lllllllllllllIllIIlIIllllIlIIIll.getValue(BlockConcretePowder.field_192426_a).getMetadata();
    }
    
    protected boolean func_192425_e(final World lllllllllllllIllIIlIIlllllIIllIl, final BlockPos lllllllllllllIllIIlIIlllllIIllII, final IBlockState lllllllllllllIllIIlIIlllllIlIIIl) {
        boolean lllllllllllllIllIIlIIlllllIlIIII = false;
        final int lllllllllllllIllIIlIIlllllIIIllI;
        final long lllllllllllllIllIIlIIlllllIIIlll = ((EnumFacing[])(Object)(lllllllllllllIllIIlIIlllllIIIllI = (int)(Object)EnumFacing.values())).length;
        for (short lllllllllllllIllIIlIIlllllIIlIII = 0; lllllllllllllIllIIlIIlllllIIlIII < lllllllllllllIllIIlIIlllllIIIlll; ++lllllllllllllIllIIlIIlllllIIlIII) {
            final EnumFacing lllllllllllllIllIIlIIlllllIIllll = lllllllllllllIllIIlIIlllllIIIllI[lllllllllllllIllIIlIIlllllIIlIII];
            if (lllllllllllllIllIIlIIlllllIIllll != EnumFacing.DOWN) {
                final BlockPos lllllllllllllIllIIlIIlllllIIlllI = lllllllllllllIllIIlIIlllllIIllII.offset(lllllllllllllIllIIlIIlllllIIllll);
                if (lllllllllllllIllIIlIIlllllIIllIl.getBlockState(lllllllllllllIllIIlIIlllllIIlllI).getMaterial() == Material.WATER) {
                    lllllllllllllIllIIlIIlllllIlIIII = true;
                    break;
                }
            }
        }
        if (lllllllllllllIllIIlIIlllllIlIIII) {
            lllllllllllllIllIIlIIlllllIIllIl.setBlockState(lllllllllllllIllIIlIIlllllIIllII, Blocks.field_192443_dR.getDefaultState().withProperty(BlockColored.COLOR, (EnumDyeColor)lllllllllllllIllIIlIIlllllIlIIIl.getValue((IProperty<V>)BlockConcretePowder.field_192426_a)), 3);
        }
        return lllllllllllllIllIIlIIlllllIlIIII;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIllIIlIIllllIllIlll, final World lllllllllllllIllIIlIIllllIllIllI, final BlockPos lllllllllllllIllIIlIIllllIllIlIl, final Block lllllllllllllIllIIlIIllllIllIlII, final BlockPos lllllllllllllIllIIlIIllllIlllIIl) {
        if (!this.func_192425_e(lllllllllllllIllIIlIIllllIllIllI, lllllllllllllIllIIlIIllllIllIlIl, lllllllllllllIllIIlIIllllIllIlll)) {
            super.neighborChanged(lllllllllllllIllIIlIIllllIllIlll, lllllllllllllIllIIlIIllllIllIllI, lllllllllllllIllIIlIIllllIllIlIl, lllllllllllllIllIIlIIllllIllIlII, lllllllllllllIllIIlIIllllIlllIIl);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllIIlIIllllIIIlIIl) {
        return this.getDefaultState().withProperty(BlockConcretePowder.field_192426_a, EnumDyeColor.byMetadata(lllllllllllllIllIIlIIllllIIIlIIl));
    }
}
