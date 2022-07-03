package net.minecraft.entity.ai;

import net.minecraft.entity.*;

public class EntityAIOpenDoor extends EntityAIDoorInteract
{
    /* synthetic */ boolean closeDoor;
    /* synthetic */ int closeDoorTemporisation;
    
    public EntityAIOpenDoor(final EntityLiving lllllllllllllIIIllIllIlllIllIIll, final boolean lllllllllllllIIIllIllIlllIlIllll) {
        super(lllllllllllllIIIllIllIlllIllIIll);
        this.theEntity = lllllllllllllIIIllIllIlllIllIIll;
        this.closeDoor = lllllllllllllIIIllIllIlllIlIllll;
    }
    
    @Override
    public void startExecuting() {
        this.closeDoorTemporisation = 20;
        this.doorBlock.toggleDoor(this.theEntity.world, this.doorPosition, true);
    }
    
    @Override
    public void updateTask() {
        --this.closeDoorTemporisation;
        super.updateTask();
    }
    
    @Override
    public boolean continueExecuting() {
        return this.closeDoor && this.closeDoorTemporisation > 0 && super.continueExecuting();
    }
    
    @Override
    public void resetTask() {
        if (this.closeDoor) {
            this.doorBlock.toggleDoor(this.theEntity.world, this.doorPosition, false);
        }
    }
}
