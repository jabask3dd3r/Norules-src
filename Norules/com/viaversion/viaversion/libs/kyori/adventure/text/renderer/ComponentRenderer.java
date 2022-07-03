package com.viaversion.viaversion.libs.kyori.adventure.text.renderer;

import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;
import java.util.function.*;

public interface ComponentRenderer<C>
{
    @NotNull
    Component render(@NotNull final Component lllllllllllllllIlIIllIllllIIllll, @NotNull final C lllllllllllllllIlIIllIllllIIlllI);
    
    default <T> ComponentRenderer<T> mapContext(final Function<T, C> lllllllllllllllIlIIllIllllIIlIll) {
        return (lllllllllllllllIlIIllIlllIllllIl, lllllllllllllllIlIIllIlllIllllII) -> this.render(lllllllllllllllIlIIllIlllIllllIl, lllllllllllllllIlIIllIllllIIlIll.apply(lllllllllllllllIlIIllIlllIllllII));
    }
}
