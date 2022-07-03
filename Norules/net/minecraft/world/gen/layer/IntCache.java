package net.minecraft.world.gen.layer;

import com.google.common.collect.*;
import java.util.*;

public class IntCache
{
    private static /* synthetic */ int intCacheSize;
    private static final /* synthetic */ List<int[]> freeLargeArrays;
    private static final /* synthetic */ List<int[]> freeSmallArrays;
    private static final /* synthetic */ List<int[]> inUseSmallArrays;
    private static final /* synthetic */ List<int[]> inUseLargeArrays;
    
    public static synchronized int[] getIntCache(final int lllllllllllllIIIIIlIIllIllIllIIl) {
        if (lllllllllllllIIIIIlIIllIllIllIIl <= 256) {
            if (IntCache.freeSmallArrays.isEmpty()) {
                final int[] lllllllllllllIIIIIlIIllIllIllIII = new int[256];
                IntCache.inUseSmallArrays.add(lllllllllllllIIIIIlIIllIllIllIII);
                return lllllllllllllIIIIIlIIllIllIllIII;
            }
            final int[] lllllllllllllIIIIIlIIllIllIlIlll = IntCache.freeSmallArrays.remove(IntCache.freeSmallArrays.size() - 1);
            IntCache.inUseSmallArrays.add(lllllllllllllIIIIIlIIllIllIlIlll);
            return lllllllllllllIIIIIlIIllIllIlIlll;
        }
        else {
            if (lllllllllllllIIIIIlIIllIllIllIIl > IntCache.intCacheSize) {
                IntCache.intCacheSize = lllllllllllllIIIIIlIIllIllIllIIl;
                IntCache.freeLargeArrays.clear();
                IntCache.inUseLargeArrays.clear();
                final int[] lllllllllllllIIIIIlIIllIllIlIllI = new int[IntCache.intCacheSize];
                IntCache.inUseLargeArrays.add(lllllllllllllIIIIIlIIllIllIlIllI);
                return lllllllllllllIIIIIlIIllIllIlIllI;
            }
            if (IntCache.freeLargeArrays.isEmpty()) {
                final int[] lllllllllllllIIIIIlIIllIllIlIlIl = new int[IntCache.intCacheSize];
                IntCache.inUseLargeArrays.add(lllllllllllllIIIIIlIIllIllIlIlIl);
                return lllllllllllllIIIIIlIIllIllIlIlIl;
            }
            final int[] lllllllllllllIIIIIlIIllIllIlIlII = IntCache.freeLargeArrays.remove(IntCache.freeLargeArrays.size() - 1);
            IntCache.inUseLargeArrays.add(lllllllllllllIIIIIlIIllIllIlIlII);
            return lllllllllllllIIIIIlIIllIllIlIlII;
        }
    }
    
    public static synchronized String getCacheSizes() {
        return String.valueOf(new StringBuilder("cache: ").append(IntCache.freeLargeArrays.size()).append(", tcache: ").append(IntCache.freeSmallArrays.size()).append(", allocated: ").append(IntCache.inUseLargeArrays.size()).append(", tallocated: ").append(IntCache.inUseSmallArrays.size()));
    }
    
    static {
        IntCache.intCacheSize = 256;
        freeSmallArrays = Lists.newArrayList();
        inUseSmallArrays = Lists.newArrayList();
        freeLargeArrays = Lists.newArrayList();
        inUseLargeArrays = Lists.newArrayList();
    }
    
    public static synchronized void resetIntCache() {
        if (!IntCache.freeLargeArrays.isEmpty()) {
            IntCache.freeLargeArrays.remove(IntCache.freeLargeArrays.size() - 1);
        }
        if (!IntCache.freeSmallArrays.isEmpty()) {
            IntCache.freeSmallArrays.remove(IntCache.freeSmallArrays.size() - 1);
        }
        IntCache.freeLargeArrays.addAll(IntCache.inUseLargeArrays);
        IntCache.freeSmallArrays.addAll(IntCache.inUseSmallArrays);
        IntCache.inUseLargeArrays.clear();
        IntCache.inUseSmallArrays.clear();
    }
}
