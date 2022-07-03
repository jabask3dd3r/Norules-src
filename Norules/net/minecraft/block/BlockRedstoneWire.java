package net.minecraft.block;

import javax.annotation.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class BlockRedstoneWire extends Block
{
    protected static final /* synthetic */ AxisAlignedBB[] REDSTONE_WIRE_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    public static final /* synthetic */ PropertyEnum<EnumAttachPosition> EAST;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    public static final /* synthetic */ PropertyInteger POWER;
    public static final /* synthetic */ PropertyEnum<EnumAttachPosition> NORTH;
    public static final /* synthetic */ PropertyEnum<EnumAttachPosition> WEST;
    private final /* synthetic */ Set<BlockPos> blocksNeedingUpdate;
    private /* synthetic */ boolean canProvidePower;
    public static final /* synthetic */ PropertyEnum<EnumAttachPosition> SOUTH;
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIIIIIIIlIIllIlIlllI, final BlockPos lllllllllllllIIIIIIIlIIllIlIlIll) {
        return lllllllllllllIIIIIIIlIIllIlIlllI.getBlockState(lllllllllllllIIIIIIIlIIllIlIlIll.down()).isFullyOpaque() || lllllllllllllIIIIIIIlIIllIlIlllI.getBlockState(lllllllllllllIIIIIIIlIIllIlIlIll.down()).getBlock() == Blocks.GLOWSTONE;
    }
    
    protected static boolean canConnectTo(final IBlockState lllllllllllllIIIIIIIlIIIlIllllll, @Nullable final EnumFacing lllllllllllllIIIIIIIlIIIlIlllllI) {
        final Block lllllllllllllIIIIIIIlIIIlIllllIl = lllllllllllllIIIIIIIlIIIlIllllll.getBlock();
        if (lllllllllllllIIIIIIIlIIIlIllllIl == Blocks.REDSTONE_WIRE) {
            return true;
        }
        if (Blocks.UNPOWERED_REPEATER.isSameDiode(lllllllllllllIIIIIIIlIIIlIllllll)) {
            final EnumFacing lllllllllllllIIIIIIIlIIIlIllllII = lllllllllllllIIIIIIIlIIIlIllllll.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING);
            return lllllllllllllIIIIIIIlIIIlIllllII == lllllllllllllIIIIIIIlIIIlIlllllI || lllllllllllllIIIIIIIlIIIlIllllII.getOpposite() == lllllllllllllIIIIIIIlIIIlIlllllI;
        }
        if (Blocks.field_190976_dk == lllllllllllllIIIIIIIlIIIlIllllll.getBlock()) {
            return lllllllllllllIIIIIIIlIIIlIlllllI == lllllllllllllIIIIIIIlIIIlIllllll.getValue((IProperty<EnumFacing>)BlockObserver.FACING);
        }
        return lllllllllllllIIIIIIIlIIIlIllllll.canProvidePower() && lllllllllllllIIIIIIIlIIIlIlllllI != null;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIIIIIlIIllIllIlII) {
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRedstoneWire.NORTH, BlockRedstoneWire.EAST, BlockRedstoneWire.SOUTH, BlockRedstoneWire.WEST, BlockRedstoneWire.POWER });
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIIIIIIlIIIIllIIlII, final Rotation lllllllllllllIIIIIIIlIIIIllIIIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIIIIIIIlIIIIllIIIIl.ordinal()]) {
            case 3: {
                return lllllllllllllIIIIIIIlIIIIllIIlII.withProperty(BlockRedstoneWire.NORTH, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.SOUTH)).withProperty(BlockRedstoneWire.EAST, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.WEST)).withProperty(BlockRedstoneWire.SOUTH, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.NORTH)).withProperty(BlockRedstoneWire.WEST, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.EAST));
            }
            case 4: {
                return lllllllllllllIIIIIIIlIIIIllIIlII.withProperty(BlockRedstoneWire.NORTH, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.EAST)).withProperty(BlockRedstoneWire.EAST, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.SOUTH)).withProperty(BlockRedstoneWire.SOUTH, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.WEST)).withProperty(BlockRedstoneWire.WEST, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.NORTH));
            }
            case 2: {
                return lllllllllllllIIIIIIIlIIIIllIIlII.withProperty(BlockRedstoneWire.NORTH, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.WEST)).withProperty(BlockRedstoneWire.EAST, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.NORTH)).withProperty(BlockRedstoneWire.SOUTH, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.EAST)).withProperty(BlockRedstoneWire.WEST, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIllIIlII.getValue((IProperty<V>)BlockRedstoneWire.SOUTH));
            }
            default: {
                return lllllllllllllIIIIIIIlIIIIllIIlII;
            }
        }
    }
    
    public BlockRedstoneWire() {
        super(Material.CIRCUITS);
        this.canProvidePower = true;
        this.blocksNeedingUpdate = (Set<BlockPos>)Sets.newHashSet();
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockRedstoneWire.NORTH, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.EAST, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.SOUTH, EnumAttachPosition.NONE).withProperty(BlockRedstoneWire.WEST, EnumAttachPosition.NONE).withProperty((IProperty<Comparable>)BlockRedstoneWire.POWER, 0));
    }
    
    protected static boolean canConnectUpwardsTo(final IBlockAccess lllllllllllllIIIIIIIlIIIllIIlIlI, final BlockPos lllllllllllllIIIIIIIlIIIllIIlIIl) {
        return canConnectUpwardsTo(lllllllllllllIIIIIIIlIIIllIIlIlI.getBlockState(lllllllllllllIIIIIIIlIIIllIIlIIl));
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIIIIIIlIIIIlIllIIl, final Mirror lllllllllllllIIIIIIIlIIIIlIllIII) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllIIIIIIIlIIIIlIllIII.ordinal()]) {
            case 2: {
                return lllllllllllllIIIIIIIlIIIIlIllIIl.withProperty(BlockRedstoneWire.NORTH, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIlIllIIl.getValue((IProperty<V>)BlockRedstoneWire.SOUTH)).withProperty(BlockRedstoneWire.SOUTH, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIlIllIIl.getValue((IProperty<V>)BlockRedstoneWire.NORTH));
            }
            case 3: {
                return lllllllllllllIIIIIIIlIIIIlIllIIl.withProperty(BlockRedstoneWire.EAST, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIlIllIIl.getValue((IProperty<V>)BlockRedstoneWire.WEST)).withProperty(BlockRedstoneWire.WEST, (EnumAttachPosition)lllllllllllllIIIIIIIlIIIIlIllIIl.getValue((IProperty<V>)BlockRedstoneWire.EAST));
            }
            default: {
                return super.withMirror(lllllllllllllIIIIIIIlIIIIlIllIIl, lllllllllllllIIIIIIIlIIIIlIllIII);
            }
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIIIIIIlIIllIllIIlI) {
        return false;
    }
    
    private int getMaxCurrentStrength(final World lllllllllllllIIIIIIIlIIlIIlIIllI, final BlockPos lllllllllllllIIIIIIIlIIlIIlIIIII, final int lllllllllllllIIIIIIIlIIlIIlIIlII) {
        if (lllllllllllllIIIIIIIlIIlIIlIIllI.getBlockState(lllllllllllllIIIIIIIlIIlIIlIIIII).getBlock() != this) {
            return lllllllllllllIIIIIIIlIIlIIlIIlII;
        }
        final int lllllllllllllIIIIIIIlIIlIIlIIIll = lllllllllllllIIIIIIIlIIlIIlIIllI.getBlockState(lllllllllllllIIIIIIIlIIlIIlIIIII).getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
        return (lllllllllllllIIIIIIIlIIlIIlIIIll > lllllllllllllIIIIIIIlIIlIIlIIlII) ? lllllllllllllIIIIIIIlIIlIIlIIIll : lllllllllllllIIIIIIIlIIlIIlIIlII;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIIIIIIlIlIIIIIlIII, final IBlockAccess lllllllllllllIIIIIIIlIlIIIIIIlll, final BlockPos lllllllllllllIIIIIIIlIlIIIIIlIIl) {
        return BlockRedstoneWire.REDSTONE_WIRE_AABB[getAABBIndex(lllllllllllllIIIIIIIlIlIIIIIlIII.getActualState(lllllllllllllIIIIIIIlIlIIIIIIlll, lllllllllllllIIIIIIIlIlIIIIIlIIl))];
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllIIIIIIIlIIllIlllIII, final IBlockAccess lllllllllllllIIIIIIIlIIllIllIlll, final BlockPos lllllllllllllIIIIIIIlIIllIllIllI) {
        return BlockRedstoneWire.NULL_AABB;
    }
    
    static {
        NORTH = PropertyEnum.create("north", EnumAttachPosition.class);
        EAST = PropertyEnum.create("east", EnumAttachPosition.class);
        SOUTH = PropertyEnum.create("south", EnumAttachPosition.class);
        WEST = PropertyEnum.create("west", EnumAttachPosition.class);
        POWER = PropertyInteger.create("power", 0, 15);
        REDSTONE_WIRE_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.1875, 0.0, 0.1875, 0.8125, 0.0625, 0.8125), new AxisAlignedBB(0.1875, 0.0, 0.1875, 0.8125, 0.0625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.1875, 0.8125, 0.0625, 0.8125), new AxisAlignedBB(0.0, 0.0, 0.1875, 0.8125, 0.0625, 1.0), new AxisAlignedBB(0.1875, 0.0, 0.0, 0.8125, 0.0625, 0.8125), new AxisAlignedBB(0.1875, 0.0, 0.0, 0.8125, 0.0625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 0.8125, 0.0625, 0.8125), new AxisAlignedBB(0.0, 0.0, 0.0, 0.8125, 0.0625, 1.0), new AxisAlignedBB(0.1875, 0.0, 0.1875, 1.0, 0.0625, 0.8125), new AxisAlignedBB(0.1875, 0.0, 0.1875, 1.0, 0.0625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.1875, 1.0, 0.0625, 0.8125), new AxisAlignedBB(0.0, 0.0, 0.1875, 1.0, 0.0625, 1.0), new AxisAlignedBB(0.1875, 0.0, 0.0, 1.0, 0.0625, 0.8125), new AxisAlignedBB(0.1875, 0.0, 0.0, 1.0, 0.0625, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0625, 0.8125), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0) };
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllIIIIIIIlIIlIIIIIlIl, final IBlockAccess lllllllllllllIIIIIIIlIIIllllllll, final BlockPos lllllllllllllIIIIIIIlIIlIIIIIIll, final EnumFacing lllllllllllllIIIIIIIlIIlIIIIIIlI) {
        return this.canProvidePower ? lllllllllllllIIIIIIIlIIlIIIIIlIl.getWeakPower(lllllllllllllIIIIIIIlIIIllllllll, lllllllllllllIIIIIIIlIIlIIIIIIll, lllllllllllllIIIIIIIlIIlIIIIIIlI) : 0;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIIIIIIlIIlIIIllIII, final World lllllllllllllIIIIIIIlIIlIIIlIlll, final BlockPos lllllllllllllIIIIIIIlIIlIIIlIIII, final Block lllllllllllllIIIIIIIlIIlIIIlIlIl, final BlockPos lllllllllllllIIIIIIIlIIlIIIlIlII) {
        if (!lllllllllllllIIIIIIIlIIlIIIlIlll.isRemote) {
            if (this.canPlaceBlockAt(lllllllllllllIIIIIIIlIIlIIIlIlll, lllllllllllllIIIIIIIlIIlIIIlIIII)) {
                this.updateSurroundingRedstone(lllllllllllllIIIIIIIlIIlIIIlIlll, lllllllllllllIIIIIIIlIIlIIIlIIII, lllllllllllllIIIIIIIlIIlIIIllIII);
            }
            else {
                this.dropBlockAsItem(lllllllllllllIIIIIIIlIIlIIIlIlll, lllllllllllllIIIIIIIlIIlIIIlIIII, lllllllllllllIIIIIIIlIIlIIIllIII, 0);
                lllllllllllllIIIIIIIlIIlIIIlIlll.setBlockToAir(lllllllllllllIIIIIIIlIIlIIIlIIII);
            }
        }
    }
    
    public static int colorMultiplier(final int lllllllllllllIIIIIIIlIIIlIlIIIll) {
        final float lllllllllllllIIIIIIIlIIIlIlIlIlI = lllllllllllllIIIIIIIlIIIlIlIIIll / 15.0f;
        float lllllllllllllIIIIIIIlIIIlIlIlIIl = lllllllllllllIIIIIIIlIIIlIlIlIlI * 0.6f + 0.4f;
        if (lllllllllllllIIIIIIIlIIIlIlIIIll == 0) {
            lllllllllllllIIIIIIIlIIIlIlIlIIl = 0.3f;
        }
        float lllllllllllllIIIIIIIlIIIlIlIlIII = lllllllllllllIIIIIIIlIIIlIlIlIlI * lllllllllllllIIIIIIIlIIIlIlIlIlI * 0.7f - 0.5f;
        float lllllllllllllIIIIIIIlIIIlIlIIlll = lllllllllllllIIIIIIIlIIIlIlIlIlI * lllllllllllllIIIIIIIlIIIlIlIlIlI * 0.6f - 0.7f;
        if (lllllllllllllIIIIIIIlIIIlIlIlIII < 0.0f) {
            lllllllllllllIIIIIIIlIIIlIlIlIII = 0.0f;
        }
        if (lllllllllllllIIIIIIIlIIIlIlIIlll < 0.0f) {
            lllllllllllllIIIIIIIlIIIlIlIIlll = 0.0f;
        }
        final int lllllllllllllIIIIIIIlIIIlIlIIllI = MathHelper.clamp((int)(lllllllllllllIIIIIIIlIIIlIlIlIIl * 255.0f), 0, 255);
        final int lllllllllllllIIIIIIIlIIIlIlIIlIl = MathHelper.clamp((int)(lllllllllllllIIIIIIIlIIIlIlIlIII * 255.0f), 0, 255);
        final int lllllllllllllIIIIIIIlIIIlIlIIlII = MathHelper.clamp((int)(lllllllllllllIIIIIIIlIIIlIlIIlll * 255.0f), 0, 255);
        return 0xFF000000 | lllllllllllllIIIIIIIlIIIlIlIIllI << 16 | lllllllllllllIIIIIIIlIIIlIlIIlIl << 8 | lllllllllllllIIIIIIIlIIIlIlIIlII;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIIIIIlIIIIllIlIII) {
        return lllllllllllllIIIIIIIlIIIIllIlIII.getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
    }
    
    private IBlockState updateSurroundingRedstone(final World lllllllllllllIIIIIIIlIIllIIlllII, final BlockPos lllllllllllllIIIIIIIlIIllIIllIll, IBlockState lllllllllllllIIIIIIIlIIllIIllIlI) {
        lllllllllllllIIIIIIIlIIllIIllIlI = this.calculateCurrentChanges(lllllllllllllIIIIIIIlIIllIIlllII, lllllllllllllIIIIIIIlIIllIIllIll, lllllllllllllIIIIIIIlIIllIIllIll, lllllllllllllIIIIIIIlIIllIIllIlI);
        final List<BlockPos> lllllllllllllIIIIIIIlIIllIIlllll = (List<BlockPos>)Lists.newArrayList((Iterable)this.blocksNeedingUpdate);
        this.blocksNeedingUpdate.clear();
        for (final BlockPos lllllllllllllIIIIIIIlIIllIIllllI : lllllllllllllIIIIIIIlIIllIIlllll) {
            lllllllllllllIIIIIIIlIIllIIlllII.notifyNeighborsOfStateChange(lllllllllllllIIIIIIIlIIllIIllllI, this, false);
        }
        return lllllllllllllIIIIIIIlIIllIIllIlI;
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllIIIIIIIlIIIlllIlIlI, final IBlockAccess lllllllllllllIIIIIIIlIIIllllIIIl, final BlockPos lllllllllllllIIIIIIIlIIIlllIlIII, final EnumFacing lllllllllllllIIIIIIIlIIIlllIllll) {
        if (!this.canProvidePower) {
            return 0;
        }
        final int lllllllllllllIIIIIIIlIIIlllIlllI = lllllllllllllIIIIIIIlIIIlllIlIlI.getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
        if (lllllllllllllIIIIIIIlIIIlllIlllI == 0) {
            return 0;
        }
        if (lllllllllllllIIIIIIIlIIIlllIllll == EnumFacing.UP) {
            return lllllllllllllIIIIIIIlIIIlllIlllI;
        }
        final EnumSet<EnumFacing> lllllllllllllIIIIIIIlIIIlllIllIl = EnumSet.noneOf(EnumFacing.class);
        for (final EnumFacing lllllllllllllIIIIIIIlIIIlllIllII : EnumFacing.Plane.HORIZONTAL) {
            if (this.isPowerSourceAt(lllllllllllllIIIIIIIlIIIllllIIIl, lllllllllllllIIIIIIIlIIIlllIlIII, lllllllllllllIIIIIIIlIIIlllIllII)) {
                lllllllllllllIIIIIIIlIIIlllIllIl.add(lllllllllllllIIIIIIIlIIIlllIllII);
            }
        }
        if (lllllllllllllIIIIIIIlIIIlllIllll.getAxis().isHorizontal() && lllllllllllllIIIIIIIlIIIlllIllIl.isEmpty()) {
            return lllllllllllllIIIIIIIlIIIlllIlllI;
        }
        if (lllllllllllllIIIIIIIlIIIlllIllIl.contains(lllllllllllllIIIIIIIlIIIlllIllll) && !lllllllllllllIIIIIIIlIIIlllIllIl.contains(lllllllllllllIIIIIIIlIIIlllIllll.rotateYCCW()) && !lllllllllllllIIIIIIIlIIIlllIllIl.contains(lllllllllllllIIIIIIIlIIIlllIllll.rotateY())) {
            return lllllllllllllIIIIIIIlIIIlllIlllI;
        }
        return 0;
    }
    
    private void notifyWireNeighborsOfStateChange(final World lllllllllllllIIIIIIIlIIlIllIIlII, final BlockPos lllllllllllllIIIIIIIlIIlIllIIIll) {
        if (lllllllllllllIIIIIIIlIIlIllIIlII.getBlockState(lllllllllllllIIIIIIIlIIlIllIIIll).getBlock() == this) {
            lllllllllllllIIIIIIIlIIlIllIIlII.notifyNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIllIIIll, this, false);
            final String lllllllllllllIIIIIIIlIIlIlIllIll;
            final boolean lllllllllllllIIIIIIIlIIlIlIlllII = ((EnumFacing[])(Object)(lllllllllllllIIIIIIIlIIlIlIllIll = (String)(Object)EnumFacing.values())).length != 0;
            for (float lllllllllllllIIIIIIIlIIlIlIlllIl = 0; lllllllllllllIIIIIIIlIIlIlIlllIl < (lllllllllllllIIIIIIIlIIlIlIlllII ? 1 : 0); ++lllllllllllllIIIIIIIlIIlIlIlllIl) {
                final EnumFacing lllllllllllllIIIIIIIlIIlIllIIIlI = lllllllllllllIIIIIIIlIIlIlIllIll[lllllllllllllIIIIIIIlIIlIlIlllIl];
                lllllllllllllIIIIIIIlIIlIllIIlII.notifyNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIllIIIll.offset(lllllllllllllIIIIIIIlIIlIllIIIlI), this, false);
            }
        }
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllIIIIIIIlIIIlIllIlIl) {
        return this.canProvidePower;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIIIIIIlIIIIlIlIIll, final IBlockState lllllllllllllIIIIIIIlIIIIlIlIIlI, final BlockPos lllllllllllllIIIIIIIlIIIIlIlIIIl, final EnumFacing lllllllllllllIIIIIIIlIIIIlIlIIII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIIIIIIlIIlIIIIlllI, final Random lllllllllllllIIIIIIIlIIlIIIIllIl, final int lllllllllllllIIIIIIIlIIlIIIIllII) {
        return Items.REDSTONE;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIIIIIIIlIIlIIllIIll, final BlockPos lllllllllllllIIIIIIIlIIlIIlllIlI, final IBlockState lllllllllllllIIIIIIIlIIlIIllIIIl) {
        super.breakBlock(lllllllllllllIIIIIIIlIIlIIllIIll, lllllllllllllIIIIIIIlIIlIIlllIlI, lllllllllllllIIIIIIIlIIlIIllIIIl);
        if (!lllllllllllllIIIIIIIlIIlIIllIIll.isRemote) {
            final boolean lllllllllllllIIIIIIIlIIlIIlIllIl;
            final boolean lllllllllllllIIIIIIIlIIlIIlIlllI = ((EnumFacing[])(Object)(lllllllllllllIIIIIIIlIIlIIlIllIl = (boolean)(Object)EnumFacing.values())).length != 0;
            for (char lllllllllllllIIIIIIIlIIlIIlIllll = '\0'; lllllllllllllIIIIIIIlIIlIIlIllll < (lllllllllllllIIIIIIIlIIlIIlIlllI ? 1 : 0); ++lllllllllllllIIIIIIIlIIlIIlIllll) {
                final EnumFacing lllllllllllllIIIIIIIlIIlIIlllIII = lllllllllllllIIIIIIIlIIlIIlIllIl[lllllllllllllIIIIIIIlIIlIIlIllll];
                lllllllllllllIIIIIIIlIIlIIllIIll.notifyNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIIlllIlI.offset(lllllllllllllIIIIIIIlIIlIIlllIII), this, false);
            }
            this.updateSurroundingRedstone(lllllllllllllIIIIIIIlIIlIIllIIll, lllllllllllllIIIIIIIlIIlIIlllIlI, lllllllllllllIIIIIIIlIIlIIllIIIl);
            for (final EnumFacing lllllllllllllIIIIIIIlIIlIIllIlll : EnumFacing.Plane.HORIZONTAL) {
                this.notifyWireNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIIllIIll, lllllllllllllIIIIIIIlIIlIIlllIlI.offset(lllllllllllllIIIIIIIlIIlIIllIlll));
            }
            for (final EnumFacing lllllllllllllIIIIIIIlIIlIIllIllI : EnumFacing.Plane.HORIZONTAL) {
                final BlockPos lllllllllllllIIIIIIIlIIlIIllIlIl = lllllllllllllIIIIIIIlIIlIIlllIlI.offset(lllllllllllllIIIIIIIlIIlIIllIllI);
                if (lllllllllllllIIIIIIIlIIlIIllIIll.getBlockState(lllllllllllllIIIIIIIlIIlIIllIlIl).isNormalCube()) {
                    this.notifyWireNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIIllIIll, lllllllllllllIIIIIIIlIIlIIllIlIl.up());
                }
                else {
                    this.notifyWireNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIIllIIll, lllllllllllllIIIIIIIlIIlIIllIlIl.down());
                }
            }
        }
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIIIIIIIlIIIIlllIlIl, final BlockPos lllllllllllllIIIIIIIlIIIIlllIlII, final IBlockState lllllllllllllIIIIIIIlIIIIlllIIll) {
        return new ItemStack(Items.REDSTONE);
    }
    
    private EnumAttachPosition getAttachPosition(final IBlockAccess lllllllllllllIIIIIIIlIIlllIIIllI, final BlockPos lllllllllllllIIIIIIIlIIlllIlIIIl, final EnumFacing lllllllllllllIIIIIIIlIIlllIIIIll) {
        final BlockPos lllllllllllllIIIIIIIlIIlllIIllIl = lllllllllllllIIIIIIIlIIlllIlIIIl.offset(lllllllllllllIIIIIIIlIIlllIIIIll);
        final IBlockState lllllllllllllIIIIIIIlIIlllIIlIll = lllllllllllllIIIIIIIlIIlllIIIllI.getBlockState(lllllllllllllIIIIIIIlIIlllIlIIIl.offset(lllllllllllllIIIIIIIlIIlllIIIIll));
        if (!canConnectTo(lllllllllllllIIIIIIIlIIlllIIIllI.getBlockState(lllllllllllllIIIIIIIlIIlllIIllIl), lllllllllllllIIIIIIIlIIlllIIIIll) && (lllllllllllllIIIIIIIlIIlllIIlIll.isNormalCube() || !canConnectUpwardsTo(lllllllllllllIIIIIIIlIIlllIIIllI.getBlockState(lllllllllllllIIIIIIIlIIlllIIllIl.down())))) {
            final IBlockState lllllllllllllIIIIIIIlIIlllIIlIIl = lllllllllllllIIIIIIIlIIlllIIIllI.getBlockState(lllllllllllllIIIIIIIlIIlllIlIIIl.up());
            if (!lllllllllllllIIIIIIIlIIlllIIlIIl.isNormalCube()) {
                final boolean lllllllllllllIIIIIIIlIIlllIIIlll = lllllllllllllIIIIIIIlIIlllIIIllI.getBlockState(lllllllllllllIIIIIIIlIIlllIIllIl).isFullyOpaque() || lllllllllllllIIIIIIIlIIlllIIIllI.getBlockState(lllllllllllllIIIIIIIlIIlllIIllIl).getBlock() == Blocks.GLOWSTONE;
                if (lllllllllllllIIIIIIIlIIlllIIIlll && canConnectUpwardsTo(lllllllllllllIIIIIIIlIIlllIIIllI.getBlockState(lllllllllllllIIIIIIIlIIlllIIllIl.up()))) {
                    if (lllllllllllllIIIIIIIlIIlllIIlIll.isBlockNormalCube()) {
                        return EnumAttachPosition.UP;
                    }
                    return EnumAttachPosition.SIDE;
                }
            }
            return EnumAttachPosition.NONE;
        }
        return EnumAttachPosition.SIDE;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIIIIIlIIIIllIllII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneWire.POWER, lllllllllllllIIIIIIIlIIIIllIllII);
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllIIIIIIIlIIllllIlIlI, final IBlockAccess lllllllllllllIIIIIIIlIIllllIlIIl, final BlockPos lllllllllllllIIIIIIIlIIllllIllII) {
        lllllllllllllIIIIIIIlIIllllIlIlI = lllllllllllllIIIIIIIlIIllllIlIlI.withProperty(BlockRedstoneWire.WEST, this.getAttachPosition(lllllllllllllIIIIIIIlIIllllIlIIl, lllllllllllllIIIIIIIlIIllllIllII, EnumFacing.WEST));
        lllllllllllllIIIIIIIlIIllllIlIlI = lllllllllllllIIIIIIIlIIllllIlIlI.withProperty(BlockRedstoneWire.EAST, this.getAttachPosition(lllllllllllllIIIIIIIlIIllllIlIIl, lllllllllllllIIIIIIIlIIllllIllII, EnumFacing.EAST));
        lllllllllllllIIIIIIIlIIllllIlIlI = lllllllllllllIIIIIIIlIIllllIlIlI.withProperty(BlockRedstoneWire.NORTH, this.getAttachPosition(lllllllllllllIIIIIIIlIIllllIlIIl, lllllllllllllIIIIIIIlIIllllIllII, EnumFacing.NORTH));
        lllllllllllllIIIIIIIlIIllllIlIlI = lllllllllllllIIIIIIIlIIllllIlIlI.withProperty(BlockRedstoneWire.SOUTH, this.getAttachPosition(lllllllllllllIIIIIIIlIIllllIlIIl, lllllllllllllIIIIIIIlIIllllIllII, EnumFacing.SOUTH));
        return lllllllllllllIIIIIIIlIIllllIlIlI;
    }
    
    protected static boolean canConnectUpwardsTo(final IBlockState lllllllllllllIIIIIIIlIIIllIIIlIl) {
        return canConnectTo(lllllllllllllIIIIIIIlIIIllIIIlIl, null);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIIIIIIIlIIlIlIIlIlI, final BlockPos lllllllllllllIIIIIIIlIIlIlIIlIIl, final IBlockState lllllllllllllIIIIIIIlIIlIlIIlIII) {
        if (!lllllllllllllIIIIIIIlIIlIlIIlIlI.isRemote) {
            this.updateSurroundingRedstone(lllllllllllllIIIIIIIlIIlIlIIlIlI, lllllllllllllIIIIIIIlIIlIlIIlIIl, lllllllllllllIIIIIIIlIIlIlIIlIII);
            for (final EnumFacing lllllllllllllIIIIIIIlIIlIlIIllll : EnumFacing.Plane.VERTICAL) {
                lllllllllllllIIIIIIIlIIlIlIIlIlI.notifyNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIlIIlIIl.offset(lllllllllllllIIIIIIIlIIlIlIIllll), this, false);
            }
            for (final EnumFacing lllllllllllllIIIIIIIlIIlIlIIlllI : EnumFacing.Plane.HORIZONTAL) {
                this.notifyWireNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIlIIlIlI, lllllllllllllIIIIIIIlIIlIlIIlIIl.offset(lllllllllllllIIIIIIIlIIlIlIIlllI));
            }
            for (final EnumFacing lllllllllllllIIIIIIIlIIlIlIIllIl : EnumFacing.Plane.HORIZONTAL) {
                final BlockPos lllllllllllllIIIIIIIlIIlIlIIllII = lllllllllllllIIIIIIIlIIlIlIIlIIl.offset(lllllllllllllIIIIIIIlIIlIlIIllIl);
                if (lllllllllllllIIIIIIIlIIlIlIIlIlI.getBlockState(lllllllllllllIIIIIIIlIIlIlIIllII).isNormalCube()) {
                    this.notifyWireNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIlIIlIlI, lllllllllllllIIIIIIIlIIlIlIIllII.up());
                }
                else {
                    this.notifyWireNeighborsOfStateChange(lllllllllllllIIIIIIIlIIlIlIIlIlI, lllllllllllllIIIIIIIlIIlIlIIllII.down());
                }
            }
        }
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    private static int getAABBIndex(final IBlockState lllllllllllllIIIIIIIlIIlllllllll) {
        int lllllllllllllIIIIIIIlIIllllllllI = 0;
        final boolean lllllllllllllIIIIIIIlIIlllllllIl = lllllllllllllIIIIIIIlIIlllllllll.getValue(BlockRedstoneWire.NORTH) != EnumAttachPosition.NONE;
        final boolean lllllllllllllIIIIIIIlIIlllllllII = lllllllllllllIIIIIIIlIIlllllllll.getValue(BlockRedstoneWire.EAST) != EnumAttachPosition.NONE;
        final boolean lllllllllllllIIIIIIIlIIllllllIll = lllllllllllllIIIIIIIlIIlllllllll.getValue(BlockRedstoneWire.SOUTH) != EnumAttachPosition.NONE;
        final boolean lllllllllllllIIIIIIIlIIllllllIlI = lllllllllllllIIIIIIIlIIlllllllll.getValue(BlockRedstoneWire.WEST) != EnumAttachPosition.NONE;
        if (lllllllllllllIIIIIIIlIIlllllllIl || (lllllllllllllIIIIIIIlIIllllllIll && !lllllllllllllIIIIIIIlIIlllllllIl && !lllllllllllllIIIIIIIlIIlllllllII && !lllllllllllllIIIIIIIlIIllllllIlI)) {
            lllllllllllllIIIIIIIlIIllllllllI |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }
        if (lllllllllllllIIIIIIIlIIlllllllII || (lllllllllllllIIIIIIIlIIllllllIlI && !lllllllllllllIIIIIIIlIIlllllllIl && !lllllllllllllIIIIIIIlIIlllllllII && !lllllllllllllIIIIIIIlIIllllllIll)) {
            lllllllllllllIIIIIIIlIIllllllllI |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }
        if (lllllllllllllIIIIIIIlIIllllllIll || (lllllllllllllIIIIIIIlIIlllllllIl && !lllllllllllllIIIIIIIlIIlllllllII && !lllllllllllllIIIIIIIlIIllllllIll && !lllllllllllllIIIIIIIlIIllllllIlI)) {
            lllllllllllllIIIIIIIlIIllllllllI |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }
        if (lllllllllllllIIIIIIIlIIllllllIlI || (lllllllllllllIIIIIIIlIIlllllllII && !lllllllllllllIIIIIIIlIIlllllllIl && !lllllllllllllIIIIIIIlIIllllllIll && !lllllllllllllIIIIIIIlIIllllllIlI)) {
            lllllllllllllIIIIIIIlIIllllllllI |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }
        return lllllllllllllIIIIIIIlIIllllllllI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockRedstoneWire.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final int lllllllllllllIIIIIIIlIIIIlIIllII = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllIIIIIIIlIIIIlIIllII[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIIIIlIIIIlIIllII[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIIIIlIIIIlIIllII[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRedstoneWire.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllIIIIIIIlIIIIlIIllII;
    }
    
    private boolean isPowerSourceAt(final IBlockAccess lllllllllllllIIIIIIIlIIIllIlIIll, final BlockPos lllllllllllllIIIIIIIlIIIllIlIIlI, final EnumFacing lllllllllllllIIIIIIIlIIIllIlIIIl) {
        final BlockPos lllllllllllllIIIIIIIlIIIllIlIlll = lllllllllllllIIIIIIIlIIIllIlIIlI.offset(lllllllllllllIIIIIIIlIIIllIlIIIl);
        final IBlockState lllllllllllllIIIIIIIlIIIllIlIllI = lllllllllllllIIIIIIIlIIIllIlIIll.getBlockState(lllllllllllllIIIIIIIlIIIllIlIlll);
        final boolean lllllllllllllIIIIIIIlIIIllIlIlIl = lllllllllllllIIIIIIIlIIIllIlIllI.isNormalCube();
        final boolean lllllllllllllIIIIIIIlIIIllIlIlII = lllllllllllllIIIIIIIlIIIllIlIIll.getBlockState(lllllllllllllIIIIIIIlIIIllIlIIlI.up()).isNormalCube();
        return (!lllllllllllllIIIIIIIlIIIllIlIlII && lllllllllllllIIIIIIIlIIIllIlIlIl && canConnectUpwardsTo(lllllllllllllIIIIIIIlIIIllIlIIll, lllllllllllllIIIIIIIlIIIllIlIlll.up())) || canConnectTo(lllllllllllllIIIIIIIlIIIllIlIllI, lllllllllllllIIIIIIIlIIIllIlIIIl) || (lllllllllllllIIIIIIIlIIIllIlIllI.getBlock() == Blocks.POWERED_REPEATER && lllllllllllllIIIIIIIlIIIllIlIllI.getValue((IProperty<Comparable>)BlockRedstoneDiode.FACING) == lllllllllllllIIIIIIIlIIIllIlIIIl) || (!lllllllllllllIIIIIIIlIIIllIlIlIl && canConnectUpwardsTo(lllllllllllllIIIIIIIlIIIllIlIIll, lllllllllllllIIIIIIIlIIIllIlIlll.down()));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRedstoneWire.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final float lllllllllllllIIIIIIIlIIIIlIIlllI = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIIIIIIIlIIIIlIIlllI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIIIIlIIIIlIIlllI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIIIIlIIIIlIIlllI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIIIIIlIIIIlIIlllI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRedstoneWire.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIIIIIIIlIIIIlIIlllI;
    }
    
    private IBlockState calculateCurrentChanges(final World lllllllllllllIIIIIIIlIIllIIIIlll, final BlockPos lllllllllllllIIIIIIIlIIllIIIIllI, final BlockPos lllllllllllllIIIIIIIlIIllIIIIlIl, IBlockState lllllllllllllIIIIIIIlIIlIlllIllI) {
        final IBlockState lllllllllllllIIIIIIIlIIllIIIIIll = lllllllllllllIIIIIIIlIIlIlllIllI;
        final int lllllllllllllIIIIIIIlIIllIIIIIlI = lllllllllllllIIIIIIIlIIlIlllIllI.getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
        int lllllllllllllIIIIIIIlIIllIIIIIIl = 0;
        lllllllllllllIIIIIIIlIIllIIIIIIl = this.getMaxCurrentStrength(lllllllllllllIIIIIIIlIIllIIIIlll, lllllllllllllIIIIIIIlIIllIIIIlIl, lllllllllllllIIIIIIIlIIllIIIIIIl);
        this.canProvidePower = false;
        final int lllllllllllllIIIIIIIlIIllIIIIIII = lllllllllllllIIIIIIIlIIllIIIIlll.isBlockIndirectlyGettingPowered(lllllllllllllIIIIIIIlIIllIIIIllI);
        this.canProvidePower = true;
        if (lllllllllllllIIIIIIIlIIllIIIIIII > 0 && lllllllllllllIIIIIIIlIIllIIIIIII > lllllllllllllIIIIIIIlIIllIIIIIIl - 1) {
            lllllllllllllIIIIIIIlIIllIIIIIIl = lllllllllllllIIIIIIIlIIllIIIIIII;
        }
        int lllllllllllllIIIIIIIlIIlIlllllll = 0;
        for (final EnumFacing lllllllllllllIIIIIIIlIIlIllllllI : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos lllllllllllllIIIIIIIlIIlIlllllIl = lllllllllllllIIIIIIIlIIllIIIIllI.offset(lllllllllllllIIIIIIIlIIlIllllllI);
            final boolean lllllllllllllIIIIIIIlIIlIlllllII = lllllllllllllIIIIIIIlIIlIlllllIl.getX() != lllllllllllllIIIIIIIlIIllIIIIlIl.getX() || lllllllllllllIIIIIIIlIIlIlllllIl.getZ() != lllllllllllllIIIIIIIlIIllIIIIlIl.getZ();
            if (lllllllllllllIIIIIIIlIIlIlllllII) {
                lllllllllllllIIIIIIIlIIlIlllllll = this.getMaxCurrentStrength(lllllllllllllIIIIIIIlIIllIIIIlll, lllllllllllllIIIIIIIlIIlIlllllIl, lllllllllllllIIIIIIIlIIlIlllllll);
            }
            if (lllllllllllllIIIIIIIlIIllIIIIlll.getBlockState(lllllllllllllIIIIIIIlIIlIlllllIl).isNormalCube() && !lllllllllllllIIIIIIIlIIllIIIIlll.getBlockState(lllllllllllllIIIIIIIlIIllIIIIllI.up()).isNormalCube()) {
                if (!lllllllllllllIIIIIIIlIIlIlllllII || lllllllllllllIIIIIIIlIIllIIIIllI.getY() < lllllllllllllIIIIIIIlIIllIIIIlIl.getY()) {
                    continue;
                }
                lllllllllllllIIIIIIIlIIlIlllllll = this.getMaxCurrentStrength(lllllllllllllIIIIIIIlIIllIIIIlll, lllllllllllllIIIIIIIlIIlIlllllIl.up(), lllllllllllllIIIIIIIlIIlIlllllll);
            }
            else {
                if (lllllllllllllIIIIIIIlIIllIIIIlll.getBlockState(lllllllllllllIIIIIIIlIIlIlllllIl).isNormalCube() || !lllllllllllllIIIIIIIlIIlIlllllII || lllllllllllllIIIIIIIlIIllIIIIllI.getY() > lllllllllllllIIIIIIIlIIllIIIIlIl.getY()) {
                    continue;
                }
                lllllllllllllIIIIIIIlIIlIlllllll = this.getMaxCurrentStrength(lllllllllllllIIIIIIIlIIllIIIIlll, lllllllllllllIIIIIIIlIIlIlllllIl.down(), lllllllllllllIIIIIIIlIIlIlllllll);
            }
        }
        if (lllllllllllllIIIIIIIlIIlIlllllll > lllllllllllllIIIIIIIlIIllIIIIIIl) {
            lllllllllllllIIIIIIIlIIllIIIIIIl = lllllllllllllIIIIIIIlIIlIlllllll - 1;
        }
        else if (lllllllllllllIIIIIIIlIIllIIIIIIl > 0) {
            --lllllllllllllIIIIIIIlIIllIIIIIIl;
        }
        else {
            lllllllllllllIIIIIIIlIIllIIIIIIl = 0;
        }
        if (lllllllllllllIIIIIIIlIIllIIIIIII > lllllllllllllIIIIIIIlIIllIIIIIIl - 1) {
            lllllllllllllIIIIIIIlIIllIIIIIIl = lllllllllllllIIIIIIIlIIllIIIIIII;
        }
        if (lllllllllllllIIIIIIIlIIllIIIIIlI != lllllllllllllIIIIIIIlIIllIIIIIIl) {
            lllllllllllllIIIIIIIlIIlIlllIllI = lllllllllllllIIIIIIIlIIlIlllIllI.withProperty((IProperty<Comparable>)BlockRedstoneWire.POWER, lllllllllllllIIIIIIIlIIllIIIIIIl);
            if (lllllllllllllIIIIIIIlIIllIIIIlll.getBlockState(lllllllllllllIIIIIIIlIIllIIIIllI) == lllllllllllllIIIIIIIlIIllIIIIIll) {
                lllllllllllllIIIIIIIlIIllIIIIlll.setBlockState(lllllllllllllIIIIIIIlIIllIIIIllI, lllllllllllllIIIIIIIlIIlIlllIllI, 2);
            }
            this.blocksNeedingUpdate.add(lllllllllllllIIIIIIIlIIllIIIIllI);
            final short lllllllllllllIIIIIIIlIIlIllIllIl;
            final char lllllllllllllIIIIIIIlIIlIllIlllI = (char)((EnumFacing[])(Object)(lllllllllllllIIIIIIIlIIlIllIllIl = (short)(Object)EnumFacing.values())).length;
            for (boolean lllllllllllllIIIIIIIlIIlIllIllll = false; (lllllllllllllIIIIIIIlIIlIllIllll ? 1 : 0) < lllllllllllllIIIIIIIlIIlIllIlllI; ++lllllllllllllIIIIIIIlIIlIllIllll) {
                final EnumFacing lllllllllllllIIIIIIIlIIlIllllIll = lllllllllllllIIIIIIIlIIlIllIllIl[lllllllllllllIIIIIIIlIIlIllIllll];
                this.blocksNeedingUpdate.add(lllllllllllllIIIIIIIlIIllIIIIllI.offset(lllllllllllllIIIIIIIlIIlIllllIll));
            }
        }
        return lllllllllllllIIIIIIIlIIlIlllIllI;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllIIIIIIIlIIIlIIIIIlI, final World lllllllllllllIIIIIIIlIIIlIIIIIIl, final BlockPos lllllllllllllIIIIIIIlIIIlIIIllII, final Random lllllllllllllIIIIIIIlIIIlIIIlIll) {
        final int lllllllllllllIIIIIIIlIIIlIIIlIlI = lllllllllllllIIIIIIIlIIIlIIIIIlI.getValue((IProperty<Integer>)BlockRedstoneWire.POWER);
        if (lllllllllllllIIIIIIIlIIIlIIIlIlI != 0) {
            final double lllllllllllllIIIIIIIlIIIlIIIlIIl = lllllllllllllIIIIIIIlIIIlIIIllII.getX() + 0.5 + (lllllllllllllIIIIIIIlIIIlIIIlIll.nextFloat() - 0.5) * 0.2;
            final double lllllllllllllIIIIIIIlIIIlIIIlIII = lllllllllllllIIIIIIIlIIIlIIIllII.getY() + 0.0625f;
            final double lllllllllllllIIIIIIIlIIIlIIIIlll = lllllllllllllIIIIIIIlIIIlIIIllII.getZ() + 0.5 + (lllllllllllllIIIIIIIlIIIlIIIlIll.nextFloat() - 0.5) * 0.2;
            final float lllllllllllllIIIIIIIlIIIlIIIIllI = lllllllllllllIIIIIIIlIIIlIIIlIlI / 15.0f;
            final float lllllllllllllIIIIIIIlIIIlIIIIlIl = lllllllllllllIIIIIIIlIIIlIIIIllI * 0.6f + 0.4f;
            final float lllllllllllllIIIIIIIlIIIlIIIIlII = Math.max(0.0f, lllllllllllllIIIIIIIlIIIlIIIIllI * lllllllllllllIIIIIIIlIIIlIIIIllI * 0.7f - 0.5f);
            final float lllllllllllllIIIIIIIlIIIlIIIIIll = Math.max(0.0f, lllllllllllllIIIIIIIlIIIlIIIIllI * lllllllllllllIIIIIIIlIIIlIIIIllI * 0.6f - 0.7f);
            lllllllllllllIIIIIIIlIIIlIIIIIIl.spawnParticle(EnumParticleTypes.REDSTONE, lllllllllllllIIIIIIIlIIIlIIIlIIl, lllllllllllllIIIIIIIlIIIlIIIlIII, lllllllllllllIIIIIIIlIIIlIIIIlll, lllllllllllllIIIIIIIlIIIlIIIIlIl, lllllllllllllIIIIIIIlIIIlIIIIlII, lllllllllllllIIIIIIIlIIIlIIIIIll, new int[0]);
        }
    }
    
    enum EnumAttachPosition implements IStringSerializable
    {
        private final /* synthetic */ String name;
        
        NONE("NONE", 2, "none"), 
        SIDE("SIDE", 1, "side"), 
        UP("UP", 0, "up");
        
        @Override
        public String toString() {
            return this.getName();
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumAttachPosition(final String lllllllllllllllIllIlllIIlIlIIlll, final int lllllllllllllllIllIlllIIlIlIIllI, final String lllllllllllllllIllIlllIIlIlIlIIl) {
            this.name = lllllllllllllllIllIlllIIlIlIlIIl;
        }
    }
}
