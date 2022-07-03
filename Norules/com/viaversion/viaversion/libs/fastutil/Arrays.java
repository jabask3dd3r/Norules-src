package com.viaversion.viaversion.libs.fastutil;

import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.concurrent.*;

public class Arrays
{
    public static void ensureOffsetLength(final int lllllllllllllIIIIllIIlIlIlIlIIll, final int lllllllllllllIIIIllIIlIlIlIlIIlI, final int lllllllllllllIIIIllIIlIlIlIlIIIl) {
        if (lllllllllllllIIIIllIIlIlIlIlIIlI < 0) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Offset (").append(lllllllllllllIIIIllIIlIlIlIlIIlI).append(") is negative")));
        }
        if (lllllllllllllIIIIllIIlIlIlIlIIIl < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Length (").append(lllllllllllllIIIIllIIlIlIlIlIIIl).append(") is negative")));
        }
        if (lllllllllllllIIIIllIIlIlIlIlIIlI + lllllllllllllIIIIllIIlIlIlIlIIIl > lllllllllllllIIIIllIIlIlIlIlIIll) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Last index (").append(lllllllllllllIIIIllIIlIlIlIlIIlI + lllllllllllllIIIIllIIlIlIlIlIIIl).append(") is greater than array length (").append(lllllllllllllIIIIllIIlIlIlIlIIll).append(")")));
        }
    }
    
    public static void parallelQuickSort(final int lllllllllllllIIIIllIIlIIllIIIIIl, final int lllllllllllllIIIIllIIlIIlIlllIll, final IntComparator lllllllllllllIIIIllIIlIIlIlllIlI, final Swapper lllllllllllllIIIIllIIlIIlIlllllI) {
        final ForkJoinPool lllllllllllllIIIIllIIlIIlIllllIl = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        lllllllllllllIIIIllIIlIIlIllllIl.invoke((ForkJoinTask<Object>)new ForkJoinGenericQuickSort(lllllllllllllIIIIllIIlIIllIIIIIl, lllllllllllllIIIIllIIlIIlIlllIll, lllllllllllllIIIIllIIlIIlIlllIlI, lllllllllllllIIIIllIIlIIlIlllllI));
        lllllllllllllIIIIllIIlIIlIllllIl.shutdown();
    }
    
    public static void ensureFromTo(final int lllllllllllllIIIIllIIlIlIlIlllll, final int lllllllllllllIIIIllIIlIlIlIllllI, final int lllllllllllllIIIIllIIlIlIlIllIlI) {
        if (lllllllllllllIIIIllIIlIlIlIllllI < 0) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Start index (").append(lllllllllllllIIIIllIIlIlIlIllllI).append(") is negative")));
        }
        if (lllllllllllllIIIIllIIlIlIlIllllI > lllllllllllllIIIIllIIlIlIlIllIlI) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Start index (").append(lllllllllllllIIIIllIIlIlIlIllllI).append(") is greater than end index (").append(lllllllllllllIIIIllIIlIlIlIllIlI).append(")")));
        }
        if (lllllllllllllIIIIllIIlIlIlIllIlI > lllllllllllllIIIIllIIlIlIlIlllll) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(lllllllllllllIIIIllIIlIlIlIllIlI).append(") is greater than array length (").append(lllllllllllllIIIIllIIlIlIlIlllll).append(")")));
        }
    }
    
    public static void quickSort(final int lllllllllllllIIIIllIIlIIlIlIIlIl, final int lllllllllllllIIIIllIIlIIlIlIIlII, final IntComparator lllllllllllllIIIIllIIlIIlIIlIllI, final Swapper lllllllllllllIIIIllIIlIIlIIlIlIl) {
        final int lllllllllllllIIIIllIIlIIlIlIIIIl = lllllllllllllIIIIllIIlIIlIlIIlII - lllllllllllllIIIIllIIlIIlIlIIlIl;
        if (lllllllllllllIIIIllIIlIIlIlIIIIl < 16) {
            for (int lllllllllllllIIIIllIIlIIlIlIlIIl = lllllllllllllIIIIllIIlIIlIlIIlIl; lllllllllllllIIIIllIIlIIlIlIlIIl < lllllllllllllIIIIllIIlIIlIlIIlII; ++lllllllllllllIIIIllIIlIIlIlIlIIl) {
                for (int lllllllllllllIIIIllIIlIIlIlIlIlI = lllllllllllllIIIIllIIlIIlIlIlIIl; lllllllllllllIIIIllIIlIIlIlIlIlI > lllllllllllllIIIIllIIlIIlIlIIlIl && lllllllllllllIIIIllIIlIIlIIlIllI.compare(lllllllllllllIIIIllIIlIIlIlIlIlI - 1, lllllllllllllIIIIllIIlIIlIlIlIlI) > 0; --lllllllllllllIIIIllIIlIIlIlIlIlI) {
                    lllllllllllllIIIIllIIlIIlIIlIlIl.swap(lllllllllllllIIIIllIIlIIlIlIlIlI, lllllllllllllIIIIllIIlIIlIlIlIlI - 1);
                }
            }
            return;
        }
        int lllllllllllllIIIIllIIlIIlIlIIIII = lllllllllllllIIIIllIIlIIlIlIIlIl + lllllllllllllIIIIllIIlIIlIlIIIIl / 2;
        int lllllllllllllIIIIllIIlIIlIIlllll = lllllllllllllIIIIllIIlIIlIlIIlIl;
        int lllllllllllllIIIIllIIlIIlIIllllI = lllllllllllllIIIIllIIlIIlIlIIlII - 1;
        if (lllllllllllllIIIIllIIlIIlIlIIIIl > 128) {
            final int lllllllllllllIIIIllIIlIIlIlIlIII = lllllllllllllIIIIllIIlIIlIlIIIIl / 8;
            lllllllllllllIIIIllIIlIIlIIlllll = med3(lllllllllllllIIIIllIIlIIlIIlllll, lllllllllllllIIIIllIIlIIlIIlllll + lllllllllllllIIIIllIIlIIlIlIlIII, lllllllllllllIIIIllIIlIIlIIlllll + 2 * lllllllllllllIIIIllIIlIIlIlIlIII, lllllllllllllIIIIllIIlIIlIIlIllI);
            lllllllllllllIIIIllIIlIIlIlIIIII = med3(lllllllllllllIIIIllIIlIIlIlIIIII - lllllllllllllIIIIllIIlIIlIlIlIII, lllllllllllllIIIIllIIlIIlIlIIIII, lllllllllllllIIIIllIIlIIlIlIIIII + lllllllllllllIIIIllIIlIIlIlIlIII, lllllllllllllIIIIllIIlIIlIIlIllI);
            lllllllllllllIIIIllIIlIIlIIllllI = med3(lllllllllllllIIIIllIIlIIlIIllllI - 2 * lllllllllllllIIIIllIIlIIlIlIlIII, lllllllllllllIIIIllIIlIIlIIllllI - lllllllllllllIIIIllIIlIIlIlIlIII, lllllllllllllIIIIllIIlIIlIIllllI, lllllllllllllIIIIllIIlIIlIIlIllI);
        }
        lllllllllllllIIIIllIIlIIlIlIIIII = med3(lllllllllllllIIIIllIIlIIlIIlllll, lllllllllllllIIIIllIIlIIlIlIIIII, lllllllllllllIIIIllIIlIIlIIllllI, lllllllllllllIIIIllIIlIIlIIlIllI);
        int lllllllllllllIIIIllIIlIIlIIlllII;
        int lllllllllllllIIIIllIIlIIlIIlllIl = lllllllllllllIIIIllIIlIIlIIlllII = lllllllllllllIIIIllIIlIIlIlIIlIl;
        int lllllllllllllIIIIllIIlIIlIIllIlI;
        int lllllllllllllIIIIllIIlIIlIIllIll = lllllllllllllIIIIllIIlIIlIIllIlI = lllllllllllllIIIIllIIlIIlIlIIlII - 1;
        while (true) {
            final int lllllllllllllIIIIllIIlIIlIlIIlll;
            if (lllllllllllllIIIIllIIlIIlIIlllII <= lllllllllllllIIIIllIIlIIlIIllIll && (lllllllllllllIIIIllIIlIIlIlIIlll = lllllllllllllIIIIllIIlIIlIIlIllI.compare(lllllllllllllIIIIllIIlIIlIIlllII, lllllllllllllIIIIllIIlIIlIlIIIII)) <= 0) {
                if (lllllllllllllIIIIllIIlIIlIlIIlll == 0) {
                    if (lllllllllllllIIIIllIIlIIlIIlllIl == lllllllllllllIIIIllIIlIIlIlIIIII) {
                        lllllllllllllIIIIllIIlIIlIlIIIII = lllllllllllllIIIIllIIlIIlIIlllII;
                    }
                    else if (lllllllllllllIIIIllIIlIIlIIlllII == lllllllllllllIIIIllIIlIIlIlIIIII) {
                        lllllllllllllIIIIllIIlIIlIlIIIII = lllllllllllllIIIIllIIlIIlIIlllIl;
                    }
                    lllllllllllllIIIIllIIlIIlIIlIlIl.swap(lllllllllllllIIIIllIIlIIlIIlllIl++, lllllllllllllIIIIllIIlIIlIIlllII);
                }
                ++lllllllllllllIIIIllIIlIIlIIlllII;
            }
            else {
                int lllllllllllllIIIIllIIlIIlIlIIllI;
                while (lllllllllllllIIIIllIIlIIlIIllIll >= lllllllllllllIIIIllIIlIIlIIlllII && (lllllllllllllIIIIllIIlIIlIlIIllI = lllllllllllllIIIIllIIlIIlIIlIllI.compare(lllllllllllllIIIIllIIlIIlIIllIll, lllllllllllllIIIIllIIlIIlIlIIIII)) >= 0) {
                    if (lllllllllllllIIIIllIIlIIlIlIIllI == 0) {
                        if (lllllllllllllIIIIllIIlIIlIIllIll == lllllllllllllIIIIllIIlIIlIlIIIII) {
                            lllllllllllllIIIIllIIlIIlIlIIIII = lllllllllllllIIIIllIIlIIlIIllIlI;
                        }
                        else if (lllllllllllllIIIIllIIlIIlIIllIlI == lllllllllllllIIIIllIIlIIlIlIIIII) {
                            lllllllllllllIIIIllIIlIIlIlIIIII = lllllllllllllIIIIllIIlIIlIIllIll;
                        }
                        lllllllllllllIIIIllIIlIIlIIlIlIl.swap(lllllllllllllIIIIllIIlIIlIIllIll, lllllllllllllIIIIllIIlIIlIIllIlI--);
                    }
                    --lllllllllllllIIIIllIIlIIlIIllIll;
                }
                if (lllllllllllllIIIIllIIlIIlIIlllII > lllllllllllllIIIIllIIlIIlIIllIll) {
                    break;
                }
                if (lllllllllllllIIIIllIIlIIlIIlllII == lllllllllllllIIIIllIIlIIlIlIIIII) {
                    lllllllllllllIIIIllIIlIIlIlIIIII = lllllllllllllIIIIllIIlIIlIIllIlI;
                }
                else if (lllllllllllllIIIIllIIlIIlIIllIll == lllllllllllllIIIIllIIlIIlIlIIIII) {
                    lllllllllllllIIIIllIIlIIlIlIIIII = lllllllllllllIIIIllIIlIIlIIllIll;
                }
                lllllllllllllIIIIllIIlIIlIIlIlIl.swap(lllllllllllllIIIIllIIlIIlIIlllII++, lllllllllllllIIIIllIIlIIlIIllIll--);
            }
        }
        int lllllllllllllIIIIllIIlIIlIIllIIl = Math.min(lllllllllllllIIIIllIIlIIlIIlllIl - lllllllllllllIIIIllIIlIIlIlIIlIl, lllllllllllllIIIIllIIlIIlIIlllII - lllllllllllllIIIIllIIlIIlIIlllIl);
        swap(lllllllllllllIIIIllIIlIIlIIlIlIl, lllllllllllllIIIIllIIlIIlIlIIlIl, lllllllllllllIIIIllIIlIIlIIlllII - lllllllllllllIIIIllIIlIIlIIllIIl, lllllllllllllIIIIllIIlIIlIIllIIl);
        lllllllllllllIIIIllIIlIIlIIllIIl = Math.min(lllllllllllllIIIIllIIlIIlIIllIlI - lllllllllllllIIIIllIIlIIlIIllIll, lllllllllllllIIIIllIIlIIlIlIIlII - lllllllllllllIIIIllIIlIIlIIllIlI - 1);
        swap(lllllllllllllIIIIllIIlIIlIIlIlIl, lllllllllllllIIIIllIIlIIlIIlllII, lllllllllllllIIIIllIIlIIlIlIIlII - lllllllllllllIIIIllIIlIIlIIllIIl, lllllllllllllIIIIllIIlIIlIIllIIl);
        if ((lllllllllllllIIIIllIIlIIlIIllIIl = lllllllllllllIIIIllIIlIIlIIlllII - lllllllllllllIIIIllIIlIIlIIlllIl) > 1) {
            quickSort(lllllllllllllIIIIllIIlIIlIlIIlIl, lllllllllllllIIIIllIIlIIlIlIIlIl + lllllllllllllIIIIllIIlIIlIIllIIl, lllllllllllllIIIIllIIlIIlIIlIllI, lllllllllllllIIIIllIIlIIlIIlIlIl);
        }
        if ((lllllllllllllIIIIllIIlIIlIIllIIl = lllllllllllllIIIIllIIlIIlIIllIlI - lllllllllllllIIIIllIIlIIlIIllIll) > 1) {
            quickSort(lllllllllllllIIIIllIIlIIlIlIIlII - lllllllllllllIIIIllIIlIIlIIllIIl, lllllllllllllIIIIllIIlIIlIlIIlII, lllllllllllllIIIIllIIlIIlIIlIllI, lllllllllllllIIIIllIIlIIlIIlIlIl);
        }
    }
    
    private static int lowerBound(int lllllllllllllIIIIllIIlIlIIIlllII, final int lllllllllllllIIIIllIIlIlIIlIIIII, final int lllllllllllllIIIIllIIlIlIIIlllll, final IntComparator lllllllllllllIIIIllIIlIlIIIllllI) {
        int lllllllllllllIIIIllIIlIlIIIlllIl = lllllllllllllIIIIllIIlIlIIlIIIII - lllllllllllllIIIIllIIlIlIIIlllII;
        while (lllllllllllllIIIIllIIlIlIIIlllIl > 0) {
            final int lllllllllllllIIIIllIIlIlIIlIIIll = lllllllllllllIIIIllIIlIlIIIlllIl / 2;
            final int lllllllllllllIIIIllIIlIlIIlIIIlI = lllllllllllllIIIIllIIlIlIIIlllII + lllllllllllllIIIIllIIlIlIIlIIIll;
            if (lllllllllllllIIIIllIIlIlIIIllllI.compare(lllllllllllllIIIIllIIlIlIIlIIIlI, lllllllllllllIIIIllIIlIlIIIlllll) < 0) {
                lllllllllllllIIIIllIIlIlIIIlllII = lllllllllllllIIIIllIIlIlIIlIIIlI + 1;
                lllllllllllllIIIIllIIlIlIIIlllIl -= lllllllllllllIIIIllIIlIlIIlIIIll + 1;
            }
            else {
                lllllllllllllIIIIllIIlIlIIIlllIl = lllllllllllllIIIIllIIlIlIIlIIIll;
            }
        }
        return lllllllllllllIIIIllIIlIlIIIlllII;
    }
    
    private static void inPlaceMerge(final int lllllllllllllIIIIllIIlIlIlIIIIII, int lllllllllllllIIIIllIIlIlIIllllll, final int lllllllllllllIIIIllIIlIlIIllIlII, final IntComparator lllllllllllllIIIIllIIlIlIIllllIl, final Swapper lllllllllllllIIIIllIIlIlIIllIIlI) {
        if (lllllllllllllIIIIllIIlIlIlIIIIII >= lllllllllllllIIIIllIIlIlIIllllll || lllllllllllllIIIIllIIlIlIIllllll >= lllllllllllllIIIIllIIlIlIIllIlII) {
            return;
        }
        if (lllllllllllllIIIIllIIlIlIIllIlII - lllllllllllllIIIIllIIlIlIlIIIIII == 2) {
            if (lllllllllllllIIIIllIIlIlIIllllIl.compare(lllllllllllllIIIIllIIlIlIIllllll, lllllllllllllIIIIllIIlIlIlIIIIII) < 0) {
                lllllllllllllIIIIllIIlIlIIllIIlI.swap(lllllllllllllIIIIllIIlIlIlIIIIII, lllllllllllllIIIIllIIlIlIIllllll);
            }
            return;
        }
        int lllllllllllllIIIIllIIlIlIIlllIlI = 0;
        int lllllllllllllIIIIllIIlIlIIlllIll = 0;
        if (lllllllllllllIIIIllIIlIlIIllllll - lllllllllllllIIIIllIIlIlIlIIIIII > lllllllllllllIIIIllIIlIlIIllIlII - lllllllllllllIIIIllIIlIlIIllllll) {
            final int lllllllllllllIIIIllIIlIlIlIIIlII = lllllllllllllIIIIllIIlIlIlIIIIII + (lllllllllllllIIIIllIIlIlIIllllll - lllllllllllllIIIIllIIlIlIlIIIIII) / 2;
            final int lllllllllllllIIIIllIIlIlIlIIIIll = lowerBound(lllllllllllllIIIIllIIlIlIIllllll, lllllllllllllIIIIllIIlIlIIllIlII, lllllllllllllIIIIllIIlIlIlIIIlII, lllllllllllllIIIIllIIlIlIIllllIl);
        }
        else {
            lllllllllllllIIIIllIIlIlIIlllIlI = lllllllllllllIIIIllIIlIlIIllllll + (lllllllllllllIIIIllIIlIlIIllIlII - lllllllllllllIIIIllIIlIlIIllllll) / 2;
            lllllllllllllIIIIllIIlIlIIlllIll = upperBound(lllllllllllllIIIIllIIlIlIlIIIIII, lllllllllllllIIIIllIIlIlIIllllll, lllllllllllllIIIIllIIlIlIIlllIlI, lllllllllllllIIIIllIIlIlIIllllIl);
        }
        final int lllllllllllllIIIIllIIlIlIIlllIIl = lllllllllllllIIIIllIIlIlIIlllIll;
        final int lllllllllllllIIIIllIIlIlIIlllIII = lllllllllllllIIIIllIIlIlIIllllll;
        final int lllllllllllllIIIIllIIlIlIIllIlll = lllllllllllllIIIIllIIlIlIIlllIlI;
        if (lllllllllllllIIIIllIIlIlIIlllIII != lllllllllllllIIIIllIIlIlIIlllIIl && lllllllllllllIIIIllIIlIlIIlllIII != lllllllllllllIIIIllIIlIlIIllIlll) {
            int lllllllllllllIIIIllIIlIlIlIIIIlI = lllllllllllllIIIIllIIlIlIIlllIIl;
            int lllllllllllllIIIIllIIlIlIlIIIIIl = lllllllllllllIIIIllIIlIlIIlllIII;
            while (lllllllllllllIIIIllIIlIlIlIIIIlI < --lllllllllllllIIIIllIIlIlIlIIIIIl) {
                lllllllllllllIIIIllIIlIlIIllIIlI.swap(lllllllllllllIIIIllIIlIlIlIIIIlI++, lllllllllllllIIIIllIIlIlIlIIIIIl);
            }
            lllllllllllllIIIIllIIlIlIlIIIIlI = lllllllllllllIIIIllIIlIlIIlllIII;
            lllllllllllllIIIIllIIlIlIlIIIIIl = lllllllllllllIIIIllIIlIlIIllIlll;
            while (lllllllllllllIIIIllIIlIlIlIIIIlI < --lllllllllllllIIIIllIIlIlIlIIIIIl) {
                lllllllllllllIIIIllIIlIlIIllIIlI.swap(lllllllllllllIIIIllIIlIlIlIIIIlI++, lllllllllllllIIIIllIIlIlIlIIIIIl);
            }
            lllllllllllllIIIIllIIlIlIlIIIIlI = lllllllllllllIIIIllIIlIlIIlllIIl;
            lllllllllllllIIIIllIIlIlIlIIIIIl = lllllllllllllIIIIllIIlIlIIllIlll;
            while (lllllllllllllIIIIllIIlIlIlIIIIlI < --lllllllllllllIIIIllIIlIlIlIIIIIl) {
                lllllllllllllIIIIllIIlIlIIllIIlI.swap(lllllllllllllIIIIllIIlIlIlIIIIlI++, lllllllllllllIIIIllIIlIlIlIIIIIl);
            }
        }
        lllllllllllllIIIIllIIlIlIIllllll = lllllllllllllIIIIllIIlIlIIlllIll + (lllllllllllllIIIIllIIlIlIIlllIlI - lllllllllllllIIIIllIIlIlIIllllll);
        inPlaceMerge(lllllllllllllIIIIllIIlIlIlIIIIII, lllllllllllllIIIIllIIlIlIIlllIll, lllllllllllllIIIIllIIlIlIIllllll, lllllllllllllIIIIllIIlIlIIllllIl, lllllllllllllIIIIllIIlIlIIllIIlI);
        inPlaceMerge(lllllllllllllIIIIllIIlIlIIllllll, lllllllllllllIIIIllIIlIlIIlllIlI, lllllllllllllIIIIllIIlIlIIllIlII, lllllllllllllIIIIllIIlIlIIllllIl, lllllllllllllIIIIllIIlIlIIllIIlI);
    }
    
    private static int med3(final int lllllllllllllIIIIllIIlIIlllllIIl, final int lllllllllllllIIIIllIIlIIlllllIII, final int lllllllllllllIIIIllIIlIIllllIIII, final IntComparator lllllllllllllIIIIllIIlIIlllIllll) {
        final int lllllllllllllIIIIllIIlIIllllIlIl = lllllllllllllIIIIllIIlIIlllIllll.compare(lllllllllllllIIIIllIIlIIlllllIIl, lllllllllllllIIIIllIIlIIlllllIII);
        final int lllllllllllllIIIIllIIlIIllllIlII = lllllllllllllIIIIllIIlIIlllIllll.compare(lllllllllllllIIIIllIIlIIlllllIIl, lllllllllllllIIIIllIIlIIllllIIII);
        final int lllllllllllllIIIIllIIlIIllllIIll = lllllllllllllIIIIllIIlIIlllIllll.compare(lllllllllllllIIIIllIIlIIlllllIII, lllllllllllllIIIIllIIlIIllllIIII);
        return (lllllllllllllIIIIllIIlIIllllIlIl < 0) ? ((lllllllllllllIIIIllIIlIIllllIIll < 0) ? lllllllllllllIIIIllIIlIIlllllIII : ((lllllllllllllIIIIllIIlIIllllIlII < 0) ? lllllllllllllIIIIllIIlIIllllIIII : lllllllllllllIIIIllIIlIIlllllIIl)) : ((lllllllllllllIIIIllIIlIIllllIIll > 0) ? lllllllllllllIIIIllIIlIIlllllIII : ((lllllllllllllIIIIllIIlIIllllIlII > 0) ? lllllllllllllIIIIllIIlIIllllIIII : lllllllllllllIIIIllIIlIIlllllIIl));
    }
    
    private static int upperBound(int lllllllllllllIIIIllIIlIlIIIIIlll, final int lllllllllllllIIIIllIIlIlIIIIlIll, final int lllllllllllllIIIIllIIlIlIIIIlIlI, final IntComparator lllllllllllllIIIIllIIlIlIIIIIlII) {
        int lllllllllllllIIIIllIIlIlIIIIlIII = lllllllllllllIIIIllIIlIlIIIIlIll - lllllllllllllIIIIllIIlIlIIIIIlll;
        while (lllllllllllllIIIIllIIlIlIIIIlIII > 0) {
            final int lllllllllllllIIIIllIIlIlIIIIlllI = lllllllllllllIIIIllIIlIlIIIIlIII / 2;
            final int lllllllllllllIIIIllIIlIlIIIIllIl = lllllllllllllIIIIllIIlIlIIIIIlll + lllllllllllllIIIIllIIlIlIIIIlllI;
            if (lllllllllllllIIIIllIIlIlIIIIIlII.compare(lllllllllllllIIIIllIIlIlIIIIlIlI, lllllllllllllIIIIllIIlIlIIIIllIl) < 0) {
                lllllllllllllIIIIllIIlIlIIIIlIII = lllllllllllllIIIIllIIlIlIIIIlllI;
            }
            else {
                lllllllllllllIIIIllIIlIlIIIIIlll = lllllllllllllIIIIllIIlIlIIIIllIl + 1;
                lllllllllllllIIIIllIIlIlIIIIlIII -= lllllllllllllIIIIllIIlIlIIIIlllI + 1;
            }
        }
        return lllllllllllllIIIIllIIlIlIIIIIlll;
    }
    
    static {
        QUICKSORT_NO_REC = 16;
        MAX_ARRAY_SIZE = 2147483639;
        PARALLEL_QUICKSORT_NO_FORK = 8192;
        MERGESORT_NO_REC = 16;
        QUICKSORT_MEDIAN_OF_9 = 128;
    }
    
    public static void mergeSort(final int lllllllllllllIIIIllIIlIIllIlllII, final int lllllllllllllIIIIllIIlIIlllIIIIl, final IntComparator lllllllllllllIIIIllIIlIIlllIIIII, final Swapper lllllllllllllIIIIllIIlIIllIllIIl) {
        final int lllllllllllllIIIIllIIlIIllIllllI = lllllllllllllIIIIllIIlIIlllIIIIl - lllllllllllllIIIIllIIlIIllIlllII;
        if (lllllllllllllIIIIllIIlIIllIllllI < 16) {
            for (int lllllllllllllIIIIllIIlIIlllIIIll = lllllllllllllIIIIllIIlIIllIlllII; lllllllllllllIIIIllIIlIIlllIIIll < lllllllllllllIIIIllIIlIIlllIIIIl; ++lllllllllllllIIIIllIIlIIlllIIIll) {
                for (int lllllllllllllIIIIllIIlIIlllIIlII = lllllllllllllIIIIllIIlIIlllIIIll; lllllllllllllIIIIllIIlIIlllIIlII > lllllllllllllIIIIllIIlIIllIlllII && lllllllllllllIIIIllIIlIIlllIIIII.compare(lllllllllllllIIIIllIIlIIlllIIlII - 1, lllllllllllllIIIIllIIlIIlllIIlII) > 0; --lllllllllllllIIIIllIIlIIlllIIlII) {
                    lllllllllllllIIIIllIIlIIllIllIIl.swap(lllllllllllllIIIIllIIlIIlllIIlII, lllllllllllllIIIIllIIlIIlllIIlII - 1);
                }
            }
            return;
        }
        final int lllllllllllllIIIIllIIlIIllIlllIl = lllllllllllllIIIIllIIlIIllIlllII + lllllllllllllIIIIllIIlIIlllIIIIl >>> 1;
        mergeSort(lllllllllllllIIIIllIIlIIllIlllII, lllllllllllllIIIIllIIlIIllIlllIl, lllllllllllllIIIIllIIlIIlllIIIII, lllllllllllllIIIIllIIlIIllIllIIl);
        mergeSort(lllllllllllllIIIIllIIlIIllIlllIl, lllllllllllllIIIIllIIlIIlllIIIIl, lllllllllllllIIIIllIIlIIlllIIIII, lllllllllllllIIIIllIIlIIllIllIIl);
        if (lllllllllllllIIIIllIIlIIlllIIIII.compare(lllllllllllllIIIIllIIlIIllIlllIl - 1, lllllllllllllIIIIllIIlIIllIlllIl) <= 0) {
            return;
        }
        inPlaceMerge(lllllllllllllIIIIllIIlIIllIlllII, lllllllllllllIIIIllIIlIIllIlllIl, lllllllllllllIIIIllIIlIIlllIIIIl, lllllllllllllIIIIllIIlIIlllIIIII, lllllllllllllIIIIllIIlIIllIllIIl);
    }
    
    protected static void swap(final Swapper lllllllllllllIIIIllIIlIIllIIlIll, int lllllllllllllIIIIllIIlIIllIIlIlI, int lllllllllllllIIIIllIIlIIllIIllIl, final int lllllllllllllIIIIllIIlIIllIIllII) {
        for (int lllllllllllllIIIIllIIlIIllIlIIII = 0; lllllllllllllIIIIllIIlIIllIlIIII < lllllllllllllIIIIllIIlIIllIIllII; ++lllllllllllllIIIIllIIlIIllIlIIII, ++lllllllllllllIIIIllIIlIIllIIlIlI, ++lllllllllllllIIIIllIIlIIllIIllIl) {
            lllllllllllllIIIIllIIlIIllIIlIll.swap(lllllllllllllIIIIllIIlIIllIIlIlI, lllllllllllllIIIIllIIlIIllIIllIl);
        }
    }
    
    private Arrays() {
    }
    
    protected static class ForkJoinGenericQuickSort extends RecursiveAction
    {
        private final /* synthetic */ int to;
        private final /* synthetic */ int from;
        private final /* synthetic */ IntComparator comp;
        private final /* synthetic */ Swapper swapper;
        
        public ForkJoinGenericQuickSort(final int lllllllllllllllIIllllIllllllIlII, final int lllllllllllllllIIllllIlllllIlllI, final IntComparator lllllllllllllllIIllllIllllllIIlI, final Swapper lllllllllllllllIIllllIlllllIllII) {
            this.from = lllllllllllllllIIllllIllllllIlII;
            this.to = lllllllllllllllIIllllIlllllIlllI;
            this.comp = lllllllllllllllIIllllIllllllIIlI;
            this.swapper = lllllllllllllllIIllllIlllllIllII;
        }
        
        @Override
        protected void compute() {
            final int lllllllllllllllIIllllIllllIlllIl = this.to - this.from;
            if (lllllllllllllllIIllllIllllIlllIl < 8192) {
                Arrays.quickSort(this.from, this.to, this.comp, this.swapper);
                return;
            }
            int lllllllllllllllIIllllIllllIlllII = this.from + lllllllllllllllIIllllIllllIlllIl / 2;
            int lllllllllllllllIIllllIllllIllIll = this.from;
            int lllllllllllllllIIllllIllllIllIlI = this.to - 1;
            int lllllllllllllllIIllllIllllIllIIl = lllllllllllllllIIllllIllllIlllIl / 8;
            lllllllllllllllIIllllIllllIllIll = med3(lllllllllllllllIIllllIllllIllIll, lllllllllllllllIIllllIllllIllIll + lllllllllllllllIIllllIllllIllIIl, lllllllllllllllIIllllIllllIllIll + 2 * lllllllllllllllIIllllIllllIllIIl, this.comp);
            lllllllllllllllIIllllIllllIlllII = med3(lllllllllllllllIIllllIllllIlllII - lllllllllllllllIIllllIllllIllIIl, lllllllllllllllIIllllIllllIlllII, lllllllllllllllIIllllIllllIlllII + lllllllllllllllIIllllIllllIllIIl, this.comp);
            lllllllllllllllIIllllIllllIllIlI = med3(lllllllllllllllIIllllIllllIllIlI - 2 * lllllllllllllllIIllllIllllIllIIl, lllllllllllllllIIllllIllllIllIlI - lllllllllllllllIIllllIllllIllIIl, lllllllllllllllIIllllIllllIllIlI, this.comp);
            lllllllllllllllIIllllIllllIlllII = med3(lllllllllllllllIIllllIllllIllIll, lllllllllllllllIIllllIllllIlllII, lllllllllllllllIIllllIllllIllIlI, this.comp);
            int lllllllllllllllIIllllIllllIlIlll;
            int lllllllllllllllIIllllIllllIllIII = lllllllllllllllIIllllIllllIlIlll = this.from;
            int lllllllllllllllIIllllIllllIlIlIl;
            int lllllllllllllllIIllllIllllIlIllI = lllllllllllllllIIllllIllllIlIlIl = this.to - 1;
            while (true) {
                final int lllllllllllllllIIllllIlllllIIIII;
                if (lllllllllllllllIIllllIllllIlIlll <= lllllllllllllllIIllllIllllIlIllI && (lllllllllllllllIIllllIlllllIIIII = this.comp.compare(lllllllllllllllIIllllIllllIlIlll, lllllllllllllllIIllllIllllIlllII)) <= 0) {
                    if (lllllllllllllllIIllllIlllllIIIII == 0) {
                        if (lllllllllllllllIIllllIllllIllIII == lllllllllllllllIIllllIllllIlllII) {
                            lllllllllllllllIIllllIllllIlllII = lllllllllllllllIIllllIllllIlIlll;
                        }
                        else if (lllllllllllllllIIllllIllllIlIlll == lllllllllllllllIIllllIllllIlllII) {
                            lllllllllllllllIIllllIllllIlllII = lllllllllllllllIIllllIllllIllIII;
                        }
                        this.swapper.swap(lllllllllllllllIIllllIllllIllIII++, lllllllllllllllIIllllIllllIlIlll);
                    }
                    ++lllllllllllllllIIllllIllllIlIlll;
                }
                else {
                    int lllllllllllllllIIllllIllllIlllll;
                    while (lllllllllllllllIIllllIllllIlIllI >= lllllllllllllllIIllllIllllIlIlll && (lllllllllllllllIIllllIllllIlllll = this.comp.compare(lllllllllllllllIIllllIllllIlIllI, lllllllllllllllIIllllIllllIlllII)) >= 0) {
                        if (lllllllllllllllIIllllIllllIlllll == 0) {
                            if (lllllllllllllllIIllllIllllIlIllI == lllllllllllllllIIllllIllllIlllII) {
                                lllllllllllllllIIllllIllllIlllII = lllllllllllllllIIllllIllllIlIlIl;
                            }
                            else if (lllllllllllllllIIllllIllllIlIlIl == lllllllllllllllIIllllIllllIlllII) {
                                lllllllllllllllIIllllIllllIlllII = lllllllllllllllIIllllIllllIlIllI;
                            }
                            this.swapper.swap(lllllllllllllllIIllllIllllIlIllI, lllllllllllllllIIllllIllllIlIlIl--);
                        }
                        --lllllllllllllllIIllllIllllIlIllI;
                    }
                    if (lllllllllllllllIIllllIllllIlIlll > lllllllllllllllIIllllIllllIlIllI) {
                        break;
                    }
                    if (lllllllllllllllIIllllIllllIlIlll == lllllllllllllllIIllllIllllIlllII) {
                        lllllllllllllllIIllllIllllIlllII = lllllllllllllllIIllllIllllIlIlIl;
                    }
                    else if (lllllllllllllllIIllllIllllIlIllI == lllllllllllllllIIllllIllllIlllII) {
                        lllllllllllllllIIllllIllllIlllII = lllllllllllllllIIllllIllllIlIllI;
                    }
                    this.swapper.swap(lllllllllllllllIIllllIllllIlIlll++, lllllllllllllllIIllllIllllIlIllI--);
                }
            }
            lllllllllllllllIIllllIllllIllIIl = Math.min(lllllllllllllllIIllllIllllIllIII - this.from, lllllllllllllllIIllllIllllIlIlll - lllllllllllllllIIllllIllllIllIII);
            Arrays.swap(this.swapper, this.from, lllllllllllllllIIllllIllllIlIlll - lllllllllllllllIIllllIllllIllIIl, lllllllllllllllIIllllIllllIllIIl);
            lllllllllllllllIIllllIllllIllIIl = Math.min(lllllllllllllllIIllllIllllIlIlIl - lllllllllllllllIIllllIllllIlIllI, this.to - lllllllllllllllIIllllIllllIlIlIl - 1);
            Arrays.swap(this.swapper, lllllllllllllllIIllllIllllIlIlll, this.to - lllllllllllllllIIllllIllllIllIIl, lllllllllllllllIIllllIllllIllIIl);
            lllllllllllllllIIllllIllllIllIIl = lllllllllllllllIIllllIllllIlIlll - lllllllllllllllIIllllIllllIllIII;
            final int lllllllllllllllIIllllIllllIlIlII = lllllllllllllllIIllllIllllIlIlIl - lllllllllllllllIIllllIllllIlIllI;
            if (lllllllllllllllIIllllIllllIllIIl > 1 && lllllllllllllllIIllllIllllIlIlII > 1) {
                ForkJoinTask.invokeAll(new ForkJoinGenericQuickSort(this.from, this.from + lllllllllllllllIIllllIllllIllIIl, this.comp, this.swapper), new ForkJoinGenericQuickSort(this.to - lllllllllllllllIIllllIllllIlIlII, this.to, this.comp, this.swapper));
            }
            else if (lllllllllllllllIIllllIllllIllIIl > 1) {
                ForkJoinTask.invokeAll(new ForkJoinGenericQuickSort(this.from, this.from + lllllllllllllllIIllllIllllIllIIl, this.comp, this.swapper));
            }
            else {
                ForkJoinTask.invokeAll(new ForkJoinGenericQuickSort(this.to - lllllllllllllllIIllllIllllIlIlII, this.to, this.comp, this.swapper));
            }
        }
    }
}
