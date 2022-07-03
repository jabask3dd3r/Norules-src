package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class CannotCompileException extends Exception
{
    private /* synthetic */ Throwable myCause;
    private /* synthetic */ String message;
    
    public CannotCompileException(final String llllllllllllIlllllIIIlllIIlIIIII) {
        super(llllllllllllIlllllIIIlllIIlIIIII);
        this.message = llllllllllllIlllllIIIlllIIlIIIII;
        this.initCause(null);
    }
    
    @Override
    public synchronized Throwable initCause(final Throwable llllllllllllIlllllIIIlllIIlIlIll) {
        this.myCause = llllllllllllIlllllIIIlllIIlIlIll;
        return this;
    }
    
    public CannotCompileException(final Throwable llllllllllllIlllllIIIlllIIIlllII) {
        super(String.valueOf(new StringBuilder().append("by ").append(llllllllllllIlllllIIIlllIIIlllII.toString())));
        this.message = null;
        this.initCause(llllllllllllIlllllIIIlllIIIlllII);
    }
    
    public CannotCompileException(final CompileError llllllllllllIlllllIIIlllIIIIIlIl) {
        this(String.valueOf(new StringBuilder().append("[source error] ").append(llllllllllllIlllllIIIlllIIIIIlIl.getMessage())), llllllllllllIlllllIIIlllIIIIIlIl);
    }
    
    public CannotCompileException(final ClassNotFoundException llllllllllllIlllllIIIllIllllllIl, final String llllllllllllIlllllIIIllIllllllll) {
        this(String.valueOf(new StringBuilder().append("cannot find ").append(llllllllllllIlllllIIIllIllllllll)), llllllllllllIlllllIIIllIllllllIl);
    }
    
    public String getReason() {
        if (this.message != null) {
            return this.message;
        }
        return this.toString();
    }
    
    public CannotCompileException(final NotFoundException llllllllllllIlllllIIIlllIIIIllIl) {
        this(String.valueOf(new StringBuilder().append("cannot find ").append(llllllllllllIlllllIIIlllIIIIllIl.getMessage())), llllllllllllIlllllIIIlllIIIIllIl);
    }
    
    public CannotCompileException(final String llllllllllllIlllllIIIlllIIIlIlIl, final Throwable llllllllllllIlllllIIIlllIIIlIIIl) {
        this(llllllllllllIlllllIIIlllIIIlIlIl);
        this.initCause(llllllllllllIlllllIIIlllIIIlIIIl);
    }
    
    public CannotCompileException(final ClassFormatError llllllllllllIlllllIIIllIllllIlll, final String llllllllllllIlllllIIIllIllllIIll) {
        this(String.valueOf(new StringBuilder().append("invalid class format: ").append(llllllllllllIlllllIIIllIllllIIll)), llllllllllllIlllllIIIllIllllIlll);
    }
    
    @Override
    public synchronized Throwable getCause() {
        return (this.myCause == this) ? null : this.myCause;
    }
}
