package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.util.function.*;

public interface IntIterable extends Iterable<Integer>
{
    @Deprecated
    default void forEach(final Consumer<? super Integer> llllllllllllllllIIIIlIllllIlIlII) {
        Objects.requireNonNull(llllllllllllllllIIIIlIllllIlIlII);
        this.forEach(llllllllllllllllIIIIlIllllIlIlII::accept);
    }
    
    IntIterator iterator();
    
    default void forEach(final IntConsumer llllllllllllllllIIIIlIllllIllIIl) {
        Objects.requireNonNull(llllllllllllllllIIIIlIllllIllIIl);
        final IntIterator llllllllllllllllIIIIlIllllIlllIl = this.iterator();
        while (llllllllllllllllIIIIlIllllIlllIl.hasNext()) {
            llllllllllllllllIIIIlIllllIllIIl.accept(llllllllllllllllIIIIlIllllIlllIl.nextInt());
        }
    }
}
