package net.minecraft.entity;

import net.minecraft.world.*;
import net.minecraft.util.*;

public interface IEntityMultiPart
{
    World getWorld();
    
    boolean attackEntityFromPart(final MultiPartEntityPart p0, final DamageSource p1, final float p2);
}
