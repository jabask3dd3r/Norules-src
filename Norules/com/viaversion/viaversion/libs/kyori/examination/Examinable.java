package com.viaversion.viaversion.libs.kyori.examination;

import java.util.stream.*;

public interface Examinable
{
    default String examinableName() {
        return this.getClass().getSimpleName();
    }
    
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.empty();
    }
    
    default <R> R examine(final Examiner<R> lllllllllllllllllIlIlIllIlIlIIlI) {
        return lllllllllllllllllIlIlIllIlIlIIlI.examine(this);
    }
}
