package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import java.util.function.*;

public interface Int2IntMap extends Int2IntFunction, Map<Integer, Integer>
{
    @Deprecated
    default Integer merge(final Integer lllllllllllllIlIIIlllIlIlllIIllI, final Integer lllllllllllllIlIIIlllIlIlllIIIIl, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIlIIIlllIlIlllIIlII) {
        return super.merge(lllllllllllllIlIIIlllIlIlllIIllI, lllllllllllllIlIIIlllIlIlllIIIIl, lllllllllllllIlIIIlllIlIlllIIlII);
    }
    
    @Deprecated
    default Integer putIfAbsent(final Integer lllllllllllllIlIIIlllIllIIlIlIIl, final Integer lllllllllllllIlIIIlllIllIIlIlIII) {
        return super.putIfAbsent(lllllllllllllIlIIIlllIllIIlIlIIl, lllllllllllllIlIIIlllIllIIlIlIII);
    }
    
    @Deprecated
    default boolean replace(final Integer lllllllllllllIlIIIlllIllIIIlIllI, final Integer lllllllllllllIlIIIlllIllIIIlIIIl, final Integer lllllllllllllIlIIIlllIllIIIlIIII) {
        return super.replace(lllllllllllllIlIIIlllIllIIIlIllI, lllllllllllllIlIIIlllIllIIIlIIIl, lllllllllllllIlIIIlllIllIIIlIIII);
    }
    
    @Deprecated
    default boolean containsKey(final Object lllllllllllllIlIIIlllIlllllllIII) {
        return super.containsKey(lllllllllllllIlIIIlllIlllllllIII);
    }
    
    default int replace(final int lllllllllllllIlIIIlllIlllIllIlll, final int lllllllllllllIlIIIlllIlllIllIllI) {
        return this.containsKey(lllllllllllllIlIIIlllIlllIllIlll) ? this.put(lllllllllllllIlIIIlllIlllIllIlll, lllllllllllllIlIIIlllIlllIllIllI) : this.defaultReturnValue();
    }
    
    @Deprecated
    default Integer computeIfAbsent(final Integer lllllllllllllIlIIIlllIllIIIIIIlI, final java.util.function.Function<? super Integer, ? extends Integer> lllllllllllllIlIIIlllIlIlllllllI) {
        return super.computeIfAbsent(lllllllllllllIlIIIlllIllIIIIIIlI, lllllllllllllIlIIIlllIlIlllllllI);
    }
    
    default boolean remove(final int lllllllllllllIlIIIlllIllllIlIIIl, final int lllllllllllllIlIIIlllIllllIlIIII) {
        final int lllllllllllllIlIIIlllIllllIIllll = this.get(lllllllllllllIlIIIlllIllllIlIIIl);
        if (lllllllllllllIlIIIlllIllllIIllll != lllllllllllllIlIIIlllIllllIlIIII || (lllllllllllllIlIIIlllIllllIIllll == this.defaultReturnValue() && !this.containsKey(lllllllllllllIlIIIlllIllllIlIIIl))) {
            return false;
        }
        this.remove(lllllllllllllIlIIIlllIllllIlIIIl);
        return true;
    }
    
    void defaultReturnValue(final int p0);
    
    default int computeIfPresent(final int lllllllllllllIlIIIlllIllIllIllIl, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIlIIIlllIllIlllIIll) {
        Objects.requireNonNull(lllllllllllllIlIIIlllIllIlllIIll);
        final int lllllllllllllIlIIIlllIllIlllIIlI = this.get(lllllllllllllIlIIIlllIllIllIllIl);
        final int lllllllllllllIlIIIlllIllIlllIIIl = this.defaultReturnValue();
        if (lllllllllllllIlIIIlllIllIlllIIlI == lllllllllllllIlIIIlllIllIlllIIIl && !this.containsKey(lllllllllllllIlIIIlllIllIllIllIl)) {
            return lllllllllllllIlIIIlllIllIlllIIIl;
        }
        final Integer lllllllllllllIlIIIlllIllIlllIIII = (Integer)lllllllllllllIlIIIlllIllIlllIIll.apply(lllllllllllllIlIIIlllIllIllIllIl, lllllllllllllIlIIIlllIllIlllIIlI);
        if (lllllllllllllIlIIIlllIllIlllIIII == null) {
            this.remove(lllllllllllllIlIIIlllIllIllIllIl);
            return lllllllllllllIlIIIlllIllIlllIIIl;
        }
        final int lllllllllllllIlIIIlllIllIllIllll = lllllllllllllIlIIIlllIllIlllIIII;
        this.put(lllllllllllllIlIIIlllIllIllIllIl, lllllllllllllIlIIIlllIllIllIllll);
        return lllllllllllllIlIIIlllIllIllIllll;
    }
    
