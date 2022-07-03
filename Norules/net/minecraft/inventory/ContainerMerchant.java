package net.minecraft.inventory;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class ContainerMerchant extends Container
{
    private final /* synthetic */ World theWorld;
    private final /* synthetic */ InventoryMerchant merchantInventory;
    private final /* synthetic */ IMerchant theMerchant;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllIllIIlIlIlIIlllIll, final int llllllllllllllIllIIlIlIlIIlllIlI) {
        ItemStack llllllllllllllIllIIlIlIlIIllllll = ItemStack.field_190927_a;
        final Slot llllllllllllllIllIIlIlIlIIlllllI = this.inventorySlots.get(llllllllllllllIllIIlIlIlIIlllIlI);
        if (llllllllllllllIllIIlIlIlIIlllllI != null && llllllllllllllIllIIlIlIlIIlllllI.getHasStack()) {
            final ItemStack llllllllllllllIllIIlIlIlIIllllIl = llllllllllllllIllIIlIlIlIIlllllI.getStack();
            llllllllllllllIllIIlIlIlIIllllll = llllllllllllllIllIIlIlIlIIllllIl.copy();
            if (llllllllllllllIllIIlIlIlIIlllIlI == 2) {
                if (!this.mergeItemStack(llllllllllllllIllIIlIlIlIIllllIl, 3, 39, true)) {
                    return ItemStack.field_190927_a;
                }
                llllllllllllllIllIIlIlIlIIlllllI.onSlotChange(llllllllllllllIllIIlIlIlIIllllIl, llllllllllllllIllIIlIlIlIIllllll);
            }
            else if (llllllllllllllIllIIlIlIlIIlllIlI != 0 && llllllllllllllIllIIlIlIlIIlllIlI != 1) {
                if (llllllllllllllIllIIlIlIlIIlllIlI >= 3 && llllllllllllllIllIIlIlIlIIlllIlI < 30) {
                    if (!this.mergeItemStack(llllllllllllllIllIIlIlIlIIllllIl, 30, 39, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (llllllllllllllIllIIlIlIlIIlllIlI >= 30 && llllllllllllllIllIIlIlIlIIlllIlI < 39 && !this.mergeItemStack(llllllllllllllIllIIlIlIlIIllllIl, 3, 30, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllIllIIlIlIlIIllllIl, 3, 39, false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllllllIllIIlIlIlIIllllIl.func_190926_b()) {
                llllllllllllllIllIIlIlIlIIlllllI.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllllIllIIlIlIlIIlllllI.onSlotChanged();
            }
            if (llllllllllllllIllIIlIlIlIIllllIl.func_190916_E() == llllllllllllllIllIIlIlIlIIllllll.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            llllllllllllllIllIIlIlIlIIlllllI.func_190901_a(llllllllllllllIllIIlIlIlIIlllIll, llllllllllllllIllIIlIlIlIIllllIl);
        }
        return llllllllllllllIllIIlIlIlIIllllll;
    }
    
    public void setCurrentRecipeIndex(final int llllllllllllllIllIIlIlIlIlIlIIIl) {
        this.merchantInventory.setCurrentRecipeIndex(llllllllllllllIllIIlIlIlIlIlIIIl);
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory llllllllllllllIllIIlIlIlIlIlIlIl) {
        this.merchantInventory.resetRecipeAndSlots();
        super.onCraftMatrixChanged(llllllllllllllIllIIlIlIlIlIlIlIl);
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllIllIIlIlIlIIlIllll) {
        super.onContainerClosed(llllllllllllllIllIIlIlIlIIlIllll);
        this.theMerchant.setCustomer(null);
        super.onContainerClosed(llllllllllllllIllIIlIlIlIIlIllll);
        if (!this.theWorld.isRemote) {
            ItemStack llllllllllllllIllIIlIlIlIIllIIIl = this.merchantInventory.removeStackFromSlot(0);
            if (!llllllllllllllIllIIlIlIlIIllIIIl.func_190926_b()) {
                llllllllllllllIllIIlIlIlIIlIllll.dropItem(llllllllllllllIllIIlIlIlIIllIIIl, false);
            }
            llllllllllllllIllIIlIlIlIIllIIIl = this.merchantInventory.removeStackFromSlot(1);
            if (!llllllllllllllIllIIlIlIlIIllIIIl.func_190926_b()) {
                llllllllllllllIllIIlIlIlIIlIllll.dropItem(llllllllllllllIllIIlIlIlIIllIIIl, false);
            }
        }
    }
    
    public InventoryMerchant getMerchantInventory() {
        return this.merchantInventory;
    }
    
    public ContainerMerchant(final InventoryPlayer llllllllllllllIllIIlIlIlIllIlIIl, final IMerchant llllllllllllllIllIIlIlIlIllIlIII, final World llllllllllllllIllIIlIlIlIllIIIII) {
        this.theMerchant = llllllllllllllIllIIlIlIlIllIlIII;
        this.theWorld = llllllllllllllIllIIlIlIlIllIIIII;
        this.merchantInventory = new InventoryMerchant(llllllllllllllIllIIlIlIlIllIlIIl.player, llllllllllllllIllIIlIlIlIllIlIII);
        this.addSlotToContainer(new Slot(this.merchantInventory, 0, 36, 53));
        this.addSlotToContainer(new Slot(this.merchantInventory, 1, 62, 53));
        this.addSlotToContainer(new SlotMerchantResult(llllllllllllllIllIIlIlIlIllIlIIl.player, llllllllllllllIllIIlIlIlIllIlIII, this.merchantInventory, 2, 120, 53));
        for (int llllllllllllllIllIIlIlIlIllIIllI = 0; llllllllllllllIllIIlIlIlIllIIllI < 3; ++llllllllllllllIllIIlIlIlIllIIllI) {
            for (int llllllllllllllIllIIlIlIlIllIIlIl = 0; llllllllllllllIllIIlIlIlIllIIlIl < 9; ++llllllllllllllIllIIlIlIlIllIIlIl) {
                this.addSlotToContainer(new Slot(llllllllllllllIllIIlIlIlIllIlIIl, llllllllllllllIllIIlIlIlIllIIlIl + llllllllllllllIllIIlIlIlIllIIllI * 9 + 9, 8 + llllllllllllllIllIIlIlIlIllIIlIl * 18, 84 + llllllllllllllIllIIlIlIlIllIIllI * 18));
            }
        }
        for (int llllllllllllllIllIIlIlIlIllIIlII = 0; llllllllllllllIllIIlIlIlIllIIlII < 9; ++llllllllllllllIllIIlIlIlIllIIlII) {
            this.addSlotToContainer(new Slot(llllllllllllllIllIIlIlIlIllIlIIl, llllllllllllllIllIIlIlIlIllIIlII, 8 + llllllllllllllIllIIlIlIlIllIIlII * 18, 142));
        }
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllIllIIlIlIlIlIIlIll) {
        return this.theMerchant.getCustomer() == llllllllllllllIllIIlIlIlIlIIlIll;
    }
}
