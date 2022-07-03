package com.viaversion.viaversion.libs.kyori.adventure.translation;

import java.util.*;
import java.text.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;

public interface Translator
{
    @Nullable
    MessageFormat translate(@NotNull final String lllllllllllllIIlIlllIllIlIllllII, @NotNull final Locale lllllllllllllIIlIlllIllIlIllllIl);
    
    @NotNull
    Key name();
    
    @Nullable
    default Locale parseLocale(@NotNull final String lllllllllllllIIlIlllIllIllIIIlII) {
        final String[] lllllllllllllIIlIlllIllIllIIIIlI = lllllllllllllIIlIlllIllIllIIIlII.split("_", 3);
        final int lllllllllllllIIlIlllIllIllIIIIIl = lllllllllllllIIlIlllIllIllIIIIlI.length;
        if (lllllllllllllIIlIlllIllIllIIIIIl == 1) {
            return new Locale(lllllllllllllIIlIlllIllIllIIIlII);
        }
        if (lllllllllllllIIlIlllIllIllIIIIIl == 2) {
            return new Locale(lllllllllllllIIlIlllIllIllIIIIlI[0], lllllllllllllIIlIlllIllIllIIIIlI[1]);
        }
        if (lllllllllllllIIlIlllIllIllIIIIIl == 3) {
            return new Locale(lllllllllllllIIlIlllIllIllIIIIlI[0], lllllllllllllIIlIlllIllIllIIIIlI[1], lllllllllllllIIlIlllIllIllIIIIlI[2]);
        }
        return null;
    }
}
