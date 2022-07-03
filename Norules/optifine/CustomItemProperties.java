package optifine;

import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.block.model.*;
import java.util.*;

public class CustomItemProperties
{
    public /* synthetic */ Map<String, String> mapModels;
    public /* synthetic */ ResourceLocation textureLocation;
    private /* synthetic */ int textureHeight;
    public /* synthetic */ Map<String, IBakedModel> mapBakedModelsTexture;
    public /* synthetic */ Map mapSprites;
    public /* synthetic */ float duration;
    public /* synthetic */ Map mapTextureLocations;
    public /* synthetic */ String model;
    public /* synthetic */ String texture;
    public /* synthetic */ float rotation;
    public /* synthetic */ String basePath;
    public /* synthetic */ int[] items;
    public /* synthetic */ Map<String, String> mapTextures;
    public /* synthetic */ int blend;
    public /* synthetic */ TextureAtlasSprite sprite;
    public /* synthetic */ float speed;
    public /* synthetic */ RangeListInt enchantmentLevels;
    public /* synthetic */ RangeListInt damage;
    public /* synthetic */ RangeListInt stackSize;
    public /* synthetic */ String name;
    public /* synthetic */ boolean damagePercent;
    public /* synthetic */ int weight;
    public /* synthetic */ IBakedModel bakedModelFull;
    public /* synthetic */ int type;
    public /* synthetic */ Map<String, IBakedModel> mapBakedModelsFull;
    public /* synthetic */ IBakedModel bakedModelTexture;
    public /* synthetic */ int hand;
    public /* synthetic */ RangeListInt enchantmentIds;
    public /* synthetic */ int layer;
    public /* synthetic */ int damageMask;
    private /* synthetic */ int textureWidth;
    public /* synthetic */ NbtTagValue[] nbtTagValues;
    
    private static BakedQuad makeBakedQuad(final BlockPart lllllllllllllllIIllllIIIIIlIIIlI, final BlockPartFace lllllllllllllllIIllllIIIIIlIlIII, final TextureAtlasSprite lllllllllllllllIIllllIIIIIlIIIII, final EnumFacing lllllllllllllllIIllllIIIIIIlllll, final ModelRotation lllllllllllllllIIllllIIIIIIllllI, final boolean lllllllllllllllIIllllIIIIIIlllIl) {
        final FaceBakery lllllllllllllllIIllllIIIIIlIIIll = new FaceBakery();
        return lllllllllllllllIIllllIIIIIlIIIll.makeBakedQuad(lllllllllllllllIIllllIIIIIlIIIlI.positionFrom, lllllllllllllllIIllllIIIIIlIIIlI.positionTo, lllllllllllllllIIllllIIIIIlIlIII, lllllllllllllllIIllllIIIIIlIIIII, lllllllllllllllIIllllIIIIIIlllll, lllllllllllllllIIllllIIIIIIllllI, lllllllllllllllIIllllIIIIIlIIIlI.partRotation, lllllllllllllllIIllllIIIIIIlllIl, lllllllllllllllIIllllIIIIIlIIIlI.shade);
    }
    
    private static Map parseTextures(final Properties lllllllllllllllIIllllIIllllIIIIl, final String lllllllllllllllIIllllIIllllIlIII) {
        final String lllllllllllllllIIllllIIllllIIlll = "texture.";
        final Map lllllllllllllllIIllllIIllllIIllI = getMatchingProperties(lllllllllllllllIIllllIIllllIIIIl, lllllllllllllllIIllllIIllllIIlll);
        if (lllllllllllllllIIllllIIllllIIllI.size() <= 0) {
            return null;
        }
        final Set lllllllllllllllIIllllIIllllIIlIl = lllllllllllllllIIllllIIllllIIllI.keySet();
        final Map lllllllllllllllIIllllIIllllIIlII = new LinkedHashMap();
        for (final Object lllllllllllllllIIllllIIllllIIIll : lllllllllllllllIIllllIIllllIIlIl) {
            String lllllllllllllllIIllllIIllllIIIlI = lllllllllllllllIIllllIIllllIIllI.get(lllllllllllllllIIllllIIllllIIIll);
            lllllllllllllllIIllllIIllllIIIlI = fixTextureName(lllllllllllllllIIllllIIllllIIIlI, lllllllllllllllIIllllIIllllIlIII);
            lllllllllllllllIIllllIIllllIIlII.put(lllllllllllllllIIllllIIllllIIIll, lllllllllllllllIIllllIIllllIIIlI);
        }
        return lllllllllllllllIIllllIIllllIIlII;
    }
    
