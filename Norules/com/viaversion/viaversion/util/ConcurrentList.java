package com.viaversion.viaversion.util;

import java.util.*;

@Deprecated
public class ConcurrentList<E> extends ArrayList<E>
{
    private final /* synthetic */ Object lock;
    
    @Override
    public void ensureCapacity(final int lllllllllllllllllIlllIllIllllIIl) {
        synchronized (this.lock) {
            super.ensureCapacity(lllllllllllllllllIlllIllIllllIIl);
        }
    }
    
    @Override
    public E set(final int lllllllllllllllllIlllIllIIlIlIlI, final E lllllllllllllllllIlllIllIIlIlIIl) {
        synchronized (this.lock) {
            return super.set(lllllllllllllllllIlllIllIIlIlIlI, lllllllllllllllllIlllIllIIlIlIIl);
        }
    }
    
    @Override
    public boolean removeAll(final Collection<?> lllllllllllllllllIlllIllIIllllll) {
        synchronized (this.lock) {
            return super.removeAll(lllllllllllllllllIlllIllIIllllll);
        }
    }
    
    @Override
    public boolean addAll(final int lllllllllllllllllIlllIlllIIlllII, final Collection<? extends E> lllllllllllllllllIlllIlllIIllllI) {
        synchronized (this.lock) {
            return super.addAll(lllllllllllllllllIlllIlllIIlllII, lllllllllllllllllIlllIlllIIllllI);
        }
    }
    
    @Override
    public boolean retainAll(final Collection<?> lllllllllllllllllIlllIllIIllIIll) {
        synchronized (this.lock) {
            return super.retainAll(lllllllllllllllllIlllIllIIllIIll);
        }
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }
    
    @Override
    public E remove(final int lllllllllllllllllIlllIllIlIlIIll) {
        synchronized (this.lock) {
            return super.remove(lllllllllllllllllIlllIllIlIlIIll);
        }
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> lllllllllllllllllIlllIlllIlIlIII) {
        synchronized (this.lock) {
            return super.addAll(lllllllllllllllllIlllIlllIlIlIII);
        }
    }
    
    @Override
    public boolean remove(final Object lllllllllllllllllIlllIllIlIIlIIl) {
        synchronized (this.lock) {
            return super.remove(lllllllllllllllllIlllIllIlIIlIIl);
        }
    }
    
    @Override
    public Object clone() {
        synchronized (this.lock) {
            return super.clone();
        }
    }
    
    @Override
    public int indexOf(final Object lllllllllllllllllIlllIllIllIIlIl) {
        synchronized (this.lock) {
            return super.indexOf(lllllllllllllllllIlllIllIllIIlIl);
        }
    }
    
    @Override
    public E get(final int lllllllllllllllllIlllIllIlllIIIl) {
        synchronized (this.lock) {
            return super.get(lllllllllllllllllIlllIllIlllIIIl);
        }
    }
    
    public ConcurrentList() {
        this.lock = new Object();
    }
    
    @Override
    public boolean contains(final Object lllllllllllllllllIlllIlllIIIIIll) {
        synchronized (this.lock) {
            return super.contains(lllllllllllllllllIlllIlllIIIIIll);
        }
    }
    
    @Override
    public <T> T[] toArray(final T[] lllllllllllllllllIlllIllIIIIlIlI) {
        synchronized (this.lock) {
            return super.toArray(lllllllllllllllllIlllIllIIIIlIlI);
        }
    }
    
    @Override
    public int lastIndexOf(final Object lllllllllllllllllIlllIllIlIllIll) {
        synchronized (this.lock) {
            return super.lastIndexOf(lllllllllllllllllIlllIllIlIllIll);
        }
    }
    
    @Override
    public List<E> subList(final int lllllllllllllllllIlllIllIIIllIlI, final int lllllllllllllllllIlllIllIIIlllII) {
        synchronized (this.lock) {
            return super.subList(lllllllllllllllllIlllIllIIIllIlI, lllllllllllllllllIlllIllIIIlllII);
        }
    }
    
