package com.viaversion.viaversion.libs.javassist.expr;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;

public abstract class Expr implements Opcode
{
    /* synthetic */ boolean edited;
    /* synthetic */ CtClass thisClass;
    /* synthetic */ int maxLocals;
    /* synthetic */ int maxStack;
    /* synthetic */ CodeIterator iterator;
    /* synthetic */ int currentPos;
    /* synthetic */ MethodInfo thisMethod;
    
    protected final boolean edited() {
        return this.edited;
    }
    
    protected final int locals() {
        return this.maxLocals;
    }
    
    protected Expr(final int lllllllllllllIIlIIlllIIlIlIIllIl, final CodeIterator lllllllllllllIIlIIlllIIlIlIIIlll, final CtClass lllllllllllllIIlIIlllIIlIlIIlIll, final MethodInfo lllllllllllllIIlIIlllIIlIlIIlIlI) {
        this.currentPos = lllllllllllllIIlIIlllIIlIlIIllIl;
        this.iterator = lllllllllllllIIlIIlllIIlIlIIIlll;
        this.thisClass = lllllllllllllIIlIIlllIIlIlIIlIll;
        this.thisMethod = lllllllllllllIIlIIlllIIlIlIIlIlI;
    }
    
    public abstract void replace(final String p0) throws CannotCompileException;
    
    public int getLineNumber() {
        return this.thisMethod.getLineNumber(this.currentPos);
    }
    
    private static void addClass(final List<CtClass> lllllllllllllIIlIIlllIIIllllllII, final CtClass lllllllllllllIIlIIlllIIIlllllIIl) {
        if (lllllllllllllIIlIIlllIIIllllllII.contains(lllllllllllllIIlIIlllIIIlllllIIl)) {
            return;
        }
        lllllllllllllIIlIIlllIIIllllllII.add(lllllllllllllIIlIIlllIIIlllllIIl);
    }
    
    public CtClass[] mayThrow() {
        final ClassPool lllllllllllllIIlIIlllIIlIIIIllIl = this.thisClass.getClassPool();
        final ConstPool lllllllllllllIIlIIlllIIlIIIIllII = this.thisMethod.getConstPool();
        final List<CtClass> lllllllllllllIIlIIlllIIlIIIIlIll = new LinkedList<CtClass>();
        try {
            final CodeAttribute lllllllllllllIIlIIlllIIlIIIlIlIl = this.thisMethod.getCodeAttribute();
            final ExceptionTable lllllllllllllIIlIIlllIIlIIIlIlII = lllllllllllllIIlIIlllIIlIIIlIlIl.getExceptionTable();
            final int lllllllllllllIIlIIlllIIlIIIlIIll = this.currentPos;
            for (int lllllllllllllIIlIIlllIIlIIIlIIlI = lllllllllllllIIlIIlllIIlIIIlIlII.size(), lllllllllllllIIlIIlllIIlIIIlIllI = 0; lllllllllllllIIlIIlllIIlIIIlIllI < lllllllllllllIIlIIlllIIlIIIlIIlI; ++lllllllllllllIIlIIlllIIlIIIlIllI) {
                if (lllllllllllllIIlIIlllIIlIIIlIlII.startPc(lllllllllllllIIlIIlllIIlIIIlIllI) <= lllllllllllllIIlIIlllIIlIIIlIIll && lllllllllllllIIlIIlllIIlIIIlIIll < lllllllllllllIIlIIlllIIlIIIlIlII.endPc(lllllllllllllIIlIIlllIIlIIIlIllI)) {
                    final int lllllllllllllIIlIIlllIIlIIIlIlll = lllllllllllllIIlIIlllIIlIIIlIlII.catchType(lllllllllllllIIlIIlllIIlIIIlIllI);
                    if (lllllllllllllIIlIIlllIIlIIIlIlll > 0) {
                        try {
                            addClass(lllllllllllllIIlIIlllIIlIIIIlIll, lllllllllllllIIlIIlllIIlIIIIllIl.get(lllllllllllllIIlIIlllIIlIIIIllII.getClassInfo(lllllllllllllIIlIIlllIIlIIIlIlll)));
                        }
                        catch (NotFoundException ex) {}
                    }
                }
            }
        }
        catch (NullPointerException ex2) {}
        final ExceptionsAttribute lllllllllllllIIlIIlllIIlIIIIlIlI = this.thisMethod.getExceptionsAttribute();
        if (lllllllllllllIIlIIlllIIlIIIIlIlI != null) {
            final String[] lllllllllllllIIlIIlllIIlIIIIllll = lllllllllllllIIlIIlllIIlIIIIlIlI.getExceptions();
            if (lllllllllllllIIlIIlllIIlIIIIllll != null) {
                for (int lllllllllllllIIlIIlllIIlIIIlIIII = lllllllllllllIIlIIlllIIlIIIIllll.length, lllllllllllllIIlIIlllIIlIIIlIIIl = 0; lllllllllllllIIlIIlllIIlIIIlIIIl < lllllllllllllIIlIIlllIIlIIIlIIII; ++lllllllllllllIIlIIlllIIlIIIlIIIl) {
                    try {
                        addClass(lllllllllllllIIlIIlllIIlIIIIlIll, lllllllllllllIIlIIlllIIlIIIIllIl.get(lllllllllllllIIlIIlllIIlIIIIllll[lllllllllllllIIlIIlllIIlIIIlIIIl]));
                    }
                    catch (NotFoundException ex3) {}
                }
            }
        }
        return lllllllllllllIIlIIlllIIlIIIIlIll.toArray(new CtClass[lllllllllllllIIlIIlllIIlIIIIlIll.size()]);
    }
    
