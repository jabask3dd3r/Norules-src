package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class MethodDecl extends ASTList
{
    public Stmnt getBody() {
        return (Stmnt)this.sublist(4).head();
    }
    
    @Override
    public void accept(final Visitor lllllllllllllllIllIlllIlIIlIIIII) throws CompileError {
        lllllllllllllllIllIlllIlIIlIIIII.atMethodDecl(this);
    }
    
    public ASTList getThrows() {
        return (ASTList)this.sublist(3).head();
    }
    
    public Declarator getReturn() {
        return (Declarator)this.tail().head();
    }
    
    public ASTList getParams() {
        return (ASTList)this.sublist(2).head();
    }
    
    public boolean isConstructor() {
        final Symbol lllllllllllllllIllIlllIlIIllIlIl = this.getReturn().getVariable();
        return lllllllllllllllIllIlllIlIIllIlIl != null && "<init>".equals(lllllllllllllllIllIlllIlIIllIlIl.get());
    }
    
    public MethodDecl(final ASTree lllllllllllllllIllIlllIlIIlllIlI, final ASTList lllllllllllllllIllIlllIlIIllllII) {
        super(lllllllllllllllIllIlllIlIIlllIlI, lllllllllllllllIllIlllIlIIllllII);
    }
    
    public ASTList getModifiers() {
        return (ASTList)this.getLeft();
    }
    
    static {
        initName = "<init>";
    }
}
