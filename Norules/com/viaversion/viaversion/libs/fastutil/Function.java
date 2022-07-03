package com.viaversion.viaversion.libs.fastutil;

@FunctionalInterface
public interface Function<K, V> extends java.util.function.Function<K, V>
{
    default V put(final K lllllllllllllIllIIIIlllIllIIllIl, final V lllllllllllllIllIIIIlllIllIIllII) {
        throw new UnsupportedOperationException();
    }
    
    default int size() {
        return -1;
    }
    
    default void clear() {
        throw new UnsupportedOperationException();
    }
    
    V get(final Object p0);
    
    default boolean containsKey(final Object lllllllllllllIllIIIIlllIllIIlIlI) {
        return true;
    }
    
    default V apply(final K lllllllllllllIllIIIIlllIllIIllll) {
        return this.get(lllllllllllllIllIIIIlllIllIIllll);
    }
    
    default V remove(final Object lllllllllllllIllIIIIlllIllIIlIII) {
        throw new UnsupportedOperationException();
    }
}
