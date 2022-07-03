package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.compiler.ast.*;

public final class Parser implements TokenId
{
    private /* synthetic */ Lex lex;
    private static final /* synthetic */ int[] binaryOpPrecedence;
    
    private int getOpPrecedence(final int llllllllllllllIIIIllIIIIllIlIIll) {
        if (33 <= llllllllllllllIIIIllIIIIllIlIIll && llllllllllllllIIIIllIIIIllIlIIll <= 63) {
            return Parser.binaryOpPrecedence[llllllllllllllIIIIllIIIIllIlIIll - 33];
        }
        if (llllllllllllllIIIIllIIIIllIlIIll == 94) {
            return 7;
        }
        if (llllllllllllllIIIIllIIIIllIlIIll == 124) {
            return 8;
        }
        if (llllllllllllllIIIIllIIIIllIlIIll == 369) {
            return 9;
        }
        if (llllllllllllllIIIIllIIIIllIlIIll == 368) {
            return 10;
        }
        if (llllllllllllllIIIIllIIIIllIlIIll == 358 || llllllllllllllIIIIllIIIIllIlIIll == 350) {
            return 5;
        }
        if (llllllllllllllIIIIllIIIIllIlIIll == 357 || llllllllllllllIIIIllIIIIllIlIIll == 359 || llllllllllllllIIIIllIIIIllIlIIll == 323) {
            return 4;
        }
        if (llllllllllllllIIIIllIIIIllIlIIll == 364 || llllllllllllllIIIIllIIIIllIlIIll == 366 || llllllllllllllIIIIllIIIIllIlIIll == 370) {
            return 3;
        }
        return 0;
    }
    
    private Stmnt parseSwitch(final SymbolTable llllllllllllllIIIIllIIlIlIIlIIlI) throws CompileError {
        final int llllllllllllllIIIIllIIlIlIIlIllI = this.lex.get();
        final ASTree llllllllllllllIIIIllIIlIlIIlIlIl = this.parseParExpression(llllllllllllllIIIIllIIlIlIIlIIlI);
        final Stmnt llllllllllllllIIIIllIIlIlIIlIlII = this.parseSwitchBlock(llllllllllllllIIIIllIIlIlIIlIIlI);
        return new Stmnt(llllllllllllllIIIIllIIlIlIIlIllI, llllllllllllllIIIIllIIlIlIIlIlIl, llllllllllllllIIIIllIIlIlIIlIlII);
    }
    
    private ASTree parseInitializer(final SymbolTable llllllllllllllIIIIllIIIllIlIIllI) throws CompileError {
        if (this.lex.lookAhead() == 123) {
            return this.parseArrayInitializer(llllllllllllllIIIIllIIIllIlIIllI);
        }
        return this.parseExpression(llllllllllllllIIIIllIIIllIlIIllI);
    }
    
    public ASTList parseMember(final SymbolTable llllllllllllllIIIIllIIllIlllIllI) throws CompileError {
        final ASTList llllllllllllllIIIIllIIllIllllIII = this.parseMember1(llllllllllllllIIIIllIIllIlllIllI);
        if (llllllllllllllIIIIllIIllIllllIII instanceof MethodDecl) {
            return this.parseMethod2(llllllllllllllIIIIllIIllIlllIllI, (MethodDecl)llllllllllllllIIIIllIIllIllllIII);
        }
        return llllllllllllllIIIIllIIllIllllIII;
    }
    
    private Stmnt parseThrow(final SymbolTable llllllllllllllIIIIllIIlIIIllIIll) throws CompileError {
        final int llllllllllllllIIIIllIIlIIIllIIlI = this.lex.get();
        final ASTree llllllllllllllIIIIllIIlIIIllIIIl = this.parseExpression(llllllllllllllIIIIllIIlIIIllIIll);
        if (this.lex.get() != 59) {
            throw new CompileError("; is missing", this.lex);
        }
        return new Stmnt(llllllllllllllIIIIllIIlIIIllIIlI, llllllllllllllIIIIllIIlIIIllIIIl);
    }
    
    private void toClassName(final ASTree llllllllllllllIIIIllIIIIIIIlIIll, final StringBuffer llllllllllllllIIIIllIIIIIIIlIIlI) throws CompileError {
        if (llllllllllllllIIIIllIIIIIIIlIIll instanceof Symbol) {
            llllllllllllllIIIIllIIIIIIIlIIlI.append(((Symbol)llllllllllllllIIIIllIIIIIIIlIIll).get());
            return;
        }
        if (llllllllllllllIIIIllIIIIIIIlIIll instanceof Expr) {
            final Expr llllllllllllllIIIIllIIIIIIIllIII = (Expr)llllllllllllllIIIIllIIIIIIIlIIll;
            if (llllllllllllllIIIIllIIIIIIIllIII.getOperator() == 46) {
                this.toClassName(llllllllllllllIIIIllIIIIIIIllIII.oprand1(), llllllllllllllIIIIllIIIIIIIlIIlI);
                llllllllllllllIIIIllIIIIIIIlIIlI.append('.');
                this.toClassName(llllllllllllllIIIIllIIIIIIIllIII.oprand2(), llllllllllllllIIIIllIIIIIIIlIIlI);
                return;
            }
        }
        throw new CompileError("bad static member access", this.lex);
    }
    
    private ASTree parseConditionalExpr(final SymbolTable llllllllllllllIIIIllIIIlIlIIIIII) throws CompileError {
        final ASTree llllllllllllllIIIIllIIIlIlIIIIlI = this.parseBinaryExpr(llllllllllllllIIIIllIIIlIlIIIIII);
        if (this.lex.lookAhead() != 63) {
            return llllllllllllllIIIIllIIIlIlIIIIlI;
        }
        this.lex.get();
        final ASTree llllllllllllllIIIIllIIIlIlIIlIII = this.parseExpression(llllllllllllllIIIIllIIIlIlIIIIII);
        if (this.lex.get() != 58) {
            throw new CompileError(": is missing", this.lex);
        }
        final ASTree llllllllllllllIIIIllIIIlIlIIIllI = this.parseExpression(llllllllllllllIIIIllIIIlIlIIIIII);
        return new CondExpr(llllllllllllllIIIIllIIIlIlIIIIlI, llllllllllllllIIIIllIIIlIlIIlIII, llllllllllllllIIIIllIIIlIlIIIllI);
    }
    
    private ASTList parseClassType(final SymbolTable llllllllllllllIIIIllIIIIIlllIlII) throws CompileError {
        ASTList llllllllllllllIIIIllIIIIIlllIIll = null;
        while (this.lex.get() == 400) {
            llllllllllllllIIIIllIIIIIlllIIll = ASTList.append(llllllllllllllIIIIllIIIIIlllIIll, new Symbol(this.lex.getString()));
            if (this.lex.lookAhead() != 46) {
                return llllllllllllllIIIIllIIIIIlllIIll;
            }
            this.lex.get();
        }
        throw new SyntaxError(this.lex);
    }
    
    public boolean hasMore() {
        return this.lex.lookAhead() >= 0;
    }
    
    private Stmnt parseBreak(final SymbolTable llllllllllllllIIIIllIIlIIIlIlIIl) throws CompileError {
        return this.parseContinue(llllllllllllllIIIIllIIlIIIlIlIIl);
    }
    
    private Declarator parseDeclarator(final SymbolTable llllllllllllllIIIIllIIIllIllIlll, final Declarator llllllllllllllIIIIllIIIllIllIllI) throws CompileError {
        if (this.lex.get() != 400 || llllllllllllllIIIIllIIIllIllIllI.getType() == 344) {
            throw new SyntaxError(this.lex);
        }
        final String llllllllllllllIIIIllIIIllIllllll = this.lex.getString();
        final Symbol llllllllllllllIIIIllIIIllIllllIl = new Symbol(llllllllllllllIIIIllIIIllIllllll);
        final int llllllllllllllIIIIllIIIllIllllII = this.parseArrayDimension();
        ASTree llllllllllllllIIIIllIIIllIlllIlI = null;
        if (this.lex.lookAhead() == 61) {
            this.lex.get();
            llllllllllllllIIIIllIIIllIlllIlI = this.parseInitializer(llllllllllllllIIIIllIIIllIllIlll);
        }
        final Declarator llllllllllllllIIIIllIIIllIlllIIl = llllllllllllllIIIIllIIIllIllIllI.make(llllllllllllllIIIIllIIIllIllllIl, llllllllllllllIIIIllIIIllIllllII, llllllllllllllIIIIllIIIllIlllIlI);
        llllllllllllllIIIIllIIIllIllIlll.append(llllllllllllllIIIIllIIIllIllllll, llllllllllllllIIIIllIIIllIlllIIl);
        return llllllllllllllIIIIllIIIllIlllIIl;
    }
    
