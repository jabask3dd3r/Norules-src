package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class SkullHandler implements BlockEntityProvider.BlockEntityHandler
{
    static {
        SKULL_END = 5566;
        SKULL_WALL_START = 5447;
    }
    
    private long getLong(final NumberTag lllllllllllllIlIllIIlIlllllIlllI) {
        return lllllllllllllIlIllIIlIlllllIlllI.asLong();
    }
    
    @Override
    public int transform(final UserConnection lllllllllllllIlIllIIlIllllllllII, final CompoundTag lllllllllllllIlIllIIlIlllllllIll) {
        final BlockStorage lllllllllllllIlIllIIlIlllllllIlI = lllllllllllllIlIllIIlIllllllllII.get(BlockStorage.class);
        final Position lllllllllllllIlIllIIlIlllllllIIl = new Position((int)this.getLong(lllllllllllllIlIllIIlIlllllllIll.get("x")), (short)this.getLong(lllllllllllllIlIllIIlIlllllllIll.get("y")), (int)this.getLong(lllllllllllllIlIllIIlIlllllllIll.get("z")));
        if (!lllllllllllllIlIllIIlIlllllllIlI.contains(lllllllllllllIlIllIIlIlllllllIIl)) {
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Received an head update packet, but there is no head! O_o ").append(lllllllllllllIlIllIIlIlllllllIll)));
            return -1;
        }
        int lllllllllllllIlIllIIlIlllllllIII = lllllllllllllIlIllIIlIlllllllIlI.get(lllllllllllllIlIllIIlIlllllllIIl).getOriginal();
        if (lllllllllllllIlIllIIlIlllllllIII >= 5447 && lllllllllllllIlIllIIlIlllllllIII <= 5566) {
            final Tag lllllllllllllIlIllIIlIlllllllllI = lllllllllllllIlIllIIlIlllllllIll.get("SkullType");
            if (lllllllllllllIlIllIIlIlllllllllI != null) {
                lllllllllllllIlIllIIlIlllllllIII += lllllllllllllIlIllIIlIlllllllIll.get("SkullType").asInt() * 20;
            }
            if (lllllllllllllIlIllIIlIlllllllIll.contains("Rot")) {
                lllllllllllllIlIllIIlIlllllllIII += lllllllllllllIlIllIIlIlllllllIll.get("Rot").asInt();
            }
            return lllllllllllllIlIllIIlIlllllllIII;
        }
        Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Why does this block have the skull block entity? ").append(lllllllllllllIlIllIIlIlllllllIll)));
        return -1;
    }
}
