package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockRedSandstone extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> TYPE;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIIlIIIIlIllIIlIIl) {
        return this.getDefaultState().withProperty(BlockRedSandstone.TYPE, EnumType.byMetadata(lllllllllllllIlIIlIIIIlIllIIlIIl));
    }
    
    public BlockRedSandstone() {
        super(Material.ROCK, BlockSand.EnumType.RED_SAND.getMapColor());
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRedSandstone.TYPE, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    static {
        TYPE = PropertyEnum.create("type", EnumType.class);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRedSandstone.TYPE });
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIlIIlIIIIlIllIlllIl) {
        return lllllllllllllIlIIlIIIIlIllIlllIl.getValue(BlockRedSandstone.TYPE).getMetadata();
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIIlIIIIlIllIIIIll) {
        return lllllllllllllIlIIlIIIIlIllIIIIll.getValue(BlockRedSandstone.TYPE).getMetadata();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIlIIlIIIIlIllIlIlIl, final NonNullList<ItemStack> lllllllllllllIlIIlIIIIlIllIlIIIl) {
        final char lllllllllllllIlIIlIIIIlIllIIllIl;
        final Exception lllllllllllllIlIIlIIIIlIllIIlllI = (Exception)((EnumType[])(Object)(lllllllllllllIlIIlIIIIlIllIIllIl = (char)(Object)EnumType.values())).length;
        for (short lllllllllllllIlIIlIIIIlIllIIllll = 0; lllllllllllllIlIIlIIIIlIllIIllll < lllllllllllllIlIIlIIIIlIllIIlllI; ++lllllllllllllIlIIlIIIIlIllIIllll) {
            final EnumType lllllllllllllIlIIlIIIIlIllIlIIll = lllllllllllllIlIIlIIIIlIllIIllIl[lllllllllllllIlIIlIIIIlIllIIllll];
            lllllllllllllIlIIlIIIIlIllIlIIIl.add(new ItemStack(this, 1, lllllllllllllIlIIlIIIIlIllIlIIll.getMetadata()));
        }
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ int meta;
        
        DEFAULT("DEFAULT", 0, 0, "red_sandstone", "default");
        
        private final /* synthetic */ String name;
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        SMOOTH("SMOOTH", 2, 2, "smooth_red_sandstone", "smooth"), 
        CHISELED("CHISELED", 1, 1, "chiseled_red_sandstone", "chiseled");
        
        private final /* synthetic */ String unlocalizedName;
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final char llllllllllllllIIIIlIllllIlIlllll;
            final long llllllllllllllIIIIlIllllIllIIIII = ((EnumType[])(Object)(llllllllllllllIIIIlIllllIlIlllll = (char)(Object)values())).length;
            for (Exception llllllllllllllIIIIlIllllIllIIIIl = (Exception)0; llllllllllllllIIIIlIllllIllIIIIl < llllllllllllllIIIIlIllllIllIIIII; ++llllllllllllllIIIIlIllllIllIIIIl) {
                final EnumType llllllllllllllIIIIlIllllIllIIIll = llllllllllllllIIIIlIllllIlIlllll[llllllllllllllIIIIlIllllIllIIIIl];
                EnumType.META_LOOKUP[llllllllllllllIIIIlIllllIllIIIll.getMetadata()] = llllllllllllllIIIIlIllllIllIIIll;
            }
        }
        
        public static EnumType byMetadata(int llllllllllllllIIIIlIllllIlIIIllI) {
            if (llllllllllllllIIIIlIllllIlIIIllI < 0 || llllllllllllllIIIIlIllllIlIIIllI >= EnumType.META_LOOKUP.length) {
                llllllllllllllIIIIlIllllIlIIIllI = 0;
            }
            return EnumType.META_LOOKUP[llllllllllllllIIIIlIllllIlIIIllI];
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        private EnumType(final String llllllllllllllIIIIlIllllIlIlIIll, final int llllllllllllllIIIIlIllllIlIlIIlI, final int llllllllllllllIIIIlIllllIlIlIlll, final String llllllllllllllIIIIlIllllIlIlIIII, final String llllllllllllllIIIIlIllllIlIlIlIl) {
            this.meta = llllllllllllllIIIIlIllllIlIlIlll;
            this.name = llllllllllllllIIIIlIllllIlIlIIII;
            this.unlocalizedName = llllllllllllllIIIIlIllllIlIlIlIl;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
    }
}
