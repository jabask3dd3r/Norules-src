package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.entity.*;

public class LayerEndermanEyes implements LayerRenderer<EntityEnderman>
{
    private static final /* synthetic */ ResourceLocation RES_ENDERMAN_EYES;
    private final /* synthetic */ RenderEnderman endermanRenderer;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    static {
        RES_ENDERMAN_EYES = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
    }
    
    public LayerEndermanEyes(final RenderEnderman llllllllllllIlllllIIIllllIIIIlIl) {
        this.endermanRenderer = llllllllllllIlllllIIIllllIIIIlIl;
    }
    
    @Override
    public void doRenderLayer(final EntityEnderman llllllllllllIlllllIIIlllIllIllII, final float llllllllllllIlllllIIIlllIllIlIll, final float llllllllllllIlllllIIIlllIllIlIlI, final float llllllllllllIlllllIIIlllIlllIlIl, final float llllllllllllIlllllIIIlllIlllIlII, final float llllllllllllIlllllIIIlllIlllIIll, final float llllllllllllIlllllIIIlllIllIIlll, final float llllllllllllIlllllIIIlllIllIIllI) {
        this.endermanRenderer.bindTexture(LayerEndermanEyes.RES_ENDERMAN_EYES);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(!llllllllllllIlllllIIIlllIllIllII.isInvisible());
        final int llllllllllllIlllllIIIlllIlllIIII = 61680;
        final int llllllllllllIlllllIIIlllIllIllll = 61680;
        final int llllllllllllIlllllIIIlllIllIlllI = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0f, 0.0f);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
        if (Config.isShaders()) {
            Shaders.beginSpiderEyes();
        }
        Config.getRenderGlobal().renderOverlayEyes = true;
        this.endermanRenderer.getMainModel().render(llllllllllllIlllllIIIlllIllIllII, llllllllllllIlllllIIIlllIllIlIll, llllllllllllIlllllIIIlllIllIlIlI, llllllllllllIlllllIIIlllIlllIlII, llllllllllllIlllllIIIlllIlllIIll, llllllllllllIlllllIIIlllIllIIlll, llllllllllllIlllllIIIlllIllIIllI);
        Config.getRenderGlobal().renderOverlayEyes = false;
        if (Config.isShaders()) {
            Shaders.endSpiderEyes();
        }
        Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
        this.endermanRenderer.setLightmap(llllllllllllIlllllIIIlllIllIllII);
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }
}
