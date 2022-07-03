package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.util.*;

public interface ISidedInventory extends IInventory
{
    boolean canInsertItem(final int p0, final ItemStack p1, final EnumFacing p2);
    
    boolean canExtractItem(final int p0, final ItemStack p1, final EnumFacing p2);
    
    int[] getSlotsForFace(final EnumFacing p0);
}
