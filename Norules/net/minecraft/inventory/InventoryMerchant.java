package net.minecraft.inventory;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import java.util.*;
import net.minecraft.village.*;

public class InventoryMerchant implements IInventory
{
    private final /* synthetic */ IMerchant theMerchant;
    private /* synthetic */ MerchantRecipe currentRecipe;
    private final /* synthetic */ EntityPlayer thePlayer;
    private final /* synthetic */ NonNullList<ItemStack> theInventory;
    private /* synthetic */ int currentRecipeIndex;
    
    private boolean inventoryResetNeededOnSlotChange(final int lllllllllllllIlllIlIIlIlIlIlIIII) {
        return lllllllllllllIlllIlIIlIlIlIlIIII == 0 || lllllllllllllIlllIlIIlIlIlIlIIII == 1;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    public MerchantRecipe getCurrentRecipe() {
        return this.currentRecipe;
    }
    
    @Override
    public void markDirty() {
        this.resetRecipeAndSlots();
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllIlllIlIIlIlIllIIlII) {
        return this.theInventory.get(lllllllllllllIlllIlIIlIlIllIIlII);
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public int getSizeInventory() {
        return this.theInventory.size();
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllIlllIlIIlIlIIllIIlI) {
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllIlllIlIIlIlIlIIIIIl, final ItemStack lllllllllllllIlllIlIIlIlIlIIIIll) {
        this.theInventory.set(lllllllllllllIlllIlIIlIlIlIIIIIl, lllllllllllllIlllIlIIlIlIlIIIIll);
        if (!lllllllllllllIlllIlIIlIlIlIIIIll.func_190926_b() && lllllllllllllIlllIlIIlIlIlIIIIll.func_190916_E() > this.getInventoryStackLimit()) {
            lllllllllllllIlllIlIIlIlIlIIIIll.func_190920_e(this.getInventoryStackLimit());
        }
        if (this.inventoryResetNeededOnSlotChange(lllllllllllllIlllIlIIlIlIlIIIIIl)) {
            this.resetRecipeAndSlots();
        }
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIlllIlIIlIlIlIllIll, final int lllllllllllllIlllIlIIlIlIlIllIlI) {
        final ItemStack lllllllllllllIlllIlIIlIlIlIllIIl = this.theInventory.get(lllllllllllllIlllIlIIlIlIlIllIll);
        if (lllllllllllllIlllIlIIlIlIlIllIll == 2 && !lllllllllllllIlllIlIIlIlIlIllIIl.func_190926_b()) {
            return ItemStackHelper.getAndSplit(this.theInventory, lllllllllllllIlllIlIIlIlIlIllIll, lllllllllllllIlllIlIIlIlIlIllIIl.func_190916_E());
        }
        final ItemStack lllllllllllllIlllIlIIlIlIlIllIII = ItemStackHelper.getAndSplit(this.theInventory, lllllllllllllIlllIlIIlIlIlIllIll, lllllllllllllIlllIlIIlIlIlIllIlI);
        if (!lllllllllllllIlllIlIIlIlIlIllIII.func_190926_b() && this.inventoryResetNeededOnSlotChange(lllllllllllllIlllIlIIlIlIlIllIll)) {
            this.resetRecipeAndSlots();
        }
        return lllllllllllllIlllIlIIlIlIlIllIII;
    }
    
    @Override
    public String getName() {
        return "mob.villager";
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllIlllIlIIlIlIllIlIll : this.theInventory) {
            if (!lllllllllllllIlllIlIIlIlIllIlIll.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllllIlllIlIIlIlIIllIlII) {
        return this.theMerchant.getCustomer() == lllllllllllllIlllIlIIlIlIIllIlII;
    }
    
    @Override
    public int getField(final int lllllllllllllIlllIlIIlIlIIIlIIII) {
        return 0;
    }
    
    public void setCurrentRecipeIndex(final int lllllllllllllIlllIlIIlIlIIIlIlII) {
        this.currentRecipeIndex = lllllllllllllIlllIlIIlIlIIIlIlII;
        this.resetRecipeAndSlots();
    }
    
    @Override
    public void clear() {
        this.theInventory.clear();
    }
    
    public void resetRecipeAndSlots() {
        this.currentRecipe = null;
        ItemStack lllllllllllllIlllIlIIlIlIIlIIIll = this.theInventory.get(0);
        ItemStack lllllllllllllIlllIlIIlIlIIlIIIlI = this.theInventory.get(1);
        if (lllllllllllllIlllIlIIlIlIIlIIIll.func_190926_b()) {
            lllllllllllllIlllIlIIlIlIIlIIIll = lllllllllllllIlllIlIIlIlIIlIIIlI;
            lllllllllllllIlllIlIIlIlIIlIIIlI = ItemStack.field_190927_a;
        }
        if (lllllllllllllIlllIlIIlIlIIlIIIll.func_190926_b()) {
            this.setInventorySlotContents(2, ItemStack.field_190927_a);
        }
        else {
            final MerchantRecipeList lllllllllllllIlllIlIIlIlIIlIIIIl = this.theMerchant.getRecipes(this.thePlayer);
            if (lllllllllllllIlllIlIIlIlIIlIIIIl != null) {
                MerchantRecipe lllllllllllllIlllIlIIlIlIIlIIIII = lllllllllllllIlllIlIIlIlIIlIIIIl.canRecipeBeUsed(lllllllllllllIlllIlIIlIlIIlIIIll, lllllllllllllIlllIlIIlIlIIlIIIlI, this.currentRecipeIndex);
                if (lllllllllllllIlllIlIIlIlIIlIIIII != null && !lllllllllllllIlllIlIIlIlIIlIIIII.isRecipeDisabled()) {
                    this.currentRecipe = lllllllllllllIlllIlIIlIlIIlIIIII;
                    this.setInventorySlotContents(2, lllllllllllllIlllIlIIlIlIIlIIIII.getItemToSell().copy());
                }
                else if (!lllllllllllllIlllIlIIlIlIIlIIIlI.func_190926_b()) {
                    lllllllllllllIlllIlIIlIlIIlIIIII = lllllllllllllIlllIlIIlIlIIlIIIIl.canRecipeBeUsed(lllllllllllllIlllIlIIlIlIIlIIIlI, lllllllllllllIlllIlIIlIlIIlIIIll, this.currentRecipeIndex);
                    if (lllllllllllllIlllIlIIlIlIIlIIIII != null && !lllllllllllllIlllIlIIlIlIIlIIIII.isRecipeDisabled()) {
                        this.currentRecipe = lllllllllllllIlllIlIIlIlIIlIIIII;
                        this.setInventorySlotContents(2, lllllllllllllIlllIlIIlIlIIlIIIII.getItemToSell().copy());
                    }
                    else {
                        this.setInventorySlotContents(2, ItemStack.field_190927_a);
                    }
                }
                else {
                    this.setInventorySlotContents(2, ItemStack.field_190927_a);
                }
            }
            this.theMerchant.verifySellingItem(this.getStackInSlot(2));
        }
    }
    
    public InventoryMerchant(final EntityPlayer lllllllllllllIlllIlIIlIlIlllIlll, final IMerchant lllllllllllllIlllIlIIlIlIlllIIll) {
        this.theInventory = NonNullList.func_191197_a(3, ItemStack.field_190927_a);
        this.thePlayer = lllllllllllllIlllIlIIlIlIlllIlll;
        this.theMerchant = lllllllllllllIlllIlIIlIlIlllIIll;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllIlllIlIIlIlIIlIlllI, final ItemStack lllllllllllllIlllIlIIlIlIIlIllIl) {
        return true;
    }
    
    @Override
    public void setField(final int lllllllllllllIlllIlIIlIlIIIIlllI, final int lllllllllllllIlllIlIIlIlIIIIllIl) {
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllllIlllIlIIlIlIlIIlIIl) {
        return ItemStackHelper.getAndRemove(this.theInventory, lllllllllllllIlllIlIIlIlIlIIlIIl);
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllIlllIlIIlIlIIllIIII) {
    }
}
