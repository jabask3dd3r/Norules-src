package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;

public class JvstCodeGen extends MemberCodeGen
{
    /* synthetic */ ProceedHandler procHandler;
    private /* synthetic */ int paramVarBase;
    /* synthetic */ CtClass[] paramTypeList;
    /* synthetic */ String proceedName;
    private /* synthetic */ boolean useParam0;
    /* synthetic */ String paramArrayName;
    private /* synthetic */ String returnVarName;
    /* synthetic */ String returnCastName;
    private /* synthetic */ String param0Type;
    private /* synthetic */ CtClass dollarType;
    /* synthetic */ String paramListName;
    /* synthetic */ CtClass returnType;
    
    public void setProceedHandler(final ProceedHandler lllllllllllllIIlIIlIIIllIIllIIII, final String lllllllllllllIIlIIlIIIllIIlIllII) {
        this.proceedName = lllllllllllllIIlIIlIIIllIIlIllII;
        this.procHandler = lllllllllllllIIlIIlIIIllIIllIIII;
    }
    
    public int recordParams(final CtClass[] lllllllllllllIIlIIlIIIlIIIlIIIll, final boolean lllllllllllllIIlIIlIIIlIIIlIIIlI, final String lllllllllllllIIlIIlIIIlIIIlIlIII, final String lllllllllllllIIlIIlIIIlIIIlIIIII, final String lllllllllllllIIlIIlIIIlIIIlIIllI, final SymbolTable lllllllllllllIIlIIlIIIlIIIlIIlIl) throws CompileError {
        return this.recordParams(lllllllllllllIIlIIlIIIlIIIlIIIll, lllllllllllllIIlIIlIIIlIIIlIIIlI, lllllllllllllIIlIIlIIIlIIIlIlIII, lllllllllllllIIlIIlIIIlIIIlIIIII, lllllllllllllIIlIIlIIIlIIIlIIllI, !lllllllllllllIIlIIlIIIlIIIlIIIlI, 0, this.getThisName(), lllllllllllllIIlIIlIIIlIIIlIIlIl);
    }
    
    public static int compileParameterList(final Bytecode lllllllllllllIIlIIlIIIIllIlIlIII, final CtClass[] lllllllllllllIIlIIlIIIIllIlIIlll, int lllllllllllllIIlIIlIIIIllIlIIIIl) {
        if (lllllllllllllIIlIIlIIIIllIlIIlll == null) {
            lllllllllllllIIlIIlIIIIllIlIlIII.addIconst(0);
            lllllllllllllIIlIIlIIIIllIlIlIII.addAnewarray("java.lang.Object");
            return 1;
        }
        final CtClass[] lllllllllllllIIlIIlIIIIllIlIIlIl = { null };
        final int lllllllllllllIIlIIlIIIIllIlIIlII = lllllllllllllIIlIIlIIIIllIlIIlll.length;
        lllllllllllllIIlIIlIIIIllIlIlIII.addIconst(lllllllllllllIIlIIlIIIIllIlIIlII);
        lllllllllllllIIlIIlIIIIllIlIlIII.addAnewarray("java.lang.Object");
        for (int lllllllllllllIIlIIlIIIIllIlIlIIl = 0; lllllllllllllIIlIIlIIIIllIlIlIIl < lllllllllllllIIlIIlIIIIllIlIIlII; ++lllllllllllllIIlIIlIIIIllIlIlIIl) {
            lllllllllllllIIlIIlIIIIllIlIlIII.addOpcode(89);
            lllllllllllllIIlIIlIIIIllIlIlIII.addIconst(lllllllllllllIIlIIlIIIIllIlIlIIl);
            if (lllllllllllllIIlIIlIIIIllIlIIlll[lllllllllllllIIlIIlIIIIllIlIlIIl].isPrimitive()) {
                final CtPrimitiveType lllllllllllllIIlIIlIIIIllIlIllII = (CtPrimitiveType)lllllllllllllIIlIIlIIIIllIlIIlll[lllllllllllllIIlIIlIIIIllIlIlIIl];
                final String lllllllllllllIIlIIlIIIIllIlIlIll = lllllllllllllIIlIIlIIIIllIlIllII.getWrapperName();
                lllllllllllllIIlIIlIIIIllIlIlIII.addNew(lllllllllllllIIlIIlIIIIllIlIlIll);
                lllllllllllllIIlIIlIIIIllIlIlIII.addOpcode(89);
                final int lllllllllllllIIlIIlIIIIllIlIlIlI = lllllllllllllIIlIIlIIIIllIlIlIII.addLoad(lllllllllllllIIlIIlIIIIllIlIIIIl, lllllllllllllIIlIIlIIIIllIlIllII);
                lllllllllllllIIlIIlIIIIllIlIIIIl += lllllllllllllIIlIIlIIIIllIlIlIlI;
                lllllllllllllIIlIIlIIIIllIlIIlIl[0] = lllllllllllllIIlIIlIIIIllIlIllII;
                lllllllllllllIIlIIlIIIIllIlIlIII.addInvokespecial(lllllllllllllIIlIIlIIIIllIlIlIll, "<init>", Descriptor.ofMethod(CtClass.voidType, lllllllllllllIIlIIlIIIIllIlIIlIl));
            }
            else {
                lllllllllllllIIlIIlIIIIllIlIlIII.addAload(lllllllllllllIIlIIlIIIIllIlIIIIl);
                ++lllllllllllllIIlIIlIIIIllIlIIIIl;
            }
            lllllllllllllIIlIIlIIIIllIlIlIII.addOpcode(83);
        }
        return 8;
    }
    
