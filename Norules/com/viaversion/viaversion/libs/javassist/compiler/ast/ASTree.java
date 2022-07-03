package com.viaversion.viaversion.libs.javassist.compiler.ast;

import java.io.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;

public abstract class ASTree implements Serializable
{
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIIlllIlIIllllIllllI = new StringBuffer();
        lllllllllllllIIlllIlIIllllIllllI.append('<');
        lllllllllllllIIlllIlIIllllIllllI.append(this.getTag());
        lllllllllllllIIlllIlIIllllIllllI.append('>');
        return lllllllllllllIIlllIlIIllllIllllI.toString();
    }
    
    public void setLeft(final ASTree lllllllllllllIIlllIlIIlllllIIlII) {
    }
    
    public ASTree getLeft() {
        return null;
    }
    
    public ASTree getRight() {
        return null;
    }
    
    public void setRight(final ASTree lllllllllllllIIlllIlIIlllllIIIlI) {
    }
    
    public abstract void accept(final Visitor p0) throws CompileError;
    
    protected String getTag() {
        final String lllllllllllllIIlllIlIIllllIllIII = this.getClass().getName();
        return lllllllllllllIIlllIlIIllllIllIII.substring(lllllllllllllIIlllIlIIllllIllIII.lastIndexOf(46) + 1);
    }
}
