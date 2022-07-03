package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class EntityAIAttackRanged extends EntityAIBase
{
    private /* synthetic */ EntityLivingBase attackTarget;
    private final /* synthetic */ int attackIntervalMin;
    private final /* synthetic */ float attackRadius;
    private /* synthetic */ int rangedAttackTime;
    private final /* synthetic */ double entityMoveSpeed;
    private /* synthetic */ int seeTime;
    private final /* synthetic */ EntityLiving entityHost;
    private final /* synthetic */ IRangedAttackMob rangedAttackEntityHost;
    private final /* synthetic */ float maxAttackDistance;
    private final /* synthetic */ int maxRangedAttackTime;
    
    @Override
    public boolean continueExecuting() {
        return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase lllllllllllllllllIIIllIIIIlIIIll = this.entityHost.getAttackTarget();
        if (lllllllllllllllllIIIllIIIIlIIIll == null) {
            return false;
        }
        this.attackTarget = lllllllllllllllllIIIllIIIIlIIIll;
        return true;
    }
    
    public EntityAIAttackRanged(final IRangedAttackMob lllllllllllllllllIIIllIIIlIllllI, final double lllllllllllllllllIIIllIIIlIlllIl, final int lllllllllllllllllIIIllIIIlIllIll, final float lllllllllllllllllIIIllIIIlIllIIl) {
        this(lllllllllllllllllIIIllIIIlIllllI, lllllllllllllllllIIIllIIIlIlllIl, lllllllllllllllllIIIllIIIlIllIll, lllllllllllllllllIIIllIIIlIllIll, lllllllllllllllllIIIllIIIlIllIIl);
    }
    
    @Override
    public void resetTask() {
        this.attackTarget = null;
        this.seeTime = 0;
        this.rangedAttackTime = -1;
    }
    
    @Override
    public void updateTask() {
        final double lllllllllllllllllIIIllIIIIIIIIII = this.entityHost.getDistanceSq(this.attackTarget.posX, this.attackTarget.getEntityBoundingBox().minY, this.attackTarget.posZ);
        final boolean lllllllllllllllllIIIlIllllllllll = this.entityHost.getEntitySenses().canSee(this.attackTarget);
        if (lllllllllllllllllIIIlIllllllllll) {
            ++this.seeTime;
        }
        else {
            this.seeTime = 0;
        }
        if (lllllllllllllllllIIIllIIIIIIIIII <= this.maxAttackDistance && this.seeTime >= 20) {
            this.entityHost.getNavigator().clearPathEntity();
        }
        else {
            this.entityHost.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
        }
        this.entityHost.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30.0f, 30.0f);
        final int rangedAttackTime = this.rangedAttackTime - 1;
        this.rangedAttackTime = rangedAttackTime;
        if (rangedAttackTime == 0) {
            if (!lllllllllllllllllIIIlIllllllllll) {
                return;
            }
            final float lllllllllllllllllIIIlIlllllllllI = MathHelper.sqrt(lllllllllllllllllIIIllIIIIIIIIII) / this.attackRadius;
            final float lllllllllllllllllIIIlIllllllllIl = MathHelper.clamp(lllllllllllllllllIIIlIlllllllllI, 0.1f, 1.0f);
            this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, lllllllllllllllllIIIlIllllllllIl);
            this.rangedAttackTime = MathHelper.floor(lllllllllllllllllIIIlIlllllllllI * (this.maxRangedAttackTime - this.attackIntervalMin) + this.attackIntervalMin);
        }
        else if (this.rangedAttackTime < 0) {
            final float lllllllllllllllllIIIlIllllllllII = MathHelper.sqrt(lllllllllllllllllIIIllIIIIIIIIII) / this.attackRadius;
            this.rangedAttackTime = MathHelper.floor(lllllllllllllllllIIIlIllllllllII * (this.maxRangedAttackTime - this.attackIntervalMin) + this.attackIntervalMin);
        }
    }
    
    public EntityAIAttackRanged(final IRangedAttackMob lllllllllllllllllIIIllIIIIlllIlI, final double lllllllllllllllllIIIllIIIIllIIll, final int lllllllllllllllllIIIllIIIIlllIII, final int lllllllllllllllllIIIllIIIIlIllll, final float lllllllllllllllllIIIllIIIIlIllIl) {
        this.rangedAttackTime = -1;
        if (!(lllllllllllllllllIIIllIIIIlllIlI instanceof EntityLivingBase)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }
        this.rangedAttackEntityHost = lllllllllllllllllIIIllIIIIlllIlI;
        this.entityHost = (EntityLiving)lllllllllllllllllIIIllIIIIlllIlI;
        this.entityMoveSpeed = lllllllllllllllllIIIllIIIIllIIll;
        this.attackIntervalMin = lllllllllllllllllIIIllIIIIlllIII;
        this.maxRangedAttackTime = lllllllllllllllllIIIllIIIIlIllll;
        this.attackRadius = lllllllllllllllllIIIllIIIIlIllIl;
        this.maxAttackDistance = lllllllllllllllllIIIllIIIIlIllIl * lllllllllllllllllIIIllIIIIlIllIl;
        this.setMutexBits(3);
    }
}
