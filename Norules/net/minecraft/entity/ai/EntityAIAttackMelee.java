package net.minecraft.entity.ai;

import net.minecraft.pathfinding.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;

public class EntityAIAttackMelee extends EntityAIBase
{
    /* synthetic */ boolean longMemory;
    /* synthetic */ double speedTowardsTarget;
    private /* synthetic */ double targetY;
    protected /* synthetic */ int attackTick;
    protected /* synthetic */ EntityCreature attacker;
    private /* synthetic */ double targetZ;
    /* synthetic */ Path entityPathEntity;
    private /* synthetic */ int delayCounter;
    /* synthetic */ World worldObj;
    private /* synthetic */ double targetX;
    
    @Override
    public void updateTask() {
        final EntityLivingBase lllllllllllllllIIlIlllIIlIIlIlIl = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity(lllllllllllllllIIlIlllIIlIIlIlIl, 30.0f, 30.0f);
        final double lllllllllllllllIIlIlllIIlIIlIlII = this.attacker.getDistanceSq(lllllllllllllllIIlIlllIIlIIlIlIl.posX, lllllllllllllllIIlIlllIIlIIlIlIl.getEntityBoundingBox().minY, lllllllllllllllIIlIlllIIlIIlIlIl.posZ);
        --this.delayCounter;
        if ((this.longMemory || this.attacker.getEntitySenses().canSee(lllllllllllllllIIlIlllIIlIIlIlIl)) && this.delayCounter <= 0 && ((this.targetX == 0.0 && this.targetY == 0.0 && this.targetZ == 0.0) || lllllllllllllllIIlIlllIIlIIlIlIl.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0 || this.attacker.getRNG().nextFloat() < 0.05f)) {
            this.targetX = lllllllllllllllIIlIlllIIlIIlIlIl.posX;
            this.targetY = lllllllllllllllIIlIlllIIlIIlIlIl.getEntityBoundingBox().minY;
            this.targetZ = lllllllllllllllIIlIlllIIlIIlIlIl.posZ;
            this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);
            if (lllllllllllllllIIlIlllIIlIIlIlII > 1024.0) {
                this.delayCounter += 10;
            }
            else if (lllllllllllllllIIlIlllIIlIIlIlII > 256.0) {
                this.delayCounter += 5;
            }
            if (!this.attacker.getNavigator().tryMoveToEntityLiving(lllllllllllllllIIlIlllIIlIIlIlIl, this.speedTowardsTarget)) {
                this.delayCounter += 15;
            }
        }
        this.attackTick = Math.max(this.attackTick - 1, 0);
        this.checkAndPerformAttack(lllllllllllllllIIlIlllIIlIIlIlIl, lllllllllllllllIIlIlllIIlIIlIlII);
    }
    
    @Override
    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
        this.delayCounter = 0;
    }
    
    protected double getAttackReachSqr(final EntityLivingBase lllllllllllllllIIlIlllIIIlllllll) {
        return this.attacker.width * 2.0f * this.attacker.width * 2.0f + lllllllllllllllIIlIlllIIIlllllll.width;
    }
    
    protected void checkAndPerformAttack(final EntityLivingBase lllllllllllllllIIlIlllIIlIIIIlll, final double lllllllllllllllIIlIlllIIlIIIlIlI) {
        final double lllllllllllllllIIlIlllIIlIIIlIIl = this.getAttackReachSqr(lllllllllllllllIIlIlllIIlIIIIlll);
        if (lllllllllllllllIIlIlllIIlIIIlIlI <= lllllllllllllllIIlIlllIIlIIIlIIl && this.attackTick <= 0) {
            this.attackTick = 20;
            this.attacker.swingArm(EnumHand.MAIN_HAND);
            this.attacker.attackEntityAsMob(lllllllllllllllIIlIlllIIlIIIIlll);
        }
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase lllllllllllllllIIlIlllIIlIlIlIll = this.attacker.getAttackTarget();
        if (lllllllllllllllIIlIlllIIlIlIlIll == null) {
            return false;
        }
        if (!lllllllllllllllIIlIlllIIlIlIlIll.isEntityAlive()) {
            return false;
        }
        this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(lllllllllllllllIIlIlllIIlIlIlIll);
        return this.entityPathEntity != null || this.getAttackReachSqr(lllllllllllllllIIlIlllIIlIlIlIll) >= this.attacker.getDistanceSq(lllllllllllllllIIlIlllIIlIlIlIll.posX, lllllllllllllllIIlIlllIIlIlIlIll.getEntityBoundingBox().minY, lllllllllllllllIIlIlllIIlIlIlIll.posZ);
    }
    
    @Override
    public void resetTask() {
        final EntityLivingBase lllllllllllllllIIlIlllIIlIIlllII = this.attacker.getAttackTarget();
        if (lllllllllllllllIIlIlllIIlIIlllII instanceof EntityPlayer && (((EntityPlayer)lllllllllllllllIIlIlllIIlIIlllII).isSpectator() || ((EntityPlayer)lllllllllllllllIIlIlllIIlIIlllII).isCreative())) {
            this.attacker.setAttackTarget(null);
        }
        this.attacker.getNavigator().clearPathEntity();
    }
    
    @Override
    public boolean continueExecuting() {
        final EntityLivingBase lllllllllllllllIIlIlllIIlIlIIlIl = this.attacker.getAttackTarget();
        if (lllllllllllllllIIlIlllIIlIlIIlIl == null) {
            return false;
        }
        if (!lllllllllllllllIIlIlllIIlIlIIlIl.isEntityAlive()) {
            return false;
        }
        if (!this.longMemory) {
            return !this.attacker.getNavigator().noPath();
        }
        return this.attacker.isWithinHomeDistanceFromPosition(new BlockPos(lllllllllllllllIIlIlllIIlIlIIlIl)) && (!(lllllllllllllllIIlIlllIIlIlIIlIl instanceof EntityPlayer) || (!((EntityPlayer)lllllllllllllllIIlIlllIIlIlIIlIl).isSpectator() && !((EntityPlayer)lllllllllllllllIIlIlllIIlIlIIlIl).isCreative()));
    }
    
    public EntityAIAttackMelee(final EntityCreature lllllllllllllllIIlIlllIIlIllIIIl, final double lllllllllllllllIIlIlllIIlIllIlII, final boolean lllllllllllllllIIlIlllIIlIlIllll) {
        this.attacker = lllllllllllllllIIlIlllIIlIllIIIl;
        this.worldObj = lllllllllllllllIIlIlllIIlIllIIIl.world;
        this.speedTowardsTarget = lllllllllllllllIIlIlllIIlIllIlII;
        this.longMemory = lllllllllllllllIIlIlllIIlIlIllll;
        this.setMutexBits(3);
    }
}
