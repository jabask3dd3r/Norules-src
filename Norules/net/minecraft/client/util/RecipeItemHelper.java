package net.minecraft.client.util;

import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import com.google.common.collect.*;
import it.unimi.dsi.fastutil.ints.*;
import java.util.*;

public class RecipeItemHelper
{
    public final /* synthetic */ Int2IntMap field_194124_a;
    
    public void func_194112_a(final ItemStack llllllllllllllIlllIllllllIlIIllI) {
        if (!llllllllllllllIlllIllllllIlIIllI.func_190926_b() && !llllllllllllllIlllIllllllIlIIllI.isItemDamaged() && !llllllllllllllIlllIllllllIlIIllI.isItemEnchanted() && !llllllllllllllIlllIllllllIlIIllI.hasDisplayName()) {
            final int llllllllllllllIlllIllllllIlIlIIl = func_194113_b(llllllllllllllIlllIllllllIlIIllI);
            final int llllllllllllllIlllIllllllIlIlIII = llllllllllllllIlllIllllllIlIIllI.func_190916_E();
            this.func_194117_b(llllllllllllllIlllIllllllIlIlIIl, llllllllllllllIlllIllllllIlIlIII);
        }
    }
    
    public boolean func_194118_a(final IRecipe llllllllllllllIlllIlllllIlllIIIl, @Nullable final IntList llllllllllllllIlllIlllllIllIllII, final int llllllllllllllIlllIlllllIllIllll) {
        return new RecipePicker(llllllllllllllIlllIlllllIlllIIIl).func_194092_a(llllllllllllllIlllIlllllIllIllll, llllllllllllllIlllIlllllIllIllII);
    }
    
    public int func_194121_a(final IRecipe llllllllllllllIlllIlllllIlIllIII, final int llllllllllllllIlllIlllllIlIllIll, @Nullable final IntList llllllllllllllIlllIlllllIlIlIllI) {
        return new RecipePicker(llllllllllllllIlllIlllllIlIllIII).func_194102_b(llllllllllllllIlllIlllllIlIllIll, llllllllllllllIlllIlllllIlIlIllI);
    }
    
    private void func_194117_b(final int llllllllllllllIlllIllllllIIIIIIl, final int llllllllllllllIlllIllllllIIIIIII) {
        this.field_194124_a.put(llllllllllllllIlllIllllllIIIIIIl, this.field_194124_a.get(llllllllllllllIlllIllllllIIIIIIl) + llllllllllllllIlllIllllllIIIIIII);
    }
    
    public int func_194114_b(final IRecipe llllllllllllllIlllIlllllIllIIllI, @Nullable final IntList llllllllllllllIlllIlllllIllIIlIl) {
        return this.func_194121_a(llllllllllllllIlllIlllllIllIIllI, Integer.MAX_VALUE, llllllllllllllIlllIlllllIllIIlIl);
    }
    
    public boolean func_194116_a(final IRecipe llllllllllllllIlllIlllllIllllIll, @Nullable final IntList llllllllllllllIlllIlllllIlllIlll) {
        return this.func_194118_a(llllllllllllllIlllIlllllIllllIll, llllllllllllllIlllIlllllIlllIlll, 1);
    }
    
    public void func_194119_a() {
        this.field_194124_a.clear();
    }
    
    public static int func_194113_b(final ItemStack llllllllllllllIlllIllllllIIlllIl) {
        final Item llllllllllllllIlllIllllllIIlllll = llllllllllllllIlllIllllllIIlllIl.getItem();
        final int llllllllllllllIlllIllllllIIllllI = llllllllllllllIlllIllllllIIlllll.getHasSubtypes() ? llllllllllllllIlllIllllllIIlllIl.getMetadata() : 0;
        return Item.REGISTRY.getIDForObject(llllllllllllllIlllIllllllIIlllll) << 16 | (llllllllllllllIlllIllllllIIllllI & 0xFFFF);
    }
    
    public RecipeItemHelper() {
        this.field_194124_a = (Int2IntMap)new Int2IntOpenHashMap();
    }
    
    public boolean func_194120_a(final int llllllllllllllIlllIllllllIIlIlll) {
        return this.field_194124_a.get(llllllllllllllIlllIllllllIIlIlll) > 0;
    }
    
