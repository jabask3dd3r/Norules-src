package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class EntityAILeapAtTarget extends EntityAIBase
{
    /* synthetic */ float leapMotionY;
    /* synthetic */ EntityLivingBase leapTarget;
    /* synthetic */ EntityLiving leaper;
    
    public EntityAILeapAtTarget(final EntityLiving lllllllllllllIlIllIlIlIIlIllllll, final float lllllllllllllIlIllIlIlIIlIlllIll) {
        this.leaper = lllllllllllllIlIllIlIlIIlIllllll;
        this.leapMotionY = lllllllllllllIlIllIlIlIIlIlllIll;
        this.setMutexBits(5);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.leaper.onGround;
    }
    
    @Override
    public void startExecuting() {
        final double lllllllllllllIlIllIlIlIIlIlIllII = this.leapTarget.posX - this.leaper.posX;
        final double lllllllllllllIlIllIlIlIIlIlIlIll = this.leapTarget.posZ - this.leaper.posZ;
        final float lllllllllllllIlIllIlIlIIlIlIlIlI = MathHelper.sqrt(lllllllllllllIlIllIlIlIIlIlIllII * lllllllllllllIlIllIlIlIIlIlIllII + lllllllllllllIlIllIlIlIIlIlIlIll * lllllllllllllIlIllIlIlIIlIlIlIll);
        if (lllllllllllllIlIllIlIlIIlIlIlIlI >= 1.0E-4) {
            final EntityLiving leaper = this.leaper;
            leaper.motionX += lllllllllllllIlIllIlIlIIlIlIllII / lllllllllllllIlIllIlIlIIlIlIlIlI * 0.5 * 0.800000011920929 + this.leaper.motionX * 0.20000000298023224;
            final EntityLiving leaper2 = this.leaper;
            leaper2.motionZ += lllllllllllllIlIllIlIlIIlIlIlIll / lllllllllllllIlIllIlIlIIlIlIlIlI * 0.5 * 0.800000011920929 + this.leaper.motionZ * 0.20000000298023224;
        }
        this.leaper.motionY = this.leapMotionY;
    }
    
    @Override
    public boolean shouldExecute() {
        this.leapTarget = this.leaper.getAttackTarget();
        if (this.leapTarget == null) {
            return false;
        }
        final double lllllllllllllIlIllIlIlIIlIllIlll = this.leaper.getDistanceSqToEntity(this.leapTarget);
        return lllllllllllllIlIllIlIlIIlIllIlll >= 4.0 && lllllllllllllIlIllIlIlIIlIllIlll <= 16.0 && this.leaper.onGround && this.leaper.getRNG().nextInt(5) == 0;
    }
}
