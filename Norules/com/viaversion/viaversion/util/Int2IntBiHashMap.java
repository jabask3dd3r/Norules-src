package com.viaversion.viaversion.util;

import com.google.common.base.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;

public class Int2IntBiHashMap implements Int2IntBiMap
{
    private final /* synthetic */ Int2IntBiHashMap inverse;
    private final /* synthetic */ Int2IntMap map;
    
    @Override
    public void clear() {
        this.map.clear();
        this.inverse.map.clear();
    }
    
    public Int2IntBiHashMap() {
        this.map = new Int2IntOpenHashMap();
        this.inverse = new Int2IntBiHashMap(this);
    }
    
    @Override
    public int put(final int lllllllllllllIIllIllIlIlIIIIlIlI, final int lllllllllllllIIllIllIlIlIIIIlIIl) {
        if (this.containsKey(lllllllllllllIIllIllIlIlIIIIlIlI) && lllllllllllllIIllIllIlIlIIIIlIIl == this.get(lllllllllllllIIllIllIlIlIIIIlIlI)) {
            return lllllllllllllIIllIllIlIlIIIIlIIl;
        }
        Preconditions.checkArgument(!this.containsValue(lllllllllllllIIllIllIlIlIIIIlIIl), "value already present: %s", new Object[] { lllllllllllllIIllIllIlIlIIIIlIIl });
        this.map.put(lllllllllllllIIllIllIlIlIIIIlIlI, lllllllllllllIIllIllIlIlIIIIlIIl);
        this.inverse.map.put(lllllllllllllIIllIllIlIlIIIIlIIl, lllllllllllllIIllIllIlIlIIIIlIlI);
        return this.defaultReturnValue();
    }
    
    @Override
    public ObjectSet<Int2IntMap.Entry> int2IntEntrySet() {
        return this.map.int2IntEntrySet();
    }
    
    @Override
    public boolean remove(final int lllllllllllllIIllIllIlIlIIIIIlII, final int lllllllllllllIIllIllIlIlIIIIIIll) {
        this.map.remove(lllllllllllllIIllIllIlIlIIIIIlII, lllllllllllllIIllIllIlIlIIIIIIll);
        return this.inverse.map.remove(lllllllllllllIIllIllIlIlIIIIIlII, lllllllllllllIIllIllIlIlIIIIIIll);
    }
    
    @Override
    public int get(final int lllllllllllllIIllIllIlIIlllllIlI) {
        return this.map.get(lllllllllllllIIllIllIlIIlllllIlI);
    }
    
    @Override
    public IntSet values() {
        return this.inverse.map.keySet();
    }
    
    @Override
    public int size() {
        return this.map.size();
    }
    
    @Override
    public void defaultReturnValue(final int lllllllllllllIIllIllIlIIlllIllIl) {
        this.map.defaultReturnValue(lllllllllllllIIllIllIlIIlllIllIl);
        this.inverse.map.defaultReturnValue(lllllllllllllIIllIllIlIIlllIllIl);
    }
    
    @Override
    public int defaultReturnValue() {
        return this.map.defaultReturnValue();
    }
    
    private Int2IntBiHashMap(final Int2IntBiHashMap lllllllllllllIIllIllIlIlIIIlIlll) {
        this.map = new Int2IntOpenHashMap();
        this.inverse = lllllllllllllIIllIllIlIlIIIlIlll;
    }
    
    @Override
    public IntSet keySet() {
        return this.map.keySet();
    }
    
    @Override
    public boolean containsKey(final int lllllllllllllIIllIllIlIIllIllIll) {
        return this.map.containsKey(lllllllllllllIIllIllIlIIllIllIll);
    }
    
    @Override
    public Int2IntBiMap inverse() {
        return this.inverse;
    }
    
    @Override
    public boolean containsValue(final int lllllllllllllIIllIllIlIIllIlIlIl) {
        return this.inverse.map.containsKey(lllllllllllllIIllIllIlIIllIlIlIl);
    }
    
    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
}
