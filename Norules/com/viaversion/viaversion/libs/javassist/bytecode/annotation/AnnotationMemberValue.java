package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class AnnotationMemberValue extends MemberValue
{
    /* synthetic */ Annotation value;
    
    @Override
    Object getValue(final ClassLoader lllllllllllllIIIlIIllIllIlllIIII, final ClassPool lllllllllllllIIIlIIllIllIllIllll, final Method lllllllllllllIIIlIIllIllIllIlllI) throws ClassNotFoundException {
        return AnnotationImpl.make(lllllllllllllIIIlIIllIllIlllIIII, this.getType(lllllllllllllIIIlIIllIllIlllIIII), lllllllllllllIIIlIIllIllIllIllll, this.value);
    }
    
    @Override
    public String toString() {
        return this.value.toString();
    }
    
    @Override
    Class<?> getType(final ClassLoader lllllllllllllIIIlIIllIllIllIIlIl) throws ClassNotFoundException {
        if (this.value == null) {
            throw new ClassNotFoundException("no type specified");
        }
        return MemberValue.loadClass(lllllllllllllIIIlIIllIllIllIIlIl, this.value.getTypeName());
    }
    
    @Override
    public void write(final AnnotationsWriter lllllllllllllIIIlIIllIllIlIlIlIl) throws IOException {
        lllllllllllllIIIlIIllIllIlIlIlIl.annotationValue();
        this.value.write(lllllllllllllIIIlIIllIllIlIlIlIl);
    }
    
    public AnnotationMemberValue(final Annotation lllllllllllllIIIlIIllIllIlllIllI, final ConstPool lllllllllllllIIIlIIllIllIlllIlIl) {
        super('@', lllllllllllllIIIlIIllIllIlllIlIl);
        this.value = lllllllllllllIIIlIIllIllIlllIllI;
    }
    
    @Override
    public void accept(final MemberValueVisitor lllllllllllllIIIlIIllIllIlIIllIl) {
        lllllllllllllIIIlIIllIllIlIIllIl.visitAnnotationMemberValue(this);
    }
    
    public AnnotationMemberValue(final ConstPool lllllllllllllIIIlIIllIllIllllllI) {
        this(null, lllllllllllllIIIlIIllIllIllllllI);
    }
    
    public Annotation getValue() {
        return this.value;
    }
    
    public void setValue(final Annotation lllllllllllllIIIlIIllIllIlIlllII) {
        this.value = lllllllllllllIIIlIIllIllIlIlllII;
    }
}
