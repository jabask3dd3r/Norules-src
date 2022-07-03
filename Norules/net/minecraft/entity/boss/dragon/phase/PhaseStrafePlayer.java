package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import javax.annotation.*;
import net.minecraft.entity.boss.*;
import org.apache.logging.log4j.*;
import net.minecraft.pathfinding.*;

public class PhaseStrafePlayer extends PhaseBase
{
    private /* synthetic */ EntityLivingBase attackTarget;
    private /* synthetic */ int fireballCharge;
    private /* synthetic */ Vec3d targetLocation;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ boolean holdingPatternClockwise;
    private /* synthetic */ Path currentPath;
    
    @Override
    public void doLocalUpdate() {
        if (this.attackTarget == null) {
            PhaseStrafePlayer.LOGGER.warn("Skipping player strafe phase because no player was found");
            this.dragon.getPhaseManager().setPhase(PhaseList.HOLDING_PATTERN);
        }
        else {
            if (this.currentPath != null && this.currentPath.isFinished()) {
                final double lllllllllllllllllIlIIlllIIlIIIlI = this.attackTarget.posX;
                final double lllllllllllllllllIlIIlllIIlIIIIl = this.attackTarget.posZ;
                final double lllllllllllllllllIlIIlllIIlIIIII = lllllllllllllllllIlIIlllIIlIIIlI - this.dragon.posX;
                final double lllllllllllllllllIlIIlllIIIlllll = lllllllllllllllllIlIIlllIIlIIIIl - this.dragon.posZ;
                final double lllllllllllllllllIlIIlllIIIllllI = MathHelper.sqrt(lllllllllllllllllIlIIlllIIlIIIII * lllllllllllllllllIlIIlllIIlIIIII + lllllllllllllllllIlIIlllIIIlllll * lllllllllllllllllIlIIlllIIIlllll);
                final double lllllllllllllllllIlIIlllIIIlllIl = Math.min(0.4000000059604645 + lllllllllllllllllIlIIlllIIIllllI / 80.0 - 1.0, 10.0);
                this.targetLocation = new Vec3d(lllllllllllllllllIlIIlllIIlIIIlI, this.attackTarget.posY + lllllllllllllllllIlIIlllIIIlllIl, lllllllllllllllllIlIIlllIIlIIIIl);
            }
            final double lllllllllllllllllIlIIlllIIIlllII = (this.targetLocation == null) ? 0.0 : this.targetLocation.squareDistanceTo(this.dragon.posX, this.dragon.posY, this.dragon.posZ);
            if (lllllllllllllllllIlIIlllIIIlllII < 100.0 || lllllllllllllllllIlIIlllIIIlllII > 22500.0) {
                this.findNewTarget();
            }
            final double lllllllllllllllllIlIIlllIIIllIll = 64.0;
            if (this.attackTarget.getDistanceSqToEntity(this.dragon) < 4096.0) {
                if (this.dragon.canEntityBeSeen(this.attackTarget)) {
                    ++this.fireballCharge;
                    final Vec3d lllllllllllllllllIlIIlllIIIllIlI = new Vec3d(this.attackTarget.posX - this.dragon.posX, 0.0, this.attackTarget.posZ - this.dragon.posZ).normalize();
                    final Vec3d lllllllllllllllllIlIIlllIIIllIIl = new Vec3d(MathHelper.sin(this.dragon.rotationYaw * 0.017453292f), 0.0, -MathHelper.cos(this.dragon.rotationYaw * 0.017453292f)).normalize();
                    final float lllllllllllllllllIlIIlllIIIllIII = (float)lllllllllllllllllIlIIlllIIIllIIl.dotProduct(lllllllllllllllllIlIIlllIIIllIlI);
                    float lllllllllllllllllIlIIlllIIIlIlll = (float)(Math.acos(lllllllllllllllllIlIIlllIIIllIII) * 57.29577951308232);
                    lllllllllllllllllIlIIlllIIIlIlll += 0.5f;
                    if (this.fireballCharge >= 5 && lllllllllllllllllIlIIlllIIIlIlll >= 0.0f && lllllllllllllllllIlIIlllIIIlIlll < 10.0f) {
                        final double lllllllllllllllllIlIIlllIIIlIllI = 1.0;
                        final Vec3d lllllllllllllllllIlIIlllIIIlIlIl = this.dragon.getLook(1.0f);
                        final double lllllllllllllllllIlIIlllIIIlIlII = this.dragon.dragonPartHead.posX - lllllllllllllllllIlIIlllIIIlIlIl.xCoord * 1.0;
                        final double lllllllllllllllllIlIIlllIIIlIIll = this.dragon.dragonPartHead.posY + this.dragon.dragonPartHead.height / 2.0f + 0.5;
                        final double lllllllllllllllllIlIIlllIIIlIIlI = this.dragon.dragonPartHead.posZ - lllllllllllllllllIlIIlllIIIlIlIl.zCoord * 1.0;
                        final double lllllllllllllllllIlIIlllIIIlIIIl = this.attackTarget.posX - lllllllllllllllllIlIIlllIIIlIlII;
                        final double lllllllllllllllllIlIIlllIIIlIIII = this.attackTarget.posY + this.attackTarget.height / 2.0f - (lllllllllllllllllIlIIlllIIIlIIll + this.dragon.dragonPartHead.height / 2.0f);
                        final double lllllllllllllllllIlIIlllIIIIllll = this.attackTarget.posZ - lllllllllllllllllIlIIlllIIIlIIlI;
                        this.dragon.world.playEvent(null, 1017, new BlockPos(this.dragon), 0);
                        final EntityDragonFireball lllllllllllllllllIlIIlllIIIIlllI = new EntityDragonFireball(this.dragon.world, this.dragon, lllllllllllllllllIlIIlllIIIlIIIl, lllllllllllllllllIlIIlllIIIlIIII, lllllllllllllllllIlIIlllIIIIllll);
                        lllllllllllllllllIlIIlllIIIIlllI.setLocationAndAngles(lllllllllllllllllIlIIlllIIIlIlII, lllllllllllllllllIlIIlllIIIlIIll, lllllllllllllllllIlIIlllIIIlIIlI, 0.0f, 0.0f);
                        this.dragon.world.spawnEntityInWorld(lllllllllllllllllIlIIlllIIIIlllI);
                        this.fireballCharge = 0;
                        if (this.currentPath != null) {
                            while (!this.currentPath.isFinished()) {
                                this.currentPath.incrementPathIndex();
                            }
                        }
                        this.dragon.getPhaseManager().setPhase(PhaseList.HOLDING_PATTERN);
                    }
                }
                else if (this.fireballCharge > 0) {
                    --this.fireballCharge;
                }
            }
            else if (this.fireballCharge > 0) {
                --this.fireballCharge;
            }
        }
    }
    
