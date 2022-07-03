package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;
import java.util.*;

public final class IntSortedSets
{
    public static final /* synthetic */ EmptySet EMPTY_SET;
    
    public static IntSortedSet synchronize(final IntSortedSet lllllllllllllllllllllIIllIlIllll, final Object lllllllllllllllllllllIIllIlIllII) {
        return (IntSortedSet)new IntSortedSets.SynchronizedSortedSet(lllllllllllllllllllllIIllIlIllll, lllllllllllllllllllllIIllIlIllII);
    }
    
    public static IntSortedSet singleton(final int lllllllllllllllllllllIIlllIIIlII) {
        return new Singleton(lllllllllllllllllllllIIlllIIIlII);
    }
    
    public static IntSortedSet singleton(final Object lllllllllllllllllllllIIllIlllIll) {
        return new Singleton((int)lllllllllllllllllllllIIllIlllIll);
    }
    
    public static IntSortedSet singleton(final int lllllllllllllllllllllIIllIllllll, final IntComparator lllllllllllllllllllllIIllIlllllI) {
        return new Singleton(lllllllllllllllllllllIIllIllllll, lllllllllllllllllllllIIllIlllllI);
    }
    
    public static IntSortedSet singleton(final Object lllllllllllllllllllllIIllIllIllI, final IntComparator lllllllllllllllllllllIIllIllIlIl) {
        return new Singleton((int)lllllllllllllllllllllIIllIllIllI, lllllllllllllllllllllIIllIllIlIl);
    }
    
    public static IntSortedSet unmodifiable(final IntSortedSet lllllllllllllllllllllIIllIlIlIIl) {
        return (IntSortedSet)new IntSortedSets.UnmodifiableSortedSet(lllllllllllllllllllllIIllIlIlIIl);
    }
    
    private IntSortedSets() {
    }
    
    public static IntSortedSet synchronize(final IntSortedSet lllllllllllllllllllllIIllIllIIll) {
        return (IntSortedSet)new IntSortedSets.SynchronizedSortedSet(lllllllllllllllllllllIIllIllIIll);
    }
    
    static {
        EMPTY_SET = new EmptySet();
    }
    
    public static class Singleton extends IntSets.Singleton implements Serializable, IntSortedSet, Cloneable
    {
        final /* synthetic */ IntComparator comparator;
        
        protected Singleton(final int lllllllllllllIlIIlllIIlllllllIll, final IntComparator lllllllllllllIlIIlllIIlllllllIlI) {
            super(lllllllllllllIlIIlllIIlllllllIll);
            this.comparator = lllllllllllllIlIIlllIIlllllllIlI;
        }
        
        @Override
        public IntComparator comparator() {
            return this.comparator;
        }
        
        @Deprecated
        @Override
        public Integer last() {
            return this.element;
        }
        
        @Deprecated
        @Override
        public Integer first() {
            return this.element;
        }
        
        private Singleton(final int lllllllllllllIlIIlllIIllllllIIIl) {
            this(lllllllllllllIlIIlllIIllllllIIIl, (IntComparator)null);
        }
        
        final int compare(final int lllllllllllllIlIIlllIIlllllIllII, final int lllllllllllllIlIIlllIIlllllIlIII) {
            return (this.comparator == null) ? Integer.compare(lllllllllllllIlIIlllIIlllllIllII, lllllllllllllIlIIlllIIlllllIlIII) : this.comparator.compare(lllllllllllllIlIIlllIIlllllIllII, lllllllllllllIlIIlllIIlllllIlIII);
        }
        
        @Override
        public IntSortedSet tailSet(final int lllllllllllllIlIIlllIIllllIIIlll) {
            if (this.compare(lllllllllllllIlIIlllIIllllIIIlll, this.element) <= 0) {
                return this;
            }
            return IntSortedSets.EMPTY_SET;
        }
        
