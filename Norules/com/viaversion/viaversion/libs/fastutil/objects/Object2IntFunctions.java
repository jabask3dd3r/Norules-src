package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;
import java.util.function.*;
import java.io.*;

public final class Object2IntFunctions
{
    public static final /* synthetic */ EmptyFunction EMPTY_FUNCTION;
    
    public static <K> Object2IntFunction<K> singleton(final K lllllllllllllIlIIIlllIIlIIIlIIll, final Integer lllllllllllllIlIIIlllIIlIIIlIIlI) {
        return new Singleton<K>(lllllllllllllIlIIIlllIIlIIIlIIll, lllllllllllllIlIIIlllIIlIIIlIIlI);
    }
    
    static {
        EMPTY_FUNCTION = new EmptyFunction();
    }
    
    public static <K> Object2IntFunction<K> synchronize(final Object2IntFunction<K> lllllllllllllIlIIIlllIIlIIIIllII) {
        return (Object2IntFunction<K>)new Object2IntFunctions.SynchronizedFunction((Object2IntFunction)lllllllllllllIlIIIlllIIlIIIIllII);
    }
    
    public static <K> Object2IntFunction<K> primitive(final Function<? super K, ? extends Integer> lllllllllllllIlIIIlllIIIllllllll) {
        Objects.requireNonNull(lllllllllllllIlIIIlllIIIllllllll);
        if (lllllllllllllIlIIIlllIIIllllllll instanceof Object2IntFunction) {
            return (Object2IntFunction<K>)(Object2IntFunction)lllllllllllllIlIIIlllIIIllllllll;
        }
        if (lllllllllllllIlIIIlllIIIllllllll instanceof ToIntFunction) {
            return lllllllllllllIlIIIlllIIIllllIlll -> ((ToIntFunction<Object>)lllllllllllllIlIIIlllIIIllllllll).applyAsInt(lllllllllllllIlIIIlllIIIllllIlll);
        }
        return new PrimitiveFunction<K>(lllllllllllllIlIIIlllIIIllllllll);
    }
    
    private Object2IntFunctions() {
    }
    
    public static <K> Object2IntFunction<K> unmodifiable(final Object2IntFunction<K> lllllllllllllIlIIIlllIIlIIIIIIll) {
        return (Object2IntFunction<K>)new Object2IntFunctions.UnmodifiableFunction((Object2IntFunction)lllllllllllllIlIIIlllIIlIIIIIIll);
    }
    
    public static <K> Object2IntFunction<K> singleton(final K lllllllllllllIlIIIlllIIlIIIllIIl, final int lllllllllllllIlIIIlllIIlIIIllIII) {
        return new Singleton<K>(lllllllllllllIlIIIlllIIlIIIllIIl, lllllllllllllIlIIIlllIIlIIIllIII);
    }
    
    public static <K> Object2IntFunction<K> synchronize(final Object2IntFunction<K> lllllllllllllIlIIIlllIIlIIIIlIII, final Object lllllllllllllIlIIIlllIIlIIIIIlll) {
        return (Object2IntFunction<K>)new Object2IntFunctions.SynchronizedFunction((Object2IntFunction)lllllllllllllIlIIIlllIIlIIIIlIII, lllllllllllllIlIIIlllIIlIIIIIlll);
    }
    
    public static class PrimitiveFunction<K> implements Object2IntFunction<K>
    {
        protected final /* synthetic */ java.util.function.Function<? super K, ? extends Integer> function;
        
        @Override
        public boolean containsKey(final Object lllllllllllllllllllIlIIIIlIIllIl) {
            return this.function.apply((Object)lllllllllllllllllllIlIIIIlIIllIl) != null;
        }
        
        @Deprecated
        @Override
        public Integer get(final Object lllllllllllllllllllIlIIIIIlllllI) {
            return (Integer)this.function.apply((Object)lllllllllllllllllllIlIIIIIlllllI);
        }
        
        @Deprecated
        @Override
        public Integer put(final K lllllllllllllllllllIlIIIIIllllII, final Integer lllllllllllllllllllIlIIIIIlllIll) {
            throw new UnsupportedOperationException();
        }
        
        protected PrimitiveFunction(final java.util.function.Function<? super K, ? extends Integer> lllllllllllllllllllIlIIIIlIlIlIl) {
            this.function = lllllllllllllllllllIlIIIIlIlIlIl;
        }
        
        @Override
        public int getInt(final Object lllllllllllllllllllIlIIIIlIIIlIl) {
            final Integer lllllllllllllllllllIlIIIIlIIIlll = (Integer)this.function.apply((Object)lllllllllllllllllllIlIIIIlIIIlIl);
            if (lllllllllllllllllllIlIIIIlIIIlll == null) {
                return this.defaultReturnValue();
            }
            return lllllllllllllllllllIlIIIIlIIIlll;
        }
    }
    
    public static class Singleton<K> extends AbstractObject2IntFunction<K> implements Serializable, Cloneable
    {
        protected final /* synthetic */ K key;
        protected final /* synthetic */ int value;
        
        public Object clone() {
            return this;
        }
        
        @Override
        public boolean containsKey(final Object lllllllllllllIlIlIIIllIIIlIIIllI) {
            return Objects.equals(this.key, lllllllllllllIlIlIIIllIIIlIIIllI);
        }
        
        @Override
        public int getInt(final Object lllllllllllllIlIlIIIllIIIlIIIIlI) {
            return Objects.equals(this.key, lllllllllllllIlIlIIIllIIIlIIIIlI) ? this.value : this.defRetValue;
        }
        
        protected Singleton(final K lllllllllllllIlIlIIIllIIIlIlIIII, final int lllllllllllllIlIlIIIllIIIlIIllll) {
            this.key = lllllllllllllIlIlIIIllIIIlIlIIII;
            this.value = lllllllllllllIlIlIIIllIIIlIIllll;
        }
        
        @Override
        public int size() {
            return 1;
        }
    }
    
    public static class EmptyFunction<K> extends AbstractObject2IntFunction<K> implements Serializable, Cloneable
    {
        @Override
        public void defaultReturnValue(final int llllllllllllIlllllIlIlIIlllIllIl) {
            throw new UnsupportedOperationException();
        }
        
        public Object clone() {
            return Object2IntFunctions.EMPTY_FUNCTION;
        }
        
        @Override
        public int defaultReturnValue() {
            return 0;
        }
        
        @Override
        public String toString() {
            return "{}";
        }
        
        @Override
        public int size() {
            return 0;
        }
        
        @Override
        public boolean containsKey(final Object llllllllllllIlllllIlIlIIllllIIII) {
            return false;
        }
        
        private Object readResolve() {
            return Object2IntFunctions.EMPTY_FUNCTION;
        }
        
        @Override
        public int getInt(final Object llllllllllllIlllllIlIlIIllllIIlI) {
            return 0;
        }
        
        @Override
        public boolean equals(final Object llllllllllllIlllllIlIlIIlllIIllI) {
            return llllllllllllIlllllIlIlIIlllIIllI instanceof Function && ((Function)llllllllllllIlllllIlIlIIlllIIllI).size() == 0;
        }
        
        protected EmptyFunction() {
        }
        
        @Override
        public void clear() {
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
    }
}