    public static ItemStack func_194115_b(final int llllllllllllllIlllIlllllIlIlIIll) {
        return (llllllllllllllIlllIlllllIlIlIIll == 0) ? ItemStack.field_190927_a : new ItemStack(Item.getItemById(llllllllllllllIlllIlllllIlIlIIll >> 16 & 0xFFFF), 1, llllllllllllllIlllIlllllIlIlIIll & 0xFFFF);
    }
    
    public int func_194122_a(final int llllllllllllllIlllIllllllIIIlIll, final int llllllllllllllIlllIllllllIIIlllI) {
        final int llllllllllllllIlllIllllllIIIllIl = this.field_194124_a.get(llllllllllllllIlllIllllllIIIlIll);
        if (llllllllllllllIlllIllllllIIIllIl >= llllllllllllllIlllIllllllIIIlllI) {
            this.field_194124_a.put(llllllllllllllIlllIllllllIIIlIll, llllllllllllllIlllIllllllIIIllIl - llllllllllllllIlllIllllllIIIlllI);
            return llllllllllllllIlllIllllllIIIlIll;
        }
        return 0;
    }
    
    class RecipePicker
    {
        private final /* synthetic */ BitSet field_194110_g;
        private final /* synthetic */ IRecipe field_194105_b;
        private final /* synthetic */ int[] field_194108_e;
        private final /* synthetic */ int field_194107_d;
        private final /* synthetic */ List<Ingredient> field_194106_c;
        private final /* synthetic */ int field_194109_f;
        private /* synthetic */ IntList field_194111_h;
        
        private int[] func_194097_a() {
            final IntCollection lllllllllllllIllllllllIlllIllllI = (IntCollection)new IntAVLTreeSet();
            for (final Ingredient lllllllllllllIllllllllIlllIlllIl : this.field_194106_c) {
                lllllllllllllIllllllllIlllIllllI.addAll((IntCollection)lllllllllllllIllllllllIlllIlllIl.func_194139_b());
            }
            final IntIterator lllllllllllllIllllllllIlllIlllII = lllllllllllllIllllllllIlllIllllI.iterator();
            while (lllllllllllllIllllllllIlllIlllII.hasNext()) {
                if (!RecipeItemHelper.this.func_194120_a(lllllllllllllIllllllllIlllIlllII.nextInt())) {
                    lllllllllllllIllllllllIlllIlllII.remove();
                }
            }
            return lllllllllllllIllllllllIlllIllllI.toIntArray();
        }
        
        private int func_194090_b() {
            int lllllllllllllIllllllllIlIlIIIIIl = Integer.MAX_VALUE;
            for (final Ingredient lllllllllllllIllllllllIlIlIIIIII : this.field_194106_c) {
                int lllllllllllllIllllllllIlIIllllll = 0;
                for (final int lllllllllllllIllllllllIlIIlllllI : lllllllllllllIllllllllIlIlIIIIII.func_194139_b()) {
                    lllllllllllllIllllllllIlIIllllll = Math.max(lllllllllllllIllllllllIlIIllllll, RecipeItemHelper.this.field_194124_a.get(lllllllllllllIllllllllIlIIlllllI));
                }
                if (lllllllllllllIllllllllIlIlIIIIIl > 0) {
                    lllllllllllllIllllllllIlIlIIIIIl = Math.min(lllllllllllllIllllllllIlIlIIIIIl, lllllllllllllIllllllllIlIIllllll);
                }
            }
            return lllllllllllllIllllllllIlIlIIIIIl;
        }
        
        private void func_194089_c(final boolean lllllllllllllIllllllllIllIIIllII, final int lllllllllllllIllllllllIllIIIlIll, final int lllllllllllllIllllllllIllIIIIllI) {
            this.field_194110_g.flip(1 + this.func_194095_d(lllllllllllllIllllllllIllIIIllII, lllllllllllllIllllllllIllIIIlIll, lllllllllllllIllllllllIllIIIIllI));
        }
        
        private boolean func_194100_b(final boolean lllllllllllllIllllllllIllIIllIII, final int lllllllllllllIllllllllIllIIlIlll, final int lllllllllllllIllllllllIllIIlIllI) {
            return lllllllllllllIllllllllIllIIllIII ^ this.field_194110_g.get(1 + this.func_194095_d(lllllllllllllIllllllllIllIIllIII, lllllllllllllIllllllllIllIIlIlll, lllllllllllllIllllllllIllIIlIllI));
        }
        
