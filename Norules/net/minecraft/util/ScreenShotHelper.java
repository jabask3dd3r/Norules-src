package net.minecraft.util;

import java.nio.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import org.apache.logging.log4j.*;
import java.text.*;
import java.io.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.client.shader.*;
import net.minecraft.client.renderer.*;
import optifine.*;
import javax.imageio.*;
import net.minecraft.util.text.event.*;
import net.minecraft.util.text.*;
import java.awt.image.*;
import org.lwjgl.*;
import net.minecraft.client.renderer.texture.*;

public class ScreenShotHelper
{
    private static final /* synthetic */ Logger LOGGER;
    private static /* synthetic */ IntBuffer pixelBuffer;
    private static final /* synthetic */ DateFormat DATE_FORMAT;
    private static /* synthetic */ int[] pixelValues;
    
    private static void updateFramebufferSize() {
        final Minecraft lllllllllllllIlIllIllIlIllIIlIlI = Minecraft.getMinecraft();
        lllllllllllllIlIllIllIlIllIIlIlI.getFramebuffer().createBindFramebuffer(lllllllllllllIlIllIllIlIllIIlIlI.displayWidth, lllllllllllllIlIllIllIlIllIIlIlI.displayHeight);
        if (lllllllllllllIlIllIllIlIllIIlIlI.entityRenderer != null) {
            lllllllllllllIlIllIllIlIllIIlIlI.entityRenderer.updateShaderGroupSize(lllllllllllllIlIllIllIlIllIIlIlI.displayWidth, lllllllllllllIlIllIllIlIllIIlIlI.displayHeight);
        }
    }
    
    private static void resize(final int lllllllllllllIlIllIllIlIllIllIII, final int lllllllllllllIlIllIllIlIllIllIll) {
        final Minecraft lllllllllllllIlIllIllIlIllIllIlI = Minecraft.getMinecraft();
        lllllllllllllIlIllIllIlIllIllIlI.displayWidth = Math.max(1, lllllllllllllIlIllIllIlIllIllIII);
        lllllllllllllIlIllIllIlIllIllIlI.displayHeight = Math.max(1, lllllllllllllIlIllIllIlIllIllIll);
        if (lllllllllllllIlIllIllIlIllIllIlI.currentScreen != null) {
            final ScaledResolution lllllllllllllIlIllIllIlIllIllIIl = new ScaledResolution(lllllllllllllIlIllIllIlIllIllIlI);
            lllllllllllllIlIllIllIlIllIllIlI.currentScreen.onResize(lllllllllllllIlIllIllIlIllIllIlI, lllllllllllllIlIllIllIlIllIllIIl.getScaledWidth(), lllllllllllllIlIllIllIlIllIllIIl.getScaledHeight());
        }
        updateFramebufferSize();
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    }
    
