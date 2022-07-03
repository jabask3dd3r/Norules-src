package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.util.function.*;
import java.io.*;

public final class Int2ObjectFunctions
{
    public static final /* synthetic */ EmptyFunction EMPTY_FUNCTION;
    
    private Int2ObjectFunctions() {
    }
    
    public static <V> Int2ObjectFunction<V> primitive(final Function<? super Integer, ? extends V> lllllllllllllIllIIIlIlllIllIlIlI) {
        Objects.requireNonNull(lllllllllllllIllIIIlIlllIllIlIlI);
        if (lllllllllllllIllIIIlIlllIllIlIlI instanceof Int2ObjectFunction) {
            return (Int2ObjectFunction<V>)(Int2ObjectFunction)lllllllllllllIllIIIlIlllIllIlIlI;
        }
        if (lllllllllllllIllIIIlIlllIllIlIlI instanceof IntFunction) {
            final IntFunction intFunction = (IntFunction)lllllllllllllIllIIIlIlllIllIlIlI;
            Objects.requireNonNull(intFunction);
            return (Int2ObjectFunction<V>)intFunction::apply;
        }
        return new PrimitiveFunction<V>(lllllllllllllIllIIIlIlllIllIlIlI);
    }
    
    public static <V> Int2ObjectFunction<V> singleton(final Integer lllllllllllllIllIIIlIlllIllllIlI, final V lllllllllllllIllIIIlIlllIllllIll) {
        return new Singleton<V>(lllllllllllllIllIIIlIlllIllllIlI, lllllllllllllIllIIIlIlllIllllIll);
    }
    
    public static <V> Int2ObjectFunction<V> unmodifiable(final Int2ObjectFunction<V> lllllllllllllIllIIIlIlllIllIlllI) {
        return (Int2ObjectFunction<V>)new Int2ObjectFunctions.UnmodifiableFunction((Int2ObjectFunction)lllllllllllllIllIIIlIlllIllIlllI);
    }
    
    public static <V> Int2ObjectFunction<V> synchronize(final Int2ObjectFunction<V> lllllllllllllIllIIIlIlllIlllIIIl, final Object lllllllllllllIllIIIlIlllIlllIIII) {
        return (Int2ObjectFunction<V>)new Int2ObjectFunctions.SynchronizedFunction((Int2ObjectFunction)lllllllllllllIllIIIlIlllIlllIIIl, lllllllllllllIllIIIlIlllIlllIIII);
    }
    
    static {
        EMPTY_FUNCTION = new EmptyFunction();
    }
    
    public static <V> Int2ObjectFunction<V> singleton(final int lllllllllllllIllIIIlIllllIIIIIII, final V lllllllllllllIllIIIlIlllIlllllll) {
        return new Singleton<V>(lllllllllllllIllIIIlIllllIIIIIII, lllllllllllllIllIIIlIlllIlllllll);
    }
    
    public static <V> Int2ObjectFunction<V> synchronize(final Int2ObjectFunction<V> lllllllllllllIllIIIlIlllIlllIllI) {
        return (Int2ObjectFunction<V>)new Int2ObjectFunctions.SynchronizedFunction((Int2ObjectFunction)lllllllllllllIllIIIlIlllIlllIllI);
    }
    
    public static class Singleton<V> extends AbstractInt2ObjectFunction<V> implements Serializable, Cloneable
    {
        protected final /* synthetic */ int key;
        protected final /* synthetic */ V value;
        
        @Override
        public V get(final int llllllllllllllIllllIllIlIIlllIlI) {
            return (this.key == llllllllllllllIllllIllIlIIlllIlI) ? this.value : this.defRetValue;
        }
        
        protected Singleton(final int llllllllllllllIllllIllIlIlIlIIII, final V llllllllllllllIllllIllIlIlIIllII) {
            this.key = llllllllllllllIllllIllIlIlIlIIII;
            this.value = llllllllllllllIllllIllIlIlIIllII;
        }
        
        public Object clone() {
            return this;
        }
        
        @Override
        public int size() {
            return 1;
        }
        
        @Override
        public boolean containsKey(final int llllllllllllllIllllIllIlIlIIlIII) {
            return this.key == llllllllllllllIllllIllIlIlIIlIII;
        }
    }
    
    public static class PrimitiveFunction<V> implements Int2ObjectFunction<V>
    {
        protected final /* synthetic */ java.util.function.Function<? super Integer, ? extends V> function;
        
        @Deprecated
        @Override
        public V get(final Object lllllllllllllllIlIlIIIlIIlllllll) {
            if (lllllllllllllllIlIlIIIlIIlllllll == null) {
                return null;
            }
            return (V)this.function.apply((Integer)lllllllllllllllIlIlIIIlIIlllllll);
        }
        
        @Override
        public boolean containsKey(final int lllllllllllllllIlIlIIIlIlIIlIlII) {
            return this.function.apply(lllllllllllllllIlIlIIIlIlIIlIlII) != null;
        }
        
        @Override
        public V get(final int lllllllllllllllIlIlIIIlIlIIIlIIl) {
            final V lllllllllllllllIlIlIIIlIlIIIlIII = (V)this.function.apply(lllllllllllllllIlIlIIIlIlIIIlIIl);
            if (lllllllllllllllIlIlIIIlIlIIIlIII == null) {
                return null;
            }
            return lllllllllllllllIlIlIIIlIlIIIlIII;
        }
        
        protected PrimitiveFunction(final java.util.function.Function<? super Integer, ? extends V> lllllllllllllllIlIlIIIlIlIIlllII) {
            this.function = lllllllllllllllIlIlIIIlIlIIlllII;
        }
        
        @Deprecated
        @Override
        public boolean containsKey(final Object lllllllllllllllIlIlIIIlIlIIlIIII) {
            return lllllllllllllllIlIlIIIlIlIIlIIII != null && this.function.apply((Integer)lllllllllllllllIlIlIIIlIlIIlIIII) != null;
        }
        
        @Deprecated
        @Override
        public V put(final Integer lllllllllllllllIlIlIIIlIIlllllIl, final V lllllllllllllllIlIlIIIlIIlllllII) {
            throw new UnsupportedOperationException();
        }
    }
    
    public static class EmptyFunction<V> extends AbstractInt2ObjectFunction<V> implements Serializable, Cloneable
    {
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public boolean equals(final Object llIlIIlllIllIll) {
            return llIlIIlllIllIll instanceof Function && ((Function)llIlIIlllIllIll).size() == 0;
        }
        
        private Object readResolve() {
            return Int2ObjectFunctions.EMPTY_FUNCTION;
        }
        
        @Override
        public V get(final int llIlIIllllIlIII) {
            return null;
        }
        
        @Override
        public String toString() {
            return "{}";
        }
        
        public Object clone() {
            return Int2ObjectFunctions.EMPTY_FUNCTION;
        }
        
        @Override
        public void clear() {
        }
        
        @Override
        public void defaultReturnValue(final V llIlIIllllIIIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public V defaultReturnValue() {
            return null;
        }
        
        @Override
        public int size() {
            return 0;
        }
        
        @Override
        public boolean containsKey(final int llIlIIllllIIllI) {
            return false;
        }
        
        protected EmptyFunction() {
        }
    }
}
