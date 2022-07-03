package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.io.*;

public class IntArraySet extends AbstractIntSet implements Cloneable, Serializable
{
    private /* synthetic */ int size;
    private transient /* synthetic */ int[] a;
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    private void readObject(final ObjectInputStream lllIIIlIIllIIII) throws ClassNotFoundException, IOException {
        lllIIIlIIllIIII.defaultReadObject();
        this.a = new int[this.size];
        for (int lllIIIlIIllIIlI = 0; lllIIIlIIllIIlI < this.size; ++lllIIIlIIllIIlI) {
            this.a[lllIIIlIIllIIlI] = lllIIIlIIllIIII.readInt();
        }
    }
    
    public IntArraySet(final IntCollection lllIIIllIIlIIIl) {
        this(lllIIIllIIlIIIl.size());
        this.addAll(lllIIIllIIlIIIl);
    }
    
    private int findKey(final int lllIIIlIllllIlI) {
        int lllIIIlIllllllI = this.size;
        while (lllIIIlIllllllI-- != 0) {
            if (this.a[lllIIIlIllllllI] == lllIIIlIllllIlI) {
                return lllIIIlIllllllI;
            }
        }
        return -1;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    public IntArraySet clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/ints/IntArraySet;
        //     7: astore_1        /* lllIIIlIlIIIlIl */
        //     8: goto            20
        //    11: astore_2        /* lllIIIlIlIIIlII */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lllIIIlIlIIIIlI */
        //    21: aload_0         /* lllIIIlIlIIIIIl */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/ints/IntArraySet.a:[I
        //    25: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    28: checkcast       [I
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/ints/IntArraySet.a:[I
        //    34: aload_1         /* lllIIIlIlIIIIlI */
        //    35: areturn        
        //    StackMapTable: 00 02 4B 07 00 64 FC 00 08 07 00 02
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
    public boolean contains(final int lllIIIlIlllIIlI) {
        return this.findKey(lllIIIlIlllIIlI) != -1;
    }
    
    public IntArraySet(final int[] lllIIIllIIIIIll, final int lllIIIllIIIIlIl) {
        this.a = lllIIIllIIIIIll;
        this.size = lllIIIllIIIIlIl;
        if (lllIIIllIIIIlIl > lllIIIllIIIIIll.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The provided size (").append(lllIIIllIIIIlIl).append(") is larger than or equal to the array size (").append(lllIIIllIIIIIll.length).append(")")));
        }
    }
    
    @Override
    public boolean add(final int lllIIIlIlIlIIlI) {
        final int lllIIIlIlIlIlII = this.findKey(lllIIIlIlIlIIlI);
        if (lllIIIlIlIlIlII != -1) {
            return false;
        }
        if (this.size == this.a.length) {
            final int[] lllIIIlIlIlIlll = new int[(this.size == 0) ? 2 : (this.size * 2)];
            int lllIIIlIlIllIII = this.size;
            while (lllIIIlIlIllIII-- != 0) {
                lllIIIlIlIlIlll[lllIIIlIlIllIII] = this.a[lllIIIlIlIllIII];
            }
            this.a = lllIIIlIlIlIlll;
        }
        this.a[this.size++] = lllIIIlIlIlIIlI;
        return true;
    }
    
    public IntArraySet(final Collection<? extends Integer> lllIIIllIIIlIll) {
        this(lllIIIllIIIlIll.size());
        this.addAll(lllIIIllIIIlIll);
    }
    
    public IntArraySet(final int[] lllIIIllIlIIIlI) {
        this.a = lllIIIllIlIIIlI;
        this.size = lllIIIllIlIIIlI.length;
    }
    
    @Override
    public IntIterator iterator() {
        return new IntIterator() {
            /* synthetic */ int next = 0;
            
            @Override
            public int nextInt() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return IntArraySet.this.a[this.next++];
            }
            
            @Override
            public void remove() {
                final int llllllllllllllIIlIIlIlllIllllIII = IntArraySet.this.size-- - this.next--;
                System.arraycopy(IntArraySet.this.a, this.next + 1, IntArraySet.this.a, this.next, llllllllllllllIIlIIlIlllIllllIII);
            }
            
            @Override
            public boolean hasNext() {
                return this.next < IntArraySet.this.size;
            }
        };
    }
    
    public IntArraySet(final int lllIIIllIIllIIl) {
        this.a = new int[lllIIIllIIllIIl];
    }
    
    public IntArraySet() {
        this.a = IntArrays.EMPTY_ARRAY;
    }
    
    @Override
    public boolean remove(final int lllIIIlIllIIlIl) {
        final int lllIIIlIllIIlII = this.findKey(lllIIIlIllIIlIl);
        if (lllIIIlIllIIlII == -1) {
            return false;
        }
        for (int lllIIIlIllIIIll = this.size - lllIIIlIllIIlII - 1, lllIIIlIllIIlll = 0; lllIIIlIllIIlll < lllIIIlIllIIIll; ++lllIIIlIllIIlll) {
            this.a[lllIIIlIllIIlII + lllIIIlIllIIlll] = this.a[lllIIIlIllIIlII + lllIIIlIllIIlll + 1];
        }
        --this.size;
        return true;
    }
    
    private void writeObject(final ObjectOutputStream lllIIIlIIllIlll) throws IOException {
        lllIIIlIIllIlll.defaultWriteObject();
        for (int lllIIIlIIlllIll = 0; lllIIIlIIlllIll < this.size; ++lllIIIlIIlllIll) {
            lllIIIlIIllIlll.writeInt(this.a[lllIIIlIIlllIll]);
        }
    }
    
    @Override
    public void clear() {
        this.size = 0;
    }
}
