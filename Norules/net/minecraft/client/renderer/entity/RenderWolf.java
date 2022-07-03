package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderWolf extends RenderLiving<EntityWolf>
{
    private static final /* synthetic */ ResourceLocation ANRGY_WOLF_TEXTURES;
    private static final /* synthetic */ ResourceLocation WOLF_TEXTURES;
    private static final /* synthetic */ ResourceLocation TAMED_WOLF_TEXTURES;
    
    @Override
    protected float handleRotationFloat(final EntityWolf lllllllllllllllIlIIlIlIllIlIIIII, final float lllllllllllllllIlIIlIlIllIIlllll) {
        return lllllllllllllllIlIIlIlIllIlIIIII.getTailRotation();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityWolf lllllllllllllllIlIIlIlIlIllIllIl) {
        if (lllllllllllllllIlIIlIlIlIllIllIl.isTamed()) {
            return RenderWolf.TAMED_WOLF_TEXTURES;
        }
        return lllllllllllllllIlIIlIlIlIllIllIl.isAngry() ? RenderWolf.ANRGY_WOLF_TEXTURES : RenderWolf.WOLF_TEXTURES;
    }
    
    public RenderWolf(final RenderManager lllllllllllllllIlIIlIlIllIlIIIll) {
        super(lllllllllllllllIlIIlIlIllIlIIIll, new ModelWolf(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerWolfCollar(this));
    }
    
    static {
        WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf.png");
        TAMED_WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
        ANRGY_WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
    }
    
    @Override
    public void doRender(final EntityWolf lllllllllllllllIlIIlIlIllIIIllll, final double lllllllllllllllIlIIlIlIlIllllllI, final double lllllllllllllllIlIIlIlIlIlllllII, final double lllllllllllllllIlIIlIlIllIIIlIlI, final float lllllllllllllllIlIIlIlIllIIIlIII, final float lllllllllllllllIlIIlIlIlIlllIllI) {
        if (lllllllllllllllIlIIlIlIllIIIllll.isWolfWet()) {
            final float lllllllllllllllIlIIlIlIllIIIIlII = lllllllllllllllIlIIlIlIllIIIllll.getBrightness() * lllllllllllllllIlIIlIlIllIIIllll.getShadingWhileWet(lllllllllllllllIlIIlIlIlIlllIllI);
            GlStateManager.color(lllllllllllllllIlIIlIlIllIIIIlII, lllllllllllllllIlIIlIlIllIIIIlII, lllllllllllllllIlIIlIlIllIIIIlII);
        }
        super.doRender(lllllllllllllllIlIIlIlIllIIIllll, lllllllllllllllIlIIlIlIlIllllllI, lllllllllllllllIlIIlIlIlIlllllII, lllllllllllllllIlIIlIlIllIIIlIlI, lllllllllllllllIlIIlIlIllIIIlIII, lllllllllllllllIlIIlIlIlIlllIllI);
    }
}
