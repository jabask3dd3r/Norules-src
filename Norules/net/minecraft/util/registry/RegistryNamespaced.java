package net.minecraft.util.registry;

import net.minecraft.util.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public class RegistryNamespaced<K, V> extends RegistrySimple<K, V> implements IObjectIntIterable<V>
{
    protected final /* synthetic */ IntIdentityHashBiMap<V> underlyingIntegerMap;
    protected final /* synthetic */ Map<V, K> inverseObjectRegistry;
    
    @Nullable
    public V getObjectById(final int lllllllllllllIIIIlIIlIlIIlIIlIII) {
        return this.underlyingIntegerMap.get(lllllllllllllIIIIlIIlIlIIlIIlIII);
    }
    
    public RegistryNamespaced() {
        this.underlyingIntegerMap = new IntIdentityHashBiMap<V>(256);
        this.inverseObjectRegistry = (Map<V, K>)((BiMap)this.registryObjects).inverse();
    }
    
    @Override
    public boolean containsKey(final K lllllllllllllIIIIlIIlIlIIlIlIllI) {
        return super.containsKey(lllllllllllllIIIIlIIlIlIIlIlIllI);
    }
    
    @Nullable
    @Override
    public V getObject(@Nullable final K lllllllllllllIIIIlIIlIlIIllIIIlI) {
        return super.getObject(lllllllllllllIIIIlIIlIlIIllIIIlI);
    }
    
    @Override
    protected Map<K, V> createUnderlyingMap() {
        return (Map<K, V>)HashBiMap.create();
    }
    
    @Override
    public Iterator<V> iterator() {
        return this.underlyingIntegerMap.iterator();
    }
    
    @Nullable
    public K getNameForObject(final V lllllllllllllIIIIlIIlIlIIlIllIlI) {
        return this.inverseObjectRegistry.get(lllllllllllllIIIIlIIlIlIIlIllIlI);
    }
    
    public void register(final int lllllllllllllIIIIlIIlIlIIllIlIIl, final K lllllllllllllIIIIlIIlIlIIllIllII, final V lllllllllllllIIIIlIIlIlIIllIIlll) {
        this.underlyingIntegerMap.put(lllllllllllllIIIIlIIlIlIIllIIlll, lllllllllllllIIIIlIIlIlIIllIlIIl);
        this.putObject(lllllllllllllIIIIlIIlIlIIllIllII, lllllllllllllIIIIlIIlIlIIllIIlll);
    }
    
    public int getIDForObject(@Nullable final V lllllllllllllIIIIlIIlIlIIlIIlllI) {
        return this.underlyingIntegerMap.getId(lllllllllllllIIIIlIIlIlIIlIIlllI);
    }
}
