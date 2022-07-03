package com.viaversion.viaversion.libs.javassist.bytecode;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.stackmap.*;
import java.util.*;
import java.io.*;

public class MethodInfo
{
    public static /* synthetic */ boolean doPreverify;
    /* synthetic */ List<AttributeInfo> attribute;
    /* synthetic */ int accessFlags;
    /* synthetic */ String cachedName;
    /* synthetic */ int name;
    /* synthetic */ int descriptor;
    /* synthetic */ ConstPool constPool;
    
    public int getAccessFlags() {
        return this.accessFlags;
    }
    
    public void rebuildStackMap(final ClassPool lllllllllllllIllIlIlIIlllIllIIIl) throws BadBytecode {
        final CodeAttribute lllllllllllllIllIlIlIIlllIllIIll = this.getCodeAttribute();
        if (lllllllllllllIllIlIlIIlllIllIIll != null) {
            final StackMapTable lllllllllllllIllIlIlIIlllIllIllI = MapMaker.make(lllllllllllllIllIlIlIIlllIllIIIl, this);
            lllllllllllllIllIlIlIIlllIllIIll.setAttribute(lllllllllllllIllIlIlIIlllIllIllI);
        }
    }
    
    public AttributeInfo getAttribute(final String lllllllllllllIllIlIlIIlllllIlllI) {
        return AttributeInfo.lookup(this.attribute, lllllllllllllIllIlIlIIlllllIlllI);
    }
    
    public void rebuildStackMapIf6(final ClassPool lllllllllllllIllIlIlIIlllIllllll, final ClassFile lllllllllllllIllIlIlIIlllIlllllI) throws BadBytecode {
        if (lllllllllllllIllIlIlIIlllIlllllI.getMajorVersion() >= 50) {
            this.rebuildStackMap(lllllllllllllIllIlIlIIlllIllllll);
        }
        if (MethodInfo.doPreverify) {
            this.rebuildStackMapForME(lllllllllllllIllIlIlIIlllIllllll);
        }
    }
    
    public void removeExceptionsAttribute() {
        AttributeInfo.remove(this.attribute, "Exceptions");
    }
    
    void compact(final ConstPool lllllllllllllIllIlIlIlIIIIllllll) {
        this.name = lllllllllllllIllIlIlIlIIIIllllll.addUtf8Info(this.getName());
        this.descriptor = lllllllllllllIllIlIlIlIIIIllllll.addUtf8Info(this.getDescriptor());
        this.attribute = AttributeInfo.copyAll(this.attribute, lllllllllllllIllIlIlIlIIIIllllll);
        this.constPool = lllllllllllllIllIlIlIlIIIIllllll;
    }
    
    public String getName() {
        if (this.cachedName == null) {
            this.cachedName = this.constPool.getUtf8Info(this.name);
        }
        return this.cachedName;
    }
    
    public void removeCodeAttribute() {
        AttributeInfo.remove(this.attribute, "Code");
    }
    
    public void rebuildStackMapForME(final ClassPool lllllllllllllIllIlIlIIlllIlIlIII) throws BadBytecode {
        final CodeAttribute lllllllllllllIllIlIlIIlllIlIIlll = this.getCodeAttribute();
        if (lllllllllllllIllIlIlIIlllIlIIlll != null) {
            final StackMap lllllllllllllIllIlIlIIlllIlIlIlI = MapMaker.make2(lllllllllllllIllIlIlIIlllIlIlIII, this);
            lllllllllllllIllIlIlIIlllIlIIlll.setAttribute(lllllllllllllIllIlIlIIlllIlIlIlI);
        }
    }
    
    static {
        nameClinit = "<clinit>";
        nameInit = "<init>";
        MethodInfo.doPreverify = false;
    }
    
