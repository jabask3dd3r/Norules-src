package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderWitherSkull extends Render<EntityWitherSkull>
{
    private static final /* synthetic */ ResourceLocation INVULNERABLE_WITHER_TEXTURES;
    private static final /* synthetic */ ResourceLocation WITHER_TEXTURES;
    private final /* synthetic */ ModelSkeletonHead skeletonHeadModel;
    
    private float getRenderYaw(final float lllllllllllllIIIIIIIIlIlllIlllIl, final float lllllllllllllIIIIIIIIlIlllIlllII, final float lllllllllllllIIIIIIIIlIlllIlIlll) {
        float lllllllllllllIIIIIIIIlIlllIllIlI;
        for (lllllllllllllIIIIIIIIlIlllIllIlI = lllllllllllllIIIIIIIIlIlllIlllII - lllllllllllllIIIIIIIIlIlllIlllIl; lllllllllllllIIIIIIIIlIlllIllIlI < -180.0f; lllllllllllllIIIIIIIIlIlllIllIlI += 360.0f) {}
        while (lllllllllllllIIIIIIIIlIlllIllIlI >= 180.0f) {
            lllllllllllllIIIIIIIIlIlllIllIlI -= 360.0f;
        }
        return lllllllllllllIIIIIIIIlIlllIlllIl + lllllllllllllIIIIIIIIlIlllIlIlll * lllllllllllllIIIIIIIIlIlllIllIlI;
    }
    
    @Override
    public void doRender(final EntityWitherSkull lllllllllllllIIIIIIIIlIlllIIlIlI, final double lllllllllllllIIIIIIIIlIlllIIlIIl, final double lllllllllllllIIIIIIIIlIllIlllllI, final double lllllllllllllIIIIIIIIlIlllIIIlll, final float lllllllllllllIIIIIIIIlIllIllllII, final float lllllllllllllIIIIIIIIlIlllIIIlIl) {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        final float lllllllllllllIIIIIIIIlIlllIIIlII = this.getRenderYaw(lllllllllllllIIIIIIIIlIlllIIlIlI.prevRotationYaw, lllllllllllllIIIIIIIIlIlllIIlIlI.rotationYaw, lllllllllllllIIIIIIIIlIlllIIIlIl);
        final float lllllllllllllIIIIIIIIlIlllIIIIll = lllllllllllllIIIIIIIIlIlllIIlIlI.prevRotationPitch + (lllllllllllllIIIIIIIIlIlllIIlIlI.rotationPitch - lllllllllllllIIIIIIIIlIlllIIlIlI.prevRotationPitch) * lllllllllllllIIIIIIIIlIlllIIIlIl;
        GlStateManager.translate((float)lllllllllllllIIIIIIIIlIlllIIlIIl, (float)lllllllllllllIIIIIIIIlIllIlllllI, (float)lllllllllllllIIIIIIIIlIlllIIIlll);
        final float lllllllllllllIIIIIIIIlIlllIIIIlI = 0.0625f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        GlStateManager.enableAlpha();
        this.bindEntityTexture(lllllllllllllIIIIIIIIlIlllIIlIlI);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIIIIIIIIlIlllIIlIlI));
        }
        this.skeletonHeadModel.render(lllllllllllllIIIIIIIIlIlllIIlIlI, 0.0f, 0.0f, 0.0f, lllllllllllllIIIIIIIIlIlllIIIlII, lllllllllllllIIIIIIIIlIlllIIIIll, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllIIIIIIIIlIlllIIlIlI, lllllllllllllIIIIIIIIlIlllIIlIIl, lllllllllllllIIIIIIIIlIllIlllllI, lllllllllllllIIIIIIIIlIlllIIIlll, lllllllllllllIIIIIIIIlIllIllllII, lllllllllllllIIIIIIIIlIlllIIIlIl);
    }
    
    public RenderWitherSkull(final RenderManager lllllllllllllIIIIIIIIlIllllIIIll) {
        super(lllllllllllllIIIIIIIIlIllllIIIll);
        this.skeletonHeadModel = new ModelSkeletonHead();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityWitherSkull lllllllllllllIIIIIIIIlIllIllIlIl) {
        return lllllllllllllIIIIIIIIlIllIllIlIl.isInvulnerable() ? RenderWitherSkull.INVULNERABLE_WITHER_TEXTURES : RenderWitherSkull.WITHER_TEXTURES;
    }
    
    static {
        INVULNERABLE_WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
        WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither.png");
    }
}
