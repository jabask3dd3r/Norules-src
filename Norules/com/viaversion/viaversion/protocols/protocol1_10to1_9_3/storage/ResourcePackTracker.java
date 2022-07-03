package com.viaversion.viaversion.protocols.protocol1_10to1_9_3.storage;

import com.viaversion.viaversion.api.connection.*;

public class ResourcePackTracker implements StorableObject
{
    private /* synthetic */ String lastHash;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("ResourcePackTracker{lastHash='").append(this.lastHash).append('\'').append('}'));
    }
    
    public void setLastHash(final String llllllllllllllllIlIIlllIlIIIllll) {
        this.lastHash = llllllllllllllllIlIIlllIlIIIllll;
    }
    
    public String getLastHash() {
        return this.lastHash;
    }
    
    public ResourcePackTracker() {
        this.lastHash = "";
    }
}
