package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class MethodTypeInfo extends ConstInfo
{
    /* synthetic */ int descriptor;
    
    @Override
    public void renameClass(final ConstPool lllllllllllllIlllIlIlllllIlIIIII, final Map<String, String> lllllllllllllIlllIlIlllllIIlllll, final Map<ConstInfo, ConstInfo> lllllllllllllIlllIlIlllllIIllllI) {
        final String lllllllllllllIlllIlIlllllIIlllII = lllllllllllllIlllIlIlllllIlIIIII.getUtf8Info(this.descriptor);
        final String lllllllllllllIlllIlIlllllIIllIlI = Descriptor.rename(lllllllllllllIlllIlIlllllIIlllII, lllllllllllllIlllIlIlllllIIlllll);
        if (lllllllllllllIlllIlIlllllIIlllII != lllllllllllllIlllIlIlllllIIllIlI) {
            if (lllllllllllllIlllIlIlllllIIllllI == null) {
                this.descriptor = lllllllllllllIlllIlIlllllIlIIIII.addUtf8Info(lllllllllllllIlllIlIlllllIIllIlI);
            }
            else {
                lllllllllllllIlllIlIlllllIIllllI.remove(this);
                this.descriptor = lllllllllllllIlllIlIlllllIlIIIII.addUtf8Info(lllllllllllllIlllIlIlllllIIllIlI);
                lllllllllllllIlllIlIlllllIIllllI.put(this, this);
            }
        }
    }
    
    static {
        tag = 16;
    }
    
    public MethodTypeInfo(final DataInputStream lllllllllllllIlllIlIllllllllllII, final int lllllllllllllIlllIlIlllllllllIll) throws IOException {
        super(lllllllllllllIlllIlIlllllllllIll);
        this.descriptor = lllllllllllllIlllIlIllllllllllII.readUnsignedShort();
    }
    
    @Override
    public int hashCode() {
        return this.descriptor;
    }
    
    @Override
    public int getTag() {
        return 16;
    }
    
    @Override
    public void write(final DataOutputStream lllllllllllllIlllIlIllllIllIIlIl) throws IOException {
        lllllllllllllIlllIlIllllIllIIlIl.writeByte(16);
        lllllllllllllIlllIlIllllIllIIlIl.writeShort(this.descriptor);
    }
    
    @Override
    public void renameClass(final ConstPool lllllllllllllIlllIlIlllllIllllIl, final String lllllllllllllIlllIlIlllllIlllIll, final String lllllllllllllIlllIlIllllllIIIllI, final Map<ConstInfo, ConstInfo> lllllllllllllIlllIlIllllllIIIlII) {
        final String lllllllllllllIlllIlIllllllIIIIlI = lllllllllllllIlllIlIlllllIllllIl.getUtf8Info(this.descriptor);
        final String lllllllllllllIlllIlIllllllIIIIIl = Descriptor.rename(lllllllllllllIlllIlIllllllIIIIlI, lllllllllllllIlllIlIlllllIlllIll, lllllllllllllIlllIlIllllllIIIllI);
        if (lllllllllllllIlllIlIllllllIIIIlI != lllllllllllllIlllIlIllllllIIIIIl) {
            if (lllllllllllllIlllIlIllllllIIIlII == null) {
                this.descriptor = lllllllllllllIlllIlIlllllIllllIl.addUtf8Info(lllllllllllllIlllIlIllllllIIIIIl);
            }
            else {
                lllllllllllllIlllIlIllllllIIIlII.remove(this);
                this.descriptor = lllllllllllllIlllIlIlllllIllllIl.addUtf8Info(lllllllllllllIlllIlIllllllIIIIIl);
                lllllllllllllIlllIlIllllllIIIlII.put(this, this);
            }
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIlIlllllllIIllI) {
        return lllllllllllllIlllIlIlllllllIIllI instanceof MethodTypeInfo && ((MethodTypeInfo)lllllllllllllIlllIlIlllllllIIllI).descriptor == this.descriptor;
    }
    
    public MethodTypeInfo(final int lllllllllllllIlllIllIIIIIIIIlllI, final int lllllllllllllIlllIllIIIIIIIIllII) {
        super(lllllllllllllIlllIllIIIIIIIIllII);
        this.descriptor = lllllllllllllIlllIllIIIIIIIIlllI;
    }
    
    @Override
    public void print(final PrintWriter lllllllllllllIlllIlIllllIlIlllII) {
        lllllllllllllIlllIlIllllIlIlllII.print("MethodType #");
        lllllllllllllIlllIlIllllIlIlllII.println(this.descriptor);
    }
    
    @Override
    public int copy(final ConstPool lllllllllllllIlllIlIllllIllllIII, final ConstPool lllllllllllllIlllIlIllllIlllllll, final Map<String, String> lllllllllllllIlllIlIllllIlllllIl) {
        String lllllllllllllIlllIlIllllIlllllII = lllllllllllllIlllIlIllllIllllIII.getUtf8Info(this.descriptor);
        lllllllllllllIlllIlIllllIlllllII = Descriptor.rename(lllllllllllllIlllIlIllllIlllllII, lllllllllllllIlllIlIllllIlllllIl);
        return lllllllllllllIlllIlIllllIlllllll.addMethodTypeInfo(lllllllllllllIlllIlIllllIlllllll.addUtf8Info(lllllllllllllIlllIlIllllIlllllII));
    }
}
