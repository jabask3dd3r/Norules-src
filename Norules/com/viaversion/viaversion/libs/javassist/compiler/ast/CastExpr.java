package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class CastExpr extends ASTList implements TokenId
{
    protected /* synthetic */ int arrayDim;
    protected /* synthetic */ int castType;
    
    public void setOprand(final ASTree lllllllllllllIlllllllIlllIIllIlI) {
        this.getRight().setLeft(lllllllllllllIlllllllIlllIIllIlI);
    }
    
    public int getArrayDim() {
        return this.arrayDim;
    }
    
    public String getTag() {
        return String.valueOf(new StringBuilder().append("cast:").append(this.castType).append(":").append(this.arrayDim));
    }
    
    public ASTree getOprand() {
        return this.getRight().getLeft();
    }
    
    public CastExpr(final int lllllllllllllIlllllllIlllIllIIII, final int lllllllllllllIlllllllIlllIlIlIll, final ASTree lllllllllllllIlllllllIlllIlIlllI) {
        super(null, new ASTList(lllllllllllllIlllllllIlllIlIlllI));
        this.castType = lllllllllllllIlllllllIlllIllIIII;
        this.arrayDim = lllllllllllllIlllllllIlllIlIlIll;
    }
    
    public int getType() {
        return this.castType;
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIlllllllIlllIIlIIIl) throws CompileError {
        lllllllllllllIlllllllIlllIIlIIIl.atCastExpr(this);
    }
    
    public ASTList getClassName() {
        return (ASTList)this.getLeft();
    }
    
    public CastExpr(final ASTList lllllllllllllIlllllllIlllIllllII, final int lllllllllllllIlllllllIlllIlllIll, final ASTree lllllllllllllIlllllllIlllIllIllI) {
        super(lllllllllllllIlllllllIlllIllllII, new ASTList(lllllllllllllIlllllllIlllIllIllI));
        this.castType = 307;
        this.arrayDim = lllllllllllllIlllllllIlllIlllIll;
    }
}
