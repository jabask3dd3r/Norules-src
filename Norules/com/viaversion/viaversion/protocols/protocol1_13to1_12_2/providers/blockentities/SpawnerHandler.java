package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;

public class SpawnerHandler implements BlockEntityProvider.BlockEntityHandler
{
    @Override
    public int transform(final UserConnection llllllllllllllllIllllIllIlIllIII, final CompoundTag llllllllllllllllIllllIllIlIlIllI) {
        if (llllllllllllllllIllllIllIlIlIllI.contains("SpawnData") && llllllllllllllllIllllIllIlIlIllI.get("SpawnData") instanceof CompoundTag) {
            final CompoundTag llllllllllllllllIllllIllIlIllIlI = llllllllllllllllIllllIllIlIlIllI.get("SpawnData");
            if (llllllllllllllllIllllIllIlIllIlI.contains("id") && llllllllllllllllIllllIllIlIllIlI.get("id") instanceof StringTag) {
                final StringTag llllllllllllllllIllllIllIlIllIll = llllllllllllllllIllllIllIlIllIlI.get("id");
                llllllllllllllllIllllIllIlIllIll.setValue(EntityNameRewriter.rewrite(llllllllllllllllIllllIllIlIllIll.getValue()));
            }
        }
        return -1;
    }
}
