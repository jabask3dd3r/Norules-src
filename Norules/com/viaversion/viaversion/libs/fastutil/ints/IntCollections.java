package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import java.io.*;

public final class IntCollections
{
    public static IntCollection asCollection(final IntIterable lllllllllllllIIlIlIllllIIIIIllIl) {
        if (lllllllllllllIIlIlIllllIIIIIllIl instanceof IntCollection) {
            return (IntCollection)lllllllllllllIIlIlIllllIIIIIllIl;
        }
        return new IterableCollection(lllllllllllllIIlIlIllllIIIIIllIl);
    }
    
    private IntCollections() {
    }
    
    public static IntCollection synchronize(final IntCollection lllllllllllllIIlIlIllllIIIIllIlI) {
        return (IntCollection)new IntCollections.SynchronizedCollection(lllllllllllllIIlIlIllllIIIIllIlI);
    }
    
    public static IntCollection synchronize(final IntCollection lllllllllllllIIlIlIllllIIIIlIllI, final Object lllllllllllllIIlIlIllllIIIIlIlIl) {
        return (IntCollection)new IntCollections.SynchronizedCollection(lllllllllllllIIlIlIllllIIIIlIllI, lllllllllllllIIlIlIllllIIIIlIlIl);
    }
    
    public static IntCollection unmodifiable(final IntCollection lllllllllllllIIlIlIllllIIIIlIIII) {
        return (IntCollection)new IntCollections.UnmodifiableCollection(lllllllllllllIIlIlIllllIIIIlIIII);
    }
    
    public abstract static class EmptyCollection extends AbstractIntCollection
    {
        @Override
        public int size() {
            return 0;
        }
        
        @Override
        public boolean removeAll(final Collection<?> lllllllllllllIIIIlIIIIlllllIllIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public boolean addAll(final Collection<? extends Integer> lllllllllllllIIIIlIIIIlllllIllll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean retainAll(final IntCollection lllllllllllllIIIIlIIIIlllllIIlIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean removeAll(final IntCollection lllllllllllllIIIIlIIIIlllllIIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final IntCollection lllllllllllllIIIIlIIIIlllllIlIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntBidirectionalIterator iterator() {
            return IntIterators.EMPTY_ITERATOR;
        }
        
        @Override
        public boolean retainAll(final Collection<?> lllllllllllllIIIIlIIIIlllllIlIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIIIIlIIIIllllllIIIl) {
            return lllllllllllllIIIIlIIIIllllllIIIl == this || (lllllllllllllIIIIlIIIIllllllIIIl instanceof Collection && ((Collection)lllllllllllllIIIIlIIIIllllllIIIl).isEmpty());
        }
        
        @Override
        public Object[] toArray() {
            return ObjectArrays.EMPTY_ARRAY;
        }
        
        @Override
        public void clear() {
        }
        
        @Override
        public boolean contains(final int lllllllllllllIIIIlIIIIllllllllII) {
            return false;
        }
        
        protected EmptyCollection() {
        }
    }
    
    public static class IterableCollection extends AbstractIntCollection implements Serializable
    {
        protected final /* synthetic */ IntIterable iterable;
        
        @Override
        public IntIterator iterator() {
            return this.iterable.iterator();
        }
        
        @Override
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }
        
        @Override
        public int size() {
            int lllllllllllllllIlllllllIIIIlIlII = 0;
            final IntIterator lllllllllllllllIlllllllIIIIlIIll = this.iterator();
            while (lllllllllllllllIlllllllIIIIlIIll.hasNext()) {
                lllllllllllllllIlllllllIIIIlIIll.nextInt();
                ++lllllllllllllllIlllllllIIIIlIlII;
            }
            return lllllllllllllllIlllllllIIIIlIlII;
        }
        
        protected IterableCollection(final IntIterable lllllllllllllllIlllllllIIIIllIIl) {
            if (lllllllllllllllIlllllllIIIIllIIl == null) {
                throw new NullPointerException();
            }
            this.iterable = lllllllllllllllIlllllllIIIIllIIl;
        }
    }
}
