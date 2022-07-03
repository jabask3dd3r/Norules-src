package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.util.*;

public class RecipesArmorDyes implements IRecipe
{
    @Override
    public boolean func_192399_d() {
        return true;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllllIIllIIlIIllIlIIII) {
        ItemStack lllllllllllllllIIllIIlIIllIIllll = ItemStack.field_190927_a;
        final int[] lllllllllllllllIIllIIlIIllIIlllI = new int[3];
        int lllllllllllllllIIllIIlIIllIIllIl = 0;
        int lllllllllllllllIIllIIlIIllIIllII = 0;
        ItemArmor lllllllllllllllIIllIIlIIllIIlIll = null;
        for (int lllllllllllllllIIllIIlIIllIIlIlI = 0; lllllllllllllllIIllIIlIIllIIlIlI < lllllllllllllllIIllIIlIIllIlIIII.getSizeInventory(); ++lllllllllllllllIIllIIlIIllIIlIlI) {
            final ItemStack lllllllllllllllIIllIIlIIllIIlIIl = lllllllllllllllIIllIIlIIllIlIIII.getStackInSlot(lllllllllllllllIIllIIlIIllIIlIlI);
            if (!lllllllllllllllIIllIIlIIllIIlIIl.func_190926_b()) {
                if (lllllllllllllllIIllIIlIIllIIlIIl.getItem() instanceof ItemArmor) {
                    lllllllllllllllIIllIIlIIllIIlIll = (ItemArmor)lllllllllllllllIIllIIlIIllIIlIIl.getItem();
                    if (lllllllllllllllIIllIIlIIllIIlIll.getArmorMaterial() != ItemArmor.ArmorMaterial.LEATHER || !lllllllllllllllIIllIIlIIllIIllll.func_190926_b()) {
                        return ItemStack.field_190927_a;
                    }
                    lllllllllllllllIIllIIlIIllIIllll = lllllllllllllllIIllIIlIIllIIlIIl.copy();
                    lllllllllllllllIIllIIlIIllIIllll.func_190920_e(1);
                    if (lllllllllllllllIIllIIlIIllIIlIll.hasColor(lllllllllllllllIIllIIlIIllIIlIIl)) {
                        final int lllllllllllllllIIllIIlIIllIIlIII = lllllllllllllllIIllIIlIIllIIlIll.getColor(lllllllllllllllIIllIIlIIllIIllll);
                        final float lllllllllllllllIIllIIlIIllIIIlll = (lllllllllllllllIIllIIlIIllIIlIII >> 16 & 0xFF) / 255.0f;
                        final float lllllllllllllllIIllIIlIIllIIIllI = (lllllllllllllllIIllIIlIIllIIlIII >> 8 & 0xFF) / 255.0f;
                        final float lllllllllllllllIIllIIlIIllIIIlIl = (lllllllllllllllIIllIIlIIllIIlIII & 0xFF) / 255.0f;
                        lllllllllllllllIIllIIlIIllIIllIl += (int)(Math.max(lllllllllllllllIIllIIlIIllIIIlll, Math.max(lllllllllllllllIIllIIlIIllIIIllI, lllllllllllllllIIllIIlIIllIIIlIl)) * 255.0f);
                        lllllllllllllllIIllIIlIIllIIlllI[0] += (int)(lllllllllllllllIIllIIlIIllIIIlll * 255.0f);
                        lllllllllllllllIIllIIlIIllIIlllI[1] += (int)(lllllllllllllllIIllIIlIIllIIIllI * 255.0f);
                        lllllllllllllllIIllIIlIIllIIlllI[2] += (int)(lllllllllllllllIIllIIlIIllIIIlIl * 255.0f);
                        ++lllllllllllllllIIllIIlIIllIIllII;
                    }
                }
                else {
                    if (lllllllllllllllIIllIIlIIllIIlIIl.getItem() != Items.DYE) {
                        return ItemStack.field_190927_a;
                    }
                    final float[] lllllllllllllllIIllIIlIIllIIIlII = EnumDyeColor.byDyeDamage(lllllllllllllllIIllIIlIIllIIlIIl.getMetadata()).func_193349_f();
                    final int lllllllllllllllIIllIIlIIllIIIIll = (int)(lllllllllllllllIIllIIlIIllIIIlII[0] * 255.0f);
                    final int lllllllllllllllIIllIIlIIllIIIIlI = (int)(lllllllllllllllIIllIIlIIllIIIlII[1] * 255.0f);
                    final int lllllllllllllllIIllIIlIIllIIIIIl = (int)(lllllllllllllllIIllIIlIIllIIIlII[2] * 255.0f);
                    lllllllllllllllIIllIIlIIllIIllIl += Math.max(lllllllllllllllIIllIIlIIllIIIIll, Math.max(lllllllllllllllIIllIIlIIllIIIIlI, lllllllllllllllIIllIIlIIllIIIIIl));
                    final int[] array = lllllllllllllllIIllIIlIIllIIlllI;
                    final int n = 0;
                    array[n] += lllllllllllllllIIllIIlIIllIIIIll;
                    final int[] array2 = lllllllllllllllIIllIIlIIllIIlllI;
                    final int n2 = 1;
                    array2[n2] += lllllllllllllllIIllIIlIIllIIIIlI;
                    final int[] array3 = lllllllllllllllIIllIIlIIllIIlllI;
                    final int n3 = 2;
                    array3[n3] += lllllllllllllllIIllIIlIIllIIIIIl;
                    ++lllllllllllllllIIllIIlIIllIIllII;
                }
            }
        }
        if (lllllllllllllllIIllIIlIIllIIlIll == null) {
            return ItemStack.field_190927_a;
        }
        int lllllllllllllllIIllIIlIIllIIIIII = lllllllllllllllIIllIIlIIllIIlllI[0] / lllllllllllllllIIllIIlIIllIIllII;
        int lllllllllllllllIIllIIlIIlIllllll = lllllllllllllllIIllIIlIIllIIlllI[1] / lllllllllllllllIIllIIlIIllIIllII;
        int lllllllllllllllIIllIIlIIlIlllllI = lllllllllllllllIIllIIlIIllIIlllI[2] / lllllllllllllllIIllIIlIIllIIllII;
        final float lllllllllllllllIIllIIlIIlIllllIl = lllllllllllllllIIllIIlIIllIIllIl / (float)lllllllllllllllIIllIIlIIllIIllII;
        final float lllllllllllllllIIllIIlIIlIllllII = (float)Math.max(lllllllllllllllIIllIIlIIllIIIIII, Math.max(lllllllllllllllIIllIIlIIlIllllll, lllllllllllllllIIllIIlIIlIlllllI));
        lllllllllllllllIIllIIlIIllIIIIII = (int)(lllllllllllllllIIllIIlIIllIIIIII * lllllllllllllllIIllIIlIIlIllllIl / lllllllllllllllIIllIIlIIlIllllII);
        lllllllllllllllIIllIIlIIlIllllll = (int)(lllllllllllllllIIllIIlIIlIllllll * lllllllllllllllIIllIIlIIlIllllIl / lllllllllllllllIIllIIlIIlIllllII);
        lllllllllllllllIIllIIlIIlIlllllI = (int)(lllllllllllllllIIllIIlIIlIlllllI * lllllllllllllllIIllIIlIIlIllllIl / lllllllllllllllIIllIIlIIlIllllII);
        int lllllllllllllllIIllIIlIIlIlllIll = (lllllllllllllllIIllIIlIIllIIIIII << 8) + lllllllllllllllIIllIIlIIlIllllll;
        lllllllllllllllIIllIIlIIlIlllIll = (lllllllllllllllIIllIIlIIlIlllIll << 8) + lllllllllllllllIIllIIlIIlIlllllI;
        lllllllllllllllIIllIIlIIllIIlIll.setColor(lllllllllllllllIIllIIlIIllIIllll, lllllllllllllllIIllIIlIIlIlllIll);
        return lllllllllllllllIIllIIlIIllIIllll;
    }
    
