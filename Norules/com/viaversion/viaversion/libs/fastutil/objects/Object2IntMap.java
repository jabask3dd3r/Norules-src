package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.function.*;

public interface Object2IntMap<K> extends Object2IntFunction<K>, Map<K, Integer>
{
    default int computeIntIfPresent(final K lllllllllllllIlIIIllIIIllIlIllll, final BiFunction<? super K, ? super Integer, ? extends Integer> lllllllllllllIlIIIllIIIllIlIIlll) {
        Objects.requireNonNull(lllllllllllllIlIIIllIIIllIlIIlll);
        final int lllllllllllllIlIIIllIIIllIlIllIl = this.getInt(lllllllllllllIlIIIllIIIllIlIllll);
        final int lllllllllllllIlIIIllIIIllIlIllII = this.defaultReturnValue();
        if (lllllllllllllIlIIIllIIIllIlIllIl == lllllllllllllIlIIIllIIIllIlIllII && !this.containsKey(lllllllllllllIlIIIllIIIllIlIllll)) {
            return lllllllllllllIlIIIllIIIllIlIllII;
        }
        final Integer lllllllllllllIlIIIllIIIllIlIlIll = (Integer)lllllllllllllIlIIIllIIIllIlIIlll.apply((Object)lllllllllllllIlIIIllIIIllIlIllll, Integer.valueOf(lllllllllllllIlIIIllIIIllIlIllIl));
        if (lllllllllllllIlIIIllIIIllIlIlIll == null) {
            this.removeInt(lllllllllllllIlIIIllIIIllIlIllll);
            return lllllllllllllIlIIIllIIIllIlIllII;
        }
        final int lllllllllllllIlIIIllIIIllIlIlIlI = lllllllllllllIlIIIllIIIllIlIlIll;
        this.put(lllllllllllllIlIIIllIIIllIlIllll, lllllllllllllIlIIIllIIIllIlIlIlI);
        return lllllllllllllIlIIIllIIIllIlIlIlI;
    }
    
    int defaultReturnValue();
    
    @Deprecated
    default ObjectSet<Map.Entry<K, Integer>> entrySet() {
        return (ObjectSet<Map.Entry<K, Integer>>)this.object2IntEntrySet();
    }
    
    @Deprecated
    default Integer merge(final K lllllllllllllIlIIIllIIIlIIllllII, final Integer lllllllllllllIlIIIllIIIlIIlllIll, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIlIIIllIIIlIIlllIlI) {
        return super.merge(lllllllllllllIlIIIllIIIlIIllllII, lllllllllllllIlIIIllIIIlIIlllIll, lllllllllllllIlIIIllIIIlIIlllIlI);
    }
    
    default int computeIntIfAbsent(final K lllllllllllllIlIIIllIIIlllIIllIl, final ToIntFunction<? super K> lllllllllllllIlIIIllIIIlllIlIIIl) {
        Objects.requireNonNull(lllllllllllllIlIIIllIIIlllIlIIIl);
        final int lllllllllllllIlIIIllIIIlllIlIIII = this.getInt(lllllllllllllIlIIIllIIIlllIIllIl);
        if (lllllllllllllIlIIIllIIIlllIlIIII != this.defaultReturnValue() || this.containsKey(lllllllllllllIlIIIllIIIlllIIllIl)) {
            return lllllllllllllIlIIIllIIIlllIlIIII;
        }
        final int lllllllllllllIlIIIllIIIlllIIllll = lllllllllllllIlIIIllIIIlllIlIIIl.applyAsInt((Object)lllllllllllllIlIIIllIIIlllIIllIl);
        this.put(lllllllllllllIlIIIllIIIlllIIllIl, lllllllllllllIlIIIllIIIlllIIllll);
        return lllllllllllllIlIIIllIIIlllIIllll;
    }
    
    boolean containsValue(final int p0);
    
    @Deprecated
    default Integer putIfAbsent(final K lllllllllllllIlIIIllIIIlIllIIlII, final Integer lllllllllllllIlIIIllIIIlIllIIIII) {
        return super.putIfAbsent(lllllllllllllIlIIIllIIIlIllIIlII, lllllllllllllIlIIIllIIIlIllIIIII);
    }
    
