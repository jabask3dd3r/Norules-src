package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class StringL extends ASTree
{
    protected /* synthetic */ String text;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("\"").append(this.text).append("\""));
    }
    
    public StringL(final String lllllllllllllIllIIIlllIlllllIIII) {
        this.text = lllllllllllllIllIIIlllIlllllIIII;
    }
    
    public String get() {
        return this.text;
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIllIIIlllIllllIIllI) throws CompileError {
        lllllllllllllIllIIIlllIllllIIllI.atStringL(this);
    }
}
