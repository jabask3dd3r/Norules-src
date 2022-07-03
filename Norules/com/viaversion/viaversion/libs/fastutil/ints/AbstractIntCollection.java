package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;

public abstract class AbstractIntCollection extends AbstractCollection<Integer> implements IntCollection
{
    @Override
    public boolean containsAll(final IntCollection lllllllllllllIIIllIIlIlIIIIlIIIl) {
        final IntIterator lllllllllllllIIIllIIlIlIIIIlIlIl = lllllllllllllIIIllIIlIlIIIIlIIIl.iterator();
        while (lllllllllllllIIIllIIlIlIIIIlIlIl.hasNext()) {
            if (!this.contains(lllllllllllllIIIllIIlIlIIIIlIlIl.nextInt())) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int[] toIntArray() {
        return this.toArray((int[])null);
    }
    
    @Override
    public boolean removeAll(final IntCollection lllllllllllllIIIllIIlIlIIIIIlIIl) {
        boolean lllllllllllllIIIllIIlIlIIIIIlIII = false;
        final IntIterator lllllllllllllIIIllIIlIlIIIIIlIll = lllllllllllllIIIllIIlIlIIIIIlIIl.iterator();
        while (lllllllllllllIIIllIIlIlIIIIIlIll.hasNext()) {
            if (this.rem(lllllllllllllIIIllIIlIlIIIIIlIll.nextInt())) {
                lllllllllllllIIIllIIlIlIIIIIlIII = true;
            }
        }
        return lllllllllllllIIIllIIlIlIIIIIlIII;
    }
    
    @Override
    public int[] toArray(int[] lllllllllllllIIIllIIlIlIIIlIlllI) {
        if (lllllllllllllIIIllIIlIlIIIlIlllI == null || lllllllllllllIIIllIIlIlIIIlIlllI.length < this.size()) {
            lllllllllllllIIIllIIlIlIIIlIlllI = new int[this.size()];
        }
        IntIterators.unwrap(this.iterator(), lllllllllllllIIIllIIlIlIIIlIlllI);
        return lllllllllllllIIIllIIlIlIIIlIlllI;
    }
    
    @Deprecated
    @Override
    public boolean contains(final Object lllllllllllllIIIllIIlIlIIIllllII) {
        return super.contains(lllllllllllllIIIllIIlIlIIIllllII);
    }
    
    @Override
    public boolean rem(final int lllllllllllllIIIllIIlIlIIlIIIlll) {
        final IntIterator lllllllllllllIIIllIIlIlIIlIIlIIl = this.iterator();
        while (lllllllllllllIIIllIIlIlIIlIIlIIl.hasNext()) {
            if (lllllllllllllIIIllIIlIlIIlIIIlll == lllllllllllllIIIllIIlIlIIlIIlIIl.nextInt()) {
                lllllllllllllIIIllIIlIlIIlIIlIIl.remove();
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIIIllIIlIIllllIllll = new StringBuilder();
        final IntIterator lllllllllllllIIIllIIlIIllllIlllI = this.iterator();
        int lllllllllllllIIIllIIlIIllllIllIl = this.size();
        boolean lllllllllllllIIIllIIlIIllllIllII = true;
        lllllllllllllIIIllIIlIIllllIllll.append("{");
        while (lllllllllllllIIIllIIlIIllllIllIl-- != 0) {
            if (lllllllllllllIIIllIIlIIllllIllII) {
                lllllllllllllIIIllIIlIIllllIllII = false;
            }
            else {
                lllllllllllllIIIllIIlIIllllIllll.append(", ");
            }
            final int lllllllllllllIIIllIIlIIlllllIIIl = lllllllllllllIIIllIIlIIllllIlllI.nextInt();
            lllllllllllllIIIllIIlIIllllIllll.append(String.valueOf(lllllllllllllIIIllIIlIIlllllIIIl));
        }
        lllllllllllllIIIllIIlIIllllIllll.append("}");
        return String.valueOf(lllllllllllllIIIllIIlIIllllIllll);
    }
    
    @Override
    public boolean retainAll(final IntCollection lllllllllllllIIIllIIlIIlllllllIl) {
        boolean lllllllllllllIIIllIIlIIlllllllII = false;
        final IntIterator lllllllllllllIIIllIIlIIlllllllll = this.iterator();
        while (lllllllllllllIIIllIIlIIlllllllll.hasNext()) {
            if (!lllllllllllllIIIllIIlIIlllllllIl.contains(lllllllllllllIIIllIIlIIlllllllll.nextInt())) {
                lllllllllllllIIIllIIlIIlllllllll.remove();
                lllllllllllllIIIllIIlIIlllllllII = true;
            }
        }
        return lllllllllllllIIIllIIlIIlllllllII;
    }
    
    @Override
    public boolean contains(final int lllllllllllllIIIllIIlIlIIlIlIIll) {
        final IntIterator lllllllllllllIIIllIIlIlIIlIlIIlI = this.iterator();
        while (lllllllllllllIIIllIIlIlIIlIlIIlI.hasNext()) {
            if (lllllllllllllIIIllIIlIlIIlIlIIll == lllllllllllllIIIllIIlIlIIlIlIIlI.nextInt()) {
                return true;
            }
        }
        return false;
    }
    
    @Deprecated
    @Override
    public boolean remove(final Object lllllllllllllIIIllIIlIlIIIllIlII) {
        return super.remove(lllllllllllllIIIllIIlIlIIIllIlII);
    }
    
    @Deprecated
    @Override
    public boolean add(final Integer lllllllllllllIIIllIIlIlIIlIIIIlI) {
        return super.add(lllllllllllllIIIllIIlIlIIlIIIIlI);
    }
    
    @Override
    public abstract IntIterator iterator();
    
    @Override
    public boolean add(final int lllllllllllllIIIllIIlIlIIlIllIII) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public int[] toIntArray(final int[] lllllllllllllIIIllIIlIlIIIlIIlIl) {
        return this.toArray(lllllllllllllIIIllIIlIlIIIlIIlIl);
    }
    
    @Override
    public boolean addAll(final IntCollection lllllllllllllIIIllIIlIlIIIIllllI) {
        boolean lllllllllllllIIIllIIlIlIIIIlllIl = false;
        final IntIterator lllllllllllllIIIllIIlIlIIIlIIIII = lllllllllllllIIIllIIlIlIIIIllllI.iterator();
        while (lllllllllllllIIIllIIlIlIIIlIIIII.hasNext()) {
            if (this.add(lllllllllllllIIIllIIlIlIIIlIIIII.nextInt())) {
                lllllllllllllIIIllIIlIlIIIIlllIl = true;
            }
        }
        return lllllllllllllIIIllIIlIlIIIIlllIl;
    }
    
    protected AbstractIntCollection() {
    }
}
