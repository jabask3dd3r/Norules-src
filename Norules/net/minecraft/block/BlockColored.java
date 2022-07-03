package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;

public class BlockColored extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> COLOR;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIIIllIlllIIIIllll) {
        return lllllllllllllIlIIIllIlllIIIIllll.getValue(BlockColored.COLOR).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIIIllIlllIIIlIIlI) {
        return this.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(lllllllllllllIlIIIllIlllIIIlIIlI));
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIlIIIllIlllIIlIIllI, final NonNullList<ItemStack> lllllllllllllIlIIIllIlllIIlIIlIl) {
        final short lllllllllllllIlIIIllIlllIIIllllI;
        final short lllllllllllllIlIIIllIlllIIIlllll = (short)((EnumDyeColor[])(Object)(lllllllllllllIlIIIllIlllIIIllllI = (short)(Object)EnumDyeColor.values())).length;
        for (double lllllllllllllIlIIIllIlllIIlIIIII = 0; lllllllllllllIlIIIllIlllIIlIIIII < lllllllllllllIlIIIllIlllIIIlllll; ++lllllllllllllIlIIIllIlllIIlIIIII) {
            final EnumDyeColor lllllllllllllIlIIIllIlllIIlIIlII = lllllllllllllIlIIIllIlllIIIllllI[lllllllllllllIlIIIllIlllIIlIIIII];
            lllllllllllllIlIIIllIlllIIlIIlIl.add(new ItemStack(this, 1, lllllllllllllIlIIIllIlllIIlIIlII.getMetadata()));
        }
    }
    
    static {
        COLOR = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIlIIIllIlllIIIllIll, final IBlockAccess lllllllllllllIlIIIllIlllIIIllIlI, final BlockPos lllllllllllllIlIIIllIlllIIIllIIl) {
        return MapColor.func_193558_a(lllllllllllllIlIIIllIlllIIIllIll.getValue(BlockColored.COLOR));
    }
    
    public BlockColored(final Material lllllllllllllIlIIIllIlllIIllIlII) {
        super(lllllllllllllIlIIIllIlllIIllIlII);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIlIIIllIlllIIlIllll) {
        return lllllllllllllIlIIIllIlllIIlIllll.getValue(BlockColored.COLOR).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockColored.COLOR });
    }
}
