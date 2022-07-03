package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import java.io.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class ByteMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    @Override
    public void write(final AnnotationsWriter lllllllllllllIlIlllIlIIIIlllllll) throws IOException {
        lllllllllllllIlIlllIlIIIIlllllll.constValueIndex(this.getValue());
    }
    
    @Override
    public void accept(final MemberValueVisitor lllllllllllllIlIlllIlIIIIllllIll) {
        lllllllllllllIlIlllIlIIIIllllIll.visitByteMemberValue(this);
    }
    
    public byte getValue() {
        return (byte)this.cp.getIntegerInfo(this.valueIndex);
    }
    
    public void setValue(final byte lllllllllllllIlIlllIlIIIlIIIlIII) {
        this.valueIndex = this.cp.addIntegerInfo(lllllllllllllIlIlllIlIIIlIIIlIII);
    }
    
    @Override
    public String toString() {
        return Byte.toString(this.getValue());
    }
    
    @Override
    Object getValue(final ClassLoader lllllllllllllIlIlllIlIIIlIIlIllI, final ClassPool lllllllllllllIlIlllIlIIIlIIlIlIl, final Method lllllllllllllIlIlllIlIIIlIIlIlII) {
        return this.getValue();
    }
    
    public ByteMemberValue(final int lllllllllllllIlIlllIlIIIlIlIlIIl, final ConstPool lllllllllllllIlIlllIlIIIlIlIlIll) {
        super('B', lllllllllllllIlIlllIlIIIlIlIlIll);
        this.valueIndex = lllllllllllllIlIlllIlIIIlIlIlIIl;
    }
    
    public ByteMemberValue(final byte lllllllllllllIlIlllIlIIIlIlIIIll, final ConstPool lllllllllllllIlIlllIlIIIlIIlllll) {
        super('B', lllllllllllllIlIlllIlIIIlIIlllll);
        this.setValue(lllllllllllllIlIlllIlIIIlIlIIIll);
    }
    
    @Override
    Class<?> getType(final ClassLoader lllllllllllllIlIlllIlIIIlIIlIIIl) {
        return Byte.TYPE;
    }
    
    public ByteMemberValue(final ConstPool lllllllllllllIlIlllIlIIIlIIllIIl) {
        super('B', lllllllllllllIlIlllIlIIIlIIllIIl);
        this.setValue((byte)0);
    }
}
