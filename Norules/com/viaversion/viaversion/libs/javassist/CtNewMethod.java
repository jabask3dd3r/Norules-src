package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.util.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;

public class CtNewMethod
{
    public static CtMethod wrapped(final CtClass llllllllllllllIlIIIlIIllIIIlllII, final String llllllllllllllIlIIIlIIllIIIllIll, final CtClass[] llllllllllllllIlIIIlIIllIIIllIlI, final CtClass[] llllllllllllllIlIIIlIIllIIIllIIl, final CtMethod llllllllllllllIlIIIlIIllIIIlIIIl, final CtMethod.ConstParameter llllllllllllllIlIIIlIIllIIIlIlll, final CtClass llllllllllllllIlIIIlIIllIIIIllll) throws CannotCompileException {
        return CtNewWrappedMethod.wrapped(llllllllllllllIlIIIlIIllIIIlllII, llllllllllllllIlIIIlIIllIIIllIll, llllllllllllllIlIIIlIIllIIIllIlI, llllllllllllllIlIIIlIIllIIIllIIl, llllllllllllllIlIIIlIIllIIIlIIIl, llllllllllllllIlIIIlIIllIIIlIlll, llllllllllllllIlIIIlIIllIIIIllll);
    }
    
    public static CtMethod getter(final String llllllllllllllIlIIIlIIllIllllIlI, final CtField llllllllllllllIlIIIlIIlllIIIIIlI) throws CannotCompileException {
        final FieldInfo llllllllllllllIlIIIlIIlllIIIIIIl = llllllllllllllIlIIIlIIlllIIIIIlI.getFieldInfo2();
        final String llllllllllllllIlIIIlIIlllIIIIIII = llllllllllllllIlIIIlIIlllIIIIIIl.getDescriptor();
        final String llllllllllllllIlIIIlIIllIlllllll = String.valueOf(new StringBuilder().append("()").append(llllllllllllllIlIIIlIIlllIIIIIII));
        final ConstPool llllllllllllllIlIIIlIIllIllllllI = llllllllllllllIlIIIlIIlllIIIIIIl.getConstPool();
        final MethodInfo llllllllllllllIlIIIlIIllIlllllIl = new MethodInfo(llllllllllllllIlIIIlIIllIllllllI, llllllllllllllIlIIIlIIllIllllIlI, llllllllllllllIlIIIlIIllIlllllll);
        llllllllllllllIlIIIlIIllIlllllIl.setAccessFlags(1);
        final Bytecode llllllllllllllIlIIIlIIllIlllllII = new Bytecode(llllllllllllllIlIIIlIIllIllllllI, 2, 1);
        try {
            final String llllllllllllllIlIIIlIIlllIIIIlIl = llllllllllllllIlIIIlIIlllIIIIIIl.getName();
            if ((llllllllllllllIlIIIlIIlllIIIIIIl.getAccessFlags() & 0x8) == 0x0) {
                llllllllllllllIlIIIlIIllIlllllII.addAload(0);
                llllllllllllllIlIIIlIIllIlllllII.addGetfield(Bytecode.THIS, llllllllllllllIlIIIlIIlllIIIIlIl, llllllllllllllIlIIIlIIlllIIIIIII);
            }
            else {
                llllllllllllllIlIIIlIIllIlllllII.addGetstatic(Bytecode.THIS, llllllllllllllIlIIIlIIlllIIIIlIl, llllllllllllllIlIIIlIIlllIIIIIII);
            }
            llllllllllllllIlIIIlIIllIlllllII.addReturn(llllllllllllllIlIIIlIIlllIIIIIlI.getType());
        }
        catch (NotFoundException llllllllllllllIlIIIlIIlllIIIIlII) {
            throw new CannotCompileException(llllllllllllllIlIIIlIIlllIIIIlII);
        }
        llllllllllllllIlIIIlIIllIlllllIl.setCodeAttribute(llllllllllllllIlIIIlIIllIlllllII.toCodeAttribute());
        final CtClass llllllllllllllIlIIIlIIllIllllIll = llllllllllllllIlIIIlIIlllIIIIIlI.getDeclaringClass();
        return new CtMethod(llllllllllllllIlIIIlIIllIlllllIl, llllllllllllllIlIIIlIIllIllllIll);
    }
    
    public static CtMethod delegator(final CtMethod llllllllllllllIlIIIlIIllIlIlIIII, final CtClass llllllllllllllIlIIIlIIllIlIIllIl) throws CannotCompileException {
        try {
            return delegator0(llllllllllllllIlIIIlIIllIlIlIIII, llllllllllllllIlIIIlIIllIlIIllIl);
        }
        catch (NotFoundException llllllllllllllIlIIIlIIllIlIlIIIl) {
            throw new CannotCompileException(llllllllllllllIlIIIlIIllIlIlIIIl);
        }
    }
    
