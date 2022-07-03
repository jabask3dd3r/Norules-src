package com.viaversion.viaversion.libs.fastutil;

import java.util.*;

public interface PriorityQueue<K>
{
    void clear();
    
    Comparator<? super K> comparator();
    
    K first();
    
    K dequeue();
    
    int size();
    
    default void changed() {
        throw new UnsupportedOperationException();
    }
    
    void enqueue(final K p0);
    
    default boolean isEmpty() {
        return this.size() == 0;
    }
    
    default K last() {
        throw new UnsupportedOperationException();
    }
}
