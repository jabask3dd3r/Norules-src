package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;
import com.viaversion.viaversion.libs.fastutil.*;
import java.util.*;

public class IntArrayList extends AbstractIntList implements Cloneable, RandomAccess, Serializable
{
    protected transient /* synthetic */ int[] a;
    protected /* synthetic */ int size;
    
    public int compareTo(final IntArrayList lllllllllllllIIIlIIlllIllIIlIlII) {
        final int lllllllllllllIIIlIIlllIllIIllIlI = this.size();
        final int lllllllllllllIIIlIIlllIllIIllIIl = lllllllllllllIIIlIIlllIllIIlIlII.size();
        final int[] lllllllllllllIIIlIIlllIllIIllIII = this.a;
        final int[] lllllllllllllIIIlIIlllIllIIlIlll = lllllllllllllIIIlIIlllIllIIlIlII.a;
        int lllllllllllllIIIlIIlllIllIIlIllI;
        for (lllllllllllllIIIlIIlllIllIIlIllI = 0; lllllllllllllIIIlIIlllIllIIlIllI < lllllllllllllIIIlIIlllIllIIllIlI && lllllllllllllIIIlIIlllIllIIlIllI < lllllllllllllIIIlIIlllIllIIllIIl; ++lllllllllllllIIIlIIlllIllIIlIllI) {
            final int lllllllllllllIIIlIIlllIllIIlllll = lllllllllllllIIIlIIlllIllIIllIII[lllllllllllllIIIlIIlllIllIIlIllI];
            final int lllllllllllllIIIlIIlllIllIIllllI = lllllllllllllIIIlIIlllIllIIlIlll[lllllllllllllIIIlIIlllIllIIlIllI];
            final int lllllllllllllIIIlIIlllIllIIlllIl;
            if ((lllllllllllllIIIlIIlllIllIIlllIl = Integer.compare(lllllllllllllIIIlIIlllIllIIlllll, lllllllllllllIIIlIIlllIllIIllllI)) != 0) {
                return lllllllllllllIIIlIIlllIllIIlllIl;
            }
        }
        return (lllllllllllllIIIlIIlllIllIIlIllI < lllllllllllllIIIlIIlllIllIIllIIl) ? -1 : ((lllllllllllllIIIlIIlllIllIIlIllI < lllllllllllllIIIlIIlllIllIIllIlI) ? 1 : 0);
    }
    
    @Override
    public void clear() {
        this.size = 0;
        assert this.size <= this.a.length;
    }
    
    public IntArrayList(final int[] lllllllllllllIIIlIIllllIlllIIIll) {
        this(lllllllllllllIIIlIIllllIlllIIIll, 0, lllllllllllllIIIlIIllllIlllIIIll.length);
    }
    
    public static IntArrayList wrap(final int[] lllllllllllllIIIlIIllllIlIllllII, final int lllllllllllllIIIlIIllllIlIlllIII) {
        if (lllllllllllllIIIlIIllllIlIlllIII > lllllllllllllIIIlIIllllIlIllllII.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The specified length (").append(lllllllllllllIIIlIIllllIlIlllIII).append(") is greater than the array size (").append(lllllllllllllIIIlIIllllIlIllllII.length).append(")")));
        }
        final IntArrayList lllllllllllllIIIlIIllllIlIlllIlI = new IntArrayList(lllllllllllllIIIlIIllllIlIllllII, false);
        lllllllllllllIIIlIIllllIlIlllIlI.size = lllllllllllllIIIlIIllllIlIlllIII;
        return lllllllllllllIIIlIIllllIlIlllIlI;
    }
    
    public IntArrayList(final IntList lllllllllllllIIIlIIllllIlllIIlll) {
        this(lllllllllllllIIIlIIllllIlllIIlll.size());
        final int n = 0;
        final int[] a = this.a;
        final int n2 = 0;
        final int size = lllllllllllllIIIlIIllllIlllIIlll.size();
        this.size = size;
        lllllllllllllIIIlIIllllIlllIIlll.getElements(n, a, n2, size);
    }
    
    @Override
    public boolean add(final int lllllllllllllIIIlIIllllIlIIllIIl) {
        this.grow(this.size + 1);
        this.a[this.size++] = lllllllllllllIIIlIIllllIlIIllIIl;
        assert this.size <= this.a.length;
        return true;
    }
    
