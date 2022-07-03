package net.minecraft.inventory;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.item.crafting.*;
import com.google.common.collect.*;

public abstract class Container
{
    private /* synthetic */ short transactionID;
    private /* synthetic */ int dragEvent;
    private final /* synthetic */ Set<EntityPlayer> playerList;
    private /* synthetic */ int dragMode;
    private final /* synthetic */ Set<Slot> dragSlots;
    public /* synthetic */ int windowId;
    protected /* synthetic */ List<IContainerListener> listeners;
    public /* synthetic */ NonNullList<ItemStack> inventoryItemStacks;
    public /* synthetic */ List<Slot> inventorySlots;
    
    public boolean canMergeSlot(final ItemStack lllllllllllllIllIIlIlIllIllIIIII, final Slot lllllllllllllIllIIlIlIllIlIlllll) {
        return true;
    }
    
    public void onCraftMatrixChanged(final IInventory lllllllllllllIllIIlIlIllIlIIIlll) {
        this.detectAndSendChanges();
    }
    
    protected void resetDrag() {
        this.dragEvent = 0;
        this.dragSlots.clear();
    }
    
    public static int extractDragMode(final int lllllllllllllIllIIlIlIlIllllllII) {
        return lllllllllllllIllIIlIlIlIllllllII >> 2 & 0x3;
    }
    
    public static void computeStackSize(final Set<Slot> lllllllllllllIllIIlIlIlIllIlIlII, final int lllllllllllllIllIIlIlIlIllIlIIll, final ItemStack lllllllllllllIllIIlIlIlIllIlIllI, final int lllllllllllllIllIIlIlIlIllIlIlIl) {
        switch (lllllllllllllIllIIlIlIlIllIlIIll) {
            case 0: {
                lllllllllllllIllIIlIlIlIllIlIllI.func_190920_e(MathHelper.floor(lllllllllllllIllIIlIlIlIllIlIllI.func_190916_E() / (float)lllllllllllllIllIIlIlIlIllIlIlII.size()));
                break;
            }
            case 1: {
                lllllllllllllIllIIlIlIlIllIlIllI.func_190920_e(1);
                break;
            }
            case 2: {
                lllllllllllllIllIIlIlIlIllIlIllI.func_190920_e(lllllllllllllIllIIlIlIlIllIlIllI.getItem().getItemStackLimit());
                break;
            }
        }
        lllllllllllllIllIIlIlIlIllIlIllI.func_190917_f(lllllllllllllIllIIlIlIlIllIlIlIl);
    }
    
    public void setCanCraft(final EntityPlayer lllllllllllllIllIIlIlIllIIlIIIlI, final boolean lllllllllllllIllIIlIlIllIIIllllI) {
        if (lllllllllllllIllIIlIlIllIIIllllI) {
            this.playerList.remove(lllllllllllllIllIIlIlIllIIlIIIlI);
        }
        else {
            this.playerList.add(lllllllllllllIllIIlIlIllIIlIIIlI);
        }
    }
    
    public void updateProgressBar(final int lllllllllllllIllIIlIlIllIIllIIlI, final int lllllllllllllIllIIlIlIllIIllIIIl) {
    }
    