        @Override
        public IntSortedSet subSet(final int lllllllllllllIlIIlllIIllllIlIlII, final int lllllllllllllIlIIlllIIllllIlIllI) {
            if (this.compare(lllllllllllllIlIIlllIIllllIlIlII, this.element) <= 0 && this.compare(this.element, lllllllllllllIlIIlllIIllllIlIllI) < 0) {
                return this;
            }
            return IntSortedSets.EMPTY_SET;
        }
        
        @Override
        public int lastInt() {
            return this.element;
        }
        
        @Deprecated
        @Override
        public IntSortedSet subSet(final Integer lllllllllllllIlIIlllIIlllIllllII, final Integer lllllllllllllIlIIlllIIlllIlllIll) {
            return this.subSet((int)lllllllllllllIlIIlllIIlllIllllII, (int)lllllllllllllIlIIlllIIlllIlllIll);
        }
        
        @Deprecated
        @Override
        public IntSortedSet tailSet(final Integer lllllllllllllIlIIlllIIlllIlIlllI) {
            return this.tailSet((int)lllllllllllllIlIIlllIIlllIlIlllI);
        }
        
        @Override
        public IntSortedSet headSet(final int lllllllllllllIlIIlllIIllllIIllll) {
            if (this.compare(this.element, lllllllllllllIlIIlllIIllllIIllll) < 0) {
                return this;
            }
            return IntSortedSets.EMPTY_SET;
        }
        
        @Override
        public int firstInt() {
            return this.element;
        }
        
        @Deprecated
        @Override
        public IntSortedSet headSet(final Integer lllllllllllllIlIIlllIIlllIllIlII) {
            return this.headSet((int)lllllllllllllIlIIlllIIlllIllIlII);
        }
        
        @Override
        public IntBidirectionalIterator iterator(final int lllllllllllllIlIIlllIIlllllIIIII) {
            final IntBidirectionalIterator lllllllllllllIlIIlllIIlllllIIIlI = this.iterator();
            if (this.compare(this.element, lllllllllllllIlIIlllIIlllllIIIII) <= 0) {
                lllllllllllllIlIIlllIIlllllIIIlI.nextInt();
            }
            return lllllllllllllIlIIlllIIlllllIIIlI;
        }
    }
    
    public static class EmptySet extends IntSets.EmptySet implements Serializable, IntSortedSet, Cloneable
    {
        @Deprecated
        @Override
        public IntSortedSet tailSet(final Integer llllllllllllllIIIIllllIlIlIlIllI) {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Override
        public int lastInt() {
            throw new NoSuchElementException();
        }
        
        @Deprecated
        @Override
        public IntSortedSet subSet(final Integer llllllllllllllIIIIllllIlIlIllIll, final Integer llllllllllllllIIIIllllIlIlIllIlI) {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Override
        public IntSortedSet headSet(final int llllllllllllllIIIIllllIlIllIIIlI) {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Override
        public IntSortedSet subSet(final int llllllllllllllIIIIllllIlIllIIlIl, final int llllllllllllllIIIIllllIlIllIIlII) {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Override
        public IntSortedSet tailSet(final int llllllllllllllIIIIllllIlIllIIIII) {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Deprecated
        @Override
        public Integer last() {
            throw new NoSuchElementException();
        }
        
        @Override
        public Object clone() {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Deprecated
        @Override
        public Integer first() {
            throw new NoSuchElementException();
        }
        
        @Override
        public IntBidirectionalIterator iterator(final int llllllllllllllIIIIllllIlIllIIlll) {
            return IntIterators.EMPTY_ITERATOR;
        }
        
        @Override
        public int firstInt() {
            throw new NoSuchElementException();
        }
        
        private Object readResolve() {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Deprecated
        @Override
        public IntSortedSet headSet(final Integer llllllllllllllIIIIllllIlIlIllIII) {
            return IntSortedSets.EMPTY_SET;
        }
        
        @Override
        public IntComparator comparator() {
            return null;
        }
        
        protected EmptySet() {
        }
    }
}