    static {
        cflowName = "$cflow";
        clazzName = "$class";
        dollarTypeName = "$type";
        sigName = "$sig";
        wrapperCastName = "$w";
    }
    
    public int recordReturnType(final CtClass lllllllllllllIIlIIlIIIlIIlIIIlIl, final String lllllllllllllIIlIIlIIIlIIIllllIl, final String lllllllllllllIIlIIlIIIlIIIllllII, final SymbolTable lllllllllllllIIlIIlIIIlIIlIIIIlI) throws CompileError {
        this.returnType = lllllllllllllIIlIIlIIIlIIlIIIlIl;
        this.returnCastName = lllllllllllllIIlIIlIIIlIIIllllIl;
        this.returnVarName = lllllllllllllIIlIIlIIIlIIIllllII;
        if (lllllllllllllIIlIIlIIIlIIIllllII == null) {
            return -1;
        }
        final int lllllllllllllIIlIIlIIIlIIlIIIIIl = this.getMaxLocals();
        final int lllllllllllllIIlIIlIIIlIIlIIIIII = lllllllllllllIIlIIlIIIlIIlIIIIIl + this.recordVar(lllllllllllllIIlIIlIIIlIIlIIIlIl, lllllllllllllIIlIIlIIIlIIIllllII, lllllllllllllIIlIIlIIIlIIlIIIIIl, lllllllllllllIIlIIlIIIlIIlIIIIlI);
        this.setMaxLocals(lllllllllllllIIlIIlIIIlIIlIIIIII);
        return lllllllllllllIIlIIlIIIlIIlIIIIIl;
    }
    
    @Override
    protected void atReturnStmnt(final Stmnt lllllllllllllIIlIIlIIIlIIlIlIIlI) throws CompileError {
        ASTree lllllllllllllIIlIIlIIIlIIlIlIIIl = lllllllllllllIIlIIlIIIlIIlIlIIlI.getLeft();
        if (lllllllllllllIIlIIlIIIlIIlIlIIIl != null && this.returnType == CtClass.voidType) {
            this.compileExpr(lllllllllllllIIlIIlIIIlIIlIlIIIl);
            if (CodeGen.is2word(this.exprType, this.arrayDim)) {
                this.bytecode.addOpcode(88);
            }
            else if (this.exprType != 344) {
                this.bytecode.addOpcode(87);
            }
            lllllllllllllIIlIIlIIIlIIlIlIIIl = null;
        }
        this.atReturnStmnt2(lllllllllllllIIlIIlIIIlIIlIlIIIl);
    }
    
    public JvstCodeGen(final Bytecode lllllllllllllIIlIIlIIIllIIlllIlI, final CtClass lllllllllllllIIlIIlIIIllIIlllIIl, final ClassPool lllllllllllllIIlIIlIIIllIIlllIII) {
        super(lllllllllllllIIlIIlIIIllIIlllIlI, lllllllllllllIIlIIlIIIllIIlllIIl, lllllllllllllIIlIIlIIIllIIlllIII);
        this.paramArrayName = null;
        this.paramListName = null;
        this.paramTypeList = null;
        this.paramVarBase = 0;
        this.useParam0 = false;
        this.param0Type = null;
        this.dollarType = null;
        this.returnType = null;
        this.returnCastName = null;
        this.returnVarName = null;
        this.proceedName = null;
        this.procHandler = null;
        this.setTypeChecker(new JvstTypeChecker(lllllllllllllIIlIIlIIIllIIlllIIl, lllllllllllllIIlIIlIIIllIIlllIII, this));
    }
    
