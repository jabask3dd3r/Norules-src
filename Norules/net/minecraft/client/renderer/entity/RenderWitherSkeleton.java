package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderWitherSkeleton extends RenderSkeleton
{
    private static final /* synthetic */ ResourceLocation WITHER_SKELETON_TEXTURES;
    
    @Override
    protected void preRenderCallback(final AbstractSkeleton lllllllllllllllIIlllIlIlllllIlll, final float lllllllllllllllIIlllIlIlllllIllI) {
        GlStateManager.scale(1.2f, 1.2f, 1.2f);
    }
    
    static {
        WITHER_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
    }
    
    public RenderWitherSkeleton(final RenderManager lllllllllllllllIIlllIlIlllllllIl) {
        super(lllllllllllllllIIlllIlIlllllllIl);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final AbstractSkeleton lllllllllllllllIIlllIlIllllllIIl) {
        return RenderWitherSkeleton.WITHER_SKELETON_TEXTURES;
    }
}