    @Override
    public PhaseList<PhaseStrafePlayer> getPhaseList() {
        return PhaseList.STRAFE_PLAYER;
    }
    
    private void navigateToNextPathNode() {
        if (this.currentPath != null && !this.currentPath.isFinished()) {
            final Vec3d lllllllllllllllllIlIIllIlllIlllI = this.currentPath.getCurrentPos();
            this.currentPath.incrementPathIndex();
            final double lllllllllllllllllIlIIllIlllIllIl = lllllllllllllllllIlIIllIlllIlllI.xCoord;
            final double lllllllllllllllllIlIIllIlllIllII = lllllllllllllllllIlIIllIlllIlllI.zCoord;
            double lllllllllllllllllIlIIllIlllIlIll;
            do {
                lllllllllllllllllIlIIllIlllIlIll = lllllllllllllllllIlIIllIlllIlllI.yCoord + this.dragon.getRNG().nextFloat() * 20.0f;
            } while (lllllllllllllllllIlIIllIlllIlIll < lllllllllllllllllIlIIllIlllIlllI.yCoord);
            this.targetLocation = new Vec3d(lllllllllllllllllIlIIllIlllIllIl, lllllllllllllllllIlIIllIlllIlIll, lllllllllllllllllIlIIllIlllIllII);
        }
    }
    
    @Nullable
    @Override
    public Vec3d getTargetLocation() {
        return this.targetLocation;
    }
    
