package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerStrayClothing implements LayerRenderer<EntityStray>
{
    private static final /* synthetic */ ResourceLocation STRAY_CLOTHES_TEXTURES;
    private final /* synthetic */ ModelSkeleton layerModel;
    private final /* synthetic */ RenderLivingBase<?> renderer;
    
    static {
        STRAY_CLOTHES_TEXTURES = new ResourceLocation("textures/entity/skeleton/stray_overlay.png");
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
    
    @Override
    public void doRenderLayer(final EntityStray llllllllllllllllllIIlIlIIIIIIIlI, final float llllllllllllllllllIIlIlIIIIIIIIl, final float llllllllllllllllllIIlIlIIIIIlIIl, final float llllllllllllllllllIIlIIlllllllll, final float llllllllllllllllllIIlIIllllllllI, final float llllllllllllllllllIIlIIlllllllIl, final float llllllllllllllllllIIlIlIIIIIIlIl, final float llllllllllllllllllIIlIIllllllIll) {
        this.layerModel.setModelAttributes(this.renderer.getMainModel());
        this.layerModel.setLivingAnimations(llllllllllllllllllIIlIlIIIIIIIlI, llllllllllllllllllIIlIlIIIIIIIIl, llllllllllllllllllIIlIlIIIIIlIIl, llllllllllllllllllIIlIIlllllllll);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.renderer.bindTexture(LayerStrayClothing.STRAY_CLOTHES_TEXTURES);
        this.layerModel.render(llllllllllllllllllIIlIlIIIIIIIlI, llllllllllllllllllIIlIlIIIIIIIIl, llllllllllllllllllIIlIlIIIIIlIIl, llllllllllllllllllIIlIIllllllllI, llllllllllllllllllIIlIIlllllllIl, llllllllllllllllllIIlIlIIIIIIlIl, llllllllllllllllllIIlIIllllllIll);
    }
    
    public LayerStrayClothing(final RenderLivingBase<?> llllllllllllllllllIIlIlIIIIllIII) {
        this.layerModel = new ModelSkeleton(0.25f, true);
        this.renderer = llllllllllllllllllIIlIlIIIIllIII;
    }
}
