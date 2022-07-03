package net.minecraft.client.renderer.block.model;

import org.lwjgl.util.vector.*;
import java.lang.reflect.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class ItemTransformVec3f
{
    public final /* synthetic */ Vector3f rotation;
    public final /* synthetic */ Vector3f translation;
    public final /* synthetic */ Vector3f scale;
    
    @Override
    public boolean equals(final Object llllllllllllllIIllIlIIllllIlIIII) {
        if (this == llllllllllllllIIllIlIIllllIlIIII) {
            return true;
        }
        if (this.getClass() != llllllllllllllIIllIlIIllllIlIIII.getClass()) {
            return false;
        }
        final ItemTransformVec3f llllllllllllllIIllIlIIllllIIllll = (ItemTransformVec3f)llllllllllllllIIllIlIIllllIlIIII;
        return this.rotation.equals((Object)llllllllllllllIIllIlIIllllIIllll.rotation) && this.scale.equals((Object)llllllllllllllIIllIlIIllllIIllll.scale) && this.translation.equals((Object)llllllllllllllIIllIlIIllllIIllll.translation);
    }
    
    static {
        DEFAULT = new ItemTransformVec3f(new Vector3f(), new Vector3f(), new Vector3f(1.0f, 1.0f, 1.0f));
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIIllIlIIllllIIlIII = this.rotation.hashCode();
        llllllllllllllIIllIlIIllllIIlIII = 31 * llllllllllllllIIllIlIIllllIIlIII + this.translation.hashCode();
        llllllllllllllIIllIlIIllllIIlIII = 31 * llllllllllllllIIllIlIIllllIIlIII + this.scale.hashCode();
        return llllllllllllllIIllIlIIllllIIlIII;
    }
    
    public ItemTransformVec3f(final Vector3f llllllllllllllIIllIlIIllllIlIlll, final Vector3f llllllllllllllIIllIlIIllllIllIlI, final Vector3f llllllllllllllIIllIlIIllllIllIIl) {
        this.rotation = new Vector3f((ReadableVector3f)llllllllllllllIIllIlIIllllIlIlll);
        this.translation = new Vector3f((ReadableVector3f)llllllllllllllIIllIlIIllllIllIlI);
        this.scale = new Vector3f((ReadableVector3f)llllllllllllllIIllIlIIllllIllIIl);
    }
    
    static class Deserializer implements JsonDeserializer<ItemTransformVec3f>
    {
        private static final /* synthetic */ Vector3f SCALE_DEFAULT;
        private static final /* synthetic */ Vector3f ROTATION_DEFAULT;
        private static final /* synthetic */ Vector3f TRANSLATION_DEFAULT;
        
        public ItemTransformVec3f deserialize(final JsonElement llllllllllllllIIlIlIIllIlIIIIlIl, final Type llllllllllllllIIlIlIIllIlIIIllII, final JsonDeserializationContext llllllllllllllIIlIlIIllIlIIIlIll) throws JsonParseException {
            final JsonObject llllllllllllllIIlIlIIllIlIIIlIlI = llllllllllllllIIlIlIIllIlIIIIlIl.getAsJsonObject();
            final Vector3f llllllllllllllIIlIlIIllIlIIIlIIl = this.parseVector3f(llllllllllllllIIlIlIIllIlIIIlIlI, "rotation", Deserializer.ROTATION_DEFAULT);
            final Vector3f llllllllllllllIIlIlIIllIlIIIlIII = this.parseVector3f(llllllllllllllIIlIlIIllIlIIIlIlI, "translation", Deserializer.TRANSLATION_DEFAULT);
            llllllllllllllIIlIlIIllIlIIIlIII.scale(0.0625f);
            llllllllllllllIIlIlIIllIlIIIlIII.x = MathHelper.clamp(llllllllllllllIIlIlIIllIlIIIlIII.x, -5.0f, 5.0f);
            llllllllllllllIIlIlIIllIlIIIlIII.y = MathHelper.clamp(llllllllllllllIIlIlIIllIlIIIlIII.y, -5.0f, 5.0f);
            llllllllllllllIIlIlIIllIlIIIlIII.z = MathHelper.clamp(llllllllllllllIIlIlIIllIlIIIlIII.z, -5.0f, 5.0f);
            final Vector3f llllllllllllllIIlIlIIllIlIIIIlll = this.parseVector3f(llllllllllllllIIlIlIIllIlIIIlIlI, "scale", Deserializer.SCALE_DEFAULT);
            llllllllllllllIIlIlIIllIlIIIIlll.x = MathHelper.clamp(llllllllllllllIIlIlIIllIlIIIIlll.x, -4.0f, 4.0f);
            llllllllllllllIIlIlIIllIlIIIIlll.y = MathHelper.clamp(llllllllllllllIIlIlIIllIlIIIIlll.y, -4.0f, 4.0f);
            llllllllllllllIIlIlIIllIlIIIIlll.z = MathHelper.clamp(llllllllllllllIIlIlIIllIlIIIIlll.z, -4.0f, 4.0f);
            return new ItemTransformVec3f(llllllllllllllIIlIlIIllIlIIIlIIl, llllllllllllllIIlIlIIllIlIIIlIII, llllllllllllllIIlIlIIllIlIIIIlll);
        }
        
        private Vector3f parseVector3f(final JsonObject llllllllllllllIIlIlIIllIIlllIIll, final String llllllllllllllIIlIlIIllIIlllIIlI, final Vector3f llllllllllllllIIlIlIIllIIlllIlll) {
            if (!llllllllllllllIIlIlIIllIIlllIIll.has(llllllllllllllIIlIlIIllIIlllIIlI)) {
                return llllllllllllllIIlIlIIllIIlllIlll;
            }
            final JsonArray llllllllllllllIIlIlIIllIIlllIllI = JsonUtils.getJsonArray(llllllllllllllIIlIlIIllIIlllIIll, llllllllllllllIIlIlIIllIIlllIIlI);
            if (llllllllllllllIIlIlIIllIIlllIllI.size() != 3) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Expected 3 ").append(llllllllllllllIIlIlIIllIIlllIIlI).append(" values, found: ").append(llllllllllllllIIlIlIIllIIlllIllI.size())));
            }
            final float[] llllllllllllllIIlIlIIllIIlllIlIl = new float[3];
            for (int llllllllllllllIIlIlIIllIIlllIlII = 0; llllllllllllllIIlIlIIllIIlllIlII < llllllllllllllIIlIlIIllIIlllIlIl.length; ++llllllllllllllIIlIlIIllIIlllIlII) {
                llllllllllllllIIlIlIIllIIlllIlIl[llllllllllllllIIlIlIIllIIlllIlII] = JsonUtils.getFloat(llllllllllllllIIlIlIIllIIlllIllI.get(llllllllllllllIIlIlIIllIIlllIlII), String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIlIIllIIlllIIlI)).append("[").append(llllllllllllllIIlIlIIllIIlllIlII).append("]")));
            }
            return new Vector3f(llllllllllllllIIlIlIIllIIlllIlIl[0], llllllllllllllIIlIlIIllIIlllIlIl[1], llllllllllllllIIlIlIIllIIlllIlIl[2]);
        }
        
        static {
            ROTATION_DEFAULT = new Vector3f(0.0f, 0.0f, 0.0f);
            TRANSLATION_DEFAULT = new Vector3f(0.0f, 0.0f, 0.0f);
            SCALE_DEFAULT = new Vector3f(1.0f, 1.0f, 1.0f);
        }
    }
}