    private MethodDecl parseMethod1(final SymbolTable llllllllllllllIIIIllIIllIlIIIlIl, final boolean llllllllllllllIIIIllIIllIIllllIl, final ASTList llllllllllllllIIIIllIIllIlIIIIll, final Declarator llllllllllllllIIIIllIIllIlIIIIlI) throws CompileError {
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        ASTList llllllllllllllIIIIllIIllIlIIIIIl = null;
        if (this.lex.lookAhead() != 41) {
            while (true) {
                llllllllllllllIIIIllIIllIlIIIIIl = ASTList.append(llllllllllllllIIIIllIIllIlIIIIIl, this.parseFormalParam(llllllllllllllIIIIllIIllIlIIIlIl));
                final int llllllllllllllIIIIllIIllIlIIIlll = this.lex.lookAhead();
                if (llllllllllllllIIIIllIIllIlIIIlll == 44) {
                    this.lex.get();
                }
                else {
                    if (llllllllllllllIIIIllIIllIlIIIlll == 41) {
                        break;
                    }
                    continue;
                }
            }
        }
        this.lex.get();
        llllllllllllllIIIIllIIllIlIIIIlI.addArrayDim(this.parseArrayDimension());
        if (llllllllllllllIIIIllIIllIIllllIl && llllllllllllllIIIIllIIllIlIIIIlI.getArrayDim() > 0) {
            throw new SyntaxError(this.lex);
        }
        ASTList llllllllllllllIIIIllIIllIlIIIIII = null;
        if (this.lex.lookAhead() == 341) {
            this.lex.get();
            while (true) {
                llllllllllllllIIIIllIIllIlIIIIII = ASTList.append(llllllllllllllIIIIllIIllIlIIIIII, this.parseClassType(llllllllllllllIIIIllIIllIlIIIlIl));
                if (this.lex.lookAhead() != 44) {
                    break;
                }
                this.lex.get();
            }
        }
        return new MethodDecl(llllllllllllllIIIIllIIllIlIIIIll, new ASTList(llllllllllllllIIIIllIIllIlIIIIlI, ASTList.make(llllllllllllllIIIIllIIllIlIIIIIl, llllllllllllllIIIIllIIllIlIIIIII, null)));
    }
    
    private Stmnt parseIf(final SymbolTable llllllllllllllIIIIllIIlIlllIIIIl) throws CompileError {
        final int llllllllllllllIIIIllIIlIlllIIIII = this.lex.get();
        final ASTree llllllllllllllIIIIllIIlIllIlllll = this.parseParExpression(llllllllllllllIIIIllIIlIlllIIIIl);
        final Stmnt llllllllllllllIIIIllIIlIllIllllI = this.parseStatement(llllllllllllllIIIIllIIlIlllIIIIl);
        Stmnt llllllllllllllIIIIllIIlIllIlllIl = null;
        if (this.lex.lookAhead() == 313) {
            this.lex.get();
            final Stmnt llllllllllllllIIIIllIIlIlllIIIll = this.parseStatement(llllllllllllllIIIIllIIlIlllIIIIl);
        }
        else {
            llllllllllllllIIIIllIIlIllIlllIl = null;
        }
        return new Stmnt(llllllllllllllIIIIllIIlIlllIIIII, llllllllllllllIIIIllIIlIllIlllll, new ASTList(llllllllllllllIIIIllIIlIllIllllI, new ASTList(llllllllllllllIIIIllIIlIllIlllIl)));
    }
    
    public ASTree parseExpression(final SymbolTable llllllllllllllIIIIllIIIlIllIlIll) throws CompileError {
        final ASTree llllllllllllllIIIIllIIIlIllIlIlI = this.parseConditionalExpr(llllllllllllllIIIIllIIIlIllIlIll);
        if (!isAssignOp(this.lex.lookAhead())) {
            return llllllllllllllIIIIllIIIlIllIlIlI;
        }
        final int llllllllllllllIIIIllIIIlIllIlIII = this.lex.get();
        final ASTree llllllllllllllIIIIllIIIlIllIIllI = this.parseExpression(llllllllllllllIIIIllIIIlIllIlIll);
        return AssignExpr.makeAssign(llllllllllllllIIIIllIIIlIllIlIII, llllllllllllllIIIIllIIIlIllIlIlI, llllllllllllllIIIIllIIIlIllIIllI);
    }
    
    public MethodDecl parseMethod2(final SymbolTable llllllllllllllIIIIllIIllIIllIIll, final MethodDecl llllllllllllllIIIIllIIllIIlIlllI) throws CompileError {
        Stmnt llllllllllllllIIIIllIIllIIllIIIl = null;
        if (this.lex.lookAhead() == 59) {
            this.lex.get();
        }
        else {
            llllllllllllllIIIIllIIllIIllIIIl = this.parseBlock(llllllllllllllIIIIllIIllIIllIIll);
            if (llllllllllllllIIIIllIIllIIllIIIl == null) {
                llllllllllllllIIIIllIIllIIllIIIl = new Stmnt(66);
            }
        }
        llllllllllllllIIIIllIIllIIlIlllI.sublist(4).setHead(llllllllllllllIIIIllIIllIIllIIIl);
        return llllllllllllllIIIIllIIllIIlIlllI;
    }
    
    private Stmnt parseSwitchBlock(final SymbolTable llllllllllllllIIIIllIIlIIlllllIl) throws CompileError {
        if (this.lex.get() != 123) {
            throw new SyntaxError(this.lex);
        }
        final SymbolTable llllllllllllllIIIIllIIlIlIIIIIlI = new SymbolTable(llllllllllllllIIIIllIIlIIlllllIl);
        Stmnt llllllllllllllIIIIllIIlIlIIIIIIl = this.parseStmntOrCase(llllllllllllllIIIIllIIlIlIIIIIlI);
        if (llllllllllllllIIIIllIIlIlIIIIIIl == null) {
            throw new CompileError("empty switch block", this.lex);
        }
        final int llllllllllllllIIIIllIIlIlIIIIIII = llllllllllllllIIIIllIIlIlIIIIIIl.getOperator();
        if (llllllllllllllIIIIllIIlIlIIIIIII != 304 && llllllllllllllIIIIllIIlIlIIIIIII != 310) {
            throw new CompileError("no case or default in a switch block", this.lex);
        }
        Stmnt llllllllllllllIIIIllIIlIIlllllll = new Stmnt(66, llllllllllllllIIIIllIIlIlIIIIIIl);
        while (this.lex.lookAhead() != 125) {
            final Stmnt llllllllllllllIIIIllIIlIlIIIIlIl = this.parseStmntOrCase(llllllllllllllIIIIllIIlIlIIIIIlI);
            if (llllllllllllllIIIIllIIlIlIIIIlIl != null) {
                final int llllllllllllllIIIIllIIlIlIIIIllI = llllllllllllllIIIIllIIlIlIIIIlIl.getOperator();
                if (llllllllllllllIIIIllIIlIlIIIIllI == 304 || llllllllllllllIIIIllIIlIlIIIIllI == 310) {
                    llllllllllllllIIIIllIIlIIlllllll = (Stmnt)ASTList.concat(llllllllllllllIIIIllIIlIIlllllll, new Stmnt(66, llllllllllllllIIIIllIIlIlIIIIlIl));
                    llllllllllllllIIIIllIIlIlIIIIIIl = llllllllllllllIIIIllIIlIlIIIIlIl;
                }
                else {
                    llllllllllllllIIIIllIIlIlIIIIIIl = (Stmnt)ASTList.concat(llllllllllllllIIIIllIIlIlIIIIIIl, new Stmnt(66, llllllllllllllIIIIllIIlIlIIIIlIl));
                }
            }
        }
        this.lex.get();
        return llllllllllllllIIIIllIIlIIlllllll;
    }
    
    private Stmnt parseBlock(final SymbolTable llllllllllllllIIIIllIIlIllllIIIl) throws CompileError {
        if (this.lex.get() != 123) {
            throw new SyntaxError(this.lex);
        }
        Stmnt llllllllllllllIIIIllIIlIllllIIII = null;
        final SymbolTable llllllllllllllIIIIllIIlIlllIllll = new SymbolTable(llllllllllllllIIIIllIIlIllllIIIl);
        while (this.lex.lookAhead() != 125) {
            final Stmnt llllllllllllllIIIIllIIlIllllIIll = this.parseStatement(llllllllllllllIIIIllIIlIlllIllll);
            if (llllllllllllllIIIIllIIlIllllIIll != null) {
                llllllllllllllIIIIllIIlIllllIIII = (Stmnt)ASTList.concat(llllllllllllllIIIIllIIlIllllIIII, new Stmnt(66, llllllllllllllIIIIllIIlIllllIIll));
            }
        }
        this.lex.get();
        if (llllllllllllllIIIIllIIlIllllIIII == null) {
            return new Stmnt(66);
        }
        return llllllllllllllIIIIllIIlIllllIIII;
    }
    
