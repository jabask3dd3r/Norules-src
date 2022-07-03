package net.minecraft.block;

import net.minecraft.block.state.pattern.*;
import net.minecraft.block.properties.*;
import com.google.common.base.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class BlockEndPortalFrame extends Block
{
    private static /* synthetic */ BlockPattern portalShape;
    public static final /* synthetic */ PropertyBool EYE;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB AABB_EYE;
    protected static final /* synthetic */ AxisAlignedBB AABB_BLOCK;
    
    public static BlockPattern getOrCreatePortalShape() {
        if (BlockEndPortalFrame.portalShape == null) {
            BlockEndPortalFrame.portalShape = FactoryBlockPattern.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?").where('?', BlockWorldState.hasState(BlockStateMatcher.ANY)).where('^', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.END_PORTAL_FRAME).where((IProperty<Comparable>)BlockEndPortalFrame.EYE, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)true)).where((IProperty<Comparable>)BlockEndPortalFrame.FACING, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)EnumFacing.SOUTH)))).where('>', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.END_PORTAL_FRAME).where((IProperty<Comparable>)BlockEndPortalFrame.EYE, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)true)).where((IProperty<Comparable>)BlockEndPortalFrame.FACING, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)EnumFacing.WEST)))).where('v', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.END_PORTAL_FRAME).where((IProperty<Comparable>)BlockEndPortalFrame.EYE, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)true)).where((IProperty<Comparable>)BlockEndPortalFrame.FACING, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)EnumFacing.NORTH)))).where('<', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.END_PORTAL_FRAME).where((IProperty<Comparable>)BlockEndPortalFrame.EYE, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)true)).where((IProperty<Comparable>)BlockEndPortalFrame.FACING, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)EnumFacing.EAST)))).build();
        }
        return BlockEndPortalFrame.portalShape;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIlIIIIIlIlIlIIIII) {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIlIIIIIlIIllIllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, (lllllllllllllIIIlIIIIIlIIllIllll & 0x4) != 0x0).withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.getHorizontal(lllllllllllllIIIlIIIIIlIIllIllll & 0x3));
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIIlIIIIIlIIllIIIII, final Rotation lllllllllllllIIIlIIIIIlIIllIIIIl) {
        return lllllllllllllIIIlIIIIIlIIllIIIII.withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, lllllllllllllIIIlIIIIIlIIllIIIIl.rotate(lllllllllllllIIIlIIIIIlIIllIIIII.getValue((IProperty<EnumFacing>)BlockEndPortalFrame.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIlIIIIIlIIllIIlll) {
        int lllllllllllllIIIlIIIIIlIIllIlIII = 0;
        lllllllllllllIIIlIIIIIlIIllIlIII |= lllllllllllllIIIlIIIIIlIIllIIlll.getValue((IProperty<EnumFacing>)BlockEndPortalFrame.FACING).getHorizontalIndex();
        if (lllllllllllllIIIlIIIIIlIIllIIlll.getValue((IProperty<Boolean>)BlockEndPortalFrame.EYE)) {
            lllllllllllllIIIlIIIIIlIIllIlIII |= 0x4;
        }
        return lllllllllllllIIIlIIIIIlIIllIlIII;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIIlIIIIIlIIlIlIIll) {
        return false;
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        EYE = PropertyBool.create("eye");
        AABB_BLOCK = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0);
        AABB_EYE = new AxisAlignedBB(0.3125, 0.8125, 0.3125, 0.6875, 1.0, 0.6875);
    }
    
    public BlockEndPortalFrame() {
        super(Material.ROCK, MapColor.GREEN);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, false));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIIlIIIIIlIlIIllllI, final IBlockAccess lllllllllllllIIIlIIIIIlIlIIlllIl, final BlockPos lllllllllllllIIIlIIIIIlIlIIlllII) {
        return BlockEndPortalFrame.AABB_BLOCK;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIIlIIIIIlIlIIIlIlI, final Random lllllllllllllIIIlIIIIIlIlIIIlIIl, final int lllllllllllllIIIlIIIIIlIlIIIlIII) {
        return Items.field_190931_a;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllIIIlIIIIIlIIlllIIll, final World lllllllllllllIIIlIIIIIlIIlllIlIl, final BlockPos lllllllllllllIIIlIIIIIlIIlllIlII) {
        return lllllllllllllIIIlIIIIIlIIlllIIll.getValue((IProperty<Boolean>)BlockEndPortalFrame.EYE) ? 15 : 0;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIIlIIIIIlIIlIlIIII, final IBlockState lllllllllllllIIIlIIIIIlIIlIIllll, final BlockPos lllllllllllllIIIlIIIIIlIIlIIlllI, final EnumFacing lllllllllllllIIIlIIIIIlIIlIIllII) {
        return (lllllllllllllIIIlIIIIIlIIlIIllII == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllllIIIlIIIIIlIlIIlIllI, final World lllllllllllllIIIlIIIIIlIlIIIllll, final BlockPos lllllllllllllIIIlIIIIIlIlIIIlllI, final AxisAlignedBB lllllllllllllIIIlIIIIIlIlIIIllIl, final List<AxisAlignedBB> lllllllllllllIIIlIIIIIlIlIIIllII, @Nullable final Entity lllllllllllllIIIlIIIIIlIlIIlIIIl, final boolean lllllllllllllIIIlIIIIIlIlIIlIIII) {
        Block.addCollisionBoxToList(lllllllllllllIIIlIIIIIlIlIIIlllI, lllllllllllllIIIlIIIIIlIlIIIllIl, lllllllllllllIIIlIIIIIlIlIIIllII, BlockEndPortalFrame.AABB_BLOCK);
        if (lllllllllllllIIIlIIIIIlIlIIIllll.getBlockState(lllllllllllllIIIlIIIIIlIlIIIlllI).getValue((IProperty<Boolean>)BlockEndPortalFrame.EYE)) {
            Block.addCollisionBoxToList(lllllllllllllIIIlIIIIIlIlIIIlllI, lllllllllllllIIIlIIIIIlIlIIIllIl, lllllllllllllIIIlIIIIIlIlIIIllII, BlockEndPortalFrame.AABB_EYE);
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockEndPortalFrame.FACING, BlockEndPortalFrame.EYE });
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIIlIIIIIlIIlIllIIl, final Mirror lllllllllllllIIIlIIIIIlIIlIllIII) {
        return lllllllllllllIIIlIIIIIlIIlIllIIl.withRotation(lllllllllllllIIIlIIIIIlIIlIllIII.toRotation(lllllllllllllIIIlIIIIIlIIlIllIIl.getValue((IProperty<EnumFacing>)BlockEndPortalFrame.FACING)));
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIIIlIIIIIlIlIIIIlII, final BlockPos lllllllllllllIIIlIIIIIlIlIIIIIll, final EnumFacing lllllllllllllIIIlIIIIIlIlIIIIIlI, final float lllllllllllllIIIlIIIIIlIlIIIIIIl, final float lllllllllllllIIIlIIIIIlIlIIIIIII, final float lllllllllllllIIIlIIIIIlIIlllllll, final int lllllllllllllIIIlIIIIIlIIllllllI, final EntityLivingBase lllllllllllllIIIlIIIIIlIIllllIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, lllllllllllllIIIlIIIIIlIIllllIll.getHorizontalFacing().getOpposite()).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, false);
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllIIIlIIIIIlIIllllIIl) {
        return true;
    }
}
