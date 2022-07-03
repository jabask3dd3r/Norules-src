package com.viaversion.viaversion.libs.javassist.tools.reflect;

public class CannotCreateException extends Exception
{
    public CannotCreateException(final String lllllllllllllIIlIIllIIIIIIlllIIl) {
        super(lllllllllllllIIlIIllIIIIIIlllIIl);
    }
    
    public CannotCreateException(final Exception lllllllllllllIIlIIllIIIIIIllIIll) {
        super(String.valueOf(new StringBuilder().append("by ").append(lllllllllllllIIlIIllIIIIIIllIIll.toString())));
    }
}
