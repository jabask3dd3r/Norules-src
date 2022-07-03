package com.viaversion.viaversion.libs.javassist.expr;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class Handler extends Expr
{
    private static /* synthetic */ String EXCEPTION_NAME;
    private /* synthetic */ ExceptionTable etable;
    private /* synthetic */ int index;
    
    public CtClass getType() throws NotFoundException {
        final int lllllllllllllllIlIlIIlIllllllIIl = this.etable.catchType(this.index);
        if (lllllllllllllllIlIlIIlIllllllIIl == 0) {
            return null;
        }
        final ConstPool lllllllllllllllIlIlIIlIllllllIII = this.getConstPool();
        final String lllllllllllllllIlIlIIlIlllllIlll = lllllllllllllllIlIlIIlIllllllIII.getClassInfo(lllllllllllllllIlIlIIlIllllllIIl);
        return this.thisClass.getClassPool().getCtClass(lllllllllllllllIlIlIIlIlllllIlll);
    }
    
    @Override
    public String getFileName() {
        return super.getFileName();
    }
    
    public boolean isFinally() {
        return this.etable.catchType(this.index) == 0;
    }
    
    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }
    
    static {
        Handler.EXCEPTION_NAME = "$1";
    }
    
    protected Handler(final ExceptionTable lllllllllllllllIlIlIIllIIIIlIlIl, final int lllllllllllllllIlIlIIllIIIIIlllI, final CodeIterator lllllllllllllllIlIlIIllIIIIIllIl, final CtClass lllllllllllllllIlIlIIllIIIIIllII, final MethodInfo lllllllllllllllIlIlIIllIIIIIlIll) {
        super(lllllllllllllllIlIlIIllIIIIlIlIl.handlerPc(lllllllllllllllIlIlIIllIIIIIlllI), lllllllllllllllIlIlIIllIIIIIllIl, lllllllllllllllIlIlIIllIIIIIllII, lllllllllllllllIlIlIIllIIIIIlIll);
        this.etable = lllllllllllllllIlIlIIllIIIIlIlIl;
        this.index = lllllllllllllllIlIlIIllIIIIIlllI;
    }
    
    @Override
    public CtBehavior where() {
        return super.where();
    }
    
    public void insertBefore(final String lllllllllllllllIlIlIIlIlllIlIllI) throws CannotCompileException {
        this.edited = true;
        final ConstPool lllllllllllllllIlIlIIlIlllIllIll = this.getConstPool();
        final CodeAttribute lllllllllllllllIlIlIIlIlllIllIlI = this.iterator.get();
        final Javac lllllllllllllllIlIlIIlIlllIllIIl = new Javac(this.thisClass);
        final Bytecode lllllllllllllllIlIlIIlIlllIllIII = lllllllllllllllIlIlIIlIlllIllIIl.getBytecode();
        lllllllllllllllIlIlIIlIlllIllIII.setStackDepth(1);
        lllllllllllllllIlIlIIlIlllIllIII.setMaxLocals(lllllllllllllllIlIlIIlIlllIllIlI.getMaxLocals());
        try {
            final CtClass lllllllllllllllIlIlIIlIllllIIIll = this.getType();
            final int lllllllllllllllIlIlIIlIllllIIIlI = lllllllllllllllIlIlIIlIlllIllIIl.recordVariable(lllllllllllllllIlIlIIlIllllIIIll, Handler.EXCEPTION_NAME);
            lllllllllllllllIlIlIIlIlllIllIIl.recordReturnType(lllllllllllllllIlIlIIlIllllIIIll, false);
            lllllllllllllllIlIlIIlIlllIllIII.addAstore(lllllllllllllllIlIlIIlIllllIIIlI);
            lllllllllllllllIlIlIIlIlllIllIIl.compileStmnt(lllllllllllllllIlIlIIlIlllIlIllI);
            lllllllllllllllIlIlIIlIlllIllIII.addAload(lllllllllllllllIlIlIIlIllllIIIlI);
            final int lllllllllllllllIlIlIIlIllllIIIIl = this.etable.handlerPc(this.index);
            lllllllllllllllIlIlIIlIlllIllIII.addOpcode(167);
            lllllllllllllllIlIlIIlIlllIllIII.addIndex(lllllllllllllllIlIlIIlIllllIIIIl - this.iterator.getCodeLength() - lllllllllllllllIlIlIIlIlllIllIII.currentPc() + 1);
            this.maxStack = lllllllllllllllIlIlIIlIlllIllIII.getMaxStack();
            this.maxLocals = lllllllllllllllIlIlIIlIlllIllIII.getMaxLocals();
            final int lllllllllllllllIlIlIIlIllllIIIII = this.iterator.append(lllllllllllllllIlIlIIlIlllIllIII.get());
            this.iterator.append(lllllllllllllllIlIlIIlIlllIllIII.getExceptionTable(), lllllllllllllllIlIlIIlIllllIIIII);
            this.etable.setHandlerPc(this.index, lllllllllllllllIlIlIIlIllllIIIII);
        }
        catch (NotFoundException lllllllllllllllIlIlIIlIlllIlllll) {
            throw new CannotCompileException(lllllllllllllllIlIlIIlIlllIlllll);
        }
        catch (CompileError lllllllllllllllIlIlIIlIlllIllllI) {
            throw new CannotCompileException(lllllllllllllllIlIlIIlIlllIllllI);
        }
    }
    
    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }
    
    @Override
    public void replace(final String lllllllllllllllIlIlIIlIllllIlllI) throws CannotCompileException {
        throw new RuntimeException("not implemented yet");
    }
}
