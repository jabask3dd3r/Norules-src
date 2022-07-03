package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.*;

public class JvstTypeChecker extends TypeChecker
{
    private /* synthetic */ JvstCodeGen codeGen;
    
    public void addNullIfVoid() {
        if (this.exprType == 344) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
        }
    }
    
    @Override
    public void atMethodArgs(ASTList lllllllllllllllIllllllllIIllIlll, final int[] lllllllllllllllIllllllllIIllIllI, final int[] lllllllllllllllIllllllllIIllIlIl, final String[] lllllllllllllllIllllllllIIllIlII) throws CompileError {
        final CtClass[] lllllllllllllllIllllllllIIlllIll = this.codeGen.paramTypeList;
        final String lllllllllllllllIllllllllIIlllIlI = this.codeGen.paramListName;
        int lllllllllllllllIllllllllIIlllIIl = 0;
        while (lllllllllllllllIllllllllIIllIlll != null) {
            final ASTree lllllllllllllllIllllllllIlIIIIIl = lllllllllllllllIllllllllIIllIlll.head();
            if (lllllllllllllllIllllllllIlIIIIIl instanceof Member && ((Member)lllllllllllllllIllllllllIlIIIIIl).get().equals(lllllllllllllllIllllllllIIlllIlI)) {
                if (lllllllllllllllIllllllllIIlllIll != null) {
                    for (final CtClass lllllllllllllllIllllllllIlIIIlII : lllllllllllllllIllllllllIIlllIll) {
                        this.setType(lllllllllllllllIllllllllIlIIIlII);
                        lllllllllllllllIllllllllIIllIllI[lllllllllllllllIllllllllIIlllIIl] = this.exprType;
                        lllllllllllllllIllllllllIIllIlIl[lllllllllllllllIllllllllIIlllIIl] = this.arrayDim;
                        lllllllllllllllIllllllllIIllIlII[lllllllllllllllIllllllllIIlllIIl] = this.className;
                        ++lllllllllllllllIllllllllIIlllIIl;
                    }
                }
            }
            else {
                lllllllllllllllIllllllllIlIIIIIl.accept(this);
                lllllllllllllllIllllllllIIllIllI[lllllllllllllllIllllllllIIlllIIl] = this.exprType;
                lllllllllllllllIllllllllIIllIlIl[lllllllllllllllIllllllllIIlllIIl] = this.arrayDim;
                lllllllllllllllIllllllllIIllIlII[lllllllllllllllIllllllllIIlllIIl] = this.className;
                ++lllllllllllllllIllllllllIIlllIIl;
            }
            lllllllllllllllIllllllllIIllIlll = lllllllllllllllIllllllllIIllIlll.tail();
        }
    }
    
    @Override
    protected void atFieldAssign(final Expr lllllllllllllllIlllllllllIlIlIll, final int lllllllllllllllIlllllllllIlIIlIl, final ASTree lllllllllllllllIlllllllllIlIlIIl, final ASTree lllllllllllllllIlllllllllIlIlIII) throws CompileError {
        if (lllllllllllllllIlllllllllIlIlIIl instanceof Member && ((Member)lllllllllllllllIlllllllllIlIlIIl).get().equals(this.codeGen.paramArrayName)) {
            lllllllllllllllIlllllllllIlIlIII.accept(this);
            final CtClass[] lllllllllllllllIlllllllllIlIlllI = this.codeGen.paramTypeList;
            if (lllllllllllllllIlllllllllIlIlllI == null) {
                return;
            }
            for (int lllllllllllllllIlllllllllIlIllIl = lllllllllllllllIlllllllllIlIlllI.length, lllllllllllllllIlllllllllIlIllll = 0; lllllllllllllllIlllllllllIlIllll < lllllllllllllllIlllllllllIlIllIl; ++lllllllllllllllIlllllllllIlIllll) {
                this.compileUnwrapValue(lllllllllllllllIlllllllllIlIlllI[lllllllllllllllIlllllllllIlIllll]);
            }
        }
        else {
            super.atFieldAssign(lllllllllllllllIlllllllllIlIlIll, lllllllllllllllIlllllllllIlIIlIl, lllllllllllllllIlllllllllIlIlIIl, lllllllllllllllIlllllllllIlIlIII);
        }
    }
    
    public boolean isParamListName(final ASTList lllllllllllllllIllllllllIllIIIIl) {
        if (this.codeGen.paramTypeList != null && lllllllllllllllIllllllllIllIIIIl != null && lllllllllllllllIllllllllIllIIIIl.tail() == null) {
            final ASTree lllllllllllllllIllllllllIllIIlIl = lllllllllllllllIllllllllIllIIIIl.head();
            return lllllllllllllllIllllllllIllIIlIl instanceof Member && ((Member)lllllllllllllllIllllllllIllIIlIl).get().equals(this.codeGen.paramListName);
        }
        return false;
    }
    
    public void setType(final CtClass lllllllllllllllIllllllllIIIlIIII) throws CompileError {
        this.setType(lllllllllllllllIllllllllIIIlIIII, 0);
    }
    
    @Override
    public void atCastExpr(final CastExpr lllllllllllllllIlllllllllIIlIlII) throws CompileError {
        final ASTList lllllllllllllllIlllllllllIIlIllI = lllllllllllllllIlllllllllIIlIlII.getClassName();
        if (lllllllllllllllIlllllllllIIlIllI != null && lllllllllllllllIlllllllllIIlIlII.getArrayDim() == 0) {
            final ASTree lllllllllllllllIlllllllllIIllIIl = lllllllllllllllIlllllllllIIlIllI.head();
            if (lllllllllllllllIlllllllllIIllIIl instanceof Symbol && lllllllllllllllIlllllllllIIlIllI.tail() == null) {
                final String lllllllllllllllIlllllllllIIllIlI = ((Symbol)lllllllllllllllIlllllllllIIllIIl).get();
                if (lllllllllllllllIlllllllllIIllIlI.equals(this.codeGen.returnCastName)) {
                    this.atCastToRtype(lllllllllllllllIlllllllllIIlIlII);
                    return;
                }
                if (lllllllllllllllIlllllllllIIllIlI.equals("$w")) {
                    this.atCastToWrapper(lllllllllllllllIlllllllllIIlIlII);
                    return;
                }
            }
        }
        super.atCastExpr(lllllllllllllllIlllllllllIIlIlII);
    }
    
    protected void atCastToWrapper(final CastExpr lllllllllllllllIllllllllIlllllIl) throws CompileError {
        lllllllllllllllIllllllllIlllllIl.getOprand().accept(this);
        if (CodeGen.isRefType(this.exprType) || this.arrayDim > 0) {
            return;
        }
        final CtClass lllllllllllllllIllllllllIlllllII = this.resolver.lookupClass(this.exprType, this.arrayDim, this.className);
        if (lllllllllllllllIllllllllIlllllII instanceof CtPrimitiveType) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
        }
    }
    
    @Override
    public int getMethodArgsLength(ASTList lllllllllllllllIllllllllIlIlIlII) {
        final String lllllllllllllllIllllllllIlIlIlll = this.codeGen.paramListName;
        int lllllllllllllllIllllllllIlIlIllI = 0;
        while (lllllllllllllllIllllllllIlIlIlII != null) {
            final ASTree lllllllllllllllIllllllllIlIllIlI = ((ASTList)lllllllllllllllIllllllllIlIlIlII).head();
            if (lllllllllllllllIllllllllIlIllIlI instanceof Member && ((Member)lllllllllllllllIllllllllIlIllIlI).get().equals(lllllllllllllllIllllllllIlIlIlll)) {
                if (this.codeGen.paramTypeList != null) {
                    lllllllllllllllIllllllllIlIlIllI += this.codeGen.paramTypeList.length;
                }
            }
            else {
                ++lllllllllllllllIllllllllIlIlIllI;
            }
            lllllllllllllllIllllllllIlIlIlII = ((ASTList)lllllllllllllllIllllllllIlIlIlII).tail();
        }
        return lllllllllllllllIllllllllIlIlIllI;
    }
    
    protected void atCastToRtype(final CastExpr lllllllllllllllIlllllllllIIIlIII) throws CompileError {
        final CtClass lllllllllllllllIlllllllllIIIIlll = this.codeGen.returnType;
        lllllllllllllllIlllllllllIIIlIII.getOprand().accept(this);
        if (this.exprType == 344 || CodeGen.isRefType(this.exprType) || this.arrayDim > 0) {
            this.compileUnwrapValue(lllllllllllllllIlllllllllIIIIlll);
        }
        else if (lllllllllllllllIlllllllllIIIIlll instanceof CtPrimitiveType) {
            final CtPrimitiveType lllllllllllllllIlllllllllIIIlIll = (CtPrimitiveType)lllllllllllllllIlllllllllIIIIlll;
            final int lllllllllllllllIlllllllllIIIlIlI = MemberResolver.descToType(lllllllllllllllIlllllllllIIIlIll.getDescriptor());
            this.exprType = lllllllllllllllIlllllllllIIIlIlI;
            this.arrayDim = 0;
            this.className = null;
        }
    }
    
    void compileInvokeSpecial(final ASTree lllllllllllllllIllllllllIIlIIllI, final String lllllllllllllllIllllllllIIlIIlIl, final String lllllllllllllllIllllllllIIlIIlII, final String lllllllllllllllIllllllllIIlIIIll, final ASTList lllllllllllllllIllllllllIIIlllIl) throws CompileError {
        lllllllllllllllIllllllllIIlIIllI.accept(this);
        final int lllllllllllllllIllllllllIIlIIIIl = this.getMethodArgsLength(lllllllllllllllIllllllllIIIlllIl);
        this.atMethodArgs(lllllllllllllllIllllllllIIIlllIl, new int[lllllllllllllllIllllllllIIlIIIIl], new int[lllllllllllllllIllllllllIIlIIIIl], new String[lllllllllllllllIllllllllIIlIIIIl]);
        this.setReturnType(lllllllllllllllIllllllllIIlIIIll);
        this.addNullIfVoid();
    }
    
    @Override
    public void atMember(final Member lllllllllllllllIlllllllllIlllIIl) throws CompileError {
        final String lllllllllllllllIlllllllllIlllIll = lllllllllllllllIlllllllllIlllIIl.get();
        if (lllllllllllllllIlllllllllIlllIll.equals(this.codeGen.paramArrayName)) {
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = "java/lang/Object";
        }
        else if (lllllllllllllllIlllllllllIlllIll.equals("$sig")) {
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = "java/lang/Class";
        }
        else if (lllllllllllllllIlllllllllIlllIll.equals("$type") || lllllllllllllllIlllllllllIlllIll.equals("$class")) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Class";
        }
        else {
            super.atMember(lllllllllllllllIlllllllllIlllIIl);
        }
    }
    
    protected void atCflow(final ASTList lllllllllllllllIllllllllIllIlIlI) throws CompileError {
        this.exprType = 324;
        this.arrayDim = 0;
        this.className = null;
    }
    
    public JvstTypeChecker(final CtClass lllllllllllllllIllllllllllIIIllI, final ClassPool lllllllllllllllIllllllllllIIIlIl, final JvstCodeGen lllllllllllllllIllllllllllIIlIII) {
        super(lllllllllllllllIllllllllllIIIllI, lllllllllllllllIllllllllllIIIlIl);
        this.codeGen = lllllllllllllllIllllllllllIIlIII;
    }
    
    @Override
    public void atCallExpr(final CallExpr lllllllllllllllIllllllllIlllIIlI) throws CompileError {
        final ASTree lllllllllllllllIllllllllIlllIIIl = lllllllllllllllIllllllllIlllIIlI.oprand1();
        if (lllllllllllllllIllllllllIlllIIIl instanceof Member) {
            final String lllllllllllllllIllllllllIlllIlII = ((Member)lllllllllllllllIllllllllIlllIIIl).get();
            if (this.codeGen.procHandler != null && lllllllllllllllIllllllllIlllIlII.equals(this.codeGen.proceedName)) {
                this.codeGen.procHandler.setReturnType(this, (ASTList)lllllllllllllllIllllllllIlllIIlI.oprand2());
                return;
            }
            if (lllllllllllllllIllllllllIlllIlII.equals("$cflow")) {
                this.atCflow((ASTList)lllllllllllllllIllllllllIlllIIlI.oprand2());
                return;
            }
        }
        super.atCallExpr(lllllllllllllllIllllllllIlllIIlI);
    }
    
    private void setType(final CtClass lllllllllllllllIllllllllIIIIIlIl, final int lllllllllllllllIllllllllIIIIIlll) throws CompileError {
        if (lllllllllllllllIllllllllIIIIIlIl.isPrimitive()) {
            final CtPrimitiveType lllllllllllllllIllllllllIIIIlIll = (CtPrimitiveType)lllllllllllllllIllllllllIIIIIlIl;
            this.exprType = MemberResolver.descToType(lllllllllllllllIllllllllIIIIlIll.getDescriptor());
            this.arrayDim = lllllllllllllllIllllllllIIIIIlll;
            this.className = null;
        }
        else {
            if (lllllllllllllllIllllllllIIIIIlIl.isArray()) {
                try {
                    this.setType(lllllllllllllllIllllllllIIIIIlIl.getComponentType(), lllllllllllllllIllllllllIIIIIlll + 1);
                    return;
                }
                catch (NotFoundException lllllllllllllllIllllllllIIIIlIlI) {
                    throw new CompileError(String.valueOf(new StringBuilder().append("undefined type: ").append(lllllllllllllllIllllllllIIIIIlIl.getName())));
                }
            }
            this.exprType = 307;
            this.arrayDim = lllllllllllllllIllllllllIIIIIlll;
            this.className = MemberResolver.javaToJvmName(lllllllllllllllIllllllllIIIIIlIl.getName());
        }
    }
    
    protected void compileUnwrapValue(final CtClass lllllllllllllllIllllllllIIIlIllI) throws CompileError {
        if (lllllllllllllllIllllllllIIIlIllI == CtClass.voidType) {
            this.addNullIfVoid();
        }
        else {
            this.setType(lllllllllllllllIllllllllIIIlIllI);
        }
    }
}
