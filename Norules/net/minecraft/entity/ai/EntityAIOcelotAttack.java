package net.minecraft.entity.ai;

import net.minecraft.world.*;
import net.minecraft.entity.*;

public class EntityAIOcelotAttack extends EntityAIBase
{
    /* synthetic */ EntityLiving theEntity;
    /* synthetic */ World theWorld;
    /* synthetic */ EntityLivingBase theVictim;
    /* synthetic */ int attackCountdown;
    
    public EntityAIOcelotAttack(final EntityLiving llllllllllllllIllllIIIIllIlIlIIl) {
        this.theEntity = llllllllllllllIllllIIIIllIlIlIIl;
        this.theWorld = llllllllllllllIllllIIIIllIlIlIIl.world;
        this.setMutexBits(3);
    }
    
    @Override
    public void resetTask() {
        this.theVictim = null;
        this.theEntity.getNavigator().clearPathEntity();
    }
    
    @Override
    public void updateTask() {
        this.theEntity.getLookHelper().setLookPositionWithEntity(this.theVictim, 30.0f, 30.0f);
        final double llllllllllllllIllllIIIIllIIlIlll = this.theEntity.width * 2.0f * this.theEntity.width * 2.0f;
        final double llllllllllllllIllllIIIIllIIlIllI = this.theEntity.getDistanceSq(this.theVictim.posX, this.theVictim.getEntityBoundingBox().minY, this.theVictim.posZ);
        double llllllllllllllIllllIIIIllIIlIlIl = 0.8;
        if (llllllllllllllIllllIIIIllIIlIllI > llllllllllllllIllllIIIIllIIlIlll && llllllllllllllIllllIIIIllIIlIllI < 16.0) {
            llllllllllllllIllllIIIIllIIlIlIl = 1.33;
        }
        else if (llllllllllllllIllllIIIIllIIlIllI < 225.0) {
            llllllllllllllIllllIIIIllIIlIlIl = 0.6;
        }
        this.theEntity.getNavigator().tryMoveToEntityLiving(this.theVictim, llllllllllllllIllllIIIIllIIlIlIl);
        this.attackCountdown = Math.max(this.attackCountdown - 1, 0);
        if (llllllllllllllIllllIIIIllIIlIllI <= llllllllllllllIllllIIIIllIIlIlll && this.attackCountdown <= 0) {
            this.attackCountdown = 20;
            this.theEntity.attackEntityAsMob(this.theVictim);
        }
    }
    
    @Override
    public boolean continueExecuting() {
        return this.theVictim.isEntityAlive() && this.theEntity.getDistanceSqToEntity(this.theVictim) <= 225.0 && (!this.theEntity.getNavigator().noPath() || this.shouldExecute());
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase llllllllllllllIllllIIIIllIlIIlIl = this.theEntity.getAttackTarget();
        if (llllllllllllllIllllIIIIllIlIIlIl == null) {
            return false;
        }
        this.theVictim = llllllllllllllIllllIIIIllIlIIlIl;
        return true;
    }
}
