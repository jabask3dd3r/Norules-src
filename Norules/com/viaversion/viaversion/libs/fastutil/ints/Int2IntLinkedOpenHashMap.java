package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import java.util.*;

public class Int2IntLinkedOpenHashMap extends AbstractInt2IntSortedMap implements Hash, Cloneable, Serializable
{
    protected transient /* synthetic */ int first;
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ boolean containsNullKey;
    protected final /* synthetic */ float f;
    protected transient /* synthetic */ IntCollection values;
    protected transient /* synthetic */ int n;
    protected transient /* synthetic */ int mask;
    protected transient /* synthetic */ int last;
    protected transient /* synthetic */ int[] value;
    protected /* synthetic */ int size;
    protected transient /* synthetic */ IntSortedSet keys;
    protected transient /* synthetic */ Int2IntSortedMap.FastSortedEntrySet entries;
    protected transient /* synthetic */ int[] key;
    protected transient /* synthetic */ long[] link;
    protected final transient /* synthetic */ int minN;
    
    @Override
    public IntComparator comparator() {
        return null;
    }
    
    @Override
    public boolean containsKey(final int lllllllllllllIIIllllIIIllllIlIll) {
        if (lllllllllllllIIIllllIIIllllIlIll == 0) {
            return this.containsNullKey;
        }
        final int[] lllllllllllllIIIllllIIIllllIlIIl = this.key;
        int lllllllllllllIIIllllIIIllllIlIII;
        int lllllllllllllIIIllllIIIllllIlIlI;
        if ((lllllllllllllIIIllllIIIllllIlIlI = lllllllllllllIIIllllIIIllllIlIIl[lllllllllllllIIIllllIIIllllIlIII = (HashCommon.mix(lllllllllllllIIIllllIIIllllIlIll) & this.mask)]) == 0) {
            return false;
        }
        if (lllllllllllllIIIllllIIIllllIlIll == lllllllllllllIIIllllIIIllllIlIlI) {
            return true;
        }
        while ((lllllllllllllIIIllllIIIllllIlIlI = lllllllllllllIIIllllIIIllllIlIIl[lllllllllllllIIIllllIIIllllIlIII = (lllllllllllllIIIllllIIIllllIlIII + 1 & this.mask)]) != 0) {
            if (lllllllllllllIIIllllIIIllllIlIll == lllllllllllllIIIllllIIIllllIlIlI) {
                return true;
            }
        }
        return false;
    }
    
