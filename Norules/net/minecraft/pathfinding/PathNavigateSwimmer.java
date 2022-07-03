package net.minecraft.pathfinding;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class PathNavigateSwimmer extends PathNavigate
{
    public PathNavigateSwimmer(final EntityLiving lllllllllllllIllllIIlIlIlIIlIIII, final World lllllllllllllIllllIIlIlIlIIIllll) {
        super(lllllllllllllIllllIIlIlIlIIlIIII, lllllllllllllIllllIIlIlIlIIIllll);
    }
    
    @Override
    protected boolean canNavigate() {
        return this.isInLiquid();
    }
    
    @Override
    public boolean canEntityStandOnPos(final BlockPos lllllllllllllIllllIIlIlIIllIIIIl) {
        return !this.worldObj.getBlockState(lllllllllllllIllllIIlIlIIllIIIIl).isFullBlock();
    }
    
    @Override
    protected boolean isDirectPathBetweenPoints(final Vec3d lllllllllllllIllllIIlIlIIllIlIIl, final Vec3d lllllllllllllIllllIIlIlIIllIllll, final int lllllllllllllIllllIIlIlIIllIlllI, final int lllllllllllllIllllIIlIlIIllIllIl, final int lllllllllllllIllllIIlIlIIllIllII) {
        final RayTraceResult lllllllllllllIllllIIlIlIIllIlIll = this.worldObj.rayTraceBlocks(lllllllllllllIllllIIlIlIIllIlIIl, new Vec3d(lllllllllllllIllllIIlIlIIllIllll.xCoord, lllllllllllllIllllIIlIlIIllIllll.yCoord + this.theEntity.height * 0.5, lllllllllllllIllllIIlIlIIllIllll.zCoord), false, true, false);
        return lllllllllllllIllllIIlIlIIllIlIll == null || lllllllllllllIllllIIlIlIIllIlIll.typeOfHit == RayTraceResult.Type.MISS;
    }
    
    @Override
    protected PathFinder getPathFinder() {
        return new PathFinder(new SwimNodeProcessor());
    }
    
    @Override
    protected Vec3d getEntityPosition() {
        return new Vec3d(this.theEntity.posX, this.theEntity.posY + this.theEntity.height * 0.5, this.theEntity.posZ);
    }
    
    @Override
    protected void pathFollow() {
        final Vec3d lllllllllllllIllllIIlIlIlIIIIIII = this.getEntityPosition();
        final float lllllllllllllIllllIIlIlIIlllllll = this.theEntity.width * this.theEntity.width;
        final int lllllllllllllIllllIIlIlIIllllllI = 6;
        if (lllllllllllllIllllIIlIlIlIIIIIII.squareDistanceTo(this.currentPath.getVectorFromIndex(this.theEntity, this.currentPath.getCurrentPathIndex())) < lllllllllllllIllllIIlIlIIlllllll) {
            this.currentPath.incrementPathIndex();
        }
        for (int lllllllllllllIllllIIlIlIIlllllIl = Math.min(this.currentPath.getCurrentPathIndex() + 6, this.currentPath.getCurrentPathLength() - 1); lllllllllllllIllllIIlIlIIlllllIl > this.currentPath.getCurrentPathIndex(); --lllllllllllllIllllIIlIlIIlllllIl) {
            final Vec3d lllllllllllllIllllIIlIlIIlllllII = this.currentPath.getVectorFromIndex(this.theEntity, lllllllllllllIllllIIlIlIIlllllIl);
            if (lllllllllllllIllllIIlIlIIlllllII.squareDistanceTo(lllllllllllllIllllIIlIlIlIIIIIII) <= 36.0 && this.isDirectPathBetweenPoints(lllllllllllllIllllIIlIlIlIIIIIII, lllllllllllllIllllIIlIlIIlllllII, 0, 0, 0)) {
                this.currentPath.setCurrentPathIndex(lllllllllllllIllllIIlIlIIlllllIl);
                break;
            }
        }
        this.checkForStuck(lllllllllllllIllllIIlIlIlIIIIIII);
    }
}