    private ASTree parseInstanceOf(final SymbolTable llllllllllllllIIIIllIIIlIIIlIIll, final ASTree llllllllllllllIIIIllIIIlIIIIllII) throws CompileError {
        final int llllllllllllllIIIIllIIIlIIIlIIIl = this.lex.lookAhead();
        if (isBuiltinType(llllllllllllllIIIIllIIIlIIIlIIIl)) {
            this.lex.get();
            final int llllllllllllllIIIIllIIIlIIIlIlIl = this.parseArrayDimension();
            return new InstanceOfExpr(llllllllllllllIIIIllIIIlIIIlIIIl, llllllllllllllIIIIllIIIlIIIlIlIl, llllllllllllllIIIIllIIIlIIIIllII);
        }
        final ASTList llllllllllllllIIIIllIIIlIIIlIIII = this.parseClassType(llllllllllllllIIIIllIIIlIIIlIIll);
        final int llllllllllllllIIIIllIIIlIIIIllll = this.parseArrayDimension();
        return new InstanceOfExpr(llllllllllllllIIIIllIIIlIIIlIIII, llllllllllllllIIIIllIIIlIIIIllll, llllllllllllllIIIIllIIIlIIIIllII);
    }
    
    private ASTList parseArraySize(final SymbolTable llllllllllllllIIIIlIlllllllIIIll) throws CompileError {
        ASTList llllllllllllllIIIIlIlllllllIIIlI = null;
        while (this.lex.lookAhead() == 91) {
            llllllllllllllIIIIlIlllllllIIIlI = ASTList.append(llllllllllllllIIIIlIlllllllIIIlI, this.parseArrayIndex(llllllllllllllIIIIlIlllllllIIIll));
        }
        return llllllllllllllIIIIlIlllllllIIIlI;
    }
    
    private ASTList parseMemberMods() {
        ASTList llllllllllllllIIIIllIIllIIlIIlll = null;
        while (true) {
            final int llllllllllllllIIIIllIIllIIlIlIII = this.lex.lookAhead();
            if (llllllllllllllIIIIllIIllIIlIlIII != 300 && llllllllllllllIIIIllIIllIIlIlIII != 315 && llllllllllllllIIIIllIIllIIlIlIII != 332 && llllllllllllllIIIIllIIllIIlIlIII != 331 && llllllllllllllIIIIllIIllIIlIlIII != 330 && llllllllllllllIIIIllIIllIIlIlIII != 338 && llllllllllllllIIIIllIIllIIlIlIII != 335 && llllllllllllllIIIIllIIllIIlIlIII != 345 && llllllllllllllIIIIllIIllIIlIlIII != 342 && llllllllllllllIIIIllIIllIIlIlIII != 347) {
                break;
            }
            llllllllllllllIIIIllIIllIIlIIlll = new ASTList(new Keyword(this.lex.get()), llllllllllllllIIIIllIIllIIlIIlll);
        }
        return llllllllllllllIIIIllIIllIIlIIlll;
    }
    
    private ASTree parseDotClass(final int llllllllllllllIIIIllIIIIIIllIlIl, final int llllllllllllllIIIIllIIIIIIllIlII) throws CompileError {
        if (llllllllllllllIIIIllIIIIIIllIlII > 0) {
            final String llllllllllllllIIIIllIIIIIlIIIIll = CodeGen.toJvmTypeName(llllllllllllllIIIIllIIIIIIllIlIl, llllllllllllllIIIIllIIIIIIllIlII);
            return Expr.make(46, new Symbol(llllllllllllllIIIIllIIIIIlIIIIll), new Member("class"));
        }
        switch (llllllllllllllIIIIllIIIIIIllIlIl) {
            case 301: {
                final String llllllllllllllIIIIllIIIIIlIIIIlI = "java.lang.Boolean";
                break;
            }
            case 303: {
                final String llllllllllllllIIIIllIIIIIlIIIIIl = "java.lang.Byte";
                break;
            }
            case 306: {
                final String llllllllllllllIIIIllIIIIIlIIIIII = "java.lang.Character";
                break;
            }
            case 334: {
                final String llllllllllllllIIIIllIIIIIIllllll = "java.lang.Short";
                break;
            }
            case 324: {
                final String llllllllllllllIIIIllIIIIIIlllllI = "java.lang.Integer";
                break;
            }
            case 326: {
                final String llllllllllllllIIIIllIIIIIIllllIl = "java.lang.Long";
                break;
            }
            case 317: {
                final String llllllllllllllIIIIllIIIIIIllllII = "java.lang.Float";
                break;
            }
            case 312: {
                final String llllllllllllllIIIIllIIIIIIlllIll = "java.lang.Double";
                break;
            }
            case 344: {
                final String llllllllllllllIIIIllIIIIIIlllIlI = "java.lang.Void";
                break;
            }
            default: {
                throw new CompileError(String.valueOf(new StringBuilder().append("invalid builtin type: ").append(llllllllllllllIIIIllIIIIIIllIlIl)));
            }
        }
        final String llllllllllllllIIIIllIIIIIIllIllI;
        return Expr.make(35, new Symbol(llllllllllllllIIIIllIIIIIIllIllI), new Member("TYPE"));
    }
    
    private ASTree parseUnaryExpr(final SymbolTable llllllllllllllIIIIllIIIIllIIIIIl) throws CompileError {
        switch (this.lex.lookAhead()) {
            case 33:
            case 43:
            case 45:
            case 126:
            case 362:
            case 363: {
                final int llllllllllllllIIIIllIIIIllIIIIll = this.lex.get();
                if (llllllllllllllIIIIllIIIIllIIIIll == 45) {
                    final int llllllllllllllIIIIllIIIIllIIIlII = this.lex.lookAhead();
                    switch (llllllllllllllIIIIllIIIIllIIIlII) {
                        case 401:
                        case 402:
                        case 403: {
                            this.lex.get();
                            return new IntConst(-this.lex.getLong(), llllllllllllllIIIIllIIIIllIIIlII);
                        }
                        case 404:
                        case 405: {
                            this.lex.get();
                            return new DoubleConst(-this.lex.getDouble(), llllllllllllllIIIIllIIIIllIIIlII);
                        }
                    }
                }
                return Expr.make(llllllllllllllIIIIllIIIIllIIIIll, this.parseUnaryExpr(llllllllllllllIIIIllIIIIllIIIIIl));
            }
            case 40: {
                return this.parseCast(llllllllllllllIIIIllIIIIllIIIIIl);
            }
            default: {
                return this.parsePostfix(llllllllllllllIIIIllIIIIllIIIIIl);
            }
        }
    }
    
    private Stmnt parseContinue(final SymbolTable llllllllllllllIIIIllIIlIIIlIIIIl) throws CompileError {
        final int llllllllllllllIIIIllIIlIIIlIIIII = this.lex.get();
        final Stmnt llllllllllllllIIIIllIIlIIIIlllll = new Stmnt(llllllllllllllIIIIllIIlIIIlIIIII);
        int llllllllllllllIIIIllIIlIIIIllllI = this.lex.get();
        if (llllllllllllllIIIIllIIlIIIIllllI == 400) {
            llllllllllllllIIIIllIIlIIIIlllll.setLeft(new Symbol(this.lex.getString()));
            llllllllllllllIIIIllIIlIIIIllllI = this.lex.get();
        }
        if (llllllllllllllIIIIllIIlIIIIllllI != 59) {
            throw new CompileError("; is missing", this.lex);
        }
        return llllllllllllllIIIIllIIlIIIIlllll;
    }
    
    private ASTree parseBinaryExpr(final SymbolTable llllllllllllllIIIIllIIIlIIlIlIlI) throws CompileError {
        ASTree llllllllllllllIIIIllIIIlIIlIllIl = this.parseUnaryExpr(llllllllllllllIIIIllIIIlIIlIlIlI);
        while (true) {
            final int llllllllllllllIIIIllIIIlIIllIlII = this.lex.lookAhead();
            final int llllllllllllllIIIIllIIIlIIllIIlI = this.getOpPrecedence(llllllllllllllIIIIllIIIlIIllIlII);
            if (llllllllllllllIIIIllIIIlIIllIIlI == 0) {
                break;
            }
            llllllllllllllIIIIllIIIlIIlIllIl = this.binaryExpr2(llllllllllllllIIIIllIIIlIIlIlIlI, llllllllllllllIIIIllIIIlIIlIllIl, llllllllllllllIIIIllIIIlIIllIIlI);
        }
        return llllllllllllllIIIIllIIIlIIlIllIl;
    }
    
