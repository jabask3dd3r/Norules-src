package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;
import java.io.*;

public class LongMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    public void setValue(final long lllllllllllllIlIIIIIIlIlllIIIIll) {
        this.valueIndex = this.cp.addLongInfo(lllllllllllllIlIIIIIIlIlllIIIIll);
    }
    
    public LongMemberValue(final int lllllllllllllIlIIIIIIlIllllIIlll, final ConstPool lllllllllllllIlIIIIIIlIllllIIIll) {
        super('J', lllllllllllllIlIIIIIIlIllllIIIll);
        this.valueIndex = lllllllllllllIlIIIIIIlIllllIIlll;
    }
    
    @Override
    Object getValue(final ClassLoader lllllllllllllIlIIIIIIlIlllIlIIIl, final ClassPool lllllllllllllIlIIIIIIlIlllIlIIII, final Method lllllllllllllIlIIIIIIlIlllIIllll) {
        return this.getValue();
    }
    
    public long getValue() {
        return this.cp.getLongInfo(this.valueIndex);
    }
    
    @Override
    public String toString() {
        return Long.toString(this.getValue());
    }
    
    public LongMemberValue(final ConstPool lllllllllllllIlIIIIIIlIlllIlIllI) {
        super('J', lllllllllllllIlIIIIIIlIlllIlIllI);
        this.setValue(0L);
    }
    
    public LongMemberValue(final long lllllllllllllIlIIIIIIlIlllIllllI, final ConstPool lllllllllllllIlIIIIIIlIlllIllIlI) {
        super('J', lllllllllllllIlIIIIIIlIlllIllIlI);
        this.setValue(lllllllllllllIlIIIIIIlIlllIllllI);
    }
    
    @Override
    public void accept(final MemberValueVisitor lllllllllllllIlIIIIIIlIllIllIllI) {
        lllllllllllllIlIIIIIIlIllIllIllI.visitLongMemberValue(this);
    }
    
    @Override
    Class<?> getType(final ClassLoader lllllllllllllIlIIIIIIlIlllIIllII) {
        return Long.TYPE;
    }
    
    @Override
    public void write(final AnnotationsWriter lllllllllllllIlIIIIIIlIllIllllII) throws IOException {
        lllllllllllllIlIIIIIIlIllIllllII.constValueIndex(this.getValue());
    }
}
