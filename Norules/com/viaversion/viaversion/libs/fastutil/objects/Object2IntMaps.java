package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.function.*;
import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public final class Object2IntMaps
{
    public static final /* synthetic */ EmptyMap EMPTY_MAP;
    
    public static <K> Object2IntMap<K> synchronize(final Object2IntMap<K> lllllllllllllllIIllIIlllllIIlIlI) {
        return (Object2IntMap<K>)new Object2IntMaps.SynchronizedMap((Object2IntMap)lllllllllllllllIIllIIlllllIIlIlI);
    }
    
    public static <K> void fastForEach(final Object2IntMap<K> lllllllllllllllIIllIIllllllIIIll, final Consumer<? super Object2IntMap.Entry<K>> lllllllllllllllIIllIIllllllIIIlI) {
        final ObjectSet<Object2IntMap.Entry<K>> lllllllllllllllIIllIIllllllIIIIl = lllllllllllllllIIllIIllllllIIIll.object2IntEntrySet();
        if (lllllllllllllllIIllIIllllllIIIIl instanceof Object2IntMap.FastEntrySet) {
            ((Object2IntMap.FastEntrySet)lllllllllllllllIIllIIllllllIIIIl).fastForEach(lllllllllllllllIIllIIllllllIIIlI);
        }
        else {
            lllllllllllllllIIllIIllllllIIIIl.forEach(lllllllllllllllIIllIIllllllIIIlI);
        }
    }
    
    public static <K> Object2IntMap<K> unmodifiable(final Object2IntMap<K> lllllllllllllllIIllIIlllllIIIIIl) {
        return (Object2IntMap<K>)new Object2IntMaps.UnmodifiableMap((Object2IntMap)lllllllllllllllIIllIIlllllIIIIIl);
    }
    
    private Object2IntMaps() {
    }
    
    public static <K> ObjectIterator<Object2IntMap.Entry<K>> fastIterator(final Object2IntMap<K> lllllllllllllllIIllIIllllllIlIlI) {
        final ObjectSet<Object2IntMap.Entry<K>> lllllllllllllllIIllIIllllllIlIIl = lllllllllllllllIIllIIllllllIlIlI.object2IntEntrySet();
        return (lllllllllllllllIIllIIllllllIlIIl instanceof Object2IntMap.FastEntrySet) ? ((Object2IntMap.FastEntrySet)lllllllllllllllIIllIIllllllIlIIl).fastIterator() : lllllllllllllllIIllIIllllllIlIIl.iterator();
    }
    
    static {
        EMPTY_MAP = new EmptyMap();
    }
    
    public static <K> ObjectIterable<Object2IntMap.Entry<K>> fastIterable(final Object2IntMap<K> lllllllllllllllIIllIIlllllIllIIl) {
        final ObjectSet<Object2IntMap.Entry<K>> lllllllllllllllIIllIIlllllIllIlI = lllllllllllllllIIllIIlllllIllIIl.object2IntEntrySet();
        return (lllllllllllllllIIllIIlllllIllIlI instanceof Object2IntMap.FastEntrySet) ? new ObjectIterable<Object2IntMap.Entry<K>>() {
            @Override
            public void forEach(final Consumer<? super Object2IntMap.Entry<K>> llllllllllllllIIlIlIlIIlIIlllIIl) {
                ((Object2IntMap.FastEntrySet)lllllllllllllllIIllIIlllllIllIlI).fastForEach(llllllllllllllIIlIlIlIIlIIlllIIl);
            }
            
            @Override
            public ObjectIterator<Object2IntMap.Entry<K>> iterator() {
                return ((Object2IntMap.FastEntrySet)lllllllllllllllIIllIIlllllIllIlI).fastIterator();
            }
        } : lllllllllllllllIIllIIlllllIllIlI;
    }
    
    public static <K> Object2IntMap<K> singleton(final K lllllllllllllllIIllIIlllllIIllll, final Integer lllllllllllllllIIllIIlllllIIllII) {
        return new Singleton<K>(lllllllllllllllIIllIIlllllIIllll, lllllllllllllllIIllIIlllllIIllII);
    }
    
    public static <K> Object2IntMap<K> emptyMap() {
        return (Object2IntMap<K>)Object2IntMaps.EMPTY_MAP;
    }
    
    public static <K> Object2IntMap<K> synchronize(final Object2IntMap<K> lllllllllllllllIIllIIlllllIIIlII, final Object lllllllllllllllIIllIIlllllIIIlIl) {
        return (Object2IntMap<K>)new Object2IntMaps.SynchronizedMap((Object2IntMap)lllllllllllllllIIllIIlllllIIIlII, lllllllllllllllIIllIIlllllIIIlIl);
    }
    
    public static <K> Object2IntMap<K> singleton(final K lllllllllllllllIIllIIlllllIlIlIl, final int lllllllllllllllIIllIIlllllIlIIlI) {
        return new Singleton<K>(lllllllllllllllIIllIIlllllIlIlIl, lllllllllllllllIIllIIlllllIlIIlI);
    }
    
    public static class EmptyMap<K> extends Object2IntFunctions.EmptyFunction<K> implements Object2IntMap<K>, Serializable, Cloneable
    {
        @Override
        public ObjectSet<K> keySet() {
            return (ObjectSet<K>)ObjectSets.EMPTY_SET;
        }
        
        @Override
        public String toString() {
            return "{}";
        }
        
        @Override
        public ObjectSet<Entry<K>> object2IntEntrySet() {
            return (ObjectSet<Entry<K>>)ObjectSets.EMPTY_SET;
        }
        
        @Override
        public boolean isEmpty() {
            return true;
        }
        
        protected EmptyMap() {
        }
        
        @Override
        public boolean containsValue(final int llllllllllllllIIllIIlIllIlIlIIIl) {
            return false;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public void putAll(final Map<? extends K, ? extends Integer> llllllllllllllIIllIIlIllIlIIllIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIIllIIlIllIlIIIIll) {
            return llllllllllllllIIllIIlIllIlIIIIll instanceof Map && ((Map)llllllllllllllIIllIIlIllIlIIIIll).isEmpty();
        }
        
        @Override
        public IntCollection values() {
            return IntSets.EMPTY_SET;
        }
        
        @Override
        public Object clone() {
            return Object2IntMaps.EMPTY_MAP;
        }
        
        @Deprecated
        @Override
        public boolean containsValue(final Object llllllllllllllIIllIIlIllIlIIllll) {
            return false;
        }
    }
    
    public static class Singleton<K> extends Object2IntFunctions.Singleton<K> implements Object2IntMap<K>, Serializable, Cloneable
    {
        protected transient /* synthetic */ ObjectSet<Entry<K>> entries;
        protected transient /* synthetic */ ObjectSet<K> keys;
        protected transient /* synthetic */ IntCollection values;
        
        @Override
        public boolean containsValue(final int lllllllllllllIlllIIlIllllllIIIll) {
            return this.value == lllllllllllllIlllIIlIllllllIIIll;
        }
        
        @Override
        public int hashCode() {
            return ((this.key == null) ? 0 : this.key.hashCode()) ^ this.value;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIlllIIlIlllllIIIlII) {
            if (lllllllllllllIlllIIlIlllllIIIlII == this) {
                return true;
            }
            if (!(lllllllllllllIlllIIlIlllllIIIlII instanceof Map)) {
                return false;
            }
            final Map<?, ?> lllllllllllllIlllIIlIlllllIIIIll = (Map<?, ?>)lllllllllllllIlllIIlIlllllIIIlII;
            return lllllllllllllIlllIIlIlllllIIIIll.size() == 1 && lllllllllllllIlllIIlIlllllIIIIll.entrySet().iterator().next().equals(this.entrySet().iterator().next());
        }
        
        @Override
        public IntCollection values() {
            if (this.values == null) {
                this.values = IntSets.singleton(this.value);
            }
            return this.values;
        }
        
        @Deprecated
        @Override
        public ObjectSet<Map.Entry<K, Integer>> entrySet() {
            return (ObjectSet<Map.Entry<K, Integer>>)this.object2IntEntrySet();
        }
        
        @Override
        public ObjectSet<K> keySet() {
            if (this.keys == null) {
                this.keys = ObjectSets.singleton(this.key);
            }
            return this.keys;
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
        
        protected Singleton(final K lllllllllllllIlllIIlIllllllIlIll, final int lllllllllllllIlllIIlIllllllIIlll) {
            super(lllllllllllllIlllIIlIllllllIlIll, lllllllllllllIlllIIlIllllllIIlll);
        }
        
        @Override
        public void putAll(final Map<? extends K, ? extends Integer> lllllllllllllIlllIIlIlllllIllIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Deprecated
        @Override
        public boolean containsValue(final Object lllllllllllllIlllIIlIlllllIlllIl) {
            return (int)lllllllllllllIlllIIlIlllllIlllIl == this.value;
        }
        
        @Override
        public ObjectSet<Entry<K>> object2IntEntrySet() {
            if (this.entries == null) {
                this.entries = (ObjectSet<Entry<K>>)ObjectSets.singleton(new AbstractObject2IntMap.BasicEntry<K>(this.key, this.value));
            }
            return this.entries;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("{").append(this.key).append("=>").append(this.value).append("}"));
        }
    }
}
