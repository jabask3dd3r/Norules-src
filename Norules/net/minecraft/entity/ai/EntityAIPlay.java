package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.math.*;

public class EntityAIPlay extends EntityAIBase
{
    private /* synthetic */ int playTime;
    private final /* synthetic */ double speed;
    private /* synthetic */ EntityLivingBase targetVillager;
    private final /* synthetic */ EntityVillager villagerObj;
    
    @Override
    public boolean shouldExecute() {
        if (this.villagerObj.getGrowingAge() >= 0) {
            return false;
        }
        if (this.villagerObj.getRNG().nextInt(400) != 0) {
            return false;
        }
        final List<EntityVillager> lllllllllllllIIllIlIIlIllllIlIll = this.villagerObj.world.getEntitiesWithinAABB((Class<? extends EntityVillager>)EntityVillager.class, this.villagerObj.getEntityBoundingBox().expand(6.0, 3.0, 6.0));
        double lllllllllllllIIllIlIIlIllllIlIlI = Double.MAX_VALUE;
        for (final EntityVillager lllllllllllllIIllIlIIlIllllIlIIl : lllllllllllllIIllIlIIlIllllIlIll) {
            if (lllllllllllllIIllIlIIlIllllIlIIl != this.villagerObj && !lllllllllllllIIllIlIIlIllllIlIIl.isPlaying() && lllllllllllllIIllIlIIlIllllIlIIl.getGrowingAge() < 0) {
                final double lllllllllllllIIllIlIIlIllllIlIII = lllllllllllllIIllIlIIlIllllIlIIl.getDistanceSqToEntity(this.villagerObj);
                if (lllllllllllllIIllIlIIlIllllIlIII > lllllllllllllIIllIlIIlIllllIlIlI) {
                    continue;
                }
                lllllllllllllIIllIlIIlIllllIlIlI = lllllllllllllIIllIlIIlIllllIlIII;
                this.targetVillager = lllllllllllllIIllIlIIlIllllIlIIl;
            }
        }
        if (this.targetVillager == null) {
            final Vec3d lllllllllllllIIllIlIIlIllllIIlll = RandomPositionGenerator.findRandomTarget(this.villagerObj, 16, 3);
            if (lllllllllllllIIllIlIIlIllllIIlll == null) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void updateTask() {
        --this.playTime;
        if (this.targetVillager != null) {
            if (this.villagerObj.getDistanceSqToEntity(this.targetVillager) > 4.0) {
                this.villagerObj.getNavigator().tryMoveToEntityLiving(this.targetVillager, this.speed);
            }
        }
        else if (this.villagerObj.getNavigator().noPath()) {
            final Vec3d lllllllllllllIIllIlIIlIlllIlIlII = RandomPositionGenerator.findRandomTarget(this.villagerObj, 16, 3);
            if (lllllllllllllIIllIlIIlIlllIlIlII == null) {
                return;
            }
            this.villagerObj.getNavigator().tryMoveToXYZ(lllllllllllllIIllIlIIlIlllIlIlII.xCoord, lllllllllllllIIllIlIIlIlllIlIlII.yCoord, lllllllllllllIIllIlIIlIlllIlIlII.zCoord, this.speed);
        }
    }
    
    public EntityAIPlay(final EntityVillager lllllllllllllIIllIlIIlIlllllIlII, final double lllllllllllllIIllIlIIlIlllllIllI) {
        this.villagerObj = lllllllllllllIIllIlIIlIlllllIlII;
        this.speed = lllllllllllllIIllIlIIlIlllllIllI;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean continueExecuting() {
        return this.playTime > 0;
    }
    
    @Override
    public void resetTask() {
        this.villagerObj.setPlaying(false);
        this.targetVillager = null;
    }
    
    @Override
    public void startExecuting() {
        if (this.targetVillager != null) {
            this.villagerObj.setPlaying(true);
        }
        this.playTime = 1000;
    }
}
