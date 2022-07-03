package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;

public interface IntSet extends IntCollection, Set<Integer>
{
    boolean remove(final int p0);
    
    IntIterator iterator();
    
    @Deprecated
    default boolean add(final Integer lllllllllllllIllIllllIllIIlIIIIl) {
        return super.add(lllllllllllllIllIllllIllIIlIIIIl);
    }
    
    @Deprecated
    default boolean remove(final Object lllllllllllllIllIllllIllIIlIIlll) {
        return super.remove(lllllllllllllIllIllllIllIIlIIlll);
    }
    
    @Deprecated
    default boolean contains(final Object lllllllllllllIllIllllIllIIIllIll) {
        return super.contains(lllllllllllllIllIllllIllIIIllIll);
    }
    
    @Deprecated
    default boolean rem(final int lllllllllllllIllIllllIllIIIlIlll) {
        return this.remove(lllllllllllllIllIllllIllIIIlIlll);
    }
}
