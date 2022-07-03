package com.viaversion.viaversion.libs.javassist;

public class Modifier
{
    public static int setPackage(final int lIlllIIlIIlIIll) {
        return lIlllIIlIIlIIll & 0xFFFFFFF8;
    }
    
    public static boolean isPublic(final int lIlllIIllIIllII) {
        return (lIlllIIllIIllII & 0x1) != 0x0;
    }
    
    public static boolean isProtected(final int lIlllIIllIIIllI) {
        return (lIlllIIllIIIllI & 0x4) != 0x0;
    }
    
    public static boolean isVolatile(final int lIlllIIlIllIlll) {
        return (lIlllIIlIllIlll & 0x40) != 0x0;
    }
    
    public static boolean isSynchronized(final int lIlllIIlIlllIlI) {
        return (lIlllIIlIlllIlI & 0x20) != 0x0;
    }
    
    public static int setProtected(final int lIlllIIlIIllIIl) {
        return (lIlllIIlIIllIIl & 0xFFFFFFFC) | 0x4;
    }
    
    public static boolean isInterface(final int lIlllIIlIlIlllI) {
        return (lIlllIIlIlIlllI & 0x200) != 0x0;
    }
    
    public static boolean isFinal(final int lIlllIIlIllllIl) {
        return (lIlllIIlIllllIl & 0x10) != 0x0;
    }
    
    public static boolean isAbstract(final int lIlllIIlIlIIlIl) {
        return (lIlllIIlIlIIlIl & 0x400) != 0x0;
    }
    
    public static boolean isNative(final int lIlllIIlIllIIIl) {
        return (lIlllIIlIllIIIl & 0x100) != 0x0;
    }
    
    static {
        TRANSIENT = 128;
        STATIC = 8;
        VOLATILE = 64;
        PRIVATE = 2;
        STRICT = 2048;
        ENUM = 16384;
        PROTECTED = 4;
        INTERFACE = 512;
        FINAL = 16;
        NATIVE = 256;
        ANNOTATION = 8192;
        ABSTRACT = 1024;
        VARARGS = 128;
        PUBLIC = 1;
        SYNCHRONIZED = 32;
    }
    
    public static int setPrivate(final int lIlllIIlIIlIllI) {
        return (lIlllIIlIIlIllI & 0xFFFFFFFA) | 0x2;
    }
    
    public static boolean isEnum(final int lIlllIIlIlIlIII) {
        return (lIlllIIlIlIlIII & 0x4000) != 0x0;
    }
    
    public static boolean isStatic(final int lIlllIIllIIIIII) {
        return (lIlllIIllIIIIII & 0x8) != 0x0;
    }
    
    public static boolean isStrict(final int lIlllIIlIlIIIlI) {
        return (lIlllIIlIlIIIlI & 0x800) != 0x0;
    }
    
    public static boolean isAnnotation(final int lIlllIIlIlIllII) {
        return (lIlllIIlIlIllII & 0x2000) != 0x0;
    }
    
    public static boolean isTransient(final int lIlllIIlIllIlII) {
        return (lIlllIIlIllIlII & 0x80) != 0x0;
    }
    
    public static int clear(final int lIlllIIlIIIlllI, final int lIlllIIlIIIllIl) {
        return lIlllIIlIIIlllI & ~lIlllIIlIIIllIl;
    }
    
    public static String toString(final int lIlllIIlIIIlIll) {
        return java.lang.reflect.Modifier.toString(lIlllIIlIIIlIll);
    }
    
    public static int setPublic(final int lIlllIIlIIlllIl) {
        return (lIlllIIlIIlllIl & 0xFFFFFFF9) | 0x1;
    }
    
    public static boolean isPrivate(final int lIlllIIllIIlIIl) {
        return (lIlllIIllIIlIIl & 0x2) != 0x0;
    }
    
    public static boolean isVarArgs(final int lIlllIIlIlIIIII) {
        return (lIlllIIlIlIIIII & 0x80) != 0x0;
    }
    
    public static boolean isPackage(final int lIlllIIllIIIIll) {
        return (lIlllIIllIIIIll & 0x7) == 0x0;
    }
}
