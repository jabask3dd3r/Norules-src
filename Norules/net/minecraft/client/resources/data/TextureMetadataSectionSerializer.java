package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class TextureMetadataSectionSerializer extends BaseMetadataSectionSerializer<TextureMetadataSection>
{
    public TextureMetadataSection deserialize(final JsonElement llllllllllllllIIIlIIIIIlIIIlIIlI, final Type llllllllllllllIIIlIIIIIlIIIlIlll, final JsonDeserializationContext llllllllllllllIIIlIIIIIlIIIlIllI) throws JsonParseException {
        final JsonObject llllllllllllllIIIlIIIIIlIIIlIlIl = llllllllllllllIIIlIIIIIlIIIlIIlI.getAsJsonObject();
        final boolean llllllllllllllIIIlIIIIIlIIIlIlII = JsonUtils.getBoolean(llllllllllllllIIIlIIIIIlIIIlIlIl, "blur", false);
        final boolean llllllllllllllIIIlIIIIIlIIIlIIll = JsonUtils.getBoolean(llllllllllllllIIIlIIIIIlIIIlIlIl, "clamp", false);
        return new TextureMetadataSection(llllllllllllllIIIlIIIIIlIIIlIlII, llllllllllllllIIIlIIIIIlIIIlIIll);
    }
    
    @Override
    public String getSectionName() {
        return "texture";
    }
}
