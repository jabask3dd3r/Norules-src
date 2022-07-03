package net.minecraft.entity.ai;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityAIAttackRangedBow<T extends EntityMob> extends EntityAIBase
{
    private final /* synthetic */ T entity;
    private final /* synthetic */ float maxAttackDistance;
    private /* synthetic */ boolean strafingBackwards;
    private /* synthetic */ int attackTime;
    private /* synthetic */ int seeTime;
    private /* synthetic */ boolean strafingClockwise;
    private /* synthetic */ int attackCooldown;
    private /* synthetic */ int strafingTime;
    private final /* synthetic */ double moveSpeedAmp;
    
    @Override
    public boolean shouldExecute() {
        return ((EntityLiving)this.entity).getAttackTarget() != null && this.isBowInMainhand();
    }
    
    public EntityAIAttackRangedBow(final T llllllllllllllIlIIIlIIlIllIIllII, final double llllllllllllllIlIIIlIIlIllIIlIll, final int llllllllllllllIlIIIlIIlIllIIIlIl, final float llllllllllllllIlIIIlIIlIllIIIlII) {
        this.attackTime = -1;
        this.strafingTime = -1;
        this.entity = llllllllllllllIlIIIlIIlIllIIllII;
        this.moveSpeedAmp = llllllllllllllIlIIIlIIlIllIIlIll;
        this.attackCooldown = llllllllllllllIlIIIlIIlIllIIIlIl;
        this.maxAttackDistance = llllllllllllllIlIIIlIIlIllIIIlII * llllllllllllllIlIIIlIIlIllIIIlII;
        this.setMutexBits(3);
    }
    
    @Override
    public boolean continueExecuting() {
        return (this.shouldExecute() || !((EntityLiving)this.entity).getNavigator().noPath()) && this.isBowInMainhand();
    }
    
    protected boolean isBowInMainhand() {
        return !((EntityLivingBase)this.entity).getHeldItemMainhand().func_190926_b() && ((EntityLivingBase)this.entity).getHeldItemMainhand().getItem() == Items.BOW;
    }
    
    public void setAttackCooldown(final int llllllllllllllIlIIIlIIlIlIlllllI) {
        this.attackCooldown = llllllllllllllIlIIIlIIlIlIlllllI;
    }
    
    @Override
    public void updateTask() {
        final EntityLivingBase llllllllllllllIlIIIlIIlIlIlIIlll = ((EntityLiving)this.entity).getAttackTarget();
        if (llllllllllllllIlIIIlIIlIlIlIIlll != null) {
            final double llllllllllllllIlIIIlIIlIlIlIIllI = ((Entity)this.entity).getDistanceSq(llllllllllllllIlIIIlIIlIlIlIIlll.posX, llllllllllllllIlIIIlIIlIlIlIIlll.getEntityBoundingBox().minY, llllllllllllllIlIIIlIIlIlIlIIlll.posZ);
            final boolean llllllllllllllIlIIIlIIlIlIlIIlIl = ((EntityLiving)this.entity).getEntitySenses().canSee(llllllllllllllIlIIIlIIlIlIlIIlll);
            final boolean llllllllllllllIlIIIlIIlIlIlIIlII = this.seeTime > 0;
            if (llllllllllllllIlIIIlIIlIlIlIIlIl != llllllllllllllIlIIIlIIlIlIlIIlII) {
                this.seeTime = 0;
            }
            if (llllllllllllllIlIIIlIIlIlIlIIlIl) {
                ++this.seeTime;
            }
            else {
                --this.seeTime;
            }
            if (llllllllllllllIlIIIlIIlIlIlIIllI <= this.maxAttackDistance && this.seeTime >= 20) {
                ((EntityLiving)this.entity).getNavigator().clearPathEntity();
                ++this.strafingTime;
            }
            else {
                ((EntityLiving)this.entity).getNavigator().tryMoveToEntityLiving(llllllllllllllIlIIIlIIlIlIlIIlll, this.moveSpeedAmp);
                this.strafingTime = -1;
            }
            if (this.strafingTime >= 20) {
                if (((EntityLivingBase)this.entity).getRNG().nextFloat() < 0.3) {
                    this.strafingClockwise = !this.strafingClockwise;
                }
                if (((EntityLivingBase)this.entity).getRNG().nextFloat() < 0.3) {
                    this.strafingBackwards = !this.strafingBackwards;
                }
                this.strafingTime = 0;
            }
            if (this.strafingTime > -1) {
                if (llllllllllllllIlIIIlIIlIlIlIIllI > this.maxAttackDistance * 0.75f) {
                    this.strafingBackwards = false;
                }
                else if (llllllllllllllIlIIIlIIlIlIlIIllI < this.maxAttackDistance * 0.25f) {
                    this.strafingBackwards = true;
                }
                ((EntityLiving)this.entity).getMoveHelper().strafe(this.strafingBackwards ? -0.5f : 0.5f, this.strafingClockwise ? 0.5f : -0.5f);
                ((EntityLiving)this.entity).faceEntity(llllllllllllllIlIIIlIIlIlIlIIlll, 30.0f, 30.0f);
            }
            else {
                ((EntityLiving)this.entity).getLookHelper().setLookPositionWithEntity(llllllllllllllIlIIIlIIlIlIlIIlll, 30.0f, 30.0f);
            }
            if (((EntityLivingBase)this.entity).isHandActive()) {
                if (!llllllllllllllIlIIIlIIlIlIlIIlIl && this.seeTime < -60) {
                    ((EntityLivingBase)this.entity).resetActiveHand();
                }
                else if (llllllllllllllIlIIIlIIlIlIlIIlIl) {
                    final int llllllllllllllIlIIIlIIlIlIlIIIll = ((EntityLivingBase)this.entity).getItemInUseMaxCount();
                    if (llllllllllllllIlIIIlIIlIlIlIIIll >= 20) {
                        ((EntityLivingBase)this.entity).resetActiveHand();
                        ((IRangedAttackMob)this.entity).attackEntityWithRangedAttack(llllllllllllllIlIIIlIIlIlIlIIlll, ItemBow.getArrowVelocity(llllllllllllllIlIIIlIIlIlIlIIIll));
                        this.attackTime = this.attackCooldown;
                    }
                }
            }
            else {
                final int attackTime = this.attackTime - 1;
                this.attackTime = attackTime;
                if (attackTime <= 0 && this.seeTime >= -60) {
                    ((EntityLivingBase)this.entity).setActiveHand(EnumHand.MAIN_HAND);
                }
            }
        }
    }
    
    @Override
    public void startExecuting() {
        super.startExecuting();
        ((IRangedAttackMob)this.entity).setSwingingArms(true);
    }
    
    @Override
    public void resetTask() {
        super.resetTask();
        ((IRangedAttackMob)this.entity).setSwingingArms(false);
        this.seeTime = 0;
        this.attackTime = -1;
        ((EntityLivingBase)this.entity).resetActiveHand();
    }
}
