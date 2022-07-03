package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.gson.*;

final class ShowEntitySerializer implements JsonDeserializer<HoverEvent.ShowEntity>, JsonSerializer<HoverEvent.ShowEntity>
{
    @Override
    public HoverEvent.ShowEntity deserialize(final JsonElement llllllllllllllIIllIIIIIlIlIIIIll, final Type llllllllllllllIIllIIIIIlIlIIIIlI, final JsonDeserializationContext llllllllllllllIIllIIIIIlIlIIIlII) throws JsonParseException {
        final JsonObject llllllllllllllIIllIIIIIlIIllllIl = llllllllllllllIIllIIIIIlIlIIIIll.getAsJsonObject();
        if (!llllllllllllllIIllIIIIIlIIllllIl.has("type") || !llllllllllllllIIllIIIIIlIIllllIl.has("id")) {
            throw new JsonParseException("A show entity hover event needs type and id fields to be deserialized");
        }
        final Key llllllllllllllIIllIIIIIlIIllllII = llllllllllllllIIllIIIIIlIlIIIlII.deserialize(llllllllllllllIIllIIIIIlIIllllIl.getAsJsonPrimitive("type"), Key.class);
        final UUID llllllllllllllIIllIIIIIlIIlllIll = UUID.fromString(llllllllllllllIIllIIIIIlIIllllIl.getAsJsonPrimitive("id").getAsString());
        Component llllllllllllllIIllIIIIIlIIlllIlI = null;
        if (llllllllllllllIIllIIIIIlIIllllIl.has("name")) {
            llllllllllllllIIllIIIIIlIIlllIlI = llllllllllllllIIllIIIIIlIlIIIlII.deserialize(llllllllllllllIIllIIIIIlIIllllIl.get("name"), Component.class);
        }
        return HoverEvent.ShowEntity.of(llllllllllllllIIllIIIIIlIIllllII, llllllllllllllIIllIIIIIlIIlllIll, llllllllllllllIIllIIIIIlIIlllIlI);
    }
    
    @Override
    public JsonElement serialize(final HoverEvent.ShowEntity llllllllllllllIIllIIIIIlIIlIllll, final Type llllllllllllllIIllIIIIIlIIlIlllI, final JsonSerializationContext llllllllllllllIIllIIIIIlIIlIllIl) {
        final JsonObject llllllllllllllIIllIIIIIlIIlIlIII = new JsonObject();
        llllllllllllllIIllIIIIIlIIlIlIII.add("type", llllllllllllllIIllIIIIIlIIlIllIl.serialize(llllllllllllllIIllIIIIIlIIlIllll.type()));
        llllllllllllllIIllIIIIIlIIlIlIII.addProperty("id", llllllllllllllIIllIIIIIlIIlIllll.id().toString());
        final Component llllllllllllllIIllIIIIIlIIlIIlll = llllllllllllllIIllIIIIIlIIlIllll.name();
        if (llllllllllllllIIllIIIIIlIIlIIlll != null) {
            llllllllllllllIIllIIIIIlIIlIlIII.add("name", llllllllllllllIIllIIIIIlIIlIllIl.serialize(llllllllllllllIIllIIIIIlIIlIIlll));
        }
        return llllllllllllllIIllIIIIIlIIlIlIII;
    }
    
    static {
        TYPE = "type";
        NAME = "name";
        ID = "id";
    }
}
