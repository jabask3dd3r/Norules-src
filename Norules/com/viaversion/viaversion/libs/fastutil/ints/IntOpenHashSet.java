package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import java.util.*;

public class IntOpenHashSet extends AbstractIntSet implements Cloneable, Serializable, Hash
{
    protected final /* synthetic */ float f;
    protected transient /* synthetic */ boolean containsNull;
    protected transient /* synthetic */ int n;
    protected final transient /* synthetic */ int minN;
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ int[] key;
    protected /* synthetic */ int size;
    protected transient /* synthetic */ int mask;
    
    public IntOpenHashSet(final int[] lllllllllllllIIIlIlllIIIllIIllII, final int lllllllllllllIIIlIlllIIIllIlIIII, final int lllllllllllllIIIlIlllIIIllIIlIlI, final float lllllllllllllIIIlIlllIIIllIIlIIl) {
        this((lllllllllllllIIIlIlllIIIllIIlIlI < 0) ? 0 : lllllllllllllIIIlIlllIIIllIIlIlI, lllllllllllllIIIlIlllIIIllIIlIIl);
        IntArrays.ensureOffsetLength(lllllllllllllIIIlIlllIIIllIIllII, lllllllllllllIIIlIlllIIIllIlIIII, lllllllllllllIIIlIlllIIIllIIlIlI);
        for (int lllllllllllllIIIlIlllIIIllIlIIll = 0; lllllllllllllIIIlIlllIIIllIlIIll < lllllllllllllIIIlIlllIIIllIIlIlI; ++lllllllllllllIIIlIlllIIIllIlIIll) {
            this.add(lllllllllllllIIIlIlllIIIllIIllII[lllllllllllllIIIlIlllIIIllIlIIII + lllllllllllllIIIlIlllIIIllIlIIll]);
        }
    }
    
    @Override
    public boolean add(final int lllllllllllllIIIlIlllIIIlIIIIIlI) {
        if (lllllllllllllIIIlIlllIIIlIIIIIlI == 0) {
            if (this.containsNull) {
                return false;
            }
            this.containsNull = true;
        }
        else {
            final int[] lllllllllllllIIIlIlllIIIlIIIIlIl = this.key;
            int lllllllllllllIIIlIlllIIIlIIIIlII;
            int lllllllllllllIIIlIlllIIIlIIIIllI;
            if ((lllllllllllllIIIlIlllIIIlIIIIllI = lllllllllllllIIIlIlllIIIlIIIIlIl[lllllllllllllIIIlIlllIIIlIIIIlII = (HashCommon.mix(lllllllllllllIIIlIlllIIIlIIIIIlI) & this.mask)]) != 0) {
                if (lllllllllllllIIIlIlllIIIlIIIIllI == lllllllllllllIIIlIlllIIIlIIIIIlI) {
                    return false;
                }
                while ((lllllllllllllIIIlIlllIIIlIIIIllI = lllllllllllllIIIlIlllIIIlIIIIlIl[lllllllllllllIIIlIlllIIIlIIIIlII = (lllllllllllllIIIlIlllIIIlIIIIlII + 1 & this.mask)]) != 0) {
                    if (lllllllllllllIIIlIlllIIIlIIIIllI == lllllllllllllIIIlIlllIIIlIIIIIlI) {
                        return false;
                    }
                }
            }
            lllllllllllllIIIlIlllIIIlIIIIlIl[lllllllllllllIIIlIlllIIIlIIIIlII] = lllllllllllllIIIlIlllIIIlIIIIIlI;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return true;
    }
    
    public boolean trim(final int lllllllllllllIIIlIlllIIIIIlIlllI) {
        final int lllllllllllllIIIlIlllIIIIIlIllIl = HashCommon.nextPowerOfTwo((int)Math.ceil(lllllllllllllIIIlIlllIIIIIlIlllI / this.f));
        if (lllllllllllllIIIlIlllIIIIIlIllIl >= this.n || this.size > HashCommon.maxFill(lllllllllllllIIIlIlllIIIIIlIllIl, this.f)) {
            return true;
        }
        try {
            this.rehash(lllllllllllllIIIlIlllIIIIIlIllIl);
        }
        catch (OutOfMemoryError lllllllllllllIIIlIlllIIIIIllIIII) {
            return false;
        }
        return true;
    }
    
    public IntOpenHashSet(final Iterator<?> lllllllllllllIIIlIlllIIIllIlllII) {
        this(IntIterators.asIntIterator(lllllllllllllIIIlIlllIIIllIlllII));
    }
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNull = false;
        Arrays.fill(this.key, 0);
    }
    
