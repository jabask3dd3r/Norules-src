package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;
import java.util.function.*;
import java.io.*;
import java.util.*;

public class Object2ObjectOpenHashMap<K, V> extends AbstractObject2ObjectMap<K, V> implements Serializable, Cloneable, Hash
{
    protected transient /* synthetic */ boolean containsNullKey;
    protected transient /* synthetic */ V[] value;
    protected transient /* synthetic */ ObjectCollection<V> values;
    protected final transient /* synthetic */ int minN;
    protected final /* synthetic */ float f;
    protected transient /* synthetic */ Object2ObjectMap.FastEntrySet<K, V> entries;
    protected transient /* synthetic */ ObjectSet<K> keys;
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ K[] key;
    protected transient /* synthetic */ int mask;
    protected /* synthetic */ int size;
    protected transient /* synthetic */ int n;
    
    @Override
    public V remove(final Object lllllllllllllIllIIllIlIIIIlIIIII) {
        if (lllllllllllllIllIIllIlIIIIlIIIII == null) {
            if (this.containsNullKey) {
                return this.removeNullEntry();
            }
            return this.defRetValue;
        }
        else {
            final K[] lllllllllllllIllIIllIlIIIIlIIIll = this.key;
            int lllllllllllllIllIIllIlIIIIlIIIlI;
            K lllllllllllllIllIIllIlIIIIlIIlII;
            if ((lllllllllllllIllIIllIlIIIIlIIlII = lllllllllllllIllIIllIlIIIIlIIIll[lllllllllllllIllIIllIlIIIIlIIIlI = (HashCommon.mix(lllllllllllllIllIIllIlIIIIlIIIII.hashCode()) & this.mask)]) == null) {
                return this.defRetValue;
            }
            if (lllllllllllllIllIIllIlIIIIlIIIII.equals(lllllllllllllIllIIllIlIIIIlIIlII)) {
                return this.removeEntry(lllllllllllllIllIIllIlIIIIlIIIlI);
            }
            while ((lllllllllllllIllIIllIlIIIIlIIlII = lllllllllllllIllIIllIlIIIIlIIIll[lllllllllllllIllIIllIlIIIIlIIIlI = (lllllllllllllIllIIllIlIIIIlIIIlI + 1 & this.mask)]) != null) {
                if (lllllllllllllIllIIllIlIIIIlIIIII.equals(lllllllllllllIllIIllIlIIIIlIIlII)) {
                    return this.removeEntry(lllllllllllllIllIIllIlIIIIlIIIlI);
                }
            }
            return this.defRetValue;
        }
    }
    
    public Object2ObjectOpenHashMap(final Object2ObjectMap<K, V> lllllllllllllIllIIllIlIlIIlIIllI) {
        this(lllllllllllllIllIIllIlIlIIlIIllI, 0.75f);
    }
    
    @Override
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractObjectCollection<V>() {
                @Override
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }
                
                @Override
                public void clear() {
                    Object2ObjectOpenHashMap.this.clear();
                }
                
                @Override
                public void forEach(final Consumer<? super V> lllllllllllllIIlIIlIlIIIIIllIIIl) {
                    if (Object2ObjectOpenHashMap.this.containsNullKey) {
                        lllllllllllllIIlIIlIlIIIIIllIIIl.accept((Object)Object2ObjectOpenHashMap.this.value[Object2ObjectOpenHashMap.this.n]);
                    }
                    int lllllllllllllIIlIIlIlIIIIIllIlIl = Object2ObjectOpenHashMap.this.n;
                    while (lllllllllllllIIlIIlIlIIIIIllIlIl-- != 0) {
                        if (Object2ObjectOpenHashMap.this.key[lllllllllllllIIlIIlIlIIIIIllIlIl] != null) {
                            lllllllllllllIIlIIlIlIIIIIllIIIl.accept((Object)Object2ObjectOpenHashMap.this.value[lllllllllllllIIlIIlIlIIIIIllIlIl]);
                        }
                    }
                }
                
                @Override
                public int size() {
                    return Object2ObjectOpenHashMap.this.size;
                }
                
