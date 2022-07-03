package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerHeldBlock implements LayerRenderer<EntityEnderman>
{
    private final /* synthetic */ RenderEnderman endermanRenderer;
    
    @Override
    public void doRenderLayer(final EntityEnderman lllllllllllllllIIlIIlIlIIlIIIIlI, final float lllllllllllllllIIlIIlIlIIlIIIIIl, final float lllllllllllllllIIlIIlIlIIlIIIIII, final float lllllllllllllllIIlIIlIlIIIllllll, final float lllllllllllllllIIlIIlIlIIIlllllI, final float lllllllllllllllIIlIIlIlIIIllllIl, final float lllllllllllllllIIlIIlIlIIIllllII, final float lllllllllllllllIIlIIlIlIIIlllIll) {
        final IBlockState lllllllllllllllIIlIIlIlIIIlllIlI = lllllllllllllllIIlIIlIlIIlIIIIlI.getHeldBlockState();
        if (lllllllllllllllIIlIIlIlIIIlllIlI != null) {
            final BlockRendererDispatcher lllllllllllllllIIlIIlIlIIIlllIIl = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.6875f, -0.75f);
            GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.25f, 0.1875f, 0.25f);
            final float lllllllllllllllIIlIIlIlIIIlllIII = 0.5f;
            GlStateManager.scale(-0.5f, -0.5f, 0.5f);
            final int lllllllllllllllIIlIIlIlIIIllIlll = lllllllllllllllIIlIIlIlIIlIIIIlI.getBrightnessForRender();
            final int lllllllllllllllIIlIIlIlIIIllIllI = lllllllllllllllIIlIIlIlIIIllIlll % 65536;
            final int lllllllllllllllIIlIIlIlIIIllIlIl = lllllllllllllllIIlIIlIlIIIllIlll / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllllIIlIIlIlIIIllIllI, (float)lllllllllllllllIIlIIlIlIIIllIlIl);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.endermanRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            lllllllllllllllIIlIIlIlIIIlllIIl.renderBlockBrightness(lllllllllllllllIIlIIlIlIIIlllIlI, 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }
    
    public LayerHeldBlock(final RenderEnderman lllllllllllllllIIlIIlIlIIlIIlllI) {
        this.endermanRenderer = lllllllllllllllIIlIIlIlIIlIIlllI;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
