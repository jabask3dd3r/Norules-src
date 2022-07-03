package com.viaversion.viaversion.libs.javassist.bytecode;

import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;
import java.io.*;

public final class ClassFile
{
    /* synthetic */ List<AttributeInfo> attributes;
    /* synthetic */ int major;
    /* synthetic */ String[] cachedInterfaces;
    /* synthetic */ int accessFlags;
    /* synthetic */ int superClass;
    /* synthetic */ int thisClass;
    public static final /* synthetic */ int MAJOR_VERSION;
    /* synthetic */ List<MethodInfo> methods;
    /* synthetic */ int[] interfaces;
    /* synthetic */ int minor;
    /* synthetic */ String thisclassname;
    /* synthetic */ ConstPool constPool;
    /* synthetic */ String cachedSuperclass;
    /* synthetic */ List<FieldInfo> fields;
    
    public ClassFile(final boolean lllllllllllllllIIllIIlIIIlllIlII, final String lllllllllllllllIIllIIlIIIlllIlll, final String lllllllllllllllIIllIIlIIIlllIllI) {
        this.major = ClassFile.MAJOR_VERSION;
        this.minor = 0;
        this.constPool = new ConstPool(lllllllllllllllIIllIIlIIIlllIlll);
        this.thisClass = this.constPool.getThisClassInfo();
        if (lllllllllllllllIIllIIlIIIlllIlII) {
            this.accessFlags = 1536;
        }
        else {
            this.accessFlags = 32;
        }
        this.initSuperclass(lllllllllllllllIIllIIlIIIlllIllI);
        this.interfaces = null;
        this.fields = new ArrayList<FieldInfo>();
        this.methods = new ArrayList<MethodInfo>();
        this.thisclassname = lllllllllllllllIIllIIlIIIlllIlll;
        this.attributes = new ArrayList<AttributeInfo>();
        this.attributes.add(new SourceFileAttribute(this.constPool, getSourcefileName(this.thisclassname)));
    }
    
    public final void addMethod2(final MethodInfo lllllllllllllllIIllIIIllIlIlllIl) {
        this.methods.add(lllllllllllllllIIllIIIllIlIlllIl);
    }
    
    public int getInnerAccessFlags() {
        final InnerClassesAttribute lllllllllllllllIIllIIlIIIIIIllll = (InnerClassesAttribute)this.getAttribute("InnerClasses");
        if (lllllllllllllllIIllIIlIIIIIIllll == null) {
            return -1;
        }
        final String lllllllllllllllIIllIIlIIIIIIlllI = this.getName();
        for (int lllllllllllllllIIllIIlIIIIIIllIl = lllllllllllllllIIllIIlIIIIIIllll.tableLength(), lllllllllllllllIIllIIlIIIIIlIIIl = 0; lllllllllllllllIIllIIlIIIIIlIIIl < lllllllllllllllIIllIIlIIIIIIllIl; ++lllllllllllllllIIllIIlIIIIIlIIIl) {
            if (lllllllllllllllIIllIIlIIIIIIlllI.equals(lllllllllllllllIIllIIlIIIIIIllll.innerClass(lllllllllllllllIIllIIlIIIIIlIIIl))) {
                return lllllllllllllllIIllIIlIIIIIIllll.accessFlags(lllllllllllllllIIllIIlIIIIIlIIIl);
            }
        }
        return -1;
    }
    
    public void setMinorVersion(final int lllllllllllllllIIllIIIlIlllIIIIl) {
        this.minor = lllllllllllllllIIllIIIlIlllIIIIl;
    }
    
    public void addInterface(final String lllllllllllllllIIllIIIlllIIllIIl) {
        this.cachedInterfaces = null;
        final int lllllllllllllllIIllIIIlllIIllIII = this.constPool.addClassInfo(lllllllllllllllIIllIIIlllIIllIIl);
        if (this.interfaces == null) {
            this.interfaces = new int[1];
            this.interfaces[0] = lllllllllllllllIIllIIIlllIIllIII;
        }
        else {
            final int lllllllllllllllIIllIIIlllIIlllII = this.interfaces.length;
            final int[] lllllllllllllllIIllIIIlllIIllIll = new int[lllllllllllllllIIllIIIlllIIlllII + 1];
            System.arraycopy(this.interfaces, 0, lllllllllllllllIIllIIIlllIIllIll, 0, lllllllllllllllIIllIIIlllIIlllII);
            lllllllllllllllIIllIIIlllIIllIll[lllllllllllllllIIllIIIlllIIlllII] = lllllllllllllllIIllIIIlllIIllIII;
            this.interfaces = lllllllllllllllIIllIIIlllIIllIll;
        }
    }
    
