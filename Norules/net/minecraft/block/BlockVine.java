package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;

public class BlockVine extends Block
{
    public static final /* synthetic */ PropertyBool SOUTH;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    public static final /* synthetic */ PropertyBool WEST;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    protected static final /* synthetic */ AxisAlignedBB UP_AABB;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    public static final /* synthetic */ PropertyBool UP;
    protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool NORTH;
    public static final /* synthetic */ PropertyBool[] ALL_FACES;
    protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
    
    @Override
    public IBlockState withMirror(final IBlockState lIIIlllIlIll, final Mirror lIIIlllIIlll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lIIIlllIIlll.ordinal()]) {
            case 2: {
                return lIIIlllIlIll.withProperty((IProperty<Comparable>)BlockVine.NORTH, (Boolean)lIIIlllIlIll.getValue((IProperty<V>)BlockVine.SOUTH)).withProperty((IProperty<Comparable>)BlockVine.SOUTH, (Boolean)lIIIlllIlIll.getValue((IProperty<V>)BlockVine.NORTH));
            }
            case 3: {
                return lIIIlllIlIll.withProperty((IProperty<Comparable>)BlockVine.EAST, (Boolean)lIIIlllIlIll.getValue((IProperty<V>)BlockVine.WEST)).withProperty((IProperty<Comparable>)BlockVine.WEST, (Boolean)lIIIlllIlIll.getValue((IProperty<V>)BlockVine.EAST));
            }
            default: {
                return super.withMirror(lIIIlllIlIll, lIIIlllIIlll);
            }
        }
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lIIlllllIIlI, final IBlockAccess lIIlllllIIIl, final BlockPos lIIlllllIIII) {
        return BlockVine.NULL_AABB;
    }
    
    @Override
    public int quantityDropped(final Random lIIlIIIlllIl) {
        return 0;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lIIIllllIIll, final Rotation lIIIllllIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lIIIllllIIlI.ordinal()]) {
            case 3: {
                return lIIIllllIIll.withProperty((IProperty<Comparable>)BlockVine.NORTH, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.SOUTH)).withProperty((IProperty<Comparable>)BlockVine.EAST, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.WEST)).withProperty((IProperty<Comparable>)BlockVine.SOUTH, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.NORTH)).withProperty((IProperty<Comparable>)BlockVine.WEST, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.EAST));
            }
            case 4: {
                return lIIIllllIIll.withProperty((IProperty<Comparable>)BlockVine.NORTH, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.EAST)).withProperty((IProperty<Comparable>)BlockVine.EAST, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.SOUTH)).withProperty((IProperty<Comparable>)BlockVine.SOUTH, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.WEST)).withProperty((IProperty<Comparable>)BlockVine.WEST, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.NORTH));
            }
            case 2: {
                return lIIIllllIIll.withProperty((IProperty<Comparable>)BlockVine.NORTH, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.WEST)).withProperty((IProperty<Comparable>)BlockVine.EAST, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.NORTH)).withProperty((IProperty<Comparable>)BlockVine.SOUTH, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.EAST)).withProperty((IProperty<Comparable>)BlockVine.WEST, (Boolean)lIIIllllIIll.getValue((IProperty<V>)BlockVine.SOUTH));
            }
            default: {
                return lIIIllllIIll;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockVine.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final int lIIIllIIlIlI = (Object)new int[EnumFacing.values().length];
        try {
            lIIIllIIlIlI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lIIIllIIlIlI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lIIIllIIlIlI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lIIIllIIlIlI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lIIIllIIlIlI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lIIIllIIlIlI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockVine.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lIIIllIIlIlI;
    }
    
    private boolean recheckGrownSides(final World lIIllIIlIllI, final BlockPos lIIllIIlIlIl, IBlockState lIIllIIIllII) {
        final IBlockState lIIllIIlIIll = (IBlockState)lIIllIIIllII;
        for (final EnumFacing lIIllIIlIIlI : EnumFacing.Plane.HORIZONTAL) {
            final PropertyBool lIIllIIlIIIl = getPropertyFor(lIIllIIlIIlI);
            if (((IBlockState)lIIllIIIllII).getValue((IProperty<Boolean>)lIIllIIlIIIl) && !this.func_193395_a(lIIllIIlIllI, lIIllIIlIlIl, lIIllIIlIIlI.getOpposite())) {
                final IBlockState lIIllIIlIIII = lIIllIIlIllI.getBlockState(lIIllIIlIlIl.up());
                if (lIIllIIlIIII.getBlock() == this && lIIllIIlIIII.getValue((IProperty<Boolean>)lIIllIIlIIIl)) {
                    continue;
                }
                lIIllIIIllII = ((IBlockState)lIIllIIIllII).withProperty((IProperty<Comparable>)lIIllIIlIIIl, Boolean.valueOf(false));
            }
        }
        if (getNumGrownFaces((IBlockState)lIIllIIIllII) == 0) {
            return false;
        }
        if (lIIllIIlIIll != lIIllIIIllII) {
            lIIllIIlIllI.setBlockState(lIIllIIlIlIl, (IBlockState)lIIllIIIllII, 2);
        }
        return true;
    }
    
    @Override
    public void harvestBlock(final World lIIlIIIlIlII, final EntityPlayer lIIlIIIlIIll, final BlockPos lIIlIIIIlIll, final IBlockState lIIlIIIIlIlI, @Nullable final TileEntity lIIlIIIIlIIl, final ItemStack lIIlIIIIllll) {
        if (!lIIlIIIlIlII.isRemote && lIIlIIIIllll.getItem() == Items.SHEARS) {
            lIIlIIIlIIll.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(lIIlIIIlIlII, lIIlIIIIlIll, new ItemStack(Blocks.VINE, 1, 0));
        }
        else {
            super.harvestBlock(lIIlIIIlIlII, lIIlIIIlIIll, lIIlIIIIlIll, lIIlIIIIlIlI, lIIlIIIIlIIl, lIIlIIIIllll);
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lIIlIllllIll, final World lIIllIIIIIII, final BlockPos lIIlIllllIIl, final Block lIIlIllllllI, final BlockPos lIIlIlllllIl) {
        if (!lIIllIIIIIII.isRemote && !this.recheckGrownSides(lIIllIIIIIII, lIIlIllllIIl, lIIlIllllIll)) {
            this.dropBlockAsItem(lIIllIIIIIII, lIIlIllllIIl, lIIlIllllIll, 0);
            lIIllIIIIIII.setBlockToAir(lIIlIllllIIl);
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState lIIllllIIlII, final IBlockAccess lIIllllIlIII, final BlockPos lIIllllIIIlI) {
        lIIllllIIlII = lIIllllIIlII.getActualState(lIIllllIlIII, lIIllllIIIlI);
        int lIIllllIIllI = 0;
        AxisAlignedBB lIIllllIIlIl = BlockVine.FULL_BLOCK_AABB;
        if (lIIllllIIlII.getValue((IProperty<Boolean>)BlockVine.UP)) {
            lIIllllIIlIl = BlockVine.UP_AABB;
            ++lIIllllIIllI;
        }
        if (lIIllllIIlII.getValue((IProperty<Boolean>)BlockVine.NORTH)) {
            lIIllllIIlIl = BlockVine.NORTH_AABB;
            ++lIIllllIIllI;
        }
        if (lIIllllIIlII.getValue((IProperty<Boolean>)BlockVine.EAST)) {
            lIIllllIIlIl = BlockVine.EAST_AABB;
            ++lIIllllIIllI;
        }
        if (lIIllllIIlII.getValue((IProperty<Boolean>)BlockVine.SOUTH)) {
            lIIllllIIlIl = BlockVine.SOUTH_AABB;
            ++lIIllllIIllI;
        }
        if (lIIllllIIlII.getValue((IProperty<Boolean>)BlockVine.WEST)) {
            lIIllllIIlIl = BlockVine.WEST_AABB;
            ++lIIllllIIllI;
        }
        return (lIIllllIIllI == 1) ? lIIllllIIlIl : BlockVine.FULL_BLOCK_AABB;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lIIlIIlIIIIl, final Random lIIlIIlIIIII, final int lIIlIIIlllll) {
        return Items.field_190931_a;
    }
    
    protected static boolean func_193397_e(final Block lIIllIlIIIlI) {
        return lIIllIlIIIlI instanceof BlockShulkerBox || lIIllIlIIIlI == Blocks.BEACON || lIIllIlIIIlI == Blocks.CAULDRON || lIIllIlIIIlI == Blocks.GLASS || lIIllIlIIIlI == Blocks.STAINED_GLASS || lIIllIlIIIlI == Blocks.PISTON || lIIllIlIIIlI == Blocks.STICKY_PISTON || lIIllIlIIIlI == Blocks.PISTON_HEAD || lIIllIlIIIlI == Blocks.TRAPDOOR;
    }
    
    public static PropertyBool getPropertyFor(final EnumFacing lIIIlllIIlII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lIIIlllIIlII.ordinal()]) {
            case 2: {
                return BlockVine.UP;
            }
            case 3: {
                return BlockVine.NORTH;
            }
            case 4: {
                return BlockVine.SOUTH;
            }
            case 5: {
                return BlockVine.WEST;
            }
            case 6: {
                return BlockVine.EAST;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(lIIIlllIIlII).append(" is an invalid choice")));
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockVine.UP, BlockVine.NORTH, BlockVine.EAST, BlockVine.SOUTH, BlockVine.WEST });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIlIIIIIIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.SOUTH, (lIIlIIIIIIll & 0x1) > 0).withProperty((IProperty<Comparable>)BlockVine.WEST, (lIIlIIIIIIll & 0x2) > 0).withProperty((IProperty<Comparable>)BlockVine.NORTH, (lIIlIIIIIIll & 0x4) > 0).withProperty((IProperty<Comparable>)BlockVine.EAST, (lIIlIIIIIIll & 0x8) > 0);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockVine.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final byte lIIIllIIlllI = (Object)new int[Rotation.values().length];
        try {
            lIIIllIIlllI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lIIIllIIlllI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lIIIllIIlllI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lIIIllIIlllI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockVine.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lIIIllIIlllI;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lIIIllIlIIll, final IBlockState lIIIllIlIIlI, final BlockPos lIIIllIlIIIl, final EnumFacing lIIIllIlIIII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockVine.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final short lIIIllIIllII = (Object)new int[Mirror.values().length];
        try {
            lIIIllIIllII[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lIIIllIIllII[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lIIIllIIllII[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockVine.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lIIIllIIllII;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lIIIllllllIl) {
        int lIIIllllllII = 0;
        if (lIIIllllllIl.getValue((IProperty<Boolean>)BlockVine.SOUTH)) {
            lIIIllllllII |= 0x1;
        }
        if (lIIIllllllIl.getValue((IProperty<Boolean>)BlockVine.WEST)) {
            lIIIllllllII |= 0x2;
        }
        if (lIIIllllllIl.getValue((IProperty<Boolean>)BlockVine.NORTH)) {
            lIIIllllllII |= 0x4;
        }
        if (lIIIllllllIl.getValue((IProperty<Boolean>)BlockVine.EAST)) {
            lIIIllllllII |= 0x8;
        }
        return lIIIllllllII;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lIIlllIlIIIl) {
        return false;
    }
    
    public static int getNumGrownFaces(final IBlockState lIIIllIlllIl) {
        int lIIIllIlllII = 0;
        float lIIIllIlIlIl;
        for (String lIIIllIlIllI = (String)((PropertyBool[])(Object)(lIIIllIlIlIl = (float)(Object)BlockVine.ALL_FACES)).length, lIIIllIlIlll = (String)0; lIIIllIlIlll < lIIIllIlIllI; ++lIIIllIlIlll) {
            final PropertyBool lIIIllIllIll = lIIIllIlIlIl[lIIIllIlIlll];
            if (lIIIllIlllIl.getValue((IProperty<Boolean>)lIIIllIllIll)) {
                ++lIIIllIlllII;
            }
        }
        return lIIIllIlllII;
    }
    
    static {
        UP = PropertyBool.create("up");
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        ALL_FACES = new PropertyBool[] { BlockVine.UP, BlockVine.NORTH, BlockVine.SOUTH, BlockVine.WEST, BlockVine.EAST };
        UP_AABB = new AxisAlignedBB(0.0, 0.9375, 0.0, 1.0, 1.0, 1.0);
        WEST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0625, 1.0, 1.0);
        EAST_AABB = new AxisAlignedBB(0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
        NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.0625);
        SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.9375, 1.0, 1.0, 1.0);
    }
    
    public boolean func_193395_a(final World lIIllIllIlII, final BlockPos lIIllIllIIll, final EnumFacing lIIllIllIlll) {
        final Block lIIllIllIllI = lIIllIllIlII.getBlockState(lIIllIllIIll.up()).getBlock();
        return this.func_193396_c(lIIllIllIlII, lIIllIllIIll.offset(lIIllIllIlll.getOpposite()), lIIllIllIlll) && (lIIllIllIllI == Blocks.AIR || lIIllIllIllI == Blocks.VINE || this.func_193396_c(lIIllIllIlII, lIIllIllIIll.up(), EnumFacing.UP));
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lIIlllIIIllI, final BlockPos lIIlllIIIlIl, final EnumFacing lIIlllIIIIII) {
        return lIIlllIIIIII != EnumFacing.DOWN && lIIlllIIIIII != EnumFacing.UP && this.func_193395_a(lIIlllIIIllI, lIIlllIIIlIl, lIIlllIIIIII);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lIIlllIIllll) {
        return false;
    }
    
    @Override
    public void updateTick(final World lIIlIlIIIlII, final BlockPos lIIlIlIIIIll, final IBlockState lIIlIllIIIlI, final Random lIIlIllIIIIl) {
        if (!lIIlIlIIIlII.isRemote && lIIlIlIIIlII.rand.nextInt(4) == 0) {
            final int lIIlIllIIIII = 4;
            int lIIlIlIlllll = 5;
            boolean lIIlIlIllllI = false;
        Label_0111:
            for (int lIIlIlIlllIl = -4; lIIlIlIlllIl <= 4; ++lIIlIlIlllIl) {
                for (int lIIlIlIlllII = -4; lIIlIlIlllII <= 4; ++lIIlIlIlllII) {
                    for (int lIIlIlIllIll = -1; lIIlIlIllIll <= 1; ++lIIlIlIllIll) {
                        if (lIIlIlIIIlII.getBlockState(lIIlIlIIIIll.add(lIIlIlIlllIl, lIIlIlIllIll, lIIlIlIlllII)).getBlock() == this && --lIIlIlIlllll <= 0) {
                            lIIlIlIllllI = true;
                            break Label_0111;
                        }
                    }
                }
            }
            final EnumFacing lIIlIlIllIlI = EnumFacing.random(lIIlIllIIIIl);
            final BlockPos lIIlIlIllIIl = lIIlIlIIIIll.up();
            if (lIIlIlIllIlI == EnumFacing.UP && lIIlIlIIIIll.getY() < 255 && lIIlIlIIIlII.isAirBlock(lIIlIlIllIIl)) {
                IBlockState lIIlIlIllIII = lIIlIllIIIlI;
                for (final EnumFacing lIIlIlIlIlll : EnumFacing.Plane.HORIZONTAL) {
                    if (lIIlIllIIIIl.nextBoolean() && this.func_193395_a(lIIlIlIIIlII, lIIlIlIllIIl, lIIlIlIlIlll.getOpposite())) {
                        lIIlIlIllIII = lIIlIlIllIII.withProperty((IProperty<Comparable>)getPropertyFor(lIIlIlIlIlll), true);
                    }
                    else {
                        lIIlIlIllIII = lIIlIlIllIII.withProperty((IProperty<Comparable>)getPropertyFor(lIIlIlIlIlll), false);
                    }
                }
                if (lIIlIlIllIII.getValue((IProperty<Boolean>)BlockVine.NORTH) || lIIlIlIllIII.getValue((IProperty<Boolean>)BlockVine.EAST) || lIIlIlIllIII.getValue((IProperty<Boolean>)BlockVine.SOUTH) || lIIlIlIllIII.getValue((IProperty<Boolean>)BlockVine.WEST)) {
                    lIIlIlIIIlII.setBlockState(lIIlIlIllIIl, lIIlIlIllIII, 2);
                }
            }
            else if (lIIlIlIllIlI.getAxis().isHorizontal() && !lIIlIllIIIlI.getValue((IProperty<Boolean>)getPropertyFor(lIIlIlIllIlI))) {
                if (!lIIlIlIllllI) {
                    final BlockPos lIIlIlIlIllI = lIIlIlIIIIll.offset(lIIlIlIllIlI);
                    final IBlockState lIIlIlIlIlIl = lIIlIlIIIlII.getBlockState(lIIlIlIlIllI);
                    final Block lIIlIlIlIlII = lIIlIlIlIlIl.getBlock();
                    if (lIIlIlIlIlII.blockMaterial == Material.AIR) {
                        final EnumFacing lIIlIlIlIIll = lIIlIlIllIlI.rotateY();
                        final EnumFacing lIIlIlIlIIlI = lIIlIlIllIlI.rotateYCCW();
                        final boolean lIIlIlIlIIIl = lIIlIllIIIlI.getValue((IProperty<Boolean>)getPropertyFor(lIIlIlIlIIll));
                        final boolean lIIlIlIlIIII = lIIlIllIIIlI.getValue((IProperty<Boolean>)getPropertyFor(lIIlIlIlIIlI));
                        final BlockPos lIIlIlIIllll = lIIlIlIlIllI.offset(lIIlIlIlIIll);
                        final BlockPos lIIlIlIIlllI = lIIlIlIlIllI.offset(lIIlIlIlIIlI);
                        if (lIIlIlIlIIIl && this.func_193395_a(lIIlIlIIIlII, lIIlIlIIllll.offset(lIIlIlIlIIll), lIIlIlIlIIll)) {
                            lIIlIlIIIlII.setBlockState(lIIlIlIlIllI, this.getDefaultState().withProperty((IProperty<Comparable>)getPropertyFor(lIIlIlIlIIll), true), 2);
                        }
                        else if (lIIlIlIlIIII && this.func_193395_a(lIIlIlIIIlII, lIIlIlIIlllI.offset(lIIlIlIlIIlI), lIIlIlIlIIlI)) {
                            lIIlIlIIIlII.setBlockState(lIIlIlIlIllI, this.getDefaultState().withProperty((IProperty<Comparable>)getPropertyFor(lIIlIlIlIIlI), true), 2);
                        }
                        else if (lIIlIlIlIIIl && lIIlIlIIIlII.isAirBlock(lIIlIlIIllll) && this.func_193395_a(lIIlIlIIIlII, lIIlIlIIllll, lIIlIlIllIlI)) {
                            lIIlIlIIIlII.setBlockState(lIIlIlIIllll, this.getDefaultState().withProperty((IProperty<Comparable>)getPropertyFor(lIIlIlIllIlI.getOpposite()), true), 2);
                        }
                        else if (lIIlIlIlIIII && lIIlIlIIIlII.isAirBlock(lIIlIlIIlllI) && this.func_193395_a(lIIlIlIIIlII, lIIlIlIIlllI, lIIlIlIllIlI)) {
                            lIIlIlIIIlII.setBlockState(lIIlIlIIlllI, this.getDefaultState().withProperty((IProperty<Comparable>)getPropertyFor(lIIlIlIllIlI.getOpposite()), true), 2);
                        }
                    }
                    else if (lIIlIlIlIlIl.func_193401_d(lIIlIlIIIlII, lIIlIlIlIllI, lIIlIlIllIlI) == BlockFaceShape.SOLID) {
                        lIIlIlIIIlII.setBlockState(lIIlIlIIIIll, lIIlIllIIIlI.withProperty((IProperty<Comparable>)getPropertyFor(lIIlIlIllIlI), true), 2);
                    }
                }
            }
            else if (lIIlIlIIIIll.getY() > 1) {
                final BlockPos lIIlIlIIllIl = lIIlIlIIIIll.down();
                final IBlockState lIIlIlIIllII = lIIlIlIIIlII.getBlockState(lIIlIlIIllIl);
                final Block lIIlIlIIlIll = lIIlIlIIllII.getBlock();
                if (lIIlIlIIlIll.blockMaterial == Material.AIR) {
                    IBlockState lIIlIlIIlIlI = lIIlIllIIIlI;
                    for (final EnumFacing lIIlIlIIlIIl : EnumFacing.Plane.HORIZONTAL) {
                        if (lIIlIllIIIIl.nextBoolean()) {
                            lIIlIlIIlIlI = lIIlIlIIlIlI.withProperty((IProperty<Comparable>)getPropertyFor(lIIlIlIIlIIl), false);
                        }
                    }
                    if (lIIlIlIIlIlI.getValue((IProperty<Boolean>)BlockVine.NORTH) || lIIlIlIIlIlI.getValue((IProperty<Boolean>)BlockVine.EAST) || lIIlIlIIlIlI.getValue((IProperty<Boolean>)BlockVine.SOUTH) || lIIlIlIIlIlI.getValue((IProperty<Boolean>)BlockVine.WEST)) {
                        lIIlIlIIIlII.setBlockState(lIIlIlIIllIl, lIIlIlIIlIlI, 2);
                    }
                }
                else if (lIIlIlIIlIll == this) {
                    IBlockState lIIlIlIIlIII = lIIlIlIIllII;
                    for (final EnumFacing lIIlIlIIIlll : EnumFacing.Plane.HORIZONTAL) {
                        final PropertyBool lIIlIlIIIllI = getPropertyFor(lIIlIlIIIlll);
                        if (lIIlIllIIIIl.nextBoolean() && lIIlIllIIIlI.getValue((IProperty<Boolean>)lIIlIlIIIllI)) {
                            lIIlIlIIlIII = lIIlIlIIlIII.withProperty((IProperty<Comparable>)lIIlIlIIIllI, true);
                        }
                    }
                    if (lIIlIlIIlIII.getValue((IProperty<Boolean>)BlockVine.NORTH) || lIIlIlIIlIII.getValue((IProperty<Boolean>)BlockVine.EAST) || lIIlIlIIlIII.getValue((IProperty<Boolean>)BlockVine.SOUTH) || lIIlIlIIlIII.getValue((IProperty<Boolean>)BlockVine.WEST)) {
                        lIIlIlIIIlII.setBlockState(lIIlIlIIllIl, lIIlIlIIlIII, 2);
                    }
                }
            }
        }
    }
    
    public BlockVine() {
        super(Material.VINE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockVine.UP, false).withProperty((IProperty<Comparable>)BlockVine.NORTH, false).withProperty((IProperty<Comparable>)BlockVine.EAST, false).withProperty((IProperty<Comparable>)BlockVine.SOUTH, false).withProperty((IProperty<Comparable>)BlockVine.WEST, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lIIlllIlIllI, final IBlockAccess lIIlllIllIIl, final BlockPos lIIlllIllIII) {
        final BlockPos lIIlllIlIlll = lIIlllIllIII.up();
        return lIIlllIlIllI.withProperty((IProperty<Comparable>)BlockVine.UP, lIIlllIllIIl.getBlockState(lIIlllIlIlll).func_193401_d(lIIlllIllIIl, lIIlllIlIlll, EnumFacing.DOWN) == BlockFaceShape.SOLID);
    }
    
    private boolean func_193396_c(final World lIIllIlIIlll, final BlockPos lIIllIlIlIlI, final EnumFacing lIIllIlIlIIl) {
        final IBlockState lIIllIlIlIII = lIIllIlIIlll.getBlockState(lIIllIlIlIlI);
        return lIIllIlIlIII.func_193401_d(lIIllIlIIlll, lIIllIlIlIlI, lIIllIlIlIIl) == BlockFaceShape.SOLID && !func_193397_e(lIIllIlIlIII.getBlock());
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lIIlIIlIlllI, final BlockPos lIIlIIlIllIl, final EnumFacing lIIlIIlIllII, final float lIIlIIlIlIll, final float lIIlIIlIlIlI, final float lIIlIIlIlIIl, final int lIIlIIlIlIII, final EntityLivingBase lIIlIIlIIlll) {
        final IBlockState lIIlIIlIIllI = this.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.UP, false).withProperty((IProperty<Comparable>)BlockVine.NORTH, false).withProperty((IProperty<Comparable>)BlockVine.EAST, false).withProperty((IProperty<Comparable>)BlockVine.SOUTH, false).withProperty((IProperty<Comparable>)BlockVine.WEST, false);
        return lIIlIIlIllII.getAxis().isHorizontal() ? lIIlIIlIIllI.withProperty((IProperty<Comparable>)getPropertyFor(lIIlIIlIllII.getOpposite()), true) : lIIlIIlIIllI;
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lIIlllIIllIl, final BlockPos lIIlllIIllII) {
        return true;
    }
}
