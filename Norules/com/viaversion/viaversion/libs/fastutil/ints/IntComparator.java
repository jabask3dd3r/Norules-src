package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.lang.invoke.*;
import java.io.*;

@FunctionalInterface
public interface IntComparator extends Comparator<Integer>
{
    int compare(final int p0, final int p1);
    
    @Deprecated
    default int compare(final Integer lllllllllllllIIIIlIllIllIIIIIIlI, final Integer lllllllllllllIIIIlIllIllIIIIIlII) {
        return this.compare((int)lllllllllllllIIIIlIllIllIIIIIIlI, (int)lllllllllllllIIIIlIllIllIIIIIlII);
    }
    
    default Comparator<Integer> thenComparing(final Comparator<? super Integer> lllllllllllllIIIIlIllIlIllllIlIl) {
        if (lllllllllllllIIIIlIllIlIllllIlIl instanceof IntComparator) {
            return this.thenComparing((IntComparator)lllllllllllllIIIIlIllIlIllllIlIl);
        }
        return super.thenComparing(lllllllllllllIIIIlIllIlIllllIlIl);
    }
    
    default IntComparator reversed() {
        return IntComparators.oppositeComparator(this);
    }
    
    default IntComparator thenComparing(final IntComparator lllllllllllllIIIIlIllIlIlllllIll) {
        final int lllllllllllllIIIIlIllIlIllIllIlI;
        return (lllllllllllllIIIIlIllIlIllIlllII, lllllllllllllIIIIlIllIlIllIlIllI) -> {
            lllllllllllllIIIIlIllIlIllIllIlI = this.compare(lllllllllllllIIIIlIllIlIllIlllII, lllllllllllllIIIIlIllIlIllIlIllI);
            return (lllllllllllllIIIIlIllIlIllIllIlI == 0) ? lllllllllllllIIIIlIllIlIlllllIll.compare(lllllllllllllIIIIlIllIlIllIlllII, lllllllllllllIIIIlIllIlIllIlIllI) : lllllllllllllIIIIlIllIlIllIllIlI;
        };
    }
}
