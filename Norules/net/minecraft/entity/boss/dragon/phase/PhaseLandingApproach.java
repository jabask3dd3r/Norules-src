package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.world.gen.feature.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.boss.*;
import javax.annotation.*;

public class PhaseLandingApproach extends PhaseBase
{
    private /* synthetic */ Path currentPath;
    private /* synthetic */ Vec3d targetLocation;
    
    private void navigateToNextPathNode() {
        if (this.currentPath != null && !this.currentPath.isFinished()) {
            final Vec3d llllllllllllllIllIllllIIIlIllIlI = this.currentPath.getCurrentPos();
            this.currentPath.incrementPathIndex();
            final double llllllllllllllIllIllllIIIlIllIIl = llllllllllllllIllIllllIIIlIllIlI.xCoord;
            final double llllllllllllllIllIllllIIIlIllIII = llllllllllllllIllIllllIIIlIllIlI.zCoord;
            double llllllllllllllIllIllllIIIlIlIlll;
            do {
                llllllllllllllIllIllllIIIlIlIlll = llllllllllllllIllIllllIIIlIllIlI.yCoord + this.dragon.getRNG().nextFloat() * 20.0f;
            } while (llllllllllllllIllIllllIIIlIlIlll < llllllllllllllIllIllllIIIlIllIlI.yCoord);
            this.targetLocation = new Vec3d(llllllllllllllIllIllllIIIlIllIIl, llllllllllllllIllIllllIIIlIlIlll, llllllllllllllIllIllllIIIlIllIII);
        }
    }
    
    @Override
    public void doLocalUpdate() {
        final double llllllllllllllIllIllllIIIllllIlI = (this.targetLocation == null) ? 0.0 : this.targetLocation.squareDistanceTo(this.dragon.posX, this.dragon.posY, this.dragon.posZ);
        if (llllllllllllllIllIllllIIIllllIlI < 100.0 || llllllllllllllIllIllllIIIllllIlI > 22500.0 || this.dragon.isCollidedHorizontally || this.dragon.isCollidedVertically) {
            this.findNewTarget();
        }
    }
    
    private void findNewTarget() {
        if (this.currentPath == null || this.currentPath.isFinished()) {
            final int llllllllllllllIllIllllIIIllIllIl = this.dragon.initPathPoints();
            final BlockPos llllllllllllllIllIllllIIIllIllII = this.dragon.world.getTopSolidOrLiquidBlock(WorldGenEndPodium.END_PODIUM_LOCATION);
            final EntityPlayer llllllllllllllIllIllllIIIllIlIll = this.dragon.world.getNearestAttackablePlayer(llllllllllllllIllIllllIIIllIllII, 128.0, 128.0);
            int llllllllllllllIllIllllIIIllIlIIl = 0;
            if (llllllllllllllIllIllllIIIllIlIll != null) {
                final Vec3d llllllllllllllIllIllllIIIllIlIII = new Vec3d(llllllllllllllIllIllllIIIllIlIll.posX, 0.0, llllllllllllllIllIllllIIIllIlIll.posZ).normalize();
                final int llllllllllllllIllIllllIIIllIlIlI = this.dragon.getNearestPpIdx(-llllllllllllllIllIllllIIIllIlIII.xCoord * 40.0, 105.0, -llllllllllllllIllIllllIIIllIlIII.zCoord * 40.0);
            }
            else {
                llllllllllllllIllIllllIIIllIlIIl = this.dragon.getNearestPpIdx(40.0, llllllllllllllIllIllllIIIllIllII.getY(), 0.0);
            }
            final PathPoint llllllllllllllIllIllllIIIllIIlll = new PathPoint(llllllllllllllIllIllllIIIllIllII.getX(), llllllllllllllIllIllllIIIllIllII.getY(), llllllllllllllIllIllllIIIllIllII.getZ());
            this.currentPath = this.dragon.findPath(llllllllllllllIllIllllIIIllIllIl, llllllllllllllIllIllllIIIllIlIIl, llllllllllllllIllIllllIIIllIIlll);
            if (this.currentPath != null) {
                this.currentPath.incrementPathIndex();
            }
        }
        this.navigateToNextPathNode();
        if (this.currentPath != null && this.currentPath.isFinished()) {
            this.dragon.getPhaseManager().setPhase(PhaseList.LANDING);
        }
    }
    
    public PhaseLandingApproach(final EntityDragon llllllllllllllIllIllllIIlIIIIlII) {
        super(llllllllllllllIllIllllIIlIIIIlII);
    }
    
    @Nullable
    @Override
    public Vec3d getTargetLocation() {
        return this.targetLocation;
    }
    
    @Override
    public PhaseList<PhaseLandingApproach> getPhaseList() {
        return PhaseList.LANDING_APPROACH;
    }
    
    @Override
    public void initPhase() {
        this.currentPath = null;
        this.targetLocation = null;
    }
}
