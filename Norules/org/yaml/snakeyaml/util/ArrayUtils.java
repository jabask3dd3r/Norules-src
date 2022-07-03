package org.yaml.snakeyaml.util;

import java.util.*;

public class ArrayUtils
{
    public static <E> List<E> toUnmodifiableCompositeList(final E[] lllllllllllllIllIlIlIlIlIIlIIIlI, final E[] lllllllllllllIllIlIlIlIlIIIllllI) {
        List<E> lllllllllllllIllIlIlIlIlIIlIIIII = null;
        if (lllllllllllllIllIlIlIlIlIIlIIIlI.length == 0) {
            final List<E> lllllllllllllIllIlIlIlIlIIlIIlII = toUnmodifiableList(lllllllllllllIllIlIlIlIlIIIllllI);
        }
        else if (lllllllllllllIllIlIlIlIlIIIllllI.length == 0) {
            final List<E> lllllllllllllIllIlIlIlIlIIlIIIll = toUnmodifiableList(lllllllllllllIllIlIlIlIlIIlIIIlI);
        }
        else {
            lllllllllllllIllIlIlIlIlIIlIIIII = new CompositeUnmodifiableArrayList<E>(lllllllllllllIllIlIlIlIlIIlIIIlI, lllllllllllllIllIlIlIlIlIIIllllI);
        }
        return lllllllllllllIllIlIlIlIlIIlIIIII;
    }
    
    private ArrayUtils() {
    }
    
    public static <E> List<E> toUnmodifiableList(final E[] lllllllllllllIllIlIlIlIlIIlIlIII) {
        return (lllllllllllllIllIlIlIlIlIIlIlIII.length == 0) ? Collections.emptyList() : new UnmodifiableArrayList<E>(lllllllllllllIllIlIlIlIlIIlIlIII);
    }
    
    private static class CompositeUnmodifiableArrayList<E> extends AbstractList<E>
    {
        private final /* synthetic */ E[] array1;
        private final /* synthetic */ E[] array2;
        
        @Override
        public E get(final int lllllllllllllIIlIIIlllllIlIlIIII) {
            if (lllllllllllllIIlIIIlllllIlIlIIII < this.array1.length) {
                final E lllllllllllllIIlIIIlllllIlIlIllI = this.array1[lllllllllllllIIlIIIlllllIlIlIIII];
            }
            else {
                if (lllllllllllllIIlIIIlllllIlIlIIII - this.array1.length >= this.array2.length) {
                    throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index: ").append(lllllllllllllIIlIIIlllllIlIlIIII).append(", Size: ").append(this.size())));
                }
                final E lllllllllllllIIlIIIlllllIlIlIlIl = this.array2[lllllllllllllIIlIIIlllllIlIlIIII - this.array1.length];
            }
            final E lllllllllllllIIlIIIlllllIlIlIIlI;
            return lllllllllllllIIlIIIlllllIlIlIIlI;
        }
        
        @Override
        public int size() {
            return this.array1.length + this.array2.length;
        }
        
        CompositeUnmodifiableArrayList(final E[] lllllllllllllIIlIIIlllllIlIllllI, final E[] lllllllllllllIIlIIIlllllIlIlllIl) {
            this.array1 = lllllllllllllIIlIIIlllllIlIllllI;
            this.array2 = lllllllllllllIIlIIIlllllIlIlllIl;
        }
    }
    
    private static class UnmodifiableArrayList<E> extends AbstractList<E>
    {
        private final /* synthetic */ E[] array;
        
        @Override
        public E get(final int lllllllllllllIllIlllIllIlllllllI) {
            if (lllllllllllllIllIlllIllIlllllllI >= this.array.length) {
                throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index: ").append(lllllllllllllIllIlllIllIlllllllI).append(", Size: ").append(this.size())));
            }
            return this.array[lllllllllllllIllIlllIllIlllllllI];
        }
        
        UnmodifiableArrayList(final E[] lllllllllllllIllIlllIlllIIIIIllI) {
            this.array = lllllllllllllIllIlllIlllIIIIIllI;
        }
        
        @Override
        public int size() {
            return this.array.length;
        }
    }
}
