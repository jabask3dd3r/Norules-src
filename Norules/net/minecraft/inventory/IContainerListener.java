package net.minecraft.inventory;

import net.minecraft.util.*;
import net.minecraft.item.*;

public interface IContainerListener
{
    void sendProgressBarUpdate(final Container p0, final int p1, final int p2);
    
    void updateCraftingInventory(final Container p0, final NonNullList<ItemStack> p1);
    
    void sendAllWindowProperties(final Container p0, final IInventory p1);
    
    void sendSlotContents(final Container p0, final int p1, final ItemStack p2);
}