    public IntOpenHashSet(final int[] lllllllllllllIIIlIlllIIIlIlIllll) {
        this(lllllllllllllIIIlIlllIIIlIlIllll, 0.75f);
    }
    
    public IntOpenHashSet() {
        this(16, 0.75f);
    }
    
    @Override
    public IntIterator iterator() {
        return new SetIterator();
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public IntOpenHashSet(final IntIterator lllllllllllllIIIlIlllIIIllllIIll, final float lllllllllllllIIIlIlllIIIllllIIlI) {
        this(16, lllllllllllllIIIlIlllIIIllllIIlI);
        while (lllllllllllllIIIlIlllIIIllllIIll.hasNext()) {
            this.add(lllllllllllllIIIlIlllIIIllllIIll.nextInt());
        }
    }
    
    public IntOpenHashSet(final int lllllllllllllIIIlIlllIIlIIIllIIl) {
        this(lllllllllllllIIIlIlllIIlIIIllIIl, 0.75f);
    }
    
    public IntOpenHashSet(final int lllllllllllllIIIlIlllIIlIIlIIIII, final float lllllllllllllIIIlIlllIIlIIlIIIlI) {
        if (lllllllllllllIIIlIlllIIlIIlIIIlI <= 0.0f || lllllllllllllIIIlIlllIIlIIlIIIlI > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (lllllllllllllIIIlIlllIIlIIlIIIII < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = lllllllllllllIIIlIlllIIlIIlIIIlI;
        final int arraySize = HashCommon.arraySize(lllllllllllllIIIlIlllIIlIIlIIIII, lllllllllllllIIIlIlllIIlIIlIIIlI);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, lllllllllllllIIIlIlllIIlIIlIIIlI);
        this.key = new int[this.n + 1];
    }
    
    public IntOpenHashSet(final Collection<? extends Integer> lllllllllllllIIIlIlllIIlIIIlIIIl, final float lllllllllllllIIIlIlllIIlIIIIllIl) {
        this(lllllllllllllIIIlIlllIIlIIIlIIIl.size(), lllllllllllllIIIlIlllIIlIIIIllIl);
        this.addAll(lllllllllllllIIIlIlllIIlIIIlIIIl);
    }
    
    protected void rehash(final int lllllllllllllIIIlIlllIIIIIIlIlll) {
        final int[] lllllllllllllIIIlIlllIIIIIIlllII = this.key;
        final int lllllllllllllIIIlIlllIIIIIIllIll = lllllllllllllIIIlIlllIIIIIIlIlll - 1;
        final int[] lllllllllllllIIIlIlllIIIIIIllIlI = new int[lllllllllllllIIIlIlllIIIIIIlIlll + 1];
        int lllllllllllllIIIlIlllIIIIIIllIIl = this.n;
        int lllllllllllllIIIlIlllIIIIIIlllll = this.realSize();
        while (lllllllllllllIIIlIlllIIIIIIlllll-- != 0) {
            while (lllllllllllllIIIlIlllIIIIIIlllII[--lllllllllllllIIIlIlllIIIIIIllIIl] == 0) {}
            int lllllllllllllIIIlIlllIIIIIlIIIII;
            if (lllllllllllllIIIlIlllIIIIIIllIlI[lllllllllllllIIIlIlllIIIIIlIIIII = (HashCommon.mix(lllllllllllllIIIlIlllIIIIIIlllII[lllllllllllllIIIlIlllIIIIIIllIIl]) & lllllllllllllIIIlIlllIIIIIIllIll)] != 0) {
                while (lllllllllllllIIIlIlllIIIIIIllIlI[lllllllllllllIIIlIlllIIIIIlIIIII = (lllllllllllllIIIlIlllIIIIIlIIIII + 1 & lllllllllllllIIIlIlllIIIIIIllIll)] != 0) {}
            }
            lllllllllllllIIIlIlllIIIIIIllIlI[lllllllllllllIIIlIlllIIIIIlIIIII] = lllllllllllllIIIlIlllIIIIIIlllII[lllllllllllllIIIlIlllIIIIIIllIIl];
        }
        this.n = lllllllllllllIIIlIlllIIIIIIlIlll;
        this.mask = lllllllllllllIIIlIlllIIIIIIllIll;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = lllllllllllllIIIlIlllIIIIIIllIlI;
    }
    
    protected final void shiftKeys(int lllllllllllllIIIlIlllIIIIllIllll) {
        final int[] lllllllllllllIIIlIlllIIIIlllIIIl = this.key;
        int lllllllllllllIIIlIlllIIIIlllIlII = 0;
    Label_0006:
        while (true) {
            lllllllllllllIIIlIlllIIIIllIllll = ((lllllllllllllIIIlIlllIIIIlllIlII = lllllllllllllIIIlIlllIIIIllIllll) + 1 & this.mask);
            int lllllllllllllIIIlIlllIIIIlllIIlI;
            while ((lllllllllllllIIIlIlllIIIIlllIIlI = lllllllllllllIIIlIlllIIIIlllIIIl[lllllllllllllIIIlIlllIIIIllIllll]) != 0) {
                final int lllllllllllllIIIlIlllIIIIlllIIll = HashCommon.mix(lllllllllllllIIIlIlllIIIIlllIIlI) & this.mask;
                Label_0087: {
                    if (lllllllllllllIIIlIlllIIIIlllIlII <= lllllllllllllIIIlIlllIIIIllIllll) {
                        if (lllllllllllllIIIlIlllIIIIlllIlII >= lllllllllllllIIIlIlllIIIIlllIIll) {
                            break Label_0087;
                        }
                        if (lllllllllllllIIIlIlllIIIIlllIIll > lllllllllllllIIIlIlllIIIIllIllll) {
                            break Label_0087;
                        }
                    }
                    else if (lllllllllllllIIIlIlllIIIIlllIlII >= lllllllllllllIIIlIlllIIIIlllIIll && lllllllllllllIIIlIlllIIIIlllIIll > lllllllllllllIIIlIlllIIIIllIllll) {
                        break Label_0087;
                    }
                    lllllllllllllIIIlIlllIIIIllIllll = (lllllllllllllIIIlIlllIIIIllIllll + 1 & this.mask);
                    continue;
                }
                lllllllllllllIIIlIlllIIIIlllIIIl[lllllllllllllIIIlIlllIIIIlllIlII] = lllllllllllllIIIlIlllIIIIlllIIlI;
                continue Label_0006;
            }
            break;
        }
        lllllllllllllIIIlIlllIIIIlllIIIl[lllllllllllllIIIlIlllIIIIlllIlII] = 0;
    }
    
    public IntOpenHashSet clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/ints/IntOpenHashSet;
        //     7: astore_1        /* lllllllllllllIIIlIlllIIIIIIIllIl */
        //     8: goto            20
        //    11: astore_2        /* lllllllllllllIIIlIlllIIIIIIIllII */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllllIIIlIlllIIIIIIIlIlI */
        //    21: aload_0         /* lllllllllllllIIIlIlllIIIIIIIlIIl */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/ints/IntOpenHashSet.key:[I
        //    25: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    28: checkcast       [I
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/ints/IntOpenHashSet.key:[I
        //    34: aload_1         /* lllllllllllllIIIlIlllIIIIIIIlIlI */
        //    35: aload_0         /* lllllllllllllIIIlIlllIIIIIIIlIIl */
        //    36: getfield        com/viaversion/viaversion/libs/fastutil/ints/IntOpenHashSet.containsNull:Z
        //    39: putfield        com/viaversion/viaversion/libs/fastutil/ints/IntOpenHashSet.containsNull:Z
        //    42: aload_1         /* lllllllllllllIIIlIlllIIIIIIIlIlI */
        //    43: areturn        
        //    StackMapTable: 00 02 4B 07 01 13 FC 00 08 07 00 02
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
    public boolean addAll(final IntCollection lllllllllllllIIIlIlllIIIlIIlIIlI) {
        if (this.f <= 0.5) {
            this.ensureCapacity(lllllllllllllIIIlIlllIIIlIIlIIlI.size());
        }
        else {
            this.tryCapacity(this.size() + lllllllllllllIIIlIlllIIIlIIlIIlI.size());
        }
        return super.addAll(lllllllllllllIIIlIlllIIIlIIlIIlI);
    }
    
    @Override
    public boolean addAll(final Collection<? extends Integer> lllllllllllllIIIlIlllIIIlIIIllII) {
        if (this.f <= 0.5) {
            this.ensureCapacity(lllllllllllllIIIlIlllIIIlIIIllII.size());
        }
        else {
            this.tryCapacity(this.size() + lllllllllllllIIIlIlllIIIlIIIllII.size());
        }
        return super.addAll(lllllllllllllIIIlIlllIIIlIIIllII);
    }
    
    public IntOpenHashSet(final int[] lllllllllllllIIIlIlllIIIlIlllllI, final int lllllllllllllIIIlIlllIIIlIllllIl, final int lllllllllllllIIIlIlllIIIlIllllII) {
        this(lllllllllllllIIIlIlllIIIlIlllllI, lllllllllllllIIIlIlllIIIlIllllIl, lllllllllllllIIIlIlllIIIlIllllII, 0.75f);
    }
    
    static {
        ASSERTS = false;
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    public IntOpenHashSet(final IntCollection lllllllllllllIIIlIlllIIIlllllIII) {
        this(lllllllllllllIIIlIlllIIIlllllIII, 0.75f);
    }
    
    private boolean removeEntry(final int lllllllllllllIIIlIlllIIIIllIIlIl) {
        --this.size;
        this.shiftKeys(lllllllllllllIIIlIlllIIIIllIIlIl);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }
    
    private void checkTable() {
    }
    
    private void ensureCapacity(final int lllllllllllllIIIlIlllIIIlIlIIlIl) {
        final int lllllllllllllIIIlIlllIIIlIlIIlII = HashCommon.arraySize(lllllllllllllIIIlIlllIIIlIlIIlIl, this.f);
        if (lllllllllllllIIIlIlllIIIlIlIIlII > this.n) {
            this.rehash(lllllllllllllIIIlIlllIIIlIlIIlII);
        }
    }
    
    @Override
    public boolean contains(final int lllllllllllllIIIlIlllIIIIlIIIlll) {
        if (lllllllllllllIIIlIlllIIIIlIIIlll == 0) {
            return this.containsNull;
        }
        final int[] lllllllllllllIIIlIlllIIIIlIIlIlI = this.key;
        int lllllllllllllIIIlIlllIIIIlIIlIIl;
        int lllllllllllllIIIlIlllIIIIlIIlIll;
        if ((lllllllllllllIIIlIlllIIIIlIIlIll = lllllllllllllIIIlIlllIIIIlIIlIlI[lllllllllllllIIIlIlllIIIIlIIlIIl = (HashCommon.mix(lllllllllllllIIIlIlllIIIIlIIIlll) & this.mask)]) == 0) {
            return false;
        }
        if (lllllllllllllIIIlIlllIIIIlIIIlll == lllllllllllllIIIlIlllIIIIlIIlIll) {
            return true;
        }
        while ((lllllllllllllIIIlIlllIIIIlIIlIll = lllllllllllllIIIlIlllIIIIlIIlIlI[lllllllllllllIIIlIlllIIIIlIIlIIl = (lllllllllllllIIIlIlllIIIIlIIlIIl + 1 & this.mask)]) != 0) {
            if (lllllllllllllIIIlIlllIIIIlIIIlll == lllllllllllllIIIlIlllIIIIlIIlIll) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIlIllIlllllllllll = 0;
        int lllllllllllllIIIlIlllIIIIIIIIIlI = this.realSize();
        int lllllllllllllIIIlIlllIIIIIIIIIIl = 0;
        while (lllllllllllllIIIlIlllIIIIIIIIIlI-- != 0) {
            while (this.key[lllllllllllllIIIlIlllIIIIIIIIIIl] == 0) {
                ++lllllllllllllIIIlIlllIIIIIIIIIIl;
            }
            lllllllllllllIIIlIllIlllllllllll += this.key[lllllllllllllIIIlIlllIIIIIIIIIIl];
            ++lllllllllllllIIIlIlllIIIIIIIIIIl;
        }
        return lllllllllllllIIIlIllIlllllllllll;
    }
    
    @Override
    public boolean remove(final int lllllllllllllIIIlIlllIIIIlIlIllI) {
        if (lllllllllllllIIIlIlllIIIIlIlIllI == 0) {
            return this.containsNull && this.removeNullEntry();
        }
        final int[] lllllllllllllIIIlIlllIIIIlIllIIl = this.key;
        int lllllllllllllIIIlIlllIIIIlIllIII;
        int lllllllllllllIIIlIlllIIIIlIllIlI;
        if ((lllllllllllllIIIlIlllIIIIlIllIlI = lllllllllllllIIIlIlllIIIIlIllIIl[lllllllllllllIIIlIlllIIIIlIllIII = (HashCommon.mix(lllllllllllllIIIlIlllIIIIlIlIllI) & this.mask)]) == 0) {
            return false;
        }
        if (lllllllllllllIIIlIlllIIIIlIlIllI == lllllllllllllIIIlIlllIIIIlIllIlI) {
            return this.removeEntry(lllllllllllllIIIlIlllIIIIlIllIII);
        }
        while ((lllllllllllllIIIlIlllIIIIlIllIlI = lllllllllllllIIIlIlllIIIIlIllIIl[lllllllllllllIIIlIlllIIIIlIllIII = (lllllllllllllIIIlIlllIIIIlIllIII + 1 & this.mask)]) != 0) {
            if (lllllllllllllIIIlIlllIIIIlIlIllI == lllllllllllllIIIlIlllIIIIlIllIlI) {
                return this.removeEntry(lllllllllllllIIIlIlllIIIIlIllIII);
            }
        }
        return false;
    }
    
    public IntOpenHashSet(final int[] lllllllllllllIIIlIlllIIIlIllIlll, final float lllllllllllllIIIlIlllIIIlIllIllI) {
        this(lllllllllllllIIIlIlllIIIlIllIlll, 0, lllllllllllllIIIlIlllIIIlIllIlll.length, lllllllllllllIIIlIlllIIIlIllIllI);
    }
    
    private void tryCapacity(final long lllllllllllllIIIlIlllIIIlIIlllII) {
        final int lllllllllllllIIIlIlllIIIlIIllIll = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(lllllllllllllIIIlIlllIIIlIIlllII / this.f))));
        if (lllllllllllllIIIlIlllIIIlIIllIll > this.n) {
            this.rehash(lllllllllllllIIIlIlllIIIlIIllIll);
        }
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.n] = 0;
        --this.size;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }
    
    public IntOpenHashSet(final Iterator<?> lllllllllllllIIIlIlllIIIlllIIlII, final float lllllllllllllIIIlIlllIIIlllIIIII) {
        this(IntIterators.asIntIterator(lllllllllllllIIIlIlllIIIlllIIlII), lllllllllllllIIIlIlllIIIlllIIIII);
    }
    
    public IntOpenHashSet(final Collection<? extends Integer> lllllllllllllIIIlIlllIIlIIIIlIIl) {
        this(lllllllllllllIIIlIlllIIlIIIIlIIl, 0.75f);
    }
    
    public IntOpenHashSet(final IntIterator lllllllllllllIIIlIlllIIIlllIlIIl) {
        this(lllllllllllllIIIlIlllIIIlllIlIIl, 0.75f);
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllIIIlIllIlllllllIIIl) throws IOException {
        final IntIterator lllllllllllllIIIlIllIlllllllIIll = this.iterator();
        lllllllllllllIIIlIllIlllllllIIIl.defaultWriteObject();
        int lllllllllllllIIIlIllIlllllllIllI = this.size;
        while (lllllllllllllIIIlIllIlllllllIllI-- != 0) {
            lllllllllllllIIIlIllIlllllllIIIl.writeInt(lllllllllllllIIIlIllIlllllllIIll.nextInt());
        }
    }
    
    private int realSize() {
        return this.containsNull ? (this.size - 1) : this.size;
    }
    
    private void readObject(final ObjectInputStream lllllllllllllIIIlIllIllllllIIIll) throws ClassNotFoundException, IOException {
        lllllllllllllIIIlIllIllllllIIIll.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final int[] key = new int[this.n + 1];
        this.key = key;
        final int[] lllllllllllllIIIlIllIllllllIIIlI = key;
        int lllllllllllllIIIlIllIllllllIIllI = this.size;
        while (lllllllllllllIIIlIllIllllllIIllI-- != 0) {
            final int lllllllllllllIIIlIllIllllllIIlll = lllllllllllllIIIlIllIllllllIIIll.readInt();
            int lllllllllllllIIIlIllIllllllIIlIl = 0;
            if (lllllllllllllIIIlIllIllllllIIlll == 0) {
                final int lllllllllllllIIIlIllIllllllIlIII = this.n;
                this.containsNull = true;
            }
            else if (lllllllllllllIIIlIllIllllllIIIlI[lllllllllllllIIIlIllIllllllIIlIl = (HashCommon.mix(lllllllllllllIIIlIllIllllllIIlll) & this.mask)] != 0) {
                while (lllllllllllllIIIlIllIllllllIIIlI[lllllllllllllIIIlIllIllllllIIlIl = (lllllllllllllIIIlIllIllllllIIlIl + 1 & this.mask)] != 0) {}
            }
            lllllllllllllIIIlIllIllllllIIIlI[lllllllllllllIIIlIllIllllllIIlIl] = lllllllllllllIIIlIllIllllllIIlll;
        }
    }
    
    public IntOpenHashSet(final IntCollection lllllllllllllIIIlIlllIIlIIIIIIlI, final float lllllllllllllIIIlIlllIIIlllllllI) {
        this(lllllllllllllIIIlIlllIIlIIIIIIlI.size(), lllllllllllllIIIlIlllIIIlllllllI);
        this.addAll(lllllllllllllIIIlIlllIIlIIIIIIlI);
    }
    
    private class SetIterator implements IntIterator
    {
        /* synthetic */ int last;
        /* synthetic */ int pos;
        /* synthetic */ boolean mustReturnNull;
        /* synthetic */ IntArrayList wrapped;
        /* synthetic */ int c;
        
        @Override
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == IntOpenHashSet.this.n) {
                IntOpenHashSet.this.containsNull = false;
                IntOpenHashSet.this.key[IntOpenHashSet.this.n] = 0;
            }
            else {
                if (this.pos < 0) {
                    IntOpenHashSet.this.remove(this.wrapped.getInt(-this.pos - 1));
                    this.last = -1;
                    return;
                }
                this.shiftKeys(this.last);
            }
            final IntOpenHashSet this$0 = IntOpenHashSet.this;
            --this$0.size;
            this.last = -1;
        }
        
