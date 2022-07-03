package com.viaversion.viaversion.libs.javassist.compiler;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class AccessorMaker
{
    private /* synthetic */ int uniqueNumber;
    private /* synthetic */ CtClass clazz;
    private /* synthetic */ Map<String, Object> accessors;
    
    public AccessorMaker(final CtClass lllllllllllllIIlIlIIIllIlIIIIIlI) {
        this.clazz = lllllllllllllIIlIlIIIllIlIIIIIlI;
        this.uniqueNumber = 1;
        this.accessors = new HashMap<String, Object>();
    }
    
    private String findAccessorName(final ClassFile lllllllllllllIIlIlIIIlIllIIlllII) {
        String lllllllllllllIIlIlIIIlIllIIllllI;
        do {
            lllllllllllllIIlIlIIIlIllIIllllI = String.valueOf(new StringBuilder().append("access$").append(this.uniqueNumber++));
        } while (lllllllllllllIIlIlIIIlIllIIlllII.getMethod(lllllllllllllIIlIlIIIlIllIIllllI) != null);
        return lllllllllllllIIlIlIIIlIllIIllllI;
    }
    
    static {
        lastParamType = "com.viaversion.viaversion.libs.javassist.runtime.Inner";
    }
    
    public MethodInfo getFieldSetter(final FieldInfo lllllllllllllIIlIlIIIlIllIllIIIl, final boolean lllllllllllllIIlIlIIIlIllIlllIII) throws CompileError {
        final String lllllllllllllIIlIlIIIlIllIllIlll = lllllllllllllIIlIlIIIlIllIllIIIl.getName();
        final String lllllllllllllIIlIlIIIlIllIllIllI = String.valueOf(new StringBuilder().append(lllllllllllllIIlIlIIIlIllIllIlll).append(":setter"));
        final Object lllllllllllllIIlIlIIIlIllIllIlIl = this.accessors.get(lllllllllllllIIlIlIIIlIllIllIllI);
        if (lllllllllllllIIlIlIIIlIllIllIlIl != null) {
            return (MethodInfo)lllllllllllllIIlIlIIIlIllIllIlIl;
        }
        final ClassFile lllllllllllllIIlIlIIIlIllIllIlII = this.clazz.getClassFile();
        final String lllllllllllllIIlIlIIIlIllIllIIll = this.findAccessorName(lllllllllllllIIlIlIIIlIllIllIlII);
        try {
            final ConstPool lllllllllllllIIlIlIIIlIlllIIIIll = lllllllllllllIIlIlIIIlIllIllIlII.getConstPool();
            final ClassPool lllllllllllllIIlIlIIIlIlllIIIIlI = this.clazz.getClassPool();
            final String lllllllllllllIIlIlIIIlIlllIIIIIl = lllllllllllllIIlIlIIIlIllIllIIIl.getDescriptor();
            String lllllllllllllIIlIlIIIlIlllIIIIII = null;
            if (lllllllllllllIIlIlIIIlIllIlllIII) {
                final String lllllllllllllIIlIlIIIlIlllIIIlIl = String.valueOf(new StringBuilder().append("(").append(lllllllllllllIIlIlIIIlIlllIIIIIl).append(")V"));
            }
            else {
                lllllllllllllIIlIlIIIlIlllIIIIII = String.valueOf(new StringBuilder().append("(").append(Descriptor.of(this.clazz)).append(lllllllllllllIIlIlIIIlIlllIIIIIl).append(")V"));
            }
            final MethodInfo lllllllllllllIIlIlIIIlIllIllllll = new MethodInfo(lllllllllllllIIlIlIIIlIlllIIIIll, lllllllllllllIIlIlIIIlIllIllIIll, lllllllllllllIIlIlIIIlIlllIIIIII);
            lllllllllllllIIlIlIIIlIllIllllll.setAccessFlags(8);
            lllllllllllllIIlIlIIIlIllIllllll.addAttribute(new SyntheticAttribute(lllllllllllllIIlIlIIIlIlllIIIIll));
            final Bytecode lllllllllllllIIlIlIIIlIllIlllllI = new Bytecode(lllllllllllllIIlIlIIIlIlllIIIIll);
            int lllllllllllllIIlIlIIIlIllIllllIl = 0;
            if (lllllllllllllIIlIlIIIlIllIlllIII) {
                final int lllllllllllllIIlIlIIIlIlllIIIlII = lllllllllllllIIlIlIIIlIllIlllllI.addLoad(0, Descriptor.toCtClass(lllllllllllllIIlIlIIIlIlllIIIIIl, lllllllllllllIIlIlIIIlIlllIIIIlI));
                lllllllllllllIIlIlIIIlIllIlllllI.addPutstatic(Bytecode.THIS, lllllllllllllIIlIlIIIlIllIllIlll, lllllllllllllIIlIlIIIlIlllIIIIIl);
            }
            else {
                lllllllllllllIIlIlIIIlIllIlllllI.addAload(0);
                lllllllllllllIIlIlIIIlIllIllllIl = lllllllllllllIIlIlIIIlIllIlllllI.addLoad(1, Descriptor.toCtClass(lllllllllllllIIlIlIIIlIlllIIIIIl, lllllllllllllIIlIlIIIlIlllIIIIlI)) + 1;
                lllllllllllllIIlIlIIIlIllIlllllI.addPutfield(Bytecode.THIS, lllllllllllllIIlIlIIIlIllIllIlll, lllllllllllllIIlIlIIIlIlllIIIIIl);
            }
            lllllllllllllIIlIlIIIlIllIlllllI.addReturn(null);
            lllllllllllllIIlIlIIIlIllIlllllI.setMaxLocals(lllllllllllllIIlIlIIIlIllIllllIl);
            lllllllllllllIIlIlIIIlIllIllllll.setCodeAttribute(lllllllllllllIIlIlIIIlIllIlllllI.toCodeAttribute());
            lllllllllllllIIlIlIIIlIllIllIlII.addMethod(lllllllllllllIIlIlIIIlIllIllllll);
            this.accessors.put(lllllllllllllIIlIlIIIlIllIllIllI, lllllllllllllIIlIlIIIlIllIllllll);
            return lllllllllllllIIlIlIIIlIllIllllll;
        }
        catch (CannotCompileException lllllllllllllIIlIlIIIlIllIllllII) {
            throw new CompileError(lllllllllllllIIlIlIIIlIllIllllII);
        }
        catch (NotFoundException lllllllllllllIIlIlIIIlIllIlllIll) {
            throw new CompileError(lllllllllllllIIlIlIIIlIllIlllIll);
        }
    }
    
    public MethodInfo getFieldGetter(final FieldInfo lllllllllllllIIlIlIIIlIllllIIIIl, final boolean lllllllllllllIIlIlIIIlIllllIIIII) throws CompileError {
        final String lllllllllllllIIlIlIIIlIllllIIlll = lllllllllllllIIlIlIIIlIllllIIIIl.getName();
        final String lllllllllllllIIlIlIIIlIllllIIllI = String.valueOf(new StringBuilder().append(lllllllllllllIIlIlIIIlIllllIIlll).append(":getter"));
        final Object lllllllllllllIIlIlIIIlIllllIIlIl = this.accessors.get(lllllllllllllIIlIlIIIlIllllIIllI);
        if (lllllllllllllIIlIlIIIlIllllIIlIl != null) {
            return (MethodInfo)lllllllllllllIIlIlIIIlIllllIIlIl;
        }
        final ClassFile lllllllllllllIIlIlIIIlIllllIIlII = this.clazz.getClassFile();
        final String lllllllllllllIIlIlIIIlIllllIIIll = this.findAccessorName(lllllllllllllIIlIlIIIlIllllIIlII);
        try {
            final ConstPool lllllllllllllIIlIlIIIlIlllllIIlI = lllllllllllllIIlIlIIIlIllllIIlII.getConstPool();
            final ClassPool lllllllllllllIIlIlIIIlIlllllIIIl = this.clazz.getClassPool();
            final String lllllllllllllIIlIlIIIlIlllllIIII = lllllllllllllIIlIlIIIlIllllIIIIl.getDescriptor();
            String lllllllllllllIIlIlIIIlIllllIllll = null;
            if (lllllllllllllIIlIlIIIlIllllIIIII) {
                final String lllllllllllllIIlIlIIIlIlllllIIll = String.valueOf(new StringBuilder().append("()").append(lllllllllllllIIlIlIIIlIlllllIIII));
            }
            else {
                lllllllllllllIIlIlIIIlIllllIllll = String.valueOf(new StringBuilder().append("(").append(Descriptor.of(this.clazz)).append(")").append(lllllllllllllIIlIlIIIlIlllllIIII));
            }
            final MethodInfo lllllllllllllIIlIlIIIlIllllIlllI = new MethodInfo(lllllllllllllIIlIlIIIlIlllllIIlI, lllllllllllllIIlIlIIIlIllllIIIll, lllllllllllllIIlIlIIIlIllllIllll);
            lllllllllllllIIlIlIIIlIllllIlllI.setAccessFlags(8);
            lllllllllllllIIlIlIIIlIllllIlllI.addAttribute(new SyntheticAttribute(lllllllllllllIIlIlIIIlIlllllIIlI));
            final Bytecode lllllllllllllIIlIlIIIlIllllIllIl = new Bytecode(lllllllllllllIIlIlIIIlIlllllIIlI);
            if (lllllllllllllIIlIlIIIlIllllIIIII) {
                lllllllllllllIIlIlIIIlIllllIllIl.addGetstatic(Bytecode.THIS, lllllllllllllIIlIlIIIlIllllIIlll, lllllllllllllIIlIlIIIlIlllllIIII);
            }
            else {
                lllllllllllllIIlIlIIIlIllllIllIl.addAload(0);
                lllllllllllllIIlIlIIIlIllllIllIl.addGetfield(Bytecode.THIS, lllllllllllllIIlIlIIIlIllllIIlll, lllllllllllllIIlIlIIIlIlllllIIII);
                lllllllllllllIIlIlIIIlIllllIllIl.setMaxLocals(1);
            }
            lllllllllllllIIlIlIIIlIllllIllIl.addReturn(Descriptor.toCtClass(lllllllllllllIIlIlIIIlIlllllIIII, lllllllllllllIIlIlIIIlIlllllIIIl));
            lllllllllllllIIlIlIIIlIllllIlllI.setCodeAttribute(lllllllllllllIIlIlIIIlIllllIllIl.toCodeAttribute());
            lllllllllllllIIlIlIIIlIllllIIlII.addMethod(lllllllllllllIIlIlIIIlIllllIlllI);
            this.accessors.put(lllllllllllllIIlIlIIIlIllllIIllI, lllllllllllllIIlIlIIIlIllllIlllI);
            return lllllllllllllIIlIlIIIlIllllIlllI;
        }
        catch (CannotCompileException lllllllllllllIIlIlIIIlIllllIllII) {
            throw new CompileError(lllllllllllllIIlIlIIIlIllllIllII);
        }
        catch (NotFoundException lllllllllllllIIlIlIIIlIllllIlIll) {
            throw new CompileError(lllllllllllllIIlIlIIIlIllllIlIll);
        }
    }
    
    public String getConstructor(final CtClass lllllllllllllIIlIlIIIllIIllIIllI, final String lllllllllllllIIlIlIIIllIIllIIlIl, final MethodInfo lllllllllllllIIlIlIIIllIIllIIlII) throws CompileError {
        final String lllllllllllllIIlIlIIIllIIllIIIll = String.valueOf(new StringBuilder().append("<init>:").append(lllllllllllllIIlIlIIIllIIllIIlIl));
        String lllllllllllllIIlIlIIIllIIllIIIlI = this.accessors.get(lllllllllllllIIlIlIIIllIIllIIIll);
        if (lllllllllllllIIlIlIIIllIIllIIIlI != null) {
            return lllllllllllllIIlIlIIIllIIllIIIlI;
        }
        lllllllllllllIIlIlIIIllIIllIIIlI = Descriptor.appendParameter("com.viaversion.viaversion.libs.javassist.runtime.Inner", lllllllllllllIIlIlIIIllIIllIIlIl);
        final ClassFile lllllllllllllIIlIlIIIllIIllIIIIl = this.clazz.getClassFile();
        try {
            final ConstPool lllllllllllllIIlIlIIIllIIlllIIII = lllllllllllllIIlIlIIIllIIllIIIIl.getConstPool();
            final ClassPool lllllllllllllIIlIlIIIllIIllIllll = this.clazz.getClassPool();
            final MethodInfo lllllllllllllIIlIlIIIllIIllIlllI = new MethodInfo(lllllllllllllIIlIlIIIllIIlllIIII, "<init>", lllllllllllllIIlIlIIIllIIllIIIlI);
            lllllllllllllIIlIlIIIllIIllIlllI.setAccessFlags(0);
            lllllllllllllIIlIlIIIllIIllIlllI.addAttribute(new SyntheticAttribute(lllllllllllllIIlIlIIIllIIlllIIII));
            final ExceptionsAttribute lllllllllllllIIlIlIIIllIIllIllIl = lllllllllllllIIlIlIIIllIIllIIlII.getExceptionsAttribute();
            if (lllllllllllllIIlIlIIIllIIllIllIl != null) {
                lllllllllllllIIlIlIIIllIIllIlllI.addAttribute(lllllllllllllIIlIlIIIllIIllIllIl.copy(lllllllllllllIIlIlIIIllIIlllIIII, null));
            }
            final CtClass[] lllllllllllllIIlIlIIIllIIllIllII = Descriptor.getParameterTypes(lllllllllllllIIlIlIIIllIIllIIlIl, lllllllllllllIIlIlIIIllIIllIllll);
            final Bytecode lllllllllllllIIlIlIIIllIIllIlIll = new Bytecode(lllllllllllllIIlIlIIIllIIlllIIII);
            lllllllllllllIIlIlIIIllIIllIlIll.addAload(0);
            int lllllllllllllIIlIlIIIllIIllIlIlI = 1;
            for (int lllllllllllllIIlIlIIIllIIlllIIIl = 0; lllllllllllllIIlIlIIIllIIlllIIIl < lllllllllllllIIlIlIIIllIIllIllII.length; ++lllllllllllllIIlIlIIIllIIlllIIIl) {
                lllllllllllllIIlIlIIIllIIllIlIlI += lllllllllllllIIlIlIIIllIIllIlIll.addLoad(lllllllllllllIIlIlIIIllIIllIlIlI, lllllllllllllIIlIlIIIllIIllIllII[lllllllllllllIIlIlIIIllIIlllIIIl]);
            }
            lllllllllllllIIlIlIIIllIIllIlIll.setMaxLocals(lllllllllllllIIlIlIIIllIIllIlIlI + 1);
            lllllllllllllIIlIlIIIllIIllIlIll.addInvokespecial(this.clazz, "<init>", lllllllllllllIIlIlIIIllIIllIIlIl);
            lllllllllllllIIlIlIIIllIIllIlIll.addReturn(null);
            lllllllllllllIIlIlIIIllIIllIlllI.setCodeAttribute(lllllllllllllIIlIlIIIllIIllIlIll.toCodeAttribute());
            lllllllllllllIIlIlIIIllIIllIIIIl.addMethod(lllllllllllllIIlIlIIIllIIllIlllI);
        }
        catch (CannotCompileException lllllllllllllIIlIlIIIllIIllIlIIl) {
            throw new CompileError(lllllllllllllIIlIlIIIllIIllIlIIl);
        }
        catch (NotFoundException lllllllllllllIIlIlIIIllIIllIlIII) {
            throw new CompileError(lllllllllllllIIlIlIIIllIIllIlIII);
        }
        this.accessors.put(lllllllllllllIIlIlIIIllIIllIIIll, lllllllllllllIIlIlIIIllIIllIIIlI);
        return lllllllllllllIIlIlIIIllIIllIIIlI;
    }
    
    public String getMethodAccessor(final String lllllllllllllIIlIlIIIllIIIIllIII, final String lllllllllllllIIlIlIIIllIIIIIllll, final String lllllllllllllIIlIlIIIllIIIIlIllI, final MethodInfo lllllllllllllIIlIlIIIllIIIIlIlIl) throws CompileError {
        final String lllllllllllllIIlIlIIIllIIIIlIlII = String.valueOf(new StringBuilder().append(lllllllllllllIIlIlIIIllIIIIllIII).append(":").append(lllllllllllllIIlIlIIIllIIIIIllll));
        String lllllllllllllIIlIlIIIllIIIIlIIll = this.accessors.get(lllllllllllllIIlIlIIIllIIIIlIlII);
        if (lllllllllllllIIlIlIIIllIIIIlIIll != null) {
            return lllllllllllllIIlIlIIIllIIIIlIIll;
        }
        final ClassFile lllllllllllllIIlIlIIIllIIIIlIIlI = this.clazz.getClassFile();
        lllllllllllllIIlIlIIIllIIIIlIIll = this.findAccessorName(lllllllllllllIIlIlIIIllIIIIlIIlI);
        try {
            final ConstPool lllllllllllllIIlIlIIIllIIIlllIII = lllllllllllllIIlIlIIIllIIIIlIIlI.getConstPool();
            final ClassPool lllllllllllllIIlIlIIIllIIIllIlll = this.clazz.getClassPool();
            final MethodInfo lllllllllllllIIlIlIIIllIIIllIllI = new MethodInfo(lllllllllllllIIlIlIIIllIIIlllIII, lllllllllllllIIlIlIIIllIIIIlIIll, lllllllllllllIIlIlIIIllIIIIlIllI);
            lllllllllllllIIlIlIIIllIIIllIllI.setAccessFlags(8);
            lllllllllllllIIlIlIIIllIIIllIllI.addAttribute(new SyntheticAttribute(lllllllllllllIIlIlIIIllIIIlllIII));
            final ExceptionsAttribute lllllllllllllIIlIlIIIllIIIllIlIl = lllllllllllllIIlIlIIIllIIIIlIlIl.getExceptionsAttribute();
            if (lllllllllllllIIlIlIIIllIIIllIlIl != null) {
                lllllllllllllIIlIlIIIllIIIllIllI.addAttribute(lllllllllllllIIlIlIIIllIIIllIlIl.copy(lllllllllllllIIlIlIIIllIIIlllIII, null));
            }
            final CtClass[] lllllllllllllIIlIlIIIllIIIllIlII = Descriptor.getParameterTypes(lllllllllllllIIlIlIIIllIIIIlIllI, lllllllllllllIIlIlIIIllIIIllIlll);
            int lllllllllllllIIlIlIIIllIIIllIIll = 0;
            final Bytecode lllllllllllllIIlIlIIIllIIIllIIlI = new Bytecode(lllllllllllllIIlIlIIIllIIIlllIII);
            for (int lllllllllllllIIlIlIIIllIIIlllIIl = 0; lllllllllllllIIlIlIIIllIIIlllIIl < lllllllllllllIIlIlIIIllIIIllIlII.length; ++lllllllllllllIIlIlIIIllIIIlllIIl) {
                lllllllllllllIIlIlIIIllIIIllIIll += lllllllllllllIIlIlIIIllIIIllIIlI.addLoad(lllllllllllllIIlIlIIIllIIIllIIll, lllllllllllllIIlIlIIIllIIIllIlII[lllllllllllllIIlIlIIIllIIIlllIIl]);
            }
            lllllllllllllIIlIlIIIllIIIllIIlI.setMaxLocals(lllllllllllllIIlIlIIIllIIIllIIll);
            if (lllllllllllllIIlIlIIIllIIIIIllll == lllllllllllllIIlIlIIIllIIIIlIllI) {
                lllllllllllllIIlIlIIIllIIIllIIlI.addInvokestatic(this.clazz, lllllllllllllIIlIlIIIllIIIIllIII, lllllllllllllIIlIlIIIllIIIIIllll);
            }
            else {
                lllllllllllllIIlIlIIIllIIIllIIlI.addInvokevirtual(this.clazz, lllllllllllllIIlIlIIIllIIIIllIII, lllllllllllllIIlIlIIIllIIIIIllll);
            }
            lllllllllllllIIlIlIIIllIIIllIIlI.addReturn(Descriptor.getReturnType(lllllllllllllIIlIlIIIllIIIIIllll, lllllllllllllIIlIlIIIllIIIllIlll));
            lllllllllllllIIlIlIIIllIIIllIllI.setCodeAttribute(lllllllllllllIIlIlIIIllIIIllIIlI.toCodeAttribute());
            lllllllllllllIIlIlIIIllIIIIlIIlI.addMethod(lllllllllllllIIlIlIIIllIIIllIllI);
        }
        catch (CannotCompileException lllllllllllllIIlIlIIIllIIIIllIll) {
            throw new CompileError(lllllllllllllIIlIlIIIllIIIIllIll);
        }
        catch (NotFoundException lllllllllllllIIlIlIIIllIIIIllIlI) {
            throw new CompileError(lllllllllllllIIlIlIIIllIIIIllIlI);
        }
        this.accessors.put(lllllllllllllIIlIlIIIllIIIIlIlII, lllllllllllllIIlIlIIIllIIIIlIIll);
        return lllllllllllllIIlIlIIIllIIIIlIIll;
    }
}
