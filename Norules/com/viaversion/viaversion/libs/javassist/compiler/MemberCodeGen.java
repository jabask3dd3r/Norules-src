package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;

public class MemberCodeGen extends CodeGen
{
    protected /* synthetic */ boolean resultStatic;
    protected /* synthetic */ MethodInfo thisMethod;
    protected /* synthetic */ CtClass thisClass;
    protected /* synthetic */ MemberResolver resolver;
    
    void setReturnType(final String llllllllllllllIIlllllIlIlllIlllI, final boolean llllllllllllllIIlllllIlIlllIIlIl, final boolean llllllllllllllIIlllllIlIlllIllII) throws CompileError {
        int llllllllllllllIIlllllIlIlllIlIll = llllllllllllllIIlllllIlIlllIlllI.indexOf(41);
        if (llllllllllllllIIlllllIlIlllIlIll < 0) {
            badMethod();
        }
        char llllllllllllllIIlllllIlIlllIlIlI = llllllllllllllIIlllllIlIlllIlllI.charAt(++llllllllllllllIIlllllIlIlllIlIll);
        int llllllllllllllIIlllllIlIlllIlIIl = 0;
        while (llllllllllllllIIlllllIlIlllIlIlI == '[') {
            ++llllllllllllllIIlllllIlIlllIlIIl;
            llllllllllllllIIlllllIlIlllIlIlI = llllllllllllllIIlllllIlIlllIlllI.charAt(++llllllllllllllIIlllllIlIlllIlIll);
        }
        this.arrayDim = llllllllllllllIIlllllIlIlllIlIIl;
        if (llllllllllllllIIlllllIlIlllIlIlI == 'L') {
            final int llllllllllllllIIlllllIlIllllIIII = llllllllllllllIIlllllIlIlllIlllI.indexOf(59, llllllllllllllIIlllllIlIlllIlIll + 1);
            if (llllllllllllllIIlllllIlIllllIIII < 0) {
                badMethod();
            }
            this.exprType = 307;
            this.className = llllllllllllllIIlllllIlIlllIlllI.substring(llllllllllllllIIlllllIlIlllIlIll + 1, llllllllllllllIIlllllIlIllllIIII);
        }
        else {
            this.exprType = MemberResolver.descToType(llllllllllllllIIlllllIlIlllIlIlI);
            this.className = null;
        }
        final int llllllllllllllIIlllllIlIlllIlIII = this.exprType;
        if (llllllllllllllIIlllllIlIlllIIlIl && llllllllllllllIIlllllIlIlllIllII) {
            if (CodeGen.is2word(llllllllllllllIIlllllIlIlllIlIII, llllllllllllllIIlllllIlIlllIlIIl)) {
                this.bytecode.addOpcode(93);
                this.bytecode.addOpcode(88);
                this.bytecode.addOpcode(87);
            }
            else if (llllllllllllllIIlllllIlIlllIlIII == 344) {
                this.bytecode.addOpcode(87);
            }
            else {
                this.bytecode.addOpcode(95);
                this.bytecode.addOpcode(87);
            }
        }
    }
    
    @Override
    protected void insertDefaultSuperCall() throws CompileError {
        this.bytecode.addAload(0);
        this.bytecode.addInvokespecial(MemberResolver.getSuperclass(this.thisClass), "<init>", "()V");
    }
    
    public CtClass getThisClass() {
        return this.thisClass;
    }
    
    private int addFieldrefInfo(final CtField llllllllllllllIIlllllIlIIIIllIlI, final FieldInfo llllllllllllllIIlllllIlIIIIIlllI) {
        final ConstPool llllllllllllllIIlllllIlIIIIlIllI = this.bytecode.getConstPool();
        final String llllllllllllllIIlllllIlIIIIlIlII = llllllllllllllIIlllllIlIIIIllIlI.getDeclaringClass().getName();
        final int llllllllllllllIIlllllIlIIIIlIIll = llllllllllllllIIlllllIlIIIIlIllI.addClassInfo(llllllllllllllIIlllllIlIIIIlIlII);
        final String llllllllllllllIIlllllIlIIIIlIIlI = llllllllllllllIIlllllIlIIIIIlllI.getName();
        final String llllllllllllllIIlllllIlIIIIlIIIl = llllllllllllllIIlllllIlIIIIIlllI.getDescriptor();
        return llllllllllllllIIlllllIlIIIIlIllI.addFieldrefInfo(llllllllllllllIIlllllIlIIIIlIIll, llllllllllllllIIlllllIlIIIIlIIlI, llllllllllllllIIlllllIlIIIIlIIIl);
    }
    
    public int getMajorVersion() {
        final ClassFile llllllllllllllIIllllllIIlIIlIIlI = this.thisClass.getClassFile2();
        if (llllllllllllllIIllllllIIlIIlIIlI == null) {
            return ClassFile.MAJOR_VERSION;
        }
        return llllllllllllllIIllllllIIlIIlIIlI.getMajorVersion();
    }
    
    public int getMethodArgsLength(final ASTList llllllllllllllIIlllllIllIIIlIIlI) {
        return ASTList.length(llllllllllllllIIlllllIllIIIlIIlI);
    }
    
    private void atArrayLength(final ASTree llllllllllllllIIlllllIlIIllIIllI) throws CompileError {
        if (this.arrayDim == 0) {
            throw new CompileError(".length applied to a non array");
        }
        this.bytecode.addOpcode(190);
        this.exprType = 324;
        this.arrayDim = 0;
    }
    
    @Override
    protected void atFieldRead(final ASTree llllllllllllllIIlllllIlIIllIllII) throws CompileError {
        final CtField llllllllllllllIIlllllIlIIlllIIII = this.fieldAccess(llllllllllllllIIlllllIlIIllIllII, true);
        if (llllllllllllllIIlllllIlIIlllIIII == null) {
            this.atArrayLength(llllllllllllllIIlllllIlIIllIllII);
            return;
        }
        final boolean llllllllllllllIIlllllIlIIllIllll = this.resultStatic;
        final ASTree llllllllllllllIIlllllIlIIllIlllI = TypeChecker.getConstantFieldValue(llllllllllllllIIlllllIlIIlllIIII);
        if (llllllllllllllIIlllllIlIIllIlllI == null) {
            this.atFieldRead(llllllllllllllIIlllllIlIIlllIIII, llllllllllllllIIlllllIlIIllIllll);
        }
        else {
            llllllllllllllIIlllllIlIIllIlllI.accept(this);
            this.setFieldType(llllllllllllllIIlllllIlIIlllIIII.getFieldInfo2());
        }
    }
    
    public CtClass[] makeThrowsList(final MethodDecl llllllllllllllIIlllllIIllIlIIllI) throws CompileError {
        ASTList llllllllllllllIIlllllIIllIlIIlII = llllllllllllllIIlllllIIllIlIIllI.getThrows();
        if (llllllllllllllIIlllllIIllIlIIlII == null) {
            return null;
        }
        int llllllllllllllIIlllllIIllIlIIIll = 0;
        final CtClass[] llllllllllllllIIlllllIIllIlIIlIl = new CtClass[llllllllllllllIIlllllIIllIlIIlII.length()];
        while (llllllllllllllIIlllllIIllIlIIlII != null) {
            llllllllllllllIIlllllIIllIlIIlIl[llllllllllllllIIlllllIIllIlIIIll++] = this.resolver.lookupClassByName((ASTList)llllllllllllllIIlllllIIllIlIIlII.head());
            llllllllllllllIIlllllIIllIlIIlII = llllllllllllllIIlllllIIllIlIIlII.tail();
        }
        return llllllllllllllIIlllllIIllIlIIlIl;
    }
    
    @Override
    public void atArrayInit(final ArrayInit llllllllllllllIIlllllIlllllIIlII) throws CompileError {
        throw new CompileError("array initializer is not supported");
    }
    
    private boolean setFieldType(final FieldInfo llllllllllllllIIlllllIlIIIllIIII) throws CompileError {
        final String llllllllllllllIIlllllIlIIIllIllI = llllllllllllllIIlllllIlIIIllIIII.getDescriptor();
        int llllllllllllllIIlllllIlIIIllIlIl = 0;
        int llllllllllllllIIlllllIlIIIllIlII = 0;
        char llllllllllllllIIlllllIlIIIllIIll;
        for (llllllllllllllIIlllllIlIIIllIIll = llllllllllllllIIlllllIlIIIllIllI.charAt(llllllllllllllIIlllllIlIIIllIlIl); llllllllllllllIIlllllIlIIIllIIll == '['; llllllllllllllIIlllllIlIIIllIIll = llllllllllllllIIlllllIlIIIllIllI.charAt(++llllllllllllllIIlllllIlIIIllIlIl)) {
            ++llllllllllllllIIlllllIlIIIllIlII;
        }
        this.arrayDim = llllllllllllllIIlllllIlIIIllIlII;
        this.exprType = MemberResolver.descToType(llllllllllllllIIlllllIlIIIllIIll);
        if (llllllllllllllIIlllllIlIIIllIIll == 'L') {
            this.className = llllllllllllllIIlllllIlIIIllIllI.substring(llllllllllllllIIlllllIlIIIllIlIl + 1, llllllllllllllIIlllllIlIIIllIllI.indexOf(59, llllllllllllllIIlllllIlIIIllIlIl + 1));
        }
        else {
            this.className = null;
        }
        final boolean llllllllllllllIIlllllIlIIIllIIlI = llllllllllllllIIlllllIlIIIllIlII == 0 && (llllllllllllllIIlllllIlIIIllIIll == 'J' || llllllllllllllIIlllllIlIIIllIIll == 'D');
        return llllllllllllllIIlllllIlIIIllIIlI;
    }
    
