package com.viaversion.viaversion.protocols.protocol1_17to1_16_4.storage;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public final class InventoryAcknowledgements implements StorableObject
{
    private final /* synthetic */ IntSet ids;
    
    public boolean removeId(final int lIIIllllllIllI) {
        return this.ids.remove(lIIIllllllIllI);
    }
    
    public InventoryAcknowledgements() {
        this.ids = new IntOpenHashSet();
    }
    
    public void addId(final int lIIIlllllllllI) {
        this.ids.add(lIIIlllllllllI);
    }
}
