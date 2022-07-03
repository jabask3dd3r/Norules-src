package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

public class ConstantAttribute extends AttributeInfo
{
    public int getConstantValue() {
        return ByteArray.readU16bit(this.get(), 0);
    }
    
    static {
        tag = "ConstantValue";
    }
    
    ConstantAttribute(final ConstPool lllllllllllllIIIllIlllIIllIIIIII, final int lllllllllllllIIIllIlllIIlIlllIll, final DataInputStream lllllllllllllIIIllIlllIIlIlllllI) throws IOException {
        super(lllllllllllllIIIllIlllIIllIIIIII, lllllllllllllIIIllIlllIIlIlllIll, lllllllllllllIIIllIlllIIlIlllllI);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool lllllllllllllIIIllIlllIIlIlIIIIl, final Map<String, String> lllllllllllllIIIllIlllIIlIlIIlII) {
        final int lllllllllllllIIIllIlllIIlIlIIIll = this.getConstPool().copy(this.getConstantValue(), lllllllllllllIIIllIlllIIlIlIIIIl, lllllllllllllIIIllIlllIIlIlIIlII);
        return new ConstantAttribute(lllllllllllllIIIllIlllIIlIlIIIIl, lllllllllllllIIIllIlllIIlIlIIIll);
    }
    
    public ConstantAttribute(final ConstPool lllllllllllllIIIllIlllIIlIllIIII, final int lllllllllllllIIIllIlllIIlIllIIll) {
        super(lllllllllllllIIIllIlllIIlIllIIII, "ConstantValue");
        final byte[] lllllllllllllIIIllIlllIIlIllIIlI = { (byte)(lllllllllllllIIIllIlllIIlIllIIll >>> 8), (byte)lllllllllllllIIIllIlllIIlIllIIll };
        this.set(lllllllllllllIIIllIlllIIlIllIIlI);
    }
}
