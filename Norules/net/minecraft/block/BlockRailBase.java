package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;

public abstract class BlockRailBase extends Block
{
    protected static final /* synthetic */ AxisAlignedBB field_190959_b;
    protected static final /* synthetic */ AxisAlignedBB FLAT_AABB;
    protected final /* synthetic */ boolean isPowered;
    
    public static boolean isRailBlock(final World lIlIIIlIlIIlIll, final BlockPos lIlIIIlIlIIlIlI) {
        return isRailBlock(lIlIIIlIlIIlIll.getBlockState(lIlIIIlIlIIlIlI));
    }
    
    protected void updateState(final IBlockState lIlIIIIlllllIIl, final World lIlIIIIlllllIII, final BlockPos lIlIIIIllllIlll, final Block lIlIIIIllllIllI) {
    }
    
    public static boolean isRailBlock(final IBlockState lIlIIIlIlIIIlIl) {
        final Block lIlIIIlIlIIIlII = lIlIIIlIlIIIlIl.getBlock();
        return lIlIIIlIlIIIlII == Blocks.RAIL || lIlIIIlIlIIIlII == Blocks.GOLDEN_RAIL || lIlIIIlIlIIIlII == Blocks.DETECTOR_RAIL || lIlIIIlIlIIIlII == Blocks.ACTIVATOR_RAIL;
    }
    
    protected BlockRailBase(final boolean lIlIIIlIIllllII) {
        super(Material.CIRCUITS);
        this.isPowered = lIlIIIlIIllllII;
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lIlIIIlIIlIllII, final IBlockAccess lIlIIIlIIllIIII, final BlockPos lIlIIIlIIlIllll) {
        final EnumRailDirection lIlIIIlIIlIlllI = (lIlIIIlIIlIllII.getBlock() == this) ? lIlIIIlIIlIllII.getValue(this.getShapeProperty()) : null;
        return (lIlIIIlIIlIlllI != null && lIlIIIlIIlIlllI.isAscending()) ? BlockRailBase.field_190959_b : BlockRailBase.FLAT_AABB;
    }
    
    static {
        FLAT_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
        field_190959_b = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lIlIIIIlllIIlIl) {
        return EnumPushReaction.NORMAL;
    }
    
