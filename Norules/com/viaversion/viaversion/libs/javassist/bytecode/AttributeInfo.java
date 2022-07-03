package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class AttributeInfo
{
    protected /* synthetic */ ConstPool constPool;
    /* synthetic */ int name;
    /* synthetic */ byte[] info;
    
    static List<AttributeInfo> copyAll(final List<AttributeInfo> lllllllllllllIIlIlllIIIlIIlIIIlI, final ConstPool lllllllllllllIIlIlllIIIlIIlIIlII) {
        if (lllllllllllllIIlIlllIIIlIIlIIIlI == null) {
            return null;
        }
        final List<AttributeInfo> lllllllllllllIIlIlllIIIlIIlIIIll = new ArrayList<AttributeInfo>();
        for (final AttributeInfo lllllllllllllIIlIlllIIIlIIlIIllI : lllllllllllllIIlIlllIIIlIIlIIIlI) {
            lllllllllllllIIlIlllIIIlIIlIIIll.add(lllllllllllllIIlIlllIIIlIIlIIllI.copy(lllllllllllllIIlIlllIIIlIIlIIlII, null));
        }
        return lllllllllllllIIlIlllIIIlIIlIIIll;
    }
    
    static void writeAll(final List<AttributeInfo> lllllllllllllIIlIlllIIIlIIlIllll, final DataOutputStream lllllllllllllIIlIlllIIIlIIllIIII) throws IOException {
        if (lllllllllllllIIlIlllIIIlIIlIllll == null) {
            return;
        }
        for (final AttributeInfo lllllllllllllIIlIlllIIIlIIllIIlI : lllllllllllllIIlIlllIIIlIIlIllll) {
            lllllllllllllIIlIlllIIIlIIllIIlI.write(lllllllllllllIIlIlllIIIlIIllIIII);
        }
    }
    
    public AttributeInfo copy(final ConstPool lllllllllllllIIlIlllIIIlIlIllllI, final Map<String, String> lllllllllllllIIlIlllIIIlIllIIIII) {
        return new AttributeInfo(lllllllllllllIIlIlllIIIlIlIllllI, this.getName(), Arrays.copyOf(this.info, this.info.length));
    }
    
    protected AttributeInfo(final ConstPool lllllllllllllIIlIlllIIIllIIIlIIl, final int lllllllllllllIIlIlllIIIllIIIlIII, final DataInputStream lllllllllllllIIlIlllIIIllIIIIlll) throws IOException {
        this.constPool = lllllllllllllIIlIlllIIIllIIIlIIl;
        this.name = lllllllllllllIIlIlllIIIllIIIlIII;
        final int lllllllllllllIIlIlllIIIllIIIlIll = lllllllllllllIIlIlllIIIllIIIIlll.readInt();
        this.info = new byte[lllllllllllllIIlIlllIIIllIIIlIll];
        if (lllllllllllllIIlIlllIIIllIIIlIll > 0) {
            lllllllllllllIIlIlllIIIllIIIIlll.readFully(this.info);
        }
    }
    
    public String getName() {
        return this.constPool.getUtf8Info(this.name);
    }
    
    public AttributeInfo(final ConstPool lllllllllllllIIlIlllIIIllIIllIll, final String lllllllllllllIIlIlllIIIllIIlIllI, final byte[] lllllllllllllIIlIlllIIIllIIlIlIl) {
        this(lllllllllllllIIlIlllIIIllIIllIll, lllllllllllllIIlIlllIIIllIIllIll.addUtf8Info(lllllllllllllIIlIlllIIIllIIlIllI), lllllllllllllIIlIlllIIIllIIlIlIl);
    }
    
    void renameClass(final String lllllllllllllIIlIlllIIIlIIIlllII, final String lllllllllllllIIlIlllIIIlIIIllIll) {
    }
    
    protected AttributeInfo(final ConstPool lllllllllllllIIlIlllIIIllIlIllII, final int lllllllllllllIIlIlllIIIllIlIllll, final byte[] lllllllllllllIIlIlllIIIllIlIlllI) {
        this.constPool = lllllllllllllIIlIlllIIIllIlIllII;
        this.name = lllllllllllllIIlIlllIIIllIlIllll;
        this.info = lllllllllllllIIlIlllIIIllIlIlllI;
    }
    
    public byte[] get() {
        return this.info;
    }
    
    static void renameClass(final List<AttributeInfo> lllllllllllllIIlIlllIIIlIIIIIlIl, final Map<String, String> lllllllllllllIIlIlllIIIlIIIIIlII) {
        if (lllllllllllllIIlIlllIIIlIIIIIlIl == null) {
            return;
        }
        for (final AttributeInfo lllllllllllllIIlIlllIIIlIIIIIllI : lllllllllllllIIlIlllIIIlIIIIIlIl) {
            lllllllllllllIIlIlllIIIlIIIIIllI.renameClass(lllllllllllllIIlIlllIIIlIIIIIlII);
        }
    }
    
    static AttributeInfo lookup(final List<AttributeInfo> lllllllllllllIIlIlllIIIlIlIIIlIl, final String lllllllllllllIIlIlllIIIlIlIIIlII) {
        if (lllllllllllllIIlIlllIIIlIlIIIlIl == null) {
            return null;
        }
        for (final AttributeInfo lllllllllllllIIlIlllIIIlIlIIlIII : lllllllllllllIIlIlllIIIlIlIIIlIl) {
            if (lllllllllllllIIlIlllIIIlIlIIlIII.getName().equals(lllllllllllllIIlIlllIIIlIlIIIlII)) {
                return lllllllllllllIIlIlllIIIlIlIIlIII;
            }
        }
        return null;
    }
    
    void getRefClasses(final Map<String, String> lllllllllllllIIlIlllIIIIlllllllI) {
    }
    
    static int getLength(final List<AttributeInfo> lllllllllllllIIlIlllIIIlIlIlIIlI) {
        int lllllllllllllIIlIlllIIIlIlIlIIIl = 0;
        for (final AttributeInfo lllllllllllllIIlIlllIIIlIlIlIIll : lllllllllllllIIlIlllIIIlIlIlIIlI) {
            lllllllllllllIIlIlllIIIlIlIlIIIl += lllllllllllllIIlIlllIIIlIlIlIIll.length();
        }
        return lllllllllllllIIlIlllIIIlIlIlIIIl;
    }
    
    static synchronized AttributeInfo remove(final List<AttributeInfo> lllllllllllllIIlIlllIIIlIIlllIlI, final String lllllllllllllIIlIlllIIIlIIlllIIl) {
        if (lllllllllllllIIlIlllIIIlIIlllIlI == null) {
            return null;
        }
        for (final AttributeInfo lllllllllllllIIlIlllIIIlIIllllIl : lllllllllllllIIlIlllIIIlIIlllIlI) {
            if (lllllllllllllIIlIlllIIIlIIllllIl.getName().equals(lllllllllllllIIlIlllIIIlIIlllIIl) && lllllllllllllIIlIlllIIIlIIlllIlI.remove(lllllllllllllIIlIlllIIIlIIllllIl)) {
                return lllllllllllllIIlIlllIIIlIIllllIl;
            }
        }
        return null;
    }
    
    public void set(final byte[] lllllllllllllIIlIlllIIIlIllIIlIl) {
        this.info = lllllllllllllIIlIlllIIIlIllIIlIl;
    }
    
    public ConstPool getConstPool() {
        return this.constPool;
    }
    
    protected AttributeInfo(final ConstPool lllllllllllllIIlIlllIIIllIlIIIlI, final String lllllllllllllIIlIlllIIIllIlIIIIl) {
        this(lllllllllllllIIlIlllIIIllIlIIIlI, lllllllllllllIIlIlllIIIllIlIIIIl, null);
    }
    
    static void getRefClasses(final List<AttributeInfo> lllllllllllllIIlIlllIIIIllllIllI, final Map<String, String> lllllllllllllIIlIlllIIIIllllIlll) {
        if (lllllllllllllIIlIlllIIIIllllIllI == null) {
            return;
        }
        for (final AttributeInfo lllllllllllllIIlIlllIIIIlllllIIl : lllllllllllllIIlIlllIIIIllllIllI) {
            lllllllllllllIIlIlllIIIIlllllIIl.getRefClasses(lllllllllllllIIlIlllIIIIllllIlll);
        }
    }
    
    void write(final DataOutputStream lllllllllllllIIlIlllIIIlIlIllIII) throws IOException {
        lllllllllllllIIlIlllIIIlIlIllIII.writeShort(this.name);
        lllllllllllllIIlIlllIIIlIlIllIII.writeInt(this.info.length);
        if (this.info.length > 0) {
            lllllllllllllIIlIlllIIIlIlIllIII.write(this.info);
        }
    }
    
    static AttributeInfo read(final ConstPool lllllllllllllIIlIlllIIIllIIIIIII, final DataInputStream lllllllllllllIIlIlllIIIlIlllllll) throws IOException {
        final int lllllllllllllIIlIlllIIIlIllllllI = lllllllllllllIIlIlllIIIlIlllllll.readUnsignedShort();
        final String lllllllllllllIIlIlllIIIlIlllllIl = lllllllllllllIIlIlllIIIllIIIIIII.getUtf8Info(lllllllllllllIIlIlllIIIlIllllllI);
        final char lllllllllllllIIlIlllIIIlIlllllII = lllllllllllllIIlIlllIIIlIlllllIl.charAt(0);
        if (lllllllllllllIIlIlllIIIlIlllllII < 'E') {
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("AnnotationDefault")) {
                return new AnnotationDefaultAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("BootstrapMethods")) {
                return new BootstrapMethodsAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("Code")) {
                return new CodeAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("ConstantValue")) {
                return new ConstantAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("Deprecated")) {
                return new DeprecatedAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
        }
        if (lllllllllllllIIlIlllIIIlIlllllII < 'M') {
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("EnclosingMethod")) {
                return new EnclosingMethodAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("Exceptions")) {
                return new ExceptionsAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("InnerClasses")) {
                return new InnerClassesAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("LineNumberTable")) {
                return new LineNumberAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("LocalVariableTable")) {
                return new LocalVariableAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("LocalVariableTypeTable")) {
                return new LocalVariableTypeAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
        }
        if (lllllllllllllIIlIlllIIIlIlllllII < 'S') {
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("MethodParameters")) {
                return new MethodParametersAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("NestHost")) {
                return new NestHostAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("NestMembers")) {
                return new NestMembersAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("RuntimeVisibleAnnotations") || lllllllllllllIIlIlllIIIlIlllllIl.equals("RuntimeInvisibleAnnotations")) {
                return new AnnotationsAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("RuntimeVisibleParameterAnnotations") || lllllllllllllIIlIlllIIIlIlllllIl.equals("RuntimeInvisibleParameterAnnotations")) {
                return new ParameterAnnotationsAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("RuntimeVisibleTypeAnnotations") || lllllllllllllIIlIlllIIIlIlllllIl.equals("RuntimeInvisibleTypeAnnotations")) {
                return new TypeAnnotationsAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
        }
        if (lllllllllllllIIlIlllIIIlIlllllII >= 'S') {
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("Signature")) {
                return new SignatureAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("SourceFile")) {
                return new SourceFileAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("Synthetic")) {
                return new SyntheticAttribute(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("StackMap")) {
                return new StackMap(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
            if (lllllllllllllIIlIlllIIIlIlllllIl.equals("StackMapTable")) {
                return new StackMapTable(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
            }
        }
        return new AttributeInfo(lllllllllllllIIlIlllIIIllIIIIIII, lllllllllllllIIlIlllIIIlIllllllI, lllllllllllllIIlIlllIIIlIlllllll);
    }
    
    static void renameClass(final List<AttributeInfo> lllllllllllllIIlIlllIIIlIIIIllll, final String lllllllllllllIIlIlllIIIlIIIIlllI, final String lllllllllllllIIlIlllIIIlIIIIllIl) {
        if (lllllllllllllIIlIlllIIIlIIIIllll == null) {
            return;
        }
        for (final AttributeInfo lllllllllllllIIlIlllIIIlIIIlIIll : lllllllllllllIIlIlllIIIlIIIIllll) {
            lllllllllllllIIlIlllIIIlIIIlIIll.renameClass(lllllllllllllIIlIlllIIIlIIIIlllI, lllllllllllllIIlIlllIIIlIIIIllIl);
        }
    }
    
    void renameClass(final Map<String, String> lllllllllllllIIlIlllIIIlIIIllIIl) {
    }
    
    public int length() {
        return this.info.length + 6;
    }
}
