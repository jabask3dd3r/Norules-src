package com.viaversion.viaversion.libs.fastutil;

public interface BigListIterator<K> extends BidirectionalIterator<K>
{
    long nextIndex();
    
    long previousIndex();
    
    default void add(final K lllllllllllllIlIllIIIlIIllIIlllI) {
        throw new UnsupportedOperationException();
    }
    
    default void set(final K lllllllllllllIlIllIIIlIIllIlIIII) {
        throw new UnsupportedOperationException();
    }
}
