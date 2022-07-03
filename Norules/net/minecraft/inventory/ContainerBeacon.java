package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class ContainerBeacon extends Container
{
    private final /* synthetic */ BeaconSlot beaconSlot;
    private final /* synthetic */ IInventory tileBeacon;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllIIIlIlIllIIlllllIl, final int llllllllllllllIIIlIlIllIlIIIIIlI) {
        ItemStack llllllllllllllIIIlIlIllIlIIIIIIl = ItemStack.field_190927_a;
        final Slot llllllllllllllIIIlIlIllIlIIIIIII = this.inventorySlots.get(llllllllllllllIIIlIlIllIlIIIIIlI);
        if (llllllllllllllIIIlIlIllIlIIIIIII != null && llllllllllllllIIIlIlIllIlIIIIIII.getHasStack()) {
            final ItemStack llllllllllllllIIIlIlIllIIlllllll = llllllllllllllIIIlIlIllIlIIIIIII.getStack();
            llllllllllllllIIIlIlIllIlIIIIIIl = llllllllllllllIIIlIlIllIIlllllll.copy();
            if (llllllllllllllIIIlIlIllIlIIIIIlI == 0) {
                if (!this.mergeItemStack(llllllllllllllIIIlIlIllIIlllllll, 1, 37, true)) {
                    return ItemStack.field_190927_a;
                }
                llllllllllllllIIIlIlIllIlIIIIIII.onSlotChange(llllllllllllllIIIlIlIllIIlllllll, llllllllllllllIIIlIlIllIlIIIIIIl);
            }
            else if (!this.beaconSlot.getHasStack() && this.beaconSlot.isItemValid(llllllllllllllIIIlIlIllIIlllllll) && llllllllllllllIIIlIlIllIIlllllll.func_190916_E() == 1) {
                if (!this.mergeItemStack(llllllllllllllIIIlIlIllIIlllllll, 0, 1, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (llllllllllllllIIIlIlIllIlIIIIIlI >= 1 && llllllllllllllIIIlIlIllIlIIIIIlI < 28) {
                if (!this.mergeItemStack(llllllllllllllIIIlIlIllIIlllllll, 28, 37, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (llllllllllllllIIIlIlIllIlIIIIIlI >= 28 && llllllllllllllIIIlIlIllIlIIIIIlI < 37) {
                if (!this.mergeItemStack(llllllllllllllIIIlIlIllIIlllllll, 1, 28, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllIIIlIlIllIIlllllll, 1, 37, false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllllllIIIlIlIllIIlllllll.func_190926_b()) {
                llllllllllllllIIIlIlIllIlIIIIIII.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllllIIIlIlIllIlIIIIIII.onSlotChanged();
            }
            if (llllllllllllllIIIlIlIllIIlllllll.func_190916_E() == llllllllllllllIIIlIlIllIlIIIIIIl.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            llllllllllllllIIIlIlIllIlIIIIIII.func_190901_a(llllllllllllllIIIlIlIllIIlllllIl, llllllllllllllIIIlIlIllIIlllllll);
        }
        return llllllllllllllIIIlIlIllIlIIIIIIl;
    }
    
    public ContainerBeacon(final IInventory llllllllllllllIIIlIlIllIlIllllII, final IInventory llllllllllllllIIIlIlIllIlIlllIlI) {
        this.tileBeacon = llllllllllllllIIIlIlIllIlIlllIlI;
        this.beaconSlot = new BeaconSlot(llllllllllllllIIIlIlIllIlIlllIlI, 0, 136, 110);
        this.addSlotToContainer(this.beaconSlot);
        final int llllllllllllllIIIlIlIllIllIIlIII = 36;
        final int llllllllllllllIIIlIlIllIllIIIllI = 137;
        for (int llllllllllllllIIIlIlIllIllIIIlII = 0; llllllllllllllIIIlIlIllIllIIIlII < 3; ++llllllllllllllIIIlIlIllIllIIIlII) {
            for (int llllllllllllllIIIlIlIllIllIIIIlI = 0; llllllllllllllIIIlIlIllIllIIIIlI < 9; ++llllllllllllllIIIlIlIllIllIIIIlI) {
                this.addSlotToContainer(new Slot(llllllllllllllIIIlIlIllIlIllllII, llllllllllllllIIIlIlIllIllIIIIlI + llllllllllllllIIIlIlIllIllIIIlII * 9 + 9, 36 + llllllllllllllIIIlIlIllIllIIIIlI * 18, 137 + llllllllllllllIIIlIlIllIllIIIlII * 18));
            }
        }
        for (int llllllllllllllIIIlIlIllIllIIIIII = 0; llllllllllllllIIIlIlIllIllIIIIII < 9; ++llllllllllllllIIIlIlIllIllIIIIII) {
            this.addSlotToContainer(new Slot(llllllllllllllIIIlIlIllIlIllllII, llllllllllllllIIIlIlIllIllIIIIII, 36 + llllllllllllllIIIlIlIllIllIIIIII * 18, 195));
        }
    }
    
    @Override
    public void updateProgressBar(final int llllllllllllllIIIlIlIllIlIlIIIIl, final int llllllllllllllIIIlIlIllIlIIlllIl) {
        this.tileBeacon.setField(llllllllllllllIIIlIlIllIlIlIIIIl, llllllllllllllIIIlIlIllIlIIlllIl);
    }
    
    @Override
    public void addListener(final IContainerListener llllllllllllllIIIlIlIllIlIlIlIlI) {
        super.addListener(llllllllllllllIIIlIlIllIlIlIlIlI);
        llllllllllllllIIIlIlIllIlIlIlIlI.sendAllWindowProperties(this, this.tileBeacon);
    }
    
    public IInventory getTileEntity() {
        return this.tileBeacon;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllIIIlIlIllIlIIlIlIl) {
        super.onContainerClosed(llllllllllllllIIIlIlIllIlIIlIlIl);
        if (!llllllllllllllIIIlIlIllIlIIlIlIl.world.isRemote) {
            final ItemStack llllllllllllllIIIlIlIllIlIIlIlII = this.beaconSlot.decrStackSize(this.beaconSlot.getSlotStackLimit());
            if (!llllllllllllllIIIlIlIllIlIIlIlII.func_190926_b()) {
                llllllllllllllIIIlIlIllIlIIlIlIl.dropItem(llllllllllllllIIIlIlIllIlIIlIlII, false);
            }
        }
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllIIIlIlIllIlIIIlIll) {
        return this.tileBeacon.isUsableByPlayer(llllllllllllllIIIlIlIllIlIIIlIll);
    }
    
    class BeaconSlot extends Slot
    {
        @Override
        public int getSlotStackLimit() {
            return 1;
        }
        
        public BeaconSlot(final IInventory lllllllllllllIIlllllllIIIlIlIlII, final int lllllllllllllIIlllllllIIIlIllIIl, final int lllllllllllllIIlllllllIIIlIllIII, final int lllllllllllllIIlllllllIIIlIlIlll) {
            super(lllllllllllllIIlllllllIIIlIlIlII, lllllllllllllIIlllllllIIIlIllIIl, lllllllllllllIIlllllllIIIlIllIII, lllllllllllllIIlllllllIIIlIlIlll);
        }
        
        @Override
        public boolean isItemValid(final ItemStack lllllllllllllIIlllllllIIIlIIlIll) {
            final Item lllllllllllllIIlllllllIIIlIIllII = lllllllllllllIIlllllllIIIlIIlIll.getItem();
            return lllllllllllllIIlllllllIIIlIIllII == Items.EMERALD || lllllllllllllIIlllllllIIIlIIllII == Items.DIAMOND || lllllllllllllIIlllllllIIIlIIllII == Items.GOLD_INGOT || lllllllllllllIIlllllllIIIlIIllII == Items.IRON_INGOT;
        }
    }
}
