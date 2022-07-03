package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class NestMembersAttribute extends AttributeInfo
{
    public int numberOfClasses() {
        return ByteArray.readU16bit(this.info, 0);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllllIllIlllIllIIIlll, final Map<String, String> llllllllllllllllIllIlllIllIIIllI) {
        final byte[] llllllllllllllllIllIlllIllIIllII = this.get();
        final byte[] llllllllllllllllIllIlllIllIIlIll = new byte[llllllllllllllllIllIlllIllIIllII.length];
        final ConstPool llllllllllllllllIllIlllIllIIlIlI = this.getConstPool();
        final int llllllllllllllllIllIlllIllIIlIIl = ByteArray.readU16bit(llllllllllllllllIllIlllIllIIllII, 0);
        ByteArray.write16bit(llllllllllllllllIllIlllIllIIlIIl, llllllllllllllllIllIlllIllIIlIll, 0);
        for (int llllllllllllllllIllIlllIllIlIIIl = 0, llllllllllllllllIllIlllIllIlIIII = 2; llllllllllllllllIllIlllIllIlIIIl < llllllllllllllllIllIlllIllIIlIIl; ++llllllllllllllllIllIlllIllIlIIIl, llllllllllllllllIllIlllIllIlIIII += 2) {
            final int llllllllllllllllIllIlllIllIlIIll = ByteArray.readU16bit(llllllllllllllllIllIlllIllIIllII, llllllllllllllllIllIlllIllIlIIII);
            final int llllllllllllllllIllIlllIllIlIIlI = llllllllllllllllIllIlllIllIIlIlI.copy(llllllllllllllllIllIlllIllIlIIll, llllllllllllllllIllIlllIllIIIlll, llllllllllllllllIllIlllIllIIIllI);
            ByteArray.write16bit(llllllllllllllllIllIlllIllIlIIlI, llllllllllllllllIllIlllIllIIlIll, llllllllllllllllIllIlllIllIlIIII);
        }
        return new NestMembersAttribute(llllllllllllllllIllIlllIllIIIlll, llllllllllllllllIllIlllIllIIlIll);
    }
    
    public int memberClass(final int llllllllllllllllIllIlllIlIllIlll) {
        return ByteArray.readU16bit(this.info, llllllllllllllllIllIlllIlIllIlll * 2 + 2);
    }
    
    NestMembersAttribute(final ConstPool llllllllllllllllIllIlllIlllIlllI, final int llllllllllllllllIllIlllIlllIlIIl, final DataInputStream llllllllllllllllIllIlllIlllIlIII) throws IOException {
        super(llllllllllllllllIllIlllIlllIlllI, llllllllllllllllIllIlllIlllIlIIl, llllllllllllllllIllIlllIlllIlIII);
    }
    
    private NestMembersAttribute(final ConstPool llllllllllllllllIllIlllIlllIIIll, final byte[] llllllllllllllllIllIlllIlllIIIlI) {
        super(llllllllllllllllIllIlllIlllIIIll, "NestMembers", llllllllllllllllIllIlllIlllIIIlI);
    }
    
    static {
        tag = "NestMembers";
    }
}
