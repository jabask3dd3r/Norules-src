package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderElderGuardian extends RenderGuardian
{
    private static final /* synthetic */ ResourceLocation GUARDIAN_ELDER_TEXTURE;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityGuardian lllllllllllllIIIIIlIIIIIllIlIllI) {
        return RenderElderGuardian.GUARDIAN_ELDER_TEXTURE;
    }
    
    @Override
    protected void preRenderCallback(final EntityGuardian lllllllllllllIIIIIlIIIIIllIllIIl, final float lllllllllllllIIIIIlIIIIIllIllIII) {
        GlStateManager.scale(2.35f, 2.35f, 2.35f);
    }
    
    public RenderElderGuardian(final RenderManager lllllllllllllIIIIIlIIIIIllIlllIl) {
        super(lllllllllllllIIIIIlIIIIIllIlllIl);
    }
    
    static {
        GUARDIAN_ELDER_TEXTURE = new ResourceLocation("textures/entity/guardian_elder.png");
    }
}