    IntCollection values();
    
    @Deprecated
    default boolean replace(final K lllllllllllllIlIIIllIIIlIlIlIIIl, final Integer lllllllllllllIlIIIllIIIlIlIIllII, final Integer lllllllllllllIlIIIllIIIlIlIIllll) {
        return super.replace(lllllllllllllIlIIIllIIIlIlIlIIIl, lllllllllllllIlIIIllIIIlIlIIllII, lllllllllllllIlIIIllIIIlIlIIllll);
    }
    
    @Deprecated
    default Integer get(final Object lllllllllllllIlIIIllIIlIIIlIIllI) {
        return super.get(lllllllllllllIlIIIllIIlIIIlIIllI);
    }
    
    default int replace(final K lllllllllllllIlIIIllIIIlllIllIlI, final int lllllllllllllIlIIIllIIIlllIlllII) {
        return this.containsKey(lllllllllllllIlIIIllIIIlllIllIlI) ? this.put(lllllllllllllIlIIIllIIIlllIllIlI, lllllllllllllIlIIIllIIIlllIlllII) : this.defaultReturnValue();
    }
    
    boolean containsKey(final Object p0);
    
    @Deprecated
    default Integer put(final K lllllllllllllIlIIIllIIlIIIlIlIll, final Integer lllllllllllllIlIIIllIIlIIIlIlIlI) {
        return super.put(lllllllllllllIlIIIllIIlIIIlIlIll, lllllllllllllIlIIIllIIlIIIlIlIlI);
    }
    
    @Deprecated
    default Integer replace(final K lllllllllllllIlIIIllIIIlIlIIIllI, final Integer lllllllllllllIlIIIllIIIlIlIIIlIl) {
        return super.replace(lllllllllllllIlIIIllIIIlIlIIIllI, lllllllllllllIlIIIllIIIlIlIIIlIl);
    }
    
    @Deprecated
    default boolean containsValue(final Object lllllllllllllIlIIIllIIlIIIIllIlI) {
        return lllllllllllllIlIIIllIIlIIIIllIlI != null && this.containsValue((int)lllllllllllllIlIIIllIIlIIIIllIlI);
    }
    
    default int getOrDefault(final Object lllllllllllllIlIIIllIIlIIIIIlllI, final int lllllllllllllIlIIIllIIlIIIIIllIl) {
        final int lllllllllllllIlIIIllIIlIIIIlIIII;
        return ((lllllllllllllIlIIIllIIlIIIIlIIII = this.getInt(lllllllllllllIlIIIllIIlIIIIIlllI)) != this.defaultReturnValue() || this.containsKey(lllllllllllllIlIIIllIIlIIIIIlllI)) ? lllllllllllllIlIIIllIIlIIIIlIIII : lllllllllllllIlIIIllIIlIIIIIllIl;
    }
    
    default int computeInt(final K lllllllllllllIlIIIllIIIllIIlIIIl, final BiFunction<? super K, ? super Integer, ? extends Integer> lllllllllllllIlIIIllIIIllIIllIII) {
        Objects.requireNonNull(lllllllllllllIlIIIllIIIllIIllIII);
        final int lllllllllllllIlIIIllIIIllIIlIlll = this.getInt(lllllllllllllIlIIIllIIIllIIlIIIl);
        final int lllllllllllllIlIIIllIIIllIIlIllI = this.defaultReturnValue();
        final boolean lllllllllllllIlIIIllIIIllIIlIlIl = lllllllllllllIlIIIllIIIllIIlIlll != lllllllllllllIlIIIllIIIllIIlIllI || this.containsKey(lllllllllllllIlIIIllIIIllIIlIIIl);
        final Integer lllllllllllllIlIIIllIIIllIIlIlII = (Integer)lllllllllllllIlIIIllIIIllIIllIII.apply((Object)lllllllllllllIlIIIllIIIllIIlIIIl, lllllllllllllIlIIIllIIIllIIlIlIl ? Integer.valueOf(lllllllllllllIlIIIllIIIllIIlIlll) : null);
        if (lllllllllllllIlIIIllIIIllIIlIlII == null) {
            if (lllllllllllllIlIIIllIIIllIIlIlIl) {
                this.removeInt(lllllllllllllIlIIIllIIIllIIlIIIl);
            }
            return lllllllllllllIlIIIllIIIllIIlIllI;
        }
        final int lllllllllllllIlIIIllIIIllIIlIIll = lllllllllllllIlIIIllIIIllIIlIlII;
        this.put(lllllllllllllIlIIIllIIIllIIlIIIl, lllllllllllllIlIIIllIIIllIIlIIll);
        return lllllllllllllIlIIIllIIIllIIlIIll;
    }
    
