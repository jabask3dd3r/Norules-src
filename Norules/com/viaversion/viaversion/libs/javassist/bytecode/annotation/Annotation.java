package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;
import java.io.*;

public class Annotation
{
    /* synthetic */ Map<String, Pair> members;
    /* synthetic */ ConstPool pool;
    /* synthetic */ int typeIndex;
    
    public MemberValue getMemberValue(final String llllllllllllllllIllllIIIlllllIlI) {
        if (this.members == null || this.members.get(llllllllllllllllIllllIIIlllllIlI) == null) {
            return null;
        }
        return this.members.get(llllllllllllllllIllllIIIlllllIlI).value;
    }
    
    public Annotation(final ConstPool llllllllllllllllIllllIIllIIIIlIl, final CtClass llllllllllllllllIllllIIllIIIIIII) throws NotFoundException {
        this(llllllllllllllllIllllIIllIIIIlIl.addUtf8Info(Descriptor.of(llllllllllllllllIllllIIllIIIIIII.getName())), llllllllllllllllIllllIIllIIIIlIl);
        if (!llllllllllllllllIllllIIllIIIIIII.isInterface()) {
            throw new RuntimeException("Only interfaces are allowed for Annotation creation.");
        }
        final CtMethod[] llllllllllllllllIllllIIllIIIIIll = llllllllllllllllIllllIIllIIIIIII.getDeclaredMethods();
        if (llllllllllllllllIllllIIllIIIIIll.length > 0) {
            this.members = new LinkedHashMap<String, Pair>();
        }
        final boolean llllllllllllllllIllllIIlIllllllI = (Object)llllllllllllllllIllllIIllIIIIIll;
        final long llllllllllllllllIllllIIlIlllllIl = llllllllllllllllIllllIIlIllllllI.length;
        for (float llllllllllllllllIllllIIlIlllllII = 0; llllllllllllllllIllllIIlIlllllII < llllllllllllllllIllllIIlIlllllIl; ++llllllllllllllllIllllIIlIlllllII) {
            final CtMethod llllllllllllllllIllllIIllIIIIlll = llllllllllllllllIllllIIlIllllllI[llllllllllllllllIllllIIlIlllllII];
            this.addMemberValue(llllllllllllllllIllllIIllIIIIlll.getName(), createMemberValue(llllllllllllllllIllllIIllIIIIlIl, llllllllllllllllIllllIIllIIIIlll.getReturnType()));
        }
    }
    
    public Object toAnnotationType(final ClassLoader llllllllllllllllIllllIIIlllIIlll, final ClassPool llllllllllllllllIllllIIIllIlllII) throws NoSuchClassError, ClassNotFoundException {
        final Class<?> llllllllllllllllIllllIIIlllIIIll = MemberValue.loadClass(llllllllllllllllIllllIIIlllIIlll, this.getTypeName());
        try {
            return AnnotationImpl.make(llllllllllllllllIllllIIIlllIIlll, llllllllllllllllIllllIIIlllIIIll, llllllllllllllllIllllIIIllIlllII, this);
        }
        catch (IllegalArgumentException llllllllllllllllIllllIIIlllIllIl) {
            throw new ClassNotFoundException(llllllllllllllllIllllIIIlllIIIll.getName(), llllllllllllllllIllllIIIlllIllIl);
        }
        catch (IllegalAccessError llllllllllllllllIllllIIIlllIlIlI) {
            throw new ClassNotFoundException(llllllllllllllllIllllIIIlllIIIll.getName(), llllllllllllllllIllllIIIlllIlIlI);
        }
    }
    
    public Set<String> getMemberNames() {
        if (this.members == null) {
            return null;
        }
        return this.members.keySet();
    }
    
