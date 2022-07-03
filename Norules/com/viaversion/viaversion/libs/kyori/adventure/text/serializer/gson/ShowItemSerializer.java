package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.nbt.api.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;

final class ShowItemSerializer implements JsonDeserializer<HoverEvent.ShowItem>, JsonSerializer<HoverEvent.ShowItem>
{
    @Override
    public JsonElement serialize(final HoverEvent.ShowItem llllllllllllllllIIIlllIIlllIIlll, final Type llllllllllllllllIIIlllIIlllIIllI, final JsonSerializationContext llllllllllllllllIIIlllIIlllIlIII) {
        final JsonObject llllllllllllllllIIIlllIIlllIIIIl = new JsonObject();
        llllllllllllllllIIIlllIIlllIIIIl.add("id", llllllllllllllllIIIlllIIlllIlIII.serialize(llllllllllllllllIIIlllIIlllIIlll.item()));
        final int llllllllllllllllIIIlllIIlllIIIII = llllllllllllllllIIIlllIIlllIIlll.count();
        if (llllllllllllllllIIIlllIIlllIIIII != 1) {
            llllllllllllllllIIIlllIIlllIIIIl.addProperty("count", llllllllllllllllIIIlllIIlllIIIII);
        }
        final BinaryTagHolder llllllllllllllllIIIlllIIllIlllll = llllllllllllllllIIIlllIIlllIIlll.nbt();
        if (llllllllllllllllIIIlllIIllIlllll != null) {
            llllllllllllllllIIIlllIIlllIIIIl.addProperty("tag", llllllllllllllllIIIlllIIllIlllll.string());
        }
        return llllllllllllllllIIIlllIIlllIIIIl;
    }
    
    static {
        ID = "id";
        COUNT = "count";
        TAG = "tag";
    }
    
    @Override
    public HoverEvent.ShowItem deserialize(final JsonElement llllllllllllllllIIIlllIIllllllll, final Type llllllllllllllllIIIlllIlIIIIIIII, final JsonDeserializationContext llllllllllllllllIIIlllIIlllllllI) throws JsonParseException {
        final JsonObject llllllllllllllllIIIlllIIlllllIII = llllllllllllllllIIIlllIIllllllll.getAsJsonObject();
        if (!llllllllllllllllIIIlllIIlllllIII.has("id")) {
            throw new JsonParseException("Not sure how to deserialize show_item hover event");
        }
        final Key llllllllllllllllIIIlllIIllllIlll = llllllllllllllllIIIlllIIlllllllI.deserialize(llllllllllllllllIIIlllIIlllllIII.getAsJsonPrimitive("id"), Key.class);
        int llllllllllllllllIIIlllIIllllIllI = 1;
        if (llllllllllllllllIIIlllIIlllllIII.has("count")) {
            llllllllllllllllIIIlllIIllllIllI = llllllllllllllllIIIlllIIlllllIII.get("count").getAsInt();
        }
        BinaryTagHolder llllllllllllllllIIIlllIIllllIlIl = null;
        if (llllllllllllllllIIIlllIIlllllIII.has("tag")) {
            final JsonElement llllllllllllllllIIIlllIIllllllIl = llllllllllllllllIIIlllIIlllllIII.get("tag");
            if (llllllllllllllllIIIlllIIllllllIl.isJsonPrimitive()) {
                llllllllllllllllIIIlllIIllllIlIl = BinaryTagHolder.of(llllllllllllllllIIIlllIIllllllIl.getAsString());
            }
            else if (!llllllllllllllllIIIlllIIllllllIl.isJsonNull()) {
                throw new JsonParseException("Expected tag to be a string");
            }
        }
        return HoverEvent.ShowItem.of(llllllllllllllllIIIlllIIllllIlll, llllllllllllllllIIIlllIIllllIllI, llllllllllllllllIIIlllIIllllIlIl);
    }
}
