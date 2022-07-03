package optifine;

import net.minecraft.util.math.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.*;
import java.util.*;
import java.io.*;
import net.minecraft.client.renderer.texture.*;

public class NaturalTextures
{
    private static /* synthetic */ NaturalProperties[] propertiesByIndex;
    
    public static BakedQuad getNaturalTexture(final BlockPos lllllllllllllIIllIlIllIIllllIIIl, final BakedQuad lllllllllllllIIllIlIllIIlllIlIII) {
        final TextureAtlasSprite lllllllllllllIIllIlIllIIlllIllll = lllllllllllllIIllIlIllIIlllIlIII.getSprite();
        if (lllllllllllllIIllIlIllIIlllIllll == null) {
            return lllllllllllllIIllIlIllIIlllIlIII;
        }
        final NaturalProperties lllllllllllllIIllIlIllIIlllIlllI = getNaturalProperties(lllllllllllllIIllIlIllIIlllIllll);
        if (lllllllllllllIIllIlIllIIlllIlllI == null) {
            return lllllllllllllIIllIlIllIIlllIlIII;
        }
        final int lllllllllllllIIllIlIllIIlllIllIl = ConnectedTextures.getSide(lllllllllllllIIllIlIllIIlllIlIII.getFace());
        final int lllllllllllllIIllIlIllIIlllIllII = Config.getRandom(lllllllllllllIIllIlIllIIllllIIIl, lllllllllllllIIllIlIllIIlllIllIl);
        int lllllllllllllIIllIlIllIIlllIlIll = 0;
        boolean lllllllllllllIIllIlIllIIlllIlIlI = false;
        if (lllllllllllllIIllIlIllIIlllIlllI.rotation > 1) {
            lllllllllllllIIllIlIllIIlllIlIll = (lllllllllllllIIllIlIllIIlllIllII & 0x3);
        }
        if (lllllllllllllIIllIlIllIIlllIlllI.rotation == 2) {
            lllllllllllllIIllIlIllIIlllIlIll = lllllllllllllIIllIlIllIIlllIlIll / 2 * 2;
        }
        if (lllllllllllllIIllIlIllIIlllIlllI.flip) {
            lllllllllllllIIllIlIllIIlllIlIlI = ((lllllllllllllIIllIlIllIIlllIllII & 0x4) != 0x0);
        }
        return lllllllllllllIIllIlIllIIlllIlllI.getQuad(lllllllllllllIIllIlIllIIlllIlIII, lllllllllllllIIllIlIllIIlllIlIll, lllllllllllllIIllIlIllIIlllIlIlI);
    }
    
