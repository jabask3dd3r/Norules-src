package net.minecraft.client.model;

import net.minecraft.entity.passive.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelHorse extends ModelBase
{
    private final /* synthetic */ ModelRenderer tailTip;
    private final /* synthetic */ ModelRenderer frontRightLeg;
    private final /* synthetic */ ModelRenderer horseSaddleBottom;
    private final /* synthetic */ ModelRenderer horseLeftFaceMetal;
    private final /* synthetic */ ModelRenderer horseLeftRein;
    private final /* synthetic */ ModelRenderer horseRightSaddleRope;
    private final /* synthetic */ ModelRenderer horseLeftEar;
    private final /* synthetic */ ModelRenderer backLeftShin;
    private final /* synthetic */ ModelRenderer frontLeftShin;
    private final /* synthetic */ ModelRenderer backRightShin;
    private final /* synthetic */ ModelRenderer frontLeftHoof;
    private final /* synthetic */ ModelRenderer horseFaceRopes;
    private final /* synthetic */ ModelRenderer muleRightEar;
    private final /* synthetic */ ModelRenderer horseRightRein;
    private final /* synthetic */ ModelRenderer horseLeftSaddleMetal;
    private final /* synthetic */ ModelRenderer backRightHoof;
    private final /* synthetic */ ModelRenderer body;
    private final /* synthetic */ ModelRenderer horseLeftSaddleRope;
    private final /* synthetic */ ModelRenderer mane;
    private final /* synthetic */ ModelRenderer muleLeftChest;
    private final /* synthetic */ ModelRenderer backLeftLeg;
    private final /* synthetic */ ModelRenderer tailMiddle;
    private final /* synthetic */ ModelRenderer tailBase;
    private final /* synthetic */ ModelRenderer horseRightSaddleMetal;
    private final /* synthetic */ ModelRenderer backLeftHoof;
    private final /* synthetic */ ModelRenderer horseSaddleBack;
    private final /* synthetic */ ModelRenderer muleRightChest;
    private final /* synthetic */ ModelRenderer horseRightEar;
    private final /* synthetic */ ModelRenderer frontLeftLeg;
    private final /* synthetic */ ModelRenderer muleLeftEar;
    private final /* synthetic */ ModelRenderer upperMouth;
    private final /* synthetic */ ModelRenderer frontRightHoof;
    private final /* synthetic */ ModelRenderer frontRightShin;
    private final /* synthetic */ ModelRenderer horseRightFaceMetal;
    private final /* synthetic */ ModelRenderer backRightLeg;
    private final /* synthetic */ ModelRenderer horseSaddleFront;
    private final /* synthetic */ ModelRenderer lowerMouth;
    private final /* synthetic */ ModelRenderer head;
    private final /* synthetic */ ModelRenderer neck;
    
    @Override
    public void render(final Entity llllllllllllllIIIIlllllIlIIlIIIl, final float llllllllllllllIIIIlllllIlIlIIIlI, final float llllllllllllllIIIIlllllIlIlIIIIl, final float llllllllllllllIIIIlllllIlIlIIIII, final float llllllllllllllIIIIlllllIlIIlllll, final float llllllllllllllIIIIlllllIlIIllllI, final float llllllllllllllIIIIlllllIlIIlllIl) {
        final AbstractHorse llllllllllllllIIIIlllllIlIIlllII = (AbstractHorse)llllllllllllllIIIIlllllIlIIlIIIl;
        final float llllllllllllllIIIIlllllIlIIllIll = llllllllllllllIIIIlllllIlIIlllII.getGrassEatingAmount(0.0f);
        final boolean llllllllllllllIIIIlllllIlIIllIlI = llllllllllllllIIIIlllllIlIIlllII.isChild();
        final boolean llllllllllllllIIIIlllllIlIIllIIl = !llllllllllllllIIIIlllllIlIIllIlI && llllllllllllllIIIIlllllIlIIlllII.isHorseSaddled();
        final boolean llllllllllllllIIIIlllllIlIIllIII = llllllllllllllIIIIlllllIlIIlllII instanceof AbstractChestHorse;
        final boolean llllllllllllllIIIIlllllIlIIlIlll = !llllllllllllllIIIIlllllIlIIllIlI && llllllllllllllIIIIlllllIlIIllIII && ((AbstractChestHorse)llllllllllllllIIIIlllllIlIIlllII).func_190695_dh();
        final float llllllllllllllIIIIlllllIlIIlIllI = llllllllllllllIIIIlllllIlIIlllII.getHorseSize();
        final boolean llllllllllllllIIIIlllllIlIIlIlIl = llllllllllllllIIIIlllllIlIIlllII.isBeingRidden();
        if (llllllllllllllIIIIlllllIlIIllIIl) {
            this.horseFaceRopes.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseSaddleBottom.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseSaddleFront.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseSaddleBack.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseLeftSaddleRope.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseLeftSaddleMetal.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseRightSaddleRope.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseRightSaddleMetal.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseLeftFaceMetal.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseRightFaceMetal.render(llllllllllllllIIIIlllllIlIIlllIl);
            if (llllllllllllllIIIIlllllIlIIlIlIl) {
                this.horseLeftRein.render(llllllllllllllIIIIlllllIlIIlllIl);
                this.horseRightRein.render(llllllllllllllIIIIlllllIlIIlllIl);
            }
        }
        if (llllllllllllllIIIIlllllIlIIllIlI) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(llllllllllllllIIIIlllllIlIIlIllI, 0.5f + llllllllllllllIIIIlllllIlIIlIllI * 0.5f, llllllllllllllIIIIlllllIlIIlIllI);
            GlStateManager.translate(0.0f, 0.95f * (1.0f - llllllllllllllIIIIlllllIlIIlIllI), 0.0f);
        }
        this.backLeftLeg.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.backLeftShin.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.backLeftHoof.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.backRightLeg.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.backRightShin.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.backRightHoof.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.frontLeftLeg.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.frontLeftShin.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.frontLeftHoof.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.frontRightLeg.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.frontRightShin.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.frontRightHoof.render(llllllllllllllIIIIlllllIlIIlllIl);
        if (llllllllllllllIIIIlllllIlIIllIlI) {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(llllllllllllllIIIIlllllIlIIlIllI, llllllllllllllIIIIlllllIlIIlIllI, llllllllllllllIIIIlllllIlIIlIllI);
            GlStateManager.translate(0.0f, 1.35f * (1.0f - llllllllllllllIIIIlllllIlIIlIllI), 0.0f);
        }
        this.body.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.tailBase.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.tailMiddle.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.tailTip.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.neck.render(llllllllllllllIIIIlllllIlIIlllIl);
        this.mane.render(llllllllllllllIIIIlllllIlIIlllIl);
        if (llllllllllllllIIIIlllllIlIIllIlI) {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            final float llllllllllllllIIIIlllllIlIIlIlII = 0.5f + llllllllllllllIIIIlllllIlIIlIllI * llllllllllllllIIIIlllllIlIIlIllI * 0.5f;
            GlStateManager.scale(llllllllllllllIIIIlllllIlIIlIlII, llllllllllllllIIIIlllllIlIIlIlII, llllllllllllllIIIIlllllIlIIlIlII);
            if (llllllllllllllIIIIlllllIlIIllIll <= 0.0f) {
                GlStateManager.translate(0.0f, 1.35f * (1.0f - llllllllllllllIIIIlllllIlIIlIllI), 0.0f);
            }
            else {
                GlStateManager.translate(0.0f, 0.9f * (1.0f - llllllllllllllIIIIlllllIlIIlIllI) * llllllllllllllIIIIlllllIlIIllIll + 1.35f * (1.0f - llllllllllllllIIIIlllllIlIIlIllI) * (1.0f - llllllllllllllIIIIlllllIlIIllIll), 0.15f * (1.0f - llllllllllllllIIIIlllllIlIIlIllI) * llllllllllllllIIIIlllllIlIIllIll);
            }
        }
        if (llllllllllllllIIIIlllllIlIIllIII) {
            this.muleLeftEar.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.muleRightEar.render(llllllllllllllIIIIlllllIlIIlllIl);
        }
        else {
            this.horseLeftEar.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.horseRightEar.render(llllllllllllllIIIIlllllIlIIlllIl);
        }
        this.head.render(llllllllllllllIIIIlllllIlIIlllIl);
        if (llllllllllllllIIIIlllllIlIIllIlI) {
            GlStateManager.popMatrix();
        }
        if (llllllllllllllIIIIlllllIlIIlIlll) {
            this.muleLeftChest.render(llllllllllllllIIIIlllllIlIIlllIl);
            this.muleRightChest.render(llllllllllllllIIIIlllllIlIIlllIl);
        }
    }
    
    private float updateHorseRotation(final float llllllllllllllIIIIlllllIIllllllI, final float llllllllllllllIIIIlllllIIlllllIl, final float llllllllllllllIIIIlllllIIlllllII) {
        float llllllllllllllIIIIlllllIIlllllll;
        for (llllllllllllllIIIIlllllIIlllllll = llllllllllllllIIIIlllllIIlllllIl - llllllllllllllIIIIlllllIIllllllI; llllllllllllllIIIIlllllIIlllllll < -180.0f; llllllllllllllIIIIlllllIIlllllll += 360.0f) {}
        while (llllllllllllllIIIIlllllIIlllllll >= 180.0f) {
            llllllllllllllIIIIlllllIIlllllll -= 360.0f;
        }
        return llllllllllllllIIIIlllllIIllllllI + llllllllllllllIIIIlllllIIlllllII * llllllllllllllIIIIlllllIIlllllll;
    }
    
    public ModelHorse() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelRenderer(this, 0, 34);
        this.body.addBox(-5.0f, -8.0f, -19.0f, 10, 10, 24);
        this.body.setRotationPoint(0.0f, 11.0f, 9.0f);
        this.tailBase = new ModelRenderer(this, 44, 0);
        this.tailBase.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 3);
        this.tailBase.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.tailBase.rotateAngleX = -1.134464f;
        this.tailMiddle = new ModelRenderer(this, 38, 7);
        this.tailMiddle.addBox(-1.5f, -2.0f, 3.0f, 3, 4, 7);
        this.tailMiddle.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.tailMiddle.rotateAngleX = -1.134464f;
        this.tailTip = new ModelRenderer(this, 24, 3);
        this.tailTip.addBox(-1.5f, -4.5f, 9.0f, 3, 4, 7);
        this.tailTip.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.tailTip.rotateAngleX = -1.3962634f;
        this.backLeftLeg = new ModelRenderer(this, 78, 29);
        this.backLeftLeg.addBox(-2.5f, -2.0f, -2.5f, 4, 9, 5);
        this.backLeftLeg.setRotationPoint(4.0f, 9.0f, 11.0f);
        this.backLeftShin = new ModelRenderer(this, 78, 43);
        this.backLeftShin.addBox(-2.0f, 0.0f, -1.5f, 3, 5, 3);
        this.backLeftShin.setRotationPoint(4.0f, 16.0f, 11.0f);
        this.backLeftHoof = new ModelRenderer(this, 78, 51);
        this.backLeftHoof.addBox(-2.5f, 5.1f, -2.0f, 4, 3, 4);
        this.backLeftHoof.setRotationPoint(4.0f, 16.0f, 11.0f);
        this.backRightLeg = new ModelRenderer(this, 96, 29);
        this.backRightLeg.addBox(-1.5f, -2.0f, -2.5f, 4, 9, 5);
        this.backRightLeg.setRotationPoint(-4.0f, 9.0f, 11.0f);
        this.backRightShin = new ModelRenderer(this, 96, 43);
        this.backRightShin.addBox(-1.0f, 0.0f, -1.5f, 3, 5, 3);
        this.backRightShin.setRotationPoint(-4.0f, 16.0f, 11.0f);
        this.backRightHoof = new ModelRenderer(this, 96, 51);
        this.backRightHoof.addBox(-1.5f, 5.1f, -2.0f, 4, 3, 4);
        this.backRightHoof.setRotationPoint(-4.0f, 16.0f, 11.0f);
        this.frontLeftLeg = new ModelRenderer(this, 44, 29);
        this.frontLeftLeg.addBox(-1.9f, -1.0f, -2.1f, 3, 8, 4);
        this.frontLeftLeg.setRotationPoint(4.0f, 9.0f, -8.0f);
        this.frontLeftShin = new ModelRenderer(this, 44, 41);
        this.frontLeftShin.addBox(-1.9f, 0.0f, -1.6f, 3, 5, 3);
        this.frontLeftShin.setRotationPoint(4.0f, 16.0f, -8.0f);
        this.frontLeftHoof = new ModelRenderer(this, 44, 51);
        this.frontLeftHoof.addBox(-2.4f, 5.1f, -2.1f, 4, 3, 4);
        this.frontLeftHoof.setRotationPoint(4.0f, 16.0f, -8.0f);
        this.frontRightLeg = new ModelRenderer(this, 60, 29);
        this.frontRightLeg.addBox(-1.1f, -1.0f, -2.1f, 3, 8, 4);
        this.frontRightLeg.setRotationPoint(-4.0f, 9.0f, -8.0f);
        this.frontRightShin = new ModelRenderer(this, 60, 41);
        this.frontRightShin.addBox(-1.1f, 0.0f, -1.6f, 3, 5, 3);
        this.frontRightShin.setRotationPoint(-4.0f, 16.0f, -8.0f);
        this.frontRightHoof = new ModelRenderer(this, 60, 51);
        this.frontRightHoof.addBox(-1.6f, 5.1f, -2.1f, 4, 3, 4);
        this.frontRightHoof.setRotationPoint(-4.0f, 16.0f, -8.0f);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.5f, -10.0f, -1.5f, 5, 5, 7);
        this.head.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.head.rotateAngleX = 0.5235988f;
        this.upperMouth = new ModelRenderer(this, 24, 18);
        this.upperMouth.addBox(-2.0f, -10.0f, -7.0f, 4, 3, 6);
        this.upperMouth.setRotationPoint(0.0f, 3.95f, -10.0f);
        this.upperMouth.rotateAngleX = 0.5235988f;
        this.lowerMouth = new ModelRenderer(this, 24, 27);
        this.lowerMouth.addBox(-2.0f, -7.0f, -6.5f, 4, 2, 5);
        this.lowerMouth.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.lowerMouth.rotateAngleX = 0.5235988f;
        this.head.addChild(this.upperMouth);
        this.head.addChild(this.lowerMouth);
        this.horseLeftEar = new ModelRenderer(this, 0, 0);
        this.horseLeftEar.addBox(0.45f, -12.0f, 4.0f, 2, 3, 1);
        this.horseLeftEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseLeftEar.rotateAngleX = 0.5235988f;
        this.horseRightEar = new ModelRenderer(this, 0, 0);
        this.horseRightEar.addBox(-2.45f, -12.0f, 4.0f, 2, 3, 1);
        this.horseRightEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseRightEar.rotateAngleX = 0.5235988f;
        this.muleLeftEar = new ModelRenderer(this, 0, 12);
        this.muleLeftEar.addBox(-2.0f, -16.0f, 4.0f, 2, 7, 1);
        this.muleLeftEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.muleLeftEar.rotateAngleX = 0.5235988f;
        this.muleLeftEar.rotateAngleZ = 0.2617994f;
        this.muleRightEar = new ModelRenderer(this, 0, 12);
        this.muleRightEar.addBox(0.0f, -16.0f, 4.0f, 2, 7, 1);
        this.muleRightEar.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.muleRightEar.rotateAngleX = 0.5235988f;
        this.muleRightEar.rotateAngleZ = -0.2617994f;
        this.neck = new ModelRenderer(this, 0, 12);
        this.neck.addBox(-2.05f, -9.8f, -2.0f, 4, 14, 8);
        this.neck.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.neck.rotateAngleX = 0.5235988f;
        this.muleLeftChest = new ModelRenderer(this, 0, 34);
        this.muleLeftChest.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.muleLeftChest.setRotationPoint(-7.5f, 3.0f, 10.0f);
        this.muleLeftChest.rotateAngleY = 1.5707964f;
        this.muleRightChest = new ModelRenderer(this, 0, 47);
        this.muleRightChest.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3);
        this.muleRightChest.setRotationPoint(4.5f, 3.0f, 10.0f);
        this.muleRightChest.rotateAngleY = 1.5707964f;
        this.horseSaddleBottom = new ModelRenderer(this, 80, 0);
        this.horseSaddleBottom.addBox(-5.0f, 0.0f, -3.0f, 10, 1, 8);
        this.horseSaddleBottom.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.horseSaddleFront = new ModelRenderer(this, 106, 9);
        this.horseSaddleFront.addBox(-1.5f, -1.0f, -3.0f, 3, 1, 2);
        this.horseSaddleFront.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.horseSaddleBack = new ModelRenderer(this, 80, 9);
        this.horseSaddleBack.addBox(-4.0f, -1.0f, 3.0f, 8, 1, 2);
        this.horseSaddleBack.setRotationPoint(0.0f, 2.0f, 2.0f);
        this.horseLeftSaddleMetal = new ModelRenderer(this, 74, 0);
        this.horseLeftSaddleMetal.addBox(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.horseLeftSaddleMetal.setRotationPoint(5.0f, 3.0f, 2.0f);
        this.horseLeftSaddleRope = new ModelRenderer(this, 70, 0);
        this.horseLeftSaddleRope.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.horseLeftSaddleRope.setRotationPoint(5.0f, 3.0f, 2.0f);
        this.horseRightSaddleMetal = new ModelRenderer(this, 74, 4);
        this.horseRightSaddleMetal.addBox(-0.5f, 6.0f, -1.0f, 1, 2, 2);
        this.horseRightSaddleMetal.setRotationPoint(-5.0f, 3.0f, 2.0f);
        this.horseRightSaddleRope = new ModelRenderer(this, 80, 0);
        this.horseRightSaddleRope.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1);
        this.horseRightSaddleRope.setRotationPoint(-5.0f, 3.0f, 2.0f);
        this.horseLeftFaceMetal = new ModelRenderer(this, 74, 13);
        this.horseLeftFaceMetal.addBox(1.5f, -8.0f, -4.0f, 1, 2, 2);
        this.horseLeftFaceMetal.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseLeftFaceMetal.rotateAngleX = 0.5235988f;
        this.horseRightFaceMetal = new ModelRenderer(this, 74, 13);
        this.horseRightFaceMetal.addBox(-2.5f, -8.0f, -4.0f, 1, 2, 2);
        this.horseRightFaceMetal.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseRightFaceMetal.rotateAngleX = 0.5235988f;
        this.horseLeftRein = new ModelRenderer(this, 44, 10);
        this.horseLeftRein.addBox(2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.horseLeftRein.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseRightRein = new ModelRenderer(this, 44, 5);
        this.horseRightRein.addBox(-2.6f, -6.0f, -6.0f, 0, 3, 16);
        this.horseRightRein.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.mane = new ModelRenderer(this, 58, 0);
        this.mane.addBox(-1.0f, -11.5f, 5.0f, 2, 16, 4);
        this.mane.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.mane.rotateAngleX = 0.5235988f;
        this.horseFaceRopes = new ModelRenderer(this, 80, 12);
        this.horseFaceRopes.addBox(-2.5f, -10.1f, -7.0f, 5, 5, 12, 0.2f);
        this.horseFaceRopes.setRotationPoint(0.0f, 4.0f, -10.0f);
        this.horseFaceRopes.rotateAngleX = 0.5235988f;
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIIIIlllllIIllIIIII, final float llllllllllllllIIIIlllllIIlIIIllI, final float llllllllllllllIIIIlllllIIlIIIlIl, final float llllllllllllllIIIIlllllIIlIIIlII) {
        super.setLivingAnimations(llllllllllllllIIIIlllllIIllIIIII, llllllllllllllIIIIlllllIIlIIIllI, llllllllllllllIIIIlllllIIlIIIlIl, llllllllllllllIIIIlllllIIlIIIlII);
        final float llllllllllllllIIIIlllllIIlIlllII = this.updateHorseRotation(llllllllllllllIIIIlllllIIllIIIII.prevRenderYawOffset, llllllllllllllIIIIlllllIIllIIIII.renderYawOffset, llllllllllllllIIIIlllllIIlIIIlII);
        final float llllllllllllllIIIIlllllIIlIllIll = this.updateHorseRotation(llllllllllllllIIIIlllllIIllIIIII.prevRotationYawHead, llllllllllllllIIIIlllllIIllIIIII.rotationYawHead, llllllllllllllIIIIlllllIIlIIIlII);
        final float llllllllllllllIIIIlllllIIlIllIlI = llllllllllllllIIIIlllllIIllIIIII.prevRotationPitch + (llllllllllllllIIIIlllllIIllIIIII.rotationPitch - llllllllllllllIIIIlllllIIllIIIII.prevRotationPitch) * llllllllllllllIIIIlllllIIlIIIlII;
        float llllllllllllllIIIIlllllIIlIllIIl = llllllllllllllIIIIlllllIIlIllIll - llllllllllllllIIIIlllllIIlIlllII;
        float llllllllllllllIIIIlllllIIlIllIII = llllllllllllllIIIIlllllIIlIllIlI * 0.017453292f;
        if (llllllllllllllIIIIlllllIIlIllIIl > 20.0f) {
            llllllllllllllIIIIlllllIIlIllIIl = 20.0f;
        }
        if (llllllllllllllIIIIlllllIIlIllIIl < -20.0f) {
            llllllllllllllIIIIlllllIIlIllIIl = -20.0f;
        }
        if (llllllllllllllIIIIlllllIIlIIIlIl > 0.2f) {
            llllllllllllllIIIIlllllIIlIllIII += MathHelper.cos(llllllllllllllIIIIlllllIIlIIIllI * 0.4f) * 0.15f * llllllllllllllIIIIlllllIIlIIIlIl;
        }
        final AbstractHorse llllllllllllllIIIIlllllIIlIlIlll = (AbstractHorse)llllllllllllllIIIIlllllIIllIIIII;
        final float llllllllllllllIIIIlllllIIlIlIllI = llllllllllllllIIIIlllllIIlIlIlll.getGrassEatingAmount(llllllllllllllIIIIlllllIIlIIIlII);
        final float llllllllllllllIIIIlllllIIlIlIlIl = llllllllllllllIIIIlllllIIlIlIlll.getRearingAmount(llllllllllllllIIIIlllllIIlIIIlII);
        final float llllllllllllllIIIIlllllIIlIlIlII = 1.0f - llllllllllllllIIIIlllllIIlIlIlIl;
        final float llllllllllllllIIIIlllllIIlIlIIll = llllllllllllllIIIIlllllIIlIlIlll.getMouthOpennessAngle(llllllllllllllIIIIlllllIIlIIIlII);
        final boolean llllllllllllllIIIIlllllIIlIlIIlI = llllllllllllllIIIIlllllIIlIlIlll.tailCounter != 0;
        final boolean llllllllllllllIIIIlllllIIlIlIIIl = llllllllllllllIIIIlllllIIlIlIlll.isHorseSaddled();
        final boolean llllllllllllllIIIIlllllIIlIlIIII = llllllllllllllIIIIlllllIIlIlIlll.isBeingRidden();
        final float llllllllllllllIIIIlllllIIlIIllll = llllllllllllllIIIIlllllIIllIIIII.ticksExisted + llllllllllllllIIIIlllllIIlIIIlII;
        final float llllllllllllllIIIIlllllIIlIIlllI = MathHelper.cos(llllllllllllllIIIIlllllIIlIIIllI * 0.6662f + 3.1415927f);
        final float llllllllllllllIIIIlllllIIlIIllIl = llllllllllllllIIIIlllllIIlIIlllI * 0.8f * llllllllllllllIIIIlllllIIlIIIlIl;
        this.head.rotationPointY = 4.0f;
        this.head.rotationPointZ = -10.0f;
        this.tailBase.rotationPointY = 3.0f;
        this.tailMiddle.rotationPointZ = 14.0f;
        this.muleRightChest.rotationPointY = 3.0f;
        this.muleRightChest.rotationPointZ = 10.0f;
        this.body.rotateAngleX = 0.0f;
        this.head.rotateAngleX = 0.5235988f + llllllllllllllIIIIlllllIIlIllIII;
        this.head.rotateAngleY = llllllllllllllIIIIlllllIIlIllIIl * 0.017453292f;
        this.head.rotateAngleX = llllllllllllllIIIIlllllIIlIlIlIl * (0.2617994f + llllllllllllllIIIIlllllIIlIllIII) + llllllllllllllIIIIlllllIIlIlIllI * 2.1816616f + (1.0f - Math.max(llllllllllllllIIIIlllllIIlIlIlIl, llllllllllllllIIIIlllllIIlIlIllI)) * this.head.rotateAngleX;
        this.head.rotateAngleY = llllllllllllllIIIIlllllIIlIlIlIl * llllllllllllllIIIIlllllIIlIllIIl * 0.017453292f + (1.0f - Math.max(llllllllllllllIIIIlllllIIlIlIlIl, llllllllllllllIIIIlllllIIlIlIllI)) * this.head.rotateAngleY;
        this.head.rotationPointY = llllllllllllllIIIIlllllIIlIlIlIl * -6.0f + llllllllllllllIIIIlllllIIlIlIllI * 11.0f + (1.0f - Math.max(llllllllllllllIIIIlllllIIlIlIlIl, llllllllllllllIIIIlllllIIlIlIllI)) * this.head.rotationPointY;
        this.head.rotationPointZ = llllllllllllllIIIIlllllIIlIlIlIl * -1.0f + llllllllllllllIIIIlllllIIlIlIllI * -10.0f + (1.0f - Math.max(llllllllllllllIIIIlllllIIlIlIlIl, llllllllllllllIIIIlllllIIlIlIllI)) * this.head.rotationPointZ;
        this.tailBase.rotationPointY = llllllllllllllIIIIlllllIIlIlIlIl * 9.0f + llllllllllllllIIIIlllllIIlIlIlII * this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = llllllllllllllIIIIlllllIIlIlIlIl * 18.0f + llllllllllllllIIIIlllllIIlIlIlII * this.tailMiddle.rotationPointZ;
        this.muleRightChest.rotationPointY = llllllllllllllIIIIlllllIIlIlIlIl * 5.5f + llllllllllllllIIIIlllllIIlIlIlII * this.muleRightChest.rotationPointY;
        this.muleRightChest.rotationPointZ = llllllllllllllIIIIlllllIIlIlIlIl * 15.0f + llllllllllllllIIIIlllllIIlIlIlII * this.muleRightChest.rotationPointZ;
        this.body.rotateAngleX = llllllllllllllIIIIlllllIIlIlIlIl * -0.7853982f + llllllllllllllIIIIlllllIIlIlIlII * this.body.rotateAngleX;
        this.horseLeftEar.rotationPointY = this.head.rotationPointY;
        this.horseRightEar.rotationPointY = this.head.rotationPointY;
        this.muleLeftEar.rotationPointY = this.head.rotationPointY;
        this.muleRightEar.rotationPointY = this.head.rotationPointY;
        this.neck.rotationPointY = this.head.rotationPointY;
        this.upperMouth.rotationPointY = 0.02f;
        this.lowerMouth.rotationPointY = 0.0f;
        this.mane.rotationPointY = this.head.rotationPointY;
        this.horseLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.horseRightEar.rotationPointZ = this.head.rotationPointZ;
        this.muleLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.muleRightEar.rotationPointZ = this.head.rotationPointZ;
        this.neck.rotationPointZ = this.head.rotationPointZ;
        this.upperMouth.rotationPointZ = 0.02f - llllllllllllllIIIIlllllIIlIlIIll;
        this.lowerMouth.rotationPointZ = llllllllllllllIIIIlllllIIlIlIIll;
        this.mane.rotationPointZ = this.head.rotationPointZ;
        this.horseLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.horseRightEar.rotateAngleX = this.head.rotateAngleX;
        this.muleLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.muleRightEar.rotateAngleX = this.head.rotateAngleX;
        this.neck.rotateAngleX = this.head.rotateAngleX;
        this.upperMouth.rotateAngleX = -0.09424778f * llllllllllllllIIIIlllllIIlIlIIll;
        this.lowerMouth.rotateAngleX = 0.15707964f * llllllllllllllIIIIlllllIIlIlIIll;
        this.mane.rotateAngleX = this.head.rotateAngleX;
        this.horseLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.horseRightEar.rotateAngleY = this.head.rotateAngleY;
        this.muleLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.muleRightEar.rotateAngleY = this.head.rotateAngleY;
        this.neck.rotateAngleY = this.head.rotateAngleY;
        this.upperMouth.rotateAngleY = 0.0f;
        this.lowerMouth.rotateAngleY = 0.0f;
        this.mane.rotateAngleY = this.head.rotateAngleY;
        this.muleLeftChest.rotateAngleX = llllllllllllllIIIIlllllIIlIIllIl / 5.0f;
        this.muleRightChest.rotateAngleX = -llllllllllllllIIIIlllllIIlIIllIl / 5.0f;
        float llllllllllllllIIIIlllllIIlIIllII = 0.2617994f * llllllllllllllIIIIlllllIIlIlIlIl;
        final float llllllllllllllIIIIlllllIIlIIlIll = MathHelper.cos(llllllllllllllIIIIlllllIIlIIllll * 0.6f + 3.1415927f);
        this.frontLeftLeg.rotationPointY = -2.0f * llllllllllllllIIIIlllllIIlIlIlIl + 9.0f * llllllllllllllIIIIlllllIIlIlIlII;
        this.frontLeftLeg.rotationPointZ = -2.0f * llllllllllllllIIIIlllllIIlIlIlIl + -8.0f * llllllllllllllIIIIlllllIIlIlIlII;
        this.frontRightLeg.rotationPointY = this.frontLeftLeg.rotationPointY;
        this.frontRightLeg.rotationPointZ = this.frontLeftLeg.rotationPointZ;
        this.backLeftShin.rotationPointY = this.backLeftLeg.rotationPointY + MathHelper.sin(1.5707964f + llllllllllllllIIIIlllllIIlIIllII + llllllllllllllIIIIlllllIIlIlIlII * -llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl) * 7.0f;
        this.backLeftShin.rotationPointZ = this.backLeftLeg.rotationPointZ + MathHelper.cos(-1.5707964f + llllllllllllllIIIIlllllIIlIIllII + llllllllllllllIIIIlllllIIlIlIlII * -llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl) * 7.0f;
        this.backRightShin.rotationPointY = this.backRightLeg.rotationPointY + MathHelper.sin(1.5707964f + llllllllllllllIIIIlllllIIlIIllII + llllllllllllllIIIIlllllIIlIlIlII * llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl) * 7.0f;
        this.backRightShin.rotationPointZ = this.backRightLeg.rotationPointZ + MathHelper.cos(-1.5707964f + llllllllllllllIIIIlllllIIlIIllII + llllllllllllllIIIIlllllIIlIlIlII * llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl) * 7.0f;
        final float llllllllllllllIIIIlllllIIlIIlIlI = (-1.0471976f + llllllllllllllIIIIlllllIIlIIlIll) * llllllllllllllIIIIlllllIIlIlIlIl + llllllllllllllIIIIlllllIIlIIllIl * llllllllllllllIIIIlllllIIlIlIlII;
        final float llllllllllllllIIIIlllllIIlIIlIIl = (-1.0471976f - llllllllllllllIIIIlllllIIlIIlIll) * llllllllllllllIIIIlllllIIlIlIlIl + -llllllllllllllIIIIlllllIIlIIllIl * llllllllllllllIIIIlllllIIlIlIlII;
        this.frontLeftShin.rotationPointY = this.frontLeftLeg.rotationPointY + MathHelper.sin(1.5707964f + llllllllllllllIIIIlllllIIlIIlIlI) * 7.0f;
        this.frontLeftShin.rotationPointZ = this.frontLeftLeg.rotationPointZ + MathHelper.cos(-1.5707964f + llllllllllllllIIIIlllllIIlIIlIlI) * 7.0f;
        this.frontRightShin.rotationPointY = this.frontRightLeg.rotationPointY + MathHelper.sin(1.5707964f + llllllllllllllIIIIlllllIIlIIlIIl) * 7.0f;
        this.frontRightShin.rotationPointZ = this.frontRightLeg.rotationPointZ + MathHelper.cos(-1.5707964f + llllllllllllllIIIIlllllIIlIIlIIl) * 7.0f;
        this.backLeftLeg.rotateAngleX = llllllllllllllIIIIlllllIIlIIllII + -llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl * llllllllllllllIIIIlllllIIlIlIlII;
        this.backLeftShin.rotateAngleX = -0.08726646f * llllllllllllllIIIIlllllIIlIlIlIl + (-llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl - Math.max(0.0f, llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl)) * llllllllllllllIIIIlllllIIlIlIlII;
        this.backLeftHoof.rotateAngleX = this.backLeftShin.rotateAngleX;
        this.backRightLeg.rotateAngleX = llllllllllllllIIIIlllllIIlIIllII + llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl * llllllllllllllIIIIlllllIIlIlIlII;
        this.backRightShin.rotateAngleX = -0.08726646f * llllllllllllllIIIIlllllIIlIlIlIl + (llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl - Math.max(0.0f, -llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl)) * llllllllllllllIIIIlllllIIlIlIlII;
        this.backRightHoof.rotateAngleX = this.backRightShin.rotateAngleX;
        this.frontLeftLeg.rotateAngleX = llllllllllllllIIIIlllllIIlIIlIlI;
        this.frontLeftShin.rotateAngleX = (this.frontLeftLeg.rotateAngleX + 3.1415927f * Math.max(0.0f, 0.2f + llllllllllllllIIIIlllllIIlIIlIll * 0.2f)) * llllllllllllllIIIIlllllIIlIlIlIl + (llllllllllllllIIIIlllllIIlIIllIl + Math.max(0.0f, llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl)) * llllllllllllllIIIIlllllIIlIlIlII;
        this.frontLeftHoof.rotateAngleX = this.frontLeftShin.rotateAngleX;
        this.frontRightLeg.rotateAngleX = llllllllllllllIIIIlllllIIlIIlIIl;
        this.frontRightShin.rotateAngleX = (this.frontRightLeg.rotateAngleX + 3.1415927f * Math.max(0.0f, 0.2f - llllllllllllllIIIIlllllIIlIIlIll * 0.2f)) * llllllllllllllIIIIlllllIIlIlIlIl + (-llllllllllllllIIIIlllllIIlIIllIl + Math.max(0.0f, -llllllllllllllIIIIlllllIIlIIlllI * 0.5f * llllllllllllllIIIIlllllIIlIIIlIl)) * llllllllllllllIIIIlllllIIlIlIlII;
        this.frontRightHoof.rotateAngleX = this.frontRightShin.rotateAngleX;
        this.backLeftHoof.rotationPointY = this.backLeftShin.rotationPointY;
        this.backLeftHoof.rotationPointZ = this.backLeftShin.rotationPointZ;
        this.backRightHoof.rotationPointY = this.backRightShin.rotationPointY;
        this.backRightHoof.rotationPointZ = this.backRightShin.rotationPointZ;
        this.frontLeftHoof.rotationPointY = this.frontLeftShin.rotationPointY;
        this.frontLeftHoof.rotationPointZ = this.frontLeftShin.rotationPointZ;
        this.frontRightHoof.rotationPointY = this.frontRightShin.rotationPointY;
        this.frontRightHoof.rotationPointZ = this.frontRightShin.rotationPointZ;
        if (llllllllllllllIIIIlllllIIlIlIIIl) {
            this.horseSaddleBottom.rotationPointY = llllllllllllllIIIIlllllIIlIlIlIl * 0.5f + llllllllllllllIIIIlllllIIlIlIlII * 2.0f;
            this.horseSaddleBottom.rotationPointZ = llllllllllllllIIIIlllllIIlIlIlIl * 11.0f + llllllllllllllIIIIlllllIIlIlIlII * 2.0f;
            this.horseSaddleFront.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseSaddleBack.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseLeftSaddleRope.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseRightSaddleRope.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseLeftSaddleMetal.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.horseRightSaddleMetal.rotationPointY = this.horseSaddleBottom.rotationPointY;
            this.muleLeftChest.rotationPointY = this.muleRightChest.rotationPointY;
            this.horseSaddleFront.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseSaddleBack.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseLeftSaddleRope.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseRightSaddleRope.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseLeftSaddleMetal.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.horseRightSaddleMetal.rotationPointZ = this.horseSaddleBottom.rotationPointZ;
            this.muleLeftChest.rotationPointZ = this.muleRightChest.rotationPointZ;
            this.horseSaddleBottom.rotateAngleX = this.body.rotateAngleX;
            this.horseSaddleFront.rotateAngleX = this.body.rotateAngleX;
            this.horseSaddleBack.rotateAngleX = this.body.rotateAngleX;
            this.horseLeftRein.rotationPointY = this.head.rotationPointY;
            this.horseRightRein.rotationPointY = this.head.rotationPointY;
            this.horseFaceRopes.rotationPointY = this.head.rotationPointY;
            this.horseLeftFaceMetal.rotationPointY = this.head.rotationPointY;
            this.horseRightFaceMetal.rotationPointY = this.head.rotationPointY;
            this.horseLeftRein.rotationPointZ = this.head.rotationPointZ;
            this.horseRightRein.rotationPointZ = this.head.rotationPointZ;
            this.horseFaceRopes.rotationPointZ = this.head.rotationPointZ;
            this.horseLeftFaceMetal.rotationPointZ = this.head.rotationPointZ;
            this.horseRightFaceMetal.rotationPointZ = this.head.rotationPointZ;
            this.horseLeftRein.rotateAngleX = llllllllllllllIIIIlllllIIlIllIII;
            this.horseRightRein.rotateAngleX = llllllllllllllIIIIlllllIIlIllIII;
            this.horseFaceRopes.rotateAngleX = this.head.rotateAngleX;
            this.horseLeftFaceMetal.rotateAngleX = this.head.rotateAngleX;
            this.horseRightFaceMetal.rotateAngleX = this.head.rotateAngleX;
            this.horseFaceRopes.rotateAngleY = this.head.rotateAngleY;
            this.horseLeftFaceMetal.rotateAngleY = this.head.rotateAngleY;
            this.horseLeftRein.rotateAngleY = this.head.rotateAngleY;
            this.horseRightFaceMetal.rotateAngleY = this.head.rotateAngleY;
            this.horseRightRein.rotateAngleY = this.head.rotateAngleY;
            if (llllllllllllllIIIIlllllIIlIlIIII) {
                this.horseLeftSaddleRope.rotateAngleX = -1.0471976f;
                this.horseLeftSaddleMetal.rotateAngleX = -1.0471976f;
                this.horseRightSaddleRope.rotateAngleX = -1.0471976f;
                this.horseRightSaddleMetal.rotateAngleX = -1.0471976f;
                this.horseLeftSaddleRope.rotateAngleZ = 0.0f;
                this.horseLeftSaddleMetal.rotateAngleZ = 0.0f;
                this.horseRightSaddleRope.rotateAngleZ = 0.0f;
                this.horseRightSaddleMetal.rotateAngleZ = 0.0f;
            }
            else {
                this.horseLeftSaddleRope.rotateAngleX = llllllllllllllIIIIlllllIIlIIllIl / 3.0f;
                this.horseLeftSaddleMetal.rotateAngleX = llllllllllllllIIIIlllllIIlIIllIl / 3.0f;
                this.horseRightSaddleRope.rotateAngleX = llllllllllllllIIIIlllllIIlIIllIl / 3.0f;
                this.horseRightSaddleMetal.rotateAngleX = llllllllllllllIIIIlllllIIlIIllIl / 3.0f;
                this.horseLeftSaddleRope.rotateAngleZ = llllllllllllllIIIIlllllIIlIIllIl / 5.0f;
                this.horseLeftSaddleMetal.rotateAngleZ = llllllllllllllIIIIlllllIIlIIllIl / 5.0f;
                this.horseRightSaddleRope.rotateAngleZ = -llllllllllllllIIIIlllllIIlIIllIl / 5.0f;
                this.horseRightSaddleMetal.rotateAngleZ = -llllllllllllllIIIIlllllIIlIIllIl / 5.0f;
            }
        }
        llllllllllllllIIIIlllllIIlIIllII = -1.3089969f + llllllllllllllIIIIlllllIIlIIIlIl * 1.5f;
        if (llllllllllllllIIIIlllllIIlIIllII > 0.0f) {
            llllllllllllllIIIIlllllIIlIIllII = 0.0f;
        }
        if (llllllllllllllIIIIlllllIIlIlIIlI) {
            this.tailBase.rotateAngleY = MathHelper.cos(llllllllllllllIIIIlllllIIlIIllll * 0.7f);
            llllllllllllllIIIIlllllIIlIIllII = 0.0f;
        }
        else {
            this.tailBase.rotateAngleY = 0.0f;
        }
        this.tailMiddle.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailTip.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailMiddle.rotationPointY = this.tailBase.rotationPointY;
        this.tailTip.rotationPointY = this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailTip.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailBase.rotateAngleX = llllllllllllllIIIIlllllIIlIIllII;
        this.tailMiddle.rotateAngleX = llllllllllllllIIIIlllllIIlIIllII;
        this.tailTip.rotateAngleX = -0.2617994f + llllllllllllllIIIIlllllIIlIIllII;
    }
}
