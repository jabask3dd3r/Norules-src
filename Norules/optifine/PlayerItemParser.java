package optifine;

import net.minecraft.client.model.*;
import net.optifine.entity.model.*;
import java.awt.*;
import com.google.gson.*;
import java.util.*;
import net.minecraft.util.*;

public class PlayerItemParser
{
    private static /* synthetic */ JsonParser jsonParser;
    
    private static int[][] parseFaceUvs(final JsonObject lllllllllllllIlIlIIIIIllllIlllll) {
        final int[][] lllllllllllllIlIlIIIIIllllIllllI = { Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvDown"), 4), Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvUp"), 4), Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvNorth"), 4), Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvSouth"), 4), Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvWest"), 4), Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvEast"), 4) };
        if (lllllllllllllIlIlIIIIIllllIllllI[2] == null) {
            lllllllllllllIlIlIIIIIllllIllllI[2] = Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvFront"), 4);
        }
        if (lllllllllllllIlIlIIIIIllllIllllI[3] == null) {
            lllllllllllllIlIlIIIIIllllIllllI[3] = Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvBack"), 4);
        }
        if (lllllllllllllIlIlIIIIIllllIllllI[4] == null) {
            lllllllllllllIlIlIIIIIllllIllllI[4] = Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvLeft"), 4);
        }
        if (lllllllllllllIlIlIIIIIllllIllllI[5] == null) {
            lllllllllllllIlIlIIIIIllllIllllI[5] = Json.parseIntArray(lllllllllllllIlIlIIIIIllllIlllll.get("uvRight"), 4);
        }
        boolean lllllllllllllIlIlIIIIIllllIlllIl = false;
        for (int lllllllllllllIlIlIIIIIllllIlllII = 0; lllllllllllllIlIlIIIIIllllIlllII < lllllllllllllIlIlIIIIIllllIllllI.length; ++lllllllllllllIlIlIIIIIllllIlllII) {
            if (lllllllllllllIlIlIIIIIllllIllllI[lllllllllllllIlIlIIIIIllllIlllII] != null) {
                lllllllllllllIlIlIIIIIllllIlllIl = true;
            }
        }
        if (!lllllllllllllIlIlIIIIIllllIlllIl) {
            return null;
        }
        return lllllllllllllIlIlIIIIIllllIllllI;
    }
    
    private static int parseAttachModel(final String lllllllllllllIlIlIIIIlIIIlIlIlll) {
        if (lllllllllllllIlIlIIIIlIIIlIlIlll == null) {
            return 0;
        }
        if (lllllllllllllIlIlIIIIlIIIlIlIlll.equals("body")) {
            return 0;
        }
        if (lllllllllllllIlIlIIIIlIIIlIlIlll.equals("head")) {
            return 1;
        }
        if (lllllllllllllIlIlIIIIlIIIlIlIlll.equals("leftArm")) {
            return 2;
        }
        if (lllllllllllllIlIlIIIIlIIIlIlIlll.equals("rightArm")) {
            return 3;
        }
        if (lllllllllllllIlIlIIIIlIIIlIlIlll.equals("leftLeg")) {
            return 4;
        }
        if (lllllllllllllIlIlIIIIlIIIlIlIlll.equals("rightLeg")) {
            return 5;
        }
        if (lllllllllllllIlIlIIIIlIIIlIlIlll.equals("cape")) {
            return 6;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown attachModel: ").append(lllllllllllllIlIlIIIIlIIIlIlIlll)));
        return 0;
    }
    
    static {
        MODEL_ID = "id";
        ITEM_TEXTURE_SIZE = "textureSize";
        MODEL_TRANSLATE = "translate";
        ITEM_USE_PLAYER_TEXTURE = "usePlayerTexture";
        BOX_UV_NORTH = "uvNorth";
        BOX_UV_BACK = "uvBack";
        MODEL_BOXES = "boxes";
        BOX_SIZE_ADD = "sizeAdd";
        MODEL_SUBMODEL = "submodel";
        MODEL_TEXTURE_SIZE = "textureSize";
        ITEM_MODELS = "models";
        MODEL_TYPE = "type";
        BOX_TEXTURE_OFFSET = "textureOffset";
        MODEL_SUBMODELS = "submodels";
        BOX_UV_WEST = "uvWest";
        MODEL_SCALE = "scale";
        MODEL_ROTATE = "rotate";
        ITEM_TYPE_MODEL = "PlayerItem";
        MODEL_TEXTURE = "texture";
        MODEL_TYPE_BOX = "ModelBox";
        ITEM_TYPE = "type";
        BOX_UV_RIGHT = "uvRight";
        MODEL_INVERT_AXIS = "invertAxis";
        MODEL_MIRROR_TEXTURE = "mirrorTexture";
        BOX_UV_SOUTH = "uvSouth";
        BOX_UV_DOWN = "uvDown";
        BOX_UV_EAST = "uvEast";
        MODEL_SPRITES = "sprites";
        BOX_UV_FRONT = "uvFront";
        BOX_UV_UP = "uvUp";
        BOX_COORDINATES = "coordinates";
        BOX_UV_LEFT = "uvLeft";
        MODEL_ATTACH_TO = "attachTo";
        MODEL_BASE_ID = "baseId";
        PlayerItemParser.jsonParser = new JsonParser();
    }
    
    public static ModelRenderer parseModelRenderer(final JsonObject lllllllllllllIlIlIIIIlIIIIlIIlII, final ModelBase lllllllllllllIlIlIIIIlIIIIlIIIll, final int[] lllllllllllllIlIlIIIIlIIIIlIIIlI, final String lllllllllllllIlIlIIIIIlllllllIlI) {
        final ModelRenderer lllllllllllllIlIlIIIIlIIIIlIIIII = new ModelRenderer(lllllllllllllIlIlIIIIlIIIIlIIIll);
        final String lllllllllllllIlIlIIIIlIIIIIlllll = Json.getString(lllllllllllllIlIlIIIIlIIIIlIIlII, "id");
        lllllllllllllIlIlIIIIlIIIIlIIIII.setId(lllllllllllllIlIlIIIIlIIIIIlllll);
        final float lllllllllllllIlIlIIIIlIIIIIllllI = Json.getFloat(lllllllllllllIlIlIIIIlIIIIlIIlII, "scale", 1.0f);
        lllllllllllllIlIlIIIIlIIIIlIIIII.scaleX = lllllllllllllIlIlIIIIlIIIIIllllI;
        lllllllllllllIlIlIIIIlIIIIlIIIII.scaleY = lllllllllllllIlIlIIIIlIIIIIllllI;
        lllllllllllllIlIlIIIIlIIIIlIIIII.scaleZ = lllllllllllllIlIlIIIIlIIIIIllllI;
        final String lllllllllllllIlIlIIIIlIIIIIlllIl = Json.getString(lllllllllllllIlIlIIIIlIIIIlIIlII, "texture");
        if (lllllllllllllIlIlIIIIlIIIIIlllIl != null) {
            lllllllllllllIlIlIIIIlIIIIlIIIII.setTextureLocation(CustomEntityModelParser.getResourceLocation(lllllllllllllIlIlIIIIIlllllllIlI, lllllllllllllIlIlIIIIlIIIIIlllIl, ".png"));
        }
        int[] lllllllllllllIlIlIIIIlIIIIIlllII = Json.parseIntArray(lllllllllllllIlIlIIIIlIIIIlIIlII.get("textureSize"), 2);
        if (lllllllllllllIlIlIIIIlIIIIIlllII == null) {
            lllllllllllllIlIlIIIIlIIIIIlllII = lllllllllllllIlIlIIIIlIIIIlIIIlI;
        }
        if (lllllllllllllIlIlIIIIlIIIIIlllII != null) {
            lllllllllllllIlIlIIIIlIIIIlIIIII.setTextureSize(lllllllllllllIlIlIIIIlIIIIIlllII[0], lllllllllllllIlIlIIIIlIIIIIlllII[1]);
        }
        final String lllllllllllllIlIlIIIIlIIIIIllIll = Json.getString(lllllllllllllIlIlIIIIlIIIIlIIlII, "invertAxis", "").toLowerCase();
        final boolean lllllllllllllIlIlIIIIlIIIIIllIlI = lllllllllllllIlIlIIIIlIIIIIllIll.contains("x");
        final boolean lllllllllllllIlIlIIIIlIIIIIllIIl = lllllllllllllIlIlIIIIlIIIIIllIll.contains("y");
        final boolean lllllllllllllIlIlIIIIlIIIIIllIII = lllllllllllllIlIlIIIIlIIIIIllIll.contains("z");
        final float[] lllllllllllllIlIlIIIIlIIIIIlIlll = Json.parseFloatArray(lllllllllllllIlIlIIIIlIIIIlIIlII.get("translate"), 3, new float[3]);
        if (lllllllllllllIlIlIIIIlIIIIIllIlI) {
            lllllllllllllIlIlIIIIlIIIIIlIlll[0] = -lllllllllllllIlIlIIIIlIIIIIlIlll[0];
        }
        if (lllllllllllllIlIlIIIIlIIIIIllIIl) {
            lllllllllllllIlIlIIIIlIIIIIlIlll[1] = -lllllllllllllIlIlIIIIlIIIIIlIlll[1];
        }
        if (lllllllllllllIlIlIIIIlIIIIIllIII) {
            lllllllllllllIlIlIIIIlIIIIIlIlll[2] = -lllllllllllllIlIlIIIIlIIIIIlIlll[2];
        }
        final float[] lllllllllllllIlIlIIIIlIIIIIlIllI = Json.parseFloatArray(lllllllllllllIlIlIIIIlIIIIlIIlII.get("rotate"), 3, new float[3]);
        for (int lllllllllllllIlIlIIIIlIIIIIlIlIl = 0; lllllllllllllIlIlIIIIlIIIIIlIlIl < lllllllllllllIlIlIIIIlIIIIIlIllI.length; ++lllllllllllllIlIlIIIIlIIIIIlIlIl) {
            lllllllllllllIlIlIIIIlIIIIIlIllI[lllllllllllllIlIlIIIIlIIIIIlIlIl] = lllllllllllllIlIlIIIIlIIIIIlIllI[lllllllllllllIlIlIIIIlIIIIIlIlIl] / 180.0f * 3.1415927f;
        }
        if (lllllllllllllIlIlIIIIlIIIIIllIlI) {
            lllllllllllllIlIlIIIIlIIIIIlIllI[0] = -lllllllllllllIlIlIIIIlIIIIIlIllI[0];
        }
        if (lllllllllllllIlIlIIIIlIIIIIllIIl) {
            lllllllllllllIlIlIIIIlIIIIIlIllI[1] = -lllllllllllllIlIlIIIIlIIIIIlIllI[1];
        }
        if (lllllllllllllIlIlIIIIlIIIIIllIII) {
            lllllllllllllIlIlIIIIlIIIIIlIllI[2] = -lllllllllllllIlIlIIIIlIIIIIlIllI[2];
        }
        lllllllllllllIlIlIIIIlIIIIlIIIII.setRotationPoint(lllllllllllllIlIlIIIIlIIIIIlIlll[0], lllllllllllllIlIlIIIIlIIIIIlIlll[1], lllllllllllllIlIlIIIIlIIIIIlIlll[2]);
        lllllllllllllIlIlIIIIlIIIIlIIIII.rotateAngleX = lllllllllllllIlIlIIIIlIIIIIlIllI[0];
        lllllllllllllIlIlIIIIlIIIIlIIIII.rotateAngleY = lllllllllllllIlIlIIIIlIIIIIlIllI[1];
        lllllllllllllIlIlIIIIlIIIIlIIIII.rotateAngleZ = lllllllllllllIlIlIIIIlIIIIIlIllI[2];
        final String lllllllllllllIlIlIIIIlIIIIIlIlII = Json.getString(lllllllllllllIlIlIIIIlIIIIlIIlII, "mirrorTexture", "").toLowerCase();
        final boolean lllllllllllllIlIlIIIIlIIIIIlIIll = lllllllllllllIlIlIIIIlIIIIIlIlII.contains("u");
        final boolean lllllllllllllIlIlIIIIlIIIIIlIIlI = lllllllllllllIlIlIIIIlIIIIIlIlII.contains("v");
        if (lllllllllllllIlIlIIIIlIIIIIlIIll) {
            lllllllllllllIlIlIIIIlIIIIlIIIII.mirror = true;
        }
        if (lllllllllllllIlIlIIIIlIIIIIlIIlI) {
            lllllllllllllIlIlIIIIlIIIIlIIIII.mirrorV = true;
        }
        final JsonArray lllllllllllllIlIlIIIIlIIIIIlIIIl = lllllllllllllIlIlIIIIlIIIIlIIlII.getAsJsonArray("boxes");
        if (lllllllllllllIlIlIIIIlIIIIIlIIIl != null) {
            for (int lllllllllllllIlIlIIIIlIIIIIlIIII = 0; lllllllllllllIlIlIIIIlIIIIIlIIII < lllllllllllllIlIlIIIIlIIIIIlIIIl.size(); ++lllllllllllllIlIlIIIIlIIIIIlIIII) {
                final JsonObject lllllllllllllIlIlIIIIlIIIIIIllll = lllllllllllllIlIlIIIIlIIIIIlIIIl.get(lllllllllllllIlIlIIIIlIIIIIlIIII).getAsJsonObject();
                final int[] lllllllllllllIlIlIIIIlIIIIIIlllI = Json.parseIntArray(lllllllllllllIlIlIIIIlIIIIIIllll.get("textureOffset"), 2);
                final int[][] lllllllllllllIlIlIIIIlIIIIIIllIl = parseFaceUvs(lllllllllllllIlIlIIIIlIIIIIIllll);
                if (lllllllllllllIlIlIIIIlIIIIIIlllI == null && lllllllllllllIlIlIIIIlIIIIIIllIl == null) {
                    throw new JsonParseException("Texture offset not specified");
                }
                final float[] lllllllllllllIlIlIIIIlIIIIIIllII = Json.parseFloatArray(lllllllllllllIlIlIIIIlIIIIIIllll.get("coordinates"), 6);
                if (lllllllllllllIlIlIIIIlIIIIIIllII == null) {
                    throw new JsonParseException("Coordinates not specified");
                }
                if (lllllllllllllIlIlIIIIlIIIIIllIlI) {
                    lllllllllllllIlIlIIIIlIIIIIIllII[0] = -lllllllllllllIlIlIIIIlIIIIIIllII[0] - lllllllllllllIlIlIIIIlIIIIIIllII[3];
                }
                if (lllllllllllllIlIlIIIIlIIIIIllIIl) {
                    lllllllllllllIlIlIIIIlIIIIIIllII[1] = -lllllllllllllIlIlIIIIlIIIIIIllII[1] - lllllllllllllIlIlIIIIlIIIIIIllII[4];
                }
                if (lllllllllllllIlIlIIIIlIIIIIllIII) {
                    lllllllllllllIlIlIIIIlIIIIIIllII[2] = -lllllllllllllIlIlIIIIlIIIIIIllII[2] - lllllllllllllIlIlIIIIlIIIIIIllII[5];
                }
                final float lllllllllllllIlIlIIIIlIIIIIIlIll = Json.getFloat(lllllllllllllIlIlIIIIlIIIIIIllll, "sizeAdd", 0.0f);
                if (lllllllllllllIlIlIIIIlIIIIIIllIl != null) {
                    lllllllllllllIlIlIIIIlIIIIlIIIII.addBox(lllllllllllllIlIlIIIIlIIIIIIllIl, lllllllllllllIlIlIIIIlIIIIIIllII[0], lllllllllllllIlIlIIIIlIIIIIIllII[1], lllllllllllllIlIlIIIIlIIIIIIllII[2], lllllllllllllIlIlIIIIlIIIIIIllII[3], lllllllllllllIlIlIIIIlIIIIIIllII[4], lllllllllllllIlIlIIIIlIIIIIIllII[5], lllllllllllllIlIlIIIIlIIIIIIlIll);
                }
                else {
                    lllllllllllllIlIlIIIIlIIIIlIIIII.setTextureOffset(lllllllllllllIlIlIIIIlIIIIIIlllI[0], lllllllllllllIlIlIIIIlIIIIIIlllI[1]);
                    lllllllllllllIlIlIIIIlIIIIlIIIII.addBox(lllllllllllllIlIlIIIIlIIIIIIllII[0], lllllllllllllIlIlIIIIlIIIIIIllII[1], lllllllllllllIlIlIIIIlIIIIIIllII[2], (int)lllllllllllllIlIlIIIIlIIIIIIllII[3], (int)lllllllllllllIlIlIIIIlIIIIIIllII[4], (int)lllllllllllllIlIlIIIIlIIIIIIllII[5], lllllllllllllIlIlIIIIlIIIIIIlIll);
                }
            }
        }
        final JsonArray lllllllllllllIlIlIIIIlIIIIIIlIlI = lllllllllllllIlIlIIIIlIIIIlIIlII.getAsJsonArray("sprites");
        if (lllllllllllllIlIlIIIIlIIIIIIlIlI != null) {
            for (int lllllllllllllIlIlIIIIlIIIIIIlIIl = 0; lllllllllllllIlIlIIIIlIIIIIIlIIl < lllllllllllllIlIlIIIIlIIIIIIlIlI.size(); ++lllllllllllllIlIlIIIIlIIIIIIlIIl) {
                final JsonObject lllllllllllllIlIlIIIIlIIIIIIlIII = lllllllllllllIlIlIIIIlIIIIIIlIlI.get(lllllllllllllIlIlIIIIlIIIIIIlIIl).getAsJsonObject();
                final int[] lllllllllllllIlIlIIIIlIIIIIIIlll = Json.parseIntArray(lllllllllllllIlIlIIIIlIIIIIIlIII.get("textureOffset"), 2);
                if (lllllllllllllIlIlIIIIlIIIIIIIlll == null) {
                    throw new JsonParseException("Texture offset not specified");
                }
                final float[] lllllllllllllIlIlIIIIlIIIIIIIllI = Json.parseFloatArray(lllllllllllllIlIlIIIIlIIIIIIlIII.get("coordinates"), 6);
                if (lllllllllllllIlIlIIIIlIIIIIIIllI == null) {
                    throw new JsonParseException("Coordinates not specified");
                }
                if (lllllllllllllIlIlIIIIlIIIIIllIlI) {
                    lllllllllllllIlIlIIIIlIIIIIIIllI[0] = -lllllllllllllIlIlIIIIlIIIIIIIllI[0] - lllllllllllllIlIlIIIIlIIIIIIIllI[3];
                }
                if (lllllllllllllIlIlIIIIlIIIIIllIIl) {
                    lllllllllllllIlIlIIIIlIIIIIIIllI[1] = -lllllllllllllIlIlIIIIlIIIIIIIllI[1] - lllllllllllllIlIlIIIIlIIIIIIIllI[4];
                }
                if (lllllllllllllIlIlIIIIlIIIIIllIII) {
                    lllllllllllllIlIlIIIIlIIIIIIIllI[2] = -lllllllllllllIlIlIIIIlIIIIIIIllI[2] - lllllllllllllIlIlIIIIlIIIIIIIllI[5];
                }
                final float lllllllllllllIlIlIIIIlIIIIIIIlIl = Json.getFloat(lllllllllllllIlIlIIIIlIIIIIIlIII, "sizeAdd", 0.0f);
                lllllllllllllIlIlIIIIlIIIIlIIIII.setTextureOffset(lllllllllllllIlIlIIIIlIIIIIIIlll[0], lllllllllllllIlIlIIIIlIIIIIIIlll[1]);
                lllllllllllllIlIlIIIIlIIIIlIIIII.addSprite(lllllllllllllIlIlIIIIlIIIIIIIllI[0], lllllllllllllIlIlIIIIlIIIIIIIllI[1], lllllllllllllIlIlIIIIlIIIIIIIllI[2], (int)lllllllllllllIlIlIIIIlIIIIIIIllI[3], (int)lllllllllllllIlIlIIIIlIIIIIIIllI[4], (int)lllllllllllllIlIlIIIIlIIIIIIIllI[5], lllllllllllllIlIlIIIIlIIIIIIIlIl);
            }
        }
        final JsonObject lllllllllllllIlIlIIIIlIIIIIIIlII = (JsonObject)lllllllllllllIlIlIIIIlIIIIlIIlII.get("submodel");
        if (lllllllllllllIlIlIIIIlIIIIIIIlII != null) {
            final ModelRenderer lllllllllllllIlIlIIIIlIIIIIIIIll = parseModelRenderer(lllllllllllllIlIlIIIIlIIIIIIIlII, lllllllllllllIlIlIIIIlIIIIlIIIll, lllllllllllllIlIlIIIIlIIIIIlllII, lllllllllllllIlIlIIIIIlllllllIlI);
            lllllllllllllIlIlIIIIlIIIIlIIIII.addChild(lllllllllllllIlIlIIIIlIIIIIIIIll);
        }
        final JsonArray lllllllllllllIlIlIIIIlIIIIIIIIlI = (JsonArray)lllllllllllllIlIlIIIIlIIIIlIIlII.get("submodels");
        if (lllllllllllllIlIlIIIIlIIIIIIIIlI != null) {
            for (int lllllllllllllIlIlIIIIlIIIIIIIIIl = 0; lllllllllllllIlIlIIIIlIIIIIIIIIl < lllllllllllllIlIlIIIIlIIIIIIIIlI.size(); ++lllllllllllllIlIlIIIIlIIIIIIIIIl) {
                final JsonObject lllllllllllllIlIlIIIIlIIIIIIIIII = (JsonObject)lllllllllllllIlIlIIIIlIIIIIIIIlI.get(lllllllllllllIlIlIIIIlIIIIIIIIIl);
                final ModelRenderer lllllllllllllIlIlIIIIIllllllllll = parseModelRenderer(lllllllllllllIlIlIIIIlIIIIIIIIII, lllllllllllllIlIlIIIIlIIIIlIIIll, lllllllllllllIlIlIIIIlIIIIIlllII, lllllllllllllIlIlIIIIIlllllllIlI);
                if (lllllllllllllIlIlIIIIIllllllllll.getId() != null) {
                    final ModelRenderer lllllllllllllIlIlIIIIIlllllllllI = lllllllllllllIlIlIIIIlIIIIlIIIII.getChild(lllllllllllllIlIlIIIIIllllllllll.getId());
                    if (lllllllllllllIlIlIIIIIlllllllllI != null) {
                        Config.warn(String.valueOf(new StringBuilder("Duplicate model ID: ").append(lllllllllllllIlIlIIIIIllllllllll.getId())));
                    }
                }
                lllllllllllllIlIlIIIIlIIIIlIIIII.addChild(lllllllllllllIlIlIIIIIllllllllll);
            }
        }
        return lllllllllllllIlIlIIIIlIIIIlIIIII;
    }
    
    private static void checkNull(final Object lllllllllllllIlIlIIIIlIIIllIlIIl, final String lllllllllllllIlIlIIIIlIIIllIlIII) {
        if (lllllllllllllIlIlIIIIlIIIllIlIIl == null) {
            throw new JsonParseException(lllllllllllllIlIlIIIIlIIIllIlIII);
        }
    }
    
    public static PlayerItemModel parseItemModel(final JsonObject lllllllllllllIlIlIIIIlIIIllllIIl) {
        final String lllllllllllllIlIlIIIIlIIlIIIlIII = Json.getString(lllllllllllllIlIlIIIIlIIIllllIIl, "type");
        if (!Config.equals(lllllllllllllIlIlIIIIlIIlIIIlIII, "PlayerItem")) {
            throw new JsonParseException(String.valueOf(new StringBuilder("Unknown model type: ").append(lllllllllllllIlIlIIIIlIIlIIIlIII)));
        }
        final int[] lllllllllllllIlIlIIIIlIIlIIIIlll = Json.parseIntArray(lllllllllllllIlIlIIIIlIIIllllIIl.get("textureSize"), 2);
        checkNull(lllllllllllllIlIlIIIIlIIlIIIIlll, "Missing texture size");
        final Dimension lllllllllllllIlIlIIIIlIIlIIIIllI = new Dimension(lllllllllllllIlIlIIIIlIIlIIIIlll[0], lllllllllllllIlIlIIIIlIIlIIIIlll[1]);
        final boolean lllllllllllllIlIlIIIIlIIlIIIIlIl = Json.getBoolean(lllllllllllllIlIlIIIIlIIIllllIIl, "usePlayerTexture", false);
        final JsonArray lllllllllllllIlIlIIIIlIIlIIIIlII = (JsonArray)lllllllllllllIlIlIIIIlIIIllllIIl.get("models");
        checkNull(lllllllllllllIlIlIIIIlIIlIIIIlII, "Missing elements");
        final Map lllllllllllllIlIlIIIIlIIlIIIIIll = new HashMap();
        final List lllllllllllllIlIlIIIIlIIlIIIIIlI = new ArrayList();
        new ArrayList();
        for (int lllllllllllllIlIlIIIIlIIlIIIIIIl = 0; lllllllllllllIlIlIIIIlIIlIIIIIIl < lllllllllllllIlIlIIIIlIIlIIIIlII.size(); ++lllllllllllllIlIlIIIIlIIlIIIIIIl) {
            final JsonObject lllllllllllllIlIlIIIIlIIlIIIIIII = (JsonObject)lllllllllllllIlIlIIIIlIIlIIIIlII.get(lllllllllllllIlIlIIIIlIIlIIIIIIl);
            final String lllllllllllllIlIlIIIIlIIIlllllll = Json.getString(lllllllllllllIlIlIIIIlIIlIIIIIII, "baseId");
            if (lllllllllllllIlIlIIIIlIIIlllllll != null) {
                final JsonObject lllllllllllllIlIlIIIIlIIIllllllI = lllllllllllllIlIlIIIIlIIlIIIIIll.get(lllllllllllllIlIlIIIIlIIIlllllll);
                if (lllllllllllllIlIlIIIIlIIIllllllI == null) {
                    Config.warn(String.valueOf(new StringBuilder("BaseID not found: ").append(lllllllllllllIlIlIIIIlIIIlllllll)));
                    continue;
                }
                for (final Map.Entry<String, JsonElement> lllllllllllllIlIlIIIIlIIIlllllIl : lllllllllllllIlIlIIIIlIIIllllllI.entrySet()) {
                    if (!lllllllllllllIlIlIIIIlIIlIIIIIII.has((String)lllllllllllllIlIlIIIIlIIIlllllIl.getKey())) {
                        lllllllllllllIlIlIIIIlIIlIIIIIII.add((String)lllllllllllllIlIlIIIIlIIIlllllIl.getKey(), (JsonElement)lllllllllllllIlIlIIIIlIIIlllllIl.getValue());
                    }
                }
            }
            final String lllllllllllllIlIlIIIIlIIIlllllII = Json.getString(lllllllllllllIlIlIIIIlIIlIIIIIII, "id");
            if (lllllllllllllIlIlIIIIlIIIlllllII != null) {
                if (!lllllllllllllIlIlIIIIlIIlIIIIIll.containsKey(lllllllllllllIlIlIIIIlIIIlllllII)) {
                    lllllllllllllIlIlIIIIlIIlIIIIIll.put(lllllllllllllIlIlIIIIlIIIlllllII, lllllllllllllIlIlIIIIlIIlIIIIIII);
                }
                else {
                    Config.warn(String.valueOf(new StringBuilder("Duplicate model ID: ").append(lllllllllllllIlIlIIIIlIIIlllllII)));
                }
            }
            final PlayerItemRenderer lllllllllllllIlIlIIIIlIIIllllIll = parseItemRenderer(lllllllllllllIlIlIIIIlIIlIIIIIII, lllllllllllllIlIlIIIIlIIlIIIIllI);
            if (lllllllllllllIlIlIIIIlIIIllllIll != null) {
                lllllllllllllIlIlIIIIlIIlIIIIIlI.add(lllllllllllllIlIlIIIIlIIIllllIll);
            }
        }
        final PlayerItemRenderer[] lllllllllllllIlIlIIIIlIIIllllIlI = lllllllllllllIlIlIIIIlIIlIIIIIlI.toArray(new PlayerItemRenderer[lllllllllllllIlIlIIIIlIIlIIIIIlI.size()]);
        return new PlayerItemModel(lllllllllllllIlIlIIIIlIIlIIIIllI, lllllllllllllIlIlIIIIlIIlIIIIlIl, lllllllllllllIlIlIIIIlIIIllllIlI);
    }
    
    private static ResourceLocation makeResourceLocation(final String lllllllllllllIlIlIIIIlIIIlIlllIl) {
        final int lllllllllllllIlIlIIIIlIIIllIIIII = lllllllllllllIlIlIIIIlIIIlIlllIl.indexOf(58);
        if (lllllllllllllIlIlIIIIlIIIllIIIII < 0) {
            return new ResourceLocation(lllllllllllllIlIlIIIIlIIIlIlllIl);
        }
        final String lllllllllllllIlIlIIIIlIIIlIlllll = lllllllllllllIlIlIIIIlIIIlIlllIl.substring(0, lllllllllllllIlIlIIIIlIIIllIIIII);
        final String lllllllllllllIlIlIIIIlIIIlIllllI = lllllllllllllIlIlIIIIlIIIlIlllIl.substring(lllllllllllllIlIlIIIIlIIIllIIIII + 1);
        return new ResourceLocation(lllllllllllllIlIlIIIIlIIIlIlllll, lllllllllllllIlIlIIIIlIIIlIllllI);
    }
    
    public static PlayerItemRenderer parseItemRenderer(final JsonObject lllllllllllllIlIlIIIIlIIIlIIlllI, final Dimension lllllllllllllIlIlIIIIlIIIlIIIlIl) {
        final String lllllllllllllIlIlIIIIlIIIlIIllII = Json.getString(lllllllllllllIlIlIIIIlIIIlIIlllI, "type");
        if (!Config.equals(lllllllllllllIlIlIIIIlIIIlIIllII, "ModelBox")) {
            Config.warn(String.valueOf(new StringBuilder("Unknown model type: ").append(lllllllllllllIlIlIIIIlIIIlIIllII)));
            return null;
        }
        final String lllllllllllllIlIlIIIIlIIIlIIlIll = Json.getString(lllllllllllllIlIlIIIIlIIIlIIlllI, "attachTo");
        final int lllllllllllllIlIlIIIIlIIIlIIlIlI = parseAttachModel(lllllllllllllIlIlIIIIlIIIlIIlIll);
        final ModelBase lllllllllllllIlIlIIIIlIIIlIIlIIl = new ModelPlayerItem();
        lllllllllllllIlIlIIIIlIIIlIIlIIl.textureWidth = lllllllllllllIlIlIIIIlIIIlIIIlIl.width;
        lllllllllllllIlIlIIIIlIIIlIIlIIl.textureHeight = lllllllllllllIlIlIIIIlIIIlIIIlIl.height;
        final ModelRenderer lllllllllllllIlIlIIIIlIIIlIIlIII = parseModelRenderer(lllllllllllllIlIlIIIIlIIIlIIlllI, lllllllllllllIlIlIIIIlIIIlIIlIIl, null, null);
        final PlayerItemRenderer lllllllllllllIlIlIIIIlIIIlIIIlll = new PlayerItemRenderer(lllllllllllllIlIlIIIIlIIIlIIlIlI, lllllllllllllIlIlIIIIlIIIlIIlIII);
        return lllllllllllllIlIlIIIIlIIIlIIIlll;
    }
}
