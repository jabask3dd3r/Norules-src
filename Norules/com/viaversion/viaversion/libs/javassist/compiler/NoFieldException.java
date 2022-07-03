package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.compiler.ast.*;

public class NoFieldException extends CompileError
{
    private /* synthetic */ ASTree expr;
    private /* synthetic */ String fieldName;
    
    public String getField() {
        return this.fieldName;
    }
    
    public NoFieldException(final String lllllllllllllIIIllllIllllIIlIIIl, final ASTree lllllllllllllIIIllllIllllIIlIIII) {
        super(String.valueOf(new StringBuilder().append("no such field: ").append(lllllllllllllIIIllllIllllIIlIIIl)));
        this.fieldName = lllllllllllllIIIllllIllllIIlIIIl;
        this.expr = lllllllllllllIIIllllIllllIIlIIII;
    }
    
    public ASTree getExpr() {
        return this.expr;
    }
}
