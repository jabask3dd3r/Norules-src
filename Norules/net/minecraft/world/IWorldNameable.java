package net.minecraft.world;

import net.minecraft.util.text.*;

public interface IWorldNameable
{
    String getName();
    
    ITextComponent getDisplayName();
    
    boolean hasCustomName();
}
