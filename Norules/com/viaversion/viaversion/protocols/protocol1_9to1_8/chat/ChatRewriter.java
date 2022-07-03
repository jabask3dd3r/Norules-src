package com.viaversion.viaversion.protocols.protocol1_9to1_8.chat;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.libs.gson.*;

public class ChatRewriter
{
    public static void toClient(final JsonObject lllllllllllllllIIIlIllIIllIlllIl, final UserConnection lllllllllllllllIIIlIllIIllIllllI) {
        if (lllllllllllllllIIIlIllIIllIlllIl.get("translate") != null && lllllllllllllllIIIlIllIIllIlllIl.get("translate").getAsString().equals("gameMode.changed")) {
            final EntityTracker1_9 lllllllllllllllIIIlIllIIlllIIIll = lllllllllllllllIIIlIllIIllIllllI.getEntityTracker(Protocol1_9To1_8.class);
            final String lllllllllllllllIIIlIllIIlllIIIlI = lllllllllllllllIIIlIllIIlllIIIll.getGameMode().getText();
            final JsonObject lllllllllllllllIIIlIllIIlllIIIIl = new JsonObject();
            lllllllllllllllIIIlIllIIlllIIIIl.addProperty("text", lllllllllllllllIIIlIllIIlllIIIlI);
            lllllllllllllllIIIlIllIIlllIIIIl.addProperty("color", "gray");
            lllllllllllllllIIIlIllIIlllIIIIl.addProperty("italic", true);
            final JsonArray lllllllllllllllIIIlIllIIlllIIIII = new JsonArray();
            lllllllllllllllIIIlIllIIlllIIIII.add(lllllllllllllllIIIlIllIIlllIIIIl);
            lllllllllllllllIIIlIllIIllIlllIl.add("with", lllllllllllllllIIIlIllIIlllIIIII);
        }
    }
}
