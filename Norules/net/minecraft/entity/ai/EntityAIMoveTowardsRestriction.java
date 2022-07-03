package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class EntityAIMoveTowardsRestriction extends EntityAIBase
{
    private /* synthetic */ double movePosX;
    private /* synthetic */ double movePosZ;
    private final /* synthetic */ EntityCreature theEntity;
    private /* synthetic */ double movePosY;
    private final /* synthetic */ double movementSpeed;
    
    @Override
    public boolean shouldExecute() {
        if (this.theEntity.isWithinHomeDistanceCurrentPosition()) {
            return false;
        }
        final BlockPos llllllllllllllIIlIIIIlIlIlllIIIl = this.theEntity.getHomePosition();
        final Vec3d llllllllllllllIIlIIIIlIlIlllIIII = RandomPositionGenerator.findRandomTargetBlockTowards(this.theEntity, 16, 7, new Vec3d(llllllllllllllIIlIIIIlIlIlllIIIl.getX(), llllllllllllllIIlIIIIlIlIlllIIIl.getY(), llllllllllllllIIlIIIIlIlIlllIIIl.getZ()));
        if (llllllllllllllIIlIIIIlIlIlllIIII == null) {
            return false;
        }
        this.movePosX = llllllllllllllIIlIIIIlIlIlllIIII.xCoord;
        this.movePosY = llllllllllllllIIlIIIIlIlIlllIIII.yCoord;
        this.movePosZ = llllllllllllllIIlIIIIlIlIlllIIII.zCoord;
        return true;
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.theEntity.getNavigator().noPath();
    }
    
    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, this.movementSpeed);
    }
    
    public EntityAIMoveTowardsRestriction(final EntityCreature llllllllllllllIIlIIIIlIlIlllIlll, final double llllllllllllllIIlIIIIlIlIllllIIl) {
        this.theEntity = llllllllllllllIIlIIIIlIlIlllIlll;
        this.movementSpeed = llllllllllllllIIlIIIIlIlIllllIIl;
        this.setMutexBits(1);
    }
}