    private static void badLvalue() throws CompileError {
        throw new CompileError("bad l-value");
    }
    
    private void atMethodCallCore2(final CtClass llllllllllllllIIlllllIllIlIIllIl, String llllllllllllllIIlllllIllIlIIllII, boolean llllllllllllllIIlllllIllIlIIlIll, boolean llllllllllllllIIlllllIllIlIIlIlI, final int llllllllllllllIIlllllIllIlIlIlIl, final MemberResolver.Method llllllllllllllIIlllllIllIlIIlIII) throws CompileError {
        CtClass llllllllllllllIIlllllIllIlIlIIll = llllllllllllllIIlllllIllIlIIlIII.declaring;
        final MethodInfo llllllllllllllIIlllllIllIlIlIIlI = llllllllllllllIIlllllIllIlIIlIII.info;
        String llllllllllllllIIlllllIllIlIlIIIl = llllllllllllllIIlllllIllIlIlIIlI.getDescriptor();
        int llllllllllllllIIlllllIllIlIlIIII = llllllllllllllIIlllllIllIlIlIIlI.getAccessFlags();
        if (((String)llllllllllllllIIlllllIllIlIIllII).equals("<init>")) {
            llllllllllllllIIlllllIllIlIIlIlI = true;
            if (llllllllllllllIIlllllIllIlIlIIll != llllllllllllllIIlllllIllIlIIllIl) {
                throw new CompileError(String.valueOf(new StringBuilder().append("no such constructor: ").append(llllllllllllllIIlllllIllIlIIllIl.getName())));
            }
            if (llllllllllllllIIlllllIllIlIlIIll != this.thisClass && AccessFlag.isPrivate(llllllllllllllIIlllllIllIlIlIIII) && (llllllllllllllIIlllllIllIlIlIIll.getClassFile().getMajorVersion() < 55 || !this.isFromSameDeclaringClass(llllllllllllllIIlllllIllIlIlIIll, this.thisClass))) {
                llllllllllllllIIlllllIllIlIlIIIl = this.getAccessibleConstructor(llllllllllllllIIlllllIllIlIlIIIl, llllllllllllllIIlllllIllIlIlIIll, llllllllllllllIIlllllIllIlIlIIlI);
                this.bytecode.addOpcode(1);
            }
        }
        else if (AccessFlag.isPrivate(llllllllllllllIIlllllIllIlIlIIII)) {
            if (llllllllllllllIIlllllIllIlIlIIll == this.thisClass) {
                llllllllllllllIIlllllIllIlIIlIlI = true;
            }
            else {
                llllllllllllllIIlllllIllIlIIlIlI = false;
                llllllllllllllIIlllllIllIlIIlIll = 1;
                final String llllllllllllllIIlllllIllIlIlllII = llllllllllllllIIlllllIllIlIlIIIl;
                if ((llllllllllllllIIlllllIllIlIlIIII & 0x8) == 0x0) {
                    llllllllllllllIIlllllIllIlIlIIIl = Descriptor.insertParameter(llllllllllllllIIlllllIllIlIlIIll.getName(), llllllllllllllIIlllllIllIlIlllII);
                }
                llllllllllllllIIlllllIllIlIlIIII = (AccessFlag.setPackage(llllllllllllllIIlllllIllIlIlIIII) | 0x8);
                llllllllllllllIIlllllIllIlIIllII = this.getAccessiblePrivate((String)llllllllllllllIIlllllIllIlIIllII, llllllllllllllIIlllllIllIlIlllII, llllllllllllllIIlllllIllIlIlIIIl, llllllllllllllIIlllllIllIlIlIIlI, llllllllllllllIIlllllIllIlIlIIll);
            }
        }
        boolean llllllllllllllIIlllllIllIlIIllll = false;
        if ((llllllllllllllIIlllllIllIlIlIIII & 0x8) != 0x0) {
            if (llllllllllllllIIlllllIllIlIIlIll == 0) {
                llllllllllllllIIlllllIllIlIIlIll = 1;
                if (llllllllllllllIIlllllIllIlIlIlIl >= 0) {
                    this.bytecode.write(llllllllllllllIIlllllIllIlIlIlIl, 0);
                }
                else {
                    llllllllllllllIIlllllIllIlIIllll = true;
                }
            }
            this.bytecode.addInvokestatic(llllllllllllllIIlllllIllIlIlIIll, (String)llllllllllllllIIlllllIllIlIIllII, llllllllllllllIIlllllIllIlIlIIIl);
        }
        else if (llllllllllllllIIlllllIllIlIIlIlI) {
            this.bytecode.addInvokespecial(llllllllllllllIIlllllIllIlIIllIl, (String)llllllllllllllIIlllllIllIlIIllII, llllllllllllllIIlllllIllIlIlIIIl);
        }
        else {
            if (!Modifier.isPublic(llllllllllllllIIlllllIllIlIlIIll.getModifiers()) || llllllllllllllIIlllllIllIlIlIIll.isInterface() != llllllllllllllIIlllllIllIlIIllIl.isInterface()) {
                llllllllllllllIIlllllIllIlIlIIll = llllllllllllllIIlllllIllIlIIllIl;
            }
            if (llllllllllllllIIlllllIllIlIlIIll.isInterface()) {
                final int llllllllllllllIIlllllIllIlIllIll = Descriptor.paramSize(llllllllllllllIIlllllIllIlIlIIIl) + 1;
                this.bytecode.addInvokeinterface(llllllllllllllIIlllllIllIlIlIIll, (String)llllllllllllllIIlllllIllIlIIllII, llllllllllllllIIlllllIllIlIlIIIl, llllllllllllllIIlllllIllIlIllIll);
            }
            else {
                if (llllllllllllllIIlllllIllIlIIlIll != 0) {
                    throw new CompileError(String.valueOf(new StringBuilder().append((String)llllllllllllllIIlllllIllIlIIllII).append(" is not static")));
                }
                this.bytecode.addInvokevirtual(llllllllllllllIIlllllIllIlIlIIll, (String)llllllllllllllIIlllllIllIlIIllII, llllllllllllllIIlllllIllIlIlIIIl);
            }
        }
        this.setReturnType(llllllllllllllIIlllllIllIlIlIIIl, (boolean)(llllllllllllllIIlllllIllIlIIlIll != 0.0f), llllllllllllllIIlllllIllIlIIllll);
    }
    
    public void atNewArrayExpr(final NewExpr llllllllllllllIIllllllIIIIIlIllI) throws CompileError {
        final int llllllllllllllIIllllllIIIIIlllII = llllllllllllllIIllllllIIIIIlIllI.getArrayType();
        final ASTList llllllllllllllIIllllllIIIIIllIll = llllllllllllllIIllllllIIIIIlIllI.getArraySize();
        final ASTList llllllllllllllIIllllllIIIIIllIlI = llllllllllllllIIllllllIIIIIlIllI.getClassName();
        final ArrayInit llllllllllllllIIllllllIIIIIllIIl = llllllllllllllIIllllllIIIIIlIllI.getInitializer();
        if (llllllllllllllIIllllllIIIIIllIll.length() <= 1) {
            final ASTree llllllllllllllIIllllllIIIIIllIII = llllllllllllllIIllllllIIIIIllIll.head();
            this.atNewArrayExpr2(llllllllllllllIIllllllIIIIIlllII, llllllllllllllIIllllllIIIIIllIII, Declarator.astToClassName(llllllllllllllIIllllllIIIIIllIlI, '/'), llllllllllllllIIllllllIIIIIllIIl);
            return;
        }
        if (llllllllllllllIIllllllIIIIIllIIl != null) {
            throw new CompileError("sorry, multi-dimensional array initializer for new is not supported");
        }
        this.atMultiNewArray(llllllllllllllIIllllllIIIIIlllII, llllllllllllllIIllllllIIIIIllIlI, llllllllllllllIIllllllIIIIIllIll);
    }
    
    @Override
    protected String getThisName() {
        return MemberResolver.javaToJvmName(this.thisClass.getName());
    }
    
