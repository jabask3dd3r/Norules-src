package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;
import java.io.*;

public class EnumMemberValue extends MemberValue
{
    /* synthetic */ int typeIndex;
    /* synthetic */ int valueIndex;
    
    public void setType(final String lllllllllllllIlIllIlIlIlIIllllIl) {
        this.typeIndex = this.cp.addUtf8Info(Descriptor.of(lllllllllllllIlIllIlIlIlIIllllIl));
    }
    
    @Override
    Class<?> getType(final ClassLoader lllllllllllllIlIllIlIlIlIlIIIllI) throws ClassNotFoundException {
        return MemberValue.loadClass(lllllllllllllIlIllIlIlIlIlIIIllI, this.getType());
    }
    
    public String getType() {
        return Descriptor.toClassName(this.cp.getUtf8Info(this.typeIndex));
    }
    
    public EnumMemberValue(final int lllllllllllllIlIllIlIlIlIllIIlII, final int lllllllllllllIlIllIlIlIlIlIlllll, final ConstPool lllllllllllllIlIllIlIlIlIllIIIlI) {
        super('e', lllllllllllllIlIllIlIlIlIllIIIlI);
        this.typeIndex = lllllllllllllIlIllIlIlIlIllIIlII;
        this.valueIndex = lllllllllllllIlIllIlIlIlIlIlllll;
    }
    
    @Override
    Object getValue(final ClassLoader lllllllllllllIlIllIlIlIlIlIlIIIl, final ClassPool lllllllllllllIlIllIlIlIlIlIlIIII, final Method lllllllllllllIlIllIlIlIlIlIIllll) throws ClassNotFoundException {
        try {
            return this.getType(lllllllllllllIlIllIlIlIlIlIlIIIl).getField(this.getValue()).get(null);
        }
        catch (NoSuchFieldException lllllllllllllIlIllIlIlIlIlIlIlII) {
            throw new ClassNotFoundException(String.valueOf(new StringBuilder().append(this.getType()).append(".").append(this.getValue())));
        }
        catch (IllegalAccessException lllllllllllllIlIllIlIlIlIlIlIIll) {
            throw new ClassNotFoundException(String.valueOf(new StringBuilder().append(this.getType()).append(".").append(this.getValue())));
        }
    }
    
    public String getValue() {
        return this.cp.getUtf8Info(this.valueIndex);
    }
    
    public void setValue(final String lllllllllllllIlIllIlIlIlIIllIlII) {
        this.valueIndex = this.cp.addUtf8Info(lllllllllllllIlIllIlIlIlIIllIlII);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.getType()).append(".").append(this.getValue()));
    }
    
    public EnumMemberValue(final ConstPool lllllllllllllIlIllIlIlIlIlIllIII) {
        super('e', lllllllllllllIlIllIlIlIlIlIllIII);
        final int n = 0;
        this.valueIndex = n;
        this.typeIndex = n;
    }
    
    @Override
    public void write(final AnnotationsWriter lllllllllllllIlIllIlIlIlIIlIllIl) throws IOException {
        lllllllllllllIlIllIlIlIlIIlIllIl.enumConstValue(this.cp.getUtf8Info(this.typeIndex), this.getValue());
    }
    
    @Override
    public void accept(final MemberValueVisitor lllllllllllllIlIllIlIlIlIIlIIlll) {
        lllllllllllllIlIllIlIlIlIIlIIlll.visitEnumMemberValue(this);
    }
}
