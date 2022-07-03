package net.minecraft.stats;

import java.util.*;
import javax.annotation.*;
import net.minecraft.item.crafting.*;

public class RecipeBook
{
    protected final /* synthetic */ BitSet field_194077_a;
    protected /* synthetic */ boolean field_192818_b;
    protected final /* synthetic */ BitSet field_194078_b;
    protected /* synthetic */ boolean field_192819_c;
    
    public void func_194074_f(final IRecipe lllllllllllllIllIllIlllIlIIllIlI) {
        this.field_194078_b.clear(func_194075_d(lllllllllllllIllIllIlllIlIIllIlI));
    }
    
    public boolean func_194076_e(final IRecipe lllllllllllllIllIllIlllIlIIllllI) {
        return this.field_194078_b.get(func_194075_d(lllllllllllllIllIllIlllIlIIllllI));
    }
    
    public void func_192813_a(final boolean lllllllllllllIllIllIlllIlIIIlIlI) {
        this.field_192818_b = lllllllllllllIllIllIlllIlIIIlIlI;
    }
    
    public void func_194073_a(final IRecipe lllllllllllllIllIllIlllIlIllIllI) {
        if (!lllllllllllllIllIllIlllIlIllIllI.func_192399_d()) {
            this.field_194077_a.set(func_194075_d(lllllllllllllIllIllIlllIlIllIllI));
        }
    }
    
    public void func_192810_b(final boolean lllllllllllllIllIllIlllIIlllllIl) {
        this.field_192819_c = lllllllllllllIllIllIlllIIlllllIl;
    }
    
    public void func_193831_b(final IRecipe lllllllllllllIllIllIlllIlIlIlIII) {
        final int lllllllllllllIllIllIlllIlIlIlIlI = func_194075_d(lllllllllllllIllIllIlllIlIlIlIII);
        this.field_194077_a.clear(lllllllllllllIllIllIlllIlIlIlIlI);
        this.field_194078_b.clear(lllllllllllllIllIllIlllIlIlIlIlI);
    }
    
    public boolean func_193830_f(@Nullable final IRecipe lllllllllllllIllIllIlllIlIllIIlI) {
        return this.field_194077_a.get(func_194075_d(lllllllllllllIllIllIlllIlIllIIlI));
    }
    
    public RecipeBook() {
        this.field_194077_a = new BitSet();
        this.field_194078_b = new BitSet();
    }
    
    public boolean func_192815_c() {
        return this.field_192819_c;
    }
    
    public boolean func_192812_b() {
        return this.field_192818_b;
    }
    
    protected static int func_194075_d(@Nullable final IRecipe lllllllllllllIllIllIlllIlIlIIlII) {
        return CraftingManager.field_193380_a.getIDForObject(lllllllllllllIllIllIlllIlIlIIlII);
    }
    
    public void func_193824_a(final RecipeBook lllllllllllllIllIllIlllIlIllllII) {
        this.field_194077_a.clear();
        this.field_194078_b.clear();
        this.field_194077_a.or(lllllllllllllIllIllIlllIlIllllII.field_194077_a);
        this.field_194078_b.or(lllllllllllllIllIllIlllIlIllllII.field_194078_b);
    }
    
    public void func_193825_e(final IRecipe lllllllllllllIllIllIlllIlIIlIlII) {
        this.field_194078_b.set(func_194075_d(lllllllllllllIllIllIlllIlIIlIlII));
    }
}
