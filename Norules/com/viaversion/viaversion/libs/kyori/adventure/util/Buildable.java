package com.viaversion.viaversion.libs.kyori.adventure.util;

import java.util.function.*;
import org.jetbrains.annotations.*;

public interface Buildable<R, B extends Builder<R>>
{
    @NotNull
    @Contract(value = "-> new", pure = true)
    B toBuilder();
    
    @NotNull
    @Contract(mutates = "param1")
    default <R extends Buildable<R, B>, B extends Builder<R>> R configureAndBuild(@NotNull final B lIIlIllllIlIll, @Nullable final Consumer<? super B> lIIlIllllIlIlI) {
        if (lIIlIllllIlIlI != null) {
            lIIlIllllIlIlI.accept((Object)lIIlIllllIlIll);
        }
        return lIIlIllllIlIll.build();
    }
    
    public interface Builder<R>
    {
        @Contract(value = "-> new", pure = true)
        @NotNull
        R build();
    }
}
