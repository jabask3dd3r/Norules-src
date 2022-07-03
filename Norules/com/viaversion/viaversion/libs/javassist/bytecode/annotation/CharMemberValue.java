package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;

public class CharMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    public char getValue() {
        return (char)this.cp.getIntegerInfo(this.valueIndex);
    }
    
    @Override
    Class<?> getType(final ClassLoader lllllllllllllllIlIIllIllIIIIIlIl) {
        return Character.TYPE;
    }
    
    public CharMemberValue(final char lllllllllllllllIlIIllIllIIlIIlII, final ConstPool lllllllllllllllIlIIllIllIIlIIIll) {
        super('C', lllllllllllllllIlIIllIllIIlIIIll);
        this.setValue(lllllllllllllllIlIIllIllIIlIIlII);
    }
    
    public CharMemberValue(final ConstPool lllllllllllllllIlIIllIllIIIlIlll) {
        super('C', lllllllllllllllIlIIllIllIIIlIlll);
        this.setValue('\0');
    }
    
    @Override
    public void write(final AnnotationsWriter lllllllllllllllIlIIllIlIllllIIlI) throws IOException {
        lllllllllllllllIlIIllIlIllllIIlI.constValueIndex(this.getValue());
    }
    
    @Override
    public void accept(final MemberValueVisitor lllllllllllllllIlIIllIlIlllIlllI) {
        lllllllllllllllIlIIllIlIlllIlllI.visitCharMemberValue(this);
    }
    
    public void setValue(final char lllllllllllllllIlIIllIlIlllllIll) {
        this.valueIndex = this.cp.addIntegerInfo(lllllllllllllllIlIIllIlIlllllIll);
    }
    
    public CharMemberValue(final int lllllllllllllllIlIIllIllIIllIllI, final ConstPool lllllllllllllllIlIIllIllIIllIlII) {
        super('C', lllllllllllllllIlIIllIllIIllIlII);
        this.valueIndex = lllllllllllllllIlIIllIllIIllIllI;
    }
    
    @Override
    public String toString() {
        return Character.toString(this.getValue());
    }
    
    @Override
    Object getValue(final ClassLoader lllllllllllllllIlIIllIllIIIIlIll, final ClassPool lllllllllllllllIlIIllIllIIIIlIlI, final Method lllllllllllllllIlIIllIllIIIIlIIl) {
        return this.getValue();
    }
}
