package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.fastutil.bytes.*;
import com.viaversion.viaversion.libs.fastutil.shorts.*;
import java.util.*;
import java.io.*;

public final class IntIterators
{
    public static final /* synthetic */ EmptyIterator EMPTY_ITERATOR;
    
    public static IntList pour(final IntIterator llllllllllllllllIIIIlIlIIlllllII) {
        return pour(llllllllllllllllIIIIlIlIIlllllII, Integer.MAX_VALUE);
    }
    
    public static IntListIterator wrap(final int[] llllllllllllllllIIIIlIlIllllllII, final int llllllllllllllllIIIIlIlIlllllllI, final int llllllllllllllllIIIIlIlIlllllIlI) {
        IntArrays.ensureOffsetLength(llllllllllllllllIIIIlIlIllllllII, llllllllllllllllIIIIlIlIlllllllI, llllllllllllllllIIIIlIlIlllllIlI);
        return new ArrayIterator(llllllllllllllllIIIIlIlIllllllII, llllllllllllllllIIIIlIlIlllllllI, llllllllllllllllIIIIlIlIlllllIlI);
    }
    
    public static int[] unwrap(final IntIterator llllllllllllllllIIIIlIlIllIlIlII) {
        return unwrap(llllllllllllllllIIIIlIlIllIlIlII, Integer.MAX_VALUE);
    }
    
    public static long unwrap(final IntIterator llllllllllllllllIIIIlIlIlIllllll, final int[][] llllllllllllllllIIIIlIlIlIlllllI) {
        return unwrap(llllllllllllllllIIIIlIlIlIllllll, llllllllllllllllIIIIlIlIlIlllllI, 0L, BigArrays.length(llllllllllllllllIIIIlIlIlIlllllI));
    }
    
    public static IntListIterator wrap(final int[] llllllllllllllllIIIIlIlIllllIlll) {
        return new ArrayIterator(llllllllllllllllIIIIlIlIllllIlll, 0, llllllllllllllllIIIIlIlIllllIlll.length);
    }
    
    public static boolean all(final IntIterator llllllllllllllllIIIIlIlIIllIllIl, final IntPredicate llllllllllllllllIIIIlIlIIllIlIlI) {
        Objects.requireNonNull(llllllllllllllllIIIIlIlIIllIlIlI);
        while (llllllllllllllllIIIIlIlIIllIllIl.hasNext()) {
            if (!llllllllllllllllIIIIlIlIIllIlIlI.test(llllllllllllllllIIIIlIlIIllIllIl.nextInt())) {
                return false;
            }
        }
        return true;
    }
    
    public static int unwrap(final IntIterator llllllllllllllllIIIIlIlIlllIIlIl, final int[] llllllllllllllllIIIIlIlIlllIIIlI) {
        return unwrap(llllllllllllllllIIIIlIlIlllIIlIl, llllllllllllllllIIIIlIlIlllIIIlI, 0, llllllllllllllllIIIIlIlIlllIIIlI.length);
    }
    
