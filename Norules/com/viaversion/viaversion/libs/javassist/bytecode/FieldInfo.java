package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

public final class FieldInfo
{
    /* synthetic */ ConstPool constPool;
    /* synthetic */ int accessFlags;
    /* synthetic */ String cachedName;
    /* synthetic */ int name;
    /* synthetic */ int descriptor;
    /* synthetic */ List<AttributeInfo> attribute;
    
    public void setAccessFlags(final int lllllllllllllIlIlllIlIIIIIlIllIl) {
        this.accessFlags = lllllllllllllIlIlllIlIIIIIlIllIl;
    }
    
    public AttributeInfo removeAttribute(final String lllllllllllllIlIlllIlIIIIIIIllll) {
        return AttributeInfo.remove(this.attribute, lllllllllllllIlIlllIlIIIIIIIllll);
    }
    
    public AttributeInfo getAttribute(final String lllllllllllllIlIlllIlIIIIIIlIIll) {
        return AttributeInfo.lookup(this.attribute, lllllllllllllIlIlllIlIIIIIIlIIll);
    }
    
    void compact(final ConstPool lllllllllllllIlIlllIlIIIIlIlIlll) {
        this.name = lllllllllllllIlIlllIlIIIIlIlIlll.addUtf8Info(this.getName());
        this.descriptor = lllllllllllllIlIlllIlIIIIlIlIlll.addUtf8Info(this.getDescriptor());
        this.attribute = AttributeInfo.copyAll(this.attribute, lllllllllllllIlIlllIlIIIIlIlIlll);
        this.constPool = lllllllllllllIlIlllIlIIIIlIlIlll;
    }
    
    public String getDescriptor() {
        return this.constPool.getUtf8Info(this.descriptor);
    }
    
    FieldInfo(final ConstPool lllllllllllllIlIlllIlIIIIllIIIlI, final DataInputStream lllllllllllllIlIlllIlIIIIllIIIIl) throws IOException {
        this(lllllllllllllIlIlllIlIIIIllIIIlI);
        this.read(lllllllllllllIlIlllIlIIIIllIIIIl);
    }
    
    public String getName() {
        if (this.cachedName == null) {
            this.cachedName = this.constPool.getUtf8Info(this.name);
        }
        return this.cachedName;
    }
    
    void write(final DataOutputStream lllllllllllllIlIlllIIlllllllIlIl) throws IOException {
        lllllllllllllIlIlllIIlllllllIlIl.writeShort(this.accessFlags);
        lllllllllllllIlIlllIIlllllllIlIl.writeShort(this.name);
        lllllllllllllIlIlllIIlllllllIlIl.writeShort(this.descriptor);
        if (this.attribute == null) {
            lllllllllllllIlIlllIIlllllllIlIl.writeShort(0);
        }
        else {
            lllllllllllllIlIlllIIlllllllIlIl.writeShort(this.attribute.size());
            AttributeInfo.writeAll(this.attribute, lllllllllllllIlIlllIIlllllllIlIl);
        }
    }
    
    public void setDescriptor(final String lllllllllllllIlIlllIlIIIIIlIIlII) {
        if (!lllllllllllllIlIlllIlIIIIIlIIlII.equals(this.getDescriptor())) {
            this.descriptor = this.constPool.addUtf8Info(lllllllllllllIlIlllIlIIIIIlIIlII);
        }
    }
    
    private void read(final DataInputStream lllllllllllllIlIlllIIlllllllllIl) throws IOException {
        this.accessFlags = lllllllllllllIlIlllIIlllllllllIl.readUnsignedShort();
        this.name = lllllllllllllIlIlllIIlllllllllIl.readUnsignedShort();
        this.descriptor = lllllllllllllIlIlllIIlllllllllIl.readUnsignedShort();
        final int lllllllllllllIlIlllIIlllllllllll = lllllllllllllIlIlllIIlllllllllIl.readUnsignedShort();
        this.attribute = new ArrayList<AttributeInfo>();
        for (int lllllllllllllIlIlllIlIIIIIIIIIlI = 0; lllllllllllllIlIlllIlIIIIIIIIIlI < lllllllllllllIlIlllIIlllllllllll; ++lllllllllllllIlIlllIlIIIIIIIIIlI) {
            this.attribute.add(AttributeInfo.read(this.constPool, lllllllllllllIlIlllIIlllllllllIl));
        }
    }
    