    private ASTree binaryExpr2(final SymbolTable llllllllllllllIIIIllIIIIllllIIII, final ASTree llllllllllllllIIIIllIIIIlllIlIIl, final int llllllllllllllIIIIllIIIIlllIlIII) throws CompileError {
        final int llllllllllllllIIIIllIIIIlllIllIl = this.lex.get();
        if (llllllllllllllIIIIllIIIIlllIllIl == 323) {
            return this.parseInstanceOf(llllllllllllllIIIIllIIIIllllIIII, llllllllllllllIIIIllIIIIlllIlIIl);
        }
        ASTree llllllllllllllIIIIllIIIIlllIllII = this.parseUnaryExpr(llllllllllllllIIIIllIIIIllllIIII);
        while (true) {
            final int llllllllllllllIIIIllIIIIllllIIll = this.lex.lookAhead();
            final int llllllllllllllIIIIllIIIIllllIIlI = this.getOpPrecedence(llllllllllllllIIIIllIIIIllllIIll);
            if (llllllllllllllIIIIllIIIIllllIIlI == 0 || llllllllllllllIIIIllIIIIlllIlIII <= llllllllllllllIIIIllIIIIllllIIlI) {
                break;
            }
            llllllllllllllIIIIllIIIIlllIllII = this.binaryExpr2(llllllllllllllIIIIllIIIIllllIIII, llllllllllllllIIIIllIIIIlllIllII, llllllllllllllIIIIllIIIIllllIIlI);
        }
        return BinExpr.makeBin(llllllllllllllIIIIllIIIIlllIllIl, llllllllllllllIIIIllIIIIlllIlIIl, llllllllllllllIIIIllIIIIlllIllII);
    }
    
    public ASTList parseMember1(final SymbolTable llllllllllllllIIIIllIIllIllIIlIl) throws CompileError {
        final ASTList llllllllllllllIIIIllIIllIllIlIlI = this.parseMemberMods();
        boolean llllllllllllllIIIIllIIllIllIlIII = false;
        Declarator llllllllllllllIIIIllIIllIllIlIIl = null;
        if (this.lex.lookAhead() == 400 && this.lex.lookAhead(1) == 40) {
            final Declarator llllllllllllllIIIIllIIllIllIlllI = new Declarator(344, 0);
            llllllllllllllIIIIllIIllIllIlIII = true;
        }
        else {
            llllllllllllllIIIIllIIllIllIlIIl = this.parseFormalType(llllllllllllllIIIIllIIllIllIIlIl);
        }
        if (this.lex.get() != 400) {
            throw new SyntaxError(this.lex);
        }
        String llllllllllllllIIIIllIIllIllIIlll = null;
        if (llllllllllllllIIIIllIIllIllIlIII) {
            final String llllllllllllllIIIIllIIllIllIllIl = "<init>";
        }
        else {
            llllllllllllllIIIIllIIllIllIIlll = this.lex.getString();
        }
        llllllllllllllIIIIllIIllIllIlIIl.setVariable(new Symbol(llllllllllllllIIIIllIIllIllIIlll));
        if (llllllllllllllIIIIllIIllIllIlIII || this.lex.lookAhead() == 40) {
            return this.parseMethod1(llllllllllllllIIIIllIIllIllIIlIl, llllllllllllllIIIIllIIllIllIlIII, llllllllllllllIIIIllIIllIllIlIlI, llllllllllllllIIIIllIIllIllIlIIl);
        }
        return this.parseField(llllllllllllllIIIIllIIllIllIIlIl, llllllllllllllIIIIllIIllIllIlIlI, llllllllllllllIIIIllIIllIllIlIIl);
    }
    
    static {
        binaryOpPrecedence = new int[] { 0, 0, 0, 0, 1, 6, 0, 0, 0, 1, 2, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0 };
    }
    
    private ASTree parsePrimaryExpr(final SymbolTable llllllllllllllIIIIllIIIIIIIIIlII) throws CompileError {
        final int llllllllllllllIIIIllIIIIIIIIIIll;
        switch (llllllllllllllIIIIllIIIIIIIIIIll = this.lex.get()) {
            case 336:
            case 339:
            case 410:
            case 411:
            case 412: {
                return new Keyword(llllllllllllllIIIIllIIIIIIIIIIll);
            }
            case 400: {
                final String llllllllllllllIIIIllIIIIIIIIlIIl = this.lex.getString();
                final Declarator llllllllllllllIIIIllIIIIIIIIlIII = llllllllllllllIIIIllIIIIIIIIIlII.lookup(llllllllllllllIIIIllIIIIIIIIlIIl);
                if (llllllllllllllIIIIllIIIIIIIIlIII == null) {
                    return new Member(llllllllllllllIIIIllIIIIIIIIlIIl);
                }
                return new Variable(llllllllllllllIIIIllIIIIIIIIlIIl, llllllllllllllIIIIllIIIIIIIIlIII);
            }
            case 406: {
                return new StringL(this.lex.getString());
            }
            case 328: {
                return this.parseNew(llllllllllllllIIIIllIIIIIIIIIlII);
            }
            case 40: {
                final ASTree llllllllllllllIIIIllIIIIIIIIIlll = this.parseExpression(llllllllllllllIIIIllIIIIIIIIIlII);
                if (this.lex.get() == 41) {
                    return llllllllllllllIIIIllIIIIIIIIIlll;
                }
                throw new CompileError(") is missing", this.lex);
            }
            default: {
                if (isBuiltinType(llllllllllllllIIIIllIIIIIIIIIIll) || llllllllllllllIIIIllIIIIIIIIIIll == 344) {
                    final int llllllllllllllIIIIllIIIIIIIIIllI = this.parseArrayDimension();
                    if (this.lex.get() == 46 && this.lex.get() == 307) {
                        return this.parseDotClass(llllllllllllllIIIIllIIIIIIIIIIll, llllllllllllllIIIIllIIIIIIIIIllI);
                    }
                }
                throw new SyntaxError(this.lex);
            }
        }
    }
    
    private ArrayInit parseArrayInitializer(final SymbolTable llllllllllllllIIIIllIIIllIIlIIIl) throws CompileError {
        this.lex.get();
        if (this.lex.lookAhead() == 125) {
            this.lex.get();
            return new ArrayInit(null);
        }
        ASTree llllllllllllllIIIIllIIIllIIlIlII = this.parseExpression(llllllllllllllIIIIllIIIllIIlIIIl);
        final ArrayInit llllllllllllllIIIIllIIIllIIlIIll = new ArrayInit(llllllllllllllIIIIllIIIllIIlIlII);
        while (this.lex.lookAhead() == 44) {
            this.lex.get();
            llllllllllllllIIIIllIIIllIIlIlII = this.parseExpression(llllllllllllllIIIIllIIIllIIlIIIl);
            ASTList.append(llllllllllllllIIIIllIIIllIIlIIll, llllllllllllllIIIIllIIIllIIlIlII);
        }
        if (this.lex.get() != 125) {
            throw new SyntaxError(this.lex);
        }
        return llllllllllllllIIIIllIIIllIIlIIll;
    }
    
    private FieldDecl parseField(final SymbolTable llllllllllllllIIIIllIIllIlIllIIl, final ASTList llllllllllllllIIIIllIIllIlIlIIlI, final Declarator llllllllllllllIIIIllIIllIlIlIIIl) throws CompileError {
        ASTree llllllllllllllIIIIllIIllIlIlIllI = null;
        if (this.lex.lookAhead() == 61) {
            this.lex.get();
            llllllllllllllIIIIllIIllIlIlIllI = this.parseExpression(llllllllllllllIIIIllIIllIlIllIIl);
        }
        final int llllllllllllllIIIIllIIllIlIlIlIl = this.lex.get();
        if (llllllllllllllIIIIllIIllIlIlIlIl == 59) {
            return new FieldDecl(llllllllllllllIIIIllIIllIlIlIIlI, new ASTList(llllllllllllllIIIIllIIllIlIlIIIl, new ASTList(llllllllllllllIIIIllIIllIlIlIllI)));
        }
        if (llllllllllllllIIIIllIIllIlIlIlIl == 44) {
            throw new CompileError("only one field can be declared in one declaration", this.lex);
        }
        throw new SyntaxError(this.lex);
    }
    
    private int nextIsClassType(int llllllllllllllIIIIllIIIIlIIIIIlI) {
        while (this.lex.lookAhead(++llllllllllllllIIIIllIIIIlIIIIIlI) == 46) {
            if (this.lex.lookAhead(++llllllllllllllIIIIllIIIIlIIIIIlI) != 400) {
                return -1;
            }
        }
        int llllllllllllllIIIIllIIIIlIIIIIIl;
        while ((llllllllllllllIIIIllIIIIlIIIIIIl = this.lex.lookAhead(llllllllllllllIIIIllIIIIlIIIIIlI++)) == 91) {
            if (this.lex.lookAhead(llllllllllllllIIIIllIIIIlIIIIIlI++) != 93) {
                return -1;
            }
        }
        return llllllllllllllIIIIllIIIIlIIIIIlI - 1;
    }
    