        private SetIterator() {
            this.pos = IntOpenHashSet.this.n;
            this.last = -1;
            this.c = IntOpenHashSet.this.size;
            this.mustReturnNull = IntOpenHashSet.this.containsNull;
        }
        
        private final void shiftKeys(int lllllllllllllIlIlIIIIIIIIIIlIIII) {
            final int[] lllllllllllllIlIlIIIIIIIIIIlIIlI = IntOpenHashSet.this.key;
            int lllllllllllllIlIlIIIIIIIIIIlIlIl = 0;
        Label_0009:
            while (true) {
                lllllllllllllIlIlIIIIIIIIIIlIIII = ((lllllllllllllIlIlIIIIIIIIIIlIlIl = (int)lllllllllllllIlIlIIIIIIIIIIlIIII) + 1 & IntOpenHashSet.this.mask);
                int lllllllllllllIlIlIIIIIIIIIIlIIll;
                while ((lllllllllllllIlIlIIIIIIIIIIlIIll = lllllllllllllIlIlIIIIIIIIIIlIIlI[lllllllllllllIlIlIIIIIIIIIIlIIII]) != 0) {
                    final int lllllllllllllIlIlIIIIIIIIIIlIlII = HashCommon.mix(lllllllllllllIlIlIIIIIIIIIIlIIll) & IntOpenHashSet.this.mask;
                    Label_0099: {
                        if (lllllllllllllIlIlIIIIIIIIIIlIlIl <= lllllllllllllIlIlIIIIIIIIIIlIIII) {
                            if (lllllllllllllIlIlIIIIIIIIIIlIlIl >= lllllllllllllIlIlIIIIIIIIIIlIlII) {
                                break Label_0099;
                            }
                            if (lllllllllllllIlIlIIIIIIIIIIlIlII > lllllllllllllIlIlIIIIIIIIIIlIIII) {
                                break Label_0099;
                            }
                        }
                        else if (lllllllllllllIlIlIIIIIIIIIIlIlIl >= lllllllllllllIlIlIIIIIIIIIIlIlII && lllllllllllllIlIlIIIIIIIIIIlIlII > lllllllllllllIlIlIIIIIIIIIIlIIII) {
                            break Label_0099;
                        }
                        lllllllllllllIlIlIIIIIIIIIIlIIII = (lllllllllllllIlIlIIIIIIIIIIlIIII + 1 & IntOpenHashSet.this.mask);
                        continue;
                    }
                    if (lllllllllllllIlIlIIIIIIIIIIlIIII < lllllllllllllIlIlIIIIIIIIIIlIlIl) {
                        if (this.wrapped == null) {
                            this.wrapped = new IntArrayList(2);
                        }
                        this.wrapped.add(lllllllllllllIlIlIIIIIIIIIIlIIlI[lllllllllllllIlIlIIIIIIIIIIlIIII]);
                    }
                    lllllllllllllIlIlIIIIIIIIIIlIIlI[lllllllllllllIlIlIIIIIIIIIIlIlIl] = lllllllllllllIlIlIIIIIIIIIIlIIll;
                    continue Label_0009;
                }
                break;
            }
            lllllllllllllIlIlIIIIIIIIIIlIIlI[lllllllllllllIlIlIIIIIIIIIIlIlIl] = 0;
        }
        
        @Override
        public int nextInt() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = IntOpenHashSet.this.n;
                return IntOpenHashSet.this.key[IntOpenHashSet.this.n];
            }
            final int[] lllllllllllllIlIlIIIIIIIIIlIIIII = IntOpenHashSet.this.key;
            while (--this.pos >= 0) {
                if (lllllllllllllIlIlIIIIIIIIIlIIIII[this.pos] != 0) {
                    final int[] array = lllllllllllllIlIlIIIIIIIIIlIIIII;
                    final int pos = this.pos;
                    this.last = pos;
                    return array[pos];
                }
            }
            this.last = Integer.MIN_VALUE;
            return this.wrapped.getInt(-this.pos - 1);
        }
        
        @Override
        public boolean hasNext() {
            return this.c != 0;
        }
    }
}
