package optifine;

import java.util.*;
import java.lang.reflect.*;

public class ArrayCache
{
    private /* synthetic */ int maxCacheSize;
    private /* synthetic */ Class elementClass;
    private /* synthetic */ ArrayDeque cache;
    
    public synchronized void free(final Object lllllllllllllIlIlIIlIIlIllIlIllI) {
        if (lllllllllllllIlIlIIlIIlIllIlIllI != null) {
            final Class lllllllllllllIlIlIIlIIlIllIllIII = lllllllllllllIlIlIIlIIlIllIlIllI.getClass();
            if (lllllllllllllIlIlIIlIIlIllIllIII.getComponentType() != this.elementClass) {
                throw new IllegalArgumentException("Wrong component type");
            }
            if (this.cache.size() < this.maxCacheSize) {
                this.cache.add(lllllllllllllIlIlIIlIIlIllIlIllI);
            }
        }
    }
    
    public synchronized Object allocate(final int lllllllllllllIlIlIIlIIlIlllIIIlI) {
        Object lllllllllllllIlIlIIlIIlIlllIIIIl = this.cache.pollLast();
        if (lllllllllllllIlIlIIlIIlIlllIIIIl == null || Array.getLength(lllllllllllllIlIlIIlIIlIlllIIIIl) < lllllllllllllIlIlIIlIIlIlllIIIlI) {
            lllllllllllllIlIlIIlIIlIlllIIIIl = Array.newInstance(this.elementClass, lllllllllllllIlIlIIlIIlIlllIIIlI);
        }
        return lllllllllllllIlIlIIlIIlIlllIIIIl;
    }
    
    public ArrayCache(final Class lllllllllllllIlIlIIlIIlIlllIlIll, final int lllllllllllllIlIlIIlIIlIlllIlIlI) {
        this.elementClass = null;
        this.maxCacheSize = 0;
        this.cache = new ArrayDeque();
        this.elementClass = lllllllllllllIlIlIIlIIlIlllIlIll;
        this.maxCacheSize = lllllllllllllIlIlIIlIIlIlllIlIlI;
    }
}