    private ASTree parseMethodCall(final SymbolTable llllllllllllllIIIIllIIIIIIlIlIII, final ASTree llllllllllllllIIIIllIIIIIIlIIlll) throws CompileError {
        if (llllllllllllllIIIIllIIIIIIlIIlll instanceof Keyword) {
            final int llllllllllllllIIIIllIIIIIIlIlllI = ((Keyword)llllllllllllllIIIIllIIIIIIlIIlll).get();
            if (llllllllllllllIIIIllIIIIIIlIlllI != 339 && llllllllllllllIIIIllIIIIIIlIlllI != 336) {
                throw new SyntaxError(this.lex);
            }
        }
        else if (!(llllllllllllllIIIIllIIIIIIlIIlll instanceof Symbol)) {
            if (llllllllllllllIIIIllIIIIIIlIIlll instanceof Expr) {
                final int llllllllllllllIIIIllIIIIIIlIllIl = ((Expr)llllllllllllllIIIIllIIIIIIlIIlll).getOperator();
                if (llllllllllllllIIIIllIIIIIIlIllIl != 46 && llllllllllllllIIIIllIIIIIIlIllIl != 35) {
                    throw new SyntaxError(this.lex);
                }
            }
        }
        return CallExpr.makeCall(llllllllllllllIIIIllIIIIIIlIIlll, this.parseArgumentList(llllllllllllllIIIIllIIIIIIlIlIII));
    }
    
    private NewExpr parseNew(final SymbolTable llllllllllllllIIIIlIllllllllIIII) throws CompileError {
        ArrayInit llllllllllllllIIIIlIlllllllIllll = null;
        int llllllllllllllIIIIlIlllllllIlllI = this.lex.lookAhead();
        if (isBuiltinType(llllllllllllllIIIIlIlllllllIlllI)) {
            this.lex.get();
            final ASTList llllllllllllllIIIIlIllllllllIlIl = this.parseArraySize(llllllllllllllIIIIlIllllllllIIII);
            if (this.lex.lookAhead() == 123) {
                llllllllllllllIIIIlIlllllllIllll = this.parseArrayInitializer(llllllllllllllIIIIlIllllllllIIII);
            }
            return new NewExpr(llllllllllllllIIIIlIlllllllIlllI, llllllllllllllIIIIlIllllllllIlIl, llllllllllllllIIIIlIlllllllIllll);
        }
        if (llllllllllllllIIIIlIlllllllIlllI == 400) {
            final ASTList llllllllllllllIIIIlIllllllllIIlI = this.parseClassType(llllllllllllllIIIIlIllllllllIIII);
            llllllllllllllIIIIlIlllllllIlllI = this.lex.lookAhead();
            if (llllllllllllllIIIIlIlllllllIlllI == 40) {
                final ASTList llllllllllllllIIIIlIllllllllIlII = this.parseArgumentList(llllllllllllllIIIIlIllllllllIIII);
                return new NewExpr(llllllllllllllIIIIlIllllllllIIlI, llllllllllllllIIIIlIllllllllIlII);
            }
            if (llllllllllllllIIIIlIlllllllIlllI == 91) {
                final ASTList llllllllllllllIIIIlIllllllllIIll = this.parseArraySize(llllllllllllllIIIIlIllllllllIIII);
                if (this.lex.lookAhead() == 123) {
                    llllllllllllllIIIIlIlllllllIllll = this.parseArrayInitializer(llllllllllllllIIIIlIllllllllIIII);
                }
                return NewExpr.makeObjectArray(llllllllllllllIIIIlIllllllllIIlI, llllllllllllllIIIIlIllllllllIIll, llllllllllllllIIIIlIlllllllIllll);
            }
        }
        throw new SyntaxError(this.lex);
    }
    
    private Stmnt parseFor(final SymbolTable llllllllllllllIIIIllIIlIlIlIllII) throws CompileError {
        final int llllllllllllllIIIIllIIlIlIlIlIII = this.lex.get();
        final SymbolTable llllllllllllllIIIIllIIlIlIlIIlll = new SymbolTable(llllllllllllllIIIIllIIlIlIlIllII);
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        Stmnt llllllllllllllIIIIllIIlIlIlIlIll = null;
        if (this.lex.lookAhead() == 59) {
            this.lex.get();
            final Stmnt llllllllllllllIIIIllIIlIlIllIIII = null;
        }
        else {
            llllllllllllllIIIIllIIlIlIlIlIll = this.parseDeclarationOrExpression(llllllllllllllIIIIllIIlIlIlIIlll, true);
        }
        ASTree llllllllllllllIIIIllIIlIlIlIlIIl = null;
        if (this.lex.lookAhead() == 59) {
            final ASTree llllllllllllllIIIIllIIlIlIlIllll = null;
        }
        else {
            llllllllllllllIIIIllIIlIlIlIlIIl = this.parseExpression(llllllllllllllIIIIllIIlIlIlIIlll);
        }
        if (this.lex.get() != 59) {
            throw new CompileError("; is missing", this.lex);
        }
        Stmnt llllllllllllllIIIIllIIlIlIlIlIlI = null;
        if (this.lex.lookAhead() == 41) {
            final Stmnt llllllllllllllIIIIllIIlIlIlIlllI = null;
        }
        else {
            llllllllllllllIIIIllIIlIlIlIlIlI = this.parseExprList(llllllllllllllIIIIllIIlIlIlIIlll);
        }
        if (this.lex.get() != 41) {
            throw new CompileError(") is missing", this.lex);
        }
        final Stmnt llllllllllllllIIIIllIIlIlIlIIllI = this.parseStatement(llllllllllllllIIIIllIIlIlIlIIlll);
        return new Stmnt(llllllllllllllIIIIllIIlIlIlIlIII, llllllllllllllIIIIllIIlIlIlIlIll, new ASTList(llllllllllllllIIIIllIIlIlIlIlIIl, new ASTList(llllllllllllllIIIIllIIlIlIlIlIlI, llllllllllllllIIIIllIIlIlIlIIllI)));
    }
    
    private ASTList parseArgumentList(final SymbolTable llllllllllllllIIIIlIllllllIlIIIl) throws CompileError {
        if (this.lex.get() != 40) {
            throw new CompileError("( is missing", this.lex);
        }
        ASTList llllllllllllllIIIIlIllllllIlIIII = null;
        if (this.lex.lookAhead() != 41) {
            while (true) {
                llllllllllllllIIIIlIllllllIlIIII = ASTList.append(llllllllllllllIIIIlIllllllIlIIII, this.parseExpression(llllllllllllllIIIIlIllllllIlIIIl));
                if (this.lex.lookAhead() != 44) {
                    break;
                }
                this.lex.get();
            }
        }
        if (this.lex.get() != 41) {
            throw new CompileError(") is missing", this.lex);
        }
        return llllllllllllllIIIIlIllllllIlIIII;
    }
    
    private Stmnt parseReturn(final SymbolTable llllllllllllllIIIIllIIlIIIllllll) throws CompileError {
        final int llllllllllllllIIIIllIIlIIIlllllI = this.lex.get();
        final Stmnt llllllllllllllIIIIllIIlIIIllllIl = new Stmnt(llllllllllllllIIIIllIIlIIIlllllI);
        if (this.lex.lookAhead() != 59) {
            llllllllllllllIIIIllIIlIIIllllIl.setLeft(this.parseExpression(llllllllllllllIIIIllIIlIIIllllll));
        }
        if (this.lex.get() != 59) {
            throw new CompileError("; is missing", this.lex);
        }
        return llllllllllllllIIIIllIIlIIIllllIl;
    }
    
