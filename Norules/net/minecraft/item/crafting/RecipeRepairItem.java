package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class RecipeRepairItem implements IRecipe
{
    @Override
    public boolean func_192399_d() {
        return true;
    }
    
    @Override
    public boolean func_194133_a(final int lllllllllllllIIIIIIllIIllllIlIll, final int lllllllllllllIIIIIIllIIllllIlIlI) {
        return lllllllllllllIIIIIIllIIllllIlIll * lllllllllllllIIIIIIllIIllllIlIlI >= 2;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllIIIIIIllIlIIIIIlIII) {
        final List<ItemStack> lllllllllllllIIIIIIllIlIIIIlIIll = (List<ItemStack>)Lists.newArrayList();
        for (int lllllllllllllIIIIIIllIlIIIIlIIlI = 0; lllllllllllllIIIIIIllIlIIIIlIIlI < lllllllllllllIIIIIIllIlIIIIIlIII.getSizeInventory(); ++lllllllllllllIIIIIIllIlIIIIlIIlI) {
            final ItemStack lllllllllllllIIIIIIllIlIIIIlIIIl = lllllllllllllIIIIIIllIlIIIIIlIII.getStackInSlot(lllllllllllllIIIIIIllIlIIIIlIIlI);
            if (!lllllllllllllIIIIIIllIlIIIIlIIIl.func_190926_b()) {
                lllllllllllllIIIIIIllIlIIIIlIIll.add(lllllllllllllIIIIIIllIlIIIIlIIIl);
                if (lllllllllllllIIIIIIllIlIIIIlIIll.size() > 1) {
                    final ItemStack lllllllllllllIIIIIIllIlIIIIlIIII = lllllllllllllIIIIIIllIlIIIIlIIll.get(0);
                    if (lllllllllllllIIIIIIllIlIIIIlIIIl.getItem() != lllllllllllllIIIIIIllIlIIIIlIIII.getItem() || lllllllllllllIIIIIIllIlIIIIlIIII.func_190916_E() != 1 || lllllllllllllIIIIIIllIlIIIIlIIIl.func_190916_E() != 1 || !lllllllllllllIIIIIIllIlIIIIlIIII.getItem().isDamageable()) {
                        return ItemStack.field_190927_a;
                    }
                }
            }
        }
        if (lllllllllllllIIIIIIllIlIIIIlIIll.size() == 2) {
            final ItemStack lllllllllllllIIIIIIllIlIIIIIllll = lllllllllllllIIIIIIllIlIIIIlIIll.get(0);
            final ItemStack lllllllllllllIIIIIIllIlIIIIIlllI = lllllllllllllIIIIIIllIlIIIIlIIll.get(1);
            if (lllllllllllllIIIIIIllIlIIIIIllll.getItem() == lllllllllllllIIIIIIllIlIIIIIlllI.getItem() && lllllllllllllIIIIIIllIlIIIIIllll.func_190916_E() == 1 && lllllllllllllIIIIIIllIlIIIIIlllI.func_190916_E() == 1 && lllllllllllllIIIIIIllIlIIIIIllll.getItem().isDamageable()) {
                final Item lllllllllllllIIIIIIllIlIIIIIllIl = lllllllllllllIIIIIIllIlIIIIIllll.getItem();
                final int lllllllllllllIIIIIIllIlIIIIIllII = lllllllllllllIIIIIIllIlIIIIIllIl.getMaxDamage() - lllllllllllllIIIIIIllIlIIIIIllll.getItemDamage();
                final int lllllllllllllIIIIIIllIlIIIIIlIll = lllllllllllllIIIIIIllIlIIIIIllIl.getMaxDamage() - lllllllllllllIIIIIIllIlIIIIIlllI.getItemDamage();
                final int lllllllllllllIIIIIIllIlIIIIIlIlI = lllllllllllllIIIIIIllIlIIIIIllII + lllllllllllllIIIIIIllIlIIIIIlIll + lllllllllllllIIIIIIllIlIIIIIllIl.getMaxDamage() * 5 / 100;
                int lllllllllllllIIIIIIllIlIIIIIlIIl = lllllllllllllIIIIIIllIlIIIIIllIl.getMaxDamage() - lllllllllllllIIIIIIllIlIIIIIlIlI;
                if (lllllllllllllIIIIIIllIlIIIIIlIIl < 0) {
                    lllllllllllllIIIIIIllIlIIIIIlIIl = 0;
                }
                return new ItemStack(lllllllllllllIIIIIIllIlIIIIIllll.getItem(), 1, lllllllllllllIIIIIIllIlIIIIIlIIl);
            }
        }
        return ItemStack.field_190927_a;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting lllllllllllllIIIIIIllIIllllllIIl) {
        final NonNullList<ItemStack> lllllllllllllIIIIIIllIIllllllIII = NonNullList.func_191197_a(lllllllllllllIIIIIIllIIllllllIIl.getSizeInventory(), ItemStack.field_190927_a);
        for (int lllllllllllllIIIIIIllIIlllllIlll = 0; lllllllllllllIIIIIIllIIlllllIlll < lllllllllllllIIIIIIllIIllllllIII.size(); ++lllllllllllllIIIIIIllIIlllllIlll) {
            final ItemStack lllllllllllllIIIIIIllIIlllllIllI = lllllllllllllIIIIIIllIIllllllIIl.getStackInSlot(lllllllllllllIIIIIIllIIlllllIlll);
            if (lllllllllllllIIIIIIllIIlllllIllI.getItem().hasContainerItem()) {
                lllllllllllllIIIIIIllIIllllllIII.set(lllllllllllllIIIIIIllIIlllllIlll, new ItemStack(lllllllllllllIIIIIIllIIlllllIllI.getItem().getContainerItem()));
            }
        }
        return lllllllllllllIIIIIIllIIllllllIII;
    }
    
    @Override
    public boolean matches(final InventoryCrafting lllllllllllllIIIIIIllIlIIIlIlIIl, final World lllllllllllllIIIIIIllIlIIIlIlIII) {
        final List<ItemStack> lllllllllllllIIIIIIllIlIIIlIIlll = (List<ItemStack>)Lists.newArrayList();
        for (int lllllllllllllIIIIIIllIlIIIlIIllI = 0; lllllllllllllIIIIIIllIlIIIlIIllI < lllllllllllllIIIIIIllIlIIIlIlIIl.getSizeInventory(); ++lllllllllllllIIIIIIllIlIIIlIIllI) {
            final ItemStack lllllllllllllIIIIIIllIlIIIlIIlIl = lllllllllllllIIIIIIllIlIIIlIlIIl.getStackInSlot(lllllllllllllIIIIIIllIlIIIlIIllI);
            if (!lllllllllllllIIIIIIllIlIIIlIIlIl.func_190926_b()) {
                lllllllllllllIIIIIIllIlIIIlIIlll.add(lllllllllllllIIIIIIllIlIIIlIIlIl);
                if (lllllllllllllIIIIIIllIlIIIlIIlll.size() > 1) {
                    final ItemStack lllllllllllllIIIIIIllIlIIIlIIlII = lllllllllllllIIIIIIllIlIIIlIIlll.get(0);
                    if (lllllllllllllIIIIIIllIlIIIlIIlIl.getItem() != lllllllllllllIIIIIIllIlIIIlIIlII.getItem() || lllllllllllllIIIIIIllIlIIIlIIlII.func_190916_E() != 1 || lllllllllllllIIIIIIllIlIIIlIIlIl.func_190916_E() != 1 || !lllllllllllllIIIIIIllIlIIIlIIlII.getItem().isDamageable()) {
                        return false;
                    }
                }
            }
        }
        return lllllllllllllIIIIIIllIlIIIlIIlll.size() == 2;
    }
}
