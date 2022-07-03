package com.viaversion.viaversion.libs.javassist;

public final class CtPrimitiveType extends CtClass
{
    private /* synthetic */ String mDescriptor;
    private /* synthetic */ int arrayType;
    private /* synthetic */ int dataSize;
    private /* synthetic */ String wrapperName;
    private /* synthetic */ String getMethodName;
    private /* synthetic */ int returnOp;
    private /* synthetic */ char descriptor;
    
    public int getReturnOp() {
        return this.returnOp;
    }
    
    public int getDataSize() {
        return this.dataSize;
    }
    
    @Override
    public int getModifiers() {
        return 17;
    }
    
    public int getArrayType() {
        return this.arrayType;
    }
    
    public String getWrapperName() {
        return this.wrapperName;
    }
    
    public String getGetMethodName() {
        return this.getMethodName;
    }
    
    CtPrimitiveType(final String llllllllllllllIIlIlIlIIlIIlIlIll, final char llllllllllllllIIlIlIlIIlIIlIIIIl, final String llllllllllllllIIlIlIlIIlIIlIlIIl, final String llllllllllllllIIlIlIlIIlIIlIlIII, final String llllllllllllllIIlIlIlIIlIIlIIlll, final int llllllllllllllIIlIlIlIIlIIlIIllI, final int llllllllllllllIIlIlIlIIlIIlIIlIl, final int llllllllllllllIIlIlIlIIlIIIllIll) {
        super(llllllllllllllIIlIlIlIIlIIlIlIll);
        this.descriptor = llllllllllllllIIlIlIlIIlIIlIIIIl;
        this.wrapperName = llllllllllllllIIlIlIlIIlIIlIlIIl;
        this.getMethodName = llllllllllllllIIlIlIlIIlIIlIlIII;
        this.mDescriptor = llllllllllllllIIlIlIlIIlIIlIIlll;
        this.returnOp = llllllllllllllIIlIlIlIIlIIlIIllI;
        this.arrayType = llllllllllllllIIlIlIlIIlIIlIIlIl;
        this.dataSize = llllllllllllllIIlIlIlIIlIIIllIll;
    }
    
    public String getGetMethodDescriptor() {
        return this.mDescriptor;
    }
    
    public char getDescriptor() {
        return this.descriptor;
    }
    
    @Override
    public boolean isPrimitive() {
        return true;
    }
}
