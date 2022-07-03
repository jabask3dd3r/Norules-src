package com.viaversion.viaversion.libs.kyori.adventure.text.flattener;

import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import org.jetbrains.annotations.*;

@FunctionalInterface
public interface FlattenerListener
{
    default void popStyle(@NotNull final Style lllllllllllllIIlIIIIlIlIlIIlllII) {
    }
    
    default void pushStyle(@NotNull final Style lllllllllllllIIlIIIIlIlIlIlIIIII) {
    }
    
    void component(@NotNull final String lllllllllllllIIlIIIIlIlIlIIlllIl);
}
