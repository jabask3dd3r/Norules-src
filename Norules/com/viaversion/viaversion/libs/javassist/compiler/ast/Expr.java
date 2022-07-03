package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Expr extends ASTList implements TokenId
{
    protected /* synthetic */ int operatorId;
    
    public static Expr make(final int lllllllllllllIIIIllIIIIlllIIIIlI, final ASTree lllllllllllllIIIIllIIIIllIllllIl) {
        return new Expr(lllllllllllllIIIIllIIIIlllIIIIlI, lllllllllllllIIIIllIIIIllIllllIl);
    }
    
    public ASTree oprand1() {
        return this.getLeft();
    }
    
    @Override
    protected String getTag() {
        return String.valueOf(new StringBuilder().append("op:").append(this.getName()));
    }
    
    Expr(final int lllllllllllllIIIIllIIIIlllIllllI, final ASTree lllllllllllllIIIIllIIIIlllIlllIl) {
        super(lllllllllllllIIIIllIIIIlllIlllIl);
        this.operatorId = lllllllllllllIIIIllIIIIlllIllllI;
    }
    
    public static Expr make(final int lllllllllllllIIIIllIIIIlllIlIlIl, final ASTree lllllllllllllIIIIllIIIIlllIlIIIl, final ASTree lllllllllllllIIIIllIIIIlllIIllll) {
        return new Expr(lllllllllllllIIIIllIIIIlllIlIlIl, lllllllllllllIIIIllIIIIlllIlIIIl, new ASTList(lllllllllllllIIIIllIIIIlllIIllll));
    }
    
    public void setOprand1(final ASTree lllllllllllllIIIIllIIIIllIIllllI) {
        this.setLeft(lllllllllllllIIIIllIIIIllIIllllI);
    }
    
    public ASTree oprand2() {
        return this.getRight().getLeft();
    }
    
    public void setOperator(final int lllllllllllllIIIIllIIIIllIlIllII) {
        this.operatorId = lllllllllllllIIIIllIIIIllIlIllII;
    }
    
    public void setOprand2(final ASTree lllllllllllllIIIIllIIIIllIIIllll) {
        this.getRight().setLeft(lllllllllllllIIIIllIIIIllIIIllll);
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIIIIllIIIIllIIIIllI) throws CompileError {
        lllllllllllllIIIIllIIIIllIIIIllI.atExpr(this);
    }
    
    Expr(final int lllllllllllllIIIIllIIIIlllllIlII, final ASTree lllllllllllllIIIIllIIIIlllllIIlI, final ASTList lllllllllllllIIIIllIIIIlllllIIII) {
        super(lllllllllllllIIIIllIIIIlllllIIlI, lllllllllllllIIIIllIIIIlllllIIII);
        this.operatorId = lllllllllllllIIIIllIIIIlllllIlII;
    }
    
    public int getOperator() {
        return this.operatorId;
    }
    
    public String getName() {
        final int lllllllllllllIIIIllIIIIllIIIIIII = this.operatorId;
        if (lllllllllllllIIIIllIIIIllIIIIIII < 128) {
            return String.valueOf((char)lllllllllllllIIIIllIIIIllIIIIIII);
        }
        if (350 <= lllllllllllllIIIIllIIIIllIIIIIII && lllllllllllllIIIIllIIIIllIIIIIII <= 371) {
            return Expr.opNames[lllllllllllllIIIIllIIIIllIIIIIII - 350];
        }
        if (lllllllllllllIIIIllIIIIllIIIIIII == 323) {
            return "instanceof";
        }
        return String.valueOf(lllllllllllllIIIIllIIIIllIIIIIII);
    }
}
