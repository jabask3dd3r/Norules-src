package net.minecraft.block;

import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public abstract class BlockStoneSlabNew extends BlockSlab
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    public static final /* synthetic */ PropertyBool SEAMLESS;
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIIllIIlIlllIIll, final Random lllllllllllllllIlIIllIIlIlllIIlI, final int lllllllllllllllIlIIllIIlIlllIIIl) {
        return Item.getItemFromBlock(Blocks.STONE_SLAB2);
    }
    
    @Override
    public IProperty<?> getVariantProperty() {
        return BlockStoneSlabNew.VARIANT;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIlIIllIIlIllIlllI, final BlockPos lllllllllllllllIlIIllIIlIllIllIl, final IBlockState lllllllllllllllIlIIllIIlIllIlIll) {
        return new ItemStack(Blocks.STONE_SLAB2, 1, lllllllllllllllIlIIllIIlIllIlIll.getValue(BlockStoneSlabNew.VARIANT).getMetadata());
    }
    
    @Override
    public String getUnlocalizedName(final int lllllllllllllllIlIIllIIlIllIIlll) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(EnumType.byMetadata(lllllllllllllllIlIIllIIlIllIIlll).getUnlocalizedName()));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIlIIllIIlIIlllIII, final IBlockAccess lllllllllllllllIlIIllIIlIIllIlll, final BlockPos lllllllllllllllIlIIllIIlIIllIllI) {
        return lllllllllllllllIlIIllIIlIIlllIII.getValue(BlockStoneSlabNew.VARIANT).getMapColor();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIIllIIlIlIIlIII) {
        IBlockState lllllllllllllllIlIIllIIlIlIIlIlI = this.getDefaultState().withProperty(BlockStoneSlabNew.VARIANT, EnumType.byMetadata(lllllllllllllllIlIIllIIlIlIIlIII & 0x7));
        if (this.isDouble()) {
            lllllllllllllllIlIIllIIlIlIIlIlI = lllllllllllllllIlIIllIIlIlIIlIlI.withProperty((IProperty<Comparable>)BlockStoneSlabNew.SEAMLESS, (lllllllllllllllIlIIllIIlIlIIlIII & 0x8) != 0x0);
        }
        else {
            lllllllllllllllIlIIllIIlIlIIlIlI = lllllllllllllllIlIIllIIlIlIIlIlI.withProperty(BlockStoneSlabNew.HALF, ((lllllllllllllllIlIIllIIlIlIIlIII & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return lllllllllllllllIlIIllIIlIlIIlIlI;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllllIlIIllIIlIlIllIII, final NonNullList<ItemStack> lllllllllllllllIlIIllIIlIlIlIlll) {
        final Exception lllllllllllllllIlIIllIIlIlIlIIII;
        final String lllllllllllllllIlIIllIIlIlIlIIIl = (String)((EnumType[])(Object)(lllllllllllllllIlIIllIIlIlIlIIII = (Exception)(Object)EnumType.values())).length;
        for (float lllllllllllllllIlIIllIIlIlIlIIlI = 0; lllllllllllllllIlIIllIIlIlIlIIlI < lllllllllllllllIlIIllIIlIlIlIIIl; ++lllllllllllllllIlIIllIIlIlIlIIlI) {
            final EnumType lllllllllllllllIlIIllIIlIlIlIllI = lllllllllllllllIlIIllIIlIlIlIIII[lllllllllllllllIlIIllIIlIlIlIIlI];
            lllllllllllllllIlIIllIIlIlIlIlll.add(new ItemStack(this, 1, lllllllllllllllIlIIllIIlIlIlIllI.getMetadata()));
        }
    }
    
    static {
        SEAMLESS = PropertyBool.create("seamless");
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public Comparable<?> getTypeForItem(final ItemStack lllllllllllllllIlIIllIIlIllIIIII) {
        return EnumType.byMetadata(lllllllllllllllIlIIllIIlIllIIIII.getMetadata() & 0x7);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneSlabNew.SEAMLESS, BlockStoneSlabNew.VARIANT }) : new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneSlabNew.HALF, BlockStoneSlabNew.VARIANT });
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIIllIIlIIllllll) {
        int lllllllllllllllIlIIllIIlIlIIIIIl = 0;
        lllllllllllllllIlIIllIIlIlIIIIIl |= lllllllllllllllIlIIllIIlIIllllll.getValue(BlockStoneSlabNew.VARIANT).getMetadata();
        if (this.isDouble()) {
            if (lllllllllllllllIlIIllIIlIIllllll.getValue((IProperty<Boolean>)BlockStoneSlabNew.SEAMLESS)) {
                lllllllllllllllIlIIllIIlIlIIIIIl |= 0x8;
            }
        }
        else if (lllllllllllllllIlIIllIIlIIllllll.getValue(BlockStoneSlabNew.HALF) == EnumBlockHalf.TOP) {
            lllllllllllllllIlIIllIIlIlIIIIIl |= 0x8;
        }
        return lllllllllllllllIlIIllIIlIlIIIIIl;
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".red_sandstone.name")));
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIlIIllIIlIIllIIlI) {
        return lllllllllllllllIlIIllIIlIIllIIlI.getValue(BlockStoneSlabNew.VARIANT).getMetadata();
    }
    
    public BlockStoneSlabNew() {
        super(Material.ROCK);
        IBlockState lllllllllllllllIlIIllIIlIllllIlI = this.blockState.getBaseState();
        if (this.isDouble()) {
            lllllllllllllllIlIIllIIlIllllIlI = lllllllllllllllIlIIllIIlIllllIlI.withProperty((IProperty<Comparable>)BlockStoneSlabNew.SEAMLESS, false);
        }
        else {
            lllllllllllllllIlIIllIIlIllllIlI = lllllllllllllllIlIIllIIlIllllIlI.withProperty(BlockStoneSlabNew.HALF, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(lllllllllllllllIlIIllIIlIllllIlI.withProperty(BlockStoneSlabNew.VARIANT, EnumType.RED_SANDSTONE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ String name;
        private final /* synthetic */ int meta;
        
        RED_SANDSTONE("RED_SANDSTONE", 0, 0, "red_sandstone", BlockSand.EnumType.RED_SAND.getMapColor());
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ MapColor mapColor;
        
        public int getMetadata() {
            return this.meta;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        private EnumType(final String lllllllllllllIlIllllIlllllIlIIII, final int lllllllllllllIlIllllIlllllIIllll, final int lllllllllllllIlIllllIlllllIlIlII, final String lllllllllllllIlIllllIlllllIIllIl, final MapColor lllllllllllllIlIllllIlllllIIllII) {
            this.meta = lllllllllllllIlIllllIlllllIlIlII;
            this.name = lllllllllllllIlIllllIlllllIIllIl;
            this.mapColor = lllllllllllllIlIllllIlllllIIllII;
        }
        
        public String getUnlocalizedName() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final int lllllllllllllIlIllllIlllllIlllII;
            final long lllllllllllllIlIllllIlllllIlllIl = ((EnumType[])(Object)(lllllllllllllIlIllllIlllllIlllII = (int)(Object)values())).length;
            for (byte lllllllllllllIlIllllIlllllIllllI = 0; lllllllllllllIlIllllIlllllIllllI < lllllllllllllIlIllllIlllllIlllIl; ++lllllllllllllIlIllllIlllllIllllI) {
                final EnumType lllllllllllllIlIllllIllllllIIIII = lllllllllllllIlIllllIlllllIlllII[lllllllllllllIlIllllIlllllIllllI];
                EnumType.META_LOOKUP[lllllllllllllIlIllllIllllllIIIII.getMetadata()] = lllllllllllllIlIllllIllllllIIIII;
            }
        }
        
        public static EnumType byMetadata(int lllllllllllllIlIllllIlllllIIIIII) {
            if (lllllllllllllIlIllllIlllllIIIIII < 0 || lllllllllllllIlIllllIlllllIIIIII >= EnumType.META_LOOKUP.length) {
                lllllllllllllIlIllllIlllllIIIIII = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIlIllllIlllllIIIIII];
        }
    }
}
