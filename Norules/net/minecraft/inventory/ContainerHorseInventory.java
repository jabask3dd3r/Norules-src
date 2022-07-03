package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class ContainerHorseInventory extends Container
{
    private final /* synthetic */ IInventory horseInventory;
    private final /* synthetic */ AbstractHorse theHorse;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllIllIIlllIlllIllIII, final int llllllllllllllIllIIlllIlllIlIlll) {
        ItemStack llllllllllllllIllIIlllIlllIlIllI = ItemStack.field_190927_a;
        final Slot llllllllllllllIllIIlllIlllIlIlIl = this.inventorySlots.get(llllllllllllllIllIIlllIlllIlIlll);
        if (llllllllllllllIllIIlllIlllIlIlIl != null && llllllllllllllIllIIlllIlllIlIlIl.getHasStack()) {
            final ItemStack llllllllllllllIllIIlllIlllIlIlII = llllllllllllllIllIIlllIlllIlIlIl.getStack();
            llllllllllllllIllIIlllIlllIlIllI = llllllllllllllIllIIlllIlllIlIlII.copy();
            if (llllllllllllllIllIIlllIlllIlIlll < this.horseInventory.getSizeInventory()) {
                if (!this.mergeItemStack(llllllllllllllIllIIlllIlllIlIlII, this.horseInventory.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (this.getSlot(1).isItemValid(llllllllllllllIllIIlllIlllIlIlII) && !this.getSlot(1).getHasStack()) {
                if (!this.mergeItemStack(llllllllllllllIllIIlllIlllIlIlII, 1, 2, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (this.getSlot(0).isItemValid(llllllllllllllIllIIlllIlllIlIlII)) {
                if (!this.mergeItemStack(llllllllllllllIllIIlllIlllIlIlII, 0, 1, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (this.horseInventory.getSizeInventory() <= 2 || !this.mergeItemStack(llllllllllllllIllIIlllIlllIlIlII, 2, this.horseInventory.getSizeInventory(), false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllllllIllIIlllIlllIlIlII.func_190926_b()) {
                llllllllllllllIllIIlllIlllIlIlIl.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllllIllIIlllIlllIlIlIl.onSlotChanged();
            }
        }
        return llllllllllllllIllIIlllIlllIlIllI;
    }
    
    public ContainerHorseInventory(final IInventory llllllllllllllIllIIlllIllllIllII, final IInventory llllllllllllllIllIIlllIlllllIlll, final AbstractHorse llllllllllllllIllIIlllIllllIlIlI, final EntityPlayer llllllllllllllIllIIlllIlllllIlIl) {
        this.horseInventory = llllllllllllllIllIIlllIlllllIlll;
        this.theHorse = llllllllllllllIllIIlllIllllIlIlI;
        final int llllllllllllllIllIIlllIlllllIlII = 3;
        llllllllllllllIllIIlllIlllllIlll.openInventory(llllllllllllllIllIIlllIlllllIlIl);
        final int llllllllllllllIllIIlllIlllllIIll = -18;
        this.addSlotToContainer(new Slot(llllllllllllllIllIIlllIlllllIlll, 0, 8, 18) {
            @Override
            public boolean canBeHovered() {
                return llllllllllllllIllIIlllIllllIlIlI.func_190685_dA();
            }
            
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllIIIlIlIlllllIllllll) {
                return lllllllllllllIIIlIlIlllllIllllll.getItem() == Items.SADDLE && !this.getHasStack() && llllllllllllllIllIIlllIllllIlIlI.func_190685_dA();
            }
        });
        this.addSlotToContainer(new Slot(llllllllllllllIllIIlllIlllllIlll, 1, 8, 36) {
            @Override
            public boolean canBeHovered() {
                return llllllllllllllIllIIlllIllllIlIlI.func_190677_dK();
            }
            
            @Override
            public int getSlotStackLimit() {
                return 1;
            }
            
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllIlIlllIIIllIllllIll) {
                return llllllllllllllIllIIlllIllllIlIlI.func_190682_f(lllllllllllllIlIlllIIIllIllllIll);
            }
        });
        if (llllllllllllllIllIIlllIllllIlIlI instanceof AbstractChestHorse && ((AbstractChestHorse)llllllllllllllIllIIlllIllllIlIlI).func_190695_dh()) {
            for (int llllllllllllllIllIIlllIlllllIIlI = 0; llllllllllllllIllIIlllIlllllIIlI < 3; ++llllllllllllllIllIIlllIlllllIIlI) {
                for (int llllllllllllllIllIIlllIlllllIIIl = 0; llllllllllllllIllIIlllIlllllIIIl < ((AbstractChestHorse)llllllllllllllIllIIlllIllllIlIlI).func_190696_dl(); ++llllllllllllllIllIIlllIlllllIIIl) {
                    this.addSlotToContainer(new Slot(llllllllllllllIllIIlllIlllllIlll, 2 + llllllllllllllIllIIlllIlllllIIIl + llllllllllllllIllIIlllIlllllIIlI * ((AbstractChestHorse)llllllllllllllIllIIlllIllllIlIlI).func_190696_dl(), 80 + llllllllllllllIllIIlllIlllllIIIl * 18, 18 + llllllllllllllIllIIlllIlllllIIlI * 18));
                }
            }
        }
        for (int llllllllllllllIllIIlllIlllllIIII = 0; llllllllllllllIllIIlllIlllllIIII < 3; ++llllllllllllllIllIIlllIlllllIIII) {
            for (int llllllllllllllIllIIlllIllllIllll = 0; llllllllllllllIllIIlllIllllIllll < 9; ++llllllllllllllIllIIlllIllllIllll) {
                this.addSlotToContainer(new Slot(llllllllllllllIllIIlllIllllIllII, llllllllllllllIllIIlllIllllIllll + llllllllllllllIllIIlllIlllllIIII * 9 + 9, 8 + llllllllllllllIllIIlllIllllIllll * 18, 102 + llllllllllllllIllIIlllIlllllIIII * 18 - 18));
            }
        }
        for (int llllllllllllllIllIIlllIllllIlllI = 0; llllllllllllllIllIIlllIllllIlllI < 9; ++llllllllllllllIllIIlllIllllIlllI) {
            this.addSlotToContainer(new Slot(llllllllllllllIllIIlllIllllIllII, llllllllllllllIllIIlllIllllIlllI, 8 + llllllllllllllIllIIlllIllllIlllI * 18, 142));
        }
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllIllIIlllIllllIIIIl) {
        return this.horseInventory.isUsableByPlayer(llllllllllllllIllIIlllIllllIIIIl) && this.theHorse.isEntityAlive() && this.theHorse.getDistanceToEntity(llllllllllllllIllIIlllIllllIIIIl) < 8.0f;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllIllIIlllIlllIIlIll) {
        super.onContainerClosed(llllllllllllllIllIIlllIlllIIlIll);
        this.horseInventory.closeInventory(llllllllllllllIllIIlllIlllIIlIll);
    }
}
