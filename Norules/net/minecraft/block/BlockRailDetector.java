package net.minecraft.block;

import net.minecraft.block.properties.*;
import com.google.common.base.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.inventory.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.util.math.*;

public class BlockRailDetector extends BlockRailBase
{
    public static final /* synthetic */ PropertyEnum<EnumRailDirection> SHAPE;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    public static final /* synthetic */ PropertyBool POWERED;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRailDetector.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final double lllllllllllllIllllIIIIlIlIlIllll = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIllllIIIIlIlIlIllll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIIIlIlIlIllll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIIIlIlIlIllll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIIIIlIlIlIllll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRailDetector.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIllllIIIIlIlIlIllll;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIllllIIIIlIlIllllII, final Mirror lllllllllllllIllllIIIIlIlIlllIll) {
        final EnumRailDirection lllllllllllllIllllIIIIlIlIlllIlI = lllllllllllllIllllIIIIlIlIllllII.getValue(BlockRailDetector.SHAPE);
        Label_0313: {
            switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllIllllIIIIlIlIlllIll.ordinal()]) {
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIIIlIlIlllIlI.ordinal()]) {
                        case 5: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        default: {
                            return super.withMirror(lllllllllllllIllllIIIIlIlIllllII, lllllllllllllIllllIIIIlIlIlllIll);
                        }
                    }
                    break;
                }
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIIIlIlIlllIlI.ordinal()]) {
                        case 3: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        default: {
                            break Label_0313;
                        }
                        case 7: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIIIlIlIllllII.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                    }
                    break;
                }
            }
        }
        return super.withMirror(lllllllllllllIllllIIIIlIlIllllII, lllllllllllllIllllIIIIlIlIlllIll);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockRailDetector.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final double lllllllllllllIllllIIIIlIlIlIllIl = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllIllllIIIIlIlIlIllIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIIIlIlIlIllIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIIIlIlIlIllIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRailDetector.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllIllllIIIIlIlIlIllIl;
    }
    
    public BlockRailDetector() {
        super(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockRailDetector.POWERED, false).withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_SOUTH));
        this.setTickRandomly(true);
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllIllllIIIIlIllllIIll, final World lllllllllllllIllllIIIIlIlllllIII, final BlockPos lllllllllllllIllllIIIIlIllllIlll) {
        if (lllllllllllllIllllIIIIlIllllIIll.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            final List<EntityMinecartCommandBlock> lllllllllllllIllllIIIIlIllllIllI = this.findMinecarts(lllllllllllllIllllIIIIlIlllllIII, lllllllllllllIllllIIIIlIllllIlll, EntityMinecartCommandBlock.class, (Predicate<Entity>[])new Predicate[0]);
            if (!lllllllllllllIllllIIIIlIllllIllI.isEmpty()) {
                return lllllllllllllIllllIIIIlIllllIllI.get(0).getCommandBlockLogic().getSuccessCount();
            }
            final List<EntityMinecart> lllllllllllllIllllIIIIlIllllIlIl = this.findMinecarts(lllllllllllllIllllIIIIlIlllllIII, lllllllllllllIllllIIIIlIllllIlll, EntityMinecart.class, EntitySelectors.HAS_INVENTORY);
            if (!lllllllllllllIllllIIIIlIllllIlIl.isEmpty()) {
                return Container.calcRedstoneFromInventory((IInventory)lllllllllllllIllllIIIIlIllllIlIl.get(0));
            }
        }
        return 0;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIllllIIIIllIIIIIllI, final BlockPos lllllllllllllIllllIIIIllIIIIlIIl, final IBlockState lllllllllllllIllllIIIIllIIIIIlII) {
        super.onBlockAdded(lllllllllllllIllllIIIIllIIIIIllI, lllllllllllllIllllIIIIllIIIIlIIl, lllllllllllllIllllIIIIllIIIIIlII);
        this.updatePoweredState(lllllllllllllIllllIIIIllIIIIIllI, lllllllllllllIllllIIIIllIIIIlIIl, lllllllllllllIllllIIIIllIIIIIlII);
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllIllllIIIIllIllIllII) {
        return true;
    }
    
    @Override
    public int tickRate(final World lllllllllllllIllllIIIIllIllIlllI) {
        return 20;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRailDetector.SHAPE, BlockRailDetector.POWERED });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllllIIIIlIllIlIIlI) {
        return this.getDefaultState().withProperty(BlockRailDetector.SHAPE, EnumRailDirection.byMetadata(lllllllllllllIllllIIIIlIllIlIIlI & 0x7)).withProperty((IProperty<Comparable>)BlockRailDetector.POWERED, (lllllllllllllIllllIIIIlIllIlIIlI & 0x8) > 0);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllIllllIIIIllIllIIIIl, final BlockPos lllllllllllllIllllIIIIllIllIIlIl, final IBlockState lllllllllllllIllllIIIIllIlIlllll, final Entity lllllllllllllIllllIIIIllIllIIIll) {
        if (!lllllllllllllIllllIIIIllIllIIIIl.isRemote && !lllllllllllllIllllIIIIllIlIlllll.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            this.updatePoweredState(lllllllllllllIllllIIIIllIllIIIIl, lllllllllllllIllllIIIIllIllIIlIl, lllllllllllllIllllIIIIllIlIlllll);
        }
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIllllIIIIlIllIIIlIl, final Rotation lllllllllllllIllllIIIIlIllIIIlII) {
        Label_0406: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIllllIIIIlIllIIIlII.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIIIlIllIIIlIl.getValue(BlockRailDetector.SHAPE).ordinal()]) {
                        case 3: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 4: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 5: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 6: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 7: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIIIlIllIIIlIl.getValue(BlockRailDetector.SHAPE).ordinal()]) {
                        case 3: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 4: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 5: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 6: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 7: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 1: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIllllIIIIlIllIIIlIl.getValue(BlockRailDetector.SHAPE).ordinal()]) {
                        case 3: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_SOUTH);
                        }
                        case 4: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_NORTH);
                        }
                        case 5: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_EAST);
                        }
                        case 6: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.ASCENDING_WEST);
                        }
                        case 7: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_WEST);
                        }
                        case 8: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_WEST);
                        }
                        case 9: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_EAST);
                        }
                        case 10: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.SOUTH_EAST);
                        }
                        case 1: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.EAST_WEST);
                        }
                        case 2: {
                            return lllllllllllllIllllIIIIlIllIIIlIl.withProperty(BlockRailDetector.SHAPE, EnumRailDirection.NORTH_SOUTH);
                        }
                        default: {
                            break Label_0406;
                        }
                    }
                    break;
                }
            }
        }
        return lllllllllllllIllllIIIIlIllIIIlIl;
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllIllllIIIIllIIlllllI, final IBlockAccess lllllllllllllIllllIIIIllIlIIIIIl, final BlockPos lllllllllllllIllllIIIIllIlIIIIII, final EnumFacing lllllllllllllIllllIIIIllIIllllll) {
        if (!lllllllllllllIllllIIIIllIIlllllI.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            return 0;
        }
        return (lllllllllllllIllllIIIIllIIllllll == EnumFacing.UP) ? 15 : 0;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllIllllIIIIllIIIIIIIl) {
        return true;
    }
    
    @Override
    public void randomTick(final World lllllllllllllIllllIIIIllIlIlllIl, final BlockPos lllllllllllllIllllIIIIllIlIlllII, final IBlockState lllllllllllllIllllIIIIllIlIllIll, final Random lllllllllllllIllllIIIIllIlIllIlI) {
    }
    
    @Override
    public void updateTick(final World lllllllllllllIllllIIIIllIlIlIlII, final BlockPos lllllllllllllIllllIIIIllIlIIlllI, final IBlockState lllllllllllllIllllIIIIllIlIIllIl, final Random lllllllllllllIllllIIIIllIlIlIIIl) {
        if (!lllllllllllllIllllIIIIllIlIlIlII.isRemote && lllllllllllllIllllIIIIllIlIIllIl.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            this.updatePoweredState(lllllllllllllIllllIIIIllIlIlIlII, lllllllllllllIllllIIIIllIlIIlllI, lllllllllllllIllllIIIIllIlIIllIl);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllllIIIIlIllIIllII) {
        int lllllllllllllIllllIIIIlIllIIlIll = 0;
        lllllllllllllIllllIIIIlIllIIlIll |= lllllllllllllIllllIIIIlIllIIllII.getValue(BlockRailDetector.SHAPE).getMetadata();
        if (lllllllllllllIllllIIIIlIllIIllII.getValue((IProperty<Boolean>)BlockRailDetector.POWERED)) {
            lllllllllllllIllllIIIIlIllIIlIll |= 0x8;
        }
        return lllllllllllllIllllIIIIlIllIIlIll;
    }
    
    private AxisAlignedBB getDectectionBox(final BlockPos lllllllllllllIllllIIIIlIllIlIlll) {
        final float lllllllllllllIllllIIIIlIllIllIII = 0.2f;
        return new AxisAlignedBB(lllllllllllllIllllIIIIlIllIlIlll.getX() + 0.2f, lllllllllllllIllllIIIIlIllIlIlll.getY(), lllllllllllllIllllIIIIlIllIlIlll.getZ() + 0.2f, lllllllllllllIllllIIIIlIllIlIlll.getX() + 1 - 0.2f, lllllllllllllIllllIIIIlIllIlIlll.getY() + 1 - 0.2f, lllllllllllllIllllIIIIlIllIlIlll.getZ() + 1 - 0.2f);
    }
    
    protected void updateConnectedRails(final World lllllllllllllIllllIIIIllIIIllllI, final BlockPos lllllllllllllIllllIIIIllIIIlIlIl, final IBlockState lllllllllllllIllllIIIIllIIIlllII, final boolean lllllllllllllIllllIIIIllIIIllIll) {
        final Rail lllllllllllllIllllIIIIllIIIllIlI = new Rail(lllllllllllllIllllIIIIllIIIllllI, lllllllllllllIllllIIIIllIIIlIlIl, lllllllllllllIllllIIIIllIIIlllII);
        for (final BlockPos lllllllllllllIllllIIIIllIIIllIIl : lllllllllllllIllllIIIIllIIIllIlI.getConnectedRails()) {
            final IBlockState lllllllllllllIllllIIIIllIIIllIII = lllllllllllllIllllIIIIllIIIllllI.getBlockState(lllllllllllllIllllIIIIllIIIllIIl);
            if (lllllllllllllIllllIIIIllIIIllIII != null) {
                lllllllllllllIllllIIIIllIIIllIII.neighborChanged(lllllllllllllIllllIIIIllIIIllllI, lllllllllllllIllllIIIIllIIIllIIl, lllllllllllllIllllIIIIllIIIllIII.getBlock(), lllllllllllllIllllIIIIllIIIlIlIl);
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
        final int[] $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = BlockRailDetector.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        if ($switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection != null) {
            return $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        }
        final int lllllllllllllIllllIIIIlIlIllIIIl = (Object)new int[EnumRailDirection.values().length];
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.EAST_WEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.NORTH_EAST.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.NORTH_SOUTH.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.NORTH_WEST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllllIllllIIIIlIlIllIIIl[EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        return BlockRailDetector.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = (int[])(Object)lllllllllllllIllllIIIIlIlIllIIIl;
    }
    
    protected <T extends EntityMinecart> List<T> findMinecarts(final World lllllllllllllIllllIIIIlIlllIIIIl, final BlockPos lllllllllllllIllllIIIIlIlllIIllI, final Class<T> lllllllllllllIllllIIIIlIllIlllll, final Predicate<Entity>... lllllllllllllIllllIIIIlIllIllllI) {
        final AxisAlignedBB lllllllllllllIllllIIIIlIlllIIIll = this.getDectectionBox(lllllllllllllIllllIIIIlIlllIIllI);
        return (lllllllllllllIllllIIIIlIllIllllI.length != 1) ? lllllllllllllIllllIIIIlIlllIIIIl.getEntitiesWithinAABB((Class<? extends T>)lllllllllllllIllllIIIIlIllIlllll, lllllllllllllIllllIIIIlIlllIIIll) : lllllllllllllIllllIIIIlIlllIIIIl.getEntitiesWithinAABB((Class<? extends T>)lllllllllllllIllllIIIIlIllIlllll, lllllllllllllIllllIIIIlIlllIIIll, (com.google.common.base.Predicate<? super T>)lllllllllllllIllllIIIIlIllIllllI[0]);
    }
    
    static {
        SHAPE = PropertyEnum.create("shape", EnumRailDirection.class, (com.google.common.base.Predicate<EnumRailDirection>)new Predicate<EnumRailDirection>() {
            public boolean apply(@Nullable final EnumRailDirection lllllllllllllIIllIlllIIIlllllIlI) {
                return lllllllllllllIIllIlllIIIlllllIlI != EnumRailDirection.NORTH_EAST && lllllllllllllIIllIlllIIIlllllIlI != EnumRailDirection.NORTH_WEST && lllllllllllllIIllIlllIIIlllllIlI != EnumRailDirection.SOUTH_EAST && lllllllllllllIIllIlllIIIlllllIlI != EnumRailDirection.SOUTH_WEST;
            }
        });
        POWERED = PropertyBool.create("powered");
    }
    
    @Override
    public IProperty<EnumRailDirection> getShapeProperty() {
        return BlockRailDetector.SHAPE;
    }
    
    private void updatePoweredState(final World lllllllllllllIllllIIIIllIIlIllIl, final BlockPos lllllllllllllIllllIIIIllIIllIIll, final IBlockState lllllllllllllIllllIIIIllIIlIlIll) {
        final boolean lllllllllllllIllllIIIIllIIllIIIl = lllllllllllllIllllIIIIllIIlIlIll.getValue((IProperty<Boolean>)BlockRailDetector.POWERED);
        boolean lllllllllllllIllllIIIIllIIllIIII = false;
        final List<EntityMinecart> lllllllllllllIllllIIIIllIIlIllll = this.findMinecarts(lllllllllllllIllllIIIIllIIlIllIl, lllllllllllllIllllIIIIllIIllIIll, EntityMinecart.class, (Predicate<Entity>[])new Predicate[0]);
        if (!lllllllllllllIllllIIIIllIIlIllll.isEmpty()) {
            lllllllllllllIllllIIIIllIIllIIII = true;
        }
        if (lllllllllllllIllllIIIIllIIllIIII && !lllllllllllllIllllIIIIllIIllIIIl) {
            lllllllllllllIllllIIIIllIIlIllIl.setBlockState(lllllllllllllIllllIIIIllIIllIIll, lllllllllllllIllllIIIIllIIlIlIll.withProperty((IProperty<Comparable>)BlockRailDetector.POWERED, true), 3);
            this.updateConnectedRails(lllllllllllllIllllIIIIllIIlIllIl, lllllllllllllIllllIIIIllIIllIIll, lllllllllllllIllllIIIIllIIlIlIll, true);
            lllllllllllllIllllIIIIllIIlIllIl.notifyNeighborsOfStateChange(lllllllllllllIllllIIIIllIIllIIll, this, false);
            lllllllllllllIllllIIIIllIIlIllIl.notifyNeighborsOfStateChange(lllllllllllllIllllIIIIllIIllIIll.down(), this, false);
            lllllllllllllIllllIIIIllIIlIllIl.markBlockRangeForRenderUpdate(lllllllllllllIllllIIIIllIIllIIll, lllllllllllllIllllIIIIllIIllIIll);
        }
        if (!lllllllllllllIllllIIIIllIIllIIII && lllllllllllllIllllIIIIllIIllIIIl) {
            lllllllllllllIllllIIIIllIIlIllIl.setBlockState(lllllllllllllIllllIIIIllIIllIIll, lllllllllllllIllllIIIIllIIlIlIll.withProperty((IProperty<Comparable>)BlockRailDetector.POWERED, false), 3);
            this.updateConnectedRails(lllllllllllllIllllIIIIllIIlIllIl, lllllllllllllIllllIIIIllIIllIIll, lllllllllllllIllllIIIIllIIlIlIll, false);
            lllllllllllllIllllIIIIllIIlIllIl.notifyNeighborsOfStateChange(lllllllllllllIllllIIIIllIIllIIll, this, false);
            lllllllllllllIllllIIIIllIIlIllIl.notifyNeighborsOfStateChange(lllllllllllllIllllIIIIllIIllIIll.down(), this, false);
            lllllllllllllIllllIIIIllIIlIllIl.markBlockRangeForRenderUpdate(lllllllllllllIllllIIIIllIIllIIll, lllllllllllllIllllIIIIllIIllIIll);
        }
        if (lllllllllllllIllllIIIIllIIllIIII) {
            lllllllllllllIllllIIIIllIIlIllIl.scheduleUpdate(new BlockPos(lllllllllllllIllllIIIIllIIllIIll), this, this.tickRate(lllllllllllllIllllIIIIllIIlIllIl));
        }
        lllllllllllllIllllIIIIllIIlIllIl.updateComparatorOutputLevel(lllllllllllllIllllIIIIllIIllIIll, this);
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllIllllIIIIllIlIIIllI, final IBlockAccess lllllllllllllIllllIIIIllIlIIlIIl, final BlockPos lllllllllllllIllllIIIIllIlIIlIII, final EnumFacing lllllllllllllIllllIIIIllIlIIIlll) {
        return lllllllllllllIllllIIIIllIlIIIllI.getValue((IProperty<Boolean>)BlockRailDetector.POWERED) ? 15 : 0;
    }
}
