package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class ShieldRecipes
{
    public static class Decoration implements IRecipe
    {
        @Override
        public boolean matches(final InventoryCrafting lllllllllllllIIllllllllIlIlIIIIl, final World lllllllllllllIIllllllllIlIlIIIII) {
            ItemStack lllllllllllllIIllllllllIlIIlllll = ItemStack.field_190927_a;
            ItemStack lllllllllllllIIllllllllIlIIllllI = ItemStack.field_190927_a;
            for (int lllllllllllllIIllllllllIlIIlllIl = 0; lllllllllllllIIllllllllIlIIlllIl < lllllllllllllIIllllllllIlIlIIIIl.getSizeInventory(); ++lllllllllllllIIllllllllIlIIlllIl) {
                final ItemStack lllllllllllllIIllllllllIlIIlllII = lllllllllllllIIllllllllIlIlIIIIl.getStackInSlot(lllllllllllllIIllllllllIlIIlllIl);
                if (!lllllllllllllIIllllllllIlIIlllII.func_190926_b()) {
                    if (lllllllllllllIIllllllllIlIIlllII.getItem() == Items.BANNER) {
                        if (!lllllllllllllIIllllllllIlIIllllI.func_190926_b()) {
                            return false;
                        }
                        lllllllllllllIIllllllllIlIIllllI = lllllllllllllIIllllllllIlIIlllII;
                    }
                    else {
                        if (lllllllllllllIIllllllllIlIIlllII.getItem() != Items.SHIELD) {
                            return false;
                        }
                        if (!lllllllllllllIIllllllllIlIIlllll.func_190926_b()) {
                            return false;
                        }
                        if (lllllllllllllIIllllllllIlIIlllII.getSubCompound("BlockEntityTag") != null) {
                            return false;
                        }
                        lllllllllllllIIllllllllIlIIlllll = lllllllllllllIIllllllllIlIIlllII;
                    }
                }
            }
            return !lllllllllllllIIllllllllIlIIlllll.func_190926_b() && !lllllllllllllIIllllllllIlIIllllI.func_190926_b();
        }
        
        @Override
        public ItemStack getRecipeOutput() {
            return ItemStack.field_190927_a;
        }
        
        @Override
        public boolean func_192399_d() {
            return true;
        }
        
        @Override
        public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllIIllllllllIlIIlIIII) {
            ItemStack lllllllllllllIIllllllllIlIIIllll = ItemStack.field_190927_a;
            ItemStack lllllllllllllIIllllllllIlIIIlllI = ItemStack.field_190927_a;
            for (int lllllllllllllIIllllllllIlIIIllIl = 0; lllllllllllllIIllllllllIlIIIllIl < lllllllllllllIIllllllllIlIIlIIII.getSizeInventory(); ++lllllllllllllIIllllllllIlIIIllIl) {
                final ItemStack lllllllllllllIIllllllllIlIIIllII = lllllllllllllIIllllllllIlIIlIIII.getStackInSlot(lllllllllllllIIllllllllIlIIIllIl);
                if (!lllllllllllllIIllllllllIlIIIllII.func_190926_b()) {
                    if (lllllllllllllIIllllllllIlIIIllII.getItem() == Items.BANNER) {
                        lllllllllllllIIllllllllIlIIIllll = lllllllllllllIIllllllllIlIIIllII;
                    }
                    else if (lllllllllllllIIllllllllIlIIIllII.getItem() == Items.SHIELD) {
                        lllllllllllllIIllllllllIlIIIlllI = lllllllllllllIIllllllllIlIIIllII.copy();
                    }
                }
            }
            if (lllllllllllllIIllllllllIlIIIlllI.func_190926_b()) {
                return lllllllllllllIIllllllllIlIIIlllI;
            }
            final NBTTagCompound lllllllllllllIIllllllllIlIIIlIll = lllllllllllllIIllllllllIlIIIllll.getSubCompound("BlockEntityTag");
            final NBTTagCompound lllllllllllllIIllllllllIlIIIlIlI = (lllllllllllllIIllllllllIlIIIlIll == null) ? new NBTTagCompound() : lllllllllllllIIllllllllIlIIIlIll.copy();
            lllllllllllllIIllllllllIlIIIlIlI.setInteger("Base", lllllllllllllIIllllllllIlIIIllll.getMetadata() & 0xF);
            lllllllllllllIIllllllllIlIIIlllI.setTagInfo("BlockEntityTag", lllllllllllllIIllllllllIlIIIlIlI);
            return lllllllllllllIIllllllllIlIIIlllI;
        }
        
        @Override
        public boolean func_194133_a(final int lllllllllllllIIllllllllIIlllIIlI, final int lllllllllllllIIllllllllIIlllIIIl) {
            return lllllllllllllIIllllllllIIlllIIlI * lllllllllllllIIllllllllIIlllIIIl >= 2;
        }
        
        @Override
        public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting lllllllllllllIIllllllllIIllllllI) {
            final NonNullList<ItemStack> lllllllllllllIIllllllllIIlllllIl = NonNullList.func_191197_a(lllllllllllllIIllllllllIIllllllI.getSizeInventory(), ItemStack.field_190927_a);
            for (int lllllllllllllIIllllllllIIlllllII = 0; lllllllllllllIIllllllllIIlllllII < lllllllllllllIIllllllllIIlllllIl.size(); ++lllllllllllllIIllllllllIIlllllII) {
                final ItemStack lllllllllllllIIllllllllIIllllIll = lllllllllllllIIllllllllIIllllllI.getStackInSlot(lllllllllllllIIllllllllIIlllllII);
                if (lllllllllllllIIllllllllIIllllIll.getItem().hasContainerItem()) {
                    lllllllllllllIIllllllllIIlllllIl.set(lllllllllllllIIllllllllIIlllllII, new ItemStack(lllllllllllllIIllllllllIIllllIll.getItem().getContainerItem()));
                }
            }
            return lllllllllllllIIllllllllIIlllllIl;
        }
    }
}
