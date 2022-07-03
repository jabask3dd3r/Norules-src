package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class EntityAISit extends EntityAIBase
{
    private /* synthetic */ boolean isSitting;
    private final /* synthetic */ EntityTameable theEntity;
    
    @Override
    public void resetTask() {
        this.theEntity.setSitting(false);
    }
    
    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().clearPathEntity();
        this.theEntity.setSitting(true);
    }
    
    public void setSitting(final boolean lllllllllllllIllllllIIlIIIllIIII) {
        this.isSitting = lllllllllllllIllllllIIlIIIllIIII;
    }
    
    public EntityAISit(final EntityTameable lllllllllllllIllllllIIlIIlIIIIII) {
        this.theEntity = lllllllllllllIllllllIIlIIlIIIIII;
        this.setMutexBits(5);
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theEntity.isTamed()) {
            return false;
        }
        if (this.theEntity.isInWater()) {
            return false;
        }
        if (!this.theEntity.onGround) {
            return false;
        }
        final EntityLivingBase lllllllllllllIllllllIIlIIIllllII = this.theEntity.getOwner();
        return lllllllllllllIllllllIIlIIIllllII == null || ((this.theEntity.getDistanceSqToEntity(lllllllllllllIllllllIIlIIIllllII) >= 144.0 || lllllllllllllIllllllIIlIIIllllII.getAITarget() == null) && this.isSitting);
    }
}
