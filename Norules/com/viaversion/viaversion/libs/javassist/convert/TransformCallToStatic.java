package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class TransformCallToStatic extends TransformCall
{
    public TransformCallToStatic(final Transformer lllllllllllllllIIllllllllllIIllI, final CtMethod lllllllllllllllIIllllllllllIIIIl, final CtMethod lllllllllllllllIIllllllllllIIlII) {
        super(lllllllllllllllIIllllllllllIIllI, lllllllllllllllIIllllllllllIIIIl, lllllllllllllllIIllllllllllIIlII);
        this.methodDescriptor = lllllllllllllllIIllllllllllIIIIl.getMethodInfo2().getDescriptor();
    }
    
    @Override
    protected int match(final int lllllllllllllllIIlllllllllIlIlII, final int lllllllllllllllIIlllllllllIlIIll, final CodeIterator lllllllllllllllIIlllllllllIIllIl, final int lllllllllllllllIIlllllllllIlIIIl, final ConstPool lllllllllllllllIIlllllllllIIllII) {
        if (this.newIndex == 0) {
            final String lllllllllllllllIIlllllllllIllIII = Descriptor.insertParameter(this.classname, this.methodDescriptor);
            final int lllllllllllllllIIlllllllllIlIlll = lllllllllllllllIIlllllllllIIllII.addNameAndTypeInfo(this.newMethodname, lllllllllllllllIIlllllllllIllIII);
            final int lllllllllllllllIIlllllllllIlIllI = lllllllllllllllIIlllllllllIIllII.addClassInfo(this.newClassname);
            this.newIndex = lllllllllllllllIIlllllllllIIllII.addMethodrefInfo(lllllllllllllllIIlllllllllIlIllI, lllllllllllllllIIlllllllllIlIlll);
            this.constPool = lllllllllllllllIIlllllllllIIllII;
        }
        lllllllllllllllIIlllllllllIIllIl.writeByte(184, lllllllllllllllIIlllllllllIlIIll);
        lllllllllllllllIIlllllllllIIllIl.write16bit(this.newIndex, lllllllllllllllIIlllllllllIlIIll + 1);
        return lllllllllllllllIIlllllllllIlIIll;
    }
}
