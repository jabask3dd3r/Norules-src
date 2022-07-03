package net.minecraft.server.management;

import com.google.gson.*;

public class UserListEntry<T>
{
    private final /* synthetic */ T value;
    
    public UserListEntry(final T lllllllllllllIllIlIIIIlllIlllllI) {
        this.value = lllllllllllllIllIlIIIIlllIlllllI;
    }
    
    protected UserListEntry(final T lllllllllllllIllIlIIIIlllIllIlIl, final JsonObject lllllllllllllIllIlIIIIlllIllIlll) {
        this.value = lllllllllllllIllIlIIIIlllIllIlIl;
    }
    
    T getValue() {
        return this.value;
    }
    
    boolean hasBanExpired() {
        return false;
    }
    
    protected void onSerialization(final JsonObject lllllllllllllIllIlIIIIlllIlIllll) {
    }
}
