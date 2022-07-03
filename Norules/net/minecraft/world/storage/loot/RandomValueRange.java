package net.minecraft.world.storage.loot;

import java.util.*;
import net.minecraft.util.math.*;
import java.lang.reflect.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class RandomValueRange
{
    private final /* synthetic */ float min;
    private final /* synthetic */ float max;
    
    public RandomValueRange(final float llllllllllllllIllIIllIIlIllIlIlI) {
        this.min = llllllllllllllIllIIllIIlIllIlIlI;
        this.max = llllllllllllllIllIIllIIlIllIlIlI;
    }
    
    public RandomValueRange(final float llllllllllllllIllIIllIIlIlllIlII, final float llllllllllllllIllIIllIIlIlllIIII) {
        this.min = llllllllllllllIllIIllIIlIlllIlII;
        this.max = llllllllllllllIllIIllIIlIlllIIII;
    }
    
    public float getMin() {
        return this.min;
    }
    
    public float generateFloat(final Random llllllllllllllIllIIllIIlIlIllIII) {
        return MathHelper.nextFloat(llllllllllllllIllIIllIIlIlIllIII, this.min, this.max);
    }
    
    public int generateInt(final Random llllllllllllllIllIIllIIlIlIllllI) {
        return MathHelper.getInt(llllllllllllllIllIIllIIlIlIllllI, MathHelper.floor(this.min), MathHelper.floor(this.max));
    }
    
    public float getMax() {
        return this.max;
    }
    
    public boolean isInRange(final int llllllllllllllIllIIllIIlIlIlIlII) {
        return llllllllllllllIllIIllIIlIlIlIlII <= this.max && llllllllllllllIllIIllIIlIlIlIlII >= this.min;
    }
    
    public static class Serializer implements JsonDeserializer<RandomValueRange>, JsonSerializer<RandomValueRange>
    {
        public JsonElement serialize(final RandomValueRange lllllllllllllIIIIlIIIIlIlIIIIllI, final Type lllllllllllllIIIIlIIIIlIlIIIlIIl, final JsonSerializationContext lllllllllllllIIIIlIIIIlIlIIIlIII) {
            if (lllllllllllllIIIIlIIIIlIlIIIIllI.min == lllllllllllllIIIIlIIIIlIlIIIIllI.max) {
                return (JsonElement)new JsonPrimitive((Number)lllllllllllllIIIIlIIIIlIlIIIIllI.min);
            }
            final JsonObject lllllllllllllIIIIlIIIIlIlIIIIlll = new JsonObject();
            lllllllllllllIIIIlIIIIlIlIIIIlll.addProperty("min", (Number)lllllllllllllIIIIlIIIIlIlIIIIllI.min);
            lllllllllllllIIIIlIIIIlIlIIIIlll.addProperty("max", (Number)lllllllllllllIIIIlIIIIlIlIIIIllI.max);
            return (JsonElement)lllllllllllllIIIIlIIIIlIlIIIIlll;
        }
        
        public RandomValueRange deserialize(final JsonElement lllllllllllllIIIIlIIIIlIlIIlIIIl, final Type lllllllllllllIIIIlIIIIlIlIIlIllI, final JsonDeserializationContext lllllllllllllIIIIlIIIIlIlIIlIlIl) throws JsonParseException {
            if (JsonUtils.isNumber(lllllllllllllIIIIlIIIIlIlIIlIIIl)) {
                return new RandomValueRange(JsonUtils.getFloat(lllllllllllllIIIIlIIIIlIlIIlIIIl, "value"));
            }
            final JsonObject lllllllllllllIIIIlIIIIlIlIIlIlII = JsonUtils.getJsonObject(lllllllllllllIIIIlIIIIlIlIIlIIIl, "value");
            final float lllllllllllllIIIIlIIIIlIlIIlIIll = JsonUtils.getFloat(lllllllllllllIIIIlIIIIlIlIIlIlII, "min");
            final float lllllllllllllIIIIlIIIIlIlIIlIIlI = JsonUtils.getFloat(lllllllllllllIIIIlIIIIlIlIIlIlII, "max");
            return new RandomValueRange(lllllllllllllIIIIlIIIIlIlIIlIIll, lllllllllllllIIIIlIIIIlIlIIlIIlI);
        }
    }
}
