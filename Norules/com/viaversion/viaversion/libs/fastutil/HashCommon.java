package com.viaversion.viaversion.libs.fastutil;

public class HashCommon
{
    protected HashCommon() {
    }
    
    public static int double2int(final double llllllllllllllIllllIllIlIllllIIl) {
        final long llllllllllllllIllllIllIlIllllIlI = Double.doubleToRawLongBits(llllllllllllllIllllIllIlIllllIIl);
        return (int)(llllllllllllllIllllIllIlIllllIlI ^ llllllllllllllIllllIllIlIllllIlI >>> 32);
    }
    
    public static int long2int(final long llllllllllllllIllllIllIlIlllIlIl) {
        return (int)(llllllllllllllIllllIllIlIlllIlIl ^ llllllllllllllIllllIllIlIlllIlIl >>> 32);
    }
    
    public static int invMix(final int llllllllllllllIllllIllIllIIIlIlI) {
        return (llllllllllllllIllllIllIllIIIlIlI ^ llllllllllllllIllllIllIllIIIlIlI >>> 16) * 340573321;
    }
    
    public static long bigArraySize(final long llllllllllllllIllllIllIlIlIlIlIl, final float llllllllllllllIllllIllIlIlIlIIIl) {
        return nextPowerOfTwo((long)Math.ceil(llllllllllllllIllllIllIlIlIlIlIl / llllllllllllllIllllIllIlIlIlIIIl));
    }
    
    static {
        INV_INT_PHI = 340573321;
        INT_PHI = -1640531527;
    }
    
    public static int float2int(final float llllllllllllllIllllIllIlIlllllll) {
        return Float.floatToRawIntBits(llllllllllllllIllllIllIlIlllllll);
    }
    
    public static long maxFill(final long llllllllllllllIllllIllIlIllIIlII, final float llllllllllllllIllllIllIlIllIIlIl) {
        return Math.min((long)Math.ceil(llllllllllllllIllllIllIlIllIIlII * llllllllllllllIllllIllIlIllIIlIl), llllllllllllllIllllIllIlIllIIlII - 1L);
    }
    
