package net.minecraft.advancements.critereon;

import javax.annotation.*;
import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.util.math.*;

public class DistancePredicate
{
    public static final /* synthetic */ DistancePredicate field_193423_a;
    private final /* synthetic */ MinMaxBounds field_193425_c;
    private final /* synthetic */ MinMaxBounds field_193424_b;
    private final /* synthetic */ MinMaxBounds field_193427_e;
    private final /* synthetic */ MinMaxBounds field_193428_f;
    private final /* synthetic */ MinMaxBounds field_193426_d;
    
    public static DistancePredicate func_193421_a(@Nullable final JsonElement lllllllllllllIlllllIllllIlllIIIl) {
        if (lllllllllllllIlllllIllllIlllIIIl != null && !lllllllllllllIlllllIllllIlllIIIl.isJsonNull()) {
            final JsonObject lllllllllllllIlllllIllllIlllIlll = JsonUtils.getJsonObject(lllllllllllllIlllllIllllIlllIIIl, "distance");
            final MinMaxBounds lllllllllllllIlllllIllllIlllIllI = MinMaxBounds.func_192515_a(lllllllllllllIlllllIllllIlllIlll.get("x"));
            final MinMaxBounds lllllllllllllIlllllIllllIlllIlIl = MinMaxBounds.func_192515_a(lllllllllllllIlllllIllllIlllIlll.get("y"));
            final MinMaxBounds lllllllllllllIlllllIllllIlllIlII = MinMaxBounds.func_192515_a(lllllllllllllIlllllIllllIlllIlll.get("z"));
            final MinMaxBounds lllllllllllllIlllllIllllIlllIIll = MinMaxBounds.func_192515_a(lllllllllllllIlllllIllllIlllIlll.get("horizontal"));
            final MinMaxBounds lllllllllllllIlllllIllllIlllIIlI = MinMaxBounds.func_192515_a(lllllllllllllIlllllIllllIlllIlll.get("absolute"));
            return new DistancePredicate(lllllllllllllIlllllIllllIlllIllI, lllllllllllllIlllllIllllIlllIlIl, lllllllllllllIlllllIllllIlllIlII, lllllllllllllIlllllIllllIlllIIll, lllllllllllllIlllllIllllIlllIIlI);
        }
        return DistancePredicate.field_193423_a;
    }
    
    static {
        field_193423_a = new DistancePredicate(MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a);
    }
    
    public boolean func_193422_a(final double lllllllllllllIlllllIlllllIIIlIII, final double lllllllllllllIlllllIlllllIIlIIIl, final double lllllllllllllIlllllIlllllIIlIIII, final double lllllllllllllIlllllIlllllIIIllll, final double lllllllllllllIlllllIlllllIIIIlII, final double lllllllllllllIlllllIlllllIIIllIl) {
        final float lllllllllllllIlllllIlllllIIIllII = (float)(lllllllllllllIlllllIlllllIIIlIII - lllllllllllllIlllllIlllllIIIllll);
        final float lllllllllllllIlllllIlllllIIIlIll = (float)(lllllllllllllIlllllIlllllIIlIIIl - lllllllllllllIlllllIlllllIIIIlII);
        final float lllllllllllllIlllllIlllllIIIlIlI = (float)(lllllllllllllIlllllIlllllIIlIIII - lllllllllllllIlllllIlllllIIIllIl);
        return this.field_193424_b.func_192514_a(MathHelper.abs(lllllllllllllIlllllIlllllIIIllII)) && this.field_193425_c.func_192514_a(MathHelper.abs(lllllllllllllIlllllIlllllIIIlIll)) && this.field_193426_d.func_192514_a(MathHelper.abs(lllllllllllllIlllllIlllllIIIlIlI)) && this.field_193427_e.func_192513_a(lllllllllllllIlllllIlllllIIIllII * lllllllllllllIlllllIlllllIIIllII + lllllllllllllIlllllIlllllIIIlIlI * lllllllllllllIlllllIlllllIIIlIlI) && this.field_193428_f.func_192513_a(lllllllllllllIlllllIlllllIIIllII * lllllllllllllIlllllIlllllIIIllII + lllllllllllllIlllllIlllllIIIlIll * lllllllllllllIlllllIlllllIIIlIll + lllllllllllllIlllllIlllllIIIlIlI * lllllllllllllIlllllIlllllIIIlIlI);
    }
    
    public DistancePredicate(final MinMaxBounds lllllllllllllIlllllIlllllIlIlIII, final MinMaxBounds lllllllllllllIlllllIlllllIlIIIIl, final MinMaxBounds lllllllllllllIlllllIlllllIlIIIII, final MinMaxBounds lllllllllllllIlllllIlllllIIlllll, final MinMaxBounds lllllllllllllIlllllIlllllIlIIlII) {
        this.field_193424_b = lllllllllllllIlllllIlllllIlIlIII;
        this.field_193425_c = lllllllllllllIlllllIlllllIlIIIIl;
        this.field_193426_d = lllllllllllllIlllllIlllllIlIIIII;
        this.field_193427_e = lllllllllllllIlllllIlllllIIlllll;
        this.field_193428_f = lllllllllllllIlllllIlllllIlIIlII;
    }
}
