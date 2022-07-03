package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockQuartz extends Block
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType;
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIIIIllIlllllllIII) {
        return lllllllllllllIIIIIIllIlllllllIII.getValue(BlockQuartz.VARIANT).getMetadata();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockQuartz.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final short lllllllllllllIIIIIIllIlllllIlIII = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIIIIIIllIlllllIlIII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIIIllIlllllIlIII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIIIllIlllllIlIII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIIIIllIlllllIlIII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockQuartz.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIIIIIIllIlllllIlIII;
    }
    
    public BlockQuartz() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockQuartz.VARIANT, EnumType.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIIIIIIlllIIIIlIIlll, final BlockPos lllllllllllllIIIIIIlllIIIIlIIllI, final EnumFacing lllllllllllllIIIIIIlllIIIIIllllI, final float lllllllllllllIIIIIIlllIIIIlIIlII, final float lllllllllllllIIIIIIlllIIIIlIIIll, final float lllllllllllllIIIIIIlllIIIIlIIIlI, final int lllllllllllllIIIIIIlllIIIIIlllIl, final EntityLivingBase lllllllllllllIIIIIIlllIIIIlIIIII) {
        if (lllllllllllllIIIIIIlllIIIIIlllIl == EnumType.LINES_Y.getMetadata()) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllIIIIIIlllIIIIIllllI.getAxis().ordinal()]) {
                case 3: {
                    return this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.LINES_Z);
                }
                case 1: {
                    return this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.LINES_X);
                }
                case 2: {
                    return this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.LINES_Y);
                }
            }
        }
        return (lllllllllllllIIIIIIlllIIIIIlllIl == EnumType.CHISELED.getMetadata()) ? this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.CHISELED) : this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.DEFAULT);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIIIIIllIllllllIlII, final Rotation lllllllllllllIIIIIIllIllllllIIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIIIIIIllIllllllIIIl.ordinal()]) {
            case 2:
            case 4: {
                switch ($SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType()[lllllllllllllIIIIIIllIllllllIlII.getValue(BlockQuartz.VARIANT).ordinal()]) {
                    case 4: {
                        return lllllllllllllIIIIIIllIllllllIlII.withProperty(BlockQuartz.VARIANT, EnumType.LINES_Z);
                    }
                    case 5: {
                        return lllllllllllllIIIIIIllIllllllIlII.withProperty(BlockQuartz.VARIANT, EnumType.LINES_X);
                    }
                    default: {
                        return lllllllllllllIIIIIIllIllllllIlII;
                    }
                }
                break;
            }
            default: {
                return lllllllllllllIIIIIIllIllllllIlII;
            }
        }
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = BlockQuartz.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final float lllllllllllllIIIIIIllIlllllIllII = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllllIIIIIIllIlllllIllII[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIIIllIlllllIllII[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIIIllIlllllIllII[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockQuartz.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllllIIIIIIllIlllllIllII;
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState lllllllllllllIIIIIIlllIIIIIIlllI) {
        final EnumType lllllllllllllIIIIIIlllIIIIIlIIII = lllllllllllllIIIIIIlllIIIIIIlllI.getValue(BlockQuartz.VARIANT);
        return (lllllllllllllIIIIIIlllIIIIIlIIII != EnumType.LINES_X && lllllllllllllIIIIIIlllIIIIIlIIII != EnumType.LINES_Z) ? super.getSilkTouchDrop(lllllllllllllIIIIIIlllIIIIIIlllI) : new ItemStack(Item.getItemFromBlock(this), 1, EnumType.LINES_Y.getMetadata());
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIIIIIIlllIIIIIlIlll) {
        final EnumType lllllllllllllIIIIIIlllIIIIIllIII = lllllllllllllIIIIIIlllIIIIIlIlll.getValue(BlockQuartz.VARIANT);
        return (lllllllllllllIIIIIIlllIIIIIllIII != EnumType.LINES_X && lllllllllllllIIIIIIlllIIIIIllIII != EnumType.LINES_Z) ? lllllllllllllIIIIIIlllIIIIIllIII.getMetadata() : EnumType.LINES_Y.getMetadata();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockQuartz$EnumType = BlockQuartz.$SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockQuartz$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockQuartz$EnumType;
        }
        final long lllllllllllllIIIIIIllIlllllIlIlI = (Object)new int[EnumType.values().length];
        try {
            lllllllllllllIIIIIIllIlllllIlIlI[EnumType.CHISELED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIIIllIlllllIlIlI[EnumType.DEFAULT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIIIllIlllllIlIlI[EnumType.LINES_X.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIIIIllIlllllIlIlI[EnumType.LINES_Y.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIIIIllIlllllIlIlI[EnumType.LINES_Z.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return BlockQuartz.$SWITCH_TABLE$net$minecraft$block$BlockQuartz$EnumType = (int[])(Object)lllllllllllllIIIIIIllIlllllIlIlI;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIIIIIIlllIIIIIIlIIl, final NonNullList<ItemStack> lllllllllllllIIIIIIlllIIIIIIIllI) {
        lllllllllllllIIIIIIlllIIIIIIIllI.add(new ItemStack(this, 1, EnumType.DEFAULT.getMetadata()));
        lllllllllllllIIIIIIlllIIIIIIIllI.add(new ItemStack(this, 1, EnumType.CHISELED.getMetadata()));
        lllllllllllllIIIIIIlllIIIIIIIllI.add(new ItemStack(this, 1, EnumType.LINES_Y.getMetadata()));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockQuartz.VARIANT });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIIIIllIlllllllllI) {
        return this.getDefaultState().withProperty(BlockQuartz.VARIANT, EnumType.byMetadata(lllllllllllllIIIIIIllIlllllllllI));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIIIIIIlllIIIIIIIlII, final IBlockAccess lllllllllllllIIIIIIlllIIIIIIIIll, final BlockPos lllllllllllllIIIIIIlllIIIIIIIIlI) {
        return MapColor.QUARTZ;
    }
    
    public enum EnumType implements IStringSerializable
    {
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        DEFAULT("DEFAULT", 0, 0, "default", "default");
        
        private final /* synthetic */ int meta;
        
        LINES_Z("LINES_Z", 4, 4, "lines_z", "lines"), 
        CHISELED("CHISELED", 1, 1, "chiseled", "chiseled"), 
        LINES_X("LINES_X", 3, 3, "lines_x", "lines"), 
        LINES_Y("LINES_Y", 2, 2, "lines_y", "lines");
        
        private final /* synthetic */ String unlocalizedName;
        private final /* synthetic */ String serializedName;
        
        public static EnumType byMetadata(int lllllllllllllIlIIlIIlllIlIIlIllI) {
            if (lllllllllllllIlIIlIIlllIlIIlIllI < 0 || lllllllllllllIlIIlIIlllIlIIlIllI >= EnumType.META_LOOKUP.length) {
                lllllllllllllIlIIlIIlllIlIIlIllI = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIlIIlIIlllIlIIlIllI];
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            short lllllllllllllIlIIlIIlllIlIlIllll;
            for (short lllllllllllllIlIIlIIlllIlIllIIII = (short)((EnumType[])(Object)(lllllllllllllIlIIlIIlllIlIlIllll = (short)(Object)values())).length, lllllllllllllIlIIlIIlllIlIllIIIl = 0; lllllllllllllIlIIlIIlllIlIllIIIl < lllllllllllllIlIIlIIlllIlIllIIII; ++lllllllllllllIlIIlIIlllIlIllIIIl) {
                final EnumType lllllllllllllIlIIlIIlllIlIllIIll = lllllllllllllIlIIlIIlllIlIlIllll[lllllllllllllIlIIlIIlllIlIllIIIl];
                EnumType.META_LOOKUP[lllllllllllllIlIIlIIlllIlIllIIll.getMetadata()] = lllllllllllllIlIIlIIlllIlIllIIll;
            }
        }
        
        private EnumType(final String lllllllllllllIlIIlIIlllIlIlIIIll, final int lllllllllllllIlIIlIIlllIlIlIIIlI, final int lllllllllllllIlIIlIIlllIlIlIIIIl, final String lllllllllllllIlIIlIIlllIlIlIIllI, final String lllllllllllllIlIIlIIlllIlIIlllll) {
            this.meta = lllllllllllllIlIIlIIlllIlIlIIIIl;
            this.serializedName = lllllllllllllIlIIlIIlllIlIlIIllI;
            this.unlocalizedName = lllllllllllllIlIIlIIlllIlIIlllll;
        }
        
        @Override
        public String toString() {
            return this.unlocalizedName;
        }
        
        @Override
        public String getName() {
            return this.serializedName;
        }
        
        public int getMetadata() {
            return this.meta;
        }
    }
}
