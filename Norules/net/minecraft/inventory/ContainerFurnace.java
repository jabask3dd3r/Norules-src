package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;

public class ContainerFurnace extends Container
{
    private /* synthetic */ int currentItemBurnTime;
    private /* synthetic */ int cookTime;
    private /* synthetic */ int totalCookTime;
    private /* synthetic */ int furnaceBurnTime;
    private final /* synthetic */ IInventory tileFurnace;
    
    @Override
    public void addListener(final IContainerListener lllllllllllllIllIIllIlIIllIIllIl) {
        super.addListener(lllllllllllllIllIIllIlIIllIIllIl);
        lllllllllllllIllIIllIlIIllIIllIl.sendAllWindowProperties(this, this.tileFurnace);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllIllIIllIlIIlIIIllII, final int lllllllllllllIllIIllIlIIlIIlIIIl) {
        ItemStack lllllllllllllIllIIllIlIIlIIlIIII = ItemStack.field_190927_a;
        final Slot lllllllllllllIllIIllIlIIlIIIllll = this.inventorySlots.get(lllllllllllllIllIIllIlIIlIIlIIIl);
        if (lllllllllllllIllIIllIlIIlIIIllll != null && lllllllllllllIllIIllIlIIlIIIllll.getHasStack()) {
            final ItemStack lllllllllllllIllIIllIlIIlIIIlllI = lllllllllllllIllIIllIlIIlIIIllll.getStack();
            lllllllllllllIllIIllIlIIlIIlIIII = lllllllllllllIllIIllIlIIlIIIlllI.copy();
            if (lllllllllllllIllIIllIlIIlIIlIIIl == 2) {
                if (!this.mergeItemStack(lllllllllllllIllIIllIlIIlIIIlllI, 3, 39, true)) {
                    return ItemStack.field_190927_a;
                }
                lllllllllllllIllIIllIlIIlIIIllll.onSlotChange(lllllllllllllIllIIllIlIIlIIIlllI, lllllllllllllIllIIllIlIIlIIlIIII);
            }
            else if (lllllllllllllIllIIllIlIIlIIlIIIl != 1 && lllllllllllllIllIIllIlIIlIIlIIIl != 0) {
                if (!FurnaceRecipes.instance().getSmeltingResult(lllllllllllllIllIIllIlIIlIIIlllI).func_190926_b()) {
                    if (!this.mergeItemStack(lllllllllllllIllIIllIlIIlIIIlllI, 0, 1, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(lllllllllllllIllIIllIlIIlIIIlllI)) {
                    if (!this.mergeItemStack(lllllllllllllIllIIllIlIIlIIIlllI, 1, 2, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (lllllllllllllIllIIllIlIIlIIlIIIl >= 3 && lllllllllllllIllIIllIlIIlIIlIIIl < 30) {
                    if (!this.mergeItemStack(lllllllllllllIllIIllIlIIlIIIlllI, 30, 39, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (lllllllllllllIllIIllIlIIlIIlIIIl >= 30 && lllllllllllllIllIIllIlIIlIIlIIIl < 39 && !this.mergeItemStack(lllllllllllllIllIIllIlIIlIIIlllI, 3, 30, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(lllllllllllllIllIIllIlIIlIIIlllI, 3, 39, false)) {
                return ItemStack.field_190927_a;
            }
            if (lllllllllllllIllIIllIlIIlIIIlllI.func_190926_b()) {
                lllllllllllllIllIIllIlIIlIIIllll.putStack(ItemStack.field_190927_a);
            }
            else {
                lllllllllllllIllIIllIlIIlIIIllll.onSlotChanged();
            }
            if (lllllllllllllIllIIllIlIIlIIIlllI.func_190916_E() == lllllllllllllIllIIllIlIIlIIlIIII.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            lllllllllllllIllIIllIlIIlIIIllll.func_190901_a(lllllllllllllIllIIllIlIIlIIIllII, lllllllllllllIllIIllIlIIlIIIlllI);
        }
        return lllllllllllllIllIIllIlIIlIIlIIII;
    }
    
    public ContainerFurnace(final InventoryPlayer lllllllllllllIllIIllIlIIlllIIIIl, final IInventory lllllllllllllIllIIllIlIIllIlllll) {
        this.tileFurnace = lllllllllllllIllIIllIlIIllIlllll;
        this.addSlotToContainer(new Slot(lllllllllllllIllIIllIlIIllIlllll, 0, 56, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(lllllllllllllIllIIllIlIIllIlllll, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(lllllllllllllIllIIllIlIIlllIIIIl.player, lllllllllllllIllIIllIlIIllIlllll, 2, 116, 35));
        for (int lllllllllllllIllIIllIlIIllIllllI = 0; lllllllllllllIllIIllIlIIllIllllI < 3; ++lllllllllllllIllIIllIlIIllIllllI) {
            for (int lllllllllllllIllIIllIlIIllIlllIl = 0; lllllllllllllIllIIllIlIIllIlllIl < 9; ++lllllllllllllIllIIllIlIIllIlllIl) {
                this.addSlotToContainer(new Slot(lllllllllllllIllIIllIlIIlllIIIIl, lllllllllllllIllIIllIlIIllIlllIl + lllllllllllllIllIIllIlIIllIllllI * 9 + 9, 8 + lllllllllllllIllIIllIlIIllIlllIl * 18, 84 + lllllllllllllIllIIllIlIIllIllllI * 18));
            }
        }
        for (int lllllllllllllIllIIllIlIIllIlllII = 0; lllllllllllllIllIIllIlIIllIlllII < 9; ++lllllllllllllIllIIllIlIIllIlllII) {
            this.addSlotToContainer(new Slot(lllllllllllllIllIIllIlIIlllIIIIl, lllllllllllllIllIIllIlIIllIlllII, 8 + lllllllllllllIllIIllIlIIllIlllII * 18, 142));
        }
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer lllllllllllllIllIIllIlIIlIIllIlI) {
        return this.tileFurnace.isUsableByPlayer(lllllllllllllIllIIllIlIIlIIllIlI);
    }
    
    @Override
    public void updateProgressBar(final int lllllllllllllIllIIllIlIIlIlIIlII, final int lllllllllllllIllIIllIlIIlIlIIIII) {
        this.tileFurnace.setField(lllllllllllllIllIIllIlIIlIlIIlII, lllllllllllllIllIIllIlIIlIlIIIII);
    }
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int lllllllllllllIllIIllIlIIlIllIIlI = 0; lllllllllllllIllIIllIlIIlIllIIlI < this.listeners.size(); ++lllllllllllllIllIIllIlIIlIllIIlI) {
            final IContainerListener lllllllllllllIllIIllIlIIlIllIIIl = this.listeners.get(lllllllllllllIllIIllIlIIlIllIIlI);
            if (this.cookTime != this.tileFurnace.getField(2)) {
                lllllllllllllIllIIllIlIIlIllIIIl.sendProgressBarUpdate(this, 2, this.tileFurnace.getField(2));
            }
            if (this.furnaceBurnTime != this.tileFurnace.getField(0)) {
                lllllllllllllIllIIllIlIIlIllIIIl.sendProgressBarUpdate(this, 0, this.tileFurnace.getField(0));
            }
            if (this.currentItemBurnTime != this.tileFurnace.getField(1)) {
                lllllllllllllIllIIllIlIIlIllIIIl.sendProgressBarUpdate(this, 1, this.tileFurnace.getField(1));
            }
            if (this.totalCookTime != this.tileFurnace.getField(3)) {
                lllllllllllllIllIIllIlIIlIllIIIl.sendProgressBarUpdate(this, 3, this.tileFurnace.getField(3));
            }
        }
        this.cookTime = this.tileFurnace.getField(2);
        this.furnaceBurnTime = this.tileFurnace.getField(0);
        this.currentItemBurnTime = this.tileFurnace.getField(1);
        this.totalCookTime = this.tileFurnace.getField(3);
    }
}