    public ItemStack slotClick(final int lllllllllllllIllIIlIlIllIlllIIIl, final int lllllllllllllIllIIlIlIlllIIlllIl, final ClickType lllllllllllllIllIIlIlIllIllIllll, final EntityPlayer lllllllllllllIllIIlIlIllIllIlllI) {
        ItemStack lllllllllllllIllIIlIlIlllIIllIlI = ItemStack.field_190927_a;
        final InventoryPlayer lllllllllllllIllIIlIlIlllIIllIIl = lllllllllllllIllIIlIlIllIllIlllI.inventory;
        if (lllllllllllllIllIIlIlIllIllIllll == ClickType.QUICK_CRAFT) {
            final int lllllllllllllIllIIlIlIlllIIllIII = this.dragEvent;
            this.dragEvent = getDragEvent(lllllllllllllIllIIlIlIlllIIlllIl);
            if ((lllllllllllllIllIIlIlIlllIIllIII != 1 || this.dragEvent != 2) && lllllllllllllIllIIlIlIlllIIllIII != this.dragEvent) {
                this.resetDrag();
            }
            else if (lllllllllllllIllIIlIlIlllIIllIIl.getItemStack().func_190926_b()) {
                this.resetDrag();
            }
            else if (this.dragEvent == 0) {
                this.dragMode = extractDragMode(lllllllllllllIllIIlIlIlllIIlllIl);
                if (isValidDragMode(this.dragMode, lllllllllllllIllIIlIlIllIllIlllI)) {
                    this.dragEvent = 1;
                    this.dragSlots.clear();
                }
                else {
                    this.resetDrag();
                }
            }
            else if (this.dragEvent == 1) {
                final Slot lllllllllllllIllIIlIlIlllIIlIlll = this.inventorySlots.get(lllllllllllllIllIIlIlIllIlllIIIl);
                final ItemStack lllllllllllllIllIIlIlIlllIIlIllI = lllllllllllllIllIIlIlIlllIIllIIl.getItemStack();
                if (lllllllllllllIllIIlIlIlllIIlIlll != null && canAddItemToSlot(lllllllllllllIllIIlIlIlllIIlIlll, lllllllllllllIllIIlIlIlllIIlIllI, true) && lllllllllllllIllIIlIlIlllIIlIlll.isItemValid(lllllllllllllIllIIlIlIlllIIlIllI) && (this.dragMode == 2 || lllllllllllllIllIIlIlIlllIIlIllI.func_190916_E() > this.dragSlots.size()) && this.canDragIntoSlot(lllllllllllllIllIIlIlIlllIIlIlll)) {
                    this.dragSlots.add(lllllllllllllIllIIlIlIlllIIlIlll);
                }
            }
            else if (this.dragEvent == 2) {
                if (!this.dragSlots.isEmpty()) {
                    final ItemStack lllllllllllllIllIIlIlIlllIIlIlIl = lllllllllllllIllIIlIlIlllIIllIIl.getItemStack().copy();
                    int lllllllllllllIllIIlIlIlllIIlIlII = lllllllllllllIllIIlIlIlllIIllIIl.getItemStack().func_190916_E();
                    for (final Slot lllllllllllllIllIIlIlIlllIIlIIll : this.dragSlots) {
                        final ItemStack lllllllllllllIllIIlIlIlllIIlIIlI = lllllllllllllIllIIlIlIlllIIllIIl.getItemStack();
                        if (lllllllllllllIllIIlIlIlllIIlIIll != null && canAddItemToSlot(lllllllllllllIllIIlIlIlllIIlIIll, lllllllllllllIllIIlIlIlllIIlIIlI, true) && lllllllllllllIllIIlIlIlllIIlIIll.isItemValid(lllllllllllllIllIIlIlIlllIIlIIlI) && (this.dragMode == 2 || lllllllllllllIllIIlIlIlllIIlIIlI.func_190916_E() >= this.dragSlots.size()) && this.canDragIntoSlot(lllllllllllllIllIIlIlIlllIIlIIll)) {
                            final ItemStack lllllllllllllIllIIlIlIlllIIlIIIl = lllllllllllllIllIIlIlIlllIIlIlIl.copy();
                            final int lllllllllllllIllIIlIlIlllIIlIIII = lllllllllllllIllIIlIlIlllIIlIIll.getHasStack() ? lllllllllllllIllIIlIlIlllIIlIIll.getStack().func_190916_E() : 0;
                            computeStackSize(this.dragSlots, this.dragMode, lllllllllllllIllIIlIlIlllIIlIIIl, lllllllllllllIllIIlIlIlllIIlIIII);
                            final int lllllllllllllIllIIlIlIlllIIIllll = Math.min(lllllllllllllIllIIlIlIlllIIlIIIl.getMaxStackSize(), lllllllllllllIllIIlIlIlllIIlIIll.getItemStackLimit(lllllllllllllIllIIlIlIlllIIlIIIl));
                            if (lllllllllllllIllIIlIlIlllIIlIIIl.func_190916_E() > lllllllllllllIllIIlIlIlllIIIllll) {
                                lllllllllllllIllIIlIlIlllIIlIIIl.func_190920_e(lllllllllllllIllIIlIlIlllIIIllll);
                            }
                            lllllllllllllIllIIlIlIlllIIlIlII -= lllllllllllllIllIIlIlIlllIIlIIIl.func_190916_E() - lllllllllllllIllIIlIlIlllIIlIIII;
                            lllllllllllllIllIIlIlIlllIIlIIll.putStack(lllllllllllllIllIIlIlIlllIIlIIIl);
                        }
                    }
                    lllllllllllllIllIIlIlIlllIIlIlIl.func_190920_e(lllllllllllllIllIIlIlIlllIIlIlII);
                    lllllllllllllIllIIlIlIlllIIllIIl.setItemStack(lllllllllllllIllIIlIlIlllIIlIlIl);
                }
                this.resetDrag();
            }
            else {
                this.resetDrag();
            }
        }
        else if (this.dragEvent != 0) {
            this.resetDrag();
        }
        else if ((lllllllllllllIllIIlIlIllIllIllll == ClickType.PICKUP || lllllllllllllIllIIlIlIllIllIllll == ClickType.QUICK_MOVE) && (lllllllllllllIllIIlIlIlllIIlllIl == 0 || lllllllllllllIllIIlIlIlllIIlllIl == 1)) {
            if (lllllllllllllIllIIlIlIllIlllIIIl == -999) {
                if (!lllllllllllllIllIIlIlIlllIIllIIl.getItemStack().func_190926_b()) {
                    if (lllllllllllllIllIIlIlIlllIIlllIl == 0) {
                        lllllllllllllIllIIlIlIllIllIlllI.dropItem(lllllllllllllIllIIlIlIlllIIllIIl.getItemStack(), true);
                        lllllllllllllIllIIlIlIlllIIllIIl.setItemStack(ItemStack.field_190927_a);
                    }
                    if (lllllllllllllIllIIlIlIlllIIlllIl == 1) {
                        lllllllllllllIllIIlIlIllIllIlllI.dropItem(lllllllllllllIllIIlIlIlllIIllIIl.getItemStack().splitStack(1), true);
                    }
                }
            }
            else if (lllllllllllllIllIIlIlIllIllIllll == ClickType.QUICK_MOVE) {
                if (lllllllllllllIllIIlIlIllIlllIIIl < 0) {
                    return ItemStack.field_190927_a;
                }
                final Slot lllllllllllllIllIIlIlIlllIIIlllI = this.inventorySlots.get(lllllllllllllIllIIlIlIllIlllIIIl);
                if (lllllllllllllIllIIlIlIlllIIIlllI == null || !lllllllllllllIllIIlIlIlllIIIlllI.canTakeStack(lllllllllllllIllIIlIlIllIllIlllI)) {
                    return ItemStack.field_190927_a;
                }
                for (ItemStack lllllllllllllIllIIlIlIlllIIIllIl = this.transferStackInSlot(lllllllllllllIllIIlIlIllIllIlllI, lllllllllllllIllIIlIlIllIlllIIIl); !lllllllllllllIllIIlIlIlllIIIllIl.func_190926_b(); lllllllllllllIllIIlIlIlllIIIllIl = this.transferStackInSlot(lllllllllllllIllIIlIlIllIllIlllI, lllllllllllllIllIIlIlIllIlllIIIl)) {
                    if (!ItemStack.areItemsEqual(lllllllllllllIllIIlIlIlllIIIlllI.getStack(), lllllllllllllIllIIlIlIlllIIIllIl)) {
                        break;
                    }
                    lllllllllllllIllIIlIlIlllIIllIlI = lllllllllllllIllIIlIlIlllIIIllIl.copy();
                }
            }
            else {
                if (lllllllllllllIllIIlIlIllIlllIIIl < 0) {
                    return ItemStack.field_190927_a;
                }
                final Slot lllllllllllllIllIIlIlIlllIIIllII = this.inventorySlots.get(lllllllllllllIllIIlIlIllIlllIIIl);
                if (lllllllllllllIllIIlIlIlllIIIllII != null) {
                    ItemStack lllllllllllllIllIIlIlIlllIIIlIll = lllllllllllllIllIIlIlIlllIIIllII.getStack();
                    final ItemStack lllllllllllllIllIIlIlIlllIIIlIlI = lllllllllllllIllIIlIlIlllIIllIIl.getItemStack();
                    if (!lllllllllllllIllIIlIlIlllIIIlIll.func_190926_b()) {
                        lllllllllllllIllIIlIlIlllIIllIlI = lllllllllllllIllIIlIlIlllIIIlIll.copy();
                    }
                    if (lllllllllllllIllIIlIlIlllIIIlIll.func_190926_b()) {
                        if (!lllllllllllllIllIIlIlIlllIIIlIlI.func_190926_b() && lllllllllllllIllIIlIlIlllIIIllII.isItemValid(lllllllllllllIllIIlIlIlllIIIlIlI)) {
                            int lllllllllllllIllIIlIlIlllIIIlIIl = (lllllllllllllIllIIlIlIlllIIlllIl == 0) ? lllllllllllllIllIIlIlIlllIIIlIlI.func_190916_E() : 1;
                            if (lllllllllllllIllIIlIlIlllIIIlIIl > lllllllllllllIllIIlIlIlllIIIllII.getItemStackLimit(lllllllllllllIllIIlIlIlllIIIlIlI)) {
                                lllllllllllllIllIIlIlIlllIIIlIIl = lllllllllllllIllIIlIlIlllIIIllII.getItemStackLimit(lllllllllllllIllIIlIlIlllIIIlIlI);
                            }
                            lllllllllllllIllIIlIlIlllIIIllII.putStack(lllllllllllllIllIIlIlIlllIIIlIlI.splitStack(lllllllllllllIllIIlIlIlllIIIlIIl));
                        }
                    }
                    else if (lllllllllllllIllIIlIlIlllIIIllII.canTakeStack(lllllllllllllIllIIlIlIllIllIlllI)) {
                        if (lllllllllllllIllIIlIlIlllIIIlIlI.func_190926_b()) {
                            if (lllllllllllllIllIIlIlIlllIIIlIll.func_190926_b()) {
                                lllllllllllllIllIIlIlIlllIIIllII.putStack(ItemStack.field_190927_a);
                                lllllllllllllIllIIlIlIlllIIllIIl.setItemStack(ItemStack.field_190927_a);
                            }
                            else {
                                final int lllllllllllllIllIIlIlIlllIIIlIII = (lllllllllllllIllIIlIlIlllIIlllIl == 0) ? lllllllllllllIllIIlIlIlllIIIlIll.func_190916_E() : ((lllllllllllllIllIIlIlIlllIIIlIll.func_190916_E() + 1) / 2);
                                lllllllllllllIllIIlIlIlllIIllIIl.setItemStack(lllllllllllllIllIIlIlIlllIIIllII.decrStackSize(lllllllllllllIllIIlIlIlllIIIlIII));
                                if (lllllllllllllIllIIlIlIlllIIIlIll.func_190926_b()) {
                                    lllllllllllllIllIIlIlIlllIIIllII.putStack(ItemStack.field_190927_a);
                                }
                                lllllllllllllIllIIlIlIlllIIIllII.func_190901_a(lllllllllllllIllIIlIlIllIllIlllI, lllllllllllllIllIIlIlIlllIIllIIl.getItemStack());
                            }
                        }
                        else if (lllllllllllllIllIIlIlIlllIIIllII.isItemValid(lllllllllllllIllIIlIlIlllIIIlIlI)) {
                            if (lllllllllllllIllIIlIlIlllIIIlIll.getItem() == lllllllllllllIllIIlIlIlllIIIlIlI.getItem() && lllllllllllllIllIIlIlIlllIIIlIll.getMetadata() == lllllllllllllIllIIlIlIlllIIIlIlI.getMetadata() && ItemStack.areItemStackTagsEqual(lllllllllllllIllIIlIlIlllIIIlIll, lllllllllllllIllIIlIlIlllIIIlIlI)) {
                                int lllllllllllllIllIIlIlIlllIIIIlll = (lllllllllllllIllIIlIlIlllIIlllIl == 0) ? lllllllllllllIllIIlIlIlllIIIlIlI.func_190916_E() : 1;
                                if (lllllllllllllIllIIlIlIlllIIIIlll > lllllllllllllIllIIlIlIlllIIIllII.getItemStackLimit(lllllllllllllIllIIlIlIlllIIIlIlI) - lllllllllllllIllIIlIlIlllIIIlIll.func_190916_E()) {
                                    lllllllllllllIllIIlIlIlllIIIIlll = lllllllllllllIllIIlIlIlllIIIllII.getItemStackLimit(lllllllllllllIllIIlIlIlllIIIlIlI) - lllllllllllllIllIIlIlIlllIIIlIll.func_190916_E();
                                }
                                if (lllllllllllllIllIIlIlIlllIIIIlll > lllllllllllllIllIIlIlIlllIIIlIlI.getMaxStackSize() - lllllllllllllIllIIlIlIlllIIIlIll.func_190916_E()) {
                                    lllllllllllllIllIIlIlIlllIIIIlll = lllllllllllllIllIIlIlIlllIIIlIlI.getMaxStackSize() - lllllllllllllIllIIlIlIlllIIIlIll.func_190916_E();
                                }
                                lllllllllllllIllIIlIlIlllIIIlIlI.func_190918_g(lllllllllllllIllIIlIlIlllIIIIlll);
                                lllllllllllllIllIIlIlIlllIIIlIll.func_190917_f(lllllllllllllIllIIlIlIlllIIIIlll);
                            }
                            else if (lllllllllllllIllIIlIlIlllIIIlIlI.func_190916_E() <= lllllllllllllIllIIlIlIlllIIIllII.getItemStackLimit(lllllllllllllIllIIlIlIlllIIIlIlI)) {
                                lllllllllllllIllIIlIlIlllIIIllII.putStack(lllllllllllllIllIIlIlIlllIIIlIlI);
                                lllllllllllllIllIIlIlIlllIIllIIl.setItemStack(lllllllllllllIllIIlIlIlllIIIlIll);
                            }
                        }
                        else if (lllllllllllllIllIIlIlIlllIIIlIll.getItem() == lllllllllllllIllIIlIlIlllIIIlIlI.getItem() && lllllllllllllIllIIlIlIlllIIIlIlI.getMaxStackSize() > 1 && (!lllllllllllllIllIIlIlIlllIIIlIll.getHasSubtypes() || lllllllllllllIllIIlIlIlllIIIlIll.getMetadata() == lllllllllllllIllIIlIlIlllIIIlIlI.getMetadata()) && ItemStack.areItemStackTagsEqual(lllllllllllllIllIIlIlIlllIIIlIll, lllllllllllllIllIIlIlIlllIIIlIlI) && !lllllllllllllIllIIlIlIlllIIIlIll.func_190926_b()) {
                            final int lllllllllllllIllIIlIlIlllIIIIllI = lllllllllllllIllIIlIlIlllIIIlIll.func_190916_E();
                            if (lllllllllllllIllIIlIlIlllIIIIllI + lllllllllllllIllIIlIlIlllIIIlIlI.func_190916_E() <= lllllllllllllIllIIlIlIlllIIIlIlI.getMaxStackSize()) {
                                lllllllllllllIllIIlIlIlllIIIlIlI.func_190917_f(lllllllllllllIllIIlIlIlllIIIIllI);
                                lllllllllllllIllIIlIlIlllIIIlIll = lllllllllllllIllIIlIlIlllIIIllII.decrStackSize(lllllllllllllIllIIlIlIlllIIIIllI);
                                if (lllllllllllllIllIIlIlIlllIIIlIll.func_190926_b()) {
                                    lllllllllllllIllIIlIlIlllIIIllII.putStack(ItemStack.field_190927_a);
                                }
                                lllllllllllllIllIIlIlIlllIIIllII.func_190901_a(lllllllllllllIllIIlIlIllIllIlllI, lllllllllllllIllIIlIlIlllIIllIIl.getItemStack());
                            }
                        }
                    }
                    lllllllllllllIllIIlIlIlllIIIllII.onSlotChanged();
                }
            }
        }
        else if (lllllllllllllIllIIlIlIllIllIllll == ClickType.SWAP && lllllllllllllIllIIlIlIlllIIlllIl >= 0 && lllllllllllllIllIIlIlIlllIIlllIl < 9) {
            final Slot lllllllllllllIllIIlIlIlllIIIIlIl = this.inventorySlots.get(lllllllllllllIllIIlIlIllIlllIIIl);
            final ItemStack lllllllllllllIllIIlIlIlllIIIIlII = lllllllllllllIllIIlIlIlllIIllIIl.getStackInSlot(lllllllllllllIllIIlIlIlllIIlllIl);
            final ItemStack lllllllllllllIllIIlIlIlllIIIIIll = lllllllllllllIllIIlIlIlllIIIIlIl.getStack();
            if (!lllllllllllllIllIIlIlIlllIIIIlII.func_190926_b() || !lllllllllllllIllIIlIlIlllIIIIIll.func_190926_b()) {
                if (lllllllllllllIllIIlIlIlllIIIIlII.func_190926_b()) {
                    if (lllllllllllllIllIIlIlIlllIIIIlIl.canTakeStack(lllllllllllllIllIIlIlIllIllIlllI)) {
                        lllllllllllllIllIIlIlIlllIIllIIl.setInventorySlotContents(lllllllllllllIllIIlIlIlllIIlllIl, lllllllllllllIllIIlIlIlllIIIIIll);
                        lllllllllllllIllIIlIlIlllIIIIlIl.func_190900_b(lllllllllllllIllIIlIlIlllIIIIIll.func_190916_E());
                        lllllllllllllIllIIlIlIlllIIIIlIl.putStack(ItemStack.field_190927_a);
                        lllllllllllllIllIIlIlIlllIIIIlIl.func_190901_a(lllllllllllllIllIIlIlIllIllIlllI, lllllllllllllIllIIlIlIlllIIIIIll);
                    }
                }
                else if (lllllllllllllIllIIlIlIlllIIIIIll.func_190926_b()) {
                    if (lllllllllllllIllIIlIlIlllIIIIlIl.isItemValid(lllllllllllllIllIIlIlIlllIIIIlII)) {
                        final int lllllllllllllIllIIlIlIlllIIIIIlI = lllllllllllllIllIIlIlIlllIIIIlIl.getItemStackLimit(lllllllllllllIllIIlIlIlllIIIIlII);
                        if (lllllllllllllIllIIlIlIlllIIIIlII.func_190916_E() > lllllllllllllIllIIlIlIlllIIIIIlI) {
                            lllllllllllllIllIIlIlIlllIIIIlIl.putStack(lllllllllllllIllIIlIlIlllIIIIlII.splitStack(lllllllllllllIllIIlIlIlllIIIIIlI));
                        }
                        else {
                            lllllllllllllIllIIlIlIlllIIIIlIl.putStack(lllllllllllllIllIIlIlIlllIIIIlII);
                            lllllllllllllIllIIlIlIlllIIllIIl.setInventorySlotContents(lllllllllllllIllIIlIlIlllIIlllIl, ItemStack.field_190927_a);
                        }
                    }
                }
                else if (lllllllllllllIllIIlIlIlllIIIIlIl.canTakeStack(lllllllllllllIllIIlIlIllIllIlllI) && lllllllllllllIllIIlIlIlllIIIIlIl.isItemValid(lllllllllllllIllIIlIlIlllIIIIlII)) {
                    final int lllllllllllllIllIIlIlIlllIIIIIIl = lllllllllllllIllIIlIlIlllIIIIlIl.getItemStackLimit(lllllllllllllIllIIlIlIlllIIIIlII);
                    if (lllllllllllllIllIIlIlIlllIIIIlII.func_190916_E() > lllllllllllllIllIIlIlIlllIIIIIIl) {
                        lllllllllllllIllIIlIlIlllIIIIlIl.putStack(lllllllllllllIllIIlIlIlllIIIIlII.splitStack(lllllllllllllIllIIlIlIlllIIIIIIl));
                        lllllllllllllIllIIlIlIlllIIIIlIl.func_190901_a(lllllllllllllIllIIlIlIllIllIlllI, lllllllllllllIllIIlIlIlllIIIIIll);
                        if (!lllllllllllllIllIIlIlIlllIIllIIl.addItemStackToInventory(lllllllllllllIllIIlIlIlllIIIIIll)) {
                            lllllllllllllIllIIlIlIllIllIlllI.dropItem(lllllllllllllIllIIlIlIlllIIIIIll, true);
                        }
                    }
                    else {
                        lllllllllllllIllIIlIlIlllIIIIlIl.putStack(lllllllllllllIllIIlIlIlllIIIIlII);
                        lllllllllllllIllIIlIlIlllIIllIIl.setInventorySlotContents(lllllllllllllIllIIlIlIlllIIlllIl, lllllllllllllIllIIlIlIlllIIIIIll);
                        lllllllllllllIllIIlIlIlllIIIIlIl.func_190901_a(lllllllllllllIllIIlIlIllIllIlllI, lllllllllllllIllIIlIlIlllIIIIIll);
                    }
                }
            }
        }
        else if (lllllllllllllIllIIlIlIllIllIllll == ClickType.CLONE && lllllllllllllIllIIlIlIllIllIlllI.capabilities.isCreativeMode && lllllllllllllIllIIlIlIlllIIllIIl.getItemStack().func_190926_b() && lllllllllllllIllIIlIlIllIlllIIIl >= 0) {
            final Slot lllllllllllllIllIIlIlIlllIIIIIII = this.inventorySlots.get(lllllllllllllIllIIlIlIllIlllIIIl);
            if (lllllllllllllIllIIlIlIlllIIIIIII != null && lllllllllllllIllIIlIlIlllIIIIIII.getHasStack()) {
                final ItemStack lllllllllllllIllIIlIlIllIlllllll = lllllllllllllIllIIlIlIlllIIIIIII.getStack().copy();
                lllllllllllllIllIIlIlIllIlllllll.func_190920_e(lllllllllllllIllIIlIlIllIlllllll.getMaxStackSize());
                lllllllllllllIllIIlIlIlllIIllIIl.setItemStack(lllllllllllllIllIIlIlIllIlllllll);
            }
        }
        else if (lllllllllllllIllIIlIlIllIllIllll == ClickType.THROW && lllllllllllllIllIIlIlIlllIIllIIl.getItemStack().func_190926_b() && lllllllllllllIllIIlIlIllIlllIIIl >= 0) {
            final Slot lllllllllllllIllIIlIlIllIllllllI = this.inventorySlots.get(lllllllllllllIllIIlIlIllIlllIIIl);
            if (lllllllllllllIllIIlIlIllIllllllI != null && lllllllllllllIllIIlIlIllIllllllI.getHasStack() && lllllllllllllIllIIlIlIllIllllllI.canTakeStack(lllllllllllllIllIIlIlIllIllIlllI)) {
                final ItemStack lllllllllllllIllIIlIlIllIlllllIl = lllllllllllllIllIIlIlIllIllllllI.decrStackSize((lllllllllllllIllIIlIlIlllIIlllIl == 0) ? 1 : lllllllllllllIllIIlIlIllIllllllI.getStack().func_190916_E());
                lllllllllllllIllIIlIlIllIllllllI.func_190901_a(lllllllllllllIllIIlIlIllIllIlllI, lllllllllllllIllIIlIlIllIlllllIl);
                lllllllllllllIllIIlIlIllIllIlllI.dropItem(lllllllllllllIllIIlIlIllIlllllIl, true);
            }
        }
        else if (lllllllllllllIllIIlIlIllIllIllll == ClickType.PICKUP_ALL && lllllllllllllIllIIlIlIllIlllIIIl >= 0) {
            final Slot lllllllllllllIllIIlIlIllIlllllII = this.inventorySlots.get(lllllllllllllIllIIlIlIllIlllIIIl);
            final ItemStack lllllllllllllIllIIlIlIllIllllIll = lllllllllllllIllIIlIlIlllIIllIIl.getItemStack();
            if (!lllllllllllllIllIIlIlIllIllllIll.func_190926_b() && (lllllllllllllIllIIlIlIllIlllllII == null || !lllllllllllllIllIIlIlIllIlllllII.getHasStack() || !lllllllllllllIllIIlIlIllIlllllII.canTakeStack(lllllllllllllIllIIlIlIllIllIlllI))) {
                final int lllllllllllllIllIIlIlIllIllllIlI = (lllllllllllllIllIIlIlIlllIIlllIl == 0) ? 0 : (this.inventorySlots.size() - 1);
                final int lllllllllllllIllIIlIlIllIllllIIl = (lllllllllllllIllIIlIlIlllIIlllIl == 0) ? 1 : -1;
                for (int lllllllllllllIllIIlIlIllIllllIII = 0; lllllllllllllIllIIlIlIllIllllIII < 2; ++lllllllllllllIllIIlIlIllIllllIII) {
                    for (int lllllllllllllIllIIlIlIllIlllIlll = lllllllllllllIllIIlIlIllIllllIlI; lllllllllllllIllIIlIlIllIlllIlll >= 0 && lllllllllllllIllIIlIlIllIlllIlll < this.inventorySlots.size() && lllllllllllllIllIIlIlIllIllllIll.func_190916_E() < lllllllllllllIllIIlIlIllIllllIll.getMaxStackSize(); lllllllllllllIllIIlIlIllIlllIlll += lllllllllllllIllIIlIlIllIllllIIl) {
                        final Slot lllllllllllllIllIIlIlIllIlllIllI = this.inventorySlots.get(lllllllllllllIllIIlIlIllIlllIlll);
                        if (lllllllllllllIllIIlIlIllIlllIllI.getHasStack() && canAddItemToSlot(lllllllllllllIllIIlIlIllIlllIllI, lllllllllllllIllIIlIlIllIllllIll, true) && lllllllllllllIllIIlIlIllIlllIllI.canTakeStack(lllllllllllllIllIIlIlIllIllIlllI) && this.canMergeSlot(lllllllllllllIllIIlIlIllIllllIll, lllllllllllllIllIIlIlIllIlllIllI)) {
                            final ItemStack lllllllllllllIllIIlIlIllIlllIlIl = lllllllllllllIllIIlIlIllIlllIllI.getStack();
                            if (lllllllllllllIllIIlIlIllIllllIII != 0 || lllllllllllllIllIIlIlIllIlllIlIl.func_190916_E() != lllllllllllllIllIIlIlIllIlllIlIl.getMaxStackSize()) {
                                final int lllllllllllllIllIIlIlIllIlllIlII = Math.min(lllllllllllllIllIIlIlIllIllllIll.getMaxStackSize() - lllllllllllllIllIIlIlIllIllllIll.func_190916_E(), lllllllllllllIllIIlIlIllIlllIlIl.func_190916_E());
                                final ItemStack lllllllllllllIllIIlIlIllIlllIIll = lllllllllllllIllIIlIlIllIlllIllI.decrStackSize(lllllllllllllIllIIlIlIllIlllIlII);
                                lllllllllllllIllIIlIlIllIllllIll.func_190917_f(lllllllllllllIllIIlIlIllIlllIlII);
                                if (lllllllllllllIllIIlIlIllIlllIIll.func_190926_b()) {
                                    lllllllllllllIllIIlIlIllIlllIllI.putStack(ItemStack.field_190927_a);
                                }
                                lllllllllllllIllIIlIlIllIlllIllI.func_190901_a(lllllllllllllIllIIlIlIllIllIlllI, lllllllllllllIllIIlIlIllIlllIIll);
                            }
                        }
                    }
                }
            }
            this.detectAndSendChanges();
        }
        return lllllllllllllIllIIlIlIlllIIllIlI;
    }
    
