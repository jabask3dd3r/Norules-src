package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public abstract class Transformer implements Opcode
{
    private /* synthetic */ Transformer next;
    
    public void initialize(final ConstPool llllllllllllllIllIIllIIlllIllIIl, final CodeAttribute llllllllllllllIllIIllIIlllIllIII) {
    }
    
    public Transformer(final Transformer llllllllllllllIllIIllIIllllIIIII) {
        this.next = llllllllllllllIllIIllIIllllIIIII;
    }
    
    public int extraLocals() {
        return 0;
    }
    
    public void initialize(final ConstPool llllllllllllllIllIIllIIlllIIllll, final CtClass llllllllllllllIllIIllIIlllIlIIlI, final MethodInfo llllllllllllllIllIIllIIlllIIlllI) throws CannotCompileException {
        this.initialize(llllllllllllllIllIIllIIlllIIllll, llllllllllllllIllIIllIIlllIIlllI.getCodeAttribute());
    }
    
    public void clean() {
    }
    
    public abstract int transform(final CtClass p0, final int p1, final CodeIterator p2, final ConstPool p3) throws CannotCompileException, BadBytecode;
    
    public int extraStack() {
        return 0;
    }
    
    public Transformer getNext() {
        return this.next;
    }
}