    @Override
    protected String resolveClassName(final ASTList llllllllllllllIIlllllIIllIIllIlI) throws CompileError {
        return this.resolver.resolveClassName(llllllllllllllIIlllllIIllIIllIlI);
    }
    
    @Override
    protected void atFieldAssign(final Expr llllllllllllllIIlllllIlIlIlIIlIl, final int llllllllllllllIIlllllIlIlIllIIIl, final ASTree llllllllllllllIIlllllIlIlIllIIII, final ASTree llllllllllllllIIlllllIlIlIlIllll, final boolean llllllllllllllIIlllllIlIlIlIIIIl) throws CompileError {
        final CtField llllllllllllllIIlllllIlIlIlIllIl = this.fieldAccess(llllllllllllllIIlllllIlIlIllIIII, false);
        final boolean llllllllllllllIIlllllIlIlIlIllII = this.resultStatic;
        if (llllllllllllllIIlllllIlIlIllIIIl != 61 && !llllllllllllllIIlllllIlIlIlIllII) {
            this.bytecode.addOpcode(89);
        }
        int llllllllllllllIIlllllIlIlIlIlIll;
        if (llllllllllllllIIlllllIlIlIllIIIl == 61) {
            final FieldInfo llllllllllllllIIlllllIlIlIlllIII = llllllllllllllIIlllllIlIlIlIllIl.getFieldInfo2();
            this.setFieldType(llllllllllllllIIlllllIlIlIlllIII);
            final AccessorMaker llllllllllllllIIlllllIlIlIllIlll = this.isAccessibleField(llllllllllllllIIlllllIlIlIlIllIl, llllllllllllllIIlllllIlIlIlllIII);
            if (llllllllllllllIIlllllIlIlIllIlll == null) {
                final int llllllllllllllIIlllllIlIlIlllIIl = this.addFieldrefInfo(llllllllllllllIIlllllIlIlIlIllIl, llllllllllllllIIlllllIlIlIlllIII);
            }
            else {
                final int llllllllllllllIIlllllIlIlIllIllI = 0;
            }
        }
        else {
            llllllllllllllIIlllllIlIlIlIlIll = this.atFieldRead(llllllllllllllIIlllllIlIlIlIllIl, llllllllllllllIIlllllIlIlIlIllII);
        }
        final int llllllllllllllIIlllllIlIlIlIlIlI = this.exprType;
        final int llllllllllllllIIlllllIlIlIlIlIIl = this.arrayDim;
        final String llllllllllllllIIlllllIlIlIlIlIII = this.className;
        this.atAssignCore(llllllllllllllIIlllllIlIlIlIIlIl, llllllllllllllIIlllllIlIlIllIIIl, llllllllllllllIIlllllIlIlIlIllll, llllllllllllllIIlllllIlIlIlIlIlI, llllllllllllllIIlllllIlIlIlIlIIl, llllllllllllllIIlllllIlIlIlIlIII);
        final boolean llllllllllllllIIlllllIlIlIlIIlll = CodeGen.is2word(llllllllllllllIIlllllIlIlIlIlIlI, llllllllllllllIIlllllIlIlIlIlIIl);
        if (llllllllllllllIIlllllIlIlIlIIIIl) {
            int llllllllllllllIIlllllIlIlIllIlII = 0;
            if (llllllllllllllIIlllllIlIlIlIllII) {
                final int llllllllllllllIIlllllIlIlIllIlIl = llllllllllllllIIlllllIlIlIlIIlll ? 92 : 89;
            }
            else {
                llllllllllllllIIlllllIlIlIllIlII = (llllllllllllllIIlllllIlIlIlIIlll ? 93 : 90);
            }
            this.bytecode.addOpcode(llllllllllllllIIlllllIlIlIllIlII);
        }
        this.atFieldAssignCore(llllllllllllllIIlllllIlIlIlIllIl, llllllllllllllIIlllllIlIlIlIllII, llllllllllllllIIlllllIlIlIlIlIll, llllllllllllllIIlllllIlIlIlIIlll);
        this.exprType = llllllllllllllIIlllllIlIlIlIlIlI;
        this.arrayDim = llllllllllllllIIlllllIlIlIlIlIIl;
        this.className = llllllllllllllIIlllllIlIlIlIlIII;
    }
    
    @Override
    protected void atClassObject2(final String llllllllllllllIIlllllIlIIIIIIlIl) throws CompileError {
        if (this.getMajorVersion() < 49) {
            super.atClassObject2(llllllllllllllIIlllllIlIIIIIIlIl);
        }
        else {
            this.bytecode.addLdc(this.bytecode.getConstPool().addClassInfo(llllllllllllllIIlllllIlIIIIIIlIl));
        }
    }
    
    @Override
    protected void atFieldPlusPlus(final int llllllllllllllIIlllllIIllllIlIII, final boolean llllllllllllllIIlllllIIllllIIlll, final ASTree llllllllllllllIIlllllIIlllllIIlI, final Expr llllllllllllllIIlllllIIlllllIIIl, final boolean llllllllllllllIIlllllIIlllllIIII) throws CompileError {
        final CtField llllllllllllllIIlllllIIllllIllll = this.fieldAccess(llllllllllllllIIlllllIIlllllIIlI, false);
        final boolean llllllllllllllIIlllllIIllllIlllI = this.resultStatic;
        if (!llllllllllllllIIlllllIIllllIlllI) {
            this.bytecode.addOpcode(89);
        }
        final int llllllllllllllIIlllllIIllllIllIl = this.atFieldRead(llllllllllllllIIlllllIIllllIllll, llllllllllllllIIlllllIIllllIlllI);
        final int llllllllllllllIIlllllIIllllIllII = this.exprType;
        final boolean llllllllllllllIIlllllIIllllIlIll = CodeGen.is2word(llllllllllllllIIlllllIIllllIllII, this.arrayDim);
        int llllllllllllllIIlllllIIllllIlIlI = 0;
        if (llllllllllllllIIlllllIIllllIlllI) {
            final int llllllllllllllIIlllllIIlllllIllI = llllllllllllllIIlllllIIllllIlIll ? 92 : 89;
        }
        else {
            llllllllllllllIIlllllIIllllIlIlI = (llllllllllllllIIlllllIIllllIlIll ? 93 : 90);
        }
        this.atPlusPlusCore(llllllllllllllIIlllllIIllllIlIlI, llllllllllllllIIlllllIIlllllIIII, llllllllllllllIIlllllIIllllIlIII, llllllllllllllIIlllllIIllllIIlll, llllllllllllllIIlllllIIlllllIIIl);
        this.atFieldAssignCore(llllllllllllllIIlllllIIllllIllll, llllllllllllllIIlllllIIllllIlllI, llllllllllllllIIlllllIIllllIllIl, llllllllllllllIIlllllIIllllIlIll);
    }
    
    protected void atMultiNewArray(final int llllllllllllllIIlllllIllllIllIIl, final ASTList llllllllllllllIIlllllIllllIllIII, ASTList llllllllllllllIIlllllIllllIlIIII) throws CompileError {
        final int llllllllllllllIIlllllIllllIlIlIl = llllllllllllllIIlllllIllllIlIIII.length();
        int llllllllllllllIIlllllIllllIlIllI = 0;
        while (llllllllllllllIIlllllIllllIlIIII != null) {
            final ASTree llllllllllllllIIlllllIllllIlllII = llllllllllllllIIlllllIllllIlIIII.head();
            if (llllllllllllllIIlllllIllllIlllII == null) {
                break;
            }
            ++llllllllllllllIIlllllIllllIlIllI;
            llllllllllllllIIlllllIllllIlllII.accept(this);
            if (this.exprType != 324) {
                throw new CompileError("bad type for array size");
            }
            llllllllllllllIIlllllIllllIlIIII = llllllllllllllIIlllllIllllIlIIII.tail();
        }
        this.exprType = llllllllllllllIIlllllIllllIllIIl;
        this.arrayDim = llllllllllllllIIlllllIllllIlIlIl;
        String llllllllllllllIIlllllIllllIlIlII = null;
        if (llllllllllllllIIlllllIllllIllIIl == 307) {
            this.className = this.resolveClassName(llllllllllllllIIlllllIllllIllIII);
            final String llllllllllllllIIlllllIllllIllIll = CodeGen.toJvmArrayName(this.className, llllllllllllllIIlllllIllllIlIlIl);
        }
        else {
            llllllllllllllIIlllllIllllIlIlII = CodeGen.toJvmTypeName(llllllllllllllIIlllllIllllIllIIl, llllllllllllllIIlllllIllllIlIlIl);
        }
        this.bytecode.addMultiNewarray(llllllllllllllIIlllllIllllIlIlII, llllllllllllllIIlllllIllllIlIllI);
    }
    