    private void read(final MethodInfo lllllllllllllIllIlIlIIllIlIlIIll, final String lllllllllllllIllIlIlIIllIlIlIIlI, final Map<String, String> lllllllllllllIllIlIlIIllIlIlIIIl) {
        final ConstPool lllllllllllllIllIlIlIIllIlIllIlI = this.constPool;
        this.accessFlags = lllllllllllllIllIlIlIIllIlIlIIll.accessFlags;
        this.name = lllllllllllllIllIlIlIIllIlIllIlI.addUtf8Info(lllllllllllllIllIlIlIIllIlIlIIlI);
        this.cachedName = lllllllllllllIllIlIlIIllIlIlIIlI;
        final ConstPool lllllllllllllIllIlIlIIllIlIllIIl = lllllllllllllIllIlIlIIllIlIlIIll.constPool;
        final String lllllllllllllIllIlIlIIllIlIllIII = lllllllllllllIllIlIlIIllIlIllIIl.getUtf8Info(lllllllllllllIllIlIlIIllIlIlIIll.descriptor);
        final String lllllllllllllIllIlIlIIllIlIlIlll = Descriptor.rename(lllllllllllllIllIlIlIIllIlIllIII, lllllllllllllIllIlIlIIllIlIlIIIl);
        this.descriptor = lllllllllllllIllIlIlIIllIlIllIlI.addUtf8Info(lllllllllllllIllIlIlIIllIlIlIlll);
        this.attribute = new ArrayList<AttributeInfo>();
        final ExceptionsAttribute lllllllllllllIllIlIlIIllIlIlIllI = lllllllllllllIllIlIlIIllIlIlIIll.getExceptionsAttribute();
        if (lllllllllllllIllIlIlIIllIlIlIllI != null) {
            this.attribute.add(lllllllllllllIllIlIlIIllIlIlIllI.copy(lllllllllllllIllIlIlIIllIlIllIlI, lllllllllllllIllIlIlIIllIlIlIIIl));
        }
        final CodeAttribute lllllllllllllIllIlIlIIllIlIlIlIl = lllllllllllllIllIlIlIIllIlIlIIll.getCodeAttribute();
        if (lllllllllllllIllIlIlIIllIlIlIlIl != null) {
            this.attribute.add(lllllllllllllIllIlIlIIllIlIlIlIl.copy(lllllllllllllIllIlIlIIllIlIllIlI, lllllllllllllIllIlIlIIllIlIlIIIl));
        }
    }
    
    public int getLineNumber(final int lllllllllllllIllIlIlIIlllIIllIIl) {
        final CodeAttribute lllllllllllllIllIlIlIIlllIIlllII = this.getCodeAttribute();
        if (lllllllllllllIllIlIlIIlllIIlllII == null) {
            return -1;
        }
        final LineNumberAttribute lllllllllllllIllIlIlIIlllIIllIll = (LineNumberAttribute)lllllllllllllIllIlIlIIlllIIlllII.getAttribute("LineNumberTable");
        if (lllllllllllllIllIlIlIIlllIIllIll == null) {
            return -1;
        }
        return lllllllllllllIllIlIlIIlllIIllIll.toLineNumber(lllllllllllllIllIlIlIIlllIIllIIl);
    }
    
    private void read(final DataInputStream lllllllllllllIllIlIlIIllIlIIIlII) throws IOException {
        this.accessFlags = lllllllllllllIllIlIlIIllIlIIIlII.readUnsignedShort();
        this.name = lllllllllllllIllIlIlIIllIlIIIlII.readUnsignedShort();
        this.descriptor = lllllllllllllIllIlIlIIllIlIIIlII.readUnsignedShort();
        final int lllllllllllllIllIlIlIIllIlIIIIll = lllllllllllllIllIlIlIIllIlIIIlII.readUnsignedShort();
        this.attribute = new ArrayList<AttributeInfo>();
        for (int lllllllllllllIllIlIlIIllIlIIIllI = 0; lllllllllllllIllIlIlIIllIlIIIllI < lllllllllllllIllIlIlIIllIlIIIIll; ++lllllllllllllIllIlIlIIllIlIIIllI) {
            this.attribute.add(AttributeInfo.read(this.constPool, lllllllllllllIllIlIlIIllIlIIIlII));
        }
    }
    
    public List<AttributeInfo> getAttributes() {
        if (this.attribute == null) {
            this.attribute = new ArrayList<AttributeInfo>();
        }
        return this.attribute;
    }
    
    public ConstPool getConstPool() {
        return this.constPool;
    }
    
