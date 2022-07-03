package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;
import java.io.*;

public final class ObjectCollections
{
    private ObjectCollections() {
    }
    
    public static <K> ObjectCollection<K> asCollection(final ObjectIterable<K> lllllllllllllllIIIlIllIIIIllIIlI) {
        if (lllllllllllllllIIIlIllIIIIllIIlI instanceof ObjectCollection) {
            return (ObjectCollection<K>)(ObjectCollection)lllllllllllllllIIIlIllIIIIllIIlI;
        }
        return new IterableCollection<K>(lllllllllllllllIIIlIllIIIIllIIlI);
    }
    
    public static <K> ObjectCollection<K> unmodifiable(final ObjectCollection<K> lllllllllllllllIIIlIllIIIIlllIlI) {
        return (ObjectCollection<K>)new ObjectCollections.UnmodifiableCollection((ObjectCollection)lllllllllllllllIIIlIllIIIIlllIlI);
    }
    
    public static <K> ObjectCollection<K> synchronize(final ObjectCollection<K> lllllllllllllllIIIlIllIIIlIIIIlI, final Object lllllllllllllllIIIlIllIIIlIIIIIl) {
        return (ObjectCollection<K>)new ObjectCollections.SynchronizedCollection((ObjectCollection)lllllllllllllllIIIlIllIIIlIIIIlI, lllllllllllllllIIIlIllIIIlIIIIIl);
    }
    
    public static <K> ObjectCollection<K> synchronize(final ObjectCollection<K> lllllllllllllllIIIlIllIIIlIIlIlI) {
        return (ObjectCollection<K>)new ObjectCollections.SynchronizedCollection((ObjectCollection)lllllllllllllllIIIlIllIIIlIIlIlI);
    }
    
    public abstract static class EmptyCollection<K> extends AbstractObjectCollection<K>
    {
        @Override
        public int hashCode() {
            return 0;
        }
        
        protected EmptyCollection() {
        }
        
        @Override
        public ObjectBidirectionalIterator<K> iterator() {
            return (ObjectBidirectionalIterator<K>)ObjectIterators.EMPTY_ITERATOR;
        }
        
        @Override
        public Object[] toArray() {
            return ObjectArrays.EMPTY_ARRAY;
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIllIIIlIllIIllIlll) {
            return llllllllllllllIllIIIlIllIIllIlll == this || (llllllllllllllIllIIIlIllIIllIlll instanceof Collection && ((Collection)llllllllllllllIllIIIlIllIIllIlll).isEmpty());
        }
        
        @Override
        public boolean addAll(final Collection<? extends K> llllllllllllllIllIIIlIllIIllIIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int size() {
            return 0;
        }
        
        @Override
        public boolean removeAll(final Collection<?> llllllllllllllIllIIIlIllIIllIIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean contains(final Object llllllllllllllIllIIIlIllIlIIIIII) {
            return false;
        }
        
        @Override
        public boolean retainAll(final Collection<?> llllllllllllllIllIIIlIllIIlIllll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
        }
    }
    
    public static class IterableCollection<K> extends AbstractObjectCollection<K> implements Serializable
    {
        protected final /* synthetic */ ObjectIterable<K> iterable;
        
        @Override
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }
        
        protected IterableCollection(final ObjectIterable<K> llllllllllllllIlllIIlIIIIlllIIIl) {
            if (llllllllllllllIlllIIlIIIIlllIIIl == null) {
                throw new NullPointerException();
            }
            this.iterable = llllllllllllllIlllIIlIIIIlllIIIl;
        }
        
        @Override
        public int size() {
            int llllllllllllllIlllIIlIIIIllIIIIl = 0;
            final ObjectIterator<K> llllllllllllllIlllIIlIIIIllIIIII = this.iterator();
            while (llllllllllllllIlllIIlIIIIllIIIII.hasNext()) {
                llllllllllllllIlllIIlIIIIllIIIII.next();
                ++llllllllllllllIlllIIlIIIIllIIIIl;
            }
            return llllllllllllllIlllIIlIIIIllIIIIl;
        }
        
        @Override
        public ObjectIterator<K> iterator() {
            return this.iterable.iterator();
        }
    }
}
