package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class TransformReadField extends Transformer
{
    protected /* synthetic */ String methodClassname;
    protected /* synthetic */ CtClass fieldClass;
    protected /* synthetic */ String fieldname;
    protected /* synthetic */ String methodName;
    protected /* synthetic */ boolean isPrivate;
    
    public TransformReadField(final Transformer lllllllllllllIIlIIllIIIIlIlIlIlI, final CtField lllllllllllllIIlIIllIIIIlIlIIlII, final String lllllllllllllIIlIIllIIIIlIlIlIII, final String lllllllllllllIIlIIllIIIIlIlIIIlI) {
        super(lllllllllllllIIlIIllIIIIlIlIlIlI);
        this.fieldClass = lllllllllllllIIlIIllIIIIlIlIIlII.getDeclaringClass();
        this.fieldname = lllllllllllllIIlIIllIIIIlIlIIlII.getName();
        this.methodClassname = lllllllllllllIIlIIllIIIIlIlIlIII;
        this.methodName = lllllllllllllIIlIIllIIIIlIlIIIlI;
        this.isPrivate = Modifier.isPrivate(lllllllllllllIIlIIllIIIIlIlIIlII.getModifiers());
    }
    
    static String isField(final ClassPool lllllllllllllIIlIIllIIIIlIIlIIll, final ConstPool lllllllllllllIIlIIllIIIIlIIllIII, final CtClass lllllllllllllIIlIIllIIIIlIIlIlll, final String lllllllllllllIIlIIllIIIIlIIlIIII, final boolean lllllllllllllIIlIIllIIIIlIIlIlIl, final int lllllllllllllIIlIIllIIIIlIIlIlII) {
        if (!lllllllllllllIIlIIllIIIIlIIllIII.getFieldrefName(lllllllllllllIIlIIllIIIIlIIlIlII).equals(lllllllllllllIIlIIllIIIIlIIlIIII)) {
            return null;
        }
        try {
            final CtClass lllllllllllllIIlIIllIIIIlIIllIlI = lllllllllllllIIlIIllIIIIlIIlIIll.get(lllllllllllllIIlIIllIIIIlIIllIII.getFieldrefClassName(lllllllllllllIIlIIllIIIIlIIlIlII));
            if (lllllllllllllIIlIIllIIIIlIIllIlI == lllllllllllllIIlIIllIIIIlIIlIlll || (!lllllllllllllIIlIIllIIIIlIIlIlIl && isFieldInSuper(lllllllllllllIIlIIllIIIIlIIllIlI, lllllllllllllIIlIIllIIIIlIIlIlll, lllllllllllllIIlIIllIIIIlIIlIIII))) {
                return lllllllllllllIIlIIllIIIIlIIllIII.getFieldrefType(lllllllllllllIIlIIllIIIIlIIlIlII);
            }
        }
        catch (NotFoundException ex) {}
        return null;
    }
    
    @Override
    public int transform(final CtClass lllllllllllllIIlIIllIIIIIllIllll, int lllllllllllllIIlIIllIIIIIllIlIII, final CodeIterator lllllllllllllIIlIIllIIIIIllIIlll, final ConstPool lllllllllllllIIlIIllIIIIIllIllII) throws BadBytecode {
        final int lllllllllllllIIlIIllIIIIIllIlIll = lllllllllllllIIlIIllIIIIIllIIlll.byteAt((int)lllllllllllllIIlIIllIIIIIllIlIII);
        if (lllllllllllllIIlIIllIIIIIllIlIll == 180 || lllllllllllllIIlIIllIIIIIllIlIll == 178) {
            final int lllllllllllllIIlIIllIIIIIlllIIlI = lllllllllllllIIlIIllIIIIIllIIlll.u16bitAt((int)(lllllllllllllIIlIIllIIIIIllIlIII + 1));
            final String lllllllllllllIIlIIllIIIIIlllIIIl = isField(lllllllllllllIIlIIllIIIIIllIllll.getClassPool(), lllllllllllllIIlIIllIIIIIllIllII, this.fieldClass, this.fieldname, this.isPrivate, lllllllllllllIIlIIllIIIIIlllIIlI);
            if (lllllllllllllIIlIIllIIIIIlllIIIl != null) {
                if (lllllllllllllIIlIIllIIIIIllIlIll == 178) {
                    lllllllllllllIIlIIllIIIIIllIIlll.move((int)lllllllllllllIIlIIllIIIIIllIlIII);
                    lllllllllllllIIlIIllIIIIIllIlIII = lllllllllllllIIlIIllIIIIIllIIlll.insertGap(1);
                    lllllllllllllIIlIIllIIIIIllIIlll.writeByte(1, (int)lllllllllllllIIlIIllIIIIIllIlIII);
                    lllllllllllllIIlIIllIIIIIllIlIII = lllllllllllllIIlIIllIIIIIllIIlll.next();
                }
                final String lllllllllllllIIlIIllIIIIIlllIlIl = String.valueOf(new StringBuilder().append("(Ljava/lang/Object;)").append(lllllllllllllIIlIIllIIIIIlllIIIl));
                final int lllllllllllllIIlIIllIIIIIlllIlII = lllllllllllllIIlIIllIIIIIllIllII.addClassInfo(this.methodClassname);
                final int lllllllllllllIIlIIllIIIIIlllIIll = lllllllllllllIIlIIllIIIIIllIllII.addMethodrefInfo(lllllllllllllIIlIIllIIIIIlllIlII, this.methodName, lllllllllllllIIlIIllIIIIIlllIlIl);
                lllllllllllllIIlIIllIIIIIllIIlll.writeByte(184, (int)lllllllllllllIIlIIllIIIIIllIlIII);
                lllllllllllllIIlIIllIIIIIllIIlll.write16bit(lllllllllllllIIlIIllIIIIIlllIIll, (int)(lllllllllllllIIlIIllIIIIIllIlIII + 1));
                return (int)lllllllllllllIIlIIllIIIIIllIlIII;
            }
        }
        return (int)lllllllllllllIIlIIllIIIIIllIlIII;
    }
    
    static boolean isFieldInSuper(final CtClass lllllllllllllIIlIIllIIIIlIIIIlII, final CtClass lllllllllllllIIlIIllIIIIlIIIIllI, final String lllllllllllllIIlIIllIIIIlIIIIlIl) {
        if (!lllllllllllllIIlIIllIIIIlIIIIlII.subclassOf(lllllllllllllIIlIIllIIIIlIIIIllI)) {
            return false;
        }
        try {
            final CtField lllllllllllllIIlIIllIIIIlIIIlIII = lllllllllllllIIlIIllIIIIlIIIIlII.getField(lllllllllllllIIlIIllIIIIlIIIIlIl);
            return lllllllllllllIIlIIllIIIIlIIIlIII.getDeclaringClass() == lllllllllllllIIlIIllIIIIlIIIIllI;
        }
        catch (NotFoundException lllllllllllllIIlIIllIIIIlIIIIIIl) {
            return false;
        }
    }
}
