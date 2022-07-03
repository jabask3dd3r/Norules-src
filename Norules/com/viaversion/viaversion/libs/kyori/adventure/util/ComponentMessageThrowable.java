package com.viaversion.viaversion.libs.kyori.adventure.util;

import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;

public interface ComponentMessageThrowable
{
    @Nullable
    Component componentMessage();
    
    @Nullable
    default Component getMessage(@Nullable final Throwable llllllllllllllllIllIllllIllIIlIl) {
        if (llllllllllllllllIllIllllIllIIlIl instanceof ComponentMessageThrowable) {
            return ((ComponentMessageThrowable)llllllllllllllllIllIllllIllIIlIl).componentMessage();
        }
        return null;
    }
    
    @Nullable
    default Component getOrConvertMessage(@Nullable final Throwable llllllllllllllllIllIllllIlIlIlIl) {
        if (llllllllllllllllIllIllllIlIlIlIl instanceof ComponentMessageThrowable) {
            return ((ComponentMessageThrowable)llllllllllllllllIllIllllIlIlIlIl).componentMessage();
        }
        if (llllllllllllllllIllIllllIlIlIlIl != null) {
            final String llllllllllllllllIllIllllIlIlIIll = llllllllllllllllIllIllllIlIlIlIl.getMessage();
            if (llllllllllllllllIllIllllIlIlIIll != null) {
                return Component.text(llllllllllllllllIllIllllIlIlIIll);
            }
        }
        return null;
    }
}
