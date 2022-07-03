package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class ShulkerBoxRecipes
{
    public static class ShulkerBoxColoring implements IRecipe
    {
        @Override
        public ItemStack getRecipeOutput() {
            return ItemStack.field_190927_a;
        }
        
        @Override
        public boolean func_194133_a(final int lllllllllllllllIllIIIIllIlIllllI, final int lllllllllllllllIllIIIIllIlIlllll) {
            return lllllllllllllllIllIIIIllIlIllllI * lllllllllllllllIllIIIIllIlIlllll >= 2;
        }
        
        @Override
        public boolean func_192399_d() {
            return true;
        }
        
        @Override
        public boolean matches(final InventoryCrafting lllllllllllllllIllIIIIlllIIIlllI, final World lllllllllllllllIllIIIIlllIIIllIl) {
            int lllllllllllllllIllIIIIlllIIIllII = 0;
            int lllllllllllllllIllIIIIlllIIIlIll = 0;
            for (int lllllllllllllllIllIIIIlllIIIlIlI = 0; lllllllllllllllIllIIIIlllIIIlIlI < lllllllllllllllIllIIIIlllIIIlllI.getSizeInventory(); ++lllllllllllllllIllIIIIlllIIIlIlI) {
                final ItemStack lllllllllllllllIllIIIIlllIIIlIIl = lllllllllllllllIllIIIIlllIIIlllI.getStackInSlot(lllllllllllllllIllIIIIlllIIIlIlI);
                if (!lllllllllllllllIllIIIIlllIIIlIIl.func_190926_b()) {
                    if (Block.getBlockFromItem(lllllllllllllllIllIIIIlllIIIlIIl.getItem()) instanceof BlockShulkerBox) {
                        ++lllllllllllllllIllIIIIlllIIIllII;
                    }
                    else {
                        if (lllllllllllllllIllIIIIlllIIIlIIl.getItem() != Items.DYE) {
                            return false;
                        }
                        ++lllllllllllllllIllIIIIlllIIIlIll;
                    }
                    if (lllllllllllllllIllIIIIlllIIIlIll > 1 || lllllllllllllllIllIIIIlllIIIllII > 1) {
                        return false;
                    }
                }
            }
            return lllllllllllllllIllIIIIlllIIIllII == 1 && lllllllllllllllIllIIIIlllIIIlIll == 1;
        }
        
        @Override
        public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllllIllIIIIllIlllIlll) {
            ItemStack lllllllllllllllIllIIIIllIlllllII = ItemStack.field_190927_a;
            ItemStack lllllllllllllllIllIIIIllIllllIll = ItemStack.field_190927_a;
            for (int lllllllllllllllIllIIIIllIllllIlI = 0; lllllllllllllllIllIIIIllIllllIlI < lllllllllllllllIllIIIIllIlllIlll.getSizeInventory(); ++lllllllllllllllIllIIIIllIllllIlI) {
                final ItemStack lllllllllllllllIllIIIIllIllllIIl = lllllllllllllllIllIIIIllIlllIlll.getStackInSlot(lllllllllllllllIllIIIIllIllllIlI);
                if (!lllllllllllllllIllIIIIllIllllIIl.func_190926_b()) {
                    if (Block.getBlockFromItem(lllllllllllllllIllIIIIllIllllIIl.getItem()) instanceof BlockShulkerBox) {
                        lllllllllllllllIllIIIIllIlllllII = lllllllllllllllIllIIIIllIllllIIl;
                    }
                    else if (lllllllllllllllIllIIIIllIllllIIl.getItem() == Items.DYE) {
                        lllllllllllllllIllIIIIllIllllIll = lllllllllllllllIllIIIIllIllllIIl;
                    }
                }
            }
            final ItemStack lllllllllllllllIllIIIIllIllllIII = BlockShulkerBox.func_190953_b(EnumDyeColor.byDyeDamage(lllllllllllllllIllIIIIllIllllIll.getMetadata()));
            if (lllllllllllllllIllIIIIllIlllllII.hasTagCompound()) {
                lllllllllllllllIllIIIIllIllllIII.setTagCompound(lllllllllllllllIllIIIIllIlllllII.getTagCompound().copy());
            }
            return lllllllllllllllIllIIIIllIllllIII;
        }
        
        @Override
        public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting lllllllllllllllIllIIIIllIllIlIII) {
            final NonNullList<ItemStack> lllllllllllllllIllIIIIllIllIlIll = NonNullList.func_191197_a(lllllllllllllllIllIIIIllIllIlIII.getSizeInventory(), ItemStack.field_190927_a);
            for (int lllllllllllllllIllIIIIllIllIlIlI = 0; lllllllllllllllIllIIIIllIllIlIlI < lllllllllllllllIllIIIIllIllIlIll.size(); ++lllllllllllllllIllIIIIllIllIlIlI) {
                final ItemStack lllllllllllllllIllIIIIllIllIlIIl = lllllllllllllllIllIIIIllIllIlIII.getStackInSlot(lllllllllllllllIllIIIIllIllIlIlI);
                if (lllllllllllllllIllIIIIllIllIlIIl.getItem().hasContainerItem()) {
                    lllllllllllllllIllIIIIllIllIlIll.set(lllllllllllllllIllIIIIllIllIlIlI, new ItemStack(lllllllllllllllIllIIIIllIllIlIIl.getItem().getContainerItem()));
                }
            }
            return lllllllllllllllIllIIIIllIllIlIll;
        }
    }
}