    public CtClass getEnclosingClass() {
        return this.thisClass;
    }
    
    public void replace(final String lllllllllllllIIlIIlllIIIlIlllIlI, final ExprEditor lllllllllllllIIlIIlllIIIlIlllIIl) throws CannotCompileException {
        this.replace(lllllllllllllIIlIIlllIIIlIlllIlI);
        if (lllllllllllllIIlIIlllIIIlIlllIIl != null) {
            this.runEditor(lllllllllllllIIlIIlllIIIlIlllIIl, this.iterator);
        }
    }
    
    public int indexOfBytecode() {
        return this.currentPos;
    }
    
    protected final ConstPool getConstPool() {
        return this.thisMethod.getConstPool();
    }
    
    private static void storeStack0(final int lllllllllllllIIlIIlllIIIllIIllll, final int lllllllllllllIIlIIlllIIIllIIlllI, final CtClass[] lllllllllllllIIlIIlllIIIllIIllIl, final int lllllllllllllIIlIIlllIIIllIIllII, final Bytecode lllllllllllllIIlIIlllIIIllIIlIll) {
        if (lllllllllllllIIlIIlllIIIllIIllll >= lllllllllllllIIlIIlllIIIllIIlllI) {
            return;
        }
        final CtClass lllllllllllllIIlIIlllIIIllIIlIlI = lllllllllllllIIlIIlllIIIllIIllIl[lllllllllllllIIlIIlllIIIllIIllll];
        int lllllllllllllIIlIIlllIIIllIIlIIl = 0;
        if (lllllllllllllIIlIIlllIIIllIIlIlI instanceof CtPrimitiveType) {
            final int lllllllllllllIIlIIlllIIIllIlIIII = ((CtPrimitiveType)lllllllllllllIIlIIlllIIIllIIlIlI).getDataSize();
        }
        else {
            lllllllllllllIIlIIlllIIIllIIlIIl = 1;
        }
        storeStack0(lllllllllllllIIlIIlllIIIllIIllll + 1, lllllllllllllIIlIIlllIIIllIIlllI, lllllllllllllIIlIIlllIIIllIIllIl, lllllllllllllIIlIIlllIIIllIIllII + lllllllllllllIIlIIlllIIIllIIlIIl, lllllllllllllIIlIIlllIIIllIIlIll);
        lllllllllllllIIlIIlllIIIllIIlIll.addStore(lllllllllllllIIlIIlllIIIllIIllII, lllllllllllllIIlIIlllIIIllIIlIlI);
    }
    
