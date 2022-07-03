package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;

public abstract class MemberValue
{
    /* synthetic */ char tag;
    /* synthetic */ ConstPool cp;
    
    private static String convertFromArray(final String llllllllllllllIlIlIIIIllIlllIlII) {
        int llllllllllllllIlIlIIIIllIlllIIlI = llllllllllllllIlIlIIIIllIlllIlII.indexOf("[]");
        if (llllllllllllllIlIlIIIIllIlllIIlI != -1) {
            final String llllllllllllllIlIlIIIIllIllllIII = llllllllllllllIlIlIIIIllIlllIlII.substring(0, llllllllllllllIlIlIIIIllIlllIIlI);
            final StringBuffer llllllllllllllIlIlIIIIllIlllIllI = new StringBuffer(Descriptor.of(llllllllllllllIlIlIIIIllIllllIII));
            while (llllllllllllllIlIlIIIIllIlllIIlI != -1) {
                llllllllllllllIlIlIIIIllIlllIllI.insert(0, "[");
                llllllllllllllIlIlIIIIllIlllIIlI = llllllllllllllIlIlIIIIllIlllIlII.indexOf("[]", llllllllllllllIlIlIIIIllIlllIIlI + 1);
            }
            return llllllllllllllIlIlIIIIllIlllIllI.toString().replace('/', '.');
        }
        return llllllllllllllIlIlIIIIllIlllIlII;
    }
    
    abstract Class<?> getType(final ClassLoader p0) throws ClassNotFoundException;
    
    public abstract void write(final AnnotationsWriter p0) throws IOException;
    
    static Class<?> loadClass(final ClassLoader llllllllllllllIlIlIIIIlllIIIllIl, final String llllllllllllllIlIlIIIIlllIIIlIll) throws NoSuchClassError, ClassNotFoundException {
        try {
            return Class.forName(convertFromArray(llllllllllllllIlIlIIIIlllIIIlIll), true, llllllllllllllIlIlIIIIlllIIIllIl);
        }
        catch (LinkageError llllllllllllllIlIlIIIIlllIIIllll) {
            throw new NoSuchClassError(llllllllllllllIlIlIIIIlllIIIlIll, llllllllllllllIlIlIIIIlllIIIllll);
        }
    }
    
    MemberValue(final char llllllllllllllIlIlIIIIlllIIlllII, final ConstPool llllllllllllllIlIlIIIIlllIIllIlI) {
        this.cp = llllllllllllllIlIlIIIIlllIIllIlI;
        this.tag = llllllllllllllIlIlIIIIlllIIlllII;
    }
    
    public abstract void accept(final MemberValueVisitor p0);
    
    abstract Object getValue(final ClassLoader p0, final ClassPool p1, final Method p2) throws ClassNotFoundException;
}
