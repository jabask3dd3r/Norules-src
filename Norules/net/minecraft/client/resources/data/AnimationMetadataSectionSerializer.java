package net.minecraft.client.resources.data;

import java.lang.reflect.*;
import com.google.gson.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import java.util.*;

public class AnimationMetadataSectionSerializer extends BaseMetadataSectionSerializer<AnimationMetadataSection> implements JsonSerializer<AnimationMetadataSection>
{
    public JsonElement serialize(final AnimationMetadataSection lllllllllllllIIllllIllIlIlllllll, final Type lllllllllllllIIllllIllIlIllllllI, final JsonSerializationContext lllllllllllllIIllllIllIlIlllllIl) {
        final JsonObject lllllllllllllIIllllIllIlIlllllII = new JsonObject();
        lllllllllllllIIllllIllIlIlllllII.addProperty("frametime", (Number)lllllllllllllIIllllIllIlIlllllll.getFrameTime());
        if (lllllllllllllIIllllIllIlIlllllll.getFrameWidth() != -1) {
            lllllllllllllIIllllIllIlIlllllII.addProperty("width", (Number)lllllllllllllIIllllIllIlIlllllll.getFrameWidth());
        }
        if (lllllllllllllIIllllIllIlIlllllll.getFrameHeight() != -1) {
            lllllllllllllIIllllIllIlIlllllII.addProperty("height", (Number)lllllllllllllIIllllIllIlIlllllll.getFrameHeight());
        }
        if (lllllllllllllIIllllIllIlIlllllll.getFrameCount() > 0) {
            final JsonArray lllllllllllllIIllllIllIlIllllIll = new JsonArray();
            for (int lllllllllllllIIllllIllIlIllllIlI = 0; lllllllllllllIIllllIllIlIllllIlI < lllllllllllllIIllllIllIlIlllllll.getFrameCount(); ++lllllllllllllIIllllIllIlIllllIlI) {
                if (lllllllllllllIIllllIllIlIlllllll.frameHasTime(lllllllllllllIIllllIllIlIllllIlI)) {
                    final JsonObject lllllllllllllIIllllIllIlIllllIIl = new JsonObject();
                    lllllllllllllIIllllIllIlIllllIIl.addProperty("index", (Number)lllllllllllllIIllllIllIlIlllllll.getFrameIndex(lllllllllllllIIllllIllIlIllllIlI));
                    lllllllllllllIIllllIllIlIllllIIl.addProperty("time", (Number)lllllllllllllIIllllIllIlIlllllll.getFrameTimeSingle(lllllllllllllIIllllIllIlIllllIlI));
                    lllllllllllllIIllllIllIlIllllIll.add((JsonElement)lllllllllllllIIllllIllIlIllllIIl);
                }
                else {
                    lllllllllllllIIllllIllIlIllllIll.add((JsonElement)new JsonPrimitive((Number)lllllllllllllIIllllIllIlIlllllll.getFrameIndex(lllllllllllllIIllllIllIlIllllIlI)));
                }
            }
            lllllllllllllIIllllIllIlIlllllII.add("frames", (JsonElement)lllllllllllllIIllllIllIlIllllIll);
        }
        return (JsonElement)lllllllllllllIIllllIllIlIlllllII;
    }
    
