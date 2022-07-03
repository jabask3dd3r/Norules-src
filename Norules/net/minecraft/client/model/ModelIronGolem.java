package net.minecraft.client.model;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;

public class ModelIronGolem extends ModelBase
{
    public /* synthetic */ ModelRenderer ironGolemRightLeg;
    public /* synthetic */ ModelRenderer ironGolemLeftArm;
    public /* synthetic */ ModelRenderer ironGolemBody;
    public /* synthetic */ ModelRenderer ironGolemRightArm;
    public /* synthetic */ ModelRenderer ironGolemHead;
    public /* synthetic */ ModelRenderer ironGolemLeftLeg;
    
    public ModelIronGolem() {
        this(0.0f);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllIlllIIIlIllIlIlIIIl, final float lllllllllllllIlllIIIlIllIlIlIIII, final float lllllllllllllIlllIIIlIllIlIIllll, final float lllllllllllllIlllIIIlIllIlIIlllI) {
        final EntityIronGolem lllllllllllllIlllIIIlIllIlIIllIl = (EntityIronGolem)lllllllllllllIlllIIIlIllIlIlIIIl;
        final int lllllllllllllIlllIIIlIllIlIIllII = lllllllllllllIlllIIIlIllIlIIllIl.getAttackTimer();
        if (lllllllllllllIlllIIIlIllIlIIllII > 0) {
            this.ironGolemRightArm.rotateAngleX = -2.0f + 1.5f * this.triangleWave(lllllllllllllIlllIIIlIllIlIIllII - lllllllllllllIlllIIIlIllIlIIlllI, 10.0f);
            this.ironGolemLeftArm.rotateAngleX = -2.0f + 1.5f * this.triangleWave(lllllllllllllIlllIIIlIllIlIIllII - lllllllllllllIlllIIIlIllIlIIlllI, 10.0f);
        }
        else {
            final int lllllllllllllIlllIIIlIllIlIIlIll = lllllllllllllIlllIIIlIllIlIIllIl.getHoldRoseTick();
            if (lllllllllllllIlllIIIlIllIlIIlIll > 0) {
                this.ironGolemRightArm.rotateAngleX = -0.8f + 0.025f * this.triangleWave((float)lllllllllllllIlllIIIlIllIlIIlIll, 70.0f);
                this.ironGolemLeftArm.rotateAngleX = 0.0f;
            }
            else {
                this.ironGolemRightArm.rotateAngleX = (-0.2f + 1.5f * this.triangleWave(lllllllllllllIlllIIIlIllIlIlIIII, 13.0f)) * lllllllllllllIlllIIIlIllIlIIllll;
                this.ironGolemLeftArm.rotateAngleX = (-0.2f - 1.5f * this.triangleWave(lllllllllllllIlllIIIlIllIlIlIIII, 13.0f)) * lllllllllllllIlllIIIlIllIlIIllll;
            }
        }
    }
    
    private float triangleWave(final float lllllllllllllIlllIIIlIllIIllllll, final float lllllllllllllIlllIIIlIllIIllllII) {
        return (Math.abs(lllllllllllllIlllIIIlIllIIllllll % lllllllllllllIlllIIIlIllIIllllII - lllllllllllllIlllIIIlIllIIllllII * 0.5f) - lllllllllllllIlllIIIlIllIIllllII * 0.25f) / (lllllllllllllIlllIIIlIllIIllllII * 0.25f);
    }
    
    public ModelIronGolem(final float lllllllllllllIlllIIIlIlllIIlIlII) {
        this(lllllllllllllIlllIIIlIlllIIlIlII, -7.0f);
    }
    