    private static File getTimestampedPNGFileForDirectory(final File lllllllllllllIlIllIllIlIlllIlIll) {
        final String lllllllllllllIlIllIllIlIllllIIIl = ScreenShotHelper.DATE_FORMAT.format(new Date()).toString();
        int lllllllllllllIlIllIllIlIlllIllll = 1;
        File lllllllllllllIlIllIllIlIlllIllIl;
        while (true) {
            lllllllllllllIlIllIllIlIlllIllIl = new File(lllllllllllllIlIllIllIlIlllIlIll, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIllIllIlIllllIIIl)).append((lllllllllllllIlIllIllIlIlllIllll == 1) ? "" : String.valueOf(new StringBuilder("_").append(lllllllllllllIlIllIllIlIlllIllll))).append(".png")));
            if (!lllllllllllllIlIllIllIlIlllIllIl.exists()) {
                break;
            }
            ++lllllllllllllIlIllIllIlIlllIllll;
        }
        return lllllllllllllIlIllIllIlIlllIllIl;
    }
    
    public static ITextComponent saveScreenshot(final File lllllllllllllIlIllIllIllIIIllIII, @Nullable final String lllllllllllllIlIllIllIllIIIlIlll, final int lllllllllllllIlIllIllIllIIIlIllI, final int lllllllllllllIlIllIllIllIIIlIlIl, final Framebuffer lllllllllllllIlIllIllIllIIIlIlII) {
        try {
            final File lllllllllllllIlIllIllIllIIlIIllI = new File(lllllllllllllIlIllIllIllIIIllIII, "screenshots");
            lllllllllllllIlIllIllIllIIlIIllI.mkdir();
            final Minecraft lllllllllllllIlIllIllIllIIlIIlIl = Minecraft.getMinecraft();
            final int lllllllllllllIlIllIllIllIIlIIlII = Config.getGameSettings().guiScale;
            final ScaledResolution lllllllllllllIlIllIllIllIIlIIIll = new ScaledResolution(lllllllllllllIlIllIllIllIIlIIlIl);
            final int lllllllllllllIlIllIllIllIIlIIIlI = lllllllllllllIlIllIllIllIIlIIIll.getScaleFactor();
            final int lllllllllllllIlIllIllIllIIlIIIIl = Config.getScreenshotSize();
            final boolean lllllllllllllIlIllIllIllIIlIIIII = OpenGlHelper.isFramebufferEnabled() && lllllllllllllIlIllIllIllIIlIIIIl > 1;
            if (lllllllllllllIlIllIllIllIIlIIIII) {
                Config.getGameSettings().guiScale = lllllllllllllIlIllIllIllIIlIIIlI * lllllllllllllIlIllIllIllIIlIIIIl;
                resize(lllllllllllllIlIllIllIllIIIlIllI * lllllllllllllIlIllIllIllIIlIIIIl, lllllllllllllIlIllIllIllIIIlIlIl * lllllllllllllIlIllIllIllIIlIIIIl);
                GlStateManager.pushMatrix();
                GlStateManager.clear(16640);
                lllllllllllllIlIllIllIllIIlIIlIl.getFramebuffer().bindFramebuffer(true);
                lllllllllllllIlIllIllIllIIlIIlIl.entityRenderer.updateCameraAndRender(lllllllllllllIlIllIllIllIIlIIlIl.getRenderPartialTicks(), System.nanoTime());
            }
            final BufferedImage lllllllllllllIlIllIllIllIIIlllll = createScreenshot(lllllllllllllIlIllIllIllIIIlIllI, lllllllllllllIlIllIllIllIIIlIlIl, lllllllllllllIlIllIllIllIIIlIlII);
            if (lllllllllllllIlIllIllIllIIlIIIII) {
                lllllllllllllIlIllIllIllIIlIIlIl.getFramebuffer().unbindFramebuffer();
                GlStateManager.popMatrix();
                Config.getGameSettings().guiScale = lllllllllllllIlIllIllIllIIlIIlII;
                resize(lllllllllllllIlIllIllIllIIIlIllI, lllllllllllllIlIllIllIllIIIlIlIl);
            }
            File lllllllllllllIlIllIllIllIIIlllIl = null;
            if (lllllllllllllIlIllIllIllIIIlIlll == null) {
                final File lllllllllllllIlIllIllIllIIIllllI = getTimestampedPNGFileForDirectory(lllllllllllllIlIllIllIllIIlIIllI);
            }
            else {
                lllllllllllllIlIllIllIllIIIlllIl = new File(lllllllllllllIlIllIllIllIIlIIllI, lllllllllllllIlIllIllIllIIIlIlll);
            }
            lllllllllllllIlIllIllIllIIIlllIl = lllllllllllllIlIllIllIllIIIlllIl.getCanonicalFile();
            Object lllllllllllllIlIllIllIllIIIlllII = null;
            if (Reflector.ForgeHooksClient_onScreenshot.exists()) {
                lllllllllllllIlIllIllIllIIIlllII = Reflector.call(Reflector.ForgeHooksClient_onScreenshot, lllllllllllllIlIllIllIllIIIlllll, lllllllllllllIlIllIllIllIIIlllIl);
                if (Reflector.callBoolean(lllllllllllllIlIllIllIllIIIlllII, Reflector.Event_isCanceled, new Object[0])) {
                    return (ITextComponent)Reflector.call(lllllllllllllIlIllIllIllIIIlllII, Reflector.ScreenshotEvent_getCancelMessage, new Object[0]);
                }
                lllllllllllllIlIllIllIllIIIlllIl = (File)Reflector.call(lllllllllllllIlIllIllIllIIIlllII, Reflector.ScreenshotEvent_getScreenshotFile, new Object[0]);
            }
            ImageIO.write(lllllllllllllIlIllIllIllIIIlllll, "png", lllllllllllllIlIllIllIllIIIlllIl);
            final ITextComponent lllllllllllllIlIllIllIllIIIllIll = new TextComponentString(lllllllllllllIlIllIllIllIIIlllIl.getName());
            lllllllllllllIlIllIllIllIIIllIll.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, lllllllllllllIlIllIllIllIIIlllIl.getAbsolutePath()));
            lllllllllllllIlIllIllIllIIIllIll.getStyle().setUnderlined(true);
            if (lllllllllllllIlIllIllIllIIIlllII != null) {
                final ITextComponent lllllllllllllIlIllIllIllIIIllIlI = (ITextComponent)Reflector.call(lllllllllllllIlIllIllIllIIIlllII, Reflector.ScreenshotEvent_getResultMessage, new Object[0]);
                if (lllllllllllllIlIllIllIllIIIllIlI != null) {
                    return lllllllllllllIlIllIllIllIIIllIlI;
                }
            }
            return new TextComponentTranslation("screenshot.success", new Object[] { lllllllllllllIlIllIllIllIIIllIll });
        }
        catch (Exception lllllllllllllIlIllIllIllIIIllIIl) {
            ScreenShotHelper.LOGGER.warn("Couldn't save screenshot", (Throwable)lllllllllllllIlIllIllIllIIIllIIl);
            return new TextComponentTranslation("screenshot.failure", new Object[] { lllllllllllllIlIllIllIllIIIllIIl.getMessage() });
        }
    }
    
    public static BufferedImage createScreenshot(int lllllllllllllIlIllIllIlIllllllIl, int lllllllllllllIlIllIllIlIllllllII, final Framebuffer lllllllllllllIlIllIllIlIlllllIll) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            lllllllllllllIlIllIllIlIllllllIl = lllllllllllllIlIllIllIlIlllllIll.framebufferTextureWidth;
            lllllllllllllIlIllIllIlIllllllII = lllllllllllllIlIllIllIlIlllllIll.framebufferTextureHeight;
        }
        final int lllllllllllllIlIllIllIlIllllllll = (int)(lllllllllllllIlIllIllIlIllllllIl * lllllllllllllIlIllIllIlIllllllII);
        if (ScreenShotHelper.pixelBuffer == null || ScreenShotHelper.pixelBuffer.capacity() < lllllllllllllIlIllIllIlIllllllll) {
            ScreenShotHelper.pixelBuffer = BufferUtils.createIntBuffer(lllllllllllllIlIllIllIlIllllllll);
            ScreenShotHelper.pixelValues = new int[lllllllllllllIlIllIllIlIllllllll];
        }
        GlStateManager.glPixelStorei(3333, 1);
        GlStateManager.glPixelStorei(3317, 1);
        ScreenShotHelper.pixelBuffer.clear();
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.bindTexture(lllllllllllllIlIllIllIlIlllllIll.framebufferTexture);
            GlStateManager.glGetTexImage(3553, 0, 32993, 33639, ScreenShotHelper.pixelBuffer);
        }
        else {
            GlStateManager.glReadPixels(0, 0, (int)lllllllllllllIlIllIllIlIllllllIl, lllllllllllllIlIllIllIlIllllllII, 32993, 33639, ScreenShotHelper.pixelBuffer);
        }
        ScreenShotHelper.pixelBuffer.get(ScreenShotHelper.pixelValues);
        TextureUtil.processPixelValues(ScreenShotHelper.pixelValues, (int)lllllllllllllIlIllIllIlIllllllIl, lllllllllllllIlIllIllIlIllllllII);
        final BufferedImage lllllllllllllIlIllIllIlIlllllllI = new BufferedImage((int)lllllllllllllIlIllIllIlIllllllIl, lllllllllllllIlIllIllIlIllllllII, 1);
        lllllllllllllIlIllIllIlIlllllllI.setRGB(0, 0, (int)lllllllllllllIlIllIllIlIllllllIl, lllllllllllllIlIllIllIlIllllllII, ScreenShotHelper.pixelValues, 0, (int)lllllllllllllIlIllIllIlIllllllIl);
        return lllllllllllllIlIllIllIlIlllllllI;
    }
    
    public static ITextComponent saveScreenshot(final File lllllllllllllIlIllIllIllIlIIIlII, final int lllllllllllllIlIllIllIllIlIIIIll, final int lllllllllllllIlIllIllIllIIlllllI, final Framebuffer lllllllllllllIlIllIllIllIIllllIl) {
        return saveScreenshot(lllllllllllllIlIllIllIllIlIIIlII, null, lllllllllllllIlIllIllIllIlIIIIll, lllllllllllllIlIllIllIllIIlllllI, lllllllllllllIlIllIllIllIIllllIl);
    }
}
