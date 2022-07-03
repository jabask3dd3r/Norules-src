package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public final class ObjectArrays
{
    public static final /* synthetic */ Object[] EMPTY_ARRAY;
    
    private static <K> void insertionSortIndirect(final int[] llllllllllllllIlllllllllIlIIlllI, final K[] llllllllllllllIlllllllllIlIlIIIl, final int llllllllllllllIlllllllllIlIlIIII, final int llllllllllllllIlllllllllIlIIlIll) {
        int llllllllllllllIlllllllllIlIlIIll = llllllllllllllIlllllllllIlIlIIII;
        while (++llllllllllllllIlllllllllIlIlIIll < llllllllllllllIlllllllllIlIIlIll) {
            final int llllllllllllllIlllllllllIlIlIlIl = llllllllllllllIlllllllllIlIIlllI[llllllllllllllIlllllllllIlIlIIll];
            int llllllllllllllIlllllllllIlIlIlII = llllllllllllllIlllllllllIlIlIIll;
            for (int llllllllllllllIlllllllllIlIlIllI = llllllllllllllIlllllllllIlIIlllI[llllllllllllllIlllllllllIlIlIlII - 1]; ((Comparable)llllllllllllllIlllllllllIlIlIIIl[llllllllllllllIlllllllllIlIlIlIl]).compareTo(llllllllllllllIlllllllllIlIlIIIl[llllllllllllllIlllllllllIlIlIllI]) < 0; llllllllllllllIlllllllllIlIlIllI = llllllllllllllIlllllllllIlIIlllI[--llllllllllllllIlllllllllIlIlIlII - 1]) {
                llllllllllllllIlllllllllIlIIlllI[llllllllllllllIlllllllllIlIlIlII] = llllllllllllllIlllllllllIlIlIllI;
                if (llllllllllllllIlllllllllIlIlIIII == llllllllllllllIlllllllllIlIlIlII - 1) {
                    --llllllllllllllIlllllllllIlIlIlII;
                    break;
                }
            }
            llllllllllllllIlllllllllIlIIlllI[llllllllllllllIlllllllllIlIlIlII] = llllllllllllllIlllllllllIlIlIlIl;
        }
    }
    
    public static <K> void stableSort(final K[] llllllllllllllIlllllllIIllllIIIl, final int llllllllllllllIlllllllIIllllIIII, final int llllllllllllllIlllllllIIlllIllll, final Comparator<K> llllllllllllllIlllllllIIlllIlIlI) {
        Arrays.sort(llllllllllllllIlllllllIIllllIIIl, llllllllllllllIlllllllIIllllIIII, llllllllllllllIlllllllIIlllIllll, llllllllllllllIlllllllIIlllIlIlI);
    }
    
    private ObjectArrays() {
    }
    
    private static <K> int med3(final K[] llllllllllllllIllllllllIIllllIll, final K[] llllllllllllllIllllllllIIllllIIl, final int llllllllllllllIllllllllIlIIIIllI, final int llllllllllllllIllllllllIlIIIIlII, final int llllllllllllllIllllllllIlIIIIIlI) {
        int llllllllllllllIllllllllIlIIIIIII2;
        final int llllllllllllllIllllllllIlIIIIIII = ((llllllllllllllIllllllllIlIIIIIII2 = ((Comparable)llllllllllllllIllllllllIIllllIll[llllllllllllllIllllllllIlIIIIllI]).compareTo(llllllllllllllIllllllllIIllllIll[llllllllllllllIllllllllIlIIIIlII])) == 0) ? ((Comparable)llllllllllllllIllllllllIIllllIIl[llllllllllllllIllllllllIlIIIIllI]).compareTo(llllllllllllllIllllllllIIllllIIl[llllllllllllllIllllllllIlIIIIlII]) : llllllllllllllIllllllllIlIIIIIII2;
        final int llllllllllllllIllllllllIIllllllI = ((llllllllllllllIllllllllIlIIIIIII2 = ((Comparable)llllllllllllllIllllllllIIllllIll[llllllllllllllIllllllllIlIIIIllI]).compareTo(llllllllllllllIllllllllIIllllIll[llllllllllllllIllllllllIlIIIIIlI])) == 0) ? ((Comparable)llllllllllllllIllllllllIIllllIIl[llllllllllllllIllllllllIlIIIIllI]).compareTo(llllllllllllllIllllllllIIllllIIl[llllllllllllllIllllllllIlIIIIIlI]) : llllllllllllllIllllllllIlIIIIIII2;
        final int llllllllllllllIllllllllIIlllllIl = ((llllllllllllllIllllllllIlIIIIIII2 = ((Comparable)llllllllllllllIllllllllIIllllIll[llllllllllllllIllllllllIlIIIIlII]).compareTo(llllllllllllllIllllllllIIllllIll[llllllllllllllIllllllllIlIIIIIlI])) == 0) ? ((Comparable)llllllllllllllIllllllllIIllllIIl[llllllllllllllIllllllllIlIIIIlII]).compareTo(llllllllllllllIllllllllIIllllIIl[llllllllllllllIllllllllIlIIIIIlI]) : llllllllllllllIllllllllIlIIIIIII2;
        return (llllllllllllllIllllllllIlIIIIIII < 0) ? ((llllllllllllllIllllllllIIlllllIl < 0) ? llllllllllllllIllllllllIlIIIIlII : ((llllllllllllllIllllllllIIllllllI < 0) ? llllllllllllllIllllllllIlIIIIIlI : llllllllllllllIllllllllIlIIIIllI)) : ((llllllllllllllIllllllllIIlllllIl > 0) ? llllllllllllllIllllllllIlIIIIlII : ((llllllllllllllIllllllllIIllllllI > 0) ? llllllllllllllIllllllllIlIIIIIlI : llllllllllllllIllllllllIlIIIIllI));
    }
    
    public static <K> void parallelQuickSortIndirect(final int[] llllllllllllllIllllllllIlllllIIl, final K[] llllllllllllllIllllllllIlllllIlI) {
        parallelQuickSortIndirect(llllllllllllllIllllllllIlllllIIl, llllllllllllllIllllllllIlllllIlI, 0, llllllllllllllIllllllllIlllllIlI.length);
    }
    
    public static <K> K[] copy(final K[] lllllllllllllllIIIIIIIIIlllIIlIl, final int lllllllllllllllIIIIIIIIIlllIIIII, final int lllllllllllllllIIIIIIIIIllIlllll) {
        ensureOffsetLength(lllllllllllllllIIIIIIIIIlllIIlIl, lllllllllllllllIIIIIIIIIlllIIIII, lllllllllllllllIIIIIIIIIllIlllll);
        final K[] lllllllllllllllIIIIIIIIIlllIIIlI = newArray(lllllllllllllllIIIIIIIIIlllIIlIl, lllllllllllllllIIIIIIIIIllIlllll);
        System.arraycopy(lllllllllllllllIIIIIIIIIlllIIlIl, lllllllllllllllIIIIIIIIIlllIIIII, lllllllllllllllIIIIIIIIIlllIIIlI, 0, lllllllllllllllIIIIIIIIIllIlllll);
        return lllllllllllllllIIIIIIIIIlllIIIlI;
    }
    
    public static <K> void mergeSort(final K[] llllllllllllllIlllllllIlIIIIlIll, final int llllllllllllllIlllllllIlIIIIlllI, final int llllllllllllllIlllllllIlIIIIllIl, final Comparator<K> llllllllllllllIlllllllIlIIIIllII) {
        mergeSort(llllllllllllllIlllllllIlIIIIlIll, llllllllllllllIlllllllIlIIIIlllI, llllllllllllllIlllllllIlIIIIllIl, llllllllllllllIlllllllIlIIIIllII, llllllllllllllIlllllllIlIIIIlIll.clone());
    }
    
    public static <K> void parallelQuickSort(final K[] llllllllllllllIlllllllIllIIIIllI, final K[] llllllllllllllIlllllllIllIIIIlIl, final int llllllllllllllIlllllllIllIIIIlII, final int llllllllllllllIlllllllIllIIIIIll) {
        if (llllllllllllllIlllllllIllIIIIIll - llllllllllllllIlllllllIllIIIIlII < 8192) {
            quickSort(llllllllllllllIlllllllIllIIIIllI, (Object[])llllllllllllllIlllllllIllIIIIlIl, llllllllllllllIlllllllIllIIIIlII, llllllllllllllIlllllllIllIIIIIll);
        }
        final ForkJoinPool llllllllllllllIlllllllIllIIIIIlI = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        llllllllllllllIlllllllIllIIIIIlI.invoke(new ForkJoinQuickSort2(llllllllllllllIlllllllIllIIIIllI, llllllllllllllIlllllllIllIIIIlIl, llllllllllllllIlllllllIllIIIIlII, llllllllllllllIlllllllIllIIIIIll));
        llllllllllllllIlllllllIllIIIIIlI.shutdown();
    }
    
    public static <K> void quickSort(final K[] llllllllllllllIlllllllIllIlIIIIl, final K[] llllllllllllllIlllllllIllIlIllll, final int llllllllllllllIlllllllIllIIlllll, final int llllllllllllllIlllllllIllIlIllIl) {
        final int llllllllllllllIlllllllIllIlIllII = llllllllllllllIlllllllIllIlIllIl - llllllllllllllIlllllllIllIIlllll;
        if (llllllllllllllIlllllllIllIlIllII < 16) {
            selectionSort(llllllllllllllIlllllllIllIlIIIIl, (Object[])llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIIlllll, llllllllllllllIlllllllIllIlIllIl);
            return;
        }
        int llllllllllllllIlllllllIllIlIlIll = llllllllllllllIlllllllIllIIlllll + llllllllllllllIlllllllIllIlIllII / 2;
        int llllllllllllllIlllllllIllIlIlIlI = llllllllllllllIlllllllIllIIlllll;
        int llllllllllllllIlllllllIllIlIlIIl = llllllllllllllIlllllllIllIlIllIl - 1;
        if (llllllllllllllIlllllllIllIlIllII > 128) {
            final int llllllllllllllIlllllllIllIllIlIl = llllllllllllllIlllllllIllIlIllII / 8;
            llllllllllllllIlllllllIllIlIlIlI = med3(llllllllllllllIlllllllIllIlIIIIl, llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIlIlIlI, llllllllllllllIlllllllIllIlIlIlI + llllllllllllllIlllllllIllIllIlIl, llllllllllllllIlllllllIllIlIlIlI + 2 * llllllllllllllIlllllllIllIllIlIl);
            llllllllllllllIlllllllIllIlIlIll = med3(llllllllllllllIlllllllIllIlIIIIl, llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIlIlIll - llllllllllllllIlllllllIllIllIlIl, llllllllllllllIlllllllIllIlIlIll, llllllllllllllIlllllllIllIlIlIll + llllllllllllllIlllllllIllIllIlIl);
            llllllllllllllIlllllllIllIlIlIIl = med3(llllllllllllllIlllllllIllIlIIIIl, llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIlIlIIl - 2 * llllllllllllllIlllllllIllIllIlIl, llllllllllllllIlllllllIllIlIlIIl - llllllllllllllIlllllllIllIllIlIl, llllllllllllllIlllllllIllIlIlIIl);
        }
        llllllllllllllIlllllllIllIlIlIll = med3(llllllllllllllIlllllllIllIlIIIIl, llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIlIlIlI, llllllllllllllIlllllllIllIlIlIll, llllllllllllllIlllllllIllIlIlIIl);
        final K llllllllllllllIlllllllIllIlIlIII = llllllllllllllIlllllllIllIlIIIIl[llllllllllllllIlllllllIllIlIlIll];
        final K llllllllllllllIlllllllIllIlIIlll = llllllllllllllIlllllllIllIlIllll[llllllllllllllIlllllllIllIlIlIll];
        int llllllllllllllIlllllllIllIlIIlIl;
        int llllllllllllllIlllllllIllIlIIllI = llllllllllllllIlllllllIllIlIIlIl = llllllllllllllIlllllllIllIIlllll;
        int llllllllllllllIlllllllIllIlIIIll;
        int llllllllllllllIlllllllIllIlIIlII = llllllllllllllIlllllllIllIlIIIll = llllllllllllllIlllllllIllIlIllIl - 1;
        while (true) {
            final int llllllllllllllIlllllllIllIllIIll;
            final int llllllllllllllIlllllllIllIllIlII;
            if (llllllllllllllIlllllllIllIlIIlIl <= llllllllllllllIlllllllIllIlIIlII && (llllllllllllllIlllllllIllIllIlII = (((llllllllllllllIlllllllIllIllIIll = ((Comparable)llllllllllllllIlllllllIllIlIIIIl[llllllllllllllIlllllllIllIlIIlIl]).compareTo(llllllllllllllIlllllllIllIlIlIII)) == 0) ? ((Comparable)llllllllllllllIlllllllIllIlIllll[llllllllllllllIlllllllIllIlIIlIl]).compareTo(llllllllllllllIlllllllIllIlIIlll) : llllllllllllllIlllllllIllIllIIll)) <= 0) {
                if (llllllllllllllIlllllllIllIllIlII == 0) {
                    swap(llllllllllllllIlllllllIllIlIIIIl, (Object[])llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIlIIllI++, llllllllllllllIlllllllIllIlIIlIl);
                }
                ++llllllllllllllIlllllllIllIlIIlIl;
            }
            else {
                int llllllllllllllIlllllllIllIllIIIl;
                int llllllllllllllIlllllllIllIllIIlI;
                while (llllllllllllllIlllllllIllIlIIlII >= llllllllllllllIlllllllIllIlIIlIl && (llllllllllllllIlllllllIllIllIIlI = (((llllllllllllllIlllllllIllIllIIIl = ((Comparable)llllllllllllllIlllllllIllIlIIIIl[llllllllllllllIlllllllIllIlIIlII]).compareTo(llllllllllllllIlllllllIllIlIlIII)) == 0) ? ((Comparable)llllllllllllllIlllllllIllIlIllll[llllllllllllllIlllllllIllIlIIlII]).compareTo(llllllllllllllIlllllllIllIlIIlll) : llllllllllllllIlllllllIllIllIIIl)) >= 0) {
                    if (llllllllllllllIlllllllIllIllIIlI == 0) {
                        swap(llllllllllllllIlllllllIllIlIIIIl, (Object[])llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIlIIlII, llllllllllllllIlllllllIllIlIIIll--);
                    }
                    --llllllllllllllIlllllllIllIlIIlII;
                }
                if (llllllllllllllIlllllllIllIlIIlIl > llllllllllllllIlllllllIllIlIIlII) {
                    break;
                }
                swap(llllllllllllllIlllllllIllIlIIIIl, (Object[])llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIlIIlIl++, llllllllllllllIlllllllIllIlIIlII--);
            }
        }
        int llllllllllllllIlllllllIllIlIIIlI = Math.min(llllllllllllllIlllllllIllIlIIllI - llllllllllllllIlllllllIllIIlllll, llllllllllllllIlllllllIllIlIIlIl - llllllllllllllIlllllllIllIlIIllI);
        swap(llllllllllllllIlllllllIllIlIIIIl, llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIIlllll, llllllllllllllIlllllllIllIlIIlIl - llllllllllllllIlllllllIllIlIIIlI, llllllllllllllIlllllllIllIlIIIlI);
        llllllllllllllIlllllllIllIlIIIlI = Math.min(llllllllllllllIlllllllIllIlIIIll - llllllllllllllIlllllllIllIlIIlII, llllllllllllllIlllllllIllIlIllIl - llllllllllllllIlllllllIllIlIIIll - 1);
        swap(llllllllllllllIlllllllIllIlIIIIl, llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIlIIlIl, llllllllllllllIlllllllIllIlIllIl - llllllllllllllIlllllllIllIlIIIlI, llllllllllllllIlllllllIllIlIIIlI);
        if ((llllllllllllllIlllllllIllIlIIIlI = llllllllllllllIlllllllIllIlIIlIl - llllllllllllllIlllllllIllIlIIllI) > 1) {
            quickSort(llllllllllllllIlllllllIllIlIIIIl, (Object[])llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIIlllll, llllllllllllllIlllllllIllIIlllll + llllllllllllllIlllllllIllIlIIIlI);
        }
        if ((llllllllllllllIlllllllIllIlIIIlI = llllllllllllllIlllllllIllIlIIIll - llllllllllllllIlllllllIllIlIIlII) > 1) {
            quickSort(llllllllllllllIlllllllIllIlIIIIl, (Object[])llllllllllllllIlllllllIllIlIllll, llllllllllllllIlllllllIllIlIllIl - llllllllllllllIlllllllIllIlIIIlI, llllllllllllllIlllllllIllIlIllIl);
        }
    }
    
    public static <K> K[] trim(final K[] lllllllllllllllIIIIIIIIIllllIIlI, final int lllllllllllllllIIIIIIIIIllllIlII) {
        if (lllllllllllllllIIIIIIIIIllllIlII >= lllllllllllllllIIIIIIIIIllllIIlI.length) {
            return lllllllllllllllIIIIIIIIIllllIIlI;
        }
        final K[] lllllllllllllllIIIIIIIIIllllIIll = (K[])newArray((Object[])lllllllllllllllIIIIIIIIIllllIIlI, lllllllllllllllIIIIIIIIIllllIlII);
        System.arraycopy(lllllllllllllllIIIIIIIIIllllIIlI, 0, lllllllllllllllIIIIIIIIIllllIIll, 0, lllllllllllllllIIIIIIIIIllllIlII);
        return lllllllllllllllIIIIIIIIIllllIIll;
    }
    
    public static <K> void stabilize(final int[] llllllllllllllIllllllllIllIIlIIl, final K[] llllllllllllllIllllllllIllIIIIlI) {
        stabilize(llllllllllllllIllllllllIllIIlIIl, llllllllllllllIllllllllIllIIIIlI, 0, llllllllllllllIllllllllIllIIlIIl.length);
    }
    
    @Deprecated
    public static <K> void fill(final K[] lllllllllllllllIIIIIIIIIllIIIlll, final int lllllllllllllllIIIIIIIIIllIIIllI, int lllllllllllllllIIIIIIIIIllIIlIIl, final K lllllllllllllllIIIIIIIIIllIIIlII) {
        ensureFromTo(lllllllllllllllIIIIIIIIIllIIIlll, lllllllllllllllIIIIIIIIIllIIIllI, lllllllllllllllIIIIIIIIIllIIlIIl);
        if (lllllllllllllllIIIIIIIIIllIIIllI == 0) {
            while (lllllllllllllllIIIIIIIIIllIIlIIl-- != 0) {
                lllllllllllllllIIIIIIIIIllIIIlll[lllllllllllllllIIIIIIIIIllIIlIIl] = lllllllllllllllIIIIIIIIIllIIIlII;
            }
        }
        else {
            for (int lllllllllllllllIIIIIIIIIllIIllII = lllllllllllllllIIIIIIIIIllIIIllI; lllllllllllllllIIIIIIIIIllIIllII < lllllllllllllllIIIIIIIIIllIIlIIl; ++lllllllllllllllIIIIIIIIIllIIllII) {
                lllllllllllllllIIIIIIIIIllIIIlll[lllllllllllllllIIIIIIIIIllIIllII] = lllllllllllllllIIIIIIIIIllIIIlII;
            }
        }
    }
    
    public static <K> void unstableSort(final K[] llllllllllllllIlllllllIlIlllIIII, final int llllllllllllllIlllllllIlIllIllll, final int llllllllllllllIlllllllIlIllIlllI) {
        quickSort((Object[])llllllllllllllIlllllllIlIlllIIII, llllllllllllllIlllllllIlIllIllll, llllllllllllllIlllllllIlIllIlllI);
    }
    
    public static <K> int binarySearch(final K[] llllllllllllllIlllllllIIllIllIIl, int llllllllllllllIlllllllIIllIlIlII, int llllllllllllllIlllllllIIllIlIIll, final K llllllllllllllIlllllllIIllIlIllI) {
        --llllllllllllllIlllllllIIllIlIIll;
        while (llllllllllllllIlllllllIIllIlIlII <= llllllllllllllIlllllllIIllIlIIll) {
            final int llllllllllllllIlllllllIIllIlllII = llllllllllllllIlllllllIIllIlIlII + llllllllllllllIlllllllIIllIlIIll >>> 1;
            final K llllllllllllllIlllllllIIllIllIlI = llllllllllllllIlllllllIIllIllIIl[llllllllllllllIlllllllIIllIlllII];
            final int llllllllllllllIlllllllIIllIllIll = ((Comparable)llllllllllllllIlllllllIIllIllIlI).compareTo(llllllllllllllIlllllllIIllIlIllI);
            if (llllllllllllllIlllllllIIllIllIll < 0) {
                llllllllllllllIlllllllIIllIlIlII = llllllllllllllIlllllllIIllIlllII + 1;
            }
            else {
                if (llllllllllllllIlllllllIIllIllIll <= 0) {
                    return llllllllllllllIlllllllIIllIlllII;
                }
                llllllllllllllIlllllllIIllIlIIll = llllllllllllllIlllllllIIllIlllII - 1;
            }
        }
        return -(llllllllllllllIlllllllIIllIlIlII + 1);
    }
    
    static {
        QUICKSORT_NO_REC = 16;
        MERGESORT_NO_REC = 16;
        QUICKSORT_MEDIAN_OF_9 = 128;
        PARALLEL_QUICKSORT_NO_FORK = 8192;
        EMPTY_ARRAY = new Object[0];
        DEFAULT_EMPTY_ARRAY = new Object[0];
        HASH_STRATEGY = new ArrayHashStrategy();
    }
    
    public static <K> void parallelQuickSort(final K[] llllllllllllllIlllllllIlIllllIlI, final K[] llllllllllllllIlllllllIlIlllIlll) {
        ensureSameLength(llllllllllllllIlllllllIlIllllIlI, (Object[])llllllllllllllIlllllllIlIlllIlll);
        parallelQuickSort(llllllllllllllIlllllllIlIllllIlI, llllllllllllllIlllllllIlIlllIlll, 0, llllllllllllllIlllllllIlIllllIlI.length);
    }
    
    public static <K> void mergeSort(final K[] llllllllllllllIlllllllIlIIllIIlI) {
        mergeSort(llllllllllllllIlllllllIlIIllIIlI, 0, llllllllllllllIlllllllIlIIllIIlI.length);
    }
    
    private static <K> K[] newArray(final K[] lllllllllllllllIIIIIIIIlIIlIlllI, final int lllllllllllllllIIIIIIIIlIIlIlIlI) {
        final Class<?> lllllllllllllllIIIIIIIIlIIlIllII = lllllllllllllllIIIIIIIIlIIlIlllI.getClass();
        if (lllllllllllllllIIIIIIIIlIIlIllII == Object[].class) {
            return (K[])((lllllllllllllllIIIIIIIIlIIlIlIlI == 0) ? ObjectArrays.EMPTY_ARRAY : new Object[lllllllllllllllIIIIIIIIlIIlIlIlI]);
        }
        return (K[])Array.newInstance(lllllllllllllllIIIIIIIIlIIlIllII.getComponentType(), lllllllllllllllIIIIIIIIlIIlIlIlI);
    }
    
    public static <K> K[] reverse(final K[] llllllllllllllIlllllllIIIllIllll, final int llllllllllllllIlllllllIIIllIlllI, final int llllllllllllllIlllllllIIIllIlIIl) {
        final int llllllllllllllIlllllllIIIllIllII = llllllllllllllIlllllllIIIllIlIIl - llllllllllllllIlllllllIIIllIlllI;
        int llllllllllllllIlllllllIIIlllIIII = llllllllllllllIlllllllIIIllIllII / 2;
        while (llllllllllllllIlllllllIIIlllIIII-- != 0) {
            final K llllllllllllllIlllllllIIIlllIIIl = llllllllllllllIlllllllIIIllIllll[llllllllllllllIlllllllIIIllIlllI + llllllllllllllIlllllllIIIllIllII - llllllllllllllIlllllllIIIlllIIII - 1];
            llllllllllllllIlllllllIIIllIllll[llllllllllllllIlllllllIIIllIlllI + llllllllllllllIlllllllIIIllIllII - llllllllllllllIlllllllIIIlllIIII - 1] = llllllllllllllIlllllllIIIllIllll[llllllllllllllIlllllllIIIllIlllI + llllllllllllllIlllllllIIIlllIIII];
            llllllllllllllIlllllllIIIllIllll[llllllllllllllIlllllllIIIllIlllI + llllllllllllllIlllllllIIIlllIIII] = llllllllllllllIlllllllIIIlllIIIl;
        }
        return llllllllllllllIlllllllIIIllIllll;
    }
    
    public static <K> K[] grow(final K[] lllllllllllllllIIIIIIIIIllllllIl, final int lllllllllllllllIIIIIIIIIllllllII, final int lllllllllllllllIIIIIIIIIlllllllI) {
        if (lllllllllllllllIIIIIIIIIllllllII > lllllllllllllllIIIIIIIIIllllllIl.length) {
            final int lllllllllllllllIIIIIIIIlIIIIIIlI = (int)Math.max(Math.min(lllllllllllllllIIIIIIIIIllllllIl.length + (long)(lllllllllllllllIIIIIIIIIllllllIl.length >> 1), 2147483639L), lllllllllllllllIIIIIIIIIllllllII);
            final K[] lllllllllllllllIIIIIIIIlIIIIIIIl = newArray(lllllllllllllllIIIIIIIIIllllllIl, lllllllllllllllIIIIIIIIlIIIIIIlI);
            System.arraycopy(lllllllllllllllIIIIIIIIIllllllIl, 0, lllllllllllllllIIIIIIIIlIIIIIIIl, 0, lllllllllllllllIIIIIIIIIlllllllI);
            return lllllllllllllllIIIIIIIIlIIIIIIIl;
        }
        return lllllllllllllllIIIIIIIIIllllllIl;
    }
    
    public static <K> void mergeSort(final K[] llllllllllllllIlllllllIlIIIIIIll, final Comparator<K> llllllllllllllIlllllllIlIIIIIIlI) {
        mergeSort(llllllllllllllIlllllllIlIIIIIIll, 0, llllllllllllllIlllllllIlIIIIIIll.length, llllllllllllllIlllllllIlIIIIIIlI);
    }
    
    public static <K> void swap(final K[] lllllllllllllllIIIIIIIIIlIIIlIll, int lllllllllllllllIIIIIIIIIlIIIlIlI, int lllllllllllllllIIIIIIIIIlIIIllIl, final int lllllllllllllllIIIIIIIIIlIIIlIII) {
        for (int lllllllllllllllIIIIIIIIIlIIlIIII = 0; lllllllllllllllIIIIIIIIIlIIlIIII < lllllllllllllllIIIIIIIIIlIIIlIII; ++lllllllllllllllIIIIIIIIIlIIlIIII, ++lllllllllllllllIIIIIIIIIlIIIlIlI, ++lllllllllllllllIIIIIIIIIlIIIllIl) {
            swap(lllllllllllllllIIIIIIIIIlIIIlIll, lllllllllllllllIIIIIIIIIlIIIlIlI, lllllllllllllllIIIIIIIIIlIIIllIl);
        }
    }
    
    public static <K> K[] ensureCapacity(final K[] lllllllllllllllIIIIIIIIlIIIlIIll, final int lllllllllllllllIIIIIIIIlIIIIllll, final int lllllllllllllllIIIIIIIIlIIIlIIIl) {
        return (K[])((lllllllllllllllIIIIIIIIlIIIIllll > lllllllllllllllIIIIIIIIlIIIlIIll.length) ? forceCapacity((Object[])lllllllllllllllIIIIIIIIlIIIlIIll, lllllllllllllllIIIIIIIIlIIIIllll, lllllllllllllllIIIIIIIIlIIIlIIIl) : lllllllllllllllIIIIIIIIlIIIlIIll);
    }
    
    @Deprecated
    public static <K> void fill(final K[] lllllllllllllllIIIIIIIIIllIlIlll, final K lllllllllllllllIIIIIIIIIllIlIllI) {
        int lllllllllllllllIIIIIIIIIllIlIlIl = lllllllllllllllIIIIIIIIIllIlIlll.length;
        while (lllllllllllllllIIIIIIIIIllIlIlIl-- != 0) {
            lllllllllllllllIIIIIIIIIllIlIlll[lllllllllllllllIIIIIIIIIllIlIlIl] = lllllllllllllllIIIIIIIIIllIlIllI;
        }
    }
    
    public static <K> void quickSort(final K[] lllllllllllllllIIIIIIIIIIIIlIIIl, final Comparator<K> lllllllllllllllIIIIIIIIIIIIIlllI) {
        quickSort(lllllllllllllllIIIIIIIIIIIIlIIIl, 0, lllllllllllllllIIIIIIIIIIIIlIIIl.length, lllllllllllllllIIIIIIIIIIIIIlllI);
    }
    
    public static <K> void ensureSameLength(final K[] lllllllllllllllIIIIIIIIIlIlIIlIl, final K[] lllllllllllllllIIIIIIIIIlIlIIIlI) {
        if (lllllllllllllllIIIIIIIIIlIlIIlIl.length != lllllllllllllllIIIIIIIIIlIlIIIlI.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Array size mismatch: ").append(lllllllllllllllIIIIIIIIIlIlIIlIl.length).append(" != ").append(lllllllllllllllIIIIIIIIIlIlIIIlI.length)));
        }
    }
    
    public static <K> void quickSort(final K[] llllllllllllllIlllllllIllIIIllIl, final K[] llllllllllllllIlllllllIllIIIllII) {
        ensureSameLength(llllllllllllllIlllllllIllIIIllIl, (Object[])llllllllllllllIlllllllIllIIIllII);
        quickSort(llllllllllllllIlllllllIllIIIllIl, llllllllllllllIlllllllIllIIIllII, 0, llllllllllllllIlllllllIllIIIllIl.length);
    }
    
    public static <K> void quickSort(final K[] lllllllllllllllIIIIIIIIIIIlIIIIl, final int lllllllllllllllIIIIIIIIIIIlIlllI, final int lllllllllllllllIIIIIIIIIIIIlllll, final Comparator<K> lllllllllllllllIIIIIIIIIIIIllllI) {
        final int lllllllllllllllIIIIIIIIIIIlIlIll = lllllllllllllllIIIIIIIIIIIIlllll - lllllllllllllllIIIIIIIIIIIlIlllI;
        if (lllllllllllllllIIIIIIIIIIIlIlIll < 16) {
            selectionSort(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIlllI, lllllllllllllllIIIIIIIIIIIIlllll, (Comparator<Object>)lllllllllllllllIIIIIIIIIIIIllllI);
            return;
        }
        int lllllllllllllllIIIIIIIIIIIlIlIlI = lllllllllllllllIIIIIIIIIIIlIlllI + lllllllllllllllIIIIIIIIIIIlIlIll / 2;
        int lllllllllllllllIIIIIIIIIIIlIlIIl = lllllllllllllllIIIIIIIIIIIlIlllI;
        int lllllllllllllllIIIIIIIIIIIlIlIII = lllllllllllllllIIIIIIIIIIIIlllll - 1;
        if (lllllllllllllllIIIIIIIIIIIlIlIll > 128) {
            final int lllllllllllllllIIIIIIIIIIIllIIlI = lllllllllllllllIIIIIIIIIIIlIlIll / 8;
            lllllllllllllllIIIIIIIIIIIlIlIIl = med3(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIlIIl, lllllllllllllllIIIIIIIIIIIlIlIIl + lllllllllllllllIIIIIIIIIIIllIIlI, lllllllllllllllIIIIIIIIIIIlIlIIl + 2 * lllllllllllllllIIIIIIIIIIIllIIlI, lllllllllllllllIIIIIIIIIIIIllllI);
            lllllllllllllllIIIIIIIIIIIlIlIlI = med3(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIlIlI - lllllllllllllllIIIIIIIIIIIllIIlI, lllllllllllllllIIIIIIIIIIIlIlIlI, lllllllllllllllIIIIIIIIIIIlIlIlI + lllllllllllllllIIIIIIIIIIIllIIlI, lllllllllllllllIIIIIIIIIIIIllllI);
            lllllllllllllllIIIIIIIIIIIlIlIII = med3(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIlIII - 2 * lllllllllllllllIIIIIIIIIIIllIIlI, lllllllllllllllIIIIIIIIIIIlIlIII - lllllllllllllllIIIIIIIIIIIllIIlI, lllllllllllllllIIIIIIIIIIIlIlIII, lllllllllllllllIIIIIIIIIIIIllllI);
        }
        lllllllllllllllIIIIIIIIIIIlIlIlI = med3(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIlIIl, lllllllllllllllIIIIIIIIIIIlIlIlI, lllllllllllllllIIIIIIIIIIIlIlIII, lllllllllllllllIIIIIIIIIIIIllllI);
        final K lllllllllllllllIIIIIIIIIIIlIIlll = lllllllllllllllIIIIIIIIIIIlIIIIl[lllllllllllllllIIIIIIIIIIIlIlIlI];
        int lllllllllllllllIIIIIIIIIIIlIIlIl;
        int lllllllllllllllIIIIIIIIIIIlIIllI = lllllllllllllllIIIIIIIIIIIlIIlIl = lllllllllllllllIIIIIIIIIIIlIlllI;
        int lllllllllllllllIIIIIIIIIIIlIIIll;
        int lllllllllllllllIIIIIIIIIIIlIIlII = lllllllllllllllIIIIIIIIIIIlIIIll = lllllllllllllllIIIIIIIIIIIIlllll - 1;
        while (true) {
            final int lllllllllllllllIIIIIIIIIIIllIIIl;
            if (lllllllllllllllIIIIIIIIIIIlIIlIl <= lllllllllllllllIIIIIIIIIIIlIIlII && (lllllllllllllllIIIIIIIIIIIllIIIl = lllllllllllllllIIIIIIIIIIIIllllI.compare(lllllllllllllllIIIIIIIIIIIlIIIIl[lllllllllllllllIIIIIIIIIIIlIIlIl], lllllllllllllllIIIIIIIIIIIlIIlll)) <= 0) {
                if (lllllllllllllllIIIIIIIIIIIllIIIl == 0) {
                    swap(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIIllI++, lllllllllllllllIIIIIIIIIIIlIIlIl);
                }
                ++lllllllllllllllIIIIIIIIIIIlIIlIl;
            }
            else {
                int lllllllllllllllIIIIIIIIIIIllIIII;
                while (lllllllllllllllIIIIIIIIIIIlIIlII >= lllllllllllllllIIIIIIIIIIIlIIlIl && (lllllllllllllllIIIIIIIIIIIllIIII = lllllllllllllllIIIIIIIIIIIIllllI.compare(lllllllllllllllIIIIIIIIIIIlIIIIl[lllllllllllllllIIIIIIIIIIIlIIlII], lllllllllllllllIIIIIIIIIIIlIIlll)) >= 0) {
                    if (lllllllllllllllIIIIIIIIIIIllIIII == 0) {
                        swap(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIIlII, lllllllllllllllIIIIIIIIIIIlIIIll--);
                    }
                    --lllllllllllllllIIIIIIIIIIIlIIlII;
                }
                if (lllllllllllllllIIIIIIIIIIIlIIlIl > lllllllllllllllIIIIIIIIIIIlIIlII) {
                    break;
                }
                swap(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIIlIl++, lllllllllllllllIIIIIIIIIIIlIIlII--);
            }
        }
        int lllllllllllllllIIIIIIIIIIIlIIIlI = Math.min(lllllllllllllllIIIIIIIIIIIlIIllI - lllllllllllllllIIIIIIIIIIIlIlllI, lllllllllllllllIIIIIIIIIIIlIIlIl - lllllllllllllllIIIIIIIIIIIlIIllI);
        swap(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIlllI, lllllllllllllllIIIIIIIIIIIlIIlIl - lllllllllllllllIIIIIIIIIIIlIIIlI, lllllllllllllllIIIIIIIIIIIlIIIlI);
        lllllllllllllllIIIIIIIIIIIlIIIlI = Math.min(lllllllllllllllIIIIIIIIIIIlIIIll - lllllllllllllllIIIIIIIIIIIlIIlII, lllllllllllllllIIIIIIIIIIIIlllll - lllllllllllllllIIIIIIIIIIIlIIIll - 1);
        swap(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIIlIl, lllllllllllllllIIIIIIIIIIIIlllll - lllllllllllllllIIIIIIIIIIIlIIIlI, lllllllllllllllIIIIIIIIIIIlIIIlI);
        if ((lllllllllllllllIIIIIIIIIIIlIIIlI = lllllllllllllllIIIIIIIIIIIlIIlIl - lllllllllllllllIIIIIIIIIIIlIIllI) > 1) {
            quickSort(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIlIlllI, lllllllllllllllIIIIIIIIIIIlIlllI + lllllllllllllllIIIIIIIIIIIlIIIlI, (Comparator<Object>)lllllllllllllllIIIIIIIIIIIIllllI);
        }
        if ((lllllllllllllllIIIIIIIIIIIlIIIlI = lllllllllllllllIIIIIIIIIIIlIIIll - lllllllllllllllIIIIIIIIIIIlIIlII) > 1) {
            quickSort(lllllllllllllllIIIIIIIIIIIlIIIIl, lllllllllllllllIIIIIIIIIIIIlllll - lllllllllllllllIIIIIIIIIIIlIIIlI, lllllllllllllllIIIIIIIIIIIIlllll, (Comparator<Object>)lllllllllllllllIIIIIIIIIIIIllllI);
        }
    }
    
    public static <K> K[] setLength(final K[] lllllllllllllllIIIIIIIIIlllIllIl, final int lllllllllllllllIIIIIIIIIlllIllII) {
        if (lllllllllllllllIIIIIIIIIlllIllII == lllllllllllllllIIIIIIIIIlllIllIl.length) {
            return lllllllllllllllIIIIIIIIIlllIllIl;
        }
        if (lllllllllllllllIIIIIIIIIlllIllII < lllllllllllllllIIIIIIIIIlllIllIl.length) {
            return (K[])trim((Object[])lllllllllllllllIIIIIIIIIlllIllIl, lllllllllllllllIIIIIIIIIlllIllII);
        }
        return (K[])ensureCapacity((Object[])lllllllllllllllIIIIIIIIIlllIllIl, lllllllllllllllIIIIIIIIIlllIllII);
    }
    
    public static <K> K[] reverse(final K[] llllllllllllllIlllllllIIIllllIll) {
        final int llllllllllllllIlllllllIIIlllllII = llllllllllllllIlllllllIIIllllIll.length;
        int llllllllllllllIlllllllIIIllllllI = llllllllllllllIlllllllIIIlllllII / 2;
        while (llllllllllllllIlllllllIIIllllllI-- != 0) {
            final K llllllllllllllIlllllllIIIlllllll = llllllllllllllIlllllllIIIllllIll[llllllllllllllIlllllllIIIlllllII - llllllllllllllIlllllllIIIllllllI - 1];
            llllllllllllllIlllllllIIIllllIll[llllllllllllllIlllllllIIIlllllII - llllllllllllllIlllllllIIIllllllI - 1] = llllllllllllllIlllllllIIIllllIll[llllllllllllllIlllllllIIIllllllI];
            llllllllllllllIlllllllIIIllllIll[llllllllllllllIlllllllIIIllllllI] = llllllllllllllIlllllllIIIlllllll;
        }
        return llllllllllllllIlllllllIIIllllIll;
    }
    
    public static <K> K[] shuffle(final K[] llllllllllllllIlllllllIIlIIlllIl, final int llllllllllllllIlllllllIIlIIllIII, final int llllllllllllllIlllllllIIlIIllIll, final Random llllllllllllllIlllllllIIlIIllIlI) {
        int llllllllllllllIlllllllIIlIIllllI = llllllllllllllIlllllllIIlIIllIll - llllllllllllllIlllllllIIlIIllIII;
        while (llllllllllllllIlllllllIIlIIllllI-- != 0) {
            final int llllllllllllllIlllllllIIlIlIIIII = llllllllllllllIlllllllIIlIIllIlI.nextInt(llllllllllllllIlllllllIIlIIllllI + 1);
            final K llllllllllllllIlllllllIIlIIlllll = llllllllllllllIlllllllIIlIIlllIl[llllllllllllllIlllllllIIlIIllIII + llllllllllllllIlllllllIIlIIllllI];
            llllllllllllllIlllllllIIlIIlllIl[llllllllllllllIlllllllIIlIIllIII + llllllllllllllIlllllllIIlIIllllI] = llllllllllllllIlllllllIIlIIlllIl[llllllllllllllIlllllllIIlIIllIII + llllllllllllllIlllllllIIlIlIIIII];
            llllllllllllllIlllllllIIlIIlllIl[llllllllllllllIlllllllIIlIIllIII + llllllllllllllIlllllllIIlIlIIIII] = llllllllllllllIlllllllIIlIIlllll;
        }
        return llllllllllllllIlllllllIIlIIlllIl;
    }
    
    public static <K> void mergeSort(final K[] llllllllllllllIlllllllIlIIlIIlII, final int llllllllllllllIlllllllIlIIIlllII, final int llllllllllllllIlllllllIlIIIllIll, final Comparator<K> llllllllllllllIlllllllIlIIIllIlI, final K[] llllllllllllllIlllllllIlIIlIIIII) {
        final int llllllllllllllIlllllllIlIIIlllll = llllllllllllllIlllllllIlIIIllIll - llllllllllllllIlllllllIlIIIlllII;
        if (llllllllllllllIlllllllIlIIIlllll < 16) {
            insertionSort(llllllllllllllIlllllllIlIIlIIlII, llllllllllllllIlllllllIlIIIlllII, llllllllllllllIlllllllIlIIIllIll, llllllllllllllIlllllllIlIIIllIlI);
            return;
        }
        final int llllllllllllllIlllllllIlIIIllllI = llllllllllllllIlllllllIlIIIlllII + llllllllllllllIlllllllIlIIIllIll >>> 1;
        mergeSort(llllllllllllllIlllllllIlIIlIIIII, llllllllllllllIlllllllIlIIIlllII, llllllllllllllIlllllllIlIIIllllI, (Comparator<Object>)llllllllllllllIlllllllIlIIIllIlI, llllllllllllllIlllllllIlIIlIIlII);
        mergeSort(llllllllllllllIlllllllIlIIlIIIII, llllllllllllllIlllllllIlIIIllllI, llllllllllllllIlllllllIlIIIllIll, (Comparator<Object>)llllllllllllllIlllllllIlIIIllIlI, llllllllllllllIlllllllIlIIlIIlII);
        if (llllllllllllllIlllllllIlIIIllIlI.compare(llllllllllllllIlllllllIlIIlIIIII[llllllllllllllIlllllllIlIIIllllI - 1], llllllllllllllIlllllllIlIIlIIIII[llllllllllllllIlllllllIlIIIllllI]) <= 0) {
            System.arraycopy(llllllllllllllIlllllllIlIIlIIIII, llllllllllllllIlllllllIlIIIlllII, llllllllllllllIlllllllIlIIlIIlII, llllllllllllllIlllllllIlIIIlllII, llllllllllllllIlllllllIlIIIlllll);
            return;
        }
        int llllllllllllllIlllllllIlIIlIIlll = llllllllllllllIlllllllIlIIIlllII;
        int llllllllllllllIlllllllIlIIlIIllI = llllllllllllllIlllllllIlIIIlllII;
        int llllllllllllllIlllllllIlIIlIIlIl = llllllllllllllIlllllllIlIIIllllI;
        while (llllllllllllllIlllllllIlIIlIIlll < llllllllllllllIlllllllIlIIIllIll) {
            if (llllllllllllllIlllllllIlIIlIIlIl >= llllllllllllllIlllllllIlIIIllIll || (llllllllllllllIlllllllIlIIlIIllI < llllllllllllllIlllllllIlIIIllllI && llllllllllllllIlllllllIlIIIllIlI.compare(llllllllllllllIlllllllIlIIlIIIII[llllllllllllllIlllllllIlIIlIIllI], llllllllllllllIlllllllIlIIlIIIII[llllllllllllllIlllllllIlIIlIIlIl]) <= 0)) {
                llllllllllllllIlllllllIlIIlIIlII[llllllllllllllIlllllllIlIIlIIlll] = llllllllllllllIlllllllIlIIlIIIII[llllllllllllllIlllllllIlIIlIIllI++];
            }
            else {
                llllllllllllllIlllllllIlIIlIIlII[llllllllllllllIlllllllIlIIlIIlll] = llllllllllllllIlllllllIlIIlIIIII[llllllllllllllIlllllllIlIIlIIlIl++];
            }
            ++llllllllllllllIlllllllIlIIlIIlll;
        }
    }
    
    public static <K> void quickSortIndirect(final int[] llllllllllllllIlllllllllIIllIlIl, final K[] llllllllllllllIlllllllllIIllIlII, final int llllllllllllllIlllllllllIIllIIll, final int llllllllllllllIlllllllllIIllIIlI) {
        final int llllllllllllllIlllllllllIIllIIIl = llllllllllllllIlllllllllIIllIIlI - llllllllllllllIlllllllllIIllIIll;
        if (llllllllllllllIlllllllllIIllIIIl < 16) {
            insertionSortIndirect(llllllllllllllIlllllllllIIllIlIl, (Object[])llllllllllllllIlllllllllIIllIlII, llllllllllllllIlllllllllIIllIIll, llllllllllllllIlllllllllIIllIIlI);
            return;
        }
        int llllllllllllllIlllllllllIIllIIII = llllllllllllllIlllllllllIIllIIll + llllllllllllllIlllllllllIIllIIIl / 2;
        int llllllllllllllIlllllllllIIlIllll = llllllllllllllIlllllllllIIllIIll;
        int llllllllllllllIlllllllllIIlIlllI = llllllllllllllIlllllllllIIllIIlI - 1;
        if (llllllllllllllIlllllllllIIllIIIl > 128) {
            final int llllllllllllllIlllllllllIIlllIII = llllllllllllllIlllllllllIIllIIIl / 8;
            llllllllllllllIlllllllllIIlIllll = med3Indirect(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIllIlII, llllllllllllllIlllllllllIIlIllll, llllllllllllllIlllllllllIIlIllll + llllllllllllllIlllllllllIIlllIII, llllllllllllllIlllllllllIIlIllll + 2 * llllllllllllllIlllllllllIIlllIII);
            llllllllllllllIlllllllllIIllIIII = med3Indirect(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIllIlII, llllllllllllllIlllllllllIIllIIII - llllllllllllllIlllllllllIIlllIII, llllllllllllllIlllllllllIIllIIII, llllllllllllllIlllllllllIIllIIII + llllllllllllllIlllllllllIIlllIII);
            llllllllllllllIlllllllllIIlIlllI = med3Indirect(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIllIlII, llllllllllllllIlllllllllIIlIlllI - 2 * llllllllllllllIlllllllllIIlllIII, llllllllllllllIlllllllllIIlIlllI - llllllllllllllIlllllllllIIlllIII, llllllllllllllIlllllllllIIlIlllI);
        }
        llllllllllllllIlllllllllIIllIIII = med3Indirect(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIllIlII, llllllllllllllIlllllllllIIlIllll, llllllllllllllIlllllllllIIllIIII, llllllllllllllIlllllllllIIlIlllI);
        final K llllllllllllllIlllllllllIIlIllIl = llllllllllllllIlllllllllIIllIlII[llllllllllllllIlllllllllIIllIlIl[llllllllllllllIlllllllllIIllIIII]];
        int llllllllllllllIlllllllllIIlIlIll;
        int llllllllllllllIlllllllllIIlIllII = llllllllllllllIlllllllllIIlIlIll = llllllllllllllIlllllllllIIllIIll;
        int llllllllllllllIlllllllllIIlIlIIl;
        int llllllllllllllIlllllllllIIlIlIlI = llllllllllllllIlllllllllIIlIlIIl = llllllllllllllIlllllllllIIllIIlI - 1;
        while (true) {
            final int llllllllllllllIlllllllllIIllIlll;
            if (llllllllllllllIlllllllllIIlIlIll <= llllllllllllllIlllllllllIIlIlIlI && (llllllllllllllIlllllllllIIllIlll = ((Comparable)llllllllllllllIlllllllllIIllIlII[llllllllllllllIlllllllllIIllIlIl[llllllllllllllIlllllllllIIlIlIll]]).compareTo(llllllllllllllIlllllllllIIlIllIl)) <= 0) {
                if (llllllllllllllIlllllllllIIllIlll == 0) {
                    IntArrays.swap(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIlIllII++, llllllllllllllIlllllllllIIlIlIll);
                }
                ++llllllllllllllIlllllllllIIlIlIll;
            }
            else {
                int llllllllllllllIlllllllllIIllIllI;
                while (llllllllllllllIlllllllllIIlIlIlI >= llllllllllllllIlllllllllIIlIlIll && (llllllllllllllIlllllllllIIllIllI = ((Comparable)llllllllllllllIlllllllllIIllIlII[llllllllllllllIlllllllllIIllIlIl[llllllllllllllIlllllllllIIlIlIlI]]).compareTo(llllllllllllllIlllllllllIIlIllIl)) >= 0) {
                    if (llllllllllllllIlllllllllIIllIllI == 0) {
                        IntArrays.swap(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIlIlIlI, llllllllllllllIlllllllllIIlIlIIl--);
                    }
                    --llllllllllllllIlllllllllIIlIlIlI;
                }
                if (llllllllllllllIlllllllllIIlIlIll > llllllllllllllIlllllllllIIlIlIlI) {
                    break;
                }
                IntArrays.swap(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIlIlIll++, llllllllllllllIlllllllllIIlIlIlI--);
            }
        }
        int llllllllllllllIlllllllllIIlIlIII = Math.min(llllllllllllllIlllllllllIIlIllII - llllllllllllllIlllllllllIIllIIll, llllllllllllllIlllllllllIIlIlIll - llllllllllllllIlllllllllIIlIllII);
        IntArrays.swap(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIllIIll, llllllllllllllIlllllllllIIlIlIll - llllllllllllllIlllllllllIIlIlIII, llllllllllllllIlllllllllIIlIlIII);
        llllllllllllllIlllllllllIIlIlIII = Math.min(llllllllllllllIlllllllllIIlIlIIl - llllllllllllllIlllllllllIIlIlIlI, llllllllllllllIlllllllllIIllIIlI - llllllllllllllIlllllllllIIlIlIIl - 1);
        IntArrays.swap(llllllllllllllIlllllllllIIllIlIl, llllllllllllllIlllllllllIIlIlIll, llllllllllllllIlllllllllIIllIIlI - llllllllllllllIlllllllllIIlIlIII, llllllllllllllIlllllllllIIlIlIII);
        if ((llllllllllllllIlllllllllIIlIlIII = llllllllllllllIlllllllllIIlIlIll - llllllllllllllIlllllllllIIlIllII) > 1) {
            quickSortIndirect(llllllllllllllIlllllllllIIllIlIl, (Object[])llllllllllllllIlllllllllIIllIlII, llllllllllllllIlllllllllIIllIIll, llllllllllllllIlllllllllIIllIIll + llllllllllllllIlllllllllIIlIlIII);
        }
        if ((llllllllllllllIlllllllllIIlIlIII = llllllllllllllIlllllllllIIlIlIIl - llllllllllllllIlllllllllIIlIlIlI) > 1) {
            quickSortIndirect(llllllllllllllIlllllllllIIllIlIl, (Object[])llllllllllllllIlllllllllIIllIlII, llllllllllllllIlllllllllIIllIIlI - llllllllllllllIlllllllllIIlIlIII, llllllllllllllIlllllllllIIllIIlI);
        }
    }
    
    public static <K> void quickSort(final K[] llllllllllllllIllllllllllIIllllI, final int llllllllllllllIllllllllllIlIlIlI, final int llllllllllllllIllllllllllIlIlIIl) {
        final int llllllllllllllIllllllllllIlIlIII = llllllllllllllIllllllllllIlIlIIl - llllllllllllllIllllllllllIlIlIlI;
        if (llllllllllllllIllllllllllIlIlIII < 16) {
            selectionSort((Object[])llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIlIlI, llllllllllllllIllllllllllIlIlIIl);
            return;
        }
        int llllllllllllllIllllllllllIlIIlll = llllllllllllllIllllllllllIlIlIlI + llllllllllllllIllllllllllIlIlIII / 2;
        int llllllllllllllIllllllllllIlIIllI = llllllllllllllIllllllllllIlIlIlI;
        int llllllllllllllIllllllllllIlIIlIl = llllllllllllllIllllllllllIlIlIIl - 1;
        if (llllllllllllllIllllllllllIlIlIII > 128) {
            final int llllllllllllllIllllllllllIlIlllI = llllllllllllllIllllllllllIlIlIII / 8;
            llllllllllllllIllllllllllIlIIllI = med3(llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIIllI, llllllllllllllIllllllllllIlIIllI + llllllllllllllIllllllllllIlIlllI, llllllllllllllIllllllllllIlIIllI + 2 * llllllllllllllIllllllllllIlIlllI);
            llllllllllllllIllllllllllIlIIlll = med3(llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIIlll - llllllllllllllIllllllllllIlIlllI, llllllllllllllIllllllllllIlIIlll, llllllllllllllIllllllllllIlIIlll + llllllllllllllIllllllllllIlIlllI);
            llllllllllllllIllllllllllIlIIlIl = med3(llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIIlIl - 2 * llllllllllllllIllllllllllIlIlllI, llllllllllllllIllllllllllIlIIlIl - llllllllllllllIllllllllllIlIlllI, llllllllllllllIllllllllllIlIIlIl);
        }
        llllllllllllllIllllllllllIlIIlll = med3(llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIIllI, llllllllllllllIllllllllllIlIIlll, llllllllllllllIllllllllllIlIIlIl);
        final K llllllllllllllIllllllllllIlIIlII = llllllllllllllIllllllllllIIllllI[llllllllllllllIllllllllllIlIIlll];
        int llllllllllllllIllllllllllIlIIIlI;
        int llllllllllllllIllllllllllIlIIIll = llllllllllllllIllllllllllIlIIIlI = llllllllllllllIllllllllllIlIlIlI;
        int llllllllllllllIllllllllllIlIIIII;
        int llllllllllllllIllllllllllIlIIIIl = llllllllllllllIllllllllllIlIIIII = llllllllllllllIllllllllllIlIlIIl - 1;
        while (true) {
            final int llllllllllllllIllllllllllIlIllIl;
            if (llllllllllllllIllllllllllIlIIIlI <= llllllllllllllIllllllllllIlIIIIl && (llllllllllllllIllllllllllIlIllIl = ((Comparable)llllllllllllllIllllllllllIIllllI[llllllllllllllIllllllllllIlIIIlI]).compareTo(llllllllllllllIllllllllllIlIIlII)) <= 0) {
                if (llllllllllllllIllllllllllIlIllIl == 0) {
                    swap((Object[])llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIIIll++, llllllllllllllIllllllllllIlIIIlI);
                }
                ++llllllllllllllIllllllllllIlIIIlI;
            }
            else {
                int llllllllllllllIllllllllllIlIllII;
                while (llllllllllllllIllllllllllIlIIIIl >= llllllllllllllIllllllllllIlIIIlI && (llllllllllllllIllllllllllIlIllII = ((Comparable)llllllllllllllIllllllllllIIllllI[llllllllllllllIllllllllllIlIIIIl]).compareTo(llllllllllllllIllllllllllIlIIlII)) >= 0) {
                    if (llllllllllllllIllllllllllIlIllII == 0) {
                        swap((Object[])llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIIIIl, llllllllllllllIllllllllllIlIIIII--);
                    }
                    --llllllllllllllIllllllllllIlIIIIl;
                }
                if (llllllllllllllIllllllllllIlIIIlI > llllllllllllllIllllllllllIlIIIIl) {
                    break;
                }
                swap((Object[])llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIIIlI++, llllllllllllllIllllllllllIlIIIIl--);
            }
        }
        int llllllllllllllIllllllllllIIlllll = Math.min(llllllllllllllIllllllllllIlIIIll - llllllllllllllIllllllllllIlIlIlI, llllllllllllllIllllllllllIlIIIlI - llllllllllllllIllllllllllIlIIIll);
        swap(llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIlIlI, llllllllllllllIllllllllllIlIIIlI - llllllllllllllIllllllllllIIlllll, llllllllllllllIllllllllllIIlllll);
        llllllllllllllIllllllllllIIlllll = Math.min(llllllllllllllIllllllllllIlIIIII - llllllllllllllIllllllllllIlIIIIl, llllllllllllllIllllllllllIlIlIIl - llllllllllllllIllllllllllIlIIIII - 1);
        swap(llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIIIlI, llllllllllllllIllllllllllIlIlIIl - llllllllllllllIllllllllllIIlllll, llllllllllllllIllllllllllIIlllll);
        if ((llllllllllllllIllllllllllIIlllll = llllllllllllllIllllllllllIlIIIlI - llllllllllllllIllllllllllIlIIIll) > 1) {
            quickSort((Object[])llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIlIlI, llllllllllllllIllllllllllIlIlIlI + llllllllllllllIllllllllllIIlllll);
        }
        if ((llllllllllllllIllllllllllIIlllll = llllllllllllllIllllllllllIlIIIII - llllllllllllllIllllllllllIlIIIIl) > 1) {
            quickSort((Object[])llllllllllllllIllllllllllIIllllI, llllllllllllllIllllllllllIlIlIIl - llllllllllllllIllllllllllIIlllll, llllllllllllllIllllllllllIlIlIIl);
        }
    }
    
    public static <K> K[] grow(final K[] lllllllllllllllIIIIIIIIlIIIIlIll, final int lllllllllllllllIIIIIIIIlIIIIlIII) {
        return grow(lllllllllllllllIIIIIIIIlIIIIlIll, lllllllllllllllIIIIIIIIlIIIIlIII, lllllllllllllllIIIIIIIIlIIIIlIll.length);
    }
    
    private static <K> int med3(final K[] lllllllllllllllIIIIIIIIIIllllllI, final int lllllllllllllllIIIIIIIIIIlllllIl, final int lllllllllllllllIIIIIIIIIIlllllII, final int lllllllllllllllIIIIIIIIIIllllIll, final Comparator<K> lllllllllllllllIIIIIIIIIIlllIIlI) {
        final int lllllllllllllllIIIIIIIIIIllllIIl = lllllllllllllllIIIIIIIIIIlllIIlI.compare(lllllllllllllllIIIIIIIIIIllllllI[lllllllllllllllIIIIIIIIIIlllllIl], lllllllllllllllIIIIIIIIIIllllllI[lllllllllllllllIIIIIIIIIIlllllII]);
        final int lllllllllllllllIIIIIIIIIIllllIII = lllllllllllllllIIIIIIIIIIlllIIlI.compare(lllllllllllllllIIIIIIIIIIllllllI[lllllllllllllllIIIIIIIIIIlllllIl], lllllllllllllllIIIIIIIIIIllllllI[lllllllllllllllIIIIIIIIIIllllIll]);
        final int lllllllllllllllIIIIIIIIIIlllIlll = lllllllllllllllIIIIIIIIIIlllIIlI.compare(lllllllllllllllIIIIIIIIIIllllllI[lllllllllllllllIIIIIIIIIIlllllII], lllllllllllllllIIIIIIIIIIllllllI[lllllllllllllllIIIIIIIIIIllllIll]);
        return (lllllllllllllllIIIIIIIIIIllllIIl < 0) ? ((lllllllllllllllIIIIIIIIIIlllIlll < 0) ? lllllllllllllllIIIIIIIIIIlllllII : ((lllllllllllllllIIIIIIIIIIllllIII < 0) ? lllllllllllllllIIIIIIIIIIllllIll : lllllllllllllllIIIIIIIIIIlllllIl)) : ((lllllllllllllllIIIIIIIIIIlllIlll > 0) ? lllllllllllllllIIIIIIIIIIlllllII : ((lllllllllllllllIIIIIIIIIIllllIII > 0) ? lllllllllllllllIIIIIIIIIIllllIll : lllllllllllllllIIIIIIIIIIlllllIl));
    }
    
    public static <K> void swap(final K[] lllllllllllllllIIIIIIIIIlIIllIIl, final int lllllllllllllllIIIIIIIIIlIIlllII, final int lllllllllllllllIIIIIIIIIlIIllIll) {
        final K lllllllllllllllIIIIIIIIIlIIllIlI = lllllllllllllllIIIIIIIIIlIIllIIl[lllllllllllllllIIIIIIIIIlIIlllII];
        lllllllllllllllIIIIIIIIIlIIllIIl[lllllllllllllllIIIIIIIIIlIIlllII] = lllllllllllllllIIIIIIIIIlIIllIIl[lllllllllllllllIIIIIIIIIlIIllIll];
        lllllllllllllllIIIIIIIIIlIIllIIl[lllllllllllllllIIIIIIIIIlIIllIll] = lllllllllllllllIIIIIIIIIlIIllIlI;
    }
    
    private static <K> void selectionSort(final K[] llllllllllllllIlllllllIlllllIIIl, final K[] llllllllllllllIlllllllIlllllIlIl, final int llllllllllllllIlllllllIlllllIlII, final int llllllllllllllIlllllllIlllllIIll) {
        for (int llllllllllllllIlllllllIllllllIII = llllllllllllllIlllllllIlllllIlII; llllllllllllllIlllllllIllllllIII < llllllllllllllIlllllllIlllllIIll - 1; ++llllllllllllllIlllllllIllllllIII) {
            int llllllllllllllIlllllllIllllllIlI = llllllllllllllIlllllllIllllllIII;
            for (int llllllllllllllIlllllllIlllllllII = llllllllllllllIlllllllIllllllIII + 1; llllllllllllllIlllllllIlllllllII < llllllllllllllIlllllllIlllllIIll; ++llllllllllllllIlllllllIlllllllII) {
                final int llllllllllllllIlllllllIlllllllIl;
                if ((llllllllllllllIlllllllIlllllllIl = ((Comparable)llllllllllllllIlllllllIlllllIIIl[llllllllllllllIlllllllIlllllllII]).compareTo(llllllllllllllIlllllllIlllllIIIl[llllllllllllllIlllllllIllllllIlI])) < 0 || (llllllllllllllIlllllllIlllllllIl == 0 && ((Comparable)llllllllllllllIlllllllIlllllIlIl[llllllllllllllIlllllllIlllllllII]).compareTo(llllllllllllllIlllllllIlllllIlIl[llllllllllllllIlllllllIllllllIlI]) < 0)) {
                    llllllllllllllIlllllllIllllllIlI = llllllllllllllIlllllllIlllllllII;
                }
            }
            if (llllllllllllllIlllllllIllllllIlI != llllllllllllllIlllllllIllllllIII) {
                K llllllllllllllIlllllllIllllllIll = llllllllllllllIlllllllIlllllIIIl[llllllllllllllIlllllllIllllllIII];
                llllllllllllllIlllllllIlllllIIIl[llllllllllllllIlllllllIllllllIII] = llllllllllllllIlllllllIlllllIIIl[llllllllllllllIlllllllIllllllIlI];
                llllllllllllllIlllllllIlllllIIIl[llllllllllllllIlllllllIllllllIlI] = llllllllllllllIlllllllIllllllIll;
                llllllllllllllIlllllllIllllllIll = llllllllllllllIlllllllIlllllIlIl[llllllllllllllIlllllllIllllllIII];
                llllllllllllllIlllllllIlllllIlIl[llllllllllllllIlllllllIllllllIII] = llllllllllllllIlllllllIlllllIlIl[llllllllllllllIlllllllIllllllIlI];
                llllllllllllllIlllllllIlllllIlIl[llllllllllllllIlllllllIllllllIlI] = llllllllllllllIlllllllIllllllIll;
            }
        }
    }
    
    public static <K> void stableSort(final K[] llllllllllllllIlllllllIIlllllllI, final int llllllllllllllIlllllllIIlllllIlI, final int llllllllllllllIlllllllIIllllllII) {
        Arrays.sort(llllllllllllllIlllllllIIlllllllI, llllllllllllllIlllllllIIlllllIlI, llllllllllllllIlllllllIIllllllII);
    }
    
    @Deprecated
    public static <K> boolean equals(final K[] lllllllllllllllIIIIIIIIIlIllllII, final K[] lllllllllllllllIIIIIIIIIlIlllllI) {
        int lllllllllllllllIIIIIIIIIlIllllIl = lllllllllllllllIIIIIIIIIlIllllII.length;
        if (lllllllllllllllIIIIIIIIIlIllllIl != lllllllllllllllIIIIIIIIIlIlllllI.length) {
            return false;
        }
        while (lllllllllllllllIIIIIIIIIlIllllIl-- != 0) {
            if (!Objects.equals(lllllllllllllllIIIIIIIIIlIllllII[lllllllllllllllIIIIIIIIIlIllllIl], lllllllllllllllIIIIIIIIIlIlllllI[lllllllllllllllIIIIIIIIIlIllllIl])) {
                return false;
            }
        }
        return true;
    }
    
    public static <K> void parallelQuickSort(final K[] lllllllllllllllIIIIIIIIIIIIIIlll, final int lllllllllllllllIIIIIIIIIIIIIIIlI, final int lllllllllllllllIIIIIIIIIIIIIIlIl, final Comparator<K> lllllllllllllllIIIIIIIIIIIIIIlII) {
        if (lllllllllllllllIIIIIIIIIIIIIIlIl - lllllllllllllllIIIIIIIIIIIIIIIlI < 8192) {
            quickSort(lllllllllllllllIIIIIIIIIIIIIIlll, lllllllllllllllIIIIIIIIIIIIIIIlI, lllllllllllllllIIIIIIIIIIIIIIlIl, (Comparator<Object>)lllllllllllllllIIIIIIIIIIIIIIlII);
        }
        else {
            final ForkJoinPool lllllllllllllllIIIIIIIIIIIIIlIII = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            lllllllllllllllIIIIIIIIIIIIIlIII.invoke(new ForkJoinQuickSortComp(lllllllllllllllIIIIIIIIIIIIIIlll, lllllllllllllllIIIIIIIIIIIIIIIlI, lllllllllllllllIIIIIIIIIIIIIIlIl, (Comparator<Object>)lllllllllllllllIIIIIIIIIIIIIIlII));
            lllllllllllllllIIIIIIIIIIIIIlIII.shutdown();
        }
    }
    
    public static <K> void quickSort(final K[] llllllllllllllIllllllllllIIIllll) {
        quickSort(llllllllllllllIllllllllllIIIllll, 0, llllllllllllllIllllllllllIIIllll.length);
    }
    
    public static <K> K[] copy(final K[] lllllllllllllllIIIIIIIIIllIlllII) {
        return lllllllllllllllIIIIIIIIIllIlllII.clone();
    }
    
    private static <K> int med3Indirect(final int[] llllllllllllllIlllllllllIllIlIIl, final K[] llllllllllllllIlllllllllIllIlIII, final int llllllllllllllIlllllllllIlllIIlI, final int llllllllllllllIlllllllllIlllIIIl, final int llllllllllllllIlllllllllIlllIIII) {
        final K llllllllllllllIlllllllllIllIllll = llllllllllllllIlllllllllIllIlIII[llllllllllllllIlllllllllIllIlIIl[llllllllllllllIlllllllllIlllIIlI]];
        final K llllllllllllllIlllllllllIllIlllI = llllllllllllllIlllllllllIllIlIII[llllllllllllllIlllllllllIllIlIIl[llllllllllllllIlllllllllIlllIIIl]];
        final K llllllllllllllIlllllllllIllIllIl = llllllllllllllIlllllllllIllIlIII[llllllllllllllIlllllllllIllIlIIl[llllllllllllllIlllllllllIlllIIII]];
        final int llllllllllllllIlllllllllIllIllII = ((Comparable)llllllllllllllIlllllllllIllIllll).compareTo(llllllllllllllIlllllllllIllIlllI);
        final int llllllllllllllIlllllllllIllIlIll = ((Comparable)llllllllllllllIlllllllllIllIllll).compareTo(llllllllllllllIlllllllllIllIllIl);
        final int llllllllllllllIlllllllllIllIlIlI = ((Comparable)llllllllllllllIlllllllllIllIlllI).compareTo(llllllllllllllIlllllllllIllIllIl);
        return (llllllllllllllIlllllllllIllIllII < 0) ? ((llllllllllllllIlllllllllIllIlIlI < 0) ? llllllllllllllIlllllllllIlllIIIl : ((llllllllllllllIlllllllllIllIlIll < 0) ? llllllllllllllIlllllllllIlllIIII : llllllllllllllIlllllllllIlllIIlI)) : ((llllllllllllllIlllllllllIllIlIlI > 0) ? llllllllllllllIlllllllllIlllIIIl : ((llllllllllllllIlllllllllIllIlIll > 0) ? llllllllllllllIlllllllllIlllIIII : llllllllllllllIlllllllllIlllIIlI));
    }
    
    public static <K> void mergeSort(final K[] llllllllllllllIlllllllIlIIllIlll, final int llllllllllllllIlllllllIlIIllIllI, final int llllllllllllllIlllllllIlIIlllIII) {
        mergeSort(llllllllllllllIlllllllIlIIllIlll, llllllllllllllIlllllllIlIIllIllI, llllllllllllllIlllllllIlIIlllIII, llllllllllllllIlllllllIlIIllIlll.clone());
    }
    
    public static <K> int binarySearch(final K[] llllllllllllllIlllllllIIlIllllIl, int llllllllllllllIlllllllIIlIllIlll, int llllllllllllllIlllllllIIlIllIllI, final K llllllllllllllIlllllllIIlIllIlIl, final Comparator<K> llllllllllllllIlllllllIIlIllIlII) {
        --llllllllllllllIlllllllIIlIllIllI;
        while (llllllllllllllIlllllllIIlIllIlll <= llllllllllllllIlllllllIIlIllIllI) {
            final int llllllllllllllIlllllllIIllIIIIII = (int)(llllllllllllllIlllllllIIlIllIlll + llllllllllllllIlllllllIIlIllIllI >>> 1);
            final K llllllllllllllIlllllllIIlIlllllI = llllllllllllllIlllllllIIlIllllIl[llllllllllllllIlllllllIIllIIIIII];
            final int llllllllllllllIlllllllIIlIllllll = llllllllllllllIlllllllIIlIllIlII.compare(llllllllllllllIlllllllIIlIlllllI, llllllllllllllIlllllllIIlIllIlIl);
            if (llllllllllllllIlllllllIIlIllllll < 0) {
                llllllllllllllIlllllllIIlIllIlll = llllllllllllllIlllllllIIllIIIIII + 1;
            }
            else {
                if (llllllllllllllIlllllllIIlIllllll <= 0) {
                    return llllllllllllllIlllllllIIllIIIIII;
                }
                llllllllllllllIlllllllIIlIllIllI = llllllllllllllIlllllllIIllIIIIII - 1;
            }
        }
        return (int)(-(llllllllllllllIlllllllIIlIllIlll + 1));
    }
    
    private static <K> int med3(final K[] llllllllllllllIlllllllllllllIIIl, final int llllllllllllllIllllllllllllIlIIl, final int llllllllllllllIllllllllllllIllll, final int llllllllllllllIllllllllllllIIlll) {
        final int llllllllllllllIllllllllllllIllIl = ((Comparable)llllllllllllllIlllllllllllllIIIl[llllllllllllllIllllllllllllIlIIl]).compareTo(llllllllllllllIlllllllllllllIIIl[llllllllllllllIllllllllllllIllll]);
        final int llllllllllllllIllllllllllllIllII = ((Comparable)llllllllllllllIlllllllllllllIIIl[llllllllllllllIllllllllllllIlIIl]).compareTo(llllllllllllllIlllllllllllllIIIl[llllllllllllllIllllllllllllIIlll]);
        final int llllllllllllllIllllllllllllIlIll = ((Comparable)llllllllllllllIlllllllllllllIIIl[llllllllllllllIllllllllllllIllll]).compareTo(llllllllllllllIlllllllllllllIIIl[llllllllllllllIllllllllllllIIlll]);
        return (llllllllllllllIllllllllllllIllIl < 0) ? ((llllllllllllllIllllllllllllIlIll < 0) ? llllllllllllllIllllllllllllIllll : ((llllllllllllllIllllllllllllIllII < 0) ? llllllllllllllIllllllllllllIIlll : llllllllllllllIllllllllllllIlIIl)) : ((llllllllllllllIllllllllllllIlIll > 0) ? llllllllllllllIllllllllllllIllll : ((llllllllllllllIllllllllllllIllII > 0) ? llllllllllllllIllllllllllllIIlll : llllllllllllllIllllllllllllIlIIl));
    }
    
    public static <K> void ensureFromTo(final K[] lllllllllllllllIIIIIIIIIlIllIIll, final int lllllllllllllllIIIIIIIIIlIllIlIl, final int lllllllllllllllIIIIIIIIIlIllIIIl) {
        com.viaversion.viaversion.libs.fastutil.Arrays.ensureFromTo(lllllllllllllllIIIIIIIIIlIllIIll.length, lllllllllllllllIIIIIIIIIlIllIlIl, lllllllllllllllIIIIIIIIIlIllIIIl);
    }
    
    public static <K> K[] ensureCapacity(final K[] lllllllllllllllIIIIIIIIlIIIllIlI, final int lllllllllllllllIIIIIIIIlIIIllIIl) {
        return ensureCapacity(lllllllllllllllIIIIIIIIlIIIllIlI, lllllllllllllllIIIIIIIIlIIIllIIl, lllllllllllllllIIIIIIIIlIIIllIlI.length);
    }
    
    public static <K> void parallelQuickSort(final K[] llllllllllllllIllllllllllIIIlIIl, final int llllllllllllllIllllllllllIIIlIII, final int llllllllllllllIllllllllllIIIIlII) {
        if (llllllllllllllIllllllllllIIIIlII - llllllllllllllIllllllllllIIIlIII < 8192) {
            quickSort((Object[])llllllllllllllIllllllllllIIIlIIl, llllllllllllllIllllllllllIIIlIII, llllllllllllllIllllllllllIIIIlII);
        }
        else {
            final ForkJoinPool llllllllllllllIllllllllllIIIlIlI = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            llllllllllllllIllllllllllIIIlIlI.invoke(new ForkJoinQuickSort(llllllllllllllIllllllllllIIIlIIl, llllllllllllllIllllllllllIIIlIII, llllllllllllllIllllllllllIIIIlII));
            llllllllllllllIllllllllllIIIlIlI.shutdown();
        }
    }
    
    public static <K> K[] shuffle(final K[] llllllllllllllIlllllllIIlIIIlIlI, final Random llllllllllllllIlllllllIIlIIIIlll) {
        int llllllllllllllIlllllllIIlIIIlIll = llllllllllllllIlllllllIIlIIIlIlI.length;
        while (llllllllllllllIlllllllIIlIIIlIll-- != 0) {
            final int llllllllllllllIlllllllIIlIIIllIl = llllllllllllllIlllllllIIlIIIIlll.nextInt(llllllllllllllIlllllllIIlIIIlIll + 1);
            final K llllllllllllllIlllllllIIlIIIllII = llllllllllllllIlllllllIIlIIIlIlI[llllllllllllllIlllllllIIlIIIlIll];
            llllllllllllllIlllllllIIlIIIlIlI[llllllllllllllIlllllllIIlIIIlIll] = llllllllllllllIlllllllIIlIIIlIlI[llllllllllllllIlllllllIIlIIIllIl];
            llllllllllllllIlllllllIIlIIIlIlI[llllllllllllllIlllllllIIlIIIllIl] = llllllllllllllIlllllllIIlIIIllII;
        }
        return llllllllllllllIlllllllIIlIIIlIlI;
    }
    
    public static <K> int binarySearch(final K[] llllllllllllllIlllllllIIllIIllII, final K llllllllllllllIlllllllIIllIIlIll) {
        return binarySearch(llllllllllllllIlllllllIIllIIllII, 0, llllllllllllllIlllllllIIllIIllII.length, llllllllllllllIlllllllIIllIIlIll);
    }
    
    public static <K> void unstableSort(final K[] llllllllllllllIlllllllIlIlIlllII, final Comparator<K> llllllllllllllIlllllllIlIlIllIll) {
        unstableSort(llllllllllllllIlllllllIlIlIlllII, 0, llllllllllllllIlllllllIlIlIlllII.length, llllllllllllllIlllllllIlIlIllIll);
    }
    
    private static <K> void swap(final K[] llllllllllllllIllllllllIIIllIlII, final K[] llllllllllllllIllllllllIIIlIIlll, int llllllllllllllIllllllllIIIllIIII, int llllllllllllllIllllllllIIIlIIIlI, final int llllllllllllllIllllllllIIIlIIIII) {
        for (int llllllllllllllIllllllllIIIllIllI = 0; llllllllllllllIllllllllIIIllIllI < llllllllllllllIllllllllIIIlIIIII; ++llllllllllllllIllllllllIIIllIllI, ++llllllllllllllIllllllllIIIllIIII, ++llllllllllllllIllllllllIIIlIIIlI) {
            swap(llllllllllllllIllllllllIIIllIlII, llllllllllllllIllllllllIIIlIIlll, llllllllllllllIllllllllIIIllIIII, llllllllllllllIllllllllIIIlIIIlI);
        }
    }
    
    public static <K> void stableSort(final K[] llllllllllllllIlllllllIIlllIIlIl, final Comparator<K> llllllllllllllIlllllllIIlllIIllI) {
        stableSort(llllllllllllllIlllllllIIlllIIlIl, 0, llllllllllllllIlllllllIIlllIIlIl.length, llllllllllllllIlllllllIIlllIIllI);
    }
    
    public static <K> void parallelQuickSortIndirect(final int[] llllllllllllllIlllllllllIIIIIllI, final K[] llllllllllllllIlllllllllIIIIIIIl, final int llllllllllllllIlllllllllIIIIIIII, final int llllllllllllllIlllllllllIIIIIIll) {
        if (llllllllllllllIlllllllllIIIIIIll - llllllllllllllIlllllllllIIIIIIII < 8192) {
            quickSortIndirect(llllllllllllllIlllllllllIIIIIllI, (Object[])llllllllllllllIlllllllllIIIIIIIl, llllllllllllllIlllllllllIIIIIIII, llllllllllllllIlllllllllIIIIIIll);
        }
        else {
            final ForkJoinPool llllllllllllllIlllllllllIIIIIlll = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            llllllllllllllIlllllllllIIIIIlll.invoke(new ForkJoinQuickSortIndirect(llllllllllllllIlllllllllIIIIIllI, llllllllllllllIlllllllllIIIIIIIl, llllllllllllllIlllllllllIIIIIIII, llllllllllllllIlllllllllIIIIIIll));
            llllllllllllllIlllllllllIIIIIlll.shutdown();
        }
    }
    
    public static <K> void mergeSort(final K[] llllllllllllllIlllllllIlIlIIllII, final int llllllllllllllIlllllllIlIlIIlIll, final int llllllllllllllIlllllllIlIlIIlIlI, final K[] llllllllllllllIlllllllIlIlIIIIll) {
        final int llllllllllllllIlllllllIlIlIIlIII = llllllllllllllIlllllllIlIlIIlIlI - llllllllllllllIlllllllIlIlIIlIll;
        if (llllllllllllllIlllllllIlIlIIlIII < 16) {
            insertionSort(llllllllllllllIlllllllIlIlIIllII, llllllllllllllIlllllllIlIlIIlIll, llllllllllllllIlllllllIlIlIIlIlI);
            return;
        }
        final int llllllllllllllIlllllllIlIlIIIlll = llllllllllllllIlllllllIlIlIIlIll + llllllllllllllIlllllllIlIlIIlIlI >>> 1;
        mergeSort(llllllllllllllIlllllllIlIlIIIIll, llllllllllllllIlllllllIlIlIIlIll, llllllllllllllIlllllllIlIlIIIlll, (Object[])llllllllllllllIlllllllIlIlIIllII);
        mergeSort(llllllllllllllIlllllllIlIlIIIIll, llllllllllllllIlllllllIlIlIIIlll, llllllllllllllIlllllllIlIlIIlIlI, (Object[])llllllllllllllIlllllllIlIlIIllII);
        if (((Comparable)llllllllllllllIlllllllIlIlIIIIll[llllllllllllllIlllllllIlIlIIIlll - 1]).compareTo(llllllllllllllIlllllllIlIlIIIIll[llllllllllllllIlllllllIlIlIIIlll]) <= 0) {
            System.arraycopy(llllllllllllllIlllllllIlIlIIIIll, llllllllllllllIlllllllIlIlIIlIll, llllllllllllllIlllllllIlIlIIllII, llllllllllllllIlllllllIlIlIIlIll, llllllllllllllIlllllllIlIlIIlIII);
            return;
        }
        int llllllllllllllIlllllllIlIlIIllll = llllllllllllllIlllllllIlIlIIlIll;
        int llllllllllllllIlllllllIlIlIIlllI = llllllllllllllIlllllllIlIlIIlIll;
        int llllllllllllllIlllllllIlIlIIllIl = llllllllllllllIlllllllIlIlIIIlll;
        while (llllllllllllllIlllllllIlIlIIllll < llllllllllllllIlllllllIlIlIIlIlI) {
            if (llllllllllllllIlllllllIlIlIIllIl >= llllllllllllllIlllllllIlIlIIlIlI || (llllllllllllllIlllllllIlIlIIlllI < llllllllllllllIlllllllIlIlIIIlll && ((Comparable)llllllllllllllIlllllllIlIlIIIIll[llllllllllllllIlllllllIlIlIIlllI]).compareTo(llllllllllllllIlllllllIlIlIIIIll[llllllllllllllIlllllllIlIlIIllIl]) <= 0)) {
                llllllllllllllIlllllllIlIlIIllII[llllllllllllllIlllllllIlIlIIllll] = llllllllllllllIlllllllIlIlIIIIll[llllllllllllllIlllllllIlIlIIlllI++];
            }
            else {
                llllllllllllllIlllllllIlIlIIllII[llllllllllllllIlllllllIlIlIIllll] = llllllllllllllIlllllllIlIlIIIIll[llllllllllllllIlllllllIlIlIIllIl++];
            }
            ++llllllllllllllIlllllllIlIlIIllll;
        }
    }
    
    public static <K> void stabilize(final int[] llllllllllllllIllllllllIllIllllI, final K[] llllllllllllllIllllllllIlllIlIII, final int llllllllllllllIllllllllIllIllIlI, final int llllllllllllllIllllllllIlllIIIll) {
        int llllllllllllllIllllllllIlllIIIII = llllllllllllllIllllllllIllIllIlI;
        for (int llllllllllllllIllllllllIlllIlIlI = llllllllllllllIllllllllIllIllIlI + 1; llllllllllllllIllllllllIlllIlIlI < llllllllllllllIllllllllIlllIIIll; ++llllllllllllllIllllllllIlllIlIlI) {
            if (llllllllllllllIllllllllIlllIlIII[llllllllllllllIllllllllIllIllllI[llllllllllllllIllllllllIlllIlIlI]] != llllllllllllllIllllllllIlllIlIII[llllllllllllllIllllllllIllIllllI[llllllllllllllIllllllllIlllIIIII]]) {
                if (llllllllllllllIllllllllIlllIlIlI - llllllllllllllIllllllllIlllIIIII > 1) {
                    IntArrays.parallelQuickSort(llllllllllllllIllllllllIllIllllI, llllllllllllllIllllllllIlllIIIII, llllllllllllllIllllllllIlllIlIlI);
                }
                llllllllllllllIllllllllIlllIIIII = llllllllllllllIllllllllIlllIlIlI;
            }
        }
        if (llllllllllllllIllllllllIlllIIIll - llllllllllllllIllllllllIlllIIIII > 1) {
            IntArrays.parallelQuickSort(llllllllllllllIllllllllIllIllllI, llllllllllllllIllllllllIlllIIIII, llllllllllllllIllllllllIlllIIIll);
        }
    }
    
    private static <K> void insertionSort(final K[] llllllllllllllIlllllllllllIIIlIl, final int llllllllllllllIlllllllllllIIIlII, final int llllllllllllllIlllllllllllIIIIII) {
        int llllllllllllllIlllllllllllIIIllI = llllllllllllllIlllllllllllIIIlII;
        while (++llllllllllllllIlllllllllllIIIllI < llllllllllllllIlllllllllllIIIIII) {
            final K llllllllllllllIlllllllllllIIlIII = llllllllllllllIlllllllllllIIIlIl[llllllllllllllIlllllllllllIIIllI];
            int llllllllllllllIlllllllllllIIIlll = llllllllllllllIlllllllllllIIIllI;
            for (K llllllllllllllIlllllllllllIIlIIl = llllllllllllllIlllllllllllIIIlIl[llllllllllllllIlllllllllllIIIlll - 1]; ((Comparable)llllllllllllllIlllllllllllIIlIII).compareTo(llllllllllllllIlllllllllllIIlIIl) < 0; llllllllllllllIlllllllllllIIlIIl = llllllllllllllIlllllllllllIIIlIl[--llllllllllllllIlllllllllllIIIlll - 1]) {
                llllllllllllllIlllllllllllIIIlIl[llllllllllllllIlllllllllllIIIlll] = llllllllllllllIlllllllllllIIlIIl;
                if (llllllllllllllIlllllllllllIIIlII == llllllllllllllIlllllllllllIIIlll - 1) {
                    --llllllllllllllIlllllllllllIIIlll;
                    break;
                }
            }
            llllllllllllllIlllllllllllIIIlIl[llllllllllllllIlllllllllllIIIlll] = llllllllllllllIlllllllllllIIlIII;
        }
    }
    
    private static <K> void selectionSort(final K[] lllllllllllllllIIIIIIIIIIllIIIll, final int lllllllllllllllIIIIIIIIIIlIllllI, final int lllllllllllllllIIIIIIIIIIlIlllIl, final Comparator<K> lllllllllllllllIIIIIIIIIIlIlllII) {
        for (int lllllllllllllllIIIIIIIIIIllIIlII = lllllllllllllllIIIIIIIIIIlIllllI; lllllllllllllllIIIIIIIIIIllIIlII < lllllllllllllllIIIIIIIIIIlIlllIl - 1; ++lllllllllllllllIIIIIIIIIIllIIlII) {
            int lllllllllllllllIIIIIIIIIIllIIlIl = lllllllllllllllIIIIIIIIIIllIIlII;
            for (int lllllllllllllllIIIIIIIIIIllIIlll = lllllllllllllllIIIIIIIIIIllIIlII + 1; lllllllllllllllIIIIIIIIIIllIIlll < lllllllllllllllIIIIIIIIIIlIlllIl; ++lllllllllllllllIIIIIIIIIIllIIlll) {
                if (lllllllllllllllIIIIIIIIIIlIlllII.compare(lllllllllllllllIIIIIIIIIIllIIIll[lllllllllllllllIIIIIIIIIIllIIlll], lllllllllllllllIIIIIIIIIIllIIIll[lllllllllllllllIIIIIIIIIIllIIlIl]) < 0) {
                    lllllllllllllllIIIIIIIIIIllIIlIl = lllllllllllllllIIIIIIIIIIllIIlll;
                }
            }
            if (lllllllllllllllIIIIIIIIIIllIIlIl != lllllllllllllllIIIIIIIIIIllIIlII) {
                final K lllllllllllllllIIIIIIIIIIllIIllI = lllllllllllllllIIIIIIIIIIllIIIll[lllllllllllllllIIIIIIIIIIllIIlII];
                lllllllllllllllIIIIIIIIIIllIIIll[lllllllllllllllIIIIIIIIIIllIIlII] = lllllllllllllllIIIIIIIIIIllIIIll[lllllllllllllllIIIIIIIIIIllIIlIl];
                lllllllllllllllIIIIIIIIIIllIIIll[lllllllllllllllIIIIIIIIIIllIIlIl] = lllllllllllllllIIIIIIIIIIllIIllI;
            }
        }
    }
    
    public static <K> void unstableSort(final K[] llllllllllllllIlllllllIlIllIlIll) {
        unstableSort(llllllllllllllIlllllllIlIllIlIll, 0, llllllllllllllIlllllllIlIllIlIll.length);
    }
    
    private static <K> void selectionSort(final K[] llllllllllllllIlllllllllllIllIIl, final int llllllllllllllIlllllllllllIllIII, final int llllllllllllllIlllllllllllIlIlII) {
        for (int llllllllllllllIlllllllllllIllIlI = llllllllllllllIlllllllllllIllIII; llllllllllllllIlllllllllllIllIlI < llllllllllllllIlllllllllllIlIlII - 1; ++llllllllllllllIlllllllllllIllIlI) {
            int llllllllllllllIlllllllllllIllIll = llllllllllllllIlllllllllllIllIlI;
            for (int llllllllllllllIlllllllllllIlllIl = llllllllllllllIlllllllllllIllIlI + 1; llllllllllllllIlllllllllllIlllIl < llllllllllllllIlllllllllllIlIlII; ++llllllllllllllIlllllllllllIlllIl) {
                if (((Comparable)llllllllllllllIlllllllllllIllIIl[llllllllllllllIlllllllllllIlllIl]).compareTo(llllllllllllllIlllllllllllIllIIl[llllllllllllllIlllllllllllIllIll]) < 0) {
                    llllllllllllllIlllllllllllIllIll = llllllllllllllIlllllllllllIlllIl;
                }
            }
            if (llllllllllllllIlllllllllllIllIll != llllllllllllllIlllllllllllIllIlI) {
                final K llllllllllllllIlllllllllllIlllII = llllllllllllllIlllllllllllIllIIl[llllllllllllllIlllllllllllIllIlI];
                llllllllllllllIlllllllllllIllIIl[llllllllllllllIlllllllllllIllIlI] = llllllllllllllIlllllllllllIllIIl[llllllllllllllIlllllllllllIllIll];
                llllllllllllllIlllllllllllIllIIl[llllllllllllllIlllllllllllIllIll] = llllllllllllllIlllllllllllIlllII;
            }
        }
    }
    
    public static <K> void unstableSort(final K[] llllllllllllllIlllllllIlIllIIllI, final int llllllllllllllIlllllllIlIllIIIIl, final int llllllllllllllIlllllllIlIllIIIII, final Comparator<K> llllllllllllllIlllllllIlIllIIIll) {
        quickSort(llllllllllllllIlllllllIlIllIIllI, llllllllllllllIlllllllIlIllIIIIl, llllllllllllllIlllllllIlIllIIIII, (Comparator<Object>)llllllllllllllIlllllllIlIllIIIll);
    }
    
    public static <K> void parallelQuickSort(final K[] llllllllllllllIllllllllllIIIIIII) {
        parallelQuickSort(llllllllllllllIllllllllllIIIIIII, 0, llllllllllllllIllllllllllIIIIIII.length);
    }
    
    public static <K> void ensureOffsetLength(final K[] lllllllllllllllIIIIIIIIIlIlIllIl, final int lllllllllllllllIIIIIIIIIlIlIlIIl, final int lllllllllllllllIIIIIIIIIlIlIlIII) {
        com.viaversion.viaversion.libs.fastutil.Arrays.ensureOffsetLength(lllllllllllllllIIIIIIIIIlIlIllIl.length, lllllllllllllllIIIIIIIIIlIlIlIIl, lllllllllllllllIIIIIIIIIlIlIlIII);
    }
    
    private static <K> void insertionSort(final K[] lllllllllllllllIIIIIIIIIIlIIllII, final int lllllllllllllllIIIIIIIIIIlIIlIll, final int lllllllllllllllIIIIIIIIIIlIIlIlI, final Comparator<K> lllllllllllllllIIIIIIIIIIlIIlIIl) {
        int lllllllllllllllIIIIIIIIIIlIIllIl = lllllllllllllllIIIIIIIIIIlIIlIll;
        while (++lllllllllllllllIIIIIIIIIIlIIllIl < lllllllllllllllIIIIIIIIIIlIIlIlI) {
            final K lllllllllllllllIIIIIIIIIIlIIllll = lllllllllllllllIIIIIIIIIIlIIllII[lllllllllllllllIIIIIIIIIIlIIllIl];
            int lllllllllllllllIIIIIIIIIIlIIlllI = lllllllllllllllIIIIIIIIIIlIIllIl;
            for (K lllllllllllllllIIIIIIIIIIlIlIIII = lllllllllllllllIIIIIIIIIIlIIllII[lllllllllllllllIIIIIIIIIIlIIlllI - 1]; lllllllllllllllIIIIIIIIIIlIIlIIl.compare(lllllllllllllllIIIIIIIIIIlIIllll, lllllllllllllllIIIIIIIIIIlIlIIII) < 0; lllllllllllllllIIIIIIIIIIlIlIIII = lllllllllllllllIIIIIIIIIIlIIllII[--lllllllllllllllIIIIIIIIIIlIIlllI - 1]) {
                lllllllllllllllIIIIIIIIIIlIIllII[lllllllllllllllIIIIIIIIIIlIIlllI] = lllllllllllllllIIIIIIIIIIlIlIIII;
                if (lllllllllllllllIIIIIIIIIIlIIlIll == lllllllllllllllIIIIIIIIIIlIIlllI - 1) {
                    --lllllllllllllllIIIIIIIIIIlIIlllI;
                    break;
                }
            }
            lllllllllllllllIIIIIIIIIIlIIllII[lllllllllllllllIIIIIIIIIIlIIlllI] = lllllllllllllllIIIIIIIIIIlIIllll;
        }
    }
    
    public static <K> void stableSort(final K[] llllllllllllllIlllllllIIllllIlll) {
        stableSort(llllllllllllllIlllllllIIllllIlll, 0, llllllllllllllIlllllllIIllllIlll.length);
    }
    
    public static <K> void parallelQuickSort(final K[] llllllllllllllIllllllllllllllIlI, final Comparator<K> llllllllllllllIllllllllllllllIIl) {
        parallelQuickSort(llllllllllllllIllllllllllllllIlI, 0, llllllllllllllIllllllllllllllIlI.length, llllllllllllllIllllllllllllllIIl);
    }
    
    public static <K> void quickSortIndirect(final int[] llllllllllllllIlllllllllIIIlIlII, final K[] llllllllllllllIlllllllllIIIlIIIl) {
        quickSortIndirect(llllllllllllllIlllllllllIIIlIlII, llllllllllllllIlllllllllIIIlIIIl, 0, llllllllllllllIlllllllllIIIlIIIl.length);
    }
    
    public static <K> K[] forceCapacity(final K[] lllllllllllllllIIIIIIIIlIIlIIIII, final int lllllllllllllllIIIIIIIIlIIIlllll, final int lllllllllllllllIIIIIIIIlIIlIIIlI) {
        final K[] lllllllllllllllIIIIIIIIlIIlIIIIl = newArray(lllllllllllllllIIIIIIIIlIIlIIIII, lllllllllllllllIIIIIIIIlIIIlllll);
        System.arraycopy(lllllllllllllllIIIIIIIIlIIlIIIII, 0, lllllllllllllllIIIIIIIIlIIlIIIIl, 0, lllllllllllllllIIIIIIIIlIIlIIIlI);
        return lllllllllllllllIIIIIIIIlIIlIIIIl;
    }
    
    public static <K> int binarySearch(final K[] llllllllllllllIlllllllIIlIlIlIlI, final K llllllllllllllIlllllllIIlIlIlIIl, final Comparator<K> llllllllllllllIlllllllIIlIlIlIll) {
        return binarySearch(llllllllllllllIlllllllIIlIlIlIlI, 0, llllllllllllllIlllllllIIlIlIlIlI.length, llllllllllllllIlllllllIIlIlIlIIl, llllllllllllllIlllllllIIlIlIlIll);
    }
    
    private static <K> void swap(final K[] llllllllllllllIllllllllIIlIlIIIl, final K[] llllllllllllllIllllllllIIlIlIIII, final int llllllllllllllIllllllllIIlIlIlIl, final int llllllllllllllIllllllllIIlIlIlII) {
        final K llllllllllllllIllllllllIIlIlIIll = llllllllllllllIllllllllIIlIlIIIl[llllllllllllllIllllllllIIlIlIlIl];
        final K llllllllllllllIllllllllIIlIlIIlI = llllllllllllllIllllllllIIlIlIIII[llllllllllllllIllllllllIIlIlIlIl];
        llllllllllllllIllllllllIIlIlIIIl[llllllllllllllIllllllllIIlIlIlIl] = llllllllllllllIllllllllIIlIlIIIl[llllllllllllllIllllllllIIlIlIlII];
        llllllllllllllIllllllllIIlIlIIII[llllllllllllllIllllllllIIlIlIlIl] = llllllllllllllIllllllllIIlIlIIII[llllllllllllllIllllllllIIlIlIlII];
        llllllllllllllIllllllllIIlIlIIIl[llllllllllllllIllllllllIIlIlIlII] = llllllllllllllIllllllllIIlIlIIll;
        llllllllllllllIllllllllIIlIlIIII[llllllllllllllIllllllllIIlIlIlII] = llllllllllllllIllllllllIIlIlIIlI;
    }
    
    private static final class ArrayHashStrategy<K> implements Hash.Strategy<K[]>, Serializable
    {
        @Override
        public boolean equals(final K[] llllllllllllllIllIllIlIIllllllll, final K[] llllllllllllllIllIllIlIlIIIIIIII) {
            return Arrays.equals(llllllllllllllIllIllIlIIllllllll, llllllllllllllIllIllIlIlIIIIIIII);
        }
        
        @Override
        public int hashCode(final K[] llllllllllllllIllIllIlIlIIIIIllI) {
            return Arrays.hashCode(llllllllllllllIllIllIlIlIIIIIllI);
        }
    }
    
    protected static class ForkJoinQuickSortComp<K> extends RecursiveAction
    {
        private final /* synthetic */ K[] x;
        private final /* synthetic */ int to;
        private final /* synthetic */ Comparator<K> comp;
        private final /* synthetic */ int from;
        
        public ForkJoinQuickSortComp(final K[] llllllllllllllIlIIIllIllllIlIIlI, final int llllllllllllllIlIIIllIllllIlIIIl, final int llllllllllllllIlIIIllIllllIlIIII, final Comparator<K> llllllllllllllIlIIIllIllllIlIlII) {
            this.from = llllllllllllllIlIIIllIllllIlIIIl;
            this.to = llllllllllllllIlIIIllIllllIlIIII;
            this.x = llllllllllllllIlIIIllIllllIlIIlI;
            this.comp = llllllllllllllIlIIIllIllllIlIlII;
        }
        
        @Override
        protected void compute() {
            final K[] llllllllllllllIlIIIllIlllIlllllI = this.x;
            final int llllllllllllllIlIIIllIlllIllllIl = this.to - this.from;
            if (llllllllllllllIlIIIllIlllIllllIl < 8192) {
                ObjectArrays.quickSort(llllllllllllllIlIIIllIlllIlllllI, this.from, this.to, this.comp);
                return;
            }
            int llllllllllllllIlIIIllIlllIllllII = this.from + llllllllllllllIlIIIllIlllIllllIl / 2;
            int llllllllllllllIlIIIllIlllIlllIll = this.from;
            int llllllllllllllIlIIIllIlllIlllIlI = this.to - 1;
            int llllllllllllllIlIIIllIlllIlllIIl = llllllllllllllIlIIIllIlllIllllIl / 8;
            llllllllllllllIlIIIllIlllIlllIll = med3(llllllllllllllIlIIIllIlllIlllllI, llllllllllllllIlIIIllIlllIlllIll, llllllllllllllIlIIIllIlllIlllIll + llllllllllllllIlIIIllIlllIlllIIl, llllllllllllllIlIIIllIlllIlllIll + 2 * llllllllllllllIlIIIllIlllIlllIIl, this.comp);
            llllllllllllllIlIIIllIlllIllllII = med3(llllllllllllllIlIIIllIlllIlllllI, llllllllllllllIlIIIllIlllIllllII - llllllllllllllIlIIIllIlllIlllIIl, llllllllllllllIlIIIllIlllIllllII, llllllllllllllIlIIIllIlllIllllII + llllllllllllllIlIIIllIlllIlllIIl, this.comp);
            llllllllllllllIlIIIllIlllIlllIlI = med3(llllllllllllllIlIIIllIlllIlllllI, llllllllllllllIlIIIllIlllIlllIlI - 2 * llllllllllllllIlIIIllIlllIlllIIl, llllllllllllllIlIIIllIlllIlllIlI - llllllllllllllIlIIIllIlllIlllIIl, llllllllllllllIlIIIllIlllIlllIlI, this.comp);
            llllllllllllllIlIIIllIlllIllllII = med3(llllllllllllllIlIIIllIlllIlllllI, llllllllllllllIlIIIllIlllIlllIll, llllllllllllllIlIIIllIlllIllllII, llllllllllllllIlIIIllIlllIlllIlI, this.comp);
            final K llllllllllllllIlIIIllIlllIlllIII = llllllllllllllIlIIIllIlllIlllllI[llllllllllllllIlIIIllIlllIllllII];
            int llllllllllllllIlIIIllIlllIllIllI;
            int llllllllllllllIlIIIllIlllIllIlll = llllllllllllllIlIIIllIlllIllIllI = this.from;
            int llllllllllllllIlIIIllIlllIllIlII;
            int llllllllllllllIlIIIllIlllIllIlIl = llllllllllllllIlIIIllIlllIllIlII = this.to - 1;
            while (true) {
                final int llllllllllllllIlIIIllIllllIIIIIl;
                if (llllllllllllllIlIIIllIlllIllIllI <= llllllllllllllIlIIIllIlllIllIlIl && (llllllllllllllIlIIIllIllllIIIIIl = this.comp.compare(llllllllllllllIlIIIllIlllIlllllI[llllllllllllllIlIIIllIlllIllIllI], llllllllllllllIlIIIllIlllIlllIII)) <= 0) {
                    if (llllllllllllllIlIIIllIllllIIIIIl == 0) {
                        ObjectArrays.swap(llllllllllllllIlIIIllIlllIlllllI, llllllllllllllIlIIIllIlllIllIlll++, llllllllllllllIlIIIllIlllIllIllI);
                    }
                    ++llllllllllllllIlIIIllIlllIllIllI;
                }
                else {
                    int llllllllllllllIlIIIllIllllIIIIII;
                    while (llllllllllllllIlIIIllIlllIllIlIl >= llllllllllllllIlIIIllIlllIllIllI && (llllllllllllllIlIIIllIllllIIIIII = this.comp.compare(llllllllllllllIlIIIllIlllIlllllI[llllllllllllllIlIIIllIlllIllIlIl], llllllllllllllIlIIIllIlllIlllIII)) >= 0) {
                        if (llllllllllllllIlIIIllIllllIIIIII == 0) {
                            ObjectArrays.swap(llllllllllllllIlIIIllIlllIlllllI, llllllllllllllIlIIIllIlllIllIlIl, llllllllllllllIlIIIllIlllIllIlII--);
                        }
                        --llllllllllllllIlIIIllIlllIllIlIl;
                    }
                    if (llllllllllllllIlIIIllIlllIllIllI > llllllllllllllIlIIIllIlllIllIlIl) {
                        break;
                    }
                    ObjectArrays.swap(llllllllllllllIlIIIllIlllIlllllI, llllllllllllllIlIIIllIlllIllIllI++, llllllllllllllIlIIIllIlllIllIlIl--);
                }
            }
            llllllllllllllIlIIIllIlllIlllIIl = Math.min(llllllllllllllIlIIIllIlllIllIlll - this.from, llllllllllllllIlIIIllIlllIllIllI - llllllllllllllIlIIIllIlllIllIlll);
            ObjectArrays.swap(llllllllllllllIlIIIllIlllIlllllI, this.from, llllllllllllllIlIIIllIlllIllIllI - llllllllllllllIlIIIllIlllIlllIIl, llllllllllllllIlIIIllIlllIlllIIl);
            llllllllllllllIlIIIllIlllIlllIIl = Math.min(llllllllllllllIlIIIllIlllIllIlII - llllllllllllllIlIIIllIlllIllIlIl, this.to - llllllllllllllIlIIIllIlllIllIlII - 1);
            ObjectArrays.swap(llllllllllllllIlIIIllIlllIlllllI, llllllllllllllIlIIIllIlllIllIllI, this.to - llllllllllllllIlIIIllIlllIlllIIl, llllllllllllllIlIIIllIlllIlllIIl);
            llllllllllllllIlIIIllIlllIlllIIl = llllllllllllllIlIIIllIlllIllIllI - llllllllllllllIlIIIllIlllIllIlll;
            final int llllllllllllllIlIIIllIlllIllIIll = llllllllllllllIlIIIllIlllIllIlII - llllllllllllllIlIIIllIlllIllIlIl;
            if (llllllllllllllIlIIIllIlllIlllIIl > 1 && llllllllllllllIlIIIllIlllIllIIll > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortComp<Object>((Object[])llllllllllllllIlIIIllIlllIlllllI, this.from, this.from + llllllllllllllIlIIIllIlllIlllIIl, (Comparator<?>)this.comp), new ForkJoinQuickSortComp<Object>((Object[])llllllllllllllIlIIIllIlllIlllllI, this.to - llllllllllllllIlIIIllIlllIllIIll, this.to, (Comparator<?>)this.comp));
            }
            else if (llllllllllllllIlIIIllIlllIlllIIl > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortComp(llllllllllllllIlIIIllIlllIlllllI, this.from, this.from + llllllllllllllIlIIIllIlllIlllIIl, this.comp));
            }
            else {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortComp(llllllllllllllIlIIIllIlllIlllllI, this.to - llllllllllllllIlIIIllIlllIllIIll, this.to, this.comp));
            }
        }
    }
    
    protected static class ForkJoinQuickSort2<K> extends RecursiveAction
    {
        private final /* synthetic */ K[] x;
        private final /* synthetic */ K[] y;
        private final /* synthetic */ int to;
        private final /* synthetic */ int from;
        
        @Override
        protected void compute() {
            final K[] lllllllllllllIIIIIIlllllllIIllII = this.x;
            final K[] lllllllllllllIIIIIIlllllllIIlIll = this.y;
            final int lllllllllllllIIIIIIlllllllIIlIlI = this.to - this.from;
            if (lllllllllllllIIIIIIlllllllIIlIlI < 8192) {
                ObjectArrays.quickSort(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, this.from, this.to);
                return;
            }
            int lllllllllllllIIIIIIlllllllIIlIIl = this.from + lllllllllllllIIIIIIlllllllIIlIlI / 2;
            int lllllllllllllIIIIIIlllllllIIlIII = this.from;
            int lllllllllllllIIIIIIlllllllIIIlll = this.to - 1;
            int lllllllllllllIIIIIIlllllllIIIllI = lllllllllllllIIIIIIlllllllIIlIlI / 8;
            lllllllllllllIIIIIIlllllllIIlIII = med3(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, lllllllllllllIIIIIIlllllllIIlIII, lllllllllllllIIIIIIlllllllIIlIII + lllllllllllllIIIIIIlllllllIIIllI, lllllllllllllIIIIIIlllllllIIlIII + 2 * lllllllllllllIIIIIIlllllllIIIllI);
            lllllllllllllIIIIIIlllllllIIlIIl = med3(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, lllllllllllllIIIIIIlllllllIIlIIl - lllllllllllllIIIIIIlllllllIIIllI, lllllllllllllIIIIIIlllllllIIlIIl, lllllllllllllIIIIIIlllllllIIlIIl + lllllllllllllIIIIIIlllllllIIIllI);
            lllllllllllllIIIIIIlllllllIIIlll = med3(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, lllllllllllllIIIIIIlllllllIIIlll - 2 * lllllllllllllIIIIIIlllllllIIIllI, lllllllllllllIIIIIIlllllllIIIlll - lllllllllllllIIIIIIlllllllIIIllI, lllllllllllllIIIIIIlllllllIIIlll);
            lllllllllllllIIIIIIlllllllIIlIIl = med3(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, lllllllllllllIIIIIIlllllllIIlIII, lllllllllllllIIIIIIlllllllIIlIIl, lllllllllllllIIIIIIlllllllIIIlll);
            final K lllllllllllllIIIIIIlllllllIIIlIl = lllllllllllllIIIIIIlllllllIIllII[lllllllllllllIIIIIIlllllllIIlIIl];
            final K lllllllllllllIIIIIIlllllllIIIlII = lllllllllllllIIIIIIlllllllIIlIll[lllllllllllllIIIIIIlllllllIIlIIl];
            int lllllllllllllIIIIIIlllllllIIIIlI;
            int lllllllllllllIIIIIIlllllllIIIIll = lllllllllllllIIIIIIlllllllIIIIlI = this.from;
            int lllllllllllllIIIIIIlllllllIIIIII;
            int lllllllllllllIIIIIIlllllllIIIIIl = lllllllllllllIIIIIIlllllllIIIIII = this.to - 1;
            while (true) {
                final int lllllllllllllIIIIIIlllllllIlIIII;
                final int lllllllllllllIIIIIIlllllllIlIIIl;
                if (lllllllllllllIIIIIIlllllllIIIIlI <= lllllllllllllIIIIIIlllllllIIIIIl && (lllllllllllllIIIIIIlllllllIlIIIl = (((lllllllllllllIIIIIIlllllllIlIIII = ((Comparable)lllllllllllllIIIIIIlllllllIIllII[lllllllllllllIIIIIIlllllllIIIIlI]).compareTo(lllllllllllllIIIIIIlllllllIIIlIl)) == 0) ? ((Comparable)lllllllllllllIIIIIIlllllllIIlIll[lllllllllllllIIIIIIlllllllIIIIlI]).compareTo(lllllllllllllIIIIIIlllllllIIIlII) : lllllllllllllIIIIIIlllllllIlIIII)) <= 0) {
                    if (lllllllllllllIIIIIIlllllllIlIIIl == 0) {
                        swap(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, lllllllllllllIIIIIIlllllllIIIIll++, lllllllllllllIIIIIIlllllllIIIIlI);
                    }
                    ++lllllllllllllIIIIIIlllllllIIIIlI;
                }
                else {
                    int lllllllllllllIIIIIIlllllllIIlllI;
                    int lllllllllllllIIIIIIlllllllIIllll;
                    while (lllllllllllllIIIIIIlllllllIIIIIl >= lllllllllllllIIIIIIlllllllIIIIlI && (lllllllllllllIIIIIIlllllllIIllll = (((lllllllllllllIIIIIIlllllllIIlllI = ((Comparable)lllllllllllllIIIIIIlllllllIIllII[lllllllllllllIIIIIIlllllllIIIIIl]).compareTo(lllllllllllllIIIIIIlllllllIIIlIl)) == 0) ? ((Comparable)lllllllllllllIIIIIIlllllllIIlIll[lllllllllllllIIIIIIlllllllIIIIIl]).compareTo(lllllllllllllIIIIIIlllllllIIIlII) : lllllllllllllIIIIIIlllllllIIlllI)) >= 0) {
                        if (lllllllllllllIIIIIIlllllllIIllll == 0) {
                            swap(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, lllllllllllllIIIIIIlllllllIIIIIl, lllllllllllllIIIIIIlllllllIIIIII--);
                        }
                        --lllllllllllllIIIIIIlllllllIIIIIl;
                    }
                    if (lllllllllllllIIIIIIlllllllIIIIlI > lllllllllllllIIIIIIlllllllIIIIIl) {
                        break;
                    }
                    swap(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, lllllllllllllIIIIIIlllllllIIIIlI++, lllllllllllllIIIIIIlllllllIIIIIl--);
                }
            }
            lllllllllllllIIIIIIlllllllIIIllI = Math.min(lllllllllllllIIIIIIlllllllIIIIll - this.from, lllllllllllllIIIIIIlllllllIIIIlI - lllllllllllllIIIIIIlllllllIIIIll);
            swap(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, this.from, lllllllllllllIIIIIIlllllllIIIIlI - lllllllllllllIIIIIIlllllllIIIllI, lllllllllllllIIIIIIlllllllIIIllI);
            lllllllllllllIIIIIIlllllllIIIllI = Math.min(lllllllllllllIIIIIIlllllllIIIIII - lllllllllllllIIIIIIlllllllIIIIIl, this.to - lllllllllllllIIIIIIlllllllIIIIII - 1);
            swap(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, lllllllllllllIIIIIIlllllllIIIIlI, this.to - lllllllllllllIIIIIIlllllllIIIllI, lllllllllllllIIIIIIlllllllIIIllI);
            lllllllllllllIIIIIIlllllllIIIllI = lllllllllllllIIIIIIlllllllIIIIlI - lllllllllllllIIIIIIlllllllIIIIll;
            final int lllllllllllllIIIIIIllllllIllllll = lllllllllllllIIIIIIlllllllIIIIII - lllllllllllllIIIIIIlllllllIIIIIl;
            if (lllllllllllllIIIIIIlllllllIIIllI > 1 && lllllllllllllIIIIIIllllllIllllll > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort2<Object>((Object[])lllllllllllllIIIIIIlllllllIIllII, (Object[])lllllllllllllIIIIIIlllllllIIlIll, this.from, this.from + lllllllllllllIIIIIIlllllllIIIllI), new ForkJoinQuickSort2<Object>((Object[])lllllllllllllIIIIIIlllllllIIllII, (Object[])lllllllllllllIIIIIIlllllllIIlIll, this.to - lllllllllllllIIIIIIllllllIllllll, this.to));
            }
            else if (lllllllllllllIIIIIIlllllllIIIllI > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort2(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, this.from, this.from + lllllllllllllIIIIIIlllllllIIIllI));
            }
            else {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort2(lllllllllllllIIIIIIlllllllIIllII, lllllllllllllIIIIIIlllllllIIlIll, this.to - lllllllllllllIIIIIIllllllIllllll, this.to));
            }
        }
        
        public ForkJoinQuickSort2(final K[] lllllllllllllIIIIIIllllllllIlIlI, final K[] lllllllllllllIIIIIIllllllllIlIIl, final int lllllllllllllIIIIIIllllllllIIIll, final int lllllllllllllIIIIIIllllllllIIlll) {
            this.from = lllllllllllllIIIIIIllllllllIIIll;
            this.to = lllllllllllllIIIIIIllllllllIIlll;
            this.x = lllllllllllllIIIIIIllllllllIlIlI;
            this.y = lllllllllllllIIIIIIllllllllIlIIl;
        }
    }
    
    protected static class ForkJoinQuickSort<K> extends RecursiveAction
    {
        private final /* synthetic */ int to;
        private final /* synthetic */ int from;
        private final /* synthetic */ K[] x;
        
        public ForkJoinQuickSort(final K[] lllllllllllllllllIlIlIIlIIIlIIII, final int lllllllllllllllllIlIlIIlIIIlIIll, final int lllllllllllllllllIlIlIIlIIIlIIlI) {
            this.from = lllllllllllllllllIlIlIIlIIIlIIll;
            this.to = lllllllllllllllllIlIlIIlIIIlIIlI;
            this.x = lllllllllllllllllIlIlIIlIIIlIIII;
        }
        
        @Override
        protected void compute() {
            final K[] lllllllllllllllllIlIlIIIllllllIl = this.x;
            final int lllllllllllllllllIlIlIIIllllllII = this.to - this.from;
            if (lllllllllllllllllIlIlIIIllllllII < 8192) {
                ObjectArrays.quickSort(lllllllllllllllllIlIlIIIllllllIl, this.from, this.to);
                return;
            }
            int lllllllllllllllllIlIlIIIlllllIll = this.from + lllllllllllllllllIlIlIIIllllllII / 2;
            int lllllllllllllllllIlIlIIIlllllIlI = this.from;
            int lllllllllllllllllIlIlIIIlllllIIl = this.to - 1;
            int lllllllllllllllllIlIlIIIlllllIII = lllllllllllllllllIlIlIIIllllllII / 8;
            lllllllllllllllllIlIlIIIlllllIlI = med3(lllllllllllllllllIlIlIIIllllllIl, lllllllllllllllllIlIlIIIlllllIlI, lllllllllllllllllIlIlIIIlllllIlI + lllllllllllllllllIlIlIIIlllllIII, lllllllllllllllllIlIlIIIlllllIlI + 2 * lllllllllllllllllIlIlIIIlllllIII);
            lllllllllllllllllIlIlIIIlllllIll = med3(lllllllllllllllllIlIlIIIllllllIl, lllllllllllllllllIlIlIIIlllllIll - lllllllllllllllllIlIlIIIlllllIII, lllllllllllllllllIlIlIIIlllllIll, lllllllllllllllllIlIlIIIlllllIll + lllllllllllllllllIlIlIIIlllllIII);
            lllllllllllllllllIlIlIIIlllllIIl = med3(lllllllllllllllllIlIlIIIllllllIl, lllllllllllllllllIlIlIIIlllllIIl - 2 * lllllllllllllllllIlIlIIIlllllIII, lllllllllllllllllIlIlIIIlllllIIl - lllllllllllllllllIlIlIIIlllllIII, lllllllllllllllllIlIlIIIlllllIIl);
            lllllllllllllllllIlIlIIIlllllIll = med3(lllllllllllllllllIlIlIIIllllllIl, lllllllllllllllllIlIlIIIlllllIlI, lllllllllllllllllIlIlIIIlllllIll, lllllllllllllllllIlIlIIIlllllIIl);
            final K lllllllllllllllllIlIlIIIllllIlll = lllllllllllllllllIlIlIIIllllllIl[lllllllllllllllllIlIlIIIlllllIll];
            int lllllllllllllllllIlIlIIIllllIlIl;
            int lllllllllllllllllIlIlIIIllllIllI = lllllllllllllllllIlIlIIIllllIlIl = this.from;
            int lllllllllllllllllIlIlIIIllllIIll;
            int lllllllllllllllllIlIlIIIllllIlII = lllllllllllllllllIlIlIIIllllIIll = this.to - 1;
            while (true) {
                final int lllllllllllllllllIlIlIIlIIIIIIII;
                if (lllllllllllllllllIlIlIIIllllIlIl <= lllllllllllllllllIlIlIIIllllIlII && (lllllllllllllllllIlIlIIlIIIIIIII = ((Comparable)lllllllllllllllllIlIlIIIllllllIl[lllllllllllllllllIlIlIIIllllIlIl]).compareTo(lllllllllllllllllIlIlIIIllllIlll)) <= 0) {
                    if (lllllllllllllllllIlIlIIlIIIIIIII == 0) {
                        ObjectArrays.swap(lllllllllllllllllIlIlIIIllllllIl, lllllllllllllllllIlIlIIIllllIllI++, lllllllllllllllllIlIlIIIllllIlIl);
                    }
                    ++lllllllllllllllllIlIlIIIllllIlIl;
                }
                else {
                    int lllllllllllllllllIlIlIIIllllllll;
                    while (lllllllllllllllllIlIlIIIllllIlII >= lllllllllllllllllIlIlIIIllllIlIl && (lllllllllllllllllIlIlIIIllllllll = ((Comparable)lllllllllllllllllIlIlIIIllllllIl[lllllllllllllllllIlIlIIIllllIlII]).compareTo(lllllllllllllllllIlIlIIIllllIlll)) >= 0) {
                        if (lllllllllllllllllIlIlIIIllllllll == 0) {
                            ObjectArrays.swap(lllllllllllllllllIlIlIIIllllllIl, lllllllllllllllllIlIlIIIllllIlII, lllllllllllllllllIlIlIIIllllIIll--);
                        }
                        --lllllllllllllllllIlIlIIIllllIlII;
                    }
                    if (lllllllllllllllllIlIlIIIllllIlIl > lllllllllllllllllIlIlIIIllllIlII) {
                        break;
                    }
                    ObjectArrays.swap(lllllllllllllllllIlIlIIIllllllIl, lllllllllllllllllIlIlIIIllllIlIl++, lllllllllllllllllIlIlIIIllllIlII--);
                }
            }
            lllllllllllllllllIlIlIIIlllllIII = Math.min(lllllllllllllllllIlIlIIIllllIllI - this.from, lllllllllllllllllIlIlIIIllllIlIl - lllllllllllllllllIlIlIIIllllIllI);
            ObjectArrays.swap(lllllllllllllllllIlIlIIIllllllIl, this.from, lllllllllllllllllIlIlIIIllllIlIl - lllllllllllllllllIlIlIIIlllllIII, lllllllllllllllllIlIlIIIlllllIII);
            lllllllllllllllllIlIlIIIlllllIII = Math.min(lllllllllllllllllIlIlIIIllllIIll - lllllllllllllllllIlIlIIIllllIlII, this.to - lllllllllllllllllIlIlIIIllllIIll - 1);
            ObjectArrays.swap(lllllllllllllllllIlIlIIIllllllIl, lllllllllllllllllIlIlIIIllllIlIl, this.to - lllllllllllllllllIlIlIIIlllllIII, lllllllllllllllllIlIlIIIlllllIII);
            lllllllllllllllllIlIlIIIlllllIII = lllllllllllllllllIlIlIIIllllIlIl - lllllllllllllllllIlIlIIIllllIllI;
            final int lllllllllllllllllIlIlIIIllllIIlI = lllllllllllllllllIlIlIIIllllIIll - lllllllllllllllllIlIlIIIllllIlII;
            if (lllllllllllllllllIlIlIIIlllllIII > 1 && lllllllllllllllllIlIlIIIllllIIlI > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort<Object>((Object[])lllllllllllllllllIlIlIIIllllllIl, this.from, this.from + lllllllllllllllllIlIlIIIlllllIII), new ForkJoinQuickSort<Object>((Object[])lllllllllllllllllIlIlIIIllllllIl, this.to - lllllllllllllllllIlIlIIIllllIIlI, this.to));
            }
            else if (lllllllllllllllllIlIlIIIlllllIII > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort(lllllllllllllllllIlIlIIIllllllIl, this.from, this.from + lllllllllllllllllIlIlIIIlllllIII));
            }
            else {
                ForkJoinTask.invokeAll(new ForkJoinQuickSort(lllllllllllllllllIlIlIIIllllllIl, this.to - lllllllllllllllllIlIlIIIllllIIlI, this.to));
            }
        }
    }
    
    protected static class ForkJoinQuickSortIndirect<K> extends RecursiveAction
    {
        private final /* synthetic */ int to;
        private final /* synthetic */ K[] x;
        private final /* synthetic */ int from;
        private final /* synthetic */ int[] perm;
        
        public ForkJoinQuickSortIndirect(final int[] llllllllllllllIIllIIIIIIIllIIIII, final K[] llllllllllllllIIllIIIIIIIlIllIlI, final int llllllllllllllIIllIIIIIIIlIllIIl, final int llllllllllllllIIllIIIIIIIlIllIII) {
            this.from = llllllllllllllIIllIIIIIIIlIllIIl;
            this.to = llllllllllllllIIllIIIIIIIlIllIII;
            this.x = llllllllllllllIIllIIIIIIIlIllIlI;
            this.perm = llllllllllllllIIllIIIIIIIllIIIII;
        }
        
        @Override
        protected void compute() {
            final K[] llllllllllllllIIllIIIIIIIlIIIlll = this.x;
            final int llllllllllllllIIllIIIIIIIlIIIllI = this.to - this.from;
            if (llllllllllllllIIllIIIIIIIlIIIllI < 8192) {
                ObjectArrays.quickSortIndirect(this.perm, llllllllllllllIIllIIIIIIIlIIIlll, this.from, this.to);
                return;
            }
            int llllllllllllllIIllIIIIIIIlIIIlIl = this.from + llllllllllllllIIllIIIIIIIlIIIllI / 2;
            int llllllllllllllIIllIIIIIIIlIIIlII = this.from;
            int llllllllllllllIIllIIIIIIIlIIIIll = this.to - 1;
            int llllllllllllllIIllIIIIIIIlIIIIlI = llllllllllllllIIllIIIIIIIlIIIllI / 8;
            llllllllllllllIIllIIIIIIIlIIIlII = med3Indirect(this.perm, llllllllllllllIIllIIIIIIIlIIIlll, llllllllllllllIIllIIIIIIIlIIIlII, llllllllllllllIIllIIIIIIIlIIIlII + llllllllllllllIIllIIIIIIIlIIIIlI, llllllllllllllIIllIIIIIIIlIIIlII + 2 * llllllllllllllIIllIIIIIIIlIIIIlI);
            llllllllllllllIIllIIIIIIIlIIIlIl = med3Indirect(this.perm, llllllllllllllIIllIIIIIIIlIIIlll, llllllllllllllIIllIIIIIIIlIIIlIl - llllllllllllllIIllIIIIIIIlIIIIlI, llllllllllllllIIllIIIIIIIlIIIlIl, llllllllllllllIIllIIIIIIIlIIIlIl + llllllllllllllIIllIIIIIIIlIIIIlI);
            llllllllllllllIIllIIIIIIIlIIIIll = med3Indirect(this.perm, llllllllllllllIIllIIIIIIIlIIIlll, llllllllllllllIIllIIIIIIIlIIIIll - 2 * llllllllllllllIIllIIIIIIIlIIIIlI, llllllllllllllIIllIIIIIIIlIIIIll - llllllllllllllIIllIIIIIIIlIIIIlI, llllllllllllllIIllIIIIIIIlIIIIll);
            llllllllllllllIIllIIIIIIIlIIIlIl = med3Indirect(this.perm, llllllllllllllIIllIIIIIIIlIIIlll, llllllllllllllIIllIIIIIIIlIIIlII, llllllllllllllIIllIIIIIIIlIIIlIl, llllllllllllllIIllIIIIIIIlIIIIll);
            final K llllllllllllllIIllIIIIIIIlIIIIIl = llllllllllllllIIllIIIIIIIlIIIlll[this.perm[llllllllllllllIIllIIIIIIIlIIIlIl]];
            int llllllllllllllIIllIIIIIIIIllllll;
            int llllllllllllllIIllIIIIIIIlIIIIII = llllllllllllllIIllIIIIIIIIllllll = this.from;
            int llllllllllllllIIllIIIIIIIIllllIl;
            int llllllllllllllIIllIIIIIIIIlllllI = llllllllllllllIIllIIIIIIIIllllIl = this.to - 1;
            while (true) {
                final int llllllllllllllIIllIIIIIIIlIIlIlI;
                if (llllllllllllllIIllIIIIIIIIllllll <= llllllllllllllIIllIIIIIIIIlllllI && (llllllllllllllIIllIIIIIIIlIIlIlI = ((Comparable)llllllllllllllIIllIIIIIIIlIIIlll[this.perm[llllllllllllllIIllIIIIIIIIllllll]]).compareTo(llllllllllllllIIllIIIIIIIlIIIIIl)) <= 0) {
                    if (llllllllllllllIIllIIIIIIIlIIlIlI == 0) {
                        IntArrays.swap(this.perm, llllllllllllllIIllIIIIIIIlIIIIII++, llllllllllllllIIllIIIIIIIIllllll);
                    }
                    ++llllllllllllllIIllIIIIIIIIllllll;
                }
                else {
                    int llllllllllllllIIllIIIIIIIlIIlIIl;
                    while (llllllllllllllIIllIIIIIIIIlllllI >= llllllllllllllIIllIIIIIIIIllllll && (llllllllllllllIIllIIIIIIIlIIlIIl = ((Comparable)llllllllllllllIIllIIIIIIIlIIIlll[this.perm[llllllllllllllIIllIIIIIIIIlllllI]]).compareTo(llllllllllllllIIllIIIIIIIlIIIIIl)) >= 0) {
                        if (llllllllllllllIIllIIIIIIIlIIlIIl == 0) {
                            IntArrays.swap(this.perm, llllllllllllllIIllIIIIIIIIlllllI, llllllllllllllIIllIIIIIIIIllllIl--);
                        }
                        --llllllllllllllIIllIIIIIIIIlllllI;
                    }
                    if (llllllllllllllIIllIIIIIIIIllllll > llllllllllllllIIllIIIIIIIIlllllI) {
                        break;
                    }
                    IntArrays.swap(this.perm, llllllllllllllIIllIIIIIIIIllllll++, llllllllllllllIIllIIIIIIIIlllllI--);
                }
            }
            llllllllllllllIIllIIIIIIIlIIIIlI = Math.min(llllllllllllllIIllIIIIIIIlIIIIII - this.from, llllllllllllllIIllIIIIIIIIllllll - llllllllllllllIIllIIIIIIIlIIIIII);
            IntArrays.swap(this.perm, this.from, llllllllllllllIIllIIIIIIIIllllll - llllllllllllllIIllIIIIIIIlIIIIlI, llllllllllllllIIllIIIIIIIlIIIIlI);
            llllllllllllllIIllIIIIIIIlIIIIlI = Math.min(llllllllllllllIIllIIIIIIIIllllIl - llllllllllllllIIllIIIIIIIIlllllI, this.to - llllllllllllllIIllIIIIIIIIllllIl - 1);
            IntArrays.swap(this.perm, llllllllllllllIIllIIIIIIIIllllll, this.to - llllllllllllllIIllIIIIIIIlIIIIlI, llllllllllllllIIllIIIIIIIlIIIIlI);
            llllllllllllllIIllIIIIIIIlIIIIlI = llllllllllllllIIllIIIIIIIIllllll - llllllllllllllIIllIIIIIIIlIIIIII;
            final int llllllllllllllIIllIIIIIIIIllllII = llllllllllllllIIllIIIIIIIIllllIl - llllllllllllllIIllIIIIIIIIlllllI;
            if (llllllllllllllIIllIIIIIIIlIIIIlI > 1 && llllllllllllllIIllIIIIIIIIllllII > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortIndirect<Object>(this.perm, (Object[])llllllllllllllIIllIIIIIIIlIIIlll, this.from, this.from + llllllllllllllIIllIIIIIIIlIIIIlI), new ForkJoinQuickSortIndirect<Object>(this.perm, (Object[])llllllllllllllIIllIIIIIIIlIIIlll, this.to - llllllllllllllIIllIIIIIIIIllllII, this.to));
            }
            else if (llllllllllllllIIllIIIIIIIlIIIIlI > 1) {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortIndirect(this.perm, llllllllllllllIIllIIIIIIIlIIIlll, this.from, this.from + llllllllllllllIIllIIIIIIIlIIIIlI));
            }
            else {
                ForkJoinTask.invokeAll(new ForkJoinQuickSortIndirect(this.perm, llllllllllllllIIllIIIIIIIlIIIlll, this.to - llllllllllllllIIllIIIIIIIIllllII, this.to));
            }
        }
    }
}
