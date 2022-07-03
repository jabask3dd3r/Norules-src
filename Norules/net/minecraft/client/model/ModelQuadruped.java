package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;

public class ModelQuadruped extends ModelBase
{
    public /* synthetic */ ModelRenderer leg1;
    public /* synthetic */ ModelRenderer leg4;
    public /* synthetic */ ModelRenderer leg2;
    protected /* synthetic */ float childZOffset;
    public /* synthetic */ ModelRenderer body;
    protected /* synthetic */ float childYOffset;
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer leg3;
    
    @Override
    public void render(final Entity llllllllllllllIIlIIlIlIlIlIlIlIl, final float llllllllllllllIIlIIlIlIlIlIlIlII, final float llllllllllllllIIlIIlIlIlIlIIlIlI, final float llllllllllllllIIlIIlIlIlIlIIlIIl, final float llllllllllllllIIlIIlIlIlIlIIlIII, final float llllllllllllllIIlIIlIlIlIlIlIIII, final float llllllllllllllIIlIIlIlIlIlIIllll) {
        this.setRotationAngles(llllllllllllllIIlIIlIlIlIlIlIlII, llllllllllllllIIlIIlIlIlIlIIlIlI, llllllllllllllIIlIIlIlIlIlIIlIIl, llllllllllllllIIlIIlIlIlIlIIlIII, llllllllllllllIIlIIlIlIlIlIlIIII, llllllllllllllIIlIIlIlIlIlIIllll, llllllllllllllIIlIIlIlIlIlIlIlIl);
        if (this.isChild) {
            final float llllllllllllllIIlIIlIlIlIlIIlllI = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, this.childYOffset * llllllllllllllIIlIIlIlIlIlIIllll, this.childZOffset * llllllllllllllIIlIIlIlIlIlIIllll);
            this.head.render(llllllllllllllIIlIIlIlIlIlIIllll);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllIIlIIlIlIlIlIIllll, 0.0f);
            this.body.render(llllllllllllllIIlIIlIlIlIlIIllll);
            this.leg1.render(llllllllllllllIIlIIlIlIlIlIIllll);
            this.leg2.render(llllllllllllllIIlIIlIlIlIlIIllll);
            this.leg3.render(llllllllllllllIIlIIlIlIlIlIIllll);
            this.leg4.render(llllllllllllllIIlIIlIlIlIlIIllll);
            GlStateManager.popMatrix();
        }
        else {
            this.head.render(llllllllllllllIIlIIlIlIlIlIIllll);
            this.body.render(llllllllllllllIIlIIlIlIlIlIIllll);
            this.leg1.render(llllllllllllllIIlIIlIlIlIlIIllll);
            this.leg2.render(llllllllllllllIIlIIlIlIlIlIIllll);
            this.leg3.render(llllllllllllllIIlIIlIlIlIlIIllll);
            this.leg4.render(llllllllllllllIIlIIlIlIlIlIIllll);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIlIIlIlIlIIllIllI, final float llllllllllllllIIlIIlIlIlIIllllIl, final float llllllllllllllIIlIIlIlIlIIllllII, final float llllllllllllllIIlIIlIlIlIIllIlII, final float llllllllllllllIIlIIlIlIlIIlllIlI, final float llllllllllllllIIlIIlIlIlIIlllIIl, final Entity llllllllllllllIIlIIlIlIlIIlllIII) {
        this.head.rotateAngleX = llllllllllllllIIlIIlIlIlIIlllIlI * 0.017453292f;
        this.head.rotateAngleY = llllllllllllllIIlIIlIlIlIIllIlII * 0.017453292f;
        this.body.rotateAngleX = 1.5707964f;
        this.leg1.rotateAngleX = MathHelper.cos(llllllllllllllIIlIIlIlIlIIllIllI * 0.6662f) * 1.4f * llllllllllllllIIlIIlIlIlIIllllIl;
        this.leg2.rotateAngleX = MathHelper.cos(llllllllllllllIIlIIlIlIlIIllIllI * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIIlIIlIlIlIIllllIl;
        this.leg3.rotateAngleX = MathHelper.cos(llllllllllllllIIlIIlIlIlIIllIllI * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIIlIIlIlIlIIllllIl;
        this.leg4.rotateAngleX = MathHelper.cos(llllllllllllllIIlIIlIlIlIIllIllI * 0.6662f) * 1.4f * llllllllllllllIIlIIlIlIlIIllllIl;
    }
    
    public ModelQuadruped(final int llllllllllllllIIlIIlIlIlIllIIlII, final float llllllllllllllIIlIIlIlIlIllIIIII) {
        this.head = new ModelRenderer(this, 0, 0);
        this.childYOffset = 8.0f;
        this.childZOffset = 4.0f;
        this.head.addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8, llllllllllllllIIlIIlIlIlIllIIIII);
        this.head.setRotationPoint(0.0f, (float)(18 - llllllllllllllIIlIIlIlIlIllIIlII), -6.0f);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-5.0f, -10.0f, -7.0f, 10, 16, 8, llllllllllllllIIlIIlIlIlIllIIIII);
        this.body.setRotationPoint(0.0f, (float)(17 - llllllllllllllIIlIIlIlIlIllIIlII), 2.0f);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, llllllllllllllIIlIIlIlIlIllIIlII, 4, llllllllllllllIIlIIlIlIlIllIIIII);
        this.leg1.setRotationPoint(-3.0f, (float)(24 - llllllllllllllIIlIIlIlIlIllIIlII), 7.0f);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, llllllllllllllIIlIIlIlIlIllIIlII, 4, llllllllllllllIIlIIlIlIlIllIIIII);
        this.leg2.setRotationPoint(3.0f, (float)(24 - llllllllllllllIIlIIlIlIlIllIIlII), 7.0f);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, llllllllllllllIIlIIlIlIlIllIIlII, 4, llllllllllllllIIlIIlIlIlIllIIIII);
        this.leg3.setRotationPoint(-3.0f, (float)(24 - llllllllllllllIIlIIlIlIlIllIIlII), -5.0f);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, llllllllllllllIIlIIlIlIlIllIIlII, 4, llllllllllllllIIlIIlIlIlIllIIIII);
        this.leg4.setRotationPoint(3.0f, (float)(24 - llllllllllllllIIlIIlIlIlIllIIlII), -5.0f);
    }
}