    public void addAttribute(final AttributeInfo lllllllllllllllIIllIIIllIIIlllll) {
        AttributeInfo.remove(this.attributes, lllllllllllllllIIllIIIllIIIlllll.getName());
        this.attributes.add(lllllllllllllllIIllIIIllIIIlllll);
    }
    
    public int getSuperclassId() {
        return this.superClass;
    }
    
    public ConstPool getConstPool() {
        return this.constPool;
    }
    
    public String getSourceFile() {
        final SourceFileAttribute lllllllllllllllIIllIIIllIIIllIll = (SourceFileAttribute)this.getAttribute("SourceFile");
        if (lllllllllllllllIIllIIIllIIIllIll == null) {
            return null;
        }
        return lllllllllllllllIIllIIIllIIIllIll.getFileName();
    }
    
    public ClassFile(final DataInputStream lllllllllllllllIIllIIlIIlIIIIIIl) throws IOException {
        this.read(lllllllllllllllIIllIIlIIlIIIIIIl);
    }
    
    private ConstPool compact0() {
        final ConstPool lllllllllllllllIIllIIlIIIlIIlIIl = new ConstPool(this.thisclassname);
        this.thisClass = lllllllllllllllIIllIIlIIIlIIlIIl.getThisClassInfo();
        final String lllllllllllllllIIllIIlIIIlIIlIII = this.getSuperclass();
        if (lllllllllllllllIIllIIlIIIlIIlIII != null) {
            this.superClass = lllllllllllllllIIllIIlIIIlIIlIIl.addClassInfo(this.getSuperclass());
        }
        if (this.interfaces != null) {
            for (int lllllllllllllllIIllIIlIIIlIIlIll = 0; lllllllllllllllIIllIIlIIIlIIlIll < this.interfaces.length; ++lllllllllllllllIIllIIlIIIlIIlIll) {
                this.interfaces[lllllllllllllllIIllIIlIIIlIIlIll] = lllllllllllllllIIllIIlIIIlIIlIIl.addClassInfo(this.constPool.getClassInfo(this.interfaces[lllllllllllllllIIllIIlIIIlIIlIll]));
            }
        }
        return lllllllllllllllIIllIIlIIIlIIlIIl;
    }
    
    public void setVersionToJava5() {
        this.major = 49;
        this.minor = 0;
    }
    
    public boolean isFinal() {
        return (this.accessFlags & 0x10) != 0x0;
    }
    
    private void testExistingField(final String lllllllllllllllIIllIIIllIlllllIl, final String lllllllllllllllIIllIIIllIlllllII) throws DuplicateMemberException {
        for (final FieldInfo lllllllllllllllIIllIIIllIlllllll : this.fields) {
            if (lllllllllllllllIIllIIIllIlllllll.getName().equals(lllllllllllllllIIllIIIllIlllllIl)) {
                throw new DuplicateMemberException(String.valueOf(new StringBuilder().append("duplicate field: ").append(lllllllllllllllIIllIIIllIlllllIl)));
            }
        }
    }
    
    public void addField(final FieldInfo lllllllllllllllIIllIIIlllIIIllII) throws DuplicateMemberException {
        this.testExistingField(lllllllllllllllIIllIIIlllIIIllII.getName(), lllllllllllllllIIllIIIlllIIIllII.getDescriptor());
        this.fields.add(lllllllllllllllIIllIIIlllIIIllII);
    }
    
    public int getAccessFlags() {
        return this.accessFlags;
    }
    
    public void setSuperclass(String lllllllllllllllIIllIIIlllllIllll) throws CannotCompileException {
        if (lllllllllllllllIIllIIIlllllIllll == null) {
            lllllllllllllllIIllIIIlllllIllll = "java.lang.Object";
        }
        try {
            this.superClass = this.constPool.addClassInfo(lllllllllllllllIIllIIIlllllIllll);
            for (final MethodInfo lllllllllllllllIIllIIIllllllIlII : this.methods) {
                lllllllllllllllIIllIIIllllllIlII.setSuperclass(lllllllllllllllIIllIIIlllllIllll);
            }
        }
        catch (BadBytecode lllllllllllllllIIllIIIllllllIIll) {
            throw new CannotCompileException(lllllllllllllllIIllIIIllllllIIll);
        }
        this.cachedSuperclass = lllllllllllllllIIllIIIlllllIllll;
    }
    
