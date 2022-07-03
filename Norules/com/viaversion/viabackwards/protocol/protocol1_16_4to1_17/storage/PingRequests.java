package com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.storage;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public final class PingRequests implements StorableObject
{
    private final /* synthetic */ IntSet ids;
    
    public void addId(final short lllllllllllllllIIlIIIIlllIIIIIII) {
        this.ids.add(lllllllllllllllIIlIIIIlllIIIIIII);
    }
    
    public boolean removeId(final short lllllllllllllllIIlIIIIllIllllIlI) {
        return this.ids.remove(lllllllllllllllIIlIIIIllIllllIlI);
    }
    
    public PingRequests() {
        this.ids = new IntOpenHashSet();
    }
}
