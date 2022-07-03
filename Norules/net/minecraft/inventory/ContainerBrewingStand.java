package net.minecraft.inventory;

import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;

public class ContainerBrewingStand extends Container
{
    private final /* synthetic */ Slot theSlot;
    private /* synthetic */ int prevFuel;
    private /* synthetic */ int prevBrewTime;
    private final /* synthetic */ IInventory tileBrewingStand;
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int llllllllllllllllllIlIlIlllIIlIlI = 0; llllllllllllllllllIlIlIlllIIlIlI < this.listeners.size(); ++llllllllllllllllllIlIlIlllIIlIlI) {
            final IContainerListener llllllllllllllllllIlIlIlllIIlIIl = this.listeners.get(llllllllllllllllllIlIlIlllIIlIlI);
            if (this.prevBrewTime != this.tileBrewingStand.getField(0)) {
                llllllllllllllllllIlIlIlllIIlIIl.sendProgressBarUpdate(this, 0, this.tileBrewingStand.getField(0));
            }
            if (this.prevFuel != this.tileBrewingStand.getField(1)) {
                llllllllllllllllllIlIlIlllIIlIIl.sendProgressBarUpdate(this, 1, this.tileBrewingStand.getField(1));
            }
        }
        this.prevBrewTime = this.tileBrewingStand.getField(0);
        this.prevFuel = this.tileBrewingStand.getField(1);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllllllIlIlIllIlllIIl) {
        return this.tileBrewingStand.isUsableByPlayer(llllllllllllllllllIlIlIllIlllIIl);
    }
    
    @Override
    public void updateProgressBar(final int llllllllllllllllllIlIlIllIlllllI, final int llllllllllllllllllIlIlIllIllllIl) {
        this.tileBrewingStand.setField(llllllllllllllllllIlIlIllIlllllI, llllllllllllllllllIlIlIllIllllIl);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllllllIlIlIllIlIlIIl, final int llllllllllllllllllIlIlIllIlIlllI) {
        ItemStack llllllllllllllllllIlIlIllIlIllIl = ItemStack.field_190927_a;
        final Slot llllllllllllllllllIlIlIllIlIllII = this.inventorySlots.get(llllllllllllllllllIlIlIllIlIlllI);
        if (llllllllllllllllllIlIlIllIlIllII != null && llllllllllllllllllIlIlIllIlIllII.getHasStack()) {
            final ItemStack llllllllllllllllllIlIlIllIlIlIll = llllllllllllllllllIlIlIllIlIllII.getStack();
            llllllllllllllllllIlIlIllIlIllIl = llllllllllllllllllIlIlIllIlIlIll.copy();
            if ((llllllllllllllllllIlIlIllIlIlllI < 0 || llllllllllllllllllIlIlIllIlIlllI > 2) && llllllllllllllllllIlIlIllIlIlllI != 3 && llllllllllllllllllIlIlIllIlIlllI != 4) {
                if (this.theSlot.isItemValid(llllllllllllllllllIlIlIllIlIlIll)) {
                    if (!this.mergeItemStack(llllllllllllllllllIlIlIllIlIlIll, 3, 4, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (Potion.canHoldPotion(llllllllllllllllllIlIlIllIlIllIl) && llllllllllllllllllIlIlIllIlIllIl.func_190916_E() == 1) {
                    if (!this.mergeItemStack(llllllllllllllllllIlIlIllIlIlIll, 0, 3, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (Fuel.isValidBrewingFuel(llllllllllllllllllIlIlIllIlIllIl)) {
                    if (!this.mergeItemStack(llllllllllllllllllIlIlIllIlIlIll, 4, 5, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (llllllllllllllllllIlIlIllIlIlllI >= 5 && llllllllllllllllllIlIlIllIlIlllI < 32) {
                    if (!this.mergeItemStack(llllllllllllllllllIlIlIllIlIlIll, 32, 41, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (llllllllllllllllllIlIlIllIlIlllI >= 32 && llllllllllllllllllIlIlIllIlIlllI < 41) {
                    if (!this.mergeItemStack(llllllllllllllllllIlIlIllIlIlIll, 5, 32, false)) {
                        return ItemStack.field_190927_a;
                    }
                }
                else if (!this.mergeItemStack(llllllllllllllllllIlIlIllIlIlIll, 5, 41, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else {
                if (!this.mergeItemStack(llllllllllllllllllIlIlIllIlIlIll, 5, 41, true)) {
                    return ItemStack.field_190927_a;
                }
                llllllllllllllllllIlIlIllIlIllII.onSlotChange(llllllllllllllllllIlIlIllIlIlIll, llllllllllllllllllIlIlIllIlIllIl);
            }
            if (llllllllllllllllllIlIlIllIlIlIll.func_190926_b()) {
                llllllllllllllllllIlIlIllIlIllII.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllllllllIlIlIllIlIllII.onSlotChanged();
            }
            if (llllllllllllllllllIlIlIllIlIlIll.func_190916_E() == llllllllllllllllllIlIlIllIlIllIl.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            llllllllllllllllllIlIlIllIlIllII.func_190901_a(llllllllllllllllllIlIlIllIlIlIIl, llllllllllllllllllIlIlIllIlIlIll);
        }
        return llllllllllllllllllIlIlIllIlIllIl;
    }
    
    public ContainerBrewingStand(final InventoryPlayer llllllllllllllllllIlIlIlllIllllI, final IInventory llllllllllllllllllIlIlIlllIlIlll) {
        this.tileBrewingStand = llllllllllllllllllIlIlIlllIlIlll;
        this.addSlotToContainer(new Potion(llllllllllllllllllIlIlIlllIlIlll, 0, 56, 51));
        this.addSlotToContainer(new Potion(llllllllllllllllllIlIlIlllIlIlll, 1, 79, 58));
        this.addSlotToContainer(new Potion(llllllllllllllllllIlIlIlllIlIlll, 2, 102, 51));
        this.theSlot = this.addSlotToContainer(new Ingredient(llllllllllllllllllIlIlIlllIlIlll, 3, 79, 17));
        this.addSlotToContainer(new Fuel(llllllllllllllllllIlIlIlllIlIlll, 4, 17, 17));
        for (int llllllllllllllllllIlIlIlllIlllII = 0; llllllllllllllllllIlIlIlllIlllII < 3; ++llllllllllllllllllIlIlIlllIlllII) {
            for (int llllllllllllllllllIlIlIlllIllIll = 0; llllllllllllllllllIlIlIlllIllIll < 9; ++llllllllllllllllllIlIlIlllIllIll) {
                this.addSlotToContainer(new Slot(llllllllllllllllllIlIlIlllIllllI, llllllllllllllllllIlIlIlllIllIll + llllllllllllllllllIlIlIlllIlllII * 9 + 9, 8 + llllllllllllllllllIlIlIlllIllIll * 18, 84 + llllllllllllllllllIlIlIlllIlllII * 18));
            }
        }
        for (int llllllllllllllllllIlIlIlllIllIlI = 0; llllllllllllllllllIlIlIlllIllIlI < 9; ++llllllllllllllllllIlIlIlllIllIlI) {
            this.addSlotToContainer(new Slot(llllllllllllllllllIlIlIlllIllllI, llllllllllllllllllIlIlIlllIllIlI, 8 + llllllllllllllllllIlIlIlllIllIlI * 18, 142));
        }
    }
    
    @Override
    public void addListener(final IContainerListener llllllllllllllllllIlIlIlllIIllll) {
        super.addListener(llllllllllllllllllIlIlIlllIIllll);
        llllllllllllllllllIlIlIlllIIllll.sendAllWindowProperties(this, this.tileBrewingStand);
    }
    
    static class Fuel extends Slot
    {
        @Override
        public int getSlotStackLimit() {
            return 64;
        }
        
        public static boolean isValidBrewingFuel(final ItemStack lllllllllllllIllIlIIIIllIlIllIII) {
            return lllllllllllllIllIlIIIIllIlIllIII.getItem() == Items.BLAZE_POWDER;
        }
        
        @Override
        public boolean isItemValid(final ItemStack lllllllllllllIllIlIIIIllIlIllIlI) {
            return isValidBrewingFuel(lllllllllllllIllIlIIIIllIlIllIlI);
        }
        
        public Fuel(final IInventory lllllllllllllIllIlIIIIllIllIIllI, final int lllllllllllllIllIlIIIIllIllIIlIl, final int lllllllllllllIllIlIIIIllIlIlllll, final int lllllllllllllIllIlIIIIllIlIllllI) {
            super(lllllllllllllIllIlIIIIllIllIIllI, lllllllllllllIllIlIIIIllIllIIlIl, lllllllllllllIllIlIIIIllIlIlllll, lllllllllllllIllIlIIIIllIlIllllI);
        }
    }
    
    static class Potion extends Slot
    {
        @Override
        public int getSlotStackLimit() {
            return 1;
        }
        
        public Potion(final IInventory lllllllllllllIIlIIIIlIlllIIIlllI, final int lllllllllllllIIlIIIIlIlllIIIlIII, final int lllllllllllllIIlIIIIlIlllIIIllII, final int lllllllllllllIIlIIIIlIlllIIIIllI) {
            super(lllllllllllllIIlIIIIlIlllIIIlllI, lllllllllllllIIlIIIIlIlllIIIlIII, lllllllllllllIIlIIIIlIlllIIIllII, lllllllllllllIIlIIIIlIlllIIIIllI);
        }
        
        @Override
        public ItemStack func_190901_a(final EntityPlayer lllllllllllllIIlIIIIlIllIlllIlll, final ItemStack lllllllllllllIIlIIIIlIllIllllIlI) {
            final PotionType lllllllllllllIIlIIIIlIllIllllIIl = PotionUtils.getPotionFromItem(lllllllllllllIIlIIIIlIllIllllIlI);
            if (lllllllllllllIIlIIIIlIllIlllIlll instanceof EntityPlayerMP) {
                CriteriaTriggers.field_192130_j.func_192173_a((EntityPlayerMP)lllllllllllllIIlIIIIlIllIlllIlll, lllllllllllllIIlIIIIlIllIllllIIl);
            }
            super.func_190901_a(lllllllllllllIIlIIIIlIllIlllIlll, lllllllllllllIIlIIIIlIllIllllIlI);
            return lllllllllllllIIlIIIIlIllIllllIlI;
        }
        
        public static boolean canHoldPotion(final ItemStack lllllllllllllIIlIIIIlIllIlllIIlI) {
            final Item lllllllllllllIIlIIIIlIllIlllIIIl = lllllllllllllIIlIIIIlIllIlllIIlI.getItem();
            return lllllllllllllIIlIIIIlIllIlllIIIl == Items.POTIONITEM || lllllllllllllIIlIIIIlIllIlllIIIl == Items.SPLASH_POTION || lllllllllllllIIlIIIIlIllIlllIIIl == Items.LINGERING_POTION || lllllllllllllIIlIIIIlIllIlllIIIl == Items.GLASS_BOTTLE;
        }
        
        @Override
        public boolean isItemValid(final ItemStack lllllllllllllIIlIIIIlIlllIIIIIlI) {
            return canHoldPotion(lllllllllllllIIlIIIIlIlllIIIIIlI);
        }
    }
    
    static class Ingredient extends Slot
    {
        @Override
        public int getSlotStackLimit() {
            return 64;
        }
        
        @Override
        public boolean isItemValid(final ItemStack llllllllllllllIlIllIIllllIlIIllI) {
            return PotionHelper.isReagent(llllllllllllllIlIllIIllllIlIIllI);
        }
        
        public Ingredient(final IInventory llllllllllllllIlIllIIllllIllIIlI, final int llllllllllllllIlIllIIllllIllIIIl, final int llllllllllllllIlIllIIllllIlIlIll, final int llllllllllllllIlIllIIllllIlIllll) {
            super(llllllllllllllIlIllIIllllIllIIlI, llllllllllllllIlIllIIllllIllIIIl, llllllllllllllIlIllIIllllIlIlIll, llllllllllllllIlIllIIllllIlIllll);
        }
    }
}
