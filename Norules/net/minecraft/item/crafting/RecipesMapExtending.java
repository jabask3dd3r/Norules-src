package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class RecipesMapExtending extends ShapedRecipes
{
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllllIlIIllIllIlllIlII) {
        ItemStack lllllllllllllllIlIIllIllIlllIlll = ItemStack.field_190927_a;
        for (int lllllllllllllllIlIIllIllIlllIllI = 0; lllllllllllllllIlIIllIllIlllIllI < lllllllllllllllIlIIllIllIlllIlII.getSizeInventory() && lllllllllllllllIlIIllIllIlllIlll.func_190926_b(); ++lllllllllllllllIlIIllIllIlllIllI) {
            final ItemStack lllllllllllllllIlIIllIllIlllIlIl = lllllllllllllllIlIIllIllIlllIlII.getStackInSlot(lllllllllllllllIlIIllIllIlllIllI);
            if (lllllllllllllllIlIIllIllIlllIlIl.getItem() == Items.FILLED_MAP) {
                lllllllllllllllIlIIllIllIlllIlll = lllllllllllllllIlIIllIllIlllIlIl;
            }
        }
        lllllllllllllllIlIIllIllIlllIlll = lllllllllllllllIlIIllIllIlllIlll.copy();
        lllllllllllllllIlIIllIllIlllIlll.func_190920_e(1);
        if (lllllllllllllllIlIIllIllIlllIlll.getTagCompound() == null) {
            lllllllllllllllIlIIllIllIlllIlll.setTagCompound(new NBTTagCompound());
        }
        lllllllllllllllIlIIllIllIlllIlll.getTagCompound().setInteger("map_scale_direction", 1);
        return lllllllllllllllIlIIllIllIlllIlll;
    }
    
    @Override
    public boolean func_192399_d() {
        return true;
    }
    
    @Override
    public boolean matches(final InventoryCrafting lllllllllllllllIlIIllIlllIIlIIlI, final World lllllllllllllllIlIIllIlllIIlIIIl) {
        if (!super.matches(lllllllllllllllIlIIllIlllIIlIIlI, lllllllllllllllIlIIllIlllIIlIIIl)) {
            return false;
        }
        ItemStack lllllllllllllllIlIIllIlllIIlIIII = ItemStack.field_190927_a;
        for (int lllllllllllllllIlIIllIlllIIIllll = 0; lllllllllllllllIlIIllIlllIIIllll < lllllllllllllllIlIIllIlllIIlIIlI.getSizeInventory() && lllllllllllllllIlIIllIlllIIlIIII.func_190926_b(); ++lllllllllllllllIlIIllIlllIIIllll) {
            final ItemStack lllllllllllllllIlIIllIlllIIIlllI = lllllllllllllllIlIIllIlllIIlIIlI.getStackInSlot(lllllllllllllllIlIIllIlllIIIllll);
            if (lllllllllllllllIlIIllIlllIIIlllI.getItem() == Items.FILLED_MAP) {
                lllllllllllllllIlIIllIlllIIlIIII = lllllllllllllllIlIIllIlllIIIlllI;
            }
        }
        if (lllllllllllllllIlIIllIlllIIlIIII.func_190926_b()) {
            return false;
        }
        final MapData lllllllllllllllIlIIllIlllIIIllIl = Items.FILLED_MAP.getMapData(lllllllllllllllIlIIllIlllIIlIIII, lllllllllllllllIlIIllIlllIIlIIIl);
        return lllllllllllllllIlIIllIlllIIIllIl != null && !this.func_190934_a(lllllllllllllllIlIIllIlllIIIllIl) && lllllllllllllllIlIIllIlllIIIllIl.scale < 4;
    }
    
    private boolean func_190934_a(final MapData lllllllllllllllIlIIllIlllIIIIIlI) {
        if (lllllllllllllllIlIIllIlllIIIIIlI.mapDecorations != null) {
            for (final MapDecoration lllllllllllllllIlIIllIlllIIIIIIl : lllllllllllllllIlIIllIlllIIIIIlI.mapDecorations.values()) {
                if (lllllllllllllllIlIIllIlllIIIIIIl.func_191179_b() == MapDecoration.Type.MANSION || lllllllllllllllIlIIllIlllIIIIIIl.func_191179_b() == MapDecoration.Type.MONUMENT) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public RecipesMapExtending() {
        super("", 3, 3, NonNullList.func_193580_a(Ingredient.field_193370_a, Ingredient.func_193368_a(Items.PAPER), Ingredient.func_193368_a(Items.PAPER), Ingredient.func_193368_a(Items.PAPER), Ingredient.func_193368_a(Items.PAPER), Ingredient.func_193367_a(Items.FILLED_MAP), Ingredient.func_193368_a(Items.PAPER), Ingredient.func_193368_a(Items.PAPER), Ingredient.func_193368_a(Items.PAPER), Ingredient.func_193368_a(Items.PAPER)), new ItemStack(Items.MAP));
    }
}
