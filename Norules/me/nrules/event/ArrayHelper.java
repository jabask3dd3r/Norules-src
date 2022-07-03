package me.nrules.event;

import java.util.*;

public class ArrayHelper<T> implements Iterable<T>
{
    private /* synthetic */ T[] elements;
    
    public void add(final T lllllllllllllIIllIIIlIlIlllllIIl) {
        if (lllllllllllllIIllIIIlIlIlllllIIl != null) {
            final Object[] lllllllllllllIIllIIIlIlIlllllIII = new Object[this.size() + 1];
            for (int lllllllllllllIIllIIIlIlIllllIlll = 0; lllllllllllllIIllIIIlIlIllllIlll < lllllllllllllIIllIIIlIlIlllllIII.length; ++lllllllllllllIIllIIIlIlIllllIlll) {
                if (lllllllllllllIIllIIIlIlIllllIlll < this.size()) {
                    lllllllllllllIIllIIIlIlIlllllIII[lllllllllllllIIllIIIlIlIllllIlll] = this.get(lllllllllllllIIllIIIlIlIllllIlll);
                }
                else {
                    lllllllllllllIIllIIIlIlIlllllIII[lllllllllllllIIllIIIlIlIllllIlll] = lllllllllllllIIllIIIlIlIlllllIIl;
                }
            }
            this.set(lllllllllllllIIllIIIlIlIlllllIII);
        }
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public T get(final int lllllllllllllIIllIIIlIlIllIIIIlI) {
        return this.array()[lllllllllllllIIllIIIlIlIllIIIIlI];
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private /* synthetic */ int index = 0;
            
            @Override
            public boolean hasNext() {
                return this.index < ArrayHelper.this.size() && ArrayHelper.this.get(this.index) != null;
            }
            
            @Override
            public T next() {
                return ArrayHelper.this.get(this.index++);
            }
            
            @Override
            public void remove() {
                ArrayHelper.this.remove(ArrayHelper.this.get(this.index));
            }
        };
    }
    
    public ArrayHelper(final T[] lllllllllllllIIllIIIlIllIIIIIIlI) {
        this.elements = lllllllllllllIIllIIIlIllIIIIIIlI;
    }
    
    public boolean contains(final T lllllllllllllIIllIIIlIlIlllIlIll) {
        Object[] lllllllllllllIIllIIIlIlIlllIlIlI;
        for (int lllllllllllllIIllIIIlIlIlllIlIIl = (lllllllllllllIIllIIIlIlIlllIlIlI = this.array()).length, lllllllllllllIIllIIIlIlIlllIlIII = 0; lllllllllllllIIllIIIlIlIlllIlIII < lllllllllllllIIllIIIlIlIlllIlIIl; ++lllllllllllllIIllIIIlIlIlllIlIII) {
            final T lllllllllllllIIllIIIlIlIlllIIlll = (T)lllllllllllllIIllIIIlIlIlllIlIlI[lllllllllllllIIllIIIlIlIlllIlIII];
            if (lllllllllllllIIllIIIlIlIlllIIlll.equals(lllllllllllllIIllIIIlIlIlllIlIll)) {
                return true;
            }
        }
        return false;
    }
    
    public void set(final T[] lllllllllllllIIllIIIlIlIllIIIllI) {
        this.elements = lllllllllllllIIllIIIlIlIllIIIllI;
    }
    
    public ArrayHelper() {
        this.elements = (T[])new Object[0];
    }
    
    public void clear() {
        this.elements = (T[])new Object[0];
    }
    
    public void remove(final T lllllllllllllIIllIIIlIlIllIllIlI) {
        if (this.contains(lllllllllllllIIllIIIlIlIllIllIlI)) {
            final Object[] lllllllllllllIIllIIIlIlIllIllIIl = new Object[this.size() - 1];
            boolean lllllllllllllIIllIIIlIlIllIllIII = true;
            for (int lllllllllllllIIllIIIlIlIllIlIlll = 0; lllllllllllllIIllIIIlIlIllIlIlll < this.size(); ++lllllllllllllIIllIIIlIlIllIlIlll) {
                if (lllllllllllllIIllIIIlIlIllIllIII && this.get(lllllllllllllIIllIIIlIlIllIlIlll).equals(lllllllllllllIIllIIIlIlIllIllIlI)) {
                    lllllllllllllIIllIIIlIlIllIllIII = false;
                }
                else {
                    lllllllllllllIIllIIIlIlIllIllIIl[lllllllllllllIIllIIIlIlIllIllIII ? lllllllllllllIIllIIIlIlIllIlIlll : (lllllllllllllIIllIIIlIlIllIlIlll - 1)] = this.get(lllllllllllllIIllIIIlIlIllIlIlll);
                }
            }
            this.set(lllllllllllllIIllIIIlIlIllIllIIl);
        }
    }
    
    public int size() {
        return this.array().length;
    }
    
    public T[] array() {
        return this.elements;
    }
}