    public int recordParams(final CtClass[] lllllllllllllIIlIIlIIIlIIIIIIIIl, final boolean lllllllllllllIIlIIlIIIlIIIIIlIll, final String lllllllllllllIIlIIlIIIIlllllllll, final String lllllllllllllIIlIIlIIIIllllllllI, final String lllllllllllllIIlIIlIIIlIIIIIlIII, final boolean lllllllllllllIIlIIlIIIlIIIIIIlll, final int lllllllllllllIIlIIlIIIIllllllIll, final String lllllllllllllIIlIIlIIIIllllllIlI, final SymbolTable lllllllllllllIIlIIlIIIIllllllIIl) throws CompileError {
        this.paramTypeList = lllllllllllllIIlIIlIIIlIIIIIIIIl;
        this.paramArrayName = lllllllllllllIIlIIlIIIIllllllllI;
        this.paramListName = lllllllllllllIIlIIlIIIlIIIIIlIII;
        this.paramVarBase = lllllllllllllIIlIIlIIIIllllllIll;
        this.useParam0 = lllllllllllllIIlIIlIIIlIIIIIIlll;
        if (lllllllllllllIIlIIlIIIIllllllIlI != null) {
            this.param0Type = MemberResolver.jvmToJavaName(lllllllllllllIIlIIlIIIIllllllIlI);
        }
        this.inStaticMethod = lllllllllllllIIlIIlIIIlIIIIIlIll;
        int lllllllllllllIIlIIlIIIlIIIIIIIll = lllllllllllllIIlIIlIIIIllllllIll;
        if (lllllllllllllIIlIIlIIIlIIIIIIlll) {
            final String lllllllllllllIIlIIlIIIlIIIIlIIII = String.valueOf(new StringBuilder().append(lllllllllllllIIlIIlIIIIlllllllll).append("0"));
            final Declarator lllllllllllllIIlIIlIIIlIIIIIllll = new Declarator(307, MemberResolver.javaToJvmName(lllllllllllllIIlIIlIIIIllllllIlI), 0, lllllllllllllIIlIIlIIIlIIIIIIIll++, new Symbol(lllllllllllllIIlIIlIIIlIIIIlIIII));
            lllllllllllllIIlIIlIIIIllllllIIl.append(lllllllllllllIIlIIlIIIlIIIIlIIII, lllllllllllllIIlIIlIIIlIIIIIllll);
        }
        for (int lllllllllllllIIlIIlIIIlIIIIIlllI = 0; lllllllllllllIIlIIlIIIlIIIIIlllI < lllllllllllllIIlIIlIIIlIIIIIIIIl.length; ++lllllllllllllIIlIIlIIIlIIIIIlllI) {
            lllllllllllllIIlIIlIIIlIIIIIIIll += this.recordVar(lllllllllllllIIlIIlIIIlIIIIIIIIl[lllllllllllllIIlIIlIIIlIIIIIlllI], String.valueOf(new StringBuilder().append(lllllllllllllIIlIIlIIIIlllllllll).append(lllllllllllllIIlIIlIIIlIIIIIlllI + 1)), lllllllllllllIIlIIlIIIlIIIIIIIll, lllllllllllllIIlIIlIIIIllllllIIl);
        }
        if (this.getMaxLocals() < lllllllllllllIIlIIlIIIlIIIIIIIll) {
            this.setMaxLocals(lllllllllllllIIlIIlIIIlIIIIIIIll);
        }
        return lllllllllllllIIlIIlIIIlIIIIIIIll;
    }
    
    @Override
    public void atMethodArgs(ASTList lllllllllllllIIlIIlIIIlIIlllIlII, final int[] lllllllllllllIIlIIlIIIlIIlllIIll, final int[] lllllllllllllIIlIIlIIIlIIllllIlI, final String[] lllllllllllllIIlIIlIIIlIIlllIIIl) throws CompileError {
        final CtClass[] lllllllllllllIIlIIlIIIlIIllllIII = this.paramTypeList;
        final String lllllllllllllIIlIIlIIIlIIlllIlll = this.paramListName;
        int lllllllllllllIIlIIlIIIlIIlllIllI = 0;
        while (lllllllllllllIIlIIlIIIlIIlllIlII != null) {
            final ASTree lllllllllllllIIlIIlIIIlIIllllllI = ((ASTList)lllllllllllllIIlIIlIIIlIIlllIlII).head();
            if (lllllllllllllIIlIIlIIIlIIllllllI instanceof Member && ((Member)lllllllllllllIIlIIlIIIlIIllllllI).get().equals(lllllllllllllIIlIIlIIIlIIlllIlll)) {
                if (lllllllllllllIIlIIlIIIlIIllllIII != null) {
                    final int lllllllllllllIIlIIlIIIlIlIIIIIII = lllllllllllllIIlIIlIIIlIIllllIII.length;
                    int lllllllllllllIIlIIlIIIlIIlllllll = this.indexOfParam1();
                    for (final CtClass lllllllllllllIIlIIlIIIlIlIIIIIlI : lllllllllllllIIlIIlIIIlIIllllIII) {
                        lllllllllllllIIlIIlIIIlIIlllllll += this.bytecode.addLoad(lllllllllllllIIlIIlIIIlIIlllllll, lllllllllllllIIlIIlIIIlIlIIIIIlI);
                        this.setType(lllllllllllllIIlIIlIIIlIlIIIIIlI);
                        lllllllllllllIIlIIlIIIlIIlllIIll[lllllllllllllIIlIIlIIIlIIlllIllI] = this.exprType;
                        lllllllllllllIIlIIlIIIlIIllllIlI[lllllllllllllIIlIIlIIIlIIlllIllI] = this.arrayDim;
                        lllllllllllllIIlIIlIIIlIIlllIIIl[lllllllllllllIIlIIlIIIlIIlllIllI] = this.className;
                        ++lllllllllllllIIlIIlIIIlIIlllIllI;
                    }
                }
            }
            else {
                lllllllllllllIIlIIlIIIlIIllllllI.accept(this);
                lllllllllllllIIlIIlIIIlIIlllIIll[lllllllllllllIIlIIlIIIlIIlllIllI] = this.exprType;
                lllllllllllllIIlIIlIIIlIIllllIlI[lllllllllllllIIlIIlIIIlIIlllIllI] = this.arrayDim;
                lllllllllllllIIlIIlIIIlIIlllIIIl[lllllllllllllIIlIIlIIIlIIlllIllI] = this.className;
                ++lllllllllllllIIlIIlIIIlIIlllIllI;
            }
            lllllllllllllIIlIIlIIIlIIlllIlII = ((ASTList)lllllllllllllIIlIIlIIIlIIlllIlII).tail();
        }
    }
    