    private Stmnt parseDeclarationOrExpression(final SymbolTable llllllllllllllIIIIllIIlIIIIIIlII, final boolean llllllllllllllIIIIllIIlIIIIIlIIl) throws CompileError {
        int llllllllllllllIIIIllIIlIIIIIlIII;
        for (llllllllllllllIIIIllIIlIIIIIlIII = this.lex.lookAhead(); llllllllllllllIIIIllIIlIIIIIlIII == 315; llllllllllllllIIIIllIIlIIIIIlIII = this.lex.lookAhead()) {
            this.lex.get();
        }
        if (isBuiltinType(llllllllllllllIIIIllIIlIIIIIlIII)) {
            llllllllllllllIIIIllIIlIIIIIlIII = this.lex.get();
            final int llllllllllllllIIIIllIIlIIIIlIIlI = this.parseArrayDimension();
            return this.parseDeclarators(llllllllllllllIIIIllIIlIIIIIIlII, new Declarator(llllllllllllllIIIIllIIlIIIIIlIII, llllllllllllllIIIIllIIlIIIIlIIlI));
        }
        if (llllllllllllllIIIIllIIlIIIIIlIII == 400) {
            final int llllllllllllllIIIIllIIlIIIIIlllI = this.nextIsClassType(0);
            if (llllllllllllllIIIIllIIlIIIIIlllI >= 0 && this.lex.lookAhead(llllllllllllllIIIIllIIlIIIIIlllI) == 400) {
                final ASTList llllllllllllllIIIIllIIlIIIIlIIIl = this.parseClassType(llllllllllllllIIIIllIIlIIIIIIlII);
                final int llllllllllllllIIIIllIIlIIIIlIIII = this.parseArrayDimension();
                return this.parseDeclarators(llllllllllllllIIIIllIIlIIIIIIlII, new Declarator(llllllllllllllIIIIllIIlIIIIlIIIl, llllllllllllllIIIIllIIlIIIIlIIII));
            }
        }
        Stmnt llllllllllllllIIIIllIIlIIIIIIllI = null;
        if (llllllllllllllIIIIllIIlIIIIIlIIl) {
            final Stmnt llllllllllllllIIIIllIIlIIIIIllIl = this.parseExprList(llllllllllllllIIIIllIIlIIIIIIlII);
        }
        else {
            llllllllllllllIIIIllIIlIIIIIIllI = new Stmnt(69, this.parseExpression(llllllllllllllIIIIllIIlIIIIIIlII));
        }
        if (this.lex.get() != 59) {
            throw new CompileError("; is missing", this.lex);
        }
        return llllllllllllllIIIIllIIlIIIIIIllI;
    }
    
    private Declarator parseFormalParam(final SymbolTable llllllllllllllIIIIllIIllIIIIIlll) throws CompileError {
        final Declarator llllllllllllllIIIIllIIllIIIIlIlI = this.parseFormalType(llllllllllllllIIIIllIIllIIIIIlll);
        if (this.lex.get() != 400) {
            throw new SyntaxError(this.lex);
        }
        final String llllllllllllllIIIIllIIllIIIIlIIl = this.lex.getString();
        llllllllllllllIIIIllIIllIIIIlIlI.setVariable(new Symbol(llllllllllllllIIIIllIIllIIIIlIIl));
        llllllllllllllIIIIllIIllIIIIlIlI.addArrayDim(this.parseArrayDimension());
        llllllllllllllIIIIllIIllIIIIIlll.append(llllllllllllllIIIIllIIllIIIIlIIl, llllllllllllllIIIIllIIllIIIIlIlI);
        return llllllllllllllIIIIllIIllIIIIlIlI;
    }
    
    private ASTree parseCast(final SymbolTable llllllllllllllIIIIllIIIIlIlIIllI) throws CompileError {
        final int llllllllllllllIIIIllIIIIlIlIIlII = this.lex.lookAhead(1);
        if (isBuiltinType(llllllllllllllIIIIllIIIIlIlIIlII) && this.nextIsBuiltinCast()) {
            this.lex.get();
            this.lex.get();
            final int llllllllllllllIIIIllIIIIlIlIlIlI = this.parseArrayDimension();
            if (this.lex.get() != 41) {
                throw new CompileError(") is missing", this.lex);
            }
            return new CastExpr(llllllllllllllIIIIllIIIIlIlIIlII, llllllllllllllIIIIllIIIIlIlIlIlI, this.parseUnaryExpr(llllllllllllllIIIIllIIIIlIlIIllI));
        }
        else {
            if (llllllllllllllIIIIllIIIIlIlIIlII != 400 || !this.nextIsClassCast()) {
                return this.parsePostfix(llllllllllllllIIIIllIIIIlIlIIllI);
            }
            this.lex.get();
            final ASTList llllllllllllllIIIIllIIIIlIlIlIIl = this.parseClassType(llllllllllllllIIIIllIIIIlIlIIllI);
            final int llllllllllllllIIIIllIIIIlIlIlIII = this.parseArrayDimension();
            if (this.lex.get() != 41) {
                throw new CompileError(") is missing", this.lex);
            }
            return new CastExpr(llllllllllllllIIIIllIIIIlIlIlIIl, llllllllllllllIIIIllIIIIlIlIlIII, this.parseUnaryExpr(llllllllllllllIIIIllIIIIlIlIIllI));
        }
    }
    
    private boolean nextIsClassCast() {
        final int llllllllllllllIIIIllIIIIlIIIlIll = this.nextIsClassType(1);
        if (llllllllllllllIIIIllIIIIlIIIlIll < 0) {
            return false;
        }
        int llllllllllllllIIIIllIIIIlIIIlIlI = this.lex.lookAhead(llllllllllllllIIIIllIIIIlIIIlIll);
        if (llllllllllllllIIIIllIIIIlIIIlIlI != 41) {
            return false;
        }
        llllllllllllllIIIIllIIIIlIIIlIlI = this.lex.lookAhead(llllllllllllllIIIIllIIIIlIIIlIll + 1);
        return llllllllllllllIIIIllIIIIlIIIlIlI == 40 || llllllllllllllIIIIllIIIIlIIIlIlI == 412 || llllllllllllllIIIIllIIIIlIIIlIlI == 406 || llllllllllllllIIIIllIIIIlIIIlIlI == 400 || llllllllllllllIIIIllIIIIlIIIlIlI == 339 || llllllllllllllIIIIllIIIIlIIIlIlI == 336 || llllllllllllllIIIIllIIIIlIIIlIlI == 328 || llllllllllllllIIIIllIIIIlIIIlIlI == 410 || llllllllllllllIIIIllIIIIlIIIlIlI == 411 || llllllllllllllIIIIllIIIIlIIIlIlI == 403 || llllllllllllllIIIIllIIIIlIIIlIlI == 402 || llllllllllllllIIIIllIIIIlIIIlIlI == 401 || llllllllllllllIIIIllIIIIlIIIlIlI == 405 || llllllllllllllIIIIllIIIIlIIIlIlI == 404;
    }
    
    private boolean nextIsBuiltinCast() {
        int llllllllllllllIIIIllIIIIlIIlIIll = 2;
        int llllllllllllllIIIIllIIIIlIIlIlII;
        while ((llllllllllllllIIIIllIIIIlIIlIlII = this.lex.lookAhead(llllllllllllllIIIIllIIIIlIIlIIll++)) == 91) {
            if (this.lex.lookAhead(llllllllllllllIIIIllIIIIlIIlIIll++) != 93) {
                return false;
            }
        }
        return this.lex.lookAhead(llllllllllllllIIIIllIIIIlIIlIIll - 1) == 41;
    }
    
    private Stmnt parseStmntOrCase(final SymbolTable llllllllllllllIIIIllIIlIIllIllII) throws CompileError {
        final int llllllllllllllIIIIllIIlIIllIllll = this.lex.lookAhead();
        if (llllllllllllllIIIIllIIlIIllIllll != 304 && llllllllllllllIIIIllIIlIIllIllll != 310) {
            return this.parseStatement(llllllllllllllIIIIllIIlIIllIllII);
        }
        this.lex.get();
        Stmnt llllllllllllllIIIIllIIlIIllIlllI = null;
        if (llllllllllllllIIIIllIIlIIllIllll == 304) {
            final Stmnt llllllllllllllIIIIllIIlIIlllIIlI = new Stmnt(llllllllllllllIIIIllIIlIIllIllll, this.parseExpression(llllllllllllllIIIIllIIlIIllIllII));
        }
        else {
            llllllllllllllIIIIllIIlIIllIlllI = new Stmnt(310);
        }
        if (this.lex.get() != 58) {
            throw new CompileError(": is missing", this.lex);
        }
        return llllllllllllllIIIIllIIlIIllIlllI;
    }
    
    public Parser(final Lex llllllllllllllIIIIllIIlllIIIIIIl) {
        this.lex = llllllllllllllIIIIllIIlllIIIIIIl;
    }
    
    private int parseArrayDimension() throws CompileError {
        int llllllllllllllIIIIllIIIIIllllIlI = 0;
        while (this.lex.lookAhead() == 91) {
            ++llllllllllllllIIIIllIIIIIllllIlI;
            this.lex.get();
            if (this.lex.get() != 93) {
                throw new CompileError("] is missing", this.lex);
            }
        }
        return llllllllllllllIIIIllIIIIIllllIlI;
    }
    
