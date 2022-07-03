package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockRailPowered extends BlockRailBase
{
    public static final /* synthetic */ PropertyEnum<EnumRailDirection> SHAPE;
    public static final /* synthetic */ PropertyBool POWERED;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
    
    @Override
    protected void updateState(final IBlockState llllllllllllllllIIIlIlIllIIIlIII, final World llllllllllllllllIIIlIlIllIIIIIII, final BlockPos llllllllllllllllIIIlIlIllIIIIllI, final Block llllllllllllllllIIIlIlIllIIIIlIl) {
        final boolean llllllllllllllllIIIlIlIllIIIIlII = llllllllllllllllIIIlIlIllIIIlIII.getValue((IProperty<Boolean>)BlockRailPowered.POWERED);
        final boolean llllllllllllllllIIIlIlIllIIIIIll = llllllllllllllllIIIlIlIllIIIIIII.isBlockPowered(llllllllllllllllIIIlIlIllIIIIllI) || this.findPoweredRailSignal(llllllllllllllllIIIlIlIllIIIIIII, llllllllllllllllIIIlIlIllIIIIllI, llllllllllllllllIIIlIlIllIIIlIII, true, 0) || this.findPoweredRailSignal(llllllllllllllllIIIlIlIllIIIIIII, llllllllllllllllIIIlIlIllIIIIllI, llllllllllllllllIIIlIlIllIIIlIII, false, 0);
        if (llllllllllllllllIIIlIlIllIIIIIll != llllllllllllllllIIIlIlIllIIIIlII) {
            llllllllllllllllIIIlIlIllIIIIIII.setBlockState(llllllllllllllllIIIlIlIllIIIIllI, llllllllllllllllIIIlIlIllIIIlIII.withProperty((IProperty<Comparable>)BlockRailPowered.POWERED, llllllllllllllllIIIlIlIllIIIIIll), 3);
            llllllllllllllllIIIlIlIllIIIIIII.notifyNeighborsOfStateChange(llllllllllllllllIIIlIlIllIIIIllI.down(), this, false);
            if (llllllllllllllllIIIlIlIllIIIlIII.getValue(BlockRailPowered.SHAPE).isAscending()) {
                llllllllllllllllIIIlIlIllIIIIIII.notifyNeighborsOfStateChange(llllllllllllllllIIIlIlIllIIIIllI.up(), this, false);
            }
        }
    }
    
    protected boolean isSameRailWithPower(final World llllllllllllllllIIIlIlIllIIlIllI, final BlockPos llllllllllllllllIIIlIlIllIIlIlIl, final boolean llllllllllllllllIIIlIlIllIIlIlII, final int llllllllllllllllIIIlIlIllIIlIIll, final EnumRailDirection llllllllllllllllIIIlIlIllIIllIlI) {
        final IBlockState llllllllllllllllIIIlIlIllIIllIIl = llllllllllllllllIIIlIlIllIIlIllI.getBlockState(llllllllllllllllIIIlIlIllIIlIlIl);
        if (llllllllllllllllIIIlIlIllIIllIIl.getBlock() != this) {
            return false;
        }
        final EnumRailDirection llllllllllllllllIIIlIlIllIIllIII = llllllllllllllllIIIlIlIllIIllIIl.getValue(BlockRailPowered.SHAPE);
        return (llllllllllllllllIIIlIlIllIIllIlI != EnumRailDirection.EAST_WEST || (llllllllllllllllIIIlIlIllIIllIII != EnumRailDirection.NORTH_SOUTH && llllllllllllllllIIIlIlIllIIllIII != EnumRailDirection.ASCENDING_NORTH && llllllllllllllllIIIlIlIllIIllIII != EnumRailDirection.ASCENDING_SOUTH)) && (llllllllllllllllIIIlIlIllIIllIlI != EnumRailDirection.NORTH_SOUTH || (llllllllllllllllIIIlIlIllIIllIII != EnumRailDirection.EAST_WEST && llllllllllllllllIIIlIlIllIIllIII != EnumRailDirection.ASCENDING_EAST && llllllllllllllllIIIlIlIllIIllIII != EnumRailDirection.ASCENDING_WEST)) && llllllllllllllllIIIlIlIllIIllIIl.getValue((IProperty<Boolean>)BlockRailPowered.POWERED) && (llllllllllllllllIIIlIlIllIIlIllI.isBlockPowered(llllllllllllllllIIIlIlIllIIlIlIl) || this.findPoweredRailSignal(llllllllllllllllIIIlIlIllIIlIllI, llllllllllllllllIIIlIlIllIIlIlIl, llllllllllllllllIIIlIlIllIIllIIl, llllllllllllllllIIIlIlIllIIlIlII, llllllllllllllllIIIlIlIllIIlIIll + 1));
    }
    
    static {
        SHAPE = PropertyEnum.create("shape", EnumRailDirection.class, (com.google.common.base.Predicate<EnumRailDirection>)new Predicate<EnumRailDirection>() {
            public boolean apply(@Nullable final EnumRailDirection lllllllllllllIllIlllIIllIIIIlllI) {
                return lllllllllllllIllIlllIIllIIIIlllI != EnumRailDirection.NORTH_EAST && lllllllllllllIllIlllIIllIIIIlllI != EnumRailDirection.NORTH_WEST && lllllllllllllIllIlllIIllIIIIlllI != EnumRailDirection.SOUTH_EAST && lllllllllllllIllIlllIIllIIIIlllI != EnumRailDirection.SOUTH_WEST;
            }
        });
        POWERED = PropertyBool.create("powered");
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRailPowered.SHAPE, BlockRailPowered.POWERED });
    }
    
    protected boolean findPoweredRailSignal(final World llllllllllllllllIIIlIlIllIllIIIl, final BlockPos llllllllllllllllIIIlIlIllIllIIII, final IBlockState llllllllllllllllIIIlIlIllIlllIlI, final boolean llllllllllllllllIIIlIlIllIlllIIl, final int llllllllllllllllIIIlIlIllIlIllIl) {
        if (llllllllllllllllIIIlIlIllIlIllIl >= 8) {
            return false;
        }
        int llllllllllllllllIIIlIlIllIllIlll = llllllllllllllllIIIlIlIllIllIIII.getX();
        int llllllllllllllllIIIlIlIllIllIllI = llllllllllllllllIIIlIlIllIllIIII.getY();
        int llllllllllllllllIIIlIlIllIllIlIl = llllllllllllllllIIIlIlIllIllIIII.getZ();
        boolean llllllllllllllllIIIlIlIllIllIlII = true;
        EnumRailDirection llllllllllllllllIIIlIlIllIllIIll = llllllllllllllllIIIlIlIllIlllIlI.getValue(BlockRailPowered.SHAPE);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIlIllIllIIll.ordinal()]) {
            case 1: {
                if (llllllllllllllllIIIlIlIllIlllIIl) {
                    ++llllllllllllllllIIIlIlIllIllIlIl;
                    break;
                }
                --llllllllllllllllIIIlIlIllIllIlIl;
                break;
            }
            case 2: {
                if (llllllllllllllllIIIlIlIllIlllIIl) {
                    --llllllllllllllllIIIlIlIllIllIlll;
                    break;
                }
                ++llllllllllllllllIIIlIlIllIllIlll;
                break;
            }
            case 3: {
                if (llllllllllllllllIIIlIlIllIlllIIl) {
                    --llllllllllllllllIIIlIlIllIllIlll;
                }
                else {
                    ++llllllllllllllllIIIlIlIllIllIlll;
                    ++llllllllllllllllIIIlIlIllIllIllI;
                    llllllllllllllllIIIlIlIllIllIlII = false;
                }
                llllllllllllllllIIIlIlIllIllIIll = EnumRailDirection.EAST_WEST;
                break;
            }
            case 4: {
                if (llllllllllllllllIIIlIlIllIlllIIl) {
                    --llllllllllllllllIIIlIlIllIllIlll;
                    ++llllllllllllllllIIIlIlIllIllIllI;
                    llllllllllllllllIIIlIlIllIllIlII = false;
                }
                else {
                    ++llllllllllllllllIIIlIlIllIllIlll;
                }
                llllllllllllllllIIIlIlIllIllIIll = EnumRailDirection.EAST_WEST;
                break;
            }
            case 5: {
                if (llllllllllllllllIIIlIlIllIlllIIl) {
                    ++llllllllllllllllIIIlIlIllIllIlIl;
                }
                else {
                    --llllllllllllllllIIIlIlIllIllIlIl;
                    ++llllllllllllllllIIIlIlIllIllIllI;
                    llllllllllllllllIIIlIlIllIllIlII = false;
                }
                llllllllllllllllIIIlIlIllIllIIll = EnumRailDirection.NORTH_SOUTH;
                break;
            }
            case 6: {
                if (llllllllllllllllIIIlIlIllIlllIIl) {
                    ++llllllllllllllllIIIlIlIllIllIlIl;
                    ++llllllllllllllllIIIlIlIllIllIllI;
                    llllllllllllllllIIIlIlIllIllIlII = false;
                }
                else {
                    --llllllllllllllllIIIlIlIllIllIlIl;
                }
                llllllllllllllllIIIlIlIllIllIIll = EnumRailDirection.NORTH_SOUTH;
                break;
            }
        }
        return this.isSameRailWithPower(llllllllllllllllIIIlIlIllIllIIIl, new BlockPos(llllllllllllllllIIIlIlIllIllIlll, llllllllllllllllIIIlIlIllIllIllI, llllllllllllllllIIIlIlIllIllIlIl), llllllllllllllllIIIlIlIllIlllIIl, llllllllllllllllIIIlIlIllIlIllIl, llllllllllllllllIIIlIlIllIllIIll) || (llllllllllllllllIIIlIlIllIllIlII && this.isSameRailWithPower(llllllllllllllllIIIlIlIllIllIIIl, new BlockPos(llllllllllllllllIIIlIlIllIllIlll, llllllllllllllllIIIlIlIllIllIllI - 1, llllllllllllllllIIIlIlIllIllIlIl), llllllllllllllllIIIlIlIllIlllIIl, llllllllllllllllIIIlIlIllIlIllIl, llllllllllllllllIIIlIlIllIllIIll));
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllllIIIlIlIlIllIlIll, final Rotation llllllllllllllllIIIlIlIlIllIlIII) {
        Label_0406: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllllIIIlIlIlIllIlIII.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIlIlIllIlIll.getValue(BlockRailPowered.SHAPE).ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 5: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIlIlIllIlIll.getValue(BlockRailPowered.SHAPE).ordinal()]) {
                        case 1: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        case 3: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 4: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 5: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 6: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 7: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIlIlIllIlIll.getValue(BlockRailPowered.SHAPE).ordinal()]) {
                        case 1: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        case 3: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 4: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 5: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 6: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 7: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIlIlIllIlIll.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
            }
        }
        return llllllllllllllllIIIlIlIlIllIlIll;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
        final int[] $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = BlockRailPowered.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        if ($switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection != null) {
            return $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        }
        final int llllllllllllllllIIIlIlIlIlIlIlll = (Object)new int[EnumRailDirection.values().length];
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.EAST_WEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.NORTH_EAST.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.NORTH_SOUTH.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.NORTH_WEST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlll[EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        return BlockRailPowered.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = (int[])(Object)llllllllllllllllIIIlIlIlIlIlIlll;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockRailPowered.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final long llllllllllllllllIIIlIlIlIlIlIIll = (Object)new int[Mirror.values().length];
        try {
            llllllllllllllllIIIlIlIlIlIlIIll[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIIll[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIIll[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRailPowered.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllllllIIIlIlIlIlIlIIll;
    }
    
    @Override
    public IProperty<EnumRailDirection> getShapeProperty() {
        return BlockRailPowered.SHAPE;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllIIIlIlIlIlllIIlI) {
        int llllllllllllllllIIIlIlIlIlllIIIl = 0;
        llllllllllllllllIIIlIlIlIlllIIIl |= llllllllllllllllIIIlIlIlIlllIIlI.getValue(BlockRailPowered.SHAPE).getMetadata();
        if (llllllllllllllllIIIlIlIlIlllIIlI.getValue((IProperty<Boolean>)BlockRailPowered.POWERED)) {
            llllllllllllllllIIIlIlIlIlllIIIl |= 0x8;
        }
        return llllllllllllllllIIIlIlIlIlllIIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRailPowered.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final short llllllllllllllllIIIlIlIlIlIlIlIl = (Object)new int[Rotation.values().length];
        try {
            llllllllllllllllIIIlIlIlIlIlIlIl[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlIl[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlIl[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIIIlIlIlIlIlIlIl[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRailPowered.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllllllIIIlIlIlIlIlIlIl;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllllIIIlIlIlIlIllllI, final Mirror llllllllllllllllIIIlIlIlIlIlllIl) {
        final EnumRailDirection llllllllllllllllIIIlIlIlIllIIIII = llllllllllllllllIIIlIlIlIlIllllI.getValue(BlockRailPowered.SHAPE);
        Label_0313: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllllllIIIlIlIlIlIlllIl.ordinal()]) {
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIlIlIllIIIII.ordinal()]) {
                        case 5: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        default: {
                            return super.withMirror(llllllllllllllllIIIlIlIlIlIllllI, llllllllllllllllIIIlIlIlIlIlllIl);
                        }
                    }
                    break;
                }
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIIIlIlIlIllIIIII.ordinal()]) {
                        case 3: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        default: {
                            break Label_0313;
                        }
                        case 7: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return llllllllllllllllIIIlIlIlIlIllllI.withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(llllllllllllllllIIIlIlIlIlIllllI, llllllllllllllllIIIlIlIlIlIlllIl);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllllIIIlIlIlIlllIllI) {
        return this.getDefaultState().withProperty(BlockRailPowered.SHAPE, EnumRailDirection.byMetadata(llllllllllllllllIIIlIlIlIlllIllI & 0x7)).withProperty((IProperty<Comparable>)BlockRailPowered.POWERED, (llllllllllllllllIIIlIlIlIlllIllI & 0x8) > 0);
    }
    
    protected BlockRailPowered() {
        super(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRailPowered.SHAPE, EnumRailDirection.NORTH_SOUTH).withProperty((IProperty<Comparable>)BlockRailPowered.POWERED, false));
    }
}
