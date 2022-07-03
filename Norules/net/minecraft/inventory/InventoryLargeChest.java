package net.minecraft.inventory;

import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;

public class InventoryLargeChest implements ILockableContainer
{
    private final /* synthetic */ ILockableContainer lowerChest;
    private final /* synthetic */ String name;
    private final /* synthetic */ ILockableContainer upperChest;
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer llllllllllllllIlIllIlIlllIIlllII) {
        return this.upperChest.isUsableByPlayer(llllllllllllllIlIllIlIlllIIlllII) && this.lowerChest.isUsableByPlayer(llllllllllllllIlIllIlIlllIIlllII);
    }
    
    @Override
    public int getSizeInventory() {
        return this.upperChest.getSizeInventory() + this.lowerChest.getSizeInventory();
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public void setLockCode(final LockCode llllllllllllllIlIllIlIllIlllIIll) {
        this.upperChest.setLockCode(llllllllllllllIlIllIlIllIlllIIll);
        this.lowerChest.setLockCode(llllllllllllllIlIllIlIllIlllIIll);
    }
    
    @Override
    public int getInventoryStackLimit() {
        return this.upperChest.getInventoryStackLimit();
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllllIlIllIlIlllIllllII, final int llllllllllllllIlIllIlIlllIlllllI) {
        return (llllllllllllllIlIllIlIlllIllllII >= this.upperChest.getSizeInventory()) ? this.lowerChest.decrStackSize(llllllllllllllIlIllIlIlllIllllII - this.upperChest.getSizeInventory(), llllllllllllllIlIllIlIlllIlllllI) : this.upperChest.decrStackSize(llllllllllllllIlIllIlIlllIllllII, llllllllllllllIlIllIlIlllIlllllI);
    }
    
    @Override
    public boolean func_191420_l() {
        return this.upperChest.func_191420_l() && this.lowerChest.func_191420_l();
    }
    
    public InventoryLargeChest(final String llllllllllllllIlIllIlIlllllIIlll, ILockableContainer llllllllllllllIlIllIlIlllllIIllI, ILockableContainer llllllllllllllIlIllIlIlllllIIlIl) {
        this.name = llllllllllllllIlIllIlIlllllIIlll;
        if (llllllllllllllIlIllIlIlllllIIllI == null) {
            llllllllllllllIlIllIlIlllllIIllI = llllllllllllllIlIllIlIlllllIIlIl;
        }
        if (llllllllllllllIlIllIlIlllllIIlIl == null) {
            llllllllllllllIlIllIlIlllllIIlIl = llllllllllllllIlIllIlIlllllIIllI;
        }
        this.upperChest = llllllllllllllIlIllIlIlllllIIllI;
        this.lowerChest = llllllllllllllIlIllIlIlllllIIlIl;
        if (llllllllllllllIlIllIlIlllllIIllI.isLocked()) {
            llllllllllllllIlIllIlIlllllIIlIl.setLockCode(llllllllllllllIlIllIlIlllllIIllI.getLockCode());
        }
        else if (llllllllllllllIlIllIlIlllllIIlIl.isLocked()) {
            llllllllllllllIlIllIlIlllllIIllI.setLockCode(llllllllllllllIlIllIlIlllllIIlIl.getLockCode());
        }
    }
    
    @Override
    public void clear() {
        this.upperChest.clear();
        this.lowerChest.clear();
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllIlIllIlIllIllIlIII, final EntityPlayer llllllllllllllIlIllIlIllIllIIlII) {
        return new ContainerChest(llllllllllllllIlIllIlIllIllIlIII, this, llllllllllllllIlIllIlIllIllIIlII);
    }
    
    @Override
    public int getField(final int llllllllllllllIlIllIlIlllIIIIllI) {
        return 0;
    }
    
    @Override
    public String getName() {
        if (this.upperChest.hasCustomName()) {
            return this.upperChest.getName();
        }
        return this.lowerChest.hasCustomName() ? this.lowerChest.getName() : this.name;
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int llllllllllllllIlIllIlIlllIllIlIl) {
        return (llllllllllllllIlIllIlIlllIllIlIl >= this.upperChest.getSizeInventory()) ? this.lowerChest.removeStackFromSlot(llllllllllllllIlIllIlIlllIllIlIl - this.upperChest.getSizeInventory()) : this.upperChest.removeStackFromSlot(llllllllllllllIlIllIlIlllIllIlIl);
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.upperChest.hasCustomName() || this.lowerChest.hasCustomName();
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllllIlIllIlIlllIllIIII, final ItemStack llllllllllllllIlIllIlIlllIlIllll) {
        if (llllllllllllllIlIllIlIlllIllIIII >= this.upperChest.getSizeInventory()) {
            this.lowerChest.setInventorySlotContents(llllllllllllllIlIllIlIlllIllIIII - this.upperChest.getSizeInventory(), llllllllllllllIlIllIlIlllIlIllll);
        }
        else {
            this.upperChest.setInventorySlotContents(llllllllllllllIlIllIlIlllIllIIII, llllllllllllllIlIllIlIlllIlIllll);
        }
    }
    
    @Override
    public boolean isLocked() {
        return this.upperChest.isLocked() || this.lowerChest.isLocked();
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllllIlIllIlIlllIIlIlll) {
        this.upperChest.openInventory(llllllllllllllIlIllIlIlllIIlIlll);
        this.lowerChest.openInventory(llllllllllllllIlIllIlIlllIIlIlll);
    }
    
    @Override
    public String getGuiID() {
        return this.upperChest.getGuiID();
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllllIlIllIlIlllIIIlIIl, final ItemStack llllllllllllllIlIllIlIlllIIIlIII) {
        return true;
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllllIlIllIlIllllIIIlII) {
        return (llllllllllllllIlIllIlIllllIIIlII >= this.upperChest.getSizeInventory()) ? this.lowerChest.getStackInSlot(llllllllllllllIlIllIlIllllIIIlII - this.upperChest.getSizeInventory()) : this.upperChest.getStackInSlot(llllllllllllllIlIllIlIllllIIIlII);
    }
    
    @Override
    public void setField(final int llllllllllllllIlIllIlIlllIIIIIlI, final int llllllllllllllIlIllIlIlllIIIIIIl) {
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllllIlIllIlIlllIIIllII) {
        this.upperChest.closeInventory(llllllllllllllIlIllIlIlllIIIllII);
        this.lowerChest.closeInventory(llllllllllllllIlIllIlIlllIIIllII);
    }
    
    public boolean isPartOfLargeChest(final IInventory llllllllllllllIlIllIlIllllIllIIl) {
        return this.upperChest == llllllllllllllIlIllIlIllllIllIIl || this.lowerChest == llllllllllllllIlIllIlIllllIllIIl;
    }
    
    @Override
    public LockCode getLockCode() {
        return this.upperChest.getLockCode();
    }
    
    @Override
    public void markDirty() {
        this.upperChest.markDirty();
        this.lowerChest.markDirty();
    }
}
