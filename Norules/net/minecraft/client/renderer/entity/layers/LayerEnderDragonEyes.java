package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.boss.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.entity.*;

public class LayerEnderDragonEyes implements LayerRenderer<EntityDragon>
{
    private final /* synthetic */ RenderDragon dragonRenderer;
    private static final /* synthetic */ ResourceLocation TEXTURE;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerEnderDragonEyes(final RenderDragon lllllllllllllllllllllIllIIIllIIl) {
        this.dragonRenderer = lllllllllllllllllllllIllIIIllIIl;
    }
    
    @Override
    public void doRenderLayer(final EntityDragon lllllllllllllllllllllIllIIIIIIII, final float lllllllllllllllllllllIllIIIIlIll, final float lllllllllllllllllllllIllIIIIlIlI, final float lllllllllllllllllllllIllIIIIlIIl, final float lllllllllllllllllllllIllIIIIlIII, final float lllllllllllllllllllllIllIIIIIlll, final float lllllllllllllllllllllIllIIIIIllI, final float lllllllllllllllllllllIlIlllllIlI) {
        this.dragonRenderer.bindTexture(LayerEnderDragonEyes.TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthFunc(514);
        final int lllllllllllllllllllllIllIIIIIlII = 61680;
        final int lllllllllllllllllllllIllIIIIIIll = 61680;
        final int lllllllllllllllllllllIllIIIIIIlI = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0f, 0.0f);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
        if (Config.isShaders()) {
            Shaders.beginSpiderEyes();
        }
        Config.getRenderGlobal().renderOverlayEyes = true;
        this.dragonRenderer.getMainModel().render(lllllllllllllllllllllIllIIIIIIII, lllllllllllllllllllllIllIIIIlIll, lllllllllllllllllllllIllIIIIlIlI, lllllllllllllllllllllIllIIIIlIII, lllllllllllllllllllllIllIIIIIlll, lllllllllllllllllllllIllIIIIIllI, lllllllllllllllllllllIlIlllllIlI);
        Config.getRenderGlobal().renderOverlayEyes = false;
        if (Config.isShaders()) {
            Shaders.endSpiderEyes();
        }
        Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
        this.dragonRenderer.setLightmap(lllllllllllllllllllllIllIIIIIIII);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.depthFunc(515);
    }
    
    static {
        TEXTURE = new ResourceLocation("textures/entity/enderdragon/dragon_eyes.png");
    }
}
