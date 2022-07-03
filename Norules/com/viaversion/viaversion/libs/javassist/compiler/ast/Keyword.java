package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Keyword extends ASTree
{
    protected /* synthetic */ int tokenId;
    
    public Keyword(final int lllllllllllllIIlIlIIlIlIlIIIIlIl) {
        this.tokenId = lllllllllllllIIlIlIIlIlIlIIIIlIl;
    }
    
    public int get() {
        return this.tokenId;
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIIlIlIIlIlIIllllIIl) throws CompileError {
        lllllllllllllIIlIlIIlIlIIllllIIl.atKeyword(this);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("id:").append(this.tokenId));
    }
}
