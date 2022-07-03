package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class BinExpr extends Expr
{
    @Override
    public void accept(final Visitor lllllllllllllIllllIllllIIlIIIllI) throws CompileError {
        lllllllllllllIllllIllllIIlIIIllI.atBinExpr(this);
    }
    
    private BinExpr(final int lllllllllllllIllllIllllIIlIlIlll, final ASTree lllllllllllllIllllIllllIIlIllIlI, final ASTList lllllllllllllIllllIllllIIlIllIIl) {
        super(lllllllllllllIllllIllllIIlIlIlll, lllllllllllllIllllIllllIIlIllIlI, lllllllllllllIllllIllllIIlIllIIl);
    }
    
    public static BinExpr makeBin(final int lllllllllllllIllllIllllIIlIIlllI, final ASTree lllllllllllllIllllIllllIIlIIllIl, final ASTree lllllllllllllIllllIllllIIlIIllll) {
        return new BinExpr(lllllllllllllIllllIllllIIlIIlllI, lllllllllllllIllllIllllIIlIIllIl, new ASTList(lllllllllllllIllllIllllIIlIIllll));
    }
}
