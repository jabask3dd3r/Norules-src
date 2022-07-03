package net.minecraft.stats;

import com.google.common.collect.*;
import net.minecraft.item.crafting.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import net.minecraft.advancements.*;
import net.minecraft.nbt.*;
import java.util.*;

public class RecipeBookServer extends RecipeBook
{
    private static final /* synthetic */ Logger field_192828_d;
    
    private List<IRecipe> func_194079_d() {
        final List<IRecipe> lIIlIIIlIllIlI = (List<IRecipe>)Lists.newArrayList();
        for (int lIIlIIIlIllIIl = this.field_194077_a.nextSetBit(0); lIIlIIIlIllIIl >= 0; lIIlIIIlIllIIl = this.field_194077_a.nextSetBit(lIIlIIIlIllIIl + 1)) {
            lIIlIIIlIllIlI.add(CraftingManager.field_193380_a.getObjectById(lIIlIIIlIllIIl));
        }
        return lIIlIIIlIllIlI;
    }
    
    public void func_193834_b(final List<IRecipe> lIIlIIlIIllIIl, final EntityPlayerMP lIIlIIlIIlllIl) {
        final List<IRecipe> lIIlIIlIIlllII = (List<IRecipe>)Lists.newArrayList();
        for (final IRecipe lIIlIIlIIllIll : lIIlIIlIIllIIl) {
            if (this.field_194077_a.get(RecipeBook.func_194075_d(lIIlIIlIIllIll))) {
                this.func_193831_b(lIIlIIlIIllIll);
                lIIlIIlIIlllII.add(lIIlIIlIIllIll);
            }
        }
        this.func_194081_a(SPacketRecipeBook.State.REMOVE, lIIlIIlIIlllIl, lIIlIIlIIlllII);
    }
    
    static {
        field_192828_d = LogManager.getLogger();
    }
    
    public void func_192825_a(final NBTTagCompound lIIlIIIllIIlII) {
        this.field_192818_b = lIIlIIIllIIlII.getBoolean("isGuiOpen");
        this.field_192819_c = lIIlIIIllIIlII.getBoolean("isFilteringCraftable");
        final NBTTagList lIIlIIIllIllIl = lIIlIIIllIIlII.getTagList("recipes", 8);
        for (int lIIlIIIllIllII = 0; lIIlIIIllIllII < lIIlIIIllIllIl.tagCount(); ++lIIlIIIllIllII) {
            final ResourceLocation lIIlIIIllIlIll = new ResourceLocation(lIIlIIIllIllIl.getStringTagAt(lIIlIIIllIllII));
            final IRecipe lIIlIIIllIlIlI = CraftingManager.func_193373_a(lIIlIIIllIlIll);
            if (lIIlIIIllIlIlI == null) {
                RecipeBookServer.field_192828_d.info("Tried to load unrecognized recipe: {} removed now.", (Object)lIIlIIIllIlIll);
            }
            else {
                this.func_194073_a(lIIlIIIllIlIlI);
            }
        }
        final NBTTagList lIIlIIIllIlIIl = lIIlIIIllIIlII.getTagList("toBeDisplayed", 8);
        for (int lIIlIIIllIlIII = 0; lIIlIIIllIlIII < lIIlIIIllIlIIl.tagCount(); ++lIIlIIIllIlIII) {
            final ResourceLocation lIIlIIIllIIlll = new ResourceLocation(lIIlIIIllIlIIl.getStringTagAt(lIIlIIIllIlIII));
            final IRecipe lIIlIIIllIIllI = CraftingManager.func_193373_a(lIIlIIIllIIlll);
            if (lIIlIIIllIIllI == null) {
                RecipeBookServer.field_192828_d.info("Tried to load unrecognized recipe: {} removed now.", (Object)lIIlIIIllIIlll);
            }
            else {
                this.func_193825_e(lIIlIIIllIIllI);
            }
        }
    }
    
    public void func_192826_c(final EntityPlayerMP lIIlIIIlIIIlll) {
        lIIlIIIlIIIlll.connection.sendPacket(new SPacketRecipeBook(SPacketRecipeBook.State.INIT, this.func_194079_d(), this.func_194080_e(), this.field_192818_b, this.field_192819_c));
    }
    
    public void func_193835_a(final List<IRecipe> lIIlIIlIlIlIlI, final EntityPlayerMP lIIlIIlIlIlIIl) {
        final List<IRecipe> lIIlIIlIlIllIl = (List<IRecipe>)Lists.newArrayList();
        for (final IRecipe lIIlIIlIlIllII : lIIlIIlIlIlIlI) {
            if (!this.field_194077_a.get(RecipeBook.func_194075_d(lIIlIIlIlIllII)) && !lIIlIIlIlIllII.func_192399_d()) {
                this.func_194073_a(lIIlIIlIlIllII);
                this.func_193825_e(lIIlIIlIlIllII);
                lIIlIIlIlIllIl.add(lIIlIIlIlIllII);
                CriteriaTriggers.field_192126_f.func_192225_a(lIIlIIlIlIlIIl, lIIlIIlIlIllII);
            }
        }
        this.func_194081_a(SPacketRecipeBook.State.ADD, lIIlIIlIlIlIIl, lIIlIIlIlIllIl);
    }
    
    public NBTTagCompound func_192824_e() {
        final NBTTagCompound lIIlIIlIIIIIIl = new NBTTagCompound();
        lIIlIIlIIIIIIl.setBoolean("isGuiOpen", this.field_192818_b);
        lIIlIIlIIIIIIl.setBoolean("isFilteringCraftable", this.field_192819_c);
        final NBTTagList lIIlIIlIIIIIII = new NBTTagList();
        for (final IRecipe lIIlIIIlllllll : this.func_194079_d()) {
            lIIlIIlIIIIIII.appendTag(new NBTTagString(CraftingManager.field_193380_a.getNameForObject(lIIlIIIlllllll).toString()));
        }
        lIIlIIlIIIIIIl.setTag("recipes", lIIlIIlIIIIIII);
        final NBTTagList lIIlIIIllllllI = new NBTTagList();
        for (final IRecipe lIIlIIIlllllIl : this.func_194080_e()) {
            lIIlIIIllllllI.appendTag(new NBTTagString(CraftingManager.field_193380_a.getNameForObject(lIIlIIIlllllIl).toString()));
        }
        lIIlIIlIIIIIIl.setTag("toBeDisplayed", lIIlIIIllllllI);
        return lIIlIIlIIIIIIl;
    }
    
    private List<IRecipe> func_194080_e() {
        final List<IRecipe> lIIlIIIlIlIIIl = (List<IRecipe>)Lists.newArrayList();
        for (int lIIlIIIlIlIIII = this.field_194078_b.nextSetBit(0); lIIlIIIlIlIIII >= 0; lIIlIIIlIlIIII = this.field_194078_b.nextSetBit(lIIlIIIlIlIIII + 1)) {
            lIIlIIIlIlIIIl.add(CraftingManager.field_193380_a.getObjectById(lIIlIIIlIlIIII));
        }
        return lIIlIIIlIlIIIl;
    }
    
    private void func_194081_a(final SPacketRecipeBook.State lIIlIIlIIIlIll, final EntityPlayerMP lIIlIIlIIIlllI, final List<IRecipe> lIIlIIlIIIlIIl) {
        lIIlIIlIIIlllI.connection.sendPacket(new SPacketRecipeBook(lIIlIIlIIIlIll, lIIlIIlIIIlIIl, Collections.emptyList(), this.field_192818_b, this.field_192819_c));
    }
}
