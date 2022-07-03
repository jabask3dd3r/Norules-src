package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Variable extends Symbol
{
    protected /* synthetic */ Declarator declarator;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.identifier).append(":").append(this.declarator.getType()));
    }
    
    public Variable(final String llllllllllllllIlllIlIIllIIllIlIl, final Declarator llllllllllllllIlllIlIIllIIllIlII) {
        super(llllllllllllllIlllIlIIllIIllIlIl);
        this.declarator = llllllllllllllIlllIlIIllIIllIlII;
    }
    
    public Declarator getDeclarator() {
        return this.declarator;
    }
    
    @Override
    public void accept(final Visitor llllllllllllllIlllIlIIllIIlIIlll) throws CompileError {
        llllllllllllllIlllIlIIllIIlIIlll.atVariable(this);
    }
}
