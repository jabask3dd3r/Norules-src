package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public abstract class AbstractInt2IntSortedMap extends AbstractInt2IntMap implements Int2IntSortedMap
{
    @Override
    public IntSortedSet keySet() {
        return new KeySet();
    }
    
    protected AbstractInt2IntSortedMap() {
    }
    
    @Override
    public IntCollection values() {
        return new ValuesCollection();
    }
    
    protected class KeySet extends AbstractIntSortedSet
    {
        @Override
        public IntSortedSet headSet(final int lllllllllllllllIIIlIlllIllIlIlIl) {
            return AbstractInt2IntSortedMap.this.headMap(lllllllllllllllIIIlIlllIllIlIlIl).keySet();
        }
        
        @Override
        public int firstInt() {
            return AbstractInt2IntSortedMap.this.firstIntKey();
        }
        
        @Override
        public IntBidirectionalIterator iterator() {
            return new KeySetIterator(Int2IntSortedMaps.fastIterator(AbstractInt2IntSortedMap.this));
        }
        
        @Override
        public IntComparator comparator() {
            return AbstractInt2IntSortedMap.this.comparator();
        }
        
        @Override
        public boolean contains(final int lllllllllllllllIIIlIlllIlllIlIlI) {
            return AbstractInt2IntSortedMap.this.containsKey(lllllllllllllllIIIlIlllIlllIlIlI);
        }
        
        @Override
        public IntSortedSet subSet(final int lllllllllllllllIIIlIlllIllIIlIII, final int lllllllllllllllIIIlIlllIllIIIlII) {
            return AbstractInt2IntSortedMap.this.subMap(lllllllllllllllIIIlIlllIllIIlIII, lllllllllllllllIIIlIlllIllIIIlII).keySet();
        }
        
        @Override
        public IntBidirectionalIterator iterator(final int lllllllllllllllIIIlIlllIlIlllllI) {
            return new KeySetIterator((ObjectBidirectionalIterator<Int2IntMap.Entry>)AbstractInt2IntSortedMap.this.int2IntEntrySet().iterator(new BasicEntry(lllllllllllllllIIIlIlllIlIlllllI, 0)));
        }
        
        @Override
        public int size() {
            return AbstractInt2IntSortedMap.this.size();
        }
        
        @Override
        public void clear() {
            AbstractInt2IntSortedMap.this.clear();
        }
        
        @Override
        public int lastInt() {
            return AbstractInt2IntSortedMap.this.lastIntKey();
        }
        
        @Override
        public IntSortedSet tailSet(final int lllllllllllllllIIIlIlllIllIIllIl) {
            return AbstractInt2IntSortedMap.this.tailMap(lllllllllllllllIIIlIlllIllIIllIl).keySet();
        }
    }
    
    protected static class KeySetIterator implements IntBidirectionalIterator
    {
        protected final /* synthetic */ ObjectBidirectionalIterator<Int2IntMap.Entry> i;
        
        public KeySetIterator(final ObjectBidirectionalIterator<Int2IntMap.Entry> llllllllllllIllllllIIllllIIllIll) {
            this.i = llllllllllllIllllllIIllllIIllIll;
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
        
        @Override
        public int previousInt() {
            return this.i.previous().getIntKey();
        }
        
        @Override
        public boolean hasPrevious() {
            return this.i.hasPrevious();
        }
        
        @Override
        public int nextInt() {
            return this.i.next().getIntKey();
        }
    }
    
    protected class ValuesCollection extends AbstractIntCollection
    {
        @Override
        public int size() {
            return AbstractInt2IntSortedMap.this.size();
        }
        
        @Override
        public boolean contains(final int llllllllllllllIIIlIIIIllllIIlllI) {
            return AbstractInt2IntSortedMap.this.containsValue(llllllllllllllIIIlIIIIllllIIlllI);
        }
        
        @Override
        public IntIterator iterator() {
            return new ValuesIterator(Int2IntSortedMaps.fastIterator(AbstractInt2IntSortedMap.this));
        }
        
        @Override
        public void clear() {
            AbstractInt2IntSortedMap.this.clear();
        }
    }
    
    protected static class ValuesIterator implements IntIterator
    {
        protected final /* synthetic */ ObjectBidirectionalIterator<Int2IntMap.Entry> i;
        
        @Override
        public int nextInt() {
            return this.i.next().getIntValue();
        }
        
        public ValuesIterator(final ObjectBidirectionalIterator<Int2IntMap.Entry> llllllllllllllIlIlllllIllllIIllI) {
            this.i = llllllllllllllIlIlllllIllllIIllI;
        }
        
        @Override
        public boolean hasNext() {
            return this.i.hasNext();
        }
    }
}
