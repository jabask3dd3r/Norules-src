package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderChicken extends RenderLiving<EntityChicken>
{
    private static final /* synthetic */ ResourceLocation CHICKEN_TEXTURES;
    
    @Override
    protected float handleRotationFloat(final EntityChicken lIllIlIIIIlll, final float lIllIlIIIIlIl) {
        final float lIllIlIIIlIIl = lIllIlIIIIlll.oFlap + (lIllIlIIIIlll.wingRotation - lIllIlIIIIlll.oFlap) * lIllIlIIIIlIl;
        final float lIllIlIIIlIII = lIllIlIIIIlll.oFlapSpeed + (lIllIlIIIIlll.destPos - lIllIlIIIIlll.oFlapSpeed) * lIllIlIIIIlIl;
        return (MathHelper.sin(lIllIlIIIlIIl) + 1.0f) * lIllIlIIIlIII;
    }
    
    static {
        CHICKEN_TEXTURES = new ResourceLocation("textures/entity/chicken.png");
    }
    
    public RenderChicken(final RenderManager lIllIlIlIIIII) {
        super(lIllIlIlIIIII, new ModelChicken(), 0.3f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityChicken lIllIlIIllIII) {
        return RenderChicken.CHICKEN_TEXTURES;
    }
}