    public void atMethodArgs(ASTList llllllllllllllIIlllllIllIIIIIIIl, final int[] llllllllllllllIIlllllIllIIIIIllI, final int[] llllllllllllllIIlllllIllIIIIIlIl, final String[] llllllllllllllIIlllllIlIlllllllI) throws CompileError {
        int llllllllllllllIIlllllIllIIIIIIll = 0;
        while (llllllllllllllIIlllllIllIIIIIIIl != null) {
            final ASTree llllllllllllllIIlllllIllIIIIlIIl = llllllllllllllIIlllllIllIIIIIIIl.head();
            llllllllllllllIIlllllIllIIIIlIIl.accept(this);
            llllllllllllllIIlllllIllIIIIIllI[llllllllllllllIIlllllIllIIIIIIll] = this.exprType;
            llllllllllllllIIlllllIllIIIIIlIl[llllllllllllllIIlllllIllIIIIIIll] = this.arrayDim;
            llllllllllllllIIlllllIlIlllllllI[llllllllllllllIIlllllIllIIIIIIll] = this.className;
            ++llllllllllllllIIlllllIllIIIIIIll;
            llllllllllllllIIlllllIllIIIIIIIl = llllllllllllllIIlllllIllIIIIIIIl.tail();
        }
    }
    
    private AccessorMaker isAccessibleField(final CtField llllllllllllllIIlllllIlIIlIIIllI, final FieldInfo llllllllllllllIIlllllIlIIlIIIIlI) throws CompileError {
        if (AccessFlag.isPrivate(llllllllllllllIIlllllIlIIlIIIIlI.getAccessFlags()) && llllllllllllllIIlllllIlIIlIIIllI.getDeclaringClass() != this.thisClass) {
            final CtClass llllllllllllllIIlllllIlIIlIIlIII = llllllllllllllIIlllllIlIIlIIIllI.getDeclaringClass();
            if (this.isEnclosing(llllllllllllllIIlllllIlIIlIIlIII, this.thisClass)) {
                final AccessorMaker llllllllllllllIIlllllIlIIlIIlIIl = llllllllllllllIIlllllIlIIlIIlIII.getAccessorMaker();
                if (llllllllllllllIIlllllIlIIlIIlIIl != null) {
                    return llllllllllllllIIlllllIlIIlIIlIIl;
                }
            }
            throw new CompileError(String.valueOf(new StringBuilder().append("Field ").append(llllllllllllllIIlllllIlIIlIIIllI.getName()).append(" in ").append(llllllllllllllIIlllllIlIIlIIlIII.getName()).append(" is private.")));
        }
        return null;
    }
    
    private static void badNewExpr() throws CompileError {
        throw new CompileError("bad new expression");
    }
    
    private int atFieldRead(final CtField llllllllllllllIIlllllIlIIlIlIlII, final boolean llllllllllllllIIlllllIlIIlIlIIll) throws CompileError {
        final FieldInfo llllllllllllllIIlllllIlIIlIllIIl = llllllllllllllIIlllllIlIIlIlIlII.getFieldInfo2();
        final boolean llllllllllllllIIlllllIlIIlIllIII = this.setFieldType(llllllllllllllIIlllllIlIIlIllIIl);
        final AccessorMaker llllllllllllllIIlllllIlIIlIlIlll = this.isAccessibleField(llllllllllllllIIlllllIlIIlIlIlII, llllllllllllllIIlllllIlIIlIllIIl);
        if (llllllllllllllIIlllllIlIIlIlIlll != null) {
            final MethodInfo llllllllllllllIIlllllIlIIlIlllIl = llllllllllllllIIlllllIlIIlIlIlll.getFieldGetter(llllllllllllllIIlllllIlIIlIllIIl, llllllllllllllIIlllllIlIIlIlIIll);
            this.bytecode.addInvokestatic(llllllllllllllIIlllllIlIIlIlIlII.getDeclaringClass(), llllllllllllllIIlllllIlIIlIlllIl.getName(), llllllllllllllIIlllllIlIIlIlllIl.getDescriptor());
            return 0;
        }
        final int llllllllllllllIIlllllIlIIlIlIllI = this.addFieldrefInfo(llllllllllllllIIlllllIlIIlIlIlII, llllllllllllllIIlllllIlIIlIllIIl);
        if (llllllllllllllIIlllllIlIIlIlIIll) {
            this.bytecode.add(178);
            this.bytecode.growStack(llllllllllllllIIlllllIlIIlIllIII ? 2 : 1);
        }
        else {
            this.bytecode.add(180);
            this.bytecode.growStack(llllllllllllllIIlllllIlIIlIllIII ? 1 : 0);
        }
        this.bytecode.addIndex(llllllllllllllIIlllllIlIIlIlIllI);
        return llllllllllllllIIlllllIlIIlIlIllI;
    }
    
    @Override
    public void atNewExpr(final NewExpr llllllllllllllIIllllllIIIIlIlIIl) throws CompileError {
        if (llllllllllllllIIllllllIIIIlIlIIl.isArray()) {
            this.atNewArrayExpr(llllllllllllllIIllllllIIIIlIlIIl);
        }
        else {
            final CtClass llllllllllllllIIllllllIIIIlIllll = this.resolver.lookupClassByName(llllllllllllllIIllllllIIIIlIlIIl.getClassName());
            final String llllllllllllllIIllllllIIIIlIlllI = llllllllllllllIIllllllIIIIlIllll.getName();
            final ASTList llllllllllllllIIllllllIIIIlIllIl = llllllllllllllIIllllllIIIIlIlIIl.getArguments();
            this.bytecode.addNew(llllllllllllllIIllllllIIIIlIlllI);
            this.bytecode.addOpcode(89);
            this.atMethodCallCore(llllllllllllllIIllllllIIIIlIllll, "<init>", llllllllllllllIIllllllIIIIlIllIl, false, true, -1, null);
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = MemberResolver.javaToJvmName(llllllllllllllIIllllllIIIIlIlllI);
        }
    }
    
    @Override
    protected String getSuperName() throws CompileError {
        return MemberResolver.javaToJvmName(MemberResolver.getSuperclass(this.thisClass).getName());
    }
    
    public MemberCodeGen(final Bytecode llllllllllllllIIllllllIIlIIlllII, final CtClass llllllllllllllIIllllllIIlIIllIll, final ClassPool llllllllllllllIIllllllIIlIIllIlI) {
        super(llllllllllllllIIllllllIIlIIlllII);
        this.resolver = new MemberResolver(llllllllllllllIIllllllIIlIIllIlI);
        this.thisClass = llllllllllllllIIllllllIIlIIllIll;
        this.thisMethod = null;
    }
    
    private static void badMethod() throws CompileError {
        throw new CompileError("bad method");
    }
    
    protected String getAccessibleConstructor(final String llllllllllllllIIlllllIllIIlIIlIl, final CtClass llllllllllllllIIlllllIllIIlIIlII, final MethodInfo llllllllllllllIIlllllIllIIIlllll) throws CompileError {
        if (this.isEnclosing(llllllllllllllIIlllllIllIIlIIlII, this.thisClass)) {
            final AccessorMaker llllllllllllllIIlllllIllIIlIIlll = llllllllllllllIIlllllIllIIlIIlII.getAccessorMaker();
            if (llllllllllllllIIlllllIllIIlIIlll != null) {
                return llllllllllllllIIlllllIllIIlIIlll.getConstructor(llllllllllllllIIlllllIllIIlIIlII, llllllllllllllIIlllllIllIIlIIlIl, llllllllllllllIIlllllIllIIIlllll);
            }
        }
        throw new CompileError(String.valueOf(new StringBuilder().append("the called constructor is private in ").append(llllllllllllllIIlllllIllIIlIIlII.getName())));
    }
    
