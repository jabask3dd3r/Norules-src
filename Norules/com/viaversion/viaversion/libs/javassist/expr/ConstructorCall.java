package com.viaversion.viaversion.libs.javassist.expr;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;

public class ConstructorCall extends MethodCall
{
    public CtConstructor getConstructor() throws NotFoundException {
        return this.getCtClass().getConstructor(this.getSignature());
    }
    
    protected ConstructorCall(final int llllllllllllllIllIllllIIllIIlIll, final CodeIterator llllllllllllllIllIllllIIllIIlIlI, final CtClass llllllllllllllIllIllllIIllIIIlII, final MethodInfo llllllllllllllIllIllllIIllIIlIII) {
        super(llllllllllllllIllIllllIIllIIlIll, llllllllllllllIllIllllIIllIIlIlI, llllllllllllllIllIllllIIllIIIlII, llllllllllllllIllIllllIIllIIlIII);
    }
    
    @Override
    public boolean isSuper() {
        return super.isSuper();
    }
    
    @Override
    public CtMethod getMethod() throws NotFoundException {
        throw new NotFoundException("this is a constructor call.  Call getConstructor().");
    }
    
    @Override
    public String getMethodName() {
        return this.isSuper() ? "super" : "this";
    }
}
