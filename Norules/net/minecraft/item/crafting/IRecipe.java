package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public interface IRecipe
{
    ItemStack getCraftingResult(final InventoryCrafting p0);
    
    default String func_193358_e() {
        return "";
    }
    
    default boolean func_192399_d() {
        return false;
    }
    
    ItemStack getRecipeOutput();
    
    boolean matches(final InventoryCrafting p0, final World p1);
    
    boolean func_194133_a(final int p0, final int p1);
    
    default NonNullList<Ingredient> func_192400_c() {
        return NonNullList.func_191196_a();
    }
    
    NonNullList<ItemStack> getRemainingItems(final InventoryCrafting p0);
}
