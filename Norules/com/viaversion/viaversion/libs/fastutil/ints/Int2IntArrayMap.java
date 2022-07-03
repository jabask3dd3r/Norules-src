package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.io.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public class Int2IntArrayMap extends AbstractInt2IntMap implements Cloneable, Serializable
{
    private /* synthetic */ int size;
    private transient /* synthetic */ int[] key;
    private transient /* synthetic */ int[] value;
    
    @Override
    public int put(final int llllllllllllIlllllIlIlIllIIlIIIl, final int llllllllllllIlllllIlIlIllIIlIlII) {
        final int llllllllllllIlllllIlIlIllIIlIIll = this.findKey(llllllllllllIlllllIlIlIllIIlIIIl);
        if (llllllllllllIlllllIlIlIllIIlIIll != -1) {
            final int llllllllllllIlllllIlIlIllIIllIlI = this.value[llllllllllllIlllllIlIlIllIIlIIll];
            this.value[llllllllllllIlllllIlIlIllIIlIIll] = llllllllllllIlllllIlIlIllIIlIlII;
            return llllllllllllIlllllIlIlIllIIllIlI;
        }
        if (this.size == this.key.length) {
            final int[] llllllllllllIlllllIlIlIllIIllIII = new int[(this.size == 0) ? 2 : (this.size * 2)];
            final int[] llllllllllllIlllllIlIlIllIIlIlll = new int[(this.size == 0) ? 2 : (this.size * 2)];
            int llllllllllllIlllllIlIlIllIIllIIl = this.size;
            while (llllllllllllIlllllIlIlIllIIllIIl-- != 0) {
                llllllllllllIlllllIlIlIllIIllIII[llllllllllllIlllllIlIlIllIIllIIl] = this.key[llllllllllllIlllllIlIlIllIIllIIl];
                llllllllllllIlllllIlIlIllIIlIlll[llllllllllllIlllllIlIlIllIIllIIl] = this.value[llllllllllllIlllllIlIlIllIIllIIl];
            }
            this.key = llllllllllllIlllllIlIlIllIIllIII;
            this.value = llllllllllllIlllllIlIlIllIIlIlll;
        }
        this.key[this.size] = llllllllllllIlllllIlIlIllIIlIIIl;
        this.value[this.size] = llllllllllllIlllllIlIlIllIIlIlII;
        ++this.size;
        return this.defRetValue;
    }
    
    @Override
    public boolean containsKey(final int llllllllllllIlllllIlIlIllIlIlllI) {
        return this.findKey(llllllllllllIlllllIlIlIllIlIlllI) != -1;
    }
    
    private void writeObject(final ObjectOutputStream llllllllllllIlllllIlIlIlIllIIlIl) throws IOException {
        llllllllllllIlllllIlIlIlIllIIlIl.defaultWriteObject();
        for (int llllllllllllIlllllIlIlIlIllIlIIl = 0; llllllllllllIlllllIlIlIlIllIlIIl < this.size; ++llllllllllllIlllllIlIlIlIllIlIIl) {
            llllllllllllIlllllIlIlIlIllIIlIl.writeInt(this.key[llllllllllllIlllllIlIlIlIllIlIIl]);
            llllllllllllIlllllIlIlIlIllIIlIl.writeInt(this.value[llllllllllllIlllllIlIlIlIllIlIIl]);
        }
    }
    
    @Override
    public IntSet keySet() {
        return new AbstractIntSet() {
            @Override
            public IntIterator iterator() {
                return new IntIterator() {
                    /* synthetic */ int pos = 0;
                    
                    @Override
                    public boolean hasNext() {
                        return this.pos < Int2IntArrayMap.this.size;
                    }
                    
                    @Override
                    public void remove() {
                        if (this.pos == 0) {
                            throw new IllegalStateException();
                        }
                        final int llllllllllllllIIIlIIIlllIIIlllll = Int2IntArrayMap.this.size - this.pos;
                        System.arraycopy(Int2IntArrayMap.this.key, this.pos, Int2IntArrayMap.this.key, this.pos - 1, llllllllllllllIIIlIIIlllIIIlllll);
                        System.arraycopy(Int2IntArrayMap.this.value, this.pos, Int2IntArrayMap.this.value, this.pos - 1, llllllllllllllIIIlIIIlllIIIlllll);
                        Int2IntArrayMap.this.size--;
                        --this.pos;
                    }
                    
                    @Override
                    public int nextInt() {
                        if (!this.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return Int2IntArrayMap.this.key[this.pos++];
                    }
                };
            }
            
            @Override
            public boolean remove(final int lllllllllllllIlllllIIllIIIIlIllI) {
                final int lllllllllllllIlllllIIllIIIIlIlIl = Int2IntArrayMap.this.findKey(lllllllllllllIlllllIIllIIIIlIllI);
                if (lllllllllllllIlllllIIllIIIIlIlIl == -1) {
                    return false;
                }
                final int lllllllllllllIlllllIIllIIIIlIlII = Int2IntArrayMap.this.size - lllllllllllllIlllllIIllIIIIlIlIl - 1;
                System.arraycopy(Int2IntArrayMap.this.key, lllllllllllllIlllllIIllIIIIlIlIl + 1, Int2IntArrayMap.this.key, lllllllllllllIlllllIIllIIIIlIlIl, lllllllllllllIlllllIIllIIIIlIlII);
                System.arraycopy(Int2IntArrayMap.this.value, lllllllllllllIlllllIIllIIIIlIlIl + 1, Int2IntArrayMap.this.value, lllllllllllllIlllllIIllIIIIlIlIl, lllllllllllllIlllllIIllIIIIlIlII);
                Int2IntArrayMap.this.size--;
                return true;
            }
            
            @Override
            public int size() {
                return Int2IntArrayMap.this.size;
            }
            
            @Override
            public boolean contains(final int lllllllllllllIlllllIIllIIIIlllII) {
                return Int2IntArrayMap.this.findKey(lllllllllllllIlllllIIllIIIIlllII) != -1;
            }
            
            @Override
            public void clear() {
                Int2IntArrayMap.this.clear();
            }
        };
    }
    
    private int findKey(final int llllllllllllIlllllIlIlIlllIIlIII) {
        final int[] llllllllllllIlllllIlIlIlllIIlIlI = this.key;
        int llllllllllllIlllllIlIlIlllIIllIl = this.size;
        while (llllllllllllIlllllIlIlIlllIIllIl-- != 0) {
            if (llllllllllllIlllllIlIlIlllIIlIlI[llllllllllllIlllllIlIlIlllIIllIl] == llllllllllllIlllllIlIlIlllIIlIII) {
                return llllllllllllIlllllIlIlIlllIIllIl;
            }
        }
        return -1;
    }
    
    public Int2IntArrayMap(final Int2IntMap llllllllllllIlllllIlIlIllllIIlll) {
        this(llllllllllllIlllllIlIlIllllIIlll.size());
        this.putAll(llllllllllllIlllllIlIlIllllIIlll);
    }
    
    public Int2IntArrayMap(final int llllllllllllIlllllIlIlIllllIllll) {
        this.key = new int[llllllllllllIlllllIlIlIllllIllll];
        this.value = new int[llllllllllllIlllllIlIlIllllIllll];
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public Int2IntArrayMap(final Map<? extends Integer, ? extends Integer> llllllllllllIlllllIlIlIllllIIIll) {
        this(llllllllllllIlllllIlIlIllllIIIll.size());
        this.putAll(llllllllllllIlllllIlIlIllllIIIll);
    }
    
    public Int2IntArrayMap() {
        this.key = IntArrays.EMPTY_ARRAY;
        this.value = IntArrays.EMPTY_ARRAY;
    }
    
    @Override
    public int remove(final int llllllllllllIlllllIlIlIllIIIIlIl) {
        final int llllllllllllIlllllIlIlIllIIIIlII = this.findKey(llllllllllllIlllllIlIlIllIIIIlIl);
        if (llllllllllllIlllllIlIlIllIIIIlII == -1) {
            return this.defRetValue;
        }
        final int llllllllllllIlllllIlIlIllIIIIIll = this.value[llllllllllllIlllllIlIlIllIIIIlII];
        final int llllllllllllIlllllIlIlIllIIIIIlI = this.size - llllllllllllIlllllIlIlIllIIIIlII - 1;
        System.arraycopy(this.key, llllllllllllIlllllIlIlIllIIIIlII + 1, this.key, llllllllllllIlllllIlIlIllIIIIlII, llllllllllllIlllllIlIlIllIIIIIlI);
        System.arraycopy(this.value, llllllllllllIlllllIlIlIllIIIIlII + 1, this.value, llllllllllllIlllllIlIlIllIIIIlII, llllllllllllIlllllIlIlIllIIIIIlI);
        --this.size;
        return llllllllllllIlllllIlIlIllIIIIIll;
    }
    
    @Override
    public Int2IntMap.FastEntrySet int2IntEntrySet() {
        return new EntrySet();
    }
    
    private void readObject(final ObjectInputStream llllllllllllIlllllIlIlIlIlIlllII) throws IOException, ClassNotFoundException {
        llllllllllllIlllllIlIlIlIlIlllII.defaultReadObject();
        this.key = new int[this.size];
        this.value = new int[this.size];
        for (int llllllllllllIlllllIlIlIlIllIIIII = 0; llllllllllllIlllllIlIlIlIllIIIII < this.size; ++llllllllllllIlllllIlIlIlIllIIIII) {
            this.key[llllllllllllIlllllIlIlIlIllIIIII] = llllllllllllIlllllIlIlIlIlIlllII.readInt();
            this.value[llllllllllllIlllllIlIlIlIllIIIII] = llllllllllllIlllllIlIlIlIlIlllII.readInt();
        }
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    public Int2IntArrayMap clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/ints/Int2IntArrayMap;
        //     7: astore_1        /* llllllllllllIlllllIlIlIlIllIlllI */
        //     8: goto            20
        //    11: astore_2        /* llllllllllllIlllllIlIlIlIlllIIlI */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllIlllllIlIlIlIlllIIII */
        //    21: aload_0         /* llllllllllllIlllllIlIlIlIllIllll */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntArrayMap.key:[I
        //    25: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    28: checkcast       [I
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntArrayMap.key:[I
        //    34: aload_1         /* llllllllllllIlllllIlIlIlIlllIIII */
        //    35: aload_0         /* llllllllllllIlllllIlIlIlIllIllll */
        //    36: getfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntArrayMap.value:[I
        //    39: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    42: checkcast       [I
        //    45: putfield        com/viaversion/viaversion/libs/fastutil/ints/Int2IntArrayMap.value:[I
        //    48: aload_1         /* llllllllllllIlllllIlIlIlIlllIIII */
        //    49: areturn        
        //    StackMapTable: 00 02 4B 07 00 E6 FC 00 08 07 00 02
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
    public int get(final int llllllllllllIlllllIlIlIllIllllll) {
        final int[] llllllllllllIlllllIlIlIllIlllllI = this.key;
        int llllllllllllIlllllIlIlIlllIIIIIl = this.size;
        while (llllllllllllIlllllIlIlIlllIIIIIl-- != 0) {
            if (llllllllllllIlllllIlIlIllIlllllI[llllllllllllIlllllIlIlIlllIIIIIl] == llllllllllllIlllllIlIlIllIllllll) {
                return this.value[llllllllllllIlllllIlIlIlllIIIIIl];
            }
        }
        return this.defRetValue;
    }
    
    public Int2IntArrayMap(final int[] llllllllllllIlllllIlIlIlllllIlll, final int[] llllllllllllIlllllIlIlIlllllIllI) {
        this.key = llllllllllllIlllllIlIlIlllllIlll;
        this.value = llllllllllllIlllllIlIlIlllllIllI;
        this.size = llllllllllllIlllllIlIlIlllllIlll.length;
        if (llllllllllllIlllllIlIlIlllllIlll.length != llllllllllllIlllllIlIlIlllllIllI.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Keys and values have different lengths (").append(llllllllllllIlllllIlIlIlllllIlll.length).append(", ").append(llllllllllllIlllllIlIlIlllllIllI.length).append(")")));
        }
    }
    
    @Override
    public void clear() {
        this.size = 0;
    }
    
    public Int2IntArrayMap(final int[] llllllllllllIlllllIlIlIlllIlIlll, final int[] llllllllllllIlllllIlIlIlllIlIllI, final int llllllllllllIlllllIlIlIlllIllIIl) {
        this.key = llllllllllllIlllllIlIlIlllIlIlll;
        this.value = llllllllllllIlllllIlIlIlllIlIllI;
        this.size = llllllllllllIlllllIlIlIlllIllIIl;
        if (llllllllllllIlllllIlIlIlllIlIlll.length != llllllllllllIlllllIlIlIlllIlIllI.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Keys and values have different lengths (").append(llllllllllllIlllllIlIlIlllIlIlll.length).append(", ").append(llllllllllllIlllllIlIlIlllIlIllI.length).append(")")));
        }
        if (llllllllllllIlllllIlIlIlllIllIIl > llllllllllllIlllllIlIlIlllIlIlll.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The provided size (").append(llllllllllllIlllllIlIlIlllIllIIl).append(") is larger than or equal to the backing-arrays size (").append(llllllllllllIlllllIlIlIlllIlIlll.length).append(")")));
        }
    }
    
    @Override
    public boolean containsValue(final int llllllllllllIlllllIlIlIllIlIIllI) {
        int llllllllllllIlllllIlIlIllIlIlIlI = this.size;
        while (llllllllllllIlllllIlIlIllIlIlIlI-- != 0) {
            if (this.value[llllllllllllIlllllIlIlIllIlIlIlI] == llllllllllllIlllllIlIlIllIlIIllI) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public IntCollection values() {
        return new AbstractIntCollection() {
            @Override
            public void clear() {
                Int2IntArrayMap.this.clear();
            }
            
            @Override
            public int size() {
                return Int2IntArrayMap.this.size;
            }
            
            @Override
            public boolean contains(final int lllllllllllllIlIIIIIIllIlllllIll) {
                return Int2IntArrayMap.this.containsValue(lllllllllllllIlIIIIIIllIlllllIll);
            }
            
            @Override
            public IntIterator iterator() {
                return new IntIterator() {
                    /* synthetic */ int pos = 0;
                    
                    @Override
                    public int nextInt() {
                        if (!this.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return Int2IntArrayMap.this.value[this.pos++];
                    }
                    
                    @Override
                    public void remove() {
                        if (this.pos == 0) {
                            throw new IllegalStateException();
                        }
                        final int llllllllllllllIIIllllIlIllIIllII = Int2IntArrayMap.this.size - this.pos;
                        System.arraycopy(Int2IntArrayMap.this.key, this.pos, Int2IntArrayMap.this.key, this.pos - 1, llllllllllllllIIIllllIlIllIIllII);
                        System.arraycopy(Int2IntArrayMap.this.value, this.pos, Int2IntArrayMap.this.value, this.pos - 1, llllllllllllllIIIllllIlIllIIllII);
                        Int2IntArrayMap.this.size--;
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.pos < Int2IntArrayMap.this.size;
                    }
                };
            }
        };
    }
    
    private final class EntrySet extends AbstractObjectSet<Int2IntMap.Entry> implements Int2IntMap.FastEntrySet
    {
        @Override
        public ObjectIterator<Int2IntMap.Entry> fastIterator() {
            return new ObjectIterator<Int2IntMap.Entry>() {
                /* synthetic */ int curr = -1;
                /* synthetic */ int next = 0;
                final /* synthetic */ BasicEntry entry = new BasicEntry();
                
                @Override
                public boolean hasNext() {
                    return this.next < Int2IntArrayMap.this.size;
                }
                
                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    final int lllllllllllllIlIIlIllllIlIIlllII = Int2IntArrayMap.this.size-- - this.next--;
                    System.arraycopy(Int2IntArrayMap.this.key, this.next + 1, Int2IntArrayMap.this.key, this.next, lllllllllllllIlIIlIllllIlIIlllII);
                    System.arraycopy(Int2IntArrayMap.this.value, this.next + 1, Int2IntArrayMap.this.value, this.next, lllllllllllllIlIIlIllllIlIIlllII);
                }
                
                @Override
                public Int2IntMap.Entry next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final BasicEntry entry = this.entry;
                    final int[] access$100 = Int2IntArrayMap.this.key;
                    final int next = this.next;
                    this.curr = next;
                    entry.key = access$100[next];
                    this.entry.value = Int2IntArrayMap.this.value[this.next++];
                    return this.entry;
                }
            };
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIIIIlIIlllIlllIIlII) {
            if (!(lllllllllllllIIIIlIIlllIlllIIlII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIIIIlIIlllIlllIIlll = (Map.Entry<?, ?>)lllllllllllllIIIIlIIlllIlllIIlII;
            if (lllllllllllllIIIIlIIlllIlllIIlll.getKey() == null || !(lllllllllllllIIIIlIIlllIlllIIlll.getKey() instanceof Integer)) {
                return false;
            }
            if (lllllllllllllIIIIlIIlllIlllIIlll.getValue() == null || !(lllllllllllllIIIIlIIlllIlllIIlll.getValue() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIIIIlIIlllIlllIIllI = (int)lllllllllllllIIIIlIIlllIlllIIlll.getKey();
            return Int2IntArrayMap.this.containsKey(lllllllllllllIIIIlIIlllIlllIIllI) && Int2IntArrayMap.this.get(lllllllllllllIIIIlIIlllIlllIIllI) == (int)lllllllllllllIIIIlIIlllIlllIIlll.getValue();
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIIIIlIIlllIllIllIIl) {
            if (!(lllllllllllllIIIIlIIlllIllIllIIl instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIIIIlIIlllIllIllIII = (Map.Entry<?, ?>)lllllllllllllIIIIlIIlllIllIllIIl;
            if (lllllllllllllIIIIlIIlllIllIllIII.getKey() == null || !(lllllllllllllIIIIlIIlllIllIllIII.getKey() instanceof Integer)) {
                return false;
            }
            if (lllllllllllllIIIIlIIlllIllIllIII.getValue() == null || !(lllllllllllllIIIIlIIlllIllIllIII.getValue() instanceof Integer)) {
                return false;
            }
            final int lllllllllllllIIIIlIIlllIllIlIlll = (int)lllllllllllllIIIIlIIlllIllIllIII.getKey();
            final int lllllllllllllIIIIlIIlllIllIlIllI = (int)lllllllllllllIIIIlIIlllIllIllIII.getValue();
            final int lllllllllllllIIIIlIIlllIllIlIlIl = Int2IntArrayMap.this.findKey(lllllllllllllIIIIlIIlllIllIlIlll);
            if (lllllllllllllIIIIlIIlllIllIlIlIl == -1 || lllllllllllllIIIIlIIlllIllIlIllI != Int2IntArrayMap.this.value[lllllllllllllIIIIlIIlllIllIlIlIl]) {
                return false;
            }
            final int lllllllllllllIIIIlIIlllIllIlIlII = Int2IntArrayMap.this.size - lllllllllllllIIIIlIIlllIllIlIlIl - 1;
            System.arraycopy(Int2IntArrayMap.this.key, lllllllllllllIIIIlIIlllIllIlIlIl + 1, Int2IntArrayMap.this.key, lllllllllllllIIIIlIIlllIllIlIlIl, lllllllllllllIIIIlIIlllIllIlIlII);
            System.arraycopy(Int2IntArrayMap.this.value, lllllllllllllIIIIlIIlllIllIlIlIl + 1, Int2IntArrayMap.this.value, lllllllllllllIIIIlIIlllIllIlIlIl, lllllllllllllIIIIlIIlllIllIlIlII);
            Int2IntArrayMap.this.size--;
            return true;
        }
        
        @Override
        public ObjectIterator<Int2IntMap.Entry> iterator() {
            return new ObjectIterator<Int2IntMap.Entry>() {
                /* synthetic */ int next = 0;
                /* synthetic */ int curr = -1;
                
                @Override
                public boolean hasNext() {
                    return this.next < Int2IntArrayMap.this.size;
                }
                
                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    final int lllllllllllllIllIllllIIlllIIlllI = Int2IntArrayMap.this.size-- - this.next--;
                    System.arraycopy(Int2IntArrayMap.this.key, this.next + 1, Int2IntArrayMap.this.key, this.next, lllllllllllllIllIllllIIlllIIlllI);
                    System.arraycopy(Int2IntArrayMap.this.value, this.next + 1, Int2IntArrayMap.this.value, this.next, lllllllllllllIllIllllIIlllIIlllI);
                }
                
                @Override
                public Int2IntMap.Entry next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final int[] access$100 = Int2IntArrayMap.this.key;
                    final int next = this.next;
                    this.curr = next;
                    return new BasicEntry(access$100[next], Int2IntArrayMap.this.value[this.next++]);
                }
            };
        }
        
        @Override
        public int size() {
            return Int2IntArrayMap.this.size;
        }
    }
}
