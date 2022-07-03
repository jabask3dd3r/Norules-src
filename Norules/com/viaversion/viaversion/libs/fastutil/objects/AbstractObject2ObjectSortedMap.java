package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public abstract class AbstractObject2ObjectSortedMap<K, V> extends AbstractObject2ObjectMap<K, V> implements Object2ObjectSortedMap<K, V>
{
    @Override
    public ObjectSortedSet<K> keySet() {
        return new KeySet();
    }
    
    protected AbstractObject2ObjectSortedMap() {
    }
    
    @Override
    public ObjectCollection<V> values() {
        return new ValuesCollection();
    }
    
    protected static class KeySetIterator<K, V> implements ObjectBidirectionalIterator<K>
    {
        protected final /* synthetic */ ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> i;
        
        @Override
        public K previous() {
            return this.i.previous().getKey();
        }
        
        @Override
        public boolean hasPrevious() {
            return this.i.hasPrevious();
        }
        
        @Override
        public K next() {
            return this.i.next().getKey();
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
        
        public KeySetIterator(final ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> lllllllllllllIlIIlIIlIIIlllIIlIl) {
            this.i = lllllllllllllIlIIlIIlIIIlllIIlIl;
        }
    }
    
    protected class KeySet extends AbstractObjectSortedSet<K>
    {
        @Override
        public K last() {
            return AbstractObject2ObjectSortedMap.this.lastKey();
        }
        
        @Override
        public ObjectSortedSet<K> tailSet(final K lllllllllllllIIllIllIlIlIllIIlIl) {
            return AbstractObject2ObjectSortedMap.this.tailMap(lllllllllllllIIllIllIlIlIllIIlIl).keySet();
        }
        
        @Override
        public ObjectBidirectionalIterator<K> iterator(final K lllllllllllllIIllIllIlIlIlIlIllI) {
            return new KeySetIterator<K, Object>((ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, ?>>)AbstractObject2ObjectSortedMap.this.object2ObjectEntrySet().iterator((Object2ObjectMap.Entry<K, V>)new BasicEntry<Object, Object>((K)lllllllllllllIIllIllIlIlIlIlIllI, null)));
        }
        
        @Override
        public K first() {
            return AbstractObject2ObjectSortedMap.this.firstKey();
        }
        
        @Override
        public int size() {
            return AbstractObject2ObjectSortedMap.this.size();
        }
        
        @Override
        public ObjectBidirectionalIterator<K> iterator() {
            return new KeySetIterator<K, Object>((ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, ?>>)Object2ObjectSortedMaps.fastIterator((Object2ObjectSortedMap<K, V>)AbstractObject2ObjectSortedMap.this));
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIIllIllIlIllIIIIIII) {
            return AbstractObject2ObjectSortedMap.this.containsKey(lllllllllllllIIllIllIlIllIIIIIII);
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return AbstractObject2ObjectSortedMap.this.comparator();
        }
        
        @Override
        public ObjectSortedSet<K> subSet(final K lllllllllllllIIllIllIlIlIlIlllIl, final K lllllllllllllIIllIllIlIlIlIlllII) {
            return AbstractObject2ObjectSortedMap.this.subMap(lllllllllllllIIllIllIlIlIlIlllIl, lllllllllllllIIllIllIlIlIlIlllII).keySet();
        }
        
        @Override
        public ObjectSortedSet<K> headSet(final K lllllllllllllIIllIllIlIlIllIllIl) {
            return AbstractObject2ObjectSortedMap.this.headMap(lllllllllllllIIllIllIlIlIllIllIl).keySet();
        }
        
        @Override
        public void clear() {
            AbstractObject2ObjectSortedMap.this.clear();
        }
    }
    
    protected static class ValuesIterator<K, V> implements ObjectIterator<V>
    {
        protected final /* synthetic */ ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> i;
        
        public ValuesIterator(final ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> llllllllllllllIlIIIlIlIllllllllI) {
            this.i = llllllllllllllIlIIIlIlIllllllllI;
        }
        
        @Override
        public V next() {
            return this.i.next().getValue();
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
    }
    
    protected class ValuesCollection extends AbstractObjectCollection<V>
    {
        @Override
        public int size() {
            return AbstractObject2ObjectSortedMap.this.size();
        }
        
        @Override
        public boolean contains(final Object llllllllllllllIIIIlIIllllIIlIlll) {
            return AbstractObject2ObjectSortedMap.this.containsValue(llllllllllllllIIIIlIIllllIIlIlll);
        }
        
        @Override
        public ObjectIterator<V> iterator() {
            return new ValuesIterator<Object, V>((ObjectBidirectionalIterator<Object2ObjectMap.Entry<?, V>>)Object2ObjectSortedMaps.fastIterator((Object2ObjectSortedMap<K, V>)AbstractObject2ObjectSortedMap.this));
        }
        
        @Override
        public void clear() {
            AbstractObject2ObjectSortedMap.this.clear();
        }
    }
}