    public AnimationMetadataSection deserialize(final JsonElement lllllllllllllIIllllIllIllIlIllII, final Type lllllllllllllIIllllIllIllIlIlIll, final JsonDeserializationContext lllllllllllllIIllllIllIllIlIlIlI) throws JsonParseException {
        final List<AnimationFrame> lllllllllllllIIllllIllIllIlIlIIl = (List<AnimationFrame>)Lists.newArrayList();
        final JsonObject lllllllllllllIIllllIllIllIlIlIII = JsonUtils.getJsonObject(lllllllllllllIIllllIllIllIlIllII, "metadata section");
        final int lllllllllllllIIllllIllIllIlIIlll = JsonUtils.getInt(lllllllllllllIIllllIllIllIlIlIII, "frametime", 1);
        if (lllllllllllllIIllllIllIllIlIIlll != 1) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)lllllllllllllIIllllIllIllIlIIlll, "Invalid default frame time");
        }
        if (lllllllllllllIIllllIllIllIlIlIII.has("frames")) {
            try {
                final JsonArray lllllllllllllIIllllIllIllIlIIllI = JsonUtils.getJsonArray(lllllllllllllIIllllIllIllIlIlIII, "frames");
                for (int lllllllllllllIIllllIllIllIlIIlIl = 0; lllllllllllllIIllllIllIllIlIIlIl < lllllllllllllIIllllIllIllIlIIllI.size(); ++lllllllllllllIIllllIllIllIlIIlIl) {
                    final JsonElement lllllllllllllIIllllIllIllIlIIlII = lllllllllllllIIllllIllIllIlIIllI.get(lllllllllllllIIllllIllIllIlIIlIl);
                    final AnimationFrame lllllllllllllIIllllIllIllIlIIIll = this.parseAnimationFrame(lllllllllllllIIllllIllIllIlIIlIl, lllllllllllllIIllllIllIllIlIIlII);
                    if (lllllllllllllIIllllIllIllIlIIIll != null) {
                        lllllllllllllIIllllIllIllIlIlIIl.add(lllllllllllllIIllllIllIllIlIIIll);
                    }
                }
            }
            catch (ClassCastException lllllllllllllIIllllIllIllIlIIIlI) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid animation->frames: expected array, was ").append(lllllllllllllIIllllIllIllIlIlIII.get("frames"))), (Throwable)lllllllllllllIIllllIllIllIlIIIlI);
            }
        }
        final int lllllllllllllIIllllIllIllIlIIIIl = JsonUtils.getInt(lllllllllllllIIllllIllIllIlIlIII, "width", -1);
        final int lllllllllllllIIllllIllIllIlIIIII = JsonUtils.getInt(lllllllllllllIIllllIllIllIlIlIII, "height", -1);
        if (lllllllllllllIIllllIllIllIlIIIIl != -1) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)lllllllllllllIIllllIllIllIlIIIIl, "Invalid width");
        }
        if (lllllllllllllIIllllIllIllIlIIIII != -1) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)lllllllllllllIIllllIllIllIlIIIII, "Invalid height");
        }
        final boolean lllllllllllllIIllllIllIllIIlllll = JsonUtils.getBoolean(lllllllllllllIIllllIllIllIlIlIII, "interpolate", false);
        return new AnimationMetadataSection(lllllllllllllIIllllIllIllIlIlIIl, lllllllllllllIIllllIllIllIlIIIIl, lllllllllllllIIllllIllIllIlIIIII, lllllllllllllIIllllIllIllIlIIlll, lllllllllllllIIllllIllIllIIlllll);
    }
    
    private AnimationFrame parseAnimationFrame(final int lllllllllllllIIllllIllIllIIIlIlI, final JsonElement lllllllllllllIIllllIllIllIIIlIIl) {
        if (lllllllllllllIIllllIllIllIIIlIIl.isJsonPrimitive()) {
            return new AnimationFrame(JsonUtils.getInt(lllllllllllllIIllllIllIllIIIlIIl, String.valueOf(new StringBuilder("frames[").append(lllllllllllllIIllllIllIllIIIlIlI).append("]"))));
        }
        if (lllllllllllllIIllllIllIllIIIlIIl.isJsonObject()) {
            final JsonObject lllllllllllllIIllllIllIllIIIllIl = JsonUtils.getJsonObject(lllllllllllllIIllllIllIllIIIlIIl, String.valueOf(new StringBuilder("frames[").append(lllllllllllllIIllllIllIllIIIlIlI).append("]")));
            final int lllllllllllllIIllllIllIllIIIllII = JsonUtils.getInt(lllllllllllllIIllllIllIllIIIllIl, "time", -1);
            if (lllllllllllllIIllllIllIllIIIllIl.has("time")) {
                Validate.inclusiveBetween(1L, 2147483647L, (long)lllllllllllllIIllllIllIllIIIllII, "Invalid frame time");
            }
            final int lllllllllllllIIllllIllIllIIIlIll = JsonUtils.getInt(lllllllllllllIIllllIllIllIIIllIl, "index");
            Validate.inclusiveBetween(0L, 2147483647L, (long)lllllllllllllIIllllIllIllIIIlIll, "Invalid frame index");
            return new AnimationFrame(lllllllllllllIIllllIllIllIIIlIll, lllllllllllllIIllllIllIllIIIllII);
        }
        return null;
    }
    
    public String getSectionName() {
        return "animation";
    }
}
