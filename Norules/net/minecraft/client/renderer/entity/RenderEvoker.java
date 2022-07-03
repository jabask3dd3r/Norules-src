package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RenderEvoker extends RenderLiving<EntityMob>
{
    private static final /* synthetic */ ResourceLocation field_191338_a;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMob lllllllllllllIlllIlllIlIIIlIIlII) {
        return RenderEvoker.field_191338_a;
    }
    
    @Override
    protected void preRenderCallback(final EntityMob lllllllllllllIlllIlllIlIIIIlllll, final float lllllllllllllIlllIlllIlIIIIllllI) {
        final float lllllllllllllIlllIlllIlIIIIlllIl = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
    
    public RenderEvoker(final RenderManager lllllllllllllIlllIlllIlIIIlIlIll) {
        super(lllllllllllllIlllIlllIlIIIlIlIll, new ModelIllager(0.0f, 0.0f, 64, 64), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this) {
            @Override
            public void doRenderLayer(final EntityLivingBase llllllllllllllIlIllllIlIIlIIllII, final float llllllllllllllIlIllllIlIIlIIIIlI, final float llllllllllllllIlIllllIlIIlIIIIIl, final float llllllllllllllIlIllllIlIIlIIIIII, final float llllllllllllllIlIllllIlIIIllllll, final float llllllllllllllIlIllllIlIIlIIIlll, final float llllllllllllllIlIllllIlIIIllllIl, final float llllllllllllllIlIllllIlIIlIIIlIl) {
                if (((EntitySpellcasterIllager)llllllllllllllIlIllllIlIIlIIllII).func_193082_dl()) {
                    super.doRenderLayer(llllllllllllllIlIllllIlIIlIIllII, llllllllllllllIlIllllIlIIlIIIIlI, llllllllllllllIlIllllIlIIlIIIIIl, llllllllllllllIlIllllIlIIlIIIIII, llllllllllllllIlIllllIlIIIllllll, llllllllllllllIlIllllIlIIlIIIlll, llllllllllllllIlIllllIlIIIllllIl, llllllllllllllIlIllllIlIIlIIIlIl);
                }
            }
            
            @Override
            protected void func_191361_a(final EnumHandSide llllllllllllllIlIllllIlIIIlllIII) {
                ((ModelIllager)this.livingEntityRenderer.getMainModel()).func_191216_a(llllllllllllllIlIllllIlIIIlllIII).postRender(0.0625f);
            }
        });
    }
    
    static {
        field_191338_a = new ResourceLocation("textures/entity/illager/evoker.png");
    }
}
