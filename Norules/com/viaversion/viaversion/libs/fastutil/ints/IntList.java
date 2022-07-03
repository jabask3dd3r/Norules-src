package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;

public interface IntList extends List<Integer>, Comparable<List<? extends Integer>>, IntCollection
{
    IntListIterator iterator();
    
    int getInt(final int p0);
    
    @Deprecated
    default void unstableSort(final Comparator<? super Integer> lllllllllllllIllIlIIIlIIIIllIIll) {
        this.unstableSort(IntComparators.asIntComparator(lllllllllllllIllIlIIIlIIIIllIIll));
    }
    
    void removeElements(final int p0, final int p1);
    
    @Deprecated
    default Integer remove(final int lllllllllllllIllIlIIIlIIIlIlIIIl) {
        return this.removeInt(lllllllllllllIllIlIIIlIIIlIlIIIl);
    }
    
    IntList subList(final int p0, final int p1);
    
    void addElements(final int p0, final int[] p1, final int p2, final int p3);
    
    @Deprecated
    default void add(final int lllllllllllllIllIlIIIlIIIlllllIl, final Integer lllllllllllllIllIlIIIlIIIllllIIl) {
        this.add(lllllllllllllIllIlIIIlIIIlllllIl, (int)lllllllllllllIllIlIIIlIIIllllIIl);
    }
    
    int removeInt(final int p0);
    
    default void unstableSort(final IntComparator lllllllllllllIllIlIIIlIIIIlIlIIl) {
        final int[] lllllllllllllIllIlIIIlIIIIlIlIll = this.toIntArray();
        if (lllllllllllllIllIlIIIlIIIIlIlIIl == null) {
            IntArrays.unstableSort(lllllllllllllIllIlIIIlIIIIlIlIll);
        }
        else {
            IntArrays.unstableSort(lllllllllllllIllIlIIIlIIIIlIlIll, lllllllllllllIllIlIIIlIIIIlIlIIl);
        }
        this.setElements(lllllllllllllIllIlIIIlIIIIlIlIll);
    }
    
    @Deprecated
    default boolean contains(final Object lllllllllllllIllIlIIIlIIIlllIlIl) {
        return super.contains(lllllllllllllIllIlIIIlIIIlllIlIl);
    }
    
    @Deprecated
    default boolean add(final Integer lllllllllllllIllIlIIIlIIIlIllIll) {
        return this.add((int)lllllllllllllIllIlIIIlIIIlIllIll);
    }
    
    @Deprecated
    default void sort(final Comparator<? super Integer> lllllllllllllIllIlIIIlIIIlIIIIII) {
        this.sort(IntComparators.asIntComparator(lllllllllllllIllIlIIIlIIIlIIIIII));
    }
    
    void size(final int p0);
    
    boolean add(final int p0);
    
    int lastIndexOf(final int p0);
    
    IntListIterator listIterator();
    
    @Deprecated
    default Integer get(final int lllllllllllllIllIlIIIlIIIllIllll) {
        return this.getInt(lllllllllllllIllIlIIIlIIIllIllll);
    }
    
    @Deprecated
    default Integer set(final int lllllllllllllIllIlIIIlIIIlIIIlll, final Integer lllllllllllllIllIlIIIlIIIlIIlIIl) {
        return this.set(lllllllllllllIllIlIIIlIIIlIIIlll, (int)lllllllllllllIllIlIIIlIIIlIIlIIl);
    }
    
    IntListIterator listIterator(final int p0);
    
    @Deprecated
    default int indexOf(final Object lllllllllllllIllIlIIIlIIIllIIlll) {
        return this.indexOf((int)lllllllllllllIllIlIIIlIIIllIIlll);
    }
    
    void getElements(final int p0, final int[] p1, final int p2, final int p3);
    
