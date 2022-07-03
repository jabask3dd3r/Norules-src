package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class EntityAIOwnerHurtTarget extends EntityAITarget
{
    private /* synthetic */ int timestamp;
    /* synthetic */ EntityTameable theEntityTameable;
    /* synthetic */ EntityLivingBase theTarget;
    
    public EntityAIOwnerHurtTarget(final EntityTameable lllllllllllllIlIIlllllIllIIlIlll) {
        super(lllllllllllllIlIIlllllIllIIlIlll, false);
        this.theEntityTameable = lllllllllllllIlIIlllllIllIIlIlll;
        this.setMutexBits(1);
    }
    
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.theTarget);
        final EntityLivingBase lllllllllllllIlIIlllllIllIIIlIII = this.theEntityTameable.getOwner();
        if (lllllllllllllIlIIlllllIllIIIlIII != null) {
            this.timestamp = lllllllllllllIlIIlllllIllIIIlIII.getLastAttackerTime();
        }
        super.startExecuting();
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theEntityTameable.isTamed()) {
            return false;
        }
        final EntityLivingBase lllllllllllllIlIIlllllIllIIlIIII = this.theEntityTameable.getOwner();
        if (lllllllllllllIlIIlllllIllIIlIIII == null) {
            return false;
        }
        this.theTarget = lllllllllllllIlIIlllllIllIIlIIII.getLastAttacker();
        final int lllllllllllllIlIIlllllIllIIIllll = lllllllllllllIlIIlllllIllIIlIIII.getLastAttackerTime();
        return lllllllllllllIlIIlllllIllIIIllll != this.timestamp && this.isSuitableTarget(this.theTarget, false) && this.theEntityTameable.shouldAttackEntity(this.theTarget, lllllllllllllIlIIlllllIllIIlIIII);
    }
}
