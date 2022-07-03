package net.minecraft.advancements.critereon;

import javax.annotation.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class MinMaxBounds
{
    private final /* synthetic */ Float field_192517_b;
    public static final /* synthetic */ MinMaxBounds field_192516_a;
    private final /* synthetic */ Float field_192518_c;
    
    public MinMaxBounds(@Nullable final Float lllllllllllllIIlIllIIlIIIIlllIII, @Nullable final Float lllllllllllllIIlIllIIlIIIIllIlll) {
        this.field_192517_b = lllllllllllllIIlIllIIlIIIIlllIII;
        this.field_192518_c = lllllllllllllIIlIllIIlIIIIllIlll;
    }
    
    public boolean func_192513_a(final double lllllllllllllIIlIllIIlIIIIlIlIII) {
        return (this.field_192517_b == null || this.field_192517_b * this.field_192517_b <= lllllllllllllIIlIllIIlIIIIlIlIII) && (this.field_192518_c == null || this.field_192518_c * this.field_192518_c >= lllllllllllllIIlIllIIlIIIIlIlIII);
    }
    
    static {
        field_192516_a = new MinMaxBounds(null, null);
    }
    
    public static MinMaxBounds func_192515_a(@Nullable final JsonElement lllllllllllllIIlIllIIlIIIIIllllI) {
        if (lllllllllllllIIlIllIIlIIIIIllllI == null || lllllllllllllIIlIllIIlIIIIIllllI.isJsonNull()) {
            return MinMaxBounds.field_192516_a;
        }
        if (JsonUtils.isNumber(lllllllllllllIIlIllIIlIIIIIllllI)) {
            final float lllllllllllllIIlIllIIlIIIIlIIIlI = JsonUtils.getFloat(lllllllllllllIIlIllIIlIIIIIllllI, "value");
            return new MinMaxBounds(lllllllllllllIIlIllIIlIIIIlIIIlI, lllllllllllllIIlIllIIlIIIIlIIIlI);
        }
        final JsonObject lllllllllllllIIlIllIIlIIIIlIIIIl = JsonUtils.getJsonObject(lllllllllllllIIlIllIIlIIIIIllllI, "value");
        final Float lllllllllllllIIlIllIIlIIIIlIIIII = lllllllllllllIIlIllIIlIIIIlIIIIl.has("min") ? Float.valueOf(JsonUtils.getFloat(lllllllllllllIIlIllIIlIIIIlIIIIl, "min")) : null;
        final Float lllllllllllllIIlIllIIlIIIIIlllll = lllllllllllllIIlIllIIlIIIIlIIIIl.has("max") ? Float.valueOf(JsonUtils.getFloat(lllllllllllllIIlIllIIlIIIIlIIIIl, "max")) : null;
        return new MinMaxBounds(lllllllllllllIIlIllIIlIIIIlIIIII, lllllllllllllIIlIllIIlIIIIIlllll);
    }
    
    public boolean func_192514_a(final float lllllllllllllIIlIllIIlIIIIlIlllI) {
        return (this.field_192517_b == null || this.field_192517_b <= lllllllllllllIIlIllIIlIIIIlIlllI) && (this.field_192518_c == null || this.field_192518_c >= lllllllllllllIIlIllIIlIIIIlIlllI);
    }
}