    @Override
    public void add(final int lllllllllllllllllIlllIlllIllIIll, final E lllllllllllllllllIlllIlllIllIIlI) {
        synchronized (this.lock) {
            super.add(lllllllllllllllllIlllIlllIllIIll, lllllllllllllllllIlllIlllIllIIlI);
        }
    }
    
    @Override
    public boolean add(final E lllllllllllllllllIlllIlllIllllll) {
        synchronized (this.lock) {
            return super.add(lllllllllllllllllIlllIlllIllllll);
        }
    }
    
    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }
    
    @Override
    public void clear() {
        synchronized (this.lock) {
            super.clear();
        }
    }
    
    @Override
    public Object[] toArray() {
        synchronized (this.lock) {
            return super.toArray();
        }
    }
    
    @Override
    public void trimToSize() {
        synchronized (this.lock) {
            super.trimToSize();
        }
    }
    
    private class Itr implements Iterator<E>
    {
        final /* synthetic */ ConcurrentList l;
        protected /* synthetic */ int cursor;
        protected /* synthetic */ int lastRet;
        
        @Override
        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            this.l.remove(this.lastRet);
            ConcurrentList.this.remove(this.lastRet);
            this.cursor = this.lastRet;
            this.lastRet = -1;
        }
        
        public Itr() {
            this.cursor = 0;
            this.lastRet = -1;
            this.l = (ConcurrentList)ConcurrentList.this.clone();
        }
        
        @Override
        public boolean hasNext() {
            return this.cursor < this.l.size();
        }
        
        @Override
        public E next() {
            final int llllllllllllllllIIIIlIllllllIIII = this.cursor;
            if (llllllllllllllllIIIIlIllllllIIII >= this.l.size()) {
                throw new NoSuchElementException();
            }
            this.cursor = llllllllllllllllIIIIlIllllllIIII + 1;
            final ConcurrentList l = this.l;
            final int n = llllllllllllllllIIIIlIllllllIIII;
            this.lastRet = n;
            return l.get(n);
        }
    }
    
    public class ListItr extends Itr implements ListIterator<E>
    {
        @Override
        public void set(final E lllllllllllllIIlIIlllIlIlIlIIlll) {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            this.l.set(this.lastRet, lllllllllllllIIlIIlllIlIlIlIIlll);
            ConcurrentList.this.set(this.lastRet, lllllllllllllIIlIIlllIlIlIlIIlll);
        }
        
        @Override
        public void add(final E lllllllllllllIIlIIlllIlIlIlIIIlI) {
            final int lllllllllllllIIlIIlllIlIlIlIIIIl = this.cursor;
            this.l.add(lllllllllllllIIlIIlllIlIlIlIIIIl, lllllllllllllIIlIIlllIlIlIlIIIlI);
            ConcurrentList.this.add(lllllllllllllIIlIIlllIlIlIlIIIIl, lllllllllllllIIlIIlllIlIlIlIIIlI);
            this.cursor = lllllllllllllIIlIIlllIlIlIlIIIIl + 1;
            this.lastRet = -1;
        }
        
        @Override
        public int nextIndex() {
            return this.cursor;
        }
        
        ListItr(final int lllllllllllllIIlIIlllIlIlIllllll) {
            this.cursor = lllllllllllllIIlIIlllIlIlIllllll;
        }
        
        @Override
        public int previousIndex() {
            return this.cursor - 1;
        }
        
        @Override
        public boolean hasPrevious() {
            return this.cursor > 0;
        }
        
        @Override
        public E previous() {
            final int lllllllllllllIIlIIlllIlIlIlIllll = this.cursor - 1;
            if (lllllllllllllIIlIIlllIlIlIlIllll < 0) {
                throw new NoSuchElementException();
            }
            this.cursor = lllllllllllllIIlIIlllIlIlIlIllll;
            final ConcurrentList l = this.l;
            final int n = lllllllllllllIIlIIlllIlIlIlIllll;
            this.lastRet = n;
            return l.get(n);
        }
    }
}
