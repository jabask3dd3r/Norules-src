package optifine;

import net.minecraft.world.*;
import net.minecraft.util.*;
import java.util.*;
import java.io.*;
import net.minecraft.client.renderer.texture.*;

public class CustomSky
{
    private static /* synthetic */ CustomSkyLayer[][] worldSkyLayers;
    
    static {
        CustomSky.worldSkyLayers = null;
    }
    
    public static void renderSky(final World lllllllllllllIlIllIIIllIIlIIIIlI, final TextureManager lllllllllllllIlIllIIIllIIlIIlllI, final float lllllllllllllIlIllIIIllIIlIIIIIl) {
        if (CustomSky.worldSkyLayers != null) {
            final int lllllllllllllIlIllIIIllIIlIIllII = lllllllllllllIlIllIIIllIIlIIIIlI.provider.getDimensionType().getId();
            if (lllllllllllllIlIllIIIllIIlIIllII >= 0 && lllllllllllllIlIllIIIllIIlIIllII < CustomSky.worldSkyLayers.length) {
                final CustomSkyLayer[] lllllllllllllIlIllIIIllIIlIIlIll = CustomSky.worldSkyLayers[lllllllllllllIlIllIIIllIIlIIllII];
                if (lllllllllllllIlIllIIIllIIlIIlIll != null) {
                    final long lllllllllllllIlIllIIIllIIlIIlIlI = lllllllllllllIlIllIIIllIIlIIIIlI.getWorldTime();
                    final int lllllllllllllIlIllIIIllIIlIIlIIl = (int)(lllllllllllllIlIllIIIllIIlIIlIlI % 24000L);
                    final float lllllllllllllIlIllIIIllIIlIIlIII = lllllllllllllIlIllIIIllIIlIIIIlI.getCelestialAngle(lllllllllllllIlIllIIIllIIlIIIIIl);
                    final float lllllllllllllIlIllIIIllIIlIIIlll = lllllllllllllIlIllIIIllIIlIIIIlI.getRainStrength(lllllllllllllIlIllIIIllIIlIIIIIl);
                    float lllllllllllllIlIllIIIllIIlIIIllI = lllllllllllllIlIllIIIllIIlIIIIlI.getThunderStrength(lllllllllllllIlIllIIIllIIlIIIIIl);
                    if (lllllllllllllIlIllIIIllIIlIIIlll > 0.0f) {
                        lllllllllllllIlIllIIIllIIlIIIllI /= lllllllllllllIlIllIIIllIIlIIIlll;
                    }
                    for (int lllllllllllllIlIllIIIllIIlIIIlIl = 0; lllllllllllllIlIllIIIllIIlIIIlIl < lllllllllllllIlIllIIIllIIlIIlIll.length; ++lllllllllllllIlIllIIIllIIlIIIlIl) {
                        final CustomSkyLayer lllllllllllllIlIllIIIllIIlIIIlII = lllllllllllllIlIllIIIllIIlIIlIll[lllllllllllllIlIllIIIllIIlIIIlIl];
                        if (lllllllllllllIlIllIIIllIIlIIIlII.isActive(lllllllllllllIlIllIIIllIIlIIIIlI, lllllllllllllIlIllIIIllIIlIIlIIl)) {
                            lllllllllllllIlIllIIIllIIlIIIlII.render(lllllllllllllIlIllIIIllIIlIIlIIl, lllllllllllllIlIllIIIllIIlIIlIII, lllllllllllllIlIllIIIllIIlIIIlll, lllllllllllllIlIllIIIllIIlIIIllI);
                        }
                    }
                    final float lllllllllllllIlIllIIIllIIlIIIIll = 1.0f - lllllllllllllIlIllIIIllIIlIIIlll;
                    Blender.clearBlend(lllllllllllllIlIllIIIllIIlIIIIll);
                }
            }
        }
    }
    
    public static void reset() {
        CustomSky.worldSkyLayers = null;
    }
    
    public static boolean hasSkyLayers(final World lllllllllllllIlIllIIIllIIIllIIIl) {
        if (CustomSky.worldSkyLayers == null) {
            return false;
        }
        if (Config.getGameSettings().renderDistanceChunks < 8) {
            return false;
        }
        final int lllllllllllllIlIllIIIllIIIllIIll = lllllllllllllIlIllIIIllIIIllIIIl.provider.getDimensionType().getId();
        if (lllllllllllllIlIllIIIllIIIllIIll >= 0 && lllllllllllllIlIllIIIllIIIllIIll < CustomSky.worldSkyLayers.length) {
            final CustomSkyLayer[] lllllllllllllIlIllIIIllIIIllIIlI = CustomSky.worldSkyLayers[lllllllllllllIlIllIIIllIIIllIIll];
            return lllllllllllllIlIllIIIllIIIllIIlI != null && lllllllllllllIlIllIIIllIIIllIIlI.length > 0;
        }
        return false;
    }
    
    public static void update() {
        reset();
        if (Config.isCustomSky()) {
            CustomSky.worldSkyLayers = readCustomSkies();
        }
    }
    
