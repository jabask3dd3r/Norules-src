package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;

public final class Object2ObjectSortedMaps
{
    public static final /* synthetic */ EmptySortedMap EMPTY_MAP;
    
    public static <K, V> Object2ObjectSortedMap<K, V> singleton(final K lllllllllllllIlIlIlIIlIIIlIlIllI, final V lllllllllllllIlIlIlIIlIIIlIlIlIl) {
        return new Singleton<K, V>(lllllllllllllIlIlIlIIlIIIlIlIllI, lllllllllllllIlIlIlIIlIIIlIlIlIl);
    }
    
    public static <K, V> Object2ObjectSortedMap<K, V> unmodifiable(final Object2ObjectSortedMap<K, V> lllllllllllllIlIlIlIIlIIIIllIIIl) {
        return (Object2ObjectSortedMap<K, V>)new Object2ObjectSortedMaps.UnmodifiableSortedMap((Object2ObjectSortedMap)lllllllllllllIlIlIlIIlIIIIllIIIl);
    }
    
    public static <K, V> Object2ObjectSortedMap<K, V> synchronize(final Object2ObjectSortedMap<K, V> lllllllllllllIlIlIlIIlIIIIlllllI) {
        return (Object2ObjectSortedMap<K, V>)new Object2ObjectSortedMaps.SynchronizedSortedMap((Object2ObjectSortedMap)lllllllllllllIlIlIlIIlIIIIlllllI);
    }
    
    public static <K, V> Object2ObjectSortedMap<K, V> synchronize(final Object2ObjectSortedMap<K, V> lllllllllllllIlIlIlIIlIIIIllIlll, final Object lllllllllllllIlIlIlIIlIIIIllIllI) {
        return (Object2ObjectSortedMap<K, V>)new Object2ObjectSortedMaps.SynchronizedSortedMap((Object2ObjectSortedMap)lllllllllllllIlIlIlIIlIIIIllIlll, lllllllllllllIlIlIlIIlIIIIllIllI);
    }
    
    private Object2ObjectSortedMaps() {
    }
    
    public static <K, V> Object2ObjectSortedMap<K, V> singleton(final K lllllllllllllIlIlIlIIlIIIlIIIllI, final V lllllllllllllIlIlIlIIlIIIlIIlIIl, final Comparator<? super K> lllllllllllllIlIlIlIIlIIIlIIlIII) {
        return new Singleton<K, V>(lllllllllllllIlIlIlIIlIIIlIIIllI, lllllllllllllIlIlIlIIlIIIlIIlIIl, lllllllllllllIlIlIlIIlIIIlIIlIII);
    }
    
    public static <K, V> ObjectBidirectionalIterable<Object2ObjectMap.Entry<K, V>> fastIterable(final Object2ObjectSortedMap<K, V> lllllllllllllIlIlIlIIlIIIlIlllII) {
        final ObjectSortedSet<Object2ObjectMap.Entry<K, V>> lllllllllllllIlIlIlIIlIIIlIllIll = lllllllllllllIlIlIlIIlIIIlIlllII.object2ObjectEntrySet();
        ObjectBidirectionalIterable<Object2ObjectMap.Entry<K, V>> objectBidirectionalIterable;
        if (lllllllllllllIlIlIlIIlIIIlIllIll instanceof Object2ObjectSortedMap.FastSortedEntrySet) {
            final Object2ObjectSortedMap.FastSortedEntrySet set = (Object2ObjectSortedMap.FastSortedEntrySet)lllllllllllllIlIlIlIIlIIIlIllIll;
            Objects.requireNonNull(set);
            objectBidirectionalIterable = set::fastIterator;
        }
        else {
            objectBidirectionalIterable = lllllllllllllIlIlIlIIlIIIlIllIll;
        }
        return objectBidirectionalIterable;
    }
    
    public static <K> Comparator<? super Map.Entry<K, ?>> entryComparator(final Comparator<? super K> lllllllllllllIlIlIlIIlIIIllIlIIl) {
        return (lllllllllllllIlIlIlIIlIIIIlIlIlI, lllllllllllllIlIlIlIIlIIIIlIlIII) -> lllllllllllllIlIlIlIIlIIIllIlIIl.compare(lllllllllllllIlIlIlIIlIIIIlIlIlI.getKey(), lllllllllllllIlIlIlIIlIIIIlIlIII.getKey());
    }
    
    public static <K, V> Object2ObjectSortedMap<K, V> emptyMap() {
        return (Object2ObjectSortedMap<K, V>)Object2ObjectSortedMaps.EMPTY_MAP;
    }
    
    public static <K, V> ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> fastIterator(final Object2ObjectSortedMap<K, V> lllllllllllllIlIlIlIIlIIIllIIIII) {
        final ObjectSortedSet<Object2ObjectMap.Entry<K, V>> lllllllllllllIlIlIlIIlIIIllIIIIl = lllllllllllllIlIlIlIIlIIIllIIIII.object2ObjectEntrySet();
        return (lllllllllllllIlIlIlIIlIIIllIIIIl instanceof Object2ObjectSortedMap.FastSortedEntrySet) ? ((Object2ObjectSortedMap.FastSortedEntrySet)lllllllllllllIlIlIlIIlIIIllIIIIl).fastIterator() : lllllllllllllIlIlIlIIlIIIllIIIIl.iterator();
    }
    
