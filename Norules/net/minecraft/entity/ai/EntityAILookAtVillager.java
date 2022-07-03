package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;

public class EntityAILookAtVillager extends EntityAIBase
{
    private /* synthetic */ int lookTime;
    private /* synthetic */ EntityVillager theVillager;
    private final /* synthetic */ EntityIronGolem theGolem;
    
    @Override
    public boolean shouldExecute() {
        if (!this.theGolem.world.isDaytime()) {
            return false;
        }
        if (this.theGolem.getRNG().nextInt(8000) != 0) {
            return false;
        }
        this.theVillager = this.theGolem.world.findNearestEntityWithinAABB(EntityVillager.class, this.theGolem.getEntityBoundingBox().expand(6.0, 2.0, 6.0), (EntityVillager)this.theGolem);
        return this.theVillager != null;
    }
    
    @Override
    public void updateTask() {
        this.theGolem.getLookHelper().setLookPositionWithEntity(this.theVillager, 30.0f, 30.0f);
        --this.lookTime;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.lookTime > 0;
    }
    
    public EntityAILookAtVillager(final EntityIronGolem lllllllllllllIIlIIllIlIlIllllIll) {
        this.theGolem = lllllllllllllIIlIIllIlIlIllllIll;
        this.setMutexBits(3);
    }
    
    @Override
    public void resetTask() {
        this.theGolem.setHoldingRose(false);
        this.theVillager = null;
    }
    
    @Override
    public void startExecuting() {
        this.lookTime = 400;
        this.theGolem.setHoldingRose(true);
    }
}
