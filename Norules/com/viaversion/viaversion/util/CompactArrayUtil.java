package com.viaversion.viaversion.util;

import java.util.function.*;

public class CompactArrayUtil
{
    private static final /* synthetic */ int[] MAGIC;
    
    public static long[] createCompactArrayWithPadding(final int lllllllllllllllllIIIllIllIlllIll, final int lllllllllllllllllIIIllIllIlllIlI, final IntToLongFunction lllllllllllllllllIIIllIllIlllIIl) {
        final long lllllllllllllllllIIIllIlllIIIIll = (1L << lllllllllllllllllIIIllIllIlllIll) - 1L;
        final char lllllllllllllllllIIIllIlllIIIIlI = (char)(64 / lllllllllllllllllIIIllIllIlllIll);
        final int lllllllllllllllllIIIllIlllIIIIIl = 3 * (lllllllllllllllllIIIllIlllIIIIlI - '\u0001');
        final long lllllllllllllllllIIIllIlllIIIIII = Integer.toUnsignedLong(CompactArrayUtil.MAGIC[lllllllllllllllllIIIllIlllIIIIIl]);
        final long lllllllllllllllllIIIllIllIllllll = Integer.toUnsignedLong(CompactArrayUtil.MAGIC[lllllllllllllllllIIIllIlllIIIIIl + 1]);
        final int lllllllllllllllllIIIllIllIlllllI = CompactArrayUtil.MAGIC[lllllllllllllllllIIIllIlllIIIIIl + 2];
        final int lllllllllllllllllIIIllIllIllllIl = (lllllllllllllllllIIIllIllIlllIlI + lllllllllllllllllIIIllIlllIIIIlI - 1) / lllllllllllllllllIIIllIlllIIIIlI;
        final long[] lllllllllllllllllIIIllIllIllllII = new long[lllllllllllllllllIIIllIllIllllIl];
        for (int lllllllllllllllllIIIllIlllIIIlll = 0; lllllllllllllllllIIIllIlllIIIlll < lllllllllllllllllIIIllIllIlllIlI; ++lllllllllllllllllIIIllIlllIIIlll) {
            final long lllllllllllllllllIIIllIlllIIlIlI = lllllllllllllllllIIIllIllIlllIIl.applyAsLong(lllllllllllllllllIIIllIlllIIIlll);
            final int lllllllllllllllllIIIllIlllIIlIIl = (int)(lllllllllllllllllIIIllIlllIIIlll * lllllllllllllllllIIIllIlllIIIIII + lllllllllllllllllIIIllIllIllllll >> 32 >> lllllllllllllllllIIIllIllIlllllI);
            final int lllllllllllllllllIIIllIlllIIlIII = (lllllllllllllllllIIIllIlllIIIlll - lllllllllllllllllIIIllIlllIIlIIl * lllllllllllllllllIIIllIlllIIIIlI) * lllllllllllllllllIIIllIllIlllIll;
            lllllllllllllllllIIIllIllIllllII[lllllllllllllllllIIIllIlllIIlIIl] = ((lllllllllllllllllIIIllIllIllllII[lllllllllllllllllIIIllIlllIIlIIl] & ~(lllllllllllllllllIIIllIlllIIIIll << lllllllllllllllllIIIllIlllIIlIII)) | (lllllllllllllllllIIIllIlllIIlIlI & lllllllllllllllllIIIllIlllIIIIll) << lllllllllllllllllIIIllIlllIIlIII);
        }
        return lllllllllllllllllIIIllIllIllllII;
    }
    
    static {
        MAGIC = new int[] { -1, -1, 0, Integer.MIN_VALUE, 0, 0, 1431655765, 1431655765, 0, Integer.MIN_VALUE, 0, 1, 858993459, 858993459, 0, 715827882, 715827882, 0, 613566756, 613566756, 0, Integer.MIN_VALUE, 0, 2, 477218588, 477218588, 0, 429496729, 429496729, 0, 390451572, 390451572, 0, 357913941, 357913941, 0, 330382099, 330382099, 0, 306783378, 306783378, 0, 286331153, 286331153, 0, Integer.MIN_VALUE, 0, 3, 252645135, 252645135, 0, 238609294, 238609294, 0, 226050910, 226050910, 0, 214748364, 214748364, 0, 204522252, 204522252, 0, 195225786, 195225786, 0, 186737708, 186737708, 0, 178956970, 178956970, 0, 171798691, 171798691, 0, 165191049, 165191049, 0, 159072862, 159072862, 0, 153391689, 153391689, 0, 148102320, 148102320, 0, 143165576, 143165576, 0, 138547332, 138547332, 0, Integer.MIN_VALUE, 0, 4, 130150524, 130150524, 0, 126322567, 126322567, 0, 122713351, 122713351, 0, 119304647, 119304647, 0, 116080197, 116080197, 0, 113025455, 113025455, 0, 110127366, 110127366, 0, 107374182, 107374182, 0, 104755299, 104755299, 0, 102261126, 102261126, 0, 99882960, 99882960, 0, 97612893, 97612893, 0, 95443717, 95443717, 0, 93368854, 93368854, 0, 91382282, 91382282, 0, 89478485, 89478485, 0, 87652393, 87652393, 0, 85899345, 85899345, 0, 84215045, 84215045, 0, 82595524, 82595524, 0, 81037118, 81037118, 0, 79536431, 79536431, 0, 78090314, 78090314, 0, 76695844, 76695844, 0, 75350303, 75350303, 0, 74051160, 74051160, 0, 72796055, 72796055, 0, 71582788, 71582788, 0, 70409299, 70409299, 0, 69273666, 69273666, 0, 68174084, 68174084, 0, Integer.MIN_VALUE, 0, 5 };
    }
    
