package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.function.*;
import java.util.*;

@FunctionalInterface
public interface IntConsumer extends Consumer<Integer>, java.util.function.IntConsumer
{
    @Deprecated
    default Consumer<Integer> andThen(final Consumer<? super Integer> lllllllllllllIlllIlIlIlIIIIllIIl) {
        return super.andThen(lllllllllllllIlllIlIlIlIIIIllIIl);
    }
    
    default IntConsumer andThen(final java.util.function.IntConsumer lllllllllllllIlllIlIlIlIIIlIIIIl) {
        Objects.requireNonNull(lllllllllllllIlllIlIlIlIIIlIIIIl);
        return lllllllllllllIlllIlIlIlIIIIIlIIl -> {
            this.accept(lllllllllllllIlllIlIlIlIIIIIlIIl);
            lllllllllllllIlllIlIlIlIIIlIIIIl.accept(lllllllllllllIlllIlIlIlIIIIIlIIl);
        };
    }
    
    @Deprecated
    default void accept(final Integer lllllllllllllIlllIlIlIlIIIlIIlIl) {
        this.accept(lllllllllllllIlllIlIlIlIIIlIIlIl);
    }
}