    private ResourceLocation getTextureLocation(final String lllllllllllllllIIllllIIIlllIlIII) {
        if (lllllllllllllllIIllllIIIlllIlIII == null) {
            return null;
        }
        final ResourceLocation lllllllllllllllIIllllIIIlllIlllI = new ResourceLocation(lllllllllllllllIIllllIIIlllIlIII);
        final String lllllllllllllllIIllllIIIlllIllIl = lllllllllllllllIIllllIIIlllIlllI.getResourceDomain();
        String lllllllllllllllIIllllIIIlllIllII = lllllllllllllllIIllllIIIlllIlllI.getResourcePath();
        if (!lllllllllllllllIIllllIIIlllIllII.contains("/")) {
            lllllllllllllllIIllllIIIlllIllII = String.valueOf(new StringBuilder("textures/items/").append(lllllllllllllllIIllllIIIlllIllII));
        }
        final String lllllllllllllllIIllllIIIlllIlIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIllllIIIlllIllII)).append(".png"));
        final ResourceLocation lllllllllllllllIIllllIIIlllIlIlI = new ResourceLocation(lllllllllllllllIIllllIIIlllIllIl, lllllllllllllllIIllllIIIlllIlIll);
        final boolean lllllllllllllllIIllllIIIlllIlIIl = Config.hasResource(lllllllllllllllIIllllIIIlllIlIlI);
        if (!lllllllllllllllIIllllIIIlllIlIIl) {
            Config.warn(String.valueOf(new StringBuilder("File not found: ").append(lllllllllllllllIIllllIIIlllIlIll)));
        }
        return lllllllllllllllIIllllIIIlllIlIlI;
    }
    
    private boolean isUseTint() {
        return true;
    }
    
    private String getMapTexture(final Map<String, String> lllllllllllllllIIllllIIIIlllIIII, final String lllllllllllllllIIllllIIIIllIllll, final String lllllllllllllllIIllllIIIIllIlllI) {
        if (lllllllllllllllIIllllIIIIlllIIII == null) {
            return lllllllllllllllIIllllIIIIllIlllI;
        }
        final String lllllllllllllllIIllllIIIIlllIIIl = lllllllllllllllIIllllIIIIlllIIII.get(lllllllllllllllIIllllIIIIllIllll);
        return (lllllllllllllllIIllllIIIIlllIIIl == null) ? lllllllllllllllIIllllIIIIllIlllI : lllllllllllllllIIllllIIIIlllIIIl;
    }
    
    private static String parseBasePath(final String lllllllllllllllIIllllIlIIlIIlIII) {
        final int lllllllllllllllIIllllIlIIlIIlIIl = lllllllllllllllIIllllIlIIlIIlIII.lastIndexOf(47);
        return (lllllllllllllllIIllllIlIIlIIlIIl < 0) ? "" : lllllllllllllllIIllllIlIIlIIlIII.substring(0, lllllllllllllllIIllllIlIIlIIlIIl);
    }
    
    private static String parseTexture(String lllllllllllllllIIllllIIlllllllIl, final String lllllllllllllllIIllllIlIIIIIlIIl, final String lllllllllllllllIIllllIIllllllIll, final String lllllllllllllllIIllllIIllllllIlI, final String lllllllllllllllIIllllIIllllllIIl, final int lllllllllllllllIIllllIIllllllIII, final Map<String, String> lllllllllllllllIIllllIlIIIIIIlII, final boolean lllllllllllllllIIllllIIlllllIllI) {
        if (lllllllllllllllIIllllIIlllllllIl == null) {
            lllllllllllllllIIllllIIlllllllIl = lllllllllllllllIIllllIlIIIIIlIIl;
        }
        if (lllllllllllllllIIllllIIlllllllIl == null) {
            lllllllllllllllIIllllIIlllllllIl = lllllllllllllllIIllllIIllllllIll;
        }
        if (lllllllllllllllIIllllIIlllllllIl != null) {
            final String lllllllllllllllIIllllIlIIIIIIIlI = ".png";
            if (lllllllllllllllIIllllIIlllllllIl.endsWith(lllllllllllllllIIllllIlIIIIIIIlI)) {
                lllllllllllllllIIllllIIlllllllIl = lllllllllllllllIIllllIIlllllllIl.substring(0, lllllllllllllllIIllllIIlllllllIl.length() - lllllllllllllllIIllllIlIIIIIIIlI.length());
            }
            lllllllllllllllIIllllIIlllllllIl = fixTextureName(lllllllllllllllIIllllIIlllllllIl, lllllllllllllllIIllllIIllllllIIl);
            return lllllllllllllllIIllllIIlllllllIl;
        }
        if (lllllllllllllllIIllllIIllllllIII == 3) {
            return null;
        }
        if (lllllllllllllllIIllllIlIIIIIIlII != null) {
            final String lllllllllllllllIIllllIlIIIIIIIIl = lllllllllllllllIIllllIlIIIIIIlII.get("texture.bow_standby");
            if (lllllllllllllllIIllllIlIIIIIIIIl != null) {
                return lllllllllllllllIIllllIlIIIIIIIIl;
            }
        }
        if (!lllllllllllllllIIllllIIlllllIllI) {
            return null;
        }
        String lllllllllllllllIIllllIlIIIIIIIII = lllllllllllllllIIllllIIllllllIlI;
        final int lllllllllllllllIIllllIIlllllllll = lllllllllllllllIIllllIIllllllIlI.lastIndexOf(47);
        if (lllllllllllllllIIllllIIlllllllll >= 0) {
            lllllllllllllllIIllllIlIIIIIIIII = lllllllllllllllIIllllIIllllllIlI.substring(lllllllllllllllIIllllIIlllllllll + 1);
        }
        final int lllllllllllllllIIllllIIllllllllI = lllllllllllllllIIllllIlIIIIIIIII.lastIndexOf(46);
        if (lllllllllllllllIIllllIIllllllllI >= 0) {
            lllllllllllllllIIllllIlIIIIIIIII = lllllllllllllllIIllllIlIIIIIIIII.substring(0, lllllllllllllllIIllllIIllllllllI);
        }
        lllllllllllllllIIllllIlIIIIIIIII = fixTextureName(lllllllllllllllIIllllIlIIIIIIIII, lllllllllllllllIIllllIIllllllIIl);
        return lllllllllllllllIIllllIlIIIIIIIII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.basePath).append("/").append(this.name).append(", type: ").append(this.type).append(", items: [").append(Config.arrayToString(this.items)).append("], textture: ").append(this.texture));
    }
    
    private int parseHand(String lllllllllllllllIIllllIIlIIIlllll) {
        if (lllllllllllllllIIllllIIlIIIlllll == null) {
            return 0;
        }
        lllllllllllllllIIllllIIlIIIlllll = lllllllllllllllIIllllIIlIIIlllll.toLowerCase();
        if (lllllllllllllllIIllllIIlIIIlllll.equals("any")) {
            return 0;
        }
        if (lllllllllllllllIIllllIIlIIIlllll.equals("main")) {
            return 1;
        }
        if (lllllllllllllllIIllllIIlIIIlllll.equals("off")) {
            return 2;
        }
        Config.warn(String.valueOf(new StringBuilder("Invalid hand: ").append(lllllllllllllllIIllllIIlIIIlllll)));
        return 0;
    }
    
    static {
        TYPE_ARMOR = 3;
        TYPE_ELYTRA = 4;
        TYPE_ITEM = 1;
        INVENTORY = "inventory";
        HAND_OFF = 2;
        TYPE_UNKNOWN = 0;
        HAND_ANY = 0;
        HAND_MAIN = 1;
        TYPE_ENCHANTMENT = 2;
    }
    
    private RangeInt parseRangeInt(String lllllllllllllllIIllllIIlIlIlIllI) {
        if (lllllllllllllllIIllllIIlIlIlIllI == null) {
            return null;
        }
        lllllllllllllllIIllllIIlIlIlIllI = lllllllllllllllIIllllIIlIlIlIllI.trim();
        final int lllllllllllllllIIllllIIlIlIlllll = lllllllllllllllIIllllIIlIlIlIllI.length() - lllllllllllllllIIllllIIlIlIlIllI.replace("-", "").length();
        if (lllllllllllllllIIllllIIlIlIlllll > 1) {
            Config.warn(String.valueOf(new StringBuilder("Invalid range: ").append(lllllllllllllllIIllllIIlIlIlIllI)));
            return null;
        }
        final String[] lllllllllllllllIIllllIIlIlIllllI = Config.tokenize(lllllllllllllllIIllllIIlIlIlIllI, "- ");
        final int[] lllllllllllllllIIllllIIlIlIlllIl = new int[lllllllllllllllIIllllIIlIlIllllI.length];
        for (int lllllllllllllllIIllllIIlIlIlllII = 0; lllllllllllllllIIllllIIlIlIlllII < lllllllllllllllIIllllIIlIlIllllI.length; ++lllllllllllllllIIllllIIlIlIlllII) {
            final String lllllllllllllllIIllllIIlIlIllIll = lllllllllllllllIIllllIIlIlIllllI[lllllllllllllllIIllllIIlIlIlllII];
            final int lllllllllllllllIIllllIIlIlIllIlI = Config.parseInt(lllllllllllllllIIllllIIlIlIllIll, -1);
            if (lllllllllllllllIIllllIIlIlIllIlI < 0) {
                Config.warn(String.valueOf(new StringBuilder("Invalid range: ").append(lllllllllllllllIIllllIIlIlIlIllI)));
                return null;
            }
            lllllllllllllllIIllllIIlIlIlllIl[lllllllllllllllIIllllIIlIlIlllII] = lllllllllllllllIIllllIIlIlIllIlI;
        }
        if (lllllllllllllllIIllllIIlIlIlllIl.length == 1) {
            final int lllllllllllllllIIllllIIlIlIllIIl = lllllllllllllllIIllllIIlIlIlllIl[0];
            if (lllllllllllllllIIllllIIlIlIlIllI.startsWith("-")) {
                return new RangeInt(0, lllllllllllllllIIllllIIlIlIllIIl);
            }
            if (lllllllllllllllIIllllIIlIlIlIllI.endsWith("-")) {
                return new RangeInt(lllllllllllllllIIllllIIlIlIllIIl, 65535);
            }
            return new RangeInt(lllllllllllllllIIllllIIlIlIllIIl, lllllllllllllllIIllllIIlIlIllIIl);
        }
        else {
            if (lllllllllllllllIIllllIIlIlIlllIl.length == 2) {
                final int lllllllllllllllIIllllIIlIlIllIII = Math.min(lllllllllllllllIIllllIIlIlIlllIl[0], lllllllllllllllIIllllIIlIlIlllIl[1]);
                final int lllllllllllllllIIllllIIlIlIlIlll = Math.max(lllllllllllllllIIllllIIlIlIlllIl[0], lllllllllllllllIIllllIIlIlIlllIl[1]);
                return new RangeInt(lllllllllllllllIIllllIIlIlIllIII, lllllllllllllllIIllllIIlIlIlIlll);
            }
            Config.warn(String.valueOf(new StringBuilder("Invalid range: ").append(lllllllllllllllIIllllIIlIlIlIllI)));
            return null;
        }
    }
    
    private RangeListInt parseRangeListInt(final String lllllllllllllllIIllllIIllIIIIIlI) {
        return this.parseRangeListInt(lllllllllllllllIIllllIIllIIIIIlI, null);
    }
    
    private static ModelBlock makeModelBlock(final String[] lllllllllllllllIIllllIIIIllIlIII) {
        final StringBuffer lllllllllllllllIIllllIIIIllIIlll = new StringBuffer();
        lllllllllllllllIIllllIIIIllIIlll.append("{\"parent\": \"builtin/generated\",\"textures\": {");
        for (int lllllllllllllllIIllllIIIIllIIllI = 0; lllllllllllllllIIllllIIIIllIIllI < lllllllllllllllIIllllIIIIllIlIII.length; ++lllllllllllllllIIllllIIIIllIIllI) {
            final String lllllllllllllllIIllllIIIIllIIlIl = lllllllllllllllIIllllIIIIllIlIII[lllllllllllllllIIllllIIIIllIIllI];
            if (lllllllllllllllIIllllIIIIllIIllI > 0) {
                lllllllllllllllIIllllIIIIllIIlll.append(", ");
            }
            lllllllllllllllIIllllIIIIllIIlll.append(String.valueOf(new StringBuilder("\"layer").append(lllllllllllllllIIllllIIIIllIIllI).append("\": \"").append(lllllllllllllllIIllllIIIIllIIlIl).append("\"")));
        }
        lllllllllllllllIIllllIIIIllIIlll.append("}}");
        final String lllllllllllllllIIllllIIIIllIIlII = lllllllllllllllIIllllIIIIllIIlll.toString();
        final ModelBlock lllllllllllllllIIllllIIIIllIIIll = ModelBlock.deserialize(lllllllllllllllIIllllIIIIllIIlII);
        return lllllllllllllllIIllllIIIIllIIIll;
    }
    
    private static ResourceLocation getModelLocation(final String lllllllllllllllIIlllIlllIIlIllIl) {
        return (Reflector.ModelLoader.exists() && !lllllllllllllllIIlllIlllIIlIllIl.startsWith("mcpatcher/") && !lllllllllllllllIIlllIlllIIlIllIl.startsWith("optifine/")) ? new ResourceLocation(String.valueOf(new StringBuilder("models/").append(lllllllllllllllIIlllIlllIIlIllIl))) : new ResourceLocation(lllllllllllllllIIlllIlllIIlIllIl);
    }
    
    private static String parseName(final String lllllllllllllllIIllllIlIIlIlIlII) {
        String lllllllllllllllIIllllIlIIlIlIIll = lllllllllllllllIIllllIlIIlIlIlII;
        final int lllllllllllllllIIllllIlIIlIlIIlI = lllllllllllllllIIllllIlIIlIlIlII.lastIndexOf(47);
        if (lllllllllllllllIIllllIlIIlIlIIlI >= 0) {
            lllllllllllllllIIllllIlIIlIlIIll = lllllllllllllllIIllllIlIIlIlIlII.substring(lllllllllllllllIIllllIlIIlIlIIlI + 1);
        }
        final int lllllllllllllllIIllllIlIIlIlIIIl = lllllllllllllllIIllllIlIIlIlIIll.lastIndexOf(46);
        if (lllllllllllllllIIllllIlIIlIlIIIl >= 0) {
            lllllllllllllllIIllllIlIIlIlIIll = lllllllllllllllIIllllIlIIlIlIIll.substring(0, lllllllllllllllIIllllIlIIlIlIIIl);
        }
        return lllllllllllllllIIllllIlIIlIlIIll;
    }
    
    public boolean isValid(final String lllllllllllllllIIllllIIlIIIllIIl) {
        if (this.name == null || this.name.length() <= 0) {
            Config.warn(String.valueOf(new StringBuilder("No name found: ").append(lllllllllllllllIIllllIIlIIIllIIl)));
            return false;
        }
        if (this.basePath == null) {
            Config.warn(String.valueOf(new StringBuilder("No base path found: ").append(lllllllllllllllIIllllIIlIIIllIIl)));
            return false;
        }
        if (this.type == 0) {
            Config.warn(String.valueOf(new StringBuilder("No type defined: ").append(lllllllllllllllIIllllIIlIIIllIIl)));
            return false;
        }
        if (this.type == 4 && this.items == null) {
            this.items = new int[] { Item.getIdFromItem(Items.ELYTRA) };
        }
        if (this.type == 1 || this.type == 3 || this.type == 4) {
            if (this.items == null) {
                this.items = this.detectItems();
            }
            if (this.items == null) {
                Config.warn(String.valueOf(new StringBuilder("No items defined: ").append(lllllllllllllllIIllllIIlIIIllIIl)));
                return false;
            }
        }
        if (this.texture == null && this.mapTextures == null && this.model == null && this.mapModels == null) {
            Config.warn(String.valueOf(new StringBuilder("No texture or model specified: ").append(lllllllllllllllIIllllIIlIIIllIIl)));
            return false;
        }
        if (this.type == 2 && this.enchantmentIds == null) {
            Config.warn(String.valueOf(new StringBuilder("No enchantmentIDs specified: ").append(lllllllllllllllIIllllIIlIIIllIIl)));
            return false;
        }
        return true;
    }
    
    private NbtTagValue[] parseNbtTagValues(final Properties lllllllllllllllIIllllIIlIIllllII) {
        final String lllllllllllllllIIllllIIlIlIIIlII = "nbt.";
        final Map lllllllllllllllIIllllIIlIlIIIIll = getMatchingProperties(lllllllllllllllIIllllIIlIIllllII, lllllllllllllllIIllllIIlIlIIIlII);
        if (lllllllllllllllIIllllIIlIlIIIIll.size() <= 0) {
            return null;
        }
        final List lllllllllllllllIIllllIIlIlIIIIlI = new ArrayList();
        for (final Object lllllllllllllllIIllllIIlIlIIIIIl : lllllllllllllllIIllllIIlIlIIIIll.keySet()) {
            final String lllllllllllllllIIllllIIlIlIIIIII = lllllllllllllllIIllllIIlIlIIIIll.get(lllllllllllllllIIllllIIlIlIIIIIl);
            final String lllllllllllllllIIllllIIlIIllllll = ((String)lllllllllllllllIIllllIIlIlIIIIIl).substring(lllllllllllllllIIllllIIlIlIIIlII.length());
            final NbtTagValue lllllllllllllllIIllllIIlIIlllllI = new NbtTagValue(lllllllllllllllIIllllIIlIIllllll, lllllllllllllllIIllllIIlIlIIIIII);
            lllllllllllllllIIllllIIlIlIIIIlI.add(lllllllllllllllIIllllIIlIIlllllI);
        }
        final NbtTagValue[] lllllllllllllllIIllllIIlIIllllIl = lllllllllllllllIIllllIIlIlIIIIlI.toArray(new NbtTagValue[lllllllllllllllIIllllIIlIlIIIIlI.size()]);
        return lllllllllllllllIIllllIIlIIllllIl;
    }
    
    private ResourceLocation getSpriteLocation(final ResourceLocation lllllllllllllllIIllllIIIllIllIlI) {
        String lllllllllllllllIIllllIIIllIlllII = lllllllllllllllIIllllIIIllIllIlI.getResourcePath();
        lllllllllllllllIIllllIIIllIlllII = StrUtils.removePrefix(lllllllllllllllIIllllIIIllIlllII, "textures/");
        lllllllllllllllIIllllIIIllIlllII = StrUtils.removeSuffix(lllllllllllllllIIllllIIIllIlllII, ".png");
        final ResourceLocation lllllllllllllllIIllllIIIllIllIll = new ResourceLocation(lllllllllllllllIIllllIIIllIllIlI.getResourceDomain(), lllllllllllllllIIllllIIIllIlllII);
        return lllllllllllllllIIllllIIIllIllIll;
    }
    
    public void loadModels(final ModelBakery lllllllllllllllIIlllIlllllIIlIll) {
        if (this.model != null) {
            loadItemModel(lllllllllllllllIIlllIlllllIIlIll, this.model);
        }
        if (this.type == 1 && this.mapModels != null) {
            for (final String lllllllllllllllIIlllIlllllIIlIlI : this.mapModels.keySet()) {
                final String lllllllllllllllIIlllIlllllIIlIIl = this.mapModels.get(lllllllllllllllIIlllIlllllIIlIlI);
                final String lllllllllllllllIIlllIlllllIIlIII = StrUtils.removePrefix(lllllllllllllllIIlllIlllllIIlIlI, "model.");
                if (lllllllllllllllIIlllIlllllIIlIII.startsWith("bow") || lllllllllllllllIIlllIlllllIIlIII.startsWith("fishing_rod")) {
                    loadItemModel(lllllllllllllllIIlllIlllllIIlIll, lllllllllllllllIIlllIlllllIIlIIl);
                }
            }
        }
    }
    
    private float parseFloat(String lllllllllllllllIIllllIIllIIIllIl, final float lllllllllllllllIIllllIIllIIIlIIl) {
        if (lllllllllllllllIIllllIIllIIIllIl == null) {
            return lllllllllllllllIIllllIIllIIIlIIl;
        }
        lllllllllllllllIIllllIIllIIIllIl = lllllllllllllllIIllllIIllIIIllIl.trim();
        final float lllllllllllllllIIllllIIllIIIlIll = Config.parseFloat(lllllllllllllllIIllllIIllIIIllIl, Float.MIN_VALUE);
        if (lllllllllllllllIIllllIIllIIIlIll == Float.MIN_VALUE) {
            Config.warn(String.valueOf(new StringBuilder("Invalid float: ").append(lllllllllllllllIIllllIIllIIIllIl)));
            return lllllllllllllllIIllllIIllIIIlIIl;
        }
        return lllllllllllllllIIllllIIllIIIlIll;
    }
    
    private static void loadItemModel(final ModelBakery lllllllllllllllIIlllIlllIlIlIIll, final String lllllllllllllllIIlllIlllIlIIIllI) {
        final ResourceLocation lllllllllllllllIIlllIlllIlIlIIIl = getModelLocation(lllllllllllllllIIlllIlllIlIIIllI);
        final ModelResourceLocation lllllllllllllllIIlllIlllIlIlIIII = new ModelResourceLocation(lllllllllllllllIIlllIlllIlIlIIIl, "inventory");
        if (Reflector.ModelLoader.exists()) {
            try {
                final Object lllllllllllllllIIlllIlllIlIIllll = Reflector.ModelLoader_VanillaLoader_INSTANCE.getValue();
                checkNull(lllllllllllllllIIlllIlllIlIIllll, "vanillaLoader is null");
                final Object lllllllllllllllIIlllIlllIlIIlllI = Reflector.call(lllllllllllllllIIlllIlllIlIIllll, Reflector.ModelLoader_VanillaLoader_loadModel, lllllllllllllllIIlllIlllIlIlIIII);
                checkNull(lllllllllllllllIIlllIlllIlIIlllI, "iModel is null");
                final Map lllllllllllllllIIlllIlllIlIIllIl = (Map)Reflector.getFieldValue(lllllllllllllllIIlllIlllIlIlIIll, Reflector.ModelLoader_stateModels);
                checkNull(lllllllllllllllIIlllIlllIlIIllIl, "stateModels is null");
                lllllllllllllllIIlllIlllIlIIllIl.put(lllllllllllllllIIlllIlllIlIlIIII, lllllllllllllllIIlllIlllIlIIlllI);
                final Set lllllllllllllllIIlllIlllIlIIllII = (Set)Reflector.ModelLoaderRegistry_textures.getValue();
                checkNull(lllllllllllllllIIlllIlllIlIIllII, "registryTextures is null");
                final Collection lllllllllllllllIIlllIlllIlIIlIlI = (Collection)Reflector.call(lllllllllllllllIIlllIlllIlIIlllI, Reflector.IModel_getTextures, new Object[0]);
                checkNull(lllllllllllllllIIlllIlllIlIIlIlI, "modelTextures is null");
                lllllllllllllllIIlllIlllIlIIllII.addAll(lllllllllllllllIIlllIlllIlIIlIlI);
            }
            catch (Exception lllllllllllllllIIlllIlllIlIIlIIl) {
                Config.warn(String.valueOf(new StringBuilder("Error registering model: ").append(lllllllllllllllIIlllIlllIlIlIIII).append(", ").append(lllllllllllllllIIlllIlllIlIIlIIl.getClass().getName()).append(": ").append(lllllllllllllllIIlllIlllIlIIlIIl.getMessage())));
            }
        }
        else {
            lllllllllllllllIIlllIlllIlIlIIll.loadItemModel(lllllllllllllllIIlllIlllIlIlIIIl.toString(), lllllllllllllllIIlllIlllIlIlIIII, lllllllllllllllIIlllIlllIlIlIIIl);
        }
    }
    
    private int parseInt(String lllllllllllllllIIllllIIllIIlIlll, final int lllllllllllllllIIllllIIllIIlIllI) {
        if (lllllllllllllllIIllllIIllIIlIlll == null) {
            return lllllllllllllllIIllllIIllIIlIllI;
        }
        lllllllllllllllIIllllIIllIIlIlll = lllllllllllllllIIllllIIllIIlIlll.trim();
        final int lllllllllllllllIIllllIIllIIlIlIl = Config.parseInt(lllllllllllllllIIllllIIllIIlIlll, Integer.MIN_VALUE);
        if (lllllllllllllllIIllllIIllIIlIlIl == Integer.MIN_VALUE) {
            Config.warn(String.valueOf(new StringBuilder("Invalid integer: ").append(lllllllllllllllIIllllIIllIIlIlll)));
            return lllllllllllllllIIllllIIllIIlIllI;
        }
        return lllllllllllllllIIllllIIllIIlIlIl;
    }
    
    private static IBakedModel bakeModel(final TextureMap lllllllllllllllIIllllIIIIlIIlllI, final ModelBlock lllllllllllllllIIllllIIIIlIIllIl, final boolean lllllllllllllllIIllllIIIIIlllllI) {
        final ModelRotation lllllllllllllllIIllllIIIIlIIlIll = ModelRotation.X0_Y0;
        final boolean lllllllllllllllIIllllIIIIlIIlIlI = false;
        final String lllllllllllllllIIllllIIIIlIIlIIl = lllllllllllllllIIllllIIIIlIIllIl.resolveTextureName("particle");
        final TextureAtlasSprite lllllllllllllllIIllllIIIIlIIlIII = lllllllllllllllIIllllIIIIlIIlllI.getAtlasSprite(new ResourceLocation(lllllllllllllllIIllllIIIIlIIlIIl).toString());
        final SimpleBakedModel.Builder lllllllllllllllIIllllIIIIlIIIlll = new SimpleBakedModel.Builder(lllllllllllllllIIllllIIIIlIIllIl, lllllllllllllllIIllllIIIIlIIllIl.createOverrides()).setTexture(lllllllllllllllIIllllIIIIlIIlIII);
        for (final BlockPart lllllllllllllllIIllllIIIIlIIIllI : lllllllllllllllIIllllIIIIlIIllIl.getElements()) {
            for (final EnumFacing lllllllllllllllIIllllIIIIlIIIlIl : lllllllllllllllIIllllIIIIlIIIllI.mapFaces.keySet()) {
                BlockPartFace lllllllllllllllIIllllIIIIlIIIlII = lllllllllllllllIIllllIIIIlIIIllI.mapFaces.get(lllllllllllllllIIllllIIIIlIIIlIl);
                if (!lllllllllllllllIIllllIIIIIlllllI) {
                    lllllllllllllllIIllllIIIIlIIIlII = new BlockPartFace(lllllllllllllllIIllllIIIIlIIIlII.cullFace, -1, lllllllllllllllIIllllIIIIlIIIlII.texture, lllllllllllllllIIllllIIIIlIIIlII.blockFaceUV);
                }
                final String lllllllllllllllIIllllIIIIlIIIIll = lllllllllllllllIIllllIIIIlIIllIl.resolveTextureName(lllllllllllllllIIllllIIIIlIIIlII.texture);
                final TextureAtlasSprite lllllllllllllllIIllllIIIIlIIIIlI = lllllllllllllllIIllllIIIIlIIlllI.getAtlasSprite(new ResourceLocation(lllllllllllllllIIllllIIIIlIIIIll).toString());
                final BakedQuad lllllllllllllllIIllllIIIIlIIIIIl = makeBakedQuad(lllllllllllllllIIllllIIIIlIIIllI, lllllllllllllllIIllllIIIIlIIIlII, lllllllllllllllIIllllIIIIlIIIIlI, lllllllllllllllIIllllIIIIlIIIlIl, lllllllllllllllIIllllIIIIlIIlIll, lllllllllllllllIIllllIIIIlIIlIlI);
                if (lllllllllllllllIIllllIIIIlIIIlII.cullFace == null) {
                    lllllllllllllllIIllllIIIIlIIIlll.addGeneralQuad(lllllllllllllllIIllllIIIIlIIIIIl);
                }
                else {
                    lllllllllllllllIIllllIIIIlIIIlll.addFaceQuad(lllllllllllllllIIllllIIIIlIIlIll.rotateFace(lllllllllllllllIIllllIIIIlIIIlII.cullFace), lllllllllllllllIIllllIIIIlIIIIIl);
                }
            }
        }
        return lllllllllllllllIIllllIIIIlIIIlll.makeBakedModel();
    }
    
    private static IBakedModel makeBakedModel(final TextureMap lllllllllllllllIIllllIIIlIlIIIIl, final ItemModelGenerator lllllllllllllllIIllllIIIlIlIlIlI, final String[] lllllllllllllllIIllllIIIlIlIlIIl, final boolean lllllllllllllllIIllllIIIlIIllllI) {
        final String[] lllllllllllllllIIllllIIIlIlIIlll = new String[lllllllllllllllIIllllIIIlIlIlIIl.length];
        for (int lllllllllllllllIIllllIIIlIlIIllI = 0; lllllllllllllllIIllllIIIlIlIIllI < lllllllllllllllIIllllIIIlIlIIlll.length; ++lllllllllllllllIIllllIIIlIlIIllI) {
            final String lllllllllllllllIIllllIIIlIlIIlIl = lllllllllllllllIIllllIIIlIlIlIIl[lllllllllllllllIIllllIIIlIlIIllI];
            lllllllllllllllIIllllIIIlIlIIlll[lllllllllllllllIIllllIIIlIlIIllI] = StrUtils.removePrefix(lllllllllllllllIIllllIIIlIlIIlIl, "textures/");
        }
        final ModelBlock lllllllllllllllIIllllIIIlIlIIlII = makeModelBlock(lllllllllllllllIIllllIIIlIlIIlll);
        final ModelBlock lllllllllllllllIIllllIIIlIlIIIll = lllllllllllllllIIllllIIIlIlIlIlI.makeItemModel(lllllllllllllllIIllllIIIlIlIIIIl, lllllllllllllllIIllllIIIlIlIIlII);
        final IBakedModel lllllllllllllllIIllllIIIlIlIIIlI = bakeModel(lllllllllllllllIIllllIIIlIlIIIIl, lllllllllllllllIIllllIIIlIlIIIll, lllllllllllllllIIllllIIIlIIllllI);
        return lllllllllllllllIIllllIIIlIlIIIlI;
    }
    
    public float getTextureHeight(final TextureManager lllllllllllllllIIllllIIIIIIIIIll) {
        if (this.textureHeight <= 0) {
            if (this.textureLocation != null) {
                final ITextureObject lllllllllllllllIIllllIIIIIIIIIlI = lllllllllllllllIIllllIIIIIIIIIll.getTexture(this.textureLocation);
                final int lllllllllllllllIIllllIIIIIIIIIIl = lllllllllllllllIIllllIIIIIIIIIlI.getGlTextureId();
                final int lllllllllllllllIIllllIIIIIIIIIII = GlStateManager.getBoundTexture();
                GlStateManager.bindTexture(lllllllllllllllIIllllIIIIIIIIIIl);
                this.textureHeight = GL11.glGetTexLevelParameteri(3553, 0, 4097);
                GlStateManager.bindTexture(lllllllllllllllIIllllIIIIIIIIIII);
            }
            if (this.textureHeight <= 0) {
                this.textureHeight = 16;
            }
        }
        return (float)this.textureHeight;
    }
    
    public CustomItemProperties(final Properties lllllllllllllllIIllllIlIIllIIIIl, final String lllllllllllllllIIllllIlIIlIllIll) {
        this.name = null;
        this.basePath = null;
        this.type = 1;
        this.items = null;
        this.texture = null;
        this.mapTextures = null;
        this.model = null;
        this.mapModels = null;
        this.damage = null;
        this.damagePercent = false;
        this.damageMask = 0;
        this.stackSize = null;
        this.enchantmentIds = null;
        this.enchantmentLevels = null;
        this.nbtTagValues = null;
        this.hand = 0;
        this.blend = 1;
        this.speed = 0.0f;
        this.rotation = 0.0f;
        this.layer = 0;
        this.duration = 1.0f;
        this.weight = 0;
        this.textureLocation = null;
        this.mapTextureLocations = null;
        this.sprite = null;
        this.mapSprites = null;
        this.bakedModelTexture = null;
        this.mapBakedModelsTexture = null;
        this.bakedModelFull = null;
        this.mapBakedModelsFull = null;
        this.textureWidth = 0;
        this.textureHeight = 0;
        this.name = parseName(lllllllllllllllIIllllIlIIlIllIll);
        this.basePath = parseBasePath(lllllllllllllllIIllllIlIIlIllIll);
        this.type = this.parseType(lllllllllllllllIIllllIlIIllIIIIl.getProperty("type"));
        this.items = this.parseItems(lllllllllllllllIIllllIlIIllIIIIl.getProperty("items"), lllllllllllllllIIllllIlIIllIIIIl.getProperty("matchItems"));
        this.mapModels = (Map<String, String>)parseModels(lllllllllllllllIIllllIlIIllIIIIl, this.basePath);
        this.model = parseModel(lllllllllllllllIIllllIlIIllIIIIl.getProperty("model"), lllllllllllllllIIllllIlIIlIllIll, this.basePath, this.type, this.mapModels);
        this.mapTextures = (Map<String, String>)parseTextures(lllllllllllllllIIllllIlIIllIIIIl, this.basePath);
        final boolean lllllllllllllllIIllllIlIIlIlllll = this.mapModels == null && this.model == null;
        this.texture = parseTexture(lllllllllllllllIIllllIlIIllIIIIl.getProperty("texture"), lllllllllllllllIIllllIlIIllIIIIl.getProperty("tile"), lllllllllllllllIIllllIlIIllIIIIl.getProperty("source"), lllllllllllllllIIllllIlIIlIllIll, this.basePath, this.type, this.mapTextures, lllllllllllllllIIllllIlIIlIlllll);
        String lllllllllllllllIIllllIlIIlIllllI = lllllllllllllllIIllllIlIIllIIIIl.getProperty("damage");
        if (lllllllllllllllIIllllIlIIlIllllI != null) {
            this.damagePercent = lllllllllllllllIIllllIlIIlIllllI.contains("%");
            lllllllllllllllIIllllIlIIlIllllI = lllllllllllllllIIllllIlIIlIllllI.replace("%", "");
            this.damage = this.parseRangeListInt(lllllllllllllllIIllllIlIIlIllllI);
            this.damageMask = this.parseInt(lllllllllllllllIIllllIlIIllIIIIl.getProperty("damageMask"), 0);
        }
        this.stackSize = this.parseRangeListInt(lllllllllllllllIIllllIlIIllIIIIl.getProperty("stackSize"));
        this.enchantmentIds = this.parseRangeListInt(lllllllllllllllIIllllIlIIllIIIIl.getProperty("enchantmentIDs"), new ParserEnchantmentId());
        this.enchantmentLevels = this.parseRangeListInt(lllllllllllllllIIllllIlIIllIIIIl.getProperty("enchantmentLevels"));
        this.nbtTagValues = this.parseNbtTagValues(lllllllllllllllIIllllIlIIllIIIIl);
        this.hand = this.parseHand(lllllllllllllllIIllllIlIIllIIIIl.getProperty("hand"));
        this.blend = Blender.parseBlend(lllllllllllllllIIllllIlIIllIIIIl.getProperty("blend"));
        this.speed = this.parseFloat(lllllllllllllllIIllllIlIIllIIIIl.getProperty("speed"), 0.0f);
        this.rotation = this.parseFloat(lllllllllllllllIIllllIlIIllIIIIl.getProperty("rotation"), 0.0f);
        this.layer = this.parseInt(lllllllllllllllIIllllIlIIllIIIIl.getProperty("layer"), 0);
        this.weight = this.parseInt(lllllllllllllllIIllllIlIIllIIIIl.getProperty("weight"), 0);
        this.duration = this.parseFloat(lllllllllllllllIIllllIlIIllIIIIl.getProperty("duration"), 1.0f);
    }
    
    public IBakedModel getBakedModel(final ResourceLocation lllllllllllllllIIlllIllllllIlIIl, final boolean lllllllllllllllIIlllIllllllIlIII) {
        IBakedModel lllllllllllllllIIlllIllllllIllll = null;
        Map<String, IBakedModel> lllllllllllllllIIlllIllllllIllIl = null;
        if (lllllllllllllllIIlllIllllllIlIII) {
            final IBakedModel lllllllllllllllIIlllIlllllllIIII = this.bakedModelFull;
            final Map<String, IBakedModel> lllllllllllllllIIlllIllllllIlllI = this.mapBakedModelsFull;
        }
        else {
            lllllllllllllllIIlllIllllllIllll = this.bakedModelTexture;
            lllllllllllllllIIlllIllllllIllIl = this.mapBakedModelsTexture;
        }
        if (lllllllllllllllIIlllIllllllIlIIl != null && lllllllllllllllIIlllIllllllIllIl != null) {
            final String lllllllllllllllIIlllIllllllIllII = lllllllllllllllIIlllIllllllIlIIl.getResourcePath();
            final IBakedModel lllllllllllllllIIlllIllllllIlIll = lllllllllllllllIIlllIllllllIllIl.get(lllllllllllllllIIlllIllllllIllII);
            if (lllllllllllllllIIlllIllllllIlIll != null) {
                return lllllllllllllllIIlllIllllllIlIll;
            }
        }
        return lllllllllllllllIIlllIllllllIllll;
    }
    
    private int[] detectItems() {
        final Item lllllllllllllllIIllllIIlIIIlIlII = Item.getByNameOrId(this.name);
        if (lllllllllllllllIIllllIIlIIIlIlII == null) {
            return null;
        }
        final int lllllllllllllllIIllllIIlIIIlIIll = Item.getIdFromItem(lllllllllllllllIIllllIIlIIIlIlII);
        return (int[])((lllllllllllllllIIllllIIlIIIlIIll <= 0) ? null : new int[] { lllllllllllllllIIllllIIlIIIlIIll });
    }
    
    private int[] parseItems(String lllllllllllllllIIllllIlIIIlIIIlI, final String lllllllllllllllIIllllIlIIIlIIIIl) {
        if (lllllllllllllllIIllllIlIIIlIIIlI == null) {
            lllllllllllllllIIllllIlIIIlIIIlI = lllllllllllllllIIllllIlIIIlIIIIl;
        }
        if (lllllllllllllllIIllllIlIIIlIIIlI == null) {
            return null;
        }
        lllllllllllllllIIllllIlIIIlIIIlI = lllllllllllllllIIllllIlIIIlIIIlI.trim();
        final Set lllllllllllllllIIllllIlIIIllIIlI = new TreeSet();
        final String[] lllllllllllllllIIllllIlIIIllIIIl = Config.tokenize(lllllllllllllllIIllllIlIIIlIIIlI, " ");
        for (int lllllllllllllllIIllllIlIIIllIIII = 0; lllllllllllllllIIllllIlIIIllIIII < lllllllllllllllIIllllIlIIIllIIIl.length; ++lllllllllllllllIIllllIlIIIllIIII) {
            final String lllllllllllllllIIllllIlIIIlIllll = lllllllllllllllIIllllIlIIIllIIIl[lllllllllllllllIIllllIlIIIllIIII];
            final int lllllllllllllllIIllllIlIIIlIlllI = Config.parseInt(lllllllllllllllIIllllIlIIIlIllll, -1);
            if (lllllllllllllllIIllllIlIIIlIlllI >= 0) {
                lllllllllllllllIIllllIlIIIllIIlI.add(new Integer(lllllllllllllllIIllllIlIIIlIlllI));
            }
            else {
                if (lllllllllllllllIIllllIlIIIlIllll.contains("-")) {
                    final String[] lllllllllllllllIIllllIlIIIlIllIl = Config.tokenize(lllllllllllllllIIllllIlIIIlIllll, "-");
                    if (lllllllllllllllIIllllIlIIIlIllIl.length == 2) {
                        final int lllllllllllllllIIllllIlIIIlIllII = Config.parseInt(lllllllllllllllIIllllIlIIIlIllIl[0], -1);
                        final int lllllllllllllllIIllllIlIIIlIlIll = Config.parseInt(lllllllllllllllIIllllIlIIIlIllIl[1], -1);
                        if (lllllllllllllllIIllllIlIIIlIllII >= 0 && lllllllllllllllIIllllIlIIIlIlIll >= 0) {
                            final int lllllllllllllllIIllllIlIIIlIlIlI = Math.min(lllllllllllllllIIllllIlIIIlIllII, lllllllllllllllIIllllIlIIIlIlIll);
                            for (int lllllllllllllllIIllllIlIIIlIlIIl = Math.max(lllllllllllllllIIllllIlIIIlIllII, lllllllllllllllIIllllIlIIIlIlIll), lllllllllllllllIIllllIlIIIlIlIII = lllllllllllllllIIllllIlIIIlIlIlI; lllllllllllllllIIllllIlIIIlIlIII <= lllllllllllllllIIllllIlIIIlIlIIl; ++lllllllllllllllIIllllIlIIIlIlIII) {
                                lllllllllllllllIIllllIlIIIllIIlI.add(new Integer(lllllllllllllllIIllllIlIIIlIlIII));
                            }
                            continue;
                        }
                    }
                }
                final Item lllllllllllllllIIllllIlIIIlIIlll = Item.getByNameOrId(lllllllllllllllIIllllIlIIIlIllll);
                if (lllllllllllllllIIllllIlIIIlIIlll == null) {
                    Config.warn(String.valueOf(new StringBuilder("Item not found: ").append(lllllllllllllllIIllllIlIIIlIllll)));
                }
                else {
                    final int lllllllllllllllIIllllIlIIIlIIllI = Item.getIdFromItem(lllllllllllllllIIllllIlIIIlIIlll);
                    if (lllllllllllllllIIllllIlIIIlIIllI <= 0) {
                        Config.warn(String.valueOf(new StringBuilder("Item not found: ").append(lllllllllllllllIIllllIlIIIlIllll)));
                    }
                    else {
                        lllllllllllllllIIllllIlIIIllIIlI.add(new Integer(lllllllllllllllIIllllIlIIIlIIllI));
                    }
                }
            }
        }
        final Integer[] lllllllllllllllIIllllIlIIIlIIlIl = lllllllllllllllIIllllIlIIIllIIlI.toArray(new Integer[lllllllllllllllIIllllIlIIIllIIlI.size()]);
        final int[] lllllllllllllllIIllllIlIIIlIIlII = new int[lllllllllllllllIIllllIlIIIlIIlIl.length];
        for (int lllllllllllllllIIllllIlIIIlIIIll = 0; lllllllllllllllIIllllIlIIIlIIIll < lllllllllllllllIIllllIlIIIlIIlII.length; ++lllllllllllllllIIllllIlIIIlIIIll) {
            lllllllllllllllIIllllIlIIIlIIlII[lllllllllllllllIIllllIlIIIlIIIll] = lllllllllllllllIIllllIlIIIlIIlIl[lllllllllllllllIIllllIlIIIlIIIll];
        }
        return lllllllllllllllIIllllIlIIIlIIlII;
    }
    
    public void updateModelTexture(final TextureMap lllllllllllllllIIllllIIIllIIlIlI, final ItemModelGenerator lllllllllllllllIIllllIIIllIIlIIl) {
        if (this.texture != null || this.mapTextures != null) {
            final String[] lllllllllllllllIIllllIIIllIIlIII = this.getModelTextures();
            final boolean lllllllllllllllIIllllIIIllIIIlll = this.isUseTint();
            this.bakedModelTexture = makeBakedModel(lllllllllllllllIIllllIIIllIIlIlI, lllllllllllllllIIllllIIIllIIlIIl, lllllllllllllllIIllllIIIllIIlIII, lllllllllllllllIIllllIIIllIIIlll);
            if (this.type == 1 && this.mapTextures != null) {
                for (final String lllllllllllllllIIllllIIIllIIIllI : this.mapTextures.keySet()) {
                    final String lllllllllllllllIIllllIIIllIIIlIl = this.mapTextures.get(lllllllllllllllIIllllIIIllIIIllI);
                    final String lllllllllllllllIIllllIIIllIIIlII = StrUtils.removePrefix(lllllllllllllllIIllllIIIllIIIllI, "texture.");
                    if (lllllllllllllllIIllllIIIllIIIlII.startsWith("bow") || lllllllllllllllIIllllIIIllIIIlII.startsWith("fishing_rod")) {
                        final String[] lllllllllllllllIIllllIIIllIIIIll = { lllllllllllllllIIllllIIIllIIIlIl };
                        final IBakedModel lllllllllllllllIIllllIIIllIIIIlI = makeBakedModel(lllllllllllllllIIllllIIIllIIlIlI, lllllllllllllllIIllllIIIllIIlIIl, lllllllllllllllIIllllIIIllIIIIll, lllllllllllllllIIllllIIIllIIIlll);
                        if (this.mapBakedModelsTexture == null) {
                            this.mapBakedModelsTexture = new HashMap<String, IBakedModel>();
                        }
                        final String lllllllllllllllIIllllIIIllIIIIIl = String.valueOf(new StringBuilder("item/").append(lllllllllllllllIIllllIIIllIIIlII));
                        this.mapBakedModelsTexture.put(lllllllllllllllIIllllIIIllIIIIIl, lllllllllllllllIIllllIIIllIIIIlI);
                    }
                }
            }
        }
    }
    
    public void updateIcons(final TextureMap lllllllllllllllIIllllIIIlllllllI) {
        if (this.texture != null) {
            this.textureLocation = this.getTextureLocation(this.texture);
            if (this.type == 1) {
                final ResourceLocation lllllllllllllllIIllllIIlIIIIIlIl = this.getSpriteLocation(this.textureLocation);
                this.sprite = lllllllllllllllIIllllIIIlllllllI.registerSprite(lllllllllllllllIIllllIIlIIIIIlIl);
            }
        }
        if (this.mapTextures != null) {
            this.mapTextureLocations = new HashMap();
            this.mapSprites = new HashMap();
            for (final String lllllllllllllllIIllllIIlIIIIIlII : this.mapTextures.keySet()) {
                final String lllllllllllllllIIllllIIlIIIIIIll = this.mapTextures.get(lllllllllllllllIIllllIIlIIIIIlII);
                final ResourceLocation lllllllllllllllIIllllIIlIIIIIIlI = this.getTextureLocation(lllllllllllllllIIllllIIlIIIIIIll);
                this.mapTextureLocations.put(lllllllllllllllIIllllIIlIIIIIlII, lllllllllllllllIIllllIIlIIIIIIlI);
                if (this.type == 1) {
                    final ResourceLocation lllllllllllllllIIllllIIlIIIIIIIl = this.getSpriteLocation(lllllllllllllllIIllllIIlIIIIIIlI);
                    final TextureAtlasSprite lllllllllllllllIIllllIIlIIIIIIII = lllllllllllllllIIllllIIIlllllllI.registerSprite(lllllllllllllllIIllllIIlIIIIIIIl);
                    this.mapSprites.put(lllllllllllllllIIllllIIlIIIIIlII, lllllllllllllllIIllllIIlIIIIIIII);
                }
            }
        }
    }
    
    private RangeListInt parseRangeListInt(final String lllllllllllllllIIllllIIlIllIllll, final IParserInt lllllllllllllllIIllllIIlIllIlllI) {
        if (lllllllllllllllIIllllIIlIllIllll == null) {
            return null;
        }
        final String[] lllllllllllllllIIllllIIlIlllIllI = Config.tokenize(lllllllllllllllIIllllIIlIllIllll, " ");
        final RangeListInt lllllllllllllllIIllllIIlIlllIlIl = new RangeListInt();
        for (int lllllllllllllllIIllllIIlIlllIlII = 0; lllllllllllllllIIllllIIlIlllIlII < lllllllllllllllIIllllIIlIlllIllI.length; ++lllllllllllllllIIllllIIlIlllIlII) {
            final String lllllllllllllllIIllllIIlIlllIIll = lllllllllllllllIIllllIIlIlllIllI[lllllllllllllllIIllllIIlIlllIlII];
            if (lllllllllllllllIIllllIIlIllIlllI != null) {
                final int lllllllllllllllIIllllIIlIlllIIlI = lllllllllllllllIIllllIIlIllIlllI.parse(lllllllllllllllIIllllIIlIlllIIll, Integer.MIN_VALUE);
                if (lllllllllllllllIIllllIIlIlllIIlI != Integer.MIN_VALUE) {
                    lllllllllllllllIIllllIIlIlllIlIl.addRange(new RangeInt(lllllllllllllllIIllllIIlIlllIIlI, lllllllllllllllIIllllIIlIlllIIlI));
                    continue;
                }
            }
            final RangeInt lllllllllllllllIIllllIIlIlllIIIl = this.parseRangeInt(lllllllllllllllIIllllIIlIlllIIll);
            if (lllllllllllllllIIllllIIlIlllIIIl == null) {
                Config.warn(String.valueOf(new StringBuilder("Invalid range list: ").append(lllllllllllllllIIllllIIlIllIllll)));
                return null;
            }
            lllllllllllllllIIllllIIlIlllIlIl.addRange(lllllllllllllllIIllllIIlIlllIIIl);
        }
        return lllllllllllllllIIllllIIlIlllIlIl;
    }
    
    private static String parseModel(String lllllllllllllllIIllllIIlllIIIllI, final String lllllllllllllllIIllllIIlllIIllII, final String lllllllllllllllIIllllIIlllIIIlIl, final int lllllllllllllllIIllllIIlllIIlIlI, final Map<String, String> lllllllllllllllIIllllIIlllIIlIIl) {
        if (lllllllllllllllIIllllIIlllIIIllI != null) {
            final String lllllllllllllllIIllllIIlllIIlIII = ".json";
            if (lllllllllllllllIIllllIIlllIIIllI.endsWith(lllllllllllllllIIllllIIlllIIlIII)) {
                lllllllllllllllIIllllIIlllIIIllI = lllllllllllllllIIllllIIlllIIIllI.substring(0, lllllllllllllllIIllllIIlllIIIllI.length() - lllllllllllllllIIllllIIlllIIlIII.length());
            }
            lllllllllllllllIIllllIIlllIIIllI = fixModelName(lllllllllllllllIIllllIIlllIIIllI, lllllllllllllllIIllllIIlllIIIlIl);
            return lllllllllllllllIIllllIIlllIIIllI;
        }
        if (lllllllllllllllIIllllIIlllIIlIlI == 3) {
            return null;
        }
        if (lllllllllllllllIIllllIIlllIIlIIl != null) {
            final String lllllllllllllllIIllllIIlllIIIlll = lllllllllllllllIIllllIIlllIIlIIl.get("model.bow_standby");
            if (lllllllllllllllIIllllIIlllIIIlll != null) {
                return lllllllllllllllIIllllIIlllIIIlll;
            }
        }
        return lllllllllllllllIIllllIIlllIIIllI;
    }
    
    private static Map getMatchingProperties(final Properties lllllllllllllllIIllllIIlIIlIllIl, final String lllllllllllllllIIllllIIlIIlIllII) {
        final Map lllllllllllllllIIllllIIlIIlIlIll = new LinkedHashMap();
        for (final Object lllllllllllllllIIllllIIlIIlIlIlI : ((Hashtable<Object, V>)lllllllllllllllIIllllIIlIIlIllIl).keySet()) {
            final String lllllllllllllllIIllllIIlIIlIlIIl = lllllllllllllllIIllllIIlIIlIllIl.getProperty((String)lllllllllllllllIIllllIIlIIlIlIlI);
            if (((String)lllllllllllllllIIllllIIlIIlIlIlI).startsWith(lllllllllllllllIIllllIIlIIlIllII)) {
                lllllllllllllllIIllllIIlIIlIlIll.put(lllllllllllllllIIllllIIlIIlIlIlI, lllllllllllllllIIllllIIlIIlIlIIl);
            }
        }
        return lllllllllllllllIIllllIIlIIlIlIll;
    }
    
    private static String fixTextureName(String lllllllllllllllIIllllIIlllIlIlII, final String lllllllllllllllIIllllIIlllIlIIll) {
        lllllllllllllllIIllllIIlllIlIlII = TextureUtils.fixResourcePath(lllllllllllllllIIllllIIlllIlIlII, lllllllllllllllIIllllIIlllIlIIll);
        if (!lllllllllllllllIIllllIIlllIlIlII.startsWith(lllllllllllllllIIllllIIlllIlIIll) && !lllllllllllllllIIllllIIlllIlIlII.startsWith("textures/") && !lllllllllllllllIIllllIIlllIlIlII.startsWith("mcpatcher/")) {
            lllllllllllllllIIllllIIlllIlIlII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIllllIIlllIlIIll)).append("/").append(lllllllllllllllIIllllIIlllIlIlII));
        }
        if (lllllllllllllllIIllllIIlllIlIlII.endsWith(".png")) {
            lllllllllllllllIIllllIIlllIlIlII = lllllllllllllllIIllllIIlllIlIlII.substring(0, lllllllllllllllIIllllIIlllIlIlII.length() - 4);
        }
        if (lllllllllllllllIIllllIIlllIlIlII.startsWith("/")) {
            lllllllllllllllIIllllIIlllIlIlII = lllllllllllllllIIllllIIlllIlIlII.substring(1);
        }
        return lllllllllllllllIIllllIIlllIlIlII;
    }
    
    private static Map parseModels(final Properties lllllllllllllllIIllllIIllIllIIII, final String lllllllllllllllIIllllIIllIllIlll) {
        final String lllllllllllllllIIllllIIllIllIllI = "model.";
        final Map lllllllllllllllIIllllIIllIllIlIl = getMatchingProperties(lllllllllllllllIIllllIIllIllIIII, lllllllllllllllIIllllIIllIllIllI);
        if (lllllllllllllllIIllllIIllIllIlIl.size() <= 0) {
            return null;
        }
        final Set lllllllllllllllIIllllIIllIllIlII = lllllllllllllllIIllllIIllIllIlIl.keySet();
        final Map lllllllllllllllIIllllIIllIllIIll = new LinkedHashMap();
        for (final Object lllllllllllllllIIllllIIllIllIIlI : lllllllllllllllIIllllIIllIllIlII) {
            String lllllllllllllllIIllllIIllIllIIIl = lllllllllllllllIIllllIIllIllIlIl.get(lllllllllllllllIIllllIIllIllIIlI);
            lllllllllllllllIIllllIIllIllIIIl = fixModelName(lllllllllllllllIIllllIIllIllIIIl, lllllllllllllllIIllllIIllIllIlll);
            lllllllllllllllIIllllIIllIllIIll.put(lllllllllllllllIIllllIIllIllIIlI, lllllllllllllllIIllllIIllIllIIIl);
        }
        return lllllllllllllllIIllllIIllIllIIll;
    }
    
    private static String fixModelName(String lllllllllllllllIIllllIIllIIlllll, final String lllllllllllllllIIllllIIllIlIIIlI) {
        lllllllllllllllIIllllIIllIIlllll = (char)TextureUtils.fixResourcePath((String)lllllllllllllllIIllllIIllIIlllll, lllllllllllllllIIllllIIllIlIIIlI);
        final boolean lllllllllllllllIIllllIIllIlIIIIl = ((String)lllllllllllllllIIllllIIllIIlllll).startsWith("block/") || ((String)lllllllllllllllIIllllIIllIIlllll).startsWith("item/");
        if (!((String)lllllllllllllllIIllllIIllIIlllll).startsWith(lllllllllllllllIIllllIIllIlIIIlI) && !lllllllllllllllIIllllIIllIlIIIIl && !((String)lllllllllllllllIIllllIIllIIlllll).startsWith("mcpatcher/")) {
            lllllllllllllllIIllllIIllIIlllll = (char)String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIllllIIllIlIIIlI)).append("/").append((String)lllllllllllllllIIllllIIllIIlllll));
        }
        final String lllllllllllllllIIllllIIllIlIIIII = ".json";
        if (((String)lllllllllllllllIIllllIIllIIlllll).endsWith(lllllllllllllllIIllllIIllIlIIIII)) {
            lllllllllllllllIIllllIIllIIlllll = (char)((String)lllllllllllllllIIllllIIllIIlllll).substring(0, ((String)lllllllllllllllIIllllIIllIIlllll).length() - lllllllllllllllIIllllIIllIlIIIII.length());
        }
        if (((String)lllllllllllllllIIllllIIllIIlllll).startsWith("/")) {
            lllllllllllllllIIllllIIllIIlllll = (char)((String)lllllllllllllllIIllllIIllIIlllll).substring(1);
        }
        return (String)lllllllllllllllIIllllIIllIIlllll;
    }
    
    private String[] getModelTextures() {
        if (this.type == 1 && this.items.length == 1) {
            final Item lllllllllllllllIIllllIIIlIIIllll = Item.getItemById(this.items[0]);
            final boolean lllllllllllllllIIllllIIIlIIIlllI = lllllllllllllllIIllllIIIlIIIllll == Items.POTIONITEM || lllllllllllllllIIllllIIIlIIIllll == Items.SPLASH_POTION || lllllllllllllllIIllllIIIlIIIllll == Items.LINGERING_POTION;
            if (lllllllllllllllIIllllIIIlIIIlllI && this.damage != null && this.damage.getCountRanges() > 0) {
                final RangeInt lllllllllllllllIIllllIIIlIIIllIl = this.damage.getRange(0);
                final int lllllllllllllllIIllllIIIlIIIllII = lllllllllllllllIIllllIIIlIIIllIl.getMin();
                final boolean lllllllllllllllIIllllIIIlIIIlIll = (lllllllllllllllIIllllIIIlIIIllII & 0x4000) != 0x0;
                final String lllllllllllllllIIllllIIIlIIIlIlI = this.getMapTexture(this.mapTextures, "texture.potion_overlay", "items/potion_overlay");
                String lllllllllllllllIIllllIIIlIIIlIIl = null;
                if (lllllllllllllllIIllllIIIlIIIlIll) {
                    lllllllllllllllIIllllIIIlIIIlIIl = this.getMapTexture(this.mapTextures, "texture.potion_bottle_splash", "items/potion_bottle_splash");
                }
                else {
                    lllllllllllllllIIllllIIIlIIIlIIl = this.getMapTexture(this.mapTextures, "texture.potion_bottle_drinkable", "items/potion_bottle_drinkable");
                }
                return new String[] { lllllllllllllllIIllllIIIlIIIlIlI, lllllllllllllllIIllllIIIlIIIlIIl };
            }
            if (lllllllllllllllIIllllIIIlIIIllll instanceof ItemArmor) {
                final ItemArmor lllllllllllllllIIllllIIIlIIIlIII = (ItemArmor)lllllllllllllllIIllllIIIlIIIllll;
                if (lllllllllllllllIIllllIIIlIIIlIII.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER) {
                    final String lllllllllllllllIIllllIIIlIIIIlll = "leather";
                    String lllllllllllllllIIllllIIIlIIIIllI = "helmet";
                    if (lllllllllllllllIIllllIIIlIIIlIII.armorType == EntityEquipmentSlot.HEAD) {
                        lllllllllllllllIIllllIIIlIIIIllI = "helmet";
                    }
                    if (lllllllllllllllIIllllIIIlIIIlIII.armorType == EntityEquipmentSlot.CHEST) {
                        lllllllllllllllIIllllIIIlIIIIllI = "chestplate";
                    }
                    if (lllllllllllllllIIllllIIIlIIIlIII.armorType == EntityEquipmentSlot.LEGS) {
                        lllllllllllllllIIllllIIIlIIIIllI = "leggings";
                    }
                    if (lllllllllllllllIIllllIIIlIIIlIII.armorType == EntityEquipmentSlot.FEET) {
                        lllllllllllllllIIllllIIIlIIIIllI = "boots";
                    }
                    final String lllllllllllllllIIllllIIIlIIIIlIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIllllIIIlIIIIlll)).append("_").append(lllllllllllllllIIllllIIIlIIIIllI));
                    final String lllllllllllllllIIllllIIIlIIIIlII = this.getMapTexture(this.mapTextures, String.valueOf(new StringBuilder("texture.").append(lllllllllllllllIIllllIIIlIIIIlIl)), String.valueOf(new StringBuilder("items/").append(lllllllllllllllIIllllIIIlIIIIlIl)));
                    final String lllllllllllllllIIllllIIIlIIIIIll = this.getMapTexture(this.mapTextures, String.valueOf(new StringBuilder("texture.").append(lllllllllllllllIIllllIIIlIIIIlIl).append("_overlay")), String.valueOf(new StringBuilder("items/").append(lllllllllllllllIIllllIIIlIIIIlIl).append("_overlay")));
                    return new String[] { lllllllllllllllIIllllIIIlIIIIlII, lllllllllllllllIIllllIIIlIIIIIll };
                }
            }
        }
        return new String[] { this.texture };
    }
    
    private static void checkNull(final Object lllllllllllllllIIlllIlllIIllIIll, final String lllllllllllllllIIlllIlllIIllIIlI) throws NullPointerException {
        if (lllllllllllllllIIlllIlllIIllIIll == null) {
            throw new NullPointerException(lllllllllllllllIIlllIlllIIllIIlI);
        }
    }
    
    public void updateModelsFull() {
        final ModelManager lllllllllllllllIIlllIllllIIlIllI = Config.getModelManager();
        final IBakedModel lllllllllllllllIIlllIllllIIlIlIl = lllllllllllllllIIlllIllllIIlIllI.getMissingModel();
        if (this.model != null) {
            final ResourceLocation lllllllllllllllIIlllIllllIIlIlII = getModelLocation(this.model);
            final ModelResourceLocation lllllllllllllllIIlllIllllIIlIIlI = new ModelResourceLocation(lllllllllllllllIIlllIllllIIlIlII, "inventory");
            this.bakedModelFull = lllllllllllllllIIlllIllllIIlIllI.getModel(lllllllllllllllIIlllIllllIIlIIlI);
            if (this.bakedModelFull == lllllllllllllllIIlllIllllIIlIlIl) {
                Config.warn(String.valueOf(new StringBuilder("Custom Items: Model not found ").append(lllllllllllllllIIlllIllllIIlIIlI.getResourcePath())));
                this.bakedModelFull = null;
            }
        }
        if (this.type == 1 && this.mapModels != null) {
            for (final String lllllllllllllllIIlllIllllIIlIIII : this.mapModels.keySet()) {
                final String lllllllllllllllIIlllIllllIIIlllI = this.mapModels.get(lllllllllllllllIIlllIllllIIlIIII);
                final String lllllllllllllllIIlllIllllIIIllII = StrUtils.removePrefix(lllllllllllllllIIlllIllllIIlIIII, "model.");
                if (lllllllllllllllIIlllIllllIIIllII.startsWith("bow") || lllllllllllllllIIlllIllllIIIllII.startsWith("fishing_rod")) {
                    final ResourceLocation lllllllllllllllIIlllIllllIIIlIlI = getModelLocation(lllllllllllllllIIlllIllllIIIlllI);
                    final ModelResourceLocation lllllllllllllllIIlllIllllIIIlIII = new ModelResourceLocation(lllllllllllllllIIlllIllllIIIlIlI, "inventory");
                    final IBakedModel lllllllllllllllIIlllIllllIIIIllI = lllllllllllllllIIlllIllllIIlIllI.getModel(lllllllllllllllIIlllIllllIIIlIII);
                    if (lllllllllllllllIIlllIllllIIIIllI == lllllllllllllllIIlllIllllIIlIlIl) {
                        Config.warn(String.valueOf(new StringBuilder("Custom Items: Model not found ").append(lllllllllllllllIIlllIllllIIIlIII.getResourcePath())));
                    }
                    else {
                        if (this.mapBakedModelsFull == null) {
                            this.mapBakedModelsFull = new HashMap<String, IBakedModel>();
                        }
                        final String lllllllllllllllIIlllIllllIIIIlII = String.valueOf(new StringBuilder("item/").append(lllllllllllllllIIlllIllllIIIllII));
                        this.mapBakedModelsFull.put(lllllllllllllllIIlllIllllIIIIlII, lllllllllllllllIIlllIllllIIIIllI);
                    }
                }
            }
        }
    }
    
    private int parseType(final String lllllllllllllllIIllllIlIIlIIIlII) {
        if (lllllllllllllllIIllllIlIIlIIIlII == null) {
            return 1;
        }
        if (lllllllllllllllIIllllIlIIlIIIlII.equals("item")) {
            return 1;
        }
        if (lllllllllllllllIIllllIlIIlIIIlII.equals("enchantment")) {
            return 2;
        }
        if (lllllllllllllllIIllllIlIIlIIIlII.equals("armor")) {
            return 3;
        }
        if (lllllllllllllllIIllllIlIIlIIIlII.equals("elytra")) {
            return 4;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown method: ").append(lllllllllllllllIIllllIlIIlIIIlII)));
        return 0;
    }
    
    public float getTextureWidth(final TextureManager lllllllllllllllIIllllIIIIIIlIIlI) {
        if (this.textureWidth <= 0) {
            if (this.textureLocation != null) {
                final ITextureObject lllllllllllllllIIllllIIIIIIlIIIl = lllllllllllllllIIllllIIIIIIlIIlI.getTexture(this.textureLocation);
                final int lllllllllllllllIIllllIIIIIIlIIII = lllllllllllllllIIllllIIIIIIlIIIl.getGlTextureId();
                final int lllllllllllllllIIllllIIIIIIIllll = GlStateManager.getBoundTexture();
                GlStateManager.bindTexture(lllllllllllllllIIllllIIIIIIlIIII);
                this.textureWidth = GL11.glGetTexLevelParameteri(3553, 0, 4096);
                GlStateManager.bindTexture(lllllllllllllllIIllllIIIIIIIllll);
            }
            if (this.textureWidth <= 0) {
                this.textureWidth = 16;
            }
        }
        return (float)this.textureWidth;
    }
}
