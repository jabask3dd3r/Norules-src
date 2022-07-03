package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.util.function.*;
import java.io.*;

public final class Int2IntFunctions
{
    public static final /* synthetic */ EmptyFunction EMPTY_FUNCTION;
    
    public static Int2IntFunction unmodifiable(final Int2IntFunction llllllllllllllIIlllIIllIlIlIlllI) {
        return (Int2IntFunction)new Int2IntFunctions.UnmodifiableFunction(llllllllllllllIIlllIIllIlIlIlllI);
    }
    
    public static Int2IntFunction synchronize(final Int2IntFunction llllllllllllllIIlllIIllIlIllIlll, final Object llllllllllllllIIlllIIllIlIlllIIl) {
        return (Int2IntFunction)new Int2IntFunctions.SynchronizedFunction(llllllllllllllIIlllIIllIlIllIlll, llllllllllllllIIlllIIllIlIlllIIl);
    }
    
    private Int2IntFunctions() {
    }
    
    public static Int2IntFunction singleton(final int llllllllllllllIIlllIIllIllIlIlIl, final int llllllllllllllIIlllIIllIllIlIllI) {
        return new Singleton(llllllllllllllIIlllIIllIllIlIlIl, llllllllllllllIIlllIIllIllIlIllI);
    }
    
    public static Int2IntFunction singleton(final Integer llllllllllllllIIlllIIllIllIIllIl, final Integer llllllllllllllIIlllIIllIllIIllll) {
        return new Singleton(llllllllllllllIIlllIIllIllIIllIl, llllllllllllllIIlllIIllIllIIllll);
    }
    
    static {
        EMPTY_FUNCTION = new EmptyFunction();
    }
    
    public static Int2IntFunction primitive(final Function<? super Integer, ? extends Integer> llllllllllllllIIlllIIllIlIlIlIll) {
        Objects.requireNonNull(llllllllllllllIIlllIIllIlIlIlIll);
        if (llllllllllllllIIlllIIllIlIlIlIll instanceof Int2IntFunction) {
            return (Int2IntFunction)llllllllllllllIIlllIIllIlIlIlIll;
        }
        if (llllllllllllllIIlllIIllIlIlIlIll instanceof IntUnaryOperator) {
            final IntUnaryOperator intUnaryOperator = (IntUnaryOperator)llllllllllllllIIlllIIllIlIlIlIll;
            Objects.requireNonNull(intUnaryOperator);
            return intUnaryOperator::applyAsInt;
        }
        return new PrimitiveFunction(llllllllllllllIIlllIIllIlIlIlIll);
    }
    
    public static Int2IntFunction synchronize(final Int2IntFunction llllllllllllllIIlllIIllIllIIIIll) {
        return (Int2IntFunction)new Int2IntFunctions.SynchronizedFunction(llllllllllllllIIlllIIllIllIIIIll);
    }
    
    public static class Singleton extends AbstractInt2IntFunction implements Serializable, Cloneable
    {
        protected final /* synthetic */ int value;
        protected final /* synthetic */ int key;
        
        public Object clone() {
            return this;
        }
        
        protected Singleton(final int llllllllllllllllIlIIllllIlllIlIl, final int llllllllllllllllIlIIllllIlllIIIl) {
            this.key = llllllllllllllllIlIIllllIlllIlIl;
            this.value = llllllllllllllllIlIIllllIlllIIIl;
        }
        
        @Override
        public int get(final int llllllllllllllllIlIIllllIllIIlIl) {
            return (this.key == llllllllllllllllIlIIllllIllIIlIl) ? this.value : this.defRetValue;
        }
        
        @Override
        public boolean containsKey(final int llllllllllllllllIlIIllllIllIlIll) {
            return this.key == llllllllllllllllIlIIllllIllIlIll;
        }
        
        @Override
        public int size() {
            return 1;
        }
    }
    
    public static class EmptyFunction extends AbstractInt2IntFunction implements Serializable, Cloneable
    {
        private Object readResolve() {
            return Int2IntFunctions.EMPTY_FUNCTION;
        }
        
        protected EmptyFunction() {
        }
        
        @Override
        public int defaultReturnValue() {
            return 0;
        }
        
        @Override
        public int size() {
            return 0;
        }
        
        @Override
        public int get(final int lllllllllllllIllllIIllIlllIlllII) {
            return 0;
        }
        
        @Override
        public void clear() {
        }
        
        @Override
        public int hashCode() {
            return 0;
        }
        
        @Override
        public String toString() {
            return "{}";
        }
        
        @Override
        public boolean containsKey(final int lllllllllllllIllllIIllIlllIllIlI) {
            return false;
        }
        
        public Object clone() {
            return Int2IntFunctions.EMPTY_FUNCTION;
        }
        
        @Override
        public void defaultReturnValue(final int lllllllllllllIllllIIllIlllIlIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIllllIIllIlllIIllll) {
            return lllllllllllllIllllIIllIlllIIllll instanceof Function && ((Function)lllllllllllllIllllIIllIlllIIllll).size() == 0;
        }
    }
    
    public static class PrimitiveFunction implements Int2IntFunction
    {
        protected final /* synthetic */ java.util.function.Function<? super Integer, ? extends Integer> function;
        
        protected PrimitiveFunction(final java.util.function.Function<? super Integer, ? extends Integer> llllllllllllllIlIIlIIIlIlllIlIIl) {
            this.function = llllllllllllllIlIIlIIIlIlllIlIIl;
        }
        
        @Override
        public boolean containsKey(final int llllllllllllllIlIIlIIIlIlllIIlIl) {
            return this.function.apply(llllllllllllllIlIIlIIIlIlllIIlIl) != null;
        }
        
        @Deprecated
        @Override
        public Integer put(final Integer llllllllllllllIlIIlIIIlIllIIllII, final Integer llllllllllllllIlIIlIIIlIllIIlIll) {
            throw new UnsupportedOperationException();
        }
        
        @Deprecated
        @Override
        public boolean containsKey(final Object llllllllllllllIlIIlIIIlIllIlllll) {
            return llllllllllllllIlIIlIIIlIllIlllll != null && this.function.apply((Integer)llllllllllllllIlIIlIIIlIllIlllll) != null;
        }
        
        @Deprecated
        @Override
        public Integer get(final Object llllllllllllllIlIIlIIIlIllIlIIII) {
            if (llllllllllllllIlIIlIIIlIllIlIIII == null) {
                return null;
            }
            return (Integer)this.function.apply((Integer)llllllllllllllIlIIlIIIlIllIlIIII);
        }
        
        @Override
        public int get(final int llllllllllllllIlIIlIIIlIllIlIlIl) {
            final Integer llllllllllllllIlIIlIIIlIllIlIlll = (Integer)this.function.apply(llllllllllllllIlIIlIIIlIllIlIlIl);
            if (llllllllllllllIlIIlIIIlIllIlIlll == null) {
                return this.defaultReturnValue();
            }
            return llllllllllllllIlIIlIIIlIllIlIlll;
        }
    }
}
