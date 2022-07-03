package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import java.util.*;

public class BlockTripWire extends Block
{
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool POWERED;
    public static final /* synthetic */ PropertyBool DISARMED;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    public static final /* synthetic */ PropertyBool ATTACHED;
    public static final /* synthetic */ PropertyBool NORTH;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    public static final /* synthetic */ PropertyBool WEST;
    public static final /* synthetic */ PropertyBool SOUTH;
    protected static final /* synthetic */ AxisAlignedBB AABB;
    protected static final /* synthetic */ AxisAlignedBB TRIP_WRITE_ATTACHED_AABB;
    
    private void notifyHook(final World lllllllllllllIIlIlllIllllllIlllI, final BlockPos lllllllllllllIIlIlllIllllllIllII, final IBlockState lllllllllllllIIlIlllIlllllIlllIl) {
        final boolean lllllllllllllIIlIlllIlllllIlIlIl;
        final long lllllllllllllIIlIlllIlllllIlIllI = ((EnumFacing[])(Object)(lllllllllllllIIlIlllIlllllIlIlIl = (boolean)(Object)new EnumFacing[] { EnumFacing.SOUTH, EnumFacing.WEST })).length;
        for (Exception lllllllllllllIIlIlllIlllllIlIlll = (Exception)0; lllllllllllllIIlIlllIlllllIlIlll < lllllllllllllIIlIlllIlllllIlIllI; ++lllllllllllllIIlIlllIlllllIlIlll) {
            final EnumFacing lllllllllllllIIlIlllIllllllIlIIl = lllllllllllllIIlIlllIlllllIlIlIl[lllllllllllllIIlIlllIlllllIlIlll];
            int lllllllllllllIIlIlllIllllllIIlll = 1;
            while (lllllllllllllIIlIlllIllllllIIlll < 42) {
                final BlockPos lllllllllllllIIlIlllIllllllIIlIl = lllllllllllllIIlIlllIllllllIllII.offset(lllllllllllllIIlIlllIllllllIlIIl, lllllllllllllIIlIlllIllllllIIlll);
                final IBlockState lllllllllllllIIlIlllIllllllIIIll = lllllllllllllIIlIlllIllllllIlllI.getBlockState(lllllllllllllIIlIlllIllllllIIlIl);
                if (lllllllllllllIIlIlllIllllllIIIll.getBlock() == Blocks.TRIPWIRE_HOOK) {
                    if (lllllllllllllIIlIlllIllllllIIIll.getValue((IProperty<Comparable>)BlockTripWireHook.FACING) == lllllllllllllIIlIlllIllllllIlIIl.getOpposite()) {
                        Blocks.TRIPWIRE_HOOK.calculateState(lllllllllllllIIlIlllIllllllIlllI, lllllllllllllIIlIlllIllllllIIlIl, lllllllllllllIIlIlllIllllllIIIll, false, true, lllllllllllllIIlIlllIllllllIIlll, lllllllllllllIIlIlllIlllllIlllIl);
                        break;
                    }
                    break;
                }
                else {
                    if (lllllllllllllIIlIlllIllllllIIIll.getBlock() != Blocks.TRIPWIRE) {
                        break;
                    }
                    ++lllllllllllllIIlIlllIllllllIIlll;
                }
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIlIllllIIIllIlIllI, final Random lllllllllllllIIlIllllIIIllIlIlIl, final int lllllllllllllIIlIllllIIIllIlIlII) {
        return Items.STRING;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIlIlllIlllIlIIllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.POWERED, (lllllllllllllIIlIlllIlllIlIIllll & 0x1) > 0).withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, (lllllllllllllIIlIlllIlllIlIIllll & 0x4) > 0).withProperty((IProperty<Comparable>)BlockTripWire.DISARMED, (lllllllllllllIIlIlllIlllIlIIllll & 0x8) > 0);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIlIllllIIIlllIlllI, final IBlockAccess lllllllllllllIIlIllllIIIlllIllIl, final BlockPos lllllllllllllIIlIllllIIIlllIllII) {
        return lllllllllllllIIlIllllIIIlllIlllI.getValue((IProperty<Boolean>)BlockTripWire.ATTACHED) ? BlockTripWire.AABB : BlockTripWire.TRIP_WRITE_ATTACHED_AABB;
    }
    
