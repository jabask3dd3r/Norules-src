package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;

public class Javac
{
    /* synthetic */ SymbolTable stable;
    /* synthetic */ JvstCodeGen gen;
    private /* synthetic */ Bytecode bytecode;
    
    public void recordSpecialProceed(final String lllllllllllllIIIllIlllIlIlIIIlII, final String lllllllllllllIIIllIlllIlIlIIllII, final String lllllllllllllIIIllIlllIlIlIIIIlI, final String lllllllllllllIIIllIlllIlIlIIlIlI, final int lllllllllllllIIIllIlllIlIlIIIIII) throws CompileError {
        final Parser lllllllllllllIIIllIlllIlIlIIlIII = new Parser(new Lex(lllllllllllllIIIllIlllIlIlIIIlII));
        final ASTree lllllllllllllIIIllIlllIlIlIIIlll = lllllllllllllIIIllIlllIlIlIIlIII.parseExpression(this.stable);
        final ProceedHandler lllllllllllllIIIllIlllIlIlIIIllI = new ProceedHandler() {
            @Override
            public void doit(final JvstCodeGen lllllllllllllIlIllIIIlIlllIlIlII, final Bytecode lllllllllllllIlIllIIIlIlllIlIIll, final ASTList lllllllllllllIlIllIIIlIlllIlIIlI) throws CompileError {
                lllllllllllllIlIllIIIlIlllIlIlII.compileInvokeSpecial(lllllllllllllIIIllIlllIlIlIIIlll, lllllllllllllIIIllIlllIlIlIIIIII, lllllllllllllIIIllIlllIlIlIIlIlI, lllllllllllllIlIllIIIlIlllIlIIlI);
            }
            
            @Override
            public void setReturnType(final JvstTypeChecker lllllllllllllIlIllIIIlIlllIIIlll, final ASTList lllllllllllllIlIllIIIlIlllIIIllI) throws CompileError {
                lllllllllllllIlIllIIIlIlllIIIlll.compileInvokeSpecial(lllllllllllllIIIllIlllIlIlIIIlll, lllllllllllllIIIllIlllIlIlIIllII, lllllllllllllIIIllIlllIlIlIIIIlI, lllllllllllllIIIllIlllIlIlIIlIlI, lllllllllllllIlIllIIIlIlllIIIllI);
            }
        };
        this.gen.setProceedHandler(lllllllllllllIIIllIlllIlIlIIIllI, "$proceed");
    }
    
    public void compileExpr(final String lllllllllllllIIIllIlllIlIIlIIIll) throws CompileError {
        final ASTree lllllllllllllIIIllIlllIlIIlIIIlI = parseExpr(lllllllllllllIIIllIlllIlIIlIIIll, this.stable);
        this.compileExpr(lllllllllllllIIIllIlllIlIIlIIIlI);
    }
    
    public int recordReturnType(final CtClass lllllllllllllIIIllIlllIllIIlIIlI, final boolean lllllllllllllIIIllIlllIllIIIlllI) throws CompileError {
        this.gen.recordType(lllllllllllllIIIllIlllIllIIlIIlI);
        return this.gen.recordReturnType(lllllllllllllIIIllIlllIllIIlIIlI, "$r", lllllllllllllIIIllIlllIllIIIlllI ? "$_" : null, this.stable);
    }
    