    public static CtMethod make(final int llllllllllllllIlIIIlIIllllIIIlll, final CtClass llllllllllllllIlIIIlIIllllIIIllI, final String llllllllllllllIlIIIlIIlllIlllllI, final CtClass[] llllllllllllllIlIIIlIIlllIllllIl, final CtClass[] llllllllllllllIlIIIlIIllllIIIIll, final String llllllllllllllIlIIIlIIlllIlllIll, final CtClass llllllllllllllIlIIIlIIlllIlllIlI) throws CannotCompileException {
        try {
            final CtMethod llllllllllllllIlIIIlIIllllIIlIIl = new CtMethod(llllllllllllllIlIIIlIIllllIIIllI, llllllllllllllIlIIIlIIlllIlllllI, llllllllllllllIlIIIlIIlllIllllIl, llllllllllllllIlIIIlIIlllIlllIlI);
            llllllllllllllIlIIIlIIllllIIlIIl.setModifiers(llllllllllllllIlIIIlIIllllIIIlll);
            llllllllllllllIlIIIlIIllllIIlIIl.setExceptionTypes(llllllllllllllIlIIIlIIllllIIIIll);
            llllllllllllllIlIIIlIIllllIIlIIl.setBody(llllllllllllllIlIIIlIIlllIlllIll);
            return llllllllllllllIlIIIlIIllllIIlIIl;
        }
        catch (NotFoundException llllllllllllllIlIIIlIIllllIIlIII) {
            throw new CannotCompileException(llllllllllllllIlIIIlIIllllIIlIII);
        }
    }
    
    public static CtMethod make(final CtClass llllllllllllllIlIIIlIIllllIlllIl, final String llllllllllllllIlIIIlIIllllIlIllI, final CtClass[] llllllllllllllIlIIIlIIllllIllIll, final CtClass[] llllllllllllllIlIIIlIIllllIlIlII, final String llllllllllllllIlIIIlIIllllIllIIl, final CtClass llllllllllllllIlIIIlIIllllIllIII) throws CannotCompileException {
        return make(1, llllllllllllllIlIIIlIIllllIlllIl, llllllllllllllIlIIIlIIllllIlIllI, llllllllllllllIlIIIlIIllllIllIll, llllllllllllllIlIIIlIIllllIlIlII, llllllllllllllIlIIIlIIllllIllIIl, llllllllllllllIlIIIlIIllllIllIII);
    }
    
    public static CtMethod abstractMethod(final CtClass llllllllllllllIlIIIlIIlllIIllIlI, final String llllllllllllllIlIIIlIIlllIIlIIll, final CtClass[] llllllllllllllIlIIIlIIlllIIlIIlI, final CtClass[] llllllllllllllIlIIIlIIlllIIlIIIl, final CtClass llllllllllllllIlIIIlIIlllIIlIIII) throws NotFoundException {
        final CtMethod llllllllllllllIlIIIlIIlllIIlIlIl = new CtMethod(llllllllllllllIlIIIlIIlllIIllIlI, llllllllllllllIlIIIlIIlllIIlIIll, llllllllllllllIlIIIlIIlllIIlIIlI, llllllllllllllIlIIIlIIlllIIlIIII);
        llllllllllllllIlIIIlIIlllIIlIlIl.setExceptionTypes(llllllllllllllIlIIIlIIlllIIlIIIl);
        return llllllllllllllIlIIIlIIlllIIlIlIl;
    }
    
