package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import java.util.*;

public class IntLinkedOpenHashSet extends AbstractIntSortedSet implements Hash, Cloneable, Serializable
{
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ int[] key;
    protected transient /* synthetic */ long[] link;
    protected transient /* synthetic */ boolean containsNull;
    protected transient /* synthetic */ int n;
    protected /* synthetic */ int size;
    protected transient /* synthetic */ int mask;
    protected transient /* synthetic */ int first;
    protected final /* synthetic */ float f;
    protected final transient /* synthetic */ int minN;
    protected transient /* synthetic */ int last;
    
    private boolean removeEntry(final int lllllllllllllIIIlIlIllIlllIIIlII) {
        --this.size;
        this.fixPointers(lllllllllllllIIIlIlIllIlllIIIlII);
        this.shiftKeys(lllllllllllllIIIlIlIllIlllIIIlII);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIlIlIllIIllIIllIl = 0;
        int lllllllllllllIIIlIlIllIIllIlIIII = this.realSize();
        int lllllllllllllIIIlIlIllIIllIIllll = 0;
        while (lllllllllllllIIIlIlIllIIllIlIIII-- != 0) {
            while (this.key[lllllllllllllIIIlIlIllIIllIIllll] == 0) {
                ++lllllllllllllIIIlIlIllIIllIIllll;
            }
            lllllllllllllIIIlIlIllIIllIIllIl += this.key[lllllllllllllIIIlIlIllIIllIIllll];
            ++lllllllllllllIIIlIlIllIIllIIllll;
        }
        return lllllllllllllIIIlIlIllIIllIIllIl;
    }
    
