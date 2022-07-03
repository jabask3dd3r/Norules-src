package optifine;

public class IntegerCache
{
    private static final /* synthetic */ Integer[] cache;
    
    static {
        CACHE_SIZE = 4096;
        cache = makeCache(4096);
    }
    
    public static Integer valueOf(final int lllllllllllllIlIIlllIIIlIlllIIIl) {
        return (lllllllllllllIlIIlllIIIlIlllIIIl >= 0 && lllllllllllllIlIIlllIIIlIlllIIIl < 4096) ? IntegerCache.cache[lllllllllllllIlIIlllIIIlIlllIIIl] : new Integer(lllllllllllllIlIIlllIIIlIlllIIIl);
    }
    
    private static Integer[] makeCache(final int lllllllllllllIlIIlllIIIlIlllIlIl) {
        final Integer[] lllllllllllllIlIIlllIIIlIlllIlll = new Integer[lllllllllllllIlIIlllIIIlIlllIlIl];
        for (int lllllllllllllIlIIlllIIIlIlllIllI = 0; lllllllllllllIlIIlllIIIlIlllIllI < lllllllllllllIlIIlllIIIlIlllIlIl; ++lllllllllllllIlIIlllIIIlIlllIllI) {
            lllllllllllllIlIIlllIIIlIlllIlll[lllllllllllllIlIIlllIIIlIlllIllI] = new Integer(lllllllllllllIlIIlllIIIlIlllIllI);
        }
        return lllllllllllllIlIIlllIIIlIlllIlll;
    }
}
