package com.viaversion.viaversion.libs.kyori.adventure.pointer;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.util.function.*;
import org.jetbrains.annotations.*;
import java.util.*;

public interface Pointers extends Buildable<Pointers, Builder>
{
    default <T> T getOrDefaultFrom(@NotNull final Pointer<T> lllllllllllllIIllIIllIllIIlllllI, @NotNull final Supplier<? extends T> lllllllllllllIIllIIllIllIIllllll) {
        return this.get(lllllllllllllIIllIIllIllIIlllllI).orElseGet(lllllllllllllIIllIIllIllIIllllll);
    }
    
    @Contract(pure = true)
    @NotNull
    default Builder builder() {
        return new PointersImpl.BuilderImpl();
    }
    
    @Nullable
    @Contract("_, !null -> !null; _, null -> null")
    default <T> T getOrDefault(@NotNull final Pointer<T> lllllllllllllIIllIIllIllIlIIlIIl, @Nullable final T lllllllllllllIIllIIllIllIlIIlIlI) {
        return this.get(lllllllllllllIIllIIllIllIlIIlIIl).orElse(lllllllllllllIIllIIllIllIlIIlIlI);
    }
    
    @NotNull
     <T> Optional<T> get(@NotNull final Pointer<T> lllllllllllllIIllIIllIllIlIIlllI);
    
     <T> boolean supports(@NotNull final Pointer<T> lllllllllllllIIllIIllIllIIllIlll);
    
    @Contract(pure = true)
    @NotNull
    default Pointers empty() {
        return PointersImpl.EMPTY;
    }
    
    public interface Builder extends Buildable.Builder<Pointers>
    {
        @Contract("_, _ -> this")
        @NotNull
         <T> Builder withDynamic(@NotNull final Pointer<T> lllllllllllllllIIIIllIIIIlllIlll, @NotNull final Supplier<T> lllllllllllllllIIIIllIIIIllllIII);
        
        @Contract("_, _ -> this")
        @NotNull
        default <T> Builder withStatic(@NotNull final Pointer<T> lllllllllllllllIIIIllIIIlIIIIIII, @Nullable final T lllllllllllllllIIIIllIIIIlllllll) {
            return this.withDynamic(lllllllllllllllIIIIllIIIlIIIIIII, () -> lllllllllllllllIIIIllIIIIlllllll);
        }
    }
}
