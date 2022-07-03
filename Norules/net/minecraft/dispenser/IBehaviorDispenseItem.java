package net.minecraft.dispenser;

import net.minecraft.item.*;

public interface IBehaviorDispenseItem
{
    ItemStack dispense(final IBlockSource p0, final ItemStack p1);
}