    public static int calcRedstoneFromInventory(@Nullable final IInventory lllllllllllllIllIIlIlIlIllIIIllI) {
        if (lllllllllllllIllIIlIlIlIllIIIllI == null) {
            return 0;
        }
        int lllllllllllllIllIIlIlIlIllIIIlIl = 0;
        float lllllllllllllIllIIlIlIlIllIIIlII = 0.0f;
        for (int lllllllllllllIllIIlIlIlIllIIIIll = 0; lllllllllllllIllIIlIlIlIllIIIIll < lllllllllllllIllIIlIlIlIllIIIllI.getSizeInventory(); ++lllllllllllllIllIIlIlIlIllIIIIll) {
            final ItemStack lllllllllllllIllIIlIlIlIllIIIIlI = lllllllllllllIllIIlIlIlIllIIIllI.getStackInSlot(lllllllllllllIllIIlIlIlIllIIIIll);
            if (!lllllllllllllIllIIlIlIlIllIIIIlI.func_190926_b()) {
                lllllllllllllIllIIlIlIlIllIIIlII += lllllllllllllIllIIlIlIlIllIIIIlI.func_190916_E() / (float)Math.min(lllllllllllllIllIIlIlIlIllIIIllI.getInventoryStackLimit(), lllllllllllllIllIIlIlIlIllIIIIlI.getMaxStackSize());
                ++lllllllllllllIllIIlIlIlIllIIIlIl;
            }
        }
        lllllllllllllIllIIlIlIlIllIIIlII /= lllllllllllllIllIIlIlIlIllIIIllI.getSizeInventory();
        return MathHelper.floor(lllllllllllllIllIIlIlIlIllIIIlII * 14.0f) + ((lllllllllllllIllIIlIlIlIllIIIlIl > 0) ? 1 : 0);
    }
    
