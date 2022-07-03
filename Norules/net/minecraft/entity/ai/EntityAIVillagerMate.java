package net.minecraft.entity.ai;

import net.minecraft.world.*;
import net.minecraft.entity.passive.*;
import net.minecraft.village.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class EntityAIVillagerMate extends EntityAIBase
{
    private /* synthetic */ int matingTimeout;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ EntityVillager villagerObj;
    private /* synthetic */ EntityVillager mate;
    /* synthetic */ Village villageObj;
    
    public EntityAIVillagerMate(final EntityVillager lllllllllllllIIlIIlIIllIIIIllIlI) {
        this.villagerObj = lllllllllllllIIlIIlIIllIIIIllIlI;
        this.worldObj = lllllllllllllIIlIIlIIllIIIIllIlI.world;
        this.setMutexBits(3);
    }
    
    @Override
    public void updateTask() {
        --this.matingTimeout;
        this.villagerObj.getLookHelper().setLookPositionWithEntity(this.mate, 10.0f, 30.0f);
        if (this.villagerObj.getDistanceSqToEntity(this.mate) > 2.25) {
            this.villagerObj.getNavigator().tryMoveToEntityLiving(this.mate, 0.25);
        }
        else if (this.matingTimeout == 0 && this.mate.isMating()) {
            this.giveBirth();
        }
        if (this.villagerObj.getRNG().nextInt(35) == 0) {
            this.worldObj.setEntityState(this.villagerObj, (byte)12);
        }
    }
    
    @Override
    public void startExecuting() {
        this.matingTimeout = 300;
        this.villagerObj.setMating(true);
    }
    
    private void giveBirth() {
        final EntityVillager lllllllllllllIIlIIlIIlIllllllllI = this.villagerObj.createChild(this.mate);
        this.mate.setGrowingAge(6000);
        this.villagerObj.setGrowingAge(6000);
        this.mate.setIsWillingToMate(false);
        this.villagerObj.setIsWillingToMate(false);
        lllllllllllllIIlIIlIIlIllllllllI.setGrowingAge(-24000);
        lllllllllllllIIlIIlIIlIllllllllI.setLocationAndAngles(this.villagerObj.posX, this.villagerObj.posY, this.villagerObj.posZ, 0.0f, 0.0f);
        this.worldObj.spawnEntityInWorld(lllllllllllllIIlIIlIIlIllllllllI);
        this.worldObj.setEntityState(lllllllllllllIIlIIlIIlIllllllllI, (byte)12);
    }
    
    @Override
    public boolean continueExecuting() {
        return this.matingTimeout >= 0 && this.checkSufficientDoorsPresentForNewVillager() && this.villagerObj.getGrowingAge() == 0 && this.villagerObj.getIsWillingToMate(false);
    }
    
    private boolean checkSufficientDoorsPresentForNewVillager() {
        if (!this.villageObj.isMatingSeason()) {
            return false;
        }
        final int lllllllllllllIIlIIlIIllIIIIIIlII = (int)((float)this.villageObj.getNumVillageDoors() * 0.35);
        return this.villageObj.getNumVillagers() < lllllllllllllIIlIIlIIllIIIIIIlII;
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.villagerObj.getGrowingAge() != 0) {
            return false;
        }
        if (this.villagerObj.getRNG().nextInt(500) != 0) {
            return false;
        }
        this.villageObj = this.worldObj.getVillageCollection().getNearestVillage(new BlockPos(this.villagerObj), 0);
        if (this.villageObj == null) {
            return false;
        }
        if (!this.checkSufficientDoorsPresentForNewVillager() || !this.villagerObj.getIsWillingToMate(true)) {
            return false;
        }
        final Entity lllllllllllllIIlIIlIIllIIIIlIllI = this.worldObj.findNearestEntityWithinAABB(EntityVillager.class, this.villagerObj.getEntityBoundingBox().expand(8.0, 3.0, 8.0), this.villagerObj);
        if (lllllllllllllIIlIIlIIllIIIIlIllI == null) {
            return false;
        }
        this.mate = (EntityVillager)lllllllllllllIIlIIlIIllIIIIlIllI;
        return this.mate.getGrowingAge() == 0 && this.mate.getIsWillingToMate(true);
    }
    
    @Override
    public void resetTask() {
        this.villageObj = null;
        this.mate = null;
        this.villagerObj.setMating(false);
    }
}
