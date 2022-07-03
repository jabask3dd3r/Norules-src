package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.entity.boss.*;
import net.minecraft.pathfinding.*;
import javax.annotation.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.util.math.*;

public class PhaseTakeoff extends PhaseBase
{
    private /* synthetic */ boolean firstTick;
    private /* synthetic */ Path currentPath;
    private /* synthetic */ Vec3d targetLocation;
    
    public PhaseTakeoff(final EntityDragon lllllllllllllIIIlllIIIllIllllIll) {
        super(lllllllllllllIIIlllIIIllIllllIll);
    }
    
    private void findNewTarget() {
        final int lllllllllllllIIIlllIIIllIllIlIIl = this.dragon.initPathPoints();
        final Vec3d lllllllllllllIIIlllIIIllIllIlIII = this.dragon.getHeadLookVec(1.0f);
        int lllllllllllllIIIlllIIIllIllIIlll = this.dragon.getNearestPpIdx(-lllllllllllllIIIlllIIIllIllIlIII.xCoord * 40.0, 105.0, -lllllllllllllIIIlllIIIllIllIlIII.zCoord * 40.0);
        if (this.dragon.getFightManager() != null && this.dragon.getFightManager().getNumAliveCrystals() > 0) {
            lllllllllllllIIIlllIIIllIllIIlll %= 12;
            if (lllllllllllllIIIlllIIIllIllIIlll < 0) {
                lllllllllllllIIIlllIIIllIllIIlll += 12;
            }
        }
        else {
            lllllllllllllIIIlllIIIllIllIIlll -= 12;
            lllllllllllllIIIlllIIIllIllIIlll &= 0x7;
            lllllllllllllIIIlllIIIllIllIIlll += 12;
        }
        this.currentPath = this.dragon.findPath(lllllllllllllIIIlllIIIllIllIlIIl, lllllllllllllIIIlllIIIllIllIIlll, null);
        if (this.currentPath != null) {
            this.currentPath.incrementPathIndex();
            this.navigateToNextPathNode();
        }
    }
    
    @Nullable
    @Override
    public Vec3d getTargetLocation() {
        return this.targetLocation;
    }
    
    @Override
    public void doLocalUpdate() {
        if (!this.firstTick && this.currentPath != null) {
            final BlockPos lllllllllllllIIIlllIIIllIlllIllI = this.dragon.world.getTopSolidOrLiquidBlock(WorldGenEndPodium.END_PODIUM_LOCATION);
            final double lllllllllllllIIIlllIIIllIlllIlIl = this.dragon.getDistanceSqToCenter(lllllllllllllIIIlllIIIllIlllIllI);
            if (lllllllllllllIIIlllIIIllIlllIlIl > 100.0) {
                this.dragon.getPhaseManager().setPhase(PhaseList.HOLDING_PATTERN);
            }
        }
        else {
            this.firstTick = false;
            this.findNewTarget();
        }
    }
    
    @Override
    public void initPhase() {
        this.firstTick = true;
        this.currentPath = null;
        this.targetLocation = null;
    }
    
    @Override
    public PhaseList<PhaseTakeoff> getPhaseList() {
        return PhaseList.TAKEOFF;
    }
    
    private void navigateToNextPathNode() {
        final Vec3d lllllllllllllIIIlllIIIllIlIllllI = this.currentPath.getCurrentPos();
        this.currentPath.incrementPathIndex();
        double lllllllllllllIIIlllIIIllIlIlllIl;
        do {
            lllllllllllllIIIlllIIIllIlIlllIl = lllllllllllllIIIlllIIIllIlIllllI.yCoord + this.dragon.getRNG().nextFloat() * 20.0f;
        } while (lllllllllllllIIIlllIIIllIlIlllIl < lllllllllllllIIIlllIIIllIlIllllI.yCoord);
        this.targetLocation = new Vec3d(lllllllllllllIIIlllIIIllIlIllllI.xCoord, lllllllllllllIIIlllIIIllIlIlllIl, lllllllllllllIIIlllIIIllIlIllllI.zCoord);
    }
}
