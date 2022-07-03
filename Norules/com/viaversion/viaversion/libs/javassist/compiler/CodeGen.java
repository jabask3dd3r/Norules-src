package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.util.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;

public abstract class CodeGen extends Visitor implements Opcode, TokenId
{
    private static final /* synthetic */ int[] castOp;
    protected /* synthetic */ String className;
    protected /* synthetic */ int exprType;
    private /* synthetic */ int tempVar;
    /* synthetic */ TypeChecker typeChecker;
    static final /* synthetic */ int[] binOp;
    protected /* synthetic */ List<Integer> continueList;
    protected /* synthetic */ Bytecode bytecode;
    public /* synthetic */ boolean inStaticMethod;
    protected /* synthetic */ boolean hasReturned;
    protected /* synthetic */ int arrayDim;
    protected /* synthetic */ List<Integer> breakList;
    protected /* synthetic */ ReturnHook returnHooks;
    private static final /* synthetic */ int[] ifOp;
    private static final /* synthetic */ int[] ifOp2;
    
    static int getCompOperator(final ASTree lllllllllllllIIIllIIIIlIIIlIIllI) throws CompileError {
        if (!(lllllllllllllIIIllIIIIlIIIlIIllI instanceof Expr)) {
            return 32;
        }
        final Expr lllllllllllllIIIllIIIIlIIIlIlIII = (Expr)lllllllllllllIIIllIIIIlIIIlIIllI;
        final int lllllllllllllIIIllIIIIlIIIlIIlll = lllllllllllllIIIllIIIIlIIIlIlIII.getOperator();
        if (lllllllllllllIIIllIIIIlIIIlIIlll == 33) {
            return 33;
        }
        if (lllllllllllllIIIllIIIIlIIIlIlIII instanceof BinExpr && lllllllllllllIIIllIIIIlIIIlIIlll != 368 && lllllllllllllIIIllIIIIlIIIlIIlll != 369 && lllllllllllllIIIllIIIIlIIIlIIlll != 38 && lllllllllllllIIIllIIIIlIIIlIIlll != 124) {
            return 358;
        }
        return lllllllllllllIIIllIIIIlIIIlIIlll;
    }
    
    protected void incMaxLocals(final int lllllllllllllIIIllIIIlIllIIIllll) {
        this.bytecode.incMaxLocals(lllllllllllllIIIllIIIlIllIIIllll);
    }
    
    private void atIfStmnt(final Stmnt lllllllllllllIIIllIIIlIIlIlllIIl) throws CompileError {
        final ASTree lllllllllllllIIIllIIIlIIllIIIIII = lllllllllllllIIIllIIIlIIlIlllIIl.head();
        final Stmnt lllllllllllllIIIllIIIlIIlIllllll = (Stmnt)lllllllllllllIIIllIIIlIIlIlllIIl.tail().head();
        final Stmnt lllllllllllllIIIllIIIlIIlIlllllI = (Stmnt)lllllllllllllIIIllIIIlIIlIlllIIl.tail().tail().head();
        if (this.compileBooleanExpr(false, lllllllllllllIIIllIIIlIIllIIIIII)) {
            this.hasReturned = false;
            if (lllllllllllllIIIllIIIlIIlIlllllI != null) {
                lllllllllllllIIIllIIIlIIlIlllllI.accept(this);
            }
            return;
        }
        final int lllllllllllllIIIllIIIlIIlIllllIl = this.bytecode.currentPc();
        int lllllllllllllIIIllIIIlIIlIllllII = 0;
        this.bytecode.addIndex(0);
        this.hasReturned = false;
        if (lllllllllllllIIIllIIIlIIlIllllll != null) {
            lllllllllllllIIIllIIIlIIlIllllll.accept(this);
        }
        final boolean lllllllllllllIIIllIIIlIIlIlllIll = this.hasReturned;
        this.hasReturned = false;
        if (lllllllllllllIIIllIIIlIIlIlllllI != null && !lllllllllllllIIIllIIIlIIlIlllIll) {
            this.bytecode.addOpcode(167);
            lllllllllllllIIIllIIIlIIlIllllII = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
        }
        this.bytecode.write16bit(lllllllllllllIIIllIIIlIIlIllllIl, this.bytecode.currentPc() - lllllllllllllIIIllIIIlIIlIllllIl + 1);
        if (lllllllllllllIIIllIIIlIIlIlllllI != null) {
            lllllllllllllIIIllIIIlIIlIlllllI.accept(this);
            if (!lllllllllllllIIIllIIIlIIlIlllIll) {
                this.bytecode.write16bit(lllllllllllllIIIllIIIlIIlIllllII, this.bytecode.currentPc() - lllllllllllllIIIllIIIlIIlIllllII + 1);
            }
            this.hasReturned = (lllllllllllllIIIllIIIlIIlIlllIll && this.hasReturned);
        }
    }
    
    private void compareExpr(final boolean lllllllllllllIIIllIIIIlIIIIIlIIl, final int lllllllllllllIIIllIIIIlIIIIIlIII, final int lllllllllllllIIIllIIIIlIIIIIIlll, final BinExpr lllllllllllllIIIllIIIIlIIIIIIIII) throws CompileError {
        if (this.arrayDim == 0) {
            this.convertOprandTypes(lllllllllllllIIIllIIIIlIIIIIIlll, this.exprType, lllllllllllllIIIllIIIIlIIIIIIIII);
        }
        final int lllllllllllllIIIllIIIIlIIIIIIlIl = typePrecedence(this.exprType);
        if (lllllllllllllIIIllIIIIlIIIIIIlIl == -1 || this.arrayDim > 0) {
            if (lllllllllllllIIIllIIIIlIIIIIlIII == 358) {
                this.bytecode.addOpcode(lllllllllllllIIIllIIIIlIIIIIlIIl ? 165 : 166);
            }
            else if (lllllllllllllIIIllIIIIlIIIIIlIII == 350) {
                this.bytecode.addOpcode(lllllllllllllIIIllIIIIlIIIIIlIIl ? 166 : 165);
            }
            else {
                badTypes(lllllllllllllIIIllIIIIlIIIIIIIII);
            }
        }
        else if (lllllllllllllIIIllIIIIlIIIIIIlIl == 3) {
            final int[] lllllllllllllIIIllIIIIlIIIIIllIl = CodeGen.ifOp;
            for (int lllllllllllllIIIllIIIIlIIIIIlllI = 0; lllllllllllllIIIllIIIIlIIIIIlllI < lllllllllllllIIIllIIIIlIIIIIllIl.length; lllllllllllllIIIllIIIIlIIIIIlllI += 3) {
                if (lllllllllllllIIIllIIIIlIIIIIllIl[lllllllllllllIIIllIIIIlIIIIIlllI] == lllllllllllllIIIllIIIIlIIIIIlIII) {
                    this.bytecode.addOpcode(lllllllllllllIIIllIIIIlIIIIIllIl[lllllllllllllIIIllIIIIlIIIIIlllI + (lllllllllllllIIIllIIIIlIIIIIlIIl ? 1 : 2)]);
                    return;
                }
            }
            badTypes(lllllllllllllIIIllIIIIlIIIIIIIII);
        }
        else {
            if (lllllllllllllIIIllIIIIlIIIIIIlIl == 0) {
                if (lllllllllllllIIIllIIIIlIIIIIlIII == 60 || lllllllllllllIIIllIIIIlIIIIIlIII == 357) {
                    this.bytecode.addOpcode(152);
                }
                else {
                    this.bytecode.addOpcode(151);
                }
            }
            else if (lllllllllllllIIIllIIIIlIIIIIIlIl == 1) {
                if (lllllllllllllIIIllIIIIlIIIIIlIII == 60 || lllllllllllllIIIllIIIIlIIIIIlIII == 357) {
                    this.bytecode.addOpcode(150);
                }
                else {
                    this.bytecode.addOpcode(149);
                }
            }
            else if (lllllllllllllIIIllIIIIlIIIIIIlIl == 2) {
                this.bytecode.addOpcode(148);
            }
            else {
                fatal();
            }
            final int[] lllllllllllllIIIllIIIIlIIIIIlIll = CodeGen.ifOp2;
            for (int lllllllllllllIIIllIIIIlIIIIIllII = 0; lllllllllllllIIIllIIIIlIIIIIllII < lllllllllllllIIIllIIIIlIIIIIlIll.length; lllllllllllllIIIllIIIIlIIIIIllII += 3) {
                if (lllllllllllllIIIllIIIIlIIIIIlIll[lllllllllllllIIIllIIIIlIIIIIllII] == lllllllllllllIIIllIIIIlIIIIIlIII) {
                    this.bytecode.addOpcode(lllllllllllllIIIllIIIIlIIIIIlIll[lllllllllllllIIIllIIIIlIIIIIllII + (lllllllllllllIIIllIIIIlIIIIIlIIl ? 1 : 2)]);
                    return;
                }
            }
            badTypes(lllllllllllllIIIllIIIIlIIIIIIIII);
        }
    }
    
    private boolean booleanExpr(final boolean lllllllllllllIIIllIIIIlIIIlllllI, final ASTree lllllllllllllIIIllIIIIlIIIllllIl) throws CompileError {
        final int lllllllllllllIIIllIIIIlIIIllllII = getCompOperator(lllllllllllllIIIllIIIIlIIIllllIl);
        if (lllllllllllllIIIllIIIIlIIIllllII == 358) {
            final BinExpr lllllllllllllIIIllIIIIlIIlIIIlII = (BinExpr)lllllllllllllIIIllIIIIlIIIllllIl;
            final int lllllllllllllIIIllIIIIlIIlIIIIll = this.compileOprands(lllllllllllllIIIllIIIIlIIlIIIlII);
            this.compareExpr(lllllllllllllIIIllIIIIlIIIlllllI, lllllllllllllIIIllIIIIlIIlIIIlII.getOperator(), lllllllllllllIIIllIIIIlIIlIIIIll, lllllllllllllIIIllIIIIlIIlIIIlII);
        }
        else {
            if (lllllllllllllIIIllIIIIlIIIllllII == 33) {
                return this.booleanExpr(!lllllllllllllIIIllIIIIlIIIlllllI, ((Expr)lllllllllllllIIIllIIIIlIIIllllIl).oprand1());
            }
            final boolean lllllllllllllIIIllIIIIlIIlIIIIII;
            if ((lllllllllllllIIIllIIIIlIIlIIIIII = (lllllllllllllIIIllIIIIlIIIllllII == 369)) || lllllllllllllIIIllIIIIlIIIllllII == 368) {
                final BinExpr lllllllllllllIIIllIIIIlIIlIIIIlI = (BinExpr)lllllllllllllIIIllIIIIlIIIllllIl;
                if (this.booleanExpr(!lllllllllllllIIIllIIIIlIIlIIIIII, lllllllllllllIIIllIIIIlIIlIIIIlI.oprand1())) {
                    this.exprType = 301;
                    this.arrayDim = 0;
                    return true;
                }
                final int lllllllllllllIIIllIIIIlIIlIIIIIl = this.bytecode.currentPc();
                this.bytecode.addIndex(0);
                if (this.booleanExpr(lllllllllllllIIIllIIIIlIIlIIIIII, lllllllllllllIIIllIIIIlIIlIIIIlI.oprand2())) {
                    this.bytecode.addOpcode(167);
                }
                this.bytecode.write16bit(lllllllllllllIIIllIIIIlIIlIIIIIl, this.bytecode.currentPc() - lllllllllllllIIIllIIIIlIIlIIIIIl + 3);
                if (lllllllllllllIIIllIIIIlIIIlllllI != lllllllllllllIIIllIIIIlIIlIIIIII) {
                    this.bytecode.addIndex(6);
                    this.bytecode.addOpcode(167);
                }
            }
            else {
                if (isAlwaysBranch(lllllllllllllIIIllIIIIlIIIllllIl, lllllllllllllIIIllIIIIlIIIlllllI)) {
                    this.exprType = 301;
                    this.arrayDim = 0;
                    return true;
                }
                lllllllllllllIIIllIIIIlIIIllllIl.accept(this);
                if (this.exprType != 301 || this.arrayDim != 0) {
                    throw new CompileError("boolean expr is required");
                }
                this.bytecode.addOpcode(lllllllllllllIIIllIIIIlIIIlllllI ? 154 : 153);
            }
        }
        this.exprType = 301;
        this.arrayDim = 0;
        return false;
    }
    
    protected int getLocalVar(final Declarator lllllllllllllIIIllIIIlIlIlllllIl) {
        int lllllllllllllIIIllIIIlIlIllllIll = lllllllllllllIIIllIIIlIlIlllllIl.getLocalVar();
        if (lllllllllllllIIIllIIIlIlIllllIll < 0) {
            lllllllllllllIIIllIIIlIlIllllIll = this.getMaxLocals();
            lllllllllllllIIIllIIIlIlIlllllIl.setLocalVar(lllllllllllllIIIllIIIlIlIllllIll);
            this.incMaxLocals(1);
        }
        return lllllllllllllIIIllIIIlIlIllllIll;
    }
    
    @Override
    public void atSymbol(final Symbol lllllllllllllIIIllIIIlIlIIIIlIll) throws CompileError {
        fatal();
    }
    
    private void atBreakStmnt(final Stmnt lllllllllllllIIIllIIIIllllllIIll, final boolean lllllllllllllIIIllIIIIllllllIIlI) throws CompileError {
        if (lllllllllllllIIIllIIIIllllllIIll.head() != null) {
            throw new CompileError("sorry, not support labeled break or continue");
        }
        this.bytecode.addOpcode(167);
        final Integer lllllllllllllIIIllIIIIllllllIlIl = this.bytecode.currentPc();
        this.bytecode.addIndex(0);
        if (lllllllllllllIIIllIIIIllllllIIlI) {
            this.breakList.add(lllllllllllllIIIllIIIIllllllIlIl);
        }
        else {
            this.continueList.add(lllllllllllllIIIllIIIIllllllIlIl);
        }
    }
    
