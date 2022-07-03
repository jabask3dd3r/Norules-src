package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;

public abstract class AbstractIntSet extends AbstractIntCollection implements IntSet, Cloneable
{
    protected AbstractIntSet() {
    }
    
    @Deprecated
    @Override
    public boolean rem(final int lllllllllllllIIlIlIlIIlIlIlIIIIl) {
        return this.remove(lllllllllllllIIlIlIlIIlIlIlIIIIl);
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIlIlIlIIlIlIllIlII = 0;
        int lllllllllllllIIlIlIlIIlIlIllIIll = this.size();
        final IntIterator lllllllllllllIIlIlIlIIlIlIllIIlI = this.iterator();
        while (lllllllllllllIIlIlIlIIlIlIllIIll-- != 0) {
            final int lllllllllllllIIlIlIlIIlIlIllIllI = lllllllllllllIIlIlIlIIlIlIllIIlI.nextInt();
            lllllllllllllIIlIlIlIIlIlIllIlII += lllllllllllllIIlIlIlIIlIlIllIllI;
        }
        return lllllllllllllIIlIlIlIIlIlIllIlII;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIlIlIIlIlIllllIl) {
        if (lllllllllllllIIlIlIlIIlIlIllllIl == this) {
            return true;
        }
        if (!(lllllllllllllIIlIlIlIIlIlIllllIl instanceof Set)) {
            return false;
        }
        final Set<?> lllllllllllllIIlIlIlIIlIlIllllll = (Set<?>)lllllllllllllIIlIlIlIIlIlIllllIl;
        return lllllllllllllIIlIlIlIIlIlIllllll.size() == this.size() && this.containsAll(lllllllllllllIIlIlIlIIlIlIllllll);
    }
    
    @Override
    public boolean remove(final int lllllllllllllIIlIlIlIIlIlIlIlIIl) {
        return super.rem(lllllllllllllIIlIlIlIIlIlIlIlIIl);
    }
    
    @Override
    public abstract IntIterator iterator();
}
