package net.minecraft.client.renderer.block.model;

import com.google.common.annotations.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.util.*;
import java.io.*;
import org.apache.logging.log4j.*;
import java.lang.reflect.*;
import com.google.gson.*;
import com.google.common.collect.*;

public class ModelBlock
{
    private final /* synthetic */ boolean ambientOcclusion;
    private final /* synthetic */ List<ItemOverride> overrides;
    public /* synthetic */ String name;
    private static final /* synthetic */ Logger LOGGER;
    @VisibleForTesting
    protected final /* synthetic */ Map<String, String> textures;
    private final /* synthetic */ List<BlockPart> elements;
    @VisibleForTesting
    protected /* synthetic */ ModelBlock parent;
    @VisibleForTesting
    protected /* synthetic */ ResourceLocation parentLocation;
    private final /* synthetic */ boolean gui3d;
    private final /* synthetic */ ItemCameraTransforms cameraTransforms;
    @VisibleForTesting
    static final /* synthetic */ Gson SERIALIZER;
    
    public ItemCameraTransforms getAllTransforms() {
        final ItemTransformVec3f llllllllllllllIIIllllllllIllIlII = this.getTransform(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND);
        final ItemTransformVec3f llllllllllllllIIIllllllllIllIIll = this.getTransform(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND);
        final ItemTransformVec3f llllllllllllllIIIllllllllIllIIlI = this.getTransform(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND);
        final ItemTransformVec3f llllllllllllllIIIllllllllIllIIIl = this.getTransform(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND);
        final ItemTransformVec3f llllllllllllllIIIllllllllIllIIII = this.getTransform(ItemCameraTransforms.TransformType.HEAD);
        final ItemTransformVec3f llllllllllllllIIIllllllllIlIllll = this.getTransform(ItemCameraTransforms.TransformType.GUI);
        final ItemTransformVec3f llllllllllllllIIIllllllllIlIlllI = this.getTransform(ItemCameraTransforms.TransformType.GROUND);
        final ItemTransformVec3f llllllllllllllIIIllllllllIlIllIl = this.getTransform(ItemCameraTransforms.TransformType.FIXED);
        return new ItemCameraTransforms(llllllllllllllIIIllllllllIllIlII, llllllllllllllIIIllllllllIllIIll, llllllllllllllIIIllllllllIllIIlI, llllllllllllllIIIllllllllIllIIIl, llllllllllllllIIIllllllllIllIIII, llllllllllllllIIIllllllllIlIllll, llllllllllllllIIIllllllllIlIlllI, llllllllllllllIIIllllllllIlIllIl);
    }
    
    private ItemTransformVec3f getTransform(final ItemCameraTransforms.TransformType llllllllllllllIIIllllllllIlIIIII) {
        return (this.parent != null && !this.cameraTransforms.hasCustomTransform(llllllllllllllIIIllllllllIlIIIII)) ? this.parent.getTransform(llllllllllllllIIIllllllllIlIIIII) : this.cameraTransforms.getTransform(llllllllllllllIIIllllllllIlIIIII);
    }
    
    public boolean isGui3d() {
        return this.gui3d;
    }
    
    private boolean startsWithHash(final String llllllllllllllIIIlllllllllIIIlIl) {
        return llllllllllllllIIIlllllllllIIIlIl.charAt(0) == '#';
    }
    
    public void getParentFromMap(final Map<ResourceLocation, ModelBlock> llllllllllllllIIIlllllllllllIlII) {
        if (this.parentLocation != null) {
            this.parent = llllllllllllllIIIlllllllllllIlII.get(this.parentLocation);
        }
    }
    
    private boolean hasParent() {
        return this.parent != null;
    }
    
    public ModelBlock getRootModel() {
        return this.hasParent() ? this.parent.getRootModel() : this;
    }
    
