package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;
import java.util.*;

public final class IntSets
{
    public static final /* synthetic */ EmptySet EMPTY_SET;
    
    public static IntSet synchronize(final IntSet lllllllllllllIlIllIlllIIIllIIIlI, final Object lllllllllllllIlIllIlllIIIllIIIIl) {
        return (IntSet)new IntSets.SynchronizedSet(lllllllllllllIlIllIlllIIIllIIIlI, lllllllllllllIlIllIlllIIIllIIIIl);
    }
    
    public static IntSet singleton(final Integer lllllllllllllIlIllIlllIIIllIlIlI) {
        return new Singleton(lllllllllllllIlIllIlllIIIllIlIlI);
    }
    
    public static IntSet synchronize(final IntSet lllllllllllllIlIllIlllIIIllIIlll) {
        return (IntSet)new IntSets.SynchronizedSet(lllllllllllllIlIllIlllIIIllIIlll);
    }
    
    public static IntSet unmodifiable(final IntSet lllllllllllllIlIllIlllIIIlIlllll) {
        return (IntSet)new IntSets.UnmodifiableSet(lllllllllllllIlIllIlllIIIlIlllll);
    }
    
    private IntSets() {
    }
    
    static {
        EMPTY_SET = new EmptySet();
    }
    
    public static IntSet singleton(final int lllllllllllllIlIllIlllIIIllIlllI) {
        return new Singleton(lllllllllllllIlIllIlllIIIllIlllI);
    }
    
    public static class EmptySet extends IntCollections.EmptyCollection implements Serializable, Cloneable, IntSet
    {
        @Deprecated
        @Override
        public boolean rem(final int lllllllllllllIllIlllIIIIllIllIII) {
            return super.rem(lllllllllllllIllIlllIIIIllIllIII);
        }
        
        private Object readResolve() {
            return IntSets.EMPTY_SET;
        }
        
        public Object clone() {
            return IntSets.EMPTY_SET;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIllIlllIIIIllIlllll) {
            return lllllllllllllIllIlllIIIIllIlllll instanceof Set && ((Set)lllllllllllllIllIlllIIIIllIlllll).isEmpty();
        }
        
        protected EmptySet() {
        }
        
        @Override
        public boolean remove(final int lllllllllllllIllIlllIIIIlllIIIll) {
            throw new UnsupportedOperationException();
        }
    }
    
    public static class Singleton extends AbstractIntSet implements Cloneable, Serializable
    {
        protected final /* synthetic */ int element;
        
        @Override
        public boolean addAll(final IntCollection lllllllllllllIlllIIllIIIIIllIIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int size() {
            return 1;
        }
        
        @Override
        public boolean remove(final int lllllllllllllIlllIIllIIIIIllllII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean retainAll(final Collection<?> lllllllllllllIlllIIllIIIIIllIIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final Collection<? extends Integer> lllllllllllllIlllIIllIIIIIllIllI) {
            throw new UnsupportedOperationException();
        }
        
        protected Singleton(final int lllllllllllllIlllIIllIIIIlIIIllI) {
            this.element = lllllllllllllIlllIIllIIIIlIIIllI;
        }
        
        @Override
        public boolean removeAll(final IntCollection lllllllllllllIlllIIllIIIIIlIlllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean contains(final int lllllllllllllIlllIIllIIIIIlllllI) {
            return lllllllllllllIlllIIllIIIIIlllllI == this.element;
        }
        
        @Override
        public IntListIterator iterator() {
            return IntIterators.singleton(this.element);
        }
        
        public Object clone() {
            return this;
        }
        
        @Override
        public boolean retainAll(final IntCollection lllllllllllllIlllIIllIIIIIlIllII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean removeAll(final Collection<?> lllllllllllllIlllIIllIIIIIllIlII) {
            throw new UnsupportedOperationException();
        }
    }
}
