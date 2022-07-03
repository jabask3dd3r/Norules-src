package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderPigZombie extends RenderBiped<EntityPigZombie>
{
    private static final /* synthetic */ ResourceLocation ZOMBIE_PIGMAN_TEXTURE;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityPigZombie lllllllllllllIIlIllllllllllIllIl) {
        return RenderPigZombie.ZOMBIE_PIGMAN_TEXTURE;
    }
    
    static {
        ZOMBIE_PIGMAN_TEXTURE = new ResourceLocation("textures/entity/zombie_pigman.png");
    }
    
    public RenderPigZombie(final RenderManager lllllllllllllIIlIlllllllllllIIIl) {
        super(lllllllllllllIIlIlllllllllllIIIl, new ModelZombie(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelZombie(0.5f, true);
                this.modelArmor = (T)new ModelZombie(1.0f, true);
            }
        });
    }
}
