package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import java.util.function.*;

public class Int2IntOpenHashMap extends AbstractInt2IntMap implements Hash, Cloneable, Serializable
{
    protected transient /* synthetic */ int[] value;
    protected final transient /* synthetic */ int minN;
    protected transient /* synthetic */ int n;
    protected transient /* synthetic */ int mask;
    protected transient /* synthetic */ int[] key;
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ IntCollection values;
    protected transient /* synthetic */ Int2IntMap.FastEntrySet entries;
    protected transient /* synthetic */ boolean containsNullKey;
    protected transient /* synthetic */ IntSet keys;
    protected final /* synthetic */ float f;
    protected /* synthetic */ int size;
    
    private void writeObject(final ObjectOutputStream llllllllllllllIIIlllIIIlIllIIlll) throws IOException {
        final int[] llllllllllllllIIIlllIIIlIllIIlIl = this.key;
        final int[] llllllllllllllIIIlllIIIlIllIIIll = this.value;
        final MapIterator llllllllllllllIIIlllIIIlIllIIIlI = new MapIterator();
        llllllllllllllIIIlllIIIlIllIIlll.defaultWriteObject();
        int llllllllllllllIIIlllIIIlIllIlIll = this.size;
        while (llllllllllllllIIIlllIIIlIllIlIll-- != 0) {
            final int llllllllllllllIIIlllIIIlIllIlIlI = llllllllllllllIIIlllIIIlIllIIIlI.nextEntry();
            llllllllllllllIIIlllIIIlIllIIlll.writeInt(llllllllllllllIIIlllIIIlIllIIlIl[llllllllllllllIIIlllIIIlIllIlIlI]);
            llllllllllllllIIIlllIIIlIllIIlll.writeInt(llllllllllllllIIIlllIIIlIllIIIll[llllllllllllllIIIlllIIIlIllIlIlI]);
        }
    }
    
    public Int2IntOpenHashMap clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap;
        //     7: astore_1        /* llllllllllllllIIIlllIIIllIllIIll */
        //     8: goto            20
        //    11: astore_2        /* llllllllllllllIIIlllIIIllIllIIIl */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllllIIIlllIIIllIlIllIl */
        //    21: aconst_null    
        //    22: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap.keys:Lcom/viaversion/viaversion/libs/fastutil/ints/IntSet;
        //    25: aload_1         /* llllllllllllllIIIlllIIIllIlIllIl */
        //    26: aconst_null    
        //    27: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap.values:Lcom/viaversion/viaversion/libs/fastutil/ints/IntCollection;
        //    30: aload_1         /* llllllllllllllIIIlllIIIllIlIllIl */
        //    31: aconst_null    
        //    32: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap.entries:Lcom/viaversion/viaversion/libs/fastutil/ints/Int2IntMap$FastEntrySet;
        //    35: aload_1         /* llllllllllllllIIIlllIIIllIlIllIl */
        //    36: aload_0         /* llllllllllllllIIIlllIIIllIlIlIll */
        //    37: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap.containsNullKey:Z
        //    40: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap.containsNullKey:Z
        //    43: aload_1         /* llllllllllllllIIIlllIIIllIlIllIl */
        //    44: aload_0         /* llllllllllllllIIIlllIIIllIlIlIll */
        //    45: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap.key:[I
        //    48: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    51: checkcast       [I
        //    54: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap.key:[I
        //    57: aload_1         /* llllllllllllllIIIlllIIIllIlIllIl */
        //    58: aload_0         /* llllllllllllllIIIlllIIIllIlIlIll */
        //    59: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap.value:[I
        //    62: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    65: checkcast       [I
        //    68: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntOpenHashMap.value:[I
        //    71: aload_1         /* llllllllllllllIIIlllIIIllIlIllIl */
        //    72: areturn        
        //    StackMapTable: 00 02 4B 07 00 76 FC 00 08 07 00 02
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
    public IntSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    @Override
    public int putIfAbsent(final int llllllllllllllIIIlllIIlIlIIlIlIl, final int llllllllllllllIIIlllIIlIlIIllIII) {
        final int llllllllllllllIIIlllIIlIlIIlIlll = this.find(llllllllllllllIIIlllIIlIlIIlIlIl);
        if (llllllllllllllIIIlllIIlIlIIlIlll >= 0) {
            return this.value[llllllllllllllIIIlllIIlIlIIlIlll];
        }
        this.insert(-llllllllllllllIIIlllIIlIlIIlIlll - 1, llllllllllllllIIIlllIIlIlIIlIlIl, llllllllllllllIIIlllIIlIlIIllIII);
        return this.defRetValue;
    }
    
    @Override
    public boolean containsKey(final int llllllllllllllIIIlllIIlIllIIlIII) {
        if (llllllllllllllIIIlllIIlIllIIlIII == 0) {
            return this.containsNullKey;
        }
        final int[] llllllllllllllIIIlllIIlIllIIIllI = this.key;
        int llllllllllllllIIIlllIIlIllIIIlIl;
        int llllllllllllllIIIlllIIlIllIIIlll;
        if ((llllllllllllllIIIlllIIlIllIIIlll = llllllllllllllIIIlllIIlIllIIIllI[llllllllllllllIIIlllIIlIllIIIlIl = (HashCommon.mix(llllllllllllllIIIlllIIlIllIIlIII) & this.mask)]) == 0) {
            return false;
        }
        if (llllllllllllllIIIlllIIlIllIIlIII == llllllllllllllIIIlllIIlIllIIIlll) {
            return true;
        }
        while ((llllllllllllllIIIlllIIlIllIIIlll = llllllllllllllIIIlllIIlIllIIIllI[llllllllllllllIIIlllIIlIllIIIlIl = (llllllllllllllIIIlllIIlIllIIIlIl + 1 & this.mask)]) != 0) {
            if (llllllllllllllIIIlllIIlIllIIlIII == llllllllllllllIIIlllIIlIllIIIlll) {
                return true;
            }
        }
        return false;
    }
    
    private void insert(final int llllllllllllllIIIlllIIllIlIlIIIl, final int llllllllllllllIIIlllIIllIlIlIIII, final int llllllllllllllIIIlllIIllIlIIllll) {
        if (llllllllllllllIIIlllIIllIlIlIIIl == this.n) {
            this.containsNullKey = true;
        }
        this.key[llllllllllllllIIIlllIIllIlIlIIIl] = llllllllllllllIIIlllIIllIlIlIIII;
        this.value[llllllllllllllIIIlllIIllIlIlIIIl] = llllllllllllllIIIlllIIllIlIIllll;
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
    }
    
    @Override
    public int replace(final int llllllllllllllIIIlllIIlIIllIIllI, final int llllllllllllllIIIlllIIlIIllIIlIl) {
        final int llllllllllllllIIIlllIIlIIllIlIIl = this.find(llllllllllllllIIIlllIIlIIllIIllI);
        if (llllllllllllllIIIlllIIlIIllIlIIl < 0) {
            return this.defRetValue;
        }
        final int llllllllllllllIIIlllIIlIIllIlIII = this.value[llllllllllllllIIIlllIIlIIllIlIIl];
        this.value[llllllllllllllIIIlllIIlIIllIlIIl] = llllllllllllllIIIlllIIlIIllIIlIl;
        return llllllllllllllIIIlllIIlIIllIlIII;
    }
    
    public Int2IntOpenHashMap(final Int2IntMap llllllllllllllIIIlllIIlllIllIllI, final float llllllllllllllIIIlllIIlllIllIlIl) {
        this(llllllllllllllIIIlllIIlllIllIllI.size(), llllllllllllllIIIlllIIlllIllIlIl);
        this.putAll(llllllllllllllIIIlllIIlllIllIllI);
    }
    
