package com.viaversion.viaversion.compatibility.unsafe;

import com.viaversion.viaversion.compatibility.*;
import sun.misc.*;
import java.lang.reflect.*;
import java.util.*;

public final class UnsafeBackedForcefulFieldModifier implements ForcefulFieldModifier
{
    private final /* synthetic */ Unsafe unsafe;
    
    @Override
    public void setField(final Field lllllllllllllIIIlllllIIIIlIlIIlI, final Object lllllllllllllIIIlllllIIIIlIlIlll, final Object lllllllllllllIIIlllllIIIIlIlIllI) {
        Objects.requireNonNull(lllllllllllllIIIlllllIIIIlIlIIlI, "field must not be null");
        final Object lllllllllllllIIIlllllIIIIlIlIlIl = (lllllllllllllIIIlllllIIIIlIlIlll != null) ? lllllllllllllIIIlllllIIIIlIlIlll : this.unsafe.staticFieldBase(lllllllllllllIIIlllllIIIIlIlIIlI);
        final long lllllllllllllIIIlllllIIIIlIlIlII = (lllllllllllllIIIlllllIIIIlIlIlll != null) ? this.unsafe.objectFieldOffset(lllllllllllllIIIlllllIIIIlIlIIlI) : this.unsafe.staticFieldOffset(lllllllllllllIIIlllllIIIIlIlIIlI);
        this.unsafe.putObject(lllllllllllllIIIlllllIIIIlIlIlIl, lllllllllllllIIIlllllIIIIlIlIlII, lllllllllllllIIIlllllIIIIlIlIllI);
    }
    
    public UnsafeBackedForcefulFieldModifier() throws ReflectiveOperationException {
        final Field lllllllllllllIIIlllllIIIIllIIIlI = Unsafe.class.getDeclaredField("theUnsafe");
        lllllllllllllIIIlllllIIIIllIIIlI.setAccessible(true);
        this.unsafe = (Unsafe)lllllllllllllIIIlllllIIIIllIIIlI.get(null);
    }
}