    public static void iterateCompactArray(final int lllllllllllllllllIIIllIlIlIIIlIl, final int lllllllllllllllllIIIllIlIlIIIlII, final long[] lllllllllllllllllIIIllIlIlIIIIll, final BiIntConsumer lllllllllllllllllIIIllIlIlIIIIlI) {
        final long lllllllllllllllllIIIllIlIlIIIllI = (1L << lllllllllllllllllIIIllIlIlIIIlIl) - 1L;
        for (int lllllllllllllllllIIIllIlIlIIlIll = 0; lllllllllllllllllIIIllIlIlIIlIll < lllllllllllllllllIIIllIlIlIIIlII; ++lllllllllllllllllIIIllIlIlIIlIll) {
            final int lllllllllllllllllIIIllIlIlIlIIII = lllllllllllllllllIIIllIlIlIIlIll * lllllllllllllllllIIIllIlIlIIIlIl;
            final int lllllllllllllllllIIIllIlIlIIllll = lllllllllllllllllIIIllIlIlIlIIII / 64;
            final int lllllllllllllllllIIIllIlIlIIlllI = ((lllllllllllllllllIIIllIlIlIIlIll + 1) * lllllllllllllllllIIIllIlIlIIIlIl - 1) / 64;
            final int lllllllllllllllllIIIllIlIlIIllIl = lllllllllllllllllIIIllIlIlIlIIII % 64;
            int lllllllllllllllllIIIllIlIlIIllII = 0;
            if (lllllllllllllllllIIIllIlIlIIllll == lllllllllllllllllIIIllIlIlIIlllI) {
                final int lllllllllllllllllIIIllIlIlIlIIlI = (int)(lllllllllllllllllIIIllIlIlIIIIll[lllllllllllllllllIIIllIlIlIIllll] >>> lllllllllllllllllIIIllIlIlIIllIl & lllllllllllllllllIIIllIlIlIIIllI);
            }
            else {
                final int lllllllllllllllllIIIllIlIlIlIIIl = 64 - lllllllllllllllllIIIllIlIlIIllIl;
                lllllllllllllllllIIIllIlIlIIllII = (int)((lllllllllllllllllIIIllIlIlIIIIll[lllllllllllllllllIIIllIlIlIIllll] >>> lllllllllllllllllIIIllIlIlIIllIl | lllllllllllllllllIIIllIlIlIIIIll[lllllllllllllllllIIIllIlIlIIlllI] << lllllllllllllllllIIIllIlIlIlIIIl) & lllllllllllllllllIIIllIlIlIIIllI);
            }
            lllllllllllllllllIIIllIlIlIIIIlI.consume(lllllllllllllllllIIIllIlIlIIlIll, lllllllllllllllllIIIllIlIlIIllII);
        }
    }
    
