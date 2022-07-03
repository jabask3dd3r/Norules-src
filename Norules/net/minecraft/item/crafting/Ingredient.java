package net.minecraft.item.crafting;

import com.google.common.base.*;
import net.minecraft.item.*;
import net.minecraft.client.util.*;
import it.unimi.dsi.fastutil.ints.*;
import java.util.*;
import javax.annotation.*;

public class Ingredient implements Predicate<ItemStack>
{
    private /* synthetic */ IntList field_194140_c;
    public static final /* synthetic */ Ingredient field_193370_a;
    private final /* synthetic */ ItemStack[] field_193371_b;
    
    public static Ingredient func_193368_a(final Item... lllllllllllllIllllllIlIIIlllllll) {
        final ItemStack[] lllllllllllllIllllllIlIIlIIIIIIl = new ItemStack[lllllllllllllIllllllIlIIIlllllll.length];
        for (int lllllllllllllIllllllIlIIlIIIIIII = 0; lllllllllllllIllllllIlIIlIIIIIII < lllllllllllllIllllllIlIIIlllllll.length; ++lllllllllllllIllllllIlIIlIIIIIII) {
            lllllllllllllIllllllIlIIlIIIIIIl[lllllllllllllIllllllIlIIlIIIIIII] = new ItemStack(lllllllllllllIllllllIlIIIlllllll[lllllllllllllIllllllIlIIlIIIIIII]);
        }
        return func_193369_a(lllllllllllllIllllllIlIIlIIIIIIl);
    }
    
    public static Ingredient func_193369_a(final ItemStack... lllllllllllllIllllllIlIIIlllIlIl) {
        if (lllllllllllllIllllllIlIIIlllIlIl.length > 0) {
            final char lllllllllllllIllllllIlIIIlllIIIl = (Object)lllllllllllllIllllllIlIIIlllIlIl;
            final Exception lllllllllllllIllllllIlIIIlllIIlI = (Exception)lllllllllllllIllllllIlIIIlllIlIl.length;
            for (byte lllllllllllllIllllllIlIIIlllIIll = 0; lllllllllllllIllllllIlIIIlllIIll < lllllllllllllIllllllIlIIIlllIIlI; ++lllllllllllllIllllllIlIIIlllIIll) {
                final ItemStack lllllllllllllIllllllIlIIIlllIllI = lllllllllllllIllllllIlIIIlllIIIl[lllllllllllllIllllllIlIIIlllIIll];
                if (!lllllllllllllIllllllIlIIIlllIllI.func_190926_b()) {
                    return new Ingredient(lllllllllllllIllllllIlIIIlllIlIl);
                }
            }
        }
        return Ingredient.field_193370_a;
    }
    
    public IntList func_194139_b() {
        if (this.field_194140_c == null) {
            this.field_194140_c = (IntList)new IntArrayList(this.field_193371_b.length);
            final long lllllllllllllIllllllIlIIlIIIlIIl;
            final char lllllllllllllIllllllIlIIlIIIlIlI = (char)((ItemStack[])(Object)(lllllllllllllIllllllIlIIlIIIlIIl = (long)(Object)this.field_193371_b)).length;
            for (float lllllllllllllIllllllIlIIlIIIlIll = 0; lllllllllllllIllllllIlIIlIIIlIll < lllllllllllllIllllllIlIIlIIIlIlI; ++lllllllllllllIllllllIlIIlIIIlIll) {
                final ItemStack lllllllllllllIllllllIlIIlIIIlllI = lllllllllllllIllllllIlIIlIIIlIIl[lllllllllllllIllllllIlIIlIIIlIll];
                this.field_194140_c.add(RecipeItemHelper.func_194113_b(lllllllllllllIllllllIlIIlIIIlllI));
            }
            this.field_194140_c.sort((Comparator)IntComparators.NATURAL_COMPARATOR);
        }
        return this.field_194140_c;
    }
    
    public static Ingredient func_193367_a(final Item lllllllllllllIllllllIlIIlIIIIllI) {
        return func_193369_a(new ItemStack(lllllllllllllIllllllIlIIlIIIIllI, 1, 32767));
    }
    
    static {
        field_193370_a = new Ingredient() {
            @Override
            public boolean apply(@Nullable final ItemStack lllllllllllllIlIIlllIlIlIIlIIIll) {
                return lllllllllllllIlIIlllIlIlIIlIIIll.func_190926_b();
            }
        };
    }
    
    public ItemStack[] func_193365_a() {
        return this.field_193371_b;
    }
    
    public boolean apply(@Nullable final ItemStack lllllllllllllIllllllIlIIlIIllIlI) {
        if (lllllllllllllIllllllIlIIlIIllIlI == null) {
            return false;
        }
        final double lllllllllllllIllllllIlIIlIIlIllI;
        final byte lllllllllllllIllllllIlIIlIIlIlll = (byte)((ItemStack[])(Object)(lllllllllllllIllllllIlIIlIIlIllI = (double)(Object)this.field_193371_b)).length;
        for (char lllllllllllllIllllllIlIIlIIllIII = '\0'; lllllllllllllIllllllIlIIlIIllIII < lllllllllllllIllllllIlIIlIIlIlll; ++lllllllllllllIllllllIlIIlIIllIII) {
            final ItemStack lllllllllllllIllllllIlIIlIIlllIl = lllllllllllllIllllllIlIIlIIlIllI[lllllllllllllIllllllIlIIlIIllIII];
            if (lllllllllllllIllllllIlIIlIIlllIl.getItem() == lllllllllllllIllllllIlIIlIIllIlI.getItem()) {
                final int lllllllllllllIllllllIlIIlIIlllII = lllllllllllllIllllllIlIIlIIlllIl.getMetadata();
                if (lllllllllllllIllllllIlIIlIIlllII == 32767 || lllllllllllllIllllllIlIIlIIlllII == lllllllllllllIllllllIlIIlIIllIlI.getMetadata()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private Ingredient(final ItemStack... lllllllllllllIllllllIlIIlIlIllII) {
        this.field_193371_b = lllllllllllllIllllllIlIIlIlIllII;
    }
}
