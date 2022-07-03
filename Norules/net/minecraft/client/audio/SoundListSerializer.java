package net.minecraft.client.audio;

import java.lang.reflect.*;
import net.minecraft.util.*;
import java.util.*;
import org.apache.commons.lang3.*;
import com.google.common.collect.*;
import com.google.gson.*;

public class SoundListSerializer implements JsonDeserializer<SoundList>
{
    public SoundList deserialize(final JsonElement lllllllllllllllIlIlIlllIIIIlIlll, final Type lllllllllllllllIlIlIlllIIIIlIlIl, final JsonDeserializationContext lllllllllllllllIlIlIlllIIIIlIIll) throws JsonParseException {
        final JsonObject lllllllllllllllIlIlIlllIIIIlIIIl = JsonUtils.getJsonObject(lllllllllllllllIlIlIlllIIIIlIlll, "entry");
        final boolean lllllllllllllllIlIlIlllIIIIIllll = JsonUtils.getBoolean(lllllllllllllllIlIlIlllIIIIlIIIl, "replace", false);
        final String lllllllllllllllIlIlIlllIIIIIlllI = JsonUtils.getString(lllllllllllllllIlIlIlllIIIIlIIIl, "subtitle", null);
        final List<Sound> lllllllllllllllIlIlIlllIIIIIllII = this.deserializeSounds(lllllllllllllllIlIlIlllIIIIlIIIl);
        return new SoundList(lllllllllllllllIlIlIlllIIIIIllII, lllllllllllllllIlIlIlllIIIIIllll, lllllllllllllllIlIlIlllIIIIIlllI);
    }
    
    private Sound.Type deserializeType(final JsonObject lllllllllllllllIlIlIllIllIllIllI, final Sound.Type lllllllllllllllIlIlIllIllIllIlIl) {
        Sound.Type lllllllllllllllIlIlIllIllIllIlll = lllllllllllllllIlIlIllIllIllIlIl;
        if (lllllllllllllllIlIlIllIllIllIllI.has("type")) {
            lllllllllllllllIlIlIllIllIllIlll = Sound.Type.getByName(JsonUtils.getString(lllllllllllllllIlIlIllIllIllIllI, "type"));
            Validate.notNull((Object)lllllllllllllllIlIlIllIllIllIlll, "Invalid type", new Object[0]);
        }
        return lllllllllllllllIlIlIllIllIllIlll;
    }
    
    private Sound deserializeSound(final JsonObject lllllllllllllllIlIlIllIlllIIllII) {
        final String lllllllllllllllIlIlIllIlllIIlIll = JsonUtils.getString(lllllllllllllllIlIlIllIlllIIllII, "name");
        final Sound.Type lllllllllllllllIlIlIllIlllIIlIlI = this.deserializeType(lllllllllllllllIlIlIllIlllIIllII, Sound.Type.FILE);
        final float lllllllllllllllIlIlIllIlllIIlIIl = JsonUtils.getFloat(lllllllllllllllIlIlIllIlllIIllII, "volume", 1.0f);
        Validate.isTrue(lllllllllllllllIlIlIllIlllIIlIIl > 0.0f, "Invalid volume", new Object[0]);
        final float lllllllllllllllIlIlIllIlllIIlIII = JsonUtils.getFloat(lllllllllllllllIlIlIllIlllIIllII, "pitch", 1.0f);
        Validate.isTrue(lllllllllllllllIlIlIllIlllIIlIII > 0.0f, "Invalid pitch", new Object[0]);
        final int lllllllllllllllIlIlIllIlllIIIlll = JsonUtils.getInt(lllllllllllllllIlIlIllIlllIIllII, "weight", 1);
        Validate.isTrue(lllllllllllllllIlIlIllIlllIIIlll > 0, "Invalid weight", new Object[0]);
        final boolean lllllllllllllllIlIlIllIlllIIIllI = JsonUtils.getBoolean(lllllllllllllllIlIlIllIlllIIllII, "stream", false);
        return new Sound(lllllllllllllllIlIlIllIlllIIlIll, lllllllllllllllIlIlIllIlllIIlIIl, lllllllllllllllIlIlIllIlllIIlIII, lllllllllllllllIlIlIllIlllIIIlll, lllllllllllllllIlIlIllIlllIIlIlI, lllllllllllllllIlIlIllIlllIIIllI);
    }
    
    private List<Sound> deserializeSounds(final JsonObject lllllllllllllllIlIlIllIllllIIIIl) {
        final List<Sound> lllllllllllllllIlIlIllIllllIlIlI = (List<Sound>)Lists.newArrayList();
        if (lllllllllllllllIlIlIllIllllIIIIl.has("sounds")) {
            final JsonArray lllllllllllllllIlIlIllIllllIlIII = JsonUtils.getJsonArray(lllllllllllllllIlIlIllIllllIIIIl, "sounds");
            for (int lllllllllllllllIlIlIllIllllIIlll = 0; lllllllllllllllIlIlIllIllllIIlll < lllllllllllllllIlIlIllIllllIlIII.size(); ++lllllllllllllllIlIlIllIllllIIlll) {
                final JsonElement lllllllllllllllIlIlIllIllllIIllI = lllllllllllllllIlIlIllIllllIlIII.get(lllllllllllllllIlIlIllIllllIIlll);
                if (JsonUtils.isString(lllllllllllllllIlIlIllIllllIIllI)) {
                    final String lllllllllllllllIlIlIllIllllIIlII = JsonUtils.getString(lllllllllllllllIlIlIllIllllIIllI, "sound");
                    lllllllllllllllIlIlIllIllllIlIlI.add(new Sound(lllllllllllllllIlIlIllIllllIIlII, 1.0f, 1.0f, 1, Sound.Type.FILE, false));
                }
                else {
                    lllllllllllllllIlIlIllIllllIlIlI.add(this.deserializeSound(JsonUtils.getJsonObject(lllllllllllllllIlIlIllIllllIIllI, "sound")));
                }
            }
        }
        return lllllllllllllllIlIlIllIllllIlIlI;
    }
}
