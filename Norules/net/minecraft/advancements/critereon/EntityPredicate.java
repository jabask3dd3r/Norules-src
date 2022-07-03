package net.minecraft.advancements.critereon;

import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class EntityPredicate
{
    private final /* synthetic */ DistancePredicate field_192485_c;
    private final /* synthetic */ MobEffectsPredicate field_193436_e;
    private final /* synthetic */ ResourceLocation field_192484_b;
    private final /* synthetic */ LocationPredicate field_193435_d;
    public static final /* synthetic */ EntityPredicate field_192483_a;
    private final /* synthetic */ NBTPredicate field_193437_f;
    
    static {
        field_192483_a = new EntityPredicate(null, DistancePredicate.field_193423_a, LocationPredicate.field_193455_a, MobEffectsPredicate.field_193473_a, NBTPredicate.field_193479_a);
    }
    
    public boolean func_192482_a(final EntityPlayerMP llllllllllllllIllIlIlllIlIIIIlII, @Nullable final Entity llllllllllllllIllIlIlllIlIIIIIII) {
        return this == EntityPredicate.field_192483_a || (llllllllllllllIllIlIlllIlIIIIIII != null && (this.field_192484_b == null || EntityList.isStringEntityName(llllllllllllllIllIlIlllIlIIIIIII, this.field_192484_b)) && this.field_192485_c.func_193422_a(llllllllllllllIllIlIlllIlIIIIlII.posX, llllllllllllllIllIlIlllIlIIIIlII.posY, llllllllllllllIllIlIlllIlIIIIlII.posZ, llllllllllllllIllIlIlllIlIIIIIII.posX, llllllllllllllIllIlIlllIlIIIIIII.posY, llllllllllllllIllIlIlllIlIIIIIII.posZ) && this.field_193435_d.func_193452_a(llllllllllllllIllIlIlllIlIIIIlII.getServerWorld(), llllllllllllllIllIlIlllIlIIIIIII.posX, llllllllllllllIllIlIlllIlIIIIIII.posY, llllllllllllllIllIlIlllIlIIIIIII.posZ) && this.field_193436_e.func_193469_a(llllllllllllllIllIlIlllIlIIIIIII) && this.field_193437_f.func_193475_a(llllllllllllllIllIlIlllIlIIIIIII));
    }
    
    public static EntityPredicate func_192481_a(@Nullable final JsonElement llllllllllllllIllIlIlllIIlllIIIl) {
        if (llllllllllllllIllIlIlllIIlllIIIl != null && !llllllllllllllIllIlIlllIIlllIIIl.isJsonNull()) {
            final JsonObject llllllllllllllIllIlIlllIIlllIlll = JsonUtils.getJsonObject(llllllllllllllIllIlIlllIIlllIIIl, "entity");
            ResourceLocation llllllllllllllIllIlIlllIIlllIllI = null;
            if (llllllllllllllIllIlIlllIIlllIlll.has("type")) {
                llllllllllllllIllIlIlllIIlllIllI = new ResourceLocation(JsonUtils.getString(llllllllllllllIllIlIlllIIlllIlll, "type"));
                if (!EntityList.isStringValidEntityName(llllllllllllllIllIlIlllIIlllIllI)) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown entity type '").append(llllllllllllllIllIlIlllIIlllIllI).append("', valid types are: ").append(EntityList.func_192840_b())));
                }
            }
            final DistancePredicate llllllllllllllIllIlIlllIIlllIlIl = DistancePredicate.func_193421_a(llllllllllllllIllIlIlllIIlllIlll.get("distance"));
            final LocationPredicate llllllllllllllIllIlIlllIIlllIlII = LocationPredicate.func_193454_a(llllllllllllllIllIlIlllIIlllIlll.get("location"));
            final MobEffectsPredicate llllllllllllllIllIlIlllIIlllIIll = MobEffectsPredicate.func_193471_a(llllllllllllllIllIlIlllIIlllIlll.get("effects"));
            final NBTPredicate llllllllllllllIllIlIlllIIlllIIlI = NBTPredicate.func_193476_a(llllllllllllllIllIlIlllIIlllIlll.get("nbt"));
            return new EntityPredicate(llllllllllllllIllIlIlllIIlllIllI, llllllllllllllIllIlIlllIIlllIlIl, llllllllllllllIllIlIlllIIlllIlII, llllllllllllllIllIlIlllIIlllIIll, llllllllllllllIllIlIlllIIlllIIlI);
        }
        return EntityPredicate.field_192483_a;
    }
    
    public EntityPredicate(@Nullable final ResourceLocation llllllllllllllIllIlIlllIlIIlIIll, final DistancePredicate llllllllllllllIllIlIlllIlIIlIIlI, final LocationPredicate llllllllllllllIllIlIlllIlIIIlIll, final MobEffectsPredicate llllllllllllllIllIlIlllIlIIlIIII, final NBTPredicate llllllllllllllIllIlIlllIlIIIllll) {
        this.field_192484_b = llllllllllllllIllIlIlllIlIIlIIll;
        this.field_192485_c = llllllllllllllIllIlIlllIlIIlIIlI;
        this.field_193435_d = llllllllllllllIllIlIlllIlIIIlIll;
        this.field_193436_e = llllllllllllllIllIlIlllIlIIlIIII;
        this.field_193437_f = llllllllllllllIllIlIlllIlIIIllll;
    }
}
