package net.minecraft.advancements.critereon;

import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class DamageSourcePredicate
{
    private final /* synthetic */ Boolean field_192451_c;
    private final /* synthetic */ Boolean field_192453_e;
    private final /* synthetic */ EntityPredicate field_193420_j;
    private final /* synthetic */ Boolean field_192450_b;
    public static /* synthetic */ DamageSourcePredicate field_192449_a;
    private final /* synthetic */ Boolean field_192455_g;
    private final /* synthetic */ Boolean field_192452_d;
    private final /* synthetic */ Boolean field_192456_h;
    private final /* synthetic */ Boolean field_192454_f;
    private final /* synthetic */ EntityPredicate field_193419_i;
    
    public DamageSourcePredicate(@Nullable final Boolean lllllllllllllIIIIIlIllIIIlIIllll, @Nullable final Boolean lllllllllllllIIIIIlIllIIIlIllIII, @Nullable final Boolean lllllllllllllIIIIIlIllIIIlIIllIl, @Nullable final Boolean lllllllllllllIIIIIlIllIIIlIIllII, @Nullable final Boolean lllllllllllllIIIIIlIllIIIlIIlIll, @Nullable final Boolean lllllllllllllIIIIIlIllIIIlIIlIlI, @Nullable final Boolean lllllllllllllIIIIIlIllIIIlIlIIll, final EntityPredicate lllllllllllllIIIIIlIllIIIlIIlIII, final EntityPredicate lllllllllllllIIIIIlIllIIIlIIIlll) {
        this.field_192450_b = lllllllllllllIIIIIlIllIIIlIIllll;
        this.field_192451_c = lllllllllllllIIIIIlIllIIIlIllIII;
        this.field_192452_d = lllllllllllllIIIIIlIllIIIlIIllIl;
        this.field_192453_e = lllllllllllllIIIIIlIllIIIlIIllII;
        this.field_192454_f = lllllllllllllIIIIIlIllIIIlIIlIll;
        this.field_192455_g = lllllllllllllIIIIIlIllIIIlIIlIlI;
        this.field_192456_h = lllllllllllllIIIIIlIllIIIlIlIIll;
        this.field_193419_i = lllllllllllllIIIIIlIllIIIlIIlIII;
        this.field_193420_j = lllllllllllllIIIIIlIllIIIlIIIlll;
    }
    
    static {
        DamageSourcePredicate.field_192449_a = new DamageSourcePredicate();
    }
    
    public DamageSourcePredicate() {
        this.field_192450_b = null;
        this.field_192451_c = null;
        this.field_192452_d = null;
        this.field_192453_e = null;
        this.field_192454_f = null;
        this.field_192455_g = null;
        this.field_192456_h = null;
        this.field_193419_i = EntityPredicate.field_192483_a;
        this.field_193420_j = EntityPredicate.field_192483_a;
    }
    
    public boolean func_193418_a(final EntityPlayerMP lllllllllllllIIIIIlIllIIIlIIIIlI, final DamageSource lllllllllllllIIIIIlIllIIIlIIIIIl) {
        return this == DamageSourcePredicate.field_192449_a || ((this.field_192450_b == null || this.field_192450_b == lllllllllllllIIIIIlIllIIIlIIIIIl.isProjectile()) && (this.field_192451_c == null || this.field_192451_c == lllllllllllllIIIIIlIllIIIlIIIIIl.isExplosion()) && (this.field_192452_d == null || this.field_192452_d == lllllllllllllIIIIIlIllIIIlIIIIIl.isUnblockable()) && (this.field_192453_e == null || this.field_192453_e == lllllllllllllIIIIIlIllIIIlIIIIIl.canHarmInCreative()) && (this.field_192454_f == null || this.field_192454_f == lllllllllllllIIIIIlIllIIIlIIIIIl.isDamageAbsolute()) && (this.field_192455_g == null || this.field_192455_g == lllllllllllllIIIIIlIllIIIlIIIIIl.isFireDamage()) && (this.field_192456_h == null || this.field_192456_h == lllllllllllllIIIIIlIllIIIlIIIIIl.isMagicDamage()) && this.field_193419_i.func_192482_a(lllllllllllllIIIIIlIllIIIlIIIIlI, lllllllllllllIIIIIlIllIIIlIIIIIl.getSourceOfDamage()) && this.field_193420_j.func_192482_a(lllllllllllllIIIIIlIllIIIlIIIIlI, lllllllllllllIIIIIlIllIIIlIIIIIl.getEntity()));
    }
    
    public static DamageSourcePredicate func_192447_a(@Nullable final JsonElement lllllllllllllIIIIIlIllIIIIllIIlI) {
        if (lllllllllllllIIIIIlIllIIIIllIIlI != null && !lllllllllllllIIIIIlIllIIIIllIIlI.isJsonNull()) {
            final JsonObject lllllllllllllIIIIIlIllIIIIllIIIl = JsonUtils.getJsonObject(lllllllllllllIIIIIlIllIIIIllIIlI, "damage type");
            final Boolean lllllllllllllIIIIIlIllIIIIllIIII = func_192448_a(lllllllllllllIIIIIlIllIIIIllIIIl, "is_projectile");
            final Boolean lllllllllllllIIIIIlIllIIIIlIllll = func_192448_a(lllllllllllllIIIIIlIllIIIIllIIIl, "is_explosion");
            final Boolean lllllllllllllIIIIIlIllIIIIlIlllI = func_192448_a(lllllllllllllIIIIIlIllIIIIllIIIl, "bypasses_armor");
            final Boolean lllllllllllllIIIIIlIllIIIIlIllIl = func_192448_a(lllllllllllllIIIIIlIllIIIIllIIIl, "bypasses_invulnerability");
            final Boolean lllllllllllllIIIIIlIllIIIIlIllII = func_192448_a(lllllllllllllIIIIIlIllIIIIllIIIl, "bypasses_magic");
            final Boolean lllllllllllllIIIIIlIllIIIIlIlIll = func_192448_a(lllllllllllllIIIIIlIllIIIIllIIIl, "is_fire");
            final Boolean lllllllllllllIIIIIlIllIIIIlIlIlI = func_192448_a(lllllllllllllIIIIIlIllIIIIllIIIl, "is_magic");
            final EntityPredicate lllllllllllllIIIIIlIllIIIIlIlIIl = EntityPredicate.func_192481_a(lllllllllllllIIIIIlIllIIIIllIIIl.get("direct_entity"));
            final EntityPredicate lllllllllllllIIIIIlIllIIIIlIlIII = EntityPredicate.func_192481_a(lllllllllllllIIIIIlIllIIIIllIIIl.get("source_entity"));
            return new DamageSourcePredicate(lllllllllllllIIIIIlIllIIIIllIIII, lllllllllllllIIIIIlIllIIIIlIllll, lllllllllllllIIIIIlIllIIIIlIlllI, lllllllllllllIIIIIlIllIIIIlIllIl, lllllllllllllIIIIIlIllIIIIlIllII, lllllllllllllIIIIIlIllIIIIlIlIll, lllllllllllllIIIIIlIllIIIIlIlIlI, lllllllllllllIIIIIlIllIIIIlIlIIl, lllllllllllllIIIIIlIllIIIIlIlIII);
        }
        return DamageSourcePredicate.field_192449_a;
    }
    
    @Nullable
    private static Boolean func_192448_a(final JsonObject lllllllllllllIIIIIlIllIIIIIllIlI, final String lllllllllllllIIIIIlIllIIIIIlIlll) {
        return lllllllllllllIIIIIlIllIIIIIllIlI.has(lllllllllllllIIIIIlIllIIIIIlIlll) ? Boolean.valueOf(JsonUtils.getBoolean(lllllllllllllIIIIIlIllIIIIIllIlI, lllllllllllllIIIIIlIllIIIIIlIlll)) : null;
    }
}