    private static boolean isBuiltinType(final int llllllllllllllIIIIllIIllIIIlIIlI) {
        return llllllllllllllIIIIllIIllIIIlIIlI == 301 || llllllllllllllIIIIllIIllIIIlIIlI == 303 || llllllllllllllIIIIllIIllIIIlIIlI == 306 || llllllllllllllIIIIllIIllIIIlIIlI == 334 || llllllllllllllIIIIllIIllIIIlIIlI == 324 || llllllllllllllIIIIllIIllIIIlIIlI == 326 || llllllllllllllIIIIllIIllIIIlIIlI == 317 || llllllllllllllIIIIllIIllIIIlIIlI == 312;
    }
    
    private Stmnt parseSynchronized(final SymbolTable llllllllllllllIIIIllIIlIIlIllllI) throws CompileError {
        final int llllllllllllllIIIIllIIlIIllIIIlI = this.lex.get();
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        final ASTree llllllllllllllIIIIllIIlIIllIIIIl = this.parseExpression(llllllllllllllIIIIllIIlIIlIllllI);
        if (this.lex.get() != 41) {
            throw new SyntaxError(this.lex);
        }
        final Stmnt llllllllllllllIIIIllIIlIIllIIIII = this.parseBlock(llllllllllllllIIIIllIIlIIlIllllI);
        return new Stmnt(llllllllllllllIIIIllIIlIIllIIIlI, llllllllllllllIIIIllIIlIIllIIIIl, llllllllllllllIIIIllIIlIIllIIIII);
    }
    
    private ASTree parsePostfix(final SymbolTable llllllllllllllIIIIllIIIIIlIlllII) throws CompileError {
        final int llllllllllllllIIIIllIIIIIlIlllll = this.lex.lookAhead();
        switch (llllllllllllllIIIIllIIIIIlIlllll) {
            case 401:
            case 402:
            case 403: {
                this.lex.get();
                return new IntConst(this.lex.getLong(), llllllllllllllIIIIllIIIIIlIlllll);
            }
            case 404:
            case 405: {
                this.lex.get();
                return new DoubleConst(this.lex.getDouble(), llllllllllllllIIIIllIIIIIlIlllll);
            }
            default: {
                ASTree llllllllllllllIIIIllIIIIIlIllllI = this.parsePrimaryExpr(llllllllllllllIIIIllIIIIIlIlllII);
                while (true) {
                    switch (this.lex.lookAhead()) {
                        case 40: {
                            llllllllllllllIIIIllIIIIIlIllllI = this.parseMethodCall(llllllllllllllIIIIllIIIIIlIlllII, llllllllllllllIIIIllIIIIIlIllllI);
                            continue;
                        }
                        case 91: {
                            if (this.lex.lookAhead(1) == 93) {
                                final int llllllllllllllIIIIllIIIIIllIlIII = this.parseArrayDimension();
                                if (this.lex.get() != 46 || this.lex.get() != 307) {
                                    throw new SyntaxError(this.lex);
                                }
                                llllllllllllllIIIIllIIIIIlIllllI = this.parseDotClass(llllllllllllllIIIIllIIIIIlIllllI, llllllllllllllIIIIllIIIIIllIlIII);
                                continue;
                            }
                            else {
                                final ASTree llllllllllllllIIIIllIIIIIllIIlll = this.parseArrayIndex(llllllllllllllIIIIllIIIIIlIlllII);
                                if (llllllllllllllIIIIllIIIIIllIIlll == null) {
                                    throw new SyntaxError(this.lex);
                                }
                                llllllllllllllIIIIllIIIIIlIllllI = Expr.make(65, llllllllllllllIIIIllIIIIIlIllllI, llllllllllllllIIIIllIIIIIllIIlll);
                                continue;
                            }
                            break;
                        }
                        case 362:
                        case 363: {
                            final int llllllllllllllIIIIllIIIIIllIIllI = this.lex.get();
                            llllllllllllllIIIIllIIIIIlIllllI = Expr.make(llllllllllllllIIIIllIIIIIllIIllI, null, llllllllllllllIIIIllIIIIIlIllllI);
                            continue;
                        }
                        case 46: {
                            this.lex.get();
                            final int llllllllllllllIIIIllIIIIIllIIlII = this.lex.get();
                            if (llllllllllllllIIIIllIIIIIllIIlII == 307) {
                                llllllllllllllIIIIllIIIIIlIllllI = this.parseDotClass(llllllllllllllIIIIllIIIIIlIllllI, 0);
                                continue;
                            }
                            if (llllllllllllllIIIIllIIIIIllIIlII == 336) {
                                llllllllllllllIIIIllIIIIIlIllllI = Expr.make(46, new Symbol(this.toClassName(llllllllllllllIIIIllIIIIIlIllllI)), new Keyword(llllllllllllllIIIIllIIIIIllIIlII));
                                continue;
                            }
                            if (llllllllllllllIIIIllIIIIIllIIlII == 400) {
                                final String llllllllllllllIIIIllIIIIIllIIlIl = this.lex.getString();
                                llllllllllllllIIIIllIIIIIlIllllI = Expr.make(46, llllllllllllllIIIIllIIIIIlIllllI, new Member(llllllllllllllIIIIllIIIIIllIIlIl));
                                continue;
                            }
                            throw new CompileError("missing member name", this.lex);
                        }
                        case 35: {
                            this.lex.get();
                            final int llllllllllllllIIIIllIIIIIllIIIlI = this.lex.get();
                            if (llllllllllllllIIIIllIIIIIllIIIlI != 400) {
                                throw new CompileError("missing static member name", this.lex);
                            }
                            final String llllllllllllllIIIIllIIIIIllIIIll = this.lex.getString();
                            llllllllllllllIIIIllIIIIIlIllllI = Expr.make(35, new Symbol(this.toClassName(llllllllllllllIIIIllIIIIIlIllllI)), new Member(llllllllllllllIIIIllIIIIIllIIIll));
                            continue;
                        }
                        default: {
                            return llllllllllllllIIIIllIIIIIlIllllI;
                        }
                    }
                }
                break;
            }
        }
    }
    
    private Stmnt parseWhile(final SymbolTable llllllllllllllIIIIllIIlIllIIlIll) throws CompileError {
        final int llllllllllllllIIIIllIIlIllIIllll = this.lex.get();
        final ASTree llllllllllllllIIIIllIIlIllIIlllI = this.parseParExpression(llllllllllllllIIIIllIIlIllIIlIll);
        final Stmnt llllllllllllllIIIIllIIlIllIIllIl = this.parseStatement(llllllllllllllIIIIllIIlIllIIlIll);
        return new Stmnt(llllllllllllllIIIIllIIlIllIIllll, llllllllllllllIIIIllIIlIllIIlllI, llllllllllllllIIIIllIIlIllIIllIl);
    }
    