    private int find(final int llllllllllllllIIIlllIIllIllIIIll) {
        if (llllllllllllllIIIlllIIllIllIIIll == 0) {
            return this.containsNullKey ? this.n : (-(this.n + 1));
        }
        final int[] llllllllllllllIIIlllIIllIllIIIIl = this.key;
        int llllllllllllllIIIlllIIllIllIIIII;
        int llllllllllllllIIIlllIIllIllIIIlI;
        if ((llllllllllllllIIIlllIIllIllIIIlI = llllllllllllllIIIlllIIllIllIIIIl[llllllllllllllIIIlllIIllIllIIIII = (HashCommon.mix(llllllllllllllIIIlllIIllIllIIIll) & this.mask)]) == 0) {
            return -(llllllllllllllIIIlllIIllIllIIIII + 1);
        }
        if (llllllllllllllIIIlllIIllIllIIIll == llllllllllllllIIIlllIIllIllIIIlI) {
            return llllllllllllllIIIlllIIllIllIIIII;
        }
        while ((llllllllllllllIIIlllIIllIllIIIlI = llllllllllllllIIIlllIIllIllIIIIl[llllllllllllllIIIlllIIllIllIIIII = (llllllllllllllIIIlllIIllIllIIIII + 1 & this.mask)]) != 0) {
            if (llllllllllllllIIIlllIIllIllIIIll == llllllllllllllIIIlllIIllIllIIIlI) {
                return llllllllllllllIIIlllIIllIllIIIII;
            }
        }
        return -(llllllllllllllIIIlllIIllIllIIIII + 1);
    }
    
    public Int2IntOpenHashMap(final Map<? extends Integer, ? extends Integer> llllllllllllllIIIlllIIllllIIIlIl, final float llllllllllllllIIIlllIIllllIIIlII) {
        this(llllllllllllllIIIlllIIllllIIIlIl.size(), llllllllllllllIIIlllIIllllIIIlII);
        this.putAll(llllllllllllllIIIlllIIllllIIIlIl);
    }
    
    protected final void shiftKeys(int llllllllllllllIIIlllIIlIlllllIIl) {
        final int[] llllllllllllllIIIlllIIlIllllllII = this.key;
        int llllllllllllllIIIlllIIllIIIIIIII = 0;
    Label_0006:
        while (true) {
            llllllllllllllIIIlllIIlIlllllIIl = ((llllllllllllllIIIlllIIllIIIIIIII = llllllllllllllIIIlllIIlIlllllIIl) + 1 & this.mask);
            int llllllllllllllIIIlllIIlIlllllllI;
            while ((llllllllllllllIIIlllIIlIlllllllI = llllllllllllllIIIlllIIlIllllllII[llllllllllllllIIIlllIIlIlllllIIl]) != 0) {
                final int llllllllllllllIIIlllIIlIllllllll = HashCommon.mix(llllllllllllllIIIlllIIlIlllllllI) & this.mask;
                Label_0087: {
                    if (llllllllllllllIIIlllIIllIIIIIIII <= llllllllllllllIIIlllIIlIlllllIIl) {
                        if (llllllllllllllIIIlllIIllIIIIIIII >= llllllllllllllIIIlllIIlIllllllll) {
                            break Label_0087;
                        }
                        if (llllllllllllllIIIlllIIlIllllllll > llllllllllllllIIIlllIIlIlllllIIl) {
                            break Label_0087;
                        }
                    }
                    else if (llllllllllllllIIIlllIIllIIIIIIII >= llllllllllllllIIIlllIIlIllllllll && llllllllllllllIIIlllIIlIllllllll > llllllllllllllIIIlllIIlIlllllIIl) {
                        break Label_0087;
                    }
                    llllllllllllllIIIlllIIlIlllllIIl = (llllllllllllllIIIlllIIlIlllllIIl + 1 & this.mask);
                    continue;
                }
                llllllllllllllIIIlllIIlIllllllII[llllllllllllllIIIlllIIllIIIIIIII] = llllllllllllllIIIlllIIlIlllllllI;
                this.value[llllllllllllllIIIlllIIllIIIIIIII] = this.value[llllllllllllllIIIlllIIlIlllllIIl];
                continue Label_0006;
            }
            break;
        }
        llllllllllllllIIIlllIIlIllllllII[llllllllllllllIIIlllIIllIIIIIIII] = 0;
    }
    
    public Int2IntOpenHashMap(final int llllllllllllllIIIlllIIllllIlIlII, final float llllllllllllllIIIlllIIllllIlIllI) {
        if (llllllllllllllIIIlllIIllllIlIllI <= 0.0f || llllllllllllllIIIlllIIllllIlIllI > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (llllllllllllllIIIlllIIllllIlIlII < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = llllllllllllllIIIlllIIllllIlIllI;
        final int arraySize = HashCommon.arraySize(llllllllllllllIIIlllIIllllIlIlII, llllllllllllllIIIlllIIllllIlIllI);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, llllllllllllllIIIlllIIllllIlIllI);
        this.key = new int[this.n + 1];
        this.value = new int[this.n + 1];
    }
    
    @Override
    public int computeIfPresent(final int llllllllllllllIIIlllIIlIIIlllIll, final BiFunction<? super Integer, ? super Integer, ? extends Integer> llllllllllllllIIIlllIIlIIIllIlIl) {
        Objects.requireNonNull(llllllllllllllIIIlllIIlIIIllIlIl);
        final int llllllllllllllIIIlllIIlIIIlllIIl = this.find(llllllllllllllIIIlllIIlIIIlllIll);
        if (llllllllllllllIIIlllIIlIIIlllIIl < 0) {
            return this.defRetValue;
        }
        final Integer llllllllllllllIIIlllIIlIIIlllIII = (Integer)llllllllllllllIIIlllIIlIIIllIlIl.apply(llllllllllllllIIIlllIIlIIIlllIll, this.value[llllllllllllllIIIlllIIlIIIlllIIl]);
        if (llllllllllllllIIIlllIIlIIIlllIII == null) {
            if (llllllllllllllIIIlllIIlIIIlllIll == 0) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(llllllllllllllIIIlllIIlIIIlllIIl);
            }
            return this.defRetValue;
        }
        return this.value[llllllllllllllIIIlllIIlIIIlllIIl] = llllllllllllllIIIlllIIlIIIlllIII;
    }
    