    @Override
    public void onBlockAdded(final World lIlIIIlIIIlIlll, final BlockPos lIlIIIlIIIlIIlI, IBlockState lIlIIIlIIIlIIIl) {
        if (!lIlIIIlIIIlIlll.isRemote) {
            lIlIIIlIIIlIIIl = this.updateDir(lIlIIIlIIIlIlll, lIlIIIlIIIlIIlI, lIlIIIlIIIlIIIl, true);
            if (this.isPowered) {
                lIlIIIlIIIlIIIl.neighborChanged(lIlIIIlIIIlIlll, lIlIIIlIIIlIIlI, this, lIlIIIlIIIlIIlI);
            }
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lIlIIIlIIIIIIII, final World lIlIIIIllllllll, final BlockPos lIlIIIlIIIIIllI, final Block lIlIIIIllllllIl, final BlockPos lIlIIIlIIIIIlII) {
        if (!lIlIIIIllllllll.isRemote) {
            final EnumRailDirection lIlIIIlIIIIIIll = lIlIIIlIIIIIIII.getValue(this.getShapeProperty());
            boolean lIlIIIlIIIIIIlI = false;
            if (!lIlIIIIllllllll.getBlockState(lIlIIIlIIIIIllI.down()).isFullyOpaque()) {
                lIlIIIlIIIIIIlI = true;
            }
            if (lIlIIIlIIIIIIll == EnumRailDirection.ASCENDING_EAST && !lIlIIIIllllllll.getBlockState(lIlIIIlIIIIIllI.east()).isFullyOpaque()) {
                lIlIIIlIIIIIIlI = true;
            }
            else if (lIlIIIlIIIIIIll == EnumRailDirection.ASCENDING_WEST && !lIlIIIIllllllll.getBlockState(lIlIIIlIIIIIllI.west()).isFullyOpaque()) {
                lIlIIIlIIIIIIlI = true;
            }
            else if (lIlIIIlIIIIIIll == EnumRailDirection.ASCENDING_NORTH && !lIlIIIIllllllll.getBlockState(lIlIIIlIIIIIllI.north()).isFullyOpaque()) {
                lIlIIIlIIIIIIlI = true;
            }
            else if (lIlIIIlIIIIIIll == EnumRailDirection.ASCENDING_SOUTH && !lIlIIIIllllllll.getBlockState(lIlIIIlIIIIIllI.south()).isFullyOpaque()) {
                lIlIIIlIIIIIIlI = true;
            }
            if (lIlIIIlIIIIIIlI && !lIlIIIIllllllll.isAirBlock(lIlIIIlIIIIIllI)) {
                this.dropBlockAsItem(lIlIIIIllllllll, lIlIIIlIIIIIllI, lIlIIIlIIIIIIII, 0);
                lIlIIIIllllllll.setBlockToAir(lIlIIIlIIIIIllI);
            }
            else {
                this.updateState(lIlIIIlIIIIIIII, lIlIIIIllllllll, lIlIIIlIIIIIllI, lIlIIIIllllllIl);
            }
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lIlIIIlIIlIlIIl, final IBlockState lIlIIIlIIlIlIII, final BlockPos lIlIIIlIIlIIlll, final EnumFacing lIlIIIlIIlIIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lIlIIIlIIlllIlI, final IBlockAccess lIlIIIlIIlllIIl, final BlockPos lIlIIIlIIlllIII) {
        return BlockRailBase.NULL_AABB;
    }
    
    public abstract IProperty<EnumRailDirection> getShapeProperty();
    
    @Override
    public void breakBlock(final World lIlIIIIllIllIlI, final BlockPos lIlIIIIllIllIIl, final IBlockState lIlIIIIllIlllII) {
        super.breakBlock(lIlIIIIllIllIlI, lIlIIIIllIllIIl, lIlIIIIllIlllII);
        if (lIlIIIIllIlllII.getValue(this.getShapeProperty()).isAscending()) {
            lIlIIIIllIllIlI.notifyNeighborsOfStateChange(lIlIIIIllIllIIl.up(), this, false);
        }
        if (this.isPowered) {
            lIlIIIIllIllIlI.notifyNeighborsOfStateChange(lIlIIIIllIllIIl, this, false);
            lIlIIIIllIllIlI.notifyNeighborsOfStateChange(lIlIIIIllIllIIl.down(), this, false);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lIlIIIlIIllIllI) {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lIlIIIlIIIllllI, final BlockPos lIlIIIlIIIlllll) {
        return lIlIIIlIIIllllI.getBlockState(lIlIIIlIIIlllll.down()).isFullyOpaque();
    }
    
    @Override
    public boolean isFullCube(final IBlockState lIlIIIlIIlIIlII) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    protected IBlockState updateDir(final World lIlIIIIlllIllll, final BlockPos lIlIIIIlllIlIIl, final IBlockState lIlIIIIlllIlIII, final boolean lIlIIIIlllIllII) {
        return lIlIIIIlllIllll.isRemote ? lIlIIIIlllIlIII : new Rail(lIlIIIIlllIllll, lIlIIIIlllIlIIl, lIlIIIIlllIlIII).place(lIlIIIIlllIllll.isBlockPowered(lIlIIIIlllIlIIl), lIlIIIIlllIllII).getBlockState();
    }
    
    public enum EnumRailDirection implements IStringSerializable
    {
        EAST_WEST("EAST_WEST", 1, 1, "east_west"), 
        NORTH_EAST("NORTH_EAST", 9, 9, "north_east");
        
        private final /* synthetic */ String name;
        private final /* synthetic */ int meta;
        private static final /* synthetic */ EnumRailDirection[] META_LOOKUP;
        
        ASCENDING_EAST("ASCENDING_EAST", 2, 2, "ascending_east"), 
        NORTH_SOUTH("NORTH_SOUTH", 0, 0, "north_south"), 
        ASCENDING_WEST("ASCENDING_WEST", 3, 3, "ascending_west"), 
        ASCENDING_NORTH("ASCENDING_NORTH", 4, 4, "ascending_north"), 
        SOUTH_WEST("SOUTH_WEST", 7, 7, "south_west"), 
        ASCENDING_SOUTH("ASCENDING_SOUTH", 5, 5, "ascending_south"), 
        SOUTH_EAST("SOUTH_EAST", 6, 6, "south_east"), 
        NORTH_WEST("NORTH_WEST", 8, 8, "north_west");
        
        public static EnumRailDirection byMetadata(int llllllllllllllllIlllIIlIlIllIIll) {
            if (llllllllllllllllIlllIIlIlIllIIll < 0 || llllllllllllllllIlllIIlIlIllIIll >= EnumRailDirection.META_LOOKUP.length) {
                llllllllllllllllIlllIIlIlIllIIll = 0;
            }
            return EnumRailDirection.META_LOOKUP[llllllllllllllllIlllIIlIlIllIIll];
        }
        
        private EnumRailDirection(final String llllllllllllllllIlllIIlIllIIIIlI, final int llllllllllllllllIlllIIlIllIIIIIl, final int llllllllllllllllIlllIIlIllIIIlIl, final String llllllllllllllllIlllIIlIlIllllll) {
            this.meta = llllllllllllllllIlllIIlIllIIIlIl;
            this.name = llllllllllllllllIlllIIlIlIllllll;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        static {
            META_LOOKUP = new EnumRailDirection[values().length];
            final short llllllllllllllllIlllIIlIllIIllII;
            final short llllllllllllllllIlllIIlIllIIllIl = (short)((EnumRailDirection[])(Object)(llllllllllllllllIlllIIlIllIIllII = (short)(Object)values())).length;
            for (boolean llllllllllllllllIlllIIlIllIIlllI = false; (llllllllllllllllIlllIIlIllIIlllI ? 1 : 0) < llllllllllllllllIlllIIlIllIIllIl; ++llllllllllllllllIlllIIlIllIIlllI) {
                final EnumRailDirection llllllllllllllllIlllIIlIllIlIIII = llllllllllllllllIlllIIlIllIIllII[llllllllllllllllIlllIIlIllIIlllI];
                EnumRailDirection.META_LOOKUP[llllllllllllllllIlllIIlIllIlIIII.getMetadata()] = llllllllllllllllIlllIIlIllIlIIII;
            }
        }
        
        public boolean isAscending() {
            return this == EnumRailDirection.ASCENDING_NORTH || this == EnumRailDirection.ASCENDING_EAST || this == EnumRailDirection.ASCENDING_SOUTH || this == EnumRailDirection.ASCENDING_WEST;
        }
    }
    
    public class Rail
    {
        private final /* synthetic */ BlockPos pos;
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        private final /* synthetic */ BlockRailBase block;
        private final /* synthetic */ List<BlockPos> connectedRails;
        private /* synthetic */ IBlockState state;
        private final /* synthetic */ boolean isPowered;
        private final /* synthetic */ World world;
        
        private boolean isConnectedToRail(final Rail lllllllllllllIIllIIlIlIIIIIlIlII) {
            return this.isConnectedTo(lllllllllllllIIllIIlIlIIIIIlIlII.pos);
        }
        
        private void connectTo(final Rail lllllllllllllIIllIIlIIllllIlllIl) {
            this.connectedRails.add(lllllllllllllIIllIIlIIllllIlllIl.pos);
            final BlockPos lllllllllllllIIllIIlIIlllllIIlll = this.pos.north();
            final BlockPos lllllllllllllIIllIIlIIlllllIIllI = this.pos.south();
            final BlockPos lllllllllllllIIllIIlIIlllllIIlIl = this.pos.west();
            final BlockPos lllllllllllllIIllIIlIIlllllIIlII = this.pos.east();
            final boolean lllllllllllllIIllIIlIIlllllIIIll = this.isConnectedTo(lllllllllllllIIllIIlIIlllllIIlll);
            final boolean lllllllllllllIIllIIlIIlllllIIIlI = this.isConnectedTo(lllllllllllllIIllIIlIIlllllIIllI);
            final boolean lllllllllllllIIllIIlIIlllllIIIIl = this.isConnectedTo(lllllllllllllIIllIIlIIlllllIIlIl);
            final boolean lllllllllllllIIllIIlIIlllllIIIII = this.isConnectedTo(lllllllllllllIIllIIlIIlllllIIlII);
            EnumRailDirection lllllllllllllIIllIIlIIllllIlllll = null;
            if (lllllllllllllIIllIIlIIlllllIIIll || lllllllllllllIIllIIlIIlllllIIIlI) {
                lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.NORTH_SOUTH;
            }
            if (lllllllllllllIIllIIlIIlllllIIIIl || lllllllllllllIIllIIlIIlllllIIIII) {
                lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.EAST_WEST;
            }
            if (!this.isPowered) {
                if (lllllllllllllIIllIIlIIlllllIIIlI && lllllllllllllIIllIIlIIlllllIIIII && !lllllllllllllIIllIIlIIlllllIIIll && !lllllllllllllIIllIIlIIlllllIIIIl) {
                    lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.SOUTH_EAST;
                }
                if (lllllllllllllIIllIIlIIlllllIIIlI && lllllllllllllIIllIIlIIlllllIIIIl && !lllllllllllllIIllIIlIIlllllIIIll && !lllllllllllllIIllIIlIIlllllIIIII) {
                    lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.SOUTH_WEST;
                }
                if (lllllllllllllIIllIIlIIlllllIIIll && lllllllllllllIIllIIlIIlllllIIIIl && !lllllllllllllIIllIIlIIlllllIIIlI && !lllllllllllllIIllIIlIIlllllIIIII) {
                    lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.NORTH_WEST;
                }
                if (lllllllllllllIIllIIlIIlllllIIIll && lllllllllllllIIllIIlIIlllllIIIII && !lllllllllllllIIllIIlIIlllllIIIlI && !lllllllllllllIIllIIlIIlllllIIIIl) {
                    lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.NORTH_EAST;
                }
            }
            if (lllllllllllllIIllIIlIIllllIlllll == EnumRailDirection.NORTH_SOUTH) {
                if (BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIIlllllIIlll.up())) {
                    lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.ASCENDING_NORTH;
                }
                if (BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIIlllllIIllI.up())) {
                    lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.ASCENDING_SOUTH;
                }
            }
            if (lllllllllllllIIllIIlIIllllIlllll == EnumRailDirection.EAST_WEST) {
                if (BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIIlllllIIlII.up())) {
                    lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.ASCENDING_EAST;
                }
                if (BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIIlllllIIlIl.up())) {
                    lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.ASCENDING_WEST;
                }
            }
            if (lllllllllllllIIllIIlIIllllIlllll == null) {
                lllllllllllllIIllIIlIIllllIlllll = EnumRailDirection.NORTH_SOUTH;
            }
            this.state = this.state.withProperty(this.block.getShapeProperty(), lllllllllllllIIllIIlIIllllIlllll);
            this.world.setBlockState(this.pos, this.state, 3);
        }
        
        private boolean hasNeighborRail(final BlockPos lllllllllllllIIllIIlIIllllIIllll) {
            final Rail lllllllllllllIIllIIlIIllllIIlllI = this.findRailAt(lllllllllllllIIllIIlIIllllIIllll);
            if (lllllllllllllIIllIIlIIllllIIlllI == null) {
                return false;
            }
            lllllllllllllIIllIIlIIllllIIlllI.removeSoftConnections();
            return lllllllllllllIIllIIlIIllllIIlllI.canConnectTo(this);
        }
        
        private void updateConnectedRails(final EnumRailDirection lllllllllllllIIllIIlIlIIIIllIIll) {
            this.connectedRails.clear();
            switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[lllllllllllllIIllIIlIlIIIIllIIll.ordinal()]) {
                case 1: {
                    this.connectedRails.add(this.pos.north());
                    this.connectedRails.add(this.pos.south());
                    break;
                }
                case 2: {
                    this.connectedRails.add(this.pos.west());
                    this.connectedRails.add(this.pos.east());
                    break;
                }
                case 3: {
                    this.connectedRails.add(this.pos.west());
                    this.connectedRails.add(this.pos.east().up());
                    break;
                }
                case 4: {
                    this.connectedRails.add(this.pos.west().up());
                    this.connectedRails.add(this.pos.east());
                    break;
                }
                case 5: {
                    this.connectedRails.add(this.pos.north().up());
                    this.connectedRails.add(this.pos.south());
                    break;
                }
                case 6: {
                    this.connectedRails.add(this.pos.north());
                    this.connectedRails.add(this.pos.south().up());
                    break;
                }
                case 7: {
                    this.connectedRails.add(this.pos.east());
                    this.connectedRails.add(this.pos.south());
                    break;
                }
                case 8: {
                    this.connectedRails.add(this.pos.west());
                    this.connectedRails.add(this.pos.south());
                    break;
                }
                case 9: {
                    this.connectedRails.add(this.pos.west());
                    this.connectedRails.add(this.pos.north());
                    break;
                }
                case 10: {
                    this.connectedRails.add(this.pos.east());
                    this.connectedRails.add(this.pos.north());
                    break;
                }
            }
        }
        
