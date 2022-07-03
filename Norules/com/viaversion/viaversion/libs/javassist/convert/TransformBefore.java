package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class TransformBefore extends TransformCall
{
    protected /* synthetic */ int maxLocals;
    protected /* synthetic */ byte[] loadCode;
    protected /* synthetic */ CtClass[] parameterTypes;
    protected /* synthetic */ int locals;
    protected /* synthetic */ byte[] saveCode;
    
    protected int match2(final int lllllllllllllIIlllIIIIIlllIllllI, final CodeIterator lllllllllllllIIlllIIIIIllllIIIIl) throws BadBytecode {
        lllllllllllllIIlllIIIIIllllIIIIl.move(lllllllllllllIIlllIIIIIlllIllllI);
        lllllllllllllIIlllIIIIIllllIIIIl.insert(this.saveCode);
        lllllllllllllIIlllIIIIIllllIIIIl.insert(this.loadCode);
        final int lllllllllllllIIlllIIIIIllllIIIII = lllllllllllllIIlllIIIIIllllIIIIl.insertGap(3);
        lllllllllllllIIlllIIIIIllllIIIIl.writeByte(184, lllllllllllllIIlllIIIIIllllIIIII);
        lllllllllllllIIlllIIIIIllllIIIIl.write16bit(this.newIndex, lllllllllllllIIlllIIIIIllllIIIII + 1);
        lllllllllllllIIlllIIIIIllllIIIIl.insert(this.loadCode);
        return lllllllllllllIIlllIIIIIllllIIIIl.next();
    }
    
    public TransformBefore(final Transformer lllllllllllllIIlllIIIIlIIIIIlIlI, final CtMethod lllllllllllllIIlllIIIIlIIIIIlIIl, final CtMethod lllllllllllllIIlllIIIIlIIIIIllII) throws NotFoundException {
        super(lllllllllllllIIlllIIIIlIIIIIlIlI, lllllllllllllIIlllIIIIlIIIIIlIIl, lllllllllllllIIlllIIIIlIIIIIllII);
        this.methodDescriptor = lllllllllllllIIlllIIIIlIIIIIlIIl.getMethodInfo2().getDescriptor();
        this.parameterTypes = lllllllllllllIIlllIIIIlIIIIIlIIl.getParameterTypes();
        this.locals = 0;
        this.maxLocals = 0;
        final byte[] array = null;
        this.loadCode = array;
        this.saveCode = array;
    }
    
    private void makeCode2(final Bytecode lllllllllllllIIlllIIIIIllIlllIIl, final Bytecode lllllllllllllIIlllIIIIIllIllIIIl, final int lllllllllllllIIlllIIIIIllIllIIII, final int lllllllllllllIIlllIIIIIllIllIllI, final CtClass[] lllllllllllllIIlllIIIIIllIlIlllI, final int lllllllllllllIIlllIIIIIllIlIllIl) {
        if (lllllllllllllIIlllIIIIIllIllIIII < lllllllllllllIIlllIIIIIllIllIllI) {
            final int lllllllllllllIIlllIIIIIllIlllIll = lllllllllllllIIlllIIIIIllIllIIIl.addLoad(lllllllllllllIIlllIIIIIllIlIllIl, lllllllllllllIIlllIIIIIllIlIlllI[lllllllllllllIIlllIIIIIllIllIIII]);
            this.makeCode2(lllllllllllllIIlllIIIIIllIlllIIl, lllllllllllllIIlllIIIIIllIllIIIl, lllllllllllllIIlllIIIIIllIllIIII + 1, lllllllllllllIIlllIIIIIllIllIllI, lllllllllllllIIlllIIIIIllIlIlllI, lllllllllllllIIlllIIIIIllIlIllIl + lllllllllllllIIlllIIIIIllIlllIll);
            lllllllllllllIIlllIIIIIllIlllIIl.addStore(lllllllllllllIIlllIIIIIllIlIllIl, lllllllllllllIIlllIIIIIllIlIlllI[lllllllllllllIIlllIIIIIllIllIIII]);
        }
        else {
            this.locals = lllllllllllllIIlllIIIIIllIlIllIl - this.maxLocals;
        }
    }
    
    protected void makeCode(final CtClass[] lllllllllllllIIlllIIIIIlllIIlIIl, final ConstPool lllllllllllllIIlllIIIIIlllIIllll) {
        final Bytecode lllllllllllllIIlllIIIIIlllIIlllI = new Bytecode(lllllllllllllIIlllIIIIIlllIIllll, 0, 0);
        final Bytecode lllllllllllllIIlllIIIIIlllIIllIl = new Bytecode(lllllllllllllIIlllIIIIIlllIIllll, 0, 0);
        final int lllllllllllllIIlllIIIIIlllIIllII = this.maxLocals;
        final int lllllllllllllIIlllIIIIIlllIIlIll = (lllllllllllllIIlllIIIIIlllIIlIIl == null) ? 0 : lllllllllllllIIlllIIIIIlllIIlIIl.length;
        lllllllllllllIIlllIIIIIlllIIllIl.addAload(lllllllllllllIIlllIIIIIlllIIllII);
        this.makeCode2(lllllllllllllIIlllIIIIIlllIIlllI, lllllllllllllIIlllIIIIIlllIIllIl, 0, lllllllllllllIIlllIIIIIlllIIlIll, lllllllllllllIIlllIIIIIlllIIlIIl, lllllllllllllIIlllIIIIIlllIIllII + 1);
        lllllllllllllIIlllIIIIIlllIIlllI.addAstore(lllllllllllllIIlllIIIIIlllIIllII);
        this.saveCode = lllllllllllllIIlllIIIIIlllIIlllI.get();
        this.loadCode = lllllllllllllIIlllIIIIIlllIIllIl.get();
    }
    
    @Override
    protected int match(final int lllllllllllllIIlllIIIIIlllllIIll, final int lllllllllllllIIlllIIIIIlllllIIlI, final CodeIterator lllllllllllllIIlllIIIIIllllIllII, final int lllllllllllllIIlllIIIIIlllllIIII, final ConstPool lllllllllllllIIlllIIIIIllllIlIll) throws BadBytecode {
        if (this.newIndex == 0) {
            String lllllllllllllIIlllIIIIIlllllIlll = String.valueOf(new StringBuilder().append(Descriptor.ofParameters(this.parameterTypes)).append('V'));
            lllllllllllllIIlllIIIIIlllllIlll = Descriptor.insertParameter(this.classname, lllllllllllllIIlllIIIIIlllllIlll);
            final int lllllllllllllIIlllIIIIIlllllIllI = lllllllllllllIIlllIIIIIllllIlIll.addNameAndTypeInfo(this.newMethodname, lllllllllllllIIlllIIIIIlllllIlll);
            final int lllllllllllllIIlllIIIIIlllllIlIl = lllllllllllllIIlllIIIIIllllIlIll.addClassInfo(this.newClassname);
            this.newIndex = lllllllllllllIIlllIIIIIllllIlIll.addMethodrefInfo(lllllllllllllIIlllIIIIIlllllIlIl, lllllllllllllIIlllIIIIIlllllIllI);
            this.constPool = lllllllllllllIIlllIIIIIllllIlIll;
        }
        if (this.saveCode == null) {
            this.makeCode(this.parameterTypes, lllllllllllllIIlllIIIIIllllIlIll);
        }
        return this.match2(lllllllllllllIIlllIIIIIlllllIIlI, lllllllllllllIIlllIIIIIllllIllII);
    }
    
    @Override
    public void initialize(final ConstPool lllllllllllllIIlllIIIIlIIIIIIIII, final CodeAttribute lllllllllllllIIlllIIIIIlllllllll) {
        super.initialize(lllllllllllllIIlllIIIIlIIIIIIIII, lllllllllllllIIlllIIIIIlllllllll);
        this.locals = 0;
        this.maxLocals = lllllllllllllIIlllIIIIIlllllllll.getMaxLocals();
        final byte[] array = null;
        this.loadCode = array;
        this.saveCode = array;
    }
    
    @Override
    public int extraLocals() {
        return this.locals;
    }
}
