package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.function.*;
import java.io.*;
import java.util.*;

public final class Object2ObjectMaps
{
    public static final /* synthetic */ EmptyMap EMPTY_MAP;
    
    public static <K, V> Object2ObjectMap<K, V> synchronize(final Object2ObjectMap<K, V> lllllllllllllllIlllIIIIIlIIlllII) {
        return (Object2ObjectMap<K, V>)new Object2ObjectMaps.SynchronizedMap((Object2ObjectMap)lllllllllllllllIlllIIIIIlIIlllII);
    }
    
    public static <K, V> ObjectIterable<Object2ObjectMap.Entry<K, V>> fastIterable(final Object2ObjectMap<K, V> lllllllllllllllIlllIIIIIlIllIIIl) {
        final ObjectSet<Object2ObjectMap.Entry<K, V>> lllllllllllllllIlllIIIIIlIlIlllI = lllllllllllllllIlllIIIIIlIllIIIl.object2ObjectEntrySet();
        return (lllllllllllllllIlllIIIIIlIlIlllI instanceof Object2ObjectMap.FastEntrySet) ? new ObjectIterable<Object2ObjectMap.Entry<K, V>>() {
            @Override
            public void forEach(final Consumer<? super Object2ObjectMap.Entry<K, V>> lllllllllllllllIIlIllIIlIllllllI) {
                ((Object2ObjectMap.FastEntrySet)lllllllllllllllIlllIIIIIlIlIlllI).fastForEach(lllllllllllllllIIlIllIIlIllllllI);
            }
            
            @Override
            public ObjectIterator<Object2ObjectMap.Entry<K, V>> iterator() {
                return ((Object2ObjectMap.FastEntrySet)lllllllllllllllIlllIIIIIlIlIlllI).fastIterator();
            }
        } : lllllllllllllllIlllIIIIIlIlIlllI;
    }
    
    public static <K, V> Object2ObjectMap<K, V> singleton(final K lllllllllllllllIlllIIIIIlIlIIIlI, final V lllllllllllllllIlllIIIIIlIIlllll) {
        return new Singleton<K, V>(lllllllllllllllIlllIIIIIlIlIIIlI, lllllllllllllllIlllIIIIIlIIlllll);
    }
    
    private Object2ObjectMaps() {
    }
    
    public static <K, V> Object2ObjectMap<K, V> emptyMap() {
        return (Object2ObjectMap<K, V>)Object2ObjectMaps.EMPTY_MAP;
    }
    
    public static <K, V> ObjectIterator<Object2ObjectMap.Entry<K, V>> fastIterator(final Object2ObjectMap<K, V> lllllllllllllllIlllIIIIIllIIllll) {
        final ObjectSet<Object2ObjectMap.Entry<K, V>> lllllllllllllllIlllIIIIIllIlIIIl = lllllllllllllllIlllIIIIIllIIllll.object2ObjectEntrySet();
        return (lllllllllllllllIlllIIIIIllIlIIIl instanceof Object2ObjectMap.FastEntrySet) ? ((Object2ObjectMap.FastEntrySet)lllllllllllllllIlllIIIIIllIlIIIl).fastIterator() : lllllllllllllllIlllIIIIIllIlIIIl.iterator();
    }
    
    public static <K, V> Object2ObjectMap<K, V> unmodifiable(final Object2ObjectMap<K, V> lllllllllllllllIlllIIIIIlIIIlIll) {
        return (Object2ObjectMap<K, V>)new Object2ObjectMaps.UnmodifiableMap((Object2ObjectMap)lllllllllllllllIlllIIIIIlIIIlIll);
    }
    
    public static <K, V> void fastForEach(final Object2ObjectMap<K, V> lllllllllllllllIlllIIIIIllIIIIIl, final Consumer<? super Object2ObjectMap.Entry<K, V>> lllllllllllllllIlllIIIIIlIlllIIl) {
        final ObjectSet<Object2ObjectMap.Entry<K, V>> lllllllllllllllIlllIIIIIlIlllIll = lllllllllllllllIlllIIIIIllIIIIIl.object2ObjectEntrySet();
        if (lllllllllllllllIlllIIIIIlIlllIll instanceof Object2ObjectMap.FastEntrySet) {
            ((Object2ObjectMap.FastEntrySet)lllllllllllllllIlllIIIIIlIlllIll).fastForEach(lllllllllllllllIlllIIIIIlIlllIIl);
        }
        else {
            lllllllllllllllIlllIIIIIlIlllIll.forEach(lllllllllllllllIlllIIIIIlIlllIIl);
        }
    }
    
    static {
        EMPTY_MAP = new EmptyMap();
    }
    
