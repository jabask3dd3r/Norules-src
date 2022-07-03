package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.potion.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class RecipeTippedArrow implements IRecipe
{
    @Override
    public boolean func_192399_d() {
        return true;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting llllllllllllllIIlllIlIlIlIIlIllI) {
        final ItemStack llllllllllllllIIlllIlIlIlIIllIII = llllllllllllllIIlllIlIlIlIIlIllI.getStackInRowAndColumn(1, 1);
        if (llllllllllllllIIlllIlIlIlIIllIII.getItem() != Items.LINGERING_POTION) {
            return ItemStack.field_190927_a;
        }
        final ItemStack llllllllllllllIIlllIlIlIlIIlIlll = new ItemStack(Items.TIPPED_ARROW, 8);
        PotionUtils.addPotionToItemStack(llllllllllllllIIlllIlIlIlIIlIlll, PotionUtils.getPotionFromItem(llllllllllllllIIlllIlIlIlIIllIII));
        PotionUtils.appendEffects(llllllllllllllIIlllIlIlIlIIlIlll, PotionUtils.getFullEffectsFromItem(llllllllllllllIIlllIlIlIlIIllIII));
        return llllllllllllllIIlllIlIlIlIIlIlll;
    }
    
    @Override
    public boolean func_194133_a(final int llllllllllllllIIlllIlIlIlIIIlIII, final int llllllllllllllIIlllIlIlIlIIIIlll) {
        return llllllllllllllIIlllIlIlIlIIIlIII >= 2 && llllllllllllllIIlllIlIlIlIIIIlll >= 2;
    }
    
    @Override
    public boolean matches(final InventoryCrafting llllllllllllllIIlllIlIlIlIlIlIII, final World llllllllllllllIIlllIlIlIlIlIIlll) {
        if (llllllllllllllIIlllIlIlIlIlIlIII.getWidth() == 3 && llllllllllllllIIlllIlIlIlIlIlIII.getHeight() == 3) {
            for (int llllllllllllllIIlllIlIlIlIlIIllI = 0; llllllllllllllIIlllIlIlIlIlIIllI < llllllllllllllIIlllIlIlIlIlIlIII.getWidth(); ++llllllllllllllIIlllIlIlIlIlIIllI) {
                for (int llllllllllllllIIlllIlIlIlIlIIlIl = 0; llllllllllllllIIlllIlIlIlIlIIlIl < llllllllllllllIIlllIlIlIlIlIlIII.getHeight(); ++llllllllllllllIIlllIlIlIlIlIIlIl) {
                    final ItemStack llllllllllllllIIlllIlIlIlIlIIlII = llllllllllllllIIlllIlIlIlIlIlIII.getStackInRowAndColumn(llllllllllllllIIlllIlIlIlIlIIllI, llllllllllllllIIlllIlIlIlIlIIlIl);
                    if (llllllllllllllIIlllIlIlIlIlIIlII.func_190926_b()) {
                        return false;
                    }
                    final Item llllllllllllllIIlllIlIlIlIlIIIll = llllllllllllllIIlllIlIlIlIlIIlII.getItem();
                    if (llllllllllllllIIlllIlIlIlIlIIllI == 1 && llllllllllllllIIlllIlIlIlIlIIlIl == 1) {
                        if (llllllllllllllIIlllIlIlIlIlIIIll != Items.LINGERING_POTION) {
                            return false;
                        }
                    }
                    else if (llllllllllllllIIlllIlIlIlIlIIIll != Items.ARROW) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting llllllllllllllIIlllIlIlIlIIlIIII) {
        return NonNullList.func_191197_a(llllllllllllllIIlllIlIlIlIIlIIII.getSizeInventory(), ItemStack.field_190927_a);
    }
}
