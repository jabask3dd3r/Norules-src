package net.minecraft.util;

import java.util.*;
import com.google.common.collect.*;

public class MapPopulator
{
    public static <K, V> Map<K, V> populateMap(final Iterable<K> llllllllllllllIIllIllllIIIIlIIIl, final Iterable<V> llllllllllllllIIllIllllIIIIlIIII, final Map<K, V> llllllllllllllIIllIllllIIIIIllll) {
        final Iterator<V> llllllllllllllIIllIllllIIIIIlllI = llllllllllllllIIllIllllIIIIlIIII.iterator();
        for (final K llllllllllllllIIllIllllIIIIIllIl : llllllllllllllIIllIllllIIIIlIIIl) {
            llllllllllllllIIllIllllIIIIIllll.put(llllllllllllllIIllIllllIIIIIllIl, llllllllllllllIIllIllllIIIIIlllI.next());
        }
        if (llllllllllllllIIllIllllIIIIIlllI.hasNext()) {
            throw new NoSuchElementException();
        }
        return llllllllllllllIIllIllllIIIIIllll;
    }
    
    public static <K, V> Map<K, V> createMap(final Iterable<K> llllllllllllllIIllIllllIIIIllIIl, final Iterable<V> llllllllllllllIIllIllllIIIIllIlI) {
        return populateMap(llllllllllllllIIllIllllIIIIllIIl, llllllllllllllIIllIllllIIIIllIlI, Maps.newLinkedHashMap());
    }
}
