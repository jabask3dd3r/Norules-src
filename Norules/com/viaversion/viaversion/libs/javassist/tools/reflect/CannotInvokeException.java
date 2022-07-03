package com.viaversion.viaversion.libs.javassist.tools.reflect;

import java.lang.reflect.*;

public class CannotInvokeException extends RuntimeException
{
    private /* synthetic */ Throwable err;
    
    public Throwable getReason() {
        return this.err;
    }
    
    public CannotInvokeException(final InvocationTargetException lllllllllllllIlllIIIIIIlllllIllI) {
        super(String.valueOf(new StringBuilder().append("by ").append(lllllllllllllIlllIIIIIIlllllIllI.getTargetException().toString())));
        this.err = null;
        this.err = lllllllllllllIlllIIIIIIlllllIllI.getTargetException();
    }
    
    public CannotInvokeException(final String lllllllllllllIlllIIIIIIlllllllII) {
        super(lllllllllllllIlllIIIIIIlllllllII);
        this.err = null;
    }
    
    public CannotInvokeException(final IllegalAccessException lllllllllllllIlllIIIIIIlllllIIII) {
        super(String.valueOf(new StringBuilder().append("by ").append(lllllllllllllIlllIIIIIIlllllIIII.toString())));
        this.err = null;
        this.err = lllllllllllllIlllIIIIIIlllllIIII;
    }
    
    public CannotInvokeException(final ClassNotFoundException lllllllllllllIlllIIIIIIllllIlIlI) {
        super(String.valueOf(new StringBuilder().append("by ").append(lllllllllllllIlllIIIIIIllllIlIlI.toString())));
        this.err = null;
        this.err = lllllllllllllIlllIIIIIIllllIlIlI;
    }
}