    public abstract boolean canInteractWith(final EntityPlayer p0);
    
    public static boolean isValidDragMode(final int lllllllllllllIllIIlIlIlIlllIllll, final EntityPlayer lllllllllllllIllIIlIlIlIlllIlllI) {
        return lllllllllllllIllIIlIlIlIlllIllll == 0 || lllllllllllllIllIIlIlIlIlllIllll == 1 || (lllllllllllllIllIIlIlIlIlllIllll == 2 && lllllllllllllIllIIlIlIlIlllIlllI.capabilities.isCreativeMode);
    }
    
    public void onContainerClosed(final EntityPlayer lllllllllllllIllIIlIlIllIlIllIll) {
        final InventoryPlayer lllllllllllllIllIIlIlIllIlIllIlI = lllllllllllllIllIIlIlIllIlIllIll.inventory;
        if (!lllllllllllllIllIIlIlIllIlIllIlI.getItemStack().func_190926_b()) {
            lllllllllllllIllIIlIlIllIlIllIll.dropItem(lllllllllllllIllIIlIlIllIlIllIlI.getItemStack(), false);
            lllllllllllllIllIIlIlIllIlIllIlI.setItemStack(ItemStack.field_190927_a);
        }
    }
    
    public boolean getCanCraft(final EntityPlayer lllllllllllllIllIIlIlIllIIlIIlll) {
        return !this.playerList.contains(lllllllllllllIllIIlIlIllIIlIIlll);
    }
    
