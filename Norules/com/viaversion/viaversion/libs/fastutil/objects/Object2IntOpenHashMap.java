package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.io.*;
import java.util.*;
import java.util.function.*;

public class Object2IntOpenHashMap<K> extends AbstractObject2IntMap<K> implements Serializable, Cloneable, Hash
{
    protected /* synthetic */ int size;
    protected transient /* synthetic */ int n;
    protected final transient /* synthetic */ int minN;
    protected transient /* synthetic */ K[] key;
    protected transient /* synthetic */ ObjectSet<K> keys;
    protected transient /* synthetic */ int[] value;
    protected transient /* synthetic */ IntCollection values;
    protected transient /* synthetic */ Object2IntMap.FastEntrySet<K> entries;
    protected final /* synthetic */ float f;
    protected transient /* synthetic */ int mask;
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ boolean containsNullKey;
    
    private void insert(final int lllllllllllllllIllllIllIIIllIIII, final K lllllllllllllllIllllIllIIIllIIll, final int lllllllllllllllIllllIllIIIlIlllI) {
        if (lllllllllllllllIllllIllIIIllIIII == this.n) {
            this.containsNullKey = true;
        }
        this.key[lllllllllllllllIllllIllIIIllIIII] = lllllllllllllllIllllIllIIIllIIll;
        this.value[lllllllllllllllIllllIllIIIllIIII] = lllllllllllllllIllllIllIIIlIlllI;
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
    }
    
    @Override
    public void putAll(final Map<? extends K, ? extends Integer> lllllllllllllllIllllIllIIlIIlIll) {
        if (this.f <= 0.5) {
            this.ensureCapacity(lllllllllllllllIllllIllIIlIIlIll.size());
        }
        else {
            this.tryCapacity(this.size() + lllllllllllllllIllllIllIIlIIlIll.size());
        }
        super.putAll(lllllllllllllllIllllIllIIlIIlIll);
    }
    
    public Object2IntOpenHashMap(final Map<? extends K, ? extends Integer> lllllllllllllllIllllIllIlIIllIlI) {
        this(lllllllllllllllIllllIllIlIIllIlI, 0.75f);
    }
    
    public Object2IntOpenHashMap<K> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap;
        //     7: astore_1        /* lllllllllllllllIllllIlIIllIlllll */
        //     8: goto            20
        //    11: astore_2        /* lllllllllllllllIllllIlIIllIllIIl */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllllllIllllIlIIllIlllII */
        //    21: aconst_null    
        //    22: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap.keys:Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectSet;
        //    25: aload_1         /* lllllllllllllllIllllIlIIllIlllII */
        //    26: aconst_null    
        //    27: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap.values:Lcom/viaversion/viaversion/libs/fastutil/ints/IntCollection;
        //    30: aload_1         /* lllllllllllllllIllllIlIIllIlllII */
        //    31: aconst_null    
        //    32: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap.entries:Lcom/viaversion/viaversion/libs/fastutil/objects/Object2IntMap$FastEntrySet;
        //    35: aload_1         /* lllllllllllllllIllllIlIIllIlllII */
        //    36: aload_0         /* lllllllllllllllIllllIlIIllIllIll */
        //    37: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap.containsNullKey:Z
        //    40: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap.containsNullKey:Z
        //    43: aload_1         /* lllllllllllllllIllllIlIIllIlllII */
        //    44: aload_0         /* lllllllllllllllIllllIlIIllIllIll */
        //    45: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap.key:[Ljava/lang/Object;
        //    48: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    51: checkcast       [Ljava/lang/Object;
        //    54: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap.key:[Ljava/lang/Object;
        //    57: aload_1         /* lllllllllllllllIllllIlIIllIlllII */
        //    58: aload_0         /* lllllllllllllllIllllIlIIllIllIll */
        //    59: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap.value:[I
        //    62: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    65: checkcast       [I
        //    68: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap.value:[I
        //    71: aload_1         /* lllllllllllllllIllllIlIIllIlllII */
        //    72: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/objects/Object2IntOpenHashMap<TK;>;
        //    StackMapTable: 00 02 4B 07 00 98 FC 00 08 07 00 02
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
    public int computeInt(final K lllllllllllllllIllllIlIlIIlllllI, final BiFunction<? super K, ? super Integer, ? extends Integer> lllllllllllllllIllllIlIlIIllllIl) {
        Objects.requireNonNull(lllllllllllllllIllllIlIlIIllllIl);
        final int lllllllllllllllIllllIlIlIIllllII = this.find(lllllllllllllllIllllIlIlIIlllllI);
        final Integer lllllllllllllllIllllIlIlIIlllIll = (Integer)lllllllllllllllIllllIlIlIIllllIl.apply((Object)lllllllllllllllIllllIlIlIIlllllI, (lllllllllllllllIllllIlIlIIllllII >= 0) ? Integer.valueOf(this.value[lllllllllllllllIllllIlIlIIllllII]) : null);
        if (lllllllllllllllIllllIlIlIIlllIll == null) {
            if (lllllllllllllllIllllIlIlIIllllII >= 0) {
                if (lllllllllllllllIllllIlIlIIlllllI == null) {
                    this.removeNullEntry();
                }
                else {
                    this.removeEntry(lllllllllllllllIllllIlIlIIllllII);
                }
            }
            return this.defRetValue;
        }
        final int lllllllllllllllIllllIlIlIIlllIlI = lllllllllllllllIllllIlIlIIlllIll;
        if (lllllllllllllllIllllIlIlIIllllII < 0) {
            this.insert(-lllllllllllllllIllllIlIlIIllllII - 1, lllllllllllllllIllllIlIlIIlllllI, lllllllllllllllIllllIlIlIIlllIlI);
            return lllllllllllllllIllllIlIlIIlllIlI;
        }
        return this.value[lllllllllllllllIllllIlIlIIllllII] = lllllllllllllllIllllIlIlIIlllIlI;
    }
    
    @Override
    public IntCollection values() {
        if (this.values == null) {
            this.values = new AbstractIntCollection() {
                @Override
                public int size() {
                    return Object2IntOpenHashMap.this.size;
                }
                
                @Override
                public IntIterator iterator() {
                    return new ValueIterator();
                }
                
                @Override
                public boolean contains(final int lllllllllllllIlIlllIlllllIlllIll) {
                    return Object2IntOpenHashMap.this.containsValue(lllllllllllllIlIlllIlllllIlllIll);
                }
                
                @Override
                public void clear() {
                    Object2IntOpenHashMap.this.clear();
                }
                
                @Override
                public void forEach(final IntConsumer lllllllllllllIlIlllIlllllIlIlllI) {
                    if (Object2IntOpenHashMap.this.containsNullKey) {
                        lllllllllllllIlIlllIlllllIlIlllI.accept(Object2IntOpenHashMap.this.value[Object2IntOpenHashMap.this.n]);
                    }
                    int lllllllllllllIlIlllIlllllIllIIlI = Object2IntOpenHashMap.this.n;
                    while (lllllllllllllIlIlllIlllllIllIIlI-- != 0) {
                        if (Object2IntOpenHashMap.this.key[lllllllllllllIlIlllIlllllIllIIlI] != null) {
                            lllllllllllllIlIlllIlllllIlIlllI.accept(Object2IntOpenHashMap.this.value[lllllllllllllIlIlllIlllllIllIIlI]);
                        }
                    }
                }
            };
        }
        return this.values;
    }
    
    public Object2IntOpenHashMap(final Map<? extends K, ? extends Integer> lllllllllllllllIllllIllIlIlIIlII, final float lllllllllllllllIllllIllIlIlIIIll) {
        this(lllllllllllllllIllllIllIlIlIIlII.size(), lllllllllllllllIllllIllIlIlIIIll);
        this.putAll(lllllllllllllllIllllIllIlIlIIlII);
    }
    
