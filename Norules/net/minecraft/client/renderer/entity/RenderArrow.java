package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public abstract class RenderArrow<T extends EntityArrow> extends Render<T>
{
    public RenderArrow(final RenderManager lllllllllllllIIIlIlIlIllIllIlIIl) {
        super(lllllllllllllIIIlIlIlIllIllIlIIl);
    }
    
    @Override
    public void doRender(final T lllllllllllllIIIlIlIlIllIIlllIlI, final double lllllllllllllIIIlIlIlIllIIlllIIl, final double lllllllllllllIIIlIlIlIllIIlllIII, final double lllllllllllllIIIlIlIlIllIIllIlll, final float lllllllllllllIIIlIlIlIllIIllIllI, final float lllllllllllllIIIlIlIlIllIIllIlIl) {
        this.bindEntityTexture(lllllllllllllIIIlIlIlIllIIlllIlI);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.disableLighting();
        GlStateManager.translate((float)lllllllllllllIIIlIlIlIllIIlllIIl, (float)lllllllllllllIIIlIlIlIllIIlllIII, (float)lllllllllllllIIIlIlIlIllIIllIlll);
        GlStateManager.rotate(lllllllllllllIIIlIlIlIllIIlllIlI.prevRotationYaw + (lllllllllllllIIIlIlIlIllIIlllIlI.rotationYaw - lllllllllllllIIIlIlIlIllIIlllIlI.prevRotationYaw) * lllllllllllllIIIlIlIlIllIIllIlIl - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIlIlIlIllIIlllIlI.prevRotationPitch + (lllllllllllllIIIlIlIlIllIIlllIlI.rotationPitch - lllllllllllllIIIlIlIlIllIIlllIlI.prevRotationPitch) * lllllllllllllIIIlIlIlIllIIllIlIl, 0.0f, 0.0f, 1.0f);
        final Tessellator lllllllllllllIIIlIlIlIllIlIIlIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIIlIlIlIllIlIIlIIl = lllllllllllllIIIlIlIlIllIlIIlIlI.getBuffer();
        final int lllllllllllllIIIlIlIlIllIlIIlIII = 0;
        final float lllllllllllllIIIlIlIlIllIlIIIlll = 0.0f;
        final float lllllllllllllIIIlIlIlIllIlIIIllI = 0.5f;
        final float lllllllllllllIIIlIlIlIllIlIIIlIl = 0.0f;
        final float lllllllllllllIIIlIlIlIllIlIIIlII = 0.15625f;
        final float lllllllllllllIIIlIlIlIllIlIIIIll = 0.0f;
        final float lllllllllllllIIIlIlIlIllIlIIIIlI = 0.15625f;
        final float lllllllllllllIIIlIlIlIllIlIIIIIl = 0.15625f;
        final float lllllllllllllIIIlIlIlIllIlIIIIII = 0.3125f;
        final float lllllllllllllIIIlIlIlIllIIllllll = 0.05625f;
        GlStateManager.enableRescaleNormal();
        final float lllllllllllllIIIlIlIlIllIIlllllI = lllllllllllllIIIlIlIlIllIIlllIlI.arrowShake - lllllllllllllIIIlIlIlIllIIllIlIl;
        if (lllllllllllllIIIlIlIlIllIIlllllI > 0.0f) {
            final float lllllllllllllIIIlIlIlIllIIllllIl = -MathHelper.sin(lllllllllllllIIIlIlIlIllIIlllllI * 3.0f) * lllllllllllllIIIlIlIlIllIIlllllI;
            GlStateManager.rotate(lllllllllllllIIIlIlIlIllIIllllIl, 0.0f, 0.0f, 1.0f);
        }
        GlStateManager.rotate(45.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(0.05625f, 0.05625f, 0.05625f);
        GlStateManager.translate(-4.0f, 0.0f, 0.0f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIIIlIlIlIllIIlllIlI));
        }
        GlStateManager.glNormal3f(0.05625f, 0.0f, 0.0f);
        lllllllllllllIIIlIlIlIllIlIIlIIl.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-7.0, -2.0, -2.0).tex(0.0, 0.15625).endVertex();
        lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-7.0, -2.0, 2.0).tex(0.15625, 0.15625).endVertex();
        lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-7.0, 2.0, 2.0).tex(0.15625, 0.3125).endVertex();
        lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-7.0, 2.0, -2.0).tex(0.0, 0.3125).endVertex();
        lllllllllllllIIIlIlIlIllIlIIlIlI.draw();
        GlStateManager.glNormal3f(-0.05625f, 0.0f, 0.0f);
        lllllllllllllIIIlIlIlIllIlIIlIIl.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-7.0, 2.0, -2.0).tex(0.0, 0.15625).endVertex();
        lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-7.0, 2.0, 2.0).tex(0.15625, 0.15625).endVertex();
        lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-7.0, -2.0, 2.0).tex(0.15625, 0.3125).endVertex();
        lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-7.0, -2.0, -2.0).tex(0.0, 0.3125).endVertex();
        lllllllllllllIIIlIlIlIllIlIIlIlI.draw();
        for (int lllllllllllllIIIlIlIlIllIIllllII = 0; lllllllllllllIIIlIlIlIllIIllllII < 4; ++lllllllllllllIIIlIlIlIllIIllllII) {
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.glNormal3f(0.0f, 0.0f, 0.05625f);
            lllllllllllllIIIlIlIlIllIlIIlIIl.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-8.0, -2.0, 0.0).tex(0.0, 0.0).endVertex();
            lllllllllllllIIIlIlIlIllIlIIlIIl.pos(8.0, -2.0, 0.0).tex(0.5, 0.0).endVertex();
            lllllllllllllIIIlIlIlIllIlIIlIIl.pos(8.0, 2.0, 0.0).tex(0.5, 0.15625).endVertex();
            lllllllllllllIIIlIlIlIllIlIIlIIl.pos(-8.0, 2.0, 0.0).tex(0.0, 0.15625).endVertex();
            lllllllllllllIIIlIlIlIllIlIIlIlI.draw();
        }
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllIIIlIlIlIllIIlllIlI, lllllllllllllIIIlIlIlIllIIlllIIl, lllllllllllllIIIlIlIlIllIIlllIII, lllllllllllllIIIlIlIlIllIIllIlll, lllllllllllllIIIlIlIlIllIIllIllI, lllllllllllllIIIlIlIlIllIIllIlIl);
    }
}
