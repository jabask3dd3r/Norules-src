package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.creativetab.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class BlockPistonBase extends BlockDirectional
{
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_DOWN_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_UP_AABB;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_WEST_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$material$EnumPushReaction;
    public static final /* synthetic */ PropertyBool EXTENDED;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_EAST_AABB;
    private final /* synthetic */ boolean isSticky;
    protected static final /* synthetic */ AxisAlignedBB PISTON_BASE_SOUTH_AABB;
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllllIIlIIIlIlllIlIIllIl) {
        return !lllllllllllllIIlIIIlIlllIlIIllIl.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED) || lllllllllllllIIlIIIlIlllIlIIllIl.getValue((IProperty<Comparable>)BlockPistonBase.FACING) == EnumFacing.DOWN;
    }
    
    private boolean doMove(final World lllllllllllllIIlIIIlIllIIllIIIll, final BlockPos lllllllllllllIIlIIIlIllIIllIIIlI, final EnumFacing lllllllllllllIIlIIIlIllIIllllIll, final boolean lllllllllllllIIlIIIlIllIIllllIlI) {
        if (!lllllllllllllIIlIIIlIllIIllllIlI) {
            lllllllllllllIIlIIIlIllIIllIIIll.setBlockToAir(lllllllllllllIIlIIIlIllIIllIIIlI.offset(lllllllllllllIIlIIIlIllIIllllIll));
        }
        final BlockPistonStructureHelper lllllllllllllIIlIIIlIllIIllllIIl = new BlockPistonStructureHelper(lllllllllllllIIlIIIlIllIIllIIIll, lllllllllllllIIlIIIlIllIIllIIIlI, lllllllllllllIIlIIIlIllIIllllIll, lllllllllllllIIlIIIlIllIIllllIlI);
        if (!lllllllllllllIIlIIIlIllIIllllIIl.canMove()) {
            return false;
        }
        final List<BlockPos> lllllllllllllIIlIIIlIllIIllllIII = lllllllllllllIIlIIIlIllIIllllIIl.getBlocksToMove();
        final List<IBlockState> lllllllllllllIIlIIIlIllIIlllIlll = (List<IBlockState>)Lists.newArrayList();
        for (int lllllllllllllIIlIIIlIllIIlllIllI = 0; lllllllllllllIIlIIIlIllIIlllIllI < lllllllllllllIIlIIIlIllIIllllIII.size(); ++lllllllllllllIIlIIIlIllIIlllIllI) {
            final BlockPos lllllllllllllIIlIIIlIllIIlllIlIl = lllllllllllllIIlIIIlIllIIllllIII.get(lllllllllllllIIlIIIlIllIIlllIllI);
            lllllllllllllIIlIIIlIllIIlllIlll.add(lllllllllllllIIlIIIlIllIIllIIIll.getBlockState(lllllllllllllIIlIIIlIllIIlllIlIl).getActualState(lllllllllllllIIlIIIlIllIIllIIIll, lllllllllllllIIlIIIlIllIIlllIlIl));
        }
        final List<BlockPos> lllllllllllllIIlIIIlIllIIlllIlII = lllllllllllllIIlIIIlIllIIllllIIl.getBlocksToDestroy();
        int lllllllllllllIIlIIIlIllIIlllIIll = lllllllllllllIIlIIIlIllIIllllIII.size() + lllllllllllllIIlIIIlIllIIlllIlII.size();
        final IBlockState[] lllllllllllllIIlIIIlIllIIlllIIlI = new IBlockState[lllllllllllllIIlIIIlIllIIlllIIll];
        final EnumFacing lllllllllllllIIlIIIlIllIIlllIIIl = lllllllllllllIIlIIIlIllIIllllIlI ? lllllllllllllIIlIIIlIllIIllllIll : lllllllllllllIIlIIIlIllIIllllIll.getOpposite();
        for (int lllllllllllllIIlIIIlIllIIlllIIII = lllllllllllllIIlIIIlIllIIlllIlII.size() - 1; lllllllllllllIIlIIIlIllIIlllIIII >= 0; --lllllllllllllIIlIIIlIllIIlllIIII) {
            final BlockPos lllllllllllllIIlIIIlIllIIllIllll = lllllllllllllIIlIIIlIllIIlllIlII.get(lllllllllllllIIlIIIlIllIIlllIIII);
            final IBlockState lllllllllllllIIlIIIlIllIIllIlllI = lllllllllllllIIlIIIlIllIIllIIIll.getBlockState(lllllllllllllIIlIIIlIllIIllIllll);
            lllllllllllllIIlIIIlIllIIllIlllI.getBlock().dropBlockAsItem(lllllllllllllIIlIIIlIllIIllIIIll, lllllllllllllIIlIIIlIllIIllIllll, lllllllllllllIIlIIIlIllIIllIlllI, 0);
            lllllllllllllIIlIIIlIllIIllIIIll.setBlockState(lllllllllllllIIlIIIlIllIIllIllll, Blocks.AIR.getDefaultState(), 4);
            --lllllllllllllIIlIIIlIllIIlllIIll;
            lllllllllllllIIlIIIlIllIIlllIIlI[lllllllllllllIIlIIIlIllIIlllIIll] = lllllllllllllIIlIIIlIllIIllIlllI;
        }
        for (int lllllllllllllIIlIIIlIllIIllIllIl = lllllllllllllIIlIIIlIllIIllllIII.size() - 1; lllllllllllllIIlIIIlIllIIllIllIl >= 0; --lllllllllllllIIlIIIlIllIIllIllIl) {
            BlockPos lllllllllllllIIlIIIlIllIIllIllII = lllllllllllllIIlIIIlIllIIllllIII.get(lllllllllllllIIlIIIlIllIIllIllIl);
            final IBlockState lllllllllllllIIlIIIlIllIIllIlIll = lllllllllllllIIlIIIlIllIIllIIIll.getBlockState(lllllllllllllIIlIIIlIllIIllIllII);
            lllllllllllllIIlIIIlIllIIllIIIll.setBlockState(lllllllllllllIIlIIIlIllIIllIllII, Blocks.AIR.getDefaultState(), 2);
            lllllllllllllIIlIIIlIllIIllIllII = lllllllllllllIIlIIIlIllIIllIllII.offset(lllllllllllllIIlIIIlIllIIlllIIIl);
            lllllllllllllIIlIIIlIllIIllIIIll.setBlockState(lllllllllllllIIlIIIlIllIIllIllII, Blocks.PISTON_EXTENSION.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, lllllllllllllIIlIIIlIllIIllllIll), 4);
            lllllllllllllIIlIIIlIllIIllIIIll.setTileEntity(lllllllllllllIIlIIIlIllIIllIllII, BlockPistonMoving.createTilePiston(lllllllllllllIIlIIIlIllIIlllIlll.get(lllllllllllllIIlIIIlIllIIllIllIl), lllllllllllllIIlIIIlIllIIllllIll, lllllllllllllIIlIIIlIllIIllllIlI, false));
            --lllllllllllllIIlIIIlIllIIlllIIll;
            lllllllllllllIIlIIIlIllIIlllIIlI[lllllllllllllIIlIIIlIllIIlllIIll] = lllllllllllllIIlIIIlIllIIllIlIll;
        }
        final BlockPos lllllllllllllIIlIIIlIllIIllIlIlI = lllllllllllllIIlIIIlIllIIllIIIlI.offset(lllllllllllllIIlIIIlIllIIllllIll);
        if (lllllllllllllIIlIIIlIllIIllllIlI) {
            final BlockPistonExtension.EnumPistonType lllllllllllllIIlIIIlIllIIllIlIIl = this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT;
            final IBlockState lllllllllllllIIlIIIlIllIIllIlIII = Blocks.PISTON_HEAD.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, lllllllllllllIIlIIIlIllIIllllIll).withProperty(BlockPistonExtension.TYPE, lllllllllllllIIlIIIlIllIIllIlIIl);
            final IBlockState lllllllllllllIIlIIIlIllIIllIIlll = Blocks.PISTON_EXTENSION.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, lllllllllllllIIlIIIlIllIIllllIll).withProperty(BlockPistonMoving.TYPE, this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
            lllllllllllllIIlIIIlIllIIllIIIll.setBlockState(lllllllllllllIIlIIIlIllIIllIlIlI, lllllllllllllIIlIIIlIllIIllIIlll, 4);
            lllllllllllllIIlIIIlIllIIllIIIll.setTileEntity(lllllllllllllIIlIIIlIllIIllIlIlI, BlockPistonMoving.createTilePiston(lllllllllllllIIlIIIlIllIIllIlIII, lllllllllllllIIlIIIlIllIIllllIll, true, true));
        }
        for (int lllllllllllllIIlIIIlIllIIllIIllI = lllllllllllllIIlIIIlIllIIlllIlII.size() - 1; lllllllllllllIIlIIIlIllIIllIIllI >= 0; --lllllllllllllIIlIIIlIllIIllIIllI) {
            lllllllllllllIIlIIIlIllIIllIIIll.notifyNeighborsOfStateChange(lllllllllllllIIlIIIlIllIIlllIlII.get(lllllllllllllIIlIIIlIllIIllIIllI), lllllllllllllIIlIIIlIllIIlllIIlI[lllllllllllllIIlIIIlIllIIlllIIll++].getBlock(), false);
        }
        for (int lllllllllllllIIlIIIlIllIIllIIlIl = lllllllllllllIIlIIIlIllIIllllIII.size() - 1; lllllllllllllIIlIIIlIllIIllIIlIl >= 0; --lllllllllllllIIlIIIlIllIIllIIlIl) {
            lllllllllllllIIlIIIlIllIIllIIIll.notifyNeighborsOfStateChange(lllllllllllllIIlIIIlIllIIllllIII.get(lllllllllllllIIlIIIlIllIIllIIlIl), lllllllllllllIIlIIIlIllIIlllIIlI[lllllllllllllIIlIIIlIllIIlllIIll++].getBlock(), false);
        }
        if (lllllllllllllIIlIIIlIllIIllllIlI) {
            lllllllllllllIIlIIIlIllIIllIIIll.notifyNeighborsOfStateChange(lllllllllllllIIlIIIlIllIIllIlIlI, Blocks.PISTON_HEAD, false);
        }
        return true;
    }
    
    public BlockPistonBase(final boolean lllllllllllllIIlIIIlIlllIlIlllIl) {
        super(Material.PISTON);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, false));
        this.isSticky = lllllllllllllIIlIIIlIlllIlIlllIl;
        this.setSoundType(SoundType.STONE);
        this.setHardness(0.5f);
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIlIIIlIllIIIIIllIl, IBlockState lllllllllllllIIlIIIlIllIIIIIIIll, final BlockPos lllllllllllllIIlIIIlIllIIIIIlIlI, final EnumFacing lllllllllllllIIlIIIlIllIIIIIlIIl) {
        lllllllllllllIIlIIIlIllIIIIIIIll = (short)this.getActualState((IBlockState)lllllllllllllIIlIIIlIllIIIIIIIll, lllllllllllllIIlIIIlIllIIIIIllIl, lllllllllllllIIlIIIlIllIIIIIlIlI);
        return (((IBlockState)lllllllllllllIIlIIIlIllIIIIIIIll).getValue((IProperty<Comparable>)BlockPistonBase.FACING) != lllllllllllllIIlIIIlIllIIIIIlIIl.getOpposite() && ((IBlockState)lllllllllllllIIlIIIlIllIIIIIIIll).getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIlIIIlIllIIlIIIIlI) {
        int lllllllllllllIIlIIIlIllIIlIIIIll = 0;
        lllllllllllllIIlIIIlIllIIlIIIIll |= lllllllllllllIIlIIIlIllIIlIIIIlI.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING).getIndex();
        if (lllllllllllllIIlIIIlIllIIlIIIIlI.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            lllllllllllllIIlIIIlIllIIlIIIIll |= 0x8;
        }
        return lllllllllllllIIlIIIlIllIIlIIIIll;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIlIIIlIllIIIllIlIl, final Rotation lllllllllllllIIlIIIlIllIIIllIlII) {
        return lllllllllllllIIlIIIlIllIIIllIlIl.withProperty((IProperty<Comparable>)BlockPistonBase.FACING, lllllllllllllIIlIIIlIllIIIllIlII.rotate(lllllllllllllIIlIIIlIllIIIllIlIl.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING)));
    }
    
    private void checkForMove(final World lllllllllllllIIlIIIlIllIllllIIlI, final BlockPos lllllllllllllIIlIIIlIllIllllIlll, final IBlockState lllllllllllllIIlIIIlIllIllllIIII) {
        final EnumFacing lllllllllllllIIlIIIlIllIllllIlIl = lllllllllllllIIlIIIlIllIllllIIII.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING);
        final boolean lllllllllllllIIlIIIlIllIllllIlII = this.shouldBeExtended(lllllllllllllIIlIIIlIllIllllIIlI, lllllllllllllIIlIIIlIllIllllIlll, lllllllllllllIIlIIIlIllIllllIlIl);
        if (lllllllllllllIIlIIIlIllIllllIlII && !lllllllllllllIIlIIIlIllIllllIIII.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            if (new BlockPistonStructureHelper(lllllllllllllIIlIIIlIllIllllIIlI, lllllllllllllIIlIIIlIllIllllIlll, lllllllllllllIIlIIIlIllIllllIlIl, true).canMove()) {
                lllllllllllllIIlIIIlIllIllllIIlI.addBlockEvent(lllllllllllllIIlIIIlIllIllllIlll, this, 0, lllllllllllllIIlIIIlIllIllllIlIl.getIndex());
            }
        }
        else if (!lllllllllllllIIlIIIlIllIllllIlII && lllllllllllllIIlIIIlIllIllllIIII.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            lllllllllllllIIlIIIlIllIllllIIlI.addBlockEvent(lllllllllllllIIlIIIlIllIllllIlll, this, 1, lllllllllllllIIlIIIlIllIllllIlIl.getIndex());
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIlIIIlIllIIIlIlIIl, final Mirror lllllllllllllIIlIIIlIllIIIlIlIlI) {
        return lllllllllllllIIlIIIlIllIIIlIlIIl.withRotation(lllllllllllllIIlIIIlIllIIIlIlIlI.toRotation(lllllllllllllIIlIIIlIllIIIlIlIIl.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING)));
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllllIIlIIIlIlllIIllllll, final World lllllllllllllIIlIIIlIlllIlIIIlIl, final BlockPos lllllllllllllIIlIIIlIlllIIllllIl, final AxisAlignedBB lllllllllllllIIlIIIlIlllIlIIIIll, final List<AxisAlignedBB> lllllllllllllIIlIIIlIlllIlIIIIlI, @Nullable final Entity lllllllllllllIIlIIIlIlllIlIIIIIl, final boolean lllllllllllllIIlIIIlIlllIlIIIIII) {
        Block.addCollisionBoxToList(lllllllllllllIIlIIIlIlllIIllllIl, lllllllllllllIIlIIIlIlllIlIIIIll, lllllllllllllIIlIIIlIlllIlIIIIlI, lllllllllllllIIlIIIlIlllIIllllll.getBoundingBox(lllllllllllllIIlIIIlIlllIlIIIlIl, lllllllllllllIIlIIIlIlllIIllllIl));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIlIIIlIlllIlIlIIIl, final IBlockAccess lllllllllllllIIlIIIlIlllIlIlIIll, final BlockPos lllllllllllllIIlIIIlIlllIlIlIIlI) {
        if (!lllllllllllllIIlIIIlIlllIlIlIIIl.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            return BlockPistonBase.FULL_BLOCK_AABB;
        }
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIlIIIlIlllIlIlIIIl.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING).ordinal()]) {
            case 1: {
                return BlockPistonBase.PISTON_BASE_DOWN_AABB;
            }
            default: {
                return BlockPistonBase.PISTON_BASE_UP_AABB;
            }
            case 3: {
                return BlockPistonBase.PISTON_BASE_NORTH_AABB;
            }
            case 4: {
                return BlockPistonBase.PISTON_BASE_SOUTH_AABB;
            }
            case 5: {
                return BlockPistonBase.PISTON_BASE_WEST_AABB;
            }
            case 6: {
                return BlockPistonBase.PISTON_BASE_EAST_AABB;
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPistonBase.FACING, BlockPistonBase.EXTENDED });
    }
    
    @Override
    public boolean eventReceived(final IBlockState lllllllllllllIIlIIIlIllIllIIIlll, final World lllllllllllllIIlIIIlIllIlIllIlll, final BlockPos lllllllllllllIIlIIIlIllIlIllIllI, final int lllllllllllllIIlIIIlIllIlIllIlIl, final int lllllllllllllIIlIIIlIllIllIIIIll) {
        final EnumFacing lllllllllllllIIlIIIlIllIllIIIIlI = lllllllllllllIIlIIIlIllIllIIIlll.getValue((IProperty<EnumFacing>)BlockPistonBase.FACING);
        if (!lllllllllllllIIlIIIlIllIlIllIlll.isRemote) {
            final boolean lllllllllllllIIlIIIlIllIllIIIIIl = this.shouldBeExtended(lllllllllllllIIlIIIlIllIlIllIlll, lllllllllllllIIlIIIlIllIlIllIllI, lllllllllllllIIlIIIlIllIllIIIIlI);
            if (lllllllllllllIIlIIIlIllIllIIIIIl && lllllllllllllIIlIIIlIllIlIllIlIl == 1) {
                lllllllllllllIIlIIIlIllIlIllIlll.setBlockState(lllllllllllllIIlIIIlIllIlIllIllI, lllllllllllllIIlIIIlIllIllIIIlll.withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, true), 2);
                return false;
            }
            if (!lllllllllllllIIlIIIlIllIllIIIIIl && lllllllllllllIIlIIIlIllIlIllIlIl == 0) {
                return false;
            }
        }
        if (lllllllllllllIIlIIIlIllIlIllIlIl == 0) {
            if (!this.doMove(lllllllllllllIIlIIIlIllIlIllIlll, lllllllllllllIIlIIIlIllIlIllIllI, lllllllllllllIIlIIIlIllIllIIIIlI, true)) {
                return false;
            }
            lllllllllllllIIlIIIlIllIlIllIlll.setBlockState(lllllllllllllIIlIIIlIllIlIllIllI, lllllllllllllIIlIIIlIllIllIIIlll.withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, true), 3);
            lllllllllllllIIlIIIlIllIlIllIlll.playSound(null, lllllllllllllIIlIIIlIllIlIllIllI, SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.BLOCKS, 0.5f, lllllllllllllIIlIIIlIllIlIllIlll.rand.nextFloat() * 0.25f + 0.6f);
        }
        else if (lllllllllllllIIlIIIlIllIlIllIlIl == 1) {
            final TileEntity lllllllllllllIIlIIIlIllIllIIIIII = lllllllllllllIIlIIIlIllIlIllIlll.getTileEntity(lllllllllllllIIlIIIlIllIlIllIllI.offset(lllllllllllllIIlIIIlIllIllIIIIlI));
            if (lllllllllllllIIlIIIlIllIllIIIIII instanceof TileEntityPiston) {
                ((TileEntityPiston)lllllllllllllIIlIIIlIllIllIIIIII).clearPistonTileEntity();
            }
            lllllllllllllIIlIIIlIllIlIllIlll.setBlockState(lllllllllllllIIlIIIlIllIlIllIllI, Blocks.PISTON_EXTENSION.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, lllllllllllllIIlIIIlIllIllIIIIlI).withProperty(BlockPistonMoving.TYPE, this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT), 3);
            lllllllllllllIIlIIIlIllIlIllIlll.setTileEntity(lllllllllllllIIlIIIlIllIlIllIllI, BlockPistonMoving.createTilePiston(this.getStateFromMeta(lllllllllllllIIlIIIlIllIllIIIIll), lllllllllllllIIlIIIlIllIllIIIIlI, false, true));
            if (this.isSticky) {
                final BlockPos lllllllllllllIIlIIIlIllIlIllllll = lllllllllllllIIlIIIlIllIlIllIllI.add(lllllllllllllIIlIIIlIllIllIIIIlI.getFrontOffsetX() * 2, lllllllllllllIIlIIIlIllIllIIIIlI.getFrontOffsetY() * 2, lllllllllllllIIlIIIlIllIllIIIIlI.getFrontOffsetZ() * 2);
                final IBlockState lllllllllllllIIlIIIlIllIlIlllllI = lllllllllllllIIlIIIlIllIlIllIlll.getBlockState(lllllllllllllIIlIIIlIllIlIllllll);
                final Block lllllllllllllIIlIIIlIllIlIllllIl = lllllllllllllIIlIIIlIllIlIlllllI.getBlock();
                boolean lllllllllllllIIlIIIlIllIlIllllII = false;
                if (lllllllllllllIIlIIIlIllIlIllllIl == Blocks.PISTON_EXTENSION) {
                    final TileEntity lllllllllllllIIlIIIlIllIlIlllIll = lllllllllllllIIlIIIlIllIlIllIlll.getTileEntity(lllllllllllllIIlIIIlIllIlIllllll);
                    if (lllllllllllllIIlIIIlIllIlIlllIll instanceof TileEntityPiston) {
                        final TileEntityPiston lllllllllllllIIlIIIlIllIlIlllIlI = (TileEntityPiston)lllllllllllllIIlIIIlIllIlIlllIll;
                        if (lllllllllllllIIlIIIlIllIlIlllIlI.getFacing() == lllllllllllllIIlIIIlIllIllIIIIlI && lllllllllllllIIlIIIlIllIlIlllIlI.isExtending()) {
                            lllllllllllllIIlIIIlIllIlIlllIlI.clearPistonTileEntity();
                            lllllllllllllIIlIIIlIllIlIllllII = true;
                        }
                    }
                }
                if (!lllllllllllllIIlIIIlIllIlIllllII && lllllllllllllIIlIIIlIllIlIlllllI.getMaterial() != Material.AIR && canPush(lllllllllllllIIlIIIlIllIlIlllllI, lllllllllllllIIlIIIlIllIlIllIlll, lllllllllllllIIlIIIlIllIlIllllll, lllllllllllllIIlIIIlIllIllIIIIlI.getOpposite(), false, lllllllllllllIIlIIIlIllIllIIIIlI) && (lllllllllllllIIlIIIlIllIlIlllllI.getMobilityFlag() == EnumPushReaction.NORMAL || lllllllllllllIIlIIIlIllIlIllllIl == Blocks.PISTON || lllllllllllllIIlIIIlIllIlIllllIl == Blocks.STICKY_PISTON)) {
                    this.doMove(lllllllllllllIIlIIIlIllIlIllIlll, lllllllllllllIIlIIIlIllIlIllIllI, lllllllllllllIIlIIIlIllIllIIIIlI, false);
                }
            }
            else {
                lllllllllllllIIlIIIlIllIlIllIlll.setBlockToAir(lllllllllllllIIlIIIlIllIlIllIllI.offset(lllllllllllllIIlIIIlIllIllIIIIlI));
            }
            lllllllllllllIIlIIIlIllIlIllIlll.playSound(null, lllllllllllllIIlIIIlIllIlIllIllI, SoundEvents.BLOCK_PISTON_CONTRACT, SoundCategory.BLOCKS, 0.5f, lllllllllllllIIlIIIlIllIlIllIlll.rand.nextFloat() * 0.15f + 0.6f);
        }
        return true;
    }
    
    static {
        EXTENDED = PropertyBool.create("extended");
        PISTON_BASE_EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.75, 1.0, 1.0);
        PISTON_BASE_WEST_AABB = new AxisAlignedBB(0.25, 0.0, 0.0, 1.0, 1.0, 1.0);
        PISTON_BASE_SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.75);
        PISTON_BASE_NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 1.0, 1.0);
        PISTON_BASE_UP_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
        PISTON_BASE_DOWN_AABB = new AxisAlignedBB(0.0, 0.25, 0.0, 1.0, 1.0, 1.0);
    }
    
    @Nullable
    public static EnumFacing getFacing(final int lllllllllllllIIlIIIlIllIlIlIIlIl) {
        final int lllllllllllllIIlIIIlIllIlIlIIllI = lllllllllllllIIlIIIlIllIlIlIIlIl & 0x7;
        return (lllllllllllllIIlIIIlIllIlIlIIllI > 5) ? null : EnumFacing.getFront(lllllllllllllIIlIIIlIllIlIlIIllI);
    }
    
    public static boolean canPush(final IBlockState lllllllllllllIIlIIIlIllIlIIlllII, final World lllllllllllllIIlIIIlIllIlIIllIll, final BlockPos lllllllllllllIIlIIIlIllIlIIlIIll, final EnumFacing lllllllllllllIIlIIIlIllIlIIlIIlI, final boolean lllllllllllllIIlIIIlIllIlIIllIII, final EnumFacing lllllllllllllIIlIIIlIllIlIIlIlll) {
        final Block lllllllllllllIIlIIIlIllIlIIlIllI = lllllllllllllIIlIIIlIllIlIIlllII.getBlock();
        if (lllllllllllllIIlIIIlIllIlIIlIllI == Blocks.OBSIDIAN) {
            return false;
        }
        if (!lllllllllllllIIlIIIlIllIlIIllIll.getWorldBorder().contains(lllllllllllllIIlIIIlIllIlIIlIIll)) {
            return false;
        }
        if (lllllllllllllIIlIIIlIllIlIIlIIll.getY() < 0 || (lllllllllllllIIlIIIlIllIlIIlIIlI == EnumFacing.DOWN && lllllllllllllIIlIIIlIllIlIIlIIll.getY() == 0)) {
            return false;
        }
        if (lllllllllllllIIlIIIlIllIlIIlIIll.getY() <= lllllllllllllIIlIIIlIllIlIIllIll.getHeight() - 1 && (lllllllllllllIIlIIIlIllIlIIlIIlI != EnumFacing.UP || lllllllllllllIIlIIIlIllIlIIlIIll.getY() != lllllllllllllIIlIIIlIllIlIIllIll.getHeight() - 1)) {
            if (lllllllllllllIIlIIIlIllIlIIlIllI != Blocks.PISTON && lllllllllllllIIlIIIlIllIlIIlIllI != Blocks.STICKY_PISTON) {
                if (lllllllllllllIIlIIIlIllIlIIlllII.getBlockHardness(lllllllllllllIIlIIIlIllIlIIllIll, lllllllllllllIIlIIIlIllIlIIlIIll) == -1.0f) {
                    return false;
                }
                switch ($SWITCH_TABLE$net$minecraft$block$material$EnumPushReaction()[lllllllllllllIIlIIIlIllIlIIlllII.getMobilityFlag().ordinal()]) {
                    case 3: {
                        return false;
                    }
                    case 2: {
                        return lllllllllllllIIlIIIlIllIlIIllIII;
                    }
                    case 5: {
                        return lllllllllllllIIlIIIlIllIlIIlIIlI == lllllllllllllIIlIIIlIllIlIIlIlll;
                    }
                }
            }
            else if (lllllllllllllIIlIIIlIllIlIIlllII.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
                return false;
            }
            return !lllllllllllllIIlIIIlIllIlIIlIllI.hasTileEntity();
        }
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIlIIIlIllIIlIIllII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, getFacing(lllllllllllllIIlIIIlIllIIlIIllII)).withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, (lllllllllllllIIlIIIlIllIIlIIllII & 0x8) > 0);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockPistonBase.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final boolean lllllllllllllIIlIIIlIlIlllllIllI = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIIlIIIlIlIlllllIllI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlIIIlIlIlllllIllI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlIIIlIlIlllllIllI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIlIIIlIlIlllllIllI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIlIIIlIlIlllllIllI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIlIIIlIlIlllllIllI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockPistonBase.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIIlIIIlIlIlllllIllI;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIIlIIIlIlllIIIIlIlI, final BlockPos lllllllllllllIIlIIIlIlllIIIIIIIl, final EnumFacing lllllllllllllIIlIIIlIlllIIIIlIII, final float lllllllllllllIIlIIIlIlllIIIIIlll, final float lllllllllllllIIlIIIlIlllIIIIIllI, final float lllllllllllllIIlIIIlIlllIIIIIlIl, final int lllllllllllllIIlIIIlIlllIIIIIlII, final EntityLivingBase lllllllllllllIIlIIIlIlllIIIIIIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.func_190914_a(lllllllllllllIIlIIIlIlllIIIIIIIl, lllllllllllllIIlIIIlIlllIIIIIIll)).withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, false);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$material$EnumPushReaction() {
        final int[] $switch_TABLE$net$minecraft$block$material$EnumPushReaction = BlockPistonBase.$SWITCH_TABLE$net$minecraft$block$material$EnumPushReaction;
        if ($switch_TABLE$net$minecraft$block$material$EnumPushReaction != null) {
            return $switch_TABLE$net$minecraft$block$material$EnumPushReaction;
        }
        final Exception lllllllllllllIIlIIIlIlIllllIlllI = (Object)new int[EnumPushReaction.values().length];
        try {
            lllllllllllllIIlIIIlIlIllllIlllI[EnumPushReaction.BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlIIIlIlIllllIlllI[EnumPushReaction.DESTROY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlIIIlIlIllllIlllI[EnumPushReaction.IGNORE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIlIIIlIlIllllIlllI[EnumPushReaction.NORMAL.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIlIIIlIlIllllIlllI[EnumPushReaction.PUSH_ONLY.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return BlockPistonBase.$SWITCH_TABLE$net$minecraft$block$material$EnumPushReaction = (int[])(Object)lllllllllllllIIlIIIlIlIllllIlllI;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIIlIIIlIlllIIIlIlIl, final BlockPos lllllllllllllIIlIIIlIlllIIIlIlII, final IBlockState lllllllllllllIIlIIIlIlllIIIlIIll) {
        if (!lllllllllllllIIlIIIlIlllIIIlIlIl.isRemote && lllllllllllllIIlIIIlIlllIIIlIlIl.getTileEntity(lllllllllllllIIlIIIlIlllIIIlIlII) == null) {
            this.checkForMove(lllllllllllllIIlIIIlIlllIIIlIlIl, lllllllllllllIIlIIIlIlllIIIlIlII, lllllllllllllIIlIIIlIlllIIIlIIll);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIlIIIlIlllIIlllIIl) {
        return false;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIlIIIlIllIlIlIlIlI) {
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIlIIIlIlllIIIlllIl, final World lllllllllllllIIlIIIlIlllIIIlllII, final BlockPos lllllllllllllIIlIIIlIlllIIlIIIIl, final Block lllllllllllllIIlIIIlIlllIIlIIIII, final BlockPos lllllllllllllIIlIIIlIlllIIIlllll) {
        if (!lllllllllllllIIlIIIlIlllIIIlllII.isRemote) {
            this.checkForMove(lllllllllllllIIlIIIlIlllIIIlllII, lllllllllllllIIlIIIlIlllIIlIIIIl, lllllllllllllIIlIIIlIlllIIIlllIl);
        }
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllIIlIIIlIlllIIllIIlI, final BlockPos lllllllllllllIIlIIIlIlllIIllIIIl, final IBlockState lllllllllllllIIlIIIlIlllIIllIIII, final EntityLivingBase lllllllllllllIIlIIIlIlllIIlIlIIl, final ItemStack lllllllllllllIIlIIIlIlllIIlIlllI) {
        lllllllllllllIIlIIIlIlllIIllIIlI.setBlockState(lllllllllllllIIlIIIlIlllIIllIIIl, lllllllllllllIIlIIIlIlllIIllIIII.withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.func_190914_a(lllllllllllllIIlIIIlIlllIIllIIIl, lllllllllllllIIlIIIlIlllIIlIlIIl)), 2);
        if (!lllllllllllllIIlIIIlIlllIIllIIlI.isRemote) {
            this.checkForMove(lllllllllllllIIlIIIlIlllIIllIIlI, lllllllllllllIIlIIIlIlllIIllIIIl, lllllllllllllIIlIIIlIlllIIllIIII);
        }
    }
    
    private boolean shouldBeExtended(final World lllllllllllllIIlIIIlIllIlllIIlII, final BlockPos lllllllllllllIIlIIIlIllIlllIIIll, final EnumFacing lllllllllllllIIlIIIlIllIlllIIIlI) {
        long lllllllllllllIIlIIIlIllIllIllIII;
        boolean lllllllllllllIIlIIIlIllIllIllIIl = ((EnumFacing[])(Object)(lllllllllllllIIlIIIlIllIllIllIII = (long)(Object)EnumFacing.values())).length != 0;
        for (final EnumFacing lllllllllllllIIlIIIlIllIlllIIIIl : lllllllllllllIIlIIIlIllIllIllIII) {
            if (lllllllllllllIIlIIIlIllIlllIIIIl != lllllllllllllIIlIIIlIllIlllIIIlI && lllllllllllllIIlIIIlIllIlllIIlII.isSidePowered(lllllllllllllIIlIIIlIllIlllIIIll.offset(lllllllllllllIIlIIIlIllIlllIIIIl), lllllllllllllIIlIIIlIllIlllIIIIl)) {
                return true;
            }
        }
        if (lllllllllllllIIlIIIlIllIlllIIlII.isSidePowered(lllllllllllllIIlIIIlIllIlllIIIll, EnumFacing.DOWN)) {
            return true;
        }
        final BlockPos lllllllllllllIIlIIIlIllIlllIIIII = lllllllllllllIIlIIIlIllIlllIIIll.up();
        double lllllllllllllIIlIIIlIllIllIlIlll;
        EnumFacing lllllllllllllIIlIIIlIllIllIlllll;
        for (lllllllllllllIIlIIIlIllIllIllIII = ((EnumFacing[])(Object)(lllllllllllllIIlIIIlIllIllIlIlll = (double)(Object)EnumFacing.values())).length, lllllllllllllIIlIIIlIllIllIllIIl = (0 != 0); (lllllllllllllIIlIIIlIllIllIllIIl ? 1 : 0) < lllllllllllllIIlIIIlIllIllIllIII; ++lllllllllllllIIlIIIlIllIllIllIIl) {
            lllllllllllllIIlIIIlIllIllIlllll = lllllllllllllIIlIIIlIllIllIlIlll[lllllllllllllIIlIIIlIllIllIllIIl];
            if (lllllllllllllIIlIIIlIllIllIlllll != EnumFacing.DOWN && lllllllllllllIIlIIIlIllIlllIIlII.isSidePowered(lllllllllllllIIlIIIlIllIlllIIIII.offset(lllllllllllllIIlIIIlIllIllIlllll), lllllllllllllIIlIIIlIllIllIlllll)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean causesSuffocation(final IBlockState lllllllllllllIIlIIIlIlllIlIlIlll) {
        return !lllllllllllllIIlIIIlIlllIlIlIlll.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED);
    }
}
