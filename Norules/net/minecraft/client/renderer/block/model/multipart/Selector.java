package net.minecraft.client.renderer.block.model.multipart;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.block.state.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.common.annotations.*;
import java.lang.reflect.*;
import com.google.gson.*;
import javax.annotation.*;

public class Selector
{
    private final /* synthetic */ VariantList variantList;
    private final /* synthetic */ ICondition condition;
    
    public VariantList getVariantList() {
        return this.variantList;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIlIIIIlllIllIIlIl) {
        if (this == lllllllllllllIlIlIIIIlllIllIIlIl) {
            return true;
        }
        if (lllllllllllllIlIlIIIIlllIllIIlIl instanceof Selector) {
            final Selector lllllllllllllIlIlIIIIlllIllIIlII = (Selector)lllllllllllllIlIlIIIIlllIllIIlIl;
            if (this.condition.equals(lllllllllllllIlIlIIIIlllIllIIlII.condition)) {
                return this.variantList.equals(lllllllllllllIlIlIIIIlllIllIIlII.variantList);
            }
        }
        return false;
    }
    
    public Predicate<IBlockState> getPredicate(final BlockStateContainer lllllllllllllIlIlIIIIlllIlllllII) {
        return this.condition.getPredicate(lllllllllllllIlIlIIIIlllIlllllII);
    }
    
    @Override
    public int hashCode() {
        return 31 * this.condition.hashCode() + this.variantList.hashCode();
    }
    
    public Selector(final ICondition lllllllllllllIlIlIIIIllllIIlIIlI, final VariantList lllllllllllllIlIlIIIIllllIIlIlIl) {
        if (lllllllllllllIlIlIIIIllllIIlIIlI == null) {
            throw new IllegalArgumentException("Missing condition for selector");
        }
        if (lllllllllllllIlIlIIIIllllIIlIlIl == null) {
            throw new IllegalArgumentException("Missing variant for selector");
        }
        this.condition = lllllllllllllIlIlIIIIllllIIlIIlI;
        this.variantList = lllllllllllllIlIlIIIIllllIIlIlIl;
    }
    
    public static class Deserializer implements JsonDeserializer<Selector>
    {
        private static final /* synthetic */ Function<JsonElement, ICondition> FUNCTION_OR_AND;
        private static final /* synthetic */ Function<Map.Entry<String, JsonElement>, ICondition> FUNCTION_PROPERTY_VALUE;
        
        private static ConditionPropertyValue makePropertyValue(final Map.Entry<String, JsonElement> lllllllllllllllIIIIIlIIllIlIIIll) {
            return new ConditionPropertyValue(lllllllllllllllIIIIIlIIllIlIIIll.getKey(), lllllllllllllllIIIIIlIIllIlIIIll.getValue().getAsString());
        }
        
        @VisibleForTesting
        static ICondition getOrAndCondition(final JsonObject lllllllllllllllIIIIIlIIllIlIlIII) {
            final Set<Map.Entry<String, JsonElement>> lllllllllllllllIIIIIlIIllIlIIlll = (Set<Map.Entry<String, JsonElement>>)lllllllllllllllIIIIIlIIllIlIlIII.entrySet();
            if (lllllllllllllllIIIIIlIIllIlIIlll.isEmpty()) {
                throw new JsonParseException("No elements found in selector");
            }
            if (lllllllllllllllIIIIIlIIllIlIIlll.size() != 1) {
                return new ConditionAnd(Iterables.transform((Iterable)lllllllllllllllIIIIIlIIllIlIIlll, (Function)Deserializer.FUNCTION_PROPERTY_VALUE));
            }
            if (lllllllllllllllIIIIIlIIllIlIlIII.has("OR")) {
                return new ConditionOr(Iterables.transform((Iterable)JsonUtils.getJsonArray(lllllllllllllllIIIIIlIIllIlIlIII, "OR"), (Function)Deserializer.FUNCTION_OR_AND));
            }
            return lllllllllllllllIIIIIlIIllIlIlIII.has("AND") ? new ConditionAnd(Iterables.transform((Iterable)JsonUtils.getJsonArray(lllllllllllllllIIIIIlIIllIlIlIII, "AND"), (Function)Deserializer.FUNCTION_OR_AND)) : makePropertyValue(lllllllllllllllIIIIIlIIllIlIIlll.iterator().next());
        }
        
        private ICondition getWhenCondition(final JsonObject lllllllllllllllIIIIIlIIllIlIlIll) {
            return lllllllllllllllIIIIIlIIllIlIlIll.has("when") ? getOrAndCondition(JsonUtils.getJsonObject(lllllllllllllllIIIIIlIIllIlIlIll, "when")) : ICondition.TRUE;
        }
        
        public Selector deserialize(final JsonElement lllllllllllllllIIIIIlIIllIllIIIl, final Type lllllllllllllllIIIIIlIIllIllIlIl, final JsonDeserializationContext lllllllllllllllIIIIIlIIllIllIlII) throws JsonParseException {
            final JsonObject lllllllllllllllIIIIIlIIllIllIIll = lllllllllllllllIIIIIlIIllIllIIIl.getAsJsonObject();
            return new Selector(this.getWhenCondition(lllllllllllllllIIIIIlIIllIllIIll), (VariantList)lllllllllllllllIIIIIlIIllIllIlII.deserialize(lllllllllllllllIIIIIlIIllIllIIll.get("apply"), (Type)VariantList.class));
        }
        
        static {
            FUNCTION_OR_AND = (Function)new Function<JsonElement, ICondition>() {
                @Nullable
                public ICondition apply(@Nullable final JsonElement llllllllllllllIIlIIlIlIlIIlIlIlI) {
                    return (llllllllllllllIIlIIlIlIlIIlIlIlI == null) ? null : Deserializer.getOrAndCondition(llllllllllllllIIlIIlIlIlIIlIlIlI.getAsJsonObject());
                }
            };
            FUNCTION_PROPERTY_VALUE = (Function)new Function<Map.Entry<String, JsonElement>, ICondition>() {
                @Nullable
                public ICondition apply(@Nullable final Map.Entry<String, JsonElement> lllllllllllllllllllIlllIIIllIIIl) {
                    return (lllllllllllllllllllIlllIIIllIIIl == null) ? null : makePropertyValue(lllllllllllllllllllIlllIIIllIIIl);
                }
            };
        }
    }
}
