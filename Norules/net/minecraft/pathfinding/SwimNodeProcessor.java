package net.minecraft.pathfinding;

import javax.annotation.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class SwimNodeProcessor extends NodeProcessor
{
    @Nullable
    private PathPoint getWaterNode(final int llllllllllllllIIlIIIIlIlIIIlIlll, final int llllllllllllllIIlIIIIlIlIIIllIll, final int llllllllllllllIIlIIIIlIlIIIllIlI) {
        final PathNodeType llllllllllllllIIlIIIIlIlIIIllIIl = this.isFree(llllllllllllllIIlIIIIlIlIIIlIlll, llllllllllllllIIlIIIIlIlIIIllIll, llllllllllllllIIlIIIIlIlIIIllIlI);
        return (llllllllllllllIIlIIIIlIlIIIllIIl == PathNodeType.WATER) ? this.openPoint(llllllllllllllIIlIIIIlIlIIIlIlll, llllllllllllllIIlIIIIlIlIIIllIll, llllllllllllllIIlIIIIlIlIIIllIlI) : null;
    }
    
    private PathNodeType isFree(final int llllllllllllllIIlIIIIlIlIIIIlIIl, final int llllllllllllllIIlIIIIlIlIIIIlIII, final int llllllllllllllIIlIIIIlIlIIIIIlll) {
        final BlockPos.MutableBlockPos llllllllllllllIIlIIIIlIlIIIIIllI = new BlockPos.MutableBlockPos();
        for (int llllllllllllllIIlIIIIlIlIIIIIlIl = llllllllllllllIIlIIIIlIlIIIIlIIl; llllllllllllllIIlIIIIlIlIIIIIlIl < llllllllllllllIIlIIIIlIlIIIIlIIl + this.entitySizeX; ++llllllllllllllIIlIIIIlIlIIIIIlIl) {
            for (int llllllllllllllIIlIIIIlIlIIIIIlII = llllllllllllllIIlIIIIlIlIIIIlIII; llllllllllllllIIlIIIIlIlIIIIIlII < llllllllllllllIIlIIIIlIlIIIIlIII + this.entitySizeY; ++llllllllllllllIIlIIIIlIlIIIIIlII) {
                for (int llllllllllllllIIlIIIIlIlIIIIIIll = llllllllllllllIIlIIIIlIlIIIIIlll; llllllllllllllIIlIIIIlIlIIIIIIll < llllllllllllllIIlIIIIlIlIIIIIlll + this.entitySizeZ; ++llllllllllllllIIlIIIIlIlIIIIIIll) {
                    final IBlockState llllllllllllllIIlIIIIlIlIIIIIIlI = this.blockaccess.getBlockState(llllllllllllllIIlIIIIlIlIIIIIllI.setPos(llllllllllllllIIlIIIIlIlIIIIIlIl, llllllllllllllIIlIIIIlIlIIIIIlII, llllllllllllllIIlIIIIlIlIIIIIIll));
                    if (llllllllllllllIIlIIIIlIlIIIIIIlI.getMaterial() != Material.WATER) {
                        return PathNodeType.BLOCKED;
                    }
                }
            }
        }
        return PathNodeType.WATER;
    }
    
    @Override
    public PathPoint getStart() {
        return this.openPoint(MathHelper.floor(this.entity.getEntityBoundingBox().minX), MathHelper.floor(this.entity.getEntityBoundingBox().minY + 0.5), MathHelper.floor(this.entity.getEntityBoundingBox().minZ));
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess llllllllllllllIIlIIIIlIlIIlIIllI, final int llllllllllllllIIlIIIIlIlIIlIIlIl, final int llllllllllllllIIlIIIIlIlIIlIIlII, final int llllllllllllllIIlIIIIlIlIIlIIIll) {
        return PathNodeType.WATER;
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess llllllllllllllIIlIIIIlIlIIllIIIl, final int llllllllllllllIIlIIIIlIlIIllIIII, final int llllllllllllllIIlIIIIlIlIIlIllll, final int llllllllllllllIIlIIIIlIlIIlIlllI, final EntityLiving llllllllllllllIIlIIIIlIlIIlIllIl, final int llllllllllllllIIlIIIIlIlIIlIllII, final int llllllllllllllIIlIIIIlIlIIlIlIll, final int llllllllllllllIIlIIIIlIlIIlIlIlI, final boolean llllllllllllllIIlIIIIlIlIIlIlIIl, final boolean llllllllllllllIIlIIIIlIlIIlIlIII) {
        return PathNodeType.WATER;
    }
    
    @Override
    public int findPathOptions(final PathPoint[] llllllllllllllIIlIIIIlIlIIllllII, final PathPoint llllllllllllllIIlIIIIlIlIlIIIIll, final PathPoint llllllllllllllIIlIIIIlIlIlIIIIlI, final float llllllllllllllIIlIIIIlIlIlIIIIIl) {
        int llllllllllllllIIlIIIIlIlIlIIIIII = 0;
        final char llllllllllllllIIlIIIIlIlIIllIlII;
        final byte llllllllllllllIIlIIIIlIlIIllIlIl = (byte)((EnumFacing[])(Object)(llllllllllllllIIlIIIIlIlIIllIlII = (char)(Object)EnumFacing.values())).length;
        for (double llllllllllllllIIlIIIIlIlIIllIllI = 0; llllllllllllllIIlIIIIlIlIIllIllI < llllllllllllllIIlIIIIlIlIIllIlIl; ++llllllllllllllIIlIIIIlIlIIllIllI) {
            final EnumFacing llllllllllllllIIlIIIIlIlIIllllll = llllllllllllllIIlIIIIlIlIIllIlII[llllllllllllllIIlIIIIlIlIIllIllI];
            final PathPoint llllllllllllllIIlIIIIlIlIIlllllI = this.getWaterNode(llllllllllllllIIlIIIIlIlIlIIIIll.xCoord + llllllllllllllIIlIIIIlIlIIllllll.getFrontOffsetX(), llllllllllllllIIlIIIIlIlIlIIIIll.yCoord + llllllllllllllIIlIIIIlIlIIllllll.getFrontOffsetY(), llllllllllllllIIlIIIIlIlIlIIIIll.zCoord + llllllllllllllIIlIIIIlIlIIllllll.getFrontOffsetZ());
            if (llllllllllllllIIlIIIIlIlIIlllllI != null && !llllllllllllllIIlIIIIlIlIIlllllI.visited && llllllllllllllIIlIIIIlIlIIlllllI.distanceTo(llllllllllllllIIlIIIIlIlIlIIIIlI) < llllllllllllllIIlIIIIlIlIlIIIIIl) {
                llllllllllllllIIlIIIIlIlIIllllII[llllllllllllllIIlIIIIlIlIlIIIIII++] = llllllllllllllIIlIIIIlIlIIlllllI;
            }
        }
        return llllllllllllllIIlIIIIlIlIlIIIIII;
    }
    
    @Override
    public PathPoint getPathPointToCoords(final double llllllllllllllIIlIIIIlIlIlIlIIll, final double llllllllllllllIIlIIIIlIlIlIlIIlI, final double llllllllllllllIIlIIIIlIlIlIlIlIl) {
        return this.openPoint(MathHelper.floor(llllllllllllllIIlIIIIlIlIlIlIIll - this.entity.width / 2.0f), MathHelper.floor(llllllllllllllIIlIIIIlIlIlIlIIlI + 0.5), MathHelper.floor(llllllllllllllIIlIIIIlIlIlIlIlIl - this.entity.width / 2.0f));
    }
}
