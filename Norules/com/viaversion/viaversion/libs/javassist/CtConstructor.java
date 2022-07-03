package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.compiler.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public final class CtConstructor extends CtBehavior
{
    public boolean isClassInitializer() {
        return this.methodInfo.isStaticInitializer();
    }
    
    public CtConstructor(final CtConstructor llllllllllllllIlIllIlIllIIIllIlI, final CtClass llllllllllllllIlIllIlIllIIIllIIl, final ClassMap llllllllllllllIlIllIlIllIIIllIII) throws CannotCompileException {
        this((MethodInfo)null, llllllllllllllIlIllIlIllIIIllIIl);
        this.copy(llllllllllllllIlIllIlIllIIIllIlI, true, llllllllllllllIlIllIlIllIIIllIII);
    }
    
    protected CtConstructor(final MethodInfo llllllllllllllIlIllIlIllIIllIIll, final CtClass llllllllllllllIlIllIlIllIIllIIlI) {
        super(llllllllllllllIlIllIlIllIIllIIlI, llllllllllllllIlIllIlIllIIllIIll);
    }
    
    @Override
    public void setBody(String llllllllllllllIlIllIlIlIllIllIlI) throws CannotCompileException {
        if (llllllllllllllIlIllIlIlIllIllIlI == null) {
            if (this.isClassInitializer()) {
                llllllllllllllIlIllIlIlIllIllIlI = ";";
            }
            else {
                llllllllllllllIlIllIlIlIllIllIlI = "super();";
            }
        }
        super.setBody(llllllllllllllIlIllIlIlIllIllIlI);
    }
    
    @Override
    int getStartPosOfBody(final CodeAttribute llllllllllllllIlIllIlIlIlIlIlllI) throws CannotCompileException {
        final CodeIterator llllllllllllllIlIllIlIlIlIlIllll = llllllllllllllIlIllIlIlIlIlIlllI.iterator();
        try {
            llllllllllllllIlIllIlIlIlIlIllll.skipConstructor();
            return llllllllllllllIlIllIlIlIlIlIllll.next();
        }
        catch (BadBytecode llllllllllllllIlIllIlIlIlIllIIlI) {
            throw new CannotCompileException(llllllllllllllIlIllIlIlIlIllIIlI);
        }
    }
    
    public CtMethod toMethod(final String llllllllllllllIlIllIlIlIlIIlIIIl, final CtClass llllllllllllllIlIllIlIlIlIIlIIII, final ClassMap llllllllllllllIlIllIlIlIlIIlIlII) throws CannotCompileException {
        final CtMethod llllllllllllllIlIllIlIlIlIIlIIll = new CtMethod(null, llllllllllllllIlIllIlIlIlIIlIIII);
        llllllllllllllIlIllIlIlIlIIlIIll.copy(this, false, llllllllllllllIlIllIlIlIlIIlIlII);
        if (this.isConstructor()) {
            final MethodInfo llllllllllllllIlIllIlIlIlIIllIIl = llllllllllllllIlIllIlIlIlIIlIIll.getMethodInfo2();
            final CodeAttribute llllllllllllllIlIllIlIlIlIIllIII = llllllllllllllIlIllIlIlIlIIllIIl.getCodeAttribute();
            if (llllllllllllllIlIllIlIlIlIIllIII != null) {
                removeConsCall(llllllllllllllIlIllIlIlIlIIllIII);
                try {
                    this.methodInfo.rebuildStackMapIf6(llllllllllllllIlIllIlIlIlIIlIIII.getClassPool(), llllllllllllllIlIllIlIlIlIIlIIII.getClassFile2());
                }
                catch (BadBytecode llllllllllllllIlIllIlIlIlIIllIlI) {
                    throw new CannotCompileException(llllllllllllllIlIllIlIlIlIIllIlI);
                }
            }
        }
        llllllllllllllIlIllIlIlIlIIlIIll.setName(llllllllllllllIlIllIlIlIlIIlIIIl);
        return llllllllllllllIlIllIlIlIlIIlIIll;
    }
    
    @Override
    public String getName() {
        if (this.methodInfo.isStaticInitializer()) {
            return "<clinit>";
        }
        return this.declaringClass.getSimpleName();
    }
    
    public boolean isConstructor() {
        return this.methodInfo.isConstructor();
    }
    
    @Override
    public String getLongName() {
        return String.valueOf(new StringBuilder().append(this.getDeclaringClass().getName()).append(this.isConstructor() ? Descriptor.toString(this.getSignature()) : ".<clinit>()"));
    }
    
    @Override
    public boolean isEmpty() {
        final CodeAttribute llllllllllllllIlIllIlIlIllllllII = this.getMethodInfo2().getCodeAttribute();
        if (llllllllllllllIlIllIlIlIllllllII == null) {
            return false;
        }
        final ConstPool llllllllllllllIlIllIlIlIlllllIll = llllllllllllllIlIllIlIlIllllllII.getConstPool();
        final CodeIterator llllllllllllllIlIllIlIlIlllllIlI = llllllllllllllIlIllIlIlIllllllII.iterator();
        try {
            final int llllllllllllllIlIllIlIlIlllllllI = llllllllllllllIlIllIlIlIlllllIlI.byteAt(llllllllllllllIlIllIlIlIlllllIlI.next());
            final int llllllllllllllIlIllIlIllIIIIIIII;
            final int llllllllllllllIlIllIlIlIllllllll;
            return llllllllllllllIlIllIlIlIlllllllI == 177 || (llllllllllllllIlIllIlIlIlllllllI == 42 && llllllllllllllIlIllIlIlIlllllIlI.byteAt(llllllllllllllIlIllIlIllIIIIIIII = llllllllllllllIlIllIlIlIlllllIlI.next()) == 183 && (llllllllllllllIlIllIlIlIllllllll = llllllllllllllIlIllIlIlIlllllIll.isConstructor(this.getSuperclassName(), llllllllllllllIlIllIlIlIlllllIlI.u16bitAt(llllllllllllllIlIllIlIllIIIIIIII + 1))) != 0 && "()V".equals(llllllllllllllIlIllIlIlIlllllIll.getUtf8Info(llllllllllllllIlIllIlIlIllllllll)) && llllllllllllllIlIllIlIlIlllllIlI.byteAt(llllllllllllllIlIllIlIlIlllllIlI.next()) == 177 && !llllllllllllllIlIllIlIlIlllllIlI.hasNext());
        }
        catch (BadBytecode llllllllllllllIlIllIlIlIllllIlIl) {
            return false;
        }
    }
    
    public void insertBeforeBody(final String llllllllllllllIlIllIlIlIllIIIIll) throws CannotCompileException {
        final CtClass llllllllllllllIlIllIlIlIllIIIIlI = this.declaringClass;
        llllllllllllllIlIllIlIlIllIIIIlI.checkModify();
        if (this.isClassInitializer()) {
            throw new CannotCompileException("class initializer");
        }
        final CodeAttribute llllllllllllllIlIllIlIlIllIIIIIl = this.methodInfo.getCodeAttribute();
        final CodeIterator llllllllllllllIlIllIlIlIllIIIIII = llllllllllllllIlIllIlIlIllIIIIIl.iterator();
        final Bytecode llllllllllllllIlIllIlIlIlIllllll = new Bytecode(this.methodInfo.getConstPool(), llllllllllllllIlIllIlIlIllIIIIIl.getMaxStack(), llllllllllllllIlIllIlIlIllIIIIIl.getMaxLocals());
        llllllllllllllIlIllIlIlIlIllllll.setStackDepth(llllllllllllllIlIllIlIlIllIIIIIl.getMaxStack());
        final Javac llllllllllllllIlIllIlIlIlIlllllI = new Javac(llllllllllllllIlIllIlIlIlIllllll, llllllllllllllIlIllIlIlIllIIIIlI);
        try {
            llllllllllllllIlIllIlIlIlIlllllI.recordParams(this.getParameterTypes(), false);
            llllllllllllllIlIllIlIlIlIlllllI.compileStmnt(llllllllllllllIlIllIlIlIllIIIIll);
            llllllllllllllIlIllIlIlIllIIIIIl.setMaxStack(llllllllllllllIlIllIlIlIlIllllll.getMaxStack());
            llllllllllllllIlIllIlIlIllIIIIIl.setMaxLocals(llllllllllllllIlIllIlIlIlIllllll.getMaxLocals());
            llllllllllllllIlIllIlIlIllIIIIII.skipConstructor();
            final int llllllllllllllIlIllIlIlIllIIlIII = llllllllllllllIlIllIlIlIllIIIIII.insertEx(llllllllllllllIlIllIlIlIlIllllll.get());
            llllllllllllllIlIllIlIlIllIIIIII.insert(llllllllllllllIlIllIlIlIlIllllll.getExceptionTable(), llllllllllllllIlIllIlIlIllIIlIII);
            this.methodInfo.rebuildStackMapIf6(llllllllllllllIlIllIlIlIllIIIIlI.getClassPool(), llllllllllllllIlIllIlIlIllIIIIlI.getClassFile2());
        }
        catch (NotFoundException llllllllllllllIlIllIlIlIllIIIlll) {
            throw new CannotCompileException(llllllllllllllIlIllIlIlIllIIIlll);
        }
        catch (CompileError llllllllllllllIlIllIlIlIllIIIllI) {
            throw new CannotCompileException(llllllllllllllIlIllIlIlIllIIIllI);
        }
        catch (BadBytecode llllllllllllllIlIllIlIlIllIIIlIl) {
            throw new CannotCompileException(llllllllllllllIlIllIlIlIllIIIlIl);
        }
    }
    
    public CtConstructor(final CtClass[] llllllllllllllIlIllIlIllIIlIlIII, final CtClass llllllllllllllIlIllIlIllIIlIIIlI) {
        this((MethodInfo)null, llllllllllllllIlIllIlIllIIlIIIlI);
        final ConstPool llllllllllllllIlIllIlIllIIlIIllI = llllllllllllllIlIllIlIllIIlIIIlI.getClassFile2().getConstPool();
        final String llllllllllllllIlIllIlIllIIlIIlIl = Descriptor.ofConstructor(llllllllllllllIlIllIlIllIIlIlIII);
        this.methodInfo = new MethodInfo(llllllllllllllIlIllIlIllIIlIIllI, "<init>", llllllllllllllIlIllIlIllIIlIIlIl);
        this.setModifiers(1);
    }
    
    public CtMethod toMethod(final String llllllllllllllIlIllIlIlIlIlIIlII, final CtClass llllllllllllllIlIllIlIlIlIlIIllI) throws CannotCompileException {
        return this.toMethod(llllllllllllllIlIllIlIlIlIlIIlII, llllllllllllllIlIllIlIlIlIlIIllI, null);
    }
    
    private String getSuperclassName() {
        final ClassFile llllllllllllllIlIllIlIlIlllIllll = this.declaringClass.getClassFile2();
        return llllllllllllllIlIllIlIlIlllIllll.getSuperclass();
    }
    
    public boolean callsSuper() throws CannotCompileException {
        final CodeAttribute llllllllllllllIlIllIlIlIlllIIlII = this.methodInfo.getCodeAttribute();
        if (llllllllllllllIlIllIlIlIlllIIlII != null) {
            final CodeIterator llllllllllllllIlIllIlIlIlllIIllI = llllllllllllllIlIllIlIlIlllIIlII.iterator();
            try {
                final int llllllllllllllIlIllIlIlIlllIlIII = llllllllllllllIlIllIlIlIlllIIllI.skipSuperConstructor();
                return llllllllllllllIlIllIlIlIlllIlIII >= 0;
            }
            catch (BadBytecode llllllllllllllIlIllIlIlIlllIIlll) {
                throw new CannotCompileException(llllllllllllllIlIllIlIlIlllIIlll);
            }
        }
        return false;
    }
    
    public void setBody(final CtConstructor llllllllllllllIlIllIlIlIllIlIlIl, final ClassMap llllllllllllllIlIllIlIlIllIlIlII) throws CannotCompileException {
        CtBehavior.setBody0(llllllllllllllIlIllIlIlIllIlIlIl.declaringClass, llllllllllllllIlIllIlIlIllIlIlIl.methodInfo, this.declaringClass, this.methodInfo, llllllllllllllIlIllIlIlIllIlIlII);
    }
    
    private static void removeConsCall(final CodeAttribute llllllllllllllIlIllIlIlIIlllllIl) throws CannotCompileException {
        final CodeIterator llllllllllllllIlIllIlIlIIlllllII = llllllllllllllIlIllIlIlIIlllllIl.iterator();
        try {
            int llllllllllllllIlIllIlIlIIlllllll = llllllllllllllIlIllIlIlIIlllllII.skipConstructor();
            if (llllllllllllllIlIllIlIlIIlllllll >= 0) {
                final int llllllllllllllIlIllIlIlIlIIIIIll = llllllllllllllIlIllIlIlIIlllllII.u16bitAt(llllllllllllllIlIllIlIlIIlllllll + 1);
                final String llllllllllllllIlIllIlIlIlIIIIIlI = llllllllllllllIlIllIlIlIIlllllIl.getConstPool().getMethodrefType(llllllllllllllIlIllIlIlIlIIIIIll);
                final int llllllllllllllIlIllIlIlIlIIIIIIl = Descriptor.numOfParameters(llllllllllllllIlIllIlIlIlIIIIIlI) + 1;
                if (llllllllllllllIlIllIlIlIlIIIIIIl > 3) {
                    llllllllllllllIlIllIlIlIIlllllll = llllllllllllllIlIllIlIlIIlllllII.insertGapAt(llllllllllllllIlIllIlIlIIlllllll, llllllllllllllIlIllIlIlIlIIIIIIl - 3, false).position;
                }
                llllllllllllllIlIllIlIlIIlllllII.writeByte(87, llllllllllllllIlIllIlIlIIlllllll++);
                llllllllllllllIlIllIlIlIIlllllII.writeByte(0, llllllllllllllIlIllIlIlIIlllllll);
                llllllllllllllIlIllIlIlIIlllllII.writeByte(0, llllllllllllllIlIllIlIlIIlllllll + 1);
                final Descriptor.Iterator llllllllllllllIlIllIlIlIlIIIIIII = new Descriptor.Iterator(llllllllllllllIlIllIlIlIlIIIIIlI);
                while (true) {
                    llllllllllllllIlIllIlIlIlIIIIIII.next();
                    if (!llllllllllllllIlIllIlIlIlIIIIIII.isParameter()) {
                        break;
                    }
                    llllllllllllllIlIllIlIlIIlllllII.writeByte(llllllllllllllIlIllIlIlIlIIIIIII.is2byte() ? 88 : 87, llllllllllllllIlIllIlIlIIlllllll++);
                }
            }
        }
        catch (BadBytecode llllllllllllllIlIllIlIlIIllllllI) {
            throw new CannotCompileException(llllllllllllllIlIllIlIlIIllllllI);
        }
    }
}