    public Bytecode compileBody(final CtBehavior lllllllllllllIIIllIllllIIIIIIIlI, final String lllllllllllllIIIllIllllIIIIIIlII) throws CompileError {
        try {
            final int lllllllllllllIIIllIllllIIIIIlIlI = lllllllllllllIIIllIllllIIIIIIIlI.getModifiers();
            this.recordParams(lllllllllllllIIIllIllllIIIIIIIlI.getParameterTypes(), Modifier.isStatic(lllllllllllllIIIllIllllIIIIIlIlI));
            CtClass lllllllllllllIIIllIllllIIIIIlIIl = null;
            if (lllllllllllllIIIllIllllIIIIIIIlI instanceof CtMethod) {
                this.gen.setThisMethod((CtMethod)lllllllllllllIIIllIllllIIIIIIIlI);
                final CtClass lllllllllllllIIIllIllllIIIIIllll = ((CtMethod)lllllllllllllIIIllIllllIIIIIIIlI).getReturnType();
            }
            else {
                lllllllllllllIIIllIllllIIIIIlIIl = CtClass.voidType;
            }
            this.recordReturnType(lllllllllllllIIIllIllllIIIIIlIIl, false);
            final boolean lllllllllllllIIIllIllllIIIIIlIII = lllllllllllllIIIllIllllIIIIIlIIl == CtClass.voidType;
            if (lllllllllllllIIIllIllllIIIIIIlII == null) {
                makeDefaultBody(this.bytecode, lllllllllllllIIIllIllllIIIIIlIIl);
            }
            else {
                final Parser lllllllllllllIIIllIllllIIIIIlllI = new Parser(new Lex(lllllllllllllIIIllIllllIIIIIIlII));
                final SymbolTable lllllllllllllIIIllIllllIIIIIllIl = new SymbolTable(this.stable);
                final Stmnt lllllllllllllIIIllIllllIIIIIllII = lllllllllllllIIIllIllllIIIIIlllI.parseStatement(lllllllllllllIIIllIllllIIIIIllIl);
                if (lllllllllllllIIIllIllllIIIIIlllI.hasMore()) {
                    throw new CompileError("the method/constructor body must be surrounded by {}");
                }
                boolean lllllllllllllIIIllIllllIIIIIlIll = false;
                if (lllllllllllllIIIllIllllIIIIIIIlI instanceof CtConstructor) {
                    lllllllllllllIIIllIllllIIIIIlIll = !((CtConstructor)lllllllllllllIIIllIllllIIIIIIIlI).isClassInitializer();
                }
                this.gen.atMethodBody(lllllllllllllIIIllIllllIIIIIllII, lllllllllllllIIIllIllllIIIIIlIll, lllllllllllllIIIllIllllIIIIIlIII);
            }
            return this.bytecode;
        }
        catch (NotFoundException lllllllllllllIIIllIllllIIIIIIlll) {
            throw new CompileError(lllllllllllllIIIllIllllIIIIIIlll.toString());
        }
    }
    
    public boolean recordParamNames(final CodeAttribute lllllllllllllIIIllIlllIlllIIIIlI, final int lllllllllllllIIIllIlllIllIllllII) throws CompileError {
        final LocalVariableAttribute lllllllllllllIIIllIlllIlllIIIIII = (LocalVariableAttribute)lllllllllllllIIIllIlllIlllIIIIlI.getAttribute("LocalVariableTable");
        if (lllllllllllllIIIllIlllIlllIIIIII == null) {
            return false;
        }
        for (int lllllllllllllIIIllIlllIllIllllll = lllllllllllllIIIllIlllIlllIIIIII.tableLength(), lllllllllllllIIIllIlllIlllIIIlII = 0; lllllllllllllIIIllIlllIlllIIIlII < lllllllllllllIIIllIlllIllIllllll; ++lllllllllllllIIIllIlllIlllIIIlII) {
            final int lllllllllllllIIIllIlllIlllIIIlIl = lllllllllllllIIIllIlllIlllIIIIII.index(lllllllllllllIIIllIlllIlllIIIlII);
            if (lllllllllllllIIIllIlllIlllIIIlIl < lllllllllllllIIIllIlllIllIllllII) {
                this.gen.recordVariable(lllllllllllllIIIllIlllIlllIIIIII.descriptor(lllllllllllllIIIllIlllIlllIIIlII), lllllllllllllIIIllIlllIlllIIIIII.variableName(lllllllllllllIIIllIlllIlllIIIlII), lllllllllllllIIIllIlllIlllIIIlIl, this.stable);
            }
        }
        return true;
    }
    
    public void setMaxLocals(final int lllllllllllllIIIllIlllIllIIlIlll) {
        this.gen.setMaxLocals(lllllllllllllIIIllIlllIllIIlIlll);
    }
    
    public int recordParams(final CtClass[] lllllllllllllIIIllIlllIllIllIIII, final boolean lllllllllllllIIIllIlllIllIllIIlI) throws CompileError {
        return this.gen.recordParams(lllllllllllllIIIllIlllIllIllIIII, lllllllllllllIIIllIlllIllIllIIlI, "$", "$args", "$$", this.stable);
    }
    
    public Bytecode getBytecode() {
        return this.bytecode;
    }
    
