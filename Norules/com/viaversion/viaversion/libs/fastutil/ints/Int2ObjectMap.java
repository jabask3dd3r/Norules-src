package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;

public interface Int2ObjectMap<V> extends Int2ObjectFunction<V>, Map<Integer, V>
{
    @Deprecated
    default V computeIfPresent(final Integer llllllllllllllllIIlIIlllIlIIIIll, final BiFunction<? super Integer, ? super V, ? extends V> llllllllllllllllIIlIIlllIIlllIll) {
        return super.computeIfPresent(llllllllllllllllIIlIIlllIlIIIIll, llllllllllllllllIIlIIlllIIlllIll);
    }
    
    int size();
    
    default V getOrDefault(final int llllllllllllllllIIlIlIIIIIlllIII, final V llllllllllllllllIIlIlIIIIIllIIll) {
        final V llllllllllllllllIIlIlIIIIIllIllI;
        return ((llllllllllllllllIIlIlIIIIIllIllI = this.get(llllllllllllllllIIlIlIIIIIlllIII)) != this.defaultReturnValue() || this.containsKey(llllllllllllllllIIlIlIIIIIlllIII)) ? llllllllllllllllIIlIlIIIIIllIllI : llllllllllllllllIIlIlIIIIIllIIll;
    }
    
    @Deprecated
    default V get(final Object llllllllllllllllIIlIlIIIIlIIlIlI) {
        return super.get(llllllllllllllllIIlIlIIIIlIIlIlI);
    }
    
    default V computeIfAbsentPartial(final int llllllllllllllllIIlIIllllllIIIlI, final Int2ObjectFunction<? extends V> llllllllllllllllIIlIIllllllIIIIl) {
        Objects.requireNonNull(llllllllllllllllIIlIIllllllIIIIl);
        final V llllllllllllllllIIlIIllllllIIllI = this.get(llllllllllllllllIIlIIllllllIIIlI);
        final V llllllllllllllllIIlIIllllllIIlIl = this.defaultReturnValue();
        if (llllllllllllllllIIlIIllllllIIllI != llllllllllllllllIIlIIllllllIIlIl || this.containsKey(llllllllllllllllIIlIIllllllIIIlI)) {
            return llllllllllllllllIIlIIllllllIIllI;
        }
        if (!llllllllllllllllIIlIIllllllIIIIl.containsKey(llllllllllllllllIIlIIllllllIIIlI)) {
            return llllllllllllllllIIlIIllllllIIlIl;
        }
        final V llllllllllllllllIIlIIllllllIIlII = (V)llllllllllllllllIIlIIllllllIIIIl.get(llllllllllllllllIIlIIllllllIIIlI);
        this.put(llllllllllllllllIIlIIllllllIIIlI, llllllllllllllllIIlIIllllllIIlII);
        return llllllllllllllllIIlIIllllllIIlII;
    }
    
    default V computeIfAbsent(final int llllllllllllllllIIlIIlllllllIIll, final IntFunction<? extends V> llllllllllllllllIIlIIlllllllIlll) {
        Objects.requireNonNull(llllllllllllllllIIlIIlllllllIlll);
        final V llllllllllllllllIIlIIlllllllIllI = this.get(llllllllllllllllIIlIIlllllllIIll);
        if (llllllllllllllllIIlIIlllllllIllI != this.defaultReturnValue() || this.containsKey(llllllllllllllllIIlIIlllllllIIll)) {
            return llllllllllllllllIIlIIlllllllIllI;
        }
        final V llllllllllllllllIIlIIlllllllIlIl = (V)llllllllllllllllIIlIIlllllllIlll.apply(llllllllllllllllIIlIIlllllllIIll);
        this.put(llllllllllllllllIIlIIlllllllIIll, llllllllllllllllIIlIIlllllllIlIl);
        return llllllllllllllllIIlIIlllllllIlIl;
    }
    
    @Deprecated
    default V computeIfAbsent(final Integer llllllllllllllllIIlIIlllIlIlIIll, final java.util.function.Function<? super Integer, ? extends V> llllllllllllllllIIlIIlllIlIlIIlI) {
        return super.computeIfAbsent(llllllllllllllllIIlIIlllIlIlIIll, llllllllllllllllIIlIIlllIlIlIIlI);
    }
    
