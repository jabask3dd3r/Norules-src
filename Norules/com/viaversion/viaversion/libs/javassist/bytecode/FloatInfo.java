package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

class FloatInfo extends ConstInfo
{
    /* synthetic */ float value;
    
    @Override
    public void write(final DataOutputStream llllllllllllllIIllIlllIllIIlIIlI) throws IOException {
        llllllllllllllIIllIlllIllIIlIIlI.writeByte(4);
        llllllllllllllIIllIlllIllIIlIIlI.writeFloat(this.value);
    }
    
    @Override
    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }
    
    @Override
    public void print(final PrintWriter llllllllllllllIIllIlllIllIIIllII) {
        llllllllllllllIIllIlllIllIIIllII.print("Float ");
        llllllllllllllIIllIlllIllIIIllII.println(this.value);
    }
    
    public FloatInfo(final DataInputStream llllllllllllllIIllIlllIllIlIlllI, final int llllllllllllllIIllIlllIllIlIlIlI) throws IOException {
        super(llllllllllllllIIllIlllIllIlIlIlI);
        this.value = llllllllllllllIIllIlllIllIlIlllI.readFloat();
    }
    
    static {
        tag = 4;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIllIlllIllIlIIIIl) {
        return llllllllllllllIIllIlllIllIlIIIIl instanceof FloatInfo && ((FloatInfo)llllllllllllllIIllIlllIllIlIIIIl).value == this.value;
    }
    
    public FloatInfo(final float llllllllllllllIIllIlllIllIllIlII, final int llllllllllllllIIllIlllIllIllIIll) {
        super(llllllllllllllIIllIlllIllIllIIll);
        this.value = llllllllllllllIIllIlllIllIllIlII;
    }
    
    @Override
    public int copy(final ConstPool llllllllllllllIIllIlllIllIIlllII, final ConstPool llllllllllllllIIllIlllIllIIllIII, final Map<String, String> llllllllllllllIIllIlllIllIIllIlI) {
        return llllllllllllllIIllIlllIllIIllIII.addFloatInfo(this.value);
    }
    
    @Override
    public int getTag() {
        return 4;
    }
}
