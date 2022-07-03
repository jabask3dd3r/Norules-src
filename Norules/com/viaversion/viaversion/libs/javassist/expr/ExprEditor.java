package com.viaversion.viaversion.libs.javassist.expr;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class ExprEditor
{
    public void edit(final NewExpr lllllllllllllIlIIIIIIIlllIIlllIl) throws CannotCompileException {
    }
    
    public void edit(final FieldAccess lllllllllllllIlIIIIIIIlllIIlIlIl) throws CannotCompileException {
    }
    
    public boolean doit(final CtClass lllllllllllllIlIIIIIIIlllllIlllI, final MethodInfo lllllllllllllIlIIIIIIIlllllIllIl) throws CannotCompileException {
        final CodeAttribute lllllllllllllIlIIIIIIIlllllllIlI = lllllllllllllIlIIIIIIIlllllIllIl.getCodeAttribute();
        if (lllllllllllllIlIIIIIIIlllllllIlI == null) {
            return false;
        }
        final CodeIterator lllllllllllllIlIIIIIIIllllllIlll = lllllllllllllIlIIIIIIIlllllllIlI.iterator();
        boolean lllllllllllllIlIIIIIIIllllllIlIl = false;
        final LoopContext lllllllllllllIlIIIIIIIllllllIIll = new LoopContext(lllllllllllllIlIIIIIIIlllllllIlI.getMaxLocals());
        while (lllllllllllllIlIIIIIIIllllllIlll.hasNext()) {
            if (this.loopBody(lllllllllllllIlIIIIIIIllllllIlll, lllllllllllllIlIIIIIIIlllllIlllI, lllllllllllllIlIIIIIIIlllllIllIl, lllllllllllllIlIIIIIIIllllllIIll)) {
                lllllllllllllIlIIIIIIIllllllIlIl = true;
            }
        }
        final ExceptionTable lllllllllllllIlIIIIIIIllllllIIlI = lllllllllllllIlIIIIIIIlllllllIlI.getExceptionTable();
        for (int lllllllllllllIlIIIIIIIllllllIIII = lllllllllllllIlIIIIIIIllllllIIlI.size(), lllllllllllllIlIIIIIIIllllllllll = 0; lllllllllllllIlIIIIIIIllllllllll < lllllllllllllIlIIIIIIIllllllIIII; ++lllllllllllllIlIIIIIIIllllllllll) {
            final Handler lllllllllllllIlIIIIIIlIIIIIIIIII = new Handler(lllllllllllllIlIIIIIIIllllllIIlI, lllllllllllllIlIIIIIIIllllllllll, lllllllllllllIlIIIIIIIllllllIlll, lllllllllllllIlIIIIIIIlllllIlllI, lllllllllllllIlIIIIIIIlllllIllIl);
            this.edit(lllllllllllllIlIIIIIIlIIIIIIIIII);
            if (lllllllllllllIlIIIIIIlIIIIIIIIII.edited()) {
                lllllllllllllIlIIIIIIIllllllIlIl = true;
                lllllllllllllIlIIIIIIIllllllIIll.updateMax(lllllllllllllIlIIIIIIlIIIIIIIIII.locals(), lllllllllllllIlIIIIIIlIIIIIIIIII.stack());
            }
        }
        if (lllllllllllllIlIIIIIIIlllllllIlI.getMaxLocals() < lllllllllllllIlIIIIIIIllllllIIll.maxLocals) {
            lllllllllllllIlIIIIIIIlllllllIlI.setMaxLocals(lllllllllllllIlIIIIIIIllllllIIll.maxLocals);
        }
        lllllllllllllIlIIIIIIIlllllllIlI.setMaxStack(lllllllllllllIlIIIIIIIlllllllIlI.getMaxStack() + lllllllllllllIlIIIIIIIllllllIIll.maxStack);
        try {
            if (lllllllllllllIlIIIIIIIllllllIlIl) {
                lllllllllllllIlIIIIIIIlllllIllIl.rebuildStackMapIf6(lllllllllllllIlIIIIIIIlllllIlllI.getClassPool(), lllllllllllllIlIIIIIIIlllllIlllI.getClassFile2());
            }
        }
        catch (BadBytecode lllllllllllllIlIIIIIIIlllllllllI) {
            throw new CannotCompileException(lllllllllllllIlIIIIIIIlllllllllI.getMessage(), lllllllllllllIlIIIIIIIlllllllllI);
        }
        return lllllllllllllIlIIIIIIIllllllIlIl;
    }
    
    public void edit(final Handler lllllllllllllIlIIIIIIIlllIIIllll) throws CannotCompileException {
    }
    
    public void edit(final ConstructorCall lllllllllllllIlIIIIIIIlllIIlIlll) throws CannotCompileException {
    }
    
    public void edit(final NewArray lllllllllllllIlIIIIIIIlllIIllIll) throws CannotCompileException {
    }
    
    public void edit(final MethodCall lllllllllllllIlIIIIIIIlllIIllIIl) throws CannotCompileException {
    }
    
    boolean doit(final CtClass lllllllllllllIlIIIIIIIllllIlIIII, final MethodInfo lllllllllllllIlIIIIIIIllllIIlIII, final LoopContext lllllllllllllIlIIIIIIIllllIIlllI, final CodeIterator lllllllllllllIlIIIIIIIllllIIIllI, int lllllllllllllIlIIIIIIIllllIIIlIl) throws CannotCompileException {
        boolean lllllllllllllIlIIIIIIIllllIIlIll = false;
        while (lllllllllllllIlIIIIIIIllllIIIllI.hasNext() && lllllllllllllIlIIIIIIIllllIIIllI.lookAhead() < lllllllllllllIlIIIIIIIllllIIIlIl) {
            final int lllllllllllllIlIIIIIIIllllIlIIlI = lllllllllllllIlIIIIIIIllllIIIllI.getCodeLength();
            if (this.loopBody(lllllllllllllIlIIIIIIIllllIIIllI, lllllllllllllIlIIIIIIIllllIlIIII, lllllllllllllIlIIIIIIIllllIIlIII, lllllllllllllIlIIIIIIIllllIIlllI)) {
                lllllllllllllIlIIIIIIIllllIIlIll = true;
                final int lllllllllllllIlIIIIIIIllllIlIIll = lllllllllllllIlIIIIIIIllllIIIllI.getCodeLength();
                if (lllllllllllllIlIIIIIIIllllIlIIlI == lllllllllllllIlIIIIIIIllllIlIIll) {
                    continue;
                }
                lllllllllllllIlIIIIIIIllllIIIlIl += lllllllllllllIlIIIIIIIllllIlIIll - lllllllllllllIlIIIIIIIllllIlIIlI;
            }
        }
        return lllllllllllllIlIIIIIIIllllIIlIll;
    }
    
    public void edit(final Instanceof lllllllllllllIlIIIIIIIlllIIlIIll) throws CannotCompileException {
    }
    
    final boolean loopBody(final CodeIterator lllllllllllllIlIIIIIIIlllIlIllIl, final CtClass lllllllllllllIlIIIIIIIlllIlIIlll, final MethodInfo lllllllllllllIlIIIIIIIlllIlIlIll, final LoopContext lllllllllllllIlIIIIIIIlllIlIlIlI) throws CannotCompileException {
        try {
            Expr lllllllllllllIlIIIIIIIlllIllIIlI = null;
            final int lllllllllllllIlIIIIIIIlllIllIIIl = lllllllllllllIlIIIIIIIlllIlIllIl.next();
            final int lllllllllllllIlIIIIIIIlllIllIIII = lllllllllllllIlIIIIIIIlllIlIllIl.byteAt(lllllllllllllIlIIIIIIIlllIllIIIl);
            if (lllllllllllllIlIIIIIIIlllIllIIII >= 178) {
                if (lllllllllllllIlIIIIIIIlllIllIIII < 188) {
                    if (lllllllllllllIlIIIIIIIlllIllIIII == 184 || lllllllllllllIlIIIIIIIlllIllIIII == 185 || lllllllllllllIlIIIIIIIlllIllIIII == 182) {
                        lllllllllllllIlIIIIIIIlllIllIIlI = new MethodCall(lllllllllllllIlIIIIIIIlllIllIIIl, lllllllllllllIlIIIIIIIlllIlIllIl, lllllllllllllIlIIIIIIIlllIlIIlll, lllllllllllllIlIIIIIIIlllIlIlIll);
                        this.edit((MethodCall)lllllllllllllIlIIIIIIIlllIllIIlI);
                    }
                    else if (lllllllllllllIlIIIIIIIlllIllIIII == 180 || lllllllllllllIlIIIIIIIlllIllIIII == 178 || lllllllllllllIlIIIIIIIlllIllIIII == 181 || lllllllllllllIlIIIIIIIlllIllIIII == 179) {
                        lllllllllllllIlIIIIIIIlllIllIIlI = new FieldAccess(lllllllllllllIlIIIIIIIlllIllIIIl, lllllllllllllIlIIIIIIIlllIlIllIl, lllllllllllllIlIIIIIIIlllIlIIlll, lllllllllllllIlIIIIIIIlllIlIlIll, lllllllllllllIlIIIIIIIlllIllIIII);
                        this.edit((FieldAccess)lllllllllllllIlIIIIIIIlllIllIIlI);
                    }
                    else if (lllllllllllllIlIIIIIIIlllIllIIII == 187) {
                        final int lllllllllllllIlIIIIIIIlllIllIllI = lllllllllllllIlIIIIIIIlllIlIllIl.u16bitAt(lllllllllllllIlIIIIIIIlllIllIIIl + 1);
                        lllllllllllllIlIIIIIIIlllIlIlIlI.newList = new NewOp(lllllllllllllIlIIIIIIIlllIlIlIlI.newList, lllllllllllllIlIIIIIIIlllIllIIIl, lllllllllllllIlIIIIIIIlllIlIlIll.getConstPool().getClassInfo(lllllllllllllIlIIIIIIIlllIllIllI));
                    }
                    else if (lllllllllllllIlIIIIIIIlllIllIIII == 183) {
                        final NewOp lllllllllllllIlIIIIIIIlllIllIIll = lllllllllllllIlIIIIIIIlllIlIlIlI.newList;
                        if (lllllllllllllIlIIIIIIIlllIllIIll != null && lllllllllllllIlIIIIIIIlllIlIlIll.getConstPool().isConstructor(lllllllllllllIlIIIIIIIlllIllIIll.type, lllllllllllllIlIIIIIIIlllIlIllIl.u16bitAt(lllllllllllllIlIIIIIIIlllIllIIIl + 1)) > 0) {
                            lllllllllllllIlIIIIIIIlllIllIIlI = new NewExpr(lllllllllllllIlIIIIIIIlllIllIIIl, lllllllllllllIlIIIIIIIlllIlIllIl, lllllllllllllIlIIIIIIIlllIlIIlll, lllllllllllllIlIIIIIIIlllIlIlIll, lllllllllllllIlIIIIIIIlllIllIIll.type, lllllllllllllIlIIIIIIIlllIllIIll.pos);
                            this.edit((NewExpr)lllllllllllllIlIIIIIIIlllIllIIlI);
                            lllllllllllllIlIIIIIIIlllIlIlIlI.newList = lllllllllllllIlIIIIIIIlllIllIIll.next;
                        }
                        else {
                            final MethodCall lllllllllllllIlIIIIIIIlllIllIlII = new MethodCall(lllllllllllllIlIIIIIIIlllIllIIIl, lllllllllllllIlIIIIIIIlllIlIllIl, lllllllllllllIlIIIIIIIlllIlIIlll, lllllllllllllIlIIIIIIIlllIlIlIll);
                            if (lllllllllllllIlIIIIIIIlllIllIlII.getMethodName().equals("<init>")) {
                                final ConstructorCall lllllllllllllIlIIIIIIIlllIllIlIl = (ConstructorCall)(lllllllllllllIlIIIIIIIlllIllIIlI = new ConstructorCall(lllllllllllllIlIIIIIIIlllIllIIIl, lllllllllllllIlIIIIIIIlllIlIllIl, lllllllllllllIlIIIIIIIlllIlIIlll, lllllllllllllIlIIIIIIIlllIlIlIll));
                                this.edit(lllllllllllllIlIIIIIIIlllIllIlIl);
                            }
                            else {
                                lllllllllllllIlIIIIIIIlllIllIIlI = lllllllllllllIlIIIIIIIlllIllIlII;
                                this.edit(lllllllllllllIlIIIIIIIlllIllIlII);
                            }
                        }
                    }
                }
                else if (lllllllllllllIlIIIIIIIlllIllIIII == 188 || lllllllllllllIlIIIIIIIlllIllIIII == 189 || lllllllllllllIlIIIIIIIlllIllIIII == 197) {
                    lllllllllllllIlIIIIIIIlllIllIIlI = new NewArray(lllllllllllllIlIIIIIIIlllIllIIIl, lllllllllllllIlIIIIIIIlllIlIllIl, lllllllllllllIlIIIIIIIlllIlIIlll, lllllllllllllIlIIIIIIIlllIlIlIll, lllllllllllllIlIIIIIIIlllIllIIII);
                    this.edit((NewArray)lllllllllllllIlIIIIIIIlllIllIIlI);
                }
                else if (lllllllllllllIlIIIIIIIlllIllIIII == 193) {
                    lllllllllllllIlIIIIIIIlllIllIIlI = new Instanceof(lllllllllllllIlIIIIIIIlllIllIIIl, lllllllllllllIlIIIIIIIlllIlIllIl, lllllllllllllIlIIIIIIIlllIlIIlll, lllllllllllllIlIIIIIIIlllIlIlIll);
                    this.edit((Instanceof)lllllllllllllIlIIIIIIIlllIllIIlI);
                }
                else if (lllllllllllllIlIIIIIIIlllIllIIII == 192) {
                    lllllllllllllIlIIIIIIIlllIllIIlI = new Cast(lllllllllllllIlIIIIIIIlllIllIIIl, lllllllllllllIlIIIIIIIlllIlIllIl, lllllllllllllIlIIIIIIIlllIlIIlll, lllllllllllllIlIIIIIIIlllIlIlIll);
                    this.edit((Cast)lllllllllllllIlIIIIIIIlllIllIIlI);
                }
            }
            if (lllllllllllllIlIIIIIIIlllIllIIlI != null && lllllllllllllIlIIIIIIIlllIllIIlI.edited()) {
                lllllllllllllIlIIIIIIIlllIlIlIlI.updateMax(lllllllllllllIlIIIIIIIlllIllIIlI.locals(), lllllllllllllIlIIIIIIIlllIllIIlI.stack());
                return true;
            }
            return false;
        }
        catch (BadBytecode lllllllllllllIlIIIIIIIlllIlIllll) {
            throw new CannotCompileException(lllllllllllllIlIIIIIIIlllIlIllll);
        }
    }
    
    public void edit(final Cast lllllllllllllIlIIIIIIIlllIIlIIIl) throws CannotCompileException {
    }
    
    static final class NewOp
    {
        /* synthetic */ String type;
        /* synthetic */ NewOp next;
        /* synthetic */ int pos;
        
        NewOp(final NewOp llllIIlllIllll, final int llllIIllllIIlI, final String llllIIllllIIIl) {
            this.next = llllIIlllIllll;
            this.pos = llllIIllllIIlI;
            this.type = llllIIllllIIIl;
        }
    }
    
    static final class LoopContext
    {
        /* synthetic */ int maxLocals;
        /* synthetic */ int maxStack;
        /* synthetic */ NewOp newList;
        
        LoopContext(final int lllllllllllllIIIIIIlllIIIllIIIlI) {
            this.maxLocals = lllllllllllllIIIIIIlllIIIllIIIlI;
            this.maxStack = 0;
            this.newList = null;
        }
        
        void updateMax(final int lllllllllllllIIIIIIlllIIIlIllIlI, final int lllllllllllllIIIIIIlllIIIlIllIIl) {
            if (this.maxLocals < lllllllllllllIIIIIIlllIIIlIllIlI) {
                this.maxLocals = lllllllllllllIIIIIIlllIIIlIllIlI;
            }
            if (this.maxStack < lllllllllllllIIIIIIlllIIIlIllIIl) {
                this.maxStack = lllllllllllllIIIIIIlllIIIlIllIIl;
            }
        }
    }
}
