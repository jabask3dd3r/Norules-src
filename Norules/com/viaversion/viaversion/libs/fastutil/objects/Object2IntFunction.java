package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;
import java.util.function.*;

@FunctionalInterface
public interface Object2IntFunction<K> extends Function<K, Integer>, ToIntFunction<K>
{
    @Deprecated
    default Integer put(final K llllllllllllIlllllIIIIlIllIIIlII, final Integer llllllllllllIlllllIIIIlIllIIlIIl) {
        final K llllllllllllIlllllIIIIlIllIIlIII = llllllllllllIlllllIIIIlIllIIIlII;
        final boolean llllllllllllIlllllIIIIlIllIIIlll = this.containsKey(llllllllllllIlllllIIIIlIllIIlIII);
        final int llllllllllllIlllllIIIIlIllIIIllI = this.put(llllllllllllIlllllIIIIlIllIIlIII, (int)llllllllllllIlllllIIIIlIllIIlIIl);
        return llllllllllllIlllllIIIIlIllIIIlll ? Integer.valueOf(llllllllllllIlllllIIIIlIllIIIllI) : null;
    }
    
    default void defaultReturnValue(final int llllllllllllIlllllIIIIlIlIlIlIIl) {
        throw new UnsupportedOperationException();
    }
    
    int getInt(final Object p0);
    
    default int removeInt(final Object llllllllllllIlllllIIIIlIllIlIIlI) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    default Integer get(final Object llllllllllllIlllllIIIIlIlIllIllI) {
        final Object llllllllllllIlllllIIIIlIlIlllIIl = llllllllllllIlllllIIIIlIlIllIllI;
        final int llllllllllllIlllllIIIIlIlIlllIII = this.getInt(llllllllllllIlllllIIIIlIlIlllIIl);
        return (llllllllllllIlllllIIIIlIlIlllIII != this.defaultReturnValue() || this.containsKey(llllllllllllIlllllIIIIlIlIlllIIl)) ? Integer.valueOf(llllllllllllIlllllIIIIlIlIlllIII) : null;
    }
    
    default int applyAsInt(final K llllllllllllIlllllIIIIlIllIlIlll) {
        return this.getInt(llllllllllllIlllllIIIIlIllIlIlll);
    }
    
    @Deprecated
    default Integer remove(final Object llllllllllllIlllllIIIIlIlIlIllII) {
        final Object llllllllllllIlllllIIIIlIlIlIlllI = llllllllllllIlllllIIIIlIlIlIllII;
        return this.containsKey(llllllllllllIlllllIIIIlIlIlIlllI) ? Integer.valueOf(this.removeInt(llllllllllllIlllllIIIIlIlIlIlllI)) : null;
    }
    
    default int put(final K llllllllllllIlllllIIIIlIllIlIlIl, final int llllllllllllIlllllIIIIlIllIlIlII) {
        throw new UnsupportedOperationException();
    }
    
    default int defaultReturnValue() {
        return 0;
    }
}
