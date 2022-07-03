package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;

public class RecipesBanners
{
    public static class RecipeAddPattern implements IRecipe
    {
        @Override
        public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting lllllllllllllIIIIlIIlIIIIlIIIlIl) {
            final NonNullList<ItemStack> lllllllllllllIIIIlIIlIIIIlIIlIII = NonNullList.func_191197_a(lllllllllllllIIIIlIIlIIIIlIIIlIl.getSizeInventory(), ItemStack.field_190927_a);
            for (int lllllllllllllIIIIlIIlIIIIlIIIlll = 0; lllllllllllllIIIIlIIlIIIIlIIIlll < lllllllllllllIIIIlIIlIIIIlIIlIII.size(); ++lllllllllllllIIIIlIIlIIIIlIIIlll) {
                final ItemStack lllllllllllllIIIIlIIlIIIIlIIIllI = lllllllllllllIIIIlIIlIIIIlIIIlIl.getStackInSlot(lllllllllllllIIIIlIIlIIIIlIIIlll);
                if (lllllllllllllIIIIlIIlIIIIlIIIllI.getItem().hasContainerItem()) {
                    lllllllllllllIIIIlIIlIIIIlIIlIII.set(lllllllllllllIIIIlIIlIIIIlIIIlll, new ItemStack(lllllllllllllIIIIlIIlIIIIlIIIllI.getItem().getContainerItem()));
                }
            }
            return lllllllllllllIIIIlIIlIIIIlIIlIII;
        }
        
        @Override
        public boolean func_194133_a(final int lllllllllllllIIIIlIIlIIIIIIllIII, final int lllllllllllllIIIIlIIlIIIIIIlIlll) {
            return lllllllllllllIIIIlIIlIIIIIIllIII >= 3 && lllllllllllllIIIIlIIlIIIIIIlIlll >= 3;
        }
        
