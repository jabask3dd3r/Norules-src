package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;

public class DoubleMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    @Override
    public String toString() {
        return Double.toString(this.getValue());
    }
    
    @Override
    public void accept(final MemberValueVisitor llIlllIIIIIIlI) {
        llIlllIIIIIIlI.visitDoubleMemberValue(this);
    }
    
    public DoubleMemberValue(final int llIlllIIllIIll, final ConstPool llIlllIIllIIlI) {
        super('D', llIlllIIllIIlI);
        this.valueIndex = llIlllIIllIIll;
    }
    
    public void setValue(final double llIlllIIIlIIIl) {
        this.valueIndex = this.cp.addDoubleInfo(llIlllIIIlIIIl);
    }
    
    @Override
    public void write(final AnnotationsWriter llIlllIIIIlIII) throws IOException {
        llIlllIIIIlIII.constValueIndex(this.getValue());
    }
    
    public DoubleMemberValue(final ConstPool llIlllIIlIIIlI) {
        super('D', llIlllIIlIIIlI);
        this.setValue(0.0);
    }
    
    @Override
    Object getValue(final ClassLoader llIlllIIIlllIl, final ClassPool llIlllIIIlllII, final Method llIlllIIIllIll) {
        return this.getValue();
    }
    
    public DoubleMemberValue(final double llIlllIIlIlIlI, final ConstPool llIlllIIlIlIIl) {
        super('D', llIlllIIlIlIIl);
        this.setValue(llIlllIIlIlIlI);
    }
    
    public double getValue() {
        return this.cp.getDoubleInfo(this.valueIndex);
    }
    
    @Override
    Class<?> getType(final ClassLoader llIlllIIIllIII) {
        return Double.TYPE;
    }
}
