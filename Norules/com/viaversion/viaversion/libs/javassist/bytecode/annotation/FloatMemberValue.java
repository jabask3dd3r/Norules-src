package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import java.io.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class FloatMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    @Override
    public String toString() {
        return Float.toString(this.getValue());
    }
    
    @Override
    public void write(final AnnotationsWriter llllllllllllllIlIlIllIllIIlIllII) throws IOException {
        llllllllllllllIlIlIllIllIIlIllII.constValueIndex(this.getValue());
    }
    
    @Override
    Object getValue(final ClassLoader llllllllllllllIlIlIllIllIlIIIIIl, final ClassPool llllllllllllllIlIlIllIllIlIIIIII, final Method llllllllllllllIlIlIllIllIIllllll) {
        return this.getValue();
    }
    
    public float getValue() {
        return this.cp.getFloatInfo(this.valueIndex);
    }
    
    @Override
    Class<?> getType(final ClassLoader llllllllllllllIlIlIllIllIIllllII) {
        return Float.TYPE;
    }
    
    public FloatMemberValue(final ConstPool llllllllllllllIlIlIllIllIlIIIlII) {
        super('F', llllllllllllllIlIlIllIllIlIIIlII);
        this.setValue(0.0f);
    }
    
    public FloatMemberValue(final int llllllllllllllIlIlIllIllIlIlIlll, final ConstPool llllllllllllllIlIlIllIllIlIlIllI) {
        super('F', llllllllllllllIlIlIllIllIlIlIllI);
        this.valueIndex = llllllllllllllIlIlIllIllIlIlIlll;
    }
    
    public void setValue(final float llllllllllllllIlIlIllIllIIllIIll) {
        this.valueIndex = this.cp.addFloatInfo(llllllllllllllIlIlIllIllIIllIIll);
    }
    
    public FloatMemberValue(final float llllllllllllllIlIlIllIllIlIIlIll, final ConstPool llllllllllllllIlIlIllIllIlIIllIl) {
        super('F', llllllllllllllIlIlIllIllIlIIllIl);
        this.setValue(llllllllllllllIlIlIllIllIlIIlIll);
    }
    
    @Override
    public void accept(final MemberValueVisitor llllllllllllllIlIlIllIllIIlIIlII) {
        llllllllllllllIlIlIllIllIIlIIlII.visitFloatMemberValue(this);
    }
}
