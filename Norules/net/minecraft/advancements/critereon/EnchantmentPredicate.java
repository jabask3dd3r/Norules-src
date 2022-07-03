package net.minecraft.advancements.critereon;

import net.minecraft.enchantment.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class EnchantmentPredicate
{
    private final /* synthetic */ MinMaxBounds field_192468_c;
    private final /* synthetic */ Enchantment field_192467_b;
    public static final /* synthetic */ EnchantmentPredicate field_192466_a;
    
    public EnchantmentPredicate() {
        this.field_192467_b = null;
        this.field_192468_c = MinMaxBounds.field_192516_a;
    }
    
    public boolean func_192463_a(final Map<Enchantment, Integer> llllllllllllllIIIllIlllIIlllIIll) {
        if (this.field_192467_b != null) {
            if (!llllllllllllllIIIllIlllIIlllIIll.containsKey(this.field_192467_b)) {
                return false;
            }
            final int llllllllllllllIIIllIlllIIlllIllI = llllllllllllllIIIllIlllIIlllIIll.get(this.field_192467_b);
            if (this.field_192468_c != null && !this.field_192468_c.func_192514_a((float)llllllllllllllIIIllIlllIIlllIllI)) {
                return false;
            }
        }
        else if (this.field_192468_c != null) {
            for (final Integer llllllllllllllIIIllIlllIIlllIlIl : llllllllllllllIIIllIlllIIlllIIll.values()) {
                if (this.field_192468_c.func_192514_a(llllllllllllllIIIllIlllIIlllIlIl)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public static EnchantmentPredicate[] func_192465_b(@Nullable final JsonElement llllllllllllllIIIllIlllIIlIllIll) {
        if (llllllllllllllIIIllIlllIIlIllIll != null && !llllllllllllllIIIllIlllIIlIllIll.isJsonNull()) {
            final JsonArray llllllllllllllIIIllIlllIIlIllllI = JsonUtils.getJsonArray(llllllllllllllIIIllIlllIIlIllIll, "enchantments");
            final EnchantmentPredicate[] llllllllllllllIIIllIlllIIlIlllIl = new EnchantmentPredicate[llllllllllllllIIIllIlllIIlIllllI.size()];
            for (int llllllllllllllIIIllIlllIIlIlllII = 0; llllllllllllllIIIllIlllIIlIlllII < llllllllllllllIIIllIlllIIlIlllIl.length; ++llllllllllllllIIIllIlllIIlIlllII) {
                llllllllllllllIIIllIlllIIlIlllIl[llllllllllllllIIIllIlllIIlIlllII] = func_192464_a(llllllllllllllIIIllIlllIIlIllllI.get(llllllllllllllIIIllIlllIIlIlllII));
            }
            return llllllllllllllIIIllIlllIIlIlllIl;
        }
        return new EnchantmentPredicate[0];
    }
    
    static {
        field_192466_a = new EnchantmentPredicate();
    }
    
    public static EnchantmentPredicate func_192464_a(@Nullable final JsonElement llllllllllllllIIIllIlllIIllIllII) {
        if (llllllllllllllIIIllIlllIIllIllII != null && !llllllllllllllIIIllIlllIIllIllII.isJsonNull()) {
            final JsonObject llllllllllllllIIIllIlllIIllIlIll = JsonUtils.getJsonObject(llllllllllllllIIIllIlllIIllIllII, "enchantment");
            Enchantment llllllllllllllIIIllIlllIIllIlIlI = null;
            if (llllllllllllllIIIllIlllIIllIlIll.has("enchantment")) {
                final ResourceLocation llllllllllllllIIIllIlllIIllIlIIl = new ResourceLocation(JsonUtils.getString(llllllllllllllIIIllIlllIIllIlIll, "enchantment"));
                llllllllllllllIIIllIlllIIllIlIlI = Enchantment.REGISTRY.getObject(llllllllllllllIIIllIlllIIllIlIIl);
                if (llllllllllllllIIIllIlllIIllIlIlI == null) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown enchantment '").append(llllllllllllllIIIllIlllIIllIlIIl).append("'")));
                }
            }
            final MinMaxBounds llllllllllllllIIIllIlllIIllIlIII = MinMaxBounds.func_192515_a(llllllllllllllIIIllIlllIIllIlIll.get("levels"));
            return new EnchantmentPredicate(llllllllllllllIIIllIlllIIllIlIlI, llllllllllllllIIIllIlllIIllIlIII);
        }
        return EnchantmentPredicate.field_192466_a;
    }
    
    public EnchantmentPredicate(@Nullable final Enchantment llllllllllllllIIIllIlllIIllllllI, final MinMaxBounds llllllllllllllIIIllIlllIlIIIIIII) {
        this.field_192467_b = llllllllllllllIIIllIlllIIllllllI;
        this.field_192468_c = llllllllllllllIIIllIlllIlIIIIIII;
    }
}
