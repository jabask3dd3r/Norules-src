package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.function.*;
import com.viaversion.viaversion.libs.fastutil.*;
import java.util.*;
import java.io.*;

public final class ObjectIterators
{
    public static final /* synthetic */ EmptyIterator EMPTY_ITERATOR;
    
    public static <K> ObjectListIterator<K> asObjectIterator(final ListIterator<K> lllllllllllllIlllIIlIIllIlIlllII) {
        if (lllllllllllllIlllIIlIIllIlIlllII instanceof ObjectListIterator) {
            return (ObjectListIterator<K>)(ObjectListIterator)lllllllllllllIlllIIlIIllIlIlllII;
        }
        return new ListIteratorWrapper<K>(lllllllllllllIlllIIlIIllIlIlllII);
    }
    
    public static <K> K[] unwrap(final Iterator<? extends K> lllllllllllllIlllIIlIIlllIllllll, int lllllllllllllIlllIIlIIllllIIIIlI) {
        if (lllllllllllllIlllIIlIIllllIIIIlI < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(lllllllllllllIlllIIlIIllllIIIIlI).append(") is negative")));
        }
        K[] lllllllllllllIlllIIlIIllllIIIIIl = (K[])new Object[16];
        int lllllllllllllIlllIIlIIllllIIIIII = 0;
        while (lllllllllllllIlllIIlIIllllIIIIlI-- != 0 && lllllllllllllIlllIIlIIlllIllllll.hasNext()) {
            if (lllllllllllllIlllIIlIIllllIIIIII == lllllllllllllIlllIIlIIllllIIIIIl.length) {
                lllllllllllllIlllIIlIIllllIIIIIl = ObjectArrays.grow(lllllllllllllIlllIIlIIllllIIIIIl, lllllllllllllIlllIIlIIllllIIIIII + 1);
            }
            lllllllllllllIlllIIlIIllllIIIIIl[lllllllllllllIlllIIlIIllllIIIIII++] = (K)lllllllllllllIlllIIlIIlllIllllll.next();
        }
        return ObjectArrays.trim(lllllllllllllIlllIIlIIllllIIIIIl, lllllllllllllIlllIIlIIllllIIIIII);
    }
    
    public static <K> ObjectList<K> pour(final Iterator<K> lllllllllllllIlllIIlIIllIllIlIlI, final int lllllllllllllIlllIIlIIllIllIIllI) {
        final ObjectArrayList<K> lllllllllllllIlllIIlIIllIllIlIII = new ObjectArrayList<K>();
        pour(lllllllllllllIlllIIlIIllIllIlIlI, lllllllllllllIlllIIlIIllIllIlIII, lllllllllllllIlllIIlIIllIllIIllI);
        lllllllllllllIlllIIlIIllIllIlIII.trim();
        return lllllllllllllIlllIIlIIllIllIlIII;
    }
    
    private ObjectIterators() {
    }
    
    public static <K> ObjectIterator<K> concat(final ObjectIterator<? extends K>[] lllllllllllllIlllIIlIIllIlIIIIII, final int lllllllllllllIlllIIlIIllIIllllll, final int lllllllllllllIlllIIlIIllIIlllllI) {
        return new IteratorConcatenator<K>(lllllllllllllIlllIIlIIllIlIIIIII, lllllllllllllIlllIIlIIllIIllllll, lllllllllllllIlllIIlIIllIIlllllI);
    }
    
    public static <K> int indexOf(final ObjectIterator<K> lllllllllllllIlllIIlIIllIlIIlIll, final Predicate<? super K> lllllllllllllIlllIIlIIllIlIIlIlI) {
        Objects.requireNonNull(lllllllllllllIlllIIlIIllIlIIlIlI);
        int lllllllllllllIlllIIlIIllIlIIllII = 0;
        while (lllllllllllllIlllIIlIIllIlIIlIll.hasNext()) {
            if (lllllllllllllIlllIIlIIllIlIIlIlI.test(lllllllllllllIlllIIlIIllIlIIlIll.next())) {
                return lllllllllllllIlllIIlIIllIlIIllII;
            }
            ++lllllllllllllIlllIIlIIllIlIIllII;
        }
        return -1;
    }
    
    public static <K> ObjectIterator<K> emptyIterator() {
        return (ObjectIterator<K>)ObjectIterators.EMPTY_ITERATOR;
    }
    
    public static <K> K[] unwrap(final Iterator<? extends K> lllllllllllllIlllIIlIIlllIlllIIl) {
        return unwrap(lllllllllllllIlllIIlIIlllIlllIIl, Integer.MAX_VALUE);
    }
    
    public static <K> int unwrap(final Iterator<K> lllllllllllllIlllIIlIIlllIIlllll, final ObjectCollection<? super K> lllllllllllllIlllIIlIIlllIIllIlI, final int lllllllllllllIlllIIlIIlllIIllIIl) {
        if (lllllllllllllIlllIIlIIlllIIllIIl < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(lllllllllllllIlllIIlIIlllIIllIIl).append(") is negative")));
        }
        int lllllllllllllIlllIIlIIlllIIlllII = lllllllllllllIlllIIlIIlllIIllIIl;
        while (lllllllllllllIlllIIlIIlllIIlllII-- != 0 && lllllllllllllIlllIIlIIlllIIlllll.hasNext()) {
            lllllllllllllIlllIIlIIlllIIllIlI.add((Object)lllllllllllllIlllIIlIIlllIIlllll.next());
        }
        return lllllllllllllIlllIIlIIlllIIllIIl - lllllllllllllIlllIIlIIlllIIlllII - 1;
    }
    
    public static <K> boolean all(final ObjectIterator<K> lllllllllllllIlllIIlIIllIlIlIIIl, final Predicate<? super K> lllllllllllllIlllIIlIIllIlIlIIII) {
        Objects.requireNonNull(lllllllllllllIlllIIlIIllIlIlIIII);
        while (lllllllllllllIlllIIlIIllIlIlIIIl.hasNext()) {
            if (!lllllllllllllIlllIIlIIllIlIlIIII.test(lllllllllllllIlllIIlIIllIlIlIIIl.next())) {
                return false;
            }
        }
        return true;
    }
    
    public static <K> ObjectListIterator<K> wrap(final K[] lllllllllllllIlllIIlIIlllllIIlIl, final int lllllllllllllIlllIIlIIlllllIIlII, final int lllllllllllllIlllIIlIIlllllIIIll) {
        ObjectArrays.ensureOffsetLength(lllllllllllllIlllIIlIIlllllIIlIl, lllllllllllllIlllIIlIIlllllIIlII, lllllllllllllIlllIIlIIlllllIIIll);
        return new ArrayIterator<K>(lllllllllllllIlllIIlIIlllllIIlIl, lllllllllllllIlllIIlIIlllllIIlII, lllllllllllllIlllIIlIIlllllIIIll);
    }
    
    public static <K> ObjectIterator<K> unmodifiable(final ObjectIterator<K> lllllllllllllIlllIIlIIllIIlllIII) {
        return (ObjectIterator<K>)new ObjectIterators.UnmodifiableIterator((ObjectIterator)lllllllllllllIlllIIlIIllIIlllIII);
    }
    
    public static <K> int unwrap(final Iterator<? extends K> lllllllllllllIlllIIlIIllllIIlIll, final K[] lllllllllllllIlllIIlIIllllIIlIII) {
        return unwrap(lllllllllllllIlllIIlIIllllIIlIll, lllllllllllllIlllIIlIIllllIIlIII, 0, lllllllllllllIlllIIlIIllllIIlIII.length);
    }
    
    public static <K> long unwrap(final Iterator<K> lllllllllllllIlllIIlIIlllIIIIIlI, final ObjectCollection<? super K> lllllllllllllIlllIIlIIlllIIIIIIl) {
        long lllllllllllllIlllIIlIIlllIIIIIll = 0L;
        while (lllllllllllllIlllIIlIIlllIIIIIlI.hasNext()) {
            lllllllllllllIlllIIlIIlllIIIIIIl.add((Object)lllllllllllllIlllIIlIIlllIIIIIlI.next());
            ++lllllllllllllIlllIIlIIlllIIIIIll;
        }
        return lllllllllllllIlllIIlIIlllIIIIIll;
    }
    
    public static <K> int pour(final Iterator<K> lllllllllllllIlllIIlIIllIlllIIIl, final ObjectCollection<? super K> lllllllllllllIlllIIlIIllIlllIIII) {
        return pour(lllllllllllllIlllIIlIIllIlllIIIl, lllllllllllllIlllIIlIIllIlllIIII, Integer.MAX_VALUE);
    }
    
    public static <K> long unwrap(final Iterator<? extends K> lllllllllllllIlllIIlIIlllIlIIlIl, final K[][] lllllllllllllIlllIIlIIlllIlIIlII) {
        return unwrap(lllllllllllllIlllIIlIIlllIlIIlIl, lllllllllllllIlllIIlIIlllIlIIlII, 0L, BigArrays.length(lllllllllllllIlllIIlIIlllIlIIlII));
    }
    
    public static <K> int pour(final Iterator<K> lllllllllllllIlllIIlIIllIlllIlll, final ObjectCollection<? super K> lllllllllllllIlllIIlIIllIlllIllI, final int lllllllllllllIlllIIlIIllIllllIIl) {
        if (lllllllllllllIlllIIlIIllIllllIIl < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(lllllllllllllIlllIIlIIllIllllIIl).append(") is negative")));
        }
        int lllllllllllllIlllIIlIIllIllllIII = lllllllllllllIlllIIlIIllIllllIIl;
        while (lllllllllllllIlllIIlIIllIllllIII-- != 0 && lllllllllllllIlllIIlIIllIlllIlll.hasNext()) {
            lllllllllllllIlllIIlIIllIlllIllI.add((Object)lllllllllllllIlllIIlIIllIlllIlll.next());
        }
        return lllllllllllllIlllIIlIIllIllllIIl - lllllllllllllIlllIIlIIllIllllIII - 1;
    }
    
    public static <K> K[][] unwrapBig(final Iterator<? extends K> lllllllllllllIlllIIlIIlllIIlIIll, long lllllllllllllIlllIIlIIlllIIIlllI) {
        if (lllllllllllllIlllIIlIIlllIIIlllI < 0L) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(lllllllllllllIlllIIlIIlllIIIlllI).append(") is negative")));
        }
        K[][] lllllllllllllIlllIIlIIlllIIlIIIl = (K[][])ObjectBigArrays.newBigArray(16L);
        long lllllllllllllIlllIIlIIlllIIlIIII = 0L;
        while (lllllllllllllIlllIIlIIlllIIIlllI-- != 0L && lllllllllllllIlllIIlIIlllIIlIIll.hasNext()) {
            if (lllllllllllllIlllIIlIIlllIIlIIII == BigArrays.length(lllllllllllllIlllIIlIIlllIIlIIIl)) {
                lllllllllllllIlllIIlIIlllIIlIIIl = BigArrays.grow(lllllllllllllIlllIIlIIlllIIlIIIl, lllllllllllllIlllIIlIIlllIIlIIII + 1L);
            }
            BigArrays.set(lllllllllllllIlllIIlIIlllIIlIIIl, lllllllllllllIlllIIlIIlllIIlIIII++, (K)lllllllllllllIlllIIlIIlllIIlIIll.next());
        }
        return BigArrays.trim(lllllllllllllIlllIIlIIlllIIlIIIl, lllllllllllllIlllIIlIIlllIIlIIII);
    }
    
    public static <K> ObjectList<K> pour(final Iterator<K> lllllllllllllIlllIIlIIllIllIIIll) {
        return pour(lllllllllllllIlllIIlIIllIllIIIll, Integer.MAX_VALUE);
    }
    
    public static <K> ObjectIterator<K> asObjectIterator(final Iterator<K> lllllllllllllIlllIIlIIllIllIIIII) {
        if (lllllllllllllIlllIIlIIllIllIIIII instanceof ObjectIterator) {
            return (ObjectIterator<K>)(ObjectIterator)lllllllllllllIlllIIlIIllIllIIIII;
        }
        return new IteratorWrapper<K>(lllllllllllllIlllIIlIIllIllIIIII);
    }
    
    public static <K> ObjectListIterator<K> unmodifiable(final ObjectListIterator<K> lllllllllllllIlllIIlIIllIIllIIlI) {
        return (ObjectListIterator<K>)new ObjectIterators.UnmodifiableListIterator((ObjectListIterator)lllllllllllllIlllIIlIIllIIllIIlI);
    }
    
    static {
        EMPTY_ITERATOR = new EmptyIterator();
    }
    
    public static <K> ObjectListIterator<K> singleton(final K lllllllllllllIlllIIlIIlllllIlIlI) {
        return new SingletonIterator<K>(lllllllllllllIlllIIlIIlllllIlIlI);
    }
    
    public static <K> K[][] unwrapBig(final Iterator<? extends K> lllllllllllllIlllIIlIIlllIIIlIlI) {
        return unwrapBig(lllllllllllllIlllIIlIIlllIIIlIlI, Long.MAX_VALUE);
    }
    
    public static <K> ObjectListIterator<K> wrap(final K[] lllllllllllllIlllIIlIIllllIllllI) {
        return new ArrayIterator<K>(lllllllllllllIlllIIlIIllllIllllI, 0, lllllllllllllIlllIIlIIllllIllllI.length);
    }
    
    public static <K> long unwrap(final Iterator<? extends K> lllllllllllllIlllIIlIIlllIllIIll, final K[][] lllllllllllllIlllIIlIIlllIllIIlI, long lllllllllllllIlllIIlIIlllIlIllII, final long lllllllllllllIlllIIlIIlllIllIIII) {
        if (lllllllllllllIlllIIlIIlllIllIIII < 0L) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(lllllllllllllIlllIIlIIlllIllIIII).append(") is negative")));
        }
        if (lllllllllllllIlllIIlIIlllIlIllII < 0L || lllllllllllllIlllIIlIIlllIlIllII + lllllllllllllIlllIIlIIlllIllIIII > BigArrays.length(lllllllllllllIlllIIlIIlllIllIIlI)) {
            throw new IllegalArgumentException();
        }
        long lllllllllllllIlllIIlIIlllIlIllll = lllllllllllllIlllIIlIIlllIllIIII;
        while (lllllllllllllIlllIIlIIlllIlIllll-- != 0L && lllllllllllllIlllIIlIIlllIllIIll.hasNext()) {
            BigArrays.set(lllllllllllllIlllIIlIIlllIllIIlI, lllllllllllllIlllIIlIIlllIlIllII++, (K)lllllllllllllIlllIIlIIlllIllIIll.next());
        }
        return lllllllllllllIlllIIlIIlllIllIIII - lllllllllllllIlllIIlIIlllIlIllll - 1L;
    }
    
    public static <K> boolean any(final ObjectIterator<K> lllllllllllllIlllIIlIIllIlIllIIl, final Predicate<? super K> lllllllllllllIlllIIlIIllIlIllIII) {
        return indexOf(lllllllllllllIlllIIlIIllIlIllIIl, lllllllllllllIlllIIlIIllIlIllIII) != -1;
    }
    
    public static <K> int unwrap(final Iterator<? extends K> lllllllllllllIlllIIlIIllllIlIlll, final K[] lllllllllllllIlllIIlIIllllIlIIIl, int lllllllllllllIlllIIlIIllllIlIlIl, final int lllllllllllllIlllIIlIIllllIIllll) {
        if (lllllllllllllIlllIIlIIllllIIllll < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The maximum number of elements (").append(lllllllllllllIlllIIlIIllllIIllll).append(") is negative")));
        }
        if (lllllllllllllIlllIIlIIllllIlIlIl < 0 || lllllllllllllIlllIIlIIllllIlIlIl + lllllllllllllIlllIIlIIllllIIllll > lllllllllllllIlllIIlIIllllIlIIIl.length) {
            throw new IllegalArgumentException();
        }
        int lllllllllllllIlllIIlIIllllIlIIll = lllllllllllllIlllIIlIIllllIIllll;
        while (lllllllllllllIlllIIlIIllllIlIIll-- != 0 && lllllllllllllIlllIIlIIllllIlIlll.hasNext()) {
            lllllllllllllIlllIIlIIllllIlIIIl[lllllllllllllIlllIIlIIllllIlIlIl++] = (K)lllllllllllllIlllIIlIIllllIlIlll.next();
        }
        return lllllllllllllIlllIIlIIllllIIllll - lllllllllllllIlllIIlIIllllIlIIll - 1;
    }
    
    public static <K> ObjectIterator<K> concat(final ObjectIterator<? extends K>[] lllllllllllllIlllIIlIIllIlIIIlIl) {
        return concat(lllllllllllllIlllIIlIIllIlIIIlIl, 0, lllllllllllllIlllIIlIIllIlIIIlIl.length);
    }
    
    public static <K> ObjectBidirectionalIterator<K> unmodifiable(final ObjectBidirectionalIterator<K> lllllllllllllIlllIIlIIllIIllIllI) {
        return (ObjectBidirectionalIterator<K>)new ObjectIterators.UnmodifiableBidirectionalIterator((ObjectBidirectionalIterator)lllllllllllllIlllIIlIIllIIllIllI);
    }
    
    private static class IteratorConcatenator<K> implements ObjectIterator<K>
    {
        /* synthetic */ int lastOffset;
        final /* synthetic */ ObjectIterator<? extends K>[] a;
        /* synthetic */ int offset;
        /* synthetic */ int length;
        
        @Override
        public boolean hasNext() {
            return this.length > 0;
        }
        
        private void advance() {
            while (this.length != 0 && !this.a[this.offset].hasNext()) {
                --this.length;
                ++this.offset;
            }
        }
        
        @Override
        public int skip(final int lllllllllllllIllllllllIIIlIllIIl) {
            this.lastOffset = -1;
            int lllllllllllllIllllllllIIIlIllIll = 0;
            while (lllllllllllllIllllllllIIIlIllIll < lllllllllllllIllllllllIIIlIllIIl && this.length != 0) {
                lllllllllllllIllllllllIIIlIllIll += this.a[this.offset].skip(lllllllllllllIllllllllIIIlIllIIl - lllllllllllllIllllllllIIIlIllIll);
                if (this.a[this.offset].hasNext()) {
                    break;
                }
                --this.length;
                ++this.offset;
            }
            return lllllllllllllIllllllllIIIlIllIll;
        }
        
        @Override
        public K next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            final ObjectIterator<? extends K>[] a = this.a;
            final int offset = this.offset;
            this.lastOffset = offset;
            final K lllllllllllllIllllllllIIIllIIllI = (K)a[offset].next();
            this.advance();
            return lllllllllllllIllllllllIIIllIIllI;
        }
        
        @Override
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.a[this.lastOffset].remove();
        }
        
        public IteratorConcatenator(final ObjectIterator<? extends K>[] lllllllllllllIllllllllIIIlllIllI, final int lllllllllllllIllllllllIIIlllIlIl, final int lllllllllllllIllllllllIIIlllIIII) {
            this.lastOffset = -1;
            this.a = lllllllllllllIllllllllIIIlllIllI;
            this.offset = lllllllllllllIllllllllIIIlllIlIl;
            this.length = lllllllllllllIllllllllIIIlllIIII;
            this.advance();
        }
    }
    
    private static class ArrayIterator<K> implements ObjectListIterator<K>
    {
        private /* synthetic */ int curr;
        private final /* synthetic */ int length;
        private final /* synthetic */ K[] array;
        private final /* synthetic */ int offset;
        
        @Override
        public K next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            return this.array[this.offset + this.curr++];
        }
        
        @Override
        public int back(int lllllllllllllIlIIIIllllIIllIIIlI) {
            if (lllllllllllllIlIIIIllllIIllIIIlI <= this.curr) {
                this.curr -= lllllllllllllIlIIIIllllIIllIIIlI;
                return lllllllllllllIlIIIIllllIIllIIIlI;
            }
            lllllllllllllIlIIIIllllIIllIIIlI = this.curr;
            this.curr = 0;
            return lllllllllllllIlIIIIllllIIllIIIlI;
        }
        
        public ArrayIterator(final K[] lllllllllllllIlIIIIllllIIlllllII, final int lllllllllllllIlIIIIllllIIllllIll, final int lllllllllllllIlIIIIllllIIllllIlI) {
            this.array = lllllllllllllIlIIIIllllIIlllllII;
            this.offset = lllllllllllllIlIIIIllllIIllllIll;
            this.length = lllllllllllllIlIIIIllllIIllllIlI;
        }
        
        @Override
        public boolean hasPrevious() {
            return this.curr > 0;
        }
        
        @Override
        public K previous() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            final K[] array = this.array;
            final int offset = this.offset;
            final int curr = this.curr - 1;
            this.curr = curr;
            return array[offset + curr];
        }
        
        @Override
        public int skip(int lllllllllllllIlIIIIllllIIllIlIlI) {
            if (lllllllllllllIlIIIIllllIIllIlIlI <= this.length - this.curr) {
                this.curr += lllllllllllllIlIIIIllllIIllIlIlI;
                return lllllllllllllIlIIIIllllIIllIlIlI;
            }
            lllllllllllllIlIIIIllllIIllIlIlI = this.length - this.curr;
            this.curr = this.length;
            return lllllllllllllIlIIIIllllIIllIlIlI;
        }
        
        @Override
        public int previousIndex() {
            return this.curr - 1;
        }
        
        @Override
        public int nextIndex() {
            return this.curr;
        }
        
        @Override
        public boolean hasNext() {
            return this.curr < this.length;
        }
    }
    
    private static class ListIteratorWrapper<K> implements ObjectListIterator<K>
    {
        final /* synthetic */ ListIterator<K> i;
        
        @Override
        public int previousIndex() {
            return this.i.previousIndex();
        }
        
        @Override
        public void remove() {
            this.i.remove();
        }
        
        @Override
        public int nextIndex() {
            return this.i.nextIndex();
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
        
        @Override
        public void set(final K lIIllIlllllIIlI) {
            this.i.set(lIIllIlllllIIlI);
        }
        
        public ListIteratorWrapper(final ListIterator<K> lIIlllIIIIIIlII) {
            this.i = lIIlllIIIIIIlII;
        }
        
        @Override
        public boolean hasPrevious() {
            return this.i.hasPrevious();
        }
        
        @Override
        public K previous() {
            return this.i.previous();
        }
        
        @Override
        public void add(final K lIIllIllllIlIlI) {
            this.i.add(lIIllIllllIlIlI);
        }
        
        @Override
        public K next() {
            return this.i.next();
        }
    }
    
    private static class SingletonIterator<K> implements ObjectListIterator<K>
    {
        private final /* synthetic */ K element;
        private /* synthetic */ int curr;
        
        @Override
        public int previousIndex() {
            return this.curr - 1;
        }
        
        @Override
        public boolean hasPrevious() {
            return this.curr == 1;
        }
        
        @Override
        public int nextIndex() {
            return this.curr;
        }
        
        public SingletonIterator(final K llIlIlIIIIIlII) {
            this.element = llIlIlIIIIIlII;
        }
        
        @Override
        public K next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }
        
        @Override
        public boolean hasNext() {
            return this.curr == 0;
        }
        
        @Override
        public K previous() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }
    }
    
    private static class IteratorWrapper<K> implements ObjectIterator<K>
    {
        final /* synthetic */ Iterator<K> i;
        
        public IteratorWrapper(final Iterator<K> lIlllIlllIIIlII) {
            this.i = lIlllIlllIIIlII;
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
        
        @Override
        public void remove() {
            this.i.remove();
        }
        
        @Override
        public K next() {
            return this.i.next();
        }
    }
    
    public static class EmptyIterator<K> implements ObjectListIterator<K>, Serializable, Cloneable
    {
        @Override
        public int previousIndex() {
            return -1;
        }
        
        @Override
        public boolean hasNext() {
            return false;
        }
        
        private Object readResolve() {
            return ObjectIterators.EMPTY_ITERATOR;
        }
        
        public Object clone() {
            return ObjectIterators.EMPTY_ITERATOR;
        }
        
        @Override
        public boolean hasPrevious() {
            return false;
        }
        
        @Override
        public K next() {
            throw new NoSuchElementException();
        }
        
        @Override
        public int back(final int lllllllllllllIIllIllIllIllIlllIl) {
            return 0;
        }
        
        @Override
        public K previous() {
            throw new NoSuchElementException();
        }
        
        @Override
        public int skip(final int lllllllllllllIIllIllIllIllIlllll) {
            return 0;
        }
        
        @Override
        public int nextIndex() {
            return 0;
        }
        
        protected EmptyIterator() {
        }
    }
}