    @Override
    public void getElements(final int lllllllllllllIIIlIIllllIIIllllII, final int[] lllllllllllllIIIlIIllllIIIlllIll, final int lllllllllllllIIIlIIllllIIIlllIlI, final int lllllllllllllIIIlIIllllIIIlllllI) {
        IntArrays.ensureOffsetLength(lllllllllllllIIIlIIllllIIIlllIll, lllllllllllllIIIlIIllllIIIlllIlI, lllllllllllllIIIlIIllllIIIlllllI);
        System.arraycopy(this.a, lllllllllllllIIIlIIllllIIIllllII, lllllllllllllIIIlIIllllIIIlllIll, lllllllllllllIIIlIIllllIIIlllIlI, lllllllllllllIIIlIIllllIIIlllllI);
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllIIIlIIlllIllIIIIlII) throws IOException {
        lllllllllllllIIIlIIlllIllIIIIlII.defaultWriteObject();
        for (int lllllllllllllIIIlIIlllIllIIIlIII = 0; lllllllllllllIIIlIIlllIllIIIlIII < this.size; ++lllllllllllllIIIlIIlllIllIIIlIII) {
            lllllllllllllIIIlIIlllIllIIIIlII.writeInt(this.a[lllllllllllllIIIlIIlllIllIIIlIII]);
        }
    }
    
    public void trim() {
        this.trim(0);
    }
    
    public IntArrayList(final IntIterator lllllllllllllIIIlIIllllIllIIIlll) {
        this();
        while (lllllllllllllIIIlIIllllIllIIIlll.hasNext()) {
            this.add(lllllllllllllIIIlIIllllIllIIIlll.nextInt());
        }
    }
    
