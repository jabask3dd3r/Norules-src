package com.viaversion.viaversion.libs.fastutil;

public final class SafeMath
{
    public static float safeDoubleToFloat(final double llllllllllllllIIlIlIlIlIIlIIIIll) {
        if (Double.isNaN(llllllllllllllIIlIlIlIlIIlIIIIll)) {
            return Float.NaN;
        }
        if (Double.isInfinite(llllllllllllllIIlIlIlIlIIlIIIIll)) {
            return (llllllllllllllIIlIlIlIlIIlIIIIll < 0.0) ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        if (llllllllllllllIIlIlIlIlIIlIIIIll < 1.401298464324817E-45 || 3.4028234663852886E38 < llllllllllllllIIlIlIlIlIIlIIIIll) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIlIlIIlIIIIll).append(" can't be represented as float (out of range)")));
        }
        final float llllllllllllllIIlIlIlIlIIlIIIIlI = (float)llllllllllllllIIlIlIlIlIIlIIIIll;
        if (llllllllllllllIIlIlIlIlIIlIIIIlI != llllllllllllllIIlIlIlIlIIlIIIIll) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIlIlIIlIIIIll).append(" can't be represented as float (imprecise)")));
        }
        return llllllllllllllIIlIlIlIlIIlIIIIlI;
    }
    
    public static short safeIntToShort(final int llllllllllllllIIlIlIlIlIIlIIlIlI) {
        if (llllllllllllllIIlIlIlIlIIlIIlIlI < -32768 || 32767 < llllllllllllllIIlIlIlIlIIlIIlIlI) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIlIlIIlIIlIlI).append(" can't be represented as short (out of range)")));
        }
        return (short)llllllllllllllIIlIlIlIlIIlIIlIlI;
    }
    
    private SafeMath() {
    }
    
    public static int safeLongToInt(final long llllllllllllllIIlIlIlIlIIlIIIlll) {
        if (llllllllllllllIIlIlIlIlIIlIIIlll < -2147483648L || 2147483647L < llllllllllllllIIlIlIlIlIIlIIIlll) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIlIlIIlIIIlll).append(" can't be represented as int (out of range)")));
        }
        return (int)llllllllllllllIIlIlIlIlIIlIIIlll;
    }
    
    public static char safeIntToChar(final int llllllllllllllIIlIlIlIlIIlIlIIII) {
        if (llllllllllllllIIlIlIlIlIIlIlIIII < 0 || 65535 < llllllllllllllIIlIlIlIlIIlIlIIII) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIlIlIIlIlIIII).append(" can't be represented as char")));
        }
        return (char)llllllllllllllIIlIlIlIlIIlIlIIII;
    }
    
    public static byte safeIntToByte(final int llllllllllllllIIlIlIlIlIIlIIllIl) {
        if (llllllllllllllIIlIlIlIlIIlIIllIl < -128 || 127 < llllllllllllllIIlIlIlIlIIlIIllIl) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllIIlIlIlIlIIlIIllIl).append(" can't be represented as byte (out of range)")));
        }
        return (byte)llllllllllllllIIlIlIlIlIIlIIllIl;
    }
}