    public static void checkModelHierarchy(final Map<ResourceLocation, ModelBlock> llllllllllllllIIIllllllllIIllIII) {
        for (final ModelBlock llllllllllllllIIIllllllllIIlIlll : llllllllllllllIIIllllllllIIllIII.values()) {
            try {
                for (ModelBlock llllllllllllllIIIllllllllIIlIllI = llllllllllllllIIIllllllllIIlIlll.parent, llllllllllllllIIIllllllllIIlIlIl = llllllllllllllIIIllllllllIIlIllI.parent; llllllllllllllIIIllllllllIIlIllI != llllllllllllllIIIllllllllIIlIlIl; llllllllllllllIIIllllllllIIlIllI = llllllllllllllIIIllllllllIIlIllI.parent, llllllllllllllIIIllllllllIIlIlIl = llllllllllllllIIIllllllllIIlIlIl.parent.parent) {}
                throw new LoopException();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    public ModelBlock(@Nullable final ResourceLocation llllllllllllllIIlIIIIIIIIIIlIlIl, final List<BlockPart> llllllllllllllIIlIIIIIIIIIIlIlII, final Map<String, String> llllllllllllllIIlIIIIIIIIIIIlIll, final boolean llllllllllllllIIlIIIIIIIIIIIlIlI, final boolean llllllllllllllIIlIIIIIIIIIIIlIIl, final ItemCameraTransforms llllllllllllllIIlIIIIIIIIIIlIIII, final List<ItemOverride> llllllllllllllIIlIIIIIIIIIIIllll) {
        this.name = "";
        this.elements = llllllllllllllIIlIIIIIIIIIIlIlII;
        this.ambientOcclusion = llllllllllllllIIlIIIIIIIIIIIlIlI;
        this.gui3d = llllllllllllllIIlIIIIIIIIIIIlIIl;
        this.textures = llllllllllllllIIlIIIIIIIIIIIlIll;
        this.parentLocation = llllllllllllllIIlIIIIIIIIIIlIlIl;
        this.cameraTransforms = llllllllllllllIIlIIIIIIIIIIlIIII;
        this.overrides = llllllllllllllIIlIIIIIIIIIIIllll;
    }
    
    public boolean isTexturePresent(final String llllllllllllllIIIlllllllllIllIll) {
        return !"missingno".equals(this.resolveTextureName(llllllllllllllIIIlllllllllIllIll));
    }
    
    @Nullable
    public ResourceLocation getParentLocation() {
        return this.parentLocation;
    }
    
    public List<BlockPart> getElements() {
        return (this.elements.isEmpty() && this.hasParent()) ? this.parent.getElements() : this.elements;
    }
    
    public String resolveTextureName(String llllllllllllllIIIlllllllllIlIlIl) {
        if (!this.startsWithHash(llllllllllllllIIIlllllllllIlIlIl)) {
            llllllllllllllIIIlllllllllIlIlIl = String.valueOf(new StringBuilder(String.valueOf('#')).append(llllllllllllllIIIlllllllllIlIlIl));
        }
        return this.resolveTextureName(llllllllllllllIIIlllllllllIlIlIl, new Bookkeep(this, null));
    }
    
    public static ModelBlock deserialize(final Reader llllllllllllllIIlIIIIIIIIIlIIIlI) {
        return JsonUtils.gsonDeserialize(ModelBlock.SERIALIZER, llllllllllllllIIlIIIIIIIIIlIIIlI, ModelBlock.class, false);
    }
    
    protected List<ItemOverride> getOverrides() {
        return this.overrides;
    }
    
    public boolean isResolved() {
        return this.parentLocation == null || (this.parent != null && this.parent.isResolved());
    }
    
    public Collection<ResourceLocation> getOverrideLocations() {
        final Set<ResourceLocation> llllllllllllllIIIllllllllllIllII = (Set<ResourceLocation>)Sets.newHashSet();
        for (final ItemOverride llllllllllllllIIIllllllllllIlIll : this.overrides) {
            llllllllllllllIIIllllllllllIllII.add(llllllllllllllIIIllllllllllIlIll.getLocation());
        }
        return llllllllllllllIIIllllllllllIllII;
    }
    
    public static ModelBlock deserialize(final String llllllllllllllIIlIIIIIIIIIlIIIII) {
        return deserialize(new StringReader(llllllllllllllIIlIIIIIIIIIlIIIII));
    }
    
    public boolean isAmbientOcclusion() {
        return this.hasParent() ? this.parent.isAmbientOcclusion() : this.ambientOcclusion;
    }
    
    private String resolveTextureName(final String llllllllllllllIIIlllllllllIIllll, final Bookkeep llllllllllllllIIIlllllllllIIlIlI) {
        if (!this.startsWithHash(llllllllllllllIIIlllllllllIIllll)) {
            return llllllllllllllIIIlllllllllIIllll;
        }
        if (this == llllllllllllllIIIlllllllllIIlIlI.modelExt) {
            ModelBlock.LOGGER.warn("Unable to resolve texture due to upward reference: {} in {}", (Object)llllllllllllllIIIlllllllllIIllll, (Object)this.name);
            return "missingno";
        }
        String llllllllllllllIIIlllllllllIIllIl = this.textures.get(llllllllllllllIIIlllllllllIIllll.substring(1));
        if (llllllllllllllIIIlllllllllIIllIl == null && this.hasParent()) {
            llllllllllllllIIIlllllllllIIllIl = this.parent.resolveTextureName(llllllllllllllIIIlllllllllIIllll, llllllllllllllIIIlllllllllIIlIlI);
        }
        llllllllllllllIIIlllllllllIIlIlI.modelExt = this;
        if (llllllllllllllIIIlllllllllIIllIl != null && this.startsWithHash(llllllllllllllIIIlllllllllIIllIl)) {
            llllllllllllllIIIlllllllllIIllIl = llllllllllllllIIIlllllllllIIlIlI.model.resolveTextureName(llllllllllllllIIIlllllllllIIllIl, llllllllllllllIIIlllllllllIIlIlI);
        }
        return (llllllllllllllIIIlllllllllIIllIl != null && !this.startsWithHash(llllllllllllllIIIlllllllllIIllIl)) ? llllllllllllllIIIlllllllllIIllIl : "missingno";
    }
    
    public ItemOverrideList createOverrides() {
        return this.overrides.isEmpty() ? ItemOverrideList.NONE : new ItemOverrideList(this.overrides);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        SERIALIZER = new GsonBuilder().registerTypeAdapter((Type)ModelBlock.class, (Object)new Deserializer()).registerTypeAdapter((Type)BlockPart.class, (Object)new BlockPart.Deserializer()).registerTypeAdapter((Type)BlockPartFace.class, (Object)new BlockPartFace.Deserializer()).registerTypeAdapter((Type)BlockFaceUV.class, (Object)new BlockFaceUV.Deserializer()).registerTypeAdapter((Type)ItemTransformVec3f.class, (Object)new ItemTransformVec3f.Deserializer()).registerTypeAdapter((Type)ItemCameraTransforms.class, (Object)new ItemCameraTransforms.Deserializer()).registerTypeAdapter((Type)ItemOverride.class, (Object)new ItemOverride.Deserializer()).create();
    }
    
    public static class Deserializer implements JsonDeserializer<ModelBlock>
    {
        private String getParent(final JsonObject llllllllllllllllIIlIllIIllIlIlll) {
            return JsonUtils.getString(llllllllllllllllIIlIllIIllIlIlll, "parent", "");
        }
        
        protected boolean getAmbientOcclusionEnabled(final JsonObject llllllllllllllllIIlIllIIllIlIIll) {
            return JsonUtils.getBoolean(llllllllllllllllIIlIllIIllIlIIll, "ambientocclusion", true);
        }
        
        protected List<ItemOverride> getItemOverrides(final JsonDeserializationContext llllllllllllllllIIlIllIIllllIIlI, final JsonObject llllllllllllllllIIlIllIIlllIllIl) {
            final List<ItemOverride> llllllllllllllllIIlIllIIllllIIII = (List<ItemOverride>)Lists.newArrayList();
            if (llllllllllllllllIIlIllIIlllIllIl.has("overrides")) {
                for (final JsonElement llllllllllllllllIIlIllIIlllIllll : JsonUtils.getJsonArray(llllllllllllllllIIlIllIIlllIllIl, "overrides")) {
                    llllllllllllllllIIlIllIIllllIIII.add((ItemOverride)llllllllllllllllIIlIllIIllllIIlI.deserialize(llllllllllllllllIIlIllIIlllIllll, (Type)ItemOverride.class));
                }
            }
            return llllllllllllllllIIlIllIIllllIIII;
        }
        
        protected List<BlockPart> getModelElements(final JsonDeserializationContext llllllllllllllllIIlIllIIllIIlIII, final JsonObject llllllllllllllllIIlIllIIllIIlIll) {
            final List<BlockPart> llllllllllllllllIIlIllIIllIIlIlI = (List<BlockPart>)Lists.newArrayList();
            if (llllllllllllllllIIlIllIIllIIlIll.has("elements")) {
                for (final JsonElement llllllllllllllllIIlIllIIllIIlIIl : JsonUtils.getJsonArray(llllllllllllllllIIlIllIIllIIlIll, "elements")) {
                    llllllllllllllllIIlIllIIllIIlIlI.add((BlockPart)llllllllllllllllIIlIllIIllIIlIII.deserialize(llllllllllllllllIIlIllIIllIIlIIl, (Type)BlockPart.class));
                }
            }
            return llllllllllllllllIIlIllIIllIIlIlI;
        }
        
        public ModelBlock deserialize(final JsonElement llllllllllllllllIIlIllIlIIIIllll, final Type llllllllllllllllIIlIllIlIIIIlllI, final JsonDeserializationContext llllllllllllllllIIlIllIlIIIIllIl) throws JsonParseException {
            final JsonObject llllllllllllllllIIlIllIlIIIIllII = llllllllllllllllIIlIllIlIIIIllll.getAsJsonObject();
            final List<BlockPart> llllllllllllllllIIlIllIlIIIIlIll = this.getModelElements(llllllllllllllllIIlIllIlIIIIllIl, llllllllllllllllIIlIllIlIIIIllII);
            final String llllllllllllllllIIlIllIlIIIIlIlI = this.getParent(llllllllllllllllIIlIllIlIIIIllII);
            final Map<String, String> llllllllllllllllIIlIllIlIIIIlIIl = this.getTextures(llllllllllllllllIIlIllIlIIIIllII);
            final boolean llllllllllllllllIIlIllIlIIIIlIII = this.getAmbientOcclusionEnabled(llllllllllllllllIIlIllIlIIIIllII);
            ItemCameraTransforms llllllllllllllllIIlIllIlIIIIIlll = ItemCameraTransforms.DEFAULT;
            if (llllllllllllllllIIlIllIlIIIIllII.has("display")) {
                final JsonObject llllllllllllllllIIlIllIlIIIIIllI = JsonUtils.getJsonObject(llllllllllllllllIIlIllIlIIIIllII, "display");
                llllllllllllllllIIlIllIlIIIIIlll = (ItemCameraTransforms)llllllllllllllllIIlIllIlIIIIllIl.deserialize((JsonElement)llllllllllllllllIIlIllIlIIIIIllI, (Type)ItemCameraTransforms.class);
            }
            final List<ItemOverride> llllllllllllllllIIlIllIlIIIIIlIl = this.getItemOverrides(llllllllllllllllIIlIllIlIIIIllIl, llllllllllllllllIIlIllIlIIIIllII);
            final ResourceLocation llllllllllllllllIIlIllIlIIIIIlII = llllllllllllllllIIlIllIlIIIIlIlI.isEmpty() ? null : new ResourceLocation(llllllllllllllllIIlIllIlIIIIlIlI);
            return new ModelBlock(llllllllllllllllIIlIllIlIIIIIlII, llllllllllllllllIIlIllIlIIIIlIll, llllllllllllllllIIlIllIlIIIIlIIl, llllllllllllllllIIlIllIlIIIIlIII, true, llllllllllllllllIIlIllIlIIIIIlll, llllllllllllllllIIlIllIlIIIIIlIl);
        }
        
        private Map<String, String> getTextures(final JsonObject llllllllllllllllIIlIllIIllIlllll) {
            final Map<String, String> llllllllllllllllIIlIllIIlllIIIlI = (Map<String, String>)Maps.newHashMap();
            if (llllllllllllllllIIlIllIIllIlllll.has("textures")) {
                final JsonObject llllllllllllllllIIlIllIIlllIIIIl = llllllllllllllllIIlIllIIllIlllll.getAsJsonObject("textures");
                for (final Map.Entry<String, JsonElement> llllllllllllllllIIlIllIIlllIIIII : llllllllllllllllIIlIllIIlllIIIIl.entrySet()) {
                    llllllllllllllllIIlIllIIlllIIIlI.put(llllllllllllllllIIlIllIIlllIIIII.getKey(), llllllllllllllllIIlIllIIlllIIIII.getValue().getAsString());
                }
            }
            return llllllllllllllllIIlIllIIlllIIIlI;
        }
    }
    
    public static class LoopException extends RuntimeException
    {
    }
    
    static final class Bookkeep
    {
        public final /* synthetic */ ModelBlock model;
        public /* synthetic */ ModelBlock modelExt;
        
        private Bookkeep() {
        }
    }
}