    private static CustomSkyLayer[][] readCustomSkies() {
        final CustomSkyLayer[][] lllllllllllllIlIllIIIllIlIIIIlII = new CustomSkyLayer[10][0];
        final String lllllllllllllIlIllIIIllIlIIIIIll = "mcpatcher/sky/world";
        int lllllllllllllIlIllIIIllIlIIIIIlI = -1;
        for (int lllllllllllllIlIllIIIllIlIIIIIIl = 0; lllllllllllllIlIllIIIllIlIIIIIIl < lllllllllllllIlIllIIIllIlIIIIlII.length; ++lllllllllllllIlIllIIIllIlIIIIIIl) {
            final String lllllllllllllIlIllIIIllIlIIIIIII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIllIlIIIIIll)).append(lllllllllllllIlIllIIIllIlIIIIIIl).append("/sky"));
            final List lllllllllllllIlIllIIIllIIlllllll = new ArrayList();
            for (int lllllllllllllIlIllIIIllIIllllllI = 1; lllllllllllllIlIllIIIllIIllllllI < 1000; ++lllllllllllllIlIllIIIllIIllllllI) {
                final String lllllllllllllIlIllIIIllIIlllllIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIllIlIIIIIII)).append(lllllllllllllIlIllIIIllIIllllllI).append(".properties"));
                try {
                    final ResourceLocation lllllllllllllIlIllIIIllIIllllIll = new ResourceLocation(lllllllllllllIlIllIIIllIIlllllIl);
                    final InputStream lllllllllllllIlIllIIIllIIllllIlI = Config.getResourceStream(lllllllllllllIlIllIIIllIIllllIll);
                    if (lllllllllllllIlIllIIIllIIllllIlI == null) {
                        break;
                    }
                    final Properties lllllllllllllIlIllIIIllIIllllIII = new Properties();
                    lllllllllllllIlIllIIIllIIllllIII.load(lllllllllllllIlIllIIIllIIllllIlI);
                    lllllllllllllIlIllIIIllIIllllIlI.close();
                    Config.dbg(String.valueOf(new StringBuilder("CustomSky properties: ").append(lllllllllllllIlIllIIIllIIlllllIl)));
                    final String lllllllllllllIlIllIIIllIIlllIllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIllIlIIIIIII)).append(lllllllllllllIlIllIIIllIIllllllI).append(".png"));
                    final CustomSkyLayer lllllllllllllIlIllIIIllIIlllIlII = new CustomSkyLayer(lllllllllllllIlIllIIIllIIllllIII, lllllllllllllIlIllIIIllIIlllIllI);
                    if (lllllllllllllIlIllIIIllIIlllIlII.isValid(lllllllllllllIlIllIIIllIIlllllIl)) {
                        final ResourceLocation lllllllllllllIlIllIIIllIIlllIIll = new ResourceLocation(lllllllllllllIlIllIIIllIIlllIlII.source);
                        final ITextureObject lllllllllllllIlIllIIIllIIlllIIlI = TextureUtils.getTexture(lllllllllllllIlIllIIIllIIlllIIll);
                        if (lllllllllllllIlIllIIIllIIlllIIlI == null) {
                            Config.log(String.valueOf(new StringBuilder("CustomSky: Texture not found: ").append(lllllllllllllIlIllIIIllIIlllIIll)));
                        }
                        else {
                            lllllllllllllIlIllIIIllIIlllIlII.textureId = lllllllllllllIlIllIIIllIIlllIIlI.getGlTextureId();
                            lllllllllllllIlIllIIIllIIlllllll.add(lllllllllllllIlIllIIIllIIlllIlII);
                            lllllllllllllIlIllIIIllIIllllIlI.close();
                        }
                    }
                }
                catch (FileNotFoundException lllllllllllllIlIllIIIllIIlllIIIl) {
                    break;
                }
                catch (IOException lllllllllllllIlIllIIIllIIllIllll) {
                    lllllllllllllIlIllIIIllIIllIllll.printStackTrace();
                }
            }
            if (lllllllllllllIlIllIIIllIIlllllll.size() > 0) {
                final CustomSkyLayer[] lllllllllllllIlIllIIIllIIllIllIl = lllllllllllllIlIllIIIllIIlllllll.toArray(new CustomSkyLayer[lllllllllllllIlIllIIIllIIlllllll.size()]);
                lllllllllllllIlIllIIIllIlIIIIlII[lllllllllllllIlIllIIIllIlIIIIIIl] = lllllllllllllIlIllIIIllIIllIllIl;
                lllllllllllllIlIllIIIllIlIIIIIlI = lllllllllllllIlIllIIIllIlIIIIIIl;
            }
        }
        if (lllllllllllllIlIllIIIllIlIIIIIlI < 0) {
            return null;
        }
        final int lllllllllllllIlIllIIIllIIllIllII = lllllllllllllIlIllIIIllIlIIIIIlI + 1;
        final CustomSkyLayer[][] lllllllllllllIlIllIIIllIIllIlIll = new CustomSkyLayer[lllllllllllllIlIllIIIllIIllIllII][0];
        for (int lllllllllllllIlIllIIIllIIllIlIlI = 0; lllllllllllllIlIllIIIllIIllIlIlI < lllllllllllllIlIllIIIllIIllIlIll.length; ++lllllllllllllIlIllIIIllIIllIlIlI) {
            lllllllllllllIlIllIIIllIIllIlIll[lllllllllllllIlIllIIIllIIllIlIlI] = lllllllllllllIlIllIIIllIlIIIIlII[lllllllllllllIlIllIIIllIIllIlIlI];
        }
        return lllllllllllllIlIllIIIllIIllIlIll;
    }
}
