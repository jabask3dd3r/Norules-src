package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockSand extends BlockFalling
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    @Override
    public int getDustColor(final IBlockState lllllllllllllIIlIIIIllllIlIIIllI) {
        final EnumType lllllllllllllIIlIIIIllllIlIIIlll = lllllllllllllIIlIIIIllllIlIIIllI.getValue(BlockSand.VARIANT);
        return lllllllllllllIIlIIIIllllIlIIIlll.getDustColor();
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSand.VARIANT });
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIIlIIIIllllIllIIlll, final NonNullList<ItemStack> lllllllllllllIIlIIIIllllIllIIIll) {
        final double lllllllllllllIIlIIIIllllIlIlllll;
        final short lllllllllllllIIlIIIIllllIllIIIII = (short)((EnumType[])(Object)(lllllllllllllIIlIIIIllllIlIlllll = (double)(Object)EnumType.values())).length;
        for (String lllllllllllllIIlIIIIllllIllIIIIl = (String)0; lllllllllllllIIlIIIIllllIllIIIIl < lllllllllllllIIlIIIIllllIllIIIII; ++lllllllllllllIIlIIIIllllIllIIIIl) {
            final EnumType lllllllllllllIIlIIIIllllIllIIlIl = lllllllllllllIIlIIIIllllIlIlllll[lllllllllllllIIlIIIIllllIllIIIIl];
            lllllllllllllIIlIIIIllllIllIIIll.add(new ItemStack(this, 1, lllllllllllllIIlIIIIllllIllIIlIl.getMetadata()));
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIlIIIIllllIlIlIIII) {
        return lllllllllllllIIlIIIIllllIlIlIIII.getValue(BlockSand.VARIANT).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIlIIIIllllIlIlIlIl) {
        return this.getDefaultState().withProperty(BlockSand.VARIANT, EnumType.byMetadata(lllllllllllllIIlIIIIllllIlIlIlIl));
    }
    
    public BlockSand() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSand.VARIANT, EnumType.SAND));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIIlIIIIllllIlIlllII, final IBlockAccess lllllllllllllIIlIIIIllllIlIllIll, final BlockPos lllllllllllllIIlIIIIllllIlIllIlI) {
        return lllllllllllllIIlIIIIllllIlIlllII.getValue(BlockSand.VARIANT).getMapColor();
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIIlIIIIllllIllIllll) {
        return lllllllllllllIIlIIIIllllIllIllll.getValue(BlockSand.VARIANT).getMetadata();
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ MapColor mapColor;
        
        RED_SAND("RED_SAND", 1, 1, "red_sand", "red", MapColor.ADOBE, -5679071), 
        SAND("SAND", 0, 0, "sand", "default", MapColor.SAND, -2370656);
        
        private final /* synthetic */ String name;
        private final /* synthetic */ int dustColor;
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ int meta;
        
        public static EnumType byMetadata(int lllllllllllllIlIlIIIlIIllIIlIIII) {
            if (lllllllllllllIlIlIIIlIIllIIlIIII < 0 || lllllllllllllIlIlIIIlIIllIIlIIII >= EnumType.META_LOOKUP.length) {
                lllllllllllllIlIlIIIlIIllIIlIIII = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIlIlIIIlIIllIIlIIII];
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        public int getDustColor() {
            return this.dustColor;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final boolean lllllllllllllIlIlIIIlIIlllIIllII;
            final boolean lllllllllllllIlIlIIIlIIlllIIllIl = ((EnumType[])(Object)(lllllllllllllIlIlIIIlIIlllIIllII = (boolean)(Object)values())).length != 0;
            for (float lllllllllllllIlIlIIIlIIlllIIllll = 0; lllllllllllllIlIlIIIlIIlllIIllll < (lllllllllllllIlIlIIIlIIlllIIllIl ? 1 : 0); ++lllllllllllllIlIlIIIlIIlllIIllll) {
                final EnumType lllllllllllllIlIlIIIlIIlllIlIIIl = lllllllllllllIlIlIIIlIIlllIIllII[lllllllllllllIlIlIIIlIIlllIIllll];
                EnumType.META_LOOKUP[lllllllllllllIlIlIIIlIIlllIlIIIl.getMetadata()] = lllllllllllllIlIlIIIlIIlllIlIIIl;
            }
        }
        
        private EnumType(final String lllllllllllllIlIlIIIlIIllIlIllII, final int lllllllllllllIlIlIIIlIIllIlIlIll, final int lllllllllllllIlIlIIIlIIllIlIlIlI, final String lllllllllllllIlIlIIIlIIllIllIllI, final String lllllllllllllIlIlIIIlIIllIlIIllI, final MapColor lllllllllllllIlIlIIIlIIllIllIIlI, final int lllllllllllllIlIlIIIlIIllIlIIIlI) {
            this.meta = lllllllllllllIlIlIIIlIIllIlIlIlI;
            this.name = lllllllllllllIlIlIIIlIIllIllIllI;
            this.mapColor = lllllllllllllIlIlIIIlIIllIllIIlI;
            this.unlocalizedName = lllllllllllllIlIlIIIlIIllIlIIllI;
            this.dustColor = lllllllllllllIlIlIIIlIIllIlIIIlI;
        }
    }
}
