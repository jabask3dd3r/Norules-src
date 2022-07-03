package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public class Int2ObjectOpenHashMap<V> extends AbstractInt2ObjectMap<V> implements Serializable, Cloneable, Hash
{
    protected transient /* synthetic */ int mask;
    protected transient /* synthetic */ int maxFill;
    protected final transient /* synthetic */ int minN;
    protected /* synthetic */ int size;
    protected final /* synthetic */ float f;
    protected transient /* synthetic */ int[] key;
    protected transient /* synthetic */ IntSet keys;
    protected transient /* synthetic */ Int2ObjectMap.FastEntrySet<V> entries;
    protected transient /* synthetic */ int n;
    protected transient /* synthetic */ boolean containsNullKey;
    protected transient /* synthetic */ ObjectCollection<V> values;
    protected transient /* synthetic */ V[] value;
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNullKey = false;
        Arrays.fill(this.key, 0);
        Arrays.fill(this.value, null);
    }
    
    @Override
    public V computeIfPresent(final int lllllllllllllllIIIIIllIllIllIllI, final BiFunction<? super Integer, ? super V, ? extends V> lllllllllllllllIIIIIllIllIlllIlI) {
        Objects.requireNonNull(lllllllllllllllIIIIIllIllIlllIlI);
        final int lllllllllllllllIIIIIllIllIlllIIl = this.find(lllllllllllllllIIIIIllIllIllIllI);
        if (lllllllllllllllIIIIIllIllIlllIIl < 0) {
            return this.defRetValue;
        }
        final V lllllllllllllllIIIIIllIllIlllIII = (V)lllllllllllllllIIIIIllIllIlllIlI.apply(Integer.valueOf(lllllllllllllllIIIIIllIllIllIllI), (Object)this.value[lllllllllllllllIIIIIllIllIlllIIl]);
        if (lllllllllllllllIIIIIllIllIlllIII == null) {
            if (lllllllllllllllIIIIIllIllIllIllI == 0) {
                this.removeNullEntry();
            }
            else {
                this.removeEntry(lllllllllllllllIIIIIllIllIlllIIl);
            }
            return this.defRetValue;
        }
        return this.value[lllllllllllllllIIIIIllIllIlllIIl] = lllllllllllllllIIIIIllIllIlllIII;
    }
    
    @Override
    public V remove(final int lllllllllllllllIIIIIlllIllIIIIlI) {
        if (lllllllllllllllIIIIIlllIllIIIIlI == 0) {
            if (this.containsNullKey) {
                return this.removeNullEntry();
            }
            return this.defRetValue;
        }
        else {
            final int[] lllllllllllllllIIIIIlllIllIIIlIl = this.key;
            int lllllllllllllllIIIIIlllIllIIIlII;
            int lllllllllllllllIIIIIlllIllIIIllI;
            if ((lllllllllllllllIIIIIlllIllIIIllI = lllllllllllllllIIIIIlllIllIIIlIl[lllllllllllllllIIIIIlllIllIIIlII = (HashCommon.mix(lllllllllllllllIIIIIlllIllIIIIlI) & this.mask)]) == 0) {
                return this.defRetValue;
            }
            if (lllllllllllllllIIIIIlllIllIIIIlI == lllllllllllllllIIIIIlllIllIIIllI) {
                return this.removeEntry(lllllllllllllllIIIIIlllIllIIIlII);
            }
            while ((lllllllllllllllIIIIIlllIllIIIllI = lllllllllllllllIIIIIlllIllIIIlIl[lllllllllllllllIIIIIlllIllIIIlII = (lllllllllllllllIIIIIlllIllIIIlII + 1 & this.mask)]) != 0) {
                if (lllllllllllllllIIIIIlllIllIIIIlI == lllllllllllllllIIIIIlllIllIIIllI) {
                    return this.removeEntry(lllllllllllllllIIIIIlllIllIIIlII);
                }
            }
            return this.defRetValue;
        }
    }
    
    @Override
    public Int2ObjectMap.FastEntrySet<V> int2ObjectEntrySet() {
        if (this.entries == null) {
            this.entries = new MapEntrySet();
        }
        return this.entries;
    }
    
    @Override
    public V get(final int lllllllllllllllIIIIIlllIlIlIIlll) {
        if (lllllllllllllllIIIIIlllIlIlIIlll == 0) {
            return this.containsNullKey ? this.value[this.n] : this.defRetValue;
        }
        final int[] lllllllllllllllIIIIIlllIlIlIlIlI = this.key;
        int lllllllllllllllIIIIIlllIlIlIlIIl;
        int lllllllllllllllIIIIIlllIlIlIlIll;
        if ((lllllllllllllllIIIIIlllIlIlIlIll = lllllllllllllllIIIIIlllIlIlIlIlI[lllllllllllllllIIIIIlllIlIlIlIIl = (HashCommon.mix(lllllllllllllllIIIIIlllIlIlIIlll) & this.mask)]) == 0) {
            return this.defRetValue;
        }
        if (lllllllllllllllIIIIIlllIlIlIIlll == lllllllllllllllIIIIIlllIlIlIlIll) {
            return this.value[lllllllllllllllIIIIIlllIlIlIlIIl];
        }
        while ((lllllllllllllllIIIIIlllIlIlIlIll = lllllllllllllllIIIIIlllIlIlIlIlI[lllllllllllllllIIIIIlllIlIlIlIIl = (lllllllllllllllIIIIIlllIlIlIlIIl + 1 & this.mask)]) != 0) {
            if (lllllllllllllllIIIIIlllIlIlIIlll == lllllllllllllllIIIIIlllIlIlIlIll) {
                return this.value[lllllllllllllllIIIIIlllIlIlIlIIl];
            }
        }
        return this.defRetValue;
    }
    
    public Int2ObjectOpenHashMap(final Map<? extends Integer, ? extends V> lllllllllllllllIIIIIllllIllIlIII, final float lllllllllllllllIIIIIllllIllIIlll) {
        this(lllllllllllllllIIIIIllllIllIlIII.size(), lllllllllllllllIIIIIllllIllIIlll);
        this.putAll(lllllllllllllllIIIIIllllIllIlIII);
    }
    
    @Override
    public V replace(final int lllllllllllllllIIIIIllIllllIIlIl, final V lllllllllllllllIIIIIllIllllIIlII) {
        final int lllllllllllllllIIIIIllIllllIIIll = this.find(lllllllllllllllIIIIIllIllllIIlIl);
        if (lllllllllllllllIIIIIllIllllIIIll < 0) {
            return this.defRetValue;
        }
        final V lllllllllllllllIIIIIllIllllIIIlI = this.value[lllllllllllllllIIIIIllIllllIIIll];
        this.value[lllllllllllllllIIIIIllIllllIIIll] = lllllllllllllllIIIIIllIllllIIlII;
        return lllllllllllllllIIIIIllIllllIIIlI;
    }
    
    public Int2ObjectOpenHashMap(final Map<? extends Integer, ? extends V> lllllllllllllllIIIIIllllIllIIIII) {
        this(lllllllllllllllIIIIIllllIllIIIII, 0.75f);
    }
    
    protected void rehash(final int lllllllllllllllIIIIIllIlIlIllIII) {
        final int[] lllllllllllllllIIIIIllIlIlIlllll = this.key;
        final V[] lllllllllllllllIIIIIllIlIlIllllI = this.value;
        final int lllllllllllllllIIIIIllIlIlIlllIl = lllllllllllllllIIIIIllIlIlIllIII - 1;
        final int[] lllllllllllllllIIIIIllIlIlIlllII = new int[lllllllllllllllIIIIIllIlIlIllIII + 1];
        final V[] lllllllllllllllIIIIIllIlIlIllIll = (V[])new Object[lllllllllllllllIIIIIllIlIlIllIII + 1];
        int lllllllllllllllIIIIIllIlIlIllIlI = this.n;
        int lllllllllllllllIIIIIllIlIllIIIlI = this.realSize();
        while (lllllllllllllllIIIIIllIlIllIIIlI-- != 0) {
            while (lllllllllllllllIIIIIllIlIlIlllll[--lllllllllllllllIIIIIllIlIlIllIlI] == 0) {}
            int lllllllllllllllIIIIIllIlIllIIIll;
            if (lllllllllllllllIIIIIllIlIlIlllII[lllllllllllllllIIIIIllIlIllIIIll = (HashCommon.mix(lllllllllllllllIIIIIllIlIlIlllll[lllllllllllllllIIIIIllIlIlIllIlI]) & lllllllllllllllIIIIIllIlIlIlllIl)] != 0) {
                while (lllllllllllllllIIIIIllIlIlIlllII[lllllllllllllllIIIIIllIlIllIIIll = (lllllllllllllllIIIIIllIlIllIIIll + 1 & lllllllllllllllIIIIIllIlIlIlllIl)] != 0) {}
            }
            lllllllllllllllIIIIIllIlIlIlllII[lllllllllllllllIIIIIllIlIllIIIll] = lllllllllllllllIIIIIllIlIlIlllll[lllllllllllllllIIIIIllIlIlIllIlI];
            lllllllllllllllIIIIIllIlIlIllIll[lllllllllllllllIIIIIllIlIllIIIll] = lllllllllllllllIIIIIllIlIlIllllI[lllllllllllllllIIIIIllIlIlIllIlI];
        }
        lllllllllllllllIIIIIllIlIlIllIll[lllllllllllllllIIIIIllIlIlIllIII] = lllllllllllllllIIIIIllIlIlIllllI[this.n];
        this.n = lllllllllllllllIIIIIllIlIlIllIII;
        this.mask = lllllllllllllllIIIIIllIlIlIlllIl;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = lllllllllllllllIIIIIllIlIlIlllII;
        this.value = lllllllllllllllIIIIIllIlIlIllIll;
    }
    
    private void tryCapacity(final long lllllllllllllllIIIIIllllIIlIIllI) {
        final int lllllllllllllllIIIIIllllIIlIIlIl = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(lllllllllllllllIIIIIllllIIlIIllI / this.f))));
        if (lllllllllllllllIIIIIllllIIlIIlIl > this.n) {
            this.rehash(lllllllllllllllIIIIIllllIIlIIlIl);
        }
    }
    
    private void checkTable() {
    }
    
    @Override
    public boolean containsKey(final int lllllllllllllllIIIIIlllIlIIlllII) {
        if (lllllllllllllllIIIIIlllIlIIlllII == 0) {
            return this.containsNullKey;
        }
        final int[] lllllllllllllllIIIIIlllIlIIllIIl = this.key;
        int lllllllllllllllIIIIIlllIlIIlIlll;
        int lllllllllllllllIIIIIlllIlIIllIll;
        if ((lllllllllllllllIIIIIlllIlIIllIll = lllllllllllllllIIIIIlllIlIIllIIl[lllllllllllllllIIIIIlllIlIIlIlll = (HashCommon.mix(lllllllllllllllIIIIIlllIlIIlllII) & this.mask)]) == 0) {
            return false;
        }
        if (lllllllllllllllIIIIIlllIlIIlllII == lllllllllllllllIIIIIlllIlIIllIll) {
            return true;
        }
        while ((lllllllllllllllIIIIIlllIlIIllIll = lllllllllllllllIIIIIlllIlIIllIIl[lllllllllllllllIIIIIlllIlIIlIlll = (lllllllllllllllIIIIIlllIlIIlIlll + 1 & this.mask)]) != 0) {
            if (lllllllllllllllIIIIIlllIlIIlllII == lllllllllllllllIIIIIlllIlIIllIll) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public V getOrDefault(final int lllllllllllllllIIIIIlllIIlIlIlIl, final V lllllllllllllllIIIIIlllIIlIlIlII) {
        if (lllllllllllllllIIIIIlllIIlIlIlIl == 0) {
            return this.containsNullKey ? this.value[this.n] : lllllllllllllllIIIIIlllIIlIlIlII;
        }
        final int[] lllllllllllllllIIIIIlllIIlIlIIlI = this.key;
        int lllllllllllllllIIIIIlllIIlIlIIIl;
        int lllllllllllllllIIIIIlllIIlIlIIll;
        if ((lllllllllllllllIIIIIlllIIlIlIIll = lllllllllllllllIIIIIlllIIlIlIIlI[lllllllllllllllIIIIIlllIIlIlIIIl = (HashCommon.mix(lllllllllllllllIIIIIlllIIlIlIlIl) & this.mask)]) == 0) {
            return lllllllllllllllIIIIIlllIIlIlIlII;
        }
        if (lllllllllllllllIIIIIlllIIlIlIlIl == lllllllllllllllIIIIIlllIIlIlIIll) {
            return this.value[lllllllllllllllIIIIIlllIIlIlIIIl];
        }
        while ((lllllllllllllllIIIIIlllIIlIlIIll = lllllllllllllllIIIIIlllIIlIlIIlI[lllllllllllllllIIIIIlllIIlIlIIIl = (lllllllllllllllIIIIIlllIIlIlIIIl + 1 & this.mask)]) != 0) {
            if (lllllllllllllllIIIIIlllIIlIlIlIl == lllllllllllllllIIIIIlllIIlIlIIll) {
                return this.value[lllllllllllllllIIIIIlllIIlIlIIIl];
            }
        }
        return lllllllllllllllIIIIIlllIIlIlIlII;
    }
    
    public Int2ObjectOpenHashMap<V> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap;
        //     7: astore_1        /* lllllllllllllllIIIIIllIlIlIIllII */
        //     8: goto            20
        //    11: astore_2        /* lllllllllllllllIIIIIllIlIlIIIllI */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllllllIIIIIllIlIlIIlIIl */
        //    21: aconst_null    
        //    22: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap.keys:Lcom/viaversion/viaversion/libs/fastutil/ints/IntSet;
        //    25: aload_1         /* lllllllllllllllIIIIIllIlIlIIlIIl */
        //    26: aconst_null    
        //    27: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap.values:Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectCollection;
        //    30: aload_1         /* lllllllllllllllIIIIIllIlIlIIlIIl */
        //    31: aconst_null    
        //    32: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap.entries:Lcom/viaversion/viaversion/libs/fastutil/ints/Int2ObjectMap$FastEntrySet;
        //    35: aload_1         /* lllllllllllllllIIIIIllIlIlIIlIIl */
        //    36: aload_0         /* lllllllllllllllIIIIIllIlIlIIlIII */
        //    37: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap.containsNullKey:Z
        //    40: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap.containsNullKey:Z
        //    43: aload_1         /* lllllllllllllllIIIIIllIlIlIIlIIl */
        //    44: aload_0         /* lllllllllllllllIIIIIllIlIlIIlIII */
        //    45: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap.key:[I
        //    48: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    51: checkcast       [I
        //    54: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap.key:[I
        //    57: aload_1         /* lllllllllllllllIIIIIllIlIlIIlIIl */
        //    58: aload_0         /* lllllllllllllllIIIIIllIlIlIIlIII */
        //    59: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap.value:[Ljava/lang/Object;
        //    62: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    65: checkcast       [Ljava/lang/Object;
        //    68: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap.value:[Ljava/lang/Object;
        //    71: aload_1         /* lllllllllllllllIIIIIllIlIlIIlIIl */
        //    72: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/ints/Int2ObjectOpenHashMap<TV;>;
        //    StackMapTable: 00 02 4B 07 01 55 FC 00 08 07 00 02
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  0      8      11     20     Ljava/lang/CloneNotSupportedException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public Int2ObjectOpenHashMap() {
        this(16, 0.75f);
    }
    
    static {
        ASSERTS = false;
    }
    
    public Int2ObjectOpenHashMap(final int lllllllllllllllIIIIIllllIlllIIII) {
        this(lllllllllllllllIIIIIllllIlllIIII, 0.75f);
    }
    
    private int find(final int lllllllllllllllIIIIIllllIIIIIllI) {
        if (lllllllllllllllIIIIIllllIIIIIllI == 0) {
            return this.containsNullKey ? this.n : (-(this.n + 1));
        }
        final int[] lllllllllllllllIIIIIllllIIIIIlII = this.key;
        int lllllllllllllllIIIIIllllIIIIIIll;
        int lllllllllllllllIIIIIllllIIIIIlIl;
        if ((lllllllllllllllIIIIIllllIIIIIlIl = lllllllllllllllIIIIIllllIIIIIlII[lllllllllllllllIIIIIllllIIIIIIll = (HashCommon.mix(lllllllllllllllIIIIIllllIIIIIllI) & this.mask)]) == 0) {
            return -(lllllllllllllllIIIIIllllIIIIIIll + 1);
        }
        if (lllllllllllllllIIIIIllllIIIIIllI == lllllllllllllllIIIIIllllIIIIIlIl) {
            return lllllllllllllllIIIIIllllIIIIIIll;
        }
        while ((lllllllllllllllIIIIIllllIIIIIlIl = lllllllllllllllIIIIIllllIIIIIlII[lllllllllllllllIIIIIllllIIIIIIll = (lllllllllllllllIIIIIllllIIIIIIll + 1 & this.mask)]) != 0) {
            if (lllllllllllllllIIIIIllllIIIIIllI == lllllllllllllllIIIIIllllIIIIIlIl) {
                return lllllllllllllllIIIIIllllIIIIIIll;
            }
        }
        return -(lllllllllllllllIIIIIllllIIIIIIll + 1);
    }
    
    @Override
    public boolean remove(final int lllllllllllllllIIIIIlllIIIIllIIl, final Object lllllllllllllllIIIIIlllIIIIllllI) {
        if (lllllllllllllllIIIIIlllIIIIllIIl == 0) {
            if (this.containsNullKey && Objects.equals(lllllllllllllllIIIIIlllIIIIllllI, this.value[this.n])) {
                this.removeNullEntry();
                return true;
            }
            return false;
        }
        else {
            final int[] lllllllllllllllIIIIIlllIIIIlllII = this.key;
            int lllllllllllllllIIIIIlllIIIIllIll;
            int lllllllllllllllIIIIIlllIIIIlllIl;
            if ((lllllllllllllllIIIIIlllIIIIlllIl = lllllllllllllllIIIIIlllIIIIlllII[lllllllllllllllIIIIIlllIIIIllIll = (HashCommon.mix(lllllllllllllllIIIIIlllIIIIllIIl) & this.mask)]) == 0) {
                return false;
            }
            if (lllllllllllllllIIIIIlllIIIIllIIl == lllllllllllllllIIIIIlllIIIIlllIl && Objects.equals(lllllllllllllllIIIIIlllIIIIllllI, this.value[lllllllllllllllIIIIIlllIIIIllIll])) {
                this.removeEntry(lllllllllllllllIIIIIlllIIIIllIll);
                return true;
            }
            while ((lllllllllllllllIIIIIlllIIIIlllIl = lllllllllllllllIIIIIlllIIIIlllII[lllllllllllllllIIIIIlllIIIIllIll = (lllllllllllllllIIIIIlllIIIIllIll + 1 & this.mask)]) != 0) {
                if (lllllllllllllllIIIIIlllIIIIllIIl == lllllllllllllllIIIIIlllIIIIlllIl && Objects.equals(lllllllllllllllIIIIIlllIIIIllllI, this.value[lllllllllllllllIIIIIlllIIIIllIll])) {
                    this.removeEntry(lllllllllllllllIIIIIlllIIIIllIll);
                    return true;
                }
            }
            return false;
        }
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public V computeIfAbsent(final int lllllllllllllllIIIIIllIlllIIlllI, final IntFunction<? extends V> lllllllllllllllIIIIIllIlllIIIlIl) {
        Objects.requireNonNull(lllllllllllllllIIIIIllIlllIIIlIl);
        final int lllllllllllllllIIIIIllIlllIIlIll = this.find(lllllllllllllllIIIIIllIlllIIlllI);
        if (lllllllllllllllIIIIIllIlllIIlIll >= 0) {
            return this.value[lllllllllllllllIIIIIllIlllIIlIll];
        }
        final V lllllllllllllllIIIIIllIlllIIlIIl = (V)lllllllllllllllIIIIIllIlllIIIlIl.apply(lllllllllllllllIIIIIllIlllIIlllI);
        this.insert(-lllllllllllllllIIIIIllIlllIIlIll - 1, lllllllllllllllIIIIIllIlllIIlllI, lllllllllllllllIIIIIllIlllIIlIIl);
        return lllllllllllllllIIIIIllIlllIIlIIl;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    public Int2ObjectOpenHashMap(final int[] lllllllllllllllIIIIIllllIlIIIlll, final V[] lllllllllllllllIIIIIllllIlIIIllI, final float lllllllllllllllIIIIIllllIlIIIIIl) {
        this(lllllllllllllllIIIIIllllIlIIIlll.length, lllllllllllllllIIIIIllllIlIIIIIl);
        if (lllllllllllllllIIIIIllllIlIIIlll.length != lllllllllllllllIIIIIllllIlIIIllI.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The key array and the value array have different lengths (").append(lllllllllllllllIIIIIllllIlIIIlll.length).append(" and ").append(lllllllllllllllIIIIIllllIlIIIllI.length).append(")")));
        }
        for (int lllllllllllllllIIIIIllllIlIIlIIl = 0; lllllllllllllllIIIIIllllIlIIlIIl < lllllllllllllllIIIIIllllIlIIIlll.length; ++lllllllllllllllIIIIIllllIlIIlIIl) {
            this.put(lllllllllllllllIIIIIllllIlIIIlll[lllllllllllllllIIIIIllllIlIIlIIl], lllllllllllllllIIIIIllllIlIIIllI[lllllllllllllllIIIIIllllIlIIlIIl]);
        }
    }
    
    @Override
    public V put(final int lllllllllllllllIIIIIlllIlllIlIll, final V lllllllllllllllIIIIIlllIlllIlIlI) {
        final int lllllllllllllllIIIIIlllIlllIlIIl = this.find(lllllllllllllllIIIIIlllIlllIlIll);
        if (lllllllllllllllIIIIIlllIlllIlIIl < 0) {
            this.insert(-lllllllllllllllIIIIIlllIlllIlIIl - 1, lllllllllllllllIIIIIlllIlllIlIll, lllllllllllllllIIIIIlllIlllIlIlI);
            return this.defRetValue;
        }
        final V lllllllllllllllIIIIIlllIlllIlIII = this.value[lllllllllllllllIIIIIlllIlllIlIIl];
        this.value[lllllllllllllllIIIIIlllIlllIlIIl] = lllllllllllllllIIIIIlllIlllIlIlI;
        return lllllllllllllllIIIIIlllIlllIlIII;
    }
    
    public boolean trim(final int lllllllllllllllIIIIIllIlIlllIIII) {
        final int lllllllllllllllIIIIIllIlIlllIIlI = HashCommon.nextPowerOfTwo((int)Math.ceil(lllllllllllllllIIIIIllIlIlllIIII / this.f));
        if (lllllllllllllllIIIIIllIlIlllIIlI >= this.n || this.size > HashCommon.maxFill(lllllllllllllllIIIIIllIlIlllIIlI, this.f)) {
            return true;
        }
        try {
            this.rehash(lllllllllllllllIIIIIllIlIlllIIlI);
        }
        catch (OutOfMemoryError lllllllllllllllIIIIIllIlIlllIlIl) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean containsValue(final Object lllllllllllllllIIIIIlllIIlllIIlI) {
        final V[] lllllllllllllllIIIIIlllIIlllIlIl = this.value;
        final int[] lllllllllllllllIIIIIlllIIlllIlII = this.key;
        if (this.containsNullKey && Objects.equals(lllllllllllllllIIIIIlllIIlllIlIl[this.n], lllllllllllllllIIIIIlllIIlllIIlI)) {
            return true;
        }
        int lllllllllllllllIIIIIlllIIllllIIl = this.n;
        while (lllllllllllllllIIIIIlllIIllllIIl-- != 0) {
            if (lllllllllllllllIIIIIlllIIlllIlII[lllllllllllllllIIIIIlllIIllllIIl] != 0 && Objects.equals(lllllllllllllllIIIIIlllIIlllIlIl[lllllllllllllllIIIIIlllIIllllIIl], lllllllllllllllIIIIIlllIIlllIIlI)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public IntSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }
    
    public Int2ObjectOpenHashMap(final Int2ObjectMap<V> lllllllllllllllIIIIIllllIlIlIIIl) {
        this(lllllllllllllllIIIIIllllIlIlIIIl, 0.75f);
    }
    
    private void readObject(final ObjectInputStream lllllllllllllllIIIIIllIlIIIIllll) throws IOException, ClassNotFoundException {
        lllllllllllllllIIIIIllIlIIIIllll.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final int[] key = new int[this.n + 1];
        this.key = key;
        final int[] lllllllllllllllIIIIIllIlIIIlIIlI = key;
        final Object[] value = new Object[this.n + 1];
        this.value = (V[])value;
        final V[] lllllllllllllllIIIIIllIlIIIlIIIl = (V[])value;
        int lllllllllllllllIIIIIllIlIIIlIllI = this.size;
        while (lllllllllllllllIIIIIllIlIIIlIllI-- != 0) {
            final int lllllllllllllllIIIIIllIlIIIllIII = lllllllllllllllIIIIIllIlIIIIllll.readInt();
            final V lllllllllllllllIIIIIllIlIIIlIlll = (V)lllllllllllllllIIIIIllIlIIIIllll.readObject();
            int lllllllllllllllIIIIIllIlIIIlIlIl = 0;
            if (lllllllllllllllIIIIIllIlIIIllIII == 0) {
                final int lllllllllllllllIIIIIllIlIIIllIIl = this.n;
                this.containsNullKey = true;
            }
            else {
                for (lllllllllllllllIIIIIllIlIIIlIlIl = (HashCommon.mix(lllllllllllllllIIIIIllIlIIIllIII) & this.mask); lllllllllllllllIIIIIllIlIIIlIIlI[lllllllllllllllIIIIIllIlIIIlIlIl] != 0; lllllllllllllllIIIIIllIlIIIlIlIl = (lllllllllllllllIIIIIllIlIIIlIlIl + 1 & this.mask)) {}
            }
            lllllllllllllllIIIIIllIlIIIlIIlI[lllllllllllllllIIIIIllIlIIIlIlIl] = lllllllllllllllIIIIIllIlIIIllIII;
            lllllllllllllllIIIIIllIlIIIlIIIl[lllllllllllllllIIIIIllIlIIIlIlIl] = lllllllllllllllIIIIIllIlIIIlIlll;
        }
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    private V removeNullEntry() {
        this.containsNullKey = false;
        final V lllllllllllllllIIIIIllllIIIlIlIl = this.value[this.n];
        this.value[this.n] = null;
        --this.size;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllllIIIIIllllIIIlIlIl;
    }
    
    protected final void shiftKeys(int lllllllllllllllIIIIIlllIllIlIlIl) {
        final int[] lllllllllllllllIIIIIlllIllIlIlll = this.key;
        int lllllllllllllllIIIIIlllIllIllIlI = 0;
    Label_0006:
        while (true) {
            lllllllllllllllIIIIIlllIllIlIlIl = ((lllllllllllllllIIIIIlllIllIllIlI = lllllllllllllllIIIIIlllIllIlIlIl) + 1 & this.mask);
            int lllllllllllllllIIIIIlllIllIllIII;
            while ((lllllllllllllllIIIIIlllIllIllIII = lllllllllllllllIIIIIlllIllIlIlll[lllllllllllllllIIIIIlllIllIlIlIl]) != 0) {
                final int lllllllllllllllIIIIIlllIllIllIIl = HashCommon.mix(lllllllllllllllIIIIIlllIllIllIII) & this.mask;
                Label_0094: {
                    if (lllllllllllllllIIIIIlllIllIllIlI <= lllllllllllllllIIIIIlllIllIlIlIl) {
                        if (lllllllllllllllIIIIIlllIllIllIlI >= lllllllllllllllIIIIIlllIllIllIIl) {
                            break Label_0094;
                        }
                        if (lllllllllllllllIIIIIlllIllIllIIl > lllllllllllllllIIIIIlllIllIlIlIl) {
                            break Label_0094;
                        }
                    }
                    else if (lllllllllllllllIIIIIlllIllIllIlI >= lllllllllllllllIIIIIlllIllIllIIl && lllllllllllllllIIIIIlllIllIllIIl > lllllllllllllllIIIIIlllIllIlIlIl) {
                        break Label_0094;
                    }
                    lllllllllllllllIIIIIlllIllIlIlIl = (lllllllllllllllIIIIIlllIllIlIlIl + 1 & this.mask);
                    continue;
                }
                lllllllllllllllIIIIIlllIllIlIlll[lllllllllllllllIIIIIlllIllIllIlI] = lllllllllllllllIIIIIlllIllIllIII;
                this.value[lllllllllllllllIIIIIlllIllIllIlI] = this.value[lllllllllllllllIIIIIlllIllIlIlIl];
                continue Label_0006;
            }
            break;
        }
        lllllllllllllllIIIIIlllIllIlIlll[lllllllllllllllIIIIIlllIllIllIlI] = 0;
        this.value[lllllllllllllllIIIIIlllIllIllIlI] = null;
    }
    
    @Override
    public void putAll(final Map<? extends Integer, ? extends V> lllllllllllllllIIIIIllllIIIIllIl) {
        if (this.f <= 0.5) {
            this.ensureCapacity(lllllllllllllllIIIIIllllIIIIllIl.size());
        }
        else {
            this.tryCapacity(this.size() + lllllllllllllllIIIIIllllIIIIllIl.size());
        }
        super.putAll(lllllllllllllllIIIIIllllIIIIllIl);
    }
    
    @Override
    public V putIfAbsent(final int lllllllllllllllIIIIIlllIIlIIIlIl, final V lllllllllllllllIIIIIlllIIlIIIlII) {
        final int lllllllllllllllIIIIIlllIIlIIIIll = this.find(lllllllllllllllIIIIIlllIIlIIIlIl);
        if (lllllllllllllllIIIIIlllIIlIIIIll >= 0) {
            return this.value[lllllllllllllllIIIIIlllIIlIIIIll];
        }
        this.insert(-lllllllllllllllIIIIIlllIIlIIIIll - 1, lllllllllllllllIIIIIlllIIlIIIlIl, lllllllllllllllIIIIIlllIIlIIIlII);
        return this.defRetValue;
    }
    
    public Int2ObjectOpenHashMap(final int lllllllllllllllIIIIIllllIllllIlI, final float lllllllllllllllIIIIIllllIlllIllI) {
        if (lllllllllllllllIIIIIllllIlllIllI <= 0.0f || lllllllllllllllIIIIIllllIlllIllI > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (lllllllllllllllIIIIIllllIllllIlI < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = lllllllllllllllIIIIIllllIlllIllI;
        final int arraySize = HashCommon.arraySize(lllllllllllllllIIIIIllllIllllIlI, lllllllllllllllIIIIIllllIlllIllI);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, lllllllllllllllIIIIIllllIlllIllI);
        this.key = new int[this.n + 1];
        this.value = (V[])new Object[this.n + 1];
    }
    
    @Override
    public boolean replace(final int lllllllllllllllIIIIIlllIIIIIIIIl, final V lllllllllllllllIIIIIllIllllllIIl, final V lllllllllllllllIIIIIllIlllllllll) {
        final int lllllllllllllllIIIIIllIllllllllI = this.find(lllllllllllllllIIIIIlllIIIIIIIIl);
        if (lllllllllllllllIIIIIllIllllllllI < 0 || !Objects.equals(lllllllllllllllIIIIIllIllllllIIl, this.value[lllllllllllllllIIIIIllIllllllllI])) {
            return false;
        }
        this.value[lllllllllllllllIIIIIllIllllllllI] = lllllllllllllllIIIIIllIlllllllll;
        return true;
    }
    
    public Int2ObjectOpenHashMap(final int[] lllllllllllllllIIIIIllllIIlllIll, final V[] lllllllllllllllIIIIIllllIIlllIlI) {
        this(lllllllllllllllIIIIIllllIIlllIll, lllllllllllllllIIIIIllllIIlllIlI, 0.75f);
    }
    
    @Override
    public ObjectCollection<V> values() {
        if (this.values == null) {
            this.values = new AbstractObjectCollection<V>() {
                @Override
                public boolean contains(final Object lllllllllllllllIIlIIIIlIlllllIIl) {
                    return Int2ObjectOpenHashMap.this.containsValue(lllllllllllllllIIlIIIIlIlllllIIl);
                }
                
                @Override
                public int size() {
                    return Int2ObjectOpenHashMap.this.size;
                }
                
                @Override
                public void forEach(final Consumer<? super V> lllllllllllllllIIlIIIIlIlllIllII) {
                    if (Int2ObjectOpenHashMap.this.containsNullKey) {
                        lllllllllllllllIIlIIIIlIlllIllII.accept((Object)Int2ObjectOpenHashMap.this.value[Int2ObjectOpenHashMap.this.n]);
                    }
                    int lllllllllllllllIIlIIIIlIllllIIII = Int2ObjectOpenHashMap.this.n;
                    while (lllllllllllllllIIlIIIIlIllllIIII-- != 0) {
                        if (Int2ObjectOpenHashMap.this.key[lllllllllllllllIIlIIIIlIllllIIII] != 0) {
                            lllllllllllllllIIlIIIIlIlllIllII.accept((Object)Int2ObjectOpenHashMap.this.value[lllllllllllllllIIlIIIIlIllllIIII]);
                        }
                    }
                }
                
                @Override
                public ObjectIterator<V> iterator() {
                    return new ValueIterator();
                }
                
                @Override
                public void clear() {
                    Int2ObjectOpenHashMap.this.clear();
                }
            };
        }
        return this.values;
    }
    
    @Override
    public V merge(final int lllllllllllllllIIIIIllIllIIlIIll, final V lllllllllllllllIIIIIllIllIIllIII, final BiFunction<? super V, ? super V, ? extends V> lllllllllllllllIIIIIllIllIIlIIIl) {
        Objects.requireNonNull(lllllllllllllllIIIIIllIllIIlIIIl);
        final int lllllllllllllllIIIIIllIllIIlIllI = this.find(lllllllllllllllIIIIIllIllIIlIIll);
        if (lllllllllllllllIIIIIllIllIIlIllI < 0 || this.value[lllllllllllllllIIIIIllIllIIlIllI] == null) {
            if (lllllllllllllllIIIIIllIllIIllIII == null) {
                return this.defRetValue;
            }
            this.insert(-lllllllllllllllIIIIIllIllIIlIllI - 1, lllllllllllllllIIIIIllIllIIlIIll, lllllllllllllllIIIIIllIllIIllIII);
            return lllllllllllllllIIIIIllIllIIllIII;
        }
        else {
            final V lllllllllllllllIIIIIllIllIIlIlIl = (V)lllllllllllllllIIIIIllIllIIlIIIl.apply((Object)this.value[lllllllllllllllIIIIIllIllIIlIllI], (Object)lllllllllllllllIIIIIllIllIIllIII);
            if (lllllllllllllllIIIIIllIllIIlIlIl == null) {
                if (lllllllllllllllIIIIIllIllIIlIIll == 0) {
                    this.removeNullEntry();
                }
                else {
                    this.removeEntry(lllllllllllllllIIIIIllIllIIlIllI);
                }
                return this.defRetValue;
            }
            return this.value[lllllllllllllllIIIIIllIllIIlIllI] = lllllllllllllllIIIIIllIllIIlIlIl;
        }
    }
    
    private V removeEntry(final int lllllllllllllllIIIIIllllIIIllIlI) {
        final V lllllllllllllllIIIIIllllIIIlllII = this.value[lllllllllllllllIIIIIllllIIIllIlI];
        this.value[lllllllllllllllIIIIIllllIIIllIlI] = null;
        --this.size;
        this.shiftKeys(lllllllllllllllIIIIIllllIIIllIlI);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return lllllllllllllllIIIIIllllIIIlllII;
    }
    
    public Int2ObjectOpenHashMap(final Int2ObjectMap<V> lllllllllllllllIIIIIllllIlIlIllI, final float lllllllllllllllIIIIIllllIlIllIII) {
        this(lllllllllllllllIIIIIllllIlIlIllI.size(), lllllllllllllllIIIIIllllIlIllIII);
        this.putAll((Map<? extends Integer, ? extends V>)lllllllllllllllIIIIIllllIlIlIllI);
    }
    
    private void insert(final int lllllllllllllllIIIIIlllIllllIlII, final int lllllllllllllllIIIIIlllIllllIIll, final V lllllllllllllllIIIIIlllIllllIIlI) {
        if (lllllllllllllllIIIIIlllIllllIlII == this.n) {
            this.containsNullKey = true;
        }
        this.key[lllllllllllllllIIIIIlllIllllIlII] = lllllllllllllllIIIIIlllIllllIIll;
        this.value[lllllllllllllllIIIIIlllIllllIlII] = lllllllllllllllIIIIIlllIllllIIlI;
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
    }
    
    private void ensureCapacity(final int lllllllllllllllIIIIIllllIIlIllll) {
        final int lllllllllllllllIIIIIllllIIlIlllI = HashCommon.arraySize(lllllllllllllllIIIIIllllIIlIllll, this.f);
        if (lllllllllllllllIIIIIllllIIlIlllI > this.n) {
            this.rehash(lllllllllllllllIIIIIllllIIlIlllI);
        }
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllIIIIIllIlIIllllII = 0;
        int lllllllllllllllIIIIIllIlIlIIIIII = this.realSize();
        int lllllllllllllllIIIIIllIlIIllllll = 0;
        int lllllllllllllllIIIIIllIlIIlllllI = 0;
        while (lllllllllllllllIIIIIllIlIlIIIIII-- != 0) {
            while (this.key[lllllllllllllllIIIIIllIlIIllllll] == 0) {
                ++lllllllllllllllIIIIIllIlIIllllll;
            }
            lllllllllllllllIIIIIllIlIIlllllI = this.key[lllllllllllllllIIIIIllIlIIllllll];
            if (this != this.value[lllllllllllllllIIIIIllIlIIllllll]) {
                lllllllllllllllIIIIIllIlIIlllllI ^= ((this.value[lllllllllllllllIIIIIllIlIIllllll] == null) ? 0 : this.value[lllllllllllllllIIIIIllIlIIllllll].hashCode());
            }
            lllllllllllllllIIIIIllIlIIllllII += lllllllllllllllIIIIIllIlIIlllllI;
            ++lllllllllllllllIIIIIllIlIIllllll;
        }
        if (this.containsNullKey) {
            lllllllllllllllIIIIIllIlIIllllII += ((this.value[this.n] == null) ? 0 : this.value[this.n].hashCode());
        }
        return lllllllllllllllIIIIIllIlIIllllII;
    }
    
    private int realSize() {
        return this.containsNullKey ? (this.size - 1) : this.size;
    }
    
    @Override
    public V compute(final int lllllllllllllllIIIIIllIllIlIlIll, final BiFunction<? super Integer, ? super V, ? extends V> lllllllllllllllIIIIIllIllIlIlIlI) {
        Objects.requireNonNull(lllllllllllllllIIIIIllIllIlIlIlI);
        final int lllllllllllllllIIIIIllIllIlIlIIl = this.find(lllllllllllllllIIIIIllIllIlIlIll);
        final V lllllllllllllllIIIIIllIllIlIlIII = (V)lllllllllllllllIIIIIllIllIlIlIlI.apply(Integer.valueOf(lllllllllllllllIIIIIllIllIlIlIll), (Object)((lllllllllllllllIIIIIllIllIlIlIIl >= 0) ? this.value[lllllllllllllllIIIIIllIllIlIlIIl] : null));
        if (lllllllllllllllIIIIIllIllIlIlIII == null) {
            if (lllllllllllllllIIIIIllIllIlIlIIl >= 0) {
                if (lllllllllllllllIIIIIllIllIlIlIll == 0) {
                    this.removeNullEntry();
                }
                else {
                    this.removeEntry(lllllllllllllllIIIIIllIllIlIlIIl);
                }
            }
            return this.defRetValue;
        }
        final V lllllllllllllllIIIIIllIllIlIIlll = lllllllllllllllIIIIIllIllIlIlIII;
        if (lllllllllllllllIIIIIllIllIlIlIIl < 0) {
            this.insert(-lllllllllllllllIIIIIllIllIlIlIIl - 1, lllllllllllllllIIIIIllIllIlIlIll, lllllllllllllllIIIIIllIllIlIIlll);
            return lllllllllllllllIIIIIllIllIlIIlll;
        }
        return this.value[lllllllllllllllIIIIIllIllIlIlIIl] = lllllllllllllllIIIIIllIllIlIIlll;
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllllIIIIIllIlIIlIIlll) throws IOException {
        final int[] lllllllllllllllIIIIIllIlIIlIlIll = this.key;
        final V[] lllllllllllllllIIIIIllIlIIlIlIlI = this.value;
        final MapIterator lllllllllllllllIIIIIllIlIIlIlIIl = new MapIterator();
        lllllllllllllllIIIIIllIlIIlIIlll.defaultWriteObject();
        int lllllllllllllllIIIIIllIlIIlIllll = this.size;
        while (lllllllllllllllIIIIIllIlIIlIllll-- != 0) {
            final int lllllllllllllllIIIIIllIlIIlIlllI = lllllllllllllllIIIIIllIlIIlIlIIl.nextEntry();
            lllllllllllllllIIIIIllIlIIlIIlll.writeInt(lllllllllllllllIIIIIllIlIIlIlIll[lllllllllllllllIIIIIllIlIIlIlllI]);
            lllllllllllllllIIIIIllIlIIlIIlll.writeObject(lllllllllllllllIIIIIllIlIIlIlIlI[lllllllllllllllIIIIIllIlIIlIlllI]);
        }
    }
    
    private class FastEntryIterator extends MapIterator implements ObjectIterator<Int2ObjectMap.Entry<V>>
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
    
    final class MapEntry implements Int2ObjectMap.Entry<V>, Map.Entry<Integer, V>
    {
        /* synthetic */ int index;
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(Int2ObjectOpenHashMap.this.key[this.index]).append("=>").append(Int2ObjectOpenHashMap.this.value[this.index]));
        }
        
        @Override
        public int hashCode() {
            return Int2ObjectOpenHashMap.this.key[this.index] ^ ((Int2ObjectOpenHashMap.this.value[this.index] == null) ? 0 : Int2ObjectOpenHashMap.this.value[this.index].hashCode());
        }
        
        MapEntry(final int llllllllllllllIIlIIIllIIllIlIIll) {
            this.index = llllllllllllllIIlIIIllIIllIlIIll;
        }
        
        @Override
        public boolean equals(final Object llllllllllllllIIlIIIllIIlIllIIll) {
            if (!(llllllllllllllIIlIIIllIIlIllIIll instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<Integer, V> llllllllllllllIIlIIIllIIlIllIlIl = (Map.Entry<Integer, V>)llllllllllllllIIlIIIllIIlIllIIll;
            return Int2ObjectOpenHashMap.this.key[this.index] == llllllllllllllIIlIIIllIIlIllIlIl.getKey() && Objects.equals(Int2ObjectOpenHashMap.this.value[this.index], llllllllllllllIIlIIIllIIlIllIlIl.getValue());
        }
        
        @Override
        public V setValue(final V llllllllllllllIIlIIIllIIlIllllll) {
            final V llllllllllllllIIlIIIllIIllIIIIIl = Int2ObjectOpenHashMap.this.value[this.index];
            Int2ObjectOpenHashMap.this.value[this.index] = llllllllllllllIIlIIIllIIlIllllll;
            return llllllllllllllIIlIIIllIIllIIIIIl;
        }
        
        @Override
        public int getIntKey() {
            return Int2ObjectOpenHashMap.this.key[this.index];
        }
        
        MapEntry() {
        }
        
        @Deprecated
        @Override
        public Integer getKey() {
            return Int2ObjectOpenHashMap.this.key[this.index];
        }
        
        @Override
        public V getValue() {
            return Int2ObjectOpenHashMap.this.value[this.index];
        }
    }
    
    private class MapIterator
    {
        /* synthetic */ int last;
        /* synthetic */ int pos;
        /* synthetic */ boolean mustReturnNullKey;
        /* synthetic */ IntArrayList wrapped;
        /* synthetic */ int c;
        
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == Int2ObjectOpenHashMap.this.n) {
                Int2ObjectOpenHashMap.this.containsNullKey = false;
                Int2ObjectOpenHashMap.this.value[Int2ObjectOpenHashMap.this.n] = null;
            }
            else {
                if (this.pos < 0) {
                    Int2ObjectOpenHashMap.this.remove(this.wrapped.getInt(-this.pos - 1));
                    this.last = -1;
                    return;
                }
                this.shiftKeys(this.last);
            }
            final Int2ObjectOpenHashMap this$0 = Int2ObjectOpenHashMap.this;
            --this$0.size;
            this.last = -1;
        }
        
        private void shiftKeys(int lllllllllllllIlIIlIIlIIIlIllIlIl) {
            final int[] lllllllllllllIlIIlIIlIIIlIllIlll = Int2ObjectOpenHashMap.this.key;
            int lllllllllllllIlIIlIIlIIIlIlllIlI = 0;
        Label_0009:
            while (true) {
                lllllllllllllIlIIlIIlIIIlIllIlIl = ((lllllllllllllIlIIlIIlIIIlIlllIlI = (int)lllllllllllllIlIIlIIlIIIlIllIlIl) + 1 & Int2ObjectOpenHashMap.this.mask);
                int lllllllllllllIlIIlIIlIIIlIlllIII;
                while ((lllllllllllllIlIIlIIlIIIlIlllIII = lllllllllllllIlIIlIIlIIIlIllIlll[lllllllllllllIlIIlIIlIIIlIllIlIl]) != 0) {
                    final int lllllllllllllIlIIlIIlIIIlIlllIIl = HashCommon.mix(lllllllllllllIlIIlIIlIIIlIlllIII) & Int2ObjectOpenHashMap.this.mask;
                    Label_0109: {
                        if (lllllllllllllIlIIlIIlIIIlIlllIlI <= lllllllllllllIlIIlIIlIIIlIllIlIl) {
                            if (lllllllllllllIlIIlIIlIIIlIlllIlI >= lllllllllllllIlIIlIIlIIIlIlllIIl) {
                                break Label_0109;
                            }
                            if (lllllllllllllIlIIlIIlIIIlIlllIIl > lllllllllllllIlIIlIIlIIIlIllIlIl) {
                                break Label_0109;
                            }
                        }
                        else if (lllllllllllllIlIIlIIlIIIlIlllIlI >= lllllllllllllIlIIlIIlIIIlIlllIIl && lllllllllllllIlIIlIIlIIIlIlllIIl > lllllllllllllIlIIlIIlIIIlIllIlIl) {
                            break Label_0109;
                        }
                        lllllllllllllIlIIlIIlIIIlIllIlIl = (lllllllllllllIlIIlIIlIIIlIllIlIl + 1 & Int2ObjectOpenHashMap.this.mask);
                        continue;
                    }
                    if (lllllllllllllIlIIlIIlIIIlIllIlIl < lllllllllllllIlIIlIIlIIIlIlllIlI) {
                        if (this.wrapped == null) {
                            this.wrapped = new IntArrayList(2);
                        }
                        this.wrapped.add(lllllllllllllIlIIlIIlIIIlIllIlll[lllllllllllllIlIIlIIlIIIlIllIlIl]);
                    }
                    lllllllllllllIlIIlIIlIIIlIllIlll[lllllllllllllIlIIlIIlIIIlIlllIlI] = lllllllllllllIlIIlIIlIIIlIlllIII;
                    Int2ObjectOpenHashMap.this.value[lllllllllllllIlIIlIIlIIIlIlllIlI] = Int2ObjectOpenHashMap.this.value[lllllllllllllIlIIlIIlIIIlIllIlIl];
                    continue Label_0009;
                }
                break;
            }
            lllllllllllllIlIIlIIlIIIlIllIlll[lllllllllllllIlIIlIIlIIIlIlllIlI] = 0;
            Int2ObjectOpenHashMap.this.value[lllllllllllllIlIIlIIlIIIlIlllIlI] = null;
        }
        
        public boolean hasNext() {
            return this.c != 0;
        }
        
        private MapIterator() {
            this.pos = Int2ObjectOpenHashMap.this.n;
            this.last = -1;
            this.c = Int2ObjectOpenHashMap.this.size;
            this.mustReturnNullKey = Int2ObjectOpenHashMap.this.containsNullKey;
        }
        
        public int skip(final int lllllllllllllIlIIlIIlIIIlIlIlIIl) {
            int lllllllllllllIlIIlIIlIIIlIlIlIII = lllllllllllllIlIIlIIlIIIlIlIlIIl;
            while (lllllllllllllIlIIlIIlIIIlIlIlIII-- != 0 && this.hasNext()) {
                this.nextEntry();
            }
            return lllllllllllllIlIIlIIlIIIlIlIlIIl - lllllllllllllIlIIlIIlIIIlIlIlIII - 1;
        }
        
        public int nextEntry() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            if (this.mustReturnNullKey) {
                this.mustReturnNullKey = false;
                final int n = Int2ObjectOpenHashMap.this.n;
                this.last = n;
                return n;
            }
            final int[] lllllllllllllIlIIlIIlIIIllIIIlll = Int2ObjectOpenHashMap.this.key;
            while (--this.pos >= 0) {
                if (lllllllllllllIlIIlIIlIIIllIIIlll[this.pos] != 0) {
                    final int pos = this.pos;
                    this.last = pos;
                    return pos;
                }
            }
            this.last = Integer.MIN_VALUE;
            int lllllllllllllIlIIlIIlIIIllIIlIlI;
            int lllllllllllllIlIIlIIlIIIllIIlIIl;
            for (lllllllllllllIlIIlIIlIIIllIIlIlI = this.wrapped.getInt(-this.pos - 1), lllllllllllllIlIIlIIlIIIllIIlIIl = (HashCommon.mix(lllllllllllllIlIIlIIlIIIllIIlIlI) & Int2ObjectOpenHashMap.this.mask); lllllllllllllIlIIlIIlIIIllIIlIlI != lllllllllllllIlIIlIIlIIIllIIIlll[lllllllllllllIlIIlIIlIIIllIIlIIl]; lllllllllllllIlIIlIIlIIIllIIlIIl = (lllllllllllllIlIIlIIlIIIllIIlIIl + 1 & Int2ObjectOpenHashMap.this.mask)) {}
            return lllllllllllllIlIIlIIlIIIllIIlIIl;
        }
    }
    
    private final class ValueIterator extends MapIterator implements ObjectIterator<V>
    {
        public ValueIterator() {
        }
        
        @Override
        public V next() {
            return Int2ObjectOpenHashMap.this.value[this.nextEntry()];
        }
    }
    
    private final class KeyIterator extends MapIterator implements IntIterator
    {
        @Override
        public int nextInt() {
            return Int2ObjectOpenHashMap.this.key[this.nextEntry()];
        }
        
        public KeyIterator() {
        }
    }
    
    private final class KeySet extends AbstractIntSet
    {
        @Override
        public boolean remove(final int lllllllllllllIllIIIlIlIIIlllllll) {
            final int lllllllllllllIllIIIlIlIIlIIIIIIl = Int2ObjectOpenHashMap.this.size;
            Int2ObjectOpenHashMap.this.remove(lllllllllllllIllIIIlIlIIIlllllll);
            return Int2ObjectOpenHashMap.this.size != lllllllllllllIllIIIlIlIIlIIIIIIl;
        }
        
        @Override
        public boolean contains(final int lllllllllllllIllIIIlIlIIlIIIlIIl) {
            return Int2ObjectOpenHashMap.this.containsKey(lllllllllllllIllIIIlIlIIlIIIlIIl);
        }
        
        @Override
        public void clear() {
            Int2ObjectOpenHashMap.this.clear();
        }
        
        @Override
        public int size() {
            return Int2ObjectOpenHashMap.this.size;
        }
        
        @Override
        public IntIterator iterator() {
            return new KeyIterator();
        }
        
        @Override
        public void forEach(final IntConsumer lllllllllllllIllIIIlIlIIlIIlIlII) {
            if (Int2ObjectOpenHashMap.this.containsNullKey) {
                lllllllllllllIllIIIlIlIIlIIlIlII.accept(Int2ObjectOpenHashMap.this.key[Int2ObjectOpenHashMap.this.n]);
            }
            int lllllllllllllIllIIIlIlIIlIIlIllI = Int2ObjectOpenHashMap.this.n;
            while (lllllllllllllIllIIIlIlIIlIIlIllI-- != 0) {
                final int lllllllllllllIllIIIlIlIIlIIlIlll = Int2ObjectOpenHashMap.this.key[lllllllllllllIllIIIlIlIIlIIlIllI];
                if (lllllllllllllIllIIIlIlIIlIIlIlll != 0) {
                    lllllllllllllIllIIIlIlIIlIIlIlII.accept(lllllllllllllIllIIIlIlIIlIIlIlll);
                }
            }
        }
    }
    
    private final class MapEntrySet extends AbstractObjectSet<Int2ObjectMap.Entry<V>> implements Int2ObjectMap.FastEntrySet<V>
    {
        @Override
        public ObjectIterator<Int2ObjectMap.Entry<V>> fastIterator() {
            return new FastEntryIterator();
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIlIIllllIIIIlllIIlI) {
            if (!(lllllllllllllIlIIllllIIIIlllIIlI instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIlIIllllIIIIllllIIl = (Map.Entry<?, ?>)lllllllllllllIlIIllllIIIIlllIIlI;
            if (lllllllllllllIlIIllllIIIIllllIIl.getKey() == null || !(lllllllllllllIlIIllllIIIIllllIIl.getKey() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIlIIllllIIIIllllIII = (int)lllllllllllllIlIIllllIIIIllllIIl.getKey();
            final V lllllllllllllIlIIllllIIIIlllIlll = (V)lllllllllllllIlIIllllIIIIllllIIl.getValue();
            if (lllllllllllllIlIIllllIIIIllllIII == 0) {
                if (Int2ObjectOpenHashMap.this.containsNullKey && Objects.equals(Int2ObjectOpenHashMap.this.value[Int2ObjectOpenHashMap.this.n], lllllllllllllIlIIllllIIIIlllIlll)) {
                    Int2ObjectOpenHashMap.this.removeNullEntry();
                    return true;
                }
                return false;
            }
            else {
                final int[] lllllllllllllIlIIllllIIIIlllIlIl = Int2ObjectOpenHashMap.this.key;
                int lllllllllllllIlIIllllIIIIlllIlII;
                int lllllllllllllIlIIllllIIIIlllIllI;
                if ((lllllllllllllIlIIllllIIIIlllIllI = lllllllllllllIlIIllllIIIIlllIlIl[lllllllllllllIlIIllllIIIIlllIlII = (HashCommon.mix(lllllllllllllIlIIllllIIIIllllIII) & Int2ObjectOpenHashMap.this.mask)]) == 0) {
                    return false;
                }
                if (lllllllllllllIlIIllllIIIIlllIllI != lllllllllllllIlIIllllIIIIllllIII) {
                    while ((lllllllllllllIlIIllllIIIIlllIllI = lllllllllllllIlIIllllIIIIlllIlIl[lllllllllllllIlIIllllIIIIlllIlII = (lllllllllllllIlIIllllIIIIlllIlII + 1 & Int2ObjectOpenHashMap.this.mask)]) != 0) {
                        if (lllllllllllllIlIIllllIIIIlllIllI == lllllllllllllIlIIllllIIIIllllIII && Objects.equals(Int2ObjectOpenHashMap.this.value[lllllllllllllIlIIllllIIIIlllIlII], lllllllllllllIlIIllllIIIIlllIlll)) {
                            Int2ObjectOpenHashMap.this.removeEntry(lllllllllllllIlIIllllIIIIlllIlII);
                            return true;
                        }
                    }
                    return false;
                }
                if (Objects.equals(Int2ObjectOpenHashMap.this.value[lllllllllllllIlIIllllIIIIlllIlII], lllllllllllllIlIIllllIIIIlllIlll)) {
                    Int2ObjectOpenHashMap.this.removeEntry(lllllllllllllIlIIllllIIIIlllIlII);
                    return true;
                }
                return false;
            }
        }
        
        @Override
        public ObjectIterator<Int2ObjectMap.Entry<V>> iterator() {
            return new EntryIterator();
        }
        
        @Override
        public int size() {
            return Int2ObjectOpenHashMap.this.size;
        }
        
        @Override
        public void fastForEach(final Consumer<? super Int2ObjectMap.Entry<V>> lllllllllllllIlIIllllIIIIlIlIIll) {
            final BasicEntry<V> lllllllllllllIlIIllllIIIIlIlIlIl = new BasicEntry<V>();
            if (Int2ObjectOpenHashMap.this.containsNullKey) {
                lllllllllllllIlIIllllIIIIlIlIlIl.key = Int2ObjectOpenHashMap.this.key[Int2ObjectOpenHashMap.this.n];
                lllllllllllllIlIIllllIIIIlIlIlIl.value = Int2ObjectOpenHashMap.this.value[Int2ObjectOpenHashMap.this.n];
                lllllllllllllIlIIllllIIIIlIlIIll.accept(lllllllllllllIlIIllllIIIIlIlIlIl);
            }
            int lllllllllllllIlIIllllIIIIlIllIII = Int2ObjectOpenHashMap.this.n;
            while (lllllllllllllIlIIllllIIIIlIllIII-- != 0) {
                if (Int2ObjectOpenHashMap.this.key[lllllllllllllIlIIllllIIIIlIllIII] != 0) {
                    lllllllllllllIlIIllllIIIIlIlIlIl.key = Int2ObjectOpenHashMap.this.key[lllllllllllllIlIIllllIIIIlIllIII];
                    lllllllllllllIlIIllllIIIIlIlIlIl.value = Int2ObjectOpenHashMap.this.value[lllllllllllllIlIIllllIIIIlIllIII];
                    lllllllllllllIlIIllllIIIIlIlIIll.accept(lllllllllllllIlIIllllIIIIlIlIlIl);
                }
            }
        }
        
        @Override
        public void clear() {
            Int2ObjectOpenHashMap.this.clear();
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIlIIllllIIIlIIIlIlI) {
            if (!(lllllllllllllIlIIllllIIIlIIIlIlI instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIlIIllllIIIlIIlIIIl = (Map.Entry<?, ?>)lllllllllllllIlIIllllIIIlIIIlIlI;
            if (lllllllllllllIlIIllllIIIlIIlIIIl.getKey() == null || !(lllllllllllllIlIIllllIIIlIIlIIIl.getKey() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIlIIllllIIIlIIlIIII = (int)lllllllllllllIlIIllllIIIlIIlIIIl.getKey();
            final V lllllllllllllIlIIllllIIIlIIIllll = (V)lllllllllllllIlIIllllIIIlIIlIIIl.getValue();
            if (lllllllllllllIlIIllllIIIlIIlIIII == 0) {
                return Int2ObjectOpenHashMap.this.containsNullKey && Objects.equals(Int2ObjectOpenHashMap.this.value[Int2ObjectOpenHashMap.this.n], lllllllllllllIlIIllllIIIlIIIllll);
            }
            final int[] lllllllllllllIlIIllllIIIlIIIllIl = Int2ObjectOpenHashMap.this.key;
            int lllllllllllllIlIIllllIIIlIIIllII;
            int lllllllllllllIlIIllllIIIlIIIlllI;
            if ((lllllllllllllIlIIllllIIIlIIIlllI = lllllllllllllIlIIllllIIIlIIIllIl[lllllllllllllIlIIllllIIIlIIIllII = (HashCommon.mix(lllllllllllllIlIIllllIIIlIIlIIII) & Int2ObjectOpenHashMap.this.mask)]) == 0) {
                return false;
            }
            if (lllllllllllllIlIIllllIIIlIIlIIII == lllllllllllllIlIIllllIIIlIIIlllI) {
                return Objects.equals(Int2ObjectOpenHashMap.this.value[lllllllllllllIlIIllllIIIlIIIllII], lllllllllllllIlIIllllIIIlIIIllll);
            }
            while ((lllllllllllllIlIIllllIIIlIIIlllI = lllllllllllllIlIIllllIIIlIIIllIl[lllllllllllllIlIIllllIIIlIIIllII = (lllllllllllllIlIIllllIIIlIIIllII + 1 & Int2ObjectOpenHashMap.this.mask)]) != 0) {
                if (lllllllllllllIlIIllllIIIlIIlIIII == lllllllllllllIlIIllllIIIlIIIlllI) {
                    return Objects.equals(Int2ObjectOpenHashMap.this.value[lllllllllllllIlIIllllIIIlIIIllII], lllllllllllllIlIIllllIIIlIIIllll);
                }
            }
            return false;
        }
        
        @Override
        public void forEach(final Consumer<? super Int2ObjectMap.Entry<V>> lllllllllllllIlIIllllIIIIlIllllI) {
            if (Int2ObjectOpenHashMap.this.containsNullKey) {
                lllllllllllllIlIIllllIIIIlIllllI.accept((Object)new BasicEntry(Int2ObjectOpenHashMap.this.key[Int2ObjectOpenHashMap.this.n], (V)Int2ObjectOpenHashMap.this.value[Int2ObjectOpenHashMap.this.n]));
            }
            int lllllllllllllIlIIllllIIIIllIIIlI = Int2ObjectOpenHashMap.this.n;
            while (lllllllllllllIlIIllllIIIIllIIIlI-- != 0) {
                if (Int2ObjectOpenHashMap.this.key[lllllllllllllIlIIllllIIIIllIIIlI] != 0) {
                    lllllllllllllIlIIllllIIIIlIllllI.accept((Object)new BasicEntry(Int2ObjectOpenHashMap.this.key[lllllllllllllIlIIllllIIIIllIIIlI], (V)Int2ObjectOpenHashMap.this.value[lllllllllllllIlIIllllIIIIllIIIlI]));
                }
            }
        }
    }
    
    private class EntryIterator extends MapIterator implements ObjectIterator<Int2ObjectMap.Entry<V>>
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
}
