package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import java.util.*;

public class ObjectLinkedOpenHashSet<K> extends AbstractObjectSortedSet<K> implements Serializable, Cloneable, Hash
{
    protected transient /* synthetic */ int last;
    protected transient /* synthetic */ int n;
    protected transient /* synthetic */ int maxFill;
    protected transient /* synthetic */ int first;
    protected transient /* synthetic */ boolean containsNull;
    protected transient /* synthetic */ int mask;
    protected final transient /* synthetic */ int minN;
    protected transient /* synthetic */ K[] key;
    protected /* synthetic */ int size;
    protected final /* synthetic */ float f;
    protected transient /* synthetic */ long[] link;
    
    public ObjectLinkedOpenHashSet(final Collection<? extends K> llllllllllllllIlIlIlIlIIlIIlllIl) {
        this(llllllllllllllIlIlIlIlIIlIIlllIl, 0.75f);
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIlIlIlIIlIlllllIIl = 0;
        int llllllllllllllIlIlIlIIlIllllllII = this.realSize();
        int llllllllllllllIlIlIlIIlIlllllIll = 0;
        while (llllllllllllllIlIlIlIIlIllllllII-- != 0) {
            while (this.key[llllllllllllllIlIlIlIIlIlllllIll] == null) {
                ++llllllllllllllIlIlIlIIlIlllllIll;
            }
            if (this != this.key[llllllllllllllIlIlIlIIlIlllllIll]) {
                llllllllllllllIlIlIlIIlIlllllIIl += this.key[llllllllllllllIlIlIlIIlIlllllIll].hashCode();
            }
            ++llllllllllllllIlIlIlIIlIlllllIll;
        }
        return llllllllllllllIlIlIlIIlIlllllIIl;
    }
    
