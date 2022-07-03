package com.viaversion.viaversion.libs.gson.internal.reflect;

import com.viaversion.viaversion.libs.gson.*;
import java.lang.reflect.*;

final class UnsafeReflectionAccessor extends ReflectionAccessor
{
    private static /* synthetic */ Class unsafeClass;
    private final /* synthetic */ Object theUnsafe;
    private final /* synthetic */ Field overrideField;
    
    private static Field getOverrideField() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        }
        catch (NoSuchFieldException lllllllllllllIllllIIIlIIllIllllI) {
            return null;
        }
    }
    
    UnsafeReflectionAccessor() {
        this.theUnsafe = getUnsafeInstance();
        this.overrideField = getOverrideField();
    }
    
    @Override
    public void makeAccessible(final AccessibleObject lllllllllllllIllllIIIlIlIIIlIlll) {
        final boolean lllllllllllllIllllIIIlIlIIIllIll = this.makeAccessibleWithUnsafe(lllllllllllllIllllIIIlIlIIIlIlll);
        if (!lllllllllllllIllllIIIlIlIIIllIll) {
            try {
                lllllllllllllIllllIIIlIlIIIlIlll.setAccessible(true);
            }
            catch (SecurityException lllllllllllllIllllIIIlIlIIlIIIIl) {
                throw new JsonIOException(String.valueOf(new StringBuilder().append("Gson couldn't modify fields for ").append(lllllllllllllIllllIIIlIlIIIlIlll).append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.")), lllllllllllllIllllIIIlIlIIlIIIIl);
            }
        }
    }
    
    private static Object getUnsafeInstance() {
        try {
            UnsafeReflectionAccessor.unsafeClass = Class.forName("sun.misc.Unsafe");
            final Field lllllllllllllIllllIIIlIIlllIlIII = UnsafeReflectionAccessor.unsafeClass.getDeclaredField("theUnsafe");
            lllllllllllllIllllIIIlIIlllIlIII.setAccessible(true);
            return lllllllllllllIllllIIIlIIlllIlIII.get(null);
        }
        catch (Exception lllllllllllllIllllIIIlIIlllIIllI) {
            return null;
        }
    }
    
    boolean makeAccessibleWithUnsafe(final AccessibleObject lllllllllllllIllllIIIlIIlllllIlI) {
        if (this.theUnsafe != null && this.overrideField != null) {
            try {
                final Method lllllllllllllIllllIIIlIlIIIIIIlI = UnsafeReflectionAccessor.unsafeClass.getMethod("objectFieldOffset", Field.class);
                final long lllllllllllllIllllIIIlIlIIIIIIII = (long)lllllllllllllIllllIIIlIlIIIIIIlI.invoke(this.theUnsafe, this.overrideField);
                final Method lllllllllllllIllllIIIlIIlllllllI = UnsafeReflectionAccessor.unsafeClass.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
                lllllllllllllIllllIIIlIIlllllllI.invoke(this.theUnsafe, lllllllllllllIllllIIIlIIlllllIlI, lllllllllllllIllllIIIlIlIIIIIIII, true);
                return true;
            }
            catch (Exception ex) {}
        }
        return false;
    }
}
