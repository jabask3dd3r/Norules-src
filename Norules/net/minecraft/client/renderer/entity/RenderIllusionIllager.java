package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class RenderIllusionIllager extends RenderLiving<EntityMob>
{
    private static final /* synthetic */ ResourceLocation field_193121_a;
    
    @Override
    public void renderName(final EntityMob lllllllllllllIlIllIllIlllIIllllI, final double lllllllllllllIlIllIllIlllIIlllIl, final double lllllllllllllIlIllIllIlllIIlllII, final double lllllllllllllIlIllIllIlllIIllIll) {
        super.renderName(lllllllllllllIlIllIllIlllIIllllI, lllllllllllllIlIllIllIlllIIlllIl, lllllllllllllIlIllIllIlllIIlllII, lllllllllllllIlIllIllIlllIIllIll);
    }
    
    public RenderIllusionIllager(final RenderManager lllllllllllllIlIllIllIllllIIlIll) {
        super(lllllllllllllIlIllIllIllllIIlIll, new ModelIllager(0.0f, 0.0f, 64, 64), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this) {
            @Override
            public void doRenderLayer(final EntityLivingBase llllllllllllllllllIIIIllllIlIIlI, final float llllllllllllllllllIIIIllllIllIlI, final float llllllllllllllllllIIIIllllIllIIl, final float llllllllllllllllllIIIIllllIIllll, final float llllllllllllllllllIIIIllllIIlllI, final float llllllllllllllllllIIIIllllIIllIl, final float llllllllllllllllllIIIIllllIIllII, final float llllllllllllllllllIIIIllllIlIlII) {
                if (((EntityIllusionIllager)llllllllllllllllllIIIIllllIlIIlI).func_193082_dl() || ((EntityIllusionIllager)llllllllllllllllllIIIIllllIlIIlI).func_193096_dj()) {
                    super.doRenderLayer(llllllllllllllllllIIIIllllIlIIlI, llllllllllllllllllIIIIllllIllIlI, llllllllllllllllllIIIIllllIllIIl, llllllllllllllllllIIIIllllIIllll, llllllllllllllllllIIIIllllIIlllI, llllllllllllllllllIIIIllllIIllIl, llllllllllllllllllIIIIllllIIllII, llllllllllllllllllIIIIllllIlIlII);
                }
            }
            
            @Override
            protected void func_191361_a(final EnumHandSide llllllllllllllllllIIIIllllIIIlll) {
                ((ModelIllager)this.livingEntityRenderer.getMainModel()).func_191216_a(llllllllllllllllllIIIIllllIIIlll).postRender(0.0625f);
            }
        });
        ((ModelIllager)this.getMainModel()).field_193775_b.showModel = true;
    }
    
    @Override
    protected boolean func_193115_c(final EntityMob lllllllllllllIlIllIllIlllIIlIlII) {
        return true;
    }
    
    static {
        field_193121_a = new ResourceLocation("textures/entity/illager/illusionist.png");
    }
    
    @Override
    public void doRender(final EntityMob lllllllllllllIlIllIllIlllIllIlll, final double lllllllllllllIlIllIllIlllIlIllII, final double lllllllllllllIlIllIllIlllIlIlIll, final double lllllllllllllIlIllIllIlllIlIlIlI, final float lllllllllllllIlIllIllIlllIllIIll, final float lllllllllllllIlIllIllIlllIllIIlI) {
        if (lllllllllllllIlIllIllIlllIllIlll.isInvisible()) {
            final Vec3d[] lllllllllllllIlIllIllIlllIllIIIl = ((EntityIllusionIllager)lllllllllllllIlIllIllIlllIllIlll).func_193098_a(lllllllllllllIlIllIllIlllIllIIlI);
            final float lllllllllllllIlIllIllIlllIllIIII = this.handleRotationFloat(lllllllllllllIlIllIllIlllIllIlll, lllllllllllllIlIllIllIlllIllIIlI);
            for (int lllllllllllllIlIllIllIlllIlIllll = 0; lllllllllllllIlIllIllIlllIlIllll < lllllllllllllIlIllIllIlllIllIIIl.length; ++lllllllllllllIlIllIllIlllIlIllll) {
                super.doRender(lllllllllllllIlIllIllIlllIllIlll, lllllllllllllIlIllIllIlllIlIllII + lllllllllllllIlIllIllIlllIllIIIl[lllllllllllllIlIllIllIlllIlIllll].xCoord + MathHelper.cos(lllllllllllllIlIllIllIlllIlIllll + lllllllllllllIlIllIllIlllIllIIII * 0.5f) * 0.025, lllllllllllllIlIllIllIlllIlIlIll + lllllllllllllIlIllIllIlllIllIIIl[lllllllllllllIlIllIllIlllIlIllll].yCoord + MathHelper.cos(lllllllllllllIlIllIllIlllIlIllll + lllllllllllllIlIllIllIlllIllIIII * 0.75f) * 0.0125, lllllllllllllIlIllIllIlllIlIlIlI + lllllllllllllIlIllIllIlllIllIIIl[lllllllllllllIlIllIllIlllIlIllll].zCoord + MathHelper.cos(lllllllllllllIlIllIllIlllIlIllll + lllllllllllllIlIllIllIlllIllIIII * 0.7f) * 0.025, lllllllllllllIlIllIllIlllIllIIll, lllllllllllllIlIllIllIlllIllIIlI);
            }
        }
        else {
            super.doRender(lllllllllllllIlIllIllIlllIllIlll, lllllllllllllIlIllIllIlllIlIllII, lllllllllllllIlIllIllIlllIlIlIll, lllllllllllllIlIllIllIlllIlIlIlI, lllllllllllllIlIllIllIlllIllIIll, lllllllllllllIlIllIllIlllIllIIlI);
        }
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMob lllllllllllllIlIllIllIllllIIlIIl) {
        return RenderIllusionIllager.field_193121_a;
    }
    
    @Override
    protected void preRenderCallback(final EntityMob lllllllllllllIlIllIllIllllIIIllI, final float lllllllllllllIlIllIllIllllIIIlIl) {
        final float lllllllllllllIlIllIllIllllIIIlII = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
}
