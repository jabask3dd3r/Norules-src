package com.viaversion.viaversion.libs.javassist.expr;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;

public class NewArray extends Expr
{
    /* synthetic */ int opcode;
    
    @Override
    public CtBehavior where() {
        return super.where();
    }
    
    public int getCreatedDimensions() {
        if (this.opcode == 197) {
            return this.iterator.byteAt(this.currentPos + 3);
        }
        return 1;
    }
    
    CtClass getPrimitiveType(final int lllllllllllllIlIllIIlIlIIIlIlIIl) {
        switch (lllllllllllllIlIllIIlIlIIIlIlIIl) {
            case 4: {
                return CtClass.booleanType;
            }
            case 5: {
                return CtClass.charType;
            }
            case 6: {
                return CtClass.floatType;
            }
            case 7: {
                return CtClass.doubleType;
            }
            case 8: {
                return CtClass.byteType;
            }
            case 9: {
                return CtClass.shortType;
            }
            case 10: {
                return CtClass.intType;
            }
            case 11: {
                return CtClass.longType;
            }
            default: {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("bad atype: ").append(lllllllllllllIlIllIIlIlIIIlIlIIl)));
            }
        }
    }
    
    protected NewArray(final int lllllllllllllIlIllIIlIlIIlIlIIII, final CodeIterator lllllllllllllIlIllIIlIlIIlIIllll, final CtClass lllllllllllllIlIllIIlIlIIlIIlllI, final MethodInfo lllllllllllllIlIllIIlIlIIlIIllIl, final int lllllllllllllIlIllIIlIlIIlIIllII) {
        super(lllllllllllllIlIllIIlIlIIlIlIIII, lllllllllllllIlIllIIlIlIIlIIllll, lllllllllllllIlIllIIlIlIIlIIlllI, lllllllllllllIlIllIIlIlIIlIIllIl);
        this.opcode = lllllllllllllIlIllIIlIlIIlIIllII;
    }
    
    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }
    
    public CtClass getComponentType() throws NotFoundException {
        if (this.opcode == 188) {
            final int lllllllllllllIlIllIIlIlIIIllIlIl = this.iterator.byteAt(this.currentPos + 1);
            return this.getPrimitiveType(lllllllllllllIlIllIIlIlIIIllIlIl);
        }
        if (this.opcode == 189 || this.opcode == 197) {
            final int lllllllllllllIlIllIIlIlIIIllIlII = this.iterator.u16bitAt(this.currentPos + 1);
            String lllllllllllllIlIllIIlIlIIIllIIll = this.getConstPool().getClassInfo(lllllllllllllIlIllIIlIlIIIllIlII);
            final int lllllllllllllIlIllIIlIlIIIllIIlI = Descriptor.arrayDimension(lllllllllllllIlIllIIlIlIIIllIIll);
            lllllllllllllIlIllIIlIlIIIllIIll = Descriptor.toArrayComponent(lllllllllllllIlIllIIlIlIIIllIIll, lllllllllllllIlIllIIlIlIIIllIIlI);
            return Descriptor.toCtClass(lllllllllllllIlIllIIlIlIIIllIIll, this.thisClass.getClassPool());
        }
        throw new RuntimeException(String.valueOf(new StringBuilder().append("bad opcode: ").append(this.opcode)));
    }
    
    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }
    
    @Override
    public String getFileName() {
        return super.getFileName();
    }
    
    @Override
    public void replace(final String lllllllllllllIlIllIIlIlIIIIlIlIl) throws CannotCompileException {
        try {
            this.replace2(lllllllllllllIlIllIIlIlIIIIlIlIl);
        }
        catch (CompileError lllllllllllllIlIllIIlIlIIIIllIIl) {
            throw new CannotCompileException(lllllllllllllIlIllIIlIlIIIIllIIl);
        }
        catch (NotFoundException lllllllllllllIlIllIIlIlIIIIllIII) {
            throw new CannotCompileException(lllllllllllllIlIllIIlIlIIIIllIII);
        }
        catch (BadBytecode lllllllllllllIlIllIIlIlIIIIlIlll) {
            throw new CannotCompileException("broken method");
        }
    }
    
    private void replace2(final String lllllllllllllIlIllIIlIIllllllIIl) throws CompileError, BadBytecode, NotFoundException, CannotCompileException {
        this.thisClass.getClassFile();
        final ConstPool lllllllllllllIlIllIIlIIllllllIII = this.getConstPool();
        final int lllllllllllllIlIllIIlIIlllllIlll = this.currentPos;
        int lllllllllllllIlIllIIlIIlllllIlII = 0;
        int lllllllllllllIlIllIIlIIlllllIIll = 1;
        if (this.opcode == 188) {
            lllllllllllllIlIllIIlIIlllllIlII = this.iterator.byteAt(this.currentPos + 1);
            final CtPrimitiveType lllllllllllllIlIllIIlIlIIIIIIIlI = (CtPrimitiveType)this.getPrimitiveType(lllllllllllllIlIllIIlIIlllllIlII);
            final String lllllllllllllIlIllIIlIlIIIIIIIII = String.valueOf(new StringBuilder().append("[").append(lllllllllllllIlIllIIlIlIIIIIIIlI.getDescriptor()));
            final int lllllllllllllIlIllIIlIlIIIIIIIIl = 2;
        }
        else if (this.opcode == 189) {
            lllllllllllllIlIllIIlIIlllllIlII = this.iterator.u16bitAt(lllllllllllllIlIllIIlIIlllllIlll + 1);
            String lllllllllllllIlIllIIlIIllllllllI = lllllllllllllIlIllIIlIIllllllIII.getClassInfo(lllllllllllllIlIllIIlIIlllllIlII);
            if (lllllllllllllIlIllIIlIIllllllllI.startsWith("[")) {
                lllllllllllllIlIllIIlIIllllllllI = String.valueOf(new StringBuilder().append("[").append(lllllllllllllIlIllIIlIIllllllllI));
            }
            else {
                lllllllllllllIlIllIIlIIllllllllI = String.valueOf(new StringBuilder().append("[L").append(lllllllllllllIlIllIIlIIllllllllI).append(";"));
            }
            final int lllllllllllllIlIllIIlIIlllllllll = 3;
        }
        else {
            if (this.opcode != 197) {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("bad opcode: ").append(this.opcode)));
            }
            lllllllllllllIlIllIIlIIlllllIlII = this.iterator.u16bitAt(this.currentPos + 1);
            final String lllllllllllllIlIllIIlIIlllllllII = lllllllllllllIlIllIIlIIllllllIII.getClassInfo(lllllllllllllIlIllIIlIIlllllIlII);
            lllllllllllllIlIllIIlIIlllllIIll = this.iterator.byteAt(this.currentPos + 3);
            final int lllllllllllllIlIllIIlIIlllllllIl = 4;
        }
        final String lllllllllllllIlIllIIlIIlllllIIlI;
        final CtClass lllllllllllllIlIllIIlIIlllllIllI = Descriptor.toCtClass(lllllllllllllIlIllIIlIIlllllIIlI, this.thisClass.getClassPool());
        final Javac lllllllllllllIlIllIIlIIlllllIIIl = new Javac(this.thisClass);
        final CodeAttribute lllllllllllllIlIllIIlIIlllllIIII = this.iterator.get();
        final CtClass[] lllllllllllllIlIllIIlIIllllIllll = new CtClass[lllllllllllllIlIllIIlIIlllllIIll];
        for (int lllllllllllllIlIllIIlIIllllllIll = 0; lllllllllllllIlIllIIlIIllllllIll < lllllllllllllIlIllIIlIIlllllIIll; ++lllllllllllllIlIllIIlIIllllllIll) {
            lllllllllllllIlIllIIlIIllllIllll[lllllllllllllIlIllIIlIIllllllIll] = CtClass.intType;
        }
        final int lllllllllllllIlIllIIlIIllllIlllI = lllllllllllllIlIllIIlIIlllllIIII.getMaxLocals();
        lllllllllllllIlIllIIlIIlllllIIIl.recordParams("java.lang.Object", lllllllllllllIlIllIIlIIllllIllll, true, lllllllllllllIlIllIIlIIllllIlllI, this.withinStatic());
        Expr.checkResultValue(lllllllllllllIlIllIIlIIlllllIllI, lllllllllllllIlIllIIlIIllllllIIl);
        final int lllllllllllllIlIllIIlIIllllIllIl = lllllllllllllIlIllIIlIIlllllIIIl.recordReturnType(lllllllllllllIlIllIIlIIlllllIllI, true);
        lllllllllllllIlIllIIlIIlllllIIIl.recordProceed(new ProceedForArray(lllllllllllllIlIllIIlIIlllllIllI, this.opcode, lllllllllllllIlIllIIlIIlllllIlII, lllllllllllllIlIllIIlIIlllllIIll));
        final Bytecode lllllllllllllIlIllIIlIIllllIllII = lllllllllllllIlIllIIlIIlllllIIIl.getBytecode();
        Expr.storeStack(lllllllllllllIlIllIIlIIllllIllll, true, lllllllllllllIlIllIIlIIllllIlllI, lllllllllllllIlIllIIlIIllllIllII);
        lllllllllllllIlIllIIlIIlllllIIIl.recordLocalVariables(lllllllllllllIlIllIIlIIlllllIIII, lllllllllllllIlIllIIlIIlllllIlll);
        lllllllllllllIlIllIIlIIllllIllII.addOpcode(1);
        lllllllllllllIlIllIIlIIllllIllII.addAstore(lllllllllllllIlIllIIlIIllllIllIl);
        lllllllllllllIlIllIIlIIlllllIIIl.compileStmnt(lllllllllllllIlIllIIlIIllllllIIl);
        lllllllllllllIlIllIIlIIllllIllII.addAload(lllllllllllllIlIllIIlIIllllIllIl);
        final int lllllllllllllIlIllIIlIIlllllIlIl;
        this.replace0(lllllllllllllIlIllIIlIIlllllIlll, lllllllllllllIlIllIIlIIllllIllII, lllllllllllllIlIllIIlIIlllllIlIl);
    }
    
    public int getDimension() {
        if (this.opcode == 188) {
            return 1;
        }
        if (this.opcode == 189 || this.opcode == 197) {
            final int lllllllllllllIlIllIIlIlIIIlIIlIl = this.iterator.u16bitAt(this.currentPos + 1);
            final String lllllllllllllIlIllIIlIlIIIlIIlII = this.getConstPool().getClassInfo(lllllllllllllIlIllIIlIlIIIlIIlIl);
            return Descriptor.arrayDimension(lllllllllllllIlIllIIlIlIIIlIIlII) + ((this.opcode == 189) ? 1 : 0);
        }
        throw new RuntimeException(String.valueOf(new StringBuilder().append("bad opcode: ").append(this.opcode)));
    }
    
    static class ProceedForArray implements ProceedHandler
    {
        /* synthetic */ CtClass arrayType;
        /* synthetic */ int index;
        /* synthetic */ int opcode;
        /* synthetic */ int dimension;
        
        ProceedForArray(final CtClass lllllllllllllIIlIIIlIIIIIIlIIIlI, final int lllllllllllllIIlIIIlIIIIIIIlllII, final int lllllllllllllIIlIIIlIIIIIIIllIll, final int lllllllllllllIIlIIIlIIIIIIIllIlI) {
            this.arrayType = lllllllllllllIIlIIIlIIIIIIlIIIlI;
            this.opcode = lllllllllllllIIlIIIlIIIIIIIlllII;
            this.index = lllllllllllllIIlIIIlIIIIIIIllIll;
            this.dimension = lllllllllllllIIlIIIlIIIIIIIllIlI;
        }
        
        @Override
        public void setReturnType(final JvstTypeChecker lllllllllllllIIlIIIlIIIIIIIIIlII, final ASTList lllllllllllllIIlIIIlIIIIIIIIIllI) throws CompileError {
            lllllllllllllIIlIIIlIIIIIIIIIlII.setType(this.arrayType);
        }
        
        @Override
        public void doit(final JvstCodeGen lllllllllllllIIlIIIlIIIIIIIIlllI, final Bytecode lllllllllllllIIlIIIlIIIIIIIlIIlI, final ASTList lllllllllllllIIlIIIlIIIIIIIIllII) throws CompileError {
            final int lllllllllllllIIlIIIlIIIIIIIlIIII = lllllllllllllIIlIIIlIIIIIIIIlllI.getMethodArgsLength(lllllllllllllIIlIIIlIIIIIIIIllII);
            if (lllllllllllllIIlIIIlIIIIIIIlIIII != this.dimension) {
                throw new CompileError("$proceed() with a wrong number of parameters");
            }
            lllllllllllllIIlIIIlIIIIIIIIlllI.atMethodArgs(lllllllllllllIIlIIIlIIIIIIIIllII, new int[lllllllllllllIIlIIIlIIIIIIIlIIII], new int[lllllllllllllIIlIIIlIIIIIIIlIIII], new String[lllllllllllllIIlIIIlIIIIIIIlIIII]);
            lllllllllllllIIlIIIlIIIIIIIlIIlI.addOpcode(this.opcode);
            if (this.opcode == 189) {
                lllllllllllllIIlIIIlIIIIIIIlIIlI.addIndex(this.index);
            }
            else if (this.opcode == 188) {
                lllllllllllllIIlIIIlIIIIIIIlIIlI.add(this.index);
            }
            else {
                lllllllllllllIIlIIIlIIIIIIIlIIlI.addIndex(this.index);
                lllllllllllllIIlIIIlIIIIIIIlIIlI.add(this.dimension);
                lllllllllllllIIlIIIlIIIIIIIlIIlI.growStack(1 - this.dimension);
            }
            lllllllllllllIIlIIIlIIIIIIIIlllI.setType(this.arrayType);
        }
    }
}
