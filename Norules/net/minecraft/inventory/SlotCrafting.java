package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.*;

public class SlotCrafting extends Slot
{
    private final /* synthetic */ EntityPlayer thePlayer;
    private final /* synthetic */ InventoryCrafting craftMatrix;
    private /* synthetic */ int amountCrafted;
    
    public SlotCrafting(final EntityPlayer lllllllllllllIIlllllIlIllIIIIIIl, final InventoryCrafting lllllllllllllIIlllllIlIllIIIIlll, final IInventory lllllllllllllIIlllllIlIllIIIIllI, final int lllllllllllllIIlllllIlIllIIIIlIl, final int lllllllllllllIIlllllIlIlIlllllIl, final int lllllllllllllIIlllllIlIllIIIIIll) {
        super(lllllllllllllIIlllllIlIllIIIIllI, lllllllllllllIIlllllIlIllIIIIlIl, lllllllllllllIIlllllIlIlIlllllIl, lllllllllllllIIlllllIlIllIIIIIll);
        this.thePlayer = lllllllllllllIIlllllIlIllIIIIIIl;
        this.craftMatrix = lllllllllllllIIlllllIlIllIIIIlll;
    }
    
    @Override
    protected void onCrafting(final ItemStack lllllllllllllIIlllllIlIlIlIlllll) {
        if (this.amountCrafted > 0) {
            lllllllllllllIIlllllIlIlIlIlllll.onCrafting(this.thePlayer.world, this.thePlayer, this.amountCrafted);
        }
        this.amountCrafted = 0;
        final InventoryCraftResult lllllllllllllIIlllllIlIlIlIllllI = (InventoryCraftResult)this.inventory;
        final IRecipe lllllllllllllIIlllllIlIlIlIlllIl = lllllllllllllIIlllllIlIlIlIllllI.func_193055_i();
        if (lllllllllllllIIlllllIlIlIlIlllIl != null && !lllllllllllllIIlllllIlIlIlIlllIl.func_192399_d()) {
            this.thePlayer.func_192021_a(Lists.newArrayList((Object[])new IRecipe[] { lllllllllllllIIlllllIlIlIlIlllIl }));
            lllllllllllllIIlllllIlIlIlIllllI.func_193056_a(null);
        }
    }
    
    @Override
    public ItemStack func_190901_a(final EntityPlayer lllllllllllllIIlllllIlIlIlIlIIII, final ItemStack lllllllllllllIIlllllIlIlIlIIllll) {
        this.onCrafting(lllllllllllllIIlllllIlIlIlIIllll);
        final NonNullList<ItemStack> lllllllllllllIIlllllIlIlIlIIlllI = CraftingManager.getRemainingItems(this.craftMatrix, lllllllllllllIIlllllIlIlIlIlIIII.world);
        for (int lllllllllllllIIlllllIlIlIlIIllIl = 0; lllllllllllllIIlllllIlIlIlIIllIl < lllllllllllllIIlllllIlIlIlIIlllI.size(); ++lllllllllllllIIlllllIlIlIlIIllIl) {
            ItemStack lllllllllllllIIlllllIlIlIlIIllII = this.craftMatrix.getStackInSlot(lllllllllllllIIlllllIlIlIlIIllIl);
            final ItemStack lllllllllllllIIlllllIlIlIlIIlIll = lllllllllllllIIlllllIlIlIlIIlllI.get(lllllllllllllIIlllllIlIlIlIIllIl);
            if (!lllllllllllllIIlllllIlIlIlIIllII.func_190926_b()) {
                this.craftMatrix.decrStackSize(lllllllllllllIIlllllIlIlIlIIllIl, 1);
                lllllllllllllIIlllllIlIlIlIIllII = this.craftMatrix.getStackInSlot(lllllllllllllIIlllllIlIlIlIIllIl);
            }
            if (!lllllllllllllIIlllllIlIlIlIIlIll.func_190926_b()) {
                if (lllllllllllllIIlllllIlIlIlIIllII.func_190926_b()) {
                    this.craftMatrix.setInventorySlotContents(lllllllllllllIIlllllIlIlIlIIllIl, lllllllllllllIIlllllIlIlIlIIlIll);
                }
                else if (ItemStack.areItemsEqual(lllllllllllllIIlllllIlIlIlIIllII, lllllllllllllIIlllllIlIlIlIIlIll) && ItemStack.areItemStackTagsEqual(lllllllllllllIIlllllIlIlIlIIllII, lllllllllllllIIlllllIlIlIlIIlIll)) {
                    lllllllllllllIIlllllIlIlIlIIlIll.func_190917_f(lllllllllllllIIlllllIlIlIlIIllII.func_190916_E());
                    this.craftMatrix.setInventorySlotContents(lllllllllllllIIlllllIlIlIlIIllIl, lllllllllllllIIlllllIlIlIlIIlIll);
                }
                else if (!this.thePlayer.inventory.addItemStackToInventory(lllllllllllllIIlllllIlIlIlIIlIll)) {
                    this.thePlayer.dropItem(lllllllllllllIIlllllIlIlIlIIlIll, false);
                }
            }
        }
        return lllllllllllllIIlllllIlIlIlIIllll;
    }
    
    @Override
    public boolean isItemValid(final ItemStack lllllllllllllIIlllllIlIlIllllIlI) {
        return false;
    }
    
    @Override
    protected void onCrafting(final ItemStack lllllllllllllIIlllllIlIlIllIllll, final int lllllllllllllIIlllllIlIlIllIlIll) {
        this.amountCrafted += lllllllllllllIIlllllIlIlIllIlIll;
        this.onCrafting(lllllllllllllIIlllllIlIlIllIllll);
    }
    
    @Override
    protected void func_190900_b(final int lllllllllllllIIlllllIlIlIllIIlIl) {
        this.amountCrafted += lllllllllllllIIlllllIlIlIllIIlIl;
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIIlllllIlIlIlllIllI) {
        if (this.getHasStack()) {
            this.amountCrafted += Math.min(lllllllllllllIIlllllIlIlIlllIllI, this.getStack().func_190916_E());
        }
        return super.decrStackSize(lllllllllllllIIlllllIlIlIlllIllI);
    }
}
