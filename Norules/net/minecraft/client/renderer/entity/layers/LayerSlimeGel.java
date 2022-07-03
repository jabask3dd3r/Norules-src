package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;

public class LayerSlimeGel implements LayerRenderer<EntitySlime>
{
    private final /* synthetic */ ModelBase slimeModel;
    private final /* synthetic */ RenderSlime slimeRenderer;
    
    @Override
    public void doRenderLayer(final EntitySlime lllllllllllllIIlllllIIllIlIIllIl, final float lllllllllllllIIlllllIIllIlIIllII, final float lllllllllllllIIlllllIIllIlIIlIll, final float lllllllllllllIIlllllIIllIlIlIIll, final float lllllllllllllIIlllllIIllIlIIlIlI, final float lllllllllllllIIlllllIIllIlIlIIIl, final float lllllllllllllIIlllllIIllIlIlIIII, final float lllllllllllllIIlllllIIllIlIIIlll) {
        if (!lllllllllllllIIlllllIIllIlIIllIl.isInvisible()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.slimeModel.setModelAttributes(this.slimeRenderer.getMainModel());
            this.slimeModel.render(lllllllllllllIIlllllIIllIlIIllIl, lllllllllllllIIlllllIIllIlIIllII, lllllllllllllIIlllllIIllIlIIlIll, lllllllllllllIIlllllIIllIlIIlIlI, lllllllllllllIIlllllIIllIlIlIIIl, lllllllllllllIIlllllIIllIlIlIIII, lllllllllllllIIlllllIIllIlIIIlll);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
    }
    
    public LayerSlimeGel(final RenderSlime lllllllllllllIIlllllIIllIllIlIIl) {
        this.slimeModel = new ModelSlime(0);
        this.slimeRenderer = lllllllllllllIIlllllIIllIllIlIIl;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
