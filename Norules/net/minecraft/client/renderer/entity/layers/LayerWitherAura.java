package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.boss.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;

public class LayerWitherAura implements LayerRenderer<EntityWither>
{
    private static final /* synthetic */ ResourceLocation WITHER_ARMOR;
    private final /* synthetic */ ModelWither witherModel;
    private final /* synthetic */ RenderWither witherRenderer;
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final EntityWither lllllllllllllIlIlIlIllIllllllllI, final float lllllllllllllIlIlIlIlllIIIIIlIlI, final float lllllllllllllIlIlIlIlllIIIIIlIIl, final float lllllllllllllIlIlIlIlllIIIIIlIII, final float lllllllllllllIlIlIlIllIllllllIlI, final float lllllllllllllIlIlIlIllIllllllIIl, final float lllllllllllllIlIlIlIlllIIIIIIlIl, final float lllllllllllllIlIlIlIllIlllllIlll) {
        if (lllllllllllllIlIlIlIllIllllllllI.isArmored()) {
            GlStateManager.depthMask(!lllllllllllllIlIlIlIllIllllllllI.isInvisible());
            this.witherRenderer.bindTexture(LayerWitherAura.WITHER_ARMOR);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            final float lllllllllllllIlIlIlIlllIIIIIIIll = lllllllllllllIlIlIlIllIllllllllI.ticksExisted + lllllllllllllIlIlIlIlllIIIIIlIII;
            final float lllllllllllllIlIlIlIlllIIIIIIIlI = MathHelper.cos(lllllllllllllIlIlIlIlllIIIIIIIll * 0.02f) * 3.0f;
            final float lllllllllllllIlIlIlIlllIIIIIIIIl = lllllllllllllIlIlIlIlllIIIIIIIll * 0.01f;
            GlStateManager.translate(lllllllllllllIlIlIlIlllIIIIIIIlI, lllllllllllllIlIlIlIlllIIIIIIIIl, 0.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            final float lllllllllllllIlIlIlIlllIIIIIIIII = 0.5f;
            GlStateManager.color(0.5f, 0.5f, 0.5f, 1.0f);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            this.witherModel.setLivingAnimations(lllllllllllllIlIlIlIllIllllllllI, lllllllllllllIlIlIlIlllIIIIIlIlI, lllllllllllllIlIlIlIlllIIIIIlIIl, lllllllllllllIlIlIlIlllIIIIIlIII);
            this.witherModel.setModelAttributes(this.witherRenderer.getMainModel());
            Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
            this.witherModel.render(lllllllllllllIlIlIlIllIllllllllI, lllllllllllllIlIlIlIlllIIIIIlIlI, lllllllllllllIlIlIlIlllIIIIIlIIl, lllllllllllllIlIlIlIllIllllllIlI, lllllllllllllIlIlIlIllIllllllIIl, lllllllllllllIlIlIlIlllIIIIIIlIl, lllllllllllllIlIlIlIllIlllllIlll);
            Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
        }
    }
    
    public LayerWitherAura(final RenderWither lllllllllllllIlIlIlIlllIIIIllIlI) {
        this.witherModel = new ModelWither(0.5f);
        this.witherRenderer = lllllllllllllIlIlIlIlllIIIIllIlI;
    }
    
    static {
        WITHER_ARMOR = new ResourceLocation("textures/entity/wither/wither_armor.png");
    }
}
