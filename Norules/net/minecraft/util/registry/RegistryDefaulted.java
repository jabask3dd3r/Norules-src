package net.minecraft.util.registry;

import javax.annotation.*;

public class RegistryDefaulted<K, V> extends RegistrySimple<K, V>
{
    private final /* synthetic */ V defaultObject;
    
    public RegistryDefaulted(final V lllllllllllllIIlIIlIllIIlIIIIIIl) {
        this.defaultObject = lllllllllllllIIlIIlIllIIlIIIIIIl;
    }
    
    @Nonnull
    @Override
    public V getObject(@Nullable final K lllllllllllllIIlIIlIllIIIlllllII) {
        final V lllllllllllllIIlIIlIllIIIllllIll = super.getObject(lllllllllllllIIlIIlIllIIIlllllII);
        return (lllllllllllllIIlIIlIllIIIllllIll == null) ? this.defaultObject : lllllllllllllIIlIIlIllIIIllllIll;
    }
}
