package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Stmnt extends ASTList implements TokenId
{
    protected /* synthetic */ int operatorId;
    
    @Override
    protected String getTag() {
        if (this.operatorId < 128) {
            return String.valueOf(new StringBuilder().append("stmnt:").append((char)this.operatorId));
        }
        return String.valueOf(new StringBuilder().append("stmnt:").append(this.operatorId));
    }
    
    public Stmnt(final int lllllllllllllIIIlIIIIllIIIIIlIIl, final ASTree lllllllllllllIIIlIIIIllIIIIIlIll) {
        super(lllllllllllllIIIlIIIIllIIIIIlIll);
        this.operatorId = lllllllllllllIIIlIIIIllIIIIIlIIl;
    }
    
    public static Stmnt make(final int lllllllllllllIIIlIIIIlIllllllIll, final ASTree lllllllllllllIIIlIIIIlIlllllllIl, final ASTree lllllllllllllIIIlIIIIlIllllllIIl) {
        return new Stmnt(lllllllllllllIIIlIIIIlIllllllIll, lllllllllllllIIIlIIIIlIlllllllIl, new ASTList(lllllllllllllIIIlIIIIlIllllllIIl));
    }
    
    public Stmnt(final int lllllllllllllIIIlIIIIllIIIIIIlII) {
        this(lllllllllllllIIIlIIIIllIIIIIIlII, null);
    }
    
    public Stmnt(final int lllllllllllllIIIlIIIIllIIIIlIIll, final ASTree lllllllllllllIIIlIIIIllIIIIlIllI, final ASTList lllllllllllllIIIlIIIIllIIIIlIIIl) {
        super(lllllllllllllIIIlIIIIllIIIIlIllI, lllllllllllllIIIlIIIIllIIIIlIIIl);
        this.operatorId = lllllllllllllIIIlIIIIllIIIIlIIll;
    }
    
    public int getOperator() {
        return this.operatorId;
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIIIlIIIIlIllllIlIIl) throws CompileError {
        lllllllllllllIIIlIIIIlIllllIlIIl.atStmnt(this);
    }
    
    public static Stmnt make(final int lllllllllllllIIIlIIIIlIlllllIIII, final ASTree lllllllllllllIIIlIIIIlIlllllIIll, final ASTree lllllllllllllIIIlIIIIlIlllllIIlI, final ASTree lllllllllllllIIIlIIIIlIlllllIIIl) {
        return new Stmnt(lllllllllllllIIIlIIIIlIlllllIIII, lllllllllllllIIIlIIIIlIlllllIIll, new ASTList(lllllllllllllIIIlIIIIlIlllllIIlI, new ASTList(lllllllllllllIIIlIIIIlIlllllIIIl)));
    }
}
