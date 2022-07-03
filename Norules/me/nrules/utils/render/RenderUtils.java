package me.nrules.utils.render;

import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import me.nrules.utils.math.*;
import net.minecraft.client.renderer.entity.*;
import java.awt.*;
import net.minecraft.util.*;
import me.nrules.module.render.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.*;
import java.lang.reflect.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.math.*;

public class RenderUtils
{
    private static final /* synthetic */ Frustum frustrum;
    private static /* synthetic */ HashMap<Integer, Integer> shadowCache;
    public static /* synthetic */ Minecraft mc;
    
    public static void drawRect(final double lllllllllllllIllIlIIIlllIllllIIl, final double lllllllllllllIllIlIIIlllIllllIII, final double lllllllllllllIllIlIIIlllIlllIlll, final double lllllllllllllIllIlIIIlllIlllIllI) {
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glBegin(7);
        GL11.glVertex2d(lllllllllllllIllIlIIIlllIlllIlll, lllllllllllllIllIlIIIlllIllllIII);
        GL11.glVertex2d(lllllllllllllIllIlIIIlllIllllIIl, lllllllllllllIllIlIIIlllIllllIII);
        GL11.glVertex2d(lllllllllllllIllIlIIIlllIllllIIl, lllllllllllllIllIlIIIlllIlllIllI);
        GL11.glVertex2d(lllllllllllllIllIlIIIlllIlllIlll, lllllllllllllIllIlIIIlllIlllIllI);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public static void drawBoundingBox(final AxisAlignedBB lllllllllllllIllIlIIIllIIlllllll) {
        GL11.glBegin(7);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.minX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.minZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.maxY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glVertex3d(lllllllllllllIllIlIIIllIIlllllll.maxX, lllllllllllllIllIlIIIllIIlllllll.minY, lllllllllllllIllIlIIIllIIlllllll.maxZ);
        GL11.glEnd();
    }
    
    public static void renderEntityBoundingBox(final Entity lllllllllllllIllIlIIlIIlIlIllIll, final float lllllllllllllIllIlIIlIIlIlIIllll, final float lllllllllllllIllIlIIlIIlIlIIlllI, final float lllllllllllllIllIlIIlIIlIlIllIII, final float lllllllllllllIllIlIIlIIlIlIIllII) {
        final RenderManager lllllllllllllIllIlIIlIIlIlIlIllI = Minecraft.getMinecraft().getRenderManager();
        final double[] lllllllllllllIllIlIIlIIlIlIlIlIl = MathUtils.interpolateEntity(lllllllllllllIllIlIIlIIlIlIllIll);
        final double lllllllllllllIllIlIIlIIlIlIlIlII = lllllllllllllIllIlIIlIIlIlIlIlIl[0];
        final double lllllllllllllIllIlIIlIIlIlIlIIll = lllllllllllllIllIlIIlIIlIlIlIlIl[1];
        final double lllllllllllllIllIlIIlIIlIlIlIIlI = lllllllllllllIllIlIIlIIlIlIlIlIl[2];
        final AxisAlignedBB lllllllllllllIllIlIIlIIlIlIlIIIl = new AxisAlignedBB(lllllllllllllIllIlIIlIIlIlIlIlII - lllllllllllllIllIlIIlIIlIlIllIll.width / 2.0f, lllllllllllllIllIlIIlIIlIlIlIIll, lllllllllllllIllIlIIlIIlIlIlIIlI - lllllllllllllIllIlIIlIIlIlIllIll.width / 2.0f, lllllllllllllIllIlIIlIIlIlIlIlII + lllllllllllllIllIlIIlIIlIlIllIll.width / 2.0f, lllllllllllllIllIlIIlIIlIlIlIIll + lllllllllllllIllIlIIlIIlIlIllIll.height, lllllllllllllIllIlIIlIIlIlIlIIlI + lllllllllllllIllIlIIlIIlIlIllIll.width / 2.0f).offset(-lllllllllllllIllIlIIlIIlIlIlIllI.viewerPosX, -lllllllllllllIllIlIIlIIlIlIlIllI.viewerPosY, -lllllllllllllIllIlIIlIIlIlIlIllI.viewerPosZ);
        RenderGlobal.drawSelectionBoundingBox(lllllllllllllIllIlIIlIIlIlIlIIIl, lllllllllllllIllIlIIlIIlIlIIllll, lllllllllllllIllIlIIlIIlIlIIlllI, lllllllllllllIllIlIIlIIlIlIllIII, lllllllllllllIllIlIIlIIlIlIIllII);
    }
    
    public static void glColor(final int lllllllllllllIllIlIIIllllIlIIIII) {
        final float lllllllllllllIllIlIIIllllIlIIlII = (lllllllllllllIllIlIIIllllIlIIIII >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIllllIlIIIll = (lllllllllllllIllIlIIIllllIlIIIII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIllllIlIIIlI = (lllllllllllllIllIlIIIllllIlIIIII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIllllIlIIIIl = (lllllllllllllIllIlIIIllllIlIIIII & 0xFF) / 255.0f;
        GL11.glColor4f(lllllllllllllIllIlIIIllllIlIIIll, lllllllllllllIllIlIIIllllIlIIIlI, lllllllllllllIllIlIIIllllIlIIIIl, lllllllllllllIllIlIIIllllIlIIlII);
    }
    
    public static boolean isInViewFrustrum(final Entity lllllllllllllIllIlIIIllIllIlIIll) {
        return isInViewFrustrum(lllllllllllllIllIlIIIllIllIlIIll.getEntityBoundingBox()) || lllllllllllllIllIlIIIllIllIlIIll.ignoreFrustumCheck;
    }
    
    public static void renderEntityFilledBoundingBox(final Entity lllllllllllllIllIlIIlIIlIllIllII, final Color lllllllllllllIllIlIIlIIlIllIlIII, final float lllllllllllllIllIlIIlIIlIllIIlll) {
        renderEntityFilledBoundingBox(lllllllllllllIllIlIIlIIlIllIllII, lllllllllllllIllIlIIlIIlIllIlIII.getRed() / 255.0f, lllllllllllllIllIlIIlIIlIllIlIII.getGreen() / 255.0f, lllllllllllllIllIlIIlIIlIllIlIII.getBlue() / 255.0f, lllllllllllllIllIlIIlIIlIllIIlll);
    }
    
    public static void enableGL2D1() {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
    }
    
    public static void drawRoundedRect2(final int lllllllllllllIllIlIIIllIlllIIIll, final int lllllllllllllIllIlIIIllIllIllIll, final int lllllllllllllIllIlIIIllIllIllIlI, final int lllllllllllllIllIlIIIllIllIllIIl, final int lllllllllllllIllIlIIIllIllIllIII) {
        final int lllllllllllllIllIlIIIllIllIllllI = lllllllllllllIllIlIIIllIlllIIIll + lllllllllllllIllIlIIIllIllIllIlI;
        final int lllllllllllllIllIlIIIllIllIlllIl = lllllllllllllIllIlIIIllIllIllIll + lllllllllllllIllIlIIIllIllIllIIl;
        drawRect((float)(lllllllllllllIllIlIIIllIlllIIIll + 1), (float)lllllllllllllIllIlIIIllIllIllIll, (float)(lllllllllllllIllIlIIIllIllIllllI - 1), (float)lllllllllllllIllIlIIIllIllIlllIl, lllllllllllllIllIlIIIllIllIllIII);
        drawRect((float)lllllllllllllIllIlIIIllIlllIIIll, (float)(lllllllllllllIllIlIIIllIllIllIll + 1), (float)lllllllllllllIllIlIIIllIllIllllI, (float)(lllllllllllllIllIlIIIllIllIlllIl - 1), lllllllllllllIllIlIIIllIllIllIII);
    }
    
    public static void drawRect2(final float lllllllllllllIllIlIIIllllIIlIIIl, final float lllllllllllllIllIlIIIllllIIlIIII, final float lllllllllllllIllIlIIIllllIIlIlII, final float lllllllllllllIllIlIIIllllIIlIIll, final int lllllllllllllIllIlIIIllllIIIllIl) {
        enableGL2D1();
        glColor(lllllllllllllIllIlIIIllllIIIllIl);
        GL11.glBegin(7);
        GL11.glVertex2f(lllllllllllllIllIlIIIllllIIlIIIl, lllllllllllllIllIlIIIllllIIlIIll);
        GL11.glVertex2f(lllllllllllllIllIlIIIllllIIlIlII, lllllllllllllIllIlIIIllllIIlIIll);
        GL11.glVertex2f(lllllllllllllIllIlIIIllllIIlIlII, lllllllllllllIllIlIIIllllIIlIIII);
        GL11.glVertex2f(lllllllllllllIllIlIIIllllIIlIIIl, lllllllllllllIllIlIIIllllIIlIIII);
        GL11.glEnd();
        disableGL2D1();
    }
    
    public static void drawTexture(final ResourceLocation lllllllllllllIllIlIIlIIlIIlllIll, final double lllllllllllllIllIlIIlIIlIIlllIlI, final double lllllllllllllIllIlIIlIIlIIlllIIl, final double lllllllllllllIllIlIIlIIlIIllllIl, final double lllllllllllllIllIlIIlIIlIIllllII) {
        GL11.glDisable(2929);
        GlStateManager.enableBlend();
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        RenderUtils.mc.getTextureManager().bindTexture(lllllllllllllIllIlIIlIIlIIlllIll);
        Gui.drawModalRectWithCustomSizedTexture((int)lllllllllllllIllIlIIlIIlIIlllIlI, (int)lllllllllllllIllIlIIlIIlIIlllIIl, 0.0f, 0.0f, (int)lllllllllllllIllIlIIlIIlIIllllIl, (int)lllllllllllllIllIlIIlIIlIIllllII, (float)(int)lllllllllllllIllIlIIlIIlIIllllIl, (float)(int)lllllllllllllIllIlIIlIIlIIllllII);
        GL11.glDepthMask(true);
        GlStateManager.disableBlend();
        GL11.glEnable(2929);
    }
    
    public static int getRainbow(final int lllllllllllllIllIlIIlIIlIIIIIlll, final int lllllllllllllIllIlIIlIIlIIIIIllI) {
        float lllllllllllllIllIlIIlIIlIIIIlIIl = (float)((System.currentTimeMillis() * 1L + lllllllllllllIllIlIIlIIlIIIIIllI / 2) % lllllllllllllIllIlIIlIIlIIIIIlll * 2L);
        lllllllllllllIllIlIIlIIlIIIIlIIl /= lllllllllllllIllIlIIlIIlIIIIIlll;
        final float lllllllllllllIllIlIIlIIlIIIIlIII = ClickGUI.guiSaturation.getValFloat();
        return Color.getHSBColor(lllllllllllllIllIlIIlIIlIIIIlIIl, lllllllllllllIllIlIIlIIlIIIIlIII, 1.0f).getRGB();
    }
    
    static {
        RenderUtils.shadowCache = new HashMap<Integer, Integer>();
        RenderUtils.mc = Minecraft.getMinecraft();
        frustrum = new Frustum();
    }
    
    public static void renderEntityFilledBoundingBox(final Entity lllllllllllllIllIlIIlIIlIllllIlI, final float lllllllllllllIllIlIIlIIllIIIIlII, final float lllllllllllllIllIlIIlIIllIIIIIll, final float lllllllllllllIllIlIIlIIllIIIIIlI, final float lllllllllllllIllIlIIlIIlIlllIllI) {
        final RenderManager lllllllllllllIllIlIIlIIllIIIIIII = Minecraft.getMinecraft().getRenderManager();
        final double[] lllllllllllllIllIlIIlIIlIlllllll = MathUtils.interpolateEntity(lllllllllllllIllIlIIlIIlIllllIlI);
        final double lllllllllllllIllIlIIlIIlIllllllI = lllllllllllllIllIlIIlIIlIlllllll[0];
        final double lllllllllllllIllIlIIlIIlIlllllIl = lllllllllllllIllIlIIlIIlIlllllll[1];
        final double lllllllllllllIllIlIIlIIlIlllllII = lllllllllllllIllIlIIlIIlIlllllll[2];
        final AxisAlignedBB lllllllllllllIllIlIIlIIlIllllIll = new AxisAlignedBB(lllllllllllllIllIlIIlIIlIllllllI - lllllllllllllIllIlIIlIIlIllllIlI.width / 2.0f, lllllllllllllIllIlIIlIIlIlllllIl, lllllllllllllIllIlIIlIIlIlllllII - lllllllllllllIllIlIIlIIlIllllIlI.width / 2.0f, lllllllllllllIllIlIIlIIlIllllllI + lllllllllllllIllIlIIlIIlIllllIlI.width / 2.0f, lllllllllllllIllIlIIlIIlIlllllIl + lllllllllllllIllIlIIlIIlIllllIlI.height, lllllllllllllIllIlIIlIIlIlllllII + lllllllllllllIllIlIIlIIlIllllIlI.width / 2.0f).offset(-lllllllllllllIllIlIIlIIllIIIIIII.viewerPosX, -lllllllllllllIllIlIIlIIllIIIIIII.viewerPosY, -lllllllllllllIllIlIIlIIllIIIIIII.viewerPosZ);
        RenderGlobal.renderFilledBox(lllllllllllllIllIlIIlIIlIllllIll, lllllllllllllIllIlIIlIIllIIIIlII, lllllllllllllIllIlIIlIIllIIIIIll, lllllllllllllIllIlIIlIIllIIIIIlI, lllllllllllllIllIlIIlIIlIlllIllI);
    }
    
    public static void post3D() {
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public static void drawBorderedRect(final double lllllllllllllIllIlIIIllIlIIIlIIl, final double lllllllllllllIllIlIIIllIlIIIlIII, final double lllllllllllllIllIlIIIllIlIIIllll, final double lllllllllllllIllIlIIIllIlIIIlllI, final double lllllllllllllIllIlIIIllIlIIIllIl, final int lllllllllllllIllIlIIIllIlIIIIlII, final int lllllllllllllIllIlIIIllIlIIIIIll, final boolean lllllllllllllIllIlIIIllIlIIIlIlI) {
        drawRect(lllllllllllllIllIlIIIllIlIIIlIIl - (lllllllllllllIllIlIIIllIlIIIlIlI ? 0.0 : lllllllllllllIllIlIIIllIlIIIllIl), lllllllllllllIllIlIIIllIlIIIlIII - (lllllllllllllIllIlIIIllIlIIIlIlI ? 0.0 : lllllllllllllIllIlIIIllIlIIIllIl), lllllllllllllIllIlIIIllIlIIIllll + (lllllllllllllIllIlIIIllIlIIIlIlI ? 0.0 : lllllllllllllIllIlIIIllIlIIIllIl), lllllllllllllIllIlIIIllIlIIIlllI + (lllllllllllllIllIlIIIllIlIIIlIlI ? 0.0 : lllllllllllllIllIlIIIllIlIIIllIl), lllllllllllllIllIlIIIllIlIIIIIll);
        drawRect(lllllllllllllIllIlIIIllIlIIIlIIl + (lllllllllllllIllIlIIIllIlIIIlIlI ? lllllllllllllIllIlIIIllIlIIIllIl : 0.0), lllllllllllllIllIlIIIllIlIIIlIII + (lllllllllllllIllIlIIIllIlIIIlIlI ? lllllllllllllIllIlIIIllIlIIIllIl : 0.0), lllllllllllllIllIlIIIllIlIIIllll - (lllllllllllllIllIlIIIllIlIIIlIlI ? lllllllllllllIllIlIIIllIlIIIllIl : 0.0), lllllllllllllIllIlIIIllIlIIIlllI - (lllllllllllllIllIlIIIllIlIIIlIlI ? lllllllllllllIllIlIIIllIlIIIllIl : 0.0), lllllllllllllIllIlIIIllIlIIIIlII);
    }
    
    public static final void drawSmoothRect(final float lllllllllllllIllIlIIlIIIIlIIIIIl, final float lllllllllllllIllIlIIlIIIIIlllIll, final float lllllllllllllIllIlIIlIIIIIlllIlI, final float lllllllllllllIllIlIIlIIIIIlllllI, final int lllllllllllllIllIlIIlIIIIIlllIII) {
        GL11.glEnable(3042);
        GL11.glEnable(2848);
        drawRect2(lllllllllllllIllIlIIlIIIIlIIIIIl, lllllllllllllIllIlIIlIIIIIlllIll, lllllllllllllIllIlIIlIIIIIlllIlI, lllllllllllllIllIlIIlIIIIIlllllI, lllllllllllllIllIlIIlIIIIIlllIII);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        drawRect2(lllllllllllllIllIlIIlIIIIlIIIIIl * 2.0f - 1.0f, lllllllllllllIllIlIIlIIIIIlllIll * 2.0f, lllllllllllllIllIlIIlIIIIlIIIIIl * 2.0f, lllllllllllllIllIlIIlIIIIIlllllI * 2.0f - 1.0f, lllllllllllllIllIlIIlIIIIIlllIII);
        drawRect2(lllllllllllllIllIlIIlIIIIlIIIIIl * 2.0f, lllllllllllllIllIlIIlIIIIIlllIll * 2.0f - 1.0f, lllllllllllllIllIlIIlIIIIIlllIlI * 2.0f, lllllllllllllIllIlIIlIIIIIlllIll * 2.0f, lllllllllllllIllIlIIlIIIIIlllIII);
        drawRect2(lllllllllllllIllIlIIlIIIIIlllIlI * 2.0f, lllllllllllllIllIlIIlIIIIIlllIll * 2.0f, lllllllllllllIllIlIIlIIIIIlllIlI * 2.0f + 1.0f, lllllllllllllIllIlIIlIIIIIlllllI * 2.0f - 1.0f, lllllllllllllIllIlIIlIIIIIlllIII);
        drawRect2(lllllllllllllIllIlIIlIIIIlIIIIIl * 2.0f, lllllllllllllIllIlIIlIIIIIlllllI * 2.0f - 1.0f, lllllllllllllIllIlIIlIIIIIlllIlI * 2.0f, lllllllllllllIllIlIIlIIIIIlllllI * 2.0f, lllllllllllllIllIlIIlIIIIIlllIII);
        GL11.glDisable(3042);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }
    
    public static void drawRoundedRect1(final double lllllllllllllIllIlIIIllIllllIlIl, final double lllllllllllllIllIlIIIllIlllIlllI, final double lllllllllllllIllIlIIIllIllllIIll, final double lllllllllllllIllIlIIIllIllllIIlI, final int lllllllllllllIllIlIIIllIllllIIIl, final int lllllllllllllIllIlIIIllIlllIlIll) {
        drawRect(lllllllllllllIllIlIIIllIllllIlIl + 0.5, lllllllllllllIllIlIIIllIlllIlllI, lllllllllllllIllIlIIIllIllllIIll - 0.5, lllllllllllllIllIlIIIllIlllIlllI + 0.5, lllllllllllllIllIlIIIllIlllIlIll);
        drawRect(lllllllllllllIllIlIIIllIllllIlIl + 0.5, lllllllllllllIllIlIIIllIllllIIlI - 0.5, lllllllllllllIllIlIIIllIllllIIll - 0.5, lllllllllllllIllIlIIIllIllllIIlI, lllllllllllllIllIlIIIllIlllIlIll);
        drawRect(lllllllllllllIllIlIIIllIllllIlIl, lllllllllllllIllIlIIIllIlllIlllI + 0.5, lllllllllllllIllIlIIIllIllllIIll, lllllllllllllIllIlIIIllIllllIIlI - 0.5, lllllllllllllIllIlIIIllIlllIlIll);
    }
    
    public static Method[] getMethods(final Class<GuiIngame> lllllllllllllIllIlIIIllllIllIllI, final Class<?>... lllllllllllllIllIlIIIllllIllIlIl) {
        final ArrayList<Method> lllllllllllllIllIlIIIllllIllIlII = new ArrayList<Method>();
        final Method[] lllllllllllllIllIlIIIllllIllIIll = lllllllllllllIllIlIIIllllIllIllI.getDeclaredMethods();
        for (int lllllllllllllIllIlIIIllllIllIIlI = 0; lllllllllllllIllIlIIIllllIllIIlI < lllllllllllllIllIlIIIllllIllIIll.length; ++lllllllllllllIllIlIIIllllIllIIlI) {
            final Method lllllllllllllIllIlIIIllllIllIIIl = lllllllllllllIllIlIIIllllIllIIll[lllllllllllllIllIlIIIllllIllIIlI];
            if (Arrays.equals(lllllllllllllIllIlIIIllllIllIIIl.getParameterTypes(), lllllllllllllIllIlIIIllllIllIlIl)) {
                lllllllllllllIllIlIIIllllIllIlII.add(lllllllllllllIllIlIIIllllIllIIIl);
            }
        }
        return lllllllllllllIllIlIIIllllIllIlII.toArray(new Method[0]);
    }
    
    public static void pre3D() {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glHint(3154, 4354);
    }
    
    public static void drawRoundedRect(final double lllllllllllllIllIlIIlIIIllIlllII, final double lllllllllllllIllIlIIlIIIllIllIll, final double lllllllllllllIllIlIIlIIIllIlIlII, final double lllllllllllllIllIlIIlIIIllIllIIl, final float lllllllllllllIllIlIIlIIIllIllIII) {
        final int lllllllllllllIllIlIIlIIIllIlIlll = 10;
        drawFillRectangle(lllllllllllllIllIlIIlIIIllIlllII + lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIll, lllllllllllllIllIlIIlIIIllIlIlII - 2.0f * lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIIl);
        drawFillRectangle(lllllllllllllIllIlIIlIIIllIlllII, lllllllllllllIllIlIIlIIIllIllIll + lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIIl - 2.0f * lllllllllllllIllIlIIlIIIllIllIII);
        drawFillRectangle(lllllllllllllIllIlIIlIIIllIlllII + lllllllllllllIllIlIIlIIIllIlIlII - lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIll + lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIIl - 2.0f * lllllllllllllIllIlIIlIIIllIllIII);
        drawCirclePart(lllllllllllllIllIlIIlIIIllIlllII + lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIll + lllllllllllllIllIlIIlIIIllIllIII, -3.1415927f, -1.5707964f, lllllllllllllIllIlIIlIIIllIllIII, 10);
        drawCirclePart(lllllllllllllIllIlIIlIIIllIlllII + lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIll + lllllllllllllIllIlIIlIIIllIllIIl - lllllllllllllIllIlIIlIIIllIllIII, -1.5707964f, 0.0f, lllllllllllllIllIlIIlIIIllIllIII, 10);
        drawCirclePart(lllllllllllllIllIlIIlIIIllIlllII + lllllllllllllIllIlIIlIIIllIlIlII - lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIll + lllllllllllllIllIlIIlIIIllIllIII, 1.5707964f, 3.1415927f, lllllllllllllIllIlIIlIIIllIllIII, 10);
        drawCirclePart(lllllllllllllIllIlIIlIIIllIlllII + lllllllllllllIllIlIIlIIIllIlIlII - lllllllllllllIllIlIIlIIIllIllIII, lllllllllllllIllIlIIlIIIllIllIll + lllllllllllllIllIlIIlIIIllIllIIl - lllllllllllllIllIlIIlIIIllIllIII, 0.0f, 1.5707964f, lllllllllllllIllIlIIlIIIllIllIII, 10);
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GlStateManager.disableBlend();
    }
    
    public static void drawBorderedRect(final double lllllllllllllIllIlIIlIIIIllllIll, final double lllllllllllllIllIlIIlIIIIlllIIll, final double lllllllllllllIllIlIIlIIIIllllIIl, final double lllllllllllllIllIlIIlIIIIllllIII, final double lllllllllllllIllIlIIlIIIIlllIIII, final int lllllllllllllIllIlIIlIIIIlllIllI, final int lllllllllllllIllIlIIlIIIIllIlllI) {
        Gui.drawRect(lllllllllllllIllIlIIlIIIIllllIll, lllllllllllllIllIlIIlIIIIlllIIll, lllllllllllllIllIlIIlIIIIllllIll + lllllllllllllIllIlIIlIIIIllllIIl, lllllllllllllIllIlIIlIIIIlllIIll + lllllllllllllIllIlIIlIIIIllllIII, lllllllllllllIllIlIIlIIIIllIlllI);
        Gui.drawRect(lllllllllllllIllIlIIlIIIIllllIll, lllllllllllllIllIlIIlIIIIlllIIll, lllllllllllllIllIlIIlIIIIllllIll + lllllllllllllIllIlIIlIIIIllllIIl, lllllllllllllIllIlIIlIIIIlllIIll + lllllllllllllIllIlIIlIIIIlllIIII, lllllllllllllIllIlIIlIIIIlllIllI);
        Gui.drawRect(lllllllllllllIllIlIIlIIIIllllIll, lllllllllllllIllIlIIlIIIIlllIIll, lllllllllllllIllIlIIlIIIIllllIll + lllllllllllllIllIlIIlIIIIlllIIII, lllllllllllllIllIlIIlIIIIlllIIll + lllllllllllllIllIlIIlIIIIllllIII, lllllllllllllIllIlIIlIIIIlllIllI);
        Gui.drawRect(lllllllllllllIllIlIIlIIIIllllIll + lllllllllllllIllIlIIlIIIIllllIIl, lllllllllllllIllIlIIlIIIIlllIIll, lllllllllllllIllIlIIlIIIIllllIll + lllllllllllllIllIlIIlIIIIllllIIl - lllllllllllllIllIlIIlIIIIlllIIII, lllllllllllllIllIlIIlIIIIlllIIll + lllllllllllllIllIlIIlIIIIllllIII, lllllllllllllIllIlIIlIIIIlllIllI);
        Gui.drawRect(lllllllllllllIllIlIIlIIIIllllIll, lllllllllllllIllIlIIlIIIIlllIIll + lllllllllllllIllIlIIlIIIIllllIII, lllllllllllllIllIlIIlIIIIllllIll + lllllllllllllIllIlIIlIIIIllllIIl, lllllllllllllIllIlIIlIIIIlllIIll + lllllllllllllIllIlIIlIIIIllllIII - lllllllllllllIllIlIIlIIIIlllIIII, lllllllllllllIllIlIIlIIIIlllIllI);
    }
    
    public static void drawGradientSideways(final double lllllllllllllIllIlIIIlllIlIlIlII, final double lllllllllllllIllIlIIIlllIlIIIlIl, final double lllllllllllllIllIlIIIlllIlIlIIlI, final double lllllllllllllIllIlIIIlllIlIlIIIl, final int lllllllllllllIllIlIIIlllIlIlIIII, final int lllllllllllllIllIlIIIlllIlIIIIIl) {
        final float lllllllllllllIllIlIIIlllIlIIlllI = (lllllllllllllIllIlIIIlllIlIlIIII >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIlIIllIl = (lllllllllllllIllIlIIIlllIlIlIIII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIlIIllII = (lllllllllllllIllIlIIIlllIlIlIIII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIlIIlIll = (lllllllllllllIllIlIIIlllIlIlIIII & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIlIIlIlI = (lllllllllllllIllIlIIIlllIlIIIIIl >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIlIIlIIl = (lllllllllllllIllIlIIIlllIlIIIIIl >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIlIIlIII = (lllllllllllllIllIlIIIlllIlIIIIIl >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIlIIIlll = (lllllllllllllIllIlIIIlllIlIIIIIl & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glShadeModel(7425);
        GL11.glPushMatrix();
        GL11.glBegin(7);
        GL11.glColor4f(lllllllllllllIllIlIIIlllIlIIllIl, lllllllllllllIllIlIIIlllIlIIllII, lllllllllllllIllIlIIIlllIlIIlIll, lllllllllllllIllIlIIIlllIlIIlllI);
        GL11.glVertex2d(lllllllllllllIllIlIIIlllIlIlIlII, lllllllllllllIllIlIIIlllIlIIIlIl);
        GL11.glVertex2d(lllllllllllllIllIlIIIlllIlIlIlII, lllllllllllllIllIlIIIlllIlIlIIIl);
        GL11.glColor4f(lllllllllllllIllIlIIIlllIlIIlIIl, lllllllllllllIllIlIIIlllIlIIlIII, lllllllllllllIllIlIIIlllIlIIIlll, lllllllllllllIllIlIIIlllIlIIlIlI);
        GL11.glVertex2d(lllllllllllllIllIlIIIlllIlIlIIlI, lllllllllllllIllIlIIIlllIlIlIIIl);
        GL11.glVertex2d(lllllllllllllIllIlIIIlllIlIlIIlI, lllllllllllllIllIlIIIlllIlIIIlIl);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }
    
    public static int getHealthColor(final EntityLivingBase lllllllllllllIllIlIIlIIIIllIlIIl) {
        final float lllllllllllllIllIlIIlIIIIllIlIII = lllllllllllllIllIlIIlIIIIllIlIIl.getHealth();
        final float lllllllllllllIllIlIIlIIIIllIIlll = lllllllllllllIllIlIIlIIIIllIlIIl.getMaxHealth();
        final float lllllllllllllIllIlIIlIIIIllIIllI = Math.max(0.0f, Math.min(lllllllllllllIllIlIIlIIIIllIlIII, lllllllllllllIllIlIIlIIIIllIIlll) / lllllllllllllIllIlIIlIIIIllIIlll);
        return Color.HSBtoRGB(lllllllllllllIllIlIIlIIIIllIIllI / 3.0f, 1.0f, 1.0f) | 0xFF000000;
    }
    
    public static void drawRoundedRect(final float lllllllllllllIllIlIIlIIIlIIIlllI, final float lllllllllllllIllIlIIlIIIlIIIIlll, final float lllllllllllllIllIlIIlIIIlIIIllII, final float lllllllllllllIllIlIIlIIIlIIIIlIl, final int lllllllllllllIllIlIIlIIIlIIIIlII, final Color lllllllllllllIllIlIIlIIIlIIIIIll) {
        Gui.drawRect((int)lllllllllllllIllIlIIlIIIlIIIlllI + lllllllllllllIllIlIIlIIIlIIIIlII, (int)lllllllllllllIllIlIIlIIIlIIIIlll, (int)lllllllllllllIllIlIIlIIIlIIIllII - lllllllllllllIllIlIIlIIIlIIIIlII, (int)lllllllllllllIllIlIIlIIIlIIIIlIl, lllllllllllllIllIlIIlIIIlIIIIIll.getRGB());
        Gui.drawRect((int)lllllllllllllIllIlIIlIIIlIIIlllI, (int)lllllllllllllIllIlIIlIIIlIIIIlll + lllllllllllllIllIlIIlIIIlIIIIlII, (int)lllllllllllllIllIlIIlIIIlIIIllII, (int)lllllllllllllIllIlIIlIIIlIIIIlIl - lllllllllllllIllIlIIlIIIlIIIIlII, lllllllllllllIllIlIIlIIIlIIIIIll.getRGB());
        drawFilledCircle((int)lllllllllllllIllIlIIlIIIlIIIlllI + lllllllllllllIllIlIIlIIIlIIIIlII, (int)lllllllllllllIllIlIIlIIIlIIIIlll + lllllllllllllIllIlIIlIIIlIIIIlII, (float)lllllllllllllIllIlIIlIIIlIIIIlII, lllllllllllllIllIlIIlIIIlIIIIIll);
        drawFilledCircle((int)lllllllllllllIllIlIIlIIIlIIIllII - lllllllllllllIllIlIIlIIIlIIIIlII, (int)lllllllllllllIllIlIIlIIIlIIIIlll + lllllllllllllIllIlIIlIIIlIIIIlII, (float)lllllllllllllIllIlIIlIIIlIIIIlII, lllllllllllllIllIlIIlIIIlIIIIIll);
        drawFilledCircle((int)lllllllllllllIllIlIIlIIIlIIIllII - lllllllllllllIllIlIIlIIIlIIIIlII, (int)lllllllllllllIllIlIIlIIIlIIIIlIl - lllllllllllllIllIlIIlIIIlIIIIlII, (float)lllllllllllllIllIlIIlIIIlIIIIlII, lllllllllllllIllIlIIlIIIlIIIIIll);
        drawFilledCircle((int)lllllllllllllIllIlIIlIIIlIIIlllI + lllllllllllllIllIlIIlIIIlIIIIlII, (int)lllllllllllllIllIlIIlIIIlIIIIlIl - lllllllllllllIllIlIIlIIIlIIIIlII, (float)lllllllllllllIllIlIIlIIIlIIIIlII, lllllllllllllIllIlIIlIIIlIIIIIll);
    }
    
    public static int astofloc(final int lllllllllllllIllIlIIlIIIIIIIIIIl) {
        float lllllllllllllIllIlIIlIIIIIIIIIll;
        float lllllllllllllIllIlIIlIIIIIIIIIlI;
        for (lllllllllllllIllIlIIlIIIIIIIIIll = 3200.0f, lllllllllllllIllIlIIlIIIIIIIIIlI = System.currentTimeMillis() % (int)lllllllllllllIllIlIIlIIIIIIIIIll + (float)(lllllllllllllIllIlIIlIIIIIIIIIIl / 2); lllllllllllllIllIlIIlIIIIIIIIIlI > lllllllllllllIllIlIIlIIIIIIIIIll; lllllllllllllIllIlIIlIIIIIIIIIlI -= lllllllllllllIllIlIIlIIIIIIIIIll) {}
        lllllllllllllIllIlIIlIIIIIIIIIlI /= lllllllllllllIllIlIIlIIIIIIIIIll;
        if (lllllllllllllIllIlIIlIIIIIIIIIlI > 0.5) {
            lllllllllllllIllIlIIlIIIIIIIIIlI = 0.5f - lllllllllllllIllIlIIlIIIIIIIIIlI - 0.5f;
        }
        lllllllllllllIllIlIIlIIIIIIIIIlI += 0.5f;
        return Color.HSBtoRGB(lllllllllllllIllIlIIlIIIIIIIIIlI, 0.5f, 1.0f);
    }
    
    public static void drawRect(double lllllllllllllIllIlIIIlllIIlIIIII, double lllllllllllllIllIlIIIlllIIIlllll, double lllllllllllllIllIlIIIlllIIIllllI, double lllllllllllllIllIlIIIlllIIIlllIl, final int lllllllllllllIllIlIIIlllIIIlllII) {
        if (lllllllllllllIllIlIIIlllIIlIIIII < lllllllllllllIllIlIIIlllIIIllllI) {
            final double lllllllllllllIllIlIIIlllIIlIlIII = lllllllllllllIllIlIIIlllIIlIIIII;
            lllllllllllllIllIlIIIlllIIlIIIII = lllllllllllllIllIlIIIlllIIIllllI;
            lllllllllllllIllIlIIIlllIIIllllI = lllllllllllllIllIlIIIlllIIlIlIII;
        }
        if (lllllllllllllIllIlIIIlllIIIlllll < lllllllllllllIllIlIIIlllIIIlllIl) {
            final double lllllllllllllIllIlIIIlllIIlIIlll = lllllllllllllIllIlIIIlllIIIlllll;
            lllllllllllllIllIlIIIlllIIIlllll = lllllllllllllIllIlIIIlllIIIlllIl;
            lllllllllllllIllIlIIIlllIIIlllIl = lllllllllllllIllIlIIIlllIIlIIlll;
        }
        final float lllllllllllllIllIlIIIlllIIlIIllI = (lllllllllllllIllIlIIIlllIIIlllII >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIIlIIlIl = (lllllllllllllIllIlIIIlllIIIlllII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIIlIIlII = (lllllllllllllIllIlIIIlllIIIlllII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIIlIIIll = (lllllllllllllIllIlIIIlllIIIlllII & 0xFF) / 255.0f;
        final Tessellator lllllllllllllIllIlIIIlllIIlIIIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIllIlIIIlllIIlIIIIl = lllllllllllllIllIlIIIlllIIlIIIlI.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(lllllllllllllIllIlIIIlllIIlIIlIl, lllllllllllllIllIlIIIlllIIlIIlII, lllllllllllllIllIlIIIlllIIlIIIll, lllllllllllllIllIlIIIlllIIlIIllI);
        lllllllllllllIllIlIIIlllIIlIIIIl.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIIlllIIlIIIIl.pos(lllllllllllllIllIlIIIlllIIlIIIII, lllllllllllllIllIlIIIlllIIIlllIl, 0.0).endVertex();
        lllllllllllllIllIlIIIlllIIlIIIIl.pos(lllllllllllllIllIlIIIlllIIIllllI, lllllllllllllIllIlIIIlllIIIlllIl, 0.0).endVertex();
        lllllllllllllIllIlIIIlllIIlIIIIl.pos(lllllllllllllIllIlIIIlllIIIllllI, lllllllllllllIllIlIIIlllIIIlllll, 0.0).endVertex();
        lllllllllllllIllIlIIIlllIIlIIIIl.pos(lllllllllllllIllIlIIIlllIIlIIIII, lllllllllllllIllIlIIIlllIIIlllll, 0.0).endVertex();
        lllllllllllllIllIlIIIlllIIlIIIlI.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public static void renderEntityBoundingBox(final Entity lllllllllllllIllIlIIlIIllIIlIllI, final Color lllllllllllllIllIlIIlIIllIIlIlIl, final float lllllllllllllIllIlIIlIIllIIlIIIl) {
        renderEntityBoundingBox(lllllllllllllIllIlIIlIIllIIlIllI, lllllllllllllIllIlIIlIIllIIlIlIl.getRed() / 255.0f, lllllllllllllIllIlIIlIIllIIlIlIl.getGreen() / 255.0f, lllllllllllllIllIlIIlIIllIIlIlIl.getBlue() / 255.0f, lllllllllllllIllIlIIlIIllIIlIIIl);
    }
    
    public static void disableGL2D() {
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    public static void drawRect(final float lllllllllllllIllIlIIIllllIIIIIlI, final float lllllllllllllIllIlIIIllllIIIIllI, final float lllllllllllllIllIlIIIllllIIIIlIl, final float lllllllllllllIllIlIIIlllIlllllll, final int lllllllllllllIllIlIIIllllIIIIIll) {
        enableGL2D();
        setColor(lllllllllllllIllIlIIIllllIIIIIll);
        drawRect(lllllllllllllIllIlIIIllllIIIIIlI, lllllllllllllIllIlIIIllllIIIIllI, lllllllllllllIllIlIIIllllIIIIlIl, lllllllllllllIllIlIIIlllIlllllll);
        disableGL2D();
    }
    
    public static void disableGL2D1() {
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public static void drawOutlinedBoundingBox(final AxisAlignedBB lllllllllllllIllIlIIIllIIllIlIIl) {
        final Tessellator lllllllllllllIllIlIIIllIIllIlIII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIllIlIIIllIIllIIlll = lllllllllllllIllIlIIIllIIllIlIII.getBuffer();
        lllllllllllllIllIlIIIllIIllIIlll.begin(3, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.minY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.maxX, lllllllllllllIllIlIIIllIIllIlIIl.minY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.maxX, lllllllllllllIllIlIIIllIIllIlIIl.minY, lllllllllllllIllIlIIIllIIllIlIIl.maxZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.minY, lllllllllllllIllIlIIIllIIllIlIIl.maxZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.minY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIlIII.draw();
        lllllllllllllIllIlIIIllIIllIIlll.begin(3, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.maxY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.maxX, lllllllllllllIllIlIIIllIIllIlIIl.maxY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.maxX, lllllllllllllIllIlIIIllIIllIlIIl.maxY, lllllllllllllIllIlIIIllIIllIlIIl.maxZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.maxY, lllllllllllllIllIlIIIllIIllIlIIl.maxZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.maxY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIlIII.draw();
        lllllllllllllIllIlIIIllIIllIIlll.begin(1, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.minY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.maxY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.maxX, lllllllllllllIllIlIIIllIIllIlIIl.minY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.maxX, lllllllllllllIllIlIIIllIIllIlIIl.maxY, lllllllllllllIllIlIIIllIIllIlIIl.minZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.maxX, lllllllllllllIllIlIIIllIIllIlIIl.minY, lllllllllllllIllIlIIIllIIllIlIIl.maxZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.maxX, lllllllllllllIllIlIIIllIIllIlIIl.maxY, lllllllllllllIllIlIIIllIIllIlIIl.maxZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.minY, lllllllllllllIllIlIIIllIIllIlIIl.maxZ).endVertex();
        lllllllllllllIllIlIIIllIIllIIlll.pos(lllllllllllllIllIlIIIllIIllIlIIl.minX, lllllllllllllIllIlIIIllIIllIlIIl.maxY, lllllllllllllIllIlIIIllIIllIlIIl.maxZ).endVertex();
        lllllllllllllIllIlIIIllIIllIlIII.draw();
    }
    
    public static Color effect(final long lllllllllllllIllIlIIIllIIllllIII, final float lllllllllllllIllIlIIIllIIlllIlll, final int lllllllllllllIllIlIIIllIIlllIllI) {
        final float lllllllllllllIllIlIIIllIIlllIlIl = (System.nanoTime() + lllllllllllllIllIlIIIllIIllllIII * lllllllllllllIllIlIIIllIIlllIllI) / 1.0E10f % 1.0f;
        final long lllllllllllllIllIlIIIllIIlllIlII = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(lllllllllllllIllIlIIIllIIlllIlIl, lllllllllllllIllIlIIIllIIlllIlll, 1.0f)), 16);
        final Color lllllllllllllIllIlIIIllIIlllIIll = new Color((int)lllllllllllllIllIlIIIllIIlllIlII);
        return new Color(lllllllllllllIllIlIIIllIIlllIIll.getRed() / 255.0f, lllllllllllllIllIlIIIllIIlllIIll.getGreen() / 255.0f, lllllllllllllIllIlIIIllIIlllIIll.getBlue() / 255.0f, lllllllllllllIllIlIIIllIIlllIIll.getAlpha() / 255.0f);
    }
    
    public static void drawRoundedRect2(final int lllllllllllllIllIlIIlIIIIIIlllII, final int lllllllllllllIllIlIIlIIIIIIlIlIl, final int lllllllllllllIllIlIIlIIIIIIlIlII, final int lllllllllllllIllIlIIlIIIIIIllIIl, final int lllllllllllllIllIlIIlIIIIIIlIIlI, final Color lllllllllllllIllIlIIlIIIIIIlIlll) {
        Gui.drawRect(lllllllllllllIllIlIIlIIIIIIlllII, lllllllllllllIllIlIIlIIIIIIlIlIl + lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlllII + lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlIl + lllllllllllllIllIlIIlIIIIIIllIIl - lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlll.getRGB());
        Gui.drawRect(lllllllllllllIllIlIIlIIIIIIlllII + lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlIl, lllllllllllllIllIlIIlIIIIIIlllII + lllllllllllllIllIlIIlIIIIIIlIlII - lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlIl + lllllllllllllIllIlIIlIIIIIIllIIl, lllllllllllllIllIlIIlIIIIIIlIlll.getRGB());
        Gui.drawRect(lllllllllllllIllIlIIlIIIIIIlllII + lllllllllllllIllIlIIlIIIIIIlIlII - lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlIl + lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlllII + lllllllllllllIllIlIIlIIIIIIlIlII, lllllllllllllIllIlIIlIIIIIIlIlIl + lllllllllllllIllIlIIlIIIIIIllIIl - lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlll.getRGB());
        drawArc(lllllllllllllIllIlIIlIIIIIIlllII + lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlIl + lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIIlI, 0, 90, lllllllllllllIllIlIIlIIIIIIlIlll);
        drawArc(lllllllllllllIllIlIIlIIIIIIlllII + lllllllllllllIllIlIIlIIIIIIlIlII - lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlIl + lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIIlI, 270, 360, lllllllllllllIllIlIIlIIIIIIlIlll);
        drawArc(lllllllllllllIllIlIIlIIIIIIlllII + lllllllllllllIllIlIIlIIIIIIlIlII - lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlIl + lllllllllllllIllIlIIlIIIIIIllIIl - lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIIlI, 180, 270, lllllllllllllIllIlIIlIIIIIIlIlll);
        drawArc(lllllllllllllIllIlIIlIIIIIIlllII + lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIlIl + lllllllllllllIllIlIIlIIIIIIllIIl - lllllllllllllIllIlIIlIIIIIIlIIlI, lllllllllllllIllIlIIlIIIIIIlIIlI, 90, 180, lllllllllllllIllIlIIlIIIIIIlIlll);
    }
    
    public static void drawItem(final int lllllllllllllIllIlIIIlllllIIIIll, final int lllllllllllllIllIlIIIlllllIIlIIl, final float lllllllllllllIllIlIIIlllllIIlIII, final EntityPlayer lllllllllllllIllIlIIIlllllIIIIII, final ItemStack lllllllllllllIllIlIIIllllIllllll) {
        final Method lllllllllllllIllIlIIIlllllIIIlIl = getMethods(GuiIngame.class, Integer.TYPE, Integer.TYPE, Float.TYPE, EntityPlayer.class, ItemStack.class)[0];
        lllllllllllllIllIlIIIlllllIIIlIl.setAccessible(true);
        try {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderHelper.enableGUIStandardItemLighting();
            lllllllllllllIllIlIIIlllllIIIlIl.invoke(Minecraft.getMinecraft().ingameGUI, lllllllllllllIllIlIIIlllllIIIIll, lllllllllllllIllIlIIIlllllIIlIIl, lllllllllllllIllIlIIIlllllIIlIII, lllllllllllllIllIlIIIlllllIIIIII, lllllllllllllIllIlIIIllllIllllll);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
        catch (IllegalAccessException | InvocationTargetException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIllIlIIIlllllIIIlII = ex;
            lllllllllllllIllIlIIIlllllIIIlII.printStackTrace();
        }
    }
    
    public static int setColor(final int lllllllllllllIllIlIIIlllIllIIlll) {
        final float lllllllllllllIllIlIIIlllIllIlIll = (lllllllllllllIllIlIIIlllIllIIlll >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIllIlIlI = (lllllllllllllIllIlIIIlllIllIIlll >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIllIlIIl = (lllllllllllllIllIlIIIlllIllIIlll >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIllIlIII = (lllllllllllllIllIlIIIlllIllIIlll & 0xFF) / 255.0f;
        GL11.glColor4f(lllllllllllllIllIlIIIlllIllIlIlI, lllllllllllllIllIlIIIlllIllIlIIl, lllllllllllllIllIlIIIlllIllIlIII, (lllllllllllllIllIlIIIlllIllIlIll == 0.0f) ? 1.0f : lllllllllllllIllIlIIIlllIllIlIll);
        return lllllllllllllIllIlIIIlllIllIIlll;
    }
    
    public static void rectangleBordered(final double lllllllllllllIllIlIIlIIlIIIlllll, final double lllllllllllllIllIlIIlIIlIIlIIlIl, final double lllllllllllllIllIlIIlIIlIIlIIlII, final double lllllllllllllIllIlIIlIIlIIIlllII, final double lllllllllllllIllIlIIlIIlIIlIIIlI, final int lllllllllllllIllIlIIlIIlIIlIIIIl, final int lllllllllllllIllIlIIlIIlIIIllIIl) {
        drawRect(lllllllllllllIllIlIIlIIlIIIlllll + lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIlIIlIl + lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIlIIlII - lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIIlllII - lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIlIIIIl);
        drawRect(lllllllllllllIllIlIIlIIlIIIlllll + lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIlIIlIl, lllllllllllllIllIlIIlIIlIIlIIlII - lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIlIIlIl + lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIIllIIl);
        drawRect(lllllllllllllIllIlIIlIIlIIIlllll, lllllllllllllIllIlIIlIIlIIlIIlIl, lllllllllllllIllIlIIlIIlIIIlllll + lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIIlllII, lllllllllllllIllIlIIlIIlIIIllIIl);
        drawRect(lllllllllllllIllIlIIlIIlIIlIIlII - lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIlIIlIl, lllllllllllllIllIlIIlIIlIIlIIlII, lllllllllllllIllIlIIlIIlIIIlllII, lllllllllllllIllIlIIlIIlIIIllIIl);
        drawRect(lllllllllllllIllIlIIlIIlIIIlllll + lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIIlllII - lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIlIIlII - lllllllllllllIllIlIIlIIlIIlIIIlI, lllllllllllllIllIlIIlIIlIIIlllII, lllllllllllllIllIlIIlIIlIIIllIIl);
    }
    
    public static void prepareScissorBox(final float lllllllllllllIllIlIIIllllllllIII, final float lllllllllllllIllIlIIIlllllllIIIl, final float lllllllllllllIllIlIIIlllllllIIII, final float lllllllllllllIllIlIIIllllllIllll) {
        final ScaledResolution lllllllllllllIllIlIIIlllllllIlII = new ScaledResolution(Minecraft.getMinecraft());
        final int lllllllllllllIllIlIIIlllllllIIll = lllllllllllllIllIlIIIlllllllIlII.getScaleFactor();
        GL11.glScissor((int)(lllllllllllllIllIlIIIllllllllIII * lllllllllllllIllIlIIIlllllllIIll), (int)((lllllllllllllIllIlIIIlllllllIlII.getScaledHeight() - lllllllllllllIllIlIIIllllllIllll) * lllllllllllllIllIlIIIlllllllIIll), (int)((lllllllllllllIllIlIIIlllllllIIII - lllllllllllllIllIlIIIllllllllIII) * lllllllllllllIllIlIIIlllllllIIll), (int)((lllllllllllllIllIlIIIllllllIllll - lllllllllllllIllIlIIIlllllllIIIl) * lllllllllllllIllIlIIIlllllllIIll));
    }
    
    public static void drawFilledCircle(final int lllllllllllllIllIlIIlIIIIlIIllll, final int lllllllllllllIllIlIIlIIIIlIIlllI, final float lllllllllllllIllIlIIlIIIIlIIllIl, final Color lllllllllllllIllIlIIlIIIIlIlIlIl) {
        final int lllllllllllllIllIlIIlIIIIlIlIlII = 50;
        final double lllllllllllllIllIlIIlIIIIlIlIIll = 6.283185307179586 / lllllllllllllIllIlIIlIIIIlIlIlII;
        GL11.glPushAttrib(8192);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glBegin(6);
        for (int lllllllllllllIllIlIIlIIIIlIlIIlI = 0; lllllllllllllIllIlIIlIIIIlIlIIlI < lllllllllllllIllIlIIlIIIIlIlIlII; ++lllllllllllllIllIlIIlIIIIlIlIIlI) {
            final float lllllllllllllIllIlIIlIIIIlIlIIIl = (float)(lllllllllllllIllIlIIlIIIIlIIllIl * Math.sin(lllllllllllllIllIlIIlIIIIlIlIIlI * lllllllllllllIllIlIIlIIIIlIlIIll));
            final float lllllllllllllIllIlIIlIIIIlIlIIII = (float)(lllllllllllllIllIlIIlIIIIlIIllIl * Math.cos(lllllllllllllIllIlIIlIIIIlIlIIlI * lllllllllllllIllIlIIlIIIIlIlIIll));
            GL11.glColor4f(lllllllllllllIllIlIIlIIIIlIlIlIl.getRed() / 255.0f, lllllllllllllIllIlIIlIIIIlIlIlIl.getGreen() / 255.0f, lllllllllllllIllIlIIlIIIIlIlIlIl.getBlue() / 255.0f, lllllllllllllIllIlIIlIIIIlIlIlIl.getAlpha() / 255.0f);
            GL11.glVertex2f(lllllllllllllIllIlIIlIIIIlIIllll + lllllllllllllIllIlIIlIIIIlIlIIIl, lllllllllllllIllIlIIlIIIIlIIlllI + lllllllllllllIllIlIIlIIIIlIlIIII);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnd();
        GL11.glPopAttrib();
    }
    
    public static void drawFillRectangle(final double lllllllllllllIllIlIIlIIIllIIlIII, final double lllllllllllllIllIlIIlIIIllIIIlll, final double lllllllllllllIllIlIIlIIIllIIlIlI, final double lllllllllllllIllIlIIlIIIllIIIlIl) {
        GlStateManager.enableBlend();
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glBegin(7);
        GL11.glVertex2d(lllllllllllllIllIlIIlIIIllIIlIII, lllllllllllllIllIlIIlIIIllIIIlll + lllllllllllllIllIlIIlIIIllIIIlIl);
        GL11.glVertex2d(lllllllllllllIllIlIIlIIIllIIlIII + lllllllllllllIllIlIIlIIIllIIlIlI, lllllllllllllIllIlIIlIIIllIIIlll + lllllllllllllIllIlIIlIIIllIIIlIl);
        GL11.glVertex2d(lllllllllllllIllIlIIlIIIllIIlIII + lllllllllllllIllIlIIlIIIllIIlIlI, lllllllllllllIllIlIIlIIIllIIIlll);
        GL11.glVertex2d(lllllllllllllIllIlIIlIIIllIIlIII, lllllllllllllIllIlIIlIIIllIIIlll);
        GL11.glEnd();
    }
    
    public static void drawSelectionBoundingBox(final AxisAlignedBB lllllllllllllIllIlIIlIIIllIIIIIl) {
        final Tessellator lllllllllllllIllIlIIlIIIllIIIIII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIllIlIIlIIIlIllllll = lllllllllllllIllIlIIlIIIllIIIIII.getBuffer();
        lllllllllllllIllIlIIlIIIlIllllll.begin(3, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.minY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.maxX, lllllllllllllIllIlIIlIIIllIIIIIl.minY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.maxX, lllllllllllllIllIlIIlIIIllIIIIIl.minY, lllllllllllllIllIlIIlIIIllIIIIIl.maxZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.minY, lllllllllllllIllIlIIlIIIllIIIIIl.maxZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.minY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIllIIIIII.draw();
        lllllllllllllIllIlIIlIIIlIllllll.begin(3, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.maxY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.maxX, lllllllllllllIllIlIIlIIIllIIIIIl.maxY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.maxX, lllllllllllllIllIlIIlIIIllIIIIIl.maxY, lllllllllllllIllIlIIlIIIllIIIIIl.maxZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.maxY, lllllllllllllIllIlIIlIIIllIIIIIl.maxZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.maxY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIllIIIIII.draw();
        lllllllllllllIllIlIIlIIIlIllllll.begin(1, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.minY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.maxY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.maxX, lllllllllllllIllIlIIlIIIllIIIIIl.minY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.maxX, lllllllllllllIllIlIIlIIIllIIIIIl.maxY, lllllllllllllIllIlIIlIIIllIIIIIl.minZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.maxX, lllllllllllllIllIlIIlIIIllIIIIIl.minY, lllllllllllllIllIlIIlIIIllIIIIIl.maxZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.maxX, lllllllllllllIllIlIIlIIIllIIIIIl.maxY, lllllllllllllIllIlIIlIIIllIIIIIl.maxZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.minY, lllllllllllllIllIlIIlIIIllIIIIIl.maxZ).endVertex();
        lllllllllllllIllIlIIlIIIlIllllll.pos(lllllllllllllIllIlIIlIIIllIIIIIl.minX, lllllllllllllIllIlIIlIIIllIIIIIl.maxY, lllllllllllllIllIlIIlIIIllIIIIIl.maxZ).endVertex();
        lllllllllllllIllIlIIlIIIllIIIIII.draw();
    }
    
    public static void drawFilledBox(final AxisAlignedBB lllllllllllllIllIlIIlIIlIIIlIIlI) {
        final Tessellator lllllllllllllIllIlIIlIIlIIIlIlII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIllIlIIlIIlIIIlIIll = lllllllllllllIllIlIIlIIlIIIlIlII.getBuffer();
        lllllllllllllIllIlIIlIIlIIIlIIll.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIlII.draw();
        lllllllllllllIllIlIIlIIlIIIlIIll.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIlII.draw();
        lllllllllllllIllIlIIlIIlIIIlIIll.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIlII.draw();
        lllllllllllllIllIlIIlIIlIIIlIIll.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIlII.draw();
        lllllllllllllIllIlIIlIIlIIIlIIll.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIlII.draw();
        lllllllllllllIllIlIIlIIlIIIlIIll.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.minX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.minZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.maxY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIIll.pos(lllllllllllllIllIlIIlIIlIIIlIIlI.maxX, lllllllllllllIllIlIIlIIlIIIlIIlI.minY, lllllllllllllIllIlIIlIIlIIIlIIlI.maxZ).endVertex();
        lllllllllllllIllIlIIlIIlIIIlIlII.draw();
    }
    
    public static void drawCirclePart(final double lllllllllllllIllIlIIlIIIlllIllIl, final double lllllllllllllIllIlIIlIIIllllIlll, final float lllllllllllllIllIlIIlIIIlllIlIll, final float lllllllllllllIllIlIIlIIIlllIlIlI, final float lllllllllllllIllIlIIlIIIllllIlII, final int lllllllllllllIllIlIIlIIIlllIlIII) {
        GlStateManager.enableBlend();
        GL11.glBegin(6);
        GL11.glVertex2d(lllllllllllllIllIlIIlIIIlllIllIl, lllllllllllllIllIlIIlIIIllllIlll);
        final float lllllllllllllIllIlIIlIIIllllIIlI = (lllllllllllllIllIlIIlIIIlllIlIlI - lllllllllllllIllIlIIlIIIlllIlIll) / lllllllllllllIllIlIIlIIIlllIlIII;
        for (int lllllllllllllIllIlIIlIIIllllIIIl = 0; lllllllllllllIllIlIIlIIIllllIIIl <= lllllllllllllIllIlIIlIIIlllIlIII; ++lllllllllllllIllIlIIlIIIllllIIIl) {
            final float lllllllllllllIllIlIIlIIIllllIIII = lllllllllllllIllIlIIlIIIlllIlIll + lllllllllllllIllIlIIlIIIllllIIIl * lllllllllllllIllIlIIlIIIllllIIlI;
            final float lllllllllllllIllIlIIlIIIlllIllll = MathHelper.sin(lllllllllllllIllIlIIlIIIllllIIII);
            final float lllllllllllllIllIlIIlIIIlllIlllI = MathHelper.cos(lllllllllllllIllIlIIlIIIllllIIII);
            GL11.glVertex2d(lllllllllllllIllIlIIlIIIlllIllIl + lllllllllllllIllIlIIlIIIlllIllll * lllllllllllllIllIlIIlIIIllllIlII, lllllllllllllIllIlIIlIIIllllIlll + lllllllllllllIllIlIIlIIIlllIlllI * lllllllllllllIllIlIIlIIIllllIlII);
        }
        GL11.glEnd();
    }
    
    public static void drawRectWithEdge(final double lllllllllllllIllIlIIlIIIIIllIIII, final double lllllllllllllIllIlIIlIIIIIlIllll, final double lllllllllllllIllIlIIlIIIIIlIlllI, final double lllllllllllllIllIlIIlIIIIIlIllIl, final Color lllllllllllllIllIlIIlIIIIIlIIlIl, final Color lllllllllllllIllIlIIlIIIIIlIIlII) {
        drawRect(lllllllllllllIllIlIIlIIIIIllIIII, lllllllllllllIllIlIIlIIIIIlIllll, lllllllllllllIllIlIIlIIIIIllIIII + lllllllllllllIllIlIIlIIIIIlIlllI, lllllllllllllIllIlIIlIIIIIlIllll + lllllllllllllIllIlIIlIIIIIlIllIl, lllllllllllllIllIlIIlIIIIIlIIlIl.getRGB());
        final int lllllllllllllIllIlIIlIIIIIlIlIlI = lllllllllllllIllIlIIlIIIIIlIIlII.getRGB();
        drawRect(lllllllllllllIllIlIIlIIIIIllIIII - 1.0, lllllllllllllIllIlIIlIIIIIlIllll, lllllllllllllIllIlIIlIIIIIllIIII, lllllllllllllIllIlIIlIIIIIlIllll + lllllllllllllIllIlIIlIIIIIlIllIl, lllllllllllllIllIlIIlIIIIIlIlIlI);
        drawRect(lllllllllllllIllIlIIlIIIIIllIIII + lllllllllllllIllIlIIlIIIIIlIlllI, lllllllllllllIllIlIIlIIIIIlIllll, lllllllllllllIllIlIIlIIIIIllIIII + lllllllllllllIllIlIIlIIIIIlIlllI + 1.0, lllllllllllllIllIlIIlIIIIIlIllll + lllllllllllllIllIlIIlIIIIIlIllIl, lllllllllllllIllIlIIlIIIIIlIlIlI);
        drawRect(lllllllllllllIllIlIIlIIIIIllIIII - 1.0, lllllllllllllIllIlIIlIIIIIlIllll - 1.0, lllllllllllllIllIlIIlIIIIIllIIII + lllllllllllllIllIlIIlIIIIIlIlllI + 1.0, lllllllllllllIllIlIIlIIIIIlIllll, lllllllllllllIllIlIIlIIIIIlIlIlI);
        drawRect(lllllllllllllIllIlIIlIIIIIllIIII - 1.0, lllllllllllllIllIlIIlIIIIIlIllll + lllllllllllllIllIlIIlIIIIIlIllIl, lllllllllllllIllIlIIlIIIIIllIIII + lllllllllllllIllIlIIlIIIIIlIlllI + 1.0, lllllllllllllIllIlIIlIIIIIlIllll + lllllllllllllIllIlIIlIIIIIlIllIl + 1.0, lllllllllllllIllIlIIlIIIIIlIlIlI);
    }
    
    public static void stopDrawing() {
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
    
    public static double interpolate(final double lllllllllllllIllIlIIIllIllIIlIIl, final double lllllllllllllIllIlIIIllIllIIIlIl, final double lllllllllllllIllIlIIIllIllIIIlll) {
        return lllllllllllllIllIlIIIllIllIIIlIl + (lllllllllllllIllIlIIIllIllIIlIIl - lllllllllllllIllIlIIIllIllIIIlIl) * lllllllllllllIllIlIIIllIllIIIlll;
    }
    
    public static void drawHead(final ResourceLocation lllllllllllllIllIlIIlIIIIIIIllIl, final int lllllllllllllIllIlIIlIIIIIIIllII, final int lllllllllllllIllIlIIlIIIIIIIlIll) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(lllllllllllllIllIlIIlIIIIIIIllIl);
        Gui.drawScaledCustomSizeModalRect(lllllllllllllIllIlIIlIIIIIIIllII, lllllllllllllIllIlIIlIIIIIIIlIll, 8.0f, 8.0f, 8, 8, 45, 45, 64.0f, 64.0f);
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
    
    public static void drawESP(final double lllllllllllllIllIlIIlIIIlIIllIlI, final double lllllllllllllIllIlIIlIIIlIIlllll, final double lllllllllllllIllIlIIlIIIlIIllllI, final double lllllllllllllIllIlIIlIIIlIIlIlll, final double lllllllllllllIllIlIIlIIIlIIlllII, final double lllllllllllllIllIlIIlIIIlIIllIll) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glLineWidth(1.5f);
        GL11.glDisable(2896);
        GL11.glDisable(3553);
        GL11.glLineWidth(1.0f);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4d(lllllllllllllIllIlIIlIIIlIIlIlll, lllllllllllllIllIlIIlIIIlIIllIll, lllllllllllllIllIlIIlIIIlIIlllII, 0.18250000476837158);
        drawColorBox(new AxisAlignedBB(lllllllllllllIllIlIIlIIIlIIllIlI, lllllllllllllIllIlIIlIIIlIIlllll, lllllllllllllIllIlIIlIIIlIIllllI, lllllllllllllIllIlIIlIIIlIIllIlI + 1.0, lllllllllllllIllIlIIlIIIlIIlllll + 1.0, lllllllllllllIllIlIIlIIIlIIllllI + 1.0), 0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glColor4d(0.0, 0.0, 0.0, 0.5);
        drawSelectionBoundingBox(new AxisAlignedBB(lllllllllllllIllIlIIlIIIlIIllIlI, lllllllllllllIllIlIIlIIIlIIlllll, lllllllllllllIllIlIIlIIIlIIllllI, lllllllllllllIllIlIIlIIIlIIllIlI + 1.0, lllllllllllllIllIlIIlIIIlIIlllll + 1.0, lllllllllllllIllIlIIlIIIlIIllllI + 1.0));
        GL11.glLineWidth(2.0f);
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static int rainbow(final int lllllllllllllIllIlIIlIIlIIllIIll, final double lllllllllllllIllIlIIlIIlIIlIllll) {
        double lllllllllllllIllIlIIlIIlIIllIIIl = Math.ceil((System.currentTimeMillis() + lllllllllllllIllIlIIlIIlIIllIIll) / lllllllllllllIllIlIIlIIlIIlIllll);
        lllllllllllllIllIlIIlIIlIIllIIIl %= 360.0;
        return Color.getHSBColor((float)(-(lllllllllllllIllIlIIlIIlIIllIIIl / 360.0)), 0.9f, 1.0f).getRGB();
    }
    
    public static void drawArc(final int lllllllllllllIllIlIIIllllllIIIll, final int lllllllllllllIllIlIIIlllllIllIIl, final int lllllllllllllIllIlIIIlllllIllIII, final int lllllllllllllIllIlIIIlllllIlIlll, final int lllllllllllllIllIlIIIlllllIlIllI, final Color lllllllllllllIllIlIIIlllllIllllI) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(lllllllllllllIllIlIIIlllllIllllI.getRed() / 255.0f, lllllllllllllIllIlIIIlllllIllllI.getGreen() / 255.0f, lllllllllllllIllIlIIIlllllIllllI.getBlue() / 255.0f, lllllllllllllIllIlIIIlllllIllllI.getAlpha() / 255.0f);
        final BufferBuilder lllllllllllllIllIlIIIlllllIlllIl = Tessellator.getInstance().getBuffer();
        lllllllllllllIllIlIIIlllllIlllIl.begin(6, DefaultVertexFormats.POSITION);
        lllllllllllllIllIlIIIlllllIlllIl.pos(lllllllllllllIllIlIIIllllllIIIll, lllllllllllllIllIlIIIlllllIllIIl, 0.0).endVertex();
        for (int lllllllllllllIllIlIIIlllllIlllII = (int)(lllllllllllllIllIlIIIlllllIlIlll / 360.0 * 100.0); lllllllllllllIllIlIIIlllllIlllII <= (int)(lllllllllllllIllIlIIIlllllIlIllI / 360.0 * 100.0); ++lllllllllllllIllIlIIIlllllIlllII) {
            final double lllllllllllllIllIlIIIlllllIllIll = 6.283185307179586 * lllllllllllllIllIlIIIlllllIlllII / 100.0 + Math.toRadians(180.0);
            lllllllllllllIllIlIIIlllllIlllIl.pos(lllllllllllllIllIlIIIllllllIIIll + Math.sin(lllllllllllllIllIlIIIlllllIllIll) * lllllllllllllIllIlIIIlllllIllIII, lllllllllllllIllIlIIIlllllIllIIl + Math.cos(lllllllllllllIllIlIIIlllllIllIll) * lllllllllllllIllIlIIIlllllIllIII, 0.0).endVertex();
        }
        Tessellator.getInstance().draw();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static void startSmooth() {
        GL11.glEnable(2848);
        GL11.glEnable(2881);
        GL11.glEnable(2832);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
        GL11.glHint(3153, 4354);
    }
    
    public static void drawColorBox(final AxisAlignedBB lllllllllllllIllIlIIlIIIlIlIllIl, final float lllllllllllllIllIlIIlIIIlIllIIll, final float lllllllllllllIllIlIIlIIIlIlIlIll, final float lllllllllllllIllIlIIlIIIlIlIlIlI, final float lllllllllllllIllIlIIlIIIlIllIIII) {
        final Tessellator lllllllllllllIllIlIIlIIIlIlIllll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIllIlIIlIIIlIlIlllI = lllllllllllllIllIlIIlIIIlIlIllll.getBuffer();
        lllllllllllllIllIlIIlIIIlIlIlllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIllll.draw();
        lllllllllllllIllIlIIlIIIlIlIlllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIllll.draw();
        lllllllllllllIllIlIIlIIIlIlIlllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIllll.draw();
        lllllllllllllIllIlIIlIIIlIlIlllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIllll.draw();
        lllllllllllllIllIlIIlIIIlIlIlllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIllll.draw();
        lllllllllllllIllIlIIlIIIlIlIlllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.minX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.minZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.maxY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIlllI.pos(lllllllllllllIllIlIIlIIIlIlIllIl.maxX, lllllllllllllIllIlIIlIIIlIlIllIl.minY, lllllllllllllIllIlIIlIIIlIlIllIl.maxZ).color(lllllllllllllIllIlIIlIIIlIllIIll, lllllllllllllIllIlIIlIIIlIlIlIll, lllllllllllllIllIlIIlIIIlIlIlIlI, lllllllllllllIllIlIIlIIIlIllIIII).endVertex();
        lllllllllllllIllIlIIlIIIlIlIllll.draw();
    }
    
    public static void startDrawing() {
        GL11.glEnable(3042);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        RenderUtils.mc.entityRenderer.setupCameraTransform(RenderUtils.mc.timer.renderPartialTicks, 0);
    }
    
    public static void drawRect1(final float lllllllllllllIllIlIIIlllIIIIIIll, final float lllllllllllllIllIlIIIlllIIIIlIll, final float lllllllllllllIllIlIIIlllIIIIIIIl, final float lllllllllllllIllIlIIIlllIIIIlIIl, final int lllllllllllllIllIlIIIlllIIIIlIII) {
        final float lllllllllllllIllIlIIIlllIIIIIlll = (lllllllllllllIllIlIIIlllIIIIlIII >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIIIIIllI = (lllllllllllllIllIlIIIlllIIIIlIII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIIIIIlIl = (lllllllllllllIllIlIIIlllIIIIlIII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIlllIIIIIlII = (lllllllllllllIllIlIIIlllIIIIlIII & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glColor4f(lllllllllllllIllIlIIIlllIIIIIllI, lllllllllllllIllIlIIIlllIIIIIlIl, lllllllllllllIllIlIIIlllIIIIIlII, lllllllllllllIllIlIIIlllIIIIIlll);
        GL11.glBegin(7);
        GL11.glVertex2d((double)lllllllllllllIllIlIIIlllIIIIIIIl, (double)lllllllllllllIllIlIIIlllIIIIlIll);
        GL11.glVertex2d((double)lllllllllllllIllIlIIIlllIIIIIIll, (double)lllllllllllllIllIlIIIlllIIIIlIll);
        GL11.glVertex2d((double)lllllllllllllIllIlIIIlllIIIIIIll, (double)lllllllllllllIllIlIIIlllIIIIlIIl);
        GL11.glVertex2d((double)lllllllllllllIllIlIIIlllIIIIIIIl, (double)lllllllllllllIllIlIIIlllIIIIlIIl);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
    
    private static boolean isInViewFrustrum(final AxisAlignedBB lllllllllllllIllIlIIIllIllIIlllI) {
        final Entity lllllllllllllIllIlIIIllIllIIllll = Minecraft.getMinecraft().getRenderViewEntity();
        RenderUtils.frustrum.setPosition(lllllllllllllIllIlIIIllIllIIllll.posX, lllllllllllllIllIlIIIllIllIIllll.posY, lllllllllllllIllIlIIIllIllIIllll.posZ);
        return RenderUtils.frustrum.isBoundingBoxInFrustum(lllllllllllllIllIlIIIllIllIIlllI);
    }
    
    public static double animate(final double lllllllllllllIllIlIIlIIllIIllIll, final double lllllllllllllIllIlIIlIIllIIllIlI) {
        return lllllllllllllIllIlIIlIIllIIllIll + (lllllllllllllIllIlIIlIIllIIllIlI * 100.0 / 100.0 - lllllllllllllIllIlIIlIIllIIllIll) / 2.0;
    }
    
    public static void endSmooth() {
        GL11.glDisable(2848);
        GL11.glDisable(2881);
        GL11.glEnable(2832);
    }
    
    public static void drawRoundedRect1(double lllllllllllllIllIlIIIllIlIllIllI, double lllllllllllllIllIlIIIllIlIlIIlIl, final double lllllllllllllIllIlIIIllIlIlIIlII, final double lllllllllllllIllIlIIIllIlIllIIll, final double lllllllllllllIllIlIIIllIlIllIIlI, final int lllllllllllllIllIlIIIllIlIllIIIl) {
        double lllllllllllllIllIlIIIllIlIllIIII = lllllllllllllIllIlIIIllIlIllIllI + lllllllllllllIllIlIIIllIlIlIIlII;
        double lllllllllllllIllIlIIIllIlIlIllll = lllllllllllllIllIlIIIllIlIlIIlIl + lllllllllllllIllIlIIIllIlIllIIll;
        final float lllllllllllllIllIlIIIllIlIlIlllI = (lllllllllllllIllIlIIIllIlIllIIIl >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIllIlIlIllIl = (lllllllllllllIllIlIIIllIlIllIIIl >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIllIlIlIllII = (lllllllllllllIllIlIIIllIlIllIIIl >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIllIlIIIllIlIlIlIll = (lllllllllllllIllIlIIIllIlIllIIIl & 0xFF) / 255.0f;
        GL11.glPushAttrib(0);
        GL11.glScaled(0.5, 0.5, 0.5);
        lllllllllllllIllIlIIIllIlIllIllI *= 2.0;
        lllllllllllllIllIlIIIllIlIlIIlIl *= 2.0;
        lllllllllllllIllIlIIIllIlIllIIII *= 2.0;
        lllllllllllllIllIlIIIllIlIlIllll *= 2.0;
        GL11.glDisable(3553);
        GL11.glColor4f(lllllllllllllIllIlIIIllIlIlIllIl, lllllllllllllIllIlIIIllIlIlIllII, lllllllllllllIllIlIIIllIlIlIlIll, lllllllllllllIllIlIIIllIlIlIlllI);
        GL11.glEnable(2848);
        GL11.glBegin(9);
        for (int lllllllllllllIllIlIIIllIlIlIlIlI = 0; lllllllllllllIllIlIIIllIlIlIlIlI <= 90; lllllllllllllIllIlIIIllIlIlIlIlI += 3) {
            GL11.glVertex2d(lllllllllllllIllIlIIIllIlIllIllI + lllllllllllllIllIlIIIllIlIllIIlI + Math.sin(lllllllllllllIllIlIIIllIlIlIlIlI * 3.141592653589793 / 180.0) * (lllllllllllllIllIlIIIllIlIllIIlI * -1.0), lllllllllllllIllIlIIIllIlIlIIlIl + lllllllllllllIllIlIIIllIlIllIIlI + Math.cos(lllllllllllllIllIlIIIllIlIlIlIlI * 3.141592653589793 / 180.0) * (lllllllllllllIllIlIIIllIlIllIIlI * -1.0));
        }
        for (int lllllllllllllIllIlIIIllIlIlIlIIl = 90; lllllllllllllIllIlIIIllIlIlIlIIl <= 180; lllllllllllllIllIlIIIllIlIlIlIIl += 3) {
            GL11.glVertex2d(lllllllllllllIllIlIIIllIlIllIllI + lllllllllllllIllIlIIIllIlIllIIlI + Math.sin(lllllllllllllIllIlIIIllIlIlIlIIl * 3.141592653589793 / 180.0) * (lllllllllllllIllIlIIIllIlIllIIlI * -1.0), lllllllllllllIllIlIIIllIlIlIllll - lllllllllllllIllIlIIIllIlIllIIlI + Math.cos(lllllllllllllIllIlIIIllIlIlIlIIl * 3.141592653589793 / 180.0) * (lllllllllllllIllIlIIIllIlIllIIlI * -1.0));
        }
        for (int lllllllllllllIllIlIIIllIlIlIlIII = 0; lllllllllllllIllIlIIIllIlIlIlIII <= 90; lllllllllllllIllIlIIIllIlIlIlIII += 3) {
            GL11.glVertex2d(lllllllllllllIllIlIIIllIlIllIIII - lllllllllllllIllIlIIIllIlIllIIlI + Math.sin(lllllllllllllIllIlIIIllIlIlIlIII * 3.141592653589793 / 180.0) * lllllllllllllIllIlIIIllIlIllIIlI, lllllllllllllIllIlIIIllIlIlIllll - lllllllllllllIllIlIIIllIlIllIIlI + Math.cos(lllllllllllllIllIlIIIllIlIlIlIII * 3.141592653589793 / 180.0) * lllllllllllllIllIlIIIllIlIllIIlI);
        }
        for (int lllllllllllllIllIlIIIllIlIlIIlll = 90; lllllllllllllIllIlIIIllIlIlIIlll <= 180; lllllllllllllIllIlIIIllIlIlIIlll += 3) {
            GL11.glVertex2d(lllllllllllllIllIlIIIllIlIllIIII - lllllllllllllIllIlIIIllIlIllIIlI + Math.sin(lllllllllllllIllIlIIIllIlIlIIlll * 3.141592653589793 / 180.0) * lllllllllllllIllIlIIIllIlIllIIlI, lllllllllllllIllIlIIIllIlIlIIlIl + lllllllllllllIllIlIIIllIlIllIIlI + Math.cos(lllllllllllllIllIlIIIllIlIlIIlll * 3.141592653589793 / 180.0) * lllllllllllllIllIlIIIllIlIllIIlI);
        }
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glScaled(2.0, 2.0, 2.0);
        GL11.glPopAttrib();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
