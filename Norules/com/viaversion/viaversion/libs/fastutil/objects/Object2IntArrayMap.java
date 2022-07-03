package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;
import java.io.*;

public class Object2IntArrayMap<K> extends AbstractObject2IntMap<K> implements Serializable, Cloneable
{
    private transient /* synthetic */ Object[] key;
    private /* synthetic */ int size;
    private transient /* synthetic */ int[] value;
    
    @Override
    public int put(final K lIIIllIIlIIIIIl, final int lIIIllIIlIIIlII) {
        final int lIIIllIIlIIIIll = this.findKey(lIIIllIIlIIIIIl);
        if (lIIIllIIlIIIIll != -1) {
            final int lIIIllIIlIIlIlI = this.value[lIIIllIIlIIIIll];
            this.value[lIIIllIIlIIIIll] = lIIIllIIlIIIlII;
            return lIIIllIIlIIlIlI;
        }
        if (this.size == this.key.length) {
            final Object[] lIIIllIIlIIlIII = new Object[(this.size == 0) ? 2 : (this.size * 2)];
            final int[] lIIIllIIlIIIlll = new int[(this.size == 0) ? 2 : (this.size * 2)];
            int lIIIllIIlIIlIIl = this.size;
            while (lIIIllIIlIIlIIl-- != 0) {
                lIIIllIIlIIlIII[lIIIllIIlIIlIIl] = this.key[lIIIllIIlIIlIIl];
                lIIIllIIlIIIlll[lIIIllIIlIIlIIl] = this.value[lIIIllIIlIIlIIl];
            }
            this.key = lIIIllIIlIIlIII;
            this.value = lIIIllIIlIIIlll;
        }
        this.key[this.size] = lIIIllIIlIIIIIl;
        this.value[this.size] = lIIIllIIlIIIlII;
        ++this.size;
        return this.defRetValue;
    }
    
