package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderPig extends RenderLiving<EntityPig>
{
    private static final /* synthetic */ ResourceLocation PIG_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityPig llllllllllllllIIlIllIlIlIIIIIlII) {
        return RenderPig.PIG_TEXTURES;
    }
    
    static {
        PIG_TEXTURES = new ResourceLocation("textures/entity/pig/pig.png");
    }
    
    public RenderPig(final RenderManager llllllllllllllIIlIllIlIlIIIIIllI) {
        super(llllllllllllllIIlIllIlIlIIIIIllI, new ModelPig(), 0.7f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerSaddle(this));
    }
}