    private void atStringConcatExpr(final Expr lllllllllllllIIIllIIIIlIIllIIllI, final int lllllllllllllIIIllIIIIlIIllIIlIl, final int lllllllllllllIIIllIIIIlIIlIlllII, final String lllllllllllllIIIllIIIIlIIllIIIll) throws CompileError {
        final int lllllllllllllIIIllIIIIlIIllIIIlI = this.exprType;
        final int lllllllllllllIIIllIIIIlIIllIIIIl = this.arrayDim;
        final boolean lllllllllllllIIIllIIIIlIIllIIIII = is2word(lllllllllllllIIIllIIIIlIIllIIIlI, lllllllllllllIIIllIIIIlIIllIIIIl);
        final boolean lllllllllllllIIIllIIIIlIIlIlllll = lllllllllllllIIIllIIIIlIIllIIIlI == 307 && "java/lang/String".equals(this.className);
        if (lllllllllllllIIIllIIIIlIIllIIIII) {
            this.convToString(lllllllllllllIIIllIIIIlIIllIIIlI, lllllllllllllIIIllIIIIlIIllIIIIl);
        }
        if (is2word(lllllllllllllIIIllIIIIlIIllIIlIl, lllllllllllllIIIllIIIIlIIlIlllII)) {
            this.bytecode.addOpcode(91);
            this.bytecode.addOpcode(87);
        }
        else {
            this.bytecode.addOpcode(95);
        }
        this.convToString(lllllllllllllIIIllIIIIlIIllIIlIl, lllllllllllllIIIllIIIIlIIlIlllII);
        this.bytecode.addOpcode(95);
        if (!lllllllllllllIIIllIIIIlIIllIIIII && !lllllllllllllIIIllIIIIlIIlIlllll) {
            this.convToString(lllllllllllllIIIllIIIIlIIllIIIlI, lllllllllllllIIIllIIIIlIIllIIIIl);
        }
        this.bytecode.addInvokevirtual("java.lang.String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/String";
    }
    
    private void atForStmnt(final Stmnt lllllllllllllIIIllIIIlIIIllIllII) throws CompileError {
        final List<Integer> lllllllllllllIIIllIIIlIIIllIlIll = this.breakList;
        final List<Integer> lllllllllllllIIIllIIIlIIIllIlIlI = this.continueList;
        this.breakList = new ArrayList<Integer>();
        this.continueList = new ArrayList<Integer>();
        final Stmnt lllllllllllllIIIllIIIlIIIllIlIIl = (Stmnt)lllllllllllllIIIllIIIlIIIllIllII.head();
        ASTList lllllllllllllIIIllIIIlIIIllIlIII = lllllllllllllIIIllIIIlIIIllIllII.tail();
        final ASTree lllllllllllllIIIllIIIlIIIllIIlll = lllllllllllllIIIllIIIlIIIllIlIII.head();
        lllllllllllllIIIllIIIlIIIllIlIII = lllllllllllllIIIllIIIlIIIllIlIII.tail();
        final Stmnt lllllllllllllIIIllIIIlIIIllIIllI = (Stmnt)lllllllllllllIIIllIIIlIIIllIlIII.head();
        final Stmnt lllllllllllllIIIllIIIlIIIllIIlIl = (Stmnt)lllllllllllllIIIllIIIlIIIllIlIII.tail();
        if (lllllllllllllIIIllIIIlIIIllIlIIl != null) {
            lllllllllllllIIIllIIIlIIIllIlIIl.accept(this);
        }
        final int lllllllllllllIIIllIIIlIIIllIIlII = this.bytecode.currentPc();
        int lllllllllllllIIIllIIIlIIIllIIIll = 0;
        if (lllllllllllllIIIllIIIlIIIllIIlll != null) {
            if (this.compileBooleanExpr(false, lllllllllllllIIIllIIIlIIIllIIlll)) {
                this.continueList = lllllllllllllIIIllIIIlIIIllIlIlI;
                this.breakList = lllllllllllllIIIllIIIlIIIllIlIll;
                this.hasReturned = false;
                return;
            }
            lllllllllllllIIIllIIIlIIIllIIIll = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
        }
        if (lllllllllllllIIIllIIIlIIIllIIlIl != null) {
            lllllllllllllIIIllIIIlIIIllIIlIl.accept(this);
        }
        final int lllllllllllllIIIllIIIlIIIllIIIlI = this.bytecode.currentPc();
        if (lllllllllllllIIIllIIIlIIIllIIllI != null) {
            lllllllllllllIIIllIIIlIIIllIIllI.accept(this);
        }
        this.bytecode.addOpcode(167);
        this.bytecode.addIndex(lllllllllllllIIIllIIIlIIIllIIlII - this.bytecode.currentPc() + 1);
        final int lllllllllllllIIIllIIIlIIIllIIIIl = this.bytecode.currentPc();
        if (lllllllllllllIIIllIIIlIIIllIIlll != null) {
            this.bytecode.write16bit(lllllllllllllIIIllIIIlIIIllIIIll, lllllllllllllIIIllIIIlIIIllIIIIl - lllllllllllllIIIllIIIlIIIllIIIll + 1);
        }
        this.patchGoto(this.breakList, lllllllllllllIIIllIIIlIIIllIIIIl);
        this.patchGoto(this.continueList, lllllllllllllIIIllIIIlIIIllIIIlI);
        this.continueList = lllllllllllllIIIllIIIlIIIllIlIlI;
        this.breakList = lllllllllllllIIIllIIIlIIIllIlIll;
        this.hasReturned = false;
    }
    
    @Override
    public void atMethodDecl(final MethodDecl lllllllllllllIIIllIIIlIIllllllIl) throws CompileError {
        ASTList lllllllllllllIIIllIIIlIIllllllII = lllllllllllllIIIllIIIlIIllllllIl.getModifiers();
        this.setMaxLocals(1);
        while (lllllllllllllIIIllIIIlIIllllllII != null) {
            final Keyword lllllllllllllIIIllIIIlIIllllllll = (Keyword)lllllllllllllIIIllIIIlIIllllllII.head();
            lllllllllllllIIIllIIIlIIllllllII = lllllllllllllIIIllIIIlIIllllllII.tail();
            if (lllllllllllllIIIllIIIlIIllllllll.get() == 335) {
                this.setMaxLocals(0);
                this.inStaticMethod = true;
            }
        }
        for (ASTList lllllllllllllIIIllIIIlIIlllllIll = lllllllllllllIIIllIIIlIIllllllIl.getParams(); lllllllllllllIIIllIIIlIIlllllIll != null; lllllllllllllIIIllIIIlIIlllllIll = lllllllllllllIIIllIIIlIIlllllIll.tail()) {
            this.atDeclarator((Declarator)lllllllllllllIIIllIIIlIIlllllIll.head());
        }
        final Stmnt lllllllllllllIIIllIIIlIIlllllIlI = lllllllllllllIIIllIIIlIIllllllIl.getBody();
        this.atMethodBody(lllllllllllllIIIllIIIlIIlllllIlI, lllllllllllllIIIllIIIlIIllllllIl.isConstructor(), lllllllllllllIIIllIIIlIIllllllIl.getReturn().getType() == 344);
    }
    
    private void convToString(final int lllllllllllllIIIllIIIIlIIlIIlllI, final int lllllllllllllIIIllIIIIlIIlIIllIl) throws CompileError {
        final String lllllllllllllIIIllIIIIlIIlIlIIII = "valueOf";
        if (isRefType(lllllllllllllIIIllIIIIlIIlIIlllI) || lllllllllllllIIIllIIIIlIIlIIllIl > 0) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(Ljava/lang/Object;)Ljava/lang/String;");
        }
        else if (lllllllllllllIIIllIIIIlIIlIIlllI == 312) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(D)Ljava/lang/String;");
        }
        else if (lllllllllllllIIIllIIIIlIIlIIlllI == 317) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(F)Ljava/lang/String;");
        }
        else if (lllllllllllllIIIllIIIIlIIlIIlllI == 326) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(J)Ljava/lang/String;");
        }
        else if (lllllllllllllIIIllIIIIlIIlIIlllI == 301) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(Z)Ljava/lang/String;");
        }
        else if (lllllllllllllIIIllIIIIlIIlIIlllI == 306) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(C)Ljava/lang/String;");
        }
        else {
            if (lllllllllllllIIIllIIIIlIIlIIlllI == 344) {
                throw new CompileError("void type expression");
            }
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(I)Ljava/lang/String;");
        }
    }
    
    @Override
    public void atExpr(final Expr lllllllllllllIIIllIIIIIlIlIlIlll) throws CompileError {
        final int lllllllllllllIIIllIIIIIlIlIlIllI = lllllllllllllIIIllIIIIIlIlIlIlll.getOperator();
        final ASTree lllllllllllllIIIllIIIIIlIlIlIlIl = lllllllllllllIIIllIIIIIlIlIlIlll.oprand1();
        if (lllllllllllllIIIllIIIIIlIlIlIllI == 46) {
            final String lllllllllllllIIIllIIIIIlIlIllIlI = ((Symbol)lllllllllllllIIIllIIIIIlIlIlIlll.oprand2()).get();
            if (lllllllllllllIIIllIIIIIlIlIllIlI.equals("class")) {
                this.atClassObject(lllllllllllllIIIllIIIIIlIlIlIlll);
            }
            else {
                this.atFieldRead(lllllllllllllIIIllIIIIIlIlIlIlll);
            }
        }
        else if (lllllllllllllIIIllIIIIIlIlIlIllI == 35) {
            this.atFieldRead(lllllllllllllIIIllIIIIIlIlIlIlll);
        }
        else if (lllllllllllllIIIllIIIIIlIlIlIllI == 65) {
            this.atArrayRead(lllllllllllllIIIllIIIIIlIlIlIlIl, lllllllllllllIIIllIIIIIlIlIlIlll.oprand2());
        }
        else if (lllllllllllllIIIllIIIIIlIlIlIllI == 362 || lllllllllllllIIIllIIIIIlIlIlIllI == 363) {
            this.atPlusPlus(lllllllllllllIIIllIIIIIlIlIlIllI, lllllllllllllIIIllIIIIIlIlIlIlIl, lllllllllllllIIIllIIIIIlIlIlIlll, true);
        }
        else if (lllllllllllllIIIllIIIIIlIlIlIllI == 33) {
            if (!this.booleanExpr(false, lllllllllllllIIIllIIIIIlIlIlIlll)) {
                this.bytecode.addIndex(7);
                this.bytecode.addIconst(1);
                this.bytecode.addOpcode(167);
                this.bytecode.addIndex(4);
            }
            this.bytecode.addIconst(0);
        }
        else if (lllllllllllllIIIllIIIIIlIlIlIllI == 67) {
            fatal();
        }
        else {
            lllllllllllllIIIllIIIIIlIlIlIlll.oprand1().accept(this);
            final int lllllllllllllIIIllIIIIIlIlIllIIl = typePrecedence(this.exprType);
            if (this.arrayDim > 0) {
                badType(lllllllllllllIIIllIIIIIlIlIlIlll);
            }
            if (lllllllllllllIIIllIIIIIlIlIlIllI == 45) {
                if (lllllllllllllIIIllIIIIIlIlIllIIl == 0) {
                    this.bytecode.addOpcode(119);
                }
                else if (lllllllllllllIIIllIIIIIlIlIllIIl == 1) {
                    this.bytecode.addOpcode(118);
                }
                else if (lllllllllllllIIIllIIIIIlIlIllIIl == 2) {
                    this.bytecode.addOpcode(117);
                }
                else if (lllllllllllllIIIllIIIIIlIlIllIIl == 3) {
                    this.bytecode.addOpcode(116);
                    this.exprType = 324;
                }
                else {
                    badType(lllllllllllllIIIllIIIIIlIlIlIlll);
                }
            }
            else if (lllllllllllllIIIllIIIIIlIlIlIllI == 126) {
                if (lllllllllllllIIIllIIIIIlIlIllIIl == 3) {
                    this.bytecode.addIconst(-1);
                    this.bytecode.addOpcode(130);
                    this.exprType = 324;
                }
                else if (lllllllllllllIIIllIIIIIlIlIllIIl == 2) {
                    this.bytecode.addLconst(-1L);
                    this.bytecode.addOpcode(131);
                }
                else {
                    badType(lllllllllllllIIIllIIIIIlIlIlIlll);
                }
            }
            else if (lllllllllllllIIIllIIIIIlIlIlIllI == 43) {
                if (lllllllllllllIIIllIIIIIlIlIllIIl == -1) {
                    badType(lllllllllllllIIIllIIIIIlIlIlIlll);
                }
            }
            else {
                fatal();
            }
        }
    }
    
    protected abstract void atFieldPlusPlus(final int p0, final boolean p1, final ASTree p2, final Expr p3, final boolean p4) throws CompileError;
    
    public void setMaxLocals(final int lllllllllllllIIIllIIIlIllIIlllII) {
        this.bytecode.setMaxLocals(lllllllllllllIIIllIIIlIllIIlllII);
    }
    
    static {
        P_DOUBLE = 0;
        P_LONG = 2;
        P_FLOAT = 1;
        jvmJavaLangObject = "java/lang/Object";
        javaLangObject = "java.lang.Object";
        jvmJavaLangString = "java/lang/String";
        P_INT = 3;
        P_OTHER = -1;
        javaLangString = "java.lang.String";
        binOp = new int[] { 43, 99, 98, 97, 96, 45, 103, 102, 101, 100, 42, 107, 106, 105, 104, 47, 111, 110, 109, 108, 37, 115, 114, 113, 112, 124, 0, 0, 129, 128, 94, 0, 0, 131, 130, 38, 0, 0, 127, 126, 364, 0, 0, 121, 120, 366, 0, 0, 123, 122, 370, 0, 0, 125, 124 };
        ifOp = new int[] { 358, 159, 160, 350, 160, 159, 357, 164, 163, 359, 162, 161, 60, 161, 162, 62, 163, 164 };
        ifOp2 = new int[] { 358, 153, 154, 350, 154, 153, 357, 158, 157, 359, 156, 155, 60, 155, 156, 62, 157, 158 };
        castOp = new int[] { 0, 144, 143, 142, 141, 0, 140, 139, 138, 137, 0, 136, 135, 134, 133, 0 };
    }
    
    private void atSwitchStmnt(final Stmnt lllllllllllllIIIllIIIlIIIIlIIllI) throws CompileError {
        boolean lllllllllllllIIIllIIIlIIIIllIlIl = false;
        if (this.typeChecker != null) {
            this.doTypeCheck(lllllllllllllIIIllIIIlIIIIlIIllI.head());
            lllllllllllllIIIllIIIlIIIIllIlIl = (this.typeChecker.exprType == 307 && this.typeChecker.arrayDim == 0 && "java/lang/String".equals(this.typeChecker.className));
        }
        this.compileExpr(lllllllllllllIIIllIIIlIIIIlIIllI.head());
        int lllllllllllllIIIllIIIlIIIIllIlII = -1;
        if (lllllllllllllIIIllIIIlIIIIllIlIl) {
            lllllllllllllIIIllIIIlIIIIllIlII = this.getMaxLocals();
            this.incMaxLocals(1);
            this.bytecode.addAstore(lllllllllllllIIIllIIIlIIIIllIlII);
            this.bytecode.addAload(lllllllllllllIIIllIIIlIIIIllIlII);
            this.bytecode.addInvokevirtual("java/lang/String", "hashCode", "()I");
        }
        final List<Integer> lllllllllllllIIIllIIIlIIIIllIIll = this.breakList;
        this.breakList = new ArrayList<Integer>();
        final int lllllllllllllIIIllIIIlIIIIllIIlI = this.bytecode.currentPc();
        this.bytecode.addOpcode(171);
        int lllllllllllllIIIllIIIlIIIIllIIIl = 3 - (lllllllllllllIIIllIIIlIIIIllIIlI & 0x3);
        while (lllllllllllllIIIllIIIlIIIIllIIIl-- > 0) {
            this.bytecode.add(0);
        }
        final Stmnt lllllllllllllIIIllIIIlIIIIllIIII = (Stmnt)lllllllllllllIIIllIIIlIIIIlIIllI.tail();
        int lllllllllllllIIIllIIIlIIIIlIllll = 0;
        for (ASTList lllllllllllllIIIllIIIlIIIlIIIIII = lllllllllllllIIIllIIIlIIIIllIIII; lllllllllllllIIIllIIIlIIIlIIIIII != null; lllllllllllllIIIllIIIlIIIlIIIIII = lllllllllllllIIIllIIIlIIIlIIIIII.tail()) {
            if (((Stmnt)lllllllllllllIIIllIIIlIIIlIIIIII.head()).getOperator() == 304) {
                ++lllllllllllllIIIllIIIlIIIIlIllll;
            }
        }
        final int lllllllllllllIIIllIIIlIIIIlIlllI = this.bytecode.currentPc();
        this.bytecode.addGap(4);
        this.bytecode.add32bit(lllllllllllllIIIllIIIlIIIIlIllll);
        this.bytecode.addGap(lllllllllllllIIIllIIIlIIIIlIllll * 8);
        final long[] lllllllllllllIIIllIIIlIIIIlIllIl = new long[lllllllllllllIIIllIIIlIIIIlIllll];
        final ArrayList<Integer> lllllllllllllIIIllIIIlIIIIlIllII = new ArrayList<Integer>();
        int lllllllllllllIIIllIIIlIIIIlIlIll = 0;
        int lllllllllllllIIIllIIIlIIIIlIlIlI = -1;
        for (ASTList lllllllllllllIIIllIIIlIIIIlllIlI = lllllllllllllIIIllIIIlIIIIllIIII; lllllllllllllIIIllIIIlIIIIlllIlI != null; lllllllllllllIIIllIIIlIIIIlllIlI = lllllllllllllIIIllIIIlIIIIlllIlI.tail()) {
            final Stmnt lllllllllllllIIIllIIIlIIIIllllII = (Stmnt)lllllllllllllIIIllIIIlIIIIlllIlI.head();
            final int lllllllllllllIIIllIIIlIIIIlllIll = lllllllllllllIIIllIIIlIIIIllllII.getOperator();
            if (lllllllllllllIIIllIIIlIIIIlllIll == 310) {
                lllllllllllllIIIllIIIlIIIIlIlIlI = this.bytecode.currentPc();
            }
            else if (lllllllllllllIIIllIIIlIIIIlllIll != 304) {
                fatal();
            }
            else {
                final int lllllllllllllIIIllIIIlIIIIlllllI = this.bytecode.currentPc();
                long lllllllllllllIIIllIIIlIIIIllllIl = 0L;
                if (lllllllllllllIIIllIIIlIIIIllIlIl) {
                    final long lllllllllllllIIIllIIIlIIIIllllll = this.computeStringLabel(lllllllllllllIIIllIIIlIIIIllllII.head(), lllllllllllllIIIllIIIlIIIIllIlII, lllllllllllllIIIllIIIlIIIIlIllII);
                }
                else {
                    lllllllllllllIIIllIIIlIIIIllllIl = this.computeLabel(lllllllllllllIIIllIIIlIIIIllllII.head());
                }
                lllllllllllllIIIllIIIlIIIIlIllIl[lllllllllllllIIIllIIIlIIIIlIlIll++] = (lllllllllllllIIIllIIIlIIIIllllIl << 32) + ((long)(lllllllllllllIIIllIIIlIIIIlllllI - lllllllllllllIIIllIIIlIIIIllIIlI) & -1L);
            }
            this.hasReturned = false;
            ((Stmnt)lllllllllllllIIIllIIIlIIIIllllII.tail()).accept(this);
        }
        Arrays.sort(lllllllllllllIIIllIIIlIIIIlIllIl);
        int lllllllllllllIIIllIIIlIIIIlIlIIl = lllllllllllllIIIllIIIlIIIIlIlllI + 8;
        for (int lllllllllllllIIIllIIIlIIIIlllIIl = 0; lllllllllllllIIIllIIIlIIIIlllIIl < lllllllllllllIIIllIIIlIIIIlIllll; ++lllllllllllllIIIllIIIlIIIIlllIIl) {
            this.bytecode.write32bit(lllllllllllllIIIllIIIlIIIIlIlIIl, (int)(lllllllllllllIIIllIIIlIIIIlIllIl[lllllllllllllIIIllIIIlIIIIlllIIl] >>> 32));
            this.bytecode.write32bit(lllllllllllllIIIllIIIlIIIIlIlIIl + 4, (int)lllllllllllllIIIllIIIlIIIIlIllIl[lllllllllllllIIIllIIIlIIIIlllIIl]);
            lllllllllllllIIIllIIIlIIIIlIlIIl += 8;
        }
        if (lllllllllllllIIIllIIIlIIIIlIlIlI < 0 || this.breakList.size() > 0) {
            this.hasReturned = false;
        }
        final int lllllllllllllIIIllIIIlIIIIlIlIII = this.bytecode.currentPc();
        if (lllllllllllllIIIllIIIlIIIIlIlIlI < 0) {
            lllllllllllllIIIllIIIlIIIIlIlIlI = lllllllllllllIIIllIIIlIIIIlIlIII;
        }
        this.bytecode.write32bit(lllllllllllllIIIllIIIlIIIIlIlllI, lllllllllllllIIIllIIIlIIIIlIlIlI - lllllllllllllIIIllIIIlIIIIllIIlI);
        for (final int lllllllllllllIIIllIIIlIIIIlllIII : lllllllllllllIIIllIIIlIIIIlIllII) {
            this.bytecode.write16bit(lllllllllllllIIIllIIIlIIIIlllIII, lllllllllllllIIIllIIIlIIIIlIlIlI - lllllllllllllIIIllIIIlIIIIlllIII + 1);
        }
        this.patchGoto(this.breakList, lllllllllllllIIIllIIIlIIIIlIlIII);
        this.breakList = lllllllllllllIIIllIIIlIIIIllIIll;
    }
    
    @Override
    public void atStmnt(final Stmnt lllllllllllllIIIllIIIlIIllIlIIIl) throws CompileError {
        if (lllllllllllllIIIllIIIlIIllIlIIIl == null) {
            return;
        }
        final int lllllllllllllIIIllIIIlIIllIlIIII = lllllllllllllIIIllIIIlIIllIlIIIl.getOperator();
        if (lllllllllllllIIIllIIIlIIllIlIIII == 69) {
            final ASTree lllllllllllllIIIllIIIlIIllIlIlIl = lllllllllllllIIIllIIIlIIllIlIIIl.getLeft();
            this.doTypeCheck(lllllllllllllIIIllIIIlIIllIlIlIl);
            if (lllllllllllllIIIllIIIlIIllIlIlIl instanceof AssignExpr) {
                this.atAssignExpr((AssignExpr)lllllllllllllIIIllIIIlIIllIlIlIl, false);
            }
            else if (isPlusPlusExpr(lllllllllllllIIIllIIIlIIllIlIlIl)) {
                final Expr lllllllllllllIIIllIIIlIIllIlIllI = (Expr)lllllllllllllIIIllIIIlIIllIlIlIl;
                this.atPlusPlus(lllllllllllllIIIllIIIlIIllIlIllI.getOperator(), lllllllllllllIIIllIIIlIIllIlIllI.oprand1(), lllllllllllllIIIllIIIlIIllIlIllI, false);
            }
            else {
                lllllllllllllIIIllIIIlIIllIlIlIl.accept(this);
                if (is2word(this.exprType, this.arrayDim)) {
                    this.bytecode.addOpcode(88);
                }
                else if (this.exprType != 344) {
                    this.bytecode.addOpcode(87);
                }
            }
        }
        else if (lllllllllllllIIIllIIIlIIllIlIIII == 68 || lllllllllllllIIIllIIIlIIllIlIIII == 66) {
            ASTList lllllllllllllIIIllIIIlIIllIlIIll = lllllllllllllIIIllIIIlIIllIlIIIl;
            while (lllllllllllllIIIllIIIlIIllIlIIll != null) {
                final ASTree lllllllllllllIIIllIIIlIIllIlIlII = lllllllllllllIIIllIIIlIIllIlIIll.head();
                lllllllllllllIIIllIIIlIIllIlIIll = lllllllllllllIIIllIIIlIIllIlIIll.tail();
                if (lllllllllllllIIIllIIIlIIllIlIlII != null) {
                    lllllllllllllIIIllIIIlIIllIlIlII.accept(this);
                }
            }
        }
        else if (lllllllllllllIIIllIIIlIIllIlIIII == 320) {
            this.atIfStmnt(lllllllllllllIIIllIIIlIIllIlIIIl);
        }
        else if (lllllllllllllIIIllIIIlIIllIlIIII == 346 || lllllllllllllIIIllIIIlIIllIlIIII == 311) {
            this.atWhileStmnt(lllllllllllllIIIllIIIlIIllIlIIIl, lllllllllllllIIIllIIIlIIllIlIIII == 346);
        }
        else if (lllllllllllllIIIllIIIlIIllIlIIII == 318) {
            this.atForStmnt(lllllllllllllIIIllIIIlIIllIlIIIl);
        }
        else if (lllllllllllllIIIllIIIlIIllIlIIII == 302 || lllllllllllllIIIllIIIlIIllIlIIII == 309) {
            this.atBreakStmnt(lllllllllllllIIIllIIIlIIllIlIIIl, lllllllllllllIIIllIIIlIIllIlIIII == 302);
        }
        else if (lllllllllllllIIIllIIIlIIllIlIIII == 333) {
            this.atReturnStmnt(lllllllllllllIIIllIIIlIIllIlIIIl);
        }
        else if (lllllllllllllIIIllIIIlIIllIlIIII == 340) {
            this.atThrowStmnt(lllllllllllllIIIllIIIlIIllIlIIIl);
        }
        else if (lllllllllllllIIIllIIIlIIllIlIIII == 343) {
            this.atTryStmnt(lllllllllllllIIIllIIIlIIllIlIIIl);
        }
        else if (lllllllllllllIIIllIIIlIIllIlIIII == 337) {
            this.atSwitchStmnt(lllllllllllllIIIllIIIlIIllIlIIIl);
        }
        else {
            if (lllllllllllllIIIllIIIlIIllIlIIII != 338) {
                this.hasReturned = false;
                throw new CompileError(String.valueOf(new StringBuilder().append("sorry, not supported statement: TokenId ").append(lllllllllllllIIIllIIIlIIllIlIIII)));
            }
            this.atSyncStmnt(lllllllllllllIIIllIIIlIIllIlIIIl);
        }
    }
    
    protected static void badTypes(final Expr lllllllllllllIIIllIIIIIllllllIll) throws CompileError {
        throw new CompileError(String.valueOf(new StringBuilder().append("invalid types for ").append(lllllllllllllIIIllIIIIIllllllIll.getName())));
    }
    
    private int computeStringLabel(ASTree lllllllllllllIIIllIIIlIIIIIIIlIl, final int lllllllllllllIIIllIIIlIIIIIIIIII, final List<Integer> lllllllllllllIIIllIIIIllllllllll) throws CompileError {
        this.doTypeCheck(lllllllllllllIIIllIIIlIIIIIIIlIl);
        lllllllllllllIIIllIIIlIIIIIIIlIl = TypeChecker.stripPlusExpr(lllllllllllllIIIllIIIlIIIIIIIlIl);
        if (lllllllllllllIIIllIIIlIIIIIIIlIl instanceof StringL) {
            final String lllllllllllllIIIllIIIlIIIIIIlIII = ((StringL)lllllllllllllIIIllIIIlIIIIIIIlIl).get();
            this.bytecode.addAload(lllllllllllllIIIllIIIlIIIIIIIIII);
            this.bytecode.addLdc(lllllllllllllIIIllIIIlIIIIIIlIII);
            this.bytecode.addInvokevirtual("java/lang/String", "equals", "(Ljava/lang/Object;)Z");
            this.bytecode.addOpcode(153);
            final Integer lllllllllllllIIIllIIIlIIIIIIIlll = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
            lllllllllllllIIIllIIIIllllllllll.add(lllllllllllllIIIllIIIlIIIIIIIlll);
            return lllllllllllllIIIllIIIlIIIIIIlIII.hashCode();
        }
        throw new CompileError("bad case label");
    }
    
    @Override
    public void atVariable(final Variable lllllllllllllIIIllIIIIIIlIlIllIl) throws CompileError {
        final Declarator lllllllllllllIIIllIIIIIIlIlIllII = lllllllllllllIIIllIIIIIIlIlIllIl.getDeclarator();
        this.exprType = lllllllllllllIIIllIIIIIIlIlIllII.getType();
        this.arrayDim = lllllllllllllIIIllIIIIIIlIlIllII.getArrayDim();
        this.className = lllllllllllllIIIllIIIIIIlIlIllII.getClassName();
        final int lllllllllllllIIIllIIIIIIlIlIlIll = this.getLocalVar(lllllllllllllIIIllIIIIIIlIlIllII);
        if (this.arrayDim > 0) {
            this.bytecode.addAload(lllllllllllllIIIllIIIIIIlIlIlIll);
        }
        else {
            switch (this.exprType) {
                case 307: {
                    this.bytecode.addAload(lllllllllllllIIIllIIIIIIlIlIlIll);
                    break;
                }
                case 326: {
                    this.bytecode.addLload(lllllllllllllIIIllIIIIIIlIlIlIll);
                    break;
                }
                case 317: {
                    this.bytecode.addFload(lllllllllllllIIIllIIIIIIlIlIlIll);
                    break;
                }
                case 312: {
                    this.bytecode.addDload(lllllllllllllIIIllIIIIIIlIlIlIll);
                    break;
                }
                default: {
                    this.bytecode.addIload(lllllllllllllIIIllIIIIIIlIlIlIll);
                    break;
                }
            }
        }
    }
    
    protected static void fatal() throws CompileError {
        throw new CompileError("fatal");
    }
    
    protected static int getArrayReadOp(final int lllllllllllllIIIllIIIIIlIIIIIllI, final int lllllllllllllIIIllIIIIIlIIIIIlIl) {
        if (lllllllllllllIIIllIIIIIlIIIIIlIl > 0) {
            return 50;
        }
        switch (lllllllllllllIIIllIIIIIlIIIIIllI) {
            case 312: {
                return 49;
            }
            case 317: {
                return 48;
            }
            case 326: {
                return 47;
            }
            case 324: {
                return 46;
            }
            case 334: {
                return 53;
            }
            case 306: {
                return 52;
            }
            case 301:
            case 303: {
                return 51;
            }
            default: {
                return 50;
            }
        }
    }
    
    protected void atClassObject2(final String lllllllllllllIIIllIIIIIlIIlIlIIl) throws CompileError {
        final int lllllllllllllIIIllIIIIIlIIlIllIl = this.bytecode.currentPc();
        this.bytecode.addLdc(lllllllllllllIIIllIIIIIlIIlIlIIl);
        this.bytecode.addInvokestatic("java.lang.Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        final int lllllllllllllIIIllIIIIIlIIlIllII = this.bytecode.currentPc();
        this.bytecode.addOpcode(167);
        final int lllllllllllllIIIllIIIIIlIIlIlIll = this.bytecode.currentPc();
        this.bytecode.addIndex(0);
        this.bytecode.addExceptionHandler(lllllllllllllIIIllIIIIIlIIlIllIl, lllllllllllllIIIllIIIIIlIIlIllII, this.bytecode.currentPc(), "java.lang.ClassNotFoundException");
        this.bytecode.growStack(1);
        this.bytecode.addInvokestatic("com.viaversion.viaversion.libs.javassist.runtime.DotClass", "fail", "(Ljava/lang/ClassNotFoundException;)Ljava/lang/NoClassDefFoundError;");
        this.bytecode.addOpcode(191);
        this.bytecode.write16bit(lllllllllllllIIIllIIIIIlIIlIlIll, this.bytecode.currentPc() - lllllllllllllIIIllIIIIIlIIlIlIll + 1);
    }
    
    protected abstract String getThisName();
    
    public static boolean is2word(final int lllllllllllllIIIllIIIlIllIllIlII, final int lllllllllllllIIIllIIIlIllIllIIlI) {
        return lllllllllllllIIIllIIIlIllIllIIlI == 0 && (lllllllllllllIIIllIIIlIllIllIlII == 312 || lllllllllllllIIIllIIIlIllIllIlII == 326);
    }
    
    private static boolean isAlwaysBranch(final ASTree lllllllllllllIIIllIIIIlIIIlIlllI, final boolean lllllllllllllIIIllIIIIlIIIlIllll) {
        if (lllllllllllllIIIllIIIIlIIIlIlllI instanceof Keyword) {
            final int lllllllllllllIIIllIIIIlIIIllIIIl = ((Keyword)lllllllllllllIIIllIIIIlIIIlIlllI).get();
            return lllllllllllllIIIllIIIIlIIIlIllll ? (lllllllllllllIIIllIIIIlIIIllIIIl == 410) : (lllllllllllllIIIllIIIIlIIIllIIIl == 411);
        }
        return false;
    }
    
    public void atArrayPlusPlus(final int lllllllllllllIIIllIIIIIIllIlIllI, final boolean lllllllllllllIIIllIIIIIIllIIllIl, final Expr lllllllllllllIIIllIIIIIIllIlIlII, final boolean lllllllllllllIIIllIIIIIIllIlIIll) throws CompileError {
        this.arrayAccess(lllllllllllllIIIllIIIIIIllIlIlII.oprand1(), lllllllllllllIIIllIIIIIIllIlIlII.oprand2());
        final int lllllllllllllIIIllIIIIIIllIlIIlI = this.exprType;
        final int lllllllllllllIIIllIIIIIIllIlIIIl = this.arrayDim;
        if (lllllllllllllIIIllIIIIIIllIlIIIl > 0) {
            badType(lllllllllllllIIIllIIIIIIllIlIlII);
        }
        this.bytecode.addOpcode(92);
        this.bytecode.addOpcode(getArrayReadOp(lllllllllllllIIIllIIIIIIllIlIIlI, this.arrayDim));
        final int lllllllllllllIIIllIIIIIIllIlIIII = is2word(lllllllllllllIIIllIIIIIIllIlIIlI, lllllllllllllIIIllIIIIIIllIlIIIl) ? 94 : 91;
        this.atPlusPlusCore(lllllllllllllIIIllIIIIIIllIlIIII, lllllllllllllIIIllIIIIIIllIlIIll, lllllllllllllIIIllIIIIIIllIlIllI, lllllllllllllIIIllIIIIIIllIIllIl, lllllllllllllIIIllIIIIIIllIlIlII);
        this.bytecode.addOpcode(getArrayWriteOp(lllllllllllllIIIllIIIIIIllIlIIlI, lllllllllllllIIIllIIIIIIllIlIIIl));
    }
    
    protected void atAssignCore(final Expr lllllllllllllIIIllIIIIlIllllIIII, final int lllllllllllllIIIllIIIIlIlllIlIII, final ASTree lllllllllllllIIIllIIIIlIlllIlllI, final int lllllllllllllIIIllIIIIlIlllIIllI, final int lllllllllllllIIIllIIIIlIlllIllII, final String lllllllllllllIIIllIIIIlIlllIIlII) throws CompileError {
        if (lllllllllllllIIIllIIIIlIlllIlIII == 354 && lllllllllllllIIIllIIIIlIlllIllII == 0 && lllllllllllllIIIllIIIIlIlllIIllI == 307) {
            this.atStringPlusEq(lllllllllllllIIIllIIIIlIllllIIII, lllllllllllllIIIllIIIIlIlllIIllI, lllllllllllllIIIllIIIIlIlllIllII, lllllllllllllIIIllIIIIlIlllIIlII, lllllllllllllIIIllIIIIlIlllIlllI);
        }
        else {
            lllllllllllllIIIllIIIIlIlllIlllI.accept(this);
            if (this.invalidDim(this.exprType, this.arrayDim, this.className, lllllllllllllIIIllIIIIlIlllIIllI, lllllllllllllIIIllIIIIlIlllIllII, lllllllllllllIIIllIIIIlIlllIIlII, false) || (lllllllllllllIIIllIIIIlIlllIlIII != 61 && lllllllllllllIIIllIIIIlIlllIllII > 0)) {
                badAssign(lllllllllllllIIIllIIIIlIllllIIII);
            }
            if (lllllllllllllIIIllIIIIlIlllIlIII != 61) {
                final int lllllllllllllIIIllIIIIlIllllIIll = CodeGen.assignOps[lllllllllllllIIIllIIIIlIlllIlIII - 351];
                final int lllllllllllllIIIllIIIIlIllllIIlI = lookupBinOp(lllllllllllllIIIllIIIIlIllllIIll);
                if (lllllllllllllIIIllIIIIlIllllIIlI < 0) {
                    fatal();
                }
                this.atArithBinExpr(lllllllllllllIIIllIIIIlIllllIIII, lllllllllllllIIIllIIIIlIllllIIll, lllllllllllllIIIllIIIIlIllllIIlI, lllllllllllllIIIllIIIIlIlllIIllI);
            }
        }
        if (lllllllllllllIIIllIIIIlIlllIlIII != 61 || (lllllllllllllIIIllIIIIlIlllIllII == 0 && !isRefType(lllllllllllllIIIllIIIIlIlllIIllI))) {
            this.atNumCastExpr(this.exprType, lllllllllllllIIIllIIIIlIlllIIllI);
        }
    }
    
    private void atPlusPlus(final int lllllllllllllIIIllIIIIIIlllIlllI, ASTree lllllllllllllIIIllIIIIIIlllIIlll, final Expr lllllllllllllIIIllIIIIIIlllIllII, final boolean lllllllllllllIIIllIIIIIIlllIlIll) throws CompileError {
        final boolean lllllllllllllIIIllIIIIIIlllIlIlI = lllllllllllllIIIllIIIIIIlllIIlll == null;
        if (lllllllllllllIIIllIIIIIIlllIlIlI) {
            lllllllllllllIIIllIIIIIIlllIIlll = lllllllllllllIIIllIIIIIIlllIllII.oprand2();
        }
        if (lllllllllllllIIIllIIIIIIlllIIlll instanceof Variable) {
            final Declarator lllllllllllllIIIllIIIIIIllllIIll = ((Variable)lllllllllllllIIIllIIIIIIlllIIlll).getDeclarator();
            final int type = lllllllllllllIIIllIIIIIIllllIIll.getType();
            this.exprType = type;
            final int lllllllllllllIIIllIIIIIIllllIIlI = type;
            this.arrayDim = lllllllllllllIIIllIIIIIIllllIIll.getArrayDim();
            final int lllllllllllllIIIllIIIIIIllllIIIl = this.getLocalVar(lllllllllllllIIIllIIIIIIllllIIll);
            if (this.arrayDim > 0) {
                badType(lllllllllllllIIIllIIIIIIlllIllII);
            }
            if (lllllllllllllIIIllIIIIIIllllIIlI == 312) {
                this.bytecode.addDload(lllllllllllllIIIllIIIIIIllllIIIl);
                if (lllllllllllllIIIllIIIIIIlllIlIll && lllllllllllllIIIllIIIIIIlllIlIlI) {
                    this.bytecode.addOpcode(92);
                }
                this.bytecode.addDconst(1.0);
                this.bytecode.addOpcode((lllllllllllllIIIllIIIIIIlllIlllI == 362) ? 99 : 103);
                if (lllllllllllllIIIllIIIIIIlllIlIll && !lllllllllllllIIIllIIIIIIlllIlIlI) {
                    this.bytecode.addOpcode(92);
                }
                this.bytecode.addDstore(lllllllllllllIIIllIIIIIIllllIIIl);
            }
            else if (lllllllllllllIIIllIIIIIIllllIIlI == 326) {
                this.bytecode.addLload(lllllllllllllIIIllIIIIIIllllIIIl);
                if (lllllllllllllIIIllIIIIIIlllIlIll && lllllllllllllIIIllIIIIIIlllIlIlI) {
                    this.bytecode.addOpcode(92);
                }
                this.bytecode.addLconst(1L);
                this.bytecode.addOpcode((lllllllllllllIIIllIIIIIIlllIlllI == 362) ? 97 : 101);
                if (lllllllllllllIIIllIIIIIIlllIlIll && !lllllllllllllIIIllIIIIIIlllIlIlI) {
                    this.bytecode.addOpcode(92);
                }
                this.bytecode.addLstore(lllllllllllllIIIllIIIIIIllllIIIl);
            }
            else if (lllllllllllllIIIllIIIIIIllllIIlI == 317) {
                this.bytecode.addFload(lllllllllllllIIIllIIIIIIllllIIIl);
                if (lllllllllllllIIIllIIIIIIlllIlIll && lllllllllllllIIIllIIIIIIlllIlIlI) {
                    this.bytecode.addOpcode(89);
                }
                this.bytecode.addFconst(1.0f);
                this.bytecode.addOpcode((lllllllllllllIIIllIIIIIIlllIlllI == 362) ? 98 : 102);
                if (lllllllllllllIIIllIIIIIIlllIlIll && !lllllllllllllIIIllIIIIIIlllIlIlI) {
                    this.bytecode.addOpcode(89);
                }
                this.bytecode.addFstore(lllllllllllllIIIllIIIIIIllllIIIl);
            }
            else if (lllllllllllllIIIllIIIIIIllllIIlI == 303 || lllllllllllllIIIllIIIIIIllllIIlI == 306 || lllllllllllllIIIllIIIIIIllllIIlI == 334 || lllllllllllllIIIllIIIIIIllllIIlI == 324) {
                if (lllllllllllllIIIllIIIIIIlllIlIll && lllllllllllllIIIllIIIIIIlllIlIlI) {
                    this.bytecode.addIload(lllllllllllllIIIllIIIIIIllllIIIl);
                }
                final int lllllllllllllIIIllIIIIIIllllIlII = (lllllllllllllIIIllIIIIIIlllIlllI == 362) ? 1 : -1;
                if (lllllllllllllIIIllIIIIIIllllIIIl > 255) {
                    this.bytecode.addOpcode(196);
                    this.bytecode.addOpcode(132);
                    this.bytecode.addIndex(lllllllllllllIIIllIIIIIIllllIIIl);
                    this.bytecode.addIndex(lllllllllllllIIIllIIIIIIllllIlII);
                }
                else {
                    this.bytecode.addOpcode(132);
                    this.bytecode.add(lllllllllllllIIIllIIIIIIllllIIIl);
                    this.bytecode.add(lllllllllllllIIIllIIIIIIllllIlII);
                }
                if (lllllllllllllIIIllIIIIIIlllIlIll && !lllllllllllllIIIllIIIIIIlllIlIlI) {
                    this.bytecode.addIload(lllllllllllllIIIllIIIIIIllllIIIl);
                }
            }
            else {
                badType(lllllllllllllIIIllIIIIIIlllIllII);
            }
        }
        else {
            if (lllllllllllllIIIllIIIIIIlllIIlll instanceof Expr) {
                final Expr lllllllllllllIIIllIIIIIIllllIIII = (Expr)lllllllllllllIIIllIIIIIIlllIIlll;
                if (lllllllllllllIIIllIIIIIIllllIIII.getOperator() == 65) {
                    this.atArrayPlusPlus(lllllllllllllIIIllIIIIIIlllIlllI, lllllllllllllIIIllIIIIIIlllIlIlI, lllllllllllllIIIllIIIIIIllllIIII, lllllllllllllIIIllIIIIIIlllIlIll);
                    return;
                }
            }
            this.atFieldPlusPlus(lllllllllllllIIIllIIIIIIlllIlllI, lllllllllllllIIIllIIIIIIlllIlIlI, (ASTree)lllllllllllllIIIllIIIIIIlllIIlll, lllllllllllllIIIllIIIIIIlllIllII, lllllllllllllIIIllIIIIIIlllIlIll);
        }
    }
    
    static int lookupBinOp(final int lllllllllllllIIIllIIIIlIlIlIIlIl) {
        final int[] lllllllllllllIIIllIIIIlIlIlIIlII = CodeGen.binOp;
        for (int lllllllllllllIIIllIIIIlIlIlIIIll = lllllllllllllIIIllIIIIlIlIlIIlII.length, lllllllllllllIIIllIIIIlIlIlIIllI = 0; lllllllllllllIIIllIIIIlIlIlIIllI < lllllllllllllIIIllIIIIlIlIlIIIll; lllllllllllllIIIllIIIIlIlIlIIllI += 5) {
            if (lllllllllllllIIIllIIIIlIlIlIIlII[lllllllllllllIIIllIIIIlIlIlIIllI] == lllllllllllllIIIllIIIIlIlIlIIlIl) {
                return lllllllllllllIIIllIIIIlIlIlIIllI;
            }
        }
        return -1;
    }
    
    @Override
    public void atBinExpr(final BinExpr lllllllllllllIIIllIIIIlIlIIlIIIl) throws CompileError {
        final int lllllllllllllIIIllIIIIlIlIIlIIII = lllllllllllllIIIllIIIIlIlIIlIIIl.getOperator();
        final int lllllllllllllIIIllIIIIlIlIIIllll = lookupBinOp(lllllllllllllIIIllIIIIlIlIIlIIII);
        if (lllllllllllllIIIllIIIIlIlIIIllll >= 0) {
            lllllllllllllIIIllIIIIlIlIIlIIIl.oprand1().accept(this);
            final ASTree lllllllllllllIIIllIIIIlIlIIlIllI = lllllllllllllIIIllIIIIlIlIIlIIIl.oprand2();
            if (lllllllllllllIIIllIIIIlIlIIlIllI == null) {
                return;
            }
            final int lllllllllllllIIIllIIIIlIlIIlIlIl = this.exprType;
            final int lllllllllllllIIIllIIIIlIlIIlIlII = this.arrayDim;
            final String lllllllllllllIIIllIIIIlIlIIlIIll = this.className;
            lllllllllllllIIIllIIIIlIlIIlIllI.accept(this);
            if (lllllllllllllIIIllIIIIlIlIIlIlII != this.arrayDim) {
                throw new CompileError("incompatible array types");
            }
            if (lllllllllllllIIIllIIIIlIlIIlIIII == 43 && lllllllllllllIIIllIIIIlIlIIlIlII == 0 && (lllllllllllllIIIllIIIIlIlIIlIlIl == 307 || this.exprType == 307)) {
                this.atStringConcatExpr(lllllllllllllIIIllIIIIlIlIIlIIIl, lllllllllllllIIIllIIIIlIlIIlIlIl, lllllllllllllIIIllIIIIlIlIIlIlII, lllllllllllllIIIllIIIIlIlIIlIIll);
            }
            else {
                this.atArithBinExpr(lllllllllllllIIIllIIIIlIlIIlIIIl, lllllllllllllIIIllIIIIlIlIIlIIII, lllllllllllllIIIllIIIIlIlIIIllll, lllllllllllllIIIllIIIIlIlIIlIlIl);
            }
        }
        else {
            if (!this.booleanExpr(true, lllllllllllllIIIllIIIIlIlIIlIIIl)) {
                this.bytecode.addIndex(7);
                this.bytecode.addIconst(0);
                this.bytecode.addOpcode(167);
                this.bytecode.addIndex(4);
            }
            this.bytecode.addIconst(1);
        }
    }
    
    @Override
    public void atCastExpr(final CastExpr lllllllllllllIIIllIIIIIllIlIIllI) throws CompileError {
        final String lllllllllllllIIIllIIIIIllIlIlIlI = this.resolveClassName(lllllllllllllIIIllIIIIIllIlIIllI.getClassName());
        final String lllllllllllllIIIllIIIIIllIlIlIIl = this.checkCastExpr(lllllllllllllIIIllIIIIIllIlIIllI, lllllllllllllIIIllIIIIIllIlIlIlI);
        final int lllllllllllllIIIllIIIIIllIlIlIII = this.exprType;
        this.exprType = lllllllllllllIIIllIIIIIllIlIIllI.getType();
        this.arrayDim = lllllllllllllIIIllIIIIIllIlIIllI.getArrayDim();
        this.className = lllllllllllllIIIllIIIIIllIlIlIlI;
        if (lllllllllllllIIIllIIIIIllIlIlIIl == null) {
            this.atNumCastExpr(lllllllllllllIIIllIIIIIllIlIlIII, this.exprType);
        }
        else {
            this.bytecode.addCheckcast(lllllllllllllIIIllIIIIIllIlIlIIl);
        }
    }
    
    protected abstract String resolveClassName(final String p0) throws CompileError;
    
    @Override
    public void atASTList(final ASTList lllllllllllllIIIllIIIlIlIIIIllll) throws CompileError {
        fatal();
    }
    
    protected abstract void atArrayVariableAssign(final ArrayInit p0, final int p1, final int p2, final String p3) throws CompileError;
    
    private String checkCastExpr(final CastExpr lllllllllllllIIIllIIIIIllIIIllII, final String lllllllllllllIIIllIIIIIllIIIIIlI) throws CompileError {
        final String lllllllllllllIIIllIIIIIllIIIlIlI = "invalid cast";
        final ASTree lllllllllllllIIIllIIIIIllIIIlIIl = lllllllllllllIIIllIIIIIllIIIllII.getOprand();
        final int lllllllllllllIIIllIIIIIllIIIlIII = lllllllllllllIIIllIIIIIllIIIllII.getArrayDim();
        final int lllllllllllllIIIllIIIIIllIIIIlll = lllllllllllllIIIllIIIIIllIIIllII.getType();
        lllllllllllllIIIllIIIIIllIIIlIIl.accept(this);
        final int lllllllllllllIIIllIIIIIllIIIIllI = this.exprType;
        final int lllllllllllllIIIllIIIIIllIIIIlIl = this.arrayDim;
        if (this.invalidDim(lllllllllllllIIIllIIIIIllIIIIllI, this.arrayDim, this.className, lllllllllllllIIIllIIIIIllIIIIlll, lllllllllllllIIIllIIIIIllIIIlIII, lllllllllllllIIIllIIIIIllIIIIIlI, true) || lllllllllllllIIIllIIIIIllIIIIllI == 344 || lllllllllllllIIIllIIIIIllIIIIlll == 344) {
            throw new CompileError("invalid cast");
        }
        if (lllllllllllllIIIllIIIIIllIIIIlll == 307) {
            if (!isRefType(lllllllllllllIIIllIIIIIllIIIIllI) && lllllllllllllIIIllIIIIIllIIIIlIl == 0) {
                throw new CompileError("invalid cast");
            }
            return toJvmArrayName(lllllllllllllIIIllIIIIIllIIIIIlI, lllllllllllllIIIllIIIIIllIIIlIII);
        }
        else {
            if (lllllllllllllIIIllIIIIIllIIIlIII > 0) {
                return toJvmTypeName(lllllllllllllIIIllIIIIIllIIIIlll, lllllllllllllIIIllIIIIIllIIIlIII);
            }
            return null;
        }
    }
    
    private void atVariableAssign(final Expr lllllllllllllIIIllIIIIllIIlIIIIl, final int lllllllllllllIIIllIIIIllIIlIlIll, final Variable lllllllllllllIIIllIIIIllIIIlllll, final Declarator lllllllllllllIIIllIIIIllIIIllllI, final ASTree lllllllllllllIIIllIIIIllIIlIlIII, final boolean lllllllllllllIIIllIIIIllIIlIIlll) throws CompileError {
        final int lllllllllllllIIIllIIIIllIIlIIllI = lllllllllllllIIIllIIIIllIIIllllI.getType();
        final int lllllllllllllIIIllIIIIllIIlIIlIl = lllllllllllllIIIllIIIIllIIIllllI.getArrayDim();
        final String lllllllllllllIIIllIIIIllIIlIIlII = lllllllllllllIIIllIIIIllIIIllllI.getClassName();
        final int lllllllllllllIIIllIIIIllIIlIIIll = this.getLocalVar(lllllllllllllIIIllIIIIllIIIllllI);
        if (lllllllllllllIIIllIIIIllIIlIlIll != 61) {
            this.atVariable(lllllllllllllIIIllIIIIllIIIlllll);
        }
        if (lllllllllllllIIIllIIIIllIIlIIIIl == null && lllllllllllllIIIllIIIIllIIlIlIII instanceof ArrayInit) {
            this.atArrayVariableAssign((ArrayInit)lllllllllllllIIIllIIIIllIIlIlIII, lllllllllllllIIIllIIIIllIIlIIllI, lllllllllllllIIIllIIIIllIIlIIlIl, lllllllllllllIIIllIIIIllIIlIIlII);
        }
        else {
            this.atAssignCore(lllllllllllllIIIllIIIIllIIlIIIIl, lllllllllllllIIIllIIIIllIIlIlIll, lllllllllllllIIIllIIIIllIIlIlIII, lllllllllllllIIIllIIIIllIIlIIllI, lllllllllllllIIIllIIIIllIIlIIlIl, lllllllllllllIIIllIIIIllIIlIIlII);
        }
        if (lllllllllllllIIIllIIIIllIIlIIlll) {
            if (is2word(lllllllllllllIIIllIIIIllIIlIIllI, lllllllllllllIIIllIIIIllIIlIIlIl)) {
                this.bytecode.addOpcode(92);
            }
            else {
                this.bytecode.addOpcode(89);
            }
        }
        if (lllllllllllllIIIllIIIIllIIlIIlIl > 0) {
            this.bytecode.addAstore(lllllllllllllIIIllIIIIllIIlIIIll);
        }
        else if (lllllllllllllIIIllIIIIllIIlIIllI == 312) {
            this.bytecode.addDstore(lllllllllllllIIIllIIIIllIIlIIIll);
        }
        else if (lllllllllllllIIIllIIIIllIIlIIllI == 317) {
            this.bytecode.addFstore(lllllllllllllIIIllIIIIllIIlIIIll);
        }
        else if (lllllllllllllIIIllIIIIllIIlIIllI == 326) {
            this.bytecode.addLstore(lllllllllllllIIIllIIIIllIIlIIIll);
        }
        else if (isRefType(lllllllllllllIIIllIIIIllIIlIIllI)) {
            this.bytecode.addAstore(lllllllllllllIIIllIIIIllIIlIIIll);
        }
        else {
            this.bytecode.addIstore(lllllllllllllIIIllIIIIllIIlIIIll);
        }
        this.exprType = lllllllllllllIIIllIIIIllIIlIIllI;
        this.arrayDim = lllllllllllllIIIllIIIIllIIlIIlIl;
        this.className = lllllllllllllIIIllIIIIllIIlIIlII;
    }
    
    @Override
    public void atKeyword(final Keyword lllllllllllllIIIllIIIIIIlIIlllll) throws CompileError {
        this.arrayDim = 0;
        final int lllllllllllllIIIllIIIIIIlIlIIIIl = lllllllllllllIIIllIIIIIIlIIlllll.get();
        switch (lllllllllllllIIIllIIIIIIlIlIIIIl) {
            case 410: {
                this.bytecode.addIconst(1);
                this.exprType = 301;
                break;
            }
            case 411: {
                this.bytecode.addIconst(0);
                this.exprType = 301;
                break;
            }
            case 412: {
                this.bytecode.addOpcode(1);
                this.exprType = 412;
                break;
            }
            case 336:
            case 339: {
                if (this.inStaticMethod) {
                    throw new CompileError(String.valueOf(new StringBuilder().append("not-available: ").append((lllllllllllllIIIllIIIIIIlIlIIIIl == 339) ? "this" : "super")));
                }
                this.bytecode.addAload(0);
                this.exprType = 307;
                if (lllllllllllllIIIllIIIIIIlIlIIIIl == 339) {
                    this.className = this.getThisName();
                    break;
                }
                this.className = this.getSuperName();
                break;
            }
            default: {
                fatal();
                break;
            }
        }
    }
    
    protected void arrayAccess(final ASTree lllllllllllllIIIllIIIIIlIIIIllll, final ASTree lllllllllllllIIIllIIIIIlIIIlIlII) throws CompileError {
        lllllllllllllIIIllIIIIIlIIIIllll.accept(this);
        final int lllllllllllllIIIllIIIIIlIIIlIIll = this.exprType;
        final int lllllllllllllIIIllIIIIIlIIIlIIlI = this.arrayDim;
        if (lllllllllllllIIIllIIIIIlIIIlIIlI == 0) {
            throw new CompileError("bad array access");
        }
        final String lllllllllllllIIIllIIIIIlIIIlIIIl = this.className;
        lllllllllllllIIIllIIIIIlIIIlIlII.accept(this);
        if (typePrecedence(this.exprType) != 3 || this.arrayDim > 0) {
            throw new CompileError("bad array index");
        }
        this.exprType = lllllllllllllIIIllIIIIIlIIIlIIll;
        this.arrayDim = lllllllllllllIIIllIIIIIlIIIlIIlI - 1;
        this.className = lllllllllllllIIIllIIIIIlIIIlIIIl;
    }
    
    private void convertOprandTypes(final int lllllllllllllIIIllIIIIIllIlllIIl, final int lllllllllllllIIIllIIIIIlllIIIIIl, final Expr lllllllllllllIIIllIIIIIllIllIlll) throws CompileError {
        final int lllllllllllllIIIllIIIIIllIlllllI = typePrecedence(lllllllllllllIIIllIIIIIllIlllIIl);
        final int lllllllllllllIIIllIIIIIllIllllIl = typePrecedence(lllllllllllllIIIllIIIIIlllIIIIIl);
        if (lllllllllllllIIIllIIIIIllIllllIl < 0 && lllllllllllllIIIllIIIIIllIlllllI < 0) {
            return;
        }
        if (lllllllllllllIIIllIIIIIllIllllIl < 0 || lllllllllllllIIIllIIIIIllIlllllI < 0) {
            badTypes(lllllllllllllIIIllIIIIIllIllIlll);
        }
        boolean lllllllllllllIIIllIIIIIllIllllll = false;
        int lllllllllllllIIIllIIIIIllIllllII = 0;
        int lllllllllllllIIIllIIIIIllIlllIll = 0;
        if (lllllllllllllIIIllIIIIIllIlllllI <= lllllllllllllIIIllIIIIIllIllllIl) {
            final boolean lllllllllllllIIIllIIIIIlllIIIllI = false;
            this.exprType = lllllllllllllIIIllIIIIIllIlllIIl;
            final int lllllllllllllIIIllIIIIIlllIIIlIl = CodeGen.castOp[lllllllllllllIIIllIIIIIllIllllIl * 4 + lllllllllllllIIIllIIIIIllIlllllI];
            final int lllllllllllllIIIllIIIIIlllIIIlII = lllllllllllllIIIllIIIIIllIlllllI;
        }
        else {
            lllllllllllllIIIllIIIIIllIllllll = true;
            lllllllllllllIIIllIIIIIllIllllII = CodeGen.castOp[lllllllllllllIIIllIIIIIllIlllllI * 4 + lllllllllllllIIIllIIIIIllIllllIl];
            lllllllllllllIIIllIIIIIllIlllIll = lllllllllllllIIIllIIIIIllIllllIl;
        }
        if (lllllllllllllIIIllIIIIIllIllllll) {
            if (lllllllllllllIIIllIIIIIllIlllIll == 0 || lllllllllllllIIIllIIIIIllIlllIll == 2) {
                if (lllllllllllllIIIllIIIIIllIlllllI == 0 || lllllllllllllIIIllIIIIIllIlllllI == 2) {
                    this.bytecode.addOpcode(94);
                }
                else {
                    this.bytecode.addOpcode(93);
                }
                this.bytecode.addOpcode(88);
                this.bytecode.addOpcode(lllllllllllllIIIllIIIIIllIllllII);
                this.bytecode.addOpcode(94);
                this.bytecode.addOpcode(88);
            }
            else if (lllllllllllllIIIllIIIIIllIlllIll == 1) {
                if (lllllllllllllIIIllIIIIIllIlllllI == 2) {
                    this.bytecode.addOpcode(91);
                    this.bytecode.addOpcode(87);
                }
                else {
                    this.bytecode.addOpcode(95);
                }
                this.bytecode.addOpcode(lllllllllllllIIIllIIIIIllIllllII);
                this.bytecode.addOpcode(95);
            }
            else {
                fatal();
            }
        }
        else if (lllllllllllllIIIllIIIIIllIllllII != 0) {
            this.bytecode.addOpcode(lllllllllllllIIIllIIIIIllIllllII);
        }
    }
    
    @Override
    public abstract void atCallExpr(final CallExpr p0) throws CompileError;
    
    private void atSyncStmnt(final Stmnt lllllllllllllIIIllIIIIlllIllIIIl) throws CompileError {
        final int lllllllllllllIIIllIIIIlllIlllIll = getListSize(this.breakList);
        final int lllllllllllllIIIllIIIIlllIlllIlI = getListSize(this.continueList);
        this.compileExpr(lllllllllllllIIIllIIIIlllIllIIIl.head());
        if (this.exprType != 307 && this.arrayDim == 0) {
            throw new CompileError("bad type expr for synchronized block");
        }
        final Bytecode lllllllllllllIIIllIIIIlllIlllIIl = this.bytecode;
        final int lllllllllllllIIIllIIIIlllIlllIII = lllllllllllllIIIllIIIIlllIlllIIl.getMaxLocals();
        lllllllllllllIIIllIIIIlllIlllIIl.incMaxLocals(1);
        lllllllllllllIIIllIIIIlllIlllIIl.addOpcode(89);
        lllllllllllllIIIllIIIIlllIlllIIl.addAstore(lllllllllllllIIIllIIIIlllIlllIII);
        lllllllllllllIIIllIIIIlllIlllIIl.addOpcode(194);
        final ReturnHook lllllllllllllIIIllIIIIlllIllIlll = new ReturnHook(this) {
            @Override
            protected boolean doit(final Bytecode lllllllllllllIlIllIlllIIlllIIIII, final int lllllllllllllIlIllIlllIIlllIIIlI) {
                lllllllllllllIlIllIlllIIlllIIIII.addAload(lllllllllllllIIIllIIIIlllIlllIII);
                lllllllllllllIlIllIlllIIlllIIIII.addOpcode(195);
                return false;
            }
        };
        final int lllllllllllllIIIllIIIIlllIllIllI = lllllllllllllIIIllIIIIlllIlllIIl.currentPc();
        final Stmnt lllllllllllllIIIllIIIIlllIllIlIl = (Stmnt)lllllllllllllIIIllIIIIlllIllIIIl.tail();
        if (lllllllllllllIIIllIIIIlllIllIlIl != null) {
            lllllllllllllIIIllIIIIlllIllIlIl.accept(this);
        }
        final int lllllllllllllIIIllIIIIlllIllIlII = lllllllllllllIIIllIIIIlllIlllIIl.currentPc();
        int lllllllllllllIIIllIIIIlllIllIIll = 0;
        if (!this.hasReturned) {
            lllllllllllllIIIllIIIIlllIllIlll.doit(lllllllllllllIIIllIIIIlllIlllIIl, 0);
            lllllllllllllIIIllIIIIlllIlllIIl.addOpcode(167);
            lllllllllllllIIIllIIIIlllIllIIll = lllllllllllllIIIllIIIIlllIlllIIl.currentPc();
            lllllllllllllIIIllIIIIlllIlllIIl.addIndex(0);
        }
        if (lllllllllllllIIIllIIIIlllIllIllI < lllllllllllllIIIllIIIIlllIllIlII) {
            final int lllllllllllllIIIllIIIIlllIlllllI = lllllllllllllIIIllIIIIlllIlllIIl.currentPc();
            lllllllllllllIIIllIIIIlllIllIlll.doit(lllllllllllllIIIllIIIIlllIlllIIl, 0);
            lllllllllllllIIIllIIIIlllIlllIIl.addOpcode(191);
            lllllllllllllIIIllIIIIlllIlllIIl.addExceptionHandler(lllllllllllllIIIllIIIIlllIllIllI, lllllllllllllIIIllIIIIlllIllIlII, lllllllllllllIIIllIIIIlllIlllllI, 0);
        }
        if (!this.hasReturned) {
            lllllllllllllIIIllIIIIlllIlllIIl.write16bit(lllllllllllllIIIllIIIIlllIllIIll, lllllllllllllIIIllIIIIlllIlllIIl.currentPc() - lllllllllllllIIIllIIIIlllIllIIll + 1);
        }
        lllllllllllllIIIllIIIIlllIllIlll.remove(this);
        if (getListSize(this.breakList) != lllllllllllllIIIllIIIIlllIlllIll || getListSize(this.continueList) != lllllllllllllIIIllIIIIlllIlllIlI) {
            throw new CompileError("sorry, cannot break/continue in synchronized block");
        }
    }
    
    protected abstract void insertDefaultSuperCall() throws CompileError;
    
    private void atArithBinExpr(final Expr lllllllllllllIIIllIIIIlIIlllllII, final int lllllllllllllIIIllIIIIlIIllllIll, final int lllllllllllllIIIllIIIIlIIllllIlI, final int lllllllllllllIIIllIIIIlIIllllIIl) throws CompileError {
        if (this.arrayDim != 0) {
            badTypes(lllllllllllllIIIllIIIIlIIlllllII);
        }
        final int lllllllllllllIIIllIIIIlIIllllIII = this.exprType;
        if (lllllllllllllIIIllIIIIlIIllllIll == 364 || lllllllllllllIIIllIIIIlIIllllIll == 366 || lllllllllllllIIIllIIIIlIIllllIll == 370) {
            if (lllllllllllllIIIllIIIIlIIllllIII == 324 || lllllllllllllIIIllIIIIlIIllllIII == 334 || lllllllllllllIIIllIIIIlIIllllIII == 306 || lllllllllllllIIIllIIIIlIIllllIII == 303) {
                this.exprType = lllllllllllllIIIllIIIIlIIllllIIl;
            }
            else {
                badTypes(lllllllllllllIIIllIIIIlIIlllllII);
            }
        }
        else {
            this.convertOprandTypes(lllllllllllllIIIllIIIIlIIllllIIl, lllllllllllllIIIllIIIIlIIllllIII, lllllllllllllIIIllIIIIlIIlllllII);
        }
        final int lllllllllllllIIIllIIIIlIIlllIlll = typePrecedence(this.exprType);
        if (lllllllllllllIIIllIIIIlIIlllIlll >= 0) {
            final int lllllllllllllIIIllIIIIlIIllllllI = CodeGen.binOp[lllllllllllllIIIllIIIIlIIllllIlI + lllllllllllllIIIllIIIIlIIlllIlll + 1];
            if (lllllllllllllIIIllIIIIlIIllllllI != 0) {
                if (lllllllllllllIIIllIIIIlIIlllIlll == 3 && this.exprType != 301) {
                    this.exprType = 324;
                }
                this.bytecode.addOpcode(lllllllllllllIIIllIIIIlIIllllllI);
                return;
            }
        }
        badTypes(lllllllllllllIIIllIIIIlIIlllllII);
    }
    
    protected abstract void atFieldRead(final ASTree p0) throws CompileError;
    
    protected abstract String resolveClassName(final ASTList p0) throws CompileError;
    
    protected static void badType(final Expr lllllllllllllIIIllIIIIIlIlIIllIl) throws CompileError {
        throw new CompileError(String.valueOf(new StringBuilder().append("invalid type for ").append(lllllllllllllIIIllIIIIIlIlIIllIl.getName())));
    }
    
    public void setTypeChecker(final TypeChecker lllllllllllllIIIllIIIlIllIlllIIl) {
        this.typeChecker = lllllllllllllIIIllIIIlIllIlllIIl;
    }
    
    public boolean compileBooleanExpr(final boolean lllllllllllllIIIllIIIlIlIIIllIII, final ASTree lllllllllllllIIIllIIIlIlIIIlIlll) throws CompileError {
        this.doTypeCheck(lllllllllllllIIIllIIIlIlIIIlIlll);
        return this.booleanExpr(lllllllllllllIIIllIIIlIlIIIllIII, lllllllllllllIIIllIIIlIlIIIlIlll);
    }
    
    private boolean needsSuperCall(Stmnt lllllllllllllIIIllIIIlIIllIlllll) throws CompileError {
        if (lllllllllllllIIIllIIIlIIllIlllll.getOperator() == 66) {
            lllllllllllllIIIllIIIlIIllIlllll = (Stmnt)lllllllllllllIIIllIIIlIIllIlllll.head();
        }
        if (lllllllllllllIIIllIIIlIIllIlllll != null && lllllllllllllIIIllIIIlIIllIlllll.getOperator() == 69) {
            final ASTree lllllllllllllIIIllIIIlIIlllIIIlI = lllllllllllllIIIllIIIlIIllIlllll.head();
            if (lllllllllllllIIIllIIIlIIlllIIIlI != null && lllllllllllllIIIllIIIlIIlllIIIlI instanceof Expr && ((Expr)lllllllllllllIIIllIIIlIIlllIIIlI).getOperator() == 67) {
                final ASTree lllllllllllllIIIllIIIlIIlllIIIll = ((Expr)lllllllllllllIIIllIIIlIIlllIIIlI).head();
                if (lllllllllllllIIIllIIIlIIlllIIIll instanceof Keyword) {
                    final int lllllllllllllIIIllIIIlIIlllIIlII = ((Keyword)lllllllllllllIIIllIIIlIIlllIIIll).get();
                    return lllllllllllllIIIllIIIlIIlllIIlII != 339 && lllllllllllllIIIllIIIlIIlllIIlII != 336;
                }
            }
        }
        return true;
    }
    
    protected int getTempVar() {
        if (this.tempVar < 0) {
            this.tempVar = this.getMaxLocals();
            this.incMaxLocals(2);
        }
        return this.tempVar;
    }
    
    @Override
    public void atDeclarator(final Declarator lllllllllllllIIIllIIIIlllIIlIlIl) throws CompileError {
        lllllllllllllIIIllIIIIlllIIlIlIl.setLocalVar(this.getMaxLocals());
        lllllllllllllIIIllIIIIlllIIlIlIl.setClassName(this.resolveClassName(lllllllllllllIIIllIIIIlllIIlIlIl.getClassName()));
        int lllllllllllllIIIllIIIIlllIIlIIlI = 0;
        if (is2word(lllllllllllllIIIllIIIIlllIIlIlIl.getType(), lllllllllllllIIIllIIIIlllIIlIlIl.getArrayDim())) {
            final int lllllllllllllIIIllIIIIlllIIllIII = 2;
        }
        else {
            lllllllllllllIIIllIIIIlllIIlIIlI = 1;
        }
        this.incMaxLocals(lllllllllllllIIIllIIIIlllIIlIIlI);
        final ASTree lllllllllllllIIIllIIIIlllIIlIIII = lllllllllllllIIIllIIIIlllIIlIlIl.getInitializer();
        if (lllllllllllllIIIllIIIIlllIIlIIII != null) {
            this.doTypeCheck(lllllllllllllIIIllIIIIlllIIlIIII);
            this.atVariableAssign(null, 61, null, lllllllllllllIIIllIIIIlllIIlIlIl, lllllllllllllIIIllIIIIlllIIlIIII, false);
        }
    }
    
    public int getMaxLocals() {
        return this.bytecode.getMaxLocals();
    }
    
    private void atArrayAssign(final Expr lllllllllllllIIIllIIIIllIIIIllIl, final int lllllllllllllIIIllIIIIllIIIIIIll, final Expr lllllllllllllIIIllIIIIllIIIIlIll, final ASTree lllllllllllllIIIllIIIIllIIIIIIIl, final boolean lllllllllllllIIIllIIIIllIIIIIIII) throws CompileError {
        this.arrayAccess(lllllllllllllIIIllIIIIllIIIIlIll.oprand1(), lllllllllllllIIIllIIIIllIIIIlIll.oprand2());
        if (lllllllllllllIIIllIIIIllIIIIIIll != 61) {
            this.bytecode.addOpcode(92);
            this.bytecode.addOpcode(getArrayReadOp(this.exprType, this.arrayDim));
        }
        final int lllllllllllllIIIllIIIIllIIIIlIII = this.exprType;
        final int lllllllllllllIIIllIIIIllIIIIIlll = this.arrayDim;
        final String lllllllllllllIIIllIIIIllIIIIIllI = this.className;
        this.atAssignCore(lllllllllllllIIIllIIIIllIIIIllIl, lllllllllllllIIIllIIIIllIIIIIIll, lllllllllllllIIIllIIIIllIIIIIIIl, lllllllllllllIIIllIIIIllIIIIlIII, lllllllllllllIIIllIIIIllIIIIIlll, lllllllllllllIIIllIIIIllIIIIIllI);
        if (lllllllllllllIIIllIIIIllIIIIIIII) {
            if (is2word(lllllllllllllIIIllIIIIllIIIIlIII, lllllllllllllIIIllIIIIllIIIIIlll)) {
                this.bytecode.addOpcode(94);
            }
            else {
                this.bytecode.addOpcode(91);
            }
        }
        this.bytecode.addOpcode(getArrayWriteOp(lllllllllllllIIIllIIIIllIIIIlIII, lllllllllllllIIIllIIIIllIIIIIlll));
        this.exprType = lllllllllllllIIIllIIIIllIIIIlIII;
        this.arrayDim = lllllllllllllIIIllIIIIllIIIIIlll;
        this.className = lllllllllllllIIIllIIIIllIIIIIllI;
    }
    
    protected static String toJvmArrayName(final String lllllllllllllIIIllIIIlIlIlIllIll, final int lllllllllllllIIIllIIIlIlIlIllIIl) {
        if (lllllllllllllIIIllIIIlIlIlIllIll == null) {
            return null;
        }
        if (lllllllllllllIIIllIIIlIlIlIllIIl == 0) {
            return lllllllllllllIIIllIIIlIlIlIllIll;
        }
        final StringBuffer lllllllllllllIIIllIIIlIlIlIlllll = new StringBuffer();
        int lllllllllllllIIIllIIIlIlIlIlllIl = lllllllllllllIIIllIIIlIlIlIllIIl;
        while (lllllllllllllIIIllIIIlIlIlIlllIl-- > 0) {
            lllllllllllllIIIllIIIlIlIlIlllll.append('[');
        }
        lllllllllllllIIIllIIIlIlIlIlllll.append('L');
        lllllllllllllIIIllIIIlIlIlIlllll.append(lllllllllllllIIIllIIIlIlIlIllIll);
        lllllllllllllIIIllIIIlIlIlIlllll.append(';');
        return lllllllllllllIIIllIIIlIlIlIlllll.toString();
    }
    
    protected void atTryStmnt(final Stmnt lllllllllllllIIIllIIIIllllIIllII) throws CompileError {
        this.hasReturned = false;
    }
    
    @Override
    public abstract void atNewExpr(final NewExpr p0) throws CompileError;
    
    @Override
    public void atIntConst(final IntConst lllllllllllllIIIllIIIIIIlIIlIIlI) throws CompileError {
        this.arrayDim = 0;
        final long lllllllllllllIIIllIIIIIIlIIlIIIl = lllllllllllllIIIllIIIIIIlIIlIIlI.get();
        final int lllllllllllllIIIllIIIIIIlIIlIIII = lllllllllllllIIIllIIIIIIlIIlIIlI.getType();
        if (lllllllllllllIIIllIIIIIIlIIlIIII == 402 || lllllllllllllIIIllIIIIIIlIIlIIII == 401) {
            this.exprType = ((lllllllllllllIIIllIIIIIIlIIlIIII == 402) ? 324 : 306);
            this.bytecode.addIconst((int)lllllllllllllIIIllIIIIIIlIIlIIIl);
        }
        else {
            this.exprType = 326;
            this.bytecode.addLconst(lllllllllllllIIIllIIIIIIlIIlIIIl);
        }
    }
    
    protected abstract void atFieldAssign(final Expr p0, final int p1, final ASTree p2, final ASTree p3, final boolean p4) throws CompileError;
    
    protected static String toJvmTypeName(final int lllllllllllllIIIllIIIlIlIIllIIlI, int lllllllllllllIIIllIIIlIlIIlllIII) {
        char lllllllllllllIIIllIIIlIlIIllIllI = 'I';
        switch (lllllllllllllIIIllIIIlIlIIllIIlI) {
            case 301: {
                lllllllllllllIIIllIIIlIlIIllIllI = 'Z';
                break;
            }
            case 303: {
                lllllllllllllIIIllIIIlIlIIllIllI = 'B';
                break;
            }
            case 306: {
                lllllllllllllIIIllIIIlIlIIllIllI = 'C';
                break;
            }
            case 334: {
                lllllllllllllIIIllIIIlIlIIllIllI = 'S';
                break;
            }
            case 324: {
                lllllllllllllIIIllIIIlIlIIllIllI = 'I';
                break;
            }
            case 326: {
                lllllllllllllIIIllIIIlIlIIllIllI = 'J';
                break;
            }
            case 317: {
                lllllllllllllIIIllIIIlIlIIllIllI = 'F';
                break;
            }
            case 312: {
                lllllllllllllIIIllIIIlIlIIllIllI = 'D';
                break;
            }
            case 344: {
                lllllllllllllIIIllIIIlIlIIllIllI = 'V';
                break;
            }
        }
        final StringBuffer lllllllllllllIIIllIIIlIlIIllIlII = new StringBuffer();
        while (lllllllllllllIIIllIIIlIlIIlllIII-- > 0) {
            lllllllllllllIIIllIIIlIlIIllIlII.append('[');
        }
        lllllllllllllIIIllIIIlIlIIllIlII.append(lllllllllllllIIIllIIIlIlIIllIllI);
        return lllllllllllllIIIllIIIlIlIIllIlII.toString();
    }
    
    protected static void badAssign(final Expr lllllllllllllIIIllIIIIllIlIIlIlI) throws CompileError {
        String lllllllllllllIIIllIIIIllIlIIlIII = null;
        if (lllllllllllllIIIllIIIIllIlIIlIlI == null) {
            final String lllllllllllllIIIllIIIIllIlIIllII = "incompatible type for assignment";
        }
        else {
            lllllllllllllIIIllIIIIllIlIIlIII = String.valueOf(new StringBuilder().append("incompatible type for ").append(lllllllllllllIIIllIIIIllIlIIlIlI.getName()));
        }
        throw new CompileError(lllllllllllllIIIllIIIIllIlIIlIII);
    }
    
    @Override
    public abstract void atMember(final Member p0) throws CompileError;
    
    protected void atAssignExpr(final AssignExpr lllllllllllllIIIllIIIIllIlIllllI, final boolean lllllllllllllIIIllIIIIllIlIlllIl) throws CompileError {
        final int lllllllllllllIIIllIIIIllIllIIllI = lllllllllllllIIIllIIIIllIlIllllI.getOperator();
        final ASTree lllllllllllllIIIllIIIIllIllIIlII = lllllllllllllIIIllIIIIllIlIllllI.oprand1();
        final ASTree lllllllllllllIIIllIIIIllIllIIIlI = lllllllllllllIIIllIIIIllIlIllllI.oprand2();
        if (lllllllllllllIIIllIIIIllIllIIlII instanceof Variable) {
            this.atVariableAssign(lllllllllllllIIIllIIIIllIlIllllI, lllllllllllllIIIllIIIIllIllIIllI, (Variable)lllllllllllllIIIllIIIIllIllIIlII, ((Variable)lllllllllllllIIIllIIIIllIllIIlII).getDeclarator(), lllllllllllllIIIllIIIIllIllIIIlI, lllllllllllllIIIllIIIIllIlIlllIl);
        }
        else {
            if (lllllllllllllIIIllIIIIllIllIIlII instanceof Expr) {
                final Expr lllllllllllllIIIllIIIIllIllIllll = (Expr)lllllllllllllIIIllIIIIllIllIIlII;
                if (lllllllllllllIIIllIIIIllIllIllll.getOperator() == 65) {
                    this.atArrayAssign(lllllllllllllIIIllIIIIllIlIllllI, lllllllllllllIIIllIIIIllIllIIllI, (Expr)lllllllllllllIIIllIIIIllIllIIlII, lllllllllllllIIIllIIIIllIllIIIlI, lllllllllllllIIIllIIIIllIlIlllIl);
                    return;
                }
            }
            this.atFieldAssign(lllllllllllllIIIllIIIIllIlIllllI, lllllllllllllIIIllIIIIllIllIIllI, lllllllllllllIIIllIIIIllIllIIlII, lllllllllllllIIIllIIIIllIllIIIlI, lllllllllllllIIIllIIIIllIlIlllIl);
        }
    }
    
    private void atWhileStmnt(final Stmnt lllllllllllllIIIllIIIlIIlIIllIll, final boolean lllllllllllllIIIllIIIlIIlIlIIlIl) throws CompileError {
        final List<Integer> lllllllllllllIIIllIIIlIIlIlIIlII = this.breakList;
        final List<Integer> lllllllllllllIIIllIIIlIIlIlIIIll = this.continueList;
        this.breakList = new ArrayList<Integer>();
        this.continueList = new ArrayList<Integer>();
        final ASTree lllllllllllllIIIllIIIlIIlIlIIIlI = lllllllllllllIIIllIIIlIIlIIllIll.head();
        final Stmnt lllllllllllllIIIllIIIlIIlIlIIIIl = (Stmnt)lllllllllllllIIIllIIIlIIlIIllIll.tail();
        int lllllllllllllIIIllIIIlIIlIlIIIII = 0;
        if (lllllllllllllIIIllIIIlIIlIlIIlIl) {
            this.bytecode.addOpcode(167);
            lllllllllllllIIIllIIIlIIlIlIIIII = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
        }
        final int lllllllllllllIIIllIIIlIIlIIlllll = this.bytecode.currentPc();
        if (lllllllllllllIIIllIIIlIIlIlIIIIl != null) {
            lllllllllllllIIIllIIIlIIlIlIIIIl.accept(this);
        }
        final int lllllllllllllIIIllIIIlIIlIIllllI = this.bytecode.currentPc();
        if (lllllllllllllIIIllIIIlIIlIlIIlIl) {
            this.bytecode.write16bit(lllllllllllllIIIllIIIlIIlIlIIIII, lllllllllllllIIIllIIIlIIlIIllllI - lllllllllllllIIIllIIIlIIlIlIIIII + 1);
        }
        boolean lllllllllllllIIIllIIIlIIlIIlllIl = this.compileBooleanExpr(true, lllllllllllllIIIllIIIlIIlIlIIIlI);
        if (lllllllllllllIIIllIIIlIIlIIlllIl) {
            this.bytecode.addOpcode(167);
            lllllllllllllIIIllIIIlIIlIIlllIl = (this.breakList.size() == 0);
        }
        this.bytecode.addIndex(lllllllllllllIIIllIIIlIIlIIlllll - this.bytecode.currentPc() + 1);
        this.patchGoto(this.breakList, this.bytecode.currentPc());
        this.patchGoto(this.continueList, lllllllllllllIIIllIIIlIIlIIllllI);
        this.continueList = lllllllllllllIIIllIIIlIIlIlIIIll;
        this.breakList = lllllllllllllIIIllIIIlIIlIlIIlII;
        this.hasReturned = lllllllllllllIIIllIIIlIIlIIlllIl;
    }
    
    private static int getListSize(final List<Integer> lllllllllllllIIIllIIIIlllIlIIlII) {
        return (lllllllllllllIIIllIIIIlllIlIIlII == null) ? 0 : lllllllllllllIIIllIIIIlllIlIIlII.size();
    }
    
    @Override
    public abstract void atArrayInit(final ArrayInit p0) throws CompileError;
    
    protected void patchGoto(final List<Integer> lllllllllllllIIIllIIIlIIlIIIIlll, final int lllllllllllllIIIllIIIlIIlIIIlIIl) {
        for (final int lllllllllllllIIIllIIIlIIlIIIllII : lllllllllllllIIIllIIIlIIlIIIIlll) {
            this.bytecode.write16bit(lllllllllllllIIIllIIIlIIlIIIllII, lllllllllllllIIIllIIIlIIlIIIlIIl - lllllllllllllIIIllIIIlIIlIIIllII + 1);
        }
    }
    
    @Override
    public void atDoubleConst(final DoubleConst lllllllllllllIIIllIIIIIIlIIIlIII) throws CompileError {
        this.arrayDim = 0;
        if (lllllllllllllIIIllIIIIIIlIIIlIII.getType() == 405) {
            this.exprType = 312;
            this.bytecode.addDconst(lllllllllllllIIIllIIIIIIlIIIlIII.get());
        }
        else {
            this.exprType = 317;
            this.bytecode.addFconst((float)lllllllllllllIIIllIIIIIIlIIIlIII.get());
        }
    }
    
    protected final void atReturnStmnt2(final ASTree lllllllllllllIIIllIIIIllllIlllIl) throws CompileError {
        int lllllllllllllIIIllIIIIllllIlllII = 0;
        if (lllllllllllllIIIllIIIIllllIlllIl == null) {
            final int lllllllllllllIIIllIIIIlllllIIllI = 177;
        }
        else {
            this.compileExpr(lllllllllllllIIIllIIIIllllIlllIl);
            if (this.arrayDim > 0) {
                final int lllllllllllllIIIllIIIIlllllIIlIl = 176;
            }
            else {
                final int lllllllllllllIIIllIIIIlllllIIIII = this.exprType;
                if (lllllllllllllIIIllIIIIlllllIIIII == 312) {
                    final int lllllllllllllIIIllIIIIlllllIIlII = 175;
                }
                else if (lllllllllllllIIIllIIIIlllllIIIII == 317) {
                    final int lllllllllllllIIIllIIIIlllllIIIll = 174;
                }
                else if (lllllllllllllIIIllIIIIlllllIIIII == 326) {
                    final int lllllllllllllIIIllIIIIlllllIIIlI = 173;
                }
                else if (isRefType(lllllllllllllIIIllIIIIlllllIIIII)) {
                    final int lllllllllllllIIIllIIIIlllllIIIIl = 176;
                }
                else {
                    lllllllllllllIIIllIIIIllllIlllII = 172;
                }
            }
        }
        for (ReturnHook lllllllllllllIIIllIIIIllllIlllll = this.returnHooks; lllllllllllllIIIllIIIIllllIlllll != null; lllllllllllllIIIllIIIIllllIlllll = lllllllllllllIIIllIIIIllllIlllll.next) {
            if (lllllllllllllIIIllIIIIllllIlllll.doit(this.bytecode, lllllllllllllIIIllIIIIllllIlllII)) {
                this.hasReturned = true;
                return;
            }
        }
        this.bytecode.addOpcode(lllllllllllllIIIllIIIIllllIlllII);
        this.hasReturned = true;
    }
    
    @Override
    public void atFieldDecl(final FieldDecl lllllllllllllIIIllIIIlIlIIIIIlll) throws CompileError {
        lllllllllllllIIIllIIIlIlIIIIIlll.getInit().accept(this);
    }
    
    public void compileExpr(final ASTree lllllllllllllIIIllIIIlIlIIlIlIII) throws CompileError {
        this.doTypeCheck(lllllllllllllIIIllIIIlIlIIlIlIII);
        lllllllllllllIIIllIIIlIlIIlIlIII.accept(this);
    }
    
    public CodeGen(final Bytecode lllllllllllllIIIllIIIlIlllIIIIIl) {
        this.bytecode = lllllllllllllIIIllIIIlIlllIIIIIl;
        this.tempVar = -1;
        this.typeChecker = null;
        this.hasReturned = false;
        this.inStaticMethod = false;
        this.breakList = null;
        this.continueList = null;
        this.returnHooks = null;
    }
    
    @Override
    public void atAssignExpr(final AssignExpr lllllllllllllIIIllIIIIlllIIIIIII) throws CompileError {
        this.atAssignExpr(lllllllllllllIIIllIIIIlllIIIIIII, true);
    }
    
    @Override
    public void atInstanceOfExpr(final InstanceOfExpr lllllllllllllIIIllIIIIIllIIlllIl) throws CompileError {
        final String lllllllllllllIIIllIIIIIllIIlllII = this.resolveClassName(lllllllllllllIIIllIIIIIllIIlllIl.getClassName());
        final String lllllllllllllIIIllIIIIIllIIllIll = this.checkCastExpr(lllllllllllllIIIllIIIIIllIIlllIl, lllllllllllllIIIllIIIIIllIIlllII);
        this.bytecode.addInstanceof(lllllllllllllIIIllIIIIIllIIllIll);
        this.exprType = 301;
        this.arrayDim = 0;
    }
    
    private static boolean isPlusPlusExpr(final ASTree lllllllllllllIIIllIIIIlllIIlllll) {
        if (lllllllllllllIIIllIIIIlllIIlllll instanceof Expr) {
            final int lllllllllllllIIIllIIIIlllIlIIIIl = ((Expr)lllllllllllllIIIllIIIIlllIIlllll).getOperator();
            return lllllllllllllIIIllIIIIlllIlIIIIl == 362 || lllllllllllllIIIllIIIIlllIlIIIIl == 363;
        }
        return false;
    }
    
    protected void atReturnStmnt(final Stmnt lllllllllllllIIIllIIIIlllllIlIll) throws CompileError {
        this.atReturnStmnt2(lllllllllllllIIIllIIIIlllllIlIll.getLeft());
    }
    
    public void atClassObject(final Expr lllllllllllllIIIllIIIIIlIIlllIll) throws CompileError {
        final ASTree lllllllllllllIIIllIIIIIlIIlllllI = lllllllllllllIIIllIIIIIlIIlllIll.oprand1();
        if (!(lllllllllllllIIIllIIIIIlIIlllllI instanceof Symbol)) {
            throw new CompileError("fatal error: badly parsed .class expr");
        }
        String lllllllllllllIIIllIIIIIlIIllllIl = ((Symbol)lllllllllllllIIIllIIIIIlIIlllllI).get();
        if (lllllllllllllIIIllIIIIIlIIllllIl.startsWith("[")) {
            int lllllllllllllIIIllIIIIIlIlIIIIIl = lllllllllllllIIIllIIIIIlIIllllIl.indexOf("[L");
            if (lllllllllllllIIIllIIIIIlIlIIIIIl >= 0) {
                final String lllllllllllllIIIllIIIIIlIlIIIIll = lllllllllllllIIIllIIIIIlIIllllIl.substring(lllllllllllllIIIllIIIIIlIlIIIIIl + 2, lllllllllllllIIIllIIIIIlIIllllIl.length() - 1);
                String lllllllllllllIIIllIIIIIlIlIIIIlI = this.resolveClassName(lllllllllllllIIIllIIIIIlIlIIIIll);
                if (!lllllllllllllIIIllIIIIIlIlIIIIll.equals(lllllllllllllIIIllIIIIIlIlIIIIlI)) {
                    lllllllllllllIIIllIIIIIlIlIIIIlI = MemberResolver.jvmToJavaName(lllllllllllllIIIllIIIIIlIlIIIIlI);
                    final StringBuffer lllllllllllllIIIllIIIIIlIlIIIlII = new StringBuffer();
                    while (lllllllllllllIIIllIIIIIlIlIIIIIl-- >= 0) {
                        lllllllllllllIIIllIIIIIlIlIIIlII.append('[');
                    }
                    lllllllllllllIIIllIIIIIlIlIIIlII.append('L').append(lllllllllllllIIIllIIIIIlIlIIIIlI).append(';');
                    lllllllllllllIIIllIIIIIlIIllllIl = lllllllllllllIIIllIIIIIlIlIIIlII.toString();
                }
            }
        }
        else {
            lllllllllllllIIIllIIIIIlIIllllIl = this.resolveClassName(MemberResolver.javaToJvmName(lllllllllllllIIIllIIIIIlIIllllIl));
            lllllllllllllIIIllIIIIIlIIllllIl = MemberResolver.jvmToJavaName(lllllllllllllIIIllIIIIIlIIllllIl);
        }
        this.atClassObject2(lllllllllllllIIIllIIIIIlIIllllIl);
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/Class";
    }
    
    private void atStringPlusEq(final Expr lllllllllllllIIIllIIIIlIllIllIlI, final int lllllllllllllIIIllIIIIlIllIllIIl, final int lllllllllllllIIIllIIIIlIllIlIIlI, final String lllllllllllllIIIllIIIIlIllIlIlll, final ASTree lllllllllllllIIIllIIIIlIllIlIllI) throws CompileError {
        if (!"java/lang/String".equals(lllllllllllllIIIllIIIIlIllIlIlll)) {
            badAssign(lllllllllllllIIIllIIIIlIllIllIlI);
        }
        this.convToString(lllllllllllllIIIllIIIIlIllIllIIl, lllllllllllllIIIllIIIIlIllIlIIlI);
        lllllllllllllIIIllIIIIlIllIlIllI.accept(this);
        this.convToString(this.exprType, this.arrayDim);
        this.bytecode.addInvokevirtual("java.lang.String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/String";
    }
    
    protected static boolean isRefType(final int lllllllllllllIIIllIIIIIlllllIlll) {
        return lllllllllllllIIIllIIIIIlllllIlll == 307 || lllllllllllllIIIllIIIIIlllllIlll == 412;
    }
    
    private static int typePrecedence(final int lllllllllllllIIIllIIIIIlllllIlIl) {
        if (lllllllllllllIIIllIIIIIlllllIlIl == 312) {
            return 0;
        }
        if (lllllllllllllIIIllIIIIIlllllIlIl == 317) {
            return 1;
        }
        if (lllllllllllllIIIllIIIIIlllllIlIl == 326) {
            return 2;
        }
        if (isRefType(lllllllllllllIIIllIIIIIlllllIlIl)) {
            return -1;
        }
        if (lllllllllllllIIIllIIIIIlllllIlIl == 344) {
            return -1;
        }
        return 3;
    }
    
    protected abstract String getSuperName() throws CompileError;
    
    protected static int getArrayWriteOp(final int lllllllllllllIIIllIIIIIlIIIIIIlI, final int lllllllllllllIIIllIIIIIIllllllll) {
        if (lllllllllllllIIIllIIIIIIllllllll > 0) {
            return 83;
        }
        switch (lllllllllllllIIIllIIIIIlIIIIIIlI) {
            case 312: {
                return 82;
            }
            case 317: {
                return 81;
            }
            case 326: {
                return 80;
            }
            case 324: {
                return 79;
            }
            case 334: {
                return 86;
            }
            case 306: {
                return 85;
            }
            case 301:
            case 303: {
                return 84;
            }
            default: {
                return 83;
            }
        }
    }
    
    @Override
    public void atStringL(final StringL lllllllllllllIIIllIIIIIIlIIllIII) throws CompileError {
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/String";
        this.bytecode.addLdc(lllllllllllllIIIllIIIIIIlIIllIII.get());
    }
    
    static boolean rightIsStrong(final int lllllllllllllIIIllIIIIIlllIlllII, final int lllllllllllllIIIllIIIIIllllIIIIl) {
        final int lllllllllllllIIIllIIIIIlllIlllll = typePrecedence(lllllllllllllIIIllIIIIIlllIlllII);
        final int lllllllllllllIIIllIIIIIlllIlllIl = typePrecedence(lllllllllllllIIIllIIIIIllllIIIIl);
        return lllllllllllllIIIllIIIIIlllIlllll >= 0 && lllllllllllllIIIllIIIIIlllIlllIl >= 0 && lllllllllllllIIIllIIIIIlllIlllll > lllllllllllllIIIllIIIIIlllIlllIl;
    }
    
    private int compileOprands(final BinExpr lllllllllllllIIIllIIIIlIIIIllIIl) throws CompileError {
        lllllllllllllIIIllIIIIlIIIIllIIl.oprand1().accept(this);
        final int lllllllllllllIIIllIIIIlIIIIlllII = this.exprType;
        final int lllllllllllllIIIllIIIIlIIIIllIll = this.arrayDim;
        lllllllllllllIIIllIIIIlIIIIllIIl.oprand2().accept(this);
        if (lllllllllllllIIIllIIIIlIIIIllIll != this.arrayDim) {
            if (lllllllllllllIIIllIIIIlIIIIlllII != 412 && this.exprType != 412) {
                throw new CompileError("incompatible array types");
            }
            if (this.exprType == 412) {
                this.arrayDim = lllllllllllllIIIllIIIIlIIIIllIll;
            }
        }
        if (lllllllllllllIIIllIIIIlIIIIlllII == 412) {
            return this.exprType;
        }
        return lllllllllllllIIIllIIIIlIIIIlllII;
    }
    
    @Override
    public void atCondExpr(final CondExpr lllllllllllllIIIllIIIIlIlIllIIII) throws CompileError {
        if (this.booleanExpr(false, lllllllllllllIIIllIIIIlIlIllIIII.condExpr())) {
            lllllllllllllIIIllIIIIlIlIllIIII.elseExpr().accept(this);
        }
        else {
            final int lllllllllllllIIIllIIIIlIlIllIlII = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
            lllllllllllllIIIllIIIIlIlIllIIII.thenExpr().accept(this);
            final int lllllllllllllIIIllIIIIlIlIllIIll = this.arrayDim;
            this.bytecode.addOpcode(167);
            final int lllllllllllllIIIllIIIIlIlIllIIlI = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
            this.bytecode.write16bit(lllllllllllllIIIllIIIIlIlIllIlII, this.bytecode.currentPc() - lllllllllllllIIIllIIIIlIlIllIlII + 1);
            lllllllllllllIIIllIIIIlIlIllIIII.elseExpr().accept(this);
            if (lllllllllllllIIIllIIIIlIlIllIIll != this.arrayDim) {
                throw new CompileError("type mismatch in ?:");
            }
            this.bytecode.write16bit(lllllllllllllIIIllIIIIlIlIllIIlI, this.bytecode.currentPc() - lllllllllllllIIIllIIIIlIlIllIIlI + 1);
        }
    }
    
    private void atThrowStmnt(final Stmnt lllllllllllllIIIllIIIIllllIlIIll) throws CompileError {
        final ASTree lllllllllllllIIIllIIIIllllIlIIlI = lllllllllllllIIIllIIIIllllIlIIll.getLeft();
        this.compileExpr(lllllllllllllIIIllIIIIllllIlIIlI);
        if (this.exprType != 307 || this.arrayDim > 0) {
            throw new CompileError("bad throw statement");
        }
        this.bytecode.addOpcode(191);
        this.hasReturned = true;
    }
    
    public void doTypeCheck(final ASTree lllllllllllllIIIllIIIlIlIIIlIIIl) throws CompileError {
        if (this.typeChecker != null) {
            lllllllllllllIIIllIIIlIlIIIlIIIl.accept(this.typeChecker);
        }
    }
    
    public void atArrayRead(final ASTree lllllllllllllIIIllIIIIIlIIIllllI, final ASTree lllllllllllllIIIllIIIIIlIIlIIIII) throws CompileError {
        this.arrayAccess(lllllllllllllIIIllIIIIIlIIIllllI, lllllllllllllIIIllIIIIIlIIlIIIII);
        this.bytecode.addOpcode(getArrayReadOp(this.exprType, this.arrayDim));
    }
    
    public void atMethodBody(final Stmnt lllllllllllllIIIllIIIlIIlllIllll, final boolean lllllllllllllIIIllIIIlIIlllIlllI, final boolean lllllllllllllIIIllIIIlIIlllIlIIl) throws CompileError {
        if (lllllllllllllIIIllIIIlIIlllIllll == null) {
            return;
        }
        if (lllllllllllllIIIllIIIlIIlllIlllI && this.needsSuperCall(lllllllllllllIIIllIIIlIIlllIllll)) {
            this.insertDefaultSuperCall();
        }
        this.hasReturned = false;
        lllllllllllllIIIllIIIlIIlllIllll.accept(this);
        if (!this.hasReturned) {
            if (!lllllllllllllIIIllIIIlIIlllIlIIl) {
                throw new CompileError("no return statement");
            }
            this.bytecode.addOpcode(177);
            this.hasReturned = true;
        }
    }
    
    @Override
    public void atPair(final Pair lllllllllllllIIIllIIIlIlIIIIllIl) throws CompileError {
        fatal();
    }
    
    protected void atPlusPlusCore(final int lllllllllllllIIIllIIIIIIlIllllll, final boolean lllllllllllllIIIllIIIIIIlIllIlll, final int lllllllllllllIIIllIIIIIIlIllIllI, final boolean lllllllllllllIIIllIIIIIIlIllllII, final Expr lllllllllllllIIIllIIIIIIlIlllIll) throws CompileError {
        final int lllllllllllllIIIllIIIIIIlIlllIlI = this.exprType;
        if (lllllllllllllIIIllIIIIIIlIllIlll && lllllllllllllIIIllIIIIIIlIllllII) {
            this.bytecode.addOpcode(lllllllllllllIIIllIIIIIIlIllllll);
        }
        if (lllllllllllllIIIllIIIIIIlIlllIlI == 324 || lllllllllllllIIIllIIIIIIlIlllIlI == 303 || lllllllllllllIIIllIIIIIIlIlllIlI == 306 || lllllllllllllIIIllIIIIIIlIlllIlI == 334) {
            this.bytecode.addIconst(1);
            this.bytecode.addOpcode((lllllllllllllIIIllIIIIIIlIllIllI == 362) ? 96 : 100);
            this.exprType = 324;
        }
        else if (lllllllllllllIIIllIIIIIIlIlllIlI == 326) {
            this.bytecode.addLconst(1L);
            this.bytecode.addOpcode((lllllllllllllIIIllIIIIIIlIllIllI == 362) ? 97 : 101);
        }
        else if (lllllllllllllIIIllIIIIIIlIlllIlI == 317) {
            this.bytecode.addFconst(1.0f);
            this.bytecode.addOpcode((lllllllllllllIIIllIIIIIIlIllIllI == 362) ? 98 : 102);
        }
        else if (lllllllllllllIIIllIIIIIIlIlllIlI == 312) {
            this.bytecode.addDconst(1.0);
            this.bytecode.addOpcode((lllllllllllllIIIllIIIIIIlIllIllI == 362) ? 99 : 103);
        }
        else {
            badType(lllllllllllllIIIllIIIIIIlIlllIll);
        }
        if (lllllllllllllIIIllIIIIIIlIllIlll && !lllllllllllllIIIllIIIIIIlIllllII) {
            this.bytecode.addOpcode(lllllllllllllIIIllIIIIIIlIllllll);
        }
    }
    
    static boolean isP_INT(final int lllllllllllllIIIllIIIIIlllllIIIl) {
        return typePrecedence(lllllllllllllIIIllIIIIIlllllIIIl) == 3;
    }
    
    void atNumCastExpr(final int lllllllllllllIIIllIIIIIlIllIllII, final int lllllllllllllIIIllIIIIIlIllIIlII) throws CompileError {
        if (lllllllllllllIIIllIIIIIlIllIllII == lllllllllllllIIIllIIIIIlIllIIlII) {
            return;
        }
        final int lllllllllllllIIIllIIIIIlIllIlIII = typePrecedence(lllllllllllllIIIllIIIIIlIllIllII);
        final int lllllllllllllIIIllIIIIIlIllIIlll = typePrecedence(lllllllllllllIIIllIIIIIlIllIIlII);
        int lllllllllllllIIIllIIIIIlIllIlIlI = 0;
        if (0 <= lllllllllllllIIIllIIIIIlIllIlIII && lllllllllllllIIIllIIIIIlIllIlIII < 3) {
            final int lllllllllllllIIIllIIIIIlIlllIlII = CodeGen.castOp[lllllllllllllIIIllIIIIIlIllIlIII * 4 + lllllllllllllIIIllIIIIIlIllIIlll];
        }
        else {
            lllllllllllllIIIllIIIIIlIllIlIlI = 0;
        }
        int lllllllllllllIIIllIIIIIlIllIlIIl = 0;
        if (lllllllllllllIIIllIIIIIlIllIIlII == 312) {
            final int lllllllllllllIIIllIIIIIlIlllIIll = 135;
        }
        else if (lllllllllllllIIIllIIIIIlIllIIlII == 317) {
            final int lllllllllllllIIIllIIIIIlIlllIIlI = 134;
        }
        else if (lllllllllllllIIIllIIIIIlIllIIlII == 326) {
            final int lllllllllllllIIIllIIIIIlIlllIIIl = 133;
        }
        else if (lllllllllllllIIIllIIIIIlIllIIlII == 334) {
            final int lllllllllllllIIIllIIIIIlIlllIIII = 147;
        }
        else if (lllllllllllllIIIllIIIIIlIllIIlII == 306) {
            final int lllllllllllllIIIllIIIIIlIllIllll = 146;
        }
        else if (lllllllllllllIIIllIIIIIlIllIIlII == 303) {
            final int lllllllllllllIIIllIIIIIlIllIlllI = 145;
        }
        else {
            lllllllllllllIIIllIIIIIlIllIlIIl = 0;
        }
        if (lllllllllllllIIIllIIIIIlIllIlIlI != 0) {
            this.bytecode.addOpcode(lllllllllllllIIIllIIIIIlIllIlIlI);
        }
        if ((lllllllllllllIIIllIIIIIlIllIlIlI == 0 || lllllllllllllIIIllIIIIIlIllIlIlI == 136 || lllllllllllllIIIllIIIIIlIllIlIlI == 139 || lllllllllllllIIIllIIIIIlIllIlIlI == 142) && lllllllllllllIIIllIIIIIlIllIlIIl != 0) {
            this.bytecode.addOpcode(lllllllllllllIIIllIIIIIlIllIlIIl);
        }
    }
    
    private boolean invalidDim(final int lllllllllllllIIIllIIIIlIllIIIIII, final int lllllllllllllIIIllIIIIlIllIIIllI, final String lllllllllllllIIIllIIIIlIllIIIlIl, final int lllllllllllllIIIllIIIIlIllIIIlII, final int lllllllllllllIIIllIIIIlIllIIIIll, final String lllllllllllllIIIllIIIIlIlIlllIll, final boolean lllllllllllllIIIllIIIIlIlIlllIlI) {
        return lllllllllllllIIIllIIIIlIllIIIllI != lllllllllllllIIIllIIIIlIllIIIIll && lllllllllllllIIIllIIIIlIllIIIIII != 412 && (lllllllllllllIIIllIIIIlIllIIIIll != 0 || lllllllllllllIIIllIIIIlIllIIIlII != 307 || !"java/lang/Object".equals(lllllllllllllIIIllIIIIlIlIlllIll)) && (!lllllllllllllIIIllIIIIlIlIlllIlI || lllllllllllllIIIllIIIIlIllIIIllI != 0 || lllllllllllllIIIllIIIIlIllIIIIII != 307 || !"java/lang/Object".equals(lllllllllllllIIIllIIIIlIllIIIlIl));
    }
    
    private int computeLabel(ASTree lllllllllllllIIIllIIIlIIIIIlIIIl) throws CompileError {
        this.doTypeCheck(lllllllllllllIIIllIIIlIIIIIlIIIl);
        lllllllllllllIIIllIIIlIIIIIlIIIl = TypeChecker.stripPlusExpr(lllllllllllllIIIllIIIlIIIIIlIIIl);
        if (lllllllllllllIIIllIIIlIIIIIlIIIl instanceof IntConst) {
            return (int)((IntConst)lllllllllllllIIIllIIIlIIIIIlIIIl).get();
        }
        throw new CompileError("bad case label");
    }
    
    protected abstract static class ReturnHook
    {
        /* synthetic */ ReturnHook next;
        
        protected abstract boolean doit(final Bytecode p0, final int p1);
        
        protected ReturnHook(final CodeGen lllllllllllllIIlIIIlllIIIIIlllII) {
            this.next = lllllllllllllIIlIIIlllIIIIIlllII.returnHooks;
            lllllllllllllIIlIIIlllIIIIIlllII.returnHooks = this;
        }
        
        protected void remove(final CodeGen lllllllllllllIIlIIIlllIIIIIllIII) {
            lllllllllllllIIlIIIlllIIIIIllIII.returnHooks = this.next;
        }
    }
}