    @Override
    public int getMethodArgsLength(ASTList lllllllllllllIIlIIlIIIlIlIIlIIll) {
        final String lllllllllllllIIlIIlIIIlIlIIlIllI = this.paramListName;
        int lllllllllllllIIlIIlIIIlIlIIlIlIl = 0;
        while (lllllllllllllIIlIIlIIIlIlIIlIIll != null) {
            final ASTree lllllllllllllIIlIIlIIIlIlIIllIIl = ((ASTList)lllllllllllllIIlIIlIIIlIlIIlIIll).head();
            if (lllllllllllllIIlIIlIIIlIlIIllIIl instanceof Member && ((Member)lllllllllllllIIlIIlIIIlIlIIllIIl).get().equals(lllllllllllllIIlIIlIIIlIlIIlIllI)) {
                if (this.paramTypeList != null) {
                    lllllllllllllIIlIIlIIIlIlIIlIlIl += this.paramTypeList.length;
                }
            }
            else {
                ++lllllllllllllIIlIIlIIIlIlIIlIlIl;
            }
            lllllllllllllIIlIIlIIIlIlIIlIIll = ((ASTList)lllllllllllllIIlIIlIIIlIlIIlIIll).tail();
        }
        return lllllllllllllIIlIIlIIIlIlIIlIlIl;
    }
    
    @Override
    public void atCallExpr(final CallExpr lllllllllllllIIlIIlIIIlIllIIIIlI) throws CompileError {
        final ASTree lllllllllllllIIlIIlIIIlIllIIIlII = lllllllllllllIIlIIlIIIlIllIIIIlI.oprand1();
        if (lllllllllllllIIlIIlIIIlIllIIIlII instanceof Member) {
            final String lllllllllllllIIlIIlIIIlIllIIIlll = ((Member)lllllllllllllIIlIIlIIIlIllIIIlII).get();
            if (this.procHandler != null && lllllllllllllIIlIIlIIIlIllIIIlll.equals(this.proceedName)) {
                this.procHandler.doit(this, this.bytecode, (ASTList)lllllllllllllIIlIIlIIIlIllIIIIlI.oprand2());
                return;
            }
            if (lllllllllllllIIlIIlIIIlIllIIIlll.equals("$cflow")) {
                this.atCflow((ASTList)lllllllllllllIIlIIlIIIlIllIIIIlI.oprand2());
                return;
            }
        }
        super.atCallExpr(lllllllllllllIIlIIlIIIlIllIIIIlI);
    }
    
    protected void atCastToWrapper(final CastExpr lllllllllllllIIlIIlIIIlIllIIllll) throws CompileError {
        lllllllllllllIIlIIlIIIlIllIIllll.getOprand().accept(this);
        if (CodeGen.isRefType(this.exprType) || this.arrayDim > 0) {
            return;
        }
        final CtClass lllllllllllllIIlIIlIIIlIllIlIIIl = this.resolver.lookupClass(this.exprType, this.arrayDim, this.className);
        if (lllllllllllllIIlIIlIIIlIllIlIIIl instanceof CtPrimitiveType) {
            final CtPrimitiveType lllllllllllllIIlIIlIIIlIllIlIlIl = (CtPrimitiveType)lllllllllllllIIlIIlIIIlIllIlIIIl;
            final String lllllllllllllIIlIIlIIIlIllIlIlII = lllllllllllllIIlIIlIIIlIllIlIlIl.getWrapperName();
            this.bytecode.addNew(lllllllllllllIIlIIlIIIlIllIlIlII);
            this.bytecode.addOpcode(89);
            if (lllllllllllllIIlIIlIIIlIllIlIlIl.getDataSize() > 1) {
                this.bytecode.addOpcode(94);
            }
            else {
                this.bytecode.addOpcode(93);
            }
            this.bytecode.addOpcode(88);
            this.bytecode.addInvokespecial(lllllllllllllIIlIIlIIIlIllIlIlII, "<init>", String.valueOf(new StringBuilder().append("(").append(lllllllllllllIIlIIlIIIlIllIlIlIl.getDescriptor()).append(")V")));
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
        }
    }
    
    private void setType(final CtClass lllllllllllllIIlIIlIIIIlIllllllI, final int lllllllllllllIIlIIlIIIIlIlllllIl) throws CompileError {
        if (lllllllllllllIIlIIlIIIIlIllllllI.isPrimitive()) {
            final CtPrimitiveType lllllllllllllIIlIIlIIIIllIIIIIIl = (CtPrimitiveType)lllllllllllllIIlIIlIIIIlIllllllI;
            this.exprType = MemberResolver.descToType(lllllllllllllIIlIIlIIIIllIIIIIIl.getDescriptor());
            this.arrayDim = lllllllllllllIIlIIlIIIIlIlllllIl;
            this.className = null;
        }
        else {
            if (lllllllllllllIIlIIlIIIIlIllllllI.isArray()) {
                try {
                    this.setType(lllllllllllllIIlIIlIIIIlIllllllI.getComponentType(), lllllllllllllIIlIIlIIIIlIlllllIl + 1);
                    return;
                }
                catch (NotFoundException lllllllllllllIIlIIlIIIIllIIIIIII) {
                    throw new CompileError(String.valueOf(new StringBuilder().append("undefined type: ").append(lllllllllllllIIlIIlIIIIlIllllllI.getName())));
                }
            }
            this.exprType = 307;
            this.arrayDim = lllllllllllllIIlIIlIIIIlIlllllIl;
            this.className = MemberResolver.javaToJvmName(lllllllllllllIIlIIlIIIIlIllllllI.getName());
        }
    }
    
