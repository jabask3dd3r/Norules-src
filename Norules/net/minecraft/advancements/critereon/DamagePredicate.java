package net.minecraft.advancements.critereon;

import javax.annotation.*;
import com.google.gson.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class DamagePredicate
{
    private final /* synthetic */ Boolean field_192370_e;
    private final /* synthetic */ MinMaxBounds field_192367_b;
    private final /* synthetic */ EntityPredicate field_192369_d;
    public static /* synthetic */ DamagePredicate field_192366_a;
    private final /* synthetic */ MinMaxBounds field_192368_c;
    private final /* synthetic */ DamageSourcePredicate field_192371_f;
    
    static {
        DamagePredicate.field_192366_a = new DamagePredicate();
    }
    
    public DamagePredicate() {
        this.field_192367_b = MinMaxBounds.field_192516_a;
        this.field_192368_c = MinMaxBounds.field_192516_a;
        this.field_192369_d = EntityPredicate.field_192483_a;
        this.field_192370_e = null;
        this.field_192371_f = DamageSourcePredicate.field_192449_a;
    }
    
    public DamagePredicate(final MinMaxBounds llllllllllllllIllIIIIIllIlllIllI, final MinMaxBounds llllllllllllllIllIIIIIllIllIllll, final EntityPredicate llllllllllllllIllIIIIIllIllIlllI, @Nullable final Boolean llllllllllllllIllIIIIIllIlllIIll, final DamageSourcePredicate llllllllllllllIllIIIIIllIllIllII) {
        this.field_192367_b = llllllllllllllIllIIIIIllIlllIllI;
        this.field_192368_c = llllllllllllllIllIIIIIllIllIllll;
        this.field_192369_d = llllllllllllllIllIIIIIllIllIlllI;
        this.field_192370_e = llllllllllllllIllIIIIIllIlllIIll;
        this.field_192371_f = llllllllllllllIllIIIIIllIllIllII;
    }
    
    public static DamagePredicate func_192364_a(@Nullable final JsonElement llllllllllllllIllIIIIIllIlIlIIlI) {
        if (llllllllllllllIllIIIIIllIlIlIIlI != null && !llllllllllllllIllIIIIIllIlIlIIlI.isJsonNull()) {
            final JsonObject llllllllllllllIllIIIIIllIlIlIIIl = JsonUtils.getJsonObject(llllllllllllllIllIIIIIllIlIlIIlI, "damage");
            final MinMaxBounds llllllllllllllIllIIIIIllIlIlIIII = MinMaxBounds.func_192515_a(llllllllllllllIllIIIIIllIlIlIIIl.get("dealt"));
            final MinMaxBounds llllllllllllllIllIIIIIllIlIIllll = MinMaxBounds.func_192515_a(llllllllllllllIllIIIIIllIlIlIIIl.get("taken"));
            final Boolean llllllllllllllIllIIIIIllIlIIlllI = llllllllllllllIllIIIIIllIlIlIIIl.has("blocked") ? Boolean.valueOf(JsonUtils.getBoolean(llllllllllllllIllIIIIIllIlIlIIIl, "blocked")) : null;
            final EntityPredicate llllllllllllllIllIIIIIllIlIIllIl = EntityPredicate.func_192481_a(llllllllllllllIllIIIIIllIlIlIIIl.get("source_entity"));
            final DamageSourcePredicate llllllllllllllIllIIIIIllIlIIllII = DamageSourcePredicate.func_192447_a(llllllllllllllIllIIIIIllIlIlIIIl.get("type"));
            return new DamagePredicate(llllllllllllllIllIIIIIllIlIlIIII, llllllllllllllIllIIIIIllIlIIllll, llllllllllllllIllIIIIIllIlIIllIl, llllllllllllllIllIIIIIllIlIIlllI, llllllllllllllIllIIIIIllIlIIllII);
        }
        return DamagePredicate.field_192366_a;
    }
    
    public boolean func_192365_a(final EntityPlayerMP llllllllllllllIllIIIIIllIlIllllI, final DamageSource llllllllllllllIllIIIIIllIllIIIll, final float llllllllllllllIllIIIIIllIlIlllII, final float llllllllllllllIllIIIIIllIllIIIIl, final boolean llllllllllllllIllIIIIIllIllIIIII) {
        return this == DamagePredicate.field_192366_a || (this.field_192367_b.func_192514_a(llllllllllllllIllIIIIIllIlIlllII) && this.field_192368_c.func_192514_a(llllllllllllllIllIIIIIllIllIIIIl) && this.field_192369_d.func_192482_a(llllllllllllllIllIIIIIllIlIllllI, llllllllllllllIllIIIIIllIllIIIll.getEntity()) && (this.field_192370_e == null || this.field_192370_e == llllllllllllllIllIIIIIllIllIIIII) && this.field_192371_f.func_193418_a(llllllllllllllIllIIIIIllIlIllllI, llllllllllllllIllIIIIIllIllIIIll));
    }
}
