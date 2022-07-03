package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.entity.boss.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class PhaseSittingScanning extends PhaseSittingBase
{
    private /* synthetic */ int scanningTime;
    
    @Override
    public void initPhase() {
        this.scanningTime = 0;
    }
    
    @Override
    public PhaseList<PhaseSittingScanning> getPhaseList() {
        return PhaseList.SITTING_SCANNING;
    }
    
    public PhaseSittingScanning(final EntityDragon llllllIIlllIlIl) {
        super(llllllIIlllIlIl);
    }
    
    @Override
    public void doLocalUpdate() {
        ++this.scanningTime;
        EntityLivingBase llllllIIllIlIII = this.dragon.world.getNearestAttackablePlayer(this.dragon, 20.0, 10.0);
        if (llllllIIllIlIII != null) {
            if (this.scanningTime > 25) {
                this.dragon.getPhaseManager().setPhase(PhaseList.SITTING_ATTACKING);
            }
            else {
                final Vec3d llllllIIllIIlll = new Vec3d(llllllIIllIlIII.posX - this.dragon.posX, 0.0, llllllIIllIlIII.posZ - this.dragon.posZ).normalize();
                final Vec3d llllllIIllIIllI = new Vec3d(MathHelper.sin(this.dragon.rotationYaw * 0.017453292f), 0.0, -MathHelper.cos(this.dragon.rotationYaw * 0.017453292f)).normalize();
                final float llllllIIllIIlIl = (float)llllllIIllIIllI.dotProduct(llllllIIllIIlll);
                final float llllllIIllIIlII = (float)(Math.acos(llllllIIllIIlIl) * 57.29577951308232) + 0.5f;
                if (llllllIIllIIlII < 0.0f || llllllIIllIIlII > 10.0f) {
                    final double llllllIIllIIIll = llllllIIllIlIII.posX - this.dragon.dragonPartHead.posX;
                    final double llllllIIllIIIlI = llllllIIllIlIII.posZ - this.dragon.dragonPartHead.posZ;
                    final double llllllIIllIIIIl = MathHelper.clamp(MathHelper.wrapDegrees(180.0 - MathHelper.atan2(llllllIIllIIIll, llllllIIllIIIlI) * 57.29577951308232 - this.dragon.rotationYaw), -100.0, 100.0);
                    final EntityDragon dragon = this.dragon;
                    dragon.randomYawVelocity *= 0.8f;
                    final float llllllIIlIlllll;
                    float llllllIIllIIIII = llllllIIlIlllll = MathHelper.sqrt(llllllIIllIIIll * llllllIIllIIIll + llllllIIllIIIlI * llllllIIllIIIlI) + 1.0f;
                    if (llllllIIllIIIII > 40.0f) {
                        llllllIIllIIIII = 40.0f;
                    }
                    this.dragon.randomYawVelocity += (float)(llllllIIllIIIIl * (0.7f / llllllIIllIIIII / llllllIIlIlllll));
                    final EntityDragon dragon2 = this.dragon;
                    dragon2.rotationYaw += this.dragon.randomYawVelocity;
                }
            }
        }
        else if (this.scanningTime >= 100) {
            llllllIIllIlIII = this.dragon.world.getNearestAttackablePlayer(this.dragon, 150.0, 150.0);
            this.dragon.getPhaseManager().setPhase(PhaseList.TAKEOFF);
            if (llllllIIllIlIII != null) {
                this.dragon.getPhaseManager().setPhase(PhaseList.CHARGING_PLAYER);
                this.dragon.getPhaseManager().getPhase(PhaseList.CHARGING_PLAYER).setTarget(new Vec3d(llllllIIllIlIII.posX, llllllIIllIlIII.posY, llllllIIllIlIII.posZ));
            }
        }
    }
}