    public void recordType(final CtClass lllllllllllllIIlIIlIIIlIIIllIlIl) {
        this.dollarType = lllllllllllllIIlIIlIIIlIIIllIlIl;
    }
    
    @Override
    protected void atFieldAssign(final Expr lllllllllllllIIlIIlIIIllIIIlIIlI, final int lllllllllllllIIlIIlIIIllIIIlIIIl, final ASTree lllllllllllllIIlIIlIIIllIIIlIIII, final ASTree lllllllllllllIIlIIlIIIllIIIIllll, final boolean lllllllllllllIIlIIlIIIllIIIIlllI) throws CompileError {
        if (lllllllllllllIIlIIlIIIllIIIlIIII instanceof Member && ((Member)lllllllllllllIIlIIlIIIllIIIlIIII).get().equals(this.paramArrayName)) {
            if (lllllllllllllIIlIIlIIIllIIIlIIIl != 61) {
                throw new CompileError(String.valueOf(new StringBuilder().append("bad operator for ").append(this.paramArrayName)));
            }
            lllllllllllllIIlIIlIIIllIIIIllll.accept(this);
            if (this.arrayDim != 1 || this.exprType != 307) {
                throw new CompileError(String.valueOf(new StringBuilder().append("invalid type for ").append(this.paramArrayName)));
            }
            this.atAssignParamList(this.paramTypeList, this.bytecode);
            if (!lllllllllllllIIlIIlIIIllIIIIlllI) {
                this.bytecode.addOpcode(87);
            }
        }
        else {
            super.atFieldAssign(lllllllllllllIIlIIlIIIllIIIlIIlI, lllllllllllllIIlIIlIIIllIIIlIIIl, lllllllllllllIIlIIlIIIllIIIlIIII, lllllllllllllIIlIIlIIIllIIIIllll, lllllllllllllIIlIIlIIIllIIIIlllI);
        }
    }
    
    private static void makeCflowName(final StringBuffer lllllllllllllIIlIIlIIIlIlIlIlIlI, final ASTree lllllllllllllIIlIIlIIIlIlIlIlIIl) throws CompileError {
        if (lllllllllllllIIlIIlIIIlIlIlIlIIl instanceof Symbol) {
            lllllllllllllIIlIIlIIIlIlIlIlIlI.append(((Symbol)lllllllllllllIIlIIlIIIlIlIlIlIIl).get());
            return;
        }
        if (lllllllllllllIIlIIlIIIlIlIlIlIIl instanceof Expr) {
            final Expr lllllllllllllIIlIIlIIIlIlIlIllIl = (Expr)lllllllllllllIIlIIlIIIlIlIlIlIIl;
            if (lllllllllllllIIlIIlIIIlIlIlIllIl.getOperator() == 46) {
                makeCflowName(lllllllllllllIIlIIlIIIlIlIlIlIlI, lllllllllllllIIlIIlIIIlIlIlIllIl.oprand1());
                lllllllllllllIIlIIlIIIlIlIlIlIlI.append('.');
                makeCflowName(lllllllllllllIIlIIlIIIlIlIlIlIlI, lllllllllllllIIlIIlIIIlIlIlIllIl.oprand2());
                return;
            }
        }
        throw new CompileError("bad $cflow");
    }
    
    public void addNullIfVoid() {
        if (this.exprType == 344) {
            this.bytecode.addOpcode(1);
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
        }
    }
    
    protected void atAssignParamList(final CtClass[] lllllllllllllIIlIIlIIIlIllllllll, final Bytecode lllllllllllllIIlIIlIIIlIlllllllI) throws CompileError {
        if (lllllllllllllIIlIIlIIIlIllllllll == null) {
            return;
        }
        int lllllllllllllIIlIIlIIIlIllllllIl = this.indexOfParam1();
        for (int lllllllllllllIIlIIlIIIlIllllllII = lllllllllllllIIlIIlIIIlIllllllll.length, lllllllllllllIIlIIlIIIllIIIIIIIl = 0; lllllllllllllIIlIIlIIIllIIIIIIIl < lllllllllllllIIlIIlIIIlIllllllII; ++lllllllllllllIIlIIlIIIllIIIIIIIl) {
            lllllllllllllIIlIIlIIIlIlllllllI.addOpcode(89);
            lllllllllllllIIlIIlIIIlIlllllllI.addIconst(lllllllllllllIIlIIlIIIllIIIIIIIl);
            lllllllllllllIIlIIlIIIlIlllllllI.addOpcode(50);
            this.compileUnwrapValue(lllllllllllllIIlIIlIIIlIllllllll[lllllllllllllIIlIIlIIIllIIIIIIIl], lllllllllllllIIlIIlIIIlIlllllllI);
            lllllllllllllIIlIIlIIIlIlllllllI.addStore(lllllllllllllIIlIIlIIIlIllllllIl, lllllllllllllIIlIIlIIIlIllllllll[lllllllllllllIIlIIlIIIllIIIIIIIl]);
            lllllllllllllIIlIIlIIIlIllllllIl += (CodeGen.is2word(this.exprType, this.arrayDim) ? 2 : 1);
        }
    }
    
