package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;

public class Gui
{
    protected /* synthetic */ float zLevel;
    
    public void drawCenteredString(final FontRenderer lllllllllllllIIlIlIIIIlllIIIIlIl, final String lllllllllllllIIlIlIIIIllIlllllll, final int lllllllllllllIIlIlIIIIlllIIIIIll, final int lllllllllllllIIlIlIIIIlllIIIIIlI, final int lllllllllllllIIlIlIIIIlllIIIIIIl) {
        lllllllllllllIIlIlIIIIlllIIIIlIl.drawStringWithShadow(lllllllllllllIIlIlIIIIllIlllllll, (float)(lllllllllllllIIlIlIIIIlllIIIIIll - lllllllllllllIIlIlIIIIlllIIIIlIl.getStringWidth(lllllllllllllIIlIlIIIIllIlllllll) / 2), (float)lllllllllllllIIlIlIIIIlllIIIIIlI, lllllllllllllIIlIlIIIIlllIIIIIIl);
    }
    
    public void drawGradientRect(final double lllllllllllllIIlIlIIIIlllIIllIll, final double lllllllllllllIIlIlIIIIlllIIllIlI, final double lllllllllllllIIlIlIIIIlllIlIlIlI, final double lllllllllllllIIlIlIIIIlllIIllIII, final int lllllllllllllIIlIlIIIIlllIlIlIII, final int lllllllllllllIIlIlIIIIlllIIlIllI) {
        final float lllllllllllllIIlIlIIIIlllIlIIllI = (lllllllllllllIIlIlIIIIlllIlIlIII >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIlllIlIIlIl = (lllllllllllllIIlIlIIIIlllIlIlIII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIlllIlIIlII = (lllllllllllllIIlIlIIIIlllIlIlIII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIlllIlIIIll = (lllllllllllllIIlIlIIIIlllIlIlIII & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIlllIlIIIlI = (lllllllllllllIIlIlIIIIlllIIlIllI >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIlllIlIIIIl = (lllllllllllllIIlIlIIIIlllIIlIllI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIlllIlIIIII = (lllllllllllllIIlIlIIIIlllIIlIllI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIlllIIlllll = (lllllllllllllIIlIlIIIIlllIIlIllI & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        final Tessellator lllllllllllllIIlIlIIIIlllIIllllI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIlIIIIlllIIlllIl = lllllllllllllIIlIlIIIIlllIIllllI.getBuffer();
        lllllllllllllIIlIlIIIIlllIIlllIl.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllIIlIlIIIIlllIIlllIl.pos(lllllllllllllIIlIlIIIIlllIlIlIlI, lllllllllllllIIlIlIIIIlllIIllIlI, this.zLevel).color(lllllllllllllIIlIlIIIIlllIlIIlIl, lllllllllllllIIlIlIIIIlllIlIIlII, lllllllllllllIIlIlIIIIlllIlIIIll, lllllllllllllIIlIlIIIIlllIlIIllI).endVertex();
        lllllllllllllIIlIlIIIIlllIIlllIl.pos(lllllllllllllIIlIlIIIIlllIIllIll, lllllllllllllIIlIlIIIIlllIIllIlI, this.zLevel).color(lllllllllllllIIlIlIIIIlllIlIIlIl, lllllllllllllIIlIlIIIIlllIlIIlII, lllllllllllllIIlIlIIIIlllIlIIIll, lllllllllllllIIlIlIIIIlllIlIIllI).endVertex();
        lllllllllllllIIlIlIIIIlllIIlllIl.pos(lllllllllllllIIlIlIIIIlllIIllIll, lllllllllllllIIlIlIIIIlllIIllIII, this.zLevel).color(lllllllllllllIIlIlIIIIlllIlIIIIl, lllllllllllllIIlIlIIIIlllIlIIIII, lllllllllllllIIlIlIIIIlllIIlllll, lllllllllllllIIlIlIIIIlllIlIIIlI).endVertex();
        lllllllllllllIIlIlIIIIlllIIlllIl.pos(lllllllllllllIIlIlIIIIlllIlIlIlI, lllllllllllllIIlIlIIIIlllIIllIII, this.zLevel).color(lllllllllllllIIlIlIIIIlllIlIIIIl, lllllllllllllIIlIlIIIIlllIlIIIII, lllllllllllllIIlIlIIIIlllIIlllll, lllllllllllllIIlIlIIIIlllIlIIIlI).endVertex();
        lllllllllllllIIlIlIIIIlllIIllllI.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    protected void drawHorizontalLine(int lllllllllllllIIlIlIIIIllllllIllI, int lllllllllllllIIlIlIIIIllllllIlIl, final int lllllllllllllIIlIlIIIIlllllllIIl, final int lllllllllllllIIlIlIIIIllllllIIll) {
        if (lllllllllllllIIlIlIIIIllllllIlIl < lllllllllllllIIlIlIIIIllllllIllI) {
            final int lllllllllllllIIlIlIIIIllllllIlll = lllllllllllllIIlIlIIIIllllllIllI;
            lllllllllllllIIlIlIIIIllllllIllI = lllllllllllllIIlIlIIIIllllllIlIl;
            lllllllllllllIIlIlIIIIllllllIlIl = lllllllllllllIIlIlIIIIllllllIlll;
        }
        drawRect(lllllllllllllIIlIlIIIIllllllIllI, lllllllllllllIIlIlIIIIlllllllIIl, lllllllllllllIIlIlIIIIllllllIlIl + 1, lllllllllllllIIlIlIIIIlllllllIIl + 1, lllllllllllllIIlIlIIIIllllllIIll);
    }
    
    public static void drawScaledCustomSizeModalRect(final int lllllllllllllIIlIlIIIIlIllIlIIIl, final int lllllllllllllIIlIlIIIIlIllIllllI, final float lllllllllllllIIlIlIIIIlIllIIllll, final float lllllllllllllIIlIlIIIIlIllIIlllI, final int lllllllllllllIIlIlIIIIlIllIIllIl, final int lllllllllllllIIlIlIIIIlIllIIllII, final int lllllllllllllIIlIlIIIIlIllIllIIl, final int lllllllllllllIIlIlIIIIlIllIllIII, final float lllllllllllllIIlIlIIIIlIllIlIlll, final float lllllllllllllIIlIlIIIIlIllIlIllI) {
        final float lllllllllllllIIlIlIIIIlIllIlIlIl = 1.0f / lllllllllllllIIlIlIIIIlIllIlIlll;
        final float lllllllllllllIIlIlIIIIlIllIlIlII = 1.0f / lllllllllllllIIlIlIIIIlIllIlIllI;
        final Tessellator lllllllllllllIIlIlIIIIlIllIlIIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIlIIIIlIllIlIIlI = lllllllllllllIIlIlIIIIlIllIlIIll.getBuffer();
        lllllllllllllIIlIlIIIIlIllIlIIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIlIlIIIIlIllIlIIlI.pos(lllllllllllllIIlIlIIIIlIllIlIIIl, lllllllllllllIIlIlIIIIlIllIllllI + lllllllllllllIIlIlIIIIlIllIllIII, 0.0).tex(lllllllllllllIIlIlIIIIlIllIIllll * lllllllllllllIIlIlIIIIlIllIlIlIl, (lllllllllllllIIlIlIIIIlIllIIlllI + lllllllllllllIIlIlIIIIlIllIIllII) * lllllllllllllIIlIlIIIIlIllIlIlII).endVertex();
        lllllllllllllIIlIlIIIIlIllIlIIlI.pos(lllllllllllllIIlIlIIIIlIllIlIIIl + lllllllllllllIIlIlIIIIlIllIllIIl, lllllllllllllIIlIlIIIIlIllIllllI + lllllllllllllIIlIlIIIIlIllIllIII, 0.0).tex((lllllllllllllIIlIlIIIIlIllIIllll + lllllllllllllIIlIlIIIIlIllIIllIl) * lllllllllllllIIlIlIIIIlIllIlIlIl, (lllllllllllllIIlIlIIIIlIllIIlllI + lllllllllllllIIlIlIIIIlIllIIllII) * lllllllllllllIIlIlIIIIlIllIlIlII).endVertex();
        lllllllllllllIIlIlIIIIlIllIlIIlI.pos(lllllllllllllIIlIlIIIIlIllIlIIIl + lllllllllllllIIlIlIIIIlIllIllIIl, lllllllllllllIIlIlIIIIlIllIllllI, 0.0).tex((lllllllllllllIIlIlIIIIlIllIIllll + lllllllllllllIIlIlIIIIlIllIIllIl) * lllllllllllllIIlIlIIIIlIllIlIlIl, lllllllllllllIIlIlIIIIlIllIIlllI * lllllllllllllIIlIlIIIIlIllIlIlII).endVertex();
        lllllllllllllIIlIlIIIIlIllIlIIlI.pos(lllllllllllllIIlIlIIIIlIllIlIIIl, lllllllllllllIIlIlIIIIlIllIllllI, 0.0).tex(lllllllllllllIIlIlIIIIlIllIIllll * lllllllllllllIIlIlIIIIlIllIlIlIl, lllllllllllllIIlIlIIIIlIllIIlllI * lllllllllllllIIlIlIIIIlIllIlIlII).endVertex();
        lllllllllllllIIlIlIIIIlIllIlIIll.draw();
    }
    
    static {
        OPTIONS_BACKGROUND = new ResourceLocation("petechka.png");
        STAT_ICONS = new ResourceLocation("textures/gui/container/stats_icons.png");
        ICONS = new ResourceLocation("textures/gui/icons.png");
    }
    
    public void drawTexturedModalRect(final int lllllllllllllIIlIlIIIIllIIlIIIII, final int lllllllllllllIIlIlIIIIllIIIlllll, final TextureAtlasSprite lllllllllllllIIlIlIIIIllIIIlIllI, final int lllllllllllllIIlIlIIIIllIIIlllIl, final int lllllllllllllIIlIlIIIIllIIIlIlII) {
        final Tessellator lllllllllllllIIlIlIIIIllIIIllIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIlIIIIllIIIllIlI = lllllllllllllIIlIlIIIIllIIIllIll.getBuffer();
        lllllllllllllIIlIlIIIIllIIIllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIlIlIIIIllIIIllIlI.pos(lllllllllllllIIlIlIIIIllIIlIIIII + 0, lllllllllllllIIlIlIIIIllIIIlllll + lllllllllllllIIlIlIIIIllIIIlIlII, this.zLevel).tex(lllllllllllllIIlIlIIIIllIIIlIllI.getMinU(), lllllllllllllIIlIlIIIIllIIIlIllI.getMaxV()).endVertex();
        lllllllllllllIIlIlIIIIllIIIllIlI.pos(lllllllllllllIIlIlIIIIllIIlIIIII + lllllllllllllIIlIlIIIIllIIIlllIl, lllllllllllllIIlIlIIIIllIIIlllll + lllllllllllllIIlIlIIIIllIIIlIlII, this.zLevel).tex(lllllllllllllIIlIlIIIIllIIIlIllI.getMaxU(), lllllllllllllIIlIlIIIIllIIIlIllI.getMaxV()).endVertex();
        lllllllllllllIIlIlIIIIllIIIllIlI.pos(lllllllllllllIIlIlIIIIllIIlIIIII + lllllllllllllIIlIlIIIIllIIIlllIl, lllllllllllllIIlIlIIIIllIIIlllll + 0, this.zLevel).tex(lllllllllllllIIlIlIIIIllIIIlIllI.getMaxU(), lllllllllllllIIlIlIIIIllIIIlIllI.getMinV()).endVertex();
        lllllllllllllIIlIlIIIIllIIIllIlI.pos(lllllllllllllIIlIlIIIIllIIlIIIII + 0, lllllllllllllIIlIlIIIIllIIIlllll + 0, this.zLevel).tex(lllllllllllllIIlIlIIIIllIIIlIllI.getMinU(), lllllllllllllIIlIlIIIIllIIIlIllI.getMinV()).endVertex();
        lllllllllllllIIlIlIIIIllIIIllIll.draw();
    }
    
    public void drawTexturedModalRect(final float lllllllllllllIIlIlIIIIllIIllIIll, final float lllllllllllllIIlIlIIIIllIIllIIlI, final int lllllllllllllIIlIlIIIIllIIllllII, final int lllllllllllllIIlIlIIIIllIIllIIII, final int lllllllllllllIIlIlIIIIllIIlIllll, final int lllllllllllllIIlIlIIIIllIIlllIIl) {
        final float lllllllllllllIIlIlIIIIllIIlllIII = 0.00390625f;
        final float lllllllllllllIIlIlIIIIllIIllIlll = 0.00390625f;
        final Tessellator lllllllllllllIIlIlIIIIllIIllIllI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIlIIIIllIIllIlIl = lllllllllllllIIlIlIIIIllIIllIllI.getBuffer();
        lllllllllllllIIlIlIIIIllIIllIlIl.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIlIlIIIIllIIllIlIl.pos(lllllllllllllIIlIlIIIIllIIllIIll + 0.0f, lllllllllllllIIlIlIIIIllIIllIIlI + lllllllllllllIIlIlIIIIllIIlllIIl, this.zLevel).tex((lllllllllllllIIlIlIIIIllIIllllII + 0) * 0.00390625f, (lllllllllllllIIlIlIIIIllIIllIIII + lllllllllllllIIlIlIIIIllIIlllIIl) * 0.00390625f).endVertex();
        lllllllllllllIIlIlIIIIllIIllIlIl.pos(lllllllllllllIIlIlIIIIllIIllIIll + lllllllllllllIIlIlIIIIllIIlIllll, lllllllllllllIIlIlIIIIllIIllIIlI + lllllllllllllIIlIlIIIIllIIlllIIl, this.zLevel).tex((lllllllllllllIIlIlIIIIllIIllllII + lllllllllllllIIlIlIIIIllIIlIllll) * 0.00390625f, (lllllllllllllIIlIlIIIIllIIllIIII + lllllllllllllIIlIlIIIIllIIlllIIl) * 0.00390625f).endVertex();
        lllllllllllllIIlIlIIIIllIIllIlIl.pos(lllllllllllllIIlIlIIIIllIIllIIll + lllllllllllllIIlIlIIIIllIIlIllll, lllllllllllllIIlIlIIIIllIIllIIlI + 0.0f, this.zLevel).tex((lllllllllllllIIlIlIIIIllIIllllII + lllllllllllllIIlIlIIIIllIIlIllll) * 0.00390625f, (lllllllllllllIIlIlIIIIllIIllIIII + 0) * 0.00390625f).endVertex();
        lllllllllllllIIlIlIIIIllIIllIlIl.pos(lllllllllllllIIlIlIIIIllIIllIIll + 0.0f, lllllllllllllIIlIlIIIIllIIllIIlI + 0.0f, this.zLevel).tex((lllllllllllllIIlIlIIIIllIIllllII + 0) * 0.00390625f, (lllllllllllllIIlIlIIIIllIIllIIII + 0) * 0.00390625f).endVertex();
        lllllllllllllIIlIlIIIIllIIllIllI.draw();
    }
    
    protected void drawVerticalLine(final int lllllllllllllIIlIlIIIIlllllIlIll, int lllllllllllllIIlIlIIIIlllllIIlIl, int lllllllllllllIIlIlIIIIlllllIIlII, final int lllllllllllllIIlIlIIIIlllllIIIll) {
        if (lllllllllllllIIlIlIIIIlllllIIlII < lllllllllllllIIlIlIIIIlllllIIlIl) {
            final int lllllllllllllIIlIlIIIIlllllIIlll = lllllllllllllIIlIlIIIIlllllIIlIl;
            lllllllllllllIIlIlIIIIlllllIIlIl = lllllllllllllIIlIlIIIIlllllIIlII;
            lllllllllllllIIlIlIIIIlllllIIlII = lllllllllllllIIlIlIIIIlllllIIlll;
        }
        drawRect(lllllllllllllIIlIlIIIIlllllIlIll, lllllllllllllIIlIlIIIIlllllIIlIl + 1, lllllllllllllIIlIlIIIIlllllIlIll + 1, lllllllllllllIIlIlIIIIlllllIIlII, lllllllllllllIIlIlIIIIlllllIIIll);
    }
    
    public static void drawRect(double lllllllllllllIIlIlIIIIllllIIlIIl, double lllllllllllllIIlIlIIIIllllIIlIII, double lllllllllllllIIlIlIIIIllllIIIlll, double lllllllllllllIIlIlIIIIllllIIIllI, final int lllllllllllllIIlIlIIIIllllIlIIlI) {
        if (lllllllllllllIIlIlIIIIllllIIlIIl < lllllllllllllIIlIlIIIIllllIIIlll) {
            final double lllllllllllllIIlIlIIIIllllIlIIIl = lllllllllllllIIlIlIIIIllllIIlIIl;
            lllllllllllllIIlIlIIIIllllIIlIIl = lllllllllllllIIlIlIIIIllllIIIlll;
            lllllllllllllIIlIlIIIIllllIIIlll = lllllllllllllIIlIlIIIIllllIlIIIl;
        }
        if (lllllllllllllIIlIlIIIIllllIIlIII < lllllllllllllIIlIlIIIIllllIIIllI) {
            final double lllllllllllllIIlIlIIIIllllIlIIII = lllllllllllllIIlIlIIIIllllIIlIII;
            lllllllllllllIIlIlIIIIllllIIlIII = lllllllllllllIIlIlIIIIllllIIIllI;
            lllllllllllllIIlIlIIIIllllIIIllI = lllllllllllllIIlIlIIIIllllIlIIII;
        }
        final float lllllllllllllIIlIlIIIIllllIIllll = (lllllllllllllIIlIlIIIIllllIlIIlI >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIllllIIlllI = (lllllllllllllIIlIlIIIIllllIlIIlI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIllllIIllIl = (lllllllllllllIIlIlIIIIllllIlIIlI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIIlIlIIIIllllIIllII = (lllllllllllllIIlIlIIIIllllIlIIlI & 0xFF) / 255.0f;
        final Tessellator lllllllllllllIIlIlIIIIllllIIlIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIlIIIIllllIIlIlI = lllllllllllllIIlIlIIIIllllIIlIll.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(lllllllllllllIIlIlIIIIllllIIlllI, lllllllllllllIIlIlIIIIllllIIllIl, lllllllllllllIIlIlIIIIllllIIllII, lllllllllllllIIlIlIIIIllllIIllll);
        lllllllllllllIIlIlIIIIllllIIlIlI.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIIlIlIIIIllllIIlIlI.pos(lllllllllllllIIlIlIIIIllllIIlIIl, lllllllllllllIIlIlIIIIllllIIIllI, 0.0).endVertex();
        lllllllllllllIIlIlIIIIllllIIlIlI.pos(lllllllllllllIIlIlIIIIllllIIIlll, lllllllllllllIIlIlIIIIllllIIIllI, 0.0).endVertex();
        lllllllllllllIIlIlIIIIllllIIlIlI.pos(lllllllllllllIIlIlIIIIllllIIIlll, lllllllllllllIIlIlIIIIllllIIlIII, 0.0).endVertex();
        lllllllllllllIIlIlIIIIllllIIlIlI.pos(lllllllllllllIIlIlIIIIllllIIlIIl, lllllllllllllIIlIlIIIIllllIIlIII, 0.0).endVertex();
        lllllllllllllIIlIlIIIIllllIIlIll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public static void drawModalRectWithCustomSizedTexture(final double lllllllllllllIIlIlIIIIllIIIIIlIl, final double lllllllllllllIIlIlIIIIlIlllllIII, final float lllllllllllllIIlIlIIIIllIIIIIIll, final float lllllllllllllIIlIlIIIIlIllllIllI, final int lllllllllllllIIlIlIIIIlIllllIlIl, final int lllllllllllllIIlIlIIIIlIllllIlII, final float lllllllllllllIIlIlIIIIlIllllllll, final float lllllllllllllIIlIlIIIIlIllllIIlI) {
        final float lllllllllllllIIlIlIIIIlIllllllIl = 1.0f / lllllllllllllIIlIlIIIIlIllllllll;
        final float lllllllllllllIIlIlIIIIlIllllllII = 1.0f / lllllllllllllIIlIlIIIIlIllllIIlI;
        final Tessellator lllllllllllllIIlIlIIIIlIlllllIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIlIIIIlIlllllIlI = lllllllllllllIIlIlIIIIlIlllllIll.getBuffer();
        lllllllllllllIIlIlIIIIlIlllllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIlIlIIIIlIlllllIlI.pos(lllllllllllllIIlIlIIIIllIIIIIlIl, lllllllllllllIIlIlIIIIlIlllllIII + lllllllllllllIIlIlIIIIlIllllIlII, 0.0).tex(lllllllllllllIIlIlIIIIllIIIIIIll * lllllllllllllIIlIlIIIIlIllllllIl, (lllllllllllllIIlIlIIIIlIllllIllI + lllllllllllllIIlIlIIIIlIllllIlII) * lllllllllllllIIlIlIIIIlIllllllII).endVertex();
        lllllllllllllIIlIlIIIIlIlllllIlI.pos(lllllllllllllIIlIlIIIIllIIIIIlIl + lllllllllllllIIlIlIIIIlIllllIlIl, lllllllllllllIIlIlIIIIlIlllllIII + lllllllllllllIIlIlIIIIlIllllIlII, 0.0).tex((lllllllllllllIIlIlIIIIllIIIIIIll + lllllllllllllIIlIlIIIIlIllllIlIl) * lllllllllllllIIlIlIIIIlIllllllIl, (lllllllllllllIIlIlIIIIlIllllIllI + lllllllllllllIIlIlIIIIlIllllIlII) * lllllllllllllIIlIlIIIIlIllllllII).endVertex();
        lllllllllllllIIlIlIIIIlIlllllIlI.pos(lllllllllllllIIlIlIIIIllIIIIIlIl + lllllllllllllIIlIlIIIIlIllllIlIl, lllllllllllllIIlIlIIIIlIlllllIII, 0.0).tex((lllllllllllllIIlIlIIIIllIIIIIIll + lllllllllllllIIlIlIIIIlIllllIlIl) * lllllllllllllIIlIlIIIIlIllllllIl, lllllllllllllIIlIlIIIIlIllllIllI * lllllllllllllIIlIlIIIIlIllllllII).endVertex();
        lllllllllllllIIlIlIIIIlIlllllIlI.pos(lllllllllllllIIlIlIIIIllIIIIIlIl, lllllllllllllIIlIlIIIIlIlllllIII, 0.0).tex(lllllllllllllIIlIlIIIIllIIIIIIll * lllllllllllllIIlIlIIIIlIllllllIl, lllllllllllllIIlIlIIIIlIllllIllI * lllllllllllllIIlIlIIIIlIllllllII).endVertex();
        lllllllllllllIIlIlIIIIlIlllllIll.draw();
    }
    
    public void drawTexturedModalRect(final int lllllllllllllIIlIlIIIIllIlIlllll, final int lllllllllllllIIlIlIIIIllIlIlIIll, final int lllllllllllllIIlIlIIIIllIlIlllIl, final int lllllllllllllIIlIlIIIIllIlIlIIIl, final int lllllllllllllIIlIlIIIIllIlIlIIII, final int lllllllllllllIIlIlIIIIllIlIIllll) {
        final float lllllllllllllIIlIlIIIIllIlIllIIl = 0.00390625f;
        final float lllllllllllllIIlIlIIIIllIlIllIII = 0.00390625f;
        final Tessellator lllllllllllllIIlIlIIIIllIlIlIlll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIlIIIIllIlIlIllI = lllllllllllllIIlIlIIIIllIlIlIlll.getBuffer();
        lllllllllllllIIlIlIIIIllIlIlIllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIlIlIIIIllIlIlIllI.pos(lllllllllllllIIlIlIIIIllIlIlllll + 0, lllllllllllllIIlIlIIIIllIlIlIIll + lllllllllllllIIlIlIIIIllIlIIllll, this.zLevel).tex((lllllllllllllIIlIlIIIIllIlIlllIl + 0) * 0.00390625f, (lllllllllllllIIlIlIIIIllIlIlIIIl + lllllllllllllIIlIlIIIIllIlIIllll) * 0.00390625f).endVertex();
        lllllllllllllIIlIlIIIIllIlIlIllI.pos(lllllllllllllIIlIlIIIIllIlIlllll + lllllllllllllIIlIlIIIIllIlIlIIII, lllllllllllllIIlIlIIIIllIlIlIIll + lllllllllllllIIlIlIIIIllIlIIllll, this.zLevel).tex((lllllllllllllIIlIlIIIIllIlIlllIl + lllllllllllllIIlIlIIIIllIlIlIIII) * 0.00390625f, (lllllllllllllIIlIlIIIIllIlIlIIIl + lllllllllllllIIlIlIIIIllIlIIllll) * 0.00390625f).endVertex();
        lllllllllllllIIlIlIIIIllIlIlIllI.pos(lllllllllllllIIlIlIIIIllIlIlllll + lllllllllllllIIlIlIIIIllIlIlIIII, lllllllllllllIIlIlIIIIllIlIlIIll + 0, this.zLevel).tex((lllllllllllllIIlIlIIIIllIlIlllIl + lllllllllllllIIlIlIIIIllIlIlIIII) * 0.00390625f, (lllllllllllllIIlIlIIIIllIlIlIIIl + 0) * 0.00390625f).endVertex();
        lllllllllllllIIlIlIIIIllIlIlIllI.pos(lllllllllllllIIlIlIIIIllIlIlllll + 0, lllllllllllllIIlIlIIIIllIlIlIIll + 0, this.zLevel).tex((lllllllllllllIIlIlIIIIllIlIlllIl + 0) * 0.00390625f, (lllllllllllllIIlIlIIIIllIlIlIIIl + 0) * 0.00390625f).endVertex();
        lllllllllllllIIlIlIIIIllIlIlIlll.draw();
    }
    
    public void drawString(final FontRenderer lllllllllllllIIlIlIIIIllIlllIIII, final String lllllllllllllIIlIlIIIIllIllIllll, final int lllllllllllllIIlIlIIIIllIllIlllI, final int lllllllllllllIIlIlIIIIllIllIllIl, final int lllllllllllllIIlIlIIIIllIllIllII) {
        lllllllllllllIIlIlIIIIllIlllIIII.drawStringWithShadow(lllllllllllllIIlIlIIIIllIllIllll, (float)lllllllllllllIIlIlIIIIllIllIlllI, (float)lllllllllllllIIlIlIIIIllIllIllIl, lllllllllllllIIlIlIIIIllIllIllII);
    }
}
