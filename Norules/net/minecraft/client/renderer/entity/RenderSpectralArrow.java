package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RenderSpectralArrow extends RenderArrow<EntitySpectralArrow>
{
    public static final /* synthetic */ ResourceLocation RES_SPECTRAL_ARROW;
    
    public RenderSpectralArrow(final RenderManager lllllllllllllIlIllIIlIlIlIIIIllI) {
        super(lllllllllllllIlIllIIlIlIlIIIIllI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySpectralArrow lllllllllllllIlIllIIlIlIlIIIIIlI) {
        return RenderSpectralArrow.RES_SPECTRAL_ARROW;
    }
    
    static {
        RES_SPECTRAL_ARROW = new ResourceLocation("textures/entity/projectiles/spectral_arrow.png");
    }
}
