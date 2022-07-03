package net.minecraft.client.renderer.block.model;

import java.util.*;
import java.lang.reflect.*;
import com.google.common.collect.*;
import com.google.gson.*;

public class VariantList
{
    private final /* synthetic */ List<Variant> variantList;
    
    @Override
    public int hashCode() {
        return this.variantList.hashCode();
    }
    
    @Override
    public boolean equals(final Object lIlIllllIllIl) {
        if (this == lIlIllllIllIl) {
            return true;
        }
        if (lIlIllllIllIl instanceof VariantList) {
            final VariantList lIlIllllIllll = (VariantList)lIlIllllIllIl;
            return this.variantList.equals(lIlIllllIllll.variantList);
        }
        return false;
    }
    
    public VariantList(final List<Variant> lIlIllllllIlI) {
        this.variantList = lIlIllllllIlI;
    }
    
    public List<Variant> getVariantList() {
        return this.variantList;
    }
    
    public static class Deserializer implements JsonDeserializer<VariantList>
    {
        public VariantList deserialize(final JsonElement llllllllllllllIlIIlIllIlIlIlllIl, final Type llllllllllllllIlIIlIllIlIlIlllII, final JsonDeserializationContext llllllllllllllIlIIlIllIlIlIllIll) throws JsonParseException {
            final List<Variant> llllllllllllllIlIIlIllIlIlIllIlI = (List<Variant>)Lists.newArrayList();
            if (llllllllllllllIlIIlIllIlIlIlllIl.isJsonArray()) {
                final JsonArray llllllllllllllIlIIlIllIlIlIllIIl = llllllllllllllIlIIlIllIlIlIlllIl.getAsJsonArray();
                if (llllllllllllllIlIIlIllIlIlIllIIl.size() == 0) {
                    throw new JsonParseException("Empty variant array");
                }
                for (final JsonElement llllllllllllllIlIIlIllIlIlIllIII : llllllllllllllIlIIlIllIlIlIllIIl) {
                    llllllllllllllIlIIlIllIlIlIllIlI.add((Variant)llllllllllllllIlIIlIllIlIlIllIll.deserialize(llllllllllllllIlIIlIllIlIlIllIII, (Type)Variant.class));
                }
            }
            else {
                llllllllllllllIlIIlIllIlIlIllIlI.add((Variant)llllllllllllllIlIIlIllIlIlIllIll.deserialize(llllllllllllllIlIIlIllIlIlIlllIl, (Type)Variant.class));
            }
            return new VariantList(llllllllllllllIlIIlIllIlIlIllIlI);
        }
    }
}