    public void setSuperclass(final String lllllllllllllIllIlIlIIllIlllllll) throws BadBytecode {
        if (!this.isConstructor()) {
            return;
        }
        final CodeAttribute lllllllllllllIllIlIlIIlllIIIIlII = this.getCodeAttribute();
        final byte[] lllllllllllllIllIlIlIIlllIIIIIll = lllllllllllllIllIlIlIIlllIIIIlII.getCode();
        final CodeIterator lllllllllllllIllIlIlIIlllIIIIIlI = lllllllllllllIllIlIlIIlllIIIIlII.iterator();
        final int lllllllllllllIllIlIlIIlllIIIIIIl = lllllllllllllIllIlIlIIlllIIIIIlI.skipSuperConstructor();
        if (lllllllllllllIllIlIlIIlllIIIIIIl >= 0) {
            final ConstPool lllllllllllllIllIlIlIIlllIIIlIll = this.constPool;
            final int lllllllllllllIllIlIlIIlllIIIlIlI = ByteArray.readU16bit(lllllllllllllIllIlIlIIlllIIIIIll, lllllllllllllIllIlIlIIlllIIIIIIl + 1);
            final int lllllllllllllIllIlIlIIlllIIIlIIl = lllllllllllllIllIlIlIIlllIIIlIll.getMethodrefNameAndType(lllllllllllllIllIlIlIIlllIIIlIlI);
            final int lllllllllllllIllIlIlIIlllIIIlIII = lllllllllllllIllIlIlIIlllIIIlIll.addClassInfo(lllllllllllllIllIlIlIIllIlllllll);
            final int lllllllllllllIllIlIlIIlllIIIIlll = lllllllllllllIllIlIlIIlllIIIlIll.addMethodrefInfo(lllllllllllllIllIlIlIIlllIIIlIII, lllllllllllllIllIlIlIIlllIIIlIIl);
            ByteArray.write16bit(lllllllllllllIllIlIlIIlllIIIIlll, lllllllllllllIllIlIlIIlllIIIIIll, lllllllllllllIllIlIlIIlllIIIIIIl + 1);
        }
    }
    
    private MethodInfo(final ConstPool lllllllllllllIllIlIlIlIIIllIllII) {
        this.constPool = lllllllllllllIllIlIlIlIIIllIllII;
        this.attribute = null;
    }
    
    public ExceptionsAttribute getExceptionsAttribute() {
        final AttributeInfo lllllllllllllIllIlIlIIllllIllllI = AttributeInfo.lookup(this.attribute, "Exceptions");
        return (ExceptionsAttribute)lllllllllllllIllIlIlIIllllIllllI;
    }
    
    public String getDescriptor() {
        return this.constPool.getUtf8Info(this.descriptor);
    }
    
    public void setName(final String lllllllllllllIllIlIlIlIIIIIllIlI) {
        this.name = this.constPool.addUtf8Info(lllllllllllllIllIlIlIlIIIIIllIlI);
        this.cachedName = lllllllllllllIllIlIlIlIIIIIllIlI;
    }
    
    public void setAccessFlags(final int lllllllllllllIllIlIlIlIIIIIIIIII) {
        this.accessFlags = lllllllllllllIllIlIlIlIIIIIIIIII;
    }
    
    public void setCodeAttribute(final CodeAttribute lllllllllllllIllIlIlIIllllIIIllI) {
        this.removeCodeAttribute();
        if (this.attribute == null) {
            this.attribute = new ArrayList<AttributeInfo>();
        }
        this.attribute.add(lllllllllllllIllIlIlIIllllIIIllI);
    }
    
    public boolean isStaticInitializer() {
        return this.getName().equals("<clinit>");
    }
    
    void write(final DataOutputStream lllllllllllllIllIlIlIIllIIlllIIl) throws IOException {
        lllllllllllllIllIlIlIIllIIlllIIl.writeShort(this.accessFlags);
        lllllllllllllIllIlIlIIllIIlllIIl.writeShort(this.name);
        lllllllllllllIllIlIlIIllIIlllIIl.writeShort(this.descriptor);
        if (this.attribute == null) {
            lllllllllllllIllIlIlIIllIIlllIIl.writeShort(0);
        }
        else {
            lllllllllllllIllIlIlIIllIIlllIIl.writeShort(this.attribute.size());
            AttributeInfo.writeAll(this.attribute, lllllllllllllIllIlIlIIllIIlllIIl);
        }
    }
    
