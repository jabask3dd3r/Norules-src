package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import com.google.gson.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.world.*;
import com.google.common.annotations.*;

public class ShapedRecipes implements IRecipe
{
    private final /* synthetic */ int recipeHeight;
    private final /* synthetic */ ItemStack recipeOutput;
    private final /* synthetic */ int recipeWidth;
    private final /* synthetic */ String field_194137_e;
    private final /* synthetic */ NonNullList<Ingredient> recipeItems;
    
    public int func_192403_f() {
        return this.recipeWidth;
    }
    
    @Override
    public boolean func_194133_a(final int lllllllllllllIlllIlllIIIlIIIlllI, final int lllllllllllllIlllIlllIIIlIIIllIl) {
        return lllllllllllllIlllIlllIIIlIIIlllI >= this.recipeWidth && lllllllllllllIlllIlllIIIlIIIllIl >= this.recipeHeight;
    }
    
    private boolean checkMatch(final InventoryCrafting lllllllllllllIlllIlllIIIIllIIlll, final int lllllllllllllIlllIlllIIIIlllIIII, final int lllllllllllllIlllIlllIIIIllIllll, final boolean lllllllllllllIlllIlllIIIIllIIlII) {
        for (int lllllllllllllIlllIlllIIIIllIllIl = 0; lllllllllllllIlllIlllIIIIllIllIl < 3; ++lllllllllllllIlllIlllIIIIllIllIl) {
            for (int lllllllllllllIlllIlllIIIIllIllII = 0; lllllllllllllIlllIlllIIIIllIllII < 3; ++lllllllllllllIlllIlllIIIIllIllII) {
                final int lllllllllllllIlllIlllIIIIllIlIll = lllllllllllllIlllIlllIIIIllIllIl - lllllllllllllIlllIlllIIIIlllIIII;
                final int lllllllllllllIlllIlllIIIIllIlIlI = lllllllllllllIlllIlllIIIIllIllII - lllllllllllllIlllIlllIIIIllIllll;
                Ingredient lllllllllllllIlllIlllIIIIllIlIIl = Ingredient.field_193370_a;
                if (lllllllllllllIlllIlllIIIIllIlIll >= 0 && lllllllllllllIlllIlllIIIIllIlIlI >= 0 && lllllllllllllIlllIlllIIIIllIlIll < this.recipeWidth && lllllllllllllIlllIlllIIIIllIlIlI < this.recipeHeight) {
                    if (lllllllllllllIlllIlllIIIIllIIlII) {
                        lllllllllllllIlllIlllIIIIllIlIIl = this.recipeItems.get(this.recipeWidth - lllllllllllllIlllIlllIIIIllIlIll - 1 + lllllllllllllIlllIlllIIIIllIlIlI * this.recipeWidth);
                    }
                    else {
                        lllllllllllllIlllIlllIIIIllIlIIl = this.recipeItems.get(lllllllllllllIlllIlllIIIIllIlIll + lllllllllllllIlllIlllIIIIllIlIlI * this.recipeWidth);
                    }
                }
                if (!lllllllllllllIlllIlllIIIIllIlIIl.apply(lllllllllllllIlllIlllIIIIllIIlll.getStackInRowAndColumn(lllllllllllllIlllIlllIIIIllIllIl, lllllllllllllIlllIlllIIIIllIllII))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static Ingredient func_193361_a(@Nullable final JsonElement lllllllllllllIlllIllIlllllIlllIl) {
        if (lllllllllllllIlllIllIlllllIlllIl == null || lllllllllllllIlllIllIlllllIlllIl.isJsonNull()) {
            throw new JsonSyntaxException("Item cannot be null");
        }
        if (lllllllllllllIlllIllIlllllIlllIl.isJsonObject()) {
            return Ingredient.func_193369_a(func_192405_a(lllllllllllllIlllIllIlllllIlllIl.getAsJsonObject(), false));
        }
        if (!lllllllllllllIlllIllIlllllIlllIl.isJsonArray()) {
            throw new JsonSyntaxException("Expected item to be object or array of objects");
        }
        final JsonArray lllllllllllllIlllIllIlllllIlllII = lllllllllllllIlllIllIlllllIlllIl.getAsJsonArray();
        if (lllllllllllllIlllIllIlllllIlllII.size() == 0) {
            throw new JsonSyntaxException("Item array cannot be empty, at least one item must be defined");
        }
        final ItemStack[] lllllllllllllIlllIllIlllllIllIll = new ItemStack[lllllllllllllIlllIllIlllllIlllII.size()];
        for (int lllllllllllllIlllIllIlllllIllIlI = 0; lllllllllllllIlllIllIlllllIllIlI < lllllllllllllIlllIllIlllllIlllII.size(); ++lllllllllllllIlllIllIlllllIllIlI) {
            lllllllllllllIlllIllIlllllIllIll[lllllllllllllIlllIllIlllllIllIlI] = func_192405_a(JsonUtils.getJsonObject(lllllllllllllIlllIllIlllllIlllII.get(lllllllllllllIlllIllIlllllIllIlI), "item"), false);
        }
        return Ingredient.func_193369_a(lllllllllllllIlllIllIlllllIllIll);
    }
    
    private static String[] func_192407_a(final JsonArray lllllllllllllIlllIllIlllllllIIII) {
        final String[] lllllllllllllIlllIllIlllllllIIll = new String[lllllllllllllIlllIllIlllllllIIII.size()];
        if (lllllllllllllIlllIllIlllllllIIll.length > 3) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, 3 is maximum");
        }
        if (lllllllllllllIlllIllIlllllllIIll.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        }
        for (int lllllllllllllIlllIllIlllllllIIlI = 0; lllllllllllllIlllIllIlllllllIIlI < lllllllllllllIlllIllIlllllllIIll.length; ++lllllllllllllIlllIllIlllllllIIlI) {
            final String lllllllllllllIlllIllIlllllllIIIl = JsonUtils.getString(lllllllllllllIlllIllIlllllllIIII.get(lllllllllllllIlllIllIlllllllIIlI), String.valueOf(new StringBuilder("pattern[").append(lllllllllllllIlllIllIlllllllIIlI).append("]")));
            if (lllllllllllllIlllIllIlllllllIIIl.length() > 3) {
                throw new JsonSyntaxException("Invalid pattern: too many columns, 3 is maximum");
            }
            if (lllllllllllllIlllIllIlllllllIIlI > 0 && lllllllllllllIlllIllIlllllllIIll[0].length() != lllllllllllllIlllIllIlllllllIIIl.length()) {
                throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
            }
            lllllllllllllIlllIllIlllllllIIll[lllllllllllllIlllIllIlllllllIIlI] = lllllllllllllIlllIllIlllllllIIIl;
        }
        return lllllllllllllIlllIllIlllllllIIll;
    }
    
    @Override
    public String func_193358_e() {
        return this.field_194137_e;
    }
    
    private static Map<String, Ingredient> func_192408_a(final JsonObject lllllllllllllIlllIllIllllllIIlIl) {
        final Map<String, Ingredient> lllllllllllllIlllIllIllllllIIlll = (Map<String, Ingredient>)Maps.newHashMap();
        for (final Map.Entry<String, JsonElement> lllllllllllllIlllIllIllllllIIllI : lllllllllllllIlllIllIllllllIIlIl.entrySet()) {
            if (lllllllllllllIlllIllIllllllIIllI.getKey().length() != 1) {
                throw new JsonSyntaxException(String.valueOf(new StringBuilder("Invalid key entry: '").append(lllllllllllllIlllIllIllllllIIllI.getKey()).append("' is an invalid symbol (must be 1 character only).")));
            }
            if (" ".equals(lllllllllllllIlllIllIllllllIIllI.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }
            lllllllllllllIlllIllIllllllIIlll.put(lllllllllllllIlllIllIllllllIIllI.getKey(), func_193361_a(lllllllllllllIlllIllIllllllIIllI.getValue()));
        }
        lllllllllllllIlllIllIllllllIIlll.put(" ", Ingredient.field_193370_a);
        return lllllllllllllIlllIllIllllllIIlll;
    }
    
    public static ItemStack func_192405_a(final JsonObject lllllllllllllIlllIllIlllllIIlIIl, final boolean lllllllllllllIlllIllIlllllIIlllI) {
        final String lllllllllllllIlllIllIlllllIIllIl = JsonUtils.getString(lllllllllllllIlllIllIlllllIIlIIl, "item");
        final Item lllllllllllllIlllIllIlllllIIllII = Item.REGISTRY.getObject(new ResourceLocation(lllllllllllllIlllIllIlllllIIllIl));
        if (lllllllllllllIlllIllIlllllIIllII == null) {
            throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown item '").append(lllllllllllllIlllIllIlllllIIllIl).append("'")));
        }
        if (lllllllllllllIlllIllIlllllIIllII.getHasSubtypes() && !lllllllllllllIlllIllIlllllIIlIIl.has("data")) {
            throw new JsonParseException(String.valueOf(new StringBuilder("Missing data for item '").append(lllllllllllllIlllIllIlllllIIllIl).append("'")));
        }
        final int lllllllllllllIlllIllIlllllIIlIll = JsonUtils.getInt(lllllllllllllIlllIllIlllllIIlIIl, "data", 0);
        final int lllllllllllllIlllIllIlllllIIlIlI = lllllllllllllIlllIllIlllllIIlllI ? JsonUtils.getInt(lllllllllllllIlllIllIlllllIIlIIl, "count", 1) : 1;
        return new ItemStack(lllllllllllllIlllIllIlllllIIllII, lllllllllllllIlllIllIlllllIIlIlI, lllllllllllllIlllIllIlllllIIlIll);
    }
    
    public ShapedRecipes(final String lllllllllllllIlllIlllIIIlIlIllIl, final int lllllllllllllIlllIlllIIIlIlIllII, final int lllllllllllllIlllIlllIIIlIlIlIll, final NonNullList<Ingredient> lllllllllllllIlllIlllIIIlIlIlIlI, final ItemStack lllllllllllllIlllIlllIIIlIlIllll) {
        this.field_194137_e = lllllllllllllIlllIlllIIIlIlIllIl;
        this.recipeWidth = lllllllllllllIlllIlllIIIlIlIllII;
        this.recipeHeight = lllllllllllllIlllIlllIIIlIlIlIll;
        this.recipeItems = lllllllllllllIlllIlllIIIlIlIlIlI;
        this.recipeOutput = lllllllllllllIlllIlllIIIlIlIllll;
    }
    
    @Override
    public NonNullList<Ingredient> func_192400_c() {
        return this.recipeItems;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllIlllIlllIIIIlIlllII) {
        return this.getRecipeOutput().copy();
    }
    
    public static ShapedRecipes func_193362_a(final JsonObject lllllllllllllIlllIlllIIIIlIIllII) {
        final String lllllllllllllIlllIlllIIIIlIIlIll = JsonUtils.getString(lllllllllllllIlllIlllIIIIlIIllII, "group", "");
        final Map<String, Ingredient> lllllllllllllIlllIlllIIIIlIIlIlI = func_192408_a(JsonUtils.getJsonObject(lllllllllllllIlllIlllIIIIlIIllII, "key"));
        final String[] lllllllllllllIlllIlllIIIIlIIlIIl = func_194134_a(func_192407_a(JsonUtils.getJsonArray(lllllllllllllIlllIlllIIIIlIIllII, "pattern")));
        final int lllllllllllllIlllIlllIIIIlIIlIII = lllllllllllllIlllIlllIIIIlIIlIIl[0].length();
        final int lllllllllllllIlllIlllIIIIlIIIlll = lllllllllllllIlllIlllIIIIlIIlIIl.length;
        final NonNullList<Ingredient> lllllllllllllIlllIlllIIIIlIIIllI = func_192402_a(lllllllllllllIlllIlllIIIIlIIlIIl, lllllllllllllIlllIlllIIIIlIIlIlI, lllllllllllllIlllIlllIIIIlIIlIII, lllllllllllllIlllIlllIIIIlIIIlll);
        final ItemStack lllllllllllllIlllIlllIIIIlIIIlIl = func_192405_a(JsonUtils.getJsonObject(lllllllllllllIlllIlllIIIIlIIllII, "result"), true);
        return new ShapedRecipes(lllllllllllllIlllIlllIIIIlIIlIll, lllllllllllllIlllIlllIIIIlIIlIII, lllllllllllllIlllIlllIIIIlIIIlll, lllllllllllllIlllIlllIIIIlIIIllI, lllllllllllllIlllIlllIIIIlIIIlIl);
    }
    
    private static int func_194136_b(final String lllllllllllllIlllIllIlllllllllII) {
        int lllllllllllllIlllIllIllllllllIll;
        for (lllllllllllllIlllIllIllllllllIll = lllllllllllllIlllIllIlllllllllII.length() - 1; lllllllllllllIlllIllIllllllllIll >= 0 && lllllllllllllIlllIllIlllllllllII.charAt(lllllllllllllIlllIllIllllllllIll) == ' '; --lllllllllllllIlllIllIllllllllIll) {}
        return lllllllllllllIlllIllIllllllllIll;
    }
    
    public int func_192404_g() {
        return this.recipeHeight;
    }
    
    private static int func_194135_a(final String lllllllllllllIlllIlllIIIIIIIIIlI) {
        int lllllllllllllIlllIlllIIIIIIIIIIl;
        for (lllllllllllllIlllIlllIIIIIIIIIIl = 0; lllllllllllllIlllIlllIIIIIIIIIIl < lllllllllllllIlllIlllIIIIIIIIIlI.length() && lllllllllllllIlllIlllIIIIIIIIIlI.charAt(lllllllllllllIlllIlllIIIIIIIIIIl) == ' '; ++lllllllllllllIlllIlllIIIIIIIIIIl) {}
        return lllllllllllllIlllIlllIIIIIIIIIIl;
    }
    
    private static NonNullList<Ingredient> func_192402_a(final String[] lllllllllllllIlllIlllIIIIIlIlIII, final Map<String, Ingredient> lllllllllllllIlllIlllIIIIIllIIIl, final int lllllllllllllIlllIlllIIIIIlIIllI, final int lllllllllllllIlllIlllIIIIIlIIlIl) {
        final NonNullList<Ingredient> lllllllllllllIlllIlllIIIIIlIlllI = NonNullList.func_191197_a(lllllllllllllIlllIlllIIIIIlIIllI * lllllllllllllIlllIlllIIIIIlIIlIl, Ingredient.field_193370_a);
        final Set<String> lllllllllllllIlllIlllIIIIIlIllIl = (Set<String>)Sets.newHashSet((Iterable)lllllllllllllIlllIlllIIIIIllIIIl.keySet());
        lllllllllllllIlllIlllIIIIIlIllIl.remove(" ");
        for (int lllllllllllllIlllIlllIIIIIlIllII = 0; lllllllllllllIlllIlllIIIIIlIllII < lllllllllllllIlllIlllIIIIIlIlIII.length; ++lllllllllllllIlllIlllIIIIIlIllII) {
            for (int lllllllllllllIlllIlllIIIIIlIlIll = 0; lllllllllllllIlllIlllIIIIIlIlIll < lllllllllllllIlllIlllIIIIIlIlIII[lllllllllllllIlllIlllIIIIIlIllII].length(); ++lllllllllllllIlllIlllIIIIIlIlIll) {
                final String lllllllllllllIlllIlllIIIIIlIlIlI = lllllllllllllIlllIlllIIIIIlIlIII[lllllllllllllIlllIlllIIIIIlIllII].substring(lllllllllllllIlllIlllIIIIIlIlIll, lllllllllllllIlllIlllIIIIIlIlIll + 1);
                final Ingredient lllllllllllllIlllIlllIIIIIlIlIIl = lllllllllllllIlllIlllIIIIIllIIIl.get(lllllllllllllIlllIlllIIIIIlIlIlI);
                if (lllllllllllllIlllIlllIIIIIlIlIIl == null) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Pattern references symbol '").append(lllllllllllllIlllIlllIIIIIlIlIlI).append("' but it's not defined in the key")));
                }
                lllllllllllllIlllIlllIIIIIlIllIl.remove(lllllllllllllIlllIlllIIIIIlIlIlI);
                lllllllllllllIlllIlllIIIIIlIlllI.set(lllllllllllllIlllIlllIIIIIlIlIll + lllllllllllllIlllIlllIIIIIlIIllI * lllllllllllllIlllIlllIIIIIlIllII, lllllllllllllIlllIlllIIIIIlIlIIl);
            }
        }
        if (!lllllllllllllIlllIlllIIIIIlIllIl.isEmpty()) {
            throw new JsonSyntaxException(String.valueOf(new StringBuilder("Key defines symbols that aren't used in pattern: ").append(lllllllllllllIlllIlllIIIIIlIllIl)));
        }
        return lllllllllllllIlllIlllIIIIIlIlllI;
    }
    
    @Override
    public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting lllllllllllllIlllIlllIIIlIIllIIl) {
        final NonNullList<ItemStack> lllllllllllllIlllIlllIIIlIIlllII = NonNullList.func_191197_a(lllllllllllllIlllIlllIIIlIIllIIl.getSizeInventory(), ItemStack.field_190927_a);
        for (int lllllllllllllIlllIlllIIIlIIllIll = 0; lllllllllllllIlllIlllIIIlIIllIll < lllllllllllllIlllIlllIIIlIIlllII.size(); ++lllllllllllllIlllIlllIIIlIIllIll) {
            final ItemStack lllllllllllllIlllIlllIIIlIIllIlI = lllllllllllllIlllIlllIIIlIIllIIl.getStackInSlot(lllllllllllllIlllIlllIIIlIIllIll);
            if (lllllllllllllIlllIlllIIIlIIllIlI.getItem().hasContainerItem()) {
                lllllllllllllIlllIlllIIIlIIlllII.set(lllllllllllllIlllIlllIIIlIIllIll, new ItemStack(lllllllllllllIlllIlllIIIlIIllIlI.getItem().getContainerItem()));
            }
        }
        return lllllllllllllIlllIlllIIIlIIlllII;
    }
    
    @Override
    public boolean matches(final InventoryCrafting lllllllllllllIlllIlllIIIIlllllll, final World lllllllllllllIlllIlllIIIlIIIIIll) {
        for (int lllllllllllllIlllIlllIIIlIIIIIlI = 0; lllllllllllllIlllIlllIIIlIIIIIlI <= 3 - this.recipeWidth; ++lllllllllllllIlllIlllIIIlIIIIIlI) {
            for (int lllllllllllllIlllIlllIIIlIIIIIIl = 0; lllllllllllllIlllIlllIIIlIIIIIIl <= 3 - this.recipeHeight; ++lllllllllllllIlllIlllIIIlIIIIIIl) {
                if (this.checkMatch(lllllllllllllIlllIlllIIIIlllllll, lllllllllllllIlllIlllIIIlIIIIIlI, lllllllllllllIlllIlllIIIlIIIIIIl, true)) {
                    return true;
                }
                if (this.checkMatch(lllllllllllllIlllIlllIIIIlllllll, lllllllllllllIlllIlllIIIlIIIIIlI, lllllllllllllIlllIlllIIIlIIIIIIl, false)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @VisibleForTesting
    static String[] func_194134_a(final String... lllllllllllllIlllIlllIIIIIIIllII) {
        int lllllllllllllIlllIlllIIIIIIlIlIl = Integer.MAX_VALUE;
        int lllllllllllllIlllIlllIIIIIIlIlII = 0;
        int lllllllllllllIlllIlllIIIIIIlIIll = 0;
        int lllllllllllllIlllIlllIIIIIIlIIlI = 0;
        for (int lllllllllllllIlllIlllIIIIIIlIIIl = 0; lllllllllllllIlllIlllIIIIIIlIIIl < lllllllllllllIlllIlllIIIIIIIllII.length; ++lllllllllllllIlllIlllIIIIIIlIIIl) {
            final String lllllllllllllIlllIlllIIIIIIlIIII = lllllllllllllIlllIlllIIIIIIIllII[lllllllllllllIlllIlllIIIIIIlIIIl];
            lllllllllllllIlllIlllIIIIIIlIlIl = Math.min(lllllllllllllIlllIlllIIIIIIlIlIl, func_194135_a(lllllllllllllIlllIlllIIIIIIlIIII));
            final int lllllllllllllIlllIlllIIIIIIIllll = func_194136_b(lllllllllllllIlllIlllIIIIIIlIIII);
            lllllllllllllIlllIlllIIIIIIlIlII = Math.max(lllllllllllllIlllIlllIIIIIIlIlII, lllllllllllllIlllIlllIIIIIIIllll);
            if (lllllllllllllIlllIlllIIIIIIIllll < 0) {
                if (lllllllllllllIlllIlllIIIIIIlIIll == lllllllllllllIlllIlllIIIIIIlIIIl) {
                    ++lllllllllllllIlllIlllIIIIIIlIIll;
                }
                ++lllllllllllllIlllIlllIIIIIIlIIlI;
            }
            else {
                lllllllllllllIlllIlllIIIIIIlIIlI = 0;
            }
        }
        if (lllllllllllllIlllIlllIIIIIIIllII.length == lllllllllllllIlllIlllIIIIIIlIIlI) {
            return new String[0];
        }
        final String[] lllllllllllllIlllIlllIIIIIIIlllI = new String[lllllllllllllIlllIlllIIIIIIIllII.length - lllllllllllllIlllIlllIIIIIIlIIlI - lllllllllllllIlllIlllIIIIIIlIIll];
        for (int lllllllllllllIlllIlllIIIIIIIllIl = 0; lllllllllllllIlllIlllIIIIIIIllIl < lllllllllllllIlllIlllIIIIIIIlllI.length; ++lllllllllllllIlllIlllIIIIIIIllIl) {
            lllllllllllllIlllIlllIIIIIIIlllI[lllllllllllllIlllIlllIIIIIIIllIl] = lllllllllllllIlllIlllIIIIIIIllII[lllllllllllllIlllIlllIIIIIIIllIl + lllllllllllllIlllIlllIIIIIIlIIll].substring(lllllllllllllIlllIlllIIIIIIlIlIl, lllllllllllllIlllIlllIIIIIIlIlII + 1);
        }
        return lllllllllllllIlllIlllIIIIIIIlllI;
    }
}