                @Override
                public boolean contains(final Object lllllllllllllIIlIIlIlIIIIIllllII) {
                    return Object2ObjectOpenHashMap.this.containsValue(lllllllllllllIIlIIlIlIIIIIllllII);
                }
            };
        }
        return this.values;
    }
    
    private void insert(final int lllllllllllllIllIIllIlIIIlIlllIl, final K lllllllllllllIllIIllIlIIIlIllIII, final V lllllllllllllIllIIllIlIIIlIllIll) {
        if (lllllllllllllIllIIllIlIIIlIlllIl == this.n) {
            this.containsNullKey = true;
        }
        this.key[lllllllllllllIllIIllIlIIIlIlllIl] = lllllllllllllIllIIllIlIIIlIllIII;
        this.value[lllllllllllllIllIIllIlIIIlIlllIl] = lllllllllllllIllIIllIlIIIlIllIll;
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
    }
    
    private void tryCapacity(final long lllllllllllllIllIIllIlIIlllIllII) {
        final int lllllllllllllIllIIllIlIIlllIllll = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(lllllllllllllIllIIllIlIIlllIllII / this.f))));
        if (lllllllllllllIllIIllIlIIlllIllll > this.n) {
            this.rehash(lllllllllllllIllIIllIlIIlllIllll);
        }
    }
    
    @Override
    public boolean containsKey(final Object lllllllllllllIllIIllIlIIIIIIIIlI) {
        if (lllllllllllllIllIIllIlIIIIIIIIlI == null) {
            return this.containsNullKey;
        }
        final K[] lllllllllllllIllIIllIlIIIIIIIlIl = this.key;
        int lllllllllllllIllIIllIlIIIIIIIlII;
        K lllllllllllllIllIIllIlIIIIIIIllI;
        if ((lllllllllllllIllIIllIlIIIIIIIllI = lllllllllllllIllIIllIlIIIIIIIlIl[lllllllllllllIllIIllIlIIIIIIIlII = (HashCommon.mix(lllllllllllllIllIIllIlIIIIIIIIlI.hashCode()) & this.mask)]) == null) {
            return false;
        }
        if (lllllllllllllIllIIllIlIIIIIIIIlI.equals(lllllllllllllIllIIllIlIIIIIIIllI)) {
            return true;
        }
        while ((lllllllllllllIllIIllIlIIIIIIIllI = lllllllllllllIllIIllIlIIIIIIIlIl[lllllllllllllIllIIllIlIIIIIIIlII = (lllllllllllllIllIIllIlIIIIIIIlII + 1 & this.mask)]) != null) {
            if (lllllllllllllIllIIllIlIIIIIIIIlI.equals(lllllllllllllIllIIllIlIIIIIIIllI)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    public boolean trim(final int lllllllllllllIllIIllIIllllIlIlII) {
        final int lllllllllllllIllIIllIIllllIlIIll = HashCommon.nextPowerOfTwo((int)Math.ceil(lllllllllllllIllIIllIIllllIlIlII / this.f));
        if (lllllllllllllIllIIllIIllllIlIIll >= this.n || this.size > HashCommon.maxFill(lllllllllllllIllIIllIIllllIlIIll, this.f)) {
            return true;
        }
        try {
            this.rehash(lllllllllllllIllIIllIIllllIlIIll);
        }
        catch (OutOfMemoryError lllllllllllllIllIIllIIllllIlIllI) {
            return false;
        }
        return true;
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> lllllllllllllIllIIllIlIIlIlIlIIl) {
        if (this.f <= 0.5) {
            this.ensureCapacity(lllllllllllllIllIIllIlIIlIlIlIIl.size());
        }
        else {
            this.tryCapacity(this.size() + lllllllllllllIllIIllIlIIlIlIlIIl.size());
        }
        super.putAll(lllllllllllllIllIIllIlIIlIlIlIIl);
    }
    
    public Object2ObjectOpenHashMap() {
        this(16, 0.75f);
    }
    
    protected final void shiftKeys(int lllllllllllllIllIIllIlIIIIllIIII) {
        final K[] lllllllllllllIllIIllIlIIIIllIIlI = this.key;
        int lllllllllllllIllIIllIlIIIIllIlIl = 0;
    Label_0006:
        while (true) {
            lllllllllllllIllIIllIlIIIIllIIII = ((lllllllllllllIllIIllIlIIIIllIlIl = lllllllllllllIllIIllIlIIIIllIIII) + 1 & this.mask);
            K lllllllllllllIllIIllIlIIIIllIIll;
            while ((lllllllllllllIllIIllIlIIIIllIIll = lllllllllllllIllIIllIlIIIIllIIlI[lllllllllllllIllIIllIlIIIIllIIII]) != null) {
                final int lllllllllllllIllIIllIlIIIIllIlII = HashCommon.mix(lllllllllllllIllIIllIlIIIIllIIll.hashCode()) & this.mask;
                Label_0097: {
                    if (lllllllllllllIllIIllIlIIIIllIlIl <= lllllllllllllIllIIllIlIIIIllIIII) {
                        if (lllllllllllllIllIIllIlIIIIllIlIl >= lllllllllllllIllIIllIlIIIIllIlII) {
                            break Label_0097;
                        }
                        if (lllllllllllllIllIIllIlIIIIllIlII > lllllllllllllIllIIllIlIIIIllIIII) {
                            break Label_0097;
                        }
                    }
                    else if (lllllllllllllIllIIllIlIIIIllIlIl >= lllllllllllllIllIIllIlIIIIllIlII && lllllllllllllIllIIllIlIIIIllIlII > lllllllllllllIllIIllIlIIIIllIIII) {
                        break Label_0097;
                    }
                    lllllllllllllIllIIllIlIIIIllIIII = (lllllllllllllIllIIllIlIIIIllIIII + 1 & this.mask);
                    continue;
                }
                lllllllllllllIllIIllIlIIIIllIIlI[lllllllllllllIllIIllIlIIIIllIlIl] = lllllllllllllIllIIllIlIIIIllIIll;
                this.value[lllllllllllllIllIIllIlIIIIllIlIl] = this.value[lllllllllllllIllIIllIlIIIIllIIII];
                continue Label_0006;
            }
            break;
        }
        lllllllllllllIllIIllIlIIIIllIIlI[lllllllllllllIllIIllIlIIIIllIlIl] = null;
        this.value[lllllllllllllIllIIllIlIIIIllIlIl] = null;
    }
    
    private int realSize() {
        return this.containsNullKey ? (this.size - 1) : this.size;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    private void checkTable() {
    }
    
    @Override
    public V put(final K lllllllllllllIllIIllIlIIIlIIlIll, final V lllllllllllllIllIIllIlIIIlIIllll) {
        final int lllllllllllllIllIIllIlIIIlIIlllI = this.find(lllllllllllllIllIIllIlIIIlIIlIll);
        if (lllllllllllllIllIIllIlIIIlIIlllI < 0) {
            this.insert(-lllllllllllllIllIIllIlIIIlIIlllI - 1, lllllllllllllIllIIllIlIIIlIIlIll, lllllllllllllIllIIllIlIIIlIIllll);
            return this.defRetValue;
        }
        final V lllllllllllllIllIIllIlIIIlIIllIl = this.value[lllllllllllllIllIIllIlIIIlIIlllI];
        this.value[lllllllllllllIllIIllIlIIIlIIlllI] = lllllllllllllIllIIllIlIIIlIIllll;
        return lllllllllllllIllIIllIlIIIlIIllIl;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    private V removeEntry(final int lllllllllllllIllIIllIlIIllIIlIlI) {
        final V lllllllllllllIllIIllIlIIllIIlllI = this.value[lllllllllllllIllIIllIlIIllIIlIlI];
        this.value[lllllllllllllIllIIllIlIIllIIlIlI] = null;
        --this.size;
        this.shiftKeys(lllllllllllllIllIIllIlIIllIIlIlI);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIllIIllIlIIllIIlllI;
    }
    
    public Object2ObjectOpenHashMap(final Object2ObjectMap<K, V> lllllllllllllIllIIllIlIlIIlIlllI, final float lllllllllllllIllIIllIlIlIIlIlIlI) {
        this(lllllllllllllIllIIllIlIlIIlIlllI.size(), lllllllllllllIllIIllIlIlIIlIlIlI);
        this.putAll((Map<? extends K, ? extends V>)lllllllllllllIllIIllIlIlIIlIlllI);
    }
    
    public Object2ObjectOpenHashMap(final int lllllllllllllIllIIllIlIlIlIIIlll) {
        this(lllllllllllllIllIIllIlIlIlIIIlll, 0.75f);
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllIllIIllIIlllIIIlIII) throws IOException {
        final K[] lllllllllllllIllIIllIIlllIIIllII = this.key;
        final V[] lllllllllllllIllIIllIIlllIIIlIll = this.value;
        final MapIterator lllllllllllllIllIIllIIlllIIIlIlI = new MapIterator();
        lllllllllllllIllIIllIIlllIIIlIII.defaultWriteObject();
        int lllllllllllllIllIIllIIlllIIlIIII = this.size;
        while (lllllllllllllIllIIllIIlllIIlIIII-- != 0) {
            final int lllllllllllllIllIIllIIlllIIIllll = lllllllllllllIllIIllIIlllIIIlIlI.nextEntry();
            lllllllllllllIllIIllIIlllIIIlIII.writeObject(lllllllllllllIllIIllIIlllIIIllII[lllllllllllllIllIIllIIlllIIIllll]);
            lllllllllllllIllIIllIIlllIIIlIII.writeObject(lllllllllllllIllIIllIIlllIIIlIll[lllllllllllllIllIIllIIlllIIIllll]);
        }
    }
    
    public Object2ObjectOpenHashMap(final Map<? extends K, ? extends V> lllllllllllllIllIIllIlIlIIlllIlI, final float lllllllllllllIllIIllIlIlIIllllII) {
        this(lllllllllllllIllIIllIlIlIIlllIlI.size(), lllllllllllllIllIIllIlIlIIllllII);
        this.putAll(lllllllllllllIllIIllIlIlIIlllIlI);
    }
    
    @Override
    public V get(final Object lllllllllllllIllIIllIlIIIIIlIIIl) {
        if (lllllllllllllIllIIllIlIIIIIlIIIl == null) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        }
        final K[] lllllllllllllIllIIllIlIIIIIlIlII = this.key;
        int lllllllllllllIllIIllIlIIIIIlIIll;
        K lllllllllllllIllIIllIlIIIIIlIlIl;
        if ((lllllllllllllIllIIllIlIIIIIlIlIl = lllllllllllllIllIIllIlIIIIIlIlII[lllllllllllllIllIIllIlIIIIIlIIll = (HashCommon.mix(lllllllllllllIllIIllIlIIIIIlIIIl.hashCode()) & this.mask)]) == null) {
            return this.defRetValue;
        }
        if (lllllllllllllIllIIllIlIIIIIlIIIl.equals(lllllllllllllIllIIllIlIIIIIlIlIl)) {
            return this.value[lllllllllllllIllIIllIlIIIIIlIIll];
        }
        while ((lllllllllllllIllIIllIlIIIIIlIlIl = lllllllllllllIllIIllIlIIIIIlIlII[lllllllllllllIllIIllIlIIIIIlIIll = (lllllllllllllIllIIllIlIIIIIlIIll + 1 & this.mask)]) != null) {
            if (lllllllllllllIllIIllIlIIIIIlIIIl.equals(lllllllllllllIllIIllIlIIIIIlIlIl)) {
                return this.value[lllllllllllllIllIIllIlIIIIIlIIll];
            }
        }
        return this.defRetValue;
    }
    
    @Override
    public ObjectSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }
    
    static {
        ASSERTS = false;
    }
    
    @Override
    public boolean containsValue(final Object lllllllllllllIllIIllIIllllllIIll) {
        final V[] lllllllllllllIllIIllIIllllllIllI = this.value;
        final K[] lllllllllllllIllIIllIIllllllIlIl = this.key;
        if (this.containsNullKey && Objects.equals(lllllllllllllIllIIllIIllllllIllI[this.n], lllllllllllllIllIIllIIllllllIIll)) {
            return true;
        }
        int lllllllllllllIllIIllIIlllllllIIl = this.n;
        while (lllllllllllllIllIIllIIlllllllIIl-- != 0) {
            if (lllllllllllllIllIIllIIllllllIlIl[lllllllllllllIllIIllIIlllllllIIl] != null && Objects.equals(lllllllllllllIllIIllIIllllllIllI[lllllllllllllIllIIllIIlllllllIIl], lllllllllllllIllIIllIIllllllIIll)) {
                return true;
            }
        }
        return false;
    }
    
    private V removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.n] = null;
        final V lllllllllllllIllIIllIlIIlIlllIlI = this.value[this.n];
        this.value[this.n] = null;
        --this.size;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIllIIllIlIIlIlllIlI;
    }
    
    private void ensureCapacity(final int lllllllllllllIllIIllIlIlIIIIIlII) {
        final int lllllllllllllIllIIllIlIlIIIIIIll = HashCommon.arraySize(lllllllllllllIllIIllIlIlIIIIIlII, this.f);
        if (lllllllllllllIllIIllIlIlIIIIIIll > this.n) {
            this.rehash(lllllllllllllIllIIllIlIlIIIIIIll);
        }
    }
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNullKey = false;
        Arrays.fill(this.key, null);
        Arrays.fill(this.value, null);
    }
    
    protected void rehash(final int lllllllllllllIllIIllIIlllIlllIIl) {
        final K[] lllllllllllllIllIIllIIllllIIIIII = this.key;
        final V[] lllllllllllllIllIIllIIlllIllllll = this.value;
        final int lllllllllllllIllIIllIIlllIlllllI = lllllllllllllIllIIllIIlllIlllIIl - 1;
        final K[] lllllllllllllIllIIllIIlllIllllIl = (K[])new Object[lllllllllllllIllIIllIIlllIlllIIl + 1];
        final V[] lllllllllllllIllIIllIIlllIllllII = (V[])new Object[lllllllllllllIllIIllIIlllIlllIIl + 1];
        int lllllllllllllIllIIllIIlllIlllIll = this.n;
        int lllllllllllllIllIIllIIllllIIIIll = this.realSize();
        while (lllllllllllllIllIIllIIllllIIIIll-- != 0) {
            while (lllllllllllllIllIIllIIllllIIIIII[--lllllllllllllIllIIllIIlllIlllIll] == null) {}
            int lllllllllllllIllIIllIIllllIIIlII;
            if (lllllllllllllIllIIllIIlllIllllIl[lllllllllllllIllIIllIIllllIIIlII = (HashCommon.mix(lllllllllllllIllIIllIIllllIIIIII[lllllllllllllIllIIllIIlllIlllIll].hashCode()) & lllllllllllllIllIIllIIlllIlllllI)] != null) {
                while (lllllllllllllIllIIllIIlllIllllIl[lllllllllllllIllIIllIIllllIIIlII = (lllllllllllllIllIIllIIllllIIIlII + 1 & lllllllllllllIllIIllIIlllIlllllI)] != null) {}
            }
            lllllllllllllIllIIllIIlllIllllIl[lllllllllllllIllIIllIIllllIIIlII] = lllllllllllllIllIIllIIllllIIIIII[lllllllllllllIllIIllIIlllIlllIll];
            lllllllllllllIllIIllIIlllIllllII[lllllllllllllIllIIllIIllllIIIlII] = lllllllllllllIllIIllIIlllIllllll[lllllllllllllIllIIllIIlllIlllIll];
        }
        lllllllllllllIllIIllIIlllIllllII[lllllllllllllIllIIllIIlllIlllIIl] = lllllllllllllIllIIllIIlllIllllll[this.n];
        this.n = lllllllllllllIllIIllIIlllIlllIIl;
        this.mask = lllllllllllllIllIIllIIlllIlllllI;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = lllllllllllllIllIIllIIlllIllllIl;
        this.value = lllllllllllllIllIIllIIlllIllllII;
    }
    
    public Object2ObjectOpenHashMap<K, V> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap;
        //     7: astore_1        /* lllllllllllllIllIIllIIlllIlIllIl */
        //     8: goto            20
        //    11: astore_2        /* lllllllllllllIllIIllIIlllIlIllII */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllllIllIIllIIlllIlIlIlI */
        //    21: aconst_null    
        //    22: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap.keys:Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectSet;
        //    25: aload_1         /* lllllllllllllIllIIllIIlllIlIlIlI */
        //    26: aconst_null    
        //    27: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap.values:Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectCollection;
        //    30: aload_1         /* lllllllllllllIllIIllIIlllIlIlIlI */
        //    31: aconst_null    
        //    32: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap.entries:Lcom/viaversion/viaversion/libs/fastutil/objects/Object2ObjectMap$FastEntrySet;
        //    35: aload_1         /* lllllllllllllIllIIllIIlllIlIlIlI */
        //    36: aload_0         /* lllllllllllllIllIIllIIlllIlIlIIl */
        //    37: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap.containsNullKey:Z
        //    40: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap.containsNullKey:Z
        //    43: aload_1         /* lllllllllllllIllIIllIIlllIlIlIlI */
        //    44: aload_0         /* lllllllllllllIllIIllIIlllIlIlIIl */
        //    45: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap.key:[Ljava/lang/Object;
        //    48: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    51: checkcast       [Ljava/lang/Object;
        //    54: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap.key:[Ljava/lang/Object;
        //    57: aload_1         /* lllllllllllllIllIIllIIlllIlIlIlI */
        //    58: aload_0         /* lllllllllllllIllIIllIIlllIlIlIIl */
        //    59: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap.value:[Ljava/lang/Object;
        //    62: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    65: checkcast       [Ljava/lang/Object;
        //    68: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap.value:[Ljava/lang/Object;
        //    71: aload_1         /* lllllllllllllIllIIllIIlllIlIlIlI */
        //    72: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/objects/Object2ObjectOpenHashMap<TK;TV;>;
        //    StackMapTable: 00 02 4B 07 01 EB FC 00 08 07 00 02
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  0      8      11     20     Ljava/lang/CloneNotSupportedException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public Object2ObjectOpenHashMap(final Map<? extends K, ? extends V> lllllllllllllIllIIllIlIlIIllIIll) {
        this(lllllllllllllIllIIllIlIlIIllIIll, 0.75f);
    }
    
    public Object2ObjectOpenHashMap(final int lllllllllllllIllIIllIlIlIlIIllII, final float lllllllllllllIllIIllIlIlIlIIlIll) {
        if (lllllllllllllIllIIllIlIlIlIIlIll <= 0.0f || lllllllllllllIllIIllIlIlIlIIlIll > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (lllllllllllllIllIIllIlIlIlIIllII < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = lllllllllllllIllIIllIlIlIlIIlIll;
        final int arraySize = HashCommon.arraySize(lllllllllllllIllIIllIlIlIlIIllII, lllllllllllllIllIIllIlIlIlIIlIll);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, lllllllllllllIllIIllIlIlIlIIlIll);
        this.key = (K[])new Object[this.n + 1];
        this.value = (V[])new Object[this.n + 1];
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIllIIllIIlllIIlllIl = 0;
        int lllllllllllllIllIIllIIlllIlIIIIl = this.realSize();
        int lllllllllllllIllIIllIIlllIlIIIII = 0;
        int lllllllllllllIllIIllIIlllIIlllll = 0;
        while (lllllllllllllIllIIllIIlllIlIIIIl-- != 0) {
            while (this.key[lllllllllllllIllIIllIIlllIlIIIII] == null) {
                ++lllllllllllllIllIIllIIlllIlIIIII;
            }
            if (this != this.key[lllllllllllllIllIIllIIlllIlIIIII]) {
                lllllllllllllIllIIllIIlllIIlllll = this.key[lllllllllllllIllIIllIIlllIlIIIII].hashCode();
            }
            if (this != this.value[lllllllllllllIllIIllIIlllIlIIIII]) {
                lllllllllllllIllIIllIIlllIIlllll ^= ((this.value[lllllllllllllIllIIllIIlllIlIIIII] == null) ? 0 : this.value[lllllllllllllIllIIllIIlllIlIIIII].hashCode());
            }
            lllllllllllllIllIIllIIlllIIlllIl += lllllllllllllIllIIllIIlllIIlllll;
            ++lllllllllllllIllIIllIIlllIlIIIII;
        }
        if (this.containsNullKey) {
            lllllllllllllIllIIllIIlllIIlllIl += ((this.value[this.n] == null) ? 0 : this.value[this.n].hashCode());
        }
        return lllllllllllllIllIIllIIlllIIlllIl;
    }
    
    private void readObject(final ObjectInputStream lllllllllllllIllIIllIIllIlllIIII) throws ClassNotFoundException, IOException {
        lllllllllllllIllIIllIIllIlllIIII.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final Object[] key = new Object[this.n + 1];
        this.key = (K[])key;
        final K[] lllllllllllllIllIIllIIllIlllIIll = (K[])key;
        final Object[] value = new Object[this.n + 1];
        this.value = (V[])value;
        final V[] lllllllllllllIllIIllIIllIlllIIlI = (V[])value;
        int lllllllllllllIllIIllIIllIlllIlll = this.size;
        while (lllllllllllllIllIIllIIllIlllIlll-- != 0) {
            final K lllllllllllllIllIIllIIllIllllIIl = (K)lllllllllllllIllIIllIIllIlllIIII.readObject();
            final V lllllllllllllIllIIllIIllIllllIII = (V)lllllllllllllIllIIllIIllIlllIIII.readObject();
            int lllllllllllllIllIIllIIllIlllIllI = 0;
            if (lllllllllllllIllIIllIIllIllllIIl == null) {
                final int lllllllllllllIllIIllIIllIllllIlI = this.n;
                this.containsNullKey = true;
            }
            else {
                for (lllllllllllllIllIIllIIllIlllIllI = (HashCommon.mix(lllllllllllllIllIIllIIllIllllIIl.hashCode()) & this.mask); lllllllllllllIllIIllIIllIlllIIll[lllllllllllllIllIIllIIllIlllIllI] != null; lllllllllllllIllIIllIIllIlllIllI = (lllllllllllllIllIIllIIllIlllIllI + 1 & this.mask)) {}
            }
            lllllllllllllIllIIllIIllIlllIIll[lllllllllllllIllIIllIIllIlllIllI] = lllllllllllllIllIIllIIllIllllIIl;
            lllllllllllllIllIIllIIllIlllIIlI[lllllllllllllIllIIllIIllIlllIllI] = lllllllllllllIllIIllIIllIllllIII;
        }
    }
    
    private int find(final K lllllllllllllIllIIllIlIIIllIlIll) {
        if (lllllllllllllIllIIllIlIIIllIlIll == null) {
            return this.containsNullKey ? this.n : (-(this.n + 1));
        }
        final K[] lllllllllllllIllIIllIlIIIllIlIIl = this.key;
        int lllllllllllllIllIIllIlIIIllIlIII;
        K lllllllllllllIllIIllIlIIIllIlIlI;
        if ((lllllllllllllIllIIllIlIIIllIlIlI = lllllllllllllIllIIllIlIIIllIlIIl[lllllllllllllIllIIllIlIIIllIlIII = (HashCommon.mix(lllllllllllllIllIIllIlIIIllIlIll.hashCode()) & this.mask)]) == null) {
            return -(lllllllllllllIllIIllIlIIIllIlIII + 1);
        }
        if (lllllllllllllIllIIllIlIIIllIlIll.equals(lllllllllllllIllIIllIlIIIllIlIlI)) {
            return lllllllllllllIllIIllIlIIIllIlIII;
        }
        while ((lllllllllllllIllIIllIlIIIllIlIlI = lllllllllllllIllIIllIlIIIllIlIIl[lllllllllllllIllIIllIlIIIllIlIII = (lllllllllllllIllIIllIlIIIllIlIII + 1 & this.mask)]) != null) {
            if (lllllllllllllIllIIllIlIIIllIlIll.equals(lllllllllllllIllIIllIlIIIllIlIlI)) {
                return lllllllllllllIllIIllIlIIIllIlIII;
            }
        }
        return -(lllllllllllllIllIIllIlIIIllIlIII + 1);
    }
    
    public Object2ObjectOpenHashMap(final K[] lllllllllllllIllIIllIlIlIIIlllII, final V[] lllllllllllllIllIIllIlIlIIIllIll, final float lllllllllllllIllIIllIlIlIIIlIllI) {
        this(lllllllllllllIllIIllIlIlIIIlllII.length, lllllllllllllIllIIllIlIlIIIlIllI);
        if (lllllllllllllIllIIllIlIlIIIlllII.length != lllllllllllllIllIIllIlIlIIIllIll.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The key array and the value array have different lengths (").append(lllllllllllllIllIIllIlIlIIIlllII.length).append(" and ").append(lllllllllllllIllIIllIlIlIIIllIll.length).append(")")));
        }
        for (int lllllllllllllIllIIllIlIlIIIllllI = 0; lllllllllllllIllIIllIlIlIIIllllI < lllllllllllllIllIIllIlIlIIIlllII.length; ++lllllllllllllIllIIllIlIlIIIllllI) {
            this.put(lllllllllllllIllIIllIlIlIIIlllII[lllllllllllllIllIIllIlIlIIIllllI], lllllllllllllIllIIllIlIlIIIllIll[lllllllllllllIllIIllIlIlIIIllllI]);
        }
    }
    
    @Override
    public Object2ObjectMap.FastEntrySet<K, V> object2ObjectEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }
    
    public Object2ObjectOpenHashMap(final K[] lllllllllllllIllIIllIlIlIIIIllIl, final V[] lllllllllllllIllIIllIlIlIIIIllII) {
        this(lllllllllllllIllIIllIlIlIIIIllIl, lllllllllllllIllIIllIlIlIIIIllII, 0.75f);
    }
    
    private class EntryIterator extends MapIterator implements ObjectIterator<Object2ObjectMap.Entry<K, V>>
    {
        private /* synthetic */ MapEntry entry;
        
        @Override
        public MapEntry next() {
            final MapEntry entry = new MapEntry(this.nextEntry());
            this.entry = entry;
            return entry;
        }
        
        @Override
        public void remove() {
            super.remove();
            this.entry.index = -1;
        }
    }
    
    private class MapIterator
    {
        /* synthetic */ int last;
        /* synthetic */ int pos;
        /* synthetic */ ObjectArrayList<K> wrapped;
        /* synthetic */ int c;
        /* synthetic */ boolean mustReturnNullKey;
        
        private void shiftKeys(int llllllllllllllIllIllIlIlIlIIIIll) {
            final K[] llllllllllllllIllIllIlIlIlIIIlIl = Object2ObjectOpenHashMap.this.key;
            int llllllllllllllIllIllIlIlIlIIlIII = 0;
        Label_0009:
            while (true) {
                llllllllllllllIllIllIlIlIlIIIIll = ((llllllllllllllIllIllIlIlIlIIlIII = llllllllllllllIllIllIlIlIlIIIIll) + 1 & Object2ObjectOpenHashMap.this.mask);
                K llllllllllllllIllIllIlIlIlIIIllI;
                while ((llllllllllllllIllIllIlIlIlIIIllI = llllllllllllllIllIllIlIlIlIIIlIl[llllllllllllllIllIllIlIlIlIIIIll]) != null) {
                    final int llllllllllllllIllIllIlIlIlIIIlll = HashCommon.mix(llllllllllllllIllIllIlIlIlIIIllI.hashCode()) & Object2ObjectOpenHashMap.this.mask;
                    Label_0112: {
                        if (llllllllllllllIllIllIlIlIlIIlIII <= llllllllllllllIllIllIlIlIlIIIIll) {
                            if (llllllllllllllIllIllIlIlIlIIlIII >= llllllllllllllIllIllIlIlIlIIIlll) {
                                break Label_0112;
                            }
                            if (llllllllllllllIllIllIlIlIlIIIlll > llllllllllllllIllIllIlIlIlIIIIll) {
                                break Label_0112;
                            }
                        }
                        else if (llllllllllllllIllIllIlIlIlIIlIII >= llllllllllllllIllIllIlIlIlIIIlll && llllllllllllllIllIllIlIlIlIIIlll > llllllllllllllIllIllIlIlIlIIIIll) {
                            break Label_0112;
                        }
                        llllllllllllllIllIllIlIlIlIIIIll = (llllllllllllllIllIllIlIlIlIIIIll + 1 & Object2ObjectOpenHashMap.this.mask);
                        continue;
                    }
                    if (llllllllllllllIllIllIlIlIlIIIIll < llllllllllllllIllIllIlIlIlIIlIII) {
                        if (this.wrapped == null) {
                            this.wrapped = new ObjectArrayList<K>(2);
                        }
                        this.wrapped.add(llllllllllllllIllIllIlIlIlIIIlIl[llllllllllllllIllIllIlIlIlIIIIll]);
                    }
                    llllllllllllllIllIllIlIlIlIIIlIl[llllllllllllllIllIllIlIlIlIIlIII] = llllllllllllllIllIllIlIlIlIIIllI;
                    Object2ObjectOpenHashMap.this.value[llllllllllllllIllIllIlIlIlIIlIII] = Object2ObjectOpenHashMap.this.value[llllllllllllllIllIllIlIlIlIIIIll];
                    continue Label_0009;
                }
                break;
            }
            llllllllllllllIllIllIlIlIlIIIlIl[llllllllllllllIllIllIlIlIlIIlIII] = null;
            Object2ObjectOpenHashMap.this.value[llllllllllllllIllIllIlIlIlIIlIII] = null;
        }
        
        private MapIterator() {
            this.pos = Object2ObjectOpenHashMap.this.n;
            this.last = -1;
            this.c = Object2ObjectOpenHashMap.this.size;
            this.mustReturnNullKey = Object2ObjectOpenHashMap.this.containsNullKey;
        }
        
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Object2ObjectOpenHashMap.this.n) {
                Object2ObjectOpenHashMap.this.containsNullKey = false;
                Object2ObjectOpenHashMap.this.key[Object2ObjectOpenHashMap.this.n] = null;
                Object2ObjectOpenHashMap.this.value[Object2ObjectOpenHashMap.this.n] = null;
            }
            else {
                if (this.pos < 0) {
                    Object2ObjectOpenHashMap.this.remove(this.wrapped.set(-this.pos - 1, null));
                    this.last = -1;
                    return;
                }
                this.shiftKeys(this.last);
            }
            final Object2ObjectOpenHashMap this$0 = Object2ObjectOpenHashMap.this;
            --this$0.size;
            this.last = -1;
        }
        
        public int skip(final int llllllllllllllIllIllIlIlIIllIlII) {
            int llllllllllllllIllIllIlIlIIllIllI = llllllllllllllIllIllIlIlIIllIlII;
            while (llllllllllllllIllIllIlIlIIllIllI-- != 0 && this.hasNext()) {
                this.nextEntry();
            }
            return llllllllllllllIllIllIlIlIIllIlII - llllllllllllllIllIllIlIlIIllIllI - 1;
        }
        
        public int nextEntry() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                final int n = Object2ObjectOpenHashMap.this.n;
                this.last = n;
                return n;
            }
            final K[] llllllllllllllIllIllIlIlIlIlIlIl = Object2ObjectOpenHashMap.this.key;
            while (--this.pos >= 0) {
                if (llllllllllllllIllIllIlIlIlIlIlIl[this.pos] != null) {
                    final int pos = this.pos;
                    this.last = pos;
                    return pos;
                }
            }
            this.last = Integer.MIN_VALUE;
            K llllllllllllllIllIllIlIlIlIllIII;
            int llllllllllllllIllIllIlIlIlIlIlll;
            for (llllllllllllllIllIllIlIlIlIllIII = this.wrapped.get(-this.pos - 1), llllllllllllllIllIllIlIlIlIlIlll = (HashCommon.mix(llllllllllllllIllIllIlIlIlIllIII.hashCode()) & Object2ObjectOpenHashMap.this.mask); !llllllllllllllIllIllIlIlIlIllIII.equals(llllllllllllllIllIllIlIlIlIlIlIl[llllllllllllllIllIllIlIlIlIlIlll]); llllllllllllllIllIllIlIlIlIlIlll = (llllllllllllllIllIllIlIlIlIlIlll + 1 & Object2ObjectOpenHashMap.this.mask)) {}
            return llllllllllllllIllIllIlIlIlIlIlll;
        }
        
        public boolean hasNext() {
            return this.c != 0;
        }
    }
    
    final class MapEntry implements Object2ObjectMap.Entry<K, V>, Map.Entry<K, V>
    {
        /* synthetic */ int index;
        
        MapEntry(final int llllllllllllllllIllIlllllIIlIIll) {
            this.index = llllllllllllllllIllIlllllIIlIIll;
        }
        
        @Override
        public int hashCode() {
            return ((Object2ObjectOpenHashMap.this.key[this.index] == null) ? 0 : Object2ObjectOpenHashMap.this.key[this.index].hashCode()) ^ ((Object2ObjectOpenHashMap.this.value[this.index] == null) ? 0 : Object2ObjectOpenHashMap.this.value[this.index].hashCode());
        }
        
        @Override
        public V setValue(final V llllllllllllllllIllIlllllIIIIIlI) {
            final V llllllllllllllllIllIlllllIIIIIIl = Object2ObjectOpenHashMap.this.value[this.index];
            Object2ObjectOpenHashMap.this.value[this.index] = llllllllllllllllIllIlllllIIIIIlI;
            return llllllllllllllllIllIlllllIIIIIIl;
        }
        
        MapEntry() {
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(Object2ObjectOpenHashMap.this.key[this.index]).append("=>").append(Object2ObjectOpenHashMap.this.value[this.index]));
        }
        
        @Override
        public K getKey() {
            return Object2ObjectOpenHashMap.this.key[this.index];
        }
        
        @Override
        public V getValue() {
            return Object2ObjectOpenHashMap.this.value[this.index];
        }
        
        @Override
        public boolean equals(final Object llllllllllllllllIllIllllIllllIIl) {
            if (!(llllllllllllllllIllIllllIllllIIl instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<K, V> llllllllllllllllIllIllllIllllIII = (Map.Entry<K, V>)llllllllllllllllIllIllllIllllIIl;
            return Objects.equals(Object2ObjectOpenHashMap.this.key[this.index], llllllllllllllllIllIllllIllllIII.getKey()) && Objects.equals(Object2ObjectOpenHashMap.this.value[this.index], llllllllllllllllIllIllllIllllIII.getValue());
        }
    }
    
    private final class KeySet extends AbstractObjectSet<K>
    {
        @Override
        public void forEach(final Consumer<? super K> lllllllllllllIIllllIIIIllIIlIlIl) {
            if (Object2ObjectOpenHashMap.this.containsNullKey) {
                lllllllllllllIIllllIIIIllIIlIlIl.accept((Object)Object2ObjectOpenHashMap.this.key[Object2ObjectOpenHashMap.this.n]);
            }
            int lllllllllllllIIllllIIIIllIIllIIl = Object2ObjectOpenHashMap.this.n;
            while (lllllllllllllIIllllIIIIllIIllIIl-- != 0) {
                final K lllllllllllllIIllllIIIIllIIllIlI = Object2ObjectOpenHashMap.this.key[lllllllllllllIIllllIIIIllIIllIIl];
                if (lllllllllllllIIllllIIIIllIIllIlI != null) {
                    lllllllllllllIIllllIIIIllIIlIlIl.accept((Object)lllllllllllllIIllllIIIIllIIllIlI);
                }
            }
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIIllllIIIIllIIIlIlI) {
            return Object2ObjectOpenHashMap.this.containsKey(lllllllllllllIIllllIIIIllIIIlIlI);
        }
        
        @Override
        public ObjectIterator<K> iterator() {
            return new KeyIterator();
        }
        
        @Override
        public int size() {
            return Object2ObjectOpenHashMap.this.size;
        }
        
        @Override
        public void clear() {
            Object2ObjectOpenHashMap.this.clear();
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIIllllIIIIIllIllIIl) {
            final int lllllllllllllIIllllIIIIIllIllIII = Object2ObjectOpenHashMap.this.size;
            Object2ObjectOpenHashMap.this.remove(lllllllllllllIIllllIIIIIllIllIIl);
            return Object2ObjectOpenHashMap.this.size != lllllllllllllIIllllIIIIIllIllIII;
        }
    }
    
    private final class KeyIterator extends MapIterator implements ObjectIterator<K>
    {
        public KeyIterator() {
        }
        
        @Override
        public K next() {
            return Object2ObjectOpenHashMap.this.key[this.nextEntry()];
        }
    }
    
    private class FastEntryIterator extends MapIterator implements ObjectIterator<Object2ObjectMap.Entry<K, V>>
    {
        private final /* synthetic */ MapEntry entry;
        
        private FastEntryIterator() {
            this.entry = new MapEntry();
        }
        
        @Override
        public MapEntry next() {
            this.entry.index = this.nextEntry();
            return this.entry;
        }
    }
    
    private final class MapEntrySet extends AbstractObjectSet<Object2ObjectMap.Entry<K, V>> implements Object2ObjectMap.FastEntrySet<K, V>
    {
        @Override
        public void clear() {
            Object2ObjectOpenHashMap.this.clear();
        }
        
        @Override
        public boolean contains(final Object llllllllllllllllIIIIlIlllIIllIll) {
            if (!(llllllllllllllllIIIIlIlllIIllIll instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> llllllllllllllllIIIIlIlllIlIIIlI = (Map.Entry<?, ?>)llllllllllllllllIIIIlIlllIIllIll;
            final K llllllllllllllllIIIIlIlllIlIIIIl = (K)llllllllllllllllIIIIlIlllIlIIIlI.getKey();
            final V llllllllllllllllIIIIlIlllIlIIIII = (V)llllllllllllllllIIIIlIlllIlIIIlI.getValue();
            if (llllllllllllllllIIIIlIlllIlIIIIl == null) {
                return Object2ObjectOpenHashMap.this.containsNullKey && Objects.equals(Object2ObjectOpenHashMap.this.value[Object2ObjectOpenHashMap.this.n], llllllllllllllllIIIIlIlllIlIIIII);
            }
            final K[] llllllllllllllllIIIIlIlllIIllllI = Object2ObjectOpenHashMap.this.key;
            int llllllllllllllllIIIIlIlllIIlllIl;
            K llllllllllllllllIIIIlIlllIIlllll;
            if ((llllllllllllllllIIIIlIlllIIlllll = llllllllllllllllIIIIlIlllIIllllI[llllllllllllllllIIIIlIlllIIlllIl = (HashCommon.mix(llllllllllllllllIIIIlIlllIlIIIIl.hashCode()) & Object2ObjectOpenHashMap.this.mask)]) == null) {
                return false;
            }
            if (llllllllllllllllIIIIlIlllIlIIIIl.equals(llllllllllllllllIIIIlIlllIIlllll)) {
                return Objects.equals(Object2ObjectOpenHashMap.this.value[llllllllllllllllIIIIlIlllIIlllIl], llllllllllllllllIIIIlIlllIlIIIII);
            }
            while ((llllllllllllllllIIIIlIlllIIlllll = llllllllllllllllIIIIlIlllIIllllI[llllllllllllllllIIIIlIlllIIlllIl = (llllllllllllllllIIIIlIlllIIlllIl + 1 & Object2ObjectOpenHashMap.this.mask)]) != null) {
                if (llllllllllllllllIIIIlIlllIlIIIIl.equals(llllllllllllllllIIIIlIlllIIlllll)) {
                    return Objects.equals(Object2ObjectOpenHashMap.this.value[llllllllllllllllIIIIlIlllIIlllIl], llllllllllllllllIIIIlIlllIlIIIII);
                }
            }
            return false;
        }
        
        @Override
        public ObjectIterator<Object2ObjectMap.Entry<K, V>> iterator() {
            return new EntryIterator();
        }
        
        @Override
        public ObjectIterator<Object2ObjectMap.Entry<K, V>> fastIterator() {
            return new FastEntryIterator();
        }
        
        @Override
        public void fastForEach(final Consumer<? super Object2ObjectMap.Entry<K, V>> llllllllllllllllIIIIlIllIllIIlII) {
            final BasicEntry<K, V> llllllllllllllllIIIIlIllIllIIllI = new BasicEntry<K, V>();
            if (Object2ObjectOpenHashMap.this.containsNullKey) {
                llllllllllllllllIIIIlIllIllIIllI.key = Object2ObjectOpenHashMap.this.key[Object2ObjectOpenHashMap.this.n];
                llllllllllllllllIIIIlIllIllIIllI.value = Object2ObjectOpenHashMap.this.value[Object2ObjectOpenHashMap.this.n];
                llllllllllllllllIIIIlIllIllIIlII.accept(llllllllllllllllIIIIlIllIllIIllI);
            }
            int llllllllllllllllIIIIlIllIllIlIIl = Object2ObjectOpenHashMap.this.n;
            while (llllllllllllllllIIIIlIllIllIlIIl-- != 0) {
                if (Object2ObjectOpenHashMap.this.key[llllllllllllllllIIIIlIllIllIlIIl] != null) {
                    llllllllllllllllIIIIlIllIllIIllI.key = Object2ObjectOpenHashMap.this.key[llllllllllllllllIIIIlIllIllIlIIl];
                    llllllllllllllllIIIIlIllIllIIllI.value = Object2ObjectOpenHashMap.this.value[llllllllllllllllIIIIlIllIllIlIIl];
                    llllllllllllllllIIIIlIllIllIIlII.accept(llllllllllllllllIIIIlIllIllIIllI);
                }
            }
        }
        
        @Override
        public boolean remove(final Object llllllllllllllllIIIIlIlllIIIlIll) {
            if (!(llllllllllllllllIIIIlIlllIIIlIll instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> llllllllllllllllIIIIlIlllIIIlIlI = (Map.Entry<?, ?>)llllllllllllllllIIIIlIlllIIIlIll;
            final K llllllllllllllllIIIIlIlllIIIlIIl = (K)llllllllllllllllIIIIlIlllIIIlIlI.getKey();
            final V llllllllllllllllIIIIlIlllIIIlIII = (V)llllllllllllllllIIIIlIlllIIIlIlI.getValue();
            if (llllllllllllllllIIIIlIlllIIIlIIl == null) {
                if (Object2ObjectOpenHashMap.this.containsNullKey && Objects.equals(Object2ObjectOpenHashMap.this.value[Object2ObjectOpenHashMap.this.n], llllllllllllllllIIIIlIlllIIIlIII)) {
                    Object2ObjectOpenHashMap.this.removeNullEntry();
                    return true;
                }
                return false;
            }
            else {
                final K[] llllllllllllllllIIIIlIlllIIIIllI = Object2ObjectOpenHashMap.this.key;
                int llllllllllllllllIIIIlIlllIIIIlIl;
                K llllllllllllllllIIIIlIlllIIIIlll;
                if ((llllllllllllllllIIIIlIlllIIIIlll = llllllllllllllllIIIIlIlllIIIIllI[llllllllllllllllIIIIlIlllIIIIlIl = (HashCommon.mix(llllllllllllllllIIIIlIlllIIIlIIl.hashCode()) & Object2ObjectOpenHashMap.this.mask)]) == null) {
                    return false;
                }
                if (!llllllllllllllllIIIIlIlllIIIIlll.equals(llllllllllllllllIIIIlIlllIIIlIIl)) {
                    while ((llllllllllllllllIIIIlIlllIIIIlll = llllllllllllllllIIIIlIlllIIIIllI[llllllllllllllllIIIIlIlllIIIIlIl = (llllllllllllllllIIIIlIlllIIIIlIl + 1 & Object2ObjectOpenHashMap.this.mask)]) != null) {
                        if (llllllllllllllllIIIIlIlllIIIIlll.equals(llllllllllllllllIIIIlIlllIIIlIIl) && Objects.equals(Object2ObjectOpenHashMap.this.value[llllllllllllllllIIIIlIlllIIIIlIl], llllllllllllllllIIIIlIlllIIIlIII)) {
                            Object2ObjectOpenHashMap.this.removeEntry(llllllllllllllllIIIIlIlllIIIIlIl);
                            return true;
                        }
                    }
                    return false;
                }
                if (Objects.equals(Object2ObjectOpenHashMap.this.value[llllllllllllllllIIIIlIlllIIIIlIl], llllllllllllllllIIIIlIlllIIIlIII)) {
                    Object2ObjectOpenHashMap.this.removeEntry(llllllllllllllllIIIIlIlllIIIIlIl);
                    return true;
                }
                return false;
            }
        }
        
        @Override
        public int size() {
            return Object2ObjectOpenHashMap.this.size;
        }
        
        @Override
        public void forEach(final Consumer<? super Object2ObjectMap.Entry<K, V>> llllllllllllllllIIIIlIllIlllIIIl) {
            if (Object2ObjectOpenHashMap.this.containsNullKey) {
                llllllllllllllllIIIIlIllIlllIIIl.accept((Object)new BasicEntry((K)Object2ObjectOpenHashMap.this.key[Object2ObjectOpenHashMap.this.n], (V)Object2ObjectOpenHashMap.this.value[Object2ObjectOpenHashMap.this.n]));
            }
            int llllllllllllllllIIIIlIllIlllIIll = Object2ObjectOpenHashMap.this.n;
            while (llllllllllllllllIIIIlIllIlllIIll-- != 0) {
                if (Object2ObjectOpenHashMap.this.key[llllllllllllllllIIIIlIllIlllIIll] != null) {
                    llllllllllllllllIIIIlIllIlllIIIl.accept((Object)new BasicEntry((K)Object2ObjectOpenHashMap.this.key[llllllllllllllllIIIIlIllIlllIIll], (V)Object2ObjectOpenHashMap.this.value[llllllllllllllllIIIIlIllIlllIIll]));
                }
            }
        }
    }
    
    private final class ValueIterator extends MapIterator implements ObjectIterator<V>
    {
        @Override
        public V next() {
            return Object2ObjectOpenHashMap.this.value[this.nextEntry()];
        }
        
        public ValueIterator() {
        }
    }
}
