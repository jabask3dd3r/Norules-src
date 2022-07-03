package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.util.function.*;

@FunctionalInterface
public interface Int2ObjectFunction<V> extends Function<Integer, V>, IntFunction<V>
{
    @Deprecated
    default V get(final Object llllllllllllllIlIIIIllIllIIIlIII) {
        if (llllllllllllllIlIIIIllIllIIIlIII == null) {
            return null;
        }
        final int llllllllllllllIlIIIIllIllIIIlIll = (int)llllllllllllllIlIIIIllIllIIIlIII;
        final V llllllllllllllIlIIIIllIllIIIlIlI = this.get(llllllllllllllIlIIIIllIllIIIlIll);
        return (llllllllllllllIlIIIIllIllIIIlIlI != this.defaultReturnValue() || this.containsKey(llllllllllllllIlIIIIllIllIIIlIll)) ? llllllllllllllIlIIIIllIllIIIlIlI : null;
    }
    
    default V put(final int llllllllllllllIlIIIIllIllIlIIlll, final V llllllllllllllIlIIIIllIllIlIIllI) {
        throw new UnsupportedOperationException();
    }
    
    default V defaultReturnValue() {
        return null;
    }
    
    @Deprecated
    default V remove(final Object llllllllllllllIlIIIIllIllIIIIIIl) {
        if (llllllllllllllIlIIIIllIllIIIIIIl == null) {
            return null;
        }
        final int llllllllllllllIlIIIIllIllIIIIIII = (int)llllllllllllllIlIIIIllIllIIIIIIl;
        return this.containsKey(llllllllllllllIlIIIIllIllIIIIIII) ? this.remove(llllllllllllllIlIIIIllIllIIIIIII) : null;
    }
    
    @Deprecated
    default V put(final Integer llllllllllllllIlIIIIllIllIIlllII, final V llllllllllllllIlIIIIllIllIIllIll) {
        final int llllllllllllllIlIIIIllIllIIllIlI = llllllllllllllIlIIIIllIllIIlllII;
        final boolean llllllllllllllIlIIIIllIllIIllIIl = this.containsKey(llllllllllllllIlIIIIllIllIIllIlI);
        final V llllllllllllllIlIIIIllIllIIllIII = this.put(llllllllllllllIlIIIIllIllIIllIlI, llllllllllllllIlIIIIllIllIIllIll);
        return llllllllllllllIlIIIIllIllIIllIIl ? llllllllllllllIlIIIIllIllIIllIII : null;
    }
    
    default V apply(final int llllllllllllllIlIIIIllIllIlIlIIl) {
        return this.get(llllllllllllllIlIIIIllIllIlIlIIl);
    }
    
    default V remove(final int llllllllllllllIlIIIIllIllIlIIlII) {
        throw new UnsupportedOperationException();
    }
    
    V get(final int p0);
    
    default boolean containsKey(final int llllllllllllllIlIIIIllIlIllllIll) {
        return true;
    }
    
    default void defaultReturnValue(final V llllllllllllllIlIIIIllIlIlllIIll) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    default boolean containsKey(final Object llllllllllllllIlIIIIllIlIlllIlll) {
        return llllllllllllllIlIIIIllIlIlllIlll != null && this.containsKey((int)llllllllllllllIlIIIIllIlIlllIlll);
    }
}
