package com.viaversion.viaversion.libs.fastutil;

import java.util.*;

public class IndirectPriorityQueues
{
    static {
        EMPTY_QUEUE = new EmptyIndirectPriorityQueue();
    }
    
    public static <K> IndirectPriorityQueue<K> synchronize(final IndirectPriorityQueue<K> lllllllllllllllllIllIIIllIllIlII, final Object lllllllllllllllllIllIIIllIllIIIl) {
        return new SynchronizedIndirectPriorityQueue<K>(lllllllllllllllllIllIIIllIllIlII, lllllllllllllllllIllIIIllIllIIIl);
    }
    
    private IndirectPriorityQueues() {
    }
    
    public static <K> IndirectPriorityQueue<K> synchronize(final IndirectPriorityQueue<K> lllllllllllllllllIllIIIllIlllIII) {
        return new SynchronizedIndirectPriorityQueue<K>(lllllllllllllllllIllIIIllIlllIII);
    }
    
    public static class SynchronizedIndirectPriorityQueue<K> implements IndirectPriorityQueue<K>
    {
        protected final /* synthetic */ IndirectPriorityQueue<K> q;
        protected final /* synthetic */ Object sync;
        
        @Override
        public Comparator<? super K> comparator() {
            synchronized (this.sync) {
                return this.q.comparator();
            }
        }
        
        @Override
        public int last() {
            synchronized (this.sync) {
                return this.q.last();
            }
        }
        
        protected SynchronizedIndirectPriorityQueue(final IndirectPriorityQueue<K> llllllllllllllIllllIlIllllllIIll, final Object llllllllllllllIllllIlIllllllIIlI) {
            this.q = llllllllllllllIllllIlIllllllIIll;
            this.sync = llllllllllllllIllllIlIllllllIIlI;
        }
        
        @Override
        public boolean remove(final int llllllllllllllIllllIlIlllIIlIIII) {
            synchronized (this.sync) {
                return this.q.remove(llllllllllllllIllllIlIlllIIlIIII);
            }
        }
        
        @Override
        public int dequeue() {
            synchronized (this.sync) {
                return this.q.dequeue();
            }
        }
        
        @Override
        public int front(final int[] llllllllllllllIllllIlIlllIIIIIIl) {
            return this.q.front(llllllllllllllIllllIlIlllIIIIIIl);
        }
        
        @Override
        public void clear() {
            synchronized (this.sync) {
                this.q.clear();
            }
        }
        
        @Override
        public boolean contains(final int llllllllllllllIllllIlIllllIlIIll) {
            synchronized (this.sync) {
                return this.q.contains(llllllllllllllIllllIlIllllIlIIll);
            }
        }
        
        @Override
        public void changed(final int llllllllllllllIllllIlIlllIIllIlI) {
            synchronized (this.sync) {
                this.q.changed(llllllllllllllIllllIlIlllIIllIlI);
            }
        }
        
        @Override
        public int size() {
            synchronized (this.sync) {
                return this.q.size();
            }
        }
        
        @Override
        public void changed() {
            synchronized (this.sync) {
                this.q.changed();
            }
        }
        
        @Override
        public boolean isEmpty() {
            synchronized (this.sync) {
                return this.q.isEmpty();
            }
        }
        
        @Override
        public void allChanged() {
            synchronized (this.sync) {
                this.q.allChanged();
            }
        }
        
        @Override
        public int first() {
            synchronized (this.sync) {
                return this.q.first();
            }
        }
        
        protected SynchronizedIndirectPriorityQueue(final IndirectPriorityQueue<K> llllllllllllllIllllIlIlllllIlllI) {
            this.q = llllllllllllllIllllIlIlllllIlllI;
            this.sync = this;
        }
        
        @Override
        public void enqueue(final int llllllllllllllIllllIlIlllllIIlII) {
            synchronized (this.sync) {
                this.q.enqueue(llllllllllllllIllllIlIlllllIIlII);
            }
        }
    }
    
    public static class EmptyIndirectPriorityQueue implements IndirectPriorityQueue
    {
        @Override
        public void clear() {
        }
        
        @Override
        public int size() {
            return 0;
        }
        
        @Override
        public void allChanged() {
        }
        
        @Override
        public boolean contains(final int lllllllllllllllIIIIIlIIIlIIlIIII) {
            return false;
        }
        
        @Override
        public int last() {
            throw new NoSuchElementException();
        }
        
        @Override
        public void enqueue(final int lllllllllllllllIIIIIlIIIlIIlIlIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Comparator<?> comparator() {
            return null;
        }
        
        protected EmptyIndirectPriorityQueue() {
        }
        
        @Override
        public boolean remove(final int lllllllllllllllIIIIIlIIIlIIIIlII) {
            return false;
        }
        
        @Override
        public void changed(final int lllllllllllllllIIIIIlIIIlIIIIlll) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Index ").append(lllllllllllllllIIIIIlIIIlIIIIlll).append(" is not in the queue")));
        }
        
        @Override
        public int dequeue() {
            throw new NoSuchElementException();
        }
        
        @Override
        public int front(final int[] lllllllllllllllIIIIIlIIIlIIIIIlI) {
            return 0;
        }
        
        @Override
        public void changed() {
            throw new NoSuchElementException();
        }
        
        @Override
        public boolean isEmpty() {
            return true;
        }
        
        @Override
        public int first() {
            throw new NoSuchElementException();
        }
    }
}