    public void recordVariable(final String lllllllllllllIIlIIlIIIIlllIIIlll, final String lllllllllllllIIlIIlIIIIllIllllIl, final int lllllllllllllIIlIIlIIIIlllIIIlIl, final SymbolTable lllllllllllllIIlIIlIIIIllIlllIll) throws CompileError {
        int lllllllllllllIIlIIlIIIIlllIIIIlI;
        char lllllllllllllIIlIIlIIIIlllIIIIll;
        for (lllllllllllllIIlIIlIIIIlllIIIIlI = 0; (lllllllllllllIIlIIlIIIIlllIIIIll = lllllllllllllIIlIIlIIIIlllIIIlll.charAt(lllllllllllllIIlIIlIIIIlllIIIIlI)) == '['; ++lllllllllllllIIlIIlIIIIlllIIIIlI) {}
        final int lllllllllllllIIlIIlIIIIlllIIIIIl = MemberResolver.descToType(lllllllllllllIIlIIlIIIIlllIIIIll);
        String lllllllllllllIIlIIlIIIIlllIIIIII = null;
        if (lllllllllllllIIlIIlIIIIlllIIIIIl == 307) {
            if (lllllllllllllIIlIIlIIIIlllIIIIlI == 0) {
                lllllllllllllIIlIIlIIIIlllIIIIII = lllllllllllllIIlIIlIIIIlllIIIlll.substring(1, lllllllllllllIIlIIlIIIIlllIIIlll.length() - 1);
            }
            else {
                lllllllllllllIIlIIlIIIIlllIIIIII = lllllllllllllIIlIIlIIIIlllIIIlll.substring(lllllllllllllIIlIIlIIIIlllIIIIlI + 1, lllllllllllllIIlIIlIIIIlllIIIlll.length() - 1);
            }
        }
        final Declarator lllllllllllllIIlIIlIIIIllIllllll = new Declarator(lllllllllllllIIlIIlIIIIlllIIIIIl, lllllllllllllIIlIIlIIIIlllIIIIII, lllllllllllllIIlIIlIIIIlllIIIIlI, lllllllllllllIIlIIlIIIIlllIIIlIl, new Symbol(lllllllllllllIIlIIlIIIIllIllllIl));
        lllllllllllllIIlIIlIIIIllIlllIll.append(lllllllllllllIIlIIlIIIIllIllllIl, lllllllllllllIIlIIlIIIIllIllllll);
    }
    
    public int recordVariable(final CtClass lllllllllllllIIlIIlIIIIllllIlllI, final String lllllllllllllIIlIIlIIIIllllIIlll, final SymbolTable lllllllllllllIIlIIlIIIIllllIllII) throws CompileError {
        if (lllllllllllllIIlIIlIIIIllllIIlll == null) {
            return -1;
        }
        final int lllllllllllllIIlIIlIIIIllllIlIll = this.getMaxLocals();
        final int lllllllllllllIIlIIlIIIIllllIlIlI = lllllllllllllIIlIIlIIIIllllIlIll + this.recordVar(lllllllllllllIIlIIlIIIIllllIlllI, lllllllllllllIIlIIlIIIIllllIIlll, lllllllllllllIIlIIlIIIIllllIlIll, lllllllllllllIIlIIlIIIIllllIllII);
        this.setMaxLocals(lllllllllllllIIlIIlIIIIllllIlIlI);
        return lllllllllllllIIlIIlIIIIllllIlIll;
    }
    
    private int indexOfParam1() {
        return this.paramVarBase + (this.useParam0 ? 1 : 0);
    }
    
    protected void atCflow(final ASTList lllllllllllllIIlIIlIIIlIlIlllIIl) throws CompileError {
        final StringBuffer lllllllllllllIIlIIlIIIlIlIlllIII = new StringBuffer();
        if (lllllllllllllIIlIIlIIIlIlIlllIIl == null || lllllllllllllIIlIIlIIIlIlIlllIIl.tail() != null) {
            throw new CompileError("bad $cflow");
        }
        makeCflowName(lllllllllllllIIlIIlIIIlIlIlllIII, lllllllllllllIIlIIlIIIlIlIlllIIl.head());
        final String lllllllllllllIIlIIlIIIlIlIllIlll = lllllllllllllIIlIIlIIIlIlIlllIII.toString();
        final Object[] lllllllllllllIIlIIlIIIlIlIllIllI = this.resolver.getClassPool().lookupCflow(lllllllllllllIIlIIlIIIlIlIllIlll);
        if (lllllllllllllIIlIIlIIIlIlIllIllI == null) {
            throw new CompileError(String.valueOf(new StringBuilder().append("no such $cflow: ").append(lllllllllllllIIlIIlIIIlIlIllIlll)));
        }
        this.bytecode.addGetstatic((String)lllllllllllllIIlIIlIIIlIlIllIllI[0], (String)lllllllllllllIIlIIlIIIlIlIllIllI[1], "Lcom/viaversion/viaversion/libs/javassist/runtime/Cflow;");
        this.bytecode.addInvokevirtual("com.viaversion.viaversion.libs.javassist.runtime.Cflow", "value", "()I");
        this.exprType = 324;
        this.arrayDim = 0;
        this.className = null;
    }
    
