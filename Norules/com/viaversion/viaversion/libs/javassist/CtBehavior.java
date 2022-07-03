package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.compiler.*;
import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.expr.*;

public abstract class CtBehavior extends CtMember
{
    protected /* synthetic */ MethodInfo methodInfo;
    
    @Override
    public void setAttribute(final String llllllllllllllIIIlIIllIIIIlIIIlI, final byte[] llllllllllllllIIIlIIllIIIIIllllI) {
        this.declaringClass.checkModify();
        this.methodInfo.addAttribute(new AttributeInfo(this.methodInfo.getConstPool(), llllllllllllllIIIlIIllIIIIlIIIlI, llllllllllllllIIIlIIllIIIIIllllI));
    }
    
    @Override
    public void setModifiers(final int llllllllllllllIIIlIIllIIlllIIIII) {
        this.declaringClass.checkModify();
        this.methodInfo.setAccessFlags(AccessFlag.of(llllllllllllllIIIlIIllIIlllIIIII));
    }
    
    private void insertBefore(final String llllllllllllllIIIlIIlIllIllllIlI, final boolean llllllllllllllIIIlIIlIllIlllIIlI) throws CannotCompileException {
        final CtClass llllllllllllllIIIlIIlIllIllllIII = this.declaringClass;
        llllllllllllllIIIlIIlIllIllllIII.checkModify();
        final CodeAttribute llllllllllllllIIIlIIlIllIlllIlll = this.methodInfo.getCodeAttribute();
        if (llllllllllllllIIIlIIlIllIlllIlll == null) {
            throw new CannotCompileException("no method body");
        }
        final CodeIterator llllllllllllllIIIlIIlIllIlllIllI = llllllllllllllIIIlIIlIllIlllIlll.iterator();
        final Javac llllllllllllllIIIlIIlIllIlllIlIl = new Javac(llllllllllllllIIIlIIlIllIllllIII);
        try {
            final int llllllllllllllIIIlIIlIlllIIIIIll = llllllllllllllIIIlIIlIllIlllIlIl.recordParams(this.getParameterTypes(), Modifier.isStatic(this.getModifiers()));
            llllllllllllllIIIlIIlIllIlllIlIl.recordParamNames(llllllllllllllIIIlIIlIllIlllIlll, llllllllllllllIIIlIIlIlllIIIIIll);
            llllllllllllllIIIlIIlIllIlllIlIl.recordLocalVariables(llllllllllllllIIIlIIlIllIlllIlll, 0);
            llllllllllllllIIIlIIlIllIlllIlIl.recordReturnType(this.getReturnType0(), false);
            llllllllllllllIIIlIIlIllIlllIlIl.compileStmnt(llllllllllllllIIIlIIlIllIllllIlI);
            final Bytecode llllllllllllllIIIlIIlIlllIIIIIlI = llllllllllllllIIIlIIlIllIlllIlIl.getBytecode();
            final int llllllllllllllIIIlIIlIlllIIIIIIl = llllllllllllllIIIlIIlIlllIIIIIlI.getMaxStack();
            final int llllllllllllllIIIlIIlIlllIIIIIII = llllllllllllllIIIlIIlIlllIIIIIlI.getMaxLocals();
            if (llllllllllllllIIIlIIlIlllIIIIIIl > llllllllllllllIIIlIIlIllIlllIlll.getMaxStack()) {
                llllllllllllllIIIlIIlIllIlllIlll.setMaxStack(llllllllllllllIIIlIIlIlllIIIIIIl);
            }
            if (llllllllllllllIIIlIIlIlllIIIIIII > llllllllllllllIIIlIIlIllIlllIlll.getMaxLocals()) {
                llllllllllllllIIIlIIlIllIlllIlll.setMaxLocals(llllllllllllllIIIlIIlIlllIIIIIII);
            }
            final int llllllllllllllIIIlIIlIllIlllllll = llllllllllllllIIIlIIlIllIlllIllI.insertEx(llllllllllllllIIIlIIlIlllIIIIIlI.get());
            llllllllllllllIIIlIIlIllIlllIllI.insert(llllllllllllllIIIlIIlIlllIIIIIlI.getExceptionTable(), llllllllllllllIIIlIIlIllIlllllll);
            if (llllllllllllllIIIlIIlIllIlllIIlI) {
                this.methodInfo.rebuildStackMapIf6(llllllllllllllIIIlIIlIllIllllIII.getClassPool(), llllllllllllllIIIlIIlIllIllllIII.getClassFile2());
            }
        }
        catch (NotFoundException llllllllllllllIIIlIIlIllIllllllI) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIllIllllllI);
        }
        catch (CompileError llllllllllllllIIIlIIlIllIlllllIl) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIllIlllllIl);
        }
        catch (BadBytecode llllllllllllllIIIlIIlIllIlllllII) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIllIlllllII);
        }
    }
    
    Object[][] getParameterAnnotations(final boolean llllllllllllllIIIlIIllIIlIIlIlIl) throws ClassNotFoundException {
        final MethodInfo llllllllllllllIIIlIIllIIlIIllIIl = this.getMethodInfo2();
        final ParameterAnnotationsAttribute llllllllllllllIIIlIIllIIlIIllIII = (ParameterAnnotationsAttribute)llllllllllllllIIIlIIllIIlIIllIIl.getAttribute("RuntimeInvisibleParameterAnnotations");
        final ParameterAnnotationsAttribute llllllllllllllIIIlIIllIIlIIlIlll = (ParameterAnnotationsAttribute)llllllllllllllIIIlIIllIIlIIllIIl.getAttribute("RuntimeVisibleParameterAnnotations");
        return CtClassType.toAnnotationType(llllllllllllllIIIlIIllIIlIIlIlIl, this.getDeclaringClass().getClassPool(), llllllllllllllIIIlIIllIIlIIllIII, llllllllllllllIIIlIIllIIlIIlIlll, llllllllllllllIIIlIIllIIlIIllIIl);
    }
    
    public void insertBefore(final String llllllllllllllIIIlIIlIlllIIlIIlI) throws CannotCompileException {
        this.insertBefore(llllllllllllllIIIlIIlIlllIIlIIlI, true);
    }
    
    public Object[][] getAvailableParameterAnnotations() {
        try {
            return this.getParameterAnnotations(true);
        }
        catch (ClassNotFoundException llllllllllllllIIIlIIllIIlIlIIlII) {
            throw new RuntimeException("Unexpected exception", llllllllllllllIIIlIIllIIlIlIIlII);
        }
    }
    
    public void insertAfter(final String llllllllllllllIIIlIIlIllIlIllIll, final boolean llllllllllllllIIIlIIlIllIlIlllIl) throws CannotCompileException {
        this.insertAfter(llllllllllllllIIIlIIlIllIlIllIll, llllllllllllllIIIlIIlIllIlIlllIl, false);
    }
    
    private void addParameter2(final int llllllllllllllIIIlIIlIlllIllIIll, final CtClass llllllllllllllIIIlIIlIlllIlIllIl, final String llllllllllllllIIIlIIlIlllIllIIIl) throws BadBytecode {
        final CodeAttribute llllllllllllllIIIlIIlIlllIllIIII = this.methodInfo.getCodeAttribute();
        if (llllllllllllllIIIlIIlIlllIllIIII != null) {
            int llllllllllllllIIIlIIlIlllIlllIll = 1;
            char llllllllllllllIIIlIIlIlllIlllIlI = 'L';
            int llllllllllllllIIIlIIlIlllIlllIIl = 0;
            if (llllllllllllllIIIlIIlIlllIlIllIl.isPrimitive()) {
                final CtPrimitiveType llllllllllllllIIIlIIlIlllIllllII = (CtPrimitiveType)llllllllllllllIIIlIIlIlllIlIllIl;
                llllllllllllllIIIlIIlIlllIlllIll = llllllllllllllIIIlIIlIlllIllllII.getDataSize();
                llllllllllllllIIIlIIlIlllIlllIlI = llllllllllllllIIIlIIlIlllIllllII.getDescriptor();
            }
            else {
                llllllllllllllIIIlIIlIlllIlllIIl = this.methodInfo.getConstPool().addClassInfo(llllllllllllllIIIlIIlIlllIlIllIl);
            }
            llllllllllllllIIIlIIlIlllIllIIII.insertLocalVar(llllllllllllllIIIlIIlIlllIllIIll, llllllllllllllIIIlIIlIlllIlllIll);
            final LocalVariableAttribute llllllllllllllIIIlIIlIlllIlllIII = (LocalVariableAttribute)llllllllllllllIIIlIIlIlllIllIIII.getAttribute("LocalVariableTable");
            if (llllllllllllllIIIlIIlIlllIlllIII != null) {
                llllllllllllllIIIlIIlIlllIlllIII.shiftIndex(llllllllllllllIIIlIIlIlllIllIIll, llllllllllllllIIIlIIlIlllIlllIll);
            }
            final LocalVariableTypeAttribute llllllllllllllIIIlIIlIlllIllIlll = (LocalVariableTypeAttribute)llllllllllllllIIIlIIlIlllIllIIII.getAttribute("LocalVariableTypeTable");
            if (llllllllllllllIIIlIIlIlllIllIlll != null) {
                llllllllllllllIIIlIIlIlllIllIlll.shiftIndex(llllllllllllllIIIlIIlIlllIllIIll, llllllllllllllIIIlIIlIlllIlllIll);
            }
            final StackMapTable llllllllllllllIIIlIIlIlllIllIllI = (StackMapTable)llllllllllllllIIIlIIlIlllIllIIII.getAttribute("StackMapTable");
            if (llllllllllllllIIIlIIlIlllIllIllI != null) {
                llllllllllllllIIIlIIlIlllIllIllI.insertLocal(llllllllllllllIIIlIIlIlllIllIIll, StackMapTable.typeTagOf(llllllllllllllIIIlIIlIlllIlllIlI), llllllllllllllIIIlIIlIlllIlllIIl);
            }
            final StackMap llllllllllllllIIIlIIlIlllIllIlIl = (StackMap)llllllllllllllIIIlIIlIlllIllIIII.getAttribute("StackMap");
            if (llllllllllllllIIIlIIlIlllIllIlIl != null) {
                llllllllllllllIIIlIIlIlllIllIlIl.insertLocal(llllllllllllllIIIlIIlIlllIllIIll, StackMapTable.typeTagOf(llllllllllllllIIIlIIlIlllIlllIlI), llllllllllllllIIIlIIlIlllIlllIIl);
            }
        }
    }
    
    public abstract String getLongName();
    
    public void addLocalVariable(final String llllllllllllllIIIlIIlIllllllIlll, final CtClass llllllllllllllIIIlIIlIllllllIllI) throws CannotCompileException {
        this.declaringClass.checkModify();
        final ConstPool llllllllllllllIIIlIIlIllllllIlIl = this.methodInfo.getConstPool();
        final CodeAttribute llllllllllllllIIIlIIlIllllllIlII = this.methodInfo.getCodeAttribute();
        if (llllllllllllllIIIlIIlIllllllIlII == null) {
            throw new CannotCompileException("no method body");
        }
        LocalVariableAttribute llllllllllllllIIIlIIlIllllllIIll = (LocalVariableAttribute)llllllllllllllIIIlIIlIllllllIlII.getAttribute("LocalVariableTable");
        if (llllllllllllllIIIlIIlIllllllIIll == null) {
            llllllllllllllIIIlIIlIllllllIIll = new LocalVariableAttribute(llllllllllllllIIIlIIlIllllllIlIl);
            llllllllllllllIIIlIIlIllllllIlII.getAttributes().add(llllllllllllllIIIlIIlIllllllIIll);
        }
        final int llllllllllllllIIIlIIlIllllllIIlI = llllllllllllllIIIlIIlIllllllIlII.getMaxLocals();
        final String llllllllllllllIIIlIIlIllllllIIIl = Descriptor.of(llllllllllllllIIIlIIlIllllllIllI);
        llllllllllllllIIIlIIlIllllllIIll.addEntry(0, llllllllllllllIIIlIIlIllllllIlII.getCodeLength(), llllllllllllllIIIlIIlIllllllIlIl.addUtf8Info(llllllllllllllIIIlIIlIllllllIlll), llllllllllllllIIIlIIlIllllllIlIl.addUtf8Info(llllllllllllllIIIlIIlIllllllIIIl), llllllllllllllIIIlIIlIllllllIIlI);
        llllllllllllllIIIlIIlIllllllIlII.setMaxLocals(llllllllllllllIIIlIIlIllllllIIlI + Descriptor.dataSize(llllllllllllllIIIlIIlIllllllIIIl));
    }
    
    public int insertAt(final int llllllllllllllIIIlIIlIlIIlllIllI, final String llllllllllllllIIIlIIlIlIIlllIlIl) throws CannotCompileException {
        return this.insertAt(llllllllllllllIIIlIIlIlIIlllIllI, true, llllllllllllllIIIlIIlIlIIlllIlIl);
    }
    
    public void insertParameter(final CtClass llllllllllllllIIIlIIlIlllllIIIIl) throws CannotCompileException {
        this.declaringClass.checkModify();
        final String llllllllllllllIIIlIIlIlllllIIIII = this.methodInfo.getDescriptor();
        final String llllllllllllllIIIlIIlIllllIlllll = Descriptor.insertParameter(llllllllllllllIIIlIIlIlllllIIIIl, llllllllllllllIIIlIIlIlllllIIIII);
        try {
            this.addParameter2(Modifier.isStatic(this.getModifiers()) ? 0 : 1, llllllllllllllIIIlIIlIlllllIIIIl, llllllllllllllIIIlIIlIlllllIIIII);
        }
        catch (BadBytecode llllllllllllllIIIlIIlIlllllIIIll) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIlllllIIIll);
        }
        this.methodInfo.setDescriptor(llllllllllllllIIIlIIlIllllIlllll);
    }
    
    @Override
    public int getModifiers() {
        return AccessFlag.toModifier(this.methodInfo.getAccessFlags());
    }
    
    public void insertAfter(final String llllllllllllllIIIlIIlIllIllIIlIl) throws CannotCompileException {
        this.insertAfter(llllllllllllllIIIlIIlIllIllIIlIl, false, false);
    }
    
    private Object[] getAnnotations(final boolean llllllllllllllIIIlIIllIIlIllIIlI) throws ClassNotFoundException {
        final MethodInfo llllllllllllllIIIlIIllIIlIllIIIl = this.getMethodInfo2();
        final AnnotationsAttribute llllllllllllllIIIlIIllIIlIllIIII = (AnnotationsAttribute)llllllllllllllIIIlIIllIIlIllIIIl.getAttribute("RuntimeInvisibleAnnotations");
        final AnnotationsAttribute llllllllllllllIIIlIIllIIlIlIllll = (AnnotationsAttribute)llllllllllllllIIIlIIllIIlIllIIIl.getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.toAnnotationType(llllllllllllllIIIlIIllIIlIllIIlI, this.getDeclaringClass().getClassPool(), llllllllllllllIIIlIIllIIlIllIIII, llllllllllllllIIIlIIllIIlIlIllll);
    }
    
    static void setBody0(final CtClass llllllllllllllIIIlIIllIIIIllllII, final MethodInfo llllllllllllllIIIlIIllIIIIllIllI, final CtClass llllllllllllllIIIlIIllIIIIllIlIl, final MethodInfo llllllllllllllIIIlIIllIIIIlllIIl, ClassMap llllllllllllllIIIlIIllIIIIllIIll) throws CannotCompileException {
        llllllllllllllIIIlIIllIIIIllIlIl.checkModify();
        llllllllllllllIIIlIIllIIIIllIIll = new ClassMap(llllllllllllllIIIlIIllIIIIllIIll);
        llllllllllllllIIIlIIllIIIIllIIll.put(llllllllllllllIIIlIIllIIIIllllII.getName(), llllllllllllllIIIlIIllIIIIllIlIl.getName());
        try {
            final CodeAttribute llllllllllllllIIIlIIllIIIIlllllI = llllllllllllllIIIlIIllIIIIllIllI.getCodeAttribute();
            if (llllllllllllllIIIlIIllIIIIlllllI != null) {
                final ConstPool llllllllllllllIIIlIIllIIIlIIIIII = llllllllllllllIIIlIIllIIIIlllIIl.getConstPool();
                final CodeAttribute llllllllllllllIIIlIIllIIIIllllll = (CodeAttribute)llllllllllllllIIIlIIllIIIIlllllI.copy(llllllllllllllIIIlIIllIIIlIIIIII, llllllllllllllIIIlIIllIIIIllIIll);
                llllllllllllllIIIlIIllIIIIlllIIl.setCodeAttribute(llllllllllllllIIIlIIllIIIIllllll);
            }
        }
        catch (CodeAttribute.RuntimeCopyException llllllllllllllIIIlIIllIIIIllllIl) {
            throw new CannotCompileException(llllllllllllllIIIlIIllIIIIllllIl);
        }
        llllllllllllllIIIlIIllIIIIlllIIl.setAccessFlags(llllllllllllllIIIlIIllIIIIlllIIl.getAccessFlags() & 0xFFFFFBFF);
        llllllllllllllIIIlIIllIIIIllIlIl.rebuildClassFile();
    }
    
    public int insertAt(int llllllllllllllIIIlIIlIlIIlIlIlII, final boolean llllllllllllllIIIlIIlIlIIlIllllI, final String llllllllllllllIIIlIIlIlIIlIlIIlI) throws CannotCompileException {
        final CodeAttribute llllllllllllllIIIlIIlIlIIlIlllII = this.methodInfo.getCodeAttribute();
        if (llllllllllllllIIIlIIlIlIIlIlllII == null) {
            throw new CannotCompileException("no method body");
        }
        final LineNumberAttribute llllllllllllllIIIlIIlIlIIlIllIll = (LineNumberAttribute)llllllllllllllIIIlIIlIlIIlIlllII.getAttribute("LineNumberTable");
        if (llllllllllllllIIIlIIlIlIIlIllIll == null) {
            throw new CannotCompileException("no line number info");
        }
        final LineNumberAttribute.Pc llllllllllllllIIIlIIlIlIIlIllIlI = llllllllllllllIIIlIIlIlIIlIllIll.toNearPc(llllllllllllllIIIlIIlIlIIlIlIlII);
        llllllllllllllIIIlIIlIlIIlIlIlII = llllllllllllllIIIlIIlIlIIlIllIlI.line;
        int llllllllllllllIIIlIIlIlIIlIllIIl = llllllllllllllIIIlIIlIlIIlIllIlI.index;
        if (!llllllllllllllIIIlIIlIlIIlIllllI) {
            return llllllllllllllIIIlIIlIlIIlIlIlII;
        }
        final CtClass llllllllllllllIIIlIIlIlIIlIllIII = this.declaringClass;
        llllllllllllllIIIlIIlIlIIlIllIII.checkModify();
        final CodeIterator llllllllllllllIIIlIIlIlIIlIlIlll = llllllllllllllIIIlIIlIlIIlIlllII.iterator();
        final Javac llllllllllllllIIIlIIlIlIIlIlIllI = new Javac(llllllllllllllIIIlIIlIlIIlIllIII);
        try {
            llllllllllllllIIIlIIlIlIIlIlIllI.recordLocalVariables(llllllllllllllIIIlIIlIlIIlIlllII, llllllllllllllIIIlIIlIlIIlIllIIl);
            llllllllllllllIIIlIIlIlIIlIlIllI.recordParams(this.getParameterTypes(), Modifier.isStatic(this.getModifiers()));
            llllllllllllllIIIlIIlIlIIlIlIllI.setMaxLocals(llllllllllllllIIIlIIlIlIIlIlllII.getMaxLocals());
            llllllllllllllIIIlIIlIlIIlIlIllI.compileStmnt(llllllllllllllIIIlIIlIlIIlIlIIlI);
            final Bytecode llllllllllllllIIIlIIlIlIIllIIllI = llllllllllllllIIIlIIlIlIIlIlIllI.getBytecode();
            final int llllllllllllllIIIlIIlIlIIllIIlIl = llllllllllllllIIIlIIlIlIIllIIllI.getMaxLocals();
            final int llllllllllllllIIIlIIlIlIIllIIlII = llllllllllllllIIIlIIlIlIIllIIllI.getMaxStack();
            llllllllllllllIIIlIIlIlIIlIlllII.setMaxLocals(llllllllllllllIIIlIIlIlIIllIIlIl);
            if (llllllllllllllIIIlIIlIlIIllIIlII > llllllllllllllIIIlIIlIlIIlIlllII.getMaxStack()) {
                llllllllllllllIIIlIIlIlIIlIlllII.setMaxStack(llllllllllllllIIIlIIlIlIIllIIlII);
            }
            llllllllllllllIIIlIIlIlIIlIllIIl = llllllllllllllIIIlIIlIlIIlIlIlll.insertAt(llllllllllllllIIIlIIlIlIIlIllIIl, llllllllllllllIIIlIIlIlIIllIIllI.get());
            llllllllllllllIIIlIIlIlIIlIlIlll.insert(llllllllllllllIIIlIIlIlIIllIIllI.getExceptionTable(), llllllllllllllIIIlIIlIlIIlIllIIl);
            this.methodInfo.rebuildStackMapIf6(llllllllllllllIIIlIIlIlIIlIllIII.getClassPool(), llllllllllllllIIIlIIlIlIIlIllIII.getClassFile2());
            return llllllllllllllIIIlIIlIlIIlIlIlII;
        }
        catch (NotFoundException llllllllllllllIIIlIIlIlIIllIIIll) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIlIIllIIIll);
        }
        catch (CompileError llllllllllllllIIIlIIlIlIIllIIIlI) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIlIIllIIIlI);
        }
        catch (BadBytecode llllllllllllllIIIlIIlIlIIllIIIIl) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIlIIllIIIIl);
        }
    }
    
    public Object[][] getParameterAnnotations() throws ClassNotFoundException {
        return this.getParameterAnnotations(false);
    }
    
    public void insertAfter(final String llllllllllllllIIIlIIlIllIIlIIllI, final boolean llllllllllllllIIIlIIlIllIIlIIlIl, final boolean llllllllllllllIIIlIIlIllIIIllIIl) throws CannotCompileException {
        final CtClass llllllllllllllIIIlIIlIllIIlIIIll = this.declaringClass;
        llllllllllllllIIIlIIlIllIIlIIIll.checkModify();
        final ConstPool llllllllllllllIIIlIIlIllIIlIIIlI = this.methodInfo.getConstPool();
        final CodeAttribute llllllllllllllIIIlIIlIllIIlIIIIl = this.methodInfo.getCodeAttribute();
        if (llllllllllllllIIIlIIlIllIIlIIIIl == null) {
            throw new CannotCompileException("no method body");
        }
        final CodeIterator llllllllllllllIIIlIIlIllIIlIIIII = llllllllllllllIIIlIIlIllIIlIIIIl.iterator();
        final int llllllllllllllIIIlIIlIllIIIlllll = llllllllllllllIIIlIIlIllIIlIIIIl.getMaxLocals();
        final Bytecode llllllllllllllIIIlIIlIllIIIllllI = new Bytecode(llllllllllllllIIIlIIlIllIIlIIIlI, 0, llllllllllllllIIIlIIlIllIIIlllll + 1);
        llllllllllllllIIIlIIlIllIIIllllI.setStackDepth(llllllllllllllIIIlIIlIllIIlIIIIl.getMaxStack() + 1);
        final Javac llllllllllllllIIIlIIlIllIIIlllIl = new Javac(llllllllllllllIIIlIIlIllIIIllllI, llllllllllllllIIIlIIlIllIIlIIIll);
        try {
            final int llllllllllllllIIIlIIlIllIIllIIlI = llllllllllllllIIIlIIlIllIIIlllIl.recordParams(this.getParameterTypes(), Modifier.isStatic(this.getModifiers()));
            llllllllllllllIIIlIIlIllIIIlllIl.recordParamNames(llllllllllllllIIIlIIlIllIIlIIIIl, llllllllllllllIIIlIIlIllIIllIIlI);
            final CtClass llllllllllllllIIIlIIlIllIIllIIIl = this.getReturnType0();
            final int llllllllllllllIIIlIIlIllIIllIIII = llllllllllllllIIIlIIlIllIIIlllIl.recordReturnType(llllllllllllllIIIlIIlIllIIllIIIl, true);
            llllllllllllllIIIlIIlIllIIIlllIl.recordLocalVariables(llllllllllllllIIIlIIlIllIIlIIIIl, 0);
            int llllllllllllllIIIlIIlIllIIlIllll = this.insertAfterHandler(llllllllllllllIIIlIIlIllIIlIIlIl, llllllllllllllIIIlIIlIllIIIllllI, llllllllllllllIIIlIIlIllIIllIIIl, llllllllllllllIIIlIIlIllIIllIIII, llllllllllllllIIIlIIlIllIIIlllIl, llllllllllllllIIIlIIlIllIIlIIllI);
            int llllllllllllllIIIlIIlIllIIlIlllI = llllllllllllllIIIlIIlIllIIlIIIII.getCodeLength();
            if (llllllllllllllIIIlIIlIllIIlIIlIl) {
                llllllllllllllIIIlIIlIllIIlIIIIl.getExceptionTable().add(this.getStartPosOfBody(llllllllllllllIIIlIIlIllIIlIIIIl), llllllllllllllIIIlIIlIllIIlIlllI, llllllllllllllIIIlIIlIllIIlIlllI, 0);
            }
            int llllllllllllllIIIlIIlIllIIlIllIl = 0;
            int llllllllllllllIIIlIIlIllIIlIllII = 0;
            boolean llllllllllllllIIIlIIlIllIIlIlIll = true;
            while (llllllllllllllIIIlIIlIllIIlIIIII.hasNext()) {
                final int llllllllllllllIIIlIIlIllIIllIlII = llllllllllllllIIIlIIlIllIIlIIIII.next();
                if (llllllllllllllIIIlIIlIllIIllIlII >= llllllllllllllIIIlIIlIllIIlIlllI) {
                    break;
                }
                final int llllllllllllllIIIlIIlIllIIllIIll = llllllllllllllIIIlIIlIllIIlIIIII.byteAt(llllllllllllllIIIlIIlIllIIllIlII);
                if (llllllllllllllIIIlIIlIllIIllIIll != 176 && llllllllllllllIIIlIIlIllIIllIIll != 172 && llllllllllllllIIIlIIlIllIIllIIll != 174 && llllllllllllllIIIlIIlIllIIllIIll != 173 && llllllllllllllIIIlIIlIllIIllIIll != 175 && llllllllllllllIIIlIIlIllIIllIIll != 177) {
                    continue;
                }
                if (llllllllllllllIIIlIIlIllIIIllIIl) {
                    llllllllllllllIIIlIIlIllIIlIIIII.setMark2(llllllllllllllIIIlIIlIllIIlIlllI);
                    Bytecode llllllllllllllIIIlIIlIllIIlllIlI = null;
                    Javac llllllllllllllIIIlIIlIllIIlllIIl = null;
                    int llllllllllllllIIIlIIlIllIIlllIII = 0;
                    if (llllllllllllllIIIlIIlIllIIlIlIll) {
                        llllllllllllllIIIlIIlIllIIlIlIll = false;
                        final Bytecode llllllllllllllIIIlIIlIllIIlllllI = llllllllllllllIIIlIIlIllIIIllllI;
                        final Javac llllllllllllllIIIlIIlIllIIllllIl = llllllllllllllIIIlIIlIllIIIlllIl;
                        final int llllllllllllllIIIlIIlIllIIllllII = llllllllllllllIIIlIIlIllIIllIIII;
                    }
                    else {
                        llllllllllllllIIIlIIlIllIIlllIlI = new Bytecode(llllllllllllllIIIlIIlIllIIlIIIlI, 0, llllllllllllllIIIlIIlIllIIIlllll + 1);
                        llllllllllllllIIIlIIlIllIIlllIlI.setStackDepth(llllllllllllllIIIlIIlIllIIlIIIIl.getMaxStack() + 1);
                        llllllllllllllIIIlIIlIllIIlllIIl = new Javac(llllllllllllllIIIlIIlIllIIlllIlI, llllllllllllllIIIlIIlIllIIlIIIll);
                        final int llllllllllllllIIIlIIlIllIIlllIll = llllllllllllllIIIlIIlIllIIlllIIl.recordParams(this.getParameterTypes(), Modifier.isStatic(this.getModifiers()));
                        llllllllllllllIIIlIIlIllIIlllIIl.recordParamNames(llllllllllllllIIIlIIlIllIIlIIIIl, llllllllllllllIIIlIIlIllIIlllIll);
                        llllllllllllllIIIlIIlIllIIlllIII = llllllllllllllIIIlIIlIllIIlllIIl.recordReturnType(llllllllllllllIIIlIIlIllIIllIIIl, true);
                        llllllllllllllIIIlIIlIllIIlllIIl.recordLocalVariables(llllllllllllllIIIlIIlIllIIlIIIIl, 0);
                    }
                    final int llllllllllllllIIIlIIlIllIIllIlll = this.insertAfterAdvice(llllllllllllllIIIlIIlIllIIlllIlI, llllllllllllllIIIlIIlIllIIlllIIl, llllllllllllllIIIlIIlIllIIlIIllI, llllllllllllllIIIlIIlIllIIlIIIlI, llllllllllllllIIIlIIlIllIIllIIIl, llllllllllllllIIIlIIlIllIIlllIII);
                    final int llllllllllllllIIIlIIlIllIIllIllI = llllllllllllllIIIlIIlIllIIlIIIII.append(llllllllllllllIIIlIIlIllIIlllIlI.get());
                    llllllllllllllIIIlIIlIllIIlIIIII.append(llllllllllllllIIIlIIlIllIIlllIlI.getExceptionTable(), llllllllllllllIIIlIIlIllIIllIllI);
                    final int llllllllllllllIIIlIIlIllIIllIlIl = llllllllllllllIIIlIIlIllIIlIIIII.getCodeLength() - llllllllllllllIIIlIIlIllIIllIlll;
                    this.insertGoto(llllllllllllllIIIlIIlIllIIlIIIII, llllllllllllllIIIlIIlIllIIllIlIl, llllllllllllllIIIlIIlIllIIllIlII);
                    llllllllllllllIIIlIIlIllIIlIlllI = llllllllllllllIIIlIIlIllIIlIIIII.getMark2();
                }
                else {
                    if (llllllllllllllIIIlIIlIllIIlIlIll) {
                        llllllllllllllIIIlIIlIllIIlIllIl = this.insertAfterAdvice(llllllllllllllIIIlIIlIllIIIllllI, llllllllllllllIIIlIIlIllIIIlllIl, llllllllllllllIIIlIIlIllIIlIIllI, llllllllllllllIIIlIIlIllIIlIIIlI, llllllllllllllIIIlIIlIllIIllIIIl, llllllllllllllIIIlIIlIllIIllIIII);
                        llllllllllllllIIIlIIlIllIIlIlllI = llllllllllllllIIIlIIlIllIIlIIIII.append(llllllllllllllIIIlIIlIllIIIllllI.get());
                        llllllllllllllIIIlIIlIllIIlIIIII.append(llllllllllllllIIIlIIlIllIIIllllI.getExceptionTable(), llllllllllllllIIIlIIlIllIIlIlllI);
                        llllllllllllllIIIlIIlIllIIlIllII = llllllllllllllIIIlIIlIllIIlIIIII.getCodeLength() - llllllllllllllIIIlIIlIllIIlIllIl;
                        llllllllllllllIIIlIIlIllIIlIllll = llllllllllllllIIIlIIlIllIIlIllII - llllllllllllllIIIlIIlIllIIlIlllI;
                        llllllllllllllIIIlIIlIllIIlIlIll = false;
                    }
                    this.insertGoto(llllllllllllllIIIlIIlIllIIlIIIII, llllllllllllllIIIlIIlIllIIlIllII, llllllllllllllIIIlIIlIllIIllIlII);
                    llllllllllllllIIIlIIlIllIIlIllII = llllllllllllllIIIlIIlIllIIlIIIII.getCodeLength() - llllllllllllllIIIlIIlIllIIlIllIl;
                    llllllllllllllIIIlIIlIllIIlIlllI = llllllllllllllIIIlIIlIllIIlIllII - llllllllllllllIIIlIIlIllIIlIllll;
                }
            }
            if (llllllllllllllIIIlIIlIllIIlIlIll) {
                llllllllllllllIIIlIIlIllIIlIlllI = llllllllllllllIIIlIIlIllIIlIIIII.append(llllllllllllllIIIlIIlIllIIIllllI.get());
                llllllllllllllIIIlIIlIllIIlIIIII.append(llllllllllllllIIIlIIlIllIIIllllI.getExceptionTable(), llllllllllllllIIIlIIlIllIIlIlllI);
            }
            llllllllllllllIIIlIIlIllIIlIIIIl.setMaxStack(llllllllllllllIIIlIIlIllIIIllllI.getMaxStack());
            llllllllllllllIIIlIIlIllIIlIIIIl.setMaxLocals(llllllllllllllIIIlIIlIllIIIllllI.getMaxLocals());
            this.methodInfo.rebuildStackMapIf6(llllllllllllllIIIlIIlIllIIlIIIll.getClassPool(), llllllllllllllIIIlIIlIllIIlIIIll.getClassFile2());
        }
        catch (NotFoundException llllllllllllllIIIlIIlIllIIlIlIlI) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIllIIlIlIlI);
        }
        catch (CompileError llllllllllllllIIIlIIlIllIIlIlIIl) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIllIIlIlIIl);
        }
        catch (BadBytecode llllllllllllllIIIlIIlIllIIlIlIII) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIllIIlIlIII);
        }
    }
    
    private int insertAfterAdvice(final Bytecode llllllllllllllIIIlIIlIlIlllllIlI, final Javac llllllllllllllIIIlIIlIlIllllIIlI, final String llllllllllllllIIIlIIlIlIlllllIII, final ConstPool llllllllllllllIIIlIIlIlIllllIlll, final CtClass llllllllllllllIIIlIIlIlIllllIIII, final int llllllllllllllIIIlIIlIlIllllIlIl) throws CompileError {
        final int llllllllllllllIIIlIIlIlIllllIlII = llllllllllllllIIIlIIlIlIlllllIlI.currentPc();
        if (llllllllllllllIIIlIIlIlIllllIIII == CtClass.voidType) {
            llllllllllllllIIIlIIlIlIlllllIlI.addOpcode(1);
            llllllllllllllIIIlIIlIlIlllllIlI.addAstore(llllllllllllllIIIlIIlIlIllllIlIl);
            llllllllllllllIIIlIIlIlIllllIIlI.compileStmnt(llllllllllllllIIIlIIlIlIlllllIII);
            llllllllllllllIIIlIIlIlIlllllIlI.addOpcode(177);
            if (llllllllllllllIIIlIIlIlIlllllIlI.getMaxLocals() < 1) {
                llllllllllllllIIIlIIlIlIlllllIlI.setMaxLocals(1);
            }
        }
        else {
            llllllllllllllIIIlIIlIlIlllllIlI.addStore(llllllllllllllIIIlIIlIlIllllIlIl, llllllllllllllIIIlIIlIlIllllIIII);
            llllllllllllllIIIlIIlIlIllllIIlI.compileStmnt(llllllllllllllIIIlIIlIlIlllllIII);
            llllllllllllllIIIlIIlIlIlllllIlI.addLoad(llllllllllllllIIIlIIlIlIllllIlIl, llllllllllllllIIIlIIlIlIllllIIII);
            if (llllllllllllllIIIlIIlIlIllllIIII.isPrimitive()) {
                llllllllllllllIIIlIIlIlIlllllIlI.addOpcode(((CtPrimitiveType)llllllllllllllIIIlIIlIlIllllIIII).getReturnOp());
            }
            else {
                llllllllllllllIIIlIIlIlIlllllIlI.addOpcode(176);
            }
        }
        return llllllllllllllIIIlIIlIlIlllllIlI.currentPc() - llllllllllllllIIIlIIlIlIllllIlII;
    }
    
    public void addParameter(final CtClass llllllllllllllIIIlIIlIllllIlIIIl) throws CannotCompileException {
        this.declaringClass.checkModify();
        final String llllllllllllllIIIlIIlIllllIlIIII = this.methodInfo.getDescriptor();
        final String llllllllllllllIIIlIIlIllllIIllll = Descriptor.appendParameter(llllllllllllllIIIlIIlIllllIlIIIl, llllllllllllllIIIlIIlIllllIlIIII);
        final int llllllllllllllIIIlIIlIllllIIlllI = Modifier.isStatic(this.getModifiers()) ? 0 : 1;
        try {
            this.addParameter2(llllllllllllllIIIlIIlIllllIIlllI + Descriptor.paramSize(llllllllllllllIIIlIIlIllllIlIIII), llllllllllllllIIIlIIlIllllIlIIIl, llllllllllllllIIIlIIlIllllIlIIII);
        }
        catch (BadBytecode llllllllllllllIIIlIIlIllllIlIIll) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIllllIlIIll);
        }
        this.methodInfo.setDescriptor(llllllllllllllIIIlIIlIllllIIllll);
    }
    
    public void instrument(final CodeConverter llllllllllllllIIIlIIlIlllIIlllIl) throws CannotCompileException {
        this.declaringClass.checkModify();
        final ConstPool llllllllllllllIIIlIIlIlllIIlllll = this.methodInfo.getConstPool();
        llllllllllllllIIIlIIlIlllIIlllIl.doit(this.getDeclaringClass(), this.methodInfo, llllllllllllllIIIlIIlIlllIIlllll);
    }
    
    @Override
    protected void extendToString(final StringBuffer llllllllllllllIIIlIIllIIllllIIIl) {
        llllllllllllllIIIlIIllIIllllIIIl.append(' ');
        llllllllllllllIIIlIIllIIllllIIIl.append(this.getName());
        llllllllllllllIIIlIIllIIllllIIIl.append(' ');
        llllllllllllllIIIlIIllIIllllIIIl.append(this.methodInfo.getDescriptor());
    }
    
    @Override
    public Object[] getAnnotations() throws ClassNotFoundException {
        return this.getAnnotations(false);
    }
    
    @Override
    public Object[] getAvailableAnnotations() {
        try {
            return this.getAnnotations(true);
        }
        catch (ClassNotFoundException llllllllllllllIIIlIIllIIlIllllII) {
            throw new RuntimeException("Unexpected exception", llllllllllllllIIIlIIllIIlIllllII);
        }
    }
    
    private int insertAfterHandler(final boolean llllllllllllllIIIlIIlIlIllIIIIIl, final Bytecode llllllllllllllIIIlIIlIlIllIIlIII, final CtClass llllllllllllllIIIlIIlIlIlIllllll, final int llllllllllllllIIIlIIlIlIlIlllllI, final Javac llllllllllllllIIIlIIlIlIllIIIlIl, final String llllllllllllllIIIlIIlIlIlIllllII) throws CompileError {
        if (!llllllllllllllIIIlIIlIlIllIIIIIl) {
            return 0;
        }
        final int llllllllllllllIIIlIIlIlIllIIIIll = llllllllllllllIIIlIIlIlIllIIlIII.getMaxLocals();
        llllllllllllllIIIlIIlIlIllIIlIII.incMaxLocals(1);
        final int llllllllllllllIIIlIIlIlIllIIIIlI = llllllllllllllIIIlIIlIlIllIIlIII.currentPc();
        llllllllllllllIIIlIIlIlIllIIlIII.addAstore(llllllllllllllIIIlIIlIlIllIIIIll);
        if (llllllllllllllIIIlIIlIlIlIllllll.isPrimitive()) {
            final char llllllllllllllIIIlIIlIlIllIIlIll = ((CtPrimitiveType)llllllllllllllIIIlIIlIlIlIllllll).getDescriptor();
            if (llllllllllllllIIIlIIlIlIllIIlIll == 'D') {
                llllllllllllllIIIlIIlIlIllIIlIII.addDconst(0.0);
                llllllllllllllIIIlIIlIlIllIIlIII.addDstore(llllllllllllllIIIlIIlIlIlIlllllI);
            }
            else if (llllllllllllllIIIlIIlIlIllIIlIll == 'F') {
                llllllllllllllIIIlIIlIlIllIIlIII.addFconst(0.0f);
                llllllllllllllIIIlIIlIlIllIIlIII.addFstore(llllllllllllllIIIlIIlIlIlIlllllI);
            }
            else if (llllllllllllllIIIlIIlIlIllIIlIll == 'J') {
                llllllllllllllIIIlIIlIlIllIIlIII.addLconst(0L);
                llllllllllllllIIIlIIlIlIllIIlIII.addLstore(llllllllllllllIIIlIIlIlIlIlllllI);
            }
            else if (llllllllllllllIIIlIIlIlIllIIlIll == 'V') {
                llllllllllllllIIIlIIlIlIllIIlIII.addOpcode(1);
                llllllllllllllIIIlIIlIlIllIIlIII.addAstore(llllllllllllllIIIlIIlIlIlIlllllI);
            }
            else {
                llllllllllllllIIIlIIlIlIllIIlIII.addIconst(0);
                llllllllllllllIIIlIIlIlIllIIlIII.addIstore(llllllllllllllIIIlIIlIlIlIlllllI);
            }
        }
        else {
            llllllllllllllIIIlIIlIlIllIIlIII.addOpcode(1);
            llllllllllllllIIIlIIlIlIllIIlIII.addAstore(llllllllllllllIIIlIIlIlIlIlllllI);
        }
        llllllllllllllIIIlIIlIlIllIIIlIl.compileStmnt(llllllllllllllIIIlIIlIlIlIllllII);
        llllllllllllllIIIlIIlIlIllIIlIII.addAload(llllllllllllllIIIlIIlIlIllIIIIll);
        llllllllllllllIIIlIIlIlIllIIlIII.addOpcode(191);
        return llllllllllllllIIIlIIlIlIllIIlIII.currentPc() - llllllllllllllIIIlIIlIlIllIIIIlI;
    }
    
    @Override
    public String getGenericSignature() {
        final SignatureAttribute llllllllllllllIIIlIIllIIlIIIIlIl = (SignatureAttribute)this.methodInfo.getAttribute("Signature");
        return (llllllllllllllIIIlIIllIIlIIIIlIl == null) ? null : llllllllllllllIIIlIIllIIlIIIIlIl.getSignature();
    }
    
    CtClass getReturnType0() throws NotFoundException {
        return Descriptor.getReturnType(this.methodInfo.getDescriptor(), this.declaringClass.getClassPool());
    }
    
    int getStartPosOfBody(final CodeAttribute llllllllllllllIIIlIIlIlIIllllllI) throws CannotCompileException {
        return 0;
    }
    
    public void setExceptionTypes(final CtClass[] llllllllllllllIIIlIIllIIIllIlIII) throws NotFoundException {
        this.declaringClass.checkModify();
        if (llllllllllllllIIIlIIllIIIllIlIII == null || llllllllllllllIIIlIIllIIIllIlIII.length == 0) {
            this.methodInfo.removeExceptionsAttribute();
            return;
        }
        final String[] llllllllllllllIIIlIIllIIIllIlIll = new String[llllllllllllllIIIlIIllIIIllIlIII.length];
        for (int llllllllllllllIIIlIIllIIIllIlllI = 0; llllllllllllllIIIlIIllIIIllIlllI < llllllllllllllIIIlIIllIIIllIlIII.length; ++llllllllllllllIIIlIIllIIIllIlllI) {
            llllllllllllllIIIlIIllIIIllIlIll[llllllllllllllIIIlIIllIIIllIlllI] = llllllllllllllIIIlIIllIIIllIlIII[llllllllllllllIIIlIIllIIIllIlllI].getName();
        }
        ExceptionsAttribute llllllllllllllIIIlIIllIIIllIlIlI = this.methodInfo.getExceptionsAttribute();
        if (llllllllllllllIIIlIIllIIIllIlIlI == null) {
            llllllllllllllIIIlIIllIIIllIlIlI = new ExceptionsAttribute(this.methodInfo.getConstPool());
            this.methodInfo.setExceptionsAttribute(llllllllllllllIIIlIIllIIIllIlIlI);
        }
        llllllllllllllIIIlIIllIIIllIlIlI.setExceptions(llllllllllllllIIIlIIllIIIllIlIll);
    }
    
    @Override
    public void setGenericSignature(final String llllllllllllllIIIlIIllIIIlllllIl) {
        this.declaringClass.checkModify();
        this.methodInfo.addAttribute(new SignatureAttribute(this.methodInfo.getConstPool(), llllllllllllllIIIlIIllIIIlllllIl));
    }
    
    public void setBody(final String llllllllllllllIIIlIIllIIIllIIIII) throws CannotCompileException {
        this.setBody(llllllllllllllIIIlIIllIIIllIIIII, null, null);
    }
    
    @Override
    public String getSignature() {
        return this.methodInfo.getDescriptor();
    }
    
    @Override
    public Object getAnnotation(final Class<?> llllllllllllllIIIlIIllIIllIIlIlI) throws ClassNotFoundException {
        final MethodInfo llllllllllllllIIIlIIllIIllIIlIIl = this.getMethodInfo2();
        final AnnotationsAttribute llllllllllllllIIIlIIllIIllIIlIII = (AnnotationsAttribute)llllllllllllllIIIlIIllIIllIIlIIl.getAttribute("RuntimeInvisibleAnnotations");
        final AnnotationsAttribute llllllllllllllIIIlIIllIIllIIIlll = (AnnotationsAttribute)llllllllllllllIIIlIIllIIllIIlIIl.getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.getAnnotationType(llllllllllllllIIIlIIllIIllIIlIlI, this.getDeclaringClass().getClassPool(), llllllllllllllIIIlIIllIIllIIlIII, llllllllllllllIIIlIIllIIllIIIlll);
    }
    
    private void insertGoto(final CodeIterator llllllllllllllIIIlIIlIlIlllIIIll, final int llllllllllllllIIIlIIlIlIllIllIll, int llllllllllllllIIIlIIlIlIllIllIlI) throws BadBytecode {
        llllllllllllllIIIlIIlIlIlllIIIll.setMark(llllllllllllllIIIlIIlIlIllIllIll);
        llllllllllllllIIIlIIlIlIlllIIIll.writeByte(0, llllllllllllllIIIlIIlIlIllIllIlI);
        final boolean llllllllllllllIIIlIIlIlIlllIIIII = llllllllllllllIIIlIIlIlIllIllIll + 2 - llllllllllllllIIIlIIlIlIllIllIlI > 32767;
        final int llllllllllllllIIIlIIlIlIllIlllll = llllllllllllllIIIlIIlIlIlllIIIII ? 4 : 2;
        final CodeIterator.Gap llllllllllllllIIIlIIlIlIllIllllI = llllllllllllllIIIlIIlIlIlllIIIll.insertGapAt(llllllllllllllIIIlIIlIlIllIllIlI, llllllllllllllIIIlIIlIlIllIlllll, false);
        llllllllllllllIIIlIIlIlIllIllIlI = llllllllllllllIIIlIIlIlIllIllllI.position + llllllllllllllIIIlIIlIlIllIllllI.length - llllllllllllllIIIlIIlIlIllIlllll;
        final int llllllllllllllIIIlIIlIlIllIlllIl = llllllllllllllIIIlIIlIlIlllIIIll.getMark() - llllllllllllllIIIlIIlIlIllIllIlI;
        if (llllllllllllllIIIlIIlIlIlllIIIII) {
            llllllllllllllIIIlIIlIlIlllIIIll.writeByte(200, llllllllllllllIIIlIIlIlIllIllIlI);
            llllllllllllllIIIlIIlIlIlllIIIll.write32bit(llllllllllllllIIIlIIlIlIllIlllIl, llllllllllllllIIIlIIlIlIllIllIlI + 1);
        }
        else if (llllllllllllllIIIlIIlIlIllIlllIl <= 32767) {
            llllllllllllllIIIlIIlIlIlllIIIll.writeByte(167, llllllllllllllIIIlIIlIlIllIllIlI);
            llllllllllllllIIIlIIlIlIlllIIIll.write16bit(llllllllllllllIIIlIIlIlIllIlllIl, llllllllllllllIIIlIIlIlIllIllIlI + 1);
        }
        else {
            if (llllllllllllllIIIlIIlIlIllIllllI.length < 4) {
                final CodeIterator.Gap llllllllllllllIIIlIIlIlIlllIIlIl = llllllllllllllIIIlIIlIlIlllIIIll.insertGapAt(llllllllllllllIIIlIIlIlIllIllllI.position, 2, false);
                llllllllllllllIIIlIIlIlIllIllIlI = llllllllllllllIIIlIIlIlIlllIIlIl.position + llllllllllllllIIIlIIlIlIlllIIlIl.length + llllllllllllllIIIlIIlIlIllIllllI.length - 4;
            }
            llllllllllllllIIIlIIlIlIlllIIIll.writeByte(200, llllllllllllllIIIlIIlIlIllIllIlI);
            llllllllllllllIIIlIIlIlIlllIIIll.write32bit(llllllllllllllIIIlIIlIlIlllIIIll.getMark() - llllllllllllllIIIlIIlIlIllIllIlI, llllllllllllllIIIlIIlIlIllIllIlI + 1);
        }
    }
    
    protected CtBehavior(final CtClass llllllllllllllIIIlIIllIlIIlIIIlI, final MethodInfo llllllllllllllIIIlIIllIlIIlIIIIl) {
        super(llllllllllllllIIIlIIllIlIIlIIIlI);
        this.methodInfo = llllllllllllllIIIlIIllIlIIlIIIIl;
    }
    
    public CtClass[] getParameterTypes() throws NotFoundException {
        return Descriptor.getParameterTypes(this.methodInfo.getDescriptor(), this.declaringClass.getClassPool());
    }
    
    @Override
    public boolean hasAnnotation(final String llllllllllllllIIIlIIllIIllIlIlII) {
        final MethodInfo llllllllllllllIIIlIIllIIllIllIII = this.getMethodInfo2();
        final AnnotationsAttribute llllllllllllllIIIlIIllIIllIlIlll = (AnnotationsAttribute)llllllllllllllIIIlIIllIIllIllIII.getAttribute("RuntimeInvisibleAnnotations");
        final AnnotationsAttribute llllllllllllllIIIlIIllIIllIlIllI = (AnnotationsAttribute)llllllllllllllIIIlIIllIIllIllIII.getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.hasAnnotationType(llllllllllllllIIIlIIllIIllIlIlII, this.getDeclaringClass().getClassPool(), llllllllllllllIIIlIIllIIllIlIlll, llllllllllllllIIIlIIllIIllIlIllI);
    }
    
    public MethodInfo getMethodInfo() {
        this.declaringClass.checkModify();
        return this.methodInfo;
    }
    
    void copy(final CtBehavior llllllllllllllIIIlIIllIlIIIIlIII, final boolean llllllllllllllIIIlIIllIIllllllll, ClassMap llllllllllllllIIIlIIllIIlllllllI) throws CannotCompileException {
        final CtClass llllllllllllllIIIlIIllIlIIIIIlIl = this.declaringClass;
        final MethodInfo llllllllllllllIIIlIIllIlIIIIIlII = llllllllllllllIIIlIIllIlIIIIlIII.methodInfo;
        final CtClass llllllllllllllIIIlIIllIlIIIIIIll = llllllllllllllIIIlIIllIlIIIIlIII.getDeclaringClass();
        final ConstPool llllllllllllllIIIlIIllIlIIIIIIlI = llllllllllllllIIIlIIllIlIIIIIlIl.getClassFile2().getConstPool();
        llllllllllllllIIIlIIllIIlllllllI = new ClassMap(llllllllllllllIIIlIIllIIlllllllI);
        llllllllllllllIIIlIIllIIlllllllI.put(llllllllllllllIIIlIIllIlIIIIIIll.getName(), llllllllllllllIIIlIIllIlIIIIIlIl.getName());
        try {
            boolean llllllllllllllIIIlIIllIlIIIIllll = false;
            final CtClass llllllllllllllIIIlIIllIlIIIIlllI = llllllllllllllIIIlIIllIlIIIIIIll.getSuperclass();
            final CtClass llllllllllllllIIIlIIllIlIIIIllIl = llllllllllllllIIIlIIllIlIIIIIlIl.getSuperclass();
            String llllllllllllllIIIlIIllIlIIIIllII = null;
            if (llllllllllllllIIIlIIllIlIIIIlllI != null && llllllllllllllIIIlIIllIlIIIIllIl != null) {
                final String llllllllllllllIIIlIIllIlIIIlIIII = llllllllllllllIIIlIIllIlIIIIlllI.getName();
                llllllllllllllIIIlIIllIlIIIIllII = llllllllllllllIIIlIIllIlIIIIllIl.getName();
                if (!llllllllllllllIIIlIIllIlIIIlIIII.equals(llllllllllllllIIIlIIllIlIIIIllII)) {
                    if (llllllllllllllIIIlIIllIlIIIlIIII.equals("java.lang.Object")) {
                        llllllllllllllIIIlIIllIlIIIIllll = true;
                    }
                    else {
                        llllllllllllllIIIlIIllIIlllllllI.putIfNone(llllllllllllllIIIlIIllIlIIIlIIII, llllllllllllllIIIlIIllIlIIIIllII);
                    }
                }
            }
            this.methodInfo = new MethodInfo(llllllllllllllIIIlIIllIlIIIIIIlI, llllllllllllllIIIlIIllIlIIIIIlII.getName(), llllllllllllllIIIlIIllIlIIIIIlII, llllllllllllllIIIlIIllIIlllllllI);
            if (llllllllllllllIIIlIIllIIllllllll && llllllllllllllIIIlIIllIlIIIIllll) {
                this.methodInfo.setSuperclass(llllllllllllllIIIlIIllIlIIIIllII);
            }
        }
        catch (NotFoundException llllllllllllllIIIlIIllIlIIIIlIll) {
            throw new CannotCompileException(llllllllllllllIIIlIIllIlIIIIlIll);
        }
        catch (BadBytecode llllllllllllllIIIlIIllIlIIIIlIlI) {
            throw new CannotCompileException(llllllllllllllIIIlIIllIlIIIIlIlI);
        }
    }
    
    public void addCatch(final String llllllllllllllIIIlIIlIlIlIIIllIl, final CtClass llllllllllllllIIIlIIlIlIlIIlIllI, final String llllllllllllllIIIlIIlIlIlIIIlIll) throws CannotCompileException {
        final CtClass llllllllllllllIIIlIIlIlIlIIlIlII = this.declaringClass;
        llllllllllllllIIIlIIlIlIlIIlIlII.checkModify();
        final ConstPool llllllllllllllIIIlIIlIlIlIIlIIll = this.methodInfo.getConstPool();
        final CodeAttribute llllllllllllllIIIlIIlIlIlIIlIIlI = this.methodInfo.getCodeAttribute();
        final CodeIterator llllllllllllllIIIlIIlIlIlIIlIIIl = llllllllllllllIIIlIIlIlIlIIlIIlI.iterator();
        final Bytecode llllllllllllllIIIlIIlIlIlIIlIIII = new Bytecode(llllllllllllllIIIlIIlIlIlIIlIIll, llllllllllllllIIIlIIlIlIlIIlIIlI.getMaxStack(), llllllllllllllIIIlIIlIlIlIIlIIlI.getMaxLocals());
        llllllllllllllIIIlIIlIlIlIIlIIII.setStackDepth(1);
        final Javac llllllllllllllIIIlIIlIlIlIIIllll = new Javac(llllllllllllllIIIlIIlIlIlIIlIIII, llllllllllllllIIIlIIlIlIlIIlIlII);
        try {
            llllllllllllllIIIlIIlIlIlIIIllll.recordParams(this.getParameterTypes(), Modifier.isStatic(this.getModifiers()));
            final int llllllllllllllIIIlIIlIlIlIlIIIII = llllllllllllllIIIlIIlIlIlIIIllll.recordVariable(llllllllllllllIIIlIIlIlIlIIlIllI, llllllllllllllIIIlIIlIlIlIIIlIll);
            llllllllllllllIIIlIIlIlIlIIlIIII.addAstore(llllllllllllllIIIlIIlIlIlIlIIIII);
            llllllllllllllIIIlIIlIlIlIIIllll.compileStmnt(llllllllllllllIIIlIIlIlIlIIIllIl);
            final int llllllllllllllIIIlIIlIlIlIIlllll = llllllllllllllIIIlIIlIlIlIIlIIII.getMaxStack();
            final int llllllllllllllIIIlIIlIlIlIIllllI = llllllllllllllIIIlIIlIlIlIIlIIII.getMaxLocals();
            if (llllllllllllllIIIlIIlIlIlIIlllll > llllllllllllllIIIlIIlIlIlIIlIIlI.getMaxStack()) {
                llllllllllllllIIIlIIlIlIlIIlIIlI.setMaxStack(llllllllllllllIIIlIIlIlIlIIlllll);
            }
            if (llllllllllllllIIIlIIlIlIlIIllllI > llllllllllllllIIIlIIlIlIlIIlIIlI.getMaxLocals()) {
                llllllllllllllIIIlIIlIlIlIIlIIlI.setMaxLocals(llllllllllllllIIIlIIlIlIlIIllllI);
            }
            final int llllllllllllllIIIlIIlIlIlIIlllIl = llllllllllllllIIIlIIlIlIlIIlIIIl.getCodeLength();
            final int llllllllllllllIIIlIIlIlIlIIlllII = llllllllllllllIIIlIIlIlIlIIlIIIl.append(llllllllllllllIIIlIIlIlIlIIlIIII.get());
            llllllllllllllIIIlIIlIlIlIIlIIlI.getExceptionTable().add(this.getStartPosOfBody(llllllllllllllIIIlIIlIlIlIIlIIlI), llllllllllllllIIIlIIlIlIlIIlllIl, llllllllllllllIIIlIIlIlIlIIlllIl, llllllllllllllIIIlIIlIlIlIIlIIll.addClassInfo(llllllllllllllIIIlIIlIlIlIIlIllI));
            llllllllllllllIIIlIIlIlIlIIlIIIl.append(llllllllllllllIIIlIIlIlIlIIlIIII.getExceptionTable(), llllllllllllllIIIlIIlIlIlIIlllII);
            this.methodInfo.rebuildStackMapIf6(llllllllllllllIIIlIIlIlIlIIlIlII.getClassPool(), llllllllllllllIIIlIIlIlIlIIlIlII.getClassFile2());
        }
        catch (NotFoundException llllllllllllllIIIlIIlIlIlIIllIll) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIlIlIIllIll);
        }
        catch (CompileError llllllllllllllIIIlIIlIlIlIIllIlI) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIlIlIIllIlI);
        }
        catch (BadBytecode llllllllllllllIIIlIIlIlIlIIllIIl) {
            throw new CannotCompileException(llllllllllllllIIIlIIlIlIlIIllIIl);
        }
    }
    
    public void instrument(final ExprEditor llllllllllllllIIIlIIlIlllIIlIllI) throws CannotCompileException {
        if (this.declaringClass.isFrozen()) {
            this.declaringClass.checkModify();
        }
        if (llllllllllllllIIIlIIlIlllIIlIllI.doit(this.declaringClass, this.methodInfo)) {
            this.declaringClass.checkModify();
        }
    }
    
    public void addCatch(final String llllllllllllllIIIlIIlIlIlIllIlII, final CtClass llllllllllllllIIIlIIlIlIlIllIIll) throws CannotCompileException {
        this.addCatch(llllllllllllllIIIlIIlIlIlIllIlII, llllllllllllllIIIlIIlIlIlIllIIll, "$e");
    }
    
    public void useCflow(final String llllllllllllllIIIlIIllIIIIIIlIII) throws CannotCompileException {
        final CtClass llllllllllllllIIIlIIllIIIIIIllIl = this.declaringClass;
        llllllllllllllIIIlIIllIIIIIIllIl.checkModify();
        final ClassPool llllllllllllllIIIlIIllIIIIIIllII = llllllllllllllIIIlIIllIIIIIIllIl.getClassPool();
        int llllllllllllllIIIlIIllIIIIIIlIlI = 0;
        while (true) {
            final String llllllllllllllIIIlIIllIIIIIIlIll = String.valueOf(new StringBuilder().append("_cflow$").append(llllllllllllllIIIlIIllIIIIIIlIlI++));
            try {
                llllllllllllllIIIlIIllIIIIIIllIl.getDeclaredField(llllllllllllllIIIlIIllIIIIIIlIll);
            }
            catch (NotFoundException llllllllllllllIIIlIIllIIIIIlIlII) {
                llllllllllllllIIIlIIllIIIIIIllII.recordCflow(llllllllllllllIIIlIIllIIIIIIlIII, this.declaringClass.getName(), llllllllllllllIIIlIIllIIIIIIlIll);
                try {
                    final CtClass llllllllllllllIIIlIIllIIIIIlIIll = llllllllllllllIIIlIIllIIIIIIllII.get("com.viaversion.viaversion.libs.javassist.runtime.Cflow");
                    final CtField llllllllllllllIIIlIIllIIIIIlIIlI = new CtField(llllllllllllllIIIlIIllIIIIIlIIll, llllllllllllllIIIlIIllIIIIIIlIll, llllllllllllllIIIlIIllIIIIIIllIl);
                    llllllllllllllIIIlIIllIIIIIlIIlI.setModifiers(9);
                    llllllllllllllIIIlIIllIIIIIIllIl.addField(llllllllllllllIIIlIIllIIIIIlIIlI, CtField.Initializer.byNew(llllllllllllllIIIlIIllIIIIIlIIll));
                    this.insertBefore(String.valueOf(new StringBuilder().append(llllllllllllllIIIlIIllIIIIIIlIll).append(".enter();")), false);
                    final String llllllllllllllIIIlIIllIIIIIlIIIl = String.valueOf(new StringBuilder().append(llllllllllllllIIIlIIllIIIIIIlIll).append(".exit();"));
                    this.insertAfter(llllllllllllllIIIlIIllIIIIIlIIIl, true);
                }
                catch (NotFoundException llllllllllllllIIIlIIllIIIIIlIIII) {
                    throw new CannotCompileException(llllllllllllllIIIlIIllIIIIIlIIII);
                }
            }
        }
    }
    
    @Override
    public byte[] getAttribute(final String llllllllllllllIIIlIIllIIIIlIlIII) {
        final AttributeInfo llllllllllllllIIIlIIllIIIIlIlIlI = this.methodInfo.getAttribute(llllllllllllllIIIlIIllIIIIlIlIII);
        if (llllllllllllllIIIlIIllIIIIlIlIlI == null) {
            return null;
        }
        return llllllllllllllIIIlIIllIIIIlIlIlI.get();
    }
    
    public CtClass[] getExceptionTypes() throws NotFoundException {
        final ExceptionsAttribute llllllllllllllIIIlIIllIIIlllIllI = this.methodInfo.getExceptionsAttribute();
        String[] llllllllllllllIIIlIIllIIIlllIlll = null;
        if (llllllllllllllIIIlIIllIIIlllIllI == null) {
            final String[] llllllllllllllIIIlIIllIIIllllIIl = null;
        }
        else {
            llllllllllllllIIIlIIllIIIlllIlll = llllllllllllllIIIlIIllIIIlllIllI.getExceptions();
        }
        return this.declaringClass.getClassPool().get(llllllllllllllIIIlIIllIIIlllIlll);
    }
    
    public MethodInfo getMethodInfo2() {
        return this.methodInfo;
    }
    
    public abstract boolean isEmpty();
    
    public void setBody(final String llllllllllllllIIIlIIllIIIlIlIIll, final String llllllllllllllIIIlIIllIIIlIIllIl, final String llllllllllllllIIIlIIllIIIlIlIIIl) throws CannotCompileException {
        final CtClass llllllllllllllIIIlIIllIIIlIlIIII = this.declaringClass;
        llllllllllllllIIIlIIllIIIlIlIIII.checkModify();
        try {
            final Javac llllllllllllllIIIlIIllIIIlIllIII = new Javac(llllllllllllllIIIlIIllIIIlIlIIII);
            if (llllllllllllllIIIlIIllIIIlIlIIIl != null) {
                llllllllllllllIIIlIIllIIIlIllIII.recordProceed(llllllllllllllIIIlIIllIIIlIIllIl, llllllllllllllIIIlIIllIIIlIlIIIl);
            }
            final Bytecode llllllllllllllIIIlIIllIIIlIlIlll = llllllllllllllIIIlIIllIIIlIllIII.compileBody(this, llllllllllllllIIIlIIllIIIlIlIIll);
            this.methodInfo.setCodeAttribute(llllllllllllllIIIlIIllIIIlIlIlll.toCodeAttribute());
            this.methodInfo.setAccessFlags(this.methodInfo.getAccessFlags() & 0xFFFFFBFF);
            this.methodInfo.rebuildStackMapIf6(llllllllllllllIIIlIIllIIIlIlIIII.getClassPool(), llllllllllllllIIIlIIllIIIlIlIIII.getClassFile2());
            this.declaringClass.rebuildClassFile();
        }
        catch (CompileError llllllllllllllIIIlIIllIIIlIlIllI) {
            throw new CannotCompileException(llllllllllllllIIIlIIllIIIlIlIllI);
        }
        catch (BadBytecode llllllllllllllIIIlIIllIIIlIlIlIl) {
            throw new CannotCompileException(llllllllllllllIIIlIIllIIIlIlIlIl);
        }
    }
}
