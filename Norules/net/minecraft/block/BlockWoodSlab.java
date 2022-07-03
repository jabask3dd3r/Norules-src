package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public abstract class BlockWoodSlab extends BlockSlab
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIllIllIlIIIIlIIIIlI) {
        return lllllllllllllIllIllIlIIIIlIIIIlI.getValue(BlockWoodSlab.VARIANT).getMetadata();
    }
    
    @Override
    public IProperty<?> getVariantProperty() {
        return BlockWoodSlab.VARIANT;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllIllIlIIIIlIIlIlI) {
        int lllllllllllllIllIllIlIIIIlIIllII = 0;
        lllllllllllllIllIllIlIIIIlIIllII |= lllllllllllllIllIllIlIIIIlIIlIlI.getValue(BlockWoodSlab.VARIANT).getMetadata();
        if (!this.isDouble() && lllllllllllllIllIllIlIIIIlIIlIlI.getValue(BlockWoodSlab.HALF) == EnumBlockHalf.TOP) {
            lllllllllllllIllIllIlIIIIlIIllII |= 0x8;
        }
        return lllllllllllllIllIllIlIIIIlIIllII;
    }
    
    public BlockWoodSlab() {
        super(Material.WOOD);
        IBlockState lllllllllllllIllIllIlIIIlIIIlIII = this.blockState.getBaseState();
        if (!this.isDouble()) {
            lllllllllllllIllIllIlIIIlIIIlIII = lllllllllllllIllIllIlIIIlIIIlIII.withProperty(BlockWoodSlab.HALF, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(lllllllllllllIllIllIlIIIlIIIlIII.withProperty(BlockWoodSlab.VARIANT, BlockPlanks.EnumType.OAK));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIllIllIlIIIIllllllI, final Random lllllllllllllIllIllIlIIIIlllllIl, final int lllllllllllllIllIllIlIIIIlllllII) {
        return Item.getItemFromBlock(Blocks.WOODEN_SLAB);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockWoodSlab.VARIANT }) : new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockWoodSlab.HALF, BlockWoodSlab.VARIANT });
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIllIllIlIIIIllllIIl, final BlockPos lllllllllllllIllIllIlIIIIllllIII, final IBlockState lllllllllllllIllIllIlIIIIlllIllI) {
        return new ItemStack(Blocks.WOODEN_SLAB, 1, lllllllllllllIllIllIlIIIIlllIllI.getValue(BlockWoodSlab.VARIANT).getMetadata());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllIllIlIIIIlIlIllI) {
        IBlockState lllllllllllllIllIllIlIIIIlIlIlIl = this.getDefaultState().withProperty(BlockWoodSlab.VARIANT, BlockPlanks.EnumType.byMetadata(lllllllllllllIllIllIlIIIIlIlIllI & 0x7));
        if (!this.isDouble()) {
            lllllllllllllIllIllIlIIIIlIlIlIl = lllllllllllllIllIllIlIIIIlIlIlIl.withProperty(BlockWoodSlab.HALF, ((lllllllllllllIllIllIlIIIIlIlIllI & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return lllllllllllllIllIllIlIIIIlIlIlIl;
    }
    
    @Override
    public String getUnlocalizedName(final int lllllllllllllIllIllIlIIIIlllIIII) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(BlockPlanks.EnumType.byMetadata(lllllllllllllIllIllIlIIIIlllIIII).getUnlocalizedName()));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIllIllIlIIIlIIIIIll, final IBlockAccess lllllllllllllIllIllIlIIIlIIIIIlI, final BlockPos lllllllllllllIllIllIlIIIlIIIIIIl) {
        return lllllllllllllIllIllIlIIIlIIIIIll.getValue(BlockWoodSlab.VARIANT).getMapColor();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIllIllIlIIIIllIIIll, final NonNullList<ItemStack> lllllllllllllIllIllIlIIIIlIlllll) {
        final float lllllllllllllIllIllIlIIIIlIllIll;
        final int lllllllllllllIllIllIlIIIIlIlllII = ((BlockPlanks.EnumType[])(Object)(lllllllllllllIllIllIlIIIIlIllIll = (float)(Object)BlockPlanks.EnumType.values())).length;
        for (double lllllllllllllIllIllIlIIIIlIlllIl = 0; lllllllllllllIllIllIlIIIIlIlllIl < lllllllllllllIllIllIlIIIIlIlllII; ++lllllllllllllIllIllIlIIIIlIlllIl) {
            final BlockPlanks.EnumType lllllllllllllIllIllIlIIIIllIIIIl = lllllllllllllIllIllIlIIIIlIllIll[lllllllllllllIllIllIlIIIIlIlllIl];
            lllllllllllllIllIllIlIIIIlIlllll.add(new ItemStack(this, 1, lllllllllllllIllIllIlIIIIllIIIIl.getMetadata()));
        }
    }
    
    @Override
    public Comparable<?> getTypeForItem(final ItemStack lllllllllllllIllIllIlIIIIllIlIll) {
        return BlockPlanks.EnumType.byMetadata(lllllllllllllIllIllIlIIIIllIlIll.getMetadata() & 0x7);
    }
}