    void compileInvokeSpecial(final ASTree lllllllllllllIIlIIlIIIlIIlIllIll, final int lllllllllllllIIlIIlIIIlIIlIllIlI, final String lllllllllllllIIlIIlIIIlIIlIllIIl, final ASTList lllllllllllllIIlIIlIIIlIIlIllIII) throws CompileError {
        lllllllllllllIIlIIlIIIlIIlIllIll.accept(this);
        final int lllllllllllllIIlIIlIIIlIIlIlllIl = this.getMethodArgsLength(lllllllllllllIIlIIlIIIlIIlIllIII);
        this.atMethodArgs(lllllllllllllIIlIIlIIIlIIlIllIII, new int[lllllllllllllIIlIIlIIIlIIlIlllIl], new int[lllllllllllllIIlIIlIIIlIIlIlllIl], new String[lllllllllllllIIlIIlIIIlIIlIlllIl]);
        this.bytecode.addInvokespecial(lllllllllllllIIlIIlIIIlIIlIllIlI, lllllllllllllIIlIIlIIIlIIlIllIIl);
        this.setReturnType(lllllllllllllIIlIIlIIIlIIlIllIIl, false, false);
        this.addNullIfVoid();
    }
    
    @Override
    public void atCastExpr(final CastExpr lllllllllllllIIlIIlIIIlIlllIlIlI) throws CompileError {
        final ASTList lllllllllllllIIlIIlIIIlIlllIllII = lllllllllllllIIlIIlIIIlIlllIlIlI.getClassName();
        if (lllllllllllllIIlIIlIIIlIlllIllII != null && lllllllllllllIIlIIlIIIlIlllIlIlI.getArrayDim() == 0) {
            final ASTree lllllllllllllIIlIIlIIIlIlllIllll = lllllllllllllIIlIIlIIIlIlllIllII.head();
            if (lllllllllllllIIlIIlIIIlIlllIllll instanceof Symbol && lllllllllllllIIlIIlIIIlIlllIllII.tail() == null) {
                final String lllllllllllllIIlIIlIIIlIllllIIII = ((Symbol)lllllllllllllIIlIIlIIIlIlllIllll).get();
                if (lllllllllllllIIlIIlIIIlIllllIIII.equals(this.returnCastName)) {
                    this.atCastToRtype(lllllllllllllIIlIIlIIIlIlllIlIlI);
                    return;
                }
                if (lllllllllllllIIlIIlIIIlIllllIIII.equals("$w")) {
                    this.atCastToWrapper(lllllllllllllIIlIIlIIIlIlllIlIlI);
                    return;
                }
            }
        }
        super.atCastExpr(lllllllllllllIIlIIlIIIlIlllIlIlI);
    }
    
