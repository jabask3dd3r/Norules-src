package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderLlama extends RenderLiving<EntityLlama>
{
    private static final /* synthetic */ ResourceLocation[] field_191350_a;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityLlama llllllllllllllllIlIlIIllIIIIIIlI) {
        return RenderLlama.field_191350_a[llllllllllllllllIlIlIIllIIIIIIlI.func_190719_dM()];
    }
    
    static {
        field_191350_a = new ResourceLocation[] { new ResourceLocation("textures/entity/llama/llama_creamy.png"), new ResourceLocation("textures/entity/llama/llama_white.png"), new ResourceLocation("textures/entity/llama/llama_brown.png"), new ResourceLocation("textures/entity/llama/llama_gray.png") };
    }
    
    public RenderLlama(final RenderManager llllllllllllllllIlIlIIllIIIIIlll) {
        super(llllllllllllllllIlIlIIllIIIIIlll, new ModelLlama(0.0f), 0.7f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerLlamaDecor(this));
    }
}
