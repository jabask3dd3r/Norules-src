package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;

public class EntityAITradePlayer extends EntityAIBase
{
    private final /* synthetic */ EntityVillager villager;
    
    public EntityAITradePlayer(final EntityVillager lllllllllllllIlIllIIlIlIlIlIIIII) {
        this.villager = lllllllllllllIlIllIIlIlIlIlIIIII;
        this.setMutexBits(5);
    }
    
    @Override
    public void startExecuting() {
        this.villager.getNavigator().clearPathEntity();
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.villager.isEntityAlive()) {
            return false;
        }
        if (this.villager.isInWater()) {
            return false;
        }
        if (!this.villager.onGround) {
            return false;
        }
        if (this.villager.velocityChanged) {
            return false;
        }
        final EntityPlayer lllllllllllllIlIllIIlIlIlIIlllII = this.villager.getCustomer();
        return lllllllllllllIlIllIIlIlIlIIlllII != null && this.villager.getDistanceSqToEntity(lllllllllllllIlIllIIlIlIlIIlllII) <= 16.0 && lllllllllllllIlIllIIlIlIlIIlllII.openContainer != null;
    }
    
    @Override
    public void resetTask() {
        this.villager.setCustomer(null);
    }
}
