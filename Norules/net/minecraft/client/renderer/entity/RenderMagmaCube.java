package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderMagmaCube extends RenderLiving<EntityMagmaCube>
{
    private static final /* synthetic */ ResourceLocation MAGMA_CUBE_TEXTURES;
    
    public RenderMagmaCube(final RenderManager llllllllllllllIlIlIllllllIllIlll) {
        super(llllllllllllllIlIlIllllllIllIlll, new ModelMagmaCube(), 0.25f);
    }
    
    @Override
    protected void preRenderCallback(final EntityMagmaCube llllllllllllllIlIlIllllllIlIIlIl, final float llllllllllllllIlIlIllllllIlIlIIl) {
        final int llllllllllllllIlIlIllllllIlIlIII = llllllllllllllIlIlIllllllIlIIlIl.getSlimeSize();
        final float llllllllllllllIlIlIllllllIlIIlll = (llllllllllllllIlIlIllllllIlIIlIl.prevSquishFactor + (llllllllllllllIlIlIllllllIlIIlIl.squishFactor - llllllllllllllIlIlIllllllIlIIlIl.prevSquishFactor) * llllllllllllllIlIlIllllllIlIlIIl) / (llllllllllllllIlIlIllllllIlIlIII * 0.5f + 1.0f);
        final float llllllllllllllIlIlIllllllIlIIllI = 1.0f / (llllllllllllllIlIlIllllllIlIIlll + 1.0f);
        GlStateManager.scale(llllllllllllllIlIlIllllllIlIIllI * llllllllllllllIlIlIllllllIlIlIII, 1.0f / llllllllllllllIlIlIllllllIlIIllI * llllllllllllllIlIlIllllllIlIlIII, llllllllllllllIlIlIllllllIlIIllI * llllllllllllllIlIlIllllllIlIlIII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMagmaCube llllllllllllllIlIlIllllllIllIIIl) {
        return RenderMagmaCube.MAGMA_CUBE_TEXTURES;
    }
    
    static {
        MAGMA_CUBE_TEXTURES = new ResourceLocation("textures/entity/slime/magmacube.png");
    }
}
