package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class MethodParametersAttribute extends AttributeInfo
{
    @Override
    public AttributeInfo copy(final ConstPool lllllllllllllIllIIIlIIlIIIIlllll, final Map<String, String> lllllllllllllIllIIIlIIlIIIlIIlIl) {
        final int lllllllllllllIllIIIlIIlIIIlIIlII = this.size();
        final ConstPool lllllllllllllIllIIIlIIlIIIlIIIll = this.getConstPool();
        final String[] lllllllllllllIllIIIlIIlIIIlIIIlI = new String[lllllllllllllIllIIIlIIlIIIlIIlII];
        final int[] lllllllllllllIllIIIlIIlIIIlIIIIl = new int[lllllllllllllIllIIIlIIlIIIlIIlII];
        for (int lllllllllllllIllIIIlIIlIIIlIlIII = 0; lllllllllllllIllIIIlIIlIIIlIlIII < lllllllllllllIllIIIlIIlIIIlIIlII; ++lllllllllllllIllIIIlIIlIIIlIlIII) {
            lllllllllllllIllIIIlIIlIIIlIIIlI[lllllllllllllIllIIIlIIlIIIlIlIII] = lllllllllllllIllIIIlIIlIIIlIIIll.getUtf8Info(this.name(lllllllllllllIllIIIlIIlIIIlIlIII));
            lllllllllllllIllIIIlIIlIIIlIIIIl[lllllllllllllIllIIIlIIlIIIlIlIII] = this.accessFlags(lllllllllllllIllIIIlIIlIIIlIlIII);
        }
        return new MethodParametersAttribute(lllllllllllllIllIIIlIIlIIIIlllll, lllllllllllllIllIIIlIIlIIIlIIIlI, lllllllllllllIllIIIlIIlIIIlIIIIl);
    }
    
    public String parameterName(final int lllllllllllllIllIIIlIIlIIIllIllI) {
        return this.getConstPool().getUtf8Info(this.name(lllllllllllllIllIIIlIIlIIIllIllI));
    }
    
    MethodParametersAttribute(final ConstPool lllllllllllllIllIIIlIIlIIlIlllIl, final int lllllllllllllIllIIIlIIlIIlIlllII, final DataInputStream lllllllllllllIllIIIlIIlIIlIlIlll) throws IOException {
        super(lllllllllllllIllIIIlIIlIIlIlllIl, lllllllllllllIllIIIlIIlIIlIlllII, lllllllllllllIllIIIlIIlIIlIlIlll);
    }
    
    public int name(final int lllllllllllllIllIIIlIIlIIIllllII) {
        return ByteArray.readU16bit(this.info, lllllllllllllIllIIIlIIlIIIllllII * 4 + 1);
    }
    
    static {
        tag = "MethodParameters";
    }
    
    public int accessFlags(final int lllllllllllllIllIIIlIIlIIIllIIII) {
        return ByteArray.readU16bit(this.info, lllllllllllllIllIIIlIIlIIIllIIII * 4 + 3);
    }
    
    public int size() {
        return this.info[0] & 0xFF;
    }
    
    public MethodParametersAttribute(final ConstPool lllllllllllllIllIIIlIIlIIlIIlllI, final String[] lllllllllllllIllIIIlIIlIIlIIlIII, final int[] lllllllllllllIllIIIlIIlIIlIIIlll) {
        super(lllllllllllllIllIIIlIIlIIlIIlllI, "MethodParameters");
        final byte[] lllllllllllllIllIIIlIIlIIlIIlIll = new byte[lllllllllllllIllIIIlIIlIIlIIlIII.length * 4 + 1];
        lllllllllllllIllIIIlIIlIIlIIlIll[0] = (byte)lllllllllllllIllIIIlIIlIIlIIlIII.length;
        for (int lllllllllllllIllIIIlIIlIIlIlIIII = 0; lllllllllllllIllIIIlIIlIIlIlIIII < lllllllllllllIllIIIlIIlIIlIIlIII.length; ++lllllllllllllIllIIIlIIlIIlIlIIII) {
            ByteArray.write16bit(lllllllllllllIllIIIlIIlIIlIIlllI.addUtf8Info(lllllllllllllIllIIIlIIlIIlIIlIII[lllllllllllllIllIIIlIIlIIlIlIIII]), lllllllllllllIllIIIlIIlIIlIIlIll, lllllllllllllIllIIIlIIlIIlIlIIII * 4 + 1);
            ByteArray.write16bit(lllllllllllllIllIIIlIIlIIlIIIlll[lllllllllllllIllIIIlIIlIIlIlIIII], lllllllllllllIllIIIlIIlIIlIIlIll, lllllllllllllIllIIIlIIlIIlIlIIII * 4 + 3);
        }
        this.set(lllllllllllllIllIIIlIIlIIlIIlIll);
    }
}
