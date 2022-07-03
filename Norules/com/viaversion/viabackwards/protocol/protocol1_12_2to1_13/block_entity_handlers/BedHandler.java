package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class BedHandler implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler
{
    @Override
    public CompoundTag transform(final UserConnection lllllllllllllIIlIIIIIIlIllIlllIl, final int lllllllllllllIIlIIIIIIlIllIlllII, final CompoundTag lllllllllllllIIlIIIIIIlIllIlIlll) {
        final int lllllllllllllIIlIIIIIIlIllIllIlI = lllllllllllllIIlIIIIIIlIllIlllII - 748;
        final int lllllllllllllIIlIIIIIIlIllIllIIl = lllllllllllllIIlIIIIIIlIllIllIlI >> 4;
        lllllllllllllIIlIIIIIIlIllIlIlll.put("color", new IntTag(lllllllllllllIIlIIIIIIlIllIllIIl));
        return lllllllllllllIIlIIIIIIlIllIlIlll;
    }
}
