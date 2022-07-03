package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;

@FunctionalInterface
public interface Object2ObjectFunction<K, V> extends Function<K, V>
{
    default V put(final K llllllllllllIlllllIlIlIIllIlIIlI, final V llllllllllllIlllllIlIlIIllIlIIIl) {
        throw new UnsupportedOperationException();
    }
    
    V get(final Object p0);
    
    default V defaultReturnValue() {
        return null;
    }
    
    default V remove(final Object llllllllllllIlllllIlIlIIllIIllll) {
        throw new UnsupportedOperationException();
    }
    
    default void defaultReturnValue(final V llllllllllllIlllllIlIlIIllIIllIl) {
        throw new UnsupportedOperationException();
    }
}
