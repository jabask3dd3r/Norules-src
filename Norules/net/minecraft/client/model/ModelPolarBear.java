package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;

public class ModelPolarBear extends ModelQuadruped
{
    @Override
    public void setRotationAngles(final float llllllllllllllllIIIllIlllllllIll, final float llllllllllllllllIIIllIlllllllIlI, final float llllllllllllllllIIIlllIIIIIIIlII, final float llllllllllllllllIIIllIlllllllIII, final float llllllllllllllllIIIlllIIIIIIIIlI, final float llllllllllllllllIIIlllIIIIIIIIIl, final Entity llllllllllllllllIIIlllIIIIIIIIII) {
        super.setRotationAngles(llllllllllllllllIIIllIlllllllIll, llllllllllllllllIIIllIlllllllIlI, llllllllllllllllIIIlllIIIIIIIlII, llllllllllllllllIIIllIlllllllIII, llllllllllllllllIIIlllIIIIIIIIlI, llllllllllllllllIIIlllIIIIIIIIIl, llllllllllllllllIIIlllIIIIIIIIII);
        final float llllllllllllllllIIIllIllllllllll = llllllllllllllllIIIlllIIIIIIIlII - llllllllllllllllIIIlllIIIIIIIIII.ticksExisted;
        float llllllllllllllllIIIllIlllllllllI = ((EntityPolarBear)llllllllllllllllIIIlllIIIIIIIIII).getStandingAnimationScale(llllllllllllllllIIIllIllllllllll);
        llllllllllllllllIIIllIlllllllllI *= llllllllllllllllIIIllIlllllllllI;
        final float llllllllllllllllIIIllIllllllllIl = 1.0f - llllllllllllllllIIIllIlllllllllI;
        this.body.rotateAngleX = 1.5707964f - llllllllllllllllIIIllIlllllllllI * 3.1415927f * 0.35f;
        this.body.rotationPointY = 9.0f * llllllllllllllllIIIllIllllllllIl + 11.0f * llllllllllllllllIIIllIlllllllllI;
        this.leg3.rotationPointY = 14.0f * llllllllllllllllIIIllIllllllllIl + -6.0f * llllllllllllllllIIIllIlllllllllI;
        this.leg3.rotationPointZ = -8.0f * llllllllllllllllIIIllIllllllllIl + -4.0f * llllllllllllllllIIIllIlllllllllI;
        final ModelRenderer leg3 = this.leg3;
        leg3.rotateAngleX -= llllllllllllllllIIIllIlllllllllI * 3.1415927f * 0.45f;
        this.leg4.rotationPointY = this.leg3.rotationPointY;
        this.leg4.rotationPointZ = this.leg3.rotationPointZ;
        final ModelRenderer leg4 = this.leg4;
        leg4.rotateAngleX -= llllllllllllllllIIIllIlllllllllI * 3.1415927f * 0.45f;
        this.head.rotationPointY = 10.0f * llllllllllllllllIIIllIllllllllIl + -12.0f * llllllllllllllllIIIllIlllllllllI;
        this.head.rotationPointZ = -16.0f * llllllllllllllllIIIllIllllllllIl + -3.0f * llllllllllllllllIIIllIlllllllllI;
        final ModelRenderer head = this.head;
        head.rotateAngleX += llllllllllllllllIIIllIlllllllllI * 3.1415927f * 0.15f;
    }
    
