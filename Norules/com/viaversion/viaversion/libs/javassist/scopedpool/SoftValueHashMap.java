package com.viaversion.viaversion.libs.javassist.scopedpool;

import java.util.concurrent.*;
import java.util.*;
import java.lang.ref.*;

public class SoftValueHashMap<K, V> implements Map<K, V>
{
    private /* synthetic */ Map<K, SoftValueRef<K, V>> hash;
    private /* synthetic */ ReferenceQueue<V> queue;
    
    public SoftValueHashMap() {
        this.queue = new ReferenceQueue<V>();
        this.hash = new ConcurrentHashMap<K, SoftValueRef<K, V>>();
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> lllllllllllllIllIlIllIlIllIlIlII) {
        this.processQueue();
        for (final K lllllllllllllIllIlIllIlIllIlIllI : lllllllllllllIllIlIllIlIllIlIlII.keySet()) {
            this.put(lllllllllllllIllIlIllIlIllIlIllI, lllllllllllllIllIlIllIlIllIlIlII.get(lllllllllllllIllIlIllIlIllIlIllI));
        }
    }
    
    public SoftValueHashMap(final int lllllllllllllIllIlIllIllIIIlllIl, final float lllllllllllllIllIlIllIllIIIlllll) {
        this.queue = new ReferenceQueue<V>();
        this.hash = new ConcurrentHashMap<K, SoftValueRef<K, V>>(lllllllllllllIllIlIllIllIIIlllIl, lllllllllllllIllIlIllIllIIIlllll);
    }
    
    @Override
    public Set<K> keySet() {
        this.processQueue();
        return this.hash.keySet();
    }
    
    private void processQueue() {
        if (!this.hash.isEmpty()) {
            Object lllllllllllllIllIlIllIllIIlIlIIl;
            while ((lllllllllllllIllIlIllIllIIlIlIIl = this.queue.poll()) != null) {
                if (lllllllllllllIllIlIllIllIIlIlIIl instanceof SoftValueRef) {
                    final SoftValueRef lllllllllllllIllIlIllIllIIlIlIlI = (SoftValueRef)lllllllllllllIllIlIllIllIIlIlIIl;
                    if (lllllllllllllIllIlIllIllIIlIlIIl != this.hash.get(lllllllllllllIllIlIllIllIIlIlIlI.key)) {
                        continue;
                    }
                    this.hash.remove(lllllllllllllIllIlIllIllIIlIlIlI.key);
                }
            }
        }
    }
    
    @Override
    public Collection<V> values() {
        this.processQueue();
        final List<V> lllllllllllllIllIlIllIlIllIIlIIl = new ArrayList<V>();
        for (final SoftValueRef<K, V> lllllllllllllIllIlIllIlIllIIlIll : this.hash.values()) {
            lllllllllllllIllIlIllIlIllIIlIIl.add((V)lllllllllllllIllIlIllIlIllIIlIll.get());
        }
        return lllllllllllllIllIlIllIlIllIIlIIl;
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        this.processQueue();
        final Set<Entry<K, V>> lllllllllllllIllIlIllIllIIllIIlI = new HashSet<Entry<K, V>>();
        for (final Entry<K, SoftValueRef<K, V>> lllllllllllllIllIlIllIllIIllIlII : this.hash.entrySet()) {
            lllllllllllllIllIlIllIllIIllIIlI.add((Entry<K, Object>)new AbstractMap.SimpleImmutableEntry<K, Object>(lllllllllllllIllIlIllIllIIllIlII.getKey(), lllllllllllllIllIlIllIllIIllIlII.getValue().get()));
        }
        return lllllllllllllIllIlIllIllIIllIIlI;
    }
    
    private V valueOrNull(final SoftValueRef<K, V> lllllllllllllIllIlIllIlIllIIIIlI) {
        if (null == lllllllllllllIllIlIllIlIllIIIIlI) {
            return null;
        }
        return (V)lllllllllllllIllIlIllIlIllIIIIlI.get();
    }
    
