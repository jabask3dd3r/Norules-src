package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class CondExpr extends ASTList
{
    public ASTree thenExpr() {
        return this.tail().head();
    }
    
    public CondExpr(final ASTree lllllllllllllllIllllIIIIlllIlllI, final ASTree lllllllllllllllIllllIIIIlllIllIl, final ASTree lllllllllllllllIllllIIIIlllIllII) {
        super(lllllllllllllllIllllIIIIlllIlllI, new ASTList(lllllllllllllllIllllIIIIlllIllIl, new ASTList(lllllllllllllllIllllIIIIlllIllII)));
    }
    
    public void setThen(final ASTree lllllllllllllllIllllIIIIllIlIllI) {
        this.tail().setHead(lllllllllllllllIllllIIIIllIlIllI);
    }
    
    public String getTag() {
        return "?:";
    }
    
    public void setElse(final ASTree lllllllllllllllIllllIIIIllIIllll) {
        this.tail().tail().setHead(lllllllllllllllIllllIIIIllIIllll);
    }
    
    public ASTree elseExpr() {
        return this.tail().tail().head();
    }
    
    public void setCond(final ASTree lllllllllllllllIllllIIIIlllIIIIl) {
        this.setHead(lllllllllllllllIllllIIIIlllIIIIl);
    }
    
    public ASTree condExpr() {
        return this.head();
    }
    
    @Override
    public void accept(final Visitor lllllllllllllllIllllIIIIllIIlIII) throws CompileError {
        lllllllllllllllIllllIIIIllIIlIII.atCondExpr(this);
    }
}
