package com.viaversion.viaversion.libs.kyori.adventure.util;

import java.util.*;
import org.jetbrains.annotations.*;

public final class ShadyPines
{
    public static boolean equals(final float llllllllllllllIllIIllIIllIIIlllI, final float llllllllllllllIllIIllIIllIIIllIl) {
        return Float.floatToIntBits(llllllllllllllIllIIllIIllIIIlllI) == Float.floatToIntBits(llllllllllllllIllIIllIIllIIIllIl);
    }
    
    @Deprecated
    @SafeVarargs
    @NotNull
    public static <E extends Enum<E>> Set<E> enumSet(final Class<E> llllllllllllllIllIIllIIllIIlllIl, final E... llllllllllllllIllIIllIIllIIllllI) {
        return MonkeyBars.enumSet(llllllllllllllIllIIllIIllIIlllIl, llllllllllllllIllIIllIIllIIllllI);
    }
    
    private ShadyPines() {
    }
    
    public static boolean equals(final double llllllllllllllIllIIllIIllIIlIllI, final double llllllllllllllIllIIllIIllIIlIlIl) {
        return Double.doubleToLongBits(llllllllllllllIllIIllIIllIIlIllI) == Double.doubleToLongBits(llllllllllllllIllIIllIIllIIlIlIl);
    }
}
