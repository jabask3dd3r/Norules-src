package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;

public final class LinearComponents
{
    @NotNull
    public static Component linear(@NotNull final ComponentBuilderApplicable... lllllllllllllIIllllIlIlIlIIIlllI) {
        final int lllllllllllllIIllllIlIlIlIIIlIIl = lllllllllllllIIllllIlIlIlIIIlllI.length;
        if (lllllllllllllIIllllIlIlIlIIIlIIl == 0) {
            return Component.empty();
        }
        if (lllllllllllllIIllllIlIlIlIIIlIIl == 1) {
            final ComponentBuilderApplicable lllllllllllllIIllllIlIlIlIIIllIl = lllllllllllllIIllllIlIlIlIIIlllI[0];
            if (lllllllllllllIIllllIlIlIlIIIllIl instanceof ComponentLike) {
                return ((ComponentLike)lllllllllllllIIllllIlIlIlIIIllIl).asComponent();
            }
            throw nothingComponentLike();
        }
        else {
            final TextComponentImpl.BuilderImpl lllllllllllllIIllllIlIlIlIIIlIII = new TextComponentImpl.BuilderImpl();
            Style.Builder lllllllllllllIIllllIlIlIlIIIIlll = null;
            for (final ComponentBuilderApplicable lllllllllllllIIllllIlIlIlIIIllII : lllllllllllllIIllllIlIlIlIIIlllI) {
                if (lllllllllllllIIllllIlIlIlIIIllII instanceof StyleBuilderApplicable) {
                    if (lllllllllllllIIllllIlIlIlIIIIlll == null) {
                        lllllllllllllIIllllIlIlIlIIIIlll = Style.style();
                    }
                    lllllllllllllIIllllIlIlIlIIIIlll.apply((StyleBuilderApplicable)lllllllllllllIIllllIlIlIlIIIllII);
                }
                else if (lllllllllllllIIllllIlIlIlIIIIlll != null && lllllllllllllIIllllIlIlIlIIIllII instanceof ComponentLike) {
                    lllllllllllllIIllllIlIlIlIIIlIII.applicableApply(((ComponentLike)lllllllllllllIIllllIlIlIlIIIllII).asComponent().style(lllllllllllllIIllllIlIlIlIIIIlll));
                }
                else {
                    lllllllllllllIIllllIlIlIlIIIlIII.applicableApply(lllllllllllllIIllllIlIlIlIIIllII);
                }
            }
            final int lllllllllllllIIllllIlIlIlIIIIllI = lllllllllllllIIllllIlIlIlIIIlIII.children.size();
            if (lllllllllllllIIllllIlIlIlIIIIllI == 0) {
                throw nothingComponentLike();
            }
            if (lllllllllllllIIllllIlIlIlIIIIllI == 1) {
                return lllllllllllllIIllllIlIlIlIIIlIII.children.get(0);
            }
            return lllllllllllllIIllllIlIlIlIIIlIII.build();
        }
    }
    
    private static IllegalStateException nothingComponentLike() {
        return new IllegalStateException("Cannot build component linearly - nothing component-like was given");
    }
    
    private LinearComponents() {
    }
}
