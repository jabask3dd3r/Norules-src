package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;

public class BlockFence extends Block
{
    public static final /* synthetic */ PropertyBool NORTH;
    public static final /* synthetic */ AxisAlignedBB EAST_AABB;
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ AxisAlignedBB WEST_AABB;
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB[] BOUNDING_BOXES;
    public static final /* synthetic */ PropertyBool WEST;
    public static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    public static final /* synthetic */ AxisAlignedBB PILLAR_AABB;
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIlllIlllIIIIlIIlll, final BlockPos llllllllllllllIlllIlllIIIIlIIllI, final IBlockState llllllllllllllIlllIlllIIIIlIIlIl, final EntityPlayer llllllllllllllIlllIlllIIIIlIIlII, final EnumHand llllllllllllllIlllIlllIIIIIllIlI, final EnumFacing llllllllllllllIlllIlllIIIIlIIIlI, final float llllllllllllllIlllIlllIIIIlIIIIl, final float llllllllllllllIlllIlllIIIIlIIIII, final float llllllllllllllIlllIlllIIIIIlllll) {
        if (!llllllllllllllIlllIlllIIIIlIIlll.isRemote) {
            return ItemLead.attachToFence(llllllllllllllIlllIlllIIIIlIIlII, llllllllllllllIlllIlllIIIIlIIlll, llllllllllllllIlllIlllIIIIlIIllI);
        }
        final ItemStack llllllllllllllIlllIlllIIIIIllllI = llllllllllllllIlllIlllIIIIlIIlII.getHeldItem(llllllllllllllIlllIlllIIIIIllIlI);
        return llllllllllllllIlllIlllIIIIIllllI.getItem() == Items.LEAD || llllllllllllllIlllIlllIIIIIllllI.func_190926_b();
    }
    
    protected static boolean func_194142_e(final Block llllllllllllllIlllIlllIIIIllIlII) {
        return Block.func_193382_c(llllllllllllllIlllIlllIIIIllIlII) || llllllllllllllIlllIlllIIIIllIlII == Blocks.BARRIER || llllllllllllllIlllIlllIIIIllIlII == Blocks.MELON_BLOCK || llllllllllllllIlllIlllIIIIllIlII == Blocks.PUMPKIN || llllllllllllllIlllIlllIIIIllIlII == Blocks.LIT_PUMPKIN;
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState llllllllllllllIlllIlllIIIllIllII, final World llllllllllllllIlllIlllIIIllIlIll, final BlockPos llllllllllllllIlllIlllIIIllIlIlI, final AxisAlignedBB llllllllllllllIlllIlllIIIlllIIII, final List<AxisAlignedBB> llllllllllllllIlllIlllIIIllIlIII, @Nullable final Entity llllllllllllllIlllIlllIIIllIlllI, final boolean llllllllllllllIlllIlllIIIllIllIl) {
        if (!llllllllllllllIlllIlllIIIllIllIl) {
            llllllllllllllIlllIlllIIIllIllII = ((IBlockProperties)llllllllllllllIlllIlllIIIllIllII).getActualState(llllllllllllllIlllIlllIIIllIlIll, llllllllllllllIlllIlllIIIllIlIlI);
        }
        Block.addCollisionBoxToList(llllllllllllllIlllIlllIIIllIlIlI, llllllllllllllIlllIlllIIIlllIIII, llllllllllllllIlllIlllIIIllIlIII, BlockFence.PILLAR_AABB);
        if (((IBlockState)llllllllllllllIlllIlllIIIllIllII).getValue((IProperty<Boolean>)BlockFence.NORTH)) {
            Block.addCollisionBoxToList(llllllllllllllIlllIlllIIIllIlIlI, llllllllllllllIlllIlllIIIlllIIII, llllllllllllllIlllIlllIIIllIlIII, BlockFence.NORTH_AABB);
        }
        if (((IBlockState)llllllllllllllIlllIlllIIIllIllII).getValue((IProperty<Boolean>)BlockFence.EAST)) {
            Block.addCollisionBoxToList(llllllllllllllIlllIlllIIIllIlIlI, llllllllllllllIlllIlllIIIlllIIII, llllllllllllllIlllIlllIIIllIlIII, BlockFence.EAST_AABB);
        }
        if (((IBlockState)llllllllllllllIlllIlllIIIllIllII).getValue((IProperty<Boolean>)BlockFence.SOUTH)) {
            Block.addCollisionBoxToList(llllllllllllllIlllIlllIIIllIlIlI, llllllllllllllIlllIlllIIIlllIIII, llllllllllllllIlllIlllIIIllIlIII, BlockFence.SOUTH_AABB);
        }
        if (((IBlockState)llllllllllllllIlllIlllIIIllIllII).getValue((IProperty<Boolean>)BlockFence.WEST)) {
            Block.addCollisionBoxToList(llllllllllllllIlllIlllIIIllIlIlI, llllllllllllllIlllIlllIIIlllIIII, llllllllllllllIlllIlllIIIllIlIII, BlockFence.WEST_AABB);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockFence.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final boolean llllllllllllllIlllIllIlllllIllll = (Object)new int[Rotation.values().length];
        try {
            llllllllllllllIlllIllIlllllIllll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlllIllIlllllIllll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlllIllIlllllIllll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIlllIllIlllllIllll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockFence.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllllIlllIllIlllllIllll;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllllIlllIlllIIIlIIllll, final BlockPos llllllllllllllIlllIlllIIIlIIlllI) {
        return false;
    }
    
    public boolean canConnectTo(final IBlockAccess llllllllllllllIlllIlllIIIIllllII, final BlockPos llllllllllllllIlllIlllIIIIlllIll, final EnumFacing llllllllllllllIlllIlllIIIlIIIIlI) {
        final IBlockState llllllllllllllIlllIlllIIIlIIIIIl = llllllllllllllIlllIlllIIIIllllII.getBlockState(llllllllllllllIlllIlllIIIIlllIll);
        final BlockFaceShape llllllllllllllIlllIlllIIIlIIIIII = llllllllllllllIlllIlllIIIlIIIIIl.func_193401_d(llllllllllllllIlllIlllIIIIllllII, llllllllllllllIlllIlllIIIIlllIll, llllllllllllllIlllIlllIIIlIIIIlI);
        final Block llllllllllllllIlllIlllIIIIllllll = llllllllllllllIlllIlllIIIlIIIIIl.getBlock();
        final boolean llllllllllllllIlllIlllIIIIlllllI = llllllllllllllIlllIlllIIIlIIIIII == BlockFaceShape.MIDDLE_POLE && (llllllllllllllIlllIlllIIIlIIIIIl.getMaterial() == this.blockMaterial || llllllllllllllIlllIlllIIIIllllll instanceof BlockFenceGate);
        return (!func_194142_e(llllllllllllllIlllIlllIIIIllllll) && llllllllllllllIlllIlllIIIlIIIIII == BlockFaceShape.SOLID) || llllllllllllllIlllIlllIIIIlllllI;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFence.NORTH, BlockFence.EAST, BlockFence.WEST, BlockFence.SOUTH });
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllIlllIlllIIIIIIIlll, final Rotation llllllllllllllIlllIlllIIIIIIIllI) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllIlllIlllIIIIIIIllI.ordinal()]) {
            case 3: {
                return llllllllllllllIlllIlllIIIIIIIlll.withProperty((IProperty<Comparable>)BlockFence.NORTH, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.SOUTH)).withProperty((IProperty<Comparable>)BlockFence.EAST, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.WEST)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.NORTH)).withProperty((IProperty<Comparable>)BlockFence.WEST, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.EAST));
            }
            case 4: {
                return llllllllllllllIlllIlllIIIIIIIlll.withProperty((IProperty<Comparable>)BlockFence.NORTH, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.EAST)).withProperty((IProperty<Comparable>)BlockFence.EAST, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.SOUTH)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.WEST)).withProperty((IProperty<Comparable>)BlockFence.WEST, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.NORTH));
            }
            case 2: {
                return llllllllllllllIlllIlllIIIIIIIlll.withProperty((IProperty<Comparable>)BlockFence.NORTH, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.WEST)).withProperty((IProperty<Comparable>)BlockFence.EAST, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.NORTH)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.EAST)).withProperty((IProperty<Comparable>)BlockFence.WEST, (Boolean)llllllllllllllIlllIlllIIIIIIIlll.getValue((IProperty<V>)BlockFence.SOUTH));
            }
            default: {
                return llllllllllllllIlllIlllIIIIIIIlll;
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIlllIlllIIIlIlIIll) {
        return false;
    }
    
    private static int getBoundingBoxIdx(final IBlockState llllllllllllllIlllIlllIIIlIllIII) {
        int llllllllllllllIlllIlllIIIlIlIlll = 0;
        if (llllllllllllllIlllIlllIIIlIllIII.getValue((IProperty<Boolean>)BlockFence.NORTH)) {
            llllllllllllllIlllIlllIIIlIlIlll |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }
        if (llllllllllllllIlllIlllIIIlIllIII.getValue((IProperty<Boolean>)BlockFence.EAST)) {
            llllllllllllllIlllIlllIIIlIlIlll |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }
        if (llllllllllllllIlllIlllIIIlIllIII.getValue((IProperty<Boolean>)BlockFence.SOUTH)) {
            llllllllllllllIlllIlllIIIlIlIlll |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }
        if (llllllllllllllIlllIlllIIIlIllIII.getValue((IProperty<Boolean>)BlockFence.WEST)) {
            llllllllllllllIlllIlllIIIlIlIlll |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }
        return llllllllllllllIlllIlllIIIlIlIlll;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllIlllIlllIIIIllIIIl, final IBlockAccess llllllllllllllIlllIlllIIIIllIIII, final BlockPos llllllllllllllIlllIlllIIIIlIllll, final EnumFacing llllllllllllllIlllIlllIIIIlIlllI) {
        return true;
    }
    
    static {
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        BOUNDING_BOXES = new AxisAlignedBB[] { new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.375, 0.625, 1.0, 0.625), new AxisAlignedBB(0.0, 0.0, 0.375, 0.625, 1.0, 1.0), new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.0, 0.625), new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 0.625, 1.0, 0.625), new AxisAlignedBB(0.0, 0.0, 0.0, 0.625, 1.0, 1.0), new AxisAlignedBB(0.375, 0.0, 0.375, 1.0, 1.0, 0.625), new AxisAlignedBB(0.375, 0.0, 0.375, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.0, 0.625), new AxisAlignedBB(0.0, 0.0, 0.375, 1.0, 1.0, 1.0), new AxisAlignedBB(0.375, 0.0, 0.0, 1.0, 1.0, 0.625), new AxisAlignedBB(0.375, 0.0, 0.0, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.625), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
        PILLAR_AABB = new AxisAlignedBB(0.375, 0.0, 0.375, 0.625, 1.5, 0.625);
        SOUTH_AABB = new AxisAlignedBB(0.375, 0.0, 0.625, 0.625, 1.5, 1.0);
        WEST_AABB = new AxisAlignedBB(0.0, 0.0, 0.375, 0.375, 1.5, 0.625);
        NORTH_AABB = new AxisAlignedBB(0.375, 0.0, 0.0, 0.625, 1.5, 0.375);
        EAST_AABB = new AxisAlignedBB(0.625, 0.0, 0.375, 1.0, 1.5, 0.625);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockFence.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final boolean llllllllllllllIlllIllIlllllIllIl = (Object)new int[Mirror.values().length];
        try {
            llllllllllllllIlllIllIlllllIllIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlllIllIlllllIllIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlllIllIlllllIllIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockFence.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllllIlllIllIlllllIllIl;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIlllIllIllllllIlIl, final IBlockState llllllllllllllIlllIllIllllllIlII, final BlockPos llllllllllllllIlllIllIllllllIIll, final EnumFacing llllllllllllllIlllIllIllllllIIlI) {
        return (llllllllllllllIlllIllIllllllIIlI != EnumFacing.UP && llllllllllllllIlllIllIllllllIIlI != EnumFacing.DOWN) ? BlockFaceShape.MIDDLE_POLE : BlockFaceShape.CENTER;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlllIlllIIIIIlIlll) {
        return 0;
    }
    
    public BlockFence(final Material llllllllllllllIlllIlllIIIlllllll, final MapColor llllllllllllllIlllIlllIIIllllllI) {
        super(llllllllllllllIlllIlllIIIlllllll, llllllllllllllIlllIlllIIIllllllI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFence.NORTH, false).withProperty((IProperty<Comparable>)BlockFence.EAST, false).withProperty((IProperty<Comparable>)BlockFence.SOUTH, false).withProperty((IProperty<Comparable>)BlockFence.WEST, false));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIlllIlllIIIlIlIIIl) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState llllllllllllllIlllIlllIIIlIlllIl, final IBlockAccess llllllllllllllIlllIlllIIIllIIIII, final BlockPos llllllllllllllIlllIlllIIIlIlllll) {
        llllllllllllllIlllIlllIIIlIlllIl = (double)this.getActualState((IBlockState)llllllllllllllIlllIlllIIIlIlllIl, llllllllllllllIlllIlllIIIllIIIII, llllllllllllllIlllIlllIIIlIlllll);
        return BlockFence.BOUNDING_BOXES[getBoundingBoxIdx((IBlockState)llllllllllllllIlllIlllIIIlIlllIl)];
    }
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllllIlllIlllIIIIIIllIl, final IBlockAccess llllllllllllllIlllIlllIIIIIIllII, final BlockPos llllllllllllllIlllIlllIIIIIIllll) {
        return llllllllllllllIlllIlllIIIIIIllIl.withProperty((IProperty<Comparable>)BlockFence.NORTH, this.canConnectTo(llllllllllllllIlllIlllIIIIIIllII, llllllllllllllIlllIlllIIIIIIllll.north(), EnumFacing.SOUTH)).withProperty((IProperty<Comparable>)BlockFence.EAST, this.canConnectTo(llllllllllllllIlllIlllIIIIIIllII, llllllllllllllIlllIlllIIIIIIllll.east(), EnumFacing.WEST)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, this.canConnectTo(llllllllllllllIlllIlllIIIIIIllII, llllllllllllllIlllIlllIIIIIIllll.south(), EnumFacing.NORTH)).withProperty((IProperty<Comparable>)BlockFence.WEST, this.canConnectTo(llllllllllllllIlllIlllIIIIIIllII, llllllllllllllIlllIlllIIIIIIllll.west(), EnumFacing.EAST));
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllIlllIllIllllllllll, final Mirror llllllllllllllIlllIllIlllllllIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllllIlllIllIlllllllIll.ordinal()]) {
            case 2: {
                return llllllllllllllIlllIllIllllllllll.withProperty((IProperty<Comparable>)BlockFence.NORTH, (Boolean)llllllllllllllIlllIllIllllllllll.getValue((IProperty<V>)BlockFence.SOUTH)).withProperty((IProperty<Comparable>)BlockFence.SOUTH, (Boolean)llllllllllllllIlllIllIllllllllll.getValue((IProperty<V>)BlockFence.NORTH));
            }
            case 3: {
                return llllllllllllllIlllIllIllllllllll.withProperty((IProperty<Comparable>)BlockFence.EAST, (Boolean)llllllllllllllIlllIllIllllllllll.getValue((IProperty<V>)BlockFence.WEST)).withProperty((IProperty<Comparable>)BlockFence.WEST, (Boolean)llllllllllllllIlllIllIllllllllll.getValue((IProperty<V>)BlockFence.EAST));
            }
            default: {
                return super.withMirror(llllllllllllllIlllIllIllllllllll, llllllllllllllIlllIllIlllllllIll);
            }
        }
    }
}
