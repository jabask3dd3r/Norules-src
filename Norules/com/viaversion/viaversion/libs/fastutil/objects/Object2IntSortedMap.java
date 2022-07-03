package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public interface Object2IntSortedMap<K> extends Object2IntMap<K>, SortedMap<K, Integer>
{
    ObjectSortedSet<Object2IntMap.Entry<K>> object2IntEntrySet();
    
    ObjectSortedSet<K> keySet();
    
    Object2IntSortedMap<K> subMap(final K p0, final K p1);
    
    @Deprecated
    default ObjectSortedSet<Map.Entry<K, Integer>> entrySet() {
        return (ObjectSortedSet<Map.Entry<K, Integer>>)this.object2IntEntrySet();
    }
    
    Comparator<? super K> comparator();
    
    IntCollection values();
    
    Object2IntSortedMap<K> headMap(final K p0);
    
    Object2IntSortedMap<K> tailMap(final K p0);
    
    public interface FastSortedEntrySet<K> extends ObjectSortedSet<Object2IntMap.Entry<K>>, FastEntrySet<K>
    {
        ObjectBidirectionalIterator<Object2IntMap.Entry<K>> fastIterator(final Object2IntMap.Entry<K> p0);
        
        ObjectBidirectionalIterator<Object2IntMap.Entry<K>> fastIterator();
    }
}
