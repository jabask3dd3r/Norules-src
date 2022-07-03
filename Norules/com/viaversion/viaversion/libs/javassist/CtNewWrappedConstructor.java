package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.bytecode.*;

class CtNewWrappedConstructor extends CtNewWrappedMethod
{
    protected static Bytecode makeBody(final CtClass lllllllllllllIIIIIIlIIlIIIllIllI, final ClassFile lllllllllllllIIIIIIlIIlIIIlIlIll, final int lllllllllllllIIIIIIlIIlIIIlIlIlI, final CtMethod lllllllllllllIIIIIIlIIlIIIlIlIII, final CtClass[] lllllllllllllIIIIIIlIIlIIIlIIlll, final CtMethod.ConstParameter lllllllllllllIIIIIIlIIlIIIlIIlIl) throws CannotCompileException {
        final int lllllllllllllIIIIIIlIIlIIIlIllll = lllllllllllllIIIIIIlIIlIIIlIlIll.getSuperclassId();
        final Bytecode lllllllllllllIIIIIIlIIlIIIlIlllI = new Bytecode(lllllllllllllIIIIIIlIIlIIIlIlIll.getConstPool(), 0, 0);
        lllllllllllllIIIIIIlIIlIIIlIlllI.setMaxLocals(false, lllllllllllllIIIIIIlIIlIIIlIIlll, 0);
        lllllllllllllIIIIIIlIIlIIIlIlllI.addAload(0);
        int lllllllllllllIIIIIIlIIlIIIllIIII = 0;
        if (lllllllllllllIIIIIIlIIlIIIlIlIlI == 0) {
            final int lllllllllllllIIIIIIlIIlIIIllllIl = 1;
            lllllllllllllIIIIIIlIIlIIIlIlllI.addInvokespecial(lllllllllllllIIIIIIlIIlIIIlIllll, "<init>", "()V");
        }
        else if (lllllllllllllIIIIIIlIIlIIIlIlIlI == 2) {
            final int lllllllllllllIIIIIIlIIlIIIllllII = lllllllllllllIIIIIIlIIlIIIlIlllI.addLoadParameters(lllllllllllllIIIIIIlIIlIIIlIIlll, 1) + 1;
            lllllllllllllIIIIIIlIIlIIIlIlllI.addInvokespecial(lllllllllllllIIIIIIlIIlIIIlIllll, "<init>", Descriptor.ofConstructor(lllllllllllllIIIIIIlIIlIIIlIIlll));
        }
        else {
            lllllllllllllIIIIIIlIIlIIIllIIII = CtNewWrappedMethod.compileParameterList(lllllllllllllIIIIIIlIIlIIIlIlllI, lllllllllllllIIIIIIlIIlIIIlIIlll, 1);
            int lllllllllllllIIIIIIlIIlIIIlllIII = 0;
            String lllllllllllllIIIIIIlIIlIIIlllIIl = null;
            if (lllllllllllllIIIIIIlIIlIIIlIIlIl == null) {
                final int lllllllllllllIIIIIIlIIlIIIlllIll = 2;
                final String lllllllllllllIIIIIIlIIlIIIlllIlI = CtMethod.ConstParameter.defaultConstDescriptor();
            }
            else {
                lllllllllllllIIIIIIlIIlIIIlllIII = lllllllllllllIIIIIIlIIlIIIlIIlIl.compile(lllllllllllllIIIIIIlIIlIIIlIlllI) + 2;
                lllllllllllllIIIIIIlIIlIIIlllIIl = lllllllllllllIIIIIIlIIlIIIlIIlIl.constDescriptor();
            }
            if (lllllllllllllIIIIIIlIIlIIIllIIII < lllllllllllllIIIIIIlIIlIIIlllIII) {
                lllllllllllllIIIIIIlIIlIIIllIIII = lllllllllllllIIIIIIlIIlIIIlllIII;
            }
            lllllllllllllIIIIIIlIIlIIIlIlllI.addInvokespecial(lllllllllllllIIIIIIlIIlIIIlIllll, "<init>", lllllllllllllIIIIIIlIIlIIIlllIIl);
        }
        if (lllllllllllllIIIIIIlIIlIIIlIlIII == null) {
            lllllllllllllIIIIIIlIIlIIIlIlllI.add(177);
        }
        else {
            final int lllllllllllllIIIIIIlIIlIIIllIlll = CtNewWrappedMethod.makeBody0(lllllllllllllIIIIIIlIIlIIIllIllI, lllllllllllllIIIIIIlIIlIIIlIlIll, lllllllllllllIIIIIIlIIlIIIlIlIII, false, lllllllllllllIIIIIIlIIlIIIlIIlll, CtClass.voidType, lllllllllllllIIIIIIlIIlIIIlIIlIl, lllllllllllllIIIIIIlIIlIIIlIlllI);
            if (lllllllllllllIIIIIIlIIlIIIllIIII < lllllllllllllIIIIIIlIIlIIIllIlll) {
                lllllllllllllIIIIIIlIIlIIIllIIII = lllllllllllllIIIIIIlIIlIIIllIlll;
            }
        }
        lllllllllllllIIIIIIlIIlIIIlIlllI.setMaxStack(lllllllllllllIIIIIIlIIlIIIllIIII);
        return lllllllllllllIIIIIIlIIlIIIlIlllI;
    }
    
    static {
        PASS_PARAMS = 2;
        PASS_NONE = 0;
    }
    
    public static CtConstructor wrapped(final CtClass[] lllllllllllllIIIIIIlIIlIIlIlIIII, final CtClass[] lllllllllllllIIIIIIlIIlIIlIlIlIl, final int lllllllllllllIIIIIIlIIlIIlIIlllI, final CtMethod lllllllllllllIIIIIIlIIlIIlIlIIll, final CtMethod.ConstParameter lllllllllllllIIIIIIlIIlIIlIlIIlI, final CtClass lllllllllllllIIIIIIlIIlIIlIIlIll) throws CannotCompileException {
        try {
            final CtConstructor lllllllllllllIIIIIIlIIlIIlIllIIl = new CtConstructor(lllllllllllllIIIIIIlIIlIIlIlIIII, lllllllllllllIIIIIIlIIlIIlIIlIll);
            lllllllllllllIIIIIIlIIlIIlIllIIl.setExceptionTypes(lllllllllllllIIIIIIlIIlIIlIlIlIl);
            final Bytecode lllllllllllllIIIIIIlIIlIIlIllIII = makeBody(lllllllllllllIIIIIIlIIlIIlIIlIll, lllllllllllllIIIIIIlIIlIIlIIlIll.getClassFile2(), lllllllllllllIIIIIIlIIlIIlIIlllI, lllllllllllllIIIIIIlIIlIIlIlIIll, lllllllllllllIIIIIIlIIlIIlIlIIII, lllllllllllllIIIIIIlIIlIIlIlIIlI);
            lllllllllllllIIIIIIlIIlIIlIllIIl.getMethodInfo2().setCodeAttribute(lllllllllllllIIIIIIlIIlIIlIllIII.toCodeAttribute());
            return lllllllllllllIIIIIIlIIlIIlIllIIl;
        }
        catch (NotFoundException lllllllllllllIIIIIIlIIlIIlIlIlll) {
            throw new CannotCompileException(lllllllllllllIIIIIIlIIlIIlIlIlll);
        }
    }
}