    @Override
    public void render(final Entity llllllllllllllllIIIlllIIIIlIIIll, final float llllllllllllllllIIIlllIIIIIllIIl, final float llllllllllllllllIIIlllIIIIlIIIIl, final float llllllllllllllllIIIlllIIIIIlIlll, final float llllllllllllllllIIIlllIIIIIlIllI, final float llllllllllllllllIIIlllIIIIIlIlIl, final float llllllllllllllllIIIlllIIIIIlllIl) {
        this.setRotationAngles(llllllllllllllllIIIlllIIIIIllIIl, llllllllllllllllIIIlllIIIIlIIIIl, llllllllllllllllIIIlllIIIIIlIlll, llllllllllllllllIIIlllIIIIIlIllI, llllllllllllllllIIIlllIIIIIlIlIl, llllllllllllllllIIIlllIIIIIlllIl, llllllllllllllllIIIlllIIIIlIIIll);
        if (this.isChild) {
            final float llllllllllllllllIIIlllIIIIIlllII = 2.0f;
            this.childYOffset = 16.0f;
            this.childZOffset = 4.0f;
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.6666667f, 0.6666667f, 0.6666667f);
            GlStateManager.translate(0.0f, this.childYOffset * llllllllllllllllIIIlllIIIIIlllIl, this.childZOffset * llllllllllllllllIIIlllIIIIIlllIl);
            this.head.render(llllllllllllllllIIIlllIIIIIlllIl);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllllIIIlllIIIIIlllIl, 0.0f);
            this.body.render(llllllllllllllllIIIlllIIIIIlllIl);
            this.leg1.render(llllllllllllllllIIIlllIIIIIlllIl);
            this.leg2.render(llllllllllllllllIIIlllIIIIIlllIl);
            this.leg3.render(llllllllllllllllIIIlllIIIIIlllIl);
            this.leg4.render(llllllllllllllllIIIlllIIIIIlllIl);
            GlStateManager.popMatrix();
        }
        else {
            this.head.render(llllllllllllllllIIIlllIIIIIlllIl);
            this.body.render(llllllllllllllllIIIlllIIIIIlllIl);
            this.leg1.render(llllllllllllllllIIIlllIIIIIlllIl);
            this.leg2.render(llllllllllllllllIIIlllIIIIIlllIl);
            this.leg3.render(llllllllllllllllIIIlllIIIIIlllIl);
            this.leg4.render(llllllllllllllllIIIlllIIIIIlllIl);
        }
    }
    
    public ModelPolarBear() {
        super(12, 0.0f);
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.5f, -3.0f, -3.0f, 7, 7, 7, 0.0f);
        this.head.setRotationPoint(0.0f, 10.0f, -16.0f);
        this.head.setTextureOffset(0, 44).addBox(-2.5f, 1.0f, -6.0f, 5, 3, 3, 0.0f);
        this.head.setTextureOffset(26, 0).addBox(-4.5f, -4.0f, -1.0f, 2, 2, 1, 0.0f);
        final ModelRenderer llllllllllllllllIIIlllIIIIllIIll = this.head.setTextureOffset(26, 0);
        llllllllllllllllIIIlllIIIIllIIll.mirror = true;
        llllllllllllllllIIIlllIIIIllIIll.addBox(2.5f, -4.0f, -1.0f, 2, 2, 1, 0.0f);
        this.body = new ModelRenderer(this);
        this.body.setTextureOffset(0, 19).addBox(-5.0f, -13.0f, -7.0f, 14, 14, 11, 0.0f);
        this.body.setTextureOffset(39, 0).addBox(-4.0f, -25.0f, -7.0f, 12, 12, 10, 0.0f);
        this.body.setRotationPoint(-2.0f, 9.0f, 12.0f);
        final int llllllllllllllllIIIlllIIIIllIIlI = 10;
        this.leg1 = new ModelRenderer(this, 50, 22);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 10, 8, 0.0f);
        this.leg1.setRotationPoint(-3.5f, 14.0f, 6.0f);
        this.leg2 = new ModelRenderer(this, 50, 22);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 10, 8, 0.0f);
        this.leg2.setRotationPoint(3.5f, 14.0f, 6.0f);
        this.leg3 = new ModelRenderer(this, 50, 40);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 10, 6, 0.0f);
        this.leg3.setRotationPoint(-2.5f, 14.0f, -7.0f);
        this.leg4 = new ModelRenderer(this, 50, 40);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 10, 6, 0.0f);
        this.leg4.setRotationPoint(2.5f, 14.0f, -7.0f);
        final ModelRenderer leg1 = this.leg1;
        --leg1.rotationPointX;
        final ModelRenderer leg2 = this.leg2;
        ++leg2.rotationPointX;
        final ModelRenderer leg3 = this.leg1;
        leg3.rotationPointZ += 0.0f;
        final ModelRenderer leg4 = this.leg2;
        leg4.rotationPointZ += 0.0f;
        final ModelRenderer leg5 = this.leg3;
        --leg5.rotationPointX;
        final ModelRenderer leg6 = this.leg4;
        ++leg6.rotationPointX;
        final ModelRenderer leg7 = this.leg3;
        --leg7.rotationPointZ;
        final ModelRenderer leg8 = this.leg4;
        --leg8.rotationPointZ;
        this.childZOffset += 2.0f;
    }
}
