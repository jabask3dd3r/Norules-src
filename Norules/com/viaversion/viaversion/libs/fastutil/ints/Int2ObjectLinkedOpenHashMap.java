package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import java.util.function.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public class Int2ObjectLinkedOpenHashMap<V> extends AbstractInt2ObjectSortedMap<V> implements Serializable, Cloneable, Hash
{
    protected transient /* synthetic */ ObjectCollection<V> values;
    protected transient /* synthetic */ int mask;
    protected transient /* synthetic */ int last;
    protected transient /* synthetic */ int[] key;
    protected transient /* synthetic */ boolean containsNullKey;
    protected transient /* synthetic */ long[] link;
    protected transient /* synthetic */ int first;
    protected /* synthetic */ int size;
    protected transient /* synthetic */ V[] value;
    protected transient /* synthetic */ IntSortedSet keys;
    protected final /* synthetic */ float f;
    protected final transient /* synthetic */ int minN;
    protected transient /* synthetic */ int n;
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ Int2ObjectSortedMap.FastSortedEntrySet<V> entries;
    
    private void insert(final int llllllllllllllIlIlllIlIIIIIllIIl, final int llllllllllllllIlIlllIlIIIIIllIII, final V llllllllllllllIlIlllIlIIIIIlIIll) {
        if (llllllllllllllIlIlllIlIIIIIllIIl == this.n) {
            this.containsNullKey = true;
        }
        this.key[llllllllllllllIlIlllIlIIIIIllIIl] = llllllllllllllIlIlllIlIIIIIllIII;
        this.value[llllllllllllllIlIlllIlIIIIIllIIl] = llllllllllllllIlIlllIlIIIIIlIIll;
        if (this.size == 0) {
            this.last = llllllllllllllIlIlllIlIIIIIllIIl;
            this.first = llllllllllllllIlIlllIlIIIIIllIIl;
            this.link[llllllllllllllIlIlllIlIIIIIllIIl] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlIlllIlIIIIIllIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlIlllIlIIIIIllIIl] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = llllllllllllllIlIlllIlIIIIIllIIl;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
    }
    
    private V setValue(final int llllllllllllllIlIlllIIllllIllIIl, final V llllllllllllllIlIlllIIllllIlllII) {
        final V llllllllllllllIlIlllIIllllIllIll = this.value[llllllllllllllIlIlllIIllllIllIIl];
        this.value[llllllllllllllIlIlllIIllllIllIIl] = llllllllllllllIlIlllIIllllIlllII;
        return llllllllllllllIlIlllIIllllIllIll;
    }
    
    @Override
    public V getOrDefault(final int llllllllllllllIlIlllIIllIIIIIllI, final V llllllllllllllIlIlllIIllIIIIIlIl) {
        if (llllllllllllllIlIlllIIllIIIIIllI == 0) {
            return this.containsNullKey ? this.value[this.n] : llllllllllllllIlIlllIIllIIIIIlIl;
        }
        final int[] llllllllllllllIlIlllIIllIIIIlIIl = this.key;
        int llllllllllllllIlIlllIIllIIIIlIII;
        int llllllllllllllIlIlllIIllIIIIlIlI;
        if ((llllllllllllllIlIlllIIllIIIIlIlI = llllllllllllllIlIlllIIllIIIIlIIl[llllllllllllllIlIlllIIllIIIIlIII = (HashCommon.mix(llllllllllllllIlIlllIIllIIIIIllI) & this.mask)]) == 0) {
            return llllllllllllllIlIlllIIllIIIIIlIl;
        }
        if (llllllllllllllIlIlllIIllIIIIIllI == llllllllllllllIlIlllIIllIIIIlIlI) {
            return this.value[llllllllllllllIlIlllIIllIIIIlIII];
        }
        while ((llllllllllllllIlIlllIIllIIIIlIlI = llllllllllllllIlIlllIIllIIIIlIIl[llllllllllllllIlIlllIIllIIIIlIII = (llllllllllllllIlIlllIIllIIIIlIII + 1 & this.mask)]) != 0) {
            if (llllllllllllllIlIlllIIllIIIIIllI == llllllllllllllIlIlllIIllIIIIlIlI) {
                return this.value[llllllllllllllIlIlllIIllIIIIlIII];
            }
        }
        return llllllllllllllIlIlllIIllIIIIIlIl;
    }
    
    public V putAndMoveToLast(final int llllllllllllllIlIlllIIllIlIIIlIl, final V llllllllllllllIlIlllIIllIlIIIlII) {
        int llllllllllllllIlIlllIIllIlIIIlll = 0;
        if (llllllllllllllIlIlllIIllIlIIIlIl == 0) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.setValue(this.n, llllllllllllllIlIlllIIllIlIIIlII);
            }
            this.containsNullKey = true;
            final int llllllllllllllIlIlllIIllIlIIllIl = this.n;
        }
        else {
            final int[] llllllllllllllIlIlllIIllIlIIlIll = this.key;
            int llllllllllllllIlIlllIIllIlIIllII;
            if ((llllllllllllllIlIlllIIllIlIIllII = llllllllllllllIlIlllIIllIlIIlIll[llllllllllllllIlIlllIIllIlIIIlll = (HashCommon.mix(llllllllllllllIlIlllIIllIlIIIlIl) & this.mask)]) != 0) {
                if (llllllllllllllIlIlllIIllIlIIllII == llllllllllllllIlIlllIIllIlIIIlIl) {
                    this.moveIndexToLast(llllllllllllllIlIlllIIllIlIIIlll);
                    return this.setValue(llllllllllllllIlIlllIIllIlIIIlll, llllllllllllllIlIlllIIllIlIIIlII);
                }
                while ((llllllllllllllIlIlllIIllIlIIllII = llllllllllllllIlIlllIIllIlIIlIll[llllllllllllllIlIlllIIllIlIIIlll = (llllllllllllllIlIlllIIllIlIIIlll + 1 & this.mask)]) != 0) {
                    if (llllllllllllllIlIlllIIllIlIIllII == llllllllllllllIlIlllIIllIlIIIlIl) {
                        this.moveIndexToLast(llllllllllllllIlIlllIIllIlIIIlll);
                        return this.setValue(llllllllllllllIlIlllIIllIlIIIlll, llllllllllllllIlIlllIIllIlIIIlII);
                    }
                }
            }
        }
        this.key[llllllllllllllIlIlllIIllIlIIIlll] = llllllllllllllIlIlllIIllIlIIIlIl;
        this.value[llllllllllllllIlIlllIIllIlIIIlll] = llllllllllllllIlIlllIIllIlIIIlII;
        if (this.size == 0) {
            final int n = llllllllllllllIlIlllIIllIlIIIlll;
            this.last = n;
            this.first = n;
            this.link[llllllllllllllIlIlllIIllIlIIIlll] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlIlllIIllIlIIIlll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlIlllIIllIlIIIlll] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = llllllllllllllIlIlllIIllIlIIIlll;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }
    
    private void moveIndexToFirst(final int llllllllllllllIlIlllIIlllIlllIIl) {
        if (this.size == 1 || this.first == llllllllllllllIlIlllIIlllIlllIIl) {
            return;
        }
        if (this.last == llllllllllllllIlIlllIIlllIlllIIl) {
            this.last = (int)(this.link[llllllllllllllIlIlllIIlllIlllIIl] >>> 32);
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        else {
            final long llllllllllllllIlIlllIIlllIllllll = this.link[llllllllllllllIlIlllIIlllIlllIIl];
            final int llllllllllllllIlIlllIIlllIlllllI = (int)(llllllllllllllIlIlllIIlllIllllll >>> 32);
            final int llllllllllllllIlIlllIIlllIllllIl = (int)llllllllllllllIlIlllIIlllIllllll;
            final long[] link2 = this.link;
            final int n = llllllllllllllIlIlllIIlllIlllllI;
            link2[n] ^= ((this.link[llllllllllllllIlIlllIIlllIlllllI] ^ (llllllllllllllIlIlllIIlllIllllll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = llllllllllllllIlIlllIIlllIllllIl;
            link3[n2] ^= ((this.link[llllllllllllllIlIlllIIlllIllllIl] ^ (llllllllllllllIlIlllIIlllIllllll & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int first = this.first;
        link4[first] ^= ((this.link[this.first] ^ ((long)llllllllllllllIlIlllIIlllIlllIIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[llllllllllllllIlIlllIIlllIlllIIl] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
        this.first = llllllllllllllIlIlllIIlllIlllIIl;
    }
    
    private void checkTable() {
    }
    
    private int realSize() {
        return this.containsNullKey ? (this.size - 1) : this.size;
    }
    
    @Override
    public IntComparator comparator() {
        return null;
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    @Override
    public V get(final int llllllllllllllIlIlllIIllIIllIlIl) {
        if (llllllllllllllIlIlllIIllIIllIlIl == 0) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        }
        final int[] llllllllllllllIlIlllIIllIIlllIII = this.key;
        int llllllllllllllIlIlllIIllIIllIlll;
        int llllllllllllllIlIlllIIllIIlllIIl;
        if ((llllllllllllllIlIlllIIllIIlllIIl = llllllllllllllIlIlllIIllIIlllIII[llllllllllllllIlIlllIIllIIllIlll = (HashCommon.mix(llllllllllllllIlIlllIIllIIllIlIl) & this.mask)]) == 0) {
            return this.defRetValue;
        }
        if (llllllllllllllIlIlllIIllIIllIlIl == llllllllllllllIlIlllIIllIIlllIIl) {
            return this.value[llllllllllllllIlIlllIIllIIllIlll];
        }
        while ((llllllllllllllIlIlllIIllIIlllIIl = llllllllllllllIlIlllIIllIIlllIII[llllllllllllllIlIlllIIllIIllIlll = (llllllllllllllIlIlllIIllIIllIlll + 1 & this.mask)]) != 0) {
            if (llllllllllllllIlIlllIIllIIllIlIl == llllllllllllllIlIlllIIllIIlllIIl) {
                return this.value[llllllllllllllIlIlllIIllIIllIlll];
            }
        }
        return this.defRetValue;
    }
    
    public Int2ObjectLinkedOpenHashMap<V> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap;
        //     7: astore_1        /* llllllllllllllIlIlllIIIlllIIllIl */
        //     8: goto            20
        //    11: astore_2        /* llllllllllllllIlIlllIIIlllIIllII */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllllIlIlllIIIlllIIlIlI */
        //    21: aconst_null    
        //    22: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.keys:Lcom/viaversion/viaversion/libs/fastutil/ints/IntSortedSet;
        //    25: aload_1         /* llllllllllllllIlIlllIIIlllIIlIlI */
        //    26: aconst_null    
        //    27: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.values:Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectCollection;
        //    30: aload_1         /* llllllllllllllIlIlllIIIlllIIlIlI */
        //    31: aconst_null    
        //    32: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.entries:Lcom/viaversion/viaversion/libs/fastutil/ints/Int2ObjectSortedMap$FastSortedEntrySet;
        //    35: aload_1         /* llllllllllllllIlIlllIIIlllIIlIlI */
        //    36: aload_0         /* llllllllllllllIlIlllIIIlllIIlIll */
        //    37: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.containsNullKey:Z
        //    40: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.containsNullKey:Z
        //    43: aload_1         /* llllllllllllllIlIlllIIIlllIIlIlI */
        //    44: aload_0         /* llllllllllllllIlIlllIIIlllIIlIll */
        //    45: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.key:[I
        //    48: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    51: checkcast       [I
        //    54: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.key:[I
        //    57: aload_1         /* llllllllllllllIlIlllIIIlllIIlIlI */
        //    58: aload_0         /* llllllllllllllIlIlllIIIlllIIlIll */
        //    59: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.value:[Ljava/lang/Object;
        //    62: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    65: checkcast       [Ljava/lang/Object;
        //    68: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.value:[Ljava/lang/Object;
        //    71: aload_1         /* llllllllllllllIlIlllIIIlllIIlIlI */
        //    72: aload_0         /* llllllllllllllIlIlllIIIlllIIlIll */
        //    73: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.link:[J
        //    76: invokevirtual   [J.clone:()Ljava/lang/Object;
        //    79: checkcast       [J
        //    82: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap.link:[J
        //    85: aload_1         /* llllllllllllllIlIlllIIIlllIIlIlI */
        //    86: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/ints/Int2ObjectLinkedOpenHashMap<TV;>;
        //    StackMapTable: 00 02 4B 07 00 FF FC 00 08 07 00 02
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
    
    @Override
    public int hashCode() {
        int llllllllllllllIlIlllIIIllIllllIl = 0;
        int llllllllllllllIlIlllIIIlllIIIIIl = this.realSize();
        int llllllllllllllIlIlllIIIlllIIIIII = 0;
        int llllllllllllllIlIlllIIIllIllllll = 0;
        while (llllllllllllllIlIlllIIIlllIIIIIl-- != 0) {
            while (this.key[llllllllllllllIlIlllIIIlllIIIIII] == 0) {
                ++llllllllllllllIlIlllIIIlllIIIIII;
            }
            llllllllllllllIlIlllIIIllIllllll = this.key[llllllllllllllIlIlllIIIlllIIIIII];
            if (this != this.value[llllllllllllllIlIlllIIIlllIIIIII]) {
                llllllllllllllIlIlllIIIllIllllll ^= ((this.value[llllllllllllllIlIlllIIIlllIIIIII] == null) ? 0 : this.value[llllllllllllllIlIlllIIIlllIIIIII].hashCode());
            }
            llllllllllllllIlIlllIIIllIllllIl += llllllllllllllIlIlllIIIllIllllll;
            ++llllllllllllllIlIlllIIIlllIIIIII;
        }
        if (this.containsNullKey) {
            llllllllllllllIlIlllIIIllIllllIl += ((this.value[this.n] == null) ? 0 : this.value[this.n].hashCode());
        }
        return llllllllllllllIlIlllIIIllIllllIl;
    }
    
    @Override
    public V put(final int llllllllllllllIlIlllIlIIIIIIIlll, final V llllllllllllllIlIlllIlIIIIIIIllI) {
        final int llllllllllllllIlIlllIlIIIIIIlIlI = this.find(llllllllllllllIlIlllIlIIIIIIIlll);
        if (llllllllllllllIlIlllIlIIIIIIlIlI < 0) {
            this.insert(-llllllllllllllIlIlllIlIIIIIIlIlI - 1, llllllllllllllIlIlllIlIIIIIIIlll, llllllllllllllIlIlllIlIIIIIIIllI);
            return this.defRetValue;
        }
        final V llllllllllllllIlIlllIlIIIIIIlIIl = this.value[llllllllllllllIlIlllIlIIIIIIlIlI];
        this.value[llllllllllllllIlIlllIlIIIIIIlIlI] = llllllllllllllIlIlllIlIIIIIIIllI;
        return llllllllllllllIlIlllIlIIIIIIlIIl;
    }
    
    @Override
    public boolean remove(final int llllllllllllllIlIlllIIlIlllIlIII, final Object llllllllllllllIlIlllIIlIlllIIlll) {
        if (llllllllllllllIlIlllIIlIlllIlIII == 0) {
            if (this.containsNullKey && Objects.equals(llllllllllllllIlIlllIIlIlllIIlll, this.value[this.n])) {
                this.removeNullEntry();
                return true;
            }
            return false;
        }
        else {
            final int[] llllllllllllllIlIlllIIlIlllIlIll = this.key;
            int llllllllllllllIlIlllIIlIlllIlIlI;
            int llllllllllllllIlIlllIIlIlllIllII;
            if ((llllllllllllllIlIlllIIlIlllIllII = llllllllllllllIlIlllIIlIlllIlIll[llllllllllllllIlIlllIIlIlllIlIlI = (HashCommon.mix(llllllllllllllIlIlllIIlIlllIlIII) & this.mask)]) == 0) {
                return false;
            }
            if (llllllllllllllIlIlllIIlIlllIlIII == llllllllllllllIlIlllIIlIlllIllII && Objects.equals(llllllllllllllIlIlllIIlIlllIIlll, this.value[llllllllllllllIlIlllIIlIlllIlIlI])) {
                this.removeEntry(llllllllllllllIlIlllIIlIlllIlIlI);
                return true;
            }
            while ((llllllllllllllIlIlllIIlIlllIllII = llllllllllllllIlIlllIIlIlllIlIll[llllllllllllllIlIlllIIlIlllIlIlI = (llllllllllllllIlIlllIIlIlllIlIlI + 1 & this.mask)]) != 0) {
                if (llllllllllllllIlIlllIIlIlllIlIII == llllllllllllllIlIlllIIlIlllIllII && Objects.equals(llllllllllllllIlIlllIIlIlllIIlll, this.value[llllllllllllllIlIlllIIlIlllIlIlI])) {
                    this.removeEntry(llllllllllllllIlIlllIIlIlllIlIlI);
                    return true;
                }
            }
            return false;
        }
    }
    
    private void ensureCapacity(final int llllllllllllllIlIlllIlIIIlIIllIl) {
        final int llllllllllllllIlIlllIlIIIlIIllll = HashCommon.arraySize(llllllllllllllIlIlllIlIIIlIIllIl, this.f);
        if (llllllllllllllIlIlllIlIIIlIIllll > this.n) {
            this.rehash(llllllllllllllIlIlllIlIIIlIIllll);
        }
    }
    
    public Int2ObjectLinkedOpenHashMap(final int llllllllllllllIlIlllIlIIlIIlIIll) {
        this(llllllllllllllIlIlllIlIIlIIlIIll, 0.75f);
    }
    
    @Override
    public boolean replace(final int llllllllllllllIlIlllIIlIllIlllIl, final V llllllllllllllIlIlllIIlIllIlIlll, final V llllllllllllllIlIlllIIlIllIlIllI) {
        final int llllllllllllllIlIlllIIlIllIllIlI = this.find(llllllllllllllIlIlllIIlIllIlllIl);
        if (llllllllllllllIlIlllIIlIllIllIlI < 0 || !Objects.equals(llllllllllllllIlIlllIIlIllIlIlll, this.value[llllllllllllllIlIlllIIlIllIllIlI])) {
            return false;
        }
        this.value[llllllllllllllIlIlllIIlIllIllIlI] = llllllllllllllIlIlllIIlIllIlIllI;
        return true;
    }
    
    public Int2ObjectLinkedOpenHashMap(final Int2ObjectMap<V> llllllllllllllIlIlllIlIIIlllIlll, final float llllllllllllllIlIlllIlIIIllllIIl) {
        this(llllllllllllllIlIlllIlIIIlllIlll.size(), llllllllllllllIlIlllIlIIIllllIIl);
        this.putAll((Map<? extends Integer, ? extends V>)llllllllllllllIlIlllIlIIIlllIlll);
    }
    
    @Override
    public V computeIfPresent(final int llllllllllllllIlIlllIIlIlIlIlIll, final BiFunction<? super Integer, ? super V, ? extends V> llllllllllllllIlIlllIIlIlIlIlIlI) {
        Objects.requireNonNull(llllllllllllllIlIlllIIlIlIlIlIlI);
        final int llllllllllllllIlIlllIIlIlIlIlllI = this.find(llllllllllllllIlIlllIIlIlIlIlIll);
        if (llllllllllllllIlIlllIIlIlIlIlllI < 0) {
            return this.defRetValue;
        }
        final V llllllllllllllIlIlllIIlIlIlIllIl = (V)llllllllllllllIlIlllIIlIlIlIlIlI.apply(Integer.valueOf(llllllllllllllIlIlllIIlIlIlIlIll), (Object)this.value[llllllllllllllIlIlllIIlIlIlIlllI]);
        if (llllllllllllllIlIlllIIlIlIlIllIl == null) {
            if (llllllllllllllIlIlllIIlIlIlIlIll == 0) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(llllllllllllllIlIlllIIlIlIlIlllI);
            }
            return this.defRetValue;
        }
        return this.value[llllllllllllllIlIlllIIlIlIlIlllI] = llllllllllllllIlIlllIIlIlIlIllIl;
    }
    
    public boolean trim(final int llllllllllllllIlIlllIIlIIIlIIlll) {
        final int llllllllllllllIlIlllIIlIIIlIIlIl = HashCommon.nextPowerOfTwo((int)Math.ceil(llllllllllllllIlIlllIIlIIIlIIlll / this.f));
        if (llllllllllllllIlIlllIIlIIIlIIlIl >= this.n || this.size > HashCommon.maxFill(llllllllllllllIlIlllIIlIIIlIIlIl, this.f)) {
            return true;
        }
        try {
            this.rehash(llllllllllllllIlIlllIIlIIIlIIlIl);
        }
        catch (OutOfMemoryError llllllllllllllIlIlllIIlIIIlIlIll) {
            return false;
        }
        return true;
    }
    
    public V putAndMoveToFirst(final int llllllllllllllIlIlllIIllIlIllIII, final V llllllllllllllIlIlllIIllIlIlIlll) {
        int llllllllllllllIlIlllIIllIlIllIlI = 0;
        if (llllllllllllllIlIlllIIllIlIllIII == 0) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.setValue(this.n, llllllllllllllIlIlllIIllIlIlIlll);
            }
            this.containsNullKey = true;
            final int llllllllllllllIlIlllIIllIllIIIII = this.n;
        }
        else {
            final int[] llllllllllllllIlIlllIIllIlIllllI = this.key;
            int llllllllllllllIlIlllIIllIlIlllll;
            if ((llllllllllllllIlIlllIIllIlIlllll = llllllllllllllIlIlllIIllIlIllllI[llllllllllllllIlIlllIIllIlIllIlI = (HashCommon.mix(llllllllllllllIlIlllIIllIlIllIII) & this.mask)]) != 0) {
                if (llllllllllllllIlIlllIIllIlIlllll == llllllllllllllIlIlllIIllIlIllIII) {
                    this.moveIndexToFirst(llllllllllllllIlIlllIIllIlIllIlI);
                    return this.setValue(llllllllllllllIlIlllIIllIlIllIlI, llllllllllllllIlIlllIIllIlIlIlll);
                }
                while ((llllllllllllllIlIlllIIllIlIlllll = llllllllllllllIlIlllIIllIlIllllI[llllllllllllllIlIlllIIllIlIllIlI = (llllllllllllllIlIlllIIllIlIllIlI + 1 & this.mask)]) != 0) {
                    if (llllllllllllllIlIlllIIllIlIlllll == llllllllllllllIlIlllIIllIlIllIII) {
                        this.moveIndexToFirst(llllllllllllllIlIlllIIllIlIllIlI);
                        return this.setValue(llllllllllllllIlIlllIIllIlIllIlI, llllllllllllllIlIlllIIllIlIlIlll);
                    }
                }
            }
        }
        this.key[llllllllllllllIlIlllIIllIlIllIlI] = llllllllllllllIlIlllIIllIlIllIII;
        this.value[llllllllllllllIlIlllIIllIlIllIlI] = llllllllllllllIlIlllIIllIlIlIlll;
        if (this.size == 0) {
            final int n = llllllllllllllIlIlllIIllIlIllIlI;
            this.last = n;
            this.first = n;
            this.link[llllllllllllllIlIlllIIllIlIllIlI] = -1L;
        }
        else {
            final long[] link = this.link;
            final int first = this.first;
            link[first] ^= ((this.link[this.first] ^ ((long)llllllllllllllIlIlllIIllIlIllIlI & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[llllllllllllllIlIlllIIllIlIllIlI] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
            this.first = llllllllllllllIlIlllIIllIlIllIlI;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }
    
    public Int2ObjectLinkedOpenHashMap() {
        this(16, 0.75f);
    }
    
    private void readObject(final ObjectInputStream llllllllllllllIlIlllIIIllIIIllII) throws ClassNotFoundException, IOException {
        llllllllllllllIlIlllIIIllIIIllII.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final int[] key = new int[this.n + 1];
        this.key = key;
        final int[] llllllllllllllIlIlllIIIllIIlIIIl = key;
        final Object[] value = new Object[this.n + 1];
        this.value = (V[])value;
        final V[] llllllllllllllIlIlllIIIllIIlIIII = (V[])value;
        final long[] link = new long[this.n + 1];
        this.link = link;
        final long[] llllllllllllllIlIlllIIIllIIIllll = link;
        int llllllllllllllIlIlllIIIllIIIlllI = -1;
        final int n = -1;
        this.last = n;
        this.first = n;
        int llllllllllllllIlIlllIIIllIIlIlIl = this.size;
        while (llllllllllllllIlIlllIIIllIIlIlIl-- != 0) {
            final int llllllllllllllIlIlllIIIllIIlIlll = llllllllllllllIlIlllIIIllIIIllII.readInt();
            final V llllllllllllllIlIlllIIIllIIlIllI = (V)llllllllllllllIlIlllIIIllIIIllII.readObject();
            int llllllllllllllIlIlllIIIllIIlIlII = 0;
            if (llllllllllllllIlIlllIIIllIIlIlll == 0) {
                final int llllllllllllllIlIlllIIIllIIllIII = this.n;
                this.containsNullKey = true;
            }
            else {
                for (llllllllllllllIlIlllIIIllIIlIlII = (HashCommon.mix(llllllllllllllIlIlllIIIllIIlIlll) & this.mask); llllllllllllllIlIlllIIIllIIlIIIl[llllllllllllllIlIlllIIIllIIlIlII] != 0; llllllllllllllIlIlllIIIllIIlIlII = (llllllllllllllIlIlllIIIllIIlIlII + 1 & this.mask)) {}
            }
            llllllllllllllIlIlllIIIllIIlIIIl[llllllllllllllIlIlllIIIllIIlIlII] = llllllllllllllIlIlllIIIllIIlIlll;
            llllllllllllllIlIlllIIIllIIlIIII[llllllllllllllIlIlllIIIllIIlIlII] = llllllllllllllIlIlllIIIllIIlIllI;
            if (this.first != -1) {
                final long[] array = llllllllllllllIlIlllIIIllIIIllll;
                final int n2 = llllllllllllllIlIlllIIIllIIIlllI;
                array[n2] ^= ((llllllllllllllIlIlllIIIllIIIllll[llllllllllllllIlIlllIIIllIIIlllI] ^ ((long)llllllllllllllIlIlllIIIllIIlIlII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = llllllllllllllIlIlllIIIllIIIllll;
                final int n3 = llllllllllllllIlIlllIIIllIIlIlII;
                array2[n3] ^= ((llllllllllllllIlIlllIIIllIIIllll[llllllllllllllIlIlllIIIllIIlIlII] ^ ((long)llllllllllllllIlIlllIIIllIIIlllI & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                llllllllllllllIlIlllIIIllIIIlllI = llllllllllllllIlIlllIIIllIIlIlII;
            }
            else {
                final int first = llllllllllllllIlIlllIIIllIIlIlII;
                this.first = first;
                llllllllllllllIlIlllIIIllIIIlllI = first;
                final long[] array3 = llllllllllllllIlIlllIIIllIIIllll;
                final int n4 = llllllllllllllIlIlllIIIllIIlIlII;
                array3[n4] |= 0xFFFFFFFF00000000L;
            }
        }
        if ((this.last = llllllllllllllIlIlllIIIllIIIlllI) != -1) {
            final long[] array4 = llllllllllllllIlIlllIIIllIIIllll;
            final int n5 = llllllllllllllIlIlllIIIllIIIlllI;
            array4[n5] |= 0xFFFFFFFFL;
        }
    }
    
    @Override
    public Int2ObjectSortedMap.FastSortedEntrySet<V> int2ObjectEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }
    
    @Override
    public V merge(final int llllllllllllllIlIlllIIlIlIIIlIII, final V llllllllllllllIlIlllIIlIlIIIllIl, final BiFunction<? super V, ? super V, ? extends V> llllllllllllllIlIlllIIlIlIIIllII) {
        Objects.requireNonNull(llllllllllllllIlIlllIIlIlIIIllII);
        final int llllllllllllllIlIlllIIlIlIIIlIll = this.find(llllllllllllllIlIlllIIlIlIIIlIII);
        if (llllllllllllllIlIlllIIlIlIIIlIll < 0 || this.value[llllllllllllllIlIlllIIlIlIIIlIll] == null) {
            if (llllllllllllllIlIlllIIlIlIIIllIl == null) {
                return this.defRetValue;
            }
            this.insert(-llllllllllllllIlIlllIIlIlIIIlIll - 1, llllllllllllllIlIlllIIlIlIIIlIII, llllllllllllllIlIlllIIlIlIIIllIl);
            return llllllllllllllIlIlllIIlIlIIIllIl;
        }
        else {
            final V llllllllllllllIlIlllIIlIlIIIlIlI = (V)llllllllllllllIlIlllIIlIlIIIllII.apply((Object)this.value[llllllllllllllIlIlllIIlIlIIIlIll], (Object)llllllllllllllIlIlllIIlIlIIIllIl);
            if (llllllllllllllIlIlllIIlIlIIIlIlI == null) {
                if (llllllllllllllIlIlllIIlIlIIIlIII == 0) {
                    this.removeNullEntry();
                }
                else {
                    this.removeEntry(llllllllllllllIlIlllIIlIlIIIlIll);
                }
                return this.defRetValue;
            }
            return this.value[llllllllllllllIlIlllIIlIlIIIlIll] = llllllllllllllIlIlllIIlIlIIIlIlI;
        }
    }
    
    public V removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int llllllllllllllIlIlllIIllllIlIIlI = this.first;
        this.first = (int)this.link[llllllllllllllIlIlllIIllllIlIIlI];
        if (0 <= this.first) {
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        --this.size;
        final V llllllllllllllIlIlllIIllllIlIIIl = this.value[llllllllllllllIlIlllIIllllIlIIlI];
        if (llllllllllllllIlIlllIIllllIlIIlI == this.n) {
            this.containsNullKey = false;
            this.value[this.n] = null;
        }
        else {
            this.shiftKeys(llllllllllllllIlIlllIIllllIlIIlI);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlIlllIIllllIlIIIl;
    }
    
    @Override
    public int lastIntKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.last];
    }
    
    @Override
    public boolean containsValue(final Object llllllllllllllIlIlllIIllIIIlIlll) {
        final V[] llllllllllllllIlIlllIIllIIIllIlI = this.value;
        final int[] llllllllllllllIlIlllIIllIIIllIIl = this.key;
        if (this.containsNullKey && Objects.equals(llllllllllllllIlIlllIIllIIIllIlI[this.n], llllllllllllllIlIlllIIllIIIlIlll)) {
            return true;
        }
        int llllllllllllllIlIlllIIllIIIlllIl = this.n;
        while (llllllllllllllIlIlllIIllIIIlllIl-- != 0) {
            if (llllllllllllllIlIlllIIllIIIllIIl[llllllllllllllIlIlllIIllIIIlllIl] != 0 && Objects.equals(llllllllllllllIlIlllIIllIIIllIlI[llllllllllllllIlIlllIIllIIIlllIl], llllllllllllllIlIlllIIllIIIlIlll)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public V remove(final int llllllllllllllIlIlllIIlllllIlIll) {
        if (llllllllllllllIlIlllIIlllllIlIll == 0) {
            if (this.containsNullKey) {
                return this.removeNullEntry();
            }
            return this.defRetValue;
        }
        else {
            final int[] llllllllllllllIlIlllIIlllllIlIIl = this.key;
            int llllllllllllllIlIlllIIlllllIlIII;
            int llllllllllllllIlIlllIIlllllIlIlI;
            if ((llllllllllllllIlIlllIIlllllIlIlI = llllllllllllllIlIlllIIlllllIlIIl[llllllllllllllIlIlllIIlllllIlIII = (HashCommon.mix(llllllllllllllIlIlllIIlllllIlIll) & this.mask)]) == 0) {
                return this.defRetValue;
            }
            if (llllllllllllllIlIlllIIlllllIlIll == llllllllllllllIlIlllIIlllllIlIlI) {
                return this.removeEntry(llllllllllllllIlIlllIIlllllIlIII);
            }
            while ((llllllllllllllIlIlllIIlllllIlIlI = llllllllllllllIlIlllIIlllllIlIIl[llllllllllllllIlIlllIIlllllIlIII = (llllllllllllllIlIlllIIlllllIlIII + 1 & this.mask)]) != 0) {
                if (llllllllllllllIlIlllIIlllllIlIll == llllllllllllllIlIlllIIlllllIlIlI) {
                    return this.removeEntry(llllllllllllllIlIlllIIlllllIlIII);
                }
            }
            return this.defRetValue;
        }
    }
    
    protected void fixPointers(final int llllllllllllllIlIlllIIlIIlIllllI, final int llllllllllllllIlIlllIIlIIlIlllIl) {
        if (this.size == 1) {
            this.last = llllllllllllllIlIlllIIlIIlIlllIl;
            this.first = llllllllllllllIlIlllIIlIIlIlllIl;
            this.link[llllllllllllllIlIlllIIlIIlIlllIl] = -1L;
            return;
        }
        if (this.first == llllllllllllllIlIlllIIlIIlIllllI) {
            this.first = llllllllllllllIlIlllIIlIIlIlllIl;
            final long[] link = this.link;
            final int n = (int)this.link[llllllllllllllIlIlllIIlIIlIllllI];
            link[n] ^= ((this.link[(int)this.link[llllllllllllllIlIlllIIlIIlIllllI]] ^ ((long)llllllllllllllIlIlllIIlIIlIlllIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[llllllllllllllIlIlllIIlIIlIlllIl] = this.link[llllllllllllllIlIlllIIlIIlIllllI];
            return;
        }
        if (this.last == llllllllllllllIlIlllIIlIIlIllllI) {
            this.last = llllllllllllllIlIlllIIlIIlIlllIl;
            final long[] link2 = this.link;
            final int n2 = (int)(this.link[llllllllllllllIlIlllIIlIIlIllllI] >>> 32);
            link2[n2] ^= ((this.link[(int)(this.link[llllllllllllllIlIlllIIlIIlIllllI] >>> 32)] ^ ((long)llllllllllllllIlIlllIIlIIlIlllIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlIlllIIlIIlIlllIl] = this.link[llllllllllllllIlIlllIIlIIlIllllI];
            return;
        }
        final long llllllllllllllIlIlllIIlIIllIIIlI = this.link[llllllllllllllIlIlllIIlIIlIllllI];
        final int llllllllllllllIlIlllIIlIIllIIIIl = (int)(llllllllllllllIlIlllIIlIIllIIIlI >>> 32);
        final int llllllllllllllIlIlllIIlIIllIIIII = (int)llllllllllllllIlIlllIIlIIllIIIlI;
        final long[] link3 = this.link;
        final int n3 = llllllllllllllIlIlllIIlIIllIIIIl;
        link3[n3] ^= ((this.link[llllllllllllllIlIlllIIlIIllIIIIl] ^ ((long)llllllllllllllIlIlllIIlIIlIlllIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n4 = llllllllllllllIlIlllIIlIIllIIIII;
        link4[n4] ^= ((this.link[llllllllllllllIlIlllIIlIIllIIIII] ^ ((long)llllllllllllllIlIlllIIlIIlIlllIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[llllllllllllllIlIlllIIlIIlIlllIl] = llllllllllllllIlIlllIIlIIllIIIlI;
    }
    
    private V removeEntry(final int llllllllllllllIlIlllIlIIIIlllIll) {
        final V llllllllllllllIlIlllIlIIIIllllIl = this.value[llllllllllllllIlIlllIlIIIIlllIll];
        this.value[llllllllllllllIlIlllIlIIIIlllIll] = null;
        --this.size;
        this.fixPointers(llllllllllllllIlIlllIlIIIIlllIll);
        this.shiftKeys(llllllllllllllIlIlllIlIIIIlllIll);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlIlllIlIIIIllllIl;
    }
    
    private V removeNullEntry() {
        this.containsNullKey = false;
        final V llllllllllllllIlIlllIlIIIIllIllI = this.value[this.n];
        this.value[this.n] = null;
        --this.size;
        this.fixPointers(this.n);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlIlllIlIIIIllIllI;
    }
    
    static {
        ASSERTS = false;
    }
    
    public Int2ObjectLinkedOpenHashMap(final Map<? extends Integer, ? extends V> llllllllllllllIlIlllIlIIIlllllll) {
        this(llllllllllllllIlIlllIlIIIlllllll, 0.75f);
    }
    
    private void tryCapacity(final long llllllllllllllIlIlllIlIIIlIIIlII) {
        final int llllllllllllllIlIlllIlIIIlIIIllI = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(llllllllllllllIlIlllIlIIIlIIIlII / this.f))));
        if (llllllllllllllIlIlllIlIIIlIIIllI > this.n) {
            this.rehash(llllllllllllllIlIlllIlIIIlIIIllI);
        }
    }
    
    @Override
    public void putAll(final Map<? extends Integer, ? extends V> llllllllllllllIlIlllIlIIIIllIIII) {
        if (this.f <= 0.5) {
            this.ensureCapacity(llllllllllllllIlIlllIlIIIIllIIII.size());
        }
        else {
            this.tryCapacity(this.size() + llllllllllllllIlIlllIlIIIIllIIII.size());
        }
        super.putAll(llllllllllllllIlIlllIlIIIIllIIII);
    }
    
    @Override
    public boolean containsKey(final int llllllllllllllIlIlllIIllIIlIlIll) {
        if (llllllllllllllIlIlllIIllIIlIlIll == 0) {
            return this.containsNullKey;
        }
        final int[] llllllllllllllIlIlllIIllIIlIlIIl = this.key;
        int llllllllllllllIlIlllIIllIIlIlIII;
        int llllllllllllllIlIlllIIllIIlIlIlI;
        if ((llllllllllllllIlIlllIIllIIlIlIlI = llllllllllllllIlIlllIIllIIlIlIIl[llllllllllllllIlIlllIIllIIlIlIII = (HashCommon.mix(llllllllllllllIlIlllIIllIIlIlIll) & this.mask)]) == 0) {
            return false;
        }
        if (llllllllllllllIlIlllIIllIIlIlIll == llllllllllllllIlIlllIIllIIlIlIlI) {
            return true;
        }
        while ((llllllllllllllIlIlllIIllIIlIlIlI = llllllllllllllIlIlllIIllIIlIlIIl[llllllllllllllIlIlllIIllIIlIlIII = (llllllllllllllIlIlllIIllIIlIlIII + 1 & this.mask)]) != 0) {
            if (llllllllllllllIlIlllIIllIIlIlIll == llllllllllllllIlIlllIIllIIlIlIlI) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public V putIfAbsent(final int llllllllllllllIlIlllIIlIlllllIII, final V llllllllllllllIlIlllIIlIlllllIll) {
        final int llllllllllllllIlIlllIIlIlllllIlI = this.find(llllllllllllllIlIlllIIlIlllllIII);
        if (llllllllllllllIlIlllIIlIlllllIlI >= 0) {
            return this.value[llllllllllllllIlIlllIIlIlllllIlI];
        }
        this.insert(-llllllllllllllIlIlllIIlIlllllIlI - 1, llllllllllllllIlIlllIIlIlllllIII, llllllllllllllIlIlllIIlIlllllIll);
        return this.defRetValue;
    }
    
    protected void fixPointers(final int llllllllllllllIlIlllIIlIIlllIlII) {
        if (this.size == 0) {
            final int n = -1;
            this.last = n;
            this.first = n;
            return;
        }
        if (this.first == llllllllllllllIlIlllIIlIIlllIlII) {
            this.first = (int)this.link[llllllllllllllIlIlllIIlIIlllIlII];
            if (0 <= this.first) {
                final long[] link = this.link;
                final int first = this.first;
                link[first] |= 0xFFFFFFFF00000000L;
            }
            return;
        }
        if (this.last == llllllllllllllIlIlllIIlIIlllIlII) {
            this.last = (int)(this.link[llllllllllllllIlIlllIIlIIlllIlII] >>> 32);
            if (0 <= this.last) {
                final long[] link2 = this.link;
                final int last = this.last;
                link2[last] |= 0xFFFFFFFFL;
            }
            return;
        }
        final long llllllllllllllIlIlllIIlIIlllIIll = this.link[llllllllllllllIlIlllIIlIIlllIlII];
        final int llllllllllllllIlIlllIIlIIlllIIlI = (int)(llllllllllllllIlIlllIIlIIlllIIll >>> 32);
        final int llllllllllllllIlIlllIIlIIlllIIIl = (int)llllllllllllllIlIlllIIlIIlllIIll;
        final long[] link3 = this.link;
        final int n2 = llllllllllllllIlIlllIIlIIlllIIlI;
        link3[n2] ^= ((this.link[llllllllllllllIlIlllIIlIIlllIIlI] ^ (llllllllllllllIlIlllIIlIIlllIIll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n3 = llllllllllllllIlIlllIIlIIlllIIIl;
        link4[n3] ^= ((this.link[llllllllllllllIlIlllIIlIIlllIIIl] ^ (llllllllllllllIlIlllIIlIIlllIIll & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
    }
    
    private void writeObject(final ObjectOutputStream llllllllllllllIlIlllIIIllIlIllIl) throws IOException {
        final int[] llllllllllllllIlIlllIIIllIlIllII = this.key;
        final V[] llllllllllllllIlIlllIIIllIlIlIll = this.value;
        final MapIterator llllllllllllllIlIlllIIIllIlIlIlI = new MapIterator();
        llllllllllllllIlIlllIIIllIlIllIl.defaultWriteObject();
        int llllllllllllllIlIlllIIIllIllIIII = this.size;
        while (llllllllllllllIlIlllIIIllIllIIII-- != 0) {
            final int llllllllllllllIlIlllIIIllIlIllll = llllllllllllllIlIlllIIIllIlIlIlI.nextEntry();
            llllllllllllllIlIlllIIIllIlIllIl.writeInt(llllllllllllllIlIlllIIIllIlIllII[llllllllllllllIlIlllIIIllIlIllll]);
            llllllllllllllIlIlllIIIllIlIllIl.writeObject(llllllllllllllIlIlllIIIllIlIlIll[llllllllllllllIlIlllIIIllIlIllll]);
        }
    }
    
    private int find(final int llllllllllllllIlIlllIlIIIIlIIIlI) {
        if (llllllllllllllIlIlllIlIIIIlIIIlI == 0) {
            return this.containsNullKey ? this.n : (-(this.n + 1));
        }
        final int[] llllllllllllllIlIlllIlIIIIlIIlIl = this.key;
        int llllllllllllllIlIlllIlIIIIlIIlII;
        int llllllllllllllIlIlllIlIIIIlIIllI;
        if ((llllllllllllllIlIlllIlIIIIlIIllI = llllllllllllllIlIlllIlIIIIlIIlIl[llllllllllllllIlIlllIlIIIIlIIlII = (HashCommon.mix(llllllllllllllIlIlllIlIIIIlIIIlI) & this.mask)]) == 0) {
            return -(llllllllllllllIlIlllIlIIIIlIIlII + 1);
        }
        if (llllllllllllllIlIlllIlIIIIlIIIlI == llllllllllllllIlIlllIlIIIIlIIllI) {
            return llllllllllllllIlIlllIlIIIIlIIlII;
        }
        while ((llllllllllllllIlIlllIlIIIIlIIllI = llllllllllllllIlIlllIlIIIIlIIlIl[llllllllllllllIlIlllIlIIIIlIIlII = (llllllllllllllIlIlllIlIIIIlIIlII + 1 & this.mask)]) != 0) {
            if (llllllllllllllIlIlllIlIIIIlIIIlI == llllllllllllllIlIlllIlIIIIlIIllI) {
                return llllllllllllllIlIlllIlIIIIlIIlII;
            }
        }
        return -(llllllllllllllIlIlllIlIIIIlIIlII + 1);
    }
    
    @Override
    public V compute(final int llllllllllllllIlIlllIIlIlIlIIIII, final BiFunction<? super Integer, ? super V, ? extends V> llllllllllllllIlIlllIIlIlIIlllll) {
        Objects.requireNonNull(llllllllllllllIlIlllIIlIlIIlllll);
        final int llllllllllllllIlIlllIIlIlIIllllI = this.find(llllllllllllllIlIlllIIlIlIlIIIII);
        final V llllllllllllllIlIlllIIlIlIIlllIl = (V)llllllllllllllIlIlllIIlIlIIlllll.apply(Integer.valueOf(llllllllllllllIlIlllIIlIlIlIIIII), (Object)((llllllllllllllIlIlllIIlIlIIllllI >= 0) ? this.value[llllllllllllllIlIlllIIlIlIIllllI] : null));
        if (llllllllllllllIlIlllIIlIlIIlllIl == null) {
            if (llllllllllllllIlIlllIIlIlIIllllI >= 0) {
                if (llllllllllllllIlIlllIIlIlIlIIIII == 0) {
                    this.removeNullEntry();
                }
                else {
                    this.removeEntry(llllllllllllllIlIlllIIlIlIIllllI);
                }
            }
            return this.defRetValue;
        }
        final V llllllllllllllIlIlllIIlIlIIlllII = llllllllllllllIlIlllIIlIlIIlllIl;
        if (llllllllllllllIlIlllIIlIlIIllllI < 0) {
            this.insert(-llllllllllllllIlIlllIIlIlIIllllI - 1, llllllllllllllIlIlllIIlIlIlIIIII, llllllllllllllIlIlllIIlIlIIlllII);
            return llllllllllllllIlIlllIIlIlIIlllII;
        }
        return this.value[llllllllllllllIlIlllIIlIlIIllllI] = llllllllllllllIlIlllIIlIlIIlllII;
    }
    
    protected void rehash(final int llllllllllllllIlIlllIIIllllIlIlI) {
        final int[] llllllllllllllIlIlllIIIllllIlIIl = this.key;
        final V[] llllllllllllllIlIlllIIIllllIlIII = this.value;
        final int llllllllllllllIlIlllIIIllllIIlll = llllllllllllllIlIlllIIIllllIlIlI - 1;
        final int[] llllllllllllllIlIlllIIIllllIIllI = new int[llllllllllllllIlIlllIIIllllIlIlI + 1];
        final V[] llllllllllllllIlIlllIIIllllIIlIl = (V[])new Object[llllllllllllllIlIlllIIIllllIlIlI + 1];
        int llllllllllllllIlIlllIIIllllIIlII = this.first;
        int llllllllllllllIlIlllIIIllllIIIll = -1;
        int llllllllllllllIlIlllIIIllllIIIlI = -1;
        final long[] llllllllllllllIlIlllIIIllllIIIIl = this.link;
        final long[] llllllllllllllIlIlllIIIllllIIIII = new long[llllllllllllllIlIlllIIIllllIlIlI + 1];
        this.first = -1;
        int llllllllllllllIlIlllIIIllllIllII = this.size;
        while (llllllllllllllIlIlllIIIllllIllII-- != 0) {
            int llllllllllllllIlIlllIIIllllIllIl = 0;
            if (llllllllllllllIlIlllIIIllllIlIIl[llllllllllllllIlIlllIIIllllIIlII] == 0) {
                final int llllllllllllllIlIlllIIIlllllIIIl = llllllllllllllIlIlllIIIllllIlIlI;
            }
            else {
                for (llllllllllllllIlIlllIIIllllIllIl = (HashCommon.mix(llllllllllllllIlIlllIIIllllIlIIl[llllllllllllllIlIlllIIIllllIIlII]) & llllllllllllllIlIlllIIIllllIIlll); llllllllllllllIlIlllIIIllllIIllI[llllllllllllllIlIlllIIIllllIllIl] != 0; llllllllllllllIlIlllIIIllllIllIl = (llllllllllllllIlIlllIIIllllIllIl + 1 & llllllllllllllIlIlllIIIllllIIlll)) {}
            }
            llllllllllllllIlIlllIIIllllIIllI[llllllllllllllIlIlllIIIllllIllIl] = llllllllllllllIlIlllIIIllllIlIIl[llllllllllllllIlIlllIIIllllIIlII];
            llllllllllllllIlIlllIIIllllIIlIl[llllllllllllllIlIlllIIIllllIllIl] = llllllllllllllIlIlllIIIllllIlIII[llllllllllllllIlIlllIIIllllIIlII];
            if (llllllllllllllIlIlllIIIllllIIIll != -1) {
                final long[] array = llllllllllllllIlIlllIIIllllIIIII;
                final int n = llllllllllllllIlIlllIIIllllIIIlI;
                array[n] ^= ((llllllllllllllIlIlllIIIllllIIIII[llllllllllllllIlIlllIIIllllIIIlI] ^ ((long)llllllllllllllIlIlllIIIllllIllIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = llllllllllllllIlIlllIIIllllIIIII;
                final int n2 = llllllllllllllIlIlllIIIllllIllIl;
                array2[n2] ^= ((llllllllllllllIlIlllIIIllllIIIII[llllllllllllllIlIlllIIIllllIllIl] ^ ((long)llllllllllllllIlIlllIIIllllIIIlI & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                llllllllllllllIlIlllIIIllllIIIlI = llllllllllllllIlIlllIIIllllIllIl;
            }
            else {
                final int first = llllllllllllllIlIlllIIIllllIllIl;
                this.first = first;
                llllllllllllllIlIlllIIIllllIIIlI = first;
                llllllllllllllIlIlllIIIllllIIIII[llllllllllllllIlIlllIIIllllIllIl] = -1L;
            }
            final int llllllllllllllIlIlllIIIllllIllll = llllllllllllllIlIlllIIIllllIIlII;
            llllllllllllllIlIlllIIIllllIIlII = (int)llllllllllllllIlIlllIIIllllIIIIl[llllllllllllllIlIlllIIIllllIIlII];
            llllllllllllllIlIlllIIIllllIIIll = llllllllllllllIlIlllIIIllllIllll;
        }
        this.link = llllllllllllllIlIlllIIIllllIIIII;
        if ((this.last = llllllllllllllIlIlllIIIllllIIIlI) != -1) {
            final long[] array3 = llllllllllllllIlIlllIIIllllIIIII;
            final int n3 = llllllllllllllIlIlllIIIllllIIIlI;
            array3[n3] |= 0xFFFFFFFFL;
        }
        this.n = llllllllllllllIlIlllIIIllllIlIlI;
        this.mask = llllllllllllllIlIlllIIIllllIIlll;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = llllllllllllllIlIlllIIIllllIIllI;
        this.value = llllllllllllllIlIlllIIIllllIIlIl;
    }
    
    private void moveIndexToLast(final int llllllllllllllIlIlllIIlllIlIIlll) {
        if (this.size == 1 || this.last == llllllllllllllIlIlllIIlllIlIIlll) {
            return;
        }
        if (this.first == llllllllllllllIlIlllIIlllIlIIlll) {
            this.first = (int)this.link[llllllllllllllIlIlllIIlllIlIIlll];
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        else {
            final long llllllllllllllIlIlllIIlllIlIlIll = this.link[llllllllllllllIlIlllIIlllIlIIlll];
            final int llllllllllllllIlIlllIIlllIlIlIlI = (int)(llllllllllllllIlIlllIIlllIlIlIll >>> 32);
            final int llllllllllllllIlIlllIIlllIlIlIIl = (int)llllllllllllllIlIlllIIlllIlIlIll;
            final long[] link2 = this.link;
            final int n = llllllllllllllIlIlllIIlllIlIlIlI;
            link2[n] ^= ((this.link[llllllllllllllIlIlllIIlllIlIlIlI] ^ (llllllllllllllIlIlllIIlllIlIlIll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = llllllllllllllIlIlllIIlllIlIlIIl;
            link3[n2] ^= ((this.link[llllllllllllllIlIlllIIlllIlIlIIl] ^ (llllllllllllllIlIlllIIlllIlIlIll & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int last = this.last;
        link4[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlIlllIIlllIlIIlll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        this.link[llllllllllllllIlIlllIIlllIlIIlll] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
        this.last = llllllllllllllIlIlllIIlllIlIIlll;
    }
    
    public V getAndMoveToFirst(final int llllllllllllllIlIlllIIlllIIIIlII) {
        if (llllllllllllllIlIlllIIlllIIIIlII == 0) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        else {
            final int[] llllllllllllllIlIlllIIlllIIIIIlI = this.key;
            int llllllllllllllIlIlllIIlllIIIIIIl;
            int llllllllllllllIlIlllIIlllIIIIIll;
            if ((llllllllllllllIlIlllIIlllIIIIIll = llllllllllllllIlIlllIIlllIIIIIlI[llllllllllllllIlIlllIIlllIIIIIIl = (HashCommon.mix(llllllllllllllIlIlllIIlllIIIIlII) & this.mask)]) == 0) {
                return this.defRetValue;
            }
            if (llllllllllllllIlIlllIIlllIIIIlII == llllllllllllllIlIlllIIlllIIIIIll) {
                this.moveIndexToFirst(llllllllllllllIlIlllIIlllIIIIIIl);
                return this.value[llllllllllllllIlIlllIIlllIIIIIIl];
            }
            while ((llllllllllllllIlIlllIIlllIIIIIll = llllllllllllllIlIlllIIlllIIIIIlI[llllllllllllllIlIlllIIlllIIIIIIl = (llllllllllllllIlIlllIIlllIIIIIIl + 1 & this.mask)]) != 0) {
                if (llllllllllllllIlIlllIIlllIIIIlII == llllllllllllllIlIlllIIlllIIIIIll) {
                    this.moveIndexToFirst(llllllllllllllIlIlllIIlllIIIIIIl);
                    return this.value[llllllllllllllIlIlllIIlllIIIIIIl];
                }
            }
            return this.defRetValue;
        }
    }
    
    @Override
    public IntSortedSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }
    
    protected final void shiftKeys(int llllllllllllllIlIlllIIllllllIllI) {
        final int[] llllllllllllllIlIlllIIlllllllIII = this.key;
        int llllllllllllllIlIlllIIlllllllIll = 0;
    Label_0006:
        while (true) {
            llllllllllllllIlIlllIIllllllIllI = ((llllllllllllllIlIlllIIlllllllIll = llllllllllllllIlIlllIIllllllIllI) + 1 & this.mask);
            int llllllllllllllIlIlllIIlllllllIIl;
            while ((llllllllllllllIlIlllIIlllllllIIl = llllllllllllllIlIlllIIlllllllIII[llllllllllllllIlIlllIIllllllIllI]) != 0) {
                final int llllllllllllllIlIlllIIlllllllIlI = HashCommon.mix(llllllllllllllIlIlllIIlllllllIIl) & this.mask;
                Label_0094: {
                    if (llllllllllllllIlIlllIIlllllllIll <= llllllllllllllIlIlllIIllllllIllI) {
                        if (llllllllllllllIlIlllIIlllllllIll >= llllllllllllllIlIlllIIlllllllIlI) {
                            break Label_0094;
                        }
                        if (llllllllllllllIlIlllIIlllllllIlI > llllllllllllllIlIlllIIllllllIllI) {
                            break Label_0094;
                        }
                    }
                    else if (llllllllllllllIlIlllIIlllllllIll >= llllllllllllllIlIlllIIlllllllIlI && llllllllllllllIlIlllIIlllllllIlI > llllllllllllllIlIlllIIllllllIllI) {
                        break Label_0094;
                    }
                    llllllllllllllIlIlllIIllllllIllI = (llllllllllllllIlIlllIIllllllIllI + 1 & this.mask);
                    continue;
                }
                llllllllllllllIlIlllIIlllllllIII[llllllllllllllIlIlllIIlllllllIll] = llllllllllllllIlIlllIIlllllllIIl;
                this.value[llllllllllllllIlIlllIIlllllllIll] = this.value[llllllllllllllIlIlllIIllllllIllI];
                this.fixPointers(llllllllllllllIlIlllIIllllllIllI, llllllllllllllIlIlllIIlllllllIll);
                continue Label_0006;
            }
            break;
        }
        llllllllllllllIlIlllIIlllllllIII[llllllllllllllIlIlllIIlllllllIll] = 0;
        this.value[llllllllllllllIlIlllIIlllllllIll] = null;
    }
    
    public Int2ObjectLinkedOpenHashMap(final int[] llllllllllllllIlIlllIlIIIlIllIIl, final V[] llllllllllllllIlIlllIlIIIlIllIII) {
        this(llllllllllllllIlIlllIlIIIlIllIIl, llllllllllllllIlIlllIlIIIlIllIII, 0.75f);
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNullKey = false;
        Arrays.fill(this.key, 0);
        Arrays.fill(this.value, null);
        final int n = -1;
        this.last = n;
        this.first = n;
    }
    
    public V removeLast() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int llllllllllllllIlIlllIIllllIIlIIl = this.last;
        this.last = (int)(this.link[llllllllllllllIlIlllIIllllIIlIIl] >>> 32);
        if (0 <= this.last) {
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        --this.size;
        final V llllllllllllllIlIlllIIllllIIlIII = this.value[llllllllllllllIlIlllIIllllIIlIIl];
        if (llllllllllllllIlIlllIIllllIIlIIl == this.n) {
            this.containsNullKey = false;
            this.value[this.n] = null;
        }
        else {
            this.shiftKeys(llllllllllllllIlIlllIIllllIIlIIl);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlIlllIIllllIIlIII;
    }
    
    @Override
    public Int2ObjectSortedMap<V> subMap(final int llllllllllllllIlIlllIIlIIlIIlllI, final int llllllllllllllIlIlllIIlIIlIIllIl) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public V replace(final int llllllllllllllIlIlllIIlIllIIlIIl, final V llllllllllllllIlIlllIIlIllIIlIII) {
        final int llllllllllllllIlIlllIIlIllIIllII = this.find(llllllllllllllIlIlllIIlIllIIlIIl);
        if (llllllllllllllIlIlllIIlIllIIllII < 0) {
            return this.defRetValue;
        }
        final V llllllllllllllIlIlllIIlIllIIlIll = this.value[llllllllllllllIlIlllIIlIllIIllII];
        this.value[llllllllllllllIlIlllIIlIllIIllII] = llllllllllllllIlIlllIIlIllIIlIII;
        return llllllllllllllIlIlllIIlIllIIlIll;
    }
    
    @Override
    public Int2ObjectSortedMap<V> headMap(final int llllllllllllllIlIlllIIlIIlIlIIII) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Int2ObjectSortedMap<V> tailMap(final int llllllllllllllIlIlllIIlIIlIlIIlI) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public V computeIfAbsent(final int llllllllllllllIlIlllIIlIlIlllIlI, final IntFunction<? extends V> llllllllllllllIlIlllIIlIlIlllllI) {
        Objects.requireNonNull(llllllllllllllIlIlllIIlIlIlllllI);
        final int llllllllllllllIlIlllIIlIlIllllIl = this.find(llllllllllllllIlIlllIIlIlIlllIlI);
        if (llllllllllllllIlIlllIIlIlIllllIl >= 0) {
            return this.value[llllllllllllllIlIlllIIlIlIllllIl];
        }
        final V llllllllllllllIlIlllIIlIlIllllII = (V)llllllllllllllIlIlllIIlIlIlllllI.apply(llllllllllllllIlIlllIIlIlIlllIlI);
        this.insert(-llllllllllllllIlIlllIIlIlIllllIl - 1, llllllllllllllIlIlllIIlIlIlllIlI, llllllllllllllIlIlllIIlIlIllllII);
        return llllllllllllllIlIlllIIlIlIllllII;
    }
    
    public Int2ObjectLinkedOpenHashMap(final int[] llllllllllllllIlIlllIlIIIllIIlII, final V[] llllllllllllllIlIlllIlIIIllIIIll, final float llllllllllllllIlIlllIlIIIllIIllI) {
        this(llllllllllllllIlIlllIlIIIllIIlII.length, llllllllllllllIlIlllIlIIIllIIllI);
        if (llllllllllllllIlIlllIlIIIllIIlII.length != llllllllllllllIlIlllIlIIIllIIIll.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The key array and the value array have different lengths (").append(llllllllllllllIlIlllIlIIIllIIlII.length).append(" and ").append(llllllllllllllIlIlllIlIIIllIIIll.length).append(")")));
        }
        for (int llllllllllllllIlIlllIlIIIllIlIlI = 0; llllllllllllllIlIlllIlIIIllIlIlI < llllllllllllllIlIlllIlIIIllIIlII.length; ++llllllllllllllIlIlllIlIIIllIlIlI) {
            this.put(llllllllllllllIlIlllIlIIIllIIlII[llllllllllllllIlIlllIlIIIllIlIlI], llllllllllllllIlIlllIlIIIllIIIll[llllllllllllllIlIlllIlIIIllIlIlI]);
        }
    }
    
    @Override
    public int firstIntKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.first];
    }
    
    public Int2ObjectLinkedOpenHashMap(final Map<? extends Integer, ? extends V> llllllllllllllIlIlllIlIIlIIIIllI, final float llllllllllllllIlIlllIlIIlIIIlIII) {
        this(llllllllllllllIlIlllIlIIlIIIIllI.size(), llllllllllllllIlIlllIlIIlIIIlIII);
        this.putAll(llllllllllllllIlIlllIlIIlIIIIllI);
    }
    
    public Int2ObjectLinkedOpenHashMap(final Int2ObjectMap<V> llllllllllllllIlIlllIlIIIlllIIII) {
        this(llllllllllllllIlIlllIlIIIlllIIII, 0.75f);
    }
    
    @Override
    public int size() {
        return this.size;
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
                public boolean contains(final Object lllllllllllllIlIIIIIIlllIlIllIIl) {
                    return Int2ObjectLinkedOpenHashMap.this.containsValue(lllllllllllllIlIIIIIIlllIlIllIIl);
                }
                
                @Override
                public void clear() {
                    Int2ObjectLinkedOpenHashMap.this.clear();
                }
                
                @Override
                public void forEach(final Consumer<? super V> lllllllllllllIlIIIIIIlllIlIlIIII) {
                    if (Int2ObjectLinkedOpenHashMap.this.containsNullKey) {
                        lllllllllllllIlIIIIIIlllIlIlIIII.accept((Object)Int2ObjectLinkedOpenHashMap.this.value[Int2ObjectLinkedOpenHashMap.this.n]);
                    }
                    int lllllllllllllIlIIIIIIlllIlIlIIlI = Int2ObjectLinkedOpenHashMap.this.n;
                    while (lllllllllllllIlIIIIIIlllIlIlIIlI-- != 0) {
                        if (Int2ObjectLinkedOpenHashMap.this.key[lllllllllllllIlIIIIIIlllIlIlIIlI] != 0) {
                            lllllllllllllIlIIIIIIlllIlIlIIII.accept((Object)Int2ObjectLinkedOpenHashMap.this.value[lllllllllllllIlIIIIIIlllIlIlIIlI]);
                        }
                    }
                }
                
                @Override
                public int size() {
                    return Int2ObjectLinkedOpenHashMap.this.size;
                }
            };
        }
        return this.values;
    }
    
    public V getAndMoveToLast(final int llllllllllllllIlIlllIIllIllIllll) {
        if (llllllllllllllIlIlllIIllIllIllll == 0) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        else {
            final int[] llllllllllllllIlIlllIIllIllIllIl = this.key;
            int llllllllllllllIlIlllIIllIllIllII;
            int llllllllllllllIlIlllIIllIllIlllI;
            if ((llllllllllllllIlIlllIIllIllIlllI = llllllllllllllIlIlllIIllIllIllIl[llllllllllllllIlIlllIIllIllIllII = (HashCommon.mix(llllllllllllllIlIlllIIllIllIllll) & this.mask)]) == 0) {
                return this.defRetValue;
            }
            if (llllllllllllllIlIlllIIllIllIllll == llllllllllllllIlIlllIIllIllIlllI) {
                this.moveIndexToLast(llllllllllllllIlIlllIIllIllIllII);
                return this.value[llllllllllllllIlIlllIIllIllIllII];
            }
            while ((llllllllllllllIlIlllIIllIllIlllI = llllllllllllllIlIlllIIllIllIllIl[llllllllllllllIlIlllIIllIllIllII = (llllllllllllllIlIlllIIllIllIllII + 1 & this.mask)]) != 0) {
                if (llllllllllllllIlIlllIIllIllIllll == llllllllllllllIlIlllIIllIllIlllI) {
                    this.moveIndexToLast(llllllllllllllIlIlllIIllIllIllII);
                    return this.value[llllllllllllllIlIlllIIllIllIllII];
                }
            }
            return this.defRetValue;
        }
    }
    
    public Int2ObjectLinkedOpenHashMap(final int llllllllllllllIlIlllIlIIlIIllIII, final float llllllllllllllIlIlllIlIIlIIllIlI) {
        this.first = -1;
        this.last = -1;
        if (llllllllllllllIlIlllIlIIlIIllIlI <= 0.0f || llllllllllllllIlIlllIlIIlIIllIlI > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (llllllllllllllIlIlllIlIIlIIllIII < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = llllllllllllllIlIlllIlIIlIIllIlI;
        final int arraySize = HashCommon.arraySize(llllllllllllllIlIlllIlIIlIIllIII, llllllllllllllIlIlllIlIIlIIllIlI);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, llllllllllllllIlIlllIlIIlIIllIlI);
        this.key = new int[this.n + 1];
        this.value = (V[])new Object[this.n + 1];
        this.link = new long[this.n + 1];
    }
    
    final class MapEntry implements Int2ObjectMap.Entry<V>, Map.Entry<Integer, V>
    {
        /* synthetic */ int index;
        
        @Override
        public int getIntKey() {
            return Int2ObjectLinkedOpenHashMap.this.key[this.index];
        }
        
        @Deprecated
        @Override
        public Integer getKey() {
            return Int2ObjectLinkedOpenHashMap.this.key[this.index];
        }
        
        @Override
        public V setValue(final V lllllllllllllIlIIllIIIllIIllIlII) {
            final V lllllllllllllIlIIllIIIllIIllIIll = Int2ObjectLinkedOpenHashMap.this.value[this.index];
            Int2ObjectLinkedOpenHashMap.this.value[this.index] = lllllllllllllIlIIllIIIllIIllIlII;
            return lllllllllllllIlIIllIIIllIIllIIll;
        }
        
        MapEntry(final int lllllllllllllIlIIllIIIllIlIIIlIl) {
            this.index = lllllllllllllIlIIllIIIllIlIIIlIl;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIlIIllIIIllIIlIIlIl) {
            if (!(lllllllllllllIlIIllIIIllIIlIIlIl instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<Integer, V> lllllllllllllIlIIllIIIllIIlIIlll = (Map.Entry<Integer, V>)lllllllllllllIlIIllIIIllIIlIIlIl;
            return Int2ObjectLinkedOpenHashMap.this.key[this.index] == lllllllllllllIlIIllIIIllIIlIIlll.getKey() && Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[this.index], lllllllllllllIlIIllIIIllIIlIIlll.getValue());
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(Int2ObjectLinkedOpenHashMap.this.key[this.index]).append("=>").append(Int2ObjectLinkedOpenHashMap.this.value[this.index]));
        }
        
        MapEntry() {
        }
        
        @Override
        public int hashCode() {
            return Int2ObjectLinkedOpenHashMap.this.key[this.index] ^ ((Int2ObjectLinkedOpenHashMap.this.value[this.index] == null) ? 0 : Int2ObjectLinkedOpenHashMap.this.value[this.index].hashCode());
        }
        
        @Override
        public V getValue() {
            return Int2ObjectLinkedOpenHashMap.this.value[this.index];
        }
    }
    
    private final class KeySet extends AbstractIntSortedSet
    {
        @Override
        public int lastInt() {
            if (Int2ObjectLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Int2ObjectLinkedOpenHashMap.this.key[Int2ObjectLinkedOpenHashMap.this.last];
        }
        
        @Override
        public IntListIterator iterator(final int lllllllllllllIllIIllIIIIllIlIlll) {
            return new KeyIterator(lllllllllllllIllIIllIIIIllIlIlll);
        }
        
        @Override
        public boolean remove(final int lllllllllllllIllIIllIIIIlIlllIII) {
            final int lllllllllllllIllIIllIIIIlIllIlll = Int2ObjectLinkedOpenHashMap.this.size;
            Int2ObjectLinkedOpenHashMap.this.remove(lllllllllllllIllIIllIIIIlIlllIII);
            return Int2ObjectLinkedOpenHashMap.this.size != lllllllllllllIllIIllIIIIlIllIlll;
        }
        
        @Override
        public boolean contains(final int lllllllllllllIllIIllIIIIlIllllll) {
            return Int2ObjectLinkedOpenHashMap.this.containsKey(lllllllllllllIllIIllIIIIlIllllll);
        }
        
        @Override
        public int firstInt() {
            if (Int2ObjectLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Int2ObjectLinkedOpenHashMap.this.key[Int2ObjectLinkedOpenHashMap.this.first];
        }
        
        @Override
        public IntComparator comparator() {
            return null;
        }
        
        @Override
        public IntSortedSet tailSet(final int lllllllllllllIllIIllIIIIlIlIlIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntSortedSet headSet(final int lllllllllllllIllIIllIIIIlIlIIllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public IntListIterator iterator() {
            return new KeyIterator();
        }
        
        @Override
        public IntSortedSet subSet(final int lllllllllllllIllIIllIIIIlIlIIlII, final int lllllllllllllIllIIllIIIIlIlIIIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
            Int2ObjectLinkedOpenHashMap.this.clear();
        }
        
        @Override
        public void forEach(final IntConsumer lllllllllllllIllIIllIIIIllIIlIII) {
            if (Int2ObjectLinkedOpenHashMap.this.containsNullKey) {
                lllllllllllllIllIIllIIIIllIIlIII.accept(Int2ObjectLinkedOpenHashMap.this.key[Int2ObjectLinkedOpenHashMap.this.n]);
            }
            int lllllllllllllIllIIllIIIIllIIllII = Int2ObjectLinkedOpenHashMap.this.n;
            while (lllllllllllllIllIIllIIIIllIIllII-- != 0) {
                final int lllllllllllllIllIIllIIIIllIIllIl = Int2ObjectLinkedOpenHashMap.this.key[lllllllllllllIllIIllIIIIllIIllII];
                if (lllllllllllllIllIIllIIIIllIIllIl != 0) {
                    lllllllllllllIllIIllIIIIllIIlIII.accept(lllllllllllllIllIIllIIIIllIIllIl);
                }
            }
        }
        
        @Override
        public int size() {
            return Int2ObjectLinkedOpenHashMap.this.size;
        }
    }
    
    private final class KeyIterator extends MapIterator implements IntListIterator
    {
        public KeyIterator(final int llllllllllllllIllIIIlIlllllIIIlI) {
            super(llllllllllllllIllIIIlIlllllIIIlI);
        }
        
        public KeyIterator() {
        }
        
        @Override
        public int nextInt() {
            return Int2ObjectLinkedOpenHashMap.this.key[this.nextEntry()];
        }
        
        @Override
        public int previousInt() {
            return Int2ObjectLinkedOpenHashMap.this.key[this.previousEntry()];
        }
    }
    
    private class MapIterator
    {
        /* synthetic */ int next;
        /* synthetic */ int index;
        /* synthetic */ int curr;
        /* synthetic */ int prev;
        
        public int previousEntry() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int)(Int2ObjectLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                --this.index;
            }
            return this.curr;
        }
        
        public int back(final int llllllllllllllIIlIlIlIllIIllIlll) {
            int llllllllllllllIIlIlIlIllIIlllIIl = llllllllllllllIIlIlIlIllIIllIlll;
            while (llllllllllllllIIlIlIlIllIIlllIIl-- != 0 && this.hasPrevious()) {
                this.previousEntry();
            }
            return llllllllllllllIIlIlIlIllIIllIlll - llllllllllllllIIlIlIlIllIIlllIIl - 1;
        }
        
        public int previousIndex() {
            this.ensureIndexKnown();
            return this.index - 1;
        }
        
        public void add(final Int2ObjectMap.Entry<V> llllllllllllllIIlIlIlIllIIllIIlI) {
            throw new UnsupportedOperationException();
        }
        
        public void set(final Int2ObjectMap.Entry<V> llllllllllllllIIlIlIlIllIIllIlII) {
            throw new UnsupportedOperationException();
        }
        
        public int nextEntry() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int)Int2ObjectLinkedOpenHashMap.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                ++this.index;
            }
            return this.curr;
        }
        
        protected MapIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = Int2ObjectLinkedOpenHashMap.this.first;
            this.index = 0;
        }
        
        public void remove() {
            this.ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                --this.index;
                this.prev = (int)(Int2ObjectLinkedOpenHashMap.this.link[this.curr] >>> 32);
            }
            else {
                this.next = (int)Int2ObjectLinkedOpenHashMap.this.link[this.curr];
            }
            final Int2ObjectLinkedOpenHashMap this$0 = Int2ObjectLinkedOpenHashMap.this;
            --this$0.size;
            if (this.prev == -1) {
                Int2ObjectLinkedOpenHashMap.this.first = this.next;
            }
            else {
                final long[] link = Int2ObjectLinkedOpenHashMap.this.link;
                final int prev = this.prev;
                link[prev] ^= ((Int2ObjectLinkedOpenHashMap.this.link[this.prev] ^ ((long)this.next & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            }
            if (this.next == -1) {
                Int2ObjectLinkedOpenHashMap.this.last = this.prev;
            }
            else {
                final long[] link2 = Int2ObjectLinkedOpenHashMap.this.link;
                final int next = this.next;
                link2[next] ^= ((Int2ObjectLinkedOpenHashMap.this.link[this.next] ^ ((long)this.prev & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            }
            int llllllllllllllIIlIlIlIllIlIIlllI = this.curr;
            this.curr = -1;
            if (llllllllllllllIIlIlIlIllIlIIlllI == Int2ObjectLinkedOpenHashMap.this.n) {
                Int2ObjectLinkedOpenHashMap.this.containsNullKey = false;
                Int2ObjectLinkedOpenHashMap.this.value[Int2ObjectLinkedOpenHashMap.this.n] = null;
                return;
            }
            final int[] llllllllllllllIIlIlIlIllIlIlIIlI = Int2ObjectLinkedOpenHashMap.this.key;
            int llllllllllllllIIlIlIlIllIlIlIIIl = 0;
        Label_0280:
            while (true) {
                llllllllllllllIIlIlIlIllIlIIlllI = ((llllllllllllllIIlIlIlIllIlIlIIIl = llllllllllllllIIlIlIlIllIlIIlllI) + 1 & Int2ObjectLinkedOpenHashMap.this.mask);
                int llllllllllllllIIlIlIlIllIlIlIIll;
                while ((llllllllllllllIIlIlIlIllIlIlIIll = llllllllllllllIIlIlIlIllIlIlIIlI[llllllllllllllIIlIlIlIllIlIIlllI]) != 0) {
                    final int llllllllllllllIIlIlIlIllIlIlIIII = HashCommon.mix(llllllllllllllIIlIlIlIllIlIlIIll) & Int2ObjectLinkedOpenHashMap.this.mask;
                    Label_0380: {
                        if (llllllllllllllIIlIlIlIllIlIlIIIl <= llllllllllllllIIlIlIlIllIlIIlllI) {
                            if (llllllllllllllIIlIlIlIllIlIlIIIl >= llllllllllllllIIlIlIlIllIlIlIIII) {
                                break Label_0380;
                            }
                            if (llllllllllllllIIlIlIlIllIlIlIIII > llllllllllllllIIlIlIlIllIlIIlllI) {
                                break Label_0380;
                            }
                        }
                        else if (llllllllllllllIIlIlIlIllIlIlIIIl >= llllllllllllllIIlIlIlIllIlIlIIII && llllllllllllllIIlIlIlIllIlIlIIII > llllllllllllllIIlIlIlIllIlIIlllI) {
                            break Label_0380;
                        }
                        llllllllllllllIIlIlIlIllIlIIlllI = (llllllllllllllIIlIlIlIllIlIIlllI + 1 & Int2ObjectLinkedOpenHashMap.this.mask);
                        continue;
                    }
                    llllllllllllllIIlIlIlIllIlIlIIlI[llllllllllllllIIlIlIlIllIlIlIIIl] = llllllllllllllIIlIlIlIllIlIlIIll;
                    Int2ObjectLinkedOpenHashMap.this.value[llllllllllllllIIlIlIlIllIlIlIIIl] = Int2ObjectLinkedOpenHashMap.this.value[llllllllllllllIIlIlIlIllIlIIlllI];
                    if (this.next == llllllllllllllIIlIlIlIllIlIIlllI) {
                        this.next = llllllllllllllIIlIlIlIllIlIlIIIl;
                    }
                    if (this.prev == llllllllllllllIIlIlIlIllIlIIlllI) {
                        this.prev = llllllllllllllIIlIlIlIllIlIlIIIl;
                    }
                    Int2ObjectLinkedOpenHashMap.this.fixPointers(llllllllllllllIIlIlIlIllIlIIlllI, llllllllllllllIIlIlIlIllIlIlIIIl);
                    continue Label_0280;
                }
                break;
            }
            llllllllllllllIIlIlIlIllIlIlIIlI[llllllllllllllIIlIlIlIllIlIlIIIl] = 0;
            Int2ObjectLinkedOpenHashMap.this.value[llllllllllllllIIlIlIlIllIlIlIIIl] = null;
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
                this.index = Int2ObjectLinkedOpenHashMap.this.size;
                return;
            }
            int llllllllllllllIIlIlIlIllIllIlIII = Int2ObjectLinkedOpenHashMap.this.first;
            this.index = 1;
            while (llllllllllllllIIlIlIlIllIllIlIII != this.prev) {
                llllllllllllllIIlIlIlIllIllIlIII = (int)Int2ObjectLinkedOpenHashMap.this.link[llllllllllllllIIlIlIlIllIllIlIII];
                ++this.index;
            }
        }
        
        public boolean hasPrevious() {
            return this.prev != -1;
        }
        
        private MapIterator(final int llllllllllllllIIlIlIlIllIlllIIll) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (llllllllllllllIIlIlIlIllIlllIIll == 0) {
                if (Int2ObjectLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int)Int2ObjectLinkedOpenHashMap.this.link[Int2ObjectLinkedOpenHashMap.this.n];
                    this.prev = Int2ObjectLinkedOpenHashMap.this.n;
                    return;
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(llllllllllllllIIlIlIlIllIlllIIll).append(" does not belong to this map.")));
            }
            else {
                if (Int2ObjectLinkedOpenHashMap.this.key[Int2ObjectLinkedOpenHashMap.this.last] == llllllllllllllIIlIlIlIllIlllIIll) {
                    this.prev = Int2ObjectLinkedOpenHashMap.this.last;
                    this.index = Int2ObjectLinkedOpenHashMap.this.size;
                    return;
                }
                for (int llllllllllllllIIlIlIlIllIlllIllI = HashCommon.mix(llllllllllllllIIlIlIlIllIlllIIll) & Int2ObjectLinkedOpenHashMap.this.mask; Int2ObjectLinkedOpenHashMap.this.key[llllllllllllllIIlIlIlIllIlllIllI] != 0; llllllllllllllIIlIlIlIllIlllIllI = (llllllllllllllIIlIlIlIllIlllIllI + 1 & Int2ObjectLinkedOpenHashMap.this.mask)) {
                    if (Int2ObjectLinkedOpenHashMap.this.key[llllllllllllllIIlIlIlIllIlllIllI] == llllllllllllllIIlIlIlIllIlllIIll) {
                        this.next = (int)Int2ObjectLinkedOpenHashMap.this.link[llllllllllllllIIlIlIlIllIlllIllI];
                        this.prev = llllllllllllllIIlIlIlIllIlllIllI;
                        return;
                    }
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(llllllllllllllIIlIlIlIllIlllIIll).append(" does not belong to this map.")));
            }
        }
        
        public boolean hasNext() {
            return this.next != -1;
        }
        
        public int skip(final int llllllllllllllIIlIlIlIllIlIIIIII) {
            int llllllllllllllIIlIlIlIllIlIIIIlI = llllllllllllllIIlIlIlIllIlIIIIII;
            while (llllllllllllllIIlIlIlIllIlIIIIlI-- != 0 && this.hasNext()) {
                this.nextEntry();
            }
            return llllllllllllllIIlIlIlIllIlIIIIII - llllllllllllllIIlIlIlIllIlIIIIlI - 1;
        }
        
        public int nextIndex() {
            this.ensureIndexKnown();
            return this.index;
        }
    }
    
    private final class MapEntrySet extends AbstractObjectSortedSet<Int2ObjectMap.Entry<V>> implements Int2ObjectSortedMap.FastSortedEntrySet<V>
    {
        @Override
        public int size() {
            return Int2ObjectLinkedOpenHashMap.this.size;
        }
        
        @Override
        public ObjectListIterator<Int2ObjectMap.Entry<V>> iterator(final Int2ObjectMap.Entry<V> lllllllllllllIIIIIllIllllllIIlIl) {
            return new EntryIterator(lllllllllllllIIIIIllIllllllIIlIl.getIntKey());
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIIIIIllIlllllllIlIl) {
            if (!(lllllllllllllIIIIIllIlllllllIlIl instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIIIIIllIlllllllllII = (Map.Entry<?, ?>)lllllllllllllIIIIIllIlllllllIlIl;
            if (lllllllllllllIIIIIllIlllllllllII.getKey() == null || !(lllllllllllllIIIIIllIlllllllllII.getKey() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIIIIIllIllllllllIll = (int)lllllllllllllIIIIIllIlllllllllII.getKey();
            final V lllllllllllllIIIIIllIllllllllIlI = (V)lllllllllllllIIIIIllIlllllllllII.getValue();
            if (lllllllllllllIIIIIllIllllllllIll == 0) {
                if (Int2ObjectLinkedOpenHashMap.this.containsNullKey && Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[Int2ObjectLinkedOpenHashMap.this.n], lllllllllllllIIIIIllIllllllllIlI)) {
                    Int2ObjectLinkedOpenHashMap.this.removeNullEntry();
                    return true;
                }
                return false;
            }
            else {
                final int[] lllllllllllllIIIIIllIllllllllIII = Int2ObjectLinkedOpenHashMap.this.key;
                int lllllllllllllIIIIIllIlllllllIlll;
                int lllllllllllllIIIIIllIllllllllIIl;
                if ((lllllllllllllIIIIIllIllllllllIIl = lllllllllllllIIIIIllIllllllllIII[lllllllllllllIIIIIllIlllllllIlll = (HashCommon.mix(lllllllllllllIIIIIllIllllllllIll) & Int2ObjectLinkedOpenHashMap.this.mask)]) == 0) {
                    return false;
                }
                if (lllllllllllllIIIIIllIllllllllIIl != lllllllllllllIIIIIllIllllllllIll) {
                    while ((lllllllllllllIIIIIllIllllllllIIl = lllllllllllllIIIIIllIllllllllIII[lllllllllllllIIIIIllIlllllllIlll = (lllllllllllllIIIIIllIlllllllIlll + 1 & Int2ObjectLinkedOpenHashMap.this.mask)]) != 0) {
                        if (lllllllllllllIIIIIllIllllllllIIl == lllllllllllllIIIIIllIllllllllIll && Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[lllllllllllllIIIIIllIlllllllIlll], lllllllllllllIIIIIllIllllllllIlI)) {
                            Int2ObjectLinkedOpenHashMap.this.removeEntry(lllllllllllllIIIIIllIlllllllIlll);
                            return true;
                        }
                    }
                    return false;
                }
                if (Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[lllllllllllllIIIIIllIlllllllIlll], lllllllllllllIIIIIllIllllllllIlI)) {
                    Int2ObjectLinkedOpenHashMap.this.removeEntry(lllllllllllllIIIIIllIlllllllIlll);
                    return true;
                }
                return false;
            }
        }
        
        @Override
        public ObjectBidirectionalIterator<Int2ObjectMap.Entry<V>> iterator() {
            return new EntryIterator();
        }
        
        @Override
        public void forEach(final Consumer<? super Int2ObjectMap.Entry<V>> lllllllllllllIIIIIllIlllllIIlllI) {
            int lllllllllllllIIIIIllIlllllIlIlII = Int2ObjectLinkedOpenHashMap.this.size;
            int lllllllllllllIIIIIllIlllllIlIIlI = Int2ObjectLinkedOpenHashMap.this.first;
            while (lllllllllllllIIIIIllIlllllIlIlII-- != 0) {
                final int lllllllllllllIIIIIllIlllllIlIIll = lllllllllllllIIIIIllIlllllIlIIlI;
                lllllllllllllIIIIIllIlllllIlIIlI = (int)Int2ObjectLinkedOpenHashMap.this.link[lllllllllllllIIIIIllIlllllIlIIll];
                lllllllllllllIIIIIllIlllllIIlllI.accept((Object)new BasicEntry(Int2ObjectLinkedOpenHashMap.this.key[lllllllllllllIIIIIllIlllllIlIIll], (V)Int2ObjectLinkedOpenHashMap.this.value[lllllllllllllIIIIIllIlllllIlIIll]));
            }
        }
        
        @Override
        public Int2ObjectMap.Entry<V> last() {
            if (Int2ObjectLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Int2ObjectLinkedOpenHashMap.this.last);
        }
        
        @Override
        public void fastForEach(final Consumer<? super Int2ObjectMap.Entry<V>> lllllllllllllIIIIIllIllllIllllIl) {
            final BasicEntry<V> lllllllllllllIIIIIllIllllIllllll = new BasicEntry<V>();
            int lllllllllllllIIIIIllIlllllIIIlII = Int2ObjectLinkedOpenHashMap.this.size;
            int lllllllllllllIIIIIllIlllllIIIIlI = Int2ObjectLinkedOpenHashMap.this.first;
            while (lllllllllllllIIIIIllIlllllIIIlII-- != 0) {
                final int lllllllllllllIIIIIllIlllllIIIIll = lllllllllllllIIIIIllIlllllIIIIlI;
                lllllllllllllIIIIIllIlllllIIIIlI = (int)Int2ObjectLinkedOpenHashMap.this.link[lllllllllllllIIIIIllIlllllIIIIll];
                lllllllllllllIIIIIllIllllIllllll.key = Int2ObjectLinkedOpenHashMap.this.key[lllllllllllllIIIIIllIlllllIIIIll];
                lllllllllllllIIIIIllIllllIllllll.value = Int2ObjectLinkedOpenHashMap.this.value[lllllllllllllIIIIIllIlllllIIIIll];
                lllllllllllllIIIIIllIllllIllllIl.accept(lllllllllllllIIIIIllIllllIllllll);
            }
        }
        
        @Override
        public ObjectListIterator<Int2ObjectMap.Entry<V>> fastIterator(final Int2ObjectMap.Entry<V> lllllllllllllIIIIIllIlllllIlllII) {
            return new FastEntryIterator(lllllllllllllIIIIIllIlllllIlllII.getIntKey());
        }
        
        @Override
        public ObjectSortedSet<Int2ObjectMap.Entry<V>> subSet(final Int2ObjectMap.Entry<V> lllllllllllllIIIIIlllIIIIIlIlIlI, final Int2ObjectMap.Entry<V> lllllllllllllIIIIIlllIIIIIlIlIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public ObjectSortedSet<Int2ObjectMap.Entry<V>> headSet(final Int2ObjectMap.Entry<V> lllllllllllllIIIIIlllIIIIIlIIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIIIIIlllIIIIIIlIlIl) {
            if (!(lllllllllllllIIIIIlllIIIIIIlIlIl instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIIIIIlllIIIIIIlIlII = (Map.Entry<?, ?>)lllllllllllllIIIIIlllIIIIIIlIlIl;
            if (lllllllllllllIIIIIlllIIIIIIlIlII.getKey() == null || !(lllllllllllllIIIIIlllIIIIIIlIlII.getKey() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIIIIIlllIIIIIIlIIll = (int)lllllllllllllIIIIIlllIIIIIIlIlII.getKey();
            final V lllllllllllllIIIIIlllIIIIIIlIIlI = (V)lllllllllllllIIIIIlllIIIIIIlIlII.getValue();
            if (lllllllllllllIIIIIlllIIIIIIlIIll == 0) {
                return Int2ObjectLinkedOpenHashMap.this.containsNullKey && Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[Int2ObjectLinkedOpenHashMap.this.n], lllllllllllllIIIIIlllIIIIIIlIIlI);
            }
            final int[] lllllllllllllIIIIIlllIIIIIIlIIII = Int2ObjectLinkedOpenHashMap.this.key;
            int lllllllllllllIIIIIlllIIIIIIIllll;
            int lllllllllllllIIIIIlllIIIIIIlIIIl;
            if ((lllllllllllllIIIIIlllIIIIIIlIIIl = lllllllllllllIIIIIlllIIIIIIlIIII[lllllllllllllIIIIIlllIIIIIIIllll = (HashCommon.mix(lllllllllllllIIIIIlllIIIIIIlIIll) & Int2ObjectLinkedOpenHashMap.this.mask)]) == 0) {
                return false;
            }
            if (lllllllllllllIIIIIlllIIIIIIlIIll == lllllllllllllIIIIIlllIIIIIIlIIIl) {
                return Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[lllllllllllllIIIIIlllIIIIIIIllll], lllllllllllllIIIIIlllIIIIIIlIIlI);
            }
            while ((lllllllllllllIIIIIlllIIIIIIlIIIl = lllllllllllllIIIIIlllIIIIIIlIIII[lllllllllllllIIIIIlllIIIIIIIllll = (lllllllllllllIIIIIlllIIIIIIIllll + 1 & Int2ObjectLinkedOpenHashMap.this.mask)]) != 0) {
                if (lllllllllllllIIIIIlllIIIIIIlIIll == lllllllllllllIIIIIlllIIIIIIlIIIl) {
                    return Objects.equals(Int2ObjectLinkedOpenHashMap.this.value[lllllllllllllIIIIIlllIIIIIIIllll], lllllllllllllIIIIIlllIIIIIIlIIlI);
                }
            }
            return false;
        }
        
        @Override
        public ObjectListIterator<Int2ObjectMap.Entry<V>> fastIterator() {
            return new FastEntryIterator();
        }
        
        @Override
        public void clear() {
            Int2ObjectLinkedOpenHashMap.this.clear();
        }
        
        @Override
        public ObjectSortedSet<Int2ObjectMap.Entry<V>> tailSet(final Int2ObjectMap.Entry<V> lllllllllllllIIIIIlllIIIIIlIIlIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Int2ObjectMap.Entry<V> first() {
            if (Int2ObjectLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Int2ObjectLinkedOpenHashMap.this.first);
        }
        
        @Override
        public Comparator<? super Int2ObjectMap.Entry<V>> comparator() {
            return null;
        }
    }
    
    private class EntryIterator extends MapIterator implements ObjectListIterator<Int2ObjectMap.Entry<V>>
    {
        private /* synthetic */ MapEntry entry;
        
        @Override
        public MapEntry next() {
            final MapEntry entry = new MapEntry(this.nextEntry());
            this.entry = entry;
            return entry;
        }
        
        public EntryIterator() {
        }
        
        @Override
        public MapEntry previous() {
            final MapEntry entry = new MapEntry(this.previousEntry());
            this.entry = entry;
            return entry;
        }
        
        public EntryIterator(final int lllllllllllllllIllIllIllIlIIlIIl) {
            super(lllllllllllllllIllIllIllIlIIlIIl);
        }
        
        @Override
        public void remove() {
            super.remove();
            this.entry.index = -1;
        }
    }
    
    private class FastEntryIterator extends MapIterator implements ObjectListIterator<Int2ObjectMap.Entry<V>>
    {
        final /* synthetic */ MapEntry entry;
        
        @Override
        public MapEntry next() {
            this.entry.index = this.nextEntry();
            return this.entry;
        }
        
        @Override
        public MapEntry previous() {
            this.entry.index = this.previousEntry();
            return this.entry;
        }
        
        public FastEntryIterator() {
            this.entry = new MapEntry();
        }
        
        public FastEntryIterator(final int lllllllllllllllllIIlllIlIIlllIlI) {
            super(lllllllllllllllllIIlllIlIIlllIlI);
            this.entry = new MapEntry();
        }
    }
    
    private final class ValueIterator extends MapIterator implements ObjectListIterator<V>
    {
        public ValueIterator() {
        }
        
        @Override
        public V next() {
            return Int2ObjectLinkedOpenHashMap.this.value[this.nextEntry()];
        }
        
        @Override
        public V previous() {
            return Int2ObjectLinkedOpenHashMap.this.value[this.previousEntry()];
        }
    }
}