    public void setMajorVersion(final int lllllllllllllllIIllIIIlIlllIlIlI) {
        this.major = lllllllllllllllIIllIIIlIlllIlIlI;
    }
    
    public String[] getInterfaces() {
        if (this.cachedInterfaces != null) {
            return this.cachedInterfaces;
        }
        String[] lllllllllllllllIIllIIIlllIlIllll = null;
        if (this.interfaces == null) {
            lllllllllllllllIIllIIIlllIlIllll = new String[0];
        }
        else {
            final String[] lllllllllllllllIIllIIIlllIllIIIl = new String[this.interfaces.length];
            for (int lllllllllllllllIIllIIIlllIllIIlI = 0; lllllllllllllllIIllIIIlllIllIIlI < this.interfaces.length; ++lllllllllllllllIIllIIIlllIllIIlI) {
                lllllllllllllllIIllIIIlllIllIIIl[lllllllllllllllIIllIIIlllIllIIlI] = this.constPool.getClassInfo(this.interfaces[lllllllllllllllIIllIIIlllIllIIlI]);
            }
            lllllllllllllllIIllIIIlllIlIllll = lllllllllllllllIIllIIIlllIllIIIl;
        }
        this.cachedInterfaces = lllllllllllllllIIllIIIlllIlIllll;
        return lllllllllllllllIIllIIIlllIlIllll;
    }
    
    public final void getRefClasses(final Map<String, String> lllllllllllllllIIllIIIlllIlllIlI) {
        this.constPool.renameClass(lllllllllllllllIIllIIIlllIlllIlI);
        AttributeInfo.getRefClasses(this.attributes, lllllllllllllllIIllIIIlllIlllIlI);
        for (final MethodInfo lllllllllllllllIIllIIIllllIIIIII : this.methods) {
            final String lllllllllllllllIIllIIIllllIIIIIl = lllllllllllllllIIllIIIllllIIIIII.getDescriptor();
            Descriptor.rename(lllllllllllllllIIllIIIllllIIIIIl, lllllllllllllllIIllIIIlllIlllIlI);
            AttributeInfo.getRefClasses(lllllllllllllllIIllIIIllllIIIIII.getAttributes(), lllllllllllllllIIllIIIlllIlllIlI);
        }
        for (final FieldInfo lllllllllllllllIIllIIIlllIlllllI : this.fields) {
            final String lllllllllllllllIIllIIIlllIllllll = lllllllllllllllIIllIIIlllIlllllI.getDescriptor();
            Descriptor.rename(lllllllllllllllIIllIIIlllIllllll, lllllllllllllllIIllIIIlllIlllIlI);
            AttributeInfo.getRefClasses(lllllllllllllllIIllIIIlllIlllllI.getAttributes(), lllllllllllllllIIllIIIlllIlllIlI);
        }
    }
    
    public void compact() {
        final ConstPool lllllllllllllllIIllIIlIIIlIlIlII = this.compact0();
        for (final MethodInfo lllllllllllllllIIllIIlIIIlIlIlll : this.methods) {
            lllllllllllllllIIllIIlIIIlIlIlll.compact(lllllllllllllllIIllIIlIIIlIlIlII);
        }
        for (final FieldInfo lllllllllllllllIIllIIlIIIlIlIllI : this.fields) {
            lllllllllllllllIIllIIlIIIlIlIllI.compact(lllllllllllllllIIllIIlIIIlIlIlII);
        }
        this.attributes = AttributeInfo.copyAll(this.attributes, lllllllllllllllIIllIIlIIIlIlIlII);
        this.constPool = lllllllllllllllIIllIIlIIIlIlIlII;
    }
    
