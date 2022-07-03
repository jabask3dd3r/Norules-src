package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;

public class CtNewConstructor
{
    public static CtConstructor defaultConstructor(final CtClass lllllllllllllIllllIIllIIIIlIIIII) throws CannotCompileException {
        final CtConstructor lllllllllllllIllllIIllIIIIIlllll = new CtConstructor((CtClass[])null, lllllllllllllIllllIIllIIIIlIIIII);
        final ConstPool lllllllllllllIllllIIllIIIIIllllI = lllllllllllllIllllIIllIIIIlIIIII.getClassFile2().getConstPool();
        final Bytecode lllllllllllllIllllIIllIIIIIlllIl = new Bytecode(lllllllllllllIllllIIllIIIIIllllI, 1, 1);
        lllllllllllllIllllIIllIIIIIlllIl.addAload(0);
        try {
            lllllllllllllIllllIIllIIIIIlllIl.addInvokespecial(lllllllllllllIllllIIllIIIIlIIIII.getSuperclass(), "<init>", "()V");
        }
        catch (NotFoundException lllllllllllllIllllIIllIIIIlIIIIl) {
            throw new CannotCompileException(lllllllllllllIllllIIllIIIIlIIIIl);
        }
        lllllllllllllIllllIIllIIIIIlllIl.add(177);
        lllllllllllllIllllIIllIIIIIlllll.getMethodInfo2().setCodeAttribute(lllllllllllllIllllIIllIIIIIlllIl.toCodeAttribute());
        return lllllllllllllIllllIIllIIIIIlllll;
    }
    
    public static CtConstructor copy(final CtConstructor lllllllllllllIllllIIllIIIIlIlIIl, final CtClass lllllllllllllIllllIIllIIIIlIlIll, final ClassMap lllllllllllllIllllIIllIIIIlIlIlI) throws CannotCompileException {
        return new CtConstructor(lllllllllllllIllllIIllIIIIlIlIIl, lllllllllllllIllllIIllIIIIlIlIll, lllllllllllllIllllIIllIIIIlIlIlI);
    }
    
    public static CtConstructor make(final String lllllllllllllIllllIIllIIIlIIIllI, final CtClass lllllllllllllIllllIIllIIIlIIIIlI) throws CannotCompileException {
        final Javac lllllllllllllIllllIIllIIIlIIIlII = new Javac(lllllllllllllIllllIIllIIIlIIIIlI);
        try {
            final CtMember lllllllllllllIllllIIllIIIlIIlIII = lllllllllllllIllllIIllIIIlIIIlII.compile(lllllllllllllIllllIIllIIIlIIIllI);
            if (lllllllllllllIllllIIllIIIlIIlIII instanceof CtConstructor) {
                return (CtConstructor)lllllllllllllIllllIIllIIIlIIlIII;
            }
        }
        catch (CompileError lllllllllllllIllllIIllIIIlIIIlll) {
            throw new CannotCompileException(lllllllllllllIllllIIllIIIlIIIlll);
        }
        throw new CannotCompileException("not a constructor");
    }
    
    public static CtConstructor make(final CtClass[] lllllllllllllIllllIIllIIIIIIlIll, final CtClass[] lllllllllllllIllllIIllIIIIIIlIlI, final CtClass lllllllllllllIllllIIllIIIIIIlIIl) throws CannotCompileException {
        return make(lllllllllllllIllllIIllIIIIIIlIll, lllllllllllllIllllIIllIIIIIIlIlI, 2, null, null, lllllllllllllIllllIIllIIIIIIlIIl);
    }
    
    public static CtConstructor skeleton(final CtClass[] lllllllllllllIllllIIllIIIIIlIlII, final CtClass[] lllllllllllllIllllIIllIIIIIlIIll, final CtClass lllllllllllllIllllIIllIIIIIlIIlI) throws CannotCompileException {
        return make(lllllllllllllIllllIIllIIIIIlIlII, lllllllllllllIllllIIllIIIIIlIIll, 0, null, null, lllllllllllllIllllIIllIIIIIlIIlI);
    }
    
    static {
        PASS_ARRAY = 1;
        PASS_PARAMS = 2;
        PASS_NONE = 0;
    }
    
    public static CtConstructor make(final CtClass[] lllllllllllllIllllIIllIIIIlllIII, final CtClass[] lllllllllllllIllllIIllIIIIllIlll, final String lllllllllllllIllllIIllIIIIllIIlI, final CtClass lllllllllllllIllllIIllIIIIllIIIl) throws CannotCompileException {
        try {
            final CtConstructor lllllllllllllIllllIIllIIIIlllIlI = new CtConstructor(lllllllllllllIllllIIllIIIIlllIII, lllllllllllllIllllIIllIIIIllIIIl);
            lllllllllllllIllllIIllIIIIlllIlI.setExceptionTypes(lllllllllllllIllllIIllIIIIllIlll);
            lllllllllllllIllllIIllIIIIlllIlI.setBody(lllllllllllllIllllIIllIIIIllIIlI);
            return lllllllllllllIllllIIllIIIIlllIlI;
        }
        catch (NotFoundException lllllllllllllIllllIIllIIIIlllIIl) {
            throw new CannotCompileException(lllllllllllllIllllIIllIIIIlllIIl);
        }
    }
    
    public static CtConstructor make(final CtClass[] lllllllllllllIllllIIlIllllllllll, final CtClass[] lllllllllllllIllllIIlIlllllllllI, final int lllllllllllllIllllIIlIllllllllIl, final CtMethod lllllllllllllIllllIIlIllllllllII, final CtMethod.ConstParameter lllllllllllllIllllIIlIllllllIlIl, final CtClass lllllllllllllIllllIIlIlllllllIlI) throws CannotCompileException {
        return CtNewWrappedConstructor.wrapped(lllllllllllllIllllIIlIllllllllll, lllllllllllllIllllIIlIlllllllllI, lllllllllllllIllllIIlIllllllllIl, lllllllllllllIllllIIlIllllllllII, lllllllllllllIllllIIlIllllllIlIl, lllllllllllllIllllIIlIlllllllIlI);
    }
}