    public void atMethodCallCore(final CtClass llllllllllllllIIlllllIlllIIIIIIl, final String llllllllllllllIIlllllIlllIIIllIl, final ASTList llllllllllllllIIlllllIllIlllllll, boolean llllllllllllllIIlllllIllIllllllI, final boolean llllllllllllllIIlllllIlllIIIlIlI, final int llllllllllllllIIlllllIlllIIIlIIl, MemberResolver.Method llllllllllllllIIlllllIllIllllIll) throws CompileError {
        final int llllllllllllllIIlllllIlllIIIIlll = this.getMethodArgsLength(llllllllllllllIIlllllIllIlllllll);
        final int[] llllllllllllllIIlllllIlllIIIIllI = new int[llllllllllllllIIlllllIlllIIIIlll];
        final int[] llllllllllllllIIlllllIlllIIIIlIl = new int[llllllllllllllIIlllllIlllIIIIlll];
        final String[] llllllllllllllIIlllllIlllIIIIlII = new String[llllllllllllllIIlllllIlllIIIIlll];
        if (!llllllllllllllIIlllllIllIllllllI && llllllllllllllIIlllllIllIllllIll != null && llllllllllllllIIlllllIllIllllIll.isStatic()) {
            this.bytecode.addOpcode(87);
            llllllllllllllIIlllllIllIllllllI = true;
        }
        final int llllllllllllllIIlllllIlllIIIIIll = this.bytecode.getStackDepth();
        this.atMethodArgs(llllllllllllllIIlllllIllIlllllll, llllllllllllllIIlllllIlllIIIIllI, llllllllllllllIIlllllIlllIIIIlIl, llllllllllllllIIlllllIlllIIIIlII);
        if (llllllllllllllIIlllllIllIllllIll == null) {
            llllllllllllllIIlllllIllIllllIll = this.resolver.lookupMethod(llllllllllllllIIlllllIlllIIIIIIl, this.thisClass, this.thisMethod, llllllllllllllIIlllllIlllIIIllIl, llllllllllllllIIlllllIlllIIIIllI, llllllllllllllIIlllllIlllIIIIlIl, llllllllllllllIIlllllIlllIIIIlII);
        }
        if (llllllllllllllIIlllllIllIllllIll == null) {
            String llllllllllllllIIlllllIlllIIlIIII = null;
            if (llllllllllllllIIlllllIlllIIIllIl.equals("<init>")) {
                final String llllllllllllllIIlllllIlllIIlIIIl = "constructor not found";
            }
            else {
                llllllllllllllIIlllllIlllIIlIIII = String.valueOf(new StringBuilder().append("Method ").append(llllllllllllllIIlllllIlllIIIllIl).append(" not found in ").append(llllllllllllllIIlllllIlllIIIIIIl.getName()));
            }
            throw new CompileError(llllllllllllllIIlllllIlllIIlIIII);
        }
        this.atMethodCallCore2(llllllllllllllIIlllllIlllIIIIIIl, llllllllllllllIIlllllIlllIIIllIl, llllllllllllllIIlllllIllIllllllI, llllllllllllllIIlllllIlllIIIlIlI, llllllllllllllIIlllllIlllIIIlIIl, llllllllllllllIIlllllIllIllllIll);
    }
    
    @Override
    public void atMember(final Member llllllllllllllIIlllllIlIIllllIII) throws CompileError {
        this.atFieldRead(llllllllllllllIIlllllIlIIllllIII);
    }
    
    private boolean isEnclosing(final CtClass llllllllllllllIIlllllIllIIIlIlll, CtClass llllllllllllllIIlllllIllIIIlIllI) {
        try {
            while (llllllllllllllIIlllllIllIIIlIllI != null) {
                llllllllllllllIIlllllIllIIIlIllI = ((CtClass)llllllllllllllIIlllllIllIIIlIllI).getDeclaringClass();
                if (llllllllllllllIIlllllIllIIIlIllI == llllllllllllllIIlllllIllIIIlIlll) {
                    return true;
                }
            }
        }
        catch (NotFoundException ex) {}
        return false;
    }
    
    private void addFinally(final List<int[]> llllllllllllllIIllllllIIIIllllll, final Stmnt llllllllllllllIIllllllIIIIlllIlI) throws CompileError {
        final Bytecode llllllllllllllIIllllllIIIIllllIl = this.bytecode;
        for (final int[] llllllllllllllIIllllllIIIlIIIIIl : llllllllllllllIIllllllIIIIllllll) {
            final int llllllllllllllIIllllllIIIlIIIIll = llllllllllllllIIllllllIIIlIIIIIl[0];
            llllllllllllllIIllllllIIIIllllIl.write16bit(llllllllllllllIIllllllIIIlIIIIll, llllllllllllllIIllllllIIIIllllIl.currentPc() - llllllllllllllIIllllllIIIlIIIIll + 1);
            final ReturnHook llllllllllllllIIllllllIIIlIIIIlI = new JsrHook2(this, llllllllllllllIIllllllIIIlIIIIIl);
            llllllllllllllIIllllllIIIIlllIlI.accept(this);
            llllllllllllllIIllllllIIIlIIIIlI.remove(this);
            if (!this.hasReturned) {
                llllllllllllllIIllllllIIIIllllIl.addOpcode(167);
                llllllllllllllIIllllllIIIIllllIl.addIndex(llllllllllllllIIllllllIIIlIIIIll + 3 - llllllllllllllIIllllllIIIIllllIl.currentPc());
            }
        }
    }
    
    public void setThisMethod(final CtMethod llllllllllllllIIllllllIIlIIIlIlI) {
        this.thisMethod = llllllllllllllIIllllllIIlIIIlIlI.getMethodInfo2();
        if (this.typeChecker != null) {
            this.typeChecker.setThisMethod(this.thisMethod);
        }
    }
    
    private boolean isFromSameDeclaringClass(CtClass llllllllllllllIIlllllIllIllIllII, final CtClass llllllllllllllIIlllllIllIllIlIll) {
        try {
            while (llllllllllllllIIlllllIllIllIllII != null) {
                if (this.isEnclosing(llllllllllllllIIlllllIllIllIllII, llllllllllllllIIlllllIllIllIlIll)) {
                    return true;
                }
                llllllllllllllIIlllllIllIllIllII = llllllllllllllIIlllllIllIllIllII.getDeclaringClass();
            }
        }
        catch (NotFoundException ex) {}
        return false;
    }
    
    @Override
    protected void atTryStmnt(final Stmnt llllllllllllllIIllllllIIIlIllIlI) throws CompileError {
        final Bytecode llllllllllllllIIllllllIIIllIIllI = this.bytecode;
        final Stmnt llllllllllllllIIllllllIIIllIIlIl = (Stmnt)llllllllllllllIIllllllIIIlIllIlI.getLeft();
        if (llllllllllllllIIllllllIIIllIIlIl == null) {
            return;
        }
        ASTList llllllllllllllIIllllllIIIllIIlII = (ASTList)llllllllllllllIIllllllIIIlIllIlI.getRight().getLeft();
        final Stmnt llllllllllllllIIllllllIIIllIIIll = (Stmnt)llllllllllllllIIllllllIIIlIllIlI.getRight().getRight().getLeft();
        final List<Integer> llllllllllllllIIllllllIIIllIIIlI = new ArrayList<Integer>();
        JsrHook llllllllllllllIIllllllIIIllIIIIl = null;
        if (llllllllllllllIIllllllIIIllIIIll != null) {
            llllllllllllllIIllllllIIIllIIIIl = new JsrHook(this);
        }
        final int llllllllllllllIIllllllIIIllIIIII = llllllllllllllIIllllllIIIllIIllI.currentPc();
        llllllllllllllIIllllllIIIllIIlIl.accept(this);
        final int llllllllllllllIIllllllIIIlIlllll = llllllllllllllIIllllllIIIllIIllI.currentPc();
        if (llllllllllllllIIllllllIIIllIIIII == llllllllllllllIIllllllIIIlIlllll) {
            throw new CompileError("empty try block");
        }
        boolean llllllllllllllIIllllllIIIlIllllI = !this.hasReturned;
        if (llllllllllllllIIllllllIIIlIllllI) {
            llllllllllllllIIllllllIIIllIIllI.addOpcode(167);
            llllllllllllllIIllllllIIIllIIIlI.add(llllllllllllllIIllllllIIIllIIllI.currentPc());
            llllllllllllllIIllllllIIIllIIllI.addIndex(0);
        }
        final int llllllllllllllIIllllllIIIlIlllIl = this.getMaxLocals();
        this.incMaxLocals(1);
        while (llllllllllllllIIllllllIIIllIIlII != null) {
            final Pair llllllllllllllIIllllllIIIllIllIl = (Pair)llllllllllllllIIllllllIIIllIIlII.head();
            llllllllllllllIIllllllIIIllIIlII = llllllllllllllIIllllllIIIllIIlII.tail();
            final Declarator llllllllllllllIIllllllIIIllIllII = (Declarator)llllllllllllllIIllllllIIIllIllIl.getLeft();
            final Stmnt llllllllllllllIIllllllIIIllIlIll = (Stmnt)llllllllllllllIIllllllIIIllIllIl.getRight();
            llllllllllllllIIllllllIIIllIllII.setLocalVar(llllllllllllllIIllllllIIIlIlllIl);
            final CtClass llllllllllllllIIllllllIIIllIlIlI = this.resolver.lookupClassByJvmName(llllllllllllllIIllllllIIIllIllII.getClassName());
            llllllllllllllIIllllllIIIllIllII.setClassName(MemberResolver.javaToJvmName(llllllllllllllIIllllllIIIllIlIlI.getName()));
            llllllllllllllIIllllllIIIllIIllI.addExceptionHandler(llllllllllllllIIllllllIIIllIIIII, llllllllllllllIIllllllIIIlIlllll, llllllllllllllIIllllllIIIllIIllI.currentPc(), llllllllllllllIIllllllIIIllIlIlI);
            llllllllllllllIIllllllIIIllIIllI.growStack(1);
            llllllllllllllIIllllllIIIllIIllI.addAstore(llllllllllllllIIllllllIIIlIlllIl);
            this.hasReturned = false;
            if (llllllllllllllIIllllllIIIllIlIll != null) {
                llllllllllllllIIllllllIIIllIlIll.accept(this);
            }
            if (!this.hasReturned) {
                llllllllllllllIIllllllIIIllIIllI.addOpcode(167);
                llllllllllllllIIllllllIIIllIIIlI.add(llllllllllllllIIllllllIIIllIIllI.currentPc());
                llllllllllllllIIllllllIIIllIIllI.addIndex(0);
                llllllllllllllIIllllllIIIlIllllI = true;
            }
        }
        if (llllllllllllllIIllllllIIIllIIIll != null) {
            llllllllllllllIIllllllIIIllIIIIl.remove(this);
            final int llllllllllllllIIllllllIIIllIlIIl = llllllllllllllIIllllllIIIllIIllI.currentPc();
            llllllllllllllIIllllllIIIllIIllI.addExceptionHandler(llllllllllllllIIllllllIIIllIIIII, llllllllllllllIIllllllIIIllIlIIl, llllllllllllllIIllllllIIIllIlIIl, 0);
            llllllllllllllIIllllllIIIllIIllI.growStack(1);
            llllllllllllllIIllllllIIIllIIllI.addAstore(llllllllllllllIIllllllIIIlIlllIl);
            this.hasReturned = false;
            llllllllllllllIIllllllIIIllIIIll.accept(this);
            if (!this.hasReturned) {
                llllllllllllllIIllllllIIIllIIllI.addAload(llllllllllllllIIllllllIIIlIlllIl);
                llllllllllllllIIllllllIIIllIIllI.addOpcode(191);
            }
            this.addFinally(llllllllllllllIIllllllIIIllIIIIl.jsrList, llllllllllllllIIllllllIIIllIIIll);
        }
        final int llllllllllllllIIllllllIIIlIlllII = llllllllllllllIIllllllIIIllIIllI.currentPc();
        this.patchGoto(llllllllllllllIIllllllIIIllIIIlI, llllllllllllllIIllllllIIIlIlllII);
        this.hasReturned = !llllllllllllllIIllllllIIIlIllllI;
        if (llllllllllllllIIllllllIIIllIIIll != null && llllllllllllllIIllllllIIIlIllllI) {
            llllllllllllllIIllllllIIIllIIIll.accept(this);
        }
    }
    
