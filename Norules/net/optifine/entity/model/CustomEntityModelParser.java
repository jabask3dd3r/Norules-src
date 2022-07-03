package net.optifine.entity.model;

import net.minecraft.util.*;
import java.util.*;
import java.io.*;
import com.google.gson.*;
import net.optifine.entity.model.anim.*;
import optifine.*;
import net.minecraft.client.model.*;

public class CustomEntityModelParser
{
    public static ResourceLocation getResourceLocation(final String llllllllllllllIIIlIllIIIlIIIlIlI, String llllllllllllllIIIlIllIIIlIIIllII, final String llllllllllllllIIIlIllIIIlIIIlIll) {
        if (!llllllllllllllIIIlIllIIIlIIIllII.endsWith(llllllllllllllIIIlIllIIIlIIIlIll)) {
            llllllllllllllIIIlIllIIIlIIIllII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIllIIIlIIIllII)).append(llllllllllllllIIIlIllIIIlIIIlIll));
        }
        if (!llllllllllllllIIIlIllIIIlIIIllII.contains("/")) {
            llllllllllllllIIIlIllIIIlIIIllII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIllIIIlIIIlIlI)).append("/").append(llllllllllllllIIIlIllIIIlIIIllII));
        }
        else if (llllllllllllllIIIlIllIIIlIIIllII.startsWith("./")) {
            llllllllllllllIIIlIllIIIlIIIllII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIllIIIlIIIlIlI)).append("/").append(llllllllllllllIIIlIllIIIlIIIllII.substring(2)));
        }
        else if (llllllllllllllIIIlIllIIIlIIIllII.startsWith("~/")) {
            llllllllllllllIIIlIllIIIlIIIllII = String.valueOf(new StringBuilder("optifine/").append(llllllllllllllIIIlIllIIIlIIIllII.substring(2)));
        }
        return new ResourceLocation(llllllllllllllIIIlIllIIIlIIIllII);
    }
    
    public static CustomEntityRenderer parseEntityRender(final JsonObject llllllllllllllIIIlIllIIIllIllIIl, final String llllllllllllllIIIlIllIIIllIllIII) {
        final ConnectedParser llllllllllllllIIIlIllIIIllIlIlll = new ConnectedParser("CustomEntityModels");
        final String llllllllllllllIIIlIllIIIllIlIllI = llllllllllllllIIIlIllIIIllIlIlll.parseName(llllllllllllllIIIlIllIIIllIllIII);
        final String llllllllllllllIIIlIllIIIllIlIlIl = llllllllllllllIIIlIllIIIllIlIlll.parseBasePath(llllllllllllllIIIlIllIIIllIllIII);
        final String llllllllllllllIIIlIllIIIllIlIlII = Json.getString(llllllllllllllIIIlIllIIIllIllIIl, "texture");
        final int[] llllllllllllllIIIlIllIIIllIlIIll = Json.parseIntArray(llllllllllllllIIIlIllIIIllIllIIl.get("textureSize"), 2);
        final float llllllllllllllIIIlIllIIIllIlIIlI = Json.getFloat(llllllllllllllIIIlIllIIIllIllIIl, "shadowSize", -1.0f);
        final JsonArray llllllllllllllIIIlIllIIIllIlIIIl = (JsonArray)llllllllllllllIIIlIllIIIllIllIIl.get("models");
        checkNull(llllllllllllllIIIlIllIIIllIlIIIl, "Missing models");
        final Map llllllllllllllIIIlIllIIIllIlIIII = new HashMap();
        final List llllllllllllllIIIlIllIIIllIIllll = new ArrayList();
        for (int llllllllllllllIIIlIllIIIllIIlllI = 0; llllllllllllllIIIlIllIIIllIIlllI < llllllllllllllIIIlIllIIIllIlIIIl.size(); ++llllllllllllllIIIlIllIIIllIIlllI) {
            final JsonObject llllllllllllllIIIlIllIIIllIIllIl = (JsonObject)llllllllllllllIIIlIllIIIllIlIIIl.get(llllllllllllllIIIlIllIIIllIIlllI);
            processBaseId(llllllllllllllIIIlIllIIIllIIllIl, llllllllllllllIIIlIllIIIllIlIIII);
            processExternalModel(llllllllllllllIIIlIllIIIllIIllIl, llllllllllllllIIIlIllIIIllIlIIII, llllllllllllllIIIlIllIIIllIlIlIl);
            processId(llllllllllllllIIIlIllIIIllIIllIl, llllllllllllllIIIlIllIIIllIlIIII);
            final CustomModelRenderer llllllllllllllIIIlIllIIIllIIllII = parseCustomModelRenderer(llllllllllllllIIIlIllIIIllIIllIl, llllllllllllllIIIlIllIIIllIlIIll, llllllllllllllIIIlIllIIIllIlIlIl);
            if (llllllllllllllIIIlIllIIIllIIllII != null) {
                llllllllllllllIIIlIllIIIllIIllll.add(llllllllllllllIIIlIllIIIllIIllII);
            }
        }
        final CustomModelRenderer[] llllllllllllllIIIlIllIIIllIIlIll = llllllllllllllIIIlIllIIIllIIllll.toArray(new CustomModelRenderer[llllllllllllllIIIlIllIIIllIIllll.size()]);
        ResourceLocation llllllllllllllIIIlIllIIIllIIlIlI = null;
        if (llllllllllllllIIIlIllIIIllIlIlII != null) {
            llllllllllllllIIIlIllIIIllIIlIlI = getResourceLocation(llllllllllllllIIIlIllIIIllIlIlIl, llllllllllllllIIIlIllIIIllIlIlII, ".png");
        }
        final CustomEntityRenderer llllllllllllllIIIlIllIIIllIIlIIl = new CustomEntityRenderer(llllllllllllllIIIlIllIIIllIlIllI, llllllllllllllIIIlIllIIIllIlIlIl, llllllllllllllIIIlIllIIIllIIlIlI, llllllllllllllIIIlIllIIIllIIlIll, llllllllllllllIIIlIllIIIllIlIIlI);
        return llllllllllllllIIIlIllIIIllIIlIIl;
    }
    
    private static void checkNull(final Object llllllllllllllIIIlIllIIIIlIIlIII, final String llllllllllllllIIIlIllIIIIlIIIlll) {
        if (llllllllllllllIIIlIllIIIIlIIlIII == null) {
            throw new JsonParseException(llllllllllllllIIIlIllIIIIlIIIlll);
        }
    }
    
    public static JsonObject loadJson(final ResourceLocation llllllllllllllIIIlIllIIIIIllllII) throws IOException, JsonParseException {
        final InputStream llllllllllllllIIIlIllIIIIlIIIIII = Config.getResourceStream(llllllllllllllIIIlIllIIIIIllllII);
        if (llllllllllllllIIIlIllIIIIlIIIIII == null) {
            return null;
        }
        final String llllllllllllllIIIlIllIIIIIllllll = Config.readInputStream(llllllllllllllIIIlIllIIIIlIIIIII, "ASCII");
        llllllllllllllIIIlIllIIIIlIIIIII.close();
        final JsonParser llllllllllllllIIIlIllIIIIIlllllI = new JsonParser();
        final JsonObject llllllllllllllIIIlIllIIIIIllllIl = (JsonObject)llllllllllllllIIIlIllIIIIIlllllI.parse(llllllllllllllIIIlIllIIIIIllllll);
        return llllllllllllllIIIlIllIIIIIllllIl;
    }
    
    public static CustomModelRenderer parseCustomModelRenderer(final JsonObject llllllllllllllIIIlIllIIIIlIlllII, final int[] llllllllllllllIIIlIllIIIIlIllIll, final String llllllllllllllIIIlIllIIIIlIllIlI) {
        final String llllllllllllllIIIlIllIIIIllIlIll = Json.getString(llllllllllllllIIIlIllIIIIlIlllII, "part");
        checkNull(llllllllllllllIIIlIllIIIIllIlIll, "Model part not specified, missing \"replace\" or \"attachTo\".");
        final boolean llllllllllllllIIIlIllIIIIllIlIlI = Json.getBoolean(llllllllllllllIIIlIllIIIIlIlllII, "attach", false);
        final ModelBase llllllllllllllIIIlIllIIIIllIlIIl = new CustomEntityModel();
        if (llllllllllllllIIIlIllIIIIlIllIll != null) {
            llllllllllllllIIIlIllIIIIllIlIIl.textureWidth = llllllllllllllIIIlIllIIIIlIllIll[0];
            llllllllllllllIIIlIllIIIIllIlIIl.textureHeight = llllllllllllllIIIlIllIIIIlIllIll[1];
        }
        ModelUpdater llllllllllllllIIIlIllIIIIllIlIII = null;
        final JsonArray llllllllllllllIIIlIllIIIIllIIlll = (JsonArray)llllllllllllllIIIlIllIIIIlIlllII.get("animations");
        if (llllllllllllllIIIlIllIIIIllIIlll != null) {
            final List<ModelVariableUpdater> llllllllllllllIIIlIllIIIIllIIllI = new ArrayList<ModelVariableUpdater>();
            for (int llllllllllllllIIIlIllIIIIllIIlIl = 0; llllllllllllllIIIlIllIIIIllIIlIl < llllllllllllllIIIlIllIIIIllIIlll.size(); ++llllllllllllllIIIlIllIIIIllIIlIl) {
                final JsonObject llllllllllllllIIIlIllIIIIllIIlII = (JsonObject)llllllllllllllIIIlIllIIIIllIIlll.get(llllllllllllllIIIlIllIIIIllIIlIl);
                for (final Map.Entry<String, JsonElement> llllllllllllllIIIlIllIIIIllIIIll : llllllllllllllIIIlIllIIIIllIIlII.entrySet()) {
                    final String llllllllllllllIIIlIllIIIIllIIIlI = llllllllllllllIIIlIllIIIIllIIIll.getKey();
                    final String llllllllllllllIIIlIllIIIIllIIIIl = llllllllllllllIIIlIllIIIIllIIIll.getValue().getAsString();
                    final ModelVariableUpdater llllllllllllllIIIlIllIIIIllIIIII = new ModelVariableUpdater(llllllllllllllIIIlIllIIIIllIIIlI, llllllllllllllIIIlIllIIIIllIIIIl);
                    llllllllllllllIIIlIllIIIIllIIllI.add(llllllllllllllIIIlIllIIIIllIIIII);
                }
            }
            if (llllllllllllllIIIlIllIIIIllIIllI.size() > 0) {
                final ModelVariableUpdater[] llllllllllllllIIIlIllIIIIlIlllll = llllllllllllllIIIlIllIIIIllIIllI.toArray(new ModelVariableUpdater[llllllllllllllIIIlIllIIIIllIIllI.size()]);
                llllllllllllllIIIlIllIIIIllIlIII = new ModelUpdater(llllllllllllllIIIlIllIIIIlIlllll);
            }
        }
        final ModelRenderer llllllllllllllIIIlIllIIIIlIllllI = PlayerItemParser.parseModelRenderer(llllllllllllllIIIlIllIIIIlIlllII, llllllllllllllIIIlIllIIIIllIlIIl, llllllllllllllIIIlIllIIIIlIllIll, llllllllllllllIIIlIllIIIIlIllIlI);
        final CustomModelRenderer llllllllllllllIIIlIllIIIIlIlllIl = new CustomModelRenderer(llllllllllllllIIIlIllIIIIllIlIll, llllllllllllllIIIlIllIIIIllIlIlI, llllllllllllllIIIlIllIIIIlIllllI, llllllllllllllIIIlIllIIIIllIlIII);
        return llllllllllllllIIIlIllIIIIlIlllIl;
    }
    
    private static void processExternalModel(final JsonObject llllllllllllllIIIlIllIIIlIlIIIII, final Map llllllllllllllIIIlIllIIIlIlIlIII, final String llllllllllllllIIIlIllIIIlIlIIlll) {
        final String llllllllllllllIIIlIllIIIlIlIIllI = Json.getString(llllllllllllllIIIlIllIIIlIlIIIII, "model");
        if (llllllllllllllIIIlIllIIIlIlIIllI != null) {
            final ResourceLocation llllllllllllllIIIlIllIIIlIlIIlIl = getResourceLocation(llllllllllllllIIIlIllIIIlIlIIlll, llllllllllllllIIIlIllIIIlIlIIllI, ".jpm");
            try {
                final JsonObject llllllllllllllIIIlIllIIIlIlIIlII = loadJson(llllllllllllllIIIlIllIIIlIlIIlIl);
                if (llllllllllllllIIIlIllIIIlIlIIlII == null) {
                    Config.warn(String.valueOf(new StringBuilder("Model not found: ").append(llllllllllllllIIIlIllIIIlIlIIlIl)));
                    return;
                }
                copyJsonElements(llllllllllllllIIIlIllIIIlIlIIlII, llllllllllllllIIIlIllIIIlIlIIIII);
            }
            catch (IOException llllllllllllllIIIlIllIIIlIlIIIll) {
                Config.error(String.valueOf(new StringBuilder().append(llllllllllllllIIIlIllIIIlIlIIIll.getClass().getName()).append(": ").append(llllllllllllllIIIlIllIIIlIlIIIll.getMessage())));
            }
            catch (JsonParseException llllllllllllllIIIlIllIIIlIlIIIlI) {
                Config.error(String.valueOf(new StringBuilder().append(llllllllllllllIIIlIllIIIlIlIIIlI.getClass().getName()).append(": ").append(llllllllllllllIIIlIllIIIlIlIIIlI.getMessage())));
            }
            catch (Exception llllllllllllllIIIlIllIIIlIlIIIIl) {
                llllllllllllllIIIlIllIIIlIlIIIIl.printStackTrace();
            }
        }
    }
    
    private static void processBaseId(final JsonObject llllllllllllllIIIlIllIIIlIllIllI, final Map llllllllllllllIIIlIllIIIlIllIlIl) {
        final String llllllllllllllIIIlIllIIIlIllIlII = Json.getString(llllllllllllllIIIlIllIIIlIllIllI, "baseId");
        if (llllllllllllllIIIlIllIIIlIllIlII != null) {
            final JsonObject llllllllllllllIIIlIllIIIlIllIIll = llllllllllllllIIIlIllIIIlIllIlIl.get(llllllllllllllIIIlIllIIIlIllIlII);
            if (llllllllllllllIIIlIllIIIlIllIIll == null) {
                Config.warn(String.valueOf(new StringBuilder("BaseID not found: ").append(llllllllllllllIIIlIllIIIlIllIlII)));
            }
            else {
                copyJsonElements(llllllllllllllIIIlIllIIIlIllIIll, llllllllllllllIIIlIllIIIlIllIllI);
            }
        }
    }
    
    private static void processId(final JsonObject llllllllllllllIIIlIllIIIlIIIIlII, final Map llllllllllllllIIIlIllIIIlIIIIIII) {
        final String llllllllllllllIIIlIllIIIlIIIIIlI = Json.getString(llllllllllllllIIIlIllIIIlIIIIlII, "id");
        if (llllllllllllllIIIlIllIIIlIIIIIlI != null) {
            if (llllllllllllllIIIlIllIIIlIIIIIlI.length() < 1) {
                Config.warn(String.valueOf(new StringBuilder("Empty model ID: ").append(llllllllllllllIIIlIllIIIlIIIIIlI)));
            }
            else if (llllllllllllllIIIlIllIIIlIIIIIII.containsKey(llllllllllllllIIIlIllIIIlIIIIIlI)) {
                Config.warn(String.valueOf(new StringBuilder("Duplicate model ID: ").append(llllllllllllllIIIlIllIIIlIIIIIlI)));
            }
            else {
                llllllllllllllIIIlIllIIIlIIIIIII.put(llllllllllllllIIIlIllIIIlIIIIIlI, llllllllllllllIIIlIllIIIlIIIIlII);
            }
        }
    }
    
    static {
        ENTITY = "entity";
        MODEL_PART = "part";
        BOX_COORDINATES = "coordinates";
        MODEL_TYPE = "type";
        MODEL_MIRROR_TEXTURE = "mirrorTexture";
        MODEL_ATTACH = "attach";
        SHADOW_SIZE = "shadowSize";
        ITEM_ANIMATIONS = "animations";
        MODEL_BASE_ID = "baseId";
        ENTITY_MODEL = "EntityModel";
        MODEL_TRANSLATE = "translate";
        MODEL_SCALE = "scale";
        MODEL_BOXES = "boxes";
        MODEL_SUBMODEL = "submodel";
        ITEM_TEXTURE_SIZE = "textureSize";
        ENTITY_MODEL_PART = "EntityModelPart";
        ITEM_USE_PLAYER_TEXTURE = "usePlayerTexture";
        MODEL_ID = "id";
        MODEL_ROTATE = "rotate";
        MODEL_SPRITES = "sprites";
        BOX_SIZE_ADD = "sizeAdd";
        MODEL_SUBMODELS = "submodels";
        TEXTURE = "texture";
        MODEL_MODEL = "model";
        MODEL_INVERT_AXIS = "invertAxis";
        ITEM_MODELS = "models";
        ITEM_TYPE = "type";
        BOX_TEXTURE_OFFSET = "textureOffset";
    }
    
    private static void copyJsonElements(final JsonObject llllllllllllllIIIlIllIIIlIIlIlll, final JsonObject llllllllllllllIIIlIllIIIlIIlIllI) {
        for (final Map.Entry<String, JsonElement> llllllllllllllIIIlIllIIIlIIlIlIl : llllllllllllllIIIlIllIIIlIIlIlll.entrySet()) {
            if (!llllllllllllllIIIlIllIIIlIIlIlIl.getKey().equals("id") && !llllllllllllllIIIlIllIIIlIIlIllI.has((String)llllllllllllllIIIlIllIIIlIIlIlIl.getKey())) {
                llllllllllllllIIIlIllIIIlIIlIllI.add((String)llllllllllllllIIIlIllIIIlIIlIlIl.getKey(), (JsonElement)llllllllllllllIIIlIllIIIlIIlIlIl.getValue());
            }
        }
    }
}
