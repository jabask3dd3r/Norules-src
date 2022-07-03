package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class InstanceOfExpr extends CastExpr
{
    public InstanceOfExpr(final int lllllllllllllIlllIIllIlllIIlllIl, final int lllllllllllllIlllIIllIlllIIlllII, final ASTree lllllllllllllIlllIIllIlllIIllIll) {
        super(lllllllllllllIlllIIllIlllIIlllIl, lllllllllllllIlllIIllIlllIIlllII, lllllllllllllIlllIIllIlllIIllIll);
    }
    
    @Override
    public String getTag() {
        return String.valueOf(new StringBuilder().append("instanceof:").append(this.castType).append(":").append(this.arrayDim));
    }
    
    public InstanceOfExpr(final ASTList lllllllllllllIlllIIllIlllIlIllIl, final int lllllllllllllIlllIIllIlllIlIllII, final ASTree lllllllllllllIlllIIllIlllIlIIlll) {
        super(lllllllllllllIlllIIllIlllIlIllIl, lllllllllllllIlllIIllIlllIlIllII, lllllllllllllIlllIIllIlllIlIIlll);
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIlllIIllIlllIIlIlII) throws CompileError {
        lllllllllllllIlllIIllIlllIIlIlII.atInstanceOfExpr(this);
    }
}
