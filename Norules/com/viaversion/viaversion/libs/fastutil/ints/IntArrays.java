package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.util.concurrent.atomic.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;

public final class IntArrays
{
    public static final /* synthetic */ int[] EMPTY_ARRAY;
    protected static final /* synthetic */ Segment POISON_PILL;
    
    public static int[] forceCapacity(final int[] lllllllllllllIllIIIIllIlIIIlllIl, final int lllllllllllllIllIIIIllIlIIIlllII, final int lllllllllllllIllIIIIllIlIIIllIll) {
        final int[] lllllllllllllIllIIIIllIlIIIllIlI = new int[lllllllllllllIllIIIIllIlIIIlllII];
        System.arraycopy(lllllllllllllIllIIIIllIlIIIlllIl, 0, lllllllllllllIllIIIIllIlIIIllIlI, 0, lllllllllllllIllIIIIllIlIIIllIll);
        return lllllllllllllIllIIIIllIlIIIllIlI;
    }
    
    public static void stableSort(final int[] lllllllllllllIllIIIIlIIlllIIIIII, final int lllllllllllllIllIIIIlIIllIllllll, final int lllllllllllllIllIIIIlIIllIlllIll) {
        unstableSort(lllllllllllllIllIIIIlIIlllIIIIII, lllllllllllllIllIIIIlIIllIllllll, lllllllllllllIllIIIIlIIllIlllIll);
    }
    
    public static int[] setLength(final int[] lllllllllllllIllIIIIllIIlllIIllI, final int lllllllllllllIllIIIIllIIlllIIlIl) {
        if (lllllllllllllIllIIIIllIIlllIIlIl == lllllllllllllIllIIIIllIIlllIIllI.length) {
            return lllllllllllllIllIIIIllIIlllIIllI;
        }
        if (lllllllllllllIllIIIIllIIlllIIlIl < lllllllllllllIllIIIIllIIlllIIllI.length) {
            return trim(lllllllllllllIllIIIIllIIlllIIllI, lllllllllllllIllIIIIllIIlllIIlIl);
        }
        return ensureCapacity(lllllllllllllIllIIIIllIIlllIIllI, lllllllllllllIllIIIIllIIlllIIlIl);
    }
    
    private static void selectionSort(final int[] lllllllllllllIllIIIIlIlIlIIIllll, final int[] lllllllllllllIllIIIIlIlIlIIIlllI, final int lllllllllllllIllIIIIlIlIlIIIllIl, final int lllllllllllllIllIIIIlIlIlIIlIIII) {
        for (int lllllllllllllIllIIIIlIlIlIIlIlII = lllllllllllllIllIIIIlIlIlIIIllIl; lllllllllllllIllIIIIlIlIlIIlIlII < lllllllllllllIllIIIIlIlIlIIlIIII - 1; ++lllllllllllllIllIIIIlIlIlIIlIlII) {
            int lllllllllllllIllIIIIlIlIlIIlIlIl = lllllllllllllIllIIIIlIlIlIIlIlII;
            for (int lllllllllllllIllIIIIlIlIlIIlIlll = lllllllllllllIllIIIIlIlIlIIlIlII + 1; lllllllllllllIllIIIIlIlIlIIlIlll < lllllllllllllIllIIIIlIlIlIIlIIII; ++lllllllllllllIllIIIIlIlIlIIlIlll) {
                final int lllllllllllllIllIIIIlIlIlIIllIII;
                if ((lllllllllllllIllIIIIlIlIlIIllIII = Integer.compare(lllllllllllllIllIIIIlIlIlIIIllll[lllllllllllllIllIIIIlIlIlIIlIlll], lllllllllllllIllIIIIlIlIlIIIllll[lllllllllllllIllIIIIlIlIlIIlIlIl])) < 0 || (lllllllllllllIllIIIIlIlIlIIllIII == 0 && lllllllllllllIllIIIIlIlIlIIIlllI[lllllllllllllIllIIIIlIlIlIIlIlll] < lllllllllllllIllIIIIlIlIlIIIlllI[lllllllllllllIllIIIIlIlIlIIlIlIl])) {
                    lllllllllllllIllIIIIlIlIlIIlIlIl = lllllllllllllIllIIIIlIlIlIIlIlll;
                }
            }
            if (lllllllllllllIllIIIIlIlIlIIlIlIl != lllllllllllllIllIIIIlIlIlIIlIlII) {
                int lllllllllllllIllIIIIlIlIlIIlIllI = lllllllllllllIllIIIIlIlIlIIIllll[lllllllllllllIllIIIIlIlIlIIlIlII];
                lllllllllllllIllIIIIlIlIlIIIllll[lllllllllllllIllIIIIlIlIlIIlIlII] = lllllllllllllIllIIIIlIlIlIIIllll[lllllllllllllIllIIIIlIlIlIIlIlIl];
                lllllllllllllIllIIIIlIlIlIIIllll[lllllllllllllIllIIIIlIlIlIIlIlIl] = lllllllllllllIllIIIIlIlIlIIlIllI;
                lllllllllllllIllIIIIlIlIlIIlIllI = lllllllllllllIllIIIIlIlIlIIIlllI[lllllllllllllIllIIIIlIlIlIIlIlII];
                lllllllllllllIllIIIIlIlIlIIIlllI[lllllllllllllIllIIIIlIlIlIIlIlII] = lllllllllllllIllIIIIlIlIlIIIlllI[lllllllllllllIllIIIIlIlIlIIlIlIl];
                lllllllllllllIllIIIIlIlIlIIIlllI[lllllllllllllIllIIIIlIlIlIIlIlIl] = lllllllllllllIllIIIIlIlIlIIlIllI;
            }
        }
    }
    
    public static void quickSortIndirect(final int[] lllllllllllllIllIIIIlIllIIIIlllI, final int[] lllllllllllllIllIIIIlIllIIIIllIl) {
        quickSortIndirect(lllllllllllllIllIIIIlIllIIIIlllI, lllllllllllllIllIIIIlIllIIIIllIl, 0, lllllllllllllIllIIIIlIllIIIIllIl.length);
    }
    
    public static void quickSort(final int[] lllllllllllllIllIIIIlIlllIlIIlII, final int lllllllllllllIllIIIIlIlllIIlIllI, final int lllllllllllllIllIIIIlIlllIlIIIlI) {
        final int lllllllllllllIllIIIIlIlllIlIIIIl = lllllllllllllIllIIIIlIlllIlIIIlI - lllllllllllllIllIIIIlIlllIIlIllI;
        if (lllllllllllllIllIIIIlIlllIlIIIIl < 16) {
            selectionSort(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIlIllI, lllllllllllllIllIIIIlIlllIlIIIlI);
            return;
        }
        int lllllllllllllIllIIIIlIlllIlIIIII = lllllllllllllIllIIIIlIlllIIlIllI + lllllllllllllIllIIIIlIlllIlIIIIl / 2;
        int lllllllllllllIllIIIIlIlllIIlllll = lllllllllllllIllIIIIlIlllIIlIllI;
        int lllllllllllllIllIIIIlIlllIIllllI = lllllllllllllIllIIIIlIlllIlIIIlI - 1;
        if (lllllllllllllIllIIIIlIlllIlIIIIl > 128) {
            final int lllllllllllllIllIIIIlIlllIlIIlll = lllllllllllllIllIIIIlIlllIlIIIIl / 8;
            lllllllllllllIllIIIIlIlllIIlllll = med3(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIlllll, lllllllllllllIllIIIIlIlllIIlllll + lllllllllllllIllIIIIlIlllIlIIlll, lllllllllllllIllIIIIlIlllIIlllll + 2 * lllllllllllllIllIIIIlIlllIlIIlll);
            lllllllllllllIllIIIIlIlllIlIIIII = med3(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIlIIIII - lllllllllllllIllIIIIlIlllIlIIlll, lllllllllllllIllIIIIlIlllIlIIIII, lllllllllllllIllIIIIlIlllIlIIIII + lllllllllllllIllIIIIlIlllIlIIlll);
            lllllllllllllIllIIIIlIlllIIllllI = med3(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIllllI - 2 * lllllllllllllIllIIIIlIlllIlIIlll, lllllllllllllIllIIIIlIlllIIllllI - lllllllllllllIllIIIIlIlllIlIIlll, lllllllllllllIllIIIIlIlllIIllllI);
        }
        lllllllllllllIllIIIIlIlllIlIIIII = med3(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIlllll, lllllllllllllIllIIIIlIlllIlIIIII, lllllllllllllIllIIIIlIlllIIllllI);
        final int lllllllllllllIllIIIIlIlllIIlllIl = lllllllllllllIllIIIIlIlllIlIIlII[lllllllllllllIllIIIIlIlllIlIIIII];
        int lllllllllllllIllIIIIlIlllIIllIll;
        int lllllllllllllIllIIIIlIlllIIlllII = lllllllllllllIllIIIIlIlllIIllIll = lllllllllllllIllIIIIlIlllIIlIllI;
        int lllllllllllllIllIIIIlIlllIIllIIl;
        int lllllllllllllIllIIIIlIlllIIllIlI = lllllllllllllIllIIIIlIlllIIllIIl = lllllllllllllIllIIIIlIlllIlIIIlI - 1;
        while (true) {
            final int lllllllllllllIllIIIIlIlllIlIIllI;
            if (lllllllllllllIllIIIIlIlllIIllIll <= lllllllllllllIllIIIIlIlllIIllIlI && (lllllllllllllIllIIIIlIlllIlIIllI = Integer.compare(lllllllllllllIllIIIIlIlllIlIIlII[lllllllllllllIllIIIIlIlllIIllIll], lllllllllllllIllIIIIlIlllIIlllIl)) <= 0) {
                if (lllllllllllllIllIIIIlIlllIlIIllI == 0) {
                    swap(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIlllII++, lllllllllllllIllIIIIlIlllIIllIll);
                }
                ++lllllllllllllIllIIIIlIlllIIllIll;
            }
            else {
                int lllllllllllllIllIIIIlIlllIlIIlIl;
                while (lllllllllllllIllIIIIlIlllIIllIlI >= lllllllllllllIllIIIIlIlllIIllIll && (lllllllllllllIllIIIIlIlllIlIIlIl = Integer.compare(lllllllllllllIllIIIIlIlllIlIIlII[lllllllllllllIllIIIIlIlllIIllIlI], lllllllllllllIllIIIIlIlllIIlllIl)) >= 0) {
                    if (lllllllllllllIllIIIIlIlllIlIIlIl == 0) {
                        swap(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIllIlI, lllllllllllllIllIIIIlIlllIIllIIl--);
                    }
                    --lllllllllllllIllIIIIlIlllIIllIlI;
                }
                if (lllllllllllllIllIIIIlIlllIIllIll > lllllllllllllIllIIIIlIlllIIllIlI) {
                    break;
                }
                swap(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIllIll++, lllllllllllllIllIIIIlIlllIIllIlI--);
            }
        }
        int lllllllllllllIllIIIIlIlllIIllIII = Math.min(lllllllllllllIllIIIIlIlllIIlllII - lllllllllllllIllIIIIlIlllIIlIllI, lllllllllllllIllIIIIlIlllIIllIll - lllllllllllllIllIIIIlIlllIIlllII);
        swap(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIlIllI, lllllllllllllIllIIIIlIlllIIllIll - lllllllllllllIllIIIIlIlllIIllIII, lllllllllllllIllIIIIlIlllIIllIII);
        lllllllllllllIllIIIIlIlllIIllIII = Math.min(lllllllllllllIllIIIIlIlllIIllIIl - lllllllllllllIllIIIIlIlllIIllIlI, lllllllllllllIllIIIIlIlllIlIIIlI - lllllllllllllIllIIIIlIlllIIllIIl - 1);
        swap(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIllIll, lllllllllllllIllIIIIlIlllIlIIIlI - lllllllllllllIllIIIIlIlllIIllIII, lllllllllllllIllIIIIlIlllIIllIII);
        if ((lllllllllllllIllIIIIlIlllIIllIII = lllllllllllllIllIIIIlIlllIIllIll - lllllllllllllIllIIIIlIlllIIlllII) > 1) {
            quickSort(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIIlIllI, lllllllllllllIllIIIIlIlllIIlIllI + lllllllllllllIllIIIIlIlllIIllIII);
        }
        if ((lllllllllllllIllIIIIlIlllIIllIII = lllllllllllllIllIIIIlIlllIIllIIl - lllllllllllllIllIIIIlIlllIIllIlI) > 1) {
            quickSort(lllllllllllllIllIIIIlIlllIlIIlII, lllllllllllllIllIIIIlIlllIlIIIlI - lllllllllllllIllIIIIlIlllIIllIII, lllllllllllllIllIIIIlIlllIlIIIlI);
        }
    }
    
    public static void radixSortIndirect(final int[] lllllllllllllIllIIIIIllllIlllIll, final int[] lllllllllllllIllIIIIIllllIllIllI, final int[] lllllllllllllIllIIIIIllllIlllIIl, final boolean lllllllllllllIllIIIIIllllIllIlII) {
        ensureSameLength(lllllllllllllIllIIIIIllllIllIllI, lllllllllllllIllIIIIIllllIlllIIl);
        radixSortIndirect(lllllllllllllIllIIIIIllllIlllIll, lllllllllllllIllIIIIIllllIllIllI, lllllllllllllIllIIIIIllllIlllIIl, 0, lllllllllllllIllIIIIIllllIllIllI.length, lllllllllllllIllIIIIIllllIllIlII);
    }
    
    public static void parallelQuickSort(final int[] lllllllllllllIllIIIIlIlIIlIIlIII, final int[] lllllllllllllIllIIIIlIlIIlIIIIlI, final int lllllllllllllIllIIIIlIlIIlIIIllI, final int lllllllllllllIllIIIIlIlIIlIIIIII) {
        if (lllllllllllllIllIIIIlIlIIlIIIIII - lllllllllllllIllIIIIlIlIIlIIIllI < 8192) {
            quickSort(lllllllllllllIllIIIIlIlIIlIIlIII, lllllllllllllIllIIIIlIlIIlIIIIlI, lllllllllllllIllIIIIlIlIIlIIIllI, lllllllllllllIllIIIIlIlIIlIIIIII);
        }
        final ForkJoinPool lllllllllllllIllIIIIlIlIIlIIIlII = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        lllllllllllllIllIIIIlIlIIlIIIlII.invoke((ForkJoinTask<Object>)new ForkJoinQuickSort2(lllllllllllllIllIIIIlIlIIlIIlIII, lllllllllllllIllIIIIlIlIIlIIIIlI, lllllllllllllIllIIIIlIlIIlIIIllI, lllllllllllllIllIIIIlIlIIlIIIIII));
        lllllllllllllIllIIIIlIlIIlIIIlII.shutdown();
    }
    
    public static void parallelQuickSort(final int[] lllllllllllllIllIIIIlIlIIIlllIlI, final int[] lllllllllllllIllIIIIlIlIIIlllIll) {
        ensureSameLength(lllllllllllllIllIIIIlIlIIIlllIlI, lllllllllllllIllIIIIlIlIIIlllIll);
        parallelQuickSort(lllllllllllllIllIIIIlIlIIIlllIlI, lllllllllllllIllIIIIlIlIIIlllIll, 0, lllllllllllllIllIIIIlIlIIIlllIlI.length);
    }
    
    public static int binarySearch(final int[] lllllllllllllIllIIIIlIIllIIIIIlI, int lllllllllllllIllIIIIlIIlIlllllII, int lllllllllllllIllIIIIlIIlIllllIll, final int lllllllllllllIllIIIIlIIlIlllllll, final IntComparator lllllllllllllIllIIIIlIIlIllllllI) {
        --lllllllllllllIllIIIIlIIlIllllIll;
        while (lllllllllllllIllIIIIlIIlIlllllII <= lllllllllllllIllIIIIlIIlIllllIll) {
            final int lllllllllllllIllIIIIlIIllIIIIlIl = lllllllllllllIllIIIIlIIlIlllllII + lllllllllllllIllIIIIlIIlIllllIll >>> 1;
            final int lllllllllllllIllIIIIlIIllIIIIIll = lllllllllllllIllIIIIlIIllIIIIIlI[lllllllllllllIllIIIIlIIllIIIIlIl];
            final int lllllllllllllIllIIIIlIIllIIIIlII = lllllllllllllIllIIIIlIIlIllllllI.compare(lllllllllllllIllIIIIlIIllIIIIIll, lllllllllllllIllIIIIlIIlIlllllll);
            if (lllllllllllllIllIIIIlIIllIIIIlII < 0) {
                lllllllllllllIllIIIIlIIlIlllllII = lllllllllllllIllIIIIlIIllIIIIlIl + 1;
            }
            else {
                if (lllllllllllllIllIIIIlIIllIIIIlII <= 0) {
                    return lllllllllllllIllIIIIlIIllIIIIlIl;
                }
                lllllllllllllIllIIIIlIIlIllllIll = lllllllllllllIllIIIIlIIllIIIIlIl - 1;
            }
        }
        return -(lllllllllllllIllIIIIlIIlIlllllII + 1);
    }
    
    public static int[] trim(final int[] lllllllllllllIllIIIIllIIlllIlIll, final int lllllllllllllIllIIIIllIIlllIlIlI) {
        if (lllllllllllllIllIIIIllIIlllIlIlI >= lllllllllllllIllIIIIllIIlllIlIll.length) {
            return lllllllllllllIllIIIIllIIlllIlIll;
        }
        final int[] lllllllllllllIllIIIIllIIlllIllII = (lllllllllllllIllIIIIllIIlllIlIlI == 0) ? IntArrays.EMPTY_ARRAY : new int[lllllllllllllIllIIIIllIIlllIlIlI];
        System.arraycopy(lllllllllllllIllIIIIllIIlllIlIll, 0, lllllllllllllIllIIIIllIIlllIllII, 0, lllllllllllllIllIIIIllIIlllIlIlI);
        return lllllllllllllIllIIIIllIIlllIllII;
    }
    
    public static void mergeSort(final int[] lllllllllllllIllIIIIlIIlllIIIlIl, final IntComparator lllllllllllllIllIIIIlIIlllIIIllI) {
        mergeSort(lllllllllllllIllIIIIlIIlllIIIlIl, 0, lllllllllllllIllIIIIlIIlllIIIlIl.length, lllllllllllllIllIIIIlIIlllIIIllI);
    }
    
    public static void unstableSort(final int[] lllllllllllllIllIIIIlIlIIIIlllII, final IntComparator lllllllllllllIllIIIIlIlIIIIllIll) {
        unstableSort(lllllllllllllIllIIIIlIlIIIIlllII, 0, lllllllllllllIllIIIIlIlIIIIlllII.length, lllllllllllllIllIIIIlIlIIIIllIll);
    }
    
    public static int binarySearch(final int[] lllllllllllllIllIIIIlIIllIIllIIl, int lllllllllllllIllIIIIlIIllIIllIII, int lllllllllllllIllIIIIlIIllIIlIlll, final int lllllllllllllIllIIIIlIIllIIllIlI) {
        --lllllllllllllIllIIIIlIIllIIlIlll;
        while (lllllllllllllIllIIIIlIIllIIllIII <= lllllllllllllIllIIIIlIIllIIlIlll) {
            final int lllllllllllllIllIIIIlIIllIIlllll = lllllllllllllIllIIIIlIIllIIllIII + lllllllllllllIllIIIIlIIllIIlIlll >>> 1;
            final int lllllllllllllIllIIIIlIIllIIllllI = lllllllllllllIllIIIIlIIllIIllIIl[lllllllllllllIllIIIIlIIllIIlllll];
            if (lllllllllllllIllIIIIlIIllIIllllI < lllllllllllllIllIIIIlIIllIIllIlI) {
                lllllllllllllIllIIIIlIIllIIllIII = lllllllllllllIllIIIIlIIllIIlllll + 1;
            }
            else {
                if (lllllllllllllIllIIIIlIIllIIllllI <= lllllllllllllIllIIIIlIIllIIllIlI) {
                    return lllllllllllllIllIIIIlIIllIIlllll;
                }
                lllllllllllllIllIIIIlIIllIIlIlll = lllllllllllllIllIIIIlIIllIIlllll - 1;
            }
        }
        return -(lllllllllllllIllIIIIlIIllIIllIII + 1);
    }
    
    public static void radixSort(final int[] lllllllllllllIllIIIIlIIlIllIlIlI) {
        radixSort(lllllllllllllIllIIIIlIIlIllIlIlI, 0, lllllllllllllIllIIIIlIIlIllIlIlI.length);
    }
    
    public static void unstableSort(final int[] lllllllllllllIllIIIIlIlIIIlIIlII, final int lllllllllllllIllIIIIlIlIIIlIIlll, final int lllllllllllllIllIIIIlIlIIIlIIllI, final IntComparator lllllllllllllIllIIIIlIlIIIlIIIIl) {
        quickSort(lllllllllllllIllIIIIlIlIIIlIIlII, lllllllllllllIllIIIIlIlIIIlIIlll, lllllllllllllIllIIIIlIlIIIlIIllI, lllllllllllllIllIIIIlIlIIIlIIIIl);
    }
    
    private static void selectionSort(final int[] lllllllllllllIllIIIIllIIIlIlllII, final int lllllllllllllIllIIIIllIIIlIlIlll, final int lllllllllllllIllIIIIllIIIlIlIllI, final IntComparator lllllllllllllIllIIIIllIIIlIlIlIl) {
        for (int lllllllllllllIllIIIIllIIIlIlllIl = lllllllllllllIllIIIIllIIIlIlIlll; lllllllllllllIllIIIIllIIIlIlllIl < lllllllllllllIllIIIIllIIIlIlIllI - 1; ++lllllllllllllIllIIIIllIIIlIlllIl) {
            int lllllllllllllIllIIIIllIIIlIllllI = lllllllllllllIllIIIIllIIIlIlllIl;
            for (int lllllllllllllIllIIIIllIIIllIIIII = lllllllllllllIllIIIIllIIIlIlllIl + 1; lllllllllllllIllIIIIllIIIllIIIII < lllllllllllllIllIIIIllIIIlIlIllI; ++lllllllllllllIllIIIIllIIIllIIIII) {
                if (lllllllllllllIllIIIIllIIIlIlIlIl.compare(lllllllllllllIllIIIIllIIIlIlllII[lllllllllllllIllIIIIllIIIllIIIII], lllllllllllllIllIIIIllIIIlIlllII[lllllllllllllIllIIIIllIIIlIllllI]) < 0) {
                    lllllllllllllIllIIIIllIIIlIllllI = lllllllllllllIllIIIIllIIIllIIIII;
                }
            }
            if (lllllllllllllIllIIIIllIIIlIllllI != lllllllllllllIllIIIIllIIIlIlllIl) {
                final int lllllllllllllIllIIIIllIIIlIlllll = lllllllllllllIllIIIIllIIIlIlllII[lllllllllllllIllIIIIllIIIlIlllIl];
                lllllllllllllIllIIIIllIIIlIlllII[lllllllllllllIllIIIIllIIIlIlllIl] = lllllllllllllIllIIIIllIIIlIlllII[lllllllllllllIllIIIIllIIIlIllllI];
                lllllllllllllIllIIIIllIIIlIlllII[lllllllllllllIllIIIIllIIIlIllllI] = lllllllllllllIllIIIIllIIIlIlllll;
            }
        }
    }
    
