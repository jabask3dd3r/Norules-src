package com.viaversion.viaversion.libs.javassist;

import java.security.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.expr.*;
import java.net.*;
import java.lang.invoke.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;
import java.io.*;
import java.util.*;

public abstract class CtClass
{
    static /* synthetic */ CtClass[] primitiveTypes;
    public static /* synthetic */ CtClass charType;
    protected /* synthetic */ String qualifiedName;
    public static /* synthetic */ String debugDump;
    public static /* synthetic */ CtClass longType;
    public static /* synthetic */ CtClass voidType;
    public static /* synthetic */ CtClass doubleType;
    public static /* synthetic */ CtClass intType;
    public static /* synthetic */ CtClass booleanType;
    public static /* synthetic */ CtClass floatType;
    public static /* synthetic */ CtClass byteType;
    public static /* synthetic */ CtClass shortType;
    
    public void replaceClassName(final ClassMap lllllllllllllIIlllIIllIlllIlIlIl) {
        this.checkModify();
    }
    
    public Class<?> toClass() throws CannotCompileException {
        return (Class<?>)this.getClassPool().toClass(this);
    }
    
    public final String getPackageName() {
        final String lllllllllllllIIlllIIllIllllIllII = this.qualifiedName;
        final int lllllllllllllIIlllIIllIllllIlIll = lllllllllllllIIlllIIllIllllIllII.lastIndexOf(46);
        if (lllllllllllllIIlllIIllIllllIlIll < 0) {
            return null;
        }
        return lllllllllllllIIlllIIllIllllIllII.substring(0, lllllllllllllIIlllIIllIllllIlIll);
    }
    
    @Deprecated
    public final Class<?> toClass(final ClassLoader lllllllllllllIIlllIIllIlIIIIIlIl) throws CannotCompileException {
        return (Class<?>)this.getClassPool().toClass(this, null, lllllllllllllIIlllIIllIlIIIIIlIl, null);
    }
    
    public void addField(final CtField lllllllllllllIIlllIIllIlIIlllIll, final CtField.Initializer lllllllllllllIIlllIIllIlIIlllIlI) throws CannotCompileException {
        this.checkModify();
    }
    
    void compress() {
    }
    
    public Object[] getAnnotations() throws ClassNotFoundException {
        return new Object[0];
    }
    
    public final String getSimpleName() {
        final String lllllllllllllIIlllIIllIlllllIlIl = this.qualifiedName;
        final int lllllllllllllIIlllIIllIlllllIlII = lllllllllllllIIlllIIllIlllllIlIl.lastIndexOf(46);
        if (lllllllllllllIIlllIIllIlllllIlII < 0) {
            return lllllllllllllIIlllIIllIlllllIlIl;
        }
        return lllllllllllllIIlllIIllIlllllIlIl.substring(lllllllllllllIIlllIIllIlllllIlII + 1);
    }
    
    public CtConstructor[] getConstructors() {
        return new CtConstructor[0];
    }
    
    public CtConstructor makeClassInitializer() throws CannotCompileException {
        throw new CannotCompileException("not a class");
    }
    
    public CtMethod getMethod(final String lllllllllllllIIlllIIllIlIllIlIII, final String lllllllllllllIIlllIIllIlIllIlIIl) throws NotFoundException {
        throw new NotFoundException(lllllllllllllIIlllIIllIlIllIlIII);
    }
    
    public CtConstructor getClassInitializer() {
        return null;
    }
    
    public void detach() {
        final ClassPool lllllllllllllIIlllIIllIlIIIIIIII = this.getClassPool();
        final CtClass lllllllllllllIIlllIIllIIllllllll = lllllllllllllIIlllIIllIlIIIIIIII.removeCached(this.getName());
        if (lllllllllllllIIlllIIllIIllllllll != this) {
            lllllllllllllIIlllIIllIlIIIIIIII.cacheCtClass(this.getName(), lllllllllllllIIlllIIllIIllllllll, false);
        }
    }
    
    public CtMethod[] getDeclaredMethods(final String lllllllllllllIIlllIIllIlIlIlllll) throws NotFoundException {
        throw new NotFoundException(lllllllllllllIIlllIIllIlIlIlllll);
    }
    
