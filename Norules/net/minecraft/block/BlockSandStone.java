package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockSandStone extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> TYPE;
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIllIlllIIlllIlIlI) {
        return lllllllllllllllIllIlllIIlllIlIlI.getValue(BlockSandStone.TYPE).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIllIlllIIllIlIIlI) {
        return this.getDefaultState().withProperty(BlockSandStone.TYPE, EnumType.byMetadata(lllllllllllllllIllIlllIIllIlIIlI));
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllllIllIlllIIlllIIIlI, final NonNullList<ItemStack> lllllllllllllllIllIlllIIlllIIIIl) {
        final char lllllllllllllllIllIlllIIllIllIlI;
        final String lllllllllllllllIllIlllIIllIllIll = (String)((EnumType[])(Object)(lllllllllllllllIllIlllIIllIllIlI = (char)(Object)EnumType.values())).length;
        for (float lllllllllllllllIllIlllIIllIlllII = 0; lllllllllllllllIllIlllIIllIlllII < lllllllllllllllIllIlllIIllIllIll; ++lllllllllllllllIllIlllIIllIlllII) {
            final EnumType lllllllllllllllIllIlllIIlllIIIII = lllllllllllllllIllIlllIIllIllIlI[lllllllllllllllIllIlllIIllIlllII];
            lllllllllllllllIllIlllIIlllIIIIl.add(new ItemStack(this, 1, lllllllllllllllIllIlllIIlllIIIII.getMetadata()));
        }
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIllIlllIIllIllIII, final IBlockAccess lllllllllllllllIllIlllIIllIlIlll, final BlockPos lllllllllllllllIllIlllIIllIlIllI) {
        return MapColor.SAND;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSandStone.TYPE });
    }
    
    static {
        TYPE = PropertyEnum.create("type", EnumType.class);
    }
    
    public BlockSandStone() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSandStone.TYPE, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIllIlllIIllIIllII) {
        return lllllllllllllllIllIlllIIllIIllII.getValue(BlockSandStone.TYPE).getMetadata();
    }
    
    public enum EnumType implements IStringSerializable
    {
        CHISELED("CHISELED", 1, 1, "chiseled_sandstone", "chiseled");
        
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ int metadata;
        
        SMOOTH("SMOOTH", 2, 2, "smooth_sandstone", "smooth"), 
        DEFAULT("DEFAULT", 0, 0, "sandstone", "default");
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ String name;
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public static EnumType byMetadata(int lllllllllllllllIllIIIIIlIllIIIII) {
            if (lllllllllllllllIllIIIIIlIllIIIII < 0 || lllllllllllllllIllIIIIIlIllIIIII >= EnumType.META_LOOKUP.length) {
                lllllllllllllllIllIIIIIlIllIIIII = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllllIllIIIIIlIllIIIII];
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumType(final String lllllllllllllllIllIIIIIlIllIllIl, final int lllllllllllllllIllIIIIIlIllIllII, final int lllllllllllllllIllIIIIIlIllIlIll, final String lllllllllllllllIllIIIIIlIlllIIII, final String lllllllllllllllIllIIIIIlIllIlIIl) {
            this.metadata = lllllllllllllllIllIIIIIlIllIlIll;
            this.name = lllllllllllllllIllIIIIIlIlllIIII;
            this.unlocalizedName = lllllllllllllllIllIIIIIlIllIlIIl;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final float lllllllllllllllIllIIIIIlIllllIIl;
            final Exception lllllllllllllllIllIIIIIlIllllIlI = (Exception)((EnumType[])(Object)(lllllllllllllllIllIIIIIlIllllIIl = (float)(Object)values())).length;
            for (byte lllllllllllllllIllIIIIIlIllllIll = 0; lllllllllllllllIllIIIIIlIllllIll < lllllllllllllllIllIIIIIlIllllIlI; ++lllllllllllllllIllIIIIIlIllllIll) {
                final EnumType lllllllllllllllIllIIIIIlIlllllIl = lllllllllllllllIllIIIIIlIllllIIl[lllllllllllllllIllIIIIIlIllllIll];
                EnumType.META_LOOKUP[lllllllllllllllIllIIIIIlIlllllIl.getMetadata()] = lllllllllllllllIllIIIIIlIlllllIl;
            }
        }
        
        public int getMetadata() {
            return this.metadata;
        }
    }
}
