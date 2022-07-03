package com.viaversion.viaversion.libs.javassist.expr;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Instanceof extends Expr
{
    @Override
    public void replace(final String llllllllllllllIlIIlIIIIIlIIlIIll) throws CannotCompileException {
        this.thisClass.getClassFile();
        final ConstPool llllllllllllllIlIIlIIIIIlIIlIIlI = this.getConstPool();
        final int llllllllllllllIlIIlIIIIIlIIlIIIl = this.currentPos;
        final int llllllllllllllIlIIlIIIIIlIIlIIII = this.iterator.u16bitAt(llllllllllllllIlIIlIIIIIlIIlIIIl + 1);
        final Javac llllllllllllllIlIIlIIIIIlIIIllll = new Javac(this.thisClass);
        final ClassPool llllllllllllllIlIIlIIIIIlIIIlllI = this.thisClass.getClassPool();
        final CodeAttribute llllllllllllllIlIIlIIIIIlIIIllIl = this.iterator.get();
        try {
            final CtClass[] llllllllllllllIlIIlIIIIIlIIlllII = { llllllllllllllIlIIlIIIIIlIIIlllI.get("java.lang.Object") };
            final CtClass llllllllllllllIlIIlIIIIIlIIllIll = CtClass.booleanType;
            final int llllllllllllllIlIIlIIIIIlIIllIlI = llllllllllllllIlIIlIIIIIlIIIllIl.getMaxLocals();
            llllllllllllllIlIIlIIIIIlIIIllll.recordParams("java.lang.Object", llllllllllllllIlIIlIIIIIlIIlllII, true, llllllllllllllIlIIlIIIIIlIIllIlI, this.withinStatic());
            final int llllllllllllllIlIIlIIIIIlIIllIIl = llllllllllllllIlIIlIIIIIlIIIllll.recordReturnType(llllllllllllllIlIIlIIIIIlIIllIll, true);
            llllllllllllllIlIIlIIIIIlIIIllll.recordProceed(new ProceedForInstanceof(llllllllllllllIlIIlIIIIIlIIlIIII));
            llllllllllllllIlIIlIIIIIlIIIllll.recordType(this.getType());
            Expr.checkResultValue(llllllllllllllIlIIlIIIIIlIIllIll, llllllllllllllIlIIlIIIIIlIIlIIll);
            final Bytecode llllllllllllllIlIIlIIIIIlIIllIII = llllllllllllllIlIIlIIIIIlIIIllll.getBytecode();
            Expr.storeStack(llllllllllllllIlIIlIIIIIlIIlllII, true, llllllllllllllIlIIlIIIIIlIIllIlI, llllllllllllllIlIIlIIIIIlIIllIII);
            llllllllllllllIlIIlIIIIIlIIIllll.recordLocalVariables(llllllllllllllIlIIlIIIIIlIIIllIl, llllllllllllllIlIIlIIIIIlIIlIIIl);
            llllllllllllllIlIIlIIIIIlIIllIII.addConstZero(llllllllllllllIlIIlIIIIIlIIllIll);
            llllllllllllllIlIIlIIIIIlIIllIII.addStore(llllllllllllllIlIIlIIIIIlIIllIIl, llllllllllllllIlIIlIIIIIlIIllIll);
            llllllllllllllIlIIlIIIIIlIIIllll.compileStmnt(llllllllllllllIlIIlIIIIIlIIlIIll);
            llllllllllllllIlIIlIIIIIlIIllIII.addLoad(llllllllllllllIlIIlIIIIIlIIllIIl, llllllllllllllIlIIlIIIIIlIIllIll);
            this.replace0(llllllllllllllIlIIlIIIIIlIIlIIIl, llllllllllllllIlIIlIIIIIlIIllIII, 3);
        }
        catch (CompileError llllllllllllllIlIIlIIIIIlIIlIlll) {
            throw new CannotCompileException(llllllllllllllIlIIlIIIIIlIIlIlll);
        }
        catch (NotFoundException llllllllllllllIlIIlIIIIIlIIlIllI) {
            throw new CannotCompileException(llllllllllllllIlIIlIIIIIlIIlIllI);
        }
        catch (BadBytecode llllllllllllllIlIIlIIIIIlIIlIlIl) {
            throw new CannotCompileException("broken method");
        }
    }
    
    protected Instanceof(final int llllllllllllllIlIIlIIIIIllIIlIII, final CodeIterator llllllllllllllIlIIlIIIIIllIIIlll, final CtClass llllllllllllllIlIIlIIIIIllIIIllI, final MethodInfo llllllllllllllIlIIlIIIIIllIIlIlI) {
        super(llllllllllllllIlIIlIIIIIllIIlIII, llllllllllllllIlIIlIIIIIllIIIlll, llllllllllllllIlIIlIIIIIllIIIllI, llllllllllllllIlIIlIIIIIllIIlIlI);
    }
    
    @Override
    public CtBehavior where() {
        return super.where();
    }
    
    public CtClass getType() throws NotFoundException {
        final ConstPool llllllllllllllIlIIlIIIIIlIllIlIl = this.getConstPool();
        final int llllllllllllllIlIIlIIIIIlIllIlII = this.currentPos;
        final int llllllllllllllIlIIlIIIIIlIllIIll = this.iterator.u16bitAt(llllllllllllllIlIIlIIIIIlIllIlII + 1);
        final String llllllllllllllIlIIlIIIIIlIllIIlI = llllllllllllllIlIIlIIIIIlIllIlIl.getClassInfo(llllllllllllllIlIIlIIIIIlIllIIll);
        return this.thisClass.getClassPool().getCtClass(llllllllllllllIlIIlIIIIIlIllIIlI);
    }
    
    @Override
    public String getFileName() {
        return super.getFileName();
    }
    
    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }
    
    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }
    
    static class ProceedForInstanceof implements ProceedHandler
    {
        /* synthetic */ int index;
        
        @Override
        public void setReturnType(final JvstTypeChecker lllllllllllllIIIlIIIlIlllIIIllll, final ASTList lllllllllllllIIIlIIIlIlllIIIlllI) throws CompileError {
            lllllllllllllIIIlIIIlIlllIIIllll.atMethodArgs(lllllllllllllIIIlIIIlIlllIIIlllI, new int[1], new int[1], new String[1]);
            lllllllllllllIIIlIIIlIlllIIIllll.setType(CtClass.booleanType);
        }
        
        @Override
        public void doit(final JvstCodeGen lllllllllllllIIIlIIIlIlllIIllIIl, final Bytecode lllllllllllllIIIlIIIlIlllIIllIII, final ASTList lllllllllllllIIIlIIIlIlllIIlIlll) throws CompileError {
            if (lllllllllllllIIIlIIIlIlllIIllIIl.getMethodArgsLength(lllllllllllllIIIlIIIlIlllIIlIlll) != 1) {
                throw new CompileError("$proceed() cannot take more than one parameter for instanceof");
            }
            lllllllllllllIIIlIIIlIlllIIllIIl.atMethodArgs(lllllllllllllIIIlIIIlIlllIIlIlll, new int[1], new int[1], new String[1]);
            lllllllllllllIIIlIIIlIlllIIllIII.addOpcode(193);
            lllllllllllllIIIlIIIlIlllIIllIII.addIndex(this.index);
            lllllllllllllIIIlIIIlIlllIIllIIl.setType(CtClass.booleanType);
        }
        
        ProceedForInstanceof(final int lllllllllllllIIIlIIIlIlllIlIIIIl) {
            this.index = lllllllllllllIIIlIIIlIlllIlIIIIl;
        }
    }
}
