package net.minecraft.client.renderer.block.model;

import com.google.common.annotations.*;
import java.lang.reflect.*;
import net.minecraft.client.renderer.block.model.multipart.*;
import java.io.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import com.google.gson.*;
import javax.annotation.*;

public class ModelBlockDefinition
{
    private /* synthetic */ Multipart multipart;
    private final /* synthetic */ Map<String, VariantList> mapVariants;
    @VisibleForTesting
    static final /* synthetic */ Gson GSON;
    
    @Override
    public boolean equals(final Object llllllllllllllllIlllIIlIllllIIIl) {
        if (this == llllllllllllllllIlllIIlIllllIIIl) {
            return true;
        }
        if (llllllllllllllllIlllIIlIllllIIIl instanceof ModelBlockDefinition) {
            final ModelBlockDefinition llllllllllllllllIlllIIlIllllIIll = (ModelBlockDefinition)llllllllllllllllIlllIIlIllllIIIl;
            if (this.mapVariants.equals(llllllllllllllllIlllIIlIllllIIll.mapVariants)) {
                return this.hasMultipartData() ? this.multipart.equals(llllllllllllllllIlllIIlIllllIIll.multipart) : (!llllllllllllllllIlllIIlIllllIIll.hasMultipartData());
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.mapVariants.hashCode() + (this.hasMultipartData() ? this.multipart.hashCode() : 0);
    }
    
    static {
        GSON = new GsonBuilder().registerTypeAdapter((Type)ModelBlockDefinition.class, (Object)new Deserializer()).registerTypeAdapter((Type)Variant.class, (Object)new Variant.Deserializer()).registerTypeAdapter((Type)VariantList.class, (Object)new VariantList.Deserializer()).registerTypeAdapter((Type)Multipart.class, (Object)new Multipart.Deserializer()).registerTypeAdapter((Type)Selector.class, (Object)new Selector.Deserializer()).create();
    }
    
    public VariantList getVariant(final String llllllllllllllllIlllIIlIlllllIlI) {
        final VariantList llllllllllllllllIlllIIlIllllllII = this.mapVariants.get(llllllllllllllllIlllIIlIlllllIlI);
        if (llllllllllllllllIlllIIlIllllllII == null) {
            throw new MissingVariantException();
        }
        return llllllllllllllllIlllIIlIllllllII;
    }
    
    public ModelBlockDefinition(final List<ModelBlockDefinition> llllllllllllllllIlllIIllIIIIlIll) {
        this.mapVariants = (Map<String, VariantList>)Maps.newHashMap();
        ModelBlockDefinition llllllllllllllllIlllIIllIIIIlllI = null;
        for (final ModelBlockDefinition llllllllllllllllIlllIIllIIIIllIl : llllllllllllllllIlllIIllIIIIlIll) {
            if (llllllllllllllllIlllIIllIIIIllIl.hasMultipartData()) {
                this.mapVariants.clear();
                llllllllllllllllIlllIIllIIIIlllI = llllllllllllllllIlllIIllIIIIllIl;
            }
            this.mapVariants.putAll(llllllllllllllllIlllIIllIIIIllIl.mapVariants);
        }
        if (llllllllllllllllIlllIIllIIIIlllI != null) {
            this.multipart = llllllllllllllllIlllIIllIIIIlllI.multipart;
        }
    }
    
    public static ModelBlockDefinition parseFromReader(final Reader llllllllllllllllIlllIIllIIlIIIII) {
        return JsonUtils.func_193839_a(ModelBlockDefinition.GSON, llllllllllllllllIlllIIllIIlIIIII, ModelBlockDefinition.class);
    }
    
    public ModelBlockDefinition(final Map<String, VariantList> llllllllllllllllIlllIIllIIIllIlI, final Multipart llllllllllllllllIlllIIllIIIllIIl) {
        this.mapVariants = (Map<String, VariantList>)Maps.newHashMap();
        this.multipart = llllllllllllllllIlllIIllIIIllIIl;
        this.mapVariants.putAll(llllllllllllllllIlllIIllIIIllIlI);
    }
    
    public boolean hasMultipartData() {
        return this.multipart != null;
    }
    
    public boolean hasVariant(final String llllllllllllllllIlllIIllIIIIIlII) {
        return this.mapVariants.get(llllllllllllllllIlllIIllIIIIIlII) != null;
    }
    
    public Set<VariantList> getMultipartVariants() {
        final Set<VariantList> llllllllllllllllIlllIIlIlllIlIIl = (Set<VariantList>)Sets.newHashSet((Iterable)this.mapVariants.values());
        if (this.hasMultipartData()) {
            llllllllllllllllIlllIIlIlllIlIIl.addAll(this.multipart.getVariants());
        }
        return llllllllllllllllIlllIIlIlllIlIIl;
    }
    
    public Multipart getMultipartData() {
        return this.multipart;
    }
    
    public class MissingVariantException extends RuntimeException
    {
    }
    
    public static class Deserializer implements JsonDeserializer<ModelBlockDefinition>
    {
        protected Map<String, VariantList> parseMapVariants(final JsonDeserializationContext lllllllllllllIlllIlIlIlllllIIIll, final JsonObject lllllllllllllIlllIlIlIlllllIIIlI) {
            final Map<String, VariantList> lllllllllllllIlllIlIlIlllllIIllI = (Map<String, VariantList>)Maps.newHashMap();
            if (lllllllllllllIlllIlIlIlllllIIIlI.has("variants")) {
                final JsonObject lllllllllllllIlllIlIlIlllllIIlIl = JsonUtils.getJsonObject(lllllllllllllIlllIlIlIlllllIIIlI, "variants");
                for (final Map.Entry<String, JsonElement> lllllllllllllIlllIlIlIlllllIIlII : lllllllllllllIlllIlIlIlllllIIlIl.entrySet()) {
                    lllllllllllllIlllIlIlIlllllIIllI.put(lllllllllllllIlllIlIlIlllllIIlII.getKey(), (VariantList)lllllllllllllIlllIlIlIlllllIIIll.deserialize((JsonElement)lllllllllllllIlllIlIlIlllllIIlII.getValue(), (Type)VariantList.class));
                }
            }
            return lllllllllllllIlllIlIlIlllllIIllI;
        }
        
        @Nullable
        protected Multipart parseMultipart(final JsonDeserializationContext lllllllllllllIlllIlIlIllllIllIIl, final JsonObject lllllllllllllIlllIlIlIllllIlIlIl) {
            if (!lllllllllllllIlllIlIlIllllIlIlIl.has("multipart")) {
                return null;
            }
            final JsonArray lllllllllllllIlllIlIlIllllIlIlll = JsonUtils.getJsonArray(lllllllllllllIlllIlIlIllllIlIlIl, "multipart");
            return (Multipart)lllllllllllllIlllIlIlIllllIllIIl.deserialize((JsonElement)lllllllllllllIlllIlIlIllllIlIlll, (Type)Multipart.class);
        }
        
        public ModelBlockDefinition deserialize(final JsonElement lllllllllllllIlllIlIlIlllllllIll, final Type lllllllllllllIlllIlIlIlllllllIlI, final JsonDeserializationContext lllllllllllllIlllIlIlIlllllllIIl) throws JsonParseException {
            final JsonObject lllllllllllllIlllIlIlIlllllllIII = lllllllllllllIlllIlIlIlllllllIll.getAsJsonObject();
            final Map<String, VariantList> lllllllllllllIlllIlIlIllllllIlll = this.parseMapVariants(lllllllllllllIlllIlIlIlllllllIIl, lllllllllllllIlllIlIlIlllllllIII);
            final Multipart lllllllllllllIlllIlIlIllllllIllI = this.parseMultipart(lllllllllllllIlllIlIlIlllllllIIl, lllllllllllllIlllIlIlIlllllllIII);
            if (!lllllllllllllIlllIlIlIllllllIlll.isEmpty() || (lllllllllllllIlllIlIlIllllllIllI != null && !lllllllllllllIlllIlIlIllllllIllI.getVariants().isEmpty())) {
                return new ModelBlockDefinition(lllllllllllllIlllIlIlIllllllIlll, lllllllllllllIlllIlIlIllllllIllI);
            }
            throw new JsonParseException("Neither 'variants' nor 'multipart' found");
        }
    }
}
