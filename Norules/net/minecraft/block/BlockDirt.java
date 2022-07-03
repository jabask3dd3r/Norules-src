package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class BlockDirt extends Block
{
    public static final /* synthetic */ PropertyBool SNOWY;
    public static final /* synthetic */ PropertyEnum<DirtType> VARIANT;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIllIllIllIlllIIII) {
        return lllllllllllllIIIllIllIllIlllIIII.getValue(BlockDirt.VARIANT).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIllIllIllIlllIlII) {
        return this.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.byMetadata(lllllllllllllIIIllIllIllIlllIlII));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDirt.VARIANT, BlockDirt.SNOWY });
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIIIllIllIlllIIlIllI, final IBlockAccess lllllllllllllIIIllIllIlllIIllIII, final BlockPos lllllllllllllIIIllIllIlllIIlIlll) {
        return lllllllllllllIIIllIllIlllIIlIllI.getValue(BlockDirt.VARIANT).getColor();
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIIIllIllIllIllllllI, final BlockPos lllllllllllllIIIllIllIllIlllllIl, final IBlockState lllllllllllllIIIllIllIllIllllIlI) {
        return new ItemStack(this, 1, lllllllllllllIIIllIllIllIllllIlI.getValue(BlockDirt.VARIANT).getMetadata());
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllIIIllIllIlllIIIllII, final IBlockAccess lllllllllllllIIIllIllIlllIIIlIll, final BlockPos lllllllllllllIIIllIllIlllIIIlIlI) {
        if (((IBlockState)lllllllllllllIIIllIllIlllIIIllII).getValue(BlockDirt.VARIANT) == DirtType.PODZOL) {
            final Block lllllllllllllIIIllIllIlllIIIllIl = lllllllllllllIIIllIllIlllIIIlIll.getBlockState(lllllllllllllIIIllIllIlllIIIlIlI.up()).getBlock();
            lllllllllllllIIIllIllIlllIIIllII = ((IBlockState)lllllllllllllIIIllIllIlllIIIllII).withProperty((IProperty<Comparable>)BlockDirt.SNOWY, Boolean.valueOf(lllllllllllllIIIllIllIlllIIIllIl == Blocks.SNOW || lllllllllllllIIIllIllIlllIIIllIl == Blocks.SNOW_LAYER));
        }
        return (IBlockState)lllllllllllllIIIllIllIlllIIIllII;
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIIIllIllIllIllIlIIl) {
        DirtType lllllllllllllIIIllIllIllIllIlIII = lllllllllllllIIIllIllIllIllIlIIl.getValue(BlockDirt.VARIANT);
        if (lllllllllllllIIIllIllIllIllIlIII == DirtType.PODZOL) {
            lllllllllllllIIIllIllIllIllIlIII = DirtType.DIRT;
        }
        return lllllllllllllIIIllIllIllIllIlIII.getMetadata();
    }
    
    protected BlockDirt() {
        super(Material.GROUND);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockDirt.VARIANT, DirtType.DIRT).withProperty((IProperty<Comparable>)BlockDirt.SNOWY, false));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIIIllIllIlllIIIIlIl, final NonNullList<ItemStack> lllllllllllllIIIllIllIlllIIIIlII) {
        lllllllllllllIIIllIllIlllIIIIlII.add(new ItemStack(this, 1, DirtType.DIRT.getMetadata()));
        lllllllllllllIIIllIllIlllIIIIlII.add(new ItemStack(this, 1, DirtType.COARSE_DIRT.getMetadata()));
        lllllllllllllIIIllIllIlllIIIIlII.add(new ItemStack(this, 1, DirtType.PODZOL.getMetadata()));
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", DirtType.class);
        SNOWY = PropertyBool.create("snowy");
    }
    
    public enum DirtType implements IStringSerializable
    {
        private static final /* synthetic */ DirtType[] METADATA_LOOKUP;
        
        COARSE_DIRT("COARSE_DIRT", 1, 1, "coarse_dirt", "coarse", MapColor.DIRT), 
        DIRT("DIRT", 0, 0, "dirt", "default", MapColor.DIRT);
        
        private final /* synthetic */ String name;
        
        PODZOL("PODZOL", 2, 2, "podzol", MapColor.OBSIDIAN);
        
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ MapColor color;
        private final /* synthetic */ int metadata;
        
        static {
            METADATA_LOOKUP = new DirtType[values().length];
            final double lllllllllllllIIIlIllllllIIIIIlll;
            final long lllllllllllllIIIlIllllllIIIIlIII = ((DirtType[])(Object)(lllllllllllllIIIlIllllllIIIIIlll = (double)(Object)values())).length;
            for (Exception lllllllllllllIIIlIllllllIIIIlIIl = (Exception)0; lllllllllllllIIIlIllllllIIIIlIIl < lllllllllllllIIIlIllllllIIIIlIII; ++lllllllllllllIIIlIllllllIIIIlIIl) {
                final DirtType lllllllllllllIIIlIllllllIIIIlIll = lllllllllllllIIIlIllllllIIIIIlll[lllllllllllllIIIlIllllllIIIIlIIl];
                DirtType.METADATA_LOOKUP[lllllllllllllIIIlIllllllIIIIlIll.getMetadata()] = lllllllllllllIIIlIllllllIIIIlIll;
            }
        }
        
        public MapColor getColor() {
            return this.color;
        }
        
        public int getMetadata() {
            return this.metadata;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public static DirtType byMetadata(int lllllllllllllIIIlIlllllIllIlIlIl) {
            if (lllllllllllllIIIlIlllllIllIlIlIl < 0 || lllllllllllllIIIlIlllllIllIlIlIl >= DirtType.METADATA_LOOKUP.length) {
                lllllllllllllIIIlIlllllIllIlIlIl = 0;
            }
            return DirtType.METADATA_LOOKUP[lllllllllllllIIIlIlllllIllIlIlIl];
        }
        
        private DirtType(final String lllllllllllllIIIlIlllllIlllllIll, final int lllllllllllllIIIlIlllllIlllllIlI, final int lllllllllllllIIIlIlllllIlllllIIl, final String lllllllllllllIIIlIlllllIlllllllI, final MapColor lllllllllllllIIIlIlllllIllllIlll) {
            this(lllllllllllllIIIlIlllllIlllllIll, lllllllllllllIIIlIlllllIlllllIlI, lllllllllllllIIIlIlllllIlllllIIl, lllllllllllllIIIlIlllllIlllllllI, lllllllllllllIIIlIlllllIlllllllI, lllllllllllllIIIlIlllllIllllIlll);
        }
        
        private DirtType(final String lllllllllllllIIIlIlllllIlllIlIIl, final int lllllllllllllIIIlIlllllIlllIlIII, final int lllllllllllllIIIlIlllllIlllIIlll, final String lllllllllllllIIIlIlllllIlllIIllI, final String lllllllllllllIIIlIlllllIlllIIlIl, final MapColor lllllllllllllIIIlIlllllIlllIIlII) {
            this.metadata = lllllllllllllIIIlIlllllIlllIIlll;
            this.name = lllllllllllllIIIlIlllllIlllIIllI;
            this.unlocalizedName = lllllllllllllIIIlIlllllIlllIIlIl;
            this.color = lllllllllllllIIIlIlllllIlllIIlII;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
