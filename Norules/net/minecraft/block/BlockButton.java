package net.minecraft.block;

import net.minecraft.entity.player.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import javax.annotation.*;

public abstract class BlockButton extends BlockDirectional
{
    private final /* synthetic */ boolean wooden;
    protected static final /* synthetic */ AxisAlignedBB AABB_DOWN_OFF;
    protected static final /* synthetic */ AxisAlignedBB AABB_SOUTH_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_NORTH_OFF;
    protected static final /* synthetic */ AxisAlignedBB AABB_NORTH_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_UP_OFF;
    protected static final /* synthetic */ AxisAlignedBB AABB_DOWN_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_WEST_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_EAST_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_UP_ON;
    protected static final /* synthetic */ AxisAlignedBB AABB_SOUTH_OFF;
    protected static final /* synthetic */ AxisAlignedBB AABB_EAST_OFF;
    public static final /* synthetic */ PropertyBool POWERED;
    protected static final /* synthetic */ AxisAlignedBB AABB_WEST_OFF;
    
    @Override
    public boolean canProvidePower(final IBlockState llIllIlIIIlIIII) {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(final World llIllIlIIlllIll, final BlockPos llIllIlIIlllIlI, final IBlockState llIllIlIIlIllll, final EntityPlayer llIllIlIIlllIII, final EnumHand llIllIlIIllIlll, final EnumFacing llIllIlIIllIllI, final float llIllIlIIllIlIl, final float llIllIlIIllIlII, final float llIllIlIIllIIll) {
        if (llIllIlIIlIllll.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            return true;
        }
        llIllIlIIlllIll.setBlockState(llIllIlIIlllIlI, llIllIlIIlIllll.withProperty((IProperty<Comparable>)BlockButton.POWERED, true), 3);
        llIllIlIIlllIll.markBlockRangeForRenderUpdate(llIllIlIIlllIlI, llIllIlIIlllIlI);
        this.playClickSound(llIllIlIIlllIII, llIllIlIIlllIll, llIllIlIIlllIlI);
        this.notifyNeighbors(llIllIlIIlllIll, llIllIlIIlllIlI, llIllIlIIlIllll.getValue((IProperty<EnumFacing>)BlockButton.FACING));
        llIllIlIIlllIll.scheduleUpdate(llIllIlIIlllIlI, this, this.tickRate(llIllIlIIlllIll));
        return true;
    }
    
    @Override
    public void randomTick(final World llIllIlIIIIlllI, final BlockPos llIllIlIIIIllIl, final IBlockState llIllIlIIIIllII, final Random llIllIlIIIIlIll) {
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llIllIlllIlIlII, final BlockPos llIllIlllIlIIll, final EnumFacing llIllIlllIIlIIl, final float llIllIlllIlIIIl, final float llIllIlllIlIIII, final float llIllIlllIIllll, final int llIllIlllIIlllI, final EntityLivingBase llIllIlllIIllIl) {
        return canPlaceBlock(llIllIlllIlIlII, llIllIlllIlIIll, llIllIlllIIlIIl) ? this.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, llIllIlllIIlIIl).withProperty((IProperty<Comparable>)BlockButton.POWERED, false) : this.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, EnumFacing.DOWN).withProperty((IProperty<Comparable>)BlockButton.POWERED, false);
    }
    
    @Override
    public void neighborChanged(final IBlockState llIllIlllIIIIll, final World llIllIllIllllII, final BlockPos llIllIllIlllIll, final Block llIllIlllIIIIII, final BlockPos llIllIllIllllll) {
        if (this.checkForDrop(llIllIllIllllII, llIllIllIlllIll, llIllIlllIIIIll) && !canPlaceBlock(llIllIllIllllII, llIllIllIlllIll, llIllIlllIIIIll.getValue((IProperty<EnumFacing>)BlockButton.FACING))) {
            this.dropBlockAsItem(llIllIllIllllII, llIllIllIlllIll, llIllIlllIIIIll, 0);
            llIllIllIllllII.setBlockToAir(llIllIllIlllIll);
        }
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llIllIIlIllIIII, final Rotation llIllIIlIlIllll) {
        return llIllIIlIllIIII.withProperty((IProperty<Comparable>)BlockButton.FACING, llIllIIlIlIllll.rotate(llIllIIlIllIIII.getValue((IProperty<EnumFacing>)BlockButton.FACING)));
    }
    
    @Override
    public void breakBlock(final World llIllIlIIlIIlII, final BlockPos llIllIlIIlIIIll, final IBlockState llIllIlIIlIIllI) {
        if (llIllIlIIlIIllI.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            this.notifyNeighbors(llIllIlIIlIIlII, llIllIlIIlIIIll, llIllIlIIlIIllI.getValue((IProperty<EnumFacing>)BlockButton.FACING));
        }
        super.breakBlock(llIllIlIIlIIlII, llIllIlIIlIIIll, llIllIlIIlIIllI);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llIllIIllllIIll, final BlockPos llIllIIllllIlll, final IBlockState llIllIIllllIIIl, final Entity llIllIIllllIlIl) {
        if (!llIllIIllllIIll.isRemote && this.wooden && !llIllIIllllIIIl.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            this.checkPressed(llIllIIllllIIIl, llIllIIllllIIll, llIllIIllllIlll);
        }
    }
    
    private void notifyNeighbors(final World llIllIIllIlIIlI, final BlockPos llIllIIllIlIIIl, final EnumFacing llIllIIllIlIIII) {
        llIllIIllIlIIlI.notifyNeighborsOfStateChange(llIllIIllIlIIIl, this, false);
        llIllIIllIlIIlI.notifyNeighborsOfStateChange(llIllIIllIlIIIl.offset(llIllIIllIlIIII.getOpposite()), this, false);
    }
    
    @Override
    public int getStrongPower(final IBlockState llIllIlIIIlIIll, final IBlockAccess llIllIlIIIlIllI, final BlockPos llIllIlIIIlIlIl, final EnumFacing llIllIlIIIlIlII) {
        if (!llIllIlIIIlIIll.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            return 0;
        }
        return (llIllIlIIIlIIll.getValue((IProperty<Comparable>)BlockButton.FACING) == llIllIlIIIlIlII) ? 15 : 0;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llIllIlllllIlII, final BlockPos llIllIlllllIllI) {
        final Exception llIllIllllIllll;
        final float llIllIlllllIIII = ((EnumFacing[])(Object)(llIllIllllIllll = (Exception)(Object)EnumFacing.values())).length;
        for (boolean llIllIlllllIIIl = false; (llIllIlllllIIIl ? 1 : 0) < llIllIlllllIIII; ++llIllIlllllIIIl) {
            final EnumFacing llIllIlllllIlIl = llIllIllllIllll[llIllIlllllIIIl];
            if (canPlaceBlock(llIllIlllllIlII, llIllIlllllIllI, llIllIlllllIlIl)) {
                return true;
            }
        }
        return false;
    }
    
    static {
        POWERED = PropertyBool.create("powered");
        AABB_DOWN_OFF = new AxisAlignedBB(0.3125, 0.875, 0.375, 0.6875, 1.0, 0.625);
        AABB_UP_OFF = new AxisAlignedBB(0.3125, 0.0, 0.375, 0.6875, 0.125, 0.625);
        AABB_NORTH_OFF = new AxisAlignedBB(0.3125, 0.375, 0.875, 0.6875, 0.625, 1.0);
        AABB_SOUTH_OFF = new AxisAlignedBB(0.3125, 0.375, 0.0, 0.6875, 0.625, 0.125);
        AABB_WEST_OFF = new AxisAlignedBB(0.875, 0.375, 0.3125, 1.0, 0.625, 0.6875);
        AABB_EAST_OFF = new AxisAlignedBB(0.0, 0.375, 0.3125, 0.125, 0.625, 0.6875);
        AABB_DOWN_ON = new AxisAlignedBB(0.3125, 0.9375, 0.375, 0.6875, 1.0, 0.625);
        AABB_UP_ON = new AxisAlignedBB(0.3125, 0.0, 0.375, 0.6875, 0.0625, 0.625);
        AABB_NORTH_ON = new AxisAlignedBB(0.3125, 0.375, 0.9375, 0.6875, 0.625, 1.0);
        AABB_SOUTH_ON = new AxisAlignedBB(0.3125, 0.375, 0.0, 0.6875, 0.625, 0.0625);
        AABB_WEST_ON = new AxisAlignedBB(0.9375, 0.375, 0.3125, 1.0, 0.625, 0.6875);
        AABB_EAST_ON = new AxisAlignedBB(0.0, 0.375, 0.3125, 0.0625, 0.625, 0.6875);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockButton.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final double llIllIIlIIllllI = (Object)new int[EnumFacing.values().length];
        try {
            llIllIIlIIllllI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llIllIIlIIllllI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llIllIIlIIllllI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llIllIIlIIllllI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llIllIIlIIllllI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llIllIIlIIllllI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockButton.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llIllIIlIIllllI;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llIllIIllIIIIll) {
        final EnumFacing llIllIIllIIIlIl;
        switch (llIllIIllIIIIll & 0x7) {
            case 0: {
                final EnumFacing llIllIIllIIlIlI = EnumFacing.DOWN;
                break;
            }
            case 1: {
                final EnumFacing llIllIIllIIlIIl = EnumFacing.EAST;
                break;
            }
            case 2: {
                final EnumFacing llIllIIllIIlIII = EnumFacing.WEST;
                break;
            }
            case 3: {
                final EnumFacing llIllIIllIIIlll = EnumFacing.SOUTH;
                break;
            }
            case 4: {
                final EnumFacing llIllIIllIIIllI = EnumFacing.NORTH;
                break;
            }
            default: {
                llIllIIllIIIlIl = EnumFacing.UP;
                break;
            }
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, llIllIIllIIIlIl).withProperty((IProperty<Comparable>)BlockButton.POWERED, (llIllIIllIIIIll & 0x8) > 0);
    }
    
    @Override
    public void updateTick(final World llIllIlIIIIIIII, final BlockPos llIllIlIIIIIlII, final IBlockState llIllIIlllllllI, final Random llIllIlIIIIIIlI) {
        if (!llIllIlIIIIIIII.isRemote && llIllIIlllllllI.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            if (this.wooden) {
                this.checkPressed(llIllIIlllllllI, llIllIlIIIIIIII, llIllIlIIIIIlII);
            }
            else {
                llIllIlIIIIIIII.setBlockState(llIllIlIIIIIlII, llIllIIlllllllI.withProperty((IProperty<Comparable>)BlockButton.POWERED, false));
                this.notifyNeighbors(llIllIlIIIIIIII, llIllIlIIIIIlII, llIllIIlllllllI.getValue((IProperty<EnumFacing>)BlockButton.FACING));
                this.playReleaseSound(llIllIlIIIIIIII, llIllIlIIIIIlII);
                llIllIlIIIIIIII.markBlockRangeForRenderUpdate(llIllIlIIIIIlII, llIllIlIIIIIlII);
            }
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llIllIlIlIIIlII, final IBlockAccess llIllIlIlIIlIII, final BlockPos llIllIlIlIIIlll) {
        final EnumFacing llIllIlIlIIIllI = llIllIlIlIIIlII.getValue((IProperty<EnumFacing>)BlockButton.FACING);
        final boolean llIllIlIlIIIlIl = llIllIlIlIIIlII.getValue((IProperty<Boolean>)BlockButton.POWERED);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llIllIlIlIIIllI.ordinal()]) {
            case 6: {
                return llIllIlIlIIIlIl ? BlockButton.AABB_EAST_ON : BlockButton.AABB_EAST_OFF;
            }
            case 5: {
                return llIllIlIlIIIlIl ? BlockButton.AABB_WEST_ON : BlockButton.AABB_WEST_OFF;
            }
            case 4: {
                return llIllIlIlIIIlIl ? BlockButton.AABB_SOUTH_ON : BlockButton.AABB_SOUTH_OFF;
            }
            default: {
                return llIllIlIlIIIlIl ? BlockButton.AABB_NORTH_ON : BlockButton.AABB_NORTH_OFF;
            }
            case 2: {
                return llIllIlIlIIIlIl ? BlockButton.AABB_UP_ON : BlockButton.AABB_UP_OFF;
            }
            case 1: {
                return llIllIlIlIIIlIl ? BlockButton.AABB_DOWN_ON : BlockButton.AABB_DOWN_OFF;
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockButton.FACING, BlockButton.POWERED });
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llIlllIIIIIlIll) {
        return false;
    }
    
    protected static boolean canPlaceBlock(final World llIllIllllIIlll, final BlockPos llIllIllllIIllI, final EnumFacing llIllIllllIIlIl) {
        final BlockPos llIllIllllIIlII = llIllIllllIIllI.offset(llIllIllllIIlIl.getOpposite());
        final IBlockState llIllIllllIIIll = llIllIllllIIlll.getBlockState(llIllIllllIIlII);
        final boolean llIllIllllIIIlI = llIllIllllIIIll.func_193401_d(llIllIllllIIlll, llIllIllllIIlII, llIllIllllIIlIl) == BlockFaceShape.SOLID;
        final Block llIllIllllIIIIl = llIllIllllIIIll.getBlock();
        if (llIllIllllIIlIl == EnumFacing.UP) {
            return llIllIllllIIIIl == Blocks.HOPPER || (!Block.func_193384_b(llIllIllllIIIIl) && llIllIllllIIIlI);
        }
        return !Block.func_193382_c(llIllIllllIIIIl) && llIllIllllIIIlI;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llIllIIlIlIlIIl, final Mirror llIllIIlIlIlIlI) {
        return llIllIIlIlIlIIl.withRotation(llIllIIlIlIlIlI.toRotation(llIllIIlIlIlIIl.getValue((IProperty<EnumFacing>)BlockButton.FACING)));
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World llIlllIIIIIIlII, final BlockPos llIlllIIIIIIIll, final EnumFacing llIllIlllllllll) {
        return canPlaceBlock(llIlllIIIIIIlII, llIlllIIIIIIIll, llIllIlllllllll);
    }
    
    @Override
    public int tickRate(final World llIlllIIIIIlllI) {
        return this.wooden ? 30 : 20;
    }
    
    private void checkPressed(final IBlockState llIllIIlllIlIII, final World llIllIIlllIIlll, final BlockPos llIllIIlllIIllI) {
        final List<? extends Entity> llIllIIlllIIlIl = llIllIIlllIIlll.getEntitiesWithinAABB((Class<? extends Entity>)EntityArrow.class, llIllIIlllIlIII.getBoundingBox(llIllIIlllIIlll, llIllIIlllIIllI).offset(llIllIIlllIIllI));
        final boolean llIllIIlllIIlII = !llIllIIlllIIlIl.isEmpty();
        final boolean llIllIIlllIIIll = llIllIIlllIlIII.getValue((IProperty<Boolean>)BlockButton.POWERED);
        if (llIllIIlllIIlII && !llIllIIlllIIIll) {
            llIllIIlllIIlll.setBlockState(llIllIIlllIIllI, llIllIIlllIlIII.withProperty((IProperty<Comparable>)BlockButton.POWERED, true));
            this.notifyNeighbors(llIllIIlllIIlll, llIllIIlllIIllI, llIllIIlllIlIII.getValue((IProperty<EnumFacing>)BlockButton.FACING));
            llIllIIlllIIlll.markBlockRangeForRenderUpdate(llIllIIlllIIllI, llIllIIlllIIllI);
            this.playClickSound(null, llIllIIlllIIlll, llIllIIlllIIllI);
        }
        if (!llIllIIlllIIlII && llIllIIlllIIIll) {
            llIllIIlllIIlll.setBlockState(llIllIIlllIIllI, llIllIIlllIlIII.withProperty((IProperty<Comparable>)BlockButton.POWERED, false));
            this.notifyNeighbors(llIllIIlllIIlll, llIllIIlllIIllI, llIllIIlllIlIII.getValue((IProperty<EnumFacing>)BlockButton.FACING));
            llIllIIlllIIlll.markBlockRangeForRenderUpdate(llIllIIlllIIllI, llIllIIlllIIllI);
            this.playReleaseSound(llIllIIlllIIlll, llIllIIlllIIllI);
        }
        if (llIllIIlllIIlII) {
            llIllIIlllIIlll.scheduleUpdate(new BlockPos(llIllIIlllIIllI), this, this.tickRate(llIllIIlllIIlll));
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llIllIIlIlIIIll, final IBlockState llIllIIlIlIIIlI, final BlockPos llIllIIlIlIIIIl, final EnumFacing llIllIIlIlIIIII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    protected BlockButton(final boolean llIlllIIIIlIlll) {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockButton.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockButton.POWERED, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.wooden = llIlllIIIIlIlll;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llIlllIIIIlIIll, final IBlockAccess llIlllIIIIlIIlI, final BlockPos llIlllIIIIlIIIl) {
        return BlockButton.NULL_AABB;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llIllIIlIllIlll) {
        int llIllIIlIlllIII = 0;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llIllIIlIllIlll.getValue((IProperty<EnumFacing>)BlockButton.FACING).ordinal()]) {
            case 6: {
                final int llIllIIlIllllIl = 1;
                break;
            }
            case 5: {
                final int llIllIIlIllllII = 2;
                break;
            }
            case 4: {
                final int llIllIIlIlllIll = 3;
                break;
            }
            case 3: {
                final int llIllIIlIlllIlI = 4;
                break;
            }
            default: {
                final int llIllIIlIlllIIl = 5;
                break;
            }
            case 1: {
                llIllIIlIlllIII = 0;
                break;
            }
        }
        if (llIllIIlIllIlll.getValue((IProperty<Boolean>)BlockButton.POWERED)) {
            llIllIIlIlllIII |= 0x8;
        }
        return llIllIIlIlllIII;
    }
    
    @Override
    public int getWeakPower(final IBlockState llIllIlIIIlllll, final IBlockAccess llIllIlIIIllllI, final BlockPos llIllIlIIIlllIl, final EnumFacing llIllIlIIIlllII) {
        return llIllIlIIIlllll.getValue((IProperty<Boolean>)BlockButton.POWERED) ? 15 : 0;
    }
    
    private boolean checkForDrop(final World llIllIlIlIlIlII, final BlockPos llIllIlIlIlIIll, final IBlockState llIllIlIlIlIIlI) {
        if (this.canPlaceBlockAt(llIllIlIlIlIlII, llIllIlIlIlIIll)) {
            return true;
        }
        this.dropBlockAsItem(llIllIlIlIlIlII, llIllIlIlIlIIll, llIllIlIlIlIIlI, 0);
        llIllIlIlIlIlII.setBlockToAir(llIllIlIlIlIIll);
        return false;
    }
    
    protected abstract void playReleaseSound(final World p0, final BlockPos p1);
    
    protected abstract void playClickSound(final EntityPlayer p0, final World p1, final BlockPos p2);
    
    @Override
    public boolean isFullCube(final IBlockState llIlllIIIIIlIIl) {
        return false;
    }
}
