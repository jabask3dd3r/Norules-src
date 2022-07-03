package net.minecraft.client.util;

import net.minecraft.stats.*;
import net.minecraft.creativetab.*;
import net.minecraft.client.gui.recipebook.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.item.crafting.*;
import com.google.common.collect.*;

public class RecipeBookClient extends RecipeBook
{
    public static final /* synthetic */ Map<CreativeTabs, List<RecipeList>> field_194086_e;
    public static final /* synthetic */ List<RecipeList> field_194087_f;
    
    private static CreativeTabs func_194084_a(final ItemStack lllllllllllllIIIllIlllllllIllIIl) {
        final CreativeTabs lllllllllllllIIIllIlllllllIllIII = lllllllllllllIIIllIlllllllIllIIl.getItem().getCreativeTab();
        if (lllllllllllllIIIllIlllllllIllIII != CreativeTabs.BUILDING_BLOCKS && lllllllllllllIIIllIlllllllIllIII != CreativeTabs.TOOLS && lllllllllllllIIIllIlllllllIllIII != CreativeTabs.REDSTONE) {
            return (lllllllllllllIIIllIlllllllIllIII == CreativeTabs.COMBAT) ? CreativeTabs.TOOLS : CreativeTabs.MISC;
        }
        return lllllllllllllIIIllIlllllllIllIII;
    }
    
    private static RecipeList func_194082_a(final CreativeTabs lllllllllllllIIIllIlllllllIlllll) {
        final RecipeList lllllllllllllIIIllIlllllllIllllI = new RecipeList();
        RecipeBookClient.field_194087_f.add(lllllllllllllIIIllIlllllllIllllI);
        RecipeBookClient.field_194086_e.computeIfAbsent(lllllllllllllIIIllIlllllllIlllll, lllllllllllllIIIllIlllllllIlIlIl -> new ArrayList()).add(lllllllllllllIIIllIlllllllIllllI);
        RecipeBookClient.field_194086_e.computeIfAbsent(CreativeTabs.SEARCH, lllllllllllllIIIllIlllllllIlIlII -> new ArrayList()).add(lllllllllllllIIIllIlllllllIllllI);
        return lllllllllllllIIIllIlllllllIllllI;
    }
    
    static {
        field_194086_e = Maps.newHashMap();
        field_194087_f = Lists.newArrayList();
        final Table<CreativeTabs, String, RecipeList> lllllllllllllIIIllIlllllllllIIII = (Table<CreativeTabs, String, RecipeList>)HashBasedTable.create();
        for (final IRecipe lllllllllllllIIIllIllllllllIllll : CraftingManager.field_193380_a) {
            if (!lllllllllllllIIIllIllllllllIllll.func_192399_d()) {
                final CreativeTabs lllllllllllllIIIllIllllllllIlllI = func_194084_a(lllllllllllllIIIllIllllllllIllll.getRecipeOutput());
                final String lllllllllllllIIIllIllllllllIllIl = lllllllllllllIIIllIllllllllIllll.func_193358_e();
                RecipeList lllllllllllllIIIllIllllllllIlIll = null;
                if (lllllllllllllIIIllIllllllllIllIl.isEmpty()) {
                    final RecipeList lllllllllllllIIIllIllllllllIllII = func_194082_a(lllllllllllllIIIllIllllllllIlllI);
                }
                else {
                    lllllllllllllIIIllIllllllllIlIll = (RecipeList)lllllllllllllIIIllIlllllllllIIII.get((Object)lllllllllllllIIIllIllllllllIlllI, (Object)lllllllllllllIIIllIllllllllIllIl);
                    if (lllllllllllllIIIllIllllllllIlIll == null) {
                        lllllllllllllIIIllIllllllllIlIll = func_194082_a(lllllllllllllIIIllIllllllllIlllI);
                        lllllllllllllIIIllIlllllllllIIII.put((Object)lllllllllllllIIIllIllllllllIlllI, (Object)lllllllllllllIIIllIllllllllIllIl, (Object)lllllllllllllIIIllIllllllllIlIll);
                    }
                }
                lllllllllllllIIIllIllllllllIlIll.func_192709_a(lllllllllllllIIIllIllllllllIllll);
            }
        }
    }
}