    public Slot getSlot(final int lllllllllllllIllIIlIlIlllIlllIll) {
        return this.inventorySlots.get(lllllllllllllIllIIlIlIlllIlllIll);
    }
    
    public void putStackInSlot(final int lllllllllllllIllIIlIlIllIlIIIIIl, final ItemStack lllllllllllllIllIIlIlIllIIllllIl) {
        this.getSlot(lllllllllllllIllIIlIlIllIlIIIIIl).putStack(lllllllllllllIllIIlIlIllIIllllIl);
    }
    
    public boolean enchantItem(final EntityPlayer lllllllllllllIllIIlIlIllllIlIIIl, final int lllllllllllllIllIIlIlIllllIlIIII) {
        return false;
    }
    
    protected void func_193327_a(final EntityPlayer lllllllllllllIllIIlIlIllIlIIllIl, final World lllllllllllllIllIIlIlIllIlIIllII, final IInventory lllllllllllllIllIIlIlIllIlIIlIll) {
        if (!lllllllllllllIllIIlIlIllIlIIllIl.isEntityAlive() || (lllllllllllllIllIIlIlIllIlIIllIl instanceof EntityPlayerMP && ((EntityPlayerMP)lllllllllllllIllIIlIlIllIlIIllIl).func_193105_t())) {
            for (int lllllllllllllIllIIlIlIllIlIIllll = 0; lllllllllllllIllIIlIlIllIlIIllll < lllllllllllllIllIIlIlIllIlIIlIll.getSizeInventory(); ++lllllllllllllIllIIlIlIllIlIIllll) {
                lllllllllllllIllIIlIlIllIlIIllIl.dropItem(lllllllllllllIllIIlIlIllIlIIlIll.removeStackFromSlot(lllllllllllllIllIIlIlIllIlIIllll), false);
            }
        }
        else {
            for (int lllllllllllllIllIIlIlIllIlIIlllI = 0; lllllllllllllIllIIlIlIllIlIIlllI < lllllllllllllIllIIlIlIllIlIIlIll.getSizeInventory(); ++lllllllllllllIllIIlIlIllIlIIlllI) {
                lllllllllllllIllIIlIlIllIlIIllIl.inventory.func_191975_a(lllllllllllllIllIIlIlIllIlIIllII, lllllllllllllIllIIlIlIllIlIIlIll.removeStackFromSlot(lllllllllllllIllIIlIlIllIlIIlllI));
            }
        }
    }
    
