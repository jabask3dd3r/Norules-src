package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockPlanks extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIIlIlIIlllIIlIIIl) {
        return lllllllllllllllIIlIlIIlllIIlIIIl.getValue(BlockPlanks.VARIANT).getMetadata();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllllIIlIlIIlllIIIlIIl, final NonNullList<ItemStack> lllllllllllllllIIlIlIIlllIIIIlIl) {
        final float lllllllllllllllIIlIlIIlllIIIIIIl;
        final double lllllllllllllllIIlIlIIlllIIIIIlI = ((EnumType[])(Object)(lllllllllllllllIIlIlIIlllIIIIIIl = (float)(Object)EnumType.values())).length;
        for (Exception lllllllllllllllIIlIlIIlllIIIIIll = (Exception)0; lllllllllllllllIIlIlIIlllIIIIIll < lllllllllllllllIIlIlIIlllIIIIIlI; ++lllllllllllllllIIlIlIIlllIIIIIll) {
            final EnumType lllllllllllllllIIlIlIIlllIIIIlll = lllllllllllllllIIlIlIIlllIIIIIIl[lllllllllllllllIIlIlIIlllIIIIIll];
            lllllllllllllllIIlIlIIlllIIIIlIl.add(new ItemStack(this, 1, lllllllllllllllIIlIlIIlllIIIIlll.getMetadata()));
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIlIlIIllIlllIIIl) {
        return lllllllllllllllIIlIlIIllIlllIIIl.getValue(BlockPlanks.VARIANT).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPlanks.VARIANT });
    }
    
    public BlockPlanks() {
        super(Material.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPlanks.VARIANT, EnumType.OAK));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIlIlIIllIlllllIl) {
        return this.getDefaultState().withProperty(BlockPlanks.VARIANT, EnumType.byMetadata(lllllllllllllllIIlIlIIllIlllllIl));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIIlIlIIllIllllIII, final IBlockAccess lllllllllllllllIIlIlIIllIlllIlll, final BlockPos lllllllllllllllIIlIlIIllIlllIllI) {
        return lllllllllllllllIIlIlIIllIllllIII.getValue(BlockPlanks.VARIANT).getMapColor();
    }
    
    public enum EnumType implements IStringSerializable
    {
        DARK_OAK("DARK_OAK", 5, 5, "dark_oak", "big_oak", MapColor.BROWN);
        
        private final /* synthetic */ int meta;
        private final /* synthetic */ String unlocalizedName;
        
        ACACIA("ACACIA", 4, 4, "acacia", MapColor.ADOBE), 
        JUNGLE("JUNGLE", 3, 3, "jungle", MapColor.DIRT);
        
        private final /* synthetic */ MapColor mapColor;
        
        OAK("OAK", 0, 0, "oak", MapColor.WOOD);
        
        private final /* synthetic */ String name;
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        BIRCH("BIRCH", 2, 2, "birch", MapColor.SAND), 
        SPRUCE("SPRUCE", 1, 1, "spruce", MapColor.OBSIDIAN);
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        private EnumType(final String lllllllllllllIIIlIllIIlIIIIIlIIl, final int lllllllllllllIIIlIllIIlIIIIIlIII, final int lllllllllllllIIIlIllIIlIIIIIlllI, final String lllllllllllllIIIlIllIIlIIIIIIllI, final String lllllllllllllIIIlIllIIlIIIIIIlIl, final MapColor lllllllllllllIIIlIllIIlIIIIIlIll) {
            this.meta = lllllllllllllIIIlIllIIlIIIIIlllI;
            this.name = lllllllllllllIIIlIllIIlIIIIIIllI;
            this.unlocalizedName = lllllllllllllIIIlIllIIlIIIIIIlIl;
            this.mapColor = lllllllllllllIIIlIllIIlIIIIIlIll;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumType(final String lllllllllllllIIIlIllIIlIIIIllIll, final int lllllllllllllIIIlIllIIlIIIIllIlI, final int lllllllllllllIIIlIllIIlIIIIllIIl, final String lllllllllllllIIIlIllIIlIIIIllllI, final MapColor lllllllllllllIIIlIllIIlIIIIlllIl) {
            this(lllllllllllllIIIlIllIIlIIIIllIll, lllllllllllllIIIlIllIIlIIIIllIlI, lllllllllllllIIIlIllIIlIIIIllIIl, lllllllllllllIIIlIllIIlIIIIllllI, lllllllllllllIIIlIllIIlIIIIllllI, lllllllllllllIIIlIllIIlIIIIlllIl);
        }
        
        public static EnumType byMetadata(int lllllllllllllIIIlIllIIIllllllIII) {
            if (lllllllllllllIIIlIllIIIllllllIII < 0 || lllllllllllllIIIlIllIIIllllllIII >= EnumType.META_LOOKUP.length) {
                lllllllllllllIIIlIllIIIllllllIII = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIIIlIllIIIllllllIII];
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final int lllllllllllllIIIlIllIIlIIIlIIlll;
            final int lllllllllllllIIIlIllIIlIIIlIlIII = ((EnumType[])(Object)(lllllllllllllIIIlIllIIlIIIlIIlll = (int)(Object)values())).length;
            for (char lllllllllllllIIIlIllIIlIIIlIlIIl = '\0'; lllllllllllllIIIlIllIIlIIIlIlIIl < lllllllllllllIIIlIllIIlIIIlIlIII; ++lllllllllllllIIIlIllIIlIIIlIlIIl) {
                final EnumType lllllllllllllIIIlIllIIlIIIlIlIll = lllllllllllllIIIlIllIIlIIIlIIlll[lllllllllllllIIIlIllIIlIIIlIlIIl];
                EnumType.META_LOOKUP[lllllllllllllIIIlIllIIlIIIlIlIll.getMetadata()] = lllllllllllllIIIlIllIIlIIIlIlIll;
            }
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
