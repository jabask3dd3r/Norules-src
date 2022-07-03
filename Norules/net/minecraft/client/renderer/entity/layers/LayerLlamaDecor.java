package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.passive.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class LayerLlamaDecor implements LayerRenderer<EntityLlama>
{
    private final /* synthetic */ RenderLlama field_191365_b;
    private final /* synthetic */ ModelLlama field_191366_c;
    private static final /* synthetic */ ResourceLocation[] field_191364_a;
    
    static {
        field_191364_a = new ResourceLocation[] { new ResourceLocation("textures/entity/llama/decor/decor_white.png"), new ResourceLocation("textures/entity/llama/decor/decor_orange.png"), new ResourceLocation("textures/entity/llama/decor/decor_magenta.png"), new ResourceLocation("textures/entity/llama/decor/decor_light_blue.png"), new ResourceLocation("textures/entity/llama/decor/decor_yellow.png"), new ResourceLocation("textures/entity/llama/decor/decor_lime.png"), new ResourceLocation("textures/entity/llama/decor/decor_pink.png"), new ResourceLocation("textures/entity/llama/decor/decor_gray.png"), new ResourceLocation("textures/entity/llama/decor/decor_silver.png"), new ResourceLocation("textures/entity/llama/decor/decor_cyan.png"), new ResourceLocation("textures/entity/llama/decor/decor_purple.png"), new ResourceLocation("textures/entity/llama/decor/decor_blue.png"), new ResourceLocation("textures/entity/llama/decor/decor_brown.png"), new ResourceLocation("textures/entity/llama/decor/decor_green.png"), new ResourceLocation("textures/entity/llama/decor/decor_red.png"), new ResourceLocation("textures/entity/llama/decor/decor_black.png") };
    }
    
    public LayerLlamaDecor(final RenderLlama llllllllllllllIIIIllIlIlllllIlII) {
        this.field_191366_c = new ModelLlama(0.5f);
        this.field_191365_b = llllllllllllllIIIIllIlIlllllIlII;
    }
    
    @Override
    public void doRenderLayer(final EntityLlama llllllllllllllIIIIllIlIllllIlIII, final float llllllllllllllIIIIllIlIllllIIlll, final float llllllllllllllIIIIllIlIllllIIllI, final float llllllllllllllIIIIllIlIllllIIlIl, final float llllllllllllllIIIIllIlIllllIIlII, final float llllllllllllllIIIIllIlIllllIIIll, final float llllllllllllllIIIIllIlIllllIIIlI, final float llllllllllllllIIIIllIlIlllIllIIl) {
        if (llllllllllllllIIIIllIlIllllIlIII.func_190717_dN()) {
            this.field_191365_b.bindTexture(LayerLlamaDecor.field_191364_a[llllllllllllllIIIIllIlIllllIlIII.func_190704_dO().getMetadata()]);
            this.field_191366_c.setModelAttributes(this.field_191365_b.getMainModel());
            this.field_191366_c.render(llllllllllllllIIIIllIlIllllIlIII, llllllllllllllIIIIllIlIllllIIlll, llllllllllllllIIIIllIlIllllIIllI, llllllllllllllIIIIllIlIllllIIlII, llllllllllllllIIIIllIlIllllIIIll, llllllllllllllIIIIllIlIllllIIIlI, llllllllllllllIIIIllIlIlllIllIIl);
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
