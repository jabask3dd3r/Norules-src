package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import com.google.common.base.*;

public class EntityAIWatchClosest extends EntityAIBase
{
    protected /* synthetic */ float maxDistanceForPlayer;
    protected /* synthetic */ EntityLiving theWatcher;
    private final /* synthetic */ float chance;
    protected /* synthetic */ Class<? extends Entity> watchedClass;
    protected /* synthetic */ Entity closestEntity;
    private /* synthetic */ int lookTime;
    
    @Override
    public void startExecuting() {
        this.lookTime = 40 + this.theWatcher.getRNG().nextInt(40);
    }
    
    @Override
    public boolean continueExecuting() {
        return this.closestEntity.isEntityAlive() && this.theWatcher.getDistanceSqToEntity(this.closestEntity) <= this.maxDistanceForPlayer * this.maxDistanceForPlayer && this.lookTime > 0;
    }
    
    @Override
    public void updateTask() {
        this.theWatcher.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + this.closestEntity.getEyeHeight(), this.closestEntity.posZ, (float)this.theWatcher.getHorizontalFaceSpeed(), (float)this.theWatcher.getVerticalFaceSpeed());
        --this.lookTime;
    }
    
    @Override
    public void resetTask() {
        this.closestEntity = null;
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.theWatcher.getRNG().nextFloat() >= this.chance) {
            return false;
        }
        if (this.theWatcher.getAttackTarget() != null) {
            this.closestEntity = this.theWatcher.getAttackTarget();
        }
        if (this.watchedClass == EntityPlayer.class) {
            this.closestEntity = this.theWatcher.world.func_190525_a(this.theWatcher.posX, this.theWatcher.posY, this.theWatcher.posZ, this.maxDistanceForPlayer, (Predicate<Entity>)Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, (Predicate)EntitySelectors.func_191324_b(this.theWatcher)));
        }
        else {
            this.closestEntity = this.theWatcher.world.findNearestEntityWithinAABB((Class<? extends EntityLiving>)this.watchedClass, this.theWatcher.getEntityBoundingBox().expand(this.maxDistanceForPlayer, 3.0, this.maxDistanceForPlayer), this.theWatcher);
        }
        return this.closestEntity != null;
    }
    
    public EntityAIWatchClosest(final EntityLiving lllllllllllllllllIIIIIIlIIIIIIIl, final Class<? extends Entity> lllllllllllllllllIIIIIIIlllllIll, final float lllllllllllllllllIIIIIIIlllllIlI, final float lllllllllllllllllIIIIIIIlllllllI) {
        this.theWatcher = lllllllllllllllllIIIIIIlIIIIIIIl;
        this.watchedClass = lllllllllllllllllIIIIIIIlllllIll;
        this.maxDistanceForPlayer = lllllllllllllllllIIIIIIIlllllIlI;
        this.chance = lllllllllllllllllIIIIIIIlllllllI;
        this.setMutexBits(2);
    }
    
    public EntityAIWatchClosest(final EntityLiving lllllllllllllllllIIIIIIlIIIIlIlI, final Class<? extends Entity> lllllllllllllllllIIIIIIlIIIIlIIl, final float lllllllllllllllllIIIIIIlIIIIlIII) {
        this.theWatcher = lllllllllllllllllIIIIIIlIIIIlIlI;
        this.watchedClass = lllllllllllllllllIIIIIIlIIIIlIIl;
        this.maxDistanceForPlayer = lllllllllllllllllIIIIIIlIIIIlIII;
        this.chance = 0.02f;
        this.setMutexBits(2);
    }
}