        @Nullable
        private BannerPattern func_190933_c(final InventoryCrafting lllllllllllllIIIIlIIlIIIIIlIlIIl) {
            final double lllllllllllllIIIIlIIlIIIIIlIIlIl;
            final byte lllllllllllllIIIIlIIlIIIIIlIIllI = (byte)((BannerPattern[])(Object)(lllllllllllllIIIIlIIlIIIIIlIIlIl = (double)(Object)BannerPattern.values())).length;
            for (double lllllllllllllIIIIlIIlIIIIIlIIlll = 0; lllllllllllllIIIIlIIlIIIIIlIIlll < lllllllllllllIIIIlIIlIIIIIlIIllI; ++lllllllllllllIIIIlIIlIIIIIlIIlll) {
                final BannerPattern lllllllllllllIIIIlIIlIIIIIllIlII = lllllllllllllIIIIlIIlIIIIIlIIlIl[lllllllllllllIIIIlIIlIIIIIlIIlll];
                if (lllllllllllllIIIIlIIlIIIIIllIlII.func_191000_d()) {
                    boolean lllllllllllllIIIIlIIlIIIIIllIIll = true;
                    if (lllllllllllllIIIIlIIlIIIIIllIlII.func_190999_e()) {
                        boolean lllllllllllllIIIIlIIlIIIIIllIIlI = false;
                        boolean lllllllllllllIIIIlIIlIIIIIllIIIl = false;
                        for (int lllllllllllllIIIIlIIlIIIIIllIIII = 0; lllllllllllllIIIIlIIlIIIIIllIIII < lllllllllllllIIIIlIIlIIIIIlIlIIl.getSizeInventory() && lllllllllllllIIIIlIIlIIIIIllIIll; ++lllllllllllllIIIIlIIlIIIIIllIIII) {
                            final ItemStack lllllllllllllIIIIlIIlIIIIIlIllll = lllllllllllllIIIIlIIlIIIIIlIlIIl.getStackInSlot(lllllllllllllIIIIlIIlIIIIIllIIII);
                            if (!lllllllllllllIIIIlIIlIIIIIlIllll.func_190926_b() && lllllllllllllIIIIlIIlIIIIIlIllll.getItem() != Items.BANNER) {
                                if (lllllllllllllIIIIlIIlIIIIIlIllll.getItem() == Items.DYE) {
                                    if (lllllllllllllIIIIlIIlIIIIIllIIIl) {
                                        lllllllllllllIIIIlIIlIIIIIllIIll = false;
                                        break;
                                    }
                                    lllllllllllllIIIIlIIlIIIIIllIIIl = true;
                                }
                                else {
                                    if (lllllllllllllIIIIlIIlIIIIIllIIlI || !lllllllllllllIIIIlIIlIIIIIlIllll.isItemEqual(lllllllllllllIIIIlIIlIIIIIllIlII.func_190998_f())) {
                                        lllllllllllllIIIIlIIlIIIIIllIIll = false;
                                        break;
                                    }
                                    lllllllllllllIIIIlIIlIIIIIllIIlI = true;
                                }
                            }
                        }
                        if (!lllllllllllllIIIIlIIlIIIIIllIIlI || !lllllllllllllIIIIlIIlIIIIIllIIIl) {
                            lllllllllllllIIIIlIIlIIIIIllIIll = false;
                        }
                    }
                    else if (lllllllllllllIIIIlIIlIIIIIlIlIIl.getSizeInventory() == lllllllllllllIIIIlIIlIIIIIllIlII.func_190996_c().length * lllllllllllllIIIIlIIlIIIIIllIlII.func_190996_c()[0].length()) {
                        int lllllllllllllIIIIlIIlIIIIIlIlllI = -1;
                        for (int lllllllllllllIIIIlIIlIIIIIlIllIl = 0; lllllllllllllIIIIlIIlIIIIIlIllIl < lllllllllllllIIIIlIIlIIIIIlIlIIl.getSizeInventory(); ++lllllllllllllIIIIlIIlIIIIIlIllIl) {
                            if (!lllllllllllllIIIIlIIlIIIIIllIIll) {
                                break;
                            }
                            final int lllllllllllllIIIIlIIlIIIIIlIllII = lllllllllllllIIIIlIIlIIIIIlIllIl / 3;
                            final int lllllllllllllIIIIlIIlIIIIIlIlIll = lllllllllllllIIIIlIIlIIIIIlIllIl % 3;
                            final ItemStack lllllllllllllIIIIlIIlIIIIIlIlIlI = lllllllllllllIIIIlIIlIIIIIlIlIIl.getStackInSlot(lllllllllllllIIIIlIIlIIIIIlIllIl);
                            if (!lllllllllllllIIIIlIIlIIIIIlIlIlI.func_190926_b() && lllllllllllllIIIIlIIlIIIIIlIlIlI.getItem() != Items.BANNER) {
                                if (lllllllllllllIIIIlIIlIIIIIlIlIlI.getItem() != Items.DYE) {
                                    lllllllllllllIIIIlIIlIIIIIllIIll = false;
                                    break;
                                }
                                if (lllllllllllllIIIIlIIlIIIIIlIlllI != -1 && lllllllllllllIIIIlIIlIIIIIlIlllI != lllllllllllllIIIIlIIlIIIIIlIlIlI.getMetadata()) {
                                    lllllllllllllIIIIlIIlIIIIIllIIll = false;
                                    break;
                                }
                                if (lllllllllllllIIIIlIIlIIIIIllIlII.func_190996_c()[lllllllllllllIIIIlIIlIIIIIlIllII].charAt(lllllllllllllIIIIlIIlIIIIIlIlIll) == ' ') {
                                    lllllllllllllIIIIlIIlIIIIIllIIll = false;
                                    break;
                                }
                                lllllllllllllIIIIlIIlIIIIIlIlllI = lllllllllllllIIIIlIIlIIIIIlIlIlI.getMetadata();
                            }
                            else if (lllllllllllllIIIIlIIlIIIIIllIlII.func_190996_c()[lllllllllllllIIIIlIIlIIIIIlIllII].charAt(lllllllllllllIIIIlIIlIIIIIlIlIll) != ' ') {
                                lllllllllllllIIIIlIIlIIIIIllIIll = false;
                                break;
                            }
                        }
                    }
                    else {
                        lllllllllllllIIIIlIIlIIIIIllIIll = false;
                    }
                    if (lllllllllllllIIIIlIIlIIIIIllIIll) {
                        return lllllllllllllIIIIlIIlIIIIIllIlII;
                    }
                }
            }
            return null;
        }
        