    private void read(final DataInputStream lllllllllllllllIIllIIIllIIIIlIlI) throws IOException {
        final int lllllllllllllllIIllIIIllIIIIllIl = lllllllllllllllIIllIIIllIIIIlIlI.readInt();
        if (lllllllllllllllIIllIIIllIIIIllIl != -889275714) {
            throw new IOException(String.valueOf(new StringBuilder().append("bad magic number: ").append(Integer.toHexString(lllllllllllllllIIllIIIllIIIIllIl))));
        }
        this.minor = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
        this.major = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
        this.constPool = new ConstPool(lllllllllllllllIIllIIIllIIIIlIlI);
        this.accessFlags = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
        this.thisClass = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
        this.constPool.setThisClassInfo(this.thisClass);
        this.superClass = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
        int lllllllllllllllIIllIIIllIIIIlllI = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
        if (lllllllllllllllIIllIIIllIIIIlllI == 0) {
            this.interfaces = null;
        }
        else {
            this.interfaces = new int[lllllllllllllllIIllIIIllIIIIlllI];
            for (int lllllllllllllllIIllIIIllIIIlIIlI = 0; lllllllllllllllIIllIIIllIIIlIIlI < lllllllllllllllIIllIIIllIIIIlllI; ++lllllllllllllllIIllIIIllIIIlIIlI) {
                this.interfaces[lllllllllllllllIIllIIIllIIIlIIlI] = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
            }
        }
        final ConstPool lllllllllllllllIIllIIIllIIIIllII = this.constPool;
        lllllllllllllllIIllIIIllIIIIlllI = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
        this.fields = new ArrayList<FieldInfo>();
        for (int lllllllllllllllIIllIIIllIIIIllll = 0; lllllllllllllllIIllIIIllIIIIllll < lllllllllllllllIIllIIIllIIIIlllI; ++lllllllllllllllIIllIIIllIIIIllll) {
            this.addField2(new FieldInfo(lllllllllllllllIIllIIIllIIIIllII, lllllllllllllllIIllIIIllIIIIlIlI));
        }
        lllllllllllllllIIllIIIllIIIIlllI = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
        this.methods = new ArrayList<MethodInfo>();
        for (int lllllllllllllllIIllIIIllIIIIllll = 0; lllllllllllllllIIllIIIllIIIIllll < lllllllllllllllIIllIIIllIIIIlllI; ++lllllllllllllllIIllIIIllIIIIllll) {
            this.addMethod2(new MethodInfo(lllllllllllllllIIllIIIllIIIIllII, lllllllllllllllIIllIIIllIIIIlIlI));
        }
        this.attributes = new ArrayList<AttributeInfo>();
        lllllllllllllllIIllIIIllIIIIlllI = lllllllllllllllIIllIIIllIIIIlIlI.readUnsignedShort();
        for (int lllllllllllllllIIllIIIllIIIIllll = 0; lllllllllllllllIIllIIIllIIIIllll < lllllllllllllllIIllIIIllIIIIlllI; ++lllllllllllllllIIllIIIllIIIIllll) {
            this.addAttribute(AttributeInfo.read(lllllllllllllllIIllIIIllIIIIllII, lllllllllllllllIIllIIIllIIIIlIlI));
        }
        this.thisclassname = this.constPool.getClassInfo(this.thisClass);
    }
    
    public final void renameClass(String lllllllllllllllIIllIIIllllIllllI, String lllllllllllllllIIllIIIlllllIIIII) {
        if (lllllllllllllllIIllIIIllllIllllI.equals(lllllllllllllllIIllIIIlllllIIIII)) {
            return;
        }
        if (lllllllllllllllIIllIIIllllIllllI.equals(this.thisclassname)) {
            this.thisclassname = lllllllllllllllIIllIIIlllllIIIII;
        }
        lllllllllllllllIIllIIIllllIllllI = Descriptor.toJvmName(lllllllllllllllIIllIIIllllIllllI);
        lllllllllllllllIIllIIIlllllIIIII = Descriptor.toJvmName(lllllllllllllllIIllIIIlllllIIIII);
        this.constPool.renameClass(lllllllllllllllIIllIIIllllIllllI, lllllllllllllllIIllIIIlllllIIIII);
        AttributeInfo.renameClass(this.attributes, lllllllllllllllIIllIIIllllIllllI, lllllllllllllllIIllIIIlllllIIIII);
        for (final MethodInfo lllllllllllllllIIllIIIlllllIIlIl : this.methods) {
            final String lllllllllllllllIIllIIIlllllIIllI = lllllllllllllllIIllIIIlllllIIlIl.getDescriptor();
            lllllllllllllllIIllIIIlllllIIlIl.setDescriptor(Descriptor.rename(lllllllllllllllIIllIIIlllllIIllI, lllllllllllllllIIllIIIllllIllllI, lllllllllllllllIIllIIIlllllIIIII));
            AttributeInfo.renameClass(lllllllllllllllIIllIIIlllllIIlIl.getAttributes(), lllllllllllllllIIllIIIllllIllllI, lllllllllllllllIIllIIIlllllIIIII);
        }
        for (final FieldInfo lllllllllllllllIIllIIIlllllIIIll : this.fields) {
            final String lllllllllllllllIIllIIIlllllIIlII = lllllllllllllllIIllIIIlllllIIIll.getDescriptor();
            lllllllllllllllIIllIIIlllllIIIll.setDescriptor(Descriptor.rename(lllllllllllllllIIllIIIlllllIIlII, lllllllllllllllIIllIIIllllIllllI, lllllllllllllllIIllIIIlllllIIIII));
            AttributeInfo.renameClass(lllllllllllllllIIllIIIlllllIIIll.getAttributes(), lllllllllllllllIIllIIIllllIllllI, lllllllllllllllIIllIIIlllllIIIII);
        }
    }
    