    public ModelIronGolem(final float lllllllllllllIlllIIIlIlllIIIllIl, final float lllllllllllllIlllIIIlIlllIIIIlll) {
        final int lllllllllllllIlllIIIlIlllIIIlIll = 128;
        final int lllllllllllllIlllIIIlIlllIIIlIlI = 128;
        this.ironGolemHead = new ModelRenderer(this).setTextureSize(128, 128);
        this.ironGolemHead.setRotationPoint(0.0f, 0.0f + lllllllllllllIlllIIIlIlllIIIIlll, -2.0f);
        this.ironGolemHead.setTextureOffset(0, 0).addBox(-4.0f, -12.0f, -5.5f, 8, 10, 8, lllllllllllllIlllIIIlIlllIIIllIl);
        this.ironGolemHead.setTextureOffset(24, 0).addBox(-1.0f, -5.0f, -7.5f, 2, 4, 2, lllllllllllllIlllIIIlIlllIIIllIl);
        this.ironGolemBody = new ModelRenderer(this).setTextureSize(128, 128);
        this.ironGolemBody.setRotationPoint(0.0f, 0.0f + lllllllllllllIlllIIIlIlllIIIIlll, 0.0f);
        this.ironGolemBody.setTextureOffset(0, 40).addBox(-9.0f, -2.0f, -6.0f, 18, 12, 11, lllllllllllllIlllIIIlIlllIIIllIl);
        this.ironGolemBody.setTextureOffset(0, 70).addBox(-4.5f, 10.0f, -3.0f, 9, 5, 6, lllllllllllllIlllIIIlIlllIIIllIl + 0.5f);
        this.ironGolemRightArm = new ModelRenderer(this).setTextureSize(128, 128);
        this.ironGolemRightArm.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.ironGolemRightArm.setTextureOffset(60, 21).addBox(-13.0f, -2.5f, -3.0f, 4, 30, 6, lllllllllllllIlllIIIlIlllIIIllIl);
        this.ironGolemLeftArm = new ModelRenderer(this).setTextureSize(128, 128);
        this.ironGolemLeftArm.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.ironGolemLeftArm.setTextureOffset(60, 58).addBox(9.0f, -2.5f, -3.0f, 4, 30, 6, lllllllllllllIlllIIIlIlllIIIllIl);
        this.ironGolemLeftLeg = new ModelRenderer(this, 0, 22).setTextureSize(128, 128);
        this.ironGolemLeftLeg.setRotationPoint(-4.0f, 18.0f + lllllllllllllIlllIIIlIlllIIIIlll, 0.0f);
        this.ironGolemLeftLeg.setTextureOffset(37, 0).addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, lllllllllllllIlllIIIlIlllIIIllIl);
        this.ironGolemRightLeg = new ModelRenderer(this, 0, 22).setTextureSize(128, 128);
        this.ironGolemRightLeg.mirror = true;
        this.ironGolemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0f, 18.0f + lllllllllllllIlllIIIlIlllIIIIlll, 0.0f);
        this.ironGolemRightLeg.addBox(-3.5f, -3.0f, -3.0f, 6, 16, 5, lllllllllllllIlllIIIlIlllIIIllIl);
    }
    
    @Override
    public void render(final Entity lllllllllllllIlllIIIlIllIllllIll, final float lllllllllllllIlllIIIlIllIllllIlI, final float lllllllllllllIlllIIIlIllIlllIIIl, final float lllllllllllllIlllIIIlIllIllllIII, final float lllllllllllllIlllIIIlIllIllIllll, final float lllllllllllllIlllIIIlIllIlllIllI, final float lllllllllllllIlllIIIlIllIlllIlIl) {
        this.setRotationAngles(lllllllllllllIlllIIIlIllIllllIlI, lllllllllllllIlllIIIlIllIlllIIIl, lllllllllllllIlllIIIlIllIllllIII, lllllllllllllIlllIIIlIllIllIllll, lllllllllllllIlllIIIlIllIlllIllI, lllllllllllllIlllIIIlIllIlllIlIl, lllllllllllllIlllIIIlIllIllllIll);
        this.ironGolemHead.render(lllllllllllllIlllIIIlIllIlllIlIl);
        this.ironGolemBody.render(lllllllllllllIlllIIIlIllIlllIlIl);
        this.ironGolemLeftLeg.render(lllllllllllllIlllIIIlIllIlllIlIl);
        this.ironGolemRightLeg.render(lllllllllllllIlllIIIlIllIlllIlIl);
        this.ironGolemRightArm.render(lllllllllllllIlllIIIlIllIlllIlIl);
        this.ironGolemLeftArm.render(lllllllllllllIlllIIIlIllIlllIlIl);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlllIIIlIllIllIIllI, final float lllllllllllllIlllIIIlIllIllIIlIl, final float lllllllllllllIlllIIIlIllIllIIlII, final float lllllllllllllIlllIIIlIllIllIIIll, final float lllllllllllllIlllIIIlIllIlIllIll, final float lllllllllllllIlllIIIlIllIllIIIIl, final Entity lllllllllllllIlllIIIlIllIllIIIII) {
        this.ironGolemHead.rotateAngleY = lllllllllllllIlllIIIlIllIllIIIll * 0.017453292f;
        this.ironGolemHead.rotateAngleX = lllllllllllllIlllIIIlIllIlIllIll * 0.017453292f;
        this.ironGolemLeftLeg.rotateAngleX = -1.5f * this.triangleWave(lllllllllllllIlllIIIlIllIllIIllI, 13.0f) * lllllllllllllIlllIIIlIllIllIIlIl;
        this.ironGolemRightLeg.rotateAngleX = 1.5f * this.triangleWave(lllllllllllllIlllIIIlIllIllIIllI, 13.0f) * lllllllllllllIlllIIIlIllIllIIlIl;
        this.ironGolemLeftLeg.rotateAngleY = 0.0f;
        this.ironGolemRightLeg.rotateAngleY = 0.0f;
    }
}