    public CtConstructor[] getDeclaredConstructors() {
        return new CtConstructor[0];
    }
    
    public boolean isPrimitive() {
        return false;
    }
    
    public CtConstructor getDeclaredConstructor(final CtClass[] lllllllllllllIIlllIIllIlIlllIIll) throws NotFoundException {
        final String lllllllllllllIIlllIIllIlIlllIIlI = Descriptor.ofConstructor(lllllllllllllIIlllIIllIlIlllIIll);
        return this.getConstructor(lllllllllllllIIlllIIllIlIlllIIlI);
    }
    
    public boolean isInterface() {
        return false;
    }
    
    public void instrument(final CodeConverter lllllllllllllIIlllIIllIlIIlIlIll) throws CannotCompileException {
        this.checkModify();
    }
    
    public CtMethod[] getMethods() {
        return new CtMethod[0];
    }
    
    public CtField[] getDeclaredFields() {
        return new CtField[0];
    }
    
    public String getGenericSignature() {
        return null;
    }
    
    public CtClass getSuperclass() throws NotFoundException {
        return null;
    }
    
    public void rebuildClassFile() {
    }
    
    public byte[] toBytecode() throws CannotCompileException, IOException {
        final ByteArrayOutputStream lllllllllllllIIlllIIllIIllllIIIl = new ByteArrayOutputStream();
        final DataOutputStream lllllllllllllIIlllIIllIIllllIIII = new DataOutputStream(lllllllllllllIIlllIIllIIllllIIIl);
        try {
            this.toBytecode(lllllllllllllIIlllIIllIIllllIIII);
        }
        finally {
            lllllllllllllIIlllIIllIIllllIIII.close();
        }
        return lllllllllllllIIlllIIllIIllllIIIl.toByteArray();
    }
    
    public boolean isFrozen() {
        return true;
    }
    
    public void setName(final String lllllllllllllIIlllIIllIllllIIIlI) {
        this.checkModify();
        if (lllllllllllllIIlllIIllIllllIIIlI != null) {
            this.qualifiedName = lllllllllllllIIlllIIllIllllIIIlI;
        }
    }
    
    public CtClass getDeclaringClass() throws NotFoundException {
        return null;
    }
    
    public void prune() {
    }
    
    public boolean hasAnnotation(final Class<?> lllllllllllllIIlllIIllIlllIIIIll) {
        return this.hasAnnotation(lllllllllllllIIlllIIllIlllIIIIll.getName());
    }
    
    public ClassFile getClassFile2() {
        return null;
    }
    
    public void addField(final CtField lllllllllllllIIlllIIllIlIlIIIlIl) throws CannotCompileException {
        this.addField(lllllllllllllIIlllIIllIlIlIIIlIl, (CtField.Initializer)null);
    }
    
    public Object[] getAvailableAnnotations() {
        return new Object[0];
    }
    
    public CtField getField(final String lllllllllllllIIlllIIllIllIIlIIIl) throws NotFoundException {
        return this.getField(lllllllllllllIIlllIIllIllIIlIIIl, null);
    }
    
    public CtClass[] getInterfaces() throws NotFoundException {
        return new CtClass[0];
    }
    
    public void setSuperclass(final CtClass lllllllllllllIIlllIIllIllIlIllIl) throws CannotCompileException {
        this.checkModify();
    }
    
    public CtBehavior[] getDeclaredBehaviors() {
        return new CtBehavior[0];
    }
    
    public static void main(final String[] lllllllllllllIIlllIIlllIIIlIllIl) {
        System.out.println("Javassist version 3.28.0-GA");
        System.out.println("Copyright (C) 1999-2021 Shigeru Chiba. All Rights Reserved.");
    }
    
    public Object getAnnotation(final Class<?> lllllllllllllIIlllIIllIllIllllIl) throws ClassNotFoundException {
        return null;
    }
    
    public void addConstructor(final CtConstructor lllllllllllllIIlllIIllIlIlIlIllI) throws CannotCompileException {
        this.checkModify();
    }
    