    public AttributeInfo removeAttribute(final String lllllllllllllIllIlIlIIlllllIlIlI) {
        return AttributeInfo.remove(this.attribute, lllllllllllllIllIlIlIIlllllIlIlI);
    }
    
    public CodeAttribute getCodeAttribute() {
        final AttributeInfo lllllllllllllIllIlIlIIllllIllIII = AttributeInfo.lookup(this.attribute, "Code");
        return (CodeAttribute)lllllllllllllIllIlIlIIllllIllIII;
    }
    
    public MethodInfo(final ConstPool lllllllllllllIllIlIlIlIIIlIlIIII, final String lllllllllllllIllIlIlIlIIIlIIllll, final MethodInfo lllllllllllllIllIlIlIlIIIlIIlllI, final Map<String, String> lllllllllllllIllIlIlIlIIIlIIlIII) throws BadBytecode {
        this(lllllllllllllIllIlIlIlIIIlIlIIII);
        this.read(lllllllllllllIllIlIlIlIIIlIIlllI, lllllllllllllIllIlIlIlIIIlIIllll, lllllllllllllIllIlIlIlIIIlIIlIII);
    }
    
    public void setDescriptor(final String lllllllllllllIllIlIlIIlllllllIIl) {
        if (!lllllllllllllIllIlIlIIlllllllIIl.equals(this.getDescriptor())) {
            this.descriptor = this.constPool.addUtf8Info(lllllllllllllIllIlIlIIlllllllIIl);
        }
    }
    
    public boolean isMethod() {
        final String lllllllllllllIllIlIlIlIIIIIlIlII = this.getName();
        return !lllllllllllllIllIlIlIlIIIIIlIlII.equals("<init>") && !lllllllllllllIllIlIlIlIIIIIlIlII.equals("<clinit>");
    }
    
    public void addAttribute(final AttributeInfo lllllllllllllIllIlIlIIlllllIIlII) {
        if (this.attribute == null) {
            this.attribute = new ArrayList<AttributeInfo>();
        }
        AttributeInfo.remove(this.attribute, lllllllllllllIllIlIlIIlllllIIlII.getName());
        this.attribute.add(lllllllllllllIllIlIlIIlllllIIlII);
    }
    
    public MethodInfo(final ConstPool lllllllllllllIllIlIlIlIIIllIIllI, final String lllllllllllllIllIlIlIlIIIllIIlIl, final String lllllllllllllIllIlIlIlIIIllIIlII) {
        this(lllllllllllllIllIlIlIlIIIllIIllI);
        this.accessFlags = 0;
        this.name = lllllllllllllIllIlIlIlIIIllIIllI.addUtf8Info(lllllllllllllIllIlIlIlIIIllIIlIl);
        this.cachedName = lllllllllllllIllIlIlIlIIIllIIlIl;
        this.descriptor = this.constPool.addUtf8Info(lllllllllllllIllIlIlIlIIIllIIlII);
    }
    
