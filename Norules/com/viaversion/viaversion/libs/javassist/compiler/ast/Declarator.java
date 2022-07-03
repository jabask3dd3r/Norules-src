package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class Declarator extends ASTList implements TokenId
{
    protected /* synthetic */ int arrayDim;
    protected /* synthetic */ String qualifiedClass;
    protected /* synthetic */ int localVar;
    protected /* synthetic */ int varType;
    
    public int getArrayDim() {
        return this.arrayDim;
    }
    
    public void setLocalVar(final int llllllllllllllIIIIlIIIllIIlIIlII) {
        this.localVar = llllllllllllllIIIIlIIIllIIlIIlII;
    }
    
    public Declarator(final int llllllllllllllIIIIlIIIlllIIlIlII, final int llllllllllllllIIIIlIIIlllIIlIIll) {
        super(null);
        this.varType = llllllllllllllIIIIlIIIlllIIlIlII;
        this.arrayDim = llllllllllllllIIIIlIIIlllIIlIIll;
        this.localVar = -1;
        this.qualifiedClass = null;
    }
    
    public void setVariable(final Symbol llllllllllllllIIIIlIIIllIIlllIIl) {
        this.setLeft(llllllllllllllIIIIlIIIllIIlllIIl);
    }
    
    public void setClassName(final String llllllllllllllIIIIlIIIllIlIIlIIl) {
        this.qualifiedClass = llllllllllllllIIIIlIIIllIlIIlIIl;
    }
    
    public int getType() {
        return this.varType;
    }
    
    public static String astToClassName(final ASTList llllllllllllllIIIIlIIIllIIIIIlll, final char llllllllllllllIIIIlIIIlIllllllll) {
        if (llllllllllllllIIIIlIIIllIIIIIlll == null) {
            return null;
        }
        final StringBuffer llllllllllllllIIIIlIIIllIIIIIIll = new StringBuffer();
        astToClassName(llllllllllllllIIIIlIIIllIIIIIIll, llllllllllllllIIIIlIIIllIIIIIlll, llllllllllllllIIIIlIIIlIllllllll);
        return llllllllllllllIIIIlIIIllIIIIIIll.toString();
    }
    
    public Declarator make(final Symbol llllllllllllllIIIIlIIIllIllIlllI, final int llllllllllllllIIIIlIIIllIllIlIII, final ASTree llllllllllllllIIIIlIIIllIllIIlll) {
        final Declarator llllllllllllllIIIIlIIIllIllIlIll = new Declarator(this.varType, this.arrayDim + llllllllllllllIIIIlIIIllIllIlIII);
        llllllllllllllIIIIlIIIllIllIlIll.qualifiedClass = this.qualifiedClass;
        llllllllllllllIIIIlIIIllIllIlIll.setLeft(llllllllllllllIIIIlIIIllIllIlllI);
        ASTList.append(llllllllllllllIIIIlIIIllIllIlIll, llllllllllllllIIIIlIIIllIllIIlll);
        return llllllllllllllIIIIlIIIllIllIlIll;
    }
    
    public void addArrayDim(final int llllllllllllllIIIIlIIIllIlIlllII) {
        this.arrayDim += llllllllllllllIIIIlIIIllIlIlllII;
    }
    
    private static void astToClassName(final StringBuffer llllllllllllllIIIIlIIIlIlllIIllI, ASTList llllllllllllllIIIIlIIIlIlllIIlII, final char llllllllllllllIIIIlIIIlIlllIlIII) {
        while (true) {
            final ASTree llllllllllllllIIIIlIIIlIlllIllII = ((ASTList)llllllllllllllIIIIlIIIlIlllIIlII).head();
            if (llllllllllllllIIIIlIIIlIlllIllII instanceof Symbol) {
                llllllllllllllIIIIlIIIlIlllIIllI.append(((Symbol)llllllllllllllIIIIlIIIlIlllIllII).get());
            }
            else if (llllllllllllllIIIIlIIIlIlllIllII instanceof ASTList) {
                astToClassName(llllllllllllllIIIIlIIIlIlllIIllI, (ASTList)llllllllllllllIIIIlIIIlIlllIllII, llllllllllllllIIIIlIIIlIlllIlIII);
            }
            llllllllllllllIIIIlIIIlIlllIIlII = ((ASTList)llllllllllllllIIIIlIIIlIlllIIlII).tail();
            if (llllllllllllllIIIIlIIIlIlllIIlII == null) {
                break;
            }
            llllllllllllllIIIIlIIIlIlllIIllI.append(llllllllllllllIIIIlIIIlIlllIlIII);
        }
    }
    
    @Override
    public void accept(final Visitor llllllllllllllIIIIlIIIllIIIlIIIl) throws CompileError {
        llllllllllllllIIIIlIIIllIIIlIIIl.atDeclarator(this);
    }
    
    public Symbol getVariable() {
        return (Symbol)this.getLeft();
    }
    
    public Declarator(final int llllllllllllllIIIIlIIIllIlllllll, final String llllllllllllllIIIIlIIIllIllllllI, final int llllllllllllllIIIIlIIIllIlllllIl, final int llllllllllllllIIIIlIIIllIlllllII, final Symbol llllllllllllllIIIIlIIIllIlllIlIl) {
        super(null);
        this.varType = llllllllllllllIIIIlIIIllIlllllll;
        this.arrayDim = llllllllllllllIIIIlIIIllIlllllIl;
        this.localVar = llllllllllllllIIIIlIIIllIlllllII;
        this.qualifiedClass = llllllllllllllIIIIlIIIllIllllllI;
        this.setLeft(llllllllllllllIIIIlIIIllIlllIlIl);
        ASTList.append(this, null);
    }
    
    public int getLocalVar() {
        return this.localVar;
    }
    
    public String getClassName() {
        return this.qualifiedClass;
    }
    
    public ASTree getInitializer() {
        final ASTList llllllllllllllIIIIlIIIllIIlIllll = this.tail();
        if (llllllllllllllIIIIlIIIllIIlIllll != null) {
            return llllllllllllllIIIIlIIIllIIlIllll.head();
        }
        return null;
    }
    
    public Declarator(final ASTList llllllllllllllIIIIlIIIlllIIIlIII, final int llllllllllllllIIIIlIIIlllIIIlIlI) {
        super(null);
        this.varType = 307;
        this.arrayDim = llllllllllllllIIIIlIIIlllIIIlIlI;
        this.localVar = -1;
        this.qualifiedClass = astToClassName(llllllllllllllIIIIlIIIlllIIIlIII, '/');
    }
    
    public String getTag() {
        return "decl";
    }
}
