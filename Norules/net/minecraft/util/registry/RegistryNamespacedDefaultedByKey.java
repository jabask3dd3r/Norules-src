package net.minecraft.util.registry;

import javax.annotation.*;
import java.util.*;
import org.apache.commons.lang3.*;

public class RegistryNamespacedDefaultedByKey<K, V> extends RegistryNamespaced<K, V>
{
    private final /* synthetic */ K defaultValueKey;
    private /* synthetic */ V defaultValue;
    
    @Nonnull
    @Override
    public K getNameForObject(final V lllllllllllllIIIIlllllIIllIlllIl) {
        final K lllllllllllllIIIIlllllIIllIlllII = super.getNameForObject(lllllllllllllIIIIlllllIIllIlllIl);
        return (lllllllllllllIIIIlllllIIllIlllII == null) ? this.defaultValueKey : lllllllllllllIIIIlllllIIllIlllII;
    }
    
    @Nonnull
    @Override
    public V getObject(@Nullable final K lllllllllllllIIIIlllllIIllIlIlII) {
        final V lllllllllllllIIIIlllllIIllIlIIll = super.getObject(lllllllllllllIIIIlllllIIllIlIlII);
        return (lllllllllllllIIIIlllllIIllIlIIll == null) ? this.defaultValue : lllllllllllllIIIIlllllIIllIlIIll;
    }
    
    @Override
    public int getIDForObject(final V lllllllllllllIIIIlllllIIlllIIllI) {
        final int lllllllllllllIIIIlllllIIlllIIlIl = super.getIDForObject(lllllllllllllIIIIlllllIIlllIIllI);
        return (lllllllllllllIIIIlllllIIlllIIlIl == -1) ? super.getIDForObject(this.defaultValue) : lllllllllllllIIIIlllllIIlllIIlIl;
    }
    
    @Override
    public void register(final int lllllllllllllIIIIlllllIIllllIIII, final K lllllllllllllIIIIlllllIIllllIIll, final V lllllllllllllIIIIlllllIIllllIIlI) {
        if (this.defaultValueKey.equals(lllllllllllllIIIIlllllIIllllIIll)) {
            this.defaultValue = lllllllllllllIIIIlllllIIllllIIlI;
        }
        super.register(lllllllllllllIIIIlllllIIllllIIII, lllllllllllllIIIIlllllIIllllIIll, lllllllllllllIIIIlllllIIllllIIlI);
    }
    
    @Nonnull
    @Override
    public V getObjectById(final int lllllllllllllIIIIlllllIIllIIlIll) {
        final V lllllllllllllIIIIlllllIIllIIlIlI = super.getObjectById(lllllllllllllIIIIlllllIIllIIlIll);
        return (lllllllllllllIIIIlllllIIllIIlIlI == null) ? this.defaultValue : lllllllllllllIIIIlllllIIllIIlIlI;
    }
    
    public RegistryNamespacedDefaultedByKey(final K lllllllllllllIIIIlllllIIlllllIlI) {
        this.defaultValueKey = lllllllllllllIIIIlllllIIlllllIlI;
    }
    
    @Nonnull
    @Override
    public V getRandomObject(final Random lllllllllllllIIIIlllllIIllIIIIlI) {
        final V lllllllllllllIIIIlllllIIllIIIIIl = super.getRandomObject(lllllllllllllIIIIlllllIIllIIIIlI);
        return (lllllllllllllIIIIlllllIIllIIIIIl == null) ? this.defaultValue : lllllllllllllIIIIlllllIIllIIIIIl;
    }
    
    public void validateKey() {
        Validate.notNull((Object)this.defaultValue, String.valueOf(new StringBuilder("Missing default of DefaultedMappedRegistry: ").append(this.defaultValueKey)), new Object[0]);
    }
}
