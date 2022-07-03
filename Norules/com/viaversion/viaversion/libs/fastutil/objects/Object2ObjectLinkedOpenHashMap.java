package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import java.util.function.*;
import java.util.*;

public class Object2ObjectLinkedOpenHashMap<K, V> extends AbstractObject2ObjectSortedMap<K, V> implements Serializable, Cloneable, Hash
{
    protected transient /* synthetic */ ObjectSortedSet<K> keys;
    protected transient /* synthetic */ int mask;
    protected transient /* synthetic */ Object2ObjectSortedMap.FastSortedEntrySet<K, V> entries;
    protected transient /* synthetic */ boolean containsNullKey;
    protected transient /* synthetic */ int n;
    protected transient /* synthetic */ V[] value;
    protected transient /* synthetic */ long[] link;
    protected transient /* synthetic */ int last;
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ K[] key;
    protected transient /* synthetic */ ObjectCollection<V> values;
    protected final /* synthetic */ float f;
    protected transient /* synthetic */ int first;
    protected /* synthetic */ int size;
    protected final transient /* synthetic */ int minN;
    
    @Override
    public K firstKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.first];
    }
    
    public Object2ObjectLinkedOpenHashMap<K, V> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap;
        //     7: astore_1        /* llllllllllllllIlllIllIIIIIIllllI */
        //     8: goto            20
        //    11: astore_2        /* llllllllllllllIlllIllIIIIIIlllIl */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllllIlllIllIIIIIIllIll */
        //    21: aconst_null    
        //    22: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.keys:Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectSortedSet;
        //    25: aload_1         /* llllllllllllllIlllIllIIIIIIllIll */
        //    26: aconst_null    
        //    27: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.values:Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectCollection;
        //    30: aload_1         /* llllllllllllllIlllIllIIIIIIllIll */
        //    31: aconst_null    
        //    32: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.entries:Lcom/viaversion/viaversion/libs/fastutil/objects/Object2ObjectSortedMap$FastSortedEntrySet;
        //    35: aload_1         /* llllllllllllllIlllIllIIIIIIllIll */
        //    36: aload_0         /* llllllllllllllIlllIllIIIIIIlllII */
        //    37: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.containsNullKey:Z
        //    40: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.containsNullKey:Z
        //    43: aload_1         /* llllllllllllllIlllIllIIIIIIllIll */
        //    44: aload_0         /* llllllllllllllIlllIllIIIIIIlllII */
        //    45: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.key:[Ljava/lang/Object;
        //    48: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    51: checkcast       [Ljava/lang/Object;
        //    54: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.key:[Ljava/lang/Object;
        //    57: aload_1         /* llllllllllllllIlllIllIIIIIIllIll */
        //    58: aload_0         /* llllllllllllllIlllIllIIIIIIlllII */
        //    59: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.value:[Ljava/lang/Object;
        //    62: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    65: checkcast       [Ljava/lang/Object;
        //    68: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.value:[Ljava/lang/Object;
        //    71: aload_1         /* llllllllllllllIlllIllIIIIIIllIll */
        //    72: aload_0         /* llllllllllllllIlllIllIIIIIIlllII */
        //    73: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.link:[J
        //    76: invokevirtual   [J.clone:()Ljava/lang/Object;
        //    79: checkcast       [J
        //    82: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap.link:[J
        //    85: aload_1         /* llllllllllllllIlllIllIIIIIIllIll */
        //    86: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/objects/Object2ObjectLinkedOpenHashMap<TK;TV;>;
        //    StackMapTable: 00 02 4B 07 00 63 FC 00 08 07 00 02
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
    public V put(final K llllllllllllllIlllIllIIlIlllIIIl, final V llllllllllllllIlllIllIIlIlllIlIl) {
        final int llllllllllllllIlllIllIIlIlllIlII = this.find(llllllllllllllIlllIllIIlIlllIIIl);
        if (llllllllllllllIlllIllIIlIlllIlII < 0) {
            this.insert(-llllllllllllllIlllIllIIlIlllIlII - 1, llllllllllllllIlllIllIIlIlllIIIl, llllllllllllllIlllIllIIlIlllIlIl);
            return this.defRetValue;
        }
        final V llllllllllllllIlllIllIIlIlllIIll = this.value[llllllllllllllIlllIllIIlIlllIlII];
        this.value[llllllllllllllIlllIllIIlIlllIlII] = llllllllllllllIlllIllIIlIlllIlIl;
        return llllllllllllllIlllIllIIlIlllIIll;
    }
    
    public Object2ObjectLinkedOpenHashMap(final int llllllllllllllIlllIllIlIIIIIIlIl, final float llllllllllllllIlllIllIlIIIIIIlII) {
        this.first = -1;
        this.last = -1;
        if (llllllllllllllIlllIllIlIIIIIIlII <= 0.0f || llllllllllllllIlllIllIlIIIIIIlII > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (llllllllllllllIlllIllIlIIIIIIlIl < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = llllllllllllllIlllIllIlIIIIIIlII;
        final int arraySize = HashCommon.arraySize(llllllllllllllIlllIllIlIIIIIIlIl, llllllllllllllIlllIllIlIIIIIIlII);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, llllllllllllllIlllIllIlIIIIIIlII);
        this.key = (K[])new Object[this.n + 1];
        this.value = (V[])new Object[this.n + 1];
        this.link = new long[this.n + 1];
    }
    
    @Override
    public Comparator<? super K> comparator() {
        return null;
    }
    
    @Override
    public boolean containsValue(final Object llllllllllllllIlllIllIIIlIlIIlll) {
        final V[] llllllllllllllIlllIllIIIlIlIIllI = this.value;
        final K[] llllllllllllllIlllIllIIIlIlIIlIl = this.key;
        if (this.containsNullKey && Objects.equals(llllllllllllllIlllIllIIIlIlIIllI[this.n], llllllllllllllIlllIllIIIlIlIIlll)) {
            return true;
        }
        int llllllllllllllIlllIllIIIlIlIlIIl = this.n;
        while (llllllllllllllIlllIllIIIlIlIlIIl-- != 0) {
            if (llllllllllllllIlllIllIIIlIlIIlIl[llllllllllllllIlllIllIIIlIlIlIIl] != null && Objects.equals(llllllllllllllIlllIllIIIlIlIIllI[llllllllllllllIlllIllIIIlIlIlIIl], llllllllllllllIlllIllIIIlIlIIlll)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public V get(final Object llllllllllllllIlllIllIIIllIIIllI) {
        if (llllllllllllllIlllIllIIIllIIIllI == null) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        }
        final K[] llllllllllllllIlllIllIIIllIIIlII = this.key;
        int llllllllllllllIlllIllIIIllIIIIll;
        K llllllllllllllIlllIllIIIllIIIlIl;
        if ((llllllllllllllIlllIllIIIllIIIlIl = llllllllllllllIlllIllIIIllIIIlII[llllllllllllllIlllIllIIIllIIIIll = (HashCommon.mix(llllllllllllllIlllIllIIIllIIIllI.hashCode()) & this.mask)]) == null) {
            return this.defRetValue;
        }
        if (llllllllllllllIlllIllIIIllIIIllI.equals(llllllllllllllIlllIllIIIllIIIlIl)) {
            return this.value[llllllllllllllIlllIllIIIllIIIIll];
        }
        while ((llllllllllllllIlllIllIIIllIIIlIl = llllllllllllllIlllIllIIIllIIIlII[llllllllllllllIlllIllIIIllIIIIll = (llllllllllllllIlllIllIIIllIIIIll + 1 & this.mask)]) != null) {
            if (llllllllllllllIlllIllIIIllIIIllI.equals(llllllllllllllIlllIllIIIllIIIlIl)) {
                return this.value[llllllllllllllIlllIllIIIllIIIIll];
            }
        }
        return this.defRetValue;
    }
    
    private void moveIndexToLast(final int llllllllllllllIlllIllIIlIIIlIlII) {
        if (this.size == 1 || this.last == llllllllllllllIlllIllIIlIIIlIlII) {
            return;
        }
        if (this.first == llllllllllllllIlllIllIIlIIIlIlII) {
            this.first = (int)this.link[llllllllllllllIlllIllIIlIIIlIlII];
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        else {
            final long llllllllllllllIlllIllIIlIIIllIlI = this.link[llllllllllllllIlllIllIIlIIIlIlII];
            final int llllllllllllllIlllIllIIlIIIllIIl = (int)(llllllllllllllIlllIllIIlIIIllIlI >>> 32);
            final int llllllllllllllIlllIllIIlIIIllIII = (int)llllllllllllllIlllIllIIlIIIllIlI;
            final long[] link2 = this.link;
            final int n = llllllllllllllIlllIllIIlIIIllIIl;
            link2[n] ^= ((this.link[llllllllllllllIlllIllIIlIIIllIIl] ^ (llllllllllllllIlllIllIIlIIIllIlI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = llllllllllllllIlllIllIIlIIIllIII;
            link3[n2] ^= ((this.link[llllllllllllllIlllIllIIlIIIllIII] ^ (llllllllllllllIlllIllIIlIIIllIlI & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int last = this.last;
        link4[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlllIllIIlIIIlIlII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        this.link[llllllllllllllIlllIllIIlIIIlIlII] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
        this.last = llllllllllllllIlllIllIIlIIIlIlII;
    }
    
    protected void rehash(final int llllllllllllllIlllIllIIIIIlIllll) {
        final K[] llllllllllllllIlllIllIIIIIlllIlI = this.key;
        final V[] llllllllllllllIlllIllIIIIIlllIIl = this.value;
        final int llllllllllllllIlllIllIIIIIlllIII = llllllllllllllIlllIllIIIIIlIllll - 1;
        final K[] llllllllllllllIlllIllIIIIIllIlll = (K[])new Object[llllllllllllllIlllIllIIIIIlIllll + 1];
        final V[] llllllllllllllIlllIllIIIIIllIllI = (V[])new Object[llllllllllllllIlllIllIIIIIlIllll + 1];
        int llllllllllllllIlllIllIIIIIllIlIl = this.first;
        int llllllllllllllIlllIllIIIIIllIlII = -1;
        int llllllllllllllIlllIllIIIIIllIIll = -1;
        final long[] llllllllllllllIlllIllIIIIIllIIlI = this.link;
        final long[] llllllllllllllIlllIllIIIIIllIIIl = new long[llllllllllllllIlllIllIIIIIlIllll + 1];
        this.first = -1;
        int llllllllllllllIlllIllIIIIIllllIl = this.size;
        while (llllllllllllllIlllIllIIIIIllllIl-- != 0) {
            int llllllllllllllIlllIllIIIIIlllllI = 0;
            if (llllllllllllllIlllIllIIIIIlllIlI[llllllllllllllIlllIllIIIIIllIlIl] == null) {
                final int llllllllllllllIlllIllIIIIlIIIIII = llllllllllllllIlllIllIIIIIlIllll;
            }
            else {
                for (llllllllllllllIlllIllIIIIIlllllI = (HashCommon.mix(llllllllllllllIlllIllIIIIIlllIlI[llllllllllllllIlllIllIIIIIllIlIl].hashCode()) & llllllllllllllIlllIllIIIIIlllIII); llllllllllllllIlllIllIIIIIllIlll[llllllllllllllIlllIllIIIIIlllllI] != null; llllllllllllllIlllIllIIIIIlllllI = (llllllllllllllIlllIllIIIIIlllllI + 1 & llllllllllllllIlllIllIIIIIlllIII)) {}
            }
            llllllllllllllIlllIllIIIIIllIlll[llllllllllllllIlllIllIIIIIlllllI] = llllllllllllllIlllIllIIIIIlllIlI[llllllllllllllIlllIllIIIIIllIlIl];
            llllllllllllllIlllIllIIIIIllIllI[llllllllllllllIlllIllIIIIIlllllI] = llllllllllllllIlllIllIIIIIlllIIl[llllllllllllllIlllIllIIIIIllIlIl];
            if (llllllllllllllIlllIllIIIIIllIlII != -1) {
                final long[] array = llllllllllllllIlllIllIIIIIllIIIl;
                final int n = llllllllllllllIlllIllIIIIIllIIll;
                array[n] ^= ((llllllllllllllIlllIllIIIIIllIIIl[llllllllllllllIlllIllIIIIIllIIll] ^ ((long)llllllllllllllIlllIllIIIIIlllllI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = llllllllllllllIlllIllIIIIIllIIIl;
                final int n2 = llllllllllllllIlllIllIIIIIlllllI;
                array2[n2] ^= ((llllllllllllllIlllIllIIIIIllIIIl[llllllllllllllIlllIllIIIIIlllllI] ^ ((long)llllllllllllllIlllIllIIIIIllIIll & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                llllllllllllllIlllIllIIIIIllIIll = llllllllllllllIlllIllIIIIIlllllI;
            }
            else {
                final int first = llllllllllllllIlllIllIIIIIlllllI;
                this.first = first;
                llllllllllllllIlllIllIIIIIllIIll = first;
                llllllllllllllIlllIllIIIIIllIIIl[llllllllllllllIlllIllIIIIIlllllI] = -1L;
            }
            final int llllllllllllllIlllIllIIIIIllllll = llllllllllllllIlllIllIIIIIllIlIl;
            llllllllllllllIlllIllIIIIIllIlIl = (int)llllllllllllllIlllIllIIIIIllIIlI[llllllllllllllIlllIllIIIIIllIlIl];
            llllllllllllllIlllIllIIIIIllIlII = llllllllllllllIlllIllIIIIIllllll;
        }
        this.link = llllllllllllllIlllIllIIIIIllIIIl;
        if ((this.last = llllllllllllllIlllIllIIIIIllIIll) != -1) {
            final long[] array3 = llllllllllllllIlllIllIIIIIllIIIl;
            final int n3 = llllllllllllllIlllIllIIIIIllIIll;
            array3[n3] |= 0xFFFFFFFFL;
        }
        this.n = llllllllllllllIlllIllIIIIIlIllll;
        this.mask = llllllllllllllIlllIllIIIIIlllIII;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = llllllllllllllIlllIllIIIIIllIlll;
        this.value = llllllllllllllIlllIllIIIIIllIllI;
    }
    
    public V removeLast() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int llllllllllllllIlllIllIIlIIllIIll = this.last;
        this.last = (int)(this.link[llllllllllllllIlllIllIIlIIllIIll] >>> 32);
        if (0 <= this.last) {
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        --this.size;
        final V llllllllllllllIlllIllIIlIIllIIlI = this.value[llllllllllllllIlllIllIIlIIllIIll];
        if (llllllllllllllIlllIllIIlIIllIIll == this.n) {
            this.containsNullKey = false;
            this.key[this.n] = null;
            this.value[this.n] = null;
        }
        else {
            this.shiftKeys(llllllllllllllIlllIllIIlIIllIIll);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlllIllIIlIIllIIlI;
    }
    
    @Override
    public V remove(final Object llllllllllllllIlllIllIIlIlIlIIII) {
        if (llllllllllllllIlllIllIIlIlIlIIII == null) {
            if (this.containsNullKey) {
                return this.removeNullEntry();
            }
            return this.defRetValue;
        }
        else {
            final K[] llllllllllllllIlllIllIIlIlIlIIll = this.key;
            int llllllllllllllIlllIllIIlIlIlIIlI;
            K llllllllllllllIlllIllIIlIlIlIlII;
            if ((llllllllllllllIlllIllIIlIlIlIlII = llllllllllllllIlllIllIIlIlIlIIll[llllllllllllllIlllIllIIlIlIlIIlI = (HashCommon.mix(llllllllllllllIlllIllIIlIlIlIIII.hashCode()) & this.mask)]) == null) {
                return this.defRetValue;
            }
            if (llllllllllllllIlllIllIIlIlIlIIII.equals(llllllllllllllIlllIllIIlIlIlIlII)) {
                return this.removeEntry(llllllllllllllIlllIllIIlIlIlIIlI);
            }
            while ((llllllllllllllIlllIllIIlIlIlIlII = llllllllllllllIlllIllIIlIlIlIIll[llllllllllllllIlllIllIIlIlIlIIlI = (llllllllllllllIlllIllIIlIlIlIIlI + 1 & this.mask)]) != null) {
                if (llllllllllllllIlllIllIIlIlIlIIII.equals(llllllllllllllIlllIllIIlIlIlIlII)) {
                    return this.removeEntry(llllllllllllllIlllIllIIlIlIlIIlI);
                }
            }
            return this.defRetValue;
        }
    }
    
    public boolean trim(final int llllllllllllllIlllIllIIIIlIlIlIl) {
        final int llllllllllllllIlllIllIIIIlIlIlII = HashCommon.nextPowerOfTwo((int)Math.ceil(llllllllllllllIlllIllIIIIlIlIlIl / this.f));
        if (llllllllllllllIlllIllIIIIlIlIlII >= this.n || this.size > HashCommon.maxFill(llllllllllllllIlllIllIIIIlIlIlII, this.f)) {
            return true;
        }
        try {
            this.rehash(llllllllllllllIlllIllIIIIlIlIlII);
        }
        catch (OutOfMemoryError llllllllllllllIlllIllIIIIlIlIlll) {
            return false;
        }
        return true;
    }
    
    private int realSize() {
        return this.containsNullKey ? (this.size - 1) : this.size;
    }
    
    public Object2ObjectLinkedOpenHashMap(final Map<? extends K, ? extends V> llllllllllllllIlllIllIIlllllIIII, final float llllllllllllllIlllIllIIllllIllll) {
        this(llllllllllllllIlllIllIIlllllIIII.size(), llllllllllllllIlllIllIIllllIllll);
        this.putAll(llllllllllllllIlllIllIIlllllIIII);
    }
    
    private V setValue(final int llllllllllllllIlllIllIIlIlIIIIll, final V llllllllllllllIlllIllIIlIlIIIIlI) {
        final V llllllllllllllIlllIllIIlIlIIIlIl = this.value[llllllllllllllIlllIllIIlIlIIIIll];
        this.value[llllllllllllllIlllIllIIlIlIIIIll] = llllllllllllllIlllIllIIlIlIIIIlI;
        return llllllllllllllIlllIllIIlIlIIIlIl;
    }
    
    private void ensureCapacity(final int llllllllllllllIlllIllIIllIlllIlI) {
        final int llllllllllllllIlllIllIIllIlllIIl = HashCommon.arraySize(llllllllllllllIlllIllIIllIlllIlI, this.f);
        if (llllllllllllllIlllIllIIllIlllIIl > this.n) {
            this.rehash(llllllllllllllIlllIllIIllIlllIIl);
        }
    }
    
    public Object2ObjectLinkedOpenHashMap(final int llllllllllllllIlllIllIIllllllIll) {
        this(llllllllllllllIlllIllIIllllllIll, 0.75f);
    }
    
    private void tryCapacity(final long llllllllllllllIlllIllIIllIlIlllI) {
        final int llllllllllllllIlllIllIIllIllIIII = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(llllllllllllllIlllIllIIllIlIlllI / this.f))));
        if (llllllllllllllIlllIllIIllIllIIII > this.n) {
            this.rehash(llllllllllllllIlllIllIIllIllIIII);
        }
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    protected final void shiftKeys(int llllllllllllllIlllIllIIlIllIIIII) {
        final K[] llllllllllllllIlllIllIIlIllIIIlI = this.key;
        int llllllllllllllIlllIllIIlIllIIlIl = 0;
    Label_0006:
        while (true) {
            llllllllllllllIlllIllIIlIllIIIII = ((llllllllllllllIlllIllIIlIllIIlIl = llllllllllllllIlllIllIIlIllIIIII) + 1 & this.mask);
            K llllllllllllllIlllIllIIlIllIIIll;
            while ((llllllllllllllIlllIllIIlIllIIIll = llllllllllllllIlllIllIIlIllIIIlI[llllllllllllllIlllIllIIlIllIIIII]) != null) {
                final int llllllllllllllIlllIllIIlIllIIlII = HashCommon.mix(llllllllllllllIlllIllIIlIllIIIll.hashCode()) & this.mask;
                Label_0097: {
                    if (llllllllllllllIlllIllIIlIllIIlIl <= llllllllllllllIlllIllIIlIllIIIII) {
                        if (llllllllllllllIlllIllIIlIllIIlIl >= llllllllllllllIlllIllIIlIllIIlII) {
                            break Label_0097;
                        }
                        if (llllllllllllllIlllIllIIlIllIIlII > llllllllllllllIlllIllIIlIllIIIII) {
                            break Label_0097;
                        }
                    }
                    else if (llllllllllllllIlllIllIIlIllIIlIl >= llllllllllllllIlllIllIIlIllIIlII && llllllllllllllIlllIllIIlIllIIlII > llllllllllllllIlllIllIIlIllIIIII) {
                        break Label_0097;
                    }
                    llllllllllllllIlllIllIIlIllIIIII = (llllllllllllllIlllIllIIlIllIIIII + 1 & this.mask);
                    continue;
                }
                llllllllllllllIlllIllIIlIllIIIlI[llllllllllllllIlllIllIIlIllIIlIl] = llllllllllllllIlllIllIIlIllIIIll;
                this.value[llllllllllllllIlllIllIIlIllIIlIl] = this.value[llllllllllllllIlllIllIIlIllIIIII];
                this.fixPointers(llllllllllllllIlllIllIIlIllIIIII, llllllllllllllIlllIllIIlIllIIlIl);
                continue Label_0006;
            }
            break;
        }
        llllllllllllllIlllIllIIlIllIIIlI[llllllllllllllIlllIllIIlIllIIlIl] = null;
        this.value[llllllllllllllIlllIllIIlIllIIlIl] = null;
    }
    
    private V removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.n] = null;
        final V llllllllllllllIlllIllIIllIlIIIII = this.value[this.n];
        this.value[this.n] = null;
        --this.size;
        this.fixPointers(this.n);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlllIllIIllIlIIIII;
    }
    
    public Object2ObjectLinkedOpenHashMap(final Map<? extends K, ? extends V> llllllllllllllIlllIllIIllllIlIll) {
        this(llllllllllllllIlllIllIIllllIlIll, 0.75f);
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends V> llllllllllllllIlllIllIIllIIllIlI) {
        if (this.f <= 0.5) {
            this.ensureCapacity(llllllllllllllIlllIllIIllIIllIlI.size());
        }
        else {
            this.tryCapacity(this.size() + llllllllllllllIlllIllIIllIIllIlI.size());
        }
        super.putAll(llllllllllllllIlllIllIIllIIllIlI);
    }
    
    public V putAndMoveToFirst(final K llllllllllllllIlllIllIIIlllIIlII, final V llllllllllllllIlllIllIIIlllIIIll) {
        int llllllllllllllIlllIllIIIlllIIllI = 0;
        if (llllllllllllllIlllIllIIIlllIIlII == null) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.setValue(this.n, llllllllllllllIlllIllIIIlllIIIll);
            }
            this.containsNullKey = true;
            final int llllllllllllllIlllIllIIIlllIllII = this.n;
        }
        else {
            final K[] llllllllllllllIlllIllIIIlllIlIlI = this.key;
            K llllllllllllllIlllIllIIIlllIlIll;
            if ((llllllllllllllIlllIllIIIlllIlIll = llllllllllllllIlllIllIIIlllIlIlI[llllllllllllllIlllIllIIIlllIIllI = (HashCommon.mix(llllllllllllllIlllIllIIIlllIIlII.hashCode()) & this.mask)]) != null) {
                if (llllllllllllllIlllIllIIIlllIlIll.equals(llllllllllllllIlllIllIIIlllIIlII)) {
                    this.moveIndexToFirst(llllllllllllllIlllIllIIIlllIIllI);
                    return this.setValue(llllllllllllllIlllIllIIIlllIIllI, llllllllllllllIlllIllIIIlllIIIll);
                }
                while ((llllllllllllllIlllIllIIIlllIlIll = llllllllllllllIlllIllIIIlllIlIlI[llllllllllllllIlllIllIIIlllIIllI = (llllllllllllllIlllIllIIIlllIIllI + 1 & this.mask)]) != null) {
                    if (llllllllllllllIlllIllIIIlllIlIll.equals(llllllllllllllIlllIllIIIlllIIlII)) {
                        this.moveIndexToFirst(llllllllllllllIlllIllIIIlllIIllI);
                        return this.setValue(llllllllllllllIlllIllIIIlllIIllI, llllllllllllllIlllIllIIIlllIIIll);
                    }
                }
            }
        }
        this.key[llllllllllllllIlllIllIIIlllIIllI] = llllllllllllllIlllIllIIIlllIIlII;
        this.value[llllllllllllllIlllIllIIIlllIIllI] = llllllllllllllIlllIllIIIlllIIIll;
        if (this.size == 0) {
            final int n = llllllllllllllIlllIllIIIlllIIllI;
            this.last = n;
            this.first = n;
            this.link[llllllllllllllIlllIllIIIlllIIllI] = -1L;
        }
        else {
            final long[] link = this.link;
            final int first = this.first;
            link[first] ^= ((this.link[this.first] ^ ((long)llllllllllllllIlllIllIIIlllIIllI & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[llllllllllllllIlllIllIIIlllIIllI] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
            this.first = llllllllllllllIlllIllIIIlllIIllI;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }
    
    @Override
    public Object2ObjectSortedMap<K, V> subMap(final K llllllllllllllIlllIllIIIIllIlIlI, final K llllllllllllllIlllIllIIIIllIlIIl) {
        throw new UnsupportedOperationException();
    }
    
    private void moveIndexToFirst(final int llllllllllllllIlllIllIIlIIlIIlIl) {
        if (this.size == 1 || this.first == llllllllllllllIlllIllIIlIIlIIlIl) {
            return;
        }
        if (this.last == llllllllllllllIlllIllIIlIIlIIlIl) {
            this.last = (int)(this.link[llllllllllllllIlllIllIIlIIlIIlIl] >>> 32);
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        else {
            final long llllllllllllllIlllIllIIlIIlIlIIl = this.link[llllllllllllllIlllIllIIlIIlIIlIl];
            final int llllllllllllllIlllIllIIlIIlIlIII = (int)(llllllllllllllIlllIllIIlIIlIlIIl >>> 32);
            final int llllllllllllllIlllIllIIlIIlIIlll = (int)llllllllllllllIlllIllIIlIIlIlIIl;
            final long[] link2 = this.link;
            final int n = llllllllllllllIlllIllIIlIIlIlIII;
            link2[n] ^= ((this.link[llllllllllllllIlllIllIIlIIlIlIII] ^ (llllllllllllllIlllIllIIlIIlIlIIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = llllllllllllllIlllIllIIlIIlIIlll;
            link3[n2] ^= ((this.link[llllllllllllllIlllIllIIlIIlIIlll] ^ (llllllllllllllIlllIllIIlIIlIlIIl & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int first = this.first;
        link4[first] ^= ((this.link[this.first] ^ ((long)llllllllllllllIlllIllIIlIIlIIlIl & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[llllllllllllllIlllIllIIlIIlIIlIl] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
        this.first = llllllllllllllIlllIllIIlIIlIIlIl;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    public Object2ObjectLinkedOpenHashMap(final Object2ObjectMap<K, V> llllllllllllllIlllIllIIllllIIIIl, final float llllllllllllllIlllIllIIllllIIIII) {
        this(llllllllllllllIlllIllIIllllIIIIl.size(), llllllllllllllIlllIllIIllllIIIII);
        this.putAll((Map<? extends K, ? extends V>)llllllllllllllIlllIllIIllllIIIIl);
    }
    
    private void writeObject(final ObjectOutputStream llllllllllllllIlllIlIllllllllIIl) throws IOException {
        final K[] llllllllllllllIlllIlIlllllllllIl = this.key;
        final V[] llllllllllllllIlllIlIlllllllllII = this.value;
        final MapIterator llllllllllllllIlllIlIllllllllIll = new MapIterator();
        llllllllllllllIlllIlIllllllllIIl.defaultWriteObject();
        int llllllllllllllIlllIllIIIIIIIIIIl = this.size;
        while (llllllllllllllIlllIllIIIIIIIIIIl-- != 0) {
            final int llllllllllllllIlllIllIIIIIIIIIII = llllllllllllllIlllIlIllllllllIll.nextEntry();
            llllllllllllllIlllIlIllllllllIIl.writeObject(llllllllllllllIlllIlIlllllllllIl[llllllllllllllIlllIllIIIIIIIIIII]);
            llllllllllllllIlllIlIllllllllIIl.writeObject(llllllllllllllIlllIlIlllllllllII[llllllllllllllIlllIllIIIIIIIIIII]);
        }
    }
    
    @Override
    public ObjectSortedSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }
    
    protected void fixPointers(final int llllllllllllllIlllIllIIIlIIIIIII, final int llllllllllllllIlllIllIIIIlllllll) {
        if (this.size == 1) {
            this.last = llllllllllllllIlllIllIIIIlllllll;
            this.first = llllllllllllllIlllIllIIIIlllllll;
            this.link[llllllllllllllIlllIllIIIIlllllll] = -1L;
            return;
        }
        if (this.first == llllllllllllllIlllIllIIIlIIIIIII) {
            this.first = llllllllllllllIlllIllIIIIlllllll;
            final long[] link = this.link;
            final int n = (int)this.link[llllllllllllllIlllIllIIIlIIIIIII];
            link[n] ^= ((this.link[(int)this.link[llllllllllllllIlllIllIIIlIIIIIII]] ^ ((long)llllllllllllllIlllIllIIIIlllllll & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[llllllllllllllIlllIllIIIIlllllll] = this.link[llllllllllllllIlllIllIIIlIIIIIII];
            return;
        }
        if (this.last == llllllllllllllIlllIllIIIlIIIIIII) {
            this.last = llllllllllllllIlllIllIIIIlllllll;
            final long[] link2 = this.link;
            final int n2 = (int)(this.link[llllllllllllllIlllIllIIIlIIIIIII] >>> 32);
            link2[n2] ^= ((this.link[(int)(this.link[llllllllllllllIlllIllIIIlIIIIIII] >>> 32)] ^ ((long)llllllllllllllIlllIllIIIIlllllll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlllIllIIIIlllllll] = this.link[llllllllllllllIlllIllIIIlIIIIIII];
            return;
        }
        final long llllllllllllllIlllIllIIIIllllllI = this.link[llllllllllllllIlllIllIIIlIIIIIII];
        final int llllllllllllllIlllIllIIIIlllllIl = (int)(llllllllllllllIlllIllIIIIllllllI >>> 32);
        final int llllllllllllllIlllIllIIIIlllllII = (int)llllllllllllllIlllIllIIIIllllllI;
        final long[] link3 = this.link;
        final int n3 = llllllllllllllIlllIllIIIIlllllIl;
        link3[n3] ^= ((this.link[llllllllllllllIlllIllIIIIlllllIl] ^ ((long)llllllllllllllIlllIllIIIIlllllll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n4 = llllllllllllllIlllIllIIIIlllllII;
        link4[n4] ^= ((this.link[llllllllllllllIlllIllIIIIlllllII] ^ ((long)llllllllllllllIlllIllIIIIlllllll & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[llllllllllllllIlllIllIIIIlllllll] = llllllllllllllIlllIllIIIIllllllI;
    }
    
    @Override
    public Object2ObjectSortedMap.FastSortedEntrySet<K, V> object2ObjectEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }
    
    @Override
    public Object2ObjectSortedMap<K, V> tailMap(final K llllllllllllllIlllIllIIIIllIlllI) {
        throw new UnsupportedOperationException();
    }
    
    public V putAndMoveToLast(final K llllllllllllllIlllIllIIIllIlIlIl, final V llllllllllllllIlllIllIIIllIlIlII) {
        int llllllllllllllIlllIllIIIllIlIIll = 0;
        if (llllllllllllllIlllIllIIIllIlIlIl == null) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.setValue(this.n, llllllllllllllIlllIllIIIllIlIlII);
            }
            this.containsNullKey = true;
            final int llllllllllllllIlllIllIIIllIllIIl = this.n;
        }
        else {
            final K[] llllllllllllllIlllIllIIIllIlIlll = this.key;
            K llllllllllllllIlllIllIIIllIllIII;
            if ((llllllllllllllIlllIllIIIllIllIII = llllllllllllllIlllIllIIIllIlIlll[llllllllllllllIlllIllIIIllIlIIll = (HashCommon.mix(llllllllllllllIlllIllIIIllIlIlIl.hashCode()) & this.mask)]) != null) {
                if (llllllllllllllIlllIllIIIllIllIII.equals(llllllllllllllIlllIllIIIllIlIlIl)) {
                    this.moveIndexToLast(llllllllllllllIlllIllIIIllIlIIll);
                    return this.setValue(llllllllllllllIlllIllIIIllIlIIll, llllllllllllllIlllIllIIIllIlIlII);
                }
                while ((llllllllllllllIlllIllIIIllIllIII = llllllllllllllIlllIllIIIllIlIlll[llllllllllllllIlllIllIIIllIlIIll = (llllllllllllllIlllIllIIIllIlIIll + 1 & this.mask)]) != null) {
                    if (llllllllllllllIlllIllIIIllIllIII.equals(llllllllllllllIlllIllIIIllIlIlIl)) {
                        this.moveIndexToLast(llllllllllllllIlllIllIIIllIlIIll);
                        return this.setValue(llllllllllllllIlllIllIIIllIlIIll, llllllllllllllIlllIllIIIllIlIlII);
                    }
                }
            }
        }
        this.key[llllllllllllllIlllIllIIIllIlIIll] = llllllllllllllIlllIllIIIllIlIlIl;
        this.value[llllllllllllllIlllIllIIIllIlIIll] = llllllllllllllIlllIllIIIllIlIlII;
        if (this.size == 0) {
            final int n = llllllllllllllIlllIllIIIllIlIIll;
            this.last = n;
            this.first = n;
            this.link[llllllllllllllIlllIllIIIllIlIIll] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlllIllIIIllIlIIll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlllIllIIIllIlIIll] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = llllllllllllllIlllIllIIIllIlIIll;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return this.defRetValue;
    }
    
    private void readObject(final ObjectInputStream llllllllllllllIlllIlIlllllIlllIl) throws IOException, ClassNotFoundException {
        llllllllllllllIlllIlIlllllIlllIl.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final Object[] key = new Object[this.n + 1];
        this.key = (K[])key;
        final K[] llllllllllllllIlllIlIllllllIIIlI = (K[])key;
        final Object[] value = new Object[this.n + 1];
        this.value = (V[])value;
        final V[] llllllllllllllIlllIlIllllllIIIIl = (V[])value;
        final long[] link = new long[this.n + 1];
        this.link = link;
        final long[] llllllllllllllIlllIlIllllllIIIII = link;
        int llllllllllllllIlllIlIlllllIlllll = -1;
        final int n = -1;
        this.last = n;
        this.first = n;
        int llllllllllllllIlllIlIllllllIIllI = this.size;
        while (llllllllllllllIlllIlIllllllIIllI-- != 0) {
            final K llllllllllllllIlllIlIllllllIlIII = (K)llllllllllllllIlllIlIlllllIlllIl.readObject();
            final V llllllllllllllIlllIlIllllllIIlll = (V)llllllllllllllIlllIlIlllllIlllIl.readObject();
            int llllllllllllllIlllIlIllllllIIlIl = 0;
            if (llllllllllllllIlllIlIllllllIlIII == null) {
                final int llllllllllllllIlllIlIllllllIlIIl = this.n;
                this.containsNullKey = true;
            }
            else {
                for (llllllllllllllIlllIlIllllllIIlIl = (HashCommon.mix(llllllllllllllIlllIlIllllllIlIII.hashCode()) & this.mask); llllllllllllllIlllIlIllllllIIIlI[llllllllllllllIlllIlIllllllIIlIl] != null; llllllllllllllIlllIlIllllllIIlIl = (llllllllllllllIlllIlIllllllIIlIl + 1 & this.mask)) {}
            }
            llllllllllllllIlllIlIllllllIIIlI[llllllllllllllIlllIlIllllllIIlIl] = llllllllllllllIlllIlIllllllIlIII;
            llllllllllllllIlllIlIllllllIIIIl[llllllllllllllIlllIlIllllllIIlIl] = llllllllllllllIlllIlIllllllIIlll;
            if (this.first != -1) {
                final long[] array = llllllllllllllIlllIlIllllllIIIII;
                final int n2 = llllllllllllllIlllIlIlllllIlllll;
                array[n2] ^= ((llllllllllllllIlllIlIllllllIIIII[llllllllllllllIlllIlIlllllIlllll] ^ ((long)llllllllllllllIlllIlIllllllIIlIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = llllllllllllllIlllIlIllllllIIIII;
                final int n3 = llllllllllllllIlllIlIllllllIIlIl;
                array2[n3] ^= ((llllllllllllllIlllIlIllllllIIIII[llllllllllllllIlllIlIllllllIIlIl] ^ ((long)llllllllllllllIlllIlIlllllIlllll & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                llllllllllllllIlllIlIlllllIlllll = llllllllllllllIlllIlIllllllIIlIl;
            }
            else {
                final int first = llllllllllllllIlllIlIllllllIIlIl;
                this.first = first;
                llllllllllllllIlllIlIlllllIlllll = first;
                final long[] array3 = llllllllllllllIlllIlIllllllIIIII;
                final int n4 = llllllllllllllIlllIlIllllllIIlIl;
                array3[n4] |= 0xFFFFFFFF00000000L;
            }
        }
        if ((this.last = llllllllllllllIlllIlIlllllIlllll) != -1) {
            final long[] array4 = llllllllllllllIlllIlIllllllIIIII;
            final int n5 = llllllllllllllIlllIlIlllllIlllll;
            array4[n5] |= 0xFFFFFFFFL;
        }
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public Object2ObjectLinkedOpenHashMap(final K[] llllllllllllllIlllIllIIlllIlIIlI, final V[] llllllllllllllIlllIllIIlllIlIIIl, final float llllllllllllllIlllIllIIlllIIllII) {
        this(llllllllllllllIlllIllIIlllIlIIlI.length, llllllllllllllIlllIllIIlllIIllII);
        if (llllllllllllllIlllIllIIlllIlIIlI.length != llllllllllllllIlllIllIIlllIlIIIl.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The key array and the value array have different lengths (").append(llllllllllllllIlllIllIIlllIlIIlI.length).append(" and ").append(llllllllllllllIlllIllIIlllIlIIIl.length).append(")")));
        }
        for (int llllllllllllllIlllIllIIlllIlIlII = 0; llllllllllllllIlllIllIIlllIlIlII < llllllllllllllIlllIllIIlllIlIIlI.length; ++llllllllllllllIlllIllIIlllIlIlII) {
            this.put(llllllllllllllIlllIllIIlllIlIIlI[llllllllllllllIlllIllIIlllIlIlII], llllllllllllllIlllIllIIlllIlIIIl[llllllllllllllIlllIllIIlllIlIlII]);
        }
    }
    
    public Object2ObjectLinkedOpenHashMap(final Object2ObjectMap<K, V> llllllllllllllIlllIllIIlllIllIlI) {
        this(llllllllllllllIlllIllIIlllIllIlI, 0.75f);
    }
    
    @Override
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractObjectCollection<V>() {
                @Override
                public int size() {
                    return Object2ObjectLinkedOpenHashMap.this.size;
                }
                
                @Override
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }
                
                @Override
                public void forEach(final Consumer<? super V> llllllllllllllIIlllIllIIllIlIlll) {
                    if (Object2ObjectLinkedOpenHashMap.this.containsNullKey) {
                        llllllllllllllIIlllIllIIllIlIlll.accept((Object)Object2ObjectLinkedOpenHashMap.this.value[Object2ObjectLinkedOpenHashMap.this.n]);
                    }
                    int llllllllllllllIIlllIllIIllIllIIl = Object2ObjectLinkedOpenHashMap.this.n;
                    while (llllllllllllllIIlllIllIIllIllIIl-- != 0) {
                        if (Object2ObjectLinkedOpenHashMap.this.key[llllllllllllllIIlllIllIIllIllIIl] != null) {
                            llllllllllllllIIlllIllIIllIlIlll.accept((Object)Object2ObjectLinkedOpenHashMap.this.value[llllllllllllllIIlllIllIIllIllIIl]);
                        }
                    }
                }
                
                @Override
                public boolean contains(final Object llllllllllllllIIlllIllIIlllIIIlI) {
                    return Object2ObjectLinkedOpenHashMap.this.containsValue(llllllllllllllIIlllIllIIlllIIIlI);
                }
                
                @Override
                public void clear() {
                    Object2ObjectLinkedOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }
    
    public Object2ObjectLinkedOpenHashMap() {
        this(16, 0.75f);
    }
    
    private void insert(final int llllllllllllllIlllIllIIllIIIIIll, final K llllllllllllllIlllIllIIllIIIIIlI, final V llllllllllllllIlllIllIIllIIIIIIl) {
        if (llllllllllllllIlllIllIIllIIIIIll == this.n) {
            this.containsNullKey = true;
        }
        this.key[llllllllllllllIlllIllIIllIIIIIll] = llllllllllllllIlllIllIIllIIIIIlI;
        this.value[llllllllllllllIlllIllIIllIIIIIll] = llllllllllllllIlllIllIIllIIIIIIl;
        if (this.size == 0) {
            this.last = llllllllllllllIlllIllIIllIIIIIll;
            this.first = llllllllllllllIlllIllIIllIIIIIll;
            this.link[llllllllllllllIlllIllIIllIIIIIll] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlllIllIIllIIIIIll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlllIllIIllIIIIIll] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = llllllllllllllIlllIllIIllIIIIIll;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
    }
    
    private int find(final K llllllllllllllIlllIllIIllIIIllII) {
        if (llllllllllllllIlllIllIIllIIIllII == null) {
            return this.containsNullKey ? this.n : (-(this.n + 1));
        }
        final K[] llllllllllllllIlllIllIIllIIIllll = this.key;
        int llllllllllllllIlllIllIIllIIIlllI;
        K llllllllllllllIlllIllIIllIIlIIII;
        if ((llllllllllllllIlllIllIIllIIlIIII = llllllllllllllIlllIllIIllIIIllll[llllllllllllllIlllIllIIllIIIlllI = (HashCommon.mix(llllllllllllllIlllIllIIllIIIllII.hashCode()) & this.mask)]) == null) {
            return -(llllllllllllllIlllIllIIllIIIlllI + 1);
        }
        if (llllllllllllllIlllIllIIllIIIllII.equals(llllllllllllllIlllIllIIllIIlIIII)) {
            return llllllllllllllIlllIllIIllIIIlllI;
        }
        while ((llllllllllllllIlllIllIIllIIlIIII = llllllllllllllIlllIllIIllIIIllll[llllllllllllllIlllIllIIllIIIlllI = (llllllllllllllIlllIllIIllIIIlllI + 1 & this.mask)]) != null) {
            if (llllllllllllllIlllIllIIllIIIllII.equals(llllllllllllllIlllIllIIllIIlIIII)) {
                return llllllllllllllIlllIllIIllIIIlllI;
            }
        }
        return -(llllllllllllllIlllIllIIllIIIlllI + 1);
    }
    
    public V getAndMoveToFirst(final K llllllllllllllIlllIllIIlIIIIIlIl) {
        if (llllllllllllllIlllIllIIlIIIIIlIl == null) {
            if (this.containsNullKey) {
                this.moveIndexToFirst(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        else {
            final K[] llllllllllllllIlllIllIIlIIIIlIII = this.key;
            int llllllllllllllIlllIllIIlIIIIIlll;
            K llllllllllllllIlllIllIIlIIIIlIIl;
            if ((llllllllllllllIlllIllIIlIIIIlIIl = llllllllllllllIlllIllIIlIIIIlIII[llllllllllllllIlllIllIIlIIIIIlll = (HashCommon.mix(llllllllllllllIlllIllIIlIIIIIlIl.hashCode()) & this.mask)]) == null) {
                return this.defRetValue;
            }
            if (llllllllllllllIlllIllIIlIIIIIlIl.equals(llllllllllllllIlllIllIIlIIIIlIIl)) {
                this.moveIndexToFirst(llllllllllllllIlllIllIIlIIIIIlll);
                return this.value[llllllllllllllIlllIllIIlIIIIIlll];
            }
            while ((llllllllllllllIlllIllIIlIIIIlIIl = llllllllllllllIlllIllIIlIIIIlIII[llllllllllllllIlllIllIIlIIIIIlll = (llllllllllllllIlllIllIIlIIIIIlll + 1 & this.mask)]) != null) {
                if (llllllllllllllIlllIllIIlIIIIIlIl.equals(llllllllllllllIlllIllIIlIIIIlIIl)) {
                    this.moveIndexToFirst(llllllllllllllIlllIllIIlIIIIIlll);
                    return this.value[llllllllllllllIlllIllIIlIIIIIlll];
                }
            }
            return this.defRetValue;
        }
    }
    
    @Override
    public Object2ObjectSortedMap<K, V> headMap(final K llllllllllllllIlllIllIIIIllIllII) {
        throw new UnsupportedOperationException();
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
        final int n = -1;
        this.last = n;
        this.first = n;
    }
    
    @Override
    public boolean containsKey(final Object llllllllllllllIlllIllIIIlIllIlll) {
        if (llllllllllllllIlllIllIIIlIllIlll == null) {
            return this.containsNullKey;
        }
        final K[] llllllllllllllIlllIllIIIlIllIlIl = this.key;
        int llllllllllllllIlllIllIIIlIllIlII;
        K llllllllllllllIlllIllIIIlIllIllI;
        if ((llllllllllllllIlllIllIIIlIllIllI = llllllllllllllIlllIllIIIlIllIlIl[llllllllllllllIlllIllIIIlIllIlII = (HashCommon.mix(llllllllllllllIlllIllIIIlIllIlll.hashCode()) & this.mask)]) == null) {
            return false;
        }
        if (llllllllllllllIlllIllIIIlIllIlll.equals(llllllllllllllIlllIllIIIlIllIllI)) {
            return true;
        }
        while ((llllllllllllllIlllIllIIIlIllIllI = llllllllllllllIlllIllIIIlIllIlIl[llllllllllllllIlllIllIIIlIllIlII = (llllllllllllllIlllIllIIIlIllIlII + 1 & this.mask)]) != null) {
            if (llllllllllllllIlllIllIIIlIllIlll.equals(llllllllllllllIlllIllIIIlIllIllI)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public K lastKey() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.last];
    }
    
    protected void fixPointers(final int llllllllllllllIlllIllIIIlIIlIIII) {
        if (this.size == 0) {
            final int n = -1;
            this.last = n;
            this.first = n;
            return;
        }
        if (this.first == llllllllllllllIlllIllIIIlIIlIIII) {
            this.first = (int)this.link[llllllllllllllIlllIllIIIlIIlIIII];
            if (0 <= this.first) {
                final long[] link = this.link;
                final int first = this.first;
                link[first] |= 0xFFFFFFFF00000000L;
            }
            return;
        }
        if (this.last == llllllllllllllIlllIllIIIlIIlIIII) {
            this.last = (int)(this.link[llllllllllllllIlllIllIIIlIIlIIII] >>> 32);
            if (0 <= this.last) {
                final long[] link2 = this.link;
                final int last = this.last;
                link2[last] |= 0xFFFFFFFFL;
            }
            return;
        }
        final long llllllllllllllIlllIllIIIlIIIllll = this.link[llllllllllllllIlllIllIIIlIIlIIII];
        final int llllllllllllllIlllIllIIIlIIIlllI = (int)(llllllllllllllIlllIllIIIlIIIllll >>> 32);
        final int llllllllllllllIlllIllIIIlIIIllIl = (int)llllllllllllllIlllIllIIIlIIIllll;
        final long[] link3 = this.link;
        final int n2 = llllllllllllllIlllIllIIIlIIIlllI;
        link3[n2] ^= ((this.link[llllllllllllllIlllIllIIIlIIIlllI] ^ (llllllllllllllIlllIllIIIlIIIllll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n3 = llllllllllllllIlllIllIIIlIIIllIl;
        link4[n3] ^= ((this.link[llllllllllllllIlllIllIIIlIIIllIl] ^ (llllllllllllllIlllIllIIIlIIIllll & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
    }
    
    private V removeEntry(final int llllllllllllllIlllIllIIllIlIIlIl) {
        final V llllllllllllllIlllIllIIllIlIIlll = this.value[llllllllllllllIlllIllIIllIlIIlIl];
        this.value[llllllllllllllIlllIllIIllIlIIlIl] = null;
        --this.size;
        this.fixPointers(llllllllllllllIlllIllIIllIlIIlIl);
        this.shiftKeys(llllllllllllllIlllIllIIllIlIIlIl);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlllIllIIllIlIIlll;
    }
    
    public Object2ObjectLinkedOpenHashMap(final K[] llllllllllllllIlllIllIIlllIIIIll, final V[] llllllllllllllIlllIllIIlllIIIIlI) {
        this(llllllllllllllIlllIllIIlllIIIIll, llllllllllllllIlllIllIIlllIIIIlI, 0.75f);
    }
    
    static {
        ASSERTS = false;
    }
    
    public V getAndMoveToLast(final K llllllllllllllIlllIllIIIllllIllI) {
        if (llllllllllllllIlllIllIIIllllIllI == null) {
            if (this.containsNullKey) {
                this.moveIndexToLast(this.n);
                return this.value[this.n];
            }
            return this.defRetValue;
        }
        else {
            final K[] llllllllllllllIlllIllIIIlllllIIl = this.key;
            int llllllllllllllIlllIllIIIlllllIII;
            K llllllllllllllIlllIllIIIlllllIlI;
            if ((llllllllllllllIlllIllIIIlllllIlI = llllllllllllllIlllIllIIIlllllIIl[llllllllllllllIlllIllIIIlllllIII = (HashCommon.mix(llllllllllllllIlllIllIIIllllIllI.hashCode()) & this.mask)]) == null) {
                return this.defRetValue;
            }
            if (llllllllllllllIlllIllIIIllllIllI.equals(llllllllllllllIlllIllIIIlllllIlI)) {
                this.moveIndexToLast(llllllllllllllIlllIllIIIlllllIII);
                return this.value[llllllllllllllIlllIllIIIlllllIII];
            }
            while ((llllllllllllllIlllIllIIIlllllIlI = llllllllllllllIlllIllIIIlllllIIl[llllllllllllllIlllIllIIIlllllIII = (llllllllllllllIlllIllIIIlllllIII + 1 & this.mask)]) != null) {
                if (llllllllllllllIlllIllIIIllllIllI.equals(llllllllllllllIlllIllIIIlllllIlI)) {
                    this.moveIndexToLast(llllllllllllllIlllIllIIIlllllIII);
                    return this.value[llllllllllllllIlllIllIIIlllllIII];
                }
            }
            return this.defRetValue;
        }
    }
    
    public V removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int llllllllllllllIlllIllIIlIIllllII = this.first;
        this.first = (int)this.link[llllllllllllllIlllIllIIlIIllllII];
        if (0 <= this.first) {
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        --this.size;
        final V llllllllllllllIlllIllIIlIIlllIll = this.value[llllllllllllllIlllIllIIlIIllllII];
        if (llllllllllllllIlllIllIIlIIllllII == this.n) {
            this.containsNullKey = false;
            this.key[this.n] = null;
            this.value[this.n] = null;
        }
        else {
            this.shiftKeys(llllllllllllllIlllIllIIlIIllllII);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlllIllIIlIIlllIll;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIlllIllIIIIIIIlllI = 0;
        int llllllllllllllIlllIllIIIIIIlIIlI = this.realSize();
        int llllllllllllllIlllIllIIIIIIlIIIl = 0;
        int llllllllllllllIlllIllIIIIIIlIIII = 0;
        while (llllllllllllllIlllIllIIIIIIlIIlI-- != 0) {
            while (this.key[llllllllllllllIlllIllIIIIIIlIIIl] == null) {
                ++llllllllllllllIlllIllIIIIIIlIIIl;
            }
            if (this != this.key[llllllllllllllIlllIllIIIIIIlIIIl]) {
                llllllllllllllIlllIllIIIIIIlIIII = this.key[llllllllllllllIlllIllIIIIIIlIIIl].hashCode();
            }
            if (this != this.value[llllllllllllllIlllIllIIIIIIlIIIl]) {
                llllllllllllllIlllIllIIIIIIlIIII ^= ((this.value[llllllllllllllIlllIllIIIIIIlIIIl] == null) ? 0 : this.value[llllllllllllllIlllIllIIIIIIlIIIl].hashCode());
            }
            llllllllllllllIlllIllIIIIIIIlllI += llllllllllllllIlllIllIIIIIIlIIII;
            ++llllllllllllllIlllIllIIIIIIlIIIl;
        }
        if (this.containsNullKey) {
            llllllllllllllIlllIllIIIIIIIlllI += ((this.value[this.n] == null) ? 0 : this.value[this.n].hashCode());
        }
        return llllllllllllllIlllIllIIIIIIIlllI;
    }
    
    private void checkTable() {
    }
    
    private final class MapEntrySet extends AbstractObjectSortedSet<Object2ObjectMap.Entry<K, V>> implements Object2ObjectSortedMap.FastSortedEntrySet<K, V>
    {
        @Override
        public ObjectSortedSet<Object2ObjectMap.Entry<K, V>> subSet(final Object2ObjectMap.Entry<K, V> lllllllllllllllIlIlIllIlIllIIIll, final Object2ObjectMap.Entry<K, V> lllllllllllllllIlIlIllIlIllIIIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean remove(final Object lllllllllllllllIlIlIllIlIIllIllI) {
            if (!(lllllllllllllllIlIlIllIlIIllIllI instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllllIlIlIllIlIIllIlIl = (Map.Entry<?, ?>)lllllllllllllllIlIlIllIlIIllIllI;
            final K lllllllllllllllIlIlIllIlIIllIlII = (K)lllllllllllllllIlIlIllIlIIllIlIl.getKey();
            final V lllllllllllllllIlIlIllIlIIllIIll = (V)lllllllllllllllIlIlIllIlIIllIlIl.getValue();
            if (lllllllllllllllIlIlIllIlIIllIlII == null) {
                if (Object2ObjectLinkedOpenHashMap.this.containsNullKey && Objects.equals(Object2ObjectLinkedOpenHashMap.this.value[Object2ObjectLinkedOpenHashMap.this.n], lllllllllllllllIlIlIllIlIIllIIll)) {
                    Object2ObjectLinkedOpenHashMap.this.removeNullEntry();
                    return true;
                }
                return false;
            }
            else {
                final K[] lllllllllllllllIlIlIllIlIIllIIIl = Object2ObjectLinkedOpenHashMap.this.key;
                int lllllllllllllllIlIlIllIlIIllIIII;
                K lllllllllllllllIlIlIllIlIIllIIlI;
                if ((lllllllllllllllIlIlIllIlIIllIIlI = lllllllllllllllIlIlIllIlIIllIIIl[lllllllllllllllIlIlIllIlIIllIIII = (HashCommon.mix(lllllllllllllllIlIlIllIlIIllIlII.hashCode()) & Object2ObjectLinkedOpenHashMap.this.mask)]) == null) {
                    return false;
                }
                if (!lllllllllllllllIlIlIllIlIIllIIlI.equals(lllllllllllllllIlIlIllIlIIllIlII)) {
                    while ((lllllllllllllllIlIlIllIlIIllIIlI = lllllllllllllllIlIlIllIlIIllIIIl[lllllllllllllllIlIlIllIlIIllIIII = (lllllllllllllllIlIlIllIlIIllIIII + 1 & Object2ObjectLinkedOpenHashMap.this.mask)]) != null) {
                        if (lllllllllllllllIlIlIllIlIIllIIlI.equals(lllllllllllllllIlIlIllIlIIllIlII) && Objects.equals(Object2ObjectLinkedOpenHashMap.this.value[lllllllllllllllIlIlIllIlIIllIIII], lllllllllllllllIlIlIllIlIIllIIll)) {
                            Object2ObjectLinkedOpenHashMap.this.removeEntry(lllllllllllllllIlIlIllIlIIllIIII);
                            return true;
                        }
                    }
                    return false;
                }
                if (Objects.equals(Object2ObjectLinkedOpenHashMap.this.value[lllllllllllllllIlIlIllIlIIllIIII], lllllllllllllllIlIlIllIlIIllIIll)) {
                    Object2ObjectLinkedOpenHashMap.this.removeEntry(lllllllllllllllIlIlIllIlIIllIIII);
                    return true;
                }
                return false;
            }
        }
        
        @Override
        public ObjectSortedSet<Object2ObjectMap.Entry<K, V>> tailSet(final Object2ObjectMap.Entry<K, V> lllllllllllllllIlIlIllIlIlIllllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Comparator<? super Object2ObjectMap.Entry<K, V>> comparator() {
            return null;
        }
        
        @Override
        public int size() {
            return Object2ObjectLinkedOpenHashMap.this.size;
        }
        
        @Override
        public void fastForEach(final Consumer<? super Object2ObjectMap.Entry<K, V>> lllllllllllllllIlIlIllIIlllllIIl) {
            final BasicEntry<K, V> lllllllllllllllIlIlIllIIlllllIII = new BasicEntry<K, V>();
            int lllllllllllllllIlIlIllIIllllllIl = Object2ObjectLinkedOpenHashMap.this.size;
            int lllllllllllllllIlIlIllIIlllllIll = Object2ObjectLinkedOpenHashMap.this.first;
            while (lllllllllllllllIlIlIllIIllllllIl-- != 0) {
                final int lllllllllllllllIlIlIllIIllllllII = lllllllllllllllIlIlIllIIlllllIll;
                lllllllllllllllIlIlIllIIlllllIll = (int)Object2ObjectLinkedOpenHashMap.this.link[lllllllllllllllIlIlIllIIllllllII];
                lllllllllllllllIlIlIllIIlllllIII.key = Object2ObjectLinkedOpenHashMap.this.key[lllllllllllllllIlIlIllIIllllllII];
                lllllllllllllllIlIlIllIIlllllIII.value = Object2ObjectLinkedOpenHashMap.this.value[lllllllllllllllIlIlIllIIllllllII];
                lllllllllllllllIlIlIllIIlllllIIl.accept(lllllllllllllllIlIlIllIIlllllIII);
            }
        }
        
        @Override
        public void clear() {
            Object2ObjectLinkedOpenHashMap.this.clear();
        }
        
        @Override
        public void forEach(final Consumer<? super Object2ObjectMap.Entry<K, V>> lllllllllllllllIlIlIllIlIIIIIlll) {
            int lllllllllllllllIlIlIllIlIIIIllIl = Object2ObjectLinkedOpenHashMap.this.size;
            int lllllllllllllllIlIlIllIlIIIIlIll = Object2ObjectLinkedOpenHashMap.this.first;
            while (lllllllllllllllIlIlIllIlIIIIllIl-- != 0) {
                final int lllllllllllllllIlIlIllIlIIIIllII = lllllllllllllllIlIlIllIlIIIIlIll;
                lllllllllllllllIlIlIllIlIIIIlIll = (int)Object2ObjectLinkedOpenHashMap.this.link[lllllllllllllllIlIlIllIlIIIIllII];
                lllllllllllllllIlIlIllIlIIIIIlll.accept((Object)new BasicEntry((K)Object2ObjectLinkedOpenHashMap.this.key[lllllllllllllllIlIlIllIlIIIIllII], (V)Object2ObjectLinkedOpenHashMap.this.value[lllllllllllllllIlIlIllIlIIIIllII]));
            }
        }
        
        @Override
        public Object2ObjectMap.Entry<K, V> last() {
            if (Object2ObjectLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Object2ObjectLinkedOpenHashMap.this.last);
        }
        
        @Override
        public ObjectListIterator<Object2ObjectMap.Entry<K, V>> iterator(final Object2ObjectMap.Entry<K, V> lllllllllllllllIlIlIllIlIIIllllI) {
            return new EntryIterator(lllllllllllllllIlIlIllIlIIIllllI.getKey());
        }
        
        @Override
        public ObjectListIterator<Object2ObjectMap.Entry<K, V>> fastIterator() {
            return new FastEntryIterator();
        }
        
        @Override
        public boolean contains(final Object lllllllllllllllIlIlIllIlIlIIlllI) {
            if (!(lllllllllllllllIlIlIllIlIlIIlllI instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllllIlIlIllIlIlIIllIl = (Map.Entry<?, ?>)lllllllllllllllIlIlIllIlIlIIlllI;
            final K lllllllllllllllIlIlIllIlIlIIllII = (K)lllllllllllllllIlIlIllIlIlIIllIl.getKey();
            final V lllllllllllllllIlIlIllIlIlIIlIll = (V)lllllllllllllllIlIlIllIlIlIIllIl.getValue();
            if (lllllllllllllllIlIlIllIlIlIIllII == null) {
                return Object2ObjectLinkedOpenHashMap.this.containsNullKey && Objects.equals(Object2ObjectLinkedOpenHashMap.this.value[Object2ObjectLinkedOpenHashMap.this.n], lllllllllllllllIlIlIllIlIlIIlIll);
            }
            final K[] lllllllllllllllIlIlIllIlIlIIlIIl = Object2ObjectLinkedOpenHashMap.this.key;
            int lllllllllllllllIlIlIllIlIlIIlIII;
            K lllllllllllllllIlIlIllIlIlIIlIlI;
            if ((lllllllllllllllIlIlIllIlIlIIlIlI = lllllllllllllllIlIlIllIlIlIIlIIl[lllllllllllllllIlIlIllIlIlIIlIII = (HashCommon.mix(lllllllllllllllIlIlIllIlIlIIllII.hashCode()) & Object2ObjectLinkedOpenHashMap.this.mask)]) == null) {
                return false;
            }
            if (lllllllllllllllIlIlIllIlIlIIllII.equals(lllllllllllllllIlIlIllIlIlIIlIlI)) {
                return Objects.equals(Object2ObjectLinkedOpenHashMap.this.value[lllllllllllllllIlIlIllIlIlIIlIII], lllllllllllllllIlIlIllIlIlIIlIll);
            }
            while ((lllllllllllllllIlIlIllIlIlIIlIlI = lllllllllllllllIlIlIllIlIlIIlIIl[lllllllllllllllIlIlIllIlIlIIlIII = (lllllllllllllllIlIlIllIlIlIIlIII + 1 & Object2ObjectLinkedOpenHashMap.this.mask)]) != null) {
                if (lllllllllllllllIlIlIllIlIlIIllII.equals(lllllllllllllllIlIlIllIlIlIIlIlI)) {
                    return Objects.equals(Object2ObjectLinkedOpenHashMap.this.value[lllllllllllllllIlIlIllIlIlIIlIII], lllllllllllllllIlIlIllIlIlIIlIll);
                }
            }
            return false;
        }
        
        @Override
        public ObjectListIterator<Object2ObjectMap.Entry<K, V>> fastIterator(final Object2ObjectMap.Entry<K, V> lllllllllllllllIlIlIllIlIIIlIlIl) {
            return new FastEntryIterator(lllllllllllllllIlIlIllIlIIIlIlIl.getKey());
        }
        
        @Override
        public ObjectSortedSet<Object2ObjectMap.Entry<K, V>> headSet(final Object2ObjectMap.Entry<K, V> lllllllllllllllIlIlIllIlIllIIIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Object2ObjectMap.Entry<K, V> first() {
            if (Object2ObjectLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return new MapEntry(Object2ObjectLinkedOpenHashMap.this.first);
        }
        
        @Override
        public ObjectBidirectionalIterator<Object2ObjectMap.Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }
    
    final class MapEntry implements Object2ObjectMap.Entry<K, V>, Map.Entry<K, V>
    {
        /* synthetic */ int index;
        
        @Override
        public V getValue() {
            return Object2ObjectLinkedOpenHashMap.this.value[this.index];
        }
        
        @Override
        public K getKey() {
            return Object2ObjectLinkedOpenHashMap.this.key[this.index];
        }
        
        MapEntry() {
        }
        
        @Override
        public int hashCode() {
            return ((Object2ObjectLinkedOpenHashMap.this.key[this.index] == null) ? 0 : Object2ObjectLinkedOpenHashMap.this.key[this.index].hashCode()) ^ ((Object2ObjectLinkedOpenHashMap.this.value[this.index] == null) ? 0 : Object2ObjectLinkedOpenHashMap.this.value[this.index].hashCode());
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIlIllIlIIIlIllIIll) {
            if (!(llllllllllllllIlIllIlIIIlIllIIll instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<K, V> llllllllllllllIlIllIlIIIlIllIIlI = (Map.Entry<K, V>)llllllllllllllIlIllIlIIIlIllIIll;
            return Objects.equals(Object2ObjectLinkedOpenHashMap.this.key[this.index], llllllllllllllIlIllIlIIIlIllIIlI.getKey()) && Objects.equals(Object2ObjectLinkedOpenHashMap.this.value[this.index], llllllllllllllIlIllIlIIIlIllIIlI.getValue());
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(Object2ObjectLinkedOpenHashMap.this.key[this.index]).append("=>").append(Object2ObjectLinkedOpenHashMap.this.value[this.index]));
        }
        
        MapEntry(final int llllllllllllllIlIllIlIIIllIIllIl) {
            this.index = llllllllllllllIlIllIlIIIllIIllIl;
        }
        
        @Override
        public V setValue(final V llllllllllllllIlIllIlIIIlIllllII) {
            final V llllllllllllllIlIllIlIIIlIlllIll = Object2ObjectLinkedOpenHashMap.this.value[this.index];
            Object2ObjectLinkedOpenHashMap.this.value[this.index] = llllllllllllllIlIllIlIIIlIllllII;
            return llllllllllllllIlIllIlIIIlIlllIll;
        }
    }
    
    private class FastEntryIterator extends MapIterator implements ObjectListIterator<Object2ObjectMap.Entry<K, V>>
    {
        final /* synthetic */ MapEntry entry;
        
        public FastEntryIterator(final K lllllllllllllIIlllllIIIllllllIll) {
            super((Object)lllllllllllllIIlllllIIIllllllIll);
            this.entry = new MapEntry();
        }
        
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
    }
    
    private class MapIterator
    {
        /* synthetic */ int index;
        /* synthetic */ int curr;
        /* synthetic */ int prev;
        /* synthetic */ int next;
        
        public void add(final Object2ObjectMap.Entry<K, V> lllllllllllllIlIIIIIIIlIllIlIIII) {
            throw new UnsupportedOperationException();
        }
        
        public int previousIndex() {
            this.ensureIndexKnown();
            return this.index - 1;
        }
        
        public boolean hasPrevious() {
            return this.prev != -1;
        }
        
        private MapIterator(final K lllllllllllllIlIIIIIIIllIlIIIIIl) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (lllllllllllllIlIIIIIIIllIlIIIIIl == null) {
                if (Object2ObjectLinkedOpenHashMap.this.containsNullKey) {
                    this.next = (int)Object2ObjectLinkedOpenHashMap.this.link[Object2ObjectLinkedOpenHashMap.this.n];
                    this.prev = Object2ObjectLinkedOpenHashMap.this.n;
                    return;
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(lllllllllllllIlIIIIIIIllIlIIIIIl).append(" does not belong to this map.")));
            }
            else {
                if (Objects.equals(Object2ObjectLinkedOpenHashMap.this.key[Object2ObjectLinkedOpenHashMap.this.last], lllllllllllllIlIIIIIIIllIlIIIIIl)) {
                    this.prev = Object2ObjectLinkedOpenHashMap.this.last;
                    this.index = Object2ObjectLinkedOpenHashMap.this.size;
                    return;
                }
                for (int lllllllllllllIlIIIIIIIllIlIIIlII = HashCommon.mix(lllllllllllllIlIIIIIIIllIlIIIIIl.hashCode()) & Object2ObjectLinkedOpenHashMap.this.mask; Object2ObjectLinkedOpenHashMap.this.key[lllllllllllllIlIIIIIIIllIlIIIlII] != null; lllllllllllllIlIIIIIIIllIlIIIlII = (lllllllllllllIlIIIIIIIllIlIIIlII + 1 & Object2ObjectLinkedOpenHashMap.this.mask)) {
                    if (Object2ObjectLinkedOpenHashMap.this.key[lllllllllllllIlIIIIIIIllIlIIIlII].equals(lllllllllllllIlIIIIIIIllIlIIIIIl)) {
                        this.next = (int)Object2ObjectLinkedOpenHashMap.this.link[lllllllllllllIlIIIIIIIllIlIIIlII];
                        this.prev = lllllllllllllIlIIIIIIIllIlIIIlII;
                        return;
                    }
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(lllllllllllllIlIIIIIIIllIlIIIIIl).append(" does not belong to this map.")));
            }
        }
        
        public int skip(final int lllllllllllllIlIIIIIIIlIllIllllI) {
            int lllllllllllllIlIIIIIIIlIlllIIIII = lllllllllllllIlIIIIIIIlIllIllllI;
            while (lllllllllllllIlIIIIIIIlIlllIIIII-- != 0 && this.hasNext()) {
                this.nextEntry();
            }
            return lllllllllllllIlIIIIIIIlIllIllllI - lllllllllllllIlIIIIIIIlIlllIIIII - 1;
        }
        
        public void remove() {
            this.ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                --this.index;
                this.prev = (int)(Object2ObjectLinkedOpenHashMap.this.link[this.curr] >>> 32);
            }
            else {
                this.next = (int)Object2ObjectLinkedOpenHashMap.this.link[this.curr];
            }
            final Object2ObjectLinkedOpenHashMap this$0 = Object2ObjectLinkedOpenHashMap.this;
            --this$0.size;
            if (this.prev == -1) {
                Object2ObjectLinkedOpenHashMap.this.first = this.next;
            }
            else {
                final long[] link = Object2ObjectLinkedOpenHashMap.this.link;
                final int prev = this.prev;
                link[prev] ^= ((Object2ObjectLinkedOpenHashMap.this.link[this.prev] ^ ((long)this.next & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            }
            if (this.next == -1) {
                Object2ObjectLinkedOpenHashMap.this.last = this.prev;
            }
            else {
                final long[] link2 = Object2ObjectLinkedOpenHashMap.this.link;
                final int next = this.next;
                link2[next] ^= ((Object2ObjectLinkedOpenHashMap.this.link[this.next] ^ ((long)this.prev & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            }
            int lllllllllllllIlIIIIIIIlIlllIllII = this.curr;
            this.curr = -1;
            if (lllllllllllllIlIIIIIIIlIlllIllII == Object2ObjectLinkedOpenHashMap.this.n) {
                Object2ObjectLinkedOpenHashMap.this.containsNullKey = false;
                Object2ObjectLinkedOpenHashMap.this.key[Object2ObjectLinkedOpenHashMap.this.n] = null;
                Object2ObjectLinkedOpenHashMap.this.value[Object2ObjectLinkedOpenHashMap.this.n] = null;
                return;
            }
            final K[] lllllllllllllIlIIIIIIIlIllllIIII = Object2ObjectLinkedOpenHashMap.this.key;
            int lllllllllllllIlIIIIIIIlIlllIllll = 0;
        Label_0296:
            while (true) {
                lllllllllllllIlIIIIIIIlIlllIllII = ((lllllllllllllIlIIIIIIIlIlllIllll = lllllllllllllIlIIIIIIIlIlllIllII) + 1 & Object2ObjectLinkedOpenHashMap.this.mask);
                K lllllllllllllIlIIIIIIIlIllllIIIl;
                while ((lllllllllllllIlIIIIIIIlIllllIIIl = lllllllllllllIlIIIIIIIlIllllIIII[lllllllllllllIlIIIIIIIlIlllIllII]) != null) {
                    final int lllllllllllllIlIIIIIIIlIlllIlllI = HashCommon.mix(lllllllllllllIlIIIIIIIlIllllIIIl.hashCode()) & Object2ObjectLinkedOpenHashMap.this.mask;
                    Label_0399: {
                        if (lllllllllllllIlIIIIIIIlIlllIllll <= lllllllllllllIlIIIIIIIlIlllIllII) {
                            if (lllllllllllllIlIIIIIIIlIlllIllll >= lllllllllllllIlIIIIIIIlIlllIlllI) {
                                break Label_0399;
                            }
                            if (lllllllllllllIlIIIIIIIlIlllIlllI > lllllllllllllIlIIIIIIIlIlllIllII) {
                                break Label_0399;
                            }
                        }
                        else if (lllllllllllllIlIIIIIIIlIlllIllll >= lllllllllllllIlIIIIIIIlIlllIlllI && lllllllllllllIlIIIIIIIlIlllIlllI > lllllllllllllIlIIIIIIIlIlllIllII) {
                            break Label_0399;
                        }
                        lllllllllllllIlIIIIIIIlIlllIllII = (lllllllllllllIlIIIIIIIlIlllIllII + 1 & Object2ObjectLinkedOpenHashMap.this.mask);
                        continue;
                    }
                    lllllllllllllIlIIIIIIIlIllllIIII[lllllllllllllIlIIIIIIIlIlllIllll] = lllllllllllllIlIIIIIIIlIllllIIIl;
                    Object2ObjectLinkedOpenHashMap.this.value[lllllllllllllIlIIIIIIIlIlllIllll] = Object2ObjectLinkedOpenHashMap.this.value[lllllllllllllIlIIIIIIIlIlllIllII];
                    if (this.next == lllllllllllllIlIIIIIIIlIlllIllII) {
                        this.next = lllllllllllllIlIIIIIIIlIlllIllll;
                    }
                    if (this.prev == lllllllllllllIlIIIIIIIlIlllIllII) {
                        this.prev = lllllllllllllIlIIIIIIIlIlllIllll;
                    }
                    Object2ObjectLinkedOpenHashMap.this.fixPointers(lllllllllllllIlIIIIIIIlIlllIllII, lllllllllllllIlIIIIIIIlIlllIllll);
                    continue Label_0296;
                }
                break;
            }
            lllllllllllllIlIIIIIIIlIllllIIII[lllllllllllllIlIIIIIIIlIlllIllll] = null;
            Object2ObjectLinkedOpenHashMap.this.value[lllllllllllllIlIIIIIIIlIlllIllll] = null;
        }
        
        public void set(final Object2ObjectMap.Entry<K, V> lllllllllllllIlIIIIIIIlIllIlIIlI) {
            throw new UnsupportedOperationException();
        }
        
        public int nextIndex() {
            this.ensureIndexKnown();
            return this.index;
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
                this.index = Object2ObjectLinkedOpenHashMap.this.size;
                return;
            }
            int lllllllllllllIlIIIIIIIllIIllIllI = Object2ObjectLinkedOpenHashMap.this.first;
            this.index = 1;
            while (lllllllllllllIlIIIIIIIllIIllIllI != this.prev) {
                lllllllllllllIlIIIIIIIllIIllIllI = (int)Object2ObjectLinkedOpenHashMap.this.link[lllllllllllllIlIIIIIIIllIIllIllI];
                ++this.index;
            }
        }
        
        public int back(final int lllllllllllllIlIIIIIIIlIllIllIII) {
            int lllllllllllllIlIIIIIIIlIllIlIlll = lllllllllllllIlIIIIIIIlIllIllIII;
            while (lllllllllllllIlIIIIIIIlIllIlIlll-- != 0 && this.hasPrevious()) {
                this.previousEntry();
            }
            return lllllllllllllIlIIIIIIIlIllIllIII - lllllllllllllIlIIIIIIIlIllIlIlll - 1;
        }
        
        public boolean hasNext() {
            return this.next != -1;
        }
        
        public int previousEntry() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int)(Object2ObjectLinkedOpenHashMap.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                --this.index;
            }
            return this.curr;
        }
        
        public int nextEntry() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int)Object2ObjectLinkedOpenHashMap.this.link[this.curr];
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
            this.next = Object2ObjectLinkedOpenHashMap.this.first;
            this.index = 0;
        }
    }
    
    private class EntryIterator extends MapIterator implements ObjectListIterator<Object2ObjectMap.Entry<K, V>>
    {
        private /* synthetic */ MapEntry entry;
        
        public EntryIterator() {
        }
        
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
        
        public EntryIterator(final K lllllllllllllIIIIIllIlllIllIIIII) {
            super((Object)lllllllllllllIIIIIllIlllIllIIIII);
        }
        
        @Override
        public MapEntry next() {
            final MapEntry entry = new MapEntry(this.nextEntry());
            this.entry = entry;
            return entry;
        }
    }
    
    private final class KeyIterator extends MapIterator implements ObjectListIterator<K>
    {
        @Override
        public K previous() {
            return Object2ObjectLinkedOpenHashMap.this.key[this.previousEntry()];
        }
        
        public KeyIterator() {
        }
        
        public KeyIterator(final K llllllllllllllllllIlllIllIlIIIlI) {
            super((Object)llllllllllllllllllIlllIllIlIIIlI);
        }
        
        @Override
        public K next() {
            return Object2ObjectLinkedOpenHashMap.this.key[this.nextEntry()];
        }
    }
    
    private final class ValueIterator extends MapIterator implements ObjectListIterator<V>
    {
        public ValueIterator() {
        }
        
        @Override
        public V next() {
            return Object2ObjectLinkedOpenHashMap.this.value[this.nextEntry()];
        }
        
        @Override
        public V previous() {
            return Object2ObjectLinkedOpenHashMap.this.value[this.previousEntry()];
        }
    }
    
    private final class KeySet extends AbstractObjectSortedSet<K>
    {
        @Override
        public void forEach(final Consumer<? super K> llllllllllllllllIllllllIllIIIIll) {
            if (Object2ObjectLinkedOpenHashMap.this.containsNullKey) {
                llllllllllllllllIllllllIllIIIIll.accept((Object)Object2ObjectLinkedOpenHashMap.this.key[Object2ObjectLinkedOpenHashMap.this.n]);
            }
            int llllllllllllllllIllllllIllIIIlll = Object2ObjectLinkedOpenHashMap.this.n;
            while (llllllllllllllllIllllllIllIIIlll-- != 0) {
                final K llllllllllllllllIllllllIllIIlIII = Object2ObjectLinkedOpenHashMap.this.key[llllllllllllllllIllllllIllIIIlll];
                if (llllllllllllllllIllllllIllIIlIII != null) {
                    llllllllllllllllIllllllIllIIIIll.accept((Object)llllllllllllllllIllllllIllIIlIII);
                }
            }
        }
        
        @Override
        public ObjectSortedSet<K> subSet(final K llllllllllllllllIllllllIlIIlllll, final K llllllllllllllllIllllllIlIIllllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public ObjectListIterator<K> iterator(final K llllllllllllllllIllllllIllIlIIII) {
            return new KeyIterator(llllllllllllllllIllllllIllIlIIII);
        }
        
        @Override
        public ObjectSortedSet<K> headSet(final K llllllllllllllllIllllllIlIlIIIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int size() {
            return Object2ObjectLinkedOpenHashMap.this.size;
        }
        
        @Override
        public Comparator<? super K> comparator() {
            return null;
        }
        
        @Override
        public boolean remove(final Object llllllllllllllllIllllllIlIllIIII) {
            final int llllllllllllllllIllllllIlIllIIlI = Object2ObjectLinkedOpenHashMap.this.size;
            Object2ObjectLinkedOpenHashMap.this.remove(llllllllllllllllIllllllIlIllIIII);
            return Object2ObjectLinkedOpenHashMap.this.size != llllllllllllllllIllllllIlIllIIlI;
        }
        
        @Override
        public ObjectListIterator<K> iterator() {
            return new KeyIterator();
        }
        
        @Override
        public void clear() {
            Object2ObjectLinkedOpenHashMap.this.clear();
        }
        
        @Override
        public ObjectSortedSet<K> tailSet(final K llllllllllllllllIllllllIlIlIIIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public K last() {
            if (Object2ObjectLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Object2ObjectLinkedOpenHashMap.this.key[Object2ObjectLinkedOpenHashMap.this.last];
        }
        
        @Override
        public boolean contains(final Object llllllllllllllllIllllllIlIlllIlI) {
            return Object2ObjectLinkedOpenHashMap.this.containsKey(llllllllllllllllIllllllIlIlllIlI);
        }
        
        @Override
        public K first() {
            if (Object2ObjectLinkedOpenHashMap.this.size == 0) {
                throw new NoSuchElementException();
            }
            return Object2ObjectLinkedOpenHashMap.this.key[Object2ObjectLinkedOpenHashMap.this.first];
        }
    }
}
