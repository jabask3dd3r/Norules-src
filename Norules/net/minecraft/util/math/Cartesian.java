package net.minecraft.util.math;

import com.google.common.base.*;
import java.lang.reflect.*;
import com.google.common.collect.*;
import java.util.*;
import javax.annotation.*;

public class Cartesian
{
    private static <T> T[] toArray(final Class<? super T> lllllllllllllIllllIllIIIllIllIIl, final Iterable<? extends T> lllllllllllllIllllIllIIIllIllIII) {
        final List<T> lllllllllllllIllllIllIIIllIlIlll = (List<T>)Lists.newArrayList();
        for (final T lllllllllllllIllllIllIIIllIlIllI : lllllllllllllIllllIllIIIllIllIII) {
            lllllllllllllIllllIllIIIllIlIlll.add(lllllllllllllIllllIllIIIllIlIllI);
        }
        return lllllllllllllIllllIllIIIllIlIlll.toArray(createArray(lllllllllllllIllllIllIIIllIllIIl, lllllllllllllIllllIllIIIllIlIlll.size()));
    }
    
    public static <T> Iterable<List<T>> cartesianProduct(final Iterable<? extends Iterable<? extends T>> lllllllllllllIllllIllIIIlllIIIll) {
        return (Iterable<List<T>>)arraysAsLists(cartesianProduct(Object.class, lllllllllllllIllllIllIIIlllIIIll));
    }
    
    private static <T> Iterable<List<T>> arraysAsLists(final Iterable<Object[]> lllllllllllllIllllIllIIIlllIIIII) {
        return (Iterable<List<T>>)Iterables.transform((Iterable)lllllllllllllIllllIllIIIlllIIIII, (Function)new GetList(null));
    }
    
    public static <T> Iterable<T[]> cartesianProduct(final Class<T> lllllllllllllIllllIllIIIlllIlIII, final Iterable<? extends Iterable<? extends T>> lllllllllllllIllllIllIIIlllIIlll) {
        return new Product<T>(lllllllllllllIllllIllIIIlllIlIII, toArray((Class<? super Iterable>)Iterable.class, (Iterable<? extends Iterable>)lllllllllllllIllllIllIIIlllIIlll), null);
    }
    
    private static <T> T[] createArray(final Class<? super T> lllllllllllllIllllIllIIIllIIlllI, final int lllllllllllllIllllIllIIIllIIlIll) {
        return (T[])Array.newInstance(lllllllllllllIllllIllIIIllIIlllI, lllllllllllllIllllIllIIIllIIlIll);
    }
    
    static class Product<T> implements Iterable<T[]>
    {
        private final /* synthetic */ Class<T> clazz;
        private final /* synthetic */ Iterable<? extends T>[] iterables;
        
        @Override
        public Iterator<T[]> iterator() {
            return (Iterator<T[]>)((this.iterables.length <= 0) ? Collections.singletonList(createArray(this.clazz, 0)).iterator() : new ProductIterator(this.clazz, this.iterables, null));
        }
        
        private Product(final Class<T> lllllllllllllllllllIIIlIlIIIllII, final Iterable<? extends T>[] lllllllllllllllllllIIIlIlIIIlIll) {
            this.clazz = lllllllllllllllllllIIIlIlIIIllII;
            this.iterables = lllllllllllllllllllIIIlIlIIIlIll;
        }
        
        static class ProductIterator<T> extends UnmodifiableIterator<T[]>
        {
            private /* synthetic */ int index;
            private final /* synthetic */ T[] results;
            private final /* synthetic */ Iterable<? extends T>[] iterables;
            private final /* synthetic */ Iterator<? extends T>[] iterators;
            
            private void endOfData() {
                this.index = -1;
                Arrays.fill(this.iterators, null);
                Arrays.fill(this.results, null);
            }
            
            public T[] next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                while (this.index < this.iterators.length) {
                    this.results[this.index] = (T)this.iterators[this.index].next();
                    ++this.index;
                }
                return this.results.clone();
            }
            
            private ProductIterator(final Class<T> lllllllllllllIIIIIIlIlIIIIIIlIlI, final Iterable<? extends T>[] lllllllllllllIIIIIIlIlIIIIIIlIIl) {
                this.index = -2;
                this.iterables = lllllllllllllIIIIIIlIlIIIIIIlIIl;
                this.iterators = (Iterator<? extends T>[])createArray(Iterator.class, this.iterables.length);
                for (int lllllllllllllIIIIIIlIlIIIIIIlIII = 0; lllllllllllllIIIIIIlIlIIIIIIlIII < this.iterables.length; ++lllllllllllllIIIIIIlIlIIIIIIlIII) {
                    this.iterators[lllllllllllllIIIIIIlIlIIIIIIlIII] = lllllllllllllIIIIIIlIlIIIIIIlIIl[lllllllllllllIIIIIIlIlIIIIIIlIII].iterator();
                }
                this.results = (T[])createArray(lllllllllllllIIIIIIlIlIIIIIIlIlI, this.iterators.length);
            }
            
            public boolean hasNext() {
                if (this.index == -2) {
                    this.index = 0;
                    final float lllllllllllllIIIIIIlIIllllllIlII;
                    final double lllllllllllllIIIIIIlIIllllllIlIl = ((Iterator<? extends T>[])(Object)(lllllllllllllIIIIIIlIIllllllIlII = (float)(Object)this.iterators)).length;
                    for (final Iterator<? extends T> lllllllllllllIIIIIIlIIlllllllIlI : lllllllllllllIIIIIIlIIllllllIlII) {
                        if (!lllllllllllllIIIIIIlIIlllllllIlI.hasNext()) {
                            this.endOfData();
                            break;
                        }
                    }
                    return true;
                }
                if (this.index >= this.iterators.length) {
                    this.index = this.iterators.length - 1;
                    while (this.index >= 0) {
                        Iterator<? extends T> lllllllllllllIIIIIIlIIlllllllIIl = this.iterators[this.index];
                        if (lllllllllllllIIIIIIlIIlllllllIIl.hasNext()) {
                            break;
                        }
                        if (this.index == 0) {
                            this.endOfData();
                            break;
                        }
                        lllllllllllllIIIIIIlIIlllllllIIl = this.iterables[this.index].iterator();
                        this.iterators[this.index] = lllllllllllllIIIIIIlIIlllllllIIl;
                        if (!lllllllllllllIIIIIIlIIlllllllIIl.hasNext()) {
                            this.endOfData();
                            break;
                        }
                        --this.index;
                    }
                }
                return this.index >= 0;
            }
        }
    }
    
    static class GetList<T> implements Function<Object[], List<T>>
    {
        private GetList() {
        }
        
        public List<T> apply(@Nullable final Object[] lllllllllllllIIlIlllIlIlIIlIlIIl) {
            return Arrays.asList((T[])lllllllllllllIIlIlllIlIlIIlIlIIl);
        }
    }
}
