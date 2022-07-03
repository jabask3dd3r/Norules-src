package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;
import java.util.*;

public final class IntLists
{
    public static final /* synthetic */ EmptyList EMPTY_LIST;
    
    private IntLists() {
    }
    
    public static IntList shuffle(final IntList llllllllllllllIlllIllIlIllIllIII, final Random llllllllllllllIlllIllIlIllIlIlll) {
        int llllllllllllllIlllIllIlIllIllIll = llllllllllllllIlllIllIlIllIllIII.size();
        while (llllllllllllllIlllIllIlIllIllIll-- != 0) {
            final int llllllllllllllIlllIllIlIllIlllIl = llllllllllllllIlllIllIlIllIlIlll.nextInt(llllllllllllllIlllIllIlIllIllIll + 1);
            final int llllllllllllllIlllIllIlIllIlllII = llllllllllllllIlllIllIlIllIllIII.getInt(llllllllllllllIlllIllIlIllIllIll);
            llllllllllllllIlllIllIlIllIllIII.set(llllllllllllllIlllIllIlIllIllIll, llllllllllllllIlllIllIlIllIllIII.getInt(llllllllllllllIlllIllIlIllIlllIl));
            llllllllllllllIlllIllIlIllIllIII.set(llllllllllllllIlllIllIlIllIlllIl, llllllllllllllIlllIllIlIllIlllII);
        }
        return llllllllllllllIlllIllIlIllIllIII;
    }
    
    public static IntList singleton(final int llllllllllllllIlllIllIlIllIlIIlI) {
        return new Singleton(llllllllllllllIlllIllIlIllIlIIlI);
    }
    
    public static IntList unmodifiable(final IntList llllllllllllllIlllIllIlIllIIIIll) {
        return (IntList)((llllllllllllllIlllIllIlIllIIIIll instanceof RandomAccess) ? new IntLists.UnmodifiableRandomAccessList(llllllllllllllIlllIllIlIllIIIIll) : new IntLists.UnmodifiableList(llllllllllllllIlllIllIlIllIIIIll));
    }
    
    public static IntList synchronize(final IntList llllllllllllllIlllIllIlIllIIIllI, final Object llllllllllllllIlllIllIlIllIIIlll) {
        return (IntList)((llllllllllllllIlllIllIlIllIIIllI instanceof RandomAccess) ? new IntLists.SynchronizedRandomAccessList(llllllllllllllIlllIllIlIllIIIllI, llllllllllllllIlllIllIlIllIIIlll) : new IntLists.SynchronizedList(llllllllllllllIlllIllIlIllIIIllI, llllllllllllllIlllIllIlIllIIIlll));
    }
    
    public static IntList synchronize(final IntList llllllllllllllIlllIllIlIllIIlIll) {
        return (IntList)((llllllllllllllIlllIllIlIllIIlIll instanceof RandomAccess) ? new IntLists.SynchronizedRandomAccessList(llllllllllllllIlllIllIlIllIIlIll) : new IntLists.SynchronizedList(llllllllllllllIlllIllIlIllIIlIll));
    }
    
    static {
        EMPTY_LIST = new EmptyList();
    }
    
    public static IntList singleton(final Object llllllllllllllIlllIllIlIllIIlllI) {
        return new Singleton((int)llllllllllllllIlllIllIlIllIIlllI);
    }
    
    public static class EmptyList extends IntCollections.EmptyCollection implements Cloneable, Serializable, RandomAccess, IntList
    {
        @Override
        public int lastIndexOf(final int llllllllllllllIllIlllIIIIlIIIlIl) {
            return -1;
        }
        
