package com.viaversion.viaversion.api.platform.providers;

import java.util.*;

public class ViaProviders
{
    private final /* synthetic */ List<Class<? extends Provider>> lonelyProviders;
    private final /* synthetic */ Map<Class<? extends Provider>, Provider> providers;
    
    public <T extends Provider> void register(final Class<T> llllllllllllllIlIIllIIlllllllllI, final T llllllllllllllIlIIllIlIIIIIIIIII) {
        this.providers.put(llllllllllllllIlIIllIIlllllllllI, llllllllllllllIlIIllIlIIIIIIIIII);
    }
    
    public <T extends Provider> void use(final Class<T> llllllllllllllIlIIllIIlllllllIII, final T llllllllllllllIlIIllIIllllllIlII) {
        this.lonelyProviders.remove(llllllllllllllIlIIllIIlllllllIII);
        this.providers.put(llllllllllllllIlIIllIIlllllllIII, llllllllllllllIlIIllIIllllllIlII);
    }
    
    public ViaProviders() {
        this.providers = new HashMap<Class<? extends Provider>, Provider>();
        this.lonelyProviders = new ArrayList<Class<? extends Provider>>();
    }
    
    public void require(final Class<? extends Provider> llllllllllllllIlIIllIlIIIIIIIllI) {
        this.lonelyProviders.add(llllllllllllllIlIIllIlIIIIIIIllI);
    }
    
    public <T extends Provider> T get(final Class<T> llllllllllllllIlIIllIIlllllIllII) {
        final Provider llllllllllllllIlIIllIIlllllIlllI = this.providers.get(llllllllllllllIlIIllIIlllllIllII);
        if (llllllllllllllIlIIllIIlllllIlllI != null) {
            return (T)llllllllllllllIlIIllIIlllllIlllI;
        }
        if (this.lonelyProviders.contains(llllllllllllllIlIIllIIlllllIllII)) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("There was no provider for ").append(llllllllllllllIlIIllIIlllllIllII).append(", one is required!")));
        }
        return null;
    }
}
