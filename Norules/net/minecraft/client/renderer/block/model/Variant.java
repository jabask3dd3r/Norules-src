package net.minecraft.client.renderer.block.model;

import net.minecraft.util.*;
import java.lang.reflect.*;
import com.google.gson.*;

public class Variant
{
    private final /* synthetic */ boolean uvLock;
    private final /* synthetic */ int weight;
    private final /* synthetic */ ModelRotation rotation;
    private final /* synthetic */ ResourceLocation modelLocation;
    
    @Override
    public int hashCode() {
        int lllllllllllllllllIIllIllIIIlIIIl = this.modelLocation.hashCode();
        lllllllllllllllllIIllIllIIIlIIIl = 31 * lllllllllllllllllIIllIllIIIlIIIl + this.rotation.hashCode();
        lllllllllllllllllIIllIllIIIlIIIl = 31 * lllllllllllllllllIIllIllIIIlIIIl + Boolean.valueOf(this.uvLock).hashCode();
        lllllllllllllllllIIllIllIIIlIIIl = 31 * lllllllllllllllllIIllIllIIIlIIIl + this.weight;
        return lllllllllllllllllIIllIllIIIlIIIl;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllIIllIllIIIlIllI) {
        if (this == lllllllllllllllllIIllIllIIIlIllI) {
            return true;
        }
        if (!(lllllllllllllllllIIllIllIIIlIllI instanceof Variant)) {
            return false;
        }
        final Variant lllllllllllllllllIIllIllIIIllIII = (Variant)lllllllllllllllllIIllIllIIIlIllI;
        return this.modelLocation.equals(lllllllllllllllllIIllIllIIIllIII.modelLocation) && this.rotation == lllllllllllllllllIIllIllIIIllIII.rotation && this.uvLock == lllllllllllllllllIIllIllIIIllIII.uvLock && this.weight == lllllllllllllllllIIllIllIIIllIII.weight;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Variant{modelLocation=").append(this.modelLocation).append(", rotation=").append(this.rotation).append(", uvLock=").append(this.uvLock).append(", weight=").append(this.weight).append('}'));
    }
    
    public ModelRotation getRotation() {
        return this.rotation;
    }
    
    public boolean isUvLock() {
        return this.uvLock;
    }
    
    public ResourceLocation getModelLocation() {
        return this.modelLocation;
    }
    
    public Variant(final ResourceLocation lllllllllllllllllIIllIllIIllIlIl, final ModelRotation lllllllllllllllllIIllIllIIlIllll, final boolean lllllllllllllllllIIllIllIIllIIll, final int lllllllllllllllllIIllIllIIllIIlI) {
        this.modelLocation = lllllllllllllllllIIllIllIIllIlIl;
        this.rotation = lllllllllllllllllIIllIllIIlIllll;
        this.uvLock = lllllllllllllllllIIllIllIIllIIll;
        this.weight = lllllllllllllllllIIllIllIIllIIlI;
    }
    
    public static class Deserializer implements JsonDeserializer<Variant>
    {
        private boolean parseUvLock(final JsonObject llllllllllllllIlIIlIlIlIllIIlIll) {
            return JsonUtils.getBoolean(llllllllllllllIlIIlIlIlIllIIlIll, "uvlock", false);
        }
        
        protected int parseWeight(final JsonObject llllllllllllllIlIIlIlIlIlIllIIll) {
            final int llllllllllllllIlIIlIlIlIlIllIlII = JsonUtils.getInt(llllllllllllllIlIIlIlIlIlIllIIll, "weight", 1);
            if (llllllllllllllIlIIlIlIlIlIllIlII < 1) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid weight ").append(llllllllllllllIlIIlIlIlIlIllIlII).append(" found, expected integer >= 1")));
            }
            return llllllllllllllIlIIlIlIlIlIllIlII;
        }
        
        protected String getStringModel(final JsonObject llllllllllllllIlIIlIlIlIlIlllIIl) {
            return JsonUtils.getString(llllllllllllllIlIIlIlIlIlIlllIIl, "model");
        }
        
        public Variant deserialize(final JsonElement llllllllllllllIlIIlIlIlIllIllIlI, final Type llllllllllllllIlIIlIlIlIlllIIIlI, final JsonDeserializationContext llllllllllllllIlIIlIlIlIlllIIIIl) throws JsonParseException {
            final JsonObject llllllllllllllIlIIlIlIlIlllIIIII = llllllllllllllIlIIlIlIlIllIllIlI.getAsJsonObject();
            final String llllllllllllllIlIIlIlIlIllIlllll = this.getStringModel(llllllllllllllIlIIlIlIlIlllIIIII);
            final ModelRotation llllllllllllllIlIIlIlIlIllIllllI = this.parseModelRotation(llllllllllllllIlIIlIlIlIlllIIIII);
            final boolean llllllllllllllIlIIlIlIlIllIlllIl = this.parseUvLock(llllllllllllllIlIIlIlIlIlllIIIII);
            final int llllllllllllllIlIIlIlIlIllIlllII = this.parseWeight(llllllllllllllIlIIlIlIlIlllIIIII);
            return new Variant(this.getResourceLocationBlock(llllllllllllllIlIIlIlIlIllIlllll), llllllllllllllIlIIlIlIlIllIllllI, llllllllllllllIlIIlIlIlIllIlllIl, llllllllllllllIlIIlIlIlIllIlllII);
        }
        
        protected ModelRotation parseModelRotation(final JsonObject llllllllllllllIlIIlIlIlIllIIIIII) {
            final int llllllllllllllIlIIlIlIlIllIIIIll = JsonUtils.getInt(llllllllllllllIlIIlIlIlIllIIIIII, "x", 0);
            final int llllllllllllllIlIIlIlIlIllIIIIlI = JsonUtils.getInt(llllllllllllllIlIIlIlIlIllIIIIII, "y", 0);
            final ModelRotation llllllllllllllIlIIlIlIlIllIIIIIl = ModelRotation.getModelRotation(llllllllllllllIlIIlIlIlIllIIIIll, llllllllllllllIlIIlIlIlIllIIIIlI);
            if (llllllllllllllIlIIlIlIlIllIIIIIl == null) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid BlockModelRotation x: ").append(llllllllllllllIlIIlIlIlIllIIIIll).append(", y: ").append(llllllllllllllIlIIlIlIlIllIIIIlI)));
            }
            return llllllllllllllIlIIlIlIlIllIIIIIl;
        }
        
        private ResourceLocation getResourceLocationBlock(final String llllllllllllllIlIIlIlIlIllIIllll) {
            ResourceLocation llllllllllllllIlIIlIlIlIllIlIIII = new ResourceLocation(llllllllllllllIlIIlIlIlIllIIllll);
            llllllllllllllIlIIlIlIlIllIlIIII = new ResourceLocation(llllllllllllllIlIIlIlIlIllIlIIII.getResourceDomain(), String.valueOf(new StringBuilder("block/").append(llllllllllllllIlIIlIlIlIllIlIIII.getResourcePath())));
            return llllllllllllllIlIIlIlIlIllIlIIII;
        }
    }
}
