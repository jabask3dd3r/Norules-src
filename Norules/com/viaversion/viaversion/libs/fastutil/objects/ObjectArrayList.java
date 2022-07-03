package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;

public class ObjectArrayList<K> extends AbstractObjectList<K> implements RandomAccess, Cloneable, Serializable
{
    protected final /* synthetic */ boolean wrapped;
    protected transient /* synthetic */ K[] a;
    protected /* synthetic */ int size;
    
    @Override
    public boolean removeAll(final Collection<?> llllllllllllllIIIIIIIIlIlIlIIIII) {
        final Object[] llllllllllllllIIIIIIIIlIlIlIIlII = this.a;
        int llllllllllllllIIIIIIIIlIlIlIIIll = 0;
        for (int llllllllllllllIIIIIIIIlIlIlIIlll = 0; llllllllllllllIIIIIIIIlIlIlIIlll < this.size; ++llllllllllllllIIIIIIIIlIlIlIIlll) {
            if (!llllllllllllllIIIIIIIIlIlIlIIIII.contains(llllllllllllllIIIIIIIIlIlIlIIlII[llllllllllllllIIIIIIIIlIlIlIIlll])) {
                llllllllllllllIIIIIIIIlIlIlIIlII[llllllllllllllIIIIIIIIlIlIlIIIll++] = llllllllllllllIIIIIIIIlIlIlIIlII[llllllllllllllIIIIIIIIlIlIlIIlll];
            }
        }
        Arrays.fill(llllllllllllllIIIIIIIIlIlIlIIlII, llllllllllllllIIIIIIIIlIlIlIIIll, this.size, null);
        final boolean llllllllllllllIIIIIIIIlIlIlIIIlI = this.size != llllllllllllllIIIIIIIIlIlIlIIIll;
        this.size = llllllllllllllIIIIIIIIlIlIlIIIll;
        return llllllllllllllIIIIIIIIlIlIlIIIlI;
    }
    
    public ObjectArrayList<K> clone() {
        final ObjectArrayList<K> llllllllllllllIIIIIIIIlIlIIIIlll = new ObjectArrayList<K>(this.size);
        System.arraycopy(this.a, 0, llllllllllllllIIIIIIIIlIlIIIIlll.a, 0, this.size);
        llllllllllllllIIIIIIIIlIlIIIIlll.size = this.size;
        return llllllllllllllIIIIIIIIlIlIIIIlll;
    }
    
    @Override
    public int lastIndexOf(final Object llllllllllllllIIIIIIIIllIIlIIIlI) {
        int llllllllllllllIIIIIIIIllIIlIIlII = this.size;
        while (llllllllllllllIIIIIIIIllIIlIIlII-- != 0) {
            if (Objects.equals(llllllllllllllIIIIIIIIllIIlIIIlI, this.a[llllllllllllllIIIIIIIIllIIlIIlII])) {
                return llllllllllllllIIIIIIIIllIIlIIlII;
            }
        }
        return -1;
    }
    
