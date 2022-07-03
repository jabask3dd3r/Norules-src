package com.viaversion.viaversion.libs.javassist;

import java.net.*;
import com.viaversion.viaversion.libs.javassist.bytecode.annotation.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;
import java.lang.ref.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.expr.*;
import java.util.*;

class CtClassType extends CtClass
{
    private /* synthetic */ Map<CtMethod, String> hiddenMethods;
    /* synthetic */ boolean wasPruned;
    private /* synthetic */ Reference<CtMember.Cache> memberCache;
    private /* synthetic */ int uniqueNumberSeed;
    /* synthetic */ ClassPool classPool;
    /* synthetic */ boolean wasChanged;
    private /* synthetic */ FieldInitLink fieldInitializers;
    /* synthetic */ byte[] rawClassfile;
    private /* synthetic */ AccessorMaker accessors;
    /* synthetic */ ClassFile classfile;
    /* synthetic */ boolean gcConstPool;
    private /* synthetic */ boolean wasFrozen;
    private /* synthetic */ int getCount;
    private /* synthetic */ boolean doPruning;
    
    @Override
    public byte[] getAttribute(final String lllllllllllllIlIllIIllIllIIIlIlI) {
        final AttributeInfo lllllllllllllIlIllIIllIllIIIllII = this.getClassFile2().getAttribute(lllllllllllllIlIllIIllIllIIIlIlI);
        if (lllllllllllllIlIllIIllIllIIIllII == null) {
            return null;
        }
        return lllllllllllllIlIllIIllIllIIIllII.get();
    }
    
    @Override
    public boolean isAnnotation() {
        return Modifier.isAnnotation(this.getModifiers());
    }
    
    @Override
    public boolean subclassOf(final CtClass lllllllllllllIlIllIlIIIIIIlIIIIl) {
        if (lllllllllllllIlIllIlIIIIIIlIIIIl == null) {
            return false;
        }
        final String lllllllllllllIlIllIlIIIIIIlIIIII = lllllllllllllIlIllIlIIIIIIlIIIIl.getName();
        CtClass lllllllllllllIlIllIlIIIIIIIlllll = this;
        try {
            while (lllllllllllllIlIllIlIIIIIIIlllll != null) {
                if (lllllllllllllIlIllIlIIIIIIIlllll.getName().equals(lllllllllllllIlIllIlIIIIIIlIIIII)) {
                    return true;
                }
                lllllllllllllIlIllIlIIIIIIIlllll = lllllllllllllIlIllIlIIIIIIIlllll.getSuperclass();
            }
        }
        catch (Exception ex) {}
        return false;
    }
    
    @Override
    public boolean stopPruning(final boolean lllllllllllllIlIllIIllIlIIlIIllI) {
        final boolean lllllllllllllIlIllIIllIlIIlIlIII = !this.doPruning;
        this.doPruning = !lllllllllllllIlIllIIllIlIIlIIllI;
        return lllllllllllllIlIllIIllIlIIlIlIII;
    }
    
    @Override
    public void addInterface(final CtClass lllllllllllllIlIllIIlllllllIlIIl) {
        this.checkModify();
        if (lllllllllllllIlIllIIlllllllIlIIl != null) {
            this.getClassFile2().addInterface(lllllllllllllIlIllIIlllllllIlIIl.getName());
        }
    }
    
    @Override
    public URL getURL() throws NotFoundException {
        final URL lllllllllllllIlIllIlIIIlllIIIlll = this.classPool.find(this.getName());
        if (lllllllllllllIlIllIlIIIlllIIIlll == null) {
            throw new NotFoundException(this.getName());
        }
        return lllllllllllllIlIllIlIIIlllIIIlll;
    }
    
    private static Object toAnnoType(final Annotation lllllllllllllIlIllIlIIIIIIlIllIl, final ClassPool lllllllllllllIlIllIlIIIIIIlIllII) throws ClassNotFoundException {
        try {
            final ClassLoader lllllllllllllIlIllIlIIIIIIllIlIl = lllllllllllllIlIllIlIIIIIIlIllII.getClassLoader();
            return lllllllllllllIlIllIlIIIIIIlIllIl.toAnnotationType(lllllllllllllIlIllIlIIIIIIllIlIl, lllllllllllllIlIllIlIIIIIIlIllII);
        }
        catch (ClassNotFoundException lllllllllllllIlIllIlIIIIIIllIIII) {
            final ClassLoader lllllllllllllIlIllIlIIIIIIllIIIl = lllllllllllllIlIllIlIIIIIIlIllII.getClass().getClassLoader();
            try {
                return lllllllllllllIlIllIlIIIIIIlIllIl.toAnnotationType(lllllllllllllIlIllIlIIIIIIllIIIl, lllllllllllllIlIllIlIIIIIIlIllII);
            }
            catch (ClassNotFoundException lllllllllllllIlIllIlIIIIIIllIIlI) {
                try {
                    final Class<?> lllllllllllllIlIllIlIIIIIIllIlII = lllllllllllllIlIllIlIIIIIIlIllII.get(lllllllllllllIlIllIlIIIIIIlIllIl.getTypeName()).toClass();
                    return AnnotationImpl.make(lllllllllllllIlIllIlIIIIIIllIlII.getClassLoader(), lllllllllllllIlIllIlIIIIIIllIlII, lllllllllllllIlIllIlIIIIIIlIllII, lllllllllllllIlIllIlIIIIIIlIllIl);
                }
                catch (Throwable lllllllllllllIlIllIlIIIIIIllIIll) {
                    throw new ClassNotFoundException(lllllllllllllIlIllIlIIIIIIlIllIl.getTypeName());
                }
            }
        }
    }
    
    @Deprecated
    static boolean hasAnnotationType(final Class<?> lllllllllllllIlIllIlIIIIllllIIlI, final ClassPool lllllllllllllIlIllIlIIIIllllIlIl, final AnnotationsAttribute lllllllllllllIlIllIlIIIIllllIlII, final AnnotationsAttribute lllllllllllllIlIllIlIIIIlllIllll) {
        return hasAnnotationType(lllllllllllllIlIllIlIIIIllllIIlI.getName(), lllllllllllllIlIllIlIIIIllllIlIl, lllllllllllllIlIllIlIIIIllllIlII, lllllllllllllIlIllIlIIIIlllIllll);
    }
    
    @Override
    public CtConstructor makeClassInitializer() throws CannotCompileException {
        final CtConstructor lllllllllllllIlIllIIllIllIllllll = this.getClassInitializer();
        if (lllllllllllllIlIllIIllIllIllllll != null) {
            return lllllllllllllIlIllIIllIllIllllll;
        }
        this.checkModify();
        final ClassFile lllllllllllllIlIllIIllIllIlllllI = this.getClassFile2();
        final Bytecode lllllllllllllIlIllIIllIllIllllIl = new Bytecode(lllllllllllllIlIllIIllIllIlllllI.getConstPool(), 0, 0);
        this.modifyClassConstructor(lllllllllllllIlIllIIllIllIlllllI, lllllllllllllIlIllIIllIllIllllIl, 0, 0);
        return this.getClassInitializer();
    }
    
    @Override
    public CtBehavior[] getDeclaredBehaviors() {
        final CtMember.Cache lllllllllllllIlIllIIlllIlllIIlIl = this.getMembers();
        CtMember lllllllllllllIlIllIIlllIlllIIlII = lllllllllllllIlIllIIlllIlllIIlIl.consHead();
        final CtMember lllllllllllllIlIllIIlllIlllIIIll = lllllllllllllIlIllIIlllIlllIIlIl.lastCons();
        final int lllllllllllllIlIllIIlllIlllIIIlI = CtMember.Cache.count(lllllllllllllIlIllIIlllIlllIIlII, lllllllllllllIlIllIIlllIlllIIIll);
        CtMember lllllllllllllIlIllIIlllIlllIIIIl = lllllllllllllIlIllIIlllIlllIIlIl.methodHead();
        final CtMember lllllllllllllIlIllIIlllIlllIIIII = lllllllllllllIlIllIIlllIlllIIlIl.lastMethod();
        final int lllllllllllllIlIllIIlllIllIlllll = CtMember.Cache.count(lllllllllllllIlIllIIlllIlllIIIIl, lllllllllllllIlIllIIlllIlllIIIII);
        CtBehavior[] lllllllllllllIlIllIIlllIllIllllI;
        int lllllllllllllIlIllIIlllIllIlllIl;
        for (lllllllllllllIlIllIIlllIllIllllI = new CtBehavior[lllllllllllllIlIllIIlllIlllIIIlI + lllllllllllllIlIllIIlllIllIlllll], lllllllllllllIlIllIIlllIllIlllIl = 0; lllllllllllllIlIllIIlllIlllIIlII != lllllllllllllIlIllIIlllIlllIIIll; lllllllllllllIlIllIIlllIlllIIlII = lllllllllllllIlIllIIlllIlllIIlII.next(), lllllllllllllIlIllIIlllIllIllllI[lllllllllllllIlIllIIlllIllIlllIl++] = (CtBehavior)lllllllllllllIlIllIIlllIlllIIlII) {}
        while (lllllllllllllIlIllIIlllIlllIIIIl != lllllllllllllIlIllIIlllIlllIIIII) {
            lllllllllllllIlIllIIlllIlllIIIIl = lllllllllllllIlIllIIlllIlllIIIIl.next();
            lllllllllllllIlIllIIlllIllIllllI[lllllllllllllIlIllIIlllIllIlllIl++] = (CtBehavior)lllllllllllllIlIllIIlllIlllIIIIl;
        }
        return lllllllllllllIlIllIIlllIllIllllI;
    }
    
    private void makeFieldCache(final CtMember.Cache lllllllllllllIlIllIIlllllIIIllIl) {
        final List<FieldInfo> lllllllllllllIlIllIIlllllIIIllll = this.getClassFile3(false).getFields();
        for (final FieldInfo lllllllllllllIlIllIIlllllIIlIIlI : lllllllllllllIlIllIIlllllIIIllll) {
            lllllllllllllIlIllIIlllllIIIllIl.addField(new CtField(lllllllllllllIlIllIIlllllIIlIIlI, this));
        }
    }
    
    @Override
    public Object[] getAvailableAnnotations() {
        try {
            return this.getAnnotations(true);
        }
        catch (ClassNotFoundException lllllllllllllIlIllIlIIIIlIlIlIIl) {
            throw new RuntimeException("Unexpected exception ", lllllllllllllIlIllIlIIIIlIlIlIIl);
        }
    }
    
    @Override
    public void removeConstructor(final CtConstructor lllllllllllllIlIllIIllIllIlIllIl) throws NotFoundException {
        this.checkModify();
        final MethodInfo lllllllllllllIlIllIIllIllIlIllII = lllllllllllllIlIllIIllIllIlIllIl.getMethodInfo2();
        final ClassFile lllllllllllllIlIllIIllIllIlIlIll = this.getClassFile2();
        if (lllllllllllllIlIllIIllIllIlIlIll.getMethods().remove(lllllllllllllIlIllIIllIllIlIllII)) {
            this.getMembers().remove(lllllllllllllIlIllIIllIllIlIllIl);
            this.gcConstPool = true;
            return;
        }
        throw new NotFoundException(lllllllllllllIlIllIIllIllIlIllIl.toString());
    }
    
    @Override
    public CtField[] getDeclaredFields() {
        final CtMember.Cache lllllllllllllIlIllIIllllIIlIIIIl = this.getMembers();
        CtMember lllllllllllllIlIllIIllllIIlIIIII = lllllllllllllIlIllIIllllIIlIIIIl.fieldHead();
        final CtMember lllllllllllllIlIllIIllllIIIlllll = lllllllllllllIlIllIIllllIIlIIIIl.lastField();
        final int lllllllllllllIlIllIIllllIIIllllI = CtMember.Cache.count(lllllllllllllIlIllIIllllIIlIIIII, lllllllllllllIlIllIIllllIIIlllll);
        final CtField[] lllllllllllllIlIllIIllllIIIlllIl = new CtField[lllllllllllllIlIllIIllllIIIllllI];
        for (int lllllllllllllIlIllIIllllIIIlllII = 0; lllllllllllllIlIllIIllllIIlIIIII != lllllllllllllIlIllIIllllIIIlllll; lllllllllllllIlIllIIllllIIlIIIII = lllllllllllllIlIllIIllllIIlIIIII.next(), lllllllllllllIlIllIIllllIIIlllIl[lllllllllllllIlIllIIllllIIIlllII++] = (CtField)lllllllllllllIlIllIIllllIIlIIIII) {}
        return lllllllllllllIlIllIIllllIIIlllIl;
    }
    
    @Override
    CtField getField2(final String lllllllllllllIlIllIIllllIIllIllI, final String lllllllllllllIlIllIIllllIIllIIIl) {
        final CtField lllllllllllllIlIllIIllllIIllIlII = this.getDeclaredField2(lllllllllllllIlIllIIllllIIllIllI, lllllllllllllIlIllIIllllIIllIIIl);
        if (lllllllllllllIlIllIIllllIIllIlII != null) {
            return lllllllllllllIlIllIIllllIIllIlII;
        }
        try {
            final char lllllllllllllIlIllIIllllIIlIlllI;
            final CtClass[] lllllllllllllIlIllIIllllIIlllIIl = (Object)(lllllllllllllIlIllIIllllIIlIlllI = (char)(Object)this.getInterfaces());
            final long lllllllllllllIlIllIIllllIIlIllIl = lllllllllllllIlIllIIllllIIlIlllI.length;
            for (double lllllllllllllIlIllIIllllIIlIllII = 0; lllllllllllllIlIllIIllllIIlIllII < lllllllllllllIlIllIIllllIIlIllIl; ++lllllllllllllIlIllIIllllIIlIllII) {
                final CtClass lllllllllllllIlIllIIllllIIlllIlI = lllllllllllllIlIllIIllllIIlIlllI[lllllllllllllIlIllIIllllIIlIllII];
                final CtField lllllllllllllIlIllIIllllIIlllIll = lllllllllllllIlIllIIllllIIlllIlI.getField2(lllllllllllllIlIllIIllllIIllIllI, lllllllllllllIlIllIIllllIIllIIIl);
                if (lllllllllllllIlIllIIllllIIlllIll != null) {
                    return lllllllllllllIlIllIIllllIIlllIll;
                }
            }
            final CtClass lllllllllllllIlIllIIllllIIlllIII = this.getSuperclass();
            if (lllllllllllllIlIllIIllllIIlllIII != null) {
                return lllllllllllllIlIllIIllllIIlllIII.getField2(lllllllllllllIlIllIIllllIIllIllI, lllllllllllllIlIllIIllllIIllIIIl);
            }
        }
        catch (NotFoundException ex) {}
        return null;
    }
    
    @Override
    public AccessorMaker getAccessorMaker() {
        if (this.accessors == null) {
            this.accessors = new AccessorMaker(this);
        }
        return this.accessors;
    }
    
    @Override
    public CtField getDeclaredField(final String lllllllllllllIlIllIIllllIIIIIlIl, final String lllllllllllllIlIllIIllllIIIIIlII) throws NotFoundException {
        final CtField lllllllllllllIlIllIIllllIIIIIlll = this.getDeclaredField2(lllllllllllllIlIllIIllllIIIIIlIl, lllllllllllllIlIllIIllllIIIIIlII);
        return this.checkGetField(lllllllllllllIlIllIIllllIIIIIlll, lllllllllllllIlIllIIllllIIIIIlIl, lllllllllllllIlIllIIllllIIIIIlII);
    }
    
    @Override
    public void setGenericSignature(final String lllllllllllllIlIllIlIIIllIIIIIll) {
        final ClassFile lllllllllllllIlIllIlIIIllIIIIIlI = this.getClassFile();
        final SignatureAttribute lllllllllllllIlIllIlIIIllIIIIIIl = new SignatureAttribute(lllllllllllllIlIllIlIIIllIIIIIlI.getConstPool(), lllllllllllllIlIllIlIIIllIIIIIll);
        lllllllllllllIlIllIlIIIllIIIIIlI.addAttribute(lllllllllllllIlIllIlIIIllIIIIIIl);
    }
    
    @Override
    public void removeField(final CtField lllllllllllllIlIllIIllIlllIIlIll) throws NotFoundException {
        this.checkModify();
        final FieldInfo lllllllllllllIlIllIIllIlllIIlIlI = lllllllllllllIlIllIIllIlllIIlIll.getFieldInfo2();
        final ClassFile lllllllllllllIlIllIIllIlllIIlIIl = this.getClassFile2();
        if (lllllllllllllIlIllIIllIlllIIlIIl.getFields().remove(lllllllllllllIlIllIIllIlllIIlIlI)) {
            this.getMembers().remove(lllllllllllllIlIllIIllIlllIIlIll);
            this.gcConstPool = true;
            return;
        }
        throw new NotFoundException(lllllllllllllIlIllIIllIlllIIlIll.toString());
    }
    