    @Override
    public boolean matches(final InventoryCrafting lllllllllllllllIIllIIlIIlllIIIll, final World lllllllllllllllIIllIIlIIlllIlIIl) {
        ItemStack lllllllllllllllIIllIIlIIlllIlIII = ItemStack.field_190927_a;
        final List<ItemStack> lllllllllllllllIIllIIlIIlllIIlll = (List<ItemStack>)Lists.newArrayList();
        for (int lllllllllllllllIIllIIlIIlllIIllI = 0; lllllllllllllllIIllIIlIIlllIIllI < lllllllllllllllIIllIIlIIlllIIIll.getSizeInventory(); ++lllllllllllllllIIllIIlIIlllIIllI) {
            final ItemStack lllllllllllllllIIllIIlIIlllIIlIl = lllllllllllllllIIllIIlIIlllIIIll.getStackInSlot(lllllllllllllllIIllIIlIIlllIIllI);
            if (!lllllllllllllllIIllIIlIIlllIIlIl.func_190926_b()) {
                if (lllllllllllllllIIllIIlIIlllIIlIl.getItem() instanceof ItemArmor) {
                    final ItemArmor lllllllllllllllIIllIIlIIlllIIlII = (ItemArmor)lllllllllllllllIIllIIlIIlllIIlIl.getItem();
                    if (lllllllllllllllIIllIIlIIlllIIlII.getArmorMaterial() != ItemArmor.ArmorMaterial.LEATHER || !lllllllllllllllIIllIIlIIlllIlIII.func_190926_b()) {
                        return false;
                    }
                    lllllllllllllllIIllIIlIIlllIlIII = lllllllllllllllIIllIIlIIlllIIlIl;
                }
                else {
                    if (lllllllllllllllIIllIIlIIlllIIlIl.getItem() != Items.DYE) {
                        return false;
                    }
                    lllllllllllllllIIllIIlIIlllIIlll.add(lllllllllllllllIIllIIlIIlllIIlIl);
                }
            }
        }
        return !lllllllllllllllIIllIIlIIlllIlIII.func_190926_b() && !lllllllllllllllIIllIIlIIlllIIlll.isEmpty();
    }
    
