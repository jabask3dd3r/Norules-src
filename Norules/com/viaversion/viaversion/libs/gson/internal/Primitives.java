package com.viaversion.viaversion.libs.gson.internal;

import java.lang.reflect.*;

public final class Primitives
{
    private Primitives() {
    }
    
    public static boolean isPrimitive(final Type lllllllllllllIlIIIIlIIllllIlIIll) {
        return lllllllllllllIlIIIIlIIllllIlIIll instanceof Class && ((Class)lllllllllllllIlIIIIlIIllllIlIIll).isPrimitive();
    }
    
    public static <T> Class<T> wrap(final Class<T> lllllllllllllIlIIIIlIIllllIIllII) {
        if (lllllllllllllIlIIIIlIIllllIIllII == Integer.TYPE) {
            return (Class<T>)Integer.class;
        }
        if (lllllllllllllIlIIIIlIIllllIIllII == Float.TYPE) {
            return (Class<T>)Float.class;
        }
        if (lllllllllllllIlIIIIlIIllllIIllII == Byte.TYPE) {
            return (Class<T>)Byte.class;
        }
        if (lllllllllllllIlIIIIlIIllllIIllII == Double.TYPE) {
            return (Class<T>)Double.class;
        }
        if (lllllllllllllIlIIIIlIIllllIIllII == Long.TYPE) {
            return (Class<T>)Long.class;
        }
        if (lllllllllllllIlIIIIlIIllllIIllII == Character.TYPE) {
            return (Class<T>)Character.class;
        }
        if (lllllllllllllIlIIIIlIIllllIIllII == Boolean.TYPE) {
            return (Class<T>)Boolean.class;
        }
        if (lllllllllllllIlIIIIlIIllllIIllII == Short.TYPE) {
            return (Class<T>)Short.class;
        }
        if (lllllllllllllIlIIIIlIIllllIIllII == Void.TYPE) {
            return (Class<T>)Void.class;
        }
        return lllllllllllllIlIIIIlIIllllIIllII;
    }
    
    public static boolean isWrapperType(final Type lllllllllllllIlIIIIlIIllllIlIIII) {
        return lllllllllllllIlIIIIlIIllllIlIIII == Integer.class || lllllllllllllIlIIIIlIIllllIlIIII == Float.class || lllllllllllllIlIIIIlIIllllIlIIII == Byte.class || lllllllllllllIlIIIIlIIllllIlIIII == Double.class || lllllllllllllIlIIIIlIIllllIlIIII == Long.class || lllllllllllllIlIIIIlIIllllIlIIII == Character.class || lllllllllllllIlIIIIlIIllllIlIIII == Boolean.class || lllllllllllllIlIIIIlIIllllIlIIII == Short.class || lllllllllllllIlIIIIlIIllllIlIIII == Void.class;
    }
    
    public static <T> Class<T> unwrap(final Class<T> lllllllllllllIlIIIIlIIllllIIlIIl) {
        if (lllllllllllllIlIIIIlIIllllIIlIIl == Integer.class) {
            return (Class<T>)Integer.TYPE;
        }
        if (lllllllllllllIlIIIIlIIllllIIlIIl == Float.class) {
            return (Class<T>)Float.TYPE;
        }
        if (lllllllllllllIlIIIIlIIllllIIlIIl == Byte.class) {
            return (Class<T>)Byte.TYPE;
        }
        if (lllllllllllllIlIIIIlIIllllIIlIIl == Double.class) {
            return (Class<T>)Double.TYPE;
        }
        if (lllllllllllllIlIIIIlIIllllIIlIIl == Long.class) {
            return (Class<T>)Long.TYPE;
        }
        if (lllllllllllllIlIIIIlIIllllIIlIIl == Character.class) {
            return (Class<T>)Character.TYPE;
        }
        if (lllllllllllllIlIIIIlIIllllIIlIIl == Boolean.class) {
            return (Class<T>)Boolean.TYPE;
        }
        if (lllllllllllllIlIIIIlIIllllIIlIIl == Short.class) {
            return (Class<T>)Short.TYPE;
        }
        if (lllllllllllllIlIIIIlIIllllIIlIIl == Void.class) {
            return (Class<T>)Void.TYPE;
        }
        return lllllllllllllIlIIIIlIIllllIIlIIl;
    }
}
