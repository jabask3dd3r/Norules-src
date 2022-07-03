package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;

public class Object2ObjectArrayMap<K, V> extends AbstractObject2ObjectMap<K, V> implements Serializable, Cloneable
{
    private /* synthetic */ int size;
    private transient /* synthetic */ Object[] value;
    private transient /* synthetic */ Object[] key;
    
    @Override
    public V get(final Object lllllllllllllIIIlllIllllIIIIlllI) {
        final Object[] lllllllllllllIIIlllIllllIIIlIIII = this.key;
        int lllllllllllllIIIlllIllllIIIlIIll = this.size;
        while (lllllllllllllIIIlllIllllIIIlIIll-- != 0) {
            if (Objects.equals(lllllllllllllIIIlllIllllIIIlIIII[lllllllllllllIIIlllIllllIIIlIIll], lllllllllllllIIIlllIllllIIIIlllI)) {
                return (V)this.value[lllllllllllllIIIlllIllllIIIlIIll];
            }
        }
        return this.defRetValue;
    }
    
    public Object2ObjectArrayMap(final Object[] lllllllllllllIIIlllIllllIlIIlIIl, final Object[] lllllllllllllIIIlllIllllIlIIlIll) {
        this.key = lllllllllllllIIIlllIllllIlIIlIIl;
        this.value = lllllllllllllIIIlllIllllIlIIlIll;
        this.size = lllllllllllllIIIlllIllllIlIIlIIl.length;
        if (lllllllllllllIIIlllIllllIlIIlIIl.length != lllllllllllllIIIlllIllllIlIIlIll.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Keys and values have different lengths (").append(lllllllllllllIIIlllIllllIlIIlIIl.length).append(", ").append(lllllllllllllIIIlllIllllIlIIlIll.length).append(")")));
        }
    }
    