    public String getName() {
        return this.thisclassname;
    }
    
    private static String getSourcefileName(final String lllllllllllllllIIllIIlIIIlIlllII) {
        return String.valueOf(new StringBuilder().append(lllllllllllllllIIllIIlIIIlIlllII.replaceAll("^.*\\.", "")).append(".java"));
    }
    
    public final void addField2(final FieldInfo lllllllllllllllIIllIIIlllIIIIlII) {
        this.fields.add(lllllllllllllllIIllIIIlllIIIIlII);
    }
    
    public final void renameClass(final Map<String, String> lllllllllllllllIIllIIIllllIIlIll) {
        final String lllllllllllllllIIllIIIllllIIllIl = lllllllllllllllIIllIIIllllIIlIll.get(Descriptor.toJvmName(this.thisclassname));
        if (lllllllllllllllIIllIIIllllIIllIl != null) {
            this.thisclassname = Descriptor.toJavaName(lllllllllllllllIIllIIIllllIIllIl);
        }
        this.constPool.renameClass(lllllllllllllllIIllIIIllllIIlIll);
        AttributeInfo.renameClass(this.attributes, lllllllllllllllIIllIIIllllIIlIll);
        for (final MethodInfo lllllllllllllllIIllIIIllllIlIIlI : this.methods) {
            final String lllllllllllllllIIllIIIllllIlIIll = lllllllllllllllIIllIIIllllIlIIlI.getDescriptor();
            lllllllllllllllIIllIIIllllIlIIlI.setDescriptor(Descriptor.rename(lllllllllllllllIIllIIIllllIlIIll, lllllllllllllllIIllIIIllllIIlIll));
            AttributeInfo.renameClass(lllllllllllllllIIllIIIllllIlIIlI.getAttributes(), lllllllllllllllIIllIIIllllIIlIll);
        }
        for (final FieldInfo lllllllllllllllIIllIIIllllIlIIII : this.fields) {
            final String lllllllllllllllIIllIIIllllIlIIIl = lllllllllllllllIIllIIIllllIlIIII.getDescriptor();
            lllllllllllllllIIllIIIllllIlIIII.setDescriptor(Descriptor.rename(lllllllllllllllIIllIIIllllIlIIIl, lllllllllllllllIIllIIIllllIIlIll));
            AttributeInfo.renameClass(lllllllllllllllIIllIIIllllIlIIII.getAttributes(), lllllllllllllllIIllIIIllllIIlIll);
        }
    }
    
    public MethodInfo getStaticInitializer() {
        return this.getMethod("<clinit>");
    }
    
    public String getSuperclass() {
        if (this.cachedSuperclass == null) {
            this.cachedSuperclass = this.constPool.getClassInfo(this.superClass);
        }
        return this.cachedSuperclass;
    }
    
    public void setAccessFlags(int lllllllllllllllIIllIIlIIIIIlIlll) {
        if ((lllllllllllllllIIllIIlIIIIIlIlll & 0x200) == 0x0) {
            lllllllllllllllIIllIIlIIIIIlIlll |= 0x20;
        }
        this.accessFlags = (int)lllllllllllllllIIllIIlIIIIIlIlll;
    }
    
