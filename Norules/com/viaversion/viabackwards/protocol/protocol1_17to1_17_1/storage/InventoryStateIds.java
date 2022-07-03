package com.viaversion.viabackwards.protocol.protocol1_17to1_17_1.storage;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public final class InventoryStateIds implements StorableObject
{
    private final /* synthetic */ Int2IntMap ids;
    
    public InventoryStateIds() {
        this.ids = new Int2IntOpenHashMap();
        this.ids.defaultReturnValue(Integer.MAX_VALUE);
    }
    
    public int removeStateId(final short llllllllllllllIllllIIlIlllIllIIl) {
        return this.ids.remove(llllllllllllllIllllIIlIlllIllIIl);
    }
    
    public void setStateId(final short llllllllllllllIllllIIlIllllIIIIl, final int llllllllllllllIllllIIlIlllIlllIl) {
        this.ids.put(llllllllllllllIllllIIlIllllIIIIl, llllllllllllllIllllIIlIlllIlllIl);
    }
}
