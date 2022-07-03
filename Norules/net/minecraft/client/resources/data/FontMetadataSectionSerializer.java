package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import com.google.gson.*;

public class FontMetadataSectionSerializer extends BaseMetadataSectionSerializer<FontMetadataSection>
{
    @Override
    public String getSectionName() {
        return "font";
    }
    
    public FontMetadataSection deserialize(final JsonElement lllllllllllllIIlllIlllllIIIIIlll, final Type lllllllllllllIIlllIlllllIIIIIllI, final JsonDeserializationContext lllllllllllllIIlllIlllllIIIIIlIl) throws JsonParseException {
        final JsonObject lllllllllllllIIlllIlllllIIIIIlII = lllllllllllllIIlllIlllllIIIIIlll.getAsJsonObject();
        final float[] lllllllllllllIIlllIlllllIIIIIIll = new float[256];
        final float[] lllllllllllllIIlllIlllllIIIIIIlI = new float[256];
        final float[] lllllllllllllIIlllIlllllIIIIIIIl = new float[256];
        float lllllllllllllIIlllIlllllIIIIIIII = 1.0f;
        float lllllllllllllIIlllIllllIllllllll = 0.0f;
        float lllllllllllllIIlllIllllIlllllllI = 0.0f;
        if (lllllllllllllIIlllIlllllIIIIIlII.has("characters")) {
            if (!lllllllllllllIIlllIlllllIIIIIlII.get("characters").isJsonObject()) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid font->characters: expected object, was ").append(lllllllllllllIIlllIlllllIIIIIlII.get("characters"))));
            }
            final JsonObject lllllllllllllIIlllIllllIllllllIl = lllllllllllllIIlllIlllllIIIIIlII.getAsJsonObject("characters");
            if (lllllllllllllIIlllIllllIllllllIl.has("default")) {
                if (!lllllllllllllIIlllIllllIllllllIl.get("default").isJsonObject()) {
                    throw new JsonParseException(String.valueOf(new StringBuilder("Invalid font->characters->default: expected object, was ").append(lllllllllllllIIlllIllllIllllllIl.get("default"))));
                }
                final JsonObject lllllllllllllIIlllIllllIllllllII = lllllllllllllIIlllIllllIllllllIl.getAsJsonObject("default");
                lllllllllllllIIlllIlllllIIIIIIII = JsonUtils.getFloat(lllllllllllllIIlllIllllIllllllII, "width", lllllllllllllIIlllIlllllIIIIIIII);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)lllllllllllllIIlllIlllllIIIIIIII, "Invalid default width");
                lllllllllllllIIlllIllllIllllllll = JsonUtils.getFloat(lllllllllllllIIlllIllllIllllllII, "spacing", lllllllllllllIIlllIllllIllllllll);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)lllllllllllllIIlllIllllIllllllll, "Invalid default spacing");
                lllllllllllllIIlllIllllIlllllllI = JsonUtils.getFloat(lllllllllllllIIlllIllllIllllllII, "left", lllllllllllllIIlllIllllIllllllll);
                Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)lllllllllllllIIlllIllllIlllllllI, "Invalid default left");
            }
            for (int lllllllllllllIIlllIllllIlllllIll = 0; lllllllllllllIIlllIllllIlllllIll < 256; ++lllllllllllllIIlllIllllIlllllIll) {
                final JsonElement lllllllllllllIIlllIllllIlllllIlI = lllllllllllllIIlllIllllIllllllIl.get(Integer.toString(lllllllllllllIIlllIllllIlllllIll));
                float lllllllllllllIIlllIllllIlllllIIl = lllllllllllllIIlllIlllllIIIIIIII;
                float lllllllllllllIIlllIllllIlllllIII = lllllllllllllIIlllIllllIllllllll;
                float lllllllllllllIIlllIllllIllllIlll = lllllllllllllIIlllIllllIlllllllI;
                if (lllllllllllllIIlllIllllIlllllIlI != null) {
                    final JsonObject lllllllllllllIIlllIllllIllllIllI = JsonUtils.getJsonObject(lllllllllllllIIlllIllllIlllllIlI, String.valueOf(new StringBuilder("characters[").append(lllllllllllllIIlllIllllIlllllIll).append("]")));
                    lllllllllllllIIlllIllllIlllllIIl = JsonUtils.getFloat(lllllllllllllIIlllIllllIllllIllI, "width", lllllllllllllIIlllIlllllIIIIIIII);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)lllllllllllllIIlllIllllIlllllIIl, "Invalid width");
                    lllllllllllllIIlllIllllIlllllIII = JsonUtils.getFloat(lllllllllllllIIlllIllllIllllIllI, "spacing", lllllllllllllIIlllIllllIllllllll);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)lllllllllllllIIlllIllllIlllllIII, "Invalid spacing");
                    lllllllllllllIIlllIllllIllllIlll = JsonUtils.getFloat(lllllllllllllIIlllIllllIllllIllI, "left", lllllllllllllIIlllIllllIlllllllI);
                    Validate.inclusiveBetween(0.0, 3.4028234663852886E38, (double)lllllllllllllIIlllIllllIllllIlll, "Invalid left");
                }
                lllllllllllllIIlllIlllllIIIIIIll[lllllllllllllIIlllIllllIlllllIll] = lllllllllllllIIlllIllllIlllllIIl;
                lllllllllllllIIlllIlllllIIIIIIlI[lllllllllllllIIlllIllllIlllllIll] = lllllllllllllIIlllIllllIlllllIII;
                lllllllllllllIIlllIlllllIIIIIIIl[lllllllllllllIIlllIllllIlllllIll] = lllllllllllllIIlllIllllIllllIlll;
            }
        }
        return new FontMetadataSection(lllllllllllllIIlllIlllllIIIIIIll, lllllllllllllIIlllIlllllIIIIIIIl, lllllllllllllIIlllIlllllIIIIIIlI);
    }
}
