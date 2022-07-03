package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;

public final class TransformNewClass extends Transformer
{
    private /* synthetic */ int newMethodNTIndex;
    private /* synthetic */ int newMethodIndex;
    private /* synthetic */ String newClassName;
    private /* synthetic */ int newClassIndex;
    private /* synthetic */ String classname;
    private /* synthetic */ int nested;
    
    @Override
    public void initialize(final ConstPool lllllllllllllIlllIIlIllIIIIIIIII, final CodeAttribute lllllllllllllIlllIIlIlIlllllllll) {
        this.nested = 0;
        final int newClassIndex = 0;
        this.newMethodIndex = newClassIndex;
        this.newMethodNTIndex = newClassIndex;
        this.newClassIndex = newClassIndex;
    }
    
    public TransformNewClass(final Transformer lllllllllllllIlllIIlIllIIIIIIlIl, final String lllllllllllllIlllIIlIllIIIIIlIII, final String lllllllllllllIlllIIlIllIIIIIIlll) {
        super(lllllllllllllIlllIIlIllIIIIIIlIl);
        this.classname = lllllllllllllIlllIIlIllIIIIIlIII;
        this.newClassName = lllllllllllllIlllIIlIllIIIIIIlll;
    }
    
    @Override
    public int transform(final CtClass lllllllllllllIlllIIlIlIlllllIIII, final int lllllllllllllIlllIIlIlIllllIllll, final CodeIterator lllllllllllllIlllIIlIlIllllIlIIl, final ConstPool lllllllllllllIlllIIlIlIllllIlIII) throws CannotCompileException {
        final int lllllllllllllIlllIIlIlIllllIllII = lllllllllllllIlllIIlIlIllllIlIIl.byteAt(lllllllllllllIlllIIlIlIllllIllll);
        if (lllllllllllllIlllIIlIlIllllIllII == 187) {
            final int lllllllllllllIlllIIlIlIlllllIlIl = lllllllllllllIlllIIlIlIllllIlIIl.u16bitAt(lllllllllllllIlllIIlIlIllllIllll + 1);
            if (lllllllllllllIlllIIlIlIllllIlIII.getClassInfo(lllllllllllllIlllIIlIlIlllllIlIl).equals(this.classname)) {
                if (lllllllllllllIlllIIlIlIllllIlIIl.byteAt(lllllllllllllIlllIIlIlIllllIllll + 3) != 89) {
                    throw new CannotCompileException("NEW followed by no DUP was found");
                }
                if (this.newClassIndex == 0) {
                    this.newClassIndex = lllllllllllllIlllIIlIlIllllIlIII.addClassInfo(this.newClassName);
                }
                lllllllllllllIlllIIlIlIllllIlIIl.write16bit(this.newClassIndex, lllllllllllllIlllIIlIlIllllIllll + 1);
                ++this.nested;
            }
        }
        else if (lllllllllllllIlllIIlIlIllllIllII == 183) {
            final int lllllllllllllIlllIIlIlIlllllIIlI = lllllllllllllIlllIIlIlIllllIlIIl.u16bitAt(lllllllllllllIlllIIlIlIllllIllll + 1);
            final int lllllllllllllIlllIIlIlIlllllIIll = lllllllllllllIlllIIlIlIllllIlIII.isConstructor(this.classname, lllllllllllllIlllIIlIlIlllllIIlI);
            if (lllllllllllllIlllIIlIlIlllllIIll != 0 && this.nested > 0) {
                final int lllllllllllllIlllIIlIlIlllllIlII = lllllllllllllIlllIIlIlIllllIlIII.getMethodrefNameAndType(lllllllllllllIlllIIlIlIlllllIIlI);
                if (this.newMethodNTIndex != lllllllllllllIlllIIlIlIlllllIlII) {
                    this.newMethodNTIndex = lllllllllllllIlllIIlIlIlllllIlII;
                    this.newMethodIndex = lllllllllllllIlllIIlIlIllllIlIII.addMethodrefInfo(this.newClassIndex, lllllllllllllIlllIIlIlIlllllIlII);
                }
                lllllllllllllIlllIIlIlIllllIlIIl.write16bit(this.newMethodIndex, lllllllllllllIlllIIlIlIllllIllll + 1);
                --this.nested;
            }
        }
        return lllllllllllllIlllIIlIlIllllIllll;
    }
}
