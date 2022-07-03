package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.function.*;
import java.util.*;

public interface IntCollection extends Collection<Integer>, IntIterable
{
    boolean add(final int p0);
    
    boolean addAll(final IntCollection p0);
    
    @Deprecated
    default boolean remove(final Object llllllllllllllIlIIIIIlIlIIlllIIl) {
        return llllllllllllllIlIIIIIlIlIIlllIIl != null && this.rem((int)llllllllllllllIlIIIIIlIlIIlllIIl);
    }
    
    boolean containsAll(final IntCollection p0);
    
    int[] toArray(final int[] p0);
    
    int[] toIntArray();
    
    boolean retainAll(final IntCollection p0);
    
    boolean contains(final int p0);
    
    @Deprecated
    default boolean contains(final Object llllllllllllllIlIIIIIlIlIIllllIl) {
        return llllllllllllllIlIIIIIlIlIIllllIl != null && this.contains((int)llllllllllllllIlIIIIIlIlIIllllIl);
    }
    
    @Deprecated
    int[] toIntArray(final int[] p0);
    
    @Deprecated
    default boolean add(final Integer llllllllllllllIlIIIIIlIlIlIIIIll) {
        return this.add((int)llllllllllllllIlIIIIIlIlIlIIIIll);
    }
    
    @Deprecated
    default boolean removeIf(final Predicate<? super Integer> llllllllllllllIlIIIIIlIlIIllIIIl) {
        return this.removeIf(llllllllllllllIlIIIIIlIlIIIlIlll -> llllllllllllllIlIIIIIlIlIIllIIIl.test(llllllllllllllIlIIIIIlIlIIIlIlll));
    }
    
    default boolean removeIf(final IntPredicate llllllllllllllIlIIIIIlIlIIlIIlll) {
        Objects.requireNonNull(llllllllllllllIlIIIIIlIlIIlIIlll);
        boolean llllllllllllllIlIIIIIlIlIIlIlIlI = false;
        final IntIterator llllllllllllllIlIIIIIlIlIIlIlIIl = this.iterator();
        while (llllllllllllllIlIIIIIlIlIIlIlIIl.hasNext()) {
            if (llllllllllllllIlIIIIIlIlIIlIIlll.test(llllllllllllllIlIIIIIlIlIIlIlIIl.nextInt())) {
                llllllllllllllIlIIIIIlIlIIlIlIIl.remove();
                llllllllllllllIlIIIIIlIlIIlIlIlI = true;
            }
        }
        return llllllllllllllIlIIIIIlIlIIlIlIlI;
    }
    
    IntIterator iterator();
    
    boolean rem(final int p0);
    
    boolean removeAll(final IntCollection p0);
}
