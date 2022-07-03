package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class BlockLever extends Block
{
    protected static final /* synthetic */ AxisAlignedBB LEVER_WEST_AABB;
    public static final /* synthetic */ PropertyEnum<EnumOrientation> FACING;
    public static final /* synthetic */ PropertyBool POWERED;
    protected static final /* synthetic */ AxisAlignedBB LEVER_SOUTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB LEVER_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB LEVER_UP_AABB;
    protected static final /* synthetic */ AxisAlignedBB LEVER_DOWN_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation;
    protected static final /* synthetic */ AxisAlignedBB LEVER_NORTH_AABB;
    
    @Override
    public void breakBlock(final World lllllllllllllllIlIlIIllIlllIIIll, final BlockPos lllllllllllllllIlIlIIllIlllIIIlI, final IBlockState lllllllllllllllIlIlIIllIlllIIIIl) {
        if (lllllllllllllllIlIlIIllIlllIIIIl.getValue((IProperty<Boolean>)BlockLever.POWERED)) {
            lllllllllllllllIlIlIIllIlllIIIll.notifyNeighborsOfStateChange(lllllllllllllllIlIlIIllIlllIIIlI, this, false);
            final EnumFacing lllllllllllllllIlIlIIllIlllIIIII = lllllllllllllllIlIlIIllIlllIIIIl.getValue(BlockLever.FACING).getFacing();
            lllllllllllllllIlIlIIllIlllIIIll.notifyNeighborsOfStateChange(lllllllllllllllIlIlIIllIlllIIIlI.offset(lllllllllllllllIlIlIIllIlllIIIII.getOpposite()), this, false);
        }
        super.breakBlock(lllllllllllllllIlIlIIllIlllIIIll, lllllllllllllllIlIlIIllIlllIIIlI, lllllllllllllllIlIlIIllIlllIIIIl);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllIlIlIIllIlIllIllI, final Rotation lllllllllllllllIlIlIIllIlIllIlll) {
        Label_0308: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllllIlIlIIllIlIllIlll.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation()[lllllllllllllllIlIlIIllIlIllIllI.getValue(BlockLever.FACING).ordinal()]) {
                        case 2: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.WEST);
                        }
                        case 3: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.EAST);
                        }
                        case 4: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.NORTH);
                        }
                        case 5: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.SOUTH);
                        }
                        default: {
                            return lllllllllllllllIlIlIIllIlIllIllI;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation()[lllllllllllllllIlIlIIllIlIllIllI.getValue(BlockLever.FACING).ordinal()]) {
                        case 2: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.NORTH);
                        }
                        case 3: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.SOUTH);
                        }
                        case 4: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.EAST);
                        }
                        case 5: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.WEST);
                        }
                        case 6: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.UP_X);
                        }
                        case 7: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.UP_Z);
                        }
                        case 1: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.DOWN_Z);
                        }
                        case 8: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.DOWN_X);
                        }
                        default: {
                            break Label_0308;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation()[lllllllllllllllIlIlIIllIlIllIllI.getValue(BlockLever.FACING).ordinal()]) {
                        case 2: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.SOUTH);
                        }
                        case 3: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.NORTH);
                        }
                        case 4: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.WEST);
                        }
                        case 5: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.EAST);
                        }
                        case 6: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.UP_X);
                        }
                        case 7: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.UP_Z);
                        }
                        case 1: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.DOWN_Z);
                        }
                        case 8: {
                            return lllllllllllllllIlIlIIllIlIllIllI.withProperty(BlockLever.FACING, EnumOrientation.DOWN_X);
                        }
                        default: {
                            break Label_0308;
                        }
                    }
                    break;
                }
            }
        }
        return lllllllllllllllIlIlIIllIlIllIllI;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIlIlIIlllIlIIlllI, final BlockPos lllllllllllllllIlIlIIlllIlIIlIlI) {
        final long lllllllllllllllIlIlIIlllIlIIIllI;
        final String lllllllllllllllIlIlIIlllIlIIIlll = (String)((EnumFacing[])(Object)(lllllllllllllllIlIlIIlllIlIIIllI = (long)(Object)EnumFacing.values())).length;
        for (char lllllllllllllllIlIlIIlllIlIIlIII = '\0'; lllllllllllllllIlIlIIlllIlIIlIII < lllllllllllllllIlIlIIlllIlIIIlll; ++lllllllllllllllIlIlIIlllIlIIlIII) {
            final EnumFacing lllllllllllllllIlIlIIlllIlIIllII = lllllllllllllllIlIlIIlllIlIIIllI[lllllllllllllllIlIlIIlllIlIIlIII];
            if (canAttachTo(lllllllllllllllIlIlIIlllIlIIlllI, lllllllllllllllIlIlIIlllIlIIlIlI, lllllllllllllllIlIlIIlllIlIIllII)) {
                return true;
            }
        }
        return false;
    }
    
    static {
        FACING = PropertyEnum.create("facing", EnumOrientation.class);
        POWERED = PropertyBool.create("powered");
        LEVER_NORTH_AABB = new AxisAlignedBB(0.3125, 0.20000000298023224, 0.625, 0.6875, 0.800000011920929, 1.0);
        LEVER_SOUTH_AABB = new AxisAlignedBB(0.3125, 0.20000000298023224, 0.0, 0.6875, 0.800000011920929, 0.375);
        LEVER_WEST_AABB = new AxisAlignedBB(0.625, 0.20000000298023224, 0.3125, 1.0, 0.800000011920929, 0.6875);
        LEVER_EAST_AABB = new AxisAlignedBB(0.0, 0.20000000298023224, 0.3125, 0.375, 0.800000011920929, 0.6875);
        LEVER_UP_AABB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 0.6000000238418579, 0.75);
        LEVER_DOWN_AABB = new AxisAlignedBB(0.25, 0.4000000059604645, 0.25, 0.75, 1.0, 0.75);
    }
    
    protected static boolean canAttachTo(final World lllllllllllllllIlIlIIlllIIllllll, final BlockPos lllllllllllllllIlIlIIlllIlIIIIIl, final EnumFacing lllllllllllllllIlIlIIlllIIllllIl) {
        return BlockButton.canPlaceBlock(lllllllllllllllIlIlIIlllIIllllll, lllllllllllllllIlIlIIlllIlIIIIIl, lllllllllllllllIlIlIIlllIIllllIl);
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllllIlIlIIllIllIIllII, final IBlockAccess lllllllllllllllIlIlIIllIllIIllll, final BlockPos lllllllllllllllIlIlIIllIllIIlllI, final EnumFacing lllllllllllllllIlIlIIllIllIIlIll) {
        if (!lllllllllllllllIlIlIIllIllIIllII.getValue((IProperty<Boolean>)BlockLever.POWERED)) {
            return 0;
        }
        return (lllllllllllllllIlIlIIllIllIIllII.getValue(BlockLever.FACING).getFacing() == lllllllllllllllIlIlIIllIllIIlIll) ? 15 : 0;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllIlIlIIlllIIIlIllI, final World lllllllllllllllIlIlIIlllIIIllIll, final BlockPos lllllllllllllllIlIlIIlllIIIllIlI, final Block lllllllllllllllIlIlIIlllIIIllIIl, final BlockPos lllllllllllllllIlIlIIlllIIIllIII) {
        if (this.checkCanSurvive(lllllllllllllllIlIlIIlllIIIllIll, lllllllllllllllIlIlIIlllIIIllIlI, lllllllllllllllIlIlIIlllIIIlIllI) && !canAttachTo(lllllllllllllllIlIlIIlllIIIllIll, lllllllllllllllIlIlIIlllIIIllIlI, lllllllllllllllIlIlIIlllIIIlIllI.getValue(BlockLever.FACING).getFacing())) {
            this.dropBlockAsItem(lllllllllllllllIlIlIIlllIIIllIll, lllllllllllllllIlIlIIlllIIIllIlI, lllllllllllllllIlIlIIlllIIIlIllI, 0);
            lllllllllllllllIlIlIIlllIIIllIll.setBlockToAir(lllllllllllllllIlIlIIlllIIIllIlI);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIlIIllIlIllllIl) {
        int lllllllllllllllIlIlIIllIlIlllllI = 0;
        lllllllllllllllIlIlIIllIlIlllllI |= lllllllllllllllIlIlIIllIlIllllIl.getValue(BlockLever.FACING).getMetadata();
        if (lllllllllllllllIlIlIIllIlIllllIl.getValue((IProperty<Boolean>)BlockLever.POWERED)) {
            lllllllllllllllIlIlIIllIlIlllllI |= 0x8;
        }
        return lllllllllllllllIlIlIIllIlIlllllI;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIlIlIIlllIllIIIlI) {
        return false;
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllllIlIlIIllIllIIlIIl) {
        return true;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockLever.FACING, BlockLever.POWERED });
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIlIlIIlllIllIIIII) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIlIlIIllIlllllIlI, final BlockPos lllllllllllllllIlIlIIllIlllllIIl, IBlockState lllllllllllllllIlIlIIllIlllIllII, final EntityPlayer lllllllllllllllIlIlIIllIllllIlll, final EnumHand lllllllllllllllIlIlIIllIllllIllI, final EnumFacing lllllllllllllllIlIlIIllIllllIlIl, final float lllllllllllllllIlIlIIllIllllIlII, final float lllllllllllllllIlIlIIllIllllIIll, final float lllllllllllllllIlIlIIllIllllIIlI) {
        if (lllllllllllllllIlIlIIllIlllllIlI.isRemote) {
            return true;
        }
        lllllllllllllllIlIlIIllIlllIllII = (long)((IBlockState)lllllllllllllllIlIlIIllIlllIllII).cycleProperty((IProperty<Comparable>)BlockLever.POWERED);
        lllllllllllllllIlIlIIllIlllllIlI.setBlockState(lllllllllllllllIlIlIIllIlllllIIl, (IBlockState)lllllllllllllllIlIlIIllIlllIllII, 3);
        final float lllllllllllllllIlIlIIllIllllIIIl = ((IBlockState)lllllllllllllllIlIlIIllIlllIllII).getValue((IProperty<Boolean>)BlockLever.POWERED) ? 0.6f : 0.5f;
        lllllllllllllllIlIlIIllIlllllIlI.playSound(null, lllllllllllllllIlIlIIllIlllllIIl, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 0.3f, lllllllllllllllIlIlIIllIllllIIIl);
        lllllllllllllllIlIlIIllIlllllIlI.notifyNeighborsOfStateChange(lllllllllllllllIlIlIIllIlllllIIl, this, false);
        final EnumFacing lllllllllllllllIlIlIIllIllllIIII = ((IBlockState)lllllllllllllllIlIlIIllIlllIllII).getValue(BlockLever.FACING).getFacing();
        lllllllllllllllIlIlIIllIlllllIlI.notifyNeighborsOfStateChange(lllllllllllllllIlIlIIllIlllllIIl.offset(lllllllllllllllIlIlIIllIllllIIII.getOpposite()), this, false);
        return true;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockLever.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final int lllllllllllllllIlIlIIllIlIlIIIlI = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllllIlIlIIllIlIlIIIlI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIIlI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIIlI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIIlI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockLever.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllllIlIlIIllIlIlIIIlI;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllllIlIlIIlllIllIIllI, final IBlockAccess lllllllllllllllIlIlIIlllIllIIlIl, final BlockPos lllllllllllllllIlIlIIlllIllIIlII) {
        return BlockLever.NULL_AABB;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllIlIlIIlllIIlIlIII, final BlockPos lllllllllllllllIlIlIIlllIIllIIlI, final EnumFacing lllllllllllllllIlIlIIlllIIlIIllI, final float lllllllllllllllIlIlIIlllIIllIIII, final float lllllllllllllllIlIlIIlllIIlIllll, final float lllllllllllllllIlIlIIlllIIlIlllI, final int lllllllllllllllIlIlIIlllIIlIllIl, final EntityLivingBase lllllllllllllllIlIlIIlllIIlIllII) {
        final IBlockState lllllllllllllllIlIlIIlllIIlIlIll = this.getDefaultState().withProperty((IProperty<Comparable>)BlockLever.POWERED, false);
        if (canAttachTo(lllllllllllllllIlIlIIlllIIlIlIII, lllllllllllllllIlIlIIlllIIllIIlI, lllllllllllllllIlIlIIlllIIlIIllI)) {
            return lllllllllllllllIlIlIIlllIIlIlIll.withProperty(BlockLever.FACING, EnumOrientation.forFacings(lllllllllllllllIlIlIIlllIIlIIllI, lllllllllllllllIlIlIIlllIIlIllII.getHorizontalFacing()));
        }
        for (final EnumFacing lllllllllllllllIlIlIIlllIIlIlIlI : EnumFacing.Plane.HORIZONTAL) {
            if (lllllllllllllllIlIlIIlllIIlIlIlI != lllllllllllllllIlIlIIlllIIlIIllI && canAttachTo(lllllllllllllllIlIlIIlllIIlIlIII, lllllllllllllllIlIlIIlllIIllIIlI, lllllllllllllllIlIlIIlllIIlIlIlI)) {
                return lllllllllllllllIlIlIIlllIIlIlIll.withProperty(BlockLever.FACING, EnumOrientation.forFacings(lllllllllllllllIlIlIIlllIIlIlIlI, lllllllllllllllIlIlIIlllIIlIllII.getHorizontalFacing()));
            }
        }
        if (lllllllllllllllIlIlIIlllIIlIlIII.getBlockState(lllllllllllllllIlIlIIlllIIllIIlI.down()).isFullyOpaque()) {
            return lllllllllllllllIlIlIIlllIIlIlIll.withProperty(BlockLever.FACING, EnumOrientation.forFacings(EnumFacing.UP, lllllllllllllllIlIlIIlllIIlIllII.getHorizontalFacing()));
        }
        return lllllllllllllllIlIlIIlllIIlIlIll;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIlIlIIllIlIlIlIIl, final IBlockState lllllllllllllllIlIlIIllIlIlIlIII, final BlockPos lllllllllllllllIlIlIIllIlIlIIlll, final EnumFacing lllllllllllllllIlIlIIllIlIlIIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    private boolean checkCanSurvive(final World lllllllllllllllIlIlIIlllIIIIlllI, final BlockPos lllllllllllllllIlIlIIlllIIIIllIl, final IBlockState lllllllllllllllIlIlIIlllIIIIllII) {
        if (this.canPlaceBlockAt(lllllllllllllllIlIlIIlllIIIIlllI, lllllllllllllllIlIlIIlllIIIIllIl)) {
            return true;
        }
        this.dropBlockAsItem(lllllllllllllllIlIlIIlllIIIIlllI, lllllllllllllllIlIlIIlllIIIIllIl, lllllllllllllllIlIlIIlllIIIIllII, 0);
        lllllllllllllllIlIlIIlllIIIIlllI.setBlockToAir(lllllllllllllllIlIlIIlllIIIIllIl);
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIlIIllIllIIIIll) {
        return this.getDefaultState().withProperty(BlockLever.FACING, EnumOrientation.byMetadata(lllllllllllllllIlIlIIllIllIIIIll & 0x7)).withProperty((IProperty<Comparable>)BlockLever.POWERED, (lllllllllllllllIlIlIIllIllIIIIll & 0x8) > 0);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllllIlIlIIllIlIllIIIl, final Mirror lllllllllllllllIlIlIIllIlIlIlllI) {
        return lllllllllllllllIlIlIIllIlIllIIIl.withRotation(lllllllllllllllIlIlIIllIlIlIlllI.toRotation(lllllllllllllllIlIlIIllIlIllIIIl.getValue(BlockLever.FACING).getFacing()));
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllllIlIlIIlllIlIllIII, final BlockPos lllllllllllllllIlIlIIlllIlIllIlI, final EnumFacing lllllllllllllllIlIlIIlllIlIllIIl) {
        return canAttachTo(lllllllllllllllIlIlIIlllIlIllIII, lllllllllllllllIlIlIIlllIlIllIlI, lllllllllllllllIlIlIIlllIlIllIIl);
    }
    
    protected BlockLever() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockLever.FACING, EnumOrientation.NORTH).withProperty((IProperty<Comparable>)BlockLever.POWERED, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIlIlIIlllIIIIIlIl, final IBlockAccess lllllllllllllllIlIlIIlllIIIIIlII, final BlockPos lllllllllllllllIlIlIIlllIIIIIIll) {
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation()[lllllllllllllllIlIlIIlllIIIIIlIl.getValue(BlockLever.FACING).ordinal()]) {
            default: {
                return BlockLever.LEVER_EAST_AABB;
            }
            case 3: {
                return BlockLever.LEVER_WEST_AABB;
            }
            case 4: {
                return BlockLever.LEVER_SOUTH_AABB;
            }
            case 5: {
                return BlockLever.LEVER_NORTH_AABB;
            }
            case 6:
            case 7: {
                return BlockLever.LEVER_UP_AABB;
            }
            case 1:
            case 8: {
                return BlockLever.LEVER_DOWN_AABB;
            }
        }
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllllIlIlIIllIllIlIlII, final IBlockAccess lllllllllllllllIlIlIIllIllIlIlll, final BlockPos lllllllllllllllIlIlIIllIllIlIllI, final EnumFacing lllllllllllllllIlIlIIllIllIlIlIl) {
        return lllllllllllllllIlIlIIllIllIlIlII.getValue((IProperty<Boolean>)BlockLever.POWERED) ? 15 : 0;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation() {
        final int[] $switch_TABLE$net$minecraft$block$BlockLever$EnumOrientation = BlockLever.$SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation;
        if ($switch_TABLE$net$minecraft$block$BlockLever$EnumOrientation != null) {
            return $switch_TABLE$net$minecraft$block$BlockLever$EnumOrientation;
        }
        final char lllllllllllllllIlIlIIllIlIlIIlII = (Object)new int[EnumOrientation.values().length];
        try {
            lllllllllllllllIlIlIIllIlIlIIlII[EnumOrientation.DOWN_X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIlII[EnumOrientation.DOWN_Z.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIlII[EnumOrientation.EAST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIlII[EnumOrientation.NORTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIlII[EnumOrientation.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIlII[EnumOrientation.UP_X.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIlII[EnumOrientation.UP_Z.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllllIlIlIIllIlIlIIlII[EnumOrientation.WEST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        return BlockLever.$SWITCH_TABLE$net$minecraft$block$BlockLever$EnumOrientation = (int[])(Object)lllllllllllllllIlIlIIllIlIlIIlII;
    }
    
    public enum EnumOrientation implements IStringSerializable
    {
        WEST("WEST", 2, 2, "west", EnumFacing.WEST), 
        DOWN_X("DOWN_X", 0, 0, "down_x", EnumFacing.DOWN), 
        NORTH("NORTH", 4, 4, "north", EnumFacing.NORTH), 
        DOWN_Z("DOWN_Z", 7, 7, "down_z", EnumFacing.DOWN), 
        SOUTH("SOUTH", 3, 3, "south", EnumFacing.SOUTH);
        
        private final /* synthetic */ EnumFacing facing;
        
        EAST("EAST", 1, 1, "east", EnumFacing.EAST);
        
        private final /* synthetic */ String name;
        private static final /* synthetic */ EnumOrientation[] META_LOOKUP;
        private final /* synthetic */ int meta;
        
        UP_Z("UP_Z", 5, 5, "up_z", EnumFacing.UP), 
        UP_X("UP_X", 6, 6, "up_x", EnumFacing.UP);
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public static EnumOrientation byMetadata(int lllllllllllllIIlIlIIlIIIIlIlIIll) {
            if (lllllllllllllIIlIlIIlIIIIlIlIIll < 0 || lllllllllllllIIlIlIIlIIIIlIlIIll >= EnumOrientation.META_LOOKUP.length) {
                lllllllllllllIIlIlIIlIIIIlIlIIll = 0;
            }
            return EnumOrientation.META_LOOKUP[lllllllllllllIIlIlIIlIIIIlIlIIll];
        }
        
        public EnumFacing getFacing() {
            return this.facing;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = EnumOrientation.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
            if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
            }
            final String lllllllllllllIIlIlIIlIIIIIllIIIl = (Object)new int[EnumFacing.Axis.values().length];
            try {
                lllllllllllllIIlIlIIlIIIIIllIIIl[EnumFacing.Axis.X.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIIlIlIIlIIIIIllIIIl[EnumFacing.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIIlIlIIlIIIIIllIIIl[EnumFacing.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            return EnumOrientation.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllllIIlIlIIlIIIIIllIIIl;
        }
        
        static {
            META_LOOKUP = new EnumOrientation[values().length];
            final double lllllllllllllIIlIlIIlIIIIllllIIl;
            final short lllllllllllllIIlIlIIlIIIIllllIlI = (short)((EnumOrientation[])(Object)(lllllllllllllIIlIlIIlIIIIllllIIl = (double)(Object)values())).length;
            for (String lllllllllllllIIlIlIIlIIIIllllIll = (String)0; lllllllllllllIIlIlIIlIIIIllllIll < lllllllllllllIIlIlIIlIIIIllllIlI; ++lllllllllllllIIlIlIIlIIIIllllIll) {
                final EnumOrientation lllllllllllllIIlIlIIlIIIIlllllIl = lllllllllllllIIlIlIIlIIIIllllIIl[lllllllllllllIIlIlIIlIIIIllllIll];
                EnumOrientation.META_LOOKUP[lllllllllllllIIlIlIIlIIIIlllllIl.getMetadata()] = lllllllllllllIIlIlIIlIIIIlllllIl;
            }
        }
        
        private EnumOrientation(final String lllllllllllllIIlIlIIlIIIIllIllIl, final int lllllllllllllIIlIlIIlIIIIllIllII, final int lllllllllllllIIlIlIIlIIIIllIlIlI, final String lllllllllllllIIlIlIIlIIIIllIlIIl, final EnumFacing lllllllllllllIIlIlIIlIIIIllIllll) {
            this.meta = lllllllllllllIIlIlIIlIIIIllIlIlI;
            this.name = lllllllllllllIIlIlIIlIIIIllIlIIl;
            this.facing = lllllllllllllIIlIlIIlIIIIllIllll;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = EnumOrientation.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final float lllllllllllllIIlIlIIlIIIIIlIllll = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllllIIlIlIIlIIIIIlIllll[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIIlIlIIlIIIIIlIllll[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIIlIlIIlIIIIIlIllll[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllllIIlIlIIlIIIIIlIllll[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllllIIlIlIIlIIIIIlIllll[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllllIIlIlIIlIIIIIlIllll[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return EnumOrientation.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIIlIlIIlIIIIIlIllll;
        }
        
        public static EnumOrientation forFacings(final EnumFacing lllllllllllllIIlIlIIlIIIIlIIIIIl, final EnumFacing lllllllllllllIIlIlIIlIIIIIlllllI) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIlIlIIlIIIIlIIIIIl.ordinal()]) {
                case 1: {
                    switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllIIlIlIIlIIIIIlllllI.getAxis().ordinal()]) {
                        case 1: {
                            return EnumOrientation.DOWN_X;
                        }
                        case 3: {
                            return EnumOrientation.DOWN_Z;
                        }
                        default: {
                            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid entityFacing ").append(lllllllllllllIIlIlIIlIIIIIlllllI).append(" for facing ").append(lllllllllllllIIlIlIIlIIIIlIIIIIl)));
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllIIlIlIIlIIIIIlllllI.getAxis().ordinal()]) {
                        case 1: {
                            return EnumOrientation.UP_X;
                        }
                        case 3: {
                            return EnumOrientation.UP_Z;
                        }
                        default: {
                            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid entityFacing ").append(lllllllllllllIIlIlIIlIIIIIlllllI).append(" for facing ").append(lllllllllllllIIlIlIIlIIIIlIIIIIl)));
                        }
                    }
                    break;
                }
                case 3: {
                    return EnumOrientation.NORTH;
                }
                case 4: {
                    return EnumOrientation.SOUTH;
                }
                case 5: {
                    return EnumOrientation.WEST;
                }
                case 6: {
                    return EnumOrientation.EAST;
                }
                default: {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid facing: ").append(lllllllllllllIIlIlIIlIIIIlIIIIIl)));
                }
            }
        }
    }
}
