package optifine;

import net.minecraft.client.settings.*;
import shadersmod.client.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import java.lang.reflect.*;
import java.nio.*;
import org.apache.commons.io.*;
import net.minecraft.server.integrated.*;
import net.minecraft.world.*;
import org.lwjgl.opengl.*;
import java.util.regex.*;
import java.awt.*;
import org.apache.logging.log4j.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import javax.imageio.*;
import java.awt.image.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.client.renderer.block.model.*;
import org.lwjgl.util.glu.*;
import org.lwjgl.*;

public class Config
{
    private static /* synthetic */ int texturePackClouds;
    private static /* synthetic */ int antialiasingLevel;
    public static /* synthetic */ GlVersion glVersion;
    public static /* synthetic */ String openGlRenderer;
    private static /* synthetic */ Minecraft minecraft;
    public static /* synthetic */ String[] openGlExtensions;
    public static /* synthetic */ String openGlVersion;
    private static /* synthetic */ DisplayMode[] displayModes;
    public static /* synthetic */ boolean fancyFogAvailable;
    private static /* synthetic */ int availableProcessors;
    private static /* synthetic */ boolean notify64BitJava;
    private static /* synthetic */ String newRelease;
    private static /* synthetic */ boolean fullscreenModeChecked;
    public static /* synthetic */ boolean waterOpacityChanged;
    private static /* synthetic */ DisplayMode desktopDisplayMode;
    public static /* synthetic */ int minecraftVersionInt;
    private static /* synthetic */ Thread minecraftThread;
    public static /* synthetic */ String openGlVendor;
    private static /* synthetic */ GameSettings gameSettings;
    public static final /* synthetic */ Float DEF_ALPHA_FUNC_LEVEL;
    public static /* synthetic */ boolean occlusionAvailable;
    public static /* synthetic */ boolean zoomMode;
    public static /* synthetic */ GlVersion glslVersion;
    private static /* synthetic */ DefaultResourcePack defaultResourcePackLazy;
    private static /* synthetic */ boolean initialized;
    private static /* synthetic */ boolean desktopModeChecked;
    private static final /* synthetic */ Logger LOGGER;
    
    public static String getVersionDebug() {
        final StringBuffer lllllllllllllllIlIIllIIIllllIllI = new StringBuffer(32);
        if (isDynamicLights()) {
            lllllllllllllllIlIIllIIIllllIllI.append("DL: ");
            lllllllllllllllIlIIllIIIllllIllI.append(String.valueOf(DynamicLights.getCount()));
            lllllllllllllllIlIIllIIIllllIllI.append(", ");
        }
        lllllllllllllllIlIIllIIIllllIllI.append("OptiFine_1.12.2_HD_U_C6");
        final String lllllllllllllllIlIIllIIIllllIlIl = Shaders.getShaderPackName();
        if (lllllllllllllllIlIIllIIIllllIlIl != null) {
            lllllllllllllllIlIIllIIIllllIllI.append(", ");
            lllllllllllllllIlIIllIIIllllIllI.append(lllllllllllllllIlIIllIIIllllIlIl);
        }
        return lllllllllllllllIlIIllIIIllllIllI.toString();
    }
    
    public static boolean isFogOff() {
        return Config.gameSettings.ofFogType == 3;
    }
    
    public static boolean isDynamicFov() {
        return Config.gameSettings.ofDynamicFov;
    }
    
    public static int[] addIntsToArray(final int[] lllllllllllllllIlIIlIlIlllIlIIII, final int[] lllllllllllllllIlIIlIlIlllIIlIIl) {
        if (lllllllllllllllIlIIlIlIlllIlIIII != null && lllllllllllllllIlIIlIlIlllIIlIIl != null) {
            final int lllllllllllllllIlIIlIlIlllIIlllI = lllllllllllllllIlIIlIlIlllIlIIII.length;
            final int lllllllllllllllIlIIlIlIlllIIllIl = lllllllllllllllIlIIlIlIlllIIlllI + lllllllllllllllIlIIlIlIlllIIlIIl.length;
            final int[] lllllllllllllllIlIIlIlIlllIIllII = new int[lllllllllllllllIlIIlIlIlllIIllIl];
            System.arraycopy(lllllllllllllllIlIIlIlIlllIlIIII, 0, lllllllllllllllIlIIlIlIlllIIllII, 0, lllllllllllllllIlIIlIlIlllIIlllI);
            for (int lllllllllllllllIlIIlIlIlllIIlIll = 0; lllllllllllllllIlIIlIlIlllIIlIll < lllllllllllllllIlIIlIlIlllIIlIIl.length; ++lllllllllllllllIlIIlIlIlllIIlIll) {
                lllllllllllllllIlIIlIlIlllIIllII[lllllllllllllllIlIIlIlIlllIIlIll + lllllllllllllllIlIIlIlIlllIIlllI] = lllllllllllllllIlIIlIlIlllIIlIIl[lllllllllllllllIlIIlIlIlllIIlIll];
            }
            return lllllllllllllllIlIIlIlIlllIIllII;
        }
        throw new NullPointerException("The given array is NULL");
    }
    
    public static boolean isNaturalTextures() {
        return Config.gameSettings.ofNaturalTextures;
    }
    
    public static boolean isVignetteEnabled() {
        if (isShaders() && !Shaders.isVignette()) {
            return false;
        }
        if (Config.gameSettings.ofVignette == 0) {
            return Config.gameSettings.fancyGraphics;
        }
        return Config.gameSettings.ofVignette == 2;
    }
    
    public static boolean isSmoothWorld() {
        return Config.gameSettings.ofSmoothWorld;
    }
    
    public static float getAlphaFuncLevel() {
        return Config.DEF_ALPHA_FUNC_LEVEL;
    }
    
    public static void writeFile(final File lllllllllllllllIlIIlIlIllIllIIII, final String lllllllllllllllIlIIlIlIllIlIllll) throws IOException {
        final FileOutputStream lllllllllllllllIlIIlIlIllIlIlllI = new FileOutputStream(lllllllllllllllIlIIlIlIllIllIIII);
        final byte[] lllllllllllllllIlIIlIlIllIlIllIl = lllllllllllllllIlIIlIlIllIlIllll.getBytes("ASCII");
        lllllllllllllllIlIIlIlIllIlIlllI.write(lllllllllllllllIlIIlIlIllIlIllIl);
        lllllllllllllllIlIIlIlIllIlIlllI.close();
    }
    
    public static boolean isNotify64BitJava() {
        return Config.notify64BitJava;
    }
    
    private static String[] detectOpenGlExtensions() {
        try {
            final GlVersion lllllllllllllllIlIIllIIIlIllIllI = getGlVersion();
            if (lllllllllllllllIlIIllIIIlIllIllI.getMajor() >= 3) {
                final int lllllllllllllllIlIIllIIIlIllIlIl = GL11.glGetInteger(33309);
                if (lllllllllllllllIlIIllIIIlIllIlIl > 0) {
                    final String[] lllllllllllllllIlIIllIIIlIllIlII = new String[lllllllllllllllIlIIllIIIlIllIlIl];
                    for (int lllllllllllllllIlIIllIIIlIllIIll = 0; lllllllllllllllIlIIllIIIlIllIIll < lllllllllllllllIlIIllIIIlIllIlIl; ++lllllllllllllllIlIIllIIIlIllIIll) {
                        lllllllllllllllIlIIllIIIlIllIlII[lllllllllllllllIlIIllIIIlIllIIll] = GL30.glGetStringi(7939, lllllllllllllllIlIIllIIIlIllIIll);
                    }
                    return lllllllllllllllIlIIllIIIlIllIlII;
                }
            }
        }
        catch (Exception lllllllllllllllIlIIllIIIlIllIIlI) {
            lllllllllllllllIlIIllIIIlIllIIlI.printStackTrace();
        }
        try {
            final String lllllllllllllllIlIIllIIIlIllIIIl = GL11.glGetString(7939);
            final String[] lllllllllllllllIlIIllIIIlIllIIII = lllllllllllllllIlIIllIIIlIllIIIl.split(" ");
            return lllllllllllllllIlIIllIIIlIllIIII;
        }
        catch (Exception lllllllllllllllIlIIllIIIlIlIllll) {
            lllllllllllllllIlIIllIIIlIlIllll.printStackTrace();
            return new String[0];
        }
    }
    
    public static boolean isCloudsOff() {
        if (Config.gameSettings.ofClouds != 0) {
            return Config.gameSettings.ofClouds == 3;
        }
        if (isShaders() && !Shaders.shaderPackClouds.isDefault()) {
            return Shaders.shaderPackClouds.isOff();
        }
        return Config.texturePackClouds != 0 && Config.texturePackClouds == 3;
    }
    
    public static boolean isBetterGrass() {
        return Config.gameSettings.ofBetterGrass != 3;
    }
    
    public static IResourcePack[] getResourcePacks() {
        final ResourcePackRepository lllllllllllllllIlIIllIIIIIIllIIl = Config.minecraft.getResourcePackRepository();
        final List lllllllllllllllIlIIllIIIIIIllIII = lllllllllllllllIlIIllIIIIIIllIIl.getRepositoryEntries();
        final List lllllllllllllllIlIIllIIIIIIlIlll = new ArrayList();
        for (final Object lllllllllllllllIlIIllIIIIIIlIllI : lllllllllllllllIlIIllIIIIIIllIII) {
            lllllllllllllllIlIIllIIIIIIlIlll.add(((ResourcePackRepository.Entry)lllllllllllllllIlIIllIIIIIIlIllI).getResourcePack());
        }
        if (lllllllllllllllIlIIllIIIIIIllIIl.getResourcePackInstance() != null) {
            lllllllllllllllIlIIllIIIIIIlIlll.add(lllllllllllllllIlIIllIIIIIIllIIl.getResourcePackInstance());
        }
        final IResourcePack[] lllllllllllllllIlIIllIIIIIIlIlIl = lllllllllllllllIlIIllIIIIIIlIlll.toArray(new IResourcePack[lllllllllllllllIlIIllIIIIIIlIlll.size()]);
        return lllllllllllllllIlIIllIIIIIIlIlIl;
    }
    
    public static boolean isShowCapes() {
        return Config.gameSettings.ofShowCapes;
    }
    
    public static boolean isUseAlphaFunc() {
        final float lllllllllllllllIlIIllIIIlIIIllIl = getAlphaFuncLevel();
        return lllllllllllllllIlIIllIIIlIIIllIl > Config.DEF_ALPHA_FUNC_LEVEL + 1.0E-5f;
    }
    
    public static boolean isAnimatedSmoke() {
        return Config.gameSettings.ofAnimatedSmoke;
    }
    
    public static void initDisplay() {
        checkInitialized();
        Config.antialiasingLevel = Config.gameSettings.ofAaLevel;
        checkDisplaySettings();
        checkDisplayMode();
        Config.minecraftThread = Thread.currentThread();
        updateThreadPriorities();
        Shaders.startup(Minecraft.getMinecraft());
    }
    