    default void setElements(final int lllllllllllllIllIlIIIlIIlIIllIll, final int[] lllllllllllllIllIlIIIlIIlIIlIlll) {
        this.setElements(lllllllllllllIllIlIIIlIIlIIllIll, lllllllllllllIllIlIIIlIIlIIlIlll, 0, lllllllllllllIllIlIIIlIIlIIlIlll.length);
    }
    
    int indexOf(final int p0);
    
    @Deprecated
    default boolean remove(final Object lllllllllllllIllIlIIIlIIIlIlIlIl) {
        return super.remove(lllllllllllllIllIlIIIlIIIlIlIlIl);
    }
    
    default void setElements(final int[] lllllllllllllIllIlIIIlIIlIlIIIII) {
        this.setElements(0, lllllllllllllIllIlIIIlIIlIlIIIII);
    }
    
    @Deprecated
    default int lastIndexOf(final Object lllllllllllllIllIlIIIlIIIllIIIIl) {
        return this.lastIndexOf((int)lllllllllllllIllIlIIIlIIIllIIIIl);
    }
    
    default void sort(final IntComparator lllllllllllllIllIlIIIlIIIIlllIII) {
        if (lllllllllllllIllIlIIIlIIIIlllIII == null) {
            this.unstableSort(lllllllllllllIllIlIIIlIIIIlllIII);
        }
        else {
            final int[] lllllllllllllIllIlIIIlIIIIllllII = this.toIntArray();
            IntArrays.stableSort(lllllllllllllIllIlIIIlIIIIllllII, lllllllllllllIllIlIIIlIIIIlllIII);
            this.setElements(lllllllllllllIllIlIIIlIIIIllllII);
        }
    }
    
    boolean addAll(final int p0, final IntList p1);
    
    default void setElements(final int lllllllllllllIllIlIIIlIIlIIIlllI, final int[] lllllllllllllIllIlIIIlIIlIIIllIl, final int lllllllllllllIllIlIIIlIIlIIIIlIl, final int lllllllllllllIllIlIIIlIIlIIIlIll) {
        if (lllllllllllllIllIlIIIlIIlIIIlllI < 0) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(lllllllllllllIllIlIIIlIIlIIIlllI).append(") is negative")));
        }
        if (lllllllllllllIllIlIIIlIIlIIIlllI > this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(lllllllllllllIllIlIIIlIIlIIIlllI).append(") is greater than list size (").append(this.size()).append(")")));
        }
        IntArrays.ensureOffsetLength(lllllllllllllIllIlIIIlIIlIIIllIl, lllllllllllllIllIlIIIlIIlIIIIlIl, lllllllllllllIllIlIIIlIIlIIIlIll);
        if (lllllllllllllIllIlIIIlIIlIIIlllI + lllllllllllllIllIlIIIlIIlIIIlIll > this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(lllllllllllllIllIlIIIlIIlIIIlllI + lllllllllllllIllIlIIIlIIlIIIlIll).append(") is greater than list size (").append(this.size()).append(")")));
        }
        final IntListIterator lllllllllllllIllIlIIIlIIlIIIlIlI = this.listIterator(lllllllllllllIllIlIIIlIIlIIIlllI);
        int lllllllllllllIllIlIIIlIIlIIIlIIl = 0;
        while (lllllllllllllIllIlIIIlIIlIIIlIIl < lllllllllllllIllIlIIIlIIlIIIlIll) {
            lllllllllllllIllIlIIIlIIlIIIlIlI.nextInt();
            lllllllllllllIllIlIIIlIIlIIIlIlI.set(lllllllllllllIllIlIIIlIIlIIIllIl[lllllllllllllIllIlIIIlIIlIIIIlIl + lllllllllllllIllIlIIIlIIlIIIlIIl++]);
        }
    }
    
    boolean addAll(final IntList p0);
    
    int set(final int p0, final int p1);
    
    void add(final int p0, final int p1);
    
    void addElements(final int p0, final int[] p1);
    
    boolean addAll(final int p0, final IntCollection p1);
}