    IntSet keySet();
    
    @Deprecated
    default V put(final Integer llllllllllllllllIIlIlIIIIlIlIlII, final V llllllllllllllllIIlIlIIIIlIlIIll) {
        return super.put(llllllllllllllllIIlIlIIIIlIlIlII, llllllllllllllllIIlIlIIIIlIlIIll);
    }
    
    ObjectSet<Entry<V>> int2ObjectEntrySet();
    
    default V computeIfPresent(final int llllllllllllllllIIlIIlllllIlIllI, final BiFunction<? super Integer, ? super V, ? extends V> llllllllllllllllIIlIIlllllIlIlIl) {
        Objects.requireNonNull(llllllllllllllllIIlIIlllllIlIlIl);
        final V llllllllllllllllIIlIIlllllIlIlII = this.get(llllllllllllllllIIlIIlllllIlIllI);
        final V llllllllllllllllIIlIIlllllIlIIll = this.defaultReturnValue();
        if (llllllllllllllllIIlIIlllllIlIlII == llllllllllllllllIIlIIlllllIlIIll && !this.containsKey(llllllllllllllllIIlIIlllllIlIllI)) {
            return llllllllllllllllIIlIIlllllIlIIll;
        }
        final V llllllllllllllllIIlIIlllllIlIIlI = (V)llllllllllllllllIIlIIlllllIlIlIl.apply(Integer.valueOf(llllllllllllllllIIlIIlllllIlIllI), (Object)llllllllllllllllIIlIIlllllIlIlII);
        if (llllllllllllllllIIlIIlllllIlIIlI == null) {
            this.remove(llllllllllllllllIIlIIlllllIlIllI);
            return llllllllllllllllIIlIIlllllIlIIll;
        }
        this.put(llllllllllllllllIIlIIlllllIlIllI, llllllllllllllllIIlIIlllllIlIIlI);
        return llllllllllllllllIIlIIlllllIlIIlI;
    }
    
    @Deprecated
    default V compute(final Integer llllllllllllllllIIlIIlllIIllIIII, final BiFunction<? super Integer, ? super V, ? extends V> llllllllllllllllIIlIIlllIIlIlllI) {
        return super.compute(llllllllllllllllIIlIIlllIIllIIII, llllllllllllllllIIlIIlllIIlIlllI);
    }
    
    default V compute(final int llllllllllllllllIIlIIlllllIIIIll, final BiFunction<? super Integer, ? super V, ? extends V> llllllllllllllllIIlIIlllllIIIIlI) {
        Objects.requireNonNull(llllllllllllllllIIlIIlllllIIIIlI);
        final V llllllllllllllllIIlIIlllllIIIIIl = this.get(llllllllllllllllIIlIIlllllIIIIll);
        final V llllllllllllllllIIlIIlllllIIIIII = this.defaultReturnValue();
        final boolean llllllllllllllllIIlIIllllIllllll = llllllllllllllllIIlIIlllllIIIIIl != llllllllllllllllIIlIIlllllIIIIII || this.containsKey(llllllllllllllllIIlIIlllllIIIIll);
        final V llllllllllllllllIIlIIllllIlllllI = (V)llllllllllllllllIIlIIlllllIIIIlI.apply(Integer.valueOf(llllllllllllllllIIlIIlllllIIIIll), (Object)(llllllllllllllllIIlIIllllIllllll ? llllllllllllllllIIlIIlllllIIIIIl : null));
        if (llllllllllllllllIIlIIllllIlllllI == null) {
            if (llllllllllllllllIIlIIllllIllllll) {
                this.remove(llllllllllllllllIIlIIlllllIIIIll);
            }
            return llllllllllllllllIIlIIlllllIIIIII;
        }
        this.put(llllllllllllllllIIlIIlllllIIIIll, llllllllllllllllIIlIIllllIlllllI);
        return llllllllllllllllIIlIIllllIlllllI;
    }
    
    @Deprecated
    default boolean containsKey(final Object llllllllllllllllIIlIlIIIIlIIIIII) {
        return super.containsKey(llllllllllllllllIIlIlIIIIlIIIIII);
    }
    
