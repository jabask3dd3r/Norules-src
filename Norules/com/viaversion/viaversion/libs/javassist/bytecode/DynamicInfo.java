package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

class DynamicInfo extends ConstInfo
{
    /* synthetic */ int nameAndType;
    /* synthetic */ int bootstrap;
    
    static {
        tag = 17;
    }
    
    public DynamicInfo(final DataInputStream llllIIIlIlII, final int llllIIIlIllI) throws IOException {
        super(llllIIIlIllI);
        this.bootstrap = llllIIIlIlII.readUnsignedShort();
        this.nameAndType = llllIIIlIlII.readUnsignedShort();
    }
    
    @Override
    public void write(final DataOutputStream lllIllllIllI) throws IOException {
        lllIllllIllI.writeByte(17);
        lllIllllIllI.writeShort(this.bootstrap);
        lllIllllIllI.writeShort(this.nameAndType);
    }
    
    public DynamicInfo(final int llllIIIllllI, final int llllIIlIIIIl, final int llllIIlIIIII) {
        super(llllIIlIIIII);
        this.bootstrap = llllIIIllllI;
        this.nameAndType = llllIIlIIIIl;
    }
    
    @Override
    public int hashCode() {
        return this.bootstrap << 16 ^ this.nameAndType;
    }
    
    @Override
    public int getTag() {
        return 17;
    }
    
    @Override
    public void print(final PrintWriter lllIlllIlllI) {
        lllIlllIlllI.print("Dynamic #");
        lllIlllIlllI.print(this.bootstrap);
        lllIlllIlllI.print(", name&type #");
        lllIlllIlllI.println(this.nameAndType);
    }
    
    @Override
    public int copy(final ConstPool llllIIIIIIII, final ConstPool lllIlllllIll, final Map<String, String> lllIlllllIlI) {
        return lllIlllllIll.addDynamicInfo(this.bootstrap, llllIIIIIIII.getItem(this.nameAndType).copy(llllIIIIIIII, lllIlllllIll, lllIlllllIlI));
    }
    
    @Override
    public boolean equals(final Object llllIIIIlIlI) {
        if (llllIIIIlIlI instanceof DynamicInfo) {
            final DynamicInfo llllIIIIllII = (DynamicInfo)llllIIIIlIlI;
            return llllIIIIllII.bootstrap == this.bootstrap && llllIIIIllII.nameAndType == this.nameAndType;
        }
        return false;
    }
}
