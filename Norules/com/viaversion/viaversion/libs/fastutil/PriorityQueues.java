package com.viaversion.viaversion.libs.fastutil;

import java.util.*;
import java.io.*;

public class PriorityQueues
{
    public static final /* synthetic */ EmptyPriorityQueue EMPTY_QUEUE;
    
    public static <K> PriorityQueue<K> emptyQueue() {
        return (PriorityQueue<K>)PriorityQueues.EMPTY_QUEUE;
    }
    
    public static <K> PriorityQueue<K> synchronize(final PriorityQueue<K> lllllllllllllIIllIlIlllIIIIIlIll) {
        return new SynchronizedPriorityQueue<K>(lllllllllllllIIllIlIlllIIIIIlIll);
    }
    
    private PriorityQueues() {
    }
    
    static {
        EMPTY_QUEUE = new EmptyPriorityQueue();
    }
    
    public static <K> PriorityQueue<K> synchronize(final PriorityQueue<K> lllllllllllllIIllIlIlllIIIIIIllI, final Object lllllllllllllIIllIlIlllIIIIIIlIl) {
        return new SynchronizedPriorityQueue<K>(lllllllllllllIIllIlIlllIIIIIIllI, lllllllllllllIIllIlIlllIIIIIIlIl);
    }
    
    public static class EmptyPriorityQueue implements Serializable, PriorityQueue
    {
        @Override
        public void changed() {
            throw new NoSuchElementException();
        }
        
        public Object clone() {
            return PriorityQueues.EMPTY_QUEUE;
        }
        
        @Override
        public int size() {
            return 0;
        }
        
        @Override
        public Object dequeue() {
            throw new NoSuchElementException();
        }
        
        @Override
        public Comparator<?> comparator() {
            return null;
        }
        
        protected EmptyPriorityQueue() {
        }
        
        @Override
        public Object last() {
            throw new NoSuchElementException();
        }
        
        @Override
        public void clear() {
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIIIIlllllIlIllIIlll) {
            return lllllllllllllIIIIlllllIlIllIIlll instanceof PriorityQueue && ((PriorityQueue)lllllllllllllIIIIlllllIlIllIIlll).isEmpty();
        }
        
        @Override
        public void enqueue(final Object lllllllllllllIIIIlllllIlIlllIlII) {
            throw new UnsupportedOperationException();
        }
        
        private Object readResolve() {
            return PriorityQueues.EMPTY_QUEUE;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public boolean isEmpty() {
            return true;
        }
        
        @Override
        public Object first() {
            throw new NoSuchElementException();
        }
    }
    
    public static class SynchronizedPriorityQueue<K> implements PriorityQueue<K>, Serializable
    {
        protected final /* synthetic */ Object sync;
        protected final /* synthetic */ PriorityQueue<K> q;
        
        @Override
        public K last() {
            synchronized (this.sync) {
                return this.q.last();
            }
        }
        
        @Override
        public void changed() {
            synchronized (this.sync) {
                this.q.changed();
            }
        }
        
        @Override
        public String toString() {
            synchronized (this.sync) {
                return this.q.toString();
            }
        }
        
        @Override
        public void enqueue(final K llllllllllllllIlIIllllIlIllIllIl) {
            synchronized (this.sync) {
                this.q.enqueue(llllllllllllllIlIIllllIlIllIllIl);
            }
        }
        
        protected SynchronizedPriorityQueue(final PriorityQueue<K> llllllllllllllIlIIllllIlIllllIlI, final Object llllllllllllllIlIIllllIlIlllllII) {
            this.q = llllllllllllllIlIIllllIlIllllIlI;
            this.sync = llllllllllllllIlIIllllIlIlllllII;
        }
        
        @Override
        public Comparator<? super K> comparator() {
            synchronized (this.sync) {
                return this.q.comparator();
            }
        }
        
        @Override
        public void clear() {
            synchronized (this.sync) {
                this.q.clear();
            }
        }
        
        @Override
        public int hashCode() {
            synchronized (this.sync) {
                return this.q.hashCode();
            }
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIlIIllllIlIIIlllIl) {
            if (llllllllllllllIlIIllllIlIIIlllIl == this) {
                return true;
            }
            synchronized (this.sync) {
                return this.q.equals(llllllllllllllIlIIllllIlIIIlllIl);
            }
        }
        
        @Override
        public K first() {
            synchronized (this.sync) {
                return this.q.first();
            }
        }
        
        private void writeObject(final ObjectOutputStream llllllllllllllIlIIllllIlIIIlIIIl) throws IOException {
            synchronized (this.sync) {
                llllllllllllllIlIIllllIlIIIlIIIl.defaultWriteObject();
            }
        }
        
        @Override
        public int size() {
            synchronized (this.sync) {
                return this.q.size();
            }
        }
        
        @Override
        public K dequeue() {
            synchronized (this.sync) {
                return this.q.dequeue();
            }
        }
        
        protected SynchronizedPriorityQueue(final PriorityQueue<K> llllllllllllllIlIIllllIlIlllIlIl) {
            this.q = llllllllllllllIlIIllllIlIlllIlIl;
            this.sync = this;
        }
        
        @Override
        public boolean isEmpty() {
            synchronized (this.sync) {
                return this.q.isEmpty();
            }
        }
    }
}
