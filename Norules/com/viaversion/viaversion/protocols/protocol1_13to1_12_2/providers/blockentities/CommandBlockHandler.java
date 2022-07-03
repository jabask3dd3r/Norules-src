package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.gson.*;

public class CommandBlockHandler implements BlockEntityProvider.BlockEntityHandler
{
    @Override
    public int transform(final UserConnection lllllllllllllIIIlllllIIIIIlIlIII, final CompoundTag lllllllllllllIIIlllllIIIIIlIIlII) {
        final Tag lllllllllllllIIIlllllIIIIIlIIllI = lllllllllllllIIIlllllIIIIIlIIlII.get("CustomName");
        if (lllllllllllllIIIlllllIIIIIlIIllI instanceof StringTag) {
            ((StringTag)lllllllllllllIIIlllllIIIIIlIIllI).setValue(ChatRewriter.legacyTextToJsonString(((StringTag)lllllllllllllIIIlllllIIIIIlIIllI).getValue()));
        }
        final Tag lllllllllllllIIIlllllIIIIIlIIlIl = lllllllllllllIIIlllllIIIIIlIIlII.get("LastOutput");
        if (lllllllllllllIIIlllllIIIIIlIIlIl instanceof StringTag) {
            final JsonElement lllllllllllllIIIlllllIIIIIlIlIlI = JsonParser.parseString(((StringTag)lllllllllllllIIIlllllIIIIIlIIlIl).getValue());
            ChatRewriter.processTranslate(lllllllllllllIIIlllllIIIIIlIlIlI);
            ((StringTag)lllllllllllllIIIlllllIIIIIlIIlIl).setValue(lllllllllllllIIIlllllIIIIIlIlIlI.toString());
        }
        return -1;
    }
}
