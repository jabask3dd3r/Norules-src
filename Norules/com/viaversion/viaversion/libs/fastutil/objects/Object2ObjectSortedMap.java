package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public interface Object2ObjectSortedMap<K, V> extends Object2ObjectMap<K, V>, SortedMap<K, V>
{
    Comparator<? super K> comparator();
    
    ObjectSortedSet<K> keySet();
    
    ObjectSortedSet<Object2ObjectMap.Entry<K, V>> object2ObjectEntrySet();
    
    Object2ObjectSortedMap<K, V> headMap(final K p0);
    
    default ObjectSortedSet<Map.Entry<K, V>> entrySet() {
        return (ObjectSortedSet<Map.Entry<K, V>>)this.object2ObjectEntrySet();
    }
    
    Object2ObjectSortedMap<K, V> subMap(final K p0, final K p1);
    
    ObjectCollection<V> values();
    
    Object2ObjectSortedMap<K, V> tailMap(final K p0);
    
    public interface FastSortedEntrySet<K, V> extends ObjectSortedSet<Object2ObjectMap.Entry<K, V>>, FastEntrySet<K, V>
    {
        ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> fastIterator();
        
        ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> fastIterator(final Object2ObjectMap.Entry<K, V> p0);
    }
}
