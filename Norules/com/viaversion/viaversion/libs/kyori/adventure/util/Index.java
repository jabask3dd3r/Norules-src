package com.viaversion.viaversion.libs.kyori.adventure.util;

import org.jetbrains.annotations.*;
import java.util.function.*;
import java.util.*;

public final class Index<K, V>
{
    private final /* synthetic */ Map<K, V> keyToValue;
    private final /* synthetic */ Map<V, K> valueToKey;
    
    @Nullable
    public K key(@NotNull final V lllllllllllllIIIlIIlIIlIlIIlIlII) {
        return this.valueToKey.get(lllllllllllllIIIlIIlIIlIlIIlIlII);
    }
    
    @NotNull
    public Set<V> values() {
        return Collections.unmodifiableSet((Set<? extends V>)this.valueToKey.keySet());
    }
    
    @NotNull
    private static <K, V> Index<K, V> create(final V[] lllllllllllllIIIlIIlIIlIlIlllllI, final IntFunction<Map<V, K>> lllllllllllllIIIlIIlIIlIllIIIIII, @NotNull final Function<? super V, ? extends K> lllllllllllllIIIlIIlIIlIlIllllll) {
        return create((List<V>)Arrays.asList((V[])lllllllllllllIIIlIIlIIlIlIlllllI), lllllllllllllIIIlIIlIIlIllIIIIII, lllllllllllllIIIlIIlIIlIlIllllll);
    }
    
    @NotNull
    public Set<K> keys() {
        return Collections.unmodifiableSet((Set<? extends K>)this.keyToValue.keySet());
    }
    
    @SafeVarargs
    @NotNull
    public static <K, V> Index<K, V> create(@NotNull final Function<? super V, ? extends K> lllllllllllllIIIlIIlIIlIllIlIIIl, @NotNull final V... lllllllllllllIIIlIIlIIlIllIlIIII) {
        return create(lllllllllllllIIIlIIlIIlIllIlIIII, (IntFunction<Map<V, K>>)HashMap::new, lllllllllllllIIIlIIlIIlIllIlIIIl);
    }
    
    @NotNull
    private static <K, V> Index<K, V> create(final List<V> lllllllllllllIIIlIIlIIlIlIlIlllI, final IntFunction<Map<V, K>> lllllllllllllIIIlIIlIIlIlIlIllII, @NotNull final Function<? super V, ? extends K> lllllllllllllIIIlIIlIIlIlIlIllIl) {
        final int lllllllllllllIIIlIIlIIlIlIlIIlIl = lllllllllllllIIIlIIlIIlIlIlIlllI.size();
        final Map<K, V> lllllllllllllIIIlIIlIIlIlIlIIlII = new HashMap<K, V>(lllllllllllllIIIlIIlIIlIlIlIIlIl);
        final Map<V, K> lllllllllllllIIIlIIlIIlIlIlIIIll = lllllllllllllIIIlIIlIIlIlIlIllII.apply(lllllllllllllIIIlIIlIIlIlIlIIlIl);
        for (int lllllllllllllIIIlIIlIIlIlIlIlIIl = 0; lllllllllllllIIIlIIlIIlIlIlIlIIl < lllllllllllllIIIlIIlIIlIlIlIIlIl; ++lllllllllllllIIIlIIlIIlIlIlIlIIl) {
            final V lllllllllllllIIIlIIlIIlIlIlIlIll = lllllllllllllIIIlIIlIIlIlIlIlllI.get(lllllllllllllIIIlIIlIIlIlIlIlIIl);
            final K lllllllllllllIIIlIIlIIlIlIlIlIlI = (K)lllllllllllllIIIlIIlIIlIlIlIllIl.apply((Object)lllllllllllllIIIlIIlIIlIlIlIlIll);
            if (lllllllllllllIIIlIIlIIlIlIlIIlII.putIfAbsent(lllllllllllllIIIlIIlIIlIlIlIlIlI, lllllllllllllIIIlIIlIIlIlIlIlIll) != null) {
                throw new IllegalStateException(String.format("Key %s already mapped to value %s", lllllllllllllIIIlIIlIIlIlIlIlIlI, lllllllllllllIIIlIIlIIlIlIlIIlII.get(lllllllllllllIIIlIIlIIlIlIlIlIlI)));
            }
            if (lllllllllllllIIIlIIlIIlIlIlIIIll.putIfAbsent(lllllllllllllIIIlIIlIIlIlIlIlIll, lllllllllllllIIIlIIlIIlIlIlIlIlI) != null) {
                throw new IllegalStateException(String.format("Value %s already mapped to key %s", lllllllllllllIIIlIIlIIlIlIlIlIll, lllllllllllllIIIlIIlIIlIlIlIIIll.get(lllllllllllllIIIlIIlIIlIlIlIlIll)));
            }
        }
        return new Index<K, V>(Collections.unmodifiableMap((Map<? extends K, ? extends V>)lllllllllllllIIIlIIlIIlIlIlIIlII), Collections.unmodifiableMap((Map<? extends V, ? extends K>)lllllllllllllIIIlIIlIIlIlIlIIIll));
    }
    
    @SafeVarargs
    @NotNull
    public static <K, V extends Enum<V>> Index<K, V> create(final Class<V> lllllllllllllIIIlIIlIIlIllIlllII, @NotNull final Function<? super V, ? extends K> lllllllllllllIIIlIIlIIlIllIllIll, @NotNull final V... lllllllllllllIIIlIIlIIlIllIllIlI) {
        return create(lllllllllllllIIIlIIlIIlIllIllIlI, lllllllllllllIIIlIIlIIlIlIIIIIll -> new EnumMap((Class<Enum>)lllllllllllllIIIlIIlIIlIllIlllII), lllllllllllllIIIlIIlIIlIllIllIll);
    }
    
    @NotNull
    public static <K, V extends Enum<V>> Index<K, V> create(final Class<V> lllllllllllllIIIlIIlIIlIlllIIlII, @NotNull final Function<? super V, ? extends K> lllllllllllllIIIlIIlIIlIlllIIlIl) {
        return create(lllllllllllllIIIlIIlIIlIlllIIlII, lllllllllllllIIIlIIlIIlIlllIIlIl, (V[])lllllllllllllIIIlIIlIIlIlllIIlII.getEnumConstants());
    }
    
    @NotNull
    public static <K, V> Index<K, V> create(@NotNull final Function<? super V, ? extends K> lllllllllllllIIIlIIlIIlIllIIlIIl, @NotNull final List<V> lllllllllllllIIIlIIlIIlIllIIlIII) {
        return create(lllllllllllllIIIlIIlIIlIllIIlIII, (IntFunction<Map<V, K>>)HashMap::new, lllllllllllllIIIlIIlIIlIllIIlIIl);
    }
    
    @Nullable
    public V value(@NotNull final K lllllllllllllIIIlIIlIIlIlIIIlIlI) {
        return this.keyToValue.get(lllllllllllllIIIlIIlIIlIlIIIlIlI);
    }
    
    private Index(final Map<K, V> lllllllllllllIIIlIIlIIlIlllIllll, final Map<V, K> lllllllllllllIIIlIIlIIlIlllIlllI) {
        this.keyToValue = lllllllllllllIIIlIIlIIlIlllIllll;
        this.valueToKey = lllllllllllllIIIlIIlIIlIlllIlllI;
    }
}