    void prune(final ConstPool lllllllllllllIllIlIlIlIIIIllIIll) {
        final List<AttributeInfo> lllllllllllllIllIlIlIlIIIIllIIlI = new ArrayList<AttributeInfo>();
        AttributeInfo lllllllllllllIllIlIlIlIIIIllIIIl = this.getAttribute("RuntimeInvisibleAnnotations");
        if (lllllllllllllIllIlIlIlIIIIllIIIl != null) {
            lllllllllllllIllIlIlIlIIIIllIIIl = lllllllllllllIllIlIlIlIIIIllIIIl.copy(lllllllllllllIllIlIlIlIIIIllIIll, null);
            lllllllllllllIllIlIlIlIIIIllIIlI.add(lllllllllllllIllIlIlIlIIIIllIIIl);
        }
        AttributeInfo lllllllllllllIllIlIlIlIIIIllIIII = this.getAttribute("RuntimeVisibleAnnotations");
        if (lllllllllllllIllIlIlIlIIIIllIIII != null) {
            lllllllllllllIllIlIlIlIIIIllIIII = lllllllllllllIllIlIlIlIIIIllIIII.copy(lllllllllllllIllIlIlIlIIIIllIIll, null);
            lllllllllllllIllIlIlIlIIIIllIIlI.add(lllllllllllllIllIlIlIlIIIIllIIII);
        }
        AttributeInfo lllllllllllllIllIlIlIlIIIIlIllll = this.getAttribute("RuntimeInvisibleParameterAnnotations");
        if (lllllllllllllIllIlIlIlIIIIlIllll != null) {
            lllllllllllllIllIlIlIlIIIIlIllll = lllllllllllllIllIlIlIlIIIIlIllll.copy(lllllllllllllIllIlIlIlIIIIllIIll, null);
            lllllllllllllIllIlIlIlIIIIllIIlI.add(lllllllllllllIllIlIlIlIIIIlIllll);
        }
        AttributeInfo lllllllllllllIllIlIlIlIIIIlIlllI = this.getAttribute("RuntimeVisibleParameterAnnotations");
        if (lllllllllllllIllIlIlIlIIIIlIlllI != null) {
            lllllllllllllIllIlIlIlIIIIlIlllI = lllllllllllllIllIlIlIlIIIIlIlllI.copy(lllllllllllllIllIlIlIlIIIIllIIll, null);
            lllllllllllllIllIlIlIlIIIIllIIlI.add(lllllllllllllIllIlIlIlIIIIlIlllI);
        }
        final AnnotationDefaultAttribute lllllllllllllIllIlIlIlIIIIlIllIl = (AnnotationDefaultAttribute)this.getAttribute("AnnotationDefault");
        if (lllllllllllllIllIlIlIlIIIIlIllIl != null) {
            lllllllllllllIllIlIlIlIIIIllIIlI.add(lllllllllllllIllIlIlIlIIIIlIllIl);
        }
        final ExceptionsAttribute lllllllllllllIllIlIlIlIIIIlIllII = this.getExceptionsAttribute();
        if (lllllllllllllIllIlIlIlIIIIlIllII != null) {
            lllllllllllllIllIlIlIlIIIIllIIlI.add(lllllllllllllIllIlIlIlIIIIlIllII);
        }
        AttributeInfo lllllllllllllIllIlIlIlIIIIlIlIll = this.getAttribute("Signature");
        if (lllllllllllllIllIlIlIlIIIIlIlIll != null) {
            lllllllllllllIllIlIlIlIIIIlIlIll = lllllllllllllIllIlIlIlIIIIlIlIll.copy(lllllllllllllIllIlIlIlIIIIllIIll, null);
            lllllllllllllIllIlIlIlIIIIllIIlI.add(lllllllllllllIllIlIlIlIIIIlIlIll);
        }
        this.attribute = lllllllllllllIllIlIlIlIIIIllIIlI;
        this.name = lllllllllllllIllIlIlIlIIIIllIIll.addUtf8Info(this.getName());
        this.descriptor = lllllllllllllIllIlIlIlIIIIllIIll.addUtf8Info(this.getDescriptor());
        this.constPool = lllllllllllllIllIlIlIlIIIIllIIll;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.getName()).append(" ").append(this.getDescriptor()));
    }
    
    public boolean isConstructor() {
        return this.getName().equals("<init>");
    }
    
    public void setExceptionsAttribute(final ExceptionsAttribute lllllllllllllIllIlIlIIllllIIllll) {
        this.removeExceptionsAttribute();
        if (this.attribute == null) {
            this.attribute = new ArrayList<AttributeInfo>();
        }
        this.attribute.add(lllllllllllllIllIlIlIIllllIIllll);
    }
    
    MethodInfo(final ConstPool lllllllllllllIllIlIlIlIIIlIllIII, final DataInputStream lllllllllllllIllIlIlIlIIIlIllIlI) throws IOException {
        this(lllllllllllllIllIlIlIlIIIlIllIII);
        this.read(lllllllllllllIllIlIlIlIIIlIllIlI);
    }
}
