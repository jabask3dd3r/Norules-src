package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public interface ObjectSortedSet<K> extends ObjectSet<K>, SortedSet<K>, ObjectBidirectionalIterable<K>
{
    ObjectSortedSet<K> headSet(final K p0);
    
    ObjectBidirectionalIterator<K> iterator(final K p0);
    
    ObjectSortedSet<K> tailSet(final K p0);
    
    ObjectBidirectionalIterator<K> iterator();
    
    ObjectSortedSet<K> subSet(final K p0, final K p1);
}
