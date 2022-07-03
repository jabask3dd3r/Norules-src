package net.minecraft.entity.boss.dragon.phase;

import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.util.math.*;
import net.minecraft.pathfinding.*;

public class PhaseHoldingPattern extends PhaseBase
{
    private /* synthetic */ boolean clockwise;
    private /* synthetic */ Path currentPath;
    private /* synthetic */ Vec3d targetLocation;
    
    @Nullable
    @Override
    public Vec3d getTargetLocation() {
        return this.targetLocation;
    }
    
    private void strafePlayer(final EntityPlayer llllllllllllllIllllIIIIlllIllIII) {
        this.dragon.getPhaseManager().setPhase(PhaseList.STRAFE_PLAYER);
        this.dragon.getPhaseManager().getPhase(PhaseList.STRAFE_PLAYER).setTarget(llllllllllllllIllllIIIIlllIllIII);
    }
    
    public PhaseHoldingPattern(final EntityDragon llllllllllllllIllllIIIIllllllllI) {
        super(llllllllllllllIllllIIIIllllllllI);
    }
    
    private void navigateToNextPathNode() {
        if (this.currentPath != null && !this.currentPath.isFinished()) {
            final Vec3d llllllllllllllIllllIIIIlllIlIIIl = this.currentPath.getCurrentPos();
            this.currentPath.incrementPathIndex();
            final double llllllllllllllIllllIIIIlllIlIIII = llllllllllllllIllllIIIIlllIlIIIl.xCoord;
            final double llllllllllllllIllllIIIIlllIIllll = llllllllllllllIllllIIIIlllIlIIIl.zCoord;
            double llllllllllllllIllllIIIIlllIIlllI;
            do {
                llllllllllllllIllllIIIIlllIIlllI = llllllllllllllIllllIIIIlllIlIIIl.yCoord + this.dragon.getRNG().nextFloat() * 20.0f;
            } while (llllllllllllllIllllIIIIlllIIlllI < llllllllllllllIllllIIIIlllIlIIIl.yCoord);
            this.targetLocation = new Vec3d(llllllllllllllIllllIIIIlllIlIIII, llllllllllllllIllllIIIIlllIIlllI, llllllllllllllIllllIIIIlllIIllll);
        }
    }
    
    @Override
    public void onCrystalDestroyed(final EntityEnderCrystal llllllllllllllIllllIIIIlllIIIlIl, final BlockPos llllllllllllllIllllIIIIlllIIIlII, final DamageSource llllllllllllllIllllIIIIlllIIIIll, @Nullable final EntityPlayer llllllllllllllIllllIIIIlllIIIIII) {
        if (llllllllllllllIllllIIIIlllIIIIII != null && !llllllllllllllIllllIIIIlllIIIIII.capabilities.disableDamage) {
            this.strafePlayer(llllllllllllllIllllIIIIlllIIIIII);
        }
    }
    
    @Override
    public void initPhase() {
        this.currentPath = null;
        this.targetLocation = null;
    }
    
    @Override
    public PhaseList<PhaseHoldingPattern> getPhaseList() {
        return PhaseList.HOLDING_PATTERN;
    }
    
    private void findNewTarget() {
        if (this.currentPath != null && this.currentPath.isFinished()) {
            final BlockPos llllllllllllllIllllIIIIllllIlIII = this.dragon.world.getTopSolidOrLiquidBlock(new BlockPos(WorldGenEndPodium.END_PODIUM_LOCATION));
            final int llllllllllllllIllllIIIIllllIIlll = (this.dragon.getFightManager() == null) ? 0 : this.dragon.getFightManager().getNumAliveCrystals();
            if (this.dragon.getRNG().nextInt(llllllllllllllIllllIIIIllllIIlll + 3) == 0) {
                this.dragon.getPhaseManager().setPhase(PhaseList.LANDING_APPROACH);
                return;
            }
            double llllllllllllllIllllIIIIllllIIllI = 64.0;
            final EntityPlayer llllllllllllllIllllIIIIllllIIlIl = this.dragon.world.getNearestAttackablePlayer(llllllllllllllIllllIIIIllllIlIII, llllllllllllllIllllIIIIllllIIllI, llllllllllllllIllllIIIIllllIIllI);
            if (llllllllllllllIllllIIIIllllIIlIl != null) {
                llllllllllllllIllllIIIIllllIIllI = llllllllllllllIllllIIIIllllIIlIl.getDistanceSqToCenter(llllllllllllllIllllIIIIllllIlIII) / 512.0;
            }
            if (llllllllllllllIllllIIIIllllIIlIl != null && (this.dragon.getRNG().nextInt(MathHelper.abs((int)llllllllllllllIllllIIIIllllIIllI) + 2) == 0 || this.dragon.getRNG().nextInt(llllllllllllllIllllIIIIllllIIlll + 2) == 0)) {
                this.strafePlayer(llllllllllllllIllllIIIIllllIIlIl);
                return;
            }
        }
        if (this.currentPath == null || this.currentPath.isFinished()) {
            int llllllllllllllIllllIIIIllllIIIll;
            final int llllllllllllllIllllIIIIllllIIlII = llllllllllllllIllllIIIIllllIIIll = this.dragon.initPathPoints();
            if (this.dragon.getRNG().nextInt(8) == 0) {
                this.clockwise = !this.clockwise;
                llllllllllllllIllllIIIIllllIIIll = llllllllllllllIllllIIIIllllIIlII + 6;
            }
            if (this.clockwise) {
                ++llllllllllllllIllllIIIIllllIIIll;
            }
            else {
                --llllllllllllllIllllIIIIllllIIIll;
            }
            if (this.dragon.getFightManager() != null && this.dragon.getFightManager().getNumAliveCrystals() >= 0) {
                llllllllllllllIllllIIIIllllIIIll %= 12;
                if (llllllllllllllIllllIIIIllllIIIll < 0) {
                    llllllllllllllIllllIIIIllllIIIll += 12;
                }
            }
            else {
                llllllllllllllIllllIIIIllllIIIll -= 12;
                llllllllllllllIllllIIIIllllIIIll &= 0x7;
                llllllllllllllIllllIIIIllllIIIll += 12;
            }
            this.currentPath = this.dragon.findPath(llllllllllllllIllllIIIIllllIIlII, llllllllllllllIllllIIIIllllIIIll, null);
            if (this.currentPath != null) {
                this.currentPath.incrementPathIndex();
            }
        }
        this.navigateToNextPathNode();
    }
    
    @Override
    public void doLocalUpdate() {
        final double llllllllllllllIllllIIIIlllllIlll = (this.targetLocation == null) ? 0.0 : this.targetLocation.squareDistanceTo(this.dragon.posX, this.dragon.posY, this.dragon.posZ);
        if (llllllllllllllIllllIIIIlllllIlll < 100.0 || llllllllllllllIllllIIIIlllllIlll > 22500.0 || this.dragon.isCollidedHorizontally || this.dragon.isCollidedVertically) {
            this.findNewTarget();
        }
    }
}