        public Rail(final World lllllllllllllIIllIIlIlIIIlIIIlIl, final BlockPos lllllllllllllIIllIIlIlIIIIlllllI, final IBlockState lllllllllllllIIllIIlIlIIIlIIIIll) {
            this.connectedRails = (List<BlockPos>)Lists.newArrayList();
            this.world = lllllllllllllIIllIIlIlIIIlIIIlIl;
            this.pos = lllllllllllllIIllIIlIlIIIIlllllI;
            this.state = lllllllllllllIIllIIlIlIIIlIIIIll;
            this.block = (BlockRailBase)lllllllllllllIIllIIlIlIIIlIIIIll.getBlock();
            final EnumRailDirection lllllllllllllIIllIIlIlIIIlIIIIlI = lllllllllllllIIllIIlIlIIIlIIIIll.getValue(this.block.getShapeProperty());
            this.isPowered = this.block.isPowered;
            this.updateConnectedRails(lllllllllllllIIllIIlIlIIIlIIIIlI);
        }
        
        public Rail place(final boolean lllllllllllllIIllIIlIIlllIlIllIl, final boolean lllllllllllllIIllIIlIIlllIlIllII) {
            final BlockPos lllllllllllllIIllIIlIIlllIlllIIl = this.pos.north();
            final BlockPos lllllllllllllIIllIIlIIlllIlllIII = this.pos.south();
            final BlockPos lllllllllllllIIllIIlIIlllIllIlll = this.pos.west();
            final BlockPos lllllllllllllIIllIIlIIlllIllIllI = this.pos.east();
            final boolean lllllllllllllIIllIIlIIlllIllIlIl = this.hasNeighborRail(lllllllllllllIIllIIlIIlllIlllIIl);
            final boolean lllllllllllllIIllIIlIIlllIllIlII = this.hasNeighborRail(lllllllllllllIIllIIlIIlllIlllIII);
            final boolean lllllllllllllIIllIIlIIlllIllIIll = this.hasNeighborRail(lllllllllllllIIllIIlIIlllIllIlll);
            final boolean lllllllllllllIIllIIlIIlllIllIIlI = this.hasNeighborRail(lllllllllllllIIllIIlIIlllIllIllI);
            EnumRailDirection lllllllllllllIIllIIlIIlllIllIIIl = null;
            if ((lllllllllllllIIllIIlIIlllIllIlIl || lllllllllllllIIllIIlIIlllIllIlII) && !lllllllllllllIIllIIlIIlllIllIIll && !lllllllllllllIIllIIlIIlllIllIIlI) {
                lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.NORTH_SOUTH;
            }
            if ((lllllllllllllIIllIIlIIlllIllIIll || lllllllllllllIIllIIlIIlllIllIIlI) && !lllllllllllllIIllIIlIIlllIllIlIl && !lllllllllllllIIllIIlIIlllIllIlII) {
                lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.EAST_WEST;
            }
            if (!this.isPowered) {
                if (lllllllllllllIIllIIlIIlllIllIlII && lllllllllllllIIllIIlIIlllIllIIlI && !lllllllllllllIIllIIlIIlllIllIlIl && !lllllllllllllIIllIIlIIlllIllIIll) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.SOUTH_EAST;
                }
                if (lllllllllllllIIllIIlIIlllIllIlII && lllllllllllllIIllIIlIIlllIllIIll && !lllllllllllllIIllIIlIIlllIllIlIl && !lllllllllllllIIllIIlIIlllIllIIlI) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.SOUTH_WEST;
                }
                if (lllllllllllllIIllIIlIIlllIllIlIl && lllllllllllllIIllIIlIIlllIllIIll && !lllllllllllllIIllIIlIIlllIllIlII && !lllllllllllllIIllIIlIIlllIllIIlI) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.NORTH_WEST;
                }
                if (lllllllllllllIIllIIlIIlllIllIlIl && lllllllllllllIIllIIlIIlllIllIIlI && !lllllllllllllIIllIIlIIlllIllIlII && !lllllllllllllIIllIIlIIlllIllIIll) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.NORTH_EAST;
                }
            }
            if (lllllllllllllIIllIIlIIlllIllIIIl == null) {
                if (lllllllllllllIIllIIlIIlllIllIlIl || lllllllllllllIIllIIlIIlllIllIlII) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.NORTH_SOUTH;
                }
                if (lllllllllllllIIllIIlIIlllIllIIll || lllllllllllllIIllIIlIIlllIllIIlI) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.EAST_WEST;
                }
                if (!this.isPowered) {
                    if (lllllllllllllIIllIIlIIlllIlIllIl) {
                        if (lllllllllllllIIllIIlIIlllIllIlII && lllllllllllllIIllIIlIIlllIllIIlI) {
                            lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.SOUTH_EAST;
                        }
                        if (lllllllllllllIIllIIlIIlllIllIIll && lllllllllllllIIllIIlIIlllIllIlII) {
                            lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.SOUTH_WEST;
                        }
                        if (lllllllllllllIIllIIlIIlllIllIIlI && lllllllllllllIIllIIlIIlllIllIlIl) {
                            lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.NORTH_EAST;
                        }
                        if (lllllllllllllIIllIIlIIlllIllIlIl && lllllllllllllIIllIIlIIlllIllIIll) {
                            lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.NORTH_WEST;
                        }
                    }
                    else {
                        if (lllllllllllllIIllIIlIIlllIllIlIl && lllllllllllllIIllIIlIIlllIllIIll) {
                            lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.NORTH_WEST;
                        }
                        if (lllllllllllllIIllIIlIIlllIllIIlI && lllllllllllllIIllIIlIIlllIllIlIl) {
                            lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.NORTH_EAST;
                        }
                        if (lllllllllllllIIllIIlIIlllIllIIll && lllllllllllllIIllIIlIIlllIllIlII) {
                            lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.SOUTH_WEST;
                        }
                        if (lllllllllllllIIllIIlIIlllIllIlII && lllllllllllllIIllIIlIIlllIllIIlI) {
                            lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.SOUTH_EAST;
                        }
                    }
                }
            }
            if (lllllllllllllIIllIIlIIlllIllIIIl == EnumRailDirection.NORTH_SOUTH) {
                if (BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIIlllIlllIIl.up())) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.ASCENDING_NORTH;
                }
                if (BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIIlllIlllIII.up())) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.ASCENDING_SOUTH;
                }
            }
            if (lllllllllllllIIllIIlIIlllIllIIIl == EnumRailDirection.EAST_WEST) {
                if (BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIIlllIllIllI.up())) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.ASCENDING_EAST;
                }
                if (BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIIlllIllIlll.up())) {
                    lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.ASCENDING_WEST;
                }
            }
            if (lllllllllllllIIllIIlIIlllIllIIIl == null) {
                lllllllllllllIIllIIlIIlllIllIIIl = EnumRailDirection.NORTH_SOUTH;
            }
            this.updateConnectedRails(lllllllllllllIIllIIlIIlllIllIIIl);
            this.state = this.state.withProperty(this.block.getShapeProperty(), lllllllllllllIIllIIlIIlllIllIIIl);
            if (lllllllllllllIIllIIlIIlllIlIllII || this.world.getBlockState(this.pos) != this.state) {
                this.world.setBlockState(this.pos, this.state, 3);
                for (int lllllllllllllIIllIIlIIlllIllIIII = 0; lllllllllllllIIllIIlIIlllIllIIII < this.connectedRails.size(); ++lllllllllllllIIllIIlIIlllIllIIII) {
                    final Rail lllllllllllllIIllIIlIIlllIlIllll = this.findRailAt(this.connectedRails.get(lllllllllllllIIllIIlIIlllIllIIII));
                    if (lllllllllllllIIllIIlIIlllIlIllll != null) {
                        lllllllllllllIIllIIlIIlllIlIllll.removeSoftConnections();
                        if (lllllllllllllIIllIIlIIlllIlIllll.canConnectTo(this)) {
                            lllllllllllllIIllIIlIIlllIlIllll.connectTo(this);
                        }
                    }
                }
            }
            return this;
        }
        
        private boolean isConnectedTo(final BlockPos lllllllllllllIIllIIlIlIIIIIIllII) {
            for (int lllllllllllllIIllIIlIlIIIIIIlIll = 0; lllllllllllllIIllIIlIlIIIIIIlIll < this.connectedRails.size(); ++lllllllllllllIIllIIlIlIIIIIIlIll) {
                final BlockPos lllllllllllllIIllIIlIlIIIIIIlIlI = this.connectedRails.get(lllllllllllllIIllIIlIlIIIIIIlIll);
                if (lllllllllllllIIllIIlIlIIIIIIlIlI.getX() == lllllllllllllIIllIIlIlIIIIIIllII.getX() && lllllllllllllIIllIIlIlIIIIIIlIlI.getZ() == lllllllllllllIIllIIlIlIIIIIIllII.getZ()) {
                    return true;
                }
            }
            return false;
        }
        
        private boolean hasRailAt(final BlockPos lllllllllllllIIllIIlIlIIIIlIIllI) {
            return BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIlIIIIlIIllI) || BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIlIIIIlIIllI.up()) || BlockRailBase.isRailBlock(this.world, lllllllllllllIIllIIlIlIIIIlIIllI.down());
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
            final int[] $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = Rail.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
            if ($switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection != null) {
                return $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
            }
            final double lllllllllllllIIllIIlIIlllIIlllII = (Object)new int[EnumRailDirection.values().length];
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.EAST_WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.NORTH_EAST.ordinal()] = 10;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.NORTH_SOUTH.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError7) {}
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.NORTH_WEST.ordinal()] = 9;
            }
            catch (NoSuchFieldError noSuchFieldError8) {}
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError9) {}
            try {
                lllllllllllllIIllIIlIIlllIIlllII[EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError10) {}
            return Rail.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = (int[])(Object)lllllllllllllIIllIIlIIlllIIlllII;
        }
        
        @Nullable
        private Rail findRailAt(final BlockPos lllllllllllllIIllIIlIlIIIIIllllI) {
            IBlockState lllllllllllllIIllIIlIlIIIIIlllIl = this.world.getBlockState(lllllllllllllIIllIIlIlIIIIIllllI);
            if (BlockRailBase.isRailBlock(lllllllllllllIIllIIlIlIIIIIlllIl)) {
                return new Rail(this.world, lllllllllllllIIllIIlIlIIIIIllllI, lllllllllllllIIllIIlIlIIIIIlllIl);
            }
            BlockPos lllllllllllllIIllIIlIlIIIIIlllII = lllllllllllllIIllIIlIlIIIIIllllI.up();
            lllllllllllllIIllIIlIlIIIIIlllIl = this.world.getBlockState(lllllllllllllIIllIIlIlIIIIIlllII);
            if (BlockRailBase.isRailBlock(lllllllllllllIIllIIlIlIIIIIlllIl)) {
                return new Rail(this.world, lllllllllllllIIllIIlIlIIIIIlllII, lllllllllllllIIllIIlIlIIIIIlllIl);
            }
            lllllllllllllIIllIIlIlIIIIIlllII = lllllllllllllIIllIIlIlIIIIIllllI.down();
            lllllllllllllIIllIIlIlIIIIIlllIl = this.world.getBlockState(lllllllllllllIIllIIlIlIIIIIlllII);
            return BlockRailBase.isRailBlock(lllllllllllllIIllIIlIlIIIIIlllIl) ? new Rail(this.world, lllllllllllllIIllIIlIlIIIIIlllII, lllllllllllllIIllIIlIlIIIIIlllIl) : null;
        }
        
        private boolean canConnectTo(final Rail lllllllllllllIIllIIlIIllllllIlIl) {
            return this.isConnectedToRail(lllllllllllllIIllIIlIIllllllIlIl) || this.connectedRails.size() != 2;
        }
        
        protected int countAdjacentRails() {
            int lllllllllllllIIllIIlIlIIIIIIIIII = 0;
            for (final EnumFacing lllllllllllllIIllIIlIIllllllllll : EnumFacing.Plane.HORIZONTAL) {
                if (this.hasRailAt(this.pos.offset(lllllllllllllIIllIIlIIllllllllll))) {
                    ++lllllllllllllIIllIIlIlIIIIIIIIII;
                }
            }
            return lllllllllllllIIllIIlIlIIIIIIIIII;
        }
        
        public IBlockState getBlockState() {
            return this.state;
        }
        
        public List<BlockPos> getConnectedRails() {
            return this.connectedRails;
        }
        
        private void removeSoftConnections() {
            for (int lllllllllllllIIllIIlIlIIIIlIlllI = 0; lllllllllllllIIllIIlIlIIIIlIlllI < this.connectedRails.size(); ++lllllllllllllIIllIIlIlIIIIlIlllI) {
                final Rail lllllllllllllIIllIIlIlIIIIlIllIl = this.findRailAt(this.connectedRails.get(lllllllllllllIIllIIlIlIIIIlIlllI));
                if (lllllllllllllIIllIIlIlIIIIlIllIl != null && lllllllllllllIIllIIlIlIIIIlIllIl.isConnectedToRail(this)) {
                    this.connectedRails.set(lllllllllllllIIllIIlIlIIIIlIlllI, lllllllllllllIIllIIlIlIIIIlIllIl.pos);
                }
                else {
                    this.connectedRails.remove(lllllllllllllIIllIIlIlIIIIlIlllI--);
                }
            }
        }
    }
}