        @Deprecated
        @Override
        public Integer set(final int llllllllllllllIllIlllIIIIIllIIIl, final Integer llllllllllllllIllIlllIIIIIllIIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntListIterator listIterator(final int llllllllllllllIllIlllIIIIIIlllII) {
            if (llllllllllllllIllIlllIIIIIIlllII == 0) {
                return IntIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(llllllllllllllIllIlllIIIIIIlllII));
        }
        
        @Override
        public void size(final int llllllllllllllIllIllIllllllIllll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final int llllllllllllllIllIlllIIIIlIIIIll, final Collection<? extends Integer> llllllllllllllIllIlllIIIIlIIIIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void removeElements(final int llllllllllllllIllIlllIIIIIIIIlII, final int llllllllllllllIllIlllIIIIIIIIIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntListIterator iterator() {
            return IntIterators.EMPTY_ITERATOR;
        }
        
        @Deprecated
        @Override
        public void unstableSort(final Comparator<? super Integer> llllllllllllllIllIlllIIIIIlIIIlI) {
        }
        
        @Override
        public int set(final int llllllllllllllIllIlllIIIIlIIlIlI, final int llllllllllllllIllIlllIIIIlIIlIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean rem(final int llllllllllllllIllIlllIIIIlIlIIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Deprecated
        @Override
        public Integer remove(final int llllllllllllllIllIlllIIIIIlIlllI) {
            throw new UnsupportedOperationException();
        }
        
        @Deprecated
        @Override
        public void add(final int llllllllllllllIllIlllIIIIIlllIII, final Integer llllllllllllllIllIlllIIIIIllIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int getInt(final int llllllllllllllIllIlllIIIIlIlIIll) {
            throw new IndexOutOfBoundsException();
        }
        
        @Override
        public void addElements(final int llllllllllllllIllIlllIIIIIIIIIIl, final int[] llllllllllllllIllIlllIIIIIIIIIII, final int llllllllllllllIllIllIlllllllllll, final int llllllllllllllIllIllIllllllllllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final int llllllllllllllIllIlllIIIIIlllllI, final IntCollection llllllllllllllIllIlllIIIIIllllIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final int llllllllllllllIllIlllIIIIIlllIll, final IntList llllllllllllllIllIlllIIIIIlllIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void getElements(final int llllllllllllllIllIlllIIIIIIIlIIl, final int[] llllllllllllllIllIlllIIIIIIIlIII, final int llllllllllllllIllIlllIIIIIIIIlll, final int llllllllllllllIllIlllIIIIIIIlIlI) {
            if (llllllllllllllIllIlllIIIIIIIlIIl == 0 && llllllllllllllIllIlllIIIIIIIlIlI == 0 && llllllllllllllIllIlllIIIIIIIIlll >= 0 && llllllllllllllIllIlllIIIIIIIIlll <= llllllllllllllIllIlllIIIIIIIlIII.length) {
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        
        @Deprecated
        @Override
        public Integer get(final int llllllllllllllIllIlllIIIIIllIlIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void unstableSort(final IntComparator llllllllllllllIllIlllIIIIIlIIllI) {
        }
        
        @Override
        public int indexOf(final int llllllllllllllIllIlllIIIIlIIIlll) {
            return -1;
        }
        
        @Override
        public IntList subList(final int llllllllllllllIllIlllIIIIIIlIlll, final int llllllllllllllIllIlllIIIIIIlIIll) {
            if (llllllllllllllIllIlllIIIIIIlIlll == 0 && llllllllllllllIllIlllIIIIIIlIIll == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }
        
        private Object readResolve() {
            return IntLists.EMPTY_LIST;
        }
        
        @Override
        public void setElements(final int[] llllllllllllllIllIllIllllllllIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Deprecated
        @Override
        public int lastIndexOf(final Object llllllllllllllIllIlllIIIIIlIlIlI) {
            return -1;
        }
        
        public Object clone() {
            return IntLists.EMPTY_LIST;
        }
        
        @Override
        public void addElements(final int llllllllllllllIllIllIlllllllllII, final int[] llllllllllllllIllIllIllllllllIll) {
            throw new UnsupportedOperationException();
        }
        
        @Deprecated
        @Override
        public int indexOf(final Object llllllllllllllIllIlllIIIIIlIllII) {
            return -1;
        }
        
        @Override
        public void setElements(final int llllllllllllllIllIllIlllllllIlII, final int[] llllllllllllllIllIllIlllllllIIll, final int llllllllllllllIllIllIlllllllIIlI, final int llllllllllllllIllIllIlllllllIIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void sort(final IntComparator llllllllllllllIllIlllIIIIIlIlIII) {
        }
        
        @Override
        public void add(final int llllllllllllllIllIlllIIIIlIIllIl, final int llllllllllllllIllIlllIIIIlIIllII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void setElements(final int llllllllllllllIllIllIlllllllIlll, final int[] llllllllllllllIllIllIlllllllIllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntListIterator listIterator() {
            return IntIterators.EMPTY_ITERATOR;
        }
        
        @Override
        public boolean addAll(final IntList llllllllllllllIllIlllIIIIlIIIIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int removeInt(final int llllllllllllllIllIlllIIIIlIIllll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public String toString() {
            return "[]";
        }
        
        protected EmptyList() {
        }
        
        @Override
        public int hashCode() {
            return 1;
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIllIllIllllllIIlII) {
            return llllllllllllllIllIllIllllllIIlII instanceof List && ((List)llllllllllllllIllIllIllllllIIlII).isEmpty();
        }
        
        @Deprecated
        @Override
        public void sort(final Comparator<? super Integer> llllllllllllllIllIlllIIIIIlIIlII) {
        }
        
        @Override
        public int compareTo(final List<? extends Integer> llllllllllllllIllIllIllllllIlIll) {
            if (llllllllllllllIllIllIllllllIlIll == this) {
                return 0;
            }
            return llllllllllllllIllIllIllllllIlIll.isEmpty() ? 0 : -1;
        }
        
        @Deprecated
        @Override
        public boolean add(final Integer llllllllllllllIllIlllIIIIIllIIll) {
            throw new UnsupportedOperationException();
        }
    }
    
    public static class Singleton extends AbstractIntList implements RandomAccess, Serializable, Cloneable
    {
        private final /* synthetic */ int element;
        
        @Override
        public int size() {
            return 1;
        }
        
        @Override
        public void removeElements(final int llllllllllllllllIlIllIIIIllIllll, final int llllllllllllllllIlIllIIIIllIlllI) {
            throw new UnsupportedOperationException();
        }
        
        @Deprecated
        @Override
        public void sort(final Comparator<? super Integer> llllllllllllllllIlIllIIIIlllIIll) {
        }
        
        @Override
        public boolean retainAll(final Collection<?> llllllllllllllllIlIllIIIlIIIIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int getInt(final int llllllllllllllllIlIllIIIlIlllIlI) {
            if (llllllllllllllllIlIllIIIlIlllIlI == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }
        
        @Override
        public IntList subList(final int llllllllllllllllIlIllIIIlIIlIlII, final int llllllllllllllllIlIllIIIlIIlIIII) {
            this.ensureIndex(llllllllllllllllIlIllIIIlIIlIlII);
            this.ensureIndex(llllllllllllllllIlIllIIIlIIlIIII);
            if (llllllllllllllllIlIllIIIlIIlIlII > llllllllllllllllIlIllIIIlIIlIIII) {
                throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Start index (").append(llllllllllllllllIlIllIIIlIIlIlII).append(") is greater than end index (").append(llllllllllllllllIlIllIIIlIIlIIII).append(")")));
            }
            if (llllllllllllllllIlIllIIIlIIlIlII != 0 || llllllllllllllllIlIllIIIlIIlIIII != 1) {
                return IntLists.EMPTY_LIST;
            }
            return this;
        }
        
        @Override
        public void setElements(final int llllllllllllllllIlIllIIIIlIlllll, final int[] llllllllllllllllIlIllIIIIlIllllI, final int llllllllllllllllIlIllIIIIlIlllIl, final int llllllllllllllllIlIllIIIIlIlllII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean contains(final int llllllllllllllllIlIllIIIlIllIIII) {
            return llllllllllllllllIlIllIIIlIllIIII == this.element;
        }
        
        protected Singleton(final int llllllllllllllllIlIllIIIlIlllllI) {
            this.element = llllllllllllllllIlIllIIIlIlllllI;
        }
        
        @Override
        public void setElements(final int llllllllllllllllIlIllIIIIllIIIlI, final int[] llllllllllllllllIlIllIIIIllIIIIl) {
            throw new UnsupportedOperationException();
        }
        
        public Object clone() {
            return this;
        }
        
        @Override
        public boolean rem(final int llllllllllllllllIlIllIIIlIllIllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean removeAll(final IntCollection llllllllllllllllIlIllIIIIllllIll) {
            throw new UnsupportedOperationException();
        }
        
        @Deprecated
        @Override
        public void unstableSort(final Comparator<? super Integer> llllllllllllllllIlIllIIIIlllIIIl) {
        }
        
        @Override
        public boolean retainAll(final IntCollection llllllllllllllllIlIllIIIIllllIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void sort(final IntComparator llllllllllllllllIlIllIIIIlllIlll) {
        }
        
        @Override
        public boolean removeAll(final Collection<?> llllllllllllllllIlIllIIIlIIIlIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final int llllllllllllllllIlIllIIIlIIIlllI, final Collection<? extends Integer> llllllllllllllllIlIllIIIlIIIllIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final Collection<? extends Integer> llllllllllllllllIlIllIIIlIIIlIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int removeInt(final int llllllllllllllllIlIllIIIlIllIlII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void unstableSort(final IntComparator llllllllllllllllIlIllIIIIlllIlIl) {
        }
        
        @Override
        public boolean addAll(final IntList llllllllllllllllIlIllIIIlIIIIlIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void size(final int llllllllllllllllIlIllIIIIlIllIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void setElements(final int[] llllllllllllllllIlIllIIIIllIIlII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final int llllllllllllllllIlIllIIIlIIIIIll, final IntList llllllllllllllllIlIllIIIlIIIIIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void addElements(final int llllllllllllllllIlIllIIIIllIllII, final int[] llllllllllllllllIlIllIIIIllIlIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final IntCollection llllllllllllllllIlIllIIIIlllllIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int[] toIntArray() {
            final int[] llllllllllllllllIlIllIIIlIlIlIlI = { this.element };
            return llllllllllllllllIlIllIIIlIlIlIlI;
        }
        
        @Override
        public void addElements(final int llllllllllllllllIlIllIIIIllIlIIl, final int[] llllllllllllllllIlIllIIIIllIlIII, final int llllllllllllllllIlIllIIIIllIIlll, final int llllllllllllllllIlIllIIIIllIIllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final int llllllllllllllllIlIllIIIlIIIIIII, final IntCollection llllllllllllllllIlIllIIIIlllllll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntListIterator listIterator() {
            return IntIterators.singleton(this.element);
        }
        
        @Override
        public IntListIterator listIterator(final int llllllllllllllllIlIllIIIlIIllIlI) {
            if (llllllllllllllllIlIllIIIlIIllIlI > 1 || llllllllllllllllIlIllIIIlIIllIlI < 0) {
                throw new IndexOutOfBoundsException();
            }
            final IntListIterator llllllllllllllllIlIllIIIlIIlllII = this.listIterator();
            if (llllllllllllllllIlIllIIIlIIllIlI == 1) {
                llllllllllllllllIlIllIIIlIIlllII.nextInt();
            }
            return llllllllllllllllIlIllIIIlIIlllII;
        }
        
        @Override
        public IntListIterator iterator() {
            return this.listIterator();
        }
    }
}
