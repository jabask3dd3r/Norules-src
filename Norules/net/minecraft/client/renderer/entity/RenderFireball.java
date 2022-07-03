package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.client.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;

public class RenderFireball extends Render<EntityFireball>
{
    private final /* synthetic */ float scale;
    
    @Override
    public void doRender(final EntityFireball lllllllllllllIIllllIIIlIIIlIIIlI, final double lllllllllllllIIllllIIIlIIIlIIIIl, final double lllllllllllllIIllllIIIlIIIllIIIl, final double lllllllllllllIIllllIIIlIIIllIIII, final float lllllllllllllIIllllIIIlIIIlIllll, final float lllllllllllllIIllllIIIlIIIlIlllI) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(lllllllllllllIIllllIIIlIIIlIIIlI);
        GlStateManager.translate((float)lllllllllllllIIllllIIIlIIIlIIIIl, (float)lllllllllllllIIllllIIIlIIIllIIIl, (float)lllllllllllllIIllllIIIlIIIllIIII);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(this.scale, this.scale, this.scale);
        final TextureAtlasSprite lllllllllllllIIllllIIIlIIIlIllIl = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(Items.FIRE_CHARGE);
        final Tessellator lllllllllllllIIllllIIIlIIIlIllII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIllllIIIlIIIlIlIll = lllllllllllllIIllllIIIlIIIlIllII.getBuffer();
        final float lllllllllllllIIllllIIIlIIIlIlIlI = lllllllllllllIIllllIIIlIIIlIllIl.getMinU();
        final float lllllllllllllIIllllIIIlIIIlIlIIl = lllllllllllllIIllllIIIlIIIlIllIl.getMaxU();
        final float lllllllllllllIIllllIIIlIIIlIlIII = lllllllllllllIIllllIIIlIIIlIllIl.getMinV();
        final float lllllllllllllIIllllIIIlIIIlIIlll = lllllllllllllIIllllIIIlIIIlIllIl.getMaxV();
        final float lllllllllllllIIllllIIIlIIIlIIllI = 1.0f;
        final float lllllllllllllIIllllIIIlIIIlIIlIl = 0.5f;
        final float lllllllllllllIIllllIIIlIIIlIIlII = 0.25f;
        GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * -this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIIllllIIIlIIIlIIIlI));
        }
        lllllllllllllIIllllIIIlIIIlIlIll.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        lllllllllllllIIllllIIIlIIIlIlIll.pos(-0.5, -0.25, 0.0).tex(lllllllllllllIIllllIIIlIIIlIlIlI, lllllllllllllIIllllIIIlIIIlIIlll).normal(0.0f, 1.0f, 0.0f).endVertex();
        lllllllllllllIIllllIIIlIIIlIlIll.pos(0.5, -0.25, 0.0).tex(lllllllllllllIIllllIIIlIIIlIlIIl, lllllllllllllIIllllIIIlIIIlIIlll).normal(0.0f, 1.0f, 0.0f).endVertex();
        lllllllllllllIIllllIIIlIIIlIlIll.pos(0.5, 0.75, 0.0).tex(lllllllllllllIIllllIIIlIIIlIlIIl, lllllllllllllIIllllIIIlIIIlIlIII).normal(0.0f, 1.0f, 0.0f).endVertex();
        lllllllllllllIIllllIIIlIIIlIlIll.pos(-0.5, 0.75, 0.0).tex(lllllllllllllIIllllIIIlIIIlIlIlI, lllllllllllllIIllllIIIlIIIlIlIII).normal(0.0f, 1.0f, 0.0f).endVertex();
        lllllllllllllIIllllIIIlIIIlIllII.draw();
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllIIllllIIIlIIIlIIIlI, lllllllllllllIIllllIIIlIIIlIIIIl, lllllllllllllIIllllIIIlIIIllIIIl, lllllllllllllIIllllIIIlIIIllIIII, lllllllllllllIIllllIIIlIIIlIllll, lllllllllllllIIllllIIIlIIIlIlllI);
    }
    
    public RenderFireball(final RenderManager lllllllllllllIIllllIIIlIIlIIIlll, final float lllllllllllllIIllllIIIlIIlIIIllI) {
        super(lllllllllllllIIllllIIIlIIlIIIlll);
        this.scale = lllllllllllllIIllllIIIlIIlIIIllI;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityFireball lllllllllllllIIllllIIIlIIIIlIIIl) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
