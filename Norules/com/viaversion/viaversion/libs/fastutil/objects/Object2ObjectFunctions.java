package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.*;

public final class Object2ObjectFunctions
{
    public static final /* synthetic */ EmptyFunction EMPTY_FUNCTION;
    
    public static <K, V> Object2ObjectFunction<K, V> synchronize(final Object2ObjectFunction<K, V> lllllllllllllIllllllllIIlllIIlll) {
        return (Object2ObjectFunction<K, V>)new Object2ObjectFunctions.SynchronizedFunction((Object2ObjectFunction)lllllllllllllIllllllllIIlllIIlll);
    }
    
    public static <K, V> Object2ObjectFunction<K, V> singleton(final K lllllllllllllIllllllllIIlllIlIlI, final V lllllllllllllIllllllllIIlllIlIll) {
        return new Singleton<K, V>(lllllllllllllIllllllllIIlllIlIlI, lllllllllllllIllllllllIIlllIlIll);
    }
    
    private Object2ObjectFunctions() {
    }
    
    static {
        EMPTY_FUNCTION = new EmptyFunction();
    }
    
    public static <K, V> Object2ObjectFunction<K, V> synchronize(final Object2ObjectFunction<K, V> lllllllllllllIllllllllIIlllIIIll, final Object lllllllllllllIllllllllIIlllIIIII) {
        return (Object2ObjectFunction<K, V>)new Object2ObjectFunctions.SynchronizedFunction((Object2ObjectFunction)lllllllllllllIllllllllIIlllIIIll, lllllllllllllIllllllllIIlllIIIII);
    }
    
    public static <K, V> Object2ObjectFunction<K, V> unmodifiable(final Object2ObjectFunction<K, V> lllllllllllllIllllllllIIllIllllI) {
        return (Object2ObjectFunction<K, V>)new Object2ObjectFunctions.UnmodifiableFunction((Object2ObjectFunction)lllllllllllllIllllllllIIllIllllI);
    }
    
    public static class Singleton<K, V> extends AbstractObject2ObjectFunction<K, V> implements Serializable, Cloneable
    {
        protected final /* synthetic */ V value;
        protected final /* synthetic */ K key;
        
        @Override
        public boolean containsKey(final Object lllllllllllllIlIIlIIlllIIlIIIIII) {
            return Objects.equals(this.key, lllllllllllllIlIIlIIlllIIlIIIIII);
        }
        
        public Object clone() {
            return this;
        }
        
        @Override
        public int size() {
            return 1;
        }
        
        protected Singleton(final K lllllllllllllIlIIlIIlllIIlIIlIlI, final V lllllllllllllIlIIlIIlllIIlIIIllI) {
            this.key = lllllllllllllIlIIlIIlllIIlIIlIlI;
            this.value = lllllllllllllIlIIlIIlllIIlIIIllI;
        }
        
        @Override
        public V get(final Object lllllllllllllIlIIlIIlllIIIllllII) {
            return Objects.equals(this.key, lllllllllllllIlIIlIIlllIIIllllII) ? this.value : this.defRetValue;
        }
    }
    
    public static class EmptyFunction<K, V> extends AbstractObject2ObjectFunction<K, V> implements Serializable, Cloneable
    {
        @Override
        public V defaultReturnValue() {
            return null;
        }
        
        private Object readResolve() {
            return Object2ObjectFunctions.EMPTY_FUNCTION;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIlIIIlIllIIlIIIIlIl) {
            return lllllllllllllIlIIIlIllIIlIIIIlIl instanceof Function && ((Function)lllllllllllllIlIIIlIllIIlIIIIlIl).size() == 0;
        }
        
        public Object clone() {
            return Object2ObjectFunctions.EMPTY_FUNCTION;
        }
        
        @Override
        public boolean containsKey(final Object lllllllllllllIlIIIlIllIIlIIlIIII) {
            return false;
        }
        
        @Override
        public String toString() {
            return "{}";
        }
        
        @Override
        public int size() {
            return 0;
        }
        
        protected EmptyFunction() {
        }
        
        @Override
        public void clear() {
        }
        
        @Override
        public void defaultReturnValue(final V lllllllllllllIlIIIlIllIIlIIIllIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public V get(final Object lllllllllllllIlIIIlIllIIlIIlIIlI) {
            return null;
        }
    }
}