    @Override
    public boolean func_194133_a(final int lllllllllllllllIIllIIlIIlIIlllII, final int lllllllllllllllIIllIIlIIlIIllIll) {
        return lllllllllllllllIIllIIlIIlIIlllII * lllllllllllllllIIllIIlIIlIIllIll >= 2;
    }
    
    @Override
    public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting lllllllllllllllIIllIIlIIlIlIlIII) {
        final NonNullList<ItemStack> lllllllllllllllIIllIIlIIlIlIIlll = NonNullList.func_191197_a(lllllllllllllllIIllIIlIIlIlIlIII.getSizeInventory(), ItemStack.field_190927_a);
        for (int lllllllllllllllIIllIIlIIlIlIIllI = 0; lllllllllllllllIIllIIlIIlIlIIllI < lllllllllllllllIIllIIlIIlIlIIlll.size(); ++lllllllllllllllIIllIIlIIlIlIIllI) {
            final ItemStack lllllllllllllllIIllIIlIIlIlIIlIl = lllllllllllllllIIllIIlIIlIlIlIII.getStackInSlot(lllllllllllllllIIllIIlIIlIlIIllI);
            if (lllllllllllllllIIllIIlIIlIlIIlIl.getItem().hasContainerItem()) {
                lllllllllllllllIIllIIlIIlIlIIlll.set(lllllllllllllllIIllIIlIIlIlIIllI, new ItemStack(lllllllllllllllIIllIIlIIlIlIIlIl.getItem().getContainerItem()));
            }
        }
        return lllllllllllllllIIllIIlIIlIlIIlll;
    }
}
