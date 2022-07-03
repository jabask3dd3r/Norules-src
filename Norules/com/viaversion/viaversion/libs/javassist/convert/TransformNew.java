package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public final class TransformNew extends Transformer
{
    private /* synthetic */ String classname;
    private /* synthetic */ int nested;
    private /* synthetic */ String trapMethod;
    private /* synthetic */ String trapClass;
    
    @Override
    public void initialize(final ConstPool llllllllllllllIIlIlllllllIllIIIl, final CodeAttribute llllllllllllllIIlIlllllllIllIIII) {
        this.nested = 0;
    }
    
    @Override
    public int transform(final CtClass llllllllllllllIIlIlllllllIIlllll, final int llllllllllllllIIlIlllllllIIllllI, final CodeIterator llllllllllllllIIlIlllllllIIllIII, final ConstPool llllllllllllllIIlIlllllllIIlllII) throws CannotCompileException {
        final int llllllllllllllIIlIlllllllIIllIll = llllllllllllllIIlIlllllllIIllIII.byteAt(llllllllllllllIIlIlllllllIIllllI);
        if (llllllllllllllIIlIlllllllIIllIll == 187) {
            final int llllllllllllllIIlIlllllllIlIIlII = llllllllllllllIIlIlllllllIIllIII.u16bitAt(llllllllllllllIIlIlllllllIIllllI + 1);
            if (llllllllllllllIIlIlllllllIIlllII.getClassInfo(llllllllllllllIIlIlllllllIlIIlII).equals(this.classname)) {
                if (llllllllllllllIIlIlllllllIIllIII.byteAt(llllllllllllllIIlIlllllllIIllllI + 3) != 89) {
                    throw new CannotCompileException("NEW followed by no DUP was found");
                }
                llllllllllllllIIlIlllllllIIllIII.writeByte(0, llllllllllllllIIlIlllllllIIllllI);
                llllllllllllllIIlIlllllllIIllIII.writeByte(0, llllllllllllllIIlIlllllllIIllllI + 1);
                llllllllllllllIIlIlllllllIIllIII.writeByte(0, llllllllllllllIIlIlllllllIIllllI + 2);
                llllllllllllllIIlIlllllllIIllIII.writeByte(0, llllllllllllllIIlIlllllllIIllllI + 3);
                ++this.nested;
                final StackMapTable llllllllllllllIIlIlllllllIlIIllI = (StackMapTable)llllllllllllllIIlIlllllllIIllIII.get().getAttribute("StackMapTable");
                if (llllllllllllllIIlIlllllllIlIIllI != null) {
                    llllllllllllllIIlIlllllllIlIIllI.removeNew(llllllllllllllIIlIlllllllIIllllI);
                }
                final StackMap llllllllllllllIIlIlllllllIlIIlIl = (StackMap)llllllllllllllIIlIlllllllIIllIII.get().getAttribute("StackMap");
                if (llllllllllllllIIlIlllllllIlIIlIl != null) {
                    llllllllllllllIIlIlllllllIlIIlIl.removeNew(llllllllllllllIIlIlllllllIIllllI);
                }
            }
        }
        else if (llllllllllllllIIlIlllllllIIllIll == 183) {
            final int llllllllllllllIIlIlllllllIlIIIIl = llllllllllllllIIlIlllllllIIllIII.u16bitAt(llllllllllllllIIlIlllllllIIllllI + 1);
            final int llllllllllllllIIlIlllllllIlIIIlI = llllllllllllllIIlIlllllllIIlllII.isConstructor(this.classname, llllllllllllllIIlIlllllllIlIIIIl);
            if (llllllllllllllIIlIlllllllIlIIIlI != 0 && this.nested > 0) {
                final int llllllllllllllIIlIlllllllIlIIIll = this.computeMethodref(llllllllllllllIIlIlllllllIlIIIlI, llllllllllllllIIlIlllllllIIlllII);
                llllllllllllllIIlIlllllllIIllIII.writeByte(184, llllllllllllllIIlIlllllllIIllllI);
                llllllllllllllIIlIlllllllIIllIII.write16bit(llllllllllllllIIlIlllllllIlIIIll, llllllllllllllIIlIlllllllIIllllI + 1);
                --this.nested;
            }
        }
        return llllllllllllllIIlIlllllllIIllllI;
    }
    
    private int computeMethodref(int llllllllllllllIIlIlllllllIIIIlll, final ConstPool llllllllllllllIIlIlllllllIIIlIll) {
        final int llllllllllllllIIlIlllllllIIIlIlI = llllllllllllllIIlIlllllllIIIlIll.addClassInfo(this.trapClass);
        final int llllllllllllllIIlIlllllllIIIlIIl = llllllllllllllIIlIlllllllIIIlIll.addUtf8Info(this.trapMethod);
        llllllllllllllIIlIlllllllIIIIlll = llllllllllllllIIlIlllllllIIIlIll.addUtf8Info(Descriptor.changeReturnType(this.classname, llllllllllllllIIlIlllllllIIIlIll.getUtf8Info(llllllllllllllIIlIlllllllIIIIlll)));
        return llllllllllllllIIlIlllllllIIIlIll.addMethodrefInfo(llllllllllllllIIlIlllllllIIIlIlI, llllllllllllllIIlIlllllllIIIlIll.addNameAndTypeInfo(llllllllllllllIIlIlllllllIIIlIIl, llllllllllllllIIlIlllllllIIIIlll));
    }
    
    public TransformNew(final Transformer llllllllllllllIIlIlllllllIllIlll, final String llllllllllllllIIlIlllllllIlllIll, final String llllllllllllllIIlIlllllllIllIlIl, final String llllllllllllllIIlIlllllllIlllIIl) {
        super(llllllllllllllIIlIlllllllIllIlll);
        this.classname = llllllllllllllIIlIlllllllIlllIll;
        this.trapClass = llllllllllllllIIlIlllllllIllIlIl;
        this.trapMethod = llllllllllllllIIlIlllllllIlllIIl;
    }
}