    @Deprecated
    default V merge(final Integer llllllllllllllllIIlIIlllIIIlllll, final V llllllllllllllllIIlIIlllIIIlIlll, final BiFunction<? super V, ? super V, ? extends V> llllllllllllllllIIlIIlllIIIlIlIl) {
        return super.merge(llllllllllllllllIIlIIlllIIIlllll, llllllllllllllllIIlIIlllIIIlIlll, llllllllllllllllIIlIIlllIIIlIlIl);
    }
    
    @Deprecated
    default boolean remove(final Object llllllllllllllllIIlIIllllIIIIlll, final Object llllllllllllllllIIlIIllllIIIIIIl) {
        return super.remove(llllllllllllllllIIlIIllllIIIIlll, llllllllllllllllIIlIIllllIIIIIIl);
    }
    
    @Deprecated
    default V remove(final Object llllllllllllllllIIlIlIIIIlIIIlII) {
        return super.remove(llllllllllllllllIIlIlIIIIlIIIlII);
    }
    
    default void clear() {
        throw new UnsupportedOperationException();
    }
    
    default boolean remove(final int llllllllllllllllIIlIlIIIIIIlllIl, final Object llllllllllllllllIIlIlIIIIIIllIII) {
        final V llllllllllllllllIIlIlIIIIIIllIll = this.get(llllllllllllllllIIlIlIIIIIIlllIl);
        if (!Objects.equals(llllllllllllllllIIlIlIIIIIIllIll, llllllllllllllllIIlIlIIIIIIllIII) || (llllllllllllllllIIlIlIIIIIIllIll == this.defaultReturnValue() && !this.containsKey(llllllllllllllllIIlIlIIIIIIlllIl))) {
            return false;
        }
        this.remove(llllllllllllllllIIlIlIIIIIIlllIl);
        return true;
    }
    
    default V merge(final int llllllllllllllllIIlIIllllIlIIlII, final V llllllllllllllllIIlIIllllIlIIIll, final BiFunction<? super V, ? super V, ? extends V> llllllllllllllllIIlIIllllIlIIIlI) {
        Objects.requireNonNull(llllllllllllllllIIlIIllllIlIIIlI);
        Objects.requireNonNull(llllllllllllllllIIlIIllllIlIIIll);
        final V llllllllllllllllIIlIIllllIlIlIII = this.get(llllllllllllllllIIlIIllllIlIIlII);
        final V llllllllllllllllIIlIIllllIlIIlll = this.defaultReturnValue();
        V llllllllllllllllIIlIIllllIlIIllI = null;
        if (llllllllllllllllIIlIIllllIlIlIII != llllllllllllllllIIlIIllllIlIIlll || this.containsKey(llllllllllllllllIIlIIllllIlIIlII)) {
            final V llllllllllllllllIIlIIllllIlIlllI = (V)llllllllllllllllIIlIIllllIlIIIlI.apply((Object)llllllllllllllllIIlIIllllIlIlIII, (Object)llllllllllllllllIIlIIllllIlIIIll);
            if (llllllllllllllllIIlIIllllIlIlllI == null) {
                this.remove(llllllllllllllllIIlIIllllIlIIlII);
                return llllllllllllllllIIlIIllllIlIIlll;
            }
            final V llllllllllllllllIIlIIllllIlIllIl = llllllllllllllllIIlIIllllIlIlllI;
        }
        else {
            llllllllllllllllIIlIIllllIlIIllI = llllllllllllllllIIlIIllllIlIIIll;
        }
        this.put(llllllllllllllllIIlIIllllIlIIlII, llllllllllllllllIIlIIllllIlIIllI);
        return llllllllllllllllIIlIIllllIlIIllI;
    }
    
    ObjectCollection<V> values();
    
    @Deprecated
    default V putIfAbsent(final Integer llllllllllllllllIIlIIllllIIIllIl, final V llllllllllllllllIIlIIllllIIIllII) {
        return super.putIfAbsent(llllllllllllllllIIlIIllllIIIllIl, llllllllllllllllIIlIIllllIIIllII);
    }
    
