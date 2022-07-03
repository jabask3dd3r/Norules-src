package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public interface Item
{
    void setAmount(final int p0);
    
    void setTag(final CompoundTag p0);
    
    default void setData(final short lllllllllllllIIlIIIlllllllIIlllI) {
        throw new UnsupportedOperationException();
    }
    
    int identifier();
    
    void setIdentifier(final int p0);
    
    int amount();
    
    CompoundTag tag();
    
    default short data() {
        return 0;
    }
}
