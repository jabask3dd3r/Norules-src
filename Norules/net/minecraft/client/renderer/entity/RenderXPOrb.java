package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import optifine.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderXPOrb extends Render<EntityXPOrb>
{
    private static final /* synthetic */ ResourceLocation EXPERIENCE_ORB_TEXTURES;
    
    public RenderXPOrb(final RenderManager lllllllllllllllIlIIllIlIIlIIlIlI) {
        super(lllllllllllllllIlIIllIlIIlIIlIlI);
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }
    
    @Override
    public void doRender(final EntityXPOrb lllllllllllllllIlIIllIlIIIlIlIIl, final double lllllllllllllllIlIIllIlIIIlIlIII, final double lllllllllllllllIlIIllIlIIIlIIlll, final double lllllllllllllllIlIIllIlIIIlIIllI, final float lllllllllllllllIlIIllIlIIIIIlIII, final float lllllllllllllllIlIIllIlIIIlIIlII) {
        if (!this.renderOutlines) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)lllllllllllllllIlIIllIlIIIlIlIII, (float)lllllllllllllllIlIIllIlIIIlIIlll, (float)lllllllllllllllIlIIllIlIIIlIIllI);
            this.bindEntityTexture(lllllllllllllllIlIIllIlIIIlIlIIl);
            RenderHelper.enableStandardItemLighting();
            final int lllllllllllllllIlIIllIlIIIlIIIll = lllllllllllllllIlIIllIlIIIlIlIIl.getTextureByXP();
            final float lllllllllllllllIlIIllIlIIIlIIIlI = (lllllllllllllllIlIIllIlIIIlIIIll % 4 * 16 + 0) / 64.0f;
            final float lllllllllllllllIlIIllIlIIIlIIIIl = (lllllllllllllllIlIIllIlIIIlIIIll % 4 * 16 + 16) / 64.0f;
            final float lllllllllllllllIlIIllIlIIIlIIIII = (lllllllllllllllIlIIllIlIIIlIIIll / 4 * 16 + 0) / 64.0f;
            final float lllllllllllllllIlIIllIlIIIIlllll = (lllllllllllllllIlIIllIlIIIlIIIll / 4 * 16 + 16) / 64.0f;
            final float lllllllllllllllIlIIllIlIIIIllllI = 1.0f;
            final float lllllllllllllllIlIIllIlIIIIlllIl = 0.5f;
            final float lllllllllllllllIlIIllIlIIIIlllII = 0.25f;
            final int lllllllllllllllIlIIllIlIIIIllIll = lllllllllllllllIlIIllIlIIIlIlIIl.getBrightnessForRender();
            final int lllllllllllllllIlIIllIlIIIIllIlI = lllllllllllllllIlIIllIlIIIIllIll % 65536;
            int lllllllllllllllIlIIllIlIIIIllIIl = lllllllllllllllIlIIllIlIIIIllIll / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllllIlIIllIlIIIIllIlI, (float)lllllllllllllllIlIIllIlIIIIllIIl);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final float lllllllllllllllIlIIllIlIIIIllIII = 255.0f;
            float lllllllllllllllIlIIllIlIIIIlIlll = (lllllllllllllllIlIIllIlIIIlIlIIl.xpColor + lllllllllllllllIlIIllIlIIIlIIlII) / 2.0f;
            if (Config.isCustomColors()) {
                lllllllllllllllIlIIllIlIIIIlIlll = CustomColors.getXpOrbTimer(lllllllllllllllIlIIllIlIIIIlIlll);
            }
            lllllllllllllllIlIIllIlIIIIllIIl = (int)((MathHelper.sin(lllllllllllllllIlIIllIlIIIIlIlll + 0.0f) + 1.0f) * 0.5f * 255.0f);
            final int lllllllllllllllIlIIllIlIIIIlIllI = 255;
            final int lllllllllllllllIlIIllIlIIIIlIlIl = (int)((MathHelper.sin(lllllllllllllllIlIIllIlIIIIlIlll + 4.1887903f) + 1.0f) * 0.1f * 255.0f);
            GlStateManager.translate(0.0f, 0.1f, 0.0f);
            GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * -this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
            final float lllllllllllllllIlIIllIlIIIIlIlII = 0.3f;
            GlStateManager.scale(0.3f, 0.3f, 0.3f);
            final Tessellator lllllllllllllllIlIIllIlIIIIlIIll = Tessellator.getInstance();
            final BufferBuilder lllllllllllllllIlIIllIlIIIIlIIlI = lllllllllllllllIlIIllIlIIIIlIIll.getBuffer();
            lllllllllllllllIlIIllIlIIIIlIIlI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
            int lllllllllllllllIlIIllIlIIIIlIIIl = lllllllllllllllIlIIllIlIIIIllIIl;
            int lllllllllllllllIlIIllIlIIIIlIIII = 255;
            int lllllllllllllllIlIIllIlIIIIIllll = lllllllllllllllIlIIllIlIIIIlIlIl;
            if (Config.isCustomColors()) {
                final int lllllllllllllllIlIIllIlIIIIIlllI = CustomColors.getXpOrbColor(lllllllllllllllIlIIllIlIIIIlIlll);
                if (lllllllllllllllIlIIllIlIIIIIlllI >= 0) {
                    lllllllllllllllIlIIllIlIIIIlIIIl = (lllllllllllllllIlIIllIlIIIIIlllI >> 16 & 0xFF);
                    lllllllllllllllIlIIllIlIIIIlIIII = (lllllllllllllllIlIIllIlIIIIIlllI >> 8 & 0xFF);
                    lllllllllllllllIlIIllIlIIIIIllll = (lllllllllllllllIlIIllIlIIIIIlllI >> 0 & 0xFF);
                }
            }
            lllllllllllllllIlIIllIlIIIIlIIlI.pos(-0.5, -0.25, 0.0).tex(lllllllllllllllIlIIllIlIIIlIIIlI, lllllllllllllllIlIIllIlIIIIlllll).color(lllllllllllllllIlIIllIlIIIIlIIIl, lllllllllllllllIlIIllIlIIIIlIIII, lllllllllllllllIlIIllIlIIIIIllll, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIIIIlIIlI.pos(0.5, -0.25, 0.0).tex(lllllllllllllllIlIIllIlIIIlIIIIl, lllllllllllllllIlIIllIlIIIIlllll).color(lllllllllllllllIlIIllIlIIIIlIIIl, lllllllllllllllIlIIllIlIIIIlIIII, lllllllllllllllIlIIllIlIIIIIllll, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIIIIlIIlI.pos(0.5, 0.75, 0.0).tex(lllllllllllllllIlIIllIlIIIlIIIIl, lllllllllllllllIlIIllIlIIIlIIIII).color(lllllllllllllllIlIIllIlIIIIlIIIl, lllllllllllllllIlIIllIlIIIIlIIII, lllllllllllllllIlIIllIlIIIIIllll, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIIIIlIIlI.pos(-0.5, 0.75, 0.0).tex(lllllllllllllllIlIIllIlIIIlIIIlI, lllllllllllllllIlIIllIlIIIlIIIII).color(lllllllllllllllIlIIllIlIIIIlIIIl, lllllllllllllllIlIIllIlIIIIlIIII, lllllllllllllllIlIIllIlIIIIIllll, 128).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIIIIlIIll.draw();
            GlStateManager.disableBlend();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            super.doRender(lllllllllllllllIlIIllIlIIIlIlIIl, lllllllllllllllIlIIllIlIIIlIlIII, lllllllllllllllIlIIllIlIIIlIIlll, lllllllllllllllIlIIllIlIIIlIIllI, lllllllllllllllIlIIllIlIIIIIlIII, lllllllllllllllIlIIllIlIIIlIIlII);
        }
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityXPOrb lllllllllllllllIlIIllIIllllIllll) {
        return RenderXPOrb.EXPERIENCE_ORB_TEXTURES;
    }
    
    static {
        EXPERIENCE_ORB_TEXTURES = new ResourceLocation("textures/entity/experience_orb.png");
    }
}
