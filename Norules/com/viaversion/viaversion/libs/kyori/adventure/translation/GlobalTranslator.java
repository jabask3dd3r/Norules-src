package com.viaversion.viaversion.libs.kyori.adventure.translation;

import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.renderer.*;

public interface GlobalTranslator extends Translator, Examinable
{
    boolean addSource(@NotNull final Translator lllllllllllllIllIIIlIIIIIllIIIlI);
    
    @NotNull
    default Component render(@NotNull final Component lllllllllllllIllIIIlIIIIIllIlIII, @NotNull final Locale lllllllllllllIllIIIlIIIIIllIIlll) {
        return renderer().render(lllllllllllllIllIIIlIIIIIllIlIII, lllllllllllllIllIIIlIIIIIllIIlll);
    }
    
    boolean removeSource(@NotNull final Translator lllllllllllllIllIIIlIIIIIllIIIIl);
    
    @NotNull
    Iterable<? extends Translator> sources();
    
    @NotNull
    default GlobalTranslator get() {
        return GlobalTranslatorImpl.INSTANCE;
    }
    
    @NotNull
    default TranslatableComponentRenderer<Locale> renderer() {
        return GlobalTranslatorImpl.INSTANCE.renderer;
    }
}
