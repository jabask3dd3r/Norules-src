package optifine;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.settings.*;
import javax.imageio.*;
import net.minecraft.client.resources.*;
import java.awt.image.*;
import java.awt.*;
import java.util.*;

public class TextureAnimations
{
    private static /* synthetic */ TextureAnimation[] textureAnimations;
    
    public static void updateAnimations() {
        if (TextureAnimations.textureAnimations != null) {
            for (int lllllllllllllllIllIlIIllIllIIIll = 0; lllllllllllllllIllIlIIllIllIIIll < TextureAnimations.textureAnimations.length; ++lllllllllllllllIllIlIIllIllIIIll) {
                final TextureAnimation lllllllllllllllIllIlIIllIllIIIlI = TextureAnimations.textureAnimations[lllllllllllllllIllIlIIllIllIIIll];
                lllllllllllllllIllIlIIllIllIIIlI.updateTexture();
            }
        }
    }
    
    public static TextureAnimation makeTextureAnimation(final Properties lllllllllllllllIllIlIIllIIIlllIl, final ResourceLocation lllllllllllllllIllIlIIllIIIIlIlI) {
        String lllllllllllllllIllIlIIllIIIllIll = lllllllllllllllIllIlIIllIIIlllIl.getProperty("from");
        String lllllllllllllllIllIlIIllIIIllIlI = lllllllllllllllIllIlIIllIIIlllIl.getProperty("to");
        final int lllllllllllllllIllIlIIllIIIllIIl = Config.parseInt(lllllllllllllllIllIlIIllIIIlllIl.getProperty("x"), -1);
        final int lllllllllllllllIllIlIIllIIIllIII = Config.parseInt(lllllllllllllllIllIlIIllIIIlllIl.getProperty("y"), -1);
        final int lllllllllllllllIllIlIIllIIIlIlll = Config.parseInt(lllllllllllllllIllIlIIllIIIlllIl.getProperty("w"), -1);
        final int lllllllllllllllIllIlIIllIIIlIllI = Config.parseInt(lllllllllllllllIllIlIIllIIIlllIl.getProperty("h"), -1);
        if (lllllllllllllllIllIlIIllIIIllIll != null && lllllllllllllllIllIlIIllIIIllIlI != null) {
            if (lllllllllllllllIllIlIIllIIIllIIl >= 0 && lllllllllllllllIllIlIIllIIIllIII >= 0 && lllllllllllllllIllIlIIllIIIlIlll >= 0 && lllllllllllllllIllIlIIllIIIlIllI >= 0) {
                lllllllllllllllIllIlIIllIIIllIll = lllllllllllllllIllIlIIllIIIllIll.trim();
                lllllllllllllllIllIlIIllIIIllIlI = lllllllllllllllIllIlIIllIIIllIlI.trim();
                final String lllllllllllllllIllIlIIllIIIlIlIl = TextureUtils.getBasePath(lllllllllllllllIllIlIIllIIIIlIlI.getResourcePath());
                lllllllllllllllIllIlIIllIIIllIll = TextureUtils.fixResourcePath(lllllllllllllllIllIlIIllIIIllIll, lllllllllllllllIllIlIIllIIIlIlIl);
                lllllllllllllllIllIlIIllIIIllIlI = TextureUtils.fixResourcePath(lllllllllllllllIllIlIIllIIIllIlI, lllllllllllllllIllIlIIllIIIlIlIl);
                final byte[] lllllllllllllllIllIlIIllIIIlIlII = getCustomTextureData(lllllllllllllllIllIlIIllIIIllIll, lllllllllllllllIllIlIIllIIIlIlll);
                if (lllllllllllllllIllIlIIllIIIlIlII == null) {
                    Config.warn(String.valueOf(new StringBuilder("TextureAnimation: Source texture not found: ").append(lllllllllllllllIllIlIIllIIIllIlI)));
                    return null;
                }
                final int lllllllllllllllIllIlIIllIIIlIIll = lllllllllllllllIllIlIIllIIIlIlII.length / 4;
                final int lllllllllllllllIllIlIIllIIIlIIlI = lllllllllllllllIllIlIIllIIIlIIll / (lllllllllllllllIllIlIIllIIIlIlll * lllllllllllllllIllIlIIllIIIlIllI);
                final int lllllllllllllllIllIlIIllIIIlIIIl = lllllllllllllllIllIlIIllIIIlIIlI * lllllllllllllllIllIlIIllIIIlIlll * lllllllllllllllIllIlIIllIIIlIllI;
                if (lllllllllllllllIllIlIIllIIIlIIll != lllllllllllllllIllIlIIllIIIlIIIl) {
                    Config.warn(String.valueOf(new StringBuilder("TextureAnimation: Source texture has invalid number of frames: ").append(lllllllllllllllIllIlIIllIIIllIll).append(", frames: ").append(lllllllllllllllIllIlIIllIIIlIIll / (float)(lllllllllllllllIllIlIIllIIIlIlll * lllllllllllllllIllIlIIllIIIlIllI))));
                    return null;
                }
                final ResourceLocation lllllllllllllllIllIlIIllIIIlIIII = new ResourceLocation(lllllllllllllllIllIlIIllIIIllIlI);
                try {
                    final InputStream lllllllllllllllIllIlIIllIIIIllll = Config.getResourceStream(lllllllllllllllIllIlIIllIIIlIIII);
                    if (lllllllllllllllIllIlIIllIIIIllll == null) {
                        Config.warn(String.valueOf(new StringBuilder("TextureAnimation: Target texture not found: ").append(lllllllllllllllIllIlIIllIIIllIlI)));
                        return null;
                    }
                    final BufferedImage lllllllllllllllIllIlIIllIIIIlllI = readTextureImage(lllllllllllllllIllIlIIllIIIIllll);
                    if (lllllllllllllllIllIlIIllIIIllIIl + lllllllllllllllIllIlIIllIIIlIlll <= lllllllllllllllIllIlIIllIIIIlllI.getWidth() && lllllllllllllllIllIlIIllIIIllIII + lllllllllllllllIllIlIIllIIIlIllI <= lllllllllllllllIllIlIIllIIIIlllI.getHeight()) {
                        final TextureAnimation lllllllllllllllIllIlIIllIIIIllIl = new TextureAnimation(lllllllllllllllIllIlIIllIIIllIll, lllllllllllllllIllIlIIllIIIlIlII, lllllllllllllllIllIlIIllIIIllIlI, lllllllllllllllIllIlIIllIIIlIIII, lllllllllllllllIllIlIIllIIIllIIl, lllllllllllllllIllIlIIllIIIllIII, lllllllllllllllIllIlIIllIIIlIlll, lllllllllllllllIllIlIIllIIIlIllI, lllllllllllllllIllIlIIllIIIlllIl, 1);
                        return lllllllllllllllIllIlIIllIIIIllIl;
                    }
                    Config.warn(String.valueOf(new StringBuilder("TextureAnimation: Animation coordinates are outside the target texture: ").append(lllllllllllllllIllIlIIllIIIllIlI)));
                    return null;
                }
                catch (IOException lllllllllllllllIllIlIIllIIIIllII) {
                    Config.warn(String.valueOf(new StringBuilder("TextureAnimation: Target texture not found: ").append(lllllllllllllllIllIlIIllIIIllIlI)));
                    return null;
                }
            }
            Config.warn("TextureAnimation: Invalid coordinates");
            return null;
        }
        Config.warn("TextureAnimation: Source or target texture not specified");
        return null;
    }
    
