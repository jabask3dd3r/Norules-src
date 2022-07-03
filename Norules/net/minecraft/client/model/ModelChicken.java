package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;

public class ModelChicken extends ModelBase
{
    public /* synthetic */ ModelRenderer chin;
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer bill;
    public /* synthetic */ ModelRenderer leftWing;
    public /* synthetic */ ModelRenderer rightLeg;
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer leftLeg;
    public /* synthetic */ ModelRenderer rightWing;
    
    public ModelChicken() {
        final int llllllllllllIlllllIlIIIIlIIIlIIl = 16;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.0f, -6.0f, -2.0f, 4, 6, 3, 0.0f);
        this.head.setRotationPoint(0.0f, 15.0f, -4.0f);
        this.bill = new ModelRenderer(this, 14, 0);
        this.bill.addBox(-2.0f, -4.0f, -4.0f, 4, 2, 2, 0.0f);
        this.bill.setRotationPoint(0.0f, 15.0f, -4.0f);
        this.chin = new ModelRenderer(this, 14, 4);
        this.chin.addBox(-1.0f, -2.0f, -3.0f, 2, 2, 2, 0.0f);
        this.chin.setRotationPoint(0.0f, 15.0f, -4.0f);
        this.body = new ModelRenderer(this, 0, 9);
        this.body.addBox(-3.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f);
        this.body.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.rightLeg = new ModelRenderer(this, 26, 0);
        this.rightLeg.addBox(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.rightLeg.setRotationPoint(-2.0f, 19.0f, 1.0f);
        this.leftLeg = new ModelRenderer(this, 26, 0);
        this.leftLeg.addBox(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.leftLeg.setRotationPoint(1.0f, 19.0f, 1.0f);
        this.rightWing = new ModelRenderer(this, 24, 13);
        this.rightWing.addBox(0.0f, 0.0f, -3.0f, 1, 4, 6);
        this.rightWing.setRotationPoint(-4.0f, 13.0f, 0.0f);
        this.leftWing = new ModelRenderer(this, 24, 13);
        this.leftWing.addBox(-1.0f, 0.0f, -3.0f, 1, 4, 6);
        this.leftWing.setRotationPoint(4.0f, 13.0f, 0.0f);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllIlllllIlIIIIIllIIlII, final float llllllllllllIlllllIlIIIIIllIIIll, final float llllllllllllIlllllIlIIIIIlIllIlI, final float llllllllllllIlllllIlIIIIIllIIIIl, final float llllllllllllIlllllIlIIIIIlIllIII, final float llllllllllllIlllllIlIIIIIlIlllll, final Entity llllllllllllIlllllIlIIIIIlIllllI) {
        this.head.rotateAngleX = llllllllllllIlllllIlIIIIIlIllIII * 0.017453292f;
        this.head.rotateAngleY = llllllllllllIlllllIlIIIIIllIIIIl * 0.017453292f;
        this.bill.rotateAngleX = this.head.rotateAngleX;
        this.bill.rotateAngleY = this.head.rotateAngleY;
        this.chin.rotateAngleX = this.head.rotateAngleX;
        this.chin.rotateAngleY = this.head.rotateAngleY;
        this.body.rotateAngleX = 1.5707964f;
        this.rightLeg.rotateAngleX = MathHelper.cos(llllllllllllIlllllIlIIIIIllIIlII * 0.6662f) * 1.4f * llllllllllllIlllllIlIIIIIllIIIll;
        this.leftLeg.rotateAngleX = MathHelper.cos(llllllllllllIlllllIlIIIIIllIIlII * 0.6662f + 3.1415927f) * 1.4f * llllllllllllIlllllIlIIIIIllIIIll;
        this.rightWing.rotateAngleZ = llllllllllllIlllllIlIIIIIlIllIlI;
        this.leftWing.rotateAngleZ = -llllllllllllIlllllIlIIIIIlIllIlI;
    }
    
    @Override
    public void render(final Entity llllllllllllIlllllIlIIIIIlllIIll, final float llllllllllllIlllllIlIIIIIllllIll, final float llllllllllllIlllllIlIIIIIlllIIIl, final float llllllllllllIlllllIlIIIIIlllIIII, final float llllllllllllIlllllIlIIIIIllllIII, final float llllllllllllIlllllIlIIIIIllIlllI, final float llllllllllllIlllllIlIIIIIllIllIl) {
        this.setRotationAngles(llllllllllllIlllllIlIIIIIllllIll, llllllllllllIlllllIlIIIIIlllIIIl, llllllllllllIlllllIlIIIIIlllIIII, llllllllllllIlllllIlIIIIIllllIII, llllllllllllIlllllIlIIIIIllIlllI, llllllllllllIlllllIlIIIIIllIllIl, llllllllllllIlllllIlIIIIIlllIIll);
        if (this.isChild) {
            final float llllllllllllIlllllIlIIIIIlllIlIl = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 5.0f * llllllllllllIlllllIlIIIIIllIllIl, 2.0f * llllllllllllIlllllIlIIIIIllIllIl);
            this.head.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.bill.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.chin.render(llllllllllllIlllllIlIIIIIllIllIl);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllIlllllIlIIIIIllIllIl, 0.0f);
            this.body.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.rightLeg.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.leftLeg.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.rightWing.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.leftWing.render(llllllllllllIlllllIlIIIIIllIllIl);
            GlStateManager.popMatrix();
        }
        else {
            this.head.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.bill.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.chin.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.body.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.rightLeg.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.leftLeg.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.rightWing.render(llllllllllllIlllllIlIIIIIllIllIl);
            this.leftWing.render(llllllllllllIlllllIlIIIIIllIllIl);
        }
    }
}