    public static void radixSortIndirect(final int[] lllllllllllllIllIIIIIllllIIIIIll, final int[] lllllllllllllIllIIIIIllllIIIIIlI, final int[] lllllllllllllIllIIIIIlllIlllIIIl, final int lllllllllllllIllIIIIIllllIIIIIII, final int lllllllllllllIllIIIIIlllIllIllll, final boolean lllllllllllllIllIIIIIlllIllIlllI) {
        if (lllllllllllllIllIIIIIlllIllIllll - lllllllllllllIllIIIIIllllIIIIIII < 1024) {
            insertionSortIndirect(lllllllllllllIllIIIIIllllIIIIIll, lllllllllllllIllIIIIIllllIIIIIlI, lllllllllllllIllIIIIIlllIlllIIIl, lllllllllllllIllIIIIIllllIIIIIII, lllllllllllllIllIIIIIlllIllIllll);
            return;
        }
        final int lllllllllllllIllIIIIIlllIlllllIl = 2;
        final int lllllllllllllIllIIIIIlllIlllllII = 7;
        final int lllllllllllllIllIIIIIlllIllllIll = 1786;
        int lllllllllllllIllIIIIIlllIllllIlI = 0;
        final int[] lllllllllllllIllIIIIIlllIllllIIl = new int[1786];
        final int[] lllllllllllllIllIIIIIlllIllllIII = new int[1786];
        final int[] lllllllllllllIllIIIIIlllIlllIlll = new int[1786];
        lllllllllllllIllIIIIIlllIllllIII[lllllllllllllIllIIIIIlllIllllIlI] = lllllllllllllIllIIIIIlllIllIllll - (lllllllllllllIllIIIIIlllIllllIIl[lllllllllllllIllIIIIIlllIllllIlI] = lllllllllllllIllIIIIIllllIIIIIII);
        lllllllllllllIllIIIIIlllIlllIlll[lllllllllllllIllIIIIIlllIllllIlI++] = 0;
        final int[] lllllllllllllIllIIIIIlllIlllIllI = new int[256];
        final int[] lllllllllllllIllIIIIIlllIlllIlIl = new int[256];
        final int[] lllllllllllllIllIIIIIlllIlllIlII = (int[])(lllllllllllllIllIIIIIlllIllIlllI ? new int[lllllllllllllIllIIIIIllllIIIIIll.length] : null);
        while (lllllllllllllIllIIIIIlllIllllIlI > 0) {
            final int lllllllllllllIllIIIIIllllIIIlIlI = lllllllllllllIllIIIIIlllIllllIIl[--lllllllllllllIllIIIIIlllIllllIlI];
            final int lllllllllllllIllIIIIIllllIIIlIIl = lllllllllllllIllIIIIIlllIllllIII[lllllllllllllIllIIIIIlllIllllIlI];
            final int lllllllllllllIllIIIIIllllIIIlIII = lllllllllllllIllIIIIIlllIlllIlll[lllllllllllllIllIIIIIlllIllllIlI];
            final int lllllllllllllIllIIIIIllllIIIIlll = (lllllllllllllIllIIIIIllllIIIlIII % 4 == 0) ? 128 : 0;
            final int[] lllllllllllllIllIIIIIllllIIIIllI = (lllllllllllllIllIIIIIllllIIIlIII < 4) ? lllllllllllllIllIIIIIllllIIIIIlI : lllllllllllllIllIIIIIlllIlllIIIl;
            final int lllllllllllllIllIIIIIllllIIIIlIl = (3 - lllllllllllllIllIIIIIllllIIIlIII % 4) * 8;
            int lllllllllllllIllIIIIIllllIIlIllI = lllllllllllllIllIIIIIllllIIIlIlI + lllllllllllllIllIIIIIllllIIIlIIl;
            while (lllllllllllllIllIIIIIllllIIlIllI-- != lllllllllllllIllIIIIIllllIIIlIlI) {
                final int[] array = lllllllllllllIllIIIIIlllIlllIllI;
                final int n = (lllllllllllllIllIIIIIllllIIIIllI[lllllllllllllIllIIIIIllllIIIIIll[lllllllllllllIllIIIIIllllIIlIllI]] >>> lllllllllllllIllIIIIIllllIIIIlIl & 0xFF) ^ lllllllllllllIllIIIIIllllIIIIlll;
                ++array[n];
            }
            int lllllllllllllIllIIIIIllllIIIIlII = -1;
            int lllllllllllllIllIIIIIllllIIlIlIl = 0;
            int lllllllllllllIllIIIIIllllIIlIlII = lllllllllllllIllIIIIIlllIllIlllI ? 0 : lllllllllllllIllIIIIIllllIIIlIlI;
            while (lllllllllllllIllIIIIIllllIIlIlIl < 256) {
                if (lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIlIlIl] != 0) {
                    lllllllllllllIllIIIIIllllIIIIlII = lllllllllllllIllIIIIIllllIIlIlIl;
                }
                lllllllllllllIllIIIIIllllIIlIlII = (lllllllllllllIllIIIIIlllIlllIlIl[lllllllllllllIllIIIIIllllIIlIlIl] = lllllllllllllIllIIIIIllllIIlIlII + lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIlIlIl]);
                ++lllllllllllllIllIIIIIllllIIlIlIl;
            }
            if (lllllllllllllIllIIIIIlllIllIlllI) {
                int lllllllllllllIllIIIIIllllIIlIIll = lllllllllllllIllIIIIIllllIIIlIlI + lllllllllllllIllIIIIIllllIIIlIIl;
                while (lllllllllllllIllIIIIIllllIIlIIll-- != lllllllllllllIllIIIIIllllIIIlIlI) {
                    final int[] array2 = lllllllllllllIllIIIIIlllIlllIlII;
                    final int[] array3 = lllllllllllllIllIIIIIlllIlllIlIl;
                    final int n2 = (lllllllllllllIllIIIIIllllIIIIllI[lllllllllllllIllIIIIIllllIIIIIll[lllllllllllllIllIIIIIllllIIlIIll]] >>> lllllllllllllIllIIIIIllllIIIIlIl & 0xFF) ^ lllllllllllllIllIIIIIllllIIIIlll;
                    array2[--array3[n2]] = lllllllllllllIllIIIIIllllIIIIIll[lllllllllllllIllIIIIIllllIIlIIll];
                }
                System.arraycopy(lllllllllllllIllIIIIIlllIlllIlII, 0, lllllllllllllIllIIIIIllllIIIIIll, lllllllllllllIllIIIIIllllIIIlIlI, lllllllllllllIllIIIIIllllIIIlIIl);
                int lllllllllllllIllIIIIIllllIIlIIlI = 0;
                int lllllllllllllIllIIIIIllllIIlIIIl = lllllllllllllIllIIIIIllllIIIlIlI;
                while (lllllllllllllIllIIIIIllllIIlIIlI < 256) {
                    if (lllllllllllllIllIIIIIllllIIIlIII < 7 && lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIlIIlI] > 1) {
                        if (lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIlIIlI] < 1024) {
                            insertionSortIndirect(lllllllllllllIllIIIIIllllIIIIIll, lllllllllllllIllIIIIIllllIIIIIlI, lllllllllllllIllIIIIIlllIlllIIIl, lllllllllllllIllIIIIIllllIIlIIIl, lllllllllllllIllIIIIIllllIIlIIIl + lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIlIIlI]);
                        }
                        else {
                            lllllllllllllIllIIIIIlllIllllIIl[lllllllllllllIllIIIIIlllIllllIlI] = lllllllllllllIllIIIIIllllIIlIIIl;
                            lllllllllllllIllIIIIIlllIllllIII[lllllllllllllIllIIIIIlllIllllIlI] = lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIlIIlI];
                            lllllllllllllIllIIIIIlllIlllIlll[lllllllllllllIllIIIIIlllIllllIlI++] = lllllllllllllIllIIIIIllllIIIlIII + 1;
                        }
                    }
                    lllllllllllllIllIIIIIllllIIlIIIl += lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIlIIlI];
                    ++lllllllllllllIllIIIIIllllIIlIIlI;
                }
                Arrays.fill(lllllllllllllIllIIIIIlllIlllIllI, 0);
            }
            else {
                for (int lllllllllllllIllIIIIIllllIIIlIll = lllllllllllllIllIIIIIllllIIIlIlI + lllllllllllllIllIIIIIllllIIIlIIl - lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIIIlII], lllllllllllllIllIIIIIllllIIIllIl = lllllllllllllIllIIIIIllllIIIlIlI, lllllllllllllIllIIIIIllllIIIllII = -1; lllllllllllllIllIIIIIllllIIIllIl <= lllllllllllllIllIIIIIllllIIIlIll; lllllllllllllIllIIIIIllllIIIllIl += lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIIllII], lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIIllII] = 0) {
                    int lllllllllllllIllIIIIIllllIIIlllI = lllllllllllllIllIIIIIllllIIIIIll[lllllllllllllIllIIIIIllllIIIllIl];
                    lllllllllllllIllIIIIIllllIIIllII = ((lllllllllllllIllIIIIIllllIIIIllI[lllllllllllllIllIIIIIllllIIIlllI] >>> lllllllllllllIllIIIIIllllIIIIlIl & 0xFF) ^ lllllllllllllIllIIIIIllllIIIIlll);
                    if (lllllllllllllIllIIIIIllllIIIllIl < lllllllllllllIllIIIIIllllIIIlIll) {
                        while (true) {
                            final int[] array4 = lllllllllllllIllIIIIIlllIlllIlIl;
                            final int n3 = lllllllllllllIllIIIIIllllIIIllII;
                            final int n4 = array4[n3] - 1;
                            array4[n3] = n4;
                            final int lllllllllllllIllIIIIIllllIIIllll;
                            if ((lllllllllllllIllIIIIIllllIIIllll = n4) <= lllllllllllllIllIIIIIllllIIIllIl) {
                                break;
                            }
                            final int lllllllllllllIllIIIIIllllIIlIIII = lllllllllllllIllIIIIIllllIIIlllI;
                            lllllllllllllIllIIIIIllllIIIlllI = lllllllllllllIllIIIIIllllIIIIIll[lllllllllllllIllIIIIIllllIIIllll];
                            lllllllllllllIllIIIIIllllIIIIIll[lllllllllllllIllIIIIIllllIIIllll] = lllllllllllllIllIIIIIllllIIlIIII;
                            lllllllllllllIllIIIIIllllIIIllII = ((lllllllllllllIllIIIIIllllIIIIllI[lllllllllllllIllIIIIIllllIIIlllI] >>> lllllllllllllIllIIIIIllllIIIIlIl & 0xFF) ^ lllllllllllllIllIIIIIllllIIIIlll);
                        }
                        lllllllllllllIllIIIIIllllIIIIIll[lllllllllllllIllIIIIIllllIIIllIl] = lllllllllllllIllIIIIIllllIIIlllI;
                    }
                    if (lllllllllllllIllIIIIIllllIIIlIII < 7 && lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIIllII] > 1) {
                        if (lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIIllII] < 1024) {
                            insertionSortIndirect(lllllllllllllIllIIIIIllllIIIIIll, lllllllllllllIllIIIIIllllIIIIIlI, lllllllllllllIllIIIIIlllIlllIIIl, lllllllllllllIllIIIIIllllIIIllIl, lllllllllllllIllIIIIIllllIIIllIl + lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIIllII]);
                        }
                        else {
                            lllllllllllllIllIIIIIlllIllllIIl[lllllllllllllIllIIIIIlllIllllIlI] = lllllllllllllIllIIIIIllllIIIllIl;
                            lllllllllllllIllIIIIIlllIllllIII[lllllllllllllIllIIIIIlllIllllIlI] = lllllllllllllIllIIIIIlllIlllIllI[lllllllllllllIllIIIIIllllIIIllII];
                            lllllllllllllIllIIIIIlllIlllIlll[lllllllllllllIllIIIIIlllIllllIlI++] = lllllllllllllIllIIIIIllllIIIlIII + 1;
                        }
                    }
                }
            }
        }
    }
    
    private static void swap(final int[] lllllllllllllIllIIIIlIlIlIlllllI, final int[] lllllllllllllIllIIIIlIlIlIllIlll, final int lllllllllllllIllIIIIlIlIlIllIllI, final int lllllllllllllIllIIIIlIlIlIlllIll) {
        final int lllllllllllllIllIIIIlIlIlIlllIlI = lllllllllllllIllIIIIlIlIlIlllllI[lllllllllllllIllIIIIlIlIlIllIllI];
        final int lllllllllllllIllIIIIlIlIlIlllIIl = lllllllllllllIllIIIIlIlIlIllIlll[lllllllllllllIllIIIIlIlIlIllIllI];
        lllllllllllllIllIIIIlIlIlIlllllI[lllllllllllllIllIIIIlIlIlIllIllI] = lllllllllllllIllIIIIlIlIlIlllllI[lllllllllllllIllIIIIlIlIlIlllIll];
        lllllllllllllIllIIIIlIlIlIllIlll[lllllllllllllIllIIIIlIlIlIllIllI] = lllllllllllllIllIIIIlIlIlIllIlll[lllllllllllllIllIIIIlIlIlIlllIll];
        lllllllllllllIllIIIIlIlIlIlllllI[lllllllllllllIllIIIIlIlIlIlllIll] = lllllllllllllIllIIIIlIlIlIlllIlI;
        lllllllllllllIllIIIIlIlIlIllIlll[lllllllllllllIllIIIIlIlIlIlllIll] = lllllllllllllIllIIIIlIlIlIlllIIl;
    }
    
    public static int[] ensureCapacity(final int[] lllllllllllllIllIIIIllIlIIIlIIIl, final int lllllllllllllIllIIIIllIlIIIlIIII) {
        return ensureCapacity(lllllllllllllIllIIIIllIlIIIlIIIl, lllllllllllllIllIIIIllIlIIIlIIII, lllllllllllllIllIIIIllIlIIIlIIIl.length);
    }
    
    public static void parallelRadixSort(final int[] lllllllllllllIllIIIIIlllllIlllII, final int[] lllllllllllllIllIIIIIlllllIllIll) {
        ensureSameLength(lllllllllllllIllIIIIIlllllIlllII, lllllllllllllIllIIIIIlllllIllIll);
        parallelRadixSort(lllllllllllllIllIIIIIlllllIlllII, lllllllllllllIllIIIIIlllllIllIll, 0, lllllllllllllIllIIIIIlllllIlllII.length);
    }
    
    public static void swap(final int[] lllllllllllllIllIIIIllIIlIIIIlII, int lllllllllllllIllIIIIllIIlIIIIIll, int lllllllllllllIllIIIIllIIlIIIIllI, final int lllllllllllllIllIIIIllIIlIIIIIIl) {
        for (int lllllllllllllIllIIIIllIIlIIIlIIl = 0; lllllllllllllIllIIIIllIIlIIIlIIl < lllllllllllllIllIIIIllIIlIIIIIIl; ++lllllllllllllIllIIIIllIIlIIIlIIl, ++lllllllllllllIllIIIIllIIlIIIIIll, ++lllllllllllllIllIIIIllIIlIIIIllI) {
            swap(lllllllllllllIllIIIIllIIlIIIIlII, lllllllllllllIllIIIIllIIlIIIIIll, lllllllllllllIllIIIIllIIlIIIIllI);
        }
    }
    
    private static void insertionSort(final int[] lllllllllllllIllIIIIlIlllIlllIll, final int lllllllllllllIllIIIIlIlllIlllIlI, final int lllllllllllllIllIIIIlIlllIlllIIl) {
        int lllllllllllllIllIIIIlIlllIllllll = lllllllllllllIllIIIIlIlllIlllIlI;
        while (++lllllllllllllIllIIIIlIlllIllllll < lllllllllllllIllIIIIlIlllIlllIIl) {
            final int lllllllllllllIllIIIIlIllllIIIIIl = lllllllllllllIllIIIIlIlllIlllIll[lllllllllllllIllIIIIlIlllIllllll];
            int lllllllllllllIllIIIIlIllllIIIIII = lllllllllllllIllIIIIlIlllIllllll;
            for (int lllllllllllllIllIIIIlIllllIIIIlI = lllllllllllllIllIIIIlIlllIlllIll[lllllllllllllIllIIIIlIllllIIIIII - 1]; lllllllllllllIllIIIIlIllllIIIIIl < lllllllllllllIllIIIIlIllllIIIIlI; lllllllllllllIllIIIIlIllllIIIIlI = lllllllllllllIllIIIIlIlllIlllIll[--lllllllllllllIllIIIIlIllllIIIIII - 1]) {
                lllllllllllllIllIIIIlIlllIlllIll[lllllllllllllIllIIIIlIllllIIIIII] = lllllllllllllIllIIIIlIllllIIIIlI;
                if (lllllllllllllIllIIIIlIlllIlllIlI == lllllllllllllIllIIIIlIllllIIIIII - 1) {
                    --lllllllllllllIllIIIIlIllllIIIIII;
                    break;
                }
            }
            lllllllllllllIllIIIIlIlllIlllIll[lllllllllllllIllIIIIlIllllIIIIII] = lllllllllllllIllIIIIlIllllIIIIIl;
        }
    }
    
    public static void ensureSameLength(final int[] lllllllllllllIllIIIIllIIlIIllllI, final int[] lllllllllllllIllIIIIllIIlIIllIll) {
        if (lllllllllllllIllIIIIllIIlIIllllI.length != lllllllllllllIllIIIIllIIlIIllIll.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(lllllllllllllIllIIIIllIIlIIllllI.length).append(" != ").append(lllllllllllllIllIIIIllIIlIIllIll.length)));
        }
    }
    
    public static void parallelQuickSort(final int[] lllllllllllllIllIIIIlIllIllllIlI) {
        parallelQuickSort(lllllllllllllIllIIIIlIllIllllIlI, 0, lllllllllllllIllIIIIlIllIllllIlI.length);
    }
    
    public static void stableSort(final int[] lllllllllllllIllIIIIlIIllIlIlIIl, final IntComparator lllllllllllllIllIIIIlIIllIlIIllI) {
        stableSort(lllllllllllllIllIIIIlIIllIlIlIIl, 0, lllllllllllllIllIIIIlIIllIlIlIIl.length, lllllllllllllIllIIIIlIIllIlIIllI);
    }
    
    @Deprecated
    public static void fill(final int[] lllllllllllllIllIIIIllIIllIIIlII, final int lllllllllllllIllIIIIllIIllIIIIll, int lllllllllllllIllIIIIllIIlIlllllI, final int lllllllllllllIllIIIIllIIlIllllIl) {
        ensureFromTo(lllllllllllllIllIIIIllIIllIIIlII, lllllllllllllIllIIIIllIIllIIIIll, lllllllllllllIllIIIIllIIlIlllllI);
        if (lllllllllllllIllIIIIllIIllIIIIll == 0) {
            while (lllllllllllllIllIIIIllIIlIlllllI-- != 0) {
                lllllllllllllIllIIIIllIIllIIIlII[lllllllllllllIllIIIIllIIlIlllllI] = lllllllllllllIllIIIIllIIlIllllIl;
            }
        }
        else {
            for (int lllllllllllllIllIIIIllIIllIIIlIl = lllllllllllllIllIIIIllIIllIIIIll; lllllllllllllIllIIIIllIIllIIIlIl < lllllllllllllIllIIIIllIIlIlllllI; ++lllllllllllllIllIIIIllIIllIIIlIl) {
                lllllllllllllIllIIIIllIIllIIIlII[lllllllllllllIllIIIIllIIllIIIlIl] = lllllllllllllIllIIIIllIIlIllllIl;
            }
        }
    }
    
    private static void selectionSort(final int[] lllllllllllllIllIIIIlIllllIlIIlI, final int lllllllllllllIllIIIIlIllllIIlllI, final int lllllllllllllIllIIIIlIllllIIllIl) {
        for (int lllllllllllllIllIIIIlIllllIlIIll = lllllllllllllIllIIIIlIllllIIlllI; lllllllllllllIllIIIIlIllllIlIIll < lllllllllllllIllIIIIlIllllIIllIl - 1; ++lllllllllllllIllIIIIlIllllIlIIll) {
            int lllllllllllllIllIIIIlIllllIlIlII = lllllllllllllIllIIIIlIllllIlIIll;
            for (int lllllllllllllIllIIIIlIllllIlIllI = lllllllllllllIllIIIIlIllllIlIIll + 1; lllllllllllllIllIIIIlIllllIlIllI < lllllllllllllIllIIIIlIllllIIllIl; ++lllllllllllllIllIIIIlIllllIlIllI) {
                if (lllllllllllllIllIIIIlIllllIlIIlI[lllllllllllllIllIIIIlIllllIlIllI] < lllllllllllllIllIIIIlIllllIlIIlI[lllllllllllllIllIIIIlIllllIlIlII]) {
                    lllllllllllllIllIIIIlIllllIlIlII = lllllllllllllIllIIIIlIllllIlIllI;
                }
            }
            if (lllllllllllllIllIIIIlIllllIlIlII != lllllllllllllIllIIIIlIllllIlIIll) {
                final int lllllllllllllIllIIIIlIllllIlIlIl = lllllllllllllIllIIIIlIllllIlIIlI[lllllllllllllIllIIIIlIllllIlIIll];
                lllllllllllllIllIIIIlIllllIlIIlI[lllllllllllllIllIIIIlIllllIlIIll] = lllllllllllllIllIIIIlIllllIlIIlI[lllllllllllllIllIIIIlIllllIlIlII];
                lllllllllllllIllIIIIlIllllIlIIlI[lllllllllllllIllIIIIlIllllIlIlII] = lllllllllllllIllIIIIlIllllIlIlIl;
            }
        }
    }
    
    public static void radixSort(final int[] lllllllllllllIllIIIIlIIIIIllIIll, final int[] lllllllllllllIllIIIIlIIIIIlIIlIl, final int lllllllllllllIllIIIIlIIIIIlIIlII, final int lllllllllllllIllIIIIlIIIIIlIIIll) {
        if (lllllllllllllIllIIIIlIIIIIlIIIll - lllllllllllllIllIIIIlIIIIIlIIlII < 1024) {
            selectionSort(lllllllllllllIllIIIIlIIIIIllIIll, lllllllllllllIllIIIIlIIIIIlIIlIl, lllllllllllllIllIIIIlIIIIIlIIlII, lllllllllllllIllIIIIlIIIIIlIIIll);
            return;
        }
        final int lllllllllllllIllIIIIlIIIIIlIllll = 2;
        final int lllllllllllllIllIIIIlIIIIIlIlllI = 7;
        final int lllllllllllllIllIIIIlIIIIIlIllIl = 1786;
        int lllllllllllllIllIIIIlIIIIIlIllII = 0;
        final int[] lllllllllllllIllIIIIlIIIIIlIlIll = new int[1786];
        final int[] lllllllllllllIllIIIIlIIIIIlIlIlI = new int[1786];
        final int[] lllllllllllllIllIIIIlIIIIIlIlIIl = new int[1786];
        lllllllllllllIllIIIIlIIIIIlIlIlI[lllllllllllllIllIIIIlIIIIIlIllII] = lllllllllllllIllIIIIlIIIIIlIIIll - (lllllllllllllIllIIIIlIIIIIlIlIll[lllllllllllllIllIIIIlIIIIIlIllII] = lllllllllllllIllIIIIlIIIIIlIIlII);
        lllllllllllllIllIIIIlIIIIIlIlIIl[lllllllllllllIllIIIIlIIIIIlIllII++] = 0;
        final int[] lllllllllllllIllIIIIlIIIIIlIlIII = new int[256];
        final int[] lllllllllllllIllIIIIlIIIIIlIIlll = new int[256];
        while (lllllllllllllIllIIIIlIIIIIlIllII > 0) {
            final int lllllllllllllIllIIIIlIIIIIlllIll = lllllllllllllIllIIIIlIIIIIlIlIll[--lllllllllllllIllIIIIlIIIIIlIllII];
            final int lllllllllllllIllIIIIlIIIIIlllIlI = lllllllllllllIllIIIIlIIIIIlIlIlI[lllllllllllllIllIIIIlIIIIIlIllII];
            final int lllllllllllllIllIIIIlIIIIIlllIIl = lllllllllllllIllIIIIlIIIIIlIlIIl[lllllllllllllIllIIIIlIIIIIlIllII];
            final int lllllllllllllIllIIIIlIIIIIlllIII = (lllllllllllllIllIIIIlIIIIIlllIIl % 4 == 0) ? 128 : 0;
            final int[] lllllllllllllIllIIIIlIIIIIllIlll = (lllllllllllllIllIIIIlIIIIIlllIIl < 4) ? lllllllllllllIllIIIIlIIIIIllIIll : lllllllllllllIllIIIIlIIIIIlIIlIl;
            final int lllllllllllllIllIIIIlIIIIIllIllI = (3 - lllllllllllllIllIIIIlIIIIIlllIIl % 4) * 8;
            int lllllllllllllIllIIIIlIIIIlIIIlII = lllllllllllllIllIIIIlIIIIIlllIll + lllllllllllllIllIIIIlIIIIIlllIlI;
            while (lllllllllllllIllIIIIlIIIIlIIIlII-- != lllllllllllllIllIIIIlIIIIIlllIll) {
                final int[] array = lllllllllllllIllIIIIlIIIIIlIlIII;
                final int n = (lllllllllllllIllIIIIlIIIIIllIlll[lllllllllllllIllIIIIlIIIIlIIIlII] >>> lllllllllllllIllIIIIlIIIIIllIllI & 0xFF) ^ lllllllllllllIllIIIIlIIIIIlllIII;
                ++array[n];
            }
            int lllllllllllllIllIIIIlIIIIIllIlIl = -1;
            int lllllllllllllIllIIIIlIIIIlIIIIll = 0;
            int lllllllllllllIllIIIIlIIIIlIIIIlI = lllllllllllllIllIIIIlIIIIIlllIll;
            while (lllllllllllllIllIIIIlIIIIlIIIIll < 256) {
                if (lllllllllllllIllIIIIlIIIIIlIlIII[lllllllllllllIllIIIIlIIIIlIIIIll] != 0) {
                    lllllllllllllIllIIIIlIIIIIllIlIl = lllllllllllllIllIIIIlIIIIlIIIIll;
                }
                lllllllllllllIllIIIIlIIIIlIIIIlI = (lllllllllllllIllIIIIlIIIIIlIIlll[lllllllllllllIllIIIIlIIIIlIIIIll] = lllllllllllllIllIIIIlIIIIlIIIIlI + lllllllllllllIllIIIIlIIIIIlIlIII[lllllllllllllIllIIIIlIIIIlIIIIll]);
                ++lllllllllllllIllIIIIlIIIIlIIIIll;
            }
            for (int lllllllllllllIllIIIIlIIIIIllIlII = lllllllllllllIllIIIIlIIIIIlllIll + lllllllllllllIllIIIIlIIIIIlllIlI - lllllllllllllIllIIIIlIIIIIlIlIII[lllllllllllllIllIIIIlIIIIIllIlIl], lllllllllllllIllIIIIlIIIIIllllIl = lllllllllllllIllIIIIlIIIIIlllIll, lllllllllllllIllIIIIlIIIIIllllII = -1; lllllllllllllIllIIIIlIIIIIllllIl <= lllllllllllllIllIIIIlIIIIIllIlII; lllllllllllllIllIIIIlIIIIIllllIl += lllllllllllllIllIIIIlIIIIIlIlIII[lllllllllllllIllIIIIlIIIIIllllII], lllllllllllllIllIIIIlIIIIIlIlIII[lllllllllllllIllIIIIlIIIIIllllII] = 0) {
                int lllllllllllllIllIIIIlIIIIIllllll = lllllllllllllIllIIIIlIIIIIllIIll[lllllllllllllIllIIIIlIIIIIllllIl];
                int lllllllllllllIllIIIIlIIIIIlllllI = lllllllllllllIllIIIIlIIIIIlIIlIl[lllllllllllllIllIIIIlIIIIIllllIl];
                lllllllllllllIllIIIIlIIIIIllllII = ((lllllllllllllIllIIIIlIIIIIllIlll[lllllllllllllIllIIIIlIIIIIllllIl] >>> lllllllllllllIllIIIIlIIIIIllIllI & 0xFF) ^ lllllllllllllIllIIIIlIIIIIlllIII);
                if (lllllllllllllIllIIIIlIIIIIllllIl < lllllllllllllIllIIIIlIIIIIllIlII) {
                    while (true) {
                        final int[] array2 = lllllllllllllIllIIIIlIIIIIlIIlll;
                        final int n2 = lllllllllllllIllIIIIlIIIIIllllII;
                        final int n3 = array2[n2] - 1;
                        array2[n2] = n3;
                        final int lllllllllllllIllIIIIlIIIIlIIIIII;
                        if ((lllllllllllllIllIIIIlIIIIlIIIIII = n3) <= lllllllllllllIllIIIIlIIIIIllllIl) {
                            break;
                        }
                        lllllllllllllIllIIIIlIIIIIllllII = ((lllllllllllllIllIIIIlIIIIIllIlll[lllllllllllllIllIIIIlIIIIlIIIIII] >>> lllllllllllllIllIIIIlIIIIIllIllI & 0xFF) ^ lllllllllllllIllIIIIlIIIIIlllIII);
                        int lllllllllllllIllIIIIlIIIIlIIIIIl = lllllllllllllIllIIIIlIIIIIllllll;
                        lllllllllllllIllIIIIlIIIIIllllll = lllllllllllllIllIIIIlIIIIIllIIll[lllllllllllllIllIIIIlIIIIlIIIIII];
                        lllllllllllllIllIIIIlIIIIIllIIll[lllllllllllllIllIIIIlIIIIlIIIIII] = lllllllllllllIllIIIIlIIIIlIIIIIl;
                        lllllllllllllIllIIIIlIIIIlIIIIIl = lllllllllllllIllIIIIlIIIIIlllllI;
                        lllllllllllllIllIIIIlIIIIIlllllI = lllllllllllllIllIIIIlIIIIIlIIlIl[lllllllllllllIllIIIIlIIIIlIIIIII];
                        lllllllllllllIllIIIIlIIIIIlIIlIl[lllllllllllllIllIIIIlIIIIlIIIIII] = lllllllllllllIllIIIIlIIIIlIIIIIl;
                    }
                    lllllllllllllIllIIIIlIIIIIllIIll[lllllllllllllIllIIIIlIIIIIllllIl] = lllllllllllllIllIIIIlIIIIIllllll;
                    lllllllllllllIllIIIIlIIIIIlIIlIl[lllllllllllllIllIIIIlIIIIIllllIl] = lllllllllllllIllIIIIlIIIIIlllllI;
                }
                if (lllllllllllllIllIIIIlIIIIIlllIIl < 7 && lllllllllllllIllIIIIlIIIIIlIlIII[lllllllllllllIllIIIIlIIIIIllllII] > 1) {
                    if (lllllllllllllIllIIIIlIIIIIlIlIII[lllllllllllllIllIIIIlIIIIIllllII] < 1024) {
                        selectionSort(lllllllllllllIllIIIIlIIIIIllIIll, lllllllllllllIllIIIIlIIIIIlIIlIl, lllllllllllllIllIIIIlIIIIIllllIl, lllllllllllllIllIIIIlIIIIIllllIl + lllllllllllllIllIIIIlIIIIIlIlIII[lllllllllllllIllIIIIlIIIIIllllII]);
                    }
                    else {
                        lllllllllllllIllIIIIlIIIIIlIlIll[lllllllllllllIllIIIIlIIIIIlIllII] = lllllllllllllIllIIIIlIIIIIllllIl;
                        lllllllllllllIllIIIIlIIIIIlIlIlI[lllllllllllllIllIIIIlIIIIIlIllII] = lllllllllllllIllIIIIlIIIIIlIlIII[lllllllllllllIllIIIIlIIIIIllllII];
                        lllllllllllllIllIIIIlIIIIIlIlIIl[lllllllllllllIllIIIIlIIIIIlIllII++] = lllllllllllllIllIIIIlIIIIIlllIIl + 1;
                    }
                }
            }
        }
    }
    
    private static int med3(final int[] lllllllllllllIllIIIIlIlIllIIllIl, final int[] lllllllllllllIllIIIIlIlIllIlIlIl, final int lllllllllllllIllIIIIlIlIllIlIlII, final int lllllllllllllIllIIIIlIlIllIIlIlI, final int lllllllllllllIllIIIIlIlIllIIlIIl) {
        int lllllllllllllIllIIIIlIlIllIlIIIl;
        final int lllllllllllllIllIIIIlIlIllIlIIII = ((lllllllllllllIllIIIIlIlIllIlIIIl = Integer.compare(lllllllllllllIllIIIIlIlIllIIllIl[lllllllllllllIllIIIIlIlIllIlIlII], lllllllllllllIllIIIIlIlIllIIllIl[lllllllllllllIllIIIIlIlIllIIlIlI])) == 0) ? Integer.compare(lllllllllllllIllIIIIlIlIllIlIlIl[lllllllllllllIllIIIIlIlIllIlIlII], lllllllllllllIllIIIIlIlIllIlIlIl[lllllllllllllIllIIIIlIlIllIIlIlI]) : lllllllllllllIllIIIIlIlIllIlIIIl;
        final int lllllllllllllIllIIIIlIlIllIIllll = ((lllllllllllllIllIIIIlIlIllIlIIIl = Integer.compare(lllllllllllllIllIIIIlIlIllIIllIl[lllllllllllllIllIIIIlIlIllIlIlII], lllllllllllllIllIIIIlIlIllIIllIl[lllllllllllllIllIIIIlIlIllIIlIIl])) == 0) ? Integer.compare(lllllllllllllIllIIIIlIlIllIlIlIl[lllllllllllllIllIIIIlIlIllIlIlII], lllllllllllllIllIIIIlIlIllIlIlIl[lllllllllllllIllIIIIlIlIllIIlIIl]) : lllllllllllllIllIIIIlIlIllIlIIIl;
        final int lllllllllllllIllIIIIlIlIllIIlllI = ((lllllllllllllIllIIIIlIlIllIlIIIl = Integer.compare(lllllllllllllIllIIIIlIlIllIIllIl[lllllllllllllIllIIIIlIlIllIIlIlI], lllllllllllllIllIIIIlIlIllIIllIl[lllllllllllllIllIIIIlIlIllIIlIIl])) == 0) ? Integer.compare(lllllllllllllIllIIIIlIlIllIlIlIl[lllllllllllllIllIIIIlIlIllIIlIlI], lllllllllllllIllIIIIlIlIllIlIlIl[lllllllllllllIllIIIIlIlIllIIlIIl]) : lllllllllllllIllIIIIlIlIllIlIIIl;
        return (lllllllllllllIllIIIIlIlIllIlIIII < 0) ? ((lllllllllllllIllIIIIlIlIllIIlllI < 0) ? lllllllllllllIllIIIIlIlIllIIlIlI : ((lllllllllllllIllIIIIlIlIllIIllll < 0) ? lllllllllllllIllIIIIlIlIllIIlIIl : lllllllllllllIllIIIIlIlIllIlIlII)) : ((lllllllllllllIllIIIIlIlIllIIlllI > 0) ? lllllllllllllIllIIIIlIlIllIIlIlI : ((lllllllllllllIllIIIIlIlIllIIllll > 0) ? lllllllllllllIllIIIIlIlIllIIlIIl : lllllllllllllIllIIIIlIlIllIlIlII));
    }
    
    public static int[] copy(final int[] lllllllllllllIllIIIIllIIllIlIlIl) {
        return lllllllllllllIllIIIIllIIllIlIlIl.clone();
    }
    
    public static void radixSortIndirect(final int[] lllllllllllllIllIIIIlIIIllllIllI, final int[] lllllllllllllIllIIIIlIIIllllIlIl, final boolean lllllllllllllIllIIIIlIIIllllIlII) {
        radixSortIndirect(lllllllllllllIllIIIIlIIIllllIllI, lllllllllllllIllIIIIlIIIllllIlIl, 0, lllllllllllllIllIIIIlIIIllllIllI.length, lllllllllllllIllIIIIlIIIllllIlII);
    }
    
    public static void mergeSort(final int[] lllllllllllllIllIIIIlIIlllIlllll, final int lllllllllllllIllIIIIlIIllllIIlIl, final int lllllllllllllIllIIIIlIIllllIIlII, final IntComparator lllllllllllllIllIIIIlIIllllIIIll, final int[] lllllllllllllIllIIIIlIIllllIIIlI) {
        final int lllllllllllllIllIIIIlIIllllIIIIl = lllllllllllllIllIIIIlIIllllIIlII - lllllllllllllIllIIIIlIIllllIIlIl;
        if (lllllllllllllIllIIIIlIIllllIIIIl < 16) {
            insertionSort(lllllllllllllIllIIIIlIIlllIlllll, lllllllllllllIllIIIIlIIllllIIlIl, lllllllllllllIllIIIIlIIllllIIlII, lllllllllllllIllIIIIlIIllllIIIll);
            return;
        }
        final int lllllllllllllIllIIIIlIIllllIIIII = lllllllllllllIllIIIIlIIllllIIlIl + lllllllllllllIllIIIIlIIllllIIlII >>> 1;
        mergeSort(lllllllllllllIllIIIIlIIllllIIIlI, lllllllllllllIllIIIIlIIllllIIlIl, lllllllllllllIllIIIIlIIllllIIIII, lllllllllllllIllIIIIlIIllllIIIll, lllllllllllllIllIIIIlIIlllIlllll);
        mergeSort(lllllllllllllIllIIIIlIIllllIIIlI, lllllllllllllIllIIIIlIIllllIIIII, lllllllllllllIllIIIIlIIllllIIlII, lllllllllllllIllIIIIlIIllllIIIll, lllllllllllllIllIIIIlIIlllIlllll);
        if (lllllllllllllIllIIIIlIIllllIIIll.compare(lllllllllllllIllIIIIlIIllllIIIlI[lllllllllllllIllIIIIlIIllllIIIII - 1], lllllllllllllIllIIIIlIIllllIIIlI[lllllllllllllIllIIIIlIIllllIIIII]) <= 0) {
            System.arraycopy(lllllllllllllIllIIIIlIIllllIIIlI, lllllllllllllIllIIIIlIIllllIIlIl, lllllllllllllIllIIIIlIIlllIlllll, lllllllllllllIllIIIIlIIllllIIlIl, lllllllllllllIllIIIIlIIllllIIIIl);
            return;
        }
        int lllllllllllllIllIIIIlIIllllIlIIl = lllllllllllllIllIIIIlIIllllIIlIl;
        int lllllllllllllIllIIIIlIIllllIlIII = lllllllllllllIllIIIIlIIllllIIlIl;
        int lllllllllllllIllIIIIlIIllllIIlll = lllllllllllllIllIIIIlIIllllIIIII;
        while (lllllllllllllIllIIIIlIIllllIlIIl < lllllllllllllIllIIIIlIIllllIIlII) {
            if (lllllllllllllIllIIIIlIIllllIIlll >= lllllllllllllIllIIIIlIIllllIIlII || (lllllllllllllIllIIIIlIIllllIlIII < lllllllllllllIllIIIIlIIllllIIIII && lllllllllllllIllIIIIlIIllllIIIll.compare(lllllllllllllIllIIIIlIIllllIIIlI[lllllllllllllIllIIIIlIIllllIlIII], lllllllllllllIllIIIIlIIllllIIIlI[lllllllllllllIllIIIIlIIllllIIlll]) <= 0)) {
                lllllllllllllIllIIIIlIIlllIlllll[lllllllllllllIllIIIIlIIllllIlIIl] = lllllllllllllIllIIIIlIIllllIIIlI[lllllllllllllIllIIIIlIIllllIlIII++];
            }
            else {
                lllllllllllllIllIIIIlIIlllIlllll[lllllllllllllIllIIIIlIIllllIlIIl] = lllllllllllllIllIIIIlIIllllIIIlI[lllllllllllllIllIIIIlIIllllIIlll++];
            }
            ++lllllllllllllIllIIIIlIIllllIlIIl;
        }
    }
    
    public static void parallelRadixSortIndirect(final int[] lllllllllllllIllIIIIlIIIIlllllIl, final int[] lllllllllllllIllIIIIlIIIlIIIlIIl, final int lllllllllllllIllIIIIlIIIlIIIlIII, final int lllllllllllllIllIIIIlIIIlIIIIlll, final boolean lllllllllllllIllIIIIlIIIlIIIIllI) {
        if (lllllllllllllIllIIIIlIIIlIIIIlll - lllllllllllllIllIIIIlIIIlIIIlIII < 1024) {
            radixSortIndirect(lllllllllllllIllIIIIlIIIIlllllIl, lllllllllllllIllIIIIlIIIlIIIlIIl, lllllllllllllIllIIIIlIIIlIIIlIII, lllllllllllllIllIIIIlIIIlIIIIlll, lllllllllllllIllIIIIlIIIlIIIIllI);
            return;
        }
        final int lllllllllllllIllIIIIlIIIlIIIIlIl = 3;
        final LinkedBlockingQueue<Segment> lllllllllllllIllIIIIlIIIlIIIIlII = new LinkedBlockingQueue<Segment>();
        lllllllllllllIllIIIIlIIIlIIIIlII.add(new Segment(lllllllllllllIllIIIIlIIIlIIIlIII, lllllllllllllIllIIIIlIIIlIIIIlll - lllllllllllllIllIIIIlIIIlIIIlIII, 0));
        final AtomicInteger lllllllllllllIllIIIIlIIIlIIIIIll = new AtomicInteger(1);
        final int lllllllllllllIllIIIIlIIIlIIIIIlI = Runtime.getRuntime().availableProcessors();
        final ExecutorService lllllllllllllIllIIIIlIIIlIIIIIIl = Executors.newFixedThreadPool(lllllllllllllIllIIIIlIIIlIIIIIlI, Executors.defaultThreadFactory());
        final ExecutorCompletionService<Void> lllllllllllllIllIIIIlIIIlIIIIIII = new ExecutorCompletionService<Void>(lllllllllllllIllIIIIlIIIlIIIIIIl);
        final int[] lllllllllllllIllIIIIlIIIIlllllll = (int[])(lllllllllllllIllIIIIlIIIlIIIIllI ? new int[lllllllllllllIllIIIIlIIIIlllllIl.length] : null);
        int lllllllllllllIllIIIIlIIIlIIIllIl = lllllllllllllIllIIIIlIIIlIIIIIlI;
        while (lllllllllllllIllIIIIlIIIlIIIllIl-- != 0) {
            final int[] lllllllllllllIllIIIIIllIIIlIIIlI;
            final int[] lllllllllllllIllIIIIIllIIIlIIIIl;
            final AtomicInteger atomicInteger;
            final int n;
            int lllllllllllllIllIIIIIllIIIllllIl;
            final Object o;
            final LinkedBlockingQueue<Segment> linkedBlockingQueue;
            Segment lllllllllllllIllIIIIIllIIIllIIII;
            int lllllllllllllIllIIIIIllIIIlIllll;
            int lllllllllllllIllIIIIIllIIIlIlllI;
            int lllllllllllllIllIIIIIllIIIlIllIl;
            int lllllllllllllIllIIIIIllIIIlIllII;
            int lllllllllllllIllIIIIIllIIIlIlIll;
            int lllllllllllllIllIIIIIllIIIllllII;
            final Object o2;
            int n2;
            final Object o3;
            int lllllllllllllIllIIIIIllIIIlIlIlI;
            int lllllllllllllIllIIIIIllIIIlllIll;
            int lllllllllllllIllIIIIIllIIIlllIlI;
            final Object o4;
            final int n3;
            int lllllllllllllIllIIIIIllIIIlllIIl;
            final Object o5;
            int n4;
            final Object o6;
            int n5;
            final Object o7;
            int lllllllllllllIllIIIIIllIIIlllIII;
            int lllllllllllllIllIIIIIllIIIllIlll;
            int lllllllllllllIllIIIIIllIIIllIIIl;
            int lllllllllllllIllIIIIIllIIIllIIll;
            int lllllllllllllIllIIIIIllIIIllIIlI;
            int lllllllllllllIllIIIIIllIIIllIlII;
            int lllllllllllllIllIIIIIllIIIllIIlI2;
            final Object o8;
            final int n7;
            int n6;
            int lllllllllllllIllIIIIIllIIIllIlIl;
            int lllllllllllllIllIIIIIllIIIllIllI;
            lllllllllllllIllIIIIlIIIlIIIIIII.submit(() -> {
                lllllllllllllIllIIIIIllIIIlIIIlI = new int[256];
                lllllllllllllIllIIIIIllIIIlIIIIl = new int[256];
                while (true) {
                    if (atomicInteger.get() == 0) {
                        lllllllllllllIllIIIIIllIIIllllIl = n;
                        while (true) {
                            lllllllllllllIllIIIIIllIIIllllIl--;
                            if (o != 0) {
                                linkedBlockingQueue.add(IntArrays.POISON_PILL);
                            }
                            else {
                                break;
                            }
                        }
                    }
                    lllllllllllllIllIIIIIllIIIllIIII = linkedBlockingQueue.take();
                    if (lllllllllllllIllIIIIIllIIIllIIII == IntArrays.POISON_PILL) {
                        break;
                    }
                    else {
                        lllllllllllllIllIIIIIllIIIlIllll = lllllllllllllIllIIIIIllIIIllIIII.offset;
                        lllllllllllllIllIIIIIllIIIlIlllI = lllllllllllllIllIIIIIllIIIllIIII.length;
                        lllllllllllllIllIIIIIllIIIlIllIl = lllllllllllllIllIIIIIllIIIllIIII.level;
                        lllllllllllllIllIIIIIllIIIlIllII = ((lllllllllllllIllIIIIIllIIIlIllIl % 4 == 0) ? 128 : 0);
                        lllllllllllllIllIIIIIllIIIlIlIll = (3 - lllllllllllllIllIIIIIllIIIlIllIl % 4) * 8;
                        lllllllllllllIllIIIIIllIIIllllII = lllllllllllllIllIIIIIllIIIlIllll + lllllllllllllIllIIIIIllIIIlIlllI;
                        while (true) {
                            lllllllllllllIllIIIIIllIIIllllII--;
                            if (o2 != lllllllllllllIllIIIIIllIIIlIllll) {
                                n2 = ((lllllllllllllIllIIIIlIIIlIIIlIIl[lllllllllllllIllIIIIlIIIIlllllIl[lllllllllllllIllIIIIIllIIIllllII]] >>> lllllllllllllIllIIIIIllIIIlIlIll & 0xFF) ^ lllllllllllllIllIIIIIllIIIlIllII);
                                ++o3[n2];
                            }
                            else {
                                break;
                            }
                        }
                        lllllllllllllIllIIIIIllIIIlIlIlI = -1;
                        lllllllllllllIllIIIIIllIIIlllIll = 0;
                        lllllllllllllIllIIIIIllIIIlllIlI = lllllllllllllIllIIIIIllIIIlIllll;
                        while (lllllllllllllIllIIIIIllIIIlllIll < 256) {
                            if (lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIlllIll] != 0) {
                                lllllllllllllIllIIIIIllIIIlIlIlI = lllllllllllllIllIIIIIllIIIlllIll;
                            }
                            lllllllllllllIllIIIIIllIIIlllIlI = (o4[n3] = lllllllllllllIllIIIIIllIIIlllIlI + lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIlllIll]);
                            ++lllllllllllllIllIIIIIllIIIlllIll;
                        }
                        if (lllllllllllllIllIIIIlIIIlIIIIllI) {
                            lllllllllllllIllIIIIIllIIIlllIIl = lllllllllllllIllIIIIIllIIIlIllll + lllllllllllllIllIIIIIllIIIlIlllI;
                            while (true) {
                                lllllllllllllIllIIIIIllIIIlllIIl--;
                                if (o5 != lllllllllllllIllIIIIIllIIIlIllll) {
                                    n4 = ((lllllllllllllIllIIIIlIIIlIIIlIIl[lllllllllllllIllIIIIlIIIIlllllIl[lllllllllllllIllIIIIIllIIIlllIIl]] >>> lllllllllllllIllIIIIIllIIIlIlIll & 0xFF) ^ lllllllllllllIllIIIIIllIIIlIllII);
                                    n5 = o6[n4] - 1;
                                    o7[o6[n4] = n5] = lllllllllllllIllIIIIlIIIIlllllIl[lllllllllllllIllIIIIIllIIIlllIIl];
                                }
                                else {
                                    break;
                                }
                            }
                            System.arraycopy(o7, lllllllllllllIllIIIIIllIIIlIllll, lllllllllllllIllIIIIlIIIIlllllIl, lllllllllllllIllIIIIIllIIIlIllll, lllllllllllllIllIIIIIllIIIlIlllI);
                            lllllllllllllIllIIIIIllIIIlllIII = 0;
                            lllllllllllllIllIIIIIllIIIllIlll = lllllllllllllIllIIIIIllIIIlIllll;
                            while (lllllllllllllIllIIIIIllIIIlllIII <= lllllllllllllIllIIIIIllIIIlIlIlI) {
                                if (lllllllllllllIllIIIIIllIIIlIllIl < 3 && lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIlllIII] > 1) {
                                    if (lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIlllIII] < 1024) {
                                        radixSortIndirect(lllllllllllllIllIIIIlIIIIlllllIl, lllllllllllllIllIIIIlIIIlIIIlIIl, lllllllllllllIllIIIIIllIIIllIlll, lllllllllllllIllIIIIIllIIIllIlll + lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIlllIII], lllllllllllllIllIIIIlIIIlIIIIllI);
                                    }
                                    else {
                                        atomicInteger.incrementAndGet();
                                        linkedBlockingQueue.add(new Segment(lllllllllllllIllIIIIIllIIIllIlll, lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIlllIII], lllllllllllllIllIIIIIllIIIlIllIl + 1));
                                    }
                                }
                                lllllllllllllIllIIIIIllIIIllIlll += lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIlllIII];
                                ++lllllllllllllIllIIIIIllIIIlllIII;
                            }
                            Arrays.fill(lllllllllllllIllIIIIIllIIIlIIIlI, 0);
                        }
                        else {
                            for (lllllllllllllIllIIIIIllIIIllIIIl = lllllllllllllIllIIIIIllIIIlIllll + lllllllllllllIllIIIIIllIIIlIlllI - lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIlIlIlI], lllllllllllllIllIIIIIllIIIllIIll = lllllllllllllIllIIIIIllIIIlIllll, lllllllllllllIllIIIIIllIIIllIIlI = -1; lllllllllllllIllIIIIIllIIIllIIll <= lllllllllllllIllIIIIIllIIIllIIIl; lllllllllllllIllIIIIIllIIIllIIll += lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIllIIlI2], lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIllIIlI2] = 0) {
                                lllllllllllllIllIIIIIllIIIllIlII = lllllllllllllIllIIIIlIIIIlllllIl[lllllllllllllIllIIIIIllIIIllIIll];
                                lllllllllllllIllIIIIIllIIIllIIlI2 = ((lllllllllllllIllIIIIlIIIlIIIlIIl[lllllllllllllIllIIIIIllIIIllIlII] >>> lllllllllllllIllIIIIIllIIIlIlIll & 0xFF) ^ lllllllllllllIllIIIIIllIIIlIllII);
                                if (lllllllllllllIllIIIIIllIIIllIIll < lllllllllllllIllIIIIIllIIIllIIIl) {
                                    while (true) {
                                        n6 = o8[n7] - 1;
                                        o8[n7] = n6;
                                        if ((lllllllllllllIllIIIIIllIIIllIlIl = n6) > lllllllllllllIllIIIIIllIIIllIIll) {
                                            lllllllllllllIllIIIIIllIIIllIllI = lllllllllllllIllIIIIIllIIIllIlII;
                                            lllllllllllllIllIIIIIllIIIllIlII = lllllllllllllIllIIIIlIIIIlllllIl[lllllllllllllIllIIIIIllIIIllIlIl];
                                            lllllllllllllIllIIIIlIIIIlllllIl[lllllllllllllIllIIIIIllIIIllIlIl] = lllllllllllllIllIIIIIllIIIllIllI;
                                            lllllllllllllIllIIIIIllIIIllIIlI2 = ((lllllllllllllIllIIIIlIIIlIIIlIIl[lllllllllllllIllIIIIIllIIIllIlII] >>> lllllllllllllIllIIIIIllIIIlIlIll & 0xFF) ^ lllllllllllllIllIIIIIllIIIlIllII);
                                        }
                                        else {
                                            break;
                                        }
                                    }
                                    lllllllllllllIllIIIIlIIIIlllllIl[lllllllllllllIllIIIIIllIIIllIIll] = lllllllllllllIllIIIIIllIIIllIlII;
                                }
                                if (lllllllllllllIllIIIIIllIIIlIllIl < 3 && lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIllIIlI2] > 1) {
                                    if (lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIllIIlI2] < 1024) {
                                        radixSortIndirect(lllllllllllllIllIIIIlIIIIlllllIl, lllllllllllllIllIIIIlIIIlIIIlIIl, lllllllllllllIllIIIIIllIIIllIIll, lllllllllllllIllIIIIIllIIIllIIll + lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIllIIlI2], lllllllllllllIllIIIIlIIIlIIIIllI);
                                    }
                                    else {
                                        atomicInteger.incrementAndGet();
                                        linkedBlockingQueue.add(new Segment(lllllllllllllIllIIIIIllIIIllIIll, lllllllllllllIllIIIIIllIIIlIIIlI[lllllllllllllIllIIIIIllIIIllIIlI2], lllllllllllllIllIIIIIllIIIlIllIl + 1));
                                    }
                                }
                            }
                        }
                        atomicInteger.decrementAndGet();
                    }
                }
                return null;
            });
        }
        Throwable lllllllllllllIllIIIIlIIIIllllllI = null;
        int lllllllllllllIllIIIIlIIIlIIIlIll = lllllllllllllIllIIIIlIIIlIIIIIlI;
        while (lllllllllllllIllIIIIlIIIlIIIlIll-- != 0) {
            try {
                lllllllllllllIllIIIIlIIIlIIIIIII.take().get();
            }
            catch (Exception lllllllllllllIllIIIIlIIIlIIIllII) {
                lllllllllllllIllIIIIlIIIIllllllI = lllllllllllllIllIIIIlIIIlIIIllII.getCause();
            }
        }
        lllllllllllllIllIIIIlIIIlIIIIIIl.shutdown();
        if (lllllllllllllIllIIIIlIIIIllllllI != null) {
            throw (lllllllllllllIllIIIIlIIIIllllllI instanceof RuntimeException) ? lllllllllllllIllIIIIlIIIIllllllI : new RuntimeException(lllllllllllllIllIIIIlIIIIllllllI);
        }
    }
    
    public static void radixSort(final int[][] lllllllllllllIllIIIIIllIlllllIII, final int lllllllllllllIllIIIIIllIllllIlll, final int lllllllllllllIllIIIIIlllIIIIIIll) {
        if (lllllllllllllIllIIIIIlllIIIIIIll - lllllllllllllIllIIIIIllIllllIlll < 1024) {
            selectionSort(lllllllllllllIllIIIIIllIlllllIII, lllllllllllllIllIIIIIllIllllIlll, lllllllllllllIllIIIIIlllIIIIIIll, 0);
            return;
        }
        final int lllllllllllllIllIIIIIlllIIIIIIlI = lllllllllllllIllIIIIIllIlllllIII.length;
        final int lllllllllllllIllIIIIIlllIIIIIIIl = 4 * lllllllllllllIllIIIIIlllIIIIIIlI - 1;
        int lllllllllllllIllIIIIIlllIIIllIIl = lllllllllllllIllIIIIIlllIIIIIIlI;
        final int lllllllllllllIllIIIIIlllIIIllIII = lllllllllllllIllIIIIIllIlllllIII[0].length;
        while (lllllllllllllIllIIIIIlllIIIllIIl-- != 0) {
            if (lllllllllllllIllIIIIIllIlllllIII[lllllllllllllIllIIIIIlllIIIllIIl].length != lllllllllllllIllIIIIIlllIIIllIII) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The array of index ").append(lllllllllllllIllIIIIIlllIIIllIIl).append(" has not the same length of the array of index 0.")));
            }
        }
        final int lllllllllllllIllIIIIIlllIIIIIIII = 255 * (lllllllllllllIllIIIIIlllIIIIIIlI * 4 - 1) + 1;
        int lllllllllllllIllIIIIIllIllllllll = 0;
        final int[] lllllllllllllIllIIIIIllIlllllllI = new int[lllllllllllllIllIIIIIlllIIIIIIII];
        final int[] lllllllllllllIllIIIIIllIllllllIl = new int[lllllllllllllIllIIIIIlllIIIIIIII];
        final int[] lllllllllllllIllIIIIIllIllllllII = new int[lllllllllllllIllIIIIIlllIIIIIIII];
        lllllllllllllIllIIIIIllIllllllIl[lllllllllllllIllIIIIIllIllllllll] = lllllllllllllIllIIIIIlllIIIIIIll - (lllllllllllllIllIIIIIllIlllllllI[lllllllllllllIllIIIIIllIllllllll] = lllllllllllllIllIIIIIllIllllIlll);
        lllllllllllllIllIIIIIllIllllllII[lllllllllllllIllIIIIIllIllllllll++] = 0;
        final int[] lllllllllllllIllIIIIIllIlllllIll = new int[256];
        final int[] lllllllllllllIllIIIIIllIlllllIlI = new int[256];
        final int[] lllllllllllllIllIIIIIllIlllllIIl = new int[lllllllllllllIllIIIIIlllIIIIIIlI];
        while (lllllllllllllIllIIIIIllIllllllll > 0) {
            final int lllllllllllllIllIIIIIlllIIIIllIl = lllllllllllllIllIIIIIllIlllllllI[--lllllllllllllIllIIIIIllIllllllll];
            final int lllllllllllllIllIIIIIlllIIIIllII = lllllllllllllIllIIIIIllIllllllIl[lllllllllllllIllIIIIIllIllllllll];
            final int lllllllllllllIllIIIIIlllIIIIlIll = lllllllllllllIllIIIIIllIllllllII[lllllllllllllIllIIIIIllIllllllll];
            final int lllllllllllllIllIIIIIlllIIIIlIlI = (lllllllllllllIllIIIIIlllIIIIlIll % 4 == 0) ? 128 : 0;
            final int[] lllllllllllllIllIIIIIlllIIIIlIIl = lllllllllllllIllIIIIIllIlllllIII[lllllllllllllIllIIIIIlllIIIIlIll / 4];
            final int lllllllllllllIllIIIIIlllIIIIlIII = (3 - lllllllllllllIllIIIIIlllIIIIlIll % 4) * 8;
            int lllllllllllllIllIIIIIlllIIIlIlll = lllllllllllllIllIIIIIlllIIIIllIl + lllllllllllllIllIIIIIlllIIIIllII;
            while (lllllllllllllIllIIIIIlllIIIlIlll-- != lllllllllllllIllIIIIIlllIIIIllIl) {
                final int[] array = lllllllllllllIllIIIIIllIlllllIll;
                final int n = (lllllllllllllIllIIIIIlllIIIIlIIl[lllllllllllllIllIIIIIlllIIIlIlll] >>> lllllllllllllIllIIIIIlllIIIIlIII & 0xFF) ^ lllllllllllllIllIIIIIlllIIIIlIlI;
                ++array[n];
            }
            int lllllllllllllIllIIIIIlllIIIIIlll = -1;
            int lllllllllllllIllIIIIIlllIIIlIllI = 0;
            int lllllllllllllIllIIIIIlllIIIlIlIl = lllllllllllllIllIIIIIlllIIIIllIl;
            while (lllllllllllllIllIIIIIlllIIIlIllI < 256) {
                if (lllllllllllllIllIIIIIllIlllllIll[lllllllllllllIllIIIIIlllIIIlIllI] != 0) {
                    lllllllllllllIllIIIIIlllIIIIIlll = lllllllllllllIllIIIIIlllIIIlIllI;
                }
                lllllllllllllIllIIIIIlllIIIlIlIl = (lllllllllllllIllIIIIIllIlllllIlI[lllllllllllllIllIIIIIlllIIIlIllI] = lllllllllllllIllIIIIIlllIIIlIlIl + lllllllllllllIllIIIIIllIlllllIll[lllllllllllllIllIIIIIlllIIIlIllI]);
                ++lllllllllllllIllIIIIIlllIIIlIllI;
            }
            for (int lllllllllllllIllIIIIIlllIIIIIllI = lllllllllllllIllIIIIIlllIIIIllIl + lllllllllllllIllIIIIIlllIIIIllII - lllllllllllllIllIIIIIllIlllllIll[lllllllllllllIllIIIIIlllIIIIIlll], lllllllllllllIllIIIIIlllIIIIllll = lllllllllllllIllIIIIIlllIIIIllIl, lllllllllllllIllIIIIIlllIIIIlllI = -1; lllllllllllllIllIIIIIlllIIIIllll <= lllllllllllllIllIIIIIlllIIIIIllI; lllllllllllllIllIIIIIlllIIIIllll += lllllllllllllIllIIIIIllIlllllIll[lllllllllllllIllIIIIIlllIIIIlllI], lllllllllllllIllIIIIIllIlllllIll[lllllllllllllIllIIIIIlllIIIIlllI] = 0) {
                int lllllllllllllIllIIIIIlllIIIlIlII = lllllllllllllIllIIIIIlllIIIIIIlI;
                while (lllllllllllllIllIIIIIlllIIIlIlII-- != 0) {
                    lllllllllllllIllIIIIIllIlllllIIl[lllllllllllllIllIIIIIlllIIIlIlII] = lllllllllllllIllIIIIIllIlllllIII[lllllllllllllIllIIIIIlllIIIlIlII][lllllllllllllIllIIIIIlllIIIIllll];
                }
                lllllllllllllIllIIIIIlllIIIIlllI = ((lllllllllllllIllIIIIIlllIIIIlIIl[lllllllllllllIllIIIIIlllIIIIllll] >>> lllllllllllllIllIIIIIlllIIIIlIII & 0xFF) ^ lllllllllllllIllIIIIIlllIIIIlIlI);
                if (lllllllllllllIllIIIIIlllIIIIllll < lllllllllllllIllIIIIIlllIIIIIllI) {
                    while (true) {
                        final int[] array2 = lllllllllllllIllIIIIIllIlllllIlI;
                        final int n2 = lllllllllllllIllIIIIIlllIIIIlllI;
                        final int n3 = array2[n2] - 1;
                        array2[n2] = n3;
                        final int lllllllllllllIllIIIIIlllIIIlIIII;
                        if ((lllllllllllllIllIIIIIlllIIIlIIII = n3) <= lllllllllllllIllIIIIIlllIIIIllll) {
                            break;
                        }
                        lllllllllllllIllIIIIIlllIIIIlllI = ((lllllllllllllIllIIIIIlllIIIIlIIl[lllllllllllllIllIIIIIlllIIIlIIII] >>> lllllllllllllIllIIIIIlllIIIIlIII & 0xFF) ^ lllllllllllllIllIIIIIlllIIIIlIlI);
                        int lllllllllllllIllIIIIIlllIIIlIIlI = lllllllllllllIllIIIIIlllIIIIIIlI;
                        while (lllllllllllllIllIIIIIlllIIIlIIlI-- != 0) {
                            final int lllllllllllllIllIIIIIlllIIIlIIll = lllllllllllllIllIIIIIllIlllllIIl[lllllllllllllIllIIIIIlllIIIlIIlI];
                            lllllllllllllIllIIIIIllIlllllIIl[lllllllllllllIllIIIIIlllIIIlIIlI] = lllllllllllllIllIIIIIllIlllllIII[lllllllllllllIllIIIIIlllIIIlIIlI][lllllllllllllIllIIIIIlllIIIlIIII];
                            lllllllllllllIllIIIIIllIlllllIII[lllllllllllllIllIIIIIlllIIIlIIlI][lllllllllllllIllIIIIIlllIIIlIIII] = lllllllllllllIllIIIIIlllIIIlIIll;
                        }
                    }
                    int lllllllllllllIllIIIIIlllIIIlIIIl = lllllllllllllIllIIIIIlllIIIIIIlI;
                    while (lllllllllllllIllIIIIIlllIIIlIIIl-- != 0) {
                        lllllllllllllIllIIIIIllIlllllIII[lllllllllllllIllIIIIIlllIIIlIIIl][lllllllllllllIllIIIIIlllIIIIllll] = lllllllllllllIllIIIIIllIlllllIIl[lllllllllllllIllIIIIIlllIIIlIIIl];
                    }
                }
                if (lllllllllllllIllIIIIIlllIIIIlIll < lllllllllllllIllIIIIIlllIIIIIIIl && lllllllllllllIllIIIIIllIlllllIll[lllllllllllllIllIIIIIlllIIIIlllI] > 1) {
                    if (lllllllllllllIllIIIIIllIlllllIll[lllllllllllllIllIIIIIlllIIIIlllI] < 1024) {
                        selectionSort(lllllllllllllIllIIIIIllIlllllIII, lllllllllllllIllIIIIIlllIIIIllll, lllllllllllllIllIIIIIlllIIIIllll + lllllllllllllIllIIIIIllIlllllIll[lllllllllllllIllIIIIIlllIIIIlllI], lllllllllllllIllIIIIIlllIIIIlIll + 1);
                    }
                    else {
                        lllllllllllllIllIIIIIllIlllllllI[lllllllllllllIllIIIIIllIllllllll] = lllllllllllllIllIIIIIlllIIIIllll;
                        lllllllllllllIllIIIIIllIllllllIl[lllllllllllllIllIIIIIllIllllllll] = lllllllllllllIllIIIIIllIlllllIll[lllllllllllllIllIIIIIlllIIIIlllI];
                        lllllllllllllIllIIIIIllIllllllII[lllllllllllllIllIIIIIllIllllllll++] = lllllllllllllIllIIIIIlllIIIIlIll + 1;
                    }
                }
            }
        }
    }
    
    public static void unstableSort(final int[] lllllllllllllIllIIIIlIlIIIlIlllI) {
        unstableSort(lllllllllllllIllIIIIlIlIIIlIlllI, 0, lllllllllllllIllIIIIlIlIIIlIlllI.length);
    }
    
    public static int[] reverse(final int[] lllllllllllllIllIIIIIllIlIllIIlI) {
        final int lllllllllllllIllIIIIIllIlIllIIll = lllllllllllllIllIIIIIllIlIllIIlI.length;
        int lllllllllllllIllIIIIIllIlIllIlIl = lllllllllllllIllIIIIIllIlIllIIll / 2;
        while (lllllllllllllIllIIIIIllIlIllIlIl-- != 0) {
            final int lllllllllllllIllIIIIIllIlIllIllI = lllllllllllllIllIIIIIllIlIllIIlI[lllllllllllllIllIIIIIllIlIllIIll - lllllllllllllIllIIIIIllIlIllIlIl - 1];
            lllllllllllllIllIIIIIllIlIllIIlI[lllllllllllllIllIIIIIllIlIllIIll - lllllllllllllIllIIIIIllIlIllIlIl - 1] = lllllllllllllIllIIIIIllIlIllIIlI[lllllllllllllIllIIIIIllIlIllIlIl];
            lllllllllllllIllIIIIIllIlIllIIlI[lllllllllllllIllIIIIIllIlIllIlIl] = lllllllllllllIllIIIIIllIlIllIllI;
        }
        return lllllllllllllIllIIIIIllIlIllIIlI;
    }
    
    public static void parallelQuickSortIndirect(final int[] lllllllllllllIllIIIIlIlIlllllIll, final int[] lllllllllllllIllIIIIlIlIlllllIlI) {
        parallelQuickSortIndirect(lllllllllllllIllIIIIlIlIlllllIll, lllllllllllllIllIIIIlIlIlllllIlI, 0, lllllllllllllIllIIIIlIlIlllllIlI.length);
    }
    
    private static int med3Indirect(final int[] lllllllllllllIllIIIIlIllIllIIIlI, final int[] lllllllllllllIllIIIIlIllIllIIIIl, final int lllllllllllllIllIIIIlIllIllIlIll, final int lllllllllllllIllIIIIlIllIllIlIlI, final int lllllllllllllIllIIIIlIllIllIlIIl) {
        final int lllllllllllllIllIIIIlIllIllIlIII = lllllllllllllIllIIIIlIllIllIIIIl[lllllllllllllIllIIIIlIllIllIIIlI[lllllllllllllIllIIIIlIllIllIlIll]];
        final int lllllllllllllIllIIIIlIllIllIIlll = lllllllllllllIllIIIIlIllIllIIIIl[lllllllllllllIllIIIIlIllIllIIIlI[lllllllllllllIllIIIIlIllIllIlIlI]];
        final int lllllllllllllIllIIIIlIllIllIIllI = lllllllllllllIllIIIIlIllIllIIIIl[lllllllllllllIllIIIIlIllIllIIIlI[lllllllllllllIllIIIIlIllIllIlIIl]];
        final int lllllllllllllIllIIIIlIllIllIIlIl = Integer.compare(lllllllllllllIllIIIIlIllIllIlIII, lllllllllllllIllIIIIlIllIllIIlll);
        final int lllllllllllllIllIIIIlIllIllIIlII = Integer.compare(lllllllllllllIllIIIIlIllIllIlIII, lllllllllllllIllIIIIlIllIllIIllI);
        final int lllllllllllllIllIIIIlIllIllIIIll = Integer.compare(lllllllllllllIllIIIIlIllIllIIlll, lllllllllllllIllIIIIlIllIllIIllI);
        return (lllllllllllllIllIIIIlIllIllIIlIl < 0) ? ((lllllllllllllIllIIIIlIllIllIIIll < 0) ? lllllllllllllIllIIIIlIllIllIlIlI : ((lllllllllllllIllIIIIlIllIllIIlII < 0) ? lllllllllllllIllIIIIlIllIllIlIIl : lllllllllllllIllIIIIlIllIllIlIll)) : ((lllllllllllllIllIIIIlIllIllIIIll > 0) ? lllllllllllllIllIIIIlIllIllIlIlI : ((lllllllllllllIllIIIIlIllIllIIlII > 0) ? lllllllllllllIllIIIIlIllIllIlIIl : lllllllllllllIllIIIIlIllIllIlIll));
    }
    
    public static void mergeSort(final int[] lllllllllllllIllIIIIlIIlllllIlIl) {
        mergeSort(lllllllllllllIllIIIIlIIlllllIlIl, 0, lllllllllllllIllIIIIlIIlllllIlIl.length);
    }
    
    public static void swap(final int[] lllllllllllllIllIIIIllIIlIIlIIlI, final int lllllllllllllIllIIIIllIIlIIlIlIl, final int lllllllllllllIllIIIIllIIlIIlIlII) {
        final int lllllllllllllIllIIIIllIIlIIlIIll = lllllllllllllIllIIIIllIIlIIlIIlI[lllllllllllllIllIIIIllIIlIIlIlIl];
        lllllllllllllIllIIIIllIIlIIlIIlI[lllllllllllllIllIIIIllIIlIIlIlIl] = lllllllllllllIllIIIIllIIlIIlIIlI[lllllllllllllIllIIIIllIIlIIlIlII];
        lllllllllllllIllIIIIllIIlIIlIIlI[lllllllllllllIllIIIIllIIlIIlIlII] = lllllllllllllIllIIIIllIIlIIlIIll;
    }
    
    public static int[] ensureCapacity(final int[] lllllllllllllIllIIIIllIlIIIIllII, final int lllllllllllllIllIIIIllIlIIIIlIll, final int lllllllllllllIllIIIIllIlIIIIIlll) {
        return (lllllllllllllIllIIIIllIlIIIIlIll > lllllllllllllIllIIIIllIlIIIIllII.length) ? forceCapacity(lllllllllllllIllIIIIllIlIIIIllII, lllllllllllllIllIIIIllIlIIIIlIll, lllllllllllllIllIIIIllIlIIIIIlll) : lllllllllllllIllIIIIllIlIIIIllII;
    }
    
    public static void quickSort(final int[] lllllllllllllIllIIIIllIIIIIIlIlI, final IntComparator lllllllllllllIllIIIIllIIIIIIlIIl) {
        quickSort(lllllllllllllIllIIIIllIIIIIIlIlI, 0, lllllllllllllIllIIIIllIIIIIIlIlI.length, lllllllllllllIllIIIIllIIIIIIlIIl);
    }
    
    public static void stableSort(final int[] lllllllllllllIllIIIIlIIllIlllIIl) {
        stableSort(lllllllllllllIllIIIIlIIllIlllIIl, 0, lllllllllllllIllIIIIlIIllIlllIIl.length);
    }
    
    public static void parallelQuickSortIndirect(final int[] lllllllllllllIllIIIIlIllIIIIIllI, final int[] lllllllllllllIllIIIIlIllIIIIIIIl, final int lllllllllllllIllIIIIlIllIIIIIIII, final int lllllllllllllIllIIIIlIlIllllllll) {
        if (lllllllllllllIllIIIIlIlIllllllll - lllllllllllllIllIIIIlIllIIIIIIII < 8192) {
            quickSortIndirect(lllllllllllllIllIIIIlIllIIIIIllI, lllllllllllllIllIIIIlIllIIIIIIIl, lllllllllllllIllIIIIlIllIIIIIIII, lllllllllllllIllIIIIlIlIllllllll);
        }
        else {
            final ForkJoinPool lllllllllllllIllIIIIlIllIIIIIlll = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            lllllllllllllIllIIIIlIllIIIIIlll.invoke((ForkJoinTask<Object>)new ForkJoinQuickSortIndirect(lllllllllllllIllIIIIlIllIIIIIllI, lllllllllllllIllIIIIlIllIIIIIIIl, lllllllllllllIllIIIIlIllIIIIIIII, lllllllllllllIllIIIIlIlIllllllll));
            lllllllllllllIllIIIIlIllIIIIIlll.shutdown();
        }
    }
    
    public static void quickSortIndirect(final int[] lllllllllllllIllIIIIlIllIIlIlllI, final int[] lllllllllllllIllIIIIlIllIIlIllIl, final int lllllllllllllIllIIIIlIllIIIllllI, final int lllllllllllllIllIIIIlIllIIIlllIl) {
        final int lllllllllllllIllIIIIlIllIIlIlIlI = lllllllllllllIllIIIIlIllIIIlllIl - lllllllllllllIllIIIIlIllIIIllllI;
        if (lllllllllllllIllIIIIlIllIIlIlIlI < 16) {
            insertionSortIndirect(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIllIl, lllllllllllllIllIIIIlIllIIIllllI, lllllllllllllIllIIIIlIllIIIlllIl);
            return;
        }
        int lllllllllllllIllIIIIlIllIIlIlIIl = lllllllllllllIllIIIIlIllIIIllllI + lllllllllllllIllIIIIlIllIIlIlIlI / 2;
        int lllllllllllllIllIIIIlIllIIlIlIII = lllllllllllllIllIIIIlIllIIIllllI;
        int lllllllllllllIllIIIIlIllIIlIIlll = lllllllllllllIllIIIIlIllIIIlllIl - 1;
        if (lllllllllllllIllIIIIlIllIIlIlIlI > 128) {
            final int lllllllllllllIllIIIIlIllIIllIIIl = lllllllllllllIllIIIIlIllIIlIlIlI / 8;
            lllllllllllllIllIIIIlIllIIlIlIII = med3Indirect(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIllIl, lllllllllllllIllIIIIlIllIIlIlIII, lllllllllllllIllIIIIlIllIIlIlIII + lllllllllllllIllIIIIlIllIIllIIIl, lllllllllllllIllIIIIlIllIIlIlIII + 2 * lllllllllllllIllIIIIlIllIIllIIIl);
            lllllllllllllIllIIIIlIllIIlIlIIl = med3Indirect(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIllIl, lllllllllllllIllIIIIlIllIIlIlIIl - lllllllllllllIllIIIIlIllIIllIIIl, lllllllllllllIllIIIIlIllIIlIlIIl, lllllllllllllIllIIIIlIllIIlIlIIl + lllllllllllllIllIIIIlIllIIllIIIl);
            lllllllllllllIllIIIIlIllIIlIIlll = med3Indirect(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIllIl, lllllllllllllIllIIIIlIllIIlIIlll - 2 * lllllllllllllIllIIIIlIllIIllIIIl, lllllllllllllIllIIIIlIllIIlIIlll - lllllllllllllIllIIIIlIllIIllIIIl, lllllllllllllIllIIIIlIllIIlIIlll);
        }
        lllllllllllllIllIIIIlIllIIlIlIIl = med3Indirect(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIllIl, lllllllllllllIllIIIIlIllIIlIlIII, lllllllllllllIllIIIIlIllIIlIlIIl, lllllllllllllIllIIIIlIllIIlIIlll);
        final int lllllllllllllIllIIIIlIllIIlIIllI = lllllllllllllIllIIIIlIllIIlIllIl[lllllllllllllIllIIIIlIllIIlIlllI[lllllllllllllIllIIIIlIllIIlIlIIl]];
        int lllllllllllllIllIIIIlIllIIlIIlII;
        int lllllllllllllIllIIIIlIllIIlIIlIl = lllllllllllllIllIIIIlIllIIlIIlII = lllllllllllllIllIIIIlIllIIIllllI;
        int lllllllllllllIllIIIIlIllIIlIIIlI;
        int lllllllllllllIllIIIIlIllIIlIIIll = lllllllllllllIllIIIIlIllIIlIIIlI = lllllllllllllIllIIIIlIllIIIlllIl - 1;
        while (true) {
            final int lllllllllllllIllIIIIlIllIIllIIII;
            if (lllllllllllllIllIIIIlIllIIlIIlII <= lllllllllllllIllIIIIlIllIIlIIIll && (lllllllllllllIllIIIIlIllIIllIIII = Integer.compare(lllllllllllllIllIIIIlIllIIlIllIl[lllllllllllllIllIIIIlIllIIlIlllI[lllllllllllllIllIIIIlIllIIlIIlII]], lllllllllllllIllIIIIlIllIIlIIllI)) <= 0) {
                if (lllllllllllllIllIIIIlIllIIllIIII == 0) {
                    swap(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIIlIl++, lllllllllllllIllIIIIlIllIIlIIlII);
                }
                ++lllllllllllllIllIIIIlIllIIlIIlII;
            }
            else {
                int lllllllllllllIllIIIIlIllIIlIllll;
                while (lllllllllllllIllIIIIlIllIIlIIIll >= lllllllllllllIllIIIIlIllIIlIIlII && (lllllllllllllIllIIIIlIllIIlIllll = Integer.compare(lllllllllllllIllIIIIlIllIIlIllIl[lllllllllllllIllIIIIlIllIIlIlllI[lllllllllllllIllIIIIlIllIIlIIIll]], lllllllllllllIllIIIIlIllIIlIIllI)) >= 0) {
                    if (lllllllllllllIllIIIIlIllIIlIllll == 0) {
                        swap(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIIIll, lllllllllllllIllIIIIlIllIIlIIIlI--);
                    }
                    --lllllllllllllIllIIIIlIllIIlIIIll;
                }
                if (lllllllllllllIllIIIIlIllIIlIIlII > lllllllllllllIllIIIIlIllIIlIIIll) {
                    break;
                }
                swap(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIIlII++, lllllllllllllIllIIIIlIllIIlIIIll--);
            }
        }
        int lllllllllllllIllIIIIlIllIIlIIIIl = Math.min(lllllllllllllIllIIIIlIllIIlIIlIl - lllllllllllllIllIIIIlIllIIIllllI, lllllllllllllIllIIIIlIllIIlIIlII - lllllllllllllIllIIIIlIllIIlIIlIl);
        swap(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIIllllI, lllllllllllllIllIIIIlIllIIlIIlII - lllllllllllllIllIIIIlIllIIlIIIIl, lllllllllllllIllIIIIlIllIIlIIIIl);
        lllllllllllllIllIIIIlIllIIlIIIIl = Math.min(lllllllllllllIllIIIIlIllIIlIIIlI - lllllllllllllIllIIIIlIllIIlIIIll, lllllllllllllIllIIIIlIllIIIlllIl - lllllllllllllIllIIIIlIllIIlIIIlI - 1);
        swap(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIIlII, lllllllllllllIllIIIIlIllIIIlllIl - lllllllllllllIllIIIIlIllIIlIIIIl, lllllllllllllIllIIIIlIllIIlIIIIl);
        if ((lllllllllllllIllIIIIlIllIIlIIIIl = lllllllllllllIllIIIIlIllIIlIIlII - lllllllllllllIllIIIIlIllIIlIIlIl) > 1) {
            quickSortIndirect(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIllIl, lllllllllllllIllIIIIlIllIIIllllI, lllllllllllllIllIIIIlIllIIIllllI + lllllllllllllIllIIIIlIllIIlIIIIl);
        }
        if ((lllllllllllllIllIIIIlIllIIlIIIIl = lllllllllllllIllIIIIlIllIIlIIIlI - lllllllllllllIllIIIIlIllIIlIIIll) > 1) {
            quickSortIndirect(lllllllllllllIllIIIIlIllIIlIlllI, lllllllllllllIllIIIIlIllIIlIllIl, lllllllllllllIllIIIIlIllIIIlllIl - lllllllllllllIllIIIIlIllIIlIIIIl, lllllllllllllIllIIIIlIllIIIlllIl);
        }
    }
    
    public static int[] grow(final int[] lllllllllllllIllIIIIllIlIIIIIlII, final int lllllllllllllIllIIIIllIlIIIIIIIl) {
        return grow(lllllllllllllIllIIIIllIlIIIIIlII, lllllllllllllIllIIIIllIlIIIIIIIl, lllllllllllllIllIIIIllIlIIIIIlII.length);
    }
    
    public static void quickSort(final int[] lllllllllllllIllIIIIlIlIIlIlIIIl, final int[] lllllllllllllIllIIIIlIlIIlIlIIII) {
        ensureSameLength(lllllllllllllIllIIIIlIlIIlIlIIIl, lllllllllllllIllIIIIlIlIIlIlIIII);
        quickSort(lllllllllllllIllIIIIlIlIIlIlIIIl, lllllllllllllIllIIIIlIlIIlIlIIII, 0, lllllllllllllIllIIIIlIlIIlIlIIIl.length);
    }
    
    public static void parallelRadixSort(final int[] lllllllllllllIllIIIIlIIIlllllIlI) {
        parallelRadixSort(lllllllllllllIllIIIIlIIIlllllIlI, 0, lllllllllllllIllIIIIlIIIlllllIlI.length);
    }
    
    public static void mergeSort(final int[] lllllllllllllIllIIIIlIIllllllIIl, final int lllllllllllllIllIIIIlIIllllllIII, final int lllllllllllllIllIIIIlIIllllllIlI) {
        mergeSort(lllllllllllllIllIIIIlIIllllllIIl, lllllllllllllIllIIIIlIIllllllIII, lllllllllllllIllIIIIlIIllllllIlI, lllllllllllllIllIIIIlIIllllllIIl.clone());
    }
    
    private static void swap(final int[] lllllllllllllIllIIIIlIlIlIlIIllI, final int[] lllllllllllllIllIIIIlIlIlIlIlIlI, int lllllllllllllIllIIIIlIlIlIlIIlII, int lllllllllllllIllIIIIlIlIlIlIlIII, final int lllllllllllllIllIIIIlIlIlIlIIIlI) {
        for (int lllllllllllllIllIIIIlIlIlIlIllII = 0; lllllllllllllIllIIIIlIlIlIlIllII < lllllllllllllIllIIIIlIlIlIlIIIlI; ++lllllllllllllIllIIIIlIlIlIlIllII, ++lllllllllllllIllIIIIlIlIlIlIIlII, ++lllllllllllllIllIIIIlIlIlIlIlIII) {
            swap(lllllllllllllIllIIIIlIlIlIlIIllI, lllllllllllllIllIIIIlIlIlIlIlIlI, lllllllllllllIllIIIIlIlIlIlIIlII, lllllllllllllIllIIIIlIlIlIlIlIII);
        }
    }
    
    public static int[] shuffle(final int[] lllllllllllllIllIIIIIllIllIIIIIl, final Random lllllllllllllIllIIIIIllIllIIIIII) {
        int lllllllllllllIllIIIIIllIllIIIIlI = lllllllllllllIllIIIIIllIllIIIIIl.length;
        while (lllllllllllllIllIIIIIllIllIIIIlI-- != 0) {
            final int lllllllllllllIllIIIIIllIllIIIlII = lllllllllllllIllIIIIIllIllIIIIII.nextInt(lllllllllllllIllIIIIIllIllIIIIlI + 1);
            final int lllllllllllllIllIIIIIllIllIIIIll = lllllllllllllIllIIIIIllIllIIIIIl[lllllllllllllIllIIIIIllIllIIIIlI];
            lllllllllllllIllIIIIIllIllIIIIIl[lllllllllllllIllIIIIIllIllIIIIlI] = lllllllllllllIllIIIIIllIllIIIIIl[lllllllllllllIllIIIIIllIllIIIlII];
            lllllllllllllIllIIIIIllIllIIIIIl[lllllllllllllIllIIIIIllIllIIIlII] = lllllllllllllIllIIIIIllIllIIIIll;
        }
        return lllllllllllllIllIIIIIllIllIIIIIl;
    }
    
    private static int med3(final int[] lllllllllllllIllIIIIlIlllllIIIll, final int lllllllllllllIllIIIIlIlllllIlIIl, final int lllllllllllllIllIIIIlIlllllIlIII, final int lllllllllllllIllIIIIlIlllllIIIII) {
        final int lllllllllllllIllIIIIlIlllllIIllI = Integer.compare(lllllllllllllIllIIIIlIlllllIIIll[lllllllllllllIllIIIIlIlllllIlIIl], lllllllllllllIllIIIIlIlllllIIIll[lllllllllllllIllIIIIlIlllllIlIII]);
        final int lllllllllllllIllIIIIlIlllllIIlIl = Integer.compare(lllllllllllllIllIIIIlIlllllIIIll[lllllllllllllIllIIIIlIlllllIlIIl], lllllllllllllIllIIIIlIlllllIIIll[lllllllllllllIllIIIIlIlllllIIIII]);
        final int lllllllllllllIllIIIIlIlllllIIlII = Integer.compare(lllllllllllllIllIIIIlIlllllIIIll[lllllllllllllIllIIIIlIlllllIlIII], lllllllllllllIllIIIIlIlllllIIIll[lllllllllllllIllIIIIlIlllllIIIII]);
        return (lllllllllllllIllIIIIlIlllllIIllI < 0) ? ((lllllllllllllIllIIIIlIlllllIIlII < 0) ? lllllllllllllIllIIIIlIlllllIlIII : ((lllllllllllllIllIIIIlIlllllIIlIl < 0) ? lllllllllllllIllIIIIlIlllllIIIII : lllllllllllllIllIIIIlIlllllIlIIl)) : ((lllllllllllllIllIIIIlIlllllIIlII > 0) ? lllllllllllllIllIIIIlIlllllIlIII : ((lllllllllllllIllIIIIlIlllllIIlIl > 0) ? lllllllllllllIllIIIIlIlllllIIIII : lllllllllllllIllIIIIlIlllllIlIIl));
    }
    
    public static void ensureFromTo(final int[] lllllllllllllIllIIIIllIIlIlIllll, final int lllllllllllllIllIIIIllIIlIlIlIll, final int lllllllllllllIllIIIIllIIlIlIllIl) {
        com.viaversion.viaversion.libs.fastutil.Arrays.ensureFromTo(lllllllllllllIllIIIIllIIlIlIllll.length, lllllllllllllIllIIIIllIIlIlIlIll, lllllllllllllIllIIIIllIIlIlIllIl);
    }
    
    public static void quickSort(final int[] lllllllllllllIllIIIIlIlllIIIlIII) {
        quickSort(lllllllllllllIllIIIIlIlllIIIlIII, 0, lllllllllllllIllIIIIlIlllIIIlIII.length);
    }
    
    public static int[] copy(final int[] lllllllllllllIllIIIIllIIllIllllI, final int lllllllllllllIllIIIIllIIllIllIIl, final int lllllllllllllIllIIIIllIIllIlllII) {
        ensureOffsetLength(lllllllllllllIllIIIIllIIllIllllI, lllllllllllllIllIIIIllIIllIllIIl, lllllllllllllIllIIIIllIIllIlllII);
        final int[] lllllllllllllIllIIIIllIIllIllIll = (lllllllllllllIllIIIIllIIllIlllII == 0) ? IntArrays.EMPTY_ARRAY : new int[lllllllllllllIllIIIIllIIllIlllII];
        System.arraycopy(lllllllllllllIllIIIIllIIllIllllI, lllllllllllllIllIIIIllIIllIllIIl, lllllllllllllIllIIIIllIIllIllIll, 0, lllllllllllllIllIIIIllIIllIlllII);
        return lllllllllllllIllIIIIllIIllIllIll;
    }
    
    public static int binarySearch(final int[] lllllllllllllIllIIIIlIIlIllIllll, final int lllllllllllllIllIIIIlIIlIllIlllI, final IntComparator lllllllllllllIllIIIIlIIlIlllIIII) {
        return binarySearch(lllllllllllllIllIIIIlIIlIllIllll, 0, lllllllllllllIllIIIIlIIlIllIllll.length, lllllllllllllIllIIIIlIIlIllIlllI, lllllllllllllIllIIIIlIIlIlllIIII);
    }
    
    private static void insertionSort(final int[] lllllllllllllIllIIIIllIIIlIIIIIl, final int lllllllllllllIllIIIIllIIIlIIIIII, final int lllllllllllllIllIIIIllIIIlIIIIll, final IntComparator lllllllllllllIllIIIIllIIIlIIIIlI) {
        int lllllllllllllIllIIIIllIIIlIIIllI = lllllllllllllIllIIIIllIIIlIIIIII;
        while (++lllllllllllllIllIIIIllIIIlIIIllI < lllllllllllllIllIIIIllIIIlIIIIll) {
            final int lllllllllllllIllIIIIllIIIlIIlIII = lllllllllllllIllIIIIllIIIlIIIIIl[lllllllllllllIllIIIIllIIIlIIIllI];
            int lllllllllllllIllIIIIllIIIlIIIlll = lllllllllllllIllIIIIllIIIlIIIllI;
            for (int lllllllllllllIllIIIIllIIIlIIlIIl = lllllllllllllIllIIIIllIIIlIIIIIl[lllllllllllllIllIIIIllIIIlIIIlll - 1]; lllllllllllllIllIIIIllIIIlIIIIlI.compare(lllllllllllllIllIIIIllIIIlIIlIII, lllllllllllllIllIIIIllIIIlIIlIIl) < 0; lllllllllllllIllIIIIllIIIlIIlIIl = lllllllllllllIllIIIIllIIIlIIIIIl[--lllllllllllllIllIIIIllIIIlIIIlll - 1]) {
                lllllllllllllIllIIIIllIIIlIIIIIl[lllllllllllllIllIIIIllIIIlIIIlll] = lllllllllllllIllIIIIllIIIlIIlIIl;
                if (lllllllllllllIllIIIIllIIIlIIIIII == lllllllllllllIllIIIIllIIIlIIIlll - 1) {
                    --lllllllllllllIllIIIIllIIIlIIIlll;
                    break;
                }
            }
            lllllllllllllIllIIIIllIIIlIIIIIl[lllllllllllllIllIIIIllIIIlIIIlll] = lllllllllllllIllIIIIllIIIlIIlIII;
        }
    }
    
    public static void stableSort(final int[] lllllllllllllIllIIIIlIIllIllIIll, final int lllllllllllllIllIIIIlIIllIllIIlI, final int lllllllllllllIllIIIIlIIllIllIIIl, final IntComparator lllllllllllllIllIIIIlIIllIllIIII) {
        mergeSort(lllllllllllllIllIIIIlIIllIllIIll, lllllllllllllIllIIIIlIIllIllIIlI, lllllllllllllIllIIIIlIIllIllIIIl, lllllllllllllIllIIIIlIIllIllIIII);
    }
    
    public static void radixSort(final int[][] lllllllllllllIllIIIIIlllIIllIlIl) {
        radixSort(lllllllllllllIllIIIIIlllIIllIlIl, 0, lllllllllllllIllIIIIIlllIIllIlIl[0].length);
    }
    
    public static void unstableSort(final int[] lllllllllllllIllIIIIlIlIIIllIlIl, final int lllllllllllllIllIIIIlIlIIIllIIIl, final int lllllllllllllIllIIIIlIlIIIllIIll) {
        if (lllllllllllllIllIIIIlIlIIIllIIll - lllllllllllllIllIIIIlIlIIIllIIIl >= 2000) {
            radixSort(lllllllllllllIllIIIIlIlIIIllIlIl, lllllllllllllIllIIIIlIlIIIllIIIl, lllllllllllllIllIIIIlIlIIIllIIll);
        }
        else {
            quickSort(lllllllllllllIllIIIIlIlIIIllIlIl, lllllllllllllIllIIIIlIlIIIllIIIl, lllllllllllllIllIIIIlIlIIIllIIll);
        }
    }
    
    @Deprecated
    public static boolean equals(final int[] lllllllllllllIllIIIIllIIlIllIlIl, final int[] lllllllllllllIllIIIIllIIlIllIlll) {
        int lllllllllllllIllIIIIllIIlIllIllI = lllllllllllllIllIIIIllIIlIllIlIl.length;
        if (lllllllllllllIllIIIIllIIlIllIllI != lllllllllllllIllIIIIllIIlIllIlll.length) {
            return false;
        }
        while (lllllllllllllIllIIIIllIIlIllIllI-- != 0) {
            if (lllllllllllllIllIIIIllIIlIllIlIl[lllllllllllllIllIIIIllIIlIllIllI] != lllllllllllllIllIIIIllIIlIllIlll[lllllllllllllIllIIIIllIIlIllIllI]) {
                return false;
            }
        }
        return true;
    }
    
    public static void parallelRadixSortIndirect(final int[] lllllllllllllIllIIIIlIIIIllIlIll, final int[] lllllllllllllIllIIIIlIIIIllIlIlI, final boolean lllllllllllllIllIIIIlIIIIllIIllI) {
        parallelRadixSortIndirect(lllllllllllllIllIIIIlIIIIllIlIll, lllllllllllllIllIIIIlIIIIllIlIlI, 0, lllllllllllllIllIIIIlIIIIllIlIlI.length, lllllllllllllIllIIIIlIIIIllIIllI);
    }
    
    static {
        RADIXSORT_NO_REC = 1024;
        QUICKSORT_MEDIAN_OF_9 = 128;
        DIGIT_BITS = 8;
        DIGITS_PER_ELEMENT = 4;
        PARALLEL_RADIXSORT_NO_FORK = 1024;
        QUICKSORT_NO_REC = 16;
        PARALLEL_QUICKSORT_NO_FORK = 8192;
        MERGESORT_NO_REC = 16;
        DIGIT_MASK = 255;
        RADIX_SORT_MIN_THRESHOLD = 2000;
        EMPTY_ARRAY = new int[0];
        DEFAULT_EMPTY_ARRAY = new int[0];
        POISON_PILL = new Segment(-1, -1, -1);
        HASH_STRATEGY = new ArrayHashStrategy();
    }
    
    public static void parallelQuickSort(final int[] lllllllllllllIllIIIIlIlllIIIIIlI, final int lllllllllllllIllIIIIlIlllIIIIIIl, final int lllllllllllllIllIIIIlIllIlllllIl) {
        if (lllllllllllllIllIIIIlIllIlllllIl - lllllllllllllIllIIIIlIlllIIIIIIl < 8192) {
            quickSort(lllllllllllllIllIIIIlIlllIIIIIlI, lllllllllllllIllIIIIlIlllIIIIIIl, lllllllllllllIllIIIIlIllIlllllIl);
        }
        else {
            final ForkJoinPool lllllllllllllIllIIIIlIlllIIIIIll = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            lllllllllllllIllIIIIlIlllIIIIIll.invoke((ForkJoinTask<Object>)new ForkJoinQuickSort(lllllllllllllIllIIIIlIlllIIIIIlI, lllllllllllllIllIIIIlIlllIIIIIIl, lllllllllllllIllIIIIlIllIlllllIl));
            lllllllllllllIllIIIIlIlllIIIIIll.shutdown();
        }
    }
    
    public static int[] reverse(final int[] lllllllllllllIllIIIIIllIlIlIIIlI, final int lllllllllllllIllIIIIIllIlIlIIlIl, final int lllllllllllllIllIIIIIllIlIlIIlII) {
        final int lllllllllllllIllIIIIIllIlIlIIIll = lllllllllllllIllIIIIIllIlIlIIlII - lllllllllllllIllIIIIIllIlIlIIlIl;
        int lllllllllllllIllIIIIIllIlIlIIlll = lllllllllllllIllIIIIIllIlIlIIIll / 2;
        while (lllllllllllllIllIIIIIllIlIlIIlll-- != 0) {
            final int lllllllllllllIllIIIIIllIlIlIlIII = lllllllllllllIllIIIIIllIlIlIIIlI[lllllllllllllIllIIIIIllIlIlIIlIl + lllllllllllllIllIIIIIllIlIlIIIll - lllllllllllllIllIIIIIllIlIlIIlll - 1];
            lllllllllllllIllIIIIIllIlIlIIIlI[lllllllllllllIllIIIIIllIlIlIIlIl + lllllllllllllIllIIIIIllIlIlIIIll - lllllllllllllIllIIIIIllIlIlIIlll - 1] = lllllllllllllIllIIIIIllIlIlIIIlI[lllllllllllllIllIIIIIllIlIlIIlIl + lllllllllllllIllIIIIIllIlIlIIlll];
            lllllllllllllIllIIIIIllIlIlIIIlI[lllllllllllllIllIIIIIllIlIlIIlIl + lllllllllllllIllIIIIIllIlIlIIlll] = lllllllllllllIllIIIIIllIlIlIlIII;
        }
        return lllllllllllllIllIIIIIllIlIlIIIlI;
    }
    
    public static void ensureOffsetLength(final int[] lllllllllllllIllIIIIllIIlIlIIllI, final int lllllllllllllIllIIIIllIIlIlIIlIl, final int lllllllllllllIllIIIIllIIlIlIIIIl) {
        com.viaversion.viaversion.libs.fastutil.Arrays.ensureOffsetLength(lllllllllllllIllIIIIllIIlIlIIllI.length, lllllllllllllIllIIIIllIIlIlIIlIl, lllllllllllllIllIIIIllIIlIlIIIIl);
    }
    
    private static void selectionSort(final int[][] lllllllllllllIllIIIIIlllIlIIIIII, final int lllllllllllllIllIIIIIlllIlIIIlIl, final int lllllllllllllIllIIIIIlllIlIIIlII, final int lllllllllllllIllIIIIIlllIIllllIl) {
        final int lllllllllllllIllIIIIIlllIlIIIIlI = lllllllllllllIllIIIIIlllIlIIIIII.length;
        final int lllllllllllllIllIIIIIlllIlIIIIIl = lllllllllllllIllIIIIIlllIIllllIl / 4;
        for (int lllllllllllllIllIIIIIlllIlIIIlll = lllllllllllllIllIIIIIlllIlIIIlIl; lllllllllllllIllIIIIIlllIlIIIlll < lllllllllllllIllIIIIIlllIlIIIlII - 1; ++lllllllllllllIllIIIIIlllIlIIIlll) {
            int lllllllllllllIllIIIIIlllIlIIlIII = lllllllllllllIllIIIIIlllIlIIIlll;
            for (int lllllllllllllIllIIIIIlllIlIIlIll = lllllllllllllIllIIIIIlllIlIIIlll + 1; lllllllllllllIllIIIIIlllIlIIlIll < lllllllllllllIllIIIIIlllIlIIIlII; ++lllllllllllllIllIIIIIlllIlIIlIll) {
                for (int lllllllllllllIllIIIIIlllIlIIllII = lllllllllllllIllIIIIIlllIlIIIIIl; lllllllllllllIllIIIIIlllIlIIllII < lllllllllllllIllIIIIIlllIlIIIIlI; ++lllllllllllllIllIIIIIlllIlIIllII) {
                    if (lllllllllllllIllIIIIIlllIlIIIIII[lllllllllllllIllIIIIIlllIlIIllII][lllllllllllllIllIIIIIlllIlIIlIll] < lllllllllllllIllIIIIIlllIlIIIIII[lllllllllllllIllIIIIIlllIlIIllII][lllllllllllllIllIIIIIlllIlIIlIII]) {
                        lllllllllllllIllIIIIIlllIlIIlIII = lllllllllllllIllIIIIIlllIlIIlIll;
                        break;
                    }
                    if (lllllllllllllIllIIIIIlllIlIIIIII[lllllllllllllIllIIIIIlllIlIIllII][lllllllllllllIllIIIIIlllIlIIlIll] > lllllllllllllIllIIIIIlllIlIIIIII[lllllllllllllIllIIIIIlllIlIIllII][lllllllllllllIllIIIIIlllIlIIlIII]) {
                        break;
                    }
                }
            }
            if (lllllllllllllIllIIIIIlllIlIIlIII != lllllllllllllIllIIIIIlllIlIIIlll) {
                int lllllllllllllIllIIIIIlllIlIIlIIl = lllllllllllllIllIIIIIlllIlIIIIlI;
                while (lllllllllllllIllIIIIIlllIlIIlIIl-- != 0) {
                    final int lllllllllllllIllIIIIIlllIlIIlIlI = lllllllllllllIllIIIIIlllIlIIIIII[lllllllllllllIllIIIIIlllIlIIlIIl][lllllllllllllIllIIIIIlllIlIIIlll];
                    lllllllllllllIllIIIIIlllIlIIIIII[lllllllllllllIllIIIIIlllIlIIlIIl][lllllllllllllIllIIIIIlllIlIIIlll] = lllllllllllllIllIIIIIlllIlIIIIII[lllllllllllllIllIIIIIlllIlIIlIIl][lllllllllllllIllIIIIIlllIlIIlIII];
                    lllllllllllllIllIIIIIlllIlIIIIII[lllllllllllllIllIIIIIlllIlIIlIIl][lllllllllllllIllIIIIIlllIlIIlIII] = lllllllllllllIllIIIIIlllIlIIlIlI;
                }
            }
        }
    }
    
    public static int binarySearch(final int[] lllllllllllllIllIIIIlIIllIIIllll, final int lllllllllllllIllIIIIlIIllIIIlllI) {
        return binarySearch(lllllllllllllIllIIIIlIIllIIIllll, 0, lllllllllllllIllIIIIlIIllIIIllll.length, lllllllllllllIllIIIIlIIllIIIlllI);
    }
    
    public static void stabilize(final int[] lllllllllllllIllIIIIlIlIlllIlIll, final int[] lllllllllllllIllIIIIlIlIlllIllll, final int lllllllllllllIllIIIIlIlIlllIlIIl, final int lllllllllllllIllIIIIlIlIlllIllIl) {
        int lllllllllllllIllIIIIlIlIlllIllII = lllllllllllllIllIIIIlIlIlllIlIIl;
        for (int lllllllllllllIllIIIIlIlIllllIIIl = lllllllllllllIllIIIIlIlIlllIlIIl + 1; lllllllllllllIllIIIIlIlIllllIIIl < lllllllllllllIllIIIIlIlIlllIllIl; ++lllllllllllllIllIIIIlIlIllllIIIl) {
            if (lllllllllllllIllIIIIlIlIlllIllll[lllllllllllllIllIIIIlIlIlllIlIll[lllllllllllllIllIIIIlIlIllllIIIl]] != lllllllllllllIllIIIIlIlIlllIllll[lllllllllllllIllIIIIlIlIlllIlIll[lllllllllllllIllIIIIlIlIlllIllII]]) {
                if (lllllllllllllIllIIIIlIlIllllIIIl - lllllllllllllIllIIIIlIlIlllIllII > 1) {
                    parallelQuickSort(lllllllllllllIllIIIIlIlIlllIlIll, lllllllllllllIllIIIIlIlIlllIllII, lllllllllllllIllIIIIlIlIllllIIIl);
                }
                lllllllllllllIllIIIIlIlIlllIllII = lllllllllllllIllIIIIlIlIllllIIIl;
            }
        }
        if (lllllllllllllIllIIIIlIlIlllIllIl - lllllllllllllIllIIIIlIlIlllIllII > 1) {
            parallelQuickSort(lllllllllllllIllIIIIlIlIlllIlIll, lllllllllllllIllIIIIlIlIlllIllII, lllllllllllllIllIIIIlIlIlllIllIl);
        }
    }
    
    public static void mergeSort(final int[] lllllllllllllIllIIIIlIlIIIIIlllI, final int lllllllllllllIllIIIIlIlIIIIIIlll, final int lllllllllllllIllIIIIlIlIIIIIllII, final int[] lllllllllllllIllIIIIlIlIIIIIIlIl) {
        final int lllllllllllllIllIIIIlIlIIIIIlIlI = lllllllllllllIllIIIIlIlIIIIIllII - lllllllllllllIllIIIIlIlIIIIIIlll;
        if (lllllllllllllIllIIIIlIlIIIIIlIlI < 16) {
            insertionSort(lllllllllllllIllIIIIlIlIIIIIlllI, lllllllllllllIllIIIIlIlIIIIIIlll, lllllllllllllIllIIIIlIlIIIIIllII);
            return;
        }
        final int lllllllllllllIllIIIIlIlIIIIIlIIl = lllllllllllllIllIIIIlIlIIIIIIlll + lllllllllllllIllIIIIlIlIIIIIllII >>> 1;
        mergeSort(lllllllllllllIllIIIIlIlIIIIIIlIl, lllllllllllllIllIIIIlIlIIIIIIlll, lllllllllllllIllIIIIlIlIIIIIlIIl, lllllllllllllIllIIIIlIlIIIIIlllI);
        mergeSort(lllllllllllllIllIIIIlIlIIIIIIlIl, lllllllllllllIllIIIIlIlIIIIIlIIl, lllllllllllllIllIIIIlIlIIIIIllII, lllllllllllllIllIIIIlIlIIIIIlllI);
        if (lllllllllllllIllIIIIlIlIIIIIIlIl[lllllllllllllIllIIIIlIlIIIIIlIIl - 1] <= lllllllllllllIllIIIIlIlIIIIIIlIl[lllllllllllllIllIIIIlIlIIIIIlIIl]) {
            System.arraycopy(lllllllllllllIllIIIIlIlIIIIIIlIl, lllllllllllllIllIIIIlIlIIIIIIlll, lllllllllllllIllIIIIlIlIIIIIlllI, lllllllllllllIllIIIIlIlIIIIIIlll, lllllllllllllIllIIIIlIlIIIIIlIlI);
            return;
        }
        int lllllllllllllIllIIIIlIlIIIIlIIIl = lllllllllllllIllIIIIlIlIIIIIIlll;
        int lllllllllllllIllIIIIlIlIIIIlIIII = lllllllllllllIllIIIIlIlIIIIIIlll;
        int lllllllllllllIllIIIIlIlIIIIIllll = lllllllllllllIllIIIIlIlIIIIIlIIl;
        while (lllllllllllllIllIIIIlIlIIIIlIIIl < lllllllllllllIllIIIIlIlIIIIIllII) {
            if (lllllllllllllIllIIIIlIlIIIIIllll >= lllllllllllllIllIIIIlIlIIIIIllII || (lllllllllllllIllIIIIlIlIIIIlIIII < lllllllllllllIllIIIIlIlIIIIIlIIl && lllllllllllllIllIIIIlIlIIIIIIlIl[lllllllllllllIllIIIIlIlIIIIlIIII] <= lllllllllllllIllIIIIlIlIIIIIIlIl[lllllllllllllIllIIIIlIlIIIIIllll])) {
                lllllllllllllIllIIIIlIlIIIIIlllI[lllllllllllllIllIIIIlIlIIIIlIIIl] = lllllllllllllIllIIIIlIlIIIIIIlIl[lllllllllllllIllIIIIlIlIIIIlIIII++];
            }
            else {
                lllllllllllllIllIIIIlIlIIIIIlllI[lllllllllllllIllIIIIlIlIIIIlIIIl] = lllllllllllllIllIIIIlIlIIIIIIlIl[lllllllllllllIllIIIIlIlIIIIIllll++];
            }
            ++lllllllllllllIllIIIIlIlIIIIlIIIl;
        }
    }
    
    private static int med3(final int[] lllllllllllllIllIIIIllIIIllIllll, final int lllllllllllllIllIIIIllIIIlllIllI, final int lllllllllllllIllIIIIllIIIllIllIl, final int lllllllllllllIllIIIIllIIIllIllII, final IntComparator lllllllllllllIllIIIIllIIIllIlIll) {
        final int lllllllllllllIllIIIIllIIIlllIIlI = lllllllllllllIllIIIIllIIIllIlIll.compare(lllllllllllllIllIIIIllIIIllIllll[lllllllllllllIllIIIIllIIIlllIllI], lllllllllllllIllIIIIllIIIllIllll[lllllllllllllIllIIIIllIIIllIllIl]);
        final int lllllllllllllIllIIIIllIIIlllIIIl = lllllllllllllIllIIIIllIIIllIlIll.compare(lllllllllllllIllIIIIllIIIllIllll[lllllllllllllIllIIIIllIIIlllIllI], lllllllllllllIllIIIIllIIIllIllll[lllllllllllllIllIIIIllIIIllIllII]);
        final int lllllllllllllIllIIIIllIIIlllIIII = lllllllllllllIllIIIIllIIIllIlIll.compare(lllllllllllllIllIIIIllIIIllIllll[lllllllllllllIllIIIIllIIIllIllIl], lllllllllllllIllIIIIllIIIllIllll[lllllllllllllIllIIIIllIIIllIllII]);
        return (lllllllllllllIllIIIIllIIIlllIIlI < 0) ? ((lllllllllllllIllIIIIllIIIlllIIII < 0) ? lllllllllllllIllIIIIllIIIllIllIl : ((lllllllllllllIllIIIIllIIIlllIIIl < 0) ? lllllllllllllIllIIIIllIIIllIllII : lllllllllllllIllIIIIllIIIlllIllI)) : ((lllllllllllllIllIIIIllIIIlllIIII > 0) ? lllllllllllllIllIIIIllIIIllIllIl : ((lllllllllllllIllIIIIllIIIlllIIIl > 0) ? lllllllllllllIllIIIIllIIIllIllII : lllllllllllllIllIIIIllIIIlllIllI));
    }
    
    public static void stabilize(final int[] lllllllllllllIllIIIIlIlIlllIIIll, final int[] lllllllllllllIllIIIIlIlIlllIIIlI) {
        stabilize(lllllllllllllIllIIIIlIlIlllIIIll, lllllllllllllIllIIIIlIlIlllIIIlI, 0, lllllllllllllIllIIIIlIlIlllIIIll.length);
    }
    
    public static void parallelQuickSort(final int[] lllllllllllllIllIIIIlIllllllIIll, final IntComparator lllllllllllllIllIIIIlIllllllIIlI) {
        parallelQuickSort(lllllllllllllIllIIIIlIllllllIIll, 0, lllllllllllllIllIIIIlIllllllIIll.length, lllllllllllllIllIIIIlIllllllIIlI);
    }
    
    private static void insertionSortIndirect(final int[] lllllllllllllIllIIIIIlllllIIlIII, final int[] lllllllllllllIllIIIIIlllllIIllII, final int[] lllllllllllllIllIIIIIlllllIIIllI, final int lllllllllllllIllIIIIIlllllIIIlIl, final int lllllllllllllIllIIIIIlllllIIlIIl) {
        int lllllllllllllIllIIIIIlllllIIlllI = lllllllllllllIllIIIIIlllllIIIlIl;
        while (++lllllllllllllIllIIIIIlllllIIlllI < lllllllllllllIllIIIIIlllllIIlIIl) {
            final int lllllllllllllIllIIIIIlllllIlIIII = lllllllllllllIllIIIIIlllllIIlIII[lllllllllllllIllIIIIIlllllIIlllI];
            int lllllllllllllIllIIIIIlllllIIllll = lllllllllllllIllIIIIIlllllIIlllI;
            for (int lllllllllllllIllIIIIIlllllIlIIIl = lllllllllllllIllIIIIIlllllIIlIII[lllllllllllllIllIIIIIlllllIIllll - 1]; lllllllllllllIllIIIIIlllllIIllII[lllllllllllllIllIIIIIlllllIlIIII] < lllllllllllllIllIIIIIlllllIIllII[lllllllllllllIllIIIIIlllllIlIIIl] || (lllllllllllllIllIIIIIlllllIIllII[lllllllllllllIllIIIIIlllllIlIIII] == lllllllllllllIllIIIIIlllllIIllII[lllllllllllllIllIIIIIlllllIlIIIl] && lllllllllllllIllIIIIIlllllIIIllI[lllllllllllllIllIIIIIlllllIlIIII] < lllllllllllllIllIIIIIlllllIIIllI[lllllllllllllIllIIIIIlllllIlIIIl]); lllllllllllllIllIIIIIlllllIlIIIl = lllllllllllllIllIIIIIlllllIIlIII[--lllllllllllllIllIIIIIlllllIIllll - 1]) {
                lllllllllllllIllIIIIIlllllIIlIII[lllllllllllllIllIIIIIlllllIIllll] = lllllllllllllIllIIIIIlllllIlIIIl;
                if (lllllllllllllIllIIIIIlllllIIIlIl == lllllllllllllIllIIIIIlllllIIllll - 1) {
                    --lllllllllllllIllIIIIIlllllIIllll;
                    break;
                }
            }
            lllllllllllllIllIIIIIlllllIIlIII[lllllllllllllIllIIIIIlllllIIllll] = lllllllllllllIllIIIIIlllllIlIIII;
        }
    }
    
    public static void parallelQuickSort(final int[] lllllllllllllIllIIIIllIIIIIIIIII, final int lllllllllllllIllIIIIlIllllllllll, final int lllllllllllllIllIIIIlIlllllllllI, final IntComparator lllllllllllllIllIIIIlIllllllllIl) {
        if (lllllllllllllIllIIIIlIlllllllllI - lllllllllllllIllIIIIlIllllllllll < 8192) {
            quickSort(lllllllllllllIllIIIIllIIIIIIIIII, lllllllllllllIllIIIIlIllllllllll, lllllllllllllIllIIIIlIlllllllllI, lllllllllllllIllIIIIlIllllllllIl);
        }
        else {
            final ForkJoinPool lllllllllllllIllIIIIllIIIIIIIIIl = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            lllllllllllllIllIIIIllIIIIIIIIIl.invoke((ForkJoinTask<Object>)new ForkJoinQuickSortComp(lllllllllllllIllIIIIllIIIIIIIIII, lllllllllllllIllIIIIlIllllllllll, lllllllllllllIllIIIIlIlllllllllI, lllllllllllllIllIIIIlIllllllllIl));
            lllllllllllllIllIIIIllIIIIIIIIIl.shutdown();
        }
    }
    
    public static void mergeSort(final int[] lllllllllllllIllIIIIlIIlllIlIIIl, final int lllllllllllllIllIIIIlIIlllIlIIII, final int lllllllllllllIllIIIIlIIlllIIllll, final IntComparator lllllllllllllIllIIIIlIIlllIIlllI) {
        mergeSort(lllllllllllllIllIIIIlIIlllIlIIIl, lllllllllllllIllIIIIlIIlllIlIIII, lllllllllllllIllIIIIlIIlllIIllll, lllllllllllllIllIIIIlIIlllIIlllI, lllllllllllllIllIIIIlIIlllIlIIIl.clone());
    }
    
    public static void radixSort(final int[] lllllllllllllIllIIIIlIIlIlIIIIll, final int lllllllllllllIllIIIIlIIlIlIIIIlI, final int lllllllllllllIllIIIIlIIlIIllIllI) {
        if (lllllllllllllIllIIIIlIIlIIllIllI - lllllllllllllIllIIIIlIIlIlIIIIlI < 1024) {
            quickSort(lllllllllllllIllIIIIlIIlIlIIIIll, lllllllllllllIllIIIIlIIlIlIIIIlI, lllllllllllllIllIIIIlIIlIIllIllI);
            return;
        }
        final int lllllllllllllIllIIIIlIIlIlIIIIII = 3;
        final int lllllllllllllIllIIIIlIIlIIllllll = 766;
        int lllllllllllllIllIIIIlIIlIIlllllI = 0;
        final int[] lllllllllllllIllIIIIlIIlIIllllIl = new int[766];
        final int[] lllllllllllllIllIIIIlIIlIIllllII = new int[766];
        final int[] lllllllllllllIllIIIIlIIlIIlllIll = new int[766];
        lllllllllllllIllIIIIlIIlIIllllII[lllllllllllllIllIIIIlIIlIIlllllI] = lllllllllllllIllIIIIlIIlIIllIllI - (lllllllllllllIllIIIIlIIlIIllllIl[lllllllllllllIllIIIIlIIlIIlllllI] = lllllllllllllIllIIIIlIIlIlIIIIlI);
        lllllllllllllIllIIIIlIIlIIlllIll[lllllllllllllIllIIIIlIIlIIlllllI++] = 0;
        final int[] lllllllllllllIllIIIIlIIlIIlllIlI = new int[256];
        final int[] lllllllllllllIllIIIIlIIlIIlllIIl = new int[256];
        while (lllllllllllllIllIIIIlIIlIIlllllI > 0) {
            final int lllllllllllllIllIIIIlIIlIlIIlIlI = lllllllllllllIllIIIIlIIlIIllllIl[--lllllllllllllIllIIIIlIIlIIlllllI];
            final int lllllllllllllIllIIIIlIIlIlIIlIIl = lllllllllllllIllIIIIlIIlIIllllII[lllllllllllllIllIIIIlIIlIIlllllI];
            final int lllllllllllllIllIIIIlIIlIlIIlIII = lllllllllllllIllIIIIlIIlIIlllIll[lllllllllllllIllIIIIlIIlIIlllllI];
            final int lllllllllllllIllIIIIlIIlIlIIIlll = (lllllllllllllIllIIIIlIIlIlIIlIII % 4 == 0) ? 128 : 0;
            final int lllllllllllllIllIIIIlIIlIlIIIllI = (3 - lllllllllllllIllIIIIlIIlIlIIlIII % 4) * 8;
            int lllllllllllllIllIIIIlIIlIlIlIIlI = lllllllllllllIllIIIIlIIlIlIIlIlI + lllllllllllllIllIIIIlIIlIlIIlIIl;
            while (lllllllllllllIllIIIIlIIlIlIlIIlI-- != lllllllllllllIllIIIIlIIlIlIIlIlI) {
                final int[] array = lllllllllllllIllIIIIlIIlIIlllIlI;
                final int n = (lllllllllllllIllIIIIlIIlIlIIIIll[lllllllllllllIllIIIIlIIlIlIlIIlI] >>> lllllllllllllIllIIIIlIIlIlIIIllI & 0xFF) ^ lllllllllllllIllIIIIlIIlIlIIIlll;
                ++array[n];
            }
            int lllllllllllllIllIIIIlIIlIlIIIlIl = -1;
            int lllllllllllllIllIIIIlIIlIlIlIIIl = 0;
            int lllllllllllllIllIIIIlIIlIlIlIIII = lllllllllllllIllIIIIlIIlIlIIlIlI;
            while (lllllllllllllIllIIIIlIIlIlIlIIIl < 256) {
                if (lllllllllllllIllIIIIlIIlIIlllIlI[lllllllllllllIllIIIIlIIlIlIlIIIl] != 0) {
                    lllllllllllllIllIIIIlIIlIlIIIlIl = lllllllllllllIllIIIIlIIlIlIlIIIl;
                }
                lllllllllllllIllIIIIlIIlIlIlIIII = (lllllllllllllIllIIIIlIIlIIlllIIl[lllllllllllllIllIIIIlIIlIlIlIIIl] = lllllllllllllIllIIIIlIIlIlIlIIII + lllllllllllllIllIIIIlIIlIIlllIlI[lllllllllllllIllIIIIlIIlIlIlIIIl]);
                ++lllllllllllllIllIIIIlIIlIlIlIIIl;
            }
            for (int lllllllllllllIllIIIIlIIlIlIIIlII = lllllllllllllIllIIIIlIIlIlIIlIlI + lllllllllllllIllIIIIlIIlIlIIlIIl - lllllllllllllIllIIIIlIIlIIlllIlI[lllllllllllllIllIIIIlIIlIlIIIlIl], lllllllllllllIllIIIIlIIlIlIIllII = lllllllllllllIllIIIIlIIlIlIIlIlI, lllllllllllllIllIIIIlIIlIlIIlIll = -1; lllllllllllllIllIIIIlIIlIlIIllII <= lllllllllllllIllIIIIlIIlIlIIIlII; lllllllllllllIllIIIIlIIlIlIIllII += lllllllllllllIllIIIIlIIlIIlllIlI[lllllllllllllIllIIIIlIIlIlIIlIll], lllllllllllllIllIIIIlIIlIIlllIlI[lllllllllllllIllIIIIlIIlIlIIlIll] = 0) {
                int lllllllllllllIllIIIIlIIlIlIIllIl = lllllllllllllIllIIIIlIIlIlIIIIll[lllllllllllllIllIIIIlIIlIlIIllII];
                lllllllllllllIllIIIIlIIlIlIIlIll = ((lllllllllllllIllIIIIlIIlIlIIllIl >>> lllllllllllllIllIIIIlIIlIlIIIllI & 0xFF) ^ lllllllllllllIllIIIIlIIlIlIIIlll);
                if (lllllllllllllIllIIIIlIIlIlIIllII < lllllllllllllIllIIIIlIIlIlIIIlII) {
                    while (true) {
                        final int[] array2 = lllllllllllllIllIIIIlIIlIIlllIIl;
                        final int n2 = lllllllllllllIllIIIIlIIlIlIIlIll;
                        final int n3 = array2[n2] - 1;
                        array2[n2] = n3;
                        final int lllllllllllllIllIIIIlIIlIlIIlllI;
                        if ((lllllllllllllIllIIIIlIIlIlIIlllI = n3) <= lllllllllllllIllIIIIlIIlIlIIllII) {
                            break;
                        }
                        final int lllllllllllllIllIIIIlIIlIlIIllll = lllllllllllllIllIIIIlIIlIlIIllIl;
                        lllllllllllllIllIIIIlIIlIlIIllIl = lllllllllllllIllIIIIlIIlIlIIIIll[lllllllllllllIllIIIIlIIlIlIIlllI];
                        lllllllllllllIllIIIIlIIlIlIIIIll[lllllllllllllIllIIIIlIIlIlIIlllI] = lllllllllllllIllIIIIlIIlIlIIllll;
                        lllllllllllllIllIIIIlIIlIlIIlIll = ((lllllllllllllIllIIIIlIIlIlIIllIl >>> lllllllllllllIllIIIIlIIlIlIIIllI & 0xFF) ^ lllllllllllllIllIIIIlIIlIlIIIlll);
                    }
                    lllllllllllllIllIIIIlIIlIlIIIIll[lllllllllllllIllIIIIlIIlIlIIllII] = lllllllllllllIllIIIIlIIlIlIIllIl;
                }
                if (lllllllllllllIllIIIIlIIlIlIIlIII < 3 && lllllllllllllIllIIIIlIIlIIlllIlI[lllllllllllllIllIIIIlIIlIlIIlIll] > 1) {
                    if (lllllllllllllIllIIIIlIIlIIlllIlI[lllllllllllllIllIIIIlIIlIlIIlIll] < 1024) {
                        quickSort(lllllllllllllIllIIIIlIIlIlIIIIll, lllllllllllllIllIIIIlIIlIlIIllII, lllllllllllllIllIIIIlIIlIlIIllII + lllllllllllllIllIIIIlIIlIIlllIlI[lllllllllllllIllIIIIlIIlIlIIlIll]);
                    }
                    else {
                        lllllllllllllIllIIIIlIIlIIllllIl[lllllllllllllIllIIIIlIIlIIlllllI] = lllllllllllllIllIIIIlIIlIlIIllII;
                        lllllllllllllIllIIIIlIIlIIllllII[lllllllllllllIllIIIIlIIlIIlllllI] = lllllllllllllIllIIIIlIIlIIlllIlI[lllllllllllllIllIIIIlIIlIlIIlIll];
                        lllllllllllllIllIIIIlIIlIIlllIll[lllllllllllllIllIIIIlIIlIIlllllI++] = lllllllllllllIllIIIIlIIlIlIIlIII + 1;
                    }
                }
            }
        }
    }
    
    public static int[] shuffle(final int[] lllllllllllllIllIIIIIllIllIlIlII, final int lllllllllllllIllIIIIIllIllIlIIll, final int lllllllllllllIllIIIIIllIllIlIIlI, final Random lllllllllllllIllIIIIIllIllIlIIIl) {
        int lllllllllllllIllIIIIIllIllIlIlIl = lllllllllllllIllIIIIIllIllIlIIlI - lllllllllllllIllIIIIIllIllIlIIll;
        while (lllllllllllllIllIIIIIllIllIlIlIl-- != 0) {
            final int lllllllllllllIllIIIIIllIllIlIlll = lllllllllllllIllIIIIIllIllIlIIIl.nextInt(lllllllllllllIllIIIIIllIllIlIlIl + 1);
            final int lllllllllllllIllIIIIIllIllIlIllI = lllllllllllllIllIIIIIllIllIlIlII[lllllllllllllIllIIIIIllIllIlIIll + lllllllllllllIllIIIIIllIllIlIlIl];
            lllllllllllllIllIIIIIllIllIlIlII[lllllllllllllIllIIIIIllIllIlIIll + lllllllllllllIllIIIIIllIllIlIlIl] = lllllllllllllIllIIIIIllIllIlIlII[lllllllllllllIllIIIIIllIllIlIIll + lllllllllllllIllIIIIIllIllIlIlll];
            lllllllllllllIllIIIIIllIllIlIlII[lllllllllllllIllIIIIIllIllIlIIll + lllllllllllllIllIIIIIllIllIlIlll] = lllllllllllllIllIIIIIllIllIlIllI;
        }
        return lllllllllllllIllIIIIIllIllIlIlII;
    }
    
    public static void quickSort(final int[] lllllllllllllIllIIIIllIIIIlIlIII, final int lllllllllllllIllIIIIllIIIIlIIlll, final int lllllllllllllIllIIIIllIIIIIllIII, final IntComparator lllllllllllllIllIIIIllIIIIlIIlIl) {
        final int lllllllllllllIllIIIIllIIIIlIIlII = lllllllllllllIllIIIIllIIIIIllIII - lllllllllllllIllIIIIllIIIIlIIlll;
        if (lllllllllllllIllIIIIllIIIIlIIlII < 16) {
            selectionSort(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIlIIlll, lllllllllllllIllIIIIllIIIIIllIII, lllllllllllllIllIIIIllIIIIlIIlIl);
            return;
        }
        int lllllllllllllIllIIIIllIIIIlIIIll = lllllllllllllIllIIIIllIIIIlIIlll + lllllllllllllIllIIIIllIIIIlIIlII / 2;
        int lllllllllllllIllIIIIllIIIIlIIIlI = lllllllllllllIllIIIIllIIIIlIIlll;
        int lllllllllllllIllIIIIllIIIIlIIIIl = lllllllllllllIllIIIIllIIIIIllIII - 1;
        if (lllllllllllllIllIIIIllIIIIlIIlII > 128) {
            final int lllllllllllllIllIIIIllIIIIlIlIll = lllllllllllllIllIIIIllIIIIlIIlII / 8;
            lllllllllllllIllIIIIllIIIIlIIIlI = med3(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIlIIIlI, lllllllllllllIllIIIIllIIIIlIIIlI + lllllllllllllIllIIIIllIIIIlIlIll, lllllllllllllIllIIIIllIIIIlIIIlI + 2 * lllllllllllllIllIIIIllIIIIlIlIll, lllllllllllllIllIIIIllIIIIlIIlIl);
            lllllllllllllIllIIIIllIIIIlIIIll = med3(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIlIIIll - lllllllllllllIllIIIIllIIIIlIlIll, lllllllllllllIllIIIIllIIIIlIIIll, lllllllllllllIllIIIIllIIIIlIIIll + lllllllllllllIllIIIIllIIIIlIlIll, lllllllllllllIllIIIIllIIIIlIIlIl);
            lllllllllllllIllIIIIllIIIIlIIIIl = med3(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIlIIIIl - 2 * lllllllllllllIllIIIIllIIIIlIlIll, lllllllllllllIllIIIIllIIIIlIIIIl - lllllllllllllIllIIIIllIIIIlIlIll, lllllllllllllIllIIIIllIIIIlIIIIl, lllllllllllllIllIIIIllIIIIlIIlIl);
        }
        lllllllllllllIllIIIIllIIIIlIIIll = med3(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIlIIIlI, lllllllllllllIllIIIIllIIIIlIIIll, lllllllllllllIllIIIIllIIIIlIIIIl, lllllllllllllIllIIIIllIIIIlIIlIl);
        final int lllllllllllllIllIIIIllIIIIlIIIII = lllllllllllllIllIIIIllIIIIlIlIII[lllllllllllllIllIIIIllIIIIlIIIll];
        int lllllllllllllIllIIIIllIIIIIllllI;
        int lllllllllllllIllIIIIllIIIIIlllll = lllllllllllllIllIIIIllIIIIIllllI = lllllllllllllIllIIIIllIIIIlIIlll;
        int lllllllllllllIllIIIIllIIIIIlllII;
        int lllllllllllllIllIIIIllIIIIIlllIl = lllllllllllllIllIIIIllIIIIIlllII = lllllllllllllIllIIIIllIIIIIllIII - 1;
        while (true) {
            final int lllllllllllllIllIIIIllIIIIlIlIlI;
            if (lllllllllllllIllIIIIllIIIIIllllI <= lllllllllllllIllIIIIllIIIIIlllIl && (lllllllllllllIllIIIIllIIIIlIlIlI = lllllllllllllIllIIIIllIIIIlIIlIl.compare(lllllllllllllIllIIIIllIIIIlIlIII[lllllllllllllIllIIIIllIIIIIllllI], lllllllllllllIllIIIIllIIIIlIIIII)) <= 0) {
                if (lllllllllllllIllIIIIllIIIIlIlIlI == 0) {
                    swap(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIIlllll++, lllllllllllllIllIIIIllIIIIIllllI);
                }
                ++lllllllllllllIllIIIIllIIIIIllllI;
            }
            else {
                int lllllllllllllIllIIIIllIIIIlIlIIl;
                while (lllllllllllllIllIIIIllIIIIIlllIl >= lllllllllllllIllIIIIllIIIIIllllI && (lllllllllllllIllIIIIllIIIIlIlIIl = lllllllllllllIllIIIIllIIIIlIIlIl.compare(lllllllllllllIllIIIIllIIIIlIlIII[lllllllllllllIllIIIIllIIIIIlllIl], lllllllllllllIllIIIIllIIIIlIIIII)) >= 0) {
                    if (lllllllllllllIllIIIIllIIIIlIlIIl == 0) {
                        swap(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIIlllIl, lllllllllllllIllIIIIllIIIIIlllII--);
                    }
                    --lllllllllllllIllIIIIllIIIIIlllIl;
                }
                if (lllllllllllllIllIIIIllIIIIIllllI > lllllllllllllIllIIIIllIIIIIlllIl) {
                    break;
                }
                swap(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIIllllI++, lllllllllllllIllIIIIllIIIIIlllIl--);
            }
        }
        int lllllllllllllIllIIIIllIIIIIllIll = Math.min(lllllllllllllIllIIIIllIIIIIlllll - lllllllllllllIllIIIIllIIIIlIIlll, lllllllllllllIllIIIIllIIIIIllllI - lllllllllllllIllIIIIllIIIIIlllll);
        swap(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIlIIlll, lllllllllllllIllIIIIllIIIIIllllI - lllllllllllllIllIIIIllIIIIIllIll, lllllllllllllIllIIIIllIIIIIllIll);
        lllllllllllllIllIIIIllIIIIIllIll = Math.min(lllllllllllllIllIIIIllIIIIIlllII - lllllllllllllIllIIIIllIIIIIlllIl, lllllllllllllIllIIIIllIIIIIllIII - lllllllllllllIllIIIIllIIIIIlllII - 1);
        swap(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIIllllI, lllllllllllllIllIIIIllIIIIIllIII - lllllllllllllIllIIIIllIIIIIllIll, lllllllllllllIllIIIIllIIIIIllIll);
        if ((lllllllllllllIllIIIIllIIIIIllIll = lllllllllllllIllIIIIllIIIIIllllI - lllllllllllllIllIIIIllIIIIIlllll) > 1) {
            quickSort(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIlIIlll, lllllllllllllIllIIIIllIIIIlIIlll + lllllllllllllIllIIIIllIIIIIllIll, lllllllllllllIllIIIIllIIIIlIIlIl);
        }
        if ((lllllllllllllIllIIIIllIIIIIllIll = lllllllllllllIllIIIIllIIIIIlllII - lllllllllllllIllIIIIllIIIIIlllIl) > 1) {
            quickSort(lllllllllllllIllIIIIllIIIIlIlIII, lllllllllllllIllIIIIllIIIIIllIII - lllllllllllllIllIIIIllIIIIIllIll, lllllllllllllIllIIIIllIIIIIllIII, lllllllllllllIllIIIIllIIIIlIIlIl);
        }
    }
    
    public static void quickSort(final int[] lllllllllllllIllIIIIlIlIIllIIIll, final int[] lllllllllllllIllIIIIlIlIIllIIIlI, final int lllllllllllllIllIIIIlIlIIlllIIII, final int lllllllllllllIllIIIIlIlIIllIIIII) {
        final int lllllllllllllIllIIIIlIlIIllIlllI = lllllllllllllIllIIIIlIlIIllIIIII - lllllllllllllIllIIIIlIlIIlllIIII;
        if (lllllllllllllIllIIIIlIlIIllIlllI < 16) {
            selectionSort(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIlllIIII, lllllllllllllIllIIIIlIlIIllIIIII);
            return;
        }
        int lllllllllllllIllIIIIlIlIIllIllIl = lllllllllllllIllIIIIlIlIIlllIIII + lllllllllllllIllIIIIlIlIIllIlllI / 2;
        int lllllllllllllIllIIIIlIlIIllIllII = lllllllllllllIllIIIIlIlIIlllIIII;
        int lllllllllllllIllIIIIlIlIIllIlIll = lllllllllllllIllIIIIlIlIIllIIIII - 1;
        if (lllllllllllllIllIIIIlIlIIllIlllI > 128) {
            final int lllllllllllllIllIIIIlIlIIlllIlll = lllllllllllllIllIIIIlIlIIllIlllI / 8;
            lllllllllllllIllIIIIlIlIIllIllII = med3(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIllIllII, lllllllllllllIllIIIIlIlIIllIllII + lllllllllllllIllIIIIlIlIIlllIlll, lllllllllllllIllIIIIlIlIIllIllII + 2 * lllllllllllllIllIIIIlIlIIlllIlll);
            lllllllllllllIllIIIIlIlIIllIllIl = med3(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIllIllIl - lllllllllllllIllIIIIlIlIIlllIlll, lllllllllllllIllIIIIlIlIIllIllIl, lllllllllllllIllIIIIlIlIIllIllIl + lllllllllllllIllIIIIlIlIIlllIlll);
            lllllllllllllIllIIIIlIlIIllIlIll = med3(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIllIlIll - 2 * lllllllllllllIllIIIIlIlIIlllIlll, lllllllllllllIllIIIIlIlIIllIlIll - lllllllllllllIllIIIIlIlIIlllIlll, lllllllllllllIllIIIIlIlIIllIlIll);
        }
        lllllllllllllIllIIIIlIlIIllIllIl = med3(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIllIllII, lllllllllllllIllIIIIlIlIIllIllIl, lllllllllllllIllIIIIlIlIIllIlIll);
        final int lllllllllllllIllIIIIlIlIIllIlIlI = lllllllllllllIllIIIIlIlIIllIIIll[lllllllllllllIllIIIIlIlIIllIllIl];
        final int lllllllllllllIllIIIIlIlIIllIlIIl = lllllllllllllIllIIIIlIlIIllIIIlI[lllllllllllllIllIIIIlIlIIllIllIl];
        int lllllllllllllIllIIIIlIlIIllIIlll;
        int lllllllllllllIllIIIIlIlIIllIlIII = lllllllllllllIllIIIIlIlIIllIIlll = lllllllllllllIllIIIIlIlIIlllIIII;
        int lllllllllllllIllIIIIlIlIIllIIlIl;
        int lllllllllllllIllIIIIlIlIIllIIllI = lllllllllllllIllIIIIlIlIIllIIlIl = lllllllllllllIllIIIIlIlIIllIIIII - 1;
        while (true) {
            final int lllllllllllllIllIIIIlIlIIlllIlIl;
            final int lllllllllllllIllIIIIlIlIIlllIllI;
            if (lllllllllllllIllIIIIlIlIIllIIlll <= lllllllllllllIllIIIIlIlIIllIIllI && (lllllllllllllIllIIIIlIlIIlllIllI = (((lllllllllllllIllIIIIlIlIIlllIlIl = Integer.compare(lllllllllllllIllIIIIlIlIIllIIIll[lllllllllllllIllIIIIlIlIIllIIlll], lllllllllllllIllIIIIlIlIIllIlIlI)) == 0) ? Integer.compare(lllllllllllllIllIIIIlIlIIllIIIlI[lllllllllllllIllIIIIlIlIIllIIlll], lllllllllllllIllIIIIlIlIIllIlIIl) : lllllllllllllIllIIIIlIlIIlllIlIl)) <= 0) {
                if (lllllllllllllIllIIIIlIlIIlllIllI == 0) {
                    swap(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIllIlIII++, lllllllllllllIllIIIIlIlIIllIIlll);
                }
                ++lllllllllllllIllIIIIlIlIIllIIlll;
            }
            else {
                int lllllllllllllIllIIIIlIlIIlllIIll;
                int lllllllllllllIllIIIIlIlIIlllIlII;
                while (lllllllllllllIllIIIIlIlIIllIIllI >= lllllllllllllIllIIIIlIlIIllIIlll && (lllllllllllllIllIIIIlIlIIlllIlII = (((lllllllllllllIllIIIIlIlIIlllIIll = Integer.compare(lllllllllllllIllIIIIlIlIIllIIIll[lllllllllllllIllIIIIlIlIIllIIllI], lllllllllllllIllIIIIlIlIIllIlIlI)) == 0) ? Integer.compare(lllllllllllllIllIIIIlIlIIllIIIlI[lllllllllllllIllIIIIlIlIIllIIllI], lllllllllllllIllIIIIlIlIIllIlIIl) : lllllllllllllIllIIIIlIlIIlllIIll)) >= 0) {
                    if (lllllllllllllIllIIIIlIlIIlllIlII == 0) {
                        swap(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIllIIllI, lllllllllllllIllIIIIlIlIIllIIlIl--);
                    }
                    --lllllllllllllIllIIIIlIlIIllIIllI;
                }
                if (lllllllllllllIllIIIIlIlIIllIIlll > lllllllllllllIllIIIIlIlIIllIIllI) {
                    break;
                }
                swap(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIllIIlll++, lllllllllllllIllIIIIlIlIIllIIllI--);
            }
        }
        int lllllllllllllIllIIIIlIlIIllIIlII = Math.min(lllllllllllllIllIIIIlIlIIllIlIII - lllllllllllllIllIIIIlIlIIlllIIII, lllllllllllllIllIIIIlIlIIllIIlll - lllllllllllllIllIIIIlIlIIllIlIII);
        swap(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIlllIIII, lllllllllllllIllIIIIlIlIIllIIlll - lllllllllllllIllIIIIlIlIIllIIlII, lllllllllllllIllIIIIlIlIIllIIlII);
        lllllllllllllIllIIIIlIlIIllIIlII = Math.min(lllllllllllllIllIIIIlIlIIllIIlIl - lllllllllllllIllIIIIlIlIIllIIllI, lllllllllllllIllIIIIlIlIIllIIIII - lllllllllllllIllIIIIlIlIIllIIlIl - 1);
        swap(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIllIIlll, lllllllllllllIllIIIIlIlIIllIIIII - lllllllllllllIllIIIIlIlIIllIIlII, lllllllllllllIllIIIIlIlIIllIIlII);
        if ((lllllllllllllIllIIIIlIlIIllIIlII = lllllllllllllIllIIIIlIlIIllIIlll - lllllllllllllIllIIIIlIlIIllIlIII) > 1) {
            quickSort(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIlllIIII, lllllllllllllIllIIIIlIlIIlllIIII + lllllllllllllIllIIIIlIlIIllIIlII);
        }
        if ((lllllllllllllIllIIIIlIlIIllIIlII = lllllllllllllIllIIIIlIlIIllIIlIl - lllllllllllllIllIIIIlIlIIllIIllI) > 1) {
            quickSort(lllllllllllllIllIIIIlIlIIllIIIll, lllllllllllllIllIIIIlIlIIllIIIlI, lllllllllllllIllIIIIlIlIIllIIIII - lllllllllllllIllIIIIlIlIIllIIlII, lllllllllllllIllIIIIlIlIIllIIIII);
        }
    }
    
    private static void insertionSortIndirect(final int[] lllllllllllllIllIIIIlIllIlIIIlll, final int[] lllllllllllllIllIIIIlIllIlIIIllI, final int lllllllllllllIllIIIIlIllIlIIlIIl, final int lllllllllllllIllIIIIlIllIlIIlIII) {
        int lllllllllllllIllIIIIlIllIlIIllII = lllllllllllllIllIIIIlIllIlIIlIIl;
        while (++lllllllllllllIllIIIIlIllIlIIllII < lllllllllllllIllIIIIlIllIlIIlIII) {
            final int lllllllllllllIllIIIIlIllIlIIlllI = lllllllllllllIllIIIIlIllIlIIIlll[lllllllllllllIllIIIIlIllIlIIllII];
            int lllllllllllllIllIIIIlIllIlIIllIl = lllllllllllllIllIIIIlIllIlIIllII;
            for (int lllllllllllllIllIIIIlIllIlIIllll = lllllllllllllIllIIIIlIllIlIIIlll[lllllllllllllIllIIIIlIllIlIIllIl - 1]; lllllllllllllIllIIIIlIllIlIIIllI[lllllllllllllIllIIIIlIllIlIIlllI] < lllllllllllllIllIIIIlIllIlIIIllI[lllllllllllllIllIIIIlIllIlIIllll]; lllllllllllllIllIIIIlIllIlIIllll = lllllllllllllIllIIIIlIllIlIIIlll[--lllllllllllllIllIIIIlIllIlIIllIl - 1]) {
                lllllllllllllIllIIIIlIllIlIIIlll[lllllllllllllIllIIIIlIllIlIIllIl] = lllllllllllllIllIIIIlIllIlIIllll;
                if (lllllllllllllIllIIIIlIllIlIIlIIl == lllllllllllllIllIIIIlIllIlIIllIl - 1) {
                    --lllllllllllllIllIIIIlIllIlIIllIl;
                    break;
                }
            }
            lllllllllllllIllIIIIlIllIlIIIlll[lllllllllllllIllIIIIlIllIlIIllIl] = lllllllllllllIllIIIIlIllIlIIlllI;
        }
    }
    
    public static int[] grow(final int[] lllllllllllllIllIIIIllIIllllIllI, final int lllllllllllllIllIIIIllIIlllllIII, final int lllllllllllllIllIIIIllIIllllIlll) {
        if (lllllllllllllIllIIIIllIIlllllIII > lllllllllllllIllIIIIllIIllllIllI.length) {
            final int lllllllllllllIllIIIIllIIlllllIll = (int)Math.max(Math.min(lllllllllllllIllIIIIllIIllllIllI.length + (long)(lllllllllllllIllIIIIllIIllllIllI.length >> 1), 2147483639L), lllllllllllllIllIIIIllIIlllllIII);
            final int[] lllllllllllllIllIIIIllIIlllllIlI = new int[lllllllllllllIllIIIIllIIlllllIll];
            System.arraycopy(lllllllllllllIllIIIIllIIllllIllI, 0, lllllllllllllIllIIIIllIIlllllIlI, 0, lllllllllllllIllIIIIllIIllllIlll);
            return lllllllllllllIllIIIIllIIlllllIlI;
        }
        return lllllllllllllIllIIIIllIIllllIllI;
    }
    
    public static void parallelRadixSort(final int[] lllllllllllllIllIIIIIllllllllIlI, final int[] lllllllllllllIllIIIIIllllllllIIl, final int lllllllllllllIllIIIIIllllllllIII, final int lllllllllllllIllIIIIIllllllIlIll) {
        if (lllllllllllllIllIIIIIllllllIlIll - lllllllllllllIllIIIIIllllllllIII < 1024) {
            quickSort(lllllllllllllIllIIIIIllllllllIlI, lllllllllllllIllIIIIIllllllllIIl, lllllllllllllIllIIIIIllllllllIII, lllllllllllllIllIIIIIllllllIlIll);
            return;
        }
        final int lllllllllllllIllIIIIIlllllllIllI = 2;
        if (lllllllllllllIllIIIIIllllllllIlI.length != lllllllllllllIllIIIIIllllllllIIl.length) {
            throw new IllegalArgumentException("Array size mismatch.");
        }
        final int lllllllllllllIllIIIIIlllllllIlIl = 7;
        final LinkedBlockingQueue<Segment> lllllllllllllIllIIIIIlllllllIlII = new LinkedBlockingQueue<Segment>();
        lllllllllllllIllIIIIIlllllllIlII.add(new Segment(lllllllllllllIllIIIIIllllllllIII, lllllllllllllIllIIIIIllllllIlIll - lllllllllllllIllIIIIIllllllllIII, 0));
        final AtomicInteger lllllllllllllIllIIIIIlllllllIIll = new AtomicInteger(1);
        final int lllllllllllllIllIIIIIlllllllIIlI = Runtime.getRuntime().availableProcessors();
        final ExecutorService lllllllllllllIllIIIIIlllllllIIIl = Executors.newFixedThreadPool(lllllllllllllIllIIIIIlllllllIIlI, Executors.defaultThreadFactory());
        final ExecutorCompletionService<Void> lllllllllllllIllIIIIIlllllllIIII = new ExecutorCompletionService<Void>(lllllllllllllIllIIIIIlllllllIIIl);
        int lllllllllllllIllIIIIIlllllllllIl = lllllllllllllIllIIIIIlllllllIIlI;
        while (lllllllllllllIllIIIIIlllllllllIl-- != 0) {
            final int[] lllllllllllllIllIIIIIllIIllIllII;
            final int[] lllllllllllllIllIIIIIllIIllIlIll;
            final AtomicInteger atomicInteger;
            final int n;
            int lllllllllllllIllIIIIIllIlIIIIlIl;
            final Object o;
            final LinkedBlockingQueue<Segment> linkedBlockingQueue;
            Segment lllllllllllllIllIIIIIllIIllllIlI;
            int lllllllllllllIllIIIIIllIIllllIIl;
            int lllllllllllllIllIIIIIllIIllllIII;
            int lllllllllllllIllIIIIIllIIlllIlll;
            int lllllllllllllIllIIIIIllIIlllIllI;
            int[] lllllllllllllIllIIIIIllIIlllIlIl;
            int lllllllllllllIllIIIIIllIIlllIlII;
            int lllllllllllllIllIIIIIllIlIIIIlII;
            final Object o2;
            int n2;
            final Object o3;
            int lllllllllllllIllIIIIIllIIlllIIll;
            int lllllllllllllIllIIIIIllIlIIIIIll;
            int lllllllllllllIllIIIIIllIlIIIIIlI;
            final Object o4;
            final int n3;
            int lllllllllllllIllIIIIIllIIlllIIlI;
            int lllllllllllllIllIIIIIllIIlllllII;
            int lllllllllllllIllIIIIIllIIllllIll;
            int lllllllllllllIllIIIIIllIIllllllI;
            int lllllllllllllIllIIIIIllIIlllllIl;
            int lllllllllllllIllIIIIIllIIllllIll2;
            final Object o5;
            final int n5;
            int n4;
            int lllllllllllllIllIIIIIllIIlllllll;
            int lllllllllllllIllIIIIIllIlIIIIIIl;
            int lllllllllllllIllIIIIIllIlIIIIIII;
            lllllllllllllIllIIIIIlllllllIIII.submit(() -> {
                lllllllllllllIllIIIIIllIIllIllII = new int[256];
                lllllllllllllIllIIIIIllIIllIlIll = new int[256];
                while (true) {
                    if (atomicInteger.get() == 0) {
                        lllllllllllllIllIIIIIllIlIIIIlIl = n;
                        while (true) {
                            lllllllllllllIllIIIIIllIlIIIIlIl--;
                            if (o != 0) {
                                linkedBlockingQueue.add(IntArrays.POISON_PILL);
                            }
                            else {
                                break;
                            }
                        }
                    }
                    lllllllllllllIllIIIIIllIIllllIlI = linkedBlockingQueue.take();
                    if (lllllllllllllIllIIIIIllIIllllIlI == IntArrays.POISON_PILL) {
                        break;
                    }
                    else {
                        lllllllllllllIllIIIIIllIIllllIIl = lllllllllllllIllIIIIIllIIllllIlI.offset;
                        lllllllllllllIllIIIIIllIIllllIII = lllllllllllllIllIIIIIllIIllllIlI.length;
                        lllllllllllllIllIIIIIllIIlllIlll = lllllllllllllIllIIIIIllIIllllIlI.level;
                        lllllllllllllIllIIIIIllIIlllIllI = ((lllllllllllllIllIIIIIllIIlllIlll % 4 == 0) ? 128 : 0);
                        lllllllllllllIllIIIIIllIIlllIlIl = ((lllllllllllllIllIIIIIllIIlllIlll < 4) ? lllllllllllllIllIIIIIllllllllIlI : lllllllllllllIllIIIIIllllllllIIl);
                        lllllllllllllIllIIIIIllIIlllIlII = (3 - lllllllllllllIllIIIIIllIIlllIlll % 4) * 8;
                        lllllllllllllIllIIIIIllIlIIIIlII = lllllllllllllIllIIIIIllIIllllIIl + lllllllllllllIllIIIIIllIIllllIII;
                        while (true) {
                            lllllllllllllIllIIIIIllIlIIIIlII--;
                            if (o2 != lllllllllllllIllIIIIIllIIllllIIl) {
                                n2 = ((lllllllllllllIllIIIIIllIIlllIlIl[lllllllllllllIllIIIIIllIlIIIIlII] >>> lllllllllllllIllIIIIIllIIlllIlII & 0xFF) ^ lllllllllllllIllIIIIIllIIlllIllI);
                                ++o3[n2];
                            }
                            else {
                                break;
                            }
                        }
                        lllllllllllllIllIIIIIllIIlllIIll = -1;
                        lllllllllllllIllIIIIIllIlIIIIIll = 0;
                        lllllllllllllIllIIIIIllIlIIIIIlI = lllllllllllllIllIIIIIllIIllllIIl;
                        while (lllllllllllllIllIIIIIllIlIIIIIll < 256) {
                            if (lllllllllllllIllIIIIIllIIllIllII[lllllllllllllIllIIIIIllIlIIIIIll] != 0) {
                                lllllllllllllIllIIIIIllIIlllIIll = lllllllllllllIllIIIIIllIlIIIIIll;
                            }
                            lllllllllllllIllIIIIIllIlIIIIIlI = (o4[n3] = lllllllllllllIllIIIIIllIlIIIIIlI + lllllllllllllIllIIIIIllIIllIllII[lllllllllllllIllIIIIIllIlIIIIIll]);
                            ++lllllllllllllIllIIIIIllIlIIIIIll;
                        }
                        for (lllllllllllllIllIIIIIllIIlllIIlI = lllllllllllllIllIIIIIllIIllllIIl + lllllllllllllIllIIIIIllIIllllIII - lllllllllllllIllIIIIIllIIllIllII[lllllllllllllIllIIIIIllIIlllIIll], lllllllllllllIllIIIIIllIIlllllII = lllllllllllllIllIIIIIllIIllllIIl, lllllllllllllIllIIIIIllIIllllIll = -1; lllllllllllllIllIIIIIllIIlllllII <= lllllllllllllIllIIIIIllIIlllIIlI; lllllllllllllIllIIIIIllIIlllllII += lllllllllllllIllIIIIIllIIllIllII[lllllllllllllIllIIIIIllIIllllIll2], lllllllllllllIllIIIIIllIIllIllII[lllllllllllllIllIIIIIllIIllllIll2] = 0) {
                            lllllllllllllIllIIIIIllIIllllllI = lllllllllllllIllIIIIIllllllllIlI[lllllllllllllIllIIIIIllIIlllllII];
                            lllllllllllllIllIIIIIllIIlllllIl = lllllllllllllIllIIIIIllllllllIIl[lllllllllllllIllIIIIIllIIlllllII];
                            lllllllllllllIllIIIIIllIIllllIll2 = ((lllllllllllllIllIIIIIllIIlllIlIl[lllllllllllllIllIIIIIllIIlllllII] >>> lllllllllllllIllIIIIIllIIlllIlII & 0xFF) ^ lllllllllllllIllIIIIIllIIlllIllI);
                            if (lllllllllllllIllIIIIIllIIlllllII < lllllllllllllIllIIIIIllIIlllIIlI) {
                                while (true) {
                                    n4 = o5[n5] - 1;
                                    o5[n5] = n4;
                                    if ((lllllllllllllIllIIIIIllIIlllllll = n4) > lllllllllllllIllIIIIIllIIlllllII) {
                                        lllllllllllllIllIIIIIllIIllllIll2 = ((lllllllllllllIllIIIIIllIIlllIlIl[lllllllllllllIllIIIIIllIIlllllll] >>> lllllllllllllIllIIIIIllIIlllIlII & 0xFF) ^ lllllllllllllIllIIIIIllIIlllIllI);
                                        lllllllllllllIllIIIIIllIlIIIIIIl = lllllllllllllIllIIIIIllIIllllllI;
                                        lllllllllllllIllIIIIIllIlIIIIIII = lllllllllllllIllIIIIIllIIlllllIl;
                                        lllllllllllllIllIIIIIllIIllllllI = lllllllllllllIllIIIIIllllllllIlI[lllllllllllllIllIIIIIllIIlllllll];
                                        lllllllllllllIllIIIIIllIIlllllIl = lllllllllllllIllIIIIIllllllllIIl[lllllllllllllIllIIIIIllIIlllllll];
                                        lllllllllllllIllIIIIIllllllllIlI[lllllllllllllIllIIIIIllIIlllllll] = lllllllllllllIllIIIIIllIlIIIIIIl;
                                        lllllllllllllIllIIIIIllllllllIIl[lllllllllllllIllIIIIIllIIlllllll] = lllllllllllllIllIIIIIllIlIIIIIII;
                                    }
                                    else {
                                        break;
                                    }
                                }
                                lllllllllllllIllIIIIIllllllllIlI[lllllllllllllIllIIIIIllIIlllllII] = lllllllllllllIllIIIIIllIIllllllI;
                                lllllllllllllIllIIIIIllllllllIIl[lllllllllllllIllIIIIIllIIlllllII] = lllllllllllllIllIIIIIllIIlllllIl;
                            }
                            if (lllllllllllllIllIIIIIllIIlllIlll < 7 && lllllllllllllIllIIIIIllIIllIllII[lllllllllllllIllIIIIIllIIllllIll2] > 1) {
                                if (lllllllllllllIllIIIIIllIIllIllII[lllllllllllllIllIIIIIllIIllllIll2] < 1024) {
                                    quickSort(lllllllllllllIllIIIIIllllllllIlI, lllllllllllllIllIIIIIllllllllIIl, lllllllllllllIllIIIIIllIIlllllII, lllllllllllllIllIIIIIllIIlllllII + lllllllllllllIllIIIIIllIIllIllII[lllllllllllllIllIIIIIllIIllllIll2]);
                                }
                                else {
                                    atomicInteger.incrementAndGet();
                                    linkedBlockingQueue.add(new Segment(lllllllllllllIllIIIIIllIIlllllII, lllllllllllllIllIIIIIllIIllIllII[lllllllllllllIllIIIIIllIIllllIll2], lllllllllllllIllIIIIIllIIlllIlll + 1));
                                }
                            }
                        }
                        atomicInteger.decrementAndGet();
                    }
                }
                return null;
            });
        }
        Throwable lllllllllllllIllIIIIIllllllIllll = null;
        int lllllllllllllIllIIIIIllllllllIll = lllllllllllllIllIIIIIlllllllIIlI;
        while (lllllllllllllIllIIIIIllllllllIll-- != 0) {
            try {
                lllllllllllllIllIIIIIlllllllIIII.take().get();
            }
            catch (Exception lllllllllllllIllIIIIIlllllllllII) {
                lllllllllllllIllIIIIIllllllIllll = lllllllllllllIllIIIIIlllllllllII.getCause();
            }
        }
        lllllllllllllIllIIIIIlllllllIIIl.shutdown();
        if (lllllllllllllIllIIIIIllllllIllll != null) {
            throw (lllllllllllllIllIIIIIllllllIllll instanceof RuntimeException) ? lllllllllllllIllIIIIIllllllIllll : new RuntimeException(lllllllllllllIllIIIIIllllllIllll);
        }
    }
    
    public static void radixSort(final int[] lllllllllllllIllIIIIlIIIIllIIIIl, final int[] lllllllllllllIllIIIIlIIIIllIIIlI) {
        ensureSameLength(lllllllllllllIllIIIIlIIIIllIIIIl, lllllllllllllIllIIIIlIIIIllIIIlI);
        radixSort(lllllllllllllIllIIIIlIIIIllIIIIl, lllllllllllllIllIIIIlIIIIllIIIlI, 0, lllllllllllllIllIIIIlIIIIllIIIIl.length);
    }
    
    public static void parallelRadixSort(final int[] lllllllllllllIllIIIIlIIlIIIlIIlI, final int lllllllllllllIllIIIIlIIlIIIlIIIl, final int lllllllllllllIllIIIIlIIlIIIIIllI) {
        if (lllllllllllllIllIIIIlIIlIIIIIllI - lllllllllllllIllIIIIlIIlIIIlIIIl < 1024) {
            quickSort(lllllllllllllIllIIIIlIIlIIIlIIlI, lllllllllllllIllIIIIlIIlIIIlIIIl, lllllllllllllIllIIIIlIIlIIIIIllI);
            return;
        }
        final int lllllllllllllIllIIIIlIIlIIIIllll = 3;
        final LinkedBlockingQueue<Segment> lllllllllllllIllIIIIlIIlIIIIlllI = new LinkedBlockingQueue<Segment>();
        lllllllllllllIllIIIIlIIlIIIIlllI.add(new Segment(lllllllllllllIllIIIIlIIlIIIlIIIl, lllllllllllllIllIIIIlIIlIIIIIllI - lllllllllllllIllIIIIlIIlIIIlIIIl, 0));
        final AtomicInteger lllllllllllllIllIIIIlIIlIIIIllIl = new AtomicInteger(1);
        final int lllllllllllllIllIIIIlIIlIIIIllII = Runtime.getRuntime().availableProcessors();
        final ExecutorService lllllllllllllIllIIIIlIIlIIIIlIll = Executors.newFixedThreadPool(lllllllllllllIllIIIIlIIlIIIIllII, Executors.defaultThreadFactory());
        final ExecutorCompletionService<Void> lllllllllllllIllIIIIlIIlIIIIlIlI = new ExecutorCompletionService<Void>(lllllllllllllIllIIIIlIIlIIIIlIll);
        int lllllllllllllIllIIIIlIIlIIIlIlIl = lllllllllllllIllIIIIlIIlIIIIllII;
        while (lllllllllllllIllIIIIlIIlIIIlIlIl-- != 0) {
            final int[] lllllllllllllIllIIIIIlIllllIIIlI;
            final int[] lllllllllllllIllIIIIIlIllllIIIIl;
            final AtomicInteger atomicInteger;
            final int n;
            int lllllllllllllIllIIIIIlIlllllIlll;
            final Object o;
            final LinkedBlockingQueue<Segment> linkedBlockingQueue;
            Segment lllllllllllllIllIIIIIlIllllIlllI;
            int lllllllllllllIllIIIIIlIllllIllIl;
            int lllllllllllllIllIIIIIlIllllIllII;
            int lllllllllllllIllIIIIIlIllllIlIll;
            int lllllllllllllIllIIIIIlIllllIlIlI;
            int lllllllllllllIllIIIIIlIllllIlIIl;
            int lllllllllllllIllIIIIIlIlllllIllI;
            final Object o2;
            int n2;
            final Object o3;
            int lllllllllllllIllIIIIIlIllllIlIII;
            int lllllllllllllIllIIIIIlIlllllIlIl;
            int lllllllllllllIllIIIIIlIlllllIlII;
            final Object o4;
            final int n3;
            int lllllllllllllIllIIIIIlIllllIIlll;
            int lllllllllllllIllIIIIIlIlllllIIII;
            int lllllllllllllIllIIIIIlIllllIllll;
            int lllllllllllllIllIIIIIlIlllllIIIl;
            int lllllllllllllIllIIIIIlIllllIllll2;
            final Object o5;
            final int n5;
            int n4;
            int lllllllllllllIllIIIIIlIlllllIIlI;
            int lllllllllllllIllIIIIIlIlllllIIll;
            lllllllllllllIllIIIIlIIlIIIIlIlI.submit(() -> {
                lllllllllllllIllIIIIIlIllllIIIlI = new int[256];
                lllllllllllllIllIIIIIlIllllIIIIl = new int[256];
                while (true) {
                    if (atomicInteger.get() == 0) {
                        lllllllllllllIllIIIIIlIlllllIlll = n;
                        while (true) {
                            lllllllllllllIllIIIIIlIlllllIlll--;
                            if (o != 0) {
                                linkedBlockingQueue.add(IntArrays.POISON_PILL);
                            }
                            else {
                                break;
                            }
                        }
                    }
                    lllllllllllllIllIIIIIlIllllIlllI = linkedBlockingQueue.take();
                    if (lllllllllllllIllIIIIIlIllllIlllI == IntArrays.POISON_PILL) {
                        break;
                    }
                    else {
                        lllllllllllllIllIIIIIlIllllIllIl = lllllllllllllIllIIIIIlIllllIlllI.offset;
                        lllllllllllllIllIIIIIlIllllIllII = lllllllllllllIllIIIIIlIllllIlllI.length;
                        lllllllllllllIllIIIIIlIllllIlIll = lllllllllllllIllIIIIIlIllllIlllI.level;
                        lllllllllllllIllIIIIIlIllllIlIlI = ((lllllllllllllIllIIIIIlIllllIlIll % 4 == 0) ? 128 : 0);
                        lllllllllllllIllIIIIIlIllllIlIIl = (3 - lllllllllllllIllIIIIIlIllllIlIll % 4) * 8;
                        lllllllllllllIllIIIIIlIlllllIllI = lllllllllllllIllIIIIIlIllllIllIl + lllllllllllllIllIIIIIlIllllIllII;
                        while (true) {
                            lllllllllllllIllIIIIIlIlllllIllI--;
                            if (o2 != lllllllllllllIllIIIIIlIllllIllIl) {
                                n2 = ((lllllllllllllIllIIIIlIIlIIIlIIlI[lllllllllllllIllIIIIIlIlllllIllI] >>> lllllllllllllIllIIIIIlIllllIlIIl & 0xFF) ^ lllllllllllllIllIIIIIlIllllIlIlI);
                                ++o3[n2];
                            }
                            else {
                                break;
                            }
                        }
                        lllllllllllllIllIIIIIlIllllIlIII = -1;
                        lllllllllllllIllIIIIIlIlllllIlIl = 0;
                        lllllllllllllIllIIIIIlIlllllIlII = lllllllllllllIllIIIIIlIllllIllIl;
                        while (lllllllllllllIllIIIIIlIlllllIlIl < 256) {
                            if (lllllllllllllIllIIIIIlIllllIIIlI[lllllllllllllIllIIIIIlIlllllIlIl] != 0) {
                                lllllllllllllIllIIIIIlIllllIlIII = lllllllllllllIllIIIIIlIlllllIlIl;
                            }
                            lllllllllllllIllIIIIIlIlllllIlII = (o4[n3] = lllllllllllllIllIIIIIlIlllllIlII + lllllllllllllIllIIIIIlIllllIIIlI[lllllllllllllIllIIIIIlIlllllIlIl]);
                            ++lllllllllllllIllIIIIIlIlllllIlIl;
                        }
                        for (lllllllllllllIllIIIIIlIllllIIlll = lllllllllllllIllIIIIIlIllllIllIl + lllllllllllllIllIIIIIlIllllIllII - lllllllllllllIllIIIIIlIllllIIIlI[lllllllllllllIllIIIIIlIllllIlIII], lllllllllllllIllIIIIIlIlllllIIII = lllllllllllllIllIIIIIlIllllIllIl, lllllllllllllIllIIIIIlIllllIllll = -1; lllllllllllllIllIIIIIlIlllllIIII <= lllllllllllllIllIIIIIlIllllIIlll; lllllllllllllIllIIIIIlIlllllIIII += lllllllllllllIllIIIIIlIllllIIIlI[lllllllllllllIllIIIIIlIllllIllll2], lllllllllllllIllIIIIIlIllllIIIlI[lllllllllllllIllIIIIIlIllllIllll2] = 0) {
                            lllllllllllllIllIIIIIlIlllllIIIl = lllllllllllllIllIIIIlIIlIIIlIIlI[lllllllllllllIllIIIIIlIlllllIIII];
                            lllllllllllllIllIIIIIlIllllIllll2 = ((lllllllllllllIllIIIIIlIlllllIIIl >>> lllllllllllllIllIIIIIlIllllIlIIl & 0xFF) ^ lllllllllllllIllIIIIIlIllllIlIlI);
                            if (lllllllllllllIllIIIIIlIlllllIIII < lllllllllllllIllIIIIIlIllllIIlll) {
                                while (true) {
                                    n4 = o5[n5] - 1;
                                    o5[n5] = n4;
                                    if ((lllllllllllllIllIIIIIlIlllllIIlI = n4) > lllllllllllllIllIIIIIlIlllllIIII) {
                                        lllllllllllllIllIIIIIlIlllllIIll = lllllllllllllIllIIIIIlIlllllIIIl;
                                        lllllllllllllIllIIIIIlIlllllIIIl = lllllllllllllIllIIIIlIIlIIIlIIlI[lllllllllllllIllIIIIIlIlllllIIlI];
                                        lllllllllllllIllIIIIlIIlIIIlIIlI[lllllllllllllIllIIIIIlIlllllIIlI] = lllllllllllllIllIIIIIlIlllllIIll;
                                        lllllllllllllIllIIIIIlIllllIllll2 = ((lllllllllllllIllIIIIIlIlllllIIIl >>> lllllllllllllIllIIIIIlIllllIlIIl & 0xFF) ^ lllllllllllllIllIIIIIlIllllIlIlI);
                                    }
                                    else {
                                        break;
                                    }
                                }
                                lllllllllllllIllIIIIlIIlIIIlIIlI[lllllllllllllIllIIIIIlIlllllIIII] = lllllllllllllIllIIIIIlIlllllIIIl;
                            }
                            if (lllllllllllllIllIIIIIlIllllIlIll < 3 && lllllllllllllIllIIIIIlIllllIIIlI[lllllllllllllIllIIIIIlIllllIllll2] > 1) {
                                if (lllllllllllllIllIIIIIlIllllIIIlI[lllllllllllllIllIIIIIlIllllIllll2] < 1024) {
                                    quickSort(lllllllllllllIllIIIIlIIlIIIlIIlI, lllllllllllllIllIIIIIlIlllllIIII, lllllllllllllIllIIIIIlIlllllIIII + lllllllllllllIllIIIIIlIllllIIIlI[lllllllllllllIllIIIIIlIllllIllll2]);
                                }
                                else {
                                    atomicInteger.incrementAndGet();
                                    linkedBlockingQueue.add(new Segment(lllllllllllllIllIIIIIlIlllllIIII, lllllllllllllIllIIIIIlIllllIIIlI[lllllllllllllIllIIIIIlIllllIllll2], lllllllllllllIllIIIIIlIllllIlIll + 1));
                                }
                            }
                        }
                        atomicInteger.decrementAndGet();
                    }
                }
                return null;
            });
        }
        Throwable lllllllllllllIllIIIIlIIlIIIIlIIl = null;
        int lllllllllllllIllIIIIlIIlIIIlIIll = lllllllllllllIllIIIIlIIlIIIIllII;
        while (lllllllllllllIllIIIIlIIlIIIlIIll-- != 0) {
            try {
                lllllllllllllIllIIIIlIIlIIIIlIlI.take().get();
            }
            catch (Exception lllllllllllllIllIIIIlIIlIIIlIlII) {
                lllllllllllllIllIIIIlIIlIIIIlIIl = lllllllllllllIllIIIIlIIlIIIlIlII.getCause();
            }
        }
        lllllllllllllIllIIIIlIIlIIIIlIll.shutdown();
        if (lllllllllllllIllIIIIlIIlIIIIlIIl != null) {
            throw (lllllllllllllIllIIIIlIIlIIIIlIIl instanceof RuntimeException) ? lllllllllllllIllIIIIlIIlIIIIlIIl : new RuntimeException(lllllllllllllIllIIIIlIIlIIIIlIIl);
        }
    }
    
    private IntArrays() {
    }
    
    public static void radixSortIndirect(final int[] lllllllllllllIllIIIIlIIIllIIIlII, final int[] lllllllllllllIllIIIIlIIIllIIIIll, final int lllllllllllllIllIIIIlIIIlIllIlII, final int lllllllllllllIllIIIIlIIIlIllIIll, final boolean lllllllllllllIllIIIIlIIIlIllIIlI) {
        if (lllllllllllllIllIIIIlIIIlIllIIll - lllllllllllllIllIIIIlIIIlIllIlII < 1024) {
            insertionSortIndirect(lllllllllllllIllIIIIlIIIllIIIlII, lllllllllllllIllIIIIlIIIllIIIIll, lllllllllllllIllIIIIlIIIlIllIlII, lllllllllllllIllIIIIlIIIlIllIIll);
            return;
        }
        final int lllllllllllllIllIIIIlIIIlIllllll = 3;
        final int lllllllllllllIllIIIIlIIIlIlllllI = 766;
        int lllllllllllllIllIIIIlIIIlIllllIl = 0;
        final int[] lllllllllllllIllIIIIlIIIlIllllII = new int[766];
        final int[] lllllllllllllIllIIIIlIIIlIlllIll = new int[766];
        final int[] lllllllllllllIllIIIIlIIIlIlllIlI = new int[766];
        lllllllllllllIllIIIIlIIIlIlllIll[lllllllllllllIllIIIIlIIIlIllllIl] = lllllllllllllIllIIIIlIIIlIllIIll - (lllllllllllllIllIIIIlIIIlIllllII[lllllllllllllIllIIIIlIIIlIllllIl] = lllllllllllllIllIIIIlIIIlIllIlII);
        lllllllllllllIllIIIIlIIIlIlllIlI[lllllllllllllIllIIIIlIIIlIllllIl++] = 0;
        final int[] lllllllllllllIllIIIIlIIIlIlllIIl = new int[256];
        final int[] lllllllllllllIllIIIIlIIIlIlllIII = new int[256];
        final int[] lllllllllllllIllIIIIlIIIlIllIlll = (int[])(lllllllllllllIllIIIIlIIIlIllIIlI ? new int[lllllllllllllIllIIIIlIIIllIIIlII.length] : null);
        while (lllllllllllllIllIIIIlIIIlIllllIl > 0) {
            final int lllllllllllllIllIIIIlIIIllIIlIlI = lllllllllllllIllIIIIlIIIlIllllII[--lllllllllllllIllIIIIlIIIlIllllIl];
            final int lllllllllllllIllIIIIlIIIllIIlIIl = lllllllllllllIllIIIIlIIIlIlllIll[lllllllllllllIllIIIIlIIIlIllllIl];
            final int lllllllllllllIllIIIIlIIIllIIlIII = lllllllllllllIllIIIIlIIIlIlllIlI[lllllllllllllIllIIIIlIIIlIllllIl];
            final int lllllllllllllIllIIIIlIIIllIIIlll = (lllllllllllllIllIIIIlIIIllIIlIII % 4 == 0) ? 128 : 0;
            final int lllllllllllllIllIIIIlIIIllIIIllI = (3 - lllllllllllllIllIIIIlIIIllIIlIII % 4) * 8;
            int lllllllllllllIllIIIIlIIIllIlIllI = lllllllllllllIllIIIIlIIIllIIlIlI + lllllllllllllIllIIIIlIIIllIIlIIl;
            while (lllllllllllllIllIIIIlIIIllIlIllI-- != lllllllllllllIllIIIIlIIIllIIlIlI) {
                final int[] array = lllllllllllllIllIIIIlIIIlIlllIIl;
                final int n = (lllllllllllllIllIIIIlIIIllIIIIll[lllllllllllllIllIIIIlIIIllIIIlII[lllllllllllllIllIIIIlIIIllIlIllI]] >>> lllllllllllllIllIIIIlIIIllIIIllI & 0xFF) ^ lllllllllllllIllIIIIlIIIllIIIlll;
                ++array[n];
            }
            int lllllllllllllIllIIIIlIIIllIIIlIl = -1;
            int lllllllllllllIllIIIIlIIIllIlIlIl = 0;
            int lllllllllllllIllIIIIlIIIllIlIlII = lllllllllllllIllIIIIlIIIlIllIIlI ? 0 : lllllllllllllIllIIIIlIIIllIIlIlI;
            while (lllllllllllllIllIIIIlIIIllIlIlIl < 256) {
                if (lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIlIlIl] != 0) {
                    lllllllllllllIllIIIIlIIIllIIIlIl = lllllllllllllIllIIIIlIIIllIlIlIl;
                }
                lllllllllllllIllIIIIlIIIllIlIlII = (lllllllllllllIllIIIIlIIIlIlllIII[lllllllllllllIllIIIIlIIIllIlIlIl] = lllllllllllllIllIIIIlIIIllIlIlII + lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIlIlIl]);
                ++lllllllllllllIllIIIIlIIIllIlIlIl;
            }
            if (lllllllllllllIllIIIIlIIIlIllIIlI) {
                int lllllllllllllIllIIIIlIIIllIlIIll = lllllllllllllIllIIIIlIIIllIIlIlI + lllllllllllllIllIIIIlIIIllIIlIIl;
                while (lllllllllllllIllIIIIlIIIllIlIIll-- != lllllllllllllIllIIIIlIIIllIIlIlI) {
                    final int[] array2 = lllllllllllllIllIIIIlIIIlIllIlll;
                    final int[] array3 = lllllllllllllIllIIIIlIIIlIlllIII;
                    final int n2 = (lllllllllllllIllIIIIlIIIllIIIIll[lllllllllllllIllIIIIlIIIllIIIlII[lllllllllllllIllIIIIlIIIllIlIIll]] >>> lllllllllllllIllIIIIlIIIllIIIllI & 0xFF) ^ lllllllllllllIllIIIIlIIIllIIIlll;
                    array2[--array3[n2]] = lllllllllllllIllIIIIlIIIllIIIlII[lllllllllllllIllIIIIlIIIllIlIIll];
                }
                System.arraycopy(lllllllllllllIllIIIIlIIIlIllIlll, 0, lllllllllllllIllIIIIlIIIllIIIlII, lllllllllllllIllIIIIlIIIllIIlIlI, lllllllllllllIllIIIIlIIIllIIlIIl);
                int lllllllllllllIllIIIIlIIIllIlIIlI = 0;
                int lllllllllllllIllIIIIlIIIllIlIIIl = lllllllllllllIllIIIIlIIIllIIlIlI;
                while (lllllllllllllIllIIIIlIIIllIlIIlI <= lllllllllllllIllIIIIlIIIllIIIlIl) {
                    if (lllllllllllllIllIIIIlIIIllIIlIII < 3 && lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIlIIlI] > 1) {
                        if (lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIlIIlI] < 1024) {
                            insertionSortIndirect(lllllllllllllIllIIIIlIIIllIIIlII, lllllllllllllIllIIIIlIIIllIIIIll, lllllllllllllIllIIIIlIIIllIlIIIl, lllllllllllllIllIIIIlIIIllIlIIIl + lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIlIIlI]);
                        }
                        else {
                            lllllllllllllIllIIIIlIIIlIllllII[lllllllllllllIllIIIIlIIIlIllllIl] = lllllllllllllIllIIIIlIIIllIlIIIl;
                            lllllllllllllIllIIIIlIIIlIlllIll[lllllllllllllIllIIIIlIIIlIllllIl] = lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIlIIlI];
                            lllllllllllllIllIIIIlIIIlIlllIlI[lllllllllllllIllIIIIlIIIlIllllIl++] = lllllllllllllIllIIIIlIIIllIIlIII + 1;
                        }
                    }
                    lllllllllllllIllIIIIlIIIllIlIIIl += lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIlIIlI];
                    ++lllllllllllllIllIIIIlIIIllIlIIlI;
                }
                Arrays.fill(lllllllllllllIllIIIIlIIIlIlllIIl, 0);
            }
            else {
                for (int lllllllllllllIllIIIIlIIIllIIlIll = lllllllllllllIllIIIIlIIIllIIlIlI + lllllllllllllIllIIIIlIIIllIIlIIl - lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIIIlIl], lllllllllllllIllIIIIlIIIllIIllIl = lllllllllllllIllIIIIlIIIllIIlIlI, lllllllllllllIllIIIIlIIIllIIllII = -1; lllllllllllllIllIIIIlIIIllIIllIl <= lllllllllllllIllIIIIlIIIllIIlIll; lllllllllllllIllIIIIlIIIllIIllIl += lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIIllII], lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIIllII] = 0) {
                    int lllllllllllllIllIIIIlIIIllIIlllI = lllllllllllllIllIIIIlIIIllIIIlII[lllllllllllllIllIIIIlIIIllIIllIl];
                    lllllllllllllIllIIIIlIIIllIIllII = ((lllllllllllllIllIIIIlIIIllIIIIll[lllllllllllllIllIIIIlIIIllIIlllI] >>> lllllllllllllIllIIIIlIIIllIIIllI & 0xFF) ^ lllllllllllllIllIIIIlIIIllIIIlll);
                    if (lllllllllllllIllIIIIlIIIllIIllIl < lllllllllllllIllIIIIlIIIllIIlIll) {
                        while (true) {
                            final int[] array4 = lllllllllllllIllIIIIlIIIlIlllIII;
                            final int n3 = lllllllllllllIllIIIIlIIIllIIllII;
                            final int n4 = array4[n3] - 1;
                            array4[n3] = n4;
                            final int lllllllllllllIllIIIIlIIIllIIllll;
                            if ((lllllllllllllIllIIIIlIIIllIIllll = n4) <= lllllllllllllIllIIIIlIIIllIIllIl) {
                                break;
                            }
                            final int lllllllllllllIllIIIIlIIIllIlIIII = lllllllllllllIllIIIIlIIIllIIlllI;
                            lllllllllllllIllIIIIlIIIllIIlllI = lllllllllllllIllIIIIlIIIllIIIlII[lllllllllllllIllIIIIlIIIllIIllll];
                            lllllllllllllIllIIIIlIIIllIIIlII[lllllllllllllIllIIIIlIIIllIIllll] = lllllllllllllIllIIIIlIIIllIlIIII;
                            lllllllllllllIllIIIIlIIIllIIllII = ((lllllllllllllIllIIIIlIIIllIIIIll[lllllllllllllIllIIIIlIIIllIIlllI] >>> lllllllllllllIllIIIIlIIIllIIIllI & 0xFF) ^ lllllllllllllIllIIIIlIIIllIIIlll);
                        }
                        lllllllllllllIllIIIIlIIIllIIIlII[lllllllllllllIllIIIIlIIIllIIllIl] = lllllllllllllIllIIIIlIIIllIIlllI;
                    }
                    if (lllllllllllllIllIIIIlIIIllIIlIII < 3 && lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIIllII] > 1) {
                        if (lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIIllII] < 1024) {
                            insertionSortIndirect(lllllllllllllIllIIIIlIIIllIIIlII, lllllllllllllIllIIIIlIIIllIIIIll, lllllllllllllIllIIIIlIIIllIIllIl, lllllllllllllIllIIIIlIIIllIIllIl + lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIIllII]);
                        }
                        else {
                            lllllllllllllIllIIIIlIIIlIllllII[lllllllllllllIllIIIIlIIIlIllllIl] = lllllllllllllIllIIIIlIIIllIIllIl;
                            lllllllllllllIllIIIIlIIIlIlllIll[lllllllllllllIllIIIIlIIIlIllllIl] = lllllllllllllIllIIIIlIIIlIlllIIl[lllllllllllllIllIIIIlIIIllIIllII];
                            lllllllllllllIllIIIIlIIIlIlllIlI[lllllllllllllIllIIIIlIIIlIllllIl++] = lllllllllllllIllIIIIlIIIllIIlIII + 1;
                        }
                    }
                }
            }
        }
    }
    
    @Deprecated
    public static void fill(final int[] lllllllllllllIllIIIIllIIllIlIIII, final int lllllllllllllIllIIIIllIIllIIllll) {
        int lllllllllllllIllIIIIllIIllIIlllI = lllllllllllllIllIIIIllIIllIlIIII.length;
        while (lllllllllllllIllIIIIllIIllIIlllI-- != 0) {
            lllllllllllllIllIIIIllIIllIlIIII[lllllllllllllIllIIIIllIIllIIlllI] = lllllllllllllIllIIIIllIIllIIllll;
        }
    }
    
    protected static class ForkJoinQuickSortComp extends RecursiveAction
    {
        private final /* synthetic */ int[] x;
        private final /* synthetic */ IntComparator comp;
        private final /* synthetic */ int from;
        private final /* synthetic */ int to;
        
        @Override
        protected void compute() {
            final int[] lllllllllllllIIllIllIllllIllIIII = this.x;
            final int lllllllllllllIIllIllIllllIlIllll = this.to - this.from;
            if (lllllllllllllIIllIllIllllIlIllll < 8192) {
                IntArrays.quickSort(lllllllllllllIIllIllIllllIllIIII, this.from, this.to, this.comp);
                return;
            }
            int lllllllllllllIIllIllIllllIlIlllI = this.from + lllllllllllllIIllIllIllllIlIllll / 2;
            int lllllllllllllIIllIllIllllIlIllIl = this.from;
            int lllllllllllllIIllIllIllllIlIllII = this.to - 1;
            int lllllllllllllIIllIllIllllIlIlIll = lllllllllllllIIllIllIllllIlIllll / 8;
            lllllllllllllIIllIllIllllIlIllIl = med3(lllllllllllllIIllIllIllllIllIIII, lllllllllllllIIllIllIllllIlIllIl, lllllllllllllIIllIllIllllIlIllIl + lllllllllllllIIllIllIllllIlIlIll, lllllllllllllIIllIllIllllIlIllIl + 2 * lllllllllllllIIllIllIllllIlIlIll, this.comp);
            lllllllllllllIIllIllIllllIlIlllI = med3(lllllllllllllIIllIllIllllIllIIII, lllllllllllllIIllIllIllllIlIlllI - lllllllllllllIIllIllIllllIlIlIll, lllllllllllllIIllIllIllllIlIlllI, lllllllllllllIIllIllIllllIlIlllI + lllllllllllllIIllIllIllllIlIlIll, this.comp);
            lllllllllllllIIllIllIllllIlIllII = med3(lllllllllllllIIllIllIllllIllIIII, lllllllllllllIIllIllIllllIlIllII - 2 * lllllllllllllIIllIllIllllIlIlIll, lllllllllllllIIllIllIllllIlIllII - lllllllllllllIIllIllIllllIlIlIll, lllllllllllllIIllIllIllllIlIllII, this.comp);
            lllllllllllllIIllIllIllllIlIlllI = med3(lllllllllllllIIllIllIllllIllIIII, lllllllllllllIIllIllIllllIlIllIl, lllllllllllllIIllIllIllllIlIlllI, lllllllllllllIIllIllIllllIlIllII, this.comp);
            final int lllllllllllllIIllIllIllllIlIlIlI = lllllllllllllIIllIllIllllIllIIII[lllllllllllllIIllIllIllllIlIlllI];
            int lllllllllllllIIllIllIllllIlIlIII;
            int lllllllllllllIIllIllIllllIlIlIIl = lllllllllllllIIllIllIllllIlIlIII = this.from;
            int lllllllllllllIIllIllIllllIlIIllI;
            int lllllllllllllIIllIllIllllIlIIlll = lllllllllllllIIllIllIllllIlIIllI = this.to - 1;
            while (true) {
                final int lllllllllllllIIllIllIllllIllIIll;
                if (lllllllllllllIIllIllIllllIlIlIII <= lllllllllllllIIllIllIllllIlIIlll && (lllllllllllllIIllIllIllllIllIIll = this.comp.compare(lllllllllllllIIllIllIllllIllIIII[lllllllllllllIIllIllIllllIlIlIII], lllllllllllllIIllIllIllllIlIlIlI)) <= 0) {
                    if (lllllllllllllIIllIllIllllIllIIll == 0) {
                        IntArrays.swap(lllllllllllllIIllIllIllllIllIIII, lllllllllllllIIllIllIllllIlIlIIl++, lllllllllllllIIllIllIllllIlIlIII);
                    }
                    ++lllllllllllllIIllIllIllllIlIlIII;
                }
                else {
                    int lllllllllllllIIllIllIllllIllIIlI;
                    while (lllllllllllllIIllIllIllllIlIIlll >= lllllllllllllIIllIllIllllIlIlIII && (lllllllllllllIIllIllIllllIllIIlI = this.comp.compare(lllllllllllllIIllIllIllllIllIIII[lllllllllllllIIllIllIllllIlIIlll], lllllllllllllIIllIllIllllIlIlIlI)) >= 0) {
                        if (lllllllllllllIIllIllIllllIllIIlI == 0) {
                            IntArrays.swap(lllllllllllllIIllIllIllllIllIIII, lllllllllllllIIllIllIllllIlIIlll, lllllllllllllIIllIllIllllIlIIllI--);
                        }
                        --lllllllllllllIIllIllIllllIlIIlll;
                    }
                    if (lllllllllllllIIllIllIllllIlIlIII > lllllllllllllIIllIllIllllIlIIlll) {
                        break;
                    }
                    IntArrays.swap(lllllllllllllIIllIllIllllIllIIII, lllllllllllllIIllIllIllllIlIlIII++, lllllllllllllIIllIllIllllIlIIlll--);
                }
            }
            lllllllllllllIIllIllIllllIlIlIll = Math.min(lllllllllllllIIllIllIllllIlIlIIl - this.from, lllllllllllllIIllIllIllllIlIlIII - lllllllllllllIIllIllIllllIlIlIIl);
            IntArrays.swap(lllllllllllllIIllIllIllllIllIIII, this.from, lllllllllllllIIllIllIllllIlIlIII - lllllllllllllIIllIllIllllIlIlIll, lllllllllllllIIllIllIllllIlIlIll);
            lllllllllllllIIllIllIllllIlIlIll = Math.min(lllllllllllllIIllIllIllllIlIIllI - lllllllllllllIIllIllIllllIlIIlll, this.to - lllllllllllllIIllIllIllllIlIIllI - 1);
            IntArrays.swap(lllllllllllllIIllIllIllllIllIIII, lllllllllllllIIllIllIllllIlIlIII, this.to - lllllllllllllIIllIllIllllIlIlIll, lllllllllllllIIllIllIllllIlIlIll);
            lllllllllllllIIllIllIllllIlIlIll = lllllllllllllIIllIllIllllIlIlIII - lllllllllllllIIllIllIllllIlIlIIl;
            final int lllllllllllllIIllIllIllllIlIIlIl = lllllllllllllIIllIllIllllIlIIllI - lllllllllllllIIllIllIllllIlIIlll;
            if (lllllllllllllIIllIllIllllIlIlIll > 1 && lllllllllllllIIllIllIllllIlIIlIl > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortComp(lllllllllllllIIllIllIllllIllIIII, this.from, this.from + lllllllllllllIIllIllIllllIlIlIll, this.comp), new ForkJoinQuickSortComp(lllllllllllllIIllIllIllllIllIIII, this.to - lllllllllllllIIllIllIllllIlIIlIl, this.to, this.comp));
            }
            else if (lllllllllllllIIllIllIllllIlIlIll > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortComp(lllllllllllllIIllIllIllllIllIIII, this.from, this.from + lllllllllllllIIllIllIllllIlIlIll, this.comp));
            }
            else {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortComp(lllllllllllllIIllIllIllllIllIIII, this.to - lllllllllllllIIllIllIllllIlIIlIl, this.to, this.comp));
            }
        }
        
        public ForkJoinQuickSortComp(final int[] lllllllllllllIIllIllIlllllIIlIIl, final int lllllllllllllIIllIllIlllllIIIIll, final int lllllllllllllIIllIllIlllllIIIIlI, final IntComparator lllllllllllllIIllIllIlllllIIIIIl) {
            this.from = lllllllllllllIIllIllIlllllIIIIll;
            this.to = lllllllllllllIIllIllIlllllIIIIlI;
            this.x = lllllllllllllIIllIllIlllllIIlIIl;
            this.comp = lllllllllllllIIllIllIlllllIIIIIl;
        }
    }
    
    protected static class ForkJoinQuickSort extends RecursiveAction
    {
        private final /* synthetic */ int from;
        private final /* synthetic */ int[] x;
        private final /* synthetic */ int to;
        
        public ForkJoinQuickSort(final int[] llllllllllllIlllllIIlIlllIllllll, final int llllllllllllIlllllIIlIlllIlllllI, final int llllllllllllIlllllIIlIlllIllllIl) {
            this.from = llllllllllllIlllllIIlIlllIlllllI;
            this.to = llllllllllllIlllllIIlIlllIllllIl;
            this.x = llllllllllllIlllllIIlIlllIllllll;
        }
        
        @Override
        protected void compute() {
            final int[] llllllllllllIlllllIIlIlllIlIllII = this.x;
            final int llllllllllllIlllllIIlIlllIlIlIll = this.to - this.from;
            if (llllllllllllIlllllIIlIlllIlIlIll < 8192) {
                IntArrays.quickSort(llllllllllllIlllllIIlIlllIlIllII, this.from, this.to);
                return;
            }
            int llllllllllllIlllllIIlIlllIlIlIlI = this.from + llllllllllllIlllllIIlIlllIlIlIll / 2;
            int llllllllllllIlllllIIlIlllIlIlIIl = this.from;
            int llllllllllllIlllllIIlIlllIlIlIII = this.to - 1;
            int llllllllllllIlllllIIlIlllIlIIlll = llllllllllllIlllllIIlIlllIlIlIll / 8;
            llllllllllllIlllllIIlIlllIlIlIIl = med3(llllllllllllIlllllIIlIlllIlIllII, llllllllllllIlllllIIlIlllIlIlIIl, llllllllllllIlllllIIlIlllIlIlIIl + llllllllllllIlllllIIlIlllIlIIlll, llllllllllllIlllllIIlIlllIlIlIIl + 2 * llllllllllllIlllllIIlIlllIlIIlll);
            llllllllllllIlllllIIlIlllIlIlIlI = med3(llllllllllllIlllllIIlIlllIlIllII, llllllllllllIlllllIIlIlllIlIlIlI - llllllllllllIlllllIIlIlllIlIIlll, llllllllllllIlllllIIlIlllIlIlIlI, llllllllllllIlllllIIlIlllIlIlIlI + llllllllllllIlllllIIlIlllIlIIlll);
            llllllllllllIlllllIIlIlllIlIlIII = med3(llllllllllllIlllllIIlIlllIlIllII, llllllllllllIlllllIIlIlllIlIlIII - 2 * llllllllllllIlllllIIlIlllIlIIlll, llllllllllllIlllllIIlIlllIlIlIII - llllllllllllIlllllIIlIlllIlIIlll, llllllllllllIlllllIIlIlllIlIlIII);
            llllllllllllIlllllIIlIlllIlIlIlI = med3(llllllllllllIlllllIIlIlllIlIllII, llllllllllllIlllllIIlIlllIlIlIIl, llllllllllllIlllllIIlIlllIlIlIlI, llllllllllllIlllllIIlIlllIlIlIII);
            final int llllllllllllIlllllIIlIlllIlIIllI = llllllllllllIlllllIIlIlllIlIllII[llllllllllllIlllllIIlIlllIlIlIlI];
            int llllllllllllIlllllIIlIlllIlIIlII;
            int llllllllllllIlllllIIlIlllIlIIlIl = llllllllllllIlllllIIlIlllIlIIlII = this.from;
            int llllllllllllIlllllIIlIlllIlIIIlI;
            int llllllllllllIlllllIIlIlllIlIIIll = llllllllllllIlllllIIlIlllIlIIIlI = this.to - 1;
            while (true) {
                final int llllllllllllIlllllIIlIlllIlIllll;
                if (llllllllllllIlllllIIlIlllIlIIlII <= llllllllllllIlllllIIlIlllIlIIIll && (llllllllllllIlllllIIlIlllIlIllll = Integer.compare(llllllllllllIlllllIIlIlllIlIllII[llllllllllllIlllllIIlIlllIlIIlII], llllllllllllIlllllIIlIlllIlIIllI)) <= 0) {
                    if (llllllllllllIlllllIIlIlllIlIllll == 0) {
                        IntArrays.swap(llllllllllllIlllllIIlIlllIlIllII, llllllllllllIlllllIIlIlllIlIIlIl++, llllllllllllIlllllIIlIlllIlIIlII);
                    }
                    ++llllllllllllIlllllIIlIlllIlIIlII;
                }
                else {
                    int llllllllllllIlllllIIlIlllIlIlllI;
                    while (llllllllllllIlllllIIlIlllIlIIIll >= llllllllllllIlllllIIlIlllIlIIlII && (llllllllllllIlllllIIlIlllIlIlllI = Integer.compare(llllllllllllIlllllIIlIlllIlIllII[llllllllllllIlllllIIlIlllIlIIIll], llllllllllllIlllllIIlIlllIlIIllI)) >= 0) {
                        if (llllllllllllIlllllIIlIlllIlIlllI == 0) {
                            IntArrays.swap(llllllllllllIlllllIIlIlllIlIllII, llllllllllllIlllllIIlIlllIlIIIll, llllllllllllIlllllIIlIlllIlIIIlI--);
                        }
                        --llllllllllllIlllllIIlIlllIlIIIll;
                    }
                    if (llllllllllllIlllllIIlIlllIlIIlII > llllllllllllIlllllIIlIlllIlIIIll) {
                        break;
                    }
                    IntArrays.swap(llllllllllllIlllllIIlIlllIlIllII, llllllllllllIlllllIIlIlllIlIIlII++, llllllllllllIlllllIIlIlllIlIIIll--);
                }
            }
            llllllllllllIlllllIIlIlllIlIIlll = Math.min(llllllllllllIlllllIIlIlllIlIIlIl - this.from, llllllllllllIlllllIIlIlllIlIIlII - llllllllllllIlllllIIlIlllIlIIlIl);
            IntArrays.swap(llllllllllllIlllllIIlIlllIlIllII, this.from, llllllllllllIlllllIIlIlllIlIIlII - llllllllllllIlllllIIlIlllIlIIlll, llllllllllllIlllllIIlIlllIlIIlll);
            llllllllllllIlllllIIlIlllIlIIlll = Math.min(llllllllllllIlllllIIlIlllIlIIIlI - llllllllllllIlllllIIlIlllIlIIIll, this.to - llllllllllllIlllllIIlIlllIlIIIlI - 1);
            IntArrays.swap(llllllllllllIlllllIIlIlllIlIllII, llllllllllllIlllllIIlIlllIlIIlII, this.to - llllllllllllIlllllIIlIlllIlIIlll, llllllllllllIlllllIIlIlllIlIIlll);
            llllllllllllIlllllIIlIlllIlIIlll = llllllllllllIlllllIIlIlllIlIIlII - llllllllllllIlllllIIlIlllIlIIlIl;
            final int llllllllllllIlllllIIlIlllIlIIIIl = llllllllllllIlllllIIlIlllIlIIIlI - llllllllllllIlllllIIlIlllIlIIIll;
            if (llllllllllllIlllllIIlIlllIlIIlll > 1 && llllllllllllIlllllIIlIlllIlIIIIl > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort(llllllllllllIlllllIIlIlllIlIllII, this.from, this.from + llllllllllllIlllllIIlIlllIlIIlll), new ForkJoinQuickSort(llllllllllllIlllllIIlIlllIlIllII, this.to - llllllllllllIlllllIIlIlllIlIIIIl, this.to));
            }
            else if (llllllllllllIlllllIIlIlllIlIIlll > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort(llllllllllllIlllllIIlIlllIlIllII, this.from, this.from + llllllllllllIlllllIIlIlllIlIIlll));
            }
            else {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort(llllllllllllIlllllIIlIlllIlIllII, this.to - llllllllllllIlllllIIlIlllIlIIIIl, this.to));
            }
        }
    }
    
    protected static final class Segment
    {
        protected final /* synthetic */ int length;
        protected final /* synthetic */ int level;
        protected final /* synthetic */ int offset;
        
        protected Segment(final int lllllllllllllIlIlIllIlllIlIIIIIl, final int lllllllllllllIlIlIllIlllIIllllII, final int lllllllllllllIlIlIllIlllIIlllIll) {
            this.offset = lllllllllllllIlIlIllIlllIlIIIIIl;
            this.length = lllllllllllllIlIlIllIlllIIllllII;
            this.level = lllllllllllllIlIlIllIlllIIlllIll;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("Segment [offset=").append(this.offset).append(", length=").append(this.length).append(", level=").append(this.level).append("]"));
        }
    }
    
    protected static class ForkJoinQuickSort2 extends RecursiveAction
    {
        private final /* synthetic */ int to;
        private final /* synthetic */ int[] y;
        private final /* synthetic */ int[] x;
        private final /* synthetic */ int from;
        
        @Override
        protected void compute() {
            final int[] llllllllllllllIlIlIIIlllIIllIlIl = this.x;
            final int[] llllllllllllllIlIlIIIlllIIllIlII = this.y;
            final int llllllllllllllIlIlIIIlllIIllIIll = this.to - this.from;
            if (llllllllllllllIlIlIIIlllIIllIIll < 8192) {
                IntArrays.quickSort(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, this.from, this.to);
                return;
            }
            int llllllllllllllIlIlIIIlllIIllIIlI = this.from + llllllllllllllIlIlIIIlllIIllIIll / 2;
            int llllllllllllllIlIlIIIlllIIllIIIl = this.from;
            int llllllllllllllIlIlIIIlllIIllIIII = this.to - 1;
            int llllllllllllllIlIlIIIlllIIlIllll = llllllllllllllIlIlIIIlllIIllIIll / 8;
            llllllllllllllIlIlIIIlllIIllIIIl = med3(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, llllllllllllllIlIlIIIlllIIllIIIl, llllllllllllllIlIlIIIlllIIllIIIl + llllllllllllllIlIlIIIlllIIlIllll, llllllllllllllIlIlIIIlllIIllIIIl + 2 * llllllllllllllIlIlIIIlllIIlIllll);
            llllllllllllllIlIlIIIlllIIllIIlI = med3(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, llllllllllllllIlIlIIIlllIIllIIlI - llllllllllllllIlIlIIIlllIIlIllll, llllllllllllllIlIlIIIlllIIllIIlI, llllllllllllllIlIlIIIlllIIllIIlI + llllllllllllllIlIlIIIlllIIlIllll);
            llllllllllllllIlIlIIIlllIIllIIII = med3(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, llllllllllllllIlIlIIIlllIIllIIII - 2 * llllllllllllllIlIlIIIlllIIlIllll, llllllllllllllIlIlIIIlllIIllIIII - llllllllllllllIlIlIIIlllIIlIllll, llllllllllllllIlIlIIIlllIIllIIII);
            llllllllllllllIlIlIIIlllIIllIIlI = med3(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, llllllllllllllIlIlIIIlllIIllIIIl, llllllllllllllIlIlIIIlllIIllIIlI, llllllllllllllIlIlIIIlllIIllIIII);
            final int llllllllllllllIlIlIIIlllIIlIlllI = llllllllllllllIlIlIIIlllIIllIlIl[llllllllllllllIlIlIIIlllIIllIIlI];
            final int llllllllllllllIlIlIIIlllIIlIllIl = llllllllllllllIlIlIIIlllIIllIlII[llllllllllllllIlIlIIIlllIIllIIlI];
            int llllllllllllllIlIlIIIlllIIlIlIll;
            int llllllllllllllIlIlIIIlllIIlIllII = llllllllllllllIlIlIIIlllIIlIlIll = this.from;
            int llllllllllllllIlIlIIIlllIIlIlIIl;
            int llllllllllllllIlIlIIIlllIIlIlIlI = llllllllllllllIlIlIIIlllIIlIlIIl = this.to - 1;
            while (true) {
                final int llllllllllllllIlIlIIIlllIIlllIIl;
                final int llllllllllllllIlIlIIIlllIIlllIlI;
                if (llllllllllllllIlIlIIIlllIIlIlIll <= llllllllllllllIlIlIIIlllIIlIlIlI && (llllllllllllllIlIlIIIlllIIlllIlI = (((llllllllllllllIlIlIIIlllIIlllIIl = Integer.compare(llllllllllllllIlIlIIIlllIIllIlIl[llllllllllllllIlIlIIIlllIIlIlIll], llllllllllllllIlIlIIIlllIIlIlllI)) == 0) ? Integer.compare(llllllllllllllIlIlIIIlllIIllIlII[llllllllllllllIlIlIIIlllIIlIlIll], llllllllllllllIlIlIIIlllIIlIllIl) : llllllllllllllIlIlIIIlllIIlllIIl)) <= 0) {
                    if (llllllllllllllIlIlIIIlllIIlllIlI == 0) {
                        swap(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, llllllllllllllIlIlIIIlllIIlIllII++, llllllllllllllIlIlIIIlllIIlIlIll);
                    }
                    ++llllllllllllllIlIlIIIlllIIlIlIll;
                }
                else {
                    int llllllllllllllIlIlIIIlllIIllIlll;
                    int llllllllllllllIlIlIIIlllIIlllIII;
                    while (llllllllllllllIlIlIIIlllIIlIlIlI >= llllllllllllllIlIlIIIlllIIlIlIll && (llllllllllllllIlIlIIIlllIIlllIII = (((llllllllllllllIlIlIIIlllIIllIlll = Integer.compare(llllllllllllllIlIlIIIlllIIllIlIl[llllllllllllllIlIlIIIlllIIlIlIlI], llllllllllllllIlIlIIIlllIIlIlllI)) == 0) ? Integer.compare(llllllllllllllIlIlIIIlllIIllIlII[llllllllllllllIlIlIIIlllIIlIlIlI], llllllllllllllIlIlIIIlllIIlIllIl) : llllllllllllllIlIlIIIlllIIllIlll)) >= 0) {
                        if (llllllllllllllIlIlIIIlllIIlllIII == 0) {
                            swap(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, llllllllllllllIlIlIIIlllIIlIlIlI, llllllllllllllIlIlIIIlllIIlIlIIl--);
                        }
                        --llllllllllllllIlIlIIIlllIIlIlIlI;
                    }
                    if (llllllllllllllIlIlIIIlllIIlIlIll > llllllllllllllIlIlIIIlllIIlIlIlI) {
                        break;
                    }
                    swap(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, llllllllllllllIlIlIIIlllIIlIlIll++, llllllllllllllIlIlIIIlllIIlIlIlI--);
                }
            }
            llllllllllllllIlIlIIIlllIIlIllll = Math.min(llllllllllllllIlIlIIIlllIIlIllII - this.from, llllllllllllllIlIlIIIlllIIlIlIll - llllllllllllllIlIlIIIlllIIlIllII);
            swap(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, this.from, llllllllllllllIlIlIIIlllIIlIlIll - llllllllllllllIlIlIIIlllIIlIllll, llllllllllllllIlIlIIIlllIIlIllll);
            llllllllllllllIlIlIIIlllIIlIllll = Math.min(llllllllllllllIlIlIIIlllIIlIlIIl - llllllllllllllIlIlIIIlllIIlIlIlI, this.to - llllllllllllllIlIlIIIlllIIlIlIIl - 1);
            swap(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, llllllllllllllIlIlIIIlllIIlIlIll, this.to - llllllllllllllIlIlIIIlllIIlIllll, llllllllllllllIlIlIIIlllIIlIllll);
            llllllllllllllIlIlIIIlllIIlIllll = llllllllllllllIlIlIIIlllIIlIlIll - llllllllllllllIlIlIIIlllIIlIllII;
            final int llllllllllllllIlIlIIIlllIIlIlIII = llllllllllllllIlIlIIIlllIIlIlIIl - llllllllllllllIlIlIIIlllIIlIlIlI;
            if (llllllllllllllIlIlIIIlllIIlIllll > 1 && llllllllllllllIlIlIIIlllIIlIlIII > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort2(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, this.from, this.from + llllllllllllllIlIlIIIlllIIlIllll), new ForkJoinQuickSort2(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, this.to - llllllllllllllIlIlIIIlllIIlIlIII, this.to));
            }
            else if (llllllllllllllIlIlIIIlllIIlIllll > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort2(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, this.from, this.from + llllllllllllllIlIlIIIlllIIlIllll));
            }
            else {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort2(llllllllllllllIlIlIIIlllIIllIlIl, llllllllllllllIlIlIIIlllIIllIlII, this.to - llllllllllllllIlIlIIIlllIIlIlIII, this.to));
            }
        }
        
        public ForkJoinQuickSort2(final int[] llllllllllllllIlIlIIIllllIIIIllI, final int[] llllllllllllllIlIlIIIllllIIIIlII, final int llllllllllllllIlIlIIIlllIllllIll, final int llllllllllllllIlIlIIIlllIllllIlI) {
            this.from = llllllllllllllIlIlIIIlllIllllIll;
            this.to = llllllllllllllIlIlIIIlllIllllIlI;
            this.x = llllllllllllllIlIlIIIllllIIIIllI;
            this.y = llllllllllllllIlIlIIIllllIIIIlII;
        }
    }
    
    protected static class ForkJoinQuickSortIndirect extends RecursiveAction
    {
        private final /* synthetic */ int to;
        private final /* synthetic */ int[] perm;
        private final /* synthetic */ int from;
        private final /* synthetic */ int[] x;
        
        @Override
        protected void compute() {
            final int[] lllllllllllllllIIIIllIIlIIIIIIll = this.x;
            final int lllllllllllllllIIIIllIIlIIIIIIlI = this.to - this.from;
            if (lllllllllllllllIIIIllIIlIIIIIIlI < 8192) {
                IntArrays.quickSortIndirect(this.perm, lllllllllllllllIIIIllIIlIIIIIIll, this.from, this.to);
                return;
            }
            int lllllllllllllllIIIIllIIlIIIIIIIl = this.from + lllllllllllllllIIIIllIIlIIIIIIlI / 2;
            int lllllllllllllllIIIIllIIlIIIIIIII = this.from;
            int lllllllllllllllIIIIllIIIllllllll = this.to - 1;
            int lllllllllllllllIIIIllIIIlllllllI = lllllllllllllllIIIIllIIlIIIIIIlI / 8;
            lllllllllllllllIIIIllIIlIIIIIIII = med3Indirect(this.perm, lllllllllllllllIIIIllIIlIIIIIIll, lllllllllllllllIIIIllIIlIIIIIIII, lllllllllllllllIIIIllIIlIIIIIIII + lllllllllllllllIIIIllIIIlllllllI, lllllllllllllllIIIIllIIlIIIIIIII + 2 * lllllllllllllllIIIIllIIIlllllllI);
            lllllllllllllllIIIIllIIlIIIIIIIl = med3Indirect(this.perm, lllllllllllllllIIIIllIIlIIIIIIll, lllllllllllllllIIIIllIIlIIIIIIIl - lllllllllllllllIIIIllIIIlllllllI, lllllllllllllllIIIIllIIlIIIIIIIl, lllllllllllllllIIIIllIIlIIIIIIIl + lllllllllllllllIIIIllIIIlllllllI);
            lllllllllllllllIIIIllIIIllllllll = med3Indirect(this.perm, lllllllllllllllIIIIllIIlIIIIIIll, lllllllllllllllIIIIllIIIllllllll - 2 * lllllllllllllllIIIIllIIIlllllllI, lllllllllllllllIIIIllIIIllllllll - lllllllllllllllIIIIllIIIlllllllI, lllllllllllllllIIIIllIIIllllllll);
            lllllllllllllllIIIIllIIlIIIIIIIl = med3Indirect(this.perm, lllllllllllllllIIIIllIIlIIIIIIll, lllllllllllllllIIIIllIIlIIIIIIII, lllllllllllllllIIIIllIIlIIIIIIIl, lllllllllllllllIIIIllIIIllllllll);
            final int lllllllllllllllIIIIllIIIllllllIl = lllllllllllllllIIIIllIIlIIIIIIll[this.perm[lllllllllllllllIIIIllIIlIIIIIIIl]];
            int lllllllllllllllIIIIllIIIlllllIll;
            int lllllllllllllllIIIIllIIIllllllII = lllllllllllllllIIIIllIIIlllllIll = this.from;
            int lllllllllllllllIIIIllIIIlllllIIl;
            int lllllllllllllllIIIIllIIIlllllIlI = lllllllllllllllIIIIllIIIlllllIIl = this.to - 1;
            while (true) {
                final int lllllllllllllllIIIIllIIlIIIIIllI;
                if (lllllllllllllllIIIIllIIIlllllIll <= lllllllllllllllIIIIllIIIlllllIlI && (lllllllllllllllIIIIllIIlIIIIIllI = Integer.compare(lllllllllllllllIIIIllIIlIIIIIIll[this.perm[lllllllllllllllIIIIllIIIlllllIll]], lllllllllllllllIIIIllIIIllllllIl)) <= 0) {
                    if (lllllllllllllllIIIIllIIlIIIIIllI == 0) {
                        IntArrays.swap(this.perm, lllllllllllllllIIIIllIIIllllllII++, lllllllllllllllIIIIllIIIlllllIll);
                    }
                    ++lllllllllllllllIIIIllIIIlllllIll;
                }
                else {
                    int lllllllllllllllIIIIllIIlIIIIIlIl;
                    while (lllllllllllllllIIIIllIIIlllllIlI >= lllllllllllllllIIIIllIIIlllllIll && (lllllllllllllllIIIIllIIlIIIIIlIl = Integer.compare(lllllllllllllllIIIIllIIlIIIIIIll[this.perm[lllllllllllllllIIIIllIIIlllllIlI]], lllllllllllllllIIIIllIIIllllllIl)) >= 0) {
                        if (lllllllllllllllIIIIllIIlIIIIIlIl == 0) {
                            IntArrays.swap(this.perm, lllllllllllllllIIIIllIIIlllllIlI, lllllllllllllllIIIIllIIIlllllIIl--);
                        }
                        --lllllllllllllllIIIIllIIIlllllIlI;
                    }
                    if (lllllllllllllllIIIIllIIIlllllIll > lllllllllllllllIIIIllIIIlllllIlI) {
                        break;
                    }
                    IntArrays.swap(this.perm, lllllllllllllllIIIIllIIIlllllIll++, lllllllllllllllIIIIllIIIlllllIlI--);
                }
            }
            lllllllllllllllIIIIllIIIlllllllI = Math.min(lllllllllllllllIIIIllIIIllllllII - this.from, lllllllllllllllIIIIllIIIlllllIll - lllllllllllllllIIIIllIIIllllllII);
            IntArrays.swap(this.perm, this.from, lllllllllllllllIIIIllIIIlllllIll - lllllllllllllllIIIIllIIIlllllllI, lllllllllllllllIIIIllIIIlllllllI);
            lllllllllllllllIIIIllIIIlllllllI = Math.min(lllllllllllllllIIIIllIIIlllllIIl - lllllllllllllllIIIIllIIIlllllIlI, this.to - lllllllllllllllIIIIllIIIlllllIIl - 1);
            IntArrays.swap(this.perm, lllllllllllllllIIIIllIIIlllllIll, this.to - lllllllllllllllIIIIllIIIlllllllI, lllllllllllllllIIIIllIIIlllllllI);
            lllllllllllllllIIIIllIIIlllllllI = lllllllllllllllIIIIllIIIlllllIll - lllllllllllllllIIIIllIIIllllllII;
            final int lllllllllllllllIIIIllIIIlllllIII = lllllllllllllllIIIIllIIIlllllIIl - lllllllllllllllIIIIllIIIlllllIlI;
            if (lllllllllllllllIIIIllIIIlllllllI > 1 && lllllllllllllllIIIIllIIIlllllIII > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortIndirect(this.perm, lllllllllllllllIIIIllIIlIIIIIIll, this.from, this.from + lllllllllllllllIIIIllIIIlllllllI), new ForkJoinQuickSortIndirect(this.perm, lllllllllllllllIIIIllIIlIIIIIIll, this.to - lllllllllllllllIIIIllIIIlllllIII, this.to));
            }
            else if (lllllllllllllllIIIIllIIIlllllllI > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortIndirect(this.perm, lllllllllllllllIIIIllIIlIIIIIIll, this.from, this.from + lllllllllllllllIIIIllIIIlllllllI));
            }
            else {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortIndirect(this.perm, lllllllllllllllIIIIllIIlIIIIIIll, this.to - lllllllllllllllIIIIllIIIlllllIII, this.to));
            }
        }
        
        public ForkJoinQuickSortIndirect(final int[] lllllllllllllllIIIIllIIlIIIlllII, final int[] lllllllllllllllIIIIllIIlIIIllIll, final int lllllllllllllllIIIIllIIlIIIlIlIl, final int lllllllllllllllIIIIllIIlIIIllIIl) {
            this.from = lllllllllllllllIIIIllIIlIIIlIlIl;
            this.to = lllllllllllllllIIIIllIIlIIIllIIl;
            this.x = lllllllllllllllIIIIllIIlIIIllIll;
            this.perm = lllllllllllllllIIIIllIIlIIIlllII;
        }
    }
    
    private static final class ArrayHashStrategy implements Hash.Strategy<int[]>, Serializable
    {
        @Override
        public int hashCode(final int[] lllllllllllllllIlIIIIIIIIIIIIlII) {
            return Arrays.hashCode(lllllllllllllllIlIIIIIIIIIIIIlII);
        }
        
        @Override
        public boolean equals(final int[] lllllllllllllllIIlllllllllllllIl, final int[] lllllllllllllllIIlllllllllllllII) {
            return Arrays.equals(lllllllllllllllIIlllllllllllllIl, lllllllllllllllIIlllllllllllllII);
        }
    }
}