    public static int arraySize(final int llllllllllllllIllllIllIlIlIlllII, final float llllllllllllllIllllIllIlIlIllIll) {
        final long llllllllllllllIllllIllIlIlIlllIl = Math.max(2L, nextPowerOfTwo((long)Math.ceil(llllllllllllllIllllIllIlIlIlllII / llllllllllllllIllllIllIlIlIllIll)));
        if (llllllllllllllIllllIllIlIlIlllIl > 1073741824L) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Too large (").append(llllllllllllllIllllIllIlIlIlllII).append(" expected elements with load factor ").append(llllllllllllllIllllIllIlIlIllIll).append(")")));
        }
        return (int)llllllllllllllIllllIllIlIlIlllIl;
    }
    
    public static int mix(final int llllllllllllllIllllIllIllIIlIIII) {
        final int llllllllllllllIllllIllIllIIIllll = llllllllllllllIllllIllIllIIlIIII * -1640531527;
        return llllllllllllllIllllIllIllIIIllll ^ llllllllllllllIllllIllIllIIIllll >>> 16;
    }
    
    public static int nextPowerOfTwo(int llllllllllllllIllllIllIlIlllIIlI) {
        if (llllllllllllllIllllIllIlIlllIIlI == 0) {
            return 1;
        }
        llllllllllllllIllllIllIlIlllIIlI = (--llllllllllllllIllllIllIlIlllIIlI | llllllllllllllIllllIllIlIlllIIlI >> 1);
        llllllllllllllIllllIllIlIlllIIlI |= llllllllllllllIllllIllIlIlllIIlI >> 2;
        llllllllllllllIllllIllIlIlllIIlI |= llllllllllllllIllllIllIlIlllIIlI >> 4;
        llllllllllllllIllllIllIlIlllIIlI |= llllllllllllllIllllIllIlIlllIIlI >> 8;
        return (llllllllllllllIllllIllIlIlllIIlI | llllllllllllllIllllIllIlIlllIIlI >> 16) + 1;
    }
    
    public static int murmurHash3(int llllllllllllllIllllIllIllIIlIllI) {
        llllllllllllllIllllIllIllIIlIllI ^= llllllllllllllIllllIllIllIIlIllI >>> 16;
        llllllllllllllIllllIllIllIIlIllI *= -2048144789;
        llllllllllllllIllllIllIllIIlIllI ^= llllllllllllllIllllIllIllIIlIllI >>> 13;
        llllllllllllllIllllIllIllIIlIllI *= -1028477387;
        llllllllllllllIllllIllIllIIlIllI ^= llllllllllllllIllllIllIllIIlIllI >>> 16;
        return (int)llllllllllllllIllllIllIllIIlIllI;
    }
    
    public static long invMix(long llllllllllllllIllllIllIllIIIIIIl) {
        llllllllllllllIllllIllIllIIIIIIl ^= (Exception)(llllllllllllllIllllIllIllIIIIIIl >>> 32);
        llllllllllllllIllllIllIllIIIIIIl ^= (Exception)(llllllllllllllIllllIllIllIIIIIIl >>> 16);
        return (long)((llllllllllllllIllllIllIllIIIIIIl ^ llllllllllllllIllllIllIllIIIIIIl >>> 32) * -1018231460777725123L);
    }
    
    public static long murmurHash3(long llllllllllllllIllllIllIllIIlIIll) {
        llllllllllllllIllllIllIllIIlIIll ^= llllllllllllllIllllIllIllIIlIIll >>> 33;
        llllllllllllllIllllIllIllIIlIIll *= -49064778989728563L;
        llllllllllllllIllllIllIllIIlIIll ^= llllllllllllllIllllIllIllIIlIIll >>> 33;
        llllllllllllllIllllIllIllIIlIIll *= -4265267296055464877L;
        llllllllllllllIllllIllIllIIlIIll ^= llllllllllllllIllllIllIllIIlIIll >>> 33;
        return llllllllllllllIllllIllIllIIlIIll;
    }
    
    public static long nextPowerOfTwo(long llllllllllllllIllllIllIlIllIllll) {
        if (llllllllllllllIllllIllIlIllIllll == 0L) {
            return 1L;
        }
        --llllllllllllllIllllIllIlIllIllll;
        llllllllllllllIllllIllIlIllIllll |= llllllllllllllIllllIllIlIllIllll >> 1;
        llllllllllllllIllllIllIlIllIllll |= llllllllllllllIllllIllIlIllIllll >> 2;
        llllllllllllllIllllIllIlIllIllll |= llllllllllllllIllllIllIlIllIllll >> 4;
        llllllllllllllIllllIllIlIllIllll |= llllllllllllllIllllIllIlIllIllll >> 8;
        llllllllllllllIllllIllIlIllIllll |= llllllllllllllIllllIllIlIllIllll >> 16;
        return (llllllllllllllIllllIllIlIllIllll | llllllllllllllIllllIllIlIllIllll >> 32) + 1L;
    }
    
    public static int maxFill(final int llllllllllllllIllllIllIlIllIlIlI, final float llllllllllllllIllllIllIlIllIlIll) {
        return Math.min((int)Math.ceil(llllllllllllllIllllIllIlIllIlIlI * llllllllllllllIllllIllIlIllIlIll), llllllllllllllIllllIllIlIllIlIlI - 1);
    }
    
    public static long mix(final long llllllllllllllIllllIllIllIIIIlll) {
        long llllllllllllllIllllIllIllIIIIllI = llllllllllllllIllllIllIllIIIIlll * -7046029254386353131L;
        llllllllllllllIllllIllIllIIIIllI ^= llllllllllllllIllllIllIllIIIIllI >>> 32;
        return llllllllllllllIllllIllIllIIIIllI ^ llllllllllllllIllllIllIllIIIIllI >>> 16;
    }
}
