package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;

public abstract class AbstractObject2ObjectMap<K, V> extends AbstractObject2ObjectFunction<K, V> implements Object2ObjectMap<K, V>, Serializable
{
    @Override
    public boolean containsKey(final Object lllllllllllllIIIIllIlIIIlIIIllII) {
        final ObjectIterator<Entry<K, V>> lllllllllllllIIIIllIlIIIlIIIlIll = this.object2ObjectEntrySet().iterator();
        while (lllllllllllllIIIIllIlIIIlIIIlIll.hasNext()) {
            if (lllllllllllllIIIIllIlIIIlIIIlIll.next().getKey() == lllllllllllllIIIIllIlIIIlIIIllII) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean containsValue(final Object lllllllllllllIIIIllIlIIIlIIlIIll) {
        return this.values().contains(lllllllllllllIIIIllIlIIIlIIlIIll);
    }
    
    protected AbstractObject2ObjectMap() {
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIIllIlIIIIllIlIII = 0;
        int lllllllllllllIIIIllIlIIIIllIIlll = this.size();
        final ObjectIterator<Entry<K, V>> lllllllllllllIIIIllIlIIIIllIIllI = Object2ObjectMaps.fastIterator((Object2ObjectMap<K, V>)this);
        while (lllllllllllllIIIIllIlIIIIllIIlll-- != 0) {
            lllllllllllllIIIIllIlIIIIllIlIII += lllllllllllllIIIIllIlIIIIllIIllI.next().hashCode();
        }
        return lllllllllllllIIIIllIlIIIIllIlIII;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> lllllllllllllIIIIllIlIIIIlllIIIl) {
        if (lllllllllllllIIIIllIlIIIIlllIIIl instanceof Object2ObjectMap) {
            final ObjectIterator<Entry<K, V>> lllllllllllllIIIIllIlIIIIllllIII = Object2ObjectMaps.fastIterator((Object2ObjectMap<K, V>)(Object2ObjectMap)lllllllllllllIIIIllIlIIIIlllIIIl);
            while (lllllllllllllIIIIllIlIIIIllllIII.hasNext()) {
                final Entry<? extends K, ? extends V> lllllllllllllIIIIllIlIIIIllllIIl = lllllllllllllIIIIllIlIIIIllllIII.next();
                this.put((K)lllllllllllllIIIIllIlIIIIllllIIl.getKey(), (V)lllllllllllllIIIIllIlIIIIllllIIl.getValue());
            }
        }
        else {
            int lllllllllllllIIIIllIlIIIIlllIlll = lllllllllllllIIIIllIlIIIIlllIIIl.size();
            final Iterator<? extends Map.Entry<? extends K, ? extends V>> lllllllllllllIIIIllIlIIIIlllIllI = lllllllllllllIIIIllIlIIIIlllIIIl.entrySet().iterator();
            while (lllllllllllllIIIIllIlIIIIlllIlll-- != 0) {
                final Map.Entry<? extends K, ? extends V> lllllllllllllIIIIllIlIIIIlllIlIl = (Map.Entry<? extends K, ? extends V>)lllllllllllllIIIIllIlIIIIlllIllI.next();
                this.put((K)lllllllllllllIIIIllIlIIIIlllIlIl.getKey(), (V)lllllllllllllIIIIllIlIIIIlllIlIl.getValue());
            }
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIllIlIIIIlIlllIl) {
        if (lllllllllllllIIIIllIlIIIIlIlllIl == this) {
            return true;
        }
        if (!(lllllllllllllIIIIllIlIIIIlIlllIl instanceof Map)) {
            return false;
        }
        final Map<?, ?> lllllllllllllIIIIllIlIIIIlIlllII = (Map<?, ?>)lllllllllllllIIIIllIlIIIIlIlllIl;
        return lllllllllllllIIIIllIlIIIIlIlllII.size() == this.size() && this.object2ObjectEntrySet().containsAll(lllllllllllllIIIIllIlIIIIlIlllII.entrySet());
    }
    
    @Override
    public ObjectCollection<V> values() {
        return new AbstractObjectCollection<V>() {
            @Override
            public void clear() {
                AbstractObject2ObjectMap.this.clear();
            }
            
            @Override
            public boolean contains(final Object lllllllllllllIllllIIlllIlIlIllll) {
                return AbstractObject2ObjectMap.this.containsValue(lllllllllllllIllllIIlllIlIlIllll);
            }
            
            @Override
            public int size() {
                return AbstractObject2ObjectMap.this.size();
            }
            
            @Override
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() {
                    private final /* synthetic */ ObjectIterator<Entry<K, V>> i = Object2ObjectMaps.fastIterator((Object2ObjectMap<K, V>)AbstractObject2ObjectMap.this);
                    
                    @Override
                    public V next() {
                        return this.i.next().getValue();
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.i.hasNext();
                    }
                };
            }
        };
    }
    
    @Override
    public ObjectSet<K> keySet() {
        return new AbstractObjectSet<K>() {
            @Override
            public int size() {
                return AbstractObject2ObjectMap.this.size();
            }
            
            @Override
            public void clear() {
                AbstractObject2ObjectMap.this.clear();
            }
            
            @Override
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() {
                    private final /* synthetic */ ObjectIterator<Entry<K, V>> i = Object2ObjectMaps.fastIterator((Object2ObjectMap<K, V>)AbstractObject2ObjectMap.this);
                    
                    @Override
                    public boolean hasNext() {
                        return this.i.hasNext();
                    }
                    
                    @Override
                    public void remove() {
                        this.i.remove();
                    }
                    
                    @Override
                    public K next() {
                        return this.i.next().getKey();
                    }
                };
            }
            
            @Override
            public boolean contains(final Object lllllllllllllIlIlllIIIIIllIlIlII) {
                return AbstractObject2ObjectMap.this.containsKey(lllllllllllllIlIlllIIIIIllIlIlII);
            }
        };
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIIIIllIlIIIIlIlIIII = new StringBuilder();
        final ObjectIterator<Entry<K, V>> lllllllllllllIIIIllIlIIIIlIIllll = Object2ObjectMaps.fastIterator((Object2ObjectMap<K, V>)this);
        int lllllllllllllIIIIllIlIIIIlIIlllI = this.size();
        boolean lllllllllllllIIIIllIlIIIIlIIllIl = true;
        lllllllllllllIIIIllIlIIIIlIlIIII.append("{");
        while (lllllllllllllIIIIllIlIIIIlIIlllI-- != 0) {
            if (lllllllllllllIIIIllIlIIIIlIIllIl) {
                lllllllllllllIIIIllIlIIIIlIIllIl = false;
            }
            else {
                lllllllllllllIIIIllIlIIIIlIlIIII.append(", ");
            }
            final Entry<K, V> lllllllllllllIIIIllIlIIIIlIlIIlI = lllllllllllllIIIIllIlIIIIlIIllll.next();
            if (this == lllllllllllllIIIIllIlIIIIlIlIIlI.getKey()) {
                lllllllllllllIIIIllIlIIIIlIlIIII.append("(this map)");
            }
            else {
                lllllllllllllIIIIllIlIIIIlIlIIII.append(String.valueOf(lllllllllllllIIIIllIlIIIIlIlIIlI.getKey()));
            }
            lllllllllllllIIIIllIlIIIIlIlIIII.append("=>");
            if (this == lllllllllllllIIIIllIlIIIIlIlIIlI.getValue()) {
                lllllllllllllIIIIllIlIIIIlIlIIII.append("(this map)");
            }
            else {
                lllllllllllllIIIIllIlIIIIlIlIIII.append(String.valueOf(lllllllllllllIIIIllIlIIIIlIlIIlI.getValue()));
            }
        }
        lllllllllllllIIIIllIlIIIIlIlIIII.append("}");
        return String.valueOf(lllllllllllllIIIIllIlIIIIlIlIIII);
    }
    
    public abstract static class BasicEntrySet<K, V> extends AbstractObjectSet<Entry<K, V>>
    {
        protected final /* synthetic */ Object2ObjectMap<K, V> map;
        
        public BasicEntrySet(final Object2ObjectMap<K, V> lllllllllllllIIIIllIlIIIllIIIlII) {
            this.map = lllllllllllllIIIIllIlIIIllIIIlII;
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIIIIllIlIIIlIlIlIIl) {
            if (!(lllllllllllllIIIIllIlIIIlIlIlIIl instanceof Map.Entry)) {
                return false;
            }
            if (lllllllllllllIIIIllIlIIIlIlIlIIl instanceof Entry) {
                final Entry<K, V> lllllllllllllIIIIllIlIIIlIlIlIll = (Entry<K, V>)lllllllllllllIIIIllIlIIIlIlIlIIl;
                return this.map.remove(lllllllllllllIIIIllIlIIIlIlIlIll.getKey(), lllllllllllllIIIIllIlIIIlIlIlIll.getValue());
            }
            final Map.Entry<?, ?> lllllllllllllIIIIllIlIIIlIlIlIII = (Map.Entry<?, ?>)lllllllllllllIIIIllIlIIIlIlIlIIl;
            final Object lllllllllllllIIIIllIlIIIlIlIIlll = lllllllllllllIIIIllIlIIIlIlIlIII.getKey();
            final Object lllllllllllllIIIIllIlIIIlIlIIllI = lllllllllllllIIIIllIlIIIlIlIlIII.getValue();
            return this.map.remove(lllllllllllllIIIIllIlIIIlIlIIlll, lllllllllllllIIIIllIlIIIlIlIIllI);
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIIIIllIlIIIlIlllIIl) {
            if (!(lllllllllllllIIIIllIlIIIlIlllIIl instanceof Map.Entry)) {
                return false;
            }
            if (lllllllllllllIIIIllIlIIIlIlllIIl instanceof Entry) {
                final Entry<K, V> lllllllllllllIIIIllIlIIIlIllllII = (Entry<K, V>)lllllllllllllIIIIllIlIIIlIlllIIl;
                final K lllllllllllllIIIIllIlIIIlIlllIll = lllllllllllllIIIIllIlIIIlIllllII.getKey();
                return this.map.containsKey(lllllllllllllIIIIllIlIIIlIlllIll) && Objects.equals(this.map.get(lllllllllllllIIIIllIlIIIlIlllIll), lllllllllllllIIIIllIlIIIlIllllII.getValue());
            }
            final Map.Entry<?, ?> lllllllllllllIIIIllIlIIIlIlllIII = (Map.Entry<?, ?>)lllllllllllllIIIIllIlIIIlIlllIIl;
            final Object lllllllllllllIIIIllIlIIIlIllIlll = lllllllllllllIIIIllIlIIIlIlllIII.getKey();
            final Object lllllllllllllIIIIllIlIIIlIllIllI = lllllllllllllIIIIllIlIIIlIlllIII.getValue();
            return this.map.containsKey(lllllllllllllIIIIllIlIIIlIllIlll) && Objects.equals(this.map.get(lllllllllllllIIIIllIlIIIlIllIlll), lllllllllllllIIIIllIlIIIlIllIllI);
        }
        
        @Override
        public int size() {
            return this.map.size();
        }
    }
    
    public static class BasicEntry<K, V> implements Entry<K, V>
    {
        protected /* synthetic */ V value;
        protected /* synthetic */ K key;
        
        @Override
        public int hashCode() {
            return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value.hashCode());
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(this.key).append("->").append(this.value));
        }
        
