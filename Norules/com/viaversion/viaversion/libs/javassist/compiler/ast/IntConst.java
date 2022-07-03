package com.viaversion.viaversion.libs.javassist.compiler.ast;

import com.viaversion.viaversion.libs.javassist.compiler.*;

public class IntConst extends ASTree
{
    protected /* synthetic */ long value;
    protected /* synthetic */ int type;
    
    public long get() {
        return this.value;
    }
    
    private IntConst compute0(final int lllllllllllllllIlIIlIIllIIIIllIl, final IntConst lllllllllllllllIlIIlIIllIIIIIIll) {
        final int lllllllllllllllIlIIlIIllIIIIlIll = this.type;
        final int lllllllllllllllIlIIlIIllIIIIlIlI = lllllllllllllllIlIIlIIllIIIIIIll.type;
        int lllllllllllllllIlIIlIIllIIIIlIIl = 0;
        if (lllllllllllllllIlIIlIIllIIIIlIll == 403 || lllllllllllllllIlIIlIIllIIIIlIlI == 403) {
            final int lllllllllllllllIlIIlIIllIIIllIll = 403;
        }
        else if (lllllllllllllllIlIIlIIllIIIIlIll == 401 && lllllllllllllllIlIIlIIllIIIIlIlI == 401) {
            final int lllllllllllllllIlIIlIIllIIIllIlI = 401;
        }
        else {
            lllllllllllllllIlIIlIIllIIIIlIIl = 402;
        }
        final long lllllllllllllllIlIIlIIllIIIIlIII = this.value;
        final long lllllllllllllllIlIIlIIllIIIIIlll = lllllllllllllllIlIIlIIllIIIIIIll.value;
        switch (lllllllllllllllIlIIlIIllIIIIllIl) {
            case 43: {
                final long lllllllllllllllIlIIlIIllIIIllIIl = lllllllllllllllIlIIlIIllIIIIlIII + lllllllllllllllIlIIlIIllIIIIIlll;
                break;
            }
            case 45: {
                final long lllllllllllllllIlIIlIIllIIIllIII = lllllllllllllllIlIIlIIllIIIIlIII - lllllllllllllllIlIIlIIllIIIIIlll;
                break;
            }
            case 42: {
                final long lllllllllllllllIlIIlIIllIIIlIlll = lllllllllllllllIlIIlIIllIIIIlIII * lllllllllllllllIlIIlIIllIIIIIlll;
                break;
            }
            case 47: {
                final long lllllllllllllllIlIIlIIllIIIlIllI = lllllllllllllllIlIIlIIllIIIIlIII / lllllllllllllllIlIIlIIllIIIIIlll;
                break;
            }
            case 37: {
                final long lllllllllllllllIlIIlIIllIIIlIlIl = lllllllllllllllIlIIlIIllIIIIlIII % lllllllllllllllIlIIlIIllIIIIIlll;
                break;
            }
            case 124: {
                final long lllllllllllllllIlIIlIIllIIIlIlII = lllllllllllllllIlIIlIIllIIIIlIII | lllllllllllllllIlIIlIIllIIIIIlll;
                break;
            }
            case 94: {
                final long lllllllllllllllIlIIlIIllIIIlIIll = lllllllllllllllIlIIlIIllIIIIlIII ^ lllllllllllllllIlIIlIIllIIIIIlll;
                break;
            }
            case 38: {
                final long lllllllllllllllIlIIlIIllIIIlIIlI = lllllllllllllllIlIIlIIllIIIIlIII & lllllllllllllllIlIIlIIllIIIIIlll;
                break;
            }
            case 364: {
                final long lllllllllllllllIlIIlIIllIIIlIIIl = this.value << (int)lllllllllllllllIlIIlIIllIIIIIlll;
                lllllllllllllllIlIIlIIllIIIIlIIl = lllllllllllllllIlIIlIIllIIIIlIll;
                break;
            }
            case 366: {
                final long lllllllllllllllIlIIlIIllIIIlIIII = this.value >> (int)lllllllllllllllIlIIlIIllIIIIIlll;
                lllllllllllllllIlIIlIIllIIIIlIIl = lllllllllllllllIlIIlIIllIIIIlIll;
                break;
            }
            case 370: {
                final long lllllllllllllllIlIIlIIllIIIIllll = this.value >>> (int)lllllllllllllllIlIIlIIllIIIIIlll;
                lllllllllllllllIlIIlIIllIIIIlIIl = lllllllllllllllIlIIlIIllIIIIlIll;
                break;
            }
            default: {
                return null;
            }
        }
        final long lllllllllllllllIlIIlIIllIIIIIllI;
        return new IntConst(lllllllllllllllIlIIlIIllIIIIIllI, lllllllllllllllIlIIlIIllIIIIlIIl);
    }
    
