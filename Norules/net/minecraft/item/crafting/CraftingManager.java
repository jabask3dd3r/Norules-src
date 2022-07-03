package net.minecraft.item.crafting;

import net.minecraft.util.registry.*;
import org.apache.commons.io.*;
import java.nio.file.*;
import java.net.*;
import java.util.*;
import java.io.*;
import javax.annotation.*;
import com.google.gson.*;
import net.minecraft.inventory.*;
import net.minecraft.world.*;
import org.apache.logging.log4j.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class CraftingManager
{
    private static /* synthetic */ int field_193381_c;
    private static final /* synthetic */ Logger field_192422_a;
    public static final /* synthetic */ RegistryNamespaced<ResourceLocation, IRecipe> field_193380_a;
    
    public static int func_193375_a(final IRecipe lllllllllllllIIllllIlllIIllIlIll) {
        return CraftingManager.field_193380_a.getIDForObject(lllllllllllllIIllllIlllIIllIlIll);
    }
    
    private static boolean func_192420_c() {
        FileSystem lllllllllllllIIllllIlllIllIIllII = null;
        final Gson lllllllllllllIIllllIlllIllIIlIll = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        try {
            final URL lllllllllllllIIllllIlllIllIIIlll = CraftingManager.class.getResource("/assets/.mcassetsroot");
            if (lllllllllllllIIllllIlllIllIIIlll != null) {
                final URI lllllllllllllIIllllIlllIllIIIllI = lllllllllllllIIllllIlllIllIIIlll.toURI();
                Path lllllllllllllIIllllIlllIllIIIlII = null;
                if ("file".equals(lllllllllllllIIllllIlllIllIIIllI.getScheme())) {
                    final Path lllllllllllllIIllllIlllIllIIIlIl = Paths.get(CraftingManager.class.getResource("/assets/minecraft/recipes").toURI());
                }
                else {
                    if (!"jar".equals(lllllllllllllIIllllIlllIllIIIllI.getScheme())) {
                        CraftingManager.field_192422_a.error(String.valueOf(new StringBuilder("Unsupported scheme ").append(lllllllllllllIIllllIlllIllIIIllI).append(" trying to list all recipes")));
                        final boolean lllllllllllllIIllllIlllIlIlIIllI;
                        final boolean lllllllllllllIIllllIlllIllIIIIll = lllllllllllllIIllllIlllIlIlIIllI = false;
                        return lllllllllllllIIllllIlllIlIlIIllI;
                    }
                    lllllllllllllIIllllIlllIllIIllII = FileSystems.newFileSystem(lllllllllllllIIllllIlllIllIIIllI, Collections.emptyMap());
                    lllllllllllllIIllllIlllIllIIIlII = lllllllllllllIIllllIlllIllIIllII.getPath("/assets/minecraft/recipes", new String[0]);
                }
                for (final Path lllllllllllllIIllllIlllIllIIIIIl : Files.walk(lllllllllllllIIllllIlllIllIIIlII, new FileVisitOption[0])) {
                    if ("json".equals(FilenameUtils.getExtension(lllllllllllllIIllllIlllIllIIIIIl.toString()))) {
                        final Path lllllllllllllIIllllIlllIllIIIIII = lllllllllllllIIllllIlllIllIIIlII.relativize(lllllllllllllIIllllIlllIllIIIIIl);
                        final String lllllllllllllIIllllIlllIlIllllll = FilenameUtils.removeExtension(lllllllllllllIIllllIlllIllIIIIII.toString()).replaceAll("\\\\", "/");
                        final ResourceLocation lllllllllllllIIllllIlllIlIlllllI = new ResourceLocation(lllllllllllllIIllllIlllIlIllllll);
                        BufferedReader lllllllllllllIIllllIlllIlIllllIl = null;
                        try {
                            lllllllllllllIIllllIlllIlIllllIl = Files.newBufferedReader(lllllllllllllIIllllIlllIllIIIIIl);
                            func_193379_a(lllllllllllllIIllllIlllIlIllllll, func_193376_a(JsonUtils.func_193839_a(lllllllllllllIIllllIlllIllIIlIll, lllllllllllllIIllllIlllIlIllllIl, JsonObject.class)));
                        }
                        catch (JsonParseException lllllllllllllIIllllIlllIlIlllIlI) {
                            CraftingManager.field_192422_a.error(String.valueOf(new StringBuilder("Parsing error loading recipe ").append(lllllllllllllIIllllIlllIlIlllllI)), (Throwable)lllllllllllllIIllllIlllIlIlllIlI);
                            final Exception lllllllllllllIIllllIlllIlIlIlIII;
                            final boolean lllllllllllllIIllllIlllIlIllllII = (boolean)(lllllllllllllIIllllIlllIlIlIlIII = (Exception)0);
                            return (boolean)lllllllllllllIIllllIlllIlIlIlIII;
                        }
                        catch (IOException lllllllllllllIIllllIlllIlIlllIIl) {
                            CraftingManager.field_192422_a.error(String.valueOf(new StringBuilder("Couldn't read recipe ").append(lllllllllllllIIllllIlllIlIlllllI).append(" from ").append(lllllllllllllIIllllIlllIllIIIIIl)), (Throwable)lllllllllllllIIllllIlllIlIlllIIl);
                            final Exception lllllllllllllIIllllIlllIlIlIlIII;
                            final boolean lllllllllllllIIllllIlllIlIlllIll = (boolean)(lllllllllllllIIllllIlllIlIlIlIII = (Exception)0);
                            return (boolean)lllllllllllllIIllllIlllIlIlIlIII;
                        }
                        finally {
                            IOUtils.closeQuietly((Reader)lllllllllllllIIllllIlllIlIllllIl);
                        }
                        IOUtils.closeQuietly((Reader)lllllllllllllIIllllIlllIlIllllIl);
                    }
                }
                return true;
            }
            CraftingManager.field_192422_a.error("Couldn't find .mcassetsroot");
            final boolean lllllllllllllIIllllIlllIllIIlIlI = false;
        }
        catch (IOException ex) {}
        catch (URISyntaxException lllllllllllllIIllllIlllIlIlllIII) {
            CraftingManager.field_192422_a.error("Couldn't get a list of all recipe files", (Throwable)lllllllllllllIIllllIlllIlIlllIII);
            final boolean lllllllllllllIIllllIlllIlIlIIllI;
            final boolean lllllllllllllIIllllIlllIllIIlIIl = lllllllllllllIIllllIlllIlIlIIllI = false;
            return lllllllllllllIIllllIlllIlIlIIllI;
        }
        finally {
            IOUtils.closeQuietly((Closeable)lllllllllllllIIllllIlllIllIIllII);
        }
        IOUtils.closeQuietly((Closeable)lllllllllllllIIllllIlllIllIIllII);
        final boolean lllllllllllllIIllllIlllIllIIlIII;
        return lllllllllllllIIllllIlllIllIIlIII;
    }
    
    public static void func_193379_a(final String lllllllllllllIIllllIlllIlIIllIll, final IRecipe lllllllllllllIIllllIlllIlIIlllII) {
        func_193372_a(new ResourceLocation(lllllllllllllIIllllIlllIlIIllIll), lllllllllllllIIllllIlllIlIIlllII);
    }
    
    @Nullable
    public static IRecipe func_193374_a(final int lllllllllllllIIllllIlllIIllIlIII) {
        return CraftingManager.field_193380_a.getObjectById(lllllllllllllIIllllIlllIIllIlIII);
    }
    
    private static IRecipe func_193376_a(final JsonObject lllllllllllllIIllllIlllIlIlIIIll) {
        final String lllllllllllllIIllllIlllIlIlIIIlI = JsonUtils.getString(lllllllllllllIIllllIlllIlIlIIIll, "type");
        if ("crafting_shaped".equals(lllllllllllllIIllllIlllIlIlIIIlI)) {
            return ShapedRecipes.func_193362_a(lllllllllllllIIllllIlllIlIlIIIll);
        }
        if ("crafting_shapeless".equals(lllllllllllllIIllllIlllIlIlIIIlI)) {
            return ShapelessRecipes.func_193363_a(lllllllllllllIIllllIlllIlIlIIIll);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Invalid or unsupported recipe type '").append(lllllllllllllIIllllIlllIlIlIIIlI).append("'")));
    }
    
    public static void func_193372_a(final ResourceLocation lllllllllllllIIllllIlllIlIIlIlIl, final IRecipe lllllllllllllIIllllIlllIlIIlIllI) {
        if (CraftingManager.field_193380_a.containsKey(lllllllllllllIIllllIlllIlIIlIlIl)) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Duplicate recipe ignored with ID ").append(lllllllllllllIIllllIlllIlIIlIlIl)));
        }
        CraftingManager.field_193380_a.register(CraftingManager.field_193381_c++, lllllllllllllIIllllIlllIlIIlIlIl, lllllllllllllIIllllIlllIlIIlIllI);
    }
    
    @Nullable
    public static IRecipe func_192413_b(final InventoryCrafting lllllllllllllIIllllIlllIlIIIIlII, final World lllllllllllllIIllllIlllIlIIIIIll) {
        for (final IRecipe lllllllllllllIIllllIlllIlIIIIIlI : CraftingManager.field_193380_a) {
            if (lllllllllllllIIllllIlllIlIIIIIlI.matches(lllllllllllllIIllllIlllIlIIIIlII, lllllllllllllIIllllIlllIlIIIIIll)) {
                return lllllllllllllIIllllIlllIlIIIIIlI;
            }
        }
        return null;
    }
    
    static {
        field_192422_a = LogManager.getLogger();
        field_193380_a = new RegistryNamespaced<ResourceLocation, IRecipe>();
    }
    
    public static ItemStack findMatchingRecipe(final InventoryCrafting lllllllllllllIIllllIlllIlIIIllII, final World lllllllllllllIIllllIlllIlIIIlllI) {
        for (final IRecipe lllllllllllllIIllllIlllIlIIIllIl : CraftingManager.field_193380_a) {
            if (lllllllllllllIIllllIlllIlIIIllIl.matches(lllllllllllllIIllllIlllIlIIIllII, lllllllllllllIIllllIlllIlIIIlllI)) {
                return lllllllllllllIIllllIlllIlIIIllIl.getCraftingResult(lllllllllllllIIllllIlllIlIIIllII);
            }
        }
        return ItemStack.field_190927_a;
    }
    
    @Nullable
    public static IRecipe func_193373_a(final ResourceLocation lllllllllllllIIllllIlllIIllIlllI) {
        return CraftingManager.field_193380_a.getObject(lllllllllllllIIllllIlllIIllIlllI);
    }
    
    public static NonNullList<ItemStack> getRemainingItems(final InventoryCrafting lllllllllllllIIllllIlllIIlllIlII, final World lllllllllllllIIllllIlllIIllllIII) {
        for (final IRecipe lllllllllllllIIllllIlllIIlllIlll : CraftingManager.field_193380_a) {
            if (lllllllllllllIIllllIlllIIlllIlll.matches(lllllllllllllIIllllIlllIIlllIlII, lllllllllllllIIllllIlllIIllllIII)) {
                return lllllllllllllIIllllIlllIIlllIlll.getRemainingItems(lllllllllllllIIllllIlllIIlllIlII);
            }
        }
        final NonNullList<ItemStack> lllllllllllllIIllllIlllIIlllIllI = NonNullList.func_191197_a(lllllllllllllIIllllIlllIIlllIlII.getSizeInventory(), ItemStack.field_190927_a);
        for (int lllllllllllllIIllllIlllIIlllIlIl = 0; lllllllllllllIIllllIlllIIlllIlIl < lllllllllllllIIllllIlllIIlllIllI.size(); ++lllllllllllllIIllllIlllIIlllIlIl) {
            lllllllllllllIIllllIlllIIlllIllI.set(lllllllllllllIIllllIlllIIlllIlIl, lllllllllllllIIllllIlllIIlllIlII.getStackInSlot(lllllllllllllIIllllIlllIIlllIlIl));
        }
        return lllllllllllllIIllllIlllIIlllIllI;
    }
    
    public static boolean func_193377_a() {
        try {
            func_193379_a("armordye", new RecipesArmorDyes());
            func_193379_a("bookcloning", new RecipeBookCloning());
            func_193379_a("mapcloning", new RecipesMapCloning());
            func_193379_a("mapextending", new RecipesMapExtending());
            func_193379_a("fireworks", new RecipeFireworks());
            func_193379_a("repairitem", new RecipeRepairItem());
            func_193379_a("tippedarrow", new RecipeTippedArrow());
            func_193379_a("bannerduplicate", new RecipesBanners.RecipeDuplicatePattern());
            func_193379_a("banneraddpattern", new RecipesBanners.RecipeAddPattern());
            func_193379_a("shielddecoration", new ShieldRecipes.Decoration());
            func_193379_a("shulkerboxcoloring", new ShulkerBoxRecipes.ShulkerBoxColoring());
            return func_192420_c();
        }
        catch (Throwable lllllllllllllIIllllIlllIlllIIIII) {
            return false;
        }
    }
}