    protected void fixPointers(final int llllllllllllllIlIlIlIIllIlllIIll) {
        if (this.size == 0) {
            final int n = -1;
            this.last = n;
            this.first = n;
            return;
        }
        if (this.first == llllllllllllllIlIlIlIIllIlllIIll) {
            this.first = (int)this.link[llllllllllllllIlIlIlIIllIlllIIll];
            if (0 <= this.first) {
                final long[] link = this.link;
                final int first = this.first;
                link[first] |= 0xFFFFFFFF00000000L;
            }
            return;
        }
        if (this.last == llllllllllllllIlIlIlIIllIlllIIll) {
            this.last = (int)(this.link[llllllllllllllIlIlIlIIllIlllIIll] >>> 32);
            if (0 <= this.last) {
                final long[] link2 = this.link;
                final int last = this.last;
                link2[last] |= 0xFFFFFFFFL;
            }
            return;
        }
        final long llllllllllllllIlIlIlIIllIlllIIlI = this.link[llllllllllllllIlIlIlIIllIlllIIll];
        final int llllllllllllllIlIlIlIIllIlllIIIl = (int)(llllllllllllllIlIlIlIIllIlllIIlI >>> 32);
        final int llllllllllllllIlIlIlIIllIlllIIII = (int)llllllllllllllIlIlIlIIllIlllIIlI;
        final long[] link3 = this.link;
        final int n2 = llllllllllllllIlIlIlIIllIlllIIIl;
        link3[n2] ^= ((this.link[llllllllllllllIlIlIlIIllIlllIIIl] ^ (llllllllllllllIlIlIlIIllIlllIIlI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n3 = llllllllllllllIlIlIlIIllIlllIIII;
        link4[n3] ^= ((this.link[llllllllllllllIlIlIlIIllIlllIIII] ^ (llllllllllllllIlIlIlIIllIlllIIlI & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
    }
    
    private void checkTable() {
    }
    
    protected final void shiftKeys(int llllllllllllllIlIlIlIlIIIIIIIlll) {
        final K[] llllllllllllllIlIlIlIlIIIIIIlIIl = this.key;
        int llllllllllllllIlIlIlIlIIIIIIllII = 0;
    Label_0006:
        while (true) {
            llllllllllllllIlIlIlIlIIIIIIIlll = ((llllllllllllllIlIlIlIlIIIIIIllII = (int)llllllllllllllIlIlIlIlIIIIIIIlll) + 1 & this.mask);
            K llllllllllllllIlIlIlIlIIIIIIlIlI;
            while ((llllllllllllllIlIlIlIlIIIIIIlIlI = llllllllllllllIlIlIlIlIIIIIIlIIl[llllllllllllllIlIlIlIlIIIIIIIlll]) != null) {
                final int llllllllllllllIlIlIlIlIIIIIIlIll = HashCommon.mix(llllllllllllllIlIlIlIlIIIIIIlIlI.hashCode()) & this.mask;
                Label_0090: {
                    if (llllllllllllllIlIlIlIlIIIIIIllII <= llllllllllllllIlIlIlIlIIIIIIIlll) {
                        if (llllllllllllllIlIlIlIlIIIIIIllII >= llllllllllllllIlIlIlIlIIIIIIlIll) {
                            break Label_0090;
                        }
                        if (llllllllllllllIlIlIlIlIIIIIIlIll > llllllllllllllIlIlIlIlIIIIIIIlll) {
                            break Label_0090;
                        }
                    }
                    else if (llllllllllllllIlIlIlIlIIIIIIllII >= llllllllllllllIlIlIlIlIIIIIIlIll && llllllllllllllIlIlIlIlIIIIIIlIll > llllllllllllllIlIlIlIlIIIIIIIlll) {
                        break Label_0090;
                    }
                    llllllllllllllIlIlIlIlIIIIIIIlll = (llllllllllllllIlIlIlIlIIIIIIIlll + 1 & this.mask);
                    continue;
                }
                llllllllllllllIlIlIlIlIIIIIIlIIl[llllllllllllllIlIlIlIlIIIIIIllII] = llllllllllllllIlIlIlIlIIIIIIlIlI;
                this.fixPointers((int)llllllllllllllIlIlIlIlIIIIIIIlll, llllllllllllllIlIlIlIlIIIIIIllII);
                continue Label_0006;
            }
            break;
        }
        llllllllllllllIlIlIlIlIIIIIIlIIl[llllllllllllllIlIlIlIlIIIIIIllII] = null;
    }
    
    private void readObject(final ObjectInputStream llllllllllllllIlIlIlIIlIllIlIllI) throws ClassNotFoundException, IOException {
        llllllllllllllIlIlIlIIlIllIlIllI.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final Object[] key = new Object[this.n + 1];
        this.key = (K[])key;
        final K[] llllllllllllllIlIlIlIIlIllIllIlI = (K[])key;
        final long[] link = new long[this.n + 1];
        this.link = link;
        final long[] llllllllllllllIlIlIlIIlIllIllIIl = link;
        int llllllllllllllIlIlIlIIlIllIllIII = -1;
        final int n = -1;
        this.last = n;
        this.first = n;
        int llllllllllllllIlIlIlIIlIllIllllI = this.size;
        while (llllllllllllllIlIlIlIIlIllIllllI-- != 0) {
            final K llllllllllllllIlIlIlIIlIllIlllll = (K)llllllllllllllIlIlIlIIlIllIlIllI.readObject();
            int llllllllllllllIlIlIlIIlIllIlllIl = 0;
            if (llllllllllllllIlIlIlIIlIllIlllll == null) {
                final int llllllllllllllIlIlIlIIlIlllIIIII = this.n;
                this.containsNull = true;
            }
            else if (llllllllllllllIlIlIlIIlIllIllIlI[llllllllllllllIlIlIlIIlIllIlllIl = (HashCommon.mix(llllllllllllllIlIlIlIIlIllIlllll.hashCode()) & this.mask)] != null) {
                while (llllllllllllllIlIlIlIIlIllIllIlI[llllllllllllllIlIlIlIIlIllIlllIl = (llllllllllllllIlIlIlIIlIllIlllIl + 1 & this.mask)] != null) {}
            }
            llllllllllllllIlIlIlIIlIllIllIlI[llllllllllllllIlIlIlIIlIllIlllIl] = llllllllllllllIlIlIlIIlIllIlllll;
            if (this.first != -1) {
                final long[] array = llllllllllllllIlIlIlIIlIllIllIIl;
                final int n2 = llllllllllllllIlIlIlIIlIllIllIII;
                array[n2] ^= ((llllllllllllllIlIlIlIIlIllIllIIl[llllllllllllllIlIlIlIIlIllIllIII] ^ ((long)llllllllllllllIlIlIlIIlIllIlllIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = llllllllllllllIlIlIlIIlIllIllIIl;
                final int n3 = llllllllllllllIlIlIlIIlIllIlllIl;
                array2[n3] ^= ((llllllllllllllIlIlIlIIlIllIllIIl[llllllllllllllIlIlIlIIlIllIlllIl] ^ ((long)llllllllllllllIlIlIlIIlIllIllIII & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                llllllllllllllIlIlIlIIlIllIllIII = llllllllllllllIlIlIlIIlIllIlllIl;
            }
            else {
                final int first = llllllllllllllIlIlIlIIlIllIlllIl;
                this.first = first;
                llllllllllllllIlIlIlIIlIllIllIII = first;
                final long[] array3 = llllllllllllllIlIlIlIIlIllIllIIl;
                final int n4 = llllllllllllllIlIlIlIIlIllIlllIl;
                array3[n4] |= 0xFFFFFFFF00000000L;
            }
        }
        if ((this.last = llllllllllllllIlIlIlIIlIllIllIII) != -1) {
            final long[] array4 = llllllllllllllIlIlIlIIlIllIllIIl;
            final int n5 = llllllllllllllIlIlIlIIlIllIllIII;
            array4[n5] |= 0xFFFFFFFFL;
        }
    }
    
    protected void fixPointers(final int llllllllllllllIlIlIlIIllIllIIIll, final int llllllllllllllIlIlIlIIllIlIlllII) {
        if (this.size == 1) {
            this.last = llllllllllllllIlIlIlIIllIlIlllII;
            this.first = llllllllllllllIlIlIlIIllIlIlllII;
            this.link[llllllllllllllIlIlIlIIllIlIlllII] = -1L;
            return;
        }
        if (this.first == llllllllllllllIlIlIlIIllIllIIIll) {
            this.first = llllllllllllllIlIlIlIIllIlIlllII;
            final long[] link = this.link;
            final int n = (int)this.link[llllllllllllllIlIlIlIIllIllIIIll];
            link[n] ^= ((this.link[(int)this.link[llllllllllllllIlIlIlIIllIllIIIll]] ^ ((long)llllllllllllllIlIlIlIIllIlIlllII & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[llllllllllllllIlIlIlIIllIlIlllII] = this.link[llllllllllllllIlIlIlIIllIllIIIll];
            return;
        }
        if (this.last == llllllllllllllIlIlIlIIllIllIIIll) {
            this.last = llllllllllllllIlIlIlIIllIlIlllII;
            final long[] link2 = this.link;
            final int n2 = (int)(this.link[llllllllllllllIlIlIlIIllIllIIIll] >>> 32);
            link2[n2] ^= ((this.link[(int)(this.link[llllllllllllllIlIlIlIIllIllIIIll] >>> 32)] ^ ((long)llllllllllllllIlIlIlIIllIlIlllII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlIlIlIIllIlIlllII] = this.link[llllllllllllllIlIlIlIIllIllIIIll];
            return;
        }
        final long llllllllllllllIlIlIlIIllIllIIIIl = this.link[llllllllllllllIlIlIlIIllIllIIIll];
        final int llllllllllllllIlIlIlIIllIllIIIII = (int)(llllllllllllllIlIlIlIIllIllIIIIl >>> 32);
        final int llllllllllllllIlIlIlIIllIlIlllll = (int)llllllllllllllIlIlIlIIllIllIIIIl;
        final long[] link3 = this.link;
        final int n3 = llllllllllllllIlIlIlIIllIllIIIII;
        link3[n3] ^= ((this.link[llllllllllllllIlIlIlIIllIllIIIII] ^ ((long)llllllllllllllIlIlIlIIllIlIlllII & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        final long[] link4 = this.link;
        final int n4 = llllllllllllllIlIlIlIIllIlIlllll;
        link4[n4] ^= ((this.link[llllllllllllllIlIlIlIIllIlIlllll] ^ ((long)llllllllllllllIlIlIlIIllIlIlllII & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[llllllllllllllIlIlIlIIllIlIlllII] = llllllllllllllIlIlIlIIllIllIIIIl;
    }
    
    private void ensureCapacity(final int llllllllllllllIlIlIlIlIIIlIIlIII) {
        final int llllllllllllllIlIlIlIlIIIlIIIlll = HashCommon.arraySize(llllllllllllllIlIlIlIlIIIlIIlIII, this.f);
        if (llllllllllllllIlIlIlIlIIIlIIIlll > this.n) {
            this.rehash(llllllllllllllIlIlIlIlIIIlIIIlll);
        }
    }
    
    public ObjectLinkedOpenHashSet<K> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectLinkedOpenHashSet;
        //     7: astore_1        /* llllllllllllllIlIlIlIIllIIIIIlll */
        //     8: goto            20
        //    11: astore_2        /* llllllllllllllIlIlIlIIllIIIIIIIl */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllllIlIlIlIIllIIIIIlII */
        //    21: aload_0         /* llllllllllllllIlIlIlIIllIIIIIlIl */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectLinkedOpenHashSet.key:[Ljava/lang/Object;
        //    25: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    28: checkcast       [Ljava/lang/Object;
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectLinkedOpenHashSet.key:[Ljava/lang/Object;
        //    34: aload_1         /* llllllllllllllIlIlIlIIllIIIIIlII */
        //    35: aload_0         /* llllllllllllllIlIlIlIIllIIIIIlIl */
        //    36: getfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectLinkedOpenHashSet.containsNull:Z
        //    39: putfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectLinkedOpenHashSet.containsNull:Z
        //    42: aload_1         /* llllllllllllllIlIlIlIIllIIIIIlII */
        //    43: aload_0         /* llllllllllllllIlIlIlIIllIIIIIlIl */
        //    44: getfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectLinkedOpenHashSet.link:[J
        //    47: invokevirtual   [J.clone:()Ljava/lang/Object;
        //    50: checkcast       [J
        //    53: putfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectLinkedOpenHashSet.link:[J
        //    56: aload_1         /* llllllllllllllIlIlIlIIllIIIIIlII */
        //    57: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectLinkedOpenHashSet<TK;>;
        //    StackMapTable: 00 02 4B 07 00 E0 FC 00 08 07 00 02
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
    
    public ObjectLinkedOpenHashSet(final K[] llllllllllllllIlIlIlIlIIIlIlIIlI) {
        this(llllllllllllllIlIlIlIlIIIlIlIIlI, 0.75f);
    }
    
    public ObjectLinkedOpenHashSet(final Collection<? extends K> llllllllllllllIlIlIlIlIIlIlIIlIl, final float llllllllllllllIlIlIlIlIIlIlIIIIl) {
        this(llllllllllllllIlIlIlIlIIlIlIIlIl.size(), llllllllllllllIlIlIlIlIIlIlIIIIl);
        this.addAll(llllllllllllllIlIlIlIlIIlIlIIlIl);
    }
    
    public K addOrGet(final K llllllllllllllIlIlIlIlIIIIIllIll) {
        int llllllllllllllIlIlIlIlIIIIIllIlI = 0;
        if (llllllllllllllIlIlIlIlIIIIIllIll == null) {
            if (this.containsNull) {
                return this.key[this.n];
            }
            final int llllllllllllllIlIlIlIlIIIIIlllll = this.n;
            this.containsNull = true;
        }
        else {
            final K[] llllllllllllllIlIlIlIlIIIIIlllIl = this.key;
            K llllllllllllllIlIlIlIlIIIIIllllI;
            if ((llllllllllllllIlIlIlIlIIIIIllllI = llllllllllllllIlIlIlIlIIIIIlllIl[llllllllllllllIlIlIlIlIIIIIllIlI = (HashCommon.mix(llllllllllllllIlIlIlIlIIIIIllIll.hashCode()) & this.mask)]) != null) {
                if (llllllllllllllIlIlIlIlIIIIIllllI.equals(llllllllllllllIlIlIlIlIIIIIllIll)) {
                    return llllllllllllllIlIlIlIlIIIIIllllI;
                }
                while ((llllllllllllllIlIlIlIlIIIIIllllI = llllllllllllllIlIlIlIlIIIIIlllIl[llllllllllllllIlIlIlIlIIIIIllIlI = (llllllllllllllIlIlIlIlIIIIIllIlI + 1 & this.mask)]) != null) {
                    if (llllllllllllllIlIlIlIlIIIIIllllI.equals(llllllllllllllIlIlIlIlIIIIIllIll)) {
                        return llllllllllllllIlIlIlIlIIIIIllllI;
                    }
                }
            }
            llllllllllllllIlIlIlIlIIIIIlllIl[llllllllllllllIlIlIlIlIIIIIllIlI] = llllllllllllllIlIlIlIlIIIIIllIll;
        }
        if (this.size == 0) {
            final int n = llllllllllllllIlIlIlIlIIIIIllIlI;
            this.last = n;
            this.first = n;
            this.link[llllllllllllllIlIlIlIlIIIIIllIlI] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlIlIlIlIIIIIllIlI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlIlIlIlIIIIIllIlI] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = llllllllllllllIlIlIlIlIIIIIllIlI;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return llllllllllllllIlIlIlIlIIIIIllIll;
    }
    
    @Override
    public ObjectSortedSet<K> tailSet(final K llllllllllllllIlIlIlIIllIlIlIIIl) {
        throw new UnsupportedOperationException();
    }
    
    public boolean addAndMoveToFirst(final K llllllllllllllIlIlIlIIlllIIlIIlI) {
        int llllllllllllllIlIlIlIIlllIIlIlII = 0;
        if (llllllllllllllIlIlIlIIlllIIlIIlI == null) {
            if (this.containsNull) {
                this.moveIndexToFirst(this.n);
                return false;
            }
            this.containsNull = true;
            final int llllllllllllllIlIlIlIIlllIIllIII = this.n;
        }
        else {
            K[] llllllllllllllIlIlIlIIlllIIlIlll;
            for (llllllllllllllIlIlIlIIlllIIlIlll = this.key, llllllllllllllIlIlIlIIlllIIlIlII = (HashCommon.mix(llllllllllllllIlIlIlIIlllIIlIIlI.hashCode()) & this.mask); llllllllllllllIlIlIlIIlllIIlIlll[llllllllllllllIlIlIlIIlllIIlIlII] != null; llllllllllllllIlIlIlIIlllIIlIlII = (llllllllllllllIlIlIlIIlllIIlIlII + 1 & this.mask)) {
                if (llllllllllllllIlIlIlIIlllIIlIIlI.equals(llllllllllllllIlIlIlIIlllIIlIlll[llllllllllllllIlIlIlIIlllIIlIlII])) {
                    this.moveIndexToFirst(llllllllllllllIlIlIlIIlllIIlIlII);
                    return false;
                }
            }
        }
        this.key[llllllllllllllIlIlIlIIlllIIlIlII] = llllllllllllllIlIlIlIIlllIIlIIlI;
        if (this.size == 0) {
            final int n = llllllllllllllIlIlIlIIlllIIlIlII;
            this.last = n;
            this.first = n;
            this.link[llllllllllllllIlIlIlIIlllIIlIlII] = -1L;
        }
        else {
            final long[] link = this.link;
            final int first = this.first;
            link[first] ^= ((this.link[this.first] ^ ((long)llllllllllllllIlIlIlIIlllIIlIlII & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            this.link[llllllllllllllIlIlIlIIlllIIlIlII] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
            this.first = llllllllllllllIlIlIlIIlllIIlIlII;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return true;
    }
    
    public ObjectLinkedOpenHashSet(final ObjectCollection<? extends K> llllllllllllllIlIlIlIlIIlIIIlllI) {
        this(llllllllllllllIlIlIlIlIIlIIIlllI, 0.75f);
    }
    
    public ObjectLinkedOpenHashSet(final K[] llllllllllllllIlIlIlIlIIIlllIlII, final int llllllllllllllIlIlIlIlIIIllIlllI, final int llllllllllllllIlIlIlIlIIIllIllIl, final float llllllllllllllIlIlIlIlIIIllIllII) {
        this((llllllllllllllIlIlIlIlIIIllIllIl < 0) ? 0 : llllllllllllllIlIlIlIlIIIllIllIl, llllllllllllllIlIlIlIlIIIllIllII);
        ObjectArrays.ensureOffsetLength(llllllllllllllIlIlIlIlIIIlllIlII, llllllllllllllIlIlIlIlIIIllIlllI, llllllllllllllIlIlIlIlIIIllIllIl);
        for (int llllllllllllllIlIlIlIlIIIlllIllI = 0; llllllllllllllIlIlIlIlIIIlllIllI < llllllllllllllIlIlIlIlIIIllIllIl; ++llllllllllllllIlIlIlIlIIIlllIllI) {
            this.add(llllllllllllllIlIlIlIlIIIlllIlII[llllllllllllllIlIlIlIlIIIllIlllI + llllllllllllllIlIlIlIlIIIlllIllI]);
        }
    }
    
    static {
        ASSERTS = false;
    }
    
    @Override
    public K last() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.last];
    }
    
    @Override
    public ObjectListIterator<K> iterator() {
        return new SetIterator();
    }
    
    @Override
    public ObjectListIterator<K> iterator(final K llllllllllllllIlIlIlIIllIlIIIlll) {
        return new SetIterator(llllllllllllllIlIlIlIIllIlIIIlll);
    }
    
    public ObjectLinkedOpenHashSet(final Iterator<? extends K> llllllllllllllIlIlIlIlIIIlllllIl) {
        this(llllllllllllllIlIlIlIlIIIlllllIl, 0.75f);
    }
    
    public ObjectLinkedOpenHashSet() {
        this(16, 0.75f);
    }
    
    public boolean addAndMoveToLast(final K llllllllllllllIlIlIlIIlllIIIlIII) {
        int llllllllllllllIlIlIlIIlllIIIIlll = 0;
        if (llllllllllllllIlIlIlIIlllIIIlIII == null) {
            if (this.containsNull) {
                this.moveIndexToLast(this.n);
                return false;
            }
            this.containsNull = true;
            final int llllllllllllllIlIlIlIIlllIIIlIll = this.n;
        }
        else {
            K[] llllllllllllllIlIlIlIIlllIIIlIlI;
            for (llllllllllllllIlIlIlIIlllIIIlIlI = this.key, llllllllllllllIlIlIlIIlllIIIIlll = (HashCommon.mix(llllllllllllllIlIlIlIIlllIIIlIII.hashCode()) & this.mask); llllllllllllllIlIlIlIIlllIIIlIlI[llllllllllllllIlIlIlIIlllIIIIlll] != null; llllllllllllllIlIlIlIIlllIIIIlll = (llllllllllllllIlIlIlIIlllIIIIlll + 1 & this.mask)) {
                if (llllllllllllllIlIlIlIIlllIIIlIII.equals(llllllllllllllIlIlIlIIlllIIIlIlI[llllllllllllllIlIlIlIIlllIIIIlll])) {
                    this.moveIndexToLast(llllllllllllllIlIlIlIIlllIIIIlll);
                    return false;
                }
            }
        }
        this.key[llllllllllllllIlIlIlIIlllIIIIlll] = llllllllllllllIlIlIlIIlllIIIlIII;
        if (this.size == 0) {
            final int n = llllllllllllllIlIlIlIIlllIIIIlll;
            this.last = n;
            this.first = n;
            this.link[llllllllllllllIlIlIlIIlllIIIIlll] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlIlIlIIlllIIIIlll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlIlIlIIlllIIIIlll] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = llllllllllllllIlIlIlIIlllIIIIlll;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size, this.f));
        }
        return true;
    }
    
    public K get(final Object llllllllllllllIlIlIlIIllllIlIlIl) {
        if (llllllllllllllIlIlIlIIllllIlIlIl == null) {
            return this.key[this.n];
        }
        final K[] llllllllllllllIlIlIlIIllllIlIIll = this.key;
        int llllllllllllllIlIlIlIIllllIlIIlI;
        K llllllllllllllIlIlIlIIllllIlIlII;
        if ((llllllllllllllIlIlIlIIllllIlIlII = llllllllllllllIlIlIlIIllllIlIIll[llllllllllllllIlIlIlIIllllIlIIlI = (HashCommon.mix(llllllllllllllIlIlIlIIllllIlIlIl.hashCode()) & this.mask)]) == null) {
            return null;
        }
        if (llllllllllllllIlIlIlIIllllIlIlIl.equals(llllllllllllllIlIlIlIIllllIlIlII)) {
            return llllllllllllllIlIlIlIIllllIlIlII;
        }
        while ((llllllllllllllIlIlIlIIllllIlIlII = llllllllllllllIlIlIlIIllllIlIIll[llllllllllllllIlIlIlIIllllIlIIlI = (llllllllllllllIlIlIlIIllllIlIIlI + 1 & this.mask)]) != null) {
            if (llllllllllllllIlIlIlIIllllIlIlIl.equals(llllllllllllllIlIlIlIIllllIlIlII)) {
                return llllllllllllllIlIlIlIIllllIlIlII;
            }
        }
        return null;
    }
    
    @Override
    public Comparator<? super K> comparator() {
        return null;
    }
    
    public boolean trim(final int llllllllllllllIlIlIlIIllIIllIlIl) {
        final int llllllllllllllIlIlIlIIllIIllIlll = HashCommon.nextPowerOfTwo((int)Math.ceil(llllllllllllllIlIlIlIIllIIllIlIl / this.f));
        if (llllllllllllllIlIlIlIIllIIllIlll >= this.n || this.size > HashCommon.maxFill(llllllllllllllIlIlIlIIllIIllIlll, this.f)) {
            return true;
        }
        try {
            this.rehash(llllllllllllllIlIlIlIIllIIllIlll);
        }
        catch (OutOfMemoryError llllllllllllllIlIlIlIIllIIlllIlI) {
            return false;
        }
        return true;
    }
    
    private void writeObject(final ObjectOutputStream llllllllllllllIlIlIlIIlIlllIlllI) throws IOException {
        final ObjectIterator<K> llllllllllllllIlIlIlIIlIlllIllIl = this.iterator();
        llllllllllllllIlIlIlIIlIlllIlllI.defaultWriteObject();
        int llllllllllllllIlIlIlIIlIllllIIII = this.size;
        while (llllllllllllllIlIlIlIIlIllllIIII-- != 0) {
            llllllllllllllIlIlIlIIlIlllIlllI.writeObject(llllllllllllllIlIlIlIIlIlllIllIl.next());
        }
    }
    
    private int realSize() {
        return this.containsNull ? (this.size - 1) : this.size;
    }
    
    @Override
    public boolean remove(final Object llllllllllllllIlIlIlIIlllllIlllI) {
        if (llllllllllllllIlIlIlIIlllllIlllI == null) {
            return this.containsNull && this.removeNullEntry();
        }
        final K[] llllllllllllllIlIlIlIIllllllIIIl = this.key;
        int llllllllllllllIlIlIlIIllllllIIII;
        K llllllllllllllIlIlIlIIllllllIIlI;
        if ((llllllllllllllIlIlIlIIllllllIIlI = llllllllllllllIlIlIlIIllllllIIIl[llllllllllllllIlIlIlIIllllllIIII = (HashCommon.mix(llllllllllllllIlIlIlIIlllllIlllI.hashCode()) & this.mask)]) == null) {
            return false;
        }
        if (llllllllllllllIlIlIlIIlllllIlllI.equals(llllllllllllllIlIlIlIIllllllIIlI)) {
            return this.removeEntry(llllllllllllllIlIlIlIIllllllIIII);
        }
        while ((llllllllllllllIlIlIlIIllllllIIlI = llllllllllllllIlIlIlIIllllllIIIl[llllllllllllllIlIlIlIIllllllIIII = (llllllllllllllIlIlIlIIllllllIIII + 1 & this.mask)]) != null) {
            if (llllllllllllllIlIlIlIIlllllIlllI.equals(llllllllllllllIlIlIlIIllllllIIlI)) {
                return this.removeEntry(llllllllllllllIlIlIlIIllllllIIII);
            }
        }
        return false;
    }
    
    public K removeLast() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int llllllllllllllIlIlIlIIlllIllllll = this.last;
        this.last = (int)(this.link[llllllllllllllIlIlIlIIlllIllllll] >>> 32);
        if (0 <= this.last) {
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        final K llllllllllllllIlIlIlIIlllIlllllI = this.key[llllllllllllllIlIlIlIIlllIllllll];
        --this.size;
        if (llllllllllllllIlIlIlIIlllIlllllI == null) {
            this.containsNull = false;
            this.key[this.n] = null;
        }
        else {
            this.shiftKeys(llllllllllllllIlIlIlIIlllIllllll);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlIlIlIIlllIlllllI;
    }
    
    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.n] = null;
        --this.size;
        this.fixPointers(this.n);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }
    
    public ObjectLinkedOpenHashSet(final K[] llllllllllllllIlIlIlIlIIIllIIlIl, final int llllllllllllllIlIlIlIlIIIllIIlII, final int llllllllllllllIlIlIlIlIIIllIIIll) {
        this(llllllllllllllIlIlIlIlIIIllIIlIl, llllllllllllllIlIlIlIlIIIllIIlII, llllllllllllllIlIlIlIlIIIllIIIll, 0.75f);
    }
    
    public ObjectLinkedOpenHashSet(final Iterator<? extends K> llllllllllllllIlIlIlIlIIlIIIIlII, final float llllllllllllllIlIlIlIlIIlIIIIIll) {
        this(16, llllllllllllllIlIlIlIlIIlIIIIIll);
        while (llllllllllllllIlIlIlIlIIlIIIIlII.hasNext()) {
            this.add(llllllllllllllIlIlIlIlIIlIIIIlII.next());
        }
    }
    
    public ObjectLinkedOpenHashSet(final K[] llllllllllllllIlIlIlIlIIIlIlIlll, final float llllllllllllllIlIlIlIlIIIlIllIIl) {
        this(llllllllllllllIlIlIlIlIIIlIlIlll, 0, llllllllllllllIlIlIlIlIIIlIlIlll.length, llllllllllllllIlIlIlIlIIIlIllIIl);
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public boolean addAll(final Collection<? extends K> llllllllllllllIlIlIlIlIIIIllIlIl) {
        if (this.f <= 0.5) {
            this.ensureCapacity(llllllllllllllIlIlIlIlIIIIllIlIl.size());
        }
        else {
            this.tryCapacity(this.size() + llllllllllllllIlIlIlIlIIIIllIlIl.size());
        }
        return super.addAll(llllllllllllllIlIlIlIlIIIIllIlIl);
    }
    
    private void moveIndexToFirst(final int llllllllllllllIlIlIlIIlllIlIllll) {
        if (this.size == 1 || this.first == llllllllllllllIlIlIlIIlllIlIllll) {
            return;
        }
        if (this.last == llllllllllllllIlIlIlIIlllIlIllll) {
            this.last = (int)(this.link[llllllllllllllIlIlIlIIlllIlIllll] >>> 32);
            final long[] link = this.link;
            final int last = this.last;
            link[last] |= 0xFFFFFFFFL;
        }
        else {
            final long llllllllllllllIlIlIlIIlllIllIlIl = this.link[llllllllllllllIlIlIlIIlllIlIllll];
            final int llllllllllllllIlIlIlIIlllIllIlII = (int)(llllllllllllllIlIlIlIIlllIllIlIl >>> 32);
            final int llllllllllllllIlIlIlIIlllIllIIll = (int)llllllllllllllIlIlIlIIlllIllIlIl;
            final long[] link2 = this.link;
            final int n = llllllllllllllIlIlIlIIlllIllIlII;
            link2[n] ^= ((this.link[llllllllllllllIlIlIlIIlllIllIlII] ^ (llllllllllllllIlIlIlIIlllIllIlIl & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = llllllllllllllIlIlIlIIlllIllIIll;
            link3[n2] ^= ((this.link[llllllllllllllIlIlIlIIlllIllIIll] ^ (llllllllllllllIlIlIlIIlllIllIlIl & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int first = this.first;
        link4[first] ^= ((this.link[this.first] ^ ((long)llllllllllllllIlIlIlIIlllIlIllll & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
        this.link[llllllllllllllIlIlIlIIlllIlIllll] = (0xFFFFFFFF00000000L | ((long)this.first & 0xFFFFFFFFL));
        this.first = llllllllllllllIlIlIlIIlllIlIllll;
    }
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNull = false;
        Arrays.fill(this.key, null);
        final int n = -1;
        this.last = n;
        this.first = n;
    }
    
    protected void rehash(final int llllllllllllllIlIlIlIIllIIIlIllI) {
        final K[] llllllllllllllIlIlIlIIllIIIlllll = this.key;
        final int llllllllllllllIlIlIlIIllIIIllllI = llllllllllllllIlIlIlIIllIIIlIllI - 1;
        final K[] llllllllllllllIlIlIlIIllIIIlllIl = (K[])new Object[llllllllllllllIlIlIlIIllIIIlIllI + 1];
        int llllllllllllllIlIlIlIIllIIIlllII = this.first;
        int llllllllllllllIlIlIlIIllIIIllIll = -1;
        int llllllllllllllIlIlIlIIllIIIllIlI = -1;
        final long[] llllllllllllllIlIlIlIIllIIIllIIl = this.link;
        final long[] llllllllllllllIlIlIlIIllIIIllIII = new long[llllllllllllllIlIlIlIIllIIIlIllI + 1];
        this.first = -1;
        int llllllllllllllIlIlIlIIllIIlIIIlI = this.size;
        while (llllllllllllllIlIlIlIIllIIlIIIlI-- != 0) {
            int llllllllllllllIlIlIlIIllIIlIIIll = 0;
            if (llllllllllllllIlIlIlIIllIIIlllll[llllllllllllllIlIlIlIIllIIIlllII] == null) {
                final int llllllllllllllIlIlIlIIllIIlIIlIl = llllllllllllllIlIlIlIIllIIIlIllI;
            }
            else {
                for (llllllllllllllIlIlIlIIllIIlIIIll = (HashCommon.mix(llllllllllllllIlIlIlIIllIIIlllll[llllllllllllllIlIlIlIIllIIIlllII].hashCode()) & llllllllllllllIlIlIlIIllIIIllllI); llllllllllllllIlIlIlIIllIIIlllIl[llllllllllllllIlIlIlIIllIIlIIIll] != null; llllllllllllllIlIlIlIIllIIlIIIll = (llllllllllllllIlIlIlIIllIIlIIIll + 1 & llllllllllllllIlIlIlIIllIIIllllI)) {}
            }
            llllllllllllllIlIlIlIIllIIIlllIl[llllllllllllllIlIlIlIIllIIlIIIll] = llllllllllllllIlIlIlIIllIIIlllll[llllllllllllllIlIlIlIIllIIIlllII];
            if (llllllllllllllIlIlIlIIllIIIllIll != -1) {
                final long[] array = llllllllllllllIlIlIlIIllIIIllIII;
                final int n = llllllllllllllIlIlIlIIllIIIllIlI;
                array[n] ^= ((llllllllllllllIlIlIlIIllIIIllIII[llllllllllllllIlIlIlIIllIIIllIlI] ^ ((long)llllllllllllllIlIlIlIIllIIlIIIll & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
                final long[] array2 = llllllllllllllIlIlIlIIllIIIllIII;
                final int n2 = llllllllllllllIlIlIlIIllIIlIIIll;
                array2[n2] ^= ((llllllllllllllIlIlIlIIllIIIllIII[llllllllllllllIlIlIlIIllIIlIIIll] ^ ((long)llllllllllllllIlIlIlIIllIIIllIlI & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
                llllllllllllllIlIlIlIIllIIIllIlI = llllllllllllllIlIlIlIIllIIlIIIll;
            }
            else {
                final int first = llllllllllllllIlIlIlIIllIIlIIIll;
                this.first = first;
                llllllllllllllIlIlIlIIllIIIllIlI = first;
                llllllllllllllIlIlIlIIllIIIllIII[llllllllllllllIlIlIlIIllIIlIIIll] = -1L;
            }
            final int llllllllllllllIlIlIlIIllIIlIIlII = llllllllllllllIlIlIlIIllIIIlllII;
            llllllllllllllIlIlIlIIllIIIlllII = (int)llllllllllllllIlIlIlIIllIIIllIIl[llllllllllllllIlIlIlIIllIIIlllII];
            llllllllllllllIlIlIlIIllIIIllIll = llllllllllllllIlIlIlIIllIIlIIlII;
        }
        this.link = llllllllllllllIlIlIlIIllIIIllIII;
        if ((this.last = llllllllllllllIlIlIlIIllIIIllIlI) != -1) {
            final long[] array3 = llllllllllllllIlIlIlIIllIIIllIII;
            final int n3 = llllllllllllllIlIlIlIIllIIIllIlI;
            array3[n3] |= 0xFFFFFFFFL;
        }
        this.n = llllllllllllllIlIlIlIIllIIIlIllI;
        this.mask = llllllllllllllIlIlIlIIllIIIllllI;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = llllllllllllllIlIlIlIIllIIIlllIl;
    }
    
    public K removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        final int llllllllllllllIlIlIlIIllllIIlIII = this.first;
        this.first = (int)this.link[llllllllllllllIlIlIlIIllllIIlIII];
        if (0 <= this.first) {
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        final K llllllllllllllIlIlIlIIllllIIIlll = this.key[llllllllllllllIlIlIlIIllllIIlIII];
        --this.size;
        if (llllllllllllllIlIlIlIIllllIIIlll == null) {
            this.containsNull = false;
            this.key[this.n] = null;
        }
        else {
            this.shiftKeys(llllllllllllllIlIlIlIIllllIIlIII);
        }
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return llllllllllllllIlIlIlIIllllIIIlll;
    }
    
    @Override
    public boolean add(final K llllllllllllllIlIlIlIlIIIIlIlIll) {
        int llllllllllllllIlIlIlIlIIIIlIlIlI = 0;
        if (llllllllllllllIlIlIlIlIIIIlIlIll == null) {
            if (this.containsNull) {
                return false;
            }
            final int llllllllllllllIlIlIlIlIIIIlIllll = this.n;
            this.containsNull = true;
        }
        else {
            final K[] llllllllllllllIlIlIlIlIIIIlIllIl = this.key;
            K llllllllllllllIlIlIlIlIIIIlIlllI;
            if ((llllllllllllllIlIlIlIlIIIIlIlllI = llllllllllllllIlIlIlIlIIIIlIllIl[llllllllllllllIlIlIlIlIIIIlIlIlI = (HashCommon.mix(llllllllllllllIlIlIlIlIIIIlIlIll.hashCode()) & this.mask)]) != null) {
                if (llllllllllllllIlIlIlIlIIIIlIlllI.equals(llllllllllllllIlIlIlIlIIIIlIlIll)) {
                    return false;
                }
                while ((llllllllllllllIlIlIlIlIIIIlIlllI = llllllllllllllIlIlIlIlIIIIlIllIl[llllllllllllllIlIlIlIlIIIIlIlIlI = (llllllllllllllIlIlIlIlIIIIlIlIlI + 1 & this.mask)]) != null) {
                    if (llllllllllllllIlIlIlIlIIIIlIlllI.equals(llllllllllllllIlIlIlIlIIIIlIlIll)) {
                        return false;
                    }
                }
            }
            llllllllllllllIlIlIlIlIIIIlIllIl[llllllllllllllIlIlIlIlIIIIlIlIlI] = llllllllllllllIlIlIlIlIIIIlIlIll;
        }
        if (this.size == 0) {
            final int n = llllllllllllllIlIlIlIlIIIIlIlIlI;
            this.last = n;
            this.first = n;
            this.link[llllllllllllllIlIlIlIlIIIIlIlIlI] = -1L;
        }
        else {
            final long[] link = this.link;
            final int last = this.last;
            link[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlIlIlIlIIIIlIlIlI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            this.link[llllllllllllllIlIlIlIlIIIIlIlIlI] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
            this.last = llllllllllllllIlIlIlIlIIIIlIlIlI;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return true;
    }
    
    private void moveIndexToLast(final int llllllllllllllIlIlIlIIlllIlIIIlI) {
        if (this.size == 1 || this.last == llllllllllllllIlIlIlIIlllIlIIIlI) {
            return;
        }
        if (this.first == llllllllllllllIlIlIlIIlllIlIIIlI) {
            this.first = (int)this.link[llllllllllllllIlIlIlIIlllIlIIIlI];
            final long[] link = this.link;
            final int first = this.first;
            link[first] |= 0xFFFFFFFF00000000L;
        }
        else {
            final long llllllllllllllIlIlIlIIlllIlIIllI = this.link[llllllllllllllIlIlIlIIlllIlIIIlI];
            final int llllllllllllllIlIlIlIIlllIlIIlIl = (int)(llllllllllllllIlIlIlIIlllIlIIllI >>> 32);
            final int llllllllllllllIlIlIlIIlllIlIIlII = (int)llllllllllllllIlIlIlIIlllIlIIllI;
            final long[] link2 = this.link;
            final int n = llllllllllllllIlIlIlIIlllIlIIlIl;
            link2[n] ^= ((this.link[llllllllllllllIlIlIlIIlllIlIIlIl] ^ (llllllllllllllIlIlIlIIlllIlIIllI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            final long[] link3 = this.link;
            final int n2 = llllllllllllllIlIlIlIIlllIlIIlII;
            link3[n2] ^= ((this.link[llllllllllllllIlIlIlIIlllIlIIlII] ^ (llllllllllllllIlIlIlIIlllIlIIllI & 0xFFFFFFFF00000000L)) & 0xFFFFFFFF00000000L);
        }
        final long[] link4 = this.link;
        final int last = this.last;
        link4[last] ^= ((this.link[this.last] ^ ((long)llllllllllllllIlIlIlIIlllIlIIIlI & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
        this.link[llllllllllllllIlIlIlIIlllIlIIIlI] = (((long)this.last & 0xFFFFFFFFL) << 32 | 0xFFFFFFFFL);
        this.last = llllllllllllllIlIlIlIIlllIlIIIlI;
    }
    
    @Override
    public boolean contains(final Object llllllllllllllIlIlIlIIllllIlllll) {
        if (llllllllllllllIlIlIlIIllllIlllll == null) {
            return this.containsNull;
        }
        final K[] llllllllllllllIlIlIlIIlllllIIIlI = this.key;
        int llllllllllllllIlIlIlIIlllllIIIIl;
        K llllllllllllllIlIlIlIIlllllIIIll;
        if ((llllllllllllllIlIlIlIIlllllIIIll = llllllllllllllIlIlIlIIlllllIIIlI[llllllllllllllIlIlIlIIlllllIIIIl = (HashCommon.mix(llllllllllllllIlIlIlIIllllIlllll.hashCode()) & this.mask)]) == null) {
            return false;
        }
        if (llllllllllllllIlIlIlIIllllIlllll.equals(llllllllllllllIlIlIlIIlllllIIIll)) {
            return true;
        }
        while ((llllllllllllllIlIlIlIIlllllIIIll = llllllllllllllIlIlIlIIlllllIIIlI[llllllllllllllIlIlIlIIlllllIIIIl = (llllllllllllllIlIlIlIIlllllIIIIl + 1 & this.mask)]) != null) {
            if (llllllllllllllIlIlIlIIllllIlllll.equals(llllllllllllllIlIlIlIIlllllIIIll)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public K first() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.key[this.first];
    }
    
    private void tryCapacity(final long llllllllllllllIlIlIlIlIIIIllllII) {
        final int llllllllllllllIlIlIlIlIIIIlllllI = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(llllllllllllllIlIlIlIlIIIIllllII / this.f))));
        if (llllllllllllllIlIlIlIlIIIIlllllI > this.n) {
            this.rehash(llllllllllllllIlIlIlIlIIIIlllllI);
        }
    }
    
    private boolean removeEntry(final int llllllllllllllIlIlIlIIllllllllIl) {
        --this.size;
        this.fixPointers(llllllllllllllIlIlIlIIllllllllIl);
        this.shiftKeys(llllllllllllllIlIlIlIIllllllllIl);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }
    
    public ObjectLinkedOpenHashSet(final ObjectCollection<? extends K> llllllllllllllIlIlIlIlIIlIIlIllI, final float llllllllllllllIlIlIlIlIIlIIlIlIl) {
        this(llllllllllllllIlIlIlIlIIlIIlIllI.size(), llllllllllllllIlIlIlIlIIlIIlIlIl);
        this.addAll(llllllllllllllIlIlIlIlIIlIIlIllI);
    }
    
    public ObjectLinkedOpenHashSet(final int llllllllllllllIlIlIlIlIIlIlIllll) {
        this(llllllllllllllIlIlIlIlIIlIlIllll, 0.75f);
    }
    
    public ObjectLinkedOpenHashSet(final int llllllllllllllIlIlIlIlIIlIllIlll, final float llllllllllllllIlIlIlIlIIlIllIllI) {
        this.first = -1;
        this.last = -1;
        if (llllllllllllllIlIlIlIlIIlIllIllI <= 0.0f || llllllllllllllIlIlIlIlIIlIllIllI > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (llllllllllllllIlIlIlIlIIlIllIlll < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = llllllllllllllIlIlIlIlIIlIllIllI;
        final int arraySize = HashCommon.arraySize(llllllllllllllIlIlIlIlIIlIllIlll, llllllllllllllIlIlIlIlIIlIllIllI);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, llllllllllllllIlIlIlIlIIlIllIllI);
        this.key = (K[])new Object[this.n + 1];
        this.link = new long[this.n + 1];
    }
    
    @Override
    public ObjectSortedSet<K> headSet(final K llllllllllllllIlIlIlIIllIlIIllll) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    @Override
    public ObjectSortedSet<K> subSet(final K llllllllllllllIlIlIlIIllIlIIllIl, final K llllllllllllllIlIlIlIIllIlIIllII) {
        throw new UnsupportedOperationException();
    }
    
    private class SetIterator implements ObjectListIterator<K>
    {
        /* synthetic */ int index;
        /* synthetic */ int next;
        /* synthetic */ int curr;
        /* synthetic */ int prev;
        
        SetIterator(final K lllllllllllllllIIllllllIIlllIlll) {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            if (lllllllllllllllIIllllllIIlllIlll == null) {
                if (ObjectLinkedOpenHashSet.this.containsNull) {
                    this.next = (int)ObjectLinkedOpenHashSet.this.link[ObjectLinkedOpenHashSet.this.n];
                    this.prev = ObjectLinkedOpenHashSet.this.n;
                    return;
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(lllllllllllllllIIllllllIIlllIlll).append(" does not belong to this set.")));
            }
            else {
                if (Objects.equals(ObjectLinkedOpenHashSet.this.key[ObjectLinkedOpenHashSet.this.last], lllllllllllllllIIllllllIIlllIlll)) {
                    this.prev = ObjectLinkedOpenHashSet.this.last;
                    this.index = ObjectLinkedOpenHashSet.this.size;
                    return;
                }
                final K[] lllllllllllllllIIllllllIIllllIll = ObjectLinkedOpenHashSet.this.key;
                for (int lllllllllllllllIIllllllIIllllIlI = HashCommon.mix(lllllllllllllllIIllllllIIlllIlll.hashCode()) & ObjectLinkedOpenHashSet.this.mask; lllllllllllllllIIllllllIIllllIll[lllllllllllllllIIllllllIIllllIlI] != null; lllllllllllllllIIllllllIIllllIlI = (lllllllllllllllIIllllllIIllllIlI + 1 & ObjectLinkedOpenHashSet.this.mask)) {
                    if (lllllllllllllllIIllllllIIllllIll[lllllllllllllllIIllllllIIllllIlI].equals(lllllllllllllllIIllllllIIlllIlll)) {
                        this.next = (int)ObjectLinkedOpenHashSet.this.link[lllllllllllllllIIllllllIIllllIlI];
                        this.prev = lllllllllllllllIIllllllIIllllIlI;
                        return;
                    }
                }
                throw new NoSuchElementException(String.valueOf(new StringBuilder().append("The key ").append(lllllllllllllllIIllllllIIlllIlll).append(" does not belong to this set.")));
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
                this.index = ObjectLinkedOpenHashSet.this.size;
                return;
            }
            int lllllllllllllllIIllllllIIllIIlIl = ObjectLinkedOpenHashSet.this.first;
            this.index = 1;
            while (lllllllllllllllIIllllllIIllIIlIl != this.prev) {
                lllllllllllllllIIllllllIIllIIlIl = (int)ObjectLinkedOpenHashSet.this.link[lllllllllllllllIIllllllIIllIIlIl];
                ++this.index;
            }
        }
        
        @Override
        public int nextIndex() {
            this.ensureIndexKnown();
            return this.index;
        }
        
        @Override
        public boolean hasNext() {
            return this.next != -1;
        }
        
        SetIterator() {
            this.prev = -1;
            this.next = -1;
            this.curr = -1;
            this.index = -1;
            this.next = ObjectLinkedOpenHashSet.this.first;
            this.index = 0;
        }
        
        @Override
        public K previous() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = this.prev;
            this.prev = (int)(ObjectLinkedOpenHashSet.this.link[this.curr] >>> 32);
            this.next = this.curr;
            if (this.index >= 0) {
                --this.index;
            }
            return ObjectLinkedOpenHashSet.this.key[this.curr];
        }
        
        @Override
        public K next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = this.next;
            this.next = (int)ObjectLinkedOpenHashSet.this.link[this.curr];
            this.prev = this.curr;
            if (this.index >= 0) {
                ++this.index;
            }
            return ObjectLinkedOpenHashSet.this.key[this.curr];
        }
        
        @Override
        public int previousIndex() {
            this.ensureIndexKnown();
            return this.index - 1;
        }
        
        @Override
        public void remove() {
            this.ensureIndexKnown();
            if (this.curr == -1) {
                throw new IllegalStateException();
            }
            if (this.curr == this.prev) {
                --this.index;
                this.prev = (int)(ObjectLinkedOpenHashSet.this.link[this.curr] >>> 32);
            }
            else {
                this.next = (int)ObjectLinkedOpenHashSet.this.link[this.curr];
            }
            final ObjectLinkedOpenHashSet this$0 = ObjectLinkedOpenHashSet.this;
            --this$0.size;
            if (this.prev == -1) {
                ObjectLinkedOpenHashSet.this.first = this.next;
            }
            else {
                final long[] link = ObjectLinkedOpenHashSet.this.link;
                final int prev = this.prev;
                link[prev] ^= ((ObjectLinkedOpenHashSet.this.link[this.prev] ^ ((long)this.next & 0xFFFFFFFFL)) & 0xFFFFFFFFL);
            }
            if (this.next == -1) {
                ObjectLinkedOpenHashSet.this.last = this.prev;
            }
            else {
                final long[] link2 = ObjectLinkedOpenHashSet.this.link;
                final int next = this.next;
                link2[next] ^= ((ObjectLinkedOpenHashSet.this.link[this.next] ^ ((long)this.prev & 0xFFFFFFFFL) << 32) & 0xFFFFFFFF00000000L);
            }
            int lllllllllllllllIIllllllIIlIlIIIl = this.curr;
            this.curr = -1;
            if (lllllllllllllllIIllllllIIlIlIIIl == ObjectLinkedOpenHashSet.this.n) {
                ObjectLinkedOpenHashSet.this.containsNull = false;
                ObjectLinkedOpenHashSet.this.key[ObjectLinkedOpenHashSet.this.n] = null;
                return;
            }
            final K[] lllllllllllllllIIllllllIIlIlIlIl = ObjectLinkedOpenHashSet.this.key;
            int lllllllllllllllIIllllllIIlIlIlII = 0;
        Label_0280:
            while (true) {
                lllllllllllllllIIllllllIIlIlIIIl = ((lllllllllllllllIIllllllIIlIlIlII = lllllllllllllllIIllllllIIlIlIIIl) + 1 & ObjectLinkedOpenHashSet.this.mask);
                K lllllllllllllllIIllllllIIlIlIllI;
                while ((lllllllllllllllIIllllllIIlIlIllI = lllllllllllllllIIllllllIIlIlIlIl[lllllllllllllllIIllllllIIlIlIIIl]) != null) {
                    final int lllllllllllllllIIllllllIIlIlIIll = HashCommon.mix(lllllllllllllllIIllllllIIlIlIllI.hashCode()) & ObjectLinkedOpenHashSet.this.mask;
                    Label_0373: {
                        if (lllllllllllllllIIllllllIIlIlIlII <= lllllllllllllllIIllllllIIlIlIIIl) {
                            if (lllllllllllllllIIllllllIIlIlIlII >= lllllllllllllllIIllllllIIlIlIIll) {
                                break Label_0373;
                            }
                            if (lllllllllllllllIIllllllIIlIlIIll > lllllllllllllllIIllllllIIlIlIIIl) {
                                break Label_0373;
                            }
                        }
                        else if (lllllllllllllllIIllllllIIlIlIlII >= lllllllllllllllIIllllllIIlIlIIll && lllllllllllllllIIllllllIIlIlIIll > lllllllllllllllIIllllllIIlIlIIIl) {
                            break Label_0373;
                        }
                        lllllllllllllllIIllllllIIlIlIIIl = (lllllllllllllllIIllllllIIlIlIIIl + 1 & ObjectLinkedOpenHashSet.this.mask);
                        continue;
                    }
                    lllllllllllllllIIllllllIIlIlIlIl[lllllllllllllllIIllllllIIlIlIlII] = lllllllllllllllIIllllllIIlIlIllI;
                    if (this.next == lllllllllllllllIIllllllIIlIlIIIl) {
                        this.next = lllllllllllllllIIllllllIIlIlIlII;
                    }
                    if (this.prev == lllllllllllllllIIllllllIIlIlIIIl) {
                        this.prev = lllllllllllllllIIllllllIIlIlIlII;
                    }
                    ObjectLinkedOpenHashSet.this.fixPointers(lllllllllllllllIIllllllIIlIlIIIl, lllllllllllllllIIllllllIIlIlIlII);
                    continue Label_0280;
                }
                break;
            }
            lllllllllllllllIIllllllIIlIlIlIl[lllllllllllllllIIllllllIIlIlIlII] = null;
        }
        
        @Override
        public boolean hasPrevious() {
            return this.prev != -1;
        }
    }
}
