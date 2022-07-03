package net.minecraft.client.renderer.entity;

import net.minecraft.entity.boss.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderWither extends RenderLiving<EntityWither>
{
    private static final /* synthetic */ ResourceLocation WITHER_TEXTURES;
    private static final /* synthetic */ ResourceLocation INVULNERABLE_WITHER_TEXTURES;
    
    public RenderWither(final RenderManager lllllllllllllIIlIllIIlIllIIIIIII) {
        super(lllllllllllllIIlIllIIlIllIIIIIII, new ModelWither(0.0f), 1.0f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerWitherAura(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityWither lllllllllllllIIlIllIIlIlIllllIlI) {
        final int lllllllllllllIIlIllIIlIlIllllIll = lllllllllllllIIlIllIIlIlIllllIlI.getInvulTime();
        return (lllllllllllllIIlIllIIlIlIllllIll > 0 && (lllllllllllllIIlIllIIlIlIllllIll > 80 || lllllllllllllIIlIllIIlIlIllllIll / 5 % 2 != 1)) ? RenderWither.INVULNERABLE_WITHER_TEXTURES : RenderWither.WITHER_TEXTURES;
    }
    
    static {
        INVULNERABLE_WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
        WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither.png");
    }
    
    @Override
    protected void preRenderCallback(final EntityWither lllllllllllllIIlIllIIlIlIlllIIll, final float lllllllllllllIIlIllIIlIlIllIlllI) {
        float lllllllllllllIIlIllIIlIlIlllIIIl = 2.0f;
        final int lllllllllllllIIlIllIIlIlIlllIIII = lllllllllllllIIlIllIIlIlIlllIIll.getInvulTime();
        if (lllllllllllllIIlIllIIlIlIlllIIII > 0) {
            lllllllllllllIIlIllIIlIlIlllIIIl -= (lllllllllllllIIlIllIIlIlIlllIIII - lllllllllllllIIlIllIIlIlIllIlllI) / 220.0f * 0.5f;
        }
        GlStateManager.scale(lllllllllllllIIlIllIIlIlIlllIIIl, lllllllllllllIIlIllIIlIlIlllIIIl, lllllllllllllIIlIllIIlIlIlllIIIl);
    }
}
