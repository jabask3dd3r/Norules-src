package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public interface Int2IntSortedMap extends Int2IntMap, SortedMap<Integer, Integer>
{
    @Deprecated
    default Integer lastKey() {
        return this.lastIntKey();
    }
    
    Int2IntSortedMap headMap(final int p0);
    
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, Integer>> entrySet() {
        return (ObjectSortedSet<Map.Entry<Integer, Integer>>)this.int2IntEntrySet();
    }
    
    ObjectSortedSet<Int2IntMap.Entry> int2IntEntrySet();
    
    @Deprecated
    default Int2IntSortedMap tailMap(final Integer llllllllllllllIIIlIIIIIIIIlIlIll) {
        return this.tailMap((int)llllllllllllllIIIlIIIIIIIIlIlIll);
    }
    
    @Deprecated
    default Int2IntSortedMap headMap(final Integer llllllllllllllIIIlIIIIIIIIllIIll) {
        return this.headMap((int)llllllllllllllIIIlIIIIIIIIllIIll);
    }
    
    @Deprecated
    default Integer firstKey() {
        return this.firstIntKey();
    }
    
    int lastIntKey();
    
    IntSortedSet keySet();
    
    @Deprecated
    default Int2IntSortedMap subMap(final Integer llllllllllllllIIIlIIIIIIIIlllIll, final Integer llllllllllllllIIIlIIIIIIIIllIlll) {
        return this.subMap((int)llllllllllllllIIIlIIIIIIIIlllIll, (int)llllllllllllllIIIlIIIIIIIIllIlll);
    }
    
    IntComparator comparator();
    
    IntCollection values();
    
    int firstIntKey();
    
    Int2IntSortedMap tailMap(final int p0);
    
    Int2IntSortedMap subMap(final int p0, final int p1);
    
    public interface FastSortedEntrySet extends ObjectSortedSet<Int2IntMap.Entry>, FastEntrySet
    {
        ObjectBidirectionalIterator<Int2IntMap.Entry> fastIterator(final Int2IntMap.Entry p0);
        
        ObjectBidirectionalIterator<Int2IntMap.Entry> fastIterator();
    }
}
