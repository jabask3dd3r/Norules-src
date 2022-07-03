package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;

public final class ObjectSortedSets
{
    public static final /* synthetic */ EmptySet EMPTY_SET;
    
    private ObjectSortedSets() {
    }
    
    public static <K> ObjectSortedSet<K> synchronize(final ObjectSortedSet<K> llllllllllllllIIIllIIIIIlIIllllI) {
        return (ObjectSortedSet<K>)new ObjectSortedSets.SynchronizedSortedSet((ObjectSortedSet)llllllllllllllIIIllIIIIIlIIllllI);
    }
    
    public static <K> ObjectSortedSet<K> singleton(final K llllllllllllllIIIllIIIIIlIlIIIIl, final Comparator<? super K> llllllllllllllIIIllIIIIIlIlIIIlI) {
        return new Singleton<K>(llllllllllllllIIIllIIIIIlIlIIIIl, llllllllllllllIIIllIIIIIlIlIIIlI);
    }
    
    public static <K> ObjectSortedSet<K> unmodifiable(final ObjectSortedSet<K> llllllllllllllIIIllIIIIIlIIlIlIl) {
        return (ObjectSortedSet<K>)new ObjectSortedSets.UnmodifiableSortedSet((ObjectSortedSet)llllllllllllllIIIllIIIIIlIIlIlIl);
    }
    
    public static <K> ObjectSet<K> emptySet() {
        return (ObjectSet<K>)ObjectSortedSets.EMPTY_SET;
    }
    
    public static <K> ObjectSortedSet<K> synchronize(final ObjectSortedSet<K> llllllllllllllIIIllIIIIIlIIllIlI, final Object llllllllllllllIIIllIIIIIlIIllIIl) {
        return (ObjectSortedSet<K>)new ObjectSortedSets.SynchronizedSortedSet((ObjectSortedSet)llllllllllllllIIIllIIIIIlIIllIlI, llllllllllllllIIIllIIIIIlIIllIIl);
    }
    
    public static <K> ObjectSortedSet<K> singleton(final K llllllllllllllIIIllIIIIIlIlIIllI) {
        return new Singleton<K>((Object)llllllllllllllIIIllIIIIIlIlIIllI);
    }
    
    static {
        EMPTY_SET = new EmptySet();
    }
    
    public static class EmptySet<K> extends ObjectSets.EmptySet<K> implements ObjectSortedSet<K>, Serializable, Cloneable
    {
        @Override
        public ObjectSortedSet<K> tailSet(final K llllllllllllllIIIIlIlllIIIIIllII) {
            return (ObjectSortedSet<K>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public Object clone() {
            return ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public K last() {
            throw new NoSuchElementException();
        }
        
        protected EmptySet() {
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return null;
        }
        
        private Object readResolve() {
            return ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public K first() {
            throw new NoSuchElementException();
        }
        
        @Override
        public ObjectSortedSet<K> headSet(final K llllllllllllllIIIIlIlllIIIIIlllI) {
            return (ObjectSortedSet<K>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public ObjectSortedSet<K> subSet(final K llllllllllllllIIIIlIlllIIIIlIIIl, final K llllllllllllllIIIIlIlllIIIIlIIII) {
            return (ObjectSortedSet<K>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public ObjectBidirectionalIterator<K> iterator(final K llllllllllllllIIIIlIlllIIIIlIIll) {
            return (ObjectBidirectionalIterator<K>)ObjectIterators.EMPTY_ITERATOR;
        }
    }
    
    public static class Singleton<K> extends ObjectSets.Singleton<K> implements ObjectSortedSet<K>, Serializable, Cloneable
    {
        final /* synthetic */ Comparator<? super K> comparator;
        
        final int compare(final K lllllllllllllIIIlIlIlllIllIIllll, final K lllllllllllllIIIlIlIlllIllIlIIIl) {
            return (this.comparator == null) ? ((Comparable)lllllllllllllIIIlIlIlllIllIIllll).compareTo(lllllllllllllIIIlIlIlllIllIlIIIl) : this.comparator.compare((Object)lllllllllllllIIIlIlIlllIllIIllll, (Object)lllllllllllllIIIlIlIlllIllIlIIIl);
        }
        
        private Singleton(final K lllllllllllllIIIlIlIlllIllIlIlll) {
            this(lllllllllllllIIIlIlIlllIllIlIlll, (Comparator<? super Object>)null);
        }
        
        @Override
        public ObjectSortedSet<K> tailSet(final K lllllllllllllIIIlIlIlllIlIlIllll) {
            if (this.compare(lllllllllllllIIIlIlIlllIlIlIllll, this.element) <= 0) {
                return this;
            }
            return (ObjectSortedSet<K>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return this.comparator;
        }
        
        @Override
        public ObjectSortedSet<K> subSet(final K lllllllllllllIIIlIlIlllIlIlllIlI, final K lllllllllllllIIIlIlIlllIlIllllII) {
            if (this.compare(lllllllllllllIIIlIlIlllIlIlllIlI, this.element) <= 0 && this.compare(this.element, lllllllllllllIIIlIlIlllIlIllllII) < 0) {
                return this;
            }
            return (ObjectSortedSet<K>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public ObjectBidirectionalIterator<K> iterator(final K lllllllllllllIIIlIlIlllIllIIlIIl) {
            final ObjectBidirectionalIterator<K> lllllllllllllIIIlIlIlllIllIIlIII = this.iterator();
            if (this.compare(this.element, lllllllllllllIIIlIlIlllIllIIlIIl) <= 0) {
                lllllllllllllIIIlIlIlllIllIIlIII.next();
            }
            return lllllllllllllIIIlIlIlllIllIIlIII;
        }
        
        @Override
        public K first() {
            return this.element;
        }
        
        @Override
        public K last() {
            return this.element;
        }
        
        protected Singleton(final K lllllllllllllIIIlIlIlllIlllIIIIl, final Comparator<? super K> lllllllllllllIIIlIlIlllIlllIIIII) {
            super(lllllllllllllIIIlIlIlllIlllIIIIl);
            this.comparator = lllllllllllllIIIlIlIlllIlllIIIII;
        }
        
        @Override
        public ObjectSortedSet<K> headSet(final K lllllllllllllIIIlIlIlllIlIllIlIl) {
            if (this.compare(this.element, lllllllllllllIIIlIlIlllIlIllIlIl) < 0) {
                return this;
            }
            return (ObjectSortedSet<K>)ObjectSortedSets.EMPTY_SET;
        }
    }
}
