package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public final class Int2ObjectSortedMaps
{
    public static final /* synthetic */ EmptySortedMap EMPTY_MAP;
    
    public static <V> ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> fastIterator(final Int2ObjectSortedMap<V> llllllllllllIlllllIIIIlIlIIIIllI) {
        final ObjectSortedSet<Int2ObjectMap.Entry<V>> llllllllllllIlllllIIIIlIlIIIIlll = llllllllllllIlllllIIIIlIlIIIIllI.int2ObjectEntrySet();
        return (llllllllllllIlllllIIIIlIlIIIIlll instanceof Int2ObjectSortedMap.FastSortedEntrySet) ? ((Int2ObjectSortedMap.FastSortedEntrySet)llllllllllllIlllllIIIIlIlIIIIlll).fastIterator() : llllllllllllIlllllIIIIlIlIIIIlll.iterator();
    }
    
    static {
        EMPTY_MAP = new EmptySortedMap();
    }
    
    public static <V> ObjectBidirectionalIterable<Int2ObjectMap.Entry<V>> fastIterable(final Int2ObjectSortedMap<V> llllllllllllIlllllIIIIlIlIIIIIII) {
        final ObjectSortedSet<Int2ObjectMap.Entry<V>> llllllllllllIlllllIIIIlIlIIIIIIl = llllllllllllIlllllIIIIlIlIIIIIII.int2ObjectEntrySet();
        ObjectBidirectionalIterable<Int2ObjectMap.Entry<V>> objectBidirectionalIterable;
        if (llllllllllllIlllllIIIIlIlIIIIIIl instanceof Int2ObjectSortedMap.FastSortedEntrySet) {
            final Int2ObjectSortedMap.FastSortedEntrySet set = (Int2ObjectSortedMap.FastSortedEntrySet)llllllllllllIlllllIIIIlIlIIIIIIl;
            Objects.requireNonNull(set);
            objectBidirectionalIterable = set::fastIterator;
        }
        else {
            objectBidirectionalIterable = llllllllllllIlllllIIIIlIlIIIIIIl;
        }
        return objectBidirectionalIterable;
    }
    
    public static <V> Int2ObjectSortedMap<V> singleton(final int llllllllllllIlllllIIIIlIIllIllIl, final V llllllllllllIlllllIIIIlIIllIllII) {
        return new Singleton<V>(llllllllllllIlllllIIIIlIIllIllIl, llllllllllllIlllllIIIIlIIllIllII);
    }
    
    public static <V> Int2ObjectSortedMap<V> singleton(final int llllllllllllIlllllIIIIlIIllIIIll, final V llllllllllllIlllllIIIIlIIllIIlIl, final IntComparator llllllllllllIlllllIIIIlIIllIIlII) {
        return new Singleton<V>(llllllllllllIlllllIIIIlIIllIIIll, llllllllllllIlllllIIIIlIIllIIlIl, llllllllllllIlllllIIIIlIIllIIlII);
    }
    
    public static <V> Int2ObjectSortedMap<V> synchronize(final Int2ObjectSortedMap<V> llllllllllllIlllllIIIIlIIlIlllll) {
        return (Int2ObjectSortedMap<V>)new Int2ObjectSortedMaps.SynchronizedSortedMap((Int2ObjectSortedMap)llllllllllllIlllllIIIIlIIlIlllll);
    }
    
    public static <V> Int2ObjectSortedMap<V> synchronize(final Int2ObjectSortedMap<V> llllllllllllIlllllIIIIlIIlIllIll, final Object llllllllllllIlllllIIIIlIIlIllIII) {
        return (Int2ObjectSortedMap<V>)new Int2ObjectSortedMaps.SynchronizedSortedMap((Int2ObjectSortedMap)llllllllllllIlllllIIIIlIIlIllIll, llllllllllllIlllllIIIIlIIlIllIII);
    }
    
    public static <V> Int2ObjectSortedMap<V> singleton(final Integer llllllllllllIlllllIIIIlIIlllllII, final V llllllllllllIlllllIIIIlIIllllIll) {
        return new Singleton<V>(llllllllllllIlllllIIIIlIIlllllII, llllllllllllIlllllIIIIlIIllllIll);
    }
    
    private Int2ObjectSortedMaps() {
    }
    
    public static <V> Int2ObjectSortedMap<V> unmodifiable(final Int2ObjectSortedMap<V> llllllllllllIlllllIIIIlIIlIlIllI) {
        return (Int2ObjectSortedMap<V>)new Int2ObjectSortedMaps.UnmodifiableSortedMap((Int2ObjectSortedMap)llllllllllllIlllllIIIIlIIlIlIllI);
    }
    
    public static <V> Int2ObjectSortedMap<V> singleton(final Integer llllllllllllIlllllIIIIlIIlllIIlI, final V llllllllllllIlllllIIIIlIIlllIlII, final IntComparator llllllllllllIlllllIIIIlIIlllIIll) {
        return new Singleton<V>(llllllllllllIlllllIIIIlIIlllIIlI, llllllllllllIlllllIIIIlIIlllIlII, llllllllllllIlllllIIIIlIIlllIIll);
    }
    
    public static Comparator<? super Map.Entry<Integer, ?>> entryComparator(final IntComparator llllllllllllIlllllIIIIlIlIIIllII) {
        return (llllllllllllIlllllIIIIlIIlIlIIII, llllllllllllIlllllIIIIlIIlIIllII) -> llllllllllllIlllllIIIIlIlIIIllII.compare((int)llllllllllllIlllllIIIIlIIlIlIIII.getKey(), (int)llllllllllllIlllllIIIIlIIlIIllII.getKey());
    }
    
    public static <V> Int2ObjectSortedMap<V> emptyMap() {
        return (Int2ObjectSortedMap<V>)Int2ObjectSortedMaps.EMPTY_MAP;
    }
    
    public static class EmptySortedMap<V> extends Int2ObjectMaps.EmptyMap<V> implements Int2ObjectSortedMap<V>, Serializable, Cloneable
    {
        @Deprecated
        @Override
        public Integer lastKey() {
            return this.lastIntKey();
        }
        
        protected EmptySortedMap() {
        }
        
        @Override
        public Int2ObjectSortedMap<V> subMap(final int lllllllllllllIIllIIllIlllllIIlII, final int lllllllllllllIIllIIllIlllllIIIll) {
            return (Int2ObjectSortedMap<V>)Int2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Deprecated
        @Override
        public Integer firstKey() {
            return this.firstIntKey();
        }
        
        @Override
        public int lastIntKey() {
            throw new NoSuchElementException();
        }
        
        @Deprecated
        @Override
        public Int2ObjectSortedMap<V> subMap(final Integer lllllllllllllIIllIIllIllllIIllII, final Integer lllllllllllllIIllIIllIllllIIlIll) {
            return this.subMap((int)lllllllllllllIIllIIllIllllIIllII, (int)lllllllllllllIIllIIllIllllIIlIll);
        }
        
        @Override
        public Int2ObjectSortedMap<V> headMap(final int lllllllllllllIIllIIllIlllllIIIIl) {
            return (Int2ObjectSortedMap<V>)Int2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public int firstIntKey() {
            throw new NoSuchElementException();
        }
        
        @Override
        public IntComparator comparator() {
            return null;
        }
        
        @Deprecated
        @Override
        public Int2ObjectSortedMap<V> headMap(final Integer lllllllllllllIIllIIllIllllIlIlll) {
            return this.headMap((int)lllllllllllllIIllIIllIllllIlIlll);
        }
        
        @Override
        public Int2ObjectSortedMap<V> tailMap(final int lllllllllllllIIllIIllIllllIlllll) {
            return (Int2ObjectSortedMap<V>)Int2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public ObjectSortedSet<Int2ObjectMap.Entry<V>> int2ObjectEntrySet() {
            return (ObjectSortedSet<Int2ObjectMap.Entry<V>>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Override
        public IntSortedSet keySet() {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Deprecated
        @Override
        public ObjectSortedSet<Map.Entry<Integer, V>> entrySet() {
            return (ObjectSortedSet<Map.Entry<Integer, V>>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Deprecated
        @Override
        public Int2ObjectSortedMap<V> tailMap(final Integer lllllllllllllIIllIIllIllllIlIIll) {
            return this.tailMap((int)lllllllllllllIIllIIllIllllIlIIll);
        }
    }
    
    public static class Singleton<V> extends Int2ObjectMaps.Singleton<V> implements Int2ObjectSortedMap<V>, Serializable, Cloneable
    {
        protected final /* synthetic */ IntComparator comparator;
        
        @Override
        public int firstIntKey() {
            return this.key;
        }
        
        @Override
        public Int2ObjectSortedMap<V> headMap(final int lllllllllllllllIllllIIIIlIIIIIII) {
            if (this.compare(this.key, lllllllllllllllIllllIIIIlIIIIIII) < 0) {
                return this;
            }
            return (Int2ObjectSortedMap<V>)Int2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.singleton(this.key, this.comparator);
            }
            return (IntSortedSet)this.keys;
        }
        
        @Override
        public ObjectSortedSet<Int2ObjectMap.Entry<V>> int2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = (ObjectSet<Int2ObjectMap.Entry<V>>)ObjectSortedSets.singleton(new AbstractInt2ObjectMap.BasicEntry<V>(this.key, this.value), Int2ObjectSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet<Int2ObjectMap.Entry<V>>)(ObjectSortedSet)this.entries;
        }
        
        @Deprecated
        @Override
        public Int2ObjectSortedMap<V> tailMap(final Integer lllllllllllllllIllllIIIIIllIlIlI) {
            return this.tailMap((int)lllllllllllllllIllllIIIIIllIlIlI);
        }
        
        @Override
        public Int2ObjectSortedMap<V> subMap(final int lllllllllllllllIllllIIIIlIIIIlll, final int lllllllllllllllIllllIIIIlIIIlIIl) {
            if (this.compare(lllllllllllllllIllllIIIIlIIIIlll, this.key) <= 0 && this.compare(this.key, lllllllllllllllIllllIIIIlIIIlIIl) < 0) {
                return this;
            }
            return (Int2ObjectSortedMap<V>)Int2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public Int2ObjectSortedMap<V> tailMap(final int lllllllllllllllIllllIIIIIllllIlI) {
            if (this.compare(lllllllllllllllIllllIIIIIllllIlI, this.key) <= 0) {
                return this;
            }
            return (Int2ObjectSortedMap<V>)Int2ObjectSortedMaps.EMPTY_MAP;
        }
        
        @Deprecated
        @Override
        public Int2ObjectSortedMap<V> subMap(final Integer lllllllllllllllIllllIIIIIllIIIII, final Integer lllllllllllllllIllllIIIIIllIIIlI) {
            return this.subMap((int)lllllllllllllllIllllIIIIIllIIIII, (int)lllllllllllllllIllllIIIIIllIIIlI);
        }
        
        protected Singleton(final int lllllllllllllllIllllIIIIlIlIIlIl, final V lllllllllllllllIllllIIIIlIlIIlII) {
            this(lllllllllllllllIllllIIIIlIlIIlIl, lllllllllllllllIllllIIIIlIlIIlII, null);
        }
        
        protected Singleton(final int lllllllllllllllIllllIIIIlIllIIll, final V lllllllllllllllIllllIIIIlIllIIlI, final IntComparator lllllllllllllllIllllIIIIlIlIllIl) {
            super(lllllllllllllllIllllIIIIlIllIIll, lllllllllllllllIllllIIIIlIllIIlI);
            this.comparator = lllllllllllllllIllllIIIIlIlIllIl;
        }
        
        @Deprecated
        @Override
        public Int2ObjectSortedMap<V> headMap(final Integer lllllllllllllllIllllIIIIIlllIIII) {
            return this.headMap((int)lllllllllllllllIllllIIIIIlllIIII);
        }
        
        @Override
        public IntComparator comparator() {
            return this.comparator;
        }
        
        @Override
        public int lastIntKey() {
            return this.key;
        }
        
        @Deprecated
        @Override
        public Integer lastKey() {
            return this.lastIntKey();
        }
        
        @Deprecated
        @Override
        public ObjectSortedSet<Map.Entry<Integer, V>> entrySet() {
            return (ObjectSortedSet<Map.Entry<Integer, V>>)this.int2ObjectEntrySet();
        }
        
        final int compare(final int lllllllllllllllIllllIIIIlIIlllll, final int lllllllllllllllIllllIIIIlIIllllI) {
            return (this.comparator == null) ? Integer.compare(lllllllllllllllIllllIIIIlIIlllll, lllllllllllllllIllllIIIIlIIllllI) : this.comparator.compare(lllllllllllllllIllllIIIIlIIlllll, lllllllllllllllIllllIIIIlIIllllI);
        }
        
        @Deprecated
        @Override
        public Integer firstKey() {
            return this.firstIntKey();
        }
    }
}