    protected void replace0(int lllllllllllllIIlIIlllIIIlIlIlIIl, final Bytecode lllllllllllllIIlIIlllIIIlIlIlllI, final int lllllllllllllIIlIIlllIIIlIlIIlll) throws BadBytecode {
        final byte[] lllllllllllllIIlIIlllIIIlIlIllII = lllllllllllllIIlIIlllIIIlIlIlllI.get();
        this.edited = true;
        final int lllllllllllllIIlIIlllIIIlIlIlIll = lllllllllllllIIlIIlllIIIlIlIllII.length - lllllllllllllIIlIIlllIIIlIlIIlll;
        for (int lllllllllllllIIlIIlllIIIlIllIIIl = 0; lllllllllllllIIlIIlllIIIlIllIIIl < lllllllllllllIIlIIlllIIIlIlIIlll; ++lllllllllllllIIlIIlllIIIlIllIIIl) {
            this.iterator.writeByte(0, lllllllllllllIIlIIlllIIIlIlIlIIl + lllllllllllllIIlIIlllIIIlIllIIIl);
        }
        if (lllllllllllllIIlIIlllIIIlIlIlIll > 0) {
            lllllllllllllIIlIIlllIIIlIlIlIIl = this.iterator.insertGapAt(lllllllllllllIIlIIlllIIIlIlIlIIl, lllllllllllllIIlIIlllIIIlIlIlIll, false).position;
        }
        this.iterator.write(lllllllllllllIIlIIlllIIIlIlIllII, lllllllllllllIIlIIlllIIIlIlIlIIl);
        this.iterator.insert(lllllllllllllIIlIIlllIIIlIlIlllI.getExceptionTable(), lllllllllllllIIlIIlllIIIlIlIlIIl);
        this.maxLocals = lllllllllllllIIlIIlllIIIlIlIlllI.getMaxLocals();
        this.maxStack = lllllllllllllIIlIIlllIIIlIlIlllI.getMaxStack();
    }
    
    protected final boolean withinStatic() {
        return (this.thisMethod.getAccessFlags() & 0x8) != 0x0;
    }
    
    protected final int stack() {
        return this.maxStack;
    }
    
    static {
        javaLangObject = "java.lang.Object";
    }
    
    public String getFileName() {
        final ClassFile lllllllllllllIIlIIlllIIIlllIllll = this.thisClass.getClassFile2();
        if (lllllllllllllIIlIIlllIIIlllIllll == null) {
            return null;
        }
        return lllllllllllllIIlIIlllIIIlllIllll.getSourceFile();
    }
    
    protected void runEditor(final ExprEditor lllllllllllllIIlIIlllIIIlIIllIII, final CodeIterator lllllllllllllIIlIIlllIIIlIIlIlll) throws CannotCompileException {
        final CodeAttribute lllllllllllllIIlIIlllIIIlIIlIllI = lllllllllllllIIlIIlllIIIlIIlIlll.get();
        final int lllllllllllllIIlIIlllIIIlIIlIlIl = lllllllllllllIIlIIlllIIIlIIlIllI.getMaxLocals();
        final int lllllllllllllIIlIIlllIIIlIIlIlII = lllllllllllllIIlIIlllIIIlIIlIllI.getMaxStack();
        final int lllllllllllllIIlIIlllIIIlIIlIIll = this.locals();
        lllllllllllllIIlIIlllIIIlIIlIllI.setMaxStack(this.stack());
        lllllllllllllIIlIIlllIIIlIIlIllI.setMaxLocals(lllllllllllllIIlIIlllIIIlIIlIIll);
        final ExprEditor.LoopContext lllllllllllllIIlIIlllIIIlIIlIIlI = new ExprEditor.LoopContext(lllllllllllllIIlIIlllIIIlIIlIIll);
        final int lllllllllllllIIlIIlllIIIlIIlIIIl = lllllllllllllIIlIIlllIIIlIIlIlll.getCodeLength();
        final int lllllllllllllIIlIIlllIIIlIIlIIII = lllllllllllllIIlIIlllIIIlIIlIlll.lookAhead();
        lllllllllllllIIlIIlllIIIlIIlIlll.move(this.currentPos);
        if (lllllllllllllIIlIIlllIIIlIIllIII.doit(this.thisClass, this.thisMethod, lllllllllllllIIlIIlllIIIlIIlIIlI, lllllllllllllIIlIIlllIIIlIIlIlll, lllllllllllllIIlIIlllIIIlIIlIIII)) {
            this.edited = true;
        }
        lllllllllllllIIlIIlllIIIlIIlIlll.move(lllllllllllllIIlIIlllIIIlIIlIIII + lllllllllllllIIlIIlllIIIlIIlIlll.getCodeLength() - lllllllllllllIIlIIlllIIIlIIlIIIl);
        lllllllllllllIIlIIlllIIIlIIlIllI.setMaxLocals(lllllllllllllIIlIIlllIIIlIIlIlIl);
        lllllllllllllIIlIIlllIIIlIIlIllI.setMaxStack(lllllllllllllIIlIIlllIIIlIIlIlII);
        this.maxLocals = lllllllllllllIIlIIlllIIIlIIlIIlI.maxLocals;
        this.maxStack += lllllllllllllIIlIIlllIIIlIIlIIlI.maxStack;
    }
    
