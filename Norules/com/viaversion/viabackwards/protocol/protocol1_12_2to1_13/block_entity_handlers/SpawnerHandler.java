package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class SpawnerHandler implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler
{
    @Override
    public CompoundTag transform(final UserConnection lllllllllllllIlIIIlIIllIlIllIlII, final int lllllllllllllIlIIIlIIllIlIllIIll, final CompoundTag lllllllllllllIlIIIlIIllIlIllIIlI) {
        final Tag lllllllllllllIlIIIlIIllIlIllIIIl = lllllllllllllIlIIIlIIllIlIllIIlI.get("SpawnData");
        if (lllllllllllllIlIIIlIIllIlIllIIIl instanceof CompoundTag) {
            final CompoundTag lllllllllllllIlIIIlIIllIlIllIlll = (CompoundTag)lllllllllllllIlIIIlIIllIlIllIIIl;
            final Tag lllllllllllllIlIIIlIIllIlIllIllI = lllllllllllllIlIIIlIIllIlIllIlll.get("id");
            if (lllllllllllllIlIIIlIIllIlIllIllI instanceof StringTag) {
                final StringTag lllllllllllllIlIIIlIIllIlIlllIII = (StringTag)lllllllllllllIlIIIlIIllIlIllIllI;
                lllllllllllllIlIIIlIIllIlIlllIII.setValue(EntityNameRewrites.rewrite(lllllllllllllIlIIIlIIllIlIlllIII.getValue()));
            }
        }
        return lllllllllllllIlIIIlIIllIlIllIIlI;
    }
}
