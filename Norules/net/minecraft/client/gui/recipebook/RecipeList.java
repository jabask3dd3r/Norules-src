package net.minecraft.client.gui.recipebook;

import net.minecraft.item.crafting.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.client.util.*;
import net.minecraft.stats.*;
import it.unimi.dsi.fastutil.ints.*;
import net.minecraft.item.*;

public class RecipeList
{
    private /* synthetic */ boolean field_194218_e;
    private /* synthetic */ List<IRecipe> field_192713_b;
    private final /* synthetic */ BitSet field_194216_c;
    private final /* synthetic */ BitSet field_194215_b;
    private final /* synthetic */ BitSet field_194217_d;
    
    public List<IRecipe> func_194208_a(final boolean llllllllllllllIIIIIIIllIllIIllll) {
        final List<IRecipe> llllllllllllllIIIIIIIllIllIIlllI = (List<IRecipe>)Lists.newArrayList();
        for (int llllllllllllllIIIIIIIllIllIIllIl = this.field_194217_d.nextSetBit(0); llllllllllllllIIIIIIIllIllIIllIl >= 0; llllllllllllllIIIIIIIllIllIIllIl = this.field_194217_d.nextSetBit(llllllllllllllIIIIIIIllIllIIllIl + 1)) {
            if ((llllllllllllllIIIIIIIllIllIIllll ? this.field_194215_b : this.field_194216_c).get(llllllllllllllIIIIIIIllIllIIllIl)) {
                llllllllllllllIIIIIIIllIllIIlllI.add(this.field_192713_b.get(llllllllllllllIIIIIIIllIllIIllIl));
            }
        }
        return llllllllllllllIIIIIIIllIllIIlllI;
    }
    
    public boolean func_194209_a() {
        return !this.field_194217_d.isEmpty();
    }
    
    public List<IRecipe> func_192711_b() {
        return this.field_192713_b;
    }
    
    public void func_194210_a(final RecipeItemHelper llllllllllllllIIIIIIIllIllllIIll, final int llllllllllllllIIIIIIIllIllllIIlI, final int llllllllllllllIIIIIIIllIllllIIIl, final RecipeBook llllllllllllllIIIIIIIllIllllIIII) {
        for (int llllllllllllllIIIIIIIllIllllIlll = 0; llllllllllllllIIIIIIIllIllllIlll < this.field_192713_b.size(); ++llllllllllllllIIIIIIIllIllllIlll) {
            final IRecipe llllllllllllllIIIIIIIllIllllIllI = this.field_192713_b.get(llllllllllllllIIIIIIIllIllllIlll);
            final boolean llllllllllllllIIIIIIIllIllllIlIl = llllllllllllllIIIIIIIllIllllIllI.func_194133_a(llllllllllllllIIIIIIIllIllllIIlI, llllllllllllllIIIIIIIllIllllIIIl) && llllllllllllllIIIIIIIllIllllIIII.func_193830_f(llllllllllllllIIIIIIIllIllllIllI);
            this.field_194216_c.set(llllllllllllllIIIIIIIllIllllIlll, llllllllllllllIIIIIIIllIllllIlIl);
            this.field_194215_b.set(llllllllllllllIIIIIIIllIllllIlll, llllllllllllllIIIIIIIllIllllIlIl && llllllllllllllIIIIIIIllIllllIIll.func_194116_a(llllllllllllllIIIIIIIllIllllIllI, null));
        }
    }
    
    public void func_194214_a(final RecipeBook llllllllllllllIIIIIIIlllIIIIlIIl) {
        for (int llllllllllllllIIIIIIIlllIIIIlIII = 0; llllllllllllllIIIIIIIlllIIIIlIII < this.field_192713_b.size(); ++llllllllllllllIIIIIIIlllIIIIlIII) {
            this.field_194217_d.set(llllllllllllllIIIIIIIlllIIIIlIII, llllllllllllllIIIIIIIlllIIIIlIIl.func_193830_f(this.field_192713_b.get(llllllllllllllIIIIIIIlllIIIIlIII)));
        }
    }
    
    public void func_192709_a(final IRecipe llllllllllllllIIIIIIIllIlIllIlll) {
        this.field_192713_b.add(llllllllllllllIIIIIIIllIlIllIlll);
        if (this.field_194218_e) {
            final ItemStack llllllllllllllIIIIIIIllIlIllIllI = this.field_192713_b.get(0).getRecipeOutput();
            final ItemStack llllllllllllllIIIIIIIllIlIllIlIl = llllllllllllllIIIIIIIllIlIllIlll.getRecipeOutput();
            this.field_194218_e = (ItemStack.areItemsEqual(llllllllllllllIIIIIIIllIlIllIllI, llllllllllllllIIIIIIIllIlIllIlIl) && ItemStack.areItemStackTagsEqual(llllllllllllllIIIIIIIllIlIllIllI, llllllllllllllIIIIIIIllIlIllIlIl));
        }
    }
    
    public RecipeList() {
        this.field_192713_b = (List<IRecipe>)Lists.newArrayList();
        this.field_194215_b = new BitSet();
        this.field_194216_c = new BitSet();
        this.field_194217_d = new BitSet();
        this.field_194218_e = true;
    }
    
    public boolean func_194213_a(final IRecipe llllllllllllllIIIIIIIllIlllIIlll) {
        return this.field_194215_b.get(this.field_192713_b.indexOf(llllllllllllllIIIIIIIllIlllIIlll));
    }
    
    public List<IRecipe> func_194207_b(final boolean llllllllllllllIIIIIIIllIllIIIIll) {
        final List<IRecipe> llllllllllllllIIIIIIIllIllIIIIlI = (List<IRecipe>)Lists.newArrayList();
        for (int llllllllllllllIIIIIIIllIllIIIIIl = this.field_194217_d.nextSetBit(0); llllllllllllllIIIIIIIllIllIIIIIl >= 0; llllllllllllllIIIIIIIllIllIIIIIl = this.field_194217_d.nextSetBit(llllllllllllllIIIIIIIllIllIIIIIl + 1)) {
            if (this.field_194216_c.get(llllllllllllllIIIIIIIllIllIIIIIl) && this.field_194215_b.get(llllllllllllllIIIIIIIllIllIIIIIl) == llllllllllllllIIIIIIIllIllIIIIll) {
                llllllllllllllIIIIIIIllIllIIIIlI.add(this.field_192713_b.get(llllllllllllllIIIIIIIllIllIIIIIl));
            }
        }
        return llllllllllllllIIIIIIIllIllIIIIlI;
    }
    
    public boolean func_194211_e() {
        return this.field_194218_e;
    }
    
    public boolean func_194212_c() {
        return !this.field_194216_c.isEmpty();
    }
    
    public boolean func_192708_c() {
        return !this.field_194215_b.isEmpty();
    }
}