    CtClassType(final ClassFile lllllllllllllIlIllIlIIlIIIllIllI, final ClassPool lllllllllllllIlIllIlIIlIIIllIlIl) {
        this((String)null, lllllllllllllIlIllIlIIlIIIllIlIl);
        this.classfile = lllllllllllllIlIllIlIIlIIIllIllI;
        this.qualifiedName = this.classfile.getName();
    }
    
    private static void getFields(final List<CtMember> lllllllllllllIlIllIIllllIllIllII, final CtClass lllllllllllllIlIllIIllllIllIlIll) {
        if (lllllllllllllIlIllIIllllIllIlIll == null) {
            return;
        }
        try {
            getFields(lllllllllllllIlIllIIllllIllIllII, lllllllllllllIlIllIIllllIllIlIll.getSuperclass());
        }
        catch (NotFoundException ex) {}
        try {
            final CtClass[] interfaces;
            final CtClass[] lllllllllllllIlIllIIllllIllIllIl = interfaces = lllllllllllllIlIllIIllllIllIlIll.getInterfaces();
            final byte lllllllllllllIlIllIIllllIllIIIll = (byte)interfaces.length;
            for (char lllllllllllllIlIllIIllllIllIIIlI = '\0'; lllllllllllllIlIllIIllllIllIIIlI < lllllllllllllIlIllIIllllIllIIIll; ++lllllllllllllIlIllIIllllIllIIIlI) {
                final CtClass lllllllllllllIlIllIIllllIllIlllI = interfaces[lllllllllllllIlIllIIllllIllIIIlI];
                getFields(lllllllllllllIlIllIIllllIllIllII, lllllllllllllIlIllIIllllIllIlllI);
            }
        }
        catch (NotFoundException ex2) {}
        final CtMember.Cache lllllllllllllIlIllIIllllIllIlIlI = ((CtClassType)lllllllllllllIlIllIIllllIllIlIll).getMembers();
        CtMember lllllllllllllIlIllIIllllIllIlIIl = lllllllllllllIlIllIIllllIllIlIlI.fieldHead();
        final CtMember lllllllllllllIlIllIIllllIllIlIII = lllllllllllllIlIllIIllllIllIlIlI.lastField();
        while (lllllllllllllIlIllIIllllIllIlIIl != lllllllllllllIlIllIIllllIllIlIII) {
            lllllllllllllIlIllIIllllIllIlIIl = lllllllllllllIlIllIIllllIllIlIIl.next();
            if (!Modifier.isPrivate(lllllllllllllIlIllIIllllIllIlIIl.getModifiers())) {
                lllllllllllllIlIllIIllllIllIllII.add(lllllllllllllIlIllIIllllIllIlIIl);
            }
        }
    }
    
    @Override
    public void instrument(final CodeConverter lllllllllllllIlIllIIllIlIllIllII) throws CannotCompileException {
        this.checkModify();
        final ClassFile lllllllllllllIlIllIIllIlIlllIIII = this.getClassFile2();
        final ConstPool lllllllllllllIlIllIIllIlIllIllll = lllllllllllllIlIllIIllIlIlllIIII.getConstPool();
        final List<MethodInfo> lllllllllllllIlIllIIllIlIllIlllI = lllllllllllllIlIllIIllIlIlllIIII.getMethods();
        final long lllllllllllllIlIllIIllIlIllIlIII = (Object)lllllllllllllIlIllIIllIlIllIlllI.toArray(new MethodInfo[lllllllllllllIlIllIIllIlIllIlllI.size()]);
        final byte lllllllllllllIlIllIIllIlIllIIlll = (byte)lllllllllllllIlIllIIllIlIllIlIII.length;
        for (boolean lllllllllllllIlIllIIllIlIllIIllI = false; (lllllllllllllIlIllIIllIlIllIIllI ? 1 : 0) < lllllllllllllIlIllIIllIlIllIIlll; ++lllllllllllllIlIllIIllIlIllIIllI) {
            final MethodInfo lllllllllllllIlIllIIllIlIlllIIll = lllllllllllllIlIllIIllIlIllIlIII[lllllllllllllIlIllIIllIlIllIIllI];
            lllllllllllllIlIllIIllIlIllIllII.doit(this, lllllllllllllIlIllIIllIlIlllIIll, lllllllllllllIlIllIIllIlIllIllll);
        }
    }
    
    @Override
    public void setName(final String lllllllllllllIlIllIlIIIllIIlIIIl) throws RuntimeException {
        final String lllllllllllllIlIllIlIIIllIIlIlII = this.getName();
        if (lllllllllllllIlIllIlIIIllIIlIIIl.equals(lllllllllllllIlIllIlIIIllIIlIlII)) {
            return;
        }
        this.classPool.checkNotFrozen(lllllllllllllIlIllIlIIIllIIlIIIl);
        final ClassFile lllllllllllllIlIllIlIIIllIIlIIll = this.getClassFile2();
        super.setName(lllllllllllllIlIllIlIIIllIIlIIIl);
        lllllllllllllIlIllIlIIIllIIlIIll.setName(lllllllllllllIlIllIlIIIllIIlIIIl);
        this.nameReplaced();
        this.classPool.classNameChanged(lllllllllllllIlIllIlIIIllIIlIlII, this);
    }
    
    private synchronized void removeClassFile() {
        if (this.classfile != null && !this.isModified() && this.hasMemberCache() == null) {
            this.classfile = null;
        }
    }
    
    private void modifyConstructors(final ClassFile lllllllllllllIlIllIIllIIllIlIIII) throws CannotCompileException, NotFoundException {
        if (this.fieldInitializers == null) {
            return;
        }
        final ConstPool lllllllllllllIlIllIIllIIllIlIIll = lllllllllllllIlIllIIllIIllIlIIII.getConstPool();
        final List<MethodInfo> lllllllllllllIlIllIIllIIllIlIIlI = lllllllllllllIlIllIIllIIllIlIIII.getMethods();
        for (final MethodInfo lllllllllllllIlIllIIllIIllIlIllI : lllllllllllllIlIllIIllIIllIlIIlI) {
            if (lllllllllllllIlIllIIllIIllIlIllI.isConstructor()) {
                final CodeAttribute lllllllllllllIlIllIIllIIllIlIlll = lllllllllllllIlIllIIllIIllIlIllI.getCodeAttribute();
                if (lllllllllllllIlIllIIllIIllIlIlll == null) {
                    continue;
                }
                try {
                    final Bytecode lllllllllllllIlIllIIllIIllIllIll = new Bytecode(lllllllllllllIlIllIIllIIllIlIIll, 0, lllllllllllllIlIllIIllIIllIlIlll.getMaxLocals());
                    final CtClass[] lllllllllllllIlIllIIllIIllIllIlI = Descriptor.getParameterTypes(lllllllllllllIlIllIIllIIllIlIllI.getDescriptor(), this.classPool);
                    final int lllllllllllllIlIllIIllIIllIllIIl = this.makeFieldInitializer(lllllllllllllIlIllIIllIIllIllIll, lllllllllllllIlIllIIllIIllIllIlI);
                    insertAuxInitializer(lllllllllllllIlIllIIllIIllIlIlll, lllllllllllllIlIllIIllIIllIllIll, lllllllllllllIlIllIIllIIllIllIIl);
                    lllllllllllllIlIllIIllIIllIlIllI.rebuildStackMapIf6(this.classPool, lllllllllllllIlIllIIllIIllIlIIII);
                }
                catch (BadBytecode lllllllllllllIlIllIIllIIllIllIII) {
                    throw new CannotCompileException(lllllllllllllIlIllIIllIIllIllIII);
                }
            }
        }
    }
    
    @Override
    public CtField[] getFields() {
        final List<CtMember> lllllllllllllIlIllIIllllIllllIII = new ArrayList<CtMember>();
        getFields(lllllllllllllIlIllIIllllIllllIII, this);
        return lllllllllllllIlIllIIllllIllllIII.toArray(new CtField[lllllllllllllIlIllIIllllIllllIII.size()]);
    }
    
    @Override
    public void defrost() {
        this.checkPruned("defrost");
        this.wasFrozen = false;
    }
    
    @Override
    public void addField(final CtField lllllllllllllIlIllIIllIllllIIllI, final String lllllllllllllIlIllIIllIllllIlIII) throws CannotCompileException {
        this.addField(lllllllllllllIlIllIIllIllllIIllI, CtField.Initializer.byExpr(lllllllllllllIlIllIIllIllllIlIII));
    }
    
    private static void getMethods0(final Map<String, CtMember> lllllllllllllIlIllIIlllIIllIIlII, final CtClass lllllllllllllIlIllIIlllIIllIIIll) {
        try {
            final char lllllllllllllIlIllIIlllIIlIlllll;
            final CtClass[] lllllllllllllIlIllIIlllIIllIlIIl = (Object)(lllllllllllllIlIllIIlllIIlIlllll = (char)(Object)lllllllllllllIlIllIIlllIIllIIIll.getInterfaces());
            final boolean lllllllllllllIlIllIIlllIIlIllllI = lllllllllllllIlIllIIlllIIlIlllll.length != 0;
            for (double lllllllllllllIlIllIIlllIIlIlllIl = 0; lllllllllllllIlIllIIlllIIlIlllIl < (lllllllllllllIlIllIIlllIIlIllllI ? 1 : 0); ++lllllllllllllIlIllIIlllIIlIlllIl) {
                final CtClass lllllllllllllIlIllIIlllIIllIlIlI = lllllllllllllIlIllIIlllIIlIlllll[lllllllllllllIlIllIIlllIIlIlllIl];
                getMethods0(lllllllllllllIlIllIIlllIIllIIlII, lllllllllllllIlIllIIlllIIllIlIlI);
            }
        }
        catch (NotFoundException ex) {}
        try {
            final CtClass lllllllllllllIlIllIIlllIIllIlIII = lllllllllllllIlIllIIlllIIllIIIll.getSuperclass();
            if (lllllllllllllIlIllIIlllIIllIlIII != null) {
                getMethods0(lllllllllllllIlIllIIlllIIllIIlII, lllllllllllllIlIllIIlllIIllIlIII);
            }
        }
        catch (NotFoundException ex2) {}
        if (lllllllllllllIlIllIIlllIIllIIIll instanceof CtClassType) {
            final CtMember.Cache lllllllllllllIlIllIIlllIIllIIlll = ((CtClassType)lllllllllllllIlIllIIlllIIllIIIll).getMembers();
            CtMember lllllllllllllIlIllIIlllIIllIIllI = lllllllllllllIlIllIIlllIIllIIlll.methodHead();
            final CtMember lllllllllllllIlIllIIlllIIllIIlIl = lllllllllllllIlIllIIlllIIllIIlll.lastMethod();
            while (lllllllllllllIlIllIIlllIIllIIllI != lllllllllllllIlIllIIlllIIllIIlIl) {
                lllllllllllllIlIllIIlllIIllIIllI = lllllllllllllIlIllIIlllIIllIIllI.next();
                if (!Modifier.isPrivate(lllllllllllllIlIllIIlllIIllIIllI.getModifiers())) {
                    lllllllllllllIlIllIIlllIIllIIlII.put(((CtMethod)lllllllllllllIlIllIIlllIIllIIllI).getStringRep(), lllllllllllllIlIllIIlllIIllIIllI);
                }
            }
        }
    }
    
    private static CtMethod getMethod0(final CtClass lllllllllllllIlIllIIlllIIIlllIll, final String lllllllllllllIlIllIIlllIIIlllIlI, final String lllllllllllllIlIllIIlllIIIlllIIl) {
        if (lllllllllllllIlIllIIlllIIIlllIll instanceof CtClassType) {
            final CtMember.Cache lllllllllllllIlIllIIlllIIlIIIllI = ((CtClassType)lllllllllllllIlIllIIlllIIIlllIll).getMembers();
            CtMember lllllllllllllIlIllIIlllIIlIIIlIl = lllllllllllllIlIllIIlllIIlIIIllI.methodHead();
            final CtMember lllllllllllllIlIllIIlllIIlIIIlII = lllllllllllllIlIllIIlllIIlIIIllI.lastMethod();
            while (lllllllllllllIlIllIIlllIIlIIIlIl != lllllllllllllIlIllIIlllIIlIIIlII) {
                lllllllllllllIlIllIIlllIIlIIIlIl = lllllllllllllIlIllIIlllIIlIIIlIl.next();
                if (lllllllllllllIlIllIIlllIIlIIIlIl.getName().equals(lllllllllllllIlIllIIlllIIIlllIlI) && ((CtMethod)lllllllllllllIlIllIIlllIIlIIIlIl).getMethodInfo2().getDescriptor().equals(lllllllllllllIlIllIIlllIIIlllIIl)) {
                    return (CtMethod)lllllllllllllIlIllIIlllIIlIIIlIl;
                }
            }
        }
        try {
            final CtClass lllllllllllllIlIllIIlllIIlIIIIlI = lllllllllllllIlIllIIlllIIIlllIll.getSuperclass();
            if (lllllllllllllIlIllIIlllIIlIIIIlI != null) {
                final CtMethod lllllllllllllIlIllIIlllIIlIIIIll = getMethod0(lllllllllllllIlIllIIlllIIlIIIIlI, lllllllllllllIlIllIIlllIIIlllIlI, lllllllllllllIlIllIIlllIIIlllIIl);
                if (lllllllllllllIlIllIIlllIIlIIIIll != null) {
                    return lllllllllllllIlIllIIlllIIlIIIIll;
                }
            }
        }
        catch (NotFoundException ex) {}
        try {
            final CtClass[] interfaces;
            final CtClass[] lllllllllllllIlIllIIlllIIIllllll = interfaces = lllllllllllllIlIllIIlllIIIlllIll.getInterfaces();
            final int length = interfaces.length;
            for (Exception lllllllllllllIlIllIIlllIIIllIlIl = (Exception)0; lllllllllllllIlIllIIlllIIIllIlIl < length; ++lllllllllllllIlIllIIlllIIIllIlIl) {
                final CtClass lllllllllllllIlIllIIlllIIlIIIIII = interfaces[lllllllllllllIlIllIIlllIIIllIlIl];
                final CtMethod lllllllllllllIlIllIIlllIIlIIIIIl = getMethod0(lllllllllllllIlIllIIlllIIlIIIIII, lllllllllllllIlIllIIlllIIIlllIlI, lllllllllllllIlIllIIlllIIIlllIIl);
                if (lllllllllllllIlIllIIlllIIlIIIIIl != null) {
                    return lllllllllllllIlIllIIlllIIlIIIIIl;
                }
            }
        }
        catch (NotFoundException ex2) {}
        return null;
    }
    