    @Override
    public void setElements(final int llllllllllllllIIIIIIIIlIlIllIlIl, final K[] llllllllllllllIIIIIIIIlIlIllIlII, final int llllllllllllllIIIIIIIIlIlIlIlllI, final int llllllllllllllIIIIIIIIlIlIlIllIl) {
        this.ensureIndex(llllllllllllllIIIIIIIIlIlIllIlIl);
        ObjectArrays.ensureOffsetLength(llllllllllllllIIIIIIIIlIlIllIlII, llllllllllllllIIIIIIIIlIlIlIlllI, llllllllllllllIIIIIIIIlIlIlIllIl);
        if (llllllllllllllIIIIIIIIlIlIllIlIl + llllllllllllllIIIIIIIIlIlIlIllIl > this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(llllllllllllllIIIIIIIIlIlIllIlIl + llllllllllllllIIIIIIIIlIlIlIllIl).append(") is greater than list size (").append(this.size).append(")")));
        }
        System.arraycopy(llllllllllllllIIIIIIIIlIlIllIlII, llllllllllllllIIIIIIIIlIlIlIlllI, this.a, llllllllllllllIIIIIIIIlIlIllIlIl, llllllllllllllIIIIIIIIlIlIlIllIl);
    }
    
    @Override
    public void getElements(final int llllllllllllllIIIIIIIIlIllIlllll, final Object[] llllllllllllllIIIIIIIIlIllIllIIl, final int llllllllllllllIIIIIIIIlIllIlllIl, final int llllllllllllllIIIIIIIIlIllIlIlll) {
        ObjectArrays.ensureOffsetLength(llllllllllllllIIIIIIIIlIllIllIIl, llllllllllllllIIIIIIIIlIllIlllIl, llllllllllllllIIIIIIIIlIllIlIlll);
        System.arraycopy(this.a, llllllllllllllIIIIIIIIlIllIlllll, llllllllllllllIIIIIIIIlIllIllIIl, llllllllllllllIIIIIIIIlIllIlllIl, llllllllllllllIIIIIIIIlIllIlIlll);
    }
    
    public int compareTo(final ObjectArrayList<? extends K> llllllllllllllIIIIIIIIlIIlIllIIl) {
        final int llllllllllllllIIIIIIIIlIIlIlllll = this.size();
        final int llllllllllllllIIIIIIIIlIIlIllllI = llllllllllllllIIIIIIIIlIIlIllIIl.size();
        final K[] llllllllllllllIIIIIIIIlIIlIlllIl = this.a;
        final K[] llllllllllllllIIIIIIIIlIIlIlllII = (K[])llllllllllllllIIIIIIIIlIIlIllIIl.a;
        int llllllllllllllIIIIIIIIlIIlIllIll;
        for (llllllllllllllIIIIIIIIlIIlIllIll = 0; llllllllllllllIIIIIIIIlIIlIllIll < llllllllllllllIIIIIIIIlIIlIlllll && llllllllllllllIIIIIIIIlIIlIllIll < llllllllllllllIIIIIIIIlIIlIllllI; ++llllllllllllllIIIIIIIIlIIlIllIll) {
            final K llllllllllllllIIIIIIIIlIIllIIlII = llllllllllllllIIIIIIIIlIIlIlllIl[llllllllllllllIIIIIIIIlIIlIllIll];
            final K llllllllllllllIIIIIIIIlIIllIIIll = llllllllllllllIIIIIIIIlIIlIlllII[llllllllllllllIIIIIIIIlIIlIllIll];
            final int llllllllllllllIIIIIIIIlIIllIIIlI;
            if ((llllllllllllllIIIIIIIIlIIllIIIlI = ((Comparable)llllllllllllllIIIIIIIIlIIllIIlII).compareTo(llllllllllllllIIIIIIIIlIIllIIIll)) != 0) {
                return llllllllllllllIIIIIIIIlIIllIIIlI;
            }
        }
        return (llllllllllllllIIIIIIIIlIIlIllIll < llllllllllllllIIIIIIIIlIIlIllllI) ? -1 : ((llllllllllllllIIIIIIIIlIIlIllIll < llllllllllllllIIIIIIIIlIIlIlllll) ? 1 : 0);
    }
    
    public ObjectArrayList(final int llllllllllllllIIIIIIIIlllIIllIlI) {
        if (llllllllllllllIIIIIIIIlllIIllIlI < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Initial capacity (").append(llllllllllllllIIIIIIIIlllIIllIlI).append(") is negative")));
        }
        if (llllllllllllllIIIIIIIIlllIIllIlI == 0) {
            this.a = (K[])ObjectArrays.EMPTY_ARRAY;
        }
        else {
            this.a = (K[])new Object[llllllllllllllIIIIIIIIlllIIllIlI];
        }
        this.wrapped = false;
    }
    
    @Override
    public boolean remove(final Object llllllllllllllIIIIIIIIllIIIIlllI) {
        final int llllllllllllllIIIIIIIIllIIIlIIII = this.indexOf(llllllllllllllIIIIIIIIllIIIIlllI);
        if (llllllllllllllIIIIIIIIllIIIlIIII == -1) {
            return false;
        }
        this.remove(llllllllllllllIIIIIIIIllIIIlIIII);
        assert this.size <= this.a.length;
        return true;
    }
    
    public void trim() {
        this.trim(0);
    }
    
    private void writeObject(final ObjectOutputStream llllllllllllllIIIIIIIIlIIlIIlIIl) throws IOException {
        llllllllllllllIIIIIIIIlIIlIIlIIl.defaultWriteObject();
        for (int llllllllllllllIIIIIIIIlIIlIIllIl = 0; llllllllllllllIIIIIIIIlIIlIIllIl < this.size; ++llllllllllllllIIIIIIIIlIIlIIllIl) {
            llllllllllllllIIIIIIIIlIIlIIlIIl.writeObject(this.a[llllllllllllllIIIIIIIIlIIlIIllIl]);
        }
    }
    
    @Override
    public K get(final int llllllllllllllIIIIIIIIllIIllIIll) {
        if (llllllllllllllIIIIIIIIllIIllIIll >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(llllllllllllllIIIIIIIIllIIllIIll).append(") is greater than or equal to list size (").append(this.size).append(")")));
        }
        return this.a[llllllllllllllIIIIIIIIllIIllIIll];
    }
    
    private void grow(int llllllllllllllIIIIIIIIllIlIIIlll) {
        if (llllllllllllllIIIIIIIIllIlIIIlll <= this.a.length) {
            return;
        }
        if (this.a != ObjectArrays.DEFAULT_EMPTY_ARRAY) {
            llllllllllllllIIIIIIIIllIlIIIlll = (int)Math.max(Math.min(this.a.length + (long)(this.a.length >> 1), 2147483639L), llllllllllllllIIIIIIIIllIlIIIlll);
        }
        else if (llllllllllllllIIIIIIIIllIlIIIlll < 10) {
            llllllllllllllIIIIIIIIllIlIIIlll = 10;
        }
        if (this.wrapped) {
            this.a = ObjectArrays.forceCapacity(this.a, llllllllllllllIIIIIIIIllIlIIIlll, this.size);
        }
        else {
            final Object[] llllllllllllllIIIIIIIIllIlIIlIll = new Object[llllllllllllllIIIIIIIIllIlIIIlll];
            System.arraycopy(this.a, 0, llllllllllllllIIIIIIIIllIlIIlIll, 0, this.size);
            this.a = (K[])llllllllllllllIIIIIIIIllIlIIlIll;
        }
        assert this.size <= this.a.length;
    }
    
    @Override
    public void add(final int llllllllllllllIIIIIIIIllIlIIIIIl, final K llllllllllllllIIIIIIIIllIlIIIIII) {
        this.ensureIndex(llllllllllllllIIIIIIIIllIlIIIIIl);
        this.grow(this.size + 1);
        if (llllllllllllllIIIIIIIIllIlIIIIIl != this.size) {
            System.arraycopy(this.a, llllllllllllllIIIIIIIIllIlIIIIIl, this.a, llllllllllllllIIIIIIIIllIlIIIIIl + 1, this.size - llllllllllllllIIIIIIIIllIlIIIIIl);
        }
        this.a[llllllllllllllIIIIIIIIllIlIIIIIl] = llllllllllllllIIIIIIIIllIlIIIIII;
        ++this.size;
        assert this.size <= this.a.length;
    }
    
    @Override
    public void addElements(final int llllllllllllllIIIIIIIIlIllIIIlII, final K[] llllllllllllllIIIIIIIIlIlIlllllI, final int llllllllllllllIIIIIIIIlIllIIIIlI, final int llllllllllllllIIIIIIIIlIllIIIIIl) {
        this.ensureIndex(llllllllllllllIIIIIIIIlIllIIIlII);
        ObjectArrays.ensureOffsetLength(llllllllllllllIIIIIIIIlIlIlllllI, llllllllllllllIIIIIIIIlIllIIIIlI, llllllllllllllIIIIIIIIlIllIIIIIl);
        this.grow(this.size + llllllllllllllIIIIIIIIlIllIIIIIl);
        System.arraycopy(this.a, llllllllllllllIIIIIIIIlIllIIIlII, this.a, llllllllllllllIIIIIIIIlIllIIIlII + llllllllllllllIIIIIIIIlIllIIIIIl, this.size - llllllllllllllIIIIIIIIlIllIIIlII);
        System.arraycopy(llllllllllllllIIIIIIIIlIlIlllllI, llllllllllllllIIIIIIIIlIllIIIIlI, this.a, llllllllllllllIIIIIIIIlIllIIIlII, llllllllllllllIIIIIIIIlIllIIIIIl);
        this.size += llllllllllllllIIIIIIIIlIllIIIIIl;
    }
    
    public ObjectArrayList(final Iterator<? extends K> llllllllllllllIIIIIIIIllIllIllll) {
        this();
        while (llllllllllllllIIIIIIIIllIllIllll.hasNext()) {
            this.add(llllllllllllllIIIIIIIIllIllIllll.next());
        }
    }
    
    @Override
    public ObjectListIterator<K> listIterator(final int llllllllllllllIIIIIIIIlIlIIllIIl) {
        this.ensureIndex(llllllllllllllIIIIIIIIlIlIIllIIl);
        return new ObjectListIterator<K>() {
            /* synthetic */ int last = -1;
            /* synthetic */ int pos = llllllllllllllIIIIIIIIlIlIIllIIl;
            
            @Override
            public int nextIndex() {
                return this.pos;
            }
            
            @Override
            public boolean hasNext() {
                return this.pos < ObjectArrayList.this.size;
            }
            
            @Override
            public int previousIndex() {
                return this.pos - 1;
            }
            
            @Override
            public K previous() {
                if (!this.hasPrevious()) {
                    throw new NoSuchElementException();
                }
                final K[] a = ObjectArrayList.this.a;
                final int n = this.pos - 1;
                this.pos = n;
                this.last = n;
                return a[n];
            }
            
            @Override
            public void add(final K llllllllllllllllllllllIlIIIIlllI) {
                ObjectArrayList.this.add(this.pos++, llllllllllllllllllllllIlIIIIlllI);
                this.last = -1;
            }
            
            @Override
            public void set(final K llllllllllllllllllllllIlIIIIlIlI) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ObjectArrayList.this.set(this.last, llllllllllllllllllllllIlIIIIlIlI);
            }
            
            @Override
            public boolean hasPrevious() {
                return this.pos > 0;
            }
            
            @Override
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                ObjectArrayList.this.remove(this.last);
                if (this.last < this.pos) {
                    --this.pos;
                }
                this.last = -1;
            }
            
            @Override
            public K next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                final K[] a = ObjectArrayList.this.a;
                final int last = this.pos++;
                this.last = last;
                return a[last];
            }
        };
    }
    
    private void readObject(final ObjectInputStream llllllllllllllIIIIIIIIlIIlIIIIlI) throws IOException, ClassNotFoundException {
        llllllllllllllIIIIIIIIlIIlIIIIlI.defaultReadObject();
        this.a = (K[])new Object[this.size];
        for (int llllllllllllllIIIIIIIIlIIlIIIlII = 0; llllllllllllllIIIIIIIIlIIlIIIlII < this.size; ++llllllllllllllIIIIIIIIlIIlIIIlII) {
            this.a[llllllllllllllIIIIIIIIlIIlIIIlII] = (K)llllllllllllllIIIIIIIIlIIlIIIIlI.readObject();
        }
    }
    
    @Override
    public void sort(final Comparator<? super K> llllllllllllllIIIIIIIIlIlIIlIIIl) {
        if (llllllllllllllIIIIIIIIlIlIIlIIIl == null) {
            ObjectArrays.stableSort(this.a, 0, this.size);
        }
        else {
            ObjectArrays.stableSort(this.a, 0, this.size, (Comparator<K>)llllllllllllllIIIIIIIIlIlIIlIIIl);
        }
    }
    
    @Override
    public K set(final int llllllllllllllIIIIIIIIllIIIIIIll, final K llllllllllllllIIIIIIIIllIIIIIIlI) {
        if (llllllllllllllIIIIIIIIllIIIIIIll >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(llllllllllllllIIIIIIIIllIIIIIIll).append(") is greater than or equal to list size (").append(this.size).append(")")));
        }
        final K llllllllllllllIIIIIIIIllIIIIIlIl = this.a[llllllllllllllIIIIIIIIllIIIIIIll];
        this.a[llllllllllllllIIIIIIIIllIIIIIIll] = llllllllllllllIIIIIIIIllIIIIIIlI;
        return llllllllllllllIIIIIIIIllIIIIIlIl;
    }
    
    private boolean valEquals(final K llllllllllllllIIIIIIIIlIIlllllll, final K llllllllllllllIIIIIIIIlIlIIIIIII) {
        return (llllllllllllllIIIIIIIIlIIlllllll == null) ? (llllllllllllllIIIIIIIIlIlIIIIIII == null) : llllllllllllllIIIIIIIIlIIlllllll.equals(llllllllllllllIIIIIIIIlIlIIIIIII);
    }
    
    public ObjectArrayList(final K[] llllllllllllllIIIIIIIIllIlllllll) {
        this(llllllllllllllIIIIIIIIllIlllllll, 0, llllllllllllllIIIIIIIIllIlllllll.length);
    }
    
    @Override
    public K remove(final int llllllllllllllIIIIIIIIllIIIlIlll) {
        if (llllllllllllllIIIIIIIIllIIIlIlll >= this.size) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(llllllllllllllIIIIIIIIllIIIlIlll).append(") is greater than or equal to list size (").append(this.size).append(")")));
        }
        final K llllllllllllllIIIIIIIIllIIIllIIl = this.a[llllllllllllllIIIIIIIIllIIIlIlll];
        --this.size;
        if (llllllllllllllIIIIIIIIllIIIlIlll != this.size) {
            System.arraycopy(this.a, llllllllllllllIIIIIIIIllIIIlIlll + 1, this.a, llllllllllllllIIIIIIIIllIIIlIlll, this.size - llllllllllllllIIIIIIIIllIIIlIlll);
        }
        this.a[this.size] = null;
        assert this.size <= this.a.length;
        return llllllllllllllIIIIIIIIllIIIllIIl;
    }
    
    @Override
    public void clear() {
        Arrays.fill(this.a, 0, this.size, null);
        this.size = 0;
        assert this.size <= this.a.length;
    }
    
    @Override
    public void removeElements(final int llllllllllllllIIIIIIIIlIllIIllIl, final int llllllllllllllIIIIIIIIlIllIlIIII) {
        com.viaversion.viaversion.libs.fastutil.Arrays.ensureFromTo(this.size, llllllllllllllIIIIIIIIlIllIIllIl, llllllllllllllIIIIIIIIlIllIlIIII);
        System.arraycopy(this.a, llllllllllllllIIIIIIIIlIllIlIIII, this.a, llllllllllllllIIIIIIIIlIllIIllIl, this.size - llllllllllllllIIIIIIIIlIllIlIIII);
        this.size -= llllllllllllllIIIIIIIIlIllIlIIII - llllllllllllllIIIIIIIIlIllIIllIl;
        int llllllllllllllIIIIIIIIlIllIIllll = llllllllllllllIIIIIIIIlIllIlIIII - llllllllllllllIIIIIIIIlIllIIllIl;
        while (llllllllllllllIIIIIIIIlIllIIllll-- != 0) {
            this.a[this.size + llllllllllllllIIIIIIIIlIllIIllll] = null;
        }
    }
    
    @Override
    public boolean add(final K llllllllllllllIIIIIIIIllIIlllIIl) {
        this.grow(this.size + 1);
        this.a[this.size++] = llllllllllllllIIIIIIIIllIIlllIIl;
        assert this.size <= this.a.length;
        return true;
    }
    
    public K[] elements() {
        return this.a;
    }
    
    @Override
    public void size(final int llllllllllllllIIIIIIIIlIllllIlll) {
        if (llllllllllllllIIIIIIIIlIllllIlll > this.a.length) {
            this.a = ObjectArrays.forceCapacity(this.a, llllllllllllllIIIIIIIIlIllllIlll, this.size);
        }
        if (llllllllllllllIIIIIIIIlIllllIlll > this.size) {
            Arrays.fill(this.a, this.size, llllllllllllllIIIIIIIIlIllllIlll, null);
        }
        else {
            Arrays.fill(this.a, llllllllllllllIIIIIIIIlIllllIlll, this.size, null);
        }
        this.size = llllllllllllllIIIIIIIIlIllllIlll;
    }
    
    public ObjectArrayList(final ObjectList<? extends K> llllllllllllllIIIIIIIIlllIIIIlll) {
        this(llllllllllllllIIIIIIIIlllIIIIlll.size());
        final int n = 0;
        final K[] a = this.a;
        final int n2 = 0;
        final int size = llllllllllllllIIIIIIIIlllIIIIlll.size();
        this.size = size;
        llllllllllllllIIIIIIIIlllIIIIlll.getElements(n, a, n2, size);
    }
    
    @Override
    public void unstableSort(final Comparator<? super K> llllllllllllllIIIIIIIIlIlIIIlIll) {
        if (llllllllllllllIIIIIIIIlIlIIIlIll == null) {
            ObjectArrays.unstableSort(this.a, 0, this.size);
        }
        else {
            ObjectArrays.unstableSort(this.a, 0, this.size, (Comparator<K>)llllllllllllllIIIIIIIIlIlIIIlIll);
        }
    }
    
    public ObjectArrayList(final ObjectCollection<? extends K> llllllllllllllIIIIIIIIlllIIIllIl) {
        this(llllllllllllllIIIIIIIIlllIIIllIl.size());
        this.size = ObjectIterators.unwrap(llllllllllllllIIIIIIIIlllIIIllIl.iterator(), this.a);
    }
    
    public void ensureCapacity(final int llllllllllllllIIIIIIIIllIlIlIIlI) {
        if (llllllllllllllIIIIIIIIllIlIlIIlI <= this.a.length || (this.a == ObjectArrays.DEFAULT_EMPTY_ARRAY && llllllllllllllIIIIIIIIllIlIlIIlI <= 10)) {
            return;
        }
        if (this.wrapped) {
            this.a = ObjectArrays.ensureCapacity(this.a, llllllllllllllIIIIIIIIllIlIlIIlI, this.size);
        }
        else if (llllllllllllllIIIIIIIIllIlIlIIlI > this.a.length) {
            final Object[] llllllllllllllIIIIIIIIllIlIlIlII = new Object[llllllllllllllIIIIIIIIllIlIlIIlI];
            System.arraycopy(this.a, 0, llllllllllllllIIIIIIIIllIlIlIlII, 0, this.size);
            this.a = (K[])llllllllllllllIIIIIIIIllIlIlIlII;
        }
        assert this.size <= this.a.length;
    }
    
    public void trim(final int llllllllllllllIIIIIIIIlIlllIIlll) {
        if (llllllllllllllIIIIIIIIlIlllIIlll >= this.a.length || this.size == this.a.length) {
            return;
        }
        final K[] llllllllllllllIIIIIIIIlIlllIlIIl = (K[])new Object[Math.max(llllllllllllllIIIIIIIIlIlllIIlll, this.size)];
        System.arraycopy(this.a, 0, llllllllllllllIIIIIIIIlIlllIlIIl, 0, this.size);
        this.a = llllllllllllllIIIIIIIIlIlllIlIIl;
        assert this.size <= this.a.length;
    }
    
    public static <K> ObjectArrayList<K> wrap(final K[] llllllllllllllIIIIIIIIllIlIllIII) {
        return wrap(llllllllllllllIIIIIIIIllIlIllIII, llllllllllllllIIIIIIIIllIlIllIII.length);
    }
    
    public boolean equals(final ObjectArrayList<K> llllllllllllllIIIIIIIIlIIlllIIlI) {
        if (llllllllllllllIIIIIIIIlIIlllIIlI == this) {
            return true;
        }
        int llllllllllllllIIIIIIIIlIIlllIllI = this.size();
        if (llllllllllllllIIIIIIIIlIIlllIllI != llllllllllllllIIIIIIIIlIIlllIIlI.size()) {
            return false;
        }
        final K[] llllllllllllllIIIIIIIIlIIlllIlIl = this.a;
        final K[] llllllllllllllIIIIIIIIlIIlllIlII = llllllllllllllIIIIIIIIlIIlllIIlI.a;
        while (llllllllllllllIIIIIIIIlIIlllIllI-- != 0) {
            if (!this.valEquals(llllllllllllllIIIIIIIIlIIlllIlIl[llllllllllllllIIIIIIIIlIIlllIllI], llllllllllllllIIIIIIIIlIIlllIlII[llllllllllllllIIIIIIIIlIIlllIllI])) {
                return false;
            }
        }
        return true;
    }
    
    public ObjectArrayList(final Collection<? extends K> llllllllllllllIIIIIIIIlllIIlIIIl) {
        this(llllllllllllllIIIIIIIIlllIIlIIIl.size());
        this.size = ObjectIterators.unwrap(llllllllllllllIIIIIIIIlllIIlIIIl.iterator(), this.a);
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public int indexOf(final Object llllllllllllllIIIIIIIIllIIlIlIll) {
        for (int llllllllllllllIIIIIIIIllIIlIllIl = 0; llllllllllllllIIIIIIIIllIIlIllIl < this.size; ++llllllllllllllIIIIIIIIllIIlIllIl) {
            if (Objects.equals(llllllllllllllIIIIIIIIllIIlIlIll, this.a[llllllllllllllIIIIIIIIllIIlIllIl])) {
                return llllllllllllllIIIIIIIIllIIlIllIl;
            }
        }
        return -1;
    }
    
    public ObjectArrayList(final K[] llllllllllllllIIIIIIIIllIllllIIl, final int llllllllllllllIIIIIIIIllIllllIII, final int llllllllllllllIIIIIIIIllIlllIIll) {
        this(llllllllllllllIIIIIIIIllIlllIIll);
        System.arraycopy(llllllllllllllIIIIIIIIllIllllIIl, llllllllllllllIIIIIIIIllIllllIII, this.a, 0, llllllllllllllIIIIIIIIllIlllIIll);
        this.size = llllllllllllllIIIIIIIIllIlllIIll;
    }
    
    public ObjectArrayList(final ObjectIterator<? extends K> llllllllllllllIIIIIIIIllIllIIlll) {
        this();
        while (llllllllllllllIIIIIIIIllIllIIlll.hasNext()) {
            this.add(llllllllllllllIIIIIIIIllIllIIlll.next());
        }
    }
    
    static {
        DEFAULT_INITIAL_CAPACITY = 10;
    }
    
    public ObjectArrayList() {
        this.a = (K[])ObjectArrays.DEFAULT_EMPTY_ARRAY;
        this.wrapped = false;
    }
    
    public static <K> ObjectArrayList<K> wrap(final K[] llllllllllllllIIIIIIIIllIllIIIII, final int llllllllllllllIIIIIIIIllIlIlllll) {
        if (llllllllllllllIIIIIIIIllIlIlllll > llllllllllllllIIIIIIIIllIllIIIII.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The specified length (").append(llllllllllllllIIIIIIIIllIlIlllll).append(") is greater than the array size (").append(llllllllllllllIIIIIIIIllIllIIIII.length).append(")")));
        }
        final ObjectArrayList<K> llllllllllllllIIIIIIIIllIlIllllI = new ObjectArrayList<K>(llllllllllllllIIIIIIIIllIllIIIII, false);
        llllllllllllllIIIIIIIIllIlIllllI.size = llllllllllllllIIIIIIIIllIlIlllll;
        return llllllllllllllIIIIIIIIllIlIllllI;
    }
    
    protected ObjectArrayList(final K[] llllllllllllllIIIIIIIIlllIlIIIll, final boolean llllllllllllllIIIIIIIIlllIlIIIlI) {
        this.a = llllllllllllllIIIIIIIIlllIlIIIll;
        this.wrapped = true;
    }
}
