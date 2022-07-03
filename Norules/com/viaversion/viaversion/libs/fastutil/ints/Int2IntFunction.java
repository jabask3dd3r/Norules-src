package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.util.function.*;

@FunctionalInterface
public interface Int2IntFunction extends Function<Integer, Integer>, IntUnaryOperator
{
    @Deprecated
    default boolean containsKey(final Object lllllllllllllllllIIIlIlIIllllIll) {
        return lllllllllllllllllIIIlIlIIllllIll != null && this.containsKey((int)lllllllllllllllllIIIlIlIIllllIll);
    }
    
    @Deprecated
    default Integer get(final Object lllllllllllllllllIIIlIlIlIIlIIlI) {
        if (lllllllllllllllllIIIlIlIlIIlIIlI == null) {
            return null;
        }
        final int lllllllllllllllllIIIlIlIlIIlIIIl = (int)lllllllllllllllllIIIlIlIlIIlIIlI;
        final int lllllllllllllllllIIIlIlIlIIlIIII = this.get(lllllllllllllllllIIIlIlIlIIlIIIl);
        return (lllllllllllllllllIIIlIlIlIIlIIII != this.defaultReturnValue() || this.containsKey(lllllllllllllllllIIIlIlIlIIlIIIl)) ? Integer.valueOf(lllllllllllllllllIIIlIlIlIIlIIII) : null;
    }
    
    default boolean containsKey(final int lllllllllllllllllIIIlIlIlIIIIIIl) {
        return true;
    }
    
    default int applyAsInt(final int lllllllllllllllllIIIlIlIlIlIllll) {
        return this.get(lllllllllllllllllIIIlIlIlIlIllll);
    }
    
    default int put(final int lllllllllllllllllIIIlIlIlIlIllIl, final int lllllllllllllllllIIIlIlIlIlIllII) {
        throw new UnsupportedOperationException();
    }
    
    default int defaultReturnValue() {
        return 0;
    }
    
    default int remove(final int lllllllllllllllllIIIlIlIlIlIlIlI) {
        throw new UnsupportedOperationException();
    }
    
    default void defaultReturnValue(final int lllllllllllllllllIIIlIlIIllllIIl) {
        throw new UnsupportedOperationException();
    }
    
    int get(final int p0);
    
    @Deprecated
    default Integer put(final Integer lllllllllllllllllIIIlIlIlIIlllII, final Integer lllllllllllllllllIIIlIlIlIlIIIIl) {
        final int lllllllllllllllllIIIlIlIlIlIIIII = lllllllllllllllllIIIlIlIlIIlllII;
        final boolean lllllllllllllllllIIIlIlIlIIlllll = this.containsKey(lllllllllllllllllIIIlIlIlIlIIIII);
        final int lllllllllllllllllIIIlIlIlIIllllI = this.put(lllllllllllllllllIIIlIlIlIlIIIII, (int)lllllllllllllllllIIIlIlIlIlIIIIl);
        return lllllllllllllllllIIIlIlIlIIlllll ? Integer.valueOf(lllllllllllllllllIIIlIlIlIIllllI) : null;
    }
    
    @Deprecated
    default Integer remove(final Object lllllllllllllllllIIIlIlIlIIIIlII) {
        if (lllllllllllllllllIIIlIlIlIIIIlII == null) {
            return null;
        }
        final int lllllllllllllllllIIIlIlIlIIIIllI = (int)lllllllllllllllllIIIlIlIlIIIIlII;
        return this.containsKey(lllllllllllllllllIIIlIlIlIIIIllI) ? Integer.valueOf(this.remove(lllllllllllllllllIIIlIlIlIIIIllI)) : null;
    }
}
