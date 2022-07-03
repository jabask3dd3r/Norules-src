package com.viaversion.viaversion.libs.kyori.adventure.key;

import org.jetbrains.annotations.*;
import java.util.*;

public interface KeyedValue<T> extends Keyed
{
    @NotNull
    default <T> KeyedValue<T> of(@NotNull final Key llllllllllllllIlIIIllIllIllllIll, @NotNull final T llllllllllllllIlIIIllIllIlllllII) {
        return new KeyedValueImpl<T>(llllllllllllllIlIIIllIllIllllIll, Objects.requireNonNull(llllllllllllllIlIIIllIllIlllllII, "value"));
    }
    
    @NotNull
    T value();
}