    public BlockTripWire() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTripWire.POWERED, false).withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, false).withProperty((IProperty<Comparable>)BlockTripWire.DISARMED, false).withProperty((IProperty<Comparable>)BlockTripWire.NORTH, false).withProperty((IProperty<Comparable>)BlockTripWire.EAST, false).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, false).withProperty((IProperty<Comparable>)BlockTripWire.WEST, false));
        this.setTickRandomly(true);
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllIIlIllllIIIlllIIIll, final IBlockAccess lllllllllllllIIlIllllIIIlllIIlIl, final BlockPos lllllllllllllIIlIllllIIIlllIIIIl) {
        return lllllllllllllIIlIllllIIIlllIIIll.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, isConnectedTo(lllllllllllllIIlIllllIIIlllIIlIl, lllllllllllllIIlIllllIIIlllIIIIl, lllllllllllllIIlIllllIIIlllIIIll, EnumFacing.NORTH)).withProperty((IProperty<Comparable>)BlockTripWire.EAST, isConnectedTo(lllllllllllllIIlIllllIIIlllIIlIl, lllllllllllllIIlIllllIIIlllIIIIl, lllllllllllllIIlIllllIIIlllIIIll, EnumFacing.EAST)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, isConnectedTo(lllllllllllllIIlIllllIIIlllIIlIl, lllllllllllllIIlIllllIIIlllIIIIl, lllllllllllllIIlIllllIIIlllIIIll, EnumFacing.SOUTH)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, isConnectedTo(lllllllllllllIIlIllllIIIlllIIlIl, lllllllllllllIIlIllllIIIlllIIIIl, lllllllllllllIIlIllllIIIlllIIIll, EnumFacing.WEST));
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllIIlIllllIIIllIlllll, final IBlockAccess lllllllllllllIIlIllllIIIllIllllI, final BlockPos lllllllllllllIIlIllllIIIllIlllIl) {
        return BlockTripWire.NULL_AABB;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIlIllllIIIllIllIIl) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    public static boolean isConnectedTo(final IBlockAccess lllllllllllllIIlIlllIlllIlIllIIl, final BlockPos lllllllllllllIIlIlllIlllIllIIIII, final IBlockState lllllllllllllIIlIlllIlllIlIlllll, final EnumFacing lllllllllllllIIlIlllIlllIlIllllI) {
        final BlockPos lllllllllllllIIlIlllIlllIlIlllIl = lllllllllllllIIlIlllIlllIllIIIII.offset(lllllllllllllIIlIlllIlllIlIllllI);
        final IBlockState lllllllllllllIIlIlllIlllIlIlllII = lllllllllllllIIlIlllIlllIlIllIIl.getBlockState(lllllllllllllIIlIlllIlllIlIlllIl);
        final Block lllllllllllllIIlIlllIlllIlIllIll = lllllllllllllIIlIlllIlllIlIlllII.getBlock();
        if (lllllllllllllIIlIlllIlllIlIllIll == Blocks.TRIPWIRE_HOOK) {
            final EnumFacing lllllllllllllIIlIlllIlllIlIllIlI = lllllllllllllIIlIlllIlllIlIllllI.getOpposite();
            return lllllllllllllIIlIlllIlllIlIlllII.getValue((IProperty<Comparable>)BlockTripWireHook.FACING) == lllllllllllllIIlIlllIlllIlIllIlI;
        }
        return lllllllllllllIIlIlllIlllIlIllIll == Blocks.TRIPWIRE;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIlIlllIlllIlIIIIII, final Rotation lllllllllllllIIlIlllIlllIIllllll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIIlIlllIlllIIllllll.ordinal()]) {
            case 3: {
                return lllllllllllllIIlIlllIlllIlIIIIII.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.SOUTH)).withProperty((IProperty<Comparable>)BlockTripWire.EAST, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.WEST)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.NORTH)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.EAST));
            }
            case 4: {
                return lllllllllllllIIlIlllIlllIlIIIIII.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.EAST)).withProperty((IProperty<Comparable>)BlockTripWire.EAST, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.SOUTH)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.WEST)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.NORTH));
            }
            case 2: {
                return lllllllllllllIIlIlllIlllIlIIIIII.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.WEST)).withProperty((IProperty<Comparable>)BlockTripWire.EAST, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.NORTH)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.EAST)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, (Boolean)lllllllllllllIIlIlllIlllIlIIIIII.getValue((IProperty<V>)BlockTripWire.SOUTH));
            }
            default: {
                return lllllllllllllIIlIlllIlllIlIIIIII;
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIlIllllIIIllIllIll) {
        return false;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIlIlllIlllIIllIlll, final Mirror lllllllllllllIIlIlllIlllIIlllIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllIIlIlllIlllIIlllIIl.ordinal()]) {
            case 2: {
                return lllllllllllllIIlIlllIlllIIllIlll.withProperty((IProperty<Comparable>)BlockTripWire.NORTH, (Boolean)lllllllllllllIIlIlllIlllIIllIlll.getValue((IProperty<V>)BlockTripWire.SOUTH)).withProperty((IProperty<Comparable>)BlockTripWire.SOUTH, (Boolean)lllllllllllllIIlIlllIlllIIllIlll.getValue((IProperty<V>)BlockTripWire.NORTH));
            }
            case 3: {
                return lllllllllllllIIlIlllIlllIIllIlll.withProperty((IProperty<Comparable>)BlockTripWire.EAST, (Boolean)lllllllllllllIIlIlllIlllIIllIlll.getValue((IProperty<V>)BlockTripWire.WEST)).withProperty((IProperty<Comparable>)BlockTripWire.WEST, (Boolean)lllllllllllllIIlIlllIlllIIllIlll.getValue((IProperty<V>)BlockTripWire.EAST));
            }
            default: {
                return super.withMirror(lllllllllllllIIlIlllIlllIIllIlll, lllllllllllllIIlIlllIlllIIlllIIl);
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIlIlllIlllIlIIIlll) {
        int lllllllllllllIIlIlllIlllIlIIlIII = 0;
        if (lllllllllllllIIlIlllIlllIlIIIlll.getValue((IProperty<Boolean>)BlockTripWire.POWERED)) {
            lllllllllllllIIlIlllIlllIlIIlIII |= 0x1;
        }
        if (lllllllllllllIIlIlllIlllIlIIIlll.getValue((IProperty<Boolean>)BlockTripWire.ATTACHED)) {
            lllllllllllllIIlIlllIlllIlIIlIII |= 0x4;
        }
        if (lllllllllllllIIlIlllIlllIlIIIlll.getValue((IProperty<Boolean>)BlockTripWire.DISARMED)) {
            lllllllllllllIIlIlllIlllIlIIlIII |= 0x8;
        }
        return lllllllllllllIIlIlllIlllIlIIlIII;
    }
    
    @Override
    public void updateTick(final World lllllllllllllIIlIlllIllllIIllllI, final BlockPos lllllllllllllIIlIlllIllllIlIIIlI, final IBlockState lllllllllllllIIlIlllIllllIlIIIIl, final Random lllllllllllllIIlIlllIllllIlIIIII) {
        if (!lllllllllllllIIlIlllIllllIIllllI.isRemote && lllllllllllllIIlIlllIllllIIllllI.getBlockState(lllllllllllllIIlIlllIllllIlIIIlI).getValue((IProperty<Boolean>)BlockTripWire.POWERED)) {
            this.updateState(lllllllllllllIIlIlllIllllIIllllI, lllllllllllllIIlIlllIllllIlIIIlI);
        }
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIIlIllllIIIlIlllIlI, final BlockPos lllllllllllllIIlIllllIIIlIllllIl, final IBlockState lllllllllllllIIlIllllIIIlIlllIII) {
        this.notifyHook(lllllllllllllIIlIllllIIIlIlllIlI, lllllllllllllIIlIllllIIIlIllllIl, lllllllllllllIIlIllllIIIlIlllIII.withProperty((IProperty<Comparable>)BlockTripWire.POWERED, true));
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIIlIllllIIIllIlIIlI, final BlockPos lllllllllllllIIlIllllIIIllIlIIIl, final IBlockState lllllllllllllIIlIllllIIIllIlIIII) {
        return new ItemStack(Items.STRING);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockTripWire.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final int lllllllllllllIIlIlllIlllIIlIllII = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIIlIlllIlllIIlIllII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlIlllIlllIIlIllII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlIlllIlllIIlIllII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIlIlllIlllIIlIllII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockTripWire.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIIlIlllIlllIIlIllII;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllIIlIlllIllllIlllIll, final BlockPos lllllllllllllIIlIlllIllllIlllIlI, final IBlockState lllllllllllllIIlIlllIllllIlllllI, final Entity lllllllllllllIIlIlllIllllIllllIl) {
        if (!lllllllllllllIIlIlllIllllIlllIll.isRemote && !lllllllllllllIIlIlllIllllIlllllI.getValue((IProperty<Boolean>)BlockTripWire.POWERED)) {
            this.updateState(lllllllllllllIIlIlllIllllIlllIll, lllllllllllllIIlIlllIllllIlllIlI);
        }
    }
    
    @Override
    public void randomTick(final World lllllllllllllIIlIlllIllllIllIIll, final BlockPos lllllllllllllIIlIlllIllllIllIIlI, final IBlockState lllllllllllllIIlIlllIllllIllIIIl, final Random lllllllllllllIIlIlllIllllIlIllII) {
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockTripWire.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final boolean lllllllllllllIIlIlllIlllIIlIlIlI = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllIIlIlllIlllIIlIlIlI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlIlllIlllIIlIlIlI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlIlllIlllIIlIlIlI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockTripWire.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllIIlIlllIlllIIlIlIlI;
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllIIlIllllIIIlIlIlllI, final BlockPos lllllllllllllIIlIllllIIIlIllIIIl, final IBlockState lllllllllllllIIlIllllIIIlIlIllII, final EntityPlayer lllllllllllllIIlIllllIIIlIlIlIll) {
        if (!lllllllllllllIIlIllllIIIlIlIlllI.isRemote && !lllllllllllllIIlIllllIIIlIlIlIll.getHeldItemMainhand().func_190926_b() && lllllllllllllIIlIllllIIIlIlIlIll.getHeldItemMainhand().getItem() == Items.SHEARS) {
            lllllllllllllIIlIllllIIIlIlIlllI.setBlockState(lllllllllllllIIlIllllIIIlIllIIIl, lllllllllllllIIlIllllIIIlIlIllII.withProperty((IProperty<Comparable>)BlockTripWire.DISARMED, true), 4);
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTripWire.POWERED, BlockTripWire.ATTACHED, BlockTripWire.DISARMED, BlockTripWire.NORTH, BlockTripWire.EAST, BlockTripWire.WEST, BlockTripWire.SOUTH });
    }
    
    static {
        POWERED = PropertyBool.create("powered");
        ATTACHED = PropertyBool.create("attached");
        DISARMED = PropertyBool.create("disarmed");
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        AABB = new AxisAlignedBB(0.0, 0.0625, 0.0, 1.0, 0.15625, 1.0);
        TRIP_WRITE_ATTACHED_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIlIlllIlllIIllIIIl, final IBlockState lllllllllllllIIlIlllIlllIIllIIII, final BlockPos lllllllllllllIIlIlllIlllIIlIllll, final EnumFacing lllllllllllllIIlIlllIlllIIlIlllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIIlIllllIIIllIIlIlI, final BlockPos lllllllllllllIIlIllllIIIllIIIlIl, final IBlockState lllllllllllllIIlIllllIIIllIIlIII) {
        lllllllllllllIIlIllllIIIllIIlIlI.setBlockState(lllllllllllllIIlIllllIIIllIIIlIl, lllllllllllllIIlIllllIIIllIIlIII, 3);
        this.notifyHook(lllllllllllllIIlIllllIIIllIIlIlI, lllllllllllllIIlIllllIIIllIIIlIl, lllllllllllllIIlIllllIIIllIIlIII);
    }
    
    private void updateState(final World lllllllllllllIIlIlllIlllIlllIlII, final BlockPos lllllllllllllIIlIlllIlllIllllllI) {
        IBlockState lllllllllllllIIlIlllIlllIlllllII = lllllllllllllIIlIlllIlllIlllIlII.getBlockState(lllllllllllllIIlIlllIlllIllllllI);
        final boolean lllllllllllllIIlIlllIlllIllllIll = lllllllllllllIIlIlllIlllIlllllII.getValue((IProperty<Boolean>)BlockTripWire.POWERED);
        boolean lllllllllllllIIlIlllIlllIllllIlI = false;
        final List<? extends Entity> lllllllllllllIIlIlllIlllIllllIII = lllllllllllllIIlIlllIlllIlllIlII.getEntitiesWithinAABBExcludingEntity(null, lllllllllllllIIlIlllIlllIlllllII.getBoundingBox(lllllllllllllIIlIlllIlllIlllIlII, lllllllllllllIIlIlllIlllIllllllI).offset(lllllllllllllIIlIlllIlllIllllllI));
        if (!lllllllllllllIIlIlllIlllIllllIII.isEmpty()) {
            for (final Entity lllllllllllllIIlIlllIlllIlllIllI : lllllllllllllIIlIlllIlllIllllIII) {
                if (!lllllllllllllIIlIlllIlllIlllIllI.doesEntityNotTriggerPressurePlate()) {
                    lllllllllllllIIlIlllIlllIllllIlI = true;
                    break;
                }
            }
        }
        if (lllllllllllllIIlIlllIlllIllllIlI != lllllllllllllIIlIlllIlllIllllIll) {
            lllllllllllllIIlIlllIlllIlllllII = lllllllllllllIIlIlllIlllIlllllII.withProperty((IProperty<Comparable>)BlockTripWire.POWERED, lllllllllllllIIlIlllIlllIllllIlI);
            lllllllllllllIIlIlllIlllIlllIlII.setBlockState(lllllllllllllIIlIlllIlllIllllllI, lllllllllllllIIlIlllIlllIlllllII, 3);
            this.notifyHook(lllllllllllllIIlIlllIlllIlllIlII, lllllllllllllIIlIlllIlllIllllllI, lllllllllllllIIlIlllIlllIlllllII);
        }
        if (lllllllllllllIIlIlllIlllIllllIlI) {
            lllllllllllllIIlIlllIlllIlllIlII.scheduleUpdate(new BlockPos(lllllllllllllIIlIlllIlllIllllllI), this, this.tickRate(lllllllllllllIIlIlllIlllIlllIlII));
        }
    }
}
