package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class RecipesMapCloning implements IRecipe
{
    @Override
    public boolean matches(final InventoryCrafting lllllllllllllllIlIIlllIlIlIIlIII, final World lllllllllllllllIlIIlllIlIlIIllIl) {
        int lllllllllllllllIlIIlllIlIlIIllII = 0;
        ItemStack lllllllllllllllIlIIlllIlIlIIlIll = ItemStack.field_190927_a;
        for (int lllllllllllllllIlIIlllIlIlIIlIlI = 0; lllllllllllllllIlIIlllIlIlIIlIlI < lllllllllllllllIlIIlllIlIlIIlIII.getSizeInventory(); ++lllllllllllllllIlIIlllIlIlIIlIlI) {
            final ItemStack lllllllllllllllIlIIlllIlIlIIlIIl = lllllllllllllllIlIIlllIlIlIIlIII.getStackInSlot(lllllllllllllllIlIIlllIlIlIIlIlI);
            if (!lllllllllllllllIlIIlllIlIlIIlIIl.func_190926_b()) {
                if (lllllllllllllllIlIIlllIlIlIIlIIl.getItem() == Items.FILLED_MAP) {
                    if (!lllllllllllllllIlIIlllIlIlIIlIll.func_190926_b()) {
                        return false;
                    }
                    lllllllllllllllIlIIlllIlIlIIlIll = lllllllllllllllIlIIlllIlIlIIlIIl;
                }
                else {
                    if (lllllllllllllllIlIIlllIlIlIIlIIl.getItem() != Items.MAP) {
                        return false;
                    }
                    ++lllllllllllllllIlIIlllIlIlIIllII;
                }
            }
        }
        return !lllllllllllllllIlIIlllIlIlIIlIll.func_190926_b() && lllllllllllllllIlIIlllIlIlIIllII > 0;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllllIlIIlllIlIIllllIl) {
        int lllllllllllllllIlIIlllIlIIllllII = 0;
        ItemStack lllllllllllllllIlIIlllIlIIlllIll = ItemStack.field_190927_a;
        for (int lllllllllllllllIlIIlllIlIIlllIlI = 0; lllllllllllllllIlIIlllIlIIlllIlI < lllllllllllllllIlIIlllIlIIllllIl.getSizeInventory(); ++lllllllllllllllIlIIlllIlIIlllIlI) {
            final ItemStack lllllllllllllllIlIIlllIlIIlllIIl = lllllllllllllllIlIIlllIlIIllllIl.getStackInSlot(lllllllllllllllIlIIlllIlIIlllIlI);
            if (!lllllllllllllllIlIIlllIlIIlllIIl.func_190926_b()) {
                if (lllllllllllllllIlIIlllIlIIlllIIl.getItem() == Items.FILLED_MAP) {
                    if (!lllllllllllllllIlIIlllIlIIlllIll.func_190926_b()) {
                        return ItemStack.field_190927_a;
                    }
                    lllllllllllllllIlIIlllIlIIlllIll = lllllllllllllllIlIIlllIlIIlllIIl;
                }
                else {
                    if (lllllllllllllllIlIIlllIlIIlllIIl.getItem() != Items.MAP) {
                        return ItemStack.field_190927_a;
                    }
                    ++lllllllllllllllIlIIlllIlIIllllII;
                }
            }
        }
        if (!lllllllllllllllIlIIlllIlIIlllIll.func_190926_b() && lllllllllllllllIlIIlllIlIIllllII >= 1) {
            final ItemStack lllllllllllllllIlIIlllIlIIlllIII = new ItemStack(Items.FILLED_MAP, lllllllllllllllIlIIlllIlIIllllII + 1, lllllllllllllllIlIIlllIlIIlllIll.getMetadata());
            if (lllllllllllllllIlIIlllIlIIlllIll.hasDisplayName()) {
                lllllllllllllllIlIIlllIlIIlllIII.setStackDisplayName(lllllllllllllllIlIIlllIlIIlllIll.getDisplayName());
            }
            if (lllllllllllllllIlIIlllIlIIlllIll.hasTagCompound()) {
                lllllllllllllllIlIIlllIlIIlllIII.setTagCompound(lllllllllllllllIlIIlllIlIIlllIll.getTagCompound());
            }
            return lllllllllllllllIlIIlllIlIIlllIII;
        }
        return ItemStack.field_190927_a;
    }
    
    @Override
    public boolean func_194133_a(final int lllllllllllllllIlIIlllIlIIIlIlll, final int lllllllllllllllIlIIlllIlIIIllIII) {
        return lllllllllllllllIlIIlllIlIIIlIlll >= 3 && lllllllllllllllIlIIlllIlIIIllIII >= 3;
    }
    
    @Override
    public boolean func_192399_d() {
        return true;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting lllllllllllllllIlIIlllIlIIlIIlIl) {
        final NonNullList<ItemStack> lllllllllllllllIlIIlllIlIIlIlIIl = NonNullList.func_191197_a(lllllllllllllllIlIIlllIlIIlIIlIl.getSizeInventory(), ItemStack.field_190927_a);
        for (int lllllllllllllllIlIIlllIlIIlIIlll = 0; lllllllllllllllIlIIlllIlIIlIIlll < lllllllllllllllIlIIlllIlIIlIlIIl.size(); ++lllllllllllllllIlIIlllIlIIlIIlll) {
            final ItemStack lllllllllllllllIlIIlllIlIIlIIllI = lllllllllllllllIlIIlllIlIIlIIlIl.getStackInSlot(lllllllllllllllIlIIlllIlIIlIIlll);
            if (lllllllllllllllIlIIlllIlIIlIIllI.getItem().hasContainerItem()) {
                lllllllllllllllIlIIlllIlIIlIlIIl.set(lllllllllllllllIlIIlllIlIIlIIlll, new ItemStack(lllllllllllllllIlIIlllIlIIlIIllI.getItem().getContainerItem()));
            }
        }
        return lllllllllllllllIlIIlllIlIIlIlIIl;
    }
}
