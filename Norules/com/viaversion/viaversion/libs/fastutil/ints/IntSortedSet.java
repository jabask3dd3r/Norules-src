package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;

public interface IntSortedSet extends IntSet, SortedSet<Integer>, IntBidirectionalIterable
{
    @Deprecated
    default IntSortedSet headSet(final Integer llllllllllllllIIIIlIIIlIIIIlllll) {
        return this.headSet((int)llllllllllllllIIIIlIIIlIIIIlllll);
    }
    
    IntBidirectionalIterator iterator(final int p0);
    
    int lastInt();
    
    IntSortedSet subSet(final int p0, final int p1);
    
    @Deprecated
    default IntSortedSet subSet(final Integer llllllllllllllIIIIlIIIlIIIlIIlII, final Integer llllllllllllllIIIIlIIIlIIIlIIIll) {
        return this.subSet((int)llllllllllllllIIIIlIIIlIIIlIIlII, (int)llllllllllllllIIIIlIIIlIIIlIIIll);
    }
    
    IntSortedSet tailSet(final int p0);
    
    @Deprecated
    default IntSortedSet tailSet(final Integer llllllllllllllIIIIlIIIlIIIIlIlll) {
        return this.tailSet((int)llllllllllllllIIIIlIIIlIIIIlIlll);
    }
    
    IntBidirectionalIterator iterator();
    
    IntSortedSet headSet(final int p0);
    
    int firstInt();
    
    IntComparator comparator();
    
    @Deprecated
    default Integer first() {
        return this.firstInt();
    }
    
    @Deprecated
    default Integer last() {
        return this.lastInt();
    }
}
