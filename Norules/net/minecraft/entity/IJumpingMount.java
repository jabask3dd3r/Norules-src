package net.minecraft.entity;

public interface IJumpingMount
{
    void setJumpPower(final int p0);
    
    void handleStartJump(final int p0);
    
    boolean canJump();
    
    void handleStopJump();
}
