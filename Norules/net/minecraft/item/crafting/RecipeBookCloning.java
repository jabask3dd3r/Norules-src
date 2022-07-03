package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class RecipeBookCloning implements IRecipe
{
    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public boolean func_194133_a(final int llllllllllllllllIIllllllIlIIIIlI, final int llllllllllllllllIIllllllIlIIIIIl) {
        return llllllllllllllllIIllllllIlIIIIlI >= 3 && llllllllllllllllIIllllllIlIIIIIl >= 3;
    }
    
    @Override
    public boolean func_192399_d() {
        return true;
    }
    
    @Override
    public boolean matches(final InventoryCrafting llllllllllllllllIIlllllllIIlIIIl, final World llllllllllllllllIIlllllllIIlIIII) {
        int llllllllllllllllIIlllllllIIIllll = 0;
        ItemStack llllllllllllllllIIlllllllIIIlllI = ItemStack.field_190927_a;
        for (int llllllllllllllllIIlllllllIIIllIl = 0; llllllllllllllllIIlllllllIIIllIl < llllllllllllllllIIlllllllIIlIIIl.getSizeInventory(); ++llllllllllllllllIIlllllllIIIllIl) {
            final ItemStack llllllllllllllllIIlllllllIIIllII = llllllllllllllllIIlllllllIIlIIIl.getStackInSlot(llllllllllllllllIIlllllllIIIllIl);
            if (!llllllllllllllllIIlllllllIIIllII.func_190926_b()) {
                if (llllllllllllllllIIlllllllIIIllII.getItem() == Items.WRITTEN_BOOK) {
                    if (!llllllllllllllllIIlllllllIIIlllI.func_190926_b()) {
                        return false;
                    }
                    llllllllllllllllIIlllllllIIIlllI = llllllllllllllllIIlllllllIIIllII;
                }
                else {
                    if (llllllllllllllllIIlllllllIIIllII.getItem() != Items.WRITABLE_BOOK) {
                        return false;
                    }
                    ++llllllllllllllllIIlllllllIIIllll;
                }
            }
        }
        return !llllllllllllllllIIlllllllIIIlllI.func_190926_b() && llllllllllllllllIIlllllllIIIlllI.hasTagCompound() && llllllllllllllllIIlllllllIIIllll > 0;
    }
    
    @Override
    public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting llllllllllllllllIIllllllIllIIIll) {
        final NonNullList<ItemStack> llllllllllllllllIIllllllIllIIIIl = NonNullList.func_191197_a(llllllllllllllllIIllllllIllIIIll.getSizeInventory(), ItemStack.field_190927_a);
        for (int llllllllllllllllIIllllllIlIlllll = 0; llllllllllllllllIIllllllIlIlllll < llllllllllllllllIIllllllIllIIIIl.size(); ++llllllllllllllllIIllllllIlIlllll) {
            final ItemStack llllllllllllllllIIllllllIlIlllIl = llllllllllllllllIIllllllIllIIIll.getStackInSlot(llllllllllllllllIIllllllIlIlllll);
            if (llllllllllllllllIIllllllIlIlllIl.getItem() instanceof ItemWrittenBook) {
                final ItemStack llllllllllllllllIIllllllIlIllIll = llllllllllllllllIIllllllIlIlllIl.copy();
                llllllllllllllllIIllllllIlIllIll.func_190920_e(1);
                llllllllllllllllIIllllllIllIIIIl.set(llllllllllllllllIIllllllIlIlllll, llllllllllllllllIIllllllIlIllIll);
                break;
            }
        }
        return llllllllllllllllIIllllllIllIIIIl;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting llllllllllllllllIIllllllIllllIlI) {
        int llllllllllllllllIIllllllIlllllll = 0;
        ItemStack llllllllllllllllIIllllllIllllllI = ItemStack.field_190927_a;
        for (int llllllllllllllllIIllllllIlllllIl = 0; llllllllllllllllIIllllllIlllllIl < llllllllllllllllIIllllllIllllIlI.getSizeInventory(); ++llllllllllllllllIIllllllIlllllIl) {
            final ItemStack llllllllllllllllIIllllllIlllllII = llllllllllllllllIIllllllIllllIlI.getStackInSlot(llllllllllllllllIIllllllIlllllIl);
            if (!llllllllllllllllIIllllllIlllllII.func_190926_b()) {
                if (llllllllllllllllIIllllllIlllllII.getItem() == Items.WRITTEN_BOOK) {
                    if (!llllllllllllllllIIllllllIllllllI.func_190926_b()) {
                        return ItemStack.field_190927_a;
                    }
                    llllllllllllllllIIllllllIllllllI = llllllllllllllllIIllllllIlllllII;
                }
                else {
                    if (llllllllllllllllIIllllllIlllllII.getItem() != Items.WRITABLE_BOOK) {
                        return ItemStack.field_190927_a;
                    }
                    ++llllllllllllllllIIllllllIlllllll;
                }
            }
        }
        if (!llllllllllllllllIIllllllIllllllI.func_190926_b() && llllllllllllllllIIllllllIllllllI.hasTagCompound() && llllllllllllllllIIllllllIlllllll >= 1 && ItemWrittenBook.getGeneration(llllllllllllllllIIllllllIllllllI) < 2) {
            final ItemStack llllllllllllllllIIllllllIllllIll = new ItemStack(Items.WRITTEN_BOOK, llllllllllllllllIIllllllIlllllll);
            llllllllllllllllIIllllllIllllIll.setTagCompound(llllllllllllllllIIllllllIllllllI.getTagCompound().copy());
            llllllllllllllllIIllllllIllllIll.getTagCompound().setInteger("generation", ItemWrittenBook.getGeneration(llllllllllllllllIIllllllIllllllI) + 1);
            if (llllllllllllllllIIllllllIllllllI.hasDisplayName()) {
                llllllllllllllllIIllllllIllllIll.setStackDisplayName(llllllllllllllllIIllllllIllllllI.getDisplayName());
            }
            return llllllllllllllllIIllllllIllllIll;
        }
        return ItemStack.field_190927_a;
    }
}
