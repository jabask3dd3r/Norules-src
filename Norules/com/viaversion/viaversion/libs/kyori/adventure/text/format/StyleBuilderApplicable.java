package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;

@FunctionalInterface
public interface StyleBuilderApplicable extends ComponentBuilderApplicable
{
    default void componentBuilderApply(@NotNull final ComponentBuilder<?, ?> lllllllllllllIIllIlIlIllIlllllIl) {
        lllllllllllllIIllIlIlIllIlllllIl.style(this::styleApply);
    }
    
    @Contract(mutates = "param")
    void styleApply(final Style.Builder lllllllllllllIIllIlIlIlllIIIIIII);
}
