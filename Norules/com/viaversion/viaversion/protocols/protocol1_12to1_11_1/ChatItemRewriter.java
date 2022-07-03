package com.viaversion.viaversion.protocols.protocol1_12to1_11_1;

import java.util.regex.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.*;

public class ChatItemRewriter
{
    private static final /* synthetic */ Pattern indexRemoval;
    
    static {
        indexRemoval = Pattern.compile("(?<![\\w-.+])\\d+:(?=([^\"\\\\]*(\\\\.|\"([^\"\\\\]*\\\\.)*[^\"\\\\]*\"))*[^\"]*$)");
    }
    
    public static void toClient(final JsonElement lllllllllllllIlIlIIIllIllllIIIIl, final UserConnection lllllllllllllIlIlIIIllIllllIIIlI) {
        if (lllllllllllllIlIlIIIllIllllIIIIl instanceof JsonObject) {
            final JsonObject lllllllllllllIlIlIIIllIllllIIllI = (JsonObject)lllllllllllllIlIlIIIllIllllIIIIl;
            if (lllllllllllllIlIlIIIllIllllIIllI.has("hoverEvent")) {
                if (lllllllllllllIlIlIIIllIllllIIllI.get("hoverEvent") instanceof JsonObject) {
                    final JsonObject lllllllllllllIlIlIIIllIllllIIlll = (JsonObject)lllllllllllllIlIlIIIllIllllIIllI.get("hoverEvent");
                    if (lllllllllllllIlIlIIIllIllllIIlll.has("action") && lllllllllllllIlIlIIIllIllllIIlll.has("value")) {
                        final String lllllllllllllIlIlIIIllIllllIlIII = lllllllllllllIlIlIIIllIllllIIlll.get("action").getAsString();
                        if (lllllllllllllIlIlIIIllIllllIlIII.equals("show_item") || lllllllllllllIlIlIIIllIllllIlIII.equals("show_entity")) {
                            final JsonElement lllllllllllllIlIlIIIllIllllIlIIl = lllllllllllllIlIlIIIllIllllIIlll.get("value");
                            if (lllllllllllllIlIlIIIllIllllIlIIl.isJsonPrimitive() && lllllllllllllIlIlIIIllIllllIlIIl.getAsJsonPrimitive().isString()) {
                                final String lllllllllllllIlIlIIIllIllllIllIl = ChatItemRewriter.indexRemoval.matcher(lllllllllllllIlIlIIIllIllllIlIIl.getAsString()).replaceAll("");
                                lllllllllllllIlIlIIIllIllllIIlll.addProperty("value", lllllllllllllIlIlIIIllIllllIllIl);
                            }
                            else if (lllllllllllllIlIlIIIllIllllIlIIl.isJsonArray()) {
                                final JsonArray lllllllllllllIlIlIIIllIllllIlIlI = new JsonArray();
                                for (final JsonElement lllllllllllllIlIlIIIllIllllIlIll : lllllllllllllIlIlIIIllIllllIlIIl.getAsJsonArray()) {
                                    if (lllllllllllllIlIlIIIllIllllIlIll.isJsonPrimitive() && lllllllllllllIlIlIIIllIllllIlIll.getAsJsonPrimitive().isString()) {
                                        final String lllllllllllllIlIlIIIllIllllIllII = ChatItemRewriter.indexRemoval.matcher(lllllllllllllIlIlIIIllIllllIlIll.getAsString()).replaceAll("");
                                        lllllllllllllIlIlIIIllIllllIlIlI.add(new JsonPrimitive(lllllllllllllIlIlIIIllIllllIllII));
                                    }
                                }
                                lllllllllllllIlIlIIIllIllllIIlll.add("value", lllllllllllllIlIlIIIllIllllIlIlI);
                            }
                        }
                    }
                }
            }
            else if (lllllllllllllIlIlIIIllIllllIIllI.has("extra")) {
                toClient(lllllllllllllIlIlIIIllIllllIIllI.get("extra"), lllllllllllllIlIlIIIllIllllIIIlI);
            }
        }
        else if (lllllllllllllIlIlIIIllIllllIIIIl instanceof JsonArray) {
            final JsonArray lllllllllllllIlIlIIIllIllllIIlII = (JsonArray)lllllllllllllIlIlIIIllIllllIIIIl;
            for (final JsonElement lllllllllllllIlIlIIIllIllllIIlIl : lllllllllllllIlIlIIIllIllllIIlII) {
                toClient(lllllllllllllIlIlIIIllIllllIIlIl, lllllllllllllIlIlIIIllIllllIIIlI);
            }
        }
    }
}
