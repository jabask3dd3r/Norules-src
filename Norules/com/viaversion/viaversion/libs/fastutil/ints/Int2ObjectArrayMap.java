package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.io.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public class Int2ObjectArrayMap<V> extends AbstractInt2ObjectMap<V> implements Serializable, Cloneable
{
    private /* synthetic */ int size;
    private transient /* synthetic */ Object[] value;
    private transient /* synthetic */ int[] key;
    
    @Override
    public int size() {
        return this.size;
    }
    
    public Int2ObjectArrayMap(final int llllllllllllllIllllIlIlIIlllIlIl) {
        this.key = new int[llllllllllllllIllllIlIlIIlllIlIl];
        this.value = new Object[llllllllllllllIllllIlIlIIlllIlIl];
    }
    
    @Override
    public V remove(final int llllllllllllllIllllIlIlIIIIIIIll) {
        final int llllllllllllllIllllIlIlIIIIIIlll = this.findKey(llllllllllllllIllllIlIlIIIIIIIll);
        if (llllllllllllllIllllIlIlIIIIIIlll == -1) {
            return this.defRetValue;
        }
        final V llllllllllllllIllllIlIlIIIIIIllI = (V)this.value[llllllllllllllIllllIlIlIIIIIIlll];
        final int llllllllllllllIllllIlIlIIIIIIlIl = this.size - llllllllllllllIllllIlIlIIIIIIlll - 1;
        System.arraycopy(this.key, llllllllllllllIllllIlIlIIIIIIlll + 1, this.key, llllllllllllllIllllIlIlIIIIIIlll, llllllllllllllIllllIlIlIIIIIIlIl);
        System.arraycopy(this.value, llllllllllllllIllllIlIlIIIIIIlll + 1, this.value, llllllllllllllIllllIlIlIIIIIIlll, llllllllllllllIllllIlIlIIIIIIlIl);
        --this.size;
        this.value[this.size] = null;
        return llllllllllllllIllllIlIlIIIIIIllI;
    }
    
    public Int2ObjectArrayMap(final Map<? extends Integer, ? extends V> llllllllllllllIllllIlIlIIllIlIIl) {
        this(llllllllllllllIllllIlIlIIllIlIIl.size());
        this.putAll(llllllllllllllIllllIlIlIIllIlIIl);
    }
    
    @Override
    public IntSet keySet() {
        return new AbstractIntSet() {
            @Override
            public boolean contains(final int lllllllllllllIllIIIIIIlIIIIlIlIl) {
                return Int2ObjectArrayMap.this.findKey(lllllllllllllIllIIIIIIlIIIIlIlIl) != -1;
            }
            
            @Override
            public int size() {
                return Int2ObjectArrayMap.this.size;
            }
            
            @Override
            public boolean remove(final int lllllllllllllIllIIIIIIlIIIIIlIll) {
                final int lllllllllllllIllIIIIIIlIIIIIlllI = Int2ObjectArrayMap.this.findKey(lllllllllllllIllIIIIIIlIIIIIlIll);
                if (lllllllllllllIllIIIIIIlIIIIIlllI == -1) {
                    return false;
                }
                final int lllllllllllllIllIIIIIIlIIIIIllIl = Int2ObjectArrayMap.this.size - lllllllllllllIllIIIIIIlIIIIIlllI - 1;
                System.arraycopy(Int2ObjectArrayMap.this.key, lllllllllllllIllIIIIIIlIIIIIlllI + 1, Int2ObjectArrayMap.this.key, lllllllllllllIllIIIIIIlIIIIIlllI, lllllllllllllIllIIIIIIlIIIIIllIl);
                System.arraycopy(Int2ObjectArrayMap.this.value, lllllllllllllIllIIIIIIlIIIIIlllI + 1, Int2ObjectArrayMap.this.value, lllllllllllllIllIIIIIIlIIIIIlllI, lllllllllllllIllIIIIIIlIIIIIllIl);
                Int2ObjectArrayMap.this.size--;
                return true;
            }
            
            @Override
            public IntIterator iterator() {
                return new IntIterator() {
                    /* synthetic */ int pos = 0;
                    
                    @Override
                    public void remove() {
                        if (this.pos == 0) {
                            throw new IllegalStateException();
                        }
                        final int lllllllllllllIIlIllIlllIIIIlIlIl = Int2ObjectArrayMap.this.size - this.pos;
                        System.arraycopy(Int2ObjectArrayMap.this.key, this.pos, Int2ObjectArrayMap.this.key, this.pos - 1, lllllllllllllIIlIllIlllIIIIlIlIl);
                        System.arraycopy(Int2ObjectArrayMap.this.value, this.pos, Int2ObjectArrayMap.this.value, this.pos - 1, lllllllllllllIIlIllIlllIIIIlIlIl);
                        Int2ObjectArrayMap.this.size--;
                        --this.pos;
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.pos < Int2ObjectArrayMap.this.size;
                    }
                    
                    @Override
                    public int nextInt() {
                        if (!this.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return Int2ObjectArrayMap.this.key[this.pos++];
                    }
                };
            }
            
            @Override
            public void clear() {
                Int2ObjectArrayMap.this.clear();
            }
        };
    }
    
    @Override
    public boolean containsValue(final Object llllllllllllllIllllIlIlIIIlIlIIl) {
        int llllllllllllllIllllIlIlIIIlIllIl = this.size;
        while (llllllllllllllIllllIlIlIIIlIllIl-- != 0) {
            if (Objects.equals(this.value[llllllllllllllIllllIlIlIIIlIllIl], llllllllllllllIllllIlIlIIIlIlIIl)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean containsKey(final int llllllllllllllIllllIlIlIIIllIIIl) {
        return this.findKey(llllllllllllllIllllIlIlIIIllIIIl) != -1;
    }
    
    public Int2ObjectArrayMap() {
        this.key = IntArrays.EMPTY_ARRAY;
        this.value = ObjectArrays.EMPTY_ARRAY;
    }
    
    @Override
    public Int2ObjectMap.FastEntrySet<V> int2ObjectEntrySet() {
        return new EntrySet();
    }
    
    @Override
    public V put(final int llllllllllllllIllllIlIlIIIIllIII, final V llllllllllllllIllllIlIlIIIIlIlll) {
        final int llllllllllllllIllllIlIlIIIIlIllI = this.findKey(llllllllllllllIllllIlIlIIIIllIII);
        if (llllllllllllllIllllIlIlIIIIlIllI != -1) {
            final V llllllllllllllIllllIlIlIIIIlllIl = (V)this.value[llllllllllllllIllllIlIlIIIIlIllI];
            this.value[llllllllllllllIllllIlIlIIIIlIllI] = llllllllllllllIllllIlIlIIIIlIlll;
            return llllllllllllllIllllIlIlIIIIlllIl;
        }
        if (this.size == this.key.length) {
            final int[] llllllllllllllIllllIlIlIIIIllIll = new int[(this.size == 0) ? 2 : (this.size * 2)];
            final Object[] llllllllllllllIllllIlIlIIIIllIlI = new Object[(this.size == 0) ? 2 : (this.size * 2)];
            int llllllllllllllIllllIlIlIIIIlllII = this.size;
            while (llllllllllllllIllllIlIlIIIIlllII-- != 0) {
                llllllllllllllIllllIlIlIIIIllIll[llllllllllllllIllllIlIlIIIIlllII] = this.key[llllllllllllllIllllIlIlIIIIlllII];
                llllllllllllllIllllIlIlIIIIllIlI[llllllllllllllIllllIlIlIIIIlllII] = this.value[llllllllllllllIllllIlIlIIIIlllII];
            }
            this.key = llllllllllllllIllllIlIlIIIIllIll;
            this.value = llllllllllllllIllllIlIlIIIIllIlI;
        }
        this.key[this.size] = llllllllllllllIllllIlIlIIIIllIII;
        this.value[this.size] = llllllllllllllIllllIlIlIIIIlIlll;
        ++this.size;
        return this.defRetValue;
    }
    
    public Int2ObjectArrayMap(final int[] llllllllllllllIllllIlIlIIlllllIl, final Object[] llllllllllllllIllllIlIlIIlllllII) {
        this.key = llllllllllllllIllllIlIlIIlllllIl;
        this.value = llllllllllllllIllllIlIlIIlllllII;
        this.size = llllllllllllllIllllIlIlIIlllllIl.length;
        if (llllllllllllllIllllIlIlIIlllllIl.length != llllllllllllllIllllIlIlIIlllllII.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Keys and values have different lengths (").append(llllllllllllllIllllIlIlIIlllllIl.length).append(", ").append(llllllllllllllIllllIlIlIIlllllII.length).append(")")));
        }
    }
    
    @Override
    public ObjectCollection<V> values() {
        return new AbstractObjectCollection<V>() {
            @Override
            public int size() {
                return Int2ObjectArrayMap.this.size;
            }
            
            @Override
            public void clear() {
                Int2ObjectArrayMap.this.clear();
            }
            
            @Override
            public boolean contains(final Object lllllllllllllIllIlIIIlIIlIllIlII) {
                return Int2ObjectArrayMap.this.containsValue(lllllllllllllIllIlIIIlIIlIllIlII);
            }
            
            @Override
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() {
                    /* synthetic */ int pos = 0;
                    
                    @Override
                    public V next() {
                        if (!this.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return (V)Int2ObjectArrayMap.this.value[this.pos++];
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.pos < Int2ObjectArrayMap.this.size;
                    }
                    
                    @Override
                    public void remove() {
                        if (this.pos == 0) {
                            throw new IllegalStateException();
                        }
                        final int lllllllllllllllIIlIlIIlIllIIllIl = Int2ObjectArrayMap.this.size - this.pos;
                        System.arraycopy(Int2ObjectArrayMap.this.key, this.pos, Int2ObjectArrayMap.this.key, this.pos - 1, lllllllllllllllIIlIlIIlIllIIllIl);
                        System.arraycopy(Int2ObjectArrayMap.this.value, this.pos, Int2ObjectArrayMap.this.value, this.pos - 1, lllllllllllllllIIlIlIIlIllIIllIl);
                        Int2ObjectArrayMap.this.size--;
                    }
                };
            }
        };
    }
    
    private int findKey(final int llllllllllllllIllllIlIlIIlIlIIIl) {
        final int[] llllllllllllllIllllIlIlIIlIlIIII = this.key;
        int llllllllllllllIllllIlIlIIlIlIIll = this.size;
        while (llllllllllllllIllllIlIlIIlIlIIll-- != 0) {
            if (llllllllllllllIllllIlIlIIlIlIIII[llllllllllllllIllllIlIlIIlIlIIll] == llllllllllllllIllllIlIlIIlIlIIIl) {
                return llllllllllllllIllllIlIlIIlIlIIll;
            }
        }
        return -1;
    }
    
    @Override
    public V get(final int llllllllllllllIllllIlIlIIlIIIlIl) {
        final int[] llllllllllllllIllllIlIlIIlIIIlII = this.key;
        int llllllllllllllIllllIlIlIIlIIIlll = this.size;
        while (llllllllllllllIllllIlIlIIlIIIlll-- != 0) {
            if (llllllllllllllIllllIlIlIIlIIIlII[llllllllllllllIllllIlIlIIlIIIlll] == llllllllllllllIllllIlIlIIlIIIlIl) {
                return (V)this.value[llllllllllllllIllllIlIlIIlIIIlll];
            }
        }
        return this.defRetValue;
    }
    
    private void writeObject(final ObjectOutputStream llllllllllllllIllllIlIIllllIlIII) throws IOException {
        llllllllllllllIllllIlIIllllIlIII.defaultWriteObject();
        for (int llllllllllllllIllllIlIIllllIllII = 0; llllllllllllllIllllIlIIllllIllII < this.size; ++llllllllllllllIllllIlIIllllIllII) {
            llllllllllllllIllllIlIIllllIlIII.writeInt(this.key[llllllllllllllIllllIlIIllllIllII]);
            llllllllllllllIllllIlIIllllIlIII.writeObject(this.value[llllllllllllllIllllIlIIllllIllII]);
        }
    }
    
    public Int2ObjectArrayMap<V> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/ints/Int2ObjectArrayMap;
        //     7: astore_1        /* llllllllllllllIllllIlIIlllllIllI */
        //     8: goto            20
        //    11: astore_2        /* llllllllllllllIllllIlIIlllllIlIl */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllllIllllIlIIlllllIIll */
        //    21: aload_0         /* llllllllllllllIllllIlIIlllllIIlI */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectArrayMap.key:[I
        //    25: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    28: checkcast       [I
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectArrayMap.key:[I
        //    34: aload_1         /* llllllllllllllIllllIlIIlllllIIll */
        //    35: aload_0         /* llllllllllllllIllllIlIIlllllIIlI */
        //    36: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectArrayMap.value:[Ljava/lang/Object;
        //    39: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    42: checkcast       [Ljava/lang/Object;
        //    45: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2ObjectArrayMap.value:[Ljava/lang/Object;
        //    48: aload_1         /* llllllllllllllIllllIlIIlllllIIll */
        //    49: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/ints/Int2ObjectArrayMap<TV;>;
        //    StackMapTable: 00 02 4B 07 01 0B FC 00 08 07 00 02
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
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public void clear() {
        int llllllllllllllIllllIlIlIIIlllIlI = this.size;
        while (llllllllllllllIllllIlIlIIIlllIlI-- != 0) {
            this.value[llllllllllllllIllllIlIlIIIlllIlI] = null;
        }
        this.size = 0;
    }
    
    public Int2ObjectArrayMap(final Int2ObjectMap<V> llllllllllllllIllllIlIlIIllIllIl) {
        this(llllllllllllllIllllIlIlIIllIllIl.size());
        this.putAll((Map<? extends Integer, ? extends V>)llllllllllllllIllllIlIlIIllIllIl);
    }
    
    private void readObject(final ObjectInputStream llllllllllllllIllllIlIIlllIlllll) throws ClassNotFoundException, IOException {
        llllllllllllllIllllIlIIlllIlllll.defaultReadObject();
        this.key = new int[this.size];
        this.value = new Object[this.size];
        for (int llllllllllllllIllllIlIIllllIIIll = 0; llllllllllllllIllllIlIIllllIIIll < this.size; ++llllllllllllllIllllIlIIllllIIIll) {
            this.key[llllllllllllllIllllIlIIllllIIIll] = llllllllllllllIllllIlIIlllIlllll.readInt();
            this.value[llllllllllllllIllllIlIIllllIIIll] = llllllllllllllIllllIlIIlllIlllll.readObject();
        }
    }
    
    public Int2ObjectArrayMap(final int[] llllllllllllllIllllIlIlIIllIIIIl, final Object[] llllllllllllllIllllIlIlIIlIlllII, final int llllllllllllllIllllIlIlIIlIlllll) {
        this.key = llllllllllllllIllllIlIlIIllIIIIl;
        this.value = llllllllllllllIllllIlIlIIlIlllII;
        this.size = llllllllllllllIllllIlIlIIlIlllll;
        if (llllllllllllllIllllIlIlIIllIIIIl.length != llllllllllllllIllllIlIlIIlIlllII.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Keys and values have different lengths (").append(llllllllllllllIllllIlIlIIllIIIIl.length).append(", ").append(llllllllllllllIllllIlIlIIlIlllII.length).append(")")));
        }
        if (llllllllllllllIllllIlIlIIlIlllll > llllllllllllllIllllIlIlIIllIIIIl.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The provided size (").append(llllllllllllllIllllIlIlIIlIlllll).append(") is larger than or equal to the backing-arrays size (").append(llllllllllllllIllllIlIlIIllIIIIl.length).append(")")));
        }
    }
    
    private final class EntrySet extends AbstractObjectSet<Int2ObjectMap.Entry<V>> implements Int2ObjectMap.FastEntrySet<V>
    {
        @Override
        public ObjectIterator<Int2ObjectMap.Entry<V>> iterator() {
            return new ObjectIterator<Int2ObjectMap.Entry<V>>() {
                /* synthetic */ int next = 0;
                /* synthetic */ int curr = -1;
                
                @Override
                public Int2ObjectMap.Entry<V> next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final int[] access$100 = Int2ObjectArrayMap.this.key;
                    final int next = this.next;
                    this.curr = next;
                    return new BasicEntry<V>(access$100[next], Int2ObjectArrayMap.this.value[this.next++]);
                }
                
                @Override
                public boolean hasNext() {
                    return this.next < Int2ObjectArrayMap.this.size;
                }
                
                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    final int lllllllllllllIlIIIlIlIIIllIlIlIl = Int2ObjectArrayMap.this.size-- - this.next--;
                    System.arraycopy(Int2ObjectArrayMap.this.key, this.next + 1, Int2ObjectArrayMap.this.key, this.next, lllllllllllllIlIIIlIlIIIllIlIlIl);
                    System.arraycopy(Int2ObjectArrayMap.this.value, this.next + 1, Int2ObjectArrayMap.this.value, this.next, lllllllllllllIlIIIlIlIIIllIlIlIl);
                    Int2ObjectArrayMap.this.value[Int2ObjectArrayMap.this.size] = null;
                }
            };
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIlIIIllllIIlIlIllII) {
            if (!(lllllllllllllIlIIIllllIIlIlIllII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIlIIIllllIIlIlIlIll = (Map.Entry<?, ?>)lllllllllllllIlIIIllllIIlIlIllII;
            if (lllllllllllllIlIIIllllIIlIlIlIll.getKey() == null || !(lllllllllllllIlIIIllllIIlIlIlIll.getKey() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIlIIIllllIIlIlIlIlI = (int)lllllllllllllIlIIIllllIIlIlIlIll.getKey();
            final V lllllllllllllIlIIIllllIIlIlIlIIl = (V)lllllllllllllIlIIIllllIIlIlIlIll.getValue();
            final int lllllllllllllIlIIIllllIIlIlIlIII = Int2ObjectArrayMap.this.findKey(lllllllllllllIlIIIllllIIlIlIlIlI);
            if (lllllllllllllIlIIIllllIIlIlIlIII == -1 || !Objects.equals(lllllllllllllIlIIIllllIIlIlIlIIl, Int2ObjectArrayMap.this.value[lllllllllllllIlIIIllllIIlIlIlIII])) {
                return false;
            }
            final int lllllllllllllIlIIIllllIIlIlIIlll = Int2ObjectArrayMap.this.size - lllllllllllllIlIIIllllIIlIlIlIII - 1;
            System.arraycopy(Int2ObjectArrayMap.this.key, lllllllllllllIlIIIllllIIlIlIlIII + 1, Int2ObjectArrayMap.this.key, lllllllllllllIlIIIllllIIlIlIlIII, lllllllllllllIlIIIllllIIlIlIIlll);
            System.arraycopy(Int2ObjectArrayMap.this.value, lllllllllllllIlIIIllllIIlIlIlIII + 1, Int2ObjectArrayMap.this.value, lllllllllllllIlIIIllllIIlIlIlIII, lllllllllllllIlIIIllllIIlIlIIlll);
            Int2ObjectArrayMap.this.size--;
            Int2ObjectArrayMap.this.value[Int2ObjectArrayMap.this.size] = null;
            return true;
        }
        
        @Override
        public int size() {
            return Int2ObjectArrayMap.this.size;
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIlIIIllllIIlIlllIll) {
            if (!(lllllllllllllIlIIIllllIIlIlllIll instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIlIIIllllIIlIlllIlI = (Map.Entry<?, ?>)lllllllllllllIlIIIllllIIlIlllIll;
            if (lllllllllllllIlIIIllllIIlIlllIlI.getKey() == null || !(lllllllllllllIlIIIllllIIlIlllIlI.getKey() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIlIIIllllIIlIlllIIl = (int)lllllllllllllIlIIIllllIIlIlllIlI.getKey();
            return Int2ObjectArrayMap.this.containsKey(lllllllllllllIlIIIllllIIlIlllIIl) && Objects.equals(Int2ObjectArrayMap.this.get(lllllllllllllIlIIIllllIIlIlllIIl), lllllllllllllIlIIIllllIIlIlllIlI.getValue());
        }
        
        @Override
        public ObjectIterator<Int2ObjectMap.Entry<V>> fastIterator() {
            return new ObjectIterator<Int2ObjectMap.Entry<V>>() {
                /* synthetic */ int next = 0;
                final /* synthetic */ BasicEntry<V> entry = new BasicEntry<V>();
                /* synthetic */ int curr = -1;
                
                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    final int llllllllllllllIIIIIlIIIIIIIlllll = Int2ObjectArrayMap.this.size-- - this.next--;
                    System.arraycopy(Int2ObjectArrayMap.this.key, this.next + 1, Int2ObjectArrayMap.this.key, this.next, llllllllllllllIIIIIlIIIIIIIlllll);
                    System.arraycopy(Int2ObjectArrayMap.this.value, this.next + 1, Int2ObjectArrayMap.this.value, this.next, llllllllllllllIIIIIlIIIIIIIlllll);
                    Int2ObjectArrayMap.this.value[Int2ObjectArrayMap.this.size] = null;
                }
                
                @Override
                public boolean hasNext() {
                    return this.next < Int2ObjectArrayMap.this.size;
                }
                
                @Override
                public Int2ObjectMap.Entry<V> next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final BasicEntry<V> entry = this.entry;
                    final int[] access$100 = Int2ObjectArrayMap.this.key;
                    final int next = this.next;
                    this.curr = next;
                    entry.key = access$100[next];
                    this.entry.value = (V)Int2ObjectArrayMap.this.value[this.next++];
                    return this.entry;
                }
            };
        }
    }
}
