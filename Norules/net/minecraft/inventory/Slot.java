package net.minecraft.inventory;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;

public class Slot
{
    private final /* synthetic */ int slotIndex;
    public final /* synthetic */ IInventory inventory;
    public /* synthetic */ int yDisplayPosition;
    public /* synthetic */ int xDisplayPosition;
    
    public void onSlotChanged() {
        this.inventory.markDirty();
    }
    
    public void onSlotChange(final ItemStack lllllllllllllIIIIIlIIllllIIIlIII, final ItemStack lllllllllllllIIIIIlIIllllIIIIIll) {
        final int lllllllllllllIIIIIlIIllllIIIIllI = lllllllllllllIIIIIlIIllllIIIIIll.func_190916_E() - lllllllllllllIIIIIlIIllllIIIlIII.func_190916_E();
        if (lllllllllllllIIIIIlIIllllIIIIllI > 0) {
            this.onCrafting(lllllllllllllIIIIIlIIllllIIIIIll, lllllllllllllIIIIIlIIllllIIIIllI);
        }
    }
    
    public void putStack(final ItemStack lllllllllllllIIIIIlIIlllIllIIllI) {
        this.inventory.setInventorySlotContents(this.slotIndex, lllllllllllllIIIIIlIIlllIllIIllI);
        this.onSlotChanged();
    }
    
    protected void func_190900_b(final int lllllllllllllIIIIIlIIlllIlllllIl) {
    }
    
    protected void onCrafting(final ItemStack lllllllllllllIIIIIlIIlllIllllIll) {
    }
    
    public Slot(final IInventory lllllllllllllIIIIIlIIllllIIlIIIl, final int lllllllllllllIIIIIlIIllllIIlIlIl, final int lllllllllllllIIIIIlIIllllIIIllll, final int lllllllllllllIIIIIlIIllllIIlIIll) {
        this.inventory = lllllllllllllIIIIIlIIllllIIlIIIl;
        this.slotIndex = lllllllllllllIIIIIlIIllllIIlIlIl;
        this.xDisplayPosition = lllllllllllllIIIIIlIIllllIIIllll;
        this.yDisplayPosition = lllllllllllllIIIIIlIIllllIIlIIll;
    }
    
    public ItemStack getStack() {
        return this.inventory.getStackInSlot(this.slotIndex);
    }
    
    public ItemStack func_190901_a(final EntityPlayer lllllllllllllIIIIIlIIlllIlllIlll, final ItemStack lllllllllllllIIIIIlIIlllIlllIlII) {
        this.onSlotChanged();
        return lllllllllllllIIIIIlIIlllIlllIlII;
    }
    
    public boolean isItemValid(final ItemStack lllllllllllllIIIIIlIIlllIlllIIlI) {
        return true;
    }
    
    public boolean canTakeStack(final EntityPlayer lllllllllllllIIIIIlIIlllIlIIlIlI) {
        return true;
    }
    
    public boolean canBeHovered() {
        return true;
    }
    
    @Nullable
    public String getSlotTexture() {
        return null;
    }
    
    protected void onCrafting(final ItemStack lllllllllllllIIIIIlIIllllIIIIIII, final int lllllllllllllIIIIIlIIlllIlllllll) {
    }
    
    public boolean getHasStack() {
        return !this.getStack().func_190926_b();
    }
    
    public int getSlotStackLimit() {
        return this.inventory.getInventoryStackLimit();
    }
    
    public int getItemStackLimit(final ItemStack lllllllllllllIIIIIlIIlllIlIlllIl) {
        return this.getSlotStackLimit();
    }
    
    public ItemStack decrStackSize(final int lllllllllllllIIIIIlIIlllIlIlIlll) {
        return this.inventory.decrStackSize(this.slotIndex, lllllllllllllIIIIIlIIlllIlIlIlll);
    }
    
    public boolean isHere(final IInventory lllllllllllllIIIIIlIIlllIlIlIIII, final int lllllllllllllIIIIIlIIlllIlIIllII) {
        return lllllllllllllIIIIIlIIlllIlIlIIII == this.inventory && lllllllllllllIIIIIlIIlllIlIIllII == this.slotIndex;
    }
}
