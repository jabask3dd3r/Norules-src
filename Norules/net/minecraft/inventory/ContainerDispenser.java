package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerDispenser extends Container
{
    private final /* synthetic */ IInventory dispenserInventory;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllIIlllIlIllIIIllIIIl, final int lllllllllllllIIlllIlIllIIIllIllI) {
        ItemStack lllllllllllllIIlllIlIllIIIllIlIl = ItemStack.field_190927_a;
        final Slot lllllllllllllIIlllIlIllIIIllIlII = this.inventorySlots.get(lllllllllllllIIlllIlIllIIIllIllI);
        if (lllllllllllllIIlllIlIllIIIllIlII != null && lllllllllllllIIlllIlIllIIIllIlII.getHasStack()) {
            final ItemStack lllllllllllllIIlllIlIllIIIllIIll = lllllllllllllIIlllIlIllIIIllIlII.getStack();
            lllllllllllllIIlllIlIllIIIllIlIl = lllllllllllllIIlllIlIllIIIllIIll.copy();
            if (lllllllllllllIIlllIlIllIIIllIllI < 9) {
                if (!this.mergeItemStack(lllllllllllllIIlllIlIllIIIllIIll, 9, 45, true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllllIIlllIlIllIIIllIIll, 0, 9, false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllllIIlllIlIllIIIllIIll.func_190926_b()) {
                lllllllllllllIIlllIlIllIIIllIlII.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllllIIlllIlIllIIIllIlII.onSlotChanged();
            }
            if (lllllllllllllIIlllIlIllIIIllIIll.func_190916_E() == lllllllllllllIIlllIlIllIIIllIlIl.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            lllllllllllllIIlllIlIllIIIllIlII.func_190901_a(lllllllllllllIIlllIlIllIIIllIIIl, lllllllllllllIIlllIlIllIIIllIIll);
        }
        return lllllllllllllIIlllIlIllIIIllIlIl;
    }
    
    public ContainerDispenser(final IInventory lllllllllllllIIlllIlIllIIlIlIIII, final IInventory lllllllllllllIIlllIlIllIIlIIIlll) {
        this.dispenserInventory = lllllllllllllIIlllIlIllIIlIIIlll;
        for (int lllllllllllllIIlllIlIllIIlIIlllI = 0; lllllllllllllIIlllIlIllIIlIIlllI < 3; ++lllllllllllllIIlllIlIllIIlIIlllI) {
            for (int lllllllllllllIIlllIlIllIIlIIllIl = 0; lllllllllllllIIlllIlIllIIlIIllIl < 3; ++lllllllllllllIIlllIlIllIIlIIllIl) {
                this.addSlotToContainer(new Slot(lllllllllllllIIlllIlIllIIlIIIlll, lllllllllllllIIlllIlIllIIlIIllIl + lllllllllllllIIlllIlIllIIlIIlllI * 3, 62 + lllllllllllllIIlllIlIllIIlIIllIl * 18, 17 + lllllllllllllIIlllIlIllIIlIIlllI * 18));
            }
        }
        for (int lllllllllllllIIlllIlIllIIlIIllII = 0; lllllllllllllIIlllIlIllIIlIIllII < 3; ++lllllllllllllIIlllIlIllIIlIIllII) {
            for (int lllllllllllllIIlllIlIllIIlIIlIll = 0; lllllllllllllIIlllIlIllIIlIIlIll < 9; ++lllllllllllllIIlllIlIllIIlIIlIll) {
                this.addSlotToContainer(new Slot(lllllllllllllIIlllIlIllIIlIlIIII, lllllllllllllIIlllIlIllIIlIIlIll + lllllllllllllIIlllIlIllIIlIIllII * 9 + 9, 8 + lllllllllllllIIlllIlIllIIlIIlIll * 18, 84 + lllllllllllllIIlllIlIllIIlIIllII * 18));
            }
        }
        for (int lllllllllllllIIlllIlIllIIlIIlIlI = 0; lllllllllllllIIlllIlIllIIlIIlIlI < 9; ++lllllllllllllIIlllIlIllIIlIIlIlI) {
            this.addSlotToContainer(new Slot(lllllllllllllIIlllIlIllIIlIlIIII, lllllllllllllIIlllIlIllIIlIIlIlI, 8 + lllllllllllllIIlllIlIllIIlIIlIlI * 18, 142));
        }
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllIIlllIlIllIIIllllll) {
        return this.dispenserInventory.isUsableByPlayer(lllllllllllllIIlllIlIllIIIllllll);
    }
}
