package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.*;

public class CompileError extends Exception
{
    private /* synthetic */ String reason;
    private /* synthetic */ Lex lex;
    
    @Override
    public String getMessage() {
        return this.reason;
    }
    
    public CompileError(final String lllllllllllllIllIlIlIlIIlIllIIlI) {
        this.reason = lllllllllllllIllIlIlIlIIlIllIIlI;
        this.lex = null;
    }
    
    public CompileError(final NotFoundException lllllllllllllIllIlIlIlIIlIlIIlII) {
        this(String.valueOf(new StringBuilder().append("cannot find ").append(lllllllllllllIllIlIlIlIIlIlIIlII.getMessage())));
    }
    
    public CompileError(final String lllllllllllllIllIlIlIlIIlIllIlll, final Lex lllllllllllllIllIlIlIlIIlIlllIIl) {
        this.reason = lllllllllllllIllIlIlIlIIlIllIlll;
        this.lex = lllllllllllllIllIlIlIlIIlIlllIIl;
    }
    
    public CompileError(final CannotCompileException lllllllllllllIllIlIlIlIIlIlIllII) {
        this(lllllllllllllIllIlIlIlIIlIlIllII.getReason());
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("compile error: ").append(this.reason));
    }
    
    public Lex getLex() {
        return this.lex;
    }
}