    public static int unwrap(final IntIterator llllllllllllllllIIIIlIlIlIlllIIl, final IntCollection llllllllllllllllIIIIlIlIlIllIlII, final int llllllllllllllllIIIIlIlIlIllIlll) {
        if (llllllllllllllllIIIIlIlIlIllIlll < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(llllllllllllllllIIIIlIlIlIllIlll).append(") is negative")));
        }
        int llllllllllllllllIIIIlIlIlIllIllI = llllllllllllllllIIIIlIlIlIllIlll;
        while (llllllllllllllllIIIIlIlIlIllIllI-- != 0 && llllllllllllllllIIIIlIlIlIlllIIl.hasNext()) {
            llllllllllllllllIIIIlIlIlIllIlII.add(llllllllllllllllIIIIlIlIlIlllIIl.nextInt());
        }
        return llllllllllllllllIIIIlIlIlIllIlll - llllllllllllllllIIIIlIlIlIllIllI - 1;
    }
    
    public static int[] unwrap(final IntIterator llllllllllllllllIIIIlIlIllIllIIl, int llllllllllllllllIIIIlIlIllIllIII) {
        if (llllllllllllllllIIIIlIlIllIllIII < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(llllllllllllllllIIIIlIlIllIllIII).append(") is negative")));
        }
        int[] llllllllllllllllIIIIlIlIllIllIll = new int[16];
        int llllllllllllllllIIIIlIlIllIllIlI = 0;
        while (llllllllllllllllIIIIlIlIllIllIII-- != 0 && llllllllllllllllIIIIlIlIllIllIIl.hasNext()) {
            if (llllllllllllllllIIIIlIlIllIllIlI == llllllllllllllllIIIIlIlIllIllIll.length) {
                llllllllllllllllIIIIlIlIllIllIll = IntArrays.grow(llllllllllllllllIIIIlIlIllIllIll, llllllllllllllllIIIIlIlIllIllIlI + 1);
            }
            llllllllllllllllIIIIlIlIllIllIll[llllllllllllllllIIIIlIlIllIllIlI++] = llllllllllllllllIIIIlIlIllIllIIl.nextInt();
        }
        return IntArrays.trim(llllllllllllllllIIIIlIlIllIllIll, llllllllllllllllIIIIlIlIllIllIlI);
    }
    
    public static boolean any(final IntIterator llllllllllllllllIIIIlIlIIlllIIll, final IntPredicate llllllllllllllllIIIIlIlIIlllIIII) {
        return indexOf(llllllllllllllllIIIIlIlIIlllIIll, llllllllllllllllIIIIlIlIIlllIIII) != -1;
    }
    
    public static int[][] unwrapBig(final IntIterator llllllllllllllllIIIIlIlIlIlIlIIl, long llllllllllllllllIIIIlIlIlIlIlIII) {
        if (llllllllllllllllIIIIlIlIlIlIlIII < 0L) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(llllllllllllllllIIIIlIlIlIlIlIII).append(") is negative")));
        }
        int[][] llllllllllllllllIIIIlIlIlIlIlIll = IntBigArrays.newBigArray(16L);
        long llllllllllllllllIIIIlIlIlIlIlIlI = 0L;
        while (llllllllllllllllIIIIlIlIlIlIlIII-- != 0L && llllllllllllllllIIIIlIlIlIlIlIIl.hasNext()) {
            if (llllllllllllllllIIIIlIlIlIlIlIlI == BigArrays.length(llllllllllllllllIIIIlIlIlIlIlIll)) {
                llllllllllllllllIIIIlIlIlIlIlIll = BigArrays.grow(llllllllllllllllIIIIlIlIlIlIlIll, llllllllllllllllIIIIlIlIlIlIlIlI + 1L);
            }
            BigArrays.set(llllllllllllllllIIIIlIlIlIlIlIll, llllllllllllllllIIIIlIlIlIlIlIlI++, llllllllllllllllIIIIlIlIlIlIlIIl.nextInt());
        }
        return BigArrays.trim(llllllllllllllllIIIIlIlIlIlIlIll, llllllllllllllllIIIIlIlIlIlIlIlI);
    }
    
    public static IntIterator unmodifiable(final IntIterator llllllllllllllllIIIIlIlIIlIIllIl) {
        return (IntIterator)new IntIterators.UnmodifiableIterator(llllllllllllllllIIIIlIlIIlIIllIl);
    }
    
    public static IntIterator wrap(final ByteIterator llllllllllllllllIIIIlIlIIlIIIlII) {
        return (IntIterator)new IntIterators.ByteIteratorWrapper(llllllllllllllllIIIIlIlIIlIIIlII);
    }
    
    public static int pour(final IntIterator llllllllllllllllIIIIlIlIlIIIlIll, final IntCollection llllllllllllllllIIIIlIlIlIIIlIII) {
        return pour(llllllllllllllllIIIIlIlIlIIIlIll, llllllllllllllllIIIIlIlIlIIIlIII, Integer.MAX_VALUE);
    }
    
    public static int indexOf(final IntIterator llllllllllllllllIIIIlIlIIllIIIll, final IntPredicate llllllllllllllllIIIIlIlIIllIIlII) {
        Objects.requireNonNull(llllllllllllllllIIIIlIlIIllIIlII);
        int llllllllllllllllIIIIlIlIIllIIllI = 0;
        while (llllllllllllllllIIIIlIlIIllIIIll.hasNext()) {
            if (llllllllllllllllIIIIlIlIIllIIlII.test(llllllllllllllllIIIIlIlIIllIIIll.nextInt())) {
                return llllllllllllllllIIIIlIlIIllIIllI;
            }
            ++llllllllllllllllIIIIlIlIIllIIllI;
        }
        return -1;
    }
    
    private IntIterators() {
    }
    
    public static int unwrap(final IntIterator llllllllllllllllIIIIlIlIllllIIIl, final int[] llllllllllllllllIIIIlIlIlllIlIll, int llllllllllllllllIIIIlIlIlllIlIlI, final int llllllllllllllllIIIIlIlIlllIlllI) {
        if (llllllllllllllllIIIIlIlIlllIlllI < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(llllllllllllllllIIIIlIlIlllIlllI).append(") is negative")));
        }
        if (llllllllllllllllIIIIlIlIlllIlIlI < 0 || llllllllllllllllIIIIlIlIlllIlIlI + llllllllllllllllIIIIlIlIlllIlllI > llllllllllllllllIIIIlIlIlllIlIll.length) {
            throw new IllegalArgumentException();
        }
        int llllllllllllllllIIIIlIlIlllIllIl = llllllllllllllllIIIIlIlIlllIlllI;
        while (llllllllllllllllIIIIlIlIlllIllIl-- != 0 && llllllllllllllllIIIIlIlIllllIIIl.hasNext()) {
            llllllllllllllllIIIIlIlIlllIlIll[llllllllllllllllIIIIlIlIlllIlIlI++] = llllllllllllllllIIIIlIlIllllIIIl.nextInt();
        }
        return llllllllllllllllIIIIlIlIlllIlllI - llllllllllllllllIIIIlIlIlllIllIl - 1;
    }
    
    public static IntIterator asIntIterator(final Iterator llllllllllllllllIIIIlIlIIllllIIl) {
        if (llllllllllllllllIIIIlIlIIllllIIl instanceof IntIterator) {
            return (IntIterator)llllllllllllllllIIIIlIlIIllllIIl;
        }
        return new IteratorWrapper(llllllllllllllllIIIIlIlIIllllIIl);
    }
    
    public static int pour(final IntIterator llllllllllllllllIIIIlIlIlIIlIIIl, final IntCollection llllllllllllllllIIIIlIlIlIIlIIII, final int llllllllllllllllIIIIlIlIlIIIllll) {
        if (llllllllllllllllIIIIlIlIlIIIllll < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(llllllllllllllllIIIIlIlIlIIIllll).append(") is negative")));
        }
        int llllllllllllllllIIIIlIlIlIIlIIlI = llllllllllllllllIIIIlIlIlIIIllll;
        while (llllllllllllllllIIIIlIlIlIIlIIlI-- != 0 && llllllllllllllllIIIIlIlIlIIlIIIl.hasNext()) {
            llllllllllllllllIIIIlIlIlIIlIIII.add(llllllllllllllllIIIIlIlIlIIlIIIl.nextInt());
        }
        return llllllllllllllllIIIIlIlIlIIIllll - llllllllllllllllIIIIlIlIlIIlIIlI - 1;
    }
    
    public static long unwrap(final IntIterator llllllllllllllllIIIIlIlIllIIlIII, final int[][] llllllllllllllllIIIIlIlIllIIIlll, long llllllllllllllllIIIIlIlIllIIIllI, final long llllllllllllllllIIIIlIlIllIIlIlI) {
        if (llllllllllllllllIIIIlIlIllIIlIlI < 0L) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(llllllllllllllllIIIIlIlIllIIlIlI).append(") is negative")));
        }
        if (llllllllllllllllIIIIlIlIllIIIllI < 0L || llllllllllllllllIIIIlIlIllIIIllI + llllllllllllllllIIIIlIlIllIIlIlI > BigArrays.length(llllllllllllllllIIIIlIlIllIIIlll)) {
            throw new IllegalArgumentException();
        }
        long llllllllllllllllIIIIlIlIllIIlIIl = llllllllllllllllIIIIlIlIllIIlIlI;
        while (llllllllllllllllIIIIlIlIllIIlIIl-- != 0L && llllllllllllllllIIIIlIlIllIIlIII.hasNext()) {
            BigArrays.set(llllllllllllllllIIIIlIlIllIIIlll, (long)(llllllllllllllllIIIIlIlIllIIIllI++), llllllllllllllllIIIIlIlIllIIlIII.nextInt());
        }
        return llllllllllllllllIIIIlIlIllIIlIlI - llllllllllllllllIIIIlIlIllIIlIIl - 1L;
    }
    
    public static IntList pour(final IntIterator llllllllllllllllIIIIlIlIlIIIIIIl, final int llllllllllllllllIIIIlIlIlIIIIIll) {
        final IntArrayList llllllllllllllllIIIIlIlIlIIIIIlI = new IntArrayList();
        pour(llllllllllllllllIIIIlIlIlIIIIIIl, llllllllllllllllIIIIlIlIlIIIIIlI, llllllllllllllllIIIIlIlIlIIIIIll);
        llllllllllllllllIIIIlIlIlIIIIIlI.trim();
        return llllllllllllllllIIIIlIlIlIIIIIlI;
    }
    
    public static int[][] unwrapBig(final IntIterator llllllllllllllllIIIIlIlIlIlIIIll) {
        return unwrapBig(llllllllllllllllIIIIlIlIlIlIIIll, Long.MAX_VALUE);
    }
    
    public static IntBidirectionalIterator unmodifiable(final IntBidirectionalIterator llllllllllllllllIIIIlIlIIlIIlIIl) {
        return (IntBidirectionalIterator)new IntIterators.UnmodifiableBidirectionalIterator(llllllllllllllllIIIIlIlIIlIIlIIl);
    }
    
    public static long unwrap(final IntIterator llllllllllllllllIIIIlIlIlIIlllII, final IntCollection llllllllllllllllIIIIlIlIlIIllIll) {
        long llllllllllllllllIIIIlIlIlIIlllIl = 0L;
        while (llllllllllllllllIIIIlIlIlIIlllII.hasNext()) {
            llllllllllllllllIIIIlIlIlIIllIll.add(llllllllllllllllIIIIlIlIlIIlllII.nextInt());
            ++llllllllllllllllIIIIlIlIlIIlllIl;
        }
        return llllllllllllllllIIIIlIlIlIIlllIl;
    }
    
    public static IntIterator concat(final IntIterator[] llllllllllllllllIIIIlIlIIlIllIIl) {
        return concat(llllllllllllllllIIIIlIlIIlIllIIl, 0, llllllllllllllllIIIIlIlIIlIllIIl.length);
    }
    
    public static IntListIterator singleton(final int llllllllllllllllIIIIlIllIIIIIlII) {
        return new SingletonIterator(llllllllllllllllIIIIlIllIIIIIlII);
    }
    
    public static IntIterator wrap(final ShortIterator llllllllllllllllIIIIlIlIIlIIIIII) {
        return (IntIterator)new IntIterators.ShortIteratorWrapper(llllllllllllllllIIIIlIlIIlIIIIII);
    }
    
    public static IntListIterator asIntIterator(final ListIterator llllllllllllllllIIIIlIlIIlllIllI) {
        if (llllllllllllllllIIIIlIlIIlllIllI instanceof IntListIterator) {
            return (IntListIterator)llllllllllllllllIIIIlIlIIlllIllI;
        }
        return new ListIteratorWrapper(llllllllllllllllIIIIlIlIIlllIllI);
    }
    
    public static IntListIterator fromTo(final int llllllllllllllllIIIIlIlIIlIlllII, final int llllllllllllllllIIIIlIlIIlIlllIl) {
        return new IntervalIterator(llllllllllllllllIIIIlIlIIlIlllII, llllllllllllllllIIIIlIlIIlIlllIl);
    }
    
    static {
        EMPTY_ITERATOR = new EmptyIterator();
    }
    
    public static IntListIterator unmodifiable(final IntListIterator llllllllllllllllIIIIlIlIIlIIIlll) {
        return (IntListIterator)new IntIterators.UnmodifiableListIterator(llllllllllllllllIIIIlIlIIlIIIlll);
    }
    
    public static IntIterator concat(final IntIterator[] llllllllllllllllIIIIlIlIIlIlIIIl, final int llllllllllllllllIIIIlIlIIlIlIIll, final int llllllllllllllllIIIIlIlIIlIIllll) {
        return new IteratorConcatenator(llllllllllllllllIIIIlIlIIlIlIIIl, llllllllllllllllIIIIlIlIIlIlIIll, llllllllllllllllIIIIlIlIIlIIllll);
    }
    
    private static class IteratorWrapper implements IntIterator
    {
        final /* synthetic */ Iterator<Integer> i;
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
        
        public IteratorWrapper(final Iterator<Integer> lllllllllllllllIIllIlIlIIlIlIIll) {
            this.i = lllllllllllllllIIllIlIlIIlIlIIll;
        }
        
        @Override
        public int nextInt() {
            return this.i.next();
        }
        
        @Override
        public void remove() {
            this.i.remove();
        }
    }
    
    private static class IteratorConcatenator implements IntIterator
    {
        /* synthetic */ int offset;
        /* synthetic */ int length;
        /* synthetic */ int lastOffset;
        final /* synthetic */ IntIterator[] a;
        
        public IteratorConcatenator(final IntIterator[] llllllllllllllIIIIIIIIIIIIIlIIlI, final int llllllllllllllIIIIIIIIIIIIIlIlIl, final int llllllllllllllIIIIIIIIIIIIIlIlII) {
            this.lastOffset = -1;
            this.a = llllllllllllllIIIIIIIIIIIIIlIIlI;
            this.offset = llllllllllllllIIIIIIIIIIIIIlIlIl;
            this.length = llllllllllllllIIIIIIIIIIIIIlIlII;
            this.advance();
        }
        
        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final IntIterator[] a = this.a;
            final int offset = this.offset;
            this.lastOffset = offset;
            final int llllllllllllllIIIIIIIIIIIIIIIllI = a[offset].nextInt();
            this.advance();
            return llllllllllllllIIIIIIIIIIIIIIIllI;
        }
        
        @Override
        public boolean hasNext() {
            return this.length > 0;
        }
        
        @Override
        public int skip(final int lllllllllllllIlllllllllllllllIIl) {
            this.lastOffset = -1;
            int lllllllllllllIlllllllllllllllIll = 0;
            while (lllllllllllllIlllllllllllllllIll < lllllllllllllIlllllllllllllllIIl && this.length != 0) {
                lllllllllllllIlllllllllllllllIll += this.a[this.offset].skip(lllllllllllllIlllllllllllllllIIl - lllllllllllllIlllllllllllllllIll);
                if (this.a[this.offset].hasNext()) {
                    break;
                }
                --this.length;
                ++this.offset;
            }
            return lllllllllllllIlllllllllllllllIll;
        }
        
        private void advance() {
            while (this.length != 0 && !this.a[this.offset].hasNext()) {
                --this.length;
                ++this.offset;
            }
        }
        
        @Override
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.a[this.lastOffset].remove();
        }
    }
    
    private static class SingletonIterator implements IntListIterator
    {
        private final /* synthetic */ int element;
        private /* synthetic */ int curr;
        
        public SingletonIterator(final int lllllllllllllIlIIIIIlIllIlIlIIlI) {
            this.element = lllllllllllllIlIIIIIlIllIlIlIIlI;
        }
        
        @Override
        public boolean hasNext() {
            return this.curr == 0;
        }
        
        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }
        
        @Override
        public int previousIndex() {
            return this.curr - 1;
        }
        
        @Override
        public boolean hasPrevious() {
            return this.curr == 1;
        }
        
        @Override
        public int previousInt() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }
        
        @Override
        public int nextIndex() {
            return this.curr;
        }
    }
    
    public static class EmptyIterator implements Cloneable, IntListIterator, Serializable
    {
        @Override
        public int nextIndex() {
            return 0;
        }
        
        @Override
        public boolean hasNext() {
            return false;
        }
        
        @Override
        public int skip(final int llllllllIIlllI) {
            return 0;
        }
        
        @Override
        public int nextInt() {
            throw new NoSuchElementException();
        }
        
        private Object readResolve() {
            return IntIterators.EMPTY_ITERATOR;
        }
        
        @Override
        public int previousInt() {
            throw new NoSuchElementException();
        }
        
        @Override
        public boolean hasPrevious() {
            return false;
        }
        
        protected EmptyIterator() {
        }
        
        public Object clone() {
            return IntIterators.EMPTY_ITERATOR;
        }
        
        @Override
        public int previousIndex() {
            return -1;
        }
        
        @Override
        public int back(final int llllllllIIllII) {
            return 0;
        }
    }
    
    private static class ListIteratorWrapper implements IntListIterator
    {
        final /* synthetic */ ListIterator<Integer> i;
        
        @Override
        public int previousInt() {
            return this.i.previous();
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
        
        @Override
        public int nextInt() {
            return this.i.next();
        }
        
        @Override
        public int previousIndex() {
            return this.i.previousIndex();
        }
        
        @Override
        public void set(final int lllllllllllllIlllllllIllIllIlIlI) {
            this.i.set(lllllllllllllIlllllllIllIllIlIlI);
        }
        
        @Override
        public void add(final int lllllllllllllIlllllllIllIllIIllI) {
            this.i.add(lllllllllllllIlllllllIllIllIIllI);
        }
        
        public ListIteratorWrapper(final ListIterator<Integer> lllllllllllllIlllllllIllIlllllII) {
            this.i = lllllllllllllIlllllllIllIlllllII;
        }
        
        @Override
        public void remove() {
            this.i.remove();
        }
        
        @Override
        public boolean hasPrevious() {
            return this.i.hasPrevious();
        }
        
        @Override
        public int nextIndex() {
            return this.i.nextIndex();
        }
    }
    
    private static class ArrayIterator implements IntListIterator
    {
        private final /* synthetic */ int[] array;
        private /* synthetic */ int curr;
        private final /* synthetic */ int length;
        private final /* synthetic */ int offset;
        
        @Override
        public int previousInt() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            final int[] array = this.array;
            final int offset = this.offset;
            final int curr = this.curr - 1;
            this.curr = curr;
            return array[offset + curr];
        }
        
        @Override
        public int back(int lllllllllllllIllIIlIIIIlllIIlIII) {
            if (lllllllllllllIllIIlIIIIlllIIlIII <= this.curr) {
                this.curr -= lllllllllllllIllIIlIIIIlllIIlIII;
                return lllllllllllllIllIIlIIIIlllIIlIII;
            }
            lllllllllllllIllIIlIIIIlllIIlIII = this.curr;
            this.curr = 0;
            return lllllllllllllIllIIlIIIIlllIIlIII;
        }
        
        @Override
        public int nextIndex() {
            return this.curr;
        }
        
        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            return this.array[this.offset + this.curr++];
        }
        
        @Override
        public boolean hasPrevious() {
            return this.curr > 0;
        }
        
        public ArrayIterator(final int[] lllllllllllllIllIIlIIIIllllIIlII, final int lllllllllllllIllIIlIIIIlllIlllll, final int lllllllllllllIllIIlIIIIllllIIIlI) {
            this.array = lllllllllllllIllIIlIIIIllllIIlII;
            this.offset = lllllllllllllIllIIlIIIIlllIlllll;
            this.length = lllllllllllllIllIIlIIIIllllIIIlI;
        }
        
        @Override
        public int previousIndex() {
            return this.curr - 1;
        }
        
        @Override
        public int skip(int lllllllllllllIllIIlIIIIlllIIllII) {
            if (lllllllllllllIllIIlIIIIlllIIllII <= this.length - this.curr) {
                this.curr += lllllllllllllIllIIlIIIIlllIIllII;
                return lllllllllllllIllIIlIIIIlllIIllII;
            }
            lllllllllllllIllIIlIIIIlllIIllII = this.length - this.curr;
            this.curr = this.length;
            return lllllllllllllIllIIlIIIIlllIIllII;
        }
        
        @Override
        public boolean hasNext() {
            return this.curr < this.length;
        }
    }
    
    private static class IntervalIterator implements IntListIterator
    {
        private final /* synthetic */ int from;
        /* synthetic */ int curr;
        private final /* synthetic */ int to;
        
        public IntervalIterator(final int llllllllllllllIIIIIIIIllllllIlll, final int llllllllllllllIIIIIIIIllllllIIll) {
            this.curr = llllllllllllllIIIIIIIIllllllIlll;
            this.from = llllllllllllllIIIIIIIIllllllIlll;
            this.to = llllllllllllllIIIIIIIIllllllIIll;
        }
        
        @Override
        public int previousInt() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            final int curr = this.curr - 1;
            this.curr = curr;
            return curr;
        }
        
        @Override
        public boolean hasNext() {
            return this.curr < this.to;
        }
        
        @Override
        public int back(int llllllllllllllIIIIIIIIllllIlIlIl) {
            if (this.curr - llllllllllllllIIIIIIIIllllIlIlIl >= this.from) {
                this.curr -= llllllllllllllIIIIIIIIllllIlIlIl;
                return llllllllllllllIIIIIIIIllllIlIlIl;
            }
            llllllllllllllIIIIIIIIllllIlIlIl = this.curr - this.from;
            this.curr = this.from;
            return llllllllllllllIIIIIIIIllllIlIlIl;
        }
        
        @Override
        public int previousIndex() {
            return this.curr - this.from - 1;
        }
        
        @Override
        public boolean hasPrevious() {
            return this.curr > this.from;
        }
        
        @Override
        public int skip(int llllllllllllllIIIIIIIIllllIlllIl) {
            if (this.curr + llllllllllllllIIIIIIIIllllIlllIl <= this.to) {
                this.curr += llllllllllllllIIIIIIIIllllIlllIl;
                return llllllllllllllIIIIIIIIllllIlllIl;
            }
            llllllllllllllIIIIIIIIllllIlllIl = this.to - this.curr;
            this.curr = this.to;
            return llllllllllllllIIIIIIIIllllIlllIl;
        }
        
        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            return this.curr++;
        }
        
        @Override
        public int nextIndex() {
            return this.curr - this.from;
        }
    }
}
