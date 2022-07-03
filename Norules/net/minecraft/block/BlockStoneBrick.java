package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockStoneBrick extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneBrick.VARIANT });
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIIIIIllIllIlIll) {
        return lllllllllllllllIIIIIIIllIllIlIll.getValue(BlockStoneBrick.VARIANT).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIIIIIIllIllIllll) {
        return this.getDefaultState().withProperty(BlockStoneBrick.VARIANT, EnumType.byMetadata(lllllllllllllllIIIIIIIllIllIllll));
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
        DEFAULT_META = EnumType.DEFAULT.getMetadata();
        MOSSY_META = EnumType.MOSSY.getMetadata();
        CRACKED_META = EnumType.CRACKED.getMetadata();
        CHISELED_META = EnumType.CHISELED.getMetadata();
    }
    
    public BlockStoneBrick() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStoneBrick.VARIANT, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllllIIIIIIIllIlllllIl, final NonNullList<ItemStack> lllllllllllllllIIIIIIIllIllllIIl) {
        final double lllllllllllllllIIIIIIIllIlllIlIl;
        final double lllllllllllllllIIIIIIIllIlllIllI = ((EnumType[])(Object)(lllllllllllllllIIIIIIIllIlllIlIl = (double)(Object)EnumType.values())).length;
        for (char lllllllllllllllIIIIIIIllIlllIlll = '\0'; lllllllllllllllIIIIIIIllIlllIlll < lllllllllllllllIIIIIIIllIlllIllI; ++lllllllllllllllIIIIIIIllIlllIlll) {
            final EnumType lllllllllllllllIIIIIIIllIllllIll = lllllllllllllllIIIIIIIllIlllIlIl[lllllllllllllllIIIIIIIllIlllIlll];
            lllllllllllllllIIIIIIIllIllllIIl.add(new ItemStack(this, 1, lllllllllllllllIIIIIIIllIllllIll.getMetadata()));
        }
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIIIIIIIlllIIIIllI) {
        return lllllllllllllllIIIIIIIlllIIIIllI.getValue(BlockStoneBrick.VARIANT).getMetadata();
    }
    
    public enum EnumType implements IStringSerializable
    {
        MOSSY("MOSSY", 1, 1, "mossy_stonebrick", "mossy");
        
        private final /* synthetic */ String unlocalizedName;
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        CRACKED("CRACKED", 2, 2, "cracked_stonebrick", "cracked");
        
        private final /* synthetic */ int meta;
        
        CHISELED("CHISELED", 3, 3, "chiseled_stonebrick", "chiseled"), 
        DEFAULT("DEFAULT", 0, 0, "stonebrick", "default");
        
        private final /* synthetic */ String name;
        
        private EnumType(final String llllllllllllllIIIIlIIlIllllIlIIl, final int llllllllllllllIIIIlIIlIllllIlIII, final int llllllllllllllIIIIlIIlIllllIIlll, final String llllllllllllllIIIIlIIlIllllIllII, final String llllllllllllllIIIIlIIlIllllIIlIl) {
            this.meta = llllllllllllllIIIIlIIlIllllIIlll;
            this.name = llllllllllllllIIIIlIIlIllllIllII;
            this.unlocalizedName = llllllllllllllIIIIlIIlIllllIIlIl;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        public static EnumType byMetadata(int llllllllllllllIIIIlIIlIlllIlllII) {
            if (llllllllllllllIIIIlIIlIlllIlllII < 0 || llllllllllllllIIIIlIIlIlllIlllII >= EnumType.META_LOOKUP.length) {
                llllllllllllllIIIIlIIlIlllIlllII = 0;
            }
            return EnumType.META_LOOKUP[llllllllllllllIIIIlIIlIlllIlllII];
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final byte llllllllllllllIIIIlIIlIlllllIlIl;
            final String llllllllllllllIIIIlIIlIlllllIllI = (String)((EnumType[])(Object)(llllllllllllllIIIIlIIlIlllllIlIl = (byte)(Object)values())).length;
            for (boolean llllllllllllllIIIIlIIlIlllllIlll = false; llllllllllllllIIIIlIIlIlllllIlll < llllllllllllllIIIIlIIlIlllllIllI; ++llllllllllllllIIIIlIIlIlllllIlll) {
                final EnumType llllllllllllllIIIIlIIlIllllllIIl = llllllllllllllIIIIlIIlIlllllIlIl[llllllllllllllIIIIlIIlIlllllIlll];
                EnumType.META_LOOKUP[llllllllllllllIIIIlIIlIllllllIIl.getMetadata()] = llllllllllllllIIIIlIIlIllllllIIl;
            }
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
    }
}
