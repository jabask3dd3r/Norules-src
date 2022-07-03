package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockStone extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    public BlockStone() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStone.VARIANT, EnumType.STONE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllllIlIIIlIIIlIIIlIlIl, final NonNullList<ItemStack> llllllllllllllIlIIIlIIIlIIIlIlII) {
        final long llllllllllllllIlIIIlIIIlIIIIllIl;
        final long llllllllllllllIlIIIlIIIlIIIIlllI = ((EnumType[])(Object)(llllllllllllllIlIIIlIIIlIIIIllIl = (long)(Object)EnumType.values())).length;
        for (float llllllllllllllIlIIIlIIIlIIIIllll = 0; llllllllllllllIlIIIlIIIlIIIIllll < llllllllllllllIlIIIlIIIlIIIIlllI; ++llllllllllllllIlIIIlIIIlIIIIllll) {
            final EnumType llllllllllllllIlIIIlIIIlIIIlIIll = llllllllllllllIlIIIlIIIlIIIIllIl[llllllllllllllIlIIIlIIIlIIIIllll];
            llllllllllllllIlIIIlIIIlIIIlIlII.add(new ItemStack(this, 1, llllllllllllllIlIIIlIIIlIIIlIIll.getMetadata()));
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIIlIIIlIIIIlIIl) {
        return this.getDefaultState().withProperty(BlockStone.VARIANT, EnumType.byMetadata(llllllllllllllIlIIIlIIIlIIIIlIIl));
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIIIlIIIlIIlIIlII, final Random llllllllllllllIlIIIlIIIlIIlIIIll, final int llllllllllllllIlIIIlIIIlIIlIIIlI) {
        return (llllllllllllllIlIIIlIIIlIIlIIlII.getValue(BlockStone.VARIANT) == EnumType.STONE) ? Item.getItemFromBlock(Blocks.COBBLESTONE) : Item.getItemFromBlock(Blocks.STONE);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlIIIlIIIlIIIllllI) {
        return llllllllllllllIlIIIlIIIlIIIllllI.getValue(BlockStone.VARIANT).getMetadata();
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIIlIIIlIIIIIIll) {
        return llllllllllllllIlIIIlIIIlIIIIIIll.getValue(BlockStone.VARIANT).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStone.VARIANT });
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".").append(EnumType.STONE.getUnlocalizedName()).append(".name")));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIlIIIlIIIlIIlIIlll, final IBlockAccess llllllllllllllIlIIIlIIIlIIlIlIIl, final BlockPos llllllllllllllIlIIIlIIIlIIlIlIII) {
        return llllllllllllllIlIIIlIIIlIIlIIlll.getValue(BlockStone.VARIANT).getMapColor();
    }
    
    public enum EnumType implements IStringSerializable
    {
        ANDESITE_SMOOTH("ANDESITE_SMOOTH", 6, 6, MapColor.STONE, "smooth_andesite", "andesiteSmooth", false), 
        ANDESITE("ANDESITE", 5, 5, MapColor.STONE, "andesite", true);
        
        private final /* synthetic */ int meta;
        private final /* synthetic */ String unlocalizedName;
        
        GRANITE_SMOOTH("GRANITE_SMOOTH", 2, 2, MapColor.DIRT, "smooth_granite", "graniteSmooth", false);
        
        private final /* synthetic */ MapColor mapColor;
        private final /* synthetic */ String name;
        
        DIORITE("DIORITE", 3, 3, MapColor.QUARTZ, "diorite", true), 
        GRANITE("GRANITE", 1, 1, MapColor.DIRT, "granite", true), 
        DIORITE_SMOOTH("DIORITE_SMOOTH", 4, 4, MapColor.QUARTZ, "smooth_diorite", "dioriteSmooth", false);
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ boolean field_190913_m;
        
        STONE("STONE", 0, 0, MapColor.STONE, "stone", true);
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final float lllllllllllllIIlIIIllIlIIlIlIlll;
            final float lllllllllllllIIlIIIllIlIIlIllIIl = ((EnumType[])(Object)(lllllllllllllIIlIIIllIlIIlIlIlll = (float)(Object)values())).length;
            for (boolean lllllllllllllIIlIIIllIlIIlIllIll = false; (lllllllllllllIIlIIIllIlIIlIllIll ? 1 : 0) < lllllllllllllIIlIIIllIlIIlIllIIl; ++lllllllllllllIIlIIIllIlIIlIllIll) {
                final EnumType lllllllllllllIIlIIIllIlIIlIlllll = lllllllllllllIIlIIIllIlIIlIlIlll[lllllllllllllIIlIIIllIlIIlIllIll];
                EnumType.META_LOOKUP[lllllllllllllIIlIIIllIlIIlIlllll.getMetadata()] = lllllllllllllIIlIIIllIlIIlIlllll;
            }
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        private EnumType(final String lllllllllllllIIlIIIllIlIIIIlIIlI, final int lllllllllllllIIlIIIllIlIIIIlIIII, final int lllllllllllllIIlIIIllIlIIIIlllII, final MapColor lllllllllllllIIlIIIllIlIIIIllIlI, final String lllllllllllllIIlIIIllIlIIIIIlIlI, final String lllllllllllllIIlIIIllIlIIIIlIlIl, final boolean lllllllllllllIIlIIIllIlIIIIlIlII) {
            this.meta = lllllllllllllIIlIIIllIlIIIIlllII;
            this.name = lllllllllllllIIlIIIllIlIIIIIlIlI;
            this.unlocalizedName = lllllllllllllIIlIIIllIlIIIIlIlIl;
            this.mapColor = lllllllllllllIIlIIIllIlIIIIllIlI;
            this.field_190913_m = lllllllllllllIIlIIIllIlIIIIlIlII;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        private EnumType(final String lllllllllllllIIlIIIllIlIIlIIIIll, final int lllllllllllllIIlIIIllIlIIlIIIIlI, final int lllllllllllllIIlIIIllIlIIlIIIIIl, final MapColor lllllllllllllIIlIIIllIlIIlIIIlll, final String lllllllllllllIIlIIIllIlIIIllllll, final boolean lllllllllllllIIlIIIllIlIIlIIIlIl) {
            this(lllllllllllllIIlIIIllIlIIlIIIIll, lllllllllllllIIlIIIllIlIIlIIIIlI, lllllllllllllIIlIIIllIlIIlIIIIIl, lllllllllllllIIlIIIllIlIIlIIIlll, lllllllllllllIIlIIIllIlIIIllllll, lllllllllllllIIlIIIllIlIIIllllll, lllllllllllllIIlIIIllIlIIlIIIlIl);
        }
        
        public static EnumType byMetadata(int lllllllllllllIIlIIIllIIlllllIIIl) {
            if (lllllllllllllIIlIIIllIIlllllIIIl < 0 || lllllllllllllIIlIIIllIIlllllIIIl >= EnumType.META_LOOKUP.length) {
                lllllllllllllIIlIIIllIIlllllIIIl = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIIlIIIllIIlllllIIIl];
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        public boolean func_190912_e() {
            return this.field_190913_m;
        }
    }
}