    private DoubleConst compute0(final int lllllllllllllllIlIIlIIlIlllIlIlI, final DoubleConst lllllllllllllllIlIIlIIlIlllIlIIl) {
        final double lllllllllllllllIlIIlIIlIlllIlllI = (double)this.value;
        final double lllllllllllllllIlIIlIIlIlllIllIl = lllllllllllllllIlIIlIIlIlllIlIIl.value;
        switch (lllllllllllllllIlIIlIIlIlllIlIlI) {
            case 43: {
                final double lllllllllllllllIlIIlIIlIllllIllI = lllllllllllllllIlIIlIIlIlllIlllI + lllllllllllllllIlIIlIIlIlllIllIl;
                break;
            }
            case 45: {
                final double lllllllllllllllIlIIlIIlIllllIlIl = lllllllllllllllIlIIlIIlIlllIlllI - lllllllllllllllIlIIlIIlIlllIllIl;
                break;
            }
            case 42: {
                final double lllllllllllllllIlIIlIIlIllllIlII = lllllllllllllllIlIIlIIlIlllIlllI * lllllllllllllllIlIIlIIlIlllIllIl;
                break;
            }
            case 47: {
                final double lllllllllllllllIlIIlIIlIllllIIll = lllllllllllllllIlIIlIIlIlllIlllI / lllllllllllllllIlIIlIIlIlllIllIl;
                break;
            }
            case 37: {
                final double lllllllllllllllIlIIlIIlIllllIIlI = lllllllllllllllIlIIlIIlIlllIlllI % lllllllllllllllIlIIlIIlIlllIllIl;
                break;
            }
            default: {
                return null;
            }
        }
        final double lllllllllllllllIlIIlIIlIlllIllII;
        return new DoubleConst(lllllllllllllllIlIIlIIlIlllIllII, lllllllllllllllIlIIlIIlIlllIlIIl.type);
    }
    
    public void set(final long lllllllllllllllIlIIlIIllIIllllII) {
        this.value = lllllllllllllllIlIIlIIllIIllllII;
    }
    
    @Override
    public String toString() {
        return Long.toString(this.value);
    }
    
    public int getType() {
        return this.type;
    }
    
    public ASTree compute(final int lllllllllllllllIlIIlIIllIIlIlIIl, final ASTree lllllllllllllllIlIIlIIllIIlIlIII) {
        if (lllllllllllllllIlIIlIIllIIlIlIII instanceof IntConst) {
            return this.compute0(lllllllllllllllIlIIlIIllIIlIlIIl, (IntConst)lllllllllllllllIlIIlIIllIIlIlIII);
        }
        if (lllllllllllllllIlIIlIIllIIlIlIII instanceof DoubleConst) {
            return this.compute0(lllllllllllllllIlIIlIIllIIlIlIIl, (DoubleConst)lllllllllllllllIlIIlIIllIIlIlIII);
        }
        return null;
    }
    
    @Override
    public void accept(final Visitor lllllllllllllllIlIIlIIllIIlIlllI) throws CompileError {
        lllllllllllllllIlIIlIIllIIlIlllI.atIntConst(this);
    }
    
    public IntConst(final long lllllllllllllllIlIIlIIllIlIIIlII, final int lllllllllllllllIlIIlIIllIlIIIllI) {
        this.value = lllllllllllllllIlIIlIIllIlIIIlII;
        this.type = lllllllllllllllIlIIlIIllIlIIIllI;
    }
}
