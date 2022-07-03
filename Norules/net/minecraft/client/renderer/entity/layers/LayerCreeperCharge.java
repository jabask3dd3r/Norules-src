package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;

public class LayerCreeperCharge implements LayerRenderer<EntityCreeper>
{
    private final /* synthetic */ ModelCreeper creeperModel;
    private static final /* synthetic */ ResourceLocation LIGHTNING_TEXTURE;
    private final /* synthetic */ RenderCreeper creeperRenderer;
    
    @Override
    public void doRenderLayer(final EntityCreeper lllllllllllllIlllIIIlIllllIllIIl, final float lllllllllllllIlllIIIlIllllIllIII, final float lllllllllllllIlllIIIlIllllIlIlll, final float lllllllllllllIlllIIIlIllllIlIllI, final float lllllllllllllIlllIIIlIlllllIIIIl, final float lllllllllllllIlllIIIlIllllIlIlII, final float lllllllllllllIlllIIIlIllllIlIIll, final float lllllllllllllIlllIIIlIllllIlIIlI) {
        if (lllllllllllllIlllIIIlIllllIllIIl.getPowered()) {
            final boolean lllllllllllllIlllIIIlIllllIlllIl = lllllllllllllIlllIIIlIllllIllIIl.isInvisible();
            GlStateManager.depthMask(!lllllllllllllIlllIIIlIllllIlllIl);
            this.creeperRenderer.bindTexture(LayerCreeperCharge.LIGHTNING_TEXTURE);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            final float lllllllllllllIlllIIIlIllllIlllII = lllllllllllllIlllIIIlIllllIllIIl.ticksExisted + lllllllllllllIlllIIIlIllllIlIllI;
            GlStateManager.translate(lllllllllllllIlllIIIlIllllIlllII * 0.01f, lllllllllllllIlllIIIlIllllIlllII * 0.01f, 0.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            final float lllllllllllllIlllIIIlIllllIllIll = 0.5f;
            GlStateManager.color(0.5f, 0.5f, 0.5f, 1.0f);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            this.creeperModel.setModelAttributes(this.creeperRenderer.getMainModel());
            Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
            this.creeperModel.render(lllllllllllllIlllIIIlIllllIllIIl, lllllllllllllIlllIIIlIllllIllIII, lllllllllllllIlllIIIlIllllIlIlll, lllllllllllllIlllIIIlIlllllIIIIl, lllllllllllllIlllIIIlIllllIlIlII, lllllllllllllIlllIIIlIllllIlIIll, lllllllllllllIlllIIIlIllllIlIIlI);
            Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(lllllllllllllIlllIIIlIllllIlllIl);
        }
    }
    
    static {
        LIGHTNING_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public LayerCreeperCharge(final RenderCreeper lllllllllllllIlllIIIlIllllllIIll) {
        this.creeperModel = new ModelCreeper(2.0f);
        this.creeperRenderer = lllllllllllllIlllIIIlIllllllIIll;
    }
}
