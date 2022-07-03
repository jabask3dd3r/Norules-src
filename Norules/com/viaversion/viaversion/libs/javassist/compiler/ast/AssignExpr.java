package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class AssignExpr extends Expr
{
    @Override
    public void accept(final Visitor lllllllllllllIlIIllllIIlIIIIIIll) throws CompileError {
        lllllllllllllIlIIllllIIlIIIIIIll.atAssignExpr(this);
    }
    
    public static AssignExpr makeAssign(final int lllllllllllllIlIIllllIIlIIIIllII, final ASTree lllllllllllllIlIIllllIIlIIIIlIII, final ASTree lllllllllllllIlIIllllIIlIIIIlIlI) {
        return new AssignExpr(lllllllllllllIlIIllllIIlIIIIllII, lllllllllllllIlIIllllIIlIIIIlIII, new ASTList(lllllllllllllIlIIllllIIlIIIIlIlI));
    }
    
    private AssignExpr(final int lllllllllllllIlIIllllIIlIIIlIIlI, final ASTree lllllllllllllIlIIllllIIlIIIlIlIl, final ASTList lllllllllllllIlIIllllIIlIIIlIIII) {
        super(lllllllllllllIlIIllllIIlIIIlIIlI, lllllllllllllIlIIllllIIlIIIlIlIl, lllllllllllllIlIIllllIIlIIIlIIII);
    }
}
