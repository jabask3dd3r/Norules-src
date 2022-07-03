package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderSlime extends RenderLiving<EntitySlime>
{
    private static final /* synthetic */ ResourceLocation SLIME_TEXTURES;
    
    public RenderSlime(final RenderManager lllllllllllllIIIlIlllIllIIIIIllI) {
        super(lllllllllllllIIIlIlllIllIIIIIllI, new ModelSlime(16), 0.25f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerSlimeGel(this));
    }
    
    static {
        SLIME_TEXTURES = new ResourceLocation("textures/entity/slime/slime.png");
    }
    
    @Override
    protected void preRenderCallback(final EntitySlime lllllllllllllIIIlIlllIlIlllIIlll, final float lllllllllllllIIIlIlllIlIlllIIIII) {
        final float lllllllllllllIIIlIlllIlIlllIIlIl = 0.999f;
        GlStateManager.scale(0.999f, 0.999f, 0.999f);
        final float lllllllllllllIIIlIlllIlIlllIIlII = (float)lllllllllllllIIIlIlllIlIlllIIlll.getSlimeSize();
        final float lllllllllllllIIIlIlllIlIlllIIIll = (lllllllllllllIIIlIlllIlIlllIIlll.prevSquishFactor + (lllllllllllllIIIlIlllIlIlllIIlll.squishFactor - lllllllllllllIIIlIlllIlIlllIIlll.prevSquishFactor) * lllllllllllllIIIlIlllIlIlllIIIII) / (lllllllllllllIIIlIlllIlIlllIIlII * 0.5f + 1.0f);
        final float lllllllllllllIIIlIlllIlIlllIIIlI = 1.0f / (lllllllllllllIIIlIlllIlIlllIIIll + 1.0f);
        GlStateManager.scale(lllllllllllllIIIlIlllIlIlllIIIlI * lllllllllllllIIIlIlllIlIlllIIlII, 1.0f / lllllllllllllIIIlIlllIlIlllIIIlI * lllllllllllllIIIlIlllIlIlllIIlII, lllllllllllllIIIlIlllIlIlllIIIlI * lllllllllllllIIIlIlllIlIlllIIlII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySlime lllllllllllllIIIlIlllIlIllIllIlI) {
        return RenderSlime.SLIME_TEXTURES;
    }
    
    @Override
    public void doRender(final EntitySlime lllllllllllllIIIlIlllIlIlllllIll, final double lllllllllllllIIIlIlllIlIllllIIll, final double lllllllllllllIIIlIlllIlIlllllIIl, final double lllllllllllllIIIlIlllIlIlllllIII, final float lllllllllllllIIIlIlllIlIllllIlll, final float lllllllllllllIIIlIlllIlIlllIllll) {
        this.shadowSize = 0.25f * lllllllllllllIIIlIlllIlIlllllIll.getSlimeSize();
        super.doRender(lllllllllllllIIIlIlllIlIlllllIll, lllllllllllllIIIlIlllIlIllllIIll, lllllllllllllIIIlIlllIlIlllllIIl, lllllllllllllIIIlIlllIlIlllllIII, lllllllllllllIIIlIlllIlIllllIlll, lllllllllllllIIIlIlllIlIlllIllll);
    }
}
