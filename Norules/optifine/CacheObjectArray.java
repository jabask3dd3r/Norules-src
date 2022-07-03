package optifine;

import java.util.*;
import java.lang.reflect.*;
import net.minecraft.block.state.*;

public class CacheObjectArray
{
    private static /* synthetic */ int maxCacheSize;
    private static /* synthetic */ ArrayDeque<int[]> arrays;
    
    private static long testNewObjDyn(final Class lllllllllllllIIlIlIIlIIlllllllll, final int lllllllllllllIIlIlIIlIIllllllIII, final int lllllllllllllIIlIlIIlIIlllllIlll) {
        final long lllllllllllllIIlIlIIlIIlllllllII = System.currentTimeMillis();
        for (int lllllllllllllIIlIlIIlIIllllllIll = 0; lllllllllllllIIlIlIIlIIllllllIll < lllllllllllllIIlIlIIlIIlllllIlll; ++lllllllllllllIIlIlIIlIIllllllIll) {
            final String lllllllllllllIIlIlIIlIIlllllIlII = (String)Array.newInstance(lllllllllllllIIlIlIIlIIlllllllll, lllllllllllllIIlIlIIlIIllllllIII);
        }
        final long lllllllllllllIIlIlIIlIIllllllIlI = System.currentTimeMillis();
        return lllllllllllllIIlIlIIlIIllllllIlI - lllllllllllllIIlIlIIlIIlllllllII;
    }
    
    private static long testNewObj(final int lllllllllllllIIlIlIIlIlIIIIIllll, final int lllllllllllllIIlIlIIlIlIIIIIlllI) {
        final long lllllllllllllIIlIlIIlIlIIIIIllIl = System.currentTimeMillis();
        for (int lllllllllllllIIlIlIIlIlIIIIIllII = 0; lllllllllllllIIlIlIIlIlIIIIIllII < lllllllllllllIIlIlIIlIlIIIIIlllI; ++lllllllllllllIIlIlIIlIlIIIIIllII) {
            final Exception lllllllllllllIIlIlIIlIlIIIIIIllI = (Object)new IBlockState[lllllllllllllIIlIlIIlIlIIIIIllll];
        }
        final long lllllllllllllIIlIlIIlIlIIIIIlIll = System.currentTimeMillis();
        return lllllllllllllIIlIlIIlIlIIIIIlIll - lllllllllllllIIlIlIIlIlIIIIIllIl;
    }
    
    static {
        CacheObjectArray.arrays = new ArrayDeque<int[]>();
        CacheObjectArray.maxCacheSize = 10;
    }
    
    public static synchronized void freeArray(final int[] lllllllllllllIIlIlIIlIlIIlIlllll) {
        if (CacheObjectArray.arrays.size() < CacheObjectArray.maxCacheSize) {
            CacheObjectArray.arrays.add(lllllllllllllIIlIlIIlIlIIlIlllll);
        }
    }
    
    private static long testCloneObj(final int lllllllllllllIIlIlIIlIlIIIlIIIII, final int lllllllllllllIIlIlIIlIlIIIIlllll) {
        final long lllllllllllllIIlIlIIlIlIIIIllllI = System.currentTimeMillis();
        final IBlockState[] lllllllllllllIIlIlIIlIlIIIIlllIl = new IBlockState[lllllllllllllIIlIlIIlIlIIIlIIIII];
        for (int lllllllllllllIIlIlIIlIlIIIIlllII = 0; lllllllllllllIIlIlIIlIlIIIIlllII < lllllllllllllIIlIlIIlIlIIIIlllll; ++lllllllllllllIIlIlIIlIlIIIIlllII) {
            final char lllllllllllllIIlIlIIlIlIIIIlIlIl = (Object)lllllllllllllIIlIlIIlIlIIIIlllIl.clone();
        }
        final long lllllllllllllIIlIlIIlIlIIIIllIll = System.currentTimeMillis();
        return lllllllllllllIIlIlIIlIlIIIIllIll - lllllllllllllIIlIlIIlIlIIIIllllI;
    }
    
