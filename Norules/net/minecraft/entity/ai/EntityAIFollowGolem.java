package net.minecraft.entity.ai;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import java.util.*;

public class EntityAIFollowGolem extends EntityAIBase
{
    private /* synthetic */ EntityIronGolem theGolem;
    private final /* synthetic */ EntityVillager theVillager;
    private /* synthetic */ boolean tookGolemRose;
    private /* synthetic */ int takeGolemRoseTick;
    
    @Override
    public void updateTask() {
        this.theVillager.getLookHelper().setLookPositionWithEntity(this.theGolem, 30.0f, 30.0f);
        if (this.theGolem.getHoldRoseTick() == this.takeGolemRoseTick) {
            this.theVillager.getNavigator().tryMoveToEntityLiving(this.theGolem, 0.5);
            this.tookGolemRose = true;
        }
        if (this.tookGolemRose && this.theVillager.getDistanceSqToEntity(this.theGolem) < 4.0) {
            this.theGolem.setHoldingRose(false);
            this.theVillager.getNavigator().clearPathEntity();
        }
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.theVillager.getGrowingAge() >= 0) {
            return false;
        }
        if (!this.theVillager.world.isDaytime()) {
            return false;
        }
        final List<EntityIronGolem> lllllllllllllIllIIllIIlIIlIIIlll = this.theVillager.world.getEntitiesWithinAABB((Class<? extends EntityIronGolem>)EntityIronGolem.class, this.theVillager.getEntityBoundingBox().expand(6.0, 2.0, 6.0));
        if (lllllllllllllIllIIllIIlIIlIIIlll.isEmpty()) {
            return false;
        }
        for (final EntityIronGolem lllllllllllllIllIIllIIlIIlIIIllI : lllllllllllllIllIIllIIlIIlIIIlll) {
            if (lllllllllllllIllIIllIIlIIlIIIllI.getHoldRoseTick() > 0) {
                this.theGolem = lllllllllllllIllIIllIIlIIlIIIllI;
                break;
            }
        }
        return this.theGolem != null;
    }
    
    @Override
    public void startExecuting() {
        this.takeGolemRoseTick = this.theVillager.getRNG().nextInt(320);
        this.tookGolemRose = false;
        this.theGolem.getNavigator().clearPathEntity();
    }
    
    @Override
    public void resetTask() {
        this.theGolem = null;
        this.theVillager.getNavigator().clearPathEntity();
    }
    
    public EntityAIFollowGolem(final EntityVillager lllllllllllllIllIIllIIlIIlIIllll) {
        this.theVillager = lllllllllllllIllIIllIIlIIlIIllll;
        this.setMutexBits(3);
    }
    
    @Override
    public boolean continueExecuting() {
        return this.theGolem.getHoldRoseTick() > 0;
    }
}
