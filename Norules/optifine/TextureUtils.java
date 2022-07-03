package optifine;

import java.nio.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import org.lwjgl.*;
import javax.imageio.*;
import net.optifine.entity.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import java.util.*;
import net.minecraft.client.resources.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.texture.*;
import java.awt.image.*;
import net.minecraft.client.renderer.*;
import java.io.*;
import java.awt.*;

public class TextureUtils
{
    public static /* synthetic */ TextureAtlasSprite iconLavaFlow;
    public static /* synthetic */ TextureAtlasSprite iconMyceliumSide;
    public static /* synthetic */ TextureAtlasSprite iconGlass;
    public static /* synthetic */ TextureAtlasSprite iconSnow;
    public static /* synthetic */ TextureAtlasSprite iconMyceliumTop;
    public static /* synthetic */ TextureAtlasSprite iconCompass;
    public static /* synthetic */ TextureAtlasSprite iconGlassPaneTop;
    public static /* synthetic */ TextureAtlasSprite iconGrassTop;
    public static /* synthetic */ TextureAtlasSprite iconGrassSide;
    public static /* synthetic */ TextureAtlasSprite iconGrassSideOverlay;
    public static /* synthetic */ TextureAtlasSprite iconGrassSideSnowed;
    public static /* synthetic */ TextureAtlasSprite iconLavaStill;
    public static /* synthetic */ TextureAtlasSprite iconFireLayer0;
    public static /* synthetic */ TextureAtlasSprite iconFireLayer1;
    public static /* synthetic */ TextureAtlasSprite iconWaterStill;
    public static /* synthetic */ TextureAtlasSprite iconWaterFlow;
    public static /* synthetic */ TextureAtlasSprite iconPortal;
    public static /* synthetic */ TextureAtlasSprite iconClock;
    private static /* synthetic */ IntBuffer staticBuffer;
    
    public static int scaleToPowerOfTwo(final int lllllllllllllIlIllIIIIIIllIIllII, final int lllllllllllllIlIllIIIIIIllIIlIll) {
        int lllllllllllllIlIllIIIIIIllIIlIlI = Math.max(lllllllllllllIlIllIIIIIIllIIllII, lllllllllllllIlIllIIIIIIllIIlIll);
        lllllllllllllIlIllIIIIIIllIIlIlI = MathHelper.smallestEncompassingPowerOfTwo(lllllllllllllIlIllIIIIIIllIIlIlI);
        return lllllllllllllIlIllIIIIIIllIIlIlI;
    }
    
    public static int getGLMaximumTextureSize() {
        for (int lllllllllllllIlIllIIIIIIIIlIIllI = 65536; lllllllllllllIlIllIIIIIIIIlIIllI > 0; lllllllllllllIlIllIIIIIIIIlIIllI >>= 1) {
            GlStateManager.glTexImage2D(32868, 0, 6408, lllllllllllllIlIllIIIIIIIIlIIllI, lllllllllllllIlIllIIIIIIIIlIIllI, 0, 6408, 5121, null);
            final int lllllllllllllIlIllIIIIIIIIlIIlIl = GL11.glGetError();
            final int lllllllllllllIlIllIIIIIIIIlIIlII = GlStateManager.glGetTexLevelParameteri(32868, 0, 4096);
            if (lllllllllllllIlIllIIIIIIIIlIIlII != 0) {
                return lllllllllllllIlIllIIIIIIIIlIIllI;
            }
        }
        return -1;
    }
    
    public static int twoToPower(final int lllllllllllllIlIllIIIIIlIIlllIll) {
        int lllllllllllllIlIllIIIIIlIIllllIl = 1;
        for (int lllllllllllllIlIllIIIIIlIIllllII = 0; lllllllllllllIlIllIIIIIlIIllllII < lllllllllllllIlIllIIIIIlIIlllIll; ++lllllllllllllIlIllIIIIIlIIllllII) {
            lllllllllllllIlIllIIIIIlIIllllIl *= 2;
        }
        return lllllllllllllIlIllIIIIIlIIllllIl;
    }
    
    public static boolean isPowerOfTwo(final int lllllllllllllIlIllIIIIIIlllllIII) {
        final int lllllllllllllIlIllIIIIIIlllllIIl = MathHelper.smallestEncompassingPowerOfTwo(lllllllllllllIlIllIIIIIIlllllIII);
        return lllllllllllllIlIllIIIIIIlllllIIl == lllllllllllllIlIllIIIIIIlllllIII;
    }
    
    public static ResourceLocation fixResourceLocation(ResourceLocation lllllllllllllIlIllIIIIIlIIIllIll, final String lllllllllllllIlIllIIIIIlIIIllllI) {
        if (!((ResourceLocation)lllllllllllllIlIllIIIIIlIIIllIll).getResourceDomain().equals("minecraft")) {
            return (ResourceLocation)lllllllllllllIlIllIIIIIlIIIllIll;
        }
        final String lllllllllllllIlIllIIIIIlIIIlllIl = ((ResourceLocation)lllllllllllllIlIllIIIIIlIIIllIll).getResourcePath();
        final String lllllllllllllIlIllIIIIIlIIIlllII = fixResourcePath(lllllllllllllIlIllIIIIIlIIIlllIl, lllllllllllllIlIllIIIIIlIIIllllI);
        if (lllllllllllllIlIllIIIIIlIIIlllII != lllllllllllllIlIllIIIIIlIIIlllIl) {
            lllllllllllllIlIllIIIIIlIIIllIll = new ResourceLocation(((ResourceLocation)lllllllllllllIlIllIIIIIlIIIllIll).getResourceDomain(), lllllllllllllIlIllIIIIIlIIIlllII);
        }
        return (ResourceLocation)lllllllllllllIlIllIIIIIlIIIllIll;
    }
    