        private void func_194096_c(final int lllllllllllllIllllllllIllIllIIII) {
            this.field_194110_g.set(this.func_194094_d(lllllllllllllIllllllllIllIllIIII));
        }
        
        private boolean func_194093_a(final boolean lllllllllllllIllllllllIllIlIIlII, final int lllllllllllllIllllllllIllIlIIIll, final int lllllllllllllIllllllllIllIIllllI) {
            return this.field_194110_g.get(this.func_194095_d(lllllllllllllIllllllllIllIlIIlII, lllllllllllllIllllllllIllIlIIIll, lllllllllllllIllllllllIllIIllllI));
        }
        
        private int func_194099_c(final boolean lllllllllllllIllllllllIlIllIIIII, final int lllllllllllllIllllllllIlIlIlllll) {
            return (lllllllllllllIllllllllIlIllIIIII ? 0 : this.field_194107_d) + lllllllllllllIllllllllIlIlIlllll;
        }
        
        private int func_194095_d(final boolean lllllllllllllIllllllllIlIlllllll, final int lllllllllllllIllllllllIlIllllllI, final int lllllllllllllIllllllllIlIlllllIl) {
            final int lllllllllllllIllllllllIlIlllllII = lllllllllllllIllllllllIlIlllllll ? (lllllllllllllIllllllllIlIllllllI * this.field_194107_d + lllllllllllllIllllllllIlIlllllIl) : (lllllllllllllIllllllllIlIlllllIl * this.field_194107_d + lllllllllllllIllllllllIlIllllllI);
            return this.field_194107_d + this.field_194109_f + this.field_194107_d + 2 * lllllllllllllIllllllllIlIlllllII;
        }
        
        private boolean func_194101_b(final boolean lllllllllllllIllllllllIlIllIlIIl, final int lllllllllllllIllllllllIlIllIlIII) {
            return this.field_194110_g.get(this.func_194099_c(lllllllllllllIllllllllIlIllIlIIl, lllllllllllllIllllllllIlIllIlIII));
        }
        
        public int func_194102_b(final int lllllllllllllIllllllllIlIlIlIlII, @Nullable final IntList lllllllllllllIllllllllIlIlIIllIl) {
            int lllllllllllllIllllllllIlIlIlIIlI = 0;
            int lllllllllllllIllllllllIlIlIlIIIl = Math.min(lllllllllllllIllllllllIlIlIlIlII, this.func_194090_b()) + 1;
            int lllllllllllllIllllllllIlIlIlIIII;
            while (true) {
                lllllllllllllIllllllllIlIlIlIIII = (lllllllllllllIllllllllIlIlIlIIlI + lllllllllllllIllllllllIlIlIlIIIl) / 2;
                if (this.func_194092_a(lllllllllllllIllllllllIlIlIlIIII, null)) {
                    if (lllllllllllllIllllllllIlIlIlIIIl - lllllllllllllIllllllllIlIlIlIIlI <= 1) {
                        break;
                    }
                    lllllllllllllIllllllllIlIlIlIIlI = lllllllllllllIllllllllIlIlIlIIII;
                }
                else {
                    lllllllllllllIllllllllIlIlIlIIIl = lllllllllllllIllllllllIlIlIlIIII;
                }
            }
            if (lllllllllllllIllllllllIlIlIlIIII > 0) {
                this.func_194092_a(lllllllllllllIllllllllIlIlIlIIII, lllllllllllllIllllllllIlIlIIllIl);
            }
            return lllllllllllllIllllllllIlIlIlIIII;
        }
        
