package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

abstract class MemberrefInfo extends ConstInfo
{
    /* synthetic */ int nameAndTypeIndex;
    /* synthetic */ int classIndex;
    
    @Override
    public int hashCode() {
        return this.classIndex << 16 ^ this.nameAndTypeIndex;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIIIlIIIllIIIllIlI) {
        if (llllllllllllllIIIIlIIIllIIIllIlI instanceof MemberrefInfo) {
            final MemberrefInfo llllllllllllllIIIIlIIIllIIIlllII = (MemberrefInfo)llllllllllllllIIIIlIIIllIIIllIlI;
            return llllllllllllllIIIIlIIIllIIIlllII.classIndex == this.classIndex && llllllllllllllIIIIlIIIllIIIlllII.nameAndTypeIndex == this.nameAndTypeIndex && llllllllllllllIIIIlIIIllIIIlllII.getClass() == this.getClass();
        }
        return false;
    }
    
    @Override
    public void write(final DataOutputStream llllllllllllllIIIIlIIIlIlllIllll) throws IOException {
        llllllllllllllIIIIlIIIlIlllIllll.writeByte(this.getTag());
        llllllllllllllIIIIlIIIlIlllIllll.writeShort(this.classIndex);
        llllllllllllllIIIIlIIIlIlllIllll.writeShort(this.nameAndTypeIndex);
    }
    
    public MemberrefInfo(final DataInputStream llllllllllllllIIIIlIIIllIIllIlII, final int llllllllllllllIIIIlIIIllIIllIIlI) throws IOException {
        super(llllllllllllllIIIIlIIIllIIllIIlI);
        this.classIndex = llllllllllllllIIIIlIIIllIIllIlII.readUnsignedShort();
        this.nameAndTypeIndex = llllllllllllllIIIIlIIIllIIllIlII.readUnsignedShort();
    }
    
    protected abstract int copy2(final ConstPool p0, final int p1, final int p2);
    
    public MemberrefInfo(final int llllllllllllllIIIIlIIIllIlIIIlll, final int llllllllllllllIIIIlIIIllIlIIllII, final int llllllllllllllIIIIlIIIllIlIIIIll) {
        super(llllllllllllllIIIIlIIIllIlIIIIll);
        this.classIndex = llllllllllllllIIIIlIIIllIlIIIlll;
        this.nameAndTypeIndex = llllllllllllllIIIIlIIIllIlIIllII;
    }
    
    public abstract String getTagName();
    
    @Override
    public int copy(final ConstPool llllllllllllllIIIIlIIIllIIIIIlII, final ConstPool llllllllllllllIIIIlIIIllIIIIIIlI, final Map<String, String> llllllllllllllIIIIlIIIlIlllllIII) {
        final int llllllllllllllIIIIlIIIlIlllllllI = llllllllllllllIIIIlIIIllIIIIIlII.getItem(this.classIndex).copy(llllllllllllllIIIIlIIIllIIIIIlII, llllllllllllllIIIIlIIIllIIIIIIlI, llllllllllllllIIIIlIIIlIlllllIII);
        final int llllllllllllllIIIIlIIIlIllllllII = llllllllllllllIIIIlIIIllIIIIIlII.getItem(this.nameAndTypeIndex).copy(llllllllllllllIIIIlIIIllIIIIIlII, llllllllllllllIIIIlIIIllIIIIIIlI, llllllllllllllIIIIlIIIlIlllllIII);
        return this.copy2(llllllllllllllIIIIlIIIllIIIIIIlI, llllllllllllllIIIIlIIIlIlllllllI, llllllllllllllIIIIlIIIlIllllllII);
    }
    
    @Override
    public void print(final PrintWriter llllllllllllllIIIIlIIIlIllIlllll) {
        llllllllllllllIIIIlIIIlIllIlllll.print(String.valueOf(new StringBuilder().append(this.getTagName()).append(" #")));
        llllllllllllllIIIIlIIIlIllIlllll.print(this.classIndex);
        llllllllllllllIIIIlIIIlIllIlllll.print(", name&type #");
        llllllllllllllIIIIlIIIlIllIlllll.println(this.nameAndTypeIndex);
    }
}
