package com.viaversion.viaversion.libs.kyori.adventure.util;

import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

public interface HSVLike extends Examinable
{
    float s();
    
    float h();
    
    float v();
    
    @NotNull
    default HSVLike of(final float lllllllllllllIIIllIlIlllIllIlIlI, final float lllllllllllllIIIllIlIlllIllIlIll, final float lllllllllllllIIIllIlIlllIllIllII) {
        return new HSVLikeImpl(lllllllllllllIIIllIlIlllIllIlIlI, lllllllllllllIIIllIlIlllIllIlIll, lllllllllllllIIIllIlIlllIllIllII);
    }
    
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("h", this.h()), ExaminableProperty.of("s", this.s()), ExaminableProperty.of("v", this.v()) });
    }
    
    @NotNull
    default HSVLike fromRGB(final int lllllllllllllIIIllIlIlllIlIllIII, final int lllllllllllllIIIllIlIlllIlIlIlll, final int lllllllllllllIIIllIlIlllIlIlIllI) {
        final float lllllllllllllIIIllIlIlllIlIIllll = lllllllllllllIIIllIlIlllIlIllIII / 255.0f;
        final float lllllllllllllIIIllIlIlllIlIIlllI = lllllllllllllIIIllIlIlllIlIlIlll / 255.0f;
        final float lllllllllllllIIIllIlIlllIlIIllIl = lllllllllllllIIIllIlIlllIlIlIllI / 255.0f;
        final float lllllllllllllIIIllIlIlllIlIIllII = Math.min(lllllllllllllIIIllIlIlllIlIIllll, Math.min(lllllllllllllIIIllIlIlllIlIIlllI, lllllllllllllIIIllIlIlllIlIIllIl));
        final float lllllllllllllIIIllIlIlllIlIIlIll = Math.max(lllllllllllllIIIllIlIlllIlIIllll, Math.max(lllllllllllllIIIllIlIlllIlIIlllI, lllllllllllllIIIllIlIlllIlIIllIl));
        final float lllllllllllllIIIllIlIlllIlIIlIlI = lllllllllllllIIIllIlIlllIlIIlIll - lllllllllllllIIIllIlIlllIlIIllII;
        float lllllllllllllIIIllIlIlllIlIIlIIl = 0.0f;
        if (lllllllllllllIIIllIlIlllIlIIlIll != 0.0f) {
            final float lllllllllllllIIIllIlIlllIlIlIlIl = lllllllllllllIIIllIlIlllIlIIlIlI / lllllllllllllIIIllIlIlllIlIIlIll;
        }
        else {
            lllllllllllllIIIllIlIlllIlIIlIIl = 0.0f;
        }
        if (lllllllllllllIIIllIlIlllIlIIlIIl == 0.0f) {
            return new HSVLikeImpl(0.0f, lllllllllllllIIIllIlIlllIlIIlIIl, lllllllllllllIIIllIlIlllIlIIlIll);
        }
        float lllllllllllllIIIllIlIlllIlIIlIII = 0.0f;
        if (lllllllllllllIIIllIlIlllIlIIllll == lllllllllllllIIIllIlIlllIlIIlIll) {
            final float lllllllllllllIIIllIlIlllIlIlIlII = (lllllllllllllIIIllIlIlllIlIIlllI - lllllllllllllIIIllIlIlllIlIIllIl) / lllllllllllllIIIllIlIlllIlIIlIlI;
        }
        else if (lllllllllllllIIIllIlIlllIlIIlllI == lllllllllllllIIIllIlIlllIlIIlIll) {
            final float lllllllllllllIIIllIlIlllIlIlIIll = 2.0f + (lllllllllllllIIIllIlIlllIlIIllIl - lllllllllllllIIIllIlIlllIlIIllll) / lllllllllllllIIIllIlIlllIlIIlIlI;
        }
        else {
            lllllllllllllIIIllIlIlllIlIIlIII = 4.0f + (lllllllllllllIIIllIlIlllIlIIllll - lllllllllllllIIIllIlIlllIlIIlllI) / lllllllllllllIIIllIlIlllIlIIlIlI;
        }
        lllllllllllllIIIllIlIlllIlIIlIII *= 60.0f;
        if (lllllllllllllIIIllIlIlllIlIIlIII < 0.0f) {
            lllllllllllllIIIllIlIlllIlIIlIII += 360.0f;
        }
        return new HSVLikeImpl(lllllllllllllIIIllIlIlllIlIIlIII / 360.0f, lllllllllllllIIIllIlIlllIlIIlIIl, lllllllllllllIIIllIlIlllIlIIlIll);
    }
}
