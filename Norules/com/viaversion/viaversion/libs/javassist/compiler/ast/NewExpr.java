package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class NewExpr extends ASTList implements TokenId
{
    protected /* synthetic */ boolean newArray;
    protected /* synthetic */ int arrayType;
    
    @Override
    public void accept(final Visitor llllllllllllllIIllIIlIIllIlllIIl) throws CompileError {
        llllllllllllllIIllIIlIIllIlllIIl.atNewExpr(this);
    }
    
    public ASTList getArguments() {
        return (ASTList)this.getRight().getLeft();
    }
    
    public NewExpr(final int llllllllllllllIIllIIlIIllllIIlII, final ASTList llllllllllllllIIllIIlIIlllIlllll, final ArrayInit llllllllllllllIIllIIlIIllllIIIlI) {
        super(null, new ASTList(llllllllllllllIIllIIlIIlllIlllll));
        this.newArray = true;
        this.arrayType = llllllllllllllIIllIIlIIllllIIlII;
        if (llllllllllllllIIllIIlIIllllIIIlI != null) {
            ASTList.append(this, llllllllllllllIIllIIlIIllllIIIlI);
        }
    }
    
    public boolean isArray() {
        return this.newArray;
    }
    
    public NewExpr(final ASTList llllllllllllllIIllIIlIIllllIlllI, final ASTList llllllllllllllIIllIIlIIllllIlIlI) {
        super(llllllllllllllIIllIIlIIllllIlllI, new ASTList(llllllllllllllIIllIIlIIllllIlIlI));
        this.newArray = false;
        this.arrayType = 307;
    }
    
    public static NewExpr makeObjectArray(final ASTList llllllllllllllIIllIIlIIlllIllIIl, final ASTList llllllllllllllIIllIIlIIlllIllIII, final ArrayInit llllllllllllllIIllIIlIIlllIlIIll) {
        final NewExpr llllllllllllllIIllIIlIIlllIlIllI = new NewExpr(llllllllllllllIIllIIlIIlllIllIIl, llllllllllllllIIllIIlIIlllIllIII);
        llllllllllllllIIllIIlIIlllIlIllI.newArray = true;
        if (llllllllllllllIIllIIlIIlllIlIIll != null) {
            ASTList.append(llllllllllllllIIllIIlIIlllIlIllI, llllllllllllllIIllIIlIIlllIlIIll);
        }
        return llllllllllllllIIllIIlIIlllIlIllI;
    }
    
    public int getArrayType() {
        return this.arrayType;
    }
    
    @Override
    protected String getTag() {
        return this.newArray ? "new[]" : "new";
    }
    
    public ASTList getArraySize() {
        return this.getArguments();
    }
    
    public ArrayInit getInitializer() {
        final ASTree llllllllllllllIIllIIlIIllIllllll = this.getRight().getRight();
        if (llllllllllllllIIllIIlIIllIllllll == null) {
            return null;
        }
        return (ArrayInit)llllllllllllllIIllIIlIIllIllllll.getLeft();
    }
    
    public ASTList getClassName() {
        return (ASTList)this.getLeft();
    }
}