    public void func_190896_a(final List<ItemStack> lllllllllllllIllIIlIlIllIIllIlIl) {
        for (int lllllllllllllIllIIlIlIllIIllIlll = 0; lllllllllllllIllIIlIlIllIIllIlll < lllllllllllllIllIIlIlIllIIllIlIl.size(); ++lllllllllllllIllIIlIlIllIIllIlll) {
            this.getSlot(lllllllllllllIllIIlIlIllIIllIlll).putStack(lllllllllllllIllIIlIlIllIIllIlIl.get(lllllllllllllIllIIlIlIllIIllIlll));
        }
    }
    
    public NonNullList<ItemStack> getInventory() {
        final NonNullList<ItemStack> lllllllllllllIllIIlIlIlllllIIllI = NonNullList.func_191196_a();
        for (int lllllllllllllIllIIlIlIlllllIIlIl = 0; lllllllllllllIllIIlIlIlllllIIlIl < this.inventorySlots.size(); ++lllllllllllllIllIIlIlIlllllIIlIl) {
            lllllllllllllIllIIlIlIlllllIIllI.add(this.inventorySlots.get(lllllllllllllIllIIlIlIlllllIIlIl).getStack());
        }
        return lllllllllllllIllIIlIlIlllllIIllI;
    }
    
    public static int getDragEvent(final int lllllllllllllIllIIlIlIlIlllllIII) {
        return lllllllllllllIllIIlIlIlIlllllIII & 0x3;
    }
    
