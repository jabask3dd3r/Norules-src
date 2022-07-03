package com.viaversion.viaversion.libs.kyori.adventure.util;

import java.time.*;
import org.jetbrains.annotations.*;

public interface Ticks
{
    @NotNull
    default Duration duration(final long lllllllllllllIllllllIllIlllIlllI) {
        return Duration.ofMillis(lllllllllllllIllllllIllIlllIlllI * 50L);
    }
}
