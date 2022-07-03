package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

public class NoSuchClassError extends Error
{
    private /* synthetic */ String className;
    
    public NoSuchClassError(final String lllllllllllllIlIlIIIllIIIIlIllll, final Error lllllllllllllIlIlIIIllIIIIllIIIl) {
        super(lllllllllllllIlIlIIIllIIIIllIIIl.toString(), lllllllllllllIlIlIIIllIIIIllIIIl);
        this.className = lllllllllllllIlIlIIIllIIIIlIllll;
    }
    
    public String getClassName() {
        return this.className;
    }
}
