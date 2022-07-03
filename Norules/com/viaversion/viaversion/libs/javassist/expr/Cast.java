package com.viaversion.viaversion.libs.javassist.expr;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Cast extends Expr
{
    public CtClass getType() throws NotFoundException {
        final ConstPool llllllllllllllllIIIIllIIlIllIIIl = this.getConstPool();
        final int llllllllllllllllIIIIllIIlIllIIII = this.currentPos;
        final int llllllllllllllllIIIIllIIlIlIllll = this.iterator.u16bitAt(llllllllllllllllIIIIllIIlIllIIII + 1);
        final String llllllllllllllllIIIIllIIlIlIlllI = llllllllllllllllIIIIllIIlIllIIIl.getClassInfo(llllllllllllllllIIIIllIIlIlIllll);
        return this.thisClass.getClassPool().getCtClass(llllllllllllllllIIIIllIIlIlIlllI);
    }
    
    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }
    
    protected Cast(final int llllllllllllllllIIIIllIIllIIIlII, final CodeIterator llllllllllllllllIIIIllIIllIIlIII, final CtClass llllllllllllllllIIIIllIIllIIIlll, final MethodInfo llllllllllllllllIIIIllIIllIIIllI) {
        super(llllllllllllllllIIIIllIIllIIIlII, llllllllllllllllIIIIllIIllIIlIII, llllllllllllllllIIIIllIIllIIIlll, llllllllllllllllIIIIllIIllIIIllI);
    }
    
    @Override
    public CtBehavior where() {
        return super.where();
    }
    
    @Override
    public void replace(final String llllllllllllllllIIIIllIIlIIIllll) throws CannotCompileException {
        this.thisClass.getClassFile();
        final ConstPool llllllllllllllllIIIIllIIlIIIlllI = this.getConstPool();
        final int llllllllllllllllIIIIllIIlIIIllIl = this.currentPos;
        final int llllllllllllllllIIIIllIIlIIIllII = this.iterator.u16bitAt(llllllllllllllllIIIIllIIlIIIllIl + 1);
        final Javac llllllllllllllllIIIIllIIlIIIlIll = new Javac(this.thisClass);
        final ClassPool llllllllllllllllIIIIllIIlIIIlIlI = this.thisClass.getClassPool();
        final CodeAttribute llllllllllllllllIIIIllIIlIIIlIIl = this.iterator.get();
        try {
            final CtClass[] llllllllllllllllIIIIllIIlIIllIII = { llllllllllllllllIIIIllIIlIIIlIlI.get("java.lang.Object") };
            final CtClass llllllllllllllllIIIIllIIlIIlIlll = this.getType();
            final int llllllllllllllllIIIIllIIlIIlIllI = llllllllllllllllIIIIllIIlIIIlIIl.getMaxLocals();
            llllllllllllllllIIIIllIIlIIIlIll.recordParams("java.lang.Object", llllllllllllllllIIIIllIIlIIllIII, true, llllllllllllllllIIIIllIIlIIlIllI, this.withinStatic());
            final int llllllllllllllllIIIIllIIlIIlIlIl = llllllllllllllllIIIIllIIlIIIlIll.recordReturnType(llllllllllllllllIIIIllIIlIIlIlll, true);
            llllllllllllllllIIIIllIIlIIIlIll.recordProceed(new ProceedForCast(llllllllllllllllIIIIllIIlIIIllII, llllllllllllllllIIIIllIIlIIlIlll));
            Expr.checkResultValue(llllllllllllllllIIIIllIIlIIlIlll, llllllllllllllllIIIIllIIlIIIllll);
            final Bytecode llllllllllllllllIIIIllIIlIIlIlII = llllllllllllllllIIIIllIIlIIIlIll.getBytecode();
            Expr.storeStack(llllllllllllllllIIIIllIIlIIllIII, true, llllllllllllllllIIIIllIIlIIlIllI, llllllllllllllllIIIIllIIlIIlIlII);
            llllllllllllllllIIIIllIIlIIIlIll.recordLocalVariables(llllllllllllllllIIIIllIIlIIIlIIl, llllllllllllllllIIIIllIIlIIIllIl);
            llllllllllllllllIIIIllIIlIIlIlII.addConstZero(llllllllllllllllIIIIllIIlIIlIlll);
            llllllllllllllllIIIIllIIlIIlIlII.addStore(llllllllllllllllIIIIllIIlIIlIlIl, llllllllllllllllIIIIllIIlIIlIlll);
            llllllllllllllllIIIIllIIlIIIlIll.compileStmnt(llllllllllllllllIIIIllIIlIIIllll);
            llllllllllllllllIIIIllIIlIIlIlII.addLoad(llllllllllllllllIIIIllIIlIIlIlIl, llllllllllllllllIIIIllIIlIIlIlll);
            this.replace0(llllllllllllllllIIIIllIIlIIIllIl, llllllllllllllllIIIIllIIlIIlIlII, 3);
        }
        catch (CompileError llllllllllllllllIIIIllIIlIIlIIll) {
            throw new CannotCompileException(llllllllllllllllIIIIllIIlIIlIIll);
        }
        catch (NotFoundException llllllllllllllllIIIIllIIlIIlIIlI) {
            throw new CannotCompileException(llllllllllllllllIIIIllIIlIIlIIlI);
        }
        catch (BadBytecode llllllllllllllllIIIIllIIlIIlIIIl) {
            throw new CannotCompileException("broken method");
        }
    }
    
    @Override
    public String getFileName() {
        return super.getFileName();
    }
    
    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }
    
    static class ProceedForCast implements ProceedHandler
    {
        /* synthetic */ int index;
        /* synthetic */ CtClass retType;
        
        @Override
        public void doit(final JvstCodeGen lllllllllllllIlIlIIIIIlIIIIIIIlI, final Bytecode lllllllllllllIlIlIIIIIlIIIIIIlIl, final ASTList lllllllllllllIlIlIIIIIlIIIIIIIII) throws CompileError {
            if (lllllllllllllIlIlIIIIIlIIIIIIIlI.getMethodArgsLength(lllllllllllllIlIlIIIIIlIIIIIIIII) != 1) {
                throw new CompileError("$proceed() cannot take more than one parameter for cast");
            }
            lllllllllllllIlIlIIIIIlIIIIIIIlI.atMethodArgs(lllllllllllllIlIlIIIIIlIIIIIIIII, new int[1], new int[1], new String[1]);
            lllllllllllllIlIlIIIIIlIIIIIIlIl.addOpcode(192);
            lllllllllllllIlIlIIIIIlIIIIIIlIl.addIndex(this.index);
            lllllllllllllIlIlIIIIIlIIIIIIIlI.setType(this.retType);
        }
        
        ProceedForCast(final int lllllllllllllIlIlIIIIIlIIIIIllIl, final CtClass lllllllllllllIlIlIIIIIlIIIIIllII) {
            this.index = lllllllllllllIlIlIIIIIlIIIIIllIl;
            this.retType = lllllllllllllIlIlIIIIIlIIIIIllII;
        }
        
        @Override
        public void setReturnType(final JvstTypeChecker lllllllllllllIlIlIIIIIIllllllIll, final ASTList lllllllllllllIlIlIIIIIIlllllIlll) throws CompileError {
            lllllllllllllIlIlIIIIIIllllllIll.atMethodArgs(lllllllllllllIlIlIIIIIIlllllIlll, new int[1], new int[1], new String[1]);
            lllllllllllllIlIlIIIIIIllllllIll.setType(this.retType);
        }
    }
}
