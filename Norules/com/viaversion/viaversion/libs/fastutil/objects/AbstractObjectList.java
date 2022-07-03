package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;
import java.util.*;
import java.io.*;

public abstract class AbstractObjectList<K> extends AbstractObjectCollection<K> implements ObjectList<K>, Stack<K>
{
    @Override
    public void size(final int lllllllllllllllIIIlIlIlIIllIlIlI) {
        int lllllllllllllllIIIlIlIlIIllIlIIl = this.size();
        if (lllllllllllllllIIIlIlIlIIllIlIlI > lllllllllllllllIIIlIlIlIIllIlIIl) {
            while (lllllllllllllllIIIlIlIlIIllIlIIl++ < lllllllllllllllIIIlIlIlIIllIlIlI) {
                this.add(null);
            }
        }
        else {
            while (lllllllllllllllIIIlIlIlIIllIlIIl-- != lllllllllllllllIIIlIlIlIIllIlIlI) {
                this.remove(lllllllllllllllIIIlIlIlIIllIlIIl);
            }
        }
    }
    
    @Override
    public int lastIndexOf(final Object lllllllllllllllIIIlIlIlIIlllIlII) {
        final ObjectListIterator<K> lllllllllllllllIIIlIlIlIIlllIIll = this.listIterator(this.size());
        while (lllllllllllllllIIIlIlIlIIlllIIll.hasPrevious()) {
            final K lllllllllllllllIIIlIlIlIIlllIllI = lllllllllllllllIIIlIlIlIIlllIIll.previous();
            if (Objects.equals(lllllllllllllllIIIlIlIlIIlllIlII, lllllllllllllllIIIlIlIlIIlllIllI)) {
                return lllllllllllllllIIIlIlIlIIlllIIll.nextIndex();
            }
        }
        return -1;
    }
    
    @Override
    public boolean addAll(final Collection<? extends K> lllllllllllllllIIIlIlIlIlIIllIll) {
        return this.addAll(this.size(), lllllllllllllllIIIlIlIlIlIIllIll);
    }
    
    protected AbstractObjectList() {
    }
    
    @Override
    public int hashCode() {
        final ObjectIterator<K> lllllllllllllllIIIlIlIIllIlllIlI = this.iterator();
        int lllllllllllllllIIIlIlIIllIlllIIl = 1;
        int lllllllllllllllIIIlIlIIllIllIlll = this.size();
        while (lllllllllllllllIIIlIlIIllIllIlll-- != 0) {
            final K lllllllllllllllIIIlIlIIllIlllllI = lllllllllllllllIIIlIlIIllIlllIlI.next();
            lllllllllllllllIIIlIlIIllIlllIIl = 31 * lllllllllllllllIIIlIlIIllIlllIIl + ((lllllllllllllllIIIlIlIIllIlllllI == null) ? 0 : lllllllllllllllIIIlIlIIllIlllllI.hashCode());
        }
        return lllllllllllllllIIIlIlIIllIlllIIl;
    }
    
    @Override
    public ObjectListIterator<K> iterator() {
        return this.listIterator();
    }
    
