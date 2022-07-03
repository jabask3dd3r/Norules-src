package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;

public abstract class AbstractObject2IntMap<K> extends AbstractObject2IntFunction<K> implements Object2IntMap<K>, Serializable
{
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIlIlIlIIIIIIIllIIlI = new StringBuilder();
        final ObjectIterator<Entry<K>> lllllllllllllIlIlIlIIIIIIIllIIIl = Object2IntMaps.fastIterator((Object2IntMap<K>)this);
        int lllllllllllllIlIlIlIIIIIIIllIIII = this.size();
        boolean lllllllllllllIlIlIlIIIIIIIlIllll = true;
        lllllllllllllIlIlIlIIIIIIIllIIlI.append("{");
        while (lllllllllllllIlIlIlIIIIIIIllIIII-- != 0) {
            if (lllllllllllllIlIlIlIIIIIIIlIllll) {
                lllllllllllllIlIlIlIIIIIIIlIllll = false;
            }
            else {
                lllllllllllllIlIlIlIIIIIIIllIIlI.append(", ");
            }
            final Entry<K> lllllllllllllIlIlIlIIIIIIIllIlII = lllllllllllllIlIlIlIIIIIIIllIIIl.next();
            if (this == lllllllllllllIlIlIlIIIIIIIllIlII.getKey()) {
                lllllllllllllIlIlIlIIIIIIIllIIlI.append("(this map)");
            }
            else {
                lllllllllllllIlIlIlIIIIIIIllIIlI.append(String.valueOf(lllllllllllllIlIlIlIIIIIIIllIlII.getKey()));
            }
            lllllllllllllIlIlIlIIIIIIIllIIlI.append("=>");
            lllllllllllllIlIlIlIIIIIIIllIIlI.append(String.valueOf(lllllllllllllIlIlIlIIIIIIIllIlII.getIntValue()));
        }
        lllllllllllllIlIlIlIIIIIIIllIIlI.append("}");
        return String.valueOf(lllllllllllllIlIlIlIIIIIIIllIIlI);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIlIlIIIIIIIllllll) {
        if (lllllllllllllIlIlIlIIIIIIIllllll == this) {
            return true;
        }
        if (!(lllllllllllllIlIlIlIIIIIIIllllll instanceof Map)) {
            return false;
        }
        final Map<?, ?> lllllllllllllIlIlIlIIIIIIIlllllI = (Map<?, ?>)lllllllllllllIlIlIlIIIIIIIllllll;
        return lllllllllllllIlIlIlIIIIIIIlllllI.size() == this.size() && this.object2IntEntrySet().containsAll(lllllllllllllIlIlIlIIIIIIIlllllI.entrySet());
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends Integer> lllllllllllllIlIlIlIIIIIIlIlIIll) {
        if (lllllllllllllIlIlIlIIIIIIlIlIIll instanceof Object2IntMap) {
            final ObjectIterator<Entry<K>> lllllllllllllIlIlIlIIIIIIlIllIlI = Object2IntMaps.fastIterator((Object2IntMap<K>)(Object2IntMap)lllllllllllllIlIlIlIIIIIIlIlIIll);
            while (lllllllllllllIlIlIlIIIIIIlIllIlI.hasNext()) {
                final Entry<? extends K> lllllllllllllIlIlIlIIIIIIlIllIll = lllllllllllllIlIlIlIIIIIIlIllIlI.next();
                this.put((K)lllllllllllllIlIlIlIIIIIIlIllIll.getKey(), lllllllllllllIlIlIlIIIIIIlIllIll.getIntValue());
            }
        }
        else {
            int lllllllllllllIlIlIlIIIIIIlIllIIl = lllllllllllllIlIlIlIIIIIIlIlIIll.size();
            final Iterator<? extends Map.Entry<? extends K, ? extends Integer>> lllllllllllllIlIlIlIIIIIIlIllIII = lllllllllllllIlIlIlIIIIIIlIlIIll.entrySet().iterator();
            while (lllllllllllllIlIlIlIIIIIIlIllIIl-- != 0) {
                final Map.Entry<? extends K, ? extends Integer> lllllllllllllIlIlIlIIIIIIlIlIlll = (Map.Entry<? extends K, ? extends Integer>)lllllllllllllIlIlIlIIIIIIlIllIII.next();
                this.put((K)lllllllllllllIlIlIlIIIIIIlIlIlll.getKey(), (Integer)lllllllllllllIlIlIlIIIIIIlIlIlll.getValue());
            }
        }
    }
    
    @Override
    public ObjectSet<K> keySet() {
        return new AbstractObjectSet<K>() {
            @Override
            public int size() {
                return AbstractObject2IntMap.this.size();
            }
            
            @Override
            public void clear() {
                AbstractObject2IntMap.this.clear();
            }
            
            @Override
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() {
                    private final /* synthetic */ ObjectIterator<Entry<K>> i = Object2IntMaps.fastIterator((Object2IntMap<K>)AbstractObject2IntMap.this);
                    
                    @Override
                    public boolean hasNext() {
                        return this.i.hasNext();
                    }
                    
                    @Override
                    public K next() {
                        return (K)this.i.next().getKey();
                    }
                    
                    @Override
                    public void remove() {
                        this.i.remove();
                    }
                };
            }
            
            @Override
            public boolean contains(final Object llllllllllllllIlIIIlIlIIIlIllIIl) {
                return AbstractObject2IntMap.this.containsKey(llllllllllllllIlIIIlIlIIIlIllIIl);
            }
        };
    }
    
    @Override
    public boolean containsKey(final Object lllllllllllllIlIlIlIIIIIIllIlllI) {
        final ObjectIterator<Entry<K>> lllllllllllllIlIlIlIIIIIIllIllIl = this.object2IntEntrySet().iterator();
        while (lllllllllllllIlIlIlIIIIIIllIllIl.hasNext()) {
            if (lllllllllllllIlIlIlIIIIIIllIllIl.next().getKey() == lllllllllllllIlIlIlIIIIIIllIlllI) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlIlIlIIIIIIlIIlIlI = 0;
        int lllllllllllllIlIlIlIIIIIIlIIlIIl = this.size();
        final ObjectIterator<Entry<K>> lllllllllllllIlIlIlIIIIIIlIIlIII = Object2IntMaps.fastIterator((Object2IntMap<K>)this);
        while (lllllllllllllIlIlIlIIIIIIlIIlIIl-- != 0) {
            lllllllllllllIlIlIlIIIIIIlIIlIlI += lllllllllllllIlIlIlIIIIIIlIIlIII.next().hashCode();
        }
        return lllllllllllllIlIlIlIIIIIIlIIlIlI;
    }
    
    @Override
    public boolean containsValue(final int lllllllllllllIlIlIlIIIIIIlllIIll) {
        return this.values().contains(lllllllllllllIlIlIlIIIIIIlllIIll);
    }
    
    @Override
    public IntCollection values() {
        return new AbstractIntCollection() {
            @Override
            public IntIterator iterator() {
                return new IntIterator() {
                    private final /* synthetic */ ObjectIterator<Entry<K>> i = Object2IntMaps.fastIterator((Object2IntMap<K>)AbstractObject2IntMap.this);
                    
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
            
            @Override
            public int size() {
                return AbstractObject2IntMap.this.size();
            }
            
            @Override
            public void clear() {
                AbstractObject2IntMap.this.clear();
            }
            
            @Override
            public boolean contains(final int llllllllllllllIlIIIllllIIIlIIlIl) {
                return AbstractObject2IntMap.this.containsValue(llllllllllllllIlIIIllllIIIlIIlIl);
            }
        };
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    protected AbstractObject2IntMap() {
    }
    
    public static class BasicEntry<K> implements Entry<K>
    {
        protected /* synthetic */ K key;
        protected /* synthetic */ int value;
        
        public BasicEntry() {
        }
        
        @Override
        public K getKey() {
            return this.key;
        }
        
        public BasicEntry(final K llllllllllllllIIllIIlIIIlllIIlII, final int llllllllllllllIIllIIlIIIlllIIIII) {
            this.key = llllllllllllllIIllIIlIIIlllIIlII;
            this.value = llllllllllllllIIllIIlIIIlllIIIII;
        }
        
        @Override
        public int setValue(final int llllllllllllllIIllIIlIIIllIllIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIIllIIlIIIllIlIIII) {
            if (!(llllllllllllllIIllIIlIIIllIlIIII instanceof Map.Entry)) {
                return false;
            }
            if (llllllllllllllIIllIIlIIIllIlIIII instanceof Entry) {
                final Entry<K> llllllllllllllIIllIIlIIIllIlIIlI = (Entry<K>)llllllllllllllIIllIIlIIIllIlIIII;
                return Objects.equals(this.key, llllllllllllllIIllIIlIIIllIlIIlI.getKey()) && this.value == llllllllllllllIIllIIlIIIllIlIIlI.getIntValue();
            }
            final Map.Entry<?, ?> llllllllllllllIIllIIlIIIllIIllll = (Map.Entry<?, ?>)llllllllllllllIIllIIlIIIllIlIIII;
            final Object llllllllllllllIIllIIlIIIllIIlllI = llllllllllllllIIllIIlIIIllIIllll.getKey();
            final Object llllllllllllllIIllIIlIIIllIIllIl = llllllllllllllIIllIIlIIIllIIllll.getValue();
            return llllllllllllllIIllIIlIIIllIIllIl != null && llllllllllllllIIllIIlIIIllIIllIl instanceof Integer && Objects.equals(this.key, llllllllllllllIIllIIlIIIllIIlllI) && this.value == (int)llllllllllllllIIllIIlIIIllIIllIl;
        }
        
        @Override
        public int getIntValue() {
            return this.value;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(this.key).append("->").append(this.value));
        }
        
        @Override
        public int hashCode() {
            return ((this.key == null) ? 0 : this.key.hashCode()) ^ this.value;
        }
        
        public BasicEntry(final K llllllllllllllIIllIIlIIIlllIlIlI, final Integer llllllllllllllIIllIIlIIIlllIlIIl) {
            this.key = llllllllllllllIIllIIlIIIlllIlIlI;
            this.value = llllllllllllllIIllIIlIIIlllIlIIl;
        }
    }
    
    public abstract static class BasicEntrySet<K> extends AbstractObjectSet<Entry<K>>
    {
        protected final /* synthetic */ Object2IntMap<K> map;
        
        @Override
        public int size() {
            return this.map.size();
        }
        
        @Override
        public boolean remove(final Object llllllllllllllllIlIlIlIlllIllIlI) {
            if (!(llllllllllllllllIlIlIlIlllIllIlI instanceof Map.Entry)) {
                return false;
            }
            if (llllllllllllllllIlIlIlIlllIllIlI instanceof Entry) {
                final Entry<K> llllllllllllllllIlIlIlIllllIIIlI = (Entry<K>)llllllllllllllllIlIlIlIlllIllIlI;
                return this.map.remove(llllllllllllllllIlIlIlIllllIIIlI.getKey(), llllllllllllllllIlIlIlIllllIIIlI.getIntValue());
            }
            final Map.Entry<?, ?> llllllllllllllllIlIlIlIlllIlllll = (Map.Entry<?, ?>)llllllllllllllllIlIlIlIlllIllIlI;
            final Object llllllllllllllllIlIlIlIlllIllllI = llllllllllllllllIlIlIlIlllIlllll.getKey();
            final Object llllllllllllllllIlIlIlIlllIlllIl = llllllllllllllllIlIlIlIlllIlllll.getValue();
            if (llllllllllllllllIlIlIlIlllIlllIl == null || !(llllllllllllllllIlIlIlIlllIlllIl instanceof Integer)) {
                return false;
            }
            final int llllllllllllllllIlIlIlIlllIlllII = (int)llllllllllllllllIlIlIlIlllIlllIl;
            return this.map.remove(llllllllllllllllIlIlIlIlllIllllI, llllllllllllllllIlIlIlIlllIlllII);
        }
        
        public BasicEntrySet(final Object2IntMap<K> llllllllllllllllIlIlIllIIIIlllll) {
            this.map = llllllllllllllllIlIlIllIIIIlllll;
        }
        
        @Override
        public boolean contains(final Object llllllllllllllllIlIlIlIllllllIll) {
            if (!(llllllllllllllllIlIlIlIllllllIll instanceof Map.Entry)) {
                return false;
            }
            if (llllllllllllllllIlIlIlIllllllIll instanceof Entry) {
                final Entry<K> llllllllllllllllIlIlIllIIIIIIIIl = (Entry<K>)llllllllllllllllIlIlIlIllllllIll;
                final K llllllllllllllllIlIlIlIlllllllll = llllllllllllllllIlIlIllIIIIIIIIl.getKey();
                return this.map.containsKey(llllllllllllllllIlIlIlIlllllllll) && this.map.getInt(llllllllllllllllIlIlIlIlllllllll) == llllllllllllllllIlIlIllIIIIIIIIl.getIntValue();
            }
            final Map.Entry<?, ?> llllllllllllllllIlIlIlIllllllIIl = (Map.Entry<?, ?>)llllllllllllllllIlIlIlIllllllIll;
            final Object llllllllllllllllIlIlIlIllllllIII = llllllllllllllllIlIlIlIllllllIIl.getKey();
            final Object llllllllllllllllIlIlIlIlllllIlll = llllllllllllllllIlIlIlIllllllIIl.getValue();
            return llllllllllllllllIlIlIlIlllllIlll != null && llllllllllllllllIlIlIlIlllllIlll instanceof Integer && this.map.containsKey(llllllllllllllllIlIlIlIllllllIII) && this.map.getInt(llllllllllllllllIlIlIlIllllllIII) == (int)llllllllllllllllIlIlIlIlllllIlll;
        }
    }
}
