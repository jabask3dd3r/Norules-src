package net.minecraft.entity.ai;

import net.minecraft.entity.*;

public class EntityAILookIdle extends EntityAIBase
{
    private /* synthetic */ int idleTime;
    private /* synthetic */ double lookZ;
    private /* synthetic */ double lookX;
    private final /* synthetic */ EntityLiving idleEntity;
    
    public EntityAILookIdle(final EntityLiving lllIIIIIIlIIlll) {
        this.idleEntity = lllIIIIIIlIIlll;
        this.setMutexBits(3);
    }
    
    @Override
    public void startExecuting() {
        final double lllIIIIIIIllIll = 6.283185307179586 * this.idleEntity.getRNG().nextDouble();
        this.lookX = Math.cos(lllIIIIIIIllIll);
        this.lookZ = Math.sin(lllIIIIIIIllIll);
        this.idleTime = 20 + this.idleEntity.getRNG().nextInt(20);
    }
    
    @Override
    public boolean shouldExecute() {
        return this.idleEntity.getRNG().nextFloat() < 0.02f;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.idleTime >= 0;
    }
    
    @Override
    public void updateTask() {
        --this.idleTime;
        this.idleEntity.getLookHelper().setLookPosition(this.idleEntity.posX + this.lookX, this.idleEntity.posY + this.idleEntity.getEyeHeight(), this.idleEntity.posZ + this.lookZ, (float)this.idleEntity.getHorizontalFaceSpeed(), (float)this.idleEntity.getVerticalFaceSpeed());
    }
}
