package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderMooshroom extends RenderLiving<EntityMooshroom>
{
    private static final /* synthetic */ ResourceLocation MOOSHROOM_TEXTURES;
    
    @Override
    public ModelCow getMainModel() {
        return (ModelCow)super.getMainModel();
    }
    
    static {
        MOOSHROOM_TEXTURES = new ResourceLocation("textures/entity/cow/mooshroom.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMooshroom llllllllllllIlllllIlIIlIlIIIIlII) {
        return RenderMooshroom.MOOSHROOM_TEXTURES;
    }
    
    public RenderMooshroom(final RenderManager llllllllllllIlllllIlIIlIlIIIlIIl) {
        super(llllllllllllIlllllIlIIlIlIIIlIIl, new ModelCow(), 0.7f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerMooshroomMushroom(this));
    }
}
