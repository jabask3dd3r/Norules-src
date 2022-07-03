package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.io.*;

public abstract class AbstractIntList extends AbstractIntCollection implements IntList, IntStack
{
    @Override
    public void size(final int llIllIIIlIIII) {
        int llIllIIIlIIlI = this.size();
        if (llIllIIIlIIII > llIllIIIlIIlI) {
            while (llIllIIIlIIlI++ < llIllIIIlIIII) {
                this.add(0);
            }
        }
        else {
            while (llIllIIIlIIlI-- != llIllIIIlIIII) {
                this.removeInt(llIllIIIlIIlI);
            }
        }
    }
    
    @Override
    public IntList subList(final int llIllIIIIlIlI, final int llIllIIIIIllI) {
        this.ensureIndex(llIllIIIIlIlI);
        this.ensureIndex(llIllIIIIIllI);
        if (llIllIIIIlIlI > llIllIIIIIllI) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Start index (").append(llIllIIIIlIlI).append(") is greater than end index (").append(llIllIIIIIllI).append(")")));
        }
        return new IntSubList(this, llIllIIIIlIlI, llIllIIIIIllI);
    }
    
    @Override
    public void getElements(final int llIlIllIlIlll, final int[] llIlIllIlIllI, int llIlIllIlIlIl, int llIlIllIlIlII) {
        final IntListIterator llIlIllIlIIll = this.listIterator(llIlIllIlIlll);
        if (llIlIllIlIlIl < 0) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Offset (").append(llIlIllIlIlIl).append(") is negative")));
        }
        if (llIlIllIlIlIl + llIlIllIlIlII > llIlIllIlIllI.length) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(llIlIllIlIlIl + llIlIllIlIlII).append(") is greater than array length (").append(llIlIllIlIllI.length).append(")")));
        }
        if (llIlIllIlIlll + llIlIllIlIlII > this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(llIlIllIlIlll + llIlIllIlIlII).append(") is greater than list size (").append(this.size()).append(")")));
        }
        while (llIlIllIlIlII-- != 0) {
            llIlIllIlIllI[llIlIllIlIlIl++] = llIlIllIlIIll.nextInt();
        }
    }
    
    @Override
    public int popInt() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.removeInt(this.size() - 1);
    }
    
    @Override
    public IntListIterator listIterator() {
        return this.listIterator(0);
    }
    
    @Override
    public boolean contains(final int llIllIllIIIlI) {
        return this.indexOf(llIllIllIIIlI) >= 0;
    }
    
    @Override
    public int peekInt(final int llIlIIlllIllI) {
        return this.getInt(this.size() - 1 - llIlIIlllIllI);
    }
    
    @Override
    public boolean equals(final Object llIlIlIlIlIlI) {
        if (llIlIlIlIlIlI == this) {
            return true;
        }
        if (!(llIlIlIlIlIlI instanceof List)) {
            return false;
        }
        final List<?> llIlIlIlIlIIl = (List<?>)llIlIlIlIlIlI;
        int llIlIlIlIlIII = this.size();
        if (llIlIlIlIlIII != llIlIlIlIlIIl.size()) {
            return false;
        }
        if (llIlIlIlIlIIl instanceof IntList) {
            final IntListIterator llIlIlIlIllIl = this.listIterator();
            final IntListIterator llIlIlIlIllII = ((IntList)llIlIlIlIlIIl).listIterator();
            while (llIlIlIlIlIII-- != 0) {
                if (llIlIlIlIllIl.nextInt() != llIlIlIlIllII.nextInt()) {
                    return false;
                }
            }
            return true;
        }
        final ListIterator<?> llIlIlIlIIlll = this.listIterator();
        final ListIterator<?> llIlIlIlIIllI = llIlIlIlIlIIl.listIterator();
        while (llIlIlIlIlIII-- != 0) {
            if (!this.valEquals(llIlIlIlIIlll.next(), llIlIlIlIIllI.next())) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void add(final int llIlllIIlIlIl, final int llIlllIIlIlII) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int set(final int llIlllIIIlIlI, final int llIlllIIIlIIl) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public IntListIterator iterator() {
        return this.listIterator();
    }
    
    @Override
    public int indexOf(final int llIllIlIllIII) {
        final IntListIterator llIllIlIllIlI = this.listIterator();
        while (llIllIlIllIlI.hasNext()) {
            final int llIllIlIlllIl = llIllIlIllIlI.nextInt();
            if (llIllIlIllIII == llIllIlIlllIl) {
                return llIllIlIllIlI.previousIndex();
            }
        }
        return -1;
    }
    
    protected void ensureRestrictedIndex(final int llIlllIIllIIl) {
        if (llIlllIIllIIl < 0) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(llIlllIIllIIl).append(") is negative")));
        }
        if (llIlllIIllIIl >= this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(llIlllIIllIIl).append(") is greater than or equal to list size (").append(this.size()).append(")")));
        }
    }
    
    @Override
    public void removeElements(final int llIlIllllllll, final int llIlIlllllllI) {
        this.ensureIndex(llIlIlllllllI);
        final IntListIterator llIlIllllllIl = this.listIterator(llIlIllllllll);
        int llIlIllllllII = llIlIlllllllI - llIlIllllllll;
        if (llIlIllllllII < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Start index (").append(llIlIllllllll).append(") is greater than end index (").append(llIlIlllllllI).append(")")));
        }
        while (llIlIllllllII-- != 0) {
            llIlIllllllIl.nextInt();
            llIlIllllllIl.remove();
        }
    }
    
    protected void ensureIndex(final int llIlllIIlllll) {
        if (llIlllIIlllll < 0) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(llIlllIIlllll).append(") is negative")));
        }
        if (llIlllIIlllll > this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(llIlllIIlllll).append(") is greater than list size (").append(this.size()).append(")")));
        }
    }
    
    @Override
    public int removeInt(final int llIlllIIIllII) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public IntListIterator listIterator(final int llIllIllIlIlI) {
        this.ensureIndex(llIllIllIlIlI);
        return new IntListIterator() {
            /* synthetic */ int pos = llIllIllIlIlI;
            /* synthetic */ int last = -1;
            
            @Override
            public void set(final int lllllllllllllllIlIlllIIlIIIlIllI) {
                if (this.last == -1) {
                    throw new IllegalStateException();
                }
                AbstractIntList.this.set(this.last, lllllllllllllllIlIlllIIlIIIlIllI);
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
                AbstractIntList.this.removeInt(this.last);
                if (this.last < this.pos) {
                    --this.pos;
                }
                this.last = -1;
            }
            
            @Override
            public int previousIndex() {
                return this.pos - 1;
            }
            
            @Override
            public int previousInt() {
                if (!this.hasPrevious()) {
                    throw new NoSuchElementException();
                }
                final AbstractIntList this$0 = AbstractIntList.this;
                final int n = this.pos - 1;
                this.pos = n;
                this.last = n;
                return this$0.getInt(n);
            }
            
            @Override
            public void add(final int lllllllllllllllIlIlllIIlIIIllllI) {
                AbstractIntList.this.add(this.pos++, lllllllllllllllIlIlllIIlIIIllllI);
                this.last = -1;
            }
            
            @Override
            public boolean hasNext() {
                return this.pos < AbstractIntList.this.size();
            }
            
            @Override
            public boolean hasPrevious() {
                return this.pos > 0;
            }
            
            @Override
            public int nextInt() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                final AbstractIntList this$0 = AbstractIntList.this;
                final int last = this.pos++;
                this.last = last;
                return this$0.getInt(last);
            }
        };
    }
    
    @Override
    public String toString() {
        final StringBuilder llIlIIlIIIIII = new StringBuilder();
        final IntIterator llIlIIIllllll = this.iterator();
        int llIlIIIlllllI = this.size();
        boolean llIlIIIllllIl = true;
        llIlIIlIIIIII.append("[");
        while (llIlIIIlllllI-- != 0) {
            if (llIlIIIllllIl) {
                llIlIIIllllIl = false;
            }
            else {
                llIlIIlIIIIII.append(", ");
            }
            final int llIlIIlIIIIlI = llIlIIIllllll.nextInt();
            llIlIIlIIIIII.append(String.valueOf(llIlIIlIIIIlI));
        }
        llIlIIlIIIIII.append("]");
        return String.valueOf(llIlIIlIIIIII);
    }
    
    @Override
    public boolean addAll(final int llIlIIlIlIllI, final IntList llIlIIlIllIII) {
        return this.addAll(llIlIIlIlIllI, (IntCollection)llIlIIlIllIII);
    }
    
    @Override
    public void addElements(final int llIlIlllIIIll, final int[] llIlIlllIIIlI) {
        this.addElements(llIlIlllIIIll, llIlIlllIIIlI, 0, llIlIlllIIIlI.length);
    }
    
    private boolean valEquals(final Object llIlIllIIIllI, final Object llIlIllIIIIll) {
        return (llIlIllIIIllI == null) ? (llIlIllIIIIll == null) : llIlIllIIIllI.equals(llIlIllIIIIll);
    }
    
    @Override
    public int topInt() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.getInt(this.size() - 1);
    }
    
    @Override
    public void addElements(int llIlIllllIIII, final int[] llIlIlllIllll, int llIlIlllIlllI, int llIlIlllIlIII) {
        this.ensureIndex(llIlIllllIIII);
        if (llIlIlllIlllI < 0) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Offset (").append(llIlIlllIlllI).append(") is negative")));
        }
        if (llIlIlllIlllI + llIlIlllIlIII > llIlIlllIllll.length) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(llIlIlllIlllI + llIlIlllIlIII).append(") is greater than array length (").append(llIlIlllIllll.length).append(")")));
        }
        while (llIlIlllIlIII-- != 0) {
            this.add(llIlIllllIIII++, llIlIlllIllll[llIlIlllIlllI++]);
        }
    }
    
    @Override
    public boolean addAll(final IntList llIlIIlIIlIIl) {
        return this.addAll(this.size(), llIlIIlIIlIIl);
    }
    
    protected AbstractIntList() {
    }
    
    @Override
    public boolean addAll(int llIlllIIIIIlI, final Collection<? extends Integer> llIlllIIIIIIl) {
        this.ensureIndex(llIlllIIIIIlI);
        final Iterator<? extends Integer> llIlllIIIIIII = llIlllIIIIIIl.iterator();
        final boolean llIllIlllllll = llIlllIIIIIII.hasNext();
        while (llIlllIIIIIII.hasNext()) {
            this.add(llIlllIIIIIlI++, (int)llIlllIIIIIII.next());
        }
        return llIllIlllllll;
    }
    
    @Override
    public boolean addAll(int llIlIIllIIllI, final IntCollection llIlIIllIIIII) {
        this.ensureIndex(llIlIIllIIllI);
        final IntIterator llIlIIllIIlII = llIlIIllIIIII.iterator();
        final boolean llIlIIllIIIll = llIlIIllIIlII.hasNext();
        while (llIlIIllIIlII.hasNext()) {
            this.add(llIlIIllIIllI++, llIlIIllIIlII.nextInt());
        }
        return llIlIIllIIIll;
    }
    
    @Override
    public void clear() {
        this.removeElements(0, this.size());
    }
    
    @Override
    public int lastIndexOf(final int llIllIlIIllII) {
        final IntListIterator llIllIlIIlllI = this.listIterator(this.size());
        while (llIllIlIIlllI.hasPrevious()) {
            final int llIllIlIlIIIl = llIllIlIIlllI.previousInt();
            if (llIllIlIIllII == llIllIlIlIIIl) {
                return llIllIlIIlllI.nextIndex();
            }
        }
        return -1;
    }
    
    @Override
    public boolean addAll(final Collection<? extends Integer> llIllIlllIllI) {
        return this.addAll(this.size(), llIllIlllIllI);
    }
    
    @Override
    public void push(final int llIlIlIIIIIlI) {
        this.add(llIlIlIIIIIlI);
    }
    
    @Override
    public boolean addAll(final IntCollection llIlIIlIIllll) {
        return this.addAll(this.size(), llIlIIlIIllll);
    }
    
    @Override
    public int hashCode() {
        final IntIterator llIlIlIlllIll = this.iterator();
        int llIlIlIlllIlI = 1;
        int llIlIlIlllIIl = this.size();
        while (llIlIlIlllIIl-- != 0) {
            final int llIlIlIllllIl = llIlIlIlllIll.nextInt();
            llIlIlIlllIlI = 31 * llIlIlIlllIlI + llIlIlIllllIl;
        }
        return llIlIlIlllIlI;
    }
    
    @Override
    public int compareTo(final List<? extends Integer> llIlIlIIlIIIl) {
        if (llIlIlIIlIIIl == this) {
            return 0;
        }
        if (llIlIlIIlIIIl instanceof IntList) {
            final IntListIterator llIlIlIIlIlIl = this.listIterator();
            final IntListIterator llIlIlIIlIlII = ((IntList)llIlIlIIlIIIl).listIterator();
            while (llIlIlIIlIlIl.hasNext() && llIlIlIIlIlII.hasNext()) {
                final int llIlIlIIlIlll = llIlIlIIlIlIl.nextInt();
                final int llIlIlIIlIllI = llIlIlIIlIlII.nextInt();
                final int llIlIlIIllIII;
                if ((llIlIlIIllIII = Integer.compare(llIlIlIIlIlll, llIlIlIIlIllI)) != 0) {
                    return llIlIlIIllIII;
                }
            }
            return llIlIlIIlIlII.hasNext() ? -1 : (llIlIlIIlIlIl.hasNext() ? 1 : 0);
        }
        final ListIterator<? extends Integer> llIlIlIIlIIII = this.listIterator();
        final ListIterator<? extends Integer> llIlIlIIIllll = llIlIlIIlIIIl.listIterator();
        while (llIlIlIIlIIII.hasNext() && llIlIlIIIllll.hasNext()) {
            final int llIlIlIIlIIll;
            if ((llIlIlIIlIIll = ((Comparable)llIlIlIIlIIII.next()).compareTo(llIlIlIIIllll.next())) != 0) {
                return llIlIlIIlIIll;
            }
        }
        return llIlIlIIIllll.hasNext() ? -1 : (llIlIlIIlIIII.hasNext() ? 1 : 0);
    }
    
    @Override
    public boolean add(final int llIlllIIlIIII) {
        this.add(this.size(), llIlllIIlIIII);
        return true;
    }
    
    @Override
    public boolean rem(final int llIlIIllIlllI) {
        final int llIlIIlllIIII = this.indexOf(llIlIIllIlllI);
        if (llIlIIlllIIII == -1) {
            return false;
        }
        this.removeInt(llIlIIlllIIII);
        return true;
    }
    
    public static class IntSubList extends AbstractIntList implements Serializable
    {
        protected /* synthetic */ int to;
        protected final /* synthetic */ IntList l;
        protected final /* synthetic */ int from;
        
        @Override
        public void add(final int lllllllllllllIIlIIllIlIlIIIlIlII, final int lllllllllllllIIlIIllIlIlIIIlIIll) {
            this.ensureIndex(lllllllllllllIIlIIllIlIlIIIlIlII);
            this.l.add(this.from + lllllllllllllIIlIIllIlIlIIIlIlII, lllllllllllllIIlIIllIlIlIIIlIIll);
            ++this.to;
            assert this.assertRange();
        }
        
        @Override
        public int size() {
            return this.to - this.from;
        }
        
        @Override
        public int set(final int lllllllllllllIIlIIllIlIIllllIIll, final int lllllllllllllIIlIIllIlIIllllIIlI) {
            this.ensureRestrictedIndex(lllllllllllllIIlIIllIlIIllllIIll);
            return this.l.set(this.from + lllllllllllllIIlIIllIlIIllllIIll, lllllllllllllIIlIIllIlIIllllIIlI);
        }
        
        @Override
        public void addElements(final int lllllllllllllIIlIIllIlIIllIlIIII, final int[] lllllllllllllIIlIIllIlIIllIIllll, final int lllllllllllllIIlIIllIlIIllIIlIIl, final int lllllllllllllIIlIIllIlIIllIIlIII) {
            this.ensureIndex(lllllllllllllIIlIIllIlIIllIlIIII);
            this.l.addElements(this.from + lllllllllllllIIlIIllIlIIllIlIIII, lllllllllllllIIlIIllIlIIllIIllll, lllllllllllllIIlIIllIlIIllIIlIIl, lllllllllllllIIlIIllIlIIllIIlIII);
            this.to += lllllllllllllIIlIIllIlIIllIIlIII;
            assert this.assertRange();
        }
        
        private boolean assertRange() {
            assert this.from <= this.l.size();
            assert this.to <= this.l.size();
            assert this.to >= this.from;
            return true;
        }
        
        public IntSubList(final IntList lllllllllllllIIlIIllIlIlIIlIIlII, final int lllllllllllllIIlIIllIlIlIIlIIlll, final int lllllllllllllIIlIIllIlIlIIlIIllI) {
            this.l = lllllllllllllIIlIIllIlIlIIlIIlII;
            this.from = lllllllllllllIIlIIllIlIlIIlIIlll;
            this.to = lllllllllllllIIlIIllIlIlIIlIIllI;
        }
        
        @Override
        public IntList subList(final int lllllllllllllIIlIIllIlIIlIllllIl, final int lllllllllllllIIlIIllIlIIlIlllIIl) {
            this.ensureIndex(lllllllllllllIIlIIllIlIIlIllllIl);
            this.ensureIndex(lllllllllllllIIlIIllIlIIlIlllIIl);
            if (lllllllllllllIIlIIllIlIIlIllllIl > lllllllllllllIIlIIllIlIIlIlllIIl) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Start index (").append(lllllllllllllIIlIIllIlIIlIllllIl).append(") is greater than end index (").append(lllllllllllllIIlIIllIlIIlIlllIIl).append(")")));
            }
            return new IntSubList(this, lllllllllllllIIlIIllIlIIlIllllIl, lllllllllllllIIlIIllIlIIlIlllIIl);
        }
        
        @Override
        public boolean rem(final int lllllllllllllIIlIIllIlIIlIllIIIl) {
            final int lllllllllllllIIlIIllIlIIlIllIIll = this.indexOf(lllllllllllllIIlIIllIlIIlIllIIIl);
            if (lllllllllllllIIlIIllIlIIlIllIIll == -1) {
                return false;
            }
            --this.to;
            this.l.removeInt(this.from + lllllllllllllIIlIIllIlIIlIllIIll);
            assert this.assertRange();
            return true;
        }
        
        @Override
        public IntListIterator listIterator(final int lllllllllllllIIlIIllIlIIllIIIlII) {
            this.ensureIndex(lllllllllllllIIlIIllIlIIllIIIlII);
            return new IntListIterator() {
                /* synthetic */ int pos = lllllllllllllIIlIIllIlIIllIIIlII;
                /* synthetic */ int last = -1;
                
                @Override
                public int previousInt() {
                    if (!this.hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    final IntList l = IntSubList.this.l;
                    final int from = IntSubList.this.from;
                    final int n = this.pos - 1;
                    this.pos = n;
                    this.last = n;
                    return l.getInt(from + n);
                }
                
                @Override
                public boolean hasNext() {
                    return this.pos < IntSubList.this.size();
                }
                
                @Override
                public int nextInt() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final IntList l = IntSubList.this.l;
                    final int from = IntSubList.this.from;
                    final int last = this.pos++;
                    this.last = last;
                    return l.getInt(from + last);
                }
                
                @Override
                public void add(final int lllllllllllllIIlIIIlIlIIIlIlllIl) {
                    if (this.last == -1) {
                        throw new IllegalStateException();
                    }
                    IntSubList.this.add(this.pos++, lllllllllllllIIlIIIlIlIIIlIlllIl);
                    this.last = -1;
                    assert IntSubList.this.assertRange();
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
                public void set(final int lllllllllllllIIlIIIlIlIIIlIllIIl) {
                    if (this.last == -1) {
                        throw new IllegalStateException();
                    }
                    IntSubList.this.set(this.last, lllllllllllllIIlIIIlIlIIIlIllIIl);
                }
                
                @Override
                public void remove() {
                    if (this.last == -1) {
                        throw new IllegalStateException();
                    }
                    IntSubList.this.removeInt(this.last);
                    if (this.last < this.pos) {
                        --this.pos;
                    }
                    this.last = -1;
                    assert IntSubList.this.assertRange();
                }
                
                @Override
                public int nextIndex() {
                    return this.pos;
                }
            };
        }
        
        @Override
        public int getInt(final int lllllllllllllIIlIIllIlIlIIIIIIIl) {
            this.ensureRestrictedIndex(lllllllllllllIIlIIllIlIlIIIIIIIl);
            return this.l.getInt(this.from + lllllllllllllIIlIIllIlIlIIIIIIIl);
        }
        
        @Override
        public int removeInt(final int lllllllllllllIIlIIllIlIIllllllIl) {
            this.ensureRestrictedIndex(lllllllllllllIIlIIllIlIIllllllIl);
            --this.to;
            return this.l.removeInt(this.from + lllllllllllllIIlIIllIlIIllllllIl);
        }
        
        @Override
        public boolean addAll(final int lllllllllllllIIlIIllIlIIlIIlllll, final IntList lllllllllllllIIlIIllIlIIlIIllllI) {
            this.ensureIndex(lllllllllllllIIlIIllIlIIlIIlllll);
            return super.addAll(lllllllllllllIIlIIllIlIIlIIlllll, lllllllllllllIIlIIllIlIIlIIllllI);
        }
        
        @Override
        public void removeElements(final int lllllllllllllIIlIIllIlIIllIllIll, final int lllllllllllllIIlIIllIlIIllIlIlll) {
            this.ensureIndex(lllllllllllllIIlIIllIlIIllIllIll);
            this.ensureIndex(lllllllllllllIIlIIllIlIIllIlIlll);
            this.l.removeElements(this.from + lllllllllllllIIlIIllIlIIllIllIll, this.from + lllllllllllllIIlIIllIlIIllIlIlll);
            this.to -= lllllllllllllIIlIIllIlIIllIlIlll - lllllllllllllIIlIIllIlIIllIllIll;
            assert this.assertRange();
        }
        
        @Override
        public boolean addAll(final int lllllllllllllIIlIIllIlIIlIlIlIII, final IntCollection lllllllllllllIIlIIllIlIIlIlIIlll) {
            this.ensureIndex(lllllllllllllIIlIIllIlIIlIlIlIII);
            return super.addAll(lllllllllllllIIlIIllIlIIlIlIlIII, lllllllllllllIIlIIllIlIIlIlIIlll);
        }
        
        @Override
        public void getElements(final int lllllllllllllIIlIIllIlIIlllIIIll, final int[] lllllllllllllIIlIIllIlIIlllIIlll, final int lllllllllllllIIlIIllIlIIlllIIIIl, final int lllllllllllllIIlIIllIlIIlllIIlIl) {
            this.ensureIndex(lllllllllllllIIlIIllIlIIlllIIIll);
            if (lllllllllllllIIlIIllIlIIlllIIIll + lllllllllllllIIlIIllIlIIlllIIlIl > this.size()) {
                throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(lllllllllllllIIlIIllIlIIlllIIIll).append(lllllllllllllIIlIIllIlIIlllIIlIl).append(") is greater than list size (").append(this.size()).append(")")));
            }
            this.l.getElements(this.from + lllllllllllllIIlIIllIlIIlllIIIll, lllllllllllllIIlIIllIlIIlllIIlll, lllllllllllllIIlIIllIlIIlllIIIIl, lllllllllllllIIlIIllIlIIlllIIlIl);
        }
        
        @Override
        public boolean add(final int lllllllllllllIIlIIllIlIlIIIllIll) {
            this.l.add(this.to, lllllllllllllIIlIIllIlIlIIIllIll);
            ++this.to;
            assert this.assertRange();
            return true;
        }
        
        @Override
        public boolean addAll(final int lllllllllllllIIlIIllIlIlIIIIlIll, final Collection<? extends Integer> lllllllllllllIIlIIllIlIlIIIIlIlI) {
            this.ensureIndex(lllllllllllllIIlIIllIlIlIIIIlIll);
            this.to += lllllllllllllIIlIIllIlIlIIIIlIlI.size();
            return this.l.addAll(this.from + lllllllllllllIIlIIllIlIlIIIIlIll, lllllllllllllIIlIIllIlIlIIIIlIlI);
        }
    }
}
