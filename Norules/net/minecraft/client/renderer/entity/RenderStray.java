package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderStray extends RenderSkeleton
{
    private static final /* synthetic */ ResourceLocation STRAY_SKELETON_TEXTURES;
    
    static {
        STRAY_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/stray.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final AbstractSkeleton lllllllllllllIIllllIlIllIIIIlIIl) {
        return RenderStray.STRAY_SKELETON_TEXTURES;
    }
    
    public RenderStray(final RenderManager lllllllllllllIIllllIlIllIIIIlIll) {
        super(lllllllllllllIIllllIlIllIIIIlIll);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerStrayClothing(this));
    }
}
