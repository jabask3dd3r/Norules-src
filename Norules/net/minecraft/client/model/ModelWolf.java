package net.minecraft.client.model;

import net.minecraft.entity.passive.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class ModelWolf extends ModelBase
{
    public /* synthetic */ ModelRenderer wolfLeg4;
    /* synthetic */ ModelRenderer wolfTail;
    public /* synthetic */ ModelRenderer wolfBody;
    public /* synthetic */ ModelRenderer wolfHeadMain;
    public /* synthetic */ ModelRenderer wolfLeg2;
    public /* synthetic */ ModelRenderer wolfLeg3;
    public /* synthetic */ ModelRenderer wolfLeg1;
    /* synthetic */ ModelRenderer wolfMane;
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllIIIIllIlIIlIIIIlIll, final float lllllllllllllIIIIllIlIIlIIIIlIlI, final float lllllllllllllIIIIllIlIIlIIIIlIIl, final float lllllllllllllIIIIllIlIIlIIIIlllI) {
        final EntityWolf lllllllllllllIIIIllIlIIlIIIIllIl = (EntityWolf)lllllllllllllIIIIllIlIIlIIIIlIll;
        if (lllllllllllllIIIIllIlIIlIIIIllIl.isAngry()) {
            this.wolfTail.rotateAngleY = 0.0f;
        }
        else {
            this.wolfTail.rotateAngleY = MathHelper.cos(lllllllllllllIIIIllIlIIlIIIIlIlI * 0.6662f) * 1.4f * lllllllllllllIIIIllIlIIlIIIIlIIl;
        }
        if (lllllllllllllIIIIllIlIIlIIIIllIl.isSitting()) {
            this.wolfMane.setRotationPoint(-1.0f, 16.0f, -3.0f);
            this.wolfMane.rotateAngleX = 1.2566371f;
            this.wolfMane.rotateAngleY = 0.0f;
            this.wolfBody.setRotationPoint(0.0f, 18.0f, 0.0f);
            this.wolfBody.rotateAngleX = 0.7853982f;
            this.wolfTail.setRotationPoint(-1.0f, 21.0f, 6.0f);
            this.wolfLeg1.setRotationPoint(-2.5f, 22.0f, 2.0f);
            this.wolfLeg1.rotateAngleX = 4.712389f;
            this.wolfLeg2.setRotationPoint(0.5f, 22.0f, 2.0f);
            this.wolfLeg2.rotateAngleX = 4.712389f;
            this.wolfLeg3.rotateAngleX = 5.811947f;
            this.wolfLeg3.setRotationPoint(-2.49f, 17.0f, -4.0f);
            this.wolfLeg4.rotateAngleX = 5.811947f;
            this.wolfLeg4.setRotationPoint(0.51f, 17.0f, -4.0f);
        }
        else {
            this.wolfBody.setRotationPoint(0.0f, 14.0f, 2.0f);
            this.wolfBody.rotateAngleX = 1.5707964f;
            this.wolfMane.setRotationPoint(-1.0f, 14.0f, -3.0f);
            this.wolfMane.rotateAngleX = this.wolfBody.rotateAngleX;
            this.wolfTail.setRotationPoint(-1.0f, 12.0f, 8.0f);
            this.wolfLeg1.setRotationPoint(-2.5f, 16.0f, 7.0f);
            this.wolfLeg2.setRotationPoint(0.5f, 16.0f, 7.0f);
            this.wolfLeg3.setRotationPoint(-2.5f, 16.0f, -4.0f);
            this.wolfLeg4.setRotationPoint(0.5f, 16.0f, -4.0f);
            this.wolfLeg1.rotateAngleX = MathHelper.cos(lllllllllllllIIIIllIlIIlIIIIlIlI * 0.6662f) * 1.4f * lllllllllllllIIIIllIlIIlIIIIlIIl;
            this.wolfLeg2.rotateAngleX = MathHelper.cos(lllllllllllllIIIIllIlIIlIIIIlIlI * 0.6662f + 3.1415927f) * 1.4f * lllllllllllllIIIIllIlIIlIIIIlIIl;
            this.wolfLeg3.rotateAngleX = MathHelper.cos(lllllllllllllIIIIllIlIIlIIIIlIlI * 0.6662f + 3.1415927f) * 1.4f * lllllllllllllIIIIllIlIIlIIIIlIIl;
            this.wolfLeg4.rotateAngleX = MathHelper.cos(lllllllllllllIIIIllIlIIlIIIIlIlI * 0.6662f) * 1.4f * lllllllllllllIIIIllIlIIlIIIIlIIl;
        }
        this.wolfHeadMain.rotateAngleZ = lllllllllllllIIIIllIlIIlIIIIllIl.getInterestedAngle(lllllllllllllIIIIllIlIIlIIIIlllI) + lllllllllllllIIIIllIlIIlIIIIllIl.getShakeAngle(lllllllllllllIIIIllIlIIlIIIIlllI, 0.0f);
        this.wolfMane.rotateAngleZ = lllllllllllllIIIIllIlIIlIIIIllIl.getShakeAngle(lllllllllllllIIIIllIlIIlIIIIlllI, -0.08f);
        this.wolfBody.rotateAngleZ = lllllllllllllIIIIllIlIIlIIIIllIl.getShakeAngle(lllllllllllllIIIIllIlIIlIIIIlllI, -0.16f);
        this.wolfTail.rotateAngleZ = lllllllllllllIIIIllIlIIlIIIIllIl.getShakeAngle(lllllllllllllIIIIllIlIIlIIIIlllI, -0.2f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIIIIllIlIIIllllIlIl, final float lllllllllllllIIIIllIlIIIllllllII, final float lllllllllllllIIIIllIlIIIlllllIll, final float lllllllllllllIIIIllIlIIIlllllIlI, final float lllllllllllllIIIIllIlIIIlllllIIl, final float lllllllllllllIIIIllIlIIIllllIIII, final Entity lllllllllllllIIIIllIlIIIllllIlll) {
        super.setRotationAngles(lllllllllllllIIIIllIlIIIllllIlIl, lllllllllllllIIIIllIlIIIllllllII, lllllllllllllIIIIllIlIIIlllllIll, lllllllllllllIIIIllIlIIIlllllIlI, lllllllllllllIIIIllIlIIIlllllIIl, lllllllllllllIIIIllIlIIIllllIIII, lllllllllllllIIIIllIlIIIllllIlll);
        this.wolfHeadMain.rotateAngleX = lllllllllllllIIIIllIlIIIlllllIIl * 0.017453292f;
        this.wolfHeadMain.rotateAngleY = lllllllllllllIIIIllIlIIIlllllIlI * 0.017453292f;
        this.wolfTail.rotateAngleX = lllllllllllllIIIIllIlIIIlllllIll;
    }
    
    public ModelWolf() {
        final float lllllllllllllIIIIllIlIIlIIlllIII = 0.0f;
        final float lllllllllllllIIIIllIlIIlIIllIlll = 13.5f;
        this.wolfHeadMain = new ModelRenderer(this, 0, 0);
        this.wolfHeadMain.addBox(-2.0f, -3.0f, -2.0f, 6, 6, 4, 0.0f);
        this.wolfHeadMain.setRotationPoint(-1.0f, 13.5f, -7.0f);
        this.wolfBody = new ModelRenderer(this, 18, 14);
        this.wolfBody.addBox(-3.0f, -2.0f, -3.0f, 6, 9, 6, 0.0f);
        this.wolfBody.setRotationPoint(0.0f, 14.0f, 2.0f);
        this.wolfMane = new ModelRenderer(this, 21, 0);
        this.wolfMane.addBox(-3.0f, -3.0f, -3.0f, 8, 6, 7, 0.0f);
        this.wolfMane.setRotationPoint(-1.0f, 14.0f, 2.0f);
        this.wolfLeg1 = new ModelRenderer(this, 0, 18);
        this.wolfLeg1.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfLeg1.setRotationPoint(-2.5f, 16.0f, 7.0f);
        this.wolfLeg2 = new ModelRenderer(this, 0, 18);
        this.wolfLeg2.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfLeg2.setRotationPoint(0.5f, 16.0f, 7.0f);
        this.wolfLeg3 = new ModelRenderer(this, 0, 18);
        this.wolfLeg3.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfLeg3.setRotationPoint(-2.5f, 16.0f, -4.0f);
        this.wolfLeg4 = new ModelRenderer(this, 0, 18);
        this.wolfLeg4.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfLeg4.setRotationPoint(0.5f, 16.0f, -4.0f);
        this.wolfTail = new ModelRenderer(this, 9, 18);
        this.wolfTail.addBox(0.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f);
        this.wolfTail.setRotationPoint(-1.0f, 12.0f, 8.0f);
        this.wolfHeadMain.setTextureOffset(16, 14).addBox(-2.0f, -5.0f, 0.0f, 2, 2, 1, 0.0f);
        this.wolfHeadMain.setTextureOffset(16, 14).addBox(2.0f, -5.0f, 0.0f, 2, 2, 1, 0.0f);
        this.wolfHeadMain.setTextureOffset(0, 10).addBox(-0.5f, 0.0f, -5.0f, 3, 3, 4, 0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllllIIIIllIlIIlIIlIlIIl, final float lllllllllllllIIIIllIlIIlIIlIlIII, final float lllllllllllllIIIIllIlIIlIIlIIlll, final float lllllllllllllIIIIllIlIIlIIIlllIl, final float lllllllllllllIIIIllIlIIlIIIlllII, final float lllllllllllllIIIIllIlIIlIIIllIll, final float lllllllllllllIIIIllIlIIlIIlIIIll) {
        super.render(lllllllllllllIIIIllIlIIlIIlIlIIl, lllllllllllllIIIIllIlIIlIIlIlIII, lllllllllllllIIIIllIlIIlIIlIIlll, lllllllllllllIIIIllIlIIlIIIlllIl, lllllllllllllIIIIllIlIIlIIIlllII, lllllllllllllIIIIllIlIIlIIIllIll, lllllllllllllIIIIllIlIIlIIlIIIll);
        this.setRotationAngles(lllllllllllllIIIIllIlIIlIIlIlIII, lllllllllllllIIIIllIlIIlIIlIIlll, lllllllllllllIIIIllIlIIlIIIlllIl, lllllllllllllIIIIllIlIIlIIIlllII, lllllllllllllIIIIllIlIIlIIIllIll, lllllllllllllIIIIllIlIIlIIlIIIll, lllllllllllllIIIIllIlIIlIIlIlIIl);
        if (this.isChild) {
            final float lllllllllllllIIIIllIlIIlIIlIIIlI = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 5.0f * lllllllllllllIIIIllIlIIlIIlIIIll, 2.0f * lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfHeadMain.renderWithRotation(lllllllllllllIIIIllIlIIlIIlIIIll);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * lllllllllllllIIIIllIlIIlIIlIIIll, 0.0f);
            this.wolfBody.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfLeg1.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfLeg2.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfLeg3.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfLeg4.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfTail.renderWithRotation(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfMane.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            GlStateManager.popMatrix();
        }
        else {
            this.wolfHeadMain.renderWithRotation(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfBody.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfLeg1.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfLeg2.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfLeg3.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfLeg4.render(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfTail.renderWithRotation(lllllllllllllIIIIllIlIIlIIlIIIll);
            this.wolfMane.render(lllllllllllllIIIIllIlIIlIIlIIIll);
        }
    }
}
