package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public abstract class BlockStoneSlab extends BlockSlab
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    public static final /* synthetic */ PropertyBool SEAMLESS;
    
    @Override
    public IProperty<?> getVariantProperty() {
        return BlockStoneSlab.VARIANT;
    }
    
    static {
        SEAMLESS = PropertyBool.create("seamless");
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlIIlIIIlIllllIlIll, final BlockPos lllllllllllllIlIIlIIIlIllllIlIlI, final IBlockState lllllllllllllIlIIlIIIlIllllIlIIl) {
        return new ItemStack(Blocks.STONE_SLAB, 1, lllllllllllllIlIIlIIIlIllllIlIIl.getValue(BlockStoneSlab.VARIANT).getMetadata());
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneSlab.SEAMLESS, BlockStoneSlab.VARIANT }) : new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStoneSlab.HALF, BlockStoneSlab.VARIANT });
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIlIIlIIIlIllIlIlIII, final IBlockAccess lllllllllllllIlIIlIIIlIllIlIlIlI, final BlockPos lllllllllllllIlIIlIIIlIllIlIlIIl) {
        return lllllllllllllIlIIlIIIlIllIlIlIII.getValue(BlockStoneSlab.VARIANT).getMapColor();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIlIIlIIIlIlllIlIlIl, final NonNullList<ItemStack> lllllllllllllIlIIlIIIlIlllIlIIIl) {
        char lllllllllllllIlIIlIIIlIlllIIllIl;
        for (float lllllllllllllIlIIlIIIlIlllIIlllI = ((EnumType[])(Object)(lllllllllllllIlIIlIIIlIlllIIllIl = (char)(Object)EnumType.values())).length, lllllllllllllIlIIlIIIlIlllIIllll = 0; lllllllllllllIlIIlIIIlIlllIIllll < lllllllllllllIlIIlIIIlIlllIIlllI; ++lllllllllllllIlIIlIIIlIlllIIllll) {
            final EnumType lllllllllllllIlIIlIIIlIlllIlIIll = lllllllllllllIlIIlIIIlIlllIIllIl[lllllllllllllIlIIlIIIlIlllIIllll];
            if (lllllllllllllIlIIlIIIlIlllIlIIll != EnumType.WOOD) {
                lllllllllllllIlIIlIIIlIlllIlIIIl.add(new ItemStack(this, 1, lllllllllllllIlIIlIIIlIlllIlIIll.getMetadata()));
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlIIlIIIlIlllllIIII, final Random lllllllllllllIlIIlIIIlIllllIllll, final int lllllllllllllIlIIlIIIlIllllIlllI) {
        return Item.getItemFromBlock(Blocks.STONE_SLAB);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIIlIIIlIllIllllII) {
        int lllllllllllllIlIIlIIIlIllIlllllI = 0;
        lllllllllllllIlIIlIIIlIllIlllllI |= lllllllllllllIlIIlIIIlIllIllllII.getValue(BlockStoneSlab.VARIANT).getMetadata();
        if (this.isDouble()) {
            if (lllllllllllllIlIIlIIIlIllIllllII.getValue((IProperty<Boolean>)BlockStoneSlab.SEAMLESS)) {
                lllllllllllllIlIIlIIIlIllIlllllI |= 0x8;
            }
        }
        else if (lllllllllllllIlIIlIIIlIllIllllII.getValue(BlockStoneSlab.HALF) == EnumBlockHalf.TOP) {
            lllllllllllllIlIIlIIIlIllIlllllI |= 0x8;
        }
        return lllllllllllllIlIIlIIIlIllIlllllI;
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIlIIlIIIlIllIlIlllI) {
        return lllllllllllllIlIIlIIIlIllIlIlllI.getValue(BlockStoneSlab.VARIANT).getMetadata();
    }
    
    public BlockStoneSlab() {
        super(Material.ROCK);
        IBlockState lllllllllllllIlIIlIIIlIlllllIlII = this.blockState.getBaseState();
        if (this.isDouble()) {
            lllllllllllllIlIIlIIIlIlllllIlII = lllllllllllllIlIIlIIIlIlllllIlII.withProperty((IProperty<Comparable>)BlockStoneSlab.SEAMLESS, false);
        }
        else {
            lllllllllllllIlIIlIIIlIlllllIlII = lllllllllllllIlIIlIIIlIlllllIlII.withProperty(BlockStoneSlab.HALF, EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(lllllllllllllIlIIlIIIlIlllllIlII.withProperty(BlockStoneSlab.VARIANT, EnumType.STONE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public String getUnlocalizedName(final int lllllllllllllIlIIlIIIlIllllIIIlI) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(EnumType.byMetadata(lllllllllllllIlIIlIIIlIllllIIIlI).getUnlocalizedName()));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIIlIIIlIlllIIIlIl) {
        IBlockState lllllllllllllIlIIlIIIlIlllIIIlll = this.getDefaultState().withProperty(BlockStoneSlab.VARIANT, EnumType.byMetadata(lllllllllllllIlIIlIIIlIlllIIIlIl & 0x7));
        if (this.isDouble()) {
            lllllllllllllIlIIlIIIlIlllIIIlll = lllllllllllllIlIIlIIIlIlllIIIlll.withProperty((IProperty<Comparable>)BlockStoneSlab.SEAMLESS, (lllllllllllllIlIIlIIIlIlllIIIlIl & 0x8) != 0x0);
        }
        else {
            lllllllllllllIlIIlIIIlIlllIIIlll = lllllllllllllIlIIlIIIlIlllIIIlll.withProperty(BlockStoneSlab.HALF, ((lllllllllllllIlIIlIIIlIlllIIIlIl & 0x8) == 0x0) ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return lllllllllllllIlIIlIIIlIlllIIIlll;
    }
    
    @Override
    public Comparable<?> getTypeForItem(final ItemStack lllllllllllllIlIIlIIIlIlllIllllI) {
        return EnumType.byMetadata(lllllllllllllIlIIlIIIlIlllIllllI.getMetadata() & 0x7);
    }
    
    public enum EnumType implements IStringSerializable
    {
        NETHERBRICK("NETHERBRICK", 6, 6, MapColor.NETHERRACK, "nether_brick", "netherBrick");
        
        private final /* synthetic */ String name;
        
        COBBLESTONE("COBBLESTONE", 3, 3, MapColor.STONE, "cobblestone", "cobble"), 
        SMOOTHBRICK("SMOOTHBRICK", 5, 5, MapColor.STONE, "stone_brick", "smoothStoneBrick"), 
        WOOD("WOOD", 2, 2, MapColor.WOOD, "wood_old", "wood"), 
        QUARTZ("QUARTZ", 7, 7, MapColor.QUARTZ, "quartz");
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        BRICK("BRICK", 4, 4, MapColor.RED, "brick");
        
        private final /* synthetic */ int meta;
        private final /* synthetic */ MapColor mapColor;
        private final /* synthetic */ String unlocalizedName;
        
        STONE("STONE", 0, 0, MapColor.STONE, "stone"), 
        SAND("SAND", 1, 1, MapColor.SAND, "sandstone", "sand");
        
        static {
            META_LOOKUP = new EnumType[values().length];
            int lllllllllllllIlIIIIlIllIIlIIlllI;
            for (Exception lllllllllllllIlIIIIlIllIIlIIllll = (Exception)((EnumType[])(Object)(lllllllllllllIlIIIIlIllIIlIIlllI = (int)(Object)values())).length, lllllllllllllIlIIIIlIllIIlIlIIII = (Exception)0; lllllllllllllIlIIIIlIllIIlIlIIII < lllllllllllllIlIIIIlIllIIlIIllll; ++lllllllllllllIlIIIIlIllIIlIlIIII) {
                final EnumType lllllllllllllIlIIIIlIllIIlIlIIlI = lllllllllllllIlIIIIlIllIIlIIlllI[lllllllllllllIlIIIIlIllIIlIlIIII];
                EnumType.META_LOOKUP[lllllllllllllIlIIIIlIllIIlIlIIlI.getMetadata()] = lllllllllllllIlIIIIlIllIIlIlIIlI;
            }
        }
        
        public MapColor getMapColor() {
            return this.mapColor;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        private EnumType(final String lllllllllllllIlIIIIlIllIIIllIIII, final int lllllllllllllIlIIIIlIllIIIlIllll, final int lllllllllllllIlIIIIlIllIIIllIlIl, final MapColor lllllllllllllIlIIIIlIllIIIllIlII, final String lllllllllllllIlIIIIlIllIIIlIllII, final String lllllllllllllIlIIIIlIllIIIlIlIll) {
            this.meta = lllllllllllllIlIIIIlIllIIIllIlIl;
            this.mapColor = lllllllllllllIlIIIIlIllIIIllIlII;
            this.name = lllllllllllllIlIIIIlIllIIIlIllII;
            this.unlocalizedName = lllllllllllllIlIIIIlIllIIIlIlIll;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumType(final String lllllllllllllIlIIIIlIllIIlIIIIlI, final int lllllllllllllIlIIIIlIllIIlIIIIIl, final int lllllllllllllIlIIIIlIllIIlIIIllI, final MapColor lllllllllllllIlIIIIlIllIIlIIIlIl, final String lllllllllllllIlIIIIlIllIIIlllllI) {
            this(lllllllllllllIlIIIIlIllIIlIIIIlI, lllllllllllllIlIIIIlIllIIlIIIIIl, lllllllllllllIlIIIIlIllIIlIIIllI, lllllllllllllIlIIIIlIllIIlIIIlIl, lllllllllllllIlIIIIlIllIIIlllllI, lllllllllllllIlIIIIlIllIIIlllllI);
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        public static EnumType byMetadata(int lllllllllllllIlIIIIlIllIIIIlllll) {
            if (lllllllllllllIlIIIIlIllIIIIlllll < 0 || lllllllllllllIlIIIIlIllIIIIlllll >= EnumType.META_LOOKUP.length) {
                lllllllllllllIlIIIIlIllIIIIlllll = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIlIIIIlIllIIIIlllll];
        }
    }
}
