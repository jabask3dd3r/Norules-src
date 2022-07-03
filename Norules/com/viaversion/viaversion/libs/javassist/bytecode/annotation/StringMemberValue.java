package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import java.io.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;

public class StringMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    public void setValue(final String lllllllllllllIlIIllllllllIlIlIlI) {
        this.valueIndex = this.cp.addUtf8Info(lllllllllllllIlIIllllllllIlIlIlI);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("\"").append(this.getValue()).append("\""));
    }
    
    @Override
    public void write(final AnnotationsWriter lllllllllllllIlIIllllllllIlIIIIl) throws IOException {
        lllllllllllllIlIIllllllllIlIIIIl.constValueIndex(this.getValue());
    }
    
    @Override
    public void accept(final MemberValueVisitor lllllllllllllIlIIllllllllIIllIll) {
        lllllllllllllIlIIllllllllIIllIll.visitStringMemberValue(this);
    }
    
    @Override
    Class<?> getType(final ClassLoader lllllllllllllIlIIllllllllIllIIIl) {
        return String.class;
    }
    
    public String getValue() {
        return this.cp.getUtf8Info(this.valueIndex);
    }
    
    public StringMemberValue(final int lllllllllllllIlIIlllllllllIIllII, final ConstPool lllllllllllllIlIIlllllllllIIlIll) {
        super('s', lllllllllllllIlIIlllllllllIIlIll);
        this.valueIndex = lllllllllllllIlIIlllllllllIIllII;
    }
    
    public StringMemberValue(final ConstPool lllllllllllllIlIIllllllllIlllIIl) {
        super('s', lllllllllllllIlIIllllllllIlllIIl);
        this.setValue("");
    }
    
    @Override
    Object getValue(final ClassLoader lllllllllllllIlIIllllllllIllIllI, final ClassPool lllllllllllllIlIIllllllllIllIlIl, final Method lllllllllllllIlIIllllllllIllIlII) {
        return this.getValue();
    }
    
    public StringMemberValue(final String lllllllllllllIlIIlllllllllIIIIII, final ConstPool lllllllllllllIlIIlllllllllIIIIlI) {
        super('s', lllllllllllllIlIIlllllllllIIIIlI);
        this.setValue(lllllllllllllIlIIlllllllllIIIIII);
    }
}
