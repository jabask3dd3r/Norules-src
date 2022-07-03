package com.viaversion.viaversion.libs.javassist.expr;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;

public class NewExpr extends Expr
{
    /* synthetic */ int newPos;
    /* synthetic */ String newTypeName;
    
    public String getClassName() {
        return this.newTypeName;
    }
    
    public CtConstructor getConstructor() throws NotFoundException {
        final ConstPool llllllllllllllIlIlIIIlIIlIIIlIIl = this.getConstPool();
        final int llllllllllllllIlIlIIIlIIlIIIlIII = this.iterator.u16bitAt(this.currentPos + 1);
        final String llllllllllllllIlIlIIIlIIlIIIIlll = llllllllllllllIlIlIIIlIIlIIIlIIl.getMethodrefType(llllllllllllllIlIlIIIlIIlIIIlIII);
        return this.getCtClass().getConstructor(llllllllllllllIlIlIIIlIIlIIIIlll);
    }
    
    @Override
    public String getFileName() {
        return super.getFileName();
    }
    
    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }
    
    private int canReplace() throws CannotCompileException {
        final int llllllllllllllIlIlIIIlIIIlllllII = this.iterator.byteAt(this.newPos + 3);
        if (llllllllllllllIlIlIIIlIIIlllllII == 89) {
            return (this.iterator.byteAt(this.newPos + 4) == 94 && this.iterator.byteAt(this.newPos + 5) == 88) ? 6 : 4;
        }
        if (llllllllllllllIlIlIIIlIIIlllllII == 90 && this.iterator.byteAt(this.newPos + 4) == 95) {
            return 5;
        }
        return 3;
    }
    
    protected NewExpr(final int llllllllllllllIlIlIIIlIIlIllIIll, final CodeIterator llllllllllllllIlIlIIIlIIlIllIIlI, final CtClass llllllllllllllIlIlIIIlIIlIlIlIlI, final MethodInfo llllllllllllllIlIlIIIlIIlIllIIII, final String llllllllllllllIlIlIIIlIIlIlIllll, final int llllllllllllllIlIlIIIlIIlIlIIlll) {
        super(llllllllllllllIlIlIIIlIIlIllIIll, llllllllllllllIlIlIIIlIIlIllIIlI, llllllllllllllIlIlIIIlIIlIlIlIlI, llllllllllllllIlIlIIIlIIlIllIIII);
        this.newTypeName = llllllllllllllIlIlIIIlIIlIlIllll;
        this.newPos = llllllllllllllIlIlIIIlIIlIlIIlll;
    }
    
    @Override
    public CtBehavior where() {
        return super.where();
    }
    
    public String getSignature() {
        final ConstPool llllllllllllllIlIlIIIlIIlIIlIIll = this.getConstPool();
        final int llllllllllllllIlIlIIIlIIlIIlIIlI = this.iterator.u16bitAt(this.currentPos + 1);
        return llllllllllllllIlIlIIIlIIlIIlIIll.getMethodrefType(llllllllllllllIlIlIIIlIIlIIlIIlI);
    }
    
    private CtClass getCtClass() throws NotFoundException {
        return this.thisClass.getClassPool().get(this.newTypeName);
    }
    
    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }
    
    @Override
    public void replace(final String llllllllllllllIlIlIIIlIIIlIlIIII) throws CannotCompileException {
        this.thisClass.getClassFile();
        final int llllllllllllllIlIlIIIlIIIlIlllII = 3;
        int llllllllllllllIlIlIIIlIIIlIllIll = this.newPos;
        final int llllllllllllllIlIlIIIlIIIlIllIlI = this.iterator.u16bitAt(llllllllllllllIlIlIIIlIIIlIllIll + 1);
        final int llllllllllllllIlIlIIIlIIIlIllIIl = this.canReplace();
        for (int llllllllllllllIlIlIIIlIIIlIllIII = llllllllllllllIlIlIIIlIIIlIllIll + llllllllllllllIlIlIIIlIIIlIllIIl, llllllllllllllIlIlIIIlIIIllIIlll = llllllllllllllIlIlIIIlIIIlIllIll; llllllllllllllIlIlIIIlIIIllIIlll < llllllllllllllIlIlIIIlIIIlIllIII; ++llllllllllllllIlIlIIIlIIIllIIlll) {
            this.iterator.writeByte(0, llllllllllllllIlIlIIIlIIIllIIlll);
        }
        final ConstPool llllllllllllllIlIlIIIlIIIlIlIlll = this.getConstPool();
        llllllllllllllIlIlIIIlIIIlIllIll = this.currentPos;
        final int llllllllllllllIlIlIIIlIIIlIlIllI = this.iterator.u16bitAt(llllllllllllllIlIlIIIlIIIlIllIll + 1);
        final String llllllllllllllIlIlIIIlIIIlIlIlIl = llllllllllllllIlIlIIIlIIIlIlIlll.getMethodrefType(llllllllllllllIlIlIIIlIIIlIlIllI);
        final Javac llllllllllllllIlIlIIIlIIIlIlIlII = new Javac(this.thisClass);
        final ClassPool llllllllllllllIlIlIIIlIIIlIlIIll = this.thisClass.getClassPool();
        final CodeAttribute llllllllllllllIlIlIIIlIIIlIlIIlI = this.iterator.get();
        try {
            final CtClass[] llllllllllllllIlIlIIIlIIIllIIllI = Descriptor.getParameterTypes(llllllllllllllIlIlIIIlIIIlIlIlIl, llllllllllllllIlIlIIIlIIIlIlIIll);
            final CtClass llllllllllllllIlIlIIIlIIIllIIlIl = llllllllllllllIlIlIIIlIIIlIlIIll.get(this.newTypeName);
            final int llllllllllllllIlIlIIIlIIIllIIlII = llllllllllllllIlIlIIIlIIIlIlIIlI.getMaxLocals();
            llllllllllllllIlIlIIIlIIIlIlIlII.recordParams(this.newTypeName, llllllllllllllIlIlIIIlIIIllIIllI, true, llllllllllllllIlIlIIIlIIIllIIlII, this.withinStatic());
            final int llllllllllllllIlIlIIIlIIIllIIIll = llllllllllllllIlIlIIIlIIIlIlIlII.recordReturnType(llllllllllllllIlIlIIIlIIIllIIlIl, true);
            llllllllllllllIlIlIIIlIIIlIlIlII.recordProceed(new ProceedForNew(llllllllllllllIlIlIIIlIIIllIIlIl, llllllllllllllIlIlIIIlIIIlIllIlI, llllllllllllllIlIlIIIlIIIlIlIllI));
            Expr.checkResultValue(llllllllllllllIlIlIIIlIIIllIIlIl, llllllllllllllIlIlIIIlIIIlIlIIII);
            final Bytecode llllllllllllllIlIlIIIlIIIllIIIlI = llllllllllllllIlIlIIIlIIIlIlIlII.getBytecode();
            Expr.storeStack(llllllllllllllIlIlIIIlIIIllIIllI, true, llllllllllllllIlIlIIIlIIIllIIlII, llllllllllllllIlIlIIIlIIIllIIIlI);
            llllllllllllllIlIlIIIlIIIlIlIlII.recordLocalVariables(llllllllllllllIlIlIIIlIIIlIlIIlI, llllllllllllllIlIlIIIlIIIlIllIll);
            llllllllllllllIlIlIIIlIIIllIIIlI.addConstZero(llllllllllllllIlIlIIIlIIIllIIlIl);
            llllllllllllllIlIlIIIlIIIllIIIlI.addStore(llllllllllllllIlIlIIIlIIIllIIIll, llllllllllllllIlIlIIIlIIIllIIlIl);
            llllllllllllllIlIlIIIlIIIlIlIlII.compileStmnt(llllllllllllllIlIlIIIlIIIlIlIIII);
            if (llllllllllllllIlIlIIIlIIIlIllIIl > 3) {
                llllllllllllllIlIlIIIlIIIllIIIlI.addAload(llllllllllllllIlIlIIIlIIIllIIIll);
            }
            this.replace0(llllllllllllllIlIlIIIlIIIlIllIll, llllllllllllllIlIlIIIlIIIllIIIlI, 3);
        }
        catch (CompileError llllllllllllllIlIlIIIlIIIllIIIIl) {
            throw new CannotCompileException(llllllllllllllIlIlIIIlIIIllIIIIl);
        }
        catch (NotFoundException llllllllllllllIlIlIIIlIIIllIIIII) {
            throw new CannotCompileException(llllllllllllllIlIlIIIlIIIllIIIII);
        }
        catch (BadBytecode llllllllllllllIlIlIIIlIIIlIlllll) {
            throw new CannotCompileException("broken method");
        }
    }
    
    static class ProceedForNew implements ProceedHandler
    {
        /* synthetic */ int methodIndex;
        /* synthetic */ int newIndex;
        /* synthetic */ CtClass newType;
        
        @Override
        public void setReturnType(final JvstTypeChecker lllllllllllllIIIIIlllIIlIIllIllI, final ASTList lllllllllllllIIIIIlllIIlIIllIlIl) throws CompileError {
            lllllllllllllIIIIIlllIIlIIllIllI.atMethodCallCore(this.newType, "<init>", lllllllllllllIIIIIlllIIlIIllIlIl);
            lllllllllllllIIIIIlllIIlIIllIllI.setType(this.newType);
        }
        
        @Override
        public void doit(final JvstCodeGen lllllllllllllIIIIIlllIIlIlIIIlII, final Bytecode lllllllllllllIIIIIlllIIlIlIIIIll, final ASTList lllllllllllllIIIIIlllIIlIIlllllI) throws CompileError {
            lllllllllllllIIIIIlllIIlIlIIIIll.addOpcode(187);
            lllllllllllllIIIIIlllIIlIlIIIIll.addIndex(this.newIndex);
            lllllllllllllIIIIIlllIIlIlIIIIll.addOpcode(89);
            lllllllllllllIIIIIlllIIlIlIIIlII.atMethodCallCore(this.newType, "<init>", lllllllllllllIIIIIlllIIlIIlllllI, false, true, -1, null);
            lllllllllllllIIIIIlllIIlIlIIIlII.setType(this.newType);
        }
        
        ProceedForNew(final CtClass lllllllllllllIIIIIlllIIlIlIlIIII, final int lllllllllllllIIIIIlllIIlIlIIllll, final int lllllllllllllIIIIIlllIIlIlIIlllI) {
            this.newType = lllllllllllllIIIIIlllIIlIlIlIIII;
            this.newIndex = lllllllllllllIIIIIlllIIlIlIIllll;
            this.methodIndex = lllllllllllllIIIIIlllIIlIlIIlllI;
        }
    }
}
