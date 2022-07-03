package font;

import java.awt.*;
import javax.imageio.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.input.*;
import java.awt.image.*;
import org.lwjgl.*;
import java.nio.*;
import org.lwjgl.opengl.*;
import java.util.*;

public final class GLUtils
{
    public static /* synthetic */ List<Integer> vbos;
    public static /* synthetic */ List<Integer> textures;
    private static final /* synthetic */ Tessellator tessellator;
    private static final /* synthetic */ Random random;
    
    public static Color getRandomColor() {
        return getRandomColor(1000, 0.6f);
    }
    
    public static void drawBorderRect(final float lllllllllllllIIlIIllIllIIlIlllII, final float lllllllllllllIIlIIllIllIIlIllIll, final float lllllllllllllIIlIIllIllIIlIllIlI, final float lllllllllllllIIlIIllIllIIlIllIIl, final float lllllllllllllIIlIIllIllIIlIllIII) {
        drawBorder(lllllllllllllIIlIIllIllIIlIllIII, lllllllllllllIIlIIllIllIIlIlllII, lllllllllllllIIlIIllIllIIlIllIll, lllllllllllllIIlIIllIllIIlIllIlI, lllllllllllllIIlIIllIllIIlIllIIl);
        drawRect(lllllllllllllIIlIIllIllIIlIlllII, lllllllllllllIIlIIllIllIIlIllIll, lllllllllllllIIlIIllIllIIlIllIlI, lllllllllllllIIlIIllIllIIlIllIIl);
    }
    
    public static int applyTexture(final int lllllllllllllIIlIIllIllIlIIlllII, final File lllllllllllllIIlIIllIllIlIIlIlll, final int lllllllllllllIIlIIllIllIlIIllIlI, final int lllllllllllllIIlIIllIllIlIIllIIl) throws IOException {
        applyTexture(lllllllllllllIIlIIllIllIlIIlllII, ImageIO.read(lllllllllllllIIlIIllIllIlIIlIlll), lllllllllllllIIlIIllIllIlIIllIlI, lllllllllllllIIlIIllIllIlIIllIIl);
        return lllllllllllllIIlIIllIllIlIIlllII;
    }
    
    public static int getScreenWidth() {
        return Minecraft.getMinecraft().displayWidth / getScaleFactor();
    }
    
    public static void drawBorder(final float lllllllllllllIIlIIllIllIIlIIIllI, final float lllllllllllllIIlIIllIllIIlIIlIll, final float lllllllllllllIIlIIllIllIIlIIIlII, final float lllllllllllllIIlIIllIllIIlIIlIIl, final float lllllllllllllIIlIIllIllIIlIIlIII) {
        GL11.glLineWidth(lllllllllllllIIlIIllIllIIlIIIllI);
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        final BufferBuilder lllllllllllllIIlIIllIllIIlIIIlll = GLUtils.tessellator.getBuffer();
        lllllllllllllIIlIIllIllIIlIIIlll.begin(2, DefaultVertexFormats.POSITION);
        lllllllllllllIIlIIllIllIIlIIIlll.pos(lllllllllllllIIlIIllIllIIlIIlIll, lllllllllllllIIlIIllIllIIlIIIlII, 0.0).endVertex();
        lllllllllllllIIlIIllIllIIlIIIlll.pos(lllllllllllllIIlIIllIllIIlIIlIll, lllllllllllllIIlIIllIllIIlIIlIII, 0.0).endVertex();
        lllllllllllllIIlIIllIllIIlIIIlll.pos(lllllllllllllIIlIIllIllIIlIIlIIl, lllllllllllllIIlIIllIllIIlIIlIII, 0.0).endVertex();
        lllllllllllllIIlIIllIllIIlIIIlll.pos(lllllllllllllIIlIIllIllIIlIIlIIl, lllllllllllllIIlIIllIllIIlIIIlII, 0.0).endVertex();
        GLUtils.tessellator.draw();
        GlStateManager.enableTexture2D();
    }
    
    public static int getMouseY() {
        return getScreenHeight() - Mouse.getY() * getScreenHeight() / Minecraft.getMinecraft().displayWidth - 1;
    }
    
    public static int getMouseX() {
        return Mouse.getX() * getScreenWidth() / Minecraft.getMinecraft().displayWidth;
    }
    
