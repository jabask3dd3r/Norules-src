package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class NameAndTypeInfo extends ConstInfo
{
    /* synthetic */ int typeDescriptor;
    /* synthetic */ int memberName;
    
    static {
        tag = 12;
    }
    
    public NameAndTypeInfo(final DataInputStream lllllllllllllllllIllllIIlIlIlIll, final int lllllllllllllllllIllllIIlIlIllIl) throws IOException {
        super(lllllllllllllllllIllllIIlIlIllIl);
        this.memberName = lllllllllllllllllIllllIIlIlIlIll.readUnsignedShort();
        this.typeDescriptor = lllllllllllllllllIllllIIlIlIlIll.readUnsignedShort();
    }
    
    @Override
    public int copy(final ConstPool lllllllllllllllllIllllIIIllIlllI, final ConstPool lllllllllllllllllIllllIIIllIIlll, final Map<String, String> lllllllllllllllllIllllIIIllIllII) {
        final String lllllllllllllllllIllllIIIllIlIll = lllllllllllllllllIllllIIIllIlllI.getUtf8Info(this.memberName);
        String lllllllllllllllllIllllIIIllIlIlI = lllllllllllllllllIllllIIIllIlllI.getUtf8Info(this.typeDescriptor);
        lllllllllllllllllIllllIIIllIlIlI = Descriptor.rename(lllllllllllllllllIllllIIIllIlIlI, lllllllllllllllllIllllIIIllIllII);
        return lllllllllllllllllIllllIIIllIIlll.addNameAndTypeInfo(lllllllllllllllllIllllIIIllIIlll.addUtf8Info(lllllllllllllllllIllllIIIllIlIll), lllllllllllllllllIllllIIIllIIlll.addUtf8Info(lllllllllllllllllIllllIIIllIlIlI));
    }
    
    @Override
    public int hashCode() {
        return this.memberName << 16 ^ this.typeDescriptor;
    }
    
    @Override
    public void print(final PrintWriter lllllllllllllllllIllllIIIlIllIlI) {
        lllllllllllllllllIllllIIIlIllIlI.print("NameAndType #");
        lllllllllllllllllIllllIIIlIllIlI.print(this.memberName);
        lllllllllllllllllIllllIIIlIllIlI.print(", type #");
        lllllllllllllllllIllllIIIlIllIlI.println(this.typeDescriptor);
    }
    
    @Override
    public int getTag() {
        return 12;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllIllllIIlIlIIIIl) {
        if (lllllllllllllllllIllllIIlIlIIIIl instanceof NameAndTypeInfo) {
            final NameAndTypeInfo lllllllllllllllllIllllIIlIlIIIll = (NameAndTypeInfo)lllllllllllllllllIllllIIlIlIIIIl;
            return lllllllllllllllllIllllIIlIlIIIll.memberName == this.memberName && lllllllllllllllllIllllIIlIlIIIll.typeDescriptor == this.typeDescriptor;
        }
        return false;
    }
    
    @Override
    public void write(final DataOutputStream lllllllllllllllllIllllIIIllIIIII) throws IOException {
        lllllllllllllllllIllllIIIllIIIII.writeByte(12);
        lllllllllllllllllIllllIIIllIIIII.writeShort(this.memberName);
        lllllllllllllllllIllllIIIllIIIII.writeShort(this.typeDescriptor);
    }
    
    public NameAndTypeInfo(final int lllllllllllllllllIllllIIlIlllIIl, final int lllllllllllllllllIllllIIlIllIlII, final int lllllllllllllllllIllllIIlIllIlll) {
        super(lllllllllllllllllIllllIIlIllIlll);
        this.memberName = lllllllllllllllllIllllIIlIlllIIl;
        this.typeDescriptor = lllllllllllllllllIllllIIlIllIlII;
    }
    
    @Override
    public void renameClass(final ConstPool lllllllllllllllllIllllIIlIIIllIl, final String lllllllllllllllllIllllIIlIIIllII, final String lllllllllllllllllIllllIIlIIlIIlI, final Map<ConstInfo, ConstInfo> lllllllllllllllllIllllIIlIIIlIlI) {
        final String lllllllllllllllllIllllIIlIIlIIII = lllllllllllllllllIllllIIlIIIllIl.getUtf8Info(this.typeDescriptor);
        final String lllllllllllllllllIllllIIlIIIllll = Descriptor.rename(lllllllllllllllllIllllIIlIIlIIII, lllllllllllllllllIllllIIlIIIllII, lllllllllllllllllIllllIIlIIlIIlI);
        if (lllllllllllllllllIllllIIlIIlIIII != lllllllllllllllllIllllIIlIIIllll) {
            if (lllllllllllllllllIllllIIlIIIlIlI == null) {
                this.typeDescriptor = lllllllllllllllllIllllIIlIIIllIl.addUtf8Info(lllllllllllllllllIllllIIlIIIllll);
            }
            else {
                lllllllllllllllllIllllIIlIIIlIlI.remove(this);
                this.typeDescriptor = lllllllllllllllllIllllIIlIIIllIl.addUtf8Info(lllllllllllllllllIllllIIlIIIllll);
                lllllllllllllllllIllllIIlIIIlIlI.put(this, this);
            }
        }
    }
    
    @Override
    public void renameClass(final ConstPool lllllllllllllllllIllllIIIllllIlI, final Map<String, String> lllllllllllllllllIllllIIIllllIIl, final Map<ConstInfo, ConstInfo> lllllllllllllllllIllllIIIllllllI) {
        final String lllllllllllllllllIllllIIIlllllIl = lllllllllllllllllIllllIIIllllIlI.getUtf8Info(this.typeDescriptor);
        final String lllllllllllllllllIllllIIIlllllII = Descriptor.rename(lllllllllllllllllIllllIIIlllllIl, lllllllllllllllllIllllIIIllllIIl);
        if (lllllllllllllllllIllllIIIlllllIl != lllllllllllllllllIllllIIIlllllII) {
            if (lllllllllllllllllIllllIIIllllllI == null) {
                this.typeDescriptor = lllllllllllllllllIllllIIIllllIlI.addUtf8Info(lllllllllllllllllIllllIIIlllllII);
            }
            else {
                lllllllllllllllllIllllIIIllllllI.remove(this);
                this.typeDescriptor = lllllllllllllllllIllllIIIllllIlI.addUtf8Info(lllllllllllllllllIllllIIIlllllII);
                lllllllllllllllllIllllIIIllllllI.put(this, this);
            }
        }
    }
}
