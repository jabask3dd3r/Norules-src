package net.minecraft.entity.ai;

import net.minecraft.entity.monster.*;
import net.minecraft.village.*;
import net.minecraft.entity.*;

public class EntityAIDefendVillage extends EntityAITarget
{
    /* synthetic */ EntityIronGolem irongolem;
    /* synthetic */ EntityLivingBase villageAgressorTarget;
    
    @Override
    public void startExecuting() {
        this.irongolem.setAttackTarget(this.villageAgressorTarget);
        super.startExecuting();
    }
    
    @Override
    public boolean shouldExecute() {
        final Village lllllllllllllllllIlIlIlIIIlIIlIl = this.irongolem.getVillage();
        if (lllllllllllllllllIlIlIlIIIlIIlIl == null) {
            return false;
        }
        this.villageAgressorTarget = lllllllllllllllllIlIlIlIIIlIIlIl.findNearestVillageAggressor(this.irongolem);
        if (this.villageAgressorTarget instanceof EntityCreeper) {
            return false;
        }
        if (this.isSuitableTarget(this.villageAgressorTarget, false)) {
            return true;
        }
        if (this.taskOwner.getRNG().nextInt(20) == 0) {
            this.villageAgressorTarget = lllllllllllllllllIlIlIlIIIlIIlIl.getNearestTargetPlayer(this.irongolem);
            return this.isSuitableTarget(this.villageAgressorTarget, false);
        }
        return false;
    }
    
    public EntityAIDefendVillage(final EntityIronGolem lllllllllllllllllIlIlIlIIIlIlIIl) {
        super(lllllllllllllllllIlIlIlIIIlIlIIl, false, true);
        this.irongolem = lllllllllllllllllIlIlIlIIIlIlIIl;
        this.setMutexBits(1);
    }
}
