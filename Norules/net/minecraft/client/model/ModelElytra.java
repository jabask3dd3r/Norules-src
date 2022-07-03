package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.*;

public class ModelElytra extends ModelBase
{
    private final /* synthetic */ ModelRenderer leftWing;
    private final /* synthetic */ ModelRenderer rightWing;
    
    @Override
    public void setRotationAngles(final float lllllllllllllIIIlllIIlIllIlIlIlI, final float lllllllllllllIIIlllIIlIllIlllIII, final float lllllllllllllIIIlllIIlIllIlIlIII, final float lllllllllllllIIIlllIIlIllIlIIlll, final float lllllllllllllIIIlllIIlIllIllIlIl, final float lllllllllllllIIIlllIIlIllIlIIlIl, final Entity lllllllllllllIIIlllIIlIllIlIIlII) {
        super.setRotationAngles(lllllllllllllIIIlllIIlIllIlIlIlI, lllllllllllllIIIlllIIlIllIlllIII, lllllllllllllIIIlllIIlIllIlIlIII, lllllllllllllIIIlllIIlIllIlIIlll, lllllllllllllIIIlllIIlIllIllIlIl, lllllllllllllIIIlllIIlIllIlIIlIl, lllllllllllllIIIlllIIlIllIlIIlII);
        float lllllllllllllIIIlllIIlIllIllIIlI = 0.2617994f;
        float lllllllllllllIIIlllIIlIllIllIIIl = -0.2617994f;
        float lllllllllllllIIIlllIIlIllIllIIII = 0.0f;
        float lllllllllllllIIIlllIIlIllIlIllll = 0.0f;
        if (lllllllllllllIIIlllIIlIllIlIIlII instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllIIIlllIIlIllIlIIlII).isElytraFlying()) {
            float lllllllllllllIIIlllIIlIllIlIlllI = 1.0f;
            if (lllllllllllllIIIlllIIlIllIlIIlII.motionY < 0.0) {
                final Vec3d lllllllllllllIIIlllIIlIllIlIllIl = new Vec3d(lllllllllllllIIIlllIIlIllIlIIlII.motionX, lllllllllllllIIIlllIIlIllIlIIlII.motionY, lllllllllllllIIIlllIIlIllIlIIlII.motionZ).normalize();
                lllllllllllllIIIlllIIlIllIlIlllI = 1.0f - (float)Math.pow(-lllllllllllllIIIlllIIlIllIlIllIl.yCoord, 1.5);
            }
            lllllllllllllIIIlllIIlIllIllIIlI = lllllllllllllIIIlllIIlIllIlIlllI * 0.34906584f + (1.0f - lllllllllllllIIIlllIIlIllIlIlllI) * lllllllllllllIIIlllIIlIllIllIIlI;
            lllllllllllllIIIlllIIlIllIllIIIl = lllllllllllllIIIlllIIlIllIlIlllI * -1.5707964f + (1.0f - lllllllllllllIIIlllIIlIllIlIlllI) * lllllllllllllIIIlllIIlIllIllIIIl;
        }
        else if (lllllllllllllIIIlllIIlIllIlIIlII.isSneaking()) {
            lllllllllllllIIIlllIIlIllIllIIlI = 0.69813174f;
            lllllllllllllIIIlllIIlIllIllIIIl = -0.7853982f;
            lllllllllllllIIIlllIIlIllIllIIII = 3.0f;
            lllllllllllllIIIlllIIlIllIlIllll = 0.08726646f;
        }
        this.leftWing.rotationPointX = 5.0f;
        this.leftWing.rotationPointY = lllllllllllllIIIlllIIlIllIllIIII;
        if (lllllllllllllIIIlllIIlIllIlIIlII instanceof AbstractClientPlayer) {
            final AbstractClientPlayer lllllllllllllIIIlllIIlIllIlIllII = (AbstractClientPlayer)lllllllllllllIIIlllIIlIllIlIIlII;
            lllllllllllllIIIlllIIlIllIlIllII.rotateElytraX += (float)((lllllllllllllIIIlllIIlIllIllIIlI - lllllllllllllIIIlllIIlIllIlIllII.rotateElytraX) * 0.1);
            lllllllllllllIIIlllIIlIllIlIllII.rotateElytraY += (float)((lllllllllllllIIIlllIIlIllIlIllll - lllllllllllllIIIlllIIlIllIlIllII.rotateElytraY) * 0.1);
            lllllllllllllIIIlllIIlIllIlIllII.rotateElytraZ += (float)((lllllllllllllIIIlllIIlIllIllIIIl - lllllllllllllIIIlllIIlIllIlIllII.rotateElytraZ) * 0.1);
            this.leftWing.rotateAngleX = lllllllllllllIIIlllIIlIllIlIllII.rotateElytraX;
            this.leftWing.rotateAngleY = lllllllllllllIIIlllIIlIllIlIllII.rotateElytraY;
            this.leftWing.rotateAngleZ = lllllllllllllIIIlllIIlIllIlIllII.rotateElytraZ;
        }
        else {
            this.leftWing.rotateAngleX = lllllllllllllIIIlllIIlIllIllIIlI;
            this.leftWing.rotateAngleZ = lllllllllllllIIIlllIIlIllIllIIIl;
            this.leftWing.rotateAngleY = lllllllllllllIIIlllIIlIllIlIllll;
        }
        this.rightWing.rotationPointX = -this.leftWing.rotationPointX;
        this.rightWing.rotateAngleY = -this.leftWing.rotateAngleY;
        this.rightWing.rotationPointY = this.leftWing.rotationPointY;
        this.rightWing.rotateAngleX = this.leftWing.rotateAngleX;
        this.rightWing.rotateAngleZ = -this.leftWing.rotateAngleZ;
    }
    
    @Override
    public void render(final Entity lllllllllllllIIIlllIIlIlllIIlIlI, final float lllllllllllllIIIlllIIlIlllIlIIIl, final float lllllllllllllIIIlllIIlIlllIlIIII, final float lllllllllllllIIIlllIIlIlllIIllll, final float lllllllllllllIIIlllIIlIlllIIlllI, final float lllllllllllllIIIlllIIlIlllIIllIl, final float lllllllllllllIIIlllIIlIlllIIlIIl) {
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableCull();
        if (lllllllllllllIIIlllIIlIlllIIlIlI instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllIIIlllIIlIlllIIlIlI).isChild()) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 1.5f, -0.1f);
            this.leftWing.render(lllllllllllllIIIlllIIlIlllIIlIIl);
            this.rightWing.render(lllllllllllllIIIlllIIlIlllIIlIIl);
            GlStateManager.popMatrix();
        }
        else {
            this.leftWing.render(lllllllllllllIIIlllIIlIlllIIlIIl);
            this.rightWing.render(lllllllllllllIIIlllIIlIlllIIlIIl);
        }
    }
    
    public ModelElytra() {
        this.leftWing = new ModelRenderer(this, 22, 0);
        this.leftWing.addBox(-10.0f, 0.0f, 0.0f, 10, 20, 2, 1.0f);
        this.rightWing = new ModelRenderer(this, 22, 0);
        this.rightWing.mirror = true;
        this.rightWing.addBox(0.0f, 0.0f, 0.0f, 10, 20, 2, 1.0f);
    }
}