    @Override
    protected String resolveClassName(final String llllllllllllllIIlllllIIllIIlIIlI) throws CompileError {
        return this.resolver.resolveJvmClassName(llllllllllllllIIlllllIIllIIlIIlI);
    }
    
    private void atNewArrayExpr2(final int llllllllllllllIIlllllIlllllllIlI, final ASTree llllllllllllllIIlllllIlllllllIIl, final String llllllllllllllIIlllllIlllllllIII, final ArrayInit llllllllllllllIIlllllIllllllIlll) throws CompileError {
        if (llllllllllllllIIlllllIllllllIlll == null) {
            if (llllllllllllllIIlllllIlllllllIIl == null) {
                throw new CompileError("no array size");
            }
            llllllllllllllIIlllllIlllllllIIl.accept(this);
        }
        else {
            if (llllllllllllllIIlllllIlllllllIIl != null) {
                throw new CompileError("unnecessary array size specified for new");
            }
            final int llllllllllllllIIllllllIIIIIIIlll = llllllllllllllIIlllllIllllllIlll.size();
            this.bytecode.addIconst(llllllllllllllIIllllllIIIIIIIlll);
        }
        String llllllllllllllIIlllllIllllllllII = null;
        if (llllllllllllllIIlllllIlllllllIlI == 307) {
            final String llllllllllllllIIllllllIIIIIIIllI = this.resolveClassName(llllllllllllllIIlllllIlllllllIII);
            this.bytecode.addAnewarray(MemberResolver.jvmToJavaName(llllllllllllllIIllllllIIIIIIIllI));
        }
        else {
            llllllllllllllIIlllllIllllllllII = null;
            int llllllllllllllIIllllllIIIIIIIlIl = 0;
            switch (llllllllllllllIIlllllIlllllllIlI) {
                case 301: {
                    llllllllllllllIIllllllIIIIIIIlIl = 4;
                    break;
                }
                case 306: {
                    llllllllllllllIIllllllIIIIIIIlIl = 5;
                    break;
                }
                case 317: {
                    llllllllllllllIIllllllIIIIIIIlIl = 6;
                    break;
                }
                case 312: {
                    llllllllllllllIIllllllIIIIIIIlIl = 7;
                    break;
                }
                case 303: {
                    llllllllllllllIIllllllIIIIIIIlIl = 8;
                    break;
                }
                case 334: {
                    llllllllllllllIIllllllIIIIIIIlIl = 9;
                    break;
                }
                case 324: {
                    llllllllllllllIIllllllIIIIIIIlIl = 10;
                    break;
                }
                case 326: {
                    llllllllllllllIIllllllIIIIIIIlIl = 11;
                    break;
                }
                default: {
                    badNewExpr();
                    break;
                }
            }
            this.bytecode.addOpcode(188);
            this.bytecode.add(llllllllllllllIIllllllIIIIIIIlIl);
        }
        if (llllllllllllllIIlllllIllllllIlll != null) {
            final int llllllllllllllIIllllllIIIIIIIIll = llllllllllllllIIlllllIllllllIlll.size();
            ASTList llllllllllllllIIllllllIIIIIIIIlI = llllllllllllllIIlllllIllllllIlll;
            for (int llllllllllllllIIllllllIIIIIIIlII = 0; llllllllllllllIIllllllIIIIIIIlII < llllllllllllllIIllllllIIIIIIIIll; ++llllllllllllllIIllllllIIIIIIIlII) {
                this.bytecode.addOpcode(89);
                this.bytecode.addIconst(llllllllllllllIIllllllIIIIIIIlII);
                llllllllllllllIIllllllIIIIIIIIlI.head().accept(this);
                if (!CodeGen.isRefType(llllllllllllllIIlllllIlllllllIlI)) {
                    this.atNumCastExpr(this.exprType, llllllllllllllIIlllllIlllllllIlI);
                }
                this.bytecode.addOpcode(CodeGen.getArrayWriteOp(llllllllllllllIIlllllIlllllllIlI, 0));
                llllllllllllllIIllllllIIIIIIIIlI = llllllllllllllIIllllllIIIIIIIIlI.tail();
            }
        }
        this.exprType = llllllllllllllIIlllllIlllllllIlI;
        this.arrayDim = 1;
        this.className = llllllllllllllIIlllllIllllllllII;
    }
    
    protected CtField fieldAccess(final ASTree llllllllllllllIIlllllIIlllIIIlll, final boolean llllllllllllllIIlllllIIlllIIIllI) throws CompileError {
        if (llllllllllllllIIlllllIIlllIIIlll instanceof Member) {
            final String llllllllllllllIIlllllIIlllIlIIll = ((Member)llllllllllllllIIlllllIIlllIIIlll).get();
            CtField llllllllllllllIIlllllIIlllIlIIlI = null;
            try {
                llllllllllllllIIlllllIIlllIlIIlI = this.thisClass.getField(llllllllllllllIIlllllIIlllIlIIll);
            }
            catch (NotFoundException llllllllllllllIIlllllIIlllIlIlII) {
                throw new NoFieldException(llllllllllllllIIlllllIIlllIlIIll, llllllllllllllIIlllllIIlllIIIlll);
            }
            final boolean llllllllllllllIIlllllIIlllIlIIIl = Modifier.isStatic(llllllllllllllIIlllllIIlllIlIIlI.getModifiers());
            if (!llllllllllllllIIlllllIIlllIlIIIl) {
                if (this.inStaticMethod) {
                    throw new CompileError(String.valueOf(new StringBuilder().append("not available in a static method: ").append(llllllllllllllIIlllllIIlllIlIIll)));
                }
                this.bytecode.addAload(0);
            }
            this.resultStatic = llllllllllllllIIlllllIIlllIlIIIl;
            return llllllllllllllIIlllllIIlllIlIIlI;
        }
        if (llllllllllllllIIlllllIIlllIIIlll instanceof Expr) {
            final Expr llllllllllllllIIlllllIIlllIIlIlI = (Expr)llllllllllllllIIlllllIIlllIIIlll;
            final int llllllllllllllIIlllllIIlllIIlIIl = llllllllllllllIIlllllIIlllIIlIlI.getOperator();
            if (llllllllllllllIIlllllIIlllIIlIIl == 35) {
                final CtField llllllllllllllIIlllllIIlllIlIIII = this.resolver.lookupField(((Symbol)llllllllllllllIIlllllIIlllIIlIlI.oprand1()).get(), (Symbol)llllllllllllllIIlllllIIlllIIlIlI.oprand2());
                this.resultStatic = true;
                return llllllllllllllIIlllllIIlllIlIIII;
            }
            if (llllllllllllllIIlllllIIlllIIlIIl == 46) {
                CtField llllllllllllllIIlllllIIlllIIlIll = null;
                try {
                    llllllllllllllIIlllllIIlllIIlIlI.oprand1().accept(this);
                    if (this.exprType == 307 && this.arrayDim == 0) {
                        llllllllllllllIIlllllIIlllIIlIll = this.resolver.lookupFieldByJvmName(this.className, (Symbol)llllllllllllllIIlllllIIlllIIlIlI.oprand2());
                    }
                    else {
                        if (llllllllllllllIIlllllIIlllIIIllI && this.arrayDim > 0 && ((Symbol)llllllllllllllIIlllllIIlllIIlIlI.oprand2()).get().equals("length")) {
                            return null;
                        }
                        badLvalue();
                    }
                    final boolean llllllllllllllIIlllllIIlllIIllll = Modifier.isStatic(llllllllllllllIIlllllIIlllIIlIll.getModifiers());
                    if (llllllllllllllIIlllllIIlllIIllll) {
                        this.bytecode.addOpcode(87);
                    }
                    this.resultStatic = llllllllllllllIIlllllIIlllIIllll;
                    return llllllllllllllIIlllllIIlllIIlIll;
                }
                catch (NoFieldException llllllllllllllIIlllllIIlllIIllII) {
                    if (llllllllllllllIIlllllIIlllIIllII.getExpr() != llllllllllllllIIlllllIIlllIIlIlI.oprand1()) {
                        throw llllllllllllllIIlllllIIlllIIllII;
                    }
                    final Symbol llllllllllllllIIlllllIIlllIIlllI = (Symbol)llllllllllllllIIlllllIIlllIIlIlI.oprand2();
                    final String llllllllllllllIIlllllIIlllIIllIl = llllllllllllllIIlllllIIlllIIllII.getField();
                    llllllllllllllIIlllllIIlllIIlIll = this.resolver.lookupFieldByJvmName2(llllllllllllllIIlllllIIlllIIllIl, llllllllllllllIIlllllIIlllIIlllI, llllllllllllllIIlllllIIlllIIIlll);
                    this.resultStatic = true;
                    return llllllllllllllIIlllllIIlllIIlIll;
                }
            }
            badLvalue();
        }
        else {
            badLvalue();
        }
        this.resultStatic = false;
        return null;
    }
    