    private void initSuperclass(final String lllllllllllllllIIllIIlIIIllIIlll) {
        if (lllllllllllllllIIllIIlIIIllIIlll != null) {
            this.superClass = this.constPool.addClassInfo(lllllllllllllllIIllIIlIIIllIIlll);
            this.cachedSuperclass = lllllllllllllllIIllIIlIIIllIIlll;
        }
        else {
            this.superClass = this.constPool.addClassInfo("java.lang.Object");
            this.cachedSuperclass = "java.lang.Object";
        }
    }
    
    public void setName(final String lllllllllllllllIIllIIIllllllllll) {
        this.renameClass(this.thisclassname, lllllllllllllllIIllIIIllllllllll);
    }
    
    public int getMajorVersion() {
        return this.major;
    }
    
    public AttributeInfo getAttribute(final String lllllllllllllllIIllIIIllIIlIllIl) {
        for (final AttributeInfo lllllllllllllllIIllIIIllIIllIIIl : this.attributes) {
            if (lllllllllllllllIIllIIIllIIllIIIl.getName().equals(lllllllllllllllIIllIIIllIIlIllIl)) {
                return lllllllllllllllIIllIIIllIIllIIIl;
            }
        }
        return null;
    }
    
    public void addMethod(final MethodInfo lllllllllllllllIIllIIIllIllIIIIl) throws DuplicateMemberException {
        this.testExistingMethod(lllllllllllllllIIllIIIllIllIIIIl);
        this.methods.add(lllllllllllllllIIllIIIllIllIIIIl);
    }
    
    public void prune() {
        final ConstPool lllllllllllllllIIllIIlIIIIlllIII = this.compact0();
        final List<AttributeInfo> lllllllllllllllIIllIIlIIIIllIlll = new ArrayList<AttributeInfo>();
        AttributeInfo lllllllllllllllIIllIIlIIIIllIllI = this.getAttribute("RuntimeInvisibleAnnotations");
        if (lllllllllllllllIIllIIlIIIIllIllI != null) {
            lllllllllllllllIIllIIlIIIIllIllI = lllllllllllllllIIllIIlIIIIllIllI.copy(lllllllllllllllIIllIIlIIIIlllIII, null);
            lllllllllllllllIIllIIlIIIIllIlll.add(lllllllllllllllIIllIIlIIIIllIllI);
        }
        AttributeInfo lllllllllllllllIIllIIlIIIIllIlIl = this.getAttribute("RuntimeVisibleAnnotations");
        if (lllllllllllllllIIllIIlIIIIllIlIl != null) {
            lllllllllllllllIIllIIlIIIIllIlIl = lllllllllllllllIIllIIlIIIIllIlIl.copy(lllllllllllllllIIllIIlIIIIlllIII, null);
            lllllllllllllllIIllIIlIIIIllIlll.add(lllllllllllllllIIllIIlIIIIllIlIl);
        }
        AttributeInfo lllllllllllllllIIllIIlIIIIllIlII = this.getAttribute("Signature");
        if (lllllllllllllllIIllIIlIIIIllIlII != null) {
            lllllllllllllllIIllIIlIIIIllIlII = lllllllllllllllIIllIIlIIIIllIlII.copy(lllllllllllllllIIllIIlIIIIlllIII, null);
            lllllllllllllllIIllIIlIIIIllIlll.add(lllllllllllllllIIllIIlIIIIllIlII);
        }
        for (final MethodInfo lllllllllllllllIIllIIlIIIIlllIll : this.methods) {
            lllllllllllllllIIllIIlIIIIlllIll.prune(lllllllllllllllIIllIIlIIIIlllIII);
        }
        for (final FieldInfo lllllllllllllllIIllIIlIIIIlllIlI : this.fields) {
            lllllllllllllllIIllIIlIIIIlllIlI.prune(lllllllllllllllIIllIIlIIIIlllIII);
        }
        this.attributes = lllllllllllllllIIllIIlIIIIllIlll;
        this.constPool = lllllllllllllllIIllIIlIIIIlllIII;
    }
    
    public MethodInfo getMethod(final String lllllllllllllllIIllIIIllIllIllII) {
        for (final MethodInfo lllllllllllllllIIllIIIllIlllIIII : this.methods) {
            if (lllllllllllllllIIllIIIllIlllIIII.getName().equals(lllllllllllllllIIllIIIllIllIllII)) {
                return lllllllllllllllIIllIIIllIlllIIII;
            }
        }
        return null;
    }
    