    private static byte[] loadImage(final String lllllllllllllllIllIlIIlIlIllllll, final int lllllllllllllllIllIlIIlIllIllllI) {
        final GameSettings lllllllllllllllIllIlIIlIllIlllIl = Config.getGameSettings();
        try {
            final ResourceLocation lllllllllllllllIllIlIIlIllIlllII = new ResourceLocation(lllllllllllllllIllIlIIlIlIllllll);
            final InputStream lllllllllllllllIllIlIIlIllIllIll = Config.getResourceStream(lllllllllllllllIllIlIIlIllIlllII);
            if (lllllllllllllllIllIlIIlIllIllIll == null) {
                return null;
            }
            BufferedImage lllllllllllllllIllIlIIlIllIllIlI = readTextureImage(lllllllllllllllIllIlIIlIllIllIll);
            lllllllllllllllIllIlIIlIllIllIll.close();
            if (lllllllllllllllIllIlIIlIllIllIlI == null) {
                return null;
            }
            if (lllllllllllllllIllIlIIlIllIllllI > 0 && lllllllllllllllIllIlIIlIllIllIlI.getWidth() != lllllllllllllllIllIlIIlIllIllllI) {
                final double lllllllllllllllIllIlIIlIllIllIIl = lllllllllllllllIllIlIIlIllIllIlI.getHeight() / lllllllllllllllIllIlIIlIllIllIlI.getWidth();
                final int lllllllllllllllIllIlIIlIllIllIII = (int)(lllllllllllllllIllIlIIlIllIllllI * lllllllllllllllIllIlIIlIllIllIIl);
                lllllllllllllllIllIlIIlIllIllIlI = scaleBufferedImage(lllllllllllllllIllIlIIlIllIllIlI, lllllllllllllllIllIlIIlIllIllllI, lllllllllllllllIllIlIIlIllIllIII);
            }
            final int lllllllllllllllIllIlIIlIllIlIlll = lllllllllllllllIllIlIIlIllIllIlI.getWidth();
            final int lllllllllllllllIllIlIIlIllIlIllI = lllllllllllllllIllIlIIlIllIllIlI.getHeight();
            final int[] lllllllllllllllIllIlIIlIllIlIlIl = new int[lllllllllllllllIllIlIIlIllIlIlll * lllllllllllllllIllIlIIlIllIlIllI];
            final byte[] lllllllllllllllIllIlIIlIllIlIIll = new byte[lllllllllllllllIllIlIIlIllIlIlll * lllllllllllllllIllIlIIlIllIlIllI * 4];
            lllllllllllllllIllIlIIlIllIllIlI.getRGB(0, 0, lllllllllllllllIllIlIIlIllIlIlll, lllllllllllllllIllIlIIlIllIlIllI, lllllllllllllllIllIlIIlIllIlIlIl, 0, lllllllllllllllIllIlIIlIllIlIlll);
            for (int lllllllllllllllIllIlIIlIllIlIIlI = 0; lllllllllllllllIllIlIIlIllIlIIlI < lllllllllllllllIllIlIIlIllIlIlIl.length; ++lllllllllllllllIllIlIIlIllIlIIlI) {
                final int lllllllllllllllIllIlIIlIllIlIIII = lllllllllllllllIllIlIIlIllIlIlIl[lllllllllllllllIllIlIIlIllIlIIlI] >> 24 & 0xFF;
                int lllllllllllllllIllIlIIlIllIIlllI = lllllllllllllllIllIlIIlIllIlIlIl[lllllllllllllllIllIlIIlIllIlIIlI] >> 16 & 0xFF;
                int lllllllllllllllIllIlIIlIllIIllII = lllllllllllllllIllIlIIlIllIlIlIl[lllllllllllllllIllIlIIlIllIlIIlI] >> 8 & 0xFF;
                int lllllllllllllllIllIlIIlIllIIlIlI = lllllllllllllllIllIlIIlIllIlIlIl[lllllllllllllllIllIlIIlIllIlIIlI] & 0xFF;
                if (lllllllllllllllIllIlIIlIllIlllIl != null && lllllllllllllllIllIlIIlIllIlllIl.anaglyph) {
                    final int lllllllllllllllIllIlIIlIllIIlIII = (lllllllllllllllIllIlIIlIllIIlllI * 30 + lllllllllllllllIllIlIIlIllIIllII * 59 + lllllllllllllllIllIlIIlIllIIlIlI * 11) / 100;
                    final int lllllllllllllllIllIlIIlIllIIIllI = (lllllllllllllllIllIlIIlIllIIlllI * 30 + lllllllllllllllIllIlIIlIllIIllII * 70) / 100;
                    final int lllllllllllllllIllIlIIlIllIIIlII = (lllllllllllllllIllIlIIlIllIIlllI * 30 + lllllllllllllllIllIlIIlIllIIlIlI * 70) / 100;
                    lllllllllllllllIllIlIIlIllIIlllI = lllllllllllllllIllIlIIlIllIIlIII;
                    lllllllllllllllIllIlIIlIllIIllII = lllllllllllllllIllIlIIlIllIIIllI;
                    lllllllllllllllIllIlIIlIllIIlIlI = lllllllllllllllIllIlIIlIllIIIlII;
                }
                lllllllllllllllIllIlIIlIllIlIIll[lllllllllllllllIllIlIIlIllIlIIlI * 4 + 0] = (byte)lllllllllllllllIllIlIIlIllIIlllI;
                lllllllllllllllIllIlIIlIllIlIIll[lllllllllllllllIllIlIIlIllIlIIlI * 4 + 1] = (byte)lllllllllllllllIllIlIIlIllIIllII;
                lllllllllllllllIllIlIIlIllIlIIll[lllllllllllllllIllIlIIlIllIlIIlI * 4 + 2] = (byte)lllllllllllllllIllIlIIlIllIIlIlI;
                lllllllllllllllIllIlIIlIllIlIIll[lllllllllllllllIllIlIIlIllIlIIlI * 4 + 3] = (byte)lllllllllllllllIllIlIIlIllIlIIII;
            }
            return lllllllllllllllIllIlIIlIllIlIIll;
        }
        catch (FileNotFoundException lllllllllllllllIllIlIIlIllIIIIlI) {
            return null;
        }
        catch (Exception lllllllllllllllIllIlIIlIllIIIIIl) {
            lllllllllllllllIllIlIIlIllIIIIIl.printStackTrace();
            return null;
        }
    }
    
