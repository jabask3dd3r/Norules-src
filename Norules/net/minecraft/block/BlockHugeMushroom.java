package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockHugeMushroom extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType;
    private final /* synthetic */ Block smallBlock;
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIlIIllIllIIIlIIIlIl, final BlockPos lllllllllllllIlIIllIllIIIlIIIlII, final EnumFacing lllllllllllllIlIIllIllIIIlIIIIll, final float lllllllllllllIlIIllIllIIIlIIIIlI, final float lllllllllllllIlIIllIllIIIlIIIIIl, final float lllllllllllllIlIIllIllIIIlIIIIII, final int lllllllllllllIlIIllIllIIIIllllll, final EntityLivingBase lllllllllllllIlIIllIllIIIIlllllI) {
        return this.getDefaultState();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final short lllllllllllllIlIIllIllIIIIIllIIl = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIlIIllIllIIIIIllIIl[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIIl[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIIl[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIIl[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIlIIllIllIIIIIllIIl;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIlIIllIllIIIlIlIllI, final IBlockAccess lllllllllllllIlIIllIllIIIlIlIlIl, final BlockPos lllllllllllllIlIIllIllIIIlIllIII) {
        switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllllIlIIllIllIIIlIlIllI.getValue(BlockHugeMushroom.VARIANT).ordinal()]) {
            case 13: {
                return MapColor.CLOTH;
            }
            case 11: {
                return MapColor.SAND;
            }
            case 10: {
                return MapColor.SAND;
            }
            default: {
                return super.getMapColor(lllllllllllllIlIIllIllIIIlIlIllI, lllllllllllllIlIIllIllIIIlIlIlIl, lllllllllllllIlIIllIllIIIlIllIII);
            }
        }
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIlIIllIllIIIIlIIllI, final Mirror lllllllllllllIlIIllIllIIIIlIIIIl) {
        final EnumType lllllllllllllIlIIllIllIIIIlIIlII = lllllllllllllIlIIllIllIIIIlIIllI.getValue(BlockHugeMushroom.VARIANT);
        Label_0329: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllIlIIllIllIIIIlIIIIl.ordinal()]) {
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllllIlIIllIllIIIIlIIlII.ordinal()]) {
                        case 1: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                        case 2: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH);
                        }
                        case 3: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        default: {
                            return super.withMirror(lllllllllllllIlIIllIllIIIIlIIllI, lllllllllllllIlIIllIllIIIIlIIIIl);
                        }
                        case 7: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        case 8: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH);
                        }
                        case 9: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                    }
                    break;
                }
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllllIlIIllIllIIIIlIIlII.ordinal()]) {
                        case 1: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                        default: {
                            break Label_0329;
                        }
                        case 3: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        case 4: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.EAST);
                        }
                        case 6: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.WEST);
                        }
                        case 7: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        case 9: {
                            return lllllllllllllIlIIllIllIIIIlIIllI.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(lllllllllllllIlIIllIllIIIIlIIllI, lllllllllllllIlIIllIllIIIIlIIIIl);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlIIllIllIIIlIlIIIl, final Random lllllllllllllIlIIllIllIIIlIlIIII, final int lllllllllllllIlIIllIllIIIlIIllll) {
        return Item.getItemFromBlock(this.smallBlock);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType = BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType;
        }
        final long lllllllllllllIlIIllIllIIIIIllIll = (Object)new int[EnumType.values().length];
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.ALL_INSIDE.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.ALL_OUTSIDE.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.ALL_STEM.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.CENTER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.NORTH.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.NORTH_EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.NORTH_WEST.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.SOUTH.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.SOUTH_EAST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.SOUTH_WEST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.STEM.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            lllllllllllllIlIIllIllIIIIIllIll[EnumType.WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        return BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType = (int[])(Object)lllllllllllllIlIIllIllIIIIIllIll;
    }
    
    public BlockHugeMushroom(final Material lllllllllllllIlIIllIllIIIllIlIlI, final MapColor lllllllllllllIlIIllIllIIIllIlIIl, final Block lllllllllllllIlIIllIllIIIllIIlII) {
        super(lllllllllllllIlIIllIllIIIllIlIlI, lllllllllllllIlIIllIllIIIllIlIIl);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockHugeMushroom.VARIANT, EnumType.ALL_OUTSIDE));
        this.smallBlock = lllllllllllllIlIIllIllIIIllIIlII;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIIllIllIIIIllIlII) {
        return lllllllllllllIlIIllIllIIIIllIlII.getValue(BlockHugeMushroom.VARIANT).getMetadata();
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIlIIllIllIIIllIIIIl) {
        return Math.max(0, lllllllllllllIlIIllIllIIIllIIIIl.nextInt(10) - 7);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIIllIllIIIIlllIIl) {
        return this.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, EnumType.byMetadata(lllllllllllllIlIIllIllIIIIlllIIl));
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIlIIllIllIIIIlIllll, final Rotation lllllllllllllIlIIllIllIIIIlIllII) {
        Label_0401: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIlIIllIllIIIIlIllII.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllllIlIIllIllIIIIlIllll.getValue(BlockHugeMushroom.VARIANT).ordinal()]) {
                        case 10: {
                            break Label_0401;
                        }
                        case 1: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        case 2: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH);
                        }
                        case 3: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                        case 4: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.EAST);
                        }
                        case 6: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.WEST);
                        }
                        case 7: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                        case 8: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH);
                        }
                        case 9: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        default: {
                            return lllllllllllllIlIIllIllIIIIlIllll;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllllIlIIllIllIIIIlIllll.getValue(BlockHugeMushroom.VARIANT).ordinal()]) {
                        case 10: {
                            break Label_0401;
                        }
                        case 1: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                        case 2: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.WEST);
                        }
                        case 3: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        case 4: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH);
                        }
                        case 6: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH);
                        }
                        case 7: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        case 8: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.EAST);
                        }
                        case 9: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                        default: {
                            return lllllllllllllIlIIllIllIIIIlIllll;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[lllllllllllllIlIIllIllIIIIlIllll.getValue(BlockHugeMushroom.VARIANT).ordinal()]) {
                        case 10: {
                            break Label_0401;
                        }
                        case 1: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_EAST);
                        }
                        case 2: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.EAST);
                        }
                        case 3: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_EAST);
                        }
                        case 4: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH);
                        }
                        case 6: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH);
                        }
                        case 7: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.NORTH_WEST);
                        }
                        case 8: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.WEST);
                        }
                        case 9: {
                            return lllllllllllllIlIIllIllIIIIlIllll.withProperty(BlockHugeMushroom.VARIANT, EnumType.SOUTH_WEST);
                        }
                        default: {
                            return lllllllllllllIlIIllIllIIIIlIllll;
                        }
                    }
                    break;
                }
            }
        }
        return lllllllllllllIlIIllIllIIIIlIllll;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockHugeMushroom.VARIANT });
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlIIllIllIIIlIIlIll, final BlockPos lllllllllllllIlIIllIllIIIlIIlIlI, final IBlockState lllllllllllllIlIIllIllIIIlIIlIIl) {
        return new ItemStack(this.smallBlock);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final char lllllllllllllIlIIllIllIIIIIlIlll = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllIlIIllIllIIIIIlIlll[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIllIIIIIlIlll[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIllIIIIIlIlll[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockHugeMushroom.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllIlIIllIllIIIIIlIlll;
    }
    
    public enum EnumType implements IStringSerializable
    {
        ALL_OUTSIDE("ALL_OUTSIDE", 11, 14, "all_outside"), 
        EAST("EAST", 5, 6, "east"), 
        SOUTH_WEST("SOUTH_WEST", 6, 7, "south_west"), 
        NORTH_WEST("NORTH_WEST", 0, 1, "north_west");
        
        private final /* synthetic */ String name;
        
        CENTER("CENTER", 4, 5, "center"), 
        STEM("STEM", 9, 10, "stem"), 
        NORTH_EAST("NORTH_EAST", 2, 3, "north_east"), 
        SOUTH("SOUTH", 7, 8, "south"), 
        ALL_STEM("ALL_STEM", 12, 15, "all_stem"), 
        NORTH("NORTH", 1, 2, "north"), 
        WEST("WEST", 3, 4, "west"), 
        ALL_INSIDE("ALL_INSIDE", 10, 0, "all_inside"), 
        SOUTH_EAST("SOUTH_EAST", 8, 9, "south_east");
        
        private final /* synthetic */ int meta;
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        
        static {
            META_LOOKUP = new EnumType[16];
            final int lllllllllllllIIIIlIIlllIlIlIllII;
            final short lllllllllllllIIIIlIIlllIlIlIllIl = (short)((EnumType[])(Object)(lllllllllllllIIIIlIIlllIlIlIllII = (int)(Object)values())).length;
            for (float lllllllllllllIIIIlIIlllIlIlIlllI = 0; lllllllllllllIIIIlIIlllIlIlIlllI < lllllllllllllIIIIlIIlllIlIlIllIl; ++lllllllllllllIIIIlIIlllIlIlIlllI) {
                final EnumType lllllllllllllIIIIlIIlllIlIllIIII = lllllllllllllIIIIlIIlllIlIlIllII[lllllllllllllIIIIlIIlllIlIlIlllI];
                EnumType.META_LOOKUP[lllllllllllllIIIIlIIlllIlIllIIII.getMetadata()] = lllllllllllllIIIIlIIlllIlIllIIII;
            }
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        public static EnumType byMetadata(int lllllllllllllIIIIlIIlllIlIIlIlII) {
            if (lllllllllllllIIIIlIIlllIlIIlIlII < 0 || lllllllllllllIIIIlIIlllIlIIlIlII >= EnumType.META_LOOKUP.length) {
                lllllllllllllIIIIlIIlllIlIIlIlII = 0;
            }
            final EnumType lllllllllllllIIIIlIIlllIlIIlIlIl = EnumType.META_LOOKUP[lllllllllllllIIIIlIIlllIlIIlIlII];
            return (lllllllllllllIIIIlIIlllIlIIlIlIl == null) ? EnumType.META_LOOKUP[0] : lllllllllllllIIIIlIIlllIlIIlIlIl;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumType(final String lllllllllllllIIIIlIIlllIlIlIIIlI, final int lllllllllllllIIIIlIIlllIlIlIIIIl, final int lllllllllllllIIIIlIIlllIlIlIIIII, final String lllllllllllllIIIIlIIlllIlIIlllll) {
            this.meta = lllllllllllllIIIIlIIlllIlIlIIIII;
            this.name = lllllllllllllIIIIlIIlllIlIIlllll;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
