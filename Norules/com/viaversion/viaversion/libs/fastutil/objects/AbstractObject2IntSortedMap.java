package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;

public abstract class AbstractObject2IntSortedMap<K> extends AbstractObject2IntMap<K> implements Object2IntSortedMap<K>
{
    protected AbstractObject2IntSortedMap() {
    }
    
    @Override
    public IntCollection values() {
        return new ValuesCollection();
    }
    
    @Override
    public ObjectSortedSet<K> keySet() {
        return new KeySet();
    }
    
    protected static class KeySetIterator<K> implements ObjectBidirectionalIterator<K>
    {
        protected final /* synthetic */ ObjectBidirectionalIterator<Object2IntMap.Entry<K>> i;
        
        @Override
        public K next() {
            return (K)this.i.next().getKey();
        }
        
        public KeySetIterator(final ObjectBidirectionalIterator<Object2IntMap.Entry<K>> lllllllllllllIllIIlIlllllIlIlllI) {
            this.i = lllllllllllllIllIIlIlllllIlIlllI;
        }
        
        @Override
        public K previous() {
            return (K)this.i.previous().getKey();
        }
        
        @Override
        public boolean hasPrevious() {
            return this.i.hasPrevious();
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
    }
    
    protected static class ValuesIterator<K> implements IntIterator
    {
        protected final /* synthetic */ ObjectBidirectionalIterator<Object2IntMap.Entry<K>> i;
        
        public ValuesIterator(final ObjectBidirectionalIterator<Object2IntMap.Entry<K>> lllllllllllllIIlIlIIlIIIllIIlIIl) {
            this.i = lllllllllllllIIlIlIIlIIIllIIlIIl;
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
        
        @Override
        public int nextInt() {
            return this.i.next().getIntValue();
        }
    }
    
    protected class ValuesCollection extends AbstractIntCollection
    {
        @Override
        public boolean contains(final int lllllllllllllllIlIlllIIIlllllIlI) {
            return AbstractObject2IntSortedMap.this.containsValue(lllllllllllllllIlIlllIIIlllllIlI);
        }
        
        @Override
        public IntIterator iterator() {
            return new ValuesIterator<Object>((ObjectBidirectionalIterator<Object2IntMap.Entry<?>>)Object2IntSortedMaps.fastIterator((Object2IntSortedMap<K>)AbstractObject2IntSortedMap.this));
        }
        
        @Override
        public void clear() {
            AbstractObject2IntSortedMap.this.clear();
        }
        
        @Override
        public int size() {
            return AbstractObject2IntSortedMap.this.size();
        }
    }
    
    protected class KeySet extends AbstractObjectSortedSet<K>
    {
        @Override
        public void clear() {
            AbstractObject2IntSortedMap.this.clear();
        }
        
        @Override
        public ObjectBidirectionalIterator<K> iterator(final K lllllllllllllIllIllIIIIlllIIIIIl) {
            return new KeySetIterator<K>((ObjectBidirectionalIterator<Object2IntMap.Entry<K>>)AbstractObject2IntSortedMap.this.object2IntEntrySet().iterator((Object2IntMap.Entry<K>)new BasicEntry<Object>((K)lllllllllllllIllIllIIIIlllIIIIIl, 0)));
        }
        
        @Override
        public K last() {
            return AbstractObject2IntSortedMap.this.lastKey();
        }
        
        @Override
        public ObjectSortedSet<K> subSet(final K lllllllllllllIllIllIIIIlllIIlIIl, final K lllllllllllllIllIllIIIIlllIIIlIl) {
            return AbstractObject2IntSortedMap.this.subMap(lllllllllllllIllIllIIIIlllIIlIIl, lllllllllllllIllIllIIIIlllIIIlIl).keySet();
        }
        
        @Override
        public K first() {
            return AbstractObject2IntSortedMap.this.firstKey();
        }
        
        @Override
        public ObjectSortedSet<K> tailSet(final K lllllllllllllIllIllIIIIlllIIlllI) {
            return AbstractObject2IntSortedMap.this.tailMap(lllllllllllllIllIllIIIIlllIIlllI).keySet();
        }
        
        @Override
        public ObjectSortedSet<K> headSet(final K lllllllllllllIllIllIIIIlllIlIlII) {
            return AbstractObject2IntSortedMap.this.headMap(lllllllllllllIllIllIIIIlllIlIlII).keySet();
        }
        
        @Override
        public ObjectBidirectionalIterator<K> iterator() {
            return new KeySetIterator<K>((ObjectBidirectionalIterator<Object2IntMap.Entry<K>>)Object2IntSortedMaps.fastIterator((Object2IntSortedMap<K>)AbstractObject2IntSortedMap.this));
        }
        
        @Override
        public int size() {
            return AbstractObject2IntSortedMap.this.size();
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return AbstractObject2IntSortedMap.this.comparator();
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIllIllIIIIllllIlIIl) {
            return AbstractObject2IntSortedMap.this.containsKey(lllllllllllllIllIllIIIIllllIlIIl);
        }
    }
}
