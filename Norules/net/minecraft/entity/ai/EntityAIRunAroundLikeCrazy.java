package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class EntityAIRunAroundLikeCrazy extends EntityAIBase
{
    private final /* synthetic */ double speed;
    private /* synthetic */ double targetZ;
    private /* synthetic */ double targetX;
    private /* synthetic */ double targetY;
    private final /* synthetic */ AbstractHorse horseHost;
    
    @Override
    public void updateTask() {
        if (!this.horseHost.isTame() && this.horseHost.getRNG().nextInt(50) == 0) {
            final Entity llllllllllllllIIlIlIlIIllIIlIlIl = this.horseHost.getPassengers().get(0);
            if (llllllllllllllIIlIlIlIIllIIlIlIl == null) {
                return;
            }
            if (llllllllllllllIIlIlIlIIllIIlIlIl instanceof EntityPlayer) {
                final int llllllllllllllIIlIlIlIIllIIlIIll = this.horseHost.getTemper();
                final int llllllllllllllIIlIlIlIIllIIlIIlI = this.horseHost.func_190676_dC();
                if (llllllllllllllIIlIlIlIIllIIlIIlI > 0 && this.horseHost.getRNG().nextInt(llllllllllllllIIlIlIlIIllIIlIIlI) < llllllllllllllIIlIlIlIIllIIlIIll) {
                    this.horseHost.setTamedBy((EntityPlayer)llllllllllllllIIlIlIlIIllIIlIlIl);
                    return;
                }
                this.horseHost.increaseTemper(5);
            }
            this.horseHost.removePassengers();
            this.horseHost.func_190687_dF();
            this.horseHost.world.setEntityState(this.horseHost, (byte)6);
        }
    }
    
    public EntityAIRunAroundLikeCrazy(final AbstractHorse llllllllllllllIIlIlIlIIllIllIlll, final double llllllllllllllIIlIlIlIIllIllIIlI) {
        this.horseHost = llllllllllllllIIlIlIlIIllIllIlll;
        this.speed = llllllllllllllIIlIlIlIIllIllIIlI;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.horseHost.isTame() || !this.horseHost.isBeingRidden()) {
            return false;
        }
        final Vec3d llllllllllllllIIlIlIlIIllIlIIlll = RandomPositionGenerator.findRandomTarget(this.horseHost, 5, 4);
        if (llllllllllllllIIlIlIlIIllIlIIlll == null) {
            return false;
        }
        this.targetX = llllllllllllllIIlIlIlIIllIlIIlll.xCoord;
        this.targetY = llllllllllllllIIlIlIlIIllIlIIlll.yCoord;
        this.targetZ = llllllllllllllIIlIlIlIIllIlIIlll.zCoord;
        return true;
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.horseHost.isTame() && !this.horseHost.getNavigator().noPath() && this.horseHost.isBeingRidden();
    }
    
    @Override
    public void startExecuting() {
        this.horseHost.getNavigator().tryMoveToXYZ(this.targetX, this.targetY, this.targetZ, this.speed);
    }
}