    public static CtMethod setter(final String llllllllllllllIlIIIlIIllIllIIllI, final CtField llllllllllllllIlIIIlIIllIllIIlIl) throws CannotCompileException {
        final FieldInfo llllllllllllllIlIIIlIIllIllIIlII = llllllllllllllIlIIIlIIllIllIIlIl.getFieldInfo2();
        final String llllllllllllllIlIIIlIIllIllIIIll = llllllllllllllIlIIIlIIllIllIIlII.getDescriptor();
        final String llllllllllllllIlIIIlIIllIllIIIlI = String.valueOf(new StringBuilder().append("(").append(llllllllllllllIlIIIlIIllIllIIIll).append(")V"));
        final ConstPool llllllllllllllIlIIIlIIllIllIIIIl = llllllllllllllIlIIIlIIllIllIIlII.getConstPool();
        final MethodInfo llllllllllllllIlIIIlIIllIllIIIII = new MethodInfo(llllllllllllllIlIIIlIIllIllIIIIl, llllllllllllllIlIIIlIIllIllIIllI, llllllllllllllIlIIIlIIllIllIIIlI);
        llllllllllllllIlIIIlIIllIllIIIII.setAccessFlags(1);
        final Bytecode llllllllllllllIlIIIlIIllIlIlllll = new Bytecode(llllllllllllllIlIIIlIIllIllIIIIl, 3, 3);
        try {
            final String llllllllllllllIlIIIlIIllIllIlIII = llllllllllllllIlIIIlIIllIllIIlII.getName();
            if ((llllllllllllllIlIIIlIIllIllIIlII.getAccessFlags() & 0x8) == 0x0) {
                llllllllllllllIlIIIlIIllIlIlllll.addAload(0);
                llllllllllllllIlIIIlIIllIlIlllll.addLoad(1, llllllllllllllIlIIIlIIllIllIIlIl.getType());
                llllllllllllllIlIIIlIIllIlIlllll.addPutfield(Bytecode.THIS, llllllllllllllIlIIIlIIllIllIlIII, llllllllllllllIlIIIlIIllIllIIIll);
            }
            else {
                llllllllllllllIlIIIlIIllIlIlllll.addLoad(1, llllllllllllllIlIIIlIIllIllIIlIl.getType());
                llllllllllllllIlIIIlIIllIlIlllll.addPutstatic(Bytecode.THIS, llllllllllllllIlIIIlIIllIllIlIII, llllllllllllllIlIIIlIIllIllIIIll);
            }
            llllllllllllllIlIIIlIIllIlIlllll.addReturn(null);
        }
        catch (NotFoundException llllllllllllllIlIIIlIIllIllIIlll) {
            throw new CannotCompileException(llllllllllllllIlIIIlIIllIllIIlll);
        }
        llllllllllllllIlIIIlIIllIllIIIII.setCodeAttribute(llllllllllllllIlIIIlIIllIlIlllll.toCodeAttribute());
        final CtClass llllllllllllllIlIIIlIIllIlIllllI = llllllllllllllIlIIIlIIllIllIIlIl.getDeclaringClass();
        return new CtMethod(llllllllllllllIlIIIlIIllIllIIIII, llllllllllllllIlIIIlIIllIlIllllI);
    }
    
    public static CtMethod copy(final CtMethod llllllllllllllIlIIIlIIlllIlIlIlI, final String llllllllllllllIlIIIlIIlllIlIIlII, final CtClass llllllllllllllIlIIIlIIlllIlIIIll, final ClassMap llllllllllllllIlIIIlIIlllIlIIIlI) throws CannotCompileException {
        final CtMethod llllllllllllllIlIIIlIIlllIlIIllI = new CtMethod(llllllllllllllIlIIIlIIlllIlIlIlI, llllllllllllllIlIIIlIIlllIlIIIll, llllllllllllllIlIIIlIIlllIlIIIlI);
        llllllllllllllIlIIIlIIlllIlIIllI.setName(llllllllllllllIlIIIlIIlllIlIIlII);
        return llllllllllllllIlIIIlIIlllIlIIllI;
    }
    
