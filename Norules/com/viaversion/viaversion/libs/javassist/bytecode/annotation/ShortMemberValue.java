package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;

public class ShortMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    @Override
    public String toString() {
        return Short.toString(this.getValue());
    }
    
    public ShortMemberValue(final int lllllllllllllIllIIllllIIIIIlllII, final ConstPool lllllllllllllIllIIllllIIIIIllIll) {
        super('S', lllllllllllllIllIIllllIIIIIllIll);
        this.valueIndex = lllllllllllllIllIIllllIIIIIlllII;
    }
    
    @Override
    public void write(final AnnotationsWriter lllllllllllllIllIIlllIllllllIlII) throws IOException {
        lllllllllllllIllIIlllIllllllIlII.constValueIndex(this.getValue());
    }
    
    @Override
    public void accept(final MemberValueVisitor lllllllllllllIllIIlllIlllllIllII) {
        lllllllllllllIllIIlllIlllllIllII.visitShortMemberValue(this);
    }
    
    @Override
    Class<?> getType(final ClassLoader lllllllllllllIllIIllllIIIIIIIlII) {
        return Short.TYPE;
    }
    
    @Override
    Object getValue(final ClassLoader lllllllllllllIllIIllllIIIIIIlIIl, final ClassPool lllllllllllllIllIIllllIIIIIIlIII, final Method lllllllllllllIllIIllllIIIIIIIlll) {
        return this.getValue();
    }
    
    public ShortMemberValue(final ConstPool lllllllllllllIllIIllllIIIIIIlllI) {
        super('S', lllllllllllllIllIIllllIIIIIIlllI);
        this.setValue((short)0);
    }
    
    public void setValue(final short lllllllllllllIllIIlllIlllllllIll) {
        this.valueIndex = this.cp.addIntegerInfo(lllllllllllllIllIIlllIlllllllIll);
    }
    
    public ShortMemberValue(final short lllllllllllllIllIIllllIIIIIlIIll, final ConstPool lllllllllllllIllIIllllIIIIIlIIlI) {
        super('S', lllllllllllllIllIIllllIIIIIlIIlI);
        this.setValue(lllllllllllllIllIIllllIIIIIlIIll);
    }
    
    public short getValue() {
        return (short)this.cp.getIntegerInfo(this.valueIndex);
    }
}
