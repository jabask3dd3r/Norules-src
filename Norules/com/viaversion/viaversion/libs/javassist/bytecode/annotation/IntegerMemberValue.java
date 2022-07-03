package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;

public class IntegerMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    @Override
    public void accept(final MemberValueVisitor llllllllllllllIlIlIIIllIlIlIlllI) {
        llllllllllllllIlIlIIIllIlIlIlllI.visitIntegerMemberValue(this);
    }
    
    public int getValue() {
        return this.cp.getIntegerInfo(this.valueIndex);
    }
    
    public IntegerMemberValue(final ConstPool llllllllllllllIlIlIIIllIllIIllII) {
        super('I', llllllllllllllIlIlIIIllIllIIllII);
        this.setValue(0);
    }
    
    @Override
    public void write(final AnnotationsWriter llllllllllllllIlIlIIIllIlIllIIlI) throws IOException {
        llllllllllllllIlIlIIIllIlIllIIlI.constValueIndex(this.getValue());
    }
    
    @Override
    Object getValue(final ClassLoader llllllllllllllIlIlIIIllIllIIlIIl, final ClassPool llllllllllllllIlIlIIIllIllIIlIII, final Method llllllllllllllIlIlIIIllIllIIIlll) {
        return this.getValue();
    }
    
    @Override
    Class<?> getType(final ClassLoader llllllllllllllIlIlIIIllIllIIIlII) {
        return Integer.TYPE;
    }
    
    public IntegerMemberValue(final int llllllllllllllIlIlIIIllIllIlllll, final ConstPool llllllllllllllIlIlIIIllIllIllllI) {
        super('I', llllllllllllllIlIlIIIllIllIllllI);
        this.valueIndex = llllllllllllllIlIlIIIllIllIlllll;
    }
    
    public void setValue(final int llllllllllllllIlIlIIIllIlIllllIl) {
        this.valueIndex = this.cp.addIntegerInfo(llllllllllllllIlIlIIIllIlIllllIl);
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.getValue());
    }
    
    public IntegerMemberValue(final ConstPool llllllllllllllIlIlIIIllIllIlIIll, final int llllllllllllllIlIlIIIllIllIlIlIl) {
        super('I', llllllllllllllIlIlIIIllIllIlIIll);
        this.setValue(llllllllllllllIlIlIIIllIllIlIlIl);
    }
}