    @Override
    public int merge(final int llllllllllllllIIIlllIIlIIIIllIIl, final int llllllllllllllIIIlllIIlIIIIllIII, final BiFunction<? super Integer, ? super Integer, ? extends Integer> llllllllllllllIIIlllIIlIIIIlIIIl) {
        Objects.requireNonNull(llllllllllllllIIIlllIIlIIIIlIIIl);
        final int llllllllllllllIIIlllIIlIIIIlIllI = this.find(llllllllllllllIIIlllIIlIIIIllIIl);
        if (llllllllllllllIIIlllIIlIIIIlIllI < 0) {
            this.insert(-llllllllllllllIIIlllIIlIIIIlIllI - 1, llllllllllllllIIIlllIIlIIIIllIIl, llllllllllllllIIIlllIIlIIIIllIII);
            return llllllllllllllIIIlllIIlIIIIllIII;
        }
        final Integer llllllllllllllIIIlllIIlIIIIlIlIl = (Integer)llllllllllllllIIIlllIIlIIIIlIIIl.apply(this.value[llllllllllllllIIIlllIIlIIIIlIllI], llllllllllllllIIIlllIIlIIIIllIII);
        if (llllllllllllllIIIlllIIlIIIIlIlIl == null) {
            if (llllllllllllllIIIlllIIlIIIIllIIl == 0) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(llllllllllllllIIIlllIIlIIIIlIllI);
            }
            return this.defRetValue;
        }
        return this.value[llllllllllllllIIIlllIIlIIIIlIllI] = llllllllllllllIIIlllIIlIIIIlIlIl;
    }
    
    private int removeNullEntry() {
        this.containsNullKey = false;
        final int llllllllllllllIIIlllIIllIlllIIlI = this.value[this.n];
        --this.size;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIIIlllIIllIlllIIlI;
    }
    
    public Int2IntOpenHashMap() {
        this(16, 0.75f);
    }
    
    public int addTo(final int llllllllllllllIIIlllIIllIIIlllll, final int llllllllllllllIIIlllIIllIIlIIIll) {
        int llllllllllllllIIIlllIIllIIlIIIIl = 0;
        if (llllllllllllllIIIlllIIllIIIlllll == 0) {
            if (this.containsNullKey) {
                return this.addToValue(this.n, llllllllllllllIIIlllIIllIIlIIIll);
            }
            final int llllllllllllllIIIlllIIllIIlIlIlI = this.n;
            this.containsNullKey = true;
        }
        else {
            final int[] llllllllllllllIIIlllIIllIIlIlIII = this.key;
            int llllllllllllllIIIlllIIllIIlIlIIl;
            if ((llllllllllllllIIIlllIIllIIlIlIIl = llllllllllllllIIIlllIIllIIlIlIII[llllllllllllllIIIlllIIllIIlIIIIl = (HashCommon.mix(llllllllllllllIIIlllIIllIIIlllll) & this.mask)]) != 0) {
                if (llllllllllllllIIIlllIIllIIlIlIIl == llllllllllllllIIIlllIIllIIIlllll) {
                    return this.addToValue(llllllllllllllIIIlllIIllIIlIIIIl, llllllllllllllIIIlllIIllIIlIIIll);
                }
                while ((llllllllllllllIIIlllIIllIIlIlIIl = llllllllllllllIIIlllIIllIIlIlIII[llllllllllllllIIIlllIIllIIlIIIIl = (llllllllllllllIIIlllIIllIIlIIIIl + 1 & this.mask)]) != 0) {
                    if (llllllllllllllIIIlllIIllIIlIlIIl == llllllllllllllIIIlllIIllIIIlllll) {
                        return this.addToValue(llllllllllllllIIIlllIIllIIlIIIIl, llllllllllllllIIIlllIIllIIlIIIll);
                    }
                }
            }
        }
        this.key[llllllllllllllIIIlllIIllIIlIIIIl] = llllllllllllllIIIlllIIllIIIlllll;
        this.value[llllllllllllllIIIlllIIllIIlIIIIl] = this.defRetValue + llllllllllllllIIIlllIIllIIlIIIll;
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return this.defRetValue;
    }
    
    @Override
    public int computeIfAbsentNullable(final int llllllllllllllIIIlllIIlIIlIIIllI, final IntFunction<? extends Integer> llllllllllllllIIIlllIIlIIlIIIlIl) {
        Objects.requireNonNull(llllllllllllllIIIlllIIlIIlIIIlIl);
        final int llllllllllllllIIIlllIIlIIlIIlIlI = this.find(llllllllllllllIIIlllIIlIIlIIIllI);
        if (llllllllllllllIIIlllIIlIIlIIlIlI >= 0) {
            return this.value[llllllllllllllIIIlllIIlIIlIIlIlI];
        }
        final Integer llllllllllllllIIIlllIIlIIlIIlIIl = (Integer)llllllllllllllIIIlllIIlIIlIIIlIl.apply(llllllllllllllIIIlllIIlIIlIIIllI);
        if (llllllllllllllIIIlllIIlIIlIIlIIl == null) {
            return this.defRetValue;
        }
        final int llllllllllllllIIIlllIIlIIlIIlIII = llllllllllllllIIIlllIIlIIlIIlIIl;
        this.insert(-llllllllllllllIIIlllIIlIIlIIlIlI - 1, llllllllllllllIIIlllIIlIIlIIIllI, llllllllllllllIIIlllIIlIIlIIlIII);
        return llllllllllllllIIIlllIIlIIlIIlIII;
    }
    
    static {
        ASSERTS = false;
    }
    
    @Override
    public boolean remove(final int llllllllllllllIIIlllIIlIlIIIIlIl, final int llllllllllllllIIIlllIIlIlIIIIlII) {
        if (llllllllllllllIIIlllIIlIlIIIIlIl == 0) {
            if (this.containsNullKey && llllllllllllllIIIlllIIlIlIIIIlII == this.value[this.n]) {
                this.removeNullEntry();
                return true;
            }
            return false;
        }
        else {
            final int[] llllllllllllllIIIlllIIlIlIIIlIII = this.key;
            int llllllllllllllIIIlllIIlIlIIIIlll;
            int llllllllllllllIIIlllIIlIlIIIlIIl;
            if ((llllllllllllllIIIlllIIlIlIIIlIIl = llllllllllllllIIIlllIIlIlIIIlIII[llllllllllllllIIIlllIIlIlIIIIlll = (HashCommon.mix(llllllllllllllIIIlllIIlIlIIIIlIl) & this.mask)]) == 0) {
                return false;
            }
            if (llllllllllllllIIIlllIIlIlIIIIlIl == llllllllllllllIIIlllIIlIlIIIlIIl && llllllllllllllIIIlllIIlIlIIIIlII == this.value[llllllllllllllIIIlllIIlIlIIIIlll]) {
                this.removeEntry(llllllllllllllIIIlllIIlIlIIIIlll);
                return true;
            }
            while ((llllllllllllllIIIlllIIlIlIIIlIIl = llllllllllllllIIIlllIIlIlIIIlIII[llllllllllllllIIIlllIIlIlIIIIlll = (llllllllllllllIIIlllIIlIlIIIIlll + 1 & this.mask)]) != 0) {
                if (llllllllllllllIIIlllIIlIlIIIIlIl == llllllllllllllIIIlllIIlIlIIIlIIl && llllllllllllllIIIlllIIlIlIIIIlII == this.value[llllllllllllllIIIlllIIlIlIIIIlll]) {
                    this.removeEntry(llllllllllllllIIIlllIIlIlIIIIlll);
                    return true;
                }
            }
            return false;
        }
    }
    
    private int addToValue(final int llllllllllllllIIIlllIIllIIllIllI, final int llllllllllllllIIIlllIIllIIllIlIl) {
        final int llllllllllllllIIIlllIIllIIlllIII = this.value[llllllllllllllIIIlllIIllIIllIllI];
        this.value[llllllllllllllIIIlllIIllIIllIllI] = llllllllllllllIIIlllIIllIIlllIII + llllllllllllllIIIlllIIllIIllIlIl;
        return llllllllllllllIIIlllIIllIIlllIII;
    }
    
    private void tryCapacity(final long llllllllllllllIIIlllIIlllIIIIIll) {
        final int llllllllllllllIIIlllIIlllIIIIIlI = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(llllllllllllllIIIlllIIlllIIIIIll / this.f))));
        if (llllllllllllllIIIlllIIlllIIIIIlI > this.n) {
            this.rehash(llllllllllllllIIIlllIIlllIIIIIlI);
        }
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIIIlllIIIllIIIIlIl = 0;
        int llllllllllllllIIIlllIIIllIIIlIll = this.realSize();
        int llllllllllllllIIIlllIIIllIIIlIlI = 0;
        int llllllllllllllIIIlllIIIllIIIlIIl = 0;
        while (llllllllllllllIIIlllIIIllIIIlIll-- != 0) {
            while (this.key[llllllllllllllIIIlllIIIllIIIlIlI] == 0) {
                ++llllllllllllllIIIlllIIIllIIIlIlI;
            }
            llllllllllllllIIIlllIIIllIIIlIIl = this.key[llllllllllllllIIIlllIIIllIIIlIlI];
            llllllllllllllIIIlllIIIllIIIlIIl ^= this.value[llllllllllllllIIIlllIIIllIIIlIlI];
            llllllllllllllIIIlllIIIllIIIIlIl += llllllllllllllIIIlllIIIllIIIlIIl;
            ++llllllllllllllIIIlllIIIllIIIlIlI;
        }
        if (this.containsNullKey) {
            llllllllllllllIIIlllIIIllIIIIlIl += this.value[this.n];
        }
        return llllllllllllllIIIlllIIIllIIIIlIl;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    public Int2IntOpenHashMap(final int[] llllllllllllllIIIlllIIlllIlIIIII, final int[] llllllllllllllIIIlllIIlllIlIIIll, final float llllllllllllllIIIlllIIlllIlIIIlI) {
        this(llllllllllllllIIIlllIIlllIlIIIII.length, llllllllllllllIIIlllIIlllIlIIIlI);
        if (llllllllllllllIIIlllIIlllIlIIIII.length != llllllllllllllIIIlllIIlllIlIIIll.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The key array and the value array have different lengths (").append(llllllllllllllIIIlllIIlllIlIIIII.length).append(" and ").append(llllllllllllllIIIlllIIlllIlIIIll.length).append(")")));
        }
        for (int llllllllllllllIIIlllIIlllIlIIllI = 0; llllllllllllllIIIlllIIlllIlIIllI < llllllllllllllIIIlllIIlllIlIIIII.length; ++llllllllllllllIIIlllIIlllIlIIllI) {
            this.put(llllllllllllllIIIlllIIlllIlIIIII[llllllllllllllIIIlllIIlllIlIIllI], llllllllllllllIIIlllIIlllIlIIIll[llllllllllllllIIIlllIIlllIlIIllI]);
        }
    }
    
    private int removeEntry(final int llllllllllllllIIIlllIIllIllllIlI) {
        final int llllllllllllllIIIlllIIllIllllIIl = this.value[llllllllllllllIIIlllIIllIllllIlI];
        --this.size;
        this.shiftKeys(llllllllllllllIIIlllIIllIllllIlI);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIIIlllIIllIllllIIl;
    }
    
    @Override
    public Int2IntMap.FastEntrySet int2IntEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }
    
    private void checkTable() {
    }
    
    public boolean trim(final int llllllllllllllIIIlllIIIlllllIIll) {
        final int llllllllllllllIIIlllIIIlllllIIlI = HashCommon.nextPowerOfTwo((int)Math.ceil(llllllllllllllIIIlllIIIlllllIIll / this.f));
        if (llllllllllllllIIIlllIIIlllllIIlI >= this.n || this.size > HashCommon.maxFill(llllllllllllllIIIlllIIIlllllIIlI, this.f)) {
            return true;
        }
        try {
            this.rehash(llllllllllllllIIIlllIIIlllllIIlI);
        }
        catch (OutOfMemoryError llllllllllllllIIIlllIIIlllllIlIl) {
            return false;
        }
        return true;
    }
    
    public Int2IntOpenHashMap(final Int2IntMap llllllllllllllIIIlllIIlllIlIllII) {
        this(llllllllllllllIIIlllIIlllIlIllII, 0.75f);
    }
    
    @Override
    public int get(final int llllllllllllllIIIlllIIlIllIlIIlI) {
        if (llllllllllllllIIIlllIIlIllIlIIlI == 0) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        }
        final int[] llllllllllllllIIIlllIIlIllIlIlIl = this.key;
        int llllllllllllllIIIlllIIlIllIlIlII;
        int llllllllllllllIIIlllIIlIllIlIllI;
        if ((llllllllllllllIIIlllIIlIllIlIllI = llllllllllllllIIIlllIIlIllIlIlIl[llllllllllllllIIIlllIIlIllIlIlII = (HashCommon.mix(llllllllllllllIIIlllIIlIllIlIIlI) & this.mask)]) == 0) {
            return this.defRetValue;
        }
        if (llllllllllllllIIIlllIIlIllIlIIlI == llllllllllllllIIIlllIIlIllIlIllI) {
            return this.value[llllllllllllllIIIlllIIlIllIlIlII];
        }
        while ((llllllllllllllIIIlllIIlIllIlIllI = llllllllllllllIIIlllIIlIllIlIlIl[llllllllllllllIIIlllIIlIllIlIlII = (llllllllllllllIIIlllIIlIllIlIlII + 1 & this.mask)]) != 0) {
            if (llllllllllllllIIIlllIIlIllIlIIlI == llllllllllllllIIIlllIIlIllIlIllI) {
                return this.value[llllllllllllllIIIlllIIlIllIlIlII];
            }
        }
        return this.defRetValue;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    protected void rehash(final int llllllllllllllIIIlllIIIlllIlllII) {
        final int[] llllllllllllllIIIlllIIIlllIllIlI = this.key;
        final int[] llllllllllllllIIIlllIIIlllIllIIl = this.value;
        final int llllllllllllllIIIlllIIIlllIlIlll = llllllllllllllIIIlllIIIlllIlllII - 1;
        final int[] llllllllllllllIIIlllIIIlllIlIlIl = new int[llllllllllllllIIIlllIIIlllIlllII + 1];
        final int[] llllllllllllllIIIlllIIIlllIlIIll = new int[llllllllllllllIIIlllIIIlllIlllII + 1];
        int llllllllllllllIIIlllIIIlllIlIIlI = this.n;
        int llllllllllllllIIIlllIIIlllIlllll = this.realSize();
        while (llllllllllllllIIIlllIIIlllIlllll-- != 0) {
            while (llllllllllllllIIIlllIIIlllIllIlI[--llllllllllllllIIIlllIIIlllIlIIlI] == 0) {}
            int llllllllllllllIIIlllIIIllllIIIII;
            if (llllllllllllllIIIlllIIIlllIlIlIl[llllllllllllllIIIlllIIIllllIIIII = (HashCommon.mix(llllllllllllllIIIlllIIIlllIllIlI[llllllllllllllIIIlllIIIlllIlIIlI]) & llllllllllllllIIIlllIIIlllIlIlll)] != 0) {
                while (llllllllllllllIIIlllIIIlllIlIlIl[llllllllllllllIIIlllIIIllllIIIII = (llllllllllllllIIIlllIIIllllIIIII + 1 & llllllllllllllIIIlllIIIlllIlIlll)] != 0) {}
            }
            llllllllllllllIIIlllIIIlllIlIlIl[llllllllllllllIIIlllIIIllllIIIII] = llllllllllllllIIIlllIIIlllIllIlI[llllllllllllllIIIlllIIIlllIlIIlI];
            llllllllllllllIIIlllIIIlllIlIIll[llllllllllllllIIIlllIIIllllIIIII] = llllllllllllllIIIlllIIIlllIllIIl[llllllllllllllIIIlllIIIlllIlIIlI];
        }
        llllllllllllllIIIlllIIIlllIlIIll[llllllllllllllIIIlllIIIlllIlllII] = llllllllllllllIIIlllIIIlllIllIIl[this.n];
        this.n = llllllllllllllIIIlllIIIlllIlllII;
        this.mask = llllllllllllllIIIlllIIIlllIlIlll;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = llllllllllllllIIIlllIIIlllIlIlIl;
        this.value = llllllllllllllIIIlllIIIlllIlIIll;
    }
    
    @Override
    public boolean containsValue(final int llllllllllllllIIIlllIIlIlIlllIII) {
        final int[] llllllllllllllIIIlllIIlIlIllIlll = this.value;
        final int[] llllllllllllllIIIlllIIlIlIllIllI = this.key;
        if (this.containsNullKey && llllllllllllllIIIlllIIlIlIllIlll[this.n] == llllllllllllllIIIlllIIlIlIlllIII) {
            return true;
        }
        int llllllllllllllIIIlllIIlIlIlllIlI = this.n;
        while (llllllllllllllIIIlllIIlIlIlllIlI-- != 0) {
            if (llllllllllllllIIIlllIIlIlIllIllI[llllllllllllllIIIlllIIlIlIlllIlI] != 0 && llllllllllllllIIIlllIIlIlIllIlll[llllllllllllllIIIlllIIlIlIlllIlI] == llllllllllllllIIIlllIIlIlIlllIII) {
                return true;
            }
        }
        return false;
    }
    
    public Int2IntOpenHashMap(final int llllllllllllllIIIlllIIllllIIllll) {
        this(llllllllllllllIIIlllIIllllIIllll, 0.75f);
    }
    
    private void ensureCapacity(final int llllllllllllllIIIlllIIlllIIIlIIl) {
        final int llllllllllllllIIIlllIIlllIIIlIll = HashCommon.arraySize(llllllllllllllIIIlllIIlllIIIlIIl, this.f);
        if (llllllllllllllIIIlllIIlllIIIlIll > this.n) {
            this.rehash(llllllllllllllIIIlllIIlllIIIlIll);
        }
    }
    
    public Int2IntOpenHashMap(final Map<? extends Integer, ? extends Integer> llllllllllllllIIIlllIIlllIlllIll) {
        this(llllllllllllllIIIlllIIlllIlllIll, 0.75f);
    }
    
    @Override
    public IntCollection values() {
        if (this.values == null) {
            this.values = new AbstractIntCollection() {
                @Override
                public boolean contains(final int llllllllllllIlllllIIIllllIIlllll) {
                    return Int2IntOpenHashMap.this.containsValue(llllllllllllIlllllIIIllllIIlllll);
                }
                
                @Override
                public void forEach(final IntConsumer llllllllllllIlllllIIIllllIIlIllI) {
                    if (Int2IntOpenHashMap.this.containsNullKey) {
                        llllllllllllIlllllIIIllllIIlIllI.accept(Int2IntOpenHashMap.this.value[Int2IntOpenHashMap.this.n]);
                    }
                    int llllllllllllIlllllIIIllllIIllIII = Int2IntOpenHashMap.this.n;
                    while (llllllllllllIlllllIIIllllIIllIII-- != 0) {
                        if (Int2IntOpenHashMap.this.key[llllllllllllIlllllIIIllllIIllIII] != 0) {
                            llllllllllllIlllllIIIllllIIlIllI.accept(Int2IntOpenHashMap.this.value[llllllllllllIlllllIIIllllIIllIII]);
                        }
                    }
                }
                
                @Override
                public int size() {
                    return Int2IntOpenHashMap.this.size;
                }
                
                @Override
                public IntIterator iterator() {
                    return new ValueIterator();
                }
                
                @Override
                public void clear() {
                    Int2IntOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }
    
    @Override
    public boolean replace(final int llllllllllllllIIIlllIIlIIlllIlIl, final int llllllllllllllIIIlllIIlIIllllIIl, final int llllllllllllllIIIlllIIlIIllllIII) {
        final int llllllllllllllIIIlllIIlIIlllIlll = this.find(llllllllllllllIIIlllIIlIIlllIlIl);
        if (llllllllllllllIIIlllIIlIIlllIlll < 0 || llllllllllllllIIIlllIIlIIllllIIl != this.value[llllllllllllllIIIlllIIlIIlllIlll]) {
            return false;
        }
        this.value[llllllllllllllIIIlllIIlIIlllIlll] = llllllllllllllIIIlllIIlIIllllIII;
        return true;
    }
    
    private int realSize() {
        return this.containsNullKey ? (this.size - 1) : this.size;
    }
    
    @Override
    public int computeIfAbsent(final int llllllllllllllIIIlllIIlIIlIlllII, final IntUnaryOperator llllllllllllllIIIlllIIlIIlIlIllI) {
        Objects.requireNonNull(llllllllllllllIIIlllIIlIIlIlIllI);
        final int llllllllllllllIIIlllIIlIIlIllIlI = this.find(llllllllllllllIIIlllIIlIIlIlllII);
        if (llllllllllllllIIIlllIIlIIlIllIlI >= 0) {
            return this.value[llllllllllllllIIIlllIIlIIlIllIlI];
        }
        final int llllllllllllllIIIlllIIlIIlIllIIl = llllllllllllllIIIlllIIlIIlIlIllI.applyAsInt(llllllllllllllIIIlllIIlIIlIlllII);
        this.insert(-llllllllllllllIIIlllIIlIIlIllIlI - 1, llllllllllllllIIIlllIIlIIlIlllII, llllllllllllllIIIlllIIlIIlIllIIl);
        return llllllllllllllIIIlllIIlIIlIllIIl;
    }
    
    @Override
    public int compute(final int llllllllllllllIIIlllIIlIIIlIIlIl, final BiFunction<? super Integer, ? super Integer, ? extends Integer> llllllllllllllIIIlllIIlIIIlIlIlI) {
        Objects.requireNonNull(llllllllllllllIIIlllIIlIIIlIlIlI);
        final int llllllllllllllIIIlllIIlIIIlIlIIl = this.find(llllllllllllllIIIlllIIlIIIlIIlIl);
        final Integer llllllllllllllIIIlllIIlIIIlIlIII = (Integer)llllllllllllllIIIlllIIlIIIlIlIlI.apply(llllllllllllllIIIlllIIlIIIlIIlIl, (llllllllllllllIIIlllIIlIIIlIlIIl >= 0) ? Integer.valueOf(this.value[llllllllllllllIIIlllIIlIIIlIlIIl]) : null);
        if (llllllllllllllIIIlllIIlIIIlIlIII == null) {
            if (llllllllllllllIIIlllIIlIIIlIlIIl >= 0) {
                if (llllllllllllllIIIlllIIlIIIlIIlIl == 0) {
                    this.removeNullEntry();
                }
                else {
                    this.removeEntry(llllllllllllllIIIlllIIlIIIlIlIIl);
                }
            }
            return this.defRetValue;
        }
        final int llllllllllllllIIIlllIIlIIIlIIlll = llllllllllllllIIIlllIIlIIIlIlIII;
        if (llllllllllllllIIIlllIIlIIIlIlIIl < 0) {
            this.insert(-llllllllllllllIIIlllIIlIIIlIlIIl - 1, llllllllllllllIIIlllIIlIIIlIIlIl, llllllllllllllIIIlllIIlIIIlIIlll);
            return llllllllllllllIIIlllIIlIIIlIIlll;
        }
        return this.value[llllllllllllllIIIlllIIlIIIlIlIIl] = llllllllllllllIIIlllIIlIIIlIIlll;
    }
    
    public Int2IntOpenHashMap(final int[] llllllllllllllIIIlllIIlllIIllIII, final int[] llllllllllllllIIIlllIIlllIIlIlII) {
        this(llllllllllllllIIIlllIIlllIIllIII, llllllllllllllIIIlllIIlllIIlIlII, 0.75f);
    }
    
    @Override
    public int getOrDefault(final int llllllllllllllIIIlllIIlIlIlIIIll, final int llllllllllllllIIIlllIIlIlIlIIIlI) {
        if (llllllllllllllIIIlllIIlIlIlIIIll == 0) {
            return this.containsNullKey ? this.value[this.n] : llllllllllllllIIIlllIIlIlIlIIIlI;
        }
        final int[] llllllllllllllIIIlllIIlIlIlIIllI = this.key;
        int llllllllllllllIIIlllIIlIlIlIIlIl;
        int llllllllllllllIIIlllIIlIlIlIIlll;
        if ((llllllllllllllIIIlllIIlIlIlIIlll = llllllllllllllIIIlllIIlIlIlIIllI[llllllllllllllIIIlllIIlIlIlIIlIl = (HashCommon.mix(llllllllllllllIIIlllIIlIlIlIIIll) & this.mask)]) == 0) {
            return llllllllllllllIIIlllIIlIlIlIIIlI;
        }
        if (llllllllllllllIIIlllIIlIlIlIIIll == llllllllllllllIIIlllIIlIlIlIIlll) {
            return this.value[llllllllllllllIIIlllIIlIlIlIIlIl];
        }
        while ((llllllllllllllIIIlllIIlIlIlIIlll = llllllllllllllIIIlllIIlIlIlIIllI[llllllllllllllIIIlllIIlIlIlIIlIl = (llllllllllllllIIIlllIIlIlIlIIlIl + 1 & this.mask)]) != 0) {
            if (llllllllllllllIIIlllIIlIlIlIIIll == llllllllllllllIIIlllIIlIlIlIIlll) {
                return this.value[llllllllllllllIIIlllIIlIlIlIIlIl];
            }
        }
        return llllllllllllllIIIlllIIlIlIlIIIlI;
    }
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNullKey = false;
        Arrays.fill(this.key, 0);
    }
    
    @Override
    public int remove(final int llllllllllllllIIIlllIIlIlllIIIIl) {
        if (llllllllllllllIIIlllIIlIlllIIIIl == 0) {
            if (this.containsNullKey) {
                return this.removeNullEntry();
            }
            return this.defRetValue;
        }
        else {
            final int[] llllllllllllllIIIlllIIlIlllIIlII = this.key;
            int llllllllllllllIIIlllIIlIlllIIIll;
            int llllllllllllllIIIlllIIlIlllIIlIl;
            if ((llllllllllllllIIIlllIIlIlllIIlIl = llllllllllllllIIIlllIIlIlllIIlII[llllllllllllllIIIlllIIlIlllIIIll = (HashCommon.mix(llllllllllllllIIIlllIIlIlllIIIIl) & this.mask)]) == 0) {
                return this.defRetValue;
            }
            if (llllllllllllllIIIlllIIlIlllIIIIl == llllllllllllllIIIlllIIlIlllIIlIl) {
                return this.removeEntry(llllllllllllllIIIlllIIlIlllIIIll);
            }
            while ((llllllllllllllIIIlllIIlIlllIIlIl = llllllllllllllIIIlllIIlIlllIIlII[llllllllllllllIIIlllIIlIlllIIIll = (llllllllllllllIIIlllIIlIlllIIIll + 1 & this.mask)]) != 0) {
                if (llllllllllllllIIIlllIIlIlllIIIIl == llllllllllllllIIIlllIIlIlllIIlIl) {
                    return this.removeEntry(llllllllllllllIIIlllIIlIlllIIIll);
                }
            }
            return this.defRetValue;
        }
    }
    
    private void readObject(final ObjectInputStream llllllllllllllIIIlllIIIlIIllllll) throws ClassNotFoundException, IOException {
        llllllllllllllIIIlllIIIlIIllllll.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final int[] key = new int[this.n + 1];
        this.key = key;
        final int[] llllllllllllllIIIlllIIIlIlIIIIlI = key;
        final int[] value = new int[this.n + 1];
        this.value = value;
        final int[] llllllllllllllIIIlllIIIlIlIIIIIl = value;
        int llllllllllllllIIIlllIIIlIlIIIllI = this.size;
        while (llllllllllllllIIIlllIIIlIlIIIllI-- != 0) {
            final int llllllllllllllIIIlllIIIlIlIIlIII = llllllllllllllIIIlllIIIlIIllllll.readInt();
            final int llllllllllllllIIIlllIIIlIlIIIlll = llllllllllllllIIIlllIIIlIIllllll.readInt();
            int llllllllllllllIIIlllIIIlIlIIIlIl = 0;
            if (llllllllllllllIIIlllIIIlIlIIlIII == 0) {
                final int llllllllllllllIIIlllIIIlIlIIlIIl = this.n;
                this.containsNullKey = true;
            }
            else {
                for (llllllllllllllIIIlllIIIlIlIIIlIl = (HashCommon.mix(llllllllllllllIIIlllIIIlIlIIlIII) & this.mask); llllllllllllllIIIlllIIIlIlIIIIlI[llllllllllllllIIIlllIIIlIlIIIlIl] != 0; llllllllllllllIIIlllIIIlIlIIIlIl = (llllllllllllllIIIlllIIIlIlIIIlIl + 1 & this.mask)) {}
            }
            llllllllllllllIIIlllIIIlIlIIIIlI[llllllllllllllIIIlllIIIlIlIIIlIl] = llllllllllllllIIIlllIIIlIlIIlIII;
            llllllllllllllIIIlllIIIlIlIIIIIl[llllllllllllllIIIlllIIIlIlIIIlIl] = llllllllllllllIIIlllIIIlIlIIIlll;
        }
    }
    
    @Override
    public void putAll(final Map<? extends Integer, ? extends Integer> llllllllllllllIIIlllIIllIllIlIlI) {
        if (this.f <= 0.5) {
            this.ensureCapacity(llllllllllllllIIIlllIIllIllIlIlI.size());
        }
        else {
            this.tryCapacity(this.size() + llllllllllllllIIIlllIIllIllIlIlI.size());
        }
        super.putAll(llllllllllllllIIIlllIIllIllIlIlI);
    }
    
    @Override
    public int put(final int llllllllllllllIIIlllIIllIlIIlIII, final int llllllllllllllIIIlllIIllIlIIIIlI) {
        final int llllllllllllllIIIlllIIllIlIIIllI = this.find(llllllllllllllIIIlllIIllIlIIlIII);
        if (llllllllllllllIIIlllIIllIlIIIllI < 0) {
            this.insert(-llllllllllllllIIIlllIIllIlIIIllI - 1, llllllllllllllIIIlllIIllIlIIlIII, llllllllllllllIIIlllIIllIlIIIIlI);
            return this.defRetValue;
        }
        final int llllllllllllllIIIlllIIllIlIIIlIl = this.value[llllllllllllllIIIlllIIllIlIIIllI];
        this.value[llllllllllllllIIIlllIIllIlIIIllI] = llllllllllllllIIIlllIIllIlIIIIlI;
        return llllllllllllllIIIlllIIllIlIIIlIl;
    }
    
    private final class KeyIterator extends MapIterator implements IntIterator
    {
        @Override
        public int nextInt() {
            return Int2IntOpenHashMap.this.key[this.nextEntry()];
        }
        
        public KeyIterator() {
        }
    }
    
    private class MapIterator
    {
        /* synthetic */ int c;
        /* synthetic */ boolean mustReturnNullKey;
        /* synthetic */ IntArrayList wrapped;
        /* synthetic */ int last;
        /* synthetic */ int pos;
        
        private MapIterator() {
            this.pos = Int2IntOpenHashMap.this.n;
            this.last = -1;
            this.c = Int2IntOpenHashMap.this.size;
            this.mustReturnNullKey = Int2IntOpenHashMap.this.containsNullKey;
        }
        
        public int nextEntry() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                final int n = Int2IntOpenHashMap.this.n;
                this.last = n;
                return n;
            }
            final int[] lllllllllllllIIIlllllIllllllIlll = Int2IntOpenHashMap.this.key;
            while (--this.pos >= 0) {
                if (lllllllllllllIIIlllllIllllllIlll[this.pos] != 0) {
                    final int pos = this.pos;
                    this.last = pos;
                    return pos;
                }
            }
            this.last = Integer.MIN_VALUE;
            int lllllllllllllIIIlllllIlllllllIlI;
            int lllllllllllllIIIlllllIlllllllIIl;
            for (lllllllllllllIIIlllllIlllllllIlI = this.wrapped.getInt(-this.pos - 1), lllllllllllllIIIlllllIlllllllIIl = (HashCommon.mix(lllllllllllllIIIlllllIlllllllIlI) & Int2IntOpenHashMap.this.mask); lllllllllllllIIIlllllIlllllllIlI != lllllllllllllIIIlllllIllllllIlll[lllllllllllllIIIlllllIlllllllIIl]; lllllllllllllIIIlllllIlllllllIIl = (lllllllllllllIIIlllllIlllllllIIl + 1 & Int2IntOpenHashMap.this.mask)) {}
            return lllllllllllllIIIlllllIlllllllIIl;
        }
        
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Int2IntOpenHashMap.this.n) {
                Int2IntOpenHashMap.this.containsNullKey = false;
            }
            else {
                if (this.pos < 0) {
                    Int2IntOpenHashMap.this.remove(this.wrapped.getInt(-this.pos - 1));
                    this.last = -1;
                    return;
                }
                this.shiftKeys(this.last);
            }
            final Int2IntOpenHashMap this$0 = Int2IntOpenHashMap.this;
            --this$0.size;
            this.last = -1;
        }
        
        private void shiftKeys(int lllllllllllllIIIlllllIlllllIIlIl) {
            final int[] lllllllllllllIIIlllllIlllllIIlll = Int2IntOpenHashMap.this.key;
            int lllllllllllllIIIlllllIlllllIlIlI = 0;
        Label_0009:
            while (true) {
                lllllllllllllIIIlllllIlllllIIlIl = ((lllllllllllllIIIlllllIlllllIlIlI = (int)lllllllllllllIIIlllllIlllllIIlIl) + 1 & Int2IntOpenHashMap.this.mask);
                int lllllllllllllIIIlllllIlllllIlIII;
                while ((lllllllllllllIIIlllllIlllllIlIII = lllllllllllllIIIlllllIlllllIIlll[lllllllllllllIIIlllllIlllllIIlIl]) != 0) {
                    final int lllllllllllllIIIlllllIlllllIlIIl = HashCommon.mix(lllllllllllllIIIlllllIlllllIlIII) & Int2IntOpenHashMap.this.mask;
                    Label_0099: {
                        if (lllllllllllllIIIlllllIlllllIlIlI <= lllllllllllllIIIlllllIlllllIIlIl) {
                            if (lllllllllllllIIIlllllIlllllIlIlI >= lllllllllllllIIIlllllIlllllIlIIl) {
                                break Label_0099;
                            }
                            if (lllllllllllllIIIlllllIlllllIlIIl > lllllllllllllIIIlllllIlllllIIlIl) {
                                break Label_0099;
                            }
                        }
                        else if (lllllllllllllIIIlllllIlllllIlIlI >= lllllllllllllIIIlllllIlllllIlIIl && lllllllllllllIIIlllllIlllllIlIIl > lllllllllllllIIIlllllIlllllIIlIl) {
                            break Label_0099;
                        }
                        lllllllllllllIIIlllllIlllllIIlIl = (lllllllllllllIIIlllllIlllllIIlIl + 1 & Int2IntOpenHashMap.this.mask);
                        continue;
                    }
                    if (lllllllllllllIIIlllllIlllllIIlIl < lllllllllllllIIIlllllIlllllIlIlI) {
                        if (this.wrapped == null) {
                            this.wrapped = new IntArrayList(2);
                        }
                        this.wrapped.add(lllllllllllllIIIlllllIlllllIIlll[lllllllllllllIIIlllllIlllllIIlIl]);
                    }
                    lllllllllllllIIIlllllIlllllIIlll[lllllllllllllIIIlllllIlllllIlIlI] = lllllllllllllIIIlllllIlllllIlIII;
                    Int2IntOpenHashMap.this.value[lllllllllllllIIIlllllIlllllIlIlI] = Int2IntOpenHashMap.this.value[lllllllllllllIIIlllllIlllllIIlIl];
                    continue Label_0009;
                }
                break;
            }
            lllllllllllllIIIlllllIlllllIIlll[lllllllllllllIIIlllllIlllllIlIlI] = 0;
        }
        
        public boolean hasNext() {
            return this.c != 0;
        }
        
        public int skip(final int lllllllllllllIIIlllllIllllIlIllI) {
            int lllllllllllllIIIlllllIllllIllIII = lllllllllllllIIIlllllIllllIlIllI;
            while (lllllllllllllIIIlllllIllllIllIII-- != 0 && this.hasNext()) {
                this.nextEntry();
            }
            return lllllllllllllIIIlllllIllllIlIllI - lllllllllllllIIIlllllIllllIllIII - 1;
        }
    }
    
    final class MapEntry implements Int2IntMap.Entry, Map.Entry<Integer, Integer>
    {
        /* synthetic */ int index;
        
        MapEntry() {
        }
        
        MapEntry(final int lllllllllllllIIllIIlIlllIIIlllII) {
            this.index = lllllllllllllIIllIIlIlllIIIlllII;
        }
        
        @Override
        public int setValue(final int lllllllllllllIIllIIlIlllIIIIlIII) {
            final int lllllllllllllIIllIIlIlllIIIIIlll = Int2IntOpenHashMap.this.value[this.index];
            Int2IntOpenHashMap.this.value[this.index] = lllllllllllllIIllIIlIlllIIIIlIII;
            return lllllllllllllIIllIIlIlllIIIIIlll;
        }
        
        @Override
        public int getIntValue() {
            return Int2IntOpenHashMap.this.value[this.index];
        }
        
        @Deprecated
        @Override
        public Integer getValue() {
            return Int2IntOpenHashMap.this.value[this.index];
        }
        
        @Override
        public int getIntKey() {
            return Int2IntOpenHashMap.this.key[this.index];
        }
        
        @Override
        public int hashCode() {
            return Int2IntOpenHashMap.this.key[this.index] ^ Int2IntOpenHashMap.this.value[this.index];
        }
        
        @Deprecated
        @Override
        public Integer setValue(final Integer lllllllllllllIIllIIlIllIlllllIlI) {
            return this.setValue((int)lllllllllllllIIllIIlIllIlllllIlI);
        }
        
        @Deprecated
        @Override
        public Integer getKey() {
            return Int2IntOpenHashMap.this.key[this.index];
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIIllIIlIllIllllIIII) {
            if (!(lllllllllllllIIllIIlIllIllllIIII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<Integer, Integer> lllllllllllllIIllIIlIllIllllIIlI = (Map.Entry<Integer, Integer>)lllllllllllllIIllIIlIllIllllIIII;
            return Int2IntOpenHashMap.this.key[this.index] == lllllllllllllIIllIIlIllIllllIIlI.getKey() && Int2IntOpenHashMap.this.value[this.index] == lllllllllllllIIllIIlIllIllllIIlI.getValue();
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(Int2IntOpenHashMap.this.key[this.index]).append("=>").append(Int2IntOpenHashMap.this.value[this.index]));
        }
    }
    
    private class EntryIterator extends MapIterator implements ObjectIterator<Int2IntMap.Entry>
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
    
    private final class ValueIterator extends MapIterator implements IntIterator
    {
        public ValueIterator() {
        }
        
        @Override
        public int nextInt() {
            return Int2IntOpenHashMap.this.value[this.nextEntry()];
        }
    }
    
    private final class MapEntrySet extends AbstractObjectSet<Int2IntMap.Entry> implements Int2IntMap.FastEntrySet
    {
        @Override
        public void forEach(final Consumer<? super Int2IntMap.Entry> llllllllllllllIlIlIllIIIlIIlIIlI) {
            if (Int2IntOpenHashMap.this.containsNullKey) {
                llllllllllllllIlIlIllIIIlIIlIIlI.accept((Object)new BasicEntry(Int2IntOpenHashMap.this.key[Int2IntOpenHashMap.this.n], Int2IntOpenHashMap.this.value[Int2IntOpenHashMap.this.n]));
            }
            int llllllllllllllIlIlIllIIIlIIlIlII = Int2IntOpenHashMap.this.n;
            while (llllllllllllllIlIlIllIIIlIIlIlII-- != 0) {
                if (Int2IntOpenHashMap.this.key[llllllllllllllIlIlIllIIIlIIlIlII] != 0) {
                    llllllllllllllIlIlIllIIIlIIlIIlI.accept((Object)new BasicEntry(Int2IntOpenHashMap.this.key[llllllllllllllIlIlIllIIIlIIlIlII], Int2IntOpenHashMap.this.value[llllllllllllllIlIlIllIIIlIIlIlII]));
                }
            }
        }
        
        @Override
        public int size() {
            return Int2IntOpenHashMap.this.size;
        }
        
        @Override
        public void clear() {
            Int2IntOpenHashMap.this.clear();
        }
        
        @Override
        public ObjectIterator<Int2IntMap.Entry> fastIterator() {
            return new FastEntryIterator();
        }
        
        @Override
        public ObjectIterator<Int2IntMap.Entry> iterator() {
            return new EntryIterator();
        }
        
        @Override
        public boolean contains(final Object llllllllllllllIlIlIllIIIllIIIlII) {
            if (!(llllllllllllllIlIlIllIIIllIIIlII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> llllllllllllllIlIlIllIIIllIIIIll = (Map.Entry<?, ?>)llllllllllllllIlIlIllIIIllIIIlII;
            if (llllllllllllllIlIlIllIIIllIIIIll.getKey() == null || !(llllllllllllllIlIlIllIIIllIIIIll.getKey() instanceof Integer)) {
                return false;
            }
            if (llllllllllllllIlIlIllIIIllIIIIll.getValue() == null || !(llllllllllllllIlIlIllIIIllIIIIll.getValue() instanceof Integer)) {
                return false;
            }
            final int llllllllllllllIlIlIllIIIllIIIIlI = (int)llllllllllllllIlIlIllIIIllIIIIll.getKey();
            final int llllllllllllllIlIlIllIIIllIIIIIl = (int)llllllllllllllIlIlIllIIIllIIIIll.getValue();
            if (llllllllllllllIlIlIllIIIllIIIIlI == 0) {
                return Int2IntOpenHashMap.this.containsNullKey && Int2IntOpenHashMap.this.value[Int2IntOpenHashMap.this.n] == llllllllllllllIlIlIllIIIllIIIIIl;
            }
            final int[] llllllllllllllIlIlIllIIIlIllllll = Int2IntOpenHashMap.this.key;
            int llllllllllllllIlIlIllIIIlIlllllI;
            int llllllllllllllIlIlIllIIIllIIIIII;
            if ((llllllllllllllIlIlIllIIIllIIIIII = llllllllllllllIlIlIllIIIlIllllll[llllllllllllllIlIlIllIIIlIlllllI = (HashCommon.mix(llllllllllllllIlIlIllIIIllIIIIlI) & Int2IntOpenHashMap.this.mask)]) == 0) {
                return false;
            }
            if (llllllllllllllIlIlIllIIIllIIIIlI == llllllllllllllIlIlIllIIIllIIIIII) {
                return Int2IntOpenHashMap.this.value[llllllllllllllIlIlIllIIIlIlllllI] == llllllllllllllIlIlIllIIIllIIIIIl;
            }
            while ((llllllllllllllIlIlIllIIIllIIIIII = llllllllllllllIlIlIllIIIlIllllll[llllllllllllllIlIlIllIIIlIlllllI = (llllllllllllllIlIlIllIIIlIlllllI + 1 & Int2IntOpenHashMap.this.mask)]) != 0) {
                if (llllllllllllllIlIlIllIIIllIIIIlI == llllllllllllllIlIlIllIIIllIIIIII) {
                    return Int2IntOpenHashMap.this.value[llllllllllllllIlIlIllIIIlIlllllI] == llllllllllllllIlIlIllIIIllIIIIIl;
                }
            }
            return false;
        }
        
        @Override
        public boolean remove(final Object llllllllllllllIlIlIllIIIlIlIllII) {
            if (!(llllllllllllllIlIlIllIIIlIlIllII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> llllllllllllllIlIlIllIIIlIlIlIll = (Map.Entry<?, ?>)llllllllllllllIlIlIllIIIlIlIllII;
            if (llllllllllllllIlIlIllIIIlIlIlIll.getKey() == null || !(llllllllllllllIlIlIllIIIlIlIlIll.getKey() instanceof Integer)) {
                return false;
            }
            if (llllllllllllllIlIlIllIIIlIlIlIll.getValue() == null || !(llllllllllllllIlIlIllIIIlIlIlIll.getValue() instanceof Integer)) {
                return false;
            }
            final int llllllllllllllIlIlIllIIIlIlIlIlI = (int)llllllllllllllIlIlIllIIIlIlIlIll.getKey();
            final int llllllllllllllIlIlIllIIIlIlIlIIl = (int)llllllllllllllIlIlIllIIIlIlIlIll.getValue();
            if (llllllllllllllIlIlIllIIIlIlIlIlI == 0) {
                if (Int2IntOpenHashMap.this.containsNullKey && Int2IntOpenHashMap.this.value[Int2IntOpenHashMap.this.n] == llllllllllllllIlIlIllIIIlIlIlIIl) {
                    Int2IntOpenHashMap.this.removeNullEntry();
                    return true;
                }
                return false;
            }
            else {
                final int[] llllllllllllllIlIlIllIIIlIlIIlll = Int2IntOpenHashMap.this.key;
                int llllllllllllllIlIlIllIIIlIlIIllI;
                int llllllllllllllIlIlIllIIIlIlIlIII;
                if ((llllllllllllllIlIlIllIIIlIlIlIII = llllllllllllllIlIlIllIIIlIlIIlll[llllllllllllllIlIlIllIIIlIlIIllI = (HashCommon.mix(llllllllllllllIlIlIllIIIlIlIlIlI) & Int2IntOpenHashMap.this.mask)]) == 0) {
                    return false;
                }
                if (llllllllllllllIlIlIllIIIlIlIlIII != llllllllllllllIlIlIllIIIlIlIlIlI) {
                    while ((llllllllllllllIlIlIllIIIlIlIlIII = llllllllllllllIlIlIllIIIlIlIIlll[llllllllllllllIlIlIllIIIlIlIIllI = (llllllllllllllIlIlIllIIIlIlIIllI + 1 & Int2IntOpenHashMap.this.mask)]) != 0) {
                        if (llllllllllllllIlIlIllIIIlIlIlIII == llllllllllllllIlIlIllIIIlIlIlIlI && Int2IntOpenHashMap.this.value[llllllllllllllIlIlIllIIIlIlIIllI] == llllllllllllllIlIlIllIIIlIlIlIIl) {
                            Int2IntOpenHashMap.this.removeEntry(llllllllllllllIlIlIllIIIlIlIIllI);
                            return true;
                        }
                    }
                    return false;
                }
                if (Int2IntOpenHashMap.this.value[llllllllllllllIlIlIllIIIlIlIIllI] == llllllllllllllIlIlIllIIIlIlIlIIl) {
                    Int2IntOpenHashMap.this.removeEntry(llllllllllllllIlIlIllIIIlIlIIllI);
                    return true;
                }
                return false;
            }
        }
        
        @Override
        public void fastForEach(final Consumer<? super Int2IntMap.Entry> llllllllllllllIlIlIllIIIlIIIlIII) {
            final BasicEntry llllllllllllllIlIlIllIIIlIIIIlll = new BasicEntry();
            if (Int2IntOpenHashMap.this.containsNullKey) {
                llllllllllllllIlIlIllIIIlIIIIlll.key = Int2IntOpenHashMap.this.key[Int2IntOpenHashMap.this.n];
                llllllllllllllIlIlIllIIIlIIIIlll.value = Int2IntOpenHashMap.this.value[Int2IntOpenHashMap.this.n];
                llllllllllllllIlIlIllIIIlIIIlIII.accept(llllllllllllllIlIlIllIIIlIIIIlll);
            }
            int llllllllllllllIlIlIllIIIlIIIlIlI = Int2IntOpenHashMap.this.n;
            while (llllllllllllllIlIlIllIIIlIIIlIlI-- != 0) {
                if (Int2IntOpenHashMap.this.key[llllllllllllllIlIlIllIIIlIIIlIlI] != 0) {
                    llllllllllllllIlIlIllIIIlIIIIlll.key = Int2IntOpenHashMap.this.key[llllllllllllllIlIlIllIIIlIIIlIlI];
                    llllllllllllllIlIlIllIIIlIIIIlll.value = Int2IntOpenHashMap.this.value[llllllllllllllIlIlIllIIIlIIIlIlI];
                    llllllllllllllIlIlIllIIIlIIIlIII.accept(llllllllllllllIlIlIllIIIlIIIIlll);
                }
            }
        }
    }
    
    private class FastEntryIterator extends MapIterator implements ObjectIterator<Int2IntMap.Entry>
    {
        private final /* synthetic */ MapEntry entry;
        
        @Override
        public MapEntry next() {
            this.entry.index = this.nextEntry();
            return this.entry;
        }
        
        private FastEntryIterator() {
            this.entry = new MapEntry();
        }
    }
    
    private final class KeySet extends AbstractIntSet
    {
        @Override
        public void clear() {
            Int2IntOpenHashMap.this.clear();
        }
        
        @Override
        public int size() {
            return Int2IntOpenHashMap.this.size;
        }
        
        @Override
        public IntIterator iterator() {
            return new KeyIterator();
        }
        
        @Override
        public boolean remove(final int lllllllllllllllIIIIIIIlIlIIIllII) {
            final int lllllllllllllllIIIIIIIlIlIIIlIll = Int2IntOpenHashMap.this.size;
            Int2IntOpenHashMap.this.remove(lllllllllllllllIIIIIIIlIlIIIllII);
            return Int2IntOpenHashMap.this.size != lllllllllllllllIIIIIIIlIlIIIlIll;
        }
        
        @Override
        public boolean contains(final int lllllllllllllllIIIIIIIlIlIIlIIIl) {
            return Int2IntOpenHashMap.this.containsKey(lllllllllllllllIIIIIIIlIlIIlIIIl);
        }
        
        @Override
        public void forEach(final IntConsumer lllllllllllllllIIIIIIIlIlIIlllII) {
            if (Int2IntOpenHashMap.this.containsNullKey) {
                lllllllllllllllIIIIIIIlIlIIlllII.accept(Int2IntOpenHashMap.this.key[Int2IntOpenHashMap.this.n]);
            }
            int lllllllllllllllIIIIIIIlIlIlIIIII = Int2IntOpenHashMap.this.n;
            while (lllllllllllllllIIIIIIIlIlIlIIIII-- != 0) {
                final int lllllllllllllllIIIIIIIlIlIlIIIIl = Int2IntOpenHashMap.this.key[lllllllllllllllIIIIIIIlIlIlIIIII];
                if (lllllllllllllllIIIIIIIlIlIlIIIIl != 0) {
                    lllllllllllllllIIIIIIIlIlIIlllII.accept(lllllllllllllllIIIIIIIlIlIlIIIIl);
                }
            }
        }
    }
}
