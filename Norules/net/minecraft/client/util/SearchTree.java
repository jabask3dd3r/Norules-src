package net.minecraft.client.util;

import java.util.function.*;
import net.minecraft.util.*;
import it.unimi.dsi.fastutil.objects.*;
import java.util.*;
import com.google.common.collect.*;

public class SearchTree<T> implements ISearchTree<T>
{
    protected /* synthetic */ SuffixArray<T> field_194045_b;
    private final /* synthetic */ Function<T, Iterable<String>> field_194046_c;
    private /* synthetic */ Object2IntMap<T> field_194049_f;
    private final /* synthetic */ Function<T, Iterable<ResourceLocation>> field_194047_d;
    protected /* synthetic */ SuffixArray<T> field_194044_a;
    private final /* synthetic */ List<T> field_194048_e;
    
    public SearchTree(final Function<T, Iterable<String>> lllllllllllllllIlllIlIllllllIIll, final Function<T, Iterable<ResourceLocation>> lllllllllllllllIlllIlIlllllIllll) {
        this.field_194044_a = new SuffixArray<T>();
        this.field_194045_b = new SuffixArray<T>();
        this.field_194048_e = (List<T>)Lists.newArrayList();
        this.field_194049_f = (Object2IntMap<T>)new Object2IntOpenHashMap();
        this.field_194046_c = lllllllllllllllIlllIlIllllllIIll;
        this.field_194047_d = lllllllllllllllIlllIlIlllllIllll;
    }
    
    private void func_194042_b(final T lllllllllllllllIlllIlIllllIllIll) {
        this.field_194047_d.apply(lllllllllllllllIlllIlIllllIllIll).forEach(lllllllllllllllIlllIlIllllIIIlll -> this.field_194045_b.func_194057_a(lllllllllllllllIlllIlIllllIllIll, lllllllllllllllIlllIlIllllIIIlll.toString().toLowerCase(Locale.ROOT)));
        this.field_194046_c.apply(lllllllllllllllIlllIlIllllIllIll).forEach(lllllllllllllllIlllIlIllllIIIIlI -> this.field_194044_a.func_194057_a(lllllllllllllllIlllIlIllllIllIll, lllllllllllllllIlllIlIllllIIIIlI.toLowerCase(Locale.ROOT)));
    }
    
    public void func_194043_a(final T lllllllllllllllIlllIlIlllllIIIll) {
        this.field_194049_f.put((Object)lllllllllllllllIlllIlIlllllIIIll, this.field_194048_e.size());
        this.field_194048_e.add(lllllllllllllllIlllIlIlllllIIIll);
        this.func_194042_b(lllllllllllllllIlllIlIlllllIIIll);
    }
    
    public void func_194040_a() {
        this.field_194044_a = new SuffixArray<T>();
        this.field_194045_b = new SuffixArray<T>();
        for (final T lllllllllllllllIlllIlIlllllIlIlI : this.field_194048_e) {
            this.func_194042_b(lllllllllllllllIlllIlIlllllIlIlI);
        }
        this.field_194044_a.func_194058_a();
        this.field_194045_b.func_194058_a();
    }
    
    @Override
    public List<T> func_194038_a(final String lllllllllllllllIlllIlIllllIlIlIl) {
        final List<T> lllllllllllllllIlllIlIllllIlIlII = this.field_194044_a.func_194055_a(lllllllllllllllIlllIlIllllIlIlIl);
        if (lllllllllllllllIlllIlIllllIlIlIl.indexOf(58) < 0) {
            return lllllllllllllllIlllIlIllllIlIlII;
        }
        final List<T> lllllllllllllllIlllIlIllllIlIIll = this.field_194045_b.func_194055_a(lllllllllllllllIlllIlIllllIlIlIl);
        return lllllllllllllllIlllIlIllllIlIIll.isEmpty() ? lllllllllllllllIlllIlIllllIlIlII : Lists.newArrayList((Iterator)new MergingIterator((Iterator<Object>)lllllllllllllllIlllIlIllllIlIlII.iterator(), (Iterator<Object>)lllllllllllllllIlllIlIllllIlIIll.iterator(), (it.unimi.dsi.fastutil.objects.Object2IntMap<Object>)this.field_194049_f));
    }
    
    static class MergingIterator<T> extends AbstractIterator<T>
    {
        private final /* synthetic */ Iterator<T> field_194034_b;
        private /* synthetic */ T field_194037_e;
        private /* synthetic */ T field_194036_d;
        private final /* synthetic */ Object2IntMap<T> field_194035_c;
        private final /* synthetic */ Iterator<T> field_194033_a;
        
        protected T computeNext() {
            if (this.field_194036_d == null && this.field_194037_e == null) {
                return (T)this.endOfData();
            }
            int lllllllllllllIIlIlIlIIlIllllIllI = 0;
            if (this.field_194036_d == this.field_194037_e) {
                final int lllllllllllllIIlIlIlIIlIlllllIIl = 0;
            }
            else if (this.field_194036_d == null) {
                final int lllllllllllllIIlIlIlIIlIlllllIII = 1;
            }
            else if (this.field_194037_e == null) {
                final int lllllllllllllIIlIlIlIIlIllllIlll = -1;
            }
            else {
                lllllllllllllIIlIlIlIIlIllllIllI = Integer.compare(this.field_194035_c.getInt((Object)this.field_194036_d), this.field_194035_c.getInt((Object)this.field_194037_e));
            }
            final T lllllllllllllIIlIlIlIIlIllllIlIl = (lllllllllllllIIlIlIlIIlIllllIllI <= 0) ? this.field_194036_d : this.field_194037_e;
            if (lllllllllllllIIlIlIlIIlIllllIllI <= 0) {
                this.field_194036_d = (this.field_194033_a.hasNext() ? this.field_194033_a.next() : null);
            }
            if (lllllllllllllIIlIlIlIIlIllllIllI >= 0) {
                this.field_194037_e = (this.field_194034_b.hasNext() ? this.field_194034_b.next() : null);
            }
            return lllllllllllllIIlIlIlIIlIllllIlIl;
        }
        
        public MergingIterator(final Iterator<T> lllllllllllllIIlIlIlIIllIIIIIlII, final Iterator<T> lllllllllllllIIlIlIlIIlIllllllll, final Object2IntMap<T> lllllllllllllIIlIlIlIIllIIIIIIlI) {
            this.field_194033_a = lllllllllllllIIlIlIlIIllIIIIIlII;
            this.field_194034_b = lllllllllllllIIlIlIlIIlIllllllll;
            this.field_194035_c = lllllllllllllIIlIlIlIIllIIIIIIlI;
            this.field_194036_d = (lllllllllllllIIlIlIlIIllIIIIIlII.hasNext() ? lllllllllllllIIlIlIlIIllIIIIIlII.next() : null);
            this.field_194037_e = (lllllllllllllIIlIlIlIIlIllllllll.hasNext() ? lllllllllllllIIlIlIlIIlIllllllll.next() : null);
        }
    }
}