    default boolean replace(final int lllllllllllllIlIIIlllIllllIIIlII, final int lllllllllllllIlIIIlllIlllIlllllI, final int lllllllllllllIlIIIlllIllllIIIIlI) {
        final int lllllllllllllIlIIIlllIllllIIIIIl = this.get(lllllllllllllIlIIIlllIllllIIIlII);
        if (lllllllllllllIlIIIlllIllllIIIIIl != lllllllllllllIlIIIlllIlllIlllllI || (lllllllllllllIlIIIlllIllllIIIIIl == this.defaultReturnValue() && !this.containsKey(lllllllllllllIlIIIlllIllllIIIlII))) {
            return false;
        }
        this.put(lllllllllllllIlIIIlllIllllIIIlII, lllllllllllllIlIIIlllIllllIIIIlI);
        return true;
    }
    
    boolean containsValue(final int p0);
    
    @Deprecated
    default Integer get(final Object lllllllllllllIlIIIllllIIIIIIIlII) {
        return super.get(lllllllllllllIlIIIllllIIIIIIIlII);
    }
    
    @Deprecated
    default boolean containsValue(final Object lllllllllllllIlIIIlllIllllllIlII) {
        return lllllllllllllIlIIIlllIllllllIlII != null && this.containsValue((int)lllllllllllllIlIIIlllIllllllIlII);
    }
    
    @Deprecated
    default Integer replace(final Integer lllllllllllllIlIIIlllIllIIIIlIII, final Integer lllllllllllllIlIIIlllIllIIIIIlll) {
        return super.replace(lllllllllllllIlIIIlllIllIIIIlIII, lllllllllllllIlIIIlllIllIIIIIlll);
    }
    
    IntSet keySet();
    
    @Deprecated
    default boolean remove(final Object lllllllllllllIlIIIlllIllIIlIIIII, final Object lllllllllllllIlIIIlllIllIIIlllll) {
        return super.remove(lllllllllllllIlIIIlllIllIIlIIIII, lllllllllllllIlIIIlllIllIIIlllll);
    }
    
    default int putIfAbsent(final int lllllllllllllIlIIIlllIllllIlllll, final int lllllllllllllIlIIIlllIllllIllllI) {
        final int lllllllllllllIlIIIlllIllllIlllIl = this.get(lllllllllllllIlIIIlllIllllIlllll);
        final int lllllllllllllIlIIIlllIllllIlllII = this.defaultReturnValue();
        if (lllllllllllllIlIIIlllIllllIlllIl != lllllllllllllIlIIIlllIllllIlllII || this.containsKey(lllllllllllllIlIIIlllIllllIlllll)) {
            return lllllllllllllIlIIIlllIllllIlllIl;
        }
        this.put(lllllllllllllIlIIIlllIllllIlllll, lllllllllllllIlIIIlllIllllIllllI);
        return lllllllllllllIlIIIlllIllllIlllII;
    }
    
    default void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    default Integer put(final Integer lllllllllllllIlIIIllllIIIIIIlIll, final Integer lllllllllllllIlIIIllllIIIIIIlIlI) {
        return super.put(lllllllllllllIlIIIllllIIIIIIlIll, lllllllllllllIlIIIllllIIIIIIlIlI);
    }
    
    IntCollection values();
    
    @Deprecated
    default ObjectSet<Map.Entry<Integer, Integer>> entrySet() {
        return (ObjectSet<Map.Entry<Integer, Integer>>)this.int2IntEntrySet();
    }
    
    default int computeIfAbsent(final int lllllllllllllIlIIIlllIlllIlIIlll, final IntUnaryOperator lllllllllllllIlIIIlllIlllIlIlIll) {
        Objects.requireNonNull(lllllllllllllIlIIIlllIlllIlIlIll);
        final int lllllllllllllIlIIIlllIlllIlIlIlI = this.get(lllllllllllllIlIIIlllIlllIlIIlll);
        if (lllllllllllllIlIIIlllIlllIlIlIlI != this.defaultReturnValue() || this.containsKey(lllllllllllllIlIIIlllIlllIlIIlll)) {
            return lllllllllllllIlIIIlllIlllIlIlIlI;
        }
        final int lllllllllllllIlIIIlllIlllIlIlIIl = lllllllllllllIlIIIlllIlllIlIlIll.applyAsInt(lllllllllllllIlIIIlllIlllIlIIlll);
        this.put(lllllllllllllIlIIIlllIlllIlIIlll, lllllllllllllIlIIIlllIlllIlIlIIl);
        return lllllllllllllIlIIIlllIlllIlIlIIl;
    }
    
