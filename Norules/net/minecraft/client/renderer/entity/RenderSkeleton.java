package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderSkeleton extends RenderBiped<AbstractSkeleton>
{
    private static final /* synthetic */ ResourceLocation SKELETON_TEXTURES;
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.09375f, 0.1875f, 0.0f);
    }
    
    public RenderSkeleton(final RenderManager lllllllllllllIIIlllllllIIIlIllll) {
        super(lllllllllllllIIIlllllllIIIlIllll, new ModelSkeleton(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelSkeleton(0.5f, true);
                this.modelArmor = (T)new ModelSkeleton(1.0f, true);
            }
        });
    }
    
    static {
        SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final AbstractSkeleton lllllllllllllIIIlllllllIIIlIlIlI) {
        return RenderSkeleton.SKELETON_TEXTURES;
    }
}
