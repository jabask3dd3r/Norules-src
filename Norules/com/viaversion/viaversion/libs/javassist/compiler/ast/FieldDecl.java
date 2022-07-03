package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class FieldDecl extends ASTList
{
    public ASTree getInit() {
        return this.sublist(2).head();
    }
    
    public ASTList getModifiers() {
        return (ASTList)this.getLeft();
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIlIIllIlIllllIlIlll) throws CompileError {
        lllllllllllllIlIIllIlIllllIlIlll.atFieldDecl(this);
    }
    
    public Declarator getDeclarator() {
        return (Declarator)this.tail().head();
    }
    
    public FieldDecl(final ASTree lllllllllllllIlIIllIlIlllllIlIlI, final ASTList lllllllllllllIlIIllIlIlllllIlIIl) {
        super(lllllllllllllIlIIllIlIlllllIlIlI, lllllllllllllIlIIllIlIlllllIlIIl);
    }
}