    protected String getAccessiblePrivate(final String llllllllllllllIIlllllIllIIllIIlI, final String llllllllllllllIIlllllIllIIllIIIl, final String llllllllllllllIIlllllIllIIllIIII, final MethodInfo llllllllllllllIIlllllIllIIllIlIl, final CtClass llllllllllllllIIlllllIllIIllIlII) throws CompileError {
        if (this.isEnclosing(llllllllllllllIIlllllIllIIllIlII, this.thisClass)) {
            final AccessorMaker llllllllllllllIIlllllIllIIlllIlI = llllllllllllllIIlllllIllIIllIlII.getAccessorMaker();
            if (llllllllllllllIIlllllIllIIlllIlI != null) {
                return llllllllllllllIIlllllIllIIlllIlI.getMethodAccessor(llllllllllllllIIlllllIllIIllIIlI, llllllllllllllIIlllllIllIIllIIIl, llllllllllllllIIlllllIllIIllIIII, llllllllllllllIIlllllIllIIllIlIl);
            }
        }
        throw new CompileError(String.valueOf(new StringBuilder().append("Method ").append(llllllllllllllIIlllllIllIIllIIlI).append(" is private")));
    }
    
    public CtClass[] makeParamList(final MethodDecl llllllllllllllIIlllllIIllIllIIII) throws CompileError {
        ASTList llllllllllllllIIlllllIIllIllIIlI = llllllllllllllIIlllllIIllIllIIII.getParams();
        CtClass[] llllllllllllllIIlllllIIllIllIIll = null;
        if (llllllllllllllIIlllllIIllIllIIlI == null) {
            final CtClass[] llllllllllllllIIlllllIIllIllIlll = new CtClass[0];
        }
        else {
            int llllllllllllllIIlllllIIllIllIllI = 0;
            llllllllllllllIIlllllIIllIllIIll = new CtClass[llllllllllllllIIlllllIIllIllIIlI.length()];
            while (llllllllllllllIIlllllIIllIllIIlI != null) {
                llllllllllllllIIlllllIIllIllIIll[llllllllllllllIIlllllIIllIllIllI++] = this.resolver.lookupClass((Declarator)llllllllllllllIIlllllIIllIllIIlI.head());
                llllllllllllllIIlllllIIllIllIIlI = llllllllllllllIIlllllIIllIllIIlI.tail();
            }
        }
        return llllllllllllllIIlllllIIllIllIIll;
    }
    
    @Override
    protected void atArrayVariableAssign(final ArrayInit llllllllllllllIIlllllIlllllIlIII, final int llllllllllllllIIlllllIlllllIllII, final int llllllllllllllIIlllllIlllllIlIll, final String llllllllllllllIIlllllIlllllIlIlI) throws CompileError {
        this.atNewArrayExpr2(llllllllllllllIIlllllIlllllIllII, null, llllllllllllllIIlllllIlllllIlIlI, llllllllllllllIIlllllIlllllIlIII);
    }
    
    @Override
    public void atCallExpr(final CallExpr llllllllllllllIIlllllIlllIlIllIl) throws CompileError {
        String llllllllllllllIIlllllIlllIllIllI = null;
        CtClass llllllllllllllIIlllllIlllIllIlIl = null;
        final ASTree llllllllllllllIIlllllIlllIllIlII = llllllllllllllIIlllllIlllIlIllIl.oprand1();
        final ASTList llllllllllllllIIlllllIlllIllIIll = (ASTList)llllllllllllllIIlllllIlllIlIllIl.oprand2();
        boolean llllllllllllllIIlllllIlllIllIIlI = false;
        boolean llllllllllllllIIlllllIlllIllIIIl = false;
        int llllllllllllllIIlllllIlllIllIIII = -1;
        final MemberResolver.Method llllllllllllllIIlllllIlllIlIllll = llllllllllllllIIlllllIlllIlIllIl.getMethod();
        if (llllllllllllllIIlllllIlllIllIlII instanceof Member) {
            llllllllllllllIIlllllIlllIllIllI = ((Member)llllllllllllllIIlllllIlllIllIlII).get();
            llllllllllllllIIlllllIlllIllIlIl = this.thisClass;
            if (this.inStaticMethod || (llllllllllllllIIlllllIlllIlIllll != null && llllllllllllllIIlllllIlllIlIllll.isStatic())) {
                llllllllllllllIIlllllIlllIllIIlI = true;
            }
            else {
                llllllllllllllIIlllllIlllIllIIII = this.bytecode.currentPc();
                this.bytecode.addAload(0);
            }
        }
        else if (llllllllllllllIIlllllIlllIllIlII instanceof Keyword) {
            llllllllllllllIIlllllIlllIllIIIl = true;
            llllllllllllllIIlllllIlllIllIllI = "<init>";
            llllllllllllllIIlllllIlllIllIlIl = this.thisClass;
            if (this.inStaticMethod) {
                throw new CompileError("a constructor cannot be static");
            }
            this.bytecode.addAload(0);
            if (((Keyword)llllllllllllllIIlllllIlllIllIlII).get() == 336) {
                llllllllllllllIIlllllIlllIllIlIl = MemberResolver.getSuperclass(llllllllllllllIIlllllIlllIllIlIl);
            }
        }
        else if (llllllllllllllIIlllllIlllIllIlII instanceof Expr) {
            final Expr llllllllllllllIIlllllIlllIlllIlI = (Expr)llllllllllllllIIlllllIlllIllIlII;
            llllllllllllllIIlllllIlllIllIllI = ((Symbol)llllllllllllllIIlllllIlllIlllIlI.oprand2()).get();
            final int llllllllllllllIIlllllIlllIlllIIl = llllllllllllllIIlllllIlllIlllIlI.getOperator();
            if (llllllllllllllIIlllllIlllIlllIIl == 35) {
                llllllllllllllIIlllllIlllIllIlIl = this.resolver.lookupClass(((Symbol)llllllllllllllIIlllllIlllIlllIlI.oprand1()).get(), false);
                llllllllllllllIIlllllIlllIllIIlI = true;
            }
            else if (llllllllllllllIIlllllIlllIlllIIl == 46) {
                final ASTree llllllllllllllIIlllllIlllIllllII = llllllllllllllIIlllllIlllIlllIlI.oprand1();
                final String llllllllllllllIIlllllIlllIlllIll = TypeChecker.isDotSuper(llllllllllllllIIlllllIlllIllllII);
                if (llllllllllllllIIlllllIlllIlllIll != null) {
                    llllllllllllllIIlllllIlllIllIIIl = true;
                    llllllllllllllIIlllllIlllIllIlIl = MemberResolver.getSuperInterface(this.thisClass, llllllllllllllIIlllllIlllIlllIll);
                    if (this.inStaticMethod || (llllllllllllllIIlllllIlllIlIllll != null && llllllllllllllIIlllllIlllIlIllll.isStatic())) {
                        llllllllllllllIIlllllIlllIllIIlI = true;
                    }
                    else {
                        llllllllllllllIIlllllIlllIllIIII = this.bytecode.currentPc();
                        this.bytecode.addAload(0);
                    }
                }
                else {
                    if (llllllllllllllIIlllllIlllIllllII instanceof Keyword && ((Keyword)llllllllllllllIIlllllIlllIllllII).get() == 336) {
                        llllllllllllllIIlllllIlllIllIIIl = true;
                    }
                    try {
                        llllllllllllllIIlllllIlllIllllII.accept(this);
                    }
                    catch (NoFieldException llllllllllllllIIlllllIlllIllllIl) {
                        if (llllllllllllllIIlllllIlllIllllIl.getExpr() != llllllllllllllIIlllllIlllIllllII) {
                            throw llllllllllllllIIlllllIlllIllllIl;
                        }
                        this.exprType = 307;
                        this.arrayDim = 0;
                        this.className = llllllllllllllIIlllllIlllIllllIl.getField();
                        llllllllllllllIIlllllIlllIllIIlI = true;
                    }
                    if (this.arrayDim > 0) {
                        llllllllllllllIIlllllIlllIllIlIl = this.resolver.lookupClass("java.lang.Object", true);
                    }
                    else if (this.exprType == 307) {
                        llllllllllllllIIlllllIlllIllIlIl = this.resolver.lookupClassByJvmName(this.className);
                    }
                    else {
                        badMethod();
                    }
                }
            }
            else {
                badMethod();
            }
        }
        else {
            fatal();
        }
        this.atMethodCallCore(llllllllllllllIIlllllIlllIllIlIl, llllllllllllllIIlllllIlllIllIllI, llllllllllllllIIlllllIlllIllIIll, llllllllllllllIIlllllIlllIllIIlI, llllllllllllllIIlllllIlllIllIIIl, llllllllllllllIIlllllIlllIllIIII, llllllllllllllIIlllllIlllIlIllll);
    }
    
