package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Pair extends ASTree
{
    protected /* synthetic */ ASTree right;
    protected /* synthetic */ ASTree left;
    
    public Pair(final ASTree lllllllllllllIIllIIllIlIllIIlllI, final ASTree lllllllllllllIIllIIllIlIllIIlIlI) {
        this.left = lllllllllllllIIllIIllIlIllIIlllI;
        this.right = lllllllllllllIIllIIllIlIllIIlIlI;
    }
    
    @Override
    public void setLeft(final ASTree lllllllllllllIIllIIllIlIlIllIIlI) {
        this.left = lllllllllllllIIllIIllIlIlIllIIlI;
    }
    
    @Override
    public ASTree getLeft() {
        return this.left;
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIIllIIllIlIllIIIIII = new StringBuffer();
        lllllllllllllIIllIIllIlIllIIIIII.append("(<Pair> ");
        lllllllllllllIIllIIllIlIllIIIIII.append((this.left == null) ? "<null>" : this.left.toString());
        lllllllllllllIIllIIllIlIllIIIIII.append(" . ");
        lllllllllllllIIllIIllIlIllIIIIII.append((this.right == null) ? "<null>" : this.right.toString());
        lllllllllllllIIllIIllIlIllIIIIII.append(')');
        return lllllllllllllIIllIIllIlIllIIIIII.toString();
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIIllIIllIlIllIIIllI) throws CompileError {
        lllllllllllllIIllIIllIlIllIIIllI.atPair(this);
    }
    
    @Override
    public ASTree getRight() {
        return this.right;
    }
    
    @Override
    public void setRight(final ASTree lllllllllllllIIllIIllIlIlIlIlllI) {
        this.right = lllllllllllllIIllIIllIlIlIlIlllI;
    }
}