    @Override
    public int lastInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.last];
    }
    
    @Override
    public IntSortedSet headSet(final int lllllllllllllIIIlIlIllIlIIlIIIll) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean addAndMoveToFirst(final int lllllllllllllIIIlIlIllIlIllIIllI) {
        int lllllllllllllIIIlIlIllIlIllIlIII = 0;
        if (lllllllllllllIIIlIlIllIlIllIIllI == 0) {
            if (this.containsNull) {
                this.moveIndexToFirst(this.n);
                return false;
            }
            this.containsNull = true;
            final int lllllllllllllIIIlIlIllIlIllIllII = this.n;
        }
        else {
            int[] lllllllllllllIIIlIlIllIlIllIlIll;
            for (lllllllllllllIIIlIlIllIlIllIlIll = this.key, lllllllllllllIIIlIlIllIlIllIlIII = (HashCommon.mix(lllllllllllllIIIlIlIllIlIllIIllI) & this.mask); lllllllllllllIIIlIlIllIlIllIlIll[lllllllllllllIIIlIlIllIlIllIlIII] != 0; lllllllllllllIIIlIlIllIlIllIlIII = (lllllllllllllIIIlIlIllIlIllIlIII + 1 & this.mask)) {
                if (lllllllllllllIIIlIlIllIlIllIIllI == lllllllllllllIIIlIlIllIlIllIlIll[lllllllllllllIIIlIlIllIlIllIlIII]) {
                    this.moveIndexToFirst(lllllllllllllIIIlIlIllIlIllIlIII);
                    return false;
                }
            }
        }
        this.key[lllllllllllllIIIlIlIllIlIllIlIII] = lllllllllllllIIIlIlIllIlIllIIllI;
        if (this.size == 0) {
            final int n = lllllllllllllIIIlIlIllIlIllIlIII;
            this.last = n;
            this.first = n;
            this.link[lllllllllllllIIIlIlIllIlIllIlIII] = -1L;
        }
        else {
            final long[] link = this.link;
            final int first = this.first;
            link[first] ^= ((this.link[this.first] ^ ((long)lllllllllllllIIIlIlIllIlIllIlIII & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[lllllllllllllIIIlIlIllIlIllIlIII] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
            this.first = lllllllllllllIIIlIlIllIlIllIlIII;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return true;
    }
    
    public IntLinkedOpenHashSet(final Iterator<?> lllllllllllllIIIlIlIlllIIIllllll, final float lllllllllllllIIIlIlIlllIIIlllllI) {
        this(IntIterators.asIntIterator(lllllllllllllIIIlIlIlllIIIllllll), lllllllllllllIIIlIlIlllIIIlllllI);
    }
    
    @Override
    public boolean addAll(final Collection<? extends Integer> lllllllllllllIIIlIlIllIllllIlIlI) {
        if (this.f <= 0.5) {
            this.ensureCapacity(lllllllllllllIIIlIlIllIllllIlIlI.size());
        }
        else {
            this.tryCapacity(this.size() + lllllllllllllIIIlIlIllIllllIlIlI.size());
        }
        return super.addAll(lllllllllllllIIIlIlIllIllllIlIlI);
    }
    
    @Override
    public boolean add(final int lllllllllllllIIIlIlIllIllllIIIII) {
        int lllllllllllllIIIlIlIllIlllIlllll = 0;
        if (lllllllllllllIIIlIlIllIllllIIIII == 0) {
            if (this.containsNull) {
                return false;
            }
            final int lllllllllllllIIIlIlIllIllllIIlII = this.n;
            this.containsNull = true;
        }
        else {
            final int[] lllllllllllllIIIlIlIllIllllIIIlI = this.key;
            int lllllllllllllIIIlIlIllIllllIIIll;
            if ((lllllllllllllIIIlIlIllIllllIIIll = lllllllllllllIIIlIlIllIllllIIIlI[lllllllllllllIIIlIlIllIlllIlllll = (HashCommon.mix(lllllllllllllIIIlIlIllIllllIIIII) & this.mask)]) != 0) {
                if (lllllllllllllIIIlIlIllIllllIIIll == lllllllllllllIIIlIlIllIllllIIIII) {
                    return false;
                }
                while ((lllllllllllllIIIlIlIllIllllIIIll = lllllllllllllIIIlIlIllIllllIIIlI[lllllllllllllIIIlIlIllIlllIlllll = (lllllllllllllIIIlIlIllIlllIlllll + 1 & this.mask)]) != 0) {
                    if (lllllllllllllIIIlIlIllIllllIIIll == lllllllllllllIIIlIlIllIllllIIIII) {
                        return false;
                    }
                }
            }
            lllllllllllllIIIlIlIllIllllIIIlI[lllllllllllllIIIlIlIllIlllIlllll] = lllllllllllllIIIlIlIllIllllIIIII;
        }
        if (this.size == 0) {
            final int n = lllllllllllllIIIlIlIllIlllIlllll;
            this.last = n;
            this.first = n;
            this.link[lllllllllllllIIIlIlIllIlllIlllll] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIIlIlIllIlllIlllll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIIlIlIllIlllIlllll] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = lllllllllllllIIIlIlIllIlllIlllll;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return true;
    }
    
    public IntLinkedOpenHashSet(final IntIterator lllllllllllllIIIlIlIlllIIlIIlllI, final float lllllllllllllIIIlIlIlllIIlIIllIl) {
        this(16, lllllllllllllIIIlIlIlllIIlIIllIl);
        while (lllllllllllllIIIlIlIlllIIlIIlllI.hasNext()) {
            this.add(lllllllllllllIIIlIlIlllIIlIIlllI.nextInt());
        }
    }
    
    @Override
    public boolean remove(final int lllllllllllllIIIlIlIllIllIlllIII) {
        if (lllllllllllllIIIlIlIllIllIlllIII == 0) {
            return this.containsNull && this.removeNullEntry();
        }
        final int[] lllllllllllllIIIlIlIllIllIllIllI = this.key;
        int lllllllllllllIIIlIlIllIllIllIlIl;
        int lllllllllllllIIIlIlIllIllIllIlll;
        if ((lllllllllllllIIIlIlIllIllIllIlll = lllllllllllllIIIlIlIllIllIllIllI[lllllllllllllIIIlIlIllIllIllIlIl = (HashCommon.mix(lllllllllllllIIIlIlIllIllIlllIII) & this.mask)]) == 0) {
            return false;
        }
        if (lllllllllllllIIIlIlIllIllIlllIII == lllllllllllllIIIlIlIllIllIllIlll) {
            return this.removeEntry(lllllllllllllIIIlIlIllIllIllIlIl);
        }
        while ((lllllllllllllIIIlIlIllIllIllIlll = lllllllllllllIIIlIlIllIllIllIllI[lllllllllllllIIIlIlIllIllIllIlIl = (lllllllllllllIIIlIlIllIllIllIlIl + 1 & this.mask)]) != 0) {
            if (lllllllllllllIIIlIlIllIllIlllIII == lllllllllllllIIIlIlIllIllIllIlll) {
                return this.removeEntry(lllllllllllllIIIlIlIllIllIllIlIl);
            }
        }
        return false;
    }
    
    public IntLinkedOpenHashSet(final int lllllllllllllIIIlIlIlllIIlllIlll) {
        this(lllllllllllllIIIlIlIlllIIlllIlll, 0.75f);
    }
    
    @Override
    public boolean contains(final int lllllllllllllIIIlIlIllIllIlIIlII) {
        if (lllllllllllllIIIlIlIllIllIlIIlII == 0) {
            return this.containsNull;
        }
        final int[] lllllllllllllIIIlIlIllIllIlIIlll = this.key;
        int lllllllllllllIIIlIlIllIllIlIIllI;
        int lllllllllllllIIIlIlIllIllIlIlIII;
        if ((lllllllllllllIIIlIlIllIllIlIlIII = lllllllllllllIIIlIlIllIllIlIIlll[lllllllllllllIIIlIlIllIllIlIIllI = (HashCommon.mix(lllllllllllllIIIlIlIllIllIlIIlII) & this.mask)]) == 0) {
            return false;
        }
        if (lllllllllllllIIIlIlIllIllIlIIlII == lllllllllllllIIIlIlIllIllIlIlIII) {
            return true;
        }
        while ((lllllllllllllIIIlIlIllIllIlIlIII = lllllllllllllIIIlIlIllIllIlIIlll[lllllllllllllIIIlIlIllIllIlIIllI = (lllllllllllllIIIlIlIllIllIlIIllI + 1 & this.mask)]) != 0) {
            if (lllllllllllllIIIlIlIllIllIlIIlII == lllllllllllllIIIlIlIllIllIlIlIII) {
                return true;
            }
        }
        return false;
    }
    
    public IntLinkedOpenHashSet(final int[] lllllllllllllIIIlIlIlllIIIIlIIlI, final float lllllllllllllIIIlIlIlllIIIIlIIIl) {
        this(lllllllllllllIIIlIlIlllIIIIlIIlI, 0, lllllllllllllIIIlIlIlllIIIIlIIlI.length, lllllllllllllIIIlIlIlllIIIIlIIIl);
    }
    
    public int removeFirstInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int lllllllllllllIIIlIlIllIllIIlllII = this.first;
        this.first = (int)this.link[lllllllllllllIIIlIlIllIllIIlllII];
        if (0 <= this.first) {
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        final int lllllllllllllIIIlIlIllIllIIllIll = this.key[lllllllllllllIIIlIlIllIllIIlllII];
        --this.size;
        if (lllllllllllllIIIlIlIllIllIIllIll == 0) {
            this.containsNull = false;
            this.key[this.n] = 0;
        }
        else {
            this.shiftKeys(lllllllllllllIIIlIlIllIllIIlllII);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIIlIlIllIllIIllIll;
    }
    
    public IntLinkedOpenHashSet(final Iterator<?> lllllllllllllIIIlIlIlllIIIlllIII) {
        this(IntIterators.asIntIterator(lllllllllllllIIIlIlIlllIIIlllIII));
    }
    
    private void tryCapacity(final long lllllllllllllIIIlIlIllIlllllIlll) {
        final int lllllllllllllIIIlIlIllIllllllIIl = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(lllllllllllllIIIlIlIllIlllllIlll / this.f))));
        if (lllllllllllllIIIlIlIllIllllllIIl > this.n) {
            this.rehash(lllllllllllllIIIlIlIllIllllllIIl);
        }
    }
    
    public IntLinkedOpenHashSet(final Collection<? extends Integer> lllllllllllllIIIlIlIlllIIllIIlll) {
        this(lllllllllllllIIIlIlIlllIIllIIlll, 0.75f);
    }
    
    private void readObject(final ObjectInputStream lllllllllllllIIIlIlIllIIlIlIllll) throws ClassNotFoundException, IOException {
        lllllllllllllIIIlIlIllIIlIlIllll.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final int[] key = new int[this.n + 1];
        this.key = key;
        final int[] lllllllllllllIIIlIlIllIIlIlIlllI = key;
        final long[] link = new long[this.n + 1];
        this.link = link;
        final long[] lllllllllllllIIIlIlIllIIlIlIllIl = link;
        int lllllllllllllIIIlIlIllIIlIlIllII = -1;
        final int n = -1;
        this.last = n;
        this.first = n;
        int lllllllllllllIIIlIlIllIIlIllIIlI = this.size;
        while (lllllllllllllIIIlIlIllIIlIllIIlI-- != 0) {
            final int lllllllllllllIIIlIlIllIIlIllIIll = lllllllllllllIIIlIlIllIIlIlIllll.readInt();
            int lllllllllllllIIIlIlIllIIlIllIIIl = 0;
            if (lllllllllllllIIIlIlIllIIlIllIIll == 0) {
                final int lllllllllllllIIIlIlIllIIlIllIlII = this.n;
                this.containsNull = true;
            }
            else if (lllllllllllllIIIlIlIllIIlIlIlllI[lllllllllllllIIIlIlIllIIlIllIIIl = (HashCommon.mix(lllllllllllllIIIlIlIllIIlIllIIll) & this.mask)] != 0) {
                while (lllllllllllllIIIlIlIllIIlIlIlllI[lllllllllllllIIIlIlIllIIlIllIIIl = (lllllllllllllIIIlIlIllIIlIllIIIl + 1 & this.mask)] != 0) {}
            }
            lllllllllllllIIIlIlIllIIlIlIlllI[lllllllllllllIIIlIlIllIIlIllIIIl] = lllllllllllllIIIlIlIllIIlIllIIll;
            if (this.first != -1) {
                final long[] array = lllllllllllllIIIlIlIllIIlIlIllIl;
                final int n2 = lllllllllllllIIIlIlIllIIlIlIllII;
                array[n2] ^= ((lllllllllllllIIIlIlIllIIlIlIllIl[lllllllllllllIIIlIlIllIIlIlIllII] ^ ((long)lllllllllllllIIIlIlIllIIlIllIIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = lllllllllllllIIIlIlIllIIlIlIllIl;
                final int n3 = lllllllllllllIIIlIlIllIIlIllIIIl;
                array2[n3] ^= ((lllllllllllllIIIlIlIllIIlIlIllIl[lllllllllllllIIIlIlIllIIlIllIIIl] ^ ((long)lllllllllllllIIIlIlIllIIlIlIllII & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                lllllllllllllIIIlIlIllIIlIlIllII = lllllllllllllIIIlIlIllIIlIllIIIl;
            }
            else {
                final int first = lllllllllllllIIIlIlIllIIlIllIIIl;
                this.first = first;
                lllllllllllllIIIlIlIllIIlIlIllII = first;
                final long[] array3 = lllllllllllllIIIlIlIllIIlIlIllIl;
                final int n4 = lllllllllllllIIIlIlIllIIlIllIIIl;
                array3[n4] |= 0xFFFFFFFF00000000L;
            }
        }
        if ((this.last = lllllllllllllIIIlIlIllIIlIlIllII) != -1) {
            final long[] array4 = lllllllllllllIIIlIlIllIIlIlIllIl;
            final int n5 = lllllllllllllIIIlIlIllIIlIlIllII;
            array4[n5] |= 0xFFFFFFFFL;
        }
    }
    
    protected void fixPointers(final int lllllllllllllIIIlIlIllIlIIllIlll, final int lllllllllllllIIIlIlIllIlIIllIllI) {
        if (this.size == 1) {
            this.last = lllllllllllllIIIlIlIllIlIIllIllI;
            this.first = lllllllllllllIIIlIlIllIlIIllIllI;
            this.link[lllllllllllllIIIlIlIllIlIIllIllI] = -1L;
            return;
        }
        if (this.first == lllllllllllllIIIlIlIllIlIIllIlll) {
            this.first = lllllllllllllIIIlIlIllIlIIllIllI;
            final long[] link = this.link;
            final int n = (int)this.link[lllllllllllllIIIlIlIllIlIIllIlll];
            link[n] ^= ((this.link[(int)this.link[lllllllllllllIIIlIlIllIlIIllIlll]] ^ ((long)lllllllllllllIIIlIlIllIlIIllIllI & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[lllllllllllllIIIlIlIllIlIIllIllI] = this.link[lllllllllllllIIIlIlIllIlIIllIlll];
            return;
        }
        if (this.last == lllllllllllllIIIlIlIllIlIIllIlll) {
            this.last = lllllllllllllIIIlIlIllIlIIllIllI;
            final long[] link2 = this.link;
            final int n2 = (int)(this.link[lllllllllllllIIIlIlIllIlIIllIlll] >>> 32);
            link2[n2] ^= ((this.link[(int)(this.link[lllllllllllllIIIlIlIllIlIIllIlll] >>> 32)] ^ ((long)lllllllllllllIIIlIlIllIlIIllIllI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIIlIlIllIlIIllIllI] = this.link[lllllllllllllIIIlIlIllIlIIllIlll];
            return;
        }
        final long lllllllllllllIIIlIlIllIlIIllIlIl = this.link[lllllllllllllIIIlIlIllIlIIllIlll];
        final int lllllllllllllIIIlIlIllIlIIllIlII = (int)(lllllllllllllIIIlIlIllIlIIllIlIl >>> 32);
        final int lllllllllllllIIIlIlIllIlIIllIIll = (int)lllllllllllllIIIlIlIllIlIIllIlIl;
        final long[] link3 = this.link;
        final int n3 = lllllllllllllIIIlIlIllIlIIllIlII;
        link3[n3] ^= ((this.link[lllllllllllllIIIlIlIllIlIIllIlII] ^ ((long)lllllllllllllIIIlIlIllIlIIllIllI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n4 = lllllllllllllIIIlIlIllIlIIllIIll;
        link4[n4] ^= ((this.link[lllllllllllllIIIlIlIllIlIIllIIll] ^ ((long)lllllllllllllIIIlIlIllIlIIllIllI & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[lllllllllllllIIIlIlIllIlIIllIllI] = lllllllllllllIIIlIlIllIlIIllIlIl;
    }
    
    public IntLinkedOpenHashSet(final IntCollection lllllllllllllIIIlIlIlllIIlIlIllI) {
        this(lllllllllllllIIIlIlIlllIIlIlIllI, 0.75f);
    }
    
    private void ensureCapacity(final int lllllllllllllIIIlIlIlllIIIIIIIII) {
        final int lllllllllllllIIIlIlIlllIIIIIIIlI = HashCommon.arraySize(lllllllllllllIIIlIlIlllIIIIIIIII, this.f);
        if (lllllllllllllIIIlIlIlllIIIIIIIlI > this.n) {
            this.rehash(lllllllllllllIIIlIlIlllIIIIIIIlI);
        }
    }
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNull = false;
        Arrays.fill(this.key, 0);
        final int n = -1;
        this.last = n;
        this.first = n;
    }
    
    public boolean trim(final int lllllllllllllIIIlIlIllIlIIIIlIIl) {
        final int lllllllllllllIIIlIlIllIlIIIIlIll = HashCommon.nextPowerOfTwo((int)Math.ceil(lllllllllllllIIIlIlIllIlIIIIlIIl / this.f));
        if (lllllllllllllIIIlIlIllIlIIIIlIll >= this.n || this.size > HashCommon.maxFill(lllllllllllllIIIlIlIllIlIIIIlIll, this.f)) {
            return true;
        }
        try {
            this.rehash(lllllllllllllIIIlIlIllIlIIIIlIll);
        }
        catch (OutOfMemoryError lllllllllllllIIIlIlIllIlIIIIlllI) {
            return false;
        }
        return true;
    }
    
    protected final void shiftKeys(int lllllllllllllIIIlIlIllIlllIIllII) {
        final int[] lllllllllllllIIIlIlIllIlllIIlllI = this.key;
        int lllllllllllllIIIlIlIllIlllIlIIIl = 0;
    Label_0006:
        while (true) {
            lllllllllllllIIIlIlIllIlllIIllII = ((lllllllllllllIIIlIlIllIlllIlIIIl = (int)lllllllllllllIIIlIlIllIlllIIllII) + 1 & this.mask);
            int lllllllllllllIIIlIlIllIlllIIllll;
            while ((lllllllllllllIIIlIlIllIlllIIllll = lllllllllllllIIIlIlIllIlllIIlllI[lllllllllllllIIIlIlIllIlllIIllII]) != 0) {
                final int lllllllllllllIIIlIlIllIlllIlIIII = HashCommon.mix(lllllllllllllIIIlIlIllIlllIIllll) & this.mask;
                Label_0087: {
                    if (lllllllllllllIIIlIlIllIlllIlIIIl <= lllllllllllllIIIlIlIllIlllIIllII) {
                        if (lllllllllllllIIIlIlIllIlllIlIIIl >= lllllllllllllIIIlIlIllIlllIlIIII) {
                            break Label_0087;
                        }
                        if (lllllllllllllIIIlIlIllIlllIlIIII > lllllllllllllIIIlIlIllIlllIIllII) {
                            break Label_0087;
                        }
                    }
                    else if (lllllllllllllIIIlIlIllIlllIlIIIl >= lllllllllllllIIIlIlIllIlllIlIIII && lllllllllllllIIIlIlIllIlllIlIIII > lllllllllllllIIIlIlIllIlllIIllII) {
                        break Label_0087;
                    }
                    lllllllllllllIIIlIlIllIlllIIllII = (lllllllllllllIIIlIlIllIlllIIllII + 1 & this.mask);
                    continue;
                }
                lllllllllllllIIIlIlIllIlllIIlllI[lllllllllllllIIIlIlIllIlllIlIIIl] = lllllllllllllIIIlIlIllIlllIIllll;
                this.fixPointers((int)lllllllllllllIIIlIlIllIlllIIllII, lllllllllllllIIIlIlIllIlllIlIIIl);
                continue Label_0006;
            }
            break;
        }
        lllllllllllllIIIlIlIllIlllIIlllI[lllllllllllllIIIlIlIllIlllIlIIIl] = 0;
    }
    
    public IntLinkedOpenHashSet(final int lllllllllllllIIIlIlIlllIIllllllI, final float lllllllllllllIIIlIlIlllIIlllllIl) {
        this.first = -1;
        this.last = -1;
        if (lllllllllllllIIIlIlIlllIIlllllIl <= 0.0f || lllllllllllllIIIlIlIlllIIlllllIl > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (lllllllllllllIIIlIlIlllIIllllllI < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = lllllllllllllIIIlIlIlllIIlllllIl;
        final int arraySize = HashCommon.arraySize(lllllllllllllIIIlIlIlllIIllllllI, lllllllllllllIIIlIlIlllIIlllllIl);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, lllllllllllllIIIlIlIlllIIlllllIl);
        this.key = new int[this.n + 1];
        this.link = new long[this.n + 1];
    }
    
    public int removeLastInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int lllllllllllllIIIlIlIllIllIIlIIll = this.last;
        this.last = (int)(this.link[lllllllllllllIIIlIlIllIllIIlIIll] >>> 32);
        if (0 <= this.last) {
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        final int lllllllllllllIIIlIlIllIllIIlIIlI = this.key[lllllllllllllIIIlIlIllIllIIlIIll];
        --this.size;
        if (lllllllllllllIIIlIlIllIllIIlIIlI == 0) {
            this.containsNull = false;
            this.key[this.n] = 0;
        }
        else {
            this.shiftKeys(lllllllllllllIIIlIlIllIllIIlIIll);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllIIIlIlIllIllIIlIIlI;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public IntComparator comparator() {
        return null;
    }
    
    public IntLinkedOpenHashSet(final IntIterator lllllllllllllIIIlIlIlllIIlIIlIIl) {
        this(lllllllllllllIIIlIlIlllIIlIIlIIl, 0.75f);
    }
    
    private void moveIndexToLast(final int lllllllllllllIIIlIlIllIlIlllIllI) {
        if (this.size == 1 || this.last == lllllllllllllIIIlIlIllIlIlllIllI) {
            return;
        }
        if (this.first == lllllllllllllIIIlIlIllIlIlllIllI) {
            this.first = (int)this.link[lllllllllllllIIIlIlIllIlIlllIllI];
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        else {
            final long lllllllllllllIIIlIlIllIlIllllIlI = this.link[lllllllllllllIIIlIlIllIlIlllIllI];
            final int lllllllllllllIIIlIlIllIlIllllIIl = (int)(lllllllllllllIIIlIlIllIlIllllIlI >>> 32);
            final int lllllllllllllIIIlIlIllIlIllllIII = (int)lllllllllllllIIIlIlIllIlIllllIlI;
            final long[] link2 = this.link;
            final int n = lllllllllllllIIIlIlIllIlIllllIIl;
            link2[n] ^= ((this.link[lllllllllllllIIIlIlIllIlIllllIIl] ^ (lllllllllllllIIIlIlIllIlIllllIlI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = lllllllllllllIIIlIlIllIlIllllIII;
            link3[n2] ^= ((this.link[lllllllllllllIIIlIlIllIlIllllIII] ^ (lllllllllllllIIIlIlIllIlIllllIlI & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int last = this.last;
        link4[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIIlIlIllIlIlllIllI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        this.link[lllllllllllllIIIlIlIllIlIlllIllI] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
        this.last = lllllllllllllIIIlIlIllIlIlllIllI;
    }
    
    @Override
    public IntSortedSet subSet(final int lllllllllllllIIIlIlIllIlIIlIIIIl, final int lllllllllllllIIIlIlIllIlIIlIIIII) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public IntListIterator iterator() {
        return new SetIterator();
    }
    
    @Override
    public IntSortedSet tailSet(final int lllllllllllllIIIlIlIllIlIIlIIlIl) {
        throw new UnsupportedOperationException();
    }
    
    public IntLinkedOpenHashSet(final Collection<? extends Integer> lllllllllllllIIIlIlIlllIIllIllII, final float lllllllllllllIIIlIlIlllIIllIlllI) {
        this(lllllllllllllIIIlIlIlllIIllIllII.size(), lllllllllllllIIIlIlIlllIIllIlllI);
        this.addAll(lllllllllllllIIIlIlIlllIIllIllII);
    }
    
    private void moveIndexToFirst(final int lllllllllllllIIIlIlIllIllIIIIIll) {
        if (this.size == 1 || this.first == lllllllllllllIIIlIlIllIllIIIIIll) {
            return;
        }
        if (this.last == lllllllllllllIIIlIlIllIllIIIIIll) {
            this.last = (int)(this.link[lllllllllllllIIIlIlIllIllIIIIIll] >>> 32);
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        else {
            final long lllllllllllllIIIlIlIllIllIIIlIIl = this.link[lllllllllllllIIIlIlIllIllIIIIIll];
            final int lllllllllllllIIIlIlIllIllIIIlIII = (int)(lllllllllllllIIIlIlIllIllIIIlIIl >>> 32);
            final int lllllllllllllIIIlIlIllIllIIIIlll = (int)lllllllllllllIIIlIlIllIllIIIlIIl;
            final long[] link2 = this.link;
            final int n = lllllllllllllIIIlIlIllIllIIIlIII;
            link2[n] ^= ((this.link[lllllllllllllIIIlIlIllIllIIIlIII] ^ (lllllllllllllIIIlIlIllIllIIIlIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = lllllllllllllIIIlIlIllIllIIIIlll;
            link3[n2] ^= ((this.link[lllllllllllllIIIlIlIllIllIIIIlll] ^ (lllllllllllllIIIlIlIllIllIIIlIIl & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int first = this.first;
        link4[first] ^= ((this.link[this.first] ^ ((long)lllllllllllllIIIlIlIllIllIIIIIll & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[lllllllllllllIIIlIlIllIllIIIIIll] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
        this.first = lllllllllllllIIIlIlIllIllIIIIIll;
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllIIIlIlIllIIllIIIIlI) throws IOException {
        final IntIterator lllllllllllllIIIlIlIllIIllIIIIIl = this.iterator();
        lllllllllllllIIIlIlIllIIllIIIIlI.defaultWriteObject();
        int lllllllllllllIIIlIlIllIIllIIIlII = this.size;
        while (lllllllllllllIIIlIlIllIIllIIIlII-- != 0) {
            lllllllllllllIIIlIlIllIIllIIIIlI.writeInt(lllllllllllllIIIlIlIllIIllIIIIIl.nextInt());
        }
    }
    
    protected void rehash(final int lllllllllllllIIIlIlIllIIlllIlIlI) {
        final int[] lllllllllllllIIIlIlIllIIllllIIll = this.key;
        final int lllllllllllllIIIlIlIllIIllllIIlI = lllllllllllllIIIlIlIllIIlllIlIlI - 1;
        final int[] lllllllllllllIIIlIlIllIIllllIIIl = new int[lllllllllllllIIIlIlIllIIlllIlIlI + 1];
        int lllllllllllllIIIlIlIllIIllllIIII = this.first;
        int lllllllllllllIIIlIlIllIIlllIllll = -1;
        int lllllllllllllIIIlIlIllIIlllIlllI = -1;
        final long[] lllllllllllllIIIlIlIllIIlllIllIl = this.link;
        final long[] lllllllllllllIIIlIlIllIIlllIllII = new long[lllllllllllllIIIlIlIllIIlllIlIlI + 1];
        this.first = -1;
        int lllllllllllllIIIlIlIllIIllllIllI = this.size;
        while (lllllllllllllIIIlIlIllIIllllIllI-- != 0) {
            int lllllllllllllIIIlIlIllIIllllIlll = 0;
            if (lllllllllllllIIIlIlIllIIllllIIll[lllllllllllllIIIlIlIllIIllllIIII] == 0) {
                final int lllllllllllllIIIlIlIllIIlllllIIl = lllllllllllllIIIlIlIllIIlllIlIlI;
            }
            else {
                for (lllllllllllllIIIlIlIllIIllllIlll = (HashCommon.mix(lllllllllllllIIIlIlIllIIllllIIll[lllllllllllllIIIlIlIllIIllllIIII]) & lllllllllllllIIIlIlIllIIllllIIlI); lllllllllllllIIIlIlIllIIllllIIIl[lllllllllllllIIIlIlIllIIllllIlll] != 0; lllllllllllllIIIlIlIllIIllllIlll = (lllllllllllllIIIlIlIllIIllllIlll + 1 & lllllllllllllIIIlIlIllIIllllIIlI)) {}
            }
            lllllllllllllIIIlIlIllIIllllIIIl[lllllllllllllIIIlIlIllIIllllIlll] = lllllllllllllIIIlIlIllIIllllIIll[lllllllllllllIIIlIlIllIIllllIIII];
            if (lllllllllllllIIIlIlIllIIlllIllll != -1) {
                final long[] array = lllllllllllllIIIlIlIllIIlllIllII;
                final int n = lllllllllllllIIIlIlIllIIlllIlllI;
                array[n] ^= ((lllllllllllllIIIlIlIllIIlllIllII[lllllllllllllIIIlIlIllIIlllIlllI] ^ ((long)lllllllllllllIIIlIlIllIIllllIlll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = lllllllllllllIIIlIlIllIIlllIllII;
                final int n2 = lllllllllllllIIIlIlIllIIllllIlll;
                array2[n2] ^= ((lllllllllllllIIIlIlIllIIlllIllII[lllllllllllllIIIlIlIllIIllllIlll] ^ ((long)lllllllllllllIIIlIlIllIIlllIlllI & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                lllllllllllllIIIlIlIllIIlllIlllI = lllllllllllllIIIlIlIllIIllllIlll;
            }
            else {
                final int first = lllllllllllllIIIlIlIllIIllllIlll;
                this.first = first;
                lllllllllllllIIIlIlIllIIlllIlllI = first;
                lllllllllllllIIIlIlIllIIlllIllII[lllllllllllllIIIlIlIllIIllllIlll] = -1L;
            }
            final int lllllllllllllIIIlIlIllIIlllllIII = lllllllllllllIIIlIlIllIIllllIIII;
            lllllllllllllIIIlIlIllIIllllIIII = (int)lllllllllllllIIIlIlIllIIlllIllIl[lllllllllllllIIIlIlIllIIllllIIII];
            lllllllllllllIIIlIlIllIIlllIllll = lllllllllllllIIIlIlIllIIlllllIII;
        }
        this.link = lllllllllllllIIIlIlIllIIlllIllII;
        if ((this.last = lllllllllllllIIIlIlIllIIlllIlllI) != -1) {
            final long[] array3 = lllllllllllllIIIlIlIllIIlllIllII;
            final int n3 = lllllllllllllIIIlIlIllIIlllIlllI;
            array3[n3] |= 0xFFFFFFFFL;
        }
        this.n = lllllllllllllIIIlIlIllIIlllIlIlI;
        this.mask = lllllllllllllIIIlIlIllIIllllIIlI;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = lllllllllllllIIIlIlIllIIllllIIIl;
    }
    
    public IntLinkedOpenHashSet(final IntCollection lllllllllllllIIIlIlIlllIIllIIIII, final float lllllllllllllIIIlIlIlllIIlIlllll) {
        this(lllllllllllllIIIlIlIlllIIllIIIII.size(), lllllllllllllIIIlIlIlllIIlIlllll);
        this.addAll(lllllllllllllIIIlIlIlllIIllIIIII);
    }
    
    @Override
    public boolean addAll(final IntCollection lllllllllllllIIIlIlIllIlllllIIII) {
        if (this.f <= 0.5) {
            this.ensureCapacity(lllllllllllllIIIlIlIllIlllllIIII.size());
        }
        else {
            this.tryCapacity(this.size() + lllllllllllllIIIlIlIllIlllllIIII.size());
        }
        return super.addAll(lllllllllllllIIIlIlIllIlllllIIII);
    }
    
    public IntLinkedOpenHashSet() {
        this(16, 0.75f);
    }
    
    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.n] = 0;
        --this.size;
        this.fixPointers(this.n);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }
    
    public IntLinkedOpenHashSet clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/ints/IntLinkedOpenHashSet;
        //     7: astore_1        /* lllllllllllllIIIlIlIllIIllIlIllI */
        //     8: goto            20
        //    11: astore_2        /* lllllllllllllIIIlIlIllIIllIlIlIl */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllllIIIlIlIllIIllIllIII */
        //    21: aload_0         /* lllllllllllllIIIlIlIllIIllIllIIl */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/ints/IntLinkedOpenHashSet.key:[I
        //    25: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    28: checkcast       [I
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/ints/IntLinkedOpenHashSet.key:[I
        //    34: aload_1         /* lllllllllllllIIIlIlIllIIllIllIII */
        //    35: aload_0         /* lllllllllllllIIIlIlIllIIllIllIIl */
        //    36: getfield        com/viaversion/viaversion/libs/fastutil/ints/IntLinkedOpenHashSet.containsNull:Z
        //    39: putfield        com/viaversion/viaversion/libs/fastutil/ints/IntLinkedOpenHashSet.containsNull:Z
        //    42: aload_1         /* lllllllllllllIIIlIlIllIIllIllIII */
        //    43: aload_0         /* lllllllllllllIIIlIlIllIIllIllIIl */
        //    44: getfield        com/viaversion/viaversion/libs/fastutil/ints/IntLinkedOpenHashSet.link:[J
        //    47: invokevirtual   [J.clone:()Ljava/lang/Object;
        //    50: checkcast       [J
        //    53: putfield        com/viaversion/viaversion/libs/fastutil/ints/IntLinkedOpenHashSet.link:[J
        //    56: aload_1         /* lllllllllllllIIIlIlIllIIllIllIII */
        //    57: areturn        
        //    StackMapTable: 00 02 4B 07 02 06 FC 00 08 07 00 02
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
    
    static {
        ASSERTS = false;
    }
    
    private void checkTable() {
    }
    
    private int realSize() {
        return this.containsNull ? (this.size - 1) : this.size;
    }
    
    public IntLinkedOpenHashSet(final int[] lllllllllllllIIIlIlIlllIIIIIllIl) {
        this(lllllllllllllIIIlIlIlllIIIIIllIl, 0.75f);
    }
    
    @Override
    public int firstInt() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.first];
    }
    
    public IntLinkedOpenHashSet(final int[] lllllllllllllIIIlIlIlllIIIlIIIII, final int lllllllllllllIIIlIlIlllIIIIllIll, final int lllllllllllllIIIlIlIlllIIIIllllI) {
        this(lllllllllllllIIIlIlIlllIIIlIIIII, lllllllllllllIIIlIlIlllIIIIllIll, lllllllllllllIIIlIlIlllIIIIllllI, 0.75f);
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    public IntLinkedOpenHashSet(final int[] lllllllllllllIIIlIlIlllIIIlIllll, final int lllllllllllllIIIlIlIlllIIIlIlllI, final int lllllllllllllIIIlIlIlllIIIlIllIl, final float lllllllllllllIIIlIlIlllIIIlIIlll) {
        this((lllllllllllllIIIlIlIlllIIIlIllIl < 0) ? 0 : lllllllllllllIIIlIlIlllIIIlIllIl, lllllllllllllIIIlIlIlllIIIlIIlll);
        IntArrays.ensureOffsetLength(lllllllllllllIIIlIlIlllIIIlIllll, lllllllllllllIIIlIlIlllIIIlIlllI, lllllllllllllIIIlIlIlllIIIlIllIl);
        for (int lllllllllllllIIIlIlIlllIIIllIIIl = 0; lllllllllllllIIIlIlIlllIIIllIIIl < lllllllllllllIIIlIlIlllIIIlIllIl; ++lllllllllllllIIIlIlIlllIIIllIIIl) {
            this.add(lllllllllllllIIIlIlIlllIIIlIllll[lllllllllllllIIIlIlIlllIIIlIlllI + lllllllllllllIIIlIlIlllIIIllIIIl]);
        }
    }
    
    public boolean addAndMoveToLast(final int lllllllllllllIIIlIlIllIlIlIllIIl) {
        int lllllllllllllIIIlIlIllIlIlIllIll = 0;
        if (lllllllllllllIIIlIlIllIlIlIllIIl == 0) {
            if (this.containsNull) {
                this.moveIndexToLast(this.n);
                return false;
            }
            this.containsNull = true;
            final int lllllllllllllIIIlIlIllIlIlIlllll = this.n;
        }
        else {
            int[] lllllllllllllIIIlIlIllIlIlIllllI;
            for (lllllllllllllIIIlIlIllIlIlIllllI = this.key, lllllllllllllIIIlIlIllIlIlIllIll = (HashCommon.mix(lllllllllllllIIIlIlIllIlIlIllIIl) & this.mask); lllllllllllllIIIlIlIllIlIlIllllI[lllllllllllllIIIlIlIllIlIlIllIll] != 0; lllllllllllllIIIlIlIllIlIlIllIll = (lllllllllllllIIIlIlIllIlIlIllIll + 1 & this.mask)) {
                if (lllllllllllllIIIlIlIllIlIlIllIIl == lllllllllllllIIIlIlIllIlIlIllllI[lllllllllllllIIIlIlIllIlIlIllIll]) {
                    this.moveIndexToLast(lllllllllllllIIIlIlIllIlIlIllIll);
                    return false;
                }
            }
        }
        this.key[lllllllllllllIIIlIlIllIlIlIllIll] = lllllllllllllIIIlIlIllIlIlIllIIl;
        if (this.size == 0) {
            final int n = lllllllllllllIIIlIlIllIlIlIllIll;
            this.last = n;
            this.first = n;
            this.link[lllllllllllllIIIlIlIllIlIlIllIll] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)lllllllllllllIIIlIlIllIlIlIllIll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[lllllllllllllIIIlIlIllIlIlIllIll] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = lllllllllllllIIIlIlIllIlIlIllIll;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return true;
    }
    
    protected void fixPointers(final int lllllllllllllIIIlIlIllIlIlIIIIlI) {
        if (this.size == 0) {
            final int n = -1;
            this.last = n;
            this.first = n;
            return;
        }
        if (this.first == lllllllllllllIIIlIlIllIlIlIIIIlI) {
            this.first = (int)this.link[lllllllllllllIIIlIlIllIlIlIIIIlI];
            if (0 <= this.first) {
                final long[] link = this.link;
                final int first = this.first;
                link[first] |= 0xFFFFFFFF00000000L;
            }
            return;
        }
        if (this.last == lllllllllllllIIIlIlIllIlIlIIIIlI) {
            this.last = (int)(this.link[lllllllllllllIIIlIlIllIlIlIIIIlI] >>> 32);
            if (0 <= this.last) {
                final long[] link2 = this.link;
                final int last = this.last;
                link2[last] |= 0xFFFFFFFFL;
            }
            return;
        }
        final long lllllllllllllIIIlIlIllIlIlIIIllI = this.link[lllllllllllllIIIlIlIllIlIlIIIIlI];
        final int lllllllllllllIIIlIlIllIlIlIIIlIl = (int)(lllllllllllllIIIlIlIllIlIlIIIllI >>> 32);
        final int lllllllllllllIIIlIlIllIlIlIIIlII = (int)lllllllllllllIIIlIlIllIlIlIIIllI;
        final long[] link3 = this.link;
        final int n2 = lllllllllllllIIIlIlIllIlIlIIIlIl;
        link3[n2] ^= ((this.link[lllllllllllllIIIlIlIllIlIlIIIlIl] ^ (lllllllllllllIIIlIlIllIlIlIIIllI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n3 = lllllllllllllIIIlIlIllIlIlIIIlII;
        link4[n3] ^= ((this.link[lllllllllllllIIIlIlIllIlIlIIIlII] ^ (lllllllllllllIIIlIlIllIlIlIIIllI & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
    }
    
    @Override
    public IntListIterator iterator(final int lllllllllllllIIIlIlIllIlIIIllIll) {
        return new SetIterator(lllllllllllllIIIlIlIllIlIIIllIll);
    }
    
    private class SetIterator implements IntListIterator
    {
        /* synthetic */ int prev;
        /* synthetic */ int curr;
        /* synthetic */ int next;
        /* synthetic */ int index;
        
        SetIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = IntLinkedOpenHashSet.this.first;
            this.index = 0;
        }
        
        @Override
        public boolean hasNext() {
            return this.next != -1;
        }
        
        @Override
        public int nextIndex() {
            this.ensureIndexKnown();
            return this.index;
        }
        
        SetIterator(final int llllllllllllllIIlIlIIlIlIIlIIlIl) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (llllllllllllllIIlIlIIlIlIIlIIlIl == 0) {
                if (IntLinkedOpenHashSet.this.containsNull) {
                    this.next = (int)IntLinkedOpenHashSet.this.link[IntLinkedOpenHashSet.this.n];
                    this.prev = IntLinkedOpenHashSet.this.n;
                    return;
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(llllllllllllllIIlIlIIlIlIIlIIlIl).append(" does not belong to this set.")));
            }
            else {
                if (IntLinkedOpenHashSet.this.key[IntLinkedOpenHashSet.this.last] == llllllllllllllIIlIlIIlIlIIlIIlIl) {
                    this.prev = IntLinkedOpenHashSet.this.last;
                    this.index = IntLinkedOpenHashSet.this.size;
                    return;
                }
                final int[] llllllllllllllIIlIlIIlIlIIlIIlII = IntLinkedOpenHashSet.this.key;
                for (int llllllllllllllIIlIlIIlIlIIlIIIll = HashCommon.mix(llllllllllllllIIlIlIIlIlIIlIIlIl) & IntLinkedOpenHashSet.this.mask; llllllllllllllIIlIlIIlIlIIlIIlII[llllllllllllllIIlIlIIlIlIIlIIIll] != 0; llllllllllllllIIlIlIIlIlIIlIIIll = (llllllllllllllIIlIlIIlIlIIlIIIll + 1 & IntLinkedOpenHashSet.this.mask)) {
                    if (llllllllllllllIIlIlIIlIlIIlIIlII[llllllllllllllIIlIlIIlIlIIlIIIll] == llllllllllllllIIlIlIIlIlIIlIIlIl) {
                        this.next = (int)IntLinkedOpenHashSet.this.link[llllllllllllllIIlIlIIlIlIIlIIIll];
                        this.prev = llllllllllllllIIlIlIIlIlIIlIIIll;
                        return;
                    }
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(llllllllllllllIIlIlIIlIlIIlIIlIl).append(" does not belong to this set.")));
            }
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
                this.index = IntLinkedOpenHashSet.this.size;
                return;
            }
            int llllllllllllllIIlIlIIlIlIIIIlllI = IntLinkedOpenHashSet.this.first;
            this.index = 1;
            while (llllllllllllllIIlIlIIlIlIIIIlllI != this.prev) {
                llllllllllllllIIlIlIIlIlIIIIlllI = (int)IntLinkedOpenHashSet.this.link[llllllllllllllIIlIlIIlIlIIIIlllI];
                ++this.index;
            }
        }
        
        @Override
        public int previousIndex() {
            this.ensureIndexKnown();
            return this.index - 1;
        }
        
        @Override
        public int previousInt() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int)(IntLinkedOpenHashSet.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                --this.index;
            }
            return IntLinkedOpenHashSet.this.key[this.curr];
        }
        
        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int)IntLinkedOpenHashSet.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                ++this.index;
            }
            return IntLinkedOpenHashSet.this.key[this.curr];
        }
        
        @Override
        public void remove() {
            this.ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                --this.index;
                this.prev = (int)(IntLinkedOpenHashSet.this.link[this.curr] >>> 32);
            }
            else {
                this.next = (int)IntLinkedOpenHashSet.this.link[this.curr];
            }
            final IntLinkedOpenHashSet this$0 = IntLinkedOpenHashSet.this;
            --this$0.size;
            if (this.prev == -1) {
                IntLinkedOpenHashSet.this.first = this.next;
            }
            else {
                final long[] link = IntLinkedOpenHashSet.this.link;
                final int prev = this.prev;
                link[prev] ^= ((IntLinkedOpenHashSet.this.link[this.prev] ^ ((long)this.next & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            }
            if (this.next == -1) {
                IntLinkedOpenHashSet.this.last = this.prev;
            }
            else {
                final long[] link2 = IntLinkedOpenHashSet.this.link;
                final int next = this.next;
                link2[next] ^= ((IntLinkedOpenHashSet.this.link[this.next] ^ ((long)this.prev & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            }
            int llllllllllllllIIlIlIIlIIlllllIlI = this.curr;
            this.curr = -1;
            if (llllllllllllllIIlIlIIlIIlllllIlI == IntLinkedOpenHashSet.this.n) {
                IntLinkedOpenHashSet.this.containsNull = false;
                IntLinkedOpenHashSet.this.key[IntLinkedOpenHashSet.this.n] = 0;
                return;
            }
            final int[] llllllllllllllIIlIlIIlIIlllllllI = IntLinkedOpenHashSet.this.key;
            int llllllllllllllIIlIlIIlIIllllllIl = 0;
        Label_0280:
            while (true) {
                llllllllllllllIIlIlIIlIIlllllIlI = ((llllllllllllllIIlIlIIlIIllllllIl = llllllllllllllIIlIlIIlIIlllllIlI) + 1 & IntLinkedOpenHashSet.this.mask);
                int llllllllllllllIIlIlIIlIIllllllll;
                while ((llllllllllllllIIlIlIIlIIllllllll = llllllllllllllIIlIlIIlIIlllllllI[llllllllllllllIIlIlIIlIIlllllIlI]) != 0) {
                    final int llllllllllllllIIlIlIIlIIllllllII = HashCommon.mix(llllllllllllllIIlIlIIlIIllllllll) & IntLinkedOpenHashSet.this.mask;
                    Label_0370: {
                        if (llllllllllllllIIlIlIIlIIllllllIl <= llllllllllllllIIlIlIIlIIlllllIlI) {
                            if (llllllllllllllIIlIlIIlIIllllllIl >= llllllllllllllIIlIlIIlIIllllllII) {
                                break Label_0370;
                            }
                            if (llllllllllllllIIlIlIIlIIllllllII > llllllllllllllIIlIlIIlIIlllllIlI) {
                                break Label_0370;
                            }
                        }
                        else if (llllllllllllllIIlIlIIlIIllllllIl >= llllllllllllllIIlIlIIlIIllllllII && llllllllllllllIIlIlIIlIIllllllII > llllllllllllllIIlIlIIlIIlllllIlI) {
                            break Label_0370;
                        }
                        llllllllllllllIIlIlIIlIIlllllIlI = (llllllllllllllIIlIlIIlIIlllllIlI + 1 & IntLinkedOpenHashSet.this.mask);
                        continue;
                    }
                    llllllllllllllIIlIlIIlIIlllllllI[llllllllllllllIIlIlIIlIIllllllIl] = llllllllllllllIIlIlIIlIIllllllll;
                    if (this.next == llllllllllllllIIlIlIIlIIlllllIlI) {
                        this.next = llllllllllllllIIlIlIIlIIllllllIl;
                    }
                    if (this.prev == llllllllllllllIIlIlIIlIIlllllIlI) {
                        this.prev = llllllllllllllIIlIlIIlIIllllllIl;
                    }
                    IntLinkedOpenHashSet.this.fixPointers(llllllllllllllIIlIlIIlIIlllllIlI, llllllllllllllIIlIlIIlIIllllllIl);
                    continue Label_0280;
                }
                break;
            }
            llllllllllllllIIlIlIIlIIlllllllI[llllllllllllllIIlIlIIlIIllllllIl] = 0;
        }
        
        @Override
        public boolean hasPrevious() {
            return this.prev != -1;
        }
    }
}
