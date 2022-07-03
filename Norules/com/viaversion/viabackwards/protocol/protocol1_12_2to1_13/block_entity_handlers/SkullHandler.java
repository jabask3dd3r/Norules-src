package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class SkullHandler implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler
{
    @Override
    public CompoundTag transform(final UserConnection llllllllllllllllIIIlIlIlllllllll, final int llllllllllllllllIIIlIlIllllllIIl, final CompoundTag llllllllllllllllIIIlIlIllllllIII) {
        final int llllllllllllllllIIIlIlIlllllllII = llllllllllllllllIIIlIlIllllllIIl - 5447;
        final int llllllllllllllllIIIlIlIllllllIll = llllllllllllllllIIIlIlIlllllllII % 20;
        final byte llllllllllllllllIIIlIlIllllllIlI = (byte)Math.floor(llllllllllllllllIIIlIlIlllllllII / 20.0f);
        llllllllllllllllIIIlIlIllllllIII.put("SkullType", new ByteTag(llllllllllllllllIIIlIlIllllllIlI));
        if (llllllllllllllllIIIlIlIllllllIll < 4) {
            return llllllllllllllllIIIlIlIllllllIII;
        }
        llllllllllllllllIIIlIlIllllllIII.put("Rot", new ByteTag((byte)(llllllllllllllllIIIlIlIllllllIll - 4 & 0xFF)));
        return llllllllllllllllIIIlIlIllllllIII;
    }
    
    static {
        SKULL_START = 5447;
    }
}