    public static boolean equalsOne(final Object lllllllllllllllIlIIlIllIlIIlIlll, final Object[] lllllllllllllllIlIIlIllIlIIllIlI) {
        if (lllllllllllllllIlIIlIllIlIIllIlI == null) {
            return false;
        }
        for (int lllllllllllllllIlIIlIllIlIIllIIl = 0; lllllllllllllllIlIIlIllIlIIllIIl < lllllllllllllllIlIIlIllIlIIllIlI.length; ++lllllllllllllllIlIIlIllIlIIllIIl) {
            final Object lllllllllllllllIlIIlIllIlIIllIII = lllllllllllllllIlIIlIllIlIIllIlI[lllllllllllllllIlIIlIllIlIIllIIl];
            if (equals(lllllllllllllllIlIIlIllIlIIlIlll, lllllllllllllllIlIIlIllIlIIllIII)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean hasResource(final IResourceManager lllllllllllllllIlIIllIIIIIlIIlIl, final ResourceLocation lllllllllllllllIlIIllIIIIIlIIIII) {
        try {
            final IResource lllllllllllllllIlIIllIIIIIlIIIll = lllllllllllllllIlIIllIIIIIlIIlIl.getResource(lllllllllllllllIlIIllIIIIIlIIIII);
            return lllllllllllllllIlIIllIIIIIlIIIll != null;
        }
        catch (IOException lllllllllllllllIlIIllIIIIIlIIIlI) {
            return false;
        }
    }
    
    public static int parseInt(String lllllllllllllllIlIIlIlllllIIlIIl, final int lllllllllllllllIlIIlIlllllIIlIII) {
        try {
            if (lllllllllllllllIlIIlIlllllIIlIIl == null) {
                return lllllllllllllllIlIIlIlllllIIlIII;
            }
            lllllllllllllllIlIIlIlllllIIlIIl = lllllllllllllllIlIIlIlllllIIlIIl.trim();
            return Integer.parseInt(lllllllllllllllIlIIlIlllllIIlIIl);
        }
        catch (NumberFormatException lllllllllllllllIlIIlIlllllIIlIlI) {
            return lllllllllllllllIlIIlIlllllIIlIII;
        }
    }
    
    public static void error(final String lllllllllllllllIlIIllIIIlIIIIlII) {
        Config.LOGGER.error(String.valueOf(new StringBuilder("[OptiFine] ").append(lllllllllllllllIlIIllIIIlIIIIlII)));
    }
    
    public static String readInputStream(final InputStream lllllllllllllllIlIIlIlllIIIllIlI) throws IOException {
        return readInputStream(lllllllllllllllIlIIlIlllIIIllIlI, "ASCII");
    }
    
    public static boolean isMoonTexture() {
        return isSunMoonEnabled() && (!isShaders() || Shaders.isMoon());
    }
    
    public static boolean isRandomMobs() {
        return Config.gameSettings.ofRandomMobs;
    }
    
    public static boolean isSingleProcessor() {
        return getAvailableProcessors() <= 1;
    }
    
    public static int getMipmapType() {
        switch (Config.gameSettings.ofMipmapType) {
            case 0: {
                return 9986;
            }
            case 1: {
                return 9986;
            }
            case 2: {
                if (isMultiTexture()) {
                    return 9985;
                }
                return 9986;
            }
            case 3: {
                if (isMultiTexture()) {
                    return 9987;
                }
                return 9986;
            }
            default: {
                return 9986;
            }
        }
    }
    
    public static Object[] addObjectToArray(final Object[] lllllllllllllllIlIIlIllIIIlIIllI, final Object lllllllllllllllIlIIlIllIIIlIIlIl, final int lllllllllllllllIlIIlIllIIIlIlIIl) {
        final List lllllllllllllllIlIIlIllIIIlIlIII = new ArrayList(Arrays.asList(lllllllllllllllIlIIlIllIIIlIIllI));
        lllllllllllllllIlIIlIllIIIlIlIII.add(lllllllllllllllIlIIlIllIIIlIlIIl, lllllllllllllllIlIIlIllIIIlIIlIl);
        final Object[] lllllllllllllllIlIIlIllIIIlIIlll = (Object[])Array.newInstance(lllllllllllllllIlIIlIllIIIlIIllI.getClass().getComponentType(), lllllllllllllllIlIIlIllIIIlIlIII.size());
        return lllllllllllllllIlIIlIllIIIlIlIII.toArray(lllllllllllllllIlIIlIllIIIlIIlll);
    }
    
    public static int getScreenshotSize() {
        return Config.gameSettings.ofScreenshotSize;
    }
    
    public static Object[] addObjectsToArray(final Object[] lllllllllllllllIlIIlIllIIIIlllII, final Object[] lllllllllllllllIlIIlIllIIIIlIllI) {
        if (lllllllllllllllIlIIlIllIIIIlllII == null) {
            throw new NullPointerException("The given array is NULL");
        }
        if (lllllllllllllllIlIIlIllIIIIlIllI.length == 0) {
            return lllllllllllllllIlIIlIllIIIIlllII;
        }
        final int lllllllllllllllIlIIlIllIIIIllIlI = lllllllllllllllIlIIlIllIIIIlllII.length;
        final int lllllllllllllllIlIIlIllIIIIllIIl = lllllllllllllllIlIIlIllIIIIllIlI + lllllllllllllllIlIIlIllIIIIlIllI.length;
        final Object[] lllllllllllllllIlIIlIllIIIIllIII = (Object[])Array.newInstance(lllllllllllllllIlIIlIllIIIIlllII.getClass().getComponentType(), lllllllllllllllIlIIlIllIIIIllIIl);
        System.arraycopy(lllllllllllllllIlIIlIllIIIIlllII, 0, lllllllllllllllIlIIlIllIIIIllIII, 0, lllllllllllllllIlIIlIllIIIIllIlI);
        System.arraycopy(lllllllllllllllIlIIlIllIIIIlIllI, 0, lllllllllllllllIlIIlIllIIIIllIII, lllllllllllllllIlIIlIllIIIIllIlI, lllllllllllllllIlIIlIllIIIIlIllI.length);
        return lllllllllllllllIlIIlIllIIIIllIII;
    }
    
    public static void checkDisplaySettings() {
        final int lllllllllllllllIlIIlIllIIlllIlIl = getAntialiasingLevel();
        if (lllllllllllllllIlIIlIllIIlllIlIl > 0) {
            final DisplayMode lllllllllllllllIlIIlIllIIlllIlII = Display.getDisplayMode();
            dbg(String.valueOf(new StringBuilder("FSAA Samples: ").append(lllllllllllllllIlIIlIllIIlllIlIl)));
            try {
                Display.destroy();
                Display.setDisplayMode(lllllllllllllllIlIIlIllIIlllIlII);
                Display.create(new PixelFormat().withDepthBits(24).withSamples(lllllllllllllllIlIIlIllIIlllIlIl));
                Display.setResizable(false);
                Display.setResizable(true);
            }
            catch (LWJGLException lllllllllllllllIlIIlIllIIlllIIll) {
                warn(String.valueOf(new StringBuilder("Error setting FSAA: ").append(lllllllllllllllIlIIlIllIIlllIlIl).append("x")));
                lllllllllllllllIlIIlIllIIlllIIll.printStackTrace();
                try {
                    Display.setDisplayMode(lllllllllllllllIlIIlIllIIlllIlII);
                    Display.create(new PixelFormat().withDepthBits(24));
                    Display.setResizable(false);
                    Display.setResizable(true);
                }
                catch (LWJGLException lllllllllllllllIlIIlIllIIlllIIlI) {
                    lllllllllllllllIlIIlIllIIlllIIlI.printStackTrace();
                    try {
                        Display.setDisplayMode(lllllllllllllllIlIIlIllIIlllIlII);
                        Display.create();
                        Display.setResizable(false);
                        Display.setResizable(true);
                    }
                    catch (LWJGLException lllllllllllllllIlIIlIllIIlllIIIl) {
                        lllllllllllllllIlIIlIllIIlllIIIl.printStackTrace();
                    }
                }
            }
            if (!Minecraft.IS_RUNNING_ON_MAC && getDefaultResourcePack() != null) {
                InputStream lllllllllllllllIlIIlIllIIlllIIII = null;
                InputStream lllllllllllllllIlIIlIllIIllIllll = null;
                try {
                    lllllllllllllllIlIIlIllIIlllIIII = getDefaultResourcePack().getInputStreamAssets(new ResourceLocation("icons/icon_16x16.png"));
                    lllllllllllllllIlIIlIllIIllIllll = getDefaultResourcePack().getInputStreamAssets(new ResourceLocation("icons/icon_32x32.png"));
                    if (lllllllllllllllIlIIlIllIIlllIIII != null && lllllllllllllllIlIIlIllIIllIllll != null) {
                        Display.setIcon(new ByteBuffer[] { readIconImage(lllllllllllllllIlIIlIllIIlllIIII), readIconImage(lllllllllllllllIlIIlIllIIllIllll) });
                    }
                }
                catch (IOException lllllllllllllllIlIIlIllIIllIlllI) {
                    warn(String.valueOf(new StringBuilder("Error setting window icon: ").append(lllllllllllllllIlIIlIllIIllIlllI.getClass().getName()).append(": ").append(lllllllllllllllIlIIlIllIIllIlllI.getMessage())));
                    return;
                }
                finally {
                    IOUtils.closeQuietly(lllllllllllllllIlIIlIllIIlllIIII);
                    IOUtils.closeQuietly(lllllllllllllllIlIIlIllIIllIllll);
                }
                IOUtils.closeQuietly(lllllllllllllllIlIIlIllIIlllIIII);
                IOUtils.closeQuietly(lllllllllllllllIlIIlIllIIllIllll);
            }
        }
    }
    
    public static String[] getOpenGlExtensions() {
        if (Config.openGlExtensions == null) {
            Config.openGlExtensions = detectOpenGlExtensions();
        }
        return Config.openGlExtensions;
    }
    
    public static WorldServer getWorldServer() {
        final World lllllllllllllllIlIIlIllIlIllIIll = Config.minecraft.world;
        if (lllllllllllllllIlIIlIllIlIllIIll == null) {
            return null;
        }
        if (!Config.minecraft.isIntegratedServerRunning()) {
            return null;
        }
        final IntegratedServer lllllllllllllllIlIIlIllIlIllIIlI = Config.minecraft.getIntegratedServer();
        if (lllllllllllllllIlIIlIllIlIllIIlI == null) {
            return null;
        }
        final WorldProvider lllllllllllllllIlIIlIllIlIllIIIl = lllllllllllllllIlIIlIllIlIllIIll.provider;
        if (lllllllllllllllIlIIlIllIlIllIIIl == null) {
            return null;
        }
        final DimensionType lllllllllllllllIlIIlIllIlIllIIII = lllllllllllllllIlIIlIllIlIllIIIl.getDimensionType();
        try {
            final WorldServer lllllllllllllllIlIIlIllIlIlIllll = lllllllllllllllIlIIlIllIlIllIIlI.worldServerForDimension(lllllllllllllllIlIIlIllIlIllIIII.getId());
            return lllllllllllllllIlIIlIllIlIlIllll;
        }
        catch (NullPointerException lllllllllllllllIlIIlIllIlIlIlllI) {
            return null;
        }
    }
    
    public static boolean isDynamicHandLight() {
        return isDynamicLights() && (!isShaders() || Shaders.isDynamicHandLight());
    }
    
    public static void setNewRelease(final String lllllllllllllllIlIIlIllIllllIlIl) {
        Config.newRelease = lllllllllllllllIlIIlIllIllllIlIl;
    }
    
    public static boolean between(final int lllllllllllllllIlIIlIlllllIllIll, final int lllllllllllllllIlIIlIlllllIllIlI, final int lllllllllllllllIlIIlIlllllIllIIl) {
        return lllllllllllllllIlIIlIlllllIllIll >= lllllllllllllllIlIIlIlllllIllIlI && lllllllllllllllIlIIlIlllllIllIll <= lllllllllllllllIlIIlIlllllIllIIl;
    }
    
    public static boolean isShaders() {
        return Shaders.shaderPackLoaded;
    }
    
    public static boolean isCloudsFancy() {
        if (Config.gameSettings.ofClouds != 0) {
            return Config.gameSettings.ofClouds == 2;
        }
        if (isShaders() && !Shaders.shaderPackClouds.isDefault()) {
            return Shaders.shaderPackClouds.isFancy();
        }
        if (Config.texturePackClouds != 0) {
            return Config.texturePackClouds == 2;
        }
        return Config.gameSettings.fancyGraphics;
    }
    
    public static void checkInitialized() {
        if (!Config.initialized && Display.isCreated()) {
            Config.initialized = true;
            checkOpenGlCaps();
            startVersionCheckThread();
        }
    }
    
    public static IResourcePack getDefiningResourcePack(final ResourceLocation lllllllllllllllIlIIlIlllllllIIlI) {
        final ResourcePackRepository lllllllllllllllIlIIlIlllllllIIIl = Config.minecraft.getResourcePackRepository();
        final IResourcePack lllllllllllllllIlIIlIlllllllIIII = lllllllllllllllIlIIlIlllllllIIIl.getResourcePackInstance();
        if (lllllllllllllllIlIIlIlllllllIIII != null && lllllllllllllllIlIIlIlllllllIIII.resourceExists(lllllllllllllllIlIIlIlllllllIIlI)) {
            return lllllllllllllllIlIIlIlllllllIIII;
        }
        final List<ResourcePackRepository.Entry> lllllllllllllllIlIIlIllllllIllll = lllllllllllllllIlIIlIlllllllIIIl.repositoryEntries;
        for (int lllllllllllllllIlIIlIllllllIlllI = lllllllllllllllIlIIlIllllllIllll.size() - 1; lllllllllllllllIlIIlIllllllIlllI >= 0; --lllllllllllllllIlIIlIllllllIlllI) {
            final ResourcePackRepository.Entry lllllllllllllllIlIIlIllllllIllIl = lllllllllllllllIlIIlIllllllIllll.get(lllllllllllllllIlIIlIllllllIlllI);
            final IResourcePack lllllllllllllllIlIIlIllllllIllII = lllllllllllllllIlIIlIllllllIllIl.getResourcePack();
            if (lllllllllllllllIlIIlIllllllIllII.resourceExists(lllllllllllllllIlIIlIlllllllIIlI)) {
                return lllllllllllllllIlIIlIllllllIllII;
            }
        }
        if (getDefaultResourcePack().resourceExists(lllllllllllllllIlIIlIlllllllIIlI)) {
            return getDefaultResourcePack();
        }
        return null;
    }
    
    public static boolean isSmoothBiomes() {
        return Config.gameSettings.ofSmoothBiomes;
    }
    
    private static GlVersion getGlVersionLwjgl() {
        if (GLContext.getCapabilities().OpenGL44) {
            return new GlVersion(4, 4);
        }
        if (GLContext.getCapabilities().OpenGL43) {
            return new GlVersion(4, 3);
        }
        if (GLContext.getCapabilities().OpenGL42) {
            return new GlVersion(4, 2);
        }
        if (GLContext.getCapabilities().OpenGL41) {
            return new GlVersion(4, 1);
        }
        if (GLContext.getCapabilities().OpenGL40) {
            return new GlVersion(4, 0);
        }
        if (GLContext.getCapabilities().OpenGL33) {
            return new GlVersion(3, 3);
        }
        if (GLContext.getCapabilities().OpenGL32) {
            return new GlVersion(3, 2);
        }
        if (GLContext.getCapabilities().OpenGL31) {
            return new GlVersion(3, 1);
        }
        if (GLContext.getCapabilities().OpenGL30) {
            return new GlVersion(3, 0);
        }
        if (GLContext.getCapabilities().OpenGL21) {
            return new GlVersion(2, 1);
        }
        if (GLContext.getCapabilities().OpenGL20) {
            return new GlVersion(2, 0);
        }
        if (GLContext.getCapabilities().OpenGL15) {
            return new GlVersion(1, 5);
        }
        if (GLContext.getCapabilities().OpenGL14) {
            return new GlVersion(1, 4);
        }
        if (GLContext.getCapabilities().OpenGL13) {
            return new GlVersion(1, 3);
        }
        if (GLContext.getCapabilities().OpenGL12) {
            return new GlVersion(1, 2);
        }
        return GLContext.getCapabilities().OpenGL11 ? new GlVersion(1, 1) : new GlVersion(1, 0);
    }
    
    public static int intHash(int lllllllllllllllIlIIlIllIllIIIIlI) {
        lllllllllllllllIlIIlIllIllIIIIlI = (lllllllllllllllIlIIlIllIllIIIIlI ^ 0x3D ^ lllllllllllllllIlIIlIllIllIIIIlI >> 16);
        lllllllllllllllIlIIlIllIllIIIIlI += lllllllllllllllIlIIlIllIllIIIIlI << 3;
        lllllllllllllllIlIIlIllIllIIIIlI ^= lllllllllllllllIlIIlIllIllIIIIlI >> 4;
        lllllllllllllllIlIIlIllIllIIIIlI *= 668265261;
        lllllllllllllllIlIIlIllIllIIIIlI ^= lllllllllllllllIlIIlIllIllIIIIlI >> 15;
        return lllllllllllllllIlIIlIllIllIIIIlI;
    }
    
    public static int getChunkViewDistance() {
        if (Config.gameSettings == null) {
            return 10;
        }
        final int lllllllllllllllIlIIlIllIlIlIIlll = Config.gameSettings.renderDistanceChunks;
        return lllllllllllllllIlIIlIllIlIlIIlll;
    }
    
    public static boolean isAnimatedRedstone() {
        return Config.gameSettings.ofAnimatedRedstone;
    }
    
    public static boolean isBetterSnow() {
        return Config.gameSettings.ofBetterSnow;
    }
    
    public static boolean isFogFast() {
        return Config.gameSettings.ofFogType == 1;
    }
    
    public static void updateAvailableProcessors() {
        Config.availableProcessors = Runtime.getRuntime().availableProcessors();
    }
    
    public static boolean isRainFancy() {
        if (Config.gameSettings.ofRain == 0) {
            return Config.gameSettings.fancyGraphics;
        }
        return Config.gameSettings.ofRain == 2;
    }
    
    public static boolean isAntialiasingConfigured() {
        return getGameSettings().ofAaLevel > 0;
    }
    
    public static String[] tokenize(final String lllllllllllllllIlIIlIllllIlIlIIl, final String lllllllllllllllIlIIlIllllIlIlllI) {
        final StringTokenizer lllllllllllllllIlIIlIllllIlIllIl = new StringTokenizer(lllllllllllllllIlIIlIllllIlIlIIl, lllllllllllllllIlIIlIllllIlIlllI);
        final List lllllllllllllllIlIIlIllllIlIllII = new ArrayList();
        while (lllllllllllllllIlIIlIllllIlIllIl.hasMoreTokens()) {
            final String lllllllllllllllIlIIlIllllIlIlIll = lllllllllllllllIlIIlIllllIlIllIl.nextToken();
            lllllllllllllllIlIIlIllllIlIllII.add(lllllllllllllllIlIIlIllllIlIlIll);
        }
        final String[] lllllllllllllllIlIIlIllllIlIlIlI = lllllllllllllllIlIIlIllllIlIllII.toArray(new String[lllllllllllllllIlIIlIllllIlIllII.size()]);
        return lllllllllllllllIlIIlIllllIlIlIlI;
    }
    
    public static boolean isAnimatedTextures() {
        return Config.gameSettings.ofAnimatedTextures;
    }
    
    public static int compareRelease(final String lllllllllllllllIlIIlIllIlllIlIlI, final String lllllllllllllllIlIIlIllIlllIlIIl) {
        final String[] lllllllllllllllIlIIlIllIlllIlIII = splitRelease(lllllllllllllllIlIIlIllIlllIlIlI);
        final String[] lllllllllllllllIlIIlIllIlllIIlll = splitRelease(lllllllllllllllIlIIlIllIlllIlIIl);
        final String lllllllllllllllIlIIlIllIlllIIllI = lllllllllllllllIlIIlIllIlllIlIII[0];
        final String lllllllllllllllIlIIlIllIlllIIlIl = lllllllllllllllIlIIlIllIlllIIlll[0];
        if (!lllllllllllllllIlIIlIllIlllIIllI.equals(lllllllllllllllIlIIlIllIlllIIlIl)) {
            return lllllllllllllllIlIIlIllIlllIIllI.compareTo(lllllllllllllllIlIIlIllIlllIIlIl);
        }
        final int lllllllllllllllIlIIlIllIlllIIlII = parseInt(lllllllllllllllIlIIlIllIlllIlIII[1], -1);
        final int lllllllllllllllIlIIlIllIlllIIIll = parseInt(lllllllllllllllIlIIlIllIlllIIlll[1], -1);
        if (lllllllllllllllIlIIlIllIlllIIlII != lllllllllllllllIlIIlIllIlllIIIll) {
            return lllllllllllllllIlIIlIllIlllIIlII - lllllllllllllllIlIIlIllIlllIIIll;
        }
        final String lllllllllllllllIlIIlIllIlllIIIlI = lllllllllllllllIlIIlIllIlllIlIII[2];
        final String lllllllllllllllIlIIlIllIlllIIIIl = lllllllllllllllIlIIlIllIlllIIlll[2];
        if (!lllllllllllllllIlIIlIllIlllIIIlI.equals(lllllllllllllllIlIIlIllIlllIIIIl)) {
            if (lllllllllllllllIlIIlIllIlllIIIlI.isEmpty()) {
                return 1;
            }
            if (lllllllllllllllIlIIlIllIlllIIIIl.isEmpty()) {
                return -1;
            }
        }
        return lllllllllllllllIlIIlIllIlllIIIlI.compareTo(lllllllllllllllIlIIlIllIlllIIIIl);
    }
    
    public static boolean isCustomGuis() {
        return Config.gameSettings.ofCustomGuis;
    }
    
    private static String[] splitRelease(final String lllllllllllllllIlIIlIllIllIIlIlI) {
        if (lllllllllllllllIlIIlIllIllIIlIlI == null || lllllllllllllllIlIIlIllIllIIlIlI.length() <= 0) {
            return new String[] { "", "", "" };
        }
        final Pattern lllllllllllllllIlIIlIllIllIIllll = Pattern.compile("([A-Z])([0-9]+)(.*)");
        final Matcher lllllllllllllllIlIIlIllIllIIlllI = lllllllllllllllIlIIlIllIllIIllll.matcher(lllllllllllllllIlIIlIllIllIIlIlI);
        if (!lllllllllllllllIlIIlIllIllIIlllI.matches()) {
            return new String[] { "", "", "" };
        }
        final String lllllllllllllllIlIIlIllIllIIllIl = normalize(lllllllllllllllIlIIlIllIllIIlllI.group(1));
        final String lllllllllllllllIlIIlIllIllIIllII = normalize(lllllllllllllllIlIIlIllIllIIlllI.group(2));
        final String lllllllllllllllIlIIlIllIllIIlIll = normalize(lllllllllllllllIlIIlIllIllIIlllI.group(3));
        return new String[] { lllllllllllllllIlIIlIllIllIIllIl, lllllllllllllllIlIIlIllIllIIllII, lllllllllllllllIlIIlIllIllIIlIll };
    }
    
    public static boolean isFireworkParticles() {
        return Config.gameSettings.ofFireworkParticles;
    }
    
    public static int limit(final int lllllllllllllllIlIIllIIIIlllIIII, final int lllllllllllllllIlIIllIIIIllIllll, final int lllllllllllllllIlIIllIIIIllIlIll) {
        if (lllllllllllllllIlIIllIIIIlllIIII < lllllllllllllllIlIIllIIIIllIllll) {
            return lllllllllllllllIlIIllIIIIllIllll;
        }
        return (lllllllllllllllIlIIllIIIIlllIIII > lllllllllllllllIlIIllIIIIllIlIll) ? lllllllllllllllIlIIllIIIIllIlIll : lllllllllllllllIlIIllIIIIlllIIII;
    }
    
    public static GameSettings getGameSettings() {
        return Config.gameSettings;
    }
    
    public static boolean equalsOne(final int lllllllllllllllIlIIlIllIlIIIllIl, final int[] lllllllllllllllIlIIlIllIlIIIllll) {
        for (int lllllllllllllllIlIIlIllIlIIIlllI = 0; lllllllllllllllIlIIlIllIlIIIlllI < lllllllllllllllIlIIlIllIlIIIllll.length; ++lllllllllllllllIlIIlIllIlIIIlllI) {
            if (lllllllllllllllIlIIlIllIlIIIllll[lllllllllllllllIlIIlIllIlIIIlllI] == lllllllllllllllIlIIlIllIlIIIllIl) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isSunMoonEnabled() {
        return Config.gameSettings.ofSunMoon;
    }
    
    private static String getUpdates(final String lllllllllllllllIlIIlIlIlllllllIl) {
        final int lllllllllllllllIlIIlIlIlllllllII = lllllllllllllllIlIIlIlIlllllllIl.indexOf(40);
        if (lllllllllllllllIlIIlIlIlllllllII < 0) {
            return "";
        }
        final int lllllllllllllllIlIIlIlIllllllIll = lllllllllllllllIlIIlIlIlllllllIl.indexOf(32, lllllllllllllllIlIIlIlIlllllllII);
        return (lllllllllllllllIlIIlIlIllllllIll < 0) ? "" : lllllllllllllllIlIIlIlIlllllllIl.substring(lllllllllllllllIlIIlIlIlllllllII + 1, lllllllllllllllIlIIlIlIllllllIll);
    }
    
    public static boolean isAnimatedLava() {
        return Config.gameSettings.ofAnimatedLava != 2;
    }
    
    private static Set<Dimension> getDisplayModeDimensions(final DisplayMode[] lllllllllllllllIlIIlIlllIllllllI) {
        final Set<Dimension> lllllllllllllllIlIIlIllllIIIIIlI = new HashSet<Dimension>();
        for (int lllllllllllllllIlIIlIllllIIIIIIl = 0; lllllllllllllllIlIIlIllllIIIIIIl < lllllllllllllllIlIIlIlllIllllllI.length; ++lllllllllllllllIlIIlIllllIIIIIIl) {
            final DisplayMode lllllllllllllllIlIIlIllllIIIIIII = lllllllllllllllIlIIlIlllIllllllI[lllllllllllllllIlIIlIllllIIIIIIl];
            final Dimension lllllllllllllllIlIIlIlllIlllllll = new Dimension(lllllllllllllllIlIIlIllllIIIIIII.getWidth(), lllllllllllllllIlIIlIllllIIIIIII.getHeight());
            lllllllllllllllIlIIlIllllIIIIIlI.add(lllllllllllllllIlIIlIlllIlllllll);
        }
        return lllllllllllllllIlIIlIllllIIIIIlI;
    }
    
    public static float getAmbientOcclusionLevel() {
        return (isShaders() && Shaders.aoLevel >= 0.0f) ? Shaders.aoLevel : Config.gameSettings.ofAoLevel;
    }
    
    public static String getResourcePackNames() {
        if (Config.minecraft.getResourcePackRepository() == null) {
            return "";
        }
        final IResourcePack[] lllllllllllllllIlIIllIIIIIIIllII = getResourcePacks();
        if (lllllllllllllllIlIIllIIIIIIIllII.length <= 0) {
            return getDefaultResourcePack().getPackName();
        }
        final String[] lllllllllllllllIlIIllIIIIIIIlIll = new String[lllllllllllllllIlIIllIIIIIIIllII.length];
        for (int lllllllllllllllIlIIllIIIIIIIlIlI = 0; lllllllllllllllIlIIllIIIIIIIlIlI < lllllllllllllllIlIIllIIIIIIIllII.length; ++lllllllllllllllIlIIllIIIIIIIlIlI) {
            lllllllllllllllIlIIllIIIIIIIlIll[lllllllllllllllIlIIllIIIIIIIlIlI] = lllllllllllllllIlIIllIIIIIIIllII[lllllllllllllllIlIIllIIIIIIIlIlI].getPackName();
        }
        final String lllllllllllllllIlIIllIIIIIIIlIIl = arrayToString(lllllllllllllllIlIIllIIIIIIIlIll);
        return lllllllllllllllIlIIllIIIIIIIlIIl;
    }
    
    public static float limit(final float lllllllllllllllIlIIllIIIIllIIlll, final float lllllllllllllllIlIIllIIIIllIIllI, final float lllllllllllllllIlIIllIIIIllIIIlI) {
        if (lllllllllllllllIlIIllIIIIllIIlll < lllllllllllllllIlIIllIIIIllIIllI) {
            return lllllllllllllllIlIIllIIIIllIIllI;
        }
        return (lllllllllllllllIlIIllIIIIllIIlll > lllllllllllllllIlIIllIIIIllIIIlI) ? lllllllllllllllIlIIllIIIIllIIIlI : lllllllllllllllIlIIllIIIIllIIlll;
    }
    
    public static DisplayMode getLargestDisplayMode() {
        final DisplayMode[] lllllllllllllllIlIIlIllllIIIllII = getDisplayModes();
        if (lllllllllllllllIlIIlIllllIIIllII == null || lllllllllllllllIlIIlIllllIIIllII.length < 1) {
            return Config.desktopDisplayMode;
        }
        final DisplayMode lllllllllllllllIlIIlIllllIIIlIll = lllllllllllllllIlIIlIllllIIIllII[lllllllllllllllIlIIlIllllIIIllII.length - 1];
        if (Config.desktopDisplayMode.getWidth() > lllllllllllllllIlIIlIllllIIIlIll.getWidth()) {
            return Config.desktopDisplayMode;
        }
        return (Config.desktopDisplayMode.getWidth() == lllllllllllllllIlIIlIllllIIIlIll.getWidth() && Config.desktopDisplayMode.getHeight() > lllllllllllllllIlIIlIllllIIIlIll.getHeight()) ? Config.desktopDisplayMode : lllllllllllllllIlIIlIllllIIIlIll;
    }
    
    public static IResource getResource(final ResourceLocation lllllllllllllllIlIIllIIIIIllIIII) throws IOException {
        return Config.minecraft.getResourceManager().getResource(lllllllllllllllIlIIllIIIIIllIIII);
    }
    
    public static boolean isAnimatedPortal() {
        return Config.gameSettings.ofAnimatedPortal;
    }
    
    public static boolean isPotionParticles() {
        return Config.gameSettings.ofPotionParticles;
    }
    
    public static String arrayToString(final Object[] lllllllllllllllIlIIllIIIIlIlIIIl) {
        if (lllllllllllllllIlIIllIIIIlIlIIIl == null) {
            return "";
        }
        final StringBuffer lllllllllllllllIlIIllIIIIlIlIIII = new StringBuffer(lllllllllllllllIlIIllIIIIlIlIIIl.length * 5);
        for (int lllllllllllllllIlIIllIIIIlIIllll = 0; lllllllllllllllIlIIllIIIIlIIllll < lllllllllllllllIlIIllIIIIlIlIIIl.length; ++lllllllllllllllIlIIllIIIIlIIllll) {
            final Object lllllllllllllllIlIIllIIIIlIIlllI = lllllllllllllllIlIIllIIIIlIlIIIl[lllllllllllllllIlIIllIIIIlIIllll];
            if (lllllllllllllllIlIIllIIIIlIIllll > 0) {
                lllllllllllllllIlIIllIIIIlIlIIII.append(", ");
            }
            lllllllllllllllIlIIllIIIIlIlIIII.append(String.valueOf(lllllllllllllllIlIIllIIIIlIIlllI));
        }
        return lllllllllllllllIlIIllIIIIlIlIIII.toString();
    }
    
    public static boolean isFogFancy() {
        return isFancyFogAvailable() && Config.gameSettings.ofFogType == 2;
    }
    
    public static boolean isConnectedTexturesFancy() {
        return Config.gameSettings.ofConnectedTextures == 2;
    }
    
    public static byte[] readAll(final InputStream lllllllllllllllIlIIlIlllIIIIIIIl) throws IOException {
        final ByteArrayOutputStream lllllllllllllllIlIIlIlllIIIIIIII = new ByteArrayOutputStream();
        final byte[] lllllllllllllllIlIIlIllIllllllll = new byte[1024];
        while (true) {
            final int lllllllllllllllIlIIlIllIlllllllI = lllllllllllllllIlIIlIlllIIIIIIIl.read(lllllllllllllllIlIIlIllIllllllll);
            if (lllllllllllllllIlIIlIllIlllllllI < 0) {
                break;
            }
            lllllllllllllllIlIIlIlllIIIIIIII.write(lllllllllllllllIlIIlIllIllllllll, 0, lllllllllllllllIlIIlIllIlllllllI);
        }
        lllllllllllllllIlIIlIlllIIIIIIIl.close();
        final byte[] lllllllllllllllIlIIlIllIllllllIl = lllllllllllllllIlIIlIlllIIIIIIII.toByteArray();
        return lllllllllllllllIlIIlIllIllllllIl;
    }
    
    public static boolean equals(final Object lllllllllllllllIlIIlIllIlIlIIIll, final Object lllllllllllllllIlIIlIllIlIlIIIlI) {
        return lllllllllllllllIlIIlIllIlIlIIIll == lllllllllllllllIlIIlIllIlIlIIIlI || (lllllllllllllllIlIIlIllIlIlIIIll != null && lllllllllllllllIlIIlIllIlIlIIIll.equals(lllllllllllllllIlIIlIllIlIlIIIlI));
    }
    
    public static boolean isPortalParticles() {
        return Config.gameSettings.ofPortalParticles;
    }
    
    public static boolean isMultiTexture() {
        return getAnisotropicFilterLevel() > 1 || getAntialiasingLevel() > 0;
    }
    
    public static boolean isDynamicLightsFast() {
        return Config.gameSettings.ofDynamicLights == 1;
    }
    
    public static boolean isAnimatedWater() {
        return Config.gameSettings.ofAnimatedWater != 2;
    }
    
    public static void updateFramebufferSize() {
        Config.minecraft.getFramebuffer().createBindFramebuffer(Config.minecraft.displayWidth, Config.minecraft.displayHeight);
        if (Config.minecraft.entityRenderer != null) {
            Config.minecraft.entityRenderer.updateShaderGroupSize(Config.minecraft.displayWidth, Config.minecraft.displayHeight);
        }
    }
    
    public static boolean isDynamicUpdates() {
        return Config.gameSettings.ofChunkUpdatesDynamic;
    }
    
    public static String getNewRelease() {
        return Config.newRelease;
    }
    
    public static InputStream getResourceStream(final ResourceLocation lllllllllllllllIlIIllIIIIIlllIll) throws IOException {
        return getResourceStream(Config.minecraft.getResourceManager(), lllllllllllllllIlIIllIIIIIlllIll);
    }
    
    public static String[] readLines(final File lllllllllllllllIlIIlIlllIIllIlll) throws IOException {
        final FileInputStream lllllllllllllllIlIIlIlllIIllIllI = new FileInputStream(lllllllllllllllIlIIlIlllIIllIlll);
        return readLines(lllllllllllllllIlIIlIlllIIllIllI);
    }
    
    static {
        OF_EDITION = "HD_U";
        MC_VERSION = "1.12.2";
        VERSION = "OptiFine_1.12.2_HD_U_C6";
        OF_RELEASE = "C6";
        OF_NAME = "OptiFine";
        Config.newRelease = null;
        Config.notify64BitJava = false;
        Config.openGlVersion = null;
        Config.openGlRenderer = null;
        Config.openGlVendor = null;
        Config.openGlExtensions = null;
        Config.glVersion = null;
        Config.glslVersion = null;
        Config.minecraftVersionInt = -1;
        Config.fancyFogAvailable = false;
        Config.occlusionAvailable = false;
        Config.gameSettings = null;
        Config.minecraft = Minecraft.getMinecraft();
        Config.initialized = false;
        Config.minecraftThread = null;
        Config.desktopDisplayMode = null;
        Config.displayModes = null;
        Config.antialiasingLevel = 0;
        Config.availableProcessors = 0;
        Config.zoomMode = false;
        Config.texturePackClouds = 0;
        Config.waterOpacityChanged = false;
        Config.fullscreenModeChecked = false;
        Config.desktopModeChecked = false;
        Config.defaultResourcePackLazy = null;
        DEF_ALPHA_FUNC_LEVEL = 0.1f;
        LOGGER = LogManager.getLogger();
    }
    
    public static boolean isGeneratedLava() {
        return Config.gameSettings.ofAnimatedLava == 1;
    }
    
    public static Dimension getFullscreenDimension() {
        if (Config.desktopDisplayMode == null) {
            return null;
        }
        if (Config.gameSettings == null) {
            return new Dimension(Config.desktopDisplayMode.getWidth(), Config.desktopDisplayMode.getHeight());
        }
        final String lllllllllllllllIlIIlIlllllIlIIll = Config.gameSettings.ofFullscreenMode;
        if (lllllllllllllllIlIIlIlllllIlIIll.equals("Default")) {
            return new Dimension(Config.desktopDisplayMode.getWidth(), Config.desktopDisplayMode.getHeight());
        }
        final String[] lllllllllllllllIlIIlIlllllIlIIlI = tokenize(lllllllllllllllIlIIlIlllllIlIIll, " x");
        return (lllllllllllllllIlIIlIlllllIlIIlI.length < 2) ? new Dimension(Config.desktopDisplayMode.getWidth(), Config.desktopDisplayMode.getHeight()) : new Dimension(parseInt(lllllllllllllllIlIIlIlllllIlIIlI[0], -1), parseInt(lllllllllllllllIlIIlIlllllIlIIlI[1], -1));
    }
    
    public static boolean isFromDefaultResourcePack(final ResourceLocation lllllllllllllllIlIIlIllllllllIll) {
        final IResourcePack lllllllllllllllIlIIlIlllllllllII = getDefiningResourcePack(lllllllllllllllIlIIlIllllllllIll);
        return lllllllllllllllIlIIlIlllllllllII == getDefaultResourcePack();
    }
    
    public static String normalize(final String lllllllllllllllIlIIlIllIIlllllII) {
        return (lllllllllllllllIlIIlIllIIlllllII == null) ? "" : lllllllllllllllIlIIlIllIIlllllII;
    }
    
    public static int getAntialiasingLevel() {
        return Config.antialiasingLevel;
    }
    
    public static boolean isTranslucentBlocksFancy() {
        if (Config.gameSettings.ofTranslucentBlocks == 0) {
            return Config.gameSettings.fancyGraphics;
        }
        return Config.gameSettings.ofTranslucentBlocks == 2;
    }
    
    public static boolean isAnimatedFlame() {
        return Config.gameSettings.ofAnimatedFlame;
    }
    
    private static void setThreadPriority(final String lllllllllllllllIlIIllIIIlIlIIIII, final int lllllllllllllllIlIIllIIIlIIlllll) {
        try {
            final ThreadGroup lllllllllllllllIlIIllIIIlIIllllI = Thread.currentThread().getThreadGroup();
            if (lllllllllllllllIlIIllIIIlIIllllI == null) {
                return;
            }
            final int lllllllllllllllIlIIllIIIlIIlllIl = (lllllllllllllllIlIIllIIIlIIllllI.activeCount() + 10) * 2;
            final Thread[] lllllllllllllllIlIIllIIIlIIlllII = new Thread[lllllllllllllllIlIIllIIIlIIlllIl];
            lllllllllllllllIlIIllIIIlIIllllI.enumerate(lllllllllllllllIlIIllIIIlIIlllII, false);
            for (int lllllllllllllllIlIIllIIIlIIllIll = 0; lllllllllllllllIlIIllIIIlIIllIll < lllllllllllllllIlIIllIIIlIIlllII.length; ++lllllllllllllllIlIIllIIIlIIllIll) {
                final Thread lllllllllllllllIlIIllIIIlIIllIlI = lllllllllllllllIlIIllIIIlIIlllII[lllllllllllllllIlIIllIIIlIIllIll];
                if (lllllllllllllllIlIIllIIIlIIllIlI != null && lllllllllllllllIlIIllIIIlIIllIlI.getName().startsWith(lllllllllllllllIlIIllIIIlIlIIIII)) {
                    lllllllllllllllIlIIllIIIlIIllIlI.setPriority(lllllllllllllllIlIIllIIIlIIlllll);
                }
            }
        }
        catch (Throwable lllllllllllllllIlIIllIIIlIIllIIl) {
            warn(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIllIIIlIIllIIl.getClass().getName())).append(": ").append(lllllllllllllllIlIIllIIIlIIllIIl.getMessage())));
        }
    }
    
    public static RenderGlobal getRenderGlobal() {
        return Config.minecraft.renderGlobal;
    }
    
    public static GlVersion getGlVersion() {
        if (Config.glVersion == null) {
            final String lllllllllllllllIlIIllIIIllIllIII = GL11.glGetString(7938);
            Config.glVersion = parseGlVersion(lllllllllllllllIlIIllIIIllIllIII, null);
            if (Config.glVersion == null) {
                Config.glVersion = getGlVersionLwjgl();
            }
            if (Config.glVersion == null) {
                Config.glVersion = new GlVersion(1, 0);
            }
        }
        return Config.glVersion;
    }
    
    public static boolean isAnimatedTerrain() {
        return Config.gameSettings.ofAnimatedTerrain;
    }
    
    public static boolean isGeneratedWater() {
        return Config.gameSettings.ofAnimatedWater == 1;
    }
    
    public static boolean isAlternateBlocks() {
        return Config.gameSettings.ofAlternateBlocks;
    }
    
    public static int getAvailableProcessors() {
        return Config.availableProcessors;
    }
    
    public static float getFogStart() {
        return Config.gameSettings.ofFogStart;
    }
    
    public static boolean isCustomItems() {
        return Config.gameSettings.ofCustomItems;
    }
    
    public static TextureManager getTextureManager() {
        return Config.minecraft.getTextureManager();
    }
    
    public static String readInputStream(final InputStream lllllllllllllllIlIIlIlllIIIlIIlI, final String lllllllllllllllIlIIlIlllIIIlIIIl) throws IOException {
        final InputStreamReader lllllllllllllllIlIIlIlllIIIlIIII = new InputStreamReader(lllllllllllllllIlIIlIlllIIIlIIlI, lllllllllllllllIlIIlIlllIIIlIIIl);
        final BufferedReader lllllllllllllllIlIIlIlllIIIIllll = new BufferedReader(lllllllllllllllIlIIlIlllIIIlIIII);
        final StringBuffer lllllllllllllllIlIIlIlllIIIIlllI = new StringBuffer();
        while (true) {
            final String lllllllllllllllIlIIlIlllIIIIllIl = lllllllllllllllIlIIlIlllIIIIllll.readLine();
            if (lllllllllllllllIlIIlIlllIIIIllIl == null) {
                break;
            }
            lllllllllllllllIlIIlIlllIIIIlllI.append(lllllllllllllllIlIIlIlllIIIIllIl);
            lllllllllllllllIlIIlIlllIIIIlllI.append("\n");
        }
        return lllllllllllllllIlIIlIlllIIIIlllI.toString();
    }
    
    public static boolean isSkyEnabled() {
        return Config.gameSettings.ofSky;
    }
    
    public static boolean isVoidParticles() {
        return Config.gameSettings.ofVoidParticles;
    }
    
    public static boolean isConnectedTextures() {
        return Config.gameSettings.ofConnectedTextures != 3;
    }
    
    public static boolean isDynamicLights() {
        return Config.gameSettings.ofDynamicLights != 3;
    }
    
    public static Object[] addObjectToArray(final Object[] lllllllllllllllIlIIlIllIIIlllIlI, final Object lllllllllllllllIlIIlIllIIIllIlII) {
        if (lllllllllllllllIlIIlIllIIIlllIlI == null) {
            throw new NullPointerException("The given array is NULL");
        }
        final int lllllllllllllllIlIIlIllIIIlllIII = lllllllllllllllIlIIlIllIIIlllIlI.length;
        final int lllllllllllllllIlIIlIllIIIllIlll = lllllllllllllllIlIIlIllIIIlllIII + 1;
        final Object[] lllllllllllllllIlIIlIllIIIllIllI = (Object[])Array.newInstance(lllllllllllllllIlIIlIllIIIlllIlI.getClass().getComponentType(), lllllllllllllllIlIIlIllIIIllIlll);
        System.arraycopy(lllllllllllllllIlIIlIllIIIlllIlI, 0, lllllllllllllllIlIIlIllIIIllIllI, 0, lllllllllllllllIlIIlIllIIIlllIII);
        lllllllllllllllIlIIlIllIIIllIllI[lllllllllllllllIlIIlIllIIIlllIII] = lllllllllllllllIlIIlIllIIIllIlII;
        return lllllllllllllllIlIIlIllIIIllIllI;
    }
    
    public static int getBitsJre() {
        final String[] lllllllllllllllIlIIlIlIlllllIIII = { "sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch" };
        for (int lllllllllllllllIlIIlIlIllllIllll = 0; lllllllllllllllIlIIlIlIllllIllll < lllllllllllllllIlIIlIlIlllllIIII.length; ++lllllllllllllllIlIIlIlIllllIllll) {
            final String lllllllllllllllIlIIlIlIllllIlllI = lllllllllllllllIlIIlIlIlllllIIII[lllllllllllllllIlIIlIlIllllIllll];
            final String lllllllllllllllIlIIlIlIllllIllIl = System.getProperty(lllllllllllllllIlIIlIlIllllIlllI);
            if (lllllllllllllllIlIIlIlIllllIllIl != null && lllllllllllllllIlIIlIlIllllIllIl.contains("64")) {
                return 64;
            }
        }
        return 32;
    }
    
    public static int getMipmapLevels() {
        return Config.gameSettings.mipmapLevels;
    }
    
    public static void checkDisplayMode() {
        try {
            if (Config.minecraft.isFullScreen()) {
                if (Config.fullscreenModeChecked) {
                    return;
                }
                Config.fullscreenModeChecked = true;
                Config.desktopModeChecked = false;
                final DisplayMode lllllllllllllllIlIIlIllIIlIIllII = Display.getDisplayMode();
                final Dimension lllllllllllllllIlIIlIllIIlIIlIll = getFullscreenDimension();
                if (lllllllllllllllIlIIlIllIIlIIlIll == null) {
                    return;
                }
                if (lllllllllllllllIlIIlIllIIlIIllII.getWidth() == lllllllllllllllIlIIlIllIIlIIlIll.width && lllllllllllllllIlIIlIllIIlIIllII.getHeight() == lllllllllllllllIlIIlIllIIlIIlIll.height) {
                    return;
                }
                final DisplayMode lllllllllllllllIlIIlIllIIlIIlIlI = getDisplayMode(lllllllllllllllIlIIlIllIIlIIlIll);
                if (lllllllllllllllIlIIlIllIIlIIlIlI == null) {
                    return;
                }
                Display.setDisplayMode(lllllllllllllllIlIIlIllIIlIIlIlI);
                Config.minecraft.displayWidth = Display.getDisplayMode().getWidth();
                Config.minecraft.displayHeight = Display.getDisplayMode().getHeight();
                if (Config.minecraft.displayWidth <= 0) {
                    Config.minecraft.displayWidth = 1;
                }
                if (Config.minecraft.displayHeight <= 0) {
                    Config.minecraft.displayHeight = 1;
                }
                if (Config.minecraft.currentScreen != null) {
                    final ScaledResolution lllllllllllllllIlIIlIllIIlIIlIIl = new ScaledResolution(Config.minecraft);
                    final int lllllllllllllllIlIIlIllIIlIIlIII = lllllllllllllllIlIIlIllIIlIIlIIl.getScaledWidth();
                    final int lllllllllllllllIlIIlIllIIlIIIlll = lllllllllllllllIlIIlIllIIlIIlIIl.getScaledHeight();
                    Config.minecraft.currentScreen.setWorldAndResolution(Config.minecraft, lllllllllllllllIlIIlIllIIlIIlIII, lllllllllllllllIlIIlIllIIlIIIlll);
                }
                Config.minecraft.loadingScreen = new LoadingScreenRenderer(Config.minecraft);
                updateFramebufferSize();
                Display.setFullscreen(true);
                Config.minecraft.gameSettings.updateVSync();
                GlStateManager.enableTexture2D();
            }
            else {
                if (Config.desktopModeChecked) {
                    return;
                }
                Config.desktopModeChecked = true;
                Config.fullscreenModeChecked = false;
                Config.minecraft.gameSettings.updateVSync();
                Display.update();
                GlStateManager.enableTexture2D();
                Display.setResizable(false);
                Display.setResizable(true);
            }
        }
        catch (Exception lllllllllllllllIlIIlIllIIlIIIllI) {
            lllllllllllllllIlIIlIllIIlIIIllI.printStackTrace();
            Config.gameSettings.ofFullscreenMode = "Default";
            Config.gameSettings.saveOfOptions();
        }
    }
    
    public static float parseFloat(String lllllllllllllllIlIIlIlllllIIIIll, final float lllllllllllllllIlIIlIllllIllllll) {
        try {
            if (lllllllllllllllIlIIlIlllllIIIIll == null) {
                return lllllllllllllllIlIIlIllllIllllll;
            }
            lllllllllllllllIlIIlIlllllIIIIll = lllllllllllllllIlIIlIlllllIIIIll.trim();
            return Float.parseFloat(lllllllllllllllIlIIlIlllllIIIIll);
        }
        catch (NumberFormatException lllllllllllllllIlIIlIlllllIIIIIl) {
            return lllllllllllllllIlIIlIllllIllllll;
        }
    }
    
    public static boolean isTimeDayOnly() {
        return Config.gameSettings.ofTime == 1;
    }
    
    public static GlVersion getGlslVersion() {
        if (Config.glslVersion == null) {
            final String lllllllllllllllIlIIllIIIllIlIlIl = GL11.glGetString(35724);
            Config.glslVersion = parseGlVersion(lllllllllllllllIlIIllIIIllIlIlIl, null);
            if (Config.glslVersion == null) {
                Config.glslVersion = new GlVersion(1, 10);
            }
        }
        return Config.glslVersion;
    }
    
    public static DynamicTexture getMojangLogoTexture(final DynamicTexture lllllllllllllllIlIIlIlIllIlllIIl) {
        try {
            final ResourceLocation lllllllllllllllIlIIlIlIllIlllllI = new ResourceLocation("textures/gui/title/mojang.png");
            final InputStream lllllllllllllllIlIIlIlIllIllllIl = getResourceStream(lllllllllllllllIlIIlIlIllIlllllI);
            if (lllllllllllllllIlIIlIlIllIllllIl == null) {
                return lllllllllllllllIlIIlIlIllIlllIIl;
            }
            final BufferedImage lllllllllllllllIlIIlIlIllIllllII = ImageIO.read(lllllllllllllllIlIIlIlIllIllllIl);
            if (lllllllllllllllIlIIlIlIllIllllII == null) {
                return lllllllllllllllIlIIlIlIllIlllIIl;
            }
            final DynamicTexture lllllllllllllllIlIIlIlIllIlllIll = new DynamicTexture(lllllllllllllllIlIIlIlIllIllllII);
            return lllllllllllllllIlIIlIlIllIlllIll;
        }
        catch (Exception lllllllllllllllIlIIlIlIllIlllIlI) {
            warn(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIlIlIllIlllIlI.getClass().getName())).append(": ").append(lllllllllllllllIlIIlIlIllIlllIlI.getMessage())));
            return lllllllllllllllIlIIlIlIllIlllIIl;
        }
    }
    
    public static int[] addIntToArray(final int[] lllllllllllllllIlIIlIlIlllIllIII, final int lllllllllllllllIlIIlIlIlllIllIIl) {
        return addIntsToArray(lllllllllllllllIlIIlIlIlllIllIII, new int[] { lllllllllllllllIlIIlIlIlllIllIIl });
    }
    
    private static DisplayMode[] getDisplayModes(final DisplayMode[] lllllllllllllllIlIIlIlllIlllIlII, final Dimension lllllllllllllllIlIIlIlllIllIllIl) {
        final List lllllllllllllllIlIIlIlllIlllIIlI = new ArrayList();
        for (int lllllllllllllllIlIIlIlllIlllIIIl = 0; lllllllllllllllIlIIlIlllIlllIIIl < lllllllllllllllIlIIlIlllIlllIlII.length; ++lllllllllllllllIlIIlIlllIlllIIIl) {
            final DisplayMode lllllllllllllllIlIIlIlllIlllIIII = lllllllllllllllIlIIlIlllIlllIlII[lllllllllllllllIlIIlIlllIlllIIIl];
            if (lllllllllllllllIlIIlIlllIlllIIII.getWidth() == lllllllllllllllIlIIlIlllIllIllIl.getWidth() && lllllllllllllllIlIIlIlllIlllIIII.getHeight() == lllllllllllllllIlIIlIlllIllIllIl.getHeight()) {
                lllllllllllllllIlIIlIlllIlllIIlI.add(lllllllllllllllIlIIlIlllIlllIIII);
            }
        }
        final DisplayMode[] lllllllllllllllIlIIlIlllIllIllll = lllllllllllllllIlIIlIlllIlllIIlI.toArray(new DisplayMode[lllllllllllllllIlIIlIlllIlllIIlI.size()]);
        return lllllllllllllllIlIIlIlllIllIllll;
    }
    
    public static void showGuiMessage(final String lllllllllllllllIlIIlIlIlllIlllll, final String lllllllllllllllIlIIlIlIllllIIIIl) {
        final GuiMessage lllllllllllllllIlIIlIlIllllIIIII = new GuiMessage(Config.minecraft.currentScreen, lllllllllllllllIlIIlIlIlllIlllll, lllllllllllllllIlIIlIlIllllIIIIl);
        Config.minecraft.displayGuiScreen(lllllllllllllllIlIIlIlIllllIIIII);
    }
    
    public static DisplayMode getDesktopDisplayMode() {
        return Config.desktopDisplayMode;
    }
    
    public static boolean isRainOff() {
        return Config.gameSettings.ofRain == 3;
    }
    
    public static DefaultResourcePack getDefaultResourcePack() {
        if (Config.defaultResourcePackLazy == null) {
            final Minecraft lllllllllllllllIlIIllIIIIIIIIIll = Minecraft.getMinecraft();
            Config.defaultResourcePackLazy = (DefaultResourcePack)Reflector.getFieldValue(lllllllllllllllIlIIllIIIIIIIIIll, Reflector.Minecraft_defaultResourcePack);
            if (Config.defaultResourcePackLazy == null) {
                final ResourcePackRepository lllllllllllllllIlIIllIIIIIIIIIlI = lllllllllllllllIlIIllIIIIIIIIIll.getResourcePackRepository();
                if (lllllllllllllllIlIIllIIIIIIIIIlI != null) {
                    Config.defaultResourcePackLazy = (DefaultResourcePack)lllllllllllllllIlIIllIIIIIIIIIlI.rprDefaultResourcePack;
                }
            }
        }
        return Config.defaultResourcePackLazy;
    }
    
    public static boolean isMinecraftThread() {
        return Thread.currentThread() == Config.minecraftThread;
    }
    
    public static void updateTexturePackClouds() {
        Config.texturePackClouds = 0;
        final IResourceManager lllllllllllllllIlIIllIIIIllllIll = getResourceManager();
        if (lllllllllllllllIlIIllIIIIllllIll != null) {
            try {
                final InputStream lllllllllllllllIlIIllIIIIllllIlI = lllllllllllllllIlIIllIIIIllllIll.getResource(new ResourceLocation("mcpatcher/color.properties")).getInputStream();
                if (lllllllllllllllIlIIllIIIIllllIlI == null) {
                    return;
                }
                final Properties lllllllllllllllIlIIllIIIIllllIIl = new Properties();
                lllllllllllllllIlIIllIIIIllllIIl.load(lllllllllllllllIlIIllIIIIllllIlI);
                lllllllllllllllIlIIllIIIIllllIlI.close();
                String lllllllllllllllIlIIllIIIIllllIII = lllllllllllllllIlIIllIIIIllllIIl.getProperty("clouds");
                if (lllllllllllllllIlIIllIIIIllllIII == null) {
                    return;
                }
                dbg(String.valueOf(new StringBuilder("Texture pack clouds: ").append(lllllllllllllllIlIIllIIIIllllIII)));
                lllllllllllllllIlIIllIIIIllllIII = lllllllllllllllIlIIllIIIIllllIII.toLowerCase();
                if (lllllllllllllllIlIIllIIIIllllIII.equals("fast")) {
                    Config.texturePackClouds = 1;
                }
                if (lllllllllllllllIlIIllIIIIllllIII.equals("fancy")) {
                    Config.texturePackClouds = 2;
                }
                if (lllllllllllllllIlIIllIIIIllllIII.equals("off")) {
                    Config.texturePackClouds = 3;
                }
            }
            catch (Exception ex) {}
        }
    }
    
    public static String[] readLines(final InputStream lllllllllllllllIlIIlIlllIIlIllIl) throws IOException {
        final List lllllllllllllllIlIIlIlllIIlIllII = new ArrayList();
        final InputStreamReader lllllllllllllllIlIIlIlllIIlIlIll = new InputStreamReader(lllllllllllllllIlIIlIlllIIlIllIl, "ASCII");
        final BufferedReader lllllllllllllllIlIIlIlllIIlIlIlI = new BufferedReader(lllllllllllllllIlIIlIlllIIlIlIll);
        while (true) {
            final String lllllllllllllllIlIIlIlllIIlIlIIl = lllllllllllllllIlIIlIlllIIlIlIlI.readLine();
            if (lllllllllllllllIlIIlIlllIIlIlIIl == null) {
                break;
            }
            lllllllllllllllIlIIlIlllIIlIllII.add(lllllllllllllllIlIIlIlllIIlIlIIl);
        }
        final String[] lllllllllllllllIlIIlIlllIIlIlIII = lllllllllllllllIlIIlIlllIIlIllII.toArray(new String[lllllllllllllllIlIIlIlllIIlIllII.size()]);
        return lllllllllllllllIlIIlIlllIIlIlIII;
    }
    
    public static void setNotify64BitJava(final boolean lllllllllllllllIlIIlIlIllllIIlll) {
        Config.notify64BitJava = lllllllllllllllIlIIlIlIllllIIlll;
    }
    
    public static void drawFps() {
        final int lllllllllllllllIlIIlIllIIIIIllII = Minecraft.getDebugFPS();
        final String lllllllllllllllIlIIlIllIIIIIlIll = getUpdates(Config.minecraft.debug);
        final int lllllllllllllllIlIIlIllIIIIIlIlI = Config.minecraft.renderGlobal.getCountActiveRenderers();
        final int lllllllllllllllIlIIlIllIIIIIlIIl = Config.minecraft.renderGlobal.getCountEntitiesRendered();
        final int lllllllllllllllIlIIlIllIIIIIlIII = Config.minecraft.renderGlobal.getCountTileEntitiesRendered();
        final String lllllllllllllllIlIIlIllIIIIIIlll = String.valueOf(new StringBuilder().append(lllllllllllllllIlIIlIllIIIIIllII).append(" fps, C: ").append(lllllllllllllllIlIIlIllIIIIIlIlI).append(", E: ").append(lllllllllllllllIlIIlIllIIIIIlIIl).append("+").append(lllllllllllllllIlIIlIllIIIIIlIII).append(", U: ").append(lllllllllllllllIlIIlIllIIIIIlIll));
        Config.minecraft.fontRendererObj.drawString(lllllllllllllllIlIIlIllIIIIIIlll, 2.0, 2.0, -2039584);
    }
    
    public static int getRandom(final BlockPos lllllllllllllllIlIIlIllIlIlllllI, final int lllllllllllllllIlIIlIllIlIllllIl) {
        int lllllllllllllllIlIIlIllIlIllllII = intHash(lllllllllllllllIlIIlIllIlIllllIl + 37);
        lllllllllllllllIlIIlIllIlIllllII = intHash(lllllllllllllllIlIIlIllIlIllllII + lllllllllllllllIlIIlIllIlIlllllI.getX());
        lllllllllllllllIlIIlIllIlIllllII = intHash(lllllllllllllllIlIIlIllIlIllllII + lllllllllllllllIlIIlIllIlIlllllI.getZ());
        lllllllllllllllIlIIlIllIlIllllII = intHash(lllllllllllllllIlIIlIllIlIllllII + lllllllllllllllIlIIlIllIlIlllllI.getY());
        return lllllllllllllllIlIIlIllIlIllllII;
    }
    
    public static boolean isAnisotropicFiltering() {
        return getAnisotropicFilterLevel() > 1;
    }
    
    public static IResourceManager getResourceManager() {
        return Config.minecraft.getResourceManager();
    }
    
    public static boolean isDroppedItemsFancy() {
        if (Config.gameSettings.ofDroppedItems == 0) {
            return Config.gameSettings.fancyGraphics;
        }
        return Config.gameSettings.ofDroppedItems == 2;
    }
    
    public static boolean isBetterGrassFancy() {
        return Config.gameSettings.ofBetterGrass == 2;
    }
    
    public static InputStream getResourceStream(final IResourceManager lllllllllllllllIlIIllIIIIIllIlII, final ResourceLocation lllllllllllllllIlIIllIIIIIllIIll) throws IOException {
        final IResource lllllllllllllllIlIIllIIIIIllIlIl = lllllllllllllllIlIIllIIIIIllIlII.getResource(lllllllllllllllIlIIllIIIIIllIIll);
        return (lllllllllllllllIlIIllIIIIIllIlIl == null) ? null : lllllllllllllllIlIIllIIIIIllIlIl.getInputStream();
    }
    
    public static boolean isTreesFancy() {
        if (Config.gameSettings.ofTrees == 0) {
            return Config.gameSettings.fancyGraphics;
        }
        return Config.gameSettings.ofTrees != 1;
    }
    
    public static boolean isAnimatedExplosion() {
        return Config.gameSettings.ofAnimatedExplosion;
    }
    
    public static boolean isFancyFogAvailable() {
        return Config.fancyFogAvailable;
    }
    
    public static String arrayToString(final int[] lllllllllllllllIlIIllIIIIlIIIlIl) {
        if (lllllllllllllllIlIIllIIIIlIIIlIl == null) {
            return "";
        }
        final StringBuffer lllllllllllllllIlIIllIIIIlIIIlII = new StringBuffer(lllllllllllllllIlIIllIIIIlIIIlIl.length * 5);
        for (int lllllllllllllllIlIIllIIIIlIIIIll = 0; lllllllllllllllIlIIllIIIIlIIIIll < lllllllllllllllIlIIllIIIIlIIIlIl.length; ++lllllllllllllllIlIIllIIIIlIIIIll) {
            final int lllllllllllllllIlIIllIIIIlIIIIlI = lllllllllllllllIlIIllIIIIlIIIlIl[lllllllllllllllIlIIllIIIIlIIIIll];
            if (lllllllllllllllIlIIllIIIIlIIIIll > 0) {
                lllllllllllllllIlIIllIIIIlIIIlII.append(", ");
            }
            lllllllllllllllIlIIllIIIIlIIIlII.append(String.valueOf(lllllllllllllllIlIIllIIIIlIIIIlI));
        }
        return lllllllllllllllIlIIllIIIIlIIIlII.toString();
    }
    
    public static boolean isSunTexture() {
        return isSunMoonEnabled() && (!isShaders() || Shaders.isSun());
    }
    
    public static boolean isStarsEnabled() {
        return Config.gameSettings.ofStars;
    }
    
    public static boolean isWeatherEnabled() {
        return Config.gameSettings.ofWeather;
    }
    
    public static double limit(final double lllllllllllllllIlIIllIIIIlIllIll, final double lllllllllllllllIlIIllIIIIlIlllIl, final double lllllllllllllllIlIIllIIIIlIllIIl) {
        if (lllllllllllllllIlIIllIIIIlIllIll < lllllllllllllllIlIIllIIIIlIlllIl) {
            return lllllllllllllllIlIIllIIIIlIlllIl;
        }
        return (lllllllllllllllIlIIllIIIIlIllIll > lllllllllllllllIlIIllIIIIlIllIIl) ? lllllllllllllllIlIIllIIIIlIllIIl : lllllllllllllllIlIIllIIIIlIllIll;
    }
    
    public static boolean isCullFacesLeaves() {
        if (Config.gameSettings.ofTrees == 0) {
            return !Config.gameSettings.fancyGraphics;
        }
        return Config.gameSettings.ofTrees == 4;
    }
    
    public static boolean isLazyChunkLoading() {
        return isSingleProcessor() && Config.gameSettings.ofLazyChunkLoading;
    }
    
    public static boolean isMipmaps() {
        return Config.gameSettings.mipmapLevels > 0;
    }
    
    public static void updateThreadPriorities() {
        updateAvailableProcessors();
        final int lllllllllllllllIlIIllIIIlIlIlIIl = 8;
        if (isSingleProcessor()) {
            if (isSmoothWorld()) {
                Config.minecraftThread.setPriority(10);
                setThreadPriority("Server thread", 1);
            }
            else {
                Config.minecraftThread.setPriority(5);
                setThreadPriority("Server thread", 5);
            }
        }
        else {
            Config.minecraftThread.setPriority(10);
            setThreadPriority("Server thread", 5);
        }
    }
    
    public static int getMinecraftVersionInt() {
        if (Config.minecraftVersionInt < 0) {
            final String[] lllllllllllllllIlIIllIIIlllIIIll = tokenize("1.12.2", ".");
            int lllllllllllllllIlIIllIIIlllIIIlI = 0;
            if (lllllllllllllllIlIIllIIIlllIIIll.length > 0) {
                lllllllllllllllIlIIllIIIlllIIIlI += 10000 * parseInt(lllllllllllllllIlIIllIIIlllIIIll[0], 0);
            }
            if (lllllllllllllllIlIIllIIIlllIIIll.length > 1) {
                lllllllllllllllIlIIllIIIlllIIIlI += 100 * parseInt(lllllllllllllllIlIIllIIIlllIIIll[1], 0);
            }
            if (lllllllllllllllIlIIllIIIlllIIIll.length > 2) {
                lllllllllllllllIlIIllIIIlllIIIlI += 1 * parseInt(lllllllllllllllIlIIllIIIlllIIIll[2], 0);
            }
            Config.minecraftVersionInt = lllllllllllllllIlIIllIIIlllIIIlI;
        }
        return Config.minecraftVersionInt;
    }
    
    private static void startVersionCheckThread() {
        final VersionCheckThread lllllllllllllllIlIIllIIIlIIlIIII = new VersionCheckThread();
        lllllllllllllllIlIIllIIIlIIlIIII.start();
    }
    
    public static String[] getDisplayModeNames() {
        final DisplayMode[] lllllllllllllllIlIIlIlllIlIllIII = getDisplayModes();
        final String[] lllllllllllllllIlIIlIlllIlIlIlll = new String[lllllllllllllllIlIIlIlllIlIllIII.length];
        for (int lllllllllllllllIlIIlIlllIlIlIllI = 0; lllllllllllllllIlIIlIlllIlIlIllI < lllllllllllllllIlIIlIlllIlIllIII.length; ++lllllllllllllllIlIIlIlllIlIlIllI) {
            final DisplayMode lllllllllllllllIlIIlIlllIlIlIlIl = lllllllllllllllIlIIlIlllIlIllIII[lllllllllllllllIlIIlIlllIlIlIllI];
            final String lllllllllllllllIlIIlIlllIlIlIlII = String.valueOf(new StringBuilder().append(lllllllllllllllIlIIlIlllIlIlIlIl.getWidth()).append("x").append(lllllllllllllllIlIIlIlllIlIlIlIl.getHeight()));
            lllllllllllllllIlIIlIlllIlIlIlll[lllllllllllllllIlIIlIlllIlIlIllI] = lllllllllllllllIlIIlIlllIlIlIlII;
        }
        return lllllllllllllllIlIIlIlllIlIlIlll;
    }
    
    public static boolean isConnectedModels() {
        return false;
    }
    
    public static boolean isAnimatedFire() {
        return Config.gameSettings.ofAnimatedFire;
    }
    
    public static TextureMap getTextureMap() {
        return getMinecraft().getTextureMapBlocks();
    }
    
    public static DisplayMode[] getDisplayModes() {
        if (Config.displayModes == null) {
            try {
                final DisplayMode[] lllllllllllllllIlIIlIllllIIlllIl = Display.getAvailableDisplayModes();
                final Set<Dimension> lllllllllllllllIlIIlIllllIIlllII = getDisplayModeDimensions(lllllllllllllllIlIIlIllllIIlllIl);
                final List lllllllllllllllIlIIlIllllIIllIll = new ArrayList();
                for (final Dimension lllllllllllllllIlIIlIllllIIllIlI : lllllllllllllllIlIIlIllllIIlllII) {
                    final DisplayMode[] lllllllllllllllIlIIlIllllIIllIIl = getDisplayModes(lllllllllllllllIlIIlIllllIIlllIl, lllllllllllllllIlIIlIllllIIllIlI);
                    final DisplayMode lllllllllllllllIlIIlIllllIIllIII = getDisplayMode(lllllllllllllllIlIIlIllllIIllIIl, Config.desktopDisplayMode);
                    if (lllllllllllllllIlIIlIllllIIllIII != null) {
                        lllllllllllllllIlIIlIllllIIllIll.add(lllllllllllllllIlIIlIllllIIllIII);
                    }
                }
                final DisplayMode[] lllllllllllllllIlIIlIllllIIlIlll = lllllllllllllllIlIIlIllllIIllIll.toArray(new DisplayMode[lllllllllllllllIlIIlIllllIIllIll.size()]);
                Arrays.sort(lllllllllllllllIlIIlIllllIIlIlll, new DisplayModeComparator());
                return lllllllllllllllIlIIlIllllIIlIlll;
            }
            catch (Exception lllllllllllllllIlIIlIllllIIlIllI) {
                lllllllllllllllIlIIlIllllIIlIllI.printStackTrace();
                Config.displayModes = new DisplayMode[] { Config.desktopDisplayMode };
            }
        }
        return Config.displayModes;
    }
    
    public static ModelManager getModelManager() {
        return Config.minecraft.getRenderItem().modelManager;
    }
    
    private static String getBuild() {
        try {
            final InputStream lllllllllllllllIlIIllIIIlllIlIlI = Config.class.getResourceAsStream("/buildof.txt");
            if (lllllllllllllllIlIIllIIIlllIlIlI == null) {
                return null;
            }
            final String lllllllllllllllIlIIllIIIlllIlIIl = readLines(lllllllllllllllIlIIllIIIlllIlIlI)[0];
            return lllllllllllllllIlIIllIIIlllIlIIl;
        }
        catch (Exception lllllllllllllllIlIIllIIIlllIlIII) {
            warn(String.valueOf(new StringBuilder().append(lllllllllllllllIlIIllIIIlllIlIII.getClass().getName()).append(": ").append(lllllllllllllllIlIIllIIIlllIlIII.getMessage())));
            return null;
        }
    }
    
    public static void dbg(final String lllllllllllllllIlIIllIIIlIIIlIIl) {
        Config.LOGGER.info(String.valueOf(new StringBuilder("[OptiFine] ").append(lllllllllllllllIlIIllIIIlIIIlIIl)));
    }
    
    public static boolean hasResource(final ResourceLocation lllllllllllllllIlIIllIIIIIlIllII) {
        final IResourcePack lllllllllllllllIlIIllIIIIIlIlIll = getDefiningResourcePack(lllllllllllllllIlIIllIIIIIlIllII);
        return lllllllllllllllIlIIllIIIIIlIlIll != null;
    }
    
    public static void initGameSettings(final GameSettings lllllllllllllllIlIIllIIIllllIIIl) {
        if (Config.gameSettings == null) {
            Config.gameSettings = lllllllllllllllIlIIllIIIllllIIIl;
            Config.desktopDisplayMode = Display.getDesktopDisplayMode();
            updateAvailableProcessors();
            ReflectorForge.putLaunchBlackboard("optifine.ForgeSplashCompatible", Boolean.TRUE);
        }
    }
    
    public static boolean isFastRender() {
        return Config.gameSettings.ofFastRender;
    }
    
    public static boolean isCustomEntityModels() {
        return Config.gameSettings.ofCustomEntityModels;
    }
    
    public static void checkGlError(final String lllllllllllllllIlIIlIlllIIllllII) {
        final int lllllllllllllllIlIIlIlllIIlllllI = GL11.glGetError();
        if (lllllllllllllllIlIIlIlllIIlllllI != 0) {
            final String lllllllllllllllIlIIlIlllIIllllIl = GLU.gluErrorString(lllllllllllllllIlIIlIlllIIlllllI);
            error(String.valueOf(new StringBuilder("OpenGlError: ").append(lllllllllllllllIlIIlIlllIIlllllI).append(" (").append(lllllllllllllllIlIIlIlllIIllllIl).append("), at: ").append(lllllllllllllllIlIIlIlllIIllllII)));
        }
    }
    
    public static boolean isOcclusionAvailable() {
        return Config.occlusionAvailable;
    }
    
    public static void sleep(final long lllllllllllllllIlIIlIllllllIIIlI) {
        try {
            Thread.sleep(lllllllllllllllIlIIlIllllllIIIlI);
        }
        catch (InterruptedException lllllllllllllllIlIIlIllllllIIIIl) {
            lllllllllllllllIlIIlIllllllIIIIl.printStackTrace();
        }
    }
    
    public static String getVersion() {
        return "OptiFine_1.12.2_HD_U_C6";
    }
    
    public static DisplayMode getDisplayMode(final Dimension lllllllllllllllIlIIlIlllIlIIIllI) throws LWJGLException {
        final DisplayMode[] lllllllllllllllIlIIlIlllIlIIlIIl = getDisplayModes();
        for (int lllllllllllllllIlIIlIlllIlIIlIII = 0; lllllllllllllllIlIIlIlllIlIIlIII < lllllllllllllllIlIIlIlllIlIIlIIl.length; ++lllllllllllllllIlIIlIlllIlIIlIII) {
            final DisplayMode lllllllllllllllIlIIlIlllIlIIIlll = lllllllllllllllIlIIlIlllIlIIlIIl[lllllllllllllllIlIIlIlllIlIIlIII];
            if (lllllllllllllllIlIIlIlllIlIIIlll.getWidth() == lllllllllllllllIlIIlIlllIlIIIllI.width && lllllllllllllllIlIIlIlllIlIIIlll.getHeight() == lllllllllllllllIlIIlIlllIlIIIllI.height) {
                return lllllllllllllllIlIIlIlllIlIIIlll;
            }
        }
        return Config.desktopDisplayMode;
    }
    
    public static boolean isCustomFonts() {
        return Config.gameSettings.ofCustomFonts;
    }
    
    public static boolean isRainSplash() {
        return Config.gameSettings.ofRainSplash;
    }
    
    public static boolean parseBoolean(String lllllllllllllllIlIIlIllllIlllIlI, final boolean lllllllllllllllIlIIlIllllIlllIIl) {
        try {
            if (lllllllllllllllIlIIlIllllIlllIlI == null) {
                return lllllllllllllllIlIIlIllllIlllIIl;
            }
            lllllllllllllllIlIIlIllllIlllIlI = lllllllllllllllIlIIlIllllIlllIlI.trim();
            return Boolean.parseBoolean(lllllllllllllllIlIIlIllllIlllIlI);
        }
        catch (NumberFormatException lllllllllllllllIlIIlIllllIlllIII) {
            return lllllllllllllllIlIIlIllllIlllIIl;
        }
    }
    
    public static GlVersion parseGlVersion(final String lllllllllllllllIlIIllIIIllIIIIlI, final GlVersion lllllllllllllllIlIIllIIIllIIIIIl) {
        try {
            if (lllllllllllllllIlIIllIIIllIIIIlI == null) {
                return lllllllllllllllIlIIllIIIllIIIIIl;
            }
            final Pattern lllllllllllllllIlIIllIIIllIIlIIl = Pattern.compile("([0-9]+)\\.([0-9]+)(\\.([0-9]+))?(.+)?");
            final Matcher lllllllllllllllIlIIllIIIllIIlIII = lllllllllllllllIlIIllIIIllIIlIIl.matcher(lllllllllllllllIlIIllIIIllIIIIlI);
            if (!lllllllllllllllIlIIllIIIllIIlIII.matches()) {
                return lllllllllllllllIlIIllIIIllIIIIIl;
            }
            final int lllllllllllllllIlIIllIIIllIIIlll = Integer.parseInt(lllllllllllllllIlIIllIIIllIIlIII.group(1));
            final int lllllllllllllllIlIIllIIIllIIIllI = Integer.parseInt(lllllllllllllllIlIIllIIIllIIlIII.group(2));
            final int lllllllllllllllIlIIllIIIllIIIlIl = (lllllllllllllllIlIIllIIIllIIlIII.group(4) != null) ? Integer.parseInt(lllllllllllllllIlIIllIIIllIIlIII.group(4)) : 0;
            final String lllllllllllllllIlIIllIIIllIIIlII = lllllllllllllllIlIIllIIIllIIlIII.group(5);
            return new GlVersion(lllllllllllllllIlIIllIIIllIIIlll, lllllllllllllllIlIIllIIIllIIIllI, lllllllllllllllIlIIllIIIllIIIlIl, lllllllllllllllIlIIllIIIllIIIlII);
        }
        catch (Exception lllllllllllllllIlIIllIIIllIIIIll) {
            lllllllllllllllIlIIllIIIllIIIIll.printStackTrace();
            return lllllllllllllllIlIIllIIIllIIIIIl;
        }
    }
    
    public static boolean isTimeNightOnly() {
        return Config.gameSettings.ofTime == 2;
    }
    
    public static boolean isTimeDefault() {
        return Config.gameSettings.ofTime == 0;
    }
    
    private static void checkOpenGlCaps() {
        log("");
        log(getVersion());
        log(String.valueOf(new StringBuilder("Build: ").append(getBuild())));
        log(String.valueOf(new StringBuilder("OS: ").append(System.getProperty("os.name")).append(" (").append(System.getProperty("os.arch")).append(") version ").append(System.getProperty("os.version"))));
        log(String.valueOf(new StringBuilder("Java: ").append(System.getProperty("java.version")).append(", ").append(System.getProperty("java.vendor"))));
        log(String.valueOf(new StringBuilder("VM: ").append(System.getProperty("java.vm.name")).append(" (").append(System.getProperty("java.vm.info")).append("), ").append(System.getProperty("java.vm.vendor"))));
        log(String.valueOf(new StringBuilder("LWJGL: ").append(Sys.getVersion())));
        Config.openGlVersion = GL11.glGetString(7938);
        Config.openGlRenderer = GL11.glGetString(7937);
        Config.openGlVendor = GL11.glGetString(7936);
        log(String.valueOf(new StringBuilder("OpenGL: ").append(Config.openGlRenderer).append(", version ").append(Config.openGlVersion).append(", ").append(Config.openGlVendor)));
        log(String.valueOf(new StringBuilder("OpenGL Version: ").append(getOpenGlVersionString())));
        if (!GLContext.getCapabilities().OpenGL12) {
            log("OpenGL Mipmap levels: Not available (GL12.GL_TEXTURE_MAX_LEVEL)");
        }
        if (!(Config.fancyFogAvailable = GLContext.getCapabilities().GL_NV_fog_distance)) {
            log("OpenGL Fancy fog: Not available (GL_NV_fog_distance)");
        }
        if (!(Config.occlusionAvailable = GLContext.getCapabilities().GL_ARB_occlusion_query)) {
            log("OpenGL Occlussion culling: Not available (GL_ARB_occlusion_query)");
        }
        final int lllllllllllllllIlIIllIIIlllIlllI = TextureUtils.getGLMaximumTextureSize();
        dbg(String.valueOf(new StringBuilder("Maximum texture size: ").append(lllllllllllllllIlIIllIIIlllIlllI).append("x").append(lllllllllllllllIlIIllIIIlllIlllI)));
    }
    
    public static boolean isWaterParticles() {
        return Config.gameSettings.ofWaterParticles;
    }
    
    public static String getOpenGlVersionString() {
        final GlVersion lllllllllllllllIlIIllIIIllIlllIl = getGlVersion();
        final String lllllllllllllllIlIIllIIIllIlllII = String.valueOf(new StringBuilder().append(lllllllllllllllIlIIllIIIllIlllIl.getMajor()).append(".").append(lllllllllllllllIlIIllIIIllIlllIl.getMinor()).append(".").append(lllllllllllllllIlIIllIIIllIlllIl.getRelease()));
        return lllllllllllllllIlIIllIIIllIlllII;
    }
    
    private static DisplayMode getDisplayMode(final DisplayMode[] lllllllllllllllIlIIlIlllIllIIlIl, final DisplayMode lllllllllllllllIlIIlIlllIllIIIII) {
        if (lllllllllllllllIlIIlIlllIllIIIII != null) {
            for (int lllllllllllllllIlIIlIlllIllIIIll = 0; lllllllllllllllIlIIlIlllIllIIIll < lllllllllllllllIlIIlIlllIllIIlIl.length; ++lllllllllllllllIlIIlIlllIllIIIll) {
                final DisplayMode lllllllllllllllIlIIlIlllIllIIIlI = lllllllllllllllIlIIlIlllIllIIlIl[lllllllllllllllIlIIlIlllIllIIIll];
                if (lllllllllllllllIlIIlIlllIllIIIlI.getBitsPerPixel() == lllllllllllllllIlIIlIlllIllIIIII.getBitsPerPixel() && lllllllllllllllIlIIlIlllIllIIIlI.getFrequency() == lllllllllllllllIlIIlIlllIllIIIII.getFrequency()) {
                    return lllllllllllllllIlIIlIlllIllIIIlI;
                }
            }
        }
        if (lllllllllllllllIlIIlIlllIllIIlIl.length <= 0) {
            return null;
        }
        Arrays.sort(lllllllllllllllIlIIlIlllIllIIlIl, new DisplayModeComparator());
        return lllllllllllllllIlIIlIlllIllIIlIl[lllllllllllllllIlIIlIlllIllIIlIl.length - 1];
    }
    
    public static void log(final String lllllllllllllllIlIIllIIIlIIIIIII) {
        dbg(lllllllllllllllIlIIllIIIlIIIIIII);
    }
    
    public static boolean isSameOne(final Object lllllllllllllllIlIIlIllIlIIIIIlI, final Object[] lllllllllllllllIlIIlIllIlIIIIlIl) {
        if (lllllllllllllllIlIIlIllIlIIIIlIl == null) {
            return false;
        }
        for (int lllllllllllllllIlIIlIllIlIIIIlII = 0; lllllllllllllllIlIIlIllIlIIIIlII < lllllllllllllllIlIIlIllIlIIIIlIl.length; ++lllllllllllllllIlIIlIllIlIIIIlII) {
            final Object lllllllllllllllIlIIlIllIlIIIIIll = lllllllllllllllIlIIlIllIlIIIIlIl[lllllllllllllllIlIIlIllIlIIIIlII];
            if (lllllllllllllllIlIIlIllIlIIIIIlI == lllllllllllllllIlIIlIllIlIIIIIll) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isCustomSky() {
        return Config.gameSettings.ofCustomSky;
    }
    
    private static ByteBuffer readIconImage(final InputStream lllllllllllllllIlIIlIllIIlIlllll) throws IOException {
        final BufferedImage lllllllllllllllIlIIlIllIIlIllllI = ImageIO.read(lllllllllllllllIlIIlIllIIlIlllll);
        final int[] lllllllllllllllIlIIlIllIIlIlllIl = lllllllllllllllIlIIlIllIIlIllllI.getRGB(0, 0, lllllllllllllllIlIIlIllIIlIllllI.getWidth(), lllllllllllllllIlIIlIllIIlIllllI.getHeight(), null, 0, lllllllllllllllIlIIlIllIIlIllllI.getWidth());
        final ByteBuffer lllllllllllllllIlIIlIllIIlIlllII = ByteBuffer.allocate(4 * lllllllllllllllIlIIlIllIIlIlllIl.length);
        final boolean lllllllllllllllIlIIlIllIIlIlIIll;
        final String lllllllllllllllIlIIlIllIIlIlIlII = (String)((int[])(Object)(lllllllllllllllIlIIlIllIIlIlIIll = (boolean)(Object)lllllllllllllllIlIIlIllIIlIlllIl)).length;
        for (long lllllllllllllllIlIIlIllIIlIlIlIl = 0; lllllllllllllllIlIIlIllIIlIlIlIl < lllllllllllllllIlIIlIllIIlIlIlII; ++lllllllllllllllIlIIlIllIIlIlIlIl) {
            final int lllllllllllllllIlIIlIllIIlIllIll = lllllllllllllllIlIIlIllIIlIlIIll[lllllllllllllllIlIIlIllIIlIlIlIl];
            lllllllllllllllIlIIlIllIIlIlllII.putInt(lllllllllllllllIlIIlIllIIlIllIll << 8 | (lllllllllllllllIlIIlIllIIlIllIll >> 24 & 0xFF));
        }
        lllllllllllllllIlIIlIllIIlIlllII.flip();
        return lllllllllllllllIlIIlIllIIlIlllII;
    }
    
    public static String readFile(final File lllllllllllllllIlIIlIlllIIIlllIl) throws IOException {
        final FileInputStream lllllllllllllllIlIIlIlllIIIllllI = new FileInputStream(lllllllllllllllIlIIlIlllIIIlllIl);
        return readInputStream(lllllllllllllllIlIIlIlllIIIllllI, "ASCII");
    }
    
    public static void warn(final String lllllllllllllllIlIIllIIIlIIIIlll) {
        Config.LOGGER.warn(String.valueOf(new StringBuilder("[OptiFine] ").append(lllllllllllllllIlIIllIIIlIIIIlll)));
    }
    
    public static boolean isTreesSmart() {
        return Config.gameSettings.ofTrees == 4;
    }
    
    public static boolean isSwampColors() {
        return Config.gameSettings.ofSwampColors;
    }
    
    public static int getBitsOs() {
        final String lllllllllllllllIlIIlIlIlllllIllI = System.getenv("ProgramFiles(X86)");
        return (lllllllllllllllIlIIlIlIlllllIllI != null) ? 64 : 32;
    }
    
    public static int getAnisotropicFilterLevel() {
        return Config.gameSettings.ofAfLevel;
    }
    
    public static Minecraft getMinecraft() {
        return Config.minecraft;
    }
    
    public static boolean isDrippingWaterLava() {
        return Config.gameSettings.ofDrippingWaterLava;
    }
    
    public static int getUpdatesPerFrame() {
        return Config.gameSettings.ofChunkUpdates;
    }
    
    public static boolean isCustomColors() {
        return Config.gameSettings.ofCustomColors;
    }
    
    public static boolean isClearWater() {
        return Config.gameSettings.ofClearWater;
    }
    
    public static float limitTo1(final float lllllllllllllllIlIIllIIIIlIlIllI) {
        if (lllllllllllllllIlIIllIIIIlIlIllI < 0.0f) {
            return 0.0f;
        }
        return (lllllllllllllllIlIIllIIIIlIlIllI > 1.0f) ? 1.0f : lllllllllllllllIlIIllIIIIlIlIllI;
    }
    
    public static boolean isAntialiasing() {
        return getAntialiasingLevel() > 0;
    }
}
