package net.minecraft.inventory;

import net.minecraft.util.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;

public class InventoryBasic implements IInventory
{
    private /* synthetic */ boolean hasCustomName;
    private final /* synthetic */ int slotsCount;
    private /* synthetic */ String inventoryTitle;
    private final /* synthetic */ NonNullList<ItemStack> inventoryContents;
    private /* synthetic */ List<IInventoryChangedListener> changeListeners;
    
    public void removeInventoryChangeListener(final IInventoryChangedListener llllllllllllllllIIIIlllIIlIllIII) {
        this.changeListeners.remove(llllllllllllllllIIIIlllIIlIllIII);
    }
    
    public InventoryBasic(final ITextComponent llllllllllllllllIIIIlllIIllIIllI, final int llllllllllllllllIIIIlllIIllIIlIl) {
        this(llllllllllllllllIIIIlllIIllIIllI.getUnformattedText(), true, llllllllllllllllIIIIlllIIllIIlIl);
    }
    
    public void setCustomName(final String llllllllllllllllIIIIlllIIIIIIllI) {
        this.hasCustomName = true;
        this.inventoryTitle = llllllllllllllllIIIIlllIIIIIIllI;
    }
    
    public InventoryBasic(final String llllllllllllllllIIIIlllIIllIllIl, final boolean llllllllllllllllIIIIlllIIlllIIII, final int llllllllllllllllIIIIlllIIllIlIll) {
        this.inventoryTitle = llllllllllllllllIIIIlllIIllIllIl;
        this.hasCustomName = llllllllllllllllIIIIlllIIlllIIII;
        this.slotsCount = llllllllllllllllIIIIlllIIllIlIll;
        this.inventoryContents = NonNullList.func_191197_a(llllllllllllllllIIIIlllIIllIlIll, ItemStack.field_190927_a);
    }
    
    @Override
    public void setField(final int llllllllllllllllIIIIllIllllIllll, final int llllllllllllllllIIIIllIllllIlllI) {
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllllIIIIllIlllllIllI) {
    }
    
    public ItemStack addItem(final ItemStack llllllllllllllllIIIIlllIIIlllIll) {
        final ItemStack llllllllllllllllIIIIlllIIIlllIlI = llllllllllllllllIIIIlllIIIlllIll.copy();
        for (int llllllllllllllllIIIIlllIIIlllIIl = 0; llllllllllllllllIIIIlllIIIlllIIl < this.slotsCount; ++llllllllllllllllIIIIlllIIIlllIIl) {
            final ItemStack llllllllllllllllIIIIlllIIIlllIII = this.getStackInSlot(llllllllllllllllIIIIlllIIIlllIIl);
            if (llllllllllllllllIIIIlllIIIlllIII.func_190926_b()) {
                this.setInventorySlotContents(llllllllllllllllIIIIlllIIIlllIIl, llllllllllllllllIIIIlllIIIlllIlI);
                this.markDirty();
                return ItemStack.field_190927_a;
            }
            if (ItemStack.areItemsEqual(llllllllllllllllIIIIlllIIIlllIII, llllllllllllllllIIIIlllIIIlllIlI)) {
                final int llllllllllllllllIIIIlllIIIllIlll = Math.min(this.getInventoryStackLimit(), llllllllllllllllIIIIlllIIIlllIII.getMaxStackSize());
                final int llllllllllllllllIIIIlllIIIllIllI = Math.min(llllllllllllllllIIIIlllIIIlllIlI.func_190916_E(), llllllllllllllllIIIIlllIIIllIlll - llllllllllllllllIIIIlllIIIlllIII.func_190916_E());
                if (llllllllllllllllIIIIlllIIIllIllI > 0) {
                    llllllllllllllllIIIIlllIIIlllIII.func_190917_f(llllllllllllllllIIIIlllIIIllIllI);
                    llllllllllllllllIIIIlllIIIlllIlI.func_190918_g(llllllllllllllllIIIIlllIIIllIllI);
                    if (llllllllllllllllIIIIlllIIIlllIlI.func_190926_b()) {
                        this.markDirty();
                        return ItemStack.field_190927_a;
                    }
                }
            }
        }
        if (llllllllllllllllIIIIlllIIIlllIlI.func_190916_E() != llllllllllllllllIIIIlllIIIlllIll.func_190916_E()) {
            this.markDirty();
        }
        return llllllllllllllllIIIIlllIIIlllIlI;
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.hasCustomName;
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllllIIIIllIllllllIII) {
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllllIIIIlllIIlIlIIlI) {
        return (llllllllllllllllIIIIlllIIlIlIIlI >= 0 && llllllllllllllllIIIIlllIIlIlIIlI < this.inventoryContents.size()) ? this.inventoryContents.get(llllllllllllllllIIIIlllIIlIlIIlI) : ItemStack.field_190927_a;
    }
    