    @Deprecated
    default V getOrDefault(final Object llllllllllllllllIIlIIllllIIlIllI, final V llllllllllllllllIIlIIllllIIlIlIl) {
        return super.getOrDefault(llllllllllllllllIIlIIllllIIlIllI, llllllllllllllllIIlIIllllIIlIlIl);
    }
    
    @Deprecated
    default boolean replace(final Integer llllllllllllllllIIlIIlllIlllIlII, final V llllllllllllllllIIlIIlllIlllIIll, final V llllllllllllllllIIlIIlllIllIlIll) {
        return super.replace(llllllllllllllllIIlIIlllIlllIlII, llllllllllllllllIIlIIlllIlllIIll, llllllllllllllllIIlIIlllIllIlIll);
    }
    
    default boolean replace(final int llllllllllllllllIIlIlIIIIIIIlIll, final V llllllllllllllllIIlIlIIIIIIIlIlI, final V llllllllllllllllIIlIlIIIIIIIlIIl) {
        final V llllllllllllllllIIlIlIIIIIIIllIl = this.get(llllllllllllllllIIlIlIIIIIIIlIll);
        if (!Objects.equals(llllllllllllllllIIlIlIIIIIIIllIl, llllllllllllllllIIlIlIIIIIIIlIlI) || (llllllllllllllllIIlIlIIIIIIIllIl == this.defaultReturnValue() && !this.containsKey(llllllllllllllllIIlIlIIIIIIIlIll))) {
            return false;
        }
        this.put(llllllllllllllllIIlIlIIIIIIIlIll, llllllllllllllllIIlIlIIIIIIIlIIl);
        return true;
    }
    
    @Deprecated
    default ObjectSet<Map.Entry<Integer, V>> entrySet() {
        return (ObjectSet<Map.Entry<Integer, V>>)this.int2ObjectEntrySet();
    }
    
    void defaultReturnValue(final V p0);
    
    V defaultReturnValue();
    
    boolean containsKey(final int p0);
    
    default V putIfAbsent(final int llllllllllllllllIIlIlIIIIIlIlIll, final V llllllllllllllllIIlIlIIIIIlIlIlI) {
        final V llllllllllllllllIIlIlIIIIIlIlIIl = this.get(llllllllllllllllIIlIlIIIIIlIlIll);
        final V llllllllllllllllIIlIlIIIIIlIlIII = this.defaultReturnValue();
        if (llllllllllllllllIIlIlIIIIIlIlIIl != llllllllllllllllIIlIlIIIIIlIlIII || this.containsKey(llllllllllllllllIIlIlIIIIIlIlIll)) {
            return llllllllllllllllIIlIlIIIIIlIlIIl;
        }
        this.put(llllllllllllllllIIlIlIIIIIlIlIll, llllllllllllllllIIlIlIIIIIlIlIlI);
        return llllllllllllllllIIlIlIIIIIlIlIII;
    }
    
    @Deprecated
    default V replace(final Integer llllllllllllllllIIlIIlllIlIllIll, final V llllllllllllllllIIlIIlllIlIllllI) {
        return super.replace(llllllllllllllllIIlIIlllIlIllIll, llllllllllllllllIIlIIlllIlIllllI);
    }
    
    default V replace(final int llllllllllllllllIIlIlIIIIIIIIIII, final V llllllllllllllllIIlIlIIIIIIIIIlI) {
        return this.containsKey(llllllllllllllllIIlIlIIIIIIIIIII) ? this.put(llllllllllllllllIIlIlIIIIIIIIIII, llllllllllllllllIIlIlIIIIIIIIIlI) : this.defaultReturnValue();
    }
    
    public interface Entry<V> extends Map.Entry<Integer, V>
    {
        @Deprecated
        default Integer getKey() {
            return this.getIntKey();
        }
        
        int getIntKey();
    }
    
    public interface FastEntrySet<V> extends ObjectSet<Entry<V>>
    {
        default void fastForEach(final Consumer<? super Entry<V>> lIllIlIlIIIllI) {
            this.forEach(lIllIlIlIIIllI);
        }
        
        ObjectIterator<Entry<V>> fastIterator();
    }
}