    static final boolean checkResultValue(final CtClass lllllllllllllIIlIIlllIIIlllIIllI, final String lllllllllllllIIlIIlllIIIlllIlIII) throws CannotCompileException {
        final boolean lllllllllllllIIlIIlllIIIlllIIlll = lllllllllllllIIlIIlllIIIlllIlIII.indexOf("$_") >= 0;
        if (!lllllllllllllIIlIIlllIIIlllIIlll && lllllllllllllIIlIIlllIIIlllIIllI != CtClass.voidType) {
            throw new CannotCompileException("the resulting value is not stored in $_");
        }
        return lllllllllllllIIlIIlllIIIlllIIlll;
    }
    
    static final void storeStack(final CtClass[] lllllllllllllIIlIIlllIIIllIllIll, final boolean lllllllllllllIIlIIlllIIIllIllIlI, final int lllllllllllllIIlIIlllIIIllIlllIl, final Bytecode lllllllllllllIIlIIlllIIIllIllIII) {
        storeStack0(0, lllllllllllllIIlIIlllIIIllIllIll.length, lllllllllllllIIlIIlllIIIllIllIll, lllllllllllllIIlIIlllIIIllIlllIl + 1, lllllllllllllIIlIIlllIIIllIllIII);
        if (lllllllllllllIIlIIlllIIIllIllIlI) {
            lllllllllllllIIlIIlllIIIllIllIII.addOpcode(1);
        }
        lllllllllllllIIlIIlllIIIllIllIII.addAstore(lllllllllllllIIlIIlllIIIllIlllIl);
    }
    
    public CtBehavior where() {
        final MethodInfo lllllllllllllIIlIIlllIIlIIlIlIlI = this.thisMethod;
        final CtBehavior[] lllllllllllllIIlIIlllIIlIIlIlIIl = this.thisClass.getDeclaredBehaviors();
        for (int lllllllllllllIIlIIlllIIlIIlIllIl = lllllllllllllIIlIIlllIIlIIlIlIIl.length - 1; lllllllllllllIIlIIlllIIlIIlIllIl >= 0; --lllllllllllllIIlIIlllIIlIIlIllIl) {
            if (lllllllllllllIIlIIlllIIlIIlIlIIl[lllllllllllllIIlIIlllIIlIIlIllIl].getMethodInfo2() == lllllllllllllIIlIIlllIIlIIlIlIlI) {
                return lllllllllllllIIlIIlllIIlIIlIlIIl[lllllllllllllIIlIIlllIIlIIlIllIl];
            }
        }
        final CtConstructor lllllllllllllIIlIIlllIIlIIlIlIII = this.thisClass.getClassInitializer();
        if (lllllllllllllIIlIIlllIIlIIlIlIII != null && lllllllllllllIIlIIlllIIlIIlIlIII.getMethodInfo2() == lllllllllllllIIlIIlllIIlIIlIlIlI) {
            return lllllllllllllIIlIIlllIIlIIlIlIII;
        }
        for (int lllllllllllllIIlIIlllIIlIIlIllII = lllllllllllllIIlIIlllIIlIIlIlIIl.length - 1; lllllllllllllIIlIIlllIIlIIlIllII >= 0; --lllllllllllllIIlIIlllIIlIIlIllII) {
            if (this.thisMethod.getName().equals(lllllllllllllIIlIIlllIIlIIlIlIIl[lllllllllllllIIlIIlllIIlIIlIllII].getMethodInfo2().getName()) && this.thisMethod.getDescriptor().equals(lllllllllllllIIlIIlllIIlIIlIlIIl[lllllllllllllIIlIIlllIIlIIlIllII].getMethodInfo2().getDescriptor())) {
                return lllllllllllllIIlIIlllIIlIIlIlIIl[lllllllllllllIIlIIlllIIlIIlIllII];
            }
        }
        throw new RuntimeException("fatal: not found");
    }
}
