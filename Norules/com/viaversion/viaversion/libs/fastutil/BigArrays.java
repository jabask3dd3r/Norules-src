package com.viaversion.viaversion.libs.fastutil;

import com.viaversion.viaversion.libs.fastutil.bytes.*;
import com.viaversion.viaversion.libs.fastutil.chars.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import com.viaversion.viaversion.libs.fastutil.doubles.*;
import com.viaversion.viaversion.libs.fastutil.longs.*;
import com.viaversion.viaversion.libs.fastutil.shorts.*;
import com.viaversion.viaversion.libs.fastutil.floats.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.fastutil.booleans.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class BigArrays
{
    public static void ensureOffsetLength(final boolean[][] llllllllllllllIllIlIIlIlIIllIlIl, final long llllllllllllllIllIlIIlIlIIllIlII, final long llllllllllllllIllIlIIlIlIIllIIll) {
        ensureOffsetLength(length(llllllllllllllIllIlIIlIlIIllIlIl), llllllllllllllIllIlIIlIlIIllIlII, llllllllllllllIllIlIIlIlIIllIIll);
    }
    
    public static void swap(final short[][] llllllllllllllIllIlIIlIIllllIIlI, final long llllllllllllllIllIlIIlIIlllIllIl, final long llllllllllllllIllIlIIlIIllllIIII) {
        final short llllllllllllllIllIlIIlIIlllIllll = llllllllllllllIllIlIIlIIllllIIlI[segment(llllllllllllllIllIlIIlIIlllIllIl)][displacement(llllllllllllllIllIlIIlIIlllIllIl)];
        llllllllllllllIllIlIIlIIllllIIlI[segment(llllllllllllllIllIlIIlIIlllIllIl)][displacement(llllllllllllllIllIlIIlIIlllIllIl)] = llllllllllllllIllIlIIlIIllllIIlI[segment(llllllllllllllIllIlIIlIIllllIIII)][displacement(llllllllllllllIllIlIIlIIllllIIII)];
        llllllllllllllIllIlIIlIIllllIIlI[segment(llllllllllllllIllIlIIlIIllllIIII)][displacement(llllllllllllllIllIlIIlIIllllIIII)] = llllllllllllllIllIlIIlIIlllIllll;
    }
    
    public static void swap(final byte[][] llllllllllllllIllIlIllIIllIlIlII, final long llllllllllllllIllIlIllIIllIlIlll, final long llllllllllllllIllIlIllIIllIlIllI) {
        final byte llllllllllllllIllIlIllIIllIlIlIl = llllllllllllllIllIlIllIIllIlIlII[segment(llllllllllllllIllIlIllIIllIlIlll)][displacement(llllllllllllllIllIlIllIIllIlIlll)];
        llllllllllllllIllIlIllIIllIlIlII[segment(llllllllllllllIllIlIllIIllIlIlll)][displacement(llllllllllllllIllIlIllIIllIlIlll)] = llllllllllllllIllIlIllIIllIlIlII[segment(llllllllllllllIllIlIllIIllIlIllI)][displacement(llllllllllllllIllIlIllIIllIlIllI)];
        llllllllllllllIllIlIllIIllIlIlII[segment(llllllllllllllIllIlIllIIllIlIllI)][displacement(llllllllllllllIllIlIllIIllIlIllI)] = llllllllllllllIllIlIllIIllIlIlIl;
    }
    
    public static int[][] copy(final int[][] llllllllllllllIllIlIlIlIIIIlIlll) {
        final int[][] llllllllllllllIllIlIlIlIIIIlIllI = llllllllllllllIllIlIlIlIIIIlIlll.clone();
        int llllllllllllllIllIlIlIlIIIIllIII = llllllllllllllIllIlIlIlIIIIlIllI.length;
        while (llllllllllllllIllIlIlIlIIIIllIII-- != 0) {
            llllllllllllllIllIlIlIlIIIIlIllI[llllllllllllllIllIlIlIlIIIIllIII] = llllllllllllllIllIlIlIlIIIIlIlll[llllllllllllllIllIlIlIlIIIIllIII].clone();
        }
        return llllllllllllllIllIlIlIlIIIIlIllI;
    }
    
    public static boolean equals(final long[][] llllllllllllllIllIlIlIIIIlIlIIll, final long[][] llllllllllllllIllIlIlIIIIlIlIIlI) {
        if (length(llllllllllllllIllIlIlIIIIlIlIIll) != length(llllllllllllllIllIlIlIIIIlIlIIlI)) {
            return false;
        }
        int llllllllllllllIllIlIlIIIIlIlIlII = llllllllllllllIllIlIlIIIIlIlIIll.length;
        while (llllllllllllllIllIlIlIIIIlIlIlII-- != 0) {
            final long[] llllllllllllllIllIlIlIIIIlIllIII = llllllllllllllIllIlIlIIIIlIlIIll[llllllllllllllIllIlIlIIIIlIlIlII];
            final long[] llllllllllllllIllIlIlIIIIlIlIlll = llllllllllllllIllIlIlIIIIlIlIIlI[llllllllllllllIllIlIlIIIIlIlIlII];
            int llllllllllllllIllIlIlIIIIlIllIIl = llllllllllllllIllIlIlIIIIlIllIII.length;
            while (llllllllllllllIllIlIlIIIIlIllIIl-- != 0) {
                if (llllllllllllllIllIlIlIIIIlIllIII[llllllllllllllIllIlIlIIIIlIllIIl] != llllllllllllllIllIlIlIIIIlIlIlll[llllllllllllllIllIlIlIIIIlIllIIl]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void fill(final double[][] llllllllllllllIllIlIIllIllllIIII, final double llllllllllllllIllIlIIllIlllIllIl) {
        int llllllllllllllIllIlIIllIllllIIIl = llllllllllllllIllIlIIllIllllIIII.length;
        while (llllllllllllllIllIlIIllIllllIIIl-- != 0) {
            Arrays.fill(llllllllllllllIllIlIIllIllllIIII[llllllllllllllIllIlIIllIllllIIIl], llllllllllllllIllIlIIllIlllIllIl);
        }
    }
    
    public static void decr(final byte[][] llllllllllllllIllIlIllIIlIlIlIll, final long llllllllllllllIllIlIllIIlIlIllII) {
        final byte[] array = llllllllllllllIllIlIllIIlIlIlIll[segment(llllllllllllllIllIlIllIIlIlIllII)];
        final int displacement = displacement(llllllllllllllIllIlIllIIlIlIllII);
        --array[displacement];
    }
    
    public static short[][] shuffle(final short[][] llllllllllllllIllIlIIIlllIIIllII, final long llllllllllllllIllIlIIIlllIIIlIll, final long llllllllllllllIllIlIIIlllIIIlllI, final Random llllllllllllllIllIlIIIlllIIIllIl) {
        long llllllllllllllIllIlIIIlllIIlIIIl = llllllllllllllIllIlIIIlllIIIlllI - llllllllllllllIllIlIIIlllIIIlIll;
        while (llllllllllllllIllIlIIIlllIIlIIIl-- != 0L) {
            final long llllllllllllllIllIlIIIlllIIlIIll = (llllllllllllllIllIlIIIlllIIIllIl.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIIlllIIlIIIl + 1L);
            final short llllllllllllllIllIlIIIlllIIlIIlI = get(llllllllllllllIllIlIIIlllIIIllII, llllllllllllllIllIlIIIlllIIIlIll + llllllllllllllIllIlIIIlllIIlIIIl);
            set(llllllllllllllIllIlIIIlllIIIllII, llllllllllllllIllIlIIIlllIIIlIll + llllllllllllllIllIlIIIlllIIlIIIl, get(llllllllllllllIllIlIIIlllIIIllII, llllllllllllllIllIlIIIlllIIIlIll + llllllllllllllIllIlIIIlllIIlIIll));
            set(llllllllllllllIllIlIIIlllIIIllII, llllllllllllllIllIlIIIlllIIIlIll + llllllllllllllIllIlIIIlllIIlIIll, llllllllllllllIllIlIIIlllIIlIIlI);
        }
        return llllllllllllllIllIlIIIlllIIIllII;
    }
    
    public static byte[][] trim(final byte[][] llllllllllllllIllIlIlIlllllllllI, final long llllllllllllllIllIlIllIIIIIIIIll) {
        ensureLength(llllllllllllllIllIlIllIIIIIIIIll);
        final long llllllllllllllIllIlIllIIIIIIIIlI = length(llllllllllllllIllIlIlIlllllllllI);
        if (llllllllllllllIllIlIllIIIIIIIIll >= llllllllllllllIllIlIllIIIIIIIIlI) {
            return llllllllllllllIllIlIlIlllllllllI;
        }
        final int llllllllllllllIllIlIllIIIIIIIIIl = (int)(llllllllllllllIllIlIllIIIIIIIIll + 134217727L >>> 27);
        final byte[][] llllllllllllllIllIlIllIIIIIIIIII = Arrays.copyOf(llllllllllllllIllIlIlIlllllllllI, llllllllllllllIllIlIllIIIIIIIIIl);
        final int llllllllllllllIllIlIlIllllllllll = (int)(llllllllllllllIllIlIllIIIIIIIIll & 0x7FFFFFFL);
        if (llllllllllllllIllIlIlIllllllllll != 0) {
            llllllllllllllIllIlIllIIIIIIIIII[llllllllllllllIllIlIllIIIIIIIIIl - 1] = ByteArrays.trim(llllllllllllllIllIlIllIIIIIIIIII[llllllllllllllIllIlIllIIIIIIIIIl - 1], llllllllllllllIllIlIlIllllllllll);
        }
        return llllllllllllllIllIlIllIIIIIIIIII;
    }
    
    public static void ensureOffsetLength(final long llllllllllllllIllIlIllIllIllIlIl, final long llllllllllllllIllIlIllIllIllIlll, final long llllllllllllllIllIlIllIllIllIIll) {
        if (llllllllllllllIllIlIllIllIllIlll < 0L) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Offset (").append(llllllllllllllIllIlIllIllIllIlll).append(") is negative")));
        }
        if (llllllllllllllIllIlIllIllIllIIll < 0L) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Length (").append(llllllllllllllIllIlIllIllIllIIll).append(") is negative")));
        }
        if (llllllllllllllIllIlIllIllIllIlll + llllllllllllllIllIlIllIllIllIIll > llllllllllllllIllIlIllIllIllIlIl) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Last index (").append(llllllllllllllIllIlIllIllIllIlll + llllllllllllllIllIlIllIllIllIIll).append(") is greater than big-array length (").append(llllllllllllllIllIlIllIllIllIlIl).append(")")));
        }
    }
    
    public static String toString(final float[][] llllllllllllllIllIlIIIIIlIIllIII) {
        if (llllllllllllllIllIlIIIIIlIIllIII == null) {
            return "null";
        }
        final long llllllllllllllIllIlIIIIIlIIllIlI = length(llllllllllllllIllIlIIIIIlIIllIII) - 1L;
        if (llllllllllllllIllIlIIIIIlIIllIlI == -1L) {
            return "[]";
        }
        final StringBuilder llllllllllllllIllIlIIIIIlIIllIIl = new StringBuilder();
        llllllllllllllIllIlIIIIIlIIllIIl.append('[');
        long llllllllllllllIllIlIIIIIlIIlllII = 0L;
        while (true) {
            llllllllllllllIllIlIIIIIlIIllIIl.append(String.valueOf(get(llllllllllllllIllIlIIIIIlIIllIII, llllllllllllllIllIlIIIIIlIIlllII)));
            if (llllllllllllllIllIlIIIIIlIIlllII == llllllllllllllIllIlIIIIIlIIllIlI) {
                break;
            }
            llllllllllllllIllIlIIIIIlIIllIIl.append(", ");
            ++llllllllllllllIllIlIIIIIlIIlllII;
        }
        return String.valueOf(llllllllllllllIllIlIIIIIlIIllIIl.append(']'));
    }
    
    public static void copyToBig(final char[] llllllllllllllIllIlIIIlIlllIIIll, int llllllllllllllIllIlIIIlIlllIIIlI, final char[][] llllllllllllllIllIlIIIlIlllIlIII, final long llllllllllllllIllIlIIIlIlllIIlll, long llllllllllllllIllIlIIIlIllIlllll) {
        int llllllllllllllIllIlIIIlIlllIIlIl = segment(llllllllllllllIllIlIIIlIlllIIlll);
        int llllllllllllllIllIlIIIlIlllIIlII = displacement(llllllllllllllIllIlIIIlIlllIIlll);
        while (llllllllllllllIllIlIIIlIllIlllll > 0L) {
            final int llllllllllllllIllIlIIIlIlllIlIll = (int)Math.min(llllllllllllllIllIlIIIlIlllIlIII[llllllllllllllIllIlIIIlIlllIIlIl].length - llllllllllllllIllIlIIIlIlllIIlII, llllllllllllllIllIlIIIlIllIlllll);
            if (llllllllllllllIllIlIIIlIlllIlIll == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIIlIlllIIIll, (int)llllllllllllllIllIlIIIlIlllIIIlI, llllllllllllllIllIlIIIlIlllIlIII[llllllllllllllIllIlIIIlIlllIIlIl], llllllllllllllIllIlIIIlIlllIIlII, llllllllllllllIllIlIIIlIlllIlIll);
            if ((llllllllllllllIllIlIIIlIlllIIlII += llllllllllllllIllIlIIIlIlllIlIll) == 134217728) {
                llllllllllllllIllIlIIIlIlllIIlII = 0;
                ++llllllllllllllIllIlIIIlIlllIIlIl;
            }
            llllllllllllllIllIlIIIlIlllIIIlI += llllllllllllllIllIlIIIlIlllIlIll;
            llllllllllllllIllIlIIIlIllIlllll -= llllllllllllllIllIlIIIlIlllIlIll;
        }
    }
    
    public static void ensureFromTo(final short[][] llllllllllllllIllIlIIIlllIlIllll, final long llllllllllllllIllIlIIIlllIlIlllI, final long llllllllllllllIllIlIIIlllIlIlIlI) {
        ensureFromTo(length(llllllllllllllIllIlIIIlllIlIllll), llllllllllllllIllIlIIIlllIlIlllI, llllllllllllllIllIlIIIlllIlIlIlI);
    }
    
    public static void copy(final byte[][] llllllllllllllIllIlIllIIlIIIllll, final long llllllllllllllIllIlIllIIlIIIlllI, final byte[][] llllllllllllllIllIlIllIIlIIIllIl, final long llllllllllllllIllIlIllIIlIIIllII, long llllllllllllllIllIlIllIIlIIIIllI) {
        if (llllllllllllllIllIlIllIIlIIIllII <= llllllllllllllIllIlIllIIlIIIlllI) {
            int llllllllllllllIllIlIllIIlIIllIIl = segment(llllllllllllllIllIlIllIIlIIIlllI);
            int llllllllllllllIllIlIllIIlIIllIII = segment(llllllllllllllIllIlIllIIlIIIllII);
            int llllllllllllllIllIlIllIIlIIlIlll = displacement(llllllllllllllIllIlIllIIlIIIlllI);
            int llllllllllllllIllIlIllIIlIIlIllI = displacement(llllllllllllllIllIlIllIIlIIIllII);
            while (llllllllllllllIllIlIllIIlIIIIllI > 0L) {
                final int llllllllllllllIllIlIllIIlIIlIlIl = (int)Math.min(llllllllllllllIllIlIllIIlIIIIllI, Math.min(llllllllllllllIllIlIllIIlIIIllll[llllllllllllllIllIlIllIIlIIllIIl].length - llllllllllllllIllIlIllIIlIIlIlll, llllllllllllllIllIlIllIIlIIIllIl[llllllllllllllIllIlIllIIlIIllIII].length - llllllllllllllIllIlIllIIlIIlIllI));
                if (llllllllllllllIllIlIllIIlIIlIlIl == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIllIIlIIIllll[llllllllllllllIllIlIllIIlIIllIIl], llllllllllllllIllIlIllIIlIIlIlll, llllllllllllllIllIlIllIIlIIIllIl[llllllllllllllIllIlIllIIlIIllIII], llllllllllllllIllIlIllIIlIIlIllI, llllllllllllllIllIlIllIIlIIlIlIl);
                if ((llllllllllllllIllIlIllIIlIIlIlll += llllllllllllllIllIlIllIIlIIlIlIl) == 134217728) {
                    llllllllllllllIllIlIllIIlIIlIlll = 0;
                    ++llllllllllllllIllIlIllIIlIIllIIl;
                }
                if ((llllllllllllllIllIlIllIIlIIlIllI += llllllllllllllIllIlIllIIlIIlIlIl) == 134217728) {
                    llllllllllllllIllIlIllIIlIIlIllI = 0;
                    ++llllllllllllllIllIlIllIIlIIllIII;
                }
                llllllllllllllIllIlIllIIlIIIIllI -= llllllllllllllIllIlIllIIlIIlIlIl;
            }
        }
        else {
            int llllllllllllllIllIlIllIIlIIlIlII = segment(llllllllllllllIllIlIllIIlIIIlllI + llllllllllllllIllIlIllIIlIIIIllI);
            int llllllllllllllIllIlIllIIlIIlIIll = segment(llllllllllllllIllIlIllIIlIIIllII + llllllllllllllIllIlIllIIlIIIIllI);
            int llllllllllllllIllIlIllIIlIIlIIlI = displacement(llllllllllllllIllIlIllIIlIIIlllI + llllllllllllllIllIlIllIIlIIIIllI);
            int llllllllllllllIllIlIllIIlIIlIIIl = displacement(llllllllllllllIllIlIllIIlIIIllII + llllllllllllllIllIlIllIIlIIIIllI);
            while (llllllllllllllIllIlIllIIlIIIIllI > 0L) {
                if (llllllllllllllIllIlIllIIlIIlIIlI == 0) {
                    llllllllllllllIllIlIllIIlIIlIIlI = 134217728;
                    --llllllllllllllIllIlIllIIlIIlIlII;
                }
                if (llllllllllllllIllIlIllIIlIIlIIIl == 0) {
                    llllllllllllllIllIlIllIIlIIlIIIl = 134217728;
                    --llllllllllllllIllIlIllIIlIIlIIll;
                }
                final int llllllllllllllIllIlIllIIlIIlIIII = (int)Math.min(llllllllllllllIllIlIllIIlIIIIllI, Math.min(llllllllllllllIllIlIllIIlIIlIIlI, llllllllllllllIllIlIllIIlIIlIIIl));
                if (llllllllllllllIllIlIllIIlIIlIIII == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIllIIlIIIllll[llllllllllllllIllIlIllIIlIIlIlII], llllllllllllllIllIlIllIIlIIlIIlI - llllllllllllllIllIlIllIIlIIlIIII, llllllllllllllIllIlIllIIlIIIllIl[llllllllllllllIllIlIllIIlIIlIIll], llllllllllllllIllIlIllIIlIIlIIIl - llllllllllllllIllIlIllIIlIIlIIII, llllllllllllllIllIlIllIIlIIlIIII);
                llllllllllllllIllIlIllIIlIIlIIlI -= llllllllllllllIllIlIllIIlIIlIIII;
                llllllllllllllIllIlIllIIlIIlIIIl -= llllllllllllllIllIlIllIIlIIlIIII;
                llllllllllllllIllIlIllIIlIIIIllI -= llllllllllllllIllIlIllIIlIIlIIII;
            }
        }
    }
    
    public static char[][] setLength(final char[][] llllllllllllllIllIlIIIlIlIIIIIII, final long llllllllllllllIllIlIIIlIIlllllII) {
        final long llllllllllllllIllIlIIIlIIllllllI = length(llllllllllllllIllIlIIIlIlIIIIIII);
        if (llllllllllllllIllIlIIIlIIlllllII == llllllllllllllIllIlIIIlIIllllllI) {
            return llllllllllllllIllIlIIIlIlIIIIIII;
        }
        if (llllllllllllllIllIlIIIlIIlllllII < llllllllllllllIllIlIIIlIIllllllI) {
            return trim(llllllllllllllIllIlIIIlIlIIIIIII, llllllllllllllIllIlIIIlIIlllllII);
        }
        return ensureCapacity(llllllllllllllIllIlIIIlIlIIIIIII, llllllllllllllIllIlIIIlIIlllllII);
    }
    
    public static boolean[][] setLength(final boolean[][] llllllllllllllIllIlIIlIllIIllllI, final long llllllllllllllIllIlIIlIllIIllIlI) {
        final long llllllllllllllIllIlIIlIllIIlllII = length(llllllllllllllIllIlIIlIllIIllllI);
        if (llllllllllllllIllIlIIlIllIIllIlI == llllllllllllllIllIlIIlIllIIlllII) {
            return llllllllllllllIllIlIIlIllIIllllI;
        }
        if (llllllllllllllIllIlIIlIllIIllIlI < llllllllllllllIllIlIIlIllIIlllII) {
            return trim(llllllllllllllIllIlIIlIllIIllllI, llllllllllllllIllIlIIlIllIIllIlI);
        }
        return ensureCapacity(llllllllllllllIllIlIIlIllIIllllI, llllllllllllllIllIlIIlIllIIllIlI);
    }
    
    public static long[][] copy(final long[][] llllllllllllllIllIlIlIIIlIIlIIII, final long llllllllllllllIllIlIlIIIlIIIllll, final long llllllllllllllIllIlIlIIIlIIlIIlI) {
        ensureOffsetLength(llllllllllllllIllIlIlIIIlIIlIIII, llllllllllllllIllIlIlIIIlIIIllll, llllllllllllllIllIlIlIIIlIIlIIlI);
        final long[][] llllllllllllllIllIlIlIIIlIIlIIIl = LongBigArrays.newBigArray(llllllllllllllIllIlIlIIIlIIlIIlI);
        copy(llllllllllllllIllIlIlIIIlIIlIIII, llllllllllllllIllIlIlIIIlIIIllll, llllllllllllllIllIlIlIIIlIIlIIIl, 0L, llllllllllllllIllIlIlIIIlIIlIIlI);
        return llllllllllllllIllIlIlIIIlIIlIIIl;
    }
    
    public static void copyFromBig(final char[][] llllllllllllllIllIlIIIllIIIIIIlI, final long llllllllllllllIllIlIIIlIlllllIlI, final char[] llllllllllllllIllIlIIIllIIIIIIII, int llllllllllllllIllIlIIIlIlllllIII, int llllllllllllllIllIlIIIlIllllIlll) {
        int llllllllllllllIllIlIIIlIllllllIl = segment(llllllllllllllIllIlIIIlIlllllIlI);
        int llllllllllllllIllIlIIIlIllllllII = displacement(llllllllllllllIllIlIIIlIlllllIlI);
        while (llllllllllllllIllIlIIIlIllllIlll > 0) {
            final int llllllllllllllIllIlIIIllIIIIIIll = Math.min(llllllllllllllIllIlIIIllIIIIIIlI[llllllllllllllIllIlIIIlIllllllIl].length - llllllllllllllIllIlIIIlIllllllII, llllllllllllllIllIlIIIlIllllIlll);
            if (llllllllllllllIllIlIIIllIIIIIIll == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIIllIIIIIIlI[llllllllllllllIllIlIIIlIllllllIl], llllllllllllllIllIlIIIlIllllllII, llllllllllllllIllIlIIIllIIIIIIII, (int)llllllllllllllIllIlIIIlIlllllIII, llllllllllllllIllIlIIIllIIIIIIll);
            if ((llllllllllllllIllIlIIIlIllllllII += llllllllllllllIllIlIIIllIIIIIIll) == 134217728) {
                llllllllllllllIllIlIIIlIllllllII = 0;
                ++llllllllllllllIllIlIIIlIllllllIl;
            }
            llllllllllllllIllIlIIIlIlllllIII += llllllllllllllIllIlIIIllIIIIIIll;
            llllllllllllllIllIlIIIlIllllIlll -= llllllllllllllIllIlIIIllIIIIIIll;
        }
    }
    
    public static long[][] ensureCapacity(final long[][] llllllllllllllIllIlIlIIIlllIlllI, final long llllllllllllllIllIlIlIIIlllIlIll) {
        return ensureCapacity(llllllllllllllIllIlIlIIIlllIlllI, llllllllllllllIllIlIlIIIlllIlIll, length(llllllllllllllIllIlIlIIIlllIlllI));
    }
    
    public static boolean[][] grow(final boolean[][] llllllllllllllIllIlIIlIllIlllIll, final long llllllllllllllIllIlIIlIllIllIllI, final long llllllllllllllIllIlIIlIllIlllIIl) {
        final long llllllllllllllIllIlIIlIllIlllIII = length(llllllllllllllIllIlIIlIllIlllIll);
        return (llllllllllllllIllIlIIlIllIllIllI > llllllllllllllIllIlIIlIllIlllIII) ? ensureCapacity(llllllllllllllIllIlIIlIllIlllIll, Math.max(llllllllllllllIllIlIIlIllIlllIII + (llllllllllllllIllIlIIlIllIlllIII >> 1), llllllllllllllIllIlIIlIllIllIllI), llllllllllllllIllIlIIlIllIlllIIl) : llllllllllllllIllIlIIlIllIlllIll;
    }
    
    public static long[][] shuffle(final long[][] llllllllllllllIllIlIlIIIIIIIllII, final Random llllllllllllllIllIlIlIIIIIIIlIll) {
        long llllllllllllllIllIlIlIIIIIIIllIl = length(llllllllllllllIllIlIlIIIIIIIllII);
        while (llllllllllllllIllIlIlIIIIIIIllIl-- != 0L) {
            final long llllllllllllllIllIlIlIIIIIIIllll = (llllllllllllllIllIlIlIIIIIIIlIll.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIlIIIIIIIllIl + 1L);
            final long llllllllllllllIllIlIlIIIIIIIlllI = get(llllllllllllllIllIlIlIIIIIIIllII, llllllllllllllIllIlIlIIIIIIIllIl);
            set(llllllllllllllIllIlIlIIIIIIIllII, llllllllllllllIllIlIlIIIIIIIllIl, get(llllllllllllllIllIlIlIIIIIIIllII, llllllllllllllIllIlIlIIIIIIIllll));
            set(llllllllllllllIllIlIlIIIIIIIllII, llllllllllllllIllIlIlIIIIIIIllll, llllllllllllllIllIlIlIIIIIIIlllI);
        }
        return llllllllllllllIllIlIlIIIIIIIllII;
    }
    
    public static boolean[][] ensureCapacity(final boolean[][] llllllllllllllIllIlIIlIllllIllII, final long llllllllllllllIllIlIIlIllllIllIl) {
        return ensureCapacity(llllllllllllllIllIlIIlIllllIllII, llllllllllllllIllIlIIlIllllIllIl, length(llllllllllllllIllIlIIlIllllIllII));
    }
    
    public static short[][] grow(final short[][] llllllllllllllIllIlIIlIIIIlIllII, final long llllllllllllllIllIlIIlIIIIlIIlll, final long llllllllllllllIllIlIIlIIIIlIlIlI) {
        final long llllllllllllllIllIlIIlIIIIlIlIIl = length(llllllllllllllIllIlIIlIIIIlIllII);
        return (llllllllllllllIllIlIIlIIIIlIIlll > llllllllllllllIllIlIIlIIIIlIlIIl) ? ensureCapacity(llllllllllllllIllIlIIlIIIIlIllII, Math.max(llllllllllllllIllIlIIlIIIIlIlIIl + (llllllllllllllIllIlIIlIIIIlIlIIl >> 1), llllllllllllllIllIlIIlIIIIlIIlll), llllllllllllllIllIlIIlIIIIlIlIlI) : llllllllllllllIllIlIIlIIIIlIllII;
    }
    
    public static void swap(final double[][] llllllllllllllIllIlIIlllllllIIlI, final long llllllllllllllIllIlIIllllllIllIl, final long llllllllllllllIllIlIIllllllIllII) {
        final double llllllllllllllIllIlIIllllllIllll = llllllllllllllIllIlIIlllllllIIlI[segment(llllllllllllllIllIlIIllllllIllIl)][displacement(llllllllllllllIllIlIIllllllIllIl)];
        llllllllllllllIllIlIIlllllllIIlI[segment(llllllllllllllIllIlIIllllllIllIl)][displacement(llllllllllllllIllIlIIllllllIllIl)] = llllllllllllllIllIlIIlllllllIIlI[segment(llllllllllllllIllIlIIllllllIllII)][displacement(llllllllllllllIllIlIIllllllIllII)];
        llllllllllllllIllIlIIlllllllIIlI[segment(llllllllllllllIllIlIIllllllIllII)][displacement(llllllllllllllIllIlIIllllllIllII)] = llllllllllllllIllIlIIllllllIllll;
    }
    
    public static <K> K[][] copy(final K[][] llllllllllllllIllIIlllllIlllIIlI, final long llllllllllllllIllIIlllllIllIllIl, final long llllllllllllllIllIIlllllIllIllII) {
        ensureOffsetLength(llllllllllllllIllIIlllllIlllIIlI, llllllllllllllIllIIlllllIllIllIl, llllllllllllllIllIIlllllIllIllII);
        final K[][] llllllllllllllIllIIlllllIllIllll = (K[][])ObjectBigArrays.newBigArray((Object[][])llllllllllllllIllIIlllllIlllIIlI, llllllllllllllIllIIlllllIllIllII);
        copy(llllllllllllllIllIIlllllIlllIIlI, llllllllllllllIllIIlllllIllIllIl, llllllllllllllIllIIlllllIllIllll, 0L, llllllllllllllIllIIlllllIllIllII);
        return llllllllllllllIllIIlllllIllIllll;
    }
    
    public static <K> K[][] grow(final K[][] llllllllllllllIllIIllllllIIlIlIl, final long llllllllllllllIllIIllllllIIlIlII, final long llllllllllllllIllIIllllllIIlIIll) {
        final long llllllllllllllIllIIllllllIIlIllI = length(llllllllllllllIllIIllllllIIlIlIl);
        return (K[][])((llllllllllllllIllIIllllllIIlIlII > llllllllllllllIllIIllllllIIlIllI) ? ensureCapacity((Object[][])llllllllllllllIllIIllllllIIlIlIl, Math.max(llllllllllllllIllIIllllllIIlIllI + (llllllllllllllIllIIllllllIIlIllI >> 1), llllllllllllllIllIIllllllIIlIlII), llllllllllllllIllIIllllllIIlIIll) : llllllllllllllIllIIllllllIIlIlIl);
    }
    
    public static void fill(final byte[][] llllllllllllllIllIlIlIllllIIlIII, final long llllllllllllllIllIlIlIllllIIIlll, final long llllllllllllllIllIlIlIllllIIIllI, final byte llllllllllllllIllIlIlIlllIllllII) {
        final long llllllllllllllIllIlIlIllllIIIlII = length(llllllllllllllIllIlIlIllllIIlIII);
        ensureFromTo(llllllllllllllIllIlIlIllllIIIlII, llllllllllllllIllIlIlIllllIIIlll, llllllllllllllIllIlIlIllllIIIllI);
        if (llllllllllllllIllIlIlIllllIIIlII == 0L) {
            return;
        }
        final int llllllllllllllIllIlIlIllllIIIIll = segment(llllllllllllllIllIlIlIllllIIIlll);
        int llllllllllllllIllIlIlIllllIIIIlI = segment(llllllllllllllIllIlIlIllllIIIllI);
        final int llllllllllllllIllIlIlIllllIIIIIl = displacement(llllllllllllllIllIlIlIllllIIIlll);
        final int llllllllllllllIllIlIlIllllIIIIII = displacement(llllllllllllllIllIlIlIllllIIIllI);
        if (llllllllllllllIllIlIlIllllIIIIll == llllllllllllllIllIlIlIllllIIIIlI) {
            Arrays.fill(llllllllllllllIllIlIlIllllIIlIII[llllllllllllllIllIlIlIllllIIIIll], llllllllllllllIllIlIlIllllIIIIIl, llllllllllllllIllIlIlIllllIIIIII, llllllllllllllIllIlIlIlllIllllII);
            return;
        }
        if (llllllllllllllIllIlIlIllllIIIIII != 0) {
            Arrays.fill(llllllllllllllIllIlIlIllllIIlIII[llllllllllllllIllIlIlIllllIIIIlI], 0, llllllllllllllIllIlIlIllllIIIIII, llllllllllllllIllIlIlIlllIllllII);
        }
        while (--llllllllllllllIllIlIlIllllIIIIlI > llllllllllllllIllIlIlIllllIIIIll) {
            Arrays.fill(llllllllllllllIllIlIlIllllIIlIII[llllllllllllllIllIlIlIllllIIIIlI], llllllllllllllIllIlIlIlllIllllII);
        }
        Arrays.fill(llllllllllllllIllIlIlIllllIIlIII[llllllllllllllIllIlIlIllllIIIIll], llllllllllllllIllIlIlIllllIIIIIl, 134217728, llllllllllllllIllIlIlIlllIllllII);
    }
    
    public static byte[][] wrap(final byte[] llllllllllllllIllIlIllIIIlIIlIlI) {
        if (llllllllllllllIllIlIllIIIlIIlIlI.length == 0) {
            return ByteBigArrays.EMPTY_BIG_ARRAY;
        }
        if (llllllllllllllIllIlIllIIIlIIlIlI.length <= 134217728) {
            return new byte[][] { llllllllllllllIllIlIllIIIlIIlIlI };
        }
        final byte[][] llllllllllllllIllIlIllIIIlIIlIll = ByteBigArrays.newBigArray((long)llllllllllllllIllIlIllIIIlIIlIlI.length);
        for (int llllllllllllllIllIlIllIIIlIIllIl = 0; llllllllllllllIllIlIllIIIlIIllIl < llllllllllllllIllIlIllIIIlIIlIll.length; ++llllllllllllllIllIlIllIIIlIIllIl) {
            System.arraycopy(llllllllllllllIllIlIllIIIlIIlIlI, (int)start(llllllllllllllIllIlIllIIIlIIllIl), llllllllllllllIllIlIllIIIlIIlIll[llllllllllllllIllIlIllIIIlIIllIl], 0, llllllllllllllIllIlIllIIIlIIlIll[llllllllllllllIllIlIllIIIlIIllIl].length);
        }
        return llllllllllllllIllIlIllIIIlIIlIll;
    }
    
    public static byte[][] forceCapacity(final byte[][] llllllllllllllIllIlIllIIIIllIlll, final long llllllllllllllIllIlIllIIIIllIllI, final long llllllllllllllIllIlIllIIIIllIlIl) {
        ensureLength(llllllllllllllIllIlIllIIIIllIllI);
        final int llllllllllllllIllIlIllIIIIllIlII = llllllllllllllIllIlIllIIIIllIlll.length - ((llllllllllllllIllIlIllIIIIllIlll.length != 0 && (llllllllllllllIllIlIllIIIIllIlll.length <= 0 || llllllllllllllIllIlIllIIIIllIlll[llllllllllllllIllIlIllIIIIllIlll.length - 1].length != 134217728)) ? 1 : 0);
        final int llllllllllllllIllIlIllIIIIllIIll = (int)(llllllllllllllIllIlIllIIIIllIllI + 134217727L >>> 27);
        final byte[][] llllllllllllllIllIlIllIIIIllIIlI = Arrays.copyOf(llllllllllllllIllIlIllIIIIllIlll, llllllllllllllIllIlIllIIIIllIIll);
        final int llllllllllllllIllIlIllIIIIllIIIl = (int)(llllllllllllllIllIlIllIIIIllIllI & 0x7FFFFFFL);
        if (llllllllllllllIllIlIllIIIIllIIIl != 0) {
            for (int llllllllllllllIllIlIllIIIIlllIIl = llllllllllllllIllIlIllIIIIllIlII; llllllllllllllIllIlIllIIIIlllIIl < llllllllllllllIllIlIllIIIIllIIll - 1; ++llllllllllllllIllIlIllIIIIlllIIl) {
                llllllllllllllIllIlIllIIIIllIIlI[llllllllllllllIllIlIllIIIIlllIIl] = new byte[134217728];
            }
            llllllllllllllIllIlIllIIIIllIIlI[llllllllllllllIllIlIllIIIIllIIll - 1] = new byte[llllllllllllllIllIlIllIIIIllIIIl];
        }
        else {
            for (int llllllllllllllIllIlIllIIIIlllIII = llllllllllllllIllIlIllIIIIllIlII; llllllllllllllIllIlIllIIIIlllIII < llllllllllllllIllIlIllIIIIllIIll; ++llllllllllllllIllIlIllIIIIlllIII) {
                llllllllllllllIllIlIllIIIIllIIlI[llllllllllllllIllIlIllIIIIlllIII] = new byte[134217728];
            }
        }
        if (llllllllllllllIllIlIllIIIIllIlIl - llllllllllllllIllIlIllIIIIllIlII * 134217728L > 0L) {
            copy(llllllllllllllIllIlIllIIIIllIlll, llllllllllllllIllIlIllIIIIllIlII * 134217728L, llllllllllllllIllIlIllIIIIllIIlI, llllllllllllllIllIlIllIIIIllIlII * 134217728L, llllllllllllllIllIlIllIIIIllIlIl - llllllllllllllIllIlIllIIIIllIlII * 134217728L);
        }
        return llllllllllllllIllIlIllIIIIllIIlI;
    }
    
    public static void fill(final byte[][] llllllllllllllIllIlIlIllllIlIllI, final byte llllllllllllllIllIlIlIllllIlIIll) {
        int llllllllllllllIllIlIlIllllIlIlll = llllllllllllllIllIlIlIllllIlIllI.length;
        while (llllllllllllllIllIlIlIllllIlIlll-- != 0) {
            Arrays.fill(llllllllllllllIllIlIlIllllIlIllI[llllllllllllllIllIlIlIllllIlIlll], llllllllllllllIllIlIlIllllIlIIll);
        }
    }
    
    public static short[][] shuffle(final short[][] llllllllllllllIllIlIIIllIllllIll, final Random llllllllllllllIllIlIIIllIlllllII) {
        long llllllllllllllIllIlIIIllIllllllI = length(llllllllllllllIllIlIIIllIllllIll);
        while (llllllllllllllIllIlIIIllIllllllI-- != 0L) {
            final long llllllllllllllIllIlIIIlllIIIIIII = (llllllllllllllIllIlIIIllIlllllII.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIIllIllllllI + 1L);
            final short llllllllllllllIllIlIIIllIlllllll = get(llllllllllllllIllIlIIIllIllllIll, llllllllllllllIllIlIIIllIllllllI);
            set(llllllllllllllIllIlIIIllIllllIll, llllllllllllllIllIlIIIllIllllllI, get(llllllllllllllIllIlIIIllIllllIll, llllllllllllllIllIlIIIlllIIIIIII));
            set(llllllllllllllIllIlIIIllIllllIll, llllllllllllllIllIlIIIlllIIIIIII, llllllllllllllIllIlIIIllIlllllll);
        }
        return llllllllllllllIllIlIIIllIllllIll;
    }
    
    public static void copy(final float[][] llllllllllllllIllIlIIIIllIIIlIll, final long llllllllllllllIllIlIIIIllIIIIlIl, final float[][] llllllllllllllIllIlIIIIllIIIlIIl, final long llllllllllllllIllIlIIIIllIIIIIll, long llllllllllllllIllIlIIIIllIIIIIlI) {
        if (llllllllllllllIllIlIIIIllIIIIIll <= llllllllllllllIllIlIIIIllIIIIlIl) {
            int llllllllllllllIllIlIIIIllIIlIlIl = segment(llllllllllllllIllIlIIIIllIIIIlIl);
            int llllllllllllllIllIlIIIIllIIlIlII = segment(llllllllllllllIllIlIIIIllIIIIIll);
            int llllllllllllllIllIlIIIIllIIlIIll = displacement(llllllllllllllIllIlIIIIllIIIIlIl);
            int llllllllllllllIllIlIIIIllIIlIIlI = displacement(llllllllllllllIllIlIIIIllIIIIIll);
            while (llllllllllllllIllIlIIIIllIIIIIlI > 0L) {
                final int llllllllllllllIllIlIIIIllIIlIIIl = (int)Math.min(llllllllllllllIllIlIIIIllIIIIIlI, Math.min(llllllllllllllIllIlIIIIllIIIlIll[llllllllllllllIllIlIIIIllIIlIlIl].length - llllllllllllllIllIlIIIIllIIlIIll, llllllllllllllIllIlIIIIllIIIlIIl[llllllllllllllIllIlIIIIllIIlIlII].length - llllllllllllllIllIlIIIIllIIlIIlI));
                if (llllllllllllllIllIlIIIIllIIlIIIl == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIIIllIIIlIll[llllllllllllllIllIlIIIIllIIlIlIl], llllllllllllllIllIlIIIIllIIlIIll, llllllllllllllIllIlIIIIllIIIlIIl[llllllllllllllIllIlIIIIllIIlIlII], llllllllllllllIllIlIIIIllIIlIIlI, llllllllllllllIllIlIIIIllIIlIIIl);
                if ((llllllllllllllIllIlIIIIllIIlIIll += llllllllllllllIllIlIIIIllIIlIIIl) == 134217728) {
                    llllllllllllllIllIlIIIIllIIlIIll = 0;
                    ++llllllllllllllIllIlIIIIllIIlIlIl;
                }
                if ((llllllllllllllIllIlIIIIllIIlIIlI += llllllllllllllIllIlIIIIllIIlIIIl) == 134217728) {
                    llllllllllllllIllIlIIIIllIIlIIlI = 0;
                    ++llllllllllllllIllIlIIIIllIIlIlII;
                }
                llllllllllllllIllIlIIIIllIIIIIlI -= llllllllllllllIllIlIIIIllIIlIIIl;
            }
        }
        else {
            int llllllllllllllIllIlIIIIllIIlIIII = segment(llllllllllllllIllIlIIIIllIIIIlIl + llllllllllllllIllIlIIIIllIIIIIlI);
            int llllllllllllllIllIlIIIIllIIIllll = segment(llllllllllllllIllIlIIIIllIIIIIll + llllllllllllllIllIlIIIIllIIIIIlI);
            int llllllllllllllIllIlIIIIllIIIlllI = displacement(llllllllllllllIllIlIIIIllIIIIlIl + llllllllllllllIllIlIIIIllIIIIIlI);
            int llllllllllllllIllIlIIIIllIIIllIl = displacement(llllllllllllllIllIlIIIIllIIIIIll + llllllllllllllIllIlIIIIllIIIIIlI);
            while (llllllllllllllIllIlIIIIllIIIIIlI > 0L) {
                if (llllllllllllllIllIlIIIIllIIIlllI == 0) {
                    llllllllllllllIllIlIIIIllIIIlllI = 134217728;
                    --llllllllllllllIllIlIIIIllIIlIIII;
                }
                if (llllllllllllllIllIlIIIIllIIIllIl == 0) {
                    llllllllllllllIllIlIIIIllIIIllIl = 134217728;
                    --llllllllllllllIllIlIIIIllIIIllll;
                }
                final int llllllllllllllIllIlIIIIllIIIllII = (int)Math.min(llllllllllllllIllIlIIIIllIIIIIlI, Math.min(llllllllllllllIllIlIIIIllIIIlllI, llllllllllllllIllIlIIIIllIIIllIl));
                if (llllllllllllllIllIlIIIIllIIIllII == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIIIllIIIlIll[llllllllllllllIllIlIIIIllIIlIIII], llllllllllllllIllIlIIIIllIIIlllI - llllllllllllllIllIlIIIIllIIIllII, llllllllllllllIllIlIIIIllIIIlIIl[llllllllllllllIllIlIIIIllIIIllll], llllllllllllllIllIlIIIIllIIIllIl - llllllllllllllIllIlIIIIllIIIllII, llllllllllllllIllIlIIIIllIIIllII);
                llllllllllllllIllIlIIIIllIIIlllI -= llllllllllllllIllIlIIIIllIIIllII;
                llllllllllllllIllIlIIIIllIIIllIl -= llllllllllllllIllIlIIIIllIIIllII;
                llllllllllllllIllIlIIIIllIIIIIlI -= llllllllllllllIllIlIIIIllIIIllII;
            }
        }
    }
    
    public static <K> K[][] setLength(final K[][] llllllllllllllIllIIlllllIlllllII, final long llllllllllllllIllIIlllllIllllIII) {
        final long llllllllllllllIllIIlllllIllllIlI = length(llllllllllllllIllIIlllllIlllllII);
        if (llllllllllllllIllIIlllllIllllIII == llllllllllllllIllIIlllllIllllIlI) {
            return llllllllllllllIllIIlllllIlllllII;
        }
        if (llllllllllllllIllIIlllllIllllIII < llllllllllllllIllIIlllllIllllIlI) {
            return (K[][])trim((Object[][])llllllllllllllIllIIlllllIlllllII, llllllllllllllIllIIlllllIllllIII);
        }
        return (K[][])ensureCapacity((Object[][])llllllllllllllIllIIlllllIlllllII, llllllllllllllIllIIlllllIllllIII);
    }
    
    public static int[][] forceCapacity(final int[][] llllllllllllllIllIlIlIlIIllllIll, final long llllllllllllllIllIlIlIlIIllIllll, final long llllllllllllllIllIlIlIlIIllIlllI) {
        ensureLength(llllllllllllllIllIlIlIlIIllIllll);
        final int llllllllllllllIllIlIlIlIIlllIllI = llllllllllllllIllIlIlIlIIllllIll.length - ((llllllllllllllIllIlIlIlIIllllIll.length != 0 && (llllllllllllllIllIlIlIlIIllllIll.length <= 0 || llllllllllllllIllIlIlIlIIllllIll[llllllllllllllIllIlIlIlIIllllIll.length - 1].length != 134217728)) ? 1 : 0);
        final int llllllllllllllIllIlIlIlIIlllIlIl = (int)(llllllllllllllIllIlIlIlIIllIllll + 134217727L >>> 27);
        final int[][] llllllllllllllIllIlIlIlIIlllIIll = Arrays.copyOf(llllllllllllllIllIlIlIlIIllllIll, llllllllllllllIllIlIlIlIIlllIlIl);
        final int llllllllllllllIllIlIlIlIIlllIIlI = (int)(llllllllllllllIllIlIlIlIIllIllll & 0x7FFFFFFL);
        if (llllllllllllllIllIlIlIlIIlllIIlI != 0) {
            for (int llllllllllllllIllIlIlIlIIllllllI = llllllllllllllIllIlIlIlIIlllIllI; llllllllllllllIllIlIlIlIIllllllI < llllllllllllllIllIlIlIlIIlllIlIl - 1; ++llllllllllllllIllIlIlIlIIllllllI) {
                llllllllllllllIllIlIlIlIIlllIIll[llllllllllllllIllIlIlIlIIllllllI] = new int[134217728];
            }
            llllllllllllllIllIlIlIlIIlllIIll[llllllllllllllIllIlIlIlIIlllIlIl - 1] = new int[llllllllllllllIllIlIlIlIIlllIIlI];
        }
        else {
            for (int llllllllllllllIllIlIlIlIIlllllIl = llllllllllllllIllIlIlIlIIlllIllI; llllllllllllllIllIlIlIlIIlllllIl < llllllllllllllIllIlIlIlIIlllIlIl; ++llllllllllllllIllIlIlIlIIlllllIl) {
                llllllllllllllIllIlIlIlIIlllIIll[llllllllllllllIllIlIlIlIIlllllIl] = new int[134217728];
            }
        }
        if (llllllllllllllIllIlIlIlIIllIlllI - llllllllllllllIllIlIlIlIIlllIllI * 134217728L > 0L) {
            copy(llllllllllllllIllIlIlIlIIllllIll, llllllllllllllIllIlIlIlIIlllIllI * 134217728L, llllllllllllllIllIlIlIlIIlllIIll, llllllllllllllIllIlIlIlIIlllIllI * 134217728L, llllllllllllllIllIlIlIlIIllIlllI - llllllllllllllIllIlIlIlIIlllIllI * 134217728L);
        }
        return llllllllllllllIllIlIlIlIIlllIIll;
    }
    
    public static void copyToBig(final float[] llllllllllllllIllIlIIIIlIlIlIlII, int llllllllllllllIllIlIIIIlIlIlIIll, final float[][] llllllllllllllIllIlIIIIlIlIllIIl, final long llllllllllllllIllIlIIIIlIlIllIII, long llllllllllllllIllIlIIIIlIlIlIIII) {
        int llllllllllllllIllIlIIIIlIlIlIllI = segment(llllllllllllllIllIlIIIIlIlIllIII);
        int llllllllllllllIllIlIIIIlIlIlIlIl = displacement(llllllllllllllIllIlIIIIlIlIllIII);
        while (llllllllllllllIllIlIIIIlIlIlIIII > 0L) {
            final int llllllllllllllIllIlIIIIlIlIlllII = (int)Math.min(llllllllllllllIllIlIIIIlIlIllIIl[llllllllllllllIllIlIIIIlIlIlIllI].length - llllllllllllllIllIlIIIIlIlIlIlIl, llllllllllllllIllIlIIIIlIlIlIIII);
            if (llllllllllllllIllIlIIIIlIlIlllII == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIIIlIlIlIlII, (int)llllllllllllllIllIlIIIIlIlIlIIll, llllllllllllllIllIlIIIIlIlIllIIl[llllllllllllllIllIlIIIIlIlIlIllI], llllllllllllllIllIlIIIIlIlIlIlIl, llllllllllllllIllIlIIIIlIlIlllII);
            if ((llllllllllllllIllIlIIIIlIlIlIlIl += llllllllllllllIllIlIIIIlIlIlllII) == 134217728) {
                llllllllllllllIllIlIIIIlIlIlIlIl = 0;
                ++llllllllllllllIllIlIIIIlIlIlIllI;
            }
            llllllllllllllIllIlIIIIlIlIlIIll += llllllllllllllIllIlIIIIlIlIlllII;
            llllllllllllllIllIlIIIIlIlIlIIII -= llllllllllllllIllIlIIIIlIlIlllII;
        }
    }
    
    public static long length(final boolean[][] llllllllllllllIllIlIIllIIlIlIIII) {
        final int llllllllllllllIllIlIIllIIlIIllll = llllllllllllllIllIlIIllIIlIlIIII.length;
        return (llllllllllllllIllIlIIllIIlIIllll == 0) ? 0L : (start(llllllllllllllIllIlIIllIIlIIllll - 1) + llllllllllllllIllIlIIllIIlIlIIII[llllllllllllllIllIlIIllIIlIIllll - 1].length);
    }
    
    public static double[][] shuffle(final double[][] llllllllllllllIllIlIIllIlIIlIIII, final long llllllllllllllIllIlIIllIlIIIlIll, final long llllllllllllllIllIlIIllIlIIIlllI, final Random llllllllllllllIllIlIIllIlIIIlIIl) {
        long llllllllllllllIllIlIIllIlIIlIIIl = llllllllllllllIllIlIIllIlIIIlllI - llllllllllllllIllIlIIllIlIIIlIll;
        while (llllllllllllllIllIlIIllIlIIlIIIl-- != 0L) {
            final long llllllllllllllIllIlIIllIlIIlIIll = (llllllllllllllIllIlIIllIlIIIlIIl.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIllIlIIlIIIl + 1L);
            final double llllllllllllllIllIlIIllIlIIlIIlI = get(llllllllllllllIllIlIIllIlIIlIIII, llllllllllllllIllIlIIllIlIIIlIll + llllllllllllllIllIlIIllIlIIlIIIl);
            set(llllllllllllllIllIlIIllIlIIlIIII, llllllllllllllIllIlIIllIlIIIlIll + llllllllllllllIllIlIIllIlIIlIIIl, get(llllllllllllllIllIlIIllIlIIlIIII, llllllllllllllIllIlIIllIlIIIlIll + llllllllllllllIllIlIIllIlIIlIIll));
            set(llllllllllllllIllIlIIllIlIIlIIII, llllllllllllllIllIlIIllIlIIIlIll + llllllllllllllIllIlIIllIlIIlIIll, llllllllllllllIllIlIIllIlIIlIIlI);
        }
        return llllllllllllllIllIlIIllIlIIlIIII;
    }
    
    public static void set(final short[][] llllllllllllllIllIlIIlIIlllllIIl, final long llllllllllllllIllIlIIlIIlllllIII, final short llllllllllllllIllIlIIlIIllllIlll) {
        llllllllllllllIllIlIIlIIlllllIIl[segment(llllllllllllllIllIlIIlIIlllllIII)][displacement(llllllllllllllIllIlIIlIIlllllIII)] = llllllllllllllIllIlIIlIIllllIlll;
    }
    
    public static void fill(final short[][] llllllllllllllIllIlIIIlllllIlllI, final short llllllllllllllIllIlIIIlllllIllIl) {
        int llllllllllllllIllIlIIIllllllIIIl = llllllllllllllIllIlIIIlllllIlllI.length;
        while (llllllllllllllIllIlIIIllllllIIIl-- != 0) {
            Arrays.fill(llllllllllllllIllIlIIIlllllIlllI[llllllllllllllIllIlIIIllllllIIIl], llllllllllllllIllIlIIIlllllIllIl);
        }
    }
    
    public static void mul(final double[][] llllllllllllllIllIlIIlllllIlIIlI, final long llllllllllllllIllIlIIlllllIlIIIl, final double llllllllllllllIllIlIIlllllIlIIll) {
        final double[] array = llllllllllllllIllIlIIlllllIlIIlI[segment(llllllllllllllIllIlIIlllllIlIIIl)];
        final int displacement = displacement(llllllllllllllIllIlIIlllllIlIIIl);
        array[displacement] *= llllllllllllllIllIlIIlllllIlIIll;
    }
    
    public static char[][] trim(final char[][] llllllllllllllIllIlIIIlIlIIIllll, final long llllllllllllllIllIlIIIlIlIIIlllI) {
        ensureLength(llllllllllllllIllIlIIIlIlIIIlllI);
        final long llllllllllllllIllIlIIIlIlIIIllIl = length(llllllllllllllIllIlIIIlIlIIIllll);
        if (llllllllllllllIllIlIIIlIlIIIlllI >= llllllllllllllIllIlIIIlIlIIIllIl) {
            return llllllllllllllIllIlIIIlIlIIIllll;
        }
        final int llllllllllllllIllIlIIIlIlIIIllII = (int)(llllllllllllllIllIlIIIlIlIIIlllI + 134217727L >>> 27);
        final char[][] llllllllllllllIllIlIIIlIlIIIlIll = Arrays.copyOf(llllllllllllllIllIlIIIlIlIIIllll, llllllllllllllIllIlIIIlIlIIIllII);
        final int llllllllllllllIllIlIIIlIlIIIlIlI = (int)(llllllllllllllIllIlIIIlIlIIIlllI & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIIlIlIIIlIlI != 0) {
            llllllllllllllIllIlIIIlIlIIIlIll[llllllllllllllIllIlIIIlIlIIIllII - 1] = CharArrays.trim(llllllllllllllIllIlIIIlIlIIIlIll[llllllllllllllIllIlIIIlIlIIIllII - 1], llllllllllllllIllIlIIIlIlIIIlIlI);
        }
        return llllllllllllllIllIlIIIlIlIIIlIll;
    }
    
    public static void ensureSameLength(final short[][] llllllllllllllIllIlIIIlllIIllllI, final short[][] llllllllllllllIllIlIIIlllIIlllIl) {
        if (length(llllllllllllllIllIlIIIlllIIllllI) != length(llllllllllllllIllIlIIIlllIIlllIl)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(length(llllllllllllllIllIlIIIlllIIllllI)).append(" != ").append(length(llllllllllllllIllIlIIIlllIIlllIl))));
        }
    }
    
    public static void ensureSameLength(final char[][] llllllllllllllIllIlIIIlIIIIIllll, final char[][] llllllllllllllIllIlIIIlIIIIIllII) {
        if (length(llllllllllllllIllIlIIIlIIIIIllll) != length(llllllllllllllIllIlIIIlIIIIIllII)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(length(llllllllllllllIllIlIIIlIIIIIllll)).append(" != ").append(length(llllllllllllllIllIlIIIlIIIIIllII))));
        }
    }
    
    public static void swap(final int[][] llllllllllllllIllIlIlIllIlIIIlIl, final long llllllllllllllIllIlIlIllIlIIlIII, final long llllllllllllllIllIlIlIllIlIIIlll) {
        final int llllllllllllllIllIlIlIllIlIIIllI = llllllllllllllIllIlIlIllIlIIIlIl[segment(llllllllllllllIllIlIlIllIlIIlIII)][displacement(llllllllllllllIllIlIlIllIlIIlIII)];
        llllllllllllllIllIlIlIllIlIIIlIl[segment(llllllllllllllIllIlIlIllIlIIlIII)][displacement(llllllllllllllIllIlIlIllIlIIlIII)] = llllllllllllllIllIlIlIllIlIIIlIl[segment(llllllllllllllIllIlIlIllIlIIIlll)][displacement(llllllllllllllIllIlIlIllIlIIIlll)];
        llllllllllllllIllIlIlIllIlIIIlIl[segment(llllllllllllllIllIlIlIllIlIIIlll)][displacement(llllllllllllllIllIlIlIllIlIIIlll)] = llllllllllllllIllIlIlIllIlIIIllI;
    }
    
    public static void fill(final int[][] llllllllllllllIllIlIlIIlllllIlll, final long llllllllllllllIllIlIlIIlllllllll, final long llllllllllllllIllIlIlIIlllllIlIl, final int llllllllllllllIllIlIlIIlllllllIl) {
        final long llllllllllllllIllIlIlIIlllllllII = length(llllllllllllllIllIlIlIIlllllIlll);
        ensureFromTo(llllllllllllllIllIlIlIIlllllllII, llllllllllllllIllIlIlIIlllllllll, llllllllllllllIllIlIlIIlllllIlIl);
        if (llllllllllllllIllIlIlIIlllllllII == 0L) {
            return;
        }
        final int llllllllllllllIllIlIlIIllllllIll = segment(llllllllllllllIllIlIlIIlllllllll);
        int llllllllllllllIllIlIlIIllllllIlI = segment(llllllllllllllIllIlIlIIlllllIlIl);
        final int llllllllllllllIllIlIlIIllllllIIl = displacement(llllllllllllllIllIlIlIIlllllllll);
        final int llllllllllllllIllIlIlIIllllllIII = displacement(llllllllllllllIllIlIlIIlllllIlIl);
        if (llllllllllllllIllIlIlIIllllllIll == llllllllllllllIllIlIlIIllllllIlI) {
            Arrays.fill(llllllllllllllIllIlIlIIlllllIlll[llllllllllllllIllIlIlIIllllllIll], llllllllllllllIllIlIlIIllllllIIl, llllllllllllllIllIlIlIIllllllIII, llllllllllllllIllIlIlIIlllllllIl);
            return;
        }
        if (llllllllllllllIllIlIlIIllllllIII != 0) {
            Arrays.fill(llllllllllllllIllIlIlIIlllllIlll[llllllllllllllIllIlIlIIllllllIlI], 0, llllllllllllllIllIlIlIIllllllIII, llllllllllllllIllIlIlIIlllllllIl);
        }
        while (--llllllllllllllIllIlIlIIllllllIlI > llllllllllllllIllIlIlIIllllllIll) {
            Arrays.fill(llllllllllllllIllIlIlIIlllllIlll[llllllllllllllIllIlIlIIllllllIlI], llllllllllllllIllIlIlIIlllllllIl);
        }
        Arrays.fill(llllllllllllllIllIlIlIIlllllIlll[llllllllllllllIllIlIlIIllllllIll], llllllllllllllIllIlIlIIllllllIIl, 134217728, llllllllllllllIllIlIlIIlllllllIl);
    }
    
    public static int[][] shuffle(final int[][] llllllllllllllIllIlIlIIllIIllIll, final Random llllllllllllllIllIlIlIIllIIllIlI) {
        long llllllllllllllIllIlIlIIllIIlllII = length(llllllllllllllIllIlIlIIllIIllIll);
        while (llllllllllllllIllIlIlIIllIIlllII-- != 0L) {
            final long llllllllllllllIllIlIlIIllIIllllI = (llllllllllllllIllIlIlIIllIIllIlI.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIlIIllIIlllII + 1L);
            final int llllllllllllllIllIlIlIIllIIlllIl = get(llllllllllllllIllIlIlIIllIIllIll, llllllllllllllIllIlIlIIllIIlllII);
            set(llllllllllllllIllIlIlIIllIIllIll, llllllllllllllIllIlIlIIllIIlllII, get(llllllllllllllIllIlIlIIllIIllIll, llllllllllllllIllIlIlIIllIIllllI));
            set(llllllllllllllIllIlIlIIllIIllIll, llllllllllllllIllIlIlIIllIIllllI, llllllllllllllIllIlIlIIllIIlllIl);
        }
        return llllllllllllllIllIlIlIIllIIllIll;
    }
    
    public static short get(final short[][] llllllllllllllIllIlIIlIlIIIIIIll, final long llllllllllllllIllIlIIlIlIIIIIIlI) {
        return llllllllllllllIllIlIIlIlIIIIIIll[segment(llllllllllllllIllIlIIlIlIIIIIIlI)][displacement(llllllllllllllIllIlIIlIlIIIIIIlI)];
    }
    
    public static void swap(final boolean[][] llllllllllllllIllIlIIllIIllIIIll, final long llllllllllllllIllIlIIllIIllIIIlI, final long llllllllllllllIllIlIIllIIlIlllIl) {
        final boolean llllllllllllllIllIlIIllIIllIIIII = llllllllllllllIllIlIIllIIllIIIll[segment(llllllllllllllIllIlIIllIIllIIIlI)][displacement(llllllllllllllIllIlIIllIIllIIIlI)];
        llllllllllllllIllIlIIllIIllIIIll[segment(llllllllllllllIllIlIIllIIllIIIlI)][displacement(llllllllllllllIllIlIIllIIllIIIlI)] = llllllllllllllIllIlIIllIIllIIIll[segment(llllllllllllllIllIlIIllIIlIlllIl)][displacement(llllllllllllllIllIlIIllIIlIlllIl)];
        llllllllllllllIllIlIIllIIllIIIll[segment(llllllllllllllIllIlIIllIIlIlllIl)][displacement(llllllllllllllIllIlIIllIIlIlllIl)] = llllllllllllllIllIlIIllIIllIIIII;
    }
    
    public static void fill(final double[][] llllllllllllllIllIlIIllIllIllIIl, final long llllllllllllllIllIlIIllIlllIIIIl, final long llllllllllllllIllIlIIllIllIlIlll, final double llllllllllllllIllIlIIllIllIlllll) {
        final long llllllllllllllIllIlIIllIllIllllI = length(llllllllllllllIllIlIIllIllIllIIl);
        ensureFromTo(llllllllllllllIllIlIIllIllIllllI, llllllllllllllIllIlIIllIlllIIIIl, llllllllllllllIllIlIIllIllIlIlll);
        if (llllllllllllllIllIlIIllIllIllllI == 0L) {
            return;
        }
        final int llllllllllllllIllIlIIllIllIlllIl = segment(llllllllllllllIllIlIIllIlllIIIIl);
        int llllllllllllllIllIlIIllIllIlllII = segment(llllllllllllllIllIlIIllIllIlIlll);
        final int llllllllllllllIllIlIIllIllIllIll = displacement(llllllllllllllIllIlIIllIlllIIIIl);
        final int llllllllllllllIllIlIIllIllIllIlI = displacement(llllllllllllllIllIlIIllIllIlIlll);
        if (llllllllllllllIllIlIIllIllIlllIl == llllllllllllllIllIlIIllIllIlllII) {
            Arrays.fill(llllllllllllllIllIlIIllIllIllIIl[llllllllllllllIllIlIIllIllIlllIl], llllllllllllllIllIlIIllIllIllIll, llllllllllllllIllIlIIllIllIllIlI, llllllllllllllIllIlIIllIllIlllll);
            return;
        }
        if (llllllllllllllIllIlIIllIllIllIlI != 0) {
            Arrays.fill(llllllllllllllIllIlIIllIllIllIIl[llllllllllllllIllIlIIllIllIlllII], 0, llllllllllllllIllIlIIllIllIllIlI, llllllllllllllIllIlIIllIllIlllll);
        }
        while (--llllllllllllllIllIlIIllIllIlllII > llllllllllllllIllIlIIllIllIlllIl) {
            Arrays.fill(llllllllllllllIllIlIIllIllIllIIl[llllllllllllllIllIlIIllIllIlllII], llllllllllllllIllIlIIllIllIlllll);
        }
        Arrays.fill(llllllllllllllIllIlIIllIllIllIIl[llllllllllllllIllIlIIllIllIlllIl], llllllllllllllIllIlIIllIllIllIll, 134217728, llllllllllllllIllIlIIllIllIlllll);
    }
    
    public static void swap(final long[][] llllllllllllllIllIlIlIIllIIIIIIl, final long llllllllllllllIllIlIlIIllIIIIIII, final long llllllllllllllIllIlIlIIlIlllllll) {
        final long llllllllllllllIllIlIlIIlIllllllI = llllllllllllllIllIlIlIIllIIIIIIl[segment(llllllllllllllIllIlIlIIllIIIIIII)][displacement(llllllllllllllIllIlIlIIllIIIIIII)];
        llllllllllllllIllIlIlIIllIIIIIIl[segment(llllllllllllllIllIlIlIIllIIIIIII)][displacement(llllllllllllllIllIlIlIIllIIIIIII)] = llllllllllllllIllIlIlIIllIIIIIIl[segment(llllllllllllllIllIlIlIIlIlllllll)][displacement(llllllllllllllIllIlIlIIlIlllllll)];
        llllllllllllllIllIlIlIIllIIIIIIl[segment(llllllllllllllIllIlIlIIlIlllllll)][displacement(llllllllllllllIllIlIlIIlIlllllll)] = llllllllllllllIllIlIlIIlIllllllI;
    }
    
    public static void copyFromBig(final byte[][] llllllllllllllIllIlIllIIIlllIIII, final long llllllllllllllIllIlIllIIIlllIllI, final byte[] llllllllllllllIllIlIllIIIllIlllI, int llllllllllllllIllIlIllIIIllIllIl, int llllllllllllllIllIlIllIIIllIllII) {
        int llllllllllllllIllIlIllIIIlllIIlI = segment(llllllllllllllIllIlIllIIIlllIllI);
        int llllllllllllllIllIlIllIIIlllIIIl = displacement(llllllllllllllIllIlIllIIIlllIllI);
        while (llllllllllllllIllIlIllIIIllIllII > 0) {
            final int llllllllllllllIllIlIllIIIllllIII = Math.min(llllllllllllllIllIlIllIIIlllIIII[llllllllllllllIllIlIllIIIlllIIlI].length - llllllllllllllIllIlIllIIIlllIIIl, llllllllllllllIllIlIllIIIllIllII);
            if (llllllllllllllIllIlIllIIIllllIII == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIllIIIlllIIII[llllllllllllllIllIlIllIIIlllIIlI], llllllllllllllIllIlIllIIIlllIIIl, llllllllllllllIllIlIllIIIllIlllI, llllllllllllllIllIlIllIIIllIllIl, llllllllllllllIllIlIllIIIllllIII);
            if ((llllllllllllllIllIlIllIIIlllIIIl += llllllllllllllIllIlIllIIIllllIII) == 134217728) {
                llllllllllllllIllIlIllIIIlllIIIl = 0;
                ++llllllllllllllIllIlIllIIIlllIIlI;
            }
            llllllllllllllIllIlIllIIIllIllIl += llllllllllllllIllIlIllIIIllllIII;
            llllllllllllllIllIlIllIIIllIllII -= llllllllllllllIllIlIllIIIllllIII;
        }
    }
    
    public static void set(final double[][] llllllllllllllIllIlIIlllllllllII, final long llllllllllllllIllIlIIllllllllIII, final double llllllllllllllIllIlIIlllllllIlll) {
        llllllllllllllIllIlIIlllllllllII[segment(llllllllllllllIllIlIIllllllllIII)][displacement(llllllllllllllIllIlIIllllllllIII)] = llllllllllllllIllIlIIlllllllIlll;
    }
    
    public static void quickSort(final long llllllllllllllIllIlIllIlIIlIIlIl, final long llllllllllllllIllIlIllIlIIllIIlI, final LongComparator llllllllllllllIllIlIllIlIIllIIIl, final BigSwapper llllllllllllllIllIlIllIlIIllIIII) {
        final long llllllllllllllIllIlIllIlIIlIllll = llllllllllllllIllIlIllIlIIllIIlI - llllllllllllllIllIlIllIlIIlIIlIl;
        if (llllllllllllllIllIlIllIlIIlIllll < 7L) {
            for (long llllllllllllllIllIlIllIlIIlllIll = llllllllllllllIllIlIllIlIIlIIlIl; llllllllllllllIllIlIllIlIIlllIll < llllllllllllllIllIlIllIlIIllIIlI; ++llllllllllllllIllIlIllIlIIlllIll) {
                for (long llllllllllllllIllIlIllIlIIllllII = llllllllllllllIllIlIllIlIIlllIll; llllllllllllllIllIlIllIlIIllllII > llllllllllllllIllIlIllIlIIlIIlIl && llllllllllllllIllIlIllIlIIllIIIl.compare(llllllllllllllIllIlIllIlIIllllII - 1L, llllllllllllllIllIlIllIlIIllllII) > 0; --llllllllllllllIllIlIllIlIIllllII) {
                    llllllllllllllIllIlIllIlIIllIIII.swap(llllllllllllllIllIlIllIlIIllllII, llllllllllllllIllIlIllIlIIllllII - 1L);
                }
            }
            return;
        }
        long llllllllllllllIllIlIllIlIIlIlllI = llllllllllllllIllIlIllIlIIlIIlIl + llllllllllllllIllIlIllIlIIlIllll / 2L;
        if (llllllllllllllIllIlIllIlIIlIllll > 7L) {
            long llllllllllllllIllIlIllIlIIlllIII = llllllllllllllIllIlIllIlIIlIIlIl;
            long llllllllllllllIllIlIllIlIIllIllI = llllllllllllllIllIlIllIlIIllIIlI - 1L;
            if (llllllllllllllIllIlIllIlIIlIllll > 40L) {
                final long llllllllllllllIllIlIllIlIIlllIlI = llllllllllllllIllIlIllIlIIlIllll / 8L;
                llllllllllllllIllIlIllIlIIlllIII = med3(llllllllllllllIllIlIllIlIIlllIII, llllllllllllllIllIlIllIlIIlllIII + llllllllllllllIllIlIllIlIIlllIlI, llllllllllllllIllIlIllIlIIlllIII + 2L * llllllllllllllIllIlIllIlIIlllIlI, llllllllllllllIllIlIllIlIIllIIIl);
                llllllllllllllIllIlIllIlIIlIlllI = med3(llllllllllllllIllIlIllIlIIlIlllI - llllllllllllllIllIlIllIlIIlllIlI, llllllllllllllIllIlIllIlIIlIlllI, llllllllllllllIllIlIllIlIIlIlllI + llllllllllllllIllIlIllIlIIlllIlI, llllllllllllllIllIlIllIlIIllIIIl);
                llllllllllllllIllIlIllIlIIllIllI = med3(llllllllllllllIllIlIllIlIIllIllI - 2L * llllllllllllllIllIlIllIlIIlllIlI, llllllllllllllIllIlIllIlIIllIllI - llllllllllllllIllIlIllIlIIlllIlI, llllllllllllllIllIlIllIlIIllIllI, llllllllllllllIllIlIllIlIIllIIIl);
            }
            llllllllllllllIllIlIllIlIIlIlllI = med3(llllllllllllllIllIlIllIlIIlllIII, llllllllllllllIllIlIllIlIIlIlllI, llllllllllllllIllIlIllIlIIllIllI, llllllllllllllIllIlIllIlIIllIIIl);
        }
        long llllllllllllllIllIlIllIlIIlIllII;
        long llllllllllllllIllIlIllIlIIlIllIl = llllllllllllllIllIlIllIlIIlIllII = llllllllllllllIllIlIllIlIIlIIlIl;
        long llllllllllllllIllIlIllIlIIlIlIlI;
        long llllllllllllllIllIlIllIlIIlIlIll = llllllllllllllIllIlIllIlIIlIlIlI = llllllllllllllIllIlIllIlIIllIIlI - 1L;
        while (true) {
            final int llllllllllllllIllIlIllIlIIllIlIl;
            if (llllllllllllllIllIlIllIlIIlIllII <= llllllllllllllIllIlIllIlIIlIlIll && (llllllllllllllIllIlIllIlIIllIlIl = llllllllllllllIllIlIllIlIIllIIIl.compare(llllllllllllllIllIlIllIlIIlIllII, llllllllllllllIllIlIllIlIIlIlllI)) <= 0) {
                if (llllllllllllllIllIlIllIlIIllIlIl == 0) {
                    if (llllllllllllllIllIlIllIlIIlIllIl == llllllllllllllIllIlIllIlIIlIlllI) {
                        llllllllllllllIllIlIllIlIIlIlllI = llllllllllllllIllIlIllIlIIlIllII;
                    }
                    else if (llllllllllllllIllIlIllIlIIlIllII == llllllllllllllIllIlIllIlIIlIlllI) {
                        llllllllllllllIllIlIllIlIIlIlllI = llllllllllllllIllIlIllIlIIlIllIl;
                    }
                    llllllllllllllIllIlIllIlIIllIIII.swap(llllllllllllllIllIlIllIlIIlIllIl++, llllllllllllllIllIlIllIlIIlIllII);
                }
                ++llllllllllllllIllIlIllIlIIlIllII;
            }
            else {
                int llllllllllllllIllIlIllIlIIllIlII;
                while (llllllllllllllIllIlIllIlIIlIlIll >= llllllllllllllIllIlIllIlIIlIllII && (llllllllllllllIllIlIllIlIIllIlII = llllllllllllllIllIlIllIlIIllIIIl.compare(llllllllllllllIllIlIllIlIIlIlIll, llllllllllllllIllIlIllIlIIlIlllI)) >= 0) {
                    if (llllllllllllllIllIlIllIlIIllIlII == 0) {
                        if (llllllllllllllIllIlIllIlIIlIlIll == llllllllllllllIllIlIllIlIIlIlllI) {
                            llllllllllllllIllIlIllIlIIlIlllI = llllllllllllllIllIlIllIlIIlIlIlI;
                        }
                        else if (llllllllllllllIllIlIllIlIIlIlIlI == llllllllllllllIllIlIllIlIIlIlllI) {
                            llllllllllllllIllIlIllIlIIlIlllI = llllllllllllllIllIlIllIlIIlIlIll;
                        }
                        llllllllllllllIllIlIllIlIIllIIII.swap(llllllllllllllIllIlIllIlIIlIlIll, llllllllllllllIllIlIllIlIIlIlIlI--);
                    }
                    --llllllllllllllIllIlIllIlIIlIlIll;
                }
                if (llllllllllllllIllIlIllIlIIlIllII > llllllllllllllIllIlIllIlIIlIlIll) {
                    break;
                }
                if (llllllllllllllIllIlIllIlIIlIllII == llllllllllllllIllIlIllIlIIlIlllI) {
                    llllllllllllllIllIlIllIlIIlIlllI = llllllllllllllIllIlIllIlIIlIlIlI;
                }
                else if (llllllllllllllIllIlIllIlIIlIlIll == llllllllllllllIllIlIllIlIIlIlllI) {
                    llllllllllllllIllIlIllIlIIlIlllI = llllllllllllllIllIlIllIlIIlIlIll;
                }
                llllllllllllllIllIlIllIlIIllIIII.swap(llllllllllllllIllIlIllIlIIlIllII++, llllllllllllllIllIlIllIlIIlIlIll--);
            }
        }
        final long llllllllllllllIllIlIllIlIIlIIlll = llllllllllllllIllIlIllIlIIlIIlIl + llllllllllllllIllIlIllIlIIlIllll;
        long llllllllllllllIllIlIllIlIIlIlIII = Math.min(llllllllllllllIllIlIllIlIIlIllIl - llllllllllllllIllIlIllIlIIlIIlIl, llllllllllllllIllIlIllIlIIlIllII - llllllllllllllIllIlIllIlIIlIllIl);
        vecSwap(llllllllllllllIllIlIllIlIIllIIII, llllllllllllllIllIlIllIlIIlIIlIl, llllllllllllllIllIlIllIlIIlIllII - llllllllllllllIllIlIllIlIIlIlIII, llllllllllllllIllIlIllIlIIlIlIII);
        llllllllllllllIllIlIllIlIIlIlIII = Math.min(llllllllllllllIllIlIllIlIIlIlIlI - llllllllllllllIllIlIllIlIIlIlIll, llllllllllllllIllIlIllIlIIlIIlll - llllllllllllllIllIlIllIlIIlIlIlI - 1L);
        vecSwap(llllllllllllllIllIlIllIlIIllIIII, llllllllllllllIllIlIllIlIIlIllII, llllllllllllllIllIlIllIlIIlIIlll - llllllllllllllIllIlIllIlIIlIlIII, llllllllllllllIllIlIllIlIIlIlIII);
        if ((llllllllllllllIllIlIllIlIIlIlIII = llllllllllllllIllIlIllIlIIlIllII - llllllllllllllIllIlIllIlIIlIllIl) > 1L) {
            quickSort(llllllllllllllIllIlIllIlIIlIIlIl, llllllllllllllIllIlIllIlIIlIIlIl + llllllllllllllIllIlIllIlIIlIlIII, llllllllllllllIllIlIllIlIIllIIIl, llllllllllllllIllIlIllIlIIllIIII);
        }
        if ((llllllllllllllIllIlIllIlIIlIlIII = llllllllllllllIllIlIllIlIIlIlIlI - llllllllllllllIllIlIllIlIIlIlIll) > 1L) {
            quickSort(llllllllllllllIllIlIllIlIIlIIlll - llllllllllllllIllIlIllIlIIlIlIII, llllllllllllllIllIlIllIlIIlIIlll, llllllllllllllIllIlIllIlIIllIIIl, llllllllllllllIllIlIllIlIIllIIII);
        }
    }
    
    public static void ensureOffsetLength(final int[][] llllllllllllllIllIlIlIIlllIIIlII, final long llllllllllllllIllIlIlIIlllIIIIll, final long llllllllllllllIllIlIlIIlllIIIIlI) {
        ensureOffsetLength(length(llllllllllllllIllIlIlIIlllIIIlII), llllllllllllllIllIlIlIIlllIIIIll, llllllllllllllIllIlIlIIlllIIIIlI);
    }
    
    public static short[][] ensureCapacity(final short[][] llllllllllllllIllIlIIlIIIlIlllll, final long llllllllllllllIllIlIIlIIIlIlllII) {
        return ensureCapacity(llllllllllllllIllIlIIlIIIlIlllll, llllllllllllllIllIlIIlIIIlIlllII, length(llllllllllllllIllIlIIlIIIlIlllll));
    }
    
    public static <K> void ensureSameLength(final K[][] llllllllllllllIllIIlllllIIIIlIIl, final K[][] llllllllllllllIllIIlllllIIIIlIlI) {
        if (length(llllllllllllllIllIIlllllIIIIlIIl) != length(llllllllllllllIllIIlllllIIIIlIlI)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(length(llllllllllllllIllIIlllllIIIIlIIl)).append(" != ").append(length(llllllllllllllIllIIlllllIIIIlIlI))));
        }
    }
    
    public static void fill(final int[][] llllllllllllllIllIlIlIlIIIIIllII, final int llllllllllllllIllIlIlIlIIIIIllIl) {
        int llllllllllllllIllIlIlIlIIIIIllll = llllllllllllllIllIlIlIlIIIIIllII.length;
        while (llllllllllllllIllIlIlIlIIIIIllll-- != 0) {
            Arrays.fill(llllllllllllllIllIlIlIlIIIIIllII[llllllllllllllIllIlIlIlIIIIIllll], llllllllllllllIllIlIlIlIIIIIllIl);
        }
    }
    
    public static boolean[][] grow(final boolean[][] llllllllllllllIllIlIIlIlllIIIIlI, final long llllllllllllllIllIlIIlIlllIIIIIl) {
        final long llllllllllllllIllIlIIlIlllIIIIll = length(llllllllllllllIllIlIIlIlllIIIIlI);
        return (llllllllllllllIllIlIIlIlllIIIIIl > llllllllllllllIllIlIIlIlllIIIIll) ? grow(llllllllllllllIllIlIIlIlllIIIIlI, llllllllllllllIllIlIIlIlllIIIIIl, llllllllllllllIllIlIIlIlllIIIIll) : llllllllllllllIllIlIIlIlllIIIIlI;
    }
    
    public static void copyFromBig(final long[][] llllllllllllllIllIlIlIIlIIIllIIl, final long llllllllllllllIllIlIlIIlIIIllIII, final long[] llllllllllllllIllIlIlIIlIIIllllI, int llllllllllllllIllIlIlIIlIIIlIllI, int llllllllllllllIllIlIlIIlIIIlIlIl) {
        int llllllllllllllIllIlIlIIlIIIllIll = segment(llllllllllllllIllIlIlIIlIIIllIII);
        int llllllllllllllIllIlIlIIlIIIllIlI = displacement(llllllllllllllIllIlIlIIlIIIllIII);
        while (llllllllllllllIllIlIlIIlIIIlIlIl > 0) {
            final int llllllllllllllIllIlIlIIlIIlIIIIl = Math.min(llllllllllllllIllIlIlIIlIIIllIIl[llllllllllllllIllIlIlIIlIIIllIll].length - llllllllllllllIllIlIlIIlIIIllIlI, llllllllllllllIllIlIlIIlIIIlIlIl);
            if (llllllllllllllIllIlIlIIlIIlIIIIl == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIlIIlIIIllIIl[llllllllllllllIllIlIlIIlIIIllIll], llllllllllllllIllIlIlIIlIIIllIlI, llllllllllllllIllIlIlIIlIIIllllI, llllllllllllllIllIlIlIIlIIIlIllI, llllllllllllllIllIlIlIIlIIlIIIIl);
            if ((llllllllllllllIllIlIlIIlIIIllIlI += llllllllllllllIllIlIlIIlIIlIIIIl) == 134217728) {
                llllllllllllllIllIlIlIIlIIIllIlI = 0;
                ++llllllllllllllIllIlIlIIlIIIllIll;
            }
            llllllllllllllIllIlIlIIlIIIlIllI += llllllllllllllIllIlIlIIlIIlIIIIl;
            llllllllllllllIllIlIlIIlIIIlIlIl -= llllllllllllllIllIlIlIIlIIlIIIIl;
        }
    }
    
    public static String toString(final int[][] llllllllllllllIllIlIlIIlllIlIlII) {
        if (llllllllllllllIllIlIlIIlllIlIlII == null) {
            return "null";
        }
        final long llllllllllllllIllIlIlIIlllIlIllI = length(llllllllllllllIllIlIlIIlllIlIlII) - 1L;
        if (llllllllllllllIllIlIlIIlllIlIllI == -1L) {
            return "[]";
        }
        final StringBuilder llllllllllllllIllIlIlIIlllIlIlIl = new StringBuilder();
        llllllllllllllIllIlIlIIlllIlIlIl.append('[');
        long llllllllllllllIllIlIlIIlllIllIII = 0L;
        while (true) {
            llllllllllllllIllIlIlIIlllIlIlIl.append(String.valueOf(get(llllllllllllllIllIlIlIIlllIlIlII, llllllllllllllIllIlIlIIlllIllIII)));
            if (llllllllllllllIllIlIlIIlllIllIII == llllllllllllllIllIlIlIIlllIlIllI) {
                break;
            }
            llllllllllllllIllIlIlIIlllIlIlIl.append(", ");
            ++llllllllllllllIllIlIlIIlllIllIII;
        }
        return String.valueOf(llllllllllllllIllIlIlIIlllIlIlIl.append(']'));
    }
    
    public static boolean equals(final byte[][] llllllllllllllIllIlIlIlllIlIlIlI, final byte[][] llllllllllllllIllIlIlIlllIlIlIIl) {
        if (length(llllllllllllllIllIlIlIlllIlIlIlI) != length(llllllllllllllIllIlIlIlllIlIlIIl)) {
            return false;
        }
        int llllllllllllllIllIlIlIlllIlIlIll = llllllllllllllIllIlIlIlllIlIlIlI.length;
        while (llllllllllllllIllIlIlIlllIlIlIll-- != 0) {
            final byte[] llllllllllllllIllIlIlIlllIlIllll = llllllllllllllIllIlIlIlllIlIlIlI[llllllllllllllIllIlIlIlllIlIlIll];
            final byte[] llllllllllllllIllIlIlIlllIlIlllI = llllllllllllllIllIlIlIlllIlIlIIl[llllllllllllllIllIlIlIlllIlIlIll];
            int llllllllllllllIllIlIlIlllIllIIII = llllllllllllllIllIlIlIlllIlIllll.length;
            while (llllllllllllllIllIlIlIlllIllIIII-- != 0) {
                if (llllllllllllllIllIlIlIlllIlIllll[llllllllllllllIllIlIlIlllIllIIII] != llllllllllllllIllIlIlIlllIlIlllI[llllllllllllllIllIlIlIlllIllIIII]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int[][] grow(final int[][] llllllllllllllIllIlIlIlIIlIlIlII, final long llllllllllllllIllIlIlIlIIlIlIIll) {
        final long llllllllllllllIllIlIlIlIIlIlIIlI = length(llllllllllllllIllIlIlIlIIlIlIlII);
        return (llllllllllllllIllIlIlIlIIlIlIIll > llllllllllllllIllIlIlIlIIlIlIIlI) ? grow(llllllllllllllIllIlIlIlIIlIlIlII, llllllllllllllIllIlIlIlIIlIlIIll, llllllllllllllIllIlIlIlIIlIlIIlI) : llllllllllllllIllIlIlIlIIlIlIlII;
    }
    
    public static void incr(final byte[][] llllllllllllllIllIlIllIIlIllIIll, final long llllllllllllllIllIlIllIIlIllIIII) {
        final byte[] array = llllllllllllllIllIlIllIIlIllIIll[segment(llllllllllllllIllIlIllIIlIllIIII)];
        final int displacement = displacement(llllllllllllllIllIlIllIIlIllIIII);
        ++array[displacement];
    }
    
    public static double get(final double[][] llllllllllllllIllIlIlIIIIIIIIIll, final long llllllllllllllIllIlIlIIIIIIIIIlI) {
        return llllllllllllllIllIlIlIIIIIIIIIll[segment(llllllllllllllIllIlIlIIIIIIIIIlI)][displacement(llllllllllllllIllIlIlIIIIIIIIIlI)];
    }
    
    public static short[][] reverse(final short[][] llllllllllllllIllIlIIlIIlllIIllI) {
        final long llllllllllllllIllIlIIlIIlllIIlIl = length(llllllllllllllIllIlIIlIIlllIIllI);
        long llllllllllllllIllIlIIlIIlllIIlll = llllllllllllllIllIlIIlIIlllIIlIl / 2L;
        while (llllllllllllllIllIlIIlIIlllIIlll-- != 0L) {
            swap(llllllllllllllIllIlIIlIIlllIIllI, llllllllllllllIllIlIIlIIlllIIlll, llllllllllllllIllIlIIlIIlllIIlIl - llllllllllllllIllIlIIlIIlllIIlll - 1L);
        }
        return llllllllllllllIllIlIIlIIlllIIllI;
    }
    
    public static float[][] grow(final float[][] llllllllllllllIllIlIIIIlIIIllIII, final long llllllllllllllIllIlIIIIlIIIlIlII) {
        final long llllllllllllllIllIlIIIIlIIIlIllI = length(llllllllllllllIllIlIIIIlIIIllIII);
        return (llllllllllllllIllIlIIIIlIIIlIlII > llllllllllllllIllIlIIIIlIIIlIllI) ? grow(llllllllllllllIllIlIIIIlIIIllIII, llllllllllllllIllIlIIIIlIIIlIlII, llllllllllllllIllIlIIIIlIIIlIllI) : llllllllllllllIllIlIIIIlIIIllIII;
    }
    
    public static char[][] shuffle(final char[][] llllllllllllllIllIlIIIIllllIlllI, final Random llllllllllllllIllIlIIIIllllIlIll) {
        long llllllllllllllIllIlIIIIllllIllll = length(llllllllllllllIllIlIIIIllllIlllI);
        while (llllllllllllllIllIlIIIIllllIllll-- != 0L) {
            final long llllllllllllllIllIlIIIIlllllIIIl = (llllllllllllllIllIlIIIIllllIlIll.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIIIllllIllll + 1L);
            final char llllllllllllllIllIlIIIIlllllIIII = get(llllllllllllllIllIlIIIIllllIlllI, llllllllllllllIllIlIIIIllllIllll);
            set(llllllllllllllIllIlIIIIllllIlllI, llllllllllllllIllIlIIIIllllIllll, get(llllllllllllllIllIlIIIIllllIlllI, llllllllllllllIllIlIIIIlllllIIIl));
            set(llllllllllllllIllIlIIIIllllIlllI, llllllllllllllIllIlIIIIlllllIIIl, llllllllllllllIllIlIIIIlllllIIII);
        }
        return llllllllllllllIllIlIIIIllllIlllI;
    }
    
    public static void fill(final long[][] llllllllllllllIllIlIlIIIIlllIIIl, final long llllllllllllllIllIlIlIIIIllIIlll, final long llllllllllllllIllIlIlIIIIllIIllI, final long llllllllllllllIllIlIlIIIIllIIlIl) {
        final long llllllllllllllIllIlIlIIIIllIllIl = length(llllllllllllllIllIlIlIIIIlllIIIl);
        ensureFromTo(llllllllllllllIllIlIlIIIIllIllIl, llllllllllllllIllIlIlIIIIllIIlll, llllllllllllllIllIlIlIIIIllIIllI);
        if (llllllllllllllIllIlIlIIIIllIllIl == 0L) {
            return;
        }
        final int llllllllllllllIllIlIlIIIIllIllII = segment(llllllllllllllIllIlIlIIIIllIIlll);
        int llllllllllllllIllIlIlIIIIllIlIll = segment(llllllllllllllIllIlIlIIIIllIIllI);
        final int llllllllllllllIllIlIlIIIIllIlIlI = displacement(llllllllllllllIllIlIlIIIIllIIlll);
        final int llllllllllllllIllIlIlIIIIllIlIIl = displacement(llllllllllllllIllIlIlIIIIllIIllI);
        if (llllllllllllllIllIlIlIIIIllIllII == llllllllllllllIllIlIlIIIIllIlIll) {
            Arrays.fill(llllllllllllllIllIlIlIIIIlllIIIl[llllllllllllllIllIlIlIIIIllIllII], llllllllllllllIllIlIlIIIIllIlIlI, llllllllllllllIllIlIlIIIIllIlIIl, llllllllllllllIllIlIlIIIIllIIlIl);
            return;
        }
        if (llllllllllllllIllIlIlIIIIllIlIIl != 0) {
            Arrays.fill(llllllllllllllIllIlIlIIIIlllIIIl[llllllllllllllIllIlIlIIIIllIlIll], 0, llllllllllllllIllIlIlIIIIllIlIIl, llllllllllllllIllIlIlIIIIllIIlIl);
        }
        while (--llllllllllllllIllIlIlIIIIllIlIll > llllllllllllllIllIlIlIIIIllIllII) {
            Arrays.fill(llllllllllllllIllIlIlIIIIlllIIIl[llllllllllllllIllIlIlIIIIllIlIll], llllllllllllllIllIlIlIIIIllIIlIl);
        }
        Arrays.fill(llllllllllllllIllIlIlIIIIlllIIIl[llllllllllllllIllIlIlIIIIllIllII], llllllllllllllIllIlIlIIIIllIlIlI, 134217728, llllllllllllllIllIlIlIIIIllIIlIl);
    }
    
    public static long index(final int llllllllllllllIllIlIllIlllIIlIII, final int llllllllllllllIllIlIllIlllIIIlIl) {
        return start(llllllllllllllIllIlIllIlllIIlIII) + llllllllllllllIllIlIllIlllIIIlIl;
    }
    
    public static void mul(final short[][] llllllllllllllIllIlIIlIIllIlIIlI, final long llllllllllllllIllIlIIlIIllIlIlII, final short llllllllllllllIllIlIIlIIllIlIIll) {
        final short[] array = llllllllllllllIllIlIIlIIllIlIIlI[segment(llllllllllllllIllIlIIlIIllIlIlII)];
        final int displacement = displacement(llllllllllllllIllIlIIlIIllIlIlII);
        array[displacement] *= llllllllllllllIllIlIIlIIllIlIIll;
    }
    
    public static byte[][] copy(final byte[][] llllllllllllllIllIlIlIlllllIlIll, final long llllllllllllllIllIlIlIlllllIlIlI, final long llllllllllllllIllIlIlIlllllIlIIl) {
        ensureOffsetLength(llllllllllllllIllIlIlIlllllIlIll, llllllllllllllIllIlIlIlllllIlIlI, llllllllllllllIllIlIlIlllllIlIIl);
        final byte[][] llllllllllllllIllIlIlIlllllIlIII = ByteBigArrays.newBigArray(llllllllllllllIllIlIlIlllllIlIIl);
        copy(llllllllllllllIllIlIlIlllllIlIll, llllllllllllllIllIlIlIlllllIlIlI, llllllllllllllIllIlIlIlllllIlIII, 0L, llllllllllllllIllIlIlIlllllIlIIl);
        return llllllllllllllIllIlIlIlllllIlIII;
    }
    
    public static long length(final short[][] llllllllllllllIllIlIIlIIllIIIIIl) {
        final int llllllllllllllIllIlIIlIIllIIIIII = llllllllllllllIllIlIIlIIllIIIIIl.length;
        return (llllllllllllllIllIlIIlIIllIIIIII == 0) ? 0L : (start(llllllllllllllIllIlIIlIIllIIIIII - 1) + llllllllllllllIllIlIIlIIllIIIIIl[llllllllllllllIllIlIIlIIllIIIIII - 1].length);
    }
    
    public static <K> void set(final K[][] llllllllllllllIllIlIIIIIIlIIllII, final long llllllllllllllIllIlIIIIIIlIIlllI, final K llllllllllllllIllIlIIIIIIlIIlIlI) {
        llllllllllllllIllIlIIIIIIlIIllII[segment(llllllllllllllIllIlIIIIIIlIIlllI)][displacement(llllllllllllllIllIlIIIIIIlIIlllI)] = llllllllllllllIllIlIIIIIIlIIlIlI;
    }
    
    public static void set(final float[][] llllllllllllllIllIlIIIIlllIllllI, final long llllllllllllllIllIlIIIIlllIllIlI, final float llllllllllllllIllIlIIIIlllIlllII) {
        llllllllllllllIllIlIIIIlllIllllI[segment(llllllllllllllIllIlIIIIlllIllIlI)][displacement(llllllllllllllIllIlIIIIlllIllIlI)] = llllllllllllllIllIlIIIIlllIlllII;
    }
    
    public static String toString(final double[][] llllllllllllllIllIlIIllIlIlllIIl) {
        if (llllllllllllllIllIlIIllIlIlllIIl == null) {
            return "null";
        }
        final long llllllllllllllIllIlIIllIlIlllIII = length(llllllllllllllIllIlIIllIlIlllIIl) - 1L;
        if (llllllllllllllIllIlIIllIlIlllIII == -1L) {
            return "[]";
        }
        final StringBuilder llllllllllllllIllIlIIllIlIllIlll = new StringBuilder();
        llllllllllllllIllIlIIllIlIllIlll.append('[');
        long llllllllllllllIllIlIIllIlIlllIlI = 0L;
        while (true) {
            llllllllllllllIllIlIIllIlIllIlll.append(String.valueOf(get(llllllllllllllIllIlIIllIlIlllIIl, llllllllllllllIllIlIIllIlIlllIlI)));
            if (llllllllllllllIllIlIIllIlIlllIlI == llllllllllllllIllIlIIllIlIlllIII) {
                break;
            }
            llllllllllllllIllIlIIllIlIllIlll.append(", ");
            ++llllllllllllllIllIlIIllIlIlllIlI;
        }
        return String.valueOf(llllllllllllllIllIlIIllIlIllIlll.append(']'));
    }
    
    public static void ensureOffsetLength(final double[][] llllllllllllllIllIlIIllIlIlIIllI, final long llllllllllllllIllIlIIllIlIlIIIlI, final long llllllllllllllIllIlIIllIlIlIIlII) {
        ensureOffsetLength(length(llllllllllllllIllIlIIllIlIlIIllI), llllllllllllllIllIlIIllIlIlIIIlI, llllllllllllllIllIlIIllIlIlIIlII);
    }
    
    public static long length(final char[][] llllllllllllllIllIlIIIllIIllIIII) {
        final int llllllllllllllIllIlIIIllIIllIIIl = llllllllllllllIllIlIIIllIIllIIII.length;
        return (llllllllllllllIllIlIIIllIIllIIIl == 0) ? 0L : (start(llllllllllllllIllIlIIIllIIllIIIl - 1) + llllllllllllllIllIlIIIllIIllIIII[llllllllllllllIllIlIIIllIIllIIIl - 1].length);
    }
    
    public static long[][] forceCapacity(final long[][] llllllllllllllIllIlIlIIIlllIIIII, final long llllllllllllllIllIlIlIIIllIlllll, final long llllllllllllllIllIlIlIIIllIllllI) {
        ensureLength(llllllllllllllIllIlIlIIIllIlllll);
        final int llllllllllllllIllIlIlIIIllIlllIl = llllllllllllllIllIlIlIIIlllIIIII.length - ((llllllllllllllIllIlIlIIIlllIIIII.length != 0 && (llllllllllllllIllIlIlIIIlllIIIII.length <= 0 || llllllllllllllIllIlIlIIIlllIIIII[llllllllllllllIllIlIlIIIlllIIIII.length - 1].length != 134217728)) ? 1 : 0);
        final int llllllllllllllIllIlIlIIIllIlllII = (int)(llllllllllllllIllIlIlIIIllIlllll + 134217727L >>> 27);
        final long[][] llllllllllllllIllIlIlIIIllIllIll = Arrays.copyOf(llllllllllllllIllIlIlIIIlllIIIII, llllllllllllllIllIlIlIIIllIlllII);
        final int llllllllllllllIllIlIlIIIllIllIlI = (int)(llllllllllllllIllIlIlIIIllIlllll & 0x7FFFFFFL);
        if (llllllllllllllIllIlIlIIIllIllIlI != 0) {
            for (int llllllllllllllIllIlIlIIIlllIIIlI = llllllllllllllIllIlIlIIIllIlllIl; llllllllllllllIllIlIlIIIlllIIIlI < llllllllllllllIllIlIlIIIllIlllII - 1; ++llllllllllllllIllIlIlIIIlllIIIlI) {
                llllllllllllllIllIlIlIIIllIllIll[llllllllllllllIllIlIlIIIlllIIIlI] = new long[134217728];
            }
            llllllllllllllIllIlIlIIIllIllIll[llllllllllllllIllIlIlIIIllIlllII - 1] = new long[llllllllllllllIllIlIlIIIllIllIlI];
        }
        else {
            for (int llllllllllllllIllIlIlIIIlllIIIIl = llllllllllllllIllIlIlIIIllIlllIl; llllllllllllllIllIlIlIIIlllIIIIl < llllllllllllllIllIlIlIIIllIlllII; ++llllllllllllllIllIlIlIIIlllIIIIl) {
                llllllllllllllIllIlIlIIIllIllIll[llllllllllllllIllIlIlIIIlllIIIIl] = new long[134217728];
            }
        }
        if (llllllllllllllIllIlIlIIIllIllllI - llllllllllllllIllIlIlIIIllIlllIl * 134217728L > 0L) {
            copy(llllllllllllllIllIlIlIIIlllIIIII, llllllllllllllIllIlIlIIIllIlllIl * 134217728L, llllllllllllllIllIlIlIIIllIllIll, llllllllllllllIllIlIlIIIllIlllIl * 134217728L, llllllllllllllIllIlIlIIIllIllllI - llllllllllllllIllIlIlIIIllIlllIl * 134217728L);
        }
        return llllllllllllllIllIlIlIIIllIllIll;
    }
    
    public static byte[][] ensureCapacity(final byte[][] llllllllllllllIllIlIllIIIIlIIIlI, final long llllllllllllllIllIlIllIIIIlIIIIl, final long llllllllllllllIllIlIllIIIIlIIIll) {
        return (llllllllllllllIllIlIllIIIIlIIIIl > length(llllllllllllllIllIlIllIIIIlIIIlI)) ? forceCapacity(llllllllllllllIllIlIllIIIIlIIIlI, llllllllllllllIllIlIllIIIIlIIIIl, llllllllllllllIllIlIllIIIIlIIIll) : llllllllllllllIllIlIllIIIIlIIIlI;
    }
    
    public static void copyToBig(final boolean[] llllllllllllllIllIlIIllIIIIIlIII, int llllllllllllllIllIlIIllIIIIIIIII, final boolean[][] llllllllllllllIllIlIIllIIIIIIllI, final long llllllllllllllIllIlIIllIIIIIIlIl, long llllllllllllllIllIlIIlIlllllllIl) {
        int llllllllllllllIllIlIIllIIIIIIIll = segment(llllllllllllllIllIlIIllIIIIIIlIl);
        int llllllllllllllIllIlIIllIIIIIIIlI = displacement(llllllllllllllIllIlIIllIIIIIIlIl);
        while (llllllllllllllIllIlIIlIlllllllIl > 0L) {
            final int llllllllllllllIllIlIIllIIIIIlIIl = (int)Math.min(llllllllllllllIllIlIIllIIIIIIllI[llllllllllllllIllIlIIllIIIIIIIll].length - llllllllllllllIllIlIIllIIIIIIIlI, llllllllllllllIllIlIIlIlllllllIl);
            if (llllllllllllllIllIlIIllIIIIIlIIl == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIllIIIIIlIII, llllllllllllllIllIlIIllIIIIIIIII, llllllllllllllIllIlIIllIIIIIIllI[llllllllllllllIllIlIIllIIIIIIIll], llllllllllllllIllIlIIllIIIIIIIlI, llllllllllllllIllIlIIllIIIIIlIIl);
            if ((llllllllllllllIllIlIIllIIIIIIIlI += llllllllllllllIllIlIIllIIIIIlIIl) == 134217728) {
                llllllllllllllIllIlIIllIIIIIIIlI = 0;
                ++llllllllllllllIllIlIIllIIIIIIIll;
            }
            llllllllllllllIllIlIIllIIIIIIIII += llllllllllllllIllIlIIllIIIIIlIIl;
            llllllllllllllIllIlIIlIlllllllIl -= llllllllllllllIllIlIIllIIIIIlIIl;
        }
    }
    
    public static void mul(final char[][] llllllllllllllIllIlIIIllIlIIIIll, final long llllllllllllllIllIlIIIllIlIIIIlI, final char llllllllllllllIllIlIIIllIlIIIlII) {
        final char[] array = llllllllllllllIllIlIIIllIlIIIIll[segment(llllllllllllllIllIlIIIllIlIIIIlI)];
        final int displacement = displacement(llllllllllllllIllIlIIIllIlIIIIlI);
        array[displacement] *= llllllllllllllIllIlIIIllIlIIIlII;
    }
    
    public static boolean[][] forceCapacity(final boolean[][] llllllllllllllIllIlIIlIllllIIIII, final long llllllllllllllIllIlIIlIlllIllIII, final long llllllllllllllIllIlIIlIlllIllllI) {
        ensureLength(llllllllllllllIllIlIIlIlllIllIII);
        final int llllllllllllllIllIlIIlIlllIlllIl = llllllllllllllIllIlIIlIllllIIIII.length - ((llllllllllllllIllIlIIlIllllIIIII.length != 0 && (llllllllllllllIllIlIIlIllllIIIII.length <= 0 || llllllllllllllIllIlIIlIllllIIIII[llllllllllllllIllIlIIlIllllIIIII.length - 1].length != 134217728)) ? 1 : 0);
        final int llllllllllllllIllIlIIlIlllIlllII = (int)(llllllllllllllIllIlIIlIlllIllIII + 134217727L >>> 27);
        final boolean[][] llllllllllllllIllIlIIlIlllIllIll = Arrays.copyOf(llllllllllllllIllIlIIlIllllIIIII, llllllllllllllIllIlIIlIlllIlllII);
        final int llllllllllllllIllIlIIlIlllIllIlI = (int)(llllllllllllllIllIlIIlIlllIllIII & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIlIlllIllIlI != 0) {
            for (int llllllllllllllIllIlIIlIllllIIIlI = llllllllllllllIllIlIIlIlllIlllIl; llllllllllllllIllIlIIlIllllIIIlI < llllllllllllllIllIlIIlIlllIlllII - 1; ++llllllllllllllIllIlIIlIllllIIIlI) {
                llllllllllllllIllIlIIlIlllIllIll[llllllllllllllIllIlIIlIllllIIIlI] = new boolean[134217728];
            }
            llllllllllllllIllIlIIlIlllIllIll[llllllllllllllIllIlIIlIlllIlllII - 1] = new boolean[llllllllllllllIllIlIIlIlllIllIlI];
        }
        else {
            for (int llllllllllllllIllIlIIlIllllIIIIl = llllllllllllllIllIlIIlIlllIlllIl; llllllllllllllIllIlIIlIllllIIIIl < llllllllllllllIllIlIIlIlllIlllII; ++llllllllllllllIllIlIIlIllllIIIIl) {
                llllllllllllllIllIlIIlIlllIllIll[llllllllllllllIllIlIIlIllllIIIIl] = new boolean[134217728];
            }
        }
        if (llllllllllllllIllIlIIlIlllIllllI - llllllllllllllIllIlIIlIlllIlllIl * 134217728L > 0L) {
            copy(llllllllllllllIllIlIIlIllllIIIII, llllllllllllllIllIlIIlIlllIlllIl * 134217728L, llllllllllllllIllIlIIlIlllIllIll, llllllllllllllIllIlIIlIlllIlllIl * 134217728L, llllllllllllllIllIlIIlIlllIllllI - llllllllllllllIllIlIIlIlllIlllIl * 134217728L);
        }
        return llllllllllllllIllIlIIlIlllIllIll;
    }
    
    public static char[][] copy(final char[][] llllllllllllllIllIlIIIlIIlllIIlI, final long llllllllllllllIllIlIIIlIIlllIIIl, final long llllllllllllllIllIlIIIlIIlllIIII) {
        ensureOffsetLength(llllllllllllllIllIlIIIlIIlllIIlI, llllllllllllllIllIlIIIlIIlllIIIl, llllllllllllllIllIlIIIlIIlllIIII);
        final char[][] llllllllllllllIllIlIIIlIIlllIIll = CharBigArrays.newBigArray(llllllllllllllIllIlIIIlIIlllIIII);
        copy(llllllllllllllIllIlIIIlIIlllIIlI, llllllllllllllIllIlIIIlIIlllIIIl, llllllllllllllIllIlIIIlIIlllIIll, 0L, llllllllllllllIllIlIIIlIIlllIIII);
        return llllllllllllllIllIlIIIlIIlllIIll;
    }
    
    public static void add(final byte[][] llllllllllllllIllIlIllIIllIIIlII, final long llllllllllllllIllIlIllIIllIIIIll, final byte llllllllllllllIllIlIllIIllIIIIlI) {
        final byte[] array = llllllllllllllIllIlIllIIllIIIlII[segment(llllllllllllllIllIlIllIIllIIIIll)];
        final int displacement = displacement(llllllllllllllIllIlIllIIllIIIIll);
        array[displacement] += llllllllllllllIllIlIllIIllIIIIlI;
    }
    
    public static void ensureSameLength(final long[][] llllllllllllllIllIlIlIIIIIlIllIl, final long[][] llllllllllllllIllIlIlIIIIIlIllII) {
        if (length(llllllllllllllIllIlIlIIIIIlIllIl) != length(llllllllllllllIllIlIlIIIIIlIllII)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(length(llllllllllllllIllIlIlIIIIIlIllIl)).append(" != ").append(length(llllllllllllllIllIlIlIIIIIlIllII))));
        }
    }
    
    public static void copy(final boolean[][] llllllllllllllIllIlIIllIIIllIIll, final long llllllllllllllIllIlIIllIIIllIIlI, final boolean[][] llllllllllllllIllIlIIllIIIllIIIl, final long llllllllllllllIllIlIIllIIIllIIII, long llllllllllllllIllIlIIllIIIlIllll) {
        if (llllllllllllllIllIlIIllIIIllIIII <= llllllllllllllIllIlIIllIIIllIIlI) {
            int llllllllllllllIllIlIIllIIlIIIIlI = segment(llllllllllllllIllIlIIllIIIllIIlI);
            int llllllllllllllIllIlIIllIIlIIIIIl = segment(llllllllllllllIllIlIIllIIIllIIII);
            int llllllllllllllIllIlIIllIIlIIIIII = displacement(llllllllllllllIllIlIIllIIIllIIlI);
            int llllllllllllllIllIlIIllIIIllllll = displacement(llllllllllllllIllIlIIllIIIllIIII);
            while (llllllllllllllIllIlIIllIIIlIllll > 0L) {
                final int llllllllllllllIllIlIIllIIIlllllI = (int)Math.min((long)llllllllllllllIllIlIIllIIIlIllll, Math.min(llllllllllllllIllIlIIllIIIllIIll[llllllllllllllIllIlIIllIIlIIIIlI].length - llllllllllllllIllIlIIllIIlIIIIII, llllllllllllllIllIlIIllIIIllIIIl[llllllllllllllIllIlIIllIIlIIIIIl].length - llllllllllllllIllIlIIllIIIllllll));
                if (llllllllllllllIllIlIIllIIIlllllI == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIllIIIllIIll[llllllllllllllIllIlIIllIIlIIIIlI], llllllllllllllIllIlIIllIIlIIIIII, llllllllllllllIllIlIIllIIIllIIIl[llllllllllllllIllIlIIllIIlIIIIIl], llllllllllllllIllIlIIllIIIllllll, llllllllllllllIllIlIIllIIIlllllI);
                if ((llllllllllllllIllIlIIllIIlIIIIII += llllllllllllllIllIlIIllIIIlllllI) == 134217728) {
                    llllllllllllllIllIlIIllIIlIIIIII = 0;
                    ++llllllllllllllIllIlIIllIIlIIIIlI;
                }
                if ((llllllllllllllIllIlIIllIIIllllll += llllllllllllllIllIlIIllIIIlllllI) == 134217728) {
                    llllllllllllllIllIlIIllIIIllllll = 0;
                    ++llllllllllllllIllIlIIllIIlIIIIIl;
                }
                llllllllllllllIllIlIIllIIIlIllll -= llllllllllllllIllIlIIllIIIlllllI;
            }
        }
        else {
            int llllllllllllllIllIlIIllIIIllllIl = segment((long)(llllllllllllllIllIlIIllIIIllIIlI + llllllllllllllIllIlIIllIIIlIllll));
            int llllllllllllllIllIlIIllIIIllllII = segment((long)(llllllllllllllIllIlIIllIIIllIIII + llllllllllllllIllIlIIllIIIlIllll));
            int llllllllllllllIllIlIIllIIIlllIll = displacement((long)(llllllllllllllIllIlIIllIIIllIIlI + llllllllllllllIllIlIIllIIIlIllll));
            int llllllllllllllIllIlIIllIIIlllIlI = displacement((long)(llllllllllllllIllIlIIllIIIllIIII + llllllllllllllIllIlIIllIIIlIllll));
            while (llllllllllllllIllIlIIllIIIlIllll > 0L) {
                if (llllllllllllllIllIlIIllIIIlllIll == 0) {
                    llllllllllllllIllIlIIllIIIlllIll = 134217728;
                    --llllllllllllllIllIlIIllIIIllllIl;
                }
                if (llllllllllllllIllIlIIllIIIlllIlI == 0) {
                    llllllllllllllIllIlIIllIIIlllIlI = 134217728;
                    --llllllllllllllIllIlIIllIIIllllII;
                }
                final int llllllllllllllIllIlIIllIIIlllIIl = (int)Math.min((long)llllllllllllllIllIlIIllIIIlIllll, Math.min(llllllllllllllIllIlIIllIIIlllIll, llllllllllllllIllIlIIllIIIlllIlI));
                if (llllllllllllllIllIlIIllIIIlllIIl == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIllIIIllIIll[llllllllllllllIllIlIIllIIIllllIl], llllllllllllllIllIlIIllIIIlllIll - llllllllllllllIllIlIIllIIIlllIIl, llllllllllllllIllIlIIllIIIllIIIl[llllllllllllllIllIlIIllIIIllllII], llllllllllllllIllIlIIllIIIlllIlI - llllllllllllllIllIlIIllIIIlllIIl, llllllllllllllIllIlIIllIIIlllIIl);
                llllllllllllllIllIlIIllIIIlllIll -= llllllllllllllIllIlIIllIIIlllIIl;
                llllllllllllllIllIlIIllIIIlllIlI -= llllllllllllllIllIlIIllIIIlllIIl;
                llllllllllllllIllIlIIllIIIlIllll -= llllllllllllllIllIlIIllIIIlllIIl;
            }
        }
    }
    
    public static void copyFromBig(final double[][] llllllllllllllIllIlIIllllIIlIIIl, final long llllllllllllllIllIlIIllllIIlIIII, final double[] llllllllllllllIllIlIIllllIIIllll, int llllllllllllllIllIlIIllllIIIIlll, int llllllllllllllIllIlIIllllIIIllIl) {
        int llllllllllllllIllIlIIllllIIIllII = segment(llllllllllllllIllIlIIllllIIlIIII);
        int llllllllllllllIllIlIIllllIIIlIll = displacement(llllllllllllllIllIlIIllllIIlIIII);
        while (llllllllllllllIllIlIIllllIIIllIl > 0) {
            final int llllllllllllllIllIlIIllllIIlIIlI = Math.min(llllllllllllllIllIlIIllllIIlIIIl[llllllllllllllIllIlIIllllIIIllII].length - llllllllllllllIllIlIIllllIIIlIll, llllllllllllllIllIlIIllllIIIllIl);
            if (llllllllllllllIllIlIIllllIIlIIlI == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIllllIIlIIIl[llllllllllllllIllIlIIllllIIIllII], llllllllllllllIllIlIIllllIIIlIll, llllllllllllllIllIlIIllllIIIllll, llllllllllllllIllIlIIllllIIIIlll, llllllllllllllIllIlIIllllIIlIIlI);
            if ((llllllllllllllIllIlIIllllIIIlIll += llllllllllllllIllIlIIllllIIlIIlI) == 134217728) {
                llllllllllllllIllIlIIllllIIIlIll = 0;
                ++llllllllllllllIllIlIIllllIIIllII;
            }
            llllllllllllllIllIlIIllllIIIIlll += llllllllllllllIllIlIIllllIIlIIlI;
            llllllllllllllIllIlIIllllIIIllIl -= llllllllllllllIllIlIIllllIIlIIlI;
        }
    }
    
    public static void copyToBig(final byte[] llllllllllllllIllIlIllIIIlIllIII, int llllllllllllllIllIlIllIIIlIlIlll, final byte[][] llllllllllllllIllIlIllIIIlIlIllI, final long llllllllllllllIllIlIllIIIlIlllII, long llllllllllllllIllIlIllIIIlIlIlII) {
        int llllllllllllllIllIlIllIIIlIllIlI = segment(llllllllllllllIllIlIllIIIlIlllII);
        int llllllllllllllIllIlIllIIIlIllIIl = displacement(llllllllllllllIllIlIllIIIlIlllII);
        while (llllllllllllllIllIlIllIIIlIlIlII > 0L) {
            final int llllllllllllllIllIlIllIIIllIIIII = (int)Math.min(llllllllllllllIllIlIllIIIlIlIllI[llllllllllllllIllIlIllIIIlIllIlI].length - llllllllllllllIllIlIllIIIlIllIIl, llllllllllllllIllIlIllIIIlIlIlII);
            if (llllllllllllllIllIlIllIIIllIIIII == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIllIIIlIllIII, llllllllllllllIllIlIllIIIlIlIlll, llllllllllllllIllIlIllIIIlIlIllI[llllllllllllllIllIlIllIIIlIllIlI], llllllllllllllIllIlIllIIIlIllIIl, llllllllllllllIllIlIllIIIllIIIII);
            if ((llllllllllllllIllIlIllIIIlIllIIl += llllllllllllllIllIlIllIIIllIIIII) == 134217728) {
                llllllllllllllIllIlIllIIIlIllIIl = 0;
                ++llllllllllllllIllIlIllIIIlIllIlI;
            }
            llllllllllllllIllIlIllIIIlIlIlll += llllllllllllllIllIlIllIIIllIIIII;
            llllllllllllllIllIlIllIIIlIlIlII -= llllllllllllllIllIlIllIIIllIIIII;
        }
    }
    
    public static long[][] setLength(final long[][] llllllllllllllIllIlIlIIIlIIllllI, final long llllllllllllllIllIlIlIIIlIIlllIl) {
        final long llllllllllllllIllIlIlIIIlIIlllII = length(llllllllllllllIllIlIlIIIlIIllllI);
        if (llllllllllllllIllIlIlIIIlIIlllIl == llllllllllllllIllIlIlIIIlIIlllII) {
            return llllllllllllllIllIlIlIIIlIIllllI;
        }
        if (llllllllllllllIllIlIlIIIlIIlllIl < llllllllllllllIllIlIlIIIlIIlllII) {
            return trim(llllllllllllllIllIlIlIIIlIIllllI, llllllllllllllIllIlIlIIIlIIlllIl);
        }
        return ensureCapacity(llllllllllllllIllIlIlIIIlIIllllI, llllllllllllllIllIlIlIIIlIIlllIl);
    }
    
    public static void mergeSort(final long llllllllllllllIllIlIllIlIlIlIllI, final long llllllllllllllIllIlIllIlIlIIllll, final LongComparator llllllllllllllIllIlIllIlIlIIlllI, final BigSwapper llllllllllllllIllIlIllIlIlIIllIl) {
        final long llllllllllllllIllIlIllIlIlIlIIlI = llllllllllllllIllIlIllIlIlIIllll - llllllllllllllIllIlIllIlIlIlIllI;
        if (llllllllllllllIllIlIllIlIlIlIIlI < 7L) {
            for (long llllllllllllllIllIlIllIlIlIlIlll = llllllllllllllIllIlIllIlIlIlIllI; llllllllllllllIllIlIllIlIlIlIlll < llllllllllllllIllIlIllIlIlIIllll; ++llllllllllllllIllIlIllIlIlIlIlll) {
                for (long llllllllllllllIllIlIllIlIlIllIII = llllllllllllllIllIlIllIlIlIlIlll; llllllllllllllIllIlIllIlIlIllIII > llllllllllllllIllIlIllIlIlIlIllI && llllllllllllllIllIlIllIlIlIIlllI.compare(llllllllllllllIllIlIllIlIlIllIII - 1L, llllllllllllllIllIlIllIlIlIllIII) > 0; --llllllllllllllIllIlIllIlIlIllIII) {
                    llllllllllllllIllIlIllIlIlIIllIl.swap(llllllllllllllIllIlIllIlIlIllIII, llllllllllllllIllIlIllIlIlIllIII - 1L);
                }
            }
            return;
        }
        final long llllllllllllllIllIlIllIlIlIlIIIl = llllllllllllllIllIlIllIlIlIlIllI + llllllllllllllIllIlIllIlIlIIllll >>> 1;
        mergeSort(llllllllllllllIllIlIllIlIlIlIllI, llllllllllllllIllIlIllIlIlIlIIIl, llllllllllllllIllIlIllIlIlIIlllI, llllllllllllllIllIlIllIlIlIIllIl);
        mergeSort(llllllllllllllIllIlIllIlIlIlIIIl, llllllllllllllIllIlIllIlIlIIllll, llllllllllllllIllIlIllIlIlIIlllI, llllllllllllllIllIlIllIlIlIIllIl);
        if (llllllllllllllIllIlIllIlIlIIlllI.compare(llllllllllllllIllIlIllIlIlIlIIIl - 1L, llllllllllllllIllIlIllIlIlIlIIIl) <= 0) {
            return;
        }
        inPlaceMerge(llllllllllllllIllIlIllIlIlIlIllI, llllllllllllllIllIlIllIlIlIlIIIl, llllllllllllllIllIlIllIlIlIIllll, llllllllllllllIllIlIllIlIlIIlllI, llllllllllllllIllIlIllIlIlIIllIl);
    }
    
    public static boolean[][] shuffle(final boolean[][] llllllllllllllIllIlIIlIlIIIllIll, final long llllllllllllllIllIlIIlIlIIIllIlI, final long llllllllllllllIllIlIIlIlIIIllIIl, final Random llllllllllllllIllIlIIlIlIIIlllII) {
        long llllllllllllllIllIlIIlIlIIlIIIII = llllllllllllllIllIlIIlIlIIIllIIl - llllllllllllllIllIlIIlIlIIIllIlI;
        while (llllllllllllllIllIlIIlIlIIlIIIII-- != 0L) {
            final long llllllllllllllIllIlIIlIlIIlIIIlI = (llllllllllllllIllIlIIlIlIIIlllII.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIlIlIIlIIIII + 1L);
            final boolean llllllllllllllIllIlIIlIlIIlIIIIl = get(llllllllllllllIllIlIIlIlIIIllIll, llllllllllllllIllIlIIlIlIIIllIlI + llllllllllllllIllIlIIlIlIIlIIIII);
            set(llllllllllllllIllIlIIlIlIIIllIll, llllllllllllllIllIlIIlIlIIIllIlI + llllllllllllllIllIlIIlIlIIlIIIII, get(llllllllllllllIllIlIIlIlIIIllIll, llllllllllllllIllIlIIlIlIIIllIlI + llllllllllllllIllIlIIlIlIIlIIIlI));
            set(llllllllllllllIllIlIIlIlIIIllIll, llllllllllllllIllIlIIlIlIIIllIlI + llllllllllllllIllIlIIlIlIIlIIIlI, llllllllllllllIllIlIIlIlIIlIIIIl);
        }
        return llllllllllllllIllIlIIlIlIIIllIll;
    }
    
    public static int[][] reverse(final int[][] llllllllllllllIllIlIlIllIIlllIll) {
        final long llllllllllllllIllIlIlIllIIllllII = length(llllllllllllllIllIlIlIllIIlllIll);
        long llllllllllllllIllIlIlIllIIlllllI = llllllllllllllIllIlIlIllIIllllII / 2L;
        while (llllllllllllllIllIlIlIllIIlllllI-- != 0L) {
            swap(llllllllllllllIllIlIlIllIIlllIll, llllllllllllllIllIlIlIllIIlllllI, llllllllllllllIllIlIlIllIIllllII - llllllllllllllIllIlIlIllIIlllllI - 1L);
        }
        return llllllllllllllIllIlIlIllIIlllIll;
    }
    
    public static void incr(final char[][] llllllllllllllIllIlIIIllIIllllII, final long llllllllllllllIllIlIIIllIIlllIll) {
        final char[] array = llllllllllllllIllIlIIIllIIllllII[segment(llllllllllllllIllIlIIIllIIlllIll)];
        final int displacement = displacement(llllllllllllllIllIlIIIllIIlllIll);
        ++array[displacement];
    }
    
    public static double[][] copy(final double[][] llllllllllllllIllIlIIlllIIIIIIIl, final long llllllllllllllIllIlIIlllIIIIIlII, final long llllllllllllllIllIlIIllIllllllll) {
        ensureOffsetLength(llllllllllllllIllIlIIlllIIIIIIIl, llllllllllllllIllIlIIlllIIIIIlII, llllllllllllllIllIlIIllIllllllll);
        final double[][] llllllllllllllIllIlIIlllIIIIIIlI = DoubleBigArrays.newBigArray(llllllllllllllIllIlIIllIllllllll);
        copy(llllllllllllllIllIlIIlllIIIIIIIl, llllllllllllllIllIlIIlllIIIIIlII, llllllllllllllIllIlIIlllIIIIIIlI, 0L, llllllllllllllIllIlIIllIllllllll);
        return llllllllllllllIllIlIIlllIIIIIIlI;
    }
    
    public static void fill(final float[][] llllllllllllllIllIlIIIIIllIIIlII, final long llllllllllllllIllIlIIIIIlIlllIlI, final long llllllllllllllIllIlIIIIIllIIIIlI, final float llllllllllllllIllIlIIIIIlIlllIII) {
        final long llllllllllllllIllIlIIIIIllIIIIII = length(llllllllllllllIllIlIIIIIllIIIlII);
        ensureFromTo(llllllllllllllIllIlIIIIIllIIIIII, llllllllllllllIllIlIIIIIlIlllIlI, llllllllllllllIllIlIIIIIllIIIIlI);
        if (llllllllllllllIllIlIIIIIllIIIIII == 0L) {
            return;
        }
        final int llllllllllllllIllIlIIIIIlIllllll = segment(llllllllllllllIllIlIIIIIlIlllIlI);
        int llllllllllllllIllIlIIIIIlIlllllI = segment(llllllllllllllIllIlIIIIIllIIIIlI);
        final int llllllllllllllIllIlIIIIIlIllllIl = displacement(llllllllllllllIllIlIIIIIlIlllIlI);
        final int llllllllllllllIllIlIIIIIlIllllII = displacement(llllllllllllllIllIlIIIIIllIIIIlI);
        if (llllllllllllllIllIlIIIIIlIllllll == llllllllllllllIllIlIIIIIlIlllllI) {
            Arrays.fill(llllllllllllllIllIlIIIIIllIIIlII[llllllllllllllIllIlIIIIIlIllllll], llllllllllllllIllIlIIIIIlIllllIl, llllllllllllllIllIlIIIIIlIllllII, llllllllllllllIllIlIIIIIlIlllIII);
            return;
        }
        if (llllllllllllllIllIlIIIIIlIllllII != 0) {
            Arrays.fill(llllllllllllllIllIlIIIIIllIIIlII[llllllllllllllIllIlIIIIIlIlllllI], 0, llllllllllllllIllIlIIIIIlIllllII, llllllllllllllIllIlIIIIIlIlllIII);
        }
        while (--llllllllllllllIllIlIIIIIlIlllllI > llllllllllllllIllIlIIIIIlIllllll) {
            Arrays.fill(llllllllllllllIllIlIIIIIllIIIlII[llllllllllllllIllIlIIIIIlIlllllI], llllllllllllllIllIlIIIIIlIlllIII);
        }
        Arrays.fill(llllllllllllllIllIlIIIIIllIIIlII[llllllllllllllIllIlIIIIIlIllllll], llllllllllllllIllIlIIIIIlIllllIl, 134217728, llllllllllllllIllIlIIIIIlIlllIII);
    }
    
    public static double[][] forceCapacity(final double[][] llllllllllllllIllIlIIlllIlIIlIlI, final long llllllllllllllIllIlIIlllIlIlIIII, final long llllllllllllllIllIlIIlllIlIIllll) {
        ensureLength(llllllllllllllIllIlIIlllIlIlIIII);
        final int llllllllllllllIllIlIIlllIlIIlllI = llllllllllllllIllIlIIlllIlIIlIlI.length - ((llllllllllllllIllIlIIlllIlIIlIlI.length != 0 && (llllllllllllllIllIlIIlllIlIIlIlI.length <= 0 || llllllllllllllIllIlIIlllIlIIlIlI[llllllllllllllIllIlIIlllIlIIlIlI.length - 1].length != 134217728)) ? 1 : 0);
        final int llllllllllllllIllIlIIlllIlIIllIl = (int)(llllllllllllllIllIlIIlllIlIlIIII + 134217727L >>> 27);
        final double[][] llllllllllllllIllIlIIlllIlIIllII = Arrays.copyOf(llllllllllllllIllIlIIlllIlIIlIlI, llllllllllllllIllIlIIlllIlIIllIl);
        final int llllllllllllllIllIlIIlllIlIIlIll = (int)(llllllllllllllIllIlIIlllIlIlIIII & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIlllIlIIlIll != 0) {
            for (int llllllllllllllIllIlIIlllIlIlIIll = llllllllllllllIllIlIIlllIlIIlllI; llllllllllllllIllIlIIlllIlIlIIll < llllllllllllllIllIlIIlllIlIIllIl - 1; ++llllllllllllllIllIlIIlllIlIlIIll) {
                llllllllllllllIllIlIIlllIlIIllII[llllllllllllllIllIlIIlllIlIlIIll] = new double[134217728];
            }
            llllllllllllllIllIlIIlllIlIIllII[llllllllllllllIllIlIIlllIlIIllIl - 1] = new double[llllllllllllllIllIlIIlllIlIIlIll];
        }
        else {
            for (int llllllllllllllIllIlIIlllIlIlIIlI = llllllllllllllIllIlIIlllIlIIlllI; llllllllllllllIllIlIIlllIlIlIIlI < llllllllllllllIllIlIIlllIlIIllIl; ++llllllllllllllIllIlIIlllIlIlIIlI) {
                llllllllllllllIllIlIIlllIlIIllII[llllllllllllllIllIlIIlllIlIlIIlI] = new double[134217728];
            }
        }
        if (llllllllllllllIllIlIIlllIlIIllll - llllllllllllllIllIlIIlllIlIIlllI * 134217728L > 0L) {
            copy(llllllllllllllIllIlIIlllIlIIlIlI, llllllllllllllIllIlIIlllIlIIlllI * 134217728L, llllllllllllllIllIlIIlllIlIIllII, llllllllllllllIllIlIIlllIlIIlllI * 134217728L, llllllllllllllIllIlIIlllIlIIllll - llllllllllllllIllIlIIlllIlIIlllI * 134217728L);
        }
        return llllllllllllllIllIlIIlllIlIIllII;
    }
    
    public static <K> K[][] trim(final K[][] llllllllllllllIllIIllllllIIIlIll, final long llllllllllllllIllIIllllllIIIlIlI) {
        ensureLength(llllllllllllllIllIIllllllIIIlIlI);
        final long llllllllllllllIllIIllllllIIIlIIl = length(llllllllllllllIllIIllllllIIIlIll);
        if (llllllllllllllIllIIllllllIIIlIlI >= llllllllllllllIllIIllllllIIIlIIl) {
            return llllllllllllllIllIIllllllIIIlIll;
        }
        final int llllllllllllllIllIIllllllIIIlIII = (int)(llllllllllllllIllIIllllllIIIlIlI + 134217727L >>> 27);
        final K[][] llllllllllllllIllIIllllllIIIIlll = Arrays.copyOf(llllllllllllllIllIIllllllIIIlIll, llllllllllllllIllIIllllllIIIlIII);
        final int llllllllllllllIllIIllllllIIIIllI = (int)(llllllllllllllIllIIllllllIIIlIlI & 0x7FFFFFFL);
        if (llllllllllllllIllIIllllllIIIIllI != 0) {
            llllllllllllllIllIIllllllIIIIlll[llllllllllllllIllIIllllllIIIlIII - 1] = ObjectArrays.trim(llllllllllllllIllIIllllllIIIIlll[llllllllllllllIllIIllllllIIIlIII - 1], llllllllllllllIllIIllllllIIIIllI);
        }
        return llllllllllllllIllIIllllllIIIIlll;
    }
    
    protected BigArrays() {
    }
    
    public static void fill(final short[][] llllllllllllllIllIlIIIlllllIIIlI, final long llllllllllllllIllIlIIIllllIllIII, final long llllllllllllllIllIlIIIlllllIIIII, final short llllllllllllllIllIlIIIllllIlIllI) {
        final long llllllllllllllIllIlIIIllllIllllI = length(llllllllllllllIllIlIIIlllllIIIlI);
        ensureFromTo(llllllllllllllIllIlIIIllllIllllI, llllllllllllllIllIlIIIllllIllIII, llllllllllllllIllIlIIIlllllIIIII);
        if (llllllllllllllIllIlIIIllllIllllI == 0L) {
            return;
        }
        final int llllllllllllllIllIlIIIllllIlllIl = segment(llllllllllllllIllIlIIIllllIllIII);
        int llllllllllllllIllIlIIIllllIlllII = segment(llllllllllllllIllIlIIIlllllIIIII);
        final int llllllllllllllIllIlIIIllllIllIll = displacement(llllllllllllllIllIlIIIllllIllIII);
        final int llllllllllllllIllIlIIIllllIllIlI = displacement(llllllllllllllIllIlIIIlllllIIIII);
        if (llllllllllllllIllIlIIIllllIlllIl == llllllllllllllIllIlIIIllllIlllII) {
            Arrays.fill(llllllllllllllIllIlIIIlllllIIIlI[llllllllllllllIllIlIIIllllIlllIl], llllllllllllllIllIlIIIllllIllIll, llllllllllllllIllIlIIIllllIllIlI, llllllllllllllIllIlIIIllllIlIllI);
            return;
        }
        if (llllllllllllllIllIlIIIllllIllIlI != 0) {
            Arrays.fill(llllllllllllllIllIlIIIlllllIIIlI[llllllllllllllIllIlIIIllllIlllII], 0, llllllllllllllIllIlIIIllllIllIlI, llllllllllllllIllIlIIIllllIlIllI);
        }
        while (--llllllllllllllIllIlIIIllllIlllII > llllllllllllllIllIlIIIllllIlllIl) {
            Arrays.fill(llllllllllllllIllIlIIIlllllIIIlI[llllllllllllllIllIlIIIllllIlllII], llllllllllllllIllIlIIIllllIlIllI);
        }
        Arrays.fill(llllllllllllllIllIlIIIlllllIIIlI[llllllllllllllIllIlIIIllllIlllIl], llllllllllllllIllIlIIIllllIllIll, 134217728, llllllllllllllIllIlIIIllllIlIllI);
    }
    
    public static void fill(final char[][] llllllllllllllIllIlIIIlIIllIIIIl, final char llllllllllllllIllIlIIIlIIllIIIII) {
        int llllllllllllllIllIlIIIlIIllIIIlI = llllllllllllllIllIlIIIlIIllIIIIl.length;
        while (llllllllllllllIllIlIIIlIIllIIIlI-- != 0) {
            Arrays.fill(llllllllllllllIllIlIIIlIIllIIIIl[llllllllllllllIllIlIIIlIIllIIIlI], llllllllllllllIllIlIIIlIIllIIIII);
        }
    }
    
    public static <K> void fill(final K[][] llllllllllllllIllIIlllllIlIllIll, final K llllllllllllllIllIIlllllIlIllIlI) {
        int llllllllllllllIllIIlllllIlIllllI = llllllllllllllIllIIlllllIlIllIll.length;
        while (llllllllllllllIllIIlllllIlIllllI-- != 0) {
            Arrays.fill(llllllllllllllIllIIlllllIlIllIll[llllllllllllllIllIIlllllIlIllllI], llllllllllllllIllIIlllllIlIllIlI);
        }
    }
    
    public static long length(final int[][] llllllllllllllIllIlIlIllIIIllIII) {
        final int llllllllllllllIllIlIlIllIIIlIlll = llllllllllllllIllIlIlIllIIIllIII.length;
        return (llllllllllllllIllIlIlIllIIIlIlll == 0) ? 0L : (start(llllllllllllllIllIlIlIllIIIlIlll - 1) + llllllllllllllIllIlIlIllIIIllIII[llllllllllllllIllIlIlIllIIIlIlll - 1].length);
    }
    
    public static <K> void copyToBig(final K[] llllllllllllllIllIIllllllllIIIll, int llllllllllllllIllIIllllllllIIIlI, final K[][] llllllllllllllIllIIllllllllIIIIl, final long llllllllllllllIllIIllllllllIIIII, long llllllllllllllIllIIlllllllIlllll) {
        int llllllllllllllIllIIllllllllIIlIl = segment(llllllllllllllIllIIllllllllIIIII);
        int llllllllllllllIllIIllllllllIIlII = displacement(llllllllllllllIllIIllllllllIIIII);
        while (llllllllllllllIllIIlllllllIlllll > 0L) {
            final int llllllllllllllIllIIllllllllIlIll = (int)Math.min(llllllllllllllIllIIllllllllIIIIl[llllllllllllllIllIIllllllllIIlIl].length - llllllllllllllIllIIllllllllIIlII, llllllllllllllIllIIlllllllIlllll);
            if (llllllllllllllIllIIllllllllIlIll == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIIllllllllIIIll, llllllllllllllIllIIllllllllIIIlI, llllllllllllllIllIIllllllllIIIIl[llllllllllllllIllIIllllllllIIlIl], llllllllllllllIllIIllllllllIIlII, llllllllllllllIllIIllllllllIlIll);
            if ((llllllllllllllIllIIllllllllIIlII += llllllllllllllIllIIllllllllIlIll) == 134217728) {
                llllllllllllllIllIIllllllllIIlII = 0;
                ++llllllllllllllIllIIllllllllIIlIl;
            }
            llllllllllllllIllIIllllllllIIIlI += llllllllllllllIllIIllllllllIlIll;
            llllllllllllllIllIIlllllllIlllll -= llllllllllllllIllIIllllllllIlIll;
        }
    }
    
    public static void decr(final short[][] llllllllllllllIllIlIIlIIllIIIlIl, final long llllllllllllllIllIlIIlIIllIIIlII) {
        final short[] array = llllllllllllllIllIlIIlIIllIIIlIl[segment(llllllllllllllIllIlIIlIIllIIIlII)];
        final int displacement = displacement(llllllllllllllIllIlIIlIIllIIIlII);
        --array[displacement];
    }
    
    public static <K> K[][] ensureCapacity(final K[][] llllllllllllllIllIIlllllllIIllll, final long llllllllllllllIllIIlllllllIIllII) {
        return ensureCapacity(llllllllllllllIllIIlllllllIIllll, llllllllllllllIllIIlllllllIIllII, length(llllllllllllllIllIIlllllllIIllll));
    }
    
    public static void copyFromBig(final boolean[][] llllllllllllllIllIlIIllIIIIllIIl, final long llllllllllllllIllIlIIllIIIIlllll, final boolean[] llllllllllllllIllIlIIllIIIIllllI, int llllllllllllllIllIlIIllIIIIlIllI, int llllllllllllllIllIlIIllIIIIlIlIl) {
        int llllllllllllllIllIlIIllIIIIllIll = segment(llllllllllllllIllIlIIllIIIIlllll);
        int llllllllllllllIllIlIIllIIIIllIlI = displacement(llllllllllllllIllIlIIllIIIIlllll);
        while (llllllllllllllIllIlIIllIIIIlIlIl > 0) {
            final int llllllllllllllIllIlIIllIIIlIIIIl = Math.min(llllllllllllllIllIlIIllIIIIllIIl[llllllllllllllIllIlIIllIIIIllIll].length - llllllllllllllIllIlIIllIIIIllIlI, llllllllllllllIllIlIIllIIIIlIlIl);
            if (llllllllllllllIllIlIIllIIIlIIIIl == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIllIIIIllIIl[llllllllllllllIllIlIIllIIIIllIll], llllllllllllllIllIlIIllIIIIllIlI, llllllllllllllIllIlIIllIIIIllllI, llllllllllllllIllIlIIllIIIIlIllI, llllllllllllllIllIlIIllIIIlIIIIl);
            if ((llllllllllllllIllIlIIllIIIIllIlI += llllllllllllllIllIlIIllIIIlIIIIl) == 134217728) {
                llllllllllllllIllIlIIllIIIIllIlI = 0;
                ++llllllllllllllIllIlIIllIIIIllIll;
            }
            llllllllllllllIllIlIIllIIIIlIllI += llllllllllllllIllIlIIllIIIlIIIIl;
            llllllllllllllIllIlIIllIIIIlIlIl -= llllllllllllllIllIlIIllIIIlIIIIl;
        }
    }
    
    public static int[][] ensureCapacity(final int[][] llllllllllllllIllIlIlIlIlIIlIlll, final long llllllllllllllIllIlIlIlIlIIllIII) {
        return ensureCapacity(llllllllllllllIllIlIlIlIlIIlIlll, llllllllllllllIllIlIlIlIlIIllIII, length(llllllllllllllIllIlIlIlIlIIlIlll));
    }
    
    public static void incr(final float[][] llllllllllllllIllIlIIIIllIlIllll, final long llllllllllllllIllIlIIIIllIlIllII) {
        final float[] array = llllllllllllllIllIlIIIIllIlIllll[segment(llllllllllllllIllIlIIIIllIlIllII)];
        final int displacement = displacement(llllllllllllllIllIlIIIIllIlIllII);
        ++array[displacement];
    }
    
    public static <K> K[][] reverse(final K[][] llllllllllllllIllIlIIIIIIIlllIIl) {
        final long llllllllllllllIllIlIIIIIIIlllIII = length(llllllllllllllIllIlIIIIIIIlllIIl);
        long llllllllllllllIllIlIIIIIIIlllIlI = llllllllllllllIllIlIIIIIIIlllIII / 2L;
        while (llllllllllllllIllIlIIIIIIIlllIlI-- != 0L) {
            swap(llllllllllllllIllIlIIIIIIIlllIIl, llllllllllllllIllIlIIIIIIIlllIlI, llllllllllllllIllIlIIIIIIIlllIII - llllllllllllllIllIlIIIIIIIlllIlI - 1L);
        }
        return llllllllllllllIllIlIIIIIIIlllIIl;
    }
    
    public static <K> K get(final K[][] llllllllllllllIllIlIIIIIIlIlIllI, final long llllllllllllllIllIlIIIIIIlIlIlIl) {
        return llllllllllllllIllIlIIIIIIlIlIllI[segment(llllllllllllllIllIlIIIIIIlIlIlIl)][displacement(llllllllllllllIllIlIIIIIIlIlIlIl)];
    }
    
    public static double[][] shuffle(final double[][] llllllllllllllIllIlIIllIIllllIll, final Random llllllllllllllIllIlIIllIIlllllII) {
        long llllllllllllllIllIlIIllIIllllllI = length(llllllllllllllIllIlIIllIIllllIll);
        while (llllllllllllllIllIlIIllIIllllllI-- != 0L) {
            final long llllllllllllllIllIlIIllIlIIIIIII = (llllllllllllllIllIlIIllIIlllllII.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIllIIllllllI + 1L);
            final double llllllllllllllIllIlIIllIIlllllll = get(llllllllllllllIllIlIIllIIllllIll, llllllllllllllIllIlIIllIIllllllI);
            set(llllllllllllllIllIlIIllIIllllIll, llllllllllllllIllIlIIllIIllllllI, get(llllllllllllllIllIlIIllIIllllIll, llllllllllllllIllIlIIllIlIIIIIII));
            set(llllllllllllllIllIlIIllIIllllIll, llllllllllllllIllIlIIllIlIIIIIII, llllllllllllllIllIlIIllIIlllllll);
        }
        return llllllllllllllIllIlIIllIIllllIll;
    }
    
    public static byte[][] copy(final byte[][] llllllllllllllIllIlIlIllllIlllll) {
        final byte[][] llllllllllllllIllIlIlIllllIllllI = llllllllllllllIllIlIlIllllIlllll.clone();
        int llllllllllllllIllIlIlIlllllIIIII = llllllllllllllIllIlIlIllllIllllI.length;
        while (llllllllllllllIllIlIlIlllllIIIII-- != 0) {
            llllllllllllllIllIlIlIllllIllllI[llllllllllllllIllIlIlIlllllIIIII] = llllllllllllllIllIlIlIllllIlllll[llllllllllllllIllIlIlIlllllIIIII].clone();
        }
        return llllllllllllllIllIlIlIllllIllllI;
    }
    
    public static void fill(final boolean[][] llllllllllllllIllIlIIlIlIlllIIIl, final long llllllllllllllIllIlIIlIlIlllIIII, final long llllllllllllllIllIlIIlIlIllIIllI, final boolean llllllllllllllIllIlIIlIlIllIIlIl) {
        final long llllllllllllllIllIlIIlIlIllIllIl = length(llllllllllllllIllIlIIlIlIlllIIIl);
        ensureFromTo(llllllllllllllIllIlIIlIlIllIllIl, llllllllllllllIllIlIIlIlIlllIIII, llllllllllllllIllIlIIlIlIllIIllI);
        if (llllllllllllllIllIlIIlIlIllIllIl == 0L) {
            return;
        }
        final int llllllllllllllIllIlIIlIlIllIllII = segment(llllllllllllllIllIlIIlIlIlllIIII);
        int llllllllllllllIllIlIIlIlIllIlIll = segment(llllllllllllllIllIlIIlIlIllIIllI);
        final int llllllllllllllIllIlIIlIlIllIlIlI = displacement(llllllllllllllIllIlIIlIlIlllIIII);
        final int llllllllllllllIllIlIIlIlIllIlIIl = displacement(llllllllllllllIllIlIIlIlIllIIllI);
        if (llllllllllllllIllIlIIlIlIllIllII == llllllllllllllIllIlIIlIlIllIlIll) {
            Arrays.fill(llllllllllllllIllIlIIlIlIlllIIIl[llllllllllllllIllIlIIlIlIllIllII], llllllllllllllIllIlIIlIlIllIlIlI, llllllllllllllIllIlIIlIlIllIlIIl, llllllllllllllIllIlIIlIlIllIIlIl);
            return;
        }
        if (llllllllllllllIllIlIIlIlIllIlIIl != 0) {
            Arrays.fill(llllllllllllllIllIlIIlIlIlllIIIl[llllllllllllllIllIlIIlIlIllIlIll], 0, llllllllllllllIllIlIIlIlIllIlIIl, llllllllllllllIllIlIIlIlIllIIlIl);
        }
        while (--llllllllllllllIllIlIIlIlIllIlIll > llllllllllllllIllIlIIlIlIllIllII) {
            Arrays.fill(llllllllllllllIllIlIIlIlIlllIIIl[llllllllllllllIllIlIIlIlIllIlIll], llllllllllllllIllIlIIlIlIllIIlIl);
        }
        Arrays.fill(llllllllllllllIllIlIIlIlIlllIIIl[llllllllllllllIllIlIIlIlIllIllII], llllllllllllllIllIlIIlIlIllIlIlI, 134217728, llllllllllllllIllIlIIlIlIllIIlIl);
    }
    
    public static byte get(final byte[][] llllllllllllllIllIlIllIIlllIIlll, final long llllllllllllllIllIlIllIIlllIlIII) {
        return llllllllllllllIllIlIllIIlllIIlll[segment(llllllllllllllIllIlIllIIlllIlIII)][displacement(llllllllllllllIllIlIllIIlllIlIII)];
    }
    
    public static void decr(final int[][] llllllllllllllIllIlIlIllIIIlllII, final long llllllllllllllIllIlIlIllIIIlllIl) {
        final int[] array = llllllllllllllIllIlIlIllIIIlllII[segment(llllllllllllllIllIlIlIllIIIlllIl)];
        final int displacement = displacement(llllllllllllllIllIlIlIllIIIlllIl);
        --array[displacement];
    }
    
    public static double[][] copy(final double[][] llllllllllllllIllIlIIllIllllIlll) {
        final double[][] llllllllllllllIllIlIIllIlllllIII = llllllllllllllIllIlIIllIllllIlll.clone();
        int llllllllllllllIllIlIIllIlllllIlI = llllllllllllllIllIlIIllIlllllIII.length;
        while (llllllllllllllIllIlIIllIlllllIlI-- != 0) {
            llllllllllllllIllIlIIllIlllllIII[llllllllllllllIllIlIIllIlllllIlI] = llllllllllllllIllIlIIllIllllIlll[llllllllllllllIllIlIIllIlllllIlI].clone();
        }
        return llllllllllllllIllIlIIllIlllllIII;
    }
    
    public static char[][] forceCapacity(final char[][] llllllllllllllIllIlIIIlIlIlllIll, final long llllllllllllllIllIlIIIlIllIIIIIl, final long llllllllllllllIllIlIIIlIllIIIIII) {
        ensureLength(llllllllllllllIllIlIIIlIllIIIIIl);
        final int llllllllllllllIllIlIIIlIlIllllll = llllllllllllllIllIlIIIlIlIlllIll.length - ((llllllllllllllIllIlIIIlIlIlllIll.length != 0 && (llllllllllllllIllIlIIIlIlIlllIll.length <= 0 || llllllllllllllIllIlIIIlIlIlllIll[llllllllllllllIllIlIIIlIlIlllIll.length - 1].length != 134217728)) ? 1 : 0);
        final int llllllllllllllIllIlIIIlIlIlllllI = (int)(llllllllllllllIllIlIIIlIllIIIIIl + 134217727L >>> 27);
        final char[][] llllllllllllllIllIlIIIlIlIllllIl = Arrays.copyOf(llllllllllllllIllIlIIIlIlIlllIll, llllllllllllllIllIlIIIlIlIlllllI);
        final int llllllllllllllIllIlIIIlIlIllllII = (int)(llllllllllllllIllIlIIIlIllIIIIIl & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIIlIlIllllII != 0) {
            for (int llllllllllllllIllIlIIIlIllIIIlII = llllllllllllllIllIlIIIlIlIllllll; llllllllllllllIllIlIIIlIllIIIlII < llllllllllllllIllIlIIIlIlIlllllI - 1; ++llllllllllllllIllIlIIIlIllIIIlII) {
                llllllllllllllIllIlIIIlIlIllllIl[llllllllllllllIllIlIIIlIllIIIlII] = new char[134217728];
            }
            llllllllllllllIllIlIIIlIlIllllIl[llllllllllllllIllIlIIIlIlIlllllI - 1] = new char[llllllllllllllIllIlIIIlIlIllllII];
        }
        else {
            for (int llllllllllllllIllIlIIIlIllIIIIll = llllllllllllllIllIlIIIlIlIllllll; llllllllllllllIllIlIIIlIllIIIIll < llllllllllllllIllIlIIIlIlIlllllI; ++llllllllllllllIllIlIIIlIllIIIIll) {
                llllllllllllllIllIlIIIlIlIllllIl[llllllllllllllIllIlIIIlIllIIIIll] = new char[134217728];
            }
        }
        if (llllllllllllllIllIlIIIlIllIIIIII - llllllllllllllIllIlIIIlIlIllllll * 134217728L > 0L) {
            copy(llllllllllllllIllIlIIIlIlIlllIll, llllllllllllllIllIlIIIlIlIllllll * 134217728L, llllllllllllllIllIlIIIlIlIllllIl, llllllllllllllIllIlIIIlIlIllllll * 134217728L, llllllllllllllIllIlIIIlIllIIIIII - llllllllllllllIllIlIIIlIlIllllll * 134217728L);
        }
        return llllllllllllllIllIlIIIlIlIllllIl;
    }
    
    public static void incr(final double[][] llllllllllllllIllIlIIlllllIIllIl, final long llllllllllllllIllIlIIlllllIIlIlI) {
        final double[] array = llllllllllllllIllIlIIlllllIIllIl[segment(llllllllllllllIllIlIIlllllIIlIlI)];
        final int displacement = displacement(llllllllllllllIllIlIIlllllIIlIlI);
        ++array[displacement];
    }
    
    public static byte[][] reverse(final byte[][] llllllllllllllIllIlIllIIllIIllII) {
        final long llllllllllllllIllIlIllIIllIIlIll = length(llllllllllllllIllIlIllIIllIIllII);
        long llllllllllllllIllIlIllIIllIIllIl = llllllllllllllIllIlIllIIllIIlIll / 2L;
        while (llllllllllllllIllIlIllIIllIIllIl-- != 0L) {
            swap(llllllllllllllIllIlIllIIllIIllII, llllllllllllllIllIlIllIIllIIllIl, llllllllllllllIllIlIllIIllIIlIll - llllllllllllllIllIlIllIIllIIllIl - 1L);
        }
        return llllllllllllllIllIlIllIIllIIllII;
    }
    
    public static short[][] copy(final short[][] llllllllllllllIllIlIIlIIIIIIIlIl, final long llllllllllllllIllIlIIlIIIIIIIlII, final long llllllllllllllIllIlIIIllllllllll) {
        ensureOffsetLength(llllllllllllllIllIlIIlIIIIIIIlIl, llllllllllllllIllIlIIlIIIIIIIlII, llllllllllllllIllIlIIIllllllllll);
        final short[][] llllllllllllllIllIlIIlIIIIIIIIlI = ShortBigArrays.newBigArray(llllllllllllllIllIlIIIllllllllll);
        copy(llllllllllllllIllIlIIlIIIIIIIlIl, llllllllllllllIllIlIIlIIIIIIIlII, llllllllllllllIllIlIIlIIIIIIIIlI, 0L, llllllllllllllIllIlIIIllllllllll);
        return llllllllllllllIllIlIIlIIIIIIIIlI;
    }
    
    public static char[][] ensureCapacity(final char[][] llllllllllllllIllIlIIIlIlIllIIII, final long llllllllllllllIllIlIIIlIlIlIllll, final long llllllllllllllIllIlIIIlIlIlIlIll) {
        return (llllllllllllllIllIlIIIlIlIlIllll > length(llllllllllllllIllIlIIIlIlIllIIII)) ? forceCapacity(llllllllllllllIllIlIIIlIlIllIIII, llllllllllllllIllIlIIIlIlIlIllll, llllllllllllllIllIlIIIlIlIlIlIll) : llllllllllllllIllIlIIIlIlIllIIII;
    }
    
    public static short[][] forceCapacity(final short[][] llllllllllllllIllIlIIlIIIlIIlIlI, final long llllllllllllllIllIlIIlIIIlIlIIII, final long llllllllllllllIllIlIIlIIIlIIllll) {
        ensureLength(llllllllllllllIllIlIIlIIIlIlIIII);
        final int llllllllllllllIllIlIIlIIIlIIlllI = llllllllllllllIllIlIIlIIIlIIlIlI.length - ((llllllllllllllIllIlIIlIIIlIIlIlI.length != 0 && (llllllllllllllIllIlIIlIIIlIIlIlI.length <= 0 || llllllllllllllIllIlIIlIIIlIIlIlI[llllllllllllllIllIlIIlIIIlIIlIlI.length - 1].length != 134217728)) ? 1 : 0);
        final int llllllllllllllIllIlIIlIIIlIIllIl = (int)(llllllllllllllIllIlIIlIIIlIlIIII + 134217727L >>> 27);
        final short[][] llllllllllllllIllIlIIlIIIlIIllII = Arrays.copyOf(llllllllllllllIllIlIIlIIIlIIlIlI, llllllllllllllIllIlIIlIIIlIIllIl);
        final int llllllllllllllIllIlIIlIIIlIIlIll = (int)(llllllllllllllIllIlIIlIIIlIlIIII & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIlIIIlIIlIll != 0) {
            for (int llllllllllllllIllIlIIlIIIlIlIIll = llllllllllllllIllIlIIlIIIlIIlllI; llllllllllllllIllIlIIlIIIlIlIIll < llllllllllllllIllIlIIlIIIlIIllIl - 1; ++llllllllllllllIllIlIIlIIIlIlIIll) {
                llllllllllllllIllIlIIlIIIlIIllII[llllllllllllllIllIlIIlIIIlIlIIll] = new short[134217728];
            }
            llllllllllllllIllIlIIlIIIlIIllII[llllllllllllllIllIlIIlIIIlIIllIl - 1] = new short[llllllllllllllIllIlIIlIIIlIIlIll];
        }
        else {
            for (int llllllllllllllIllIlIIlIIIlIlIIlI = llllllllllllllIllIlIIlIIIlIIlllI; llllllllllllllIllIlIIlIIIlIlIIlI < llllllllllllllIllIlIIlIIIlIIllIl; ++llllllllllllllIllIlIIlIIIlIlIIlI) {
                llllllllllllllIllIlIIlIIIlIIllII[llllllllllllllIllIlIIlIIIlIlIIlI] = new short[134217728];
            }
        }
        if (llllllllllllllIllIlIIlIIIlIIllll - llllllllllllllIllIlIIlIIIlIIlllI * 134217728L > 0L) {
            copy(llllllllllllllIllIlIIlIIIlIIlIlI, llllllllllllllIllIlIIlIIIlIIlllI * 134217728L, llllllllllllllIllIlIIlIIIlIIllII, llllllllllllllIllIlIIlIIIlIIlllI * 134217728L, llllllllllllllIllIlIIlIIIlIIllll - llllllllllllllIllIlIIlIIIlIIlllI * 134217728L);
        }
        return llllllllllllllIllIlIIlIIIlIIllII;
    }
    
    public static float[][] shuffle(final float[][] llllllllllllllIllIlIIIIIIlIlllll, final Random llllllllllllllIllIlIIIIIIlIllllI) {
        long llllllllllllllIllIlIIIIIIllIIIII = length(llllllllllllllIllIlIIIIIIlIlllll);
        while (llllllllllllllIllIlIIIIIIllIIIII-- != 0L) {
            final long llllllllllllllIllIlIIIIIIllIIIlI = (llllllllllllllIllIlIIIIIIlIllllI.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIIIIIllIIIII + 1L);
            final float llllllllllllllIllIlIIIIIIllIIIIl = get(llllllllllllllIllIlIIIIIIlIlllll, llllllllllllllIllIlIIIIIIllIIIII);
            set(llllllllllllllIllIlIIIIIIlIlllll, llllllllllllllIllIlIIIIIIllIIIII, get(llllllllllllllIllIlIIIIIIlIlllll, llllllllllllllIllIlIIIIIIllIIIlI));
            set(llllllllllllllIllIlIIIIIIlIlllll, llllllllllllllIllIlIIIIIIllIIIlI, llllllllllllllIllIlIIIIIIllIIIIl);
        }
        return llllllllllllllIllIlIIIIIIlIlllll;
    }
    
    public static void ensureSameLength(final double[][] llllllllllllllIllIlIIllIlIIllllI, final double[][] llllllllllllllIllIlIIllIlIIllIll) {
        if (length(llllllllllllllIllIlIIllIlIIllllI) != length(llllllllllllllIllIlIIllIlIIllIll)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(length(llllllllllllllIllIlIIllIlIIllllI)).append(" != ").append(length(llllllllllllllIllIlIIllIlIIllIll))));
        }
    }
    
    public static float[][] trim(final float[][] llllllllllllllIllIlIIIIlIIIIIIII, final long llllllllllllllIllIlIIIIIllllllll) {
        ensureLength(llllllllllllllIllIlIIIIIllllllll);
        final long llllllllllllllIllIlIIIIIlllllllI = length(llllllllllllllIllIlIIIIlIIIIIIII);
        if (llllllllllllllIllIlIIIIIllllllll >= llllllllllllllIllIlIIIIIlllllllI) {
            return llllllllllllllIllIlIIIIlIIIIIIII;
        }
        final int llllllllllllllIllIlIIIIIllllllIl = (int)(llllllllllllllIllIlIIIIIllllllll + 134217727L >>> 27);
        final float[][] llllllllllllllIllIlIIIIIllllllII = Arrays.copyOf(llllllllllllllIllIlIIIIlIIIIIIII, llllllllllllllIllIlIIIIIllllllIl);
        final int llllllllllllllIllIlIIIIIlllllIll = (int)(llllllllllllllIllIlIIIIIllllllll & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIIIIlllllIll != 0) {
            llllllllllllllIllIlIIIIIllllllII[llllllllllllllIllIlIIIIIllllllIl - 1] = FloatArrays.trim(llllllllllllllIllIlIIIIIllllllII[llllllllllllllIllIlIIIIIllllllIl - 1], llllllllllllllIllIlIIIIIlllllIll);
        }
        return llllllllllllllIllIlIIIIIllllllII;
    }
    
    public static void ensureFromTo(final long llllllllllllllIllIlIllIlllIIIIIl, final long llllllllllllllIllIlIllIlllIIIIII, final long llllllllllllllIllIlIllIllIllllII) {
        if (llllllllllllllIllIlIllIlllIIIIII < 0L) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Start index (").append(llllllllllllllIllIlIllIlllIIIIII).append(") is negative")));
        }
        if (llllllllllllllIllIlIllIlllIIIIII > llllllllllllllIllIlIllIllIllllII) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Start index (").append(llllllllllllllIllIlIllIlllIIIIII).append(") is greater than end index (").append(llllllllllllllIllIlIllIllIllllII).append(")")));
        }
        if (llllllllllllllIllIlIllIllIllllII > llllllllllllllIllIlIllIlllIIIIIl) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(llllllllllllllIllIlIllIllIllllII).append(") is greater than big-array length (").append(llllllllllllllIllIlIllIlllIIIIIl).append(")")));
        }
    }
    
    public static String toString(final short[][] llllllllllllllIllIlIIIlllIlllIIl) {
        if (llllllllllllllIllIlIIIlllIlllIIl == null) {
            return "null";
        }
        final long llllllllllllllIllIlIIIlllIlllIII = length(llllllllllllllIllIlIIIlllIlllIIl) - 1L;
        if (llllllllllllllIllIlIIIlllIlllIII == -1L) {
            return "[]";
        }
        final StringBuilder llllllllllllllIllIlIIIlllIllIlll = new StringBuilder();
        llllllllllllllIllIlIIIlllIllIlll.append('[');
        long llllllllllllllIllIlIIIlllIlllIlI = 0L;
        while (true) {
            llllllllllllllIllIlIIIlllIllIlll.append(String.valueOf(get(llllllllllllllIllIlIIIlllIlllIIl, llllllllllllllIllIlIIIlllIlllIlI)));
            if (llllllllllllllIllIlIIIlllIlllIlI == llllllllllllllIllIlIIIlllIlllIII) {
                break;
            }
            llllllllllllllIllIlIIIlllIllIlll.append(", ");
            ++llllllllllllllIllIlIIIlllIlllIlI;
        }
        return String.valueOf(llllllllllllllIllIlIIIlllIllIlll.append(']'));
    }
    
    public static void set(final char[][] llllllllllllllIllIlIIIllIllIllIl, final long llllllllllllllIllIlIIIllIllIllII, final char llllllllllllllIllIlIIIllIllIlIll) {
        llllllllllllllIllIlIIIllIllIllIl[segment(llllllllllllllIllIlIIIllIllIllII)][displacement(llllllllllllllIllIlIIIllIllIllII)] = llllllllllllllIllIlIIIllIllIlIll;
    }
    
    public static long length(final long[][] llllllllllllllIllIlIlIIlIlIlIIII) {
        final int llllllllllllllIllIlIlIIlIlIIllll = llllllllllllllIllIlIlIIlIlIlIIII.length;
        return (llllllllllllllIllIlIlIIlIlIIllll == 0) ? 0L : (start(llllllllllllllIllIlIlIIlIlIIllll - 1) + llllllllllllllIllIlIlIIlIlIlIIII[llllllllllllllIllIlIlIIlIlIIllll - 1].length);
    }
    
    public static boolean[][] reverse(final boolean[][] llllllllllllllIllIlIIllIIlIlIlll) {
        final long llllllllllllllIllIlIIllIIlIlIllI = length(llllllllllllllIllIlIIllIIlIlIlll);
        long llllllllllllllIllIlIIllIIlIllIII = llllllllllllllIllIlIIllIIlIlIllI / 2L;
        while (llllllllllllllIllIlIIllIIlIllIII-- != 0L) {
            swap(llllllllllllllIllIlIIllIIlIlIlll, llllllllllllllIllIlIIllIIlIllIII, llllllllllllllIllIlIIllIIlIlIllI - llllllllllllllIllIlIIllIIlIllIII - 1L);
        }
        return llllllllllllllIllIlIIllIIlIlIlll;
    }
    
    public static void copyFromBig(final int[][] llllllllllllllIllIlIlIlIlllIIlIl, final long llllllllllllllIllIlIlIlIllIlllIl, final int[] llllllllllllllIllIlIlIlIlllIIIll, int llllllllllllllIllIlIlIlIllIllIlI, int llllllllllllllIllIlIlIlIllIllIII) {
        int llllllllllllllIllIlIlIlIlllIIIII = segment(llllllllllllllIllIlIlIlIllIlllIl);
        int llllllllllllllIllIlIlIlIllIlllll = displacement(llllllllllllllIllIlIlIlIllIlllIl);
        while (llllllllllllllIllIlIlIlIllIllIII > 0) {
            final int llllllllllllllIllIlIlIlIlllIIllI = Math.min(llllllllllllllIllIlIlIlIlllIIlIl[llllllllllllllIllIlIlIlIlllIIIII].length - llllllllllllllIllIlIlIlIllIlllll, llllllllllllllIllIlIlIlIllIllIII);
            if (llllllllllllllIllIlIlIlIlllIIllI == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIlIlIlllIIlIl[llllllllllllllIllIlIlIlIlllIIIII], llllllllllllllIllIlIlIlIllIlllll, llllllllllllllIllIlIlIlIlllIIIll, llllllllllllllIllIlIlIlIllIllIlI, llllllllllllllIllIlIlIlIlllIIllI);
            if ((llllllllllllllIllIlIlIlIllIlllll += llllllllllllllIllIlIlIlIlllIIllI) == 134217728) {
                llllllllllllllIllIlIlIlIllIlllll = 0;
                ++llllllllllllllIllIlIlIlIlllIIIII;
            }
            llllllllllllllIllIlIlIlIllIllIlI += llllllllllllllIllIlIlIlIlllIIllI;
            llllllllllllllIllIlIlIlIllIllIII -= llllllllllllllIllIlIlIlIlllIIllI;
        }
    }
    
    public static String toString(final long[][] llllllllllllllIllIlIlIIIIlIIIlIl) {
        if (llllllllllllllIllIlIlIIIIlIIIlIl == null) {
            return "null";
        }
        final long llllllllllllllIllIlIlIIIIlIIIlll = length(llllllllllllllIllIlIlIIIIlIIIlIl) - 1L;
        if (llllllllllllllIllIlIlIIIIlIIIlll == -1L) {
            return "[]";
        }
        final StringBuilder llllllllllllllIllIlIlIIIIlIIIllI = new StringBuilder();
        llllllllllllllIllIlIlIIIIlIIIllI.append('[');
        long llllllllllllllIllIlIlIIIIlIIlIIl = 0L;
        while (true) {
            llllllllllllllIllIlIlIIIIlIIIllI.append(String.valueOf(get(llllllllllllllIllIlIlIIIIlIIIlIl, llllllllllllllIllIlIlIIIIlIIlIIl)));
            if (llllllllllllllIllIlIlIIIIlIIlIIl == llllllllllllllIllIlIlIIIIlIIIlll) {
                break;
            }
            llllllllllllllIllIlIlIIIIlIIIllI.append(", ");
            ++llllllllllllllIllIlIlIIIIlIIlIIl;
        }
        return String.valueOf(llllllllllllllIllIlIlIIIIlIIIllI.append(']'));
    }
    
    public static void ensureFromTo(final long[][] llllllllllllllIllIlIlIIIIIlllllI, final long llllllllllllllIllIlIlIIIIIlllIlI, final long llllllllllllllIllIlIlIIIIIlllIIl) {
        ensureFromTo(length(llllllllllllllIllIlIlIIIIIlllllI), llllllllllllllIllIlIlIIIIIlllIlI, llllllllllllllIllIlIlIIIIIlllIIl);
    }
    
    public static void ensureLength(final long llllllllllllllIllIlIllIllIllIIIl) {
        if (llllllllllllllIllIlIllIllIllIIIl < 0L) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Negative big-array size: ").append(llllllllllllllIllIlIllIllIllIIIl)));
        }
        if (llllllllllllllIllIlIllIllIllIIIl >= 288230376017494016L) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Big-array size too big: ").append(llllllllllllllIllIlIllIllIllIIIl)));
        }
    }
    
    public static void copyFromBig(final short[][] llllllllllllllIllIlIIlIIlIIIlIlI, final long llllllllllllllIllIlIIlIIlIIIlIIl, final short[] llllllllllllllIllIlIIlIIlIIIlIII, int llllllllllllllIllIlIIlIIlIIIIlll, int llllllllllllllIllIlIIlIIlIIIIllI) {
        int llllllllllllllIllIlIIlIIlIIIllII = segment(llllllllllllllIllIlIIlIIlIIIlIIl);
        int llllllllllllllIllIlIIlIIlIIIlIll = displacement(llllllllllllllIllIlIIlIIlIIIlIIl);
        while (llllllllllllllIllIlIIlIIlIIIIllI > 0) {
            final int llllllllllllllIllIlIIlIIlIIlIIlI = Math.min(llllllllllllllIllIlIIlIIlIIIlIlI[llllllllllllllIllIlIIlIIlIIIllII].length - llllllllllllllIllIlIIlIIlIIIlIll, llllllllllllllIllIlIIlIIlIIIIllI);
            if (llllllllllllllIllIlIIlIIlIIlIIlI == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIlIIlIIIlIlI[llllllllllllllIllIlIIlIIlIIIllII], llllllllllllllIllIlIIlIIlIIIlIll, llllllllllllllIllIlIIlIIlIIIlIII, llllllllllllllIllIlIIlIIlIIIIlll, llllllllllllllIllIlIIlIIlIIlIIlI);
            if ((llllllllllllllIllIlIIlIIlIIIlIll += llllllllllllllIllIlIIlIIlIIlIIlI) == 134217728) {
                llllllllllllllIllIlIIlIIlIIIlIll = 0;
                ++llllllllllllllIllIlIIlIIlIIIllII;
            }
            llllllllllllllIllIlIIlIIlIIIIlll += llllllllllllllIllIlIIlIIlIIlIIlI;
            llllllllllllllIllIlIIlIIlIIIIllI -= llllllllllllllIllIlIIlIIlIIlIIlI;
        }
    }
    
    public static void copyFromBig(final float[][] llllllllllllllIllIlIIIIlIlllIIll, final long llllllllllllllIllIlIIIIlIlllIIlI, final float[] llllllllllllllIllIlIIIIlIllIlIlI, int llllllllllllllIllIlIIIIlIllIlIIl, int llllllllllllllIllIlIIIIlIllIlIII) {
        int llllllllllllllIllIlIIIIlIllIlllI = segment(llllllllllllllIllIlIIIIlIlllIIlI);
        int llllllllllllllIllIlIIIIlIllIllIl = displacement(llllllllllllllIllIlIIIIlIlllIIlI);
        while (llllllllllllllIllIlIIIIlIllIlIII > 0) {
            final int llllllllllllllIllIlIIIIlIlllIlII = Math.min(llllllllllllllIllIlIIIIlIlllIIll[llllllllllllllIllIlIIIIlIllIlllI].length - llllllllllllllIllIlIIIIlIllIllIl, (int)llllllllllllllIllIlIIIIlIllIlIII);
            if (llllllllllllllIllIlIIIIlIlllIlII == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIIIlIlllIIll[llllllllllllllIllIlIIIIlIllIlllI], llllllllllllllIllIlIIIIlIllIllIl, llllllllllllllIllIlIIIIlIllIlIlI, llllllllllllllIllIlIIIIlIllIlIIl, llllllllllllllIllIlIIIIlIlllIlII);
            if ((llllllllllllllIllIlIIIIlIllIllIl += llllllllllllllIllIlIIIIlIlllIlII) == 134217728) {
                llllllllllllllIllIlIIIIlIllIllIl = 0;
                ++llllllllllllllIllIlIIIIlIllIlllI;
            }
            llllllllllllllIllIlIIIIlIllIlIIl += llllllllllllllIllIlIIIIlIlllIlII;
            llllllllllllllIllIlIIIIlIllIlIII -= llllllllllllllIllIlIIIIlIlllIlII;
        }
    }
    
    public static long[][] ensureCapacity(final long[][] llllllllllllllIllIlIlIIIllIIlllI, final long llllllllllllllIllIlIlIIIllIIllIl, final long llllllllllllllIllIlIlIIIllIIllII) {
        return (llllllllllllllIllIlIlIIIllIIllIl > length(llllllllllllllIllIlIlIIIllIIlllI)) ? forceCapacity(llllllllllllllIllIlIlIIIllIIlllI, llllllllllllllIllIlIlIIIllIIllIl, llllllllllllllIllIlIlIIIllIIllII) : llllllllllllllIllIlIlIIIllIIlllI;
    }
    
    private static void inPlaceMerge(final long llllllllllllllIllIlIllIllIIlIlIl, long llllllllllllllIllIlIllIllIIllllI, final long llllllllllllllIllIlIllIllIIlllIl, final LongComparator llllllllllllllIllIlIllIllIIIllll, final BigSwapper llllllllllllllIllIlIllIllIIllIll) {
        if (llllllllllllllIllIlIllIllIIlIlIl >= llllllllllllllIllIlIllIllIIllllI || llllllllllllllIllIlIllIllIIllllI >= llllllllllllllIllIlIllIllIIlllIl) {
            return;
        }
        if (llllllllllllllIllIlIllIllIIlllIl - llllllllllllllIllIlIllIllIIlIlIl == 2L) {
            if (llllllllllllllIllIlIllIllIIIllll.compare(llllllllllllllIllIlIllIllIIllllI, llllllllllllllIllIlIllIllIIlIlIl) < 0) {
                llllllllllllllIllIlIllIllIIllIll.swap(llllllllllllllIllIlIllIllIIlIlIl, llllllllllllllIllIlIllIllIIllllI);
            }
            return;
        }
        long llllllllllllllIllIlIllIllIIllIIl = 0L;
        long llllllllllllllIllIlIllIllIIllIlI = 0L;
        if (llllllllllllllIllIlIllIllIIllllI - llllllllllllllIllIlIllIllIIlIlIl > llllllllllllllIllIlIllIllIIlllIl - llllllllllllllIllIlIllIllIIllllI) {
            final long llllllllllllllIllIlIllIllIlIIIll = llllllllllllllIllIlIllIllIIlIlIl + (llllllllllllllIllIlIllIllIIllllI - llllllllllllllIllIlIllIllIIlIlIl) / 2L;
            final long llllllllllllllIllIlIllIllIlIIIlI = lowerBound(llllllllllllllIllIlIllIllIIllllI, llllllllllllllIllIlIllIllIIlllIl, llllllllllllllIllIlIllIllIlIIIll, llllllllllllllIllIlIllIllIIIllll);
        }
        else {
            llllllllllllllIllIlIllIllIIllIIl = llllllllllllllIllIlIllIllIIllllI + (llllllllllllllIllIlIllIllIIlllIl - llllllllllllllIllIlIllIllIIllllI) / 2L;
            llllllllllllllIllIlIllIllIIllIlI = upperBound(llllllllllllllIllIlIllIllIIlIlIl, llllllllllllllIllIlIllIllIIllllI, llllllllllllllIllIlIllIllIIllIIl, llllllllllllllIllIlIllIllIIIllll);
        }
        final long llllllllllllllIllIlIllIllIIllIII = llllllllllllllIllIlIllIllIIllIlI;
        final long llllllllllllllIllIlIllIllIIlIlll = llllllllllllllIllIlIllIllIIllllI;
        final long llllllllllllllIllIlIllIllIIlIllI = llllllllllllllIllIlIllIllIIllIIl;
        if (llllllllllllllIllIlIllIllIIlIlll != llllllllllllllIllIlIllIllIIllIII && llllllllllllllIllIlIllIllIIlIlll != llllllllllllllIllIlIllIllIIlIllI) {
            long llllllllllllllIllIlIllIllIlIIIIl = llllllllllllllIllIlIllIllIIllIII;
            long llllllllllllllIllIlIllIllIlIIIII = llllllllllllllIllIlIllIllIIlIlll;
            while (llllllllllllllIllIlIllIllIlIIIIl < --llllllllllllllIllIlIllIllIlIIIII) {
                llllllllllllllIllIlIllIllIIllIll.swap(llllllllllllllIllIlIllIllIlIIIIl++, llllllllllllllIllIlIllIllIlIIIII);
            }
            llllllllllllllIllIlIllIllIlIIIIl = llllllllllllllIllIlIllIllIIlIlll;
            llllllllllllllIllIlIllIllIlIIIII = llllllllllllllIllIlIllIllIIlIllI;
            while (llllllllllllllIllIlIllIllIlIIIIl < --llllllllllllllIllIlIllIllIlIIIII) {
                llllllllllllllIllIlIllIllIIllIll.swap(llllllllllllllIllIlIllIllIlIIIIl++, llllllllllllllIllIlIllIllIlIIIII);
            }
            llllllllllllllIllIlIllIllIlIIIIl = llllllllllllllIllIlIllIllIIllIII;
            llllllllllllllIllIlIllIllIlIIIII = llllllllllllllIllIlIllIllIIlIllI;
            while (llllllllllllllIllIlIllIllIlIIIIl < --llllllllllllllIllIlIllIllIlIIIII) {
                llllllllllllllIllIlIllIllIIllIll.swap(llllllllllllllIllIlIllIllIlIIIIl++, llllllllllllllIllIlIllIllIlIIIII);
            }
        }
        llllllllllllllIllIlIllIllIIllllI = llllllllllllllIllIlIllIllIIllIlI + (llllllllllllllIllIlIllIllIIllIIl - llllllllllllllIllIlIllIllIIllllI);
        inPlaceMerge(llllllllllllllIllIlIllIllIIlIlIl, llllllllllllllIllIlIllIllIIllIlI, llllllllllllllIllIlIllIllIIllllI, llllllllllllllIllIlIllIllIIIllll, llllllllllllllIllIlIllIllIIllIll);
        inPlaceMerge(llllllllllllllIllIlIllIllIIllllI, llllllllllllllIllIlIllIllIIllIIl, llllllllllllllIllIlIllIllIIlllIl, llllllllllllllIllIlIllIllIIIllll, llllllllllllllIllIlIllIllIIllIll);
    }
    
    public static long[][] reverse(final long[][] llllllllllllllIllIlIlIIlIlllIIll) {
        final long llllllllllllllIllIlIlIIlIlllIlII = length(llllllllllllllIllIlIlIIlIlllIIll);
        long llllllllllllllIllIlIlIIlIlllIllI = llllllllllllllIllIlIlIIlIlllIlII / 2L;
        while (llllllllllllllIllIlIlIIlIlllIllI-- != 0L) {
            swap(llllllllllllllIllIlIlIIlIlllIIll, llllllllllllllIllIlIlIIlIlllIllI, llllllllllllllIllIlIlIIlIlllIlII - llllllllllllllIllIlIlIIlIlllIllI - 1L);
        }
        return llllllllllllllIllIlIlIIlIlllIIll;
    }
    
    public static void ensureFromTo(final byte[][] llllllllllllllIllIlIlIlllIIlIlIl, final long llllllllllllllIllIlIlIlllIIlIlII, final long llllllllllllllIllIlIlIlllIIlIIII) {
        ensureFromTo(length(llllllllllllllIllIlIlIlllIIlIlIl), llllllllllllllIllIlIlIlllIIlIlII, llllllllllllllIllIlIlIlllIIlIIII);
    }
    
    public static void copy(final long[][] llllllllllllllIllIlIlIIlIIlllIII, final long llllllllllllllIllIlIlIIlIIllIlll, final long[][] llllllllllllllIllIlIlIIlIIllIllI, final long llllllllllllllIllIlIlIIlIIllIIII, long llllllllllllllIllIlIlIIlIIlIllll) {
        if (llllllllllllllIllIlIlIIlIIllIIII <= llllllllllllllIllIlIlIIlIIllIlll) {
            int llllllllllllllIllIlIlIIlIlIIIIlI = segment(llllllllllllllIllIlIlIIlIIllIlll);
            int llllllllllllllIllIlIlIIlIlIIIIIl = segment(llllllllllllllIllIlIlIIlIIllIIII);
            int llllllllllllllIllIlIlIIlIlIIIIII = displacement(llllllllllllllIllIlIlIIlIIllIlll);
            int llllllllllllllIllIlIlIIlIIllllll = displacement(llllllllllllllIllIlIlIIlIIllIIII);
            while (llllllllllllllIllIlIlIIlIIlIllll > 0L) {
                final int llllllllllllllIllIlIlIIlIIlllllI = (int)Math.min(llllllllllllllIllIlIlIIlIIlIllll, Math.min(llllllllllllllIllIlIlIIlIIlllIII[llllllllllllllIllIlIlIIlIlIIIIlI].length - llllllllllllllIllIlIlIIlIlIIIIII, llllllllllllllIllIlIlIIlIIllIllI[llllllllllllllIllIlIlIIlIlIIIIIl].length - llllllllllllllIllIlIlIIlIIllllll));
                if (llllllllllllllIllIlIlIIlIIlllllI == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIlIIlIIlllIII[llllllllllllllIllIlIlIIlIlIIIIlI], llllllllllllllIllIlIlIIlIlIIIIII, llllllllllllllIllIlIlIIlIIllIllI[llllllllllllllIllIlIlIIlIlIIIIIl], llllllllllllllIllIlIlIIlIIllllll, llllllllllllllIllIlIlIIlIIlllllI);
                if ((llllllllllllllIllIlIlIIlIlIIIIII += llllllllllllllIllIlIlIIlIIlllllI) == 134217728) {
                    llllllllllllllIllIlIlIIlIlIIIIII = 0;
                    ++llllllllllllllIllIlIlIIlIlIIIIlI;
                }
                if ((llllllllllllllIllIlIlIIlIIllllll += llllllllllllllIllIlIlIIlIIlllllI) == 134217728) {
                    llllllllllllllIllIlIlIIlIIllllll = 0;
                    ++llllllllllllllIllIlIlIIlIlIIIIIl;
                }
                llllllllllllllIllIlIlIIlIIlIllll -= llllllllllllllIllIlIlIIlIIlllllI;
            }
        }
        else {
            int llllllllllllllIllIlIlIIlIIllllIl = segment(llllllllllllllIllIlIlIIlIIllIlll + llllllllllllllIllIlIlIIlIIlIllll);
            int llllllllllllllIllIlIlIIlIIllllII = segment(llllllllllllllIllIlIlIIlIIllIIII + llllllllllllllIllIlIlIIlIIlIllll);
            int llllllllllllllIllIlIlIIlIIlllIll = displacement(llllllllllllllIllIlIlIIlIIllIlll + llllllllllllllIllIlIlIIlIIlIllll);
            int llllllllllllllIllIlIlIIlIIlllIlI = displacement(llllllllllllllIllIlIlIIlIIllIIII + llllllllllllllIllIlIlIIlIIlIllll);
            while (llllllllllllllIllIlIlIIlIIlIllll > 0L) {
                if (llllllllllllllIllIlIlIIlIIlllIll == 0) {
                    llllllllllllllIllIlIlIIlIIlllIll = 134217728;
                    --llllllllllllllIllIlIlIIlIIllllIl;
                }
                if (llllllllllllllIllIlIlIIlIIlllIlI == 0) {
                    llllllllllllllIllIlIlIIlIIlllIlI = 134217728;
                    --llllllllllllllIllIlIlIIlIIllllII;
                }
                final int llllllllllllllIllIlIlIIlIIlllIIl = (int)Math.min(llllllllllllllIllIlIlIIlIIlIllll, Math.min(llllllllllllllIllIlIlIIlIIlllIll, llllllllllllllIllIlIlIIlIIlllIlI));
                if (llllllllllllllIllIlIlIIlIIlllIIl == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIlIIlIIlllIII[llllllllllllllIllIlIlIIlIIllllIl], llllllllllllllIllIlIlIIlIIlllIll - llllllllllllllIllIlIlIIlIIlllIIl, llllllllllllllIllIlIlIIlIIllIllI[llllllllllllllIllIlIlIIlIIllllII], llllllllllllllIllIlIlIIlIIlllIlI - llllllllllllllIllIlIlIIlIIlllIIl, llllllllllllllIllIlIlIIlIIlllIIl);
                llllllllllllllIllIlIlIIlIIlllIll -= llllllllllllllIllIlIlIIlIIlllIIl;
                llllllllllllllIllIlIlIIlIIlllIlI -= llllllllllllllIllIlIlIIlIIlllIIl;
                llllllllllllllIllIlIlIIlIIlIllll -= llllllllllllllIllIlIlIIlIIlllIIl;
            }
        }
    }
    
    public static char[][] copy(final char[][] llllllllllllllIllIlIIIlIIllIlIlI) {
        final char[][] llllllllllllllIllIlIIIlIIllIlIIl = llllllllllllllIllIlIIIlIIllIlIlI.clone();
        int llllllllllllllIllIlIIIlIIllIlIll = llllllllllllllIllIlIIIlIIllIlIIl.length;
        while (llllllllllllllIllIlIIIlIIllIlIll-- != 0) {
            llllllllllllllIllIlIIIlIIllIlIIl[llllllllllllllIllIlIIIlIIllIlIll] = llllllllllllllIllIlIIIlIIllIlIlI[llllllllllllllIllIlIIIlIIllIlIll].clone();
        }
        return llllllllllllllIllIlIIIlIIllIlIIl;
    }
    
    public static void main(final String[] llllllllllllllIllIIllllIllIIlIlI) {
        final int[][] llllllllllllllIllIIllllIllIIlIIl = IntBigArrays.newBigArray(1L << Integer.parseInt(llllllllllllllIllIIllllIllIIlIlI[0]));
        int llllllllllllllIllIIllllIllIIlIll = 10;
        while (llllllllllllllIllIIllllIllIIlIll-- != 0) {
            long llllllllllllllIllIIllllIllIIllII = -System.currentTimeMillis();
            long llllllllllllllIllIIllllIllIIllll = 0L;
            long llllllllllllllIllIIllllIllIlIlll = length(llllllllllllllIllIIllllIllIIlIIl);
            while (llllllllllllllIllIIllllIllIlIlll-- != 0L) {
                llllllllllllllIllIIllllIllIIllll ^= (llllllllllllllIllIIllllIllIlIlll ^ (long)get(llllllllllllllIllIIllllIllIIlIIl, llllllllllllllIllIIllllIllIlIlll));
            }
            if (llllllllllllllIllIIllllIllIIllll == 0L) {
                System.err.println();
            }
            System.out.println(String.valueOf(new StringBuilder().append("Single loop: ").append(llllllllllllllIllIIllllIllIIllII + System.currentTimeMillis()).append("ms")));
            llllllllllllllIllIIllllIllIIllII = -System.currentTimeMillis();
            long llllllllllllllIllIIllllIllIIlllI = 0L;
            int llllllllllllllIllIIllllIllIlIlII = llllllllllllllIllIIllllIllIIlIIl.length;
            while (llllllllllllllIllIIllllIllIlIlII-- != 0) {
                final int[] llllllllllllllIllIIllllIllIlIlIl = llllllllllllllIllIIllllIllIIlIIl[llllllllllllllIllIIllllIllIlIlII];
                int llllllllllllllIllIIllllIllIlIllI = llllllllllllllIllIIllllIllIlIlIl.length;
                while (llllllllllllllIllIIllllIllIlIllI-- != 0) {
                    llllllllllllllIllIIllllIllIIlllI ^= ((long)llllllllllllllIllIIllllIllIlIlIl[llllllllllllllIllIIllllIllIlIllI] ^ index(llllllllllllllIllIIllllIllIlIlII, llllllllllllllIllIIllllIllIlIllI));
                }
            }
            if (llllllllllllllIllIIllllIllIIlllI == 0L) {
                System.err.println();
            }
            if (llllllllllllllIllIIllllIllIIllll != llllllllllllllIllIIllllIllIIlllI) {
                throw new AssertionError();
            }
            System.out.println(String.valueOf(new StringBuilder().append("Double loop: ").append(llllllllllllllIllIIllllIllIIllII + System.currentTimeMillis()).append("ms")));
            final long llllllllllllllIllIIllllIllIIllIl = 0L;
            long llllllllllllllIllIIllllIllIlIIII = length(llllllllllllllIllIIllllIllIIlIIl);
            int llllllllllllllIllIIllllIllIlIIIl = llllllllllllllIllIIllllIllIIlIIl.length;
            while (llllllllllllllIllIIllllIllIlIIIl-- != 0) {
                final int[] llllllllllllllIllIIllllIllIlIIlI = llllllllllllllIllIIllllIllIIlIIl[llllllllllllllIllIIllllIllIlIIIl];
                int llllllllllllllIllIIllllIllIlIIll = llllllllllllllIllIIllllIllIlIIlI.length;
                while (llllllllllllllIllIIllllIllIlIIll-- != 0) {
                    llllllllllllllIllIIllllIllIIlllI ^= ((long)llllllllllllllIllIIllllIllIlIIlI[llllllllllllllIllIIllllIllIlIIll] ^ --llllllllllllllIllIIllllIllIlIIII);
                }
            }
            if (llllllllllllllIllIIllllIllIIllIl == 0L) {
                System.err.println();
            }
            if (llllllllllllllIllIIllllIllIIllll != llllllllllllllIllIIllllIllIIllIl) {
                throw new AssertionError();
            }
            System.out.println(String.valueOf(new StringBuilder().append("Double loop (with additional index): ").append(llllllllllllllIllIIllllIllIIllII + System.currentTimeMillis()).append("ms")));
        }
    }
    
    public static void copy(final char[][] llllllllllllllIllIlIIIllIIIlIlIl, final long llllllllllllllIllIlIIIllIIIllIIl, final char[][] llllllllllllllIllIlIIIllIIIllIII, final long llllllllllllllIllIlIIIllIIIlIIlI, long llllllllllllllIllIlIIIllIIIlIIIl) {
        if (llllllllllllllIllIlIIIllIIIlIIlI <= llllllllllllllIllIlIIIllIIIllIIl) {
            int llllllllllllllIllIlIIIllIIlIIlII = segment(llllllllllllllIllIlIIIllIIIllIIl);
            int llllllllllllllIllIlIIIllIIlIIIll = segment(llllllllllllllIllIlIIIllIIIlIIlI);
            int llllllllllllllIllIlIIIllIIlIIIlI = displacement(llllllllllllllIllIlIIIllIIIllIIl);
            int llllllllllllllIllIlIIIllIIlIIIIl = displacement(llllllllllllllIllIlIIIllIIIlIIlI);
            while (llllllllllllllIllIlIIIllIIIlIIIl > 0L) {
                final int llllllllllllllIllIlIIIllIIlIIIII = (int)Math.min(llllllllllllllIllIlIIIllIIIlIIIl, Math.min(llllllllllllllIllIlIIIllIIIlIlIl[llllllllllllllIllIlIIIllIIlIIlII].length - llllllllllllllIllIlIIIllIIlIIIlI, llllllllllllllIllIlIIIllIIIllIII[llllllllllllllIllIlIIIllIIlIIIll].length - llllllllllllllIllIlIIIllIIlIIIIl));
                if (llllllllllllllIllIlIIIllIIlIIIII == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIIllIIIlIlIl[llllllllllllllIllIlIIIllIIlIIlII], llllllllllllllIllIlIIIllIIlIIIlI, llllllllllllllIllIlIIIllIIIllIII[llllllllllllllIllIlIIIllIIlIIIll], llllllllllllllIllIlIIIllIIlIIIIl, llllllllllllllIllIlIIIllIIlIIIII);
                if ((llllllllllllllIllIlIIIllIIlIIIlI += llllllllllllllIllIlIIIllIIlIIIII) == 134217728) {
                    llllllllllllllIllIlIIIllIIlIIIlI = 0;
                    ++llllllllllllllIllIlIIIllIIlIIlII;
                }
                if ((llllllllllllllIllIlIIIllIIlIIIIl += llllllllllllllIllIlIIIllIIlIIIII) == 134217728) {
                    llllllllllllllIllIlIIIllIIlIIIIl = 0;
                    ++llllllllllllllIllIlIIIllIIlIIIll;
                }
                llllllllllllllIllIlIIIllIIIlIIIl -= llllllllllllllIllIlIIIllIIlIIIII;
            }
        }
        else {
            int llllllllllllllIllIlIIIllIIIlllll = segment(llllllllllllllIllIlIIIllIIIllIIl + llllllllllllllIllIlIIIllIIIlIIIl);
            int llllllllllllllIllIlIIIllIIIllllI = segment(llllllllllllllIllIlIIIllIIIlIIlI + llllllllllllllIllIlIIIllIIIlIIIl);
            int llllllllllllllIllIlIIIllIIIlllIl = displacement(llllllllllllllIllIlIIIllIIIllIIl + llllllllllllllIllIlIIIllIIIlIIIl);
            int llllllllllllllIllIlIIIllIIIlllII = displacement(llllllllllllllIllIlIIIllIIIlIIlI + llllllllllllllIllIlIIIllIIIlIIIl);
            while (llllllllllllllIllIlIIIllIIIlIIIl > 0L) {
                if (llllllllllllllIllIlIIIllIIIlllIl == 0) {
                    llllllllllllllIllIlIIIllIIIlllIl = 134217728;
                    --llllllllllllllIllIlIIIllIIIlllll;
                }
                if (llllllllllllllIllIlIIIllIIIlllII == 0) {
                    llllllllllllllIllIlIIIllIIIlllII = 134217728;
                    --llllllllllllllIllIlIIIllIIIllllI;
                }
                final int llllllllllllllIllIlIIIllIIIllIll = (int)Math.min(llllllllllllllIllIlIIIllIIIlIIIl, Math.min(llllllllllllllIllIlIIIllIIIlllIl, llllllllllllllIllIlIIIllIIIlllII));
                if (llllllllllllllIllIlIIIllIIIllIll == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIIllIIIlIlIl[llllllllllllllIllIlIIIllIIIlllll], llllllllllllllIllIlIIIllIIIlllIl - llllllllllllllIllIlIIIllIIIllIll, llllllllllllllIllIlIIIllIIIllIII[llllllllllllllIllIlIIIllIIIllllI], llllllllllllllIllIlIIIllIIIlllII - llllllllllllllIllIlIIIllIIIllIll, llllllllllllllIllIlIIIllIIIllIll);
                llllllllllllllIllIlIIIllIIIlllIl -= llllllllllllllIllIlIIIllIIIllIll;
                llllllllllllllIllIlIIIllIIIlllII -= llllllllllllllIllIlIIIllIIIllIll;
                llllllllllllllIllIlIIIllIIIlIIIl -= llllllllllllllIllIlIIIllIIIllIll;
            }
        }
    }
    
    public static void ensureFromTo(final char[][] llllllllllllllIllIlIIIlIIIlIIIII, final long llllllllllllllIllIlIIIlIIIIlllII, final long llllllllllllllIllIlIIIlIIIIllIll) {
        ensureFromTo(length(llllllllllllllIllIlIIIlIIIlIIIII), llllllllllllllIllIlIIIlIIIIlllII, llllllllllllllIllIlIIIlIIIIllIll);
    }
    
    public static boolean equals(final double[][] llllllllllllllIllIlIIllIllIIIlll, final double[][] llllllllllllllIllIlIIllIllIIIllI) {
        if (length(llllllllllllllIllIlIIllIllIIIlll) != length(llllllllllllllIllIlIIllIllIIIllI)) {
            return false;
        }
        int llllllllllllllIllIlIIllIllIIIlIl = llllllllllllllIllIlIIllIllIIIlll.length;
        while (llllllllllllllIllIlIIllIllIIIlIl-- != 0) {
            final double[] llllllllllllllIllIlIIllIllIIlIIl = llllllllllllllIllIlIIllIllIIIlll[llllllllllllllIllIlIIllIllIIIlIl];
            final double[] llllllllllllllIllIlIIllIllIIlIII = llllllllllllllIllIlIIllIllIIIllI[llllllllllllllIllIlIIllIllIIIlIl];
            int llllllllllllllIllIlIIllIllIIlIlI = llllllllllllllIllIlIIllIllIIlIIl.length;
            while (llllllllllllllIllIlIIllIllIIlIlI-- != 0) {
                if (Double.doubleToLongBits(llllllllllllllIllIlIIllIllIIlIIl[llllllllllllllIllIlIIllIllIIlIlI]) != Double.doubleToLongBits(llllllllllllllIllIlIIllIllIIlIII[llllllllllllllIllIlIIllIllIIlIlI])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static long get(final long[][] llllllllllllllIllIlIlIIllIIlIIII, final long llllllllllllllIllIlIlIIllIIlIIIl) {
        return llllllllllllllIllIlIlIIllIIlIIII[segment(llllllllllllllIllIlIlIIllIIlIIIl)][displacement(llllllllllllllIllIlIlIIllIIlIIIl)];
    }
    
    public static boolean equals(final boolean[][] llllllllllllllIllIlIIlIlIlIlIIll, final boolean[][] llllllllllllllIllIlIIlIlIlIlIIlI) {
        if (length(llllllllllllllIllIlIIlIlIlIlIIll) != length(llllllllllllllIllIlIIlIlIlIlIIlI)) {
            return false;
        }
        int llllllllllllllIllIlIIlIlIlIlIlII = llllllllllllllIllIlIIlIlIlIlIIll.length;
        while (llllllllllllllIllIlIIlIlIlIlIlII-- != 0) {
            final boolean[] llllllllllllllIllIlIIlIlIlIllIII = llllllllllllllIllIlIIlIlIlIlIIll[llllllllllllllIllIlIIlIlIlIlIlII];
            final boolean[] llllllllllllllIllIlIIlIlIlIlIlll = llllllllllllllIllIlIIlIlIlIlIIlI[llllllllllllllIllIlIIlIlIlIlIlII];
            int llllllllllllllIllIlIIlIlIlIllIIl = llllllllllllllIllIlIIlIlIlIllIII.length;
            while (llllllllllllllIllIlIIlIlIlIllIIl-- != 0) {
                if (llllllllllllllIllIlIIlIlIlIllIII[llllllllllllllIllIlIIlIlIlIllIIl] != llllllllllllllIllIlIIlIlIlIlIlll[llllllllllllllIllIlIIlIlIlIllIIl]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static double[][] wrap(final double[] llllllllllllllIllIlIIlllIllIIllI) {
        if (llllllllllllllIllIlIIlllIllIIllI.length == 0) {
            return DoubleBigArrays.EMPTY_BIG_ARRAY;
        }
        if (llllllllllllllIllIlIIlllIllIIllI.length <= 134217728) {
            return new double[][] { llllllllllllllIllIlIIlllIllIIllI };
        }
        final double[][] llllllllllllllIllIlIIlllIllIIlIl = DoubleBigArrays.newBigArray((long)llllllllllllllIllIlIIlllIllIIllI.length);
        for (int llllllllllllllIllIlIIlllIllIIlll = 0; llllllllllllllIllIlIIlllIllIIlll < llllllllllllllIllIlIIlllIllIIlIl.length; ++llllllllllllllIllIlIIlllIllIIlll) {
            System.arraycopy(llllllllllllllIllIlIIlllIllIIllI, (int)start(llllllllllllllIllIlIIlllIllIIlll), llllllllllllllIllIlIIlllIllIIlIl[llllllllllllllIllIlIIlllIllIIlll], 0, llllllllllllllIllIlIIlllIllIIlIl[llllllllllllllIllIlIIlllIllIIlll].length);
        }
        return llllllllllllllIllIlIIlllIllIIlIl;
    }
    
    public static long[][] wrap(final long[] llllllllllllllIllIlIlIIIllllIIll) {
        if (llllllllllllllIllIlIlIIIllllIIll.length == 0) {
            return LongBigArrays.EMPTY_BIG_ARRAY;
        }
        if (llllllllllllllIllIlIlIIIllllIIll.length <= 134217728) {
            return new long[][] { llllllllllllllIllIlIlIIIllllIIll };
        }
        final long[][] llllllllllllllIllIlIlIIIllllIlII = LongBigArrays.newBigArray((long)llllllllllllllIllIlIlIIIllllIIll.length);
        for (int llllllllllllllIllIlIlIIIllllIllI = 0; llllllllllllllIllIlIlIIIllllIllI < llllllllllllllIllIlIlIIIllllIlII.length; ++llllllllllllllIllIlIlIIIllllIllI) {
            System.arraycopy(llllllllllllllIllIlIlIIIllllIIll, (int)start(llllllllllllllIllIlIlIIIllllIllI), llllllllllllllIllIlIlIIIllllIlII[llllllllllllllIllIlIlIIIllllIllI], 0, llllllllllllllIllIlIlIIIllllIlII[llllllllllllllIllIlIlIIIllllIllI].length);
        }
        return llllllllllllllIllIlIlIIIllllIlII;
    }
    
    public static String toString(final char[][] llllllllllllllIllIlIIIlIIIlIIlll) {
        if (llllllllllllllIllIlIIIlIIIlIIlll == null) {
            return "null";
        }
        final long llllllllllllllIllIlIIIlIIIlIlIIl = length(llllllllllllllIllIlIIIlIIIlIIlll) - 1L;
        if (llllllllllllllIllIlIIIlIIIlIlIIl == -1L) {
            return "[]";
        }
        final StringBuilder llllllllllllllIllIlIIIlIIIlIlIII = new StringBuilder();
        llllllllllllllIllIlIIIlIIIlIlIII.append('[');
        long llllllllllllllIllIlIIIlIIIlIlIll = 0L;
        while (true) {
            llllllllllllllIllIlIIIlIIIlIlIII.append(String.valueOf(get(llllllllllllllIllIlIIIlIIIlIIlll, llllllllllllllIllIlIIIlIIIlIlIll)));
            if (llllllllllllllIllIlIIIlIIIlIlIll == llllllllllllllIllIlIIIlIIIlIlIIl) {
                break;
            }
            llllllllllllllIllIlIIIlIIIlIlIII.append(", ");
            ++llllllllllllllIllIlIIIlIIIlIlIll;
        }
        return String.valueOf(llllllllllllllIllIlIIIlIIIlIlIII.append(']'));
    }
    
    public static double[][] trim(final double[][] llllllllllllllIllIlIIlllIIIllIII, final long llllllllllllllIllIlIIlllIIIlIlll) {
        ensureLength(llllllllllllllIllIlIIlllIIIlIlll);
        final long llllllllllllllIllIlIIlllIIIlllII = length(llllllllllllllIllIlIIlllIIIllIII);
        if (llllllllllllllIllIlIIlllIIIlIlll >= llllllllllllllIllIlIIlllIIIlllII) {
            return llllllllllllllIllIlIIlllIIIllIII;
        }
        final int llllllllllllllIllIlIIlllIIIllIll = (int)(llllllllllllllIllIlIIlllIIIlIlll + 134217727L >>> 27);
        final double[][] llllllllllllllIllIlIIlllIIIllIlI = Arrays.copyOf(llllllllllllllIllIlIIlllIIIllIII, llllllllllllllIllIlIIlllIIIllIll);
        final int llllllllllllllIllIlIIlllIIIllIIl = (int)(llllllllllllllIllIlIIlllIIIlIlll & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIlllIIIllIIl != 0) {
            llllllllllllllIllIlIIlllIIIllIlI[llllllllllllllIllIlIIlllIIIllIll - 1] = DoubleArrays.trim(llllllllllllllIllIlIIlllIIIllIlI[llllllllllllllIllIlIIlllIIIllIll - 1], llllllllllllllIllIlIIlllIIIllIIl);
        }
        return llllllllllllllIllIlIIlllIIIllIlI;
    }
    
    public static double[][] ensureCapacity(final double[][] llllllllllllllIllIlIIlllIlIlllIl, final long llllllllllllllIllIlIIlllIlIllllI) {
        return ensureCapacity(llllllllllllllIllIlIIlllIlIlllIl, llllllllllllllIllIlIIlllIlIllllI, length(llllllllllllllIllIlIIlllIlIlllIl));
    }
    
    public static char[][] reverse(final char[][] llllllllllllllIllIlIIIllIlIlIlll) {
        final long llllllllllllllIllIlIIIllIlIlIllI = length(llllllllllllllIllIlIIIllIlIlIlll);
        long llllllllllllllIllIlIIIllIlIllIII = llllllllllllllIllIlIIIllIlIlIllI / 2L;
        while (llllllllllllllIllIlIIIllIlIllIII-- != 0L) {
            swap(llllllllllllllIllIlIIIllIlIlIlll, llllllllllllllIllIlIIIllIlIllIII, llllllllllllllIllIlIIIllIlIlIllI - llllllllllllllIllIlIIIllIlIllIII - 1L);
        }
        return llllllllllllllIllIlIIIllIlIlIlll;
    }
    
    public static byte[][] setLength(final byte[][] llllllllllllllIllIlIlIllllllIlIl, final long llllllllllllllIllIlIlIllllllIlII) {
        final long llllllllllllllIllIlIlIllllllIIll = length(llllllllllllllIllIlIlIllllllIlIl);
        if (llllllllllllllIllIlIlIllllllIlII == llllllllllllllIllIlIlIllllllIIll) {
            return llllllllllllllIllIlIlIllllllIlIl;
        }
        if (llllllllllllllIllIlIlIllllllIlII < llllllllllllllIllIlIlIllllllIIll) {
            return trim(llllllllllllllIllIlIlIllllllIlIl, llllllllllllllIllIlIlIllllllIlII);
        }
        return ensureCapacity(llllllllllllllIllIlIlIllllllIlIl, llllllllllllllIllIlIlIllllllIlII);
    }
    
    public static float[][] setLength(final float[][] llllllllllllllIllIlIIIIIlllIlllI, final long llllllllllllllIllIlIIIIIlllIllIl) {
        final long llllllllllllllIllIlIIIIIlllIllll = length(llllllllllllllIllIlIIIIIlllIlllI);
        if (llllllllllllllIllIlIIIIIlllIllIl == llllllllllllllIllIlIIIIIlllIllll) {
            return llllllllllllllIllIlIIIIIlllIlllI;
        }
        if (llllllllllllllIllIlIIIIIlllIllIl < llllllllllllllIllIlIIIIIlllIllll) {
            return trim(llllllllllllllIllIlIIIIIlllIlllI, llllllllllllllIllIlIIIIIlllIllIl);
        }
        return ensureCapacity(llllllllllllllIllIlIIIIIlllIlllI, llllllllllllllIllIlIIIIIlllIllIl);
    }
    
    public static int[][] ensureCapacity(final int[][] llllllllllllllIllIlIlIlIIllIIIll, final long llllllllllllllIllIlIlIlIIlIlllIl, final long llllllllllllllIllIlIlIlIIlIllIll) {
        return (llllllllllllllIllIlIlIlIIlIlllIl > length(llllllllllllllIllIlIlIlIIllIIIll)) ? forceCapacity(llllllllllllllIllIlIlIlIIllIIIll, llllllllllllllIllIlIlIlIIlIlllIl, llllllllllllllIllIlIlIlIIlIllIll) : llllllllllllllIllIlIlIlIIllIIIll;
    }
    
    public static long[][] trim(final long[][] llllllllllllllIllIlIlIIIlIlIIlll, final long llllllllllllllIllIlIlIIIlIlIIllI) {
        ensureLength(llllllllllllllIllIlIlIIIlIlIIllI);
        final long llllllllllllllIllIlIlIIIlIlIlIll = length(llllllllllllllIllIlIlIIIlIlIIlll);
        if (llllllllllllllIllIlIlIIIlIlIIllI >= llllllllllllllIllIlIlIIIlIlIlIll) {
            return llllllllllllllIllIlIlIIIlIlIIlll;
        }
        final int llllllllllllllIllIlIlIIIlIlIlIlI = (int)(llllllllllllllIllIlIlIIIlIlIIllI + 134217727L >>> 27);
        final long[][] llllllllllllllIllIlIlIIIlIlIlIIl = Arrays.copyOf(llllllllllllllIllIlIlIIIlIlIIlll, llllllllllllllIllIlIlIIIlIlIlIlI);
        final int llllllllllllllIllIlIlIIIlIlIlIII = (int)(llllllllllllllIllIlIlIIIlIlIIllI & 0x7FFFFFFL);
        if (llllllllllllllIllIlIlIIIlIlIlIII != 0) {
            llllllllllllllIllIlIlIIIlIlIlIIl[llllllllllllllIllIlIlIIIlIlIlIlI - 1] = LongArrays.trim(llllllllllllllIllIlIlIIIlIlIlIIl[llllllllllllllIllIlIlIIIlIlIlIlI - 1], llllllllllllllIllIlIlIIIlIlIlIII);
        }
        return llllllllllllllIllIlIlIIIlIlIlIIl;
    }
    
    public static void ensureOffsetLength(final short[][] llllllllllllllIllIlIIIlllIlIIllI, final long llllllllllllllIllIlIIIlllIlIIlIl, final long llllllllllllllIllIlIIIlllIlIIlII) {
        ensureOffsetLength(length(llllllllllllllIllIlIIIlllIlIIllI), llllllllllllllIllIlIIIlllIlIIlIl, llllllllllllllIllIlIIIlllIlIIlII);
    }
    
    public static void copyToBig(final double[] llllllllllllllIllIlIIlllIllllIIl, int llllllllllllllIllIlIIlllIlllIIIl, final double[][] llllllllllllllIllIlIIlllIlllIlll, final long llllllllllllllIllIlIIlllIllIllll, long llllllllllllllIllIlIIlllIllIlllI) {
        int llllllllllllllIllIlIIlllIlllIlII = segment(llllllllllllllIllIlIIlllIllIllll);
        int llllllllllllllIllIlIIlllIlllIIll = displacement(llllllllllllllIllIlIIlllIllIllll);
        while (llllllllllllllIllIlIIlllIllIlllI > 0L) {
            final int llllllllllllllIllIlIIlllIllllIlI = (int)Math.min(llllllllllllllIllIlIIlllIlllIlll[llllllllllllllIllIlIIlllIlllIlII].length - llllllllllllllIllIlIIlllIlllIIll, (long)llllllllllllllIllIlIIlllIllIlllI);
            if (llllllllllllllIllIlIIlllIllllIlI == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIlllIllllIIl, llllllllllllllIllIlIIlllIlllIIIl, llllllllllllllIllIlIIlllIlllIlll[llllllllllllllIllIlIIlllIlllIlII], llllllllllllllIllIlIIlllIlllIIll, llllllllllllllIllIlIIlllIllllIlI);
            if ((llllllllllllllIllIlIIlllIlllIIll += llllllllllllllIllIlIIlllIllllIlI) == 134217728) {
                llllllllllllllIllIlIIlllIlllIIll = 0;
                ++llllllllllllllIllIlIIlllIlllIlII;
            }
            llllllllllllllIllIlIIlllIlllIIIl += llllllllllllllIllIlIIlllIllllIlI;
            llllllllllllllIllIlIIlllIllIlllI -= llllllllllllllIllIlIIlllIllllIlI;
        }
    }
    
    static {
        SMALL = 7;
        MEDIUM = 40;
        SEGMENT_SIZE = 134217728;
        SEGMENT_SHIFT = 27;
        SEGMENT_MASK = 134217727;
    }
    
    public static String toString(final boolean[][] llllllllllllllIllIlIIlIlIlIIlIII) {
        if (llllllllllllllIllIlIIlIlIlIIlIII == null) {
            return "null";
        }
        final long llllllllllllllIllIlIIlIlIlIIIlll = length(llllllllllllllIllIlIIlIlIlIIlIII) - 1L;
        if (llllllllllllllIllIlIIlIlIlIIIlll == -1L) {
            return "[]";
        }
        final StringBuilder llllllllllllllIllIlIIlIlIlIIIllI = new StringBuilder();
        llllllllllllllIllIlIIlIlIlIIIllI.append('[');
        long llllllllllllllIllIlIIlIlIlIIlIIl = 0L;
        while (true) {
            llllllllllllllIllIlIIlIlIlIIIllI.append(String.valueOf(get(llllllllllllllIllIlIIlIlIlIIlIII, llllllllllllllIllIlIIlIlIlIIlIIl)));
            if (llllllllllllllIllIlIIlIlIlIIlIIl == llllllllllllllIllIlIIlIlIlIIIlll) {
                break;
            }
            llllllllllllllIllIlIIlIlIlIIIllI.append(", ");
            ++llllllllllllllIllIlIIlIlIlIIlIIl;
        }
        return String.valueOf(llllllllllllllIllIlIIlIlIlIIIllI.append(']'));
    }
    
    public static <K> K[][] ensureCapacity(final K[][] llllllllllllllIllIIllllllIlIllII, final long llllllllllllllIllIIllllllIlIlIll, final long llllllllllllllIllIIllllllIlIlIlI) {
        return (K[][])((llllllllllllllIllIIllllllIlIlIll > length(llllllllllllllIllIIllllllIlIllII)) ? forceCapacity((Object[][])llllllllllllllIllIIllllllIlIllII, llllllllllllllIllIIllllllIlIlIll, llllllllllllllIllIIllllllIlIlIlI) : llllllllllllllIllIIllllllIlIllII);
    }
    
    public static <K> void swap(final K[][] llllllllllllllIllIlIIIIIIlIIIIIl, final long llllllllllllllIllIlIIIIIIlIIIlII, final long llllllllllllllIllIlIIIIIIlIIIIll) {
        final K llllllllllllllIllIlIIIIIIlIIIIlI = llllllllllllllIllIlIIIIIIlIIIIIl[segment(llllllllllllllIllIlIIIIIIlIIIlII)][displacement(llllllllllllllIllIlIIIIIIlIIIlII)];
        llllllllllllllIllIlIIIIIIlIIIIIl[segment(llllllllllllllIllIlIIIIIIlIIIlII)][displacement(llllllllllllllIllIlIIIIIIlIIIlII)] = llllllllllllllIllIlIIIIIIlIIIIIl[segment(llllllllllllllIllIlIIIIIIlIIIIll)][displacement(llllllllllllllIllIlIIIIIIlIIIIll)];
        llllllllllllllIllIlIIIIIIlIIIIIl[segment(llllllllllllllIllIlIIIIIIlIIIIll)][displacement(llllllllllllllIllIlIIIIIIlIIIIll)] = llllllllllllllIllIlIIIIIIlIIIIlI;
    }
    
    public static short[][] ensureCapacity(final short[][] llllllllllllllIllIlIIlIIIIllllII, final long llllllllllllllIllIlIIlIIIIlllIll, final long llllllllllllllIllIlIIlIIIIlllIlI) {
        return (llllllllllllllIllIlIIlIIIIlllIll > length(llllllllllllllIllIlIIlIIIIllllII)) ? forceCapacity(llllllllllllllIllIlIIlIIIIllllII, llllllllllllllIllIlIIlIIIIlllIll, llllllllllllllIllIlIIlIIIIlllIlI) : llllllllllllllIllIlIIlIIIIllllII;
    }
    
    public static <K> K[][] grow(final K[][] llllllllllllllIllIIllllllIlIIIII, final long llllllllllllllIllIIllllllIlIIIlI) {
        final long llllllllllllllIllIIllllllIlIIIIl = length(llllllllllllllIllIIllllllIlIIIII);
        return (llllllllllllllIllIIllllllIlIIIlI > llllllllllllllIllIIllllllIlIIIIl) ? grow(llllllllllllllIllIIllllllIlIIIII, llllllllllllllIllIIllllllIlIIIlI, llllllllllllllIllIIllllllIlIIIIl) : llllllllllllllIllIIllllllIlIIIII;
    }
    
    public static <K> void copy(final K[][] llllllllllllllIllIlIIIIIIIIllIlI, final long llllllllllllllIllIlIIIIIIIIllIIl, final K[][] llllllllllllllIllIlIIIIIIIIllIII, final long llllllllllllllIllIlIIIIIIIIlIlll, long llllllllllllllIllIlIIIIIIIIlIIIl) {
        if (llllllllllllllIllIlIIIIIIIIlIlll <= llllllllllllllIllIlIIIIIIIIllIIl) {
            int llllllllllllllIllIlIIIIIIIlIIlII = segment(llllllllllllllIllIlIIIIIIIIllIIl);
            int llllllllllllllIllIlIIIIIIIlIIIll = segment(llllllllllllllIllIlIIIIIIIIlIlll);
            int llllllllllllllIllIlIIIIIIIlIIIlI = displacement(llllllllllllllIllIlIIIIIIIIllIIl);
            int llllllllllllllIllIlIIIIIIIlIIIIl = displacement(llllllllllllllIllIlIIIIIIIIlIlll);
            while (llllllllllllllIllIlIIIIIIIIlIIIl > 0L) {
                final int llllllllllllllIllIlIIIIIIIlIIIII = (int)Math.min((long)llllllllllllllIllIlIIIIIIIIlIIIl, Math.min(llllllllllllllIllIlIIIIIIIIllIlI[llllllllllllllIllIlIIIIIIIlIIlII].length - llllllllllllllIllIlIIIIIIIlIIIlI, llllllllllllllIllIlIIIIIIIIllIII[llllllllllllllIllIlIIIIIIIlIIIll].length - llllllllllllllIllIlIIIIIIIlIIIIl));
                if (llllllllllllllIllIlIIIIIIIlIIIII == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIIIIIIIllIlI[llllllllllllllIllIlIIIIIIIlIIlII], llllllllllllllIllIlIIIIIIIlIIIlI, llllllllllllllIllIlIIIIIIIIllIII[llllllllllllllIllIlIIIIIIIlIIIll], llllllllllllllIllIlIIIIIIIlIIIIl, llllllllllllllIllIlIIIIIIIlIIIII);
                if ((llllllllllllllIllIlIIIIIIIlIIIlI += llllllllllllllIllIlIIIIIIIlIIIII) == 134217728) {
                    llllllllllllllIllIlIIIIIIIlIIIlI = 0;
                    ++llllllllllllllIllIlIIIIIIIlIIlII;
                }
                if ((llllllllllllllIllIlIIIIIIIlIIIIl += llllllllllllllIllIlIIIIIIIlIIIII) == 134217728) {
                    llllllllllllllIllIlIIIIIIIlIIIIl = 0;
                    ++llllllllllllllIllIlIIIIIIIlIIIll;
                }
                llllllllllllllIllIlIIIIIIIIlIIIl -= llllllllllllllIllIlIIIIIIIlIIIII;
            }
        }
        else {
            int llllllllllllllIllIlIIIIIIIIlllll = segment((long)(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIIIl));
            int llllllllllllllIllIlIIIIIIIIllllI = segment((long)(llllllllllllllIllIlIIIIIIIIlIlll + llllllllllllllIllIlIIIIIIIIlIIIl));
            int llllllllllllllIllIlIIIIIIIIlllIl = displacement((long)(llllllllllllllIllIlIIIIIIIIllIIl + llllllllllllllIllIlIIIIIIIIlIIIl));
            int llllllllllllllIllIlIIIIIIIIlllII = displacement((long)(llllllllllllllIllIlIIIIIIIIlIlll + llllllllllllllIllIlIIIIIIIIlIIIl));
            while (llllllllllllllIllIlIIIIIIIIlIIIl > 0L) {
                if (llllllllllllllIllIlIIIIIIIIlllIl == 0) {
                    llllllllllllllIllIlIIIIIIIIlllIl = 134217728;
                    --llllllllllllllIllIlIIIIIIIIlllll;
                }
                if (llllllllllllllIllIlIIIIIIIIlllII == 0) {
                    llllllllllllllIllIlIIIIIIIIlllII = 134217728;
                    --llllllllllllllIllIlIIIIIIIIllllI;
                }
                final int llllllllllllllIllIlIIIIIIIIllIll = (int)Math.min((long)llllllllllllllIllIlIIIIIIIIlIIIl, Math.min(llllllllllllllIllIlIIIIIIIIlllIl, llllllllllllllIllIlIIIIIIIIlllII));
                if (llllllllllllllIllIlIIIIIIIIllIll == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIIIIIIIllIlI[llllllllllllllIllIlIIIIIIIIlllll], llllllllllllllIllIlIIIIIIIIlllIl - llllllllllllllIllIlIIIIIIIIllIll, llllllllllllllIllIlIIIIIIIIllIII[llllllllllllllIllIlIIIIIIIIllllI], llllllllllllllIllIlIIIIIIIIlllII - llllllllllllllIllIlIIIIIIIIllIll, llllllllllllllIllIlIIIIIIIIllIll);
                llllllllllllllIllIlIIIIIIIIlllIl -= llllllllllllllIllIlIIIIIIIIllIll;
                llllllllllllllIllIlIIIIIIIIlllII -= llllllllllllllIllIlIIIIIIIIllIll;
                llllllllllllllIllIlIIIIIIIIlIIIl -= llllllllllllllIllIlIIIIIIIIllIll;
            }
        }
    }
    
    public static void ensureSameLength(final int[][] llllllllllllllIllIlIlIIllIllllII, final int[][] llllllllllllllIllIlIlIIllIlllIIl) {
        if (length(llllllllllllllIllIlIlIIllIllllII) != length(llllllllllllllIllIlIlIIllIlllIIl)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(length(llllllllllllllIllIlIlIIllIllllII)).append(" != ").append(length(llllllllllllllIllIlIlIIllIlllIIl))));
        }
    }
    
    public static long[][] grow(final long[][] llllllllllllllIllIlIlIIIlIllIlll, final long llllllllllllllIllIlIlIIIlIlllIlI, final long llllllllllllllIllIlIlIIIlIlllIIl) {
        final long llllllllllllllIllIlIlIIIlIlllIII = length(llllllllllllllIllIlIlIIIlIllIlll);
        return (llllllllllllllIllIlIlIIIlIlllIlI > llllllllllllllIllIlIlIIIlIlllIII) ? ensureCapacity(llllllllllllllIllIlIlIIIlIllIlll, Math.max(llllllllllllllIllIlIlIIIlIlllIII + (llllllllllllllIllIlIlIIIlIlllIII >> 1), llllllllllllllIllIlIlIIIlIlllIlI), llllllllllllllIllIlIlIIIlIlllIIl) : llllllllllllllIllIlIlIIIlIllIlll;
    }
    
    public static boolean[][] shuffle(final boolean[][] llllllllllllllIllIlIIlIlIIIIlIlI, final Random llllllllllllllIllIlIIlIlIIIIlIll) {
        long llllllllllllllIllIlIIlIlIIIIllIl = length(llllllllllllllIllIlIIlIlIIIIlIlI);
        while (llllllllllllllIllIlIIlIlIIIIllIl-- != 0L) {
            final long llllllllllllllIllIlIIlIlIIIIllll = (llllllllllllllIllIlIIlIlIIIIlIll.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIlIlIIIIllIl + 1L);
            final boolean llllllllllllllIllIlIIlIlIIIIlllI = get(llllllllllllllIllIlIIlIlIIIIlIlI, llllllllllllllIllIlIIlIlIIIIllIl);
            set(llllllllllllllIllIlIIlIlIIIIlIlI, llllllllllllllIllIlIIlIlIIIIllIl, get(llllllllllllllIllIlIIlIlIIIIlIlI, llllllllllllllIllIlIIlIlIIIIllll));
            set(llllllllllllllIllIlIIlIlIIIIlIlI, llllllllllllllIllIlIIlIlIIIIllll, llllllllllllllIllIlIIlIlIIIIlllI);
        }
        return llllllllllllllIllIlIIlIlIIIIlIlI;
    }
    
    public static <K> void copyFromBig(final K[][] llllllllllllllIllIIllllllllllIll, final long llllllllllllllIllIlIIIIIIIIIIIIl, final K[] llllllllllllllIllIlIIIIIIIIIIIII, int llllllllllllllIllIIllllllllllIII, int llllllllllllllIllIIlllllllllIlll) {
        int llllllllllllllIllIIlllllllllllIl = segment(llllllllllllllIllIlIIIIIIIIIIIIl);
        int llllllllllllllIllIIlllllllllllII = displacement(llllllllllllllIllIlIIIIIIIIIIIIl);
        while (llllllllllllllIllIIlllllllllIlll > 0) {
            final int llllllllllllllIllIlIIIIIIIIIIIll = Math.min(llllllllllllllIllIIllllllllllIll[llllllllllllllIllIIlllllllllllIl].length - llllllllllllllIllIIlllllllllllII, llllllllllllllIllIIlllllllllIlll);
            if (llllllllllllllIllIlIIIIIIIIIIIll == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIIllllllllllIll[llllllllllllllIllIIlllllllllllIl], llllllllllllllIllIIlllllllllllII, llllllllllllllIllIlIIIIIIIIIIIII, llllllllllllllIllIIllllllllllIII, llllllllllllllIllIlIIIIIIIIIIIll);
            if ((llllllllllllllIllIIlllllllllllII += llllllllllllllIllIlIIIIIIIIIIIll) == 134217728) {
                llllllllllllllIllIIlllllllllllII = 0;
                ++llllllllllllllIllIIlllllllllllIl;
            }
            llllllllllllllIllIIllllllllllIII += llllllllllllllIllIlIIIIIIIIIIIll;
            llllllllllllllIllIIlllllllllIlll -= llllllllllllllIllIlIIIIIIIIIIIll;
        }
    }
    
    public static long length(final float[][] llllllllllllllIllIlIIIIllIlIIIIl) {
        final int llllllllllllllIllIlIIIIllIlIIIlI = llllllllllllllIllIlIIIIllIlIIIIl.length;
        return (llllllllllllllIllIlIIIIllIlIIIlI == 0) ? 0L : (start(llllllllllllllIllIlIIIIllIlIIIlI - 1) + llllllllllllllIllIlIIIIllIlIIIIl[llllllllllllllIllIlIIIIllIlIIIlI - 1].length);
    }
    
    public static double[][] grow(final double[][] llllllllllllllIllIlIIlllIIllIIll, final long llllllllllllllIllIlIIlllIIllIIlI) {
        final long llllllllllllllIllIlIIlllIIllIlII = length(llllllllllllllIllIlIIlllIIllIIll);
        return (llllllllllllllIllIlIIlllIIllIIlI > llllllllllllllIllIlIIlllIIllIlII) ? grow(llllllllllllllIllIlIIlllIIllIIll, llllllllllllllIllIlIIlllIIllIIlI, llllllllllllllIllIlIIlllIIllIlII) : llllllllllllllIllIlIIlllIIllIIll;
    }
    
    public static char[][] grow(final char[][] llllllllllllllIllIlIIIlIlIlIIlII, final long llllllllllllllIllIlIIIlIlIlIIIll) {
        final long llllllllllllllIllIlIIIlIlIlIIlIl = length(llllllllllllllIllIlIIIlIlIlIIlII);
        return (llllllllllllllIllIlIIIlIlIlIIIll > llllllllllllllIllIlIIIlIlIlIIlIl) ? grow(llllllllllllllIllIlIIIlIlIlIIlII, llllllllllllllIllIlIIIlIlIlIIIll, llllllllllllllIllIlIIIlIlIlIIlIl) : llllllllllllllIllIlIIIlIlIlIIlII;
    }
    
    public static <K> String toString(final K[][] llllllllllllllIllIIlllllIIlIIIll) {
        if (llllllllllllllIllIIlllllIIlIIIll == null) {
            return "null";
        }
        final long llllllllllllllIllIIlllllIIlIIlIl = length(llllllllllllllIllIIlllllIIlIIIll) - 1L;
        if (llllllllllllllIllIIlllllIIlIIlIl == -1L) {
            return "[]";
        }
        final StringBuilder llllllllllllllIllIIlllllIIlIIlII = new StringBuilder();
        llllllllllllllIllIIlllllIIlIIlII.append('[');
        long llllllllllllllIllIIlllllIIlIIlll = 0L;
        while (true) {
            llllllllllllllIllIIlllllIIlIIlII.append(String.valueOf(get(llllllllllllllIllIIlllllIIlIIIll, llllllllllllllIllIIlllllIIlIIlll)));
            if (llllllllllllllIllIIlllllIIlIIlll == llllllllllllllIllIIlllllIIlIIlIl) {
                break;
            }
            llllllllllllllIllIIlllllIIlIIlII.append(", ");
            ++llllllllllllllIllIIlllllIIlIIlll;
        }
        return String.valueOf(llllllllllllllIllIIlllllIIlIIlII.append(']'));
    }
    
    private static void vecSwap(final BigSwapper llllllllllllllIllIlIllIIllllIIII, long llllllllllllllIllIlIllIIlllIllll, long llllllllllllllIllIlIllIIlllIlllI, final long llllllllllllllIllIlIllIIlllIllIl) {
        for (int llllllllllllllIllIlIllIIllllIlIl = 0; llllllllllllllIllIlIllIIllllIlIl < llllllllllllllIllIlIllIIlllIllIl; ++llllllllllllllIllIlIllIIllllIlIl, ++llllllllllllllIllIlIllIIlllIllll, ++llllllllllllllIllIlIllIIlllIlllI) {
            llllllllllllllIllIlIllIIllllIIII.swap(llllllllllllllIllIlIllIIlllIllll, llllllllllllllIllIlIllIIlllIlllI);
        }
    }
    
    public static void add(final float[][] llllllllllllllIllIlIIIIllIllllIl, final long llllllllllllllIllIlIIIIllIllllII, final float llllllllllllllIllIlIIIIllIlllIll) {
        final float[] array = llllllllllllllIllIlIIIIllIllllIl[segment(llllllllllllllIllIlIIIIllIllllII)];
        final int displacement = displacement(llllllllllllllIllIlIIIIllIllllII);
        array[displacement] += llllllllllllllIllIlIIIIllIlllIll;
    }
    
    public static void decr(final float[][] llllllllllllllIllIlIIIIllIlIIlll, final long llllllllllllllIllIlIIIIllIlIlIII) {
        final float[] array = llllllllllllllIllIlIIIIllIlIIlll[segment(llllllllllllllIllIlIIIIllIlIlIII)];
        final int displacement = displacement(llllllllllllllIllIlIIIIllIlIlIII);
        --array[displacement];
    }
    
    public static void add(final long[][] llllllllllllllIllIlIlIIlIllIllIl, final long llllllllllllllIllIlIlIIlIllIllII, final long llllllllllllllIllIlIlIIlIllIlIII) {
        final long[] array = llllllllllllllIllIlIlIIlIllIllIl[segment(llllllllllllllIllIlIlIIlIllIllII)];
        final int displacement = displacement(llllllllllllllIllIlIlIIlIllIllII);
        array[displacement] += llllllllllllllIllIlIlIIlIllIlIII;
    }
    
    public static boolean get(final boolean[][] llllllllllllllIllIlIIllIIlllIIlI, final long llllllllllllllIllIlIIllIIlllIIIl) {
        return llllllllllllllIllIlIIllIIlllIIlI[segment(llllllllllllllIllIlIIllIIlllIIIl)][displacement(llllllllllllllIllIlIIllIIlllIIIl)];
    }
    
    public static void ensureFromTo(final boolean[][] llllllllllllllIllIlIIlIlIIlllllI, final long llllllllllllllIllIlIIlIlIIlllIlI, final long llllllllllllllIllIlIIlIlIIllllII) {
        ensureFromTo(length(llllllllllllllIllIlIIlIlIIlllllI), llllllllllllllIllIlIIlIlIIlllIlI, llllllllllllllIllIlIIlIlIIllllII);
    }
    
    public static char[][] grow(final char[][] llllllllllllllIllIlIIIlIlIIlllIl, final long llllllllllllllIllIlIIIlIlIIlllII, final long llllllllllllllIllIlIIIlIlIIlIlll) {
        final long llllllllllllllIllIlIIIlIlIIllIlI = length(llllllllllllllIllIlIIIlIlIIlllIl);
        return (llllllllllllllIllIlIIIlIlIIlllII > llllllllllllllIllIlIIIlIlIIllIlI) ? ensureCapacity(llllllllllllllIllIlIIIlIlIIlllIl, Math.max(llllllllllllllIllIlIIIlIlIIllIlI + (llllllllllllllIllIlIIIlIlIIllIlI >> 1), llllllllllllllIllIlIIIlIlIIlllII), llllllllllllllIllIlIIIlIlIIlIlll) : llllllllllllllIllIlIIIlIlIIlllIl;
    }
    
    public static long[][] copy(final long[][] llllllllllllllIllIlIlIIIlIIIIllI) {
        final long[][] llllllllllllllIllIlIlIIIlIIIIlll = llllllllllllllIllIlIlIIIlIIIIllI.clone();
        int llllllllllllllIllIlIlIIIlIIIlIIl = llllllllllllllIllIlIlIIIlIIIIlll.length;
        while (llllllllllllllIllIlIlIIIlIIIlIIl-- != 0) {
            llllllllllllllIllIlIlIIIlIIIIlll[llllllllllllllIllIlIlIIIlIIIlIIl] = llllllllllllllIllIlIlIIIlIIIIllI[llllllllllllllIllIlIlIIIlIIIlIIl].clone();
        }
        return llllllllllllllIllIlIlIIIlIIIIlll;
    }
    
    public static byte[][] grow(final byte[][] llllllllllllllIllIlIllIIIIIIlllI, final long llllllllllllllIllIlIllIIIIIIllIl, final long llllllllllllllIllIlIllIIIIIIllII) {
        final long llllllllllllllIllIlIllIIIIIIllll = length(llllllllllllllIllIlIllIIIIIIlllI);
        return (llllllllllllllIllIlIllIIIIIIllIl > llllllllllllllIllIlIllIIIIIIllll) ? ensureCapacity(llllllllllllllIllIlIllIIIIIIlllI, Math.max(llllllllllllllIllIlIllIIIIIIllll + (llllllllllllllIllIlIllIIIIIIllll >> 1), llllllllllllllIllIlIllIIIIIIllIl), llllllllllllllIllIlIllIIIIIIllII) : llllllllllllllIllIlIllIIIIIIlllI;
    }
    
    public static short[][] wrap(final short[] llllllllllllllIllIlIIlIIIllIIllI) {
        if (llllllllllllllIllIlIIlIIIllIIllI.length == 0) {
            return ShortBigArrays.EMPTY_BIG_ARRAY;
        }
        if (llllllllllllllIllIlIIlIIIllIIllI.length <= 134217728) {
            return new short[][] { llllllllllllllIllIlIIlIIIllIIllI };
        }
        final short[][] llllllllllllllIllIlIIlIIIllIIlIl = ShortBigArrays.newBigArray((long)llllllllllllllIllIlIIlIIIllIIllI.length);
        for (int llllllllllllllIllIlIIlIIIllIIlll = 0; llllllllllllllIllIlIIlIIIllIIlll < llllllllllllllIllIlIIlIIIllIIlIl.length; ++llllllllllllllIllIlIIlIIIllIIlll) {
            System.arraycopy(llllllllllllllIllIlIIlIIIllIIllI, (int)start(llllllllllllllIllIlIIlIIIllIIlll), llllllllllllllIllIlIIlIIIllIIlIl[llllllllllllllIllIlIIlIIIllIIlll], 0, llllllllllllllIllIlIIlIIIllIIlIl[llllllllllllllIllIlIIlIIIllIIlll].length);
        }
        return llllllllllllllIllIlIIlIIIllIIlIl;
    }
    
    public static void incr(final int[][] llllllllllllllIllIlIlIllIIlIIlII, final long llllllllllllllIllIlIlIllIIlIIIIl) {
        final int[] array = llllllllllllllIllIlIlIllIIlIIlII[segment(llllllllllllllIllIlIlIllIIlIIIIl)];
        final int displacement = displacement(llllllllllllllIllIlIlIllIIlIIIIl);
        ++array[displacement];
    }
    
    public static <K> void ensureFromTo(final K[][] llllllllllllllIllIIlllllIIIllIIl, final long llllllllllllllIllIIlllllIIIllIII, final long llllllllllllllIllIIlllllIIIlIlll) {
        ensureFromTo(length(llllllllllllllIllIIlllllIIIllIIl), llllllllllllllIllIIlllllIIIllIII, llllllllllllllIllIIlllllIIIlIlll);
    }
    
    public static byte[][] grow(final byte[][] llllllllllllllIllIlIllIIIIIlllII, final long llllllllllllllIllIlIllIIIIIllIII) {
        final long llllllllllllllIllIlIllIIIIIllIlI = length(llllllllllllllIllIlIllIIIIIlllII);
        return (llllllllllllllIllIlIllIIIIIllIII > llllllllllllllIllIlIllIIIIIllIlI) ? grow(llllllllllllllIllIlIllIIIIIlllII, llllllllllllllIllIlIllIIIIIllIII, llllllllllllllIllIlIllIIIIIllIlI) : llllllllllllllIllIlIllIIIIIlllII;
    }
    
    public static void copy(final int[][] llllllllllllllIllIlIlIlIlllllIll, final long llllllllllllllIllIlIlIlIllllllll, final int[][] llllllllllllllIllIlIlIlIlllllIIl, final long llllllllllllllIllIlIlIlIllllllIl, long llllllllllllllIllIlIlIlIllllIlll) {
        if (llllllllllllllIllIlIlIlIllllllIl <= llllllllllllllIllIlIlIlIllllllll) {
            int llllllllllllllIllIlIlIllIIIIlIlI = segment(llllllllllllllIllIlIlIlIllllllll);
            int llllllllllllllIllIlIlIllIIIIlIIl = segment(llllllllllllllIllIlIlIlIllllllIl);
            int llllllllllllllIllIlIlIllIIIIlIII = displacement(llllllllllllllIllIlIlIlIllllllll);
            int llllllllllllllIllIlIlIllIIIIIlll = displacement(llllllllllllllIllIlIlIlIllllllIl);
            while (llllllllllllllIllIlIlIlIllllIlll > 0L) {
                final int llllllllllllllIllIlIlIllIIIIIllI = (int)Math.min(llllllllllllllIllIlIlIlIllllIlll, Math.min(llllllllllllllIllIlIlIlIlllllIll[llllllllllllllIllIlIlIllIIIIlIlI].length - llllllllllllllIllIlIlIllIIIIlIII, llllllllllllllIllIlIlIlIlllllIIl[llllllllllllllIllIlIlIllIIIIlIIl].length - llllllllllllllIllIlIlIllIIIIIlll));
                if (llllllllllllllIllIlIlIllIIIIIllI == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIlIlIlllllIll[llllllllllllllIllIlIlIllIIIIlIlI], llllllllllllllIllIlIlIllIIIIlIII, llllllllllllllIllIlIlIlIlllllIIl[llllllllllllllIllIlIlIllIIIIlIIl], llllllllllllllIllIlIlIllIIIIIlll, llllllllllllllIllIlIlIllIIIIIllI);
                if ((llllllllllllllIllIlIlIllIIIIlIII += llllllllllllllIllIlIlIllIIIIIllI) == 134217728) {
                    llllllllllllllIllIlIlIllIIIIlIII = 0;
                    ++llllllllllllllIllIlIlIllIIIIlIlI;
                }
                if ((llllllllllllllIllIlIlIllIIIIIlll += llllllllllllllIllIlIlIllIIIIIllI) == 134217728) {
                    llllllllllllllIllIlIlIllIIIIIlll = 0;
                    ++llllllllllllllIllIlIlIllIIIIlIIl;
                }
                llllllllllllllIllIlIlIlIllllIlll -= llllllllllllllIllIlIlIllIIIIIllI;
            }
        }
        else {
            int llllllllllllllIllIlIlIllIIIIIlIl = segment(llllllllllllllIllIlIlIlIllllllll + llllllllllllllIllIlIlIlIllllIlll);
            int llllllllllllllIllIlIlIllIIIIIlII = segment(llllllllllllllIllIlIlIlIllllllIl + llllllllllllllIllIlIlIlIllllIlll);
            int llllllllllllllIllIlIlIllIIIIIIll = displacement(llllllllllllllIllIlIlIlIllllllll + llllllllllllllIllIlIlIlIllllIlll);
            int llllllllllllllIllIlIlIllIIIIIIlI = displacement(llllllllllllllIllIlIlIlIllllllIl + llllllllllllllIllIlIlIlIllllIlll);
            while (llllllllllllllIllIlIlIlIllllIlll > 0L) {
                if (llllllllllllllIllIlIlIllIIIIIIll == 0) {
                    llllllllllllllIllIlIlIllIIIIIIll = 134217728;
                    --llllllllllllllIllIlIlIllIIIIIlIl;
                }
                if (llllllllllllllIllIlIlIllIIIIIIlI == 0) {
                    llllllllllllllIllIlIlIllIIIIIIlI = 134217728;
                    --llllllllllllllIllIlIlIllIIIIIlII;
                }
                final int llllllllllllllIllIlIlIllIIIIIIIl = (int)Math.min(llllllllllllllIllIlIlIlIllllIlll, Math.min(llllllllllllllIllIlIlIllIIIIIIll, llllllllllllllIllIlIlIllIIIIIIlI));
                if (llllllllllllllIllIlIlIllIIIIIIIl == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIlIlIlllllIll[llllllllllllllIllIlIlIllIIIIIlIl], llllllllllllllIllIlIlIllIIIIIIll - llllllllllllllIllIlIlIllIIIIIIIl, llllllllllllllIllIlIlIlIlllllIIl[llllllllllllllIllIlIlIllIIIIIlII], llllllllllllllIllIlIlIllIIIIIIlI - llllllllllllllIllIlIlIllIIIIIIIl, llllllllllllllIllIlIlIllIIIIIIIl);
                llllllllllllllIllIlIlIllIIIIIIll -= llllllllllllllIllIlIlIllIIIIIIIl;
                llllllllllllllIllIlIlIllIIIIIIlI -= llllllllllllllIllIlIlIllIIIIIIIl;
                llllllllllllllIllIlIlIlIllllIlll -= llllllllllllllIllIlIlIllIIIIIIIl;
            }
        }
    }
    
    public static float[][] copy(final float[][] llllllllllllllIllIlIIIIIllIllIll) {
        final float[][] llllllllllllllIllIlIIIIIllIllIlI = llllllllllllllIllIlIIIIIllIllIll.clone();
        int llllllllllllllIllIlIIIIIllIlllII = llllllllllllllIllIlIIIIIllIllIlI.length;
        while (llllllllllllllIllIlIIIIIllIlllII-- != 0) {
            llllllllllllllIllIlIIIIIllIllIlI[llllllllllllllIllIlIIIIIllIlllII] = llllllllllllllIllIlIIIIIllIllIll[llllllllllllllIllIlIIIIIllIlllII].clone();
        }
        return llllllllllllllIllIlIIIIIllIllIlI;
    }
    
    private static long med3(final long llllllllllllllIllIlIllIlIllIIllI, final long llllllllllllllIllIlIllIlIllIIlIl, final long llllllllllllllIllIlIllIlIllIlIll, final LongComparator llllllllllllllIllIlIllIlIllIlIlI) {
        final int llllllllllllllIllIlIllIlIllIlIIl = llllllllllllllIllIlIllIlIllIlIlI.compare(llllllllllllllIllIlIllIlIllIIllI, llllllllllllllIllIlIllIlIllIIlIl);
        final int llllllllllllllIllIlIllIlIllIlIII = llllllllllllllIllIlIllIlIllIlIlI.compare(llllllllllllllIllIlIllIlIllIIllI, llllllllllllllIllIlIllIlIllIlIll);
        final int llllllllllllllIllIlIllIlIllIIlll = llllllllllllllIllIlIllIlIllIlIlI.compare(llllllllllllllIllIlIllIlIllIIlIl, llllllllllllllIllIlIllIlIllIlIll);
        return (llllllllllllllIllIlIllIlIllIlIIl < 0) ? ((llllllllllllllIllIlIllIlIllIIlll < 0) ? llllllllllllllIllIlIllIlIllIIlIl : ((llllllllllllllIllIlIllIlIllIlIII < 0) ? llllllllllllllIllIlIllIlIllIlIll : llllllllllllllIllIlIllIlIllIIllI)) : ((llllllllllllllIllIlIllIlIllIIlll > 0) ? llllllllllllllIllIlIllIlIllIIlIl : ((llllllllllllllIllIlIllIlIllIlIII > 0) ? llllllllllllllIllIlIllIlIllIlIll : llllllllllllllIllIlIllIlIllIIllI));
    }
    
    public static <K> K[][] copy(final K[][] llllllllllllllIllIIlllllIllIIlII) {
        final K[][] llllllllllllllIllIIlllllIllIIlIl = llllllllllllllIllIIlllllIllIIlII.clone();
        int llllllllllllllIllIIlllllIllIIlll = llllllllllllllIllIIlllllIllIIlIl.length;
        while (llllllllllllllIllIIlllllIllIIlll-- != 0) {
            llllllllllllllIllIIlllllIllIIlIl[llllllllllllllIllIIlllllIllIIlll] = llllllllllllllIllIIlllllIllIIlII[llllllllllllllIllIIlllllIllIIlll].clone();
        }
        return llllllllllllllIllIIlllllIllIIlIl;
    }
    
    public static float[][] grow(final float[][] llllllllllllllIllIlIIIIlIIIIlIlI, final long llllllllllllllIllIlIIIIlIIIIllIl, final long llllllllllllllIllIlIIIIlIIIIllII) {
        final long llllllllllllllIllIlIIIIlIIIIlIll = length(llllllllllllllIllIlIIIIlIIIIlIlI);
        return (llllllllllllllIllIlIIIIlIIIIllIl > llllllllllllllIllIlIIIIlIIIIlIll) ? ensureCapacity(llllllllllllllIllIlIIIIlIIIIlIlI, Math.max(llllllllllllllIllIlIIIIlIIIIlIll + (llllllllllllllIllIlIIIIlIIIIlIll >> 1), llllllllllllllIllIlIIIIlIIIIllIl), llllllllllllllIllIlIIIIlIIIIllII) : llllllllllllllIllIlIIIIlIIIIlIlI;
    }
    
    public static void set(final boolean[][] llllllllllllllIllIlIIllIIllIllIl, final long llllllllllllllIllIlIIllIIllIlIIl, final boolean llllllllllllllIllIlIIllIIllIlIII) {
        llllllllllllllIllIlIIllIIllIllIl[segment(llllllllllllllIllIlIIllIIllIlIIl)][displacement(llllllllllllllIllIlIIllIIllIlIIl)] = llllllllllllllIllIlIIllIIllIlIII;
    }
    
    public static void copyToBig(final long[] llllllllllllllIllIlIlIIlIIIIIIIl, int llllllllllllllIllIlIlIIlIIIIIIII, final long[][] llllllllllllllIllIlIlIIlIIIIIllI, final long llllllllllllllIllIlIlIIIlllllllI, long llllllllllllllIllIlIlIIIllllllIl) {
        int llllllllllllllIllIlIlIIlIIIIIIll = segment(llllllllllllllIllIlIlIIIlllllllI);
        int llllllllllllllIllIlIlIIlIIIIIIlI = displacement(llllllllllllllIllIlIlIIIlllllllI);
        while (llllllllllllllIllIlIlIIIllllllIl > 0L) {
            final int llllllllllllllIllIlIlIIlIIIIlIIl = (int)Math.min(llllllllllllllIllIlIlIIlIIIIIllI[llllllllllllllIllIlIlIIlIIIIIIll].length - llllllllllllllIllIlIlIIlIIIIIIlI, llllllllllllllIllIlIlIIIllllllIl);
            if (llllllllllllllIllIlIlIIlIIIIlIIl == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIlIIlIIIIIIIl, llllllllllllllIllIlIlIIlIIIIIIII, llllllllllllllIllIlIlIIlIIIIIllI[llllllllllllllIllIlIlIIlIIIIIIll], llllllllllllllIllIlIlIIlIIIIIIlI, llllllllllllllIllIlIlIIlIIIIlIIl);
            if ((llllllllllllllIllIlIlIIlIIIIIIlI += llllllllllllllIllIlIlIIlIIIIlIIl) == 134217728) {
                llllllllllllllIllIlIlIIlIIIIIIlI = 0;
                ++llllllllllllllIllIlIlIIlIIIIIIll;
            }
            llllllllllllllIllIlIlIIlIIIIIIII += llllllllllllllIllIlIlIIlIIIIlIIl;
            llllllllllllllIllIlIlIIIllllllIl -= llllllllllllllIllIlIlIIlIIIIlIIl;
        }
    }
    
    public static int[][] setLength(final int[][] llllllllllllllIllIlIlIlIIIlIllIl, final long llllllllllllllIllIlIlIlIIIlIlIIl) {
        final long llllllllllllllIllIlIlIlIIIlIlIll = length(llllllllllllllIllIlIlIlIIIlIllIl);
        if (llllllllllllllIllIlIlIlIIIlIlIIl == llllllllllllllIllIlIlIlIIIlIlIll) {
            return llllllllllllllIllIlIlIlIIIlIllIl;
        }
        if (llllllllllllllIllIlIlIlIIIlIlIIl < llllllllllllllIllIlIlIlIIIlIlIll) {
            return trim(llllllllllllllIllIlIlIlIIIlIllIl, llllllllllllllIllIlIlIlIIIlIlIIl);
        }
        return ensureCapacity(llllllllllllllIllIlIlIlIIIlIllIl, llllllllllllllIllIlIlIlIIIlIlIIl);
    }
    
    public static boolean[][] copy(final boolean[][] llllllllllllllIllIlIIlIllIIIlIII) {
        final boolean[][] llllllllllllllIllIlIIlIllIIIIlll = llllllllllllllIllIlIIlIllIIIlIII.clone();
        int llllllllllllllIllIlIIlIllIIIlIIl = llllllllllllllIllIlIIlIllIIIIlll.length;
        while (llllllllllllllIllIlIIlIllIIIlIIl-- != 0) {
            llllllllllllllIllIlIIlIllIIIIlll[llllllllllllllIllIlIIlIllIIIlIIl] = llllllllllllllIllIlIIlIllIIIlIII[llllllllllllllIllIlIIlIllIIIlIIl].clone();
        }
        return llllllllllllllIllIlIIlIllIIIIlll;
    }
    
    public static double[][] grow(final double[][] llllllllllllllIllIlIIlllIIlIllII, final long llllllllllllllIllIlIIlllIIlIlIll, final long llllllllllllllIllIlIIlllIIlIIllI) {
        final long llllllllllllllIllIlIIlllIIlIlIIl = length(llllllllllllllIllIlIIlllIIlIllII);
        return (llllllllllllllIllIlIIlllIIlIlIll > llllllllllllllIllIlIIlllIIlIlIIl) ? ensureCapacity(llllllllllllllIllIlIIlllIIlIllII, Math.max(llllllllllllllIllIlIIlllIIlIlIIl + (llllllllllllllIllIlIIlllIIlIlIIl >> 1), llllllllllllllIllIlIIlllIIlIlIll), llllllllllllllIllIlIIlllIIlIIllI) : llllllllllllllIllIlIIlllIIlIllII;
    }
    
    private static long lowerBound(long llllllllllllllIllIlIllIlIllllIll, final long llllllllllllllIllIlIllIlIllllIlI, final long llllllllllllllIllIlIllIlIllllllI, final LongComparator llllllllllllllIllIlIllIlIllllIII) {
        long llllllllllllllIllIlIllIlIlllllII = (long)(llllllllllllllIllIlIllIlIllllIlI - llllllllllllllIllIlIllIlIllllIll);
        while (llllllllllllllIllIlIllIlIlllllII > 0L) {
            final long llllllllllllllIllIlIllIllIIIIIlI = llllllllllllllIllIlIllIlIlllllII / 2L;
            final long llllllllllllllIllIlIllIllIIIIIIl = (long)(llllllllllllllIllIlIllIlIllllIll + llllllllllllllIllIlIllIllIIIIIlI);
            if (llllllllllllllIllIlIllIlIllllIII.compare(llllllllllllllIllIlIllIllIIIIIIl, llllllllllllllIllIlIllIlIllllllI) < 0) {
                llllllllllllllIllIlIllIlIllllIll = llllllllllllllIllIlIllIllIIIIIIl + 1L;
                llllllllllllllIllIlIllIlIlllllII -= llllllllllllllIllIlIllIllIIIIIlI + 1L;
            }
            else {
                llllllllllllllIllIlIllIlIlllllII = llllllllllllllIllIlIllIllIIIIIlI;
            }
        }
        return (long)llllllllllllllIllIlIllIlIllllIll;
    }
    
    public static char[][] wrap(final char[] llllllllllllllIllIlIIIlIllIlIlIl) {
        if (llllllllllllllIllIlIIIlIllIlIlIl.length == 0) {
            return CharBigArrays.EMPTY_BIG_ARRAY;
        }
        if (llllllllllllllIllIlIIIlIllIlIlIl.length <= 134217728) {
            return new char[][] { llllllllllllllIllIlIIIlIllIlIlIl };
        }
        final char[][] llllllllllllllIllIlIIIlIllIlIllI = CharBigArrays.newBigArray((long)llllllllllllllIllIlIIIlIllIlIlIl.length);
        for (int llllllllllllllIllIlIIIlIllIllIII = 0; llllllllllllllIllIlIIIlIllIllIII < llllllllllllllIllIlIIIlIllIlIllI.length; ++llllllllllllllIllIlIIIlIllIllIII) {
            System.arraycopy(llllllllllllllIllIlIIIlIllIlIlIl, (int)start(llllllllllllllIllIlIIIlIllIllIII), llllllllllllllIllIlIIIlIllIlIllI[llllllllllllllIllIlIIIlIllIllIII], 0, llllllllllllllIllIlIIIlIllIlIllI[llllllllllllllIllIlIIIlIllIllIII].length);
        }
        return llllllllllllllIllIlIIIlIllIlIllI;
    }
    
    public static <K> long length(final K[][] llllllllllllllIllIlIIIIIIIllIIlI) {
        final int llllllllllllllIllIlIIIIIIIllIIIl = llllllllllllllIllIlIIIIIIIllIIlI.length;
        return (llllllllllllllIllIlIIIIIIIllIIIl == 0) ? 0L : (start(llllllllllllllIllIlIIIIIIIllIIIl - 1) + llllllllllllllIllIlIIIIIIIllIIlI[llllllllllllllIllIlIIIIIIIllIIIl - 1].length);
    }
    
    private static long upperBound(long llllllllllllllIllIlIllIlIIIIIIIl, final long llllllllllllllIllIlIllIlIIIIIlIl, final long llllllllllllllIllIlIllIIllllllll, final LongComparator llllllllllllllIllIlIllIIlllllllI) {
        long llllllllllllllIllIlIllIlIIIIIIlI = llllllllllllllIllIlIllIlIIIIIlIl - llllllllllllllIllIlIllIlIIIIIIIl;
        while (llllllllllllllIllIlIllIlIIIIIIlI > 0L) {
            final long llllllllllllllIllIlIllIlIIIIlIII = llllllllllllllIllIlIllIlIIIIIIlI / 2L;
            final long llllllllllllllIllIlIllIlIIIIIlll = llllllllllllllIllIlIllIlIIIIIIIl + llllllllllllllIllIlIllIlIIIIlIII;
            if (llllllllllllllIllIlIllIIlllllllI.compare(llllllllllllllIllIlIllIIllllllll, llllllllllllllIllIlIllIlIIIIIlll) < 0) {
                llllllllllllllIllIlIllIlIIIIIIlI = llllllllllllllIllIlIllIlIIIIlIII;
            }
            else {
                llllllllllllllIllIlIllIlIIIIIIIl = llllllllllllllIllIlIllIlIIIIIlll + 1L;
                llllllllllllllIllIlIllIlIIIIIIlI -= llllllllllllllIllIlIllIlIIIIlIII + 1L;
            }
        }
        return llllllllllllllIllIlIllIlIIIIIIIl;
    }
    
    public static int[][] shuffle(final int[][] llllllllllllllIllIlIlIIllIlIlIlI, final long llllllllllllllIllIlIlIIllIlIllIl, final long llllllllllllllIllIlIlIIllIlIllII, final Random llllllllllllllIllIlIlIIllIlIlIll) {
        long llllllllllllllIllIlIlIIllIlIllll = llllllllllllllIllIlIlIIllIlIllII - llllllllllllllIllIlIlIIllIlIllIl;
        while (llllllllllllllIllIlIlIIllIlIllll-- != 0L) {
            final long llllllllllllllIllIlIlIIllIllIIIl = (llllllllllllllIllIlIlIIllIlIlIll.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIlIIllIlIllll + 1L);
            final int llllllllllllllIllIlIlIIllIllIIII = get(llllllllllllllIllIlIlIIllIlIlIlI, llllllllllllllIllIlIlIIllIlIllIl + llllllllllllllIllIlIlIIllIlIllll);
            set(llllllllllllllIllIlIlIIllIlIlIlI, llllllllllllllIllIlIlIIllIlIllIl + llllllllllllllIllIlIlIIllIlIllll, get(llllllllllllllIllIlIlIIllIlIlIlI, llllllllllllllIllIlIlIIllIlIllIl + llllllllllllllIllIlIlIIllIllIIIl));
            set(llllllllllllllIllIlIlIIllIlIlIlI, llllllllllllllIllIlIlIIllIlIllIl + llllllllllllllIllIlIlIIllIllIIIl, llllllllllllllIllIlIlIIllIllIIII);
        }
        return llllllllllllllIllIlIlIIllIlIlIlI;
    }
    
    public static float[][] ensureCapacity(final float[][] llllllllllllllIllIlIIIIlIIIllllI, final long llllllllllllllIllIlIIIIlIIlIIIII, final long llllllllllllllIllIlIIIIlIIIlllll) {
        return (llllllllllllllIllIlIIIIlIIlIIIII > length(llllllllllllllIllIlIIIIlIIIllllI)) ? forceCapacity(llllllllllllllIllIlIIIIlIIIllllI, llllllllllllllIllIlIIIIlIIlIIIII, llllllllllllllIllIlIIIIlIIIlllll) : llllllllllllllIllIlIIIIlIIIllllI;
    }
    
    public static short[][] trim(final short[][] llllllllllllllIllIlIIlIIIIIllIII, final long llllllllllllllIllIlIIlIIIIIlllIl) {
        ensureLength(llllllllllllllIllIlIIlIIIIIlllIl);
        final long llllllllllllllIllIlIIlIIIIIlllII = length(llllllllllllllIllIlIIlIIIIIllIII);
        if (llllllllllllllIllIlIIlIIIIIlllIl >= llllllllllllllIllIlIIlIIIIIlllII) {
            return llllllllllllllIllIlIIlIIIIIllIII;
        }
        final int llllllllllllllIllIlIIlIIIIIllIll = (int)(llllllllllllllIllIlIIlIIIIIlllIl + 134217727L >>> 27);
        final short[][] llllllllllllllIllIlIIlIIIIIllIlI = Arrays.copyOf(llllllllllllllIllIlIIlIIIIIllIII, llllllllllllllIllIlIIlIIIIIllIll);
        final int llllllllllllllIllIlIIlIIIIIllIIl = (int)(llllllllllllllIllIlIIlIIIIIlllIl & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIlIIIIIllIIl != 0) {
            llllllllllllllIllIlIIlIIIIIllIlI[llllllllllllllIllIlIIlIIIIIllIll - 1] = ShortArrays.trim(llllllllllllllIllIlIIlIIIIIllIlI[llllllllllllllIllIlIIlIIIIIllIll - 1], llllllllllllllIllIlIIlIIIIIllIIl);
        }
        return llllllllllllllIllIlIIlIIIIIllIlI;
    }
    
    public static float[][] wrap(final float[] llllllllllllllIllIlIIIIlIlIIIllI) {
        if (llllllllllllllIllIlIIIIlIlIIIllI.length == 0) {
            return FloatBigArrays.EMPTY_BIG_ARRAY;
        }
        if (llllllllllllllIllIlIIIIlIlIIIllI.length <= 134217728) {
            return new float[][] { llllllllllllllIllIlIIIIlIlIIIllI };
        }
        final float[][] llllllllllllllIllIlIIIIlIlIIIlll = FloatBigArrays.newBigArray((long)llllllllllllllIllIlIIIIlIlIIIllI.length);
        for (int llllllllllllllIllIlIIIIlIlIIlIIl = 0; llllllllllllllIllIlIIIIlIlIIlIIl < llllllllllllllIllIlIIIIlIlIIIlll.length; ++llllllllllllllIllIlIIIIlIlIIlIIl) {
            System.arraycopy(llllllllllllllIllIlIIIIlIlIIIllI, (int)start(llllllllllllllIllIlIIIIlIlIIlIIl), llllllllllllllIllIlIIIIlIlIIIlll[llllllllllllllIllIlIIIIlIlIIlIIl], 0, llllllllllllllIllIlIIIIlIlIIIlll[llllllllllllllIllIlIIIIlIlIIlIIl].length);
        }
        return llllllllllllllIllIlIIIIlIlIIIlll;
    }
    
    public static void fill(final long[][] llllllllllllllIllIlIlIIIIlllllIl, final long llllllllllllllIllIlIlIIIIllllllI) {
        int llllllllllllllIllIlIlIIIlIIIIIII = llllllllllllllIllIlIlIIIIlllllIl.length;
        while (llllllllllllllIllIlIlIIIlIIIIIII-- != 0) {
            Arrays.fill(llllllllllllllIllIlIlIIIIlllllIl[llllllllllllllIllIlIlIIIlIIIIIII], llllllllllllllIllIlIlIIIIllllllI);
        }
    }
    
    public static <K> K[][] wrap(final K[] llllllllllllllIllIIlllllllIlIllI) {
        if (llllllllllllllIllIIlllllllIlIllI.length == 0 && llllllllllllllIllIIlllllllIlIllI.getClass() == Object[].class) {
            return (K[][])ObjectBigArrays.EMPTY_BIG_ARRAY;
        }
        if (llllllllllllllIllIIlllllllIlIllI.length <= 134217728) {
            final K[][] llllllllllllllIllIIlllllllIllIII = (K[][])Array.newInstance(llllllllllllllIllIIlllllllIlIllI.getClass(), 1);
            llllllllllllllIllIIlllllllIllIII[0] = llllllllllllllIllIIlllllllIlIllI;
            return llllllllllllllIllIIlllllllIllIII;
        }
        final K[][] llllllllllllllIllIIlllllllIlIlIl = (K[][])ObjectBigArrays.newBigArray((Class)llllllllllllllIllIIlllllllIlIllI.getClass(), (long)llllllllllllllIllIIlllllllIlIllI.length);
        for (int llllllllllllllIllIIlllllllIlIlll = 0; llllllllllllllIllIIlllllllIlIlll < llllllllllllllIllIIlllllllIlIlIl.length; ++llllllllllllllIllIIlllllllIlIlll) {
            System.arraycopy(llllllllllllllIllIIlllllllIlIllI, (int)start(llllllllllllllIllIIlllllllIlIlll), llllllllllllllIllIIlllllllIlIlIl[llllllllllllllIllIIlllllllIlIlll], 0, llllllllllllllIllIIlllllllIlIlIl[llllllllllllllIllIIlllllllIlIlll].length);
        }
        return llllllllllllllIllIIlllllllIlIlIl;
    }
    
    public static void decr(final char[][] llllllllllllllIllIlIIIllIIlllIII, final long llllllllllllllIllIlIIIllIIllIlIl) {
        final char[] array = llllllllllllllIllIlIIIllIIlllIII[segment(llllllllllllllIllIlIIIllIIllIlIl)];
        final int displacement = displacement(llllllllllllllIllIlIIIllIIllIlIl);
        --array[displacement];
    }
    
    public static byte[][] ensureCapacity(final byte[][] llllllllllllllIllIlIllIIIlIIIIll, final long llllllllllllllIllIlIllIIIlIIIlII) {
        return ensureCapacity(llllllllllllllIllIlIllIIIlIIIIll, llllllllllllllIllIlIllIIIlIIIlII, length(llllllllllllllIllIlIllIIIlIIIIll));
    }
    
    public static boolean[][] trim(final boolean[][] llllllllllllllIllIlIIlIllIlIIlll, final long llllllllllllllIllIlIIlIllIlIllII) {
        ensureLength(llllllllllllllIllIlIIlIllIlIllII);
        final long llllllllllllllIllIlIIlIllIlIlIll = length(llllllllllllllIllIlIIlIllIlIIlll);
        if (llllllllllllllIllIlIIlIllIlIllII >= llllllllllllllIllIlIIlIllIlIlIll) {
            return llllllllllllllIllIlIIlIllIlIIlll;
        }
        final int llllllllllllllIllIlIIlIllIlIlIlI = (int)(llllllllllllllIllIlIIlIllIlIllII + 134217727L >>> 27);
        final boolean[][] llllllllllllllIllIlIIlIllIlIlIIl = Arrays.copyOf(llllllllllllllIllIlIIlIllIlIIlll, llllllllllllllIllIlIIlIllIlIlIlI);
        final int llllllllllllllIllIlIIlIllIlIlIII = (int)(llllllllllllllIllIlIIlIllIlIllII & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIlIllIlIlIII != 0) {
            llllllllllllllIllIlIIlIllIlIlIIl[llllllllllllllIllIlIIlIllIlIlIlI - 1] = BooleanArrays.trim(llllllllllllllIllIlIIlIllIlIlIIl[llllllllllllllIllIlIIlIllIlIlIlI - 1], llllllllllllllIllIlIIlIllIlIlIII);
        }
        return llllllllllllllIllIlIIlIllIlIlIIl;
    }
    
    public static boolean equals(final float[][] llllllllllllllIllIlIIIIIlIlIIllI, final float[][] llllllllllllllIllIlIIIIIlIlIIlIl) {
        if (length(llllllllllllllIllIlIIIIIlIlIIllI) != length(llllllllllllllIllIlIIIIIlIlIIlIl)) {
            return false;
        }
        int llllllllllllllIllIlIIIIIlIlIIlll = llllllllllllllIllIlIIIIIlIlIIllI.length;
        while (llllllllllllllIllIlIIIIIlIlIIlll-- != 0) {
            final float[] llllllllllllllIllIlIIIIIlIlIlIll = llllllllllllllIllIlIIIIIlIlIIllI[llllllllllllllIllIlIIIIIlIlIIlll];
            final float[] llllllllllllllIllIlIIIIIlIlIlIlI = llllllllllllllIllIlIIIIIlIlIIlIl[llllllllllllllIllIlIIIIIlIlIIlll];
            int llllllllllllllIllIlIIIIIlIlIllII = llllllllllllllIllIlIIIIIlIlIlIll.length;
            while (llllllllllllllIllIlIIIIIlIlIllII-- != 0) {
                if (Float.floatToIntBits(llllllllllllllIllIlIIIIIlIlIlIll[llllllllllllllIllIlIIIIIlIlIllII]) != Float.floatToIntBits(llllllllllllllIllIlIIIIIlIlIlIlI[llllllllllllllIllIlIIIIIlIlIllII])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean[][] copy(final boolean[][] llllllllllllllIllIlIIlIllIIlIIII, final long llllllllllllllIllIlIIlIllIIlIIll, final long llllllllllllllIllIlIIlIllIIIlllI) {
        ensureOffsetLength(llllllllllllllIllIlIIlIllIIlIIII, llllllllllllllIllIlIIlIllIIlIIll, llllllllllllllIllIlIIlIllIIIlllI);
        final boolean[][] llllllllllllllIllIlIIlIllIIlIIIl = BooleanBigArrays.newBigArray(llllllllllllllIllIlIIlIllIIIlllI);
        copy(llllllllllllllIllIlIIlIllIIlIIII, llllllllllllllIllIlIIlIllIIlIIll, llllllllllllllIllIlIIlIllIIlIIIl, 0L, llllllllllllllIllIlIIlIllIIIlllI);
        return llllllllllllllIllIlIIlIllIIlIIIl;
    }
    
    public static int displacement(final long llllllllllllllIllIlIllIlllIIllll) {
        return (int)(llllllllllllllIllIlIllIlllIIllll & 0x7FFFFFFL);
    }
    
    public static <K> K[][] shuffle(final K[][] llllllllllllllIllIIllllIlllIlIlI, final Random llllllllllllllIllIIllllIlllIIlll) {
        long llllllllllllllIllIIllllIlllIlIll = length(llllllllllllllIllIIllllIlllIlIlI);
        while (llllllllllllllIllIIllllIlllIlIll-- != 0L) {
            final long llllllllllllllIllIIllllIlllIllIl = (llllllllllllllIllIIllllIlllIIlll.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIIllllIlllIlIll + 1L);
            final K llllllllllllllIllIIllllIlllIllII = get(llllllllllllllIllIIllllIlllIlIlI, llllllllllllllIllIIllllIlllIlIll);
            set(llllllllllllllIllIIllllIlllIlIlI, llllllllllllllIllIIllllIlllIlIll, (K)get((K[][])llllllllllllllIllIIllllIlllIlIlI, llllllllllllllIllIIllllIlllIllIl));
            set(llllllllllllllIllIIllllIlllIlIlI, llllllllllllllIllIIllllIlllIllIl, llllllllllllllIllIIllllIlllIllII);
        }
        return llllllllllllllIllIIllllIlllIlIlI;
    }
    
    public static void copy(final double[][] llllllllllllllIllIlIIllllIlIIlII, final long llllllllllllllIllIlIIllllIlIIIll, final double[][] llllllllllllllIllIlIIllllIlIIIlI, final long llllllllllllllIllIlIIllllIlIIIIl, long llllllllllllllIllIlIIllllIlIIIII) {
        if (llllllllllllllIllIlIIllllIlIIIIl <= llllllllllllllIllIlIIllllIlIIIll) {
            int llllllllllllllIllIlIIllllIllIIll = segment(llllllllllllllIllIlIIllllIlIIIll);
            int llllllllllllllIllIlIIllllIllIIlI = segment(llllllllllllllIllIlIIllllIlIIIIl);
            int llllllllllllllIllIlIIllllIllIIIl = displacement(llllllllllllllIllIlIIllllIlIIIll);
            int llllllllllllllIllIlIIllllIllIIII = displacement(llllllllllllllIllIlIIllllIlIIIIl);
            while (llllllllllllllIllIlIIllllIlIIIII > 0L) {
                final int llllllllllllllIllIlIIllllIlIllll = (int)Math.min(llllllllllllllIllIlIIllllIlIIIII, Math.min(llllllllllllllIllIlIIllllIlIIlII[llllllllllllllIllIlIIllllIllIIll].length - llllllllllllllIllIlIIllllIllIIIl, llllllllllllllIllIlIIllllIlIIIlI[llllllllllllllIllIlIIllllIllIIlI].length - llllllllllllllIllIlIIllllIllIIII));
                if (llllllllllllllIllIlIIllllIlIllll == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIllllIlIIlII[llllllllllllllIllIlIIllllIllIIll], llllllllllllllIllIlIIllllIllIIIl, llllllllllllllIllIlIIllllIlIIIlI[llllllllllllllIllIlIIllllIllIIlI], llllllllllllllIllIlIIllllIllIIII, llllllllllllllIllIlIIllllIlIllll);
                if ((llllllllllllllIllIlIIllllIllIIIl += llllllllllllllIllIlIIllllIlIllll) == 134217728) {
                    llllllllllllllIllIlIIllllIllIIIl = 0;
                    ++llllllllllllllIllIlIIllllIllIIll;
                }
                if ((llllllllllllllIllIlIIllllIllIIII += llllllllllllllIllIlIIllllIlIllll) == 134217728) {
                    llllllllllllllIllIlIIllllIllIIII = 0;
                    ++llllllllllllllIllIlIIllllIllIIlI;
                }
                llllllllllllllIllIlIIllllIlIIIII -= llllllllllllllIllIlIIllllIlIllll;
            }
        }
        else {
            int llllllllllllllIllIlIIllllIlIlllI = segment(llllllllllllllIllIlIIllllIlIIIll + llllllllllllllIllIlIIllllIlIIIII);
            int llllllllllllllIllIlIIllllIlIllIl = segment(llllllllllllllIllIlIIllllIlIIIIl + llllllllllllllIllIlIIllllIlIIIII);
            int llllllllllllllIllIlIIllllIlIllII = displacement(llllllllllllllIllIlIIllllIlIIIll + llllllllllllllIllIlIIllllIlIIIII);
            int llllllllllllllIllIlIIllllIlIlIll = displacement(llllllllllllllIllIlIIllllIlIIIIl + llllllllllllllIllIlIIllllIlIIIII);
            while (llllllllllllllIllIlIIllllIlIIIII > 0L) {
                if (llllllllllllllIllIlIIllllIlIllII == 0) {
                    llllllllllllllIllIlIIllllIlIllII = 134217728;
                    --llllllllllllllIllIlIIllllIlIlllI;
                }
                if (llllllllllllllIllIlIIllllIlIlIll == 0) {
                    llllllllllllllIllIlIIllllIlIlIll = 134217728;
                    --llllllllllllllIllIlIIllllIlIllIl;
                }
                final int llllllllllllllIllIlIIllllIlIlIlI = (int)Math.min(llllllllllllllIllIlIIllllIlIIIII, Math.min(llllllllllllllIllIlIIllllIlIllII, llllllllllllllIllIlIIllllIlIlIll));
                if (llllllllllllllIllIlIIllllIlIlIlI == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIllllIlIIlII[llllllllllllllIllIlIIllllIlIlllI], llllllllllllllIllIlIIllllIlIllII - llllllllllllllIllIlIIllllIlIlIlI, llllllllllllllIllIlIIllllIlIIIlI[llllllllllllllIllIlIIllllIlIllIl], llllllllllllllIllIlIIllllIlIlIll - llllllllllllllIllIlIIllllIlIlIlI, llllllllllllllIllIlIIllllIlIlIlI);
                llllllllllllllIllIlIIllllIlIllII -= llllllllllllllIllIlIIllllIlIlIlI;
                llllllllllllllIllIlIIllllIlIlIll -= llllllllllllllIllIlIIllllIlIlIlI;
                llllllllllllllIllIlIIllllIlIIIII -= llllllllllllllIllIlIIllllIlIlIlI;
            }
        }
    }
    
    public static <K> void ensureOffsetLength(final K[][] llllllllllllllIllIIlllllIIIlIIII, final long llllllllllllllIllIIlllllIIIIllll, final long llllllllllllllIllIIlllllIIIIlllI) {
        ensureOffsetLength(length(llllllllllllllIllIIlllllIIIlIIII), llllllllllllllIllIIlllllIIIIllll, llllllllllllllIllIIlllllIIIIlllI);
    }
    
    public static int segment(final long llllllllllllllIllIlIllIlllIlIIIl) {
        return (int)(llllllllllllllIllIlIllIlllIlIIIl >>> 27);
    }
    
    public static void mul(final int[][] llllllllllllllIllIlIlIllIIlIllII, final long llllllllllllllIllIlIlIllIIlIlIll, final int llllllllllllllIllIlIlIllIIlIIlll) {
        final int[] array = llllllllllllllIllIlIlIllIIlIllII[segment(llllllllllllllIllIlIlIllIIlIlIll)];
        final int displacement = displacement(llllllllllllllIllIlIlIllIIlIlIll);
        array[displacement] *= llllllllllllllIllIlIlIllIIlIIlll;
    }
    
    public static <K> K[][] shuffle(final K[][] llllllllllllllIllIIllllIllllllIl, final long llllllllllllllIllIIllllIllllllII, final long llllllllllllllIllIIllllIllllIlll, final Random llllllllllllllIllIIllllIllllIllI) {
        long llllllllllllllIllIIllllIlllllllI = llllllllllllllIllIIllllIllllIlll - llllllllllllllIllIIllllIllllllII;
        while (llllllllllllllIllIIllllIlllllllI-- != 0L) {
            final long llllllllllllllIllIIlllllIIIIIIII = (llllllllllllllIllIIllllIllllIllI.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIIllllIlllllllI + 1L);
            final K llllllllllllllIllIIllllIllllllll = get(llllllllllllllIllIIllllIllllllIl, llllllllllllllIllIIllllIllllllII + llllllllllllllIllIIllllIlllllllI);
            set(llllllllllllllIllIIllllIllllllIl, llllllllllllllIllIIllllIllllllII + llllllllllllllIllIIllllIlllllllI, (K)get((K[][])llllllllllllllIllIIllllIllllllIl, llllllllllllllIllIIllllIllllllII + llllllllllllllIllIIlllllIIIIIIII));
            set(llllllllllllllIllIIllllIllllllIl, llllllllllllllIllIIllllIllllllII + llllllllllllllIllIIlllllIIIIIIII, llllllllllllllIllIIllllIllllllll);
        }
        return llllllllllllllIllIIllllIllllllIl;
    }
    
    public static void ensureSameLength(final float[][] llllllllllllllIllIlIIIIIlIIIIIII, final float[][] llllllllllllllIllIlIIIIIIlllllll) {
        if (length(llllllllllllllIllIlIIIIIlIIIIIII) != length(llllllllllllllIllIlIIIIIIlllllll)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(length(llllllllllllllIllIlIIIIIlIIIIIII)).append(" != ").append(length(llllllllllllllIllIlIIIIIIlllllll))));
        }
    }
    
    public static float[][] ensureCapacity(final float[][] llllllllllllllIllIlIIIIlIlIIIIIl, final long llllllllllllllIllIlIIIIlIlIIIIII) {
        return ensureCapacity(llllllllllllllIllIlIIIIlIlIIIIIl, llllllllllllllIllIlIIIIlIlIIIIII, length(llllllllllllllIllIlIIIIlIlIIIIIl));
    }
    
    public static long[][] shuffle(final long[][] llllllllllllllIllIlIlIIIIIIllIll, final long llllllllllllllIllIlIlIIIIIIllllI, final long llllllllllllllIllIlIlIIIIIIlllIl, final Random llllllllllllllIllIlIlIIIIIIllIII) {
        long llllllllllllllIllIlIlIIIIIlIIIII = llllllllllllllIllIlIlIIIIIIlllIl - llllllllllllllIllIlIlIIIIIIllllI;
        while (llllllllllllllIllIlIlIIIIIlIIIII-- != 0L) {
            final long llllllllllllllIllIlIlIIIIIlIIIlI = (llllllllllllllIllIlIlIIIIIIllIII.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIlIIIIIlIIIII + 1L);
            final long llllllllllllllIllIlIlIIIIIlIIIIl = get(llllllllllllllIllIlIlIIIIIIllIll, llllllllllllllIllIlIlIIIIIIllllI + llllllllllllllIllIlIlIIIIIlIIIII);
            set(llllllllllllllIllIlIlIIIIIIllIll, llllllllllllllIllIlIlIIIIIIllllI + llllllllllllllIllIlIlIIIIIlIIIII, get(llllllllllllllIllIlIlIIIIIIllIll, llllllllllllllIllIlIlIIIIIIllllI + llllllllllllllIllIlIlIIIIIlIIIlI));
            set(llllllllllllllIllIlIlIIIIIIllIll, llllllllllllllIllIlIlIIIIIIllllI + llllllllllllllIllIlIlIIIIIlIIIlI, llllllllllllllIllIlIlIIIIIlIIIIl);
        }
        return llllllllllllllIllIlIlIIIIIIllIll;
    }
    
    public static void add(final int[][] llllllllllllllIllIlIlIllIIllIIlI, final long llllllllllllllIllIlIlIllIIllIlII, final int llllllllllllllIllIlIlIllIIllIIll) {
        final int[] array = llllllllllllllIllIlIlIllIIllIIlI[segment(llllllllllllllIllIlIlIllIIllIlII)];
        final int displacement = displacement(llllllllllllllIllIlIlIllIIllIlII);
        array[displacement] += llllllllllllllIllIlIlIllIIllIIll;
    }
    
    public static long length(final double[][] llllllllllllllIllIlIIlllllIIIIIl) {
        final int llllllllllllllIllIlIIlllllIIIIII = llllllllllllllIllIlIIlllllIIIIIl.length;
        return (llllllllllllllIllIlIIlllllIIIIII == 0) ? 0L : (start(llllllllllllllIllIlIIlllllIIIIII - 1) + llllllllllllllIllIlIIlllllIIIIIl[llllllllllllllIllIlIIlllllIIIIII - 1].length);
    }
    
    public static long[][] grow(final long[][] llllllllllllllIllIlIlIIIllIIIlIl, final long llllllllllllllIllIlIlIIIllIIIIIl) {
        final long llllllllllllllIllIlIlIIIllIIIIll = length(llllllllllllllIllIlIlIIIllIIIlIl);
        return (llllllllllllllIllIlIlIIIllIIIIIl > llllllllllllllIllIlIlIIIllIIIIll) ? grow(llllllllllllllIllIlIlIIIllIIIlIl, llllllllllllllIllIlIlIIIllIIIIIl, llllllllllllllIllIlIlIIIllIIIIll) : llllllllllllllIllIlIlIIIllIIIlIl;
    }
    
    public static int[][] grow(final int[][] llllllllllllllIllIlIlIlIIlIIlIlI, final long llllllllllllllIllIlIlIlIIlIIIlIl, final long llllllllllllllIllIlIlIlIIlIIlIII) {
        final long llllllllllllllIllIlIlIlIIlIIIlll = length(llllllllllllllIllIlIlIlIIlIIlIlI);
        return (llllllllllllllIllIlIlIlIIlIIIlIl > llllllllllllllIllIlIlIlIIlIIIlll) ? ensureCapacity(llllllllllllllIllIlIlIlIIlIIlIlI, Math.max(llllllllllllllIllIlIlIlIIlIIIlll + (llllllllllllllIllIlIlIlIIlIIIlll >> 1), llllllllllllllIllIlIlIlIIlIIIlIl), llllllllllllllIllIlIlIlIIlIIlIII) : llllllllllllllIllIlIlIlIIlIIlIlI;
    }
    
    public static void add(final char[][] llllllllllllllIllIlIIIllIlIIllII, final long llllllllllllllIllIlIIIllIlIIlllI, final char llllllllllllllIllIlIIIllIlIIlIlI) {
        final char[] array = llllllllllllllIllIlIIIllIlIIllII[segment(llllllllllllllIllIlIIIllIlIIlllI)];
        final int displacement = displacement(llllllllllllllIllIlIIIllIlIIlllI);
        array[displacement] += llllllllllllllIllIlIIIllIlIIlIlI;
    }
    
    public static <K> boolean equals(final K[][] llllllllllllllIllIIlllllIIllIIIl, final K[][] llllllllllllllIllIIlllllIIllIIll) {
        if (length(llllllllllllllIllIIlllllIIllIIIl) != length(llllllllllllllIllIIlllllIIllIIll)) {
            return false;
        }
        int llllllllllllllIllIIlllllIIllIIlI = llllllllllllllIllIIlllllIIllIIIl.length;
        while (llllllllllllllIllIIlllllIIllIIlI-- != 0) {
            final K[] llllllllllllllIllIIlllllIIllIllI = llllllllllllllIllIIlllllIIllIIIl[llllllllllllllIllIIlllllIIllIIlI];
            final K[] llllllllllllllIllIIlllllIIllIlIl = llllllllllllllIllIIlllllIIllIIll[llllllllllllllIllIIlllllIIllIIlI];
            int llllllllllllllIllIIlllllIIllIlll = llllllllllllllIllIIlllllIIllIllI.length;
            while (llllllllllllllIllIIlllllIIllIlll-- != 0) {
                if (!Objects.equals(llllllllllllllIllIIlllllIIllIllI[llllllllllllllIllIIlllllIIllIlll], llllllllllllllIllIIlllllIIllIlIl[llllllllllllllIllIIlllllIIllIlll])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void copyToBig(final int[] llllllllllllllIllIlIlIlIlIlllllI, int llllllllllllllIllIlIlIlIlIllIllI, final int[][] llllllllllllllIllIlIlIlIlIllIlIl, final long llllllllllllllIllIlIlIlIlIlllIll, long llllllllllllllIllIlIlIlIlIllIIll) {
        int llllllllllllllIllIlIlIlIlIlllIIl = segment(llllllllllllllIllIlIlIlIlIlllIll);
        int llllllllllllllIllIlIlIlIlIlllIII = displacement(llllllllllllllIllIlIlIlIlIlllIll);
        while (llllllllllllllIllIlIlIlIlIllIIll > 0L) {
            final int llllllllllllllIllIlIlIlIlIllllll = (int)Math.min(llllllllllllllIllIlIlIlIlIllIlIl[llllllllllllllIllIlIlIlIlIlllIIl].length - llllllllllllllIllIlIlIlIlIlllIII, (long)llllllllllllllIllIlIlIlIlIllIIll);
            if (llllllllllllllIllIlIlIlIlIllllll == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIlIlIlIlllllI, llllllllllllllIllIlIlIlIlIllIllI, llllllllllllllIllIlIlIlIlIllIlIl[llllllllllllllIllIlIlIlIlIlllIIl], llllllllllllllIllIlIlIlIlIlllIII, llllllllllllllIllIlIlIlIlIllllll);
            if ((llllllllllllllIllIlIlIlIlIlllIII += llllllllllllllIllIlIlIlIlIllllll) == 134217728) {
                llllllllllllllIllIlIlIlIlIlllIII = 0;
                ++llllllllllllllIllIlIlIlIlIlllIIl;
            }
            llllllllllllllIllIlIlIlIlIllIllI += llllllllllllllIllIlIlIlIlIllllll;
            llllllllllllllIllIlIlIlIlIllIIll -= llllllllllllllIllIlIlIlIlIllllll;
        }
    }
    
    public static int[][] trim(final int[][] llllllllllllllIllIlIlIlIIIllllII, final long llllllllllllllIllIlIlIlIIIlllIll) {
        ensureLength(llllllllllllllIllIlIlIlIIIlllIll);
        final long llllllllllllllIllIlIlIlIIIlllIlI = length(llllllllllllllIllIlIlIlIIIllllII);
        if (llllllllllllllIllIlIlIlIIIlllIll >= llllllllllllllIllIlIlIlIIIlllIlI) {
            return llllllllllllllIllIlIlIlIIIllllII;
        }
        final int llllllllllllllIllIlIlIlIIIlllIIl = (int)(llllllllllllllIllIlIlIlIIIlllIll + 134217727L >>> 27);
        final int[][] llllllllllllllIllIlIlIlIIIlllIII = Arrays.copyOf(llllllllllllllIllIlIlIlIIIllllII, llllllllllllllIllIlIlIlIIIlllIIl);
        final int llllllllllllllIllIlIlIlIIIllIlll = (int)(llllllllllllllIllIlIlIlIIIlllIll & 0x7FFFFFFL);
        if (llllllllllllllIllIlIlIlIIIllIlll != 0) {
            llllllllllllllIllIlIlIlIIIlllIII[llllllllllllllIllIlIlIlIIIlllIIl - 1] = IntArrays.trim(llllllllllllllIllIlIlIlIIIlllIII[llllllllllllllIllIlIlIlIIIlllIIl - 1], llllllllllllllIllIlIlIlIIIllIlll);
        }
        return llllllllllllllIllIlIlIlIIIlllIII;
    }
    
    public static void set(final byte[][] llllllllllllllIllIlIllIIllIlllll, final long llllllllllllllIllIlIllIIllIllllI, final byte llllllllllllllIllIlIllIIllIlllIl) {
        llllllllllllllIllIlIllIIllIlllll[segment(llllllllllllllIllIlIllIIllIllllI)][displacement(llllllllllllllIllIlIllIIllIllllI)] = llllllllllllllIllIlIllIIllIlllIl;
    }
    
    public static <K> void fill(final K[][] llllllllllllllIllIIlllllIlIIllll, final long llllllllllllllIllIIlllllIlIIIlIl, final long llllllllllllllIllIIlllllIlIIllIl, final K llllllllllllllIllIIlllllIlIIIIll) {
        final long llllllllllllllIllIIlllllIlIIlIll = length(llllllllllllllIllIIlllllIlIIllll);
        ensureFromTo(llllllllllllllIllIIlllllIlIIlIll, llllllllllllllIllIIlllllIlIIIlIl, llllllllllllllIllIIlllllIlIIllIl);
        if (llllllllllllllIllIIlllllIlIIlIll == 0L) {
            return;
        }
        final int llllllllllllllIllIIlllllIlIIlIlI = segment(llllllllllllllIllIIlllllIlIIIlIl);
        int llllllllllllllIllIIlllllIlIIlIIl = segment(llllllllllllllIllIIlllllIlIIllIl);
        final int llllllllllllllIllIIlllllIlIIlIII = displacement(llllllllllllllIllIIlllllIlIIIlIl);
        final int llllllllllllllIllIIlllllIlIIIlll = displacement(llllllllllllllIllIIlllllIlIIllIl);
        if (llllllllllllllIllIIlllllIlIIlIlI == llllllllllllllIllIIlllllIlIIlIIl) {
            Arrays.fill(llllllllllllllIllIIlllllIlIIllll[llllllllllllllIllIIlllllIlIIlIlI], llllllllllllllIllIIlllllIlIIlIII, llllllllllllllIllIIlllllIlIIIlll, llllllllllllllIllIIlllllIlIIIIll);
            return;
        }
        if (llllllllllllllIllIIlllllIlIIIlll != 0) {
            Arrays.fill(llllllllllllllIllIIlllllIlIIllll[llllllllllllllIllIIlllllIlIIlIIl], 0, llllllllllllllIllIIlllllIlIIIlll, llllllllllllllIllIIlllllIlIIIIll);
        }
        while (--llllllllllllllIllIIlllllIlIIlIIl > llllllllllllllIllIIlllllIlIIlIlI) {
            Arrays.fill(llllllllllllllIllIIlllllIlIIllll[llllllllllllllIllIIlllllIlIIlIIl], llllllllllllllIllIIlllllIlIIIIll);
        }
        Arrays.fill(llllllllllllllIllIIlllllIlIIllll[llllllllllllllIllIIlllllIlIIlIlI], llllllllllllllIllIIlllllIlIIlIII, 134217728, llllllllllllllIllIIlllllIlIIIIll);
    }
    
    public static void ensureSameLength(final byte[][] llllllllllllllIllIlIlIlllIIIIIlI, final byte[][] llllllllllllllIllIlIlIlllIIIIIIl) {
        if (length(llllllllllllllIllIlIlIlllIIIIIlI) != length(llllllllllllllIllIlIlIlllIIIIIIl)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(length(llllllllllllllIllIlIlIlllIIIIIlI)).append(" != ").append(length(llllllllllllllIllIlIlIlllIIIIIIl))));
        }
    }
    
    public static boolean equals(final char[][] llllllllllllllIllIlIIIlIIIlllIII, final char[][] llllllllllllllIllIlIIIlIIIllIlII) {
        if (length(llllllllllllllIllIlIIIlIIIlllIII) != length(llllllllllllllIllIlIIIlIIIllIlII)) {
            return false;
        }
        int llllllllllllllIllIlIIIlIIIllIllI = llllllllllllllIllIlIIIlIIIlllIII.length;
        while (llllllllllllllIllIlIIIlIIIllIllI-- != 0) {
            final char[] llllllllllllllIllIlIIIlIIIlllIlI = llllllllllllllIllIlIIIlIIIlllIII[llllllllllllllIllIlIIIlIIIllIllI];
            final char[] llllllllllllllIllIlIIIlIIIlllIIl = llllllllllllllIllIlIIIlIIIllIlII[llllllllllllllIllIlIIIlIIIllIllI];
            int llllllllllllllIllIlIIIlIIIlllIll = llllllllllllllIllIlIIIlIIIlllIlI.length;
            while (llllllllllllllIllIlIIIlIIIlllIll-- != 0) {
                if (llllllllllllllIllIlIIIlIIIlllIlI[llllllllllllllIllIlIIIlIIIlllIll] != llllllllllllllIllIlIIIlIIIlllIIl[llllllllllllllIllIlIIIlIIIlllIll]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int[][] wrap(final int[] llllllllllllllIllIlIlIlIlIlIIIll) {
        if (llllllllllllllIllIlIlIlIlIlIIIll.length == 0) {
            return IntBigArrays.EMPTY_BIG_ARRAY;
        }
        if (llllllllllllllIllIlIlIlIlIlIIIll.length <= 134217728) {
            return new int[][] { llllllllllllllIllIlIlIlIlIlIIIll };
        }
        final int[][] llllllllllllllIllIlIlIlIlIlIIlII = IntBigArrays.newBigArray((long)llllllllllllllIllIlIlIlIlIlIIIll.length);
        for (int llllllllllllllIllIlIlIlIlIlIIlll = 0; llllllllllllllIllIlIlIlIlIlIIlll < llllllllllllllIllIlIlIlIlIlIIlII.length; ++llllllllllllllIllIlIlIlIlIlIIlll) {
            System.arraycopy(llllllllllllllIllIlIlIlIlIlIIIll, (int)start(llllllllllllllIllIlIlIlIlIlIIlll), llllllllllllllIllIlIlIlIlIlIIlII[llllllllllllllIllIlIlIlIlIlIIlll], 0, llllllllllllllIllIlIlIlIlIlIIlII[llllllllllllllIllIlIlIlIlIlIIlll].length);
        }
        return llllllllllllllIllIlIlIlIlIlIIlII;
    }
    
    public static byte[][] shuffle(final byte[][] llllllllllllllIllIlIlIllIllIIIll, final Random llllllllllllllIllIlIlIllIllIIIII) {
        long llllllllllllllIllIlIlIllIllIIlII = length(llllllllllllllIllIlIlIllIllIIIll);
        while (llllllllllllllIllIlIlIllIllIIlII-- != 0L) {
            final long llllllllllllllIllIlIlIllIllIIllI = (llllllllllllllIllIlIlIllIllIIIII.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIlIllIllIIlII + 1L);
            final byte llllllllllllllIllIlIlIllIllIIlIl = get(llllllllllllllIllIlIlIllIllIIIll, llllllllllllllIllIlIlIllIllIIlII);
            set(llllllllllllllIllIlIlIllIllIIIll, llllllllllllllIllIlIlIllIllIIlII, get(llllllllllllllIllIlIlIllIllIIIll, llllllllllllllIllIlIlIllIllIIllI));
            set(llllllllllllllIllIlIlIllIllIIIll, llllllllllllllIllIlIlIllIllIIllI, llllllllllllllIllIlIlIllIllIIlIl);
        }
        return llllllllllllllIllIlIlIllIllIIIll;
    }
    
    public static void ensureFromTo(final float[][] llllllllllllllIllIlIIIIIlIIlIIIl, final long llllllllllllllIllIlIIIIIlIIIllIl, final long llllllllllllllIllIlIIIIIlIIIllll) {
        ensureFromTo(length(llllllllllllllIllIlIIIIIlIIlIIIl), llllllllllllllIllIlIIIIIlIIIllIl, llllllllllllllIllIlIIIIIlIIIllll);
    }
    
    public static short[][] grow(final short[][] llllllllllllllIllIlIIlIIIIllIIll, final long llllllllllllllIllIlIIlIIIIllIIlI) {
        final long llllllllllllllIllIlIIlIIIIllIlII = length(llllllllllllllIllIlIIlIIIIllIIll);
        return (llllllllllllllIllIlIIlIIIIllIIlI > llllllllllllllIllIlIIlIIIIllIlII) ? grow(llllllllllllllIllIlIIlIIIIllIIll, llllllllllllllIllIlIIlIIIIllIIlI, llllllllllllllIllIlIIlIIIIllIlII) : llllllllllllllIllIlIIlIIIIllIIll;
    }
    
    public static boolean[][] wrap(final boolean[] llllllllllllllIllIlIIlIlllllIlIl) {
        if (llllllllllllllIllIlIIlIlllllIlIl.length == 0) {
            return BooleanBigArrays.EMPTY_BIG_ARRAY;
        }
        if (llllllllllllllIllIlIIlIlllllIlIl.length <= 134217728) {
            return new boolean[][] { llllllllllllllIllIlIIlIlllllIlIl };
        }
        final boolean[][] llllllllllllllIllIlIIlIlllllIlII = BooleanBigArrays.newBigArray((long)llllllllllllllIllIlIIlIlllllIlIl.length);
        for (int llllllllllllllIllIlIIlIlllllIllI = 0; llllllllllllllIllIlIIlIlllllIllI < llllllllllllllIllIlIIlIlllllIlII.length; ++llllllllllllllIllIlIIlIlllllIllI) {
            System.arraycopy(llllllllllllllIllIlIIlIlllllIlIl, (int)start(llllllllllllllIllIlIIlIlllllIllI), llllllllllllllIllIlIIlIlllllIlII[llllllllllllllIllIlIIlIlllllIllI], 0, llllllllllllllIllIlIIlIlllllIlII[llllllllllllllIllIlIIlIlllllIllI].length);
        }
        return llllllllllllllIllIlIIlIlllllIlII;
    }
    
    public static double[][] setLength(final double[][] llllllllllllllIllIlIIlllIIIIllll, final long llllllllllllllIllIlIIlllIIIIlIll) {
        final long llllllllllllllIllIlIIlllIIIIllIl = length(llllllllllllllIllIlIIlllIIIIllll);
        if (llllllllllllllIllIlIIlllIIIIlIll == llllllllllllllIllIlIIlllIIIIllIl) {
            return llllllllllllllIllIlIIlllIIIIllll;
        }
        if (llllllllllllllIllIlIIlllIIIIlIll < llllllllllllllIllIlIIlllIIIIllIl) {
            return trim(llllllllllllllIllIlIIlllIIIIllll, llllllllllllllIllIlIIlllIIIIlIll);
        }
        return ensureCapacity(llllllllllllllIllIlIIlllIIIIllll, llllllllllllllIllIlIIlllIIIIlIll);
    }
    
    public static char get(final char[][] llllllllllllllIllIlIIIllIlllIlII, final long llllllllllllllIllIlIIIllIlllIIIl) {
        return llllllllllllllIllIlIIIllIlllIlII[segment(llllllllllllllIllIlIIIllIlllIIIl)][displacement(llllllllllllllIllIlIIIllIlllIIIl)];
    }
    
    public static void incr(final long[][] llllllllllllllIllIlIlIIlIlIllIlI, final long llllllllllllllIllIlIlIIlIlIllIll) {
        final long[] array = llllllllllllllIllIlIlIIlIlIllIlI[segment(llllllllllllllIllIlIlIIlIlIllIll)];
        final int displacement = displacement(llllllllllllllIllIlIlIIlIlIllIll);
        ++array[displacement];
    }
    
    public static void fill(final boolean[][] llllllllllllllIllIlIIlIlIlllllll, final boolean llllllllllllllIllIlIIlIlIlllllII) {
        int llllllllllllllIllIlIIlIllIIIIIII = llllllllllllllIllIlIIlIlIlllllll.length;
        while (llllllllllllllIllIlIIlIllIIIIIII-- != 0) {
            Arrays.fill(llllllllllllllIllIlIIlIlIlllllll[llllllllllllllIllIlIIlIllIIIIIII], llllllllllllllIllIlIIlIlIlllllII);
        }
    }
    
    public static void decr(final double[][] llllllllllllllIllIlIIlllllIIIlIl, final long llllllllllllllIllIlIIlllllIIIlII) {
        final double[] array = llllllllllllllIllIlIIlllllIIIlIl[segment(llllllllllllllIllIlIIlllllIIIlII)];
        final int displacement = displacement(llllllllllllllIllIlIIlllllIIIlII);
        --array[displacement];
    }
    
    public static int[][] copy(final int[][] llllllllllllllIllIlIlIlIIIIlllll, final long llllllllllllllIllIlIlIlIIIlIIIlI, final long llllllllllllllIllIlIlIlIIIIlllIl) {
        ensureOffsetLength(llllllllllllllIllIlIlIlIIIIlllll, llllllllllllllIllIlIlIlIIIlIIIlI, llllllllllllllIllIlIlIlIIIIlllIl);
        final int[][] llllllllllllllIllIlIlIlIIIlIIIII = IntBigArrays.newBigArray(llllllllllllllIllIlIlIlIIIIlllIl);
        copy(llllllllllllllIllIlIlIlIIIIlllll, llllllllllllllIllIlIlIlIIIlIIIlI, llllllllllllllIllIlIlIlIIIlIIIII, 0L, llllllllllllllIllIlIlIlIIIIlllIl);
        return llllllllllllllIllIlIlIlIIIlIIIII;
    }
    
    public static void mul(final byte[][] llllllllllllllIllIlIllIIlIlllIll, final long llllllllllllllIllIlIllIIlIllIlll, final byte llllllllllllllIllIlIllIIlIlllIIl) {
        final byte[] array = llllllllllllllIllIlIllIIlIlllIll[segment(llllllllllllllIllIlIllIIlIllIlll)];
        final int displacement = displacement(llllllllllllllIllIlIllIIlIllIlll);
        array[displacement] *= llllllllllllllIllIlIllIIlIlllIIl;
    }
    
    public static void set(final int[][] llllllllllllllIllIlIlIllIlIlIIll, final long llllllllllllllIllIlIlIllIlIlIIlI, final int llllllllllllllIllIlIlIllIlIlIIIl) {
        llllllllllllllIllIlIlIllIlIlIIll[segment(llllllllllllllIllIlIlIllIlIlIIlI)][displacement(llllllllllllllIllIlIlIllIlIlIIlI)] = llllllllllllllIllIlIlIllIlIlIIIl;
    }
    
    public static void fill(final char[][] llllllllllllllIllIlIIIlIIlIIlIlI, final long llllllllllllllIllIlIIIlIIlIlIIlI, final long llllllllllllllIllIlIIIlIIlIlIIIl, final char llllllllllllllIllIlIIIlIIlIIIlll) {
        final long llllllllllllllIllIlIIIlIIlIIllll = length(llllllllllllllIllIlIIIlIIlIIlIlI);
        ensureFromTo(llllllllllllllIllIlIIIlIIlIIllll, llllllllllllllIllIlIIIlIIlIlIIlI, llllllllllllllIllIlIIIlIIlIlIIIl);
        if (llllllllllllllIllIlIIIlIIlIIllll == 0L) {
            return;
        }
        final int llllllllllllllIllIlIIIlIIlIIlllI = segment(llllllllllllllIllIlIIIlIIlIlIIlI);
        int llllllllllllllIllIlIIIlIIlIIllIl = segment(llllllllllllllIllIlIIIlIIlIlIIIl);
        final int llllllllllllllIllIlIIIlIIlIIllII = displacement(llllllllllllllIllIlIIIlIIlIlIIlI);
        final int llllllllllllllIllIlIIIlIIlIIlIll = displacement(llllllllllllllIllIlIIIlIIlIlIIIl);
        if (llllllllllllllIllIlIIIlIIlIIlllI == llllllllllllllIllIlIIIlIIlIIllIl) {
            Arrays.fill(llllllllllllllIllIlIIIlIIlIIlIlI[llllllllllllllIllIlIIIlIIlIIlllI], llllllllllllllIllIlIIIlIIlIIllII, llllllllllllllIllIlIIIlIIlIIlIll, llllllllllllllIllIlIIIlIIlIIIlll);
            return;
        }
        if (llllllllllllllIllIlIIIlIIlIIlIll != 0) {
            Arrays.fill(llllllllllllllIllIlIIIlIIlIIlIlI[llllllllllllllIllIlIIIlIIlIIllIl], 0, llllllllllllllIllIlIIIlIIlIIlIll, llllllllllllllIllIlIIIlIIlIIIlll);
        }
        while (--llllllllllllllIllIlIIIlIIlIIllIl > llllllllllllllIllIlIIIlIIlIIlllI) {
            Arrays.fill(llllllllllllllIllIlIIIlIIlIIlIlI[llllllllllllllIllIlIIIlIIlIIllIl], llllllllllllllIllIlIIIlIIlIIIlll);
        }
        Arrays.fill(llllllllllllllIllIlIIIlIIlIIlIlI[llllllllllllllIllIlIIIlIIlIIlllI], llllllllllllllIllIlIIIlIIlIIllII, 134217728, llllllllllllllIllIlIIIlIIlIIIlll);
    }
    
    public static void ensureOffsetLength(final byte[][] llllllllllllllIllIlIlIlllIIIlIIl, final long llllllllllllllIllIlIlIlllIIIlIll, final long llllllllllllllIllIlIlIlllIIIlIlI) {
        ensureOffsetLength(length(llllllllllllllIllIlIlIlllIIIlIIl), llllllllllllllIllIlIlIlllIIIlIll, llllllllllllllIllIlIlIlllIIIlIlI);
    }
    
    public static char[][] shuffle(final char[][] llllllllllllllIllIlIIIIlllllllIl, final long llllllllllllllIllIlIIIlIIIIIIIII, final long llllllllllllllIllIlIIIIllllllIll, final Random llllllllllllllIllIlIIIIllllllllI) {
        long llllllllllllllIllIlIIIlIIIIIIIlI = llllllllllllllIllIlIIIIllllllIll - llllllllllllllIllIlIIIlIIIIIIIII;
        while (llllllllllllllIllIlIIIlIIIIIIIlI-- != 0L) {
            final long llllllllllllllIllIlIIIlIIIIIIlII = (llllllllllllllIllIlIIIIllllllllI.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIIlIIIIIIIlI + 1L);
            final char llllllllllllllIllIlIIIlIIIIIIIll = get(llllllllllllllIllIlIIIIlllllllIl, llllllllllllllIllIlIIIlIIIIIIIII + llllllllllllllIllIlIIIlIIIIIIIlI);
            set(llllllllllllllIllIlIIIIlllllllIl, llllllllllllllIllIlIIIlIIIIIIIII + llllllllllllllIllIlIIIlIIIIIIIlI, get(llllllllllllllIllIlIIIIlllllllIl, llllllllllllllIllIlIIIlIIIIIIIII + llllllllllllllIllIlIIIlIIIIIIlII));
            set(llllllllllllllIllIlIIIIlllllllIl, llllllllllllllIllIlIIIlIIIIIIIII + llllllllllllllIllIlIIIlIIIIIIlII, llllllllllllllIllIlIIIlIIIIIIIll);
        }
        return llllllllllllllIllIlIIIIlllllllIl;
    }
    
    public static long start(final int llllllllllllllIllIlIllIlllIIllII) {
        return (long)llllllllllllllIllIlIllIlllIIllII << 27;
    }
    
    public static String toString(final byte[][] llllllllllllllIllIlIlIlllIIlllII) {
        if (llllllllllllllIllIlIlIlllIIlllII == null) {
            return "null";
        }
        final long llllllllllllllIllIlIlIlllIIllllI = length(llllllllllllllIllIlIlIlllIIlllII) - 1L;
        if (llllllllllllllIllIlIlIlllIIllllI == -1L) {
            return "[]";
        }
        final StringBuilder llllllllllllllIllIlIlIlllIIlllIl = new StringBuilder();
        llllllllllllllIllIlIlIlllIIlllIl.append('[');
        long llllllllllllllIllIlIlIlllIlIIIII = 0L;
        while (true) {
            llllllllllllllIllIlIlIlllIIlllIl.append(String.valueOf(get(llllllllllllllIllIlIlIlllIIlllII, llllllllllllllIllIlIlIlllIlIIIII)));
            if (llllllllllllllIllIlIlIlllIlIIIII == llllllllllllllIllIlIlIlllIIllllI) {
                break;
            }
            llllllllllllllIllIlIlIlllIIlllIl.append(", ");
            ++llllllllllllllIllIlIlIlllIlIIIII;
        }
        return String.valueOf(llllllllllllllIllIlIlIlllIIlllIl.append(']'));
    }
    
    public static double[][] ensureCapacity(final double[][] llllllllllllllIllIlIIlllIIllllll, final long llllllllllllllIllIlIIlllIIlllllI, final long llllllllllllllIllIlIIlllIIllllIl) {
        return (llllllllllllllIllIlIIlllIIlllllI > length(llllllllllllllIllIlIIlllIIllllll)) ? forceCapacity(llllllllllllllIllIlIIlllIIllllll, llllllllllllllIllIlIIlllIIlllllI, llllllllllllllIllIlIIlllIIllllIl) : llllllllllllllIllIlIIlllIIllllll;
    }
    
    public static void fill(final float[][] llllllllllllllIllIlIIIIIllIlIIII, final float llllllllllllllIllIlIIIIIllIlIIIl) {
        int llllllllllllllIllIlIIIIIllIlIIll = llllllllllllllIllIlIIIIIllIlIIII.length;
        while (llllllllllllllIllIlIIIIIllIlIIll-- != 0) {
            Arrays.fill(llllllllllllllIllIlIIIIIllIlIIII[llllllllllllllIllIlIIIIIllIlIIll], llllllllllllllIllIlIIIIIllIlIIIl);
        }
    }
    
    public static void ensureFromTo(final double[][] llllllllllllllIllIlIIllIlIlIllII, final long llllllllllllllIllIlIIllIlIlIlIll, final long llllllllllllllIllIlIIllIlIlIlIlI) {
        ensureFromTo(length(llllllllllllllIllIlIIllIlIlIllII), llllllllllllllIllIlIIllIlIlIlIll, llllllllllllllIllIlIIllIlIlIlIlI);
    }
    
    public static void ensureFromTo(final int[][] llllllllllllllIllIlIlIIlllIIllIl, final long llllllllllllllIllIlIlIIlllIIllII, final long llllllllllllllIllIlIlIIlllIIlIII) {
        ensureFromTo(length(llllllllllllllIllIlIlIIlllIIllIl), llllllllllllllIllIlIlIIlllIIllII, llllllllllllllIllIlIlIIlllIIlIII);
    }
    
    public static short[][] copy(final short[][] llllllllllllllIllIlIIIlllllllIIl) {
        final short[][] llllllllllllllIllIlIIIlllllllIII = llllllllllllllIllIlIIIlllllllIIl.clone();
        int llllllllllllllIllIlIIIlllllllIlI = llllllllllllllIllIlIIIlllllllIII.length;
        while (llllllllllllllIllIlIIIlllllllIlI-- != 0) {
            llllllllllllllIllIlIIIlllllllIII[llllllllllllllIllIlIIIlllllllIlI] = llllllllllllllIllIlIIIlllllllIIl[llllllllllllllIllIlIIIlllllllIlI].clone();
        }
        return llllllllllllllIllIlIIIlllllllIII;
    }
    
    public static void swap(final float[][] llllllllllllllIllIlIIIIlllIlIIII, final long llllllllllllllIllIlIIIIlllIlIIll, final long llllllllllllllIllIlIIIIlllIlIIlI) {
        final float llllllllllllllIllIlIIIIlllIlIIIl = llllllllllllllIllIlIIIIlllIlIIII[segment(llllllllllllllIllIlIIIIlllIlIIll)][displacement(llllllllllllllIllIlIIIIlllIlIIll)];
        llllllllllllllIllIlIIIIlllIlIIII[segment(llllllllllllllIllIlIIIIlllIlIIll)][displacement(llllllllllllllIllIlIIIIlllIlIIll)] = llllllllllllllIllIlIIIIlllIlIIII[segment(llllllllllllllIllIlIIIIlllIlIIlI)][displacement(llllllllllllllIllIlIIIIlllIlIIlI)];
        llllllllllllllIllIlIIIIlllIlIIII[segment(llllllllllllllIllIlIIIIlllIlIIlI)][displacement(llllllllllllllIllIlIIIIlllIlIIlI)] = llllllllllllllIllIlIIIIlllIlIIIl;
    }
    
    public static void ensureOffsetLength(final char[][] llllllllllllllIllIlIIIlIIIIlIlII, final long llllllllllllllIllIlIIIlIIIIlIIll, final long llllllllllllllIllIlIIIlIIIIlIIlI) {
        ensureOffsetLength(length(llllllllllllllIllIlIIIlIIIIlIlII), llllllllllllllIllIlIIIlIIIIlIIll, llllllllllllllIllIlIIIlIIIIlIIlI);
    }
    
    public static void swap(final char[][] llllllllllllllIllIlIIIllIllIIIll, final long llllllllllllllIllIlIIIllIllIIIlI, final long llllllllllllllIllIlIIIllIllIIIIl) {
        final char llllllllllllllIllIlIIIllIllIIIII = llllllllllllllIllIlIIIllIllIIIll[segment(llllllllllllllIllIlIIIllIllIIIlI)][displacement(llllllllllllllIllIlIIIllIllIIIlI)];
        llllllllllllllIllIlIIIllIllIIIll[segment(llllllllllllllIllIlIIIllIllIIIlI)][displacement(llllllllllllllIllIlIIIllIllIIIlI)] = llllllllllllllIllIlIIIllIllIIIll[segment(llllllllllllllIllIlIIIllIllIIIIl)][displacement(llllllllllllllIllIlIIIllIllIIIIl)];
        llllllllllllllIllIlIIIllIllIIIll[segment(llllllllllllllIllIlIIIllIllIIIIl)][displacement(llllllllllllllIllIlIIIllIllIIIIl)] = llllllllllllllIllIlIIIllIllIIIII;
    }
    
    public static float[][] copy(final float[][] llllllllllllllIllIlIIIIIlllIIlll, final long llllllllllllllIllIlIIIIIlllIIllI, final long llllllllllllllIllIlIIIIIlllIIlIl) {
        ensureOffsetLength(llllllllllllllIllIlIIIIIlllIIlll, llllllllllllllIllIlIIIIIlllIIllI, llllllllllllllIllIlIIIIIlllIIlIl);
        final float[][] llllllllllllllIllIlIIIIIlllIIlII = FloatBigArrays.newBigArray(llllllllllllllIllIlIIIIIlllIIlIl);
        copy(llllllllllllllIllIlIIIIIlllIIlll, llllllllllllllIllIlIIIIIlllIIllI, llllllllllllllIllIlIIIIIlllIIlII, 0L, llllllllllllllIllIlIIIIIlllIIlIl);
        return llllllllllllllIllIlIIIIIlllIIlII;
    }
    
    public static float[][] shuffle(final float[][] llllllllllllllIllIlIIIIIIllIlllI, final long llllllllllllllIllIlIIIIIIlllIIIl, final long llllllllllllllIllIlIIIIIIlllIIII, final Random llllllllllllllIllIlIIIIIIllIllll) {
        long llllllllllllllIllIlIIIIIIlllIIll = llllllllllllllIllIlIIIIIIlllIIII - llllllllllllllIllIlIIIIIIlllIIIl;
        while (llllllllllllllIllIlIIIIIIlllIIll-- != 0L) {
            final long llllllllllllllIllIlIIIIIIlllIlIl = (llllllllllllllIllIlIIIIIIllIllll.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIIIIIIlllIIll + 1L);
            final float llllllllllllllIllIlIIIIIIlllIlII = get(llllllllllllllIllIlIIIIIIllIlllI, llllllllllllllIllIlIIIIIIlllIIIl + llllllllllllllIllIlIIIIIIlllIIll);
            set(llllllllllllllIllIlIIIIIIllIlllI, llllllllllllllIllIlIIIIIIlllIIIl + llllllllllllllIllIlIIIIIIlllIIll, get(llllllllllllllIllIlIIIIIIllIlllI, llllllllllllllIllIlIIIIIIlllIIIl + llllllllllllllIllIlIIIIIIlllIlIl));
            set(llllllllllllllIllIlIIIIIIllIlllI, llllllllllllllIllIlIIIIIIlllIIIl + llllllllllllllIllIlIIIIIIlllIlIl, llllllllllllllIllIlIIIIIIlllIlII);
        }
        return llllllllllllllIllIlIIIIIIllIlllI;
    }
    
    public static void ensureOffsetLength(final long[][] llllllllllllllIllIlIlIIIIIllIIlI, final long llllllllllllllIllIlIlIIIIIllIlII, final long llllllllllllllIllIlIlIIIIIllIIII) {
        ensureOffsetLength(length(llllllllllllllIllIlIlIIIIIllIIlI), llllllllllllllIllIlIlIIIIIllIlII, llllllllllllllIllIlIlIIIIIllIIII);
    }
    
    public static void ensureOffsetLength(final float[][] llllllllllllllIllIlIIIIIlIIIlIII, final long llllllllllllllIllIlIIIIIlIIIIlII, final long llllllllllllllIllIlIIIIIlIIIIllI) {
        ensureOffsetLength(length(llllllllllllllIllIlIIIIIlIIIlIII), llllllllllllllIllIlIIIIIlIIIIlII, llllllllllllllIllIlIIIIIlIIIIllI);
    }
    
    public static boolean equals(final short[][] llllllllllllllIllIlIIIllllIIIlll, final short[][] llllllllllllllIllIlIIIllllIIIllI) {
        if (length(llllllllllllllIllIlIIIllllIIIlll) != length(llllllllllllllIllIlIIIllllIIIllI)) {
            return false;
        }
        int llllllllllllllIllIlIIIllllIIIlIl = llllllllllllllIllIlIIIllllIIIlll.length;
        while (llllllllllllllIllIlIIIllllIIIlIl-- != 0) {
            final short[] llllllllllllllIllIlIIIllllIIlIIl = llllllllllllllIllIlIIIllllIIIlll[llllllllllllllIllIlIIIllllIIIlIl];
            final short[] llllllllllllllIllIlIIIllllIIlIII = llllllllllllllIllIlIIIllllIIIllI[llllllllllllllIllIlIIIllllIIIlIl];
            int llllllllllllllIllIlIIIllllIIlIlI = llllllllllllllIllIlIIIllllIIlIIl.length;
            while (llllllllllllllIllIlIIIllllIIlIlI-- != 0) {
                if (llllllllllllllIllIlIIIllllIIlIIl[llllllllllllllIllIlIIIllllIIlIlI] != llllllllllllllIllIlIIIllllIIlIII[llllllllllllllIllIlIIIllllIIlIlI]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static <K> K[][] forceCapacity(final K[][] llllllllllllllIllIIllllllIlllIII, final long llllllllllllllIllIIllllllIllllll, final long llllllllllllllIllIIllllllIllIllI) {
        ensureLength(llllllllllllllIllIIllllllIllllll);
        final int llllllllllllllIllIIllllllIllllIl = llllllllllllllIllIIllllllIlllIII.length - ((llllllllllllllIllIIllllllIlllIII.length != 0 && (llllllllllllllIllIIllllllIlllIII.length <= 0 || llllllllllllllIllIIllllllIlllIII[llllllllllllllIllIIllllllIlllIII.length - 1].length != 134217728)) ? 1 : 0);
        final int llllllllllllllIllIIllllllIllllII = (int)(llllllllllllllIllIIllllllIllllll + 134217727L >>> 27);
        final K[][] llllllllllllllIllIIllllllIlllIll = Arrays.copyOf(llllllllllllllIllIIllllllIlllIII, llllllllllllllIllIIllllllIllllII);
        final Class<?> llllllllllllllIllIIllllllIlllIlI = llllllllllllllIllIIllllllIlllIII.getClass().getComponentType();
        final int llllllllllllllIllIIllllllIlllIIl = (int)(llllllllllllllIllIIllllllIllllll & 0x7FFFFFFL);
        if (llllllllllllllIllIIllllllIlllIIl != 0) {
            for (int llllllllllllllIllIIlllllllIIIIlI = llllllllllllllIllIIllllllIllllIl; llllllllllllllIllIIlllllllIIIIlI < llllllllllllllIllIIllllllIllllII - 1; ++llllllllllllllIllIIlllllllIIIIlI) {
                llllllllllllllIllIIllllllIlllIll[llllllllllllllIllIIlllllllIIIIlI] = (K[])Array.newInstance(llllllllllllllIllIIllllllIlllIlI.getComponentType(), 134217728);
            }
            llllllllllllllIllIIllllllIlllIll[llllllllllllllIllIIllllllIllllII - 1] = (K[])Array.newInstance(llllllllllllllIllIIllllllIlllIlI.getComponentType(), llllllllllllllIllIIllllllIlllIIl);
        }
        else {
            for (int llllllllllllllIllIIlllllllIIIIIl = llllllllllllllIllIIllllllIllllIl; llllllllllllllIllIIlllllllIIIIIl < llllllllllllllIllIIllllllIllllII; ++llllllllllllllIllIIlllllllIIIIIl) {
                llllllllllllllIllIIllllllIlllIll[llllllllllllllIllIIlllllllIIIIIl] = (K[])Array.newInstance(llllllllllllllIllIIllllllIlllIlI.getComponentType(), 134217728);
            }
        }
        if (llllllllllllllIllIIllllllIllIllI - llllllllllllllIllIIllllllIllllIl * 134217728L > 0L) {
            copy(llllllllllllllIllIIllllllIlllIII, llllllllllllllIllIIllllllIllllIl * 134217728L, llllllllllllllIllIIllllllIlllIll, llllllllllllllIllIIllllllIllllIl * 134217728L, llllllllllllllIllIIllllllIllIllI - llllllllllllllIllIIllllllIllllIl * 134217728L);
        }
        return llllllllllllllIllIIllllllIlllIll;
    }
    
    public static void add(final short[][] llllllllllllllIllIlIIlIIllIllIll, final long llllllllllllllIllIlIIlIIllIllIlI, final short llllllllllllllIllIlIIlIIllIllIIl) {
        final short[] array = llllllllllllllIllIlIIlIIllIllIll[segment(llllllllllllllIllIlIIlIIllIllIlI)];
        final int displacement = displacement(llllllllllllllIllIlIIlIIllIllIlI);
        array[displacement] += llllllllllllllIllIlIIlIIllIllIIl;
    }
    
    public static boolean[][] ensureCapacity(final boolean[][] llllllllllllllIllIlIIlIlllIIlllI, final long llllllllllllllIllIlIIlIlllIIlIlI, final long llllllllllllllIllIlIIlIlllIIlIIl) {
        return (llllllllllllllIllIlIIlIlllIIlIlI > length(llllllllllllllIllIlIIlIlllIIlllI)) ? forceCapacity(llllllllllllllIllIlIIlIlllIIlllI, llllllllllllllIllIlIIlIlllIIlIlI, llllllllllllllIllIlIIlIlllIIlIIl) : llllllllllllllIllIlIIlIlllIIlllI;
    }
    
    public static void set(final long[][] llllllllllllllIllIlIlIIllIIIlIII, final long llllllllllllllIllIlIlIIllIIIlIlI, final long llllllllllllllIllIlIlIIllIIIlIIl) {
        llllllllllllllIllIlIlIIllIIIlIII[segment(llllllllllllllIllIlIlIIllIIIlIlI)][displacement(llllllllllllllIllIlIlIIllIIIlIlI)] = llllllllllllllIllIlIlIIllIIIlIIl;
    }
    
    public static int get(final int[][] llllllllllllllIllIlIlIllIlIllIII, final long llllllllllllllIllIlIlIllIlIlIlll) {
        return llllllllllllllIllIlIlIllIlIllIII[segment(llllllllllllllIllIlIlIllIlIlIlll)][displacement(llllllllllllllIllIlIlIllIlIlIlll)];
    }
    
    public static void mul(final float[][] llllllllllllllIllIlIIIIllIllIlII, final long llllllllllllllIllIlIIIIllIllIIll, final float llllllllllllllIllIlIIIIllIllIIlI) {
        final float[] array = llllllllllllllIllIlIIIIllIllIlII[segment(llllllllllllllIllIlIIIIllIllIIll)];
        final int displacement = displacement(llllllllllllllIllIlIIIIllIllIIll);
        array[displacement] *= llllllllllllllIllIlIIIIllIllIIlI;
    }
    
    public static char[][] ensureCapacity(final char[][] llllllllllllllIllIlIIIlIllIlIIII, final long llllllllllllllIllIlIIIlIllIIllll) {
        return ensureCapacity(llllllllllllllIllIlIIIlIllIlIIII, llllllllllllllIllIlIIIlIllIIllll, length(llllllllllllllIllIlIIIlIllIlIIII));
    }
    
    public static void incr(final short[][] llllllllllllllIllIlIIlIIllIIlIll, final long llllllllllllllIllIlIIlIIllIIlIlI) {
        final short[] array = llllllllllllllIllIlIIlIIllIIlIll[segment(llllllllllllllIllIlIIlIIllIIlIlI)];
        final int displacement = displacement(llllllllllllllIllIlIIlIIllIIlIlI);
        ++array[displacement];
    }
    
    public static short[][] setLength(final short[][] llllllllllllllIllIlIIlIIIIIIllll, final long llllllllllllllIllIlIIlIIIIIIlIll) {
        final long llllllllllllllIllIlIIlIIIIIIllIl = length(llllllllllllllIllIlIIlIIIIIIllll);
        if (llllllllllllllIllIlIIlIIIIIIlIll == llllllllllllllIllIlIIlIIIIIIllIl) {
            return llllllllllllllIllIlIIlIIIIIIllll;
        }
        if (llllllllllllllIllIlIIlIIIIIIlIll < llllllllllllllIllIlIIlIIIIIIllIl) {
            return trim(llllllllllllllIllIlIIlIIIIIIllll, llllllllllllllIllIlIIlIIIIIIlIll);
        }
        return ensureCapacity(llllllllllllllIllIlIIlIIIIIIllll, llllllllllllllIllIlIIlIIIIIIlIll);
    }
    
    public static void mul(final long[][] llllllllllllllIllIlIlIIlIllIIlII, final long llllllllllllllIllIlIlIIlIllIIIII, final long llllllllllllllIllIlIlIIlIlIlllll) {
        final long[] array = llllllllllllllIllIlIlIIlIllIIlII[segment(llllllllllllllIllIlIlIIlIllIIIII)];
        final int displacement = displacement(llllllllllllllIllIlIlIIlIllIIIII);
        array[displacement] *= llllllllllllllIllIlIlIIlIlIlllll;
    }
    
    public static void add(final double[][] llllllllllllllIllIlIIlllllIllllI, final long llllllllllllllIllIlIIlllllIllIlI, final double llllllllllllllIllIlIIlllllIlllII) {
        final double[] array = llllllllllllllIllIlIIlllllIllllI[segment(llllllllllllllIllIlIIlllllIllIlI)];
        final int displacement = displacement(llllllllllllllIllIlIIlllllIllIlI);
        array[displacement] += llllllllllllllIllIlIIlllllIlllII;
    }
    
    public static float[][] reverse(final float[][] llllllllllllllIllIlIIIIlllIIlIII) {
        final long llllllllllllllIllIlIIIIlllIIIlll = length(llllllllllllllIllIlIIIIlllIIlIII);
        long llllllllllllllIllIlIIIIlllIIlIIl = llllllllllllllIllIlIIIIlllIIIlll / 2L;
        while (llllllllllllllIllIlIIIIlllIIlIIl-- != 0L) {
            swap(llllllllllllllIllIlIIIIlllIIlIII, llllllllllllllIllIlIIIIlllIIlIIl, llllllllllllllIllIlIIIIlllIIIlll - llllllllllllllIllIlIIIIlllIIlIIl - 1L);
        }
        return llllllllllllllIllIlIIIIlllIIlIII;
    }
    
    public static byte[][] shuffle(final byte[][] llllllllllllllIllIlIlIllIlllIIlI, final long llllllllllllllIllIlIlIllIlllIlIl, final long llllllllllllllIllIlIlIllIlllIlII, final Random llllllllllllllIllIlIlIllIllIllll) {
        long llllllllllllllIllIlIlIllIlllIlll = llllllllllllllIllIlIlIllIlllIlII - llllllllllllllIllIlIlIllIlllIlIl;
        while (llllllllllllllIllIlIlIllIlllIlll-- != 0L) {
            final long llllllllllllllIllIlIlIllIllllIIl = (llllllllllllllIllIlIlIllIllIllll.nextLong() & Long.MAX_VALUE) % (llllllllllllllIllIlIlIllIlllIlll + 1L);
            final byte llllllllllllllIllIlIlIllIllllIII = get(llllllllllllllIllIlIlIllIlllIIlI, llllllllllllllIllIlIlIllIlllIlIl + llllllllllllllIllIlIlIllIlllIlll);
            set(llllllllllllllIllIlIlIllIlllIIlI, llllllllllllllIllIlIlIllIlllIlIl + llllllllllllllIllIlIlIllIlllIlll, get(llllllllllllllIllIlIlIllIlllIIlI, llllllllllllllIllIlIlIllIlllIlIl + llllllllllllllIllIlIlIllIllllIIl));
            set(llllllllllllllIllIlIlIllIlllIIlI, llllllllllllllIllIlIlIllIlllIlIl + llllllllllllllIllIlIlIllIllllIIl, llllllllllllllIllIlIlIllIllllIII);
        }
        return llllllllllllllIllIlIlIllIlllIIlI;
    }
    
    public static float[][] forceCapacity(final float[][] llllllllllllllIllIlIIIIlIIllIIll, final long llllllllllllllIllIlIIIIlIIlIlIll, final long llllllllllllllIllIlIIIIlIIllIIIl) {
        ensureLength(llllllllllllllIllIlIIIIlIIlIlIll);
        final int llllllllllllllIllIlIIIIlIIllIIII = llllllllllllllIllIlIIIIlIIllIIll.length - ((llllllllllllllIllIlIIIIlIIllIIll.length != 0 && (llllllllllllllIllIlIIIIlIIllIIll.length <= 0 || llllllllllllllIllIlIIIIlIIllIIll[llllllllllllllIllIlIIIIlIIllIIll.length - 1].length != 134217728)) ? 1 : 0);
        final int llllllllllllllIllIlIIIIlIIlIllll = (int)(llllllllllllllIllIlIIIIlIIlIlIll + 134217727L >>> 27);
        final float[][] llllllllllllllIllIlIIIIlIIlIlllI = Arrays.copyOf(llllllllllllllIllIlIIIIlIIllIIll, llllllllllllllIllIlIIIIlIIlIllll);
        final int llllllllllllllIllIlIIIIlIIlIllIl = (int)(llllllllllllllIllIlIIIIlIIlIlIll & 0x7FFFFFFL);
        if (llllllllllllllIllIlIIIIlIIlIllIl != 0) {
            for (int llllllllllllllIllIlIIIIlIIllIlIl = llllllllllllllIllIlIIIIlIIllIIII; llllllllllllllIllIlIIIIlIIllIlIl < llllllllllllllIllIlIIIIlIIlIllll - 1; ++llllllllllllllIllIlIIIIlIIllIlIl) {
                llllllllllllllIllIlIIIIlIIlIlllI[llllllllllllllIllIlIIIIlIIllIlIl] = new float[134217728];
            }
            llllllllllllllIllIlIIIIlIIlIlllI[llllllllllllllIllIlIIIIlIIlIllll - 1] = new float[llllllllllllllIllIlIIIIlIIlIllIl];
        }
        else {
            for (int llllllllllllllIllIlIIIIlIIllIlII = llllllllllllllIllIlIIIIlIIllIIII; llllllllllllllIllIlIIIIlIIllIlII < llllllllllllllIllIlIIIIlIIlIllll; ++llllllllllllllIllIlIIIIlIIllIlII) {
                llllllllllllllIllIlIIIIlIIlIlllI[llllllllllllllIllIlIIIIlIIllIlII] = new float[134217728];
            }
        }
        if (llllllllllllllIllIlIIIIlIIllIIIl - llllllllllllllIllIlIIIIlIIllIIII * 134217728L > 0L) {
            copy(llllllllllllllIllIlIIIIlIIllIIll, llllllllllllllIllIlIIIIlIIllIIII * 134217728L, llllllllllllllIllIlIIIIlIIlIlllI, llllllllllllllIllIlIIIIlIIllIIII * 134217728L, llllllllllllllIllIlIIIIlIIllIIIl - llllllllllllllIllIlIIIIlIIllIIII * 134217728L);
        }
        return llllllllllllllIllIlIIIIlIIlIlllI;
    }
    
    public static boolean equals(final int[][] llllllllllllllIllIlIlIIllllIIlIl, final int[][] llllllllllllllIllIlIlIIllllIIlII) {
        if (length(llllllllllllllIllIlIlIIllllIIlIl) != length(llllllllllllllIllIlIlIIllllIIlII)) {
            return false;
        }
        int llllllllllllllIllIlIlIIllllIIIll = llllllllllllllIllIlIlIIllllIIlIl.length;
        while (llllllllllllllIllIlIlIIllllIIIll-- != 0) {
            final int[] llllllllllllllIllIlIlIIllllIIlll = llllllllllllllIllIlIlIIllllIIlIl[llllllllllllllIllIlIlIIllllIIIll];
            final int[] llllllllllllllIllIlIlIIllllIIllI = llllllllllllllIllIlIlIIllllIIlII[llllllllllllllIllIlIlIIllllIIIll];
            int llllllllllllllIllIlIlIIllllIlIII = llllllllllllllIllIlIlIIllllIIlll.length;
            while (llllllllllllllIllIlIlIIllllIlIII-- != 0) {
                if (llllllllllllllIllIlIlIIllllIIlll[llllllllllllllIllIlIlIIllllIlIII] != llllllllllllllIllIlIlIIllllIIllI[llllllllllllllIllIlIlIIllllIlIII]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static long length(final byte[][] llllllllllllllIllIlIllIIlIlIIlIl) {
        final int llllllllllllllIllIlIllIIlIlIIllI = llllllllllllllIllIlIllIIlIlIIlIl.length;
        return (llllllllllllllIllIlIllIIlIlIIllI == 0) ? 0L : (start(llllllllllllllIllIlIllIIlIlIIllI - 1) + llllllllllllllIllIlIllIIlIlIIlIl[llllllllllllllIllIlIllIIlIlIIllI - 1].length);
    }
    
    public static void copy(final short[][] llllllllllllllIllIlIIlIIlIlIlIIl, final long llllllllllllllIllIlIIlIIlIlIlIII, final short[][] llllllllllllllIllIlIIlIIlIlIIIlI, final long llllllllllllllIllIlIIlIIlIlIIIIl, long llllllllllllllIllIlIIlIIlIlIIIII) {
        if (llllllllllllllIllIlIIlIIlIlIIIIl <= llllllllllllllIllIlIIlIIlIlIlIII) {
            int llllllllllllllIllIlIIlIIlIllIIll = segment(llllllllllllllIllIlIIlIIlIlIlIII);
            int llllllllllllllIllIlIIlIIlIllIIlI = segment(llllllllllllllIllIlIIlIIlIlIIIIl);
            int llllllllllllllIllIlIIlIIlIllIIIl = displacement(llllllllllllllIllIlIIlIIlIlIlIII);
            int llllllllllllllIllIlIIlIIlIllIIII = displacement(llllllllllllllIllIlIIlIIlIlIIIIl);
            while (llllllllllllllIllIlIIlIIlIlIIIII > 0L) {
                final int llllllllllllllIllIlIIlIIlIlIllll = (int)Math.min(llllllllllllllIllIlIIlIIlIlIIIII, Math.min(llllllllllllllIllIlIIlIIlIlIlIIl[llllllllllllllIllIlIIlIIlIllIIll].length - llllllllllllllIllIlIIlIIlIllIIIl, llllllllllllllIllIlIIlIIlIlIIIlI[llllllllllllllIllIlIIlIIlIllIIlI].length - llllllllllllllIllIlIIlIIlIllIIII));
                if (llllllllllllllIllIlIIlIIlIlIllll == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIlIIlIlIlIIl[llllllllllllllIllIlIIlIIlIllIIll], llllllllllllllIllIlIIlIIlIllIIIl, llllllllllllllIllIlIIlIIlIlIIIlI[llllllllllllllIllIlIIlIIlIllIIlI], llllllllllllllIllIlIIlIIlIllIIII, llllllllllllllIllIlIIlIIlIlIllll);
                if ((llllllllllllllIllIlIIlIIlIllIIIl += llllllllllllllIllIlIIlIIlIlIllll) == 134217728) {
                    llllllllllllllIllIlIIlIIlIllIIIl = 0;
                    ++llllllllllllllIllIlIIlIIlIllIIll;
                }
                if ((llllllllllllllIllIlIIlIIlIllIIII += llllllllllllllIllIlIIlIIlIlIllll) == 134217728) {
                    llllllllllllllIllIlIIlIIlIllIIII = 0;
                    ++llllllllllllllIllIlIIlIIlIllIIlI;
                }
                llllllllllllllIllIlIIlIIlIlIIIII -= llllllllllllllIllIlIIlIIlIlIllll;
            }
        }
        else {
            int llllllllllllllIllIlIIlIIlIlIlllI = segment(llllllllllllllIllIlIIlIIlIlIlIII + llllllllllllllIllIlIIlIIlIlIIIII);
            int llllllllllllllIllIlIIlIIlIlIllIl = segment(llllllllllllllIllIlIIlIIlIlIIIIl + llllllllllllllIllIlIIlIIlIlIIIII);
            int llllllllllllllIllIlIIlIIlIlIllII = displacement(llllllllllllllIllIlIIlIIlIlIlIII + llllllllllllllIllIlIIlIIlIlIIIII);
            int llllllllllllllIllIlIIlIIlIlIlIll = displacement(llllllllllllllIllIlIIlIIlIlIIIIl + llllllllllllllIllIlIIlIIlIlIIIII);
            while (llllllllllllllIllIlIIlIIlIlIIIII > 0L) {
                if (llllllllllllllIllIlIIlIIlIlIllII == 0) {
                    llllllllllllllIllIlIIlIIlIlIllII = 134217728;
                    --llllllllllllllIllIlIIlIIlIlIlllI;
                }
                if (llllllllllllllIllIlIIlIIlIlIlIll == 0) {
                    llllllllllllllIllIlIIlIIlIlIlIll = 134217728;
                    --llllllllllllllIllIlIIlIIlIlIllIl;
                }
                final int llllllllllllllIllIlIIlIIlIlIlIlI = (int)Math.min(llllllllllllllIllIlIIlIIlIlIIIII, Math.min(llllllllllllllIllIlIIlIIlIlIllII, llllllllllllllIllIlIIlIIlIlIlIll));
                if (llllllllllllllIllIlIIlIIlIlIlIlI == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                System.arraycopy(llllllllllllllIllIlIIlIIlIlIlIIl[llllllllllllllIllIlIIlIIlIlIlllI], llllllllllllllIllIlIIlIIlIlIllII - llllllllllllllIllIlIIlIIlIlIlIlI, llllllllllllllIllIlIIlIIlIlIIIlI[llllllllllllllIllIlIIlIIlIlIllIl], llllllllllllllIllIlIIlIIlIlIlIll - llllllllllllllIllIlIIlIIlIlIlIlI, llllllllllllllIllIlIIlIIlIlIlIlI);
                llllllllllllllIllIlIIlIIlIlIllII -= llllllllllllllIllIlIIlIIlIlIlIlI;
                llllllllllllllIllIlIIlIIlIlIlIll -= llllllllllllllIllIlIIlIIlIlIlIlI;
                llllllllllllllIllIlIIlIIlIlIIIII -= llllllllllllllIllIlIIlIIlIlIlIlI;
            }
        }
    }
    
    public static float get(final float[][] llllllllllllllIllIlIIIIllllIIlIl, final long llllllllllllllIllIlIIIIllllIIIlI) {
        return llllllllllllllIllIlIIIIllllIIlIl[segment(llllllllllllllIllIlIIIIllllIIIlI)][displacement(llllllllllllllIllIlIIIIllllIIIlI)];
    }
    
    public static void copyToBig(final short[] llllllllllllllIllIlIIlIIIllllIIl, int llllllllllllllIllIlIIlIIIlllIIIl, final short[][] llllllllllllllIllIlIIlIIIlllIIII, final long llllllllllllllIllIlIIlIIIllIllll, long llllllllllllllIllIlIIlIIIllIlllI) {
        int llllllllllllllIllIlIIlIIIlllIlII = segment(llllllllllllllIllIlIIlIIIllIllll);
        int llllllllllllllIllIlIIlIIIlllIIll = displacement(llllllllllllllIllIlIIlIIIllIllll);
        while (llllllllllllllIllIlIIlIIIllIlllI > 0L) {
            final int llllllllllllllIllIlIIlIIIllllIlI = (int)Math.min(llllllllllllllIllIlIIlIIIlllIIII[llllllllllllllIllIlIIlIIIlllIlII].length - llllllllllllllIllIlIIlIIIlllIIll, llllllllllllllIllIlIIlIIIllIlllI);
            if (llllllllllllllIllIlIIlIIIllllIlI == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(llllllllllllllIllIlIIlIIIllllIIl, llllllllllllllIllIlIIlIIIlllIIIl, llllllllllllllIllIlIIlIIIlllIIII[llllllllllllllIllIlIIlIIIlllIlII], llllllllllllllIllIlIIlIIIlllIIll, llllllllllllllIllIlIIlIIIllllIlI);
            if ((llllllllllllllIllIlIIlIIIlllIIll += llllllllllllllIllIlIIlIIIllllIlI) == 134217728) {
                llllllllllllllIllIlIIlIIIlllIIll = 0;
                ++llllllllllllllIllIlIIlIIIlllIlII;
            }
            llllllllllllllIllIlIIlIIIlllIIIl += llllllllllllllIllIlIIlIIIllllIlI;
            llllllllllllllIllIlIIlIIIllIlllI -= llllllllllllllIllIlIIlIIIllllIlI;
        }
    }
    
    public static void decr(final long[][] llllllllllllllIllIlIlIIlIlIlIlII, final long llllllllllllllIllIlIlIIlIlIlIlIl) {
        final long[] array = llllllllllllllIllIlIlIIlIlIlIlII[segment(llllllllllllllIllIlIlIIlIlIlIlIl)];
        final int displacement = displacement(llllllllllllllIllIlIlIIlIlIlIlIl);
        --array[displacement];
    }
    
    public static void ensureSameLength(final boolean[][] llllllllllllllIllIlIIlIlIIlIllIl, final boolean[][] llllllllllllllIllIlIIlIlIIlIlIlI) {
        if (length(llllllllllllllIllIlIIlIlIIlIllIl) != length(llllllllllllllIllIlIIlIlIIlIlIlI)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(length(llllllllllllllIllIlIIlIlIIlIllIl)).append(" != ").append(length(llllllllllllllIllIlIIlIlIIlIlIlI))));
        }
    }
    
    public static double[][] reverse(final double[][] llllllllllllllIllIlIIllllllIIllI) {
        final long llllllllllllllIllIlIIllllllIIlIl = length(llllllllllllllIllIlIIllllllIIllI);
        long llllllllllllllIllIlIIllllllIIlll = llllllllllllllIllIlIIllllllIIlIl / 2L;
        while (llllllllllllllIllIlIIllllllIIlll-- != 0L) {
            swap(llllllllllllllIllIlIIllllllIIllI, llllllllllllllIllIlIIllllllIIlll, llllllllllllllIllIlIIllllllIIlIl - llllllllllllllIllIlIIllllllIIlll - 1L);
        }
        return llllllllllllllIllIlIIllllllIIllI;
    }
}
