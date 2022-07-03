package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class LongInfo extends ConstInfo
{
    /* synthetic */ long value;
    
    @Override
    public int copy(final ConstPool lllllllllllllIIIIlllllllIlIlIllI, final ConstPool lllllllllllllIIIIlllllllIlIlIIlI, final Map<String, String> lllllllllllllIIIIlllllllIlIlIlII) {
        return lllllllllllllIIIIlllllllIlIlIIlI.addLongInfo(this.value);
    }
    
    @Override
    public void print(final PrintWriter lllllllllllllIIIIlllllllIlIIlIII) {
        lllllllllllllIIIIlllllllIlIIlIII.print("Long ");
        lllllllllllllIIIIlllllllIlIIlIII.println(this.value);
    }
    
    public LongInfo(final long lllllllllllllIIIIlllllllIllIlllI, final int lllllllllllllIIIIlllllllIllIllIl) {
        super(lllllllllllllIIIIlllllllIllIllIl);
        this.value = lllllllllllllIIIIlllllllIllIlllI;
    }
    
    public LongInfo(final DataInputStream lllllllllllllIIIIlllllllIllIlIII, final int lllllllllllllIIIIlllllllIllIIlII) throws IOException {
        super(lllllllllllllIIIIlllllllIllIIlII);
        this.value = lllllllllllllIIIIlllllllIllIlIII.readLong();
    }
    
    @Override
    public int getTag() {
        return 5;
    }
    
    @Override
    public int hashCode() {
        return (int)(this.value ^ this.value >>> 32);
    }
    
    @Override
    public void write(final DataOutputStream lllllllllllllIIIIlllllllIlIIlllI) throws IOException {
        lllllllllllllIIIIlllllllIlIIlllI.writeByte(5);
        lllllllllllllIIIIlllllllIlIIlllI.writeLong(this.value);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIlllllllIlIlllIl) {
        return lllllllllllllIIIIlllllllIlIlllIl instanceof LongInfo && ((LongInfo)lllllllllllllIIIIlllllllIlIlllIl).value == this.value;
    }
    
    static {
        tag = 5;
    }
}
