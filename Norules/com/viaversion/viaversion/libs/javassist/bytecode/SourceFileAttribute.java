package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

public class SourceFileAttribute extends AttributeInfo
{
    static {
        tag = "SourceFile";
    }
    
    SourceFileAttribute(final ConstPool lllllllllllllIlIllIlllIllIllIlIl, final int lllllllllllllIlIllIlllIllIllIIII, final DataInputStream lllllllllllllIlIllIlllIllIlIllll) throws IOException {
        super(lllllllllllllIlIllIlllIllIllIlIl, lllllllllllllIlIllIlllIllIllIIII, lllllllllllllIlIllIlllIllIlIllll);
    }
    
    public SourceFileAttribute(final ConstPool lllllllllllllIlIllIlllIllIlIIIll, final String lllllllllllllIlIllIlllIllIlIIlll) {
        super(lllllllllllllIlIllIlllIllIlIIIll, "SourceFile");
        final int lllllllllllllIlIllIlllIllIlIIllI = lllllllllllllIlIllIlllIllIlIIIll.addUtf8Info(lllllllllllllIlIllIlllIllIlIIlll);
        final byte[] lllllllllllllIlIllIlllIllIlIIlIl = { (byte)(lllllllllllllIlIllIlllIllIlIIllI >>> 8), (byte)lllllllllllllIlIllIlllIllIlIIllI };
        this.set(lllllllllllllIlIllIlllIllIlIIlIl);
    }
    
    public String getFileName() {
        return this.getConstPool().getUtf8Info(ByteArray.readU16bit(this.get(), 0));
    }
    
    @Override
    public AttributeInfo copy(final ConstPool lllllllllllllIlIllIlllIllIIllIIl, final Map<String, String> lllllllllllllIlIllIlllIllIIllIII) {
        return new SourceFileAttribute(lllllllllllllIlIllIlllIllIIllIIl, this.getFileName());
    }
}
