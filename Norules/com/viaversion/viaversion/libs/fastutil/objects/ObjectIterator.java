package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public interface ObjectIterator<K> extends Iterator<K>
{
    default int skip(final int llllllllllllllIllllIllIlIIIlIllI) {
        if (llllllllllllllIllllIllIlIIIlIllI < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Argument must be nonnegative: ").append(llllllllllllllIllllIllIlIIIlIllI)));
        }
        int llllllllllllllIllllIllIlIIIlIlIl = llllllllllllllIllllIllIlIIIlIllI;
        while (llllllllllllllIllllIllIlIIIlIlIl-- != 0 && this.hasNext()) {
            this.next();
        }
        return llllllllllllllIllllIllIlIIIlIllI - llllllllllllllIllllIllIlIIIlIlIl - 1;
    }
}
