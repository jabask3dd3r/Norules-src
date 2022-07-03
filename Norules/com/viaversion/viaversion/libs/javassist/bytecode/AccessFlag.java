package com.viaversion.viaversion.libs.javassist.bytecode;

public class AccessFlag
{
    public static int of(final int llllllllllllllllIllIlIllIIIIIllI) {
        return llllllllllllllllIllIlIllIIIIIllI;
    }
    
    public static int setPackage(final int llllllllllllllllIllIlIllIIIllIll) {
        return llllllllllllllllIllIlIllIIIllIll & 0xFFFFFFF8;
    }
    
    public static boolean isPublic(final int llllllllllllllllIllIlIllIIIllIIl) {
        return (llllllllllllllllIllIlIllIIIllIIl & 0x1) != 0x0;
    }
    
    public static int toModifier(final int llllllllllllllllIllIlIllIIIIIIll) {
        return llllllllllllllllIllIlIllIIIIIIll;
    }
    
    public static boolean isPackage(final int llllllllllllllllIllIlIllIIIIllll) {
        return (llllllllllllllllIllIlIllIIIIllll & 0x7) == 0x0;
    }
    
    static {
        PUBLIC = 1;
        SYNCHRONIZED = 32;
        STATIC = 8;
        ABSTRACT = 1024;
        STRICT = 2048;
        TRANSIENT = 128;
        FINAL = 16;
        NATIVE = 256;
        ANNOTATION = 8192;
        VOLATILE = 64;
        SUPER = 32;
        PRIVATE = 2;
        SYNTHETIC = 4096;
        BRIDGE = 64;
        ENUM = 16384;
        MANDATED = 32768;
        VARARGS = 128;
        PROTECTED = 4;
        INTERFACE = 512;
        MODULE = 32768;
    }
    
    public static int setPrivate(final int llllllllllllllllIllIlIllIIIlllll) {
        return (llllllllllllllllIllIlIllIIIlllll & 0xFFFFFFFA) | 0x2;
    }
    
    public static boolean isProtected(final int llllllllllllllllIllIlIllIIIlIllI) {
        return (llllllllllllllllIllIlIllIIIlIllI & 0x4) != 0x0;
    }
    
    public static int setPublic(final int llllllllllllllllIllIlIllIIlIIlII) {
        return (llllllllllllllllIllIlIllIIlIIlII & 0xFFFFFFF9) | 0x1;
    }
    
    public static boolean isPrivate(final int llllllllllllllllIllIlIllIIIlIIlI) {
        return (llllllllllllllllIllIlIllIIIlIIlI & 0x2) != 0x0;
    }
    
    public static int clear(final int llllllllllllllllIllIlIllIIIIlIlI, final int llllllllllllllllIllIlIllIIIIlIIl) {
        return llllllllllllllllIllIlIllIIIIlIlI & ~llllllllllllllllIllIlIllIIIIlIIl;
    }
    
    public static int setProtected(final int llllllllllllllllIllIlIllIIlIIIIl) {
        return (llllllllllllllllIllIlIllIIlIIIIl & 0xFFFFFFFC) | 0x4;
    }
}