    static {
        version = "3.28.0-GA";
        javaLangObject = "java.lang.Object";
        CtClass.debugDump = null;
        CtClass.primitiveTypes = new CtClass[9];
        CtClass.booleanType = new CtPrimitiveType("boolean", 'Z', "java.lang.Boolean", "booleanValue", "()Z", 172, 4, 1);
        CtClass.primitiveTypes[0] = CtClass.booleanType;
        CtClass.charType = new CtPrimitiveType("char", 'C', "java.lang.Character", "charValue", "()C", 172, 5, 1);
        CtClass.primitiveTypes[1] = CtClass.charType;
        CtClass.byteType = new CtPrimitiveType("byte", 'B', "java.lang.Byte", "byteValue", "()B", 172, 8, 1);
        CtClass.primitiveTypes[2] = CtClass.byteType;
        CtClass.shortType = new CtPrimitiveType("short", 'S', "java.lang.Short", "shortValue", "()S", 172, 9, 1);
        CtClass.primitiveTypes[3] = CtClass.shortType;
        CtClass.intType = new CtPrimitiveType("int", 'I', "java.lang.Integer", "intValue", "()I", 172, 10, 1);
        CtClass.primitiveTypes[4] = CtClass.intType;
        CtClass.longType = new CtPrimitiveType("long", 'J', "java.lang.Long", "longValue", "()J", 173, 11, 2);
        CtClass.primitiveTypes[5] = CtClass.longType;
        CtClass.floatType = new CtPrimitiveType("float", 'F', "java.lang.Float", "floatValue", "()F", 174, 6, 1);
        CtClass.primitiveTypes[6] = CtClass.floatType;
        CtClass.doubleType = new CtPrimitiveType("double", 'D', "java.lang.Double", "doubleValue", "()D", 175, 7, 2);
        CtClass.primitiveTypes[7] = CtClass.doubleType;
        CtClass.voidType = new CtPrimitiveType("void", 'V', "java.lang.Void", null, null, 177, 0, 0);
        CtClass.primitiveTypes[8] = CtClass.voidType;
    }
    
    protected DataOutputStream makeFileOutput(final String lllllllllllllIIlllIIllIIllIlIIII) {
        final String lllllllllllllIIlllIIllIIllIlIlII = this.getName();
        final String lllllllllllllIIlllIIllIIllIlIIll = String.valueOf(new StringBuilder().append(lllllllllllllIIlllIIllIIllIlIIII).append(File.separatorChar).append(lllllllllllllIIlllIIllIIllIlIlII.replace('.', File.separatorChar)).append(".class"));
        final int lllllllllllllIIlllIIllIIllIlIIlI = lllllllllllllIIlllIIllIIllIlIIll.lastIndexOf(File.separatorChar);
        if (lllllllllllllIIlllIIllIIllIlIIlI > 0) {
            final String lllllllllllllIIlllIIllIIllIlIlll = lllllllllllllIIlllIIllIIllIlIIll.substring(0, lllllllllllllIIlllIIllIIllIlIIlI);
            if (!lllllllllllllIIlllIIllIIllIlIlll.equals(".")) {
                new File(lllllllllllllIIlllIIllIIllIlIlll).mkdirs();
            }
        }
        return new DataOutputStream(new BufferedOutputStream(new DelayedFileOutputStream(lllllllllllllIIlllIIllIIllIlIIll)));
    }
    
    public boolean isArray() {
        return false;
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIIlllIIlllIIIlIIIll = new StringBuffer(this.getClass().getName());
        lllllllllllllIIlllIIlllIIIlIIIll.append("@");
        lllllllllllllIIlllIIlllIIIlIIIll.append(Integer.toHexString(this.hashCode()));
        lllllllllllllIIlllIIlllIIIlIIIll.append("[");
        this.extendToString(lllllllllllllIIlllIIlllIIIlIIIll);
        lllllllllllllIIlllIIlllIIIlIIIll.append("]");
        return lllllllllllllIIlllIIlllIIIlIIIll.toString();
    }
    
    public void instrument(final ExprEditor lllllllllllllIIlllIIllIlIIlIIlll) throws CannotCompileException {
        this.checkModify();
    }
    
    public void addMethod(final CtMethod lllllllllllllIIlllIIllIlIlIIlllI) throws CannotCompileException {
        this.checkModify();
    }
    
