package net.minecraft.inventory;

import net.minecraft.item.crafting.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.util.text.*;

public class InventoryCraftResult implements IInventory
{
    private /* synthetic */ IRecipe field_193057_b;
    private final /* synthetic */ NonNullList<ItemStack> stackResult;
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public void markDirty() {
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllllIlIIIIlIIIIllllIlII) {
        return true;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public int getSizeInventory() {
        return 1;
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllllIlIIIIlIIIlIIIIIIII) {
        return ItemStackHelper.getAndRemove(this.stackResult, 0);
    }
    
    @Nullable
    public IRecipe func_193055_i() {
        return this.field_193057_b;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllIlIIIIlIIIIlllIlllI, final ItemStack lllllllllllllIlIIIIlIIIIlllIllIl) {
        return true;
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllIlIIIIlIIIIllllIIlI) {
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    public void func_193056_a(@Nullable final IRecipe lllllllllllllIlIIIIlIIIIllIllllI) {
        this.field_193057_b = lllllllllllllIlIIIIlIIIIllIllllI;
    }
    
    @Override
    public String getName() {
        return "Result";
    }
    
    @Override
    public void setField(final int lllllllllllllIlIIIIlIIIIlllIlIIl, final int lllllllllllllIlIIIIlIIIIlllIlIII) {
    }
    
    @Override
    public void clear() {
        this.stackResult.clear();
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllIlIIIIlIIIlIIIlIlII : this.stackResult) {
            if (!lllllllllllllIlIIIIlIIIlIIIlIlII.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public InventoryCraftResult() {
        this.stackResult = NonNullList.func_191197_a(1, ItemStack.field_190927_a);
    }
    
    @Override
    public int getField(final int lllllllllllllIlIIIIlIIIIlllIlIll) {
        return 0;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllIlIIIIlIIIIllllIIII) {
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllIlIIIIlIIIIlllllIll, final ItemStack lllllllllllllIlIIIIlIIIIlllllIII) {
        this.stackResult.set(0, lllllllllllllIlIIIIlIIIIlllllIII);
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIlIIIIlIIIlIIIIIlIl, final int lllllllllllllIlIIIIlIIIlIIIIIlII) {
        return ItemStackHelper.getAndRemove(this.stackResult, 0);
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllIlIIIIlIIIlIIIIlllI) {
        return this.stackResult.get(0);
    }
}