    public PhaseStrafePlayer(final EntityDragon lllllllllllllllllIlIIlllIIllIllI) {
        super(lllllllllllllllllIlIIlllIIllIllI);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void setTarget(final EntityLivingBase lllllllllllllllllIlIIllIllIlIlIl) {
        this.attackTarget = lllllllllllllllllIlIIllIllIlIlIl;
        final int lllllllllllllllllIlIIllIllIlIlII = this.dragon.initPathPoints();
        final int lllllllllllllllllIlIIllIllIlIIll = this.dragon.getNearestPpIdx(this.attackTarget.posX, this.attackTarget.posY, this.attackTarget.posZ);
        final int lllllllllllllllllIlIIllIllIlIIlI = MathHelper.floor(this.attackTarget.posX);
        final int lllllllllllllllllIlIIllIllIlIIIl = MathHelper.floor(this.attackTarget.posZ);
        final double lllllllllllllllllIlIIllIllIlIIII = lllllllllllllllllIlIIllIllIlIIlI - this.dragon.posX;
        final double lllllllllllllllllIlIIllIllIIllll = lllllllllllllllllIlIIllIllIlIIIl - this.dragon.posZ;
        final double lllllllllllllllllIlIIllIllIIlllI = MathHelper.sqrt(lllllllllllllllllIlIIllIllIlIIII * lllllllllllllllllIlIIllIllIlIIII + lllllllllllllllllIlIIllIllIIllll * lllllllllllllllllIlIIllIllIIllll);
        final double lllllllllllllllllIlIIllIllIIllIl = Math.min(0.4000000059604645 + lllllllllllllllllIlIIllIllIIlllI / 80.0 - 1.0, 10.0);
        final int lllllllllllllllllIlIIllIllIIllII = MathHelper.floor(this.attackTarget.posY + lllllllllllllllllIlIIllIllIIllIl);
        final PathPoint lllllllllllllllllIlIIllIllIIlIll = new PathPoint(lllllllllllllllllIlIIllIllIlIIlI, lllllllllllllllllIlIIllIllIIllII, lllllllllllllllllIlIIllIllIlIIIl);
        this.currentPath = this.dragon.findPath(lllllllllllllllllIlIIllIllIlIlII, lllllllllllllllllIlIIllIllIlIIll, lllllllllllllllllIlIIllIllIIlIll);
        if (this.currentPath != null) {
            this.currentPath.incrementPathIndex();
            this.navigateToNextPathNode();
        }
    }
    
    private void findNewTarget() {
        if (this.currentPath == null || this.currentPath.isFinished()) {
            int lllllllllllllllllIlIIllIlllllIII;
            final int lllllllllllllllllIlIIllIlllllIIl = lllllllllllllllllIlIIllIlllllIII = this.dragon.initPathPoints();
            if (this.dragon.getRNG().nextInt(8) == 0) {
                this.holdingPatternClockwise = !this.holdingPatternClockwise;
                lllllllllllllllllIlIIllIlllllIII = lllllllllllllllllIlIIllIlllllIIl + 6;
            }
            if (this.holdingPatternClockwise) {
                ++lllllllllllllllllIlIIllIlllllIII;
            }
            else {
                --lllllllllllllllllIlIIllIlllllIII;
            }
            if (this.dragon.getFightManager() != null && this.dragon.getFightManager().getNumAliveCrystals() > 0) {
                lllllllllllllllllIlIIllIlllllIII %= 12;
                if (lllllllllllllllllIlIIllIlllllIII < 0) {
                    lllllllllllllllllIlIIllIlllllIII += 12;
                }
            }
            else {
                lllllllllllllllllIlIIllIlllllIII -= 12;
                lllllllllllllllllIlIIllIlllllIII &= 0x7;
                lllllllllllllllllIlIIllIlllllIII += 12;
            }
            this.currentPath = this.dragon.findPath(lllllllllllllllllIlIIllIlllllIIl, lllllllllllllllllIlIIllIlllllIII, null);
            if (this.currentPath != null) {
                this.currentPath.incrementPathIndex();
            }
        }
        this.navigateToNextPathNode();
    }
    
    @Override
    public void initPhase() {
        this.fireballCharge = 0;
        this.targetLocation = null;
        this.currentPath = null;
        this.attackTarget = null;
    }
}
