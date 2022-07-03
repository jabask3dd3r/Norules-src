package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.block.properties.*;
import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public abstract class BlockFlower extends BlockBush
{
    protected /* synthetic */ PropertyEnum<EnumFlowerType> type;
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlllllIlIIllIlIlIl) {
        return this.getDefaultState().withProperty(this.getTypeProperty(), EnumFlowerType.getType(this.getBlockType(), llllllllllllllIlllllIlIIllIlIlIl));
    }
    
    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XZ;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllllIlllllIlIIlllIllII, final NonNullList<ItemStack> llllllllllllllIlllllIlIIlllIIlII) {
        final char llllllllllllllIlllllIlIIllIlllll;
        final double llllllllllllllIlllllIlIIlllIIIII = ((EnumFlowerType[])(Object)(llllllllllllllIlllllIlIIllIlllll = (char)(Object)EnumFlowerType.getTypes(this.getBlockType()))).length;
        for (long llllllllllllllIlllllIlIIlllIIIIl = 0; llllllllllllllIlllllIlIIlllIIIIl < llllllllllllllIlllllIlIIlllIIIII; ++llllllllllllllIlllllIlIIlllIIIIl) {
            final EnumFlowerType llllllllllllllIlllllIlIIlllIlIII = llllllllllllllIlllllIlIIllIlllll[llllllllllllllIlllllIlIIlllIIIIl];
            llllllllllllllIlllllIlIIlllIIlII.add(new ItemStack(this, 1, llllllllllllllIlllllIlIIlllIlIII.getMeta()));
        }
    }
    
    protected BlockFlower() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getTypeProperty(), (this.getBlockType() == EnumFlowerColor.RED) ? EnumFlowerType.POPPY : EnumFlowerType.DANDELION));
    }
    
    public IProperty<EnumFlowerType> getTypeProperty() {
        if (this.type == null) {
            this.type = PropertyEnum.create("type", EnumFlowerType.class, (com.google.common.base.Predicate<EnumFlowerType>)new Predicate<EnumFlowerType>() {
                public boolean apply(@Nullable final EnumFlowerType llllllllllllllIlIIllIlllIIlIIllI) {
                    return llllllllllllllIlIIllIlllIIlIIllI.getBlockType() == BlockFlower.this.getBlockType();
                }
            });
        }
        return this.type;
    }
    
    public abstract EnumFlowerColor getBlockType();
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { this.getTypeProperty() });
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlllllIlIIllIIIIIl) {
        return llllllllllllllIlllllIlIIllIIIIIl.getValue(this.getTypeProperty()).getMeta();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIlllllIlIlIIIlIlll, final IBlockAccess llllllllllllllIlllllIlIlIIIlIllI, final BlockPos llllllllllllllIlllllIlIlIIIlIlIl) {
        return super.getBoundingBox(llllllllllllllIlllllIlIlIIIlIlll, llllllllllllllIlllllIlIlIIIlIllI, llllllllllllllIlllllIlIlIIIlIlIl).func_191194_a(llllllllllllllIlllllIlIlIIIlIlll.func_191059_e(llllllllllllllIlllllIlIlIIIlIllI, llllllllllllllIlllllIlIlIIIlIlIl));
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlllllIlIlIIIIIlIl) {
        return llllllllllllllIlllllIlIlIIIIIlIl.getValue(this.getTypeProperty()).getMeta();
    }
    
    public enum EnumFlowerColor
    {
        YELLOW("YELLOW", 0), 
        RED("RED", 1);
        
        private EnumFlowerColor(final String llllllllllllllIIlllIIlIIIIlIllII, final int llllllllllllllIIlllIIlIIIIlIlIll) {
        }
        
        public BlockFlower getBlock() {
            return (this == EnumFlowerColor.YELLOW) ? Blocks.YELLOW_FLOWER : Blocks.RED_FLOWER;
        }
    }
    
    public enum EnumFlowerType implements IStringSerializable
    {
        RED_TULIP("RED_TULIP", 5, EnumFlowerColor.RED, 4, "red_tulip", "tulipRed");
        
        private final /* synthetic */ String unlocalizedName;
        
        HOUSTONIA("HOUSTONIA", 4, EnumFlowerColor.RED, 3, "houstonia");
        
        private final /* synthetic */ String name;
        
        ORANGE_TULIP("ORANGE_TULIP", 6, EnumFlowerColor.RED, 5, "orange_tulip", "tulipOrange"), 
        PINK_TULIP("PINK_TULIP", 8, EnumFlowerColor.RED, 7, "pink_tulip", "tulipPink"), 
        BLUE_ORCHID("BLUE_ORCHID", 2, EnumFlowerColor.RED, 1, "blue_orchid", "blueOrchid"), 
        POPPY("POPPY", 1, EnumFlowerColor.RED, 0, "poppy");
        
        private final /* synthetic */ EnumFlowerColor blockType;
        private static final /* synthetic */ EnumFlowerType[][] TYPES_FOR_BLOCK;
        private final /* synthetic */ int meta;
        
        DANDELION("DANDELION", 0, EnumFlowerColor.YELLOW, 0, "dandelion"), 
        WHITE_TULIP("WHITE_TULIP", 7, EnumFlowerColor.RED, 6, "white_tulip", "tulipWhite"), 
        ALLIUM("ALLIUM", 3, EnumFlowerColor.RED, 2, "allium"), 
        OXEYE_DAISY("OXEYE_DAISY", 9, EnumFlowerColor.RED, 8, "oxeye_daisy", "oxeyeDaisy");
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public static EnumFlowerType[] getTypes(final EnumFlowerColor lllllllllllllllIlIlIIIlllIIlllll) {
            return EnumFlowerType.TYPES_FOR_BLOCK[lllllllllllllllIlIlIIIlllIIlllll.ordinal()];
        }
        
        private EnumFlowerType(final String lllllllllllllllIlIlIIIllllllIIlI, final int lllllllllllllllIlIlIIIllllllIIIl, final EnumFlowerColor lllllllllllllllIlIlIIIlllllIllll, final int lllllllllllllllIlIlIIIlllllIllIl, final String lllllllllllllllIlIlIIIlllllIlIll) {
            this(lllllllllllllllIlIlIIIllllllIIlI, lllllllllllllllIlIlIIIllllllIIIl, lllllllllllllllIlIlIIIlllllIllll, lllllllllllllllIlIlIIIlllllIllIl, lllllllllllllllIlIlIIIlllllIlIll, lllllllllllllllIlIlIIIlllllIlIll);
        }
        
        public int getMeta() {
            return this.meta;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public static EnumFlowerType getType(final EnumFlowerColor lllllllllllllllIlIlIIIlllIllIIII, int lllllllllllllllIlIlIIIlllIlIlIIl) {
            final EnumFlowerType[] lllllllllllllllIlIlIIIlllIlIllIl = EnumFlowerType.TYPES_FOR_BLOCK[lllllllllllllllIlIlIIIlllIllIIII.ordinal()];
            if (lllllllllllllllIlIlIIIlllIlIlIIl < 0 || lllllllllllllllIlIlIIIlllIlIlIIl >= lllllllllllllllIlIlIIIlllIlIllIl.length) {
                lllllllllllllllIlIlIIIlllIlIlIIl = 0;
            }
            return lllllllllllllllIlIlIIIlllIlIllIl[lllllllllllllllIlIlIIIlllIlIlIIl];
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        private EnumFlowerType(final String lllllllllllllllIlIlIIIllllIIlIlI, final int lllllllllllllllIlIlIIIllllIIlIIl, final EnumFlowerColor lllllllllllllllIlIlIIIllllIllIIl, final int lllllllllllllllIlIlIIIllllIIIlll, final String lllllllllllllllIlIlIIIllllIlIllI, final String lllllllllllllllIlIlIIIllllIIllII) {
            this.blockType = lllllllllllllllIlIlIIIllllIllIIl;
            this.meta = lllllllllllllllIlIlIIIllllIIIlll;
            this.name = lllllllllllllllIlIlIIIllllIlIllI;
            this.unlocalizedName = lllllllllllllllIlIlIIIllllIIllII;
        }
        
        public EnumFlowerColor getBlockType() {
            return this.blockType;
        }
        
        static {
            TYPES_FOR_BLOCK = new EnumFlowerType[EnumFlowerColor.values().length][];
            final boolean lllllllllllllllIlIlIIlIIIIIIlIll;
            final Exception lllllllllllllllIlIlIIlIIIIIIllIl = (Exception)((EnumFlowerColor[])(Object)(lllllllllllllllIlIlIIlIIIIIIlIll = (boolean)(Object)EnumFlowerColor.values())).length;
            for (final EnumFlowerColor lllllllllllllllIlIlIIlIIIIIlIlIl : lllllllllllllllIlIlIIlIIIIIIlIll) {
                final Collection<EnumFlowerType> lllllllllllllllIlIlIIlIIIIIlIIll = (Collection<EnumFlowerType>)Collections2.filter((Collection)Lists.newArrayList((Object[])values()), (Predicate)new Predicate<EnumFlowerType>() {
                    private final /* synthetic */ EnumFlowerColor val$blockflower$enumflowercolor;
                    
                    public boolean apply(@Nullable final EnumFlowerType lllllllllllllIlIIlllllIllllIlIlI) {
                        return lllllllllllllIlIIlllllIllllIlIlI.getBlockType() == this.val$blockflower$enumflowercolor;
                    }
                });
                EnumFlowerType.TYPES_FOR_BLOCK[lllllllllllllllIlIlIIlIIIIIlIlIl.ordinal()] = lllllllllllllllIlIlIIlIIIIIlIIll.toArray(new EnumFlowerType[lllllllllllllllIlIlIIlIIIIIlIIll.size()]);
            }
        }
    }
}
