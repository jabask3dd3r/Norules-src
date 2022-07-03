package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class LayerSaddle implements LayerRenderer<EntityPig>
{
    private static final /* synthetic */ ResourceLocation TEXTURE;
    private final /* synthetic */ RenderPig pigRenderer;
    private final /* synthetic */ ModelPig pigModel;
    
    static {
        TEXTURE = new ResourceLocation("textures/entity/pig/pig_saddle.png");
    }
    
    @Override
    public void doRenderLayer(final EntityPig lllllllllllllllIIIlIllllIlIIIIll, final float lllllllllllllllIIIlIllllIlIIIIlI, final float lllllllllllllllIIIlIllllIlIIlIlI, final float lllllllllllllllIIIlIllllIlIIlIIl, final float lllllllllllllllIIIlIllllIlIIIIII, final float lllllllllllllllIIIlIllllIIllllll, final float lllllllllllllllIIIlIllllIIlllllI, final float lllllllllllllllIIIlIllllIlIIIlIl) {
        if (lllllllllllllllIIIlIllllIlIIIIll.getSaddled()) {
            this.pigRenderer.bindTexture(LayerSaddle.TEXTURE);
            this.pigModel.setModelAttributes(this.pigRenderer.getMainModel());
            this.pigModel.render(lllllllllllllllIIIlIllllIlIIIIll, lllllllllllllllIIIlIllllIlIIIIlI, lllllllllllllllIIIlIllllIlIIlIlI, lllllllllllllllIIIlIllllIlIIIIII, lllllllllllllllIIIlIllllIIllllll, lllllllllllllllIIIlIllllIIlllllI, lllllllllllllllIIIlIllllIlIIIlIl);
        }
    }
    
    public LayerSaddle(final RenderPig lllllllllllllllIIIlIllllIlIlIllI) {
        this.pigModel = new ModelPig(0.5f);
        this.pigRenderer = lllllllllllllllIIIlIllllIlIlIllI;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