    @Deprecated
    default Integer compute(final Integer lllllllllllllIlIIIlllIlIllllIIII, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIlIIIlllIlIlllIllll) {
        return super.compute(lllllllllllllIlIIIlllIlIllllIIII, lllllllllllllIlIIIlllIlIlllIllll);
    }
    
    int defaultReturnValue();
    
    default int compute(final int lllllllllllllIlIIIlllIllIlIllllI, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIlIIIlllIllIlIlIlIl) {
        Objects.requireNonNull(lllllllllllllIlIIIlllIllIlIlIlIl);
        final int lllllllllllllIlIIIlllIllIlIlllII = this.get(lllllllllllllIlIIIlllIllIlIllllI);
        final int lllllllllllllIlIIIlllIllIlIllIll = this.defaultReturnValue();
        final boolean lllllllllllllIlIIIlllIllIlIllIlI = lllllllllllllIlIIIlllIllIlIlllII != lllllllllllllIlIIIlllIllIlIllIll || this.containsKey(lllllllllllllIlIIIlllIllIlIllllI);
        final Integer lllllllllllllIlIIIlllIllIlIllIIl = (Integer)lllllllllllllIlIIIlllIllIlIlIlIl.apply(lllllllllllllIlIIIlllIllIlIllllI, lllllllllllllIlIIIlllIllIlIllIlI ? Integer.valueOf(lllllllllllllIlIIIlllIllIlIlllII) : null);
        if (lllllllllllllIlIIIlllIllIlIllIIl == null) {
            if (lllllllllllllIlIIIlllIllIlIllIlI) {
                this.remove(lllllllllllllIlIIIlllIllIlIllllI);
            }
            return lllllllllllllIlIIIlllIllIlIllIll;
        }
        final int lllllllllllllIlIIIlllIllIlIllIII = lllllllllllllIlIIIlllIllIlIllIIl;
        this.put(lllllllllllllIlIIIlllIllIlIllllI, lllllllllllllIlIIIlllIllIlIllIII);
        return lllllllllllllIlIIIlllIllIlIllIII;
    }
    
    default int getOrDefault(final int lllllllllllllIlIIIlllIlllllIlIII, final int lllllllllllllIlIIIlllIlllllIIlll) {
        final int lllllllllllllIlIIIlllIlllllIlIlI;
        return ((lllllllllllllIlIIIlllIlllllIlIlI = this.get(lllllllllllllIlIIIlllIlllllIlIII)) != this.defaultReturnValue() || this.containsKey(lllllllllllllIlIIIlllIlllllIlIII)) ? lllllllllllllIlIIIlllIlllllIlIlI : lllllllllllllIlIIIlllIlllllIIlll;
    }
    
    default int computeIfAbsentPartial(final int lllllllllllllIlIIIlllIlllIIIIlll, final Int2IntFunction lllllllllllllIlIIIlllIlllIIIIIII) {
        Objects.requireNonNull(lllllllllllllIlIIIlllIlllIIIIIII);
        final int lllllllllllllIlIIIlllIlllIIIIlIl = this.get(lllllllllllllIlIIIlllIlllIIIIlll);
        final int lllllllllllllIlIIIlllIlllIIIIlII = this.defaultReturnValue();
        if (lllllllllllllIlIIIlllIlllIIIIlIl != lllllllllllllIlIIIlllIlllIIIIlII || this.containsKey(lllllllllllllIlIIIlllIlllIIIIlll)) {
            return lllllllllllllIlIIIlllIlllIIIIlIl;
        }
        if (!lllllllllllllIlIIIlllIlllIIIIIII.containsKey(lllllllllllllIlIIIlllIlllIIIIlll)) {
            return lllllllllllllIlIIIlllIlllIIIIlII;
        }
        final int lllllllllllllIlIIIlllIlllIIIIIll = lllllllllllllIlIIIlllIlllIIIIIII.get(lllllllllllllIlIIIlllIlllIIIIlll);
        this.put(lllllllllllllIlIIIlllIlllIIIIlll, lllllllllllllIlIIIlllIlllIIIIIll);
        return lllllllllllllIlIIIlllIlllIIIIIll;
    }
    
