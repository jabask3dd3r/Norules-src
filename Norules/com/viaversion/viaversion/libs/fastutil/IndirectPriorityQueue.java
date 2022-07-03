package com.viaversion.viaversion.libs.fastutil;

import java.util.*;

public interface IndirectPriorityQueue<K>
{
    default int last() {
        throw new UnsupportedOperationException();
    }
    
    default boolean isEmpty() {
        return this.size() == 0;
    }
    
    void enqueue(final int p0);
    
    int dequeue();
    
    int first();
    
    default void allChanged() {
        throw new UnsupportedOperationException();
    }
    
    default void changed() {
        this.changed(this.first());
    }
    
    void clear();
    
    default boolean contains(final int lllllllllllllIlIIlIIIIlIIlIlllll) {
        throw new UnsupportedOperationException();
    }
    
    int size();
    
    default int front(final int[] lllllllllllllIlIIlIIIIlIIlIllIll) {
        throw new UnsupportedOperationException();
    }
    
    default void changed(final int lllllllllllllIlIIlIIIIlIIllIIIlI) {
        throw new UnsupportedOperationException();
    }
    
    Comparator<? super K> comparator();
    
    default boolean remove(final int lllllllllllllIlIIlIIIIlIIlIlllIl) {
        throw new UnsupportedOperationException();
    }
}
