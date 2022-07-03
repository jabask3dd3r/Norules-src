package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public abstract class AbstractInt2IntMap extends AbstractInt2IntFunction implements Serializable, Int2IntMap
{
    @Override
    public boolean containsValue(final int llllllIIIIlIll) {
        return this.values().contains(llllllIIIIlIll);
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllIllIIlIII = new StringBuilder();
        final ObjectIterator<Entry> lllllIllIIIlll = Int2IntMaps.fastIterator(this);
        int lllllIllIIIllI = this.size();
        boolean lllllIllIIIlIl = true;
        lllllIllIIlIII.append("{");
        while (lllllIllIIIllI-- != 0) {
            if (lllllIllIIIlIl) {
                lllllIllIIIlIl = false;
            }
            else {
                lllllIllIIlIII.append(", ");
            }
            final Entry lllllIllIIlIlI = lllllIllIIIlll.next();
            lllllIllIIlIII.append(String.valueOf(lllllIllIIlIlI.getIntKey()));
            lllllIllIIlIII.append("=>");
            lllllIllIIlIII.append(String.valueOf(lllllIllIIlIlI.getIntValue()));
        }
        lllllIllIIlIII.append("}");
        return String.valueOf(lllllIllIIlIII);
    }
    
    @Override
    public IntCollection values() {
        return new AbstractIntCollection() {
            @Override
            public int size() {
                return AbstractInt2IntMap.this.size();
            }
            
            @Override
            public void clear() {
                AbstractInt2IntMap.this.clear();
            }
            
            @Override
            public boolean contains(final int lllllllllllllIIIIlIlIlIIIIIlIIII) {
                return AbstractInt2IntMap.this.containsValue(lllllllllllllIIIIlIlIlIIIIIlIIII);
            }
            
            @Override
            public IntIterator iterator() {
                return new IntIterator() {
                    private final /* synthetic */ ObjectIterator<Entry> i = Int2IntMaps.fastIterator(AbstractInt2IntMap.this);
                    
                    @Override
                    public boolean hasNext() {
                        return this.i.hasNext();
                    }
                    
                    @Override
                    public int nextInt() {
                        return this.i.next().getIntValue();
                    }
                };
            }
        };
    }
    
    @Override
    public IntSet keySet() {
        return new AbstractIntSet() {
            @Override
            public IntIterator iterator() {
                return new IntIterator() {
                    private final /* synthetic */ ObjectIterator<Entry> i = Int2IntMaps.fastIterator(AbstractInt2IntMap.this);
                    
                    @Override
                    public boolean hasNext() {
                        return this.i.hasNext();
                    }
                    
                    @Override
                    public int nextInt() {
                        return this.i.next().getIntKey();
                    }
                    
                    @Override
                    public void remove() {
                        this.i.remove();
                    }
                };
            }
            
            @Override
            public int size() {
                return AbstractInt2IntMap.this.size();
            }
            
            @Override
            public boolean contains(final int lllllllllllllllIllIIllIIIllIIIII) {
                return AbstractInt2IntMap.this.containsKey(lllllllllllllllIllIIllIIIllIIIII);
            }
            
            @Override
            public void clear() {
                AbstractInt2IntMap.this.clear();
            }
        };
    }
    
    @Override
    public void putAll(final Map<? extends Integer, ? extends Integer> lllllIlllIlIIl) {
        if (lllllIlllIlIIl instanceof Int2IntMap) {
            final ObjectIterator<Entry> lllllIllllIIII = Int2IntMaps.fastIterator((Int2IntMap)lllllIlllIlIIl);
            while (lllllIllllIIII.hasNext()) {
                final Entry lllllIllllIIIl = lllllIllllIIII.next();
                this.put(lllllIllllIIIl.getIntKey(), lllllIllllIIIl.getIntValue());
            }
        }
        else {
            int lllllIlllIllll = lllllIlllIlIIl.size();
            final Iterator<? extends Map.Entry<? extends Integer, ? extends Integer>> lllllIlllIlllI = lllllIlllIlIIl.entrySet().iterator();
            while (lllllIlllIllll-- != 0) {
                final Map.Entry<? extends Integer, ? extends Integer> lllllIlllIllIl = (Map.Entry<? extends Integer, ? extends Integer>)lllllIlllIlllI.next();
                this.put((Integer)lllllIlllIllIl.getKey(), (Integer)lllllIlllIllIl.getValue());
            }
        }
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public boolean containsKey(final int llllllIIIIIIIl) {
        final ObjectIterator<Entry> llllllIIIIIIll = this.int2IntEntrySet().iterator();
        while (llllllIIIIIIll.hasNext()) {
            if (llllllIIIIIIll.next().getIntKey() == llllllIIIIIIIl) {
                return true;
            }
        }
        return false;
    }
    
    protected AbstractInt2IntMap() {
    }
    
    @Override
    public boolean equals(final Object lllllIllIlIIlI) {
        if (lllllIllIlIIlI == this) {
            return true;
        }
        if (!(lllllIllIlIIlI instanceof Map)) {
            return false;
        }
        final Map<?, ?> lllllIllIlIlII = (Map<?, ?>)lllllIllIlIIlI;
        return lllllIllIlIlII.size() == this.size() && this.int2IntEntrySet().containsAll(lllllIllIlIlII.entrySet());
    }
    
    @Override
    public int hashCode() {
        int lllllIlllIIIII = 0;
        int lllllIllIlllll = this.size();
        final ObjectIterator<Entry> lllllIllIllllI = Int2IntMaps.fastIterator(this);
        while (lllllIllIlllll-- != 0) {
            lllllIlllIIIII += lllllIllIllllI.next().hashCode();
        }
        return lllllIlllIIIII;
    }
    
    public static class BasicEntry implements Entry
    {
        protected /* synthetic */ int key;
        protected /* synthetic */ int value;
        
        public BasicEntry(final Integer lllllllllllllIIllllllIlllllIIIIl, final Integer lllllllllllllIIllllllIlllllIIIll) {
            this.key = lllllllllllllIIllllllIlllllIIIIl;
            this.value = lllllllllllllIIllllllIlllllIIIll;
        }
        
        @Override
        public int setValue(final int lllllllllllllIIllllllIllllIIllll) {
            throw new UnsupportedOperationException();
        }
        
        public BasicEntry(final int lllllllllllllIIllllllIllllIllIII, final int lllllllllllllIIllllllIllllIllIlI) {
            this.key = lllllllllllllIIllllllIllllIllIII;
            this.value = lllllllllllllIIllllllIllllIllIlI;
        }
        
        @Override
        public int hashCode() {
            return this.key ^ this.value;
        }
        
        @Override
        public int getIntKey() {
            return this.key;
        }
        
        public BasicEntry() {
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIIllllllIllllIIIIlI) {
            if (!(lllllllllllllIIllllllIllllIIIIlI instanceof Map.Entry)) {
                return false;
            }
            if (lllllllllllllIIllllllIllllIIIIlI instanceof Entry) {
                final Entry lllllllllllllIIllllllIllllIIlIIl = (Entry)lllllllllllllIIllllllIllllIIIIlI;
                return this.key == lllllllllllllIIllllllIllllIIlIIl.getIntKey() && this.value == lllllllllllllIIllllllIllllIIlIIl.getIntValue();
            }
            final Map.Entry<?, ?> lllllllllllllIIllllllIllllIIIllI = (Map.Entry<?, ?>)lllllllllllllIIllllllIllllIIIIlI;
            final Object lllllllllllllIIllllllIllllIIIlIl = lllllllllllllIIllllllIllllIIIllI.getKey();
            if (lllllllllllllIIllllllIllllIIIlIl == null || !(lllllllllllllIIllllllIllllIIIlIl instanceof Integer)) {
                return false;
            }
            final Object lllllllllllllIIllllllIllllIIIlII = lllllllllllllIIllllllIllllIIIllI.getValue();
            return lllllllllllllIIllllllIllllIIIlII != null && lllllllllllllIIllllllIllllIIIlII instanceof Integer && this.key == (int)lllllllllllllIIllllllIllllIIIlIl && this.value == (int)lllllllllllllIIllllllIllllIIIlII;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(this.key).append("->").append(this.value));
        }
        
        @Override
        public int getIntValue() {
            return this.value;
        }
    }
    
    public abstract static class BasicEntrySet extends AbstractObjectSet<Entry>
    {
        protected final /* synthetic */ Int2IntMap map;
        
        @Override
        public boolean remove(final Object lllllllllllllllIlIllIIllIIIIlIII) {
            if (!(lllllllllllllllIlIllIIllIIIIlIII instanceof Map.Entry)) {
                return false;
            }
            if (lllllllllllllllIlIllIIllIIIIlIII instanceof Entry) {
                final Entry lllllllllllllllIlIllIIllIIIlIIIl = (Entry)lllllllllllllllIlIllIIllIIIIlIII;
                return this.map.remove(lllllllllllllllIlIllIIllIIIlIIIl.getIntKey(), lllllllllllllllIlIllIIllIIIlIIIl.getIntValue());
            }
            final Map.Entry<?, ?> lllllllllllllllIlIllIIllIIIIlllI = (Map.Entry<?, ?>)lllllllllllllllIlIllIIllIIIIlIII;
            final Object lllllllllllllllIlIllIIllIIIIllIl = lllllllllllllllIlIllIIllIIIIlllI.getKey();
            if (lllllllllllllllIlIllIIllIIIIllIl == null || !(lllllllllllllllIlIllIIllIIIIllIl instanceof Integer)) {
                return false;
            }
            final int lllllllllllllllIlIllIIllIIIIllII = (int)lllllllllllllllIlIllIIllIIIIllIl;
            final Object lllllllllllllllIlIllIIllIIIIlIll = lllllllllllllllIlIllIIllIIIIlllI.getValue();
            if (lllllllllllllllIlIllIIllIIIIlIll == null || !(lllllllllllllllIlIllIIllIIIIlIll instanceof Integer)) {
                return false;
            }
            final int lllllllllllllllIlIllIIllIIIIlIlI = (int)lllllllllllllllIlIllIIllIIIIlIll;
            return this.map.remove(lllllllllllllllIlIllIIllIIIIllII, lllllllllllllllIlIllIIllIIIIlIlI);
        }
        
        @Override
        public boolean contains(final Object lllllllllllllllIlIllIIllIIlIIIll) {
            if (!(lllllllllllllllIlIllIIllIIlIIIll instanceof Map.Entry)) {
                return false;
            }
            if (lllllllllllllllIlIllIIllIIlIIIll instanceof Entry) {
                final Entry lllllllllllllllIlIllIIllIIlIIllI = (Entry)lllllllllllllllIlIllIIllIIlIIIll;
                final int lllllllllllllllIlIllIIllIIlIIlIl = lllllllllllllllIlIllIIllIIlIIllI.getIntKey();
                return this.map.containsKey(lllllllllllllllIlIllIIllIIlIIlIl) && this.map.get(lllllllllllllllIlIllIIllIIlIIlIl) == lllllllllllllllIlIllIIllIIlIIllI.getIntValue();
            }
            final Map.Entry<?, ?> lllllllllllllllIlIllIIllIIlIIIlI = (Map.Entry<?, ?>)lllllllllllllllIlIllIIllIIlIIIll;
            final Object lllllllllllllllIlIllIIllIIlIIIIl = lllllllllllllllIlIllIIllIIlIIIlI.getKey();
            if (lllllllllllllllIlIllIIllIIlIIIIl == null || !(lllllllllllllllIlIllIIllIIlIIIIl instanceof Integer)) {
                return false;
            }
            final int lllllllllllllllIlIllIIllIIlIIIII = (int)lllllllllllllllIlIllIIllIIlIIIIl;
            final Object lllllllllllllllIlIllIIllIIIlllll = lllllllllllllllIlIllIIllIIlIIIlI.getValue();
            return lllllllllllllllIlIllIIllIIIlllll != null && lllllllllllllllIlIllIIllIIIlllll instanceof Integer && this.map.containsKey(lllllllllllllllIlIllIIllIIlIIIII) && this.map.get(lllllllllllllllIlIllIIllIIlIIIII) == (int)lllllllllllllllIlIllIIllIIIlllll;
        }
        
        public BasicEntrySet(final Int2IntMap lllllllllllllllIlIllIIllIIlIllIl) {
            this.map = lllllllllllllllIlIllIIllIIlIllIl;
        }
        
        @Override
        public int size() {
            return this.map.size();
        }
    }
}