    private static synchronized int[] allocateArray(final int lllllllllllllIIlIlIIlIlIIllIIlII) {
        int[] lllllllllllllIIlIlIIlIlIIllIIIll = CacheObjectArray.arrays.pollLast();
        if (lllllllllllllIIlIlIIlIlIIllIIIll == null || lllllllllllllIIlIlIIlIlIIllIIIll.length < lllllllllllllIIlIlIIlIlIIllIIlII) {
            lllllllllllllIIlIlIIlIlIIllIIIll = new int[lllllllllllllIIlIlIIlIlIIllIIlII];
        }
        return lllllllllllllIIlIlIIlIlIIllIIIll;
    }
    
    private static long testNew(final int lllllllllllllIIlIlIIlIlIIIllIIII, final int lllllllllllllIIlIlIIlIlIIIlIllll) {
        final long lllllllllllllIIlIlIIlIlIIIlIlllI = System.currentTimeMillis();
        for (int lllllllllllllIIlIlIIlIlIIIlIllIl = 0; lllllllllllllIIlIlIIlIlIIIlIllIl < lllllllllllllIIlIlIIlIlIIIlIllll; ++lllllllllllllIIlIlIIlIlIIIlIllIl) {
            final String lllllllllllllIIlIlIIlIlIIIlIIlll = (Object)Array.newInstance(Integer.TYPE, lllllllllllllIIlIlIIlIlIIIllIIII);
        }
        final long lllllllllllllIIlIlIIlIlIIIlIllII = System.currentTimeMillis();
        return lllllllllllllIIlIlIIlIlIIIlIllII - lllllllllllllIIlIlIIlIlIIIlIlllI;
    }
    
    public static void main(final String[] lllllllllllllIIlIlIIlIlIIlIlIllI) throws Exception {
        final int lllllllllllllIIlIlIIlIlIIlIlIlIl = 4096;
        final int lllllllllllllIIlIlIIlIlIIlIlIlII = 500000;
        testNew(lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        testClone(lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        testNewObj(lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        testCloneObj(lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        testNewObjDyn(IBlockState.class, lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        final long lllllllllllllIIlIlIIlIlIIlIlIIll = testNew(lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        final long lllllllllllllIIlIlIIlIlIIlIlIIlI = testClone(lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        final long lllllllllllllIIlIlIIlIlIIlIlIIIl = testNewObj(lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        final long lllllllllllllIIlIlIIlIlIIlIlIIII = testCloneObj(lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        final long lllllllllllllIIlIlIIlIlIIlIIllll = testNewObjDyn(IBlockState.class, lllllllllllllIIlIlIIlIlIIlIlIlIl, lllllllllllllIIlIlIIlIlIIlIlIlII);
        Config.dbg(String.valueOf(new StringBuilder("New: ").append(lllllllllllllIIlIlIIlIlIIlIlIIll)));
        Config.dbg(String.valueOf(new StringBuilder("Clone: ").append(lllllllllllllIIlIlIIlIlIIlIlIIlI)));
        Config.dbg(String.valueOf(new StringBuilder("NewObj: ").append(lllllllllllllIIlIlIIlIlIIlIlIIIl)));
        Config.dbg(String.valueOf(new StringBuilder("CloneObj: ").append(lllllllllllllIIlIlIIlIlIIlIlIIII)));
        Config.dbg(String.valueOf(new StringBuilder("NewObjDyn: ").append(lllllllllllllIIlIlIIlIlIIlIIllll)));
    }
    
    private static long testClone(final int lllllllllllllIIlIlIIlIlIIIlllIll, final int lllllllllllllIIlIlIIlIlIIIlllIlI) {
        final long lllllllllllllIIlIlIIlIlIIIllllll = System.currentTimeMillis();
        final int[] lllllllllllllIIlIlIIlIlIIIlllllI = new int[lllllllllllllIIlIlIIlIlIIIlllIll];
        for (int lllllllllllllIIlIlIIlIlIIIllllIl = 0; lllllllllllllIIlIlIIlIlIIIllllIl < lllllllllllllIIlIlIIlIlIIIlllIlI; ++lllllllllllllIIlIlIIlIlIIIllllIl) {
            final byte lllllllllllllIIlIlIIlIlIIIllIllI = (Object)lllllllllllllIIlIlIIlIlIIIlllllI.clone();
        }
        final long lllllllllllllIIlIlIIlIlIIIllllII = System.currentTimeMillis();
        return lllllllllllllIIlIlIIlIlIIIllllII - lllllllllllllIIlIlIIlIlIIIllllll;
    }
}
