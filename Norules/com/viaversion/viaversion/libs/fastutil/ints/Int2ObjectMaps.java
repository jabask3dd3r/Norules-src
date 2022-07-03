package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.function.*;
import java.io.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import java.util.*;

public final class Int2ObjectMaps
{
    public static final /* synthetic */ EmptyMap EMPTY_MAP;
    
    public static <V> Int2ObjectMap<V> singleton(final Integer llllllllllllllIIIlIIllIllllIIlll, final V llllllllllllllIIIlIIllIllllIlIII) {
        return new Singleton<V>(llllllllllllllIIIlIIllIllllIIlll, llllllllllllllIIIlIIllIllllIlIII);
    }
    
    public static <V> Int2ObjectMap<V> singleton(final int llllllllllllllIIIlIIllIllllIllll, final V llllllllllllllIIIlIIllIllllIllII) {
        return new Singleton<V>(llllllllllllllIIIlIIllIllllIllll, llllllllllllllIIIlIIllIllllIllII);
    }
    
    public static <V> Int2ObjectMap<V> synchronize(final Int2ObjectMap<V> llllllllllllllIIIlIIllIlllIllllI, final Object llllllllllllllIIIlIIllIlllIlllll) {
        return (Int2ObjectMap<V>)new Int2ObjectMaps.SynchronizedMap((Int2ObjectMap)llllllllllllllIIIlIIllIlllIllllI, llllllllllllllIIIlIIllIlllIlllll);
    }
    
    public static <V> ObjectIterator<Int2ObjectMap.Entry<V>> fastIterator(final Int2ObjectMap<V> llllllllllllllIIIlIIlllIIIIIIlII) {
        final ObjectSet<Int2ObjectMap.Entry<V>> llllllllllllllIIIlIIlllIIIIIIIll = llllllllllllllIIIlIIlllIIIIIIlII.int2ObjectEntrySet();
        return (llllllllllllllIIIlIIlllIIIIIIIll instanceof Int2ObjectMap.FastEntrySet) ? ((Int2ObjectMap.FastEntrySet)llllllllllllllIIIlIIlllIIIIIIIll).fastIterator() : llllllllllllllIIIlIIlllIIIIIIIll.iterator();
    }
    
    public static <V> void fastForEach(final Int2ObjectMap<V> llllllllllllllIIIlIIllIlllllllIl, final Consumer<? super Int2ObjectMap.Entry<V>> llllllllllllllIIIlIIllIlllllllII) {
        final ObjectSet<Int2ObjectMap.Entry<V>> llllllllllllllIIIlIIllIllllllIll = llllllllllllllIIIlIIllIlllllllIl.int2ObjectEntrySet();
        if (llllllllllllllIIIlIIllIllllllIll instanceof Int2ObjectMap.FastEntrySet) {
            ((Int2ObjectMap.FastEntrySet)llllllllllllllIIIlIIllIllllllIll).fastForEach(llllllllllllllIIIlIIllIlllllllII);
        }
        else {
            llllllllllllllIIIlIIllIllllllIll.forEach(llllllllllllllIIIlIIllIlllllllII);
        }
    }
    
    private Int2ObjectMaps() {
    }
    
    static {
        EMPTY_MAP = new EmptyMap();
    }
    
    public static <V> Int2ObjectMap<V> synchronize(final Int2ObjectMap<V> llllllllllllllIIIlIIllIllllIIIll) {
        return (Int2ObjectMap<V>)new Int2ObjectMaps.SynchronizedMap((Int2ObjectMap)llllllllllllllIIIlIIllIllllIIIll);
    }
    
    public static <V> ObjectIterable<Int2ObjectMap.Entry<V>> fastIterable(final Int2ObjectMap<V> llllllllllllllIIIlIIllIlllllIIll) {
        final ObjectSet<Int2ObjectMap.Entry<V>> llllllllllllllIIIlIIllIlllllIlII = llllllllllllllIIIlIIllIlllllIIll.int2ObjectEntrySet();
        return (llllllllllllllIIIlIIllIlllllIlII instanceof Int2ObjectMap.FastEntrySet) ? new ObjectIterable<Int2ObjectMap.Entry<V>>() {
            @Override
            public void forEach(final Consumer<? super Int2ObjectMap.Entry<V>> llllllllllllIllllllIllIIlIlIIIll) {
                ((Int2ObjectMap.FastEntrySet)llllllllllllllIIIlIIllIlllllIlII).fastForEach(llllllllllllIllllllIllIIlIlIIIll);
            }
            
            @Override
            public ObjectIterator<Int2ObjectMap.Entry<V>> iterator() {
                return ((Int2ObjectMap.FastEntrySet)llllllllllllllIIIlIIllIlllllIlII).fastIterator();
            }
        } : llllllllllllllIIIlIIllIlllllIlII;
    }
    
