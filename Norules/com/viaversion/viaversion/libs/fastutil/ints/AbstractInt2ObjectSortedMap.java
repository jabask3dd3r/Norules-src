package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.objects.*;
import java.util.*;

public abstract class AbstractInt2ObjectSortedMap<V> extends AbstractInt2ObjectMap<V> implements Int2ObjectSortedMap<V>
{
    @Override
    public IntSortedSet keySet() {
        return new KeySet();
    }
    
    protected AbstractInt2ObjectSortedMap() {
    }
    
    @Override
    public ObjectCollection<V> values() {
        return new ValuesCollection();
    }
    
    protected class ValuesCollection extends AbstractObjectCollection<V>
    {
        @Override
        public void clear() {
            AbstractInt2ObjectSortedMap.this.clear();
        }
        
        @Override
        public ObjectIterator<V> iterator() {
            return new ValuesIterator<V>((ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>>)Int2ObjectSortedMaps.fastIterator((Int2ObjectSortedMap<V>)AbstractInt2ObjectSortedMap.this));
        }
        
        @Override
        public int size() {
            return AbstractInt2ObjectSortedMap.this.size();
        }
        
        @Override
        public boolean contains(final Object llllllllllllllIIIlIIIlIIlllIlllI) {
            return AbstractInt2ObjectSortedMap.this.containsValue(llllllllllllllIIIlIIIlIIlllIlllI);
        }
    }
    
    protected static class ValuesIterator<V> implements ObjectIterator<V>
    {
        protected final /* synthetic */ ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> i;
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
        
        @Override
        public V next() {
            return (V)this.i.next().getValue();
        }
        
        public ValuesIterator(final ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> lllllllllllllllIIIlllIIlIlIIllll) {
            this.i = lllllllllllllllIIIlllIIlIlIIllll;
        }
    }
    
    protected class KeySet extends AbstractIntSortedSet
    {
        @Override
        public void clear() {
            AbstractInt2ObjectSortedMap.this.clear();
        }
        
        @Override
        public int lastInt() {
            return AbstractInt2ObjectSortedMap.this.lastIntKey();
        }
        
        @Override
        public int size() {
            return AbstractInt2ObjectSortedMap.this.size();
        }
        
        @Override
        public int firstInt() {
            return AbstractInt2ObjectSortedMap.this.firstIntKey();
        }
        
        @Override
        public IntComparator comparator() {
            return AbstractInt2ObjectSortedMap.this.comparator();
        }
        
        @Override
        public IntBidirectionalIterator iterator(final int llllllllllllllIllllIllllIlllIIlI) {
            return new KeySetIterator<Object>((ObjectBidirectionalIterator<Int2ObjectMap.Entry<?>>)AbstractInt2ObjectSortedMap.this.int2ObjectEntrySet().iterator((Int2ObjectMap.Entry<V>)new BasicEntry<Object>(llllllllllllllIllllIllllIlllIIlI, null)));
        }
        
        @Override
        public IntSortedSet headSet(final int llllllllllllllIllllIlllllIIIlIIl) {
            return AbstractInt2ObjectSortedMap.this.headMap(llllllllllllllIllllIlllllIIIlIIl).keySet();
        }
        
        @Override
        public IntSortedSet tailSet(final int llllllllllllllIllllIlllllIIIIIIl) {
            return AbstractInt2ObjectSortedMap.this.tailMap(llllllllllllllIllllIlllllIIIIIIl).keySet();
        }
        
        @Override
        public IntBidirectionalIterator iterator() {
            return new KeySetIterator<Object>((ObjectBidirectionalIterator<Int2ObjectMap.Entry<?>>)Int2ObjectSortedMaps.fastIterator((Int2ObjectSortedMap<V>)AbstractInt2ObjectSortedMap.this));
        }
        
        @Override
        public boolean contains(final int llllllllllllllIllllIlllllIIllllI) {
            return AbstractInt2ObjectSortedMap.this.containsKey(llllllllllllllIllllIlllllIIllllI);
        }
        
        @Override
        public IntSortedSet subSet(final int llllllllllllllIllllIllllIllllIIl, final int llllllllllllllIllllIllllIllllIll) {
            return AbstractInt2ObjectSortedMap.this.subMap(llllllllllllllIllllIllllIllllIIl, llllllllllllllIllllIllllIllllIll).keySet();
        }
    }
    
    protected static class KeySetIterator<V> implements IntBidirectionalIterator
    {
        protected final /* synthetic */ ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> i;
        
        @Override
        public boolean hasPrevious() {
            return this.i.hasPrevious();
        }
        
        @Override
        public int previousInt() {
            return this.i.previous().getIntKey();
        }
        
        @Override
        public int nextInt() {
            return this.i.next().getIntKey();
        }
        
        public KeySetIterator(final ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> lllllllllllllIlIIlIIlIIlllIIIIll) {
            this.i = lllllllllllllIlIIlIIlIIlllIIIIll;
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
    }
}
