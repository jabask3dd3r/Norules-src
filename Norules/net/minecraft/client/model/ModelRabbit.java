package net.minecraft.client.model;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.math.*;

public class ModelRabbit extends ModelBase
{
    private final /* synthetic */ ModelRenderer rabbitRightThigh;
    private final /* synthetic */ ModelRenderer rabbitRightEar;
    private final /* synthetic */ ModelRenderer rabbitHead;
    private final /* synthetic */ ModelRenderer rabbitTail;
    private final /* synthetic */ ModelRenderer rabbitLeftThigh;
    private /* synthetic */ float jumpRotation;
    private final /* synthetic */ ModelRenderer rabbitLeftFoot;
    private final /* synthetic */ ModelRenderer rabbitRightFoot;
    private final /* synthetic */ ModelRenderer rabbitBody;
    private final /* synthetic */ ModelRenderer rabbitNose;
    private final /* synthetic */ ModelRenderer rabbitRightArm;
    private final /* synthetic */ ModelRenderer rabbitLeftEar;
    private final /* synthetic */ ModelRenderer rabbitLeftArm;
    
    public ModelRabbit() {
        this.setTextureOffset("head.main", 0, 0);
        this.setTextureOffset("head.nose", 0, 24);
        this.setTextureOffset("head.ear1", 0, 10);
        this.setTextureOffset("head.ear2", 6, 10);
        this.rabbitLeftFoot = new ModelRenderer(this, 26, 24);
        this.rabbitLeftFoot.addBox(-1.0f, 5.5f, -3.7f, 2, 1, 7);
        this.rabbitLeftFoot.setRotationPoint(3.0f, 17.5f, 3.7f);
        this.rabbitLeftFoot.mirror = true;
        this.setRotationOffset(this.rabbitLeftFoot, 0.0f, 0.0f, 0.0f);
        this.rabbitRightFoot = new ModelRenderer(this, 8, 24);
        this.rabbitRightFoot.addBox(-1.0f, 5.5f, -3.7f, 2, 1, 7);
        this.rabbitRightFoot.setRotationPoint(-3.0f, 17.5f, 3.7f);
        this.rabbitRightFoot.mirror = true;
        this.setRotationOffset(this.rabbitRightFoot, 0.0f, 0.0f, 0.0f);
        this.rabbitLeftThigh = new ModelRenderer(this, 30, 15);
        this.rabbitLeftThigh.addBox(-1.0f, 0.0f, 0.0f, 2, 4, 5);
        this.rabbitLeftThigh.setRotationPoint(3.0f, 17.5f, 3.7f);
        this.rabbitLeftThigh.mirror = true;
        this.setRotationOffset(this.rabbitLeftThigh, -0.34906584f, 0.0f, 0.0f);
        this.rabbitRightThigh = new ModelRenderer(this, 16, 15);
        this.rabbitRightThigh.addBox(-1.0f, 0.0f, 0.0f, 2, 4, 5);
        this.rabbitRightThigh.setRotationPoint(-3.0f, 17.5f, 3.7f);
        this.rabbitRightThigh.mirror = true;
        this.setRotationOffset(this.rabbitRightThigh, -0.34906584f, 0.0f, 0.0f);
        this.rabbitBody = new ModelRenderer(this, 0, 0);
        this.rabbitBody.addBox(-3.0f, -2.0f, -10.0f, 6, 5, 10);
        this.rabbitBody.setRotationPoint(0.0f, 19.0f, 8.0f);
        this.rabbitBody.mirror = true;
        this.setRotationOffset(this.rabbitBody, -0.34906584f, 0.0f, 0.0f);
        this.rabbitLeftArm = new ModelRenderer(this, 8, 15);
        this.rabbitLeftArm.addBox(-1.0f, 0.0f, -1.0f, 2, 7, 2);
        this.rabbitLeftArm.setRotationPoint(3.0f, 17.0f, -1.0f);
        this.rabbitLeftArm.mirror = true;
        this.setRotationOffset(this.rabbitLeftArm, -0.17453292f, 0.0f, 0.0f);
        this.rabbitRightArm = new ModelRenderer(this, 0, 15);
        this.rabbitRightArm.addBox(-1.0f, 0.0f, -1.0f, 2, 7, 2);
        this.rabbitRightArm.setRotationPoint(-3.0f, 17.0f, -1.0f);
        this.rabbitRightArm.mirror = true;
        this.setRotationOffset(this.rabbitRightArm, -0.17453292f, 0.0f, 0.0f);
        this.rabbitHead = new ModelRenderer(this, 32, 0);
        this.rabbitHead.addBox(-2.5f, -4.0f, -5.0f, 5, 4, 5);
        this.rabbitHead.setRotationPoint(0.0f, 16.0f, -1.0f);
        this.rabbitHead.mirror = true;
        this.setRotationOffset(this.rabbitHead, 0.0f, 0.0f, 0.0f);
        this.rabbitRightEar = new ModelRenderer(this, 52, 0);
        this.rabbitRightEar.addBox(-2.5f, -9.0f, -1.0f, 2, 5, 1);
        this.rabbitRightEar.setRotationPoint(0.0f, 16.0f, -1.0f);
        this.rabbitRightEar.mirror = true;
        this.setRotationOffset(this.rabbitRightEar, 0.0f, -0.2617994f, 0.0f);
        this.rabbitLeftEar = new ModelRenderer(this, 58, 0);
        this.rabbitLeftEar.addBox(0.5f, -9.0f, -1.0f, 2, 5, 1);
        this.rabbitLeftEar.setRotationPoint(0.0f, 16.0f, -1.0f);
        this.rabbitLeftEar.mirror = true;
        this.setRotationOffset(this.rabbitLeftEar, 0.0f, 0.2617994f, 0.0f);
        this.rabbitTail = new ModelRenderer(this, 52, 6);
        this.rabbitTail.addBox(-1.5f, -1.5f, 0.0f, 3, 3, 2);
        this.rabbitTail.setRotationPoint(0.0f, 20.0f, 7.0f);
        this.rabbitTail.mirror = true;
        this.setRotationOffset(this.rabbitTail, -0.3490659f, 0.0f, 0.0f);
        this.rabbitNose = new ModelRenderer(this, 32, 9);
        this.rabbitNose.addBox(-0.5f, -2.5f, -5.5f, 1, 1, 1);
        this.rabbitNose.setRotationPoint(0.0f, 16.0f, -1.0f);
        this.rabbitNose.mirror = true;
        this.setRotationOffset(this.rabbitNose, 0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllllIlIIIlIlIIIlIIlIllI, final float lllllllllllllIlIIIlIlIIIlIIlIlIl, final float lllllllllllllIlIIIlIlIIIlIIlllIl, final float lllllllllllllIlIIIlIlIIIlIIlIIll, final float lllllllllllllIlIIIlIlIIIlIIlIIlI, final float lllllllllllllIlIIIlIlIIIlIIlIIIl, final float lllllllllllllIlIIIlIlIIIlIIlIIII) {
        this.setRotationAngles(lllllllllllllIlIIIlIlIIIlIIlIlIl, lllllllllllllIlIIIlIlIIIlIIlllIl, lllllllllllllIlIIIlIlIIIlIIlIIll, lllllllllllllIlIIIlIlIIIlIIlIIlI, lllllllllllllIlIIIlIlIIIlIIlIIIl, lllllllllllllIlIIIlIlIIIlIIlIIII, lllllllllllllIlIIIlIlIIIlIIlIllI);
        if (this.isChild) {
            final float lllllllllllllIlIIIlIlIIIlIIllIII = 1.5f;
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.56666666f, 0.56666666f, 0.56666666f);
            GlStateManager.translate(0.0f, 22.0f * lllllllllllllIlIIIlIlIIIlIIlIIII, 2.0f * lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitHead.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitLeftEar.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitRightEar.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitNose.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.4f, 0.4f, 0.4f);
            GlStateManager.translate(0.0f, 36.0f * lllllllllllllIlIIIlIlIIIlIIlIIII, 0.0f);
            this.rabbitLeftFoot.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitRightFoot.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitLeftThigh.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitRightThigh.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitBody.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitLeftArm.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitRightArm.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitTail.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            GlStateManager.popMatrix();
        }
        else {
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.6f, 0.6f, 0.6f);
            GlStateManager.translate(0.0f, 16.0f * lllllllllllllIlIIIlIlIIIlIIlIIII, 0.0f);
            this.rabbitLeftFoot.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitRightFoot.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitLeftThigh.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitRightThigh.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitBody.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitLeftArm.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitRightArm.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitHead.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitRightEar.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitLeftEar.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitTail.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            this.rabbitNose.render(lllllllllllllIlIIIlIlIIIlIIlIIII);
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllIlIIIlIlIIIIlllIIII, final float lllllllllllllIlIIIlIlIIIIllIlIlI, final float lllllllllllllIlIIIlIlIIIIllIlIIl, final float lllllllllllllIlIIIlIlIIIIllIlIII) {
        super.setLivingAnimations(lllllllllllllIlIIIlIlIIIIlllIIII, lllllllllllllIlIIIlIlIIIIllIlIlI, lllllllllllllIlIIIlIlIIIIllIlIIl, lllllllllllllIlIIIlIlIIIIllIlIII);
        this.jumpRotation = MathHelper.sin(((EntityRabbit)lllllllllllllIlIIIlIlIIIIlllIIII).setJumpCompletion(lllllllllllllIlIIIlIlIIIIllIlIII) * 3.1415927f);
    }
    
