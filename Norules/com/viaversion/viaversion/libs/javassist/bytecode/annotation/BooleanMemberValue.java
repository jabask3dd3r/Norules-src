package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;

public class BooleanMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    @Override
    public void accept(final MemberValueVisitor llllllllllllllIllIIlIIlIllllIlIl) {
        llllllllllllllIllIIlIIlIllllIlIl.visitBooleanMemberValue(this);
    }
    
    public BooleanMemberValue(final ConstPool llllllllllllllIllIIlIIllIIIlIlIl) {
        super('Z', llllllllllllllIllIIlIIllIIIlIlIl);
        this.setValue(false);
    }
    
    public BooleanMemberValue(final int llllllllllllllIllIIlIIllIIlIIllI, final ConstPool llllllllllllllIllIIlIIllIIlIlIIl) {
        super('Z', llllllllllllllIllIIlIIllIIlIlIIl);
        this.valueIndex = llllllllllllllIllIIlIIllIIlIIllI;
    }
    
    public void setValue(final boolean llllllllllllllIllIIlIIllIIIIIIlI) {
        this.valueIndex = this.cp.addIntegerInfo(llllllllllllllIllIIlIIllIIIIIIlI ? 1 : 0);
    }
    
    @Override
    public String toString() {
        return this.getValue() ? "true" : "false";
    }
    
    @Override
    public void write(final AnnotationsWriter llllllllllllllIllIIlIIlIlllllIll) throws IOException {
        llllllllllllllIllIIlIIlIlllllIll.constValueIndex(this.getValue());
    }
    
    @Override
    Class<?> getType(final ClassLoader llllllllllllllIllIIlIIllIIIIlIll) {
        return Boolean.TYPE;
    }
    
    public BooleanMemberValue(final boolean llllllllllllllIllIIlIIllIIIlllIl, final ConstPool llllllllllllllIllIIlIIllIIIlllII) {
        super('Z', llllllllllllllIllIIlIIllIIIlllII);
        this.setValue(llllllllllllllIllIIlIIllIIIlllIl);
    }
    
    @Override
    Object getValue(final ClassLoader llllllllllllllIllIIlIIllIIIlIIII, final ClassPool llllllllllllllIllIIlIIllIIIIllll, final Method llllllllllllllIllIIlIIllIIIIlllI) {
        return this.getValue();
    }
    
    public boolean getValue() {
        return this.cp.getIntegerInfo(this.valueIndex) != 0;
    }
}
