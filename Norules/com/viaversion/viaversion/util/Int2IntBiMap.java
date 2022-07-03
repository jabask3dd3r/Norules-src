package com.viaversion.viaversion.util;

import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;

public interface Int2IntBiMap extends Int2IntMap
{
    Int2IntBiMap inverse();
    
    @Deprecated
    default void putAll(final Map<? extends Integer, ? extends Integer> llllllllllllllIlIlIIIIlIIIIIlIlI) {
        throw new UnsupportedOperationException();
    }
    
    int put(final int p0, final int p1);
}