        @Override
        public boolean matches(final InventoryCrafting lllllllllllllIIIIlIIlIIIIlllIIII, final World lllllllllllllIIIIlIIlIIIIlllIlIl) {
            boolean lllllllllllllIIIIlIIlIIIIlllIlII = false;
            for (int lllllllllllllIIIIlIIlIIIIlllIIll = 0; lllllllllllllIIIIlIIlIIIIlllIIll < lllllllllllllIIIIlIIlIIIIlllIIII.getSizeInventory(); ++lllllllllllllIIIIlIIlIIIIlllIIll) {
                final ItemStack lllllllllllllIIIIlIIlIIIIlllIIlI = lllllllllllllIIIIlIIlIIIIlllIIII.getStackInSlot(lllllllllllllIIIIlIIlIIIIlllIIll);
                if (lllllllllllllIIIIlIIlIIIIlllIIlI.getItem() == Items.BANNER) {
                    if (lllllllllllllIIIIlIIlIIIIlllIlII) {
                        return false;
                    }
                    if (TileEntityBanner.getPatterns(lllllllllllllIIIIlIIlIIIIlllIIlI) >= 6) {
                        return false;
                    }
                    lllllllllllllIIIIlIIlIIIIlllIlII = true;
                }
            }
            return lllllllllllllIIIIlIIlIIIIlllIlII && this.func_190933_c(lllllllllllllIIIIlIIlIIIIlllIIII) != null;
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
        public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllIIIIlIIlIIIIlIlIllI) {
            ItemStack lllllllllllllIIIIlIIlIIIIllIIIlI = ItemStack.field_190927_a;
            for (int lllllllllllllIIIIlIIlIIIIllIIIIl = 0; lllllllllllllIIIIlIIlIIIIllIIIIl < lllllllllllllIIIIlIIlIIIIlIlIllI.getSizeInventory(); ++lllllllllllllIIIIlIIlIIIIllIIIIl) {
                final ItemStack lllllllllllllIIIIlIIlIIIIllIIIII = lllllllllllllIIIIlIIlIIIIlIlIllI.getStackInSlot(lllllllllllllIIIIlIIlIIIIllIIIIl);
                if (!lllllllllllllIIIIlIIlIIIIllIIIII.func_190926_b() && lllllllllllllIIIIlIIlIIIIllIIIII.getItem() == Items.BANNER) {
                    lllllllllllllIIIIlIIlIIIIllIIIlI = lllllllllllllIIIIlIIlIIIIllIIIII.copy();
                    lllllllllllllIIIIlIIlIIIIllIIIlI.func_190920_e(1);
                    break;
                }
            }
            final BannerPattern lllllllllllllIIIIlIIlIIIIlIlllll = this.func_190933_c(lllllllllllllIIIIlIIlIIIIlIlIllI);
            if (lllllllllllllIIIIlIIlIIIIlIlllll != null) {
                int lllllllllllllIIIIlIIlIIIIlIllllI = 0;
                for (int lllllllllllllIIIIlIIlIIIIlIlllIl = 0; lllllllllllllIIIIlIIlIIIIlIlllIl < lllllllllllllIIIIlIIlIIIIlIlIllI.getSizeInventory(); ++lllllllllllllIIIIlIIlIIIIlIlllIl) {
                    final ItemStack lllllllllllllIIIIlIIlIIIIlIlllII = lllllllllllllIIIIlIIlIIIIlIlIllI.getStackInSlot(lllllllllllllIIIIlIIlIIIIlIlllIl);
                    if (lllllllllllllIIIIlIIlIIIIlIlllII.getItem() == Items.DYE) {
                        lllllllllllllIIIIlIIlIIIIlIllllI = lllllllllllllIIIIlIIlIIIIlIlllII.getMetadata();
                        break;
                    }
                }
                final NBTTagCompound lllllllllllllIIIIlIIlIIIIlIllIll = lllllllllllllIIIIlIIlIIIIllIIIlI.func_190925_c("BlockEntityTag");
                NBTTagList lllllllllllllIIIIlIIlIIIIlIllIIl = null;
                if (lllllllllllllIIIIlIIlIIIIlIllIll.hasKey("Patterns", 9)) {
                    final NBTTagList lllllllllllllIIIIlIIlIIIIlIllIlI = lllllllllllllIIIIlIIlIIIIlIllIll.getTagList("Patterns", 10);
                }
                else {
                    lllllllllllllIIIIlIIlIIIIlIllIIl = new NBTTagList();
                    lllllllllllllIIIIlIIlIIIIlIllIll.setTag("Patterns", lllllllllllllIIIIlIIlIIIIlIllIIl);
                }
                final NBTTagCompound lllllllllllllIIIIlIIlIIIIlIllIII = new NBTTagCompound();
                lllllllllllllIIIIlIIlIIIIlIllIII.setString("Pattern", lllllllllllllIIIIlIIlIIIIlIlllll.func_190993_b());
                lllllllllllllIIIIlIIlIIIIlIllIII.setInteger("Color", lllllllllllllIIIIlIIlIIIIlIllllI);
                lllllllllllllIIIIlIIlIIIIlIllIIl.appendTag(lllllllllllllIIIIlIIlIIIIlIllIII);
            }
            return lllllllllllllIIIIlIIlIIIIllIIIlI;
        }
    }
    
    public static class RecipeDuplicatePattern implements IRecipe
    {
        @Override
        public ItemStack getCraftingResult(final InventoryCrafting llllllllllllllIllIllIlIIlIllllII) {
            for (int llllllllllllllIllIllIlIIlIlllIll = 0; llllllllllllllIllIllIlIIlIlllIll < llllllllllllllIllIllIlIIlIllllII.getSizeInventory(); ++llllllllllllllIllIllIlIIlIlllIll) {
                final ItemStack llllllllllllllIllIllIlIIlIlllIlI = llllllllllllllIllIllIlIIlIllllII.getStackInSlot(llllllllllllllIllIllIlIIlIlllIll);
                if (!llllllllllllllIllIllIlIIlIlllIlI.func_190926_b() && TileEntityBanner.getPatterns(llllllllllllllIllIllIlIIlIlllIlI) > 0) {
                    final ItemStack llllllllllllllIllIllIlIIlIlllIIl = llllllllllllllIllIllIlIIlIlllIlI.copy();
                    llllllllllllllIllIllIlIIlIlllIIl.func_190920_e(1);
                    return llllllllllllllIllIllIlIIlIlllIIl;
                }
            }
            return ItemStack.field_190927_a;
        }
        
        @Override
        public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting llllllllllllllIllIllIlIIlIlIlIII) {
            final NonNullList<ItemStack> llllllllllllllIllIllIlIIlIlIllII = NonNullList.func_191197_a(llllllllllllllIllIllIlIIlIlIlIII.getSizeInventory(), ItemStack.field_190927_a);
            for (int llllllllllllllIllIllIlIIlIlIlIll = 0; llllllllllllllIllIllIlIIlIlIlIll < llllllllllllllIllIllIlIIlIlIllII.size(); ++llllllllllllllIllIllIlIIlIlIlIll) {
                final ItemStack llllllllllllllIllIllIlIIlIlIlIlI = llllllllllllllIllIllIlIIlIlIlIII.getStackInSlot(llllllllllllllIllIllIlIIlIlIlIll);
                if (!llllllllllllllIllIllIlIIlIlIlIlI.func_190926_b()) {
                    if (llllllllllllllIllIllIlIIlIlIlIlI.getItem().hasContainerItem()) {
                        llllllllllllllIllIllIlIIlIlIllII.set(llllllllllllllIllIllIlIIlIlIlIll, new ItemStack(llllllllllllllIllIllIlIIlIlIlIlI.getItem().getContainerItem()));
                    }
                    else if (llllllllllllllIllIllIlIIlIlIlIlI.hasTagCompound() && TileEntityBanner.getPatterns(llllllllllllllIllIllIlIIlIlIlIlI) > 0) {
                        final ItemStack llllllllllllllIllIllIlIIlIlIlIIl = llllllllllllllIllIllIlIIlIlIlIlI.copy();
                        llllllllllllllIllIllIlIIlIlIlIIl.func_190920_e(1);
                        llllllllllllllIllIllIlIIlIlIllII.set(llllllllllllllIllIllIlIIlIlIlIll, llllllllllllllIllIllIlIIlIlIlIIl);
                    }
                }
            }
            return llllllllllllllIllIllIlIIlIlIllII;
        }
        
        @Override
        public ItemStack getRecipeOutput() {
            return ItemStack.field_190927_a;
        }
        
        @Override
        public boolean func_194133_a(final int llllllllllllllIllIllIlIIlIIlllll, final int llllllllllllllIllIllIlIIlIIllllI) {
            return llllllllllllllIllIllIlIIlIIlllll * llllllllllllllIllIllIlIIlIIllllI >= 2;
        }
        
        @Override
        public boolean matches(final InventoryCrafting llllllllllllllIllIllIlIIllIIlIII, final World llllllllllllllIllIllIlIIllIIllll) {
            ItemStack llllllllllllllIllIllIlIIllIIlllI = ItemStack.field_190927_a;
            ItemStack llllllllllllllIllIllIlIIllIIllIl = ItemStack.field_190927_a;
            for (int llllllllllllllIllIllIlIIllIIllII = 0; llllllllllllllIllIllIlIIllIIllII < llllllllllllllIllIllIlIIllIIlIII.getSizeInventory(); ++llllllllllllllIllIllIlIIllIIllII) {
                final ItemStack llllllllllllllIllIllIlIIllIIlIll = llllllllllllllIllIllIlIIllIIlIII.getStackInSlot(llllllllllllllIllIllIlIIllIIllII);
                if (!llllllllllllllIllIllIlIIllIIlIll.func_190926_b()) {
                    if (llllllllllllllIllIllIlIIllIIlIll.getItem() != Items.BANNER) {
                        return false;
                    }
                    if (!llllllllllllllIllIllIlIIllIIlllI.func_190926_b() && !llllllllllllllIllIllIlIIllIIllIl.func_190926_b()) {
                        return false;
                    }
                    final EnumDyeColor llllllllllllllIllIllIlIIllIIlIlI = ItemBanner.getBaseColor(llllllllllllllIllIllIlIIllIIlIll);
                    final boolean llllllllllllllIllIllIlIIllIIlIIl = TileEntityBanner.getPatterns(llllllllllllllIllIllIlIIllIIlIll) > 0;
                    if (!llllllllllllllIllIllIlIIllIIlllI.func_190926_b()) {
                        if (llllllllllllllIllIllIlIIllIIlIIl) {
                            return false;
                        }
                        if (llllllllllllllIllIllIlIIllIIlIlI != ItemBanner.getBaseColor(llllllllllllllIllIllIlIIllIIlllI)) {
                            return false;
                        }
                        llllllllllllllIllIllIlIIllIIllIl = llllllllllllllIllIllIlIIllIIlIll;
                    }
                    else if (!llllllllllllllIllIllIlIIllIIllIl.func_190926_b()) {
                        if (!llllllllllllllIllIllIlIIllIIlIIl) {
                            return false;
                        }
                        if (llllllllllllllIllIllIlIIllIIlIlI != ItemBanner.getBaseColor(llllllllllllllIllIllIlIIllIIllIl)) {
                            return false;
                        }
                        llllllllllllllIllIllIlIIllIIlllI = llllllllllllllIllIllIlIIllIIlIll;
                    }
                    else if (llllllllllllllIllIllIlIIllIIlIIl) {
                        llllllllllllllIllIllIlIIllIIlllI = llllllllllllllIllIllIlIIllIIlIll;
                    }
                    else {
                        llllllllllllllIllIllIlIIllIIllIl = llllllllllllllIllIllIlIIllIIlIll;
                    }
                }
            }
            return !llllllllllllllIllIllIlIIllIIlllI.func_190926_b() && !llllllllllllllIllIllIlIIllIIllIl.func_190926_b();
        }
        
        @Override
        public boolean func_192399_d() {
            return true;
        }
    }
}
