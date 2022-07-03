package net.minecraft.inventory;

import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public interface IInventory extends IWorldNameable
{
    ItemStack getStackInSlot(final int p0);
    
    boolean isUsableByPlayer(final EntityPlayer p0);
    
    boolean isItemValidForSlot(final int p0, final ItemStack p1);
    
    void markDirty();
    
    int getInventoryStackLimit();
    
    void closeInventory(final EntityPlayer p0);
    
    void openInventory(final EntityPlayer p0);
    
    void setField(final int p0, final int p1);
    
    int getField(final int p0);
    
    int getFieldCount();
    
    ItemStack decrStackSize(final int p0, final int p1);
    
    ItemStack removeStackFromSlot(final int p0);
    
    boolean func_191420_l();
    
    int getSizeInventory();
    
    void clear();
    
    void setInventorySlotContents(final int p0, final ItemStack p1);
}
