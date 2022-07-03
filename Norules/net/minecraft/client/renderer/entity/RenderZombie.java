package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderZombie extends RenderBiped<EntityZombie>
{
    private static final /* synthetic */ ResourceLocation ZOMBIE_TEXTURES;
    
    public RenderZombie(final RenderManager lllllllllllllIIIllIIlllllIllIIIl) {
        super(lllllllllllllIIIllIIlllllIllIIIl, new ModelZombie(), 0.5f);
        final LayerBipedArmor lllllllllllllIIIllIIlllllIllIIll = new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelZombie(0.5f, true);
                this.modelArmor = (T)new ModelZombie(1.0f, true);
            }
        };
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(lllllllllllllIIIllIIlllllIllIIll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityZombie lllllllllllllIIIllIIlllllIlIllII) {
        return RenderZombie.ZOMBIE_TEXTURES;
    }
    
    static {
        ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
    }
}
