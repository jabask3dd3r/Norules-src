package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;
import java.util.function.*;

public interface Object2ObjectMap<K, V> extends Object2ObjectFunction<K, V>, Map<K, V>
{
    default V put(final K lllllllllllllIllIlIlIIlIlllIIIll, final V lllllllllllllIllIlIlIIlIllIlllll) {
        return super.put(lllllllllllllIllIlIlIIlIlllIIIll, lllllllllllllIllIlIlIIlIllIlllll);
    }
    
    ObjectSet<Entry<K, V>> object2ObjectEntrySet();
    
    ObjectSet<K> keySet();
    
    default ObjectSet<Map.Entry<K, V>> entrySet() {
        return (ObjectSet<Map.Entry<K, V>>)this.object2ObjectEntrySet();
    }
    
    V defaultReturnValue();
    
    boolean containsKey(final Object p0);
    
    void defaultReturnValue(final V p0);
    
    ObjectCollection<V> values();
    
    default void clear() {
        throw new UnsupportedOperationException();
    }
    
    int size();
    
    default V remove(final Object lllllllllllllIllIlIlIIlIllIllIll) {
        return super.remove(lllllllllllllIllIlIlIIlIllIllIll);
    }
    
    public interface Entry<K, V> extends Map.Entry<K, V>
    {
    }
    
    public interface FastEntrySet<K, V> extends ObjectSet<Entry<K, V>>
    {
        ObjectIterator<Entry<K, V>> fastIterator();
        
        default void fastForEach(final Consumer<? super Entry<K, V>> lllllllllllllIIllIllIIIIIlIIllII) {
            this.forEach(lllllllllllllIIllIllIIIIIlIIllII);
        }
    }
}