    private static BufferedImage readTextureImage(final InputStream lllllllllllllllIllIlIIlIlIIlIlll) throws IOException {
        final BufferedImage lllllllllllllllIllIlIIlIlIIllIIl = ImageIO.read(lllllllllllllllIllIlIIlIlIIlIlll);
        lllllllllllllllIllIlIIlIlIIlIlll.close();
        return lllllllllllllllIllIlIIlIlIIllIIl;
    }
    
    public static void reset() {
        TextureAnimations.textureAnimations = null;
    }
    
    static {
        TextureAnimations.textureAnimations = null;
    }
    
    public static void update() {
        TextureAnimations.textureAnimations = null;
        final IResourcePack[] lllllllllllllllIllIlIIllIllIIlll = Config.getResourcePacks();
        TextureAnimations.textureAnimations = getTextureAnimations(lllllllllllllllIllIlIIllIllIIlll);
        if (Config.isAnimatedTextures()) {
            updateAnimations();
        }
    }
    
    public static BufferedImage scaleBufferedImage(final BufferedImage lllllllllllllllIllIlIIlIlIIIIlIl, final int lllllllllllllllIllIlIIlIIlllllll, final int lllllllllllllllIllIlIIlIlIIIIIll) {
        final BufferedImage lllllllllllllllIllIlIIlIlIIIIIlI = new BufferedImage(lllllllllllllllIllIlIIlIIlllllll, lllllllllllllllIllIlIIlIlIIIIIll, 2);
        final Graphics2D lllllllllllllllIllIlIIlIlIIIIIIl = lllllllllllllllIllIlIIlIlIIIIIlI.createGraphics();
        lllllllllllllllIllIlIIlIlIIIIIIl.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        lllllllllllllllIllIlIIlIlIIIIIIl.drawImage(lllllllllllllllIllIlIIlIlIIIIlIl, 0, 0, lllllllllllllllIllIlIIlIIlllllll, lllllllllllllllIllIlIIlIlIIIIIll, null);
        return lllllllllllllllIllIlIIlIlIIIIIlI;
    }
    
