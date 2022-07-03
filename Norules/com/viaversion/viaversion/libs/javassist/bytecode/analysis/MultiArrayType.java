package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import com.viaversion.viaversion.libs.javassist.*;

public class MultiArrayType extends Type
{
    private /* synthetic */ MultiType component;
    private /* synthetic */ int dims;
    
    @Override
    boolean popChanged() {
        return this.component.popChanged();
    }
    
    @Override
    public int getSize() {
        return 1;
    }
    
    @Override
    public boolean isReference() {
        return true;
    }
    
    @Override
    public boolean isAssignableFrom(final Type llllIlIIllIIIlI) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Override
    public String toString() {
        return this.arrayName(this.component.toString(), this.dims);
    }
    
    public MultiArrayType(final MultiType llllIlIlIlIIIII, final int llllIlIlIIllIll) {
        super(null);
        this.component = llllIlIlIlIIIII;
        this.dims = llllIlIlIIllIll;
    }
    
    @Override
    public boolean equals(final Object llllIlIIIlllIII) {
        if (!(llllIlIIIlllIII instanceof MultiArrayType)) {
            return false;
        }
        final MultiArrayType llllIlIIIllIlll = (MultiArrayType)llllIlIIIlllIII;
        return this.component.equals(llllIlIIIllIlll.component) && this.dims == llllIlIIIllIlll.dims;
    }
    
    public boolean isAssignableTo(final Type llllIlIIlIIIIlI) {
        if (Type.eq(llllIlIIlIIIIlI.getCtClass(), Type.OBJECT.getCtClass())) {
            return true;
        }
        if (Type.eq(llllIlIIlIIIIlI.getCtClass(), Type.CLONEABLE.getCtClass())) {
            return true;
        }
        if (Type.eq(llllIlIIlIIIIlI.getCtClass(), Type.SERIALIZABLE.getCtClass())) {
            return true;
        }
        if (!llllIlIIlIIIIlI.isArray()) {
            return false;
        }
        final Type llllIlIIlIIIlIl = this.getRootComponent(llllIlIIlIIIIlI);
        final int llllIlIIlIIIlII = llllIlIIlIIIIlI.getDimensions();
        if (llllIlIIlIIIlII > this.dims) {
            return false;
        }
        if (llllIlIIlIIIlII < this.dims) {
            return Type.eq(llllIlIIlIIIlIl.getCtClass(), Type.OBJECT.getCtClass()) || Type.eq(llllIlIIlIIIlIl.getCtClass(), Type.CLONEABLE.getCtClass()) || Type.eq(llllIlIIlIIIlIl.getCtClass(), Type.SERIALIZABLE.getCtClass());
        }
        return this.component.isAssignableTo(llllIlIIlIIIlIl);
    }
    
    @Override
    public Type getComponent() {
        return (this.dims == 1) ? this.component : new MultiArrayType(this.component, this.dims - 1);
    }
    
    @Override
    public CtClass getCtClass() {
        final CtClass llllIlIlIIIIlII = this.component.getCtClass();
        if (llllIlIlIIIIlII == null) {
            return null;
        }
        ClassPool llllIlIlIIIIIll = llllIlIlIIIIlII.getClassPool();
        if (llllIlIlIIIIIll == null) {
            llllIlIlIIIIIll = ClassPool.getDefault();
        }
        final String llllIlIlIIIIIlI = this.arrayName(llllIlIlIIIIlII.getName(), this.dims);
        try {
            return llllIlIlIIIIIll.get(llllIlIlIIIIIlI);
        }
        catch (NotFoundException llllIlIlIIIIllI) {
            throw new RuntimeException(llllIlIlIIIIllI);
        }
    }
    
    @Override
    public boolean isArray() {
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.component.hashCode() + this.dims;
    }
    
    @Override
    public int getDimensions() {
        return this.dims;
    }
}