    public void addInventoryChangeListener(final IInventoryChangedListener llllllllllllllllIIIIlllIIlIlllII) {
        if (this.changeListeners == null) {
            this.changeListeners = (List<IInventoryChangedListener>)Lists.newArrayList();
        }
        this.changeListeners.add(llllllllllllllllIIIIlllIIlIlllII);
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack llllllllllllllllIIIIlllIIIIlIlIl : this.inventoryContents) {
            if (!llllllllllllllllIIIIlllIIIIlIlIl.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer llllllllllllllllIIIIllIllllllIlI) {
        return true;
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllllIIIIlllIIIlIIIIl, final ItemStack llllllllllllllllIIIIlllIIIlIIIII) {
        this.inventoryContents.set(llllllllllllllllIIIIlllIIIlIIIIl, llllllllllllllllIIIIlllIIIlIIIII);
        if (!llllllllllllllllIIIIlllIIIlIIIII.func_190926_b() && llllllllllllllllIIIIlllIIIlIIIII.func_190916_E() > this.getInventoryStackLimit()) {
            llllllllllllllllIIIIlllIIIlIIIII.func_190920_e(this.getInventoryStackLimit());
        }
        this.markDirty();
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllllIIIIlllIIlIIIllI, final int llllllllllllllllIIIIlllIIlIIlIIl) {
        final ItemStack llllllllllllllllIIIIlllIIlIIlIII = ItemStackHelper.getAndSplit(this.inventoryContents, llllllllllllllllIIIIlllIIlIIIllI, llllllllllllllllIIIIlllIIlIIlIIl);
        if (!llllllllllllllllIIIIlllIIlIIlIII.func_190926_b()) {
            this.markDirty();
        }
        return llllllllllllllllIIIIlllIIlIIlIII;
    }
    
    @Override
    public int getField(final int llllllllllllllllIIIIllIlllllIIIl) {
        return 0;
    }
    
    @Override
    public void markDirty() {
        if (this.changeListeners != null) {
            for (int llllllllllllllllIIIIllIllllllllI = 0; llllllllllllllllIIIIllIllllllllI < this.changeListeners.size(); ++llllllllllllllllIIIIllIllllllllI) {
                this.changeListeners.get(llllllllllllllllIIIIllIllllllllI).onInventoryChanged(this);
            }
        }
    }
    
    @Override
    public String getName() {
        return this.inventoryTitle;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllllIIIIllIlllllIlII, final ItemStack llllllllllllllllIIIIllIlllllIIll) {
        return true;
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int llllllllllllllllIIIIlllIIIlIlIlI) {
        final ItemStack llllllllllllllllIIIIlllIIIlIlIIl = this.inventoryContents.get(llllllllllllllllIIIIlllIIIlIlIlI);
        if (llllllllllllllllIIIIlllIIIlIlIIl.func_190926_b()) {
            return ItemStack.field_190927_a;
        }
        this.inventoryContents.set(llllllllllllllllIIIIlllIIIlIlIlI, ItemStack.field_190927_a);
        return llllllllllllllllIIIIlllIIIlIlIIl;
    }
    
    @Override
    public int getSizeInventory() {
        return this.slotsCount;
    }
    
    @Override
    public void clear() {
        this.inventoryContents.clear();
    }
}
