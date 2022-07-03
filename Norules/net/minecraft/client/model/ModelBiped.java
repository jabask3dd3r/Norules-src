package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class ModelBiped extends ModelBase
{
    public /* synthetic */ ModelRenderer bipedRightArm;
    public /* synthetic */ ModelRenderer bipedRightLeg;
    public /* synthetic */ boolean isSneak;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose;
    public /* synthetic */ ModelRenderer bipedHeadwear;
    public /* synthetic */ ModelRenderer bipedLeftArm;
    public /* synthetic */ ModelRenderer bipedLeftLeg;
    public /* synthetic */ ArmPose leftArmPose;
    public /* synthetic */ ModelRenderer bipedBody;
    public /* synthetic */ ModelRenderer bipedHead;
    public /* synthetic */ ArmPose rightArmPose;
    
    public void postRenderArm(final float lllllllllllllIIIIllIlIlIllllIlll, final EnumHandSide lllllllllllllIIIIllIlIlIllllIllI) {
        this.getArmForSide(lllllllllllllIIIIllIlIlIllllIllI).postRender(lllllllllllllIIIIllIlIlIllllIlll);
    }
    
    public ModelBiped(final float lllllllllllllIIIIllIlIllIllIIIll) {
        this(lllllllllllllIIIIllIlIllIllIIIll, 0.0f, 64, 32);
    }
    
    protected ModelRenderer getArmForSide(final EnumHandSide lllllllllllllIIIIllIlIlIllllIIII) {
        return (lllllllllllllIIIIllIlIlIllllIIII == EnumHandSide.LEFT) ? this.bipedLeftArm : this.bipedRightArm;
    }
    
    public void setInvisible(final boolean lllllllllllllIIIIllIlIllIIIIIIIl) {
        this.bipedHead.showModel = lllllllllllllIIIIllIlIllIIIIIIIl;
        this.bipedHeadwear.showModel = lllllllllllllIIIIllIlIllIIIIIIIl;
        this.bipedBody.showModel = lllllllllllllIIIIllIlIllIIIIIIIl;
        this.bipedRightArm.showModel = lllllllllllllIIIIllIlIllIIIIIIIl;
        this.bipedLeftArm.showModel = lllllllllllllIIIIllIlIllIIIIIIIl;
        this.bipedRightLeg.showModel = lllllllllllllIIIIllIlIllIIIIIIIl;
        this.bipedLeftLeg.showModel = lllllllllllllIIIIllIlIllIIIIIIIl;
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIIIIllIlIllIIIllIlI, final float lllllllllllllIIIIllIlIllIIIllIIl, final float lllllllllllllIIIIllIlIllIIIllIII, final float lllllllllllllIIIIllIlIllIIlIIllI, final float lllllllllllllIIIIllIlIllIIlIIlIl, final float lllllllllllllIIIIllIlIllIIlIIlII, final Entity lllllllllllllIIIIllIlIllIIlIIIll) {
        final boolean lllllllllllllIIIIllIlIllIIlIIIlI = lllllllllllllIIIIllIlIllIIlIIIll instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllIIIIllIlIllIIlIIIll).getTicksElytraFlying() > 4;
        this.bipedHead.rotateAngleY = lllllllllllllIIIIllIlIllIIlIIllI * 0.017453292f;
        if (lllllllllllllIIIIllIlIllIIlIIIlI) {
            this.bipedHead.rotateAngleX = -0.7853982f;
        }
        else {
            this.bipedHead.rotateAngleX = lllllllllllllIIIIllIlIllIIlIIlIl * 0.017453292f;
        }
        this.bipedBody.rotateAngleY = 0.0f;
        this.bipedRightArm.rotationPointZ = 0.0f;
        this.bipedRightArm.rotationPointX = -5.0f;
        this.bipedLeftArm.rotationPointZ = 0.0f;
        this.bipedLeftArm.rotationPointX = 5.0f;
        float lllllllllllllIIIIllIlIllIIlIIIIl = 1.0f;
        if (lllllllllllllIIIIllIlIllIIlIIIlI) {
            lllllllllllllIIIIllIlIllIIlIIIIl = (float)(lllllllllllllIIIIllIlIllIIlIIIll.motionX * lllllllllllllIIIIllIlIllIIlIIIll.motionX + lllllllllllllIIIIllIlIllIIlIIIll.motionY * lllllllllllllIIIIllIlIllIIlIIIll.motionY + lllllllllllllIIIIllIlIllIIlIIIll.motionZ * lllllllllllllIIIIllIlIllIIlIIIll.motionZ);
            lllllllllllllIIIIllIlIllIIlIIIIl /= 0.2f;
            lllllllllllllIIIIllIlIllIIlIIIIl *= lllllllllllllIIIIllIlIllIIlIIIIl * lllllllllllllIIIIllIlIllIIlIIIIl;
        }
        if (lllllllllllllIIIIllIlIllIIlIIIIl < 1.0f) {
            lllllllllllllIIIIllIlIllIIlIIIIl = 1.0f;
        }
        this.bipedRightArm.rotateAngleX = MathHelper.cos(lllllllllllllIIIIllIlIllIIIllIlI * 0.6662f + 3.1415927f) * 2.0f * lllllllllllllIIIIllIlIllIIIllIIl * 0.5f / lllllllllllllIIIIllIlIllIIlIIIIl;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(lllllllllllllIIIIllIlIllIIIllIlI * 0.6662f) * 2.0f * lllllllllllllIIIIllIlIllIIIllIIl * 0.5f / lllllllllllllIIIIllIlIllIIlIIIIl;
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(lllllllllllllIIIIllIlIllIIIllIlI * 0.6662f) * 1.4f * lllllllllllllIIIIllIlIllIIIllIIl / lllllllllllllIIIIllIlIllIIlIIIIl;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(lllllllllllllIIIIllIlIllIIIllIlI * 0.6662f + 3.1415927f) * 1.4f * lllllllllllllIIIIllIlIllIIIllIIl / lllllllllllllIIIIllIlIllIIlIIIIl;
        this.bipedRightLeg.rotateAngleY = 0.0f;
        this.bipedLeftLeg.rotateAngleY = 0.0f;
        this.bipedRightLeg.rotateAngleZ = 0.0f;
        this.bipedLeftLeg.rotateAngleZ = 0.0f;
        if (this.isRiding) {
            final ModelRenderer bipedRightArm = this.bipedRightArm;
            bipedRightArm.rotateAngleX -= 0.62831855f;
            final ModelRenderer bipedLeftArm = this.bipedLeftArm;
            bipedLeftArm.rotateAngleX -= 0.62831855f;
            this.bipedRightLeg.rotateAngleX = -1.4137167f;
            this.bipedRightLeg.rotateAngleY = 0.31415927f;
            this.bipedRightLeg.rotateAngleZ = 0.07853982f;
            this.bipedLeftLeg.rotateAngleX = -1.4137167f;
            this.bipedLeftLeg.rotateAngleY = -0.31415927f;
            this.bipedLeftLeg.rotateAngleZ = -0.07853982f;
        }
        this.bipedRightArm.rotateAngleY = 0.0f;
        this.bipedRightArm.rotateAngleZ = 0.0f;
        switch ($SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose()[this.leftArmPose.ordinal()]) {
            case 1: {
                this.bipedLeftArm.rotateAngleY = 0.0f;
                break;
            }
            case 3: {
                this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5f - 0.9424779f;
                this.bipedLeftArm.rotateAngleY = 0.5235988f;
                break;
            }
            case 2: {
                this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5f - 0.31415927f;
                this.bipedLeftArm.rotateAngleY = 0.0f;
                break;
            }
        }
        switch ($SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose()[this.rightArmPose.ordinal()]) {
            case 1: {
                this.bipedRightArm.rotateAngleY = 0.0f;
                break;
            }
            case 3: {
                this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5f - 0.9424779f;
                this.bipedRightArm.rotateAngleY = -0.5235988f;
                break;
            }
            case 2: {
                this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5f - 0.31415927f;
                this.bipedRightArm.rotateAngleY = 0.0f;
                break;
            }
        }
        if (this.swingProgress > 0.0f) {
            final EnumHandSide lllllllllllllIIIIllIlIllIIlIIIII = this.getMainHand(lllllllllllllIIIIllIlIllIIlIIIll);
            final ModelRenderer lllllllllllllIIIIllIlIllIIIlllll = this.getArmForSide(lllllllllllllIIIIllIlIllIIlIIIII);
            float lllllllllllllIIIIllIlIllIIIllllI = this.swingProgress;
            this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt(lllllllllllllIIIIllIlIllIIIllllI) * 6.2831855f) * 0.2f;
            if (lllllllllllllIIIIllIlIllIIlIIIII == EnumHandSide.LEFT) {
                final ModelRenderer bipedBody = this.bipedBody;
                bipedBody.rotateAngleY *= -1.0f;
            }
            this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0f;
            this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0f;
            final ModelRenderer bipedRightArm2 = this.bipedRightArm;
            bipedRightArm2.rotateAngleY += this.bipedBody.rotateAngleY;
            final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
            bipedLeftArm2.rotateAngleY += this.bipedBody.rotateAngleY;
            final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
            bipedLeftArm3.rotateAngleX += this.bipedBody.rotateAngleY;
            lllllllllllllIIIIllIlIllIIIllllI = 1.0f - this.swingProgress;
            lllllllllllllIIIIllIlIllIIIllllI *= lllllllllllllIIIIllIlIllIIIllllI;
            lllllllllllllIIIIllIlIllIIIllllI *= lllllllllllllIIIIllIlIllIIIllllI;
            lllllllllllllIIIIllIlIllIIIllllI = 1.0f - lllllllllllllIIIIllIlIllIIIllllI;
            final float lllllllllllllIIIIllIlIllIIIlllIl = MathHelper.sin(lllllllllllllIIIIllIlIllIIIllllI * 3.1415927f);
            final float lllllllllllllIIIIllIlIllIIIlllII = MathHelper.sin(this.swingProgress * 3.1415927f) * -(this.bipedHead.rotateAngleX - 0.7f) * 0.75f;
            lllllllllllllIIIIllIlIllIIIlllll.rotateAngleX -= (float)(lllllllllllllIIIIllIlIllIIIlllIl * 1.2 + lllllllllllllIIIIllIlIllIIIlllII);
            final ModelRenderer modelRenderer = lllllllllllllIIIIllIlIllIIIlllll;
            modelRenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0f;
            final ModelRenderer modelRenderer2 = lllllllllllllIIIIllIlIllIIIlllll;
            modelRenderer2.rotateAngleZ += MathHelper.sin(this.swingProgress * 3.1415927f) * -0.4f;
        }
        if (this.isSneak) {
            this.bipedBody.rotateAngleX = 0.5f;
            final ModelRenderer bipedRightArm3 = this.bipedRightArm;
            bipedRightArm3.rotateAngleX += 0.4f;
            final ModelRenderer bipedLeftArm4 = this.bipedLeftArm;
            bipedLeftArm4.rotateAngleX += 0.4f;
            this.bipedRightLeg.rotationPointZ = 4.0f;
            this.bipedLeftLeg.rotationPointZ = 4.0f;
            this.bipedRightLeg.rotationPointY = 9.0f;
            this.bipedLeftLeg.rotationPointY = 9.0f;
            this.bipedHead.rotationPointY = 1.0f;
        }
        else {
            this.bipedBody.rotateAngleX = 0.0f;
            this.bipedRightLeg.rotationPointZ = 0.1f;
            this.bipedLeftLeg.rotationPointZ = 0.1f;
            this.bipedRightLeg.rotationPointY = 12.0f;
            this.bipedLeftLeg.rotationPointY = 12.0f;
            this.bipedHead.rotationPointY = 0.0f;
        }
        final ModelRenderer bipedRightArm4 = this.bipedRightArm;
        bipedRightArm4.rotateAngleZ += MathHelper.cos(lllllllllllllIIIIllIlIllIIIllIII * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm5 = this.bipedLeftArm;
        bipedLeftArm5.rotateAngleZ -= MathHelper.cos(lllllllllllllIIIIllIlIllIIIllIII * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm5 = this.bipedRightArm;
        bipedRightArm5.rotateAngleX += MathHelper.sin(lllllllllllllIIIIllIlIllIIIllIII * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm6 = this.bipedLeftArm;
        bipedLeftArm6.rotateAngleX -= MathHelper.sin(lllllllllllllIIIIllIlIllIIIllIII * 0.067f) * 0.05f;
        if (this.rightArmPose == ArmPose.BOW_AND_ARROW) {
            this.bipedRightArm.rotateAngleY = -0.1f + this.bipedHead.rotateAngleY;
            this.bipedLeftArm.rotateAngleY = 0.1f + this.bipedHead.rotateAngleY + 0.4f;
            this.bipedRightArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
            this.bipedLeftArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
        }
        else if (this.leftArmPose == ArmPose.BOW_AND_ARROW) {
            this.bipedRightArm.rotateAngleY = -0.1f + this.bipedHead.rotateAngleY - 0.4f;
            this.bipedLeftArm.rotateAngleY = 0.1f + this.bipedHead.rotateAngleY;
            this.bipedRightArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
            this.bipedLeftArm.rotateAngleX = -1.5707964f + this.bipedHead.rotateAngleX;
        }
        ModelBase.copyModelAngles(this.bipedHead, this.bipedHeadwear);
    }
    
    protected EnumHandSide getMainHand(final Entity lllllllllllllIIIIllIlIlIlllIlIll) {
        if (lllllllllllllIIIIllIlIlIlllIlIll instanceof EntityLivingBase) {
            final EntityLivingBase lllllllllllllIIIIllIlIlIlllIlIlI = (EntityLivingBase)lllllllllllllIIIIllIlIlIlllIlIll;
            final EnumHandSide lllllllllllllIIIIllIlIlIlllIlIIl = lllllllllllllIIIIllIlIlIlllIlIlI.getPrimaryHand();
            return (lllllllllllllIIIIllIlIlIlllIlIlI.swingingHand == EnumHand.MAIN_HAND) ? lllllllllllllIIIIllIlIlIlllIlIIl : lllllllllllllIIIIllIlIlIlllIlIIl.opposite();
        }
        return EnumHandSide.RIGHT;
    }
    
    @Override
    public void setModelAttributes(final ModelBase lllllllllllllIIIIllIlIllIIIIlIIl) {
        super.setModelAttributes(lllllllllllllIIIIllIlIllIIIIlIIl);
        if (lllllllllllllIIIIllIlIllIIIIlIIl instanceof ModelBiped) {
            final ModelBiped lllllllllllllIIIIllIlIllIIIIlIII = (ModelBiped)lllllllllllllIIIIllIlIllIIIIlIIl;
            this.leftArmPose = lllllllllllllIIIIllIlIllIIIIlIII.leftArmPose;
            this.rightArmPose = lllllllllllllIIIIllIlIllIIIIlIII.rightArmPose;
            this.isSneak = lllllllllllllIIIIllIlIllIIIIlIII.isSneak;
        }
    }
    
    @Override
    public void render(final Entity lllllllllllllIIIIllIlIllIlIIlIIl, final float lllllllllllllIIIIllIlIllIIllllll, final float lllllllllllllIIIIllIlIllIIlllllI, final float lllllllllllllIIIIllIlIllIlIIIllI, final float lllllllllllllIIIIllIlIllIlIIIlIl, final float lllllllllllllIIIIllIlIllIlIIIlII, final float lllllllllllllIIIIllIlIllIIlllIlI) {
        this.setRotationAngles(lllllllllllllIIIIllIlIllIIllllll, lllllllllllllIIIIllIlIllIIlllllI, lllllllllllllIIIIllIlIllIlIIIllI, lllllllllllllIIIIllIlIllIlIIIlIl, lllllllllllllIIIIllIlIllIlIIIlII, lllllllllllllIIIIllIlIllIIlllIlI, lllllllllllllIIIIllIlIllIlIIlIIl);
        GlStateManager.pushMatrix();
        if (this.isChild) {
            final float lllllllllllllIIIIllIlIllIlIIIIlI = 2.0f;
            GlStateManager.scale(0.75f, 0.75f, 0.75f);
            GlStateManager.translate(0.0f, 16.0f * lllllllllllllIIIIllIlIllIIlllIlI, 0.0f);
            this.bipedHead.render(lllllllllllllIIIIllIlIllIIlllIlI);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * lllllllllllllIIIIllIlIllIIlllIlI, 0.0f);
            this.bipedBody.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedRightArm.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedLeftArm.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedRightLeg.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedLeftLeg.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedHeadwear.render(lllllllllllllIIIIllIlIllIIlllIlI);
        }
        else {
            if (lllllllllllllIIIIllIlIllIlIIlIIl.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            this.bipedHead.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedBody.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedRightArm.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedLeftArm.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedRightLeg.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedLeftLeg.render(lllllllllllllIIIIllIlIllIIlllIlI);
            this.bipedHeadwear.render(lllllllllllllIIIIllIlIllIIlllIlI);
        }
        GlStateManager.popMatrix();
    }
    
    public ModelBiped() {
        this(0.0f);
    }
    
    public ModelBiped(final float lllllllllllllIIIIllIlIllIlIlIlll, final float lllllllllllllIIIIllIlIllIlIllIll, final int lllllllllllllIIIIllIlIllIlIlIlIl, final int lllllllllllllIIIIllIlIllIlIlIlII) {
        this.leftArmPose = ArmPose.EMPTY;
        this.rightArmPose = ArmPose.EMPTY;
        this.textureWidth = lllllllllllllIIIIllIlIllIlIlIlIl;
        this.textureHeight = lllllllllllllIIIIllIlIllIlIlIlII;
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, lllllllllllllIIIIllIlIllIlIlIlll);
        this.bipedHead.setRotationPoint(0.0f, 0.0f + lllllllllllllIIIIllIlIllIlIllIll, 0.0f);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, lllllllllllllIIIIllIlIllIlIlIlll + 0.5f);
        this.bipedHeadwear.setRotationPoint(0.0f, 0.0f + lllllllllllllIIIIllIlIllIlIllIll, 0.0f);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, lllllllllllllIIIIllIlIllIlIlIlll);
        this.bipedBody.setRotationPoint(0.0f, 0.0f + lllllllllllllIIIIllIlIllIlIllIll, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllllIIIIllIlIllIlIlIlll);
        this.bipedRightArm.setRotationPoint(-5.0f, 2.0f + lllllllllllllIIIIllIlIllIlIllIll, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllllIIIIllIlIllIlIlIlll);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + lllllllllllllIIIIllIlIllIlIllIll, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIIIllIlIllIlIlIlll);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f + lllllllllllllIIIIllIlIllIlIllIll, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIIIllIlIllIlIlIlll);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f + lllllllllllllIIIIllIlIllIlIllIll, 0.0f);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose() {
        final int[] $switch_TABLE$net$minecraft$client$model$ModelBiped$ArmPose = ModelBiped.$SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose;
        if ($switch_TABLE$net$minecraft$client$model$ModelBiped$ArmPose != null) {
            return $switch_TABLE$net$minecraft$client$model$ModelBiped$ArmPose;
        }
        final short lllllllllllllIIIIllIlIlIlllIIlII = (Object)new int[ArmPose.values().length];
        try {
            lllllllllllllIIIIllIlIlIlllIIlII[ArmPose.BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIllIlIlIlllIIlII[ArmPose.BOW_AND_ARROW.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIllIlIlIlllIIlII[ArmPose.EMPTY.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIIllIlIlIlllIIlII[ArmPose.ITEM.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return ModelBiped.$SWITCH_TABLE$net$minecraft$client$model$ModelBiped$ArmPose = (int[])(Object)lllllllllllllIIIIllIlIlIlllIIlII;
    }
    
    public enum ArmPose
    {
        BLOCK("BLOCK", 2), 
        ITEM("ITEM", 1), 
        EMPTY("EMPTY", 0), 
        BOW_AND_ARROW("BOW_AND_ARROW", 3);
        
        private ArmPose(final String llllllllllllllIIIllIlllIlIlIllII, final int llllllllllllllIIIllIlllIlIlIlIll) {
        }
    }
}
