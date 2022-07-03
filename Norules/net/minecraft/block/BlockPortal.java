package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.state.pattern.*;
import com.google.common.cache.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;

public class BlockPortal extends BlockBreakable
{
    protected static final /* synthetic */ AxisAlignedBB Z_AABB;
    protected static final /* synthetic */ AxisAlignedBB X_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    public static final /* synthetic */ PropertyEnum<EnumFacing.Axis> AXIS;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
    protected static final /* synthetic */ AxisAlignedBB Y_AABB;
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIllllIllIIIIIIIllIl, final IBlockAccess lllllllllllllIllllIllIIIIIIIllII, final BlockPos lllllllllllllIllllIllIIIIIIIlIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllIllllIllIIIIIIIllIl.getValue(BlockPortal.AXIS).ordinal()]) {
            case 1: {
                return BlockPortal.X_AABB;
            }
            default: {
                return BlockPortal.Y_AABB;
            }
            case 3: {
                return BlockPortal.Z_AABB;
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllllIlIlllIllIIllI) {
        return getMetaForAxis(lllllllllllllIllllIlIlllIllIIllI.getValue(BlockPortal.AXIS));
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIllllIlIlllIIlIlIlI, final IBlockState lllllllllllllIllllIlIlllIIlIlIIl, final BlockPos lllllllllllllIllllIlIlllIIlIlIII, final EnumFacing lllllllllllllIllllIlIlllIIlIIlll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    public BlockPortal() {
        super(Material.PORTAL, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockPortal.AXIS, EnumFacing.Axis.X));
        this.setTickRandomly(true);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIllllIlIlllIllIIIII, final Rotation lllllllllllllIllllIlIlllIllIIIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIllllIlIlllIllIIIIl.ordinal()]) {
            case 2:
            case 4: {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllIllllIlIlllIllIIIII.getValue(BlockPortal.AXIS).ordinal()]) {
                    case 1: {
                        return lllllllllllllIllllIlIlllIllIIIII.withProperty(BlockPortal.AXIS, EnumFacing.Axis.Z);
                    }
                    case 3: {
                        return lllllllllllllIllllIlIlllIllIIIII.withProperty(BlockPortal.AXIS, EnumFacing.Axis.X);
                    }
                    default: {
                        return lllllllllllllIllllIlIlllIllIIIII;
                    }
                }
                break;
            }
            default: {
                return lllllllllllllIllllIlIlllIllIIIII;
            }
        }
    }
    
    static {
        AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);
        X_AABB = new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.0, 0.625);
        Z_AABB = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.0, 1.0);
        Y_AABB = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPortal.AXIS });
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIllllIlIlllllIlIlIl, final World lllllllllllllIllllIlIlllllIIllII, final BlockPos lllllllllllllIllllIlIlllllIlIIll, final Block lllllllllllllIllllIlIlllllIlIIlI, final BlockPos lllllllllllllIllllIlIlllllIlIIIl) {
        final EnumFacing.Axis lllllllllllllIllllIlIlllllIlIIII = lllllllllllllIllllIlIlllllIlIlIl.getValue(BlockPortal.AXIS);
        if (lllllllllllllIllllIlIlllllIlIIII == EnumFacing.Axis.X) {
            final Size lllllllllllllIllllIlIlllllIIllll = new Size(lllllllllllllIllllIlIlllllIIllII, lllllllllllllIllllIlIlllllIlIIll, EnumFacing.Axis.X);
            if (!lllllllllllllIllllIlIlllllIIllll.isValid() || lllllllllllllIllllIlIlllllIIllll.portalBlockCount < lllllllllllllIllllIlIlllllIIllll.width * lllllllllllllIllllIlIlllllIIllll.height) {
                lllllllllllllIllllIlIlllllIIllII.setBlockState(lllllllllllllIllllIlIlllllIlIIll, Blocks.AIR.getDefaultState());
            }
        }
        else if (lllllllllllllIllllIlIlllllIlIIII == EnumFacing.Axis.Z) {
            final Size lllllllllllllIllllIlIlllllIIlllI = new Size(lllllllllllllIllllIlIlllllIIllII, lllllllllllllIllllIlIlllllIlIIll, EnumFacing.Axis.Z);
            if (!lllllllllllllIllllIlIlllllIIlllI.isValid() || lllllllllllllIllllIlIlllllIIlllI.portalBlockCount < lllllllllllllIllllIlIlllllIIlllI.width * lllllllllllllIllllIlIlllllIIlllI.height) {
                lllllllllllllIllllIlIlllllIIllII.setBlockState(lllllllllllllIllllIlIlllllIlIIll, Blocks.AIR.getDefaultState());
            }
        }
    }
    
    public boolean trySpawnPortal(final World lllllllllllllIllllIlIlllllIlllll, final BlockPos lllllllllllllIllllIlIllllllIIIlI) {
        final Size lllllllllllllIllllIlIllllllIIIIl = new Size(lllllllllllllIllllIlIlllllIlllll, lllllllllllllIllllIlIllllllIIIlI, EnumFacing.Axis.X);
        if (lllllllllllllIllllIlIllllllIIIIl.isValid() && lllllllllllllIllllIlIllllllIIIIl.portalBlockCount == 0) {
            lllllllllllllIllllIlIllllllIIIIl.placePortalBlocks();
            return true;
        }
        final Size lllllllllllllIllllIlIllllllIIIII = new Size(lllllllllllllIllllIlIlllllIlllll, lllllllllllllIllllIlIllllllIIIlI, EnumFacing.Axis.Z);
        if (lllllllllllllIllllIlIllllllIIIII.isValid() && lllllllllllllIllllIlIllllllIIIII.portalBlockCount == 0) {
            lllllllllllllIllllIlIllllllIIIII.placePortalBlocks();
            return true;
        }
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllIllllIlIlllllllIIII, final IBlockAccess lllllllllllllIllllIlIllllllIllll, final BlockPos lllllllllllllIllllIlIllllllIlllI) {
        return BlockPortal.NULL_AABB;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = BlockPortal.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final int lllllllllllllIllllIlIlllIIlIIlIl = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllllIllllIlIlllIIlIIlIl[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIlIlllIIlIIlIl[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIlIlllIIlIIlIl[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockPortal.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllllIllllIlIlllIIlIIlIl;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllllIlIlllIllIllII) {
        return this.getDefaultState().withProperty(BlockPortal.AXIS, ((lllllllllllllIllllIlIlllIllIllII & 0x3) == 0x2) ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
    }
    
    public static int getMetaForAxis(final EnumFacing.Axis lllllllllllllIllllIlIllllllIlIll) {
        if (lllllllllllllIllllIlIllllllIlIll == EnumFacing.Axis.X) {
            return 1;
        }
        return (lllllllllllllIllllIlIllllllIlIll == EnumFacing.Axis.Z) ? 2 : 0;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIllllIlIllllllIlIIl) {
        return false;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllIllllIlIllllIIIlIll, final World lllllllllllllIllllIlIlllIlllllIl, final BlockPos lllllllllllllIllllIlIllllIIIlIIl, final Random lllllllllllllIllllIlIllllIIIlIII) {
        if (lllllllllllllIllllIlIllllIIIlIII.nextInt(100) == 0) {
            lllllllllllllIllllIlIlllIlllllIl.playSound(lllllllllllllIllllIlIllllIIIlIIl.getX() + 0.5, lllllllllllllIllllIlIllllIIIlIIl.getY() + 0.5, lllllllllllllIllllIlIllllIIIlIIl.getZ() + 0.5, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5f, lllllllllllllIllllIlIllllIIIlIII.nextFloat() * 0.4f + 0.8f, false);
        }
        for (int lllllllllllllIllllIlIllllIIIIlll = 0; lllllllllllllIllllIlIllllIIIIlll < 4; ++lllllllllllllIllllIlIllllIIIIlll) {
            double lllllllllllllIllllIlIllllIIIIllI = lllllllllllllIllllIlIllllIIIlIIl.getX() + lllllllllllllIllllIlIllllIIIlIII.nextFloat();
            final double lllllllllllllIllllIlIllllIIIIlIl = lllllllllllllIllllIlIllllIIIlIIl.getY() + lllllllllllllIllllIlIllllIIIlIII.nextFloat();
            double lllllllllllllIllllIlIllllIIIIlII = lllllllllllllIllllIlIllllIIIlIIl.getZ() + lllllllllllllIllllIlIllllIIIlIII.nextFloat();
            double lllllllllllllIllllIlIllllIIIIIll = (lllllllllllllIllllIlIllllIIIlIII.nextFloat() - 0.5) * 0.5;
            final double lllllllllllllIllllIlIllllIIIIIlI = (lllllllllllllIllllIlIllllIIIlIII.nextFloat() - 0.5) * 0.5;
            double lllllllllllllIllllIlIllllIIIIIIl = (lllllllllllllIllllIlIllllIIIlIII.nextFloat() - 0.5) * 0.5;
            final int lllllllllllllIllllIlIllllIIIIIII = lllllllllllllIllllIlIllllIIIlIII.nextInt(2) * 2 - 1;
            if (lllllllllllllIllllIlIlllIlllllIl.getBlockState(lllllllllllllIllllIlIllllIIIlIIl.west()).getBlock() != this && lllllllllllllIllllIlIlllIlllllIl.getBlockState(lllllllllllllIllllIlIllllIIIlIIl.east()).getBlock() != this) {
                lllllllllllllIllllIlIllllIIIIllI = lllllllllllllIllllIlIllllIIIlIIl.getX() + 0.5 + 0.25 * lllllllllllllIllllIlIllllIIIIIII;
                lllllllllllllIllllIlIllllIIIIIll = lllllllllllllIllllIlIllllIIIlIII.nextFloat() * 2.0f * lllllllllllllIllllIlIllllIIIIIII;
            }
            else {
                lllllllllllllIllllIlIllllIIIIlII = lllllllllllllIllllIlIllllIIIlIIl.getZ() + 0.5 + 0.25 * lllllllllllllIllllIlIllllIIIIIII;
                lllllllllllllIllllIlIllllIIIIIIl = lllllllllllllIllllIlIllllIIIlIII.nextFloat() * 2.0f * lllllllllllllIllllIlIllllIIIIIII;
            }
            lllllllllllllIllllIlIlllIlllllIl.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllllIllllIlIllllIIIIllI, lllllllllllllIllllIlIllllIIIIlIl, lllllllllllllIllllIlIllllIIIIlII, lllllllllllllIllllIlIllllIIIIIll, lllllllllllllIllllIlIllllIIIIIlI, lllllllllllllIllllIlIllllIIIIIIl, new int[0]);
        }
    }
    
    public BlockPattern.PatternHelper createPatternHelper(final World lllllllllllllIllllIlIlllIIlllIll, final BlockPos lllllllllllllIllllIlIlllIIlllIlI) {
        EnumFacing.Axis lllllllllllllIllllIlIlllIlIIlIII = EnumFacing.Axis.Z;
        Size lllllllllllllIllllIlIlllIlIIIlll = new Size(lllllllllllllIllllIlIlllIIlllIll, lllllllllllllIllllIlIlllIIlllIlI, EnumFacing.Axis.X);
        final LoadingCache<BlockPos, BlockWorldState> lllllllllllllIllllIlIlllIlIIIllI = BlockPattern.createLoadingCache(lllllllllllllIllllIlIlllIIlllIll, true);
        if (!lllllllllllllIllllIlIlllIlIIIlll.isValid()) {
            lllllllllllllIllllIlIlllIlIIlIII = EnumFacing.Axis.X;
            lllllllllllllIllllIlIlllIlIIIlll = new Size(lllllllllllllIllllIlIlllIIlllIll, lllllllllllllIllllIlIlllIIlllIlI, EnumFacing.Axis.Z);
        }
        if (!lllllllllllllIllllIlIlllIlIIIlll.isValid()) {
            return new BlockPattern.PatternHelper(lllllllllllllIllllIlIlllIIlllIlI, EnumFacing.NORTH, EnumFacing.UP, lllllllllllllIllllIlIlllIlIIIllI, 1, 1, 1);
        }
        final int[] lllllllllllllIllllIlIlllIlIIIlIl = new int[EnumFacing.AxisDirection.values().length];
        final EnumFacing lllllllllllllIllllIlIlllIlIIIlII = lllllllllllllIllllIlIlllIlIIIlll.rightDir.rotateYCCW();
        final BlockPos lllllllllllllIllllIlIlllIlIIIIll = lllllllllllllIllllIlIlllIlIIIlll.bottomLeft.up(lllllllllllllIllllIlIlllIlIIIlll.getHeight() - 1);
        double lllllllllllllIllllIlIlllIIllIIII;
        boolean lllllllllllllIllllIlIlllIIllIIIl = ((EnumFacing.AxisDirection[])(Object)(lllllllllllllIllllIlIlllIIllIIII = (double)(Object)EnumFacing.AxisDirection.values())).length != 0;
        for (final EnumFacing.AxisDirection lllllllllllllIllllIlIlllIlIIIIlI : lllllllllllllIllllIlIlllIIllIIII) {
            final BlockPattern.PatternHelper lllllllllllllIllllIlIlllIlIIIIIl = new BlockPattern.PatternHelper((lllllllllllllIllllIlIlllIlIIIlII.getAxisDirection() == lllllllllllllIllllIlIlllIlIIIIlI) ? lllllllllllllIllllIlIlllIlIIIIll : lllllllllllllIllllIlIlllIlIIIIll.offset(lllllllllllllIllllIlIlllIlIIIlll.rightDir, lllllllllllllIllllIlIlllIlIIIlll.getWidth() - 1), EnumFacing.getFacingFromAxis(lllllllllllllIllllIlIlllIlIIIIlI, lllllllllllllIllllIlIlllIlIIlIII), EnumFacing.UP, lllllllllllllIllllIlIlllIlIIIllI, lllllllllllllIllllIlIlllIlIIIlll.getWidth(), lllllllllllllIllllIlIlllIlIIIlll.getHeight(), 1);
            for (int lllllllllllllIllllIlIlllIlIIIIII = 0; lllllllllllllIllllIlIlllIlIIIIII < lllllllllllllIllllIlIlllIlIIIlll.getWidth(); ++lllllllllllllIllllIlIlllIlIIIIII) {
                for (int lllllllllllllIllllIlIlllIIllllll = 0; lllllllllllllIllllIlIlllIIllllll < lllllllllllllIllllIlIlllIlIIIlll.getHeight(); ++lllllllllllllIllllIlIlllIIllllll) {
                    final BlockWorldState lllllllllllllIllllIlIlllIIlllllI = lllllllllllllIllllIlIlllIlIIIIIl.translateOffset(lllllllllllllIllllIlIlllIlIIIIII, lllllllllllllIllllIlIlllIIllllll, 1);
                    if (lllllllllllllIllllIlIlllIIlllllI.getBlockState() != null && lllllllllllllIllllIlIlllIIlllllI.getBlockState().getMaterial() != Material.AIR) {
                        final int[] array = lllllllllllllIllllIlIlllIlIIIlIl;
                        final int ordinal = lllllllllllllIllllIlIlllIlIIIIlI.ordinal();
                        ++array[ordinal];
                    }
                }
            }
        }
        EnumFacing.AxisDirection lllllllllllllIllllIlIlllIIllllIl = EnumFacing.AxisDirection.POSITIVE;
        Exception lllllllllllllIllllIlIlllIIlIllll;
        EnumFacing.AxisDirection lllllllllllllIllllIlIlllIIllllII;
        for (lllllllllllllIllllIlIlllIIllIIII = ((EnumFacing.AxisDirection[])(Object)(lllllllllllllIllllIlIlllIIlIllll = (Exception)(Object)EnumFacing.AxisDirection.values())).length, lllllllllllllIllllIlIlllIIllIIIl = (0 != 0); (lllllllllllllIllllIlIlllIIllIIIl ? 1 : 0) < lllllllllllllIllllIlIlllIIllIIII; ++lllllllllllllIllllIlIlllIIllIIIl) {
            lllllllllllllIllllIlIlllIIllllII = lllllllllllllIllllIlIlllIIlIllll[lllllllllllllIllllIlIlllIIllIIIl];
            if (lllllllllllllIllllIlIlllIlIIIlIl[lllllllllllllIllllIlIlllIIllllII.ordinal()] < lllllllllllllIllllIlIlllIlIIIlIl[lllllllllllllIllllIlIlllIIllllIl.ordinal()]) {
                lllllllllllllIllllIlIlllIIllllIl = lllllllllllllIllllIlIlllIIllllII;
            }
        }
        return new BlockPattern.PatternHelper((lllllllllllllIllllIlIlllIlIIIlII.getAxisDirection() == lllllllllllllIllllIlIlllIIllllIl) ? lllllllllllllIllllIlIlllIlIIIIll : lllllllllllllIllllIlIlllIlIIIIll.offset(lllllllllllllIllllIlIlllIlIIIlll.rightDir, lllllllllllllIllllIlIlllIlIIIlll.getWidth() - 1), EnumFacing.getFacingFromAxis(lllllllllllllIllllIlIlllIIllllIl, lllllllllllllIllllIlIlllIlIIlIII), EnumFacing.UP, lllllllllllllIllllIlIlllIlIIIllI, lllllllllllllIllllIlIlllIlIIIlll.getWidth(), lllllllllllllIllllIlIlllIlIIIlll.getHeight(), 1);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIllllIlIlllIlllIIlI, final BlockPos lllllllllllllIllllIlIlllIlllIIIl, final IBlockState lllllllllllllIllllIlIlllIlllIIII) {
        return ItemStack.field_190927_a;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockPortal.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final long lllllllllllllIllllIlIlllIIlIIIll = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIllllIlIlllIIlIIIll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIlIlllIIlIIIll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIlIlllIIlIIIll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIlIlllIIlIIIll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockPortal.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIllllIlIlllIIlIIIll;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIllllIlIllllIlIIIll) {
        return 0;
    }
    
    @Override
    public void updateTick(final World lllllllllllllIllllIllIIIIIIIIIII, final BlockPos lllllllllllllIllllIlIlllllllIlll, final IBlockState lllllllllllllIllllIlIllllllllllI, final Random lllllllllllllIllllIlIlllllllllIl) {
        super.updateTick(lllllllllllllIllllIllIIIIIIIIIII, lllllllllllllIllllIlIlllllllIlll, lllllllllllllIllllIlIllllllllllI, lllllllllllllIllllIlIlllllllllIl);
        if (lllllllllllllIllllIllIIIIIIIIIII.provider.isSurfaceWorld() && lllllllllllllIllllIllIIIIIIIIIII.getGameRules().getBoolean("doMobSpawning") && lllllllllllllIllllIlIlllllllllIl.nextInt(2000) < lllllllllllllIllllIllIIIIIIIIIII.getDifficulty().getDifficultyId()) {
            final int lllllllllllllIllllIlIlllllllllII = lllllllllllllIllllIlIlllllllIlll.getY();
            BlockPos lllllllllllllIllllIlIllllllllIll;
            for (lllllllllllllIllllIlIllllllllIll = lllllllllllllIllllIlIlllllllIlll; !lllllllllllllIllllIllIIIIIIIIIII.getBlockState(lllllllllllllIllllIlIllllllllIll).isFullyOpaque() && lllllllllllllIllllIlIllllllllIll.getY() > 0; lllllllllllllIllllIlIllllllllIll = lllllllllllllIllllIlIllllllllIll.down()) {}
            if (lllllllllllllIllllIlIlllllllllII > 0 && !lllllllllllllIllllIllIIIIIIIIIII.getBlockState(lllllllllllllIllllIlIllllllllIll.up()).isNormalCube()) {
                final Entity lllllllllllllIllllIlIllllllllIlI = ItemMonsterPlacer.spawnCreature(lllllllllllllIllllIllIIIIIIIIIII, EntityList.func_191306_a(EntityPigZombie.class), lllllllllllllIllllIlIllllllllIll.getX() + 0.5, lllllllllllllIllllIlIllllllllIll.getY() + 1.1, lllllllllllllIllllIlIllllllllIll.getZ() + 0.5);
                if (lllllllllllllIllllIlIllllllllIlI != null) {
                    lllllllllllllIllllIlIllllllllIlI.timeUntilPortal = lllllllllllllIllllIlIllllllllIlI.getPortalCooldown();
                }
            }
        }
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllIllllIlIllllIIllllI, final BlockPos lllllllllllllIllllIlIllllIIllIlI, final IBlockState lllllllllllllIllllIlIllllIIlllII, final Entity lllllllllllllIllllIlIllllIIllIll) {
        if (!lllllllllllllIllllIlIllllIIllIll.isRiding() && !lllllllllllllIllllIlIllllIIllIll.isBeingRidden() && lllllllllllllIllllIlIllllIIllIll.isNonBoss()) {
            lllllllllllllIllllIlIllllIIllIll.setPortal(lllllllllllllIllllIlIllllIIllIlI);
        }
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllIllllIlIllllIlIllll, final IBlockAccess lllllllllllllIllllIlIllllIlIlllI, BlockPos lllllllllllllIllllIlIllllIlIllIl, final EnumFacing lllllllllllllIllllIlIllllIlIllII) {
        lllllllllllllIllllIlIllllIlIllIl = lllllllllllllIllllIlIllllIlIllIl.offset(lllllllllllllIllllIlIllllIlIllII);
        EnumFacing.Axis lllllllllllllIllllIlIllllIllIlll = null;
        if (lllllllllllllIllllIlIllllIlIllll.getBlock() == this) {
            lllllllllllllIllllIlIllllIllIlll = lllllllllllllIllllIlIllllIlIllll.getValue(BlockPortal.AXIS);
            if (lllllllllllllIllllIlIllllIllIlll == null) {
                return false;
            }
            if (lllllllllllllIllllIlIllllIllIlll == EnumFacing.Axis.Z && lllllllllllllIllllIlIllllIlIllII != EnumFacing.EAST && lllllllllllllIllllIlIllllIlIllII != EnumFacing.WEST) {
                return false;
            }
            if (lllllllllllllIllllIlIllllIllIlll == EnumFacing.Axis.X && lllllllllllllIllllIlIllllIlIllII != EnumFacing.SOUTH && lllllllllllllIllllIlIllllIlIllII != EnumFacing.NORTH) {
                return false;
            }
        }
        final boolean lllllllllllllIllllIlIllllIllIllI = lllllllllllllIllllIlIllllIlIlllI.getBlockState(lllllllllllllIllllIlIllllIlIllIl.west()).getBlock() == this && lllllllllllllIllllIlIllllIlIlllI.getBlockState(lllllllllllllIllllIlIllllIlIllIl.west(2)).getBlock() != this;
        final boolean lllllllllllllIllllIlIllllIllIlIl = lllllllllllllIllllIlIllllIlIlllI.getBlockState(lllllllllllllIllllIlIllllIlIllIl.east()).getBlock() == this && lllllllllllllIllllIlIllllIlIlllI.getBlockState(lllllllllllllIllllIlIllllIlIllIl.east(2)).getBlock() != this;
        final boolean lllllllllllllIllllIlIllllIllIlII = lllllllllllllIllllIlIllllIlIlllI.getBlockState(lllllllllllllIllllIlIllllIlIllIl.north()).getBlock() == this && lllllllllllllIllllIlIllllIlIlllI.getBlockState(lllllllllllllIllllIlIllllIlIllIl.north(2)).getBlock() != this;
        final boolean lllllllllllllIllllIlIllllIllIIll = lllllllllllllIllllIlIllllIlIlllI.getBlockState(lllllllllllllIllllIlIllllIlIllIl.south()).getBlock() == this && lllllllllllllIllllIlIllllIlIlllI.getBlockState(lllllllllllllIllllIlIllllIlIllIl.south(2)).getBlock() != this;
        final boolean lllllllllllllIllllIlIllllIllIIlI = lllllllllllllIllllIlIllllIllIllI || lllllllllllllIllllIlIllllIllIlIl || lllllllllllllIllllIlIllllIllIlll == EnumFacing.Axis.X;
        final boolean lllllllllllllIllllIlIllllIllIIIl = lllllllllllllIllllIlIllllIllIlII || lllllllllllllIllllIlIllllIllIIll || lllllllllllllIllllIlIllllIllIlll == EnumFacing.Axis.Z;
        return (lllllllllllllIllllIlIllllIllIIlI && lllllllllllllIllllIlIllllIlIllII == EnumFacing.WEST) || (lllllllllllllIllllIlIllllIllIIlI && lllllllllllllIllllIlIllllIlIllII == EnumFacing.EAST) || (lllllllllllllIllllIlIllllIllIIIl && lllllllllllllIllllIlIllllIlIllII == EnumFacing.NORTH) || (lllllllllllllIllllIlIllllIllIIIl && lllllllllllllIllllIlIllllIlIllII == EnumFacing.SOUTH);
    }
    
    public static class Size
    {
        private /* synthetic */ BlockPos bottomLeft;
        private final /* synthetic */ EnumFacing leftDir;
        private /* synthetic */ int height;
        private /* synthetic */ int width;
        private /* synthetic */ int portalBlockCount;
        private final /* synthetic */ EnumFacing.Axis axis;
        private final /* synthetic */ EnumFacing rightDir;
        private final /* synthetic */ World world;
        
        protected int calculatePortalHeight() {
            this.height = 0;
        Label_0181:
            while (this.height < 21) {
                for (int lllllllllllllllIIllllllllIIllIll = 0; lllllllllllllllIIllllllllIIllIll < this.width; ++lllllllllllllllIIllllllllIIllIll) {
                    final BlockPos lllllllllllllllIIllllllllIIllIlI = this.bottomLeft.offset(this.rightDir, lllllllllllllllIIllllllllIIllIll).up(this.height);
                    Block lllllllllllllllIIllllllllIIllIIl = this.world.getBlockState(lllllllllllllllIIllllllllIIllIlI).getBlock();
                    if (!this.isEmptyBlock(lllllllllllllllIIllllllllIIllIIl)) {
                        break Label_0181;
                    }
                    if (lllllllllllllllIIllllllllIIllIIl == Blocks.PORTAL) {
                        ++this.portalBlockCount;
                    }
                    if (lllllllllllllllIIllllllllIIllIll == 0) {
                        lllllllllllllllIIllllllllIIllIIl = this.world.getBlockState(lllllllllllllllIIllllllllIIllIlI.offset(this.leftDir)).getBlock();
                        if (lllllllllllllllIIllllllllIIllIIl != Blocks.OBSIDIAN) {
                            break Label_0181;
                        }
                    }
                    else if (lllllllllllllllIIllllllllIIllIll == this.width - 1) {
                        lllllllllllllllIIllllllllIIllIIl = this.world.getBlockState(lllllllllllllllIIllllllllIIllIlI.offset(this.rightDir)).getBlock();
                        if (lllllllllllllllIIllllllllIIllIIl != Blocks.OBSIDIAN) {
                            break Label_0181;
                        }
                    }
                }
                ++this.height;
            }
            for (int lllllllllllllllIIllllllllIIllIII = 0; lllllllllllllllIIllllllllIIllIII < this.width; ++lllllllllllllllIIllllllllIIllIII) {
                if (this.world.getBlockState(this.bottomLeft.offset(this.rightDir, lllllllllllllllIIllllllllIIllIII).up(this.height)).getBlock() != Blocks.OBSIDIAN) {
                    this.height = 0;
                    break;
                }
            }
            if (this.height <= 21 && this.height >= 3) {
                return this.height;
            }
            this.bottomLeft = null;
            this.width = 0;
            this.height = 0;
            return 0;
        }
        
        protected boolean isEmptyBlock(final Block lllllllllllllllIIllllllllIIlIIII) {
            return lllllllllllllllIIllllllllIIlIIII.blockMaterial == Material.AIR || lllllllllllllllIIllllllllIIlIIII == Blocks.FIRE || lllllllllllllllIIllllllllIIlIIII == Blocks.PORTAL;
        }
        
        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public int getWidth() {
            return this.width;
        }
        
        public Size(final World lllllllllllllllIIllllllllIlllIlI, BlockPos lllllllllllllllIIllllllllIlllIIl, final EnumFacing.Axis lllllllllllllllIIllllllllIlllllI) {
            this.world = lllllllllllllllIIllllllllIlllIlI;
            this.axis = lllllllllllllllIIllllllllIlllllI;
            if (lllllllllllllllIIllllllllIlllllI == EnumFacing.Axis.X) {
                this.leftDir = EnumFacing.EAST;
                this.rightDir = EnumFacing.WEST;
            }
            else {
                this.leftDir = EnumFacing.NORTH;
                this.rightDir = EnumFacing.SOUTH;
            }
            for (BlockPos lllllllllllllllIIllllllllIllllIl = (BlockPos)lllllllllllllllIIllllllllIlllIIl; ((Vec3i)lllllllllllllllIIllllllllIlllIIl).getY() > lllllllllllllllIIllllllllIllllIl.getY() - 21 && ((Vec3i)lllllllllllllllIIllllllllIlllIIl).getY() > 0 && this.isEmptyBlock(lllllllllllllllIIllllllllIlllIlI.getBlockState(((BlockPos)lllllllllllllllIIllllllllIlllIIl).down()).getBlock()); lllllllllllllllIIllllllllIlllIIl = ((BlockPos)lllllllllllllllIIllllllllIlllIIl).down()) {}
            final int lllllllllllllllIIllllllllIllllII = this.getDistanceUntilEdge((BlockPos)lllllllllllllllIIllllllllIlllIIl, this.leftDir) - 1;
            if (lllllllllllllllIIllllllllIllllII >= 0) {
                this.bottomLeft = ((BlockPos)lllllllllllllllIIllllllllIlllIIl).offset(this.leftDir, lllllllllllllllIIllllllllIllllII);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
                if (this.width < 2 || this.width > 21) {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }
            if (this.bottomLeft != null) {
                this.height = this.calculatePortalHeight();
            }
        }
        
        public void placePortalBlocks() {
            for (int lllllllllllllllIIllllllllIIIIlll = 0; lllllllllllllllIIllllllllIIIIlll < this.width; ++lllllllllllllllIIllllllllIIIIlll) {
                final BlockPos lllllllllllllllIIllllllllIIIIllI = this.bottomLeft.offset(this.rightDir, lllllllllllllllIIllllllllIIIIlll);
                for (int lllllllllllllllIIllllllllIIIIlIl = 0; lllllllllllllllIIllllllllIIIIlIl < this.height; ++lllllllllllllllIIllllllllIIIIlIl) {
                    this.world.setBlockState(lllllllllllllllIIllllllllIIIIllI.up(lllllllllllllllIIllllllllIIIIlIl), Blocks.PORTAL.getDefaultState().withProperty(BlockPortal.AXIS, this.axis), 2);
                }
            }
        }
        
        protected int getDistanceUntilEdge(final BlockPos lllllllllllllllIIllllllllIlIlIlI, final EnumFacing lllllllllllllllIIllllllllIlIllll) {
            int lllllllllllllllIIllllllllIlIlllI;
            for (lllllllllllllllIIllllllllIlIlllI = 0; lllllllllllllllIIllllllllIlIlllI < 22; ++lllllllllllllllIIllllllllIlIlllI) {
                final BlockPos lllllllllllllllIIllllllllIlIllIl = lllllllllllllllIIllllllllIlIlIlI.offset(lllllllllllllllIIllllllllIlIllll, lllllllllllllllIIllllllllIlIlllI);
                if (!this.isEmptyBlock(this.world.getBlockState(lllllllllllllllIIllllllllIlIllIl).getBlock())) {
                    break;
                }
                if (this.world.getBlockState(lllllllllllllllIIllllllllIlIllIl.down()).getBlock() != Blocks.OBSIDIAN) {
                    break;
                }
            }
            final Block lllllllllllllllIIllllllllIlIllII = this.world.getBlockState(lllllllllllllllIIllllllllIlIlIlI.offset(lllllllllllllllIIllllllllIlIllll, lllllllllllllllIIllllllllIlIlllI)).getBlock();
            return (lllllllllllllllIIllllllllIlIllII == Blocks.OBSIDIAN) ? lllllllllllllllIIllllllllIlIlllI : 0;
        }
    }
}