    protected boolean mergeItemStack(final ItemStack lllllllllllllIllIIlIlIllIIIlIIlI, final int lllllllllllllIllIIlIlIllIIIlIIIl, final int lllllllllllllIllIIlIlIllIIIIIlII, final boolean lllllllllllllIllIIlIlIllIIIIllll) {
        boolean lllllllllllllIllIIlIlIllIIIIlllI = false;
        int lllllllllllllIllIIlIlIllIIIIllIl = lllllllllllllIllIIlIlIllIIIlIIIl;
        if (lllllllllllllIllIIlIlIllIIIIllll) {
            lllllllllllllIllIIlIlIllIIIIllIl = lllllllllllllIllIIlIlIllIIIIIlII - 1;
        }
        if (lllllllllllllIllIIlIlIllIIIlIIlI.isStackable()) {
            while (!lllllllllllllIllIIlIlIllIIIlIIlI.func_190926_b()) {
                if (lllllllllllllIllIIlIlIllIIIIllll) {
                    if (lllllllllllllIllIIlIlIllIIIIllIl < lllllllllllllIllIIlIlIllIIIlIIIl) {
                        break;
                    }
                }
                else if (lllllllllllllIllIIlIlIllIIIIllIl >= lllllllllllllIllIIlIlIllIIIIIlII) {
                    break;
                }
                final Slot lllllllllllllIllIIlIlIllIIIIllII = this.inventorySlots.get(lllllllllllllIllIIlIlIllIIIIllIl);
                final ItemStack lllllllllllllIllIIlIlIllIIIIlIll = lllllllllllllIllIIlIlIllIIIIllII.getStack();
                if (!lllllllllllllIllIIlIlIllIIIIlIll.func_190926_b() && lllllllllllllIllIIlIlIllIIIIlIll.getItem() == lllllllllllllIllIIlIlIllIIIlIIlI.getItem() && (!lllllllllllllIllIIlIlIllIIIlIIlI.getHasSubtypes() || lllllllllllllIllIIlIlIllIIIlIIlI.getMetadata() == lllllllllllllIllIIlIlIllIIIIlIll.getMetadata()) && ItemStack.areItemStackTagsEqual(lllllllllllllIllIIlIlIllIIIlIIlI, lllllllllllllIllIIlIlIllIIIIlIll)) {
                    final int lllllllllllllIllIIlIlIllIIIIlIlI = lllllllllllllIllIIlIlIllIIIIlIll.func_190916_E() + lllllllllllllIllIIlIlIllIIIlIIlI.func_190916_E();
                    if (lllllllllllllIllIIlIlIllIIIIlIlI <= lllllllllllllIllIIlIlIllIIIlIIlI.getMaxStackSize()) {
                        lllllllllllllIllIIlIlIllIIIlIIlI.func_190920_e(0);
                        lllllllllllllIllIIlIlIllIIIIlIll.func_190920_e(lllllllllllllIllIIlIlIllIIIIlIlI);
                        lllllllllllllIllIIlIlIllIIIIllII.onSlotChanged();
                        lllllllllllllIllIIlIlIllIIIIlllI = true;
                    }
                    else if (lllllllllllllIllIIlIlIllIIIIlIll.func_190916_E() < lllllllllllllIllIIlIlIllIIIlIIlI.getMaxStackSize()) {
                        lllllllllllllIllIIlIlIllIIIlIIlI.func_190918_g(lllllllllllllIllIIlIlIllIIIlIIlI.getMaxStackSize() - lllllllllllllIllIIlIlIllIIIIlIll.func_190916_E());
                        lllllllllllllIllIIlIlIllIIIIlIll.func_190920_e(lllllllllllllIllIIlIlIllIIIlIIlI.getMaxStackSize());
                        lllllllllllllIllIIlIlIllIIIIllII.onSlotChanged();
                        lllllllllllllIllIIlIlIllIIIIlllI = true;
                    }
                }
                if (lllllllllllllIllIIlIlIllIIIIllll) {
                    --lllllllllllllIllIIlIlIllIIIIllIl;
                }
                else {
                    ++lllllllllllllIllIIlIlIllIIIIllIl;
                }
            }
        }
        if (!lllllllllllllIllIIlIlIllIIIlIIlI.func_190926_b()) {
            if (lllllllllllllIllIIlIlIllIIIIllll) {
                lllllllllllllIllIIlIlIllIIIIllIl = lllllllllllllIllIIlIlIllIIIIIlII - 1;
            }
            else {
                lllllllllllllIllIIlIlIllIIIIllIl = lllllllllllllIllIIlIlIllIIIlIIIl;
            }
            while (true) {
                if (lllllllllllllIllIIlIlIllIIIIllll) {
                    if (lllllllllllllIllIIlIlIllIIIIllIl < lllllllllllllIllIIlIlIllIIIlIIIl) {
                        break;
                    }
                }
                else if (lllllllllllllIllIIlIlIllIIIIllIl >= lllllllllllllIllIIlIlIllIIIIIlII) {
                    break;
                }
                final Slot lllllllllllllIllIIlIlIllIIIIlIIl = this.inventorySlots.get(lllllllllllllIllIIlIlIllIIIIllIl);
                final ItemStack lllllllllllllIllIIlIlIllIIIIlIII = lllllllllllllIllIIlIlIllIIIIlIIl.getStack();
                if (lllllllllllllIllIIlIlIllIIIIlIII.func_190926_b() && lllllllllllllIllIIlIlIllIIIIlIIl.isItemValid(lllllllllllllIllIIlIlIllIIIlIIlI)) {
                    if (lllllllllllllIllIIlIlIllIIIlIIlI.func_190916_E() > lllllllllllllIllIIlIlIllIIIIlIIl.getSlotStackLimit()) {
                        lllllllllllllIllIIlIlIllIIIIlIIl.putStack(lllllllllllllIllIIlIlIllIIIlIIlI.splitStack(lllllllllllllIllIIlIlIllIIIIlIIl.getSlotStackLimit()));
                    }
                    else {
                        lllllllllllllIllIIlIlIllIIIIlIIl.putStack(lllllllllllllIllIIlIlIllIIIlIIlI.splitStack(lllllllllllllIllIIlIlIllIIIlIIlI.func_190916_E()));
                    }
                    lllllllllllllIllIIlIlIllIIIIlIIl.onSlotChanged();
                    lllllllllllllIllIIlIlIllIIIIlllI = true;
                    break;
                }
                if (lllllllllllllIllIIlIlIllIIIIllll) {
                    --lllllllllllllIllIIlIlIllIIIIllIl;
                }
                else {
                    ++lllllllllllllIllIIlIlIllIIIIllIl;
                }
            }
        }
        return lllllllllllllIllIIlIlIllIIIIlllI;
    }
    
    public void addListener(final IContainerListener lllllllllllllIllIIlIlIllllllIIIl) {
        if (this.listeners.contains(lllllllllllllIllIIlIlIllllllIIIl)) {
            throw new IllegalArgumentException("Listener already listening");
        }
        this.listeners.add(lllllllllllllIllIIlIlIllllllIIIl);
        lllllllllllllIllIIlIlIllllllIIIl.updateCraftingInventory(this, this.getInventory());
        this.detectAndSendChanges();
    }
    
    public static int calcRedstone(@Nullable final TileEntity lllllllllllllIllIIlIlIlIllIIllII) {
        return (lllllllllllllIllIIlIlIlIllIIllII instanceof IInventory) ? calcRedstoneFromInventory((IInventory)lllllllllllllIllIIlIlIlIllIIllII) : 0;
    }
    