    private void atFieldAssignCore(final CtField llllllllllllllIIlllllIlIlIIIIlIl, final boolean llllllllllllllIIlllllIlIlIIIlIIl, final int llllllllllllllIIlllllIlIlIIIlIII, final boolean llllllllllllllIIlllllIlIlIIIIlll) throws CompileError {
        if (llllllllllllllIIlllllIlIlIIIlIII != 0) {
            if (llllllllllllllIIlllllIlIlIIIlIIl) {
                this.bytecode.add(179);
                this.bytecode.growStack(llllllllllllllIIlllllIlIlIIIIlll ? -2 : -1);
            }
            else {
                this.bytecode.add(181);
                this.bytecode.growStack(llllllllllllllIIlllllIlIlIIIIlll ? -3 : -2);
            }
            this.bytecode.addIndex(llllllllllllllIIlllllIlIlIIIlIII);
        }
        else {
            final CtClass llllllllllllllIIlllllIlIlIIIllll = llllllllllllllIIlllllIlIlIIIIlIl.getDeclaringClass();
            final AccessorMaker llllllllllllllIIlllllIlIlIIIlllI = llllllllllllllIIlllllIlIlIIIllll.getAccessorMaker();
            final FieldInfo llllllllllllllIIlllllIlIlIIIllIl = llllllllllllllIIlllllIlIlIIIIlIl.getFieldInfo2();
            final MethodInfo llllllllllllllIIlllllIlIlIIIllII = llllllllllllllIIlllllIlIlIIIlllI.getFieldSetter(llllllllllllllIIlllllIlIlIIIllIl, llllllllllllllIIlllllIlIlIIIlIIl);
            this.bytecode.addInvokestatic(llllllllllllllIIlllllIlIlIIIllll, llllllllllllllIIlllllIlIlIIIllII.getName(), llllllllllllllIIlllllIlIlIIIllII.getDescriptor());
        }
    }
    
    static class JsrHook extends ReturnHook
    {
        /* synthetic */ List<int[]> jsrList;
        /* synthetic */ CodeGen cgen;
        /* synthetic */ int var;
        
        private void jsrJmp(final Bytecode lllllllllllllIlIIlllIlIlIIIIIlIl) {
            lllllllllllllIlIIlllIlIlIIIIIlIl.addOpcode(167);
            this.jsrList.add(new int[] { lllllllllllllIlIIlllIlIlIIIIIlIl.currentPc(), this.var });
            lllllllllllllIlIIlllIlIlIIIIIlIl.addIndex(0);
        }
        
        @Override
        protected boolean doit(final Bytecode lllllllllllllIlIIlllIlIIllllllIl, final int lllllllllllllIlIIlllIlIIllllllll) {
            switch (lllllllllllllIlIIlllIlIIllllllll) {
                case 177: {
                    this.jsrJmp(lllllllllllllIlIIlllIlIIllllllIl);
                    break;
                }
                case 176: {
                    lllllllllllllIlIIlllIlIIllllllIl.addAstore(this.getVar(1));
                    this.jsrJmp(lllllllllllllIlIIlllIlIIllllllIl);
                    lllllllllllllIlIIlllIlIIllllllIl.addAload(this.var);
                    break;
                }
                case 172: {
                    lllllllllllllIlIIlllIlIIllllllIl.addIstore(this.getVar(1));
                    this.jsrJmp(lllllllllllllIlIIlllIlIIllllllIl);
                    lllllllllllllIlIIlllIlIIllllllIl.addIload(this.var);
                    break;
                }
                case 173: {
                    lllllllllllllIlIIlllIlIIllllllIl.addLstore(this.getVar(2));
                    this.jsrJmp(lllllllllllllIlIIlllIlIIllllllIl);
                    lllllllllllllIlIIlllIlIIllllllIl.addLload(this.var);
                    break;
                }
                case 175: {
                    lllllllllllllIlIIlllIlIIllllllIl.addDstore(this.getVar(2));
                    this.jsrJmp(lllllllllllllIlIIlllIlIIllllllIl);
                    lllllllllllllIlIIlllIlIIllllllIl.addDload(this.var);
                    break;
                }
                case 174: {
                    lllllllllllllIlIIlllIlIIllllllIl.addFstore(this.getVar(1));
                    this.jsrJmp(lllllllllllllIlIIlllIlIIllllllIl);
                    lllllllllllllIlIIlllIlIIllllllIl.addFload(this.var);
                    break;
                }
                default: {
                    throw new RuntimeException("fatal");
                }
            }
            return false;
        }
        
        JsrHook(final CodeGen lllllllllllllIlIIlllIlIlIIIlIIIl) {
            super(lllllllllllllIlIIlllIlIlIIIlIIIl);
            this.jsrList = new ArrayList<int[]>();
            this.cgen = lllllllllllllIlIIlllIlIlIIIlIIIl;
            this.var = -1;
        }
        
        private int getVar(final int lllllllllllllIlIIlllIlIlIIIIlIll) {
            if (this.var < 0) {
                this.var = this.cgen.getMaxLocals();
                this.cgen.incMaxLocals(lllllllllllllIlIIlllIlIlIIIIlIll);
            }
            return this.var;
        }
    }
    
    static class JsrHook2 extends ReturnHook
    {
        /* synthetic */ int var;
        /* synthetic */ int target;
        
        @Override
        protected boolean doit(final Bytecode lllllllllllllIllllIlllllIIIlIIII, final int lllllllllllllIllllIlllllIIIIllII) {
            switch (lllllllllllllIllllIlllllIIIIllII) {
                case 177: {
                    break;
                }
                case 176: {
                    lllllllllllllIllllIlllllIIIlIIII.addAstore(this.var);
                    break;
                }
                case 172: {
                    lllllllllllllIllllIlllllIIIlIIII.addIstore(this.var);
                    break;
                }
                case 173: {
                    lllllllllllllIllllIlllllIIIlIIII.addLstore(this.var);
                    break;
                }
                case 175: {
                    lllllllllllllIllllIlllllIIIlIIII.addDstore(this.var);
                    break;
                }
                case 174: {
                    lllllllllllllIllllIlllllIIIlIIII.addFstore(this.var);
                    break;
                }
                default: {
                    throw new RuntimeException("fatal");
                }
            }
            lllllllllllllIllllIlllllIIIlIIII.addOpcode(167);
            lllllllllllllIllllIlllllIIIlIIII.addIndex(this.target - lllllllllllllIllllIlllllIIIlIIII.currentPc() + 3);
            return true;
        }
        
        JsrHook2(final CodeGen lllllllllllllIllllIlllllIlIIIlII, final int[] lllllllllllllIllllIlllllIlIIIIll) {
            super(lllllllllllllIllllIlllllIlIIIlII);
            this.target = lllllllllllllIllllIlllllIlIIIIll[0];
            this.var = lllllllllllllIllllIlllllIlIIIIll[1];
        }
    }
}
