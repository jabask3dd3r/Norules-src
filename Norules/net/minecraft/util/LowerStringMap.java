package net.minecraft.util;

import com.google.common.collect.*;
import java.util.*;

public class LowerStringMap<V> implements Map<String, V>
{
    private final /* synthetic */ Map<String, V> internalMap;
    
    @Override
    public void putAll(final Map<? extends String, ? extends V> llllllllllllllIllIIlllIlIIIIIIII) {
        for (final Entry<? extends String, ? extends V> llllllllllllllIllIIlllIIllllllll : llllllllllllllIllIIlllIlIIIIIIII.entrySet()) {
            this.put((String)llllllllllllllIllIIlllIIllllllll.getKey(), llllllllllllllIllIIlllIIllllllll.getValue());
        }
    }
    
    @Override
    public Set<Entry<String, V>> entrySet() {
        return this.internalMap.entrySet();
    }
    
    @Override
    public int size() {
        return this.internalMap.size();
    }
    
    @Override
    public V remove(final Object llllllllllllllIllIIlllIlIIIIIllI) {
        return this.internalMap.remove(llllllllllllllIllIIlllIlIIIIIllI.toString().toLowerCase(Locale.ROOT));
    }
    
    @Override
    public boolean containsKey(final Object llllllllllllllIllIIlllIlIIlIIIll) {
        return this.internalMap.containsKey(llllllllllllllIllIIlllIlIIlIIIll.toString().toLowerCase(Locale.ROOT));
    }
    
    @Override
    public boolean containsValue(final Object llllllllllllllIllIIlllIlIIIllIll) {
        return this.internalMap.containsKey(llllllllllllllIllIIlllIlIIIllIll);
    }
    
    public LowerStringMap() {
        this.internalMap = (Map<String, V>)Maps.newLinkedHashMap();
    }
    
    @Override
    public V get(final Object llllllllllllllIllIIlllIlIIIlIlIl) {
        return this.internalMap.get(llllllllllllllIllIIlllIlIIIlIlIl.toString().toLowerCase(Locale.ROOT));
    }
    
    @Override
    public boolean isEmpty() {
        return this.internalMap.isEmpty();
    }
    
    @Override
    public V put(final String llllllllllllllIllIIlllIlIIIIllIl, final V llllllllllllllIllIIlllIlIIIIllII) {
        return this.internalMap.put(llllllllllllllIllIIlllIlIIIIllIl.toLowerCase(Locale.ROOT), llllllllllllllIllIIlllIlIIIIllII);
    }
    
    @Override
    public Collection<V> values() {
        return this.internalMap.values();
    }
    
    @Override
    public void clear() {
        this.internalMap.clear();
    }
    
    @Override
    public Set<String> keySet() {
        return this.internalMap.keySet();
    }
}
