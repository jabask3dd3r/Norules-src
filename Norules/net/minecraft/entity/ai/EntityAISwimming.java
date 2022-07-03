package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;

public class EntityAISwimming extends EntityAIBase
{
    private final /* synthetic */ EntityLiving theEntity;
    
    @Override
    public void updateTask() {
        if (this.theEntity.getRNG().nextFloat() < 0.8f) {
            this.theEntity.getJumpHelper().setJumping();
        }
    }
    
    public EntityAISwimming(final EntityLiving llllllllllllllIlIlIIlIIIIIIlIlIl) {
        this.theEntity = llllllllllllllIlIlIIlIIIIIIlIlIl;
        this.setMutexBits(4);
        if (llllllllllllllIlIlIIlIIIIIIlIlIl.getNavigator() instanceof PathNavigateGround) {
            ((PathNavigateGround)llllllllllllllIlIlIIlIIIIIIlIlIl.getNavigator()).setCanSwim(true);
        }
        else if (llllllllllllllIlIlIIlIIIIIIlIlIl.getNavigator() instanceof PathNavigateFlying) {
            ((PathNavigateFlying)llllllllllllllIlIlIIlIIIIIIlIlIl.getNavigator()).func_192877_c(true);
        }
    }
    
    @Override
    public boolean shouldExecute() {
        return this.theEntity.isInWater() || this.theEntity.isInLava();
    }
}
