package com.viaversion.viaversion.libs.kyori.adventure.key;

import org.jetbrains.annotations.*;
import org.intellij.lang.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

public interface Key extends Comparable<Key>, Examinable
{
    @NotNull
    default Key key(@NotNull @Pattern("[a-z0-9_\\-.]+") final String lllllllllllllllIIIllIllllIlIlllI, @NotNull @Pattern("[a-z0-9_\\-./]+") final String lllllllllllllllIIIllIllllIlIllIl) {
        return new KeyImpl(lllllllllllllllIIIllIllllIlIlllI, lllllllllllllllIIIllIllllIlIllIl);
    }
    
    @NotNull
    default Key key(@NotNull final String lllllllllllllllIIIllIlllllIIIlII, final char lllllllllllllllIIIllIlllllIIIIll) {
        final int lllllllllllllllIIIllIlllllIIIIII = lllllllllllllllIIIllIlllllIIIlII.indexOf(lllllllllllllllIIIllIlllllIIIIll);
        final String lllllllllllllllIIIllIllllIllllll = (lllllllllllllllIIIllIlllllIIIIII >= 1) ? lllllllllllllllIIIllIlllllIIIlII.substring(0, lllllllllllllllIIIllIlllllIIIIII) : "minecraft";
        final String lllllllllllllllIIIllIllllIlllllI = (lllllllllllllllIIIllIlllllIIIIII >= 0) ? lllllllllllllllIIIllIlllllIIIlII.substring(lllllllllllllllIIIllIlllllIIIIII + 1) : lllllllllllllllIIIllIlllllIIIlII;
        return key(lllllllllllllllIIIllIllllIllllll, lllllllllllllllIIIllIllllIlllllI);
    }
    
    default int compareTo(@NotNull final Key lllllllllllllllIIIllIllllIlIIIlI) {
        final int lllllllllllllllIIIllIllllIIlllll = this.value().compareTo(lllllllllllllllIIIllIllllIlIIIlI.value());
        if (lllllllllllllllIIIllIllllIIlllll != 0) {
            return KeyImpl.clampCompare(lllllllllllllllIIIllIllllIIlllll);
        }
        return KeyImpl.clampCompare(this.namespace().compareTo(lllllllllllllllIIIllIllllIlIIIlI.namespace()));
    }
    
    @NotNull
    String asString();
    
    @NotNull
    default Key key(@NotNull final Namespaced lllllllllllllllIIIllIllllIllIllI, @NotNull @Pattern("[a-z0-9_\\-./]+") final String lllllllllllllllIIIllIllllIllIlIl) {
        return key(lllllllllllllllIIIllIllllIllIllI.namespace(), lllllllllllllllIIIllIllllIllIlIl);
    }
    
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("namespace", this.namespace()), ExaminableProperty.of("value", this.value()) });
    }
    
    @NotNull
    default Key key(@NotNull @Pattern("([a-z0-9_\\-.]+:)?[a-z0-9_\\-./]+") final String lllllllllllllllIIIllIlllllIIllII) {
        return key(lllllllllllllllIIIllIlllllIIllII, ':');
    }
    
    @NotNull
    String namespace();
    
    @NotNull
    String value();
}
