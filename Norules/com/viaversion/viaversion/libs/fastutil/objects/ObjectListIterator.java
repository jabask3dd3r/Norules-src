package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public interface ObjectListIterator<K> extends ObjectBidirectionalIterator<K>, ListIterator<K>
{
    default void remove() {
        throw new UnsupportedOperationException();
    }
    
    default void set(final K lllllllllllllIIllIlllllIlIIllIIl) {
        throw new UnsupportedOperationException();
    }
    
    default void add(final K lllllllllllllIIllIlllllIlIIlIlll) {
        throw new UnsupportedOperationException();
    }
}