    private void moveIndexToFirst(final int lllllllllllllIIIllllIIlIIlIlIlll) {
        if (this.size == 1 || this.first == lllllllllllllIIIllllIIlIIlIlIlll) {
            return;
        }
        if (this.last == lllllllllllllIIIllllIIlIIlIlIlll) {
            this.last = (int)(this.link[lllllllllllllIIIllllIIlIIlIlIlll] >>> 32);
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        else {
            final long lllllllllllllIIIllllIIlIIlIlllIl = this.link[lllllllllllllIIIllllIIlIIlIlIlll];
            final int lllllllllllllIIIllllIIlIIlIlllII = (int)(lllllllllllllIIIllllIIlIIlIlllIl >>> 32);
            final int lllllllllllllIIIllllIIlIIlIllIll = (int)lllllllllllllIIIllllIIlIIlIlllIl;
            final long[] link2 = this.link;
            final int n = lllllllllllllIIIllllIIlIIlIlllII;
            link2[n] ^= ((this.link[lllllllllllllIIIllllIIlIIlIlllII] ^ (lllllllllllllIIIllllIIlIIlIlllIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = lllllllllllllIIIllllIIlIIlIllIll;
            link3[n2] ^= ((this.link[lllllllllllllIIIllllIIlIIlIllIll] ^ (lllllllllllllIIIllllIIlIIlIlllIl & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int first = this.first;
        link4[first] ^= ((this.link[this.first] ^ ((long)lllllllllllllIIIllllIIlIIlIlIlll & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[lllllllllllllIIIllllIIlIIlIlIlll] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
        this.first = lllllllllllllIIIllllIIlIIlIlIlll;
    }
    
    protected final void shiftKeys(int lllllllllllllIIIllllIIlIlIIlIlII) {
        final int[] lllllllllllllIIIllllIIlIlIIlIllI = this.key;
        int lllllllllllllIIIllllIIlIlIIllIIl = 0;
    Label_0006:
        while (true) {
            lllllllllllllIIIllllIIlIlIIlIlII = ((lllllllllllllIIIllllIIlIlIIllIIl = lllllllllllllIIIllllIIlIlIIlIlII) + 1 & this.mask);
            int lllllllllllllIIIllllIIlIlIIlIlll;
            while ((lllllllllllllIIIllllIIlIlIIlIlll = lllllllllllllIIIllllIIlIlIIlIllI[lllllllllllllIIIllllIIlIlIIlIlII]) != 0) {
                final int lllllllllllllIIIllllIIlIlIIllIII = HashCommon.mix(lllllllllllllIIIllllIIlIlIIlIlll) & this.mask;
                Label_0087: {
                    if (lllllllllllllIIIllllIIlIlIIllIIl <= lllllllllllllIIIllllIIlIlIIlIlII) {
                        if (lllllllllllllIIIllllIIlIlIIllIIl >= lllllllllllllIIIllllIIlIlIIllIII) {
                            break Label_0087;
                        }
                        if (lllllllllllllIIIllllIIlIlIIllIII > lllllllllllllIIIllllIIlIlIIlIlII) {
                            break Label_0087;
                        }
                    }
                    else if (lllllllllllllIIIllllIIlIlIIllIIl >= lllllllllllllIIIllllIIlIlIIllIII && lllllllllllllIIIllllIIlIlIIllIII > lllllllllllllIIIllllIIlIlIIlIlII) {
                        break Label_0087;
                    }
                    lllllllllllllIIIllllIIlIlIIlIlII = (lllllllllllllIIIllllIIlIlIIlIlII + 1 & this.mask);
                    continue;
                }
                lllllllllllllIIIllllIIlIlIIlIllI[lllllllllllllIIIllllIIlIlIIllIIl] = lllllllllllllIIIllllIIlIlIIlIlll;
                this.value[lllllllllllllIIIllllIIlIlIIllIIl] = this.value[lllllllllllllIIIllllIIlIlIIlIlII];
                this.fixPointers(lllllllllllllIIIllllIIlIlIIlIlII, lllllllllllllIIIllllIIlIlIIllIIl);
                continue Label_0006;
            }
            break;
        }
        lllllllllllllIIIllllIIlIlIIlIllI[lllllllllllllIIIllllIIlIlIIllIIl] = 0;
    }
    
    public Int2IntLinkedOpenHashMap(final int[] lllllllllllllIIIllllIIllIIlIIlIl, final int[] lllllllllllllIIIllllIIllIIlIIlII, final float lllllllllllllIIIllllIIllIIlIIIll) {
        this(lllllllllllllIIIllllIIllIIlIIlIl.length, lllllllllllllIIIllllIIllIIlIIIll);
        if (lllllllllllllIIIllllIIllIIlIIlIl.length != lllllllllllllIIIllllIIllIIlIIlII.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The key array and the value array have different lengths (").append(lllllllllllllIIIllllIIllIIlIIlIl.length).append(" and ").append(lllllllllllllIIIllllIIllIIlIIlII.length).append(")")));
        }
        for (int lllllllllllllIIIllllIIllIIlIIlll = 0; lllllllllllllIIIllllIIllIIlIIlll < lllllllllllllIIIllllIIllIIlIIlIl.length; ++lllllllllllllIIIllllIIllIIlIIlll) {
            this.put(lllllllllllllIIIllllIIllIIlIIlIl[lllllllllllllIIIllllIIllIIlIIlll], lllllllllllllIIIllllIIllIIlIIlII[lllllllllllllIIIllllIIllIIlIIlll]);
        }
    }
    
    private void insert(final int lllllllllllllIIIllllIIlIllIlIIlI, final int lllllllllllllIIIllllIIlIllIlIIIl, final int lllllllllllllIIIllllIIlIllIlIIII) {
        if (lllllllllllllIIIllllIIlIllIlIIlI == this.n) {
            this.containsNullKey = true;
        }
        this.key[lllllllllllllIIIllllIIlIllIlIIlI] = lllllllllllllIIIllllIIlIllIlIIIl;
        this.value[lllllllllllllIIIllllIIlIllIlIIlI] = lllllllllllllIIIllllIIlIllIlIIII;
        if (this.size == 0) {
            this.last = lllllllllllllIIIllllIIlIllIlIIlI;
            this.first = lllllllllllllIIIllllIIlIllIlIIlI;
            this.link[lllllllllllllIIIllllIIlIllIlIIlI] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIIllllIIlIllIlIIlI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIIllllIIlIllIlIIlI] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = lllllllllllllIIIllllIIlIllIlIIlI;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
    }
    
    @Override
    public Int2IntSortedMap subMap(final int lllllllllllllIIIllllIIIIllllllII, final int lllllllllllllIIIllllIIIIlllllIll) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public IntSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }
    
    @Override
    public int replace(final int lllllllllllllIIIllllIIIllIIIlllI, final int lllllllllllllIIIllllIIIllIIIllIl) {
        final int lllllllllllllIIIllllIIIllIIIllII = this.find(lllllllllllllIIIllllIIIllIIIlllI);
        if (lllllllllllllIIIllllIIIllIIIllII < 0) {
            return this.defRetValue;
        }
        final int lllllllllllllIIIllllIIIllIIIlIll = this.value[lllllllllllllIIIllllIIIllIIIllII];
        this.value[lllllllllllllIIIllllIIIllIIIllII] = lllllllllllllIIIllllIIIllIIIllIl;
        return lllllllllllllIIIllllIIIllIIIlIll;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    public Int2IntLinkedOpenHashMap(final int[] lllllllllllllIIIllllIIllIIIllIIl, final int[] lllllllllllllIIIllllIIllIIIllIII) {
        this(lllllllllllllIIIllllIIllIIIllIIl, lllllllllllllIIIllllIIllIIIllIII, 0.75f);
    }
    
    public Int2IntLinkedOpenHashMap(final Map<? extends Integer, ? extends Integer> lllllllllllllIIIllllIIllIlIIIllI, final float lllllllllllllIIIllllIIllIlIIIIlI) {
        this(lllllllllllllIIIllllIIllIlIIIllI.size(), lllllllllllllIIIllllIIllIlIIIIlI);
        this.putAll(lllllllllllllIIIllllIIllIlIIIllI);
    }
    
    public Int2IntLinkedOpenHashMap() {
        this(16, 0.75f);
    }
    
    public Int2IntLinkedOpenHashMap(final Int2IntMap lllllllllllllIIIllllIIllIIllIlII, final float lllllllllllllIIIllllIIllIIllIllI) {
        this(lllllllllllllIIIllllIIllIIllIlII.size(), lllllllllllllIIIllllIIllIIllIllI);
        this.putAll(lllllllllllllIIIllllIIllIIllIlII);
    }
    
    @Override
    public int putIfAbsent(final int lllllllllllllIIIllllIIIllIlllIII, final int lllllllllllllIIIllllIIIllIllIlll) {
        final int lllllllllllllIIIllllIIIllIlllIlI = this.find(lllllllllllllIIIllllIIIllIlllIII);
        if (lllllllllllllIIIllllIIIllIlllIlI >= 0) {
            return this.value[lllllllllllllIIIllllIIIllIlllIlI];
        }
        this.insert(-lllllllllllllIIIllllIIIllIlllIlI - 1, lllllllllllllIIIllllIIIllIlllIII, lllllllllllllIIIllllIIIllIllIlll);
        return this.defRetValue;
    }
    
    public Int2IntLinkedOpenHashMap(final Int2IntMap lllllllllllllIIIllllIIllIIlIllll) {
        this(lllllllllllllIIIllllIIllIIlIllll, 0.75f);
    }
    
    @Override
    public int put(final int lllllllllllllIIIllllIIlIllIIlIIl, final int lllllllllllllIIIllllIIlIllIIIIll) {
        final int lllllllllllllIIIllllIIlIllIIIlll = this.find(lllllllllllllIIIllllIIlIllIIlIIl);
        if (lllllllllllllIIIllllIIlIllIIIlll < 0) {
            this.insert(-lllllllllllllIIIllllIIlIllIIIlll - 1, lllllllllllllIIIllllIIlIllIIlIIl, lllllllllllllIIIllllIIlIllIIIIll);
            return this.defRetValue;
        }
        final int lllllllllllllIIIllllIIlIllIIIllI = this.value[lllllllllllllIIIllllIIlIllIIIlll];
        this.value[lllllllllllllIIIllllIIlIllIIIlll] = lllllllllllllIIIllllIIlIllIIIIll;
        return lllllllllllllIIIllllIIlIllIIIllI;
    }
    
    @Override
    public int lastIntKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.last];
    }
    
    public Int2IntLinkedOpenHashMap(final Map<? extends Integer, ? extends Integer> lllllllllllllIIIllllIIllIIllllII) {
        this(lllllllllllllIIIllllIIllIIllllII, 0.75f);
    }
    
    @Override
    public int firstIntKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.first];
    }
    
    public boolean trim(final int lllllllllllllIIIllllIIIIlllIIlll) {
        final int lllllllllllllIIIllllIIIIlllIIllI = HashCommon.nextPowerOfTwo((int)Math.ceil(lllllllllllllIIIllllIIIIlllIIlll / this.f));
        if (lllllllllllllIIIllllIIIIlllIIllI >= this.n || this.size > HashCommon.maxFill(lllllllllllllIIIllllIIIIlllIIllI, this.f)) {
            return true;
        }
        try {
            this.rehash(lllllllllllllIIIllllIIIIlllIIllI);
        }
        catch (OutOfMemoryError lllllllllllllIIIllllIIIIlllIlIIl) {
            return false;
        }
        return true;
    }
    
    @Override
    public Int2IntSortedMap headMap(final int lllllllllllllIIIllllIIIIlllllllI) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public int get(final int lllllllllllllIIIllllIIIllllllIlI) {
        if (lllllllllllllIIIllllIIIllllllIlI == 0) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        }
        final int[] lllllllllllllIIIllllIIIllllllIII = this.key;
        int lllllllllllllIIIllllIIIlllllIlll;
        int lllllllllllllIIIllllIIIllllllIIl;
        if ((lllllllllllllIIIllllIIIllllllIIl = lllllllllllllIIIllllIIIllllllIII[lllllllllllllIIIllllIIIlllllIlll = (HashCommon.mix(lllllllllllllIIIllllIIIllllllIlI) & this.mask)]) == 0) {
            return this.defRetValue;
        }
        if (lllllllllllllIIIllllIIIllllllIlI == lllllllllllllIIIllllIIIllllllIIl) {
            return this.value[lllllllllllllIIIllllIIIlllllIlll];
        }
        while ((lllllllllllllIIIllllIIIllllllIIl = lllllllllllllIIIllllIIIllllllIII[lllllllllllllIIIllllIIIlllllIlll = (lllllllllllllIIIllllIIIlllllIlll + 1 & this.mask)]) != 0) {
            if (lllllllllllllIIIllllIIIllllllIlI == lllllllllllllIIIllllIIIllllllIIl) {
                return this.value[lllllllllllllIIIllllIIIlllllIlll];
            }
        }
        return this.defRetValue;
    }
    
    private int realSize() {
        return this.containsNullKey ? (this.size - 1) : this.size;
    }
    
    public int getAndMoveToLast(final int lllllllllllllIIIllllIIlIIIlIlIlI) {
        if (lllllllllllllIIIllllIIlIIIlIlIlI == 0) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        else {
            final int[] lllllllllllllIIIllllIIlIIIlIllIl = this.key;
            int lllllllllllllIIIllllIIlIIIlIllII;
            int lllllllllllllIIIllllIIlIIIlIlllI;
            if ((lllllllllllllIIIllllIIlIIIlIlllI = lllllllllllllIIIllllIIlIIIlIllIl[lllllllllllllIIIllllIIlIIIlIllII = (HashCommon.mix(lllllllllllllIIIllllIIlIIIlIlIlI) & this.mask)]) == 0) {
                return this.defRetValue;
            }
            if (lllllllllllllIIIllllIIlIIIlIlIlI == lllllllllllllIIIllllIIlIIIlIlllI) {
                this.moveIndexToLast(lllllllllllllIIIllllIIlIIIlIllII);
                return this.value[lllllllllllllIIIllllIIlIIIlIllII];
            }
            while ((lllllllllllllIIIllllIIlIIIlIlllI = lllllllllllllIIIllllIIlIIIlIllIl[lllllllllllllIIIllllIIlIIIlIllII = (lllllllllllllIIIllllIIlIIIlIllII + 1 & this.mask)]) != 0) {
                if (lllllllllllllIIIllllIIlIIIlIlIlI == lllllllllllllIIIllllIIlIIIlIlllI) {
                    this.moveIndexToLast(lllllllllllllIIIllllIIlIIIlIllII);
                    return this.value[lllllllllllllIIIllllIIlIIIlIllII];
                }
            }
            return this.defRetValue;
        }
    }
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNullKey = false;
        Arrays.fill(this.key, 0);
        final int n = -1;
        this.last = n;
        this.first = n;
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    @Override
    public Int2IntSortedMap tailMap(final int lllllllllllllIIIllllIIIlIIIIIIII) {
        throw new UnsupportedOperationException();
    }
    
    private void checkTable() {
    }
    
    protected void fixPointers(final int lllllllllllllIIIllllIIIlIIlIIIlI) {
        if (this.size == 0) {
            final int n = -1;
            this.last = n;
            this.first = n;
            return;
        }
        if (this.first == lllllllllllllIIIllllIIIlIIlIIIlI) {
            this.first = (int)this.link[lllllllllllllIIIllllIIIlIIlIIIlI];
            if (0 <= this.first) {
                final long[] link = this.link;
                final int first = this.first;
                link[first] |= 0xFFFFFFFF00000000L;
            }
            return;
        }
        if (this.last == lllllllllllllIIIllllIIIlIIlIIIlI) {
            this.last = (int)(this.link[lllllllllllllIIIllllIIIlIIlIIIlI] >>> 32);
            if (0 <= this.last) {
                final long[] link2 = this.link;
                final int last = this.last;
                link2[last] |= 0xFFFFFFFFL;
            }
            return;
        }
        final long lllllllllllllIIIllllIIIlIIlIIIIl = this.link[lllllllllllllIIIllllIIIlIIlIIIlI];
        final int lllllllllllllIIIllllIIIlIIlIIIII = (int)(lllllllllllllIIIllllIIIlIIlIIIIl >>> 32);
        final int lllllllllllllIIIllllIIIlIIIlllll = (int)lllllllllllllIIIllllIIIlIIlIIIIl;
        final long[] link3 = this.link;
        final int n2 = lllllllllllllIIIllllIIIlIIlIIIII;
        link3[n2] ^= ((this.link[lllllllllllllIIIllllIIIlIIlIIIII] ^ (lllllllllllllIIIllllIIIlIIlIIIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n3 = lllllllllllllIIIllllIIIlIIIlllll;
        link4[n3] ^= ((this.link[lllllllllllllIIIllllIIIlIIIlllll] ^ (lllllllllllllIIIllllIIIlIIlIIIIl & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
    }
    
    private int addToValue(final int lllllllllllllIIIllllIIlIlIlllIll, final int lllllllllllllIIIllllIIlIlIlllIlI) {
        final int lllllllllllllIIIllllIIlIlIlllIIl = this.value[lllllllllllllIIIllllIIlIlIlllIll];
        this.value[lllllllllllllIIIllllIIlIlIlllIll] = lllllllllllllIIIllllIIlIlIlllIIl + lllllllllllllIIIllllIIlIlIlllIlI;
        return lllllllllllllIIIllllIIlIlIlllIIl;
    }
    
    private int find(final int lllllllllllllIIIllllIIlIllIlllll) {
        if (lllllllllllllIIIllllIIlIllIlllll == 0) {
            return this.containsNullKey ? this.n : (-(this.n + 1));
        }
        final int[] lllllllllllllIIIllllIIlIlllIIIlI = this.key;
        int lllllllllllllIIIllllIIlIlllIIIIl;
        int lllllllllllllIIIllllIIlIlllIIIll;
        if ((lllllllllllllIIIllllIIlIlllIIIll = lllllllllllllIIIllllIIlIlllIIIlI[lllllllllllllIIIllllIIlIlllIIIIl = (HashCommon.mix(lllllllllllllIIIllllIIlIllIlllll) & this.mask)]) == 0) {
            return -(lllllllllllllIIIllllIIlIlllIIIIl + 1);
        }
        if (lllllllllllllIIIllllIIlIllIlllll == lllllllllllllIIIllllIIlIlllIIIll) {
            return lllllllllllllIIIllllIIlIlllIIIIl;
        }
        while ((lllllllllllllIIIllllIIlIlllIIIll = lllllllllllllIIIllllIIlIlllIIIlI[lllllllllllllIIIllllIIlIlllIIIIl = (lllllllllllllIIIllllIIlIlllIIIIl + 1 & this.mask)]) != 0) {
            if (lllllllllllllIIIllllIIlIllIlllll == lllllllllllllIIIllllIIlIlllIIIll) {
                return lllllllllllllIIIllllIIlIlllIIIIl;
            }
        }
        return -(lllllllllllllIIIllllIIlIlllIIIIl + 1);
    }
    
    private void tryCapacity(final long lllllllllllllIIIllllIIllIIIIIIIl) {
        final int lllllllllllllIIIllllIIllIIIIIIll = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(lllllllllllllIIIllllIIllIIIIIIIl / this.f))));
        if (lllllllllllllIIIllllIIllIIIIIIll > this.n) {
            this.rehash(lllllllllllllIIIllllIIllIIIIIIll);
        }
    }
    
    @Override
    public int computeIfPresent(final int lllllllllllllIIIllllIIIlIlIllllI, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIIIllllIIIlIlIlllIl) {
        Objects.requireNonNull(lllllllllllllIIIllllIIIlIlIlllIl);
        final int lllllllllllllIIIllllIIIlIlIlllII = this.find(lllllllllllllIIIllllIIIlIlIllllI);
        if (lllllllllllllIIIllllIIIlIlIlllII < 0) {
            return this.defRetValue;
        }
        final Integer lllllllllllllIIIllllIIIlIlIllIll = (Integer)lllllllllllllIIIllllIIIlIlIlllIl.apply(lllllllllllllIIIllllIIIlIlIllllI, this.value[lllllllllllllIIIllllIIIlIlIlllII]);
        if (lllllllllllllIIIllllIIIlIlIllIll == null) {
            if (lllllllllllllIIIllllIIIlIlIllllI == 0) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(lllllllllllllIIIllllIIIlIlIlllII);
            }
            return this.defRetValue;
        }
        return this.value[lllllllllllllIIIllllIIIlIlIlllII] = lllllllllllllIIIllllIIIlIlIllIll;
    }
    
    public Int2IntLinkedOpenHashMap(final int lllllllllllllIIIllllIIllIlIlIIII) {
        this(lllllllllllllIIIllllIIllIlIlIIII, 0.75f);
    }
    
    @Override
    public boolean remove(final int lllllllllllllIIIllllIIIllIlIlllI, final int lllllllllllllIIIllllIIIllIlIllIl) {
        if (lllllllllllllIIIllllIIIllIlIlllI == 0) {
            if (this.containsNullKey && lllllllllllllIIIllllIIIllIlIllIl == this.value[this.n]) {
                this.removeNullEntry();
                return true;
            }
            return false;
        }
        else {
            final int[] lllllllllllllIIIllllIIIllIlIlIll = this.key;
            int lllllllllllllIIIllllIIIllIlIlIlI;
            int lllllllllllllIIIllllIIIllIlIllII;
            if ((lllllllllllllIIIllllIIIllIlIllII = lllllllllllllIIIllllIIIllIlIlIll[lllllllllllllIIIllllIIIllIlIlIlI = (HashCommon.mix(lllllllllllllIIIllllIIIllIlIlllI) & this.mask)]) == 0) {
                return false;
            }
            if (lllllllllllllIIIllllIIIllIlIlllI == lllllllllllllIIIllllIIIllIlIllII && lllllllllllllIIIllllIIIllIlIllIl == this.value[lllllllllllllIIIllllIIIllIlIlIlI]) {
                this.removeEntry(lllllllllllllIIIllllIIIllIlIlIlI);
                return true;
            }
            while ((lllllllllllllIIIllllIIIllIlIllII = lllllllllllllIIIllllIIIllIlIlIll[lllllllllllllIIIllllIIIllIlIlIlI = (lllllllllllllIIIllllIIIllIlIlIlI + 1 & this.mask)]) != 0) {
                if (lllllllllllllIIIllllIIIllIlIlllI == lllllllllllllIIIllllIIIllIlIllII && lllllllllllllIIIllllIIIllIlIllIl == this.value[lllllllllllllIIIllllIIIllIlIlIlI]) {
                    this.removeEntry(lllllllllllllIIIllllIIIllIlIlIlI);
                    return true;
                }
            }
            return false;
        }
    }
    
    static {
        ASSERTS = false;
    }
    
    public int removeLastInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int lllllllllllllIIIllllIIlIIllIIlll = this.last;
        this.last = (int)(this.link[lllllllllllllIIIllllIIlIIllIIlll] >>> 32);
        if (0 <= this.last) {
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        --this.size;
        final int lllllllllllllIIIllllIIlIIllIIllI = this.value[lllllllllllllIIIllllIIlIIllIIlll];
        if (lllllllllllllIIIllllIIlIIllIIlll == this.n) {
            this.containsNullKey = false;
        }
        else {
            this.shiftKeys(lllllllllllllIIIllllIIlIIllIIlll);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIIllllIIlIIllIIllI;
    }
    
    @Override
    public int merge(final int lllllllllllllIIIllllIIIlIIllllII, final int lllllllllllllIIIllllIIIlIIlllIll, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIIIllllIIIlIIllIlII) {
        Objects.requireNonNull(lllllllllllllIIIllllIIIlIIllIlII);
        final int lllllllllllllIIIllllIIIlIIlllIIl = this.find(lllllllllllllIIIllllIIIlIIllllII);
        if (lllllllllllllIIIllllIIIlIIlllIIl < 0) {
            this.insert(-lllllllllllllIIIllllIIIlIIlllIIl - 1, lllllllllllllIIIllllIIIlIIllllII, lllllllllllllIIIllllIIIlIIlllIll);
            return lllllllllllllIIIllllIIIlIIlllIll;
        }
        final Integer lllllllllllllIIIllllIIIlIIlllIII = (Integer)lllllllllllllIIIllllIIIlIIllIlII.apply(this.value[lllllllllllllIIIllllIIIlIIlllIIl], lllllllllllllIIIllllIIIlIIlllIll);
        if (lllllllllllllIIIllllIIIlIIlllIII == null) {
            if (lllllllllllllIIIllllIIIlIIllllII == 0) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(lllllllllllllIIIllllIIIlIIlllIIl);
            }
            return this.defRetValue;
        }
        return this.value[lllllllllllllIIIllllIIIlIIlllIIl] = lllllllllllllIIIllllIIIlIIlllIII;
    }
    
    public int putAndMoveToFirst(final int lllllllllllllIIIllllIIlIIIIlllII, final int lllllllllllllIIIllllIIlIIIIllIll) {
        int lllllllllllllIIIllllIIlIIIIllIlI = 0;
        if (lllllllllllllIIIllllIIlIIIIlllII == 0) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.setValue(this.n, lllllllllllllIIIllllIIlIIIIllIll);
            }
            this.containsNullKey = true;
            final int lllllllllllllIIIllllIIlIIIlIIIII = this.n;
        }
        else {
            final int[] lllllllllllllIIIllllIIlIIIIllllI = this.key;
            int lllllllllllllIIIllllIIlIIIIlllll;
            if ((lllllllllllllIIIllllIIlIIIIlllll = lllllllllllllIIIllllIIlIIIIllllI[lllllllllllllIIIllllIIlIIIIllIlI = (HashCommon.mix(lllllllllllllIIIllllIIlIIIIlllII) & this.mask)]) != 0) {
                if (lllllllllllllIIIllllIIlIIIIlllll == lllllllllllllIIIllllIIlIIIIlllII) {
                    this.moveIndexToFirst(lllllllllllllIIIllllIIlIIIIllIlI);
                    return this.setValue(lllllllllllllIIIllllIIlIIIIllIlI, lllllllllllllIIIllllIIlIIIIllIll);
                }
                while ((lllllllllllllIIIllllIIlIIIIlllll = lllllllllllllIIIllllIIlIIIIllllI[lllllllllllllIIIllllIIlIIIIllIlI = (lllllllllllllIIIllllIIlIIIIllIlI + 1 & this.mask)]) != 0) {
                    if (lllllllllllllIIIllllIIlIIIIlllll == lllllllllllllIIIllllIIlIIIIlllII) {
                        this.moveIndexToFirst(lllllllllllllIIIllllIIlIIIIllIlI);
                        return this.setValue(lllllllllllllIIIllllIIlIIIIllIlI, lllllllllllllIIIllllIIlIIIIllIll);
                    }
                }
            }
        }
        this.key[lllllllllllllIIIllllIIlIIIIllIlI] = lllllllllllllIIIllllIIlIIIIlllII;
        this.value[lllllllllllllIIIllllIIlIIIIllIlI] = lllllllllllllIIIllllIIlIIIIllIll;
        if (this.size == 0) {
            final int n = lllllllllllllIIIllllIIlIIIIllIlI;
            this.last = n;
            this.first = n;
            this.link[lllllllllllllIIIllllIIlIIIIllIlI] = -1L;
        }
        else {
            final long[] link = this.link;
            final int first = this.first;
            link[first] ^= ((this.link[this.first] ^ ((long)lllllllllllllIIIllllIIlIIIIllIlI & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[lllllllllllllIIIllllIIlIIIIllIlI] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
            this.first = lllllllllllllIIIllllIIlIIIIllIlI;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }
    
    private void moveIndexToLast(final int lllllllllllllIIIllllIIlIIlIIlIII) {
        if (this.size == 1 || this.last == lllllllllllllIIIllllIIlIIlIIlIII) {
            return;
        }
        if (this.first == lllllllllllllIIIllllIIlIIlIIlIII) {
            this.first = (int)this.link[lllllllllllllIIIllllIIlIIlIIlIII];
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        else {
            final long lllllllllllllIIIllllIIlIIlIIlllI = this.link[lllllllllllllIIIllllIIlIIlIIlIII];
            final int lllllllllllllIIIllllIIlIIlIIllIl = (int)(lllllllllllllIIIllllIIlIIlIIlllI >>> 32);
            final int lllllllllllllIIIllllIIlIIlIIllII = (int)lllllllllllllIIIllllIIlIIlIIlllI;
            final long[] link2 = this.link;
            final int n = lllllllllllllIIIllllIIlIIlIIllIl;
            link2[n] ^= ((this.link[lllllllllllllIIIllllIIlIIlIIllIl] ^ (lllllllllllllIIIllllIIlIIlIIlllI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = lllllllllllllIIIllllIIlIIlIIllII;
            link3[n2] ^= ((this.link[lllllllllllllIIIllllIIlIIlIIllII] ^ (lllllllllllllIIIllllIIlIIlIIlllI & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int last = this.last;
        link4[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIIllllIIlIIlIIlIII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        this.link[lllllllllllllIIIllllIIlIIlIIlIII] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
        this.last = lllllllllllllIIIllllIIlIIlIIlIII;
    }
    
    @Override
    public boolean replace(final int lllllllllllllIIIllllIIIllIIlllIl, final int lllllllllllllIIIllllIIIllIIlllII, final int lllllllllllllIIIllllIIIllIIllIll) {
        final int lllllllllllllIIIllllIIIllIIllIlI = this.find(lllllllllllllIIIllllIIIllIIlllIl);
        if (lllllllllllllIIIllllIIIllIIllIlI < 0 || lllllllllllllIIIllllIIIllIIlllII != this.value[lllllllllllllIIIllllIIIllIIllIlI]) {
            return false;
        }
        this.value[lllllllllllllIIIllllIIIllIIllIlI] = lllllllllllllIIIllllIIIllIIllIll;
        return true;
    }
    
    public Int2IntLinkedOpenHashMap clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap;
        //     7: astore_1        /* lllllllllllllIIIllllIIIIlIllIIII */
        //     8: goto            20
        //    11: astore_2        /* lllllllllllllIIIllllIIIIlIlIllll */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllllIIIllllIIIIlIlIllIl */
        //    21: aconst_null    
        //    22: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.keys:Lcom/viaversion/viaversion/libs/fastutil/ints/IntSortedSet;
        //    25: aload_1         /* lllllllllllllIIIllllIIIIlIlIllIl */
        //    26: aconst_null    
        //    27: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.values:Lcom/viaversion/viaversion/libs/fastutil/ints/IntCollection;
        //    30: aload_1         /* lllllllllllllIIIllllIIIIlIlIllIl */
        //    31: aconst_null    
        //    32: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.entries:Lcom/viaversion/viaversion/libs/fastutil/ints/Int2IntSortedMap$FastSortedEntrySet;
        //    35: aload_1         /* lllllllllllllIIIllllIIIIlIlIllIl */
        //    36: aload_0         /* lllllllllllllIIIllllIIIIlIlIlllI */
        //    37: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.containsNullKey:Z
        //    40: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.containsNullKey:Z
        //    43: aload_1         /* lllllllllllllIIIllllIIIIlIlIllIl */
        //    44: aload_0         /* lllllllllllllIIIllllIIIIlIlIlllI */
        //    45: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.key:[I
        //    48: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    51: checkcast       [I
        //    54: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.key:[I
        //    57: aload_1         /* lllllllllllllIIIllllIIIIlIlIllIl */
        //    58: aload_0         /* lllllllllllllIIIllllIIIIlIlIlllI */
        //    59: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.value:[I
        //    62: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    65: checkcast       [I
        //    68: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.value:[I
        //    71: aload_1         /* lllllllllllllIIIllllIIIIlIlIllIl */
        //    72: aload_0         /* lllllllllllllIIIllllIIIIlIlIlllI */
        //    73: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.link:[J
        //    76: invokevirtual   [J.clone:()Ljava/lang/Object;
        //    79: checkcast       [J
        //    82: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntLinkedOpenHashMap.link:[J
        //    85: aload_1         /* lllllllllllllIIIllllIIIIlIlIllIl */
        //    86: areturn        
        //    StackMapTable: 00 02 4B 07 01 63 FC 00 08 07 00 02
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
    
    protected void rehash(final int lllllllllllllIIIllllIIIIllIIllIl) {
        final int[] lllllllllllllIIIllllIIIIllIIllII = this.key;
        final int[] lllllllllllllIIIllllIIIIllIIlIll = this.value;
        final int lllllllllllllIIIllllIIIIllIIlIlI = lllllllllllllIIIllllIIIIllIIllIl - 1;
        final int[] lllllllllllllIIIllllIIIIllIIlIIl = new int[lllllllllllllIIIllllIIIIllIIllIl + 1];
        final int[] lllllllllllllIIIllllIIIIllIIlIII = new int[lllllllllllllIIIllllIIIIllIIllIl + 1];
        int lllllllllllllIIIllllIIIIllIIIlll = this.first;
        int lllllllllllllIIIllllIIIIllIIIllI = -1;
        int lllllllllllllIIIllllIIIIllIIIlIl = -1;
        final long[] lllllllllllllIIIllllIIIIllIIIlII = this.link;
        final long[] lllllllllllllIIIllllIIIIllIIIIll = new long[lllllllllllllIIIllllIIIIllIIllIl + 1];
        this.first = -1;
        int lllllllllllllIIIllllIIIIllIIllll = this.size;
        while (lllllllllllllIIIllllIIIIllIIllll-- != 0) {
            int lllllllllllllIIIllllIIIIllIlIIII = 0;
            if (lllllllllllllIIIllllIIIIllIIllII[lllllllllllllIIIllllIIIIllIIIlll] == 0) {
                final int lllllllllllllIIIllllIIIIllIlIIlI = lllllllllllllIIIllllIIIIllIIllIl;
            }
            else {
                for (lllllllllllllIIIllllIIIIllIlIIII = (HashCommon.mix(lllllllllllllIIIllllIIIIllIIllII[lllllllllllllIIIllllIIIIllIIIlll]) & lllllllllllllIIIllllIIIIllIIlIlI); lllllllllllllIIIllllIIIIllIIlIIl[lllllllllllllIIIllllIIIIllIlIIII] != 0; lllllllllllllIIIllllIIIIllIlIIII = (lllllllllllllIIIllllIIIIllIlIIII + 1 & lllllllllllllIIIllllIIIIllIIlIlI)) {}
            }
            lllllllllllllIIIllllIIIIllIIlIIl[lllllllllllllIIIllllIIIIllIlIIII] = lllllllllllllIIIllllIIIIllIIllII[lllllllllllllIIIllllIIIIllIIIlll];
            lllllllllllllIIIllllIIIIllIIlIII[lllllllllllllIIIllllIIIIllIlIIII] = lllllllllllllIIIllllIIIIllIIlIll[lllllllllllllIIIllllIIIIllIIIlll];
            if (lllllllllllllIIIllllIIIIllIIIllI != -1) {
                final long[] array = lllllllllllllIIIllllIIIIllIIIIll;
                final int n = lllllllllllllIIIllllIIIIllIIIlIl;
                array[n] ^= ((lllllllllllllIIIllllIIIIllIIIIll[lllllllllllllIIIllllIIIIllIIIlIl] ^ ((long)lllllllllllllIIIllllIIIIllIlIIII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = lllllllllllllIIIllllIIIIllIIIIll;
                final int n2 = lllllllllllllIIIllllIIIIllIlIIII;
                array2[n2] ^= ((lllllllllllllIIIllllIIIIllIIIIll[lllllllllllllIIIllllIIIIllIlIIII] ^ ((long)lllllllllllllIIIllllIIIIllIIIlIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                lllllllllllllIIIllllIIIIllIIIlIl = lllllllllllllIIIllllIIIIllIlIIII;
            }
            else {
                final int first = lllllllllllllIIIllllIIIIllIlIIII;
                this.first = first;
                lllllllllllllIIIllllIIIIllIIIlIl = first;
                lllllllllllllIIIllllIIIIllIIIIll[lllllllllllllIIIllllIIIIllIlIIII] = -1L;
            }
            final int lllllllllllllIIIllllIIIIllIlIIIl = lllllllllllllIIIllllIIIIllIIIlll;
            lllllllllllllIIIllllIIIIllIIIlll = (int)lllllllllllllIIIllllIIIIllIIIlII[lllllllllllllIIIllllIIIIllIIIlll];
            lllllllllllllIIIllllIIIIllIIIllI = lllllllllllllIIIllllIIIIllIlIIIl;
        }
        this.link = lllllllllllllIIIllllIIIIllIIIIll;
        if ((this.last = lllllllllllllIIIllllIIIIllIIIlIl) != -1) {
            final long[] array3 = lllllllllllllIIIllllIIIIllIIIIll;
            final int n3 = lllllllllllllIIIllllIIIIllIIIlIl;
            array3[n3] |= 0xFFFFFFFFL;
        }
        this.n = lllllllllllllIIIllllIIIIllIIllIl;
        this.mask = lllllllllllllIIIllllIIIIllIIlIlI;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = lllllllllllllIIIllllIIIIllIIlIIl;
        this.value = lllllllllllllIIIllllIIIIllIIlIII;
    }
    
    @Override
    public int computeIfAbsent(final int lllllllllllllIIIllllIIIlIllllIlI, final IntUnaryOperator lllllllllllllIIIllllIIIlIllllllI) {
        Objects.requireNonNull(lllllllllllllIIIllllIIIlIllllllI);
        final int lllllllllllllIIIllllIIIlIlllllIl = this.find(lllllllllllllIIIllllIIIlIllllIlI);
        if (lllllllllllllIIIllllIIIlIlllllIl >= 0) {
            return this.value[lllllllllllllIIIllllIIIlIlllllIl];
        }
        final int lllllllllllllIIIllllIIIlIlllllII = lllllllllllllIIIllllIIIlIllllllI.applyAsInt(lllllllllllllIIIllllIIIlIllllIlI);
        this.insert(-lllllllllllllIIIllllIIIlIlllllIl - 1, lllllllllllllIIIllllIIIlIllllIlI, lllllllllllllIIIllllIIIlIlllllII);
        return lllllllllllllIIIllllIIIlIlllllII;
    }
    
    private int removeEntry(final int lllllllllllllIIIllllIIlIlllllIII) {
        final int lllllllllllllIIIllllIIlIlllllIlI = this.value[lllllllllllllIIIllllIIlIlllllIII];
        --this.size;
        this.fixPointers(lllllllllllllIIIllllIIlIlllllIII);
        this.shiftKeys(lllllllllllllIIIllllIIlIlllllIII);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIIllllIIlIlllllIlI;
    }
    
    private int setValue(final int lllllllllllllIIIllllIIlIIllllIll, final int lllllllllllllIIIllllIIlIIlllIllI) {
        final int lllllllllllllIIIllllIIlIIllllIIl = this.value[lllllllllllllIIIllllIIlIIllllIll];
        this.value[lllllllllllllIIIllllIIlIIllllIll] = lllllllllllllIIIllllIIlIIlllIllI;
        return lllllllllllllIIIllllIIlIIllllIIl;
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllIIIllllIIIIlIIlIIII) throws IOException {
        final int[] lllllllllllllIIIllllIIIIlIIIllll = this.key;
        final int[] lllllllllllllIIIllllIIIIlIIIlllI = this.value;
        final MapIterator lllllllllllllIIIllllIIIIlIIIllIl = new MapIterator();
        lllllllllllllIIIllllIIIIlIIlIIII.defaultWriteObject();
        int lllllllllllllIIIllllIIIIlIIlIIll = this.size;
        while (lllllllllllllIIIllllIIIIlIIlIIll-- != 0) {
            final int lllllllllllllIIIllllIIIIlIIlIIlI = lllllllllllllIIIllllIIIIlIIIllIl.nextEntry();
            lllllllllllllIIIllllIIIIlIIlIIII.writeInt(lllllllllllllIIIllllIIIIlIIIllll[lllllllllllllIIIllllIIIIlIIlIIlI]);
            lllllllllllllIIIllllIIIIlIIlIIII.writeInt(lllllllllllllIIIllllIIIIlIIIlllI[lllllllllllllIIIllllIIIIlIIlIIlI]);
        }
    }
    
    @Override
    public void putAll(final Map<? extends Integer, ? extends Integer> lllllllllllllIIIllllIIlIlllIllIl) {
        if (this.f <= 0.5) {
            this.ensureCapacity(lllllllllllllIIIllllIIlIlllIllIl.size());
        }
        else {
            this.tryCapacity(this.size() + lllllllllllllIIIllllIIlIlllIllIl.size());
        }
        super.putAll(lllllllllllllIIIllllIIlIlllIllIl);
    }
    
    private void readObject(final ObjectInputStream lllllllllllllIIIllllIIIIIllIllll) throws ClassNotFoundException, IOException {
        lllllllllllllIIIllllIIIIIllIllll.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final int[] key = new int[this.n + 1];
        this.key = key;
        final int[] lllllllllllllIIIllllIIIIIlllIlII = key;
        final int[] value = new int[this.n + 1];
        this.value = value;
        final int[] lllllllllllllIIIllllIIIIIlllIIll = value;
        final long[] link = new long[this.n + 1];
        this.link = link;
        final long[] lllllllllllllIIIllllIIIIIlllIIlI = link;
        int lllllllllllllIIIllllIIIIIlllIIIl = -1;
        final int n = -1;
        this.last = n;
        this.first = n;
        int lllllllllllllIIIllllIIIIIllllIII = this.size;
        while (lllllllllllllIIIllllIIIIIllllIII-- != 0) {
            final int lllllllllllllIIIllllIIIIIllllIlI = lllllllllllllIIIllllIIIIIllIllll.readInt();
            final int lllllllllllllIIIllllIIIIIllllIIl = lllllllllllllIIIllllIIIIIllIllll.readInt();
            int lllllllllllllIIIllllIIIIIlllIlll = 0;
            if (lllllllllllllIIIllllIIIIIllllIlI == 0) {
                final int lllllllllllllIIIllllIIIIIllllIll = this.n;
                this.containsNullKey = true;
            }
            else {
                for (lllllllllllllIIIllllIIIIIlllIlll = (HashCommon.mix(lllllllllllllIIIllllIIIIIllllIlI) & this.mask); lllllllllllllIIIllllIIIIIlllIlII[lllllllllllllIIIllllIIIIIlllIlll] != 0; lllllllllllllIIIllllIIIIIlllIlll = (lllllllllllllIIIllllIIIIIlllIlll + 1 & this.mask)) {}
            }
            lllllllllllllIIIllllIIIIIlllIlII[lllllllllllllIIIllllIIIIIlllIlll] = lllllllllllllIIIllllIIIIIllllIlI;
            lllllllllllllIIIllllIIIIIlllIIll[lllllllllllllIIIllllIIIIIlllIlll] = lllllllllllllIIIllllIIIIIllllIIl;
            if (this.first != -1) {
                final long[] array = lllllllllllllIIIllllIIIIIlllIIlI;
                final int n2 = lllllllllllllIIIllllIIIIIlllIIIl;
                array[n2] ^= ((lllllllllllllIIIllllIIIIIlllIIlI[lllllllllllllIIIllllIIIIIlllIIIl] ^ ((long)lllllllllllllIIIllllIIIIIlllIlll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = lllllllllllllIIIllllIIIIIlllIIlI;
                final int n3 = lllllllllllllIIIllllIIIIIlllIlll;
                array2[n3] ^= ((lllllllllllllIIIllllIIIIIlllIIlI[lllllllllllllIIIllllIIIIIlllIlll] ^ ((long)lllllllllllllIIIllllIIIIIlllIIIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                lllllllllllllIIIllllIIIIIlllIIIl = lllllllllllllIIIllllIIIIIlllIlll;
            }
            else {
                final int first = lllllllllllllIIIllllIIIIIlllIlll;
                this.first = first;
                lllllllllllllIIIllllIIIIIlllIIIl = first;
                final long[] array3 = lllllllllllllIIIllllIIIIIlllIIlI;
                final int n4 = lllllllllllllIIIllllIIIIIlllIlll;
                array3[n4] |= 0xFFFFFFFF00000000L;
            }
        }
        if ((this.last = lllllllllllllIIIllllIIIIIlllIIIl) != -1) {
            final long[] array4 = lllllllllllllIIIllllIIIIIlllIIlI;
            final int n5 = lllllllllllllIIIllllIIIIIlllIIIl;
            array4[n5] |= 0xFFFFFFFFL;
        }
    }
    
    @Override
    public Int2IntSortedMap.FastSortedEntrySet int2IntEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }
    
    public int putAndMoveToLast(final int lllllllllllllIIIllllIIlIIIIIlIIl, final int lllllllllllllIIIllllIIlIIIIIIlII) {
        int lllllllllllllIIIllllIIlIIIIIIlll = 0;
        if (lllllllllllllIIIllllIIlIIIIIlIIl == 0) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.setValue(this.n, lllllllllllllIIIllllIIlIIIIIIlII);
            }
            this.containsNullKey = true;
            final int lllllllllllllIIIllllIIlIIIIIllIl = this.n;
        }
        else {
            final int[] lllllllllllllIIIllllIIlIIIIIlIll = this.key;
            int lllllllllllllIIIllllIIlIIIIIllII;
            if ((lllllllllllllIIIllllIIlIIIIIllII = lllllllllllllIIIllllIIlIIIIIlIll[lllllllllllllIIIllllIIlIIIIIIlll = (HashCommon.mix(lllllllllllllIIIllllIIlIIIIIlIIl) & this.mask)]) != 0) {
                if (lllllllllllllIIIllllIIlIIIIIllII == lllllllllllllIIIllllIIlIIIIIlIIl) {
                    this.moveIndexToLast(lllllllllllllIIIllllIIlIIIIIIlll);
                    return this.setValue(lllllllllllllIIIllllIIlIIIIIIlll, lllllllllllllIIIllllIIlIIIIIIlII);
                }
                while ((lllllllllllllIIIllllIIlIIIIIllII = lllllllllllllIIIllllIIlIIIIIlIll[lllllllllllllIIIllllIIlIIIIIIlll = (lllllllllllllIIIllllIIlIIIIIIlll + 1 & this.mask)]) != 0) {
                    if (lllllllllllllIIIllllIIlIIIIIllII == lllllllllllllIIIllllIIlIIIIIlIIl) {
                        this.moveIndexToLast(lllllllllllllIIIllllIIlIIIIIIlll);
                        return this.setValue(lllllllllllllIIIllllIIlIIIIIIlll, lllllllllllllIIIllllIIlIIIIIIlII);
                    }
                }
            }
        }
        this.key[lllllllllllllIIIllllIIlIIIIIIlll] = lllllllllllllIIIllllIIlIIIIIlIIl;
        this.value[lllllllllllllIIIllllIIlIIIIIIlll] = lllllllllllllIIIllllIIlIIIIIIlII;
        if (this.size == 0) {
            final int n = lllllllllllllIIIllllIIlIIIIIIlll;
            this.last = n;
            this.first = n;
            this.link[lllllllllllllIIIllllIIlIIIIIIlll] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIIllllIIlIIIIIIlll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIIllllIIlIIIIIIlll] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = lllllllllllllIIIllllIIlIIIIIIlll;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }
    
    @Override
    public boolean containsValue(final int lllllllllllllIIIllllIIIlllIllIll) {
        final int[] lllllllllllllIIIllllIIIlllIllIlI = this.value;
        final int[] lllllllllllllIIIllllIIIlllIllIIl = this.key;
        if (this.containsNullKey && lllllllllllllIIIllllIIIlllIllIlI[this.n] == lllllllllllllIIIllllIIIlllIllIll) {
            return true;
        }
        int lllllllllllllIIIllllIIIlllIlllIl = this.n;
        while (lllllllllllllIIIllllIIIlllIlllIl-- != 0) {
            if (lllllllllllllIIIllllIIIlllIllIIl[lllllllllllllIIIllllIIIlllIlllIl] != 0 && lllllllllllllIIIllllIIIlllIllIlI[lllllllllllllIIIllllIIIlllIlllIl] == lllllllllllllIIIllllIIIlllIllIll) {
                return true;
            }
        }
        return false;
    }
    
    protected void fixPointers(final int lllllllllllllIIIllllIIIlIIIlIIlI, final int lllllllllllllIIIllllIIIlIIIlIIIl) {
        if (this.size == 1) {
            this.last = lllllllllllllIIIllllIIIlIIIlIIIl;
            this.first = lllllllllllllIIIllllIIIlIIIlIIIl;
            this.link[lllllllllllllIIIllllIIIlIIIlIIIl] = -1L;
            return;
        }
        if (this.first == lllllllllllllIIIllllIIIlIIIlIIlI) {
            this.first = lllllllllllllIIIllllIIIlIIIlIIIl;
            final long[] link = this.link;
            final int n = (int)this.link[lllllllllllllIIIllllIIIlIIIlIIlI];
            link[n] ^= ((this.link[(int)this.link[lllllllllllllIIIllllIIIlIIIlIIlI]] ^ ((long)lllllllllllllIIIllllIIIlIIIlIIIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[lllllllllllllIIIllllIIIlIIIlIIIl] = this.link[lllllllllllllIIIllllIIIlIIIlIIlI];
            return;
        }
        if (this.last == lllllllllllllIIIllllIIIlIIIlIIlI) {
            this.last = lllllllllllllIIIllllIIIlIIIlIIIl;
            final long[] link2 = this.link;
            final int n2 = (int)(this.link[lllllllllllllIIIllllIIIlIIIlIIlI] >>> 32);
            link2[n2] ^= ((this.link[(int)(this.link[lllllllllllllIIIllllIIIlIIIlIIlI] >>> 32)] ^ ((long)lllllllllllllIIIllllIIIlIIIlIIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIIllllIIIlIIIlIIIl] = this.link[lllllllllllllIIIllllIIIlIIIlIIlI];
            return;
        }
        final long lllllllllllllIIIllllIIIlIIIlIIII = this.link[lllllllllllllIIIllllIIIlIIIlIIlI];
        final int lllllllllllllIIIllllIIIlIIIIllll = (int)(lllllllllllllIIIllllIIIlIIIlIIII >>> 32);
        final int lllllllllllllIIIllllIIIlIIIIlllI = (int)lllllllllllllIIIllllIIIlIIIlIIII;
        final long[] link3 = this.link;
        final int n3 = lllllllllllllIIIllllIIIlIIIIllll;
        link3[n3] ^= ((this.link[lllllllllllllIIIllllIIIlIIIIllll] ^ ((long)lllllllllllllIIIllllIIIlIIIlIIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n4 = lllllllllllllIIIllllIIIlIIIIlllI;
        link4[n4] ^= ((this.link[lllllllllllllIIIllllIIIlIIIIlllI] ^ ((long)lllllllllllllIIIllllIIIlIIIlIIIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[lllllllllllllIIIllllIIIlIIIlIIIl] = lllllllllllllIIIllllIIIlIIIlIIII;
    }
    
    @Override
    public int getOrDefault(final int lllllllllllllIIIllllIIIlllIIllII, final int lllllllllllllIIIllllIIIlllIIlIll) {
        if (lllllllllllllIIIllllIIIlllIIllII == 0) {
            return this.containsNullKey ? this.value[this.n] : lllllllllllllIIIllllIIIlllIIlIll;
        }
        final int[] lllllllllllllIIIllllIIIlllIIlIIl = this.key;
        int lllllllllllllIIIllllIIIlllIIlIII;
        int lllllllllllllIIIllllIIIlllIIlIlI;
        if ((lllllllllllllIIIllllIIIlllIIlIlI = lllllllllllllIIIllllIIIlllIIlIIl[lllllllllllllIIIllllIIIlllIIlIII = (HashCommon.mix(lllllllllllllIIIllllIIIlllIIllII) & this.mask)]) == 0) {
            return lllllllllllllIIIllllIIIlllIIlIll;
        }
        if (lllllllllllllIIIllllIIIlllIIllII == lllllllllllllIIIllllIIIlllIIlIlI) {
            return this.value[lllllllllllllIIIllllIIIlllIIlIII];
        }
        while ((lllllllllllllIIIllllIIIlllIIlIlI = lllllllllllllIIIllllIIIlllIIlIIl[lllllllllllllIIIllllIIIlllIIlIII = (lllllllllllllIIIllllIIIlllIIlIII + 1 & this.mask)]) != 0) {
            if (lllllllllllllIIIllllIIIlllIIllII == lllllllllllllIIIllllIIIlllIIlIlI) {
                return this.value[lllllllllllllIIIllllIIIlllIIlIII];
            }
        }
        return lllllllllllllIIIllllIIIlllIIlIll;
    }
    
    @Override
    public IntCollection values() {
        if (this.values == null) {
            this.values = new AbstractIntCollection() {
                @Override
                public int size() {
                    return Int2IntLinkedOpenHashMap.this.size;
                }
                
                @Override
                public void clear() {
                    Int2IntLinkedOpenHashMap.this.clear();
                }
                
                @Override
                public void forEach(final IntConsumer lllllllllllllIIIIIIlIIllIlIIIlII) {
                    if (Int2IntLinkedOpenHashMap.this.containsNullKey) {
                        lllllllllllllIIIIIIlIIllIlIIIlII.accept(Int2IntLinkedOpenHashMap.this.value[Int2IntLinkedOpenHashMap.this.n]);
                    }
                    int lllllllllllllIIIIIIlIIllIlIIIllI = Int2IntLinkedOpenHashMap.this.n;
                    while (lllllllllllllIIIIIIlIIllIlIIIllI-- != 0) {
                        if (Int2IntLinkedOpenHashMap.this.key[lllllllllllllIIIIIIlIIllIlIIIllI] != 0) {
                            lllllllllllllIIIIIIlIIllIlIIIlII.accept(Int2IntLinkedOpenHashMap.this.value[lllllllllllllIIIIIIlIIllIlIIIllI]);
                        }
                    }
                }
                
                @Override
                public boolean contains(final int lllllllllllllIIIIIIlIIllIlIIllll) {
                    return Int2IntLinkedOpenHashMap.this.containsValue(lllllllllllllIIIIIIlIIllIlIIllll);
                }
                
                @Override
                public IntIterator iterator() {
                    return new ValueIterator();
                }
            };
        }
        return this.values;
    }
    
    private int removeNullEntry() {
        this.containsNullKey = false;
        final int lllllllllllllIIIllllIIlIllllIIll = this.value[this.n];
        --this.size;
        this.fixPointers(this.n);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIIllllIIlIllllIIll;
    }
    
    private void ensureCapacity(final int lllllllllllllIIIllllIIllIIIIlIlI) {
        final int lllllllllllllIIIllllIIllIIIIllII = HashCommon.arraySize(lllllllllllllIIIllllIIllIIIIlIlI, this.f);
        if (lllllllllllllIIIllllIIllIIIIllII > this.n) {
            this.rehash(lllllllllllllIIIllllIIllIIIIllII);
        }
    }
    
    @Override
    public int remove(final int lllllllllllllIIIllllIIlIlIIIlIIl) {
        if (lllllllllllllIIIllllIIlIlIIIlIIl == 0) {
            if (this.containsNullKey) {
                return this.removeNullEntry();
            }
            return this.defRetValue;
        }
        else {
            final int[] lllllllllllllIIIllllIIlIlIIIIlll = this.key;
            int lllllllllllllIIIllllIIlIlIIIIllI;
            int lllllllllllllIIIllllIIlIlIIIlIII;
            if ((lllllllllllllIIIllllIIlIlIIIlIII = lllllllllllllIIIllllIIlIlIIIIlll[lllllllllllllIIIllllIIlIlIIIIllI = (HashCommon.mix(lllllllllllllIIIllllIIlIlIIIlIIl) & this.mask)]) == 0) {
                return this.defRetValue;
            }
            if (lllllllllllllIIIllllIIlIlIIIlIIl == lllllllllllllIIIllllIIlIlIIIlIII) {
                return this.removeEntry(lllllllllllllIIIllllIIlIlIIIIllI);
            }
            while ((lllllllllllllIIIllllIIlIlIIIlIII = lllllllllllllIIIllllIIlIlIIIIlll[lllllllllllllIIIllllIIlIlIIIIllI = (lllllllllllllIIIllllIIlIlIIIIllI + 1 & this.mask)]) != 0) {
                if (lllllllllllllIIIllllIIlIlIIIlIIl == lllllllllllllIIIllllIIlIlIIIlIII) {
                    return this.removeEntry(lllllllllllllIIIllllIIlIlIIIIllI);
                }
            }
            return this.defRetValue;
        }
    }
    
    public int getAndMoveToFirst(final int lllllllllllllIIIllllIIlIIIlllllI) {
        if (lllllllllllllIIIllllIIlIIIlllllI == 0) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        else {
            final int[] lllllllllllllIIIllllIIlIIIllllII = this.key;
            int lllllllllllllIIIllllIIlIIIlllIll;
            int lllllllllllllIIIllllIIlIIIllllIl;
            if ((lllllllllllllIIIllllIIlIIIllllIl = lllllllllllllIIIllllIIlIIIllllII[lllllllllllllIIIllllIIlIIIlllIll = (HashCommon.mix(lllllllllllllIIIllllIIlIIIlllllI) & this.mask)]) == 0) {
                return this.defRetValue;
            }
            if (lllllllllllllIIIllllIIlIIIlllllI == lllllllllllllIIIllllIIlIIIllllIl) {
                this.moveIndexToFirst(lllllllllllllIIIllllIIlIIIlllIll);
                return this.value[lllllllllllllIIIllllIIlIIIlllIll];
            }
            while ((lllllllllllllIIIllllIIlIIIllllIl = lllllllllllllIIIllllIIlIIIllllII[lllllllllllllIIIllllIIlIIIlllIll = (lllllllllllllIIIllllIIlIIIlllIll + 1 & this.mask)]) != 0) {
                if (lllllllllllllIIIllllIIlIIIlllllI == lllllllllllllIIIllllIIlIIIllllIl) {
                    this.moveIndexToFirst(lllllllllllllIIIllllIIlIIIlllIll);
                    return this.value[lllllllllllllIIIllllIIlIIIlllIll];
                }
            }
            return this.defRetValue;
        }
    }
    
    @Override
    public int compute(final int lllllllllllllIIIllllIIIlIlIIlIII, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIIIllllIIIlIlIIIlll) {
        Objects.requireNonNull(lllllllllllllIIIllllIIIlIlIIIlll);
        final int lllllllllllllIIIllllIIIlIlIIllII = this.find(lllllllllllllIIIllllIIIlIlIIlIII);
        final Integer lllllllllllllIIIllllIIIlIlIIlIll = (Integer)lllllllllllllIIIllllIIIlIlIIIlll.apply(lllllllllllllIIIllllIIIlIlIIlIII, (lllllllllllllIIIllllIIIlIlIIllII >= 0) ? Integer.valueOf(this.value[lllllllllllllIIIllllIIIlIlIIllII]) : null);
        if (lllllllllllllIIIllllIIIlIlIIlIll == null) {
            if (lllllllllllllIIIllllIIIlIlIIllII >= 0) {
                if (lllllllllllllIIIllllIIIlIlIIlIII == 0) {
                    this.removeNullEntry();
                }
                else {
                    this.removeEntry(lllllllllllllIIIllllIIIlIlIIllII);
                }
            }
            return this.defRetValue;
        }
        final int lllllllllllllIIIllllIIIlIlIIlIlI = lllllllllllllIIIllllIIIlIlIIlIll;
        if (lllllllllllllIIIllllIIIlIlIIllII < 0) {
            this.insert(-lllllllllllllIIIllllIIIlIlIIllII - 1, lllllllllllllIIIllllIIIlIlIIlIII, lllllllllllllIIIllllIIIlIlIIlIlI);
            return lllllllllllllIIIllllIIIlIlIIlIlI;
        }
        return this.value[lllllllllllllIIIllllIIIlIlIIllII] = lllllllllllllIIIllllIIIlIlIIlIlI;
    }
    
    public int removeFirstInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int lllllllllllllIIIllllIIlIIlllIIII = this.first;
        this.first = (int)this.link[lllllllllllllIIIllllIIlIIlllIIII];
        if (0 <= this.first) {
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        --this.size;
        final int lllllllllllllIIIllllIIlIIllIllll = this.value[lllllllllllllIIIllllIIlIIlllIIII];
        if (lllllllllllllIIIllllIIlIIlllIIII == this.n) {
            this.containsNullKey = false;
        }
        else {
            this.shiftKeys(lllllllllllllIIIllllIIlIIlllIIII);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIIllllIIlIIllIllll;
    }
    
    public Int2IntLinkedOpenHashMap(final int lllllllllllllIIIllllIIllIlIlIlIl, final float lllllllllllllIIIllllIIllIlIlIlII) {
        this.first = -1;
        this.last = -1;
        if (lllllllllllllIIIllllIIllIlIlIlII <= 0.0f || lllllllllllllIIIllllIIllIlIlIlII > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (lllllllllllllIIIllllIIllIlIlIlIl < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = lllllllllllllIIIllllIIllIlIlIlII;
        final int arraySize = HashCommon.arraySize(lllllllllllllIIIllllIIllIlIlIlIl, lllllllllllllIIIllllIIllIlIlIlII);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, lllllllllllllIIIllllIIllIlIlIlII);
        this.key = new int[this.n + 1];
        this.value = new int[this.n + 1];
        this.link = new long[this.n + 1];
    }
    
    public int addTo(final int lllllllllllllIIIllllIIlIlIlIlIlI, final int lllllllllllllIIIllllIIlIlIlIlIIl) {
        int lllllllllllllIIIllllIIlIlIlIlIII = 0;
        if (lllllllllllllIIIllllIIlIlIlIlIlI == 0) {
            if (this.containsNullKey) {
                return this.addToValue(this.n, lllllllllllllIIIllllIIlIlIlIlIIl);
            }
            final int lllllllllllllIIIllllIIlIlIlIlllI = this.n;
            this.containsNullKey = true;
        }
        else {
            final int[] lllllllllllllIIIllllIIlIlIlIllII = this.key;
            int lllllllllllllIIIllllIIlIlIlIllIl;
            if ((lllllllllllllIIIllllIIlIlIlIllIl = lllllllllllllIIIllllIIlIlIlIllII[lllllllllllllIIIllllIIlIlIlIlIII = (HashCommon.mix(lllllllllllllIIIllllIIlIlIlIlIlI) & this.mask)]) != 0) {
                if (lllllllllllllIIIllllIIlIlIlIllIl == lllllllllllllIIIllllIIlIlIlIlIlI) {
                    return this.addToValue(lllllllllllllIIIllllIIlIlIlIlIII, lllllllllllllIIIllllIIlIlIlIlIIl);
                }
                while ((lllllllllllllIIIllllIIlIlIlIllIl = lllllllllllllIIIllllIIlIlIlIllII[lllllllllllllIIIllllIIlIlIlIlIII = (lllllllllllllIIIllllIIlIlIlIlIII + 1 & this.mask)]) != 0) {
                    if (lllllllllllllIIIllllIIlIlIlIllIl == lllllllllllllIIIllllIIlIlIlIlIlI) {
                        return this.addToValue(lllllllllllllIIIllllIIlIlIlIlIII, lllllllllllllIIIllllIIlIlIlIlIIl);
                    }
                }
            }
        }
        this.key[lllllllllllllIIIllllIIlIlIlIlIII] = lllllllllllllIIIllllIIlIlIlIlIlI;
        this.value[lllllllllllllIIIllllIIlIlIlIlIII] = this.defRetValue + lllllllllllllIIIllllIIlIlIlIlIIl;
        if (this.size == 0) {
            final int n = lllllllllllllIIIllllIIlIlIlIlIII;
            this.last = n;
            this.first = n;
            this.link[lllllllllllllIIIllllIIlIlIlIlIII] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIIllllIIlIlIlIlIII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIIllllIIlIlIlIlIII] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = lllllllllllllIIIllllIIlIlIlIlIII;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return this.defRetValue;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIllllIIIIlIlIIIII = 0;
        int lllllllllllllIIIllllIIIIlIlIIlII = this.realSize();
        int lllllllllllllIIIllllIIIIlIlIIIll = 0;
        int lllllllllllllIIIllllIIIIlIlIIIlI = 0;
        while (lllllllllllllIIIllllIIIIlIlIIlII-- != 0) {
            while (this.key[lllllllllllllIIIllllIIIIlIlIIIll] == 0) {
                ++lllllllllllllIIIllllIIIIlIlIIIll;
            }
            lllllllllllllIIIllllIIIIlIlIIIlI = this.key[lllllllllllllIIIllllIIIIlIlIIIll];
            lllllllllllllIIIllllIIIIlIlIIIlI ^= this.value[lllllllllllllIIIllllIIIIlIlIIIll];
            lllllllllllllIIIllllIIIIlIlIIIII += lllllllllllllIIIllllIIIIlIlIIIlI;
            ++lllllllllllllIIIllllIIIIlIlIIIll;
        }
        if (this.containsNullKey) {
            lllllllllllllIIIllllIIIIlIlIIIII += this.value[this.n];
        }
        return lllllllllllllIIIllllIIIIlIlIIIII;
    }
    
    @Override
    public int computeIfAbsentNullable(final int lllllllllllllIIIllllIIIlIllIllll, final IntFunction<? extends Integer> lllllllllllllIIIllllIIIlIllIlllI) {
        Objects.requireNonNull(lllllllllllllIIIllllIIIlIllIlllI);
        final int lllllllllllllIIIllllIIIlIllIllIl = this.find(lllllllllllllIIIllllIIIlIllIllll);
        if (lllllllllllllIIIllllIIIlIllIllIl >= 0) {
            return this.value[lllllllllllllIIIllllIIIlIllIllIl];
        }
        final Integer lllllllllllllIIIllllIIIlIllIllII = (Integer)lllllllllllllIIIllllIIIlIllIlllI.apply(lllllllllllllIIIllllIIIlIllIllll);
        if (lllllllllllllIIIllllIIIlIllIllII == null) {
            return this.defRetValue;
        }
        final int lllllllllllllIIIllllIIIlIllIlIll = lllllllllllllIIIllllIIIlIllIllII;
        this.insert(-lllllllllllllIIIllllIIIlIllIllIl - 1, lllllllllllllIIIllllIIIlIllIllll, lllllllllllllIIIllllIIIlIllIlIll);
        return lllllllllllllIIIllllIIIlIllIlIll;
    }
    
    private class FastEntryIterator extends MapIterator implements ObjectListIterator<Int2IntMap.Entry>
    {
        final /* synthetic */ MapEntry entry;
        
        public FastEntryIterator(final int llllllllllllllIlIIlllIlIlllllIII) {
            super(llllllllllllllIlIIlllIlIlllllIII);
            this.entry = new MapEntry();
        }
        
        public FastEntryIterator() {
            this.entry = new MapEntry();
        }
        
        @Override
        public MapEntry previous() {
            this.entry.index = this.previousEntry();
            return this.entry;
        }
        
        @Override
        public MapEntry next() {
            this.entry.index = this.nextEntry();
            return this.entry;
        }
    }
    
    private class MapIterator
    {
        /* synthetic */ int prev;
        /* synthetic */ int curr;
        /* synthetic */ int index;
        /* synthetic */ int next;
        
        private final void ensureIndexKnown() {
            if (this.index >= 0) {
                return;
            }
            if (this.prev == -1) {
                this.index = 0;
                return;
            }
            if (this.next == -1) {
                this.index = Int2IntLinkedOpenHashMap.this.size;
                return;
            }
            int llllllllllllllIlIlIIlIlIIlllIllI = Int2IntLinkedOpenHashMap.this.first;
            this.index = 1;
            while (llllllllllllllIlIlIIlIlIIlllIllI != this.prev) {
                llllllllllllllIlIlIIlIlIIlllIllI = (int)Int2IntLinkedOpenHashMap.this.link[llllllllllllllIlIlIIlIlIIlllIllI];
                ++this.index;
            }
        }
        
        protected MapIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = Int2IntLinkedOpenHashMap.this.first;
            this.index = 0;
        }
        
        public boolean hasPrevious() {
            return this.prev != -1;
        }
        
        public int previousIndex() {
            this.ensureIndexKnown();
            return this.index - 1;
        }
        
        public int nextIndex() {
            this.ensureIndexKnown();
            return this.index;
        }
        
        public void set(final Int2IntMap.Entry llllllllllllllIlIlIIlIlIIlIIIIlI) {
            throw new UnsupportedOperationException();
        }
        
        public int back(final int llllllllllllllIlIlIIlIlIIlIIlIII) {
            int llllllllllllllIlIlIIlIlIIlIIIlll = llllllllllllllIlIlIIlIlIIlIIlIII;
            while (llllllllllllllIlIlIIlIlIIlIIIlll-- != 0 && this.hasPrevious()) {
                this.previousEntry();
            }
            return llllllllllllllIlIlIIlIlIIlIIlIII - llllllllllllllIlIlIIlIlIIlIIIlll - 1;
        }
        
        public int previousEntry() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int)(Int2IntLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                --this.index;
            }
            return this.curr;
        }
        
        public boolean hasNext() {
            return this.next != -1;
        }
        
        private MapIterator(final int llllllllllllllIlIlIIlIlIlIIIIIIl) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (llllllllllllllIlIlIIlIlIlIIIIIIl == 0) {
                if (Int2IntLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int)Int2IntLinkedOpenHashMap.this.link[Int2IntLinkedOpenHashMap.this.n];
                    this.prev = Int2IntLinkedOpenHashMap.this.n;
                    return;
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(llllllllllllllIlIlIIlIlIlIIIIIIl).append(" does not belong to this map.")));
            }
            else {
                if (Int2IntLinkedOpenHashMap.this.key[Int2IntLinkedOpenHashMap.this.last] == llllllllllllllIlIlIIlIlIlIIIIIIl) {
                    this.prev = Int2IntLinkedOpenHashMap.this.last;
                    this.index = Int2IntLinkedOpenHashMap.this.size;
                    return;
                }
                for (int llllllllllllllIlIlIIlIlIlIIIIlII = HashCommon.mix(llllllllllllllIlIlIIlIlIlIIIIIIl) & Int2IntLinkedOpenHashMap.this.mask; Int2IntLinkedOpenHashMap.this.key[llllllllllllllIlIlIIlIlIlIIIIlII] != 0; llllllllllllllIlIlIIlIlIlIIIIlII = (llllllllllllllIlIlIIlIlIlIIIIlII + 1 & Int2IntLinkedOpenHashMap.this.mask)) {
                    if (Int2IntLinkedOpenHashMap.this.key[llllllllllllllIlIlIIlIlIlIIIIlII] == llllllllllllllIlIlIIlIlIlIIIIIIl) {
                        this.next = (int)Int2IntLinkedOpenHashMap.this.link[llllllllllllllIlIlIIlIlIlIIIIlII];
                        this.prev = llllllllllllllIlIlIIlIlIlIIIIlII;
                        return;
                    }
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(llllllllllllllIlIlIIlIlIlIIIIIIl).append(" does not belong to this map.")));
            }
        }
        
        public void remove() {
            this.ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                --this.index;
                this.prev = (int)(Int2IntLinkedOpenHashMap.this.link[this.curr] >>> 32);
            }
            else {
                this.next = (int)Int2IntLinkedOpenHashMap.this.link[this.curr];
            }
            final Int2IntLinkedOpenHashMap this$0 = Int2IntLinkedOpenHashMap.this;
            --this$0.size;
            if (this.prev == -1) {
                Int2IntLinkedOpenHashMap.this.first = this.next;
            }
            else {
                final long[] link = Int2IntLinkedOpenHashMap.this.link;
                final int prev = this.prev;
                link[prev] ^= ((Int2IntLinkedOpenHashMap.this.link[this.prev] ^ ((long)this.next & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            }
            if (this.next == -1) {
                Int2IntLinkedOpenHashMap.this.last = this.prev;
            }
            else {
                final long[] link2 = Int2IntLinkedOpenHashMap.this.link;
                final int next = this.next;
                link2[next] ^= ((Int2IntLinkedOpenHashMap.this.link[this.next] ^ ((long)this.prev & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            }
            int llllllllllllllIlIlIIlIlIIlIlllII = this.curr;
            this.curr = -1;
            if (llllllllllllllIlIlIIlIlIIlIlllII == Int2IntLinkedOpenHashMap.this.n) {
                Int2IntLinkedOpenHashMap.this.containsNullKey = false;
                return;
            }
            final int[] llllllllllllllIlIlIIlIlIIllIIIII = Int2IntLinkedOpenHashMap.this.key;
            int llllllllllllllIlIlIIlIlIIlIlllll = 0;
        Label_0264:
            while (true) {
                llllllllllllllIlIlIIlIlIIlIlllII = ((llllllllllllllIlIlIIlIlIIlIlllll = llllllllllllllIlIlIIlIlIIlIlllII) + 1 & Int2IntLinkedOpenHashMap.this.mask);
                int llllllllllllllIlIlIIlIlIIllIIIIl;
                while ((llllllllllllllIlIlIIlIlIIllIIIIl = llllllllllllllIlIlIIlIlIIllIIIII[llllllllllllllIlIlIIlIlIIlIlllII]) != 0) {
                    final int llllllllllllllIlIlIIlIlIIlIllllI = HashCommon.mix(llllllllllllllIlIlIIlIlIIllIIIIl) & Int2IntLinkedOpenHashMap.this.mask;
                    Label_0354: {
                        if (llllllllllllllIlIlIIlIlIIlIlllll <= llllllllllllllIlIlIIlIlIIlIlllII) {
                            if (llllllllllllllIlIlIIlIlIIlIlllll >= llllllllllllllIlIlIIlIlIIlIllllI) {
                                break Label_0354;
                            }
                            if (llllllllllllllIlIlIIlIlIIlIllllI > llllllllllllllIlIlIIlIlIIlIlllII) {
                                break Label_0354;
                            }
                        }
                        else if (llllllllllllllIlIlIIlIlIIlIlllll >= llllllllllllllIlIlIIlIlIIlIllllI && llllllllllllllIlIlIIlIlIIlIllllI > llllllllllllllIlIlIIlIlIIlIlllII) {
                            break Label_0354;
                        }
                        llllllllllllllIlIlIIlIlIIlIlllII = (llllllllllllllIlIlIIlIlIIlIlllII + 1 & Int2IntLinkedOpenHashMap.this.mask);
                        continue;
                    }
                    llllllllllllllIlIlIIlIlIIllIIIII[llllllllllllllIlIlIIlIlIIlIlllll] = llllllllllllllIlIlIIlIlIIllIIIIl;
                    Int2IntLinkedOpenHashMap.this.value[llllllllllllllIlIlIIlIlIIlIlllll] = Int2IntLinkedOpenHashMap.this.value[llllllllllllllIlIlIIlIlIIlIlllII];
                    if (this.next == llllllllllllllIlIlIIlIlIIlIlllII) {
                        this.next = llllllllllllllIlIlIIlIlIIlIlllll;
                    }
                    if (this.prev == llllllllllllllIlIlIIlIlIIlIlllII) {
                        this.prev = llllllllllllllIlIlIIlIlIIlIlllll;
                    }
                    Int2IntLinkedOpenHashMap.this.fixPointers(llllllllllllllIlIlIIlIlIIlIlllII, llllllllllllllIlIlIIlIlIIlIlllll);
                    continue Label_0264;
                }
                break;
            }
            llllllllllllllIlIlIIlIlIIllIIIII[llllllllllllllIlIlIIlIlIIlIlllll] = 0;
        }
        
        public int skip(final int llllllllllllllIlIlIIlIlIIlIIlllI) {
            int llllllllllllllIlIlIIlIlIIlIlIIII = llllllllllllllIlIlIIlIlIIlIIlllI;
            while (llllllllllllllIlIlIIlIlIIlIlIIII-- != 0 && this.hasNext()) {
                this.nextEntry();
            }
            return llllllllllllllIlIlIIlIlIIlIIlllI - llllllllllllllIlIlIIlIlIIlIlIIII - 1;
        }
        
        public void add(final Int2IntMap.Entry llllllllllllllIlIlIIlIlIIlIIIIII) {
            throw new UnsupportedOperationException();
        }
        
        public int nextEntry() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int)Int2IntLinkedOpenHashMap.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                ++this.index;
            }
            return this.curr;
        }
    }
    
    final class MapEntry implements Int2IntMap.Entry, Map.Entry<Integer, Integer>
    {
        /* synthetic */ int index;
        
        @Override
        public int getIntKey() {
            return Int2IntLinkedOpenHashMap.this.key[this.index];
        }
        
        @Override
        public int getIntValue() {
            return Int2IntLinkedOpenHashMap.this.value[this.index];
        }
        
        @Deprecated
        @Override
        public Integer getKey() {
            return Int2IntLinkedOpenHashMap.this.key[this.index];
        }
        
        @Override
        public boolean equals(final Object llllllllllllllllIlllllIIlllIlIII) {
            if (!(llllllllllllllllIlllllIIlllIlIII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<Integer, Integer> llllllllllllllllIlllllIIlllIIlll = (Map.Entry<Integer, Integer>)llllllllllllllllIlllllIIlllIlIII;
            return Int2IntLinkedOpenHashMap.this.key[this.index] == llllllllllllllllIlllllIIlllIIlll.getKey() && Int2IntLinkedOpenHashMap.this.value[this.index] == llllllllllllllllIlllllIIlllIIlll.getValue();
        }
        
        @Override
        public int setValue(final int llllllllllllllllIlllllIIllllllIl) {
            final int llllllllllllllllIlllllIIllllllII = Int2IntLinkedOpenHashMap.this.value[this.index];
            Int2IntLinkedOpenHashMap.this.value[this.index] = llllllllllllllllIlllllIIllllllIl;
            return llllllllllllllllIlllllIIllllllII;
        }
        
        MapEntry() {
        }
        
        @Override
        public int hashCode() {
            return Int2IntLinkedOpenHashMap.this.key[this.index] ^ Int2IntLinkedOpenHashMap.this.value[this.index];
        }
        
        MapEntry(final int llllllllllllllllIlllllIlIIIIlllI) {
            this.index = llllllllllllllllIlllllIlIIIIlllI;
        }
        
        @Deprecated
        @Override
        public Integer setValue(final Integer llllllllllllllllIlllllIIlllIllll) {
            return this.setValue((int)llllllllllllllllIlllllIIlllIllll);
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(Int2IntLinkedOpenHashMap.this.key[this.index]).append("=>").append(Int2IntLinkedOpenHashMap.this.value[this.index]));
        }
        
        @Deprecated
        @Override
        public Integer getValue() {
            return Int2IntLinkedOpenHashMap.this.value[this.index];
        }
    }
    
    private final class ValueIterator extends MapIterator implements IntListIterator
    {
        public ValueIterator() {
        }
        
        @Override
        public int previousInt() {
            return Int2IntLinkedOpenHashMap.this.value[this.previousEntry()];
        }
        
        @Override
        public int nextInt() {
            return Int2IntLinkedOpenHashMap.this.value[this.nextEntry()];
        }
    }
    
    private final class KeyIterator extends MapIterator implements IntListIterator
    {
        @Override
        public int nextInt() {
            return Int2IntLinkedOpenHashMap.this.key[this.nextEntry()];
        }
        
        public KeyIterator(final int lllllllllllllllIllIIIlIlIllIllII) {
            super(lllllllllllllllIllIIIlIlIllIllII);
        }
        
        @Override
        public int previousInt() {
            return Int2IntLinkedOpenHashMap.this.key[this.previousEntry()];
        }
        
        public KeyIterator() {
        }
    }
    
    private final class MapEntrySet extends AbstractObjectSortedSet<Int2IntMap.Entry> implements Int2IntSortedMap.FastSortedEntrySet
    {
        @Override
        public ObjectListIterator<Int2IntMap.Entry> fastIterator(final Int2IntMap.Entry lllllllllllllIIIIllIIIllllIlIIll) {
            return new FastEntryIterator(lllllllllllllIIIIllIIIllllIlIIll.getIntKey());
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIIIIllIIIllllllIlII) {
            if (!(lllllllllllllIIIIllIIIllllllIlII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIIIIllIIIllllllIIll = (Map.Entry<?, ?>)lllllllllllllIIIIllIIIllllllIlII;
            if (lllllllllllllIIIIllIIIllllllIIll.getKey() == null || !(lllllllllllllIIIIllIIIllllllIIll.getKey() instanceof Integer)) {
                return false;
            }
            if (lllllllllllllIIIIllIIIllllllIIll.getValue() == null || !(lllllllllllllIIIIllIIIllllllIIll.getValue() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIIIIllIIIllllllIIlI = (int)lllllllllllllIIIIllIIIllllllIIll.getKey();
            final int lllllllllllllIIIIllIIIllllllIIIl = (int)lllllllllllllIIIIllIIIllllllIIll.getValue();
            if (lllllllllllllIIIIllIIIllllllIIlI == 0) {
                if (Int2IntLinkedOpenHashMap.this.containsNullKey && Int2IntLinkedOpenHashMap.this.value[Int2IntLinkedOpenHashMap.this.n] == lllllllllllllIIIIllIIIllllllIIIl) {
                    Int2IntLinkedOpenHashMap.this.removeNullEntry();
                    return true;
                }
                return false;
            }
            else {
                final int[] lllllllllllllIIIIllIIIlllllIllll = Int2IntLinkedOpenHashMap.this.key;
                int lllllllllllllIIIIllIIIlllllIlllI;
                int lllllllllllllIIIIllIIIllllllIIII;
                if ((lllllllllllllIIIIllIIIllllllIIII = lllllllllllllIIIIllIIIlllllIllll[lllllllllllllIIIIllIIIlllllIlllI = (HashCommon.mix(lllllllllllllIIIIllIIIllllllIIlI) & Int2IntLinkedOpenHashMap.this.mask)]) == 0) {
                    return false;
                }
                if (lllllllllllllIIIIllIIIllllllIIII != lllllllllllllIIIIllIIIllllllIIlI) {
                    while ((lllllllllllllIIIIllIIIllllllIIII = lllllllllllllIIIIllIIIlllllIllll[lllllllllllllIIIIllIIIlllllIlllI = (lllllllllllllIIIIllIIIlllllIlllI + 1 & Int2IntLinkedOpenHashMap.this.mask)]) != 0) {
                        if (lllllllllllllIIIIllIIIllllllIIII == lllllllllllllIIIIllIIIllllllIIlI && Int2IntLinkedOpenHashMap.this.value[lllllllllllllIIIIllIIIlllllIlllI] == lllllllllllllIIIIllIIIllllllIIIl) {
                            Int2IntLinkedOpenHashMap.this.removeEntry(lllllllllllllIIIIllIIIlllllIlllI);
                            return true;
                        }
                    }
                    return false;
                }
                if (Int2IntLinkedOpenHashMap.this.value[lllllllllllllIIIIllIIIlllllIlllI] == lllllllllllllIIIIllIIIllllllIIIl) {
                    Int2IntLinkedOpenHashMap.this.removeEntry(lllllllllllllIIIIllIIIlllllIlllI);
                    return true;
                }
                return false;
            }
        }
        
        @Override
        public ObjectSortedSet<Int2IntMap.Entry> headSet(final Int2IntMap.Entry lllllllllllllIIIIllIIlIIIIIllllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void fastForEach(final Consumer<? super Int2IntMap.Entry> lllllllllllllIIIIllIIIlllIllIlII) {
            final BasicEntry lllllllllllllIIIIllIIIlllIllIllI = new BasicEntry();
            int lllllllllllllIIIIllIIIlllIlllIll = Int2IntLinkedOpenHashMap.this.size;
            int lllllllllllllIIIIllIIIlllIlllIIl = Int2IntLinkedOpenHashMap.this.first;
            while (lllllllllllllIIIIllIIIlllIlllIll-- != 0) {
                final int lllllllllllllIIIIllIIIlllIlllIlI = lllllllllllllIIIIllIIIlllIlllIIl;
                lllllllllllllIIIIllIIIlllIlllIIl = (int)Int2IntLinkedOpenHashMap.this.link[lllllllllllllIIIIllIIIlllIlllIlI];
                lllllllllllllIIIIllIIIlllIllIllI.key = Int2IntLinkedOpenHashMap.this.key[lllllllllllllIIIIllIIIlllIlllIlI];
                lllllllllllllIIIIllIIIlllIllIllI.value = Int2IntLinkedOpenHashMap.this.value[lllllllllllllIIIIllIIIlllIlllIlI];
                lllllllllllllIIIIllIIIlllIllIlII.accept(lllllllllllllIIIIllIIIlllIllIllI);
            }
        }
        
        @Override
        public Int2IntMap.Entry last() {
            if (Int2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Int2IntLinkedOpenHashMap.this.last);
        }
        
        @Override
        public void clear() {
            Int2IntLinkedOpenHashMap.this.clear();
        }
        
        @Override
        public ObjectListIterator<Int2IntMap.Entry> iterator(final Int2IntMap.Entry lllllllllllllIIIIllIIIllllIllIlI) {
            return new EntryIterator(lllllllllllllIIIIllIIIllllIllIlI.getIntKey());
        }
        
        @Override
        public int size() {
            return Int2IntLinkedOpenHashMap.this.size;
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIIIIllIIlIIIIIIllII) {
            if (!(lllllllllllllIIIIllIIlIIIIIIllII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIIIIllIIlIIIIIIlIll = (Map.Entry<?, ?>)lllllllllllllIIIIllIIlIIIIIIllII;
            if (lllllllllllllIIIIllIIlIIIIIIlIll.getKey() == null || !(lllllllllllllIIIIllIIlIIIIIIlIll.getKey() instanceof Integer)) {
                return false;
            }
            if (lllllllllllllIIIIllIIlIIIIIIlIll.getValue() == null || !(lllllllllllllIIIIllIIlIIIIIIlIll.getValue() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIIIIllIIlIIIIIIlIlI = (int)lllllllllllllIIIIllIIlIIIIIIlIll.getKey();
            final int lllllllllllllIIIIllIIlIIIIIIlIIl = (int)lllllllllllllIIIIllIIlIIIIIIlIll.getValue();
            if (lllllllllllllIIIIllIIlIIIIIIlIlI == 0) {
                return Int2IntLinkedOpenHashMap.this.containsNullKey && Int2IntLinkedOpenHashMap.this.value[Int2IntLinkedOpenHashMap.this.n] == lllllllllllllIIIIllIIlIIIIIIlIIl;
            }
            final int[] lllllllllllllIIIIllIIlIIIIIIIlll = Int2IntLinkedOpenHashMap.this.key;
            int lllllllllllllIIIIllIIlIIIIIIIllI;
            int lllllllllllllIIIIllIIlIIIIIIlIII;
            if ((lllllllllllllIIIIllIIlIIIIIIlIII = lllllllllllllIIIIllIIlIIIIIIIlll[lllllllllllllIIIIllIIlIIIIIIIllI = (HashCommon.mix(lllllllllllllIIIIllIIlIIIIIIlIlI) & Int2IntLinkedOpenHashMap.this.mask)]) == 0) {
                return false;
            }
            if (lllllllllllllIIIIllIIlIIIIIIlIlI == lllllllllllllIIIIllIIlIIIIIIlIII) {
                return Int2IntLinkedOpenHashMap.this.value[lllllllllllllIIIIllIIlIIIIIIIllI] == lllllllllllllIIIIllIIlIIIIIIlIIl;
            }
            while ((lllllllllllllIIIIllIIlIIIIIIlIII = lllllllllllllIIIIllIIlIIIIIIIlll[lllllllllllllIIIIllIIlIIIIIIIllI = (lllllllllllllIIIIllIIlIIIIIIIllI + 1 & Int2IntLinkedOpenHashMap.this.mask)]) != 0) {
                if (lllllllllllllIIIIllIIlIIIIIIlIlI == lllllllllllllIIIIllIIlIIIIIIlIII) {
                    return Int2IntLinkedOpenHashMap.this.value[lllllllllllllIIIIllIIlIIIIIIIllI] == lllllllllllllIIIIllIIlIIIIIIlIIl;
                }
            }
            return false;
        }
        
        @Override
        public ObjectListIterator<Int2IntMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }
        
        @Override
        public void forEach(final Consumer<? super Int2IntMap.Entry> lllllllllllllIIIIllIIIllllIIIlll) {
            int lllllllllllllIIIIllIIIllllIIlIll = Int2IntLinkedOpenHashMap.this.size;
            int lllllllllllllIIIIllIIIllllIIlIIl = Int2IntLinkedOpenHashMap.this.first;
            while (lllllllllllllIIIIllIIIllllIIlIll-- != 0) {
                final int lllllllllllllIIIIllIIIllllIIlIlI = lllllllllllllIIIIllIIIllllIIlIIl;
                lllllllllllllIIIIllIIIllllIIlIIl = (int)Int2IntLinkedOpenHashMap.this.link[lllllllllllllIIIIllIIIllllIIlIlI];
                lllllllllllllIIIIllIIIllllIIIlll.accept((Object)new BasicEntry(Int2IntLinkedOpenHashMap.this.key[lllllllllllllIIIIllIIIllllIIlIlI], Int2IntLinkedOpenHashMap.this.value[lllllllllllllIIIIllIIIllllIIlIlI]));
            }
        }
        
        @Override
        public Int2IntMap.Entry first() {
            if (Int2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Int2IntLinkedOpenHashMap.this.first);
        }
        
        @Override
        public ObjectSortedSet<Int2IntMap.Entry> tailSet(final Int2IntMap.Entry lllllllllllllIIIIllIIlIIIIIlllII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public ObjectBidirectionalIterator<Int2IntMap.Entry> iterator() {
            return new EntryIterator();
        }
        
        @Override
        public Comparator<? super Int2IntMap.Entry> comparator() {
            return null;
        }
        
        @Override
        public ObjectSortedSet<Int2IntMap.Entry> subSet(final Int2IntMap.Entry lllllllllllllIIIIllIIlIIIIlIIIIl, final Int2IntMap.Entry lllllllllllllIIIIllIIlIIIIlIIIII) {
            throw new UnsupportedOperationException();
        }
    }
    
    private class EntryIterator extends MapIterator implements ObjectListIterator<Int2IntMap.Entry>
    {
        private /* synthetic */ MapEntry entry;
        
        @Override
        public MapEntry previous() {
            final MapEntry entry = new MapEntry(this.previousEntry());
            this.entry = entry;
            return entry;
        }
        
        public EntryIterator() {
        }
        
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
        
        public EntryIterator(final int lllllllllllllIIlIlIllIlllIlIllIl) {
            super(lllllllllllllIIlIlIllIlllIlIllIl);
        }
    }
    
    private final class KeySet extends AbstractIntSortedSet
    {
        @Override
        public int firstInt() {
            if (Int2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Int2IntLinkedOpenHashMap.this.key[Int2IntLinkedOpenHashMap.this.first];
        }
        
        @Override
        public int size() {
            return Int2IntLinkedOpenHashMap.this.size;
        }
        
        @Override
        public void forEach(final IntConsumer lllllllllllllIllIIIllIlllIIlIIIl) {
            if (Int2IntLinkedOpenHashMap.this.containsNullKey) {
                lllllllllllllIllIIIllIlllIIlIIIl.accept(Int2IntLinkedOpenHashMap.this.key[Int2IntLinkedOpenHashMap.this.n]);
            }
            int lllllllllllllIllIIIllIlllIIlIlIl = Int2IntLinkedOpenHashMap.this.n;
            while (lllllllllllllIllIIIllIlllIIlIlIl-- != 0) {
                final int lllllllllllllIllIIIllIlllIIlIllI = Int2IntLinkedOpenHashMap.this.key[lllllllllllllIllIIIllIlllIIlIlIl];
                if (lllllllllllllIllIIIllIlllIIlIllI != 0) {
                    lllllllllllllIllIIIllIlllIIlIIIl.accept(lllllllllllllIllIIIllIlllIIlIllI);
                }
            }
        }
        
        @Override
        public IntListIterator iterator() {
            return new KeyIterator();
        }
        
        @Override
        public boolean contains(final int lllllllllllllIllIIIllIlllIIIlIII) {
            return Int2IntLinkedOpenHashMap.this.containsKey(lllllllllllllIllIIIllIlllIIIlIII);
        }
        
        @Override
        public IntComparator comparator() {
            return null;
        }
        
        @Override
        public IntListIterator iterator(final int lllllllllllllIllIIIllIlllIIllllI) {
            return new KeyIterator(lllllllllllllIllIIIllIlllIIllllI);
        }
        
        @Override
        public boolean remove(final int lllllllllllllIllIIIllIlllIIIIIIl) {
            final int lllllllllllllIllIIIllIlllIIIIIII = Int2IntLinkedOpenHashMap.this.size;
            Int2IntLinkedOpenHashMap.this.remove(lllllllllllllIllIIIllIlllIIIIIIl);
            return Int2IntLinkedOpenHashMap.this.size != lllllllllllllIllIIIllIlllIIIIIII;
        }
        
        @Override
        public IntSortedSet subSet(final int lllllllllllllIllIIIllIllIllIllIl, final int lllllllllllllIllIIIllIllIllIllII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntSortedSet headSet(final int lllllllllllllIllIIIllIllIllIllll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntSortedSet tailSet(final int lllllllllllllIllIIIllIllIlllIIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
            Int2IntLinkedOpenHashMap.this.clear();
        }
        
        @Override
        public int lastInt() {
            if (Int2IntLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Int2IntLinkedOpenHashMap.this.key[Int2IntLinkedOpenHashMap.this.last];
        }
    }
}