    public void writeFile(final String lllllllllllllIIlllIIllIIlllIIIll) throws CannotCompileException, IOException {
        final DataOutputStream lllllllllllllIIlllIIllIIlllIIIlI = this.makeFileOutput(lllllllllllllIIlllIIllIIlllIIIll);
        try {
            this.toBytecode(lllllllllllllIIlllIIllIIlllIIIlI);
        }
        finally {
            lllllllllllllIIlllIIllIIlllIIIlI.close();
        }
    }
    
    public CtClass makeNestedClass(final String lllllllllllllIIlllIIllIllIIllIII, final boolean lllllllllllllIIlllIIllIllIIlIlll) {
        throw new RuntimeException(String.valueOf(new StringBuilder().append(this.getName()).append(" is not a class")));
    }
    
    public CtClass getComponentType() throws NotFoundException {
        return null;
    }
    
    public CtField getField(final String lllllllllllllIIlllIIllIllIIIlIlI, final String lllllllllllllIIlllIIllIllIIIlIll) throws NotFoundException {
        throw new NotFoundException(lllllllllllllIIlllIIllIllIIIlIlI);
    }
    
    public synchronized Collection<String> getRefClasses() {
        final ClassFile lllllllllllllIIlllIIllIlllIIlllI = this.getClassFile2();
        if (lllllllllllllIIlllIIllIlllIIlllI != null) {
            final ClassMap lllllllllllllIIlllIIllIlllIlIIII = new ClassMap() {
                @Override
                public String put(final String lllllllllllllllIIlIlIIlIlIlllllI, final String lllllllllllllllIIlIlIIlIlIlllIII) {
                    return this.put0(lllllllllllllllIIlIlIIlIlIlllllI, lllllllllllllllIIlIlIIlIlIlllIII);
                }
                
                @Override
                public void fix(final String lllllllllllllllIIlIlIIlIlIlIllIl) {
                }
                
                @Override
                public String get(final Object lllllllllllllllIIlIlIIlIlIllIIII) {
                    final String lllllllllllllllIIlIlIIlIlIllIIlI = ClassMap.toJavaName((String)lllllllllllllllIIlIlIIlIlIllIIII);
                    this.put0(lllllllllllllllIIlIlIIlIlIllIIlI, lllllllllllllllIIlIlIIlIlIllIIlI);
                    return null;
                }
            };
            lllllllllllllIIlllIIllIlllIIlllI.getRefClasses(lllllllllllllIIlllIIllIlllIlIIII);
            return ((HashMap<K, String>)lllllllllllllIIlllIIllIlllIlIIII).values();
        }
        return null;
    }
    
    public void replaceClassName(final String lllllllllllllIIlllIIllIlllIllIlI, final String lllllllllllllIIlllIIllIlllIllIIl) {
        this.checkModify();
    }
    
    public void defrost() {
        throw new RuntimeException(String.valueOf(new StringBuilder().append("cannot defrost ").append(this.getName())));
    }
    
    public URL getURL() throws NotFoundException {
        throw new NotFoundException(this.getName());
    }
    
    public void removeField(final CtField lllllllllllllIIlllIIllIlIIllIllI) throws NotFoundException {
        this.checkModify();
    }
    
    public boolean stopPruning(final boolean lllllllllllllIIlllIIllIIlllllIlI) {
        return true;
    }
    
    public String getName() {
        return this.qualifiedName;
    }
    
    protected void extendToString(final StringBuffer lllllllllllllIIlllIIlllIIIIllIll) {
        lllllllllllllIIlllIIlllIIIIllIll.append(this.getName());
    }
    
    public void addField(final CtField lllllllllllllIIlllIIllIlIlIIIIII, final String lllllllllllllIIlllIIllIlIIllllll) throws CannotCompileException {
        this.checkModify();
    }
    
    public CtMethod getDeclaredMethod(final String lllllllllllllIIlllIIllIlIlIllIlI) throws NotFoundException {
        throw new NotFoundException(lllllllllllllIIlllIIllIlIlIllIlI);
    }
    
    public CtField[] getFields() {
        return new CtField[0];
    }
    