    public Object2IntOpenHashMap() {
        this(16, 0.75f);
    }
    
    private int realSize() {
        return this.containsNullKey ? (this.size - 1) : this.size;
    }
    
    @Override
    public boolean replace(final K lllllllllllllllIllllIlIlIllllIll, final int lllllllllllllllIllllIlIlIlllIlIl, final int lllllllllllllllIllllIlIlIlllIlII) {
        final int lllllllllllllllIllllIlIlIllllIII = this.find(lllllllllllllllIllllIlIlIllllIll);
        if (lllllllllllllllIllllIlIlIllllIII < 0 || lllllllllllllllIllllIlIlIlllIlIl != this.value[lllllllllllllllIllllIlIlIllllIII]) {
            return false;
        }
        this.value[lllllllllllllllIllllIlIlIllllIII] = lllllllllllllllIllllIlIlIlllIlII;
        return true;
    }
    
    @Override
    public boolean containsKey(final Object lllllllllllllllIllllIlIlllIIIlII) {
        if (lllllllllllllllIllllIlIlllIIIlII == null) {
            return this.containsNullKey;
        }
        final K[] lllllllllllllllIllllIlIlllIIIlll = this.key;
        int lllllllllllllllIllllIlIlllIIIllI;
        K lllllllllllllllIllllIlIlllIIlIII;
        if ((lllllllllllllllIllllIlIlllIIlIII = lllllllllllllllIllllIlIlllIIIlll[lllllllllllllllIllllIlIlllIIIllI = (HashCommon.mix(lllllllllllllllIllllIlIlllIIIlII.hashCode()) & this.mask)]) == null) {
            return false;
        }
        if (lllllllllllllllIllllIlIlllIIIlII.equals(lllllllllllllllIllllIlIlllIIlIII)) {
            return true;
        }
        while ((lllllllllllllllIllllIlIlllIIlIII = lllllllllllllllIllllIlIlllIIIlll[lllllllllllllllIllllIlIlllIIIllI = (lllllllllllllllIllllIlIlllIIIllI + 1 & this.mask)]) != null) {
            if (lllllllllllllllIllllIlIlllIIIlII.equals(lllllllllllllllIllllIlIlllIIlIII)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    private void ensureCapacity(final int lllllllllllllllIllllIllIIllIlIII) {
        final int lllllllllllllllIllllIllIIllIlIlI = HashCommon.arraySize(lllllllllllllllIllllIllIIllIlIII, this.f);
        if (lllllllllllllllIllllIllIIllIlIlI > this.n) {
            this.rehash(lllllllllllllllIllllIllIIllIlIlI);
        }
    }
    
    @Override
    public int putIfAbsent(final K lllllllllllllllIllllIlIllIIllIlI, final int lllllllllllllllIllllIlIllIIlIlIl) {
        final int lllllllllllllllIllllIlIllIIllIII = this.find(lllllllllllllllIllllIlIllIIllIlI);
        if (lllllllllllllllIllllIlIllIIllIII >= 0) {
            return this.value[lllllllllllllllIllllIlIllIIllIII];
        }
        this.insert(-lllllllllllllllIllllIlIllIIllIII - 1, lllllllllllllllIllllIlIllIIllIlI, lllllllllllllllIllllIlIllIIlIlIl);
        return this.defRetValue;
    }
    
    @Override
    public ObjectSet<K> keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }
    
    protected void rehash(final int lllllllllllllllIllllIlIIllllIIll) {
        final K[] lllllllllllllllIllllIlIIllllIIlI = this.key;
        final int[] lllllllllllllllIllllIlIIllllIIIl = this.value;
        final int lllllllllllllllIllllIlIIllllIIII = lllllllllllllllIllllIlIIllllIIll - 1;
        final K[] lllllllllllllllIllllIlIIlllIllll = (K[])new Object[lllllllllllllllIllllIlIIllllIIll + 1];
        final int[] lllllllllllllllIllllIlIIlllIlllI = new int[lllllllllllllllIllllIlIIllllIIll + 1];
        int lllllllllllllllIllllIlIIlllIllIl = this.n;
        int lllllllllllllllIllllIlIIllllIlIl = this.realSize();
        while (lllllllllllllllIllllIlIIllllIlIl-- != 0) {
            while (lllllllllllllllIllllIlIIllllIIlI[--lllllllllllllllIllllIlIIlllIllIl] == null) {}
            int lllllllllllllllIllllIlIIllllIllI;
            if (lllllllllllllllIllllIlIIlllIllll[lllllllllllllllIllllIlIIllllIllI = (HashCommon.mix(lllllllllllllllIllllIlIIllllIIlI[lllllllllllllllIllllIlIIlllIllIl].hashCode()) & lllllllllllllllIllllIlIIllllIIII)] != null) {
                while (lllllllllllllllIllllIlIIlllIllll[lllllllllllllllIllllIlIIllllIllI = (lllllllllllllllIllllIlIIllllIllI + 1 & lllllllllllllllIllllIlIIllllIIII)] != null) {}
            }
            lllllllllllllllIllllIlIIlllIllll[lllllllllllllllIllllIlIIllllIllI] = lllllllllllllllIllllIlIIllllIIlI[lllllllllllllllIllllIlIIlllIllIl];
            lllllllllllllllIllllIlIIlllIlllI[lllllllllllllllIllllIlIIllllIllI] = lllllllllllllllIllllIlIIllllIIIl[lllllllllllllllIllllIlIIlllIllIl];
        }
        lllllllllllllllIllllIlIIlllIlllI[lllllllllllllllIllllIlIIllllIIll] = lllllllllllllllIllllIlIIllllIIIl[this.n];
        this.n = lllllllllllllllIllllIlIIllllIIll;
        this.mask = lllllllllllllllIllllIlIIllllIIII;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = lllllllllllllllIllllIlIIlllIllll;
        this.value = lllllllllllllllIllllIlIIlllIlllI;
    }
    
    public Object2IntOpenHashMap(final K[] lllllllllllllllIllllIllIlIIIIIll, final int[] lllllllllllllllIllllIllIIllllllI, final float lllllllllllllllIllllIllIIlllllIl) {
        this(lllllllllllllllIllllIllIlIIIIIll.length, lllllllllllllllIllllIllIIlllllIl);
        if (lllllllllllllllIllllIllIlIIIIIll.length != lllllllllllllllIllllIllIIllllllI.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The key array and the value array have different lengths (").append(lllllllllllllllIllllIllIlIIIIIll.length).append(" and ").append(lllllllllllllllIllllIllIIllllllI.length).append(")")));
        }
        for (int lllllllllllllllIllllIllIlIIIIlIl = 0; lllllllllllllllIllllIllIlIIIIlIl < lllllllllllllllIllllIllIlIIIIIll.length; ++lllllllllllllllIllllIllIlIIIIlIl) {
            this.put(lllllllllllllllIllllIllIlIIIIIll[lllllllllllllllIllllIllIlIIIIlIl], lllllllllllllllIllllIllIIllllllI[lllllllllllllllIllllIllIlIIIIlIl]);
        }
    }
    
    @Override
    public int getInt(final Object lllllllllllllllIllllIlIlllIllIII) {
        if (lllllllllllllllIllllIlIlllIllIII == null) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        }
        final K[] lllllllllllllllIllllIlIlllIlIllI = this.key;
        int lllllllllllllllIllllIlIlllIlIlIl;
        K lllllllllllllllIllllIlIlllIlIlll;
        if ((lllllllllllllllIllllIlIlllIlIlll = lllllllllllllllIllllIlIlllIlIllI[lllllllllllllllIllllIlIlllIlIlIl = (HashCommon.mix(lllllllllllllllIllllIlIlllIllIII.hashCode()) & this.mask)]) == null) {
            return this.defRetValue;
        }
        if (lllllllllllllllIllllIlIlllIllIII.equals(lllllllllllllllIllllIlIlllIlIlll)) {
            return this.value[lllllllllllllllIllllIlIlllIlIlIl];
        }
        while ((lllllllllllllllIllllIlIlllIlIlll = lllllllllllllllIllllIlIlllIlIllI[lllllllllllllllIllllIlIlllIlIlIl = (lllllllllllllllIllllIlIlllIlIlIl + 1 & this.mask)]) != null) {
            if (lllllllllllllllIllllIlIlllIllIII.equals(lllllllllllllllIllllIlIlllIlIlll)) {
                return this.value[lllllllllllllllIllllIlIlllIlIlIl];
            }
        }
        return this.defRetValue;
    }
    
    public Object2IntOpenHashMap(final Object2IntMap<K> lllllllllllllllIllllIllIlIIlIIlI, final float lllllllllllllllIllllIllIlIIlIIIl) {
        this(lllllllllllllllIllllIllIlIIlIIlI.size(), lllllllllllllllIllllIllIlIIlIIIl);
        this.putAll((Map<? extends K, ? extends Integer>)lllllllllllllllIllllIllIlIIlIIlI);
    }
    
    @Override
    public int removeInt(final Object lllllllllllllllIllllIlIllllIIlll) {
        if (lllllllllllllllIllllIlIllllIIlll == null) {
            if (this.containsNullKey) {
                return this.removeNullEntry();
            }
            return this.defRetValue;
        }
        else {
            final K[] lllllllllllllllIllllIlIllllIIlIl = this.key;
            int lllllllllllllllIllllIlIllllIIlII;
            K lllllllllllllllIllllIlIllllIIllI;
            if ((lllllllllllllllIllllIlIllllIIllI = lllllllllllllllIllllIlIllllIIlIl[lllllllllllllllIllllIlIllllIIlII = (HashCommon.mix(lllllllllllllllIllllIlIllllIIlll.hashCode()) & this.mask)]) == null) {
                return this.defRetValue;
            }
            if (lllllllllllllllIllllIlIllllIIlll.equals(lllllllllllllllIllllIlIllllIIllI)) {
                return this.removeEntry(lllllllllllllllIllllIlIllllIIlII);
            }
            while ((lllllllllllllllIllllIlIllllIIllI = lllllllllllllllIllllIlIllllIIlIl[lllllllllllllllIllllIlIllllIIlII = (lllllllllllllllIllllIlIllllIIlII + 1 & this.mask)]) != null) {
                if (lllllllllllllllIllllIlIllllIIlll.equals(lllllllllllllllIllllIlIllllIIllI)) {
                    return this.removeEntry(lllllllllllllllIllllIlIllllIIlII);
                }
            }
            return this.defRetValue;
        }
    }
    
    private int removeEntry(final int lllllllllllllllIllllIllIIlIlIllI) {
        final int lllllllllllllllIllllIllIIlIllIII = this.value[lllllllllllllllIllllIllIIlIlIllI];
        --this.size;
        this.shiftKeys(lllllllllllllllIllllIllIIlIlIllI);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllllIllllIllIIlIllIII;
    }
    
    public Object2IntOpenHashMap(final int lllllllllllllllIllllIllIlIllIllI, final float lllllllllllllllIllllIllIlIllIlIl) {
        if (lllllllllllllllIllllIllIlIllIlIl <= 0.0f || lllllllllllllllIllllIllIlIllIlIl > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (lllllllllllllllIllllIllIlIllIllI < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = lllllllllllllllIllllIllIlIllIlIl;
        final int arraySize = HashCommon.arraySize(lllllllllllllllIllllIllIlIllIllI, lllllllllllllllIllllIllIlIllIlIl);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, lllllllllllllllIllllIllIlIllIlIl);
        this.key = (K[])new Object[this.n + 1];
        this.value = new int[this.n + 1];
    }
    
    public Object2IntOpenHashMap(final int lllllllllllllllIllllIllIlIlIllII) {
        this(lllllllllllllllIllllIllIlIlIllII, 0.75f);
    }
    
    @Override
    public int getOrDefault(final Object lllllllllllllllIllllIlIllIlIIlII, final int lllllllllllllllIllllIlIllIlIIIll) {
        if (lllllllllllllllIllllIlIllIlIIlII == null) {
            return this.containsNullKey ? this.value[this.n] : lllllllllllllllIllllIlIllIlIIIll;
        }
        final K[] lllllllllllllllIllllIlIllIlIIlll = this.key;
        int lllllllllllllllIllllIlIllIlIIllI;
        K lllllllllllllllIllllIlIllIlIlIII;
        if ((lllllllllllllllIllllIlIllIlIlIII = lllllllllllllllIllllIlIllIlIIlll[lllllllllllllllIllllIlIllIlIIllI = (HashCommon.mix(lllllllllllllllIllllIlIllIlIIlII.hashCode()) & this.mask)]) == null) {
            return lllllllllllllllIllllIlIllIlIIIll;
        }
        if (lllllllllllllllIllllIlIllIlIIlII.equals(lllllllllllllllIllllIlIllIlIlIII)) {
            return this.value[lllllllllllllllIllllIlIllIlIIllI];
        }
        while ((lllllllllllllllIllllIlIllIlIlIII = lllllllllllllllIllllIlIllIlIIlll[lllllllllllllllIllllIlIllIlIIllI = (lllllllllllllllIllllIlIllIlIIllI + 1 & this.mask)]) != null) {
            if (lllllllllllllllIllllIlIllIlIIlII.equals(lllllllllllllllIllllIlIllIlIlIII)) {
                return this.value[lllllllllllllllIllllIlIllIlIIllI];
            }
        }
        return lllllllllllllllIllllIlIllIlIIIll;
    }
    
    @Override
    public int replace(final K lllllllllllllllIllllIlIlIllIIlll, final int lllllllllllllllIllllIlIlIllIIllI) {
        final int lllllllllllllllIllllIlIlIllIlIlI = this.find(lllllllllllllllIllllIlIlIllIIlll);
        if (lllllllllllllllIllllIlIlIllIlIlI < 0) {
            return this.defRetValue;
        }
        final int lllllllllllllllIllllIlIlIllIlIIl = this.value[lllllllllllllllIllllIlIlIllIlIlI];
        this.value[lllllllllllllllIllllIlIlIllIlIlI] = lllllllllllllllIllllIlIlIllIIllI;
        return lllllllllllllllIllllIlIlIllIlIIl;
    }
    
    protected final void shiftKeys(int lllllllllllllllIllllIlIlllllIIlI) {
        final K[] lllllllllllllllIllllIlIlllllIlII = this.key;
        int lllllllllllllllIllllIlIlllllIlll = 0;
    Label_0006:
        while (true) {
            lllllllllllllllIllllIlIlllllIIlI = ((lllllllllllllllIllllIlIlllllIlll = lllllllllllllllIllllIlIlllllIIlI) + 1 & this.mask);
            K lllllllllllllllIllllIlIlllllIlIl;
            while ((lllllllllllllllIllllIlIlllllIlIl = lllllllllllllllIllllIlIlllllIlII[lllllllllllllllIllllIlIlllllIIlI]) != null) {
                final int lllllllllllllllIllllIlIlllllIllI = HashCommon.mix(lllllllllllllllIllllIlIlllllIlIl.hashCode()) & this.mask;
                Label_0090: {
                    if (lllllllllllllllIllllIlIlllllIlll <= lllllllllllllllIllllIlIlllllIIlI) {
                        if (lllllllllllllllIllllIlIlllllIlll >= lllllllllllllllIllllIlIlllllIllI) {
                            break Label_0090;
                        }
                        if (lllllllllllllllIllllIlIlllllIllI > lllllllllllllllIllllIlIlllllIIlI) {
                            break Label_0090;
                        }
                    }
                    else if (lllllllllllllllIllllIlIlllllIlll >= lllllllllllllllIllllIlIlllllIllI && lllllllllllllllIllllIlIlllllIllI > lllllllllllllllIllllIlIlllllIIlI) {
                        break Label_0090;
                    }
                    lllllllllllllllIllllIlIlllllIIlI = (lllllllllllllllIllllIlIlllllIIlI + 1 & this.mask);
                    continue;
                }
                lllllllllllllllIllllIlIlllllIlII[lllllllllllllllIllllIlIlllllIlll] = lllllllllllllllIllllIlIlllllIlIl;
                this.value[lllllllllllllllIllllIlIlllllIlll] = this.value[lllllllllllllllIllllIlIlllllIIlI];
                continue Label_0006;
            }
            break;
        }
        lllllllllllllllIllllIlIlllllIlII[lllllllllllllllIllllIlIlllllIlll] = null;
    }
    
    public boolean trim(final int lllllllllllllllIllllIlIlIIIIIllI) {
        final int lllllllllllllllIllllIlIlIIIIIlIl = HashCommon.nextPowerOfTwo((int)Math.ceil(lllllllllllllllIllllIlIlIIIIIllI / this.f));
        if (lllllllllllllllIllllIlIlIIIIIlIl >= this.n || this.size > HashCommon.maxFill(lllllllllllllllIllllIlIlIIIIIlIl, this.f)) {
            return true;
        }
        try {
            this.rehash(lllllllllllllllIllllIlIlIIIIIlIl);
        }
        catch (OutOfMemoryError lllllllllllllllIllllIlIlIIIIlIII) {
            return false;
        }
        return true;
    }
    
    private void checkTable() {
    }
    
    public Object2IntOpenHashMap(final Object2IntMap<K> lllllllllllllllIllllIllIlIIIlIll) {
        this(lllllllllllllllIllllIllIlIIIlIll, 0.75f);
    }
    
    private void readObject(final ObjectInputStream lllllllllllllllIllllIlIIlIlIIIlI) throws ClassNotFoundException, IOException {
        lllllllllllllllIllllIlIIlIlIIIlI.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final Object[] key = new Object[this.n + 1];
        this.key = (K[])key;
        final K[] lllllllllllllllIllllIlIIlIlIIlIl = (K[])key;
        final int[] value = new int[this.n + 1];
        this.value = value;
        final int[] lllllllllllllllIllllIlIIlIlIIlII = value;
        int lllllllllllllllIllllIlIIlIlIlIIl = this.size;
        while (lllllllllllllllIllllIlIIlIlIlIIl-- != 0) {
            final K lllllllllllllllIllllIlIIlIlIlIll = (K)lllllllllllllllIllllIlIIlIlIIIlI.readObject();
            final int lllllllllllllllIllllIlIIlIlIlIlI = lllllllllllllllIllllIlIIlIlIIIlI.readInt();
            int lllllllllllllllIllllIlIIlIlIlIII = 0;
            if (lllllllllllllllIllllIlIIlIlIlIll == null) {
                final int lllllllllllllllIllllIlIIlIlIllII = this.n;
                this.containsNullKey = true;
            }
            else {
                for (lllllllllllllllIllllIlIIlIlIlIII = (HashCommon.mix(lllllllllllllllIllllIlIIlIlIlIll.hashCode()) & this.mask); lllllllllllllllIllllIlIIlIlIIlIl[lllllllllllllllIllllIlIIlIlIlIII] != null; lllllllllllllllIllllIlIIlIlIlIII = (lllllllllllllllIllllIlIIlIlIlIII + 1 & this.mask)) {}
            }
            lllllllllllllllIllllIlIIlIlIIlIl[lllllllllllllllIllllIlIIlIlIlIII] = lllllllllllllllIllllIlIIlIlIlIll;
            lllllllllllllllIllllIlIIlIlIIlII[lllllllllllllllIllllIlIIlIlIlIII] = lllllllllllllllIllllIlIIlIlIlIlI;
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
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public boolean remove(final Object lllllllllllllllIllllIlIllIIIIllI, final int lllllllllllllllIllllIlIllIIIIlIl) {
        if (lllllllllllllllIllllIlIllIIIIllI == null) {
            if (this.containsNullKey && lllllllllllllllIllllIlIllIIIIlIl == this.value[this.n]) {
                this.removeNullEntry();
                return true;
            }
            return false;
        }
        else {
            final K[] lllllllllllllllIllllIlIllIIIlIIl = this.key;
            int lllllllllllllllIllllIlIllIIIlIII;
            K lllllllllllllllIllllIlIllIIIlIlI;
            if ((lllllllllllllllIllllIlIllIIIlIlI = lllllllllllllllIllllIlIllIIIlIIl[lllllllllllllllIllllIlIllIIIlIII = (HashCommon.mix(lllllllllllllllIllllIlIllIIIIllI.hashCode()) & this.mask)]) == null) {
                return false;
            }
            if (lllllllllllllllIllllIlIllIIIIllI.equals(lllllllllllllllIllllIlIllIIIlIlI) && lllllllllllllllIllllIlIllIIIIlIl == this.value[lllllllllllllllIllllIlIllIIIlIII]) {
                this.removeEntry(lllllllllllllllIllllIlIllIIIlIII);
                return true;
            }
            while ((lllllllllllllllIllllIlIllIIIlIlI = lllllllllllllllIllllIlIllIIIlIIl[lllllllllllllllIllllIlIllIIIlIII = (lllllllllllllllIllllIlIllIIIlIII + 1 & this.mask)]) != null) {
                if (lllllllllllllllIllllIlIllIIIIllI.equals(lllllllllllllllIllllIlIllIIIlIlI) && lllllllllllllllIllllIlIllIIIIlIl == this.value[lllllllllllllllIllllIlIllIIIlIII]) {
                    this.removeEntry(lllllllllllllllIllllIlIllIIIlIII);
                    return true;
                }
            }
            return false;
        }
    }
    
    @Override
    public int computeIntIfAbsent(final K lllllllllllllllIllllIlIlIlIllIII, final ToIntFunction<? super K> lllllllllllllllIllllIlIlIlIlIlll) {
        Objects.requireNonNull(lllllllllllllllIllllIlIlIlIlIlll);
        final int lllllllllllllllIllllIlIlIlIllIll = this.find(lllllllllllllllIllllIlIlIlIllIII);
        if (lllllllllllllllIllllIlIlIlIllIll >= 0) {
            return this.value[lllllllllllllllIllllIlIlIlIllIll];
        }
        final int lllllllllllllllIllllIlIlIlIllIlI = lllllllllllllllIllllIlIlIlIlIlll.applyAsInt((Object)lllllllllllllllIllllIlIlIlIllIII);
        this.insert(-lllllllllllllllIllllIlIlIlIllIll - 1, lllllllllllllllIllllIlIlIlIllIII, lllllllllllllllIllllIlIlIlIllIlI);
        return lllllllllllllllIllllIlIlIlIllIlI;
    }
    
    @Override
    public int computeIntIfPresent(final K lllllllllllllllIllllIlIlIlIIlIIl, final BiFunction<? super K, ? super Integer, ? extends Integer> lllllllllllllllIllllIlIlIlIIlIII) {
        Objects.requireNonNull(lllllllllllllllIllllIlIlIlIIlIII);
        final int lllllllllllllllIllllIlIlIlIIllII = this.find(lllllllllllllllIllllIlIlIlIIlIIl);
        if (lllllllllllllllIllllIlIlIlIIllII < 0) {
            return this.defRetValue;
        }
        final Integer lllllllllllllllIllllIlIlIlIIlIll = (Integer)lllllllllllllllIllllIlIlIlIIlIII.apply((Object)lllllllllllllllIllllIlIlIlIIlIIl, Integer.valueOf(this.value[lllllllllllllllIllllIlIlIlIIllII]));
        if (lllllllllllllllIllllIlIlIlIIlIll == null) {
            if (lllllllllllllllIllllIlIlIlIIlIIl == null) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(lllllllllllllllIllllIlIlIlIIllII);
            }
            return this.defRetValue;
        }
        return this.value[lllllllllllllllIllllIlIlIlIIllII] = lllllllllllllllIllllIlIlIlIIlIll;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllIllllIlIIllIIllll = 0;
        int lllllllllllllllIllllIlIIllIlIIll = this.realSize();
        int lllllllllllllllIllllIlIIllIlIIlI = 0;
        int lllllllllllllllIllllIlIIllIlIIIl = 0;
        while (lllllllllllllllIllllIlIIllIlIIll-- != 0) {
            while (this.key[lllllllllllllllIllllIlIIllIlIIlI] == null) {
                ++lllllllllllllllIllllIlIIllIlIIlI;
            }
            if (this != this.key[lllllllllllllllIllllIlIIllIlIIlI]) {
                lllllllllllllllIllllIlIIllIlIIIl = this.key[lllllllllllllllIllllIlIIllIlIIlI].hashCode();
            }
            lllllllllllllllIllllIlIIllIlIIIl ^= this.value[lllllllllllllllIllllIlIIllIlIIlI];
            lllllllllllllllIllllIlIIllIIllll += lllllllllllllllIllllIlIIllIlIIIl;
            ++lllllllllllllllIllllIlIIllIlIIlI;
        }
        if (this.containsNullKey) {
            lllllllllllllllIllllIlIIllIIllll += this.value[this.n];
        }
        return lllllllllllllllIllllIlIIllIIllll;
    }
    
    @Override
    public Object2IntMap.FastEntrySet<K> object2IntEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }
    
    private int find(final K lllllllllllllllIllllIllIIlIIIIlI) {
        if (lllllllllllllllIllllIllIIlIIIIlI == null) {
            return this.containsNullKey ? this.n : (-(this.n + 1));
        }
        final K[] lllllllllllllllIllllIllIIlIIIIII = this.key;
        int lllllllllllllllIllllIllIIIllllll;
        K lllllllllllllllIllllIllIIlIIIIIl;
        if ((lllllllllllllllIllllIllIIlIIIIIl = lllllllllllllllIllllIllIIlIIIIII[lllllllllllllllIllllIllIIIllllll = (HashCommon.mix(lllllllllllllllIllllIllIIlIIIIlI.hashCode()) & this.mask)]) == null) {
            return -(lllllllllllllllIllllIllIIIllllll + 1);
        }
        if (lllllllllllllllIllllIllIIlIIIIlI.equals(lllllllllllllllIllllIllIIlIIIIIl)) {
            return lllllllllllllllIllllIllIIIllllll;
        }
        while ((lllllllllllllllIllllIllIIlIIIIIl = lllllllllllllllIllllIllIIlIIIIII[lllllllllllllllIllllIllIIIllllll = (lllllllllllllllIllllIllIIIllllll + 1 & this.mask)]) != null) {
            if (lllllllllllllllIllllIllIIlIIIIlI.equals(lllllllllllllllIllllIllIIlIIIIIl)) {
                return lllllllllllllllIllllIllIIIllllll;
            }
        }
        return -(lllllllllllllllIllllIllIIIllllll + 1);
    }
    
    @Override
    public int mergeInt(final K lllllllllllllllIllllIlIlIIlIIllI, final int lllllllllllllllIllllIlIlIIlIlIll, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllllIllllIlIlIIlIIlII) {
        Objects.requireNonNull(lllllllllllllllIllllIlIlIIlIIlII);
        final int lllllllllllllllIllllIlIlIIlIlIIl = this.find(lllllllllllllllIllllIlIlIIlIIllI);
        if (lllllllllllllllIllllIlIlIIlIlIIl < 0) {
            this.insert(-lllllllllllllllIllllIlIlIIlIlIIl - 1, lllllllllllllllIllllIlIlIIlIIllI, lllllllllllllllIllllIlIlIIlIlIll);
            return lllllllllllllllIllllIlIlIIlIlIll;
        }
        final Integer lllllllllllllllIllllIlIlIIlIlIII = (Integer)lllllllllllllllIllllIlIlIIlIIlII.apply(this.value[lllllllllllllllIllllIlIlIIlIlIIl], lllllllllllllllIllllIlIlIIlIlIll);
        if (lllllllllllllllIllllIlIlIIlIlIII == null) {
            if (lllllllllllllllIllllIlIlIIlIIllI == null) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(lllllllllllllllIllllIlIlIIlIlIIl);
            }
            return this.defRetValue;
        }
        return this.value[lllllllllllllllIllllIlIlIIlIlIIl] = lllllllllllllllIllllIlIlIIlIlIII;
    }
    
    public Object2IntOpenHashMap(final K[] lllllllllllllllIllllIllIIlllIlII, final int[] lllllllllllllllIllllIllIIlllIIll) {
        this(lllllllllllllllIllllIllIIlllIlII, lllllllllllllllIllllIllIIlllIIll, 0.75f);
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    private int addToValue(final int lllllllllllllllIllllIllIIIIlIlIl, final int lllllllllllllllIllllIllIIIIllIII) {
        final int lllllllllllllllIllllIllIIIIlIlll = this.value[lllllllllllllllIllllIllIIIIlIlIl];
        this.value[lllllllllllllllIllllIllIIIIlIlIl] = lllllllllllllllIllllIllIIIIlIlll + lllllllllllllllIllllIllIIIIllIII;
        return lllllllllllllllIllllIllIIIIlIlll;
    }
    
    @Override
    public boolean containsValue(final int lllllllllllllllIllllIlIllIllIlIl) {
        final int[] lllllllllllllllIllllIlIllIlllIII = this.value;
        final K[] lllllllllllllllIllllIlIllIllIlll = this.key;
        if (this.containsNullKey && lllllllllllllllIllllIlIllIlllIII[this.n] == lllllllllllllllIllllIlIllIllIlIl) {
            return true;
        }
        int lllllllllllllllIllllIlIllIlllIll = this.n;
        while (lllllllllllllllIllllIlIllIlllIll-- != 0) {
            if (lllllllllllllllIllllIlIllIllIlll[lllllllllllllllIllllIlIllIlllIll] != null && lllllllllllllllIllllIlIllIlllIII[lllllllllllllllIllllIlIllIlllIll] == lllllllllllllllIllllIlIllIllIlIl) {
                return true;
            }
        }
        return false;
    }
    
    private int removeNullEntry() {
        this.containsNullKey = false;
        this.key[this.n] = null;
        final int lllllllllllllllIllllIllIIlIlIIIl = this.value[this.n];
        --this.size;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllllIllllIllIIlIlIIIl;
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllllIllllIlIIlIlllIlI) throws IOException {
        final K[] lllllllllllllllIllllIlIIlIlllllI = this.key;
        final int[] lllllllllllllllIllllIlIIlIllllIl = this.value;
        final MapIterator lllllllllllllllIllllIlIIlIllllII = new MapIterator();
        lllllllllllllllIllllIlIIlIlllIlI.defaultWriteObject();
        int lllllllllllllllIllllIlIIllIIIIlI = this.size;
        while (lllllllllllllllIllllIlIIllIIIIlI-- != 0) {
            final int lllllllllllllllIllllIlIIllIIIIIl = lllllllllllllllIllllIlIIlIllllII.nextEntry();
            lllllllllllllllIllllIlIIlIlllIlI.writeObject(lllllllllllllllIllllIlIIlIlllllI[lllllllllllllllIllllIlIIllIIIIIl]);
            lllllllllllllllIllllIlIIlIlllIlI.writeInt(lllllllllllllllIllllIlIIlIllllIl[lllllllllllllllIllllIlIIllIIIIIl]);
        }
    }
    
    @Override
    public int put(final K lllllllllllllllIllllIllIIIlIIIlI, final int lllllllllllllllIllllIllIIIlIIIIl) {
        final int lllllllllllllllIllllIllIIIlIIlIl = this.find(lllllllllllllllIllllIllIIIlIIIlI);
        if (lllllllllllllllIllllIllIIIlIIlIl < 0) {
            this.insert(-lllllllllllllllIllllIllIIIlIIlIl - 1, lllllllllllllllIllllIllIIIlIIIlI, lllllllllllllllIllllIllIIIlIIIIl);
            return this.defRetValue;
        }
        final int lllllllllllllllIllllIllIIIlIIlII = this.value[lllllllllllllllIllllIllIIIlIIlIl];
        this.value[lllllllllllllllIllllIllIIIlIIlIl] = lllllllllllllllIllllIllIIIlIIIIl;
        return lllllllllllllllIllllIllIIIlIIlII;
    }
    
    public int addTo(final K lllllllllllllllIllllIllIIIIIlIII, final int lllllllllllllllIllllIllIIIIIIIll) {
        int lllllllllllllllIllllIllIIIIIIllI = 0;
        if (lllllllllllllllIllllIllIIIIIlIII == null) {
            if (this.containsNullKey) {
                return this.addToValue(this.n, lllllllllllllllIllllIllIIIIIIIll);
            }
            final int lllllllllllllllIllllIllIIIIIllII = this.n;
            this.containsNullKey = true;
        }
        else {
            final K[] lllllllllllllllIllllIllIIIIIlIlI = this.key;
            K lllllllllllllllIllllIllIIIIIlIll;
            if ((lllllllllllllllIllllIllIIIIIlIll = lllllllllllllllIllllIllIIIIIlIlI[lllllllllllllllIllllIllIIIIIIllI = (HashCommon.mix(lllllllllllllllIllllIllIIIIIlIII.hashCode()) & this.mask)]) != null) {
                if (lllllllllllllllIllllIllIIIIIlIll.equals(lllllllllllllllIllllIllIIIIIlIII)) {
                    return this.addToValue(lllllllllllllllIllllIllIIIIIIllI, lllllllllllllllIllllIllIIIIIIIll);
                }
                while ((lllllllllllllllIllllIllIIIIIlIll = lllllllllllllllIllllIllIIIIIlIlI[lllllllllllllllIllllIllIIIIIIllI = (lllllllllllllllIllllIllIIIIIIllI + 1 & this.mask)]) != null) {
                    if (lllllllllllllllIllllIllIIIIIlIll.equals(lllllllllllllllIllllIllIIIIIlIII)) {
                        return this.addToValue(lllllllllllllllIllllIllIIIIIIllI, lllllllllllllllIllllIllIIIIIIIll);
                    }
                }
            }
        }
        this.key[lllllllllllllllIllllIllIIIIIIllI] = lllllllllllllllIllllIllIIIIIlIII;
        this.value[lllllllllllllllIllllIllIIIIIIllI] = this.defRetValue + lllllllllllllllIllllIllIIIIIIIll;
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return this.defRetValue;
    }
    
    private void tryCapacity(final long lllllllllllllllIllllIllIIlIlllll) {
        final int lllllllllllllllIllllIllIIllIIIIl = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(lllllllllllllllIllllIllIIlIlllll / this.f))));
        if (lllllllllllllllIllllIllIIllIIIIl > this.n) {
            this.rehash(lllllllllllllllIllllIllIIllIIIIl);
        }
    }
    
    static {
        ASSERTS = false;
    }
    
    private class FastEntryIterator extends MapIterator implements ObjectIterator<Object2IntMap.Entry<K>>
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
    
    private class MapIterator
    {
        /* synthetic */ int last;
        /* synthetic */ int pos;
        /* synthetic */ boolean mustReturnNullKey;
        /* synthetic */ ObjectArrayList<K> wrapped;
        /* synthetic */ int c;
        
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Object2IntOpenHashMap.this.n) {
                Object2IntOpenHashMap.this.containsNullKey = false;
                Object2IntOpenHashMap.this.key[Object2IntOpenHashMap.this.n] = null;
            }
            else {
                if (this.pos < 0) {
                    Object2IntOpenHashMap.this.removeInt(this.wrapped.set(-this.pos - 1, null));
                    this.last = -1;
                    return;
                }
                this.shiftKeys(this.last);
            }
            final Object2IntOpenHashMap this$0 = Object2IntOpenHashMap.this;
            --this$0.size;
            this.last = -1;
        }
        
        public int skip(final int llllllllllllllIllIIlIIlIIlIIlIlI) {
            int llllllllllllllIllIIlIIlIIlIIllII = llllllllllllllIllIIlIIlIIlIIlIlI;
            while (llllllllllllllIllIIlIIlIIlIIllII-- != 0 && this.hasNext()) {
                this.nextEntry();
            }
            return llllllllllllllIllIIlIIlIIlIIlIlI - llllllllllllllIllIIlIIlIIlIIllII - 1;
        }
        
        private MapIterator() {
            this.pos = Object2IntOpenHashMap.this.n;
            this.last = -1;
            this.c = Object2IntOpenHashMap.this.size;
            this.mustReturnNullKey = Object2IntOpenHashMap.this.containsNullKey;
        }
        
        private void shiftKeys(int llllllllllllllIllIIlIIlIIllIlIII) {
            final K[] llllllllllllllIllIIlIIlIIllIlIll = Object2IntOpenHashMap.this.key;
            int llllllllllllllIllIIlIIlIIlllIIII = 0;
        Label_0009:
            while (true) {
                llllllllllllllIllIIlIIlIIllIlIII = ((llllllllllllllIllIIlIIlIIlllIIII = llllllllllllllIllIIlIIlIIllIlIII) + 1 & Object2IntOpenHashMap.this.mask);
                K llllllllllllllIllIIlIIlIIllIllIl;
                while ((llllllllllllllIllIIlIIlIIllIllIl = llllllllllllllIllIIlIIlIIllIlIll[llllllllllllllIllIIlIIlIIllIlIII]) != null) {
                    final int llllllllllllllIllIIlIIlIIllIlllI = HashCommon.mix(llllllllllllllIllIIlIIlIIllIllIl.hashCode()) & Object2IntOpenHashMap.this.mask;
                    Label_0102: {
                        if (llllllllllllllIllIIlIIlIIlllIIII <= llllllllllllllIllIIlIIlIIllIlIII) {
                            if (llllllllllllllIllIIlIIlIIlllIIII >= llllllllllllllIllIIlIIlIIllIlllI) {
                                break Label_0102;
                            }
                            if (llllllllllllllIllIIlIIlIIllIlllI > llllllllllllllIllIIlIIlIIllIlIII) {
                                break Label_0102;
                            }
                        }
                        else if (llllllllllllllIllIIlIIlIIlllIIII >= llllllllllllllIllIIlIIlIIllIlllI && llllllllllllllIllIIlIIlIIllIlllI > llllllllllllllIllIIlIIlIIllIlIII) {
                            break Label_0102;
                        }
                        llllllllllllllIllIIlIIlIIllIlIII = (llllllllllllllIllIIlIIlIIllIlIII + 1 & Object2IntOpenHashMap.this.mask);
                        continue;
                    }
                    if (llllllllllllllIllIIlIIlIIllIlIII < llllllllllllllIllIIlIIlIIlllIIII) {
                        if (this.wrapped == null) {
                            this.wrapped = new ObjectArrayList<K>(2);
                        }
                        this.wrapped.add(llllllllllllllIllIIlIIlIIllIlIll[llllllllllllllIllIIlIIlIIllIlIII]);
                    }
                    llllllllllllllIllIIlIIlIIllIlIll[llllllllllllllIllIIlIIlIIlllIIII] = llllllllllllllIllIIlIIlIIllIllIl;
                    Object2IntOpenHashMap.this.value[llllllllllllllIllIIlIIlIIlllIIII] = Object2IntOpenHashMap.this.value[llllllllllllllIllIIlIIlIIllIlIII];
                    continue Label_0009;
                }
                break;
            }
            llllllllllllllIllIIlIIlIIllIlIll[llllllllllllllIllIIlIIlIIlllIIII] = null;
        }
        
        public boolean hasNext() {
            return this.c != 0;
        }
        
        public int nextEntry() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                final int n = Object2IntOpenHashMap.this.n;
                this.last = n;
                return n;
            }
            final K[] llllllllllllllIllIIlIIlIIlllllIl = Object2IntOpenHashMap.this.key;
            while (--this.pos >= 0) {
                if (llllllllllllllIllIIlIIlIIlllllIl[this.pos] != null) {
                    final int pos = this.pos;
                    this.last = pos;
                    return pos;
                }
            }
            this.last = Integer.MIN_VALUE;
            K llllllllllllllIllIIlIIlIlIIIIIII;
            int llllllllllllllIllIIlIIlIIlllllll;
            for (llllllllllllllIllIIlIIlIlIIIIIII = this.wrapped.get(-this.pos - 1), llllllllllllllIllIIlIIlIIlllllll = (HashCommon.mix(llllllllllllllIllIIlIIlIlIIIIIII.hashCode()) & Object2IntOpenHashMap.this.mask); !llllllllllllllIllIIlIIlIlIIIIIII.equals(llllllllllllllIllIIlIIlIIlllllIl[llllllllllllllIllIIlIIlIIlllllll]); llllllllllllllIllIIlIIlIIlllllll = (llllllllllllllIllIIlIIlIIlllllll + 1 & Object2IntOpenHashMap.this.mask)) {}
            return llllllllllllllIllIIlIIlIIlllllll;
        }
    }
    
    final class MapEntry implements Object2IntMap.Entry<K>, Map.Entry<K, Integer>
    {
        /* synthetic */ int index;
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(Object2IntOpenHashMap.this.key[this.index]).append("=>").append(Object2IntOpenHashMap.this.value[this.index]));
        }
        
        @Override
        public int hashCode() {
            return ((Object2IntOpenHashMap.this.key[this.index] == null) ? 0 : Object2IntOpenHashMap.this.key[this.index].hashCode()) ^ Object2IntOpenHashMap.this.value[this.index];
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIlIIlllIllIllIIllIl) {
            if (!(lllllllllllllIlIIlllIllIllIIllIl instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<K, Integer> lllllllllllllIlIIlllIllIllIIllll = (Map.Entry<K, Integer>)lllllllllllllIlIIlllIllIllIIllIl;
            return Objects.equals(Object2IntOpenHashMap.this.key[this.index], lllllllllllllIlIIlllIllIllIIllll.getKey()) && Object2IntOpenHashMap.this.value[this.index] == lllllllllllllIlIIlllIllIllIIllll.getValue();
        }
        
        MapEntry(final int lllllllllllllIlIIlllIllIllllIllI) {
            this.index = lllllllllllllIlIIlllIllIllllIllI;
        }
        
        @Override
        public K getKey() {
            return Object2IntOpenHashMap.this.key[this.index];
        }
        
        @Deprecated
        @Override
        public Integer getValue() {
            return Object2IntOpenHashMap.this.value[this.index];
        }
        
        @Deprecated
        @Override
        public Integer setValue(final Integer lllllllllllllIlIIlllIllIllIlIlIl) {
            return this.setValue((int)lllllllllllllIlIIlllIllIllIlIlIl);
        }
        
        MapEntry() {
        }
        
        @Override
        public int setValue(final int lllllllllllllIlIIlllIllIlllIIIlI) {
            final int lllllllllllllIlIIlllIllIlllIIIIl = Object2IntOpenHashMap.this.value[this.index];
            Object2IntOpenHashMap.this.value[this.index] = lllllllllllllIlIIlllIllIlllIIIlI;
            return lllllllllllllIlIIlllIllIlllIIIIl;
        }
        
        @Override
        public int getIntValue() {
            return Object2IntOpenHashMap.this.value[this.index];
        }
    }
    
    private final class ValueIterator extends MapIterator implements IntIterator
    {
        public ValueIterator() {
        }
        
        @Override
        public int nextInt() {
            return Object2IntOpenHashMap.this.value[this.nextEntry()];
        }
    }
    
    private final class KeySet extends AbstractObjectSet<K>
    {
        @Override
        public int size() {
            return Object2IntOpenHashMap.this.size;
        }
        
        @Override
        public void forEach(final Consumer<? super K> llllIllIIIIllll) {
            if (Object2IntOpenHashMap.this.containsNullKey) {
                llllIllIIIIllll.accept((Object)Object2IntOpenHashMap.this.key[Object2IntOpenHashMap.this.n]);
            }
            int llllIllIIIlIIll = Object2IntOpenHashMap.this.n;
            while (llllIllIIIlIIll-- != 0) {
                final K llllIllIIIlIlII = Object2IntOpenHashMap.this.key[llllIllIIIlIIll];
                if (llllIllIIIlIlII != null) {
                    llllIllIIIIllll.accept((Object)llllIllIIIlIlII);
                }
            }
        }
        
        @Override
        public boolean contains(final Object llllIllIIIIIlII) {
            return Object2IntOpenHashMap.this.containsKey(llllIllIIIIIlII);
        }
        
        @Override
        public boolean remove(final Object llllIlIllllllII) {
            final int llllIlIlllllllI = Object2IntOpenHashMap.this.size;
            Object2IntOpenHashMap.this.removeInt(llllIlIllllllII);
            return Object2IntOpenHashMap.this.size != llllIlIlllllllI;
        }
        
        @Override
        public ObjectIterator<K> iterator() {
            return new KeyIterator();
        }
        
        @Override
        public void clear() {
            Object2IntOpenHashMap.this.clear();
        }
    }
    
    private final class KeyIterator extends MapIterator implements ObjectIterator<K>
    {
        public KeyIterator() {
        }
        
        @Override
        public K next() {
            return Object2IntOpenHashMap.this.key[this.nextEntry()];
        }
    }
    
    private class EntryIterator extends MapIterator implements ObjectIterator<Object2IntMap.Entry<K>>
    {
        private /* synthetic */ MapEntry entry;
        
        @Override
        public void remove() {
            super.remove();
            this.entry.index = -1;
        }
        
        @Override
        public MapEntry next() {
            final MapEntry entry = new MapEntry(this.nextEntry());
            this.entry = entry;
            return entry;
        }
    }
    
    private final class MapEntrySet extends AbstractObjectSet<Object2IntMap.Entry<K>> implements Object2IntMap.FastEntrySet<K>
    {
        @Override
        public ObjectIterator<Object2IntMap.Entry<K>> iterator() {
            return new EntryIterator();
        }
        
        @Override
        public void fastForEach(final Consumer<? super Object2IntMap.Entry<K>> lllllllllllllIllIIlIlIIlIIlIllII) {
            final BasicEntry<K> lllllllllllllIllIIlIlIIlIIlIlllI = new BasicEntry<K>();
            if (Object2IntOpenHashMap.this.containsNullKey) {
                lllllllllllllIllIIlIlIIlIIlIlllI.key = Object2IntOpenHashMap.this.key[Object2IntOpenHashMap.this.n];
                lllllllllllllIllIIlIlIIlIIlIlllI.value = Object2IntOpenHashMap.this.value[Object2IntOpenHashMap.this.n];
                lllllllllllllIllIIlIlIIlIIlIllII.accept(lllllllllllllIllIIlIlIIlIIlIlllI);
            }
            int lllllllllllllIllIIlIlIIlIIllIIIl = Object2IntOpenHashMap.this.n;
            while (lllllllllllllIllIIlIlIIlIIllIIIl-- != 0) {
                if (Object2IntOpenHashMap.this.key[lllllllllllllIllIIlIlIIlIIllIIIl] != null) {
                    lllllllllllllIllIIlIlIIlIIlIlllI.key = Object2IntOpenHashMap.this.key[lllllllllllllIllIIlIlIIlIIllIIIl];
                    lllllllllllllIllIIlIlIIlIIlIlllI.value = Object2IntOpenHashMap.this.value[lllllllllllllIllIIlIlIIlIIllIIIl];
                    lllllllllllllIllIIlIlIIlIIlIllII.accept(lllllllllllllIllIIlIlIIlIIlIlllI);
                }
            }
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIllIIlIlIIlIllIlIll) {
            if (!(lllllllllllllIllIIlIlIIlIllIlIll instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIllIIlIlIIlIllIlIlI = (Map.Entry<?, ?>)lllllllllllllIllIIlIlIIlIllIlIll;
            if (lllllllllllllIllIIlIlIIlIllIlIlI.getValue() == null || !(lllllllllllllIllIIlIlIIlIllIlIlI.getValue() instanceof Integer)) {
                return false;
            }
            final K lllllllllllllIllIIlIlIIlIllIlIIl = (K)lllllllllllllIllIIlIlIIlIllIlIlI.getKey();
            final int lllllllllllllIllIIlIlIIlIllIlIII = (int)lllllllllllllIllIIlIlIIlIllIlIlI.getValue();
            if (lllllllllllllIllIIlIlIIlIllIlIIl == null) {
                return Object2IntOpenHashMap.this.containsNullKey && Object2IntOpenHashMap.this.value[Object2IntOpenHashMap.this.n] == lllllllllllllIllIIlIlIIlIllIlIII;
            }
            final K[] lllllllllllllIllIIlIlIIlIllIIllI = Object2IntOpenHashMap.this.key;
            int lllllllllllllIllIIlIlIIlIllIIlIl;
            K lllllllllllllIllIIlIlIIlIllIIlll;
            if ((lllllllllllllIllIIlIlIIlIllIIlll = lllllllllllllIllIIlIlIIlIllIIllI[lllllllllllllIllIIlIlIIlIllIIlIl = (HashCommon.mix(lllllllllllllIllIIlIlIIlIllIlIIl.hashCode()) & Object2IntOpenHashMap.this.mask)]) == null) {
                return false;
            }
            if (lllllllllllllIllIIlIlIIlIllIlIIl.equals(lllllllllllllIllIIlIlIIlIllIIlll)) {
                return Object2IntOpenHashMap.this.value[lllllllllllllIllIIlIlIIlIllIIlIl] == lllllllllllllIllIIlIlIIlIllIlIII;
            }
            while ((lllllllllllllIllIIlIlIIlIllIIlll = lllllllllllllIllIIlIlIIlIllIIllI[lllllllllllllIllIIlIlIIlIllIIlIl = (lllllllllllllIllIIlIlIIlIllIIlIl + 1 & Object2IntOpenHashMap.this.mask)]) != null) {
                if (lllllllllllllIllIIlIlIIlIllIlIIl.equals(lllllllllllllIllIIlIlIIlIllIIlll)) {
                    return Object2IntOpenHashMap.this.value[lllllllllllllIllIIlIlIIlIllIIlIl] == lllllllllllllIllIIlIlIIlIllIlIII;
                }
            }
            return false;
        }
        
        @Override
        public int size() {
            return Object2IntOpenHashMap.this.size;
        }
        
        @Override
        public void forEach(final Consumer<? super Object2IntMap.Entry<K>> lllllllllllllIllIIlIlIIlIIlllIIl) {
            if (Object2IntOpenHashMap.this.containsNullKey) {
                lllllllllllllIllIIlIlIIlIIlllIIl.accept((Object)new BasicEntry((K)Object2IntOpenHashMap.this.key[Object2IntOpenHashMap.this.n], Object2IntOpenHashMap.this.value[Object2IntOpenHashMap.this.n]));
            }
            int lllllllllllllIllIIlIlIIlIIlllIll = Object2IntOpenHashMap.this.n;
            while (lllllllllllllIllIIlIlIIlIIlllIll-- != 0) {
                if (Object2IntOpenHashMap.this.key[lllllllllllllIllIIlIlIIlIIlllIll] != null) {
                    lllllllllllllIllIIlIlIIlIIlllIIl.accept((Object)new BasicEntry((K)Object2IntOpenHashMap.this.key[lllllllllllllIllIIlIlIIlIIlllIll], Object2IntOpenHashMap.this.value[lllllllllllllIllIIlIlIIlIIlllIll]));
                }
            }
        }
        
        @Override
        public ObjectIterator<Object2IntMap.Entry<K>> fastIterator() {
            return new FastEntryIterator();
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIllIIlIlIIlIlIlIIll) {
            if (!(lllllllllllllIllIIlIlIIlIlIlIIll instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIllIIlIlIIlIlIlIIlI = (Map.Entry<?, ?>)lllllllllllllIllIIlIlIIlIlIlIIll;
            if (lllllllllllllIllIIlIlIIlIlIlIIlI.getValue() == null || !(lllllllllllllIllIIlIlIIlIlIlIIlI.getValue() instanceof Integer)) {
                return false;
            }
            final K lllllllllllllIllIIlIlIIlIlIlIIIl = (K)lllllllllllllIllIIlIlIIlIlIlIIlI.getKey();
            final int lllllllllllllIllIIlIlIIlIlIlIIII = (int)lllllllllllllIllIIlIlIIlIlIlIIlI.getValue();
            if (lllllllllllllIllIIlIlIIlIlIlIIIl == null) {
                if (Object2IntOpenHashMap.this.containsNullKey && Object2IntOpenHashMap.this.value[Object2IntOpenHashMap.this.n] == lllllllllllllIllIIlIlIIlIlIlIIII) {
                    Object2IntOpenHashMap.this.removeNullEntry();
                    return true;
                }
                return false;
            }
            else {
                final K[] lllllllllllllIllIIlIlIIlIlIIlllI = Object2IntOpenHashMap.this.key;
                int lllllllllllllIllIIlIlIIlIlIIllIl;
                K lllllllllllllIllIIlIlIIlIlIIllll;
                if ((lllllllllllllIllIIlIlIIlIlIIllll = lllllllllllllIllIIlIlIIlIlIIlllI[lllllllllllllIllIIlIlIIlIlIIllIl = (HashCommon.mix(lllllllllllllIllIIlIlIIlIlIlIIIl.hashCode()) & Object2IntOpenHashMap.this.mask)]) == null) {
                    return false;
                }
                if (!lllllllllllllIllIIlIlIIlIlIIllll.equals(lllllllllllllIllIIlIlIIlIlIlIIIl)) {
                    while ((lllllllllllllIllIIlIlIIlIlIIllll = lllllllllllllIllIIlIlIIlIlIIlllI[lllllllllllllIllIIlIlIIlIlIIllIl = (lllllllllllllIllIIlIlIIlIlIIllIl + 1 & Object2IntOpenHashMap.this.mask)]) != null) {
                        if (lllllllllllllIllIIlIlIIlIlIIllll.equals(lllllllllllllIllIIlIlIIlIlIlIIIl) && Object2IntOpenHashMap.this.value[lllllllllllllIllIIlIlIIlIlIIllIl] == lllllllllllllIllIIlIlIIlIlIlIIII) {
                            Object2IntOpenHashMap.this.removeEntry(lllllllllllllIllIIlIlIIlIlIIllIl);
                            return true;
                        }
                    }
                    return false;
                }
                if (Object2IntOpenHashMap.this.value[lllllllllllllIllIIlIlIIlIlIIllIl] == lllllllllllllIllIIlIlIIlIlIlIIII) {
                    Object2IntOpenHashMap.this.removeEntry(lllllllllllllIllIIlIlIIlIlIIllIl);
                    return true;
                }
                return false;
            }
        }
        
        @Override
        public void clear() {
            Object2IntOpenHashMap.this.clear();
        }
    }
}
