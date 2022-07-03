package net.minecraft.util.registry;

import com.google.common.collect.*;
import javax.annotation.*;
import org.apache.commons.lang3.*;
import org.apache.logging.log4j.*;
import java.util.*;

public class RegistrySimple<K, V> implements IRegistry<K, V>
{
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ Object[] values;
    protected final /* synthetic */ Map<K, V> registryObjects;
    
    protected Map<K, V> createUnderlyingMap() {
        return (Map<K, V>)Maps.newHashMap();
    }
    
    public boolean containsKey(final K lIIIlIIIllIlllI) {
        return this.registryObjects.containsKey(lIIIlIIIllIlllI);
    }
    
    public RegistrySimple() {
        this.registryObjects = this.createUnderlyingMap();
    }
    
    @Override
    public Iterator<V> iterator() {
        return this.registryObjects.values().iterator();
    }
    
    @Nullable
    @Override
    public V getObject(@Nullable final K lIIIlIIlIIIIlll) {
        return this.registryObjects.get(lIIIlIIlIIIIlll);
    }
    
    @Override
    public void putObject(final K lIIIlIIIlllllll, final V lIIIlIIlIIIIIIl) {
        Validate.notNull((Object)lIIIlIIIlllllll);
        Validate.notNull((Object)lIIIlIIlIIIIIIl);
        this.values = null;
        if (this.registryObjects.containsKey(lIIIlIIIlllllll)) {
            RegistrySimple.LOGGER.debug("Adding duplicate key '{}' to registry", (Object)lIIIlIIIlllllll);
        }
        this.registryObjects.put(lIIIlIIIlllllll, lIIIlIIlIIIIIIl);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public Set<K> getKeys() {
        return Collections.unmodifiableSet((Set<? extends K>)this.registryObjects.keySet());
    }
    
    @Nullable
    public V getRandomObject(final Random lIIIlIIIlllIllI) {
        if (this.values == null) {
            final Collection<?> lIIIlIIIlllIlIl = this.registryObjects.values();
            if (lIIIlIIIlllIlIl.isEmpty()) {
                return null;
            }
            this.values = lIIIlIIIlllIlIl.toArray(new Object[lIIIlIIIlllIlIl.size()]);
        }
        return (V)this.values[lIIIlIIIlllIllI.nextInt(this.values.length)];
    }
}
