package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderSquid extends RenderLiving<EntitySquid>
{
    private static final /* synthetic */ ResourceLocation SQUID_TEXTURES;
    
    static {
        SQUID_TEXTURES = new ResourceLocation("textures/entity/squid.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySquid lllllllllllllIllIllllIlIIllIllII) {
        return RenderSquid.SQUID_TEXTURES;
    }
    
    @Override
    protected void rotateCorpse(final EntitySquid lllllllllllllIllIllllIlIIlIlllll, final float lllllllllllllIllIllllIlIIllIIlII, final float lllllllllllllIllIllllIlIIlIllllI, final float lllllllllllllIllIllllIlIIllIIIlI) {
        final float lllllllllllllIllIllllIlIIllIIIIl = lllllllllllllIllIllllIlIIlIlllll.prevSquidPitch + (lllllllllllllIllIllllIlIIlIlllll.squidPitch - lllllllllllllIllIllllIlIIlIlllll.prevSquidPitch) * lllllllllllllIllIllllIlIIllIIIlI;
        final float lllllllllllllIllIllllIlIIllIIIII = lllllllllllllIllIllllIlIIlIlllll.prevSquidYaw + (lllllllllllllIllIllllIlIIlIlllll.squidYaw - lllllllllllllIllIllllIlIIlIlllll.prevSquidYaw) * lllllllllllllIllIllllIlIIllIIIlI;
        GlStateManager.translate(0.0f, 0.5f, 0.0f);
        GlStateManager.rotate(180.0f - lllllllllllllIllIllllIlIIlIllllI, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIllIllllIlIIllIIIIl, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIllIllllIlIIllIIIII, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, -1.2f, 0.0f);
    }
    
    public RenderSquid(final RenderManager lllllllllllllIllIllllIlIIlllIIII) {
        super(lllllllllllllIllIllllIlIIlllIIII, new ModelSquid(), 0.7f);
    }
    
    @Override
    protected float handleRotationFloat(final EntitySquid lllllllllllllIllIllllIlIIlIlIlll, final float lllllllllllllIllIllllIlIIlIlIlII) {
        return lllllllllllllIllIllllIlIIlIlIlll.lastTentacleAngle + (lllllllllllllIllIllllIlIIlIlIlll.tentacleAngle - lllllllllllllIllIllllIlIIlIlIlll.lastTentacleAngle) * lllllllllllllIllIllllIlIIlIlIlII;
    }
}