    public Class<?> toClass(ClassLoader lllllllllllllIIlllIIllIlIIIIllIl, final ProtectionDomain lllllllllllllIIlllIIllIlIIIlIIII) throws CannotCompileException {
        final ClassPool lllllllllllllIIlllIIllIlIIIIllll = this.getClassPool();
        if (lllllllllllllIIlllIIllIlIIIIllIl == null) {
            lllllllllllllIIlllIIllIlIIIIllIl = lllllllllllllIIlllIIllIlIIIIllll.getClassLoader();
        }
        return (Class<?>)lllllllllllllIIlllIIllIlIIIIllll.toClass(this, null, lllllllllllllIIlllIIllIlIIIIllIl, lllllllllllllIIlllIIllIlIIIlIIII);
    }
    
    public boolean isKotlin() {
        return this.hasAnnotation("kotlin.Metadata");
    }
    
    public Class<?> toClass(final Class<?> lllllllllllllIIlllIIllIlIIIlllll) throws CannotCompileException {
        return this.getClassPool().toClass(this, lllllllllllllIIlllIIllIlIIIlllll);
    }
    
    public Class<?> toClass(final MethodHandles.Lookup lllllllllllllIIlllIIllIlIIIllIIl) throws CannotCompileException {
        return this.getClassPool().toClass(this, lllllllllllllIIlllIIllIlIIIllIIl);
    }
    
    public void freeze() {
    }
    
    public void setInterfaces(final CtClass[] lllllllllllllIIlllIIllIllIlIlIII) {
        this.checkModify();
    }
    
    public CtField getDeclaredField(final String lllllllllllllIIlllIIllIllIIIIIll) throws NotFoundException {
        throw new NotFoundException(lllllllllllllIIlllIIllIllIIIIIll);
    }
    
    public boolean isModified() {
        return false;
    }
    
    public CtClass[] getDeclaredClasses() throws NotFoundException {
        return this.getNestedClasses();
    }
    
    public void setGenericSignature(final String lllllllllllllIIlllIIllIlllIllllI) {
        this.checkModify();
    }
    
    public boolean isEnum() {
        return false;
    }
    
    public boolean isAnnotation() {
        return false;
    }
    
    public String makeUniqueName(final String lllllllllllllIIlllIIllIIlIlllIlI) {
        throw new RuntimeException(String.valueOf(new StringBuilder().append("not available in ").append(this.getName())));
    }
    
    public CtBehavior getEnclosingBehavior() throws NotFoundException {
        return null;
    }
    
    void incGetCounter() {
    }
    
    public ClassFile getClassFile() {
        this.checkModify();
        return this.getClassFile2();
    }
    
    CtField getField2(final String lllllllllllllIIlllIIllIllIIIlIII, final String lllllllllllllIIlllIIllIllIIIIlll) {
        return null;
    }
    
    public CtField getDeclaredField(final String lllllllllllllIIlllIIllIlIlllllll, final String lllllllllllllIIlllIIllIlIllllllI) throws NotFoundException {
        throw new NotFoundException(lllllllllllllIIlllIIllIlIlllllll);
    }
    
    public void removeMethod(final CtMethod lllllllllllllIIlllIIllIlIlIIlIlI) throws NotFoundException {
        this.checkModify();
    }
    
    public ClassPool getClassPool() {
        return null;
    }
    
    public boolean subclassOf(final CtClass lllllllllllllIIlllIIllIllIllIIIl) {
        return false;
    }
    
    public CtMethod getDeclaredMethod(final String lllllllllllllIIlllIIllIlIllIIIlI, final CtClass[] lllllllllllllIIlllIIllIlIllIIIll) throws NotFoundException {
        throw new NotFoundException(lllllllllllllIIlllIIllIlIllIIIlI);
    }
    
    public boolean hasAnnotation(final String lllllllllllllIIlllIIllIllIllllll) {
        return false;
    }
    
    public void addInterface(final CtClass lllllllllllllIIlllIIllIllIlIIlII) {
        this.checkModify();
    }
    