    public static void saveGlTexture(final String lllllllllllllIlIllIIIIIIlIIIIlIl, final int lllllllllllllIlIllIIIIIIIlllIIlI, final int lllllllllllllIlIllIIIIIIIlllIIIl, final int lllllllllllllIlIllIIIIIIlIIIIIlI, final int lllllllllllllIlIllIIIIIIIllIllll) {
        bindTexture(lllllllllllllIlIllIIIIIIIlllIIlI);
        GL11.glPixelStorei(3333, 1);
        GL11.glPixelStorei(3317, 1);
        final File lllllllllllllIlIllIIIIIIlIIIIIII = new File(lllllllllllllIlIllIIIIIIlIIIIlIl);
        final File lllllllllllllIlIllIIIIIIIlllllll = lllllllllllllIlIllIIIIIIlIIIIIII.getParentFile();
        if (lllllllllllllIlIllIIIIIIIlllllll != null) {
            lllllllllllllIlIllIIIIIIIlllllll.mkdirs();
        }
        for (int lllllllllllllIlIllIIIIIIIllllllI = 0; lllllllllllllIlIllIIIIIIIllllllI < 16; ++lllllllllllllIlIllIIIIIIIllllllI) {
            final File lllllllllllllIlIllIIIIIIIlllllIl = new File(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIIlIIIIlIl)).append("_").append(lllllllllllllIlIllIIIIIIIllllllI).append(".png")));
            lllllllllllllIlIllIIIIIIIlllllIl.delete();
        }
        for (int lllllllllllllIlIllIIIIIIIlllllII = 0; lllllllllllllIlIllIIIIIIIlllllII <= lllllllllllllIlIllIIIIIIIlllIIIl; ++lllllllllllllIlIllIIIIIIIlllllII) {
            final File lllllllllllllIlIllIIIIIIIllllIll = new File(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIIlIIIIlIl)).append("_").append(lllllllllllllIlIllIIIIIIIlllllII).append(".png")));
            final int lllllllllllllIlIllIIIIIIIllllIlI = lllllllllllllIlIllIIIIIIlIIIIIlI >> lllllllllllllIlIllIIIIIIIlllllII;
            final int lllllllllllllIlIllIIIIIIIllllIIl = lllllllllllllIlIllIIIIIIIllIllll >> lllllllllllllIlIllIIIIIIIlllllII;
            final int lllllllllllllIlIllIIIIIIIllllIII = lllllllllllllIlIllIIIIIIIllllIlI * lllllllllllllIlIllIIIIIIIllllIIl;
            final IntBuffer lllllllllllllIlIllIIIIIIIlllIlll = BufferUtils.createIntBuffer(lllllllllllllIlIllIIIIIIIllllIII);
            final int[] lllllllllllllIlIllIIIIIIIlllIllI = new int[lllllllllllllIlIllIIIIIIIllllIII];
            GL11.glGetTexImage(3553, lllllllllllllIlIllIIIIIIIlllllII, 32993, 33639, lllllllllllllIlIllIIIIIIIlllIlll);
            lllllllllllllIlIllIIIIIIIlllIlll.get(lllllllllllllIlIllIIIIIIIlllIllI);
            final BufferedImage lllllllllllllIlIllIIIIIIIlllIlIl = new BufferedImage(lllllllllllllIlIllIIIIIIIllllIlI, lllllllllllllIlIllIIIIIIIllllIIl, 2);
            lllllllllllllIlIllIIIIIIIlllIlIl.setRGB(0, 0, lllllllllllllIlIllIIIIIIIllllIlI, lllllllllllllIlIllIIIIIIIllllIIl, lllllllllllllIlIllIIIIIIIlllIllI, 0, lllllllllllllIlIllIIIIIIIllllIlI);
            try {
                ImageIO.write(lllllllllllllIlIllIIIIIIIlllIlIl, "png", lllllllllllllIlIllIIIIIIIllllIll);
                Config.dbg(String.valueOf(new StringBuilder("Exported: ").append(lllllllllllllIlIllIIIIIIIllllIll)));
            }
            catch (Exception lllllllllllllIlIllIIIIIIIlllIlII) {
                Config.warn(String.valueOf(new StringBuilder("Error writing: ").append(lllllllllllllIlIllIIIIIIIllllIll)));
                Config.warn(String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIIIIIIlllIlII.getClass().getName()).append(": ").append(lllllllllllllIlIllIIIIIIIlllIlII.getMessage())));
            }
        }
    }
    
    public static void resourcesReloaded(final IResourceManager lllllllllllllIlIllIIIIIlIIlIllll) {
        if (getTextureMapBlocks() != null) {
            Config.dbg("*** Reloading custom textures ***");
            CustomSky.reset();
            TextureAnimations.reset();
            update();
            NaturalTextures.update();
            BetterGrass.update();
            BetterSnow.update();
            TextureAnimations.update();
            CustomColors.update();
            CustomSky.update();
            RandomMobs.resetTextures();
            CustomItems.updateModels();
            CustomEntityModels.update();
            Shaders.resourcesReloaded();
            Lang.resourcesReloaded();
            Config.updateTexturePackClouds();
            SmartLeaves.updateLeavesModels();
            CustomPanorama.update();
            CustomGuis.update();
            Config.getTextureManager().tick();
        }
    }
    
    public static String getBasePath(final String lllllllllllllIlIllIIIIIlIIIIIlll) {
        final int lllllllllllllIlIllIIIIIlIIIIlIII = lllllllllllllIlIllIIIIIlIIIIIlll.lastIndexOf(47);
        return (lllllllllllllIlIllIIIIIlIIIIlIII < 0) ? "" : lllllllllllllIlIllIIIIIlIIIIIlll.substring(0, lllllllllllllIlIllIIIIIlIIIIlIII);
    }
    
    public static void applyAnisotropicLevel() {
        if (GLContext.getCapabilities().GL_EXT_texture_filter_anisotropic) {
            final float lllllllllllllIlIllIIIIIlIIIIIIll = GL11.glGetFloat(34047);
            float lllllllllllllIlIllIIIIIlIIIIIIlI = (float)Config.getAnisotropicFilterLevel();
            lllllllllllllIlIllIIIIIlIIIIIIlI = Math.min(lllllllllllllIlIllIIIIIlIIIIIIlI, lllllllllllllIlIllIIIIIlIIIIIIll);
            GL11.glTexParameterf(3553, 34046, lllllllllllllIlIllIIIIIlIIIIIIlI);
        }
    }
    
    public static void bindTexture(final int lllllllllllllIlIllIIIIIIlllllllI) {
        GlStateManager.bindTexture(lllllllllllllIlIllIIIIIIlllllllI);
    }
    
    public static TextureMap getTextureMapBlocks() {
        return Minecraft.getMinecraft().getTextureMapBlocks();
    }
    
    public static void dbgMipmaps(final TextureAtlasSprite lllllllllllllIlIllIIIIIIlIIllIIl) {
        final int[][] lllllllllllllIlIllIIIIIIlIIlllII = lllllllllllllIlIllIIIIIIlIIllIIl.getFrameTextureData(0);
        for (int lllllllllllllIlIllIIIIIIlIIllIll = 0; lllllllllllllIlIllIIIIIIlIIllIll < lllllllllllllIlIllIIIIIIlIIlllII.length; ++lllllllllllllIlIllIIIIIIlIIllIll) {
            final int[] lllllllllllllIlIllIIIIIIlIIllIlI = lllllllllllllIlIllIIIIIIlIIlllII[lllllllllllllIlIllIIIIIIlIIllIll];
            if (lllllllllllllIlIllIIIIIIlIIllIlI == null) {
                Config.dbg(String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIIIIIlIIllIll).append(": ").append(lllllllllllllIlIllIIIIIIlIIllIlI)));
            }
            else {
                Config.dbg(String.valueOf(new StringBuilder().append(lllllllllllllIlIllIIIIIIlIIllIll).append(": ").append(lllllllllllllIlIllIIIIIIlIIllIlI.length)));
            }
        }
    }
    
    public static void generateCustomMipmaps(final TextureAtlasSprite lllllllllllllIlIllIIIIIIIlIIIlll, final int lllllllllllllIlIllIIIIIIIlIIIllI) {
        final int lllllllllllllIlIllIIIIIIIlIlIlIl = lllllllllllllIlIllIIIIIIIlIIIlll.getIconWidth();
        final int lllllllllllllIlIllIIIIIIIlIlIlII = lllllllllllllIlIllIIIIIIIlIIIlll.getIconHeight();
        if (lllllllllllllIlIllIIIIIIIlIIIlll.getFrameCount() < 1) {
            final List<int[][]> lllllllllllllIlIllIIIIIIIlIlIIll = new ArrayList<int[][]>();
            final int[][] lllllllllllllIlIllIIIIIIIlIlIIlI = new int[lllllllllllllIlIllIIIIIIIlIIIllI + 1][];
            final int[] lllllllllllllIlIllIIIIIIIlIlIIIl = new int[lllllllllllllIlIllIIIIIIIlIlIlIl * lllllllllllllIlIllIIIIIIIlIlIlII];
            lllllllllllllIlIllIIIIIIIlIlIIlI[0] = lllllllllllllIlIllIIIIIIIlIlIIIl;
            lllllllllllllIlIllIIIIIIIlIlIIll.add(lllllllllllllIlIllIIIIIIIlIlIIlI);
            lllllllllllllIlIllIIIIIIIlIIIlll.setFramesTextureData(lllllllllllllIlIllIIIIIIIlIlIIll);
        }
        final List<int[][]> lllllllllllllIlIllIIIIIIIlIlIIII = new ArrayList<int[][]>();
        for (int lllllllllllllIlIllIIIIIIIlIIllll = lllllllllllllIlIllIIIIIIIlIIIlll.getFrameCount(), lllllllllllllIlIllIIIIIIIlIIlllI = 0; lllllllllllllIlIllIIIIIIIlIIlllI < lllllllllllllIlIllIIIIIIIlIIllll; ++lllllllllllllIlIllIIIIIIIlIIlllI) {
            int[] lllllllllllllIlIllIIIIIIIlIIllIl = getFrameData(lllllllllllllIlIllIIIIIIIlIIIlll, lllllllllllllIlIllIIIIIIIlIIlllI, 0);
            if (lllllllllllllIlIllIIIIIIIlIIllIl == null || lllllllllllllIlIllIIIIIIIlIIllIl.length < 1) {
                lllllllllllllIlIllIIIIIIIlIIllIl = new int[lllllllllllllIlIllIIIIIIIlIlIlIl * lllllllllllllIlIllIIIIIIIlIlIlII];
            }
            if (lllllllllllllIlIllIIIIIIIlIIllIl.length != lllllllllllllIlIllIIIIIIIlIlIlIl * lllllllllllllIlIllIIIIIIIlIlIlII) {
                int lllllllllllllIlIllIIIIIIIlIIllII = (int)Math.round(Math.sqrt(lllllllllllllIlIllIIIIIIIlIIllIl.length));
                if (lllllllllllllIlIllIIIIIIIlIIllII * lllllllllllllIlIllIIIIIIIlIIllII != lllllllllllllIlIllIIIIIIIlIIllIl.length) {
                    lllllllllllllIlIllIIIIIIIlIIllIl = new int[] { 0 };
                    lllllllllllllIlIllIIIIIIIlIIllII = 1;
                }
                final BufferedImage lllllllllllllIlIllIIIIIIIlIIlIll = new BufferedImage(lllllllllllllIlIllIIIIIIIlIIllII, lllllllllllllIlIllIIIIIIIlIIllII, 2);
                lllllllllllllIlIllIIIIIIIlIIlIll.setRGB(0, 0, lllllllllllllIlIllIIIIIIIlIIllII, lllllllllllllIlIllIIIIIIIlIIllII, lllllllllllllIlIllIIIIIIIlIIllIl, 0, lllllllllllllIlIllIIIIIIIlIIllII);
                final BufferedImage lllllllllllllIlIllIIIIIIIlIIlIlI = scaleImage(lllllllllllllIlIllIIIIIIIlIIlIll, lllllllllllllIlIllIIIIIIIlIlIlIl);
                final int[] lllllllllllllIlIllIIIIIIIlIIlIIl = new int[lllllllllllllIlIllIIIIIIIlIlIlIl * lllllllllllllIlIllIIIIIIIlIlIlII];
                lllllllllllllIlIllIIIIIIIlIIlIlI.getRGB(0, 0, lllllllllllllIlIllIIIIIIIlIlIlIl, lllllllllllllIlIllIIIIIIIlIlIlII, lllllllllllllIlIllIIIIIIIlIIlIIl, 0, lllllllllllllIlIllIIIIIIIlIlIlIl);
                lllllllllllllIlIllIIIIIIIlIIllIl = lllllllllllllIlIllIIIIIIIlIIlIIl;
            }
            final int[][] lllllllllllllIlIllIIIIIIIlIIlIII = new int[lllllllllllllIlIllIIIIIIIlIIIllI + 1][];
            lllllllllllllIlIllIIIIIIIlIIlIII[0] = lllllllllllllIlIllIIIIIIIlIIllIl;
            lllllllllllllIlIllIIIIIIIlIlIIII.add(lllllllllllllIlIllIIIIIIIlIIlIII);
        }
        lllllllllllllIlIllIIIIIIIlIIIlll.setFramesTextureData(lllllllllllllIlIllIIIIIIIlIlIIII);
        lllllllllllllIlIllIIIIIIIlIIIlll.generateMipmaps(lllllllllllllIlIllIIIIIIIlIIIllI);
    }
    
    public static void registerResourceListener() {
        final IResourceManager lllllllllllllIlIllIIIIIlIIlIlIll = Config.getResourceManager();
        if (lllllllllllllIlIllIIIIIlIIlIlIll instanceof IReloadableResourceManager) {
            final IReloadableResourceManager lllllllllllllIlIllIIIIIlIIlIlIlI = (IReloadableResourceManager)lllllllllllllIlIllIIIIIlIIlIlIll;
            final IResourceManagerReloadListener lllllllllllllIlIllIIIIIlIIlIlIIl = new IResourceManagerReloadListener() {
                @Override
                public void onResourceManagerReload(final IResourceManager llllllIIIlII) {
                    TextureUtils.resourcesReloaded(llllllIIIlII);
                }
            };
            lllllllllllllIlIllIIIIIlIIlIlIlI.registerReloadListener(lllllllllllllIlIllIIIIIlIIlIlIIl);
        }
        final ITickableTextureObject lllllllllllllIlIllIIIIIlIIlIlIII = new ITickableTextureObject() {
            @Override
            public void tick() {
                TextureAnimations.updateCustomAnimations();
            }
            
            @Override
            public void setBlurMipmap(final boolean llllllllllllllllllIlIlIlIIlIIIlI, final boolean llllllllllllllllllIlIlIlIIlIIIIl) {
            }
            
            @Override
            public MultiTexID getMultiTexID() {
                return null;
            }
            
            @Override
            public void restoreLastBlurMipmap() {
            }
            
            @Override
            public int getGlTextureId() {
                return 0;
            }
            
            @Override
            public void loadTexture(final IResourceManager llllllllllllllllllIlIlIlIIlIIlIl) throws IOException {
            }
        };
        final ResourceLocation lllllllllllllIlIllIIIIIlIIlIIlll = new ResourceLocation("optifine/TickableTextures");
        Config.getTextureManager().loadTickableTexture(lllllllllllllIlIllIIIIIlIIlIIlll, lllllllllllllIlIllIIIIIlIIlIlIII);
    }
    
    public static int[] getFrameData(final TextureAtlasSprite lllllllllllllIlIllIIIIIIIIlIllll, final int lllllllllllllIlIllIIIIIIIIllIlII, final int lllllllllllllIlIllIIIIIIIIlIllIl) {
        final List<int[][]> lllllllllllllIlIllIIIIIIIIllIIlI = lllllllllllllIlIllIIIIIIIIlIllll.getFramesTextureData();
        if (lllllllllllllIlIllIIIIIIIIllIIlI.size() <= lllllllllllllIlIllIIIIIIIIllIlII) {
            return null;
        }
        final int[][] lllllllllllllIlIllIIIIIIIIllIIIl = lllllllllllllIlIllIIIIIIIIllIIlI.get(lllllllllllllIlIllIIIIIIIIllIlII);
        if (lllllllllllllIlIllIIIIIIIIllIIIl != null && lllllllllllllIlIllIIIIIIIIllIIIl.length > lllllllllllllIlIllIIIIIIIIlIllIl) {
            final int[] lllllllllllllIlIllIIIIIIIIllIIII = lllllllllllllIlIllIIIIIIIIllIIIl[lllllllllllllIlIllIIIIIIIIlIllIl];
            return lllllllllllllIlIllIIIIIIIIllIIII;
        }
        return null;
    }
    
    public static int getPowerOfTwo(final int lllllllllllllIlIllIIIIIlIlIIIlII) {
        int lllllllllllllIlIllIIIIIlIlIIIllI;
        int lllllllllllllIlIllIIIIIlIlIIIlIl;
        for (lllllllllllllIlIllIIIIIlIlIIIllI = 1, lllllllllllllIlIllIIIIIlIlIIIlIl = 0; lllllllllllllIlIllIIIIIlIlIIIllI < lllllllllllllIlIllIIIIIlIlIIIlII; lllllllllllllIlIllIIIIIlIlIIIllI *= 2, ++lllllllllllllIlIllIIIIIlIlIIIlIl) {}
        return lllllllllllllIlIllIIIIIlIlIIIlIl;
    }
    
    public static ITextureObject getTexture(final ResourceLocation lllllllllllllIlIllIIIIIlIIllIIlI) {
        final ITextureObject lllllllllllllIlIllIIIIIlIIllIlII = Config.getTextureManager().getTexture(lllllllllllllIlIllIIIIIlIIllIIlI);
        if (lllllllllllllIlIllIIIIIlIIllIlII != null) {
            return lllllllllllllIlIllIIIIIlIIllIlII;
        }
        if (!Config.hasResource(lllllllllllllIlIllIIIIIlIIllIIlI)) {
            return null;
        }
        final ITextureObject lllllllllllllIlIllIIIIIlIIllIIll = new SimpleTexture(lllllllllllllIlIllIIIIIlIIllIIlI);
        Config.getTextureManager().loadTexture(lllllllllllllIlIllIIIIIlIIllIIlI, lllllllllllllIlIllIIIIIlIIllIIll);
        return lllllllllllllIlIllIIIIIlIIllIIll;
    }
    
    public static void update() {
        final TextureMap lllllllllllllIlIllIIIIIlIlllIllI = getTextureMapBlocks();
        if (lllllllllllllIlIllIIIIIlIlllIllI != null) {
            final String lllllllllllllIlIllIIIIIlIlllIlII = "minecraft:blocks/";
            TextureUtils.iconGrassTop = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("grass_top")));
            TextureUtils.iconGrassSide = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("grass_side")));
            TextureUtils.iconGrassSideOverlay = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("grass_side_overlay")));
            TextureUtils.iconSnow = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("snow")));
            TextureUtils.iconGrassSideSnowed = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("grass_side_snowed")));
            TextureUtils.iconMyceliumSide = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("mycelium_side")));
            TextureUtils.iconMyceliumTop = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("mycelium_top")));
            TextureUtils.iconWaterStill = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("water_still")));
            TextureUtils.iconWaterFlow = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("water_flow")));
            TextureUtils.iconLavaStill = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("lava_still")));
            TextureUtils.iconLavaFlow = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("lava_flow")));
            TextureUtils.iconFireLayer0 = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("fire_layer_0")));
            TextureUtils.iconFireLayer1 = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("fire_layer_1")));
            TextureUtils.iconPortal = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("portal")));
            TextureUtils.iconGlass = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("glass")));
            TextureUtils.iconGlassPaneTop = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIlII)).append("glass_pane_top")));
            final String lllllllllllllIlIllIIIIIlIlllIIll = "minecraft:items/";
            TextureUtils.iconCompass = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIIll)).append("compass")));
            TextureUtils.iconClock = lllllllllllllIlIllIIIIIlIlllIllI.getSpriteSafe(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIlllIIll)).append("clock")));
        }
    }
    
    public static int ceilPowerOfTwo(final int lllllllllllllIlIllIIIIIlIlIIllII) {
        int lllllllllllllIlIllIIIIIlIlIIllIl;
        for (lllllllllllllIlIllIIIIIlIlIIllIl = 1; lllllllllllllIlIllIIIIIlIlIIllIl < lllllllllllllIlIllIIIIIlIlIIllII; lllllllllllllIlIllIIIIIlIlIIllIl *= 2) {}
        return lllllllllllllIlIllIIIIIlIlIIllIl;
    }
    
    public static BufferedImage scaleImage(final BufferedImage lllllllllllllIlIllIIIIIIlllIlllI, final int lllllllllllllIlIllIIIIIIlllIllIl) {
        final int lllllllllllllIlIllIIIIIIlllIllII = lllllllllllllIlIllIIIIIIlllIlllI.getWidth();
        final int lllllllllllllIlIllIIIIIIlllIlIll = lllllllllllllIlIllIIIIIIlllIlllI.getHeight();
        final int lllllllllllllIlIllIIIIIIlllIlIlI = lllllllllllllIlIllIIIIIIlllIlIll * lllllllllllllIlIllIIIIIIlllIllIl / lllllllllllllIlIllIIIIIIlllIllII;
        final BufferedImage lllllllllllllIlIllIIIIIIlllIlIIl = new BufferedImage(lllllllllllllIlIllIIIIIIlllIllIl, lllllllllllllIlIllIIIIIIlllIlIlI, 2);
        final Graphics2D lllllllllllllIlIllIIIIIIlllIlIII = lllllllllllllIlIllIIIIIIlllIlIIl.createGraphics();
        Object lllllllllllllIlIllIIIIIIlllIIlll = RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR;
        if (lllllllllllllIlIllIIIIIIlllIllIl < lllllllllllllIlIllIIIIIIlllIllII || lllllllllllllIlIllIIIIIIlllIllIl % lllllllllllllIlIllIIIIIIlllIllII != 0) {
            lllllllllllllIlIllIIIIIIlllIIlll = RenderingHints.VALUE_INTERPOLATION_BILINEAR;
        }
        lllllllllllllIlIllIIIIIIlllIlIII.setRenderingHint(RenderingHints.KEY_INTERPOLATION, lllllllllllllIlIllIIIIIIlllIIlll);
        lllllllllllllIlIllIIIIIIlllIlIII.drawImage(lllllllllllllIlIllIIIIIIlllIlllI, 0, 0, lllllllllllllIlIllIIIIIIlllIllIl, lllllllllllllIlIllIIIIIIlllIlIlI, null);
        return lllllllllllllIlIllIIIIIIlllIlIIl;
    }
    
    public static BufferedImage fixTextureDimensions(final String lllllllllllllIlIllIIIIIlIlIlllII, final BufferedImage lllllllllllllIlIllIIIIIlIlIlIlIl) {
        if (lllllllllllllIlIllIIIIIlIlIlllII.startsWith("/mob/zombie") || lllllllllllllIlIllIIIIIlIlIlllII.startsWith("/mob/pigzombie")) {
            final int lllllllllllllIlIllIIIIIlIlIllIlI = lllllllllllllIlIllIIIIIlIlIlIlIl.getWidth();
            final int lllllllllllllIlIllIIIIIlIlIllIIl = lllllllllllllIlIllIIIIIlIlIlIlIl.getHeight();
            if (lllllllllllllIlIllIIIIIlIlIllIlI == lllllllllllllIlIllIIIIIlIlIllIIl * 2) {
                final BufferedImage lllllllllllllIlIllIIIIIlIlIllIII = new BufferedImage(lllllllllllllIlIllIIIIIlIlIllIlI, lllllllllllllIlIllIIIIIlIlIllIIl * 2, 2);
                final Graphics2D lllllllllllllIlIllIIIIIlIlIlIlll = lllllllllllllIlIllIIIIIlIlIllIII.createGraphics();
                lllllllllllllIlIllIIIIIlIlIlIlll.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                lllllllllllllIlIllIIIIIlIlIlIlll.drawImage(lllllllllllllIlIllIIIIIlIlIlIlIl, 0, 0, lllllllllllllIlIllIIIIIlIlIllIlI, lllllllllllllIlIllIIIIIlIlIllIIl, null);
                return lllllllllllllIlIllIIIIIlIlIllIII;
            }
        }
        return lllllllllllllIlIllIIIIIlIlIlIlIl;
    }
    
    public static String fixResourcePath(String lllllllllllllIlIllIIIIIlIIIIllll, String lllllllllllllIlIllIIIIIlIIIIlllI) {
        final String lllllllllllllIlIllIIIIIlIIIlIIIl = "assets/minecraft/";
        if (((String)lllllllllllllIlIllIIIIIlIIIIllll).startsWith(lllllllllllllIlIllIIIIIlIIIlIIIl)) {
            lllllllllllllIlIllIIIIIlIIIIllll = ((String)lllllllllllllIlIllIIIIIlIIIIllll).substring(lllllllllllllIlIllIIIIIlIIIlIIIl.length());
            return (String)lllllllllllllIlIllIIIIIlIIIIllll;
        }
        if (((String)lllllllllllllIlIllIIIIIlIIIIllll).startsWith("./")) {
            lllllllllllllIlIllIIIIIlIIIIllll = ((String)lllllllllllllIlIllIIIIIlIIIIllll).substring(2);
            if (!((String)lllllllllllllIlIllIIIIIlIIIIlllI).endsWith("/")) {
                lllllllllllllIlIllIIIIIlIIIIlllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIIIIlllI)).append("/"));
            }
            lllllllllllllIlIllIIIIIlIIIIllll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIIIIlllI)).append((String)lllllllllllllIlIllIIIIIlIIIIllll));
            return (String)lllllllllllllIlIllIIIIIlIIIIllll;
        }
        if (((String)lllllllllllllIlIllIIIIIlIIIIllll).startsWith("/~")) {
            lllllllllllllIlIllIIIIIlIIIIllll = ((String)lllllllllllllIlIllIIIIIlIIIIllll).substring(1);
        }
        final String lllllllllllllIlIllIIIIIlIIIlIIII = "mcpatcher/";
        if (((String)lllllllllllllIlIllIIIIIlIIIIllll).startsWith("~/")) {
            lllllllllllllIlIllIIIIIlIIIIllll = ((String)lllllllllllllIlIllIIIIIlIIIIllll).substring(2);
            lllllllllllllIlIllIIIIIlIIIIllll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIIIlIIII)).append((String)lllllllllllllIlIllIIIIIlIIIIllll));
            return (String)lllllllllllllIlIllIIIIIlIIIIllll;
        }
        if (((String)lllllllllllllIlIllIIIIIlIIIIllll).startsWith("/")) {
            lllllllllllllIlIllIIIIIlIIIIllll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIIIIIlIIIlIIII)).append(((String)lllllllllllllIlIllIIIIIlIIIIllll).substring(1)));
            return (String)lllllllllllllIlIllIIIIIlIIIIllll;
        }
        return (String)lllllllllllllIlIllIIIIIlIIIIllll;
    }
    
    static {
        texLogBirch = "log_birch";
        texLogAcacia = "log_acacia";
        texSandstoneBottom = "sandstone_bottom";
        texLogBirchTop = "log_birch_top";
        texBedrock = "bedrock";
        texLeavesBirch = "leaves_birch";
        texCompass = "compass";
        texLeavesJungle = "leaves_jungle";
        texLogJungleTop = "log_jungle_top";
        texRedstoneLampOff = "redstone_lamp_off";
        texLogOak = "log_oak";
        texClock = "clock";
        texDirt = "dirt";
        texFireLayer0 = "fire_layer_0";
        texGravel = "gravel";
        texGlassPaneTop = "glass_pane_top";
        texSand = "sand";
        texLeavesAcacia = "leaves_acacia";
        texGrassTop = "grass_top";
        texSnow = "snow";
        texLogBigOakTop = "log_big_oak_top";
        texGrassSideSnowed = "grass_side_snowed";
        texPortal = "portal";
        texWaterStill = "water_still";
        SPRITE_PREFIX_ITEMS = "minecraft:items/";
        texWaterFlow = "water_flow";
        texCactusSide = "cactus_side";
        texFarmlandDry = "farmland_dry";
        texStone = "stone";
        texFireLayer1 = "fire_layer_1";
        texLeavesBigOak = "leaves_big_oak";
        texLapisOre = "lapis_ore";
        texIronOre = "iron_ore";
        SPRITE_PREFIX_BLOCKS = "minecraft:blocks/";
        texLogAcaciaTop = "log_acacia_top";
        texClay = "clay";
        texGlass = "glass";
        texLeavesSpuce = "leaves_spruce";
        texDiamondOre = "diamond_ore";
        texGoldOre = "gold_ore";
        texMyceliumSide = "mycelium_side";
        texRedstoneOre = "redstone_ore";
        texLeavesSpruce = "leaves_spruce";
        texLavaStill = "lava_still";
        texLeavesOak = "leaves_oak";
        texLavaFlow = "lava_flow";
        texCoarseDirt = "coarse_dirt";
        texCoalOre = "coal_ore";
        texLogBigOak = "log_big_oak";
        texMyceliumTop = "mycelium_top";
        texLogJungle = "log_jungle";
        texNetherrack = "netherrack";
        texGlowstone = "glowstone";
        texObsidian = "obsidian";
        texGrassSide = "grass_side";
        texSoulSand = "soul_sand";
        texStoneslabTop = "stone_slab_top";
        texLogSpruce = "log_spruce";
        texStoneslabSide = "stone_slab_side";
        texFarmlandWet = "farmland_wet";
        texLogOakTop = "log_oak_top";
        texLeavesSpruceOpaque = "leaves_spruce_opaque";
        texEndStone = "end_stone";
        texGrassSideOverlay = "grass_side_overlay";
        texLogSpruceTop = "log_spruce_top";
        texRedstoneLampOn = "redstone_lamp_on";
        texSandstoneTop = "sandstone_top";
        TextureUtils.staticBuffer = GLAllocation.createDirectIntBuffer(256);
    }
    
    public static int scaleMinTo(final int lllllllllllllIlIllIIIIIIllIIIIll, final int lllllllllllllIlIllIIIIIIlIllllll) {
        if (lllllllllllllIlIllIIIIIIllIIIIll >= lllllllllllllIlIllIIIIIIlIllllll) {
            return lllllllllllllIlIllIIIIIIllIIIIll;
        }
        int lllllllllllllIlIllIIIIIIllIIIIIl;
        for (lllllllllllllIlIllIIIIIIllIIIIIl = lllllllllllllIlIllIIIIIIllIIIIll; lllllllllllllIlIllIIIIIIllIIIIIl < lllllllllllllIlIllIIIIIIlIllllll; lllllllllllllIlIllIIIIIIllIIIIIl *= 2) {}
        return lllllllllllllIlIllIIIIIIllIIIIIl;
    }
    
    public static Dimension getImageSize(final InputStream lllllllllllllIlIllIIIIIIlIlIlIlI, final String lllllllllllllIlIllIIIIIIlIlIlIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    javax/imageio/ImageIO.getImageReadersBySuffix:(Ljava/lang/String;)Ljava/util/Iterator;
        //     4: astore_2        /* lllllllllllllIlIllIIIIIIlIlIlIII */
        //     5: aload_2         /* lllllllllllllIlIllIIIIIIlIllIIlI */
        //     6: invokeinterface java/util/Iterator.hasNext:()Z
        //    11: ifeq            97
        //    14: aload_2         /* lllllllllllllIlIllIIIIIIlIllIIlI */
        //    15: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    20: checkcast       Ljavax/imageio/ImageReader;
        //    23: astore_3        /* lllllllllllllIlIllIIIIIIlIlIIlll */
        //    24: aload_0         /* lllllllllllllIlIllIIIIIIlIllIlII */
        //    25: invokestatic    javax/imageio/ImageIO.createImageInputStream:(Ljava/lang/Object;)Ljavax/imageio/stream/ImageInputStream;
        //    28: astore          lllllllllllllIlIllIIIIIIlIlIlllI
        //    30: aload_3         /* lllllllllllllIlIllIIIIIIlIllIIIl */
        //    31: aload           lllllllllllllIlIllIIIIIIlIlIlllI
        //    33: invokevirtual   javax/imageio/ImageReader.setInput:(Ljava/lang/Object;)V
        //    36: aload_3         /* lllllllllllllIlIllIIIIIIlIllIIIl */
        //    37: aload_3         /* lllllllllllllIlIllIIIIIIlIllIIIl */
        //    38: invokevirtual   javax/imageio/ImageReader.getMinIndex:()I
        //    41: invokevirtual   javax/imageio/ImageReader.getWidth:(I)I
        //    44: istore          lllllllllllllIlIllIIIIIIlIlIllIl
        //    46: aload_3         /* lllllllllllllIlIllIIIIIIlIllIIIl */
        //    47: aload_3         /* lllllllllllllIlIllIIIIIIlIllIIIl */
        //    48: invokevirtual   javax/imageio/ImageReader.getMinIndex:()I
        //    51: invokevirtual   javax/imageio/ImageReader.getHeight:(I)I
        //    54: istore          lllllllllllllIlIllIIIIIIlIlIllII
        //    56: new             Ljava/awt/Dimension;
        //    59: dup            
        //    60: iload           lllllllllllllIlIllIIIIIIlIlIllIl
        //    62: iload           lllllllllllllIlIllIIIIIIlIlIllII
        //    64: invokespecial   java/awt/Dimension.<init>:(II)V
        //    67: astore          lllllllllllllIlIllIIIIIIlIllIIII
        //    69: goto            90
        //    72: astore          lllllllllllllIlIllIIIIIIlIlIlIll
        //    74: aload_3         /* lllllllllllllIlIllIIIIIIlIllIIIl */
        //    75: invokevirtual   javax/imageio/ImageReader.dispose:()V
        //    78: goto            5
        //    81: astore          lllllllllllllIlIllIIIIIIlIlIIIlI
        //    83: aload_3         /* lllllllllllllIlIllIIIIIIlIllIIIl */
        //    84: invokevirtual   javax/imageio/ImageReader.dispose:()V
        //    87: aload           lllllllllllllIlIllIIIIIIlIlIIIlI
        //    89: athrow         
        //    90: aload_3         /* lllllllllllllIlIllIIIIIIlIllIIIl */
        //    91: invokevirtual   javax/imageio/ImageReader.dispose:()V
        //    94: aload           lllllllllllllIlIllIIIIIIlIlIllll
        //    96: areturn        
        //    97: aconst_null    
        //    98: areturn        
        //    StackMapTable: 00 05 FC 00 05 07 04 61 FF 00 42 00 04 07 04 9B 07 00 AF 07 04 61 07 04 6A 00 01 07 04 5B 48 07 04 9D FF 00 08 00 08 07 04 9B 07 00 AF 07 04 61 07 04 6A 07 04 7B 07 04 9F 01 01 00 00 FF 00 06 00 03 07 04 9B 07 00 AF 07 04 61 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  24     69     72     81     Ljava/io/IOException;
        //  24     74     81     90     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static BufferedImage scaleToPowerOfTwo(final BufferedImage lllllllllllllIlIllIIIIIIllIlIlII, final int lllllllllllllIlIllIIIIIIllIlIIll) {
        if (lllllllllllllIlIllIIIIIIllIlIlII == null) {
            return lllllllllllllIlIllIIIIIIllIlIlII;
        }
        final int lllllllllllllIlIllIIIIIIllIlIlll = lllllllllllllIlIllIIIIIIllIlIlII.getWidth();
        final int lllllllllllllIlIllIIIIIIllIlIllI = scaleToPowerOfTwo(lllllllllllllIlIllIIIIIIllIlIlll, lllllllllllllIlIllIIIIIIllIlIIll);
        if (lllllllllllllIlIllIIIIIIllIlIllI == lllllllllllllIlIllIIIIIIllIlIlll) {
            return lllllllllllllIlIllIIIIIIllIlIlII;
        }
        final BufferedImage lllllllllllllIlIllIIIIIIllIlIlIl = scaleImage(lllllllllllllIlIllIIIIIIllIlIlII, lllllllllllllIlIllIIIIIIllIlIllI);
        return lllllllllllllIlIllIIIIIIllIlIlIl;
    }
}
