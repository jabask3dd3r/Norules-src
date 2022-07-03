package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class BedHandler implements BlockEntityProvider.BlockEntityHandler
{
    @Override
    public int transform(final UserConnection llllllllllllllIllIIIIlIIlIIIlIIl, final CompoundTag llllllllllllllIllIIIIlIIlIIIlIII) {
        final BlockStorage llllllllllllllIllIIIIlIIlIIIlllI = llllllllllllllIllIIIIlIIlIIIlIIl.get(BlockStorage.class);
        final Position llllllllllllllIllIIIIlIIlIIIllIl = new Position((int)this.getLong(llllllllllllllIllIIIIlIIlIIIlIII.get("x")), (short)this.getLong(llllllllllllllIllIIIIlIIlIIIlIII.get("y")), (int)this.getLong(llllllllllllllIllIIIIlIIlIIIlIII.get("z")));
        if (!llllllllllllllIllIIIIlIIlIIIlllI.contains(llllllllllllllIllIIIIlIIlIIIllIl)) {
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Received an bed color update packet, but there is no bed! O_o ").append(llllllllllllllIllIIIIlIIlIIIlIII)));
            return -1;
        }
        int llllllllllllllIllIIIIlIIlIIIllII = llllllllllllllIllIIIIlIIlIIIlllI.get(llllllllllllllIllIIIIlIIlIIIllIl).getOriginal() - 972 + 748;
        final Tag llllllllllllllIllIIIIlIIlIIIlIll = llllllllllllllIllIIIIlIIlIIIlIII.get("color");
        if (llllllllllllllIllIIIIlIIlIIIlIll != null) {
            llllllllllllllIllIIIIlIIlIIIllII += ((NumberTag)llllllllllllllIllIIIIlIIlIIIlIll).asInt() * 16;
        }
        return llllllllllllllIllIIIIlIIlIIIllII;
    }
    
    private long getLong(final NumberTag llllllllllllllIllIIIIlIIlIIIIIIl) {
        return llllllllllllllIllIIIIlIIlIIIIIIl.asLong();
    }
}
