package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.*;

public class RenderGiantZombie extends RenderLiving<EntityGiantZombie>
{
    private static final /* synthetic */ ResourceLocation ZOMBIE_TEXTURES;
    private final /* synthetic */ float scale;
    
    static {
        ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
    }
    
    public RenderGiantZombie(final RenderManager lllllllllllllIIIIllIllllIllllIll, final float lllllllllllllIIIIllIllllIllllIlI) {
        super(lllllllllllllIIIIllIllllIllllIll, new ModelZombie(), 0.5f * lllllllllllllIIIIllIllllIllllIlI);
        this.scale = lllllllllllllIIIIllIllllIllllIlI;
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelZombie(0.5f, true);
                this.modelArmor = (T)new ModelZombie(1.0f, true);
            }
        });
    }
    
    @Override
    protected void preRenderCallback(final EntityGiantZombie lllllllllllllIIIIllIllllIlllIIll, final float lllllllllllllIIIIllIllllIlllIIlI) {
        GlStateManager.scale(this.scale, this.scale, this.scale);
    }
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityGiantZombie lllllllllllllIIIIllIllllIllIllll) {
        return RenderGiantZombie.ZOMBIE_TEXTURES;
    }
}
