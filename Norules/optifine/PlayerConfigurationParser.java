package optifine;

import net.minecraft.util.*;
import java.awt.image.*;
import net.minecraft.client.*;
import javax.imageio.*;
import java.io.*;
import com.google.gson.*;

public class PlayerConfigurationParser
{
    private /* synthetic */ String player;
    
    public PlayerConfigurationParser(final String lllllllllllllllIlIlIIIIllIIIlIII) {
        this.player = null;
        this.player = lllllllllllllllIlIlIIIIllIIIlIII;
    }
    
    static {
        ITEM_ACTIVE = "active";
        ITEM_TYPE = "type";
        CONFIG_ITEMS = "items";
    }
    
    public PlayerConfiguration parsePlayerConfiguration(final JsonElement lllllllllllllllIlIlIIIIlIlllIllI) {
        if (lllllllllllllllIlIlIIIIlIlllIllI == null) {
            throw new JsonParseException(String.valueOf(new StringBuilder("JSON object is null, player: ").append(this.player)));
        }
        final JsonObject lllllllllllllllIlIlIIIIlIlllIlIl = (JsonObject)lllllllllllllllIlIlIIIIlIlllIllI;
        final PlayerConfiguration lllllllllllllllIlIlIIIIlIlllIlII = new PlayerConfiguration();
        final JsonArray lllllllllllllllIlIlIIIIlIlllIIll = (JsonArray)lllllllllllllllIlIlIIIIlIlllIlIl.get("items");
        if (lllllllllllllllIlIlIIIIlIlllIIll != null) {
            for (int lllllllllllllllIlIlIIIIlIlllIIlI = 0; lllllllllllllllIlIlIIIIlIlllIIlI < lllllllllllllllIlIlIIIIlIlllIIll.size(); ++lllllllllllllllIlIlIIIIlIlllIIlI) {
                final JsonObject lllllllllllllllIlIlIIIIlIlllIIIl = (JsonObject)lllllllllllllllIlIlIIIIlIlllIIll.get(lllllllllllllllIlIlIIIIlIlllIIlI);
                final boolean lllllllllllllllIlIlIIIIlIlllIIII = Json.getBoolean(lllllllllllllllIlIlIIIIlIlllIIIl, "active", true);
                if (lllllllllllllllIlIlIIIIlIlllIIII) {
                    final String lllllllllllllllIlIlIIIIlIllIllll = Json.getString(lllllllllllllllIlIlIIIIlIlllIIIl, "type");
                    if (lllllllllllllllIlIlIIIIlIllIllll == null) {
                        Config.warn(String.valueOf(new StringBuilder("Item type is null, player: ").append(this.player)));
                    }
                    else {
                        String lllllllllllllllIlIlIIIIlIllIlllI = Json.getString(lllllllllllllllIlIlIIIIlIlllIIIl, "model");
                        if (lllllllllllllllIlIlIIIIlIllIlllI == null) {
                            lllllllllllllllIlIlIIIIlIllIlllI = String.valueOf(new StringBuilder("items/").append(lllllllllllllllIlIlIIIIlIllIllll).append("/model.cfg"));
                        }
                        final PlayerItemModel lllllllllllllllIlIlIIIIlIllIllIl = this.downloadModel(lllllllllllllllIlIlIIIIlIllIlllI);
                        if (lllllllllllllllIlIlIIIIlIllIllIl != null) {
                            if (!lllllllllllllllIlIlIIIIlIllIllIl.isUsePlayerTexture()) {
                                String lllllllllllllllIlIlIIIIlIllIllII = Json.getString(lllllllllllllllIlIlIIIIlIlllIIIl, "texture");
                                if (lllllllllllllllIlIlIIIIlIllIllII == null) {
                                    lllllllllllllllIlIlIIIIlIllIllII = String.valueOf(new StringBuilder("items/").append(lllllllllllllllIlIlIIIIlIllIllll).append("/users/").append(this.player).append(".png"));
                                }
                                final BufferedImage lllllllllllllllIlIlIIIIlIllIlIll = this.downloadTextureImage(lllllllllllllllIlIlIIIIlIllIllII);
                                if (lllllllllllllllIlIlIIIIlIllIlIll == null) {
                                    continue;
                                }
                                lllllllllllllllIlIlIIIIlIllIllIl.setTextureImage(lllllllllllllllIlIlIIIIlIllIlIll);
                                final ResourceLocation lllllllllllllllIlIlIIIIlIllIlIlI = new ResourceLocation("optifine.net", lllllllllllllllIlIlIIIIlIllIllII);
                                lllllllllllllllIlIlIIIIlIllIllIl.setTextureLocation(lllllllllllllllIlIlIIIIlIllIlIlI);
                            }
                            lllllllllllllllIlIlIIIIlIlllIlII.addPlayerItemModel(lllllllllllllllIlIlIIIIlIllIllIl);
                        }
                    }
                }
            }
        }
        return lllllllllllllllIlIlIIIIlIlllIlII;
    }
    
