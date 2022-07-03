package com.viaversion.viaversion.libs.kyori.adventure.text;

import java.util.function.*;
import java.util.*;
import org.jetbrains.annotations.*;

@FunctionalInterface
public interface ComponentLike
{
    @NotNull
    default List<Component> asComponents(@NotNull final List<? extends ComponentLike> lllllllllllllIIlIlIIlIlIlIllIIII) {
        return asComponents(lllllllllllllIIlIlIIlIlIlIllIIII, null);
    }
    
    @Nullable
    default Component unbox(@Nullable final ComponentLike lllllllllllllIIlIlIIlIlIlIIlIlIl) {
        return (lllllllllllllIIlIlIIlIlIlIIlIlIl != null) ? lllllllllllllIIlIlIIlIlIlIIlIlIl.asComponent() : null;
    }
    
    @NotNull
    default List<Component> asComponents(@NotNull final List<? extends ComponentLike> lllllllllllllIIlIlIIlIlIlIlIIlIl, @Nullable final Predicate<? super Component> lllllllllllllIIlIlIIlIlIlIlIIllI) {
        if (lllllllllllllIIlIlIIlIlIlIlIIlIl.isEmpty()) {
            return Collections.emptyList();
        }
        final int lllllllllllllIIlIlIIlIlIlIIlllll = lllllllllllllIIlIlIIlIlIlIlIIlIl.size();
        ArrayList<Component> lllllllllllllIIlIlIIlIlIlIIllllI = null;
        for (int lllllllllllllIIlIlIIlIlIlIlIIIlI = 0; lllllllllllllIIlIlIIlIlIlIlIIIlI < lllllllllllllIIlIlIIlIlIlIIlllll; ++lllllllllllllIIlIlIIlIlIlIlIIIlI) {
            final ComponentLike lllllllllllllIIlIlIIlIlIlIlIIlII = (ComponentLike)lllllllllllllIIlIlIIlIlIlIlIIlIl.get(lllllllllllllIIlIlIIlIlIlIlIIIlI);
            final Component lllllllllllllIIlIlIIlIlIlIlIIIll = lllllllllllllIIlIlIIlIlIlIlIIlII.asComponent();
            if (lllllllllllllIIlIlIIlIlIlIlIIllI == null || lllllllllllllIIlIlIIlIlIlIlIIllI.test(lllllllllllllIIlIlIIlIlIlIlIIIll)) {
                if (lllllllllllllIIlIlIIlIlIlIIllllI == null) {
                    lllllllllllllIIlIlIIlIlIlIIllllI = new ArrayList<Component>(lllllllllllllIIlIlIIlIlIlIIlllll);
                }
                lllllllllllllIIlIlIIlIlIlIIllllI.add(lllllllllllllIIlIlIIlIlIlIlIIIll);
            }
        }
        if (lllllllllllllIIlIlIIlIlIlIIllllI != null) {
            lllllllllllllIIlIlIIlIlIlIIllllI.trimToSize();
        }
        if (lllllllllllllIIlIlIIlIlIlIIllllI == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList((List<? extends Component>)lllllllllllllIIlIlIIlIlIlIIllllI);
    }
    
    @NotNull
    @Contract(pure = true)
    Component asComponent();
}
