package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.client.model.*;

public class RenderBat extends RenderLiving<EntityBat>
{
    private static final /* synthetic */ ResourceLocation BAT_TEXTURES;
    
    static {
        BAT_TEXTURES = new ResourceLocation("textures/entity/bat.png");
    }
    
    @Override
    protected void rotateCorpse(final EntityBat lllllllllllllIlllIIllIllllllIIll, final float lllllllllllllIlllIIllIllllllIIlI, final float lllllllllllllIlllIIllIllllllIllI, final float lllllllllllllIlllIIllIllllllIIII) {
        if (lllllllllllllIlllIIllIllllllIIll.getIsBatHanging()) {
            GlStateManager.translate(0.0f, -0.1f, 0.0f);
        }
        else {
            GlStateManager.translate(0.0f, MathHelper.cos(lllllllllllllIlllIIllIllllllIIlI * 0.3f) * 0.1f, 0.0f);
        }
        super.rotateCorpse(lllllllllllllIlllIIllIllllllIIll, lllllllllllllIlllIIllIllllllIIlI, lllllllllllllIlllIIllIllllllIllI, lllllllllllllIlllIIllIllllllIIII);
    }
    
    public RenderBat(final RenderManager lllllllllllllIlllIIlllIIIIIIIlII) {
        super(lllllllllllllIlllIIlllIIIIIIIlII, new ModelBat(), 0.25f);
    }
    
    @Override
    protected void preRenderCallback(final EntityBat lllllllllllllIlllIIlllIIIIIIIIII, final float lllllllllllllIlllIIllIllllllllll) {
        GlStateManager.scale(0.35f, 0.35f, 0.35f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityBat lllllllllllllIlllIIlllIIIIIIIIlI) {
        return RenderBat.BAT_TEXTURES;
    }
}
