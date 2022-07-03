package net.minecraft.entity.ai;

public abstract class EntityAIBase
{
    private /* synthetic */ int mutexBits;
    
    public void setMutexBits(final int lllllllllllllIIlIlllllIIlIllIIII) {
        this.mutexBits = lllllllllllllIIlIlllllIIlIllIIII;
    }
    
    public int getMutexBits() {
        return this.mutexBits;
    }
    
    public boolean continueExecuting() {
        return this.shouldExecute();
    }
    
    public void updateTask() {
    }
    
    public void startExecuting() {
    }
    
    public boolean isInterruptible() {
        return true;
    }
    
    public void resetTask() {
    }
    
    public abstract boolean shouldExecute();
}
