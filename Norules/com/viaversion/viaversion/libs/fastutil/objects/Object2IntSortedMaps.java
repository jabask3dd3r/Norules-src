package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;

public final class Object2IntSortedMaps
{
    public static final /* synthetic */ EmptySortedMap EMPTY_MAP;
    
    public static <K> Object2IntSortedMap<K> singleton(final K lllllllllllllIlIlllIIlIllIIlIIll, final Integer lllllllllllllIlIlllIIlIllIIlIIlI) {
        return new Singleton<K>(lllllllllllllIlIlllIIlIllIIlIIll, lllllllllllllIlIlllIIlIllIIlIIlI);
    }
    
    public static <K> Object2IntSortedMap<K> synchronize(final Object2IntSortedMap<K> lllllllllllllIlIlllIIlIlIlllIllI) {
        return (Object2IntSortedMap<K>)new Object2IntSortedMaps.SynchronizedSortedMap((Object2IntSortedMap)lllllllllllllIlIlllIIlIlIlllIllI);
    }
    
    static {
        EMPTY_MAP = new EmptySortedMap();
    }
    
    public static <K> Object2IntSortedMap<K> singleton(final K lllllllllllllIlIlllIIlIllIIIllII, final Integer lllllllllllllIlIlllIIlIllIIIlIII, final Comparator<? super K> lllllllllllllIlIlllIIlIllIIIIlll) {
        return new Singleton<K>(lllllllllllllIlIlllIIlIllIIIllII, lllllllllllllIlIlllIIlIllIIIlIII, lllllllllllllIlIlllIIlIllIIIIlll);
    }
    
    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(final Comparator<? super K> lllllllllllllIlIlllIIlIllIlIIIll) {
        return (lllllllllllllIlIlllIIlIlIllIIlII, lllllllllllllIlIlllIIlIlIllIIIll) -> lllllllllllllIlIlllIIlIllIlIIIll.compare(lllllllllllllIlIlllIIlIlIllIIlII.getKey(), lllllllllllllIlIlllIIlIlIllIIIll.getKey());
    }
    
    public static <K> ObjectBidirectionalIterator<Object2IntMap.Entry<K>> fastIterator(final Object2IntSortedMap<K> lllllllllllllIlIlllIIlIllIIlllIl) {
        final ObjectSortedSet<Object2IntMap.Entry<K>> lllllllllllllIlIlllIIlIllIIllllI = lllllllllllllIlIlllIIlIllIIlllIl.object2IntEntrySet();
        return (lllllllllllllIlIlllIIlIllIIllllI instanceof Object2IntSortedMap.FastSortedEntrySet) ? ((Object2IntSortedMap.FastSortedEntrySet)lllllllllllllIlIlllIIlIllIIllllI).fastIterator() : lllllllllllllIlIlllIIlIllIIllllI.iterator();
    }
    
    private Object2IntSortedMaps() {
    }
    
    public static <K> Object2IntSortedMap<K> unmodifiable(final Object2IntSortedMap<K> lllllllllllllIlIlllIIlIlIllIllIl) {
        return (Object2IntSortedMap<K>)new Object2IntSortedMaps.UnmodifiableSortedMap((Object2IntSortedMap)lllllllllllllIlIlllIIlIlIllIllIl);
    }
    
    public static <K> Object2IntSortedMap<K> emptyMap() {
        return (Object2IntSortedMap<K>)Object2IntSortedMaps.EMPTY_MAP;
    }
    
    public static <K> Object2IntSortedMap<K> synchronize(final Object2IntSortedMap<K> lllllllllllllIlIlllIIlIlIlllIIlI, final Object lllllllllllllIlIlllIIlIlIlllIIIl) {
        return (Object2IntSortedMap<K>)new Object2IntSortedMaps.SynchronizedSortedMap((Object2IntSortedMap)lllllllllllllIlIlllIIlIlIlllIIlI, lllllllllllllIlIlllIIlIlIlllIIIl);
    }
    
    public static <K> Object2IntSortedMap<K> singleton(final K lllllllllllllIlIlllIIlIllIIIIlII, final int lllllllllllllIlIlllIIlIllIIIIIIl) {
        return new Singleton<K>(lllllllllllllIlIlllIIlIllIIIIlII, lllllllllllllIlIlllIIlIllIIIIIIl);
    }
    
    public static <K> ObjectBidirectionalIterable<Object2IntMap.Entry<K>> fastIterable(final Object2IntSortedMap<K> lllllllllllllIlIlllIIlIllIIlIlll) {
        final ObjectSortedSet<Object2IntMap.Entry<K>> lllllllllllllIlIlllIIlIllIIllIII = lllllllllllllIlIlllIIlIllIIlIlll.object2IntEntrySet();
        ObjectBidirectionalIterable<Object2IntMap.Entry<K>> objectBidirectionalIterable;
        if (lllllllllllllIlIlllIIlIllIIllIII instanceof Object2IntSortedMap.FastSortedEntrySet) {
            final Object2IntSortedMap.FastSortedEntrySet set = (Object2IntSortedMap.FastSortedEntrySet)lllllllllllllIlIlllIIlIllIIllIII;
            Objects.requireNonNull(set);
            objectBidirectionalIterable = set::fastIterator;
        }
        else {
            objectBidirectionalIterable = lllllllllllllIlIlllIIlIllIIllIII;
        }
        return objectBidirectionalIterable;
    }
    
