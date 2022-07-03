package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import com.google.gson.*;
import net.minecraft.util.text.*;
import net.minecraft.util.*;

public class PackMetadataSectionSerializer extends BaseMetadataSectionSerializer<PackMetadataSection> implements JsonSerializer<PackMetadataSection>
{
    public JsonElement serialize(final PackMetadataSection lllllllllllllllIIIIllIIIIIIllIIl, final Type lllllllllllllllIIIIllIIIIIIllIII, final JsonSerializationContext lllllllllllllllIIIIllIIIIIIlIlII) {
        final JsonObject lllllllllllllllIIIIllIIIIIIlIllI = new JsonObject();
        lllllllllllllllIIIIllIIIIIIlIllI.addProperty("pack_format", (Number)lllllllllllllllIIIIllIIIIIIllIIl.getPackFormat());
        lllllllllllllllIIIIllIIIIIIlIllI.add("description", lllllllllllllllIIIIllIIIIIIlIlII.serialize((Object)lllllllllllllllIIIIllIIIIIIllIIl.getPackDescription()));
        return (JsonElement)lllllllllllllllIIIIllIIIIIIlIllI;
    }
    
    public PackMetadataSection deserialize(final JsonElement lllllllllllllllIIIIllIIIIIlIIIlI, final Type lllllllllllllllIIIIllIIIIIlIIlll, final JsonDeserializationContext lllllllllllllllIIIIllIIIIIlIIllI) throws JsonParseException {
        final JsonObject lllllllllllllllIIIIllIIIIIlIIlIl = lllllllllllllllIIIIllIIIIIlIIIlI.getAsJsonObject();
        final ITextComponent lllllllllllllllIIIIllIIIIIlIIlII = (ITextComponent)lllllllllllllllIIIIllIIIIIlIIllI.deserialize(lllllllllllllllIIIIllIIIIIlIIlIl.get("description"), (Type)ITextComponent.class);
        if (lllllllllllllllIIIIllIIIIIlIIlII == null) {
            throw new JsonParseException("Invalid/missing description!");
        }
        final int lllllllllllllllIIIIllIIIIIlIIIll = JsonUtils.getInt(lllllllllllllllIIIIllIIIIIlIIlIl, "pack_format");
        return new PackMetadataSection(lllllllllllllllIIIIllIIIIIlIIlII, lllllllllllllllIIIIllIIIIIlIIIll);
    }
    
    public String getSectionName() {
        return "pack";
    }
}
