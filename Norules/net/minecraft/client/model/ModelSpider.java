package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelSpider extends ModelBase
{
    public /* synthetic */ ModelRenderer spiderBody;
    public /* synthetic */ ModelRenderer spiderLeg3;
    public /* synthetic */ ModelRenderer spiderLeg7;
    public /* synthetic */ ModelRenderer spiderNeck;
    public /* synthetic */ ModelRenderer spiderLeg2;
    public /* synthetic */ ModelRenderer spiderLeg8;
    public /* synthetic */ ModelRenderer spiderLeg4;
    public /* synthetic */ ModelRenderer spiderLeg6;
    public /* synthetic */ ModelRenderer spiderHead;
    public /* synthetic */ ModelRenderer spiderLeg1;
    public /* synthetic */ ModelRenderer spiderLeg5;
    
    @Override
    public void setRotationAngles(final float llllllllllllllllIlIlIIlIIllIIlIl, final float llllllllllllllllIlIlIIlIIlllIlll, final float llllllllllllllllIlIlIIlIIlllIllI, final float llllllllllllllllIlIlIIlIIlllIlIl, final float llllllllllllllllIlIlIIlIIlllIlII, final float llllllllllllllllIlIlIIlIIlllIIll, final Entity llllllllllllllllIlIlIIlIIlllIIlI) {
        this.spiderHead.rotateAngleY = llllllllllllllllIlIlIIlIIlllIlIl * 0.017453292f;
        this.spiderHead.rotateAngleX = llllllllllllllllIlIlIIlIIlllIlII * 0.017453292f;
        final float llllllllllllllllIlIlIIlIIlllIIIl = 0.7853982f;
        this.spiderLeg1.rotateAngleZ = -0.7853982f;
        this.spiderLeg2.rotateAngleZ = 0.7853982f;
        this.spiderLeg3.rotateAngleZ = -0.58119464f;
        this.spiderLeg4.rotateAngleZ = 0.58119464f;
        this.spiderLeg5.rotateAngleZ = -0.58119464f;
        this.spiderLeg6.rotateAngleZ = 0.58119464f;
        this.spiderLeg7.rotateAngleZ = -0.7853982f;
        this.spiderLeg8.rotateAngleZ = 0.7853982f;
        final float llllllllllllllllIlIlIIlIIlllIIII = -0.0f;
        final float llllllllllllllllIlIlIIlIIllIllll = 0.3926991f;
        this.spiderLeg1.rotateAngleY = 0.7853982f;
        this.spiderLeg2.rotateAngleY = -0.7853982f;
        this.spiderLeg3.rotateAngleY = 0.3926991f;
        this.spiderLeg4.rotateAngleY = -0.3926991f;
        this.spiderLeg5.rotateAngleY = -0.3926991f;
        this.spiderLeg6.rotateAngleY = 0.3926991f;
        this.spiderLeg7.rotateAngleY = -0.7853982f;
        this.spiderLeg8.rotateAngleY = 0.7853982f;
        final float llllllllllllllllIlIlIIlIIllIlllI = -(MathHelper.cos(llllllllllllllllIlIlIIlIIllIIlIl * 0.6662f * 2.0f + 0.0f) * 0.4f) * llllllllllllllllIlIlIIlIIlllIlll;
        final float llllllllllllllllIlIlIIlIIllIllIl = -(MathHelper.cos(llllllllllllllllIlIlIIlIIllIIlIl * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * llllllllllllllllIlIlIIlIIlllIlll;
        final float llllllllllllllllIlIlIIlIIllIllII = -(MathHelper.cos(llllllllllllllllIlIlIIlIIllIIlIl * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * llllllllllllllllIlIlIIlIIlllIlll;
        final float llllllllllllllllIlIlIIlIIllIlIll = -(MathHelper.cos(llllllllllllllllIlIlIIlIIllIIlIl * 0.6662f * 2.0f + 4.712389f) * 0.4f) * llllllllllllllllIlIlIIlIIlllIlll;
        final float llllllllllllllllIlIlIIlIIllIlIlI = Math.abs(MathHelper.sin(llllllllllllllllIlIlIIlIIllIIlIl * 0.6662f + 0.0f) * 0.4f) * llllllllllllllllIlIlIIlIIlllIlll;
        final float llllllllllllllllIlIlIIlIIllIlIIl = Math.abs(MathHelper.sin(llllllllllllllllIlIlIIlIIllIIlIl * 0.6662f + 3.1415927f) * 0.4f) * llllllllllllllllIlIlIIlIIlllIlll;
        final float llllllllllllllllIlIlIIlIIllIlIII = Math.abs(MathHelper.sin(llllllllllllllllIlIlIIlIIllIIlIl * 0.6662f + 1.5707964f) * 0.4f) * llllllllllllllllIlIlIIlIIlllIlll;
        final float llllllllllllllllIlIlIIlIIllIIlll = Math.abs(MathHelper.sin(llllllllllllllllIlIlIIlIIllIIlIl * 0.6662f + 4.712389f) * 0.4f) * llllllllllllllllIlIlIIlIIlllIlll;
        final ModelRenderer spiderLeg1 = this.spiderLeg1;
        spiderLeg1.rotateAngleY += llllllllllllllllIlIlIIlIIllIlllI;
        final ModelRenderer spiderLeg2 = this.spiderLeg2;
        spiderLeg2.rotateAngleY += -llllllllllllllllIlIlIIlIIllIlllI;
        final ModelRenderer spiderLeg3 = this.spiderLeg3;
        spiderLeg3.rotateAngleY += llllllllllllllllIlIlIIlIIllIllIl;
        final ModelRenderer spiderLeg4 = this.spiderLeg4;
        spiderLeg4.rotateAngleY += -llllllllllllllllIlIlIIlIIllIllIl;
        final ModelRenderer spiderLeg5 = this.spiderLeg5;
        spiderLeg5.rotateAngleY += llllllllllllllllIlIlIIlIIllIllII;
        final ModelRenderer spiderLeg6 = this.spiderLeg6;
        spiderLeg6.rotateAngleY += -llllllllllllllllIlIlIIlIIllIllII;
        final ModelRenderer spiderLeg7 = this.spiderLeg7;
        spiderLeg7.rotateAngleY += llllllllllllllllIlIlIIlIIllIlIll;
        final ModelRenderer spiderLeg8 = this.spiderLeg8;
        spiderLeg8.rotateAngleY += -llllllllllllllllIlIlIIlIIllIlIll;
        final ModelRenderer spiderLeg9 = this.spiderLeg1;
        spiderLeg9.rotateAngleZ += llllllllllllllllIlIlIIlIIllIlIlI;
        final ModelRenderer spiderLeg10 = this.spiderLeg2;
        spiderLeg10.rotateAngleZ += -llllllllllllllllIlIlIIlIIllIlIlI;
        final ModelRenderer spiderLeg11 = this.spiderLeg3;
        spiderLeg11.rotateAngleZ += llllllllllllllllIlIlIIlIIllIlIIl;
        final ModelRenderer spiderLeg12 = this.spiderLeg4;
        spiderLeg12.rotateAngleZ += -llllllllllllllllIlIlIIlIIllIlIIl;
        final ModelRenderer spiderLeg13 = this.spiderLeg5;
        spiderLeg13.rotateAngleZ += llllllllllllllllIlIlIIlIIllIlIII;
        final ModelRenderer spiderLeg14 = this.spiderLeg6;
        spiderLeg14.rotateAngleZ += -llllllllllllllllIlIlIIlIIllIlIII;
        final ModelRenderer spiderLeg15 = this.spiderLeg7;
        spiderLeg15.rotateAngleZ += llllllllllllllllIlIlIIlIIllIIlll;
        final ModelRenderer spiderLeg16 = this.spiderLeg8;
        spiderLeg16.rotateAngleZ += -llllllllllllllllIlIlIIlIIllIIlll;
    }
    
    @Override
    public void render(final Entity llllllllllllllllIlIlIIlIlIIllllI, final float llllllllllllllllIlIlIIlIlIIlllIl, final float llllllllllllllllIlIlIIlIlIIllIll, final float llllllllllllllllIlIlIIlIlIIllIIl, final float llllllllllllllllIlIlIIlIlIIlIlll, final float llllllllllllllllIlIlIIlIlIIIlIll, final float llllllllllllllllIlIlIIlIlIIIlIlI) {
        this.setRotationAngles(llllllllllllllllIlIlIIlIlIIlllIl, llllllllllllllllIlIlIIlIlIIllIll, llllllllllllllllIlIlIIlIlIIllIIl, llllllllllllllllIlIlIIlIlIIlIlll, llllllllllllllllIlIlIIlIlIIIlIll, llllllllllllllllIlIlIIlIlIIIlIlI, llllllllllllllllIlIlIIlIlIIllllI);
        this.spiderHead.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderNeck.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderBody.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderLeg1.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderLeg2.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderLeg3.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderLeg4.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderLeg5.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderLeg6.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderLeg7.render(llllllllllllllllIlIlIIlIlIIIlIlI);
        this.spiderLeg8.render(llllllllllllllllIlIlIIlIlIIIlIlI);
    }
    
    public ModelSpider() {
        final float llllllllllllllllIlIlIIlIlIllllIl = 0.0f;
        final int llllllllllllllllIlIlIIlIlIlllIll = 15;
        this.spiderHead = new ModelRenderer(this, 32, 4);
        this.spiderHead.addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8, 0.0f);
        this.spiderHead.setRotationPoint(0.0f, 15.0f, -3.0f);
        this.spiderNeck = new ModelRenderer(this, 0, 0);
        this.spiderNeck.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.spiderNeck.setRotationPoint(0.0f, 15.0f, 0.0f);
        this.spiderBody = new ModelRenderer(this, 0, 12);
        this.spiderBody.addBox(-5.0f, -4.0f, -6.0f, 10, 8, 12, 0.0f);
        this.spiderBody.setRotationPoint(0.0f, 15.0f, 9.0f);
        this.spiderLeg1 = new ModelRenderer(this, 18, 0);
        this.spiderLeg1.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg1.setRotationPoint(-4.0f, 15.0f, 2.0f);
        this.spiderLeg2 = new ModelRenderer(this, 18, 0);
        this.spiderLeg2.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg2.setRotationPoint(4.0f, 15.0f, 2.0f);
        this.spiderLeg3 = new ModelRenderer(this, 18, 0);
        this.spiderLeg3.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg3.setRotationPoint(-4.0f, 15.0f, 1.0f);
        this.spiderLeg4 = new ModelRenderer(this, 18, 0);
        this.spiderLeg4.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg4.setRotationPoint(4.0f, 15.0f, 1.0f);
        this.spiderLeg5 = new ModelRenderer(this, 18, 0);
        this.spiderLeg5.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg5.setRotationPoint(-4.0f, 15.0f, 0.0f);
        this.spiderLeg6 = new ModelRenderer(this, 18, 0);
        this.spiderLeg6.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg6.setRotationPoint(4.0f, 15.0f, 0.0f);
        this.spiderLeg7 = new ModelRenderer(this, 18, 0);
        this.spiderLeg7.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg7.setRotationPoint(-4.0f, 15.0f, -1.0f);
        this.spiderLeg8 = new ModelRenderer(this, 18, 0);
        this.spiderLeg8.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg8.setRotationPoint(4.0f, 15.0f, -1.0f);
    }
}