    protected void func_192389_a(final World lllllllllllllIllIIlIlIlIlIllIIll, final EntityPlayer lllllllllllllIllIIlIlIlIlIlIlIlI, final InventoryCrafting lllllllllllllIllIIlIlIlIlIllIIIl, final InventoryCraftResult lllllllllllllIllIIlIlIlIlIlIlIII) {
        if (!lllllllllllllIllIIlIlIlIlIllIIll.isRemote) {
            final EntityPlayerMP lllllllllllllIllIIlIlIlIlIlIllll = (EntityPlayerMP)lllllllllllllIllIIlIlIlIlIlIlIlI;
            ItemStack lllllllllllllIllIIlIlIlIlIlIlllI = ItemStack.field_190927_a;
            final IRecipe lllllllllllllIllIIlIlIlIlIlIllIl = CraftingManager.func_192413_b(lllllllllllllIllIIlIlIlIlIllIIIl, lllllllllllllIllIIlIlIlIlIllIIll);
            if (lllllllllllllIllIIlIlIlIlIlIllIl != null && (lllllllllllllIllIIlIlIlIlIlIllIl.func_192399_d() || !lllllllllllllIllIIlIlIlIlIllIIll.getGameRules().getBoolean("doLimitedCrafting") || lllllllllllllIllIIlIlIlIlIlIllll.func_192037_E().func_193830_f(lllllllllllllIllIIlIlIlIlIlIllIl))) {
                lllllllllllllIllIIlIlIlIlIlIlIII.func_193056_a(lllllllllllllIllIIlIlIlIlIlIllIl);
                lllllllllllllIllIIlIlIlIlIlIlllI = lllllllllllllIllIIlIlIlIlIlIllIl.getCraftingResult(lllllllllllllIllIIlIlIlIlIllIIIl);
            }
            lllllllllllllIllIIlIlIlIlIlIlIII.setInventorySlotContents(0, lllllllllllllIllIIlIlIlIlIlIlllI);
            lllllllllllllIllIIlIlIlIlIlIllll.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, lllllllllllllIllIIlIlIlIlIlIlllI));
        }
    }
    
    @Nullable
    public Slot getSlotFromInventory(final IInventory lllllllllllllIllIIlIlIllllIIlIIl, final int lllllllllllllIllIIlIlIllllIIlIII) {
        for (int lllllllllllllIllIIlIlIllllIIIlll = 0; lllllllllllllIllIIlIlIllllIIIlll < this.inventorySlots.size(); ++lllllllllllllIllIIlIlIllllIIIlll) {
            final Slot lllllllllllllIllIIlIlIllllIIIllI = this.inventorySlots.get(lllllllllllllIllIIlIlIllllIIIlll);
            if (lllllllllllllIllIIlIlIllllIIIllI.isHere(lllllllllllllIllIIlIlIllllIIlIIl, lllllllllllllIllIIlIlIllllIIlIII)) {
                return lllllllllllllIllIIlIlIllllIIIllI;
            }
        }
        return null;
    }
    
    public short getNextTransactionID(final InventoryPlayer lllllllllllllIllIIlIlIllIIlIlllI) {
        ++this.transactionID;
        return this.transactionID;
    }
    
    public static boolean canAddItemToSlot(@Nullable final Slot lllllllllllllIllIIlIlIlIlllIIlII, final ItemStack lllllllllllllIllIIlIlIlIlllIIIll, final boolean lllllllllllllIllIIlIlIlIllIllllI) {
        final boolean lllllllllllllIllIIlIlIlIlllIIIIl = lllllllllllllIllIIlIlIlIlllIIlII == null || !lllllllllllllIllIIlIlIlIlllIIlII.getHasStack();
        if (!lllllllllllllIllIIlIlIlIlllIIIIl && lllllllllllllIllIIlIlIlIlllIIIll.isItemEqual(lllllllllllllIllIIlIlIlIlllIIlII.getStack()) && ItemStack.areItemStackTagsEqual(lllllllllllllIllIIlIlIlIlllIIlII.getStack(), lllllllllllllIllIIlIlIlIlllIIIll)) {
            return lllllllllllllIllIIlIlIlIlllIIlII.getStack().func_190916_E() + (lllllllllllllIllIIlIlIlIllIllllI ? 0 : lllllllllllllIllIIlIlIlIlllIIIll.func_190916_E()) <= lllllllllllllIllIIlIlIlIlllIIIll.getMaxStackSize();
        }
        return lllllllllllllIllIIlIlIlIlllIIIIl;
    }
    
    public void removeListener(final IContainerListener lllllllllllllIllIIlIlIlllllIlIll) {
        this.listeners.remove(lllllllllllllIllIIlIlIlllllIlIll);
    }
    
    public boolean canDragIntoSlot(final Slot lllllllllllllIllIIlIlIlIllIIllll) {
        return true;
    }
    
    protected Slot addSlotToContainer(final Slot lllllllllllllIllIIlIlIlllllllIIl) {
        lllllllllllllIllIIlIlIlllllllIIl.slotNumber = this.inventorySlots.size();
        this.inventorySlots.add(lllllllllllllIllIIlIlIlllllllIIl);
        this.inventoryItemStacks.add(ItemStack.field_190927_a);
        return lllllllllllllIllIIlIlIlllllllIIl;
    }
    
    public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllIllIIlIlIlllIllIllI, final int lllllllllllllIllIIlIlIlllIllIlIl) {
        final Slot lllllllllllllIllIIlIlIlllIllIlII = this.inventorySlots.get(lllllllllllllIllIIlIlIlllIllIlIl);
        return (lllllllllllllIllIIlIlIlllIllIlII != null) ? lllllllllllllIllIIlIlIlllIllIlII.getStack() : ItemStack.field_190927_a;
    }
    
    public Container() {
        this.inventoryItemStacks = NonNullList.func_191196_a();
        this.inventorySlots = (List<Slot>)Lists.newArrayList();
        this.dragMode = -1;
        this.dragSlots = (Set<Slot>)Sets.newHashSet();
        this.listeners = (List<IContainerListener>)Lists.newArrayList();
        this.playerList = (Set<EntityPlayer>)Sets.newHashSet();
    }
    
    public static int getQuickcraftMask(final int lllllllllllllIllIIlIlIlIllllIlIl, final int lllllllllllllIllIIlIlIlIllllIlII) {
        return (lllllllllllllIllIIlIlIlIllllIlIl & 0x3) | (lllllllllllllIllIIlIlIlIllllIlII & 0x3) << 2;
    }
    
    public void detectAndSendChanges() {
        for (int lllllllllllllIllIIlIlIllllIllIll = 0; lllllllllllllIllIIlIlIllllIllIll < this.inventorySlots.size(); ++lllllllllllllIllIIlIlIllllIllIll) {
            final ItemStack lllllllllllllIllIIlIlIllllIllIlI = this.inventorySlots.get(lllllllllllllIllIIlIlIllllIllIll).getStack();
            ItemStack lllllllllllllIllIIlIlIllllIllIIl = this.inventoryItemStacks.get(lllllllllllllIllIIlIlIllllIllIll);
            if (!ItemStack.areItemStacksEqual(lllllllllllllIllIIlIlIllllIllIIl, lllllllllllllIllIIlIlIllllIllIlI)) {
                lllllllllllllIllIIlIlIllllIllIIl = (lllllllllllllIllIIlIlIllllIllIlI.func_190926_b() ? ItemStack.field_190927_a : lllllllllllllIllIIlIlIllllIllIlI.copy());
                this.inventoryItemStacks.set(lllllllllllllIllIIlIlIllllIllIll, lllllllllllllIllIIlIlIllllIllIIl);
                for (int lllllllllllllIllIIlIlIllllIllIII = 0; lllllllllllllIllIIlIlIllllIllIII < this.listeners.size(); ++lllllllllllllIllIIlIlIllllIllIII) {
                    this.listeners.get(lllllllllllllIllIIlIlIllllIllIII).sendSlotContents(this, lllllllllllllIllIIlIlIllllIllIll, lllllllllllllIllIIlIlIllllIllIIl);
                }
            }
        }
    }
}
