package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import java.util.*;

public class BannerHandler implements BlockEntityProvider.BlockEntityHandler
{
    static {
        BANNER_START = 6854;
        WALL_BANNER_STOP = 7173;
        WALL_BANNER_START = 7110;
        BANNER_STOP = 7109;
    }
    
    private long getLong(final NumberTag llIIllIIlIIII) {
        return llIIllIIlIIII.asLong();
    }
    
    @Override
    public int transform(final UserConnection llIIllIlIIlIl, final CompoundTag llIIllIlIIlII) {
        final BlockStorage llIIllIlIIIll = llIIllIlIIlIl.get(BlockStorage.class);
        final Position llIIllIlIIIlI = new Position((int)this.getLong(llIIllIlIIlII.get("x")), (short)this.getLong(llIIllIlIIlII.get("y")), (int)this.getLong(llIIllIlIIlII.get("z")));
        if (!llIIllIlIIIll.contains(llIIllIlIIIlI)) {
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Received an banner color update packet, but there is no banner! O_o ").append(llIIllIlIIlII)));
            return -1;
        }
        int llIIllIlIIIIl = llIIllIlIIIll.get(llIIllIlIIIlI).getOriginal();
        final Tag llIIllIlIIIII = llIIllIlIIlII.get("Base");
        int llIIllIIlllll = 0;
        if (llIIllIlIIIII != null) {
            llIIllIIlllll = llIIllIlIIlII.get("Base").asInt();
        }
        if (llIIllIlIIIIl >= 6854 && llIIllIlIIIIl <= 7109) {
            llIIllIlIIIIl += (15 - llIIllIIlllll) * 16;
        }
        else if (llIIllIlIIIIl >= 7110 && llIIllIlIIIIl <= 7173) {
            llIIllIlIIIIl += (15 - llIIllIIlllll) * 4;
        }
        else {
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Why does this block have the banner block entity? :(").append(llIIllIlIIlII)));
        }
        if (llIIllIlIIlII.get("Patterns") instanceof ListTag) {
            for (final Tag llIIllIlllIIl : llIIllIlIIlII.get("Patterns")) {
                if (llIIllIlllIIl instanceof CompoundTag) {
                    final Tag llIIllIlllIlI = ((CompoundTag)llIIllIlllIIl).get("Color");
                    if (!(llIIllIlllIlI instanceof IntTag)) {
                        continue;
                    }
                    ((IntTag)llIIllIlllIlI).setValue(15 - (int)llIIllIlllIlI.getValue());
                }
            }
        }
        final Tag llIIllIIllllI = llIIllIlIIlII.get("CustomName");
        if (llIIllIIllllI instanceof StringTag) {
            ((StringTag)llIIllIIllllI).setValue(ChatRewriter.legacyTextToJsonString(((StringTag)llIIllIIllllI).getValue()));
        }
        return llIIllIlIIIIl;
    }
}