    public Stmnt parseStatement(final SymbolTable llllllllllllllIIIIllIIlIlllllllI) throws CompileError {
        final int llllllllllllllIIIIllIIlIllllllIl = this.lex.lookAhead();
        if (llllllllllllllIIIIllIIlIllllllIl == 123) {
            return this.parseBlock(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 59) {
            this.lex.get();
            return new Stmnt(66);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 400 && this.lex.lookAhead(1) == 58) {
            this.lex.get();
            final String llllllllllllllIIIIllIIllIIIIIIII = this.lex.getString();
            this.lex.get();
            return Stmnt.make(76, new Symbol(llllllllllllllIIIIllIIllIIIIIIII), this.parseStatement(llllllllllllllIIIIllIIlIlllllllI));
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 320) {
            return this.parseIf(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 346) {
            return this.parseWhile(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 311) {
            return this.parseDo(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 318) {
            return this.parseFor(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 343) {
            return this.parseTry(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 337) {
            return this.parseSwitch(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 338) {
            return this.parseSynchronized(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 333) {
            return this.parseReturn(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 340) {
            return this.parseThrow(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 302) {
            return this.parseBreak(llllllllllllllIIIIllIIlIlllllllI);
        }
        if (llllllllllllllIIIIllIIlIllllllIl == 309) {
            return this.parseContinue(llllllllllllllIIIIllIIlIlllllllI);
        }
        return this.parseDeclarationOrExpression(llllllllllllllIIIIllIIlIlllllllI, false);
    }
    
    private Stmnt parseDo(final SymbolTable llllllllllllllIIIIllIIlIlIllllII) throws CompileError {
        final int llllllllllllllIIIIllIIlIllIIIIII = this.lex.get();
        final Stmnt llllllllllllllIIIIllIIlIlIllllll = this.parseStatement(llllllllllllllIIIIllIIlIlIllllII);
        if (this.lex.get() != 346 || this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        final ASTree llllllllllllllIIIIllIIlIlIlllllI = this.parseExpression(llllllllllllllIIIIllIIlIlIllllII);
        if (this.lex.get() != 41 || this.lex.get() != 59) {
            throw new SyntaxError(this.lex);
        }
        return new Stmnt(llllllllllllllIIIIllIIlIllIIIIII, llllllllllllllIIIIllIIlIlIlllllI, llllllllllllllIIIIllIIlIlIllllll);
    }
    
    private ASTree parseDotClass(final ASTree llllllllllllllIIIIllIIIIIlIIlllI, int llllllllllllllIIIIllIIIIIlIIllIl) throws CompileError {
        String llllllllllllllIIIIllIIIIIlIIllII = this.toClassName(llllllllllllllIIIIllIIIIIlIIlllI);
        if (llllllllllllllIIIIllIIIIIlIIllIl > 0) {
            final StringBuffer llllllllllllllIIIIllIIIIIlIlIIII = new StringBuffer();
            while (llllllllllllllIIIIllIIIIIlIIllIl-- > 0) {
                llllllllllllllIIIIllIIIIIlIlIIII.append('[');
            }
            llllllllllllllIIIIllIIIIIlIlIIII.append('L').append(llllllllllllllIIIIllIIIIIlIIllII.replace('.', '/')).append(';');
            llllllllllllllIIIIllIIIIIlIIllII = llllllllllllllIIIIllIIIIIlIlIIII.toString();
        }
        return Expr.make(46, new Symbol(llllllllllllllIIIIllIIIIIlIIllII), new Member("class"));
    }
    
    private Stmnt parseDeclarators(final SymbolTable llllllllllllllIIIIllIIIlllIllIll, final Declarator llllllllllllllIIIIllIIIllllIIIII) throws CompileError {
        Stmnt llllllllllllllIIIIllIIIlllIlllll = null;
        while (true) {
            llllllllllllllIIIIllIIIlllIlllll = (Stmnt)ASTList.concat(llllllllllllllIIIIllIIIlllIlllll, new Stmnt(68, this.parseDeclarator(llllllllllllllIIIIllIIIlllIllIll, llllllllllllllIIIIllIIIllllIIIII)));
            final int llllllllllllllIIIIllIIIllllIIlII = this.lex.get();
            if (llllllllllllllIIIIllIIIllllIIlII == 59) {
                return llllllllllllllIIIIllIIIlllIlllll;
            }
            if (llllllllllllllIIIIllIIIllllIIlII != 44) {
                throw new CompileError("; is missing", this.lex);
            }
        }
    }
    
    private Stmnt parseTry(final SymbolTable llllllllllllllIIIIllIIlIIlIIllll) throws CompileError {
        this.lex.get();
        final Stmnt llllllllllllllIIIIllIIlIIlIIlllI = this.parseBlock(llllllllllllllIIIIllIIlIIlIIllll);
        ASTList llllllllllllllIIIIllIIlIIlIIllIl = null;
        while (this.lex.lookAhead() == 305) {
            this.lex.get();
            if (this.lex.get() != 40) {
                throw new SyntaxError(this.lex);
            }
            final SymbolTable llllllllllllllIIIIllIIlIIlIlIIll = new SymbolTable(llllllllllllllIIIIllIIlIIlIIllll);
            final Declarator llllllllllllllIIIIllIIlIIlIlIIlI = this.parseFormalParam(llllllllllllllIIIIllIIlIIlIlIIll);
            if (llllllllllllllIIIIllIIlIIlIlIIlI.getArrayDim() > 0 || llllllllllllllIIIIllIIlIIlIlIIlI.getType() != 307) {
                throw new SyntaxError(this.lex);
            }
            if (this.lex.get() != 41) {
                throw new SyntaxError(this.lex);
            }
            final Stmnt llllllllllllllIIIIllIIlIIlIlIIIl = this.parseBlock(llllllllllllllIIIIllIIlIIlIlIIll);
            llllllllllllllIIIIllIIlIIlIIllIl = ASTList.append(llllllllllllllIIIIllIIlIIlIIllIl, new Pair(llllllllllllllIIIIllIIlIIlIlIIlI, llllllllllllllIIIIllIIlIIlIlIIIl));
        }
        Stmnt llllllllllllllIIIIllIIlIIlIIllII = null;
        if (this.lex.lookAhead() == 316) {
            this.lex.get();
            llllllllllllllIIIIllIIlIIlIIllII = this.parseBlock(llllllllllllllIIIIllIIlIIlIIllll);
        }
        return Stmnt.make(343, llllllllllllllIIIIllIIlIIlIIlllI, llllllllllllllIIIIllIIlIIlIIllIl, llllllllllllllIIIIllIIlIIlIIllII);
    }
    
    private Stmnt parseExprList(final SymbolTable llllllllllllllIIIIllIIIllllllIII) throws CompileError {
        Stmnt llllllllllllllIIIIllIIIlllllIlll = null;
        while (true) {
            final Stmnt llllllllllllllIIIIllIIIllllllIlI = new Stmnt(69, this.parseExpression(llllllllllllllIIIIllIIIllllllIII));
            llllllllllllllIIIIllIIIlllllIlll = (Stmnt)ASTList.concat(llllllllllllllIIIIllIIIlllllIlll, new Stmnt(66, llllllllllllllIIIIllIIIllllllIlI));
            if (this.lex.lookAhead() != 44) {
                break;
            }
            this.lex.get();
        }
        return llllllllllllllIIIIllIIIlllllIlll;
    }
    
    private ASTree parseParExpression(final SymbolTable llllllllllllllIIIIllIIIllIIIIIIl) throws CompileError {
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        final ASTree llllllllllllllIIIIllIIIllIIIIIII = this.parseExpression(llllllllllllllIIIIllIIIllIIIIIIl);
        if (this.lex.get() != 41) {
            throw new SyntaxError(this.lex);
        }
        return llllllllllllllIIIIllIIIllIIIIIII;
    }
    
    private String toClassName(final ASTree llllllllllllllIIIIllIIIIIIlIIIIl) throws CompileError {
        final StringBuffer llllllllllllllIIIIllIIIIIIlIIIII = new StringBuffer();
        this.toClassName(llllllllllllllIIIIllIIIIIIlIIIIl, llllllllllllllIIIIllIIIIIIlIIIII);
        return llllllllllllllIIIIllIIIIIIlIIIII.toString();
    }
    
    private ASTree parseArrayIndex(final SymbolTable llllllllllllllIIIIlIllllllIllIlI) throws CompileError {
        this.lex.get();
        if (this.lex.lookAhead() == 93) {
            this.lex.get();
            return null;
        }
        final ASTree llllllllllllllIIIIlIllllllIllIIl = this.parseExpression(llllllllllllllIIIIlIllllllIllIlI);
        if (this.lex.get() != 93) {
            throw new CompileError("] is missing", this.lex);
        }
        return llllllllllllllIIIIlIllllllIllIIl;
    }
    
    private static boolean isAssignOp(final int llllllllllllllIIIIllIIIlIlIlIlIl) {
        return llllllllllllllIIIIllIIIlIlIlIlIl == 61 || llllllllllllllIIIIllIIIlIlIlIlIl == 351 || llllllllllllllIIIIllIIIlIlIlIlIl == 352 || llllllllllllllIIIIllIIIlIlIlIlIl == 353 || llllllllllllllIIIIllIIIlIlIlIlIl == 354 || llllllllllllllIIIIllIIIlIlIlIlIl == 355 || llllllllllllllIIIIllIIIlIlIlIlIl == 356 || llllllllllllllIIIIllIIIlIlIlIlIl == 360 || llllllllllllllIIIIllIIIlIlIlIlIl == 361 || llllllllllllllIIIIllIIIlIlIlIlIl == 365 || llllllllllllllIIIIllIIIlIlIlIlIl == 367 || llllllllllllllIIIIllIIIlIlIlIlIl == 371;
    }
    
    private Declarator parseFormalType(final SymbolTable llllllllllllllIIIIllIIllIIIlIlll) throws CompileError {
        final int llllllllllllllIIIIllIIllIIIllIll = this.lex.lookAhead();
        if (isBuiltinType(llllllllllllllIIIIllIIllIIIllIll) || llllllllllllllIIIIllIIllIIIllIll == 344) {
            this.lex.get();
            final int llllllllllllllIIIIllIIllIIIllllI = this.parseArrayDimension();
            return new Declarator(llllllllllllllIIIIllIIllIIIllIll, llllllllllllllIIIIllIIllIIIllllI);
        }
        final ASTList llllllllllllllIIIIllIIllIIIllIlI = this.parseClassType(llllllllllllllIIIIllIIllIIIlIlll);
        final int llllllllllllllIIIIllIIllIIIllIIl = this.parseArrayDimension();
        return new Declarator(llllllllllllllIIIIllIIllIIIllIlI, llllllllllllllIIIIllIIllIIIllIIl);
    }
}
