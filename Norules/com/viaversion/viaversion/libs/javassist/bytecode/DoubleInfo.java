package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

class DoubleInfo extends ConstInfo
{
    /* synthetic */ double value;
    
    @Override
    public void print(final PrintWriter lllllllllllllIIIIIIIIlllIIIIIlII) {
        lllllllllllllIIIIIIIIlllIIIIIlII.print("Double ");
        lllllllllllllIIIIIIIIlllIIIIIlII.println(this.value);
    }
    
    public DoubleInfo(final DataInputStream lllllllllllllIIIIIIIIlllIIlIlIIl, final int lllllllllllllIIIIIIIIlllIIlIIlIl) throws IOException {
        super(lllllllllllllIIIIIIIIlllIIlIIlIl);
        this.value = lllllllllllllIIIIIIIIlllIIlIlIIl.readDouble();
    }
    
    static {
        tag = 6;
    }
    
    public DoubleInfo(final double lllllllllllllIIIIIIIIlllIIlIllll, final int lllllllllllllIIIIIIIIlllIIllIIIl) {
        super(lllllllllllllIIIIIIIIlllIIllIIIl);
        this.value = lllllllllllllIIIIIIIIlllIIlIllll;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIIIIIlllIIIllIIl) {
        return lllllllllllllIIIIIIIIlllIIIllIIl instanceof DoubleInfo && ((DoubleInfo)lllllllllllllIIIIIIIIlllIIIllIIl).value == this.value;
    }
    
    @Override
    public void write(final DataOutputStream lllllllllllllIIIIIIIIlllIIIIlIlI) throws IOException {
        lllllllllllllIIIIIIIIlllIIIIlIlI.writeByte(6);
        lllllllllllllIIIIIIIIlllIIIIlIlI.writeDouble(this.value);
    }
    
    @Override
    public int hashCode() {
        final long lllllllllllllIIIIIIIIlllIIlIIIIl = Double.doubleToLongBits(this.value);
        return (int)(lllllllllllllIIIIIIIIlllIIlIIIIl ^ lllllllllllllIIIIIIIIlllIIlIIIIl >>> 32);
    }
    
    @Override
    public int copy(final ConstPool lllllllllllllIIIIIIIIlllIIIlIlII, final ConstPool lllllllllllllIIIIIIIIlllIIIlIIll, final Map<String, String> lllllllllllllIIIIIIIIlllIIIlIIlI) {
        return lllllllllllllIIIIIIIIlllIIIlIIll.addDoubleInfo(this.value);
    }
    
    @Override
    public int getTag() {
        return 6;
    }
}
