package com.viaversion.viaversion.libs.kyori.adventure.text.event;

import java.util.function.*;
import org.jetbrains.annotations.*;

public interface HoverEventSource<V>
{
    @NotNull
    HoverEvent<V> asHoverEvent(@NotNull final UnaryOperator<V> lllllllllllllIIIIlIllIlIIlIIllIl);
    
    @Nullable
    default <V> HoverEvent<V> unbox(@Nullable final HoverEventSource<V> lllllllllllllIIIIlIllIlIIlIlIIll) {
        return (lllllllllllllIIIIlIllIlIIlIlIIll != null) ? lllllllllllllIIIIlIllIlIIlIlIIll.asHoverEvent() : null;
    }
    
    @NotNull
    default HoverEvent<V> asHoverEvent() {
        return this.asHoverEvent(UnaryOperator.identity());
    }
}
