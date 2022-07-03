package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class LayerDeadmau5Head implements LayerRenderer<AbstractClientPlayer>
{
    private final /* synthetic */ RenderPlayer playerRenderer;
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    public LayerDeadmau5Head(final RenderPlayer lllllllllllllIIIlllIIIlIlllIllIl) {
        this.playerRenderer = lllllllllllllIIIlllIIIlIlllIllIl;
    }
    
    @Override
    public void doRenderLayer(final AbstractClientPlayer lllllllllllllIIIlllIIIlIlllIIlII, final float lllllllllllllIIIlllIIIlIlllIIIll, final float lllllllllllllIIIlllIIIlIlllIIIlI, final float lllllllllllllIIIlllIIIlIllIlIllI, final float lllllllllllllIIIlllIIIlIlllIIIII, final float lllllllllllllIIIlllIIIlIllIlllll, final float lllllllllllllIIIlllIIIlIllIllllI, final float lllllllllllllIIIlllIIIlIllIlllIl) {
        if ("deadmau5".equals(lllllllllllllIIIlllIIIlIlllIIlII.getName()) && lllllllllllllIIIlllIIIlIlllIIlII.hasSkin() && !lllllllllllllIIIlllIIIlIlllIIlII.isInvisible()) {
            this.playerRenderer.bindTexture(lllllllllllllIIIlllIIIlIlllIIlII.getLocationSkin());
            for (int lllllllllllllIIIlllIIIlIllIlllII = 0; lllllllllllllIIIlllIIIlIllIlllII < 2; ++lllllllllllllIIIlllIIIlIllIlllII) {
                final float lllllllllllllIIIlllIIIlIllIllIll = lllllllllllllIIIlllIIIlIlllIIlII.prevRotationYaw + (lllllllllllllIIIlllIIIlIlllIIlII.rotationYaw - lllllllllllllIIIlllIIIlIlllIIlII.prevRotationYaw) * lllllllllllllIIIlllIIIlIllIlIllI - (lllllllllllllIIIlllIIIlIlllIIlII.prevRenderYawOffset + (lllllllllllllIIIlllIIIlIlllIIlII.renderYawOffset - lllllllllllllIIIlllIIIlIlllIIlII.prevRenderYawOffset) * lllllllllllllIIIlllIIIlIllIlIllI);
                final float lllllllllllllIIIlllIIIlIllIllIlI = lllllllllllllIIIlllIIIlIlllIIlII.prevRotationPitch + (lllllllllllllIIIlllIIIlIlllIIlII.rotationPitch - lllllllllllllIIIlllIIIlIlllIIlII.prevRotationPitch) * lllllllllllllIIIlllIIIlIllIlIllI;
                GlStateManager.pushMatrix();
                GlStateManager.rotate(lllllllllllllIIIlllIIIlIllIllIll, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(lllllllllllllIIIlllIIIlIllIllIlI, 1.0f, 0.0f, 0.0f);
                GlStateManager.translate(0.375f * (lllllllllllllIIIlllIIIlIllIlllII * 2 - 1), 0.0f, 0.0f);
                GlStateManager.translate(0.0f, -0.375f, 0.0f);
                GlStateManager.rotate(-lllllllllllllIIIlllIIIlIllIllIlI, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-lllllllllllllIIIlllIIIlIllIllIll, 0.0f, 1.0f, 0.0f);
                final float lllllllllllllIIIlllIIIlIllIllIIl = 1.3333334f;
                GlStateManager.scale(1.3333334f, 1.3333334f, 1.3333334f);
                this.playerRenderer.getMainModel().renderDeadmau5Head(0.0625f);
                GlStateManager.popMatrix();
            }
        }
    }
}