    @Override
    public boolean containsValue(final Object lllllllllllllIllIlIllIlIlllIIIII) {
        this.processQueue();
        if (null == lllllllllllllIllIlIllIlIlllIIIII) {
            return false;
        }
        for (final SoftValueRef<K, V> lllllllllllllIllIlIllIlIlllIIlII : this.hash.values()) {
            if (null != lllllllllllllIllIlIllIlIlllIIlII && lllllllllllllIllIlIllIlIlllIIIII.equals(lllllllllllllIllIlIllIlIlllIIlII.get())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public V put(final K lllllllllllllIllIlIllIlIllllIllI, final V lllllllllllllIllIlIllIlIllllIlIl) {
        this.processQueue();
        return this.valueOrNull(this.hash.put(lllllllllllllIllIlIllIlIllllIllI, (SoftValueRef<K, V>)create(lllllllllllllIllIlIllIlIllllIllI, lllllllllllllIllIlIllIlIllllIlIl, this.queue)));
    }
    
    @Override
    public V get(final Object lllllllllllllIllIlIllIlIllllllIl) {
        this.processQueue();
        return this.valueOrNull(this.hash.get(lllllllllllllIllIlIllIlIllllllIl));
    }
    
    @Override
    public boolean containsKey(final Object lllllllllllllIllIlIllIllIIIIIIll) {
        this.processQueue();
        return this.hash.containsKey(lllllllllllllIllIlIllIllIIIIIIll);
    }
    
    @Override
    public boolean isEmpty() {
        this.processQueue();
        return this.hash.isEmpty();
    }
    
    @Override
    public V remove(final Object lllllllllllllIllIlIllIlIlllIlllI) {
        this.processQueue();
        return this.valueOrNull(this.hash.remove(lllllllllllllIllIlIllIlIlllIlllI));
    }
    
    @Override
    public void clear() {
        this.processQueue();
        this.hash.clear();
    }
    
    public SoftValueHashMap(final int lllllllllllllIllIlIllIllIIIllIII) {
        this.queue = new ReferenceQueue<V>();
        this.hash = new ConcurrentHashMap<K, SoftValueRef<K, V>>(lllllllllllllIllIlIllIllIIIllIII);
    }
    
    @Override
    public int size() {
        this.processQueue();
        return this.hash.size();
    }
    
    public SoftValueHashMap(final Map<K, V> lllllllllllllIllIlIllIllIIIIllIl) {
        this(Math.max(2 * lllllllllllllIllIlIllIllIIIIllIl.size(), 11), 0.75f);
        this.putAll((Map<? extends K, ? extends V>)lllllllllllllIllIlIllIllIIIIllIl);
    }
    
    private static class SoftValueRef<K, V> extends SoftReference<V>
    {
        public /* synthetic */ K key;
        
        private static <K, V> SoftValueRef<K, V> create(final K lllllllllllllIlIIlIIllIlIllIllIl, final V lllllllllllllIlIIlIIllIlIllIllll, final ReferenceQueue<V> lllllllllllllIlIIlIIllIlIllIlIll) {
            if (lllllllllllllIlIIlIIllIlIllIllll == null) {
                return null;
            }
            return new SoftValueRef<K, V>(lllllllllllllIlIIlIIllIlIllIllIl, lllllllllllllIlIIlIIllIlIllIllll, lllllllllllllIlIIlIIllIlIllIlIll);
        }
        
        private SoftValueRef(final K lllllllllllllIlIIlIIllIlIllllIlI, final V lllllllllllllIlIIlIIllIlIllllIIl, final ReferenceQueue<V> lllllllllllllIlIIlIIllIlIllllIII) {
            super(lllllllllllllIlIIlIIllIlIllllIIl, lllllllllllllIlIIlIIllIlIllllIII);
            this.key = lllllllllllllIlIIlIIllIlIllllIlI;
        }
    }
}
