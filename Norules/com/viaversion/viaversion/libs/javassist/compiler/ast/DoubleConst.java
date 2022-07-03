package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class DoubleConst extends ASTree
{
    protected /* synthetic */ double value;
    protected /* synthetic */ int type;
    
    public void set(final double lllllllllllllIIllllllIlllIIlIIII) {
        this.value = lllllllllllllIIllllllIlllIIlIIII;
    }
    
    @Override
    public String toString() {
        return Double.toString(this.value);
    }
    
    public double get() {
        return this.value;
    }
    
    public DoubleConst(final double lllllllllllllIIllllllIlllIIllIlI, final int lllllllllllllIIllllllIlllIIlllII) {
        this.value = lllllllllllllIIllllllIlllIIllIlI;
        this.type = lllllllllllllIIllllllIlllIIlllII;
    }
    
    @Override
    public void accept(final Visitor lllllllllllllIIllllllIlllIIIIllI) throws CompileError {
        lllllllllllllIIllllllIlllIIIIllI.atDoubleConst(this);
    }
    
    private DoubleConst compute0(final int lllllllllllllIIllllllIllIlllIIII, final DoubleConst lllllllllllllIIllllllIllIlllIIll) {
        int lllllllllllllIIllllllIllIlllIIlI = 0;
        if (this.type == 405 || lllllllllllllIIllllllIllIlllIIll.type == 405) {
            final int lllllllllllllIIllllllIllIlllIllI = 405;
        }
        else {
            lllllllllllllIIllllllIllIlllIIlI = 404;
        }
        return compute(lllllllllllllIIllllllIllIlllIIII, this.value, lllllllllllllIIllllllIllIlllIIll.value, lllllllllllllIIllllllIllIlllIIlI);
    }
    
    private DoubleConst compute0(final int lllllllllllllIIllllllIllIllIlIIl, final IntConst lllllllllllllIIllllllIllIllIIlIl) {
        return compute(lllllllllllllIIllllllIllIllIlIIl, this.value, (double)lllllllllllllIIllllllIllIllIIlIl.value, this.type);
    }
    
    public int getType() {
        return this.type;
    }
    
    private static DoubleConst compute(final int lllllllllllllIIllllllIllIlIlIlIl, final double lllllllllllllIIllllllIllIlIllIIl, final double lllllllllllllIIllllllIllIlIllIII, final int lllllllllllllIIllllllIllIlIlIIlI) {
        switch (lllllllllllllIIllllllIllIlIlIlIl) {
            case 43: {
                final double lllllllllllllIIllllllIllIlIlllll = lllllllllllllIIllllllIllIlIllIIl + lllllllllllllIIllllllIllIlIllIII;
                break;
            }
            case 45: {
                final double lllllllllllllIIllllllIllIlIllllI = lllllllllllllIIllllllIllIlIllIIl - lllllllllllllIIllllllIllIlIllIII;
                break;
            }
            case 42: {
                final double lllllllllllllIIllllllIllIlIlllIl = lllllllllllllIIllllllIllIlIllIIl * lllllllllllllIIllllllIllIlIllIII;
                break;
            }
            case 47: {
                final double lllllllllllllIIllllllIllIlIlllII = lllllllllllllIIllllllIllIlIllIIl / lllllllllllllIIllllllIllIlIllIII;
                break;
            }
            case 37: {
                final double lllllllllllllIIllllllIllIlIllIll = lllllllllllllIIllllllIllIlIllIIl % lllllllllllllIIllllllIllIlIllIII;
                break;
            }
            default: {
                return null;
            }
        }
        final double lllllllllllllIIllllllIllIlIlIllI;
        return new DoubleConst(lllllllllllllIIllllllIllIlIlIllI, lllllllllllllIIllllllIllIlIlIIlI);
    }
    
    public ASTree compute(final int lllllllllllllIIllllllIllIlllllII, final ASTree lllllllllllllIIllllllIllIllllllI) {
        if (lllllllllllllIIllllllIllIllllllI instanceof IntConst) {
            return this.compute0(lllllllllllllIIllllllIllIlllllII, (IntConst)lllllllllllllIIllllllIllIllllllI);
        }
        if (lllllllllllllIIllllllIllIllllllI instanceof DoubleConst) {
            return this.compute0(lllllllllllllIIllllllIllIlllllII, (DoubleConst)lllllllllllllIIllllllIllIllllllI);
        }
        return null;
    }
}
