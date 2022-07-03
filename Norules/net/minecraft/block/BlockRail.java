package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class BlockRail extends BlockRailBase
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    public static final /* synthetic */ PropertyEnum<EnumRailDirection> SHAPE;
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllllIIIIIIIllIIllIII, final Rotation llllllllllllllllIIIIIIIllIIlIlIl) {
        Label_0406: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllllIIIIIIIllIIlIlIl.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIIIIIllIIllIII.getValue(BlockRail.SHAPE).ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 5: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 8: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 9: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 10: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIIIIIllIIllIII.getValue(BlockRail.SHAPE).ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 4: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 5: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 6: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 7: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 1: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIIIIIllIIllIII.getValue(BlockRail.SHAPE).ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 4: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 5: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 6: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 7: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 1: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return llllllllllllllllIIIIIIIllIIllIII.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
            }
        }
        return llllllllllllllllIIIIIIIllIIllIII;
    }
    
    static {
        SHAPE = PropertyEnum.create("shape", EnumRailDirection.class);
    }
    
    @Override
    public IProperty<EnumRailDirection> getShapeProperty() {
        return BlockRail.SHAPE;
    }
    
    @Override
    protected void updateState(final IBlockState llllllllllllllllIIIIIIIllIlIllll, final World llllllllllllllllIIIIIIIllIlIlIIl, final BlockPos llllllllllllllllIIIIIIIllIlIlIII, final Block llllllllllllllllIIIIIIIllIlIIlll) {
        if (llllllllllllllllIIIIIIIllIlIIlll.getDefaultState().canProvidePower() && new Rail(llllllllllllllllIIIIIIIllIlIlIIl, llllllllllllllllIIIIIIIllIlIlIII, llllllllllllllllIIIIIIIllIlIllll).countAdjacentRails() == 3) {
            this.updateDir(llllllllllllllllIIIIIIIllIlIlIIl, llllllllllllllllIIIIIIIllIlIlIII, llllllllllllllllIIIIIIIllIlIllll, false);
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllllIIIIIIIllIIIllll, final Mirror llllllllllllllllIIIIIIIllIIIlIlI) {
        final EnumRailDirection llllllllllllllllIIIIIIIllIIIllIl = llllllllllllllllIIIIIIIllIIIllll.getValue(BlockRail.SHAPE);
        Label_0313: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllllllIIIIIIIllIIIlIlI.ordinal()]) {
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIIIIIllIIIllIl.ordinal()]) {
                        case 5: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        default: {
                            return super.withMirror(llllllllllllllllIIIIIIIllIIIllll, llllllllllllllllIIIIIIIllIIIlIlI);
                        }
                    }
                    break;
                }
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIIIIIllIIIllIl.ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        default: {
                            break Label_0313;
                        }
                        case 7: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return llllllllllllllllIIIIIIIllIIIllll.withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(llllllllllllllllIIIIIIIllIIIllll, llllllllllllllllIIIIIIIllIIIlIlI);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRail.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final long llllllllllllllllIIIIIIIllIIIIIlI = (Object)new int[Rotation.values().length];
        try {
            llllllllllllllllIIIIIIIllIIIIIlI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIIIIIllIIIIIlI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIIIIIllIIIIIlI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIIIIIIIllIIIIIlI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRail.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllllllIIIIIIIllIIIIIlI;
    }
    
    protected BlockRail() {
        super(false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_SOUTH));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllllIIIIIIIllIlIIIII) {
        return this.getDefaultState().withProperty(BlockRail.SHAPE, EnumRailDirection.byMetadata(llllllllllllllllIIIIIIIllIlIIIII));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRail.SHAPE });
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
        final int[] $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = BlockRail.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        if ($switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection != null) {
            return $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        }
        final byte llllllllllllllllIIIIIIIllIIIIlII = (Object)new int[EnumRailDirection.values().length];
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.EAST_WEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.NORTH_EAST.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.NORTH_SOUTH.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.NORTH_WEST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllllIIIIIIIllIIIIlII[EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        return BlockRail.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = (int[])(Object)llllllllllllllllIIIIIIIllIIIIlII;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllIIIIIIIllIIlllII) {
        return llllllllllllllllIIIIIIIllIIlllII.getValue(BlockRail.SHAPE).getMetadata();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockRail.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final char llllllllllllllllIIIIIIIllIIIIIII = (Object)new int[Mirror.values().length];
        try {
            llllllllllllllllIIIIIIIllIIIIIII[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIIIIIllIIIIIII[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIIIIIllIIIIIII[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRail.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllllllIIIIIIIllIIIIIII;
    }
}