    public static <K> Object2IntSortedMap<K> singleton(final K lllllllllllllIlIlllIIlIlIllllIlI, final int lllllllllllllIlIlllIIlIlIllllIIl, final Comparator<? super K> lllllllllllllIlIlllIIlIlIllllIII) {
        return new Singleton<K>(lllllllllllllIlIlllIIlIlIllllIlI, lllllllllllllIlIlllIIlIlIllllIIl, lllllllllllllIlIlllIIlIlIllllIII);
    }
    
    public static class EmptySortedMap<K> extends Object2IntMaps.EmptyMap<K> implements Object2IntSortedMap<K>, Serializable, Cloneable
    {
        @Override
        public Object2IntSortedMap<K> headMap(final K lllllllllllllllIIIIllIIIIlIlIllI) {
            return (Object2IntSortedMap<K>)Object2IntSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public Object2IntSortedMap<K> subMap(final K lllllllllllllllIIIIllIIIIlIllIIl, final K lllllllllllllllIIIIllIIIIlIllIII) {
            return (Object2IntSortedMap<K>)Object2IntSortedMaps.EMPTY_MAP;
        }
        
        protected EmptySortedMap() {
        }
        
        @Override
        public K lastKey() {
            throw new NoSuchElementException();
        }
        
        @Override
        public K firstKey() {
            throw new NoSuchElementException();
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return null;
        }
        
        @Override
        public Object2IntSortedMap<K> tailMap(final K lllllllllllllllIIIIllIIIIlIlIlII) {
            return (Object2IntSortedMap<K>)Object2IntSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public ObjectSortedSet<Object2IntMap.Entry<K>> object2IntEntrySet() {
            return (ObjectSortedSet<Object2IntMap.Entry<K>>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Deprecated
        @Override
        public ObjectSortedSet<Map.Entry<K, Integer>> entrySet() {
            return (ObjectSortedSet<Map.Entry<K, Integer>>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public ObjectSortedSet<K> keySet() {
            return (ObjectSortedSet<K>)ObjectSortedSets.EMPTY_SET;
        }
    }
    
    public static class Singleton<K> extends Object2IntMaps.Singleton<K> implements Object2IntSortedMap<K>, Serializable, Cloneable
    {
        protected final /* synthetic */ Comparator<? super K> comparator;
        
        @Override
        public K lastKey() {
            return this.key;
        }
        
        @Override
        public Object2IntSortedMap<K> subMap(final K llllllllllllllIllIIIIIIIIIIlIIII, final K llllllllllllllIllIIIIIIIIIIlIlII) {
            if (this.compare(llllllllllllllIllIIIIIIIIIIlIIII, this.key) <= 0 && this.compare(this.key, llllllllllllllIllIIIIIIIIIIlIlII) < 0) {
                return this;
            }
            return (Object2IntSortedMap<K>)Object2IntSortedMaps.EMPTY_MAP;
        }
        
        protected Singleton(final K llllllllllllllIllIIIIIIIIlIIIIll, final int llllllllllllllIllIIIIIIIIlIIIIlI, final Comparator<? super K> llllllllllllllIllIIIIIIIIlIIIIIl) {
            super(llllllllllllllIllIIIIIIIIlIIIIll, llllllllllllllIllIIIIIIIIlIIIIlI);
            this.comparator = llllllllllllllIllIIIIIIIIlIIIIIl;
        }
        
        @Override
        public ObjectSortedSet<Object2IntMap.Entry<K>> object2IntEntrySet() {
            if (this.entries == null) {
                this.entries = (ObjectSet<Object2IntMap.Entry<K>>)ObjectSortedSets.singleton(new AbstractObject2IntMap.BasicEntry<K>(this.key, this.value), (Comparator<? super AbstractObject2IntMap.BasicEntry<K>>)Object2IntSortedMaps.entryComparator((Comparator<? super Object>)this.comparator));
            }
            return (ObjectSortedSet<Object2IntMap.Entry<K>>)(ObjectSortedSet)this.entries;
        }
        
        @Deprecated
        @Override
        public ObjectSortedSet<Map.Entry<K, Integer>> entrySet() {
            return (ObjectSortedSet<Map.Entry<K, Integer>>)this.object2IntEntrySet();
        }
        
        final int compare(final K llllllllllllllIllIIIIIIIIIlIlllI, final K llllllllllllllIllIIIIIIIIIlIlIIl) {
            return (this.comparator == null) ? ((Comparable)llllllllllllllIllIIIIIIIIIlIlllI).compareTo(llllllllllllllIllIIIIIIIIIlIlIIl) : this.comparator.compare((Object)llllllllllllllIllIIIIIIIIIlIlllI, (Object)llllllllllllllIllIIIIIIIIIlIlIIl);
        }
        
        @Override
        public Object2IntSortedMap<K> headMap(final K llllllllllllllIllIIIIIIIIIIIIIIl) {
            if (this.compare(this.key, llllllllllllllIllIIIIIIIIIIIIIIl) < 0) {
                return this;
            }
            return (Object2IntSortedMap<K>)Object2IntSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public Object2IntSortedMap<K> tailMap(final K llllllllllllllIlIlllllllllllIlII) {
            if (this.compare(llllllllllllllIlIlllllllllllIlII, this.key) <= 0) {
                return this;
            }
            return (Object2IntSortedMap<K>)Object2IntSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet<K>)(ObjectSortedSet)this.keys;
        }
        
        @Override
        public K firstKey() {
            return this.key;
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return this.comparator;
        }
        
        protected Singleton(final K llllllllllllllIllIIIIIIIIIlllIIl, final int llllllllllllllIllIIIIIIIIIlllIll) {
            this(llllllllllllllIllIIIIIIIIIlllIIl, llllllllllllllIllIIIIIIIIIlllIll, null);
        }
    }
}
