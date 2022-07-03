package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class EntityAIOwnerHurtByTarget extends EntityAITarget
{
    private /* synthetic */ int timestamp;
    /* synthetic */ EntityLivingBase theOwnerAttacker;
    /* synthetic */ EntityTameable theDefendingTameable;
    
    @Override
    public boolean shouldExecute() {
        if (!this.theDefendingTameable.isTamed()) {
            return false;
        }
        final EntityLivingBase lllIIlIlllllIlI = this.theDefendingTameable.getOwner();
        if (lllIIlIlllllIlI == null) {
            return false;
        }
        this.theOwnerAttacker = lllIIlIlllllIlI.getAITarget();
        final int lllIIlIlllllIIl = lllIIlIlllllIlI.getRevengeTimer();
        return lllIIlIlllllIIl != this.timestamp && this.isSuitableTarget(this.theOwnerAttacker, false) && this.theDefendingTameable.shouldAttackEntity(this.theOwnerAttacker, lllIIlIlllllIlI);
    }
    
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.theOwnerAttacker);
        final EntityLivingBase lllIIlIllllIIlI = this.theDefendingTameable.getOwner();
        if (lllIIlIllllIIlI != null) {
            this.timestamp = lllIIlIllllIIlI.getRevengeTimer();
        }
        super.startExecuting();
    }
    
    public EntityAIOwnerHurtByTarget(final EntityTameable lllIIllIIIIIIIl) {
        super(lllIIllIIIIIIIl, false);
        this.theDefendingTameable = lllIIllIIIIIIIl;
        this.setMutexBits(1);
    }
}