    public static boolean isHovered(final int lllllllllllllIIlIIllIllIlIllIIlI, final int lllllllllllllIIlIIllIllIlIllIIIl, final int lllllllllllllIIlIIllIllIlIllIIII, final int lllllllllllllIIlIIllIllIlIlIllll, final int lllllllllllllIIlIIllIllIlIlIlIII, final int lllllllllllllIIlIIllIllIlIlIIlll) {
        return lllllllllllllIIlIIllIllIlIlIlIII >= lllllllllllllIIlIIllIllIlIllIIlI && lllllllllllllIIlIIllIllIlIlIlIII <= lllllllllllllIIlIIllIllIlIllIIlI + lllllllllllllIIlIIllIllIlIllIIII && lllllllllllllIIlIIllIllIlIlIIlll >= lllllllllllllIIlIIllIllIlIllIIIl && lllllllllllllIIlIIllIllIlIlIIlll < lllllllllllllIIlIIllIllIlIllIIIl + lllllllllllllIIlIIllIllIlIlIllll;
    }
    
    public static void glScissor(final float lllllllllllllIIlIIllIllIllIIIllI, final float lllllllllllllIIlIIllIllIllIIlIlI, final float lllllllllllllIIlIIllIllIllIIIlII, final float lllllllllllllIIlIIllIllIllIIlIII) {
        final int lllllllllllllIIlIIllIllIllIIIlll = getScaleFactor();
        GL11.glScissor((int)(lllllllllllllIIlIIllIllIllIIIllI * lllllllllllllIIlIIllIllIllIIIlll), (int)(Minecraft.getMinecraft().displayHeight - lllllllllllllIIlIIllIllIllIIlIII * lllllllllllllIIlIIllIllIllIIIlll), (int)((lllllllllllllIIlIIllIllIllIIIlII - lllllllllllllIIlIIllIllIllIIIllI) * lllllllllllllIIlIIllIllIllIIIlll), (int)((lllllllllllllIIlIIllIllIllIIlIII - lllllllllllllIIlIIllIllIllIIlIlI) * lllllllllllllIIlIIllIllIllIIIlll));
    }
    
    public static int applyTexture(final int lllllllllllllIIlIIllIllIlIIIlIll, final BufferedImage lllllllllllllIIlIIllIllIlIIIIIIl, final int lllllllllllllIIlIIllIllIlIIIlIIl, final int lllllllllllllIIlIIllIllIIlllllll) {
        final int[] lllllllllllllIIlIIllIllIlIIIIlll = new int[lllllllllllllIIlIIllIllIlIIIIIIl.getWidth() * lllllllllllllIIlIIllIllIlIIIIIIl.getHeight()];
        lllllllllllllIIlIIllIllIlIIIIIIl.getRGB(0, 0, lllllllllllllIIlIIllIllIlIIIIIIl.getWidth(), lllllllllllllIIlIIllIllIlIIIIIIl.getHeight(), lllllllllllllIIlIIllIllIlIIIIlll, 0, lllllllllllllIIlIIllIllIlIIIIIIl.getWidth());
        final ByteBuffer lllllllllllllIIlIIllIllIlIIIIllI = BufferUtils.createByteBuffer(lllllllllllllIIlIIllIllIlIIIIIIl.getWidth() * lllllllllllllIIlIIllIllIlIIIIIIl.getHeight() * 4);
        for (int lllllllllllllIIlIIllIllIlIIIIlIl = 0; lllllllllllllIIlIIllIllIlIIIIlIl < lllllllllllllIIlIIllIllIlIIIIIIl.getHeight(); ++lllllllllllllIIlIIllIllIlIIIIlIl) {
            for (int lllllllllllllIIlIIllIllIlIIIIlII = 0; lllllllllllllIIlIIllIllIlIIIIlII < lllllllllllllIIlIIllIllIlIIIIIIl.getWidth(); ++lllllllllllllIIlIIllIllIlIIIIlII) {
                final int lllllllllllllIIlIIllIllIlIIIIIll = lllllllllllllIIlIIllIllIlIIIIlll[lllllllllllllIIlIIllIllIlIIIIlIl * lllllllllllllIIlIIllIllIlIIIIIIl.getWidth() + lllllllllllllIIlIIllIllIlIIIIlII];
                lllllllllllllIIlIIllIllIlIIIIllI.put((byte)(lllllllllllllIIlIIllIllIlIIIIIll >> 16 & 0xFF));
                lllllllllllllIIlIIllIllIlIIIIllI.put((byte)(lllllllllllllIIlIIllIllIlIIIIIll >> 8 & 0xFF));
                lllllllllllllIIlIIllIllIlIIIIllI.put((byte)(lllllllllllllIIlIIllIllIlIIIIIll & 0xFF));
                lllllllllllllIIlIIllIllIlIIIIllI.put((byte)(lllllllllllllIIlIIllIllIlIIIIIll >> 24 & 0xFF));
            }
        }
        lllllllllllllIIlIIllIllIlIIIIllI.flip();
        applyTexture(lllllllllllllIIlIIllIllIlIIIlIll, lllllllllllllIIlIIllIllIlIIIIIIl.getWidth(), lllllllllllllIIlIIllIllIlIIIIIIl.getHeight(), lllllllllllllIIlIIllIllIlIIIIllI, lllllllllllllIIlIIllIllIlIIIlIIl, lllllllllllllIIlIIllIllIIlllllll);
        return lllllllllllllIIlIIllIllIlIIIlIll;
    }
    