    default int merge(final int lllllllllllllIlIIIlllIllIlIIIlII, final int lllllllllllllIlIIIlllIllIlIIIIll, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIlIIIlllIllIIlllIll) {
        Objects.requireNonNull(lllllllllllllIlIIIlllIllIIlllIll);
        final int lllllllllllllIlIIIlllIllIlIIIIIl = this.get(lllllllllllllIlIIIlllIllIlIIIlII);
        final int lllllllllllllIlIIIlllIllIlIIIIII = this.defaultReturnValue();
        int lllllllllllllIlIIIlllIllIIllllll = 0;
        if (lllllllllllllIlIIIlllIllIlIIIIIl != lllllllllllllIlIIIlllIllIlIIIIII || this.containsKey(lllllllllllllIlIIIlllIllIlIIIlII)) {
            final Integer lllllllllllllIlIIIlllIllIlIIIlll = (Integer)lllllllllllllIlIIIlllIllIIlllIll.apply(lllllllllllllIlIIIlllIllIlIIIIIl, lllllllllllllIlIIIlllIllIlIIIIll);
            if (lllllllllllllIlIIIlllIllIlIIIlll == null) {
                this.remove(lllllllllllllIlIIIlllIllIlIIIlII);
                return lllllllllllllIlIIIlllIllIlIIIIII;
            }
            final int lllllllllllllIlIIIlllIllIlIIIllI = lllllllllllllIlIIIlllIllIlIIIlll;
        }
        else {
            lllllllllllllIlIIIlllIllIIllllll = lllllllllllllIlIIIlllIllIlIIIIll;
        }
        this.put(lllllllllllllIlIIIlllIllIlIIIlII, lllllllllllllIlIIIlllIllIIllllll);
        return lllllllllllllIlIIIlllIllIIllllll;
    }
    
    boolean containsKey(final int p0);
    
    @Deprecated
    default Integer getOrDefault(final Object lllllllllllllIlIIIlllIllIIllIIlI, final Integer lllllllllllllIlIIIlllIllIIllIIIl) {
        return super.getOrDefault(lllllllllllllIlIIIlllIllIIllIIlI, lllllllllllllIlIIIlllIllIIllIIIl);
    }
    
    ObjectSet<Entry> int2IntEntrySet();
    
    default int computeIfAbsentNullable(final int lllllllllllllIlIIIlllIlllIIlIlII, final IntFunction<? extends Integer> lllllllllllllIlIIIlllIlllIIllIlI) {
        Objects.requireNonNull(lllllllllllllIlIIIlllIlllIIllIlI);
        final int lllllllllllllIlIIIlllIlllIIllIIl = this.get(lllllllllllllIlIIIlllIlllIIlIlII);
        final int lllllllllllllIlIIIlllIlllIIllIII = this.defaultReturnValue();
        if (lllllllllllllIlIIIlllIlllIIllIIl != lllllllllllllIlIIIlllIlllIIllIII || this.containsKey(lllllllllllllIlIIIlllIlllIIlIlII)) {
            return lllllllllllllIlIIIlllIlllIIllIIl;
        }
        final Integer lllllllllllllIlIIIlllIlllIIlIlll = (Integer)lllllllllllllIlIIIlllIlllIIllIlI.apply(lllllllllllllIlIIIlllIlllIIlIlII);
        if (lllllllllllllIlIIIlllIlllIIlIlll == null) {
            return lllllllllllllIlIIIlllIlllIIllIII;
        }
        final int lllllllllllllIlIIIlllIlllIIlIllI = lllllllllllllIlIIIlllIlllIIlIlll;
        this.put(lllllllllllllIlIIIlllIlllIIlIlII, lllllllllllllIlIIIlllIlllIIlIllI);
        return lllllllllllllIlIIIlllIlllIIlIllI;
    }
    
    int size();
    
    @Deprecated
    default Integer remove(final Object lllllllllllllIlIIIlllIlllllllllI) {
        return super.remove(lllllllllllllIlIIIlllIlllllllllI);
    }
    
    @Deprecated
    default Integer computeIfPresent(final Integer lllllllllllllIlIIIlllIlIlllllIIl, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIlIIIlllIlIllllIlIl) {
        return super.computeIfPresent(lllllllllllllIlIIIlllIlIlllllIIl, lllllllllllllIlIIIlllIlIllllIlIl);
    }
    
    public interface Entry extends Map.Entry<Integer, Integer>
    {
        int getIntValue();
        
        @Deprecated
        default Integer getValue() {
            return this.getIntValue();
        }
        
        int getIntKey();
        
        @Deprecated
        default Integer setValue(final Integer lllllllllllllIIIIlIllIIIllIlllll) {
            return this.setValue((int)lllllllllllllIIIIlIllIIIllIlllll);
        }
        
        int setValue(final int p0);
        
        @Deprecated
        default Integer getKey() {
            return this.getIntKey();
        }
    }
    
    public interface FastEntrySet extends ObjectSet<Entry>
    {
        ObjectIterator<Entry> fastIterator();
        
        default void fastForEach(final Consumer<? super Entry> lllllllllllllllIIIIIlIlIIIIlIlII) {
            this.forEach(lllllllllllllllIIIIIlIlIIIIlIlII);
        }
    }
}
