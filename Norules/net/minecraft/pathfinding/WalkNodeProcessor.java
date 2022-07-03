package net.minecraft.pathfinding;

import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public class WalkNodeProcessor extends NodeProcessor
{
    protected /* synthetic */ float avoidsWater;
    
    public PathNodeType func_193578_a(final IBlockAccess llllllllllllllIIlIlIllIlIIlIIIll, final int llllllllllllllIIlIlIllIlIIlIIIlI, final int llllllllllllllIIlIlIllIlIIIllIII, final int llllllllllllllIIlIlIllIlIIIlIlll, PathNodeType llllllllllllllIIlIlIllIlIIIlIllI) {
        final BlockPos.PooledMutableBlockPos llllllllllllllIIlIlIllIlIIIllllI = BlockPos.PooledMutableBlockPos.retain();
        if (llllllllllllllIIlIlIllIlIIIlIllI == PathNodeType.WALKABLE) {
            for (int llllllllllllllIIlIlIllIlIIIlllIl = -1; llllllllllllllIIlIlIllIlIIIlllIl <= 1; ++llllllllllllllIIlIlIllIlIIIlllIl) {
                for (int llllllllllllllIIlIlIllIlIIIlllII = -1; llllllllllllllIIlIlIllIlIIIlllII <= 1; ++llllllllllllllIIlIlIllIlIIIlllII) {
                    if (llllllllllllllIIlIlIllIlIIIlllIl != 0 || llllllllllllllIIlIlIllIlIIIlllII != 0) {
                        final Block llllllllllllllIIlIlIllIlIIIllIll = llllllllllllllIIlIlIllIlIIlIIIll.getBlockState(llllllllllllllIIlIlIllIlIIIllllI.setPos(llllllllllllllIIlIlIllIlIIIlllIl + llllllllllllllIIlIlIllIlIIlIIIlI, llllllllllllllIIlIlIllIlIIIllIII, llllllllllllllIIlIlIllIlIIIlllII + llllllllllllllIIlIlIllIlIIIlIlll)).getBlock();
                        if (llllllllllllllIIlIlIllIlIIIllIll == Blocks.CACTUS) {
                            llllllllllllllIIlIlIllIlIIIlIllI = PathNodeType.DANGER_CACTUS;
                        }
                        else if (llllllllllllllIIlIlIllIlIIIllIll == Blocks.FIRE) {
                            llllllllllllllIIlIlIllIlIIIlIllI = PathNodeType.DANGER_FIRE;
                        }
                    }
                }
            }
        }
        llllllllllllllIIlIlIllIlIIIllllI.release();
        return (PathNodeType)llllllllllllllIIlIlIllIlIIIlIllI;
    }
    
    @Override
    public void initProcessor(final IBlockAccess llllllllllllllIIlIlIlllIIllllIII, final EntityLiving llllllllllllllIIlIlIlllIIlllIlII) {
        super.initProcessor(llllllllllllllIIlIlIlllIIllllIII, llllllllllllllIIlIlIlllIIlllIlII);
        this.avoidsWater = llllllllllllllIIlIlIlllIIlllIlII.getPathPriority(PathNodeType.WATER);
    }
    
    private PathNodeType getPathNodeType(final EntityLiving llllllllllllllIIlIlIllIlIlIllIIl, final BlockPos llllllllllllllIIlIlIllIlIlIlIlIl) {
        return this.getPathNodeType(llllllllllllllIIlIlIllIlIlIllIIl, llllllllllllllIIlIlIllIlIlIlIlIl.getX(), llllllllllllllIIlIlIllIlIlIlIlIl.getY(), llllllllllllllIIlIlIllIlIlIlIlIl.getZ());
    }
    
    private PathNodeType getPathNodeType(final EntityLiving llllllllllllllIIlIlIllIlIlIIlllI, final int llllllllllllllIIlIlIllIlIlIIlIII, final int llllllllllllllIIlIlIllIlIlIIIlll, final int llllllllllllllIIlIlIllIlIlIIIllI) {
        return this.getPathNodeType(this.blockaccess, llllllllllllllIIlIlIllIlIlIIlIII, llllllllllllllIIlIlIllIlIlIIIlll, llllllllllllllIIlIlIllIlIlIIIllI, llllllllllllllIIlIlIllIlIlIIlllI, this.entitySizeX, this.entitySizeY, this.entitySizeZ, this.getCanBreakDoors(), this.getCanEnterDoors());
    }
    
    protected PathNodeType getPathNodeTypeRaw(final IBlockAccess llllllllllllllIIlIlIllIlIIIIIIII, final int llllllllllllllIIlIlIllIIllllllll, final int llllllllllllllIIlIlIllIIlllllllI, final int llllllllllllllIIlIlIllIIllllllIl) {
        final BlockPos llllllllllllllIIlIlIllIlIIIIIlII = new BlockPos(llllllllllllllIIlIlIllIIllllllll, llllllllllllllIIlIlIllIIlllllllI, llllllllllllllIIlIlIllIIllllllIl);
        final IBlockState llllllllllllllIIlIlIllIlIIIIIIll = llllllllllllllIIlIlIllIlIIIIIIII.getBlockState(llllllllllllllIIlIlIllIlIIIIIlII);
        final Block llllllllllllllIIlIlIllIlIIIIIIlI = llllllllllllllIIlIlIllIlIIIIIIll.getBlock();
        final Material llllllllllllllIIlIlIllIlIIIIIIIl = llllllllllllllIIlIlIllIlIIIIIIll.getMaterial();
        if (llllllllllllllIIlIlIllIlIIIIIIIl == Material.AIR) {
            return PathNodeType.OPEN;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIlI == Blocks.TRAPDOOR || llllllllllllllIIlIlIllIlIIIIIIlI == Blocks.IRON_TRAPDOOR || llllllllllllllIIlIlIllIlIIIIIIlI == Blocks.WATERLILY) {
            return PathNodeType.TRAPDOOR;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIlI == Blocks.FIRE) {
            return PathNodeType.DAMAGE_FIRE;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIlI == Blocks.CACTUS) {
            return PathNodeType.DAMAGE_CACTUS;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIlI instanceof BlockDoor && llllllllllllllIIlIlIllIlIIIIIIIl == Material.WOOD && !llllllllllllllIIlIlIllIlIIIIIIll.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
            return PathNodeType.DOOR_WOOD_CLOSED;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIlI instanceof BlockDoor && llllllllllllllIIlIlIllIlIIIIIIIl == Material.IRON && !llllllllllllllIIlIlIllIlIIIIIIll.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
            return PathNodeType.DOOR_IRON_CLOSED;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIlI instanceof BlockDoor && llllllllllllllIIlIlIllIlIIIIIIll.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
            return PathNodeType.DOOR_OPEN;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIlI instanceof BlockRailBase) {
            return PathNodeType.RAIL;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIlI instanceof BlockFence || llllllllllllllIIlIlIllIlIIIIIIlI instanceof BlockWall || (llllllllllllllIIlIlIllIlIIIIIIlI instanceof BlockFenceGate && !llllllllllllllIIlIlIllIlIIIIIIll.getValue((IProperty<Boolean>)BlockFenceGate.OPEN))) {
            return PathNodeType.FENCE;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIIl == Material.WATER) {
            return PathNodeType.WATER;
        }
        if (llllllllllllllIIlIlIllIlIIIIIIIl == Material.LAVA) {
            return PathNodeType.LAVA;
        }
        return llllllllllllllIIlIlIllIlIIIIIIlI.isPassable(llllllllllllllIIlIlIllIlIIIIIIII, llllllllllllllIIlIlIllIlIIIIIlII) ? PathNodeType.OPEN : PathNodeType.BLOCKED;
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess llllllllllllllIIlIlIllIlIIllllII, final int llllllllllllllIIlIlIllIlIIllIIll, final int llllllllllllllIIlIlIllIlIIlllIlI, final int llllllllllllllIIlIlIllIlIIllIIIl) {
        PathNodeType llllllllllllllIIlIlIllIlIIlllIII = this.getPathNodeTypeRaw(llllllllllllllIIlIlIllIlIIllllII, llllllllllllllIIlIlIllIlIIllIIll, llllllllllllllIIlIlIllIlIIlllIlI, llllllllllllllIIlIlIllIlIIllIIIl);
        if (llllllllllllllIIlIlIllIlIIlllIII == PathNodeType.OPEN && llllllllllllllIIlIlIllIlIIlllIlI >= 1) {
            final Block llllllllllllllIIlIlIllIlIIllIlll = llllllllllllllIIlIlIllIlIIllllII.getBlockState(new BlockPos(llllllllllllllIIlIlIllIlIIllIIll, llllllllllllllIIlIlIllIlIIlllIlI - 1, llllllllllllllIIlIlIllIlIIllIIIl)).getBlock();
            final PathNodeType llllllllllllllIIlIlIllIlIIllIllI = this.getPathNodeTypeRaw(llllllllllllllIIlIlIllIlIIllllII, llllllllllllllIIlIlIllIlIIllIIll, llllllllllllllIIlIlIllIlIIlllIlI - 1, llllllllllllllIIlIlIllIlIIllIIIl);
            llllllllllllllIIlIlIllIlIIlllIII = ((llllllllllllllIIlIlIllIlIIllIllI != PathNodeType.WALKABLE && llllllllllllllIIlIlIllIlIIllIllI != PathNodeType.OPEN && llllllllllllllIIlIlIllIlIIllIllI != PathNodeType.WATER && llllllllllllllIIlIlIllIlIIllIllI != PathNodeType.LAVA) ? PathNodeType.WALKABLE : PathNodeType.OPEN);
            if (llllllllllllllIIlIlIllIlIIllIllI == PathNodeType.DAMAGE_FIRE || llllllllllllllIIlIlIllIlIIllIlll == Blocks.MAGMA) {
                llllllllllllllIIlIlIllIlIIlllIII = PathNodeType.DAMAGE_FIRE;
            }
            if (llllllllllllllIIlIlIllIlIIllIllI == PathNodeType.DAMAGE_CACTUS) {
                llllllllllllllIIlIlIllIlIIlllIII = PathNodeType.DAMAGE_CACTUS;
            }
        }
        llllllllllllllIIlIlIllIlIIlllIII = this.func_193578_a(llllllllllllllIIlIlIllIlIIllllII, llllllllllllllIIlIlIllIlIIllIIll, llllllllllllllIIlIlIllIlIIlllIlI, llllllllllllllIIlIlIllIlIIllIIIl, llllllllllllllIIlIlIllIlIIlllIII);
        return llllllllllllllIIlIlIllIlIIlllIII;
    }
    
    @Override
    public PathPoint getPathPointToCoords(final double llllllllllllllIIlIlIlllIIlIIlIll, final double llllllllllllllIIlIlIlllIIlIIlllI, final double llllllllllllllIIlIlIlllIIlIIllIl) {
        return this.openPoint(MathHelper.floor(llllllllllllllIIlIlIlllIIlIIlIll), MathHelper.floor(llllllllllllllIIlIlIlllIIlIIlllI), MathHelper.floor(llllllllllllllIIlIlIlllIIlIIllIl));
    }
    
    @Override
    public int findPathOptions(final PathPoint[] llllllllllllllIIlIlIlllIIIIllllI, final PathPoint llllllllllllllIIlIlIlllIIIllIIll, final PathPoint llllllllllllllIIlIlIlllIIIllIIlI, final float llllllllllllllIIlIlIlllIIIllIIIl) {
        int llllllllllllllIIlIlIlllIIIllIIII = 0;
        int llllllllllllllIIlIlIlllIIIlIllll = 0;
        final PathNodeType llllllllllllllIIlIlIlllIIIlIlllI = this.getPathNodeType(this.entity, llllllllllllllIIlIlIlllIIIllIIll.xCoord, llllllllllllllIIlIlIlllIIIllIIll.yCoord + 1, llllllllllllllIIlIlIlllIIIllIIll.zCoord);
        if (this.entity.getPathPriority(llllllllllllllIIlIlIlllIIIlIlllI) >= 0.0f) {
            llllllllllllllIIlIlIlllIIIlIllll = MathHelper.floor(Math.max(1.0f, this.entity.stepHeight));
        }
        final BlockPos llllllllllllllIIlIlIlllIIIlIllIl = new BlockPos(llllllllllllllIIlIlIlllIIIllIIll.xCoord, llllllllllllllIIlIlIlllIIIllIIll.yCoord, llllllllllllllIIlIlIlllIIIllIIll.zCoord).down();
        final double llllllllllllllIIlIlIlllIIIlIllII = llllllllllllllIIlIlIlllIIIllIIll.yCoord - (1.0 - this.blockaccess.getBlockState(llllllllllllllIIlIlIlllIIIlIllIl).getBoundingBox(this.blockaccess, llllllllllllllIIlIlIlllIIIlIllIl).maxY);
        final PathPoint llllllllllllllIIlIlIlllIIIlIlIll = this.getSafePoint(llllllllllllllIIlIlIlllIIIllIIll.xCoord, llllllllllllllIIlIlIlllIIIllIIll.yCoord, llllllllllllllIIlIlIlllIIIllIIll.zCoord + 1, llllllllllllllIIlIlIlllIIIlIllll, llllllllllllllIIlIlIlllIIIlIllII, EnumFacing.SOUTH);
        final PathPoint llllllllllllllIIlIlIlllIIIlIlIlI = this.getSafePoint(llllllllllllllIIlIlIlllIIIllIIll.xCoord - 1, llllllllllllllIIlIlIlllIIIllIIll.yCoord, llllllllllllllIIlIlIlllIIIllIIll.zCoord, llllllllllllllIIlIlIlllIIIlIllll, llllllllllllllIIlIlIlllIIIlIllII, EnumFacing.WEST);
        final PathPoint llllllllllllllIIlIlIlllIIIlIlIIl = this.getSafePoint(llllllllllllllIIlIlIlllIIIllIIll.xCoord + 1, llllllllllllllIIlIlIlllIIIllIIll.yCoord, llllllllllllllIIlIlIlllIIIllIIll.zCoord, llllllllllllllIIlIlIlllIIIlIllll, llllllllllllllIIlIlIlllIIIlIllII, EnumFacing.EAST);
        final PathPoint llllllllllllllIIlIlIlllIIIlIlIII = this.getSafePoint(llllllllllllllIIlIlIlllIIIllIIll.xCoord, llllllllllllllIIlIlIlllIIIllIIll.yCoord, llllllllllllllIIlIlIlllIIIllIIll.zCoord - 1, llllllllllllllIIlIlIlllIIIlIllll, llllllllllllllIIlIlIlllIIIlIllII, EnumFacing.NORTH);
        if (llllllllllllllIIlIlIlllIIIlIlIll != null && !llllllllllllllIIlIlIlllIIIlIlIll.visited && llllllllllllllIIlIlIlllIIIlIlIll.distanceTo(llllllllllllllIIlIlIlllIIIllIIlI) < llllllllllllllIIlIlIlllIIIllIIIl) {
            llllllllllllllIIlIlIlllIIIIllllI[llllllllllllllIIlIlIlllIIIllIIII++] = llllllllllllllIIlIlIlllIIIlIlIll;
        }
        if (llllllllllllllIIlIlIlllIIIlIlIlI != null && !llllllllllllllIIlIlIlllIIIlIlIlI.visited && llllllllllllllIIlIlIlllIIIlIlIlI.distanceTo(llllllllllllllIIlIlIlllIIIllIIlI) < llllllllllllllIIlIlIlllIIIllIIIl) {
            llllllllllllllIIlIlIlllIIIIllllI[llllllllllllllIIlIlIlllIIIllIIII++] = llllllllllllllIIlIlIlllIIIlIlIlI;
        }
        if (llllllllllllllIIlIlIlllIIIlIlIIl != null && !llllllllllllllIIlIlIlllIIIlIlIIl.visited && llllllllllllllIIlIlIlllIIIlIlIIl.distanceTo(llllllllllllllIIlIlIlllIIIllIIlI) < llllllllllllllIIlIlIlllIIIllIIIl) {
            llllllllllllllIIlIlIlllIIIIllllI[llllllllllllllIIlIlIlllIIIllIIII++] = llllllllllllllIIlIlIlllIIIlIlIIl;
        }
        if (llllllllllllllIIlIlIlllIIIlIlIII != null && !llllllllllllllIIlIlIlllIIIlIlIII.visited && llllllllllllllIIlIlIlllIIIlIlIII.distanceTo(llllllllllllllIIlIlIlllIIIllIIlI) < llllllllllllllIIlIlIlllIIIllIIIl) {
            llllllllllllllIIlIlIlllIIIIllllI[llllllllllllllIIlIlIlllIIIllIIII++] = llllllllllllllIIlIlIlllIIIlIlIII;
        }
        final boolean llllllllllllllIIlIlIlllIIIlIIlll = llllllllllllllIIlIlIlllIIIlIlIII == null || llllllllllllllIIlIlIlllIIIlIlIII.nodeType == PathNodeType.OPEN || llllllllllllllIIlIlIlllIIIlIlIII.costMalus != 0.0f;
        final boolean llllllllllllllIIlIlIlllIIIlIIllI = llllllllllllllIIlIlIlllIIIlIlIll == null || llllllllllllllIIlIlIlllIIIlIlIll.nodeType == PathNodeType.OPEN || llllllllllllllIIlIlIlllIIIlIlIll.costMalus != 0.0f;
        final boolean llllllllllllllIIlIlIlllIIIlIIlIl = llllllllllllllIIlIlIlllIIIlIlIIl == null || llllllllllllllIIlIlIlllIIIlIlIIl.nodeType == PathNodeType.OPEN || llllllllllllllIIlIlIlllIIIlIlIIl.costMalus != 0.0f;
        final boolean llllllllllllllIIlIlIlllIIIlIIlII = llllllllllllllIIlIlIlllIIIlIlIlI == null || llllllllllllllIIlIlIlllIIIlIlIlI.nodeType == PathNodeType.OPEN || llllllllllllllIIlIlIlllIIIlIlIlI.costMalus != 0.0f;
        if (llllllllllllllIIlIlIlllIIIlIIlll && llllllllllllllIIlIlIlllIIIlIIlII) {
            final PathPoint llllllllllllllIIlIlIlllIIIlIIIll = this.getSafePoint(llllllllllllllIIlIlIlllIIIllIIll.xCoord - 1, llllllllllllllIIlIlIlllIIIllIIll.yCoord, llllllllllllllIIlIlIlllIIIllIIll.zCoord - 1, llllllllllllllIIlIlIlllIIIlIllll, llllllllllllllIIlIlIlllIIIlIllII, EnumFacing.NORTH);
            if (llllllllllllllIIlIlIlllIIIlIIIll != null && !llllllllllllllIIlIlIlllIIIlIIIll.visited && llllllllllllllIIlIlIlllIIIlIIIll.distanceTo(llllllllllllllIIlIlIlllIIIllIIlI) < llllllllllllllIIlIlIlllIIIllIIIl) {
                llllllllllllllIIlIlIlllIIIIllllI[llllllllllllllIIlIlIlllIIIllIIII++] = llllllllllllllIIlIlIlllIIIlIIIll;
            }
        }
        if (llllllllllllllIIlIlIlllIIIlIIlll && llllllllllllllIIlIlIlllIIIlIIlIl) {
            final PathPoint llllllllllllllIIlIlIlllIIIlIIIlI = this.getSafePoint(llllllllllllllIIlIlIlllIIIllIIll.xCoord + 1, llllllllllllllIIlIlIlllIIIllIIll.yCoord, llllllllllllllIIlIlIlllIIIllIIll.zCoord - 1, llllllllllllllIIlIlIlllIIIlIllll, llllllllllllllIIlIlIlllIIIlIllII, EnumFacing.NORTH);
            if (llllllllllllllIIlIlIlllIIIlIIIlI != null && !llllllllllllllIIlIlIlllIIIlIIIlI.visited && llllllllllllllIIlIlIlllIIIlIIIlI.distanceTo(llllllllllllllIIlIlIlllIIIllIIlI) < llllllllllllllIIlIlIlllIIIllIIIl) {
                llllllllllllllIIlIlIlllIIIIllllI[llllllllllllllIIlIlIlllIIIllIIII++] = llllllllllllllIIlIlIlllIIIlIIIlI;
            }
        }
        if (llllllllllllllIIlIlIlllIIIlIIllI && llllllllllllllIIlIlIlllIIIlIIlII) {
            final PathPoint llllllllllllllIIlIlIlllIIIlIIIIl = this.getSafePoint(llllllllllllllIIlIlIlllIIIllIIll.xCoord - 1, llllllllllllllIIlIlIlllIIIllIIll.yCoord, llllllllllllllIIlIlIlllIIIllIIll.zCoord + 1, llllllllllllllIIlIlIlllIIIlIllll, llllllllllllllIIlIlIlllIIIlIllII, EnumFacing.SOUTH);
            if (llllllllllllllIIlIlIlllIIIlIIIIl != null && !llllllllllllllIIlIlIlllIIIlIIIIl.visited && llllllllllllllIIlIlIlllIIIlIIIIl.distanceTo(llllllllllllllIIlIlIlllIIIllIIlI) < llllllllllllllIIlIlIlllIIIllIIIl) {
                llllllllllllllIIlIlIlllIIIIllllI[llllllllllllllIIlIlIlllIIIllIIII++] = llllllllllllllIIlIlIlllIIIlIIIIl;
            }
        }
        if (llllllllllllllIIlIlIlllIIIlIIllI && llllllllllllllIIlIlIlllIIIlIIlIl) {
            final PathPoint llllllllllllllIIlIlIlllIIIlIIIII = this.getSafePoint(llllllllllllllIIlIlIlllIIIllIIll.xCoord + 1, llllllllllllllIIlIlIlllIIIllIIll.yCoord, llllllllllllllIIlIlIlllIIIllIIll.zCoord + 1, llllllllllllllIIlIlIlllIIIlIllll, llllllllllllllIIlIlIlllIIIlIllII, EnumFacing.SOUTH);
            if (llllllllllllllIIlIlIlllIIIlIIIII != null && !llllllllllllllIIlIlIlllIIIlIIIII.visited && llllllllllllllIIlIlIlllIIIlIIIII.distanceTo(llllllllllllllIIlIlIlllIIIllIIlI) < llllllllllllllIIlIlIlllIIIllIIIl) {
                llllllllllllllIIlIlIlllIIIIllllI[llllllllllllllIIlIlIlllIIIllIIII++] = llllllllllllllIIlIlIlllIIIlIIIII;
            }
        }
        return llllllllllllllIIlIlIlllIIIllIIII;
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess llllllllllllllIIlIlIllIllIlIlIlI, final int llllllllllllllIIlIlIllIllIlllIlI, final int llllllllllllllIIlIlIllIllIlllIIl, final int llllllllllllllIIlIlIllIllIlllIII, final EntityLiving llllllllllllllIIlIlIllIllIllIlll, final int llllllllllllllIIlIlIllIllIlIIlIl, final int llllllllllllllIIlIlIllIllIllIlIl, final int llllllllllllllIIlIlIllIllIlIIIll, final boolean llllllllllllllIIlIlIllIllIlIIIlI, final boolean llllllllllllllIIlIlIllIllIllIIlI) {
        final EnumSet<PathNodeType> llllllllllllllIIlIlIllIllIllIIIl = EnumSet.noneOf(PathNodeType.class);
        PathNodeType llllllllllllllIIlIlIllIllIllIIII = PathNodeType.BLOCKED;
        final double llllllllllllllIIlIlIllIllIlIllll = llllllllllllllIIlIlIllIllIllIlll.width / 2.0;
        final BlockPos llllllllllllllIIlIlIllIllIlIlllI = new BlockPos(llllllllllllllIIlIlIllIllIllIlll);
        llllllllllllllIIlIlIllIllIllIIII = this.func_193577_a(llllllllllllllIIlIlIllIllIlIlIlI, llllllllllllllIIlIlIllIllIlllIlI, llllllllllllllIIlIlIllIllIlllIIl, llllllllllllllIIlIlIllIllIlllIII, llllllllllllllIIlIlIllIllIlIIlIl, llllllllllllllIIlIlIllIllIllIlIl, llllllllllllllIIlIlIllIllIlIIIll, llllllllllllllIIlIlIllIllIlIIIlI, llllllllllllllIIlIlIllIllIllIIlI, llllllllllllllIIlIlIllIllIllIIIl, llllllllllllllIIlIlIllIllIllIIII, llllllllllllllIIlIlIllIllIlIlllI);
        if (llllllllllllllIIlIlIllIllIllIIIl.contains(PathNodeType.FENCE)) {
            return PathNodeType.FENCE;
        }
        PathNodeType llllllllllllllIIlIlIllIllIlIllIl = PathNodeType.BLOCKED;
        for (final PathNodeType llllllllllllllIIlIlIllIllIlIllII : llllllllllllllIIlIlIllIllIllIIIl) {
            if (llllllllllllllIIlIlIllIllIllIlll.getPathPriority(llllllllllllllIIlIlIllIllIlIllII) < 0.0f) {
                return llllllllllllllIIlIlIllIllIlIllII;
            }
            if (llllllllllllllIIlIlIllIllIllIlll.getPathPriority(llllllllllllllIIlIlIllIllIlIllII) < llllllllllllllIIlIlIllIllIllIlll.getPathPriority(llllllllllllllIIlIlIllIllIlIllIl)) {
                continue;
            }
            llllllllllllllIIlIlIllIllIlIllIl = llllllllllllllIIlIlIllIllIlIllII;
        }
        if (llllllllllllllIIlIlIllIllIllIIII == PathNodeType.OPEN && llllllllllllllIIlIlIllIllIllIlll.getPathPriority(llllllllllllllIIlIlIllIllIlIllIl) == 0.0f) {
            return PathNodeType.OPEN;
        }
        return llllllllllllllIIlIlIllIllIlIllIl;
    }
    
    @Override
    public PathPoint getStart() {
        int llllllllllllllIIlIlIlllIIllIIlIl = 0;
        if (this.getCanSwim() && this.entity.isInWater()) {
            int llllllllllllllIIlIlIlllIIllIIlll = (int)this.entity.getEntityBoundingBox().minY;
            final BlockPos.MutableBlockPos llllllllllllllIIlIlIlllIIllIIlII = new BlockPos.MutableBlockPos(MathHelper.floor(this.entity.posX), llllllllllllllIIlIlIlllIIllIIlll, MathHelper.floor(this.entity.posZ));
            for (Block llllllllllllllIIlIlIlllIIllIIIll = this.blockaccess.getBlockState(llllllllllllllIIlIlIlllIIllIIlII).getBlock(); llllllllllllllIIlIlIlllIIllIIIll == Blocks.FLOWING_WATER || llllllllllllllIIlIlIlllIIllIIIll == Blocks.WATER; llllllllllllllIIlIlIlllIIllIIIll = this.blockaccess.getBlockState(llllllllllllllIIlIlIlllIIllIIlII).getBlock()) {
                ++llllllllllllllIIlIlIlllIIllIIlll;
                llllllllllllllIIlIlIlllIIllIIlII.setPos(MathHelper.floor(this.entity.posX), llllllllllllllIIlIlIlllIIllIIlll, MathHelper.floor(this.entity.posZ));
            }
        }
        else if (this.entity.onGround) {
            final int llllllllllllllIIlIlIlllIIllIIllI = MathHelper.floor(this.entity.getEntityBoundingBox().minY + 0.5);
        }
        else {
            BlockPos llllllllllllllIIlIlIlllIIllIIIlI;
            for (llllllllllllllIIlIlIlllIIllIIIlI = new BlockPos(this.entity); (this.blockaccess.getBlockState(llllllllllllllIIlIlIlllIIllIIIlI).getMaterial() == Material.AIR || this.blockaccess.getBlockState(llllllllllllllIIlIlIlllIIllIIIlI).getBlock().isPassable(this.blockaccess, llllllllllllllIIlIlIlllIIllIIIlI)) && llllllllllllllIIlIlIlllIIllIIIlI.getY() > 0; llllllllllllllIIlIlIlllIIllIIIlI = llllllllllllllIIlIlIlllIIllIIIlI.down()) {}
            llllllllllllllIIlIlIlllIIllIIlIl = llllllllllllllIIlIlIlllIIllIIIlI.up().getY();
        }
        final BlockPos llllllllllllllIIlIlIlllIIllIIIIl = new BlockPos(this.entity);
        final PathNodeType llllllllllllllIIlIlIlllIIllIIIII = this.getPathNodeType(this.entity, llllllllllllllIIlIlIlllIIllIIIIl.getX(), llllllllllllllIIlIlIlllIIllIIlIl, llllllllllllllIIlIlIlllIIllIIIIl.getZ());
        if (this.entity.getPathPriority(llllllllllllllIIlIlIlllIIllIIIII) < 0.0f) {
            final Set<BlockPos> llllllllllllllIIlIlIlllIIlIlllll = (Set<BlockPos>)Sets.newHashSet();
            llllllllllllllIIlIlIlllIIlIlllll.add(new BlockPos(this.entity.getEntityBoundingBox().minX, llllllllllllllIIlIlIlllIIllIIlIl, this.entity.getEntityBoundingBox().minZ));
            llllllllllllllIIlIlIlllIIlIlllll.add(new BlockPos(this.entity.getEntityBoundingBox().minX, llllllllllllllIIlIlIlllIIllIIlIl, this.entity.getEntityBoundingBox().maxZ));
            llllllllllllllIIlIlIlllIIlIlllll.add(new BlockPos(this.entity.getEntityBoundingBox().maxX, llllllllllllllIIlIlIlllIIllIIlIl, this.entity.getEntityBoundingBox().minZ));
            llllllllllllllIIlIlIlllIIlIlllll.add(new BlockPos(this.entity.getEntityBoundingBox().maxX, llllllllllllllIIlIlIlllIIllIIlIl, this.entity.getEntityBoundingBox().maxZ));
            for (final BlockPos llllllllllllllIIlIlIlllIIlIllllI : llllllllllllllIIlIlIlllIIlIlllll) {
                final PathNodeType llllllllllllllIIlIlIlllIIlIlllIl = this.getPathNodeType(this.entity, llllllllllllllIIlIlIlllIIlIllllI);
                if (this.entity.getPathPriority(llllllllllllllIIlIlIlllIIlIlllIl) >= 0.0f) {
                    return this.openPoint(llllllllllllllIIlIlIlllIIlIllllI.getX(), llllllllllllllIIlIlIlllIIlIllllI.getY(), llllllllllllllIIlIlIlllIIlIllllI.getZ());
                }
            }
        }
        return this.openPoint(llllllllllllllIIlIlIlllIIllIIIIl.getX(), llllllllllllllIIlIlIlllIIllIIlIl, llllllllllllllIIlIlIlllIIllIIIIl.getZ());
    }
    
    public PathNodeType func_193577_a(final IBlockAccess llllllllllllllIIlIlIllIllIIIIlII, final int llllllllllllllIIlIlIllIlIllIllll, final int llllllllllllllIIlIlIllIlIllIlllI, final int llllllllllllllIIlIlIllIllIIIIIIl, final int llllllllllllllIIlIlIllIllIIIIIII, final int llllllllllllllIIlIlIllIlIllIlIll, final int llllllllllllllIIlIlIllIlIllIlIlI, final boolean llllllllllllllIIlIlIllIlIllIlIIl, final boolean llllllllllllllIIlIlIllIlIllIlIII, final EnumSet<PathNodeType> llllllllllllllIIlIlIllIlIllIIlll, PathNodeType llllllllllllllIIlIlIllIlIllIIllI, final BlockPos llllllllllllllIIlIlIllIlIllllIIl) {
        for (int llllllllllllllIIlIlIllIlIllllIII = 0; llllllllllllllIIlIlIllIlIllllIII < llllllllllllllIIlIlIllIllIIIIIII; ++llllllllllllllIIlIlIllIlIllllIII) {
            for (int llllllllllllllIIlIlIllIlIlllIlll = 0; llllllllllllllIIlIlIllIlIlllIlll < llllllllllllllIIlIlIllIlIllIlIll; ++llllllllllllllIIlIlIllIlIlllIlll) {
                for (int llllllllllllllIIlIlIllIlIlllIllI = 0; llllllllllllllIIlIlIllIlIlllIllI < llllllllllllllIIlIlIllIlIllIlIlI; ++llllllllllllllIIlIlIllIlIlllIllI) {
                    final int llllllllllllllIIlIlIllIlIlllIlIl = llllllllllllllIIlIlIllIlIllllIII + llllllllllllllIIlIlIllIlIllIllll;
                    final int llllllllllllllIIlIlIllIlIlllIlII = llllllllllllllIIlIlIllIlIlllIlll + llllllllllllllIIlIlIllIlIllIlllI;
                    final int llllllllllllllIIlIlIllIlIlllIIll = llllllllllllllIIlIlIllIlIlllIllI + llllllllllllllIIlIlIllIllIIIIIIl;
                    PathNodeType llllllllllllllIIlIlIllIlIlllIIlI = this.getPathNodeType(llllllllllllllIIlIlIllIllIIIIlII, llllllllllllllIIlIlIllIlIlllIlIl, llllllllllllllIIlIlIllIlIlllIlII, llllllllllllllIIlIlIllIlIlllIIll);
                    if (llllllllllllllIIlIlIllIlIlllIIlI == PathNodeType.DOOR_WOOD_CLOSED && llllllllllllllIIlIlIllIlIllIlIIl && llllllllllllllIIlIlIllIlIllIlIII) {
                        llllllllllllllIIlIlIllIlIlllIIlI = PathNodeType.WALKABLE;
                    }
                    if (llllllllllllllIIlIlIllIlIlllIIlI == PathNodeType.DOOR_OPEN && !llllllllllllllIIlIlIllIlIllIlIII) {
                        llllllllllllllIIlIlIllIlIlllIIlI = PathNodeType.BLOCKED;
                    }
                    if (llllllllllllllIIlIlIllIlIlllIIlI == PathNodeType.RAIL && !(llllllllllllllIIlIlIllIllIIIIlII.getBlockState(llllllllllllllIIlIlIllIlIllllIIl).getBlock() instanceof BlockRailBase) && !(llllllllllllllIIlIlIllIllIIIIlII.getBlockState(llllllllllllllIIlIlIllIlIllllIIl.down()).getBlock() instanceof BlockRailBase)) {
                        llllllllllllllIIlIlIllIlIlllIIlI = PathNodeType.FENCE;
                    }
                    if (llllllllllllllIIlIlIllIlIllllIII == 0 && llllllllllllllIIlIlIllIlIlllIlll == 0 && llllllllllllllIIlIlIllIlIlllIllI == 0) {
                        llllllllllllllIIlIlIllIlIllIIllI = llllllllllllllIIlIlIllIlIlllIIlI;
                    }
                    llllllllllllllIIlIlIllIlIllIIlll.add(llllllllllllllIIlIlIllIlIlllIIlI);
                }
            }
        }
        return llllllllllllllIIlIlIllIlIllIIllI;
    }
    
    @Override
    public void postProcess() {
        this.entity.setPathPriority(PathNodeType.WATER, this.avoidsWater);
        super.postProcess();
    }
    
    @Nullable
    private PathPoint getSafePoint(final int llllllllllllllIIlIlIllIlllllIlll, int llllllllllllllIIlIlIllIllllIIIII, final int llllllllllllllIIlIlIllIlllllIlIl, final int llllllllllllllIIlIlIllIlllIllllI, final double llllllllllllllIIlIlIllIlllIlllIl, final EnumFacing llllllllllllllIIlIlIllIlllllIIlI) {
        PathPoint llllllllllllllIIlIlIllIlllllIIIl = null;
        final BlockPos llllllllllllllIIlIlIllIlllllIIII = new BlockPos(llllllllllllllIIlIlIllIlllllIlll, llllllllllllllIIlIlIllIllllIIIII, llllllllllllllIIlIlIllIlllllIlIl);
        final BlockPos llllllllllllllIIlIlIllIllllIllll = llllllllllllllIIlIlIllIlllllIIII.down();
        final double llllllllllllllIIlIlIllIllllIlllI = llllllllllllllIIlIlIllIllllIIIII - (1.0 - this.blockaccess.getBlockState(llllllllllllllIIlIlIllIllllIllll).getBoundingBox(this.blockaccess, llllllllllllllIIlIlIllIllllIllll).maxY);
        if (llllllllllllllIIlIlIllIllllIlllI - llllllllllllllIIlIlIllIlllIlllIl > 1.125) {
            return null;
        }
        PathNodeType llllllllllllllIIlIlIllIllllIllIl = this.getPathNodeType(this.entity, llllllllllllllIIlIlIllIlllllIlll, llllllllllllllIIlIlIllIllllIIIII, llllllllllllllIIlIlIllIlllllIlIl);
        float llllllllllllllIIlIlIllIllllIllII = this.entity.getPathPriority(llllllllllllllIIlIlIllIllllIllIl);
        final double llllllllllllllIIlIlIllIllllIlIll = this.entity.width / 2.0;
        if (llllllllllllllIIlIlIllIllllIllII >= 0.0f) {
            llllllllllllllIIlIlIllIlllllIIIl = this.openPoint(llllllllllllllIIlIlIllIlllllIlll, llllllllllllllIIlIlIllIllllIIIII, llllllllllllllIIlIlIllIlllllIlIl);
            llllllllllllllIIlIlIllIlllllIIIl.nodeType = llllllllllllllIIlIlIllIllllIllIl;
            llllllllllllllIIlIlIllIlllllIIIl.costMalus = Math.max(llllllllllllllIIlIlIllIlllllIIIl.costMalus, llllllllllllllIIlIlIllIllllIllII);
        }
        if (llllllllllllllIIlIlIllIllllIllIl == PathNodeType.WALKABLE) {
            return llllllllllllllIIlIlIllIlllllIIIl;
        }
        if (llllllllllllllIIlIlIllIlllllIIIl == null && llllllllllllllIIlIlIllIlllIllllI > 0 && llllllllllllllIIlIlIllIllllIllIl != PathNodeType.FENCE && llllllllllllllIIlIlIllIllllIllIl != PathNodeType.TRAPDOOR) {
            llllllllllllllIIlIlIllIlllllIIIl = this.getSafePoint(llllllllllllllIIlIlIllIlllllIlll, llllllllllllllIIlIlIllIllllIIIII + 1, llllllllllllllIIlIlIllIlllllIlIl, llllllllllllllIIlIlIllIlllIllllI - 1, llllllllllllllIIlIlIllIlllIlllIl, llllllllllllllIIlIlIllIlllllIIlI);
            if (llllllllllllllIIlIlIllIlllllIIIl != null && (llllllllllllllIIlIlIllIlllllIIIl.nodeType == PathNodeType.OPEN || llllllllllllllIIlIlIllIlllllIIIl.nodeType == PathNodeType.WALKABLE) && this.entity.width < 1.0f) {
                final double llllllllllllllIIlIlIllIllllIlIlI = llllllllllllllIIlIlIllIlllllIlll - llllllllllllllIIlIlIllIlllllIIlI.getFrontOffsetX() + 0.5;
                final double llllllllllllllIIlIlIllIllllIlIIl = llllllllllllllIIlIlIllIlllllIlIl - llllllllllllllIIlIlIllIlllllIIlI.getFrontOffsetZ() + 0.5;
                final AxisAlignedBB llllllllllllllIIlIlIllIllllIlIII = new AxisAlignedBB(llllllllllllllIIlIlIllIllllIlIlI - llllllllllllllIIlIlIllIllllIlIll, llllllllllllllIIlIlIllIllllIIIII + 0.001, llllllllllllllIIlIlIllIllllIlIIl - llllllllllllllIIlIlIllIllllIlIll, llllllllllllllIIlIlIllIllllIlIlI + llllllllllllllIIlIlIllIllllIlIll, llllllllllllllIIlIlIllIllllIIIII + this.entity.height, llllllllllllllIIlIlIllIllllIlIIl + llllllllllllllIIlIlIllIllllIlIll);
                final AxisAlignedBB llllllllllllllIIlIlIllIllllIIlll = this.blockaccess.getBlockState(llllllllllllllIIlIlIllIlllllIIII).getBoundingBox(this.blockaccess, llllllllllllllIIlIlIllIlllllIIII);
                final AxisAlignedBB llllllllllllllIIlIlIllIllllIIllI = llllllllllllllIIlIlIllIllllIlIII.addCoord(0.0, llllllllllllllIIlIlIllIllllIIlll.maxY - 0.002, 0.0);
                if (this.entity.world.collidesWithAnyBlock(llllllllllllllIIlIlIllIllllIIllI)) {
                    llllllllllllllIIlIlIllIlllllIIIl = null;
                }
            }
        }
        if (llllllllllllllIIlIlIllIllllIllIl == PathNodeType.OPEN) {
            final AxisAlignedBB llllllllllllllIIlIlIllIllllIIlIl = new AxisAlignedBB(llllllllllllllIIlIlIllIlllllIlll - llllllllllllllIIlIlIllIllllIlIll + 0.5, llllllllllllllIIlIlIllIllllIIIII + 0.001, llllllllllllllIIlIlIllIlllllIlIl - llllllllllllllIIlIlIllIllllIlIll + 0.5, llllllllllllllIIlIlIllIlllllIlll + llllllllllllllIIlIlIllIllllIlIll + 0.5, llllllllllllllIIlIlIllIllllIIIII + this.entity.height, llllllllllllllIIlIlIllIlllllIlIl + llllllllllllllIIlIlIllIllllIlIll + 0.5);
            if (this.entity.world.collidesWithAnyBlock(llllllllllllllIIlIlIllIllllIIlIl)) {
                return null;
            }
            if (this.entity.width >= 1.0f) {
                final PathNodeType llllllllllllllIIlIlIllIllllIIlII = this.getPathNodeType(this.entity, llllllllllllllIIlIlIllIlllllIlll, llllllllllllllIIlIlIllIllllIIIII - 1, llllllllllllllIIlIlIllIlllllIlIl);
                if (llllllllllllllIIlIlIllIllllIIlII == PathNodeType.BLOCKED) {
                    llllllllllllllIIlIlIllIlllllIIIl = this.openPoint(llllllllllllllIIlIlIllIlllllIlll, llllllllllllllIIlIlIllIllllIIIII, llllllllllllllIIlIlIllIlllllIlIl);
                    llllllllllllllIIlIlIllIlllllIIIl.nodeType = PathNodeType.WALKABLE;
                    llllllllllllllIIlIlIllIlllllIIIl.costMalus = Math.max(llllllllllllllIIlIlIllIlllllIIIl.costMalus, llllllllllllllIIlIlIllIllllIllII);
                    return llllllllllllllIIlIlIllIlllllIIIl;
                }
            }
            int llllllllllllllIIlIlIllIllllIIIll = 0;
            while (llllllllllllllIIlIlIllIllllIIIII > 0 && llllllllllllllIIlIlIllIllllIllIl == PathNodeType.OPEN) {
                --llllllllllllllIIlIlIllIllllIIIII;
                if (llllllllllllllIIlIlIllIllllIIIll++ >= this.entity.getMaxFallHeight()) {
                    return null;
                }
                llllllllllllllIIlIlIllIllllIllIl = this.getPathNodeType(this.entity, llllllllllllllIIlIlIllIlllllIlll, llllllllllllllIIlIlIllIllllIIIII, llllllllllllllIIlIlIllIlllllIlIl);
                llllllllllllllIIlIlIllIllllIllII = this.entity.getPathPriority(llllllllllllllIIlIlIllIllllIllIl);
                if (llllllllllllllIIlIlIllIllllIllIl != PathNodeType.OPEN && llllllllllllllIIlIlIllIllllIllII >= 0.0f) {
                    llllllllllllllIIlIlIllIlllllIIIl = this.openPoint(llllllllllllllIIlIlIllIlllllIlll, llllllllllllllIIlIlIllIllllIIIII, llllllllllllllIIlIlIllIlllllIlIl);
                    llllllllllllllIIlIlIllIlllllIIIl.nodeType = llllllllllllllIIlIlIllIllllIllIl;
                    llllllllllllllIIlIlIllIlllllIIIl.costMalus = Math.max(llllllllllllllIIlIlIllIlllllIIIl.costMalus, llllllllllllllIIlIlIllIllllIllII);
                    break;
                }
                if (llllllllllllllIIlIlIllIllllIllII < 0.0f) {
                    return null;
                }
            }
        }
        return llllllllllllllIIlIlIllIlllllIIIl;
    }
}