    public static <V> Int2ObjectMap<V> unmodifiable(final Int2ObjectMap<V> llllllllllllllIIIlIIllIlllIllIlI) {
        return (Int2ObjectMap<V>)new Int2ObjectMaps.UnmodifiableMap((Int2ObjectMap)llllllllllllllIIIlIIllIlllIllIlI);
    }
    
    public static <V> Int2ObjectMap<V> emptyMap() {
        return (Int2ObjectMap<V>)Int2ObjectMaps.EMPTY_MAP;
    }
    
    public static class Singleton<V> extends Int2ObjectFunctions.Singleton<V> implements Int2ObjectMap<V>, Serializable, Cloneable
    {
        protected transient /* synthetic */ ObjectSet<Entry<V>> entries;
        protected transient /* synthetic */ IntSet keys;
        protected transient /* synthetic */ ObjectCollection<V> values;
        
        @Override
        public boolean containsValue(final Object llllllllllllllllIIIIIIllIIIlIllI) {
            return Objects.equals(this.value, llllllllllllllllIIIIIIllIIIlIllI);
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("{").append(this.key).append("=>").append(this.value).append("}"));
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
        
        @Override
        public ObjectSet<Entry<V>> int2ObjectEntrySet() {
            if (this.entries == null) {
                this.entries = (ObjectSet<Entry<V>>)ObjectSets.singleton(new AbstractInt2ObjectMap.BasicEntry<V>(this.key, this.value));
            }
            return this.entries;
        }
        
        @Override
        public IntSet keySet() {
            if (this.keys == null) {
                this.keys = IntSets.singleton(this.key);
            }
            return this.keys;
        }
        
        @Override
        public boolean equals(final Object llllllllllllllllIIIIIIlIllllllII) {
            if (llllllllllllllllIIIIIIlIllllllII == this) {
                return true;
            }
            if (!(llllllllllllllllIIIIIIlIllllllII instanceof Map)) {
                return false;
            }
            final Map<?, ?> llllllllllllllllIIIIIIlIlllllllI = (Map<?, ?>)llllllllllllllllIIIIIIlIllllllII;
            return llllllllllllllllIIIIIIlIlllllllI.size() == 1 && llllllllllllllllIIIIIIlIlllllllI.entrySet().iterator().next().equals(this.entrySet().iterator().next());
        }
        
        @Override
        public ObjectCollection<V> values() {
            if (this.values == null) {
                this.values = ObjectSets.singleton(this.value);
            }
            return this.values;
        }
        
        @Deprecated
        @Override
        public ObjectSet<Map.Entry<Integer, V>> entrySet() {
            return (ObjectSet<Map.Entry<Integer, V>>)this.int2ObjectEntrySet();
        }
        
        @Override
        public void putAll(final Map<? extends Integer, ? extends V> llllllllllllllllIIIIIIllIIIlIlII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int hashCode() {
            return this.key ^ ((this.value == null) ? 0 : this.value.hashCode());
        }
        
        protected Singleton(final int llllllllllllllllIIIIIIllIIIlllIl, final V llllllllllllllllIIIIIIllIIIlllII) {
            super(llllllllllllllllIIIIIIllIIIlllIl, llllllllllllllllIIIIIIllIIIlllII);
        }
    }
    
    public static class EmptyMap<V> extends Int2ObjectFunctions.EmptyFunction<V> implements Int2ObjectMap<V>, Serializable, Cloneable
    {
        @Override
        public void putAll(final Map<? extends Integer, ? extends V> llllllllllllllIIllIlIlIIIIIllIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean containsValue(final Object llllllllllllllIIllIlIlIIIIIllIll) {
            return false;
        }
        
        @Override
        public String toString() {
            return "{}";
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIIllIlIlIIIIIlIIII) {
            return llllllllllllllIIllIlIlIIIIIlIIII instanceof Map && ((Map)llllllllllllllIIllIlIlIIIIIlIIII).isEmpty();
        }
        
        @Override
        public boolean isEmpty() {
            return true;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public IntSet keySet() {
            return IntSets.EMPTY_SET;
        }
        
        protected EmptyMap() {
        }
        
        @Override
        public ObjectSet<Entry<V>> int2ObjectEntrySet() {
            return (ObjectSet<Entry<V>>)ObjectSets.EMPTY_SET;
        }
        
        @Override
        public ObjectCollection<V> values() {
            return (ObjectCollection<V>)ObjectSets.EMPTY_SET;
        }
        
        @Override
        public Object clone() {
            return Int2ObjectMaps.EMPTY_MAP;
        }
    }
}
