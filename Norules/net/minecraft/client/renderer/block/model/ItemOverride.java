package net.minecraft.client.renderer.block.model;

import java.util.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.gson.*;
import com.google.common.collect.*;

public class ItemOverride
{
    private final /* synthetic */ ResourceLocation location;
    private final /* synthetic */ Map<ResourceLocation, Float> mapResourceValues;
    
    boolean matchesItemStack(final ItemStack lllllllllllllllllIlIIlIlIIIlIlll, @Nullable final World lllllllllllllllllIlIIlIlIIIlIllI, @Nullable final EntityLivingBase lllllllllllllllllIlIIlIlIIIlIlIl) {
        final Item lllllllllllllllllIlIIlIlIIIllIll = lllllllllllllllllIlIIlIlIIIlIlll.getItem();
        for (final Map.Entry<ResourceLocation, Float> lllllllllllllllllIlIIlIlIIIllIlI : this.mapResourceValues.entrySet()) {
            final IItemPropertyGetter lllllllllllllllllIlIIlIlIIIllIIl = lllllllllllllllllIlIIlIlIIIllIll.getPropertyGetter(lllllllllllllllllIlIIlIlIIIllIlI.getKey());
            if (lllllllllllllllllIlIIlIlIIIllIIl == null || lllllllllllllllllIlIIlIlIIIllIIl.apply(lllllllllllllllllIlIIlIlIIIlIlll, lllllllllllllllllIlIIlIlIIIlIllI, lllllllllllllllllIlIIlIlIIIlIlIl) < lllllllllllllllllIlIIlIlIIIllIlI.getValue()) {
                return false;
            }
        }
        return true;
    }
    
    public ResourceLocation getLocation() {
        return this.location;
    }
    
    public ItemOverride(final ResourceLocation lllllllllllllllllIlIIlIlIIlIllll, final Map<ResourceLocation, Float> lllllllllllllllllIlIIlIlIIlIlIll) {
        this.location = lllllllllllllllllIlIIlIlIIlIllll;
        this.mapResourceValues = lllllllllllllllllIlIIlIlIIlIlIll;
    }
    
    static class Deserializer implements JsonDeserializer<ItemOverride>
    {
        public ItemOverride deserialize(final JsonElement lllllllllllllIIIlIIIIlIIlIIIIIII, final Type lllllllllllllIIIlIIIIlIIlIIIIllI, final JsonDeserializationContext lllllllllllllIIIlIIIIlIIlIIIIlIl) throws JsonParseException {
            final JsonObject lllllllllllllIIIlIIIIlIIlIIIIlII = lllllllllllllIIIlIIIIlIIlIIIIIII.getAsJsonObject();
            final ResourceLocation lllllllllllllIIIlIIIIlIIlIIIIIll = new ResourceLocation(JsonUtils.getString(lllllllllllllIIIlIIIIlIIlIIIIlII, "model"));
            final Map<ResourceLocation, Float> lllllllllllllIIIlIIIIlIIlIIIIIlI = this.makeMapResourceValues(lllllllllllllIIIlIIIIlIIlIIIIlII);
            return new ItemOverride(lllllllllllllIIIlIIIIlIIlIIIIIll, lllllllllllllIIIlIIIIlIIlIIIIIlI);
        }
        
        protected Map<ResourceLocation, Float> makeMapResourceValues(final JsonObject lllllllllllllIIIlIIIIlIIIlllIllI) {
            final Map<ResourceLocation, Float> lllllllllllllIIIlIIIIlIIIlllIlIl = (Map<ResourceLocation, Float>)Maps.newLinkedHashMap();
            final JsonObject lllllllllllllIIIlIIIIlIIIlllIlII = JsonUtils.getJsonObject(lllllllllllllIIIlIIIIlIIIlllIllI, "predicate");
            for (final Map.Entry<String, JsonElement> lllllllllllllIIIlIIIIlIIIlllIIll : lllllllllllllIIIlIIIIlIIIlllIlII.entrySet()) {
                lllllllllllllIIIlIIIIlIIIlllIlIl.put(new ResourceLocation(lllllllllllllIIIlIIIIlIIIlllIIll.getKey()), JsonUtils.getFloat(lllllllllllllIIIlIIIIlIIIlllIIll.getValue(), lllllllllllllIIIlIIIIlIIIlllIIll.getKey()));
            }
            return lllllllllllllIIIlIIIIlIIIlllIlIl;
        }
    }
}
