package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Member extends Symbol
{
    private /* synthetic */ CtField field;
    
    @Override
    public void accept(final Visitor lllllllllllllllllIIIlIIllIlIIlll) throws CompileError {
        lllllllllllllllllIIIlIIllIlIIlll.atMember(this);
    }
    
    public Member(final String lllllllllllllllllIIIlIIllIllIlll) {
        super(lllllllllllllllllIIIlIIllIllIlll);
        this.field = null;
    }
    
    public void setField(final CtField lllllllllllllllllIIIlIIllIllIIIl) {
        this.field = lllllllllllllllllIIIlIIllIllIIIl;
    }
    
    public CtField getField() {
        return this.field;
    }
}