    void checkModify() throws RuntimeException {
        if (this.isFrozen()) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append(this.getName()).append(" class is frozen")));
        }
    }
    
    public void setModifiers(final int lllllllllllllIIlllIIllIllIllIlII) {
        this.checkModify();
    }
    
    public void removeConstructor(final CtConstructor lllllllllllllIIlllIIllIlIlIlIIlI) throws NotFoundException {
        this.checkModify();
    }
    
    public void writeFile() throws IOException, NotFoundException, CannotCompileException {
        this.writeFile(".");
    }
    
    public int getModifiers() {
        return 0;
    }
    
    public boolean subtypeOf(final CtClass lllllllllllllIIlllIIllIlllllllll) throws NotFoundException {
        return this == lllllllllllllIIlllIIllIlllllllll || this.getName().equals(lllllllllllllIIlllIIllIlllllllll.getName());
    }
    
    public CtClass[] getNestedClasses() throws NotFoundException {
        return new CtClass[0];
    }
    
    public CtMethod[] getDeclaredMethods() {
        return new CtMethod[0];
    }
    
    public void toBytecode(final DataOutputStream lllllllllllllIIlllIIllIIlIllllIl) throws CannotCompileException, IOException {
        throw new CannotCompileException("not a class");
    }
    
    public CtConstructor getConstructor(final String lllllllllllllIIlllIIllIlIllllIIl) throws NotFoundException {
        throw new NotFoundException("no such constructor");
    }
    
    public AccessorMaker getAccessorMaker() {
        return null;
    }
    
    @Deprecated
    public final CtMethod getEnclosingMethod() throws NotFoundException {
        final CtBehavior lllllllllllllIIlllIIllIllIIllllI = this.getEnclosingBehavior();
        if (lllllllllllllIIlllIIllIllIIllllI == null) {
            return null;
        }
        if (lllllllllllllIIlllIIllIllIIllllI instanceof CtMethod) {
            return (CtMethod)lllllllllllllIIlllIIllIllIIllllI;
        }
        throw new NotFoundException(String.valueOf(new StringBuilder().append(lllllllllllllIIlllIIllIllIIllllI.getLongName()).append(" is enclosing ").append(this.getName())));
    }
    
    public byte[] getAttribute(final String lllllllllllllIIlllIIllIlIIllIIll) {
        return null;
    }
    
    public void setAttribute(final String lllllllllllllIIlllIIllIlIIllIIII, final byte[] lllllllllllllIIlllIIllIlIIlIllll) {
        this.checkModify();
    }
    
    public void debugWriteFile(final String lllllllllllllIIlllIIllIIllIIIIII) {
        try {
            final boolean lllllllllllllIIlllIIllIIllIIIlIl = this.stopPruning(true);
            this.writeFile(lllllllllllllIIlllIIllIIllIIIIII);
            this.defrost();
            this.stopPruning(lllllllllllllIIlllIIllIIllIIIlIl);
        }
        catch (Exception lllllllllllllIIlllIIllIIllIIIlII) {
            throw new RuntimeException(lllllllllllllIIlllIIllIIllIIIlII);
        }
    }
    
    public void debugWriteFile() {
        this.debugWriteFile(".");
    }
    
    protected CtClass(final String lllllllllllllIIlllIIlllIIIlIIlll) {
        this.qualifiedName = lllllllllllllIIlllIIlllIIIlIIlll;
    }
    
    static class DelayedFileOutputStream extends OutputStream
    {
        private /* synthetic */ String filename;
        private /* synthetic */ FileOutputStream file;
        
        @Override
        public void close() throws IOException {
            this.init();
            this.file.close();
        }
        
        private void init() throws IOException {
            if (this.file == null) {
                this.file = new FileOutputStream(this.filename);
            }
        }
        
        @Override
        public void write(final int lllIlIIllllIlll) throws IOException {
            this.init();
            this.file.write(lllIlIIllllIlll);
        }
        
        @Override
        public void flush() throws IOException {
            this.init();
            this.file.flush();
        }
        
        @Override
        public void write(final byte[] lllIlIIlllIIlll, final int lllIlIIlllIlIlI, final int lllIlIIlllIIlIl) throws IOException {
            this.init();
            this.file.write(lllIlIIlllIIlll, lllIlIIlllIlIlI, lllIlIIlllIIlIl);
        }
        
        @Override
        public void write(final byte[] lllIlIIllllIIIl) throws IOException {
            this.init();
            this.file.write(lllIlIIllllIIIl);
        }
        
        DelayedFileOutputStream(final String lllIlIlIIIIIIlI) {
            this.file = null;
            this.filename = lllIlIlIIIIIIlI;
        }
    }
}
