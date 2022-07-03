package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import javax.annotation.*;
import net.minecraft.init.*;
import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockTripWireHook extends Block
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    protected static final /* synthetic */ AxisAlignedBB HOOK_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB HOOK_SOUTH_AABB;
    public static final /* synthetic */ PropertyBool POWERED;
    public static final /* synthetic */ PropertyDirection FACING;
    public static final /* synthetic */ PropertyBool ATTACHED;
    protected static final /* synthetic */ AxisAlignedBB HOOK_WEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB HOOK_EAST_AABB;
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllllllIIlIllIIlIlIl, final BlockPos lllllllllllllllllllIIlIllIIlIlII, final EnumFacing lllllllllllllllllllIIlIllIIlIIll, final float lllllllllllllllllllIIlIllIIlIIlI, final float lllllllllllllllllllIIlIllIIlIIIl, final float lllllllllllllllllllIIlIllIIlIIII, final int lllllllllllllllllllIIlIllIIIllll, final EntityLivingBase lllllllllllllllllllIIlIllIIIlllI) {
        IBlockState lllllllllllllllllllIIlIllIIIllIl = this.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.POWERED, false).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, false);
        if (lllllllllllllllllllIIlIllIIlIIll.getAxis().isHorizontal()) {
            lllllllllllllllllllIIlIllIIIllIl = lllllllllllllllllllIIlIllIIIllIl.withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, lllllllllllllllllllIIlIllIIlIIll);
        }
        return lllllllllllllllllllIIlIllIIIllIl;
    }
    
    private boolean checkForDrop(final World lllllllllllllllllllIIlIIlllIllII, final BlockPos lllllllllllllllllllIIlIIlllIlIll, final IBlockState lllllllllllllllllllIIlIIlllIlIlI) {
        if (!this.canPlaceBlockAt(lllllllllllllllllllIIlIIlllIllII, lllllllllllllllllllIIlIIlllIlIll)) {
            this.dropBlockAsItem(lllllllllllllllllllIIlIIlllIllII, lllllllllllllllllllIIlIIlllIlIll, lllllllllllllllllllIIlIIlllIlIlI, 0);
            lllllllllllllllllllIIlIIlllIllII.setBlockToAir(lllllllllllllllllllIIlIIlllIlIll);
            return false;
        }
        return true;
    }
    
    private void playSound(final World lllllllllllllllllllIIlIlIIIIllIl, final BlockPos lllllllllllllllllllIIlIlIIIIIllI, final boolean lllllllllllllllllllIIlIlIIIIIlIl, final boolean lllllllllllllllllllIIlIlIIIIlIlI, final boolean lllllllllllllllllllIIlIlIIIIIIll, final boolean lllllllllllllllllllIIlIlIIIIIIlI) {
        if (lllllllllllllllllllIIlIlIIIIlIlI && !lllllllllllllllllllIIlIlIIIIIIlI) {
            lllllllllllllllllllIIlIlIIIIllIl.playSound(null, lllllllllllllllllllIIlIlIIIIIllI, SoundEvents.BLOCK_TRIPWIRE_CLICK_ON, SoundCategory.BLOCKS, 0.4f, 0.6f);
        }
        else if (!lllllllllllllllllllIIlIlIIIIlIlI && lllllllllllllllllllIIlIlIIIIIIlI) {
            lllllllllllllllllllIIlIlIIIIllIl.playSound(null, lllllllllllllllllllIIlIlIIIIIllI, SoundEvents.BLOCK_TRIPWIRE_CLICK_OFF, SoundCategory.BLOCKS, 0.4f, 0.5f);
        }
        else if (lllllllllllllllllllIIlIlIIIIIlIl && !lllllllllllllllllllIIlIlIIIIIIll) {
            lllllllllllllllllllIIlIlIIIIllIl.playSound(null, lllllllllllllllllllIIlIlIIIIIllI, SoundEvents.BLOCK_TRIPWIRE_ATTACH, SoundCategory.BLOCKS, 0.4f, 0.7f);
        }
        else if (!lllllllllllllllllllIIlIlIIIIIlIl && lllllllllllllllllllIIlIlIIIIIIll) {
            lllllllllllllllllllIIlIlIIIIllIl.playSound(null, lllllllllllllllllllIIlIlIIIIIllI, SoundEvents.BLOCK_TRIPWIRE_DETACH, SoundCategory.BLOCKS, 0.4f, 1.2f / (lllllllllllllllllllIIlIlIIIIllIl.rand.nextFloat() * 0.2f + 0.9f));
        }
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllllllIIlIIlllIIIlI, final BlockPos lllllllllllllllllllIIlIIllIllIll, final IBlockState lllllllllllllllllllIIlIIlllIIIII) {
        final boolean lllllllllllllllllllIIlIIllIlllll = lllllllllllllllllllIIlIIlllIIIII.getValue((IProperty<Boolean>)BlockTripWireHook.ATTACHED);
        final boolean lllllllllllllllllllIIlIIllIllllI = lllllllllllllllllllIIlIIlllIIIII.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED);
        if (lllllllllllllllllllIIlIIllIlllll || lllllllllllllllllllIIlIIllIllllI) {
            this.calculateState(lllllllllllllllllllIIlIIlllIIIlI, lllllllllllllllllllIIlIIllIllIll, lllllllllllllllllllIIlIIlllIIIII, true, false, -1, null);
        }
        if (lllllllllllllllllllIIlIIllIllllI) {
            lllllllllllllllllllIIlIIlllIIIlI.notifyNeighborsOfStateChange(lllllllllllllllllllIIlIIllIllIll, this, false);
            lllllllllllllllllllIIlIIlllIIIlI.notifyNeighborsOfStateChange(lllllllllllllllllllIIlIIllIllIll.offset(lllllllllllllllllllIIlIIlllIIIII.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING).getOpposite()), this, false);
        }
        super.breakBlock(lllllllllllllllllllIIlIIlllIIIlI, lllllllllllllllllllIIlIIllIllIll, lllllllllllllllllllIIlIIlllIIIII);
    }
    
    @Override
    public void updateTick(final World lllllllllllllllllllIIlIlIIIlllII, final BlockPos lllllllllllllllllllIIlIlIIIllIll, final IBlockState lllllllllllllllllllIIlIlIIIllIlI, final Random lllllllllllllllllllIIlIlIIIllIIl) {
        this.calculateState(lllllllllllllllllllIIlIlIIIlllII, lllllllllllllllllllIIlIlIIIllIll, lllllllllllllllllllIIlIlIIIllIlI, false, true, -1, null);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllllllIIlIlllIIIlll, final IBlockAccess lllllllllllllllllllIIlIlllIIlIlI, final BlockPos lllllllllllllllllllIIlIlllIIlIII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllllllllIIlIlllIIIlll.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING).ordinal()]) {
            default: {
                return BlockTripWireHook.HOOK_EAST_AABB;
            }
            case 5: {
                return BlockTripWireHook.HOOK_WEST_AABB;
            }
            case 4: {
                return BlockTripWireHook.HOOK_SOUTH_AABB;
            }
            case 3: {
                return BlockTripWireHook.HOOK_NORTH_AABB;
            }
        }
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllllllIIlIllIIlllIl, final BlockPos lllllllllllllllllllIIlIllIIlllII) {
        for (final EnumFacing lllllllllllllllllllIIlIllIIlllll : EnumFacing.Plane.HORIZONTAL) {
            if (this.canPlaceBlockOnSide(lllllllllllllllllllIIlIllIIlllIl, lllllllllllllllllllIIlIllIIlllII, lllllllllllllllllllIIlIllIIlllll)) {
                return true;
            }
        }
        return false;
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        POWERED = PropertyBool.create("powered");
        ATTACHED = PropertyBool.create("attached");
        HOOK_NORTH_AABB = new AxisAlignedBB(0.3125, 0.0, 0.625, 0.6875, 0.625, 1.0);
        HOOK_SOUTH_AABB = new AxisAlignedBB(0.3125, 0.0, 0.0, 0.6875, 0.625, 0.375);
        HOOK_WEST_AABB = new AxisAlignedBB(0.625, 0.0, 0.3125, 1.0, 0.625, 0.6875);
        HOOK_EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.3125, 0.375, 0.625, 0.6875);
    }
    
    public BlockTripWireHook() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockTripWireHook.POWERED, false).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setTickRandomly(true);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockTripWireHook.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short lllllllllllllllllllIIlIIlIlIIIII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllllllllIIlIIlIlIIIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllllIIlIIlIlIIIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllllIIlIIlIlIIIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllllIIlIIlIlIIIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllllllIIlIIlIlIIIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllllllIIlIIlIlIIIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockTripWireHook.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllllllllIIlIIlIlIIIII;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllllllIIlIlIllIllIl, final World lllllllllllllllllllIIlIlIllIllII, final BlockPos lllllllllllllllllllIIlIlIllIlIll, final Block lllllllllllllllllllIIlIlIllIlIlI, final BlockPos lllllllllllllllllllIIlIlIlllIIII) {
        if (lllllllllllllllllllIIlIlIllIlIlI != this && this.checkForDrop(lllllllllllllllllllIIlIlIllIllII, lllllllllllllllllllIIlIlIllIlIll, lllllllllllllllllllIIlIlIllIllIl)) {
            final EnumFacing lllllllllllllllllllIIlIlIllIllll = lllllllllllllllllllIIlIlIllIllIl.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING);
            if (!this.canPlaceBlockOnSide(lllllllllllllllllllIIlIlIllIllII, lllllllllllllllllllIIlIlIllIlIll, lllllllllllllllllllIIlIlIllIllll)) {
                this.dropBlockAsItem(lllllllllllllllllllIIlIlIllIllII, lllllllllllllllllllIIlIlIllIlIll, lllllllllllllllllllIIlIlIllIllIl, 0);
                lllllllllllllllllllIIlIlIllIllII.setBlockToAir(lllllllllllllllllllIIlIlIllIlIll);
            }
        }
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllllllIIlIIlIllIlII, final Rotation lllllllllllllllllllIIlIIlIllIIIl) {
        return lllllllllllllllllllIIlIIlIllIlII.withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, lllllllllllllllllllIIlIIlIllIIIl.rotate(lllllllllllllllllllIIlIIlIllIlII.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING)));
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllllllllIIlIIllIlIlIl, final IBlockAccess lllllllllllllllllllIIlIIllIlIlII, final BlockPos lllllllllllllllllllIIlIIllIlIIll, final EnumFacing lllllllllllllllllllIIlIIllIlIIlI) {
        return lllllllllllllllllllIIlIIllIlIlIl.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED) ? 15 : 0;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTripWireHook.FACING, BlockTripWireHook.POWERED, BlockTripWireHook.ATTACHED });
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    
    private void notifyNeighbors(final World lllllllllllllllllllIIlIIllllllII, final BlockPos lllllllllllllllllllIIlIIllllIlll, final EnumFacing lllllllllllllllllllIIlIIllllIllI) {
        lllllllllllllllllllIIlIIllllllII.notifyNeighborsOfStateChange(lllllllllllllllllllIIlIIllllIlll, this, false);
        lllllllllllllllllllIIlIIllllllII.notifyNeighborsOfStateChange(lllllllllllllllllllIIlIIllllIlll.offset(lllllllllllllllllllIIlIIllllIllI.getOpposite()), this, false);
    }
    
    @Override
    public void randomTick(final World lllllllllllllllllllIIlIlIIlIIlIl, final BlockPos lllllllllllllllllllIIlIlIIlIIlII, final IBlockState lllllllllllllllllllIIlIlIIlIIIll, final Random lllllllllllllllllllIIlIlIIlIIIlI) {
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllllllllIIlIIllIIIllI) {
        return true;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllllIIlIIlIllllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.getHorizontal(lllllllllllllllllllIIlIIlIllllll & 0x3)).withProperty((IProperty<Comparable>)BlockTripWireHook.POWERED, (lllllllllllllllllllIIlIIlIllllll & 0x8) > 0).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, (lllllllllllllllllllIIlIIlIllllll & 0x4) > 0);
    }
    
    public void calculateState(final World lllllllllllllllllllIIlIlIlIlIIll, final BlockPos lllllllllllllllllllIIlIlIIlllIII, final IBlockState lllllllllllllllllllIIlIlIlIlIIIl, final boolean lllllllllllllllllllIIlIlIlIlIIII, final boolean lllllllllllllllllllIIlIlIIllIlIl, final int lllllllllllllllllllIIlIlIlIIlllI, @Nullable final IBlockState lllllllllllllllllllIIlIlIIllIIll) {
        final EnumFacing lllllllllllllllllllIIlIlIlIIllII = lllllllllllllllllllIIlIlIlIlIIIl.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING);
        final boolean lllllllllllllllllllIIlIlIlIIlIll = lllllllllllllllllllIIlIlIlIlIIIl.getValue((IProperty<Boolean>)BlockTripWireHook.ATTACHED);
        final boolean lllllllllllllllllllIIlIlIlIIlIlI = lllllllllllllllllllIIlIlIlIlIIIl.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED);
        boolean lllllllllllllllllllIIlIlIlIIlIIl = !lllllllllllllllllllIIlIlIlIlIIII;
        boolean lllllllllllllllllllIIlIlIlIIlIII = false;
        int lllllllllllllllllllIIlIlIlIIIlll = 0;
        final IBlockState[] lllllllllllllllllllIIlIlIlIIIllI = new IBlockState[42];
        int lllllllllllllllllllIIlIlIlIIIlIl = 1;
        while (lllllllllllllllllllIIlIlIlIIIlIl < 42) {
            final BlockPos lllllllllllllllllllIIlIlIlIIIlII = lllllllllllllllllllIIlIlIIlllIII.offset(lllllllllllllllllllIIlIlIlIIllII, lllllllllllllllllllIIlIlIlIIIlIl);
            IBlockState lllllllllllllllllllIIlIlIlIIIIll = lllllllllllllllllllIIlIlIlIlIIll.getBlockState(lllllllllllllllllllIIlIlIlIIIlII);
            if (lllllllllllllllllllIIlIlIlIIIIll.getBlock() == Blocks.TRIPWIRE_HOOK) {
                if (lllllllllllllllllllIIlIlIlIIIIll.getValue((IProperty<Comparable>)BlockTripWireHook.FACING) == lllllllllllllllllllIIlIlIlIIllII.getOpposite()) {
                    lllllllllllllllllllIIlIlIlIIIlll = lllllllllllllllllllIIlIlIlIIIlIl;
                    break;
                }
                break;
            }
            else {
                if (lllllllllllllllllllIIlIlIlIIIIll.getBlock() != Blocks.TRIPWIRE && lllllllllllllllllllIIlIlIlIIIlIl != lllllllllllllllllllIIlIlIlIIlllI) {
                    lllllllllllllllllllIIlIlIlIIIllI[lllllllllllllllllllIIlIlIlIIIlIl] = null;
                    lllllllllllllllllllIIlIlIlIIlIIl = false;
                }
                else {
                    if (lllllllllllllllllllIIlIlIlIIIlIl == lllllllllllllllllllIIlIlIlIIlllI) {
                        lllllllllllllllllllIIlIlIlIIIIll = (IBlockState)MoreObjects.firstNonNull((Object)lllllllllllllllllllIIlIlIIllIIll, (Object)lllllllllllllllllllIIlIlIlIIIIll);
                    }
                    final boolean lllllllllllllllllllIIlIlIlIIIIlI = !lllllllllllllllllllIIlIlIlIIIIll.getValue((IProperty<Boolean>)BlockTripWire.DISARMED);
                    final boolean lllllllllllllllllllIIlIlIlIIIIIl = lllllllllllllllllllIIlIlIlIIIIll.getValue((IProperty<Boolean>)BlockTripWire.POWERED);
                    lllllllllllllllllllIIlIlIlIIlIII |= (lllllllllllllllllllIIlIlIlIIIIlI && lllllllllllllllllllIIlIlIlIIIIIl);
                    lllllllllllllllllllIIlIlIlIIIllI[lllllllllllllllllllIIlIlIlIIIlIl] = lllllllllllllllllllIIlIlIlIIIIll;
                    if (lllllllllllllllllllIIlIlIlIIIlIl == lllllllllllllllllllIIlIlIlIIlllI) {
                        lllllllllllllllllllIIlIlIlIlIIll.scheduleUpdate(lllllllllllllllllllIIlIlIIlllIII, this, this.tickRate(lllllllllllllllllllIIlIlIlIlIIll));
                        lllllllllllllllllllIIlIlIlIIlIIl &= lllllllllllllllllllIIlIlIlIIIIlI;
                    }
                }
                ++lllllllllllllllllllIIlIlIlIIIlIl;
            }
        }
        lllllllllllllllllllIIlIlIlIIlIIl &= (lllllllllllllllllllIIlIlIlIIIlll > 1);
        lllllllllllllllllllIIlIlIlIIlIII &= lllllllllllllllllllIIlIlIlIIlIIl;
        final IBlockState lllllllllllllllllllIIlIlIlIIIIII = this.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, lllllllllllllllllllIIlIlIlIIlIIl).withProperty((IProperty<Comparable>)BlockTripWireHook.POWERED, lllllllllllllllllllIIlIlIlIIlIII);
        if (lllllllllllllllllllIIlIlIlIIIlll > 0) {
            final BlockPos lllllllllllllllllllIIlIlIIllllll = lllllllllllllllllllIIlIlIIlllIII.offset(lllllllllllllllllllIIlIlIlIIllII, lllllllllllllllllllIIlIlIlIIIlll);
            final EnumFacing lllllllllllllllllllIIlIlIIlllllI = lllllllllllllllllllIIlIlIlIIllII.getOpposite();
            lllllllllllllllllllIIlIlIlIlIIll.setBlockState(lllllllllllllllllllIIlIlIIllllll, lllllllllllllllllllIIlIlIlIIIIII.withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, lllllllllllllllllllIIlIlIIlllllI), 3);
            this.notifyNeighbors(lllllllllllllllllllIIlIlIlIlIIll, lllllllllllllllllllIIlIlIIllllll, lllllllllllllllllllIIlIlIIlllllI);
            this.playSound(lllllllllllllllllllIIlIlIlIlIIll, lllllllllllllllllllIIlIlIIllllll, lllllllllllllllllllIIlIlIlIIlIIl, lllllllllllllllllllIIlIlIlIIlIII, lllllllllllllllllllIIlIlIlIIlIll, lllllllllllllllllllIIlIlIlIIlIlI);
        }
        this.playSound(lllllllllllllllllllIIlIlIlIlIIll, lllllllllllllllllllIIlIlIIlllIII, lllllllllllllllllllIIlIlIlIIlIIl, lllllllllllllllllllIIlIlIlIIlIII, lllllllllllllllllllIIlIlIlIIlIll, lllllllllllllllllllIIlIlIlIIlIlI);
        if (!lllllllllllllllllllIIlIlIlIlIIII) {
            lllllllllllllllllllIIlIlIlIlIIll.setBlockState(lllllllllllllllllllIIlIlIIlllIII, lllllllllllllllllllIIlIlIlIIIIII.withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, lllllllllllllllllllIIlIlIlIIllII), 3);
            if (lllllllllllllllllllIIlIlIIllIlIl) {
                this.notifyNeighbors(lllllllllllllllllllIIlIlIlIlIIll, lllllllllllllllllllIIlIlIIlllIII, lllllllllllllllllllIIlIlIlIIllII);
            }
        }
        if (lllllllllllllllllllIIlIlIlIIlIll != lllllllllllllllllllIIlIlIlIIlIIl) {
            for (int lllllllllllllllllllIIlIlIIllllIl = 1; lllllllllllllllllllIIlIlIIllllIl < lllllllllllllllllllIIlIlIlIIIlll; ++lllllllllllllllllllIIlIlIIllllIl) {
                final BlockPos lllllllllllllllllllIIlIlIIllllII = lllllllllllllllllllIIlIlIIlllIII.offset(lllllllllllllllllllIIlIlIlIIllII, lllllllllllllllllllIIlIlIIllllIl);
                final IBlockState lllllllllllllllllllIIlIlIIlllIll = lllllllllllllllllllIIlIlIlIIIllI[lllllllllllllllllllIIlIlIIllllIl];
                if (lllllllllllllllllllIIlIlIIlllIll != null && lllllllllllllllllllIIlIlIlIlIIll.getBlockState(lllllllllllllllllllIIlIlIIllllII).getMaterial() != Material.AIR) {
                    lllllllllllllllllllIIlIlIlIlIIll.setBlockState(lllllllllllllllllllIIlIlIIllllII, lllllllllllllllllllIIlIlIIlllIll.withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, lllllllllllllllllllIIlIlIlIIlIIl), 3);
                }
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllllllIIlIlllIIIIII) {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllllllllIIlIllIllIlIl, final BlockPos lllllllllllllllllllIIlIllIlIllIl, final EnumFacing lllllllllllllllllllIIlIllIlIllII) {
        final EnumFacing lllllllllllllllllllIIlIllIllIIlI = lllllllllllllllllllIIlIllIlIllII.getOpposite();
        final BlockPos lllllllllllllllllllIIlIllIllIIIl = lllllllllllllllllllIIlIllIlIllIl.offset(lllllllllllllllllllIIlIllIllIIlI);
        final IBlockState lllllllllllllllllllIIlIllIllIIII = lllllllllllllllllllIIlIllIllIlIl.getBlockState(lllllllllllllllllllIIlIllIllIIIl);
        final boolean lllllllllllllllllllIIlIllIlIllll = Block.func_193382_c(lllllllllllllllllllIIlIllIllIIII.getBlock());
        return !lllllllllllllllllllIIlIllIlIllll && lllllllllllllllllllIIlIllIlIllII.getAxis().isHorizontal() && lllllllllllllllllllIIlIllIllIIII.func_193401_d(lllllllllllllllllllIIlIllIllIlIl, lllllllllllllllllllIIlIllIllIIIl, lllllllllllllllllllIIlIllIlIllII) == BlockFaceShape.SOLID && !lllllllllllllllllllIIlIllIllIIII.canProvidePower();
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllllllllIIlIllIIIIlII, final BlockPos lllllllllllllllllllIIlIllIIIIIll, final IBlockState lllllllllllllllllllIIlIllIIIIIlI, final EntityLivingBase lllllllllllllllllllIIlIllIIIIIIl, final ItemStack lllllllllllllllllllIIlIllIIIIIII) {
        this.calculateState(lllllllllllllllllllIIlIllIIIIlII, lllllllllllllllllllIIlIllIIIIIll, lllllllllllllllllllIIlIllIIIIIlI, false, false, -1, null);
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllllllllIIlIlllIIIlII, final IBlockAccess lllllllllllllllllllIIlIlllIIIIll, final BlockPos lllllllllllllllllllIIlIlllIIIIlI) {
        return BlockTripWireHook.NULL_AABB;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllllllllIIlIIlIlIlIll, final Mirror lllllllllllllllllllIIlIIlIlIlIlI) {
        return lllllllllllllllllllIIlIIlIlIlIll.withRotation(lllllllllllllllllllIIlIIlIlIlIlI.toRotation(lllllllllllllllllllIIlIIlIlIlIll.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING)));
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllllllIIlIIlIlIIlIl, final IBlockState lllllllllllllllllllIIlIIlIlIIlII, final BlockPos lllllllllllllllllllIIlIIlIlIIIll, final EnumFacing lllllllllllllllllllIIlIIlIlIIIlI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllllIIlIIlIlllIIl) {
        int lllllllllllllllllllIIlIIlIlllIlI = 0;
        lllllllllllllllllllIIlIIlIlllIlI |= lllllllllllllllllllIIlIIlIlllIIl.getValue((IProperty<EnumFacing>)BlockTripWireHook.FACING).getHorizontalIndex();
        if (lllllllllllllllllllIIlIIlIlllIIl.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED)) {
            lllllllllllllllllllIIlIIlIlllIlI |= 0x8;
        }
        if (lllllllllllllllllllIIlIIlIlllIIl.getValue((IProperty<Boolean>)BlockTripWireHook.ATTACHED)) {
            lllllllllllllllllllIIlIIlIlllIlI |= 0x4;
        }
        return lllllllllllllllllllIIlIIlIlllIlI;
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllllllllIIlIIllIIlIIl, final IBlockAccess lllllllllllllllllllIIlIIllIIllII, final BlockPos lllllllllllllllllllIIlIIllIIlIll, final EnumFacing lllllllllllllllllllIIlIIllIIlIlI) {
        if (!lllllllllllllllllllIIlIIllIIlIIl.getValue((IProperty<Boolean>)BlockTripWireHook.POWERED)) {
            return 0;
        }
        return (lllllllllllllllllllIIlIIllIIlIIl.getValue((IProperty<Comparable>)BlockTripWireHook.FACING) == lllllllllllllllllllIIlIIllIIlIlI) ? 15 : 0;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllllllIIlIllIlllllI) {
        return false;
    }
}