    public int recordParams(final String lllllllllllllIIIllIlllIllIlIIlll, final CtClass[] lllllllllllllIIIllIlllIllIlIIIII, final boolean lllllllllllllIIIllIlllIllIlIIlIl, final int lllllllllllllIIIllIlllIllIlIIlII, final boolean lllllllllllllIIIllIlllIllIlIIIll) throws CompileError {
        return this.gen.recordParams(lllllllllllllIIIllIlllIllIlIIIII, lllllllllllllIIIllIlllIllIlIIIll, "$", "$args", "$$", lllllllllllllIIIllIlllIllIlIIlIl, lllllllllllllIIIllIlllIllIlIIlII, lllllllllllllIIIllIlllIllIlIIlll, this.stable);
    }
    
    public static ASTree parseExpr(final String lllllllllllllIIIllIlllIlIIIllIll, final SymbolTable lllllllllllllIIIllIlllIlIIIllIlI) throws CompileError {
        final Parser lllllllllllllIIIllIlllIlIIIllIIl = new Parser(new Lex(lllllllllllllIIIllIlllIlIIIllIll));
        return lllllllllllllIIIllIlllIlIIIllIIl.parseExpression(lllllllllllllIIIllIlllIlIIIllIlI);
    }
    
    public void recordProceed(final String lllllllllllllIIIllIlllIlIllIllll, final String lllllllllllllIIIllIlllIlIlllIlIl) throws CompileError {
        final Parser lllllllllllllIIIllIlllIlIlllIlII = new Parser(new Lex(lllllllllllllIIIllIlllIlIllIllll));
        final ASTree lllllllllllllIIIllIlllIlIlllIIll = lllllllllllllIIIllIlllIlIlllIlII.parseExpression(this.stable);
        final String lllllllllllllIIIllIlllIlIlllIIlI = lllllllllllllIIIllIlllIlIlllIlIl;
        final ProceedHandler lllllllllllllIIIllIlllIlIlllIIIl = new ProceedHandler() {
            @Override
            public void setReturnType(final JvstTypeChecker lllllllllllllIllIIlIlIIllIIIIlII, final ASTList lllllllllllllIllIIlIlIIllIIIIlll) throws CompileError {
                ASTree lllllllllllllIllIIlIlIIllIIIIllI = new Member(lllllllllllllIIIllIlllIlIlllIIlI);
                if (lllllllllllllIIIllIlllIlIlllIIll != null) {
                    lllllllllllllIllIIlIlIIllIIIIllI = Expr.make(46, lllllllllllllIIIllIlllIlIlllIIll, lllllllllllllIllIIlIlIIllIIIIllI);
                }
                lllllllllllllIllIIlIlIIllIIIIllI = CallExpr.makeCall(lllllllllllllIllIIlIlIIllIIIIllI, lllllllllllllIllIIlIlIIllIIIIlll);
                lllllllllllllIllIIlIlIIllIIIIllI.accept(lllllllllllllIllIIlIlIIllIIIIlII);
                lllllllllllllIllIIlIlIIllIIIIlII.addNullIfVoid();
            }
            
            @Override
            public void doit(final JvstCodeGen lllllllllllllIllIIlIlIIllIIlIIII, final Bytecode lllllllllllllIllIIlIlIIllIIlIlII, final ASTList lllllllllllllIllIIlIlIIllIIlIIll) throws CompileError {
                ASTree lllllllllllllIllIIlIlIIllIIlIIlI = new Member(lllllllllllllIIIllIlllIlIlllIIlI);
                if (lllllllllllllIIIllIlllIlIlllIIll != null) {
                    lllllllllllllIllIIlIlIIllIIlIIlI = Expr.make(46, lllllllllllllIIIllIlllIlIlllIIll, lllllllllllllIllIIlIlIIllIIlIIlI);
                }
                lllllllllllllIllIIlIlIIllIIlIIlI = CallExpr.makeCall(lllllllllllllIllIIlIlIIllIIlIIlI, lllllllllllllIllIIlIlIIllIIlIIll);
                lllllllllllllIllIIlIlIIllIIlIIII.compileExpr(lllllllllllllIllIIlIlIIllIIlIIlI);
                lllllllllllllIllIIlIlIIllIIlIIII.addNullIfVoid();
            }
        };
        this.gen.setProceedHandler(lllllllllllllIIIllIlllIlIlllIIIl, "$proceed");
    }
    
