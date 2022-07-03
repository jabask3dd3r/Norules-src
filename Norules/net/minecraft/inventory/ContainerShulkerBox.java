package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class ContainerShulkerBox extends Container
{
    private final /* synthetic */ IInventory field_190899_a;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllllIlIllllIIIlllIlII, final int lllllllllllllllIlIllllIIIlllIIll) {
        ItemStack lllllllllllllllIlIllllIIIlllIIlI = ItemStack.field_190927_a;
        final Slot lllllllllllllllIlIllllIIIlllIIIl = this.inventorySlots.get(lllllllllllllllIlIllllIIIlllIIll);
        if (lllllllllllllllIlIllllIIIlllIIIl != null && lllllllllllllllIlIllllIIIlllIIIl.getHasStack()) {
            final ItemStack lllllllllllllllIlIllllIIIlllIIII = lllllllllllllllIlIllllIIIlllIIIl.getStack();
            lllllllllllllllIlIllllIIIlllIIlI = lllllllllllllllIlIllllIIIlllIIII.copy();
            if (lllllllllllllllIlIllllIIIlllIIll < this.field_190899_a.getSizeInventory()) {
                if (!this.mergeItemStack(lllllllllllllllIlIllllIIIlllIIII, this.field_190899_a.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllllllIlIllllIIIlllIIII, 0, this.field_190899_a.getSizeInventory(), false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllllllIlIllllIIIlllIIII.func_190926_b()) {
                lllllllllllllllIlIllllIIIlllIIIl.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllllllIlIllllIIIlllIIIl.onSlotChanged();
            }
        }
        return lllllllllllllllIlIllllIIIlllIIlI;
    }
    
    public ContainerShulkerBox(final InventoryPlayer lllllllllllllllIlIllllIIlIIIIlll, final IInventory lllllllllllllllIlIllllIIlIIIIllI, final EntityPlayer lllllllllllllllIlIllllIIlIIlIIII) {
        this.field_190899_a = lllllllllllllllIlIllllIIlIIIIllI;
        lllllllllllllllIlIllllIIlIIIIllI.openInventory(lllllllllllllllIlIllllIIlIIlIIII);
        final int lllllllllllllllIlIllllIIlIIIllll = 3;
        final int lllllllllllllllIlIllllIIlIIIlllI = 9;
        for (int lllllllllllllllIlIllllIIlIIIllIl = 0; lllllllllllllllIlIllllIIlIIIllIl < 3; ++lllllllllllllllIlIllllIIlIIIllIl) {
            for (int lllllllllllllllIlIllllIIlIIIllII = 0; lllllllllllllllIlIllllIIlIIIllII < 9; ++lllllllllllllllIlIllllIIlIIIllII) {
                this.addSlotToContainer(new SlotShulkerBox(lllllllllllllllIlIllllIIlIIIIllI, lllllllllllllllIlIllllIIlIIIllII + lllllllllllllllIlIllllIIlIIIllIl * 9, 8 + lllllllllllllllIlIllllIIlIIIllII * 18, 18 + lllllllllllllllIlIllllIIlIIIllIl * 18));
            }
        }
        for (int lllllllllllllllIlIllllIIlIIIlIll = 0; lllllllllllllllIlIllllIIlIIIlIll < 3; ++lllllllllllllllIlIllllIIlIIIlIll) {
            for (int lllllllllllllllIlIllllIIlIIIlIlI = 0; lllllllllllllllIlIllllIIlIIIlIlI < 9; ++lllllllllllllllIlIllllIIlIIIlIlI) {
                this.addSlotToContainer(new Slot(lllllllllllllllIlIllllIIlIIIIlll, lllllllllllllllIlIllllIIlIIIlIlI + lllllllllllllllIlIllllIIlIIIlIll * 9 + 9, 8 + lllllllllllllllIlIllllIIlIIIlIlI * 18, 84 + lllllllllllllllIlIllllIIlIIIlIll * 18));
            }
        }
        for (int lllllllllllllllIlIllllIIlIIIlIIl = 0; lllllllllllllllIlIllllIIlIIIlIIl < 9; ++lllllllllllllllIlIllllIIlIIIlIIl) {
            this.addSlotToContainer(new Slot(lllllllllllllllIlIllllIIlIIIIlll, lllllllllllllllIlIllllIIlIIIlIIl, 8 + lllllllllllllllIlIllllIIlIIIlIIl * 18, 142));
        }
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllllllIlIllllIIIllIIlIl) {
        super.onContainerClosed(lllllllllllllllIlIllllIIIllIIlIl);
        this.field_190899_a.closeInventory(lllllllllllllllIlIllllIIIllIIlIl);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllllIlIllllIIIlllllIl) {
        return this.field_190899_a.isUsableByPlayer(lllllllllllllllIlIllllIIIlllllIl);
    }
}
