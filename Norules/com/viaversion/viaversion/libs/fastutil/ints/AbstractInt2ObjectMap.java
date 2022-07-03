package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public abstract class AbstractInt2ObjectMap<V> extends AbstractInt2ObjectFunction<V> implements Int2ObjectMap<V>, Serializable
{
    @Override
    public boolean equals(final Object lllllllllllllIIIlIlIIlIlIIlIIllI) {
        if (lllllllllllllIIIlIlIIlIlIIlIIllI == this) {
            return true;
        }
        if (!(lllllllllllllIIIlIlIIlIlIIlIIllI instanceof Map)) {
            return false;
        }
        final Map<?, ?> lllllllllllllIIIlIlIIlIlIIlIIlIl = (Map<?, ?>)lllllllllllllIIIlIlIIlIlIIlIIllI;
        return lllllllllllllIIIlIlIIlIlIIlIIlIl.size() == this.size() && this.int2ObjectEntrySet().containsAll(lllllllllllllIIIlIlIIlIlIIlIIlIl.entrySet());
    }
    
    @Override
    public boolean containsKey(final int lllllllllllllIIIlIlIIlIlIlIlIlIl) {
        final ObjectIterator<Entry<V>> lllllllllllllIIIlIlIIlIlIlIlIlII = this.int2ObjectEntrySet().iterator();
        while (lllllllllllllIIIlIlIIlIlIlIlIlII.hasNext()) {
            if (lllllllllllllIIIlIlIIlIlIlIlIlII.next().getIntKey() == lllllllllllllIIIlIlIIlIlIlIlIlIl) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void putAll(final Map<? extends Integer, ? extends V> lllllllllllllIIIlIlIIlIlIIlllIlI) {
        if (lllllllllllllIIIlIlIIlIlIIlllIlI instanceof Int2ObjectMap) {
            final ObjectIterator<Entry<V>> lllllllllllllIIIlIlIIlIlIlIIIIIl = Int2ObjectMaps.fastIterator((Int2ObjectMap<V>)(Int2ObjectMap)lllllllllllllIIIlIlIIlIlIIlllIlI);
            while (lllllllllllllIIIlIlIIlIlIlIIIIIl.hasNext()) {
                final Entry<? extends V> lllllllllllllIIIlIlIIlIlIlIIIIlI = lllllllllllllIIIlIlIIlIlIlIIIIIl.next();
                this.put(lllllllllllllIIIlIlIIlIlIlIIIIlI.getIntKey(), (V)lllllllllllllIIIlIlIIlIlIlIIIIlI.getValue());
            }
        }
        else {
            int lllllllllllllIIIlIlIIlIlIlIIIIII = lllllllllllllIIIlIlIIlIlIIlllIlI.size();
            final Iterator<? extends Map.Entry<? extends Integer, ? extends V>> lllllllllllllIIIlIlIIlIlIIllllll = lllllllllllllIIIlIlIIlIlIIlllIlI.entrySet().iterator();
            while (lllllllllllllIIIlIlIIlIlIlIIIIII-- != 0) {
                final Map.Entry<? extends Integer, ? extends V> lllllllllllllIIIlIlIIlIlIIlllllI = (Map.Entry<? extends Integer, ? extends V>)lllllllllllllIIIlIlIIlIlIIllllll.next();
                this.put((Integer)lllllllllllllIIIlIlIIlIlIIlllllI.getKey(), (V)lllllllllllllIIIlIlIIlIlIIlllllI.getValue());
            }
        }
    }
    
    @Override
    public IntSet keySet() {
        return new AbstractIntSet() {
            @Override
            public boolean contains(final int lllllllllllllIIIIlIIIIIlIIIllIll) {
                return AbstractInt2ObjectMap.this.containsKey(lllllllllllllIIIIlIIIIIlIIIllIll);
            }
            
            @Override
            public int size() {
                return AbstractInt2ObjectMap.this.size();
            }
            
            @Override
            public IntIterator iterator() {
                return new IntIterator() {
                    private final /* synthetic */ ObjectIterator<Entry<V>> i = Int2ObjectMaps.fastIterator((Int2ObjectMap<V>)AbstractInt2ObjectMap.this);
                    
                    @Override
                    public void remove() {
                        this.i.remove();
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.i.hasNext();
                    }
                    
                    @Override
                    public int nextInt() {
                        return this.i.next().getIntKey();
                    }
                };
            }
            
            @Override
            public void clear() {
                AbstractInt2ObjectMap.this.clear();
            }
        };
    }
    
    @Override
    public ObjectCollection<V> values() {
        return new AbstractObjectCollection<V>() {
            @Override
            public int size() {
                return AbstractInt2ObjectMap.this.size();
            }
            
            @Override
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() {
                    private final /* synthetic */ ObjectIterator<Entry<V>> i = Int2ObjectMaps.fastIterator((Int2ObjectMap<V>)AbstractInt2ObjectMap.this);
                    
                    @Override
                    public V next() {
                        return (V)this.i.next().getValue();
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.i.hasNext();
                    }
                };
            }
            
            @Override
            public boolean contains(final Object lllllllllllllllIIllIIllIIllIIIll) {
                return AbstractInt2ObjectMap.this.containsValue(lllllllllllllllIIllIIllIIllIIIll);
            }
            
            @Override
            public void clear() {
                AbstractInt2ObjectMap.this.clear();
            }
        };
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIlIlIIlIlIIllIIIl = 0;
        int lllllllllllllIIIlIlIIlIlIIllIIII = this.size();
        final ObjectIterator<Entry<V>> lllllllllllllIIIlIlIIlIlIIlIllll = Int2ObjectMaps.fastIterator((Int2ObjectMap<V>)this);
        while (lllllllllllllIIIlIlIIlIlIIllIIII-- != 0) {
            lllllllllllllIIIlIlIIlIlIIllIIIl += lllllllllllllIIIlIlIIlIlIIlIllll.next().hashCode();
        }
        return lllllllllllllIIIlIlIIlIlIIllIIIl;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public boolean containsValue(final Object lllllllllllllIIIlIlIIlIlIlIllIlI) {
        return this.values().contains(lllllllllllllIIIlIlIIlIlIlIllIlI);
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIIIlIlIIlIlIIIllIIl = new StringBuilder();
        final ObjectIterator<Entry<V>> lllllllllllllIIIlIlIIlIlIIIllIII = Int2ObjectMaps.fastIterator((Int2ObjectMap<V>)this);
        int lllllllllllllIIIlIlIIlIlIIIlIlll = this.size();
        boolean lllllllllllllIIIlIlIIlIlIIIlIllI = true;
        lllllllllllllIIIlIlIIlIlIIIllIIl.append("{");
        while (lllllllllllllIIIlIlIIlIlIIIlIlll-- != 0) {
            if (lllllllllllllIIIlIlIIlIlIIIlIllI) {
                lllllllllllllIIIlIlIIlIlIIIlIllI = false;
            }
            else {
                lllllllllllllIIIlIlIIlIlIIIllIIl.append(", ");
            }
            final Entry<V> lllllllllllllIIIlIlIIlIlIIIllIll = lllllllllllllIIIlIlIIlIlIIIllIII.next();
            lllllllllllllIIIlIlIIlIlIIIllIIl.append(String.valueOf(lllllllllllllIIIlIlIIlIlIIIllIll.getIntKey()));
            lllllllllllllIIIlIlIIlIlIIIllIIl.append("=>");
            if (this == lllllllllllllIIIlIlIIlIlIIIllIll.getValue()) {
                lllllllllllllIIIlIlIIlIlIIIllIIl.append("(this map)");
            }
            else {
                lllllllllllllIIIlIlIIlIlIIIllIIl.append(String.valueOf(lllllllllllllIIIlIlIIlIlIIIllIll.getValue()));
            }
        }
        lllllllllllllIIIlIlIIlIlIIIllIIl.append("}");
        return String.valueOf(lllllllllllllIIIlIlIIlIlIIIllIIl);
    }
    
    protected AbstractInt2ObjectMap() {
    }
    
    public static class BasicEntry<V> implements Entry<V>
    {
        protected /* synthetic */ int key;
        protected /* synthetic */ V value;
        
        @Override
        public V setValue(final V lllllllllllllIllIIlllllIIIIIIIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public V getValue() {
            return this.value;
        }
        
        public BasicEntry(final Integer lllllllllllllIllIIlllllIIIIlIlll, final V lllllllllllllIllIIlllllIIIIlIllI) {
            this.key = lllllllllllllIllIIlllllIIIIlIlll;
            this.value = lllllllllllllIllIIlllllIIIIlIllI;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIllIIllllIlllllIlIl) {
            if (!(lllllllllllllIllIIllllIlllllIlIl instanceof Map.Entry)) {
                return false;
            }
            if (lllllllllllllIllIIllllIlllllIlIl instanceof Entry) {
                final Entry<V> lllllllllllllIllIIllllIlllllllII = (Entry<V>)lllllllllllllIllIIllllIlllllIlIl;
                return this.key == lllllllllllllIllIIllllIlllllllII.getIntKey() && Objects.equals(this.value, lllllllllllllIllIIllllIlllllllII.getValue());
            }
            final Map.Entry<?, ?> lllllllllllllIllIIllllIllllllIIl = (Map.Entry<?, ?>)lllllllllllllIllIIllllIlllllIlIl;
            final Object lllllllllllllIllIIllllIllllllIII = lllllllllllllIllIIllllIllllllIIl.getKey();
            if (lllllllllllllIllIIllllIllllllIII == null || !(lllllllllllllIllIIllllIllllllIII instanceof Integer)) {
                return false;
            }
            final Object lllllllllllllIllIIllllIlllllIlll = lllllllllllllIllIIllllIllllllIIl.getValue();
            return this.key == (int)lllllllllllllIllIIllllIllllllIII && Objects.equals(this.value, lllllllllllllIllIIllllIlllllIlll);
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(this.key).append("->").append(this.value));
        }
        
        public BasicEntry(final int lllllllllllllIllIIlllllIIIIIlIll, final V lllllllllllllIllIIlllllIIIIIllIl) {
            this.key = lllllllllllllIllIIlllllIIIIIlIll;
            this.value = lllllllllllllIllIIlllllIIIIIllIl;
        }
        
        @Override
        public int getIntKey() {
            return this.key;
        }
        
        public BasicEntry() {
        }
        
        @Override
        public int hashCode() {
            return this.key ^ ((this.value == null) ? 0 : this.value.hashCode());
        }
    }
    
    public abstract static class BasicEntrySet<V> extends AbstractObjectSet<Entry<V>>
    {
        protected final /* synthetic */ Int2ObjectMap<V> map;
        
        @Override
        public boolean contains(final Object lIIllllIlIIllI) {
            if (!(lIIllllIlIIllI instanceof Map.Entry)) {
                return false;
            }
            if (lIIllllIlIIllI instanceof Entry) {
                final Entry<V> lIIllllIlIllll = (Entry<V>)lIIllllIlIIllI;
                final int lIIllllIlIlllI = lIIllllIlIllll.getIntKey();
                return this.map.containsKey(lIIllllIlIlllI) && Objects.equals(this.map.get(lIIllllIlIlllI), lIIllllIlIllll.getValue());
            }
            final Map.Entry<?, ?> lIIllllIlIlIll = (Map.Entry<?, ?>)lIIllllIlIIllI;
            final Object lIIllllIlIlIlI = lIIllllIlIlIll.getKey();
            if (lIIllllIlIlIlI == null || !(lIIllllIlIlIlI instanceof Integer)) {
                return false;
            }
            final int lIIllllIlIlIIl = (int)lIIllllIlIlIlI;
            final Object lIIllllIlIlIII = lIIllllIlIlIll.getValue();
            return this.map.containsKey(lIIllllIlIlIIl) && Objects.equals(this.map.get(lIIllllIlIlIIl), lIIllllIlIlIII);
        }
        
        public BasicEntrySet(final Int2ObjectMap<V> lIIllllIlllIII) {
            this.map = lIIllllIlllIII;
        }
        
        @Override
        public int size() {
            return this.map.size();
        }
        
        @Override
        public boolean remove(final Object lIIllllIIlIIll) {
            if (!(lIIllllIIlIIll instanceof Map.Entry)) {
                return false;
            }
            if (lIIllllIIlIIll instanceof Entry) {
                final Entry<V> lIIllllIIllIll = (Entry<V>)lIIllllIIlIIll;
                return this.map.remove(lIIllllIIllIll.getIntKey(), lIIllllIIllIll.getValue());
            }
            final Map.Entry<?, ?> lIIllllIIllIII = (Map.Entry<?, ?>)lIIllllIIlIIll;
            final Object lIIllllIIlIlll = lIIllllIIllIII.getKey();
            if (lIIllllIIlIlll == null || !(lIIllllIIlIlll instanceof Integer)) {
                return false;
            }
            final int lIIllllIIlIllI = (int)lIIllllIIlIlll;
            final Object lIIllllIIlIlIl = lIIllllIIllIII.getValue();
            return this.map.remove(lIIllllIIlIllI, lIIllllIIlIlIl);
        }
    }
}