    static {
        EMPTY_MAP = new EmptySortedMap();
    }
    
    public static class EmptySortedMap<K, V> extends Object2ObjectMaps.EmptyMap<K, V> implements Object2ObjectSortedMap<K, V>, Serializable, Cloneable
    {
        @Override
        public Object2ObjectSortedMap<K, V> subMap(final K llllllllllllllllIllIIllIIllllIlI, final K llllllllllllllllIllIIllIIllllIIl) {
            return (Object2ObjectSortedMap<K, V>)Object2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public K lastKey() {
            throw new NoSuchElementException();
        }
        
        protected EmptySortedMap() {
        }
        
        @Override
        public ObjectSortedSet<Object2ObjectMap.Entry<K, V>> object2ObjectEntrySet() {
            return (ObjectSortedSet<Object2ObjectMap.Entry<K, V>>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public K firstKey() {
            throw new NoSuchElementException();
        }
        
        @Override
        public Object2ObjectSortedMap<K, V> headMap(final K llllllllllllllllIllIIllIIlllIlll) {
            return (Object2ObjectSortedMap<K, V>)Object2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public Object2ObjectSortedMap<K, V> tailMap(final K llllllllllllllllIllIIllIIlllIlIl) {
            return (Object2ObjectSortedMap<K, V>)Object2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return null;
        }
        
        @Override
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return (ObjectSortedSet<Map.Entry<K, V>>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public ObjectSortedSet<K> keySet() {
            return (ObjectSortedSet<K>)ObjectSortedSets.EMPTY_SET;
        }
    }
    
    public static class Singleton<K, V> extends Object2ObjectMaps.Singleton<K, V> implements Object2ObjectSortedMap<K, V>, Serializable, Cloneable
    {
        protected final /* synthetic */ Comparator<? super K> comparator;
        
        @Override
        public Object2ObjectSortedMap<K, V> headMap(final K lllllllllllllIlIllllllIIIIIlIlII) {
            if (this.compare(this.key, lllllllllllllIlIllllllIIIIIlIlII) < 0) {
                return this;
            }
            return (Object2ObjectSortedMap<K, V>)Object2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public K firstKey() {
            return this.key;
        }
        
        protected Singleton(final K lllllllllllllIlIllllllIIIIllIlll, final V lllllllllllllIlIllllllIIIIlllIIl) {
            this(lllllllllllllIlIllllllIIIIllIlll, lllllllllllllIlIllllllIIIIlllIIl, null);
        }
        
        @Override
        public ObjectSortedSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSortedSets.singleton(this.key, this.comparator);
            }
            return (ObjectSortedSet<K>)(ObjectSortedSet)this.keys;
        }
        
        final int compare(final K lllllllllllllIlIllllllIIIIlIlllI, final K lllllllllllllIlIllllllIIIIllIIII) {
            return (this.comparator == null) ? ((Comparable)lllllllllllllIlIllllllIIIIlIlllI).compareTo(lllllllllllllIlIllllllIIIIllIIII) : this.comparator.compare((Object)lllllllllllllIlIllllllIIIIlIlllI, (Object)lllllllllllllIlIllllllIIIIllIIII);
        }
        
        @Override
        public Object2ObjectSortedMap<K, V> subMap(final K lllllllllllllIlIllllllIIIIIlllII, final K lllllllllllllIlIllllllIIIIIllIII) {
            if (this.compare(lllllllllllllIlIllllllIIIIIlllII, this.key) <= 0 && this.compare(this.key, lllllllllllllIlIllllllIIIIIllIII) < 0) {
                return this;
            }
            return (Object2ObjectSortedMap<K, V>)Object2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public ObjectSortedSet<Object2ObjectMap.Entry<K, V>> object2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = (ObjectSet<Object2ObjectMap.Entry<K, V>>)ObjectSortedSets.singleton(new AbstractObject2ObjectMap.BasicEntry<K, V>(this.key, this.value), (Comparator<? super AbstractObject2ObjectMap.BasicEntry<K, V>>)Object2ObjectSortedMaps.entryComparator((Comparator<? super Object>)this.comparator));
            }
            return (ObjectSortedSet<Object2ObjectMap.Entry<K, V>>)(ObjectSortedSet)this.entries;
        }
        
        @Override
        public K lastKey() {
            return this.key;
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return this.comparator;
        }
        
        @Override
        public Object2ObjectSortedMap<K, V> tailMap(final K lllllllllllllIlIllllllIIIIIIlllI) {
            if (this.compare(lllllllllllllIlIllllllIIIIIIlllI, this.key) <= 0) {
                return this;
            }
            return (Object2ObjectSortedMap<K, V>)Object2ObjectSortedMaps.EMPTY_MAP;
        }
        
        protected Singleton(final K lllllllllllllIlIllllllIIIlIIIIIl, final V lllllllllllllIlIllllllIIIlIIIlII, final Comparator<? super K> lllllllllllllIlIllllllIIIlIIIIll) {
            super(lllllllllllllIlIllllllIIIlIIIIIl, lllllllllllllIlIllllllIIIlIIIlII);
            this.comparator = lllllllllllllIlIllllllIIIlIIIIll;
        }
        
        @Override
        public ObjectSortedSet<Map.Entry<K, V>> entrySet() {
            return (ObjectSortedSet<Map.Entry<K, V>>)this.object2ObjectEntrySet();
        }
    }
}
