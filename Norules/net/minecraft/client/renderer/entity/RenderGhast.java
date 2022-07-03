package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;

public class RenderGhast extends RenderLiving<EntityGhast>
{
    private static final /* synthetic */ ResourceLocation GHAST_TEXTURES;
    private static final /* synthetic */ ResourceLocation GHAST_SHOOTING_TEXTURES;
    
    static {
        GHAST_TEXTURES = new ResourceLocation("textures/entity/ghast/ghast.png");
        GHAST_SHOOTING_TEXTURES = new ResourceLocation("textures/entity/ghast/ghast_shooting.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityGhast llllllllllllIlllllIIllIIIllIIlIl) {
        return llllllllllllIlllllIIllIIIllIIlIl.isAttacking() ? RenderGhast.GHAST_SHOOTING_TEXTURES : RenderGhast.GHAST_TEXTURES;
    }
    
    public RenderGhast(final RenderManager llllllllllllIlllllIIllIIIllIlIlI) {
        super(llllllllllllIlllllIIllIIIllIlIlI, new ModelGhast(), 0.5f);
    }
    
    @Override
    protected void preRenderCallback(final EntityGhast llllllllllllIlllllIIllIIIlIlllll, final float llllllllllllIlllllIIllIIIlIllllI) {
        final float llllllllllllIlllllIIllIIIlIlllIl = 1.0f;
        final float llllllllllllIlllllIIllIIIlIlllII = 4.5f;
        final float llllllllllllIlllllIIllIIIlIllIll = 4.5f;
        GlStateManager.scale(4.5f, 4.5f, 4.5f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
