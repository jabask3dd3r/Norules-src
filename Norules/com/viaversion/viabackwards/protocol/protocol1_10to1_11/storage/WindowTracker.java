package com.viaversion.viabackwards.protocol.protocol1_10to1_11.storage;

import com.viaversion.viaversion.api.connection.*;

public class WindowTracker implements StorableObject
{
    private /* synthetic */ String inventory;
    private /* synthetic */ int entityId;
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public WindowTracker() {
        this.entityId = -1;
    }
    
    public String getInventory() {
        return this.inventory;
    }
    
    public void setInventory(final String lllllllllllllIlIIIIIIllIlIIIllII) {
        this.inventory = lllllllllllllIlIIIIIIllIlIIIllII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("WindowTracker{inventory='").append(this.inventory).append('\'').append(", entityId=").append(this.entityId).append('}'));
    }
    
    public void setEntityId(final int lllllllllllllIlIIIIIIllIlIIIIlIl) {
        this.entityId = lllllllllllllIlIIIIIIllIlIIIIlIl;
    }
}
