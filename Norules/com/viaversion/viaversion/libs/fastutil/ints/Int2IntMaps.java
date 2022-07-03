package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.function.*;
import java.io.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import java.util.*;

public final class Int2IntMaps
{
    public static final /* synthetic */ EmptyMap EMPTY_MAP;
    
    public static Int2IntMap synchronize(final Int2IntMap llllllllllllllllIllllIIllIlIllIl) {
        return (Int2IntMap)new Int2IntMaps.SynchronizedMap(llllllllllllllllIllllIIllIlIllIl);
    }
    
    public static ObjectIterable<Int2IntMap.Entry> fastIterable(final Int2IntMap llllllllllllllllIllllIIllIllllIl) {
        final ObjectSet<Int2IntMap.Entry> llllllllllllllllIllllIIllIlllllI = llllllllllllllllIllllIIllIllllIl.int2IntEntrySet();
        return (llllllllllllllllIllllIIllIlllllI instanceof Int2IntMap.FastEntrySet) ? new ObjectIterable<Int2IntMap.Entry>() {
            @Override
            public ObjectIterator<Int2IntMap.Entry> iterator() {
                return ((Int2IntMap.FastEntrySet)llllllllllllllllIllllIIllIlllllI).fastIterator();
            }
            
            @Override
            public void forEach(final Consumer<? super Int2IntMap.Entry> llllllllllllIlllllllIllllIIIllIl) {
                ((Int2IntMap.FastEntrySet)llllllllllllllllIllllIIllIlllllI).fastForEach(llllllllllllIlllllllIllllIIIllIl);
            }
        } : llllllllllllllllIllllIIllIlllllI;
    }
    
    public static ObjectIterator<Int2IntMap.Entry> fastIterator(final Int2IntMap llllllllllllllllIllllIIlllIIlllI) {
        final ObjectSet<Int2IntMap.Entry> llllllllllllllllIllllIIlllIIllIl = llllllllllllllllIllllIIlllIIlllI.int2IntEntrySet();
        return (llllllllllllllllIllllIIlllIIllIl instanceof Int2IntMap.FastEntrySet) ? ((Int2IntMap.FastEntrySet)llllllllllllllllIllllIIlllIIllIl).fastIterator() : llllllllllllllllIllllIIlllIIllIl.iterator();
    }
    
    private Int2IntMaps() {
    }
    
    public static Int2IntMap synchronize(final Int2IntMap llllllllllllllllIllllIIllIlIlIII, final Object llllllllllllllllIllllIIllIlIIlll) {
        return (Int2IntMap)new Int2IntMaps.SynchronizedMap(llllllllllllllllIllllIIllIlIlIII, llllllllllllllllIllllIIllIlIIlll);
    }
    
    public static Int2IntMap singleton(final Integer llllllllllllllllIllllIIllIllIIll, final Integer llllllllllllllllIllllIIllIllIIlI) {
        return new Singleton(llllllllllllllllIllllIIllIllIIll, llllllllllllllllIllllIIllIllIIlI);
    }
    
    public static Int2IntMap singleton(final int llllllllllllllllIllllIIllIlllIIl, final int llllllllllllllllIllllIIllIllIllI) {
        return new Singleton(llllllllllllllllIllllIIllIlllIIl, llllllllllllllllIllllIIllIllIllI);
    }
    
    public static void fastForEach(final Int2IntMap llllllllllllllllIllllIIlllIIIlII, final Consumer<? super Int2IntMap.Entry> llllllllllllllllIllllIIlllIIIIll) {
        final ObjectSet<Int2IntMap.Entry> llllllllllllllllIllllIIlllIIIlIl = llllllllllllllllIllllIIlllIIIlII.int2IntEntrySet();
        if (llllllllllllllllIllllIIlllIIIlIl instanceof Int2IntMap.FastEntrySet) {
            ((Int2IntMap.FastEntrySet)llllllllllllllllIllllIIlllIIIlIl).fastForEach(llllllllllllllllIllllIIlllIIIIll);
        }
        else {
            llllllllllllllllIllllIIlllIIIlIl.forEach(llllllllllllllllIllllIIlllIIIIll);
        }
    }
    
    static {
        EMPTY_MAP = new EmptyMap();
    }
    