    @Override
    public boolean containsValue(final int lIIIllIIlIllIII) {
        int lIIIllIIlIllIlI = this.size;
        while (lIIIllIIlIllIlI-- != 0) {
            if (this.value[lIIIllIIlIllIlI] == lIIIllIIlIllIII) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int getInt(final Object lIIIllIIllIllll) {
        final Object[] lIIIllIIlllIIIl = this.key;
        int lIIIllIIlllIlII = this.size;
        while (lIIIllIIlllIlII-- != 0) {
            if (Objects.equals(lIIIllIIlllIIIl[lIIIllIIlllIlII], lIIIllIIllIllll)) {
                return this.value[lIIIllIIlllIlII];
            }
        }
        return this.defRetValue;
    }
    
    public Object2IntArrayMap() {
        this.key = ObjectArrays.EMPTY_ARRAY;
        this.value = IntArrays.EMPTY_ARRAY;
    }
    
    public Object2IntArrayMap(final Object[] lIIIllIlIlIllIl, final int[] lIIIllIlIlIllII) {
        this.key = lIIIllIlIlIllIl;
        this.value = lIIIllIlIlIllII;
        this.size = lIIIllIlIlIllIl.length;
        if (lIIIllIlIlIllIl.length != lIIIllIlIlIllII.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Keys and values have different lengths (").append(lIIIllIlIlIllIl.length).append(", ").append(lIIIllIlIlIllII.length).append(")")));
        }
    }
    
    public Object2IntArrayMap(final Map<? extends K, ? extends Integer> lIIIllIlIIlIllI) {
        this(lIIIllIlIIlIllI.size());
        this.putAll(lIIIllIlIIlIllI);
    }
    
    @Override
    public boolean containsKey(final Object lIIIllIIlIllllI) {
        return this.findKey(lIIIllIIlIllllI) != -1;
    }
    
    @Override
    public Object2IntMap.FastEntrySet<K> object2IntEntrySet() {
        return new EntrySet();
    }
    
    @Override
    public int removeInt(final Object lIIIllIIIllIlIl) {
        final int lIIIllIIIllIlII = this.findKey(lIIIllIIIllIlIl);
        if (lIIIllIIIllIlII == -1) {
            return this.defRetValue;
        }
        final int lIIIllIIIllIIll = this.value[lIIIllIIIllIlII];
        final int lIIIllIIIllIIlI = this.size - lIIIllIIIllIlII - 1;
        System.arraycopy(this.key, lIIIllIIIllIlII + 1, this.key, lIIIllIIIllIlII, lIIIllIIIllIIlI);
        System.arraycopy(this.value, lIIIllIIIllIlII + 1, this.value, lIIIllIIIllIlII, lIIIllIIIllIIlI);
        --this.size;
        this.key[this.size] = null;
        return lIIIllIIIllIIll;
    }
    
    public Object2IntArrayMap<K> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/objects/Object2IntArrayMap;
        //     7: astore_1        /* lIIIllIIIlIIIll */
        //     8: goto            20
        //    11: astore_2        /* lIIIllIIIIlllIl */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lIIIllIIIlIIIII */
        //    21: aload_0         /* lIIIllIIIIlllll */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntArrayMap.key:[Ljava/lang/Object;
        //    25: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    28: checkcast       [Ljava/lang/Object;
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntArrayMap.key:[Ljava/lang/Object;
        //    34: aload_1         /* lIIIllIIIlIIIII */
        //    35: aload_0         /* lIIIllIIIIlllll */
        //    36: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntArrayMap.value:[I
        //    39: invokevirtual   [I.clone:()Ljava/lang/Object;
        //    42: checkcast       [I
        //    45: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2IntArrayMap.value:[I
        //    48: aload_1         /* lIIIllIIIlIIIII */
        //    49: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/objects/Object2IntArrayMap<TK;>;
        //    StackMapTable: 00 02 4B 07 00 DE FC 00 08 07 00 02
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
    
    public Object2IntArrayMap(final Object[] lIIIllIlIIIlIlI, final int[] lIIIllIlIIIlIIl, final int lIIIllIlIIIllII) {
        this.key = lIIIllIlIIIlIlI;
        this.value = lIIIllIlIIIlIIl;
        this.size = lIIIllIlIIIllII;
        if (lIIIllIlIIIlIlI.length != lIIIllIlIIIlIIl.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Keys and values have different lengths (").append(lIIIllIlIIIlIlI.length).append(", ").append(lIIIllIlIIIlIIl.length).append(")")));
        }
        if (lIIIllIlIIIllII > lIIIllIlIIIlIlI.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The provided size (").append(lIIIllIlIIIllII).append(") is larger than or equal to the backing-arrays size (").append(lIIIllIlIIIlIlI.length).append(")")));
        }
    }
    
    public Object2IntArrayMap(final Object2IntMap<K> lIIIllIlIIllIlI) {
        this(lIIIllIlIIllIlI.size());
        this.putAll((Map<? extends K, ? extends Integer>)lIIIllIlIIllIlI);
    }
    
    @Override
    public IntCollection values() {
        return new AbstractIntCollection() {
            @Override
            public boolean contains(final int lllllllllllllIlIIIIlIlIlllIIIIIl) {
                return Object2IntArrayMap.this.containsValue(lllllllllllllIlIIIIlIlIlllIIIIIl);
            }
            
            @Override
            public void clear() {
                Object2IntArrayMap.this.clear();
            }
            
            @Override
            public IntIterator iterator() {
                return new IntIterator() {
                    /* synthetic */ int pos = 0;
                    
                    @Override
                    public boolean hasNext() {
                        return this.pos < Object2IntArrayMap.this.size;
                    }
                    
                    @Override
                    public int nextInt() {
                        if (!this.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return Object2IntArrayMap.this.value[this.pos++];
                    }
                    
                    @Override
                    public void remove() {
                        if (this.pos == 0) {
                            throw new IllegalStateException();
                        }
                        final int lllllllllllllIllllIIlIIIlIIIlIIl = Object2IntArrayMap.this.size - this.pos;
                        System.arraycopy(Object2IntArrayMap.this.key, this.pos, Object2IntArrayMap.this.key, this.pos - 1, lllllllllllllIllllIIlIIIlIIIlIIl);
                        System.arraycopy(Object2IntArrayMap.this.value, this.pos, Object2IntArrayMap.this.value, this.pos - 1, lllllllllllllIllllIIlIIIlIIIlIIl);
                        Object2IntArrayMap.this.size--;
                    }
                };
            }
            
            @Override
            public int size() {
                return Object2IntArrayMap.this.size;
            }
        };
    }
    
    private void writeObject(final ObjectOutputStream lIIIllIIIIlIlIl) throws IOException {
        lIIIllIIIIlIlIl.defaultWriteObject();
        for (int lIIIllIIIIllIIl = 0; lIIIllIIIIllIIl < this.size; ++lIIIllIIIIllIIl) {
            lIIIllIIIIlIlIl.writeObject(this.key[lIIIllIIIIllIIl]);
            lIIIllIIIIlIlIl.writeInt(this.value[lIIIllIIIIllIIl]);
        }
    }
    
    private void readObject(final ObjectInputStream lIIIllIIIIIllII) throws ClassNotFoundException, IOException {
        lIIIllIIIIIllII.defaultReadObject();
        this.key = new Object[this.size];
        this.value = new int[this.size];
        for (int lIIIllIIIIlIIII = 0; lIIIllIIIIlIIII < this.size; ++lIIIllIIIIlIIII) {
            this.key[lIIIllIIIIlIIII] = lIIIllIIIIIllII.readObject();
            this.value[lIIIllIIIIlIIII] = lIIIllIIIIIllII.readInt();
        }
    }
    
    public Object2IntArrayMap(final int lIIIllIlIlIIIlI) {
        this.key = new Object[lIIIllIlIlIIIlI];
        this.value = new int[lIIIllIlIlIIIlI];
    }
    
    @Override
    public void clear() {
        int lIIIllIIllIIlll = this.size;
        while (lIIIllIIllIIlll-- != 0) {
            this.key[lIIIllIIllIIlll] = null;
        }
        this.size = 0;
    }
    
    private int findKey(final Object lIIIllIIllllllI) {
        final Object[] lIIIllIIlllllIl = this.key;
        int lIIIllIlIIIIIII = this.size;
        while (lIIIllIlIIIIIII-- != 0) {
            if (Objects.equals(lIIIllIIlllllIl[lIIIllIlIIIIIII], lIIIllIIllllllI)) {
                return lIIIllIlIIIIIII;
            }
        }
        return -1;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public ObjectSet<K> keySet() {
        return new AbstractObjectSet<K>() {
            @Override
            public void clear() {
                Object2IntArrayMap.this.clear();
            }
            
            @Override
            public boolean contains(final Object lllllllllllllIIIIlIIIllIIIIlllII) {
                return Object2IntArrayMap.this.findKey(lllllllllllllIIIIlIIIllIIIIlllII) != -1;
            }
            
            @Override
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() {
                    /* synthetic */ int pos = 0;
                    
                    @Override
                    public boolean hasNext() {
                        return this.pos < Object2IntArrayMap.this.size;
                    }
                    
                    @Override
                    public K next() {
                        if (!this.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return (K)Object2IntArrayMap.this.key[this.pos++];
                    }
                    
                    @Override
                    public void remove() {
                        if (this.pos == 0) {
                            throw new IllegalStateException();
                        }
                        final int lllllllllllllllllIIlIIlllIllllII = Object2IntArrayMap.this.size - this.pos;
                        System.arraycopy(Object2IntArrayMap.this.key, this.pos, Object2IntArrayMap.this.key, this.pos - 1, lllllllllllllllllIIlIIlllIllllII);
                        System.arraycopy(Object2IntArrayMap.this.value, this.pos, Object2IntArrayMap.this.value, this.pos - 1, lllllllllllllllllIIlIIlllIllllII);
                        Object2IntArrayMap.this.size--;
                        --this.pos;
                    }
                };
            }
            
            @Override
            public int size() {
                return Object2IntArrayMap.this.size;
            }
            
            @Override
            public boolean remove(final Object lllllllllllllIIIIlIIIllIIIIlIIlI) {
                final int lllllllllllllIIIIlIIIllIIIIlIlIl = Object2IntArrayMap.this.findKey(lllllllllllllIIIIlIIIllIIIIlIIlI);
                if (lllllllllllllIIIIlIIIllIIIIlIlIl == -1) {
                    return false;
                }
                final int lllllllllllllIIIIlIIIllIIIIlIlII = Object2IntArrayMap.this.size - lllllllllllllIIIIlIIIllIIIIlIlIl - 1;
                System.arraycopy(Object2IntArrayMap.this.key, lllllllllllllIIIIlIIIllIIIIlIlIl + 1, Object2IntArrayMap.this.key, lllllllllllllIIIIlIIIllIIIIlIlIl, lllllllllllllIIIIlIIIllIIIIlIlII);
                System.arraycopy(Object2IntArrayMap.this.value, lllllllllllllIIIIlIIIllIIIIlIlIl + 1, Object2IntArrayMap.this.value, lllllllllllllIIIIlIIIllIIIIlIlIl, lllllllllllllIIIIlIIIllIIIIlIlII);
                Object2IntArrayMap.this.size--;
                return true;
            }
        };
    }
    
    private final class EntrySet extends AbstractObjectSet<Object2IntMap.Entry<K>> implements Object2IntMap.FastEntrySet<K>
    {
        @Override
        public boolean contains(final Object llllllllllllllllllllIlllIlIlIIlI) {
            if (!(llllllllllllllllllllIlllIlIlIIlI instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> llllllllllllllllllllIlllIlIlIIIl = (Map.Entry<?, ?>)llllllllllllllllllllIlllIlIlIIlI;
            if (llllllllllllllllllllIlllIlIlIIIl.getValue() == null || !(llllllllllllllllllllIlllIlIlIIIl.getValue() instanceof Integer)) {
                return false;
            }
            final K llllllllllllllllllllIlllIlIlIIII = (K)llllllllllllllllllllIlllIlIlIIIl.getKey();
            return Object2IntArrayMap.this.containsKey(llllllllllllllllllllIlllIlIlIIII) && Object2IntArrayMap.this.getInt(llllllllllllllllllllIlllIlIlIIII) == (int)llllllllllllllllllllIlllIlIlIIIl.getValue();
        }
        
        @Override
        public int size() {
            return Object2IntArrayMap.this.size;
        }
        
        @Override
        public ObjectIterator<Object2IntMap.Entry<K>> iterator() {
            return new ObjectIterator<Object2IntMap.Entry<K>>() {
                /* synthetic */ int curr = -1;
                /* synthetic */ int next = 0;
                
                @Override
                public boolean hasNext() {
                    return this.next < Object2IntArrayMap.this.size;
                }
                
                @Override
                public Object2IntMap.Entry<K> next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final Object[] access$100 = Object2IntArrayMap.this.key;
                    final int next = this.next;
                    this.curr = next;
                    return new BasicEntry<K>(access$100[next], Object2IntArrayMap.this.value[this.next++]);
                }
                
                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    final int llllllllllllllIlIlllIlIlIIIIIlII = Object2IntArrayMap.this.size-- - this.next--;
                    System.arraycopy(Object2IntArrayMap.this.key, this.next + 1, Object2IntArrayMap.this.key, this.next, llllllllllllllIlIlllIlIlIIIIIlII);
                    System.arraycopy(Object2IntArrayMap.this.value, this.next + 1, Object2IntArrayMap.this.value, this.next, llllllllllllllIlIlllIlIlIIIIIlII);
                    Object2IntArrayMap.this.key[Object2IntArrayMap.this.size] = null;
                }
            };
        }
        
        @Override
        public boolean remove(final Object llllllllllllllllllllIlllIlIIIIll) {
            if (!(llllllllllllllllllllIlllIlIIIIll instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> llllllllllllllllllllIlllIlIIIIlI = (Map.Entry<?, ?>)llllllllllllllllllllIlllIlIIIIll;
            if (llllllllllllllllllllIlllIlIIIIlI.getValue() == null || !(llllllllllllllllllllIlllIlIIIIlI.getValue() instanceof Integer)) {
                return false;
            }
            final K llllllllllllllllllllIlllIlIIIIIl = (K)llllllllllllllllllllIlllIlIIIIlI.getKey();
            final int llllllllllllllllllllIlllIlIIIIII = (int)llllllllllllllllllllIlllIlIIIIlI.getValue();
            final int llllllllllllllllllllIlllIIllllll = Object2IntArrayMap.this.findKey(llllllllllllllllllllIlllIlIIIIIl);
            if (llllllllllllllllllllIlllIIllllll == -1 || llllllllllllllllllllIlllIlIIIIII != Object2IntArrayMap.this.value[llllllllllllllllllllIlllIIllllll]) {
                return false;
            }
            final int llllllllllllllllllllIlllIIlllllI = Object2IntArrayMap.this.size - llllllllllllllllllllIlllIIllllll - 1;
            System.arraycopy(Object2IntArrayMap.this.key, llllllllllllllllllllIlllIIllllll + 1, Object2IntArrayMap.this.key, llllllllllllllllllllIlllIIllllll, llllllllllllllllllllIlllIIlllllI);
            System.arraycopy(Object2IntArrayMap.this.value, llllllllllllllllllllIlllIIllllll + 1, Object2IntArrayMap.this.value, llllllllllllllllllllIlllIIllllll, llllllllllllllllllllIlllIIlllllI);
            Object2IntArrayMap.this.size--;
            Object2IntArrayMap.this.key[Object2IntArrayMap.this.size] = null;
            return true;
        }
        
        @Override
        public ObjectIterator<Object2IntMap.Entry<K>> fastIterator() {
            return new ObjectIterator<Object2IntMap.Entry<K>>() {
                final /* synthetic */ BasicEntry<K> entry = new BasicEntry<K>();
                /* synthetic */ int next = 0;
                /* synthetic */ int curr = -1;
                
                @Override
                public Object2IntMap.Entry<K> next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final BasicEntry<K> entry = this.entry;
                    final Object[] access$100 = Object2IntArrayMap.this.key;
                    final int next = this.next;
                    this.curr = next;
                    entry.key = (K)access$100[next];
                    this.entry.value = Object2IntArrayMap.this.value[this.next++];
                    return this.entry;
                }
                
                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    final int lllllllllllllIlIllllIIIIIIlIllll = Object2IntArrayMap.this.size-- - this.next--;
                    System.arraycopy(Object2IntArrayMap.this.key, this.next + 1, Object2IntArrayMap.this.key, this.next, lllllllllllllIlIllllIIIIIIlIllll);
                    System.arraycopy(Object2IntArrayMap.this.value, this.next + 1, Object2IntArrayMap.this.value, this.next, lllllllllllllIlIllllIIIIIIlIllll);
                    Object2IntArrayMap.this.key[Object2IntArrayMap.this.size] = null;
                }
                
                @Override
                public boolean hasNext() {
                    return this.next < Object2IntArrayMap.this.size;
                }
            };
        }
    }
}
