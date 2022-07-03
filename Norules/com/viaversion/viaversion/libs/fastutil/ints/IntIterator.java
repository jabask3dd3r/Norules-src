package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.function.*;
import java.util.*;

public interface IntIterator extends PrimitiveIterator.OfInt
{
    default int skip(final int llllllllllllllIllIIIIIIIIlIlllII) {
        if (llllllllllllllIllIIIIIIIIlIlllII < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Argument must be nonnegative: ").append(llllllllllllllIllIIIIIIIIlIlllII)));
        }
        int llllllllllllllIllIIIIIIIIlIllllI = llllllllllllllIllIIIIIIIIlIlllII;
        while (llllllllllllllIllIIIIIIIIlIllllI-- != 0 && this.hasNext()) {
            this.nextInt();
        }
        return llllllllllllllIllIIIIIIIIlIlllII - llllllllllllllIllIIIIIIIIlIllllI - 1;
    }
    
    @Deprecated
    default void forEachRemaining(final Consumer<? super Integer> llllllllllllllIllIIIIIIIIllIlllI) {
        Objects.requireNonNull(llllllllllllllIllIIIIIIIIllIlllI);
        this.forEachRemaining(llllllllllllllIllIIIIIIIIllIlllI::accept);
    }
    
    @Deprecated
    default Integer next() {
        return this.nextInt();
    }
    
    int nextInt();
}