    public static void cleanup() {
        GL15.glBindBuffer(34962, 0);
        GL11.glBindTexture(3553, 0);
        for (final int lllllllllllllIIlIIllIllIIllIIlIl : GLUtils.vbos) {
            GL15.glDeleteBuffers(lllllllllllllIIlIIllIllIIllIIlIl);
        }
        for (final int lllllllllllllIIlIIllIllIIllIIlII : GLUtils.textures) {
            GL11.glDeleteTextures(lllllllllllllIIlIIllIllIIllIIlII);
        }
    }
    
    public static void glColor(final Color lllllllllllllIIlIIllIlIlllllIIll) {
        GlStateManager.color(lllllllllllllIIlIIllIlIlllllIIll.getRed() / 255.0f, lllllllllllllIIlIIllIlIlllllIIll.getGreen() / 255.0f, lllllllllllllIIlIIllIlIlllllIIll.getBlue() / 255.0f, lllllllllllllIIlIIllIlIlllllIIll.getAlpha() / 255.0f);
    }
    
    public static void disableGL2D() {
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    static {
        random = new Random();
        tessellator = Tessellator.getInstance();
        GLUtils.vbos = new ArrayList<Integer>();
        GLUtils.textures = new ArrayList<Integer>();
    }
    
    public static void drawGradientRect(final int lllllllllllllIIlIIllIllIIIlIIIIl, final int lllllllllllllIIlIIllIllIIIlIIIII, final int lllllllllllllIIlIIllIllIIIIIllll, final int lllllllllllllIIlIIllIllIIIIllllI, final int lllllllllllllIIlIIllIllIIIIlllIl, final int lllllllllllllIIlIIllIllIIIIlllII) {
        final float lllllllllllllIIlIIllIllIIIIllIll = (lllllllllllllIIlIIllIllIIIIlllIl >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIIllIllIIIIllIlI = (lllllllllllllIIlIIllIllIIIIlllIl >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIIllIllIIIIllIIl = (lllllllllllllIIlIIllIllIIIIlllIl >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIIllIllIIIIllIII = (lllllllllllllIIlIIllIllIIIIlllIl & 0xFF) / 255.0f;
        final float lllllllllllllIIlIIllIllIIIIlIlll = (lllllllllllllIIlIIllIllIIIIlllII >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIIllIllIIIIlIllI = (lllllllllllllIIlIIllIllIIIIlllII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIIllIllIIIIlIlIl = (lllllllllllllIIlIIllIllIIIIlllII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIIllIllIIIIlIlII = (lllllllllllllIIlIIllIllIIIIlllII & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        final Tessellator lllllllllllllIIlIIllIllIIIIlIIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIIllIllIIIIlIIlI = lllllllllllllIIlIIllIllIIIIlIIll.getBuffer();
        lllllllllllllIIlIIllIllIIIIlIIlI.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllIIlIIllIllIIIIlIIlI.pos(lllllllllllllIIlIIllIllIIIlIIIIl + (double)lllllllllllllIIlIIllIllIIIIIllll, lllllllllllllIIlIIllIllIIIlIIIII, 0.0).color(lllllllllllllIIlIIllIllIIIIllIlI, lllllllllllllIIlIIllIllIIIIllIIl, lllllllllllllIIlIIllIllIIIIllIII, lllllllllllllIIlIIllIllIIIIllIll).endVertex();
        lllllllllllllIIlIIllIllIIIIlIIlI.pos(lllllllllllllIIlIIllIllIIIlIIIIl, lllllllllllllIIlIIllIllIIIlIIIII, 0.0).color(lllllllllllllIIlIIllIllIIIIllIlI, lllllllllllllIIlIIllIllIIIIllIIl, lllllllllllllIIlIIllIllIIIIllIII, lllllllllllllIIlIIllIllIIIIllIll).endVertex();
        lllllllllllllIIlIIllIllIIIIlIIlI.pos(lllllllllllllIIlIIllIllIIIlIIIIl, lllllllllllllIIlIIllIllIIIlIIIII + (double)lllllllllllllIIlIIllIllIIIIllllI, 0.0).color(lllllllllllllIIlIIllIllIIIIlIllI, lllllllllllllIIlIIllIllIIIIlIlIl, lllllllllllllIIlIIllIllIIIIlIlII, lllllllllllllIIlIIllIllIIIIlIlll).endVertex();
        lllllllllllllIIlIIllIllIIIIlIIlI.pos(lllllllllllllIIlIIllIllIIIlIIIIl + (double)lllllllllllllIIlIIllIllIIIIIllll, lllllllllllllIIlIIllIllIIIlIIIII + (double)lllllllllllllIIlIIllIllIIIIllllI, 0.0).color(lllllllllllllIIlIIllIllIIIIlIllI, lllllllllllllIIlIIllIllIIIIlIlIl, lllllllllllllIIlIIllIllIIIIlIlII, lllllllllllllIIlIIllIllIIIIlIlll).endVertex();
        lllllllllllllIIlIIllIllIIIIlIIll.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public static int getScaleFactor() {
        int lllllllllllllIIlIIllIllIlIlllllI = 1;
        final boolean lllllllllllllIIlIIllIllIlIllllIl = Minecraft.getMinecraft().isUnicode();
        int lllllllllllllIIlIIllIllIlIllllII = Minecraft.getMinecraft().gameSettings.guiScale;
        if (lllllllllllllIIlIIllIllIlIllllII == 0) {
            lllllllllllllIIlIIllIllIlIllllII = 1000;
        }
        while (lllllllllllllIIlIIllIllIlIlllllI < lllllllllllllIIlIIllIllIlIllllII && Minecraft.getMinecraft().displayWidth / (lllllllllllllIIlIIllIllIlIlllllI + 1) >= 320 && Minecraft.getMinecraft().displayHeight / (lllllllllllllIIlIIllIllIlIlllllI + 1) >= 240) {
            ++lllllllllllllIIlIIllIllIlIlllllI;
        }
        if (lllllllllllllIIlIIllIllIlIllllIl && lllllllllllllIIlIIllIllIlIlllllI % 2 != 0 && lllllllllllllIIlIIllIllIlIlllllI != 1) {
            --lllllllllllllIIlIIllIllIlIlllllI;
        }
        return lllllllllllllIIlIIllIllIlIlllllI;
    }
    
    public static void drawRect(final float lllllllllllllIIlIIllIllIIIlllIll, final float lllllllllllllIIlIIllIllIIIllIlIl, final float lllllllllllllIIlIIllIllIIIlllIIl, final float lllllllllllllIIlIIllIllIIIllIIll) {
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        final BufferBuilder lllllllllllllIIlIIllIllIIIllIlll = GLUtils.tessellator.getBuffer();
        lllllllllllllIIlIIllIllIIIllIlll.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIIlIIllIllIIIllIlll.pos(lllllllllllllIIlIIllIllIIIlllIll, lllllllllllllIIlIIllIllIIIllIIll, 0.0).endVertex();
        lllllllllllllIIlIIllIllIIIllIlll.pos(lllllllllllllIIlIIllIllIIIlllIIl, lllllllllllllIIlIIllIllIIIllIIll, 0.0).endVertex();
        lllllllllllllIIlIIllIllIIIllIlll.pos(lllllllllllllIIlIIllIllIIIlllIIl, lllllllllllllIIlIIllIllIIIllIlIl, 0.0).endVertex();
        lllllllllllllIIlIIllIllIIIllIlll.pos(lllllllllllllIIlIIllIllIIIlllIll, lllllllllllllIIlIIllIllIIIllIlIl, 0.0).endVertex();
        GLUtils.tessellator.draw();
        GlStateManager.enableTexture2D();
    }
    
    public static Color getRandomColor(final int lllllllllllllIIlIIllIlIllllIIIlI, final float lllllllllllllIIlIIllIlIllllIIIIl) {
        final float lllllllllllllIIlIIllIlIllllIIIII = GLUtils.random.nextFloat();
        final float lllllllllllllIIlIIllIlIlllIlllll = (GLUtils.random.nextInt(lllllllllllllIIlIIllIlIllllIIIlI) + (float)lllllllllllllIIlIIllIlIllllIIIlI) / lllllllllllllIIlIIllIlIllllIIIlI + lllllllllllllIIlIIllIlIllllIIIlI;
        return getHSBColor(lllllllllllllIIlIIllIlIllllIIIII, lllllllllllllIIlIIllIlIlllIlllll, lllllllllllllIIlIIllIlIllllIIIIl);
    }
    
    public static void glColor(final float lllllllllllllIIlIIllIlIlllllllIl, final float lllllllllllllIIlIIllIlIllllllIII, final float lllllllllllllIIlIIllIlIlllllIlll, final float lllllllllllllIIlIIllIlIlllllIllI) {
        GlStateManager.color(lllllllllllllIIlIIllIlIlllllllIl, lllllllllllllIIlIIllIlIllllllIII, lllllllllllllIIlIIllIlIlllllIlll, lllllllllllllIIlIIllIlIlllllIllI);
    }
    
    public static void enableGL2D() {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }
    
    public static int getTexture() {
        final int lllllllllllllIIlIIllIllIlIlIIIlI = GL11.glGenTextures();
        GLUtils.textures.add(lllllllllllllIIlIIllIllIlIlIIIlI);
        return lllllllllllllIIlIIllIllIlIlIIIlI;
    }
    
    public static void glColor(final int lllllllllllllIIlIIllIlIlllllIIII) {
        GlStateManager.color((lllllllllllllIIlIIllIlIlllllIIII >> 16 & 0xFF) / 255.0f, (lllllllllllllIIlIIllIlIlllllIIII >> 8 & 0xFF) / 255.0f, (lllllllllllllIIlIIllIlIlllllIIII & 0xFF) / 255.0f, (lllllllllllllIIlIIllIlIlllllIIII >> 24 & 0xFF) / 255.0f);
    }
    
    public static int genVBO() {
        final int lllllllllllllIIlIIllIllIlIlIIlIl = GL15.glGenBuffers();
        GLUtils.vbos.add(lllllllllllllIIlIIllIllIlIlIIlIl);
        GL15.glBindBuffer(34962, lllllllllllllIIlIIllIllIlIlIIlIl);
        return lllllllllllllIIlIIllIllIlIlIIlIl;
    }
    
    public static int applyTexture(final int lllllllllllllIIlIIllIllIIllIllIl, final int lllllllllllllIIlIIllIllIIllIllII, final int lllllllllllllIIlIIllIllIIllIlIll, final ByteBuffer lllllllllllllIIlIIllIllIIllIlIlI, final int lllllllllllllIIlIIllIllIIllIlIIl, final int lllllllllllllIIlIIllIllIIllIlIII) {
        GL11.glBindTexture(3553, lllllllllllllIIlIIllIllIIllIllIl);
        GL11.glTexParameteri(3553, 10241, lllllllllllllIIlIIllIllIIllIlIIl);
        GL11.glTexParameteri(3553, 10240, lllllllllllllIIlIIllIllIIllIlIIl);
        GL11.glTexParameteri(3553, 10242, lllllllllllllIIlIIllIllIIllIlIII);
        GL11.glTexParameteri(3553, 10243, lllllllllllllIIlIIllIllIIllIlIII);
        GL11.glPixelStorei(3317, 1);
        GL11.glTexImage2D(3553, 0, 32856, lllllllllllllIIlIIllIllIIllIllII, lllllllllllllIIlIIllIllIIllIlIll, 0, 6408, 5121, lllllllllllllIIlIIllIllIIllIlIlI);
        GL11.glBindTexture(3553, 0);
        return lllllllllllllIIlIIllIllIIllIllIl;
    }
    
    public static int getScreenHeight() {
        return Minecraft.getMinecraft().displayHeight / getScaleFactor();
    }
    
    public static Color getHSBColor(final float lllllllllllllIIlIIllIlIllllIlIIl, final float lllllllllllllIIlIIllIlIllllIlIll, final float lllllllllllllIIlIIllIlIllllIlIlI) {
        return Color.getHSBColor(lllllllllllllIIlIIllIlIllllIlIIl, lllllllllllllIIlIIllIlIllllIlIll, lllllllllllllIIlIIllIlIllllIlIlI);
    }
    
    public static void glScissor(final int[] lllllllllllllIIlIIllIllIllIlIIlI) {
        glScissor((float)lllllllllllllIIlIIllIllIllIlIIlI[0], (float)lllllllllllllIIlIIllIllIllIlIIlI[1], (float)(lllllllllllllIIlIIllIllIllIlIIlI[0] + lllllllllllllIIlIIllIllIllIlIIlI[2]), (float)(lllllllllllllIIlIIllIllIllIlIIlI[1] + lllllllllllllIIlIIllIllIllIlIIlI[3]));
    }
}
