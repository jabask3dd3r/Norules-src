package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class InvokeDynamicInfo extends ConstInfo
{
    /* synthetic */ int bootstrap;
    /* synthetic */ int nameAndType;
    
    public InvokeDynamicInfo(final int lIlllIlIIlllII, final int lIlllIlIIlIlll, final int lIlllIlIIlIllI) {
        super(lIlllIlIIlIllI);
        this.bootstrap = lIlllIlIIlllII;
        this.nameAndType = lIlllIlIIlIlll;
    }
    
    @Override
    public boolean equals(final Object lIlllIlIIIIIlI) {
        if (lIlllIlIIIIIlI instanceof InvokeDynamicInfo) {
            final InvokeDynamicInfo lIlllIlIIIIllI = (InvokeDynamicInfo)lIlllIlIIIIIlI;
            return lIlllIlIIIIllI.bootstrap == this.bootstrap && lIlllIlIIIIllI.nameAndType == this.nameAndType;
        }
        return false;
    }
    
    static {
        tag = 18;
    }
    
    @Override
    public int getTag() {
        return 18;
    }
    
    public InvokeDynamicInfo(final DataInputStream lIlllIlIIIlllI, final int lIlllIlIIlIIII) throws IOException {
        super(lIlllIlIIlIIII);
        this.bootstrap = lIlllIlIIIlllI.readUnsignedShort();
        this.nameAndType = lIlllIlIIIlllI.readUnsignedShort();
    }
    
    @Override
    public void print(final PrintWriter lIlllIIllIlIlI) {
        lIlllIIllIlIlI.print("InvokeDynamic #");
        lIlllIIllIlIlI.print(this.bootstrap);
        lIlllIIllIlIlI.print(", name&type #");
        lIlllIIllIlIlI.println(this.nameAndType);
    }
    
    @Override
    public int hashCode() {
        return this.bootstrap << 16 ^ this.nameAndType;
    }
    
    @Override
    public int copy(final ConstPool lIlllIIllllIlI, final ConstPool lIlllIIlllIlIl, final Map<String, String> lIlllIIllllIII) {
        return lIlllIIlllIlIl.addInvokeDynamicInfo(this.bootstrap, lIlllIIllllIlI.getItem(this.nameAndType).copy(lIlllIIllllIlI, lIlllIIlllIlIl, lIlllIIllllIII));
    }
    
    @Override
    public void write(final DataOutputStream lIlllIIlllIIII) throws IOException {
        lIlllIIlllIIII.writeByte(18);
        lIlllIIlllIIII.writeShort(this.bootstrap);
        lIlllIIlllIIII.writeShort(this.nameAndType);
    }
}
