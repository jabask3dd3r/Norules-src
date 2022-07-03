package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Symbol extends ASTree
{
    protected /* synthetic */ String identifier;
    
    public String get() {
        return this.identifier;
    }
    
    public Symbol(final String lllllllllllllIlIlIlIlIIIlIllIIII) {
        this.identifier = lllllllllllllIlIlIlIlIIIlIllIIII;
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIlIlIlIlIIIlIlIIlII) throws CompileError {
        lllllllllllllIlIlIlIlIIIlIlIIlII.atSymbol(this);
    }
    
    @Override
    public String toString() {
        return this.identifier;
    }
}