    default boolean remove(final Object lllllllllllllIlIIIllIIIlllllIlll, final int lllllllllllllIlIIIllIIIlllllIIlI) {
        final int lllllllllllllIlIIIllIIIlllllIlIl = this.getInt(lllllllllllllIlIIIllIIIlllllIlll);
        if (lllllllllllllIlIIIllIIIlllllIlIl != lllllllllllllIlIIIllIIIlllllIIlI || (lllllllllllllIlIIIllIIIlllllIlIl == this.defaultReturnValue() && !this.containsKey(lllllllllllllIlIIIllIIIlllllIlll))) {
            return false;
        }
        this.removeInt(lllllllllllllIlIIIllIIIlllllIlll);
        return true;
    }
    
    default int computeIntIfAbsentPartial(final K lllllllllllllIlIIIllIIIllIllllII, final Object2IntFunction<? super K> lllllllllllllIlIIIllIIIlllIIIIIl) {
        Objects.requireNonNull(lllllllllllllIlIIIllIIIlllIIIIIl);
        final int lllllllllllllIlIIIllIIIlllIIIIII = this.getInt(lllllllllllllIlIIIllIIIllIllllII);
        final int lllllllllllllIlIIIllIIIllIllllll = this.defaultReturnValue();
        if (lllllllllllllIlIIIllIIIlllIIIIII != lllllllllllllIlIIIllIIIllIllllll || this.containsKey(lllllllllllllIlIIIllIIIllIllllII)) {
            return lllllllllllllIlIIIllIIIlllIIIIII;
        }
        if (!lllllllllllllIlIIIllIIIlllIIIIIl.containsKey(lllllllllllllIlIIIllIIIllIllllII)) {
            return lllllllllllllIlIIIllIIIllIllllll;
        }
        final int lllllllllllllIlIIIllIIIllIlllllI = lllllllllllllIlIIIllIIIlllIIIIIl.getInt(lllllllllllllIlIIIllIIIllIllllII);
        this.put(lllllllllllllIlIIIllIIIllIllllII, lllllllllllllIlIIIllIIIllIlllllI);
        return lllllllllllllIlIIIllIIIllIlllllI;
    }
    
    @Deprecated
    default boolean remove(final Object lllllllllllllIlIIIllIIIlIlIllIII, final Object lllllllllllllIlIIIllIIIlIlIlIlll) {
        return super.remove(lllllllllllllIlIIIllIIIlIlIllIII, lllllllllllllIlIIIllIIIlIlIlIlll);
    }
    
    @Deprecated
    default Integer remove(final Object lllllllllllllIlIIIllIIlIIIIllllI) {
        return super.remove(lllllllllllllIlIIIllIIlIIIIllllI);
    }
    
    ObjectSet<K> keySet();
    
    int size();
    
    @Deprecated
    default Integer getOrDefault(final Object lllllllllllllIlIIIllIIIlIllIlIlI, final Integer lllllllllllllIlIIIllIIIlIllIllII) {
        return super.getOrDefault(lllllllllllllIlIIIllIIIlIllIlIlI, lllllllllllllIlIIIllIIIlIllIllII);
    }
    
    default int putIfAbsent(final K lllllllllllllIlIIIllIIlIIIIIIIII, final int lllllllllllllIlIIIllIIIlllllllll) {
        final int lllllllllllllIlIIIllIIlIIIIIIIll = this.getInt(lllllllllllllIlIIIllIIlIIIIIIIII);
        final int lllllllllllllIlIIIllIIlIIIIIIIlI = this.defaultReturnValue();
        if (lllllllllllllIlIIIllIIlIIIIIIIll != lllllllllllllIlIIIllIIlIIIIIIIlI || this.containsKey(lllllllllllllIlIIIllIIlIIIIIIIII)) {
            return lllllllllllllIlIIIllIIlIIIIIIIll;
        }
        this.put(lllllllllllllIlIIIllIIlIIIIIIIII, lllllllllllllIlIIIllIIIlllllllll);
        return lllllllllllllIlIIIllIIlIIIIIIIlI;
    }
    
