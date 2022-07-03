package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderSnowMan extends RenderLiving<EntitySnowman>
{
    private static final /* synthetic */ ResourceLocation SNOW_MAN_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySnowman llllllllllllllIIIIIIlIlIIIlllllI) {
        return RenderSnowMan.SNOW_MAN_TEXTURES;
    }
    
    @Override
    public ModelSnowMan getMainModel() {
        return (ModelSnowMan)super.getMainModel();
    }
    
    static {
        SNOW_MAN_TEXTURES = new ResourceLocation("textures/entity/snowman.png");
    }
    
    public RenderSnowMan(final RenderManager llllllllllllllIIIIIIlIlIIlIIIIII) {
        super(llllllllllllllIIIIIIlIlIIlIIIIII, new ModelSnowMan(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerSnowmanHead(this));
    }
}