    public Object2ObjectArrayMap(final int lllllllllllllIIIlllIllllIIllllll) {
        this.key = new Object[lllllllllllllIIIlllIllllIIllllll];
        this.value = new Object[lllllllllllllIIIlllIllllIIllllll];
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    private void readObject(final ObjectInputStream lllllllllllllIIIlllIlllIlIlIllIl) throws IOException, ClassNotFoundException {
        lllllllllllllIIIlllIlllIlIlIllIl.defaultReadObject();
        this.key = new Object[this.size];
        this.value = new Object[this.size];
        for (int lllllllllllllIIIlllIlllIlIlIllll = 0; lllllllllllllIIIlllIlllIlIlIllll < this.size; ++lllllllllllllIIIlllIlllIlIlIllll) {
            this.key[lllllllllllllIIIlllIlllIlIlIllll] = lllllllllllllIIIlllIlllIlIlIllIl.readObject();
            this.value[lllllllllllllIIIlllIlllIlIlIllll] = lllllllllllllIIIlllIlllIlIlIllIl.readObject();
        }
    }
    
    @Override
    public boolean containsKey(final Object lllllllllllllIIIlllIlllIllllllll) {
        return this.findKey(lllllllllllllIIIlllIlllIllllllll) != -1;
    }
    
    private int findKey(final Object lllllllllllllIIIlllIllllIIIllIlI) {
        final Object[] lllllllllllllIIIlllIllllIIIlllII = this.key;
        int lllllllllllllIIIlllIllllIIIlllll = this.size;
        while (lllllllllllllIIIlllIllllIIIlllll-- != 0) {
            if (Objects.equals(lllllllllllllIIIlllIllllIIIlllII[lllllllllllllIIIlllIllllIIIlllll], lllllllllllllIIIlllIllllIIIllIlI)) {
                return lllllllllllllIIIlllIllllIIIlllll;
            }
        }
        return -1;
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllIIIlllIlllIlIllIlII) throws IOException {
        lllllllllllllIIIlllIlllIlIllIlII.defaultWriteObject();
        for (int lllllllllllllIIIlllIlllIlIlllIII = 0; lllllllllllllIIIlllIlllIlIlllIII < this.size; ++lllllllllllllIIIlllIlllIlIlllIII) {
            lllllllllllllIIIlllIlllIlIllIlII.writeObject(this.key[lllllllllllllIIIlllIlllIlIlllIII]);
            lllllllllllllIIIlllIlllIlIllIlII.writeObject(this.value[lllllllllllllIIIlllIlllIlIlllIII]);
        }
    }
    
    @Override
    public ObjectCollection<V> values() {
        return new AbstractObjectCollection<V>() {
            @Override
            public void clear() {
                Object2ObjectArrayMap.this.clear();
            }
            
            @Override
            public ObjectIterator<V> iterator() {
                return new ObjectIterator<V>() {
                    /* synthetic */ int pos = 0;
                    
                    @Override
                    public void remove() {
                        if (this.pos == 0) {
                            throw new IllegalStateException();
                        }
                        final int lllllllllllllIlIIIIIIlllIlllIIll = Object2ObjectArrayMap.this.size - this.pos;
                        System.arraycopy(Object2ObjectArrayMap.this.key, this.pos, Object2ObjectArrayMap.this.key, this.pos - 1, lllllllllllllIlIIIIIIlllIlllIIll);
                        System.arraycopy(Object2ObjectArrayMap.this.value, this.pos, Object2ObjectArrayMap.this.value, this.pos - 1, lllllllllllllIlIIIIIIlllIlllIIll);
                        Object2ObjectArrayMap.this.size--;
                    }
                    
                    @Override
                    public V next() {
                        if (!this.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return (V)Object2ObjectArrayMap.this.value[this.pos++];
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.pos < Object2ObjectArrayMap.this.size;
                    }
                };
            }
            
            @Override
            public boolean contains(final Object llllllllllllllIIIIIIlIlIIIIlIllI) {
                return Object2ObjectArrayMap.this.containsValue(llllllllllllllIIIIIIlIlIIIIlIllI);
            }
            
            @Override
            public int size() {
                return Object2ObjectArrayMap.this.size;
            }
        };
    }
    
    @Override
    public V put(final K lllllllllllllIIIlllIlllIlllIIlII, final V lllllllllllllIIIlllIlllIllIlllll) {
        final int lllllllllllllIIIlllIlllIlllIIIlI = this.findKey(lllllllllllllIIIlllIlllIlllIIlII);
        if (lllllllllllllIIIlllIlllIlllIIIlI != -1) {
            final V lllllllllllllIIIlllIlllIlllIlIIl = (V)this.value[lllllllllllllIIIlllIlllIlllIIIlI];
            this.value[lllllllllllllIIIlllIlllIlllIIIlI] = lllllllllllllIIIlllIlllIllIlllll;
            return lllllllllllllIIIlllIlllIlllIlIIl;
        }
        if (this.size == this.key.length) {
            final Object[] lllllllllllllIIIlllIlllIlllIIlll = new Object[(this.size == 0) ? 2 : (this.size * 2)];
            final Object[] lllllllllllllIIIlllIlllIlllIIllI = new Object[(this.size == 0) ? 2 : (this.size * 2)];
            int lllllllllllllIIIlllIlllIlllIlIII = this.size;
            while (lllllllllllllIIIlllIlllIlllIlIII-- != 0) {
                lllllllllllllIIIlllIlllIlllIIlll[lllllllllllllIIIlllIlllIlllIlIII] = this.key[lllllllllllllIIIlllIlllIlllIlIII];
                lllllllllllllIIIlllIlllIlllIIllI[lllllllllllllIIIlllIlllIlllIlIII] = this.value[lllllllllllllIIIlllIlllIlllIlIII];
            }
            this.key = lllllllllllllIIIlllIlllIlllIIlll;
            this.value = lllllllllllllIIIlllIlllIlllIIllI;
        }
        this.key[this.size] = lllllllllllllIIIlllIlllIlllIIlII;
        this.value[this.size] = lllllllllllllIIIlllIlllIllIlllll;
        ++this.size;
        return this.defRetValue;
    }
    
    public Object2ObjectArrayMap(final Map<? extends K, ? extends V> lllllllllllllIIIlllIllllIIllIIll) {
        this(lllllllllllllIIIlllIllllIIllIIll.size());
        this.putAll(lllllllllllllIIIlllIllllIIllIIll);
    }
    
    public Object2ObjectArrayMap(final Object[] lllllllllllllIIIlllIllllIIlIlIIl, final Object[] lllllllllllllIIIlllIllllIIlIlIII, final int lllllllllllllIIIlllIllllIIlIlIll) {
        this.key = lllllllllllllIIIlllIllllIIlIlIIl;
        this.value = lllllllllllllIIIlllIllllIIlIlIII;
        this.size = lllllllllllllIIIlllIllllIIlIlIll;
        if (lllllllllllllIIIlllIllllIIlIlIIl.length != lllllllllllllIIIlllIllllIIlIlIII.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Keys and values have different lengths (").append(lllllllllllllIIIlllIllllIIlIlIIl.length).append(", ").append(lllllllllllllIIIlllIllllIIlIlIII.length).append(")")));
        }
        if (lllllllllllllIIIlllIllllIIlIlIll > lllllllllllllIIIlllIllllIIlIlIIl.length) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The provided size (").append(lllllllllllllIIIlllIllllIIlIlIll).append(") is larger than or equal to the backing-arrays size (").append(lllllllllllllIIIlllIllllIIlIlIIl.length).append(")")));
        }
    }
    
    @Override
    public boolean containsValue(final Object lllllllllllllIIIlllIlllIllllIlIl) {
        int lllllllllllllIIIlllIlllIlllllIIl = this.size;
        while (lllllllllllllIIIlllIlllIlllllIIl-- != 0) {
            if (Objects.equals(this.value[lllllllllllllIIIlllIlllIlllllIIl], lllllllllllllIIIlllIlllIllllIlIl)) {
                return true;
            }
        }
        return false;
    }
    
    public Object2ObjectArrayMap() {
        this.key = ObjectArrays.EMPTY_ARRAY;
        this.value = ObjectArrays.EMPTY_ARRAY;
    }
    
    public Object2ObjectArrayMap(final Object2ObjectMap<K, V> lllllllllllllIIIlllIllllIIlllIIl) {
        this(lllllllllllllIIIlllIllllIIlllIIl.size());
        this.putAll((Map<? extends K, ? extends V>)lllllllllllllIIIlllIllllIIlllIIl);
    }
    
    @Override
    public ObjectSet<K> keySet() {
        return new AbstractObjectSet<K>() {
            @Override
            public ObjectIterator<K> iterator() {
                return new ObjectIterator<K>() {
                    /* synthetic */ int pos = 0;
                    
                    @Override
                    public void remove() {
                        if (this.pos == 0) {
                            throw new IllegalStateException();
                        }
                        final int lllllllllllllIIlIllIllIlllllIlll = Object2ObjectArrayMap.this.size - this.pos;
                        System.arraycopy(Object2ObjectArrayMap.this.key, this.pos, Object2ObjectArrayMap.this.key, this.pos - 1, lllllllllllllIIlIllIllIlllllIlll);
                        System.arraycopy(Object2ObjectArrayMap.this.value, this.pos, Object2ObjectArrayMap.this.value, this.pos - 1, lllllllllllllIIlIllIllIlllllIlll);
                        Object2ObjectArrayMap.this.size--;
                        --this.pos;
                    }
                    
                    @Override
                    public boolean hasNext() {
                        return this.pos < Object2ObjectArrayMap.this.size;
                    }
                    
                    @Override
                    public K next() {
                        if (!this.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        return (K)Object2ObjectArrayMap.this.key[this.pos++];
                    }
                };
            }
            
            @Override
            public int size() {
                return Object2ObjectArrayMap.this.size;
            }
            
            @Override
            public boolean remove(final Object lllllllllllllIIllllIIIIllllIIIll) {
                final int lllllllllllllIIllllIIIIllllIIllI = Object2ObjectArrayMap.this.findKey(lllllllllllllIIllllIIIIllllIIIll);
                if (lllllllllllllIIllllIIIIllllIIllI == -1) {
                    return false;
                }
                final int lllllllllllllIIllllIIIIllllIIlIl = Object2ObjectArrayMap.this.size - lllllllllllllIIllllIIIIllllIIllI - 1;
                System.arraycopy(Object2ObjectArrayMap.this.key, lllllllllllllIIllllIIIIllllIIllI + 1, Object2ObjectArrayMap.this.key, lllllllllllllIIllllIIIIllllIIllI, lllllllllllllIIllllIIIIllllIIlIl);
                System.arraycopy(Object2ObjectArrayMap.this.value, lllllllllllllIIllllIIIIllllIIllI + 1, Object2ObjectArrayMap.this.value, lllllllllllllIIllllIIIIllllIIllI, lllllllllllllIIllllIIIIllllIIlIl);
                Object2ObjectArrayMap.this.size--;
                return true;
            }
            
            @Override
            public void clear() {
                Object2ObjectArrayMap.this.clear();
            }
            
            @Override
            public boolean contains(final Object lllllllllllllIIllllIIIIllllIllll) {
                return Object2ObjectArrayMap.this.findKey(lllllllllllllIIllllIIIIllllIllll) != -1;
            }
        };
    }
    
    public Object2ObjectArrayMap<K, V> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/objects/Object2ObjectArrayMap;
        //     7: astore_1        /* lllllllllllllIIIlllIlllIllIIIIlI */
        //     8: goto            20
        //    11: astore_2        /* lllllllllllllIIIlllIlllIlIllllII */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllllIIIlllIlllIlIllllll */
        //    21: aload_0         /* lllllllllllllIIIlllIlllIllIIIIII */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectArrayMap.key:[Ljava/lang/Object;
        //    25: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    28: checkcast       [Ljava/lang/Object;
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectArrayMap.key:[Ljava/lang/Object;
        //    34: aload_1         /* lllllllllllllIIIlllIlllIlIllllll */
        //    35: aload_0         /* lllllllllllllIIIlllIlllIllIIIIII */
        //    36: getfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectArrayMap.value:[Ljava/lang/Object;
        //    39: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    42: checkcast       [Ljava/lang/Object;
        //    45: putfield        com/viaversion/viaversion/libs/fastutil/objects/Object2ObjectArrayMap.value:[Ljava/lang/Object;
        //    48: aload_1         /* lllllllllllllIIIlllIlllIlIllllll */
        //    49: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/objects/Object2ObjectArrayMap<TK;TV;>;
        //    StackMapTable: 00 02 4B 07 00 43 FC 00 08 07 00 02
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
    public V remove(final Object lllllllllllllIIIlllIlllIllIIllll) {
        final int lllllllllllllIIIlllIlllIllIlIIll = this.findKey(lllllllllllllIIIlllIlllIllIIllll);
        if (lllllllllllllIIIlllIlllIllIlIIll == -1) {
            return this.defRetValue;
        }
        final V lllllllllllllIIIlllIlllIllIlIIlI = (V)this.value[lllllllllllllIIIlllIlllIllIlIIll];
        final int lllllllllllllIIIlllIlllIllIlIIIl = this.size - lllllllllllllIIIlllIlllIllIlIIll - 1;
        System.arraycopy(this.key, lllllllllllllIIIlllIlllIllIlIIll + 1, this.key, lllllllllllllIIIlllIlllIllIlIIll, lllllllllllllIIIlllIlllIllIlIIIl);
        System.arraycopy(this.value, lllllllllllllIIIlllIlllIllIlIIll + 1, this.value, lllllllllllllIIIlllIlllIllIlIIll, lllllllllllllIIIlllIlllIllIlIIIl);
        --this.size;
        this.key[this.size] = null;
        this.value[this.size] = null;
        return lllllllllllllIIIlllIlllIllIlIIlI;
    }
    
    @Override
    public void clear() {
        int lllllllllllllIIIlllIllllIIIIIllI = this.size;
        while (lllllllllllllIIIlllIllllIIIIIllI-- != 0) {
            this.key[lllllllllllllIIIlllIllllIIIIIllI] = null;
            this.value[lllllllllllllIIIlllIllllIIIIIllI] = null;
        }
        this.size = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public Object2ObjectMap.FastEntrySet<K, V> object2ObjectEntrySet() {
        return new EntrySet();
    }
    
    private final class EntrySet extends AbstractObjectSet<Object2ObjectMap.Entry<K, V>> implements Object2ObjectMap.FastEntrySet<K, V>
    {
        @Override
        public int size() {
            return Object2ObjectArrayMap.this.size;
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIlIllllIlIIllllIIII) {
            if (!(lllllllllllllIlIllllIlIIllllIIII instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIlIllllIlIIllllIIll = (Map.Entry<?, ?>)lllllllllllllIlIllllIlIIllllIIII;
            final K lllllllllllllIlIllllIlIIllllIIlI = (K)lllllllllllllIlIllllIlIIllllIIll.getKey();
            return Object2ObjectArrayMap.this.containsKey(lllllllllllllIlIllllIlIIllllIIlI) && Objects.equals(Object2ObjectArrayMap.this.get(lllllllllllllIlIllllIlIIllllIIlI), lllllllllllllIlIllllIlIIllllIIll.getValue());
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIlIllllIlIIllIlllIl) {
            if (!(lllllllllllllIlIllllIlIIllIlllIl instanceof Map.Entry)) {
                return false;
            }
            final Map.Entry<?, ?> lllllllllllllIlIllllIlIIllIlllII = (Map.Entry<?, ?>)lllllllllllllIlIllllIlIIllIlllIl;
            final K lllllllllllllIlIllllIlIIllIllIll = (K)lllllllllllllIlIllllIlIIllIlllII.getKey();
            final V lllllllllllllIlIllllIlIIllIllIlI = (V)lllllllllllllIlIllllIlIIllIlllII.getValue();
            final int lllllllllllllIlIllllIlIIllIllIIl = Object2ObjectArrayMap.this.findKey(lllllllllllllIlIllllIlIIllIllIll);
            if (lllllllllllllIlIllllIlIIllIllIIl == -1 || !Objects.equals(lllllllllllllIlIllllIlIIllIllIlI, Object2ObjectArrayMap.this.value[lllllllllllllIlIllllIlIIllIllIIl])) {
                return false;
            }
            final int lllllllllllllIlIllllIlIIllIllIII = Object2ObjectArrayMap.this.size - lllllllllllllIlIllllIlIIllIllIIl - 1;
            System.arraycopy(Object2ObjectArrayMap.this.key, lllllllllllllIlIllllIlIIllIllIIl + 1, Object2ObjectArrayMap.this.key, lllllllllllllIlIllllIlIIllIllIIl, lllllllllllllIlIllllIlIIllIllIII);
            System.arraycopy(Object2ObjectArrayMap.this.value, lllllllllllllIlIllllIlIIllIllIIl + 1, Object2ObjectArrayMap.this.value, lllllllllllllIlIllllIlIIllIllIIl, lllllllllllllIlIllllIlIIllIllIII);
            Object2ObjectArrayMap.this.size--;
            Object2ObjectArrayMap.this.key[Object2ObjectArrayMap.this.size] = null;
            Object2ObjectArrayMap.this.value[Object2ObjectArrayMap.this.size] = null;
            return true;
        }
        
        @Override
        public ObjectIterator<Object2ObjectMap.Entry<K, V>> iterator() {
            return new ObjectIterator<Object2ObjectMap.Entry<K, V>>() {
                /* synthetic */ int curr = -1;
                /* synthetic */ int next = 0;
                
                @Override
                public boolean hasNext() {
                    return this.next < Object2ObjectArrayMap.this.size;
                }
                
                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    final int llllllllllllllIIIIIllIIIIIIllIIl = Object2ObjectArrayMap.this.size-- - this.next--;
                    System.arraycopy(Object2ObjectArrayMap.this.key, this.next + 1, Object2ObjectArrayMap.this.key, this.next, llllllllllllllIIIIIllIIIIIIllIIl);
                    System.arraycopy(Object2ObjectArrayMap.this.value, this.next + 1, Object2ObjectArrayMap.this.value, this.next, llllllllllllllIIIIIllIIIIIIllIIl);
                    Object2ObjectArrayMap.this.key[Object2ObjectArrayMap.this.size] = null;
                    Object2ObjectArrayMap.this.value[Object2ObjectArrayMap.this.size] = null;
                }
                
                @Override
                public Object2ObjectMap.Entry<K, V> next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final Object[] access$100 = Object2ObjectArrayMap.this.key;
                    final int next = this.next;
                    this.curr = next;
                    return new BasicEntry<K, V>(access$100[next], Object2ObjectArrayMap.this.value[this.next++]);
                }
            };
        }
        
        @Override
        public ObjectIterator<Object2ObjectMap.Entry<K, V>> fastIterator() {
            return new ObjectIterator<Object2ObjectMap.Entry<K, V>>() {
                final /* synthetic */ BasicEntry<K, V> entry = new BasicEntry<K, V>();
                /* synthetic */ int next = 0;
                /* synthetic */ int curr = -1;
                
                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    final int lllllllllllllllIIIllllllIIlllIll = Object2ObjectArrayMap.this.size-- - this.next--;
                    System.arraycopy(Object2ObjectArrayMap.this.key, this.next + 1, Object2ObjectArrayMap.this.key, this.next, lllllllllllllllIIIllllllIIlllIll);
                    System.arraycopy(Object2ObjectArrayMap.this.value, this.next + 1, Object2ObjectArrayMap.this.value, this.next, lllllllllllllllIIIllllllIIlllIll);
                    Object2ObjectArrayMap.this.key[Object2ObjectArrayMap.this.size] = null;
                    Object2ObjectArrayMap.this.value[Object2ObjectArrayMap.this.size] = null;
                }
                
                @Override
                public boolean hasNext() {
                    return this.next < Object2ObjectArrayMap.this.size;
                }
                
                @Override
                public Object2ObjectMap.Entry<K, V> next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    final BasicEntry<K, V> entry = this.entry;
                    final Object[] access$100 = Object2ObjectArrayMap.this.key;
                    final int next = this.next;
                    this.curr = next;
                    entry.key = (K)access$100[next];
                    this.entry.value = (V)Object2ObjectArrayMap.this.value[this.next++];
                    return this.entry;
                }
            };
        }
    }
}
