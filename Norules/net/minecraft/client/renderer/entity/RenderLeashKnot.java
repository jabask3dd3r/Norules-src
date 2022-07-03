package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderLeashKnot extends Render<EntityLeashKnot>
{
    private final /* synthetic */ ModelLeashKnot leashKnotModel;
    private static final /* synthetic */ ResourceLocation LEASH_KNOT_TEXTURES;
    
    @Override
    public void doRender(final EntityLeashKnot lIIlIIIIlIIllll, final double lIIlIIIIlIlIllI, final double lIIlIIIIlIlIlIl, final double lIIlIIIIlIIllII, final float lIIlIIIIlIlIIll, final float lIIlIIIIlIlIIlI) {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        GlStateManager.translate((float)lIIlIIIIlIlIllI, (float)lIIlIIIIlIlIlIl, (float)lIIlIIIIlIIllII);
        final float lIIlIIIIlIlIIIl = 0.0625f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        GlStateManager.enableAlpha();
        this.bindEntityTexture(lIIlIIIIlIIllll);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lIIlIIIIlIIllll));
        }
        this.leashKnotModel.render(lIIlIIIIlIIllll, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        super.doRender(lIIlIIIIlIIllll, lIIlIIIIlIlIllI, lIIlIIIIlIlIlIl, lIIlIIIIlIIllII, lIIlIIIIlIlIIll, lIIlIIIIlIlIIlI);
    }
    
    static {
        LEASH_KNOT_TEXTURES = new ResourceLocation("textures/entity/lead_knot.png");
    }
    
    public RenderLeashKnot(final RenderManager lIIlIIIIllIIIIl) {
        super(lIIlIIIIllIIIIl);
        this.leashKnotModel = new ModelLeashKnot();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityLeashKnot lIIlIIIIlIIIlll) {
        return RenderLeashKnot.LEASH_KNOT_TEXTURES;
    }
}