    public static <K, V> Object2ObjectMap<K, V> synchronize(final Object2ObjectMap<K, V> lllllllllllllllIlllIIIIIlIIlIIlI, final Object lllllllllllllllIlllIIIIIlIIlIIII) {
        return (Object2ObjectMap<K, V>)new Object2ObjectMaps.SynchronizedMap((Object2ObjectMap)lllllllllllllllIlllIIIIIlIIlIIlI, lllllllllllllllIlllIIIIIlIIlIIII);
    }
    
    public static class EmptyMap<K, V> extends Object2ObjectFunctions.EmptyFunction<K, V> implements Object2ObjectMap<K, V>, Serializable, Cloneable
    {
        @Override
        public boolean containsValue(final Object lllllllllllllIlIlIIlIIlIIIlllIlI) {
            return false;
        }
        
        @Override
        public Object clone() {
            return Object2ObjectMaps.EMPTY_MAP;
        }
        
        @Override
        public ObjectSet<Entry<K, V>> object2ObjectEntrySet() {
            return (ObjectSet<Entry<K, V>>)ObjectSets.EMPTY_SET;
        }
        
        @Override
        public String toString() {
            return "{}";
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public void putAll(final Map<? extends K, ? extends V> lllllllllllllIlIlIIlIIlIIIllIllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean isEmpty() {
            return true;
        }
        
        protected EmptyMap() {
        }
        
        @Override
        public ObjectCollection<V> values() {
            return (ObjectCollection<V>)ObjectSets.EMPTY_SET;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIlIlIIlIIlIIIlIlIIl) {
            return lllllllllllllIlIlIIlIIlIIIlIlIIl instanceof Map && ((Map)lllllllllllllIlIlIIlIIlIIIlIlIIl).isEmpty();
        }
        
        @Override
        public ObjectSet<K> keySet() {
            return (ObjectSet<K>)ObjectSets.EMPTY_SET;
        }
    }
    
    public static class Singleton<K, V> extends Object2ObjectFunctions.Singleton<K, V> implements Object2ObjectMap<K, V>, Serializable, Cloneable
    {
        protected transient /* synthetic */ ObjectSet<Entry<K, V>> entries;
        protected transient /* synthetic */ ObjectSet<K> keys;
        protected transient /* synthetic */ ObjectCollection<V> values;
        
        @Override
        public boolean equals(final Object lllllllllllllIIlIIIlIIIIIlllllll) {
            if (lllllllllllllIIlIIIlIIIIIlllllll == this) {
                return true;
            }
            if (!(lllllllllllllIIlIIIlIIIIIlllllll instanceof Map)) {
                return false;
            }
            final Map<?, ?> lllllllllllllIIlIIIlIIIIlIIIIIIl = (Map<?, ?>)lllllllllllllIIlIIIlIIIIIlllllll;
            return lllllllllllllIIlIIIlIIIIlIIIIIIl.size() == 1 && lllllllllllllIIlIIIlIIIIlIIIIIIl.entrySet().iterator().next().equals(this.entrySet().iterator().next());
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
        
        @Override
        public void putAll(final Map<? extends K, ? extends V> lllllllllllllIIlIIIlIIIIlIIlIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("{").append(this.key).append("=>").append(this.value).append("}"));
        }
        
        @Override
        public int hashCode() {
            return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value.hashCode());
        }
        
        @Override
        public ObjectSet<Map.Entry<K, V>> entrySet() {
            return (ObjectSet<Map.Entry<K, V>>)this.object2ObjectEntrySet();
        }
        
        @Override
        public boolean containsValue(final Object lllllllllllllIIlIIIlIIIIlIIllIll) {
            return Objects.equals(this.value, lllllllllllllIIlIIIlIIIIlIIllIll);
        }
        
        @Override
        public ObjectSet<Entry<K, V>> object2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = (ObjectSet<Entry<K, V>>)ObjectSets.singleton(new AbstractObject2ObjectMap.BasicEntry<K, V>(this.key, this.value));
            }
            return this.entries;
        }
        
        @Override
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.singleton(this.key);
            }
            return this.keys;
        }
        
        @Override
        public ObjectCollection<V> values() {
            if (this.values == null) {
                this.values = ObjectSets.singleton(this.value);
            }
            return this.values;
        }
        
        protected Singleton(final K lllllllllllllIIlIIIlIIIIlIlIIIII, final V lllllllllllllIIlIIIlIIIIlIlIIIlI) {
            super(lllllllllllllIIlIIIlIIIIlIlIIIII, lllllllllllllIIlIIIlIIIIlIlIIIlI);
        }
    }
}
