package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class ClassMemberValue extends MemberValue
{
    /* synthetic */ int valueIndex;
    
    public ClassMemberValue(final String llllllllllllllIllllIlIllIlllIIIl, final ConstPool llllllllllllllIllllIlIllIllIllIl) {
        super('c', llllllllllllllIllllIlIllIllIllIl);
        this.setValue(llllllllllllllIllllIlIllIlllIIIl);
    }
    
    public void setValue(final String llllllllllllllIllllIlIllIlIIlIlI) {
        final String llllllllllllllIllllIlIllIlIIlIIl = Descriptor.of(llllllllllllllIllllIlIllIlIIlIlI);
        this.valueIndex = this.cp.addUtf8Info(llllllllllllllIllllIlIllIlIIlIIl);
    }
    
    public ClassMemberValue(final ConstPool llllllllllllllIllllIlIllIllIIlll) {
        super('c', llllllllllllllIllllIlIllIllIIlll);
        this.setValue("java.lang.Class");
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.getValue().replace('$', '.')).append(".class"));
    }
    
    @Override
    Object getValue(final ClassLoader llllllllllllllIllllIlIllIlIlllIl, final ClassPool llllllllllllllIllllIlIllIllIIIIl, final Method llllllllllllllIllllIlIllIllIIIII) throws ClassNotFoundException {
        final String llllllllllllllIllllIlIllIlIlllll = this.getValue();
        if (llllllllllllllIllllIlIllIlIlllll.equals("void")) {
            return Void.TYPE;
        }
        if (llllllllllllllIllllIlIllIlIlllll.equals("int")) {
            return Integer.TYPE;
        }
        if (llllllllllllllIllllIlIllIlIlllll.equals("byte")) {
            return Byte.TYPE;
        }
        if (llllllllllllllIllllIlIllIlIlllll.equals("long")) {
            return Long.TYPE;
        }
        if (llllllllllllllIllllIlIllIlIlllll.equals("double")) {
            return Double.TYPE;
        }
        if (llllllllllllllIllllIlIllIlIlllll.equals("float")) {
            return Float.TYPE;
        }
        if (llllllllllllllIllllIlIllIlIlllll.equals("char")) {
            return Character.TYPE;
        }
        if (llllllllllllllIllllIlIllIlIlllll.equals("short")) {
            return Short.TYPE;
        }
        if (llllllllllllllIllllIlIllIlIlllll.equals("boolean")) {
            return Boolean.TYPE;
        }
        return MemberValue.loadClass(llllllllllllllIllllIlIllIlIlllIl, llllllllllllllIllllIlIllIlIlllll);
    }
    
    @Override
    public void write(final AnnotationsWriter llllllllllllllIllllIlIllIIllllll) throws IOException {
        llllllllllllllIllllIlIllIIllllll.classInfoIndex(this.cp.getUtf8Info(this.valueIndex));
    }
    
    @Override
    Class<?> getType(final ClassLoader llllllllllllllIllllIlIllIlIllIII) throws ClassNotFoundException {
        return MemberValue.loadClass(llllllllllllllIllllIlIllIlIllIII, "java.lang.Class");
    }
    
    public String getValue() {
        final String llllllllllllllIllllIlIllIlIlIIlI = this.cp.getUtf8Info(this.valueIndex);
        try {
            return SignatureAttribute.toTypeSignature(llllllllllllllIllllIlIllIlIlIIlI).jvmTypeName();
        }
        catch (BadBytecode llllllllllllllIllllIlIllIlIlIlII) {
            throw new RuntimeException(llllllllllllllIllllIlIllIlIlIlII);
        }
    }
    
    public ClassMemberValue(final int llllllllllllllIllllIlIllIllllIlI, final ConstPool llllllllllllllIllllIlIllIlllIllI) {
        super('c', llllllllllllllIllllIlIllIlllIllI);
        this.valueIndex = llllllllllllllIllllIlIllIllllIlI;
    }
    
    @Override
    public void accept(final MemberValueVisitor llllllllllllllIllllIlIllIIlllIIl) {
        llllllllllllllIllllIlIllIIlllIIl.visitClassMemberValue(this);
    }
}
