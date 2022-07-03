package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import java.util.*;

public class EntityAIFollowParent extends EntityAIBase
{
    /* synthetic */ EntityAnimal childAnimal;
    /* synthetic */ EntityAnimal parentAnimal;
    private /* synthetic */ int delayCounter;
    /* synthetic */ double moveSpeed;
    
    @Override
    public boolean continueExecuting() {
        if (this.childAnimal.getGrowingAge() >= 0) {
            return false;
        }
        if (!this.parentAnimal.isEntityAlive()) {
            return false;
        }
        final double lllllllllllllIIIIlIlllIIIIIIIIll = this.childAnimal.getDistanceSqToEntity(this.parentAnimal);
        return lllllllllllllIIIIlIlllIIIIIIIIll >= 9.0 && lllllllllllllIIIIlIlllIIIIIIIIll <= 256.0;
    }
    
    @Override
    public void updateTask() {
        final int delayCounter = this.delayCounter - 1;
        this.delayCounter = delayCounter;
        if (delayCounter <= 0) {
            this.delayCounter = 10;
            this.childAnimal.getNavigator().tryMoveToEntityLiving(this.parentAnimal, this.moveSpeed);
        }
    }
    
    public EntityAIFollowParent(final EntityAnimal lllllllllllllIIIIlIlllIIIIIlllII, final double lllllllllllllIIIIlIlllIIIIIllIll) {
        this.childAnimal = lllllllllllllIIIIlIlllIIIIIlllII;
        this.moveSpeed = lllllllllllllIIIIlIlllIIIIIllIll;
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.childAnimal.getGrowingAge() >= 0) {
            return false;
        }
        final List<EntityAnimal> lllllllllllllIIIIlIlllIIIIIlIIlI = this.childAnimal.world.getEntitiesWithinAABB(this.childAnimal.getClass(), this.childAnimal.getEntityBoundingBox().expand(8.0, 4.0, 8.0));
        EntityAnimal lllllllllllllIIIIlIlllIIIIIlIIIl = null;
        double lllllllllllllIIIIlIlllIIIIIlIIII = Double.MAX_VALUE;
        for (final EntityAnimal lllllllllllllIIIIlIlllIIIIIIllll : lllllllllllllIIIIlIlllIIIIIlIIlI) {
            if (lllllllllllllIIIIlIlllIIIIIIllll.getGrowingAge() >= 0) {
                final double lllllllllllllIIIIlIlllIIIIIIlllI = this.childAnimal.getDistanceSqToEntity(lllllllllllllIIIIlIlllIIIIIIllll);
                if (lllllllllllllIIIIlIlllIIIIIIlllI > lllllllllllllIIIIlIlllIIIIIlIIII) {
                    continue;
                }
                lllllllllllllIIIIlIlllIIIIIlIIII = lllllllllllllIIIIlIlllIIIIIIlllI;
                lllllllllllllIIIIlIlllIIIIIlIIIl = lllllllllllllIIIIlIlllIIIIIIllll;
            }
        }
        if (lllllllllllllIIIIlIlllIIIIIlIIIl == null) {
            return false;
        }
        if (lllllllllllllIIIIlIlllIIIIIlIIII < 9.0) {
            return false;
        }
        this.parentAnimal = lllllllllllllIIIIlIlllIIIIIlIIIl;
        return true;
    }
    
    @Override
    public void startExecuting() {
        this.delayCounter = 0;
    }
    
    @Override
    public void resetTask() {
        this.parentAnimal = null;
    }
}
