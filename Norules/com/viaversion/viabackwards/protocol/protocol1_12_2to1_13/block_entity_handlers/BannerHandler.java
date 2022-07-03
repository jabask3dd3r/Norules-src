package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class BannerHandler implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler
{
    static {
        WALL_BANNER_STOP = 7173;
        BANNER_STOP = 7109;
        WALL_BANNER_START = 7110;
        BANNER_START = 6854;
    }
    
    @Override
    public CompoundTag transform(final UserConnection llllllllllllllIlIIlIIIIIIlIIlIII, final int llllllllllllllIlIIlIIIIIIlIIIlll, final CompoundTag llllllllllllllIlIIlIIIIIIlIIIllI) {
        if (llllllllllllllIlIIlIIIIIIlIIIlll >= 6854 && llllllllllllllIlIIlIIIIIIlIIIlll <= 7109) {
            final int llllllllllllllIlIIlIIIIIIlIIllIl = llllllllllllllIlIIlIIIIIIlIIIlll - 6854 >> 4;
            llllllllllllllIlIIlIIIIIIlIIIllI.put("Base", new IntTag(15 - llllllllllllllIlIIlIIIIIIlIIllIl));
        }
        else if (llllllllllllllIlIIlIIIIIIlIIIlll >= 7110 && llllllllllllllIlIIlIIIIIIlIIIlll <= 7173) {
            final int llllllllllllllIlIIlIIIIIIlIIllII = llllllllllllllIlIIlIIIIIIlIIIlll - 7110 >> 2;
            llllllllllllllIlIIlIIIIIIlIIIllI.put("Base", new IntTag(15 - llllllllllllllIlIIlIIIIIIlIIllII));
        }
        else {
            ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Why does this block have the banner block entity? :(").append(llllllllllllllIlIIlIIIIIIlIIIllI)));
        }
        final Tag llllllllllllllIlIIlIIIIIIlIIIlIl = llllllllllllllIlIIlIIIIIIlIIIllI.get("Patterns");
        if (llllllllllllllIlIIlIIIIIIlIIIlIl instanceof ListTag) {
            for (final Tag llllllllllllllIlIIlIIIIIIlIIlIlI : (ListTag)llllllllllllllIlIIlIIIIIIlIIIlIl) {
                if (!(llllllllllllllIlIIlIIIIIIlIIlIlI instanceof CompoundTag)) {
                    continue;
                }
                final IntTag llllllllllllllIlIIlIIIIIIlIIlIll = ((CompoundTag)llllllllllllllIlIIlIIIIIIlIIlIlI).get("Color");
                llllllllllllllIlIIlIIIIIIlIIlIll.setValue(15 - llllllllllllllIlIIlIIIIIIlIIlIll.asInt());
            }
        }
        return llllllllllllllIlIIlIIIIIIlIIIllI;
    }
}
