package com.viaversion.viaversion.protocols.protocol1_9to1_8.storage;

import com.viaversion.viaversion.api.connection.*;

public class MovementTracker implements StorableObject
{
    private /* synthetic */ boolean ground;
    private /* synthetic */ long nextIdlePacket;
    
    public MovementTracker() {
        this.nextIdlePacket = 0L;
        this.ground = true;
    }
    
    public boolean isGround() {
        return this.ground;
    }
    
    public long getNextIdlePacket() {
        return this.nextIdlePacket;
    }
    
    public void incrementIdlePacket() {
        this.nextIdlePacket = Math.max(this.nextIdlePacket + 50L, System.currentTimeMillis() - 1000L);
    }
    
    public void setGround(final boolean llllllllllllllIIllIIlllIlIIIlIIl) {
        this.ground = llllllllllllllIIllIIlllIlIIIlIIl;
    }
}