    default void clear() {
        throw new UnsupportedOperationException();
    }
    
    ObjectSet<Entry<K>> object2IntEntrySet();
    
    void defaultReturnValue(final int p0);
    
    default boolean replace(final K lllllllllllllIlIIIllIIIllllIlIlI, final int lllllllllllllIlIIIllIIIllllIlIIl, final int lllllllllllllIlIIIllIIIllllIIIll) {
        final int lllllllllllllIlIIIllIIIllllIIlll = this.getInt(lllllllllllllIlIIIllIIIllllIlIlI);
        if (lllllllllllllIlIIIllIIIllllIIlll != lllllllllllllIlIIIllIIIllllIlIIl || (lllllllllllllIlIIIllIIIllllIIlll == this.defaultReturnValue() && !this.containsKey(lllllllllllllIlIIIllIIIllllIlIlI))) {
            return false;
        }
        this.put(lllllllllllllIlIIIllIIIllllIlIlI, lllllllllllllIlIIIllIIIllllIIIll);
        return true;
    }
    
    default int mergeInt(final K lllllllllllllIlIIIllIIIlIllllIII, final int lllllllllllllIlIIIllIIIlIlllIlll, final BiFunction<? super Integer, ? super Integer, ? extends Integer> lllllllllllllIlIIIllIIIlIlllIllI) {
        Objects.requireNonNull(lllllllllllllIlIIIllIIIlIlllIllI);
        final int lllllllllllllIlIIIllIIIlIlllllII = this.getInt(lllllllllllllIlIIIllIIIlIllllIII);
        final int lllllllllllllIlIIIllIIIlIllllIll = this.defaultReturnValue();
        int lllllllllllllIlIIIllIIIlIllllIlI = 0;
        if (lllllllllllllIlIIIllIIIlIlllllII != lllllllllllllIlIIIllIIIlIllllIll || this.containsKey(lllllllllllllIlIIIllIIIlIllllIII)) {
            final Integer lllllllllllllIlIIIllIIIllIIIIIlI = (Integer)lllllllllllllIlIIIllIIIlIlllIllI.apply(lllllllllllllIlIIIllIIIlIlllllII, lllllllllllllIlIIIllIIIlIlllIlll);
            if (lllllllllllllIlIIIllIIIllIIIIIlI == null) {
                this.removeInt(lllllllllllllIlIIIllIIIlIllllIII);
                return lllllllllllllIlIIIllIIIlIllllIll;
            }
            final int lllllllllllllIlIIIllIIIllIIIIIIl = lllllllllllllIlIIIllIIIllIIIIIlI;
        }
        else {
            lllllllllllllIlIIIllIIIlIllllIlI = lllllllllllllIlIIIllIIIlIlllIlll;
        }
        this.put(lllllllllllllIlIIIllIIIlIllllIII, lllllllllllllIlIIIllIIIlIllllIlI);
        return lllllllllllllIlIIIllIIIlIllllIlI;
    }
    
    public interface FastEntrySet<K> extends ObjectSet<Entry<K>>
    {
        default void fastForEach(final Consumer<? super Entry<K>> lllllllllllllIIllIlIlIllIllIlIIl) {
            this.forEach(lllllllllllllIIllIlIlIllIllIlIIl);
        }
        
        ObjectIterator<Entry<K>> fastIterator();
    }
    
    public interface Entry<K> extends Map.Entry<K, Integer>
    {
        int setValue(final int p0);
        
        @Deprecated
        default Integer setValue(final Integer lllllllllllllllIIlllIlIIllllIlIl) {
            return this.setValue((int)lllllllllllllllIIlllIlIIllllIlIl);
        }
        
        int getIntValue();
        
        @Deprecated
        default Integer getValue() {
            return this.getIntValue();
        }
    }
}
