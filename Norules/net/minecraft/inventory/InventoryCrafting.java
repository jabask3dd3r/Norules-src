package net.minecraft.inventory;

import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.client.util.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.*;

public class InventoryCrafting implements IInventory
{
    private final /* synthetic */ int inventoryWidth;
    private final /* synthetic */ NonNullList<ItemStack> stackList;
    private final /* synthetic */ int inventoryHeight;
    private final /* synthetic */ Container eventHandler;
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllIIIIlIllllIllllllll, final ItemStack lllllllllllllIIIIlIllllIlllllllI) {
        this.stackList.set(lllllllllllllIIIIlIllllIllllllll, lllllllllllllIIIIlIllllIlllllllI);
        this.eventHandler.onCraftMatrixChanged(this);
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    public void func_194018_a(final RecipeItemHelper lllllllllllllIIIIlIllllIllIllllI) {
        for (final ItemStack lllllllllllllIIIIlIllllIllIlllIl : this.stackList) {
            lllllllllllllIIIIlIllllIllIllllI.func_194112_a(lllllllllllllIIIIlIllllIllIlllIl);
        }
    }
    
    public ItemStack getStackInRowAndColumn(final int lllllllllllllIIIIlIlllllIIlIIIlI, final int lllllllllllllIIIIlIlllllIIIllllI) {
        return (lllllllllllllIIIIlIlllllIIlIIIlI >= 0 && lllllllllllllIIIIlIlllllIIlIIIlI < this.inventoryWidth && lllllllllllllIIIIlIlllllIIIllllI >= 0 && lllllllllllllIIIIlIlllllIIIllllI <= this.inventoryHeight) ? this.getStackInSlot(lllllllllllllIIIIlIlllllIIlIIIlI + lllllllllllllIIIIlIlllllIIIllllI * this.inventoryWidth) : ItemStack.field_190927_a;
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIIIIlIlllllIIIIlIIl, final int lllllllllllllIIIIlIlllllIIIIlIII) {
        final ItemStack lllllllllllllIIIIlIlllllIIIIlIll = ItemStackHelper.getAndSplit(this.stackList, lllllllllllllIIIIlIlllllIIIIlIIl, lllllllllllllIIIIlIlllllIIIIlIII);
        if (!lllllllllllllIIIIlIlllllIIIIlIll.func_190926_b()) {
            this.eventHandler.onCraftMatrixChanged(this);
        }
        return lllllllllllllIIIIlIlllllIIIIlIll;
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllIIIIlIlllllIIlIlIIl) {
        return (lllllllllllllIIIIlIlllllIIlIlIIl >= this.getSizeInventory()) ? ItemStack.field_190927_a : this.stackList.get(lllllllllllllIIIIlIlllllIIlIlIIl);
    }
    
    @Override
    public void clear() {
        this.stackList.clear();
    }
    
    @Override
    public void setField(final int lllllllllllllIIIIlIllllIlllIllll, final int lllllllllllllIIIIlIllllIlllIlllI) {
    }
    
    public int getHeight() {
        return this.inventoryHeight;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllIIIIlIllllIllllIlII, final ItemStack lllllllllllllIIIIlIllllIllllIIll) {
        return true;
    }
    
    public int getWidth() {
        return this.inventoryWidth;
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllIIIIlIlllllIIllIIII : this.stackList) {
            if (!lllllllllllllIIIIlIlllllIIllIIII.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void markDirty() {
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllllIIIIlIlllllIIIlIIll) {
        return ItemStackHelper.getAndRemove(this.stackList, lllllllllllllIIIIlIlllllIIIlIIll);
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    @Override
    public int getField(final int lllllllllllllIIIIlIllllIllllIIIl) {
        return 0;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllIIIIlIllllIllllIllI) {
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllIIIIlIllllIlllllIII) {
    }
    
    @Override
    public String getName() {
        return "container.crafting";
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllllIIIIlIllllIlllllIlI) {
        return true;
    }
    
    public InventoryCrafting(final Container lllllllllllllIIIIlIlllllIIlllllI, final int lllllllllllllIIIIlIlllllIIlllIIl, final int lllllllllllllIIIIlIlllllIIlllIII) {
        this.stackList = NonNullList.func_191197_a(lllllllllllllIIIIlIlllllIIlllIIl * lllllllllllllIIIIlIlllllIIlllIII, ItemStack.field_190927_a);
        this.eventHandler = lllllllllllllIIIIlIlllllIIlllllI;
        this.inventoryWidth = lllllllllllllIIIIlIlllllIIlllIIl;
        this.inventoryHeight = lllllllllllllIIIIlIlllllIIlllIII;
    }
    
    @Override
    public int getSizeInventory() {
        return this.stackList.size();
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
}
