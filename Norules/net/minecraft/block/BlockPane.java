package net.minecraft.block;

import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class BlockPane extends Block
{
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool NORTH;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    public static final /* synthetic */ PropertyBool WEST;
    private final /* synthetic */ boolean canDrop;
    protected static final /* synthetic */ AxisAlignedBB[] AABB_BY_INDEX;
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllllllIIlIIIIlIllIl, final Random lllllllllllllllllllIIlIIIIlIllII, final int lllllllllllllllllllIIlIIIIlIIlll) {
        return this.canDrop ? super.getItemDropped(lllllllllllllllllllIIlIIIIlIllIl, lllllllllllllllllllIIlIIIIlIllII, lllllllllllllllllllIIlIIIIlIIlll) : Items.field_190931_a;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllllIIIlllllllIlI) {
        return 0;
    }
    
    private static int getBoundingBoxIndex(final EnumFacing lllllllllllllllllllIIlIIIlIlIIIl) {
        return 1 << lllllllllllllllllllIIlIIIlIlIIIl.getHorizontalIndex();
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllllllIIlIIIIlIIIll) {
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockPane.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final double lllllllllllllllllllIIIllllIllllI = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllllllllIIIllllIllllI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllllIIIllllIllllI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllllIIIllllIllllI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllllIIIllllIllllI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockPane.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllllllllIIIllllIllllI;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState lllllllllllllllllllIIlIIIlIIIlll, final IBlockAccess lllllllllllllllllllIIlIIIlIIlIlI, final BlockPos lllllllllllllllllllIIlIIIlIIIlIl) {
        lllllllllllllllllllIIlIIIlIIIlll = (double)this.getActualState((IBlockState)lllllllllllllllllllIIlIIIlIIIlll, lllllllllllllllllllIIlIIIlIIlIlI, lllllllllllllllllllIIlIIIlIIIlIl);
        return BlockPane.AABB_BY_INDEX[getBoundingBoxIndex((IBlockState)lllllllllllllllllllIIlIIIlIIIlll)];
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState lllllllllllllllllllIIlIIIlIllIIl, final World lllllllllllllllllllIIlIIIllIIIII, final BlockPos lllllllllllllllllllIIlIIIlIlllll, final AxisAlignedBB lllllllllllllllllllIIlIIIlIlIllI, final List<AxisAlignedBB> lllllllllllllllllllIIlIIIlIlllIl, @Nullable final Entity lllllllllllllllllllIIlIIIlIlllII, final boolean lllllllllllllllllllIIlIIIlIllIll) {
        if (!lllllllllllllllllllIIlIIIlIllIll) {
            lllllllllllllllllllIIlIIIlIllIIl = this.getActualState((IBlockState)lllllllllllllllllllIIlIIIlIllIIl, lllllllllllllllllllIIlIIIllIIIII, lllllllllllllllllllIIlIIIlIlllll);
        }
        Block.addCollisionBoxToList(lllllllllllllllllllIIlIIIlIlllll, lllllllllllllllllllIIlIIIlIlIllI, lllllllllllllllllllIIlIIIlIlllIl, BlockPane.AABB_BY_INDEX[0]);
        if (((IBlockState)lllllllllllllllllllIIlIIIlIllIIl).getValue((IProperty<Boolean>)BlockPane.NORTH)) {
            Block.addCollisionBoxToList(lllllllllllllllllllIIlIIIlIlllll, lllllllllllllllllllIIlIIIlIlIllI, lllllllllllllllllllIIlIIIlIlllIl, BlockPane.AABB_BY_INDEX[getBoundingBoxIndex(EnumFacing.NORTH)]);
        }
        if (((IBlockState)lllllllllllllllllllIIlIIIlIllIIl).getValue((IProperty<Boolean>)BlockPane.SOUTH)) {
            Block.addCollisionBoxToList(lllllllllllllllllllIIlIIIlIlllll, lllllllllllllllllllIIlIIIlIlIllI, lllllllllllllllllllIIlIIIlIlllIl, BlockPane.AABB_BY_INDEX[getBoundingBoxIndex(EnumFacing.SOUTH)]);
        }
        if (((IBlockState)lllllllllllllllllllIIlIIIlIllIIl).getValue((IProperty<Boolean>)BlockPane.EAST)) {
            Block.addCollisionBoxToList(lllllllllllllllllllIIlIIIlIlllll, lllllllllllllllllllIIlIIIlIlIllI, lllllllllllllllllllIIlIIIlIlllIl, BlockPane.AABB_BY_INDEX[getBoundingBoxIndex(EnumFacing.EAST)]);
        }
        if (((IBlockState)lllllllllllllllllllIIlIIIlIllIIl).getValue((IProperty<Boolean>)BlockPane.WEST)) {
            Block.addCollisionBoxToList(lllllllllllllllllllIIlIIIlIlllll, lllllllllllllllllllIIlIIIlIlIllI, lllllllllllllllllllIIlIIIlIlllIl, BlockPane.AABB_BY_INDEX[getBoundingBoxIndex(EnumFacing.WEST)]);
        }
    }
    
    private static int getBoundingBoxIndex(final IBlockState lllllllllllllllllllIIlIIIlIIIIlI) {
        int lllllllllllllllllllIIlIIIlIIIIIl = 0;
        if (lllllllllllllllllllIIlIIIlIIIIlI.getValue((IProperty<Boolean>)BlockPane.NORTH)) {
            lllllllllllllllllllIIlIIIlIIIIIl |= getBoundingBoxIndex(EnumFacing.NORTH);
        }
        if (lllllllllllllllllllIIlIIIlIIIIlI.getValue((IProperty<Boolean>)BlockPane.EAST)) {
            lllllllllllllllllllIIlIIIlIIIIIl |= getBoundingBoxIndex(EnumFacing.EAST);
        }
        if (lllllllllllllllllllIIlIIIlIIIIlI.getValue((IProperty<Boolean>)BlockPane.SOUTH)) {
            lllllllllllllllllllIIlIIIlIIIIIl |= getBoundingBoxIndex(EnumFacing.SOUTH);
        }
        if (lllllllllllllllllllIIlIIIlIIIIlI.getValue((IProperty<Boolean>)BlockPane.WEST)) {
            lllllllllllllllllllIIlIIIlIIIIIl |= getBoundingBoxIndex(EnumFacing.WEST);
        }
        return lllllllllllllllllllIIlIIIlIIIIIl;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllllllllIIlIIIIIlllII, final IBlockAccess lllllllllllllllllllIIlIIIIIlIllI, final BlockPos lllllllllllllllllllIIlIIIIIllIlI, final EnumFacing lllllllllllllllllllIIlIIIIIlIlII) {
        return lllllllllllllllllllIIlIIIIIlIllI.getBlockState(lllllllllllllllllllIIlIIIIIllIlI.offset(lllllllllllllllllllIIlIIIIIlIlII)).getBlock() != this && super.shouldSideBeRendered(lllllllllllllllllllIIlIIIIIlllII, lllllllllllllllllllIIlIIIIIlIllI, lllllllllllllllllllIIlIIIIIllIlI, lllllllllllllllllllIIlIIIIIlIlII);
    }
    
    public final boolean func_193393_b(final IBlockAccess lllllllllllllllllllIIlIIIIIIIllI, final IBlockState lllllllllllllllllllIIlIIIIIIlIll, final BlockPos lllllllllllllllllllIIlIIIIIIlIlI, final EnumFacing lllllllllllllllllllIIlIIIIIIlIIl) {
        final Block lllllllllllllllllllIIlIIIIIIlIII = lllllllllllllllllllIIlIIIIIIlIll.getBlock();
        final BlockFaceShape lllllllllllllllllllIIlIIIIIIIlll = lllllllllllllllllllIIlIIIIIIlIll.func_193401_d(lllllllllllllllllllIIlIIIIIIIllI, lllllllllllllllllllIIlIIIIIIlIlI, lllllllllllllllllllIIlIIIIIIlIIl);
        return (!func_193394_e(lllllllllllllllllllIIlIIIIIIlIII) && lllllllllllllllllllIIlIIIIIIIlll == BlockFaceShape.SOLID) || lllllllllllllllllllIIlIIIIIIIlll == BlockFaceShape.MIDDLE_POLE_THIN;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllllllIIlIIIIlIIlIl) {
        return false;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllllllllIIlIIIIllIlIl, final IBlockAccess lllllllllllllllllllIIlIIIIllIlII, final BlockPos lllllllllllllllllllIIlIIIIllIIll) {
        return lllllllllllllllllllIIlIIIIllIlIl.withProperty((IProperty<Comparable>)BlockPane.NORTH, this.func_193393_b(lllllllllllllllllllIIlIIIIllIlII, lllllllllllllllllllIIlIIIIllIlII.getBlockState(lllllllllllllllllllIIlIIIIllIIll.north()), lllllllllllllllllllIIlIIIIllIIll.north(), EnumFacing.SOUTH)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, this.func_193393_b(lllllllllllllllllllIIlIIIIllIlII, lllllllllllllllllllIIlIIIIllIlII.getBlockState(lllllllllllllllllllIIlIIIIllIIll.south()), lllllllllllllllllllIIlIIIIllIIll.south(), EnumFacing.NORTH)).withProperty((IProperty<Comparable>)BlockPane.WEST, this.func_193393_b(lllllllllllllllllllIIlIIIIllIlII, lllllllllllllllllllIIlIIIIllIlII.getBlockState(lllllllllllllllllllIIlIIIIllIIll.west()), lllllllllllllllllllIIlIIIIllIIll.west(), EnumFacing.EAST)).withProperty((IProperty<Comparable>)BlockPane.EAST, this.func_193393_b(lllllllllllllllllllIIlIIIIllIlII, lllllllllllllllllllIIlIIIIllIlII.getBlockState(lllllllllllllllllllIIlIIIIllIIll.east()), lllllllllllllllllllIIlIIIIllIIll.east(), EnumFacing.WEST));
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    protected static boolean func_193394_e(final Block lllllllllllllllllllIIIlllllllllI) {
        return lllllllllllllllllllIIIlllllllllI instanceof BlockShulkerBox || lllllllllllllllllllIIIlllllllllI instanceof BlockLeaves || lllllllllllllllllllIIIlllllllllI == Blocks.BEACON || lllllllllllllllllllIIIlllllllllI == Blocks.CAULDRON || lllllllllllllllllllIIIlllllllllI == Blocks.GLOWSTONE || lllllllllllllllllllIIIlllllllllI == Blocks.ICE || lllllllllllllllllllIIIlllllllllI == Blocks.SEA_LANTERN || lllllllllllllllllllIIIlllllllllI == Blocks.PISTON || lllllllllllllllllllIIIlllllllllI == Blocks.STICKY_PISTON || lllllllllllllllllllIIIlllllllllI == Blocks.PISTON_HEAD || lllllllllllllllllllIIIlllllllllI == Blocks.MELON_BLOCK || lllllllllllllllllllIIIlllllllllI == Blocks.PUMPKIN || lllllllllllllllllllIIIlllllllllI == Blocks.LIT_PUMPKIN || lllllllllllllllllllIIIlllllllllI == Blocks.BARRIER;
    }
    
    static {
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        AABB_BY_INDEX = new AxisAlignedBB[] { new AxisAlignedBB(0.4375, 0.0, 0.4375, 0.5625, 1.0, 0.5625), new AxisAlignedBB(0.4375, 0.0, 0.4375, 0.5625, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.4375, 0.5625, 1.0, 0.5625), new AxisAlignedBB(0.0, 0.0, 0.4375, 0.5625, 1.0, 1.0), new AxisAlignedBB(0.4375, 0.0, 0.0, 0.5625, 1.0, 0.5625), new AxisAlignedBB(0.4375, 0.0, 0.0, 0.5625, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 0.5625, 1.0, 0.5625), new AxisAlignedBB(0.0, 0.0, 0.0, 0.5625, 1.0, 1.0), new AxisAlignedBB(0.4375, 0.0, 0.4375, 1.0, 1.0, 0.5625), new AxisAlignedBB(0.4375, 0.0, 0.4375, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.4375, 1.0, 1.0, 0.5625), new AxisAlignedBB(0.0, 0.0, 0.4375, 1.0, 1.0, 1.0), new AxisAlignedBB(0.4375, 0.0, 0.0, 1.0, 1.0, 0.5625), new AxisAlignedBB(0.4375, 0.0, 0.0, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.5625), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllllllIIIllllllIlII, final Rotation lllllllllllllllllllIIIllllllIIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllllllllIIIllllllIIll.ordinal()]) {
            case 3: {
                return lllllllllllllllllllIIIllllllIlII.withProperty((IProperty<Comparable>)BlockPane.NORTH, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.SOUTH)).withProperty((IProperty<Comparable>)BlockPane.EAST, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.WEST)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.NORTH)).withProperty((IProperty<Comparable>)BlockPane.WEST, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.EAST));
            }
            case 4: {
                return lllllllllllllllllllIIIllllllIlII.withProperty((IProperty<Comparable>)BlockPane.NORTH, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.EAST)).withProperty((IProperty<Comparable>)BlockPane.EAST, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.SOUTH)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.WEST)).withProperty((IProperty<Comparable>)BlockPane.WEST, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.NORTH));
            }
            case 2: {
                return lllllllllllllllllllIIIllllllIlII.withProperty((IProperty<Comparable>)BlockPane.NORTH, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.WEST)).withProperty((IProperty<Comparable>)BlockPane.EAST, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.NORTH)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.EAST)).withProperty((IProperty<Comparable>)BlockPane.WEST, (Boolean)lllllllllllllllllllIIIllllllIlII.getValue((IProperty<V>)BlockPane.SOUTH));
            }
            default: {
                return lllllllllllllllllllIIIllllllIlII;
            }
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllllllIIIlllllIIlII, final IBlockState lllllllllllllllllllIIIlllllIIIll, final BlockPos lllllllllllllllllllIIIlllllIIIlI, final EnumFacing lllllllllllllllllllIIIlllllIIIIl) {
        return (lllllllllllllllllllIIIlllllIIIIl != EnumFacing.UP && lllllllllllllllllllIIIlllllIIIIl != EnumFacing.DOWN) ? BlockFaceShape.MIDDLE_POLE_THIN : BlockFaceShape.CENTER_SMALL;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllllllllIIIlllllIlIll, final Mirror lllllllllllllllllllIIIlllllIlIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllllllllIIIlllllIlIlI.ordinal()]) {
            case 2: {
                return lllllllllllllllllllIIIlllllIlIll.withProperty((IProperty<Comparable>)BlockPane.NORTH, (Boolean)lllllllllllllllllllIIIlllllIlIll.getValue((IProperty<V>)BlockPane.SOUTH)).withProperty((IProperty<Comparable>)BlockPane.SOUTH, (Boolean)lllllllllllllllllllIIIlllllIlIll.getValue((IProperty<V>)BlockPane.NORTH));
            }
            case 3: {
                return lllllllllllllllllllIIIlllllIlIll.withProperty((IProperty<Comparable>)BlockPane.EAST, (Boolean)lllllllllllllllllllIIIlllllIlIll.getValue((IProperty<V>)BlockPane.WEST)).withProperty((IProperty<Comparable>)BlockPane.WEST, (Boolean)lllllllllllllllllllIIIlllllIlIll.getValue((IProperty<V>)BlockPane.EAST));
            }
            default: {
                return super.withMirror(lllllllllllllllllllIIIlllllIlIll, lllllllllllllllllllIIIlllllIlIlI);
            }
        }
    }
    
    protected BlockPane(final Material lllllllllllllllllllIIlIIIllIlIll, final boolean lllllllllllllllllllIIlIIIllIllIl) {
        super(lllllllllllllllllllIIlIIIllIlIll);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPane.NORTH, false).withProperty((IProperty<Comparable>)BlockPane.EAST, false).withProperty((IProperty<Comparable>)BlockPane.SOUTH, false).withProperty((IProperty<Comparable>)BlockPane.WEST, false));
        this.canDrop = lllllllllllllllllllIIlIIIllIllIl;
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockPane.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final char lllllllllllllllllllIIIllllIlllII = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllllllllIIIllllIlllII[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllllIIIllllIlllII[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllllIIIllllIlllII[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockPane.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllllllllIIIllllIlllII;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPane.NORTH, BlockPane.EAST, BlockPane.WEST, BlockPane.SOUTH });
    }
}