    private void setRotationOffset(final ModelRenderer lllllllllllllIlIIIlIlIIIlIllIIIl, final float lllllllllllllIlIIIlIlIIIlIlIllII, final float lllllllllllllIlIIIlIlIIIlIlIllll, final float lllllllllllllIlIIIlIlIIIlIlIlIlI) {
        lllllllllllllIlIIIlIlIIIlIllIIIl.rotateAngleX = lllllllllllllIlIIIlIlIIIlIlIllII;
        lllllllllllllIlIIIlIlIIIlIllIIIl.rotateAngleY = lllllllllllllIlIIIlIlIIIlIlIllll;
        lllllllllllllIlIIIlIlIIIlIllIIIl.rotateAngleZ = lllllllllllllIlIIIlIlIIIlIlIlIlI;
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlIIIlIlIIIlIIIIllI, final float lllllllllllllIlIIIlIlIIIlIIIIlIl, final float lllllllllllllIlIIIlIlIIIIlllllII, final float lllllllllllllIlIIIlIlIIIIllllIll, final float lllllllllllllIlIIIlIlIIIlIIIIIlI, final float lllllllllllllIlIIIlIlIIIlIIIIIIl, final Entity lllllllllllllIlIIIlIlIIIIllllIIl) {
        final float lllllllllllllIlIIIlIlIIIIlllllll = lllllllllllllIlIIIlIlIIIIlllllII - lllllllllllllIlIIIlIlIIIIllllIIl.ticksExisted;
        final EntityRabbit lllllllllllllIlIIIlIlIIIIllllllI = (EntityRabbit)lllllllllllllIlIIIlIlIIIIllllIIl;
        this.rabbitNose.rotateAngleX = lllllllllllllIlIIIlIlIIIlIIIIIlI * 0.017453292f;
        this.rabbitHead.rotateAngleX = lllllllllllllIlIIIlIlIIIlIIIIIlI * 0.017453292f;
        this.rabbitRightEar.rotateAngleX = lllllllllllllIlIIIlIlIIIlIIIIIlI * 0.017453292f;
        this.rabbitLeftEar.rotateAngleX = lllllllllllllIlIIIlIlIIIlIIIIIlI * 0.017453292f;
        this.rabbitNose.rotateAngleY = lllllllllllllIlIIIlIlIIIIllllIll * 0.017453292f;
        this.rabbitHead.rotateAngleY = lllllllllllllIlIIIlIlIIIIllllIll * 0.017453292f;
        this.rabbitRightEar.rotateAngleY = this.rabbitNose.rotateAngleY - 0.2617994f;
        this.rabbitLeftEar.rotateAngleY = this.rabbitNose.rotateAngleY + 0.2617994f;
        this.jumpRotation = MathHelper.sin(lllllllllllllIlIIIlIlIIIIllllllI.setJumpCompletion(lllllllllllllIlIIIlIlIIIIlllllll) * 3.1415927f);
        this.rabbitLeftThigh.rotateAngleX = (this.jumpRotation * 50.0f - 21.0f) * 0.017453292f;
        this.rabbitRightThigh.rotateAngleX = (this.jumpRotation * 50.0f - 21.0f) * 0.017453292f;
        this.rabbitLeftFoot.rotateAngleX = this.jumpRotation * 50.0f * 0.017453292f;
        this.rabbitRightFoot.rotateAngleX = this.jumpRotation * 50.0f * 0.017453292f;
        this.rabbitLeftArm.rotateAngleX = (this.jumpRotation * -40.0f - 11.0f) * 0.017453292f;
        this.rabbitRightArm.rotateAngleX = (this.jumpRotation * -40.0f - 11.0f) * 0.017453292f;
    }
}
