package net.minecraft.advancements.critereon;

import net.minecraft.world.biome.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class LocationPredicate
{
    private final /* synthetic */ MinMaxBounds field_193458_d;
    @Nullable
    final /* synthetic */ Biome field_193456_b;
    private final /* synthetic */ MinMaxBounds field_193457_c;
    @Nullable
    private final /* synthetic */ DimensionType field_193461_g;
    private final /* synthetic */ MinMaxBounds field_193459_e;
    @Nullable
    private final /* synthetic */ String field_193460_f;
    public static /* synthetic */ LocationPredicate field_193455_a;
    
    public LocationPredicate(final MinMaxBounds lllllllllllllIlIlIlIllIlIlIIlIlI, final MinMaxBounds lllllllllllllIlIlIlIllIlIlIIIIlI, final MinMaxBounds lllllllllllllIlIlIlIllIlIlIIlIII, @Nullable final Biome lllllllllllllIlIlIlIllIlIlIIIlll, @Nullable final String lllllllllllllIlIlIlIllIlIlIIIllI, @Nullable final DimensionType lllllllllllllIlIlIlIllIlIlIIIlIl) {
        this.field_193457_c = lllllllllllllIlIlIlIllIlIlIIlIlI;
        this.field_193458_d = lllllllllllllIlIlIlIllIlIlIIIIlI;
        this.field_193459_e = lllllllllllllIlIlIlIllIlIlIIlIII;
        this.field_193456_b = lllllllllllllIlIlIlIllIlIlIIIlll;
        this.field_193460_f = lllllllllllllIlIlIlIllIlIlIIIllI;
        this.field_193461_g = lllllllllllllIlIlIlIllIlIlIIIlIl;
    }
    
    static {
        LocationPredicate.field_193455_a = new LocationPredicate(MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, MinMaxBounds.field_192516_a, null, null, null);
    }
    
    public boolean func_193453_a(final WorldServer lllllllllllllIlIlIlIllIlIIlIIlll, final float lllllllllllllIlIlIlIllIlIIlIIIII, final float lllllllllllllIlIlIlIllIlIIlIIlIl, final float lllllllllllllIlIlIlIllIlIIIllllI) {
        if (!this.field_193457_c.func_192514_a(lllllllllllllIlIlIlIllIlIIlIIIII)) {
            return false;
        }
        if (!this.field_193458_d.func_192514_a(lllllllllllllIlIlIlIllIlIIlIIlIl)) {
            return false;
        }
        if (!this.field_193459_e.func_192514_a(lllllllllllllIlIlIlIllIlIIIllllI)) {
            return false;
        }
        if (this.field_193461_g != null && this.field_193461_g != lllllllllllllIlIlIlIllIlIIlIIlll.provider.getDimensionType()) {
            return false;
        }
        final BlockPos lllllllllllllIlIlIlIllIlIIlIIIll = new BlockPos(lllllllllllllIlIlIlIllIlIIlIIIII, lllllllllllllIlIlIlIllIlIIlIIlIl, lllllllllllllIlIlIlIllIlIIIllllI);
        return (this.field_193456_b == null || this.field_193456_b == lllllllllllllIlIlIlIllIlIIlIIlll.getBiome(lllllllllllllIlIlIlIllIlIIlIIIll)) && (this.field_193460_f == null || lllllllllllllIlIlIlIllIlIIlIIlll.getChunkProvider().func_193413_a(lllllllllllllIlIlIlIllIlIIlIIlll, this.field_193460_f, lllllllllllllIlIlIlIllIlIIlIIIll));
    }
    
    public static LocationPredicate func_193454_a(@Nullable final JsonElement lllllllllllllIlIlIlIllIlIIIIlIII) {
        if (lllllllllllllIlIlIlIllIlIIIIlIII != null && !lllllllllllllIlIlIlIllIlIIIIlIII.isJsonNull()) {
            final JsonObject lllllllllllllIlIlIlIllIlIIIlIIIl = JsonUtils.getJsonObject(lllllllllllllIlIlIlIllIlIIIIlIII, "location");
            final JsonObject lllllllllllllIlIlIlIllIlIIIlIIII = JsonUtils.getJsonObject(lllllllllllllIlIlIlIllIlIIIlIIIl, "position", new JsonObject());
            final MinMaxBounds lllllllllllllIlIlIlIllIlIIIIllll = MinMaxBounds.func_192515_a(lllllllllllllIlIlIlIllIlIIIlIIII.get("x"));
            final MinMaxBounds lllllllllllllIlIlIlIllIlIIIIlllI = MinMaxBounds.func_192515_a(lllllllllllllIlIlIlIllIlIIIlIIII.get("y"));
            final MinMaxBounds lllllllllllllIlIlIlIllIlIIIIllIl = MinMaxBounds.func_192515_a(lllllllllllllIlIlIlIllIlIIIlIIII.get("z"));
            final DimensionType lllllllllllllIlIlIlIllIlIIIIllII = lllllllllllllIlIlIlIllIlIIIlIIIl.has("dimension") ? DimensionType.func_193417_a(JsonUtils.getString(lllllllllllllIlIlIlIllIlIIIlIIIl, "dimension")) : null;
            final String lllllllllllllIlIlIlIllIlIIIIlIll = lllllllllllllIlIlIlIllIlIIIlIIIl.has("feature") ? JsonUtils.getString(lllllllllllllIlIlIlIllIlIIIlIIIl, "feature") : null;
            Biome lllllllllllllIlIlIlIllIlIIIIlIlI = null;
            if (lllllllllllllIlIlIlIllIlIIIlIIIl.has("biome")) {
                final ResourceLocation lllllllllllllIlIlIlIllIlIIIIlIIl = new ResourceLocation(JsonUtils.getString(lllllllllllllIlIlIlIllIlIIIlIIIl, "biome"));
                lllllllllllllIlIlIlIllIlIIIIlIlI = Biome.REGISTRY.getObject(lllllllllllllIlIlIlIllIlIIIIlIIl);
                if (lllllllllllllIlIlIlIllIlIIIIlIlI == null) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown biome '").append(lllllllllllllIlIlIlIllIlIIIIlIIl).append("'")));
                }
            }
            return new LocationPredicate(lllllllllllllIlIlIlIllIlIIIIllll, lllllllllllllIlIlIlIllIlIIIIlllI, lllllllllllllIlIlIlIllIlIIIIllIl, lllllllllllllIlIlIlIllIlIIIIlIlI, lllllllllllllIlIlIlIllIlIIIIlIll, lllllllllllllIlIlIlIllIlIIIIllII);
        }
        return LocationPredicate.field_193455_a;
    }
    
    public boolean func_193452_a(final WorldServer lllllllllllllIlIlIlIllIlIIllIlll, final double lllllllllllllIlIlIlIllIlIIllIllI, final double lllllllllllllIlIlIlIllIlIIllIlIl, final double lllllllllllllIlIlIlIllIlIIlIllll) {
        return this.func_193453_a(lllllllllllllIlIlIlIllIlIIllIlll, (float)lllllllllllllIlIlIlIllIlIIllIllI, (float)lllllllllllllIlIlIlIllIlIIllIlIl, (float)lllllllllllllIlIlIlIllIlIIlIllll);
    }
}