    public static TextureAnimation[] getTextureAnimations(final IResourcePack[] lllllllllllllllIllIlIIllIlIlIlII) {
        final List lllllllllllllllIllIlIIllIlIllIIl = new ArrayList();
        for (int lllllllllllllllIllIlIIllIlIllIII = 0; lllllllllllllllIllIlIIllIlIllIII < lllllllllllllllIllIlIIllIlIlIlII.length; ++lllllllllllllllIllIlIIllIlIllIII) {
            final IResourcePack lllllllllllllllIllIlIIllIlIlIlll = lllllllllllllllIllIlIIllIlIlIlII[lllllllllllllllIllIlIIllIlIllIII];
            final TextureAnimation[] lllllllllllllllIllIlIIllIlIlIllI = getTextureAnimations(lllllllllllllllIllIlIIllIlIlIlll);
            if (lllllllllllllllIllIlIIllIlIlIllI != null) {
                lllllllllllllllIllIlIIllIlIllIIl.addAll(Arrays.asList(lllllllllllllllIllIlIIllIlIlIllI));
            }
        }
        final TextureAnimation[] lllllllllllllllIllIlIIllIlIlIlIl = lllllllllllllllIllIlIIllIlIllIIl.toArray(new TextureAnimation[lllllllllllllllIllIlIIllIlIllIIl.size()]);
        return lllllllllllllllIllIlIIllIlIlIlIl;
    }
    