    @Override
    public int set(final int lllllllllllllIIIlIIllllIIllIlIIl, final int lllllllllllllIIIlIIllllIIllIlIII) {
        if (lllllllllllllIIIlIIllllIIllIlIIl >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(lllllllllllllIIIlIIllllIIllIlIIl).append(") is greater than or equal to list size (").append(this.size).append(")")));
        }
        final int lllllllllllllIIIlIIllllIIllIIlll = this.a[lllllllllllllIIIlIIllllIIllIlIIl];
        this.a[lllllllllllllIIIlIIllllIIllIlIIl] = lllllllllllllIIIlIIllllIIllIlIII;
        return lllllllllllllIIIlIIllllIIllIIlll;
    }
    
    private void grow(int lllllllllllllIIIlIIllllIlIlIlIII) {
        if (lllllllllllllIIIlIIllllIlIlIlIII <= this.a.length) {
            return;
        }
        if (this.a != IntArrays.DEFAULT_EMPTY_ARRAY) {
            lllllllllllllIIIlIIllllIlIlIlIII = (int)Math.max(Math.min(this.a.length + (long)(this.a.length >> 1), 2147483639L), lllllllllllllIIIlIIllllIlIlIlIII);
        }
        else if (lllllllllllllIIIlIIllllIlIlIlIII < 10) {
            lllllllllllllIIIlIIllllIlIlIlIII = 10;
        }
        this.a = IntArrays.forceCapacity(this.a, lllllllllllllIIIlIIllllIlIlIlIII, this.size);
        assert this.size <= this.a.length;
    }
    
    protected IntArrayList(final int[] lllllllllllllIIIlIIlllllIIIIIlIl, final boolean lllllllllllllIIIlIIlllllIIIIIlII) {
        this.a = lllllllllllllIIIlIIlllllIIIIIlIl;
    }
    
    private void readObject(final ObjectInputStream lllllllllllllIIIlIIlllIlIlllllIl) throws IOException, ClassNotFoundException {
        lllllllllllllIIIlIIlllIlIlllllIl.defaultReadObject();
        this.a = new int[this.size];
        for (int lllllllllllllIIIlIIlllIlIlllllll = 0; lllllllllllllIIIlIIlllIlIlllllll < this.size; ++lllllllllllllIIIlIIlllIlIlllllll) {
            this.a[lllllllllllllIIIlIIlllIlIlllllll] = lllllllllllllIIIlIIlllIlIlllllIl.readInt();
        }
    }
    
    public static IntArrayList wrap(final int[] lllllllllllllIIIlIIllllIlIllIlIl) {
        return wrap(lllllllllllllIIIlIIllllIlIllIlIl, lllllllllllllIIIlIIllllIlIllIlIl.length);
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public IntArrayList(final int lllllllllllllIIIlIIllllIllllllII) {
        if (lllllllllllllIIIlIIllllIllllllII < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Initial capacity (").append(lllllllllllllIIIlIIllllIllllllII).append(") is negative")));
        }
        if (lllllllllllllIIIlIIllllIllllllII == 0) {
            this.a = IntArrays.EMPTY_ARRAY;
        }
        else {
            this.a = new int[lllllllllllllIIIlIIllllIllllllII];
        }
    }
    
    public IntArrayList() {
        this.a = IntArrays.DEFAULT_EMPTY_ARRAY;
    }
    
    @Override
    public void addElements(final int lllllllllllllIIIlIIllllIIIlIIlII, final int[] lllllllllllllIIIlIIllllIIIlIIIll, final int lllllllllllllIIIlIIllllIIIlIIlll, final int lllllllllllllIIIlIIllllIIIlIIIIl) {
        this.ensureIndex(lllllllllllllIIIlIIllllIIIlIIlII);
        IntArrays.ensureOffsetLength(lllllllllllllIIIlIIllllIIIlIIIll, lllllllllllllIIIlIIllllIIIlIIlll, lllllllllllllIIIlIIllllIIIlIIIIl);
        this.grow(this.size + lllllllllllllIIIlIIllllIIIlIIIIl);
        System.arraycopy(this.a, lllllllllllllIIIlIIllllIIIlIIlII, this.a, lllllllllllllIIIlIIllllIIIlIIlII + lllllllllllllIIIlIIllllIIIlIIIIl, this.size - lllllllllllllIIIlIIllllIIIlIIlII);
        System.arraycopy(lllllllllllllIIIlIIllllIIIlIIIll, lllllllllllllIIIlIIllllIIIlIIlll, this.a, lllllllllllllIIIlIIllllIIIlIIlII, lllllllllllllIIIlIIllllIIIlIIIIl);
        this.size += lllllllllllllIIIlIIllllIIIlIIIIl;
    }
    
    @Override
    public boolean removeAll(final IntCollection lllllllllllllIIIlIIlllIllllIlIIl) {
        final int[] lllllllllllllIIIlIIlllIllllIlIII = this.a;
        int lllllllllllllIIIlIIlllIllllIIlll = 0;
        for (int lllllllllllllIIIlIIlllIllllIlIll = 0; lllllllllllllIIIlIIlllIllllIlIll < this.size; ++lllllllllllllIIIlIIlllIllllIlIll) {
            if (!lllllllllllllIIIlIIlllIllllIlIIl.contains(lllllllllllllIIIlIIlllIllllIlIII[lllllllllllllIIIlIIlllIllllIlIll])) {
                lllllllllllllIIIlIIlllIllllIlIII[lllllllllllllIIIlIIlllIllllIIlll++] = lllllllllllllIIIlIIlllIllllIlIII[lllllllllllllIIIlIIlllIllllIlIll];
            }
        }
        final boolean lllllllllllllIIIlIIlllIllllIIllI = this.size != lllllllllllllIIIlIIlllIllllIIlll;
        this.size = lllllllllllllIIIlIIlllIllllIIlll;
        return lllllllllllllIIIlIIlllIllllIIllI;
    }
    
    @Override
    public boolean addAll(final int lllllllllllllIIIlIIlllIlllllIIll, final IntList lllllllllllllIIIlIIlllIlllllIllI) {
        this.ensureIndex(lllllllllllllIIIlIIlllIlllllIIll);
        final int lllllllllllllIIIlIIlllIlllllIlIl = lllllllllllllIIIlIIlllIlllllIllI.size();
        if (lllllllllllllIIIlIIlllIlllllIlIl == 0) {
            return false;
        }
        this.grow(this.size + lllllllllllllIIIlIIlllIlllllIlIl);
        if (lllllllllllllIIIlIIlllIlllllIIll != this.size) {
            System.arraycopy(this.a, lllllllllllllIIIlIIlllIlllllIIll, this.a, lllllllllllllIIIlIIlllIlllllIIll + lllllllllllllIIIlIIlllIlllllIlIl, this.size - lllllllllllllIIIlIIlllIlllllIIll);
        }
        lllllllllllllIIIlIIlllIlllllIllI.getElements(0, this.a, lllllllllllllIIIlIIlllIlllllIIll, lllllllllllllIIIlIIlllIlllllIlIl);
        this.size += lllllllllllllIIIlIIlllIlllllIlIl;
        assert this.size <= this.a.length;
        return true;
    }
    
    public void trim(final int lllllllllllllIIIlIIllllIIlIIllII) {
        if (lllllllllllllIIIlIIllllIIlIIllII >= this.a.length || this.size == this.a.length) {
            return;
        }
        final int[] lllllllllllllIIIlIIllllIIlIIlIll = new int[Math.max(lllllllllllllIIIlIIllllIIlIIllII, this.size)];
        System.arraycopy(this.a, 0, lllllllllllllIIIlIIllllIIlIIlIll, 0, this.size);
        this.a = lllllllllllllIIIlIIllllIIlIIlIll;
        assert this.size <= this.a.length;
    }
    
    @Override
    public int[] toArray(int[] lllllllllllllIIIlIIllllIIIIIllII) {
        if (lllllllllllllIIIlIIllllIIIIIllII == null || lllllllllllllIIIlIIllllIIIIIllII.length < this.size) {
            lllllllllllllIIIlIIllllIIIIIllII = new int[this.size];
        }
        System.arraycopy(this.a, 0, lllllllllllllIIIlIIllllIIIIIllII, 0, this.size);
        return lllllllllllllIIIlIIllllIIIIIllII;
    }
    
    public IntArrayList(final Iterator<? extends Integer> lllllllllllllIIIlIIllllIllIIllll) {
        this();
        while (lllllllllllllIIIlIIllllIllIIllll.hasNext()) {
            this.add((int)lllllllllllllIIIlIIllllIllIIllll.next());
        }
    }
    
    @Override
    public int indexOf(final int lllllllllllllIIIlIIllllIlIIIllIl) {
        for (int lllllllllllllIIIlIIllllIlIIIllll = 0; lllllllllllllIIIlIIllllIlIIIllll < this.size; ++lllllllllllllIIIlIIllllIlIIIllll) {
            if (lllllllllllllIIIlIIllllIlIIIllIl == this.a[lllllllllllllIIIlIIllllIlIIIllll]) {
                return lllllllllllllIIIlIIllllIlIIIllll;
            }
        }
        return -1;
    }
    
    @Override
    public int removeInt(final int lllllllllllllIIIlIIllllIIlllllII) {
        if (lllllllllllllIIIlIIllllIIlllllII >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(lllllllllllllIIIlIIllllIIlllllII).append(") is greater than or equal to list size (").append(this.size).append(")")));
        }
        final int lllllllllllllIIIlIIllllIIllllIll = this.a[lllllllllllllIIIlIIllllIIlllllII];
        --this.size;
        if (lllllllllllllIIIlIIllllIIlllllII != this.size) {
            System.arraycopy(this.a, lllllllllllllIIIlIIllllIIlllllII + 1, this.a, lllllllllllllIIIlIIllllIIlllllII, this.size - lllllllllllllIIIlIIllllIIlllllII);
        }
        assert this.size <= this.a.length;
        return lllllllllllllIIIlIIllllIIllllIll;
    }
    
    @Override
    public void sort(final IntComparator lllllllllllllIIIlIIlllIlllIIIlll) {
        if (lllllllllllllIIIlIIlllIlllIIIlll == null) {
            IntArrays.stableSort(this.a, 0, this.size);
        }
        else {
            IntArrays.stableSort(this.a, 0, this.size, lllllllllllllIIIlIIlllIlllIIIlll);
        }
    }
    
    @Override
    public void removeElements(final int lllllllllllllIIIlIIllllIIIllIlII, final int lllllllllllllIIIlIIllllIIIllIIll) {
        Arrays.ensureFromTo(this.size, lllllllllllllIIIlIIllllIIIllIlII, lllllllllllllIIIlIIllllIIIllIIll);
        System.arraycopy(this.a, lllllllllllllIIIlIIllllIIIllIIll, this.a, lllllllllllllIIIlIIllllIIIllIlII, this.size - lllllllllllllIIIlIIllllIIIllIIll);
        this.size -= lllllllllllllIIIlIIllllIIIllIIll - lllllllllllllIIIlIIllllIIIllIlII;
    }
    
    @Override
    public boolean rem(final int lllllllllllllIIIlIIllllIIlllIIII) {
        final int lllllllllllllIIIlIIllllIIlllIIlI = this.indexOf(lllllllllllllIIIlIIllllIIlllIIII);
        if (lllllllllllllIIIlIIllllIIlllIIlI == -1) {
            return false;
        }
        this.removeInt(lllllllllllllIIIlIIllllIIlllIIlI);
        assert this.size <= this.a.length;
        return true;
    }
    
    @Override
    public int getInt(final int lllllllllllllIIIlIIllllIlIIlIIll) {
        if (lllllllllllllIIIlIIllllIlIIlIIll >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(lllllllllllllIIIlIIllllIlIIlIIll).append(") is greater than or equal to list size (").append(this.size).append(")")));
        }
        return this.a[lllllllllllllIIIlIIllllIlIIlIIll];
    }
    
    public IntArrayList clone() {
        final IntArrayList lllllllllllllIIIlIIlllIllIlllIll = new IntArrayList(this.size);
        System.arraycopy(this.a, 0, lllllllllllllIIIlIIlllIllIlllIll.a, 0, this.size);
        lllllllllllllIIIlIIlllIllIlllIll.size = this.size;
        return lllllllllllllIIIlIIlllIllIlllIll;
    }
    
    @Override
    public void size(final int lllllllllllllIIIlIIllllIIlIlIlll) {
        if (lllllllllllllIIIlIIllllIIlIlIlll > this.a.length) {
            this.a = IntArrays.forceCapacity(this.a, lllllllllllllIIIlIIllllIIlIlIlll, this.size);
        }
        if (lllllllllllllIIIlIIllllIIlIlIlll > this.size) {
            java.util.Arrays.fill(this.a, this.size, lllllllllllllIIIlIIllllIIlIlIlll, 0);
        }
        this.size = lllllllllllllIIIlIIllllIIlIlIlll;
    }
    
    public IntArrayList(final IntCollection lllllllllllllIIIlIIllllIlllIllIl) {
        this(lllllllllllllIIIlIIllllIlllIllIl.size());
        this.size = IntIterators.unwrap(lllllllllllllIIIlIIllllIlllIllIl.iterator(), this.a);
    }
    
    public int[] elements() {
        return this.a;
    }
    
    @Override
    public boolean removeAll(final Collection<?> lllllllllllllIIIlIIlllIlllIllIIl) {
        final int[] lllllllllllllIIIlIIlllIlllIllIII = this.a;
        int lllllllllllllIIIlIIlllIlllIlIlll = 0;
        for (int lllllllllllllIIIlIIlllIlllIllIll = 0; lllllllllllllIIIlIIlllIlllIllIll < this.size; ++lllllllllllllIIIlIIlllIlllIllIll) {
            if (!lllllllllllllIIIlIIlllIlllIllIIl.contains(lllllllllllllIIIlIIlllIlllIllIII[lllllllllllllIIIlIIlllIlllIllIll])) {
                lllllllllllllIIIlIIlllIlllIllIII[lllllllllllllIIIlIIlllIlllIlIlll++] = lllllllllllllIIIlIIlllIlllIllIII[lllllllllllllIIIlIIlllIlllIllIll];
            }
        }
        final boolean lllllllllllllIIIlIIlllIlllIlIllI = this.size != lllllllllllllIIIlIIlllIlllIlIlll;
        this.size = lllllllllllllIIIlIIlllIlllIlIlll;
        return lllllllllllllIIIlIIlllIlllIlIllI;
    }
    
    @Override
    public IntListIterator listIterator(final int lllllllllllllIIIlIIlllIlllIIllIl) {
        this.ensureIndex(lllllllllllllIIIlIIlllIlllIIllIl);
        return new IntListIterator() {
            /* synthetic */ int last = -1;
            /* synthetic */ int pos = lllllllllllllIIIlIIlllIlllIIllIl;
            
            @Override
            public boolean hasNext() {
                return this.pos < IntArrayList.this.size;
            }
            
            @Override
            public boolean hasPrevious() {
                return this.pos > 0;
            }
            
            @Override
            public int nextIndex() {
                return this.pos;
            }
            
            @Override
            public int previousIndex() {
                return this.pos - 1;
            }
            
            @Override
            public void add(final int llllllllllllIlllllIIIlIllIlllIIl) {
                IntArrayList.this.add(this.pos++, llllllllllllIlllllIIIlIllIlllIIl);
                this.last = -1;
            }
            
            @Override
            public int nextInt() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                final int[] a = IntArrayList.this.a;
                final int last = this.pos++;
                this.last = last;
                return a[last];
            }
            
            @Override
            public void set(final int llllllllllllIlllllIIIlIllIllIIll) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                IntArrayList.this.set(this.last, llllllllllllIlllllIIIlIllIllIIll);
            }
            
            @Override
            public int previousInt() {
                if (!this.hasPrevious()) {
                    throw new NoSuchElementException();
                }
                final int[] a = IntArrayList.this.a;
                final int n = this.pos - 1;
                this.pos = n;
                this.last = n;
                return a[n];
            }
            
            @Override
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                IntArrayList.this.removeInt(this.last);
                if (this.last < this.pos) {
                    --this.pos;
                }
                this.last = -1;
            }
        };
    }
    
    public IntArrayList(final Collection<? extends Integer> lllllllllllllIIIlIIllllIllllIlIl) {
        this(lllllllllllllIIIlIIllllIllllIlIl.size());
        this.size = IntIterators.unwrap(IntIterators.asIntIterator(lllllllllllllIIIlIIllllIllllIlIl.iterator()), this.a);
    }
    
    public void ensureCapacity(final int lllllllllllllIIIlIIllllIlIllIIII) {
        if (lllllllllllllIIIlIIllllIlIllIIII <= this.a.length || (this.a == IntArrays.DEFAULT_EMPTY_ARRAY && lllllllllllllIIIlIIllllIlIllIIII <= 10)) {
            return;
        }
        this.a = IntArrays.ensureCapacity(this.a, lllllllllllllIIIlIIllllIlIllIIII, this.size);
        assert this.size <= this.a.length;
    }
    
    @Override
    public void add(final int lllllllllllllIIIlIIllllIlIlIIIII, final int lllllllllllllIIIlIIllllIlIIlllll) {
        this.ensureIndex(lllllllllllllIIIlIIllllIlIlIIIII);
        this.grow(this.size + 1);
        if (lllllllllllllIIIlIIllllIlIlIIIII != this.size) {
            System.arraycopy(this.a, lllllllllllllIIIlIIllllIlIlIIIII, this.a, lllllllllllllIIIlIIllllIlIlIIIII + 1, this.size - lllllllllllllIIIlIIllllIlIlIIIII);
        }
        this.a[lllllllllllllIIIlIIllllIlIlIIIII] = lllllllllllllIIIlIIllllIlIIlllll;
        ++this.size;
        assert this.size <= this.a.length;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public void setElements(final int lllllllllllllIIIlIIllllIIIIlIlIl, final int[] lllllllllllllIIIlIIllllIIIIlIlII, final int lllllllllllllIIIlIIllllIIIIllIII, final int lllllllllllllIIIlIIllllIIIIlIIlI) {
        this.ensureIndex(lllllllllllllIIIlIIllllIIIIlIlIl);
        IntArrays.ensureOffsetLength(lllllllllllllIIIlIIllllIIIIlIlII, lllllllllllllIIIlIIllllIIIIllIII, lllllllllllllIIIlIIllllIIIIlIIlI);
        if (lllllllllllllIIIlIIllllIIIIlIlIl + lllllllllllllIIIlIIllllIIIIlIIlI > this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(lllllllllllllIIIlIIllllIIIIlIlIl + lllllllllllllIIIlIIllllIIIIlIIlI).append(") is greater than list size (").append(this.size).append(")")));
        }
        System.arraycopy(lllllllllllllIIIlIIllllIIIIlIlII, lllllllllllllIIIlIIllllIIIIllIII, this.a, lllllllllllllIIIlIIllllIIIIlIlIl, lllllllllllllIIIlIIllllIIIIlIIlI);
    }
    
    public IntArrayList(final int[] lllllllllllllIIIlIIllllIllIlIlll, final int lllllllllllllIIIlIIllllIllIlIllI, final int lllllllllllllIIIlIIllllIllIllIIl) {
        this(lllllllllllllIIIlIIllllIllIllIIl);
        System.arraycopy(lllllllllllllIIIlIIllllIllIlIlll, lllllllllllllIIIlIIllllIllIlIllI, this.a, 0, lllllllllllllIIIlIIllllIllIllIIl);
        this.size = lllllllllllllIIIlIIllllIllIllIIl;
    }
    
    static {
        DEFAULT_INITIAL_CAPACITY = 10;
    }
    
    @Override
    public boolean addAll(int lllllllllllllIIIlIIllllIIIIIIlIl, final IntCollection lllllllllllllIIIlIIllllIIIIIIlII) {
        this.ensureIndex(lllllllllllllIIIlIIllllIIIIIIlIl);
        int lllllllllllllIIIlIIllllIIIIIIIll = lllllllllllllIIIlIIllllIIIIIIlII.size();
        if (lllllllllllllIIIlIIllllIIIIIIIll == 0) {
            return false;
        }
        this.grow(this.size + lllllllllllllIIIlIIllllIIIIIIIll);
        if (lllllllllllllIIIlIIllllIIIIIIlIl != this.size) {
            System.arraycopy(this.a, lllllllllllllIIIlIIllllIIIIIIlIl, this.a, lllllllllllllIIIlIIllllIIIIIIlIl + lllllllllllllIIIlIIllllIIIIIIIll, this.size - lllllllllllllIIIlIIllllIIIIIIlIl);
        }
        final IntIterator lllllllllllllIIIlIIllllIIIIIIIlI = lllllllllllllIIIlIIllllIIIIIIlII.iterator();
        this.size += lllllllllllllIIIlIIllllIIIIIIIll;
        while (lllllllllllllIIIlIIllllIIIIIIIll-- != 0) {
            this.a[lllllllllllllIIIlIIllllIIIIIIlIl++] = lllllllllllllIIIlIIllllIIIIIIIlI.nextInt();
        }
        assert this.size <= this.a.length;
        return true;
    }
    
    @Override
    public int lastIndexOf(final int lllllllllllllIIIlIIllllIlIIIIIlI) {
        int lllllllllllllIIIlIIllllIlIIIIllI = this.size;
        while (lllllllllllllIIIlIIllllIlIIIIllI-- != 0) {
            if (lllllllllllllIIIlIIllllIlIIIIIlI == this.a[lllllllllllllIIIlIIllllIlIIIIllI]) {
                return lllllllllllllIIIlIIllllIlIIIIllI;
            }
        }
        return -1;
    }
    
    public boolean equals(final IntArrayList lllllllllllllIIIlIIlllIllIllIIlI) {
        if (lllllllllllllIIIlIIlllIllIllIIlI == this) {
            return true;
        }
        int lllllllllllllIIIlIIlllIllIllIIIl = this.size();
        if (lllllllllllllIIIlIIlllIllIllIIIl != lllllllllllllIIIlIIlllIllIllIIlI.size()) {
            return false;
        }
        final int[] lllllllllllllIIIlIIlllIllIllIIII = this.a;
        final int[] lllllllllllllIIIlIIlllIllIlIllll = lllllllllllllIIIlIIlllIllIllIIlI.a;
        while (lllllllllllllIIIlIIlllIllIllIIIl-- != 0) {
            if (lllllllllllllIIIlIIlllIllIllIIII[lllllllllllllIIIlIIlllIllIllIIIl] != lllllllllllllIIIlIIlllIllIlIllll[lllllllllllllIIIlIIlllIllIllIIIl]) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void unstableSort(final IntComparator lllllllllllllIIIlIIlllIlllIIIIIl) {
        if (lllllllllllllIIIlIIlllIlllIIIIIl == null) {
            IntArrays.unstableSort(this.a, 0, this.size);
        }
        else {
            IntArrays.unstableSort(this.a, 0, this.size, lllllllllllllIIIlIIlllIlllIIIIIl);
        }
    }
}