    @Override
    public K top() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.get(this.size() - 1);
    }
    
    @Override
    public K remove(final int lllllllllllllllIIIlIlIlIlIllIIIl) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ObjectListIterator<K> listIterator() {
        return this.listIterator(0);
    }
    
    @Override
    public void clear() {
        this.removeElements(0, this.size());
    }
    
    @Override
    public ObjectList<K> subList(final int lllllllllllllllIIIlIlIlIIlIllllI, final int lllllllllllllllIIIlIlIlIIlIlllIl) {
        this.ensureIndex(lllllllllllllllIIIlIlIlIIlIllllI);
        this.ensureIndex(lllllllllllllllIIIlIlIlIIlIlllIl);
        if (lllllllllllllllIIIlIlIlIIlIllllI > lllllllllllllllIIIlIlIlIIlIlllIl) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Start index (").append(lllllllllllllllIIIlIlIlIIlIllllI).append(") is greater than end index (").append(lllllllllllllllIIIlIlIlIIlIlllIl).append(")")));
        }
        return new ObjectSubList<K>(this, lllllllllllllllIIIlIlIlIIlIllllI, lllllllllllllllIIIlIlIlIIlIlllIl);
    }
    
    @Override
    public K pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.remove(this.size() - 1);
    }
    
    @Override
    public boolean contains(final Object lllllllllllllllIIIlIlIlIlIIIIlll) {
        return this.indexOf(lllllllllllllllIIIlIlIlIlIIIIlll) >= 0;
    }
    
    @Override
    public int indexOf(final Object lllllllllllllllIIIlIlIlIIlllllIl) {
        final ObjectListIterator<K> lllllllllllllllIIIlIlIlIIlllllll = this.listIterator();
        while (lllllllllllllllIIIlIlIlIIlllllll.hasNext()) {
            final K lllllllllllllllIIIlIlIlIlIIIIIlI = lllllllllllllllIIIlIlIlIIlllllll.next();
            if (Objects.equals(lllllllllllllllIIIlIlIlIIlllllIl, lllllllllllllllIIIlIlIlIlIIIIIlI)) {
                return lllllllllllllllIIIlIlIlIIlllllll.previousIndex();
            }
        }
        return -1;
    }
    
    protected void ensureRestrictedIndex(final int lllllllllllllllIIIlIlIlIlIlllllI) {
        if (lllllllllllllllIIIlIlIlIlIlllllI < 0) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(lllllllllllllllIIIlIlIlIlIlllllI).append(") is negative")));
        }
        if (lllllllllllllllIIIlIlIlIlIlllllI >= this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(lllllllllllllllIIIlIlIlIlIlllllI).append(") is greater than or equal to list size (").append(this.size()).append(")")));
        }
    }
    
    @Override
    public boolean addAll(int lllllllllllllllIIIlIlIlIlIlIIlll, final Collection<? extends K> lllllllllllllllIIIlIlIlIlIlIIllI) {
        this.ensureIndex(lllllllllllllllIIIlIlIlIlIlIIlll);
        final Iterator<? extends K> lllllllllllllllIIIlIlIlIlIlIIlIl = lllllllllllllllIIIlIlIlIlIlIIllI.iterator();
        final boolean lllllllllllllllIIIlIlIlIlIlIIlII = lllllllllllllllIIIlIlIlIlIlIIlIl.hasNext();
        while (lllllllllllllllIIIlIlIlIlIlIIlIl.hasNext()) {
            this.add(lllllllllllllllIIIlIlIlIlIlIIlll++, lllllllllllllllIIIlIlIlIlIlIIlIl.next());
        }
        return lllllllllllllllIIIlIlIlIlIlIIlII;
    }
    
    @Override
    public int compareTo(final List<? extends K> lllllllllllllllIIIlIlIIlIllIllII) {
        if (lllllllllllllllIIIlIlIIlIllIllII == this) {
            return 0;
        }
        if (lllllllllllllllIIIlIlIIlIllIllII instanceof ObjectList) {
            final ObjectListIterator<K> lllllllllllllllIIIlIlIIlIlllIIll = this.listIterator();
            final ObjectListIterator<K> lllllllllllllllIIIlIlIIlIlllIIIl = ((ObjectList)lllllllllllllllIIIlIlIIlIllIllII).listIterator();
            while (lllllllllllllllIIIlIlIIlIlllIIll.hasNext() && lllllllllllllllIIIlIlIIlIlllIIIl.hasNext()) {
                final K lllllllllllllllIIIlIlIIlIlllIlIl = lllllllllllllllIIIlIlIIlIlllIIll.next();
                final K lllllllllllllllIIIlIlIIlIlllIlII = lllllllllllllllIIIlIlIIlIlllIIIl.next();
                final int lllllllllllllllIIIlIlIIlIlllIlll;
                if ((lllllllllllllllIIIlIlIIlIlllIlll = ((Comparable)lllllllllllllllIIIlIlIIlIlllIlIl).compareTo(lllllllllllllllIIIlIlIIlIlllIlII)) != 0) {
                    return lllllllllllllllIIIlIlIIlIlllIlll;
                }
            }
            return lllllllllllllllIIIlIlIIlIlllIIIl.hasNext() ? -1 : (lllllllllllllllIIIlIlIIlIlllIIll.hasNext() ? 1 : 0);
        }
        final ListIterator<? extends K> lllllllllllllllIIIlIlIIlIllIlIlI = (ListIterator<? extends K>)this.listIterator();
        final ListIterator<? extends K> lllllllllllllllIIIlIlIIlIllIlIIl = lllllllllllllllIIIlIlIIlIllIllII.listIterator();
        while (lllllllllllllllIIIlIlIIlIllIlIlI.hasNext() && lllllllllllllllIIIlIlIIlIllIlIIl.hasNext()) {
            final int lllllllllllllllIIIlIlIIlIlllIIII;
            if ((lllllllllllllllIIIlIlIIlIlllIIII = ((Comparable)lllllllllllllllIIIlIlIIlIllIlIlI.next()).compareTo(lllllllllllllllIIIlIlIIlIllIlIIl.next())) != 0) {
                return lllllllllllllllIIIlIlIIlIlllIIII;
            }
        }
        return lllllllllllllllIIIlIlIIlIllIlIIl.hasNext() ? -1 : (lllllllllllllllIIIlIlIIlIllIlIlI.hasNext() ? 1 : 0);
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllllIIIlIlIIlIIllIllI = new StringBuilder();
        final ObjectIterator<K> lllllllllllllllIIIlIlIIlIIllIlIl = this.iterator();
        int lllllllllllllllIIIlIlIIlIIllIlII = this.size();
        boolean lllllllllllllllIIIlIlIIlIIllIIll = true;
        lllllllllllllllIIIlIlIIlIIllIllI.append("[");
        while (lllllllllllllllIIIlIlIIlIIllIlII-- != 0) {
            if (lllllllllllllllIIIlIlIIlIIllIIll) {
                lllllllllllllllIIIlIlIIlIIllIIll = false;
            }
            else {
                lllllllllllllllIIIlIlIIlIIllIllI.append(", ");
            }
            final K lllllllllllllllIIIlIlIIlIIlllIII = lllllllllllllllIIIlIlIIlIIllIlIl.next();
            if (this == lllllllllllllllIIIlIlIIlIIlllIII) {
                lllllllllllllllIIIlIlIIlIIllIllI.append("(this list)");
            }
            else {
                lllllllllllllllIIIlIlIIlIIllIllI.append(String.valueOf(lllllllllllllllIIIlIlIIlIIlllIII));
            }
        }
        lllllllllllllllIIIlIlIIlIIllIllI.append("]");
        return String.valueOf(lllllllllllllllIIIlIlIIlIIllIllI);
    }
    
    @Override
    public void removeElements(final int lllllllllllllllIIIlIlIlIIlIIIIlI, final int lllllllllllllllIIIlIlIlIIlIIIllI) {
        this.ensureIndex(lllllllllllllllIIIlIlIlIIlIIIllI);
        final ObjectListIterator<K> lllllllllllllllIIIlIlIlIIlIIIlIl = this.listIterator(lllllllllllllllIIIlIlIlIIlIIIIlI);
        int lllllllllllllllIIIlIlIlIIlIIIlII = lllllllllllllllIIIlIlIlIIlIIIllI - lllllllllllllllIIIlIlIlIIlIIIIlI;
        if (lllllllllllllllIIIlIlIlIIlIIIlII < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Start index (").append(lllllllllllllllIIIlIlIlIIlIIIIlI).append(") is greater than end index (").append(lllllllllllllllIIIlIlIlIIlIIIllI).append(")")));
        }
        while (lllllllllllllllIIIlIlIlIIlIIIlII-- != 0) {
            lllllllllllllllIIIlIlIlIIlIIIlIl.next();
            lllllllllllllllIIIlIlIlIIlIIIlIl.remove();
        }
    }
    
    protected void ensureIndex(final int lllllllllllllllIIIlIlIlIllIIIIlI) {
        if (lllllllllllllllIIIlIlIlIllIIIIlI < 0) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(lllllllllllllllIIIlIlIlIllIIIIlI).append(") is negative")));
        }
        if (lllllllllllllllIIIlIlIlIllIIIIlI > this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(lllllllllllllllIIIlIlIlIllIIIIlI).append(") is greater than list size (").append(this.size()).append(")")));
        }
    }
    
    @Override
    public void getElements(final int lllllllllllllllIIIlIlIIlllllIlll, final Object[] lllllllllllllllIIIlIlIIlllllIllI, int lllllllllllllllIIIlIlIIllllIllll, int lllllllllllllllIIIlIlIIllllIlllI) {
        final ObjectListIterator<K> lllllllllllllllIIIlIlIIlllllIIll = this.listIterator(lllllllllllllllIIIlIlIIlllllIlll);
        if (lllllllllllllllIIIlIlIIllllIllll < 0) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Offset (").append(lllllllllllllllIIIlIlIIllllIllll).append(") is negative")));
        }
        if (lllllllllllllllIIIlIlIIllllIllll + lllllllllllllllIIIlIlIIllllIlllI > lllllllllllllllIIIlIlIIlllllIllI.length) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(lllllllllllllllIIIlIlIIllllIllll + lllllllllllllllIIIlIlIIllllIlllI).append(") is greater than array length (").append(lllllllllllllllIIIlIlIIlllllIllI.length).append(")")));
        }
        if (lllllllllllllllIIIlIlIIlllllIlll + lllllllllllllllIIIlIlIIllllIlllI > this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(lllllllllllllllIIIlIlIIlllllIlll + lllllllllllllllIIIlIlIIllllIlllI).append(") is greater than list size (").append(this.size()).append(")")));
        }
        while (lllllllllllllllIIIlIlIIllllIlllI-- != 0) {
            lllllllllllllllIIIlIlIIlllllIllI[lllllllllllllllIIIlIlIIllllIllll++] = lllllllllllllllIIIlIlIIlllllIIll.next();
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIlIlIIllIIllIIl) {
        if (lllllllllllllllIIIlIlIIllIIllIIl == this) {
            return true;
        }
        if (!(lllllllllllllllIIIlIlIIllIIllIIl instanceof List)) {
            return false;
        }
        final List<?> lllllllllllllllIIIlIlIIllIlIIIIl = (List<?>)lllllllllllllllIIIlIlIIllIIllIIl;
        int lllllllllllllllIIIlIlIIllIIlllll = this.size();
        if (lllllllllllllllIIIlIlIIllIIlllll != lllllllllllllllIIIlIlIIllIlIIIIl.size()) {
            return false;
        }
        final ListIterator<?> lllllllllllllllIIIlIlIIllIIlllIl = this.listIterator();
        final ListIterator<?> lllllllllllllllIIIlIlIIllIIlllII = lllllllllllllllIIIlIlIIllIlIIIIl.listIterator();
        while (lllllllllllllllIIIlIlIIllIIlllll-- != 0) {
            if (!this.valEquals(lllllllllllllllIIIlIlIIllIIlllIl.next(), lllllllllllllllIIIlIlIIllIIlllII.next())) {
                return false;
            }
        }
        return true;
    }
    
    private boolean valEquals(final Object lllllllllllllllIIIlIlIIlllIllIII, final Object lllllllllllllllIIIlIlIIlllIlIIlI) {
        return (lllllllllllllllIIIlIlIIlllIllIII == null) ? (lllllllllllllllIIIlIlIIlllIlIIlI == null) : lllllllllllllllIIIlIlIIlllIllIII.equals(lllllllllllllllIIIlIlIIlllIlIIlI);
    }
    
    @Override
    public void addElements(int lllllllllllllllIIIlIlIlIIIlIIlII, final K[] lllllllllllllllIIIlIlIlIIIlIIIlI, int lllllllllllllllIIIlIlIlIIIlIIIII, int lllllllllllllllIIIlIlIlIIIIllllI) {
        this.ensureIndex(lllllllllllllllIIIlIlIlIIIlIIlII);
        if (lllllllllllllllIIIlIlIlIIIlIIIII < 0) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Offset (").append(lllllllllllllllIIIlIlIlIIIlIIIII).append(") is negative")));
        }
        if (lllllllllllllllIIIlIlIlIIIlIIIII + lllllllllllllllIIIlIlIlIIIIllllI > lllllllllllllllIIIlIlIlIIIlIIIlI.length) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(lllllllllllllllIIIlIlIlIIIlIIIII + lllllllllllllllIIIlIlIlIIIIllllI).append(") is greater than array length (").append(lllllllllllllllIIIlIlIlIIIlIIIlI.length).append(")")));
        }
        while (lllllllllllllllIIIlIlIlIIIIllllI-- != 0) {
            this.add(lllllllllllllllIIIlIlIlIIIlIIlII++, lllllllllllllllIIIlIlIlIIIlIIIlI[lllllllllllllllIIIlIlIlIIIlIIIII++]);
        }
    }
    
    @Override
    public void add(final int lllllllllllllllIIIlIlIlIlIlllIlI, final K lllllllllllllllIIIlIlIlIlIlllIIl) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public K set(final int lllllllllllllllIIIlIlIlIlIlIllll, final K lllllllllllllllIIIlIlIlIlIlIlllI) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean add(final K lllllllllllllllIIIlIlIlIlIllIlIl) {
        this.add(this.size(), lllllllllllllllIIIlIlIlIlIllIlIl);
        return true;
    }
    
    @Override
    public void push(final K lllllllllllllllIIIlIlIIlIlIlIIll) {
        this.add(lllllllllllllllIIIlIlIIlIlIlIIll);
    }
    
    @Override
    public ObjectListIterator<K> listIterator(final int lllllllllllllllIIIlIlIlIlIIIllIl) {
        this.ensureIndex(lllllllllllllllIIIlIlIlIlIIIllIl);
        return new ObjectListIterator<K>() {
            /* synthetic */ int last = -1;
            /* synthetic */ int pos = lllllllllllllllIIIlIlIlIlIIIllIl;
            
            @Override
            public void add(final K lllllllllllllIIlIlIllIllIlIlllII) {
                AbstractObjectList.this.add(this.pos++, lllllllllllllIIlIlIllIllIlIlllII);
                this.last = -1;
            }
            
            @Override
            public int previousIndex() {
                return this.pos - 1;
            }
            
            @Override
            public void set(final K lllllllllllllIIlIlIllIllIlIlIllI) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                AbstractObjectList.this.set(this.last, lllllllllllllIIlIlIllIllIlIlIllI);
            }
            
            @Override
            public K next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                final AbstractObjectList this$0 = AbstractObjectList.this;
                final int last = this.pos++;
                this.last = last;
                return this$0.get(last);
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
            public void remove() {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                AbstractObjectList.this.remove(this.last);
                if (this.last < this.pos) {
                    --this.pos;
                }
                this.last = -1;
            }
            
            @Override
            public K previous() {
                if (!this.hasPrevious()) {
                    throw new NoSuchElementException();
                }
                final AbstractObjectList this$0 = AbstractObjectList.this;
                final int n = this.pos - 1;
                this.pos = n;
                this.last = n;
                return this$0.get(n);
            }
            
            @Override
            public boolean hasNext() {
                return this.pos < AbstractObjectList.this.size();
            }
        };
    }
    
    @Override
    public K peek(final int lllllllllllllllIIIlIlIIlIlIIIIIl) {
        return this.get(this.size() - 1 - lllllllllllllllIIIlIlIIlIlIIIIIl);
    }
    
    @Override
    public void addElements(final int lllllllllllllllIIIlIlIlIIIIIlllI, final K[] lllllllllllllllIIIlIlIlIIIIlIIIl) {
        this.addElements(lllllllllllllllIIIlIlIlIIIIIlllI, lllllllllllllllIIIlIlIlIIIIlIIIl, 0, lllllllllllllllIIIlIlIlIIIIlIIIl.length);
    }
    
    public static class ObjectSubList<K> extends AbstractObjectList<K> implements Serializable
    {
        protected final /* synthetic */ ObjectList<K> l;
        protected final /* synthetic */ int from;
        protected /* synthetic */ int to;
        
        @Override
        public void add(final int lllllllllllllllIlIllIlIllIlIlIll, final K lllllllllllllllIlIllIlIllIlIIlll) {
            this.ensureIndex(lllllllllllllllIlIllIlIllIlIlIll);
            this.l.add(this.from + lllllllllllllllIlIllIlIllIlIlIll, lllllllllllllllIlIllIlIllIlIIlll);
            ++this.to;
            assert this.assertRange();
        }
        
        public ObjectSubList(final ObjectList<K> lllllllllllllllIlIllIlIllIlllIll, final int lllllllllllllllIlIllIlIllIlllllI, final int lllllllllllllllIlIllIlIllIlllIIl) {
            this.l = lllllllllllllllIlIllIlIllIlllIll;
            this.from = lllllllllllllllIlIllIlIllIlllllI;
            this.to = lllllllllllllllIlIllIlIllIlllIIl;
        }
        
        @Override
        public ObjectList<K> subList(final int lllllllllllllllIlIllIlIlIlIlIlII, final int lllllllllllllllIlIllIlIlIlIlIIII) {
            this.ensureIndex(lllllllllllllllIlIllIlIlIlIlIlII);
            this.ensureIndex(lllllllllllllllIlIllIlIlIlIlIIII);
            if (lllllllllllllllIlIllIlIlIlIlIlII > lllllllllllllllIlIllIlIlIlIlIIII) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Start index (").append(lllllllllllllllIlIllIlIlIlIlIlII).append(") is greater than end index (").append(lllllllllllllllIlIllIlIlIlIlIIII).append(")")));
            }
            return new ObjectSubList((ObjectList<Object>)this, lllllllllllllllIlIllIlIlIlIlIlII, lllllllllllllllIlIllIlIlIlIlIIII);
        }
        
        @Override
        public ObjectListIterator<K> listIterator(final int lllllllllllllllIlIllIlIlIlIllIll) {
            this.ensureIndex(lllllllllllllllIlIllIlIlIlIllIll);
            return new ObjectListIterator<K>() {
                /* synthetic */ int pos = lllllllllllllllIlIllIlIlIlIllIll;
                /* synthetic */ int last = -1;
                
                @Override
                public boolean hasNext() {
                    return this.pos < ObjectSubList.this.size();
                }
                
                @Override
                public K next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final ObjectList<K> l = ObjectSubList.this.l;
                    final int from = ObjectSubList.this.from;
                    final int last = this.pos++;
                    this.last = last;
                    return (K)l.get(from + last);
                }
                
                @Override
                public int nextIndex() {
                    return this.pos;
                }
                
                @Override
                public void set(final K llllllllllllllIIlllIllIlIIlIIllI) {
                    if (this.last == -1) {
                        throw new IllegalStateException();
                    }
                    ObjectSubList.this.set(this.last, llllllllllllllIIlllIllIlIIlIIllI);
                }
                
                @Override
                public int previousIndex() {
                    return this.pos - 1;
                }
                
                @Override
                public boolean hasPrevious() {
                    return this.pos > 0;
                }
                
                @Override
                public void add(final K llllllllllllllIIlllIllIlIIlIllII) {
                    if (this.last == -1) {
                        throw new IllegalStateException();
                    }
                    ObjectSubList.this.add(this.pos++, llllllllllllllIIlllIllIlIIlIllII);
                    this.last = -1;
                    assert ObjectSubList.this.assertRange();
                }
                
                @Override
                public K previous() {
                    if (!this.hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    final ObjectList<K> l = ObjectSubList.this.l;
                    final int from = ObjectSubList.this.from;
                    final int n = this.pos - 1;
                    this.pos = n;
                    this.last = n;
                    return (K)l.get(from + n);
                }
                
                @Override
                public void remove() {
                    if (this.last == -1) {
                        throw new IllegalStateException();
                    }
                    ObjectSubList.this.remove(this.last);
                    if (this.last < this.pos) {
                        --this.pos;
                    }
                    this.last = -1;
                    assert ObjectSubList.this.assertRange();
                }
            };
        }
        
        @Override
        public void removeElements(final int lllllllllllllllIlIllIlIlIllIllll, final int lllllllllllllllIlIllIlIlIlllIIIl) {
            this.ensureIndex(lllllllllllllllIlIllIlIlIllIllll);
            this.ensureIndex(lllllllllllllllIlIllIlIlIlllIIIl);
            this.l.removeElements(this.from + lllllllllllllllIlIllIlIlIllIllll, this.from + lllllllllllllllIlIllIlIlIlllIIIl);
            this.to -= lllllllllllllllIlIllIlIlIlllIIIl - lllllllllllllllIlIllIlIlIllIllll;
            assert this.assertRange();
        }
        
        @Override
        public void getElements(final int lllllllllllllllIlIllIlIlIllllIlI, final Object[] lllllllllllllllIlIllIlIlIllllIIl, final int lllllllllllllllIlIllIlIlIlllllIl, final int lllllllllllllllIlIllIlIlIlllllII) {
            this.ensureIndex(lllllllllllllllIlIllIlIlIllllIlI);
            if (lllllllllllllllIlIllIlIlIllllIlI + lllllllllllllllIlIllIlIlIlllllII > this.size()) {
                throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(lllllllllllllllIlIllIlIlIllllIlI).append(lllllllllllllllIlIllIlIlIlllllII).append(") is greater than list size (").append(this.size()).append(")")));
            }
            this.l.getElements(this.from + lllllllllllllllIlIllIlIlIllllIlI, lllllllllllllllIlIllIlIlIllllIIl, lllllllllllllllIlIllIlIlIlllllIl, lllllllllllllllIlIllIlIlIlllllII);
        }
        
        @Override
        public K get(final int lllllllllllllllIlIllIlIllIIllIII) {
            this.ensureRestrictedIndex(lllllllllllllllIlIllIlIllIIllIII);
            return this.l.get(this.from + lllllllllllllllIlIllIlIllIIllIII);
        }
        
        @Override
        public K set(final int lllllllllllllllIlIllIlIllIIIlIlI, final K lllllllllllllllIlIllIlIllIIIllII) {
            this.ensureRestrictedIndex(lllllllllllllllIlIllIlIllIIIlIlI);
            return this.l.set(this.from + lllllllllllllllIlIllIlIllIIIlIlI, lllllllllllllllIlIllIlIllIIIllII);
        }
        
        @Override
        public boolean add(final K lllllllllllllllIlIllIlIllIllIIII) {
            this.l.add(this.to, lllllllllllllllIlIllIlIllIllIIII);
            ++this.to;
            assert this.assertRange();
            return true;
        }
        
        @Override
        public K remove(final int lllllllllllllllIlIllIlIllIIlIIlI) {
            this.ensureRestrictedIndex(lllllllllllllllIlIllIlIllIIlIIlI);
            --this.to;
            return this.l.remove(this.from + lllllllllllllllIlIllIlIllIIlIIlI);
        }
        
        @Override
        public void addElements(final int lllllllllllllllIlIllIlIlIllIIlll, final K[] lllllllllllllllIlIllIlIlIllIIllI, final int lllllllllllllllIlIllIlIlIllIIlIl, final int lllllllllllllllIlIllIlIlIlIlllll) {
            this.ensureIndex(lllllllllllllllIlIllIlIlIllIIlll);
            this.l.addElements(this.from + lllllllllllllllIlIllIlIlIllIIlll, lllllllllllllllIlIllIlIlIllIIllI, lllllllllllllllIlIllIlIlIllIIlIl, lllllllllllllllIlIllIlIlIlIlllll);
            this.to += lllllllllllllllIlIllIlIlIlIlllll;
            assert this.assertRange();
        }
        
        private boolean assertRange() {
            assert this.from <= this.l.size();
            assert this.to <= this.l.size();
            assert this.to >= this.from;
            return true;
        }
        
        @Override
        public boolean addAll(final int lllllllllllllllIlIllIlIllIlIIIlI, final Collection<? extends K> lllllllllllllllIlIllIlIllIlIIIIl) {
            this.ensureIndex(lllllllllllllllIlIllIlIllIlIIIlI);
            this.to += lllllllllllllllIlIllIlIllIlIIIIl.size();
            return this.l.addAll(this.from + lllllllllllllllIlIllIlIllIlIIIlI, (Collection<?>)lllllllllllllllIlIllIlIllIlIIIIl);
        }
        
        @Override
        public int size() {
            return this.to - this.from;
        }
    }
}
