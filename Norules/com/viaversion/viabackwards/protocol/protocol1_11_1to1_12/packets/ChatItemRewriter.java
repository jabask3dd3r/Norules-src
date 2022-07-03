package com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.gson.*;

public class ChatItemRewriter
{
    public static void toClient(final JsonElement lllllllllllllIIlIlIIlllIlIIllIII, final UserConnection lllllllllllllIIlIlIIlllIlIIlIlll) {
        if (lllllllllllllIIlIlIIlllIlIIllIII instanceof JsonObject) {
            final JsonObject lllllllllllllIIlIlIIlllIlIIlllIl = (JsonObject)lllllllllllllIIlIlIIlllIlIIllIII;
            if (lllllllllllllIIlIlIIlllIlIIlllIl.has("hoverEvent")) {
                if (lllllllllllllIIlIlIIlllIlIIlllIl.get("hoverEvent") instanceof JsonObject) {
                    final JsonObject lllllllllllllIIlIlIIlllIlIIllllI = (JsonObject)lllllllllllllIIlIlIIlllIlIIlllIl.get("hoverEvent");
                    if (lllllllllllllIIlIlIIlllIlIIllllI.has("action") && lllllllllllllIIlIlIIlllIlIIllllI.has("value")) {
                        final String lllllllllllllIIlIlIIlllIlIIlllll = lllllllllllllIIlIlIIlllIlIIllllI.get("action").getAsString();
                        if (lllllllllllllIIlIlIIlllIlIIlllll.equals("show_item") || lllllllllllllIIlIlIIlllIlIIlllll.equals("show_entity")) {
                            final JsonElement lllllllllllllIIlIlIIlllIlIlIIIII = lllllllllllllIIlIlIIlllIlIIllllI.get("value");
                            if (lllllllllllllIIlIlIIlllIlIlIIIII.isJsonArray()) {
                                final JsonArray lllllllllllllIIlIlIIlllIlIlIIIlI = new JsonArray();
                                final int lllllllllllllIIlIlIIlllIlIlIIIIl = 0;
                                for (final JsonElement lllllllllllllIIlIlIIlllIlIlIIIll : lllllllllllllIIlIlIIlllIlIlIIIII.getAsJsonArray()) {
                                    if (lllllllllllllIIlIlIIlllIlIlIIIll.isJsonPrimitive() && lllllllllllllIIlIlIIlllIlIlIIIll.getAsJsonPrimitive().isString()) {
                                        final String lllllllllllllIIlIlIIlllIlIlIIlII = String.valueOf(new StringBuilder().append(lllllllllllllIIlIlIIlllIlIlIIIIl).append(":").append(lllllllllllllIIlIlIIlllIlIlIIIll.getAsString()));
                                        lllllllllllllIIlIlIIlllIlIlIIIlI.add(new JsonPrimitive(lllllllllllllIIlIlIIlllIlIlIIlII));
                                    }
                                }
                                lllllllllllllIIlIlIIlllIlIIllllI.add("value", lllllllllllllIIlIlIIlllIlIlIIIlI);
                            }
                        }
                    }
                }
            }
            else if (lllllllllllllIIlIlIIlllIlIIlllIl.has("extra")) {
                toClient(lllllllllllllIIlIlIIlllIlIIlllIl.get("extra"), lllllllllllllIIlIlIIlllIlIIlIlll);
            }
        }
        else if (lllllllllllllIIlIlIIlllIlIIllIII instanceof JsonArray) {
            final JsonArray lllllllllllllIIlIlIIlllIlIIllIll = (JsonArray)lllllllllllllIIlIlIIlllIlIIllIII;
            for (final JsonElement lllllllllllllIIlIlIIlllIlIIlllII : lllllllllllllIIlIlIIlllIlIIllIll) {
                toClient(lllllllllllllIIlIlIIlllIlIIlllII, lllllllllllllIIlIlIIlllIlIIlIlll);
            }
        }
    }
}
