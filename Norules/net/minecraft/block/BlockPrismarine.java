package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockPrismarine extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    public static final /* synthetic */ int BRICKS_META;
    public static final /* synthetic */ int ROUGH_META;
    public static final /* synthetic */ int DARK_META;
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIllIllllIlIlllIllII, final IBlockAccess lllllllllllllIllIllllIlIlllIllll, final BlockPos lllllllllllllIllIllllIlIlllIlllI) {
        return (lllllllllllllIllIllllIlIlllIllII.getValue(BlockPrismarine.VARIANT) == EnumType.ROUGH) ? MapColor.CYAN : MapColor.DIAMOND;
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
        ROUGH_META = EnumType.ROUGH.getMetadata();
        BRICKS_META = EnumType.BRICKS.getMetadata();
        DARK_META = EnumType.DARK.getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllIllllIlIllIIlIIl) {
        return this.getDefaultState().withProperty(BlockPrismarine.VARIANT, EnumType.byMetadata(lllllllllllllIllIllllIlIllIIlIIl));
    }
    
    public BlockPrismarine() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPrismarine.VARIANT, EnumType.ROUGH));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".").append(EnumType.ROUGH.getUnlocalizedName()).append(".name")));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllIllllIlIllIlIIII) {
        return lllllllllllllIllIllllIlIllIlIIII.getValue(BlockPrismarine.VARIANT).getMetadata();
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIllIllllIlIllIlIlIl) {
        return lllllllllllllIllIllllIlIllIlIlIl.getValue(BlockPrismarine.VARIANT).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPrismarine.VARIANT });
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIllIllllIlIllIIIIll, final NonNullList<ItemStack> lllllllllllllIllIllllIlIllIIIIII) {
        lllllllllllllIllIllllIlIllIIIIII.add(new ItemStack(this, 1, BlockPrismarine.ROUGH_META));
        lllllllllllllIllIllllIlIllIIIIII.add(new ItemStack(this, 1, BlockPrismarine.BRICKS_META));
        lllllllllllllIllIllllIlIllIIIIII.add(new ItemStack(this, 1, BlockPrismarine.DARK_META));
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ String unlocalizedName;
        
        DARK("DARK", 2, 2, "dark_prismarine", "dark");
        
        private final /* synthetic */ String name;
        private final /* synthetic */ int meta;
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        ROUGH("ROUGH", 0, 0, "prismarine", "rough"), 
        BRICKS("BRICKS", 1, 1, "prismarine_bricks", "bricks");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public static EnumType byMetadata(int llllllllllllllIIIIllllIIllIlIllI) {
            if (llllllllllllllIIIIllllIIllIlIllI < 0 || llllllllllllllIIIIllllIIllIlIllI >= EnumType.META_LOOKUP.length) {
                llllllllllllllIIIIllllIIllIlIllI = 0;
            }
            return EnumType.META_LOOKUP[llllllllllllllIIIIllllIIllIlIllI];
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        private EnumType(final String llllllllllllllIIIIllllIIlllIIIlI, final int llllllllllllllIIIIllllIIlllIIIIl, final int llllllllllllllIIIIllllIIlllIIllI, final String llllllllllllllIIIIllllIIlllIIlIl, final String llllllllllllllIIIIllllIIllIllllI) {
            this.meta = llllllllllllllIIIIllllIIlllIIllI;
            this.name = llllllllllllllIIIIllllIIlllIIlIl;
            this.unlocalizedName = llllllllllllllIIIIllllIIllIllllI;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final char llllllllllllllIIIIllllIIlllIlllI;
            final double llllllllllllllIIIIllllIIlllIllll = ((EnumType[])(Object)(llllllllllllllIIIIllllIIlllIlllI = (char)(Object)values())).length;
            for (Exception llllllllllllllIIIIllllIIllllIIII = (Exception)0; llllllllllllllIIIIllllIIllllIIII < llllllllllllllIIIIllllIIlllIllll; ++llllllllllllllIIIIllllIIllllIIII) {
                final EnumType llllllllllllllIIIIllllIIllllIIlI = llllllllllllllIIIIllllIIlllIlllI[llllllllllllllIIIIllllIIllllIIII];
                EnumType.META_LOOKUP[llllllllllllllIIIIllllIIllllIIlI.getMetadata()] = llllllllllllllIIIIllllIIllllIIlI;
            }
        }
    }
}
