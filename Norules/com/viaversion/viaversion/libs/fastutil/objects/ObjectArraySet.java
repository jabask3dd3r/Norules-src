package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;

public class ObjectArraySet<K> extends AbstractObjectSet<K> implements Serializable, Cloneable
{
    private /* synthetic */ int size;
    private transient /* synthetic */ Object[] a;
    
    public ObjectArraySet(final Object[] llllllllllllllllllIIIIlIIlllIIlI, final int llllllllllllllllllIIIIlIIllIlllI) {
        this.a = llllllllllllllllllIIIIlIIlllIIlI;
        this.size = llllllllllllllllllIIIIlIIllIlllI;
        if (llllllllllllllllllIIIIlIIllIlllI > llllllllllllllllllIIIIlIIlllIIlI.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The provided size (").append(llllllllllllllllllIIIIlIIllIlllI).append(") is larger than or equal to the array size (").append(llllllllllllllllllIIIIlIIlllIIlI.length).append(")")));
        }
    }
    
    @Override
    public boolean remove(final Object llllllllllllllllllIIIIlIIlIlIIIl) {
        final int llllllllllllllllllIIIIlIIlIlIIII = this.findKey(llllllllllllllllllIIIIlIIlIlIIIl);
        if (llllllllllllllllllIIIIlIIlIlIIII == -1) {
            return false;
        }
        for (int llllllllllllllllllIIIIlIIlIIllll = this.size - llllllllllllllllllIIIIlIIlIlIIII - 1, llllllllllllllllllIIIIlIIlIlIIll = 0; llllllllllllllllllIIIIlIIlIlIIll < llllllllllllllllllIIIIlIIlIIllll; ++llllllllllllllllllIIIIlIIlIlIIll) {
            this.a[llllllllllllllllllIIIIlIIlIlIIII + llllllllllllllllllIIIIlIIlIlIIll] = this.a[llllllllllllllllllIIIIlIIlIlIIII + llllllllllllllllllIIIIlIIlIlIIll + 1];
        }
        --this.size;
        this.a[this.size] = null;
        return true;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    private int findKey(final Object llllllllllllllllllIIIIlIIllIlIII) {
        int llllllllllllllllllIIIIlIIllIlIlI = this.size;
        while (llllllllllllllllllIIIIlIIllIlIlI-- != 0) {
            if (Objects.equals(this.a[llllllllllllllllllIIIIlIIllIlIlI], llllllllllllllllllIIIIlIIllIlIII)) {
                return llllllllllllllllllIIIIlIIllIlIlI;
            }
        }
        return -1;
    }
    
    @Override
    public boolean add(final K llllllllllllllllllIIIIlIIlIIIIIl) {
        final int llllllllllllllllllIIIIlIIlIIIIII = this.findKey(llllllllllllllllllIIIIlIIlIIIIIl);
        if (llllllllllllllllllIIIIlIIlIIIIII != -1) {
            return false;
        }
        if (this.size == this.a.length) {
            final Object[] llllllllllllllllllIIIIlIIlIIIIll = new Object[(this.size == 0) ? 2 : (this.size * 2)];
            int llllllllllllllllllIIIIlIIlIIIlII = this.size;
            while (llllllllllllllllllIIIIlIIlIIIlII-- != 0) {
                llllllllllllllllllIIIIlIIlIIIIll[llllllllllllllllllIIIIlIIlIIIlII] = this.a[llllllllllllllllllIIIIlIIlIIIlII];
            }
            this.a = llllllllllllllllllIIIIlIIlIIIIll;
        }
        this.a[this.size++] = llllllllllllllllllIIIIlIIlIIIIIl;
        return true;
    }
    
    private void readObject(final ObjectInputStream llllllllllllllllllIIIIlIIIIllIlI) throws ClassNotFoundException, IOException {
        llllllllllllllllllIIIIlIIIIllIlI.defaultReadObject();
        this.a = new Object[this.size];
        for (int llllllllllllllllllIIIIlIIIIllllI = 0; llllllllllllllllllIIIIlIIIIllllI < this.size; ++llllllllllllllllllIIIIlIIIIllllI) {
            this.a[llllllllllllllllllIIIIlIIIIllllI] = llllllllllllllllllIIIIlIIIIllIlI.readObject();
        }
    }
    
    public ObjectArraySet(final Collection<? extends K> llllllllllllllllllIIIIlIIllllIIl) {
        this(llllllllllllllllllIIIIlIIllllIIl.size());
        this.addAll(llllllllllllllllllIIIIlIIllllIIl);
    }
    
    @Override
    public void clear() {
        Arrays.fill(this.a, 0, this.size, null);
        this.size = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public ObjectArraySet<K> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectArraySet;
        //     7: astore_1        /* llllllllllllllllllIIIIlIIIlIllII */
        //     8: goto            20
        //    11: astore_2        /* llllllllllllllllllIIIIlIIIlIlIll */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllllllllIIIIlIIIlIlllI */
        //    21: aload_0         /* llllllllllllllllllIIIIlIIIlIllIl */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectArraySet.a:[Ljava/lang/Object;
        //    25: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    28: checkcast       [Ljava/lang/Object;
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectArraySet.a:[Ljava/lang/Object;
        //    34: aload_1         /* llllllllllllllllllIIIIlIIIlIlllI */
        //    35: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectArraySet<TK;>;
        //    StackMapTable: 00 02 4B 07 00 C1 FC 00 08 07 00 02
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
    public boolean contains(final Object llllllllllllllllllIIIIlIIlIllllI) {
        return this.findKey(llllllllllllllllllIIIIlIIlIllllI) != -1;
    }
    
    private void writeObject(final ObjectOutputStream llllllllllllllllllIIIIlIIIlIIIll) throws IOException {
        llllllllllllllllllIIIIlIIIlIIIll.defaultWriteObject();
        for (int llllllllllllllllllIIIIlIIIlIIlll = 0; llllllllllllllllllIIIIlIIIlIIlll < this.size; ++llllllllllllllllllIIIIlIIIlIIlll) {
            llllllllllllllllllIIIIlIIIlIIIll.writeObject(this.a[llllllllllllllllllIIIIlIIIlIIlll]);
        }
    }
    
    public ObjectArraySet(final ObjectCollection<K> llllllllllllllllllIIIIlIIlllllll) {
        this(llllllllllllllllllIIIIlIIlllllll.size());
        this.addAll((Collection<? extends K>)llllllllllllllllllIIIIlIIlllllll);
    }
    
    public ObjectArraySet() {
        this.a = ObjectArrays.EMPTY_ARRAY;
    }
    
    @Override
    public ObjectIterator<K> iterator() {
        return new ObjectIterator<K>() {
            /* synthetic */ int next = 0;
            
            @Override
            public void remove() {
                final int llllllllllllllllllIlIIlllllIllII = ObjectArraySet.this.size-- - this.next--;
                System.arraycopy(ObjectArraySet.this.a, this.next + 1, ObjectArraySet.this.a, this.next, llllllllllllllllllIlIIlllllIllII);
                ObjectArraySet.this.a[ObjectArraySet.this.size] = null;
            }
            
            @Override
            public K next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K)ObjectArraySet.this.a[this.next++];
            }
            
            @Override
            public boolean hasNext() {
                return this.next < ObjectArraySet.this.size;
            }
        };
    }
    
    public ObjectArraySet(final int llllllllllllllllllIIIIlIlIIIIIll) {
        this.a = new Object[llllllllllllllllllIIIIlIlIIIIIll];
    }
    
    public ObjectArraySet(final Object[] llllllllllllllllllIIIIlIlIIIllII) {
        this.a = llllllllllllllllllIIIIlIlIIIllII;
        this.size = llllllllllllllllllIIIIlIlIIIllII.length;
    }
}
