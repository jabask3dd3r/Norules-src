package net.minecraft.util;

public class IntegerCache
{
    private static final /* synthetic */ Integer[] CACHE;
    
    static {
        CACHE = new Integer[65535];
        for (int lllllllllllllIlIIllllllIllIlIIII = 0, lllllllllllllIlIIllllllIllIIllll = IntegerCache.CACHE.length; lllllllllllllIlIIllllllIllIlIIII < lllllllllllllIlIIllllllIllIIllll; ++lllllllllllllIlIIllllllIllIlIIII) {
            IntegerCache.CACHE[lllllllllllllIlIIllllllIllIlIIII] = lllllllllllllIlIIllllllIllIlIIII;
        }
    }
    
    public static Integer getInteger(final int lllllllllllllIlIIllllllIllIIIlll) {
        return (lllllllllllllIlIIllllllIllIIIlll > 0 && lllllllllllllIlIIllllllIllIIIlll < IntegerCache.CACHE.length) ? IntegerCache.CACHE[lllllllllllllIlIIllllllIllIIIlll] : lllllllllllllIlIIllllllIllIIIlll;
    }
}
