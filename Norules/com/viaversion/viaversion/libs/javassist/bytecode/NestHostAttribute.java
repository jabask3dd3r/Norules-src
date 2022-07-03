package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class NestHostAttribute extends AttributeInfo
{
    public int hostClassIndex() {
        return ByteArray.readU16bit(this.info, 0);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllllllIlIIllIlIIIllI, final Map<String, String> llllllllllllllllllIlIIllIlIIlIlI) {
        final int llllllllllllllllllIlIIllIlIIlIIl = ByteArray.readU16bit(this.get(), 0);
        final int llllllllllllllllllIlIIllIlIIlIII = this.getConstPool().copy(llllllllllllllllllIlIIllIlIIlIIl, llllllllllllllllllIlIIllIlIIIllI, llllllllllllllllllIlIIllIlIIlIlI);
        return new NestHostAttribute(llllllllllllllllllIlIIllIlIIIllI, llllllllllllllllllIlIIllIlIIlIII);
    }
    
    static {
        tag = "NestHost";
    }
    
    private NestHostAttribute(final ConstPool llllllllllllllllllIlIIllIlIlIIll, final int llllllllllllllllllIlIIllIlIlIlIl) {
        super(llllllllllllllllllIlIIllIlIlIIll, "NestHost", new byte[2]);
        ByteArray.write16bit(llllllllllllllllllIlIIllIlIlIlIl, this.get(), 0);
    }
    
    NestHostAttribute(final ConstPool llllllllllllllllllIlIIllIllIIIIl, final int llllllllllllllllllIlIIllIlIlllII, final DataInputStream llllllllllllllllllIlIIllIlIllIll) throws IOException {
        super(llllllllllllllllllIlIIllIllIIIIl, llllllllllllllllllIlIIllIlIlllII, llllllllllllllllllIlIIllIlIllIll);
    }
}
