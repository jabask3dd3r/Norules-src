package com.viaversion.viaversion.libs.kyori.adventure.pointer;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.function.*;

public interface Pointered
{
    @Nullable
    @Contract("_, null -> null; _, !null -> !null")
    default <T> T getOrDefault(@NotNull final Pointer<T> lllllllllllllIlIIIIIllIIlIllIllI, @Nullable final T lllllllllllllIlIIIIIllIIlIllIlIl) {
        return this.pointers().getOrDefault(lllllllllllllIlIIIIIllIIlIllIllI, lllllllllllllIlIIIIIllIIlIllIlIl);
    }
    
    @NotNull
    default <T> Optional<T> get(@NotNull final Pointer<T> lllllllllllllIlIIIIIllIIlIlllllI) {
        return this.pointers().get(lllllllllllllIlIIIIIllIIlIlllllI);
    }
    
    @NotNull
    default Pointers pointers() {
        return Pointers.empty();
    }
    
    default <T> T getOrDefaultFrom(@NotNull final Pointer<T> lllllllllllllIlIIIIIllIIlIlIlIlI, @NotNull final Supplier<? extends T> lllllllllllllIlIIIIIllIIlIlIlIll) {
        return this.pointers().getOrDefaultFrom(lllllllllllllIlIIIIIllIIlIlIlIlI, lllllllllllllIlIIIIIllIIlIlIlIll);
    }
}
