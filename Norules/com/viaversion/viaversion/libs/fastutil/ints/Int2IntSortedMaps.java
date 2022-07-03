package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public final class Int2IntSortedMaps
{
    public static final /* synthetic */ EmptySortedMap EMPTY_MAP;
    
    public static ObjectBidirectionalIterator<Int2IntMap.Entry> fastIterator(final Int2IntSortedMap lllllllllllllIlIllIlIlIlIIIIIIII) {
        final ObjectSortedSet<Int2IntMap.Entry> lllllllllllllIlIllIlIlIlIIIIIIIl = lllllllllllllIlIllIlIlIlIIIIIIII.int2IntEntrySet();
        return (lllllllllllllIlIllIlIlIlIIIIIIIl instanceof Int2IntSortedMap.FastSortedEntrySet) ? ((Int2IntSortedMap.FastSortedEntrySet)lllllllllllllIlIllIlIlIlIIIIIIIl).fastIterator() : lllllllllllllIlIllIlIlIlIIIIIIIl.iterator();
    }
    
    static {
        EMPTY_MAP = new EmptySortedMap();
    }
    
    public static Int2IntSortedMap singleton(final Integer lllllllllllllIlIllIlIlIIlllIllll, final Integer lllllllllllllIlIllIlIlIIlllIlIll, final IntComparator lllllllllllllIlIllIlIlIIlllIlIlI) {
        return new Singleton(lllllllllllllIlIllIlIlIIlllIllll, lllllllllllllIlIllIlIlIIlllIlIll, lllllllllllllIlIllIlIlIIlllIlIlI);
    }
    
    public static Int2IntSortedMap synchronize(final Int2IntSortedMap lllllllllllllIlIllIlIlIIllIlIIll, final Object lllllllllllllIlIllIlIlIIllIlIIlI) {
        return (Int2IntSortedMap)new Int2IntSortedMaps.SynchronizedSortedMap(lllllllllllllIlIllIlIlIIllIlIIll, lllllllllllllIlIllIlIlIIllIlIIlI);
    }
    
    public static Comparator<? super Map.Entry<Integer, ?>> entryComparator(final IntComparator lllllllllllllIlIllIlIlIlIIIIIllI) {
        return (lllllllllllllIlIllIlIlIIllIIIlll, lllllllllllllIlIllIlIlIIllIIIllI) -> lllllllllllllIlIllIlIlIlIIIIIllI.compare((int)lllllllllllllIlIllIlIlIIllIIIlll.getKey(), (int)lllllllllllllIlIllIlIlIIllIIIllI.getKey());
    }
    
    public static Int2IntSortedMap singleton(final Integer lllllllllllllIlIllIlIlIIllllIlII, final Integer lllllllllllllIlIllIlIlIIllllIlIl) {
        return new Singleton(lllllllllllllIlIllIlIlIIllllIlII, lllllllllllllIlIllIlIlIIllllIlIl);
    }
    
    public static Int2IntSortedMap unmodifiable(final Int2IntSortedMap lllllllllllllIlIllIlIlIIllIlIIII) {
        return (Int2IntSortedMap)new Int2IntSortedMaps.UnmodifiableSortedMap(lllllllllllllIlIllIlIlIIllIlIIII);
    }
    
    public static Int2IntSortedMap singleton(final int lllllllllllllIlIllIlIlIIlllIIlll, final int lllllllllllllIlIllIlIlIIlllIIlII) {
        return new Singleton(lllllllllllllIlIllIlIlIIlllIIlll, lllllllllllllIlIllIlIlIIlllIIlII);
    }
    
    public static Int2IntSortedMap synchronize(final Int2IntSortedMap lllllllllllllIlIllIlIlIIllIllIIl) {
        return (Int2IntSortedMap)new Int2IntSortedMaps.SynchronizedSortedMap(lllllllllllllIlIllIlIlIIllIllIIl);
    }
    
    public static Int2IntSortedMap singleton(final int lllllllllllllIlIllIlIlIIllIlllIl, final int lllllllllllllIlIllIlIlIIllIlllll, final IntComparator lllllllllllllIlIllIlIlIIllIllIll) {
        return new Singleton(lllllllllllllIlIllIlIlIIllIlllIl, lllllllllllllIlIllIlIlIIllIlllll, lllllllllllllIlIllIlIlIIllIllIll);
    }
    
    private Int2IntSortedMaps() {
    }
    
    public static ObjectBidirectionalIterable<Int2IntMap.Entry> fastIterable(final Int2IntSortedMap lllllllllllllIlIllIlIlIIlllllIlI) {
        final ObjectSortedSet<Int2IntMap.Entry> lllllllllllllIlIllIlIlIIlllllIll = lllllllllllllIlIllIlIlIIlllllIlI.int2IntEntrySet();
        ObjectBidirectionalIterable<Int2IntMap.Entry> objectBidirectionalIterable;
        if (lllllllllllllIlIllIlIlIIlllllIll instanceof Int2IntSortedMap.FastSortedEntrySet) {
            final Int2IntSortedMap.FastSortedEntrySet set = (Int2IntSortedMap.FastSortedEntrySet)lllllllllllllIlIllIlIlIIlllllIll;
            Objects.requireNonNull(set);
            objectBidirectionalIterable = set::fastIterator;
        }
        else {
            objectBidirectionalIterable = lllllllllllllIlIllIlIlIIlllllIll;
        }
        return objectBidirectionalIterable;
    }
    
    public static class EmptySortedMap extends Int2IntMaps.EmptyMap implements Serializable, Int2IntSortedMap, Cloneable
    {
        @Override
        public Int2IntSortedMap headMap(final int llllllllllllllIlllIIIlIlIllllIIl) {
            return Int2IntSortedMaps.EMPTY_MAP;
        }
        
        protected EmptySortedMap() {
        }
        
        @Deprecated
        @Override
        public Integer lastKey() {
            return this.lastIntKey();
        }
        
        @Override
        public int lastIntKey() {
            throw new NoSuchElementException();
        }
        
        @Deprecated
        @Override
        public Integer firstKey() {
            return this.firstIntKey();
        }
        
        @Override
        public int firstIntKey() {
            throw new NoSuchElementException();
        }
        
        @Override
        public Int2IntSortedMap subMap(final int llllllllllllllIlllIIIlIlIlllllII, final int llllllllllllllIlllIIIlIlIllllIll) {
            return Int2IntSortedMaps.EMPTY_MAP;
        }
        
        @Deprecated
        @Override
        public Int2IntSortedMap headMap(final Integer llllllllllllllIlllIIIlIlIllIllll) {
            return this.headMap((int)llllllllllllllIlllIIIlIlIllIllll);
        }
        
        @Deprecated
        @Override
        public ObjectSortedSet<Map.Entry<Integer, Integer>> entrySet() {
            return (ObjectSortedSet<Map.Entry<Integer, Integer>>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Deprecated
        @Override
        public Int2IntSortedMap subMap(final Integer llllllllllllllIlllIIIlIlIllIIIIl, final Integer llllllllllllllIlllIIIlIlIllIIIII) {
            return this.subMap((int)llllllllllllllIlllIIIlIlIllIIIIl, (int)llllllllllllllIlllIIIlIlIllIIIII);
        }
        
        @Override
        public IntComparator comparator() {
            return null;
        }
        
        @Override
        public ObjectSortedSet<Int2IntMap.Entry> int2IntEntrySet() {
            return (ObjectSortedSet<Int2IntMap.Entry>)ObjectSortedSets.EMPTY_SET;
        }
        
        @Deprecated
        @Override
        public Int2IntSortedMap tailMap(final Integer llllllllllllllIlllIIIlIlIllIlIIl) {
            return this.tailMap((int)llllllllllllllIlllIIIlIlIllIlIIl);
        }
        
        @Override
        public IntSortedSet keySet() {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Override
        public Int2IntSortedMap tailMap(final int llllllllllllllIlllIIIlIlIlllIlll) {
            return Int2IntSortedMaps.EMPTY_MAP;
        }
    }
    
    public static class Singleton extends Int2IntMaps.Singleton implements Int2IntSortedMap, Serializable, Cloneable
    {
        protected final /* synthetic */ IntComparator comparator;
        
        @Override
        public Int2IntSortedMap headMap(final int llllllllllllllIllIllllIlIIlIlIlI) {
            if (this.compare(this.key, llllllllllllllIllIllllIlIIlIlIlI) < 0) {
                return this;
            }
            return Int2IntSortedMaps.EMPTY_MAP;
        }
        
        @Deprecated
        @Override
        public Integer firstKey() {
            return this.firstIntKey();
        }
        
        @Override
        public Int2IntSortedMap tailMap(final int llllllllllllllIllIllllIlIIlIIlII) {
            if (this.compare(llllllllllllllIllIllllIlIIlIIlII, this.key) <= 0) {
                return this;
            }
            return Int2IntSortedMaps.EMPTY_MAP;
        }
        
        @Override
        public ObjectSortedSet<Int2IntMap.Entry> int2IntEntrySet() {
            if (this.entries == null) {
                this.entries = (ObjectSet<Int2IntMap.Entry>)ObjectSortedSets.singleton(new AbstractInt2IntMap.BasicEntry(this.key, this.value), Int2IntSortedMaps.entryComparator(this.comparator));
            }
            return (ObjectSortedSet<Int2IntMap.Entry>)(ObjectSortedSet)this.entries;
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
        public Int2IntSortedMap headMap(final Integer llllllllllllllIllIllllIlIIIlIllI) {
            return this.headMap((int)llllllllllllllIllIllllIlIIIlIllI);
        }
        
        protected Singleton(final int llllllllllllllIllIllllIlIlIIllIl, final int llllllllllllllIllIllllIlIlIIllll) {
            this(llllllllllllllIllIllllIlIlIIllIl, llllllllllllllIllIllllIlIlIIllll, null);
        }
        
        @Override
        public int firstIntKey() {
            return this.key;
        }
        
        @Override
        public IntSortedSet keySet() {
            if (this.keys == null) {
                this.keys = IntSortedSets.singleton(this.key, this.comparator);
            }
            return (IntSortedSet)this.keys;
        }
        
        @Deprecated
        @Override
        public ObjectSortedSet<Map.Entry<Integer, Integer>> entrySet() {
            return (ObjectSortedSet<Map.Entry<Integer, Integer>>)this.int2IntEntrySet();
        }
        
        @Override
        public Int2IntSortedMap subMap(final int llllllllllllllIllIllllIlIIlIllll, final int llllllllllllllIllIllllIlIIllIIIl) {
            if (this.compare(llllllllllllllIllIllllIlIIlIllll, this.key) <= 0 && this.compare(this.key, llllllllllllllIllIllllIlIIllIIIl) < 0) {
                return this;
            }
            return Int2IntSortedMaps.EMPTY_MAP;
        }
        
        protected Singleton(final int llllllllllllllIllIllllIlIlIlIlll, final int llllllllllllllIllIllllIlIlIllIlI, final IntComparator llllllllllllllIllIllllIlIlIllIIl) {
            super(llllllllllllllIllIllllIlIlIlIlll, llllllllllllllIllIllllIlIlIllIlI);
            this.comparator = llllllllllllllIllIllllIlIlIllIIl;
        }
        
        @Deprecated
        @Override
        public Int2IntSortedMap tailMap(final Integer llllllllllllllIllIllllIlIIIlIIlI) {
            return this.tailMap((int)llllllllllllllIllIllllIlIIIlIIlI);
        }
        
        final int compare(final int llllllllllllllIllIllllIlIlIIIlll, final int llllllllllllllIllIllllIlIlIIIIll) {
            return (this.comparator == null) ? Integer.compare(llllllllllllllIllIllllIlIlIIIlll, llllllllllllllIllIllllIlIlIIIIll) : this.comparator.compare(llllllllllllllIllIllllIlIlIIIlll, llllllllllllllIllIllllIlIlIIIIll);
        }
        
        @Deprecated
        @Override
        public Int2IntSortedMap subMap(final Integer llllllllllllllIllIllllIlIIIIlIll, final Integer llllllllllllllIllIllllIlIIIIlIlI) {
            return this.subMap((int)llllllllllllllIllIllllIlIIIIlIll, (int)llllllllllllllIllIllllIlIIIIlIlI);
        }
    }
}
