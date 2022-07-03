package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.entity.*;

public class LayerSpiderEyes<T extends EntitySpider> implements LayerRenderer<T>
{
    private static final /* synthetic */ ResourceLocation SPIDER_EYES;
    private final /* synthetic */ RenderSpider<T> spiderRenderer;
    
    public LayerSpiderEyes(final RenderSpider<T> lllllllllllllIIlIIllIlllIIlIlIlI) {
        this.spiderRenderer = lllllllllllllIIlIIllIlllIIlIlIlI;
    }
    
    static {
        SPIDER_EYES = new ResourceLocation("textures/entity/spider_eyes.png");
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final T lllllllllllllIIlIIllIlllIIIlllIl, final float lllllllllllllIIlIIllIlllIIIlllII, final float lllllllllllllIIlIIllIlllIIIllIll, final float lllllllllllllIIlIIllIlllIIIllIlI, final float lllllllllllllIIlIIllIlllIIIllIIl, final float lllllllllllllIIlIIllIlllIIIIllIl, final float lllllllllllllIIlIIllIlllIIIlIlll, final float lllllllllllllIIlIIllIlllIIIlIllI) {
        this.spiderRenderer.bindTexture(LayerSpiderEyes.SPIDER_EYES);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        if (lllllllllllllIIlIIllIlllIIIlllIl.isInvisible()) {
            GlStateManager.depthMask(false);
        }
        else {
            GlStateManager.depthMask(true);
        }
        int lllllllllllllIIlIIllIlllIIIlIlIl = 61680;
        int lllllllllllllIIlIIllIlllIIIlIlII = lllllllllllllIIlIIllIlllIIIlIlIl % 65536;
        int lllllllllllllIIlIIllIlllIIIlIIll = lllllllllllllIIlIIllIlllIIIlIlIl / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllIIlIIllIlllIIIlIlII, (float)lllllllllllllIIlIIllIlllIIIlIIll);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
        if (Config.isShaders()) {
            Shaders.beginSpiderEyes();
        }
        Config.getRenderGlobal().renderOverlayEyes = true;
        this.spiderRenderer.getMainModel().render(lllllllllllllIIlIIllIlllIIIlllIl, lllllllllllllIIlIIllIlllIIIlllII, lllllllllllllIIlIIllIlllIIIllIll, lllllllllllllIIlIIllIlllIIIllIIl, lllllllllllllIIlIIllIlllIIIIllIl, lllllllllllllIIlIIllIlllIIIlIlll, lllllllllllllIIlIIllIlllIIIlIllI);
        Config.getRenderGlobal().renderOverlayEyes = false;
        if (Config.isShaders()) {
            Shaders.endSpiderEyes();
        }
        Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
        lllllllllllllIIlIIllIlllIIIlIlIl = lllllllllllllIIlIIllIlllIIIlllIl.getBrightnessForRender();
        lllllllllllllIIlIIllIlllIIIlIlII = lllllllllllllIIlIIllIlllIIIlIlIl % 65536;
        lllllllllllllIIlIIllIlllIIIlIIll = lllllllllllllIIlIIllIlllIIIlIlIl / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllIIlIIllIlllIIIlIlII, (float)lllllllllllllIIlIIllIlllIIIlIIll);
        this.spiderRenderer.setLightmap(lllllllllllllIIlIIllIlllIIIlllIl);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }
}
