package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class RenderDragonFireball extends Render<EntityDragonFireball>
{
    private static final /* synthetic */ ResourceLocation DRAGON_FIREBALL_TEXTURE;
    
    public RenderDragonFireball(final RenderManager lIIIlIIlIIlllI) {
        super(lIIIlIIlIIlllI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityDragonFireball lIIIlIIIlIIllI) {
        return RenderDragonFireball.DRAGON_FIREBALL_TEXTURE;
    }
    
    @Override
    public void doRender(final EntityDragonFireball lIIIlIIIllIIlI, final double lIIIlIIIllllIl, final double lIIIlIIIllIIII, final double lIIIlIIIlllIll, final float lIIIlIIIlllIlI, final float lIIIlIIIlIllIl) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(lIIIlIIIllIIlI);
        GlStateManager.translate((float)lIIIlIIIllllIl, (float)lIIIlIIIllIIII, (float)lIIIlIIIlllIll);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        final Tessellator lIIIlIIIlllIII = Tessellator.getInstance();
        final BufferBuilder lIIIlIIIllIlll = lIIIlIIIlllIII.getBuffer();
        final float lIIIlIIIllIllI = 1.0f;
        final float lIIIlIIIllIlIl = 0.5f;
        final float lIIIlIIIllIlII = 0.25f;
        GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * -this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lIIIlIIIllIIlI));
        }
        lIIIlIIIllIlll.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        lIIIlIIIllIlll.pos(-0.5, -0.25, 0.0).tex(0.0, 1.0).normal(0.0f, 1.0f, 0.0f).endVertex();
        lIIIlIIIllIlll.pos(0.5, -0.25, 0.0).tex(1.0, 1.0).normal(0.0f, 1.0f, 0.0f).endVertex();
        lIIIlIIIllIlll.pos(0.5, 0.75, 0.0).tex(1.0, 0.0).normal(0.0f, 1.0f, 0.0f).endVertex();
        lIIIlIIIllIlll.pos(-0.5, 0.75, 0.0).tex(0.0, 0.0).normal(0.0f, 1.0f, 0.0f).endVertex();
        lIIIlIIIlllIII.draw();
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(lIIIlIIIllIIlI, lIIIlIIIllllIl, lIIIlIIIllIIII, lIIIlIIIlllIll, lIIIlIIIlllIlI, lIIIlIIIlIllIl);
    }
    
    static {
        DRAGON_FIREBALL_TEXTURE = new ResourceLocation("textures/entity/enderdragon/dragon_fireball.png");
    }
}
