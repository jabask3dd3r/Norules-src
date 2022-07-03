package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.passive.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerMooshroomMushroom implements LayerRenderer<EntityMooshroom>
{
    private final /* synthetic */ RenderMooshroom mooshroomRenderer;
    
    @Override
    public void doRenderLayer(final EntityMooshroom lllllllllllllIllllIIllIIllIIIlII, final float lllllllllllllIllllIIllIIllIIIIll, final float lllllllllllllIllllIIllIIllIIIIlI, final float lllllllllllllIllllIIllIIllIIIIIl, final float lllllllllllllIllllIIllIIllIIIIII, final float lllllllllllllIllllIIllIIlIllllll, final float lllllllllllllIllllIIllIIlIlllllI, final float lllllllllllllIllllIIllIIlIllllIl) {
        if (!lllllllllllllIllllIIllIIllIIIlII.isChild() && !lllllllllllllIllllIIllIIllIIIlII.isInvisible()) {
            final BlockRendererDispatcher lllllllllllllIllllIIllIIlIllllII = Minecraft.getMinecraft().getBlockRendererDispatcher();
            this.mooshroomRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            GlStateManager.enableCull();
            GlStateManager.cullFace(GlStateManager.CullFace.FRONT);
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f, -1.0f, 1.0f);
            GlStateManager.translate(0.2f, 0.35f, 0.5f);
            GlStateManager.rotate(42.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate(-0.5f, -0.5f, 0.5f);
            lllllllllllllIllllIIllIIlIllllII.renderBlockBrightness(Blocks.RED_MUSHROOM.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.1f, 0.0f, -0.6f);
            GlStateManager.rotate(42.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, 0.5f);
            lllllllllllllIllllIIllIIlIllllII.renderBlockBrightness(Blocks.RED_MUSHROOM.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            this.mooshroomRenderer.getMainModel().head.postRender(0.0625f);
            GlStateManager.scale(1.0f, -1.0f, 1.0f);
            GlStateManager.translate(0.0f, 0.7f, -0.2f);
            GlStateManager.rotate(12.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(-0.5f, -0.5f, 0.5f);
            lllllllllllllIllllIIllIIlIllllII.renderBlockBrightness(Blocks.RED_MUSHROOM.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.cullFace(GlStateManager.CullFace.BACK);
            GlStateManager.disableCull();
        }
    }
    
    public LayerMooshroomMushroom(final RenderMooshroom lllllllllllllIllllIIllIIllIIlIIl) {
        this.mooshroomRenderer = lllllllllllllIllllIIllIIllIIlIIl;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