    public boolean isInterface() {
        return (this.accessFlags & 0x200) != 0x0;
    }
    
    private static boolean isDuplicated(final MethodInfo lllllllllllllllIIllIIIllIlIIIllI, final String lllllllllllllllIIllIIIllIlIIIIII, final String lllllllllllllllIIllIIIllIlIIIlII, final MethodInfo lllllllllllllllIIllIIIllIIlllllI, final ListIterator<MethodInfo> lllllllllllllllIIllIIIllIlIIIIlI) {
        if (!lllllllllllllllIIllIIIllIIlllllI.getName().equals(lllllllllllllllIIllIIIllIlIIIIII)) {
            return false;
        }
        final String lllllllllllllllIIllIIIllIlIIIIIl = lllllllllllllllIIllIIIllIIlllllI.getDescriptor();
        if (!Descriptor.eqParamTypes(lllllllllllllllIIllIIIllIlIIIIIl, lllllllllllllllIIllIIIllIlIIIlII)) {
            return false;
        }
        if (!lllllllllllllllIIllIIIllIlIIIIIl.equals(lllllllllllllllIIllIIIllIlIIIlII)) {
            return false;
        }
        if (notBridgeMethod(lllllllllllllllIIllIIIllIIlllllI)) {
            return true;
        }
        lllllllllllllllIIllIIIllIlIIIIlI.remove();
        return false;
    }
    
    public boolean isAbstract() {
        return (this.accessFlags & 0x400) != 0x0;
    }
    
    public List<AttributeInfo> getAttributes() {
        return this.attributes;
    }
    
    public void setInterfaces(final String[] lllllllllllllllIIllIIIlllIlIIIll) {
        this.cachedInterfaces = null;
        if (lllllllllllllllIIllIIIlllIlIIIll != null) {
            this.interfaces = new int[lllllllllllllllIIllIIIlllIlIIIll.length];
            for (int lllllllllllllllIIllIIIlllIlIIlll = 0; lllllllllllllllIIllIIIlllIlIIlll < lllllllllllllllIIllIIIlllIlIIIll.length; ++lllllllllllllllIIllIIIlllIlIIlll) {
                this.interfaces[lllllllllllllllIIllIIIlllIlIIlll] = this.constPool.addClassInfo(lllllllllllllllIIllIIIlllIlIIIll[lllllllllllllllIIllIIIlllIlIIlll]);
            }
        }
    }
    
    static {
        JAVA_3 = 47;
        JAVA_10 = 54;
        JAVA_1 = 45;
        JAVA_7 = 51;
        JAVA_11 = 55;
        JAVA_5 = 49;
        JAVA_8 = 52;
        JAVA_2 = 46;
        JAVA_6 = 50;
        JAVA_9 = 53;
        JAVA_4 = 48;
        int lllllllllllllllIIllIIIlIllIllIll = 47;
        try {
            Class.forName("java.lang.StringBuilder");
            lllllllllllllllIIllIIIlIllIllIll = 49;
            Class.forName("java.util.zip.DeflaterInputStream");
            lllllllllllllllIIllIIIlIllIllIll = 50;
            Class.forName("java.lang.invoke.CallSite", false, ClassLoader.getSystemClassLoader());
            lllllllllllllllIIllIIIlIllIllIll = 51;
            Class.forName("java.util.function.Function");
            lllllllllllllllIIllIIIlIllIllIll = 52;
            Class.forName("java.lang.Module");
            lllllllllllllllIIllIIIlIllIllIll = 53;
            List.class.getMethod("copyOf", Collection.class);
            lllllllllllllllIIllIIIlIllIllIll = 54;
            Class.forName("java.util.Optional").getMethod("isEmpty", (Class<?>[])new Class[0]);
            lllllllllllllllIIllIIIlIllIllIll = 55;
        }
        catch (Throwable t) {}
        MAJOR_VERSION = lllllllllllllllIIllIIIlIllIllIll;
    }
    
    public int getMinorVersion() {
        return this.minor;
    }
    
    public List<FieldInfo> getFields() {
        return this.fields;
    }
    