    private int recordVar(final CtClass lllllllllllllIIlIIlIIIIlllIlllII, final String lllllllllllllIIlIIlIIIIlllIlIlIl, final int lllllllllllllIIlIIlIIIIlllIllIlI, final SymbolTable lllllllllllllIIlIIlIIIIlllIlIIll) throws CompileError {
        if (lllllllllllllIIlIIlIIIIlllIlllII == CtClass.voidType) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
        }
        else {
            this.setType(lllllllllllllIIlIIlIIIIlllIlllII);
        }
        final Declarator lllllllllllllIIlIIlIIIIlllIllIII = new Declarator(this.exprType, this.className, this.arrayDim, lllllllllllllIIlIIlIIIIlllIllIlI, new Symbol(lllllllllllllIIlIIlIIIIlllIlIlIl));
        lllllllllllllIIlIIlIIIIlllIlIIll.append(lllllllllllllIIlIIlIIIIlllIlIlIl, lllllllllllllIIlIIlIIIIlllIllIII);
        return CodeGen.is2word(this.exprType, this.arrayDim) ? 2 : 1;
    }
    
    @Override
    public void atMember(final Member lllllllllllllIIlIIlIIIllIIlIIlII) throws CompileError {
        final String lllllllllllllIIlIIlIIIllIIlIIIll = lllllllllllllIIlIIlIIIllIIlIIlII.get();
        if (lllllllllllllIIlIIlIIIllIIlIIIll.equals(this.paramArrayName)) {
            compileParameterList(this.bytecode, this.paramTypeList, this.indexOfParam1());
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = "java/lang/Object";
        }
        else if (lllllllllllllIIlIIlIIIllIIlIIIll.equals("$sig")) {
            this.bytecode.addLdc(Descriptor.ofMethod(this.returnType, this.paramTypeList));
            this.bytecode.addInvokestatic("com/viaversion/viaversion/libs/javassist/runtime/Desc", "getParams", "(Ljava/lang/String;)[Ljava/lang/Class;");
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = "java/lang/Class";
        }
        else if (lllllllllllllIIlIIlIIIllIIlIIIll.equals("$type")) {
            if (this.dollarType == null) {
                throw new CompileError("$type is not available");
            }
            this.bytecode.addLdc(Descriptor.of(this.dollarType));
            this.callGetType("getType");
        }
        else if (lllllllllllllIIlIIlIIIllIIlIIIll.equals("$class")) {
            if (this.param0Type == null) {
                throw new CompileError("$class is not available");
            }
            this.bytecode.addLdc(this.param0Type);
            this.callGetType("getClazz");
        }
        else {
            super.atMember(lllllllllllllIIlIIlIIIllIIlIIlII);
        }
    }
    
    public void setType(final CtClass lllllllllllllIIlIIlIIIIllIIIIllI) throws CompileError {
        this.setType(lllllllllllllIIlIIlIIIIllIIIIllI, 0);
    }
    
    protected void atCastToRtype(final CastExpr lllllllllllllIIlIIlIIIlIllIlllll) throws CompileError {
        lllllllllllllIIlIIlIIIlIllIlllll.getOprand().accept(this);
        if (this.exprType == 344 || CodeGen.isRefType(this.exprType) || this.arrayDim > 0) {
            this.compileUnwrapValue(this.returnType, this.bytecode);
        }
        else {
            if (!(this.returnType instanceof CtPrimitiveType)) {
                throw new CompileError("invalid cast");
            }
            final CtPrimitiveType lllllllllllllIIlIIlIIIlIlllIIIlI = (CtPrimitiveType)this.returnType;
            final int lllllllllllllIIlIIlIIIlIlllIIIIl = MemberResolver.descToType(lllllllllllllIIlIIlIIIlIlllIIIlI.getDescriptor());
            this.atNumCastExpr(this.exprType, lllllllllllllIIlIIlIIIlIlllIIIIl);
            this.exprType = lllllllllllllIIlIIlIIIlIlllIIIIl;
            this.arrayDim = 0;
            this.className = null;
        }
    }
    
    public void doNumCast(final CtClass lllllllllllllIIlIIlIIIIlIlllIIIl) throws CompileError {
        if (this.arrayDim == 0 && !CodeGen.isRefType(this.exprType)) {
            if (!(lllllllllllllIIlIIlIIIIlIlllIIIl instanceof CtPrimitiveType)) {
                throw new CompileError("type mismatch");
            }
            final CtPrimitiveType lllllllllllllIIlIIlIIIIlIlllIlIl = (CtPrimitiveType)lllllllllllllIIlIIlIIIIlIlllIIIl;
            this.atNumCastExpr(this.exprType, MemberResolver.descToType(lllllllllllllIIlIIlIIIIlIlllIlIl.getDescriptor()));
        }
    }
    
    protected void compileUnwrapValue(final CtClass lllllllllllllIIlIIlIIIIllIIIllll, final Bytecode lllllllllllllIIlIIlIIIIllIIlIIIl) throws CompileError {
        if (lllllllllllllIIlIIlIIIIllIIIllll == CtClass.voidType) {
            this.addNullIfVoid();
            return;
        }
        if (this.exprType == 344) {
            throw new CompileError(String.valueOf(new StringBuilder().append("invalid type for ").append(this.returnCastName)));
        }
        if (lllllllllllllIIlIIlIIIIllIIIllll instanceof CtPrimitiveType) {
            final CtPrimitiveType lllllllllllllIIlIIlIIIIllIIlIlIl = (CtPrimitiveType)lllllllllllllIIlIIlIIIIllIIIllll;
            final String lllllllllllllIIlIIlIIIIllIIlIlII = lllllllllllllIIlIIlIIIIllIIlIlIl.getWrapperName();
            lllllllllllllIIlIIlIIIIllIIlIIIl.addCheckcast(lllllllllllllIIlIIlIIIIllIIlIlII);
            lllllllllllllIIlIIlIIIIllIIlIIIl.addInvokevirtual(lllllllllllllIIlIIlIIIIllIIlIlII, lllllllllllllIIlIIlIIIIllIIlIlIl.getGetMethodName(), lllllllllllllIIlIIlIIIIllIIlIlIl.getGetMethodDescriptor());
            this.setType(lllllllllllllIIlIIlIIIIllIIIllll);
        }
        else {
            lllllllllllllIIlIIlIIIIllIIlIIIl.addCheckcast(lllllllllllllIIlIIlIIIIllIIIllll);
            this.setType(lllllllllllllIIlIIlIIIIllIIIllll);
        }
    }
    
    public boolean isParamListName(final ASTList lllllllllllllIIlIIlIIIlIlIlIIIlI) {
        if (this.paramTypeList != null && lllllllllllllIIlIIlIIIlIlIlIIIlI != null && lllllllllllllIIlIIlIIIlIlIlIIIlI.tail() == null) {
            final ASTree lllllllllllllIIlIIlIIIlIlIlIIlII = lllllllllllllIIlIIlIIIlIlIlIIIlI.head();
            return lllllllllllllIIlIIlIIIlIlIlIIlII instanceof Member && ((Member)lllllllllllllIIlIIlIIIlIlIlIIlII).get().equals(this.paramListName);
        }
        return false;
    }
    
    private void callGetType(final String lllllllllllllIIlIIlIIIllIIIllIlI) {
        this.bytecode.addInvokestatic("com/viaversion/viaversion/libs/javassist/runtime/Desc", lllllllllllllIIlIIlIIIllIIIllIlI, "(Ljava/lang/String;)Ljava/lang/Class;");
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/Class";
    }
}