    public static byte[] getCustomTextureData(final String lllllllllllllllIllIlIIlIllllIlll, final int lllllllllllllllIllIlIIlIllllIIll) {
        byte[] lllllllllllllllIllIlIIlIllllIlIl = loadImage(lllllllllllllllIllIlIIlIllllIlll, lllllllllllllllIllIlIIlIllllIIll);
        if (lllllllllllllllIllIlIIlIllllIlIl == null) {
            lllllllllllllllIllIlIIlIllllIlIl = loadImage(String.valueOf(new StringBuilder("/anim").append(lllllllllllllllIllIlIIlIllllIlll)), lllllllllllllllIllIlIIlIllllIIll);
        }
        return lllllllllllllllIllIlIIlIllllIlIl;
    }
    
    public static void updateCustomAnimations() {
        if (TextureAnimations.textureAnimations != null && Config.isAnimatedTextures()) {
            updateAnimations();
        }
    }
    
    public static TextureAnimation[] getTextureAnimations(final IResourcePack lllllllllllllllIllIlIIllIlIIIlIl) {
        final String[] lllllllllllllllIllIlIIllIlIIIlII = ResUtils.collectFiles(lllllllllllllllIllIlIIllIlIIIlIl, "mcpatcher/anim/", ".properties", null);
        if (lllllllllllllllIllIlIIllIlIIIlII.length <= 0) {
            return null;
        }
        final List lllllllllllllllIllIlIIllIlIIIIll = new ArrayList();
        for (int lllllllllllllllIllIlIIllIlIIIIlI = 0; lllllllllllllllIllIlIIllIlIIIIlI < lllllllllllllllIllIlIIllIlIIIlII.length; ++lllllllllllllllIllIlIIllIlIIIIlI) {
            final String lllllllllllllllIllIlIIllIlIIIIIl = lllllllllllllllIllIlIIllIlIIIlII[lllllllllllllllIllIlIIllIlIIIIlI];
            Config.dbg(String.valueOf(new StringBuilder("Texture animation: ").append(lllllllllllllllIllIlIIllIlIIIIIl)));
            try {
                final ResourceLocation lllllllllllllllIllIlIIllIlIIIIII = new ResourceLocation(lllllllllllllllIllIlIIllIlIIIIIl);
                final InputStream lllllllllllllllIllIlIIllIIllllll = lllllllllllllllIllIlIIllIlIIIlIl.getInputStream(lllllllllllllllIllIlIIllIlIIIIII);
                final Properties lllllllllllllllIllIlIIllIIlllllI = new Properties();
                lllllllllllllllIllIlIIllIIlllllI.load(lllllllllllllllIllIlIIllIIllllll);
                final TextureAnimation lllllllllllllllIllIlIIllIIllllIl = makeTextureAnimation(lllllllllllllllIllIlIIllIIlllllI, lllllllllllllllIllIlIIllIlIIIIII);
                if (lllllllllllllllIllIlIIllIIllllIl != null) {
                    final ResourceLocation lllllllllllllllIllIlIIllIIllllII = new ResourceLocation(lllllllllllllllIllIlIIllIIllllIl.getDstTex());
                    if (Config.getDefiningResourcePack(lllllllllllllllIllIlIIllIIllllII) != lllllllllllllllIllIlIIllIlIIIlIl) {
                        Config.dbg(String.valueOf(new StringBuilder("Skipped: ").append(lllllllllllllllIllIlIIllIlIIIIIl).append(", target texture not loaded from same resource pack")));
                    }
                    else {
                        lllllllllllllllIllIlIIllIlIIIIll.add(lllllllllllllllIllIlIIllIIllllIl);
                    }
                }
            }
            catch (FileNotFoundException lllllllllllllllIllIlIIllIIlllIll) {
                Config.warn(String.valueOf(new StringBuilder("File not found: ").append(lllllllllllllllIllIlIIllIIlllIll.getMessage())));
            }
            catch (IOException lllllllllllllllIllIlIIllIIlllIlI) {
                lllllllllllllllIllIlIIllIIlllIlI.printStackTrace();
            }
        }
        final TextureAnimation[] lllllllllllllllIllIlIIllIIlllIIl = lllllllllllllllIllIlIIllIlIIIIll.toArray(new TextureAnimation[lllllllllllllllIllIlIIllIlIIIIll.size()]);
        return lllllllllllllllIllIlIIllIIlllIIl;
    }
}
