package com.viaversion.viaversion.libs.javassist.expr;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;
import com.viaversion.viaversion.libs.javassist.*;

public class FieldAccess extends Expr
{
    /* synthetic */ int opcode;
    
    public boolean isStatic() {
        return isStatic(this.opcode);
    }
    
    @Override
    public String getFileName() {
        return super.getFileName();
    }
    
    private CtClass getCtClass() throws NotFoundException {
        return this.thisClass.getClassPool().get(this.getClassName());
    }
    
    static boolean isStatic(final int lllllllllllllIIllIllIlllIllIIIIl) {
        return lllllllllllllIIllIllIlllIllIIIIl == 178 || lllllllllllllIIllIllIlllIllIIIIl == 179;
    }
    
    @Override
    public CtBehavior where() {
        return super.where();
    }
    
    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }
    
    public boolean isWriter() {
        return this.opcode == 181 || this.opcode == 179;
    }
    
    protected FieldAccess(final int lllllllllllllIIllIllIlllIllllIlI, final CodeIterator lllllllllllllIIllIllIlllIlllIIll, final CtClass lllllllllllllIIllIllIlllIlllIIlI, final MethodInfo lllllllllllllIIllIllIlllIlllIIIl, final int lllllllllllllIIllIllIlllIlllIllI) {
        super(lllllllllllllIIllIllIlllIllllIlI, lllllllllllllIIllIllIlllIlllIIll, lllllllllllllIIllIllIlllIlllIIlI, lllllllllllllIIllIllIlllIlllIIIl);
        this.opcode = lllllllllllllIIllIllIlllIlllIllI;
    }
    
    @Override
    public void replace(final String lllllllllllllIIllIllIlllIIIlIIlI) throws CannotCompileException {
        this.thisClass.getClassFile();
        final ConstPool lllllllllllllIIllIllIlllIIIllIII = this.getConstPool();
        final int lllllllllllllIIllIllIlllIIIlIlll = this.currentPos;
        final int lllllllllllllIIllIllIlllIIIlIllI = this.iterator.u16bitAt(lllllllllllllIIllIllIlllIIIlIlll + 1);
        final Javac lllllllllllllIIllIllIlllIIIlIlIl = new Javac(this.thisClass);
        final CodeAttribute lllllllllllllIIllIllIlllIIIlIlII = this.iterator.get();
        try {
            final CtClass lllllllllllllIIllIllIlllIIlIIIll = Descriptor.toCtClass(lllllllllllllIIllIllIlllIIIllIII.getFieldrefType(lllllllllllllIIllIllIlllIIIlIllI), this.thisClass.getClassPool());
            final boolean lllllllllllllIIllIllIlllIIlIIIlI = this.isReader();
            CtClass[] lllllllllllllIIllIllIlllIIlIIlIl = null;
            CtClass lllllllllllllIIllIllIlllIIlIIlII = null;
            if (lllllllllllllIIllIllIlllIIlIIIlI) {
                final CtClass[] lllllllllllllIIllIllIlllIIlIIlll = new CtClass[0];
                final CtClass lllllllllllllIIllIllIlllIIlIIllI = lllllllllllllIIllIllIlllIIlIIIll;
            }
            else {
                lllllllllllllIIllIllIlllIIlIIlIl = new CtClass[] { lllllllllllllIIllIllIlllIIlIIIll };
                lllllllllllllIIllIllIlllIIlIIlII = CtClass.voidType;
            }
            final int lllllllllllllIIllIllIlllIIlIIIIl = lllllllllllllIIllIllIlllIIIlIlII.getMaxLocals();
            lllllllllllllIIllIllIlllIIIlIlIl.recordParams(lllllllllllllIIllIllIlllIIIllIII.getFieldrefClassName(lllllllllllllIIllIllIlllIIIlIllI), lllllllllllllIIllIllIlllIIlIIlIl, true, lllllllllllllIIllIllIlllIIlIIIIl, this.withinStatic());
            boolean lllllllllllllIIllIllIlllIIlIIIII = Expr.checkResultValue(lllllllllllllIIllIllIlllIIlIIlII, lllllllllllllIIllIllIlllIIIlIIlI);
            if (lllllllllllllIIllIllIlllIIlIIIlI) {
                lllllllllllllIIllIllIlllIIlIIIII = true;
            }
            final int lllllllllllllIIllIllIlllIIIlllll = lllllllllllllIIllIllIlllIIIlIlIl.recordReturnType(lllllllllllllIIllIllIlllIIlIIlII, lllllllllllllIIllIllIlllIIlIIIII);
            if (lllllllllllllIIllIllIlllIIlIIIlI) {
                lllllllllllllIIllIllIlllIIIlIlIl.recordProceed(new ProceedForRead(lllllllllllllIIllIllIlllIIlIIlII, this.opcode, lllllllllllllIIllIllIlllIIIlIllI, lllllllllllllIIllIllIlllIIlIIIIl));
            }
            else {
                lllllllllllllIIllIllIlllIIIlIlIl.recordType(lllllllllllllIIllIllIlllIIlIIIll);
                lllllllllllllIIllIllIlllIIIlIlIl.recordProceed(new ProceedForWrite(lllllllllllllIIllIllIlllIIlIIlIl[0], this.opcode, lllllllllllllIIllIllIlllIIIlIllI, lllllllllllllIIllIllIlllIIlIIIIl));
            }
            final Bytecode lllllllllllllIIllIllIlllIIIllllI = lllllllllllllIIllIllIlllIIIlIlIl.getBytecode();
            Expr.storeStack(lllllllllllllIIllIllIlllIIlIIlIl, this.isStatic(), lllllllllllllIIllIllIlllIIlIIIIl, lllllllllllllIIllIllIlllIIIllllI);
            lllllllllllllIIllIllIlllIIIlIlIl.recordLocalVariables(lllllllllllllIIllIllIlllIIIlIlII, lllllllllllllIIllIllIlllIIIlIlll);
            if (lllllllllllllIIllIllIlllIIlIIIII) {
                if (lllllllllllllIIllIllIlllIIlIIlII == CtClass.voidType) {
                    lllllllllllllIIllIllIlllIIIllllI.addOpcode(1);
                    lllllllllllllIIllIllIlllIIIllllI.addAstore(lllllllllllllIIllIllIlllIIIlllll);
                }
                else {
                    lllllllllllllIIllIllIlllIIIllllI.addConstZero(lllllllllllllIIllIllIlllIIlIIlII);
                    lllllllllllllIIllIllIlllIIIllllI.addStore(lllllllllllllIIllIllIlllIIIlllll, lllllllllllllIIllIllIlllIIlIIlII);
                }
            }
            lllllllllllllIIllIllIlllIIIlIlIl.compileStmnt(lllllllllllllIIllIllIlllIIIlIIlI);
            if (lllllllllllllIIllIllIlllIIlIIIlI) {
                lllllllllllllIIllIllIlllIIIllllI.addLoad(lllllllllllllIIllIllIlllIIIlllll, lllllllllllllIIllIllIlllIIlIIlII);
            }
            this.replace0(lllllllllllllIIllIllIlllIIIlIlll, lllllllllllllIIllIllIlllIIIllllI, 3);
        }
        catch (CompileError lllllllllllllIIllIllIlllIIIlllIl) {
            throw new CannotCompileException(lllllllllllllIIllIllIlllIIIlllIl);
        }
        catch (NotFoundException lllllllllllllIIllIllIlllIIIlllII) {
            throw new CannotCompileException(lllllllllllllIIllIllIlllIIIlllII);
        }
        catch (BadBytecode lllllllllllllIIllIllIlllIIIllIll) {
            throw new CannotCompileException("broken method");
        }
    }
    
    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }
    
    public String getFieldName() {
        final int lllllllllllllIIllIllIlllIlIIlllI = this.iterator.u16bitAt(this.currentPos + 1);
        return this.getConstPool().getFieldrefName(lllllllllllllIIllIllIlllIlIIlllI);
    }
    
    public String getSignature() {
        final int lllllllllllllIIllIllIlllIIlllIIl = this.iterator.u16bitAt(this.currentPos + 1);
        return this.getConstPool().getFieldrefType(lllllllllllllIIllIllIlllIIlllIIl);
    }
    
    public boolean isReader() {
        return this.opcode == 180 || this.opcode == 178;
    }
    
    public String getClassName() {
        final int lllllllllllllIIllIllIlllIlIlIlII = this.iterator.u16bitAt(this.currentPos + 1);
        return this.getConstPool().getFieldrefClassName(lllllllllllllIIllIllIlllIlIlIlII);
    }
    
    public CtField getField() throws NotFoundException {
        final CtClass lllllllllllllIIllIllIlllIlIIIllI = this.getCtClass();
        final int lllllllllllllIIllIllIlllIlIIIlIl = this.iterator.u16bitAt(this.currentPos + 1);
        final ConstPool lllllllllllllIIllIllIlllIlIIIlII = this.getConstPool();
        return lllllllllllllIIllIllIlllIlIIIllI.getField(lllllllllllllIIllIllIlllIlIIIlII.getFieldrefName(lllllllllllllIIllIllIlllIlIIIlIl), lllllllllllllIIllIllIlllIlIIIlII.getFieldrefType(lllllllllllllIIllIllIlllIlIIIlIl));
    }
    
    static class ProceedForRead implements ProceedHandler
    {
        /* synthetic */ int opcode;
        /* synthetic */ int index;
        /* synthetic */ CtClass fieldType;
        /* synthetic */ int targetVar;
        
        @Override
        public void setReturnType(final JvstTypeChecker llllllllllllllIIlIIIIIlIllIIIIll, final ASTList llllllllllllllIIlIIIIIlIllIIIIlI) throws CompileError {
            llllllllllllllIIlIIIIIlIllIIIIll.setType(this.fieldType);
        }
        
        ProceedForRead(final CtClass llllllllllllllIIlIIIIIlIllIllIlI, final int llllllllllllllIIlIIIIIlIllIllIIl, final int llllllllllllllIIlIIIIIlIllIlllIl, final int llllllllllllllIIlIIIIIlIllIlIlll) {
            this.fieldType = llllllllllllllIIlIIIIIlIllIllIlI;
            this.targetVar = llllllllllllllIIlIIIIIlIllIlIlll;
            this.opcode = llllllllllllllIIlIIIIIlIllIllIIl;
            this.index = llllllllllllllIIlIIIIIlIllIlllIl;
        }
        
        @Override
        public void doit(final JvstCodeGen llllllllllllllIIlIIIIIlIllIIllll, final Bytecode llllllllllllllIIlIIIIIlIllIIlIIl, final ASTList llllllllllllllIIlIIIIIlIllIIllIl) throws CompileError {
            if (llllllllllllllIIlIIIIIlIllIIllIl != null && !llllllllllllllIIlIIIIIlIllIIllll.isParamListName(llllllllllllllIIlIIIIIlIllIIllIl)) {
                throw new CompileError("$proceed() cannot take a parameter for field reading");
            }
            int llllllllllllllIIlIIIIIlIllIIllII = 0;
            if (FieldAccess.isStatic(this.opcode)) {
                final int llllllllllllllIIlIIIIIlIllIlIIIl = 0;
            }
            else {
                llllllllllllllIIlIIIIIlIllIIllII = -1;
                llllllllllllllIIlIIIIIlIllIIlIIl.addAload(this.targetVar);
            }
            if (this.fieldType instanceof CtPrimitiveType) {
                llllllllllllllIIlIIIIIlIllIIllII += ((CtPrimitiveType)this.fieldType).getDataSize();
            }
            else {
                ++llllllllllllllIIlIIIIIlIllIIllII;
            }
            llllllllllllllIIlIIIIIlIllIIlIIl.add(this.opcode);
            llllllllllllllIIlIIIIIlIllIIlIIl.addIndex(this.index);
            llllllllllllllIIlIIIIIlIllIIlIIl.growStack(llllllllllllllIIlIIIIIlIllIIllII);
            llllllllllllllIIlIIIIIlIllIIllll.setType(this.fieldType);
        }
    }
    
    static class ProceedForWrite implements ProceedHandler
    {
        /* synthetic */ int opcode;
        /* synthetic */ int index;
        /* synthetic */ int targetVar;
        /* synthetic */ CtClass fieldType;
        
        ProceedForWrite(final CtClass lllllllllllllIIlIllIIIIlIIIIllll, final int lllllllllllllIIlIllIIIIlIIIlIIll, final int lllllllllllllIIlIllIIIIlIIIIllIl, final int lllllllllllllIIlIllIIIIlIIIlIIIl) {
            this.fieldType = lllllllllllllIIlIllIIIIlIIIIllll;
            this.targetVar = lllllllllllllIIlIllIIIIlIIIlIIIl;
            this.opcode = lllllllllllllIIlIllIIIIlIIIlIIll;
            this.index = lllllllllllllIIlIllIIIIlIIIIllIl;
        }
        
        @Override
        public void doit(final JvstCodeGen lllllllllllllIIlIllIIIIlIIIIIlII, final Bytecode lllllllllllllIIlIllIIIIIlllllllI, final ASTList lllllllllllllIIlIllIIIIlIIIIIIlI) throws CompileError {
            if (lllllllllllllIIlIllIIIIlIIIIIlII.getMethodArgsLength(lllllllllllllIIlIllIIIIlIIIIIIlI) != 1) {
                throw new CompileError("$proceed() cannot take more than one parameter for field writing");
            }
            int lllllllllllllIIlIllIIIIlIIIIIIIl = 0;
            if (FieldAccess.isStatic(this.opcode)) {
                final int lllllllllllllIIlIllIIIIlIIIIIllI = 0;
            }
            else {
                lllllllllllllIIlIllIIIIlIIIIIIIl = -1;
                lllllllllllllIIlIllIIIIIlllllllI.addAload(this.targetVar);
            }
            lllllllllllllIIlIllIIIIlIIIIIlII.atMethodArgs(lllllllllllllIIlIllIIIIlIIIIIIlI, new int[1], new int[1], new String[1]);
            lllllllllllllIIlIllIIIIlIIIIIlII.doNumCast(this.fieldType);
            if (this.fieldType instanceof CtPrimitiveType) {
                lllllllllllllIIlIllIIIIlIIIIIIIl -= ((CtPrimitiveType)this.fieldType).getDataSize();
            }
            else {
                --lllllllllllllIIlIllIIIIlIIIIIIIl;
            }
            lllllllllllllIIlIllIIIIIlllllllI.add(this.opcode);
            lllllllllllllIIlIllIIIIIlllllllI.addIndex(this.index);
            lllllllllllllIIlIllIIIIIlllllllI.growStack(lllllllllllllIIlIllIIIIlIIIIIIIl);
            lllllllllllllIIlIllIIIIlIIIIIlII.setType(CtClass.voidType);
            lllllllllllllIIlIllIIIIlIIIIIlII.addNullIfVoid();
        }
        
        @Override
        public void setReturnType(final JvstTypeChecker lllllllllllllIIlIllIIIIIllllIllI, final ASTList lllllllllllllIIlIllIIIIIllllIlIl) throws CompileError {
            lllllllllllllIIlIllIIIIIllllIllI.atMethodArgs(lllllllllllllIIlIllIIIIIllllIlIl, new int[1], new int[1], new String[1]);
            lllllllllllllIIlIllIIIIIllllIllI.setType(CtClass.voidType);
            lllllllllllllIIlIllIIIIIllllIllI.addNullIfVoid();
        }
    }
}
