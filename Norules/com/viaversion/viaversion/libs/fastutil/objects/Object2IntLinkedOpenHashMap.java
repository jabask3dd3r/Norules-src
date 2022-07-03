package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;
import java.util.function.*;

public class Object2IntLinkedOpenHashMap<K> extends AbstractObject2IntSortedMap<K> implements Serializable, Cloneable, Hash
{
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ long[] link;
    protected transient /* synthetic */ int[] value;
    protected transient /* synthetic */ Object2IntSortedMap.FastSortedEntrySet<K> entries;
    protected transient /* synthetic */ int n;
    protected /* synthetic */ int size;
    protected transient /* synthetic */ K[] key;
    protected transient /* synthetic */ IntCollection values;
    protected final /* synthetic */ float f;
    protected transient /* synthetic */ int first;
    protected transient /* synthetic */ int mask;
    protected final transient /* synthetic */ int minN;
    protected transient /* synthetic */ int last;
    protected transient /* synthetic */ ObjectSortedSet<K> keys;
    protected transient /* synthetic */ boolean containsNullKey;
    
    @Override
    public int replace(final K lllllllllllllIIlIIIIIllIIIIlIlII, final int lllllllllllllIIlIIIIIllIIIIlIIll) {
        final int lllllllllllllIIlIIIIIllIIIIlIIlI = this.find(lllllllllllllIIlIIIIIllIIIIlIlII);
        if (lllllllllllllIIlIIIIIllIIIIlIIlI < 0) {
            return this.defRetValue;
        }
        final int lllllllllllllIIlIIIIIllIIIIlIIIl = this.value[lllllllllllllIIlIIIIIllIIIIlIIlI];
        this.value[lllllllllllllIIlIIIIIllIIIIlIIlI] = lllllllllllllIIlIIIIIllIIIIlIIll;
        return lllllllllllllIIlIIIIIllIIIIlIIIl;
    }
    
