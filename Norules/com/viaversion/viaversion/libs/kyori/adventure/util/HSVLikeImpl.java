package com.viaversion.viaversion.libs.kyori.adventure.util;

import java.util.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;

final class HSVLikeImpl implements HSVLike
{
    private final /* synthetic */ float v;
    private final /* synthetic */ float h;
    private final /* synthetic */ float s;
    
    @Override
    public float s() {
        return this.s;
    }
    
    @Override
    public float h() {
        return this.h;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.h, this.s, this.v);
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    HSVLikeImpl(final float lllllllllllllIlIlIIIlIIIlIlIllII, final float lllllllllllllIlIlIIIlIIIlIlIlIlI, final float lllllllllllllIlIlIIIlIIIlIlIlIll) {
        this.h = lllllllllllllIlIlIIIlIIIlIlIllII;
        this.s = lllllllllllllIlIlIIIlIIIlIlIlIlI;
        this.v = lllllllllllllIlIlIIIlIIIlIlIlIll;
    }
    
    @Override
    public float v() {
        return this.v;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIlIlIIIlIIIlIIlIlIl) {
        if (this == lllllllllllllIlIlIIIlIIIlIIlIlIl) {
            return true;
        }
        if (!(lllllllllllllIlIlIIIlIIIlIIlIlIl instanceof HSVLikeImpl)) {
            return false;
        }
        final HSVLikeImpl lllllllllllllIlIlIIIlIIIlIIlIIlI = (HSVLikeImpl)lllllllllllllIlIlIIIlIIIlIIlIlIl;
        return ShadyPines.equals(lllllllllllllIlIlIIIlIIIlIIlIIlI.h, this.h) && ShadyPines.equals(lllllllllllllIlIlIIIlIIIlIIlIIlI.s, this.s) && ShadyPines.equals(lllllllllllllIlIlIIIlIIIlIIlIIlI.v, this.v);
    }
}
