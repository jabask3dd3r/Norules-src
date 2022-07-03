package net.minecraft.inventory;

import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;

public class InventoryEnderChest extends InventoryBasic
{
    private /* synthetic */ TileEntityEnderChest associatedChest;
    
    @Override
    public void openInventory(final EntityPlayer llIlIlIIIlIIllI) {
        if (this.associatedChest != null) {
            this.associatedChest.openChest();
        }
        super.openInventory(llIlIlIIIlIIllI);
    }
    
    @Override
    public void closeInventory(final EntityPlayer llIlIlIIIlIIIII) {
        if (this.associatedChest != null) {
            this.associatedChest.closeChest();
        }
        super.closeInventory(llIlIlIIIlIIIII);
        this.associatedChest = null;
    }
    
    public InventoryEnderChest() {
        super("container.enderchest", false, 27);
    }
    
    public NBTTagList saveInventoryToNBT() {
        final NBTTagList llIlIlIIIlllIlI = new NBTTagList();
        for (int llIlIlIIIlllIIl = 0; llIlIlIIIlllIIl < this.getSizeInventory(); ++llIlIlIIIlllIIl) {
            final ItemStack llIlIlIIIlllIII = this.getStackInSlot(llIlIlIIIlllIIl);
            if (!llIlIlIIIlllIII.func_190926_b()) {
                final NBTTagCompound llIlIlIIIllIlll = new NBTTagCompound();
                llIlIlIIIllIlll.setByte("Slot", (byte)llIlIlIIIlllIIl);
                llIlIlIIIlllIII.writeToNBT(llIlIlIIIllIlll);
                llIlIlIIIlllIlI.appendTag(llIlIlIIIllIlll);
            }
        }
        return llIlIlIIIlllIlI;
    }
    
    public void loadInventoryFromNBT(final NBTTagList llIlIlIIlIIIlII) {
        for (int llIlIlIIlIIlIIl = 0; llIlIlIIlIIlIIl < this.getSizeInventory(); ++llIlIlIIlIIlIIl) {
            this.setInventorySlotContents(llIlIlIIlIIlIIl, ItemStack.field_190927_a);
        }
        for (int llIlIlIIlIIlIII = 0; llIlIlIIlIIlIII < llIlIlIIlIIIlII.tagCount(); ++llIlIlIIlIIlIII) {
            final NBTTagCompound llIlIlIIlIIIlll = llIlIlIIlIIIlII.getCompoundTagAt(llIlIlIIlIIlIII);
            final int llIlIlIIlIIIllI = llIlIlIIlIIIlll.getByte("Slot") & 0xFF;
            if (llIlIlIIlIIIllI >= 0 && llIlIlIIlIIIllI < this.getSizeInventory()) {
                this.setInventorySlotContents(llIlIlIIlIIIllI, new ItemStack(llIlIlIIlIIIlll));
            }
        }
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer llIlIlIIIlIlllI) {
        return (this.associatedChest == null || this.associatedChest.canBeUsed(llIlIlIIIlIlllI)) && super.isUsableByPlayer(llIlIlIIIlIlllI);
    }
    
    public void setChestTileEntity(final TileEntityEnderChest llIlIlIIlIlIIll) {
        this.associatedChest = llIlIlIIlIlIIll;
    }
}
