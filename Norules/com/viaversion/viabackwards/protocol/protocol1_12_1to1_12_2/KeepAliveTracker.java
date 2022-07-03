package com.viaversion.viabackwards.protocol.protocol1_12_1to1_12_2;

import com.viaversion.viaversion.api.connection.*;

public class KeepAliveTracker implements StorableObject
{
    private /* synthetic */ long keepAlive;
    
    public void setKeepAlive(final long llllllllllllllIIIIIIIIlllIlllIIl) {
        this.keepAlive = llllllllllllllIIIIIIIIlllIlllIIl;
    }
    
    public KeepAliveTracker() {
        this.keepAlive = 2147483647L;
    }
    
    public long getKeepAlive() {
        return this.keepAlive;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("KeepAliveTracker{keepAlive=").append(this.keepAlive).append('}'));
    }
}
