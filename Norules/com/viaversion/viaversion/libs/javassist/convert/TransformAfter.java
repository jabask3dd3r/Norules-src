package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class TransformAfter extends TransformBefore
{
    public TransformAfter(final Transformer lllllllllllllIIlllllIIlIllIlllIl, final CtMethod lllllllllllllIIlllllIIlIllIlllII, final CtMethod lllllllllllllIIlllllIIlIllIllIll) throws NotFoundException {
        super(lllllllllllllIIlllllIIlIllIlllIl, lllllllllllllIIlllllIIlIllIlllII, lllllllllllllIIlllllIIlIllIllIll);
    }
    
    @Override
    protected int match2(int lllllllllllllIIlllllIIlIllIlIlIl, final CodeIterator lllllllllllllIIlllllIIlIllIlIIII) throws BadBytecode {
        lllllllllllllIIlllllIIlIllIlIIII.move(lllllllllllllIIlllllIIlIllIlIlIl);
        lllllllllllllIIlllllIIlIllIlIIII.insert(this.saveCode);
        lllllllllllllIIlllllIIlIllIlIIII.insert(this.loadCode);
        int lllllllllllllIIlllllIIlIllIlIIll = lllllllllllllIIlllllIIlIllIlIIII.insertGap(3);
        lllllllllllllIIlllllIIlIllIlIIII.setMark(lllllllllllllIIlllllIIlIllIlIIll);
        lllllllllllllIIlllllIIlIllIlIIII.insert(this.loadCode);
        lllllllllllllIIlllllIIlIllIlIlIl = lllllllllllllIIlllllIIlIllIlIIII.next();
        lllllllllllllIIlllllIIlIllIlIIll = lllllllllllllIIlllllIIlIllIlIIII.getMark();
        lllllllllllllIIlllllIIlIllIlIIII.writeByte(lllllllllllllIIlllllIIlIllIlIIII.byteAt(lllllllllllllIIlllllIIlIllIlIlIl), lllllllllllllIIlllllIIlIllIlIIll);
        lllllllllllllIIlllllIIlIllIlIIII.write16bit(lllllllllllllIIlllllIIlIllIlIIII.u16bitAt(lllllllllllllIIlllllIIlIllIlIlIl + 1), lllllllllllllIIlllllIIlIllIlIIll + 1);
        lllllllllllllIIlllllIIlIllIlIIII.writeByte(184, lllllllllllllIIlllllIIlIllIlIlIl);
        lllllllllllllIIlllllIIlIllIlIIII.write16bit(this.newIndex, lllllllllllllIIlllllIIlIllIlIlIl + 1);
        lllllllllllllIIlllllIIlIllIlIIII.move(lllllllllllllIIlllllIIlIllIlIIll);
        return lllllllllllllIIlllllIIlIllIlIIII.next();
    }
}