    public static void update() {
        NaturalTextures.propertiesByIndex = new NaturalProperties[0];
        if (Config.isNaturalTextures()) {
            final String lllllllllllllIIllIlIllIlIIIllIll = "optifine/natural.properties";
            try {
                final ResourceLocation lllllllllllllIIllIlIllIlIIIllIlI = new ResourceLocation(lllllllllllllIIllIlIllIlIIIllIll);
                if (!Config.hasResource(lllllllllllllIIllIlIllIlIIIllIlI)) {
                    Config.dbg(String.valueOf(new StringBuilder("NaturalTextures: configuration \"").append(lllllllllllllIIllIlIllIlIIIllIll).append("\" not found")));
                    return;
                }
                final boolean lllllllllllllIIllIlIllIlIIIllIIl = Config.isFromDefaultResourcePack(lllllllllllllIIllIlIllIlIIIllIlI);
                final InputStream lllllllllllllIIllIlIllIlIIIllIII = Config.getResourceStream(lllllllllllllIIllIlIllIlIIIllIlI);
                final ArrayList lllllllllllllIIllIlIllIlIIIlIlll = new ArrayList(256);
                final String lllllllllllllIIllIlIllIlIIIlIllI = Config.readInputStream(lllllllllllllIIllIlIllIlIIIllIII);
                lllllllllllllIIllIlIllIlIIIllIII.close();
                final String[] lllllllllllllIIllIlIllIlIIIlIlIl = Config.tokenize(lllllllllllllIIllIlIllIlIIIlIllI, "\n\r");
                if (lllllllllllllIIllIlIllIlIIIllIIl) {
                    Config.dbg(String.valueOf(new StringBuilder("Natural Textures: Parsing default configuration \"").append(lllllllllllllIIllIlIllIlIIIllIll).append("\"")));
                    Config.dbg("Natural Textures: Valid only for textures from default resource pack");
                }
                else {
                    Config.dbg(String.valueOf(new StringBuilder("Natural Textures: Parsing configuration \"").append(lllllllllllllIIllIlIllIlIIIllIll).append("\"")));
                }
                final TextureMap lllllllllllllIIllIlIllIlIIIlIlII = TextureUtils.getTextureMapBlocks();
                for (int lllllllllllllIIllIlIllIlIIIlIIll = 0; lllllllllllllIIllIlIllIlIIIlIIll < lllllllllllllIIllIlIllIlIIIlIlIl.length; ++lllllllllllllIIllIlIllIlIIIlIIll) {
                    final String lllllllllllllIIllIlIllIlIIIlIIlI = lllllllllllllIIllIlIllIlIIIlIlIl[lllllllllllllIIllIlIllIlIIIlIIll].trim();
                    if (!lllllllllllllIIllIlIllIlIIIlIIlI.startsWith("#")) {
                        final String[] lllllllllllllIIllIlIllIlIIIlIIIl = Config.tokenize(lllllllllllllIIllIlIllIlIIIlIIlI, "=");
                        if (lllllllllllllIIllIlIllIlIIIlIIIl.length != 2) {
                            Config.warn(String.valueOf(new StringBuilder("Natural Textures: Invalid \"").append(lllllllllllllIIllIlIllIlIIIllIll).append("\" line: ").append(lllllllllllllIIllIlIllIlIIIlIIlI)));
                        }
                        else {
                            final String lllllllllllllIIllIlIllIlIIIlIIII = lllllllllllllIIllIlIllIlIIIlIIIl[0].trim();
                            final String lllllllllllllIIllIlIllIlIIIIllll = lllllllllllllIIllIlIllIlIIIlIIIl[1].trim();
                            final TextureAtlasSprite lllllllllllllIIllIlIllIlIIIIlllI = lllllllllllllIIllIlIllIlIIIlIlII.getSpriteSafe(String.valueOf(new StringBuilder("minecraft:blocks/").append(lllllllllllllIIllIlIllIlIIIlIIII)));
                            if (lllllllllllllIIllIlIllIlIIIIlllI == null) {
                                Config.warn(String.valueOf(new StringBuilder("Natural Textures: Texture not found: \"").append(lllllllllllllIIllIlIllIlIIIllIll).append("\" line: ").append(lllllllllllllIIllIlIllIlIIIlIIlI)));
                            }
                            else {
                                final int lllllllllllllIIllIlIllIlIIIIllIl = lllllllllllllIIllIlIllIlIIIIlllI.getIndexInMap();
                                if (lllllllllllllIIllIlIllIlIIIIllIl < 0) {
                                    Config.warn(String.valueOf(new StringBuilder("Natural Textures: Invalid \"").append(lllllllllllllIIllIlIllIlIIIllIll).append("\" line: ").append(lllllllllllllIIllIlIllIlIIIlIIlI)));
                                }
                                else {
                                    if (lllllllllllllIIllIlIllIlIIIllIIl && !Config.isFromDefaultResourcePack(new ResourceLocation(String.valueOf(new StringBuilder("textures/blocks/").append(lllllllllllllIIllIlIllIlIIIlIIII).append(".png"))))) {
                                        return;
                                    }
                                    final NaturalProperties lllllllllllllIIllIlIllIlIIIIllII = new NaturalProperties(lllllllllllllIIllIlIllIlIIIIllll);
                                    if (lllllllllllllIIllIlIllIlIIIIllII.isValid()) {
                                        while (lllllllllllllIIllIlIllIlIIIlIlll.size() <= lllllllllllllIIllIlIllIlIIIIllIl) {
                                            lllllllllllllIIllIlIllIlIIIlIlll.add(null);
                                        }
                                        lllllllllllllIIllIlIllIlIIIlIlll.set(lllllllllllllIIllIlIllIlIIIIllIl, lllllllllllllIIllIlIllIlIIIIllII);
                                        Config.dbg(String.valueOf(new StringBuilder("NaturalTextures: ").append(lllllllllllllIIllIlIllIlIIIlIIII).append(" = ").append(lllllllllllllIIllIlIllIlIIIIllll)));
                                    }
                                }
                            }
                        }
                    }
                }
                NaturalTextures.propertiesByIndex = lllllllllllllIIllIlIllIlIIIlIlll.toArray(new NaturalProperties[lllllllllllllIIllIlIllIlIIIlIlll.size()]);
            }
            catch (FileNotFoundException lllllllllllllIIllIlIllIlIIIIlIll) {
                Config.warn(String.valueOf(new StringBuilder("NaturalTextures: configuration \"").append(lllllllllllllIIllIlIllIlIIIllIll).append("\" not found")));
            }
            catch (Exception lllllllllllllIIllIlIllIlIIIIlIlI) {
                lllllllllllllIIllIlIllIlIIIIlIlI.printStackTrace();
            }
        }
    }
    
    public static NaturalProperties getNaturalProperties(final TextureAtlasSprite lllllllllllllIIllIlIllIIllIllllI) {
        if (!(lllllllllllllIIllIlIllIIllIllllI instanceof TextureAtlasSprite)) {
            return null;
        }
        final int lllllllllllllIIllIlIllIIllIlllIl = lllllllllllllIIllIlIllIIllIllllI.getIndexInMap();
        if (lllllllllllllIIllIlIllIIllIlllIl >= 0 && lllllllllllllIIllIlIllIIllIlllIl < NaturalTextures.propertiesByIndex.length) {
            final NaturalProperties lllllllllllllIIllIlIllIIllIlllII = NaturalTextures.propertiesByIndex[lllllllllllllIIllIlIllIIllIlllIl];
            return lllllllllllllIIllIlIllIIllIlllII;
        }
        return null;
    }
    
    static {
        NaturalTextures.propertiesByIndex = new NaturalProperties[0];
    }
}
