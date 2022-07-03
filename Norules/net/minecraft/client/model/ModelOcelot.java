package net.minecraft.client.model;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;

public class ModelOcelot extends ModelBase
{
    private final /* synthetic */ ModelRenderer ocelotTail;
    private final /* synthetic */ ModelRenderer ocelotBackLeftLeg;
    private final /* synthetic */ ModelRenderer ocelotFrontRightLeg;
    private final /* synthetic */ ModelRenderer ocelotBackRightLeg;
    private final /* synthetic */ ModelRenderer ocelotFrontLeftLeg;
    private final /* synthetic */ ModelRenderer ocelotBody;
    private final /* synthetic */ ModelRenderer ocelotTail2;
    private final /* synthetic */ ModelRenderer ocelotHead;
    private /* synthetic */ int state;
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllIlllIIllIIlIIlIIIll, final float lllllllllllllIlllIIllIIlIIlIIIIl, final float lllllllllllllIlllIIllIIlIIIllllI, final float lllllllllllllIlllIIllIIlIIIlllII) {
        final EntityOcelot lllllllllllllIlllIIllIIlIIIllIlI = (EntityOcelot)lllllllllllllIlllIIllIIlIIlIIIll;
        this.ocelotBody.rotationPointY = 12.0f;
        this.ocelotBody.rotationPointZ = -10.0f;
        this.ocelotHead.rotationPointY = 15.0f;
        this.ocelotHead.rotationPointZ = -9.0f;
        this.ocelotTail.rotationPointY = 15.0f;
        this.ocelotTail.rotationPointZ = 8.0f;
        this.ocelotTail2.rotationPointY = 20.0f;
        this.ocelotTail2.rotationPointZ = 14.0f;
        this.ocelotFrontLeftLeg.rotationPointY = 13.8f;
        this.ocelotFrontLeftLeg.rotationPointZ = -5.0f;
        this.ocelotFrontRightLeg.rotationPointY = 13.8f;
        this.ocelotFrontRightLeg.rotationPointZ = -5.0f;
        this.ocelotBackLeftLeg.rotationPointY = 18.0f;
        this.ocelotBackLeftLeg.rotationPointZ = 5.0f;
        this.ocelotBackRightLeg.rotationPointY = 18.0f;
        this.ocelotBackRightLeg.rotationPointZ = 5.0f;
        this.ocelotTail.rotateAngleX = 0.9f;
        if (lllllllllllllIlllIIllIIlIIIllIlI.isSneaking()) {
            final ModelRenderer ocelotBody = this.ocelotBody;
            ++ocelotBody.rotationPointY;
            final ModelRenderer ocelotHead = this.ocelotHead;
            ocelotHead.rotationPointY += 2.0f;
            final ModelRenderer ocelotTail = this.ocelotTail;
            ++ocelotTail.rotationPointY;
            final ModelRenderer ocelotTail2 = this.ocelotTail2;
            ocelotTail2.rotationPointY -= 4.0f;
            final ModelRenderer ocelotTail3 = this.ocelotTail2;
            ocelotTail3.rotationPointZ += 2.0f;
            this.ocelotTail.rotateAngleX = 1.5707964f;
            this.ocelotTail2.rotateAngleX = 1.5707964f;
            this.state = 0;
        }
        else if (lllllllllllllIlllIIllIIlIIIllIlI.isSprinting()) {
            this.ocelotTail2.rotationPointY = this.ocelotTail.rotationPointY;
            final ModelRenderer ocelotTail4 = this.ocelotTail2;
            ocelotTail4.rotationPointZ += 2.0f;
            this.ocelotTail.rotateAngleX = 1.5707964f;
            this.ocelotTail2.rotateAngleX = 1.5707964f;
            this.state = 2;
        }
        else if (lllllllllllllIlllIIllIIlIIIllIlI.isSitting()) {
            this.ocelotBody.rotateAngleX = 0.7853982f;
            final ModelRenderer ocelotBody2 = this.ocelotBody;
            ocelotBody2.rotationPointY -= 4.0f;
            final ModelRenderer ocelotBody3 = this.ocelotBody;
            ocelotBody3.rotationPointZ += 5.0f;
            final ModelRenderer ocelotHead2 = this.ocelotHead;
            ocelotHead2.rotationPointY -= 3.3f;
            final ModelRenderer ocelotHead3 = this.ocelotHead;
            ++ocelotHead3.rotationPointZ;
            final ModelRenderer ocelotTail5 = this.ocelotTail;
            ocelotTail5.rotationPointY += 8.0f;
            final ModelRenderer ocelotTail6 = this.ocelotTail;
            ocelotTail6.rotationPointZ -= 2.0f;
            final ModelRenderer ocelotTail7 = this.ocelotTail2;
            ocelotTail7.rotationPointY += 2.0f;
            final ModelRenderer ocelotTail8 = this.ocelotTail2;
            ocelotTail8.rotationPointZ -= 0.8f;
            this.ocelotTail.rotateAngleX = 1.7278761f;
            this.ocelotTail2.rotateAngleX = 2.670354f;
            this.ocelotFrontLeftLeg.rotateAngleX = -0.15707964f;
            this.ocelotFrontLeftLeg.rotationPointY = 15.8f;
            this.ocelotFrontLeftLeg.rotationPointZ = -7.0f;
            this.ocelotFrontRightLeg.rotateAngleX = -0.15707964f;
            this.ocelotFrontRightLeg.rotationPointY = 15.8f;
            this.ocelotFrontRightLeg.rotationPointZ = -7.0f;
            this.ocelotBackLeftLeg.rotateAngleX = -1.5707964f;
            this.ocelotBackLeftLeg.rotationPointY = 21.0f;
            this.ocelotBackLeftLeg.rotationPointZ = 1.0f;
            this.ocelotBackRightLeg.rotateAngleX = -1.5707964f;
            this.ocelotBackRightLeg.rotationPointY = 21.0f;
            this.ocelotBackRightLeg.rotationPointZ = 1.0f;
            this.state = 3;
        }
        else {
            this.state = 1;
        }
    }
    
    @Override
    public void render(final Entity lllllllllllllIlllIIllIIlIlllIIlI, final float lllllllllllllIlllIIllIIlIlllllIl, final float lllllllllllllIlllIIllIIlIllIlllI, final float lllllllllllllIlllIIllIIlIllIllIl, final float lllllllllllllIlllIIllIIlIllllIIl, final float lllllllllllllIlllIIllIIlIllIlIIl, final float lllllllllllllIlllIIllIIlIlllIllI) {
        this.setRotationAngles(lllllllllllllIlllIIllIIlIlllllIl, lllllllllllllIlllIIllIIlIllIlllI, lllllllllllllIlllIIllIIlIllIllIl, lllllllllllllIlllIIllIIlIllllIIl, lllllllllllllIlllIIllIIlIllIlIIl, lllllllllllllIlllIIllIIlIlllIllI, lllllllllllllIlllIIllIIlIlllIIlI);
        if (this.isChild) {
            final float lllllllllllllIlllIIllIIlIlllIlII = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.75f, 0.75f, 0.75f);
            GlStateManager.translate(0.0f, 10.0f * lllllllllllllIlllIIllIIlIlllIllI, 4.0f * lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotHead.render(lllllllllllllIlllIIllIIlIlllIllI);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * lllllllllllllIlllIIllIIlIlllIllI, 0.0f);
            this.ocelotBody.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotBackLeftLeg.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotBackRightLeg.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotFrontLeftLeg.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotFrontRightLeg.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotTail.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotTail2.render(lllllllllllllIlllIIllIIlIlllIllI);
            GlStateManager.popMatrix();
        }
        else {
            this.ocelotHead.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotBody.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotTail.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotTail2.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotBackLeftLeg.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotBackRightLeg.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotFrontLeftLeg.render(lllllllllllllIlllIIllIIlIlllIllI);
            this.ocelotFrontRightLeg.render(lllllllllllllIlllIIllIIlIlllIllI);
        }
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlllIIllIIlIlIlllII, final float lllllllllllllIlllIIllIIlIlIllIll, final float lllllllllllllIlllIIllIIlIlIllIlI, final float lllllllllllllIlllIIllIIlIlIIlllI, final float lllllllllllllIlllIIllIIlIlIlIlll, final float lllllllllllllIlllIIllIIlIlIlIllI, final Entity lllllllllllllIlllIIllIIlIlIlIlIl) {
        this.ocelotHead.rotateAngleX = lllllllllllllIlllIIllIIlIlIlIlll * 0.017453292f;
        this.ocelotHead.rotateAngleY = lllllllllllllIlllIIllIIlIlIIlllI * 0.017453292f;
        if (this.state != 3) {
            this.ocelotBody.rotateAngleX = 1.5707964f;
            if (this.state == 2) {
                this.ocelotBackLeftLeg.rotateAngleX = MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII * 0.6662f) * lllllllllllllIlllIIllIIlIlIllIll;
                this.ocelotBackRightLeg.rotateAngleX = MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII * 0.6662f + 0.3f) * lllllllllllllIlllIIllIIlIlIllIll;
                this.ocelotFrontLeftLeg.rotateAngleX = MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII * 0.6662f + 3.1415927f + 0.3f) * lllllllllllllIlllIIllIIlIlIllIll;
                this.ocelotFrontRightLeg.rotateAngleX = MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII * 0.6662f + 3.1415927f) * lllllllllllllIlllIIllIIlIlIllIll;
                this.ocelotTail2.rotateAngleX = 1.7278761f + 0.31415927f * MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII) * lllllllllllllIlllIIllIIlIlIllIll;
            }
            else {
                this.ocelotBackLeftLeg.rotateAngleX = MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII * 0.6662f) * lllllllllllllIlllIIllIIlIlIllIll;
                this.ocelotBackRightLeg.rotateAngleX = MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII * 0.6662f + 3.1415927f) * lllllllllllllIlllIIllIIlIlIllIll;
                this.ocelotFrontLeftLeg.rotateAngleX = MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII * 0.6662f + 3.1415927f) * lllllllllllllIlllIIllIIlIlIllIll;
                this.ocelotFrontRightLeg.rotateAngleX = MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII * 0.6662f) * lllllllllllllIlllIIllIIlIlIllIll;
                if (this.state == 1) {
                    this.ocelotTail2.rotateAngleX = 1.7278761f + 0.7853982f * MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII) * lllllllllllllIlllIIllIIlIlIllIll;
                }
                else {
                    this.ocelotTail2.rotateAngleX = 1.7278761f + 0.47123894f * MathHelper.cos(lllllllllllllIlllIIllIIlIlIlllII) * lllllllllllllIlllIIllIIlIlIllIll;
                }
            }
        }
    }
    
    public ModelOcelot() {
        this.state = 1;
        this.setTextureOffset("head.main", 0, 0);
        this.setTextureOffset("head.nose", 0, 24);
        this.setTextureOffset("head.ear1", 0, 10);
        this.setTextureOffset("head.ear2", 6, 10);
        this.ocelotHead = new ModelRenderer(this, "head");
        this.ocelotHead.addBox("main", -2.5f, -2.0f, -3.0f, 5, 4, 5);
        this.ocelotHead.addBox("nose", -1.5f, 0.0f, -4.0f, 3, 2, 2);
        this.ocelotHead.addBox("ear1", -2.0f, -3.0f, 0.0f, 1, 1, 2);
        this.ocelotHead.addBox("ear2", 1.0f, -3.0f, 0.0f, 1, 1, 2);
        this.ocelotHead.setRotationPoint(0.0f, 15.0f, -9.0f);
        this.ocelotBody = new ModelRenderer(this, 20, 0);
        this.ocelotBody.addBox(-2.0f, 3.0f, -8.0f, 4, 16, 6, 0.0f);
        this.ocelotBody.setRotationPoint(0.0f, 12.0f, -10.0f);
        this.ocelotTail = new ModelRenderer(this, 0, 15);
        this.ocelotTail.addBox(-0.5f, 0.0f, 0.0f, 1, 8, 1);
        this.ocelotTail.rotateAngleX = 0.9f;
        this.ocelotTail.setRotationPoint(0.0f, 15.0f, 8.0f);
        this.ocelotTail2 = new ModelRenderer(this, 4, 15);
        this.ocelotTail2.addBox(-0.5f, 0.0f, 0.0f, 1, 8, 1);
        this.ocelotTail2.setRotationPoint(0.0f, 20.0f, 14.0f);
        this.ocelotBackLeftLeg = new ModelRenderer(this, 8, 13);
        this.ocelotBackLeftLeg.addBox(-1.0f, 0.0f, 1.0f, 2, 6, 2);
        this.ocelotBackLeftLeg.setRotationPoint(1.1f, 18.0f, 5.0f);
        this.ocelotBackRightLeg = new ModelRenderer(this, 8, 13);
        this.ocelotBackRightLeg.addBox(-1.0f, 0.0f, 1.0f, 2, 6, 2);
        this.ocelotBackRightLeg.setRotationPoint(-1.1f, 18.0f, 5.0f);
        this.ocelotFrontLeftLeg = new ModelRenderer(this, 40, 0);
        this.ocelotFrontLeftLeg.addBox(-1.0f, 0.0f, 0.0f, 2, 10, 2);
        this.ocelotFrontLeftLeg.setRotationPoint(1.2f, 13.8f, -5.0f);
        this.ocelotFrontRightLeg = new ModelRenderer(this, 40, 0);
        this.ocelotFrontRightLeg.addBox(-1.0f, 0.0f, 0.0f, 2, 10, 2);
        this.ocelotFrontRightLeg.setRotationPoint(-1.2f, 13.8f, -5.0f);
    }
}
