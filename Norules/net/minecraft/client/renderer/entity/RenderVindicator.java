package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderVindicator extends RenderLiving<EntityMob>
{
    private static final /* synthetic */ ResourceLocation field_191357_a;
    
    static {
        field_191357_a = new ResourceLocation("textures/entity/illager/vindicator.png");
    }
    
    public RenderVindicator(final RenderManager lllllllllllllIllIIIIlllIIllIlIll) {
        super(lllllllllllllIllIIIIlllIIllIlIll, new ModelIllager(0.0f, 0.0f, 64, 64), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this) {
            @Override
            protected void func_191361_a(final EnumHandSide lllllllllllllIIlIIlIIIllIlIIIllI) {
                ((ModelIllager)this.livingEntityRenderer.getMainModel()).func_191216_a(lllllllllllllIIlIIlIIIllIlIIIllI).postRender(0.0625f);
            }
            
            @Override
            public void doRenderLayer(final EntityLivingBase lllllllllllllIIlIIlIIIllIlIlIIll, final float lllllllllllllIIlIIlIIIllIlIlIIlI, final float lllllllllllllIIlIIlIIIllIlIlIIIl, final float lllllllllllllIIlIIlIIIllIlIlIIII, final float lllllllllllllIIlIIlIIIllIlIllIII, final float lllllllllllllIIlIIlIIIllIlIlIlll, final float lllllllllllllIIlIIlIIIllIlIIllIl, final float lllllllllllllIIlIIlIIIllIlIIllII) {
                if (((EntityVindicator)lllllllllllllIIlIIlIIIllIlIlIIll).func_190639_o()) {
                    super.doRenderLayer(lllllllllllllIIlIIlIIIllIlIlIIll, lllllllllllllIIlIIlIIIllIlIlIIlI, lllllllllllllIIlIIlIIIllIlIlIIIl, lllllllllllllIIlIIlIIIllIlIlIIII, lllllllllllllIIlIIlIIIllIlIllIII, lllllllllllllIIlIIlIIIllIlIlIlll, lllllllllllllIIlIIlIIIllIlIIllIl, lllllllllllllIIlIIlIIIllIlIIllII);
                }
            }
        });
    }
    
    @Override
    protected void preRenderCallback(final EntityMob lllllllllllllIllIIIIlllIIlIIllll, final float lllllllllllllIllIIIIlllIIlIIlllI) {
        final float lllllllllllllIllIIIIlllIIlIIllIl = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
    
    @Override
    public void doRender(final EntityMob lllllllllllllIllIIIIlllIIlIllIIl, final double lllllllllllllIllIIIIlllIIlIllIII, final double lllllllllllllIllIIIIlllIIlIlIlll, final double lllllllllllllIllIIIIlllIIlIlIllI, final float lllllllllllllIllIIIIlllIIlIlllII, final float lllllllllllllIllIIIIlllIIlIllIll) {
        super.doRender(lllllllllllllIllIIIIlllIIlIllIIl, lllllllllllllIllIIIIlllIIlIllIII, lllllllllllllIllIIIIlllIIlIlIlll, lllllllllllllIllIIIIlllIIlIlIllI, lllllllllllllIllIIIIlllIIlIlllII, lllllllllllllIllIIIIlllIIlIllIll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMob lllllllllllllIllIIIIlllIIlIlIIlI) {
        return RenderVindicator.field_191357_a;
    }
}
