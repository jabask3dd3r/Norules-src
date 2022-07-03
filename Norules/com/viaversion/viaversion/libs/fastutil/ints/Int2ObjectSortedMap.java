package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public interface Int2ObjectSortedMap<V> extends Int2ObjectMap<V>, SortedMap<Integer, V>
{
    ObjectSortedSet<Int2ObjectMap.Entry<V>> int2ObjectEntrySet();
    
    IntSortedSet keySet();
    
    ObjectCollection<V> values();
    
    @Deprecated
    default Integer lastKey() {
        return this.lastIntKey();
    }
    
    Int2ObjectSortedMap<V> headMap(final int p0);
    
    @Deprecated
    default Int2ObjectSortedMap<V> tailMap(final Integer llllllllllllllIIIIIllIllIllIIlII) {
        return this.tailMap((int)llllllllllllllIIIIIllIllIllIIlII);
    }
    
    @Deprecated
    default Integer firstKey() {
        return this.firstIntKey();
    }
    
    @Deprecated
    default Int2ObjectSortedMap<V> subMap(final Integer llllllllllllllIIIIIllIllIlllIlII, final Integer llllllllllllllIIIIIllIllIlllIIII) {
        return this.subMap((int)llllllllllllllIIIIIllIllIlllIlII, (int)llllllllllllllIIIIIllIllIlllIIII);
    }
    
    IntComparator comparator();
    
    int firstIntKey();
    
    Int2ObjectSortedMap<V> tailMap(final int p0);
    
    @Deprecated
    default Int2ObjectSortedMap<V> headMap(final Integer llllllllllllllIIIIIllIllIllIllII) {
        return this.headMap((int)llllllllllllllIIIIIllIllIllIllII);
    }
    
    @Deprecated
    default ObjectSortedSet<Map.Entry<Integer, V>> entrySet() {
        return (ObjectSortedSet<Map.Entry<Integer, V>>)this.int2ObjectEntrySet();
    }
    
    Int2ObjectSortedMap<V> subMap(final int p0, final int p1);
    
    int lastIntKey();
    
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Int2ObjectMap.Entry<V>>, FastEntrySet<V>
    {
        ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> fastIterator(final Int2ObjectMap.Entry<V> p0);
        
        ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> fastIterator();
    }
}
