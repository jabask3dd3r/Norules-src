package net.minecraft.block;

import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;

public abstract class BlockPurpurSlab extends BlockSlab
{
    public static final /* synthetic */ PropertyEnum<Variant> VARIANT;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIIIllllllllllll) {
        IBlockState lllllllllllllllIlIIIlllllllllllI = this.getDefaultState().withProperty(BlockPurpurSlab.VARIANT, Variant.DEFAULT);
        if (!this.isDouble()) {
            lllllllllllllllIlIIIlllllllllllI = lllllllllllllllIlIIIlllllllllllI.withProperty(BlockPurpurSlab.HALF, ((lllllllllllllllIlIIIllllllllllll & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return lllllllllllllllIlIIIlllllllllllI;
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", Variant.class);
    }
    
    @Override
    public Comparable<?> getTypeForItem(final ItemStack lllllllllllllllIlIIIlllllllIlIII) {
        return Variant.DEFAULT;
    }
    
    @Override
    public String getUnlocalizedName(final int lllllllllllllllIlIIIlllllllIllII) {
        return super.getUnlocalizedName();
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIIlIIIIIIIIlIlI, final Random lllllllllllllllIlIIlIIIIIIIIlIIl, final int lllllllllllllllIlIIlIIIIIIIIlIII) {
        return Item.getItemFromBlock(Blocks.PURPUR_SLAB);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPurpurSlab.VARIANT }) : new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPurpurSlab.HALF, BlockPurpurSlab.VARIANT });
    }
    
    @Override
    public IProperty<?> getVariantProperty() {
        return BlockPurpurSlab.VARIANT;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIIIllllllllIllI) {
        int lllllllllllllllIlIIIllllllllIlIl = 0;
        if (!this.isDouble() && lllllllllllllllIlIIIllllllllIllI.getValue(BlockPurpurSlab.HALF) == EnumBlockHalf.TOP) {
            lllllllllllllllIlIIIllllllllIlIl |= 0x8;
        }
        return lllllllllllllllIlIIIllllllllIlIl;
    }
    
    public BlockPurpurSlab() {
        super(Material.ROCK, MapColor.MAGENTA);
        IBlockState lllllllllllllllIlIIlIIIIIIIIlllI = this.blockState.getBaseState();
        if (!this.isDouble()) {
            lllllllllllllllIlIIlIIIIIIIIlllI = lllllllllllllllIlIIlIIIIIIIIlllI.withProperty(BlockPurpurSlab.HALF, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(lllllllllllllllIlIIlIIIIIIIIlllI.withProperty(BlockPurpurSlab.VARIANT, Variant.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIlIIlIIIIIIIIIllI, final BlockPos lllllllllllllllIlIIlIIIIIIIIIlIl, final IBlockState lllllllllllllllIlIIlIIIIIIIIIlII) {
        return new ItemStack(Blocks.PURPUR_SLAB);
    }
    
    public static class Double extends BlockPurpurSlab
    {
        @Override
        public boolean isDouble() {
            return true;
        }
    }
    
    public static class Half extends BlockPurpurSlab
    {
        @Override
        public boolean isDouble() {
            return false;
        }
    }
    
    public enum Variant implements IStringSerializable
    {
        DEFAULT("DEFAULT", 0);
        
        @Override
        public String getName() {
            return "default";
        }
        
        private Variant(final String lllllllllllllIlIIllIlIllIIIIllII, final int lllllllllllllIlIIllIlIllIIIIlIll) {
        }
    }
}
