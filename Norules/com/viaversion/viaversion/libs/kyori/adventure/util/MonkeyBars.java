package com.viaversion.viaversion.libs.kyori.adventure.util;

import org.jetbrains.annotations.*;
import java.util.*;

public final class MonkeyBars
{
    private MonkeyBars() {
    }
    
    @SafeVarargs
    @NotNull
    public static <E extends Enum<E>> Set<E> enumSet(final Class<E> lllllllllllllllllIIIlllIIlIlIllI, final E... lllllllllllllllllIIIlllIIlIlIlll) {
        final Set<E> lllllllllllllllllIIIlllIIlIlIIll = EnumSet.noneOf(lllllllllllllllllIIIlllIIlIlIllI);
        Collections.addAll(lllllllllllllllllIIIlllIIlIlIIll, lllllllllllllllllIIIlllIIlIlIlll);
        return Collections.unmodifiableSet((Set<? extends E>)lllllllllllllllllIIIlllIIlIlIIll);
    }
    
    @NotNull
    public static <T> List<T> addOne(@NotNull final List<T> lllllllllllllllllIIIlllIIlIIllII, final T lllllllllllllllllIIIlllIIlIIlIll) {
        if (lllllllllllllllllIIIlllIIlIIllII.isEmpty()) {
            return Collections.singletonList(lllllllllllllllllIIIlllIIlIIlIll);
        }
        final List<T> lllllllllllllllllIIIlllIIlIIlIII = new ArrayList<T>(lllllllllllllllllIIIlllIIlIIllII.size() + 1);
        lllllllllllllllllIIIlllIIlIIlIII.addAll((Collection<? extends T>)lllllllllllllllllIIIlllIIlIIllII);
        lllllllllllllllllIIIlllIIlIIlIII.add(lllllllllllllllllIIIlllIIlIIlIll);
        return Collections.unmodifiableList((List<? extends T>)lllllllllllllllllIIIlllIIlIIlIII);
    }
}