        private boolean func_194098_a(final int lllllllllllllIllllllllIlllIIIIll) {
            for (int lllllllllllllIllllllllIlllIIllII = this.field_194109_f, lllllllllllllIllllllllIlllIIlIll = 0; lllllllllllllIllllllllIlllIIlIll < lllllllllllllIllllllllIlllIIllII; ++lllllllllllllIllllllllIlllIIlIll) {
                if (RecipeItemHelper.this.field_194124_a.get(this.field_194108_e[lllllllllllllIllllllllIlllIIlIll]) >= lllllllllllllIllllllllIlllIIIIll) {
                    this.func_194088_a(false, lllllllllllllIllllllllIlllIIlIll);
                    while (!this.field_194111_h.isEmpty()) {
                        final int lllllllllllllIllllllllIlllIIlIlI = this.field_194111_h.size();
                        final boolean lllllllllllllIllllllllIlllIIlIIl = (lllllllllllllIllllllllIlllIIlIlI & 0x1) == 0x1;
                        final int lllllllllllllIllllllllIlllIIlIII = this.field_194111_h.getInt(lllllllllllllIllllllllIlllIIlIlI - 1);
                        if (!lllllllllllllIllllllllIlllIIlIIl && !this.func_194091_b(lllllllllllllIllllllllIlllIIlIII)) {
                            break;
                        }
                        for (int lllllllllllllIllllllllIlllIIIlll = lllllllllllllIllllllllIlllIIlIIl ? this.field_194107_d : lllllllllllllIllllllllIlllIIllII, lllllllllllllIllllllllIlllIIIllI = 0; lllllllllllllIllllllllIlllIIIllI < lllllllllllllIllllllllIlllIIIlll; ++lllllllllllllIllllllllIlllIIIllI) {
                            if (!this.func_194101_b(lllllllllllllIllllllllIlllIIlIIl, lllllllllllllIllllllllIlllIIIllI) && this.func_194093_a(lllllllllllllIllllllllIlllIIlIIl, lllllllllllllIllllllllIlllIIlIII, lllllllllllllIllllllllIlllIIIllI) && this.func_194100_b(lllllllllllllIllllllllIlllIIlIIl, lllllllllllllIllllllllIlllIIlIII, lllllllllllllIllllllllIlllIIIllI)) {
                                this.func_194088_a(lllllllllllllIllllllllIlllIIlIIl, lllllllllllllIllllllllIlllIIIllI);
                                break;
                            }
                        }
                        final int lllllllllllllIllllllllIlllIIIlIl = this.field_194111_h.size();
                        if (lllllllllllllIllllllllIlllIIIlIl != lllllllllllllIllllllllIlllIIlIlI) {
                            continue;
                        }
                        this.field_194111_h.removeInt(lllllllllllllIllllllllIlllIIIlIl - 1);
                    }
                    if (!this.field_194111_h.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        public RecipePicker(final IRecipe lllllllllllllIlllllllllIIIIIllIl) {
            this.field_194106_c = (List<Ingredient>)Lists.newArrayList();
            this.field_194111_h = (IntList)new IntArrayList();
            this.field_194105_b = lllllllllllllIlllllllllIIIIIllIl;
            this.field_194106_c.addAll(lllllllllllllIlllllllllIIIIIllIl.func_192400_c());
            this.field_194106_c.removeIf(lllllllllllllIllllllllIlIIllIlII -> lllllllllllllIllllllllIlIIllIlII == Ingredient.field_193370_a);
            this.field_194107_d = this.field_194106_c.size();
            this.field_194108_e = this.func_194097_a();
            this.field_194109_f = this.field_194108_e.length;
            this.field_194110_g = new BitSet(this.field_194107_d + this.field_194109_f + this.field_194107_d + this.field_194107_d * this.field_194109_f);
            for (int lllllllllllllIlllllllllIIIIIllII = 0; lllllllllllllIlllllllllIIIIIllII < this.field_194106_c.size(); ++lllllllllllllIlllllllllIIIIIllII) {
                final IntList lllllllllllllIlllllllllIIIIIlIll = this.field_194106_c.get(lllllllllllllIlllllllllIIIIIllII).func_194139_b();
                for (int lllllllllllllIlllllllllIIIIIlIlI = 0; lllllllllllllIlllllllllIIIIIlIlI < this.field_194109_f; ++lllllllllllllIlllllllllIIIIIlIlI) {
                    if (lllllllllllllIlllllllllIIIIIlIll.contains(this.field_194108_e[lllllllllllllIlllllllllIIIIIlIlI])) {
                        this.field_194110_g.set(this.func_194095_d(true, lllllllllllllIlllllllllIIIIIlIlI, lllllllllllllIlllllllllIIIIIllII));
                    }
                }
            }
        }
        
        public boolean func_194092_a(final int lllllllllllllIllllllllIllllIllII, @Nullable final IntList lllllllllllllIllllllllIlllllIlll) {
            if (lllllllllllllIllllllllIllllIllII <= 0) {
                return true;
            }
            int lllllllllllllIllllllllIlllllIllI = 0;
            while (this.func_194098_a(lllllllllllllIllllllllIllllIllII)) {
                RecipeItemHelper.this.func_194122_a(this.field_194108_e[this.field_194111_h.getInt(0)], lllllllllllllIllllllllIllllIllII);
                final int lllllllllllllIllllllllIlllllIlIl = this.field_194111_h.size() - 1;
                this.func_194096_c(this.field_194111_h.getInt(lllllllllllllIllllllllIlllllIlIl));
                for (int lllllllllllllIllllllllIlllllIlII = 0; lllllllllllllIllllllllIlllllIlII < lllllllllllllIllllllllIlllllIlIl; ++lllllllllllllIllllllllIlllllIlII) {
                    this.func_194089_c((lllllllllllllIllllllllIlllllIlII & 0x1) == 0x0, (int)this.field_194111_h.get(lllllllllllllIllllllllIlllllIlII), (int)this.field_194111_h.get(lllllllllllllIllllllllIlllllIlII + 1));
                }
                this.field_194111_h.clear();
                this.field_194110_g.clear(0, this.field_194107_d + this.field_194109_f);
                ++lllllllllllllIllllllllIlllllIllI;
            }
            final boolean lllllllllllllIllllllllIlllllIIll = lllllllllllllIllllllllIlllllIllI == this.field_194107_d;
            final boolean lllllllllllllIllllllllIlllllIIlI = lllllllllllllIllllllllIlllllIIll && lllllllllllllIllllllllIlllllIlll != null;
            if (lllllllllllllIllllllllIlllllIIlI) {
                lllllllllllllIllllllllIlllllIlll.clear();
            }
            this.field_194110_g.clear(0, this.field_194107_d + this.field_194109_f + this.field_194107_d);
            int lllllllllllllIllllllllIlllllIIIl = 0;
            final List<Ingredient> lllllllllllllIllllllllIlllllIIII = this.field_194105_b.func_192400_c();
            for (int lllllllllllllIllllllllIllllIllll = 0; lllllllllllllIllllllllIllllIllll < lllllllllllllIllllllllIlllllIIII.size(); ++lllllllllllllIllllllllIllllIllll) {
                if (lllllllllllllIllllllllIlllllIIlI && lllllllllllllIllllllllIlllllIIII.get(lllllllllllllIllllllllIllllIllll) == Ingredient.field_193370_a) {
                    lllllllllllllIllllllllIlllllIlll.add(0);
                }
                else {
                    for (int lllllllllllllIllllllllIllllIlllI = 0; lllllllllllllIllllllllIllllIlllI < this.field_194109_f; ++lllllllllllllIllllllllIllllIlllI) {
                        if (this.func_194100_b(false, lllllllllllllIllllllllIlllllIIIl, lllllllllllllIllllllllIllllIlllI)) {
                            this.func_194089_c(true, lllllllllllllIllllllllIllllIlllI, lllllllllllllIllllllllIlllllIIIl);
                            RecipeItemHelper.this.func_194117_b(this.field_194108_e[lllllllllllllIllllllllIllllIlllI], lllllllllllllIllllllllIllllIllII);
                            if (lllllllllllllIllllllllIlllllIIlI) {
                                lllllllllllllIllllllllIlllllIlll.add(this.field_194108_e[lllllllllllllIllllllllIllllIlllI]);
                            }
                        }
                    }
                    ++lllllllllllllIllllllllIlllllIIIl;
                }
            }
            return lllllllllllllIllllllllIlllllIIll;
        }
        
        private boolean func_194091_b(final int lllllllllllllIllllllllIllIllIllI) {
            return this.field_194110_g.get(this.func_194094_d(lllllllllllllIllllllllIllIllIllI));
        }
        
        private int func_194094_d(final int lllllllllllllIllllllllIllIlIlIlI) {
            return this.field_194107_d + this.field_194109_f + lllllllllllllIllllllllIllIlIlIlI;
        }
        
        private void func_194088_a(final boolean lllllllllllllIllllllllIlIlllIIlI, final int lllllllllllllIllllllllIlIlllIIIl) {
            this.field_194110_g.set(this.func_194099_c(lllllllllllllIllllllllIlIlllIIlI, lllllllllllllIllllllllIlIlllIIIl));
            this.field_194111_h.add(lllllllllllllIllllllllIlIlllIIIl);
        }
    }
}
