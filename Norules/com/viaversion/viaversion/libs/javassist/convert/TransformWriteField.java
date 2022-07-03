package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;

public final class TransformWriteField extends TransformReadField
{
    @Override
    public int transform(final CtClass lllllllllllllIllllllIlllllIlIlII, int lllllllllllllIllllllIlllllIIllIl, final CodeIterator lllllllllllllIllllllIlllllIlIIlI, final ConstPool lllllllllllllIllllllIlllllIIlIll) throws BadBytecode {
        final int lllllllllllllIllllllIlllllIlIIII = lllllllllllllIllllllIlllllIlIIlI.byteAt((int)lllllllllllllIllllllIlllllIIllIl);
        if (lllllllllllllIllllllIlllllIlIIII == 181 || lllllllllllllIllllllIlllllIlIIII == 179) {
            final int lllllllllllllIllllllIlllllIlIlll = lllllllllllllIllllllIlllllIlIIlI.u16bitAt((int)(lllllllllllllIllllllIlllllIIllIl + 1));
            final String lllllllllllllIllllllIlllllIlIllI = TransformReadField.isField(lllllllllllllIllllllIlllllIlIlII.getClassPool(), lllllllllllllIllllllIlllllIIlIll, this.fieldClass, this.fieldname, this.isPrivate, lllllllllllllIllllllIlllllIlIlll);
            if (lllllllllllllIllllllIlllllIlIllI != null) {
                if (lllllllllllllIllllllIlllllIlIIII == 179) {
                    final CodeAttribute lllllllllllllIllllllIlllllIlllII = lllllllllllllIllllllIlllllIlIIlI.get();
                    lllllllllllllIllllllIlllllIlIIlI.move((int)lllllllllllllIllllllIlllllIIllIl);
                    final char lllllllllllllIllllllIlllllIllIll = lllllllllllllIllllllIlllllIlIllI.charAt(0);
                    if (lllllllllllllIllllllIlllllIllIll == 'J' || lllllllllllllIllllllIlllllIllIll == 'D') {
                        lllllllllllllIllllllIlllllIIllIl = lllllllllllllIllllllIlllllIlIIlI.insertGap(3);
                        lllllllllllllIllllllIlllllIlIIlI.writeByte(1, (int)lllllllllllllIllllllIlllllIIllIl);
                        lllllllllllllIllllllIlllllIlIIlI.writeByte(91, (int)(lllllllllllllIllllllIlllllIIllIl + 1));
                        lllllllllllllIllllllIlllllIlIIlI.writeByte(87, (int)(lllllllllllllIllllllIlllllIIllIl + 2));
                        lllllllllllllIllllllIlllllIlllII.setMaxStack(lllllllllllllIllllllIlllllIlllII.getMaxStack() + 2);
                    }
                    else {
                        lllllllllllllIllllllIlllllIIllIl = lllllllllllllIllllllIlllllIlIIlI.insertGap(2);
                        lllllllllllllIllllllIlllllIlIIlI.writeByte(1, (int)lllllllllllllIllllllIlllllIIllIl);
                        lllllllllllllIllllllIlllllIlIIlI.writeByte(95, (int)(lllllllllllllIllllllIlllllIIllIl + 1));
                        lllllllllllllIllllllIlllllIlllII.setMaxStack(lllllllllllllIllllllIlllllIlllII.getMaxStack() + 1);
                    }
                    lllllllllllllIllllllIlllllIIllIl = lllllllllllllIllllllIlllllIlIIlI.next();
                }
                final int lllllllllllllIllllllIlllllIllIlI = lllllllllllllIllllllIlllllIIlIll.addClassInfo(this.methodClassname);
                final String lllllllllllllIllllllIlllllIllIIl = String.valueOf(new StringBuilder().append("(Ljava/lang/Object;").append(lllllllllllllIllllllIlllllIlIllI).append(")V"));
                final int lllllllllllllIllllllIlllllIllIII = lllllllllllllIllllllIlllllIIlIll.addMethodrefInfo(lllllllllllllIllllllIlllllIllIlI, this.methodName, lllllllllllllIllllllIlllllIllIIl);
                lllllllllllllIllllllIlllllIlIIlI.writeByte(184, (int)lllllllllllllIllllllIlllllIIllIl);
                lllllllllllllIllllllIlllllIlIIlI.write16bit(lllllllllllllIllllllIlllllIllIII, (int)(lllllllllllllIllllllIlllllIIllIl + 1));
            }
        }
        return (int)lllllllllllllIllllllIlllllIIllIl;
    }
    
    public TransformWriteField(final Transformer lllllllllllllIllllllIllllllIlIll, final CtField lllllllllllllIllllllIllllllIlIlI, final String lllllllllllllIllllllIllllllIlllI, final String lllllllllllllIllllllIllllllIlIII) {
        super(lllllllllllllIllllllIllllllIlIll, lllllllllllllIllllllIllllllIlIlI, lllllllllllllIllllllIllllllIlllI, lllllllllllllIllllllIllllllIlIII);
    }
}