    public static long[] createCompactArray(final int lllllllllllllllllIIIllIlIllIllll, final int lllllllllllllllllIIIllIlIllIlllI, final IntToLongFunction lllllllllllllllllIIIllIlIllIlIII) {
        final long lllllllllllllllllIIIllIlIllIllII = (1L << lllllllllllllllllIIIllIlIllIllll) - 1L;
        final long[] lllllllllllllllllIIIllIlIllIlIll = new long[(int)Math.ceil(lllllllllllllllllIIIllIlIllIlllI * lllllllllllllllllIIIllIlIllIllll / 64.0)];
        for (int lllllllllllllllllIIIllIlIlllIIII = 0; lllllllllllllllllIIIllIlIlllIIII < lllllllllllllllllIIIllIlIllIlllI; ++lllllllllllllllllIIIllIlIlllIIII) {
            final long lllllllllllllllllIIIllIlIlllIlIl = lllllllllllllllllIIIllIlIllIlIII.applyAsLong(lllllllllllllllllIIIllIlIlllIIII);
            final int lllllllllllllllllIIIllIlIlllIlII = lllllllllllllllllIIIllIlIlllIIII * lllllllllllllllllIIIllIlIllIllll;
            final int lllllllllllllllllIIIllIlIlllIIll = lllllllllllllllllIIIllIlIlllIlII / 64;
            final int lllllllllllllllllIIIllIlIlllIIlI = ((lllllllllllllllllIIIllIlIlllIIII + 1) * lllllllllllllllllIIIllIlIllIllll - 1) / 64;
            final int lllllllllllllllllIIIllIlIlllIIIl = lllllllllllllllllIIIllIlIlllIlII % 64;
            lllllllllllllllllIIIllIlIllIlIll[lllllllllllllllllIIIllIlIlllIIll] = ((lllllllllllllllllIIIllIlIllIlIll[lllllllllllllllllIIIllIlIlllIIll] & ~(lllllllllllllllllIIIllIlIllIllII << lllllllllllllllllIIIllIlIlllIIIl)) | (lllllllllllllllllIIIllIlIlllIlIl & lllllllllllllllllIIIllIlIllIllII) << lllllllllllllllllIIIllIlIlllIIIl);
            if (lllllllllllllllllIIIllIlIlllIIll != lllllllllllllllllIIIllIlIlllIIlI) {
                final int lllllllllllllllllIIIllIlIlllIllI = 64 - lllllllllllllllllIIIllIlIlllIIIl;
                lllllllllllllllllIIIllIlIllIlIll[lllllllllllllllllIIIllIlIlllIIlI] = (lllllllllllllllllIIIllIlIllIlIll[lllllllllllllllllIIIllIlIlllIIlI] >>> lllllllllllllllllIIIllIlIlllIllI << lllllllllllllllllIIIllIlIlllIllI | (lllllllllllllllllIIIllIlIlllIlIl & lllllllllllllllllIIIllIlIllIllII) >> lllllllllllllllllIIIllIlIlllIllI);
            }
        }
        return lllllllllllllllllIIIllIlIllIlIll;
    }
    
    public static void iterateCompactArrayWithPadding(final int lllllllllllllllllIIIllIllIIllIlI, final int lllllllllllllllllIIIllIllIIIllll, final long[] lllllllllllllllllIIIllIllIIIlllI, final BiIntConsumer lllllllllllllllllIIIllIllIIIllIl) {
        final long lllllllllllllllllIIIllIllIIlIllI = (1L << lllllllllllllllllIIIllIllIIllIlI) - 1L;
        final char lllllllllllllllllIIIllIllIIlIlIl = (char)(64 / lllllllllllllllllIIIllIllIIllIlI);
        final int lllllllllllllllllIIIllIllIIlIlII = 3 * (lllllllllllllllllIIIllIllIIlIlIl - '\u0001');
        final long lllllllllllllllllIIIllIllIIlIIll = Integer.toUnsignedLong(CompactArrayUtil.MAGIC[lllllllllllllllllIIIllIllIIlIlII]);
        final long lllllllllllllllllIIIllIllIIlIIlI = Integer.toUnsignedLong(CompactArrayUtil.MAGIC[lllllllllllllllllIIIllIllIIlIlII + 1]);
        final int lllllllllllllllllIIIllIllIIlIIIl = CompactArrayUtil.MAGIC[lllllllllllllllllIIIllIllIIlIlII + 2];
        for (int lllllllllllllllllIIIllIllIIllIll = 0; lllllllllllllllllIIIllIllIIllIll < lllllllllllllllllIIIllIllIIIllll; ++lllllllllllllllllIIIllIllIIllIll) {
            final int lllllllllllllllllIIIllIllIIllllI = (int)(lllllllllllllllllIIIllIllIIllIll * lllllllllllllllllIIIllIllIIlIIll + lllllllllllllllllIIIllIllIIlIIlI >> 32 >> lllllllllllllllllIIIllIllIIlIIIl);
            final int lllllllllllllllllIIIllIllIIlllIl = (lllllllllllllllllIIIllIllIIllIll - lllllllllllllllllIIIllIllIIllllI * lllllllllllllllllIIIllIllIIlIlIl) * lllllllllllllllllIIIllIllIIllIlI;
            final int lllllllllllllllllIIIllIllIIlllII = (int)(lllllllllllllllllIIIllIllIIIlllI[lllllllllllllllllIIIllIllIIllllI] >> lllllllllllllllllIIIllIllIIlllIl & lllllllllllllllllIIIllIllIIlIllI);
            lllllllllllllllllIIIllIllIIIllIl.consume(lllllllllllllllllIIIllIllIIllIll, lllllllllllllllllIIIllIllIIlllII);
        }
    }
    
    private CompactArrayUtil() {
        throw new AssertionError();
    }
}
