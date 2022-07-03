package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class ArrayInit extends ASTList
{
    public String getTag() {
        return "array";
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIIIIIIlllIIIlIIIIll) throws CompileError {
        lllllllllllllIIIIIIlllIIIlIIIIll.atArrayInit(this);
    }
    
    public int size() {
        final int lllllllllllllIIIIIIlllIIIlIIlIll = this.length();
        if (lllllllllllllIIIIIIlllIIIlIIlIll == 1 && this.head() == null) {
            return 0;
        }
        return lllllllllllllIIIIIIlllIIIlIIlIll;
    }
    
    public ArrayInit(final ASTree lllllllllllllIIIIIIlllIIIlIlIIIl) {
        super(lllllllllllllIIIIIIlllIIIlIlIIIl);
    }
}
