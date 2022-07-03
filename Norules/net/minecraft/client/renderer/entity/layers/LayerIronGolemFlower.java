package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerIronGolemFlower implements LayerRenderer<EntityIronGolem>
{
    private final /* synthetic */ RenderIronGolem ironGolemRenderer;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final EntityIronGolem lllllllllllllllIlIllllllllIlIIIl, final float lllllllllllllllIlIllllllllIlIIII, final float lllllllllllllllIlIllllllllIIllll, final float lllllllllllllllIlIllllllllIIlllI, final float lllllllllllllllIlIllllllllIIllIl, final float lllllllllllllllIlIllllllllIIllII, final float lllllllllllllllIlIllllllllIIlIll, final float lllllllllllllllIlIllllllllIIlIlI) {
        if (lllllllllllllllIlIllllllllIlIIIl.getHoldRoseTick() != 0) {
            final BlockRendererDispatcher lllllllllllllllIlIllllllllIIlIIl = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.rotate(5.0f + 180.0f * ((ModelIronGolem)this.ironGolemRenderer.getMainModel()).ironGolemRightArm.rotateAngleX / 3.1415927f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.translate(-0.9375f, -0.625f, -0.9375f);
            final float lllllllllllllllIlIllllllllIIlIII = 0.5f;
            GlStateManager.scale(0.5f, -0.5f, 0.5f);
            final int lllllllllllllllIlIllllllllIIIlll = lllllllllllllllIlIllllllllIlIIIl.getBrightnessForRender();
            final int lllllllllllllllIlIllllllllIIIllI = lllllllllllllllIlIllllllllIIIlll % 65536;
            final int lllllllllllllllIlIllllllllIIIlIl = lllllllllllllllIlIllllllllIIIlll / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllllIlIllllllllIIIllI, (float)lllllllllllllllIlIllllllllIIIlIl);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.ironGolemRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            lllllllllllllllIlIllllllllIIlIIl.renderBlockBrightness(Blocks.RED_FLOWER.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }
    
    public LayerIronGolemFlower(final RenderIronGolem lllllllllllllllIlIllllllllIlllII) {
        this.ironGolemRenderer = lllllllllllllllIlIllllllllIlllII;
    }
}