    @Override
    public String makeUniqueName(final String lllllllllllllIlIllIIllIIlIIIlIll) {
        final Map<Object, CtClassType> lllllllllllllIlIllIIllIIlIIIlIlI = new HashMap<Object, CtClassType>();
        this.makeMemberList(lllllllllllllIlIllIIllIIlIIIlIlI);
        final Set<Object> lllllllllllllIlIllIIllIIlIIIlIIl = lllllllllllllIlIllIIllIIlIIIlIlI.keySet();
        final String[] lllllllllllllIlIllIIllIIlIIIlIII = new String[lllllllllllllIlIllIIllIIlIIIlIIl.size()];
        lllllllllllllIlIllIIllIIlIIIlIIl.toArray(lllllllllllllIlIllIIllIIlIIIlIII);
        if (notFindInArray(lllllllllllllIlIllIIllIIlIIIlIll, lllllllllllllIlIllIIllIIlIIIlIII)) {
            return lllllllllllllIlIllIIllIIlIIIlIll;
        }
        int lllllllllllllIlIllIIllIIlIIIIlll = 100;
        while (lllllllllllllIlIllIIllIIlIIIIlll <= 999) {
            final String lllllllllllllIlIllIIllIIlIIIIllI = String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIllIIlIIIlIll).append(lllllllllllllIlIllIIllIIlIIIIlll++));
            if (notFindInArray(lllllllllllllIlIllIIllIIlIIIIllI, lllllllllllllIlIllIIllIIlIIIlIII)) {
                return lllllllllllllIlIllIIllIIlIIIIllI;
            }
        }
        throw new RuntimeException("too many unique name");
    }
    
    private synchronized ClassFile setClassFile(final ClassFile lllllllllllllIlIllIlIIIlllIlIlII) {
        if (this.classfile == null) {
            this.classfile = lllllllllllllIlIllIlIIIlllIlIlII;
        }
        return this.classfile;
    }
    
    void setClassPool(final ClassPool lllllllllllllIlIllIlIIIlllIIlIll) {
        this.classPool = lllllllllllllIlIllIlIIIlllIIlIll;
    }
    
    static Object getAnnotationType(final Class<?> lllllllllllllIlIllIlIIIIlIllllIl, final ClassPool lllllllllllllIlIllIlIIIIlIllllII, final AnnotationsAttribute lllllllllllllIlIllIlIIIIlIllIlII, final AnnotationsAttribute lllllllllllllIlIllIlIIIIlIllIIll) throws ClassNotFoundException {
        Annotation[] lllllllllllllIlIllIlIIIIlIlllIIl = null;
        if (lllllllllllllIlIllIlIIIIlIllIlII == null) {
            final Annotation[] lllllllllllllIlIllIlIIIIllIIIIIl = null;
        }
        else {
            lllllllllllllIlIllIlIIIIlIlllIIl = lllllllllllllIlIllIlIIIIlIllIlII.getAnnotations();
        }
        Annotation[] lllllllllllllIlIllIlIIIIlIlllIII = null;
        if (lllllllllllllIlIllIlIIIIlIllIIll == null) {
            final Annotation[] lllllllllllllIlIllIlIIIIllIIIIII = null;
        }
        else {
            lllllllllllllIlIllIlIIIIlIlllIII = lllllllllllllIlIllIlIIIIlIllIIll.getAnnotations();
        }
        final String lllllllllllllIlIllIlIIIIlIllIlll = lllllllllllllIlIllIlIIIIlIllllIl.getName();
        if (lllllllllllllIlIllIlIIIIlIlllIIl != null) {
            for (int lllllllllllllIlIllIlIIIIlIllllll = 0; lllllllllllllIlIllIlIIIIlIllllll < lllllllllllllIlIllIlIIIIlIlllIIl.length; ++lllllllllllllIlIllIlIIIIlIllllll) {
                if (lllllllllllllIlIllIlIIIIlIlllIIl[lllllllllllllIlIllIlIIIIlIllllll].getTypeName().equals(lllllllllllllIlIllIlIIIIlIllIlll)) {
                    return toAnnoType(lllllllllllllIlIllIlIIIIlIlllIIl[lllllllllllllIlIllIlIIIIlIllllll], lllllllllllllIlIllIlIIIIlIllllII);
                }
            }
        }
        if (lllllllllllllIlIllIlIIIIlIlllIII != null) {
            for (int lllllllllllllIlIllIlIIIIlIlllllI = 0; lllllllllllllIlIllIlIIIIlIlllllI < lllllllllllllIlIllIlIIIIlIlllIII.length; ++lllllllllllllIlIllIlIIIIlIlllllI) {
                if (lllllllllllllIlIllIlIIIIlIlllIII[lllllllllllllIlIllIlIIIIlIlllllI].getTypeName().equals(lllllllllllllIlIllIlIIIIlIllIlll)) {
                    return toAnnoType(lllllllllllllIlIllIlIIIIlIlllIII[lllllllllllllIlIllIlIIIIlIlllllI], lllllllllllllIlIllIlIIIIlIllllII);
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean isInterface() {
        return Modifier.isInterface(this.getModifiers());
    }
    
    @Override
    public boolean isModified() {
        return this.wasChanged;
    }
    
    @Override
    public CtConstructor getClassInitializer() {
        final CtMember.Cache lllllllllllllIlIllIIlllIIlllllll = this.getMembers();
        CtMember lllllllllllllIlIllIIlllIIllllllI = lllllllllllllIlIllIIlllIIlllllll.consHead();
        final CtMember lllllllllllllIlIllIIlllIIlllllIl = lllllllllllllIlIllIIlllIIlllllll.lastCons();
        while (lllllllllllllIlIllIIlllIIllllllI != lllllllllllllIlIllIIlllIIlllllIl) {
            lllllllllllllIlIllIIlllIIllllllI = lllllllllllllIlIllIIlllIIllllllI.next();
            final CtConstructor lllllllllllllIlIllIIlllIlIIIIIIl = (CtConstructor)lllllllllllllIlIllIIlllIIllllllI;
            if (lllllllllllllIlIllIIlllIlIIIIIIl.isClassInitializer()) {
                return lllllllllllllIlIllIIlllIlIIIIIIl;
            }
        }
        return null;
    }
    
    @Override
    public CtMethod[] getDeclaredMethods() {
        final CtMember.Cache lllllllllllllIlIllIIlllIIIlIllII = this.getMembers();
        CtMember lllllllllllllIlIllIIlllIIIlIlIll = lllllllllllllIlIllIIlllIIIlIllII.methodHead();
        final CtMember lllllllllllllIlIllIIlllIIIlIlIlI = lllllllllllllIlIllIIlllIIIlIllII.lastMethod();
        final List<CtMember> lllllllllllllIlIllIIlllIIIlIlIIl = new ArrayList<CtMember>();
        while (lllllllllllllIlIllIIlllIIIlIlIll != lllllllllllllIlIllIIlllIIIlIlIlI) {
            lllllllllllllIlIllIIlllIIIlIlIll = lllllllllllllIlIllIIlllIIIlIlIll.next();
            lllllllllllllIlIllIIlllIIIlIlIIl.add(lllllllllllllIlIllIIlllIIIlIlIll);
        }
        return lllllllllllllIlIllIIlllIIIlIlIIl.toArray(new CtMethod[lllllllllllllIlIllIIlllIIIlIlIIl.size()]);
    }
    
    private void makeMemberList(final Map<Object, CtClassType> lllllllllllllIlIllIIllIIIlIlllll) {
        final int lllllllllllllIlIllIIllIIIllIIIll = this.getModifiers();
        Label_0081: {
            if (!Modifier.isAbstract(lllllllllllllIlIllIIllIIIllIIIll)) {
                if (!Modifier.isInterface(lllllllllllllIlIllIIllIIIllIIIll)) {
                    break Label_0081;
                }
            }
            try {
                final double lllllllllllllIlIllIIllIIIlIlllII;
                final CtClass[] lllllllllllllIlIllIIllIIIllIlIIl = (Object)(lllllllllllllIlIllIIllIIIlIlllII = (double)(Object)this.getInterfaces());
                for (final CtClass lllllllllllllIlIllIIllIIIllIlIlI : lllllllllllllIlIllIIllIIIlIlllII) {
                    if (lllllllllllllIlIllIIllIIIllIlIlI != null && lllllllllllllIlIllIIllIIIllIlIlI instanceof CtClassType) {
                        ((CtClassType)lllllllllllllIlIllIIllIIIllIlIlI).makeMemberList(lllllllllllllIlIllIIllIIIlIlllll);
                    }
                }
            }
            catch (NotFoundException ex) {}
            try {
                final CtClass lllllllllllllIlIllIIllIIIllIlIII = this.getSuperclass();
                if (lllllllllllllIlIllIIllIIIllIlIII != null && lllllllllllllIlIllIIllIIIllIlIII instanceof CtClassType) {
                    ((CtClassType)lllllllllllllIlIllIIllIIIllIlIII).makeMemberList(lllllllllllllIlIllIIllIIIlIlllll);
                }
            }
            catch (NotFoundException ex2) {}
        }
        final List<MethodInfo> lllllllllllllIlIllIIllIIIllIIIlI = this.getClassFile2().getMethods();
        double lllllllllllllIlIllIIllIIIlIlllII = (double)lllllllllllllIlIllIIllIIIllIIIlI.iterator();
        while (((Iterator)lllllllllllllIlIllIIllIIIlIlllII).hasNext()) {
            final MethodInfo lllllllllllllIlIllIIllIIIllIIlll = ((Iterator<MethodInfo>)lllllllllllllIlIllIIllIIIlIlllII).next();
            lllllllllllllIlIllIIllIIIlIlllll.put(lllllllllllllIlIllIIllIIIllIIlll.getName(), this);
        }
        final List<FieldInfo> lllllllllllllIlIllIIllIIIllIIIIl = this.getClassFile2().getFields();
        for (final FieldInfo lllllllllllllIlIllIIllIIIllIIllI : lllllllllllllIlIllIIllIIIllIIIIl) {
            lllllllllllllIlIllIIllIIIlIlllll.put(lllllllllllllIlIllIIllIIIllIIllI.getName(), this);
        }
    }
    
    @Override
    public ClassFile getClassFile2() {
        return this.getClassFile3(true);
    }
    
    private void modifyClassConstructor(final ClassFile lllllllllllllIlIllIIllIIllllIlIl, final Bytecode lllllllllllllIlIllIIllIIllllIlII, final int lllllllllllllIlIllIIllIIlllIllIl, final int lllllllllllllIlIllIIllIIlllIllII) throws CannotCompileException {
        MethodInfo lllllllllllllIlIllIIllIIllllIIIl = lllllllllllllIlIllIIllIIllllIlIl.getStaticInitializer();
        if (lllllllllllllIlIllIIllIIllllIIIl == null) {
            lllllllllllllIlIllIIllIIllllIlII.add(177);
            lllllllllllllIlIllIIllIIllllIlII.setMaxStack(lllllllllllllIlIllIIllIIlllIllIl);
            lllllllllllllIlIllIIllIIllllIlII.setMaxLocals(lllllllllllllIlIllIIllIIlllIllII);
            lllllllllllllIlIllIIllIIllllIIIl = new MethodInfo(lllllllllllllIlIllIIllIIllllIlIl.getConstPool(), "<clinit>", "()V");
            lllllllllllllIlIllIIllIIllllIIIl.setAccessFlags(8);
            lllllllllllllIlIllIIllIIllllIIIl.setCodeAttribute(lllllllllllllIlIllIIllIIllllIlII.toCodeAttribute());
            lllllllllllllIlIllIIllIIllllIlIl.addMethod(lllllllllllllIlIllIIllIIllllIIIl);
            final CtMember.Cache lllllllllllllIlIllIIllIIlllllllI = this.hasMemberCache();
            if (lllllllllllllIlIllIIllIIlllllllI != null) {
                lllllllllllllIlIllIIllIIlllllllI.addConstructor(new CtConstructor(lllllllllllllIlIllIIllIIllllIIIl, this));
            }
        }
        else {
            final CodeAttribute lllllllllllllIlIllIIllIIlllllIII = lllllllllllllIlIllIIllIIllllIIIl.getCodeAttribute();
            if (lllllllllllllIlIllIIllIIlllllIII == null) {
                throw new CannotCompileException("empty <clinit>");
            }
            try {
                final CodeIterator lllllllllllllIlIllIIllIIllllllIl = lllllllllllllIlIllIIllIIlllllIII.iterator();
                final int lllllllllllllIlIllIIllIIllllllII = lllllllllllllIlIllIIllIIllllllIl.insertEx(lllllllllllllIlIllIIllIIllllIlII.get());
                lllllllllllllIlIllIIllIIllllllIl.insert(lllllllllllllIlIllIIllIIllllIlII.getExceptionTable(), lllllllllllllIlIllIIllIIllllllII);
                final int lllllllllllllIlIllIIllIIlllllIll = lllllllllllllIlIllIIllIIlllllIII.getMaxStack();
                if (lllllllllllllIlIllIIllIIlllllIll < lllllllllllllIlIllIIllIIlllIllIl) {
                    lllllllllllllIlIllIIllIIlllllIII.setMaxStack(lllllllllllllIlIllIIllIIlllIllIl);
                }
                final int lllllllllllllIlIllIIllIIlllllIlI = lllllllllllllIlIllIIllIIlllllIII.getMaxLocals();
                if (lllllllllllllIlIllIIllIIlllllIlI < lllllllllllllIlIllIIllIIlllIllII) {
                    lllllllllllllIlIllIIllIIlllllIII.setMaxLocals(lllllllllllllIlIllIIllIIlllIllII);
                }
            }
            catch (BadBytecode lllllllllllllIlIllIIllIIlllllIIl) {
                throw new CannotCompileException(lllllllllllllIlIllIIllIIlllllIIl);
            }
        }
        try {
            lllllllllllllIlIllIIllIIllllIIIl.rebuildStackMapIf6(this.classPool, lllllllllllllIlIllIIllIIllllIlIl);
        }
        catch (BadBytecode lllllllllllllIlIllIIllIIllllIlll) {
            throw new CannotCompileException(lllllllllllllIlIllIIllIIllllIlll);
        }
    }
    
    @Override
    public CtMethod getDeclaredMethod(final String lllllllllllllIlIllIIlllIIIIIIllI) throws NotFoundException {
        final CtMember.Cache lllllllllllllIlIllIIlllIIIIIlIlI = this.getMembers();
        CtMember lllllllllllllIlIllIIlllIIIIIlIIl = lllllllllllllIlIllIIlllIIIIIlIlI.methodHead();
        final CtMember lllllllllllllIlIllIIlllIIIIIlIII = lllllllllllllIlIllIIlllIIIIIlIlI.lastMethod();
        while (lllllllllllllIlIllIIlllIIIIIlIIl != lllllllllllllIlIllIIlllIIIIIlIII) {
            lllllllllllllIlIllIIlllIIIIIlIIl = lllllllllllllIlIllIIlllIIIIIlIIl.next();
            if (lllllllllllllIlIllIIlllIIIIIlIIl.getName().equals(lllllllllllllIlIllIIlllIIIIIIllI)) {
                return (CtMethod)lllllllllllllIlIllIIlllIIIIIlIIl;
            }
        }
        throw new NotFoundException(String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIlllIIIIIIllI).append("(..) is not found in ").append(this.getName())));
    }
    
    private CtField checkGetField(final CtField lllllllllllllIlIllIIllllIlIIlIIl, final String lllllllllllllIlIllIIllllIlIIlIII, final String lllllllllllllIlIllIIllllIlIIlIll) throws NotFoundException {
        if (lllllllllllllIlIllIIllllIlIIlIIl == null) {
            String lllllllllllllIlIllIIllllIlIIllll = String.valueOf(new StringBuilder().append("field: ").append(lllllllllllllIlIllIIllllIlIIlIII));
            if (lllllllllllllIlIllIIllllIlIIlIll != null) {
                lllllllllllllIlIllIIllllIlIIllll = String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIllllIlIIllll).append(" type ").append(lllllllllllllIlIllIIllllIlIIlIll));
            }
            throw new NotFoundException(String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIllllIlIIllll).append(" in ").append(this.getName())));
        }
        return lllllllllllllIlIllIIllllIlIIlIIl;
    }
    
    @Override
    void checkModify() throws RuntimeException {
        if (this.isFrozen()) {
            String lllllllllllllIlIllIlIIIllIlllIIl = String.valueOf(new StringBuilder().append(this.getName()).append(" class is frozen"));
            if (this.wasPruned) {
                lllllllllllllIlIllIlIIIllIlllIIl = String.valueOf(new StringBuilder().append(lllllllllllllIlIllIlIIIllIlllIIl).append(" and pruned"));
            }
            throw new RuntimeException(lllllllllllllIlIllIlIIIllIlllIIl);
        }
        this.wasChanged = true;
    }
    
    @Override
    public CtMethod[] getMethods() {
        final Map<String, CtMember> lllllllllllllIlIllIIlllIIlllIlII = new HashMap<String, CtMember>();
        getMethods0(lllllllllllllIlIllIIlllIIlllIlII, this);
        return lllllllllllllIlIllIIlllIIlllIlII.values().toArray(new CtMethod[lllllllllllllIlIllIIlllIIlllIlII.size()]);
    }
    
    @Override
    void compress() {
        if (this.getCount < 2) {
            if (!this.isModified() && ClassPool.releaseUnmodifiedClassFile) {
                this.removeClassFile();
            }
            else if (this.isFrozen() && !this.wasPruned) {
                this.saveClassFile();
            }
        }
        this.getCount = 0;
    }
    
    @Override
    public CtConstructor[] getConstructors() {
        final CtMember.Cache lllllllllllllIlIllIIlllIllIIIlll = this.getMembers();
        final CtMember lllllllllllllIlIllIIlllIllIIIllI = lllllllllllllIlIllIIlllIllIIIlll.consHead();
        final CtMember lllllllllllllIlIllIIlllIllIIIlIl = lllllllllllllIlIllIIlllIllIIIlll.lastCons();
        int lllllllllllllIlIllIIlllIllIIIlII = 0;
        CtMember lllllllllllllIlIllIIlllIllIIIIll = lllllllllllllIlIllIIlllIllIIIllI;
        while (lllllllllllllIlIllIIlllIllIIIIll != lllllllllllllIlIllIIlllIllIIIlIl) {
            lllllllllllllIlIllIIlllIllIIIIll = lllllllllllllIlIllIIlllIllIIIIll.next();
            if (isPubCons((CtConstructor)lllllllllllllIlIllIIlllIllIIIIll)) {
                ++lllllllllllllIlIllIIlllIllIIIlII;
            }
        }
        final CtConstructor[] lllllllllllllIlIllIIlllIllIIIIlI = new CtConstructor[lllllllllllllIlIllIIlllIllIIIlII];
        int lllllllllllllIlIllIIlllIllIIIIIl = 0;
        lllllllllllllIlIllIIlllIllIIIIll = lllllllllllllIlIllIIlllIllIIIllI;
        while (lllllllllllllIlIllIIlllIllIIIIll != lllllllllllllIlIllIIlllIllIIIlIl) {
            lllllllllllllIlIllIIlllIllIIIIll = lllllllllllllIlIllIIlllIllIIIIll.next();
            final CtConstructor lllllllllllllIlIllIIlllIllIIlIIl = (CtConstructor)lllllllllllllIlIllIIlllIllIIIIll;
            if (isPubCons(lllllllllllllIlIllIIlllIllIIlIIl)) {
                lllllllllllllIlIllIIlllIllIIIIlI[lllllllllllllIlIllIIlllIllIIIIIl++] = lllllllllllllIlIllIIlllIllIIlIIl;
            }
        }
        return lllllllllllllIlIllIIlllIllIIIIlI;
    }
    
    @Override
    public CtClass[] getNestedClasses() throws NotFoundException {
        final ClassFile lllllllllllllIlIllIlIIIlIlIIIIIl = this.getClassFile2();
        final InnerClassesAttribute lllllllllllllIlIllIlIIIlIlIIIIII = (InnerClassesAttribute)lllllllllllllIlIllIlIIIlIlIIIIIl.getAttribute("InnerClasses");
        if (lllllllllllllIlIllIlIIIlIlIIIIII == null) {
            return new CtClass[0];
        }
        final String lllllllllllllIlIllIlIIIlIIllllll = String.valueOf(new StringBuilder().append(lllllllllllllIlIllIlIIIlIlIIIIIl.getName()).append("$"));
        final int lllllllllllllIlIllIlIIIlIIlllllI = lllllllllllllIlIllIlIIIlIlIIIIII.tableLength();
        final List<CtClass> lllllllllllllIlIllIlIIIlIIllllIl = new ArrayList<CtClass>(lllllllllllllIlIllIlIIIlIIlllllI);
        for (int lllllllllllllIlIllIlIIIlIlIIIIll = 0; lllllllllllllIlIllIlIIIlIlIIIIll < lllllllllllllIlIllIlIIIlIIlllllI; ++lllllllllllllIlIllIlIIIlIlIIIIll) {
            final String lllllllllllllIlIllIlIIIlIlIIIlII = lllllllllllllIlIllIlIIIlIlIIIIII.innerClass(lllllllllllllIlIllIlIIIlIlIIIIll);
            if (lllllllllllllIlIllIlIIIlIlIIIlII != null && lllllllllllllIlIllIlIIIlIlIIIlII.startsWith(lllllllllllllIlIllIlIIIlIIllllll) && lllllllllllllIlIllIlIIIlIlIIIlII.lastIndexOf(36) < lllllllllllllIlIllIlIIIlIIllllll.length()) {
                lllllllllllllIlIllIlIIIlIIllllIl.add(this.classPool.get(lllllllllllllIlIllIlIIIlIlIIIlII));
            }
        }
        return lllllllllllllIlIllIlIIIlIIllllIl.toArray(new CtClass[lllllllllllllIlIllIlIIIlIIllllIl.size()]);
    }
    
    private static void insertAuxInitializer(final CodeAttribute lllllllllllllIlIllIIllIIllIIIIII, final Bytecode lllllllllllllIlIllIIllIIlIlllIII, final int lllllllllllllIlIllIIllIIlIllIlll) throws BadBytecode {
        final CodeIterator lllllllllllllIlIllIIllIIlIllllIl = lllllllllllllIlIllIIllIIllIIIIII.iterator();
        int lllllllllllllIlIllIIllIIlIllllII = lllllllllllllIlIllIIllIIlIllllIl.skipSuperConstructor();
        if (lllllllllllllIlIllIIllIIlIllllII < 0) {
            lllllllllllllIlIllIIllIIlIllllII = lllllllllllllIlIllIIllIIlIllllIl.skipThisConstructor();
            if (lllllllllllllIlIllIIllIIlIllllII >= 0) {
                return;
            }
        }
        final int lllllllllllllIlIllIIllIIlIlllIll = lllllllllllllIlIllIIllIIlIllllIl.insertEx(lllllllllllllIlIllIIllIIlIlllIII.get());
        lllllllllllllIlIllIIllIIlIllllIl.insert(lllllllllllllIlIllIIllIIlIlllIII.getExceptionTable(), lllllllllllllIlIllIIllIIlIlllIll);
        final int lllllllllllllIlIllIIllIIlIlllIlI = lllllllllllllIlIllIIllIIllIIIIII.getMaxStack();
        if (lllllllllllllIlIllIIllIIlIlllIlI < lllllllllllllIlIllIIllIIlIllIlll) {
            lllllllllllllIlIllIIllIIllIIIIII.setMaxStack(lllllllllllllIlIllIIllIIlIllIlll);
        }
    }
    
    Map<CtMethod, String> getHiddenMethods() {
        if (this.hiddenMethods == null) {
            this.hiddenMethods = new Hashtable<CtMethod, String>();
        }
        return this.hiddenMethods;
    }
    
    @Override
    public CtMethod getMethod(final String lllllllllllllIlIllIIlllIIlIlIllI, final String lllllllllllllIlIllIIlllIIlIlIlIl) throws NotFoundException {
        final CtMethod lllllllllllllIlIllIIlllIIlIlIlII = getMethod0(this, lllllllllllllIlIllIIlllIIlIlIllI, lllllllllllllIlIllIIlllIIlIlIlIl);
        if (lllllllllllllIlIllIIlllIIlIlIlII != null) {
            return lllllllllllllIlIllIIlllIIlIlIlII;
        }
        throw new NotFoundException(String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIlllIIlIlIllI).append("(..) is not found in ").append(this.getName())));
    }
    
    private void checkPruned(final String lllllllllllllIlIllIIllIlIIllIIII) {
        if (this.wasPruned) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIllIlIIllIIII).append("(): ").append(this.getName()).append(" was pruned.")));
        }
    }
    
    private static boolean notFindInArray(final String lllllllllllllIlIllIIllIIIllllIIl, final String[] lllllllllllllIlIllIIllIIIllllIII) {
        for (int lllllllllllllIlIllIIllIIIlllIlll = lllllllllllllIlIllIIllIIIllllIII.length, lllllllllllllIlIllIIllIIIllllIlI = 0; lllllllllllllIlIllIIllIIIllllIlI < lllllllllllllIlIllIIllIIIlllIlll; ++lllllllllllllIlIllIIllIIIllllIlI) {
            if (lllllllllllllIlIllIIllIIIllllIII[lllllllllllllIlIllIIllIIIllllIlI].startsWith(lllllllllllllIlIllIIllIIIllllIIl)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void removeMethod(final CtMethod lllllllllllllIlIllIIllIllIIlIlII) throws NotFoundException {
        this.checkModify();
        final MethodInfo lllllllllllllIlIllIIllIllIIlIlll = lllllllllllllIlIllIIllIllIIlIlII.getMethodInfo2();
        final ClassFile lllllllllllllIlIllIIllIllIIlIllI = this.getClassFile2();
        if (lllllllllllllIlIllIIllIllIIlIllI.getMethods().remove(lllllllllllllIlIllIIllIllIIlIlll)) {
            this.getMembers().remove(lllllllllllllIlIllIIllIllIIlIlII);
            this.gcConstPool = true;
            return;
        }
        throw new NotFoundException(lllllllllllllIlIllIIllIllIIlIlII.toString());
    }
    
    @Override
    public void addConstructor(final CtConstructor lllllllllllllIlIllIIllIllIllIlIl) throws CannotCompileException {
        this.checkModify();
        if (lllllllllllllIlIllIIllIllIllIlIl.getDeclaringClass() != this) {
            throw new CannotCompileException("cannot add");
        }
        this.getMembers().addConstructor(lllllllllllllIlIllIIllIllIllIlIl);
        this.getClassFile2().addMethod(lllllllllllllIlIllIIllIllIllIlIl.getMethodInfo2());
    }
    
    private static boolean isPubCons(final CtConstructor lllllllllllllIlIllIIlllIlIllIllI) {
        return !Modifier.isPrivate(lllllllllllllIlIllIIlllIlIllIllI.getModifiers()) && lllllllllllllIlIllIIlllIlIllIllI.isConstructor();
    }
    
    @Override
    public Object getAnnotation(final Class<?> lllllllllllllIlIllIlIIIIllIlIIlI) throws ClassNotFoundException {
        final ClassFile lllllllllllllIlIllIlIIIIllIlIIIl = this.getClassFile2();
        final AnnotationsAttribute lllllllllllllIlIllIlIIIIllIlIIII = (AnnotationsAttribute)lllllllllllllIlIllIlIIIIllIlIIIl.getAttribute("RuntimeInvisibleAnnotations");
        final AnnotationsAttribute lllllllllllllIlIllIlIIIIllIIllll = (AnnotationsAttribute)lllllllllllllIlIllIlIIIIllIlIIIl.getAttribute("RuntimeVisibleAnnotations");
        return getAnnotationType(lllllllllllllIlIllIlIIIIllIlIIlI, this.getClassPool(), lllllllllllllIlIllIlIIIIllIlIIII, lllllllllllllIlIllIlIIIIllIIllll);
    }
    
    private int makeFieldInitializer(final Bytecode lllllllllllllIlIllIIllIIlIlIIIII, final CtClass[] lllllllllllllIlIllIIllIIlIIlllll) throws NotFoundException, CannotCompileException {
        int lllllllllllllIlIllIIllIIlIlIIIll = 0;
        final Javac lllllllllllllIlIllIIllIIlIlIIIlI = new Javac(lllllllllllllIlIllIIllIIlIlIIIII, this);
        try {
            lllllllllllllIlIllIIllIIlIlIIIlI.recordParams(lllllllllllllIlIllIIllIIlIIlllll, false);
        }
        catch (CompileError lllllllllllllIlIllIIllIIlIlIlIlI) {
            throw new CannotCompileException(lllllllllllllIlIllIIllIIlIlIlIlI);
        }
        for (FieldInitLink lllllllllllllIlIllIIllIIlIlIIlll = this.fieldInitializers; lllllllllllllIlIllIIllIIlIlIIlll != null; lllllllllllllIlIllIIllIIlIlIIlll = lllllllllllllIlIllIIllIIlIlIIlll.next) {
            final CtField lllllllllllllIlIllIIllIIlIlIlIII = lllllllllllllIlIllIIllIIlIlIIlll.field;
            if (!Modifier.isStatic(lllllllllllllIlIllIIllIIlIlIlIII.getModifiers())) {
                final int lllllllllllllIlIllIIllIIlIlIlIIl = lllllllllllllIlIllIIllIIlIlIIlll.init.compile(lllllllllllllIlIllIIllIIlIlIlIII.getType(), lllllllllllllIlIllIIllIIlIlIlIII.getName(), lllllllllllllIlIllIIllIIlIlIIIII, lllllllllllllIlIllIIllIIlIIlllll, lllllllllllllIlIllIIllIIlIlIIIlI);
                if (lllllllllllllIlIllIIllIIlIlIIIll < lllllllllllllIlIllIIllIIlIlIlIIl) {
                    lllllllllllllIlIllIIllIIlIlIIIll = lllllllllllllIlIllIIllIIlIlIlIIl;
                }
            }
        }
        return lllllllllllllIlIllIIllIIlIlIIIll;
    }
    
    static boolean hasAnnotationType(final String lllllllllllllIlIllIlIIIIlllIIlII, final ClassPool lllllllllllllIlIllIlIIIIlllIIIll, final AnnotationsAttribute lllllllllllllIlIllIlIIIIlllIIIlI, final AnnotationsAttribute lllllllllllllIlIllIlIIIIlllIIIIl) {
        Annotation[] lllllllllllllIlIllIlIIIIlllIIIII = null;
        if (lllllllllllllIlIllIlIIIIlllIIIlI == null) {
            final Annotation[] lllllllllllllIlIllIlIIIIlllIlIII = null;
        }
        else {
            lllllllllllllIlIllIlIIIIlllIIIII = lllllllllllllIlIllIlIIIIlllIIIlI.getAnnotations();
        }
        Annotation[] lllllllllllllIlIllIlIIIIllIlllll = null;
        if (lllllllllllllIlIllIlIIIIlllIIIIl == null) {
            final Annotation[] lllllllllllllIlIllIlIIIIlllIIlll = null;
        }
        else {
            lllllllllllllIlIllIlIIIIllIlllll = lllllllllllllIlIllIlIIIIlllIIIIl.getAnnotations();
        }
        if (lllllllllllllIlIllIlIIIIlllIIIII != null) {
            for (int lllllllllllllIlIllIlIIIIlllIIllI = 0; lllllllllllllIlIllIlIIIIlllIIllI < lllllllllllllIlIllIlIIIIlllIIIII.length; ++lllllllllllllIlIllIlIIIIlllIIllI) {
                if (lllllllllllllIlIllIlIIIIlllIIIII[lllllllllllllIlIllIlIIIIlllIIllI].getTypeName().equals(lllllllllllllIlIllIlIIIIlllIIlII)) {
                    return true;
                }
            }
        }
        if (lllllllllllllIlIllIlIIIIllIlllll != null) {
            for (int lllllllllllllIlIllIlIIIIlllIIlIl = 0; lllllllllllllIlIllIlIIIIlllIIlIl < lllllllllllllIlIllIlIIIIllIlllll.length; ++lllllllllllllIlIllIlIIIIlllIIlIl) {
                if (lllllllllllllIlIllIlIIIIllIlllll[lllllllllllllIlIllIlIIIIlllIIlIl].getTypeName().equals(lllllllllllllIlIllIlIIIIlllIIlII)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private CtField getDeclaredField2(final String lllllllllllllIlIllIIlllIlllllIll, final String lllllllllllllIlIllIIlllIllllIlII) {
        final CtMember.Cache lllllllllllllIlIllIIlllIlllllIIl = this.getMembers();
        CtMember lllllllllllllIlIllIIlllIlllllIII = lllllllllllllIlIllIIlllIlllllIIl.fieldHead();
        final CtMember lllllllllllllIlIllIIlllIllllIlll = lllllllllllllIlIllIIlllIlllllIIl.lastField();
        while (lllllllllllllIlIllIIlllIlllllIII != lllllllllllllIlIllIIlllIllllIlll) {
            lllllllllllllIlIllIIlllIlllllIII = lllllllllllllIlIllIIlllIlllllIII.next();
            if (lllllllllllllIlIllIIlllIlllllIII.getName().equals(lllllllllllllIlIllIIlllIlllllIll) && (lllllllllllllIlIllIIlllIllllIlII == null || lllllllllllllIlIllIIlllIllllIlII.equals(lllllllllllllIlIllIIlllIlllllIII.getSignature()))) {
                return (CtField)lllllllllllllIlIllIIlllIlllllIII;
            }
        }
        return null;
    }
    
    private Object[] getAnnotations(final boolean lllllllllllllIlIllIlIIIIlIIllIlI) throws ClassNotFoundException {
        final ClassFile lllllllllllllIlIllIlIIIIlIIllllI = this.getClassFile2();
        final AnnotationsAttribute lllllllllllllIlIllIlIIIIlIIlllIl = (AnnotationsAttribute)lllllllllllllIlIllIlIIIIlIIllllI.getAttribute("RuntimeInvisibleAnnotations");
        final AnnotationsAttribute lllllllllllllIlIllIlIIIIlIIlllII = (AnnotationsAttribute)lllllllllllllIlIllIlIIIIlIIllllI.getAttribute("RuntimeVisibleAnnotations");
        return toAnnotationType(lllllllllllllIlIllIlIIIIlIIllIlI, this.getClassPool(), lllllllllllllIlIllIlIIIIlIIlllIl, lllllllllllllIlIllIlIIIIlIIlllII);
    }
    
    @Override
    public ClassPool getClassPool() {
        return this.classPool;
    }
    
    @Override
    public CtClass getDeclaringClass() throws NotFoundException {
        final ClassFile lllllllllllllIlIllIIllllllIlllII = this.getClassFile2();
        final InnerClassesAttribute lllllllllllllIlIllIIllllllIllIll = (InnerClassesAttribute)lllllllllllllIlIllIIllllllIlllII.getAttribute("InnerClasses");
        if (lllllllllllllIlIllIIllllllIllIll == null) {
            return null;
        }
        final String lllllllllllllIlIllIIllllllIllIlI = this.getName();
        for (int lllllllllllllIlIllIIllllllIllIIl = lllllllllllllIlIllIIllllllIllIll.tableLength(), lllllllllllllIlIllIIllllllIllllI = 0; lllllllllllllIlIllIIllllllIllllI < lllllllllllllIlIllIIllllllIllIIl; ++lllllllllllllIlIllIIllllllIllllI) {
            if (lllllllllllllIlIllIIllllllIllIlI.equals(lllllllllllllIlIllIIllllllIllIll.innerClass(lllllllllllllIlIllIIllllllIllllI))) {
                final String lllllllllllllIlIllIIlllllllIIIII = lllllllllllllIlIllIIllllllIllIll.outerClass(lllllllllllllIlIllIIllllllIllllI);
                if (lllllllllllllIlIllIIlllllllIIIII != null) {
                    return this.classPool.get(lllllllllllllIlIllIIlllllllIIIII);
                }
                final EnclosingMethodAttribute lllllllllllllIlIllIIllllllIlllll = (EnclosingMethodAttribute)lllllllllllllIlIllIIllllllIlllII.getAttribute("EnclosingMethod");
                if (lllllllllllllIlIllIIllllllIlllll != null) {
                    return this.classPool.get(lllllllllllllIlIllIIllllllIlllll.className());
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean isFrozen() {
        return this.wasFrozen;
    }
    
    protected synchronized CtMember.Cache getMembers() {
        CtMember.Cache lllllllllllllIlIllIIlllllIIllIlI = null;
        if (this.memberCache == null || (lllllllllllllIlIllIIlllllIIllIlI = this.memberCache.get()) == null) {
            lllllllllllllIlIllIIlllllIIllIlI = new CtMember.Cache(this);
            this.makeFieldCache(lllllllllllllIlIllIIlllllIIllIlI);
            this.makeBehaviorCache(lllllllllllllIlIllIIlllllIIllIlI);
            this.memberCache = new WeakReference<CtMember.Cache>(lllllllllllllIlIllIIlllllIIllIlI);
        }
        return lllllllllllllIlIllIIlllllIIllIlI;
    }
    
    CtClassType(final InputStream lllllllllllllIlIllIlIIlIIIllllll, final ClassPool lllllllllllllIlIllIlIIlIIIlllIll) throws IOException {
        this((String)null, lllllllllllllIlIllIlIIlIIIlllIll);
        this.classfile = new ClassFile(new DataInputStream(lllllllllllllIlIllIlIIlIIIllllll));
        this.qualifiedName = this.classfile.getName();
    }
    
    @Override
    public void addField(final CtField lllllllllllllIlIllIIllIlllIlIlIl, CtField.Initializer lllllllllllllIlIllIIllIlllIlIlII) throws CannotCompileException {
        this.checkModify();
        if (lllllllllllllIlIllIIllIlllIlIlIl.getDeclaringClass() != this) {
            throw new CannotCompileException("cannot add");
        }
        if (lllllllllllllIlIllIIllIlllIlIlII == null) {
            lllllllllllllIlIllIIllIlllIlIlII = lllllllllllllIlIllIIllIlllIlIlIl.getInit();
        }
        if (lllllllllllllIlIllIIllIlllIlIlII != null) {
            ((CtField.Initializer)lllllllllllllIlIllIIllIlllIlIlII).check(lllllllllllllIlIllIIllIlllIlIlIl.getSignature());
            final int lllllllllllllIlIllIIllIlllIlllII = lllllllllllllIlIllIIllIlllIlIlIl.getModifiers();
            if (Modifier.isStatic(lllllllllllllIlIllIIllIlllIlllII) && Modifier.isFinal(lllllllllllllIlIllIIllIlllIlllII)) {
                try {
                    final ConstPool lllllllllllllIlIllIIllIlllIllllI = this.getClassFile2().getConstPool();
                    final int lllllllllllllIlIllIIllIlllIlllIl = ((CtField.Initializer)lllllllllllllIlIllIIllIlllIlIlII).getConstantValue(lllllllllllllIlIllIIllIlllIllllI, lllllllllllllIlIllIIllIlllIlIlIl.getType());
                    if (lllllllllllllIlIllIIllIlllIlllIl != 0) {
                        lllllllllllllIlIllIIllIlllIlIlIl.getFieldInfo2().addAttribute(new ConstantAttribute(lllllllllllllIlIllIIllIlllIllllI, lllllllllllllIlIllIIllIlllIlllIl));
                        lllllllllllllIlIllIIllIlllIlIlII = null;
                    }
                }
                catch (NotFoundException ex) {}
            }
        }
        this.getMembers().addField(lllllllllllllIlIllIIllIlllIlIlIl);
        this.getClassFile2().addField(lllllllllllllIlIllIIllIlllIlIlIl.getFieldInfo2());
        if (lllllllllllllIlIllIIllIlllIlIlII != null) {
            final FieldInitLink lllllllllllllIlIllIIllIlllIllIll = new FieldInitLink(lllllllllllllIlIllIIllIlllIlIlIl, (CtField.Initializer)lllllllllllllIlIllIIllIlllIlIlII);
            FieldInitLink lllllllllllllIlIllIIllIlllIllIlI = this.fieldInitializers;
            if (lllllllllllllIlIllIIllIlllIllIlI == null) {
                this.fieldInitializers = lllllllllllllIlIllIIllIlllIllIll;
            }
            else {
                while (lllllllllllllIlIllIIllIlllIllIlI.next != null) {
                    lllllllllllllIlIllIIllIlllIllIlI = lllllllllllllIlIllIIllIlllIllIlI.next;
                }
                lllllllllllllIlIllIIllIlllIllIlI.next = lllllllllllllIlIllIIllIlllIllIll;
            }
        }
    }
    
    private void modifyClassConstructor(final ClassFile lllllllllllllIlIllIIllIlIIIlIlll) throws CannotCompileException, NotFoundException {
        if (this.fieldInitializers == null) {
            return;
        }
        final Bytecode lllllllllllllIlIllIIllIlIIIlIllI = new Bytecode(lllllllllllllIlIllIIllIlIIIlIlll.getConstPool(), 0, 0);
        final Javac lllllllllllllIlIllIIllIlIIIlIlIl = new Javac(lllllllllllllIlIllIIllIlIIIlIllI, this);
        int lllllllllllllIlIllIIllIlIIIlIlII = 0;
        boolean lllllllllllllIlIllIIllIlIIIlIIll = false;
        for (FieldInitLink lllllllllllllIlIllIIllIlIIIllIIl = this.fieldInitializers; lllllllllllllIlIllIIllIlIIIllIIl != null; lllllllllllllIlIllIIllIlIIIllIIl = lllllllllllllIlIllIIllIlIIIllIIl.next) {
            final CtField lllllllllllllIlIllIIllIlIIIllIlI = lllllllllllllIlIllIIllIlIIIllIIl.field;
            if (Modifier.isStatic(lllllllllllllIlIllIIllIlIIIllIlI.getModifiers())) {
                lllllllllllllIlIllIIllIlIIIlIIll = true;
                final int lllllllllllllIlIllIIllIlIIIllIll = lllllllllllllIlIllIIllIlIIIllIIl.init.compileIfStatic(lllllllllllllIlIllIIllIlIIIllIlI.getType(), lllllllllllllIlIllIIllIlIIIllIlI.getName(), lllllllllllllIlIllIIllIlIIIlIllI, lllllllllllllIlIllIIllIlIIIlIlIl);
                if (lllllllllllllIlIllIIllIlIIIlIlII < lllllllllllllIlIllIIllIlIIIllIll) {
                    lllllllllllllIlIllIIllIlIIIlIlII = lllllllllllllIlIllIIllIlIIIllIll;
                }
            }
        }
        if (lllllllllllllIlIllIIllIlIIIlIIll) {
            this.modifyClassConstructor(lllllllllllllIlIllIIllIlIIIlIlll, lllllllllllllIlIllIIllIlIIIlIllI, lllllllllllllIlIllIIllIlIIIlIlII, 0);
        }
    }
    
    private void makeBehaviorCache(final CtMember.Cache lllllllllllllIlIllIIlllllIIIIIlI) {
        final List<MethodInfo> lllllllllllllIlIllIIlllllIIIIIIl = this.getClassFile3(false).getMethods();
        for (final MethodInfo lllllllllllllIlIllIIlllllIIIIlII : lllllllllllllIlIllIIlllllIIIIIIl) {
            if (lllllllllllllIlIllIIlllllIIIIlII.isMethod()) {
                lllllllllllllIlIllIIlllllIIIIIlI.addMethod(new CtMethod(lllllllllllllIlIllIIlllllIIIIlII, this));
            }
            else {
                lllllllllllllIlIllIIlllllIIIIIlI.addConstructor(new CtConstructor(lllllllllllllIlIllIIlllllIIIIlII, this));
            }
        }
    }
    
    @Override
    public CtClass getSuperclass() throws NotFoundException {
        final String lllllllllllllIlIllIlIIIIIIIlIllI = this.getClassFile2().getSuperclass();
        if (lllllllllllllIlIllIlIIIIIIIlIllI == null) {
            return null;
        }
        return this.classPool.get(lllllllllllllIlIllIlIIIIIIIlIllI);
    }
    
    private void dumpClassFile(final ClassFile lllllllllllllIlIllIIllIlIIlllIIl) throws IOException {
        final DataOutputStream lllllllllllllIlIllIIllIlIIlllIII = this.makeFileOutput(CtClassType.debugDump);
        try {
            lllllllllllllIlIllIIllIlIIlllIIl.write(lllllllllllllIlIllIIllIlIIlllIII);
        }
        finally {
            lllllllllllllIlIllIIllIlIIlllIII.close();
        }
    }
    
    static Object[][] toAnnotationType(final boolean lllllllllllllIlIllIlIIIIIlIIlIlI, final ClassPool lllllllllllllIlIllIlIIIIIlIlIIII, final ParameterAnnotationsAttribute lllllllllllllIlIllIlIIIIIlIIlIII, final ParameterAnnotationsAttribute lllllllllllllIlIllIlIIIIIlIIlllI, final MethodInfo lllllllllllllIlIllIlIIIIIlIIllIl) throws ClassNotFoundException {
        int lllllllllllllIlIllIlIIIIIlIIllII = 0;
        if (lllllllllllllIlIllIlIIIIIlIIlIII != null) {
            lllllllllllllIlIllIlIIIIIlIIllII = lllllllllllllIlIllIlIIIIIlIIlIII.numParameters();
        }
        else if (lllllllllllllIlIllIlIIIIIlIIlllI != null) {
            lllllllllllllIlIllIlIIIIIlIIllII = lllllllllllllIlIllIlIIIIIlIIlllI.numParameters();
        }
        else {
            lllllllllllllIlIllIlIIIIIlIIllII = Descriptor.numOfParameters(lllllllllllllIlIllIlIIIIIlIIllIl.getDescriptor());
        }
        final Object[][] lllllllllllllIlIllIlIIIIIlIIlIll = new Object[lllllllllllllIlIllIlIIIIIlIIllII][];
        for (int lllllllllllllIlIllIlIIIIIlIlIIlI = 0; lllllllllllllIlIllIlIIIIIlIlIIlI < lllllllllllllIlIllIlIIIIIlIIllII; ++lllllllllllllIlIllIlIIIIIlIlIIlI) {
            Annotation[] lllllllllllllIlIllIlIIIIIlIlIllI = null;
            int lllllllllllllIlIllIlIIIIIlIlIlII = 0;
            if (lllllllllllllIlIllIlIIIIIlIIlIII == null) {
                final Annotation[] lllllllllllllIlIllIlIIIIIlIlllll = null;
                final int lllllllllllllIlIllIlIIIIIlIllllI = 0;
            }
            else {
                lllllllllllllIlIllIlIIIIIlIlIllI = lllllllllllllIlIllIlIIIIIlIIlIII.getAnnotations()[lllllllllllllIlIllIlIIIIIlIlIIlI];
                lllllllllllllIlIllIlIIIIIlIlIlII = lllllllllllllIlIllIlIIIIIlIlIllI.length;
            }
            Annotation[] lllllllllllllIlIllIlIIIIIlIlIlIl = null;
            int lllllllllllllIlIllIlIIIIIlIlIIll = 0;
            if (lllllllllllllIlIllIlIIIIIlIIlllI == null) {
                final Annotation[] lllllllllllllIlIllIlIIIIIlIlllIl = null;
                final int lllllllllllllIlIllIlIIIIIlIlllII = 0;
            }
            else {
                lllllllllllllIlIllIlIIIIIlIlIlIl = lllllllllllllIlIllIlIIIIIlIIlllI.getAnnotations()[lllllllllllllIlIllIlIIIIIlIlIIlI];
                lllllllllllllIlIllIlIIIIIlIlIIll = lllllllllllllIlIllIlIIIIIlIlIlIl.length;
            }
            if (!lllllllllllllIlIllIlIIIIIlIIlIlI) {
                lllllllllllllIlIllIlIIIIIlIIlIll[lllllllllllllIlIllIlIIIIIlIlIIlI] = new Object[lllllllllllllIlIllIlIIIIIlIlIlII + lllllllllllllIlIllIlIIIIIlIlIIll];
                for (int lllllllllllllIlIllIlIIIIIlIllIll = 0; lllllllllllllIlIllIlIIIIIlIllIll < lllllllllllllIlIllIlIIIIIlIlIlII; ++lllllllllllllIlIllIlIIIIIlIllIll) {
                    lllllllllllllIlIllIlIIIIIlIIlIll[lllllllllllllIlIllIlIIIIIlIlIIlI][lllllllllllllIlIllIlIIIIIlIllIll] = toAnnoType(lllllllllllllIlIllIlIIIIIlIlIllI[lllllllllllllIlIllIlIIIIIlIllIll], lllllllllllllIlIllIlIIIIIlIlIIII);
                }
                for (int lllllllllllllIlIllIlIIIIIlIllIlI = 0; lllllllllllllIlIllIlIIIIIlIllIlI < lllllllllllllIlIllIlIIIIIlIlIIll; ++lllllllllllllIlIllIlIIIIIlIllIlI) {
                    lllllllllllllIlIllIlIIIIIlIIlIll[lllllllllllllIlIllIlIIIIIlIlIIlI][lllllllllllllIlIllIlIIIIIlIllIlI + lllllllllllllIlIllIlIIIIIlIlIlII] = toAnnoType(lllllllllllllIlIllIlIIIIIlIlIlIl[lllllllllllllIlIllIlIIIIIlIllIlI], lllllllllllllIlIllIlIIIIIlIlIIII);
                }
            }
            else {
                final List<Object> lllllllllllllIlIllIlIIIIIlIlIlll = new ArrayList<Object>();
                for (int lllllllllllllIlIllIlIIIIIlIllIIl = 0; lllllllllllllIlIllIlIIIIIlIllIIl < lllllllllllllIlIllIlIIIIIlIlIlII; ++lllllllllllllIlIllIlIIIIIlIllIIl) {
                    try {
                        lllllllllllllIlIllIlIIIIIlIlIlll.add(toAnnoType(lllllllllllllIlIllIlIIIIIlIlIllI[lllllllllllllIlIllIlIIIIIlIllIIl], lllllllllllllIlIllIlIIIIIlIlIIII));
                    }
                    catch (ClassNotFoundException ex) {}
                }
                for (int lllllllllllllIlIllIlIIIIIlIllIII = 0; lllllllllllllIlIllIlIIIIIlIllIII < lllllllllllllIlIllIlIIIIIlIlIIll; ++lllllllllllllIlIllIlIIIIIlIllIII) {
                    try {
                        lllllllllllllIlIllIlIIIIIlIlIlll.add(toAnnoType(lllllllllllllIlIllIlIIIIIlIlIlIl[lllllllllllllIlIllIlIIIIIlIllIII], lllllllllllllIlIllIlIIIIIlIlIIII));
                    }
                    catch (ClassNotFoundException ex2) {}
                }
                lllllllllllllIlIllIlIIIIIlIIlIll[lllllllllllllIlIllIlIIIIIlIlIIlI] = lllllllllllllIlIllIlIIIIIlIlIlll.toArray();
            }
        }
        return lllllllllllllIlIllIlIIIIIlIIlIll;
    }
    
    @Override
    public void replaceClassName(final String lllllllllllllIlIllIlIIIlIllIIlII, final String lllllllllllllIlIllIlIIIlIllIIIll) throws RuntimeException {
        final String lllllllllllllIlIllIlIIIlIllIIllI = this.getName();
        if (lllllllllllllIlIllIlIIIlIllIIllI.equals(lllllllllllllIlIllIlIIIlIllIIlII)) {
            this.setName(lllllllllllllIlIllIlIIIlIllIIIll);
        }
        else {
            super.replaceClassName(lllllllllllllIlIllIlIIIlIllIIlII, lllllllllllllIlIllIlIIIlIllIIIll);
            this.getClassFile2().renameClass(lllllllllllllIlIllIlIIIlIllIIlII, lllllllllllllIlIllIlIIIlIllIIIll);
            this.nameReplaced();
        }
    }
    
    @Override
    public void setSuperclass(final CtClass lllllllllllllIlIllIlIIIIIIIlIIII) throws CannotCompileException {
        this.checkModify();
        if (this.isInterface()) {
            this.addInterface(lllllllllllllIlIllIlIIIIIIIlIIII);
        }
        else {
            this.getClassFile2().setSuperclass(lllllllllllllIlIllIlIIIIIIIlIIII.getName());
        }
    }
    
    @Override
    public boolean isEnum() {
        return Modifier.isEnum(this.getModifiers());
    }
    
    int getUniqueNumber() {
        return this.uniqueNumberSeed++;
    }
    
    @Override
    public void setAttribute(final String lllllllllllllIlIllIIllIlIlllllll, final byte[] lllllllllllllIlIllIIllIllIIIIIlI) {
        this.checkModify();
        final ClassFile lllllllllllllIlIllIIllIllIIIIIIl = this.getClassFile2();
        lllllllllllllIlIllIIllIllIIIIIIl.addAttribute(new AttributeInfo(lllllllllllllIlIllIIllIllIIIIIIl.getConstPool(), lllllllllllllIlIllIIllIlIlllllll, lllllllllllllIlIllIIllIllIIIIIlI));
    }
    
    @Override
    public CtMethod getDeclaredMethod(final String lllllllllllllIlIllIIllIlllllIIll, final CtClass[] lllllllllllllIlIllIIllIlllllIIlI) throws NotFoundException {
        final String lllllllllllllIlIllIIllIllllllIII = Descriptor.ofParameters(lllllllllllllIlIllIIllIlllllIIlI);
        final CtMember.Cache lllllllllllllIlIllIIllIlllllIlll = this.getMembers();
        CtMember lllllllllllllIlIllIIllIlllllIllI = lllllllllllllIlIllIIllIlllllIlll.methodHead();
        final CtMember lllllllllllllIlIllIIllIlllllIlIl = lllllllllllllIlIllIIllIlllllIlll.lastMethod();
        while (lllllllllllllIlIllIIllIlllllIllI != lllllllllllllIlIllIIllIlllllIlIl) {
            lllllllllllllIlIllIIllIlllllIllI = lllllllllllllIlIllIIllIlllllIllI.next();
            if (lllllllllllllIlIllIIllIlllllIllI.getName().equals(lllllllllllllIlIllIIllIlllllIIll) && ((CtMethod)lllllllllllllIlIllIIllIlllllIllI).getMethodInfo2().getDescriptor().startsWith(lllllllllllllIlIllIIllIllllllIII)) {
                return (CtMethod)lllllllllllllIlIllIIllIlllllIllI;
            }
        }
        throw new NotFoundException(String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIllIlllllIIll).append("(..) is not found in ").append(this.getName())));
    }
    
    @Override
    public void freeze() {
        this.wasFrozen = true;
    }
    
    private void exToString(final StringBuffer lllllllllllllIlIllIlIIlIIIIlIlll, final String lllllllllllllIlIllIlIIlIIIIllIlI, CtMember lllllllllllllIlIllIlIIlIIIIlIlIl, final CtMember lllllllllllllIlIllIlIIlIIIIllIII) {
        lllllllllllllIlIllIlIIlIIIIlIlll.append(lllllllllllllIlIllIlIIlIIIIllIlI);
        while (lllllllllllllIlIllIlIIlIIIIlIlIl != lllllllllllllIlIllIlIIlIIIIllIII) {
            lllllllllllllIlIllIlIIlIIIIlIlIl = ((CtMember)lllllllllllllIlIllIlIIlIIIIlIlIl).next();
            lllllllllllllIlIllIlIIlIIIIlIlll.append(lllllllllllllIlIllIlIIlIIIIlIlIl);
            lllllllllllllIlIllIlIIlIIIIlIlll.append(", ");
        }
    }
    
    @Override
    public CtMethod[] getDeclaredMethods(final String lllllllllllllIlIllIIlllIIIIlIllI) throws NotFoundException {
        final CtMember.Cache lllllllllllllIlIllIIlllIIIIllIll = this.getMembers();
        CtMember lllllllllllllIlIllIIlllIIIIllIlI = lllllllllllllIlIllIIlllIIIIllIll.methodHead();
        final CtMember lllllllllllllIlIllIIlllIIIIllIIl = lllllllllllllIlIllIIlllIIIIllIll.lastMethod();
        final List<CtMember> lllllllllllllIlIllIIlllIIIIllIII = new ArrayList<CtMember>();
        while (lllllllllllllIlIllIIlllIIIIllIlI != lllllllllllllIlIllIIlllIIIIllIIl) {
            lllllllllllllIlIllIIlllIIIIllIlI = lllllllllllllIlIllIIlllIIIIllIlI.next();
            if (lllllllllllllIlIllIIlllIIIIllIlI.getName().equals(lllllllllllllIlIllIIlllIIIIlIllI)) {
                lllllllllllllIlIllIIlllIIIIllIII.add(lllllllllllllIlIllIIlllIIIIllIlI);
            }
        }
        return lllllllllllllIlIllIIlllIIIIllIII.toArray(new CtMethod[lllllllllllllIlIllIIlllIIIIllIII.size()]);
    }
    
    @Override
    public CtConstructor getConstructor(final String lllllllllllllIlIllIIlllIlIlIIlll) throws NotFoundException {
        final CtMember.Cache lllllllllllllIlIllIIlllIlIlIlIll = this.getMembers();
        CtMember lllllllllllllIlIllIIlllIlIlIlIlI = lllllllllllllIlIllIIlllIlIlIlIll.consHead();
        final CtMember lllllllllllllIlIllIIlllIlIlIlIIl = lllllllllllllIlIllIIlllIlIlIlIll.lastCons();
        while (lllllllllllllIlIllIIlllIlIlIlIlI != lllllllllllllIlIllIIlllIlIlIlIIl) {
            lllllllllllllIlIllIIlllIlIlIlIlI = lllllllllllllIlIllIIlllIlIlIlIlI.next();
            final CtConstructor lllllllllllllIlIllIIlllIlIlIlllI = (CtConstructor)lllllllllllllIlIllIIlllIlIlIlIlI;
            if (lllllllllllllIlIllIIlllIlIlIlllI.getMethodInfo2().getDescriptor().equals(lllllllllllllIlIllIIlllIlIlIIlll) && lllllllllllllIlIllIIlllIlIlIlllI.isConstructor()) {
                return lllllllllllllIlIllIIlllIlIlIlllI;
            }
        }
        return super.getConstructor(lllllllllllllIlIllIIlllIlIlIIlll);
    }
    
    private static void updateInnerEntry(final int lllllllllllllIlIllIlIIIlIIIllIlI, final String lllllllllllllIlIllIlIIIlIIIlIIll, final CtClass lllllllllllllIlIllIlIIIlIIIlIIlI, final boolean lllllllllllllIlIllIlIIIlIIIlIlll) {
        final ClassFile lllllllllllllIlIllIlIIIlIIIlIllI = lllllllllllllIlIllIlIIIlIIIlIIlI.getClassFile2();
        final InnerClassesAttribute lllllllllllllIlIllIlIIIlIIIlIlIl = (InnerClassesAttribute)lllllllllllllIlIllIlIIIlIIIlIllI.getAttribute("InnerClasses");
        if (lllllllllllllIlIllIlIIIlIIIlIlIl != null) {
            final int lllllllllllllIlIllIlIIIlIIIlllII = lllllllllllllIlIllIlIIIlIIIllIlI & 0xFFFFFFF7;
            final int lllllllllllllIlIllIlIIIlIIIllIll = lllllllllllllIlIllIlIIIlIIIlIlIl.find(lllllllllllllIlIllIlIIIlIIIlIIll);
            if (lllllllllllllIlIllIlIIIlIIIllIll >= 0) {
                final int lllllllllllllIlIllIlIIIlIIIlllIl = lllllllllllllIlIllIlIIIlIIIlIlIl.accessFlags(lllllllllllllIlIllIlIIIlIIIllIll) & 0x8;
                if (lllllllllllllIlIllIlIIIlIIIlllIl != 0 || !Modifier.isStatic(lllllllllllllIlIllIlIIIlIIIllIlI)) {
                    lllllllllllllIlIllIlIIIlIIIlIIlI.checkModify();
                    lllllllllllllIlIllIlIIIlIIIlIlIl.setAccessFlags(lllllllllllllIlIllIlIIIlIIIllIll, AccessFlag.of(lllllllllllllIlIllIlIIIlIIIlllII) | lllllllllllllIlIllIlIIIlIIIlllIl);
                    final String lllllllllllllIlIllIlIIIlIIIllllI = lllllllllllllIlIllIlIIIlIIIlIlIl.outerClass(lllllllllllllIlIllIlIIIlIIIllIll);
                    if (lllllllllllllIlIllIlIIIlIIIllllI != null && lllllllllllllIlIllIlIIIlIIIlIlll) {
                        try {
                            final CtClass lllllllllllllIlIllIlIIIlIIlIIIII = lllllllllllllIlIllIlIIIlIIIlIIlI.getClassPool().get(lllllllllllllIlIllIlIIIlIIIllllI);
                            updateInnerEntry(lllllllllllllIlIllIlIIIlIIIlllII, lllllllllllllIlIllIlIIIlIIIlIIll, lllllllllllllIlIllIlIIIlIIlIIIII, false);
                        }
                        catch (NotFoundException lllllllllllllIlIllIlIIIlIIIlllll) {
                            throw new RuntimeException(String.valueOf(new StringBuilder().append("cannot find the declaring class: ").append(lllllllllllllIlIllIlIIIlIIIllllI)));
                        }
                    }
                    return;
                }
            }
        }
        if (Modifier.isStatic(lllllllllllllIlIllIlIIIlIIIllIlI)) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("cannot change ").append(Descriptor.toJavaName(lllllllllllllIlIllIlIIIlIIIlIIll)).append(" into a static class")));
        }
    }
    
    private synchronized void saveClassFile() {
        if (this.classfile == null || this.hasMemberCache() != null) {
            return;
        }
        final ByteArrayOutputStream lllllllllllllIlIllIlIIIllllIIIlI = new ByteArrayOutputStream();
        final DataOutputStream lllllllllllllIlIllIlIIIllllIIIIl = new DataOutputStream(lllllllllllllIlIllIlIIIllllIIIlI);
        try {
            this.classfile.write(lllllllllllllIlIllIlIIIllllIIIIl);
            lllllllllllllIlIllIlIIIllllIIIlI.close();
            this.rawClassfile = lllllllllllllIlIllIlIIIllllIIIlI.toByteArray();
            this.classfile = null;
        }
        catch (IOException ex) {}
    }
    
    private void nameReplaced() {
        final CtMember.Cache lllllllllllllIlIllIIlllllIlIIlIl = this.hasMemberCache();
        if (lllllllllllllIlIllIIlllllIlIIlIl != null) {
            CtMember lllllllllllllIlIllIIlllllIlIlIII = lllllllllllllIlIllIIlllllIlIIlIl.methodHead();
            final CtMember lllllllllllllIlIllIIlllllIlIIlll = lllllllllllllIlIllIIlllllIlIIlIl.lastMethod();
            while (lllllllllllllIlIllIIlllllIlIlIII != lllllllllllllIlIllIIlllllIlIIlll) {
                lllllllllllllIlIllIIlllllIlIlIII = lllllllllllllIlIllIIlllllIlIlIII.next();
                lllllllllllllIlIllIIlllllIlIlIII.nameReplaced();
            }
        }
    }
    
    @Override
    public void setModifiers(final int lllllllllllllIlIllIlIIIlIIllIIII) {
        this.checkModify();
        updateInnerEntry(lllllllllllllIlIllIlIIIlIIllIIII, this.getName(), this, true);
        final ClassFile lllllllllllllIlIllIlIIIlIIlIllll = this.getClassFile2();
        lllllllllllllIlIllIlIIIlIIlIllll.setAccessFlags(AccessFlag.of(lllllllllllllIlIllIlIIIlIIllIIII & 0xFFFFFFF7));
    }
    
    @Override
    public int getModifiers() {
        final ClassFile lllllllllllllIlIllIlIIIlIlIlIIll = this.getClassFile2();
        int lllllllllllllIlIllIlIIIlIlIlIIlI = lllllllllllllIlIllIlIIIlIlIlIIll.getAccessFlags();
        lllllllllllllIlIllIlIIIlIlIlIIlI = AccessFlag.clear(lllllllllllllIlIllIlIIIlIlIlIIlI, 32);
        final int lllllllllllllIlIllIlIIIlIlIlIIIl = lllllllllllllIlIllIlIIIlIlIlIIll.getInnerAccessFlags();
        if (lllllllllllllIlIllIlIIIlIlIlIIIl != -1) {
            if ((lllllllllllllIlIllIlIIIlIlIlIIIl & 0x8) != 0x0) {
                lllllllllllllIlIllIlIIIlIlIlIIlI |= 0x8;
            }
            if ((lllllllllllllIlIllIlIIIlIlIlIIIl & 0x1) != 0x0) {
                lllllllllllllIlIllIlIIIlIlIlIIlI |= 0x1;
            }
            else {
                lllllllllllllIlIllIlIIIlIlIlIIlI &= 0xFFFFFFFE;
                if ((lllllllllllllIlIllIlIIIlIlIlIIIl & 0x4) != 0x0) {
                    lllllllllllllIlIllIlIIIlIlIlIIlI |= 0x4;
                }
                else if ((lllllllllllllIlIllIlIIIlIlIlIIIl & 0x2) != 0x0) {
                    lllllllllllllIlIllIlIIIlIlIlIIlI |= 0x2;
                }
            }
        }
        return AccessFlag.toModifier(lllllllllllllIlIllIlIIIlIlIlIIlI);
    }
    
    @Override
    final void incGetCounter() {
        ++this.getCount;
    }
    
    @Override
    public void replaceClassName(final ClassMap lllllllllllllIlIllIlIIIlIlllIllI) throws RuntimeException {
        final String lllllllllllllIlIllIlIIIlIlllIlIl = this.getName();
        String lllllllllllllIlIllIlIIIlIlllIlII = lllllllllllllIlIllIlIIIlIlllIllI.get(Descriptor.toJvmName(lllllllllllllIlIllIlIIIlIlllIlIl));
        if (lllllllllllllIlIllIlIIIlIlllIlII != null) {
            lllllllllllllIlIllIlIIIlIlllIlII = Descriptor.toJavaName(lllllllllllllIlIllIlIIIlIlllIlII);
            this.classPool.checkNotFrozen(lllllllllllllIlIllIlIIIlIlllIlII);
        }
        super.replaceClassName(lllllllllllllIlIllIlIIIlIlllIllI);
        final ClassFile lllllllllllllIlIllIlIIIlIlllIIll = this.getClassFile2();
        lllllllllllllIlIllIlIIIlIlllIIll.renameClass(lllllllllllllIlIllIlIIIlIlllIllI);
        this.nameReplaced();
        if (lllllllllllllIlIllIlIIIlIlllIlII != null) {
            super.setName(lllllllllllllIlIllIlIIIlIlllIlII);
            this.classPool.classNameChanged(lllllllllllllIlIllIlIIIlIlllIlIl, this);
        }
    }
    
    @Override
    public CtConstructor[] getDeclaredConstructors() {
        final CtMember.Cache lllllllllllllIlIllIIlllIlIIlIllI = this.getMembers();
        final CtMember lllllllllllllIlIllIIlllIlIIlIlIl = lllllllllllllIlIllIIlllIlIIlIllI.consHead();
        final CtMember lllllllllllllIlIllIIlllIlIIlIlII = lllllllllllllIlIllIIlllIlIIlIllI.lastCons();
        int lllllllllllllIlIllIIlllIlIIlIIll = 0;
        CtMember lllllllllllllIlIllIIlllIlIIlIIlI = lllllllllllllIlIllIIlllIlIIlIlIl;
        while (lllllllllllllIlIllIIlllIlIIlIIlI != lllllllllllllIlIllIIlllIlIIlIlII) {
            lllllllllllllIlIllIIlllIlIIlIIlI = lllllllllllllIlIllIIlllIlIIlIIlI.next();
            final CtConstructor lllllllllllllIlIllIIlllIlIIllIIl = (CtConstructor)lllllllllllllIlIllIIlllIlIIlIIlI;
            if (lllllllllllllIlIllIIlllIlIIllIIl.isConstructor()) {
                ++lllllllllllllIlIllIIlllIlIIlIIll;
            }
        }
        final CtConstructor[] lllllllllllllIlIllIIlllIlIIlIIIl = new CtConstructor[lllllllllllllIlIllIIlllIlIIlIIll];
        int lllllllllllllIlIllIIlllIlIIlIIII = 0;
        lllllllllllllIlIllIIlllIlIIlIIlI = lllllllllllllIlIllIIlllIlIIlIlIl;
        while (lllllllllllllIlIllIIlllIlIIlIIlI != lllllllllllllIlIllIIlllIlIIlIlII) {
            lllllllllllllIlIllIIlllIlIIlIIlI = lllllllllllllIlIllIIlllIlIIlIIlI.next();
            final CtConstructor lllllllllllllIlIllIIlllIlIIllIII = (CtConstructor)lllllllllllllIlIllIIlllIlIIlIIlI;
            if (lllllllllllllIlIllIIlllIlIIllIII.isConstructor()) {
                lllllllllllllIlIllIIlllIlIIlIIIl[lllllllllllllIlIllIIlllIlIIlIIII++] = lllllllllllllIlIllIIlllIlIIllIII;
            }
        }
        return lllllllllllllIlIllIIlllIlIIlIIIl;
    }
    
    @Override
    public boolean hasAnnotation(final String lllllllllllllIlIllIlIIIlIIIIIIll) {
        final ClassFile lllllllllllllIlIllIlIIIlIIIIIIlI = this.getClassFile2();
        final AnnotationsAttribute lllllllllllllIlIllIlIIIlIIIIIIIl = (AnnotationsAttribute)lllllllllllllIlIllIlIIIlIIIIIIlI.getAttribute("RuntimeInvisibleAnnotations");
        final AnnotationsAttribute lllllllllllllIlIllIlIIIlIIIIIIII = (AnnotationsAttribute)lllllllllllllIlIllIlIIIlIIIIIIlI.getAttribute("RuntimeVisibleAnnotations");
        return hasAnnotationType(lllllllllllllIlIllIlIIIlIIIIIIll, this.getClassPool(), lllllllllllllIlIllIlIIIlIIIIIIIl, lllllllllllllIlIllIlIIIlIIIIIIII);
    }
    
    @Override
    public CtBehavior getEnclosingBehavior() throws NotFoundException {
        final ClassFile lllllllllllllIlIllIIllllllIIlIlI = this.getClassFile2();
        final EnclosingMethodAttribute lllllllllllllIlIllIIllllllIIlIIl = (EnclosingMethodAttribute)lllllllllllllIlIllIIllllllIIlIlI.getAttribute("EnclosingMethod");
        if (lllllllllllllIlIllIIllllllIIlIIl == null) {
            return null;
        }
        final CtClass lllllllllllllIlIllIIllllllIIlIII = this.classPool.get(lllllllllllllIlIllIIllllllIIlIIl.className());
        final String lllllllllllllIlIllIIllllllIIIlll = lllllllllllllIlIllIIllllllIIlIIl.methodName();
        if ("<init>".equals(lllllllllllllIlIllIIllllllIIIlll)) {
            return lllllllllllllIlIllIIllllllIIlIII.getConstructor(lllllllllllllIlIllIIllllllIIlIIl.methodDescriptor());
        }
        if ("<clinit>".equals(lllllllllllllIlIllIIllllllIIIlll)) {
            return lllllllllllllIlIllIIllllllIIlIII.getClassInitializer();
        }
        return lllllllllllllIlIllIIllllllIIlIII.getMethod(lllllllllllllIlIllIIllllllIIIlll, lllllllllllllIlIllIIllllllIIlIIl.methodDescriptor());
    }
    
    @Override
    public void rebuildClassFile() {
        this.gcConstPool = true;
    }
    
    CtClassType(final String lllllllllllllIlIllIlIIlIIlIIIlIl, final ClassPool lllllllllllllIlIllIlIIlIIlIIIlll) {
        super(lllllllllllllIlIllIlIIlIIlIIIlIl);
        this.doPruning = ClassPool.doPruning;
        this.classPool = lllllllllllllIlIllIlIIlIIlIIIlll;
        final boolean b = false;
        this.gcConstPool = b;
        this.wasPruned = b;
        this.wasFrozen = b;
        this.wasChanged = b;
        this.classfile = null;
        this.rawClassfile = null;
        this.memberCache = null;
        this.accessors = null;
        this.fieldInitializers = null;
        this.hiddenMethods = null;
        this.uniqueNumberSeed = 0;
        this.getCount = 0;
    }
    
    @Override
    public void toBytecode(final DataOutputStream lllllllllllllIlIllIIllIlIlIIIIII) throws CannotCompileException, IOException {
        try {
            if (this.isModified()) {
                this.checkPruned("toBytecode");
                final ClassFile lllllllllllllIlIllIIllIlIlIIIllI = this.getClassFile2();
                if (this.gcConstPool) {
                    lllllllllllllIlIllIIllIlIlIIIllI.compact();
                    this.gcConstPool = false;
                }
                this.modifyClassConstructor(lllllllllllllIlIllIIllIlIlIIIllI);
                this.modifyConstructors(lllllllllllllIlIllIIllIlIlIIIllI);
                if (CtClassType.debugDump != null) {
                    this.dumpClassFile(lllllllllllllIlIllIIllIlIlIIIllI);
                }
                lllllllllllllIlIllIIllIlIlIIIllI.write(lllllllllllllIlIllIIllIlIlIIIIII);
                lllllllllllllIlIllIIllIlIlIIIIII.flush();
                this.fieldInitializers = null;
                if (this.doPruning) {
                    lllllllllllllIlIllIIllIlIlIIIllI.prune();
                    this.wasPruned = true;
                }
            }
            else {
                this.classPool.writeClassfile(this.getName(), lllllllllllllIlIllIIllIlIlIIIIII);
            }
            this.getCount = 0;
            this.wasFrozen = true;
        }
        catch (NotFoundException lllllllllllllIlIllIIllIlIlIIIlIl) {
            throw new CannotCompileException(lllllllllllllIlIllIIllIlIlIIIlIl);
        }
        catch (IOException lllllllllllllIlIllIIllIlIlIIIlII) {
            throw new CannotCompileException(lllllllllllllIlIllIIllIlIlIIIlII);
        }
    }
    
    @Override
    public void prune() {
        if (this.wasPruned) {
            return;
        }
        final boolean b = true;
        this.wasFrozen = b;
        this.wasPruned = b;
        this.getClassFile2().prune();
    }
    
    @Override
    public String getGenericSignature() {
        final SignatureAttribute lllllllllllllIlIllIlIIIllIIIlIll = (SignatureAttribute)this.getClassFile2().getAttribute("Signature");
        return (lllllllllllllIlIllIlIIIllIIIlIll == null) ? null : lllllllllllllIlIllIlIIIllIIIlIll.getSignature();
    }
    
    @Override
    public void addMethod(final CtMethod lllllllllllllIlIllIIllIllIIlllll) throws CannotCompileException {
        this.checkModify();
        if (lllllllllllllIlIllIIllIllIIlllll.getDeclaringClass() != this) {
            throw new CannotCompileException("bad declaring class");
        }
        final int lllllllllllllIlIllIIllIllIlIIIIl = lllllllllllllIlIllIIllIllIIlllll.getModifiers();
        if ((this.getModifiers() & 0x200) != 0x0) {
            if (Modifier.isProtected(lllllllllllllIlIllIIllIllIlIIIIl) || Modifier.isPrivate(lllllllllllllIlIllIIllIllIlIIIIl)) {
                throw new CannotCompileException(String.valueOf(new StringBuilder().append("an interface method must be public: ").append(lllllllllllllIlIllIIllIllIIlllll.toString())));
            }
            lllllllllllllIlIllIIllIllIIlllll.setModifiers(lllllllllllllIlIllIIllIllIlIIIIl | 0x1);
        }
        this.getMembers().addMethod(lllllllllllllIlIllIIllIllIIlllll);
        this.getClassFile2().addMethod(lllllllllllllIlIllIIllIllIIlllll.getMethodInfo2());
        if ((lllllllllllllIlIllIIllIllIlIIIIl & 0x400) != 0x0) {
            this.setModifiers(this.getModifiers() | 0x400);
        }
    }
    
    static {
        GET_THRESHOLD = 2;
    }
    
    @Override
    public CtClass[] getInterfaces() throws NotFoundException {
        final String[] lllllllllllllIlIllIlIIIIIIIIIllI = this.getClassFile2().getInterfaces();
        final int lllllllllllllIlIllIlIIIIIIIIIlIl = lllllllllllllIlIllIlIIIIIIIIIllI.length;
        final CtClass[] lllllllllllllIlIllIlIIIIIIIIIlII = new CtClass[lllllllllllllIlIllIlIIIIIIIIIlIl];
        for (int lllllllllllllIlIllIlIIIIIIIIlIII = 0; lllllllllllllIlIllIlIIIIIIIIlIII < lllllllllllllIlIllIlIIIIIIIIIlIl; ++lllllllllllllIlIllIlIIIIIIIIlIII) {
            lllllllllllllIlIllIlIIIIIIIIIlII[lllllllllllllIlIllIlIIIIIIIIlIII] = this.classPool.get(lllllllllllllIlIllIlIIIIIIIIIllI[lllllllllllllIlIllIlIIIIIIIIlIII]);
        }
        return lllllllllllllIlIllIlIIIIIIIIIlII;
    }
    
    @Override
    public boolean subtypeOf(final CtClass lllllllllllllIlIllIlIIIllIlIlIIl) throws NotFoundException {
        final String lllllllllllllIlIllIlIIIllIlIIlll = lllllllllllllIlIllIlIIIllIlIlIIl.getName();
        if (this == lllllllllllllIlIllIlIIIllIlIlIIl || this.getName().equals(lllllllllllllIlIllIlIIIllIlIIlll)) {
            return true;
        }
        final ClassFile lllllllllllllIlIllIlIIIllIlIIllI = this.getClassFile2();
        final String lllllllllllllIlIllIlIIIllIlIIlIl = lllllllllllllIlIllIlIIIllIlIIllI.getSuperclass();
        if (lllllllllllllIlIllIlIIIllIlIIlIl != null && lllllllllllllIlIllIlIIIllIlIIlIl.equals(lllllllllllllIlIllIlIIIllIlIIlll)) {
            return true;
        }
        final String[] lllllllllllllIlIllIlIIIllIlIIlII = lllllllllllllIlIllIlIIIllIlIIllI.getInterfaces();
        final int lllllllllllllIlIllIlIIIllIlIIIll = lllllllllllllIlIllIlIIIllIlIIlII.length;
        for (int lllllllllllllIlIllIlIIIllIlIlIII = 0; lllllllllllllIlIllIlIIIllIlIlIII < lllllllllllllIlIllIlIIIllIlIIIll; ++lllllllllllllIlIllIlIIIllIlIlIII) {
            if (lllllllllllllIlIllIlIIIllIlIIlII[lllllllllllllIlIllIlIIIllIlIlIII].equals(lllllllllllllIlIllIlIIIllIlIIlll)) {
                return true;
            }
        }
        if (lllllllllllllIlIllIlIIIllIlIIlIl != null && this.classPool.get(lllllllllllllIlIllIlIIIllIlIIlIl).subtypeOf(lllllllllllllIlIllIlIIIllIlIlIIl)) {
            return true;
        }
        for (int lllllllllllllIlIllIlIIIllIlIlIII = 0; lllllllllllllIlIllIlIIIllIlIlIII < lllllllllllllIlIllIlIIIllIlIIIll; ++lllllllllllllIlIllIlIIIllIlIlIII) {
            if (this.classPool.get(lllllllllllllIlIllIlIIIllIlIIlII[lllllllllllllIlIllIlIIIllIlIlIII]).subtypeOf(lllllllllllllIlIllIlIIIllIlIlIIl)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public CtField getDeclaredField(final String lllllllllllllIlIllIIllllIIIIllll) throws NotFoundException {
        return this.getDeclaredField(lllllllllllllIlIllIIllllIIIIllll, null);
    }
    
    @Override
    public void instrument(final ExprEditor lllllllllllllIlIllIIllIlIlIllIlI) throws CannotCompileException {
        this.checkModify();
        final ClassFile lllllllllllllIlIllIIllIlIlIllIIl = this.getClassFile2();
        final List<MethodInfo> lllllllllllllIlIllIIllIlIlIllIII = lllllllllllllIlIllIIllIlIlIllIIl.getMethods();
        final int lllllllllllllIlIllIIllIlIlIlIIll = (Object)lllllllllllllIlIllIIllIlIlIllIII.toArray(new MethodInfo[lllllllllllllIlIllIIllIlIlIllIII.size()]);
        final Exception lllllllllllllIlIllIIllIlIlIlIIlI = (Exception)lllllllllllllIlIllIIllIlIlIlIIll.length;
        for (double lllllllllllllIlIllIIllIlIlIlIIIl = 0; lllllllllllllIlIllIIllIlIlIlIIIl < lllllllllllllIlIllIIllIlIlIlIIlI; ++lllllllllllllIlIllIIllIlIlIlIIIl) {
            final MethodInfo lllllllllllllIlIllIIllIlIlIlllII = lllllllllllllIlIllIIllIlIlIlIIll[lllllllllllllIlIllIIllIlIlIlIIIl];
            lllllllllllllIlIllIIllIlIlIllIlI.doit(this, lllllllllllllIlIllIIllIlIlIlllII);
        }
    }
    
    protected CtMember.Cache hasMemberCache() {
        if (this.memberCache != null) {
            return this.memberCache.get();
        }
        return null;
    }
    
    @Override
    public void setInterfaces(final CtClass[] lllllllllllllIlIllIIllllllllIlIl) {
        this.checkModify();
        String[] lllllllllllllIlIllIIllllllllIlII = null;
        if (lllllllllllllIlIllIIllllllllIlIl == null) {
            final String[] lllllllllllllIlIllIIlllllllllIIl = new String[0];
        }
        else {
            final int lllllllllllllIlIllIIllllllllIlll = lllllllllllllIlIllIIllllllllIlIl.length;
            lllllllllllllIlIllIIllllllllIlII = new String[lllllllllllllIlIllIIllllllllIlll];
            for (int lllllllllllllIlIllIIlllllllllIII = 0; lllllllllllllIlIllIIlllllllllIII < lllllllllllllIlIllIIllllllllIlll; ++lllllllllllllIlIllIIlllllllllIII) {
                lllllllllllllIlIllIIllllllllIlII[lllllllllllllIlIllIIlllllllllIII] = lllllllllllllIlIllIIllllllllIlIl[lllllllllllllIlIllIIlllllllllIII].getName();
            }
        }
        this.getClassFile2().setInterfaces(lllllllllllllIlIllIIllllllllIlII);
    }
    
    @Override
    public Object[] getAnnotations() throws ClassNotFoundException {
        return this.getAnnotations(false);
    }
    
    @Override
    public CtClass makeNestedClass(final String lllllllllllllIlIllIIlllllIllIIlI, final boolean lllllllllllllIlIllIIlllllIllIIIl) {
        if (!lllllllllllllIlIllIIlllllIllIIIl) {
            throw new RuntimeException("sorry, only nested static class is supported");
        }
        this.checkModify();
        final CtClass lllllllllllllIlIllIIlllllIllIlll = this.classPool.makeNestedClass(String.valueOf(new StringBuilder().append(this.getName()).append("$").append(lllllllllllllIlIllIIlllllIllIIlI)));
        final ClassFile lllllllllllllIlIllIIlllllIllIllI = this.getClassFile2();
        final ClassFile lllllllllllllIlIllIIlllllIllIlIl = lllllllllllllIlIllIIlllllIllIlll.getClassFile2();
        InnerClassesAttribute lllllllllllllIlIllIIlllllIllIlII = (InnerClassesAttribute)lllllllllllllIlIllIIlllllIllIllI.getAttribute("InnerClasses");
        if (lllllllllllllIlIllIIlllllIllIlII == null) {
            lllllllllllllIlIllIIlllllIllIlII = new InnerClassesAttribute(lllllllllllllIlIllIIlllllIllIllI.getConstPool());
            lllllllllllllIlIllIIlllllIllIllI.addAttribute(lllllllllllllIlIllIIlllllIllIlII);
        }
        lllllllllllllIlIllIIlllllIllIlII.append(lllllllllllllIlIllIIlllllIllIlll.getName(), this.getName(), lllllllllllllIlIllIIlllllIllIIlI, (lllllllllllllIlIllIIlllllIllIlIl.getAccessFlags() & 0xFFFFFFDF) | 0x8);
        lllllllllllllIlIllIIlllllIllIlIl.addAttribute(lllllllllllllIlIllIIlllllIllIlII.copy(lllllllllllllIlIllIIlllllIllIlIl.getConstPool(), null));
        return lllllllllllllIlIllIIlllllIllIlll;
    }
    
    public ClassFile getClassFile3(final boolean lllllllllllllIlIllIlIIIlllllIllI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/viaversion/viaversion/libs/javassist/CtClassType.classfile:Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;
        //     4: astore_2        /* lllllllllllllIlIllIlIIIllllllIlI */
        //     5: aload_2         /* lllllllllllllIlIllIlIIIllllllIlI */
        //     6: ifnull          11
        //     9: aload_2         /* lllllllllllllIlIllIlIIIllllllIlI */
        //    10: areturn        
        //    11: iload_1         /* lllllllllllllIlIllIlIIIllllllIll */
        //    12: ifeq            22
        //    15: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //    16: getfield        com/viaversion/viaversion/libs/javassist/CtClassType.classPool:Lcom/viaversion/viaversion/libs/javassist/ClassPool;
        //    19: invokevirtual   com/viaversion/viaversion/libs/javassist/ClassPool.compress:()V
        //    22: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //    23: dup            
        //    24: astore          lllllllllllllIlIllIlIIIlllllIIll
        //    26: monitorenter   
        //    27: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //    28: getfield        com/viaversion/viaversion/libs/javassist/CtClassType.classfile:Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;
        //    31: astore_2        /* lllllllllllllIlIllIlIIIllllllIlI */
        //    32: aload_2         /* lllllllllllllIlIllIlIIIllllllIlI */
        //    33: ifnull          41
        //    36: aload_2         /* lllllllllllllIlIllIlIIIllllllIlI */
        //    37: aload           lllllllllllllIlIllIlIIIlllllIIll
        //    39: monitorexit    
        //    40: areturn        
        //    41: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //    42: getfield        com/viaversion/viaversion/libs/javassist/CtClassType.rawClassfile:[B
        //    45: astore_3        /* lllllllllllllIlIllIlIIIlllllIlII */
        //    46: aload           lllllllllllllIlIllIlIIIlllllIIll
        //    48: monitorexit    
        //    49: goto            60
        //    52: astore          5
        //    54: aload           lllllllllllllIlIllIlIIIlllllIIll
        //    56: monitorexit    
        //    57: aload           5
        //    59: athrow         
        //    60: aload_3         /* lllllllllllllIlIllIlIIIllllllIIl */
        //    61: ifnull          141
        //    64: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;
        //    67: dup            
        //    68: new             Ljava/io/DataInputStream;
        //    71: dup            
        //    72: new             Ljava/io/ByteArrayInputStream;
        //    75: dup            
        //    76: aload_3         /* lllllllllllllIlIllIlIIIllllllIIl */
        //    77: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //    80: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    83: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/ClassFile.<init>:(Ljava/io/DataInputStream;)V
        //    86: astore          lllllllllllllIlIllIlIIlIIIIIIIlI
        //    88: goto            108
        //    91: astore          lllllllllllllIlIllIlIIlIIIIIIIIl
        //    93: new             Ljava/lang/RuntimeException;
        //    96: dup            
        //    97: aload           lllllllllllllIlIllIlIIlIIIIIIIIl
        //    99: invokevirtual   java/io/IOException.toString:()Ljava/lang/String;
        //   102: aload           lllllllllllllIlIllIlIIlIIIIIIIIl
        //   104: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   107: athrow         
        //   108: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   109: iconst_2       
        //   110: putfield        com/viaversion/viaversion/libs/javassist/CtClassType.getCount:I
        //   113: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   114: dup            
        //   115: astore          5
        //   117: monitorenter   
        //   118: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   119: aconst_null    
        //   120: putfield        com/viaversion/viaversion/libs/javassist/CtClassType.rawClassfile:[B
        //   123: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   124: aload           lllllllllllllIlIllIlIIlIIIIIIIII
        //   126: invokespecial   com/viaversion/viaversion/libs/javassist/CtClassType.setClassFile:(Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;)Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;
        //   129: aload           5
        //   131: monitorexit    
        //   132: areturn        
        //   133: astore          lllllllllllllIlIllIlIIIlllllIIIl
        //   135: aload           5
        //   137: monitorexit    
        //   138: aload           lllllllllllllIlIllIlIIIlllllIIIl
        //   140: athrow         
        //   141: aconst_null    
        //   142: astore          lllllllllllllIlIllIlIIIllllllIII
        //   144: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   145: getfield        com/viaversion/viaversion/libs/javassist/CtClassType.classPool:Lcom/viaversion/viaversion/libs/javassist/ClassPool;
        //   148: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   149: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClassType.getName:()Ljava/lang/String;
        //   152: invokevirtual   com/viaversion/viaversion/libs/javassist/ClassPool.openClassfile:(Ljava/lang/String;)Ljava/io/InputStream;
        //   155: astore          lllllllllllllIlIllIlIIIllllllIII
        //   157: aload           lllllllllllllIlIllIlIIIllllllIII
        //   159: ifnonnull       174
        //   162: new             Lcom/viaversion/viaversion/libs/javassist/NotFoundException;
        //   165: dup            
        //   166: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   167: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClassType.getName:()Ljava/lang/String;
        //   170: invokespecial   com/viaversion/viaversion/libs/javassist/NotFoundException.<init>:(Ljava/lang/String;)V
        //   173: athrow         
        //   174: new             Ljava/io/BufferedInputStream;
        //   177: dup            
        //   178: aload           lllllllllllllIlIllIlIIIllllllIII
        //   180: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //   183: astore          lllllllllllllIlIllIlIIIllllllIII
        //   185: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;
        //   188: dup            
        //   189: new             Ljava/io/DataInputStream;
        //   192: dup            
        //   193: aload           lllllllllllllIlIllIlIIIllllllIII
        //   195: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //   198: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/ClassFile.<init>:(Ljava/io/DataInputStream;)V
        //   201: astore          lllllllllllllIlIllIlIIIlllllllll
        //   203: aload           lllllllllllllIlIllIlIIIlllllllll
        //   205: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/ClassFile.getName:()Ljava/lang/String;
        //   208: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   209: getfield        com/viaversion/viaversion/libs/javassist/CtClassType.qualifiedName:Ljava/lang/String;
        //   212: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   215: ifne            289
        //   218: new             Ljava/lang/RuntimeException;
        //   221: dup            
        //   222: new             Ljava/lang/StringBuilder;
        //   225: dup            
        //   226: invokespecial   java/lang/StringBuilder.<init>:()V
        //   229: ldc_w           "cannot find "
        //   232: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   235: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   236: getfield        com/viaversion/viaversion/libs/javassist/CtClassType.qualifiedName:Ljava/lang/String;
        //   239: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   242: ldc_w           ": "
        //   245: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   248: aload           lllllllllllllIlIllIlIIIlllllllll
        //   250: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/ClassFile.getName:()Ljava/lang/String;
        //   253: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   256: ldc_w           " found in "
        //   259: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   262: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   263: getfield        com/viaversion/viaversion/libs/javassist/CtClassType.qualifiedName:Ljava/lang/String;
        //   266: bipush          46
        //   268: bipush          47
        //   270: invokevirtual   java/lang/String.replace:(CC)Ljava/lang/String;
        //   273: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   276: ldc_w           ".class"
        //   279: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   282: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   285: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //   288: athrow         
        //   289: aload_0         /* lllllllllllllIlIllIlIIIlllllllII */
        //   290: aload           lllllllllllllIlIllIlIIIlllllllll
        //   292: invokespecial   com/viaversion/viaversion/libs/javassist/CtClassType.setClassFile:(Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;)Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;
        //   295: astore          lllllllllllllIlIllIlIIIlllllIIIl
        //   297: aload           lllllllllllllIlIllIlIIIllllllIII
        //   299: ifnull          312
        //   302: aload           lllllllllllllIlIllIlIIIllllllIII
        //   304: invokevirtual   java/io/InputStream.close:()V
        //   307: goto            312
        //   310: astore          lllllllllllllIlIllIlIIIlllllIIII
        //   312: aload           lllllllllllllIlIllIlIIIlllllIIIl
        //   314: areturn        
        //   315: astore          lllllllllllllIlIllIlIIIllllllllI
        //   317: new             Ljava/lang/RuntimeException;
        //   320: dup            
        //   321: aload           lllllllllllllIlIllIlIIIllllllllI
        //   323: invokevirtual   com/viaversion/viaversion/libs/javassist/NotFoundException.toString:()Ljava/lang/String;
        //   326: aload           lllllllllllllIlIllIlIIIllllllllI
        //   328: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   331: athrow         
        //   332: astore          lllllllllllllIlIllIlIIIlllllllIl
        //   334: new             Ljava/lang/RuntimeException;
        //   337: dup            
        //   338: aload           lllllllllllllIlIllIlIIIlllllllIl
        //   340: invokevirtual   java/io/IOException.toString:()Ljava/lang/String;
        //   343: aload           lllllllllllllIlIllIlIIIlllllllIl
        //   345: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   348: athrow         
        //   349: astore          lllllllllllllIlIllIlIIIllllIllll
        //   351: aload           lllllllllllllIlIllIlIIIllllllIII
        //   353: ifnull          366
        //   356: aload           lllllllllllllIlIllIlIIIllllllIII
        //   358: invokevirtual   java/io/InputStream.close:()V
        //   361: goto            366
        //   364: astore          lllllllllllllIlIllIlIIIllllIlllI
        //   366: aload           lllllllllllllIlIllIlIIIllllIllll
        //   368: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                        
        //  -----  -----  -----  -----  ------------------------------------------------------------
        //  27     40     52     60     Any
        //  41     49     52     60     Any
        //  52     57     52     60     Any
        //  64     88     91     108    Ljava/io/IOException;
        //  118    132    133    141    Any
        //  133    138    133    141    Any
        //  302    307    310    312    Ljava/io/IOException;
        //  144    297    315    332    Lcom/viaversion/viaversion/libs/javassist/NotFoundException;
        //  144    297    332    349    Ljava/io/IOException;
        //  144    297    349    369    Any
        //  356    361    364    366    Ljava/io/IOException;
        //  315    351    349    369    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    protected void extendToString(final StringBuffer lllllllllllllIlIllIlIIlIIIlIIIll) {
        if (this.wasChanged) {
            lllllllllllllIlIllIlIIlIIIlIIIll.append("changed ");
        }
        if (this.wasFrozen) {
            lllllllllllllIlIllIlIIlIIIlIIIll.append("frozen ");
        }
        if (this.wasPruned) {
            lllllllllllllIlIllIlIIlIIIlIIIll.append("pruned ");
        }
        lllllllllllllIlIllIlIIlIIIlIIIll.append(Modifier.toString(this.getModifiers()));
        lllllllllllllIlIllIlIIlIIIlIIIll.append(" class ");
        lllllllllllllIlIllIlIIlIIIlIIIll.append(this.getName());
        try {
            final CtClass lllllllllllllIlIllIlIIlIIIlIllII = this.getSuperclass();
            if (lllllllllllllIlIllIlIIlIIIlIllII != null) {
                final String lllllllllllllIlIllIlIIlIIIlIllIl = lllllllllllllIlIllIlIIlIIIlIllII.getName();
                if (!lllllllllllllIlIllIlIIlIIIlIllIl.equals("java.lang.Object")) {
                    lllllllllllllIlIllIlIIlIIIlIIIll.append(String.valueOf(new StringBuilder().append(" extends ").append(lllllllllllllIlIllIlIIlIIIlIllII.getName())));
                }
            }
        }
        catch (NotFoundException lllllllllllllIlIllIlIIlIIIlIlIll) {
            lllllllllllllIlIllIlIIlIIIlIIIll.append(" extends ??");
        }
        try {
            final CtClass[] lllllllllllllIlIllIlIIlIIIlIlIIl = this.getInterfaces();
            if (lllllllllllllIlIllIlIIlIIIlIlIIl.length > 0) {
                lllllllllllllIlIllIlIIlIIIlIIIll.append(" implements ");
            }
            for (int lllllllllllllIlIllIlIIlIIIlIlIlI = 0; lllllllllllllIlIllIlIIlIIIlIlIlI < lllllllllllllIlIllIlIIlIIIlIlIIl.length; ++lllllllllllllIlIllIlIIlIIIlIlIlI) {
                lllllllllllllIlIllIlIIlIIIlIIIll.append(lllllllllllllIlIllIlIIlIIIlIlIIl[lllllllllllllIlIllIlIIlIIIlIlIlI].getName());
                lllllllllllllIlIllIlIIlIIIlIIIll.append(", ");
            }
        }
        catch (NotFoundException lllllllllllllIlIllIlIIlIIIlIlIII) {
            lllllllllllllIlIllIlIIlIIIlIIIll.append(" extends ??");
        }
        final CtMember.Cache lllllllllllllIlIllIlIIlIIIlIIlIl = this.getMembers();
        this.exToString(lllllllllllllIlIllIlIIlIIIlIIIll, " fields=", lllllllllllllIlIllIlIIlIIIlIIlIl.fieldHead(), lllllllllllllIlIllIlIIlIIIlIIlIl.lastField());
        this.exToString(lllllllllllllIlIllIlIIlIIIlIIIll, " constructors=", lllllllllllllIlIllIlIIlIIIlIIlIl.consHead(), lllllllllllllIlIllIlIIlIIIlIIlIl.lastCons());
        this.exToString(lllllllllllllIlIllIlIIlIIIlIIIll, " methods=", lllllllllllllIlIllIlIIlIIIlIIlIl.methodHead(), lllllllllllllIlIllIlIIlIIIlIIlIl.lastMethod());
    }
    
    @Override
    public CtField getField(final String lllllllllllllIlIllIIllllIlIllIll, final String lllllllllllllIlIllIIllllIlIlIllI) throws NotFoundException {
        final CtField lllllllllllllIlIllIIllllIlIllIIl = this.getField2(lllllllllllllIlIllIIllllIlIllIll, lllllllllllllIlIllIIllllIlIlIllI);
        return this.checkGetField(lllllllllllllIlIllIIllllIlIllIIl, lllllllllllllIlIllIIllllIlIllIll, lllllllllllllIlIllIIllllIlIlIllI);
    }
    
    static Object[] toAnnotationType(final boolean lllllllllllllIlIllIlIIIIIllllIIl, final ClassPool lllllllllllllIlIllIlIIIIIllllIII, final AnnotationsAttribute lllllllllllllIlIllIlIIIIlIIIIIII, final AnnotationsAttribute lllllllllllllIlIllIlIIIIIlllllll) throws ClassNotFoundException {
        Annotation[] lllllllllllllIlIllIlIIIIIllllllI = null;
        int lllllllllllllIlIllIlIIIIIlllllII = 0;
        if (lllllllllllllIlIllIlIIIIlIIIIIII == null) {
            final Annotation[] lllllllllllllIlIllIlIIIIlIIIlIll = null;
            final int lllllllllllllIlIllIlIIIIlIIIlIlI = 0;
        }
        else {
            lllllllllllllIlIllIlIIIIIllllllI = lllllllllllllIlIllIlIIIIlIIIIIII.getAnnotations();
            lllllllllllllIlIllIlIIIIIlllllII = lllllllllllllIlIllIlIIIIIllllllI.length;
        }
        Annotation[] lllllllllllllIlIllIlIIIIIlllllIl = null;
        int lllllllllllllIlIllIlIIIIIllllIll = 0;
        if (lllllllllllllIlIllIlIIIIIlllllll == null) {
            final Annotation[] lllllllllllllIlIllIlIIIIlIIIlIIl = null;
            final int lllllllllllllIlIllIlIIIIlIIIlIII = 0;
        }
        else {
            lllllllllllllIlIllIlIIIIIlllllIl = lllllllllllllIlIllIlIIIIIlllllll.getAnnotations();
            lllllllllllllIlIllIlIIIIIllllIll = lllllllllllllIlIllIlIIIIIlllllIl.length;
        }
        if (!lllllllllllllIlIllIlIIIIIllllIIl) {
            final Object[] lllllllllllllIlIllIlIIIIlIIIIlIl = new Object[lllllllllllllIlIllIlIIIIIlllllII + lllllllllllllIlIllIlIIIIIllllIll];
            for (int lllllllllllllIlIllIlIIIIlIIIIlll = 0; lllllllllllllIlIllIlIIIIlIIIIlll < lllllllllllllIlIllIlIIIIIlllllII; ++lllllllllllllIlIllIlIIIIlIIIIlll) {
                lllllllllllllIlIllIlIIIIlIIIIlIl[lllllllllllllIlIllIlIIIIlIIIIlll] = toAnnoType(lllllllllllllIlIllIlIIIIIllllllI[lllllllllllllIlIllIlIIIIlIIIIlll], lllllllllllllIlIllIlIIIIIllllIII);
            }
            for (int lllllllllllllIlIllIlIIIIlIIIIllI = 0; lllllllllllllIlIllIlIIIIlIIIIllI < lllllllllllllIlIllIlIIIIIllllIll; ++lllllllllllllIlIllIlIIIIlIIIIllI) {
                lllllllllllllIlIllIlIIIIlIIIIlIl[lllllllllllllIlIllIlIIIIlIIIIllI + lllllllllllllIlIllIlIIIIIlllllII] = toAnnoType(lllllllllllllIlIllIlIIIIIlllllIl[lllllllllllllIlIllIlIIIIlIIIIllI], lllllllllllllIlIllIlIIIIIllllIII);
            }
            return lllllllllllllIlIllIlIIIIlIIIIlIl;
        }
        final List<Object> lllllllllllllIlIllIlIIIIIllllIlI = new ArrayList<Object>();
        for (int lllllllllllllIlIllIlIIIIlIIIIlII = 0; lllllllllllllIlIllIlIIIIlIIIIlII < lllllllllllllIlIllIlIIIIIlllllII; ++lllllllllllllIlIllIlIIIIlIIIIlII) {
            try {
                lllllllllllllIlIllIlIIIIIllllIlI.add(toAnnoType(lllllllllllllIlIllIlIIIIIllllllI[lllllllllllllIlIllIlIIIIlIIIIlII], lllllllllllllIlIllIlIIIIIllllIII));
            }
            catch (ClassNotFoundException ex) {}
        }
        for (int lllllllllllllIlIllIlIIIIlIIIIIll = 0; lllllllllllllIlIllIlIIIIlIIIIIll < lllllllllllllIlIllIlIIIIIllllIll; ++lllllllllllllIlIllIlIIIIlIIIIIll) {
            try {
                lllllllllllllIlIllIlIIIIIllllIlI.add(toAnnoType(lllllllllllllIlIllIlIIIIIlllllIl[lllllllllllllIlIllIlIIIIlIIIIIll], lllllllllllllIlIllIlIIIIIllllIII));
            }
            catch (ClassNotFoundException ex2) {}
        }
        return lllllllllllllIlIllIlIIIIIllllIlI.toArray();
    }
}
