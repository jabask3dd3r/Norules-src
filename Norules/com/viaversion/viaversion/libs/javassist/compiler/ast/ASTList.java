package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class ASTList extends ASTree
{
    private /* synthetic */ ASTree left;
    private /* synthetic */ ASTList right;
    
    public boolean subst(final ASTree lllllllllllllIlIlIllIllIIlllllIl, final ASTree lllllllllllllIlIlIllIllIIlllllll) {
        for (ASTList lllllllllllllIlIlIllIllIlIIIIIlI = this; lllllllllllllIlIlIllIllIlIIIIIlI != null; lllllllllllllIlIlIllIllIlIIIIIlI = lllllllllllllIlIlIllIllIlIIIIIlI.right) {
            if (lllllllllllllIlIlIllIllIlIIIIIlI.left == lllllllllllllIlIlIllIllIIlllllll) {
                lllllllllllllIlIlIllIllIlIIIIIlI.left = lllllllllllllIlIlIllIllIIlllllIl;
                return true;
            }
        }
        return false;
    }
    
    public int length() {
        return length(this);
    }
    
    public ASTList tail() {
        return this.right;
    }
    
    public ASTList(final ASTree lllllllllllllIlIlIllIllIlllIIIII) {
        this.left = lllllllllllllIlIlIllIllIlllIIIII;
        this.right = null;
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIlIlIllIllIlIIllllI = new StringBuffer();
        lllllllllllllIlIlIllIllIlIIllllI.append("(<");
        lllllllllllllIlIlIllIllIlIIllllI.append(this.getTag());
        lllllllllllllIlIlIllIllIlIIllllI.append('>');
        for (ASTList lllllllllllllIlIlIllIllIlIIlllIl = this; lllllllllllllIlIlIllIllIlIIlllIl != null; lllllllllllllIlIlIllIllIlIIlllIl = lllllllllllllIlIlIllIllIlIIlllIl.right) {
            lllllllllllllIlIlIllIllIlIIllllI.append(' ');
            final ASTree lllllllllllllIlIlIllIllIlIlIIIII = lllllllllllllIlIlIllIllIlIIlllIl.left;
            lllllllllllllIlIlIllIllIlIIllllI.append((lllllllllllllIlIlIllIllIlIlIIIII == null) ? "<null>" : lllllllllllllIlIlIllIllIlIlIIIII.toString());
        }
        lllllllllllllIlIlIllIllIlIIllllI.append(')');
        return lllllllllllllIlIlIllIllIlIIllllI.toString();
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIlIlIllIllIlIlIIlIl) throws CompileError {
        lllllllllllllIlIlIllIllIlIlIIlIl.atASTList(this);
    }
    
    public ASTList sublist(int lllllllllllllIlIlIllIllIlIIIlIll) {
        ASTList lllllllllllllIlIlIllIllIlIIIlIlI = this;
        while (lllllllllllllIlIlIllIllIlIIIlIll-- > 0) {
            lllllllllllllIlIlIllIllIlIIIlIlI = lllllllllllllIlIlIllIllIlIIIlIlI.right;
        }
        return lllllllllllllIlIlIllIllIlIIIlIlI;
    }
    
    @Override
    public ASTree getRight() {
        return this.right;
    }
    
    @Override
    public void setRight(final ASTree lllllllllllllIlIlIllIllIlIllllll) {
        this.right = (ASTList)lllllllllllllIlIlIllIllIlIllllll;
    }
    
    @Override
    public void setLeft(final ASTree lllllllllllllIlIlIllIllIllIIIIll) {
        this.left = lllllllllllllIlIlIllIllIllIIIIll;
    }
    
    public static ASTList concat(final ASTList lllllllllllllIlIlIllIllIIllIlllI, final ASTList lllllllllllllIlIlIllIllIIllIllIl) {
        if (lllllllllllllIlIlIllIllIIllIlllI == null) {
            return lllllllllllllIlIlIllIllIIllIllIl;
        }
        ASTList lllllllllllllIlIlIllIllIIllIllll;
        for (lllllllllllllIlIlIllIllIIllIllll = lllllllllllllIlIlIllIllIIllIlllI; lllllllllllllIlIlIllIllIIllIllll.right != null; lllllllllllllIlIlIllIllIIllIllll = lllllllllllllIlIlIllIllIIllIllll.right) {}
        lllllllllllllIlIlIllIllIIllIllll.right = lllllllllllllIlIlIllIllIIllIllIl;
        return lllllllllllllIlIlIllIllIIllIlllI;
    }
    
    public void setHead(final ASTree lllllllllllllIlIlIllIllIlIllIllI) {
        this.left = lllllllllllllIlIlIllIllIlIllIllI;
    }
    
    public ASTList(final ASTree lllllllllllllIlIlIllIllIlllIlIlI, final ASTList lllllllllllllIlIlIllIllIlllIlIII) {
        this.left = lllllllllllllIlIlIllIllIlllIlIlI;
        this.right = lllllllllllllIlIlIllIllIlllIlIII;
    }
    
    public void setTail(final ASTList lllllllllllllIlIlIllIllIlIlIlIll) {
        this.right = lllllllllllllIlIlIllIllIlIlIlIll;
    }
    
    public static ASTList make(final ASTree lllllllllllllIlIlIllIllIllIlIllI, final ASTree lllllllllllllIlIlIllIllIllIllIII, final ASTree lllllllllllllIlIlIllIllIllIlIIll) {
        return new ASTList(lllllllllllllIlIlIllIllIllIlIllI, new ASTList(lllllllllllllIlIlIllIllIllIllIII, new ASTList(lllllllllllllIlIlIllIllIllIlIIll)));
    }
    
    public static ASTList append(final ASTList lllllllllllllIlIlIllIllIIllllIII, final ASTree lllllllllllllIlIlIllIllIIlllIlll) {
        return concat(lllllllllllllIlIlIllIllIIllllIII, new ASTList(lllllllllllllIlIlIllIllIIlllIlll));
    }
    
    public ASTree head() {
        return this.left;
    }
    
    @Override
    public ASTree getLeft() {
        return this.left;
    }
    
    public static int length(ASTList lllllllllllllIlIlIllIllIlIIlIIIl) {
        if (lllllllllllllIlIlIllIllIlIIlIIIl == null) {
            return 0;
        }
        int lllllllllllllIlIlIllIllIlIIlIIlI;
        for (lllllllllllllIlIlIllIllIlIIlIIlI = 0; lllllllllllllIlIlIllIllIlIIlIIIl != null; lllllllllllllIlIlIllIllIlIIlIIIl = lllllllllllllIlIlIllIllIlIIlIIIl.right, ++lllllllllllllIlIlIllIllIlIIlIIlI) {}
        return lllllllllllllIlIlIllIllIlIIlIIlI;
    }
}
