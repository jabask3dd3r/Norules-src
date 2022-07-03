package com.viaversion.viaversion.libs.gson.internal;

import java.io.*;
import java.lang.reflect.*;

public abstract class UnsafeAllocator
{
    public static UnsafeAllocator create() {
        try {
            final Class<?> lllllllllllllIIlIlllllIlIIIIIlll = Class.forName("sun.misc.Unsafe");
            final Field lllllllllllllIIlIlllllIlIIIIIllI = lllllllllllllIIlIlllllIlIIIIIlll.getDeclaredField("theUnsafe");
            lllllllllllllIIlIlllllIlIIIIIllI.setAccessible(true);
            final Object lllllllllllllIIlIlllllIlIIIIIlIl = lllllllllllllIIlIlllllIlIIIIIllI.get(null);
            final Method lllllllllllllIIlIlllllIlIIIIIlII = lllllllllllllIIlIlllllIlIIIIIlll.getMethod("allocateInstance", Class.class);
            return new UnsafeAllocator() {
                @Override
                public <T> T newInstance(final Class<T> lllllllllllllIIlIlIIllIIlIllIIII) throws Exception {
                    UnsafeAllocator.assertInstantiable(lllllllllllllIIlIlIIllIIlIllIIII);
                    return (T)lllllllllllllIIlIlllllIlIIIIIlII.invoke(lllllllllllllIIlIlllllIlIIIIIlIl, lllllllllllllIIlIlIIllIIlIllIIII);
                }
            };
        }
        catch (Exception ex) {
            try {
                final Method lllllllllllllIIlIlllllIlIIIIIIll = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                lllllllllllllIIlIlllllIlIIIIIIll.setAccessible(true);
                final int lllllllllllllIIlIlllllIlIIIIIIlI = (int)lllllllllllllIIlIlllllIlIIIIIIll.invoke(null, Object.class);
                final Method lllllllllllllIIlIlllllIlIIIIIIIl = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                lllllllllllllIIlIlllllIlIIIIIIIl.setAccessible(true);
                return new UnsafeAllocator() {
                    @Override
                    public <T> T newInstance(final Class<T> lllllllllllllIIIllIlIIIIlIllIlII) throws Exception {
                        UnsafeAllocator.assertInstantiable(lllllllllllllIIIllIlIIIIlIllIlII);
                        return (T)lllllllllllllIIlIlllllIlIIIIIIIl.invoke(null, lllllllllllllIIIllIlIIIIlIllIlII, lllllllllllllIIlIlllllIlIIIIIIlI);
                    }
                };
            }
            catch (Exception ex2) {
                try {
                    final Method lllllllllllllIIlIlllllIlIIIIIIII = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    lllllllllllllIIlIlllllIlIIIIIIII.setAccessible(true);
                    return new UnsafeAllocator() {
                        @Override
                        public <T> T newInstance(final Class<T> lllllllllllllIlIllIllllIIlIIIIll) throws Exception {
                            UnsafeAllocator.assertInstantiable(lllllllllllllIlIllIllllIIlIIIIll);
                            return (T)lllllllllllllIIlIlllllIlIIIIIIII.invoke(null, lllllllllllllIlIllIllllIIlIIIIll, Object.class);
                        }
                    };
                }
                catch (Exception ex3) {
                    return new UnsafeAllocator() {
                        @Override
                        public <T> T newInstance(final Class<T> lllllllllllllIlIllIlllIlIIIIllll) {
                            throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append("Cannot allocate ").append(lllllllllllllIlIllIlllIlIIIIllll)));
                        }
                    };
                }
            }
        }
    }
    
    public abstract <T> T newInstance(final Class<T> p0) throws Exception;
    
    static void assertInstantiable(final Class<?> lllllllllllllIIlIlllllIIlllllIIl) {
        final int lllllllllllllIIlIlllllIIlllllIII = lllllllllllllIIlIlllllIIlllllIIl.getModifiers();
        if (Modifier.isInterface(lllllllllllllIIlIlllllIIlllllIII)) {
            throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append("Interface can't be instantiated! Interface name: ").append(lllllllllllllIIlIlllllIIlllllIIl.getName())));
        }
        if (Modifier.isAbstract(lllllllllllllIIlIlllllIIlllllIII)) {
            throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append("Abstract class can't be instantiated! Class name: ").append(lllllllllllllIIlIlllllIIlllllIIl.getName())));
        }
    }
}
