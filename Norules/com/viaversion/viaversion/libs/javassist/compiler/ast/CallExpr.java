package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class CallExpr extends Expr
{
    private /* synthetic */ MemberResolver.Method method;
    
    private CallExpr(final ASTree llllllllllllllIlIIllllIIlIIllIll, final ASTList llllllllllllllIlIIllllIIlIIllIlI) {
        super(67, llllllllllllllIlIIllllIIlIIllIll, llllllllllllllIlIIllllIIlIIllIlI);
        this.method = null;
    }
    
    public static CallExpr makeCall(final ASTree llllllllllllllIlIIllllIIlIIIllII, final ASTree llllllllllllllIlIIllllIIlIIIllIl) {
        return new CallExpr(llllllllllllllIlIIllllIIlIIIllII, new ASTList(llllllllllllllIlIIllllIIlIIIllIl));
    }
    
    public MemberResolver.Method getMethod() {
        return this.method;
    }
    
    @Override
    public void accept(final Visitor llllllllllllllIlIIllllIIlIIIIlIl) throws CompileError {
        llllllllllllllIlIIllllIIlIIIIlIl.atCallExpr(this);
    }
    
    public void setMethod(final MemberResolver.Method llllllllllllllIlIIllllIIlIIlIlII) {
        this.method = llllllllllllllIlIIllllIIlIIlIlII;
    }
}