    private static void makeDefaultBody(final Bytecode lllllllllllllIIIllIlllIllllIlIIl, final CtClass lllllllllllllIIIllIlllIllllIllII) {
        int lllllllllllllIIIllIlllIllllIlIll;
        int lllllllllllllIIIllIlllIllllIlIlI = 0;
        if (lllllllllllllIIIllIlllIllllIllII instanceof CtPrimitiveType) {
            final CtPrimitiveType lllllllllllllIIIllIlllIlllllIIII = (CtPrimitiveType)lllllllllllllIIIllIlllIllllIllII;
            final int lllllllllllllIIIllIlllIllllIllll = lllllllllllllIIIllIlllIlllllIIII.getReturnOp();
            if (lllllllllllllIIIllIlllIllllIllll == 175) {
                final int lllllllllllllIIIllIlllIlllllIlII = 14;
            }
            else if (lllllllllllllIIIllIlllIllllIllll == 174) {
                final int lllllllllllllIIIllIlllIlllllIIll = 11;
            }
            else if (lllllllllllllIIIllIlllIllllIllll == 173) {
                final int lllllllllllllIIIllIlllIlllllIIlI = 9;
            }
            else if (lllllllllllllIIIllIlllIllllIllll == 177) {
                final int lllllllllllllIIIllIlllIlllllIIIl = 0;
            }
            else {
                final int lllllllllllllIIIllIlllIllllIlllI = 3;
            }
        }
        else {
            lllllllllllllIIIllIlllIllllIlIll = 176;
            lllllllllllllIIIllIlllIllllIlIlI = 1;
        }
        if (lllllllllllllIIIllIlllIllllIlIlI != 0) {
            lllllllllllllIIIllIlllIllllIlIIl.addOpcode(lllllllllllllIIIllIlllIllllIlIlI);
        }
        lllllllllllllIIIllIlllIllllIlIIl.addOpcode(lllllllllllllIIIllIlllIllllIlIll);
    }
    
    public Javac(final CtClass lllllllllllllIIIllIllllIIllIIIll) {
        this(new Bytecode(lllllllllllllIIIllIllllIIllIIIll.getClassFile2().getConstPool(), 0, 0), lllllllllllllIIIllIllllIIllIIIll);
    }
    
    public void recordProceed(final ProceedHandler lllllllllllllIIIllIlllIlIIlllIIl) {
        this.gen.setProceedHandler(lllllllllllllIIIllIlllIlIIlllIIl, "$proceed");
    }
    
    public void recordType(final CtClass lllllllllllllIIIllIlllIllIIIlIII) {
        this.gen.recordType(lllllllllllllIIIllIlllIllIIIlIII);
    }
    
    public boolean recordLocalVariables(final CodeAttribute lllllllllllllIIIllIlllIlllIlIIll, final int lllllllllllllIIIllIlllIlllIlIlll) throws CompileError {
        final LocalVariableAttribute lllllllllllllIIIllIlllIlllIlIllI = (LocalVariableAttribute)lllllllllllllIIIllIlllIlllIlIIll.getAttribute("LocalVariableTable");
        if (lllllllllllllIIIllIlllIlllIlIllI == null) {
            return false;
        }
        for (int lllllllllllllIIIllIlllIlllIlIlIl = lllllllllllllIIIllIlllIlllIlIllI.tableLength(), lllllllllllllIIIllIlllIlllIllIlI = 0; lllllllllllllIIIllIlllIlllIllIlI < lllllllllllllIIIllIlllIlllIlIlIl; ++lllllllllllllIIIllIlllIlllIllIlI) {
            final int lllllllllllllIIIllIlllIlllIlllII = lllllllllllllIIIllIlllIlllIlIllI.startPc(lllllllllllllIIIllIlllIlllIllIlI);
            final int lllllllllllllIIIllIlllIlllIllIll = lllllllllllllIIIllIlllIlllIlIllI.codeLength(lllllllllllllIIIllIlllIlllIllIlI);
            if (lllllllllllllIIIllIlllIlllIlllII <= lllllllllllllIIIllIlllIlllIlIlll && lllllllllllllIIIllIlllIlllIlIlll < lllllllllllllIIIllIlllIlllIlllII + lllllllllllllIIIllIlllIlllIllIll) {
                this.gen.recordVariable(lllllllllllllIIIllIlllIlllIlIllI.descriptor(lllllllllllllIIIllIlllIlllIllIlI), lllllllllllllIIIllIlllIlllIlIllI.variableName(lllllllllllllIIIllIlllIlllIllIlI), lllllllllllllIIIllIlllIlllIlIllI.index(lllllllllllllIIIllIlllIlllIllIlI), this.stable);
            }
        }
        return true;
    }
    
