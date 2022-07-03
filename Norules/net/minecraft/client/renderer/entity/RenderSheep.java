package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderSheep extends RenderLiving<EntitySheep>
{
    private static final /* synthetic */ ResourceLocation SHEARED_SHEEP_TEXTURES;
    
    static {
        SHEARED_SHEEP_TEXTURES = new ResourceLocation("textures/entity/sheep/sheep.png");
    }
    
    public RenderSheep(final RenderManager lllllllllllllIIIllIIlIlllIlIlIll) {
        super(lllllllllllllIIIllIIlIlllIlIlIll, new ModelSheep2(), 0.7f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerSheepWool(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySheep lllllllllllllIIIllIIlIlllIlIIlll) {
        return RenderSheep.SHEARED_SHEEP_TEXTURES;
    }
}
