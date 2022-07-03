package net.minecraft.inventory;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class ContainerWorkbench extends Container
{
    private final /* synthetic */ EntityPlayer field_192390_i;
    public /* synthetic */ InventoryCraftResult craftResult;
    private final /* synthetic */ World worldObj;
    public /* synthetic */ InventoryCrafting craftMatrix;
    private final /* synthetic */ BlockPos pos;
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllllIlllllIIlIIlIIlI) {
        super.onContainerClosed(llllllllllllllllIlllllIIlIIlIIlI);
        if (!this.worldObj.isRemote) {
            this.func_193327_a(llllllllllllllllIlllllIIlIIlIIlI, this.worldObj, this.craftMatrix);
        }
    }
    
    public ContainerWorkbench(final InventoryPlayer llllllllllllllllIlllllIIlIlIIIII, final World llllllllllllllllIlllllIIlIlIlIII, final BlockPos llllllllllllllllIlllllIIlIlIIlll) {
        this.craftMatrix = new InventoryCrafting(this, 3, 3);
        this.craftResult = new InventoryCraftResult();
        this.worldObj = llllllllllllllllIlllllIIlIlIlIII;
        this.pos = llllllllllllllllIlllllIIlIlIIlll;
        this.field_192390_i = llllllllllllllllIlllllIIlIlIIIII.player;
        this.addSlotToContainer(new SlotCrafting(llllllllllllllllIlllllIIlIlIIIII.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        for (int llllllllllllllllIlllllIIlIlIIllI = 0; llllllllllllllllIlllllIIlIlIIllI < 3; ++llllllllllllllllIlllllIIlIlIIllI) {
            for (int llllllllllllllllIlllllIIlIlIIlIl = 0; llllllllllllllllIlllllIIlIlIIlIl < 3; ++llllllllllllllllIlllllIIlIlIIlIl) {
                this.addSlotToContainer(new Slot(this.craftMatrix, llllllllllllllllIlllllIIlIlIIlIl + llllllllllllllllIlllllIIlIlIIllI * 3, 30 + llllllllllllllllIlllllIIlIlIIlIl * 18, 17 + llllllllllllllllIlllllIIlIlIIllI * 18));
            }
        }
        for (int llllllllllllllllIlllllIIlIlIIlII = 0; llllllllllllllllIlllllIIlIlIIlII < 3; ++llllllllllllllllIlllllIIlIlIIlII) {
            for (int llllllllllllllllIlllllIIlIlIIIll = 0; llllllllllllllllIlllllIIlIlIIIll < 9; ++llllllllllllllllIlllllIIlIlIIIll) {
                this.addSlotToContainer(new Slot(llllllllllllllllIlllllIIlIlIIIII, llllllllllllllllIlllllIIlIlIIIll + llllllllllllllllIlllllIIlIlIIlII * 9 + 9, 8 + llllllllllllllllIlllllIIlIlIIIll * 18, 84 + llllllllllllllllIlllllIIlIlIIlII * 18));
            }
        }
        for (int llllllllllllllllIlllllIIlIlIIIlI = 0; llllllllllllllllIlllllIIlIlIIIlI < 9; ++llllllllllllllllIlllllIIlIlIIIlI) {
            this.addSlotToContainer(new Slot(llllllllllllllllIlllllIIlIlIIIII, llllllllllllllllIlllllIIlIlIIIlI, 8 + llllllllllllllllIlllllIIlIlIIIlI * 18, 142));
        }
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllllIlllllIIlIIIIIll, final int llllllllllllllllIlllllIIIllllIll) {
        ItemStack llllllllllllllllIlllllIIlIIIIIIl = ItemStack.field_190927_a;
        final Slot llllllllllllllllIlllllIIlIIIIIII = this.inventorySlots.get(llllllllllllllllIlllllIIIllllIll);
        if (llllllllllllllllIlllllIIlIIIIIII != null && llllllllllllllllIlllllIIlIIIIIII.getHasStack()) {
            final ItemStack llllllllllllllllIlllllIIIlllllll = llllllllllllllllIlllllIIlIIIIIII.getStack();
            llllllllllllllllIlllllIIlIIIIIIl = llllllllllllllllIlllllIIIlllllll.copy();
            if (llllllllllllllllIlllllIIIllllIll == 0) {
                llllllllllllllllIlllllIIIlllllll.getItem().onCreated(llllllllllllllllIlllllIIIlllllll, this.worldObj, llllllllllllllllIlllllIIlIIIIIll);
                if (!this.mergeItemStack(llllllllllllllllIlllllIIIlllllll, 10, 46, true)) {
                    return ItemStack.field_190927_a;
                }
                llllllllllllllllIlllllIIlIIIIIII.onSlotChange(llllllllllllllllIlllllIIIlllllll, llllllllllllllllIlllllIIlIIIIIIl);
            }
            else if (llllllllllllllllIlllllIIIllllIll >= 10 && llllllllllllllllIlllllIIIllllIll < 37) {
                if (!this.mergeItemStack(llllllllllllllllIlllllIIIlllllll, 37, 46, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (llllllllllllllllIlllllIIIllllIll >= 37 && llllllllllllllllIlllllIIIllllIll < 46) {
                if (!this.mergeItemStack(llllllllllllllllIlllllIIIlllllll, 10, 37, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllllIlllllIIIlllllll, 10, 46, false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllllllllIlllllIIIlllllll.func_190926_b()) {
                llllllllllllllllIlllllIIlIIIIIII.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllllllIlllllIIlIIIIIII.onSlotChanged();
            }
            if (llllllllllllllllIlllllIIIlllllll.func_190916_E() == llllllllllllllllIlllllIIlIIIIIIl.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            final ItemStack llllllllllllllllIlllllIIIllllllI = llllllllllllllllIlllllIIlIIIIIII.func_190901_a(llllllllllllllllIlllllIIlIIIIIll, llllllllllllllllIlllllIIIlllllll);
            if (llllllllllllllllIlllllIIIllllIll == 0) {
                llllllllllllllllIlllllIIlIIIIIll.dropItem(llllllllllllllllIlllllIIIllllllI, false);
            }
        }
        return llllllllllllllllIlllllIIlIIIIIIl;
    }
    
    @Override
    public boolean canMergeSlot(final ItemStack llllllllllllllllIlllllIIIllIllll, final Slot llllllllllllllllIlllllIIIllIlllI) {
        return llllllllllllllllIlllllIIIllIlllI.inventory != this.craftResult && super.canMergeSlot(llllllllllllllllIlllllIIIllIllll, llllllllllllllllIlllllIIIllIlllI);
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory llllllllllllllllIlllllIIlIIllIIl) {
        this.func_192389_a(this.worldObj, this.field_192390_i, this.craftMatrix, this.craftResult);
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllllIlllllIIlIIIllII) {
        return this.worldObj.getBlockState(this.pos).getBlock() == Blocks.CRAFTING_TABLE && llllllllllllllllIlllllIIlIIIllII.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
}