    public void compileStmnt(final String lllllllllllllIIIllIlllIlIIlIllll) throws CompileError {
        final Parser lllllllllllllIIIllIlllIlIIlIlllI = new Parser(new Lex(lllllllllllllIIIllIlllIlIIlIllll));
        final SymbolTable lllllllllllllIIIllIlllIlIIlIllIl = new SymbolTable(this.stable);
        while (lllllllllllllIIIllIlllIlIIlIlllI.hasMore()) {
            final Stmnt lllllllllllllIIIllIlllIlIIllIIIl = lllllllllllllIIIllIlllIlIIlIlllI.parseStatement(lllllllllllllIIIllIlllIlIIlIllIl);
            if (lllllllllllllIIIllIlllIlIIllIIIl != null) {
                lllllllllllllIIIllIlllIlIIllIIIl.accept(this.gen);
            }
        }
    }
    
    public Javac(final Bytecode lllllllllllllIIIllIllllIIlIllIll, final CtClass lllllllllllllIIIllIllllIIlIlllIl) {
        this.gen = new JvstCodeGen(lllllllllllllIIIllIllllIIlIllIll, lllllllllllllIIIllIllllIIlIlllIl, lllllllllllllIIIllIllllIIlIlllIl.getClassPool());
        this.stable = new SymbolTable();
        this.bytecode = lllllllllllllIIIllIllllIIlIllIll;
    }
    
    public int recordVariable(final CtClass lllllllllllllIIIllIlllIllIIIIIll, final String lllllllllllllIIIllIlllIlIlllllll) throws CompileError {
        return this.gen.recordVariable(lllllllllllllIIIllIlllIllIIIIIll, lllllllllllllIIIllIlllIlIlllllll, this.stable);
    }
    
    public void compileExpr(final ASTree lllllllllllllIIIllIlllIlIIIlIIII) throws CompileError {
        if (lllllllllllllIIIllIlllIlIIIlIIII != null) {
            this.gen.compileExpr(lllllllllllllIIIllIlllIlIIIlIIII);
        }
    }
    
    static {
        param0Name = "$0";
        resultVarName = "$_";
        proceedName = "$proceed";
    }
    
