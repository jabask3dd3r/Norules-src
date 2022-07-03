package com.viaversion.viaversion.libs.kyori.adventure.translation;

import java.util.function.*;
import java.util.*;

final class TranslationLocales
{
    private static final /* synthetic */ Supplier<Locale> GLOBAL;
    
    static Locale global() {
        return TranslationLocales.GLOBAL.get();
    }
    
    private TranslationLocales() {
    }
    
    static {
        final String lllllllllllllIIIlIIlllllllIlIIlI = System.getProperty("net.kyo".concat("ri.adventure.defaultTranslationLocale"));
        if (lllllllllllllIIIlIIlllllllIlIIlI == null || lllllllllllllIIIlIIlllllllIlIIlI.isEmpty()) {
            GLOBAL = (() -> Locale.US);
        }
        else if (lllllllllllllIIIlIIlllllllIlIIlI.equals("system")) {
            GLOBAL = Locale::getDefault;
        }
        else {
            final Locale lllllllllllllIIIlIIlllllllIlIIll = Translator.parseLocale(lllllllllllllIIIlIIlllllllIlIIlI);
            GLOBAL = (() -> lllllllllllllIIIlIIlllllllIlIIll);
        }
    }
}
