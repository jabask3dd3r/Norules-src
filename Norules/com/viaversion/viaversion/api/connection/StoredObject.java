package com.viaversion.viaversion.api.connection;

public abstract class StoredObject implements StorableObject
{
    private final /* synthetic */ UserConnection user;
    
    protected StoredObject(final UserConnection lllllllllllllIIlllIIIIllIIllIIII) {
        this.user = lllllllllllllIIlllIIIIllIIllIIII;
    }
    
    public UserConnection getUser() {
        return this.user;
    }
}
