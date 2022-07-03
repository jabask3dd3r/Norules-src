package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public final class TransformFieldAccess extends Transformer
{
    private /* synthetic */ boolean isPrivate;
    private /* synthetic */ String newFieldname;
    private /* synthetic */ String fieldname;
    private /* synthetic */ CtClass fieldClass;
    private /* synthetic */ int newIndex;
    private /* synthetic */ String newClassname;
    private /* synthetic */ ConstPool constPool;
    
    @Override
    public int transform(final CtClass llllllllllllllIlllIIlIlIIIIllIll, final int llllllllllllllIlllIIlIlIIIIllIlI, final CodeIterator llllllllllllllIlllIIlIlIIIIlllll, final ConstPool llllllllllllllIlllIIlIlIIIIllllI) {
        final int llllllllllllllIlllIIlIlIIIIlllIl = llllllllllllllIlllIIlIlIIIIlllll.byteAt(llllllllllllllIlllIIlIlIIIIllIlI);
        if (llllllllllllllIlllIIlIlIIIIlllIl == 180 || llllllllllllllIlllIIlIlIIIIlllIl == 178 || llllllllllllllIlllIIlIlIIIIlllIl == 181 || llllllllllllllIlllIIlIlIIIIlllIl == 179) {
            final int llllllllllllllIlllIIlIlIIIlIIlII = llllllllllllllIlllIIlIlIIIIlllll.u16bitAt(llllllllllllllIlllIIlIlIIIIllIlI + 1);
            final String llllllllllllllIlllIIlIlIIIlIIIll = TransformReadField.isField(llllllllllllllIlllIIlIlIIIIllIll.getClassPool(), llllllllllllllIlllIIlIlIIIIllllI, this.fieldClass, this.fieldname, this.isPrivate, llllllllllllllIlllIIlIlIIIlIIlII);
            if (llllllllllllllIlllIIlIlIIIlIIIll != null) {
                if (this.newIndex == 0) {
                    final int llllllllllllllIlllIIlIlIIIlIIlIl = llllllllllllllIlllIIlIlIIIIllllI.addNameAndTypeInfo(this.newFieldname, llllllllllllllIlllIIlIlIIIlIIIll);
                    this.newIndex = llllllllllllllIlllIIlIlIIIIllllI.addFieldrefInfo(llllllllllllllIlllIIlIlIIIIllllI.addClassInfo(this.newClassname), llllllllllllllIlllIIlIlIIIlIIlIl);
                    this.constPool = llllllllllllllIlllIIlIlIIIIllllI;
                }
                llllllllllllllIlllIIlIlIIIIlllll.write16bit(this.newIndex, llllllllllllllIlllIIlIlIIIIllIlI + 1);
            }
        }
        return llllllllllllllIlllIIlIlIIIIllIlI;
    }
    
    public TransformFieldAccess(final Transformer llllllllllllllIlllIIlIlIIIlllIIl, final CtField llllllllllllllIlllIIlIlIIIllllIl, final String llllllllllllllIlllIIlIlIIIllIlll, final String llllllllllllllIlllIIlIlIIIlllIll) {
        super(llllllllllllllIlllIIlIlIIIlllIIl);
        this.fieldClass = llllllllllllllIlllIIlIlIIIllllIl.getDeclaringClass();
        this.fieldname = llllllllllllllIlllIIlIlIIIllllIl.getName();
        this.isPrivate = Modifier.isPrivate(llllllllllllllIlllIIlIlIIIllllIl.getModifiers());
        this.newClassname = llllllllllllllIlllIIlIlIIIllIlll;
        this.newFieldname = llllllllllllllIlllIIlIlIIIlllIll;
        this.constPool = null;
    }
    
    @Override
    public void initialize(final ConstPool llllllllllllllIlllIIlIlIIIllIIlI, final CodeAttribute llllllllllllllIlllIIlIlIIIllIIIl) {
        if (this.constPool != llllllllllllllIlllIIlIlIIIllIIlI) {
            this.newIndex = 0;
        }
    }
}