    private CtBehavior compileMethod(final Parser lllllllllllllIIIllIllllIIIlIIIIl, MethodDecl lllllllllllllIIIllIllllIIIlIIIII) throws CompileError {
        final int lllllllllllllIIIllIllllIIIlIIlIl = MemberResolver.getModifiers(lllllllllllllIIIllIllllIIIlIIIII.getModifiers());
        final CtClass[] lllllllllllllIIIllIllllIIIlIIlII = this.gen.makeParamList(lllllllllllllIIIllIllllIIIlIIIII);
        final CtClass[] lllllllllllllIIIllIllllIIIlIIIll = this.gen.makeThrowsList(lllllllllllllIIIllIllllIIIlIIIII);
        this.recordParams(lllllllllllllIIIllIllllIIIlIIlII, Modifier.isStatic(lllllllllllllIIIllIllllIIIlIIlIl));
        lllllllllllllIIIllIllllIIIlIIIII = lllllllllllllIIIllIllllIIIlIIIIl.parseMethod2(this.stable, lllllllllllllIIIllIllllIIIlIIIII);
        try {
            if (lllllllllllllIIIllIllllIIIlIIIII.isConstructor()) {
                final CtConstructor lllllllllllllIIIllIllllIIIlIllIl = new CtConstructor(lllllllllllllIIIllIllllIIIlIIlII, this.gen.getThisClass());
                lllllllllllllIIIllIllllIIIlIllIl.setModifiers(lllllllllllllIIIllIllllIIIlIIlIl);
                lllllllllllllIIIllIllllIIIlIIIII.accept(this.gen);
                lllllllllllllIIIllIllllIIIlIllIl.getMethodInfo().setCodeAttribute(this.bytecode.toCodeAttribute());
                lllllllllllllIIIllIllllIIIlIllIl.setExceptionTypes(lllllllllllllIIIllIllllIIIlIIIll);
                return lllllllllllllIIIllIllllIIIlIllIl;
            }
            final Declarator lllllllllllllIIIllIllllIIIlIllII = lllllllllllllIIIllIllllIIIlIIIII.getReturn();
            final CtClass lllllllllllllIIIllIllllIIIlIlIll = this.gen.resolver.lookupClass(lllllllllllllIIIllIllllIIIlIllII);
            this.recordReturnType(lllllllllllllIIIllIllllIIIlIlIll, false);
            final CtMethod lllllllllllllIIIllIllllIIIlIlIlI = new CtMethod(lllllllllllllIIIllIllllIIIlIlIll, lllllllllllllIIIllIllllIIIlIllII.getVariable().get(), lllllllllllllIIIllIllllIIIlIIlII, this.gen.getThisClass());
            lllllllllllllIIIllIllllIIIlIlIlI.setModifiers(lllllllllllllIIIllIllllIIIlIIlIl);
            this.gen.setThisMethod(lllllllllllllIIIllIllllIIIlIlIlI);
            lllllllllllllIIIllIllllIIIlIIIII.accept(this.gen);
            if (lllllllllllllIIIllIllllIIIlIIIII.getBody() != null) {
                lllllllllllllIIIllIllllIIIlIlIlI.getMethodInfo().setCodeAttribute(this.bytecode.toCodeAttribute());
            }
            else {
                lllllllllllllIIIllIllllIIIlIlIlI.setModifiers(lllllllllllllIIIllIllllIIIlIIlIl | 0x400);
            }
            lllllllllllllIIIllIllllIIIlIlIlI.setExceptionTypes(lllllllllllllIIIllIllllIIIlIIIll);
            return lllllllllllllIIIllIllllIIIlIlIlI;
        }
        catch (NotFoundException lllllllllllllIIIllIllllIIIlIlIIl) {
            throw new CompileError(lllllllllllllIIIllIllllIIIlIlIIl.toString());
        }
    }
    
    public void recordStaticProceed(final String lllllllllllllIIIllIlllIlIlIlllII, final String lllllllllllllIIIllIlllIlIlIllIll) throws CompileError {
        final String lllllllllllllIIIllIlllIlIllIIIII = lllllllllllllIIIllIlllIlIlIlllII;
        final String lllllllllllllIIIllIlllIlIlIlllll = lllllllllllllIIIllIlllIlIlIllIll;
        final ProceedHandler lllllllllllllIIIllIlllIlIlIllllI = new ProceedHandler() {
            @Override
            public void setReturnType(final JvstTypeChecker lllllllllllllIlIlllllIlllIllllll, final ASTList lllllllllllllIlIlllllIllllIIIIlI) throws CompileError {
                Expr lllllllllllllIlIlllllIllllIIIIIl = Expr.make(35, new Symbol(lllllllllllllIIIllIlllIlIllIIIII), new Member(lllllllllllllIIIllIlllIlIlIlllll));
                lllllllllllllIlIlllllIllllIIIIIl = CallExpr.makeCall(lllllllllllllIlIlllllIllllIIIIIl, lllllllllllllIlIlllllIllllIIIIlI);
                lllllllllllllIlIlllllIllllIIIIIl.accept(lllllllllllllIlIlllllIlllIllllll);
                lllllllllllllIlIlllllIlllIllllll.addNullIfVoid();
            }
            
            @Override
            public void doit(final JvstCodeGen lllllllllllllIlIlllllIllllIlIIII, final Bytecode lllllllllllllIlIlllllIllllIIllll, final ASTList lllllllllllllIlIlllllIllllIIlllI) throws CompileError {
                Expr lllllllllllllIlIlllllIllllIIllIl = Expr.make(35, new Symbol(lllllllllllllIIIllIlllIlIllIIIII), new Member(lllllllllllllIIIllIlllIlIlIlllll));
                lllllllllllllIlIlllllIllllIIllIl = CallExpr.makeCall(lllllllllllllIlIlllllIllllIIllIl, lllllllllllllIlIlllllIllllIIlllI);
                lllllllllllllIlIlllllIllllIlIIII.compileExpr(lllllllllllllIlIlllllIllllIIllIl);
                lllllllllllllIlIlllllIllllIlIIII.addNullIfVoid();
            }
        };
        this.gen.setProceedHandler(lllllllllllllIIIllIlllIlIlIllllI, "$proceed");
    }
    
