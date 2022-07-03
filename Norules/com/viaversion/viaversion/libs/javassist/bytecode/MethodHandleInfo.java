package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

class MethodHandleInfo extends ConstInfo
{
    /* synthetic */ int refKind;
    /* synthetic */ int refIndex;
    
    static {
        tag = 15;
    }
    
    @Override
    public void print(final PrintWriter llIlIIIIlIlIIll) {
        llIlIIIIlIlIIll.print("MethodHandle #");
        llIlIIIIlIlIIll.print(this.refKind);
        llIlIIIIlIlIIll.print(", index #");
        llIlIIIIlIlIIll.println(this.refIndex);
    }
    
    public MethodHandleInfo(final DataInputStream llIlIIIIlllIlll, final int llIlIIIIllllIIl) throws IOException {
        super(llIlIIIIllllIIl);
        this.refKind = llIlIIIIlllIlll.readUnsignedByte();
        this.refIndex = llIlIIIIlllIlll.readUnsignedShort();
    }
    
    public MethodHandleInfo(final int llIlIIIlIIIIlIl, final int llIlIIIlIIIIlII, final int llIlIIIlIIIIIll) {
        super(llIlIIIlIIIIIll);
        this.refKind = llIlIIIlIIIIlIl;
        this.refIndex = llIlIIIlIIIIlII;
    }
    
    @Override
    public boolean equals(final Object llIlIIIIllIlIll) {
        if (llIlIIIIllIlIll instanceof MethodHandleInfo) {
            final MethodHandleInfo llIlIIIIllIllll = (MethodHandleInfo)llIlIIIIllIlIll;
            return llIlIIIIllIllll.refKind == this.refKind && llIlIIIIllIllll.refIndex == this.refIndex;
        }
        return false;
    }
    
    @Override
    public void write(final DataOutputStream llIlIIIIlIlIlll) throws IOException {
        llIlIIIIlIlIlll.writeByte(15);
        llIlIIIIlIlIlll.writeByte(this.refKind);
        llIlIIIIlIlIlll.writeShort(this.refIndex);
    }
    
    @Override
    public int copy(final ConstPool llIlIIIIllIIIll, final ConstPool llIlIIIIllIIIlI, final Map<String, String> llIlIIIIlIlllIl) {
        return llIlIIIIllIIIlI.addMethodHandleInfo(this.refKind, llIlIIIIllIIIll.getItem(this.refIndex).copy(llIlIIIIllIIIll, llIlIIIIllIIIlI, llIlIIIIlIlllIl));
    }
    
    @Override
    public int getTag() {
        return 15;
    }
    
    @Override
    public int hashCode() {
        return this.refKind << 16 ^ this.refIndex;
    }
}
