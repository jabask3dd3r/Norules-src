package net.minecraft.world;

import net.minecraft.inventory.*;

public interface ILockableContainer extends IInventory, IInteractionObject
{
    LockCode getLockCode();
    
    void setLockCode(final LockCode p0);
    
    boolean isLocked();
}
