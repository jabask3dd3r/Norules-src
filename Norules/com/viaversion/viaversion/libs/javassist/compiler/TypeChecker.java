package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class TypeChecker extends Visitor implements TokenId, Opcode
{
    protected /* synthetic */ int arrayDim;
    protected /* synthetic */ int exprType;
    protected /* synthetic */ CtClass thisClass;
    protected /* synthetic */ MethodInfo thisMethod;
    protected /* synthetic */ MemberResolver resolver;
    protected /* synthetic */ String className;
    
    @Override
    public void atIntConst(final IntConst llllllllllllllIIlIllllIIIIIIIIII) throws CompileError {
        this.arrayDim = 0;
        final int llllllllllllllIIlIllllIIIIIIIIlI = llllllllllllllIIlIllllIIIIIIIIII.getType();
        if (llllllllllllllIIlIllllIIIIIIIIlI == 402 || llllllllllllllIIlIllllIIIIIIIIlI == 401) {
            this.exprType = ((llllllllllllllIIlIllllIIIIIIIIlI == 402) ? 324 : 306);
        }
        else {
            this.exprType = 326;
        }
    }
    
    private void atArrayAssign(final Expr llllllllllllllIIlIlllllIlIIlllII, final int llllllllllllllIIlIlllllIlIIllIll, final Expr llllllllllllllIIlIlllllIlIIllIlI, final ASTree llllllllllllllIIlIlllllIlIIlIIll) throws CompileError {
        this.atArrayRead(llllllllllllllIIlIlllllIlIIllIlI.oprand1(), llllllllllllllIIlIlllllIlIIllIlI.oprand2());
        final int llllllllllllllIIlIlllllIlIIllIII = this.exprType;
        final int llllllllllllllIIlIlllllIlIIlIlll = this.arrayDim;
        final String llllllllllllllIIlIlllllIlIIlIllI = this.className;
        llllllllllllllIIlIlllllIlIIlIIll.accept(this);
        this.exprType = llllllllllllllIIlIlllllIlIIllIII;
        this.arrayDim = llllllllllllllIIlIlllllIlIIlIlll;
        this.className = llllllllllllllIIlIlllllIlIIlIllI;
    }
    
    @Override
    public void atAssignExpr(final AssignExpr llllllllllllllIIlIlllllIllIIIIIl) throws CompileError {
        final int llllllllllllllIIlIlllllIllIIIlIl = llllllllllllllIIlIlllllIllIIIIIl.getOperator();
        final ASTree llllllllllllllIIlIlllllIllIIIlII = llllllllllllllIIlIlllllIllIIIIIl.oprand1();
        final ASTree llllllllllllllIIlIlllllIllIIIIll = llllllllllllllIIlIlllllIllIIIIIl.oprand2();
        if (llllllllllllllIIlIlllllIllIIIlII instanceof Variable) {
            this.atVariableAssign(llllllllllllllIIlIlllllIllIIIIIl, llllllllllllllIIlIlllllIllIIIlIl, (Variable)llllllllllllllIIlIlllllIllIIIlII, ((Variable)llllllllllllllIIlIlllllIllIIIlII).getDeclarator(), llllllllllllllIIlIlllllIllIIIIll);
        }
        else {
            if (llllllllllllllIIlIlllllIllIIIlII instanceof Expr) {
                final Expr llllllllllllllIIlIlllllIllIIlIII = (Expr)llllllllllllllIIlIlllllIllIIIlII;
                if (llllllllllllllIIlIlllllIllIIlIII.getOperator() == 65) {
                    this.atArrayAssign(llllllllllllllIIlIlllllIllIIIIIl, llllllllllllllIIlIlllllIllIIIlIl, (Expr)llllllllllllllIIlIlllllIllIIIlII, llllllllllllllIIlIlllllIllIIIIll);
                    return;
                }
            }
            this.atFieldAssign(llllllllllllllIIlIlllllIllIIIIIl, llllllllllllllIIlIlllllIllIIIlIl, llllllllllllllIIlIlllllIllIIIlII, llllllllllllllIIlIlllllIllIIIIll);
        }
    }
    
    private void atVariableAssign(final Expr llllllllllllllIIlIlllllIlIllIIll, final int llllllllllllllIIlIlllllIlIllIIlI, final Variable llllllllllllllIIlIlllllIlIllIIIl, final Declarator llllllllllllllIIlIlllllIlIllIIII, final ASTree llllllllllllllIIlIlllllIlIlIIlll) throws CompileError {
        final int llllllllllllllIIlIlllllIlIlIlllI = llllllllllllllIIlIlllllIlIllIIII.getType();
        final int llllllllllllllIIlIlllllIlIlIllIl = llllllllllllllIIlIlllllIlIllIIII.getArrayDim();
        final String llllllllllllllIIlIlllllIlIlIllII = llllllllllllllIIlIlllllIlIllIIII.getClassName();
        if (llllllllllllllIIlIlllllIlIllIIlI != 61) {
            this.atVariable(llllllllllllllIIlIlllllIlIllIIIl);
        }
        llllllllllllllIIlIlllllIlIlIIlll.accept(this);
        this.exprType = llllllllllllllIIlIlllllIlIlIlllI;
        this.arrayDim = llllllllllllllIIlIlllllIlIlIllIl;
        this.className = llllllllllllllIIlIlllllIlIlIllII;
    }
    
    public void atArrayRead(final ASTree llllllllllllllIIlIllllIIIlIIlllI, final ASTree llllllllllllllIIlIllllIIIlIIllIl) throws CompileError {
        llllllllllllllIIlIllllIIIlIIlllI.accept(this);
        final int llllllllllllllIIlIllllIIIlIIllII = this.exprType;
        final int llllllllllllllIIlIllllIIIlIIlIll = this.arrayDim;
        final String llllllllllllllIIlIllllIIIlIIlIlI = this.className;
        llllllllllllllIIlIllllIIIlIIllIl.accept(this);
        this.exprType = llllllllllllllIIlIllllIIIlIIllII;
        this.arrayDim = llllllllllllllIIlIllllIIIlIIlIll - 1;
        this.className = llllllllllllllIIlIllllIIIlIIlIlI;
    }
    
    private boolean isConstant(final Expr llllllllllllllIIlIllllIllIlIIIlI, final int llllllllllllllIIlIllllIllIlIIIIl, ASTree llllllllllllllIIlIllllIllIIlllIl) {
        llllllllllllllIIlIllllIllIIlllIl = stripPlusExpr(llllllllllllllIIlIllllIllIIlllIl);
        if (llllllllllllllIIlIllllIllIIlllIl instanceof IntConst) {
            final IntConst llllllllllllllIIlIllllIllIlIIllI = (IntConst)llllllllllllllIIlIllllIllIIlllIl;
            long llllllllllllllIIlIllllIllIlIIlIl = llllllllllllllIIlIllllIllIlIIllI.get();
            if (llllllllllllllIIlIllllIllIlIIIIl == 45) {
                llllllllllllllIIlIllllIllIlIIlIl = -llllllllllllllIIlIllllIllIlIIlIl;
            }
            else {
                if (llllllllllllllIIlIllllIllIlIIIIl != 126) {
                    return false;
                }
                llllllllllllllIIlIllllIllIlIIlIl ^= -1L;
            }
            llllllllllllllIIlIllllIllIlIIllI.set(llllllllllllllIIlIllllIllIlIIlIl);
        }
        else {
            if (!(llllllllllllllIIlIllllIllIIlllIl instanceof DoubleConst)) {
                return false;
            }
            final DoubleConst llllllllllllllIIlIllllIllIlIIlII = (DoubleConst)llllllllllllllIIlIllllIllIIlllIl;
            if (llllllllllllllIIlIllllIllIlIIIIl != 45) {
                return false;
            }
            llllllllllllllIIlIllllIllIlIIlII.set(-llllllllllllllIIlIllllIllIlIIlII.get());
        }
        llllllllllllllIIlIllllIllIlIIIlI.setOperator(43);
        return true;
    }
    
    private void atFieldRead(final ASTree llllllllllllllIIlIllllIIlIlIIIII) throws CompileError {
        this.atFieldRead(this.fieldAccess(llllllllllllllIIlIllllIIlIlIIIII));
    }
    
    public TypeChecker(final CtClass llllllllllllllIIlIllllllIlIlIlII, final ClassPool llllllllllllllIIlIllllllIlIlIIll) {
        this.resolver = new MemberResolver(llllllllllllllIIlIllllllIlIlIIll);
        this.thisClass = llllllllllllllIIlIllllllIlIlIlII;
        this.thisMethod = null;
    }
    
    protected static String argTypesToString(final int[] llllllllllllllIIlIllllllIlIIlIll, final int[] llllllllllllllIIlIllllllIlIIIlIl, final String[] llllllllllllllIIlIllllllIlIIIlII) {
        final StringBuffer llllllllllllllIIlIllllllIlIIlIII = new StringBuffer();
        llllllllllllllIIlIllllllIlIIlIII.append('(');
        final int llllllllllllllIIlIllllllIlIIIlll = llllllllllllllIIlIllllllIlIIlIll.length;
        if (llllllllllllllIIlIllllllIlIIIlll > 0) {
            int llllllllllllllIIlIllllllIlIIllII = 0;
            while (true) {
                typeToString(llllllllllllllIIlIllllllIlIIlIII, llllllllllllllIIlIllllllIlIIlIll[llllllllllllllIIlIllllllIlIIllII], llllllllllllllIIlIllllllIlIIIlIl[llllllllllllllIIlIllllllIlIIllII], llllllllllllllIIlIllllllIlIIIlII[llllllllllllllIIlIllllllIlIIllII]);
                if (++llllllllllllllIIlIllllllIlIIllII >= llllllllllllllIIlIllllllIlIIIlll) {
                    break;
                }
                llllllllllllllIIlIllllllIlIIlIII.append(',');
            }
        }
        llllllllllllllIIlIllllllIlIIlIII.append(')');
        return llllllllllllllIIlIllllllIlIIlIII.toString();
    }
    
    @Override
    public void atNewExpr(final NewExpr llllllllllllllIIlIllllllIIIIlIII) throws CompileError {
        if (llllllllllllllIIlIllllllIIIIlIII.isArray()) {
            this.atNewArrayExpr(llllllllllllllIIlIllllllIIIIlIII);
        }
        else {
            final CtClass llllllllllllllIIlIllllllIIIIlllI = this.resolver.lookupClassByName(llllllllllllllIIlIllllllIIIIlIII.getClassName());
            final String llllllllllllllIIlIllllllIIIIllIl = llllllllllllllIIlIllllllIIIIlllI.getName();
            final ASTList llllllllllllllIIlIllllllIIIIllII = llllllllllllllIIlIllllllIIIIlIII.getArguments();
            this.atMethodCallCore(llllllllllllllIIlIllllllIIIIlllI, "<init>", llllllllllllllIIlIllllllIIIIllII);
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = MemberResolver.javaToJvmName(llllllllllllllIIlIllllllIIIIllIl);
        }
    }
    
    public void atNewArrayExpr(final NewExpr llllllllllllllIIlIlllllIllllIlIl) throws CompileError {
        final int llllllllllllllIIlIlllllIlllllIlI = llllllllllllllIIlIlllllIllllIlIl.getArrayType();
        final ASTList llllllllllllllIIlIlllllIlllllIIl = llllllllllllllIIlIlllllIllllIlIl.getArraySize();
        final ASTList llllllllllllllIIlIlllllIlllllIII = llllllllllllllIIlIlllllIllllIlIl.getClassName();
        final ASTree llllllllllllllIIlIlllllIllllIlll = llllllllllllllIIlIlllllIllllIlIl.getInitializer();
        if (llllllllllllllIIlIlllllIllllIlll != null) {
            llllllllllllllIIlIlllllIllllIlll.accept(this);
        }
        if (llllllllllllllIIlIlllllIlllllIIl.length() > 1) {
            this.atMultiNewArray(llllllllllllllIIlIlllllIlllllIlI, llllllllllllllIIlIlllllIlllllIII, llllllllllllllIIlIlllllIlllllIIl);
        }
        else {
            final ASTree llllllllllllllIIlIlllllIllllllIl = llllllllllllllIIlIlllllIlllllIIl.head();
            if (llllllllllllllIIlIlllllIllllllIl != null) {
                llllllllllllllIIlIlllllIllllllIl.accept(this);
            }
            this.exprType = llllllllllllllIIlIlllllIlllllIlI;
            this.arrayDim = 1;
            if (llllllllllllllIIlIlllllIlllllIlI == 307) {
                this.className = this.resolveClassName(llllllllllllllIIlIlllllIlllllIII);
            }
            else {
                this.className = null;
            }
        }
    }
    
    static String isDotSuper(final ASTree llllllllllllllIIlIllllIlIlllIIlI) {
        if (llllllllllllllIIlIllllIlIlllIIlI instanceof Expr) {
            final Expr llllllllllllllIIlIllllIlIlllIlII = (Expr)llllllllllllllIIlIllllIlIlllIIlI;
            if (llllllllllllllIIlIllllIlIlllIlII.getOperator() == 46) {
                final ASTree llllllllllllllIIlIllllIlIlllIlIl = llllllllllllllIIlIllllIlIlllIlII.oprand2();
                if (llllllllllllllIIlIllllIlIlllIlIl instanceof Keyword && ((Keyword)llllllllllllllIIlIllllIlIlllIlIl).get() == 336) {
                    return ((Symbol)llllllllllllllIIlIllllIlIlllIlII.oprand1()).get();
                }
            }
        }
        return null;
    }
    
    @Override
    public void atMember(final Member llllllllllllllIIlIllllIIIIIllllI) throws CompileError {
        this.atFieldRead(llllllllllllllIIlIllllIIIIIllllI);
    }
    
    public void setThisMethod(final MethodInfo llllllllllllllIIlIllllllIIlIIllI) {
        this.thisMethod = llllllllllllllIIlIllllllIIlIIllI;
    }
    
    @Override
    public void atArrayInit(final ArrayInit llllllllllllllIIlIlllllIlllIIllI) throws CompileError {
        ASTList llllllllllllllIIlIlllllIlllIlIII = llllllllllllllIIlIlllllIlllIIllI;
        while (llllllllllllllIIlIlllllIlllIlIII != null) {
            final ASTree llllllllllllllIIlIlllllIlllIlIll = llllllllllllllIIlIlllllIlllIlIII.head();
            llllllllllllllIIlIlllllIlllIlIII = llllllllllllllIIlIlllllIlllIlIII.tail();
            if (llllllllllllllIIlIlllllIlllIlIll != null) {
                llllllllllllllIIlIlllllIlllIlIll.accept(this);
            }
        }
    }
    
    protected CtField fieldAccess(final ASTree llllllllllllllIIlIllllIIIlllIIll) throws CompileError {
        if (llllllllllllllIIlIllllIIIlllIIll instanceof Member) {
            final Member llllllllllllllIIlIllllIIlIIIIIII = (Member)llllllllllllllIIlIllllIIIlllIIll;
            final String llllllllllllllIIlIllllIIIlllllll = llllllllllllllIIlIllllIIlIIIIIII.get();
            try {
                final CtField llllllllllllllIIlIllllIIlIIIIIlI = this.thisClass.getField(llllllllllllllIIlIllllIIIlllllll);
                if (Modifier.isStatic(llllllllllllllIIlIllllIIlIIIIIlI.getModifiers())) {
                    llllllllllllllIIlIllllIIlIIIIIII.setField(llllllllllllllIIlIllllIIlIIIIIlI);
                }
                return llllllllllllllIIlIllllIIlIIIIIlI;
            }
            catch (NotFoundException llllllllllllllIIlIllllIIlIIIIIIl) {
                throw new NoFieldException(llllllllllllllIIlIllllIIIlllllll, llllllllllllllIIlIllllIIIlllIIll);
            }
        }
        if (llllllllllllllIIlIllllIIIlllIIll instanceof Expr) {
            final Expr llllllllllllllIIlIllllIIIllllIII = (Expr)llllllllllllllIIlIllllIIIlllIIll;
            final int llllllllllllllIIlIllllIIIlllIlll = llllllllllllllIIlIllllIIIllllIII.getOperator();
            if (llllllllllllllIIlIllllIIIlllIlll == 35) {
                final Member llllllllllllllIIlIllllIIIllllllI = (Member)llllllllllllllIIlIllllIIIllllIII.oprand2();
                final CtField llllllllllllllIIlIllllIIIlllllIl = this.resolver.lookupField(((Symbol)llllllllllllllIIlIllllIIIllllIII.oprand1()).get(), llllllllllllllIIlIllllIIIllllllI);
                llllllllllllllIIlIllllIIIllllllI.setField(llllllllllllllIIlIllllIIIlllllIl);
                return llllllllllllllIIlIllllIIIlllllIl;
            }
            if (llllllllllllllIIlIllllIIIlllIlll == 46) {
                try {
                    llllllllllllllIIlIllllIIIllllIII.oprand1().accept(this);
                }
                catch (NoFieldException llllllllllllllIIlIllllIIIlllllII) {
                    if (llllllllllllllIIlIllllIIIlllllII.getExpr() != llllllllllllllIIlIllllIIIllllIII.oprand1()) {
                        throw llllllllllllllIIlIllllIIIlllllII;
                    }
                    return this.fieldAccess2(llllllllllllllIIlIllllIIIllllIII, llllllllllllllIIlIllllIIIlllllII.getField());
                }
                CompileError llllllllllllllIIlIllllIIIllllIlI = null;
                try {
                    if (this.exprType == 307 && this.arrayDim == 0) {
                        return this.resolver.lookupFieldByJvmName(this.className, (Symbol)llllllllllllllIIlIllllIIIllllIII.oprand2());
                    }
                }
                catch (CompileError llllllllllllllIIlIllllIIIllllIll) {
                    llllllllllllllIIlIllllIIIllllIlI = llllllllllllllIIlIllllIIIllllIll;
                }
                final ASTree llllllllllllllIIlIllllIIIllllIIl = llllllllllllllIIlIllllIIIllllIII.oprand1();
                if (llllllllllllllIIlIllllIIIllllIIl instanceof Symbol) {
                    return this.fieldAccess2(llllllllllllllIIlIllllIIIllllIII, ((Symbol)llllllllllllllIIlIllllIIIllllIIl).get());
                }
                if (llllllllllllllIIlIllllIIIllllIlI != null) {
                    throw llllllllllllllIIlIllllIIIllllIlI;
                }
            }
        }
        throw new CompileError("bad field access");
    }
    
    @Override
    public void atVariable(final Variable llllllllllllllIIlIllllIIIIIllIIl) throws CompileError {
        final Declarator llllllllllllllIIlIllllIIIIIllIII = llllllllllllllIIlIllllIIIIIllIIl.getDeclarator();
        this.exprType = llllllllllllllIIlIllllIIIIIllIII.getType();
        this.arrayDim = llllllllllllllIIlIllllIIIIIllIII.getArrayDim();
        this.className = llllllllllllllIIlIllllIIIIIllIII.getClassName();
    }
    
    void setReturnType(final String llllllllllllllIIlIllllIIlIlIlIII) throws CompileError {
        int llllllllllllllIIlIllllIIlIlIllII = llllllllllllllIIlIllllIIlIlIlIII.indexOf(41);
        if (llllllllllllllIIlIllllIIlIlIllII < 0) {
            badMethod();
        }
        char llllllllllllllIIlIllllIIlIlIlIll = llllllllllllllIIlIllllIIlIlIlIII.charAt(++llllllllllllllIIlIllllIIlIlIllII);
        int llllllllllllllIIlIllllIIlIlIlIlI = 0;
        while (llllllllllllllIIlIllllIIlIlIlIll == '[') {
            ++llllllllllllllIIlIllllIIlIlIlIlI;
            llllllllllllllIIlIllllIIlIlIlIll = llllllllllllllIIlIllllIIlIlIlIII.charAt(++llllllllllllllIIlIllllIIlIlIllII);
        }
        this.arrayDim = llllllllllllllIIlIllllIIlIlIlIlI;
        if (llllllllllllllIIlIllllIIlIlIlIll == 'L') {
            final int llllllllllllllIIlIllllIIlIllIIII = llllllllllllllIIlIllllIIlIlIlIII.indexOf(59, llllllllllllllIIlIllllIIlIlIllII + 1);
            if (llllllllllllllIIlIllllIIlIllIIII < 0) {
                badMethod();
            }
            this.exprType = 307;
            this.className = llllllllllllllIIlIllllIIlIlIlIII.substring(llllllllllllllIIlIllllIIlIlIllII + 1, llllllllllllllIIlIllllIIlIllIIII);
        }
        else {
            this.exprType = MemberResolver.descToType(llllllllllllllIIlIllllIIlIlIlIll);
            this.className = null;
        }
    }
    
    private Expr atPlusExpr(final BinExpr llllllllllllllIIlIlllllIIlIIIllI) throws CompileError {
        final ASTree llllllllllllllIIlIlllllIIlIIIlIl = llllllllllllllIIlIlllllIIlIIIllI.oprand1();
        final ASTree llllllllllllllIIlIlllllIIlIIIlII = llllllllllllllIIlIlllllIIlIIIllI.oprand2();
        if (llllllllllllllIIlIlllllIIlIIIlII == null) {
            llllllllllllllIIlIlllllIIlIIIlIl.accept(this);
            return null;
        }
        if (isPlusExpr(llllllllllllllIIlIlllllIIlIIIlIl)) {
            final Expr llllllllllllllIIlIlllllIIlIIlIlI = this.atPlusExpr((BinExpr)llllllllllllllIIlIlllllIIlIIIlIl);
            if (llllllllllllllIIlIlllllIIlIIlIlI != null) {
                llllllllllllllIIlIlllllIIlIIIlII.accept(this);
                this.exprType = 307;
                this.arrayDim = 0;
                this.className = "java/lang/StringBuffer";
                return makeAppendCall(llllllllllllllIIlIlllllIIlIIlIlI, llllllllllllllIIlIlllllIIlIIIlII);
            }
        }
        else {
            llllllllllllllIIlIlllllIIlIIIlIl.accept(this);
        }
        final int llllllllllllllIIlIlllllIIlIIIIll = this.exprType;
        final int llllllllllllllIIlIlllllIIlIIIIlI = this.arrayDim;
        final String llllllllllllllIIlIlllllIIlIIIIIl = this.className;
        llllllllllllllIIlIlllllIIlIIIlII.accept(this);
        if (this.isConstant(llllllllllllllIIlIlllllIIlIIIllI, 43, llllllllllllllIIlIlllllIIlIIIlIl, llllllllllllllIIlIlllllIIlIIIlII)) {
            return null;
        }
        if ((llllllllllllllIIlIlllllIIlIIIIll == 307 && llllllllllllllIIlIlllllIIlIIIIlI == 0 && "java/lang/String".equals(llllllllllllllIIlIlllllIIlIIIIIl)) || (this.exprType == 307 && this.arrayDim == 0 && "java/lang/String".equals(this.className))) {
            final ASTList llllllllllllllIIlIlllllIIlIIlIIl = ASTList.make(new Symbol("java"), new Symbol("lang"), new Symbol("StringBuffer"));
            final ASTree llllllllllllllIIlIlllllIIlIIlIII = new NewExpr(llllllllllllllIIlIlllllIIlIIlIIl, null);
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/StringBuffer";
            return makeAppendCall(makeAppendCall(llllllllllllllIIlIlllllIIlIIlIII, llllllllllllllIIlIlllllIIlIIIlIl), llllllllllllllIIlIlllllIIlIIIlII);
        }
        this.computeBinExprType(llllllllllllllIIlIlllllIIlIIIllI, 43, llllllllllllllIIlIlllllIIlIIIIll);
        return null;
    }
    
    protected void atMultiNewArray(final int llllllllllllllIIlIlllllIllIllIlI, final ASTList llllllllllllllIIlIlllllIllIlIIll, ASTList llllllllllllllIIlIlllllIllIlIIlI) throws CompileError {
        final int llllllllllllllIIlIlllllIllIlIllI = ((ASTList)llllllllllllllIIlIlllllIllIlIIlI).length();
        int llllllllllllllIIlIlllllIllIlIlll = 0;
        while (llllllllllllllIIlIlllllIllIlIIlI != null) {
            final ASTree llllllllllllllIIlIlllllIllIlllII = ((ASTList)llllllllllllllIIlIlllllIllIlIIlI).head();
            if (llllllllllllllIIlIlllllIllIlllII == null) {
                break;
            }
            ++llllllllllllllIIlIlllllIllIlIlll;
            llllllllllllllIIlIlllllIllIlllII.accept(this);
            llllllllllllllIIlIlllllIllIlIIlI = ((ASTList)llllllllllllllIIlIlllllIllIlIIlI).tail();
        }
        this.exprType = llllllllllllllIIlIlllllIllIllIlI;
        this.arrayDim = llllllllllllllIIlIlllllIllIlIllI;
        if (llllllllllllllIIlIlllllIllIllIlI == 307) {
            this.className = this.resolveClassName(llllllllllllllIIlIlllllIllIlIIll);
        }
        else {
            this.className = null;
        }
    }
    
    static ASTree stripPlusExpr(final ASTree llllllllllllllIIlIlllllIIIIllIll) {
        if (llllllllllllllIIlIlllllIIIIllIll instanceof BinExpr) {
            final BinExpr llllllllllllllIIlIlllllIIIlIIIIl = (BinExpr)llllllllllllllIIlIlllllIIIIllIll;
            if (llllllllllllllIIlIlllllIIIlIIIIl.getOperator() == 43 && llllllllllllllIIlIlllllIIIlIIIIl.oprand2() == null) {
                return llllllllllllllIIlIlllllIIIlIIIIl.getLeft();
            }
        }
        else if (llllllllllllllIIlIlllllIIIIllIll instanceof Expr) {
            final Expr llllllllllllllIIlIlllllIIIIlllll = (Expr)llllllllllllllIIlIlllllIIIIllIll;
            final int llllllllllllllIIlIlllllIIIIllllI = llllllllllllllIIlIlllllIIIIlllll.getOperator();
            if (llllllllllllllIIlIlllllIIIIllllI == 35) {
                final ASTree llllllllllllllIIlIlllllIIIlIIIII = getConstantFieldValue((Member)llllllllllllllIIlIlllllIIIIlllll.oprand2());
                if (llllllllllllllIIlIlllllIIIlIIIII != null) {
                    return llllllllllllllIIlIlllllIIIlIIIII;
                }
            }
            else if (llllllllllllllIIlIlllllIIIIllllI == 43 && llllllllllllllIIlIlllllIIIIlllll.getRight() == null) {
                return llllllllllllllIIlIlllllIIIIlllll.getLeft();
            }
        }
        else if (llllllllllllllIIlIlllllIIIIllIll instanceof Member) {
            final ASTree llllllllllllllIIlIlllllIIIIlllIl = getConstantFieldValue((Member)llllllllllllllIIlIlllllIIIIllIll);
            if (llllllllllllllIIlIlllllIIIIlllIl != null) {
                return llllllllllllllIIlIlllllIIIIlllIl;
            }
        }
        return llllllllllllllIIlIlllllIIIIllIll;
    }
    
    private static Expr makeAppendCall(final ASTree llllllllllllllIIlIllllIlllllllll, final ASTree llllllllllllllIIlIllllIlllllllII) {
        return CallExpr.makeCall(Expr.make(46, llllllllllllllIIlIllllIlllllllll, new Member("append")), new ASTList(llllllllllllllIIlIllllIlllllllII));
    }
    
    public void atMethodArgs(ASTList llllllllllllllIIlIllllIlIIllIllI, final int[] llllllllllllllIIlIllllIlIIllIlIl, final int[] llllllllllllllIIlIllllIlIIllIlII, final String[] llllllllllllllIIlIllllIlIIlllIIl) throws CompileError {
        int llllllllllllllIIlIllllIlIIlllIII = 0;
        while (llllllllllllllIIlIllllIlIIllIllI != null) {
            final ASTree llllllllllllllIIlIllllIlIIlllllI = ((ASTList)llllllllllllllIIlIllllIlIIllIllI).head();
            llllllllllllllIIlIllllIlIIlllllI.accept(this);
            llllllllllllllIIlIllllIlIIllIlIl[llllllllllllllIIlIllllIlIIlllIII] = this.exprType;
            llllllllllllllIIlIllllIlIIllIlII[llllllllllllllIIlIllllIlIIlllIII] = this.arrayDim;
            llllllllllllllIIlIllllIlIIlllIIl[llllllllllllllIIlIllllIlIIlllIII] = this.className;
            ++llllllllllllllIIlIllllIlIIlllIII;
            llllllllllllllIIlIllllIlIIllIllI = ((ASTList)llllllllllllllIIlIllllIlIIllIllI).tail();
        }
    }
    
    protected String resolveClassName(final String llllllllllllllIIlIllllllIIIlIllI) throws CompileError {
        return this.resolver.resolveJvmClassName(llllllllllllllIIlIllllllIIIlIllI);
    }
    
    public int getMethodArgsLength(final ASTList llllllllllllllIIlIllllIlIlIIIllI) {
        return ASTList.length(llllllllllllllIIlIllllIlIlIIIllI);
    }
    
    @Override
    public void atBinExpr(final BinExpr llllllllllllllIIlIlllllIIlIllIIl) throws CompileError {
        final int llllllllllllllIIlIlllllIIlIlllII = llllllllllllllIIlIlllllIIlIllIIl.getOperator();
        final int llllllllllllllIIlIlllllIIlIllIll = CodeGen.lookupBinOp(llllllllllllllIIlIlllllIIlIlllII);
        if (llllllllllllllIIlIlllllIIlIllIll >= 0) {
            if (llllllllllllllIIlIlllllIIlIlllII == 43) {
                Expr llllllllllllllIIlIlllllIIllIIIlI = this.atPlusExpr(llllllllllllllIIlIlllllIIlIllIIl);
                if (llllllllllllllIIlIlllllIIllIIIlI != null) {
                    llllllllllllllIIlIlllllIIllIIIlI = CallExpr.makeCall(Expr.make(46, llllllllllllllIIlIlllllIIllIIIlI, new Member("toString")), null);
                    llllllllllllllIIlIlllllIIlIllIIl.setOprand1(llllllllllllllIIlIlllllIIllIIIlI);
                    llllllllllllllIIlIlllllIIlIllIIl.setOprand2(null);
                    this.className = "java/lang/String";
                }
            }
            else {
                final ASTree llllllllllllllIIlIlllllIIllIIIIl = llllllllllllllIIlIlllllIIlIllIIl.oprand1();
                final ASTree llllllllllllllIIlIlllllIIllIIIII = llllllllllllllIIlIlllllIIlIllIIl.oprand2();
                llllllllllllllIIlIlllllIIllIIIIl.accept(this);
                final int llllllllllllllIIlIlllllIIlIlllll = this.exprType;
                llllllllllllllIIlIlllllIIllIIIII.accept(this);
                if (!this.isConstant(llllllllllllllIIlIlllllIIlIllIIl, llllllllllllllIIlIlllllIIlIlllII, llllllllllllllIIlIlllllIIllIIIIl, llllllllllllllIIlIlllllIIllIIIII)) {
                    this.computeBinExprType(llllllllllllllIIlIlllllIIlIllIIl, llllllllllllllIIlIlllllIIlIlllII, llllllllllllllIIlIlllllIIlIlllll);
                }
            }
        }
        else {
            this.booleanExpr(llllllllllllllIIlIlllllIIlIllIIl);
        }
    }
    
    private void insertCast(final BinExpr llllllllllllllIIlIllllIlllIlIlII, final int llllllllllllllIIlIllllIlllIlIIll, final int llllllllllllllIIlIllllIlllIlIIlI) throws CompileError {
        if (CodeGen.rightIsStrong(llllllllllllllIIlIllllIlllIlIIll, llllllllllllllIIlIllllIlllIlIIlI)) {
            llllllllllllllIIlIllllIlllIlIlII.setLeft(new CastExpr(llllllllllllllIIlIllllIlllIlIIlI, 0, llllllllllllllIIlIllllIlllIlIlII.oprand1()));
        }
        else {
            this.exprType = llllllllllllllIIlIllllIlllIlIIll;
        }
    }
    
    protected void atFieldPlusPlus(final ASTree llllllllllllllIIlIllllIIIIlIlIlI) throws CompileError {
        final CtField llllllllllllllIIlIllllIIIIlIlIIl = this.fieldAccess(llllllllllllllIIlIllllIIIIlIlIlI);
        this.atFieldRead(llllllllllllllIIlIllllIIIIlIlIIl);
        final int llllllllllllllIIlIllllIIIIlIlIII = this.exprType;
        if (llllllllllllllIIlIllllIIIIlIlIII == 324 || llllllllllllllIIlIllllIIIIlIlIII == 303 || llllllllllllllIIlIllllIIIIlIlIII == 306 || llllllllllllllIIlIllllIIIIlIlIII == 334) {
            this.exprType = 324;
        }
    }
    
    @Override
    public void atStringL(final StringL llllllllllllllIIlIllllIIIIIIlIIl) throws CompileError {
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/String";
    }
    
    private void computeBinExprType(final BinExpr llllllllllllllIIlIllllIlllllIIII, final int llllllllllllllIIlIllllIlllllIlII, final int llllllllllllllIIlIllllIlllllIIll) throws CompileError {
        final int llllllllllllllIIlIllllIlllllIIlI = this.exprType;
        if (llllllllllllllIIlIllllIlllllIlII == 364 || llllllllllllllIIlIllllIlllllIlII == 366 || llllllllllllllIIlIllllIlllllIlII == 370) {
            this.exprType = llllllllllllllIIlIllllIlllllIIll;
        }
        else {
            this.insertCast(llllllllllllllIIlIllllIlllllIIII, llllllllllllllIIlIllllIlllllIIll, llllllllllllllIIlIllllIlllllIIlI);
        }
        if (CodeGen.isP_INT(this.exprType) && this.exprType != 301) {
            this.exprType = 324;
        }
    }
    
    private static ASTree getConstantFieldValue(final Member llllllllllllllIIlIlllllIIIIlIllI) {
        return getConstantFieldValue(llllllllllllllIIlIlllllIIIIlIllI.getField());
    }
    
    private CtField fieldAccess2(final Expr llllllllllllllIIlIllllIIIllIlIII, final String llllllllllllllIIlIllllIIIllIIlll) throws CompileError {
        final Member llllllllllllllIIlIllllIIIllIIllI = (Member)llllllllllllllIIlIllllIIIllIlIII.oprand2();
        final CtField llllllllllllllIIlIllllIIIllIIlIl = this.resolver.lookupFieldByJvmName2(llllllllllllllIIlIllllIIIllIIlll, llllllllllllllIIlIllllIIIllIIllI, llllllllllllllIIlIllllIIIllIlIII);
        llllllllllllllIIlIllllIIIllIlIII.setOperator(35);
        llllllllllllllIIlIllllIIIllIlIII.setOprand1(new Symbol(MemberResolver.jvmToJavaName(llllllllllllllIIlIllllIIIllIIlll)));
        llllllllllllllIIlIllllIIIllIIllI.setField(llllllllllllllIIlIllllIIIllIIlIl);
        return llllllllllllllIIlIllllIIIllIIlIl;
    }
    
    public static ASTree getConstantFieldValue(final CtField llllllllllllllIIlIlllllIIIIIllll) {
        if (llllllllllllllIIlIlllllIIIIIllll == null) {
            return null;
        }
        final Object llllllllllllllIIlIlllllIIIIIlllI = llllllllllllllIIlIlllllIIIIIllll.getConstantValue();
        if (llllllllllllllIIlIlllllIIIIIlllI == null) {
            return null;
        }
        if (llllllllllllllIIlIlllllIIIIIlllI instanceof String) {
            return new StringL((String)llllllllllllllIIlIlllllIIIIIlllI);
        }
        if (llllllllllllllIIlIlllllIIIIIlllI instanceof Double || llllllllllllllIIlIlllllIIIIIlllI instanceof Float) {
            final int llllllllllllllIIlIlllllIIIIlIIIl = (llllllllllllllIIlIlllllIIIIIlllI instanceof Double) ? 405 : 404;
            return new DoubleConst(((Number)llllllllllllllIIlIlllllIIIIIlllI).doubleValue(), llllllllllllllIIlIlllllIIIIlIIIl);
        }
        if (llllllllllllllIIlIlllllIIIIIlllI instanceof Number) {
            final int llllllllllllllIIlIlllllIIIIlIIII = (llllllllllllllIIlIlllllIIIIIlllI instanceof Long) ? 403 : 402;
            return new IntConst(((Number)llllllllllllllIIlIlllllIIIIIlllI).longValue(), llllllllllllllIIlIlllllIIIIlIIII);
        }
        if (llllllllllllllIIlIlllllIIIIIlllI instanceof Boolean) {
            return new Keyword(llllllllllllllIIlIlllllIIIIIlllI ? 410 : 411);
        }
        return null;
    }
    
    private void booleanExpr(final ASTree llllllllllllllIIlIllllIllllIIIIl) throws CompileError {
        final int llllllllllllllIIlIllllIllllIIIII = CodeGen.getCompOperator(llllllllllllllIIlIllllIllllIIIIl);
        if (llllllllllllllIIlIllllIllllIIIII == 358) {
            final BinExpr llllllllllllllIIlIllllIllllIIllI = (BinExpr)llllllllllllllIIlIllllIllllIIIIl;
            llllllllllllllIIlIllllIllllIIllI.oprand1().accept(this);
            final int llllllllllllllIIlIllllIllllIIlIl = this.exprType;
            final int llllllllllllllIIlIllllIllllIIlII = this.arrayDim;
            llllllllllllllIIlIllllIllllIIllI.oprand2().accept(this);
            if (llllllllllllllIIlIllllIllllIIlII == 0 && this.arrayDim == 0) {
                this.insertCast(llllllllllllllIIlIllllIllllIIllI, llllllllllllllIIlIllllIllllIIlIl, this.exprType);
            }
        }
        else if (llllllllllllllIIlIllllIllllIIIII == 33) {
            ((Expr)llllllllllllllIIlIllllIllllIIIIl).oprand1().accept(this);
        }
        else if (llllllllllllllIIlIllllIllllIIIII == 369 || llllllllllllllIIlIllllIllllIIIII == 368) {
            final BinExpr llllllllllllllIIlIllllIllllIIIll = (BinExpr)llllllllllllllIIlIllllIllllIIIIl;
            llllllllllllllIIlIllllIllllIIIll.oprand1().accept(this);
            llllllllllllllIIlIllllIllllIIIll.oprand2().accept(this);
        }
        else {
            llllllllllllllIIlIllllIllllIIIIl.accept(this);
        }
        this.exprType = 301;
        this.arrayDim = 0;
    }
    
    protected String resolveClassName(final ASTList llllllllllllllIIlIllllllIIIlllII) throws CompileError {
        return this.resolver.resolveClassName(llllllllllllllIIlIllllllIIIlllII);
    }
    
    @Override
    public void atKeyword(final Keyword llllllllllllllIIlIllllIIIIIIllIl) throws CompileError {
        this.arrayDim = 0;
        final int llllllllllllllIIlIllllIIIIIIllll = llllllllllllllIIlIllllIIIIIIllIl.get();
        switch (llllllllllllllIIlIllllIIIIIIllll) {
            case 410:
            case 411: {
                this.exprType = 301;
                break;
            }
            case 412: {
                this.exprType = 412;
                break;
            }
            case 336:
            case 339: {
                this.exprType = 307;
                if (llllllllllllllIIlIllllIIIIIIllll == 339) {
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
    
    @Override
    public void atCastExpr(final CastExpr llllllllllllllIIlIllllIlllIIlIIl) throws CompileError {
        final String llllllllllllllIIlIllllIlllIIlIII = this.resolveClassName(llllllllllllllIIlIllllIlllIIlIIl.getClassName());
        llllllllllllllIIlIllllIlllIIlIIl.getOprand().accept(this);
        this.exprType = llllllllllllllIIlIllllIlllIIlIIl.getType();
        this.arrayDim = llllllllllllllIIlIllllIlllIIlIIl.getArrayDim();
        this.className = llllllllllllllIIlIllllIlllIIlIII;
    }
    
    private static boolean isPlusExpr(final ASTree llllllllllllllIIlIlllllIIIIIIlII) {
        if (llllllllllllllIIlIlllllIIIIIIlII instanceof BinExpr) {
            final BinExpr llllllllllllllIIlIlllllIIIIIIlll = (BinExpr)llllllllllllllIIlIlllllIIIIIIlII;
            final int llllllllllllllIIlIlllllIIIIIIllI = llllllllllllllIIlIlllllIIIIIIlll.getOperator();
            return llllllllllllllIIlIlllllIIIIIIllI == 43;
        }
        return false;
    }
    
    @Override
    public void atCallExpr(final CallExpr llllllllllllllIIlIllllIllIIIIIlI) throws CompileError {
        String llllllllllllllIIlIllllIllIIIlIII = null;
        CtClass llllllllllllllIIlIllllIllIIIIlll = null;
        final ASTree llllllllllllllIIlIllllIllIIIIllI = llllllllllllllIIlIllllIllIIIIIlI.oprand1();
        final ASTList llllllllllllllIIlIllllIllIIIIlIl = (ASTList)llllllllllllllIIlIllllIllIIIIIlI.oprand2();
        if (llllllllllllllIIlIllllIllIIIIllI instanceof Member) {
            llllllllllllllIIlIllllIllIIIlIII = ((Member)llllllllllllllIIlIllllIllIIIIllI).get();
            llllllllllllllIIlIllllIllIIIIlll = this.thisClass;
        }
        else if (llllllllllllllIIlIllllIllIIIIllI instanceof Keyword) {
            llllllllllllllIIlIllllIllIIIlIII = "<init>";
            if (((Keyword)llllllllllllllIIlIllllIllIIIIllI).get() == 336) {
                llllllllllllllIIlIllllIllIIIIlll = MemberResolver.getSuperclass(this.thisClass);
            }
            else {
                llllllllllllllIIlIllllIllIIIIlll = this.thisClass;
            }
        }
        else if (llllllllllllllIIlIllllIllIIIIllI instanceof Expr) {
            final Expr llllllllllllllIIlIllllIllIIIllII = (Expr)llllllllllllllIIlIllllIllIIIIllI;
            llllllllllllllIIlIllllIllIIIlIII = ((Symbol)llllllllllllllIIlIllllIllIIIllII.oprand2()).get();
            final int llllllllllllllIIlIllllIllIIIlIll = llllllllllllllIIlIllllIllIIIllII.getOperator();
            if (llllllllllllllIIlIllllIllIIIlIll == 35) {
                llllllllllllllIIlIllllIllIIIIlll = this.resolver.lookupClass(((Symbol)llllllllllllllIIlIllllIllIIIllII.oprand1()).get(), false);
            }
            else if (llllllllllllllIIlIllllIllIIIlIll == 46) {
                final ASTree llllllllllllllIIlIllllIllIIIlllI = llllllllllllllIIlIllllIllIIIllII.oprand1();
                final String llllllllllllllIIlIllllIllIIIllIl = isDotSuper(llllllllllllllIIlIllllIllIIIlllI);
                if (llllllllllllllIIlIllllIllIIIllIl != null) {
                    llllllllllllllIIlIllllIllIIIIlll = MemberResolver.getSuperInterface(this.thisClass, llllllllllllllIIlIllllIllIIIllIl);
                }
                else {
                    try {
                        llllllllllllllIIlIllllIllIIIlllI.accept(this);
                    }
                    catch (NoFieldException llllllllllllllIIlIllllIllIIIllll) {
                        if (llllllllllllllIIlIllllIllIIIllll.getExpr() != llllllllllllllIIlIllllIllIIIlllI) {
                            throw llllllllllllllIIlIllllIllIIIllll;
                        }
                        this.exprType = 307;
                        this.arrayDim = 0;
                        this.className = llllllllllllllIIlIllllIllIIIllll.getField();
                        llllllllllllllIIlIllllIllIIIllII.setOperator(35);
                        llllllllllllllIIlIllllIllIIIllII.setOprand1(new Symbol(MemberResolver.jvmToJavaName(this.className)));
                    }
                    if (this.arrayDim > 0) {
                        llllllllllllllIIlIllllIllIIIIlll = this.resolver.lookupClass("java.lang.Object", true);
                    }
                    else if (this.exprType == 307) {
                        llllllllllllllIIlIllllIllIIIIlll = this.resolver.lookupClassByJvmName(this.className);
                    }
                    else {
                        badMethod();
                    }
                }
            }
            else {
                badMethod();
            }
        }
        else {
            fatal();
        }
        final MemberResolver.Method llllllllllllllIIlIllllIllIIIIlII = this.atMethodCallCore(llllllllllllllIIlIllllIllIIIIlll, llllllllllllllIIlIllllIllIIIlIII, llllllllllllllIIlIllllIllIIIIlIl);
        llllllllllllllIIlIllllIllIIIIIlI.setMethod(llllllllllllllIIlIllllIllIIIIlII);
    }
    
    @Override
    public void atCondExpr(final CondExpr llllllllllllllIIlIlllllIIlllIIlI) throws CompileError {
        this.booleanExpr(llllllllllllllIIlIlllllIIlllIIlI.condExpr());
        llllllllllllllIIlIlllllIIlllIIlI.thenExpr().accept(this);
        final int llllllllllllllIIlIlllllIIlllIIIl = this.exprType;
        final int llllllllllllllIIlIlllllIIlllIIII = this.arrayDim;
        final String llllllllllllllIIlIlllllIIllIllll = this.className;
        llllllllllllllIIlIlllllIIlllIIlI.elseExpr().accept(this);
        if (llllllllllllllIIlIlllllIIlllIIII == 0 && llllllllllllllIIlIlllllIIlllIIII == this.arrayDim) {
            if (CodeGen.rightIsStrong(llllllllllllllIIlIlllllIIlllIIIl, this.exprType)) {
                llllllllllllllIIlIlllllIIlllIIlI.setThen(new CastExpr(this.exprType, 0, llllllllllllllIIlIlllllIIlllIIlI.thenExpr()));
            }
            else if (CodeGen.rightIsStrong(this.exprType, llllllllllllllIIlIlllllIIlllIIIl)) {
                llllllllllllllIIlIlllllIIlllIIlI.setElse(new CastExpr(llllllllllllllIIlIlllllIIlllIIIl, 0, llllllllllllllIIlIlllllIIlllIIlI.elseExpr()));
                this.exprType = llllllllllllllIIlIlllllIIlllIIIl;
            }
        }
    }
    
    public void atClassObject(final Expr llllllllllllllIIlIllllIIIlIlllIl) throws CompileError {
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/Class";
    }
    
    protected static StringBuffer typeToString(final StringBuffer llllllllllllllIIlIllllllIIllIIIl, final int llllllllllllllIIlIllllllIIllIlIl, int llllllllllllllIIlIllllllIIlIllll, final String llllllllllllllIIlIllllllIIlIlllI) {
        String llllllllllllllIIlIllllllIIllIIlI = null;
        if (llllllllllllllIIlIllllllIIllIlIl == 307) {
            final String llllllllllllllIIlIllllllIIlllIlI = MemberResolver.jvmToJavaName(llllllllllllllIIlIllllllIIlIlllI);
        }
        else if (llllllllllllllIIlIllllllIIllIlIl == 412) {
            final String llllllllllllllIIlIllllllIIlllIIl = "Object";
        }
        else {
            try {
                final String llllllllllllllIIlIllllllIIlllIII = MemberResolver.getTypeName(llllllllllllllIIlIllllllIIllIlIl);
            }
            catch (CompileError llllllllllllllIIlIllllllIIllIlll) {
                llllllllllllllIIlIllllllIIllIIlI = "?";
            }
        }
        llllllllllllllIIlIllllllIIllIIIl.append(llllllllllllllIIlIllllllIIllIIlI);
        while (llllllllllllllIIlIllllllIIlIllll-- > 0) {
            llllllllllllllIIlIllllllIIllIIIl.append("[]");
        }
        return llllllllllllllIIlIllllllIIllIIIl;
    }
    
    @Override
    public void atInstanceOfExpr(final InstanceOfExpr llllllllllllllIIlIllllIllIllllll) throws CompileError {
        llllllllllllllIIlIllllIllIllllll.getOprand().accept(this);
        this.exprType = 301;
        this.arrayDim = 0;
    }
    
    static {
        jvmJavaLangString = "java/lang/String";
        jvmJavaLangClass = "java/lang/Class";
        javaLangObject = "java.lang.Object";
        jvmJavaLangObject = "java/lang/Object";
    }
    
    private void atPlusPlus(final int llllllllllllllIIlIllllIIIIlllIIl, ASTree llllllllllllllIIlIllllIIIIllIlII, final Expr llllllllllllllIIlIllllIIIIllIIll) throws CompileError {
        final boolean llllllllllllllIIlIllllIIIIllIllI = llllllllllllllIIlIllllIIIIllIlII == null;
        if (llllllllllllllIIlIllllIIIIllIllI) {
            llllllllllllllIIlIllllIIIIllIlII = llllllllllllllIIlIllllIIIIllIIll.oprand2();
        }
        if (llllllllllllllIIlIllllIIIIllIlII instanceof Variable) {
            final Declarator llllllllllllllIIlIllllIIIIllllIl = ((Variable)llllllllllllllIIlIllllIIIIllIlII).getDeclarator();
            this.exprType = llllllllllllllIIlIllllIIIIllllIl.getType();
            this.arrayDim = llllllllllllllIIlIllllIIIIllllIl.getArrayDim();
        }
        else {
            if (llllllllllllllIIlIllllIIIIllIlII instanceof Expr) {
                final Expr llllllllllllllIIlIllllIIIIlllIll = (Expr)llllllllllllllIIlIllllIIIIllIlII;
                if (llllllllllllllIIlIllllIIIIlllIll.getOperator() == 65) {
                    this.atArrayRead(llllllllllllllIIlIllllIIIIlllIll.oprand1(), llllllllllllllIIlIllllIIIIlllIll.oprand2());
                    final int llllllllllllllIIlIllllIIIIllllII = this.exprType;
                    if (llllllllllllllIIlIllllIIIIllllII == 324 || llllllllllllllIIlIllllIIIIllllII == 303 || llllllllllllllIIlIllllIIIIllllII == 306 || llllllllllllllIIlIllllIIIIllllII == 334) {
                        this.exprType = 324;
                    }
                    return;
                }
            }
            this.atFieldPlusPlus(llllllllllllllIIlIllllIIIIllIlII);
        }
    }
    
    public void atArrayLength(final Expr llllllllllllllIIlIllllIIIlIllIII) throws CompileError {
        llllllllllllllIIlIllllIIIlIllIII.oprand1().accept(this);
        if (this.arrayDim == 0) {
            throw new NoFieldException("length", llllllllllllllIIlIllllIIIlIllIII);
        }
        this.exprType = 324;
        this.arrayDim = 0;
    }
    
    protected String getThisName() {
        return MemberResolver.javaToJvmName(this.thisClass.getName());
    }
    
    private boolean isConstant(final BinExpr llllllllllllllIIlIlllllIIIllIIII, final int llllllllllllllIIlIlllllIIIlIllll, ASTree llllllllllllllIIlIlllllIIIlIlIII, ASTree llllllllllllllIIlIlllllIIIlIIlll) throws CompileError {
        llllllllllllllIIlIlllllIIIlIlIII = (byte)stripPlusExpr((ASTree)llllllllllllllIIlIlllllIIIlIlIII);
        llllllllllllllIIlIlllllIIIlIIlll = stripPlusExpr(llllllllllllllIIlIlllllIIIlIIlll);
        ASTree llllllllllllllIIlIlllllIIIlIllII = null;
        if (llllllllllllllIIlIlllllIIIlIlIII instanceof StringL && llllllllllllllIIlIlllllIIIlIIlll instanceof StringL && llllllllllllllIIlIlllllIIIlIllll == 43) {
            llllllllllllllIIlIlllllIIIlIllII = new StringL(String.valueOf(new StringBuilder().append(((StringL)llllllllllllllIIlIlllllIIIlIlIII).get()).append(((StringL)llllllllllllllIIlIlllllIIIlIIlll).get())));
        }
        else if (llllllllllllllIIlIlllllIIIlIlIII instanceof IntConst) {
            llllllllllllllIIlIlllllIIIlIllII = ((IntConst)llllllllllllllIIlIlllllIIIlIlIII).compute(llllllllllllllIIlIlllllIIIlIllll, llllllllllllllIIlIlllllIIIlIIlll);
        }
        else if (llllllllllllllIIlIlllllIIIlIlIII instanceof DoubleConst) {
            llllllllllllllIIlIlllllIIIlIllII = ((DoubleConst)llllllllllllllIIlIlllllIIIlIlIII).compute(llllllllllllllIIlIlllllIIIlIllll, llllllllllllllIIlIlllllIIIlIIlll);
        }
        if (llllllllllllllIIlIlllllIIIlIllII == null) {
            return false;
        }
        llllllllllllllIIlIlllllIIIllIIII.setOperator(43);
        llllllllllllllIIlIlllllIIIllIIII.setOprand1(llllllllllllllIIlIlllllIIIlIllII);
        llllllllllllllIIlIlllllIIIllIIII.setOprand2(null);
        llllllllllllllIIlIlllllIIIlIllII.accept(this);
        return true;
    }
    
    private static void badMethod() throws CompileError {
        throw new CompileError("bad method");
    }
    
    protected static void fatal() throws CompileError {
        throw new CompileError("fatal");
    }
    
    private void atFieldRead(final CtField llllllllllllllIIlIllllIIlIIlIlIl) throws CompileError {
        final FieldInfo llllllllllllllIIlIllllIIlIIlIlII = llllllllllllllIIlIllllIIlIIlIlIl.getFieldInfo2();
        final String llllllllllllllIIlIllllIIlIIlIIll = llllllllllllllIIlIllllIIlIIlIlII.getDescriptor();
        int llllllllllllllIIlIllllIIlIIlIIlI = 0;
        int llllllllllllllIIlIllllIIlIIlIIIl = 0;
        char llllllllllllllIIlIllllIIlIIlIIII;
        for (llllllllllllllIIlIllllIIlIIlIIII = llllllllllllllIIlIllllIIlIIlIIll.charAt(llllllllllllllIIlIllllIIlIIlIIlI); llllllllllllllIIlIllllIIlIIlIIII == '['; llllllllllllllIIlIllllIIlIIlIIII = llllllllllllllIIlIllllIIlIIlIIll.charAt(++llllllllllllllIIlIllllIIlIIlIIlI)) {
            ++llllllllllllllIIlIllllIIlIIlIIIl;
        }
        this.arrayDim = llllllllllllllIIlIllllIIlIIlIIIl;
        this.exprType = MemberResolver.descToType(llllllllllllllIIlIllllIIlIIlIIII);
        if (llllllllllllllIIlIllllIIlIIlIIII == 'L') {
            this.className = llllllllllllllIIlIllllIIlIIlIIll.substring(llllllllllllllIIlIllllIIlIIlIIlI + 1, llllllllllllllIIlIllllIIlIIlIIll.indexOf(59, llllllllllllllIIlIllllIIlIIlIIlI + 1));
        }
        else {
            this.className = null;
        }
    }
    
    protected void atFieldAssign(final Expr llllllllllllllIIlIlllllIlIIIIlll, final int llllllllllllllIIlIlllllIlIIIIllI, final ASTree llllllllllllllIIlIlllllIIllllllI, final ASTree llllllllllllllIIlIlllllIIlllllIl) throws CompileError {
        final CtField llllllllllllllIIlIlllllIlIIIIIll = this.fieldAccess(llllllllllllllIIlIlllllIIllllllI);
        this.atFieldRead(llllllllllllllIIlIlllllIlIIIIIll);
        final int llllllllllllllIIlIlllllIlIIIIIlI = this.exprType;
        final int llllllllllllllIIlIlllllIlIIIIIIl = this.arrayDim;
        final String llllllllllllllIIlIlllllIlIIIIIII = this.className;
        llllllllllllllIIlIlllllIIlllllIl.accept(this);
        this.exprType = llllllllllllllIIlIlllllIlIIIIIlI;
        this.arrayDim = llllllllllllllIIlIlllllIlIIIIIIl;
        this.className = llllllllllllllIIlIlllllIlIIIIIII;
    }
    
    protected String getSuperName() throws CompileError {
        return MemberResolver.javaToJvmName(MemberResolver.getSuperclass(this.thisClass).getName());
    }
    
    @Override
    public void atDoubleConst(final DoubleConst llllllllllllllIIlIlllIlllllllIIl) throws CompileError {
        this.arrayDim = 0;
        if (llllllllllllllIIlIlllIlllllllIIl.getType() == 405) {
            this.exprType = 312;
        }
        else {
            this.exprType = 317;
        }
    }
    
    @Override
    public void atExpr(final Expr llllllllllllllIIlIllllIllIllIlII) throws CompileError {
        final int llllllllllllllIIlIllllIllIllIIll = llllllllllllllIIlIllllIllIllIlII.getOperator();
        final ASTree llllllllllllllIIlIllllIllIllIIlI = llllllllllllllIIlIllllIllIllIlII.oprand1();
        if (llllllllllllllIIlIllllIllIllIIll == 46) {
            final String llllllllllllllIIlIllllIllIllIlll = ((Symbol)llllllllllllllIIlIllllIllIllIlII.oprand2()).get();
            if (llllllllllllllIIlIllllIllIllIlll.equals("length")) {
                try {
                    this.atArrayLength(llllllllllllllIIlIllllIllIllIlII);
                }
                catch (NoFieldException llllllllllllllIIlIllllIllIlllIII) {
                    this.atFieldRead(llllllllllllllIIlIllllIllIllIlII);
                }
            }
            else if (llllllllllllllIIlIllllIllIllIlll.equals("class")) {
                this.atClassObject(llllllllllllllIIlIllllIllIllIlII);
            }
            else {
                this.atFieldRead(llllllllllllllIIlIllllIllIllIlII);
            }
        }
        else if (llllllllllllllIIlIllllIllIllIIll == 35) {
            final String llllllllllllllIIlIllllIllIllIllI = ((Symbol)llllllllllllllIIlIllllIllIllIlII.oprand2()).get();
            if (llllllllllllllIIlIllllIllIllIllI.equals("class")) {
                this.atClassObject(llllllllllllllIIlIllllIllIllIlII);
            }
            else {
                this.atFieldRead(llllllllllllllIIlIllllIllIllIlII);
            }
        }
        else if (llllllllllllllIIlIllllIllIllIIll == 65) {
            this.atArrayRead(llllllllllllllIIlIllllIllIllIIlI, llllllllllllllIIlIllllIllIllIlII.oprand2());
        }
        else if (llllllllllllllIIlIllllIllIllIIll == 362 || llllllllllllllIIlIllllIllIllIIll == 363) {
            this.atPlusPlus(llllllllllllllIIlIllllIllIllIIll, llllllllllllllIIlIllllIllIllIIlI, llllllllllllllIIlIllllIllIllIlII);
        }
        else if (llllllllllllllIIlIllllIllIllIIll == 33) {
            this.booleanExpr(llllllllllllllIIlIllllIllIllIlII);
        }
        else if (llllllllllllllIIlIllllIllIllIIll == 67) {
            fatal();
        }
        else {
            llllllllllllllIIlIllllIllIllIIlI.accept(this);
            if (!this.isConstant(llllllllllllllIIlIllllIllIllIlII, llllllllllllllIIlIllllIllIllIIll, llllllllllllllIIlIllllIllIllIIlI) && (llllllllllllllIIlIllllIllIllIIll == 45 || llllllllllllllIIlIllllIllIllIIll == 126) && CodeGen.isP_INT(this.exprType)) {
                this.exprType = 324;
            }
        }
    }
    
    public MemberResolver.Method atMethodCallCore(final CtClass llllllllllllllIIlIllllIlIlIlIlII, final String llllllllllllllIIlIllllIlIlIlIIll, final ASTList llllllllllllllIIlIllllIlIlIlllII) throws CompileError {
        final int llllllllllllllIIlIllllIlIlIllIll = this.getMethodArgsLength(llllllllllllllIIlIllllIlIlIlllII);
        final int[] llllllllllllllIIlIllllIlIlIllIlI = new int[llllllllllllllIIlIllllIlIlIllIll];
        final int[] llllllllllllllIIlIllllIlIlIllIIl = new int[llllllllllllllIIlIllllIlIlIllIll];
        final String[] llllllllllllllIIlIllllIlIlIllIII = new String[llllllllllllllIIlIllllIlIlIllIll];
        this.atMethodArgs(llllllllllllllIIlIllllIlIlIlllII, llllllllllllllIIlIllllIlIlIllIlI, llllllllllllllIIlIllllIlIlIllIIl, llllllllllllllIIlIllllIlIlIllIII);
        final MemberResolver.Method llllllllllllllIIlIllllIlIlIlIlll = this.resolver.lookupMethod(llllllllllllllIIlIllllIlIlIlIlII, this.thisClass, this.thisMethod, llllllllllllllIIlIllllIlIlIlIIll, llllllllllllllIIlIllllIlIlIllIlI, llllllllllllllIIlIllllIlIlIllIIl, llllllllllllllIIlIllllIlIlIllIII);
        if (llllllllllllllIIlIllllIlIlIlIlll == null) {
            final String llllllllllllllIIlIllllIlIllIIIlI = llllllllllllllIIlIllllIlIlIlIlII.getName();
            final String llllllllllllllIIlIllllIlIllIIIIl = argTypesToString(llllllllllllllIIlIllllIlIlIllIlI, llllllllllllllIIlIllllIlIlIllIIl, llllllllllllllIIlIllllIlIlIllIII);
            String llllllllllllllIIlIllllIlIllIIIII = null;
            if (llllllllllllllIIlIllllIlIlIlIIll.equals("<init>")) {
                final String llllllllllllllIIlIllllIlIllIIIll = String.valueOf(new StringBuilder().append("cannot find constructor ").append(llllllllllllllIIlIllllIlIllIIIlI).append(llllllllllllllIIlIllllIlIllIIIIl));
            }
            else {
                llllllllllllllIIlIllllIlIllIIIII = String.valueOf(new StringBuilder().append(llllllllllllllIIlIllllIlIlIlIIll).append(llllllllllllllIIlIllllIlIllIIIIl).append(" not found in ").append(llllllllllllllIIlIllllIlIllIIIlI));
            }
            throw new CompileError(llllllllllllllIIlIllllIlIllIIIII);
        }
        final String llllllllllllllIIlIllllIlIlIlIllI = llllllllllllllIIlIllllIlIlIlIlll.info.getDescriptor();
        this.setReturnType(llllllllllllllIIlIllllIlIlIlIllI);
        return llllllllllllllIIlIllllIlIlIlIlll;
    }
}
