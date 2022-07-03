package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class EntityAIMoveTowardsTarget extends EntityAIBase
{
    private /* synthetic */ double movePosZ;
    private /* synthetic */ EntityLivingBase targetEntity;
    private final /* synthetic */ double speed;
    private final /* synthetic */ EntityCreature theEntity;
    private /* synthetic */ double movePosX;
    private final /* synthetic */ float maxTargetDistance;
    private /* synthetic */ double movePosY;
    
    public EntityAIMoveTowardsTarget(final EntityCreature lllllllllllllIlIlllIlIIIllIlllII, final double lllllllllllllIlIlllIlIIIllIlllll, final float lllllllllllllIlIlllIlIIIllIllllI) {
        this.theEntity = lllllllllllllIlIlllIlIIIllIlllII;
        this.speed = lllllllllllllIlIlllIlIIIllIlllll;
        this.maxTargetDistance = lllllllllllllIlIlllIlIIIllIllllI;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.theEntity.getNavigator().noPath() && this.targetEntity.isEntityAlive() && this.targetEntity.getDistanceSqToEntity(this.theEntity) < this.maxTargetDistance * this.maxTargetDistance;
    }
    
    @Override
    public boolean shouldExecute() {
        this.targetEntity = this.theEntity.getAttackTarget();
        if (this.targetEntity == null) {
            return false;
        }
        if (this.targetEntity.getDistanceSqToEntity(this.theEntity) > this.maxTargetDistance * this.maxTargetDistance) {
            return false;
        }
        final Vec3d lllllllllllllIlIlllIlIIIllIlIllI = RandomPositionGenerator.findRandomTargetBlockTowards(this.theEntity, 16, 7, new Vec3d(this.targetEntity.posX, this.targetEntity.posY, this.targetEntity.posZ));
        if (lllllllllllllIlIlllIlIIIllIlIllI == null) {
            return false;
        }
        this.movePosX = lllllllllllllIlIlllIlIIIllIlIllI.xCoord;
        this.movePosY = lllllllllllllIlIlllIlIIIllIlIllI.yCoord;
        this.movePosZ = lllllllllllllIlIlllIlIIIllIlIllI.zCoord;
        return true;
    }
    
    @Override
    public void resetTask() {
        this.targetEntity = null;
    }
    
    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, this.speed);
    }
}
