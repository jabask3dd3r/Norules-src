package net.minecraft.advancements;

import java.util.*;
import com.google.common.collect.*;
import javax.annotation.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class Criterion
{
    private final /* synthetic */ ICriterionInstance field_192147_a;
    
    public static Map<String, Criterion> func_192144_b(final JsonObject lllllllllllllllIIlIIllIIIIIllIII, final JsonDeserializationContext lllllllllllllllIIlIIllIIIIIlIlll) {
        final Map<String, Criterion> lllllllllllllllIIlIIllIIIIIlIllI = (Map<String, Criterion>)Maps.newHashMap();
        for (final Map.Entry<String, JsonElement> lllllllllllllllIIlIIllIIIIIlIlIl : lllllllllllllllIIlIIllIIIIIllIII.entrySet()) {
            lllllllllllllllIIlIIllIIIIIlIllI.put(lllllllllllllllIIlIIllIIIIIlIlIl.getKey(), func_192145_a(JsonUtils.getJsonObject(lllllllllllllllIIlIIllIIIIIlIlIl.getValue(), "criterion"), lllllllllllllllIIlIIllIIIIIlIlll));
        }
        return lllllllllllllllIIlIIllIIIIIlIllI;
    }
    
    public Criterion() {
        this.field_192147_a = null;
    }
    
    @Nullable
    public ICriterionInstance func_192143_a() {
        return this.field_192147_a;
    }
    
    public void func_192140_a(final PacketBuffer lllllllllllllllIIlIIllIIIIlIlllI) {
    }
    
    public static Criterion func_192146_b(final PacketBuffer lllllllllllllllIIlIIllIIIIIllllI) {
        return new Criterion();
    }
    
    public static Map<String, Criterion> func_192142_c(final PacketBuffer lllllllllllllllIIlIIllIIIIIIIlll) {
        final Map<String, Criterion> lllllllllllllllIIlIIllIIIIIIlIlI = (Map<String, Criterion>)Maps.newHashMap();
        for (int lllllllllllllllIIlIIllIIIIIIlIIl = lllllllllllllllIIlIIllIIIIIIIlll.readVarIntFromBuffer(), lllllllllllllllIIlIIllIIIIIIlIII = 0; lllllllllllllllIIlIIllIIIIIIlIII < lllllllllllllllIIlIIllIIIIIIlIIl; ++lllllllllllllllIIlIIllIIIIIIlIII) {
            lllllllllllllllIIlIIllIIIIIIlIlI.put(lllllllllllllllIIlIIllIIIIIIIlll.readStringFromBuffer(32767), func_192146_b(lllllllllllllllIIlIIllIIIIIIIlll));
        }
        return lllllllllllllllIIlIIllIIIIIIlIlI;
    }
    
    public static Criterion func_192145_a(final JsonObject lllllllllllllllIIlIIllIIIIlIlIII, final JsonDeserializationContext lllllllllllllllIIlIIllIIIIlIIIlI) {
        final ResourceLocation lllllllllllllllIIlIIllIIIIlIIllI = new ResourceLocation(JsonUtils.getString(lllllllllllllllIIlIIllIIIIlIlIII, "trigger"));
        final ICriterionTrigger<?> lllllllllllllllIIlIIllIIIIlIIlIl = CriteriaTriggers.func_192119_a(lllllllllllllllIIlIIllIIIIlIIllI);
        if (lllllllllllllllIIlIIllIIIIlIIlIl == null) {
            throw new JsonSyntaxException(String.valueOf(new StringBuilder("Invalid criterion trigger: ").append(lllllllllllllllIIlIIllIIIIlIIllI)));
        }
        final ICriterionInstance lllllllllllllllIIlIIllIIIIlIIlII = (ICriterionInstance)lllllllllllllllIIlIIllIIIIlIIlIl.func_192166_a(JsonUtils.getJsonObject(lllllllllllllllIIlIIllIIIIlIlIII, "conditions", new JsonObject()), lllllllllllllllIIlIIllIIIIlIIIlI);
        return new Criterion(lllllllllllllllIIlIIllIIIIlIIlII);
    }
    
    public Criterion(final ICriterionInstance lllllllllllllllIIlIIllIIIIllIIll) {
        this.field_192147_a = lllllllllllllllIIlIIllIIIIllIIll;
    }
    
    public static void func_192141_a(final Map<String, Criterion> lllllllllllllllIIlIIlIllllllllll, final PacketBuffer lllllllllllllllIIlIIlIlllllllllI) {
        lllllllllllllllIIlIIlIlllllllllI.writeVarIntToBuffer(lllllllllllllllIIlIIlIllllllllll.size());
        for (final Map.Entry<String, Criterion> lllllllllllllllIIlIIlIllllllllIl : lllllllllllllllIIlIIlIllllllllll.entrySet()) {
            lllllllllllllllIIlIIlIlllllllllI.writeString(lllllllllllllllIIlIIlIllllllllIl.getKey());
            lllllllllllllllIIlIIlIllllllllIl.getValue().func_192140_a(lllllllllllllllIIlIIlIlllllllllI);
        }
    }
}
