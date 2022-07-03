package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import com.google.gson.*;
import java.util.*;

public class LanguageMetadataSectionSerializer extends BaseMetadataSectionSerializer<LanguageMetadataSection>
{
    @Override
    public String getSectionName() {
        return "language";
    }
    
    public LanguageMetadataSection deserialize(final JsonElement llllllllllllIllllllIIlIIIIIlIIII, final Type llllllllllllIllllllIIlIIIIIIllll, final JsonDeserializationContext llllllllllllIllllllIIlIIIIIIlllI) throws JsonParseException {
        final JsonObject llllllllllllIllllllIIlIIIIIIllIl = llllllllllllIllllllIIlIIIIIlIIII.getAsJsonObject();
        final Set<Language> llllllllllllIllllllIIlIIIIIIllII = (Set<Language>)Sets.newHashSet();
        for (final Map.Entry<String, JsonElement> llllllllllllIllllllIIlIIIIIIlIll : llllllllllllIllllllIIlIIIIIIllIl.entrySet()) {
            final String llllllllllllIllllllIIlIIIIIIlIlI = llllllllllllIllllllIIlIIIIIIlIll.getKey();
            if (llllllllllllIllllllIIlIIIIIIlIlI.length() > 16) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid language->'").append(llllllllllllIllllllIIlIIIIIIlIlI).append("': language code must not be more than ").append(16).append(" characters long")));
            }
            final JsonObject llllllllllllIllllllIIlIIIIIIlIIl = JsonUtils.getJsonObject(llllllllllllIllllllIIlIIIIIIlIll.getValue(), "language");
            final String llllllllllllIllllllIIlIIIIIIlIII = JsonUtils.getString(llllllllllllIllllllIIlIIIIIIlIIl, "region");
            final String llllllllllllIllllllIIlIIIIIIIlll = JsonUtils.getString(llllllllllllIllllllIIlIIIIIIlIIl, "name");
            final boolean llllllllllllIllllllIIlIIIIIIIllI = JsonUtils.getBoolean(llllllllllllIllllllIIlIIIIIIlIIl, "bidirectional", false);
            if (llllllllllllIllllllIIlIIIIIIlIII.isEmpty()) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid language->'").append(llllllllllllIllllllIIlIIIIIIlIlI).append("'->region: empty value")));
            }
            if (llllllllllllIllllllIIlIIIIIIIlll.isEmpty()) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid language->'").append(llllllllllllIllllllIIlIIIIIIlIlI).append("'->name: empty value")));
            }
            if (!llllllllllllIllllllIIlIIIIIIllII.add(new Language(llllllllllllIllllllIIlIIIIIIlIlI, llllllllllllIllllllIIlIIIIIIlIII, llllllllllllIllllllIIlIIIIIIIlll, llllllllllllIllllllIIlIIIIIIIllI))) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Duplicate language->'").append(llllllllllllIllllllIIlIIIIIIlIlI).append("' defined")));
            }
        }
        return new LanguageMetadataSection(llllllllllllIllllllIIlIIIIIIllII);
    }
}