        @Override
        public V getValue() {
            return this.value;
        }
        
        public BasicEntry(final K lllllllllllllIlIIlIIIIlllIIlIlIl, final V lllllllllllllIlIIlIIIIlllIIlIIIl) {
            this.key = lllllllllllllIlIIlIIIIlllIIlIlIl;
            this.value = lllllllllllllIlIIlIIIIlllIIlIIIl;
        }
        
        @Override
        public K getKey() {
            return this.key;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIlIIlIIIIllIlllllII) {
            if (!(lllllllllllllIlIIlIIIIllIlllllII instanceof Map.Entry)) {
                return false;
            }
            if (lllllllllllllIlIIlIIIIllIlllllII instanceof Entry) {
                final Entry<K, V> lllllllllllllIlIIlIIIIlllIIIIIll = (Entry<K, V>)lllllllllllllIlIIlIIIIllIlllllII;
                return Objects.equals(this.key, lllllllllllllIlIIlIIIIlllIIIIIll.getKey()) && Objects.equals(this.value, lllllllllllllIlIIlIIIIlllIIIIIll.getValue());
            }
            final Map.Entry<?, ?> lllllllllllllIlIIlIIIIlllIIIIIII = (Map.Entry<?, ?>)lllllllllllllIlIIlIIIIllIlllllII;
            final Object lllllllllllllIlIIlIIIIllIlllllll = lllllllllllllIlIIlIIIIlllIIIIIII.getKey();
            final Object lllllllllllllIlIIlIIIIllIllllllI = lllllllllllllIlIIlIIIIlllIIIIIII.getValue();
            return Objects.equals(this.key, lllllllllllllIlIIlIIIIllIlllllll) && Objects.equals(this.value, lllllllllllllIlIIlIIIIllIllllllI);
        }
        
        public BasicEntry() {
        }
        
        @Override
        public V setValue(final V lllllllllllllIlIIlIIIIlllIIIlIIl) {
            throw new UnsupportedOperationException();
        }
    }
}
