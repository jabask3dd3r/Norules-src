package javax.vecmath;

class VecMathUtil
{
    static final long hashLongBits(long llllllllllllllIIlIlllllllllIIIll, final long llllllllllllllIIlIlllllllllIIIlI) {
        llllllllllllllIIlIlllllllllIIIll *= (short)31L;
        return llllllllllllllIIlIlllllllllIIIll + llllllllllllllIIlIlllllllllIIIlI;
    }
    
    static final long hashDoubleBits(long llllllllllllllIIlIllllllllIlIlll, final double llllllllllllllIIlIllllllllIllIII) {
        llllllllllllllIIlIllllllllIlIlll *= 31L;
        if (llllllllllllllIIlIllllllllIllIII == 0.0) {
            return llllllllllllllIIlIllllllllIlIlll;
        }
        return llllllllllllllIIlIllllllllIlIlll + Double.doubleToLongBits(llllllllllllllIIlIllllllllIllIII);
    }
    
    static final long hashFloatBits(long llllllllllllllIIlIllllllllIlllIl, final float llllllllllllllIIlIllllllllIllllI) {
        llllllllllllllIIlIllllllllIlllIl *= 31L;
        if (llllllllllllllIIlIllllllllIllllI == 0.0f) {
            return llllllllllllllIIlIllllllllIlllIl;
        }
        return llllllllllllllIIlIllllllllIlllIl + Float.floatToIntBits(llllllllllllllIIlIllllllllIllllI);
    }
    
    private VecMathUtil() {
    }
    
    static final int hashFinish(final long llllllllllllllIIlIllllllllIlIIll) {
        return (int)(llllllllllllllIIlIllllllllIlIIll ^ llllllllllllllIIlIllllllllIlIIll >> 32);
    }
}
