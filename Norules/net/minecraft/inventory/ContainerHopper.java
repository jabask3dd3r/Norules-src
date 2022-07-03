package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerHopper extends Container
{
    private final /* synthetic */ IInventory hopperInventory;
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllllllIllIIllIlIIIllI) {
        return this.hopperInventory.isUsableByPlayer(lllllllllllllllllIllIIllIlIIIllI);
    }
    
    public ContainerHopper(final InventoryPlayer lllllllllllllllllIllIIllIlIlIIIl, final IInventory lllllllllllllllllIllIIllIlIlIIII, final EntityPlayer lllllllllllllllllIllIIllIlIIllll) {
        this.hopperInventory = lllllllllllllllllIllIIllIlIlIIII;
        lllllllllllllllllIllIIllIlIlIIII.openInventory(lllllllllllllllllIllIIllIlIIllll);
        final int lllllllllllllllllIllIIllIlIlIlll = 51;
        for (int lllllllllllllllllIllIIllIlIlIllI = 0; lllllllllllllllllIllIIllIlIlIllI < lllllllllllllllllIllIIllIlIlIIII.getSizeInventory(); ++lllllllllllllllllIllIIllIlIlIllI) {
            this.addSlotToContainer(new Slot(lllllllllllllllllIllIIllIlIlIIII, lllllllllllllllllIllIIllIlIlIllI, 44 + lllllllllllllllllIllIIllIlIlIllI * 18, 20));
        }
        for (int lllllllllllllllllIllIIllIlIlIlIl = 0; lllllllllllllllllIllIIllIlIlIlIl < 3; ++lllllllllllllllllIllIIllIlIlIlIl) {
            for (int lllllllllllllllllIllIIllIlIlIlII = 0; lllllllllllllllllIllIIllIlIlIlII < 9; ++lllllllllllllllllIllIIllIlIlIlII) {
                this.addSlotToContainer(new Slot(lllllllllllllllllIllIIllIlIlIIIl, lllllllllllllllllIllIIllIlIlIlII + lllllllllllllllllIllIIllIlIlIlIl * 9 + 9, 8 + lllllllllllllllllIllIIllIlIlIlII * 18, lllllllllllllllllIllIIllIlIlIlIl * 18 + 51));
            }
        }
        for (int lllllllllllllllllIllIIllIlIlIIll = 0; lllllllllllllllllIllIIllIlIlIIll < 9; ++lllllllllllllllllIllIIllIlIlIIll) {
            this.addSlotToContainer(new Slot(lllllllllllllllllIllIIllIlIlIIIl, lllllllllllllllllIllIIllIlIlIIll, 8 + lllllllllllllllllIllIIllIlIlIIll * 18, 109));
        }
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllllllllIllIIllIIllIIII) {
        super.onContainerClosed(lllllllllllllllllIllIIllIIllIIII);
        this.hopperInventory.closeInventory(lllllllllllllllllIllIIllIIllIIII);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllllllIllIIllIIllllll, final int lllllllllllllllllIllIIllIIlllllI) {
        ItemStack lllllllllllllllllIllIIllIIllllIl = ItemStack.field_190927_a;
        final Slot lllllllllllllllllIllIIllIIllllII = this.inventorySlots.get(lllllllllllllllllIllIIllIIlllllI);
        if (lllllllllllllllllIllIIllIIllllII != null && lllllllllllllllllIllIIllIIllllII.getHasStack()) {
            final ItemStack lllllllllllllllllIllIIllIIlllIll = lllllllllllllllllIllIIllIIllllII.getStack();
            lllllllllllllllllIllIIllIIllllIl = lllllllllllllllllIllIIllIIlllIll.copy();
            if (lllllllllllllllllIllIIllIIlllllI < this.hopperInventory.getSizeInventory()) {
                if (!this.mergeItemStack(lllllllllllllllllIllIIllIIlllIll, this.hopperInventory.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllllllllIllIIllIIlllIll, 0, this.hopperInventory.getSizeInventory(), false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllllllllIllIIllIIlllIll.func_190926_b()) {
                lllllllllllllllllIllIIllIIllllII.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllllllllIllIIllIIllllII.onSlotChanged();
            }
        }
        return lllllllllllllllllIllIIllIIllllIl;
    }
}
