package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.*;

public interface IItemPropertyGetter
{
    float apply(final ItemStack p0, final World p1, final EntityLivingBase p2);
}