    private BufferedImage downloadTextureImage(final String lllllllllllllllIlIlIIIIlIlIlIIIl) {
        final String lllllllllllllllIlIlIIIIlIlIlIlIl = String.valueOf(new StringBuilder(String.valueOf(HttpUtils.getPlayerItemsUrl())).append("/").append(lllllllllllllllIlIlIIIIlIlIlIIIl));
        try {
            final byte[] lllllllllllllllIlIlIIIIlIlIlIlII = HttpPipeline.get(lllllllllllllllIlIlIIIIlIlIlIlIl, Minecraft.getMinecraft().getProxy());
            final BufferedImage lllllllllllllllIlIlIIIIlIlIlIIll = ImageIO.read(new ByteArrayInputStream(lllllllllllllllIlIlIIIIlIlIlIlII));
            return lllllllllllllllIlIlIIIIlIlIlIIll;
        }
        catch (IOException lllllllllllllllIlIlIIIIlIlIlIIlI) {
            Config.warn(String.valueOf(new StringBuilder("Error loading item texture ").append(lllllllllllllllIlIlIIIIlIlIlIIIl).append(": ").append(lllllllllllllllIlIlIIIIlIlIlIIlI.getClass().getName()).append(": ").append(lllllllllllllllIlIlIIIIlIlIlIIlI.getMessage())));
            return null;
        }
    }
    
    private PlayerItemModel downloadModel(final String lllllllllllllllIlIlIIIIlIIllllIl) {
        final String lllllllllllllllIlIlIIIIlIlIIIlII = String.valueOf(new StringBuilder(String.valueOf(HttpUtils.getPlayerItemsUrl())).append("/").append(lllllllllllllllIlIlIIIIlIIllllIl));
        try {
            final byte[] lllllllllllllllIlIlIIIIlIlIIIIll = HttpPipeline.get(lllllllllllllllIlIlIIIIlIlIIIlII, Minecraft.getMinecraft().getProxy());
            final String lllllllllllllllIlIlIIIIlIlIIIIlI = new String(lllllllllllllllIlIlIIIIlIlIIIIll, "ASCII");
            final JsonParser lllllllllllllllIlIlIIIIlIlIIIIIl = new JsonParser();
            final JsonObject lllllllllllllllIlIlIIIIlIlIIIIII = (JsonObject)lllllllllllllllIlIlIIIIlIlIIIIIl.parse(lllllllllllllllIlIlIIIIlIlIIIIlI);
            final PlayerItemModel lllllllllllllllIlIlIIIIlIIllllll = PlayerItemParser.parseItemModel(lllllllllllllllIlIlIIIIlIlIIIIII);
            return lllllllllllllllIlIlIIIIlIIllllll;
        }
        catch (Exception lllllllllllllllIlIlIIIIlIIlllllI) {
            Config.warn(String.valueOf(new StringBuilder("Error loading item model ").append(lllllllllllllllIlIlIIIIlIIllllIl).append(": ").append(lllllllllllllllIlIlIIIIlIIlllllI.getClass().getName()).append(": ").append(lllllllllllllllIlIlIIIIlIIlllllI.getMessage())));
            return null;
        }
    }
}