    public void write(final DataOutputStream lllllllllllllllIIllIIIlIlllllIll) throws IOException {
        lllllllllllllllIIllIIIlIlllllIll.writeInt(-889275714);
        lllllllllllllllIIllIIIlIlllllIll.writeShort(this.minor);
        lllllllllllllllIIllIIIlIlllllIll.writeShort(this.major);
        this.constPool.write(lllllllllllllllIIllIIIlIlllllIll);
        lllllllllllllllIIllIIIlIlllllIll.writeShort(this.accessFlags);
        lllllllllllllllIIllIIIlIlllllIll.writeShort(this.thisClass);
        lllllllllllllllIIllIIIlIlllllIll.writeShort(this.superClass);
        int lllllllllllllllIIllIIIlIlllllIIl = 0;
        if (this.interfaces == null) {
            final int lllllllllllllllIIllIIIlIllllllll = 0;
        }
        else {
            lllllllllllllllIIllIIIlIlllllIIl = this.interfaces.length;
        }
        lllllllllllllllIIllIIIlIlllllIll.writeShort(lllllllllllllllIIllIIIlIlllllIIl);
        for (int lllllllllllllllIIllIIIlIlllllIlI = 0; lllllllllllllllIIllIIIlIlllllIlI < lllllllllllllllIIllIIIlIlllllIIl; ++lllllllllllllllIIllIIIlIlllllIlI) {
            lllllllllllllllIIllIIIlIlllllIll.writeShort(this.interfaces[lllllllllllllllIIllIIIlIlllllIlI]);
        }
        lllllllllllllllIIllIIIlIlllllIIl = this.fields.size();
        lllllllllllllllIIllIIIlIlllllIll.writeShort(lllllllllllllllIIllIIIlIlllllIIl);
        for (int lllllllllllllllIIllIIIlIlllllIlI = 0; lllllllllllllllIIllIIIlIlllllIlI < lllllllllllllllIIllIIIlIlllllIIl; ++lllllllllllllllIIllIIIlIlllllIlI) {
            final FieldInfo lllllllllllllllIIllIIIlIlllllllI = this.fields.get(lllllllllllllllIIllIIIlIlllllIlI);
            lllllllllllllllIIllIIIlIlllllllI.write(lllllllllllllllIIllIIIlIlllllIll);
        }
        lllllllllllllllIIllIIIlIlllllIll.writeShort(this.methods.size());
        for (final MethodInfo lllllllllllllllIIllIIIlIllllllIl : this.methods) {
            lllllllllllllllIIllIIIlIllllllIl.write(lllllllllllllllIIllIIIlIlllllIll);
        }
        lllllllllllllllIIllIIIlIlllllIll.writeShort(this.attributes.size());
        AttributeInfo.writeAll(this.attributes, lllllllllllllllIIllIIIlIlllllIll);
    }
    
    public List<MethodInfo> getMethods() {
        return this.methods;
    }
    
    private static boolean notBridgeMethod(final MethodInfo lllllllllllllllIIllIIIllIIlllIlI) {
        return (lllllllllllllllIIllIIIllIIlllIlI.getAccessFlags() & 0x40) == 0x0;
    }
    
    private void testExistingMethod(final MethodInfo lllllllllllllllIIllIIIllIlIIllll) throws DuplicateMemberException {
        final String lllllllllllllllIIllIIIllIlIlIIll = lllllllllllllllIIllIIIllIlIIllll.getName();
        final String lllllllllllllllIIllIIIllIlIlIIlI = lllllllllllllllIIllIIIllIlIIllll.getDescriptor();
        final ListIterator<MethodInfo> lllllllllllllllIIllIIIllIlIlIIIl = this.methods.listIterator(0);
        while (lllllllllllllllIIllIIIllIlIlIIIl.hasNext()) {
            if (isDuplicated(lllllllllllllllIIllIIIllIlIIllll, lllllllllllllllIIllIIIllIlIlIIll, lllllllllllllllIIllIIIllIlIlIIlI, lllllllllllllllIIllIIIllIlIlIIIl.next(), lllllllllllllllIIllIIIllIlIlIIIl)) {
                throw new DuplicateMemberException(String.valueOf(new StringBuilder().append("duplicate method: ").append(lllllllllllllllIIllIIIllIlIlIIll).append(" in ").append(this.getName())));
            }
        }
    }
    
    public AttributeInfo removeAttribute(final String lllllllllllllllIIllIIIllIIlIIlll) {
        return AttributeInfo.remove(this.attributes, lllllllllllllllIIllIIIllIIlIIlll);
    }
}