    public int getConstantValue() {
        if ((this.accessFlags & 0x8) == 0x0) {
            return 0;
        }
        final ConstantAttribute lllllllllllllIlIlllIlIIIIIIllllI = (ConstantAttribute)this.getAttribute("ConstantValue");
        if (lllllllllllllIlIlllIlIIIIIIllllI == null) {
            return 0;
        }
        return lllllllllllllIlIlllIlIIIIIIllllI.getConstantValue();
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.getName()).append(" ").append(this.getDescriptor()));
    }
    
    public void setName(final String lllllllllllllIlIlllIlIIIIIllIlII) {
        this.name = this.constPool.addUtf8Info(lllllllllllllIlIlllIlIIIIIllIlII);
        this.cachedName = lllllllllllllIlIlllIlIIIIIllIlII;
    }
    
    public int getAccessFlags() {
        return this.accessFlags;
    }
    
    void prune(final ConstPool lllllllllllllIlIlllIlIIIIlIIIlIl) {
        final List<AttributeInfo> lllllllllllllIlIlllIlIIIIlIIlIll = new ArrayList<AttributeInfo>();
        AttributeInfo lllllllllllllIlIlllIlIIIIlIIlIlI = this.getAttribute("RuntimeInvisibleAnnotations");
        if (lllllllllllllIlIlllIlIIIIlIIlIlI != null) {
            lllllllllllllIlIlllIlIIIIlIIlIlI = lllllllllllllIlIlllIlIIIIlIIlIlI.copy(lllllllllllllIlIlllIlIIIIlIIIlIl, null);
            lllllllllllllIlIlllIlIIIIlIIlIll.add(lllllllllllllIlIlllIlIIIIlIIlIlI);
        }
        AttributeInfo lllllllllllllIlIlllIlIIIIlIIlIIl = this.getAttribute("RuntimeVisibleAnnotations");
        if (lllllllllllllIlIlllIlIIIIlIIlIIl != null) {
            lllllllllllllIlIlllIlIIIIlIIlIIl = lllllllllllllIlIlllIlIIIIlIIlIIl.copy(lllllllllllllIlIlllIlIIIIlIIIlIl, null);
            lllllllllllllIlIlllIlIIIIlIIlIll.add(lllllllllllllIlIlllIlIIIIlIIlIIl);
        }
        AttributeInfo lllllllllllllIlIlllIlIIIIlIIlIII = this.getAttribute("Signature");
        if (lllllllllllllIlIlllIlIIIIlIIlIII != null) {
            lllllllllllllIlIlllIlIIIIlIIlIII = lllllllllllllIlIlllIlIIIIlIIlIII.copy(lllllllllllllIlIlllIlIIIIlIIIlIl, null);
            lllllllllllllIlIlllIlIIIIlIIlIll.add(lllllllllllllIlIlllIlIIIIlIIlIII);
        }
        int lllllllllllllIlIlllIlIIIIlIIIlll = this.getConstantValue();
        if (lllllllllllllIlIlllIlIIIIlIIIlll != 0) {
            lllllllllllllIlIlllIlIIIIlIIIlll = this.constPool.copy(lllllllllllllIlIlllIlIIIIlIIIlll, lllllllllllllIlIlllIlIIIIlIIIlIl, null);
            lllllllllllllIlIlllIlIIIIlIIlIll.add(new ConstantAttribute(lllllllllllllIlIlllIlIIIIlIIIlIl, lllllllllllllIlIlllIlIIIIlIIIlll));
        }
        this.attribute = lllllllllllllIlIlllIlIIIIlIIlIll;
        this.name = lllllllllllllIlIlllIlIIIIlIIIlIl.addUtf8Info(this.getName());
        this.descriptor = lllllllllllllIlIlllIlIIIIlIIIlIl.addUtf8Info(this.getDescriptor());
        this.constPool = lllllllllllllIlIlllIlIIIIlIIIlIl;
    }
    
    public void addAttribute(final AttributeInfo lllllllllllllIlIlllIlIIIIIIIIlll) {
        if (this.attribute == null) {
            this.attribute = new ArrayList<AttributeInfo>();
        }
        AttributeInfo.remove(this.attribute, lllllllllllllIlIlllIlIIIIIIIIlll.getName());
        this.attribute.add(lllllllllllllIlIlllIlIIIIIIIIlll);
    }
    
    public List<AttributeInfo> getAttributes() {
        if (this.attribute == null) {
            this.attribute = new ArrayList<AttributeInfo>();
        }
        return this.attribute;
    }
    
    public FieldInfo(final ConstPool lllllllllllllIlIlllIlIIIIllIlIIl, final String lllllllllllllIlIlllIlIIIIllIlIII, final String lllllllllllllIlIlllIlIIIIllIIlll) {
        this(lllllllllllllIlIlllIlIIIIllIlIIl);
        this.name = lllllllllllllIlIlllIlIIIIllIlIIl.addUtf8Info(lllllllllllllIlIlllIlIIIIllIlIII);
        this.cachedName = lllllllllllllIlIlllIlIIIIllIlIII;
        this.descriptor = lllllllllllllIlIlllIlIIIIllIlIIl.addUtf8Info(lllllllllllllIlIlllIlIIIIllIIlll);
    }
    
    public ConstPool getConstPool() {
        return this.constPool;
    }
    
    private FieldInfo(final ConstPool lllllllllllllIlIlllIlIIIIlllIlIl) {
        this.constPool = lllllllllllllIlIlllIlIIIIlllIlIl;
        this.accessFlags = 0;
        this.attribute = null;
    }
}