    @Override
    public IntCollection values() {
        if (this.values == null) {
            this.values = new AbstractIntCollection() {
                @Override
                public boolean contains(final int lllllllllllllIlIllllIIlIlIlIlIlI) {
                    return Object2IntLinkedOpenHashMap.this.containsValue(lllllllllllllIlIllllIIlIlIlIlIlI);
                }
                
                @Override
                public void forEach(final IntConsumer lllllllllllllIlIllllIIlIlIIlllll) {
                    if (Object2IntLinkedOpenHashMap.this.containsNullKey) {
                        lllllllllllllIlIllllIIlIlIIlllll.accept(Object2IntLinkedOpenHashMap.this.value[Object2IntLinkedOpenHashMap.this.n]);
                    }
                    int lllllllllllllIlIllllIIlIlIlIIIll = Object2IntLinkedOpenHashMap.this.n;
                    while (lllllllllllllIlIllllIIlIlIlIIIll-- != 0) {
                        if (Object2IntLinkedOpenHashMap.this.key[lllllllllllllIlIllllIIlIlIlIIIll] != null) {
                            lllllllllllllIlIllllIIlIlIIlllll.accept(Object2IntLinkedOpenHashMap.this.value[lllllllllllllIlIllllIIlIlIlIIIll]);
                        }
                    }
                }
                
                @Override
                public IntIterator iterator() {
                    return new ValueIterator();
                }
                
                @Override
                public int size() {
                    return Object2IntLinkedOpenHashMap.this.size;
                }
                
                @Override
                public void clear() {
                    Object2IntLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }
    
    protected final void shiftKeys(int lllllllllllllIIlIIIIIlllIIIllIlI) {
        final K[] lllllllllllllIIlIIIIIlllIIIlllII = this.key;
        int lllllllllllllIIlIIIIIlllIIIlllll = 0;
    Label_0006:
        while (true) {
            lllllllllllllIIlIIIIIlllIIIllIlI = ((lllllllllllllIIlIIIIIlllIIIlllll = lllllllllllllIIlIIIIIlllIIIllIlI) + 1 & this.mask);
            K lllllllllllllIIlIIIIIlllIIIlllIl;
            while ((lllllllllllllIIlIIIIIlllIIIlllIl = lllllllllllllIIlIIIIIlllIIIlllII[lllllllllllllIIlIIIIIlllIIIllIlI]) != null) {
                final int lllllllllllllIIlIIIIIlllIIIllllI = HashCommon.mix(lllllllllllllIIlIIIIIlllIIIlllIl.hashCode()) & this.mask;
                Label_0090: {
                    if (lllllllllllllIIlIIIIIlllIIIlllll <= lllllllllllllIIlIIIIIlllIIIllIlI) {
                        if (lllllllllllllIIlIIIIIlllIIIlllll >= lllllllllllllIIlIIIIIlllIIIllllI) {
                            break Label_0090;
                        }
                        if (lllllllllllllIIlIIIIIlllIIIllllI > lllllllllllllIIlIIIIIlllIIIllIlI) {
                            break Label_0090;
                        }
                    }
                    else if (lllllllllllllIIlIIIIIlllIIIlllll >= lllllllllllllIIlIIIIIlllIIIllllI && lllllllllllllIIlIIIIIlllIIIllllI > lllllllllllllIIlIIIIIlllIIIllIlI) {
                        break Label_0090;
                    }
                    lllllllllllllIIlIIIIIlllIIIllIlI = (lllllllllllllIIlIIIIIlllIIIllIlI + 1 & this.mask);
                    continue;
                }
                lllllllllllllIIlIIIIIlllIIIlllII[lllllllllllllIIlIIIIIlllIIIlllll] = lllllllllllllIIlIIIIIlllIIIlllIl;
                this.value[lllllllllllllIIlIIIIIlllIIIlllll] = this.value[lllllllllllllIIlIIIIIlllIIIllIlI];
                this.fixPointers(lllllllllllllIIlIIIIIlllIIIllIlI, lllllllllllllIIlIIIIIlllIIIlllll);
                continue Label_0006;
            }
            break;
        }
        lllllllllllllIIlIIIIIlllIIIlllII[lllllllllllllIIlIIIIIlllIIIlllll] = null;
    }
    
    public int getAndMoveToFirst(final K lllllllllllllIIlIIIIIllIllIIIlII) {
        if (lllllllllllllIIlIIIIIllIllIIIlII == null) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        else {
            final K[] lllllllllllllIIlIIIIIllIllIIIIlI = this.key;
            int lllllllllllllIIlIIIIIllIllIIIIIl;
            K lllllllllllllIIlIIIIIllIllIIIIll;
            if ((lllllllllllllIIlIIIIIllIllIIIIll = lllllllllllllIIlIIIIIllIllIIIIlI[lllllllllllllIIlIIIIIllIllIIIIIl = (HashCommon.mix(lllllllllllllIIlIIIIIllIllIIIlII.hashCode()) & this.mask)]) == null) {
                return this.defRetValue;
            }
            if (lllllllllllllIIlIIIIIllIllIIIlII.equals(lllllllllllllIIlIIIIIllIllIIIIll)) {
                this.moveIndexToFirst(lllllllllllllIIlIIIIIllIllIIIIIl);
                return this.value[lllllllllllllIIlIIIIIllIllIIIIIl];
            }
            while ((lllllllllllllIIlIIIIIllIllIIIIll = lllllllllllllIIlIIIIIllIllIIIIlI[lllllllllllllIIlIIIIIllIllIIIIIl = (lllllllllllllIIlIIIIIllIllIIIIIl + 1 & this.mask)]) != null) {
                if (lllllllllllllIIlIIIIIllIllIIIlII.equals(lllllllllllllIIlIIIIIllIllIIIIll)) {
                    this.moveIndexToFirst(lllllllllllllIIlIIIIIllIllIIIIIl);
                    return this.value[lllllllllllllIIlIIIIIllIllIIIIIl];
                }
            }
            return this.defRetValue;
        }
    }
    
    public boolean trim(final int lllllllllllllIIlIIIIIlIlIlllllII) {
        final int lllllllllllllIIlIIIIIlIlIllllllI = HashCommon.nextPowerOfTwo((int)Math.ceil(lllllllllllllIIlIIIIIlIlIlllllII / this.f));
        if (lllllllllllllIIlIIIIIlIlIllllllI >= this.n || this.size > HashCommon.maxFill(lllllllllllllIIlIIIIIlIlIllllllI, this.f)) {
            return true;
        }
        try {
            this.rehash(lllllllllllllIIlIIIIIlIlIllllllI);
        }
        catch (OutOfMemoryError lllllllllllllIIlIIIIIlIllIIIIIIl) {
            return false;
        }
        return true;
    }
    
    @Override
    public int computeIntIfPresent(final K lllllllllllllIIlIIIIIlIlllllIIIl, final BiFunction<? super K, ? super Integer, ? extends Integer> lllllllllllllIIlIIIIIlIlllllIIII) {
        Objects.requireNonNull(lllllllllllllIIlIIIIIlIlllllIIII);
        final int lllllllllllllIIlIIIIIlIlllllIlII = this.find(lllllllllllllIIlIIIIIlIlllllIIIl);
        if (lllllllllllllIIlIIIIIlIlllllIlII < 0) {
            return this.defRetValue;
        }
        final Integer lllllllllllllIIlIIIIIlIlllllIIll = (Integer)lllllllllllllIIlIIIIIlIlllllIIII.apply((Object)lllllllllllllIIlIIIIIlIlllllIIIl, Integer.valueOf(this.value[lllllllllllllIIlIIIIIlIlllllIlII]));
        if (lllllllllllllIIlIIIIIlIlllllIIll == null) {
            if (lllllllllllllIIlIIIIIlIlllllIIIl == null) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(lllllllllllllIIlIIIIIlIlllllIlII);
            }
            return this.defRetValue;
        }
        return this.value[lllllllllllllIIlIIIIIlIlllllIlII] = lllllllllllllIIlIIIIIlIlllllIIll;
    }
    
    public int removeLastInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int lllllllllllllIIlIIIIIllIlllIllIl = this.last;
        this.last = (int)(this.link[lllllllllllllIIlIIIIIllIlllIllIl] >>> 32);
        if (0 <= this.last) {
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        --this.size;
        final int lllllllllllllIIlIIIIIllIlllIllII = this.value[lllllllllllllIIlIIIIIllIlllIllIl];
        if (lllllllllllllIIlIIIIIllIlllIllIl == this.n) {
            this.containsNullKey = false;
            this.key[this.n] = null;
        }
        else {
            this.shiftKeys(lllllllllllllIIlIIIIIllIlllIllIl);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIlIIIIIllIlllIllII;
    }
    
    private int find(final K lllllllllllllIIlIIIIIlllIllIIlIl) {
        if (lllllllllllllIIlIIIIIlllIllIIlIl == null) {
            return this.containsNullKey ? this.n : (-(this.n + 1));
        }
        final K[] lllllllllllllIIlIIIIIlllIllIlIII = this.key;
        int lllllllllllllIIlIIIIIlllIllIIlll;
        K lllllllllllllIIlIIIIIlllIllIlIIl;
        if ((lllllllllllllIIlIIIIIlllIllIlIIl = lllllllllllllIIlIIIIIlllIllIlIII[lllllllllllllIIlIIIIIlllIllIIlll = (HashCommon.mix(lllllllllllllIIlIIIIIlllIllIIlIl.hashCode()) & this.mask)]) == null) {
            return -(lllllllllllllIIlIIIIIlllIllIIlll + 1);
        }
        if (lllllllllllllIIlIIIIIlllIllIIlIl.equals(lllllllllllllIIlIIIIIlllIllIlIIl)) {
            return lllllllllllllIIlIIIIIlllIllIIlll;
        }
        while ((lllllllllllllIIlIIIIIlllIllIlIIl = lllllllllllllIIlIIIIIlllIllIlIII[lllllllllllllIIlIIIIIlllIllIIlll = (lllllllllllllIIlIIIIIlllIllIIlll + 1 & this.mask)]) != null) {
            if (lllllllllllllIIlIIIIIlllIllIIlIl.equals(lllllllllllllIIlIIIIIlllIllIlIIl)) {
                return lllllllllllllIIlIIIIIlllIllIIlll;
            }
        }
        return -(lllllllllllllIIlIIIIIlllIllIIlll + 1);
    }
    
    static {
        ASSERTS = false;
    }
    
    private void checkTable() {
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    private void readObject(final ObjectInputStream lllllllllllllIIlIIIIIlIlIIIIIlll) throws IOException, ClassNotFoundException {
        lllllllllllllIIlIIIIIlIlIIIIIlll.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final Object[] key = new Object[this.n + 1];
        this.key = (K[])key;
        final K[] lllllllllllllIIlIIIIIlIlIIIIllII = (K[])key;
        final int[] value = new int[this.n + 1];
        this.value = value;
        final int[] lllllllllllllIIlIIIIIlIlIIIIlIll = value;
        final long[] link = new long[this.n + 1];
        this.link = link;
        final long[] lllllllllllllIIlIIIIIlIlIIIIlIlI = link;
        int lllllllllllllIIlIIIIIlIlIIIIlIIl = -1;
        final int n = -1;
        this.last = n;
        this.first = n;
        int lllllllllllllIIlIIIIIlIlIIIlIIII = this.size;
        while (lllllllllllllIIlIIIIIlIlIIIlIIII-- != 0) {
            final K lllllllllllllIIlIIIIIlIlIIIlIIlI = (K)lllllllllllllIIlIIIIIlIlIIIIIlll.readObject();
            final int lllllllllllllIIlIIIIIlIlIIIlIIIl = lllllllllllllIIlIIIIIlIlIIIIIlll.readInt();
            int lllllllllllllIIlIIIIIlIlIIIIllll = 0;
            if (lllllllllllllIIlIIIIIlIlIIIlIIlI == null) {
                final int lllllllllllllIIlIIIIIlIlIIIlIIll = this.n;
                this.containsNullKey = true;
            }
            else {
                for (lllllllllllllIIlIIIIIlIlIIIIllll = (HashCommon.mix(lllllllllllllIIlIIIIIlIlIIIlIIlI.hashCode()) & this.mask); lllllllllllllIIlIIIIIlIlIIIIllII[lllllllllllllIIlIIIIIlIlIIIIllll] != null; lllllllllllllIIlIIIIIlIlIIIIllll = (lllllllllllllIIlIIIIIlIlIIIIllll + 1 & this.mask)) {}
            }
            lllllllllllllIIlIIIIIlIlIIIIllII[lllllllllllllIIlIIIIIlIlIIIIllll] = lllllllllllllIIlIIIIIlIlIIIlIIlI;
            lllllllllllllIIlIIIIIlIlIIIIlIll[lllllllllllllIIlIIIIIlIlIIIIllll] = lllllllllllllIIlIIIIIlIlIIIlIIIl;
            if (this.first != -1) {
                final long[] array = lllllllllllllIIlIIIIIlIlIIIIlIlI;
                final int n2 = lllllllllllllIIlIIIIIlIlIIIIlIIl;
                array[n2] ^= ((lllllllllllllIIlIIIIIlIlIIIIlIlI[lllllllllllllIIlIIIIIlIlIIIIlIIl] ^ ((long)lllllllllllllIIlIIIIIlIlIIIIllll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = lllllllllllllIIlIIIIIlIlIIIIlIlI;
                final int n3 = lllllllllllllIIlIIIIIlIlIIIIllll;
                array2[n3] ^= ((lllllllllllllIIlIIIIIlIlIIIIlIlI[lllllllllllllIIlIIIIIlIlIIIIllll] ^ ((long)lllllllllllllIIlIIIIIlIlIIIIlIIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                lllllllllllllIIlIIIIIlIlIIIIlIIl = lllllllllllllIIlIIIIIlIlIIIIllll;
            }
            else {
                final int first = lllllllllllllIIlIIIIIlIlIIIIllll;
                this.first = first;
                lllllllllllllIIlIIIIIlIlIIIIlIIl = first;
                final long[] array3 = lllllllllllllIIlIIIIIlIlIIIIlIlI;
                final int n4 = lllllllllllllIIlIIIIIlIlIIIIllll;
                array3[n4] |= 0xFFFFFFFF00000000L;
            }
        }
        if ((this.last = lllllllllllllIIlIIIIIlIlIIIIlIIl) != -1) {
            final long[] array4 = lllllllllllllIIlIIIIIlIlIIIIlIlI;
            final int n5 = lllllllllllllIIlIIIIIlIlIIIIlIIl;
            array4[n5] |= 0xFFFFFFFFL;
        }
    }
    
    @Override
    public Object2IntSortedMap<K> subMap(final K lllllllllllllIIlIIIIIlIllIIlIlII, final K lllllllllllllIIlIIIIIlIllIIlIIll) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int getInt(final Object lllllllllllllIIlIIIIIllIlIIIIIII) {
        if (lllllllllllllIIlIIIIIllIlIIIIIII == null) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        }
        final K[] lllllllllllllIIlIIIIIllIIllllllI = this.key;
        int lllllllllllllIIlIIIIIllIIlllllIl;
        K lllllllllllllIIlIIIIIllIIlllllll;
        if ((lllllllllllllIIlIIIIIllIIlllllll = lllllllllllllIIlIIIIIllIIllllllI[lllllllllllllIIlIIIIIllIIlllllIl = (HashCommon.mix(lllllllllllllIIlIIIIIllIlIIIIIII.hashCode()) & this.mask)]) == null) {
            return this.defRetValue;
        }
        if (lllllllllllllIIlIIIIIllIlIIIIIII.equals(lllllllllllllIIlIIIIIllIIlllllll)) {
            return this.value[lllllllllllllIIlIIIIIllIIlllllIl];
        }
        while ((lllllllllllllIIlIIIIIllIIlllllll = lllllllllllllIIlIIIIIllIIllllllI[lllllllllllllIIlIIIIIllIIlllllIl = (lllllllllllllIIlIIIIIllIIlllllIl + 1 & this.mask)]) != null) {
            if (lllllllllllllIIlIIIIIllIlIIIIIII.equals(lllllllllllllIIlIIIIIllIIlllllll)) {
                return this.value[lllllllllllllIIlIIIIIllIIlllllIl];
            }
        }
        return this.defRetValue;
    }
    
    protected void rehash(final int lllllllllllllIIlIIIIIlIlIlIllIIl) {
        final K[] lllllllllllllIIlIIIIIlIlIllIIlII = this.key;
        final int[] lllllllllllllIIlIIIIIlIlIllIIIll = this.value;
        final int lllllllllllllIIlIIIIIlIlIllIIIlI = lllllllllllllIIlIIIIIlIlIlIllIIl - 1;
        final K[] lllllllllllllIIlIIIIIlIlIllIIIIl = (K[])new Object[lllllllllllllIIlIIIIIlIlIlIllIIl + 1];
        final int[] lllllllllllllIIlIIIIIlIlIllIIIII = new int[lllllllllllllIIlIIIIIlIlIlIllIIl + 1];
        int lllllllllllllIIlIIIIIlIlIlIlllll = this.first;
        int lllllllllllllIIlIIIIIlIlIlIllllI = -1;
        int lllllllllllllIIlIIIIIlIlIlIlllIl = -1;
        final long[] lllllllllllllIIlIIIIIlIlIlIlllII = this.link;
        final long[] lllllllllllllIIlIIIIIlIlIlIllIll = new long[lllllllllllllIIlIIIIIlIlIlIllIIl + 1];
        this.first = -1;
        int lllllllllllllIIlIIIIIlIlIllIIlll = this.size;
        while (lllllllllllllIIlIIIIIlIlIllIIlll-- != 0) {
            int lllllllllllllIIlIIIIIlIlIllIlIII = 0;
            if (lllllllllllllIIlIIIIIlIlIllIIlII[lllllllllllllIIlIIIIIlIlIlIlllll] == null) {
                final int lllllllllllllIIlIIIIIlIlIllIlIlI = lllllllllllllIIlIIIIIlIlIlIllIIl;
            }
            else {
                for (lllllllllllllIIlIIIIIlIlIllIlIII = (HashCommon.mix(lllllllllllllIIlIIIIIlIlIllIIlII[lllllllllllllIIlIIIIIlIlIlIlllll].hashCode()) & lllllllllllllIIlIIIIIlIlIllIIIlI); lllllllllllllIIlIIIIIlIlIllIIIIl[lllllllllllllIIlIIIIIlIlIllIlIII] != null; lllllllllllllIIlIIIIIlIlIllIlIII = (lllllllllllllIIlIIIIIlIlIllIlIII + 1 & lllllllllllllIIlIIIIIlIlIllIIIlI)) {}
            }
            lllllllllllllIIlIIIIIlIlIllIIIIl[lllllllllllllIIlIIIIIlIlIllIlIII] = lllllllllllllIIlIIIIIlIlIllIIlII[lllllllllllllIIlIIIIIlIlIlIlllll];
            lllllllllllllIIlIIIIIlIlIllIIIII[lllllllllllllIIlIIIIIlIlIllIlIII] = lllllllllllllIIlIIIIIlIlIllIIIll[lllllllllllllIIlIIIIIlIlIlIlllll];
            if (lllllllllllllIIlIIIIIlIlIlIllllI != -1) {
                final long[] array = lllllllllllllIIlIIIIIlIlIlIllIll;
                final int n = lllllllllllllIIlIIIIIlIlIlIlllIl;
                array[n] ^= ((lllllllllllllIIlIIIIIlIlIlIllIll[lllllllllllllIIlIIIIIlIlIlIlllIl] ^ ((long)lllllllllllllIIlIIIIIlIlIllIlIII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = lllllllllllllIIlIIIIIlIlIlIllIll;
                final int n2 = lllllllllllllIIlIIIIIlIlIllIlIII;
                array2[n2] ^= ((lllllllllllllIIlIIIIIlIlIlIllIll[lllllllllllllIIlIIIIIlIlIllIlIII] ^ ((long)lllllllllllllIIlIIIIIlIlIlIlllIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                lllllllllllllIIlIIIIIlIlIlIlllIl = lllllllllllllIIlIIIIIlIlIllIlIII;
            }
            else {
                final int first = lllllllllllllIIlIIIIIlIlIllIlIII;
                this.first = first;
                lllllllllllllIIlIIIIIlIlIlIlllIl = first;
                lllllllllllllIIlIIIIIlIlIlIllIll[lllllllllllllIIlIIIIIlIlIllIlIII] = -1L;
            }
            final int lllllllllllllIIlIIIIIlIlIllIlIIl = lllllllllllllIIlIIIIIlIlIlIlllll;
            lllllllllllllIIlIIIIIlIlIlIlllll = (int)lllllllllllllIIlIIIIIlIlIlIlllII[lllllllllllllIIlIIIIIlIlIlIlllll];
            lllllllllllllIIlIIIIIlIlIlIllllI = lllllllllllllIIlIIIIIlIlIllIlIIl;
        }
        this.link = lllllllllllllIIlIIIIIlIlIlIllIll;
        if ((this.last = lllllllllllllIIlIIIIIlIlIlIlllIl) != -1) {
            final long[] array3 = lllllllllllllIIlIIIIIlIlIlIllIll;
            final int n3 = lllllllllllllIIlIIIIIlIlIlIlllIl;
            array3[n3] |= 0xFFFFFFFFL;
        }
        this.n = lllllllllllllIIlIIIIIlIlIlIllIIl;
        this.mask = lllllllllllllIIlIIIIIlIlIllIIIlI;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = lllllllllllllIIlIIIIIlIlIllIIIIl;
        this.value = lllllllllllllIIlIIIIIlIlIllIIIII;
    }
    
    protected void fixPointers(final int lllllllllllllIIlIIIIIlIllIllIlIl) {
        if (this.size == 0) {
            final int n = -1;
            this.last = n;
            this.first = n;
            return;
        }
        if (this.first == lllllllllllllIIlIIIIIlIllIllIlIl) {
            this.first = (int)this.link[lllllllllllllIIlIIIIIlIllIllIlIl];
            if (0 <= this.first) {
                final long[] link = this.link;
                final int first = this.first;
                link[first] |= 0xFFFFFFFF00000000L;
            }
            return;
        }
        if (this.last == lllllllllllllIIlIIIIIlIllIllIlIl) {
            this.last = (int)(this.link[lllllllllllllIIlIIIIIlIllIllIlIl] >>> 32);
            if (0 <= this.last) {
                final long[] link2 = this.link;
                final int last = this.last;
                link2[last] |= 0xFFFFFFFFL;
            }
            return;
        }
        final long lllllllllllllIIlIIIIIlIllIlllIIl = this.link[lllllllllllllIIlIIIIIlIllIllIlIl];
        final int lllllllllllllIIlIIIIIlIllIlllIII = (int)(lllllllllllllIIlIIIIIlIllIlllIIl >>> 32);
        final int lllllllllllllIIlIIIIIlIllIllIlll = (int)lllllllllllllIIlIIIIIlIllIlllIIl;
        final long[] link3 = this.link;
        final int n2 = lllllllllllllIIlIIIIIlIllIlllIII;
        link3[n2] ^= ((this.link[lllllllllllllIIlIIIIIlIllIlllIII] ^ (lllllllllllllIIlIIIIIlIllIlllIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n3 = lllllllllllllIIlIIIIIlIllIllIlll;
        link4[n3] ^= ((this.link[lllllllllllllIIlIIIIIlIllIllIlll] ^ (lllllllllllllIIlIIIIIlIllIlllIIl & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
    }
    
    public int addTo(final K lllllllllllllIIlIIIIIlllIIllIIII, final int lllllllllllllIIlIIIIIlllIIlIlIll) {
        int lllllllllllllIIlIIIIIlllIIlIlllI = 0;
        if (lllllllllllllIIlIIIIIlllIIllIIII == null) {
            if (this.containsNullKey) {
                return this.addToValue(this.n, lllllllllllllIIlIIIIIlllIIlIlIll);
            }
            final int lllllllllllllIIlIIIIIlllIIllIlII = this.n;
            this.containsNullKey = true;
        }
        else {
            final K[] lllllllllllllIIlIIIIIlllIIllIIlI = this.key;
            K lllllllllllllIIlIIIIIlllIIllIIll;
            if ((lllllllllllllIIlIIIIIlllIIllIIll = lllllllllllllIIlIIIIIlllIIllIIlI[lllllllllllllIIlIIIIIlllIIlIlllI = (HashCommon.mix(lllllllllllllIIlIIIIIlllIIllIIII.hashCode()) & this.mask)]) != null) {
                if (lllllllllllllIIlIIIIIlllIIllIIll.equals(lllllllllllllIIlIIIIIlllIIllIIII)) {
                    return this.addToValue(lllllllllllllIIlIIIIIlllIIlIlllI, lllllllllllllIIlIIIIIlllIIlIlIll);
                }
                while ((lllllllllllllIIlIIIIIlllIIllIIll = lllllllllllllIIlIIIIIlllIIllIIlI[lllllllllllllIIlIIIIIlllIIlIlllI = (lllllllllllllIIlIIIIIlllIIlIlllI + 1 & this.mask)]) != null) {
                    if (lllllllllllllIIlIIIIIlllIIllIIll.equals(lllllllllllllIIlIIIIIlllIIllIIII)) {
                        return this.addToValue(lllllllllllllIIlIIIIIlllIIlIlllI, lllllllllllllIIlIIIIIlllIIlIlIll);
                    }
                }
            }
        }
        this.key[lllllllllllllIIlIIIIIlllIIlIlllI] = lllllllllllllIIlIIIIIlllIIllIIII;
        this.value[lllllllllllllIIlIIIIIlllIIlIlllI] = this.defRetValue + lllllllllllllIIlIIIIIlllIIlIlIll;
        if (this.size == 0) {
            final int n = lllllllllllllIIlIIIIIlllIIlIlllI;
            this.last = n;
            this.first = n;
            this.link[lllllllllllllIIlIIIIIlllIIlIlllI] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIlIIIIIlllIIlIlllI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIlIIIIIlllIIlIlllI] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = lllllllllllllIIlIIIIIlllIIlIlllI;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return this.defRetValue;
    }
    
    @Override
    public int removeInt(final Object lllllllllllllIIlIIIIIlllIIIIlIlI) {
        if (lllllllllllllIIlIIIIIlllIIIIlIlI == null) {
            if (this.containsNullKey) {
                return this.removeNullEntry();
            }
            return this.defRetValue;
        }
        else {
            final K[] lllllllllllllIIlIIIIIlllIIIIllIl = this.key;
            int lllllllllllllIIlIIIIIlllIIIIllII;
            K lllllllllllllIIlIIIIIlllIIIIlllI;
            if ((lllllllllllllIIlIIIIIlllIIIIlllI = lllllllllllllIIlIIIIIlllIIIIllIl[lllllllllllllIIlIIIIIlllIIIIllII = (HashCommon.mix(lllllllllllllIIlIIIIIlllIIIIlIlI.hashCode()) & this.mask)]) == null) {
                return this.defRetValue;
            }
            if (lllllllllllllIIlIIIIIlllIIIIlIlI.equals(lllllllllllllIIlIIIIIlllIIIIlllI)) {
                return this.removeEntry(lllllllllllllIIlIIIIIlllIIIIllII);
            }
            while ((lllllllllllllIIlIIIIIlllIIIIlllI = lllllllllllllIIlIIIIIlllIIIIllIl[lllllllllllllIIlIIIIIlllIIIIllII = (lllllllllllllIIlIIIIIlllIIIIllII + 1 & this.mask)]) != null) {
                if (lllllllllllllIIlIIIIIlllIIIIlIlI.equals(lllllllllllllIIlIIIIIlllIIIIlllI)) {
                    return this.removeEntry(lllllllllllllIIlIIIIIlllIIIIllII);
                }
            }
            return this.defRetValue;
        }
    }
    
    @Override
    public ObjectSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }
    
    public Object2IntLinkedOpenHashMap(final Object2IntMap<K> lllllllllllllIIlIIIIIllllIllIIll) {
        this(lllllllllllllIIlIIIIIllllIllIIll, 0.75f);
    }
    
    public Object2IntLinkedOpenHashMap() {
        this(16, 0.75f);
    }
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNullKey = false;
        Arrays.fill(this.key, null);
        final int n = -1;
        this.last = n;
        this.first = n;
    }
    
    @Override
    public Comparator<? super K> comparator() {
        return null;
    }
    
    public Object2IntLinkedOpenHashMap(final K[] lllllllllllllIIlIIIIIllllIIlllll, final int[] lllllllllllllIIlIIIIIllllIIllIll) {
        this(lllllllllllllIIlIIIIIllllIIlllll, lllllllllllllIIlIIIIIllllIIllIll, 0.75f);
    }
    
    public Object2IntLinkedOpenHashMap(final int lllllllllllllIIlIIIIIlllllIllllI, final float lllllllllllllIIlIIIIIlllllIlllIl) {
        this.first = -1;
        this.last = -1;
        if (lllllllllllllIIlIIIIIlllllIlllIl <= 0.0f || lllllllllllllIIlIIIIIlllllIlllIl > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (lllllllllllllIIlIIIIIlllllIllllI < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = lllllllllllllIIlIIIIIlllllIlllIl;
        final int arraySize = HashCommon.arraySize(lllllllllllllIIlIIIIIlllllIllllI, lllllllllllllIIlIIIIIlllllIlllIl);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, lllllllllllllIIlIIIIIlllllIlllIl);
        this.key = (K[])new Object[this.n + 1];
        this.value = new int[this.n + 1];
        this.link = new long[this.n + 1];
    }
    
    private void insert(final int lllllllllllllIIlIIIIIlllIlIllIII, final K lllllllllllllIIlIIIIIlllIlIllIll, final int lllllllllllllIIlIIIIIlllIlIllIlI) {
        if (lllllllllllllIIlIIIIIlllIlIllIII == this.n) {
            this.containsNullKey = true;
        }
        this.key[lllllllllllllIIlIIIIIlllIlIllIII] = lllllllllllllIIlIIIIIlllIlIllIll;
        this.value[lllllllllllllIIlIIIIIlllIlIllIII] = lllllllllllllIIlIIIIIlllIlIllIlI;
        if (this.size == 0) {
            this.last = lllllllllllllIIlIIIIIlllIlIllIII;
            this.first = lllllllllllllIIlIIIIIlllIlIllIII;
            this.link[lllllllllllllIIlIIIIIlllIlIllIII] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIlIIIIIlllIlIllIII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIlIIIIIlllIlIllIII] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = lllllllllllllIIlIIIIIlllIlIllIII;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends Integer> lllllllllllllIIlIIIIIlllIlllIIll) {
        if (this.f <= 0.5) {
            this.ensureCapacity(lllllllllllllIIlIIIIIlllIlllIIll.size());
        }
        else {
            this.tryCapacity(this.size() + lllllllllllllIIlIIIIIlllIlllIIll.size());
        }
        super.putAll(lllllllllllllIIlIIIIIlllIlllIIll);
    }
    
    @Override
    public int getOrDefault(final Object lllllllllllllIIlIIIIIllIIlIlIIlI, final int lllllllllllllIIlIIIIIllIIlIlIIIl) {
        if (lllllllllllllIIlIIIIIllIIlIlIIlI == null) {
            return this.containsNullKey ? this.value[this.n] : lllllllllllllIIlIIIIIllIIlIlIIIl;
        }
        final K[] lllllllllllllIIlIIIIIllIIlIIllll = this.key;
        int lllllllllllllIIlIIIIIllIIlIIlllI;
        K lllllllllllllIIlIIIIIllIIlIlIIII;
        if ((lllllllllllllIIlIIIIIllIIlIlIIII = lllllllllllllIIlIIIIIllIIlIIllll[lllllllllllllIIlIIIIIllIIlIIlllI = (HashCommon.mix(lllllllllllllIIlIIIIIllIIlIlIIlI.hashCode()) & this.mask)]) == null) {
            return lllllllllllllIIlIIIIIllIIlIlIIIl;
        }
        if (lllllllllllllIIlIIIIIllIIlIlIIlI.equals(lllllllllllllIIlIIIIIllIIlIlIIII)) {
            return this.value[lllllllllllllIIlIIIIIllIIlIIlllI];
        }
        while ((lllllllllllllIIlIIIIIllIIlIlIIII = lllllllllllllIIlIIIIIllIIlIIllll[lllllllllllllIIlIIIIIllIIlIIlllI = (lllllllllllllIIlIIIIIllIIlIIlllI + 1 & this.mask)]) != null) {
            if (lllllllllllllIIlIIIIIllIIlIlIIlI.equals(lllllllllllllIIlIIIIIllIIlIlIIII)) {
                return this.value[lllllllllllllIIlIIIIIllIIlIIlllI];
            }
        }
        return lllllllllllllIIlIIIIIllIIlIlIIIl;
    }
    
    @Override
    public boolean replace(final K lllllllllllllIIlIIIIIllIIIlIIIll, final int lllllllllllllIIlIIIIIllIIIIlllIl, final int lllllllllllllIIlIIIIIllIIIIlllII) {
        final int lllllllllllllIIlIIIIIllIIIlIIIII = this.find(lllllllllllllIIlIIIIIllIIIlIIIll);
        if (lllllllllllllIIlIIIIIllIIIlIIIII < 0 || lllllllllllllIIlIIIIIllIIIIlllIl != this.value[lllllllllllllIIlIIIIIllIIIlIIIII]) {
            return false;
        }
        this.value[lllllllllllllIIlIIIIIllIIIlIIIII] = lllllllllllllIIlIIIIIllIIIIlllII;
        return true;
    }
    
    @Override
    public boolean containsKey(final Object lllllllllllllIIlIIIIIllIIlllIIIl) {
        if (lllllllllllllIIlIIIIIllIIlllIIIl == null) {
            return this.containsNullKey;
        }
        final K[] lllllllllllllIIlIIIIIllIIllIllll = this.key;
        int lllllllllllllIIlIIIIIllIIllIlllI;
        K lllllllllllllIIlIIIIIllIIlllIIII;
        if ((lllllllllllllIIlIIIIIllIIlllIIII = lllllllllllllIIlIIIIIllIIllIllll[lllllllllllllIIlIIIIIllIIllIlllI = (HashCommon.mix(lllllllllllllIIlIIIIIllIIlllIIIl.hashCode()) & this.mask)]) == null) {
            return false;
        }
        if (lllllllllllllIIlIIIIIllIIlllIIIl.equals(lllllllllllllIIlIIIIIllIIlllIIII)) {
            return true;
        }
        while ((lllllllllllllIIlIIIIIllIIlllIIII = lllllllllllllIIlIIIIIllIIllIllll[lllllllllllllIIlIIIIIllIIllIlllI = (lllllllllllllIIlIIIIIllIIllIlllI + 1 & this.mask)]) != null) {
            if (lllllllllllllIIlIIIIIllIIlllIIIl.equals(lllllllllllllIIlIIIIIllIIlllIIII)) {
                return true;
            }
        }
        return false;
    }
    
    public Object2IntLinkedOpenHashMap<K> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap;
        //     7: astore_1        /* lllllllllllllIIlIIIIIlIlIlIIIIll */
        //     8: goto            20
        //    11: astore_2        /* lllllllllllllIIlIIIIIlIlIlIIIIlI */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllllIIlIIIIIlIlIlIIIlIl */
        //    21: aconst_null    
        //    22: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.keys:Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectSortedSet;
        //    25: aload_1         /* lllllllllllllIIlIIIIIlIlIlIIIlIl */
        //    26: aconst_null    
        //    27: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.values:Lcom/viaversion/viaversion/libs/fastutil/ints/IntCollection;
        //    30: aload_1         /* lllllllllllllIIlIIIIIlIlIlIIIlIl */
        //    31: aconst_null    
        //    32: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.entries:Lcom/viaversion/viaversion/libs/fastutil/objects/Object2IntSortedMap$FastSortedEntrySet;
        //    35: aload_1         /* lllllllllllllIIlIIIIIlIlIlIIIlIl */
        //    36: aload_0         /* lllllllllllllIIlIIIIIlIlIlIIIllI */
        //    37: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.containsNullKey:Z
        //    40: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.containsNullKey:Z
        //    43: aload_1         /* lllllllllllllIIlIIIIIlIlIlIIIlIl */
        //    44: aload_0         /* lllllllllllllIIlIIIIIlIlIlIIIllI */
        //    45: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.key:[Ljava/lang/Object;
        //    48: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    51: checkcast       [Ljava/lang/Object;
        //    54: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.key:[Ljava/lang/Object;
        //    57: aload_1         /* lllllllllllllIIlIIIIIlIlIlIIIlIl */
        //    58: aload_0         /* lllllllllllllIIlIIIIIlIlIlIIIllI */
        //    59: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.value:[I
        //    62: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    65: checkcast       [I
        //    68: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.value:[I
        //    71: aload_1         /* lllllllllllllIIlIIIIIlIlIlIIIlIl */
        //    72: aload_0         /* lllllllllllllIIlIIIIIlIlIlIIIllI */
        //    73: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.link:[J
        //    76: invokevirtual   [J.clone:()Ljava/lang/Object;
        //    79: checkcast       [J
        //    82: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap.link:[J
        //    85: aload_1         /* lllllllllllllIIlIIIIIlIlIlIIIlIl */
        //    86: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/objects/Object2IntLinkedOpenHashMap<TK;>;
        //    StackMapTable: 00 02 4B 07 02 5B FC 00 08 07 00 02
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
    
    private void tryCapacity(final long lllllllllllllIIlIIIIIllllIIIlIlI) {
        final int lllllllllllllIIlIIIIIllllIIIlIIl = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(lllllllllllllIIlIIIIIllllIIIlIlI / this.f))));
        if (lllllllllllllIIlIIIIIllllIIIlIIl > this.n) {
            this.rehash(lllllllllllllIIlIIIIIllllIIIlIIl);
        }
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    @Override
    public int putIfAbsent(final K lllllllllllllIIlIIIIIllIIlIIIIlI, final int lllllllllllllIIlIIIIIllIIIllllIl) {
        final int lllllllllllllIIlIIIIIllIIlIIIIII = this.find(lllllllllllllIIlIIIIIllIIlIIIIlI);
        if (lllllllllllllIIlIIIIIllIIlIIIIII >= 0) {
            return this.value[lllllllllllllIIlIIIIIllIIlIIIIII];
        }
        this.insert(-lllllllllllllIIlIIIIIllIIlIIIIII - 1, lllllllllllllIIlIIIIIllIIlIIIIlI, lllllllllllllIIlIIIIIllIIIllllIl);
        return this.defRetValue;
    }
    
    private void ensureCapacity(final int lllllllllllllIIlIIIIIllllIIlIIII) {
        final int lllllllllllllIIlIIIIIllllIIlIIlI = HashCommon.arraySize(lllllllllllllIIlIIIIIllllIIlIIII, this.f);
        if (lllllllllllllIIlIIIIIllllIIlIIlI > this.n) {
            this.rehash(lllllllllllllIIlIIIIIllllIIlIIlI);
        }
    }
    
    @Override
    public Object2IntSortedMap<K> tailMap(final K lllllllllllllIIlIIIIIlIllIIllIII) {
        throw new UnsupportedOperationException();
    }
    
    private int addToValue(final int lllllllllllllIIlIIIIIlllIlIIIIIl, final int lllllllllllllIIlIIIIIlllIIllllII) {
        final int lllllllllllllIIlIIIIIlllIIllllll = this.value[lllllllllllllIIlIIIIIlllIlIIIIIl];
        this.value[lllllllllllllIIlIIIIIlllIlIIIIIl] = lllllllllllllIIlIIIIIlllIIllllll + lllllllllllllIIlIIIIIlllIIllllII;
        return lllllllllllllIIlIIIIIlllIIllllll;
    }
    
    public Object2IntLinkedOpenHashMap(final Object2IntMap<K> lllllllllllllIIlIIIIIllllIlllIlI, final float lllllllllllllIIlIIIIIllllIlllIIl) {
        this(lllllllllllllIIlIIIIIllllIlllIlI.size(), lllllllllllllIIlIIIIIllllIlllIIl);
        this.putAll((Map<? extends K, ? extends Integer>)lllllllllllllIIlIIIIIllllIlllIlI);
    }
    
    public Object2IntLinkedOpenHashMap(final K[] lllllllllllllIIlIIIIIllllIlIlIll, final int[] lllllllllllllIIlIIIIIllllIlIIllI, final float lllllllllllllIIlIIIIIllllIlIIlIl) {
        this(lllllllllllllIIlIIIIIllllIlIlIll.length, lllllllllllllIIlIIIIIllllIlIIlIl);
        if (lllllllllllllIIlIIIIIllllIlIlIll.length != lllllllllllllIIlIIIIIllllIlIIllI.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The key array and the value array have different lengths (").append(lllllllllllllIIlIIIIIllllIlIlIll.length).append(" and ").append(lllllllllllllIIlIIIIIllllIlIIllI.length).append(")")));
        }
        for (int lllllllllllllIIlIIIIIllllIlIllIl = 0; lllllllllllllIIlIIIIIllllIlIllIl < lllllllllllllIIlIIIIIllllIlIlIll.length; ++lllllllllllllIIlIIIIIllllIlIllIl) {
            this.put(lllllllllllllIIlIIIIIllllIlIlIll[lllllllllllllIIlIIIIIllllIlIllIl], lllllllllllllIIlIIIIIllllIlIIllI[lllllllllllllIIlIIIIIllllIlIllIl]);
        }
    }
    
    private int removeEntry(final int lllllllllllllIIlIIIIIlllIllllllI) {
        final int lllllllllllllIIlIIIIIllllIIIIIII = this.value[lllllllllllllIIlIIIIIlllIllllllI];
        --this.size;
        this.fixPointers(lllllllllllllIIlIIIIIlllIllllllI);
        this.shiftKeys(lllllllllllllIIlIIIIIlllIllllllI);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIlIIIIIllllIIIIIII;
    }
    
    private int realSize() {
        return this.containsNullKey ? (this.size - 1) : this.size;
    }
    
    @Override
    public Object2IntSortedMap<K> headMap(final K lllllllllllllIIlIIIIIlIllIIlIllI) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIlIIIIIlIlIIlllIII = 0;
        int lllllllllllllIIlIIIIIlIlIIllllII = this.realSize();
        int lllllllllllllIIlIIIIIlIlIIlllIll = 0;
        int lllllllllllllIIlIIIIIlIlIIlllIlI = 0;
        while (lllllllllllllIIlIIIIIlIlIIllllII-- != 0) {
            while (this.key[lllllllllllllIIlIIIIIlIlIIlllIll] == null) {
                ++lllllllllllllIIlIIIIIlIlIIlllIll;
            }
            if (this != this.key[lllllllllllllIIlIIIIIlIlIIlllIll]) {
                lllllllllllllIIlIIIIIlIlIIlllIlI = this.key[lllllllllllllIIlIIIIIlIlIIlllIll].hashCode();
            }
            lllllllllllllIIlIIIIIlIlIIlllIlI ^= this.value[lllllllllllllIIlIIIIIlIlIIlllIll];
            lllllllllllllIIlIIIIIlIlIIlllIII += lllllllllllllIIlIIIIIlIlIIlllIlI;
            ++lllllllllllllIIlIIIIIlIlIIlllIll;
        }
        if (this.containsNullKey) {
            lllllllllllllIIlIIIIIlIlIIlllIII += this.value[this.n];
        }
        return lllllllllllllIIlIIIIIlIlIIlllIII;
    }
    
    public int putAndMoveToFirst(final K lllllllllllllIIlIIIIIllIlIIllllI, final int lllllllllllllIIlIIIIIllIlIlIIIIl) {
        int lllllllllllllIIlIIIIIllIlIlIIIII = 0;
        if (lllllllllllllIIlIIIIIllIlIIllllI == null) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.setValue(this.n, lllllllllllllIIlIIIIIllIlIlIIIIl);
            }
            this.containsNullKey = true;
            final int lllllllllllllIIlIIIIIllIlIlIIllI = this.n;
        }
        else {
            final K[] lllllllllllllIIlIIIIIllIlIlIIlII = this.key;
            K lllllllllllllIIlIIIIIllIlIlIIlIl;
            if ((lllllllllllllIIlIIIIIllIlIlIIlIl = lllllllllllllIIlIIIIIllIlIlIIlII[lllllllllllllIIlIIIIIllIlIlIIIII = (HashCommon.mix(lllllllllllllIIlIIIIIllIlIIllllI.hashCode()) & this.mask)]) != null) {
                if (lllllllllllllIIlIIIIIllIlIlIIlIl.equals(lllllllllllllIIlIIIIIllIlIIllllI)) {
                    this.moveIndexToFirst(lllllllllllllIIlIIIIIllIlIlIIIII);
                    return this.setValue(lllllllllllllIIlIIIIIllIlIlIIIII, lllllllllllllIIlIIIIIllIlIlIIIIl);
                }
                while ((lllllllllllllIIlIIIIIllIlIlIIlIl = lllllllllllllIIlIIIIIllIlIlIIlII[lllllllllllllIIlIIIIIllIlIlIIIII = (lllllllllllllIIlIIIIIllIlIlIIIII + 1 & this.mask)]) != null) {
                    if (lllllllllllllIIlIIIIIllIlIlIIlIl.equals(lllllllllllllIIlIIIIIllIlIIllllI)) {
                        this.moveIndexToFirst(lllllllllllllIIlIIIIIllIlIlIIIII);
                        return this.setValue(lllllllllllllIIlIIIIIllIlIlIIIII, lllllllllllllIIlIIIIIllIlIlIIIIl);
                    }
                }
            }
        }
        this.key[lllllllllllllIIlIIIIIllIlIlIIIII] = lllllllllllllIIlIIIIIllIlIIllllI;
        this.value[lllllllllllllIIlIIIIIllIlIlIIIII] = lllllllllllllIIlIIIIIllIlIlIIIIl;
        if (this.size == 0) {
            final int n = lllllllllllllIIlIIIIIllIlIlIIIII;
            this.last = n;
            this.first = n;
            this.link[lllllllllllllIIlIIIIIllIlIlIIIII] = -1L;
        }
        else {
            final long[] link = this.link;
            final int first = this.first;
            link[first] ^= ((this.link[this.first] ^ ((long)lllllllllllllIIlIIIIIllIlIlIIIII & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[lllllllllllllIIlIIIIIllIlIlIIIII] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
            this.first = lllllllllllllIIlIIIIIllIlIlIIIII;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }
    
    @Override
    public Object2IntSortedMap.FastSortedEntrySet<K> object2IntEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }
    
    @Override
    public boolean containsValue(final int lllllllllllllIIlIIIIIllIIllIIIIl) {
        final int[] lllllllllllllIIlIIIIIllIIllIIIII = this.value;
        final K[] lllllllllllllIIlIIIIIllIIlIlllll = this.key;
        if (this.containsNullKey && lllllllllllllIIlIIIIIllIIllIIIII[this.n] == lllllllllllllIIlIIIIIllIIllIIIIl) {
            return true;
        }
        int lllllllllllllIIlIIIIIllIIllIIIll = this.n;
        while (lllllllllllllIIlIIIIIllIIllIIIll-- != 0) {
            if (lllllllllllllIIlIIIIIllIIlIlllll[lllllllllllllIIlIIIIIllIIllIIIll] != null && lllllllllllllIIlIIIIIllIIllIIIII[lllllllllllllIIlIIIIIllIIllIIIll] == lllllllllllllIIlIIIIIllIIllIIIIl) {
                return true;
            }
        }
        return false;
    }
    
    public int putAndMoveToLast(final K lllllllllllllIIlIIIIIllIlIIIllll, final int lllllllllllllIIlIIIIIllIlIIIlllI) {
        int lllllllllllllIIlIIIIIllIlIIIllIl = 0;
        if (lllllllllllllIIlIIIIIllIlIIIllll == null) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.setValue(this.n, lllllllllllllIIlIIIIIllIlIIIlllI);
            }
            this.containsNullKey = true;
            final int lllllllllllllIIlIIIIIllIlIIlIIll = this.n;
        }
        else {
            final K[] lllllllllllllIIlIIIIIllIlIIlIIIl = this.key;
            K lllllllllllllIIlIIIIIllIlIIlIIlI;
            if ((lllllllllllllIIlIIIIIllIlIIlIIlI = lllllllllllllIIlIIIIIllIlIIlIIIl[lllllllllllllIIlIIIIIllIlIIIllIl = (HashCommon.mix(lllllllllllllIIlIIIIIllIlIIIllll.hashCode()) & this.mask)]) != null) {
                if (lllllllllllllIIlIIIIIllIlIIlIIlI.equals(lllllllllllllIIlIIIIIllIlIIIllll)) {
                    this.moveIndexToLast(lllllllllllllIIlIIIIIllIlIIIllIl);
                    return this.setValue(lllllllllllllIIlIIIIIllIlIIIllIl, lllllllllllllIIlIIIIIllIlIIIlllI);
                }
                while ((lllllllllllllIIlIIIIIllIlIIlIIlI = lllllllllllllIIlIIIIIllIlIIlIIIl[lllllllllllllIIlIIIIIllIlIIIllIl = (lllllllllllllIIlIIIIIllIlIIIllIl + 1 & this.mask)]) != null) {
                    if (lllllllllllllIIlIIIIIllIlIIlIIlI.equals(lllllllllllllIIlIIIIIllIlIIIllll)) {
                        this.moveIndexToLast(lllllllllllllIIlIIIIIllIlIIIllIl);
                        return this.setValue(lllllllllllllIIlIIIIIllIlIIIllIl, lllllllllllllIIlIIIIIllIlIIIlllI);
                    }
                }
            }
        }
        this.key[lllllllllllllIIlIIIIIllIlIIIllIl] = lllllllllllllIIlIIIIIllIlIIIllll;
        this.value[lllllllllllllIIlIIIIIllIlIIIllIl] = lllllllllllllIIlIIIIIllIlIIIlllI;
        if (this.size == 0) {
            final int n = lllllllllllllIIlIIIIIllIlIIIllIl;
            this.last = n;
            this.first = n;
            this.link[lllllllllllllIIlIIIIIllIlIIIllIl] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIlIIIIIllIlIIIllIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIlIIIIIllIlIIIllIl] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = lllllllllllllIIlIIIIIllIlIIIllIl;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }
    
    public int getAndMoveToLast(final K lllllllllllllIIlIIIIIllIlIllIlIl) {
        if (lllllllllllllIIlIIIIIllIlIllIlIl == null) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        else {
            final K[] lllllllllllllIIlIIIIIllIlIllIIll = this.key;
            int lllllllllllllIIlIIIIIllIlIllIIlI;
            K lllllllllllllIIlIIIIIllIlIllIlII;
            if ((lllllllllllllIIlIIIIIllIlIllIlII = lllllllllllllIIlIIIIIllIlIllIIll[lllllllllllllIIlIIIIIllIlIllIIlI = (HashCommon.mix(lllllllllllllIIlIIIIIllIlIllIlIl.hashCode()) & this.mask)]) == null) {
                return this.defRetValue;
            }
            if (lllllllllllllIIlIIIIIllIlIllIlIl.equals(lllllllllllllIIlIIIIIllIlIllIlII)) {
                this.moveIndexToLast(lllllllllllllIIlIIIIIllIlIllIIlI);
                return this.value[lllllllllllllIIlIIIIIllIlIllIIlI];
            }
            while ((lllllllllllllIIlIIIIIllIlIllIlII = lllllllllllllIIlIIIIIllIlIllIIll[lllllllllllllIIlIIIIIllIlIllIIlI = (lllllllllllllIIlIIIIIllIlIllIIlI + 1 & this.mask)]) != null) {
                if (lllllllllllllIIlIIIIIllIlIllIlIl.equals(lllllllllllllIIlIIIIIllIlIllIlII)) {
                    this.moveIndexToLast(lllllllllllllIIlIIIIIllIlIllIIlI);
                    return this.value[lllllllllllllIIlIIIIIllIlIllIIlI];
                }
            }
            return this.defRetValue;
        }
    }
    
    @Override
    public K firstKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.first];
    }
    
    private void moveIndexToLast(final int lllllllllllllIIlIIIIIllIllIlIIII) {
        if (this.size == 1 || this.last == lllllllllllllIIlIIIIIllIllIlIIII) {
            return;
        }
        if (this.first == lllllllllllllIIlIIIIIllIllIlIIII) {
            this.first = (int)this.link[lllllllllllllIIlIIIIIllIllIlIIII];
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        else {
            final long lllllllllllllIIlIIIIIllIllIlIlII = this.link[lllllllllllllIIlIIIIIllIllIlIIII];
            final int lllllllllllllIIlIIIIIllIllIlIIll = (int)(lllllllllllllIIlIIIIIllIllIlIlII >>> 32);
            final int lllllllllllllIIlIIIIIllIllIlIIlI = (int)lllllllllllllIIlIIIIIllIllIlIlII;
            final long[] link2 = this.link;
            final int n = lllllllllllllIIlIIIIIllIllIlIIll;
            link2[n] ^= ((this.link[lllllllllllllIIlIIIIIllIllIlIIll] ^ (lllllllllllllIIlIIIIIllIllIlIlII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = lllllllllllllIIlIIIIIllIllIlIIlI;
            link3[n2] ^= ((this.link[lllllllllllllIIlIIIIIllIllIlIIlI] ^ (lllllllllllllIIlIIIIIllIllIlIlII & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int last = this.last;
        link4[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIlIIIIIllIllIlIIII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        this.link[lllllllllllllIIlIIIIIllIllIlIIII] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
        this.last = lllllllllllllIIlIIIIIllIllIlIIII;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public Object2IntLinkedOpenHashMap(final int lllllllllllllIIlIIIIIlllllIlIlII) {
        this(lllllllllllllIIlIIIIIlllllIlIlII, 0.75f);
    }
    
    @Override
    public boolean remove(final Object lllllllllllllIIlIIIIIllIIIlIlllI, final int lllllllllllllIIlIIIIIllIIIlIllIl) {
        if (lllllllllllllIIlIIIIIllIIIlIlllI == null) {
            if (this.containsNullKey && lllllllllllllIIlIIIIIllIIIlIllIl == this.value[this.n]) {
                this.removeNullEntry();
                return true;
            }
            return false;
        }
        else {
            final K[] lllllllllllllIIlIIIIIllIIIllIIIl = this.key;
            int lllllllllllllIIlIIIIIllIIIllIIII;
            K lllllllllllllIIlIIIIIllIIIllIIlI;
            if ((lllllllllllllIIlIIIIIllIIIllIIlI = lllllllllllllIIlIIIIIllIIIllIIIl[lllllllllllllIIlIIIIIllIIIllIIII = (HashCommon.mix(lllllllllllllIIlIIIIIllIIIlIlllI.hashCode()) & this.mask)]) == null) {
                return false;
            }
            if (lllllllllllllIIlIIIIIllIIIlIlllI.equals(lllllllllllllIIlIIIIIllIIIllIIlI) && lllllllllllllIIlIIIIIllIIIlIllIl == this.value[lllllllllllllIIlIIIIIllIIIllIIII]) {
                this.removeEntry(lllllllllllllIIlIIIIIllIIIllIIII);
                return true;
            }
            while ((lllllllllllllIIlIIIIIllIIIllIIlI = lllllllllllllIIlIIIIIllIIIllIIIl[lllllllllllllIIlIIIIIllIIIllIIII = (lllllllllllllIIlIIIIIllIIIllIIII + 1 & this.mask)]) != null) {
                if (lllllllllllllIIlIIIIIllIIIlIlllI.equals(lllllllllllllIIlIIIIIllIIIllIIlI) && lllllllllllllIIlIIIIIllIIIlIllIl == this.value[lllllllllllllIIlIIIIIllIIIllIIII]) {
                    this.removeEntry(lllllllllllllIIlIIIIIllIIIllIIII);
                    return true;
                }
            }
            return false;
        }
    }
    
    private int removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.n] = null;
        final int lllllllllllllIIlIIIIIlllIllllIIl = this.value[this.n];
        --this.size;
        this.fixPointers(this.n);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIlIIIIIlllIllllIIl;
    }
    
    private void moveIndexToFirst(final int lllllllllllllIIlIIIIIllIllIlllIl) {
        if (this.size == 1 || this.first == lllllllllllllIIlIIIIIllIllIlllIl) {
            return;
        }
        if (this.last == lllllllllllllIIlIIIIIllIllIlllIl) {
            this.last = (int)(this.link[lllllllllllllIIlIIIIIllIllIlllIl] >>> 32);
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        else {
            final long lllllllllllllIIlIIIIIllIlllIIIll = this.link[lllllllllllllIIlIIIIIllIllIlllIl];
            final int lllllllllllllIIlIIIIIllIlllIIIlI = (int)(lllllllllllllIIlIIIIIllIlllIIIll >>> 32);
            final int lllllllllllllIIlIIIIIllIlllIIIIl = (int)lllllllllllllIIlIIIIIllIlllIIIll;
            final long[] link2 = this.link;
            final int n = lllllllllllllIIlIIIIIllIlllIIIlI;
            link2[n] ^= ((this.link[lllllllllllllIIlIIIIIllIlllIIIlI] ^ (lllllllllllllIIlIIIIIllIlllIIIll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = lllllllllllllIIlIIIIIllIlllIIIIl;
            link3[n2] ^= ((this.link[lllllllllllllIIlIIIIIllIlllIIIIl] ^ (lllllllllllllIIlIIIIIllIlllIIIll & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int first = this.first;
        link4[first] ^= ((this.link[this.first] ^ ((long)lllllllllllllIIlIIIIIllIllIlllIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[lllllllllllllIIlIIIIIllIllIlllIl] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
        this.first = lllllllllllllIIlIIIIIllIllIlllIl;
    }
    
    @Override
    public int put(final K lllllllllllllIIlIIIIIlllIlIIlIlI, final int lllllllllllllIIlIIIIIlllIlIIlIIl) {
        final int lllllllllllllIIlIIIIIlllIlIIllIl = this.find(lllllllllllllIIlIIIIIlllIlIIlIlI);
        if (lllllllllllllIIlIIIIIlllIlIIllIl < 0) {
            this.insert(-lllllllllllllIIlIIIIIlllIlIIllIl - 1, lllllllllllllIIlIIIIIlllIlIIlIlI, lllllllllllllIIlIIIIIlllIlIIlIIl);
            return this.defRetValue;
        }
        final int lllllllllllllIIlIIIIIlllIlIIllII = this.value[lllllllllllllIIlIIIIIlllIlIIllIl];
        this.value[lllllllllllllIIlIIIIIlllIlIIllIl] = lllllllllllllIIlIIIIIlllIlIIlIIl;
        return lllllllllllllIIlIIIIIlllIlIIllII;
    }
    
    public Object2IntLinkedOpenHashMap(final Map<? extends K, ? extends Integer> lllllllllllllIIlIIIIIlllllIIllII, final float lllllllllllllIIlIIIIIlllllIIlIll) {
        this(lllllllllllllIIlIIIIIlllllIIllII.size(), lllllllllllllIIlIIIIIlllllIIlIll);
        this.putAll(lllllllllllllIIlIIIIIlllllIIllII);
    }
    
    @Override
    public int mergeInt(final K lllllllllllllIIlIIIIIlIlllIlIlII, final int lllllllllllllIIlIIIIIlIlllIlIIll, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIIlIIIIIlIlllIIllII) {
        Objects.requireNonNull(lllllllllllllIIlIIIIIlIlllIIllII);
        final int lllllllllllllIIlIIIIIlIlllIlIIIl = this.find(lllllllllllllIIlIIIIIlIlllIlIlII);
        if (lllllllllllllIIlIIIIIlIlllIlIIIl < 0) {
            this.insert(-lllllllllllllIIlIIIIIlIlllIlIIIl - 1, lllllllllllllIIlIIIIIlIlllIlIlII, lllllllllllllIIlIIIIIlIlllIlIIll);
            return lllllllllllllIIlIIIIIlIlllIlIIll;
        }
        final Integer lllllllllllllIIlIIIIIlIlllIlIIII = (Integer)lllllllllllllIIlIIIIIlIlllIIllII.apply(this.value[lllllllllllllIIlIIIIIlIlllIlIIIl], lllllllllllllIIlIIIIIlIlllIlIIll);
        if (lllllllllllllIIlIIIIIlIlllIlIIII == null) {
            if (lllllllllllllIIlIIIIIlIlllIlIlII == null) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(lllllllllllllIIlIIIIIlIlllIlIIIl);
            }
            return this.defRetValue;
        }
        return this.value[lllllllllllllIIlIIIIIlIlllIlIIIl] = lllllllllllllIIlIIIIIlIlllIlIIII;
    }
    
    @Override
    public int computeInt(final K lllllllllllllIIlIIIIIlIllllIIllI, final BiFunction<? super K, ? super Integer, ? extends Integer> lllllllllllllIIlIIIIIlIlllIlllll) {
        Objects.requireNonNull(lllllllllllllIIlIIIIIlIlllIlllll);
        final int lllllllllllllIIlIIIIIlIllllIIlII = this.find(lllllllllllllIIlIIIIIlIllllIIllI);
        final Integer lllllllllllllIIlIIIIIlIllllIIIll = (Integer)lllllllllllllIIlIIIIIlIlllIlllll.apply((Object)lllllllllllllIIlIIIIIlIllllIIllI, (lllllllllllllIIlIIIIIlIllllIIlII >= 0) ? Integer.valueOf(this.value[lllllllllllllIIlIIIIIlIllllIIlII]) : null);
        if (lllllllllllllIIlIIIIIlIllllIIIll == null) {
            if (lllllllllllllIIlIIIIIlIllllIIlII >= 0) {
                if (lllllllllllllIIlIIIIIlIllllIIllI == null) {
                    this.removeNullEntry();
                }
                else {
                    this.removeEntry(lllllllllllllIIlIIIIIlIllllIIlII);
                }
            }
            return this.defRetValue;
        }
        final int lllllllllllllIIlIIIIIlIllllIIIlI = lllllllllllllIIlIIIIIlIllllIIIll;
        if (lllllllllllllIIlIIIIIlIllllIIlII < 0) {
            this.insert(-lllllllllllllIIlIIIIIlIllllIIlII - 1, lllllllllllllIIlIIIIIlIllllIIllI, lllllllllllllIIlIIIIIlIllllIIIlI);
            return lllllllllllllIIlIIIIIlIllllIIIlI;
        }
        return this.value[lllllllllllllIIlIIIIIlIllllIIlII] = lllllllllllllIIlIIIIIlIllllIIIlI;
    }
    
    @Override
    public K lastKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.last];
    }
    
    @Override
    public int computeIntIfAbsent(final K lllllllllllllIIlIIIIIllIIIIIIIII, final ToIntFunction<? super K> lllllllllllllIIlIIIIIllIIIIIIlII) {
        Objects.requireNonNull(lllllllllllllIIlIIIIIllIIIIIIlII);
        final int lllllllllllllIIlIIIIIllIIIIIIIll = this.find(lllllllllllllIIlIIIIIllIIIIIIIII);
        if (lllllllllllllIIlIIIIIllIIIIIIIll >= 0) {
            return this.value[lllllllllllllIIlIIIIIllIIIIIIIll];
        }
        final int lllllllllllllIIlIIIIIllIIIIIIIlI = lllllllllllllIIlIIIIIllIIIIIIlII.applyAsInt((Object)lllllllllllllIIlIIIIIllIIIIIIIII);
        this.insert(-lllllllllllllIIlIIIIIllIIIIIIIll - 1, lllllllllllllIIlIIIIIllIIIIIIIII, lllllllllllllIIlIIIIIllIIIIIIIlI);
        return lllllllllllllIIlIIIIIllIIIIIIIlI;
    }
    
    private int setValue(final int lllllllllllllIIlIIIIIllIllllllIl, final int lllllllllllllIIlIIIIIllIllllllII) {
        final int lllllllllllllIIlIIIIIllIllllllll = this.value[lllllllllllllIIlIIIIIllIllllllIl];
        this.value[lllllllllllllIIlIIIIIllIllllllIl] = lllllllllllllIIlIIIIIllIllllllII;
        return lllllllllllllIIlIIIIIllIllllllll;
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllIIlIIIIIlIlIIlIlIII) throws IOException {
        final K[] lllllllllllllIIlIIIIIlIlIIlIIlll = this.key;
        final int[] lllllllllllllIIlIIIIIlIlIIlIIllI = this.value;
        final MapIterator lllllllllllllIIlIIIIIlIlIIlIIlIl = new MapIterator();
        lllllllllllllIIlIIIIIlIlIIlIlIII.defaultWriteObject();
        int lllllllllllllIIlIIIIIlIlIIlIlIll = this.size;
        while (lllllllllllllIIlIIIIIlIlIIlIlIll-- != 0) {
            final int lllllllllllllIIlIIIIIlIlIIlIlIlI = lllllllllllllIIlIIIIIlIlIIlIIlIl.nextEntry();
            lllllllllllllIIlIIIIIlIlIIlIlIII.writeObject(lllllllllllllIIlIIIIIlIlIIlIIlll[lllllllllllllIIlIIIIIlIlIIlIlIlI]);
            lllllllllllllIIlIIIIIlIlIIlIlIII.writeInt(lllllllllllllIIlIIIIIlIlIIlIIllI[lllllllllllllIIlIIIIIlIlIIlIlIlI]);
        }
    }
    
    public int removeFirstInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int lllllllllllllIIlIIIIIllIllllIllI = this.first;
        this.first = (int)this.link[lllllllllllllIIlIIIIIllIllllIllI];
        if (0 <= this.first) {
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        --this.size;
        final int lllllllllllllIIlIIIIIllIllllIlIl = this.value[lllllllllllllIIlIIIIIllIllllIllI];
        if (lllllllllllllIIlIIIIIllIllllIllI == this.n) {
            this.containsNullKey = false;
            this.key[this.n] = null;
        }
        else {
            this.shiftKeys(lllllllllllllIIlIIIIIllIllllIllI);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIlIIIIIllIllllIlIl;
    }
    
    protected void fixPointers(final int lllllllllllllIIlIIIIIlIllIlIIlII, final int lllllllllllllIIlIIIIIlIllIlIlIIl) {
        if (this.size == 1) {
            this.last = lllllllllllllIIlIIIIIlIllIlIlIIl;
            this.first = lllllllllllllIIlIIIIIlIllIlIlIIl;
            this.link[lllllllllllllIIlIIIIIlIllIlIlIIl] = -1L;
            return;
        }
        if (this.first == lllllllllllllIIlIIIIIlIllIlIIlII) {
            this.first = lllllllllllllIIlIIIIIlIllIlIlIIl;
            final long[] link = this.link;
            final int n = (int)this.link[lllllllllllllIIlIIIIIlIllIlIIlII];
            link[n] ^= ((this.link[(int)this.link[lllllllllllllIIlIIIIIlIllIlIIlII]] ^ ((long)lllllllllllllIIlIIIIIlIllIlIlIIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[lllllllllllllIIlIIIIIlIllIlIlIIl] = this.link[lllllllllllllIIlIIIIIlIllIlIIlII];
            return;
        }
        if (this.last == lllllllllllllIIlIIIIIlIllIlIIlII) {
            this.last = lllllllllllllIIlIIIIIlIllIlIlIIl;
            final long[] link2 = this.link;
            final int n2 = (int)(this.link[lllllllllllllIIlIIIIIlIllIlIIlII] >>> 32);
            link2[n2] ^= ((this.link[(int)(this.link[lllllllllllllIIlIIIIIlIllIlIIlII] >>> 32)] ^ ((long)lllllllllllllIIlIIIIIlIllIlIlIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIlIIIIIlIllIlIlIIl] = this.link[lllllllllllllIIlIIIIIlIllIlIIlII];
            return;
        }
        final long lllllllllllllIIlIIIIIlIllIlIlIII = this.link[lllllllllllllIIlIIIIIlIllIlIIlII];
        final int lllllllllllllIIlIIIIIlIllIlIIlll = (int)(lllllllllllllIIlIIIIIlIllIlIlIII >>> 32);
        final int lllllllllllllIIlIIIIIlIllIlIIllI = (int)lllllllllllllIIlIIIIIlIllIlIlIII;
        final long[] link3 = this.link;
        final int n3 = lllllllllllllIIlIIIIIlIllIlIIlll;
        link3[n3] ^= ((this.link[lllllllllllllIIlIIIIIlIllIlIIlll] ^ ((long)lllllllllllllIIlIIIIIlIllIlIlIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n4 = lllllllllllllIIlIIIIIlIllIlIIllI;
        link4[n4] ^= ((this.link[lllllllllllllIIlIIIIIlIllIlIIllI] ^ ((long)lllllllllllllIIlIIIIIlIllIlIlIIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[lllllllllllllIIlIIIIIlIllIlIlIIl] = lllllllllllllIIlIIIIIlIllIlIlIII;
    }
    
    public Object2IntLinkedOpenHashMap(final Map<? extends K, ? extends Integer> lllllllllllllIIlIIIIIlllllIIIlII) {
        this(lllllllllllllIIlIIIIIlllllIIIlII, 0.75f);
    }
    
    private final class ValueIterator extends MapIterator implements IntListIterator
    {
        public ValueIterator() {
        }
        
        @Override
        public int nextInt() {
            return Object2IntLinkedOpenHashMap.this.value[this.nextEntry()];
        }
        
        @Override
        public int previousInt() {
            return Object2IntLinkedOpenHashMap.this.value[this.previousEntry()];
        }
    }
    
    private class MapIterator
    {
        /* synthetic */ int index;
        /* synthetic */ int next;
        /* synthetic */ int prev;
        /* synthetic */ int curr;
        
        public int nextIndex() {
            this.ensureIndexKnown();
            return this.index;
        }
        
        private MapIterator(final K lllllllllllllIIIIIlIIIIIlIIIIlll) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (lllllllllllllIIIIIlIIIIIlIIIIlll == null) {
                if (Object2IntLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int)Object2IntLinkedOpenHashMap.this.link[Object2IntLinkedOpenHashMap.this.n];
                    this.prev = Object2IntLinkedOpenHashMap.this.n;
                    return;
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(lllllllllllllIIIIIlIIIIIlIIIIlll).append(" does not belong to this map.")));
            }
            else {
                if (Objects.equals(Object2IntLinkedOpenHashMap.this.key[Object2IntLinkedOpenHashMap.this.last], lllllllllllllIIIIIlIIIIIlIIIIlll)) {
                    this.prev = Object2IntLinkedOpenHashMap.this.last;
                    this.index = Object2IntLinkedOpenHashMap.this.size;
                    return;
                }
                for (int lllllllllllllIIIIIlIIIIIlIIIIllI = HashCommon.mix(lllllllllllllIIIIIlIIIIIlIIIIlll.hashCode()) & Object2IntLinkedOpenHashMap.this.mask; Object2IntLinkedOpenHashMap.this.key[lllllllllllllIIIIIlIIIIIlIIIIllI] != null; lllllllllllllIIIIIlIIIIIlIIIIllI = (lllllllllllllIIIIIlIIIIIlIIIIllI + 1 & Object2IntLinkedOpenHashMap.this.mask)) {
                    if (Object2IntLinkedOpenHashMap.this.key[lllllllllllllIIIIIlIIIIIlIIIIllI].equals(lllllllllllllIIIIIlIIIIIlIIIIlll)) {
                        this.next = (int)Object2IntLinkedOpenHashMap.this.link[lllllllllllllIIIIIlIIIIIlIIIIllI];
                        this.prev = lllllllllllllIIIIIlIIIIIlIIIIllI;
                        return;
                    }
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(lllllllllllllIIIIIlIIIIIlIIIIlll).append(" does not belong to this map.")));
            }
        }
        
        public void add(final Object2IntMap.Entry<K> lllllllllllllIIIIIlIIIIIIlIIIIlI) {
            throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
            return this.next != -1;
        }
        
        public int previousEntry() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int)(Object2IntLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                --this.index;
            }
            return this.curr;
        }
        
        public void set(final Object2IntMap.Entry<K> lllllllllllllIIIIIlIIIIIIlIIIlII) {
            throw new UnsupportedOperationException();
        }
        
        protected MapIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = Object2IntLinkedOpenHashMap.this.first;
            this.index = 0;
        }
        
        private final void ensureIndexKnown() {
            if (this.index >= 0) {
                return;
            }
            if (this.prev == -1) {
                this.index = 0;
                return;
            }
            if (this.next == -1) {
                this.index = Object2IntLinkedOpenHashMap.this.size;
                return;
            }
            int lllllllllllllIIIIIlIIIIIIllllIII = Object2IntLinkedOpenHashMap.this.first;
            this.index = 1;
            while (lllllllllllllIIIIIlIIIIIIllllIII != this.prev) {
                lllllllllllllIIIIIlIIIIIIllllIII = (int)Object2IntLinkedOpenHashMap.this.link[lllllllllllllIIIIIlIIIIIIllllIII];
                ++this.index;
            }
        }
        
        public int back(final int lllllllllllllIIIIIlIIIIIIlIIIlll) {
            int lllllllllllllIIIIIlIIIIIIlIIlIIl = lllllllllllllIIIIIlIIIIIIlIIIlll;
            while (lllllllllllllIIIIIlIIIIIIlIIlIIl-- != 0 && this.hasPrevious()) {
                this.previousEntry();
            }
            return lllllllllllllIIIIIlIIIIIIlIIIlll - lllllllllllllIIIIIlIIIIIIlIIlIIl - 1;
        }
        
        public int previousIndex() {
            this.ensureIndexKnown();
            return this.index - 1;
        }
        
        public void remove() {
            this.ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                --this.index;
                this.prev = (int)(Object2IntLinkedOpenHashMap.this.link[this.curr] >>> 32);
            }
            else {
                this.next = (int)Object2IntLinkedOpenHashMap.this.link[this.curr];
            }
            final Object2IntLinkedOpenHashMap this$0 = Object2IntLinkedOpenHashMap.this;
            --this$0.size;
            if (this.prev == -1) {
                Object2IntLinkedOpenHashMap.this.first = this.next;
            }
            else {
                final long[] link = Object2IntLinkedOpenHashMap.this.link;
                final int prev = this.prev;
                link[prev] ^= ((Object2IntLinkedOpenHashMap.this.link[this.prev] ^ ((long)this.next & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            }
            if (this.next == -1) {
                Object2IntLinkedOpenHashMap.this.last = this.prev;
            }
            else {
                final long[] link2 = Object2IntLinkedOpenHashMap.this.link;
                final int next = this.next;
                link2[next] ^= ((Object2IntLinkedOpenHashMap.this.link[this.next] ^ ((long)this.prev & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            }
            int lllllllllllllIIIIIlIIIIIIlIllllI = this.curr;
            this.curr = -1;
            if (lllllllllllllIIIIIlIIIIIIlIllllI == Object2IntLinkedOpenHashMap.this.n) {
                Object2IntLinkedOpenHashMap.this.containsNullKey = false;
                Object2IntLinkedOpenHashMap.this.key[Object2IntLinkedOpenHashMap.this.n] = null;
                return;
            }
            final K[] lllllllllllllIIIIIlIIIIIIllIIIlI = Object2IntLinkedOpenHashMap.this.key;
            int lllllllllllllIIIIIlIIIIIIllIIIIl = 0;
        Label_0280:
            while (true) {
                lllllllllllllIIIIIlIIIIIIlIllllI = ((lllllllllllllIIIIIlIIIIIIllIIIIl = lllllllllllllIIIIIlIIIIIIlIllllI) + 1 & Object2IntLinkedOpenHashMap.this.mask);
                K lllllllllllllIIIIIlIIIIIIllIIIll;
                while ((lllllllllllllIIIIIlIIIIIIllIIIll = lllllllllllllIIIIIlIIIIIIllIIIlI[lllllllllllllIIIIIlIIIIIIlIllllI]) != null) {
                    final int lllllllllllllIIIIIlIIIIIIllIIIII = HashCommon.mix(lllllllllllllIIIIIlIIIIIIllIIIll.hashCode()) & Object2IntLinkedOpenHashMap.this.mask;
                    Label_0373: {
                        if (lllllllllllllIIIIIlIIIIIIllIIIIl <= lllllllllllllIIIIIlIIIIIIlIllllI) {
                            if (lllllllllllllIIIIIlIIIIIIllIIIIl >= lllllllllllllIIIIIlIIIIIIllIIIII) {
                                break Label_0373;
                            }
                            if (lllllllllllllIIIIIlIIIIIIllIIIII > lllllllllllllIIIIIlIIIIIIlIllllI) {
                                break Label_0373;
                            }
                        }
                        else if (lllllllllllllIIIIIlIIIIIIllIIIIl >= lllllllllllllIIIIIlIIIIIIllIIIII && lllllllllllllIIIIIlIIIIIIllIIIII > lllllllllllllIIIIIlIIIIIIlIllllI) {
                            break Label_0373;
                        }
                        lllllllllllllIIIIIlIIIIIIlIllllI = (lllllllllllllIIIIIlIIIIIIlIllllI + 1 & Object2IntLinkedOpenHashMap.this.mask);
                        continue;
                    }
                    lllllllllllllIIIIIlIIIIIIllIIIlI[lllllllllllllIIIIIlIIIIIIllIIIIl] = lllllllllllllIIIIIlIIIIIIllIIIll;
                    Object2IntLinkedOpenHashMap.this.value[lllllllllllllIIIIIlIIIIIIllIIIIl] = Object2IntLinkedOpenHashMap.this.value[lllllllllllllIIIIIlIIIIIIlIllllI];
                    if (this.next == lllllllllllllIIIIIlIIIIIIlIllllI) {
                        this.next = lllllllllllllIIIIIlIIIIIIllIIIIl;
                    }
                    if (this.prev == lllllllllllllIIIIIlIIIIIIlIllllI) {
                        this.prev = lllllllllllllIIIIIlIIIIIIllIIIIl;
                    }
                    Object2IntLinkedOpenHashMap.this.fixPointers(lllllllllllllIIIIIlIIIIIIlIllllI, lllllllllllllIIIIIlIIIIIIllIIIIl);
                    continue Label_0280;
                }
                break;
            }
            lllllllllllllIIIIIlIIIIIIllIIIlI[lllllllllllllIIIIIlIIIIIIllIIIIl] = null;
        }
        
        public int skip(final int lllllllllllllIIIIIlIIIIIIlIlIIII) {
            int lllllllllllllIIIIIlIIIIIIlIlIIlI = lllllllllllllIIIIIlIIIIIIlIlIIII;
            while (lllllllllllllIIIIIlIIIIIIlIlIIlI-- != 0 && this.hasNext()) {
                this.nextEntry();
            }
            return lllllllllllllIIIIIlIIIIIIlIlIIII - lllllllllllllIIIIIlIIIIIIlIlIIlI - 1;
        }
        
        public int nextEntry() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int)Object2IntLinkedOpenHashMap.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                ++this.index;
            }
            return this.curr;
        }
        
        public boolean hasPrevious() {
            return this.prev != -1;
        }
    }
    
    private final class KeyIterator extends MapIterator implements ObjectListIterator<K>
    {
        public KeyIterator() {
        }
        
        public KeyIterator(final K lllllllllllllIIIlllIllIlIIIlIIll) {
            super((Object)lllllllllllllIIIlllIllIlIIIlIIll);
        }
        
        @Override
        public K next() {
            return Object2IntLinkedOpenHashMap.this.key[this.nextEntry()];
        }
        
        @Override
        public K previous() {
            return Object2IntLinkedOpenHashMap.this.key[this.previousEntry()];
        }
    }
    
    private class FastEntryIterator extends MapIterator implements ObjectListIterator<Object2IntMap.Entry<K>>
    {
        final /* synthetic */ MapEntry entry;
        
        @Override
        public MapEntry next() {
            this.entry.index = this.nextEntry();
            return this.entry;
        }
        
        public FastEntryIterator() {
            this.entry = new MapEntry();
        }
        
        public FastEntryIterator(final K llllllllllllllIIIlIlllIIIlllIIlI) {
            super((Object)llllllllllllllIIIlIlllIIIlllIIlI);
            this.entry = new MapEntry();
        }
        
        @Override
        public MapEntry previous() {
            this.entry.index = this.previousEntry();
            return this.entry;
        }
    }
    
    final class MapEntry implements Object2IntMap.Entry<K>, Map.Entry<K, Integer>
    {
        /* synthetic */ int index;
        
        MapEntry() {
        }
        
        @Override
        public int getIntValue() {
            return Object2IntLinkedOpenHashMap.this.value[this.index];
        }
        
        @Override
        public int hashCode() {
            return ((Object2IntLinkedOpenHashMap.this.key[this.index] == null) ? 0 : Object2IntLinkedOpenHashMap.this.key[this.index].hashCode()) ^ Object2IntLinkedOpenHashMap.this.value[this.index];
        }
        
        @Deprecated
        @Override
        public Integer getValue() {
            return Object2IntLinkedOpenHashMap.this.value[this.index];
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIlIIlIIlllIIIIllII) {
            if (!(llllllllllllllIlIIlIIlllIIIIllII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<K, Integer> llllllllllllllIlIIlIIlllIIIIlIll = (Map.Entry<K, Integer>)llllllllllllllIlIIlIIlllIIIIllII;
            return Objects.equals(Object2IntLinkedOpenHashMap.this.key[this.index], llllllllllllllIlIIlIIlllIIIIlIll.getKey()) && Object2IntLinkedOpenHashMap.this.value[this.index] == llllllllllllllIlIIlIIlllIIIIlIll.getValue();
        }
        
        MapEntry(final int llllllllllllllIlIIlIIlllIIlIllll) {
            this.index = llllllllllllllIlIIlIIlllIIlIllll;
        }
        
        @Override
        public int setValue(final int llllllllllllllIlIIlIIlllIIIllIll) {
            final int llllllllllllllIlIIlIIlllIIIlllIl = Object2IntLinkedOpenHashMap.this.value[this.index];
            Object2IntLinkedOpenHashMap.this.value[this.index] = llllllllllllllIlIIlIIlllIIIllIll;
            return llllllllllllllIlIIlIIlllIIIlllIl;
        }
        
        @Deprecated
        @Override
        public Integer setValue(final Integer llllllllllllllIlIIlIIlllIIIlIIIl) {
            return this.setValue((int)llllllllllllllIlIIlIIlllIIIlIIIl);
        }
        
        @Override
        public K getKey() {
            return Object2IntLinkedOpenHashMap.this.key[this.index];
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(Object2IntLinkedOpenHashMap.this.key[this.index]).append("=>").append(Object2IntLinkedOpenHashMap.this.value[this.index]));
        }
    }
    
    private final class MapEntrySet extends AbstractObjectSortedSet<Object2IntMap.Entry<K>> implements Object2IntSortedMap.FastSortedEntrySet<K>
    {
        @Override
        public ObjectListIterator<Object2IntMap.Entry<K>> iterator(final Object2IntMap.Entry<K> lllllllllllllIllllllIIllIlllIIIl) {
            return new EntryIterator(lllllllllllllIllllllIIllIlllIIIl.getKey());
        }
        
        @Override
        public Comparator<? super Object2IntMap.Entry<K>> comparator() {
            return null;
        }
        
        @Override
        public ObjectBidirectionalIterator<Object2IntMap.Entry<K>> iterator() {
            return new EntryIterator();
        }
        
        @Override
        public void forEach(final Consumer<? super Object2IntMap.Entry<K>> lllllllllllllIllllllIIllIlIllIlI) {
            int lllllllllllllIllllllIIllIllIIIII = Object2IntLinkedOpenHashMap.this.size;
            int lllllllllllllIllllllIIllIlIllllI = Object2IntLinkedOpenHashMap.this.first;
            while (lllllllllllllIllllllIIllIllIIIII-- != 0) {
                final int lllllllllllllIllllllIIllIlIlllll = lllllllllllllIllllllIIllIlIllllI;
                lllllllllllllIllllllIIllIlIllllI = (int)Object2IntLinkedOpenHashMap.this.link[lllllllllllllIllllllIIllIlIlllll];
                lllllllllllllIllllllIIllIlIllIlI.accept((Object)new BasicEntry((K)Object2IntLinkedOpenHashMap.this.key[lllllllllllllIllllllIIllIlIlllll], Object2IntLinkedOpenHashMap.this.value[lllllllllllllIllllllIIllIlIlllll]));
            }
        }
        
        @Override
        public ObjectSortedSet<Object2IntMap.Entry<K>> tailSet(final Object2IntMap.Entry<K> lllllllllllllIllllllIIlllIllIIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public ObjectListIterator<Object2IntMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }
        
        @Override
        public ObjectSortedSet<Object2IntMap.Entry<K>> headSet(final Object2IntMap.Entry<K> lllllllllllllIllllllIIlllIllIIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
            Object2IntLinkedOpenHashMap.this.clear();
        }
        
        @Override
        public int size() {
            return Object2IntLinkedOpenHashMap.this.size;
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIllllllIIlllIIIlIIl) {
            if (!(lllllllllllllIllllllIIlllIIIlIIl instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIllllllIIlllIIIlIII = (Map.Entry<?, ?>)lllllllllllllIllllllIIlllIIIlIIl;
            if (lllllllllllllIllllllIIlllIIIlIII.getValue() == null || !(lllllllllllllIllllllIIlllIIIlIII.getValue() instanceof Integer)) {
                return false;
            }
            final K lllllllllllllIllllllIIlllIIIIlll = (K)lllllllllllllIllllllIIlllIIIlIII.getKey();
            final int lllllllllllllIllllllIIlllIIIIllI = (int)lllllllllllllIllllllIIlllIIIlIII.getValue();
            if (lllllllllllllIllllllIIlllIIIIlll == null) {
                if (Object2IntLinkedOpenHashMap.this.containsNullKey && Object2IntLinkedOpenHashMap.this.value[Object2IntLinkedOpenHashMap.this.n] == lllllllllllllIllllllIIlllIIIIllI) {
                    Object2IntLinkedOpenHashMap.this.removeNullEntry();
                    return true;
                }
                return false;
            }
            else {
                final K[] lllllllllllllIllllllIIlllIIIIlII = Object2IntLinkedOpenHashMap.this.key;
                int lllllllllllllIllllllIIlllIIIIIll;
                K lllllllllllllIllllllIIlllIIIIlIl;
                if ((lllllllllllllIllllllIIlllIIIIlIl = lllllllllllllIllllllIIlllIIIIlII[lllllllllllllIllllllIIlllIIIIIll = (HashCommon.mix(lllllllllllllIllllllIIlllIIIIlll.hashCode()) & Object2IntLinkedOpenHashMap.this.mask)]) == null) {
                    return false;
                }
                if (!lllllllllllllIllllllIIlllIIIIlIl.equals(lllllllllllllIllllllIIlllIIIIlll)) {
                    while ((lllllllllllllIllllllIIlllIIIIlIl = lllllllllllllIllllllIIlllIIIIlII[lllllllllllllIllllllIIlllIIIIIll = (lllllllllllllIllllllIIlllIIIIIll + 1 & Object2IntLinkedOpenHashMap.this.mask)]) != null) {
                        if (lllllllllllllIllllllIIlllIIIIlIl.equals(lllllllllllllIllllllIIlllIIIIlll) && Object2IntLinkedOpenHashMap.this.value[lllllllllllllIllllllIIlllIIIIIll] == lllllllllllllIllllllIIlllIIIIllI) {
                            Object2IntLinkedOpenHashMap.this.removeEntry(lllllllllllllIllllllIIlllIIIIIll);
                            return true;
                        }
                    }
                    return false;
                }
                if (Object2IntLinkedOpenHashMap.this.value[lllllllllllllIllllllIIlllIIIIIll] == lllllllllllllIllllllIIlllIIIIllI) {
                    Object2IntLinkedOpenHashMap.this.removeEntry(lllllllllllllIllllllIIlllIIIIIll);
                    return true;
                }
                return false;
            }
        }
        
        @Override
        public Object2IntMap.Entry<K> last() {
            if (Object2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Object2IntLinkedOpenHashMap.this.last);
        }
        
        @Override
        public Object2IntMap.Entry<K> first() {
            if (Object2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Object2IntLinkedOpenHashMap.this.first);
        }
        
        @Override
        public ObjectSortedSet<Object2IntMap.Entry<K>> subSet(final Object2IntMap.Entry<K> lllllllllllllIllllllIIlllIllIllI, final Object2IntMap.Entry<K> lllllllllllllIllllllIIlllIllIlIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIllllllIIlllIIllIIl) {
            if (!(lllllllllllllIllllllIIlllIIllIIl instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIllllllIIlllIlIIIII = (Map.Entry<?, ?>)lllllllllllllIllllllIIlllIIllIIl;
            if (lllllllllllllIllllllIIlllIlIIIII.getValue() == null || !(lllllllllllllIllllllIIlllIlIIIII.getValue() instanceof Integer)) {
                return false;
            }
            final K lllllllllllllIllllllIIlllIIlllll = (K)lllllllllllllIllllllIIlllIlIIIII.getKey();
            final int lllllllllllllIllllllIIlllIIllllI = (int)lllllllllllllIllllllIIlllIlIIIII.getValue();
            if (lllllllllllllIllllllIIlllIIlllll == null) {
                return Object2IntLinkedOpenHashMap.this.containsNullKey && Object2IntLinkedOpenHashMap.this.value[Object2IntLinkedOpenHashMap.this.n] == lllllllllllllIllllllIIlllIIllllI;
            }
            final K[] lllllllllllllIllllllIIlllIIlllII = Object2IntLinkedOpenHashMap.this.key;
            int lllllllllllllIllllllIIlllIIllIll;
            K lllllllllllllIllllllIIlllIIlllIl;
            if ((lllllllllllllIllllllIIlllIIlllIl = lllllllllllllIllllllIIlllIIlllII[lllllllllllllIllllllIIlllIIllIll = (HashCommon.mix(lllllllllllllIllllllIIlllIIlllll.hashCode()) & Object2IntLinkedOpenHashMap.this.mask)]) == null) {
                return false;
            }
            if (lllllllllllllIllllllIIlllIIlllll.equals(lllllllllllllIllllllIIlllIIlllIl)) {
                return Object2IntLinkedOpenHashMap.this.value[lllllllllllllIllllllIIlllIIllIll] == lllllllllllllIllllllIIlllIIllllI;
            }
            while ((lllllllllllllIllllllIIlllIIlllIl = lllllllllllllIllllllIIlllIIlllII[lllllllllllllIllllllIIlllIIllIll = (lllllllllllllIllllllIIlllIIllIll + 1 & Object2IntLinkedOpenHashMap.this.mask)]) != null) {
                if (lllllllllllllIllllllIIlllIIlllll.equals(lllllllllllllIllllllIIlllIIlllIl)) {
                    return Object2IntLinkedOpenHashMap.this.value[lllllllllllllIllllllIIlllIIllIll] == lllllllllllllIllllllIIlllIIllllI;
                }
            }
            return false;
        }
        
        @Override
        public void fastForEach(final Consumer<? super Object2IntMap.Entry<K>> lllllllllllllIllllllIIllIlIIlIIl) {
            final BasicEntry<K> lllllllllllllIllllllIIllIlIIlIll = new BasicEntry<K>();
            int lllllllllllllIllllllIIllIlIlIIII = Object2IntLinkedOpenHashMap.this.size;
            int lllllllllllllIllllllIIllIlIIlllI = Object2IntLinkedOpenHashMap.this.first;
            while (lllllllllllllIllllllIIllIlIlIIII-- != 0) {
                final int lllllllllllllIllllllIIllIlIIllll = lllllllllllllIllllllIIllIlIIlllI;
                lllllllllllllIllllllIIllIlIIlllI = (int)Object2IntLinkedOpenHashMap.this.link[lllllllllllllIllllllIIllIlIIllll];
                lllllllllllllIllllllIIllIlIIlIll.key = Object2IntLinkedOpenHashMap.this.key[lllllllllllllIllllllIIllIlIIllll];
                lllllllllllllIllllllIIllIlIIlIll.value = Object2IntLinkedOpenHashMap.this.value[lllllllllllllIllllllIIllIlIIllll];
                lllllllllllllIllllllIIllIlIIlIIl.accept(lllllllllllllIllllllIIllIlIIlIll);
            }
        }
        
        @Override
        public ObjectListIterator<Object2IntMap.Entry<K>> fastIterator(final Object2IntMap.Entry<K> lllllllllllllIllllllIIllIllIlIII) {
            return new FastEntryIterator(lllllllllllllIllllllIIllIllIlIII.getKey());
        }
    }
    
    private class EntryIterator extends MapIterator implements ObjectListIterator<Object2IntMap.Entry<K>>
    {
        private /* synthetic */ MapEntry entry;
        
        @Override
        public void remove() {
            super.remove();
            this.entry.index = -1;
        }
        
        @Override
        public MapEntry previous() {
            final MapEntry entry = new MapEntry(this.previousEntry());
            this.entry = entry;
            return entry;
        }
        
        public EntryIterator(final K lllllllllllllIIIIIIIlllIllIIIIlI) {
            super((Object)lllllllllllllIIIIIIIlllIllIIIIlI);
        }
        
        public EntryIterator() {
        }
        
        @Override
        public MapEntry next() {
            final MapEntry entry = new MapEntry(this.nextEntry());
            this.entry = entry;
            return entry;
        }
    }
    
    private final class KeySet extends AbstractObjectSortedSet<K>
    {
        @Override
        public ObjectSortedSet<K> subSet(final K llllllllllllllIllIIllIlIllIlIIIl, final K llllllllllllllIllIIllIlIllIlIIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public ObjectListIterator<K> iterator(final K llllllllllllllIllIIllIllIIIIIlII) {
            return new KeyIterator(llllllllllllllIllIIllIllIIIIIlII);
        }
        
        @Override
        public ObjectSortedSet<K> headSet(final K llllllllllllllIllIIllIlIllIlIIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
            Object2IntLinkedOpenHashMap.this.clear();
        }
        
        @Override
        public ObjectListIterator<K> iterator() {
            return new KeyIterator();
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return null;
        }
        
        @Override
        public K first() {
            if (Object2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Object2IntLinkedOpenHashMap.this.key[Object2IntLinkedOpenHashMap.this.first];
        }
        
        @Override
        public boolean contains(final Object llllllllllllllIllIIllIlIlllIllII) {
            return Object2IntLinkedOpenHashMap.this.containsKey(llllllllllllllIllIIllIlIlllIllII);
        }
        
        @Override
        public ObjectSortedSet<K> tailSet(final K llllllllllllllIllIIllIlIllIlIlIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void forEach(final Consumer<? super K> llllllllllllllIllIIllIlIllllIlll) {
            if (Object2IntLinkedOpenHashMap.this.containsNullKey) {
                llllllllllllllIllIIllIlIllllIlll.accept((Object)Object2IntLinkedOpenHashMap.this.key[Object2IntLinkedOpenHashMap.this.n]);
            }
            int llllllllllllllIllIIllIlIlllllIIl = Object2IntLinkedOpenHashMap.this.n;
            while (llllllllllllllIllIIllIlIlllllIIl-- != 0) {
                final K llllllllllllllIllIIllIlIlllllIlI = Object2IntLinkedOpenHashMap.this.key[llllllllllllllIllIIllIlIlllllIIl];
                if (llllllllllllllIllIIllIlIlllllIlI != null) {
                    llllllllllllllIllIIllIlIllllIlll.accept((Object)llllllllllllllIllIIllIlIlllllIlI);
                }
            }
        }
        
        @Override
        public boolean remove(final Object llllllllllllllIllIIllIlIlllIIIlI) {
            final int llllllllllllllIllIIllIlIlllIIlII = Object2IntLinkedOpenHashMap.this.size;
            Object2IntLinkedOpenHashMap.this.removeInt(llllllllllllllIllIIllIlIlllIIIlI);
            return Object2IntLinkedOpenHashMap.this.size != llllllllllllllIllIIllIlIlllIIlII;
        }
        
        @Override
        public int size() {
            return Object2IntLinkedOpenHashMap.this.size;
        }
        
        @Override
        public K last() {
            if (Object2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Object2IntLinkedOpenHashMap.this.key[Object2IntLinkedOpenHashMap.this.last];
        }
    }
}