    public static MemberValue createMemberValue(final ConstPool llllllllllllllllIllllIIlIllIllII, final CtClass llllllllllllllllIllllIIlIllIllIl) throws NotFoundException {
        if (llllllllllllllllIllllIIlIllIllIl == CtClass.booleanType) {
            return new BooleanMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl == CtClass.byteType) {
            return new ByteMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl == CtClass.charType) {
            return new CharMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl == CtClass.shortType) {
            return new ShortMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl == CtClass.intType) {
            return new IntegerMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl == CtClass.longType) {
            return new LongMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl == CtClass.floatType) {
            return new FloatMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl == CtClass.doubleType) {
            return new DoubleMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl.getName().equals("java.lang.Class")) {
            return new ClassMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl.getName().equals("java.lang.String")) {
            return new StringMemberValue(llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl.isArray()) {
            final CtClass llllllllllllllllIllllIIlIlllIllI = llllllllllllllllIllllIIlIllIllIl.getComponentType();
            final MemberValue llllllllllllllllIllllIIlIlllIIll = createMemberValue(llllllllllllllllIllllIIlIllIllII, llllllllllllllllIllllIIlIlllIllI);
            return new ArrayMemberValue(llllllllllllllllIllllIIlIlllIIll, llllllllllllllllIllllIIlIllIllII);
        }
        if (llllllllllllllllIllllIIlIllIllIl.isInterface()) {
            final Annotation llllllllllllllllIllllIIlIlllIIlI = new Annotation(llllllllllllllllIllllIIlIllIllII, llllllllllllllllIllllIIlIllIllIl);
            return new AnnotationMemberValue(llllllllllllllllIllllIIlIlllIIlI, llllllllllllllllIllllIIlIllIllII);
        }
        final EnumMemberValue llllllllllllllllIllllIIlIllIllll = new EnumMemberValue(llllllllllllllllIllllIIlIllIllII);
        llllllllllllllllIllllIIlIllIllll.setType(llllllllllllllllIllllIIlIllIllIl.getName());
        return llllllllllllllllIllllIIlIllIllll;
    }
    
    @Override
    public String toString() {
        final StringBuffer llllllllllllllllIllllIIlIIIllIll = new StringBuffer("@");
        llllllllllllllllIllllIIlIIIllIll.append(this.getTypeName());
        if (this.members != null) {
            llllllllllllllllIllllIIlIIIllIll.append("(");
            for (final String llllllllllllllllIllllIIlIIIlllll : this.members.keySet()) {
                llllllllllllllllIllllIIlIIIllIll.append(llllllllllllllllIllllIIlIIIlllll).append("=").append(this.getMemberValue(llllllllllllllllIllllIIlIIIlllll)).append(", ");
            }
            llllllllllllllllIllllIIlIIIllIll.setLength(llllllllllllllllIllllIIlIIIllIll.length() - 2);
            llllllllllllllllIllllIIlIIIllIll.append(")");
        }
        return llllllllllllllllIllllIIlIIIllIll.toString();
    }
    
    public Annotation(final String llllllllllllllllIllllIIllIIlIIIl, final ConstPool llllllllllllllllIllllIIllIIlIIII) {
        this(llllllllllllllllIllllIIllIIlIIII.addUtf8Info(Descriptor.of(llllllllllllllllIllllIIllIIlIIIl)), llllllllllllllllIllllIIllIIlIIII);
    }
    
    public void addMemberValue(final int llllllllllllllllIllllIIlIlIllIIl, final MemberValue llllllllllllllllIllllIIlIlIlIIII) {
        final Pair llllllllllllllllIllllIIlIlIlIlII = new Pair();
        llllllllllllllllIllllIIlIlIlIlII.name = llllllllllllllllIllllIIlIlIllIIl;
        llllllllllllllllIllllIIlIlIlIlII.value = llllllllllllllllIllllIIlIlIlIIII;
        this.addMemberValue(llllllllllllllllIllllIIlIlIlIlII);
    }
    
    public Annotation(final int llllllllllllllllIllllIIllIIlllIl, final ConstPool llllllllllllllllIllllIIllIIllIIl) {
        this.pool = llllllllllllllllIllllIIllIIllIIl;
        this.typeIndex = llllllllllllllllIllllIIllIIlllIl;
        this.members = null;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIllllIIIlIllIlII) {
        if (llllllllllllllllIllllIIIlIllIlII == this) {
            return true;
        }
        if (llllllllllllllllIllllIIIlIllIlII == null || !(llllllllllllllllIllllIIIlIllIlII instanceof Annotation)) {
            return false;
        }
        final Annotation llllllllllllllllIllllIIIlIllIlll = (Annotation)llllllllllllllllIllllIIIlIllIlII;
        if (!this.getTypeName().equals(llllllllllllllllIllllIIIlIllIlll.getTypeName())) {
            return false;
        }
        final Map<String, Pair> llllllllllllllllIllllIIIlIllIllI = llllllllllllllllIllllIIIlIllIlll.members;
        if (this.members == llllllllllllllllIllllIIIlIllIllI) {
            return true;
        }
        if (this.members == null) {
            return llllllllllllllllIllllIIIlIllIllI == null;
        }
        return llllllllllllllllIllllIIIlIllIllI != null && this.members.equals(llllllllllllllllIllllIIIlIllIllI);
    }
    
    public void addMemberValue(final String llllllllllllllllIllllIIlIIlllIll, final MemberValue llllllllllllllllIllllIIlIlIIIIII) {
        final Pair llllllllllllllllIllllIIlIIllllll = new Pair();
        llllllllllllllllIllllIIlIIllllll.name = this.pool.addUtf8Info(llllllllllllllllIllllIIlIIlllIll);
        llllllllllllllllIllllIIlIIllllll.value = llllllllllllllllIllllIIlIlIIIIII;
        if (this.members == null) {
            this.members = new LinkedHashMap<String, Pair>();
        }
        this.members.put(llllllllllllllllIllllIIlIIlllIll, llllllllllllllllIllllIIlIIllllll);
    }
    
    public String getTypeName() {
        return Descriptor.toClassName(this.pool.getUtf8Info(this.typeIndex));
    }
    
    private void addMemberValue(final Pair llllllllllllllllIllllIIlIIllIlII) {
        final String llllllllllllllllIllllIIlIIllIIll = this.pool.getUtf8Info(llllllllllllllllIllllIIlIIllIlII.name);
        if (this.members == null) {
            this.members = new LinkedHashMap<String, Pair>();
        }
        this.members.put(llllllllllllllllIllllIIlIIllIIll, llllllllllllllllIllllIIlIIllIlII);
    }
    
    @Override
    public int hashCode() {
        return this.getTypeName().hashCode() + ((this.members == null) ? 0 : this.members.hashCode());
    }
    
    public void write(final AnnotationsWriter llllllllllllllllIllllIIIllIIIlII) throws IOException {
        final String llllllllllllllllIllllIIIllIIIllI = this.pool.getUtf8Info(this.typeIndex);
        if (this.members == null) {
            llllllllllllllllIllllIIIllIIIlII.annotation(llllllllllllllllIllllIIIllIIIllI, 0);
            return;
        }
        llllllllllllllllIllllIIIllIIIlII.annotation(llllllllllllllllIllllIIIllIIIllI, this.members.size());
        for (final Pair llllllllllllllllIllllIIIllIIlIll : this.members.values()) {
            llllllllllllllllIllllIIIllIIIlII.memberValuePair(llllllllllllllllIllllIIIllIIlIll.name);
            llllllllllllllllIllllIIIllIIlIll.value.write(llllllllllllllllIllllIIIllIIIlII);
        }
    }
    
    static class Pair
    {
        /* synthetic */ int name;
        /* synthetic */ MemberValue value;
    }
}
