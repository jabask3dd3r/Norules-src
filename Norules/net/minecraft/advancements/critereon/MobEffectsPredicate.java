package net.minecraft.advancements.critereon;

import java.util.*;
import net.minecraft.potion.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.entity.*;

public class MobEffectsPredicate
{
    private final /* synthetic */ Map<Potion, InstancePredicate> field_193474_b;
    public static final /* synthetic */ MobEffectsPredicate field_193473_a;
    
    static {
        field_193473_a = new MobEffectsPredicate(Collections.emptyMap());
    }
    
    public MobEffectsPredicate(final Map<Potion, InstancePredicate> lllllllllllllllIllllllIllIIIIlll) {
        this.field_193474_b = lllllllllllllllIllllllIllIIIIlll;
    }
    
    public boolean func_193470_a(final Map<Potion, PotionEffect> lllllllllllllllIllllllIlIlllIIlI) {
        if (this == MobEffectsPredicate.field_193473_a) {
            return true;
        }
        for (final Map.Entry<Potion, InstancePredicate> lllllllllllllllIllllllIlIlllIIIl : this.field_193474_b.entrySet()) {
            final PotionEffect lllllllllllllllIllllllIlIlllIIII = lllllllllllllllIllllllIlIlllIIlI.get(lllllllllllllllIllllllIlIlllIIIl.getKey());
            if (!lllllllllllllllIllllllIlIlllIIIl.getValue().func_193463_a(lllllllllllllllIllllllIlIlllIIII)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean func_193472_a(final EntityLivingBase lllllllllllllllIllllllIlIllllIIl) {
        return this == MobEffectsPredicate.field_193473_a || this.func_193470_a(lllllllllllllllIllllllIlIllllIIl.func_193076_bZ());
    }
    
    public static MobEffectsPredicate func_193471_a(@Nullable final JsonElement lllllllllllllllIllllllIlIlIllIll) {
        if (lllllllllllllllIllllllIlIlIllIll != null && !lllllllllllllllIllllllIlIlIllIll.isJsonNull()) {
            final JsonObject lllllllllllllllIllllllIlIllIIIIl = JsonUtils.getJsonObject(lllllllllllllllIllllllIlIlIllIll, "effects");
            final Map<Potion, InstancePredicate> lllllllllllllllIllllllIlIllIIIII = (Map<Potion, InstancePredicate>)Maps.newHashMap();
            for (final Map.Entry<String, JsonElement> lllllllllllllllIllllllIlIlIlllll : lllllllllllllllIllllllIlIllIIIIl.entrySet()) {
                final ResourceLocation lllllllllllllllIllllllIlIlIllllI = new ResourceLocation(lllllllllllllllIllllllIlIlIlllll.getKey());
                final Potion lllllllllllllllIllllllIlIlIlllIl = Potion.REGISTRY.getObject(lllllllllllllllIllllllIlIlIllllI);
                if (lllllllllllllllIllllllIlIlIlllIl == null) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown effect '").append(lllllllllllllllIllllllIlIlIllllI).append("'")));
                }
                final InstancePredicate lllllllllllllllIllllllIlIlIlllII = InstancePredicate.func_193464_a(JsonUtils.getJsonObject(lllllllllllllllIllllllIlIlIlllll.getValue(), lllllllllllllllIllllllIlIlIlllll.getKey()));
                lllllllllllllllIllllllIlIllIIIII.put(lllllllllllllllIllllllIlIlIlllIl, lllllllllllllllIllllllIlIlIlllII);
            }
            return new MobEffectsPredicate(lllllllllllllllIllllllIlIllIIIII);
        }
        return MobEffectsPredicate.field_193473_a;
    }
    
    public boolean func_193469_a(final Entity lllllllllllllllIllllllIlIlllllll) {
        return this == MobEffectsPredicate.field_193473_a || (lllllllllllllllIllllllIlIlllllll instanceof EntityLivingBase && this.func_193470_a(((EntityLivingBase)lllllllllllllllIllllllIlIlllllll).func_193076_bZ()));
    }
    
    public static class InstancePredicate
    {
        @Nullable
        private final /* synthetic */ Boolean field_193467_c;
        @Nullable
        private final /* synthetic */ Boolean field_193468_d;
        private final /* synthetic */ MinMaxBounds field_193465_a;
        private final /* synthetic */ MinMaxBounds field_193466_b;
        
        public InstancePredicate(final MinMaxBounds lllllllllllllIlIlIIlIlIlIlllllIl, final MinMaxBounds lllllllllllllIlIlIIlIlIllIIIIIIl, @Nullable final Boolean lllllllllllllIlIlIIlIlIlIllllIll, @Nullable final Boolean lllllllllllllIlIlIIlIlIlIlllllll) {
            this.field_193465_a = lllllllllllllIlIlIIlIlIlIlllllIl;
            this.field_193466_b = lllllllllllllIlIlIIlIlIllIIIIIIl;
            this.field_193467_c = lllllllllllllIlIlIIlIlIlIllllIll;
            this.field_193468_d = lllllllllllllIlIlIIlIlIlIlllllll;
        }
        
        public static InstancePredicate func_193464_a(final JsonObject lllllllllllllIlIlIIlIlIlIllIlIIl) {
            final MinMaxBounds lllllllllllllIlIlIIlIlIlIllIllIl = MinMaxBounds.func_192515_a(lllllllllllllIlIlIIlIlIlIllIlIIl.get("amplifier"));
            final MinMaxBounds lllllllllllllIlIlIIlIlIlIllIllII = MinMaxBounds.func_192515_a(lllllllllllllIlIlIIlIlIlIllIlIIl.get("duration"));
            final Boolean lllllllllllllIlIlIIlIlIlIllIlIll = lllllllllllllIlIlIIlIlIlIllIlIIl.has("ambient") ? Boolean.valueOf(JsonUtils.getBoolean(lllllllllllllIlIlIIlIlIlIllIlIIl, "ambient")) : null;
            final Boolean lllllllllllllIlIlIIlIlIlIllIlIlI = lllllllllllllIlIlIIlIlIlIllIlIIl.has("visible") ? Boolean.valueOf(JsonUtils.getBoolean(lllllllllllllIlIlIIlIlIlIllIlIIl, "visible")) : null;
            return new InstancePredicate(lllllllllllllIlIlIIlIlIlIllIllIl, lllllllllllllIlIlIIlIlIlIllIllII, lllllllllllllIlIlIIlIlIlIllIlIll, lllllllllllllIlIlIIlIlIlIllIlIlI);
        }
        
        public boolean func_193463_a(@Nullable final PotionEffect lllllllllllllIlIlIIlIlIlIlllIllI) {
            return lllllllllllllIlIlIIlIlIlIlllIllI != null && this.field_193465_a.func_192514_a((float)lllllllllllllIlIlIIlIlIlIlllIllI.getAmplifier()) && this.field_193466_b.func_192514_a((float)lllllllllllllIlIlIIlIlIlIlllIllI.getDuration()) && (this.field_193467_c == null || this.field_193467_c == lllllllllllllIlIlIIlIlIlIlllIllI.getIsAmbient()) && (this.field_193468_d == null || this.field_193468_d == lllllllllllllIlIlIIlIlIlIlllIllI.doesShowParticles());
        }
    }
}
