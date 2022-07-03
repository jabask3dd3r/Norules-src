package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.legacy;

import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;

public final class LegacyFormat implements Examinable
{
    @Nullable
    private final /* synthetic */ TextDecoration decoration;
    @Nullable
    private final /* synthetic */ NamedTextColor color;
    private final /* synthetic */ boolean reset;
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("color", this.color), ExaminableProperty.of("decoration", this.decoration), ExaminableProperty.of("reset", this.reset) });
    }
    
    private LegacyFormat(final boolean lllllllllllllIIIlIIIIIlllIllllll) {
        this.color = null;
        this.decoration = null;
        this.reset = lllllllllllllIIIlIIIIIlllIllllll;
    }
    
    LegacyFormat(@Nullable final NamedTextColor lllllllllllllIIIlIIIIIllllIIllIl) {
        this.color = lllllllllllllIIIlIIIIIllllIIllIl;
        this.decoration = null;
        this.reset = false;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIIlIIIIIlllIlIlllI) {
        if (this == lllllllllllllIIIlIIIIIlllIlIlllI) {
            return true;
        }
        if (lllllllllllllIIIlIIIIIlllIlIlllI == null || this.getClass() != lllllllllllllIIIlIIIIIlllIlIlllI.getClass()) {
            return false;
        }
        final LegacyFormat lllllllllllllIIIlIIIIIlllIlIlIll = (LegacyFormat)lllllllllllllIIIlIIIIIlllIlIlllI;
        return this.color == lllllllllllllIIIlIIIIIlllIlIlIll.color && this.decoration == lllllllllllllIIIlIIIIIlllIlIlIll.decoration && this.reset == lllllllllllllIIIlIIIIIlllIlIlIll.reset;
    }
    
    public boolean reset() {
        return this.reset;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIlIIIIIlllIlIIlII = Objects.hashCode(this.color);
        lllllllllllllIIIlIIIIIlllIlIIlII = 31 * lllllllllllllIIIlIIIIIlllIlIIlII + Objects.hashCode(this.decoration);
        lllllllllllllIIIlIIIIIlllIlIIlII = 31 * lllllllllllllIIIlIIIIIlllIlIIlII + Boolean.hashCode(this.reset);
        return lllllllllllllIIIlIIIIIlllIlIIlII;
    }
    
    @Nullable
    public TextDecoration decoration() {
        return this.decoration;
    }
    
    @Nullable
    public TextColor color() {
        return this.color;
    }
    
    static {
        RESET = new LegacyFormat(true);
    }
    
    LegacyFormat(@Nullable final TextDecoration lllllllllllllIIIlIIIIIllllIIIllI) {
        this.color = null;
        this.decoration = lllllllllllllIIIlIIIIIllllIIIllI;
        this.reset = false;
    }
}
