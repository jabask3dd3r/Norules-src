package net.minecraft.item.crafting;

import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class ShapelessRecipes implements IRecipe
{
    private final /* synthetic */ NonNullList<Ingredient> recipeItems;
    private final /* synthetic */ ItemStack recipeOutput;
    private final /* synthetic */ String field_194138_c;
    
    public ShapelessRecipes(final String llllllllllllllIlllIIIIllIllIIlIl, final ItemStack llllllllllllllIlllIIIIllIllIIIll, final NonNullList<Ingredient> llllllllllllllIlllIIIIllIllIIIIl) {
        this.field_194138_c = llllllllllllllIlllIIIIllIllIIlIl;
        this.recipeOutput = llllllllllllllIlllIIIIllIllIIIll;
        this.recipeItems = llllllllllllllIlllIIIIllIllIIIIl;
    }
    
    @Override
    public String func_193358_e() {
        return this.field_194138_c;
    }
    
    @Override
    public boolean matches(final InventoryCrafting llllllllllllllIlllIIIIllIIlllIII, final World llllllllllllllIlllIIIIllIIllIlll) {
        final List<Ingredient> llllllllllllllIlllIIIIllIIllIllI = (List<Ingredient>)Lists.newArrayList((Iterable)this.recipeItems);
        for (int llllllllllllllIlllIIIIllIIllIlIl = 0; llllllllllllllIlllIIIIllIIllIlIl < llllllllllllllIlllIIIIllIIlllIII.getHeight(); ++llllllllllllllIlllIIIIllIIllIlIl) {
            for (int llllllllllllllIlllIIIIllIIllIlII = 0; llllllllllllllIlllIIIIllIIllIlII < llllllllllllllIlllIIIIllIIlllIII.getWidth(); ++llllllllllllllIlllIIIIllIIllIlII) {
                final ItemStack llllllllllllllIlllIIIIllIIllIIll = llllllllllllllIlllIIIIllIIlllIII.getStackInRowAndColumn(llllllllllllllIlllIIIIllIIllIlII, llllllllllllllIlllIIIIllIIllIlIl);
                if (!llllllllllllllIlllIIIIllIIllIIll.func_190926_b()) {
                    boolean llllllllllllllIlllIIIIllIIllIIlI = false;
                    for (final Ingredient llllllllllllllIlllIIIIllIIllIIIl : llllllllllllllIlllIIIIllIIllIllI) {
                        if (llllllllllllllIlllIIIIllIIllIIIl.apply(llllllllllllllIlllIIIIllIIllIIll)) {
                            llllllllllllllIlllIIIIllIIllIIlI = true;
                            llllllllllllllIlllIIIIllIIllIllI.remove(llllllllllllllIlllIIIIllIIllIIIl);
                            break;
                        }
                    }
                    if (!llllllllllllllIlllIIIIllIIllIIlI) {
                        return false;
                    }
                }
            }
        }
        return llllllllllllllIlllIIIIllIIllIllI.isEmpty();
    }
    
    private static NonNullList<Ingredient> func_193364_a(final JsonArray llllllllllllllIlllIIIIllIIIIllll) {
        final NonNullList<Ingredient> llllllllllllllIlllIIIIllIIIlIIlI = NonNullList.func_191196_a();
        for (int llllllllllllllIlllIIIIllIIIlIIIl = 0; llllllllllllllIlllIIIIllIIIlIIIl < llllllllllllllIlllIIIIllIIIIllll.size(); ++llllllllllllllIlllIIIIllIIIlIIIl) {
            final Ingredient llllllllllllllIlllIIIIllIIIlIIII = ShapedRecipes.func_193361_a(llllllllllllllIlllIIIIllIIIIllll.get(llllllllllllllIlllIIIIllIIIlIIIl));
            if (llllllllllllllIlllIIIIllIIIlIIII != Ingredient.field_193370_a) {
                llllllllllllllIlllIIIIllIIIlIIlI.add(llllllllllllllIlllIIIIllIIIlIIII);
            }
        }
        return llllllllllllllIlllIIIIllIIIlIIlI;
    }
    
    @Override
    public boolean func_194133_a(final int llllllllllllllIlllIIIIllIIIIIlII, final int llllllllllllllIlllIIIIllIIIIIIll) {
        return llllllllllllllIlllIIIIllIIIIIlII * llllllllllllllIlllIIIIllIIIIIIll >= this.recipeItems.size();
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting llllllllllllllIlllIIIIllIIlIIlIl) {
        return this.recipeOutput.copy();
    }
    
    @Override
    public NonNullList<Ingredient> func_192400_c() {
        return this.recipeItems;
    }
    
    @Override
    public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting llllllllllllllIlllIIIIllIlIIlIlI) {
        final NonNullList<ItemStack> llllllllllllllIlllIIIIllIlIIlIIl = NonNullList.func_191197_a(llllllllllllllIlllIIIIllIlIIlIlI.getSizeInventory(), ItemStack.field_190927_a);
        for (int llllllllllllllIlllIIIIllIlIIlIII = 0; llllllllllllllIlllIIIIllIlIIlIII < llllllllllllllIlllIIIIllIlIIlIIl.size(); ++llllllllllllllIlllIIIIllIlIIlIII) {
            final ItemStack llllllllllllllIlllIIIIllIlIIIlll = llllllllllllllIlllIIIIllIlIIlIlI.getStackInSlot(llllllllllllllIlllIIIIllIlIIlIII);
            if (llllllllllllllIlllIIIIllIlIIIlll.getItem().hasContainerItem()) {
                llllllllllllllIlllIIIIllIlIIlIIl.set(llllllllllllllIlllIIIIllIlIIlIII, new ItemStack(llllllllllllllIlllIIIIllIlIIIlll.getItem().getContainerItem()));
            }
        }
        return llllllllllllllIlllIIIIllIlIIlIIl;
    }
    
    public static ShapelessRecipes func_193363_a(final JsonObject llllllllllllllIlllIIIIllIIIllIll) {
        final String llllllllllllllIlllIIIIllIIIllllI = JsonUtils.getString(llllllllllllllIlllIIIIllIIIllIll, "group", "");
        final NonNullList<Ingredient> llllllllllllllIlllIIIIllIIIlllIl = func_193364_a(JsonUtils.getJsonArray(llllllllllllllIlllIIIIllIIIllIll, "ingredients"));
        if (llllllllllllllIlllIIIIllIIIlllIl.isEmpty()) {
            throw new JsonParseException("No ingredients for shapeless recipe");
        }
        if (llllllllllllllIlllIIIIllIIIlllIl.size() > 9) {
            throw new JsonParseException("Too many ingredients for shapeless recipe");
        }
        final ItemStack llllllllllllllIlllIIIIllIIIlllII = ShapedRecipes.func_192405_a(JsonUtils.getJsonObject(llllllllllllllIlllIIIIllIIIllIll, "result"), true);
        return new ShapelessRecipes(llllllllllllllIlllIIIIllIIIllllI, llllllllllllllIlllIIIIllIIIlllII, llllllllllllllIlllIIIIllIIIlllIl);
    }
}
