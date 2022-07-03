package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class EnclosingMethodAttribute extends AttributeInfo
{
    public String className() {
        return this.getConstPool().getClassInfo(this.classIndex());
    }
    
    static {
        tag = "EnclosingMethod";
    }
    
    public String methodDescriptor() {
        final ConstPool llllllllllllllIlIlIlIlIlllIIIllI = this.getConstPool();
        final int llllllllllllllIlIlIlIlIlllIIIlIl = this.methodIndex();
        final int llllllllllllllIlIlIlIlIlllIIIlII = llllllllllllllIlIlIlIlIlllIIIllI.getNameAndTypeDescriptor(llllllllllllllIlIlIlIlIlllIIIlIl);
        return llllllllllllllIlIlIlIlIlllIIIllI.getUtf8Info(llllllllllllllIlIlIlIlIlllIIIlII);
    }
    
    public String methodName() {
        final ConstPool llllllllllllllIlIlIlIlIlllIlIlll = this.getConstPool();
        final int llllllllllllllIlIlIlIlIlllIlIlIl = this.methodIndex();
        if (llllllllllllllIlIlIlIlIlllIlIlIl == 0) {
            return "<clinit>";
        }
        final int llllllllllllllIlIlIlIlIlllIlIIll = llllllllllllllIlIlIlIlIlllIlIlll.getNameAndTypeName(llllllllllllllIlIlIlIlIlllIlIlIl);
        return llllllllllllllIlIlIlIlIlllIlIlll.getUtf8Info(llllllllllllllIlIlIlIlIlllIlIIll);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllIlIlIlIlIllIlllIIl, final Map<String, String> llllllllllllllIlIlIlIlIllIlllIll) {
        if (this.methodIndex() == 0) {
            return new EnclosingMethodAttribute(llllllllllllllIlIlIlIlIllIlllIIl, this.className());
        }
        return new EnclosingMethodAttribute(llllllllllllllIlIlIlIlIllIlllIIl, this.className(), this.methodName(), this.methodDescriptor());
    }
    
    public int methodIndex() {
        return ByteArray.readU16bit(this.get(), 2);
    }
    
    public EnclosingMethodAttribute(final ConstPool llllllllllllllIlIlIlIlIlllllIIII, final String llllllllllllllIlIlIlIlIlllllIlIl) {
        super(llllllllllllllIlIlIlIlIlllllIIII, "EnclosingMethod");
        final int llllllllllllllIlIlIlIlIlllllIlII = llllllllllllllIlIlIlIlIlllllIIII.addClassInfo(llllllllllllllIlIlIlIlIlllllIlIl);
        final int llllllllllllllIlIlIlIlIlllllIIll = 0;
        final byte[] llllllllllllllIlIlIlIlIlllllIIlI = { (byte)(llllllllllllllIlIlIlIlIlllllIlII >>> 8), (byte)llllllllllllllIlIlIlIlIlllllIlII, (byte)(llllllllllllllIlIlIlIlIlllllIIll >>> 8), (byte)llllllllllllllIlIlIlIlIlllllIIll };
        this.set(llllllllllllllIlIlIlIlIlllllIIlI);
    }
    
    public int classIndex() {
        return ByteArray.readU16bit(this.get(), 0);
    }
    
    public EnclosingMethodAttribute(final ConstPool llllllllllllllIlIlIlIllIIIIIIlII, final String llllllllllllllIlIlIlIllIIIIIIIll, final String llllllllllllllIlIlIlIllIIIIIIIlI, final String llllllllllllllIlIlIlIllIIIIIIIIl) {
        super(llllllllllllllIlIlIlIllIIIIIIlII, "EnclosingMethod");
        final int llllllllllllllIlIlIlIllIIIIIlIII = llllllllllllllIlIlIlIllIIIIIIlII.addClassInfo(llllllllllllllIlIlIlIllIIIIIIIll);
        final int llllllllllllllIlIlIlIllIIIIIIlll = llllllllllllllIlIlIlIllIIIIIIlII.addNameAndTypeInfo(llllllllllllllIlIlIlIllIIIIIIIlI, llllllllllllllIlIlIlIllIIIIIIIIl);
        final byte[] llllllllllllllIlIlIlIllIIIIIIllI = { (byte)(llllllllllllllIlIlIlIllIIIIIlIII >>> 8), (byte)llllllllllllllIlIlIlIllIIIIIlIII, (byte)(llllllllllllllIlIlIlIllIIIIIIlll >>> 8), (byte)llllllllllllllIlIlIlIllIIIIIIlll };
        this.set(llllllllllllllIlIlIlIllIIIIIIllI);
    }
    
    EnclosingMethodAttribute(final ConstPool llllllllllllllIlIlIlIllIIIIllIII, final int llllllllllllllIlIlIlIllIIIIllIll, final DataInputStream llllllllllllllIlIlIlIllIIIIlIllI) throws IOException {
        super(llllllllllllllIlIlIlIllIIIIllIII, llllllllllllllIlIlIlIllIIIIllIll, llllllllllllllIlIlIlIllIIIIlIllI);
    }
}
