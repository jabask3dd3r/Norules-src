package com.viaversion.viaversion.libs.javassist.expr;

import com.viaversion.viaversion.libs.javassist.compiler.*;
import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class MethodCall extends Expr
{
    public boolean isSuper() {
        return this.iterator.byteAt(this.currentPos) == 183 && !this.where().getDeclaringClass().getName().equals(this.getClassName());
    }
    
    public String getSignature() {
        final ConstPool lllllllllllllIlIlIIlIllIIIlIllIl = this.getConstPool();
        final int lllllllllllllIlIlIIlIllIIIlIllII = this.getNameAndType(lllllllllllllIlIlIIlIllIIIlIllIl);
        return lllllllllllllIlIlIIlIllIIIlIllIl.getUtf8Info(lllllllllllllIlIlIIlIllIIIlIllIl.getNameAndTypeDescriptor(lllllllllllllIlIlIIlIllIIIlIllII));
    }
    
    public CtMethod getMethod() throws NotFoundException {
        return this.getCtClass().getMethod(this.getMethodName(), this.getSignature());
    }
    
    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }
    
    protected MethodCall(final int lllllllllllllIlIlIIlIllIIlllIlII, final CodeIterator lllllllllllllIlIlIIlIllIIlllIIll, final CtClass lllllllllllllIlIlIIlIllIIlllIIlI, final MethodInfo lllllllllllllIlIlIIlIllIIlllIIIl) {
        super(lllllllllllllIlIlIIlIllIIlllIlII, lllllllllllllIlIlIIlIllIIlllIIll, lllllllllllllIlIlIIlIllIIlllIIlI, lllllllllllllIlIlIIlIllIIlllIIIl);
    }
    
    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }
    
    @Override
    public String getFileName() {
        return super.getFileName();
    }
    
    protected CtClass getCtClass() throws NotFoundException {
        return this.thisClass.getClassPool().get(this.getClassName());
    }
    
    private int getNameAndType(final ConstPool lllllllllllllIlIlIIlIllIIllIIIII) {
        final int lllllllllllllIlIlIIlIllIIllIIlII = this.currentPos;
        final int lllllllllllllIlIlIIlIllIIllIIIll = this.iterator.byteAt(lllllllllllllIlIlIIlIllIIllIIlII);
        final int lllllllllllllIlIlIIlIllIIllIIIlI = this.iterator.u16bitAt(lllllllllllllIlIlIIlIllIIllIIlII + 1);
        if (lllllllllllllIlIlIIlIllIIllIIIll == 185) {
            return lllllllllllllIlIlIIlIllIIllIIIII.getInterfaceMethodrefNameAndType(lllllllllllllIlIlIIlIllIIllIIIlI);
        }
        return lllllllllllllIlIlIIlIllIIllIIIII.getMethodrefNameAndType(lllllllllllllIlIlIIlIllIIllIIIlI);
    }
    
    public String getClassName() {
        final ConstPool lllllllllllllIlIlIIlIllIIlIIIlll = this.getConstPool();
        final int lllllllllllllIlIlIIlIllIIlIIIllI = this.currentPos;
        final int lllllllllllllIlIlIIlIllIIlIIIlIl = this.iterator.byteAt(lllllllllllllIlIlIIlIllIIlIIIllI);
        final int lllllllllllllIlIlIIlIllIIlIIIlII = this.iterator.u16bitAt(lllllllllllllIlIlIIlIllIIlIIIllI + 1);
        String lllllllllllllIlIlIIlIllIIlIIlIII = null;
        if (lllllllllllllIlIlIIlIllIIlIIIlIl == 185) {
            final String lllllllllllllIlIlIIlIllIIlIIlIlI = lllllllllllllIlIlIIlIllIIlIIIlll.getInterfaceMethodrefClassName(lllllllllllllIlIlIIlIllIIlIIIlII);
        }
        else {
            lllllllllllllIlIlIIlIllIIlIIlIII = lllllllllllllIlIlIIlIllIIlIIIlll.getMethodrefClassName(lllllllllllllIlIlIIlIllIIlIIIlII);
        }
        if (lllllllllllllIlIlIIlIllIIlIIlIII.charAt(0) == '[') {
            lllllllllllllIlIlIIlIllIIlIIlIII = Descriptor.toClassName(lllllllllllllIlIlIIlIllIIlIIlIII);
        }
        return lllllllllllllIlIlIIlIllIIlIIlIII;
    }
    
    @Override
    public CtBehavior where() {
        return super.where();
    }
    
    @Override
    public void replace(final String lllllllllllllIlIlIIlIlIlllllIIlI) throws CannotCompileException {
        this.thisClass.getClassFile();
        final ConstPool lllllllllllllIlIlIIlIlIllllllllI = this.getConstPool();
        final int lllllllllllllIlIlIIlIlIlllllllIl = this.currentPos;
        final int lllllllllllllIlIlIIlIlIlllllllII = this.iterator.u16bitAt(lllllllllllllIlIlIIlIlIlllllllIl + 1);
        final int lllllllllllllIlIlIIlIlIlllllIlll = this.iterator.byteAt(lllllllllllllIlIlIIlIlIlllllllIl);
        if (lllllllllllllIlIlIIlIlIlllllIlll == 185) {
            final int lllllllllllllIlIlIIlIllIIIIIllIl = 5;
            final String lllllllllllllIlIlIIlIllIIIIlIIII = lllllllllllllIlIlIIlIlIllllllllI.getInterfaceMethodrefClassName(lllllllllllllIlIlIIlIlIlllllllII);
            final String lllllllllllllIlIlIIlIllIIIIIllll = lllllllllllllIlIlIIlIlIllllllllI.getInterfaceMethodrefName(lllllllllllllIlIlIIlIlIlllllllII);
            final String lllllllllllllIlIlIIlIllIIIIIlllI = lllllllllllllIlIlIIlIlIllllllllI.getInterfaceMethodrefType(lllllllllllllIlIlIIlIlIlllllllII);
        }
        else {
            if (lllllllllllllIlIlIIlIlIlllllIlll != 184 && lllllllllllllIlIlIIlIlIlllllIlll != 183 && lllllllllllllIlIlIIlIlIlllllIlll != 182) {
                throw new CannotCompileException("not method invocation");
            }
            final int lllllllllllllIlIlIIlIllIIIIIlIIl = 3;
            final String lllllllllllllIlIlIIlIllIIIIIllII = lllllllllllllIlIlIIlIlIllllllllI.getMethodrefClassName(lllllllllllllIlIlIIlIlIlllllllII);
            final String lllllllllllllIlIlIIlIllIIIIIlIll = lllllllllllllIlIlIIlIlIllllllllI.getMethodrefName(lllllllllllllIlIlIIlIlIlllllllII);
            final String lllllllllllllIlIlIIlIllIIIIIlIlI = lllllllllllllIlIlIIlIlIllllllllI.getMethodrefType(lllllllllllllIlIlIIlIlIlllllllII);
        }
        final Javac lllllllllllllIlIlIIlIlIlllllIllI = new Javac(this.thisClass);
        final ClassPool lllllllllllllIlIlIIlIlIlllllIlIl = this.thisClass.getClassPool();
        final CodeAttribute lllllllllllllIlIlIIlIlIlllllIlII = this.iterator.get();
        try {
            final String lllllllllllllIlIlIIlIlIllllllIIl;
            final CtClass[] lllllllllllllIlIlIIlIllIIIIIlIII = Descriptor.getParameterTypes(lllllllllllllIlIlIIlIlIllllllIIl, lllllllllllllIlIlIIlIlIlllllIlIl);
            final CtClass lllllllllllllIlIlIIlIllIIIIIIlll = Descriptor.getReturnType(lllllllllllllIlIlIIlIlIllllllIIl, lllllllllllllIlIlIIlIlIlllllIlIl);
            final int lllllllllllllIlIlIIlIllIIIIIIllI = lllllllllllllIlIlIIlIlIlllllIlII.getMaxLocals();
            final String lllllllllllllIlIlIIlIlIllllllIll;
            lllllllllllllIlIlIIlIlIlllllIllI.recordParams(lllllllllllllIlIlIIlIlIllllllIll, lllllllllllllIlIlIIlIllIIIIIlIII, true, lllllllllllllIlIlIIlIllIIIIIIllI, this.withinStatic());
            final int lllllllllllllIlIlIIlIllIIIIIIlIl = lllllllllllllIlIlIIlIlIlllllIllI.recordReturnType(lllllllllllllIlIlIIlIllIIIIIIlll, true);
            if (lllllllllllllIlIlIIlIlIlllllIlll == 184) {
                final String lllllllllllllIlIlIIlIlIllllllIlI;
                lllllllllllllIlIlIIlIlIlllllIllI.recordStaticProceed(lllllllllllllIlIlIIlIlIllllllIll, lllllllllllllIlIlIIlIlIllllllIlI);
            }
            else if (lllllllllllllIlIlIIlIlIlllllIlll == 183) {
                final String lllllllllllllIlIlIIlIlIllllllIlI;
                lllllllllllllIlIlIIlIlIlllllIllI.recordSpecialProceed("$0", lllllllllllllIlIlIIlIlIllllllIll, lllllllllllllIlIlIIlIlIllllllIlI, lllllllllllllIlIlIIlIlIllllllIIl, lllllllllllllIlIlIIlIlIlllllllII);
            }
            else {
                final String lllllllllllllIlIlIIlIlIllllllIlI;
                lllllllllllllIlIlIIlIlIlllllIllI.recordProceed("$0", lllllllllllllIlIlIIlIlIllllllIlI);
            }
            Expr.checkResultValue(lllllllllllllIlIlIIlIllIIIIIIlll, lllllllllllllIlIlIIlIlIlllllIIlI);
            final Bytecode lllllllllllllIlIlIIlIllIIIIIIlII = lllllllllllllIlIlIIlIlIlllllIllI.getBytecode();
            Expr.storeStack(lllllllllllllIlIlIIlIllIIIIIlIII, lllllllllllllIlIlIIlIlIlllllIlll == 184, lllllllllllllIlIlIIlIllIIIIIIllI, lllllllllllllIlIlIIlIllIIIIIIlII);
            lllllllllllllIlIlIIlIlIlllllIllI.recordLocalVariables(lllllllllllllIlIlIIlIlIlllllIlII, lllllllllllllIlIlIIlIlIlllllllIl);
            if (lllllllllllllIlIlIIlIllIIIIIIlll != CtClass.voidType) {
                lllllllllllllIlIlIIlIllIIIIIIlII.addConstZero(lllllllllllllIlIlIIlIllIIIIIIlll);
                lllllllllllllIlIlIIlIllIIIIIIlII.addStore(lllllllllllllIlIlIIlIllIIIIIIlIl, lllllllllllllIlIlIIlIllIIIIIIlll);
            }
            lllllllllllllIlIlIIlIlIlllllIllI.compileStmnt(lllllllllllllIlIlIIlIlIlllllIIlI);
            if (lllllllllllllIlIlIIlIllIIIIIIlll != CtClass.voidType) {
                lllllllllllllIlIlIIlIllIIIIIIlII.addLoad(lllllllllllllIlIlIIlIllIIIIIIlIl, lllllllllllllIlIlIIlIllIIIIIIlll);
            }
            final int lllllllllllllIlIlIIlIlIllllllIII;
            this.replace0(lllllllllllllIlIlIIlIlIlllllllIl, lllllllllllllIlIlIIlIllIIIIIIlII, lllllllllllllIlIlIIlIlIllllllIII);
        }
        catch (CompileError lllllllllllllIlIlIIlIllIIIIIIIll) {
            throw new CannotCompileException(lllllllllllllIlIlIIlIllIIIIIIIll);
        }
        catch (NotFoundException lllllllllllllIlIlIIlIllIIIIIIIlI) {
            throw new CannotCompileException(lllllllllllllIlIlIIlIllIIIIIIIlI);
        }
        catch (BadBytecode lllllllllllllIlIlIIlIllIIIIIIIIl) {
            throw new CannotCompileException("broken method");
        }
    }
    
    public String getMethodName() {
        final ConstPool lllllllllllllIlIlIIlIllIIIlllIIl = this.getConstPool();
        final int lllllllllllllIlIlIIlIllIIIlllIII = this.getNameAndType(lllllllllllllIlIlIIlIllIIIlllIIl);
        return lllllllllllllIlIlIIlIllIIIlllIIl.getUtf8Info(lllllllllllllIlIlIIlIllIIIlllIIl.getNameAndTypeName(lllllllllllllIlIlIIlIllIIIlllIII));
    }
}