    public static Int2IntMap unmodifiable(final Int2IntMap llllllllllllllllIllllIIllIlIIlII) {
        return (Int2IntMap)new Int2IntMaps.UnmodifiableMap(llllllllllllllllIllllIIllIlIIlII);
    }
    
    public static class EmptyMap extends Int2IntFunctions.EmptyFunction implements Cloneable, Int2IntMap, Serializable
    {
        @Override
        public Object clone() {
            return Int2IntMaps.EMPTY_MAP;
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllllIllIIlllllllIIlII) {
            return lllllllllllllllIllIIlllllllIIlII instanceof Map && ((Map)lllllllllllllllIllIIlllllllIIlII).isEmpty();
        }
        
        @Deprecated
        @Override
        public boolean containsValue(final Object lllllllllllllllIllIIllllllllIIII) {
            return false;
        }
        
        @Override
        public String toString() {
            return "{}";
        }
        
        protected EmptyMap() {
        }
        
        @Override
        public boolean isEmpty() {
            return true;
        }
        
        @Override
        public IntSet keySet() {
            return IntSets.EMPTY_SET;
        }
        
        @Override
        public ObjectSet<Entry> int2IntEntrySet() {
            return (ObjectSet<Entry>)ObjectSets.EMPTY_SET;
        }
        
        @Override
        public boolean containsValue(final int lllllllllllllllIllIIllllllllIIlI) {
            return false;
        }
        
        @Override
        public void putAll(final Map<? extends Integer, ? extends Integer> lllllllllllllllIllIIlllllllIlllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntCollection values() {
            return IntSets.EMPTY_SET;
        }
    }
    
    public static class Singleton extends Int2IntFunctions.Singleton implements Cloneable, Serializable, Int2IntMap
    {
        protected transient /* synthetic */ IntSet keys;
        protected transient /* synthetic */ IntCollection values;
        protected transient /* synthetic */ ObjectSet<Entry> entries;
        
        @Override
        public ObjectSet<Entry> int2IntEntrySet() {
            if (this.entries == null) {
                this.entries = (ObjectSet<Entry>)ObjectSets.singleton(new AbstractInt2IntMap.BasicEntry(this.key, this.value));
            }
            return this.entries;
        }
        
        protected Singleton(final int lllllllllllllIIllIllIIIIllIIIIlI, final int lllllllllllllIIllIllIIIIllIIIIIl) {
            super(lllllllllllllIIllIllIIIIllIIIIlI, lllllllllllllIIllIllIIIIllIIIIIl);
        }
        
        @Override
        public boolean isEmpty() {
            return false;
        }
        
        @Override
        public int hashCode() {
            return this.key ^ this.value;
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
        public boolean containsValue(final Object lllllllllllllIIllIllIIIIlIllIlII) {
            return (int)lllllllllllllIIllIllIIIIlIllIlII == this.value;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIIllIllIIIIlIIllIII) {
            if (lllllllllllllIIllIllIIIIlIIllIII == this) {
                return true;
            }
            if (!(lllllllllllllIIllIllIIIIlIIllIII instanceof Map)) {
                return false;
            }
            final Map<?, ?> lllllllllllllIIllIllIIIIlIIllIlI = (Map<?, ?>)lllllllllllllIIllIllIIIIlIIllIII;
            return lllllllllllllIIllIllIIIIlIIllIlI.size() == 1 && lllllllllllllIIllIllIIIIlIIllIlI.entrySet().iterator().next().equals(this.entrySet().iterator().next());
        }
        
        @Override
        public IntSet keySet() {
            if (this.keys == null) {
                this.keys = IntSets.singleton(this.key);
            }
            return this.keys;
        }
        
        @Override
        public boolean containsValue(final int lllllllllllllIIllIllIIIIlIlllIII) {
            return this.value == lllllllllllllIIllIllIIIIlIlllIII;
        }
        
        @Deprecated
        @Override
        public ObjectSet<Map.Entry<Integer, Integer>> entrySet() {
            return (ObjectSet<Map.Entry<Integer, Integer>>)this.int2IntEntrySet();
        }
        
        @Override
        public void putAll(final Map<? extends Integer, ? extends Integer> lllllllllllllIIllIllIIIIlIllIIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("{").append(this.key).append("=>").append(this.value).append("}"));
        }
    }
}
