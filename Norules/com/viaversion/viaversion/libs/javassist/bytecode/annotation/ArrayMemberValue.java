package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;

public class ArrayMemberValue extends MemberValue
{
    /* synthetic */ MemberValue type;
    /* synthetic */ MemberValue[] values;
    
    public MemberValue getType() {
        return this.type;
    }
    
    @Override
    Class<?> getType(final ClassLoader lllllllllllllIlllIlIIlIIlIIIllll) throws ClassNotFoundException {
        if (this.type == null) {
            throw new ClassNotFoundException("no array type specified");
        }
        final Object lllllllllllllIlllIlIIlIIlIIIlllI = Array.newInstance(this.type.getType(lllllllllllllIlllIlIIlIIlIIIllll), 0);
        return lllllllllllllIlllIlIIlIIlIIIlllI.getClass();
    }
    
    public MemberValue[] getValue() {
        return this.values;
    }
    
    @Override
    public void accept(final MemberValueVisitor lllllllllllllIlllIlIIlIIIllIIllI) {
        lllllllllllllIlllIlIIlIIIllIIllI.visitArrayMemberValue(this);
    }
    
    @Override
    Object getValue(final ClassLoader lllllllllllllIlllIlIIlIIlIIllIlI, final ClassPool lllllllllllllIlllIlIIlIIlIIllIIl, final Method lllllllllllllIlllIlIIlIIlIIllIII) throws ClassNotFoundException {
        if (this.values == null) {
            throw new ClassNotFoundException(String.valueOf(new StringBuilder().append("no array elements found: ").append(lllllllllllllIlllIlIIlIIlIIllIII.getName())));
        }
        final int lllllllllllllIlllIlIIlIIlIIllllI = this.values.length;
        Class<?> lllllllllllllIlllIlIIlIIlIIlllIl = null;
        if (this.type == null) {
            final Class<?> lllllllllllllIlllIlIIlIIlIlIIlII = lllllllllllllIlllIlIIlIIlIIllIII.getReturnType().getComponentType();
            if (lllllllllllllIlllIlIIlIIlIlIIlII == null || lllllllllllllIlllIlIIlIIlIIllllI > 0) {
                throw new ClassNotFoundException(String.valueOf(new StringBuilder().append("broken array type: ").append(lllllllllllllIlllIlIIlIIlIIllIII.getName())));
            }
        }
        else {
            lllllllllllllIlllIlIIlIIlIIlllIl = this.type.getType(lllllllllllllIlllIlIIlIIlIIllIlI);
        }
        final Object lllllllllllllIlllIlIIlIIlIIlllII = Array.newInstance(lllllllllllllIlllIlIIlIIlIIlllIl, lllllllllllllIlllIlIIlIIlIIllllI);
        for (int lllllllllllllIlllIlIIlIIlIlIIIll = 0; lllllllllllllIlllIlIIlIIlIlIIIll < lllllllllllllIlllIlIIlIIlIIllllI; ++lllllllllllllIlllIlIIlIIlIlIIIll) {
            Array.set(lllllllllllllIlllIlIIlIIlIIlllII, lllllllllllllIlllIlIIlIIlIlIIIll, this.values[lllllllllllllIlllIlIIlIIlIlIIIll].getValue(lllllllllllllIlllIlIIlIIlIIllIlI, lllllllllllllIlllIlIIlIIlIIllIIl, lllllllllllllIlllIlIIlIIlIIllIII));
        }
        return lllllllllllllIlllIlIIlIIlIIlllII;
    }
    
    public ArrayMemberValue(final MemberValue lllllllllllllIlllIlIIlIIlIlIlllI, final ConstPool lllllllllllllIlllIlIIlIIlIlIllIl) {
        super('[', lllllllllllllIlllIlIIlIIlIlIllIl);
        this.type = lllllllllllllIlllIlIIlIIlIlIlllI;
        this.values = null;
    }
    
    public ArrayMemberValue(final ConstPool lllllllllllllIlllIlIIlIIlIlllIII) {
        super('[', lllllllllllllIlllIlIIlIIlIlllIII);
        this.type = null;
        this.values = null;
    }
    
    public void setValue(final MemberValue[] lllllllllllllIlllIlIIlIIlIIIIIIl) {
        this.values = lllllllllllllIlllIlIIlIIlIIIIIIl;
        if (lllllllllllllIlllIlIIlIIlIIIIIIl != null && lllllllllllllIlllIlIIlIIlIIIIIIl.length > 0) {
            this.type = lllllllllllllIlllIlIIlIIlIIIIIIl[0];
        }
    }
    
    @Override
    public void write(final AnnotationsWriter lllllllllllllIlllIlIIlIIIllIllII) throws IOException {
        final int lllllllllllllIlllIlIIlIIIllIlllI = (this.values == null) ? 0 : this.values.length;
        lllllllllllllIlllIlIIlIIIllIllII.arrayValue(lllllllllllllIlllIlIIlIIIllIlllI);
        for (int lllllllllllllIlllIlIIlIIIlllIIIl = 0; lllllllllllllIlllIlIIlIIIlllIIIl < lllllllllllllIlllIlIIlIIIllIlllI; ++lllllllllllllIlllIlIIlIIIlllIIIl) {
            this.values[lllllllllllllIlllIlIIlIIIlllIIIl].write(lllllllllllllIlllIlIIlIIIllIllII);
        }
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIlllIlIIlIIIllllIIl = new StringBuffer("{");
        if (this.values != null) {
            for (int lllllllllllllIlllIlIIlIIIllllIll = 0; lllllllllllllIlllIlIIlIIIllllIll < this.values.length; ++lllllllllllllIlllIlIIlIIIllllIll) {
                lllllllllllllIlllIlIIlIIIllllIIl.append(this.values[lllllllllllllIlllIlIIlIIIllllIll].toString());
                if (lllllllllllllIlllIlIIlIIIllllIll + 1 < this.values.length) {
                    lllllllllllllIlllIlIIlIIIllllIIl.append(", ");
                }
            }
        }
        lllllllllllllIlllIlIIlIIIllllIIl.append("}");
        return lllllllllllllIlllIlIIlIIIllllIIl.toString();
    }
}