    private static CtMethod delegator0(final CtMethod llllllllllllllIlIIIlIIllIIllIIII, final CtClass llllllllllllllIlIIIlIIllIIllllII) throws CannotCompileException, NotFoundException {
        final MethodInfo llllllllllllllIlIIIlIIllIIlllIll = llllllllllllllIlIIIlIIllIIllIIII.getMethodInfo2();
        final String llllllllllllllIlIIIlIIllIIlllIlI = llllllllllllllIlIIIlIIllIIlllIll.getName();
        final String llllllllllllllIlIIIlIIllIIlllIIl = llllllllllllllIlIIIlIIllIIlllIll.getDescriptor();
        final ConstPool llllllllllllllIlIIIlIIllIIlllIII = llllllllllllllIlIIIlIIllIIllllII.getClassFile2().getConstPool();
        final MethodInfo llllllllllllllIlIIIlIIllIIllIlll = new MethodInfo(llllllllllllllIlIIIlIIllIIlllIII, llllllllllllllIlIIIlIIllIIlllIlI, llllllllllllllIlIIIlIIllIIlllIIl);
        llllllllllllllIlIIIlIIllIIllIlll.setAccessFlags(llllllllllllllIlIIIlIIllIIlllIll.getAccessFlags());
        final ExceptionsAttribute llllllllllllllIlIIIlIIllIIllIllI = llllllllllllllIlIIIlIIllIIlllIll.getExceptionsAttribute();
        if (llllllllllllllIlIIIlIIllIIllIllI != null) {
            llllllllllllllIlIIIlIIllIIllIlll.setExceptionsAttribute((ExceptionsAttribute)llllllllllllllIlIIIlIIllIIllIllI.copy(llllllllllllllIlIIIlIIllIIlllIII, null));
        }
        final Bytecode llllllllllllllIlIIIlIIllIIllIlIl = new Bytecode(llllllllllllllIlIIIlIIllIIlllIII, 0, 0);
        final boolean llllllllllllllIlIIIlIIllIIllIlII = Modifier.isStatic(llllllllllllllIlIIIlIIllIIllIIII.getModifiers());
        final CtClass llllllllllllllIlIIIlIIllIIllIIll = llllllllllllllIlIIIlIIllIIllIIII.getDeclaringClass();
        final CtClass[] llllllllllllllIlIIIlIIllIIllIIlI = llllllllllllllIlIIIlIIllIIllIIII.getParameterTypes();
        int llllllllllllllIlIIIlIIllIIllIIIl = 0;
        if (llllllllllllllIlIIIlIIllIIllIlII) {
            final int llllllllllllllIlIIIlIIllIIlllllI = llllllllllllllIlIIIlIIllIIllIlIl.addLoadParameters(llllllllllllllIlIIIlIIllIIllIIlI, 0);
            llllllllllllllIlIIIlIIllIIllIlIl.addInvokestatic(llllllllllllllIlIIIlIIllIIllIIll, llllllllllllllIlIIIlIIllIIlllIlI, llllllllllllllIlIIIlIIllIIlllIIl);
        }
        else {
            llllllllllllllIlIIIlIIllIIllIlIl.addLoad(0, llllllllllllllIlIIIlIIllIIllIIll);
            llllllllllllllIlIIIlIIllIIllIIIl = llllllllllllllIlIIIlIIllIIllIlIl.addLoadParameters(llllllllllllllIlIIIlIIllIIllIIlI, 1);
            llllllllllllllIlIIIlIIllIIllIlIl.addInvokespecial(llllllllllllllIlIIIlIIllIIllIIll, llllllllllllllIlIIIlIIllIIlllIlI, llllllllllllllIlIIIlIIllIIlllIIl);
        }
        llllllllllllllIlIIIlIIllIIllIlIl.addReturn(llllllllllllllIlIIIlIIllIIllIIII.getReturnType());
        llllllllllllllIlIIIlIIllIIllIlIl.setMaxLocals(++llllllllllllllIlIIIlIIllIIllIIIl);
        llllllllllllllIlIIIlIIllIIllIlIl.setMaxStack((llllllllllllllIlIIIlIIllIIllIIIl < 2) ? 2 : llllllllllllllIlIIIlIIllIIllIIIl);
        llllllllllllllIlIIIlIIllIIllIlll.setCodeAttribute(llllllllllllllIlIIIlIIllIIllIlIl.toCodeAttribute());
        return new CtMethod(llllllllllllllIlIIIlIIllIIllIlll, llllllllllllllIlIIIlIIllIIllllII);
    }
    
    public static CtMethod make(final String llllllllllllllIlIIIlIIlllllllIII, final CtClass llllllllllllllIlIIIlIIllllllIlll) throws CannotCompileException {
        return make(llllllllllllllIlIIIlIIlllllllIII, llllllllllllllIlIIIlIIllllllIlll, null, null);
    }
    
    public static CtMethod make(final String llllllllllllllIlIIIlIIlllllIlllI, final CtClass llllllllllllllIlIIIlIIlllllIllIl, final String llllllllllllllIlIIIlIIlllllIllII, final String llllllllllllllIlIIIlIIlllllIIllI) throws CannotCompileException {
        final Javac llllllllllllllIlIIIlIIlllllIlIlI = new Javac(llllllllllllllIlIIIlIIlllllIllIl);
        try {
            if (llllllllllllllIlIIIlIIlllllIIllI != null) {
                llllllllllllllIlIIIlIIlllllIlIlI.recordProceed(llllllllllllllIlIIIlIIlllllIllII, llllllllllllllIlIIIlIIlllllIIllI);
            }
            final CtMember llllllllllllllIlIIIlIIllllllIIII = llllllllllllllIlIIIlIIlllllIlIlI.compile(llllllllllllllIlIIIlIIlllllIlllI);
            if (llllllllllllllIlIIIlIIllllllIIII instanceof CtMethod) {
                return (CtMethod)llllllllllllllIlIIIlIIllllllIIII;
            }
        }
        catch (CompileError llllllllllllllIlIIIlIIlllllIllll) {
            throw new CannotCompileException(llllllllllllllIlIIIlIIlllllIllll);
        }
        throw new CannotCompileException("not a method");
    }
    
    public static CtMethod copy(final CtMethod llllllllllllllIlIIIlIIlllIllIlIl, final CtClass llllllllllllllIlIIIlIIlllIllIlII, final ClassMap llllllllllllllIlIIIlIIlllIllIIII) throws CannotCompileException {
        return new CtMethod(llllllllllllllIlIIIlIIlllIllIlIl, llllllllllllllIlIIIlIIlllIllIlII, llllllllllllllIlIIIlIIlllIllIIII);
    }
}