    public CtMember compile(final String lllllllllllllIIIllIllllIIlIIIlll) throws CompileError {
        final Parser lllllllllllllIIIllIllllIIlIIlIlI = new Parser(new Lex(lllllllllllllIIIllIllllIIlIIIlll));
        final ASTList lllllllllllllIIIllIllllIIlIIlIIl = lllllllllllllIIIllIllllIIlIIlIlI.parseMember1(this.stable);
        try {
            if (lllllllllllllIIIllIllllIIlIIlIIl instanceof FieldDecl) {
                return this.compileField((FieldDecl)lllllllllllllIIIllIllllIIlIIlIIl);
            }
            final CtBehavior lllllllllllllIIIllIllllIIlIlIIII = this.compileMethod(lllllllllllllIIIllIllllIIlIIlIlI, (MethodDecl)lllllllllllllIIIllIllllIIlIIlIIl);
            final CtClass lllllllllllllIIIllIllllIIlIIllll = lllllllllllllIIIllIllllIIlIlIIII.getDeclaringClass();
            lllllllllllllIIIllIllllIIlIlIIII.getMethodInfo2().rebuildStackMapIf6(lllllllllllllIIIllIllllIIlIIllll.getClassPool(), lllllllllllllIIIllIllllIIlIIllll.getClassFile2());
            return lllllllllllllIIIllIllllIIlIlIIII;
        }
        catch (BadBytecode lllllllllllllIIIllIllllIIlIIlllI) {
            throw new CompileError(lllllllllllllIIIllIllllIIlIIlllI.getMessage());
        }
        catch (CannotCompileException lllllllllllllIIIllIllllIIlIIllIl) {
            throw new CompileError(lllllllllllllIIIllIllllIIlIIllIl.getMessage());
        }
    }
    
    private CtField compileField(final FieldDecl lllllllllllllIIIllIllllIIIllllIl) throws CompileError, CannotCompileException {
        final Declarator lllllllllllllIIIllIllllIIIlllIll = lllllllllllllIIIllIllllIIIllllIl.getDeclarator();
        final CtFieldWithInit lllllllllllllIIIllIllllIIIllllII = new CtFieldWithInit(this.gen.resolver.lookupClass(lllllllllllllIIIllIllllIIIlllIll), lllllllllllllIIIllIllllIIIlllIll.getVariable().get(), this.gen.getThisClass());
        lllllllllllllIIIllIllllIIIllllII.setModifiers(MemberResolver.getModifiers(lllllllllllllIIIllIllllIIIllllIl.getModifiers()));
        if (lllllllllllllIIIllIllllIIIllllIl.getInit() != null) {
            lllllllllllllIIIllIllllIIIllllII.setInit(lllllllllllllIIIllIllllIIIllllIl.getInit());
        }
        return lllllllllllllIIIllIllllIIIllllII;
    }
    
    public static class CtFieldWithInit extends CtField
    {
        private /* synthetic */ ASTree init;
        
        @Override
        protected ASTree getInitAST() {
            return this.init;
        }
        
        CtFieldWithInit(final CtClass lllllllllllllIIIIlIllIIlIIIllIll, final String lllllllllllllIIIIlIllIIlIIIllIlI, final CtClass lllllllllllllIIIIlIllIIlIIIllIIl) throws CannotCompileException {
            super(lllllllllllllIIIIlIllIIlIIIllIll, lllllllllllllIIIIlIllIIlIIIllIlI, lllllllllllllIIIIlIllIIlIIIllIIl);
            this.init = null;
        }
        
        protected void setInit(final ASTree lllllllllllllIIIIlIllIIlIIIlIIll) {
            this.init = lllllllllllllIIIIlIllIIlIIIlIIll;
        }
    }
}
