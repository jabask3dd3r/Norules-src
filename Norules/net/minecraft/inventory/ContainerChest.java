package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ContainerChest extends Container
{
    private final /* synthetic */ IInventory lowerChestInventory;
    private final /* synthetic */ int numRows;
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllllIIlIllIIIlIlIlIll) {
        return this.lowerChestInventory.isUsableByPlayer(lllllllllllllllIIlIllIIIlIlIlIll);
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer lllllllllllllllIIlIllIIIlIIlIlll) {
        super.onContainerClosed(lllllllllllllllIIlIllIIIlIIlIlll);
        this.lowerChestInventory.closeInventory(lllllllllllllllIIlIllIIIlIIlIlll);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllllIIlIllIIIlIlIIlII, final int lllllllllllllllIIlIllIIIlIIllllI) {
        ItemStack lllllllllllllllIIlIllIIIlIlIIIlI = ItemStack.field_190927_a;
        final Slot lllllllllllllllIIlIllIIIlIlIIIIl = this.inventorySlots.get(lllllllllllllllIIlIllIIIlIIllllI);
        if (lllllllllllllllIIlIllIIIlIlIIIIl != null && lllllllllllllllIIlIllIIIlIlIIIIl.getHasStack()) {
            final ItemStack lllllllllllllllIIlIllIIIlIlIIIII = lllllllllllllllIIlIllIIIlIlIIIIl.getStack();
            lllllllllllllllIIlIllIIIlIlIIIlI = lllllllllllllllIIlIllIIIlIlIIIII.copy();
            if (lllllllllllllllIIlIllIIIlIIllllI < this.numRows * 9) {
                if (!this.mergeItemStack(lllllllllllllllIIlIllIIIlIlIIIII, this.numRows * 9, this.inventorySlots.size(), true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllllllIIlIllIIIlIlIIIII, 0, this.numRows * 9, false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllllllIIlIllIIIlIlIIIII.func_190926_b()) {
                lllllllllllllllIIlIllIIIlIlIIIIl.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllllllIIlIllIIIlIlIIIIl.onSlotChanged();
            }
        }
        return lllllllllllllllIIlIllIIIlIlIIIlI;
    }
    
    public IInventory getLowerChestInventory() {
        return this.lowerChestInventory;
    }
    
    public ContainerChest(final IInventory lllllllllllllllIIlIllIIIllIIIIII, final IInventory lllllllllllllllIIlIllIIIlIllllll, final EntityPlayer lllllllllllllllIIlIllIIIlIlllllI) {
        this.lowerChestInventory = lllllllllllllllIIlIllIIIlIllllll;
        this.numRows = lllllllllllllllIIlIllIIIlIllllll.getSizeInventory() / 9;
        lllllllllllllllIIlIllIIIlIllllll.openInventory(lllllllllllllllIIlIllIIIlIlllllI);
        final int lllllllllllllllIIlIllIIIlIllllIl = (this.numRows - 4) * 18;
        for (int lllllllllllllllIIlIllIIIlIllllII = 0; lllllllllllllllIIlIllIIIlIllllII < this.numRows; ++lllllllllllllllIIlIllIIIlIllllII) {
            for (int lllllllllllllllIIlIllIIIlIlllIll = 0; lllllllllllllllIIlIllIIIlIlllIll < 9; ++lllllllllllllllIIlIllIIIlIlllIll) {
                this.addSlotToContainer(new Slot(lllllllllllllllIIlIllIIIlIllllll, lllllllllllllllIIlIllIIIlIlllIll + lllllllllllllllIIlIllIIIlIllllII * 9, 8 + lllllllllllllllIIlIllIIIlIlllIll * 18, 18 + lllllllllllllllIIlIllIIIlIllllII * 18));
            }
        }
        for (int lllllllllllllllIIlIllIIIlIlllIlI = 0; lllllllllllllllIIlIllIIIlIlllIlI < 3; ++lllllllllllllllIIlIllIIIlIlllIlI) {
            for (int lllllllllllllllIIlIllIIIlIlllIIl = 0; lllllllllllllllIIlIllIIIlIlllIIl < 9; ++lllllllllllllllIIlIllIIIlIlllIIl) {
                this.addSlotToContainer(new Slot(lllllllllllllllIIlIllIIIllIIIIII, lllllllllllllllIIlIllIIIlIlllIIl + lllllllllllllllIIlIllIIIlIlllIlI * 9 + 9, 8 + lllllllllllllllIIlIllIIIlIlllIIl * 18, 103 + lllllllllllllllIIlIllIIIlIlllIlI * 18 + lllllllllllllllIIlIllIIIlIllllIl));
            }
        }
        for (int lllllllllllllllIIlIllIIIlIlllIII = 0; lllllllllllllllIIlIllIIIlIlllIII < 9; ++lllllllllllllllIIlIllIIIlIlllIII) {
            this.addSlotToContainer(new Slot(lllllllllllllllIIlIllIIIllIIIIII, lllllllllllllllIIlIllIIIlIlllIII, 8 + lllllllllllllllIIlIllIIIlIlllIII * 18, 161 + lllllllllllllllIIlIllIIIlIllllIl));
        }
    }
}
