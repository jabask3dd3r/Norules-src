package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;

public class RenderHusk extends RenderZombie
{
    private static final /* synthetic */ ResourceLocation HUSK_ZOMBIE_TEXTURES;
    
    @Override
    protected void preRenderCallback(final EntityZombie lllllllllllllIlIIIIlIlllIlIlIIIl, final float lllllllllllllIlIIIIlIlllIlIlIIII) {
        final float lllllllllllllIlIIIIlIlllIlIIllll = 1.0625f;
        GlStateManager.scale(1.0625f, 1.0625f, 1.0625f);
        super.preRenderCallback(lllllllllllllIlIIIIlIlllIlIlIIIl, lllllllllllllIlIIIIlIlllIlIlIIII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityZombie lllllllllllllIlIIIIlIlllIlIIlIIl) {
        return RenderHusk.HUSK_ZOMBIE_TEXTURES;
    }
    
    public RenderHusk(final RenderManager lllllllllllllIlIIIIlIlllIlIllIIl) {
        super(lllllllllllllIlIIIIlIlllIlIllIIl);
    }
    
    static {
        HUSK_ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/husk.png");
    }
}
