package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;

public interface IntListIterator extends IntBidirectionalIterator, ListIterator<Integer>
{
    default void set(final int llllllllllllIlllllIllllIlIIlIlll) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    default void set(final Integer llllllllllllIlllllIllllIlIIIlllI) {
        this.set((int)llllllllllllIlllllIllllIlIIIlllI);
    }
    
    default void add(final int llllllllllllIlllllIllllIlIIlIlIl) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    default void add(final Integer llllllllllllIlllllIllllIlIIIlIlI) {
        this.add((int)llllllllllllIlllllIllllIlIIIlIlI);
    }
    
    @Deprecated
    default Integer next() {
        return super.next();
    }
    
    default void remove() {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    default Integer previous() {
        return super.previous();
    }
}
