package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.math.*;

public class ModelZombieVillager extends ModelBiped
{
    @Override
    public void setRotationAngles(final float lllllllllllllIIlllllllIIIllIlllI, final float lllllllllllllIIlllllllIIIllIllIl, final float lllllllllllllIIlllllllIIIllIllII, final float lllllllllllllIIlllllllIIIlllIlll, final float lllllllllllllIIlllllllIIIlllIllI, final float lllllllllllllIIlllllllIIIllIlIIl, final Entity lllllllllllllIIlllllllIIIllIlIII) {
        super.setRotationAngles(lllllllllllllIIlllllllIIIllIlllI, lllllllllllllIIlllllllIIIllIllIl, lllllllllllllIIlllllllIIIllIllII, lllllllllllllIIlllllllIIIlllIlll, lllllllllllllIIlllllllIIIlllIllI, lllllllllllllIIlllllllIIIllIlIIl, lllllllllllllIIlllllllIIIllIlIII);
        final EntityZombie lllllllllllllIIlllllllIIIlllIIll = (EntityZombie)lllllllllllllIIlllllllIIIllIlIII;
        final float lllllllllllllIIlllllllIIIlllIIlI = MathHelper.sin(this.swingProgress * 3.1415927f);
        final float lllllllllllllIIlllllllIIIlllIIIl = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -(0.1f - lllllllllllllIIlllllllIIIlllIIlI * 0.6f);
        this.bipedLeftArm.rotateAngleY = 0.1f - lllllllllllllIIlllllllIIIlllIIlI * 0.6f;
        final float lllllllllllllIIlllllllIIIlllIIII = -3.1415927f / (lllllllllllllIIlllllllIIIlllIIll.isArmsRaised() ? 1.5f : 2.25f);
        this.bipedRightArm.rotateAngleX = lllllllllllllIIlllllllIIIlllIIII;
        this.bipedLeftArm.rotateAngleX = lllllllllllllIIlllllllIIIlllIIII;
        final ModelRenderer bipedRightArm = this.bipedRightArm;
        bipedRightArm.rotateAngleX += lllllllllllllIIlllllllIIIlllIIlI * 1.2f - lllllllllllllIIlllllllIIIlllIIIl * 0.4f;
        final ModelRenderer bipedLeftArm = this.bipedLeftArm;
        bipedLeftArm.rotateAngleX += lllllllllllllIIlllllllIIIlllIIlI * 1.2f - lllllllllllllIIlllllllIIIlllIIIl * 0.4f;
        final ModelRenderer bipedRightArm2 = this.bipedRightArm;
        bipedRightArm2.rotateAngleZ += MathHelper.cos(lllllllllllllIIlllllllIIIllIllII * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
        bipedLeftArm2.rotateAngleZ -= MathHelper.cos(lllllllllllllIIlllllllIIIllIllII * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm3 = this.bipedRightArm;
        bipedRightArm3.rotateAngleX += MathHelper.sin(lllllllllllllIIlllllllIIIllIllII * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
        bipedLeftArm3.rotateAngleX -= MathHelper.sin(lllllllllllllIIlllllllIIIllIllII * 0.067f) * 0.05f;
    }
    
    public ModelZombieVillager() {
        this(0.0f, 0.0f, false);
    }
    
    public ModelZombieVillager(final float lllllllllllllIIlllllllIIlIIIlIlI, final float lllllllllllllIIlllllllIIlIIIlIIl, final boolean lllllllllllllIIlllllllIIlIIIllIl) {
        super(lllllllllllllIIlllllllIIlIIIlIlI, 0.0f, 64, lllllllllllllIIlllllllIIlIIIllIl ? 32 : 64);
        if (lllllllllllllIIlllllllIIlIIIllIl) {
            this.bipedHead = new ModelRenderer(this, 0, 0);
            this.bipedHead.addBox(-4.0f, -10.0f, -4.0f, 8, 8, 8, lllllllllllllIIlllllllIIlIIIlIlI);
            this.bipedHead.setRotationPoint(0.0f, 0.0f + lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedBody = new ModelRenderer(this, 16, 16);
            this.bipedBody.setRotationPoint(0.0f, 0.0f + lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedBody.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, lllllllllllllIIlllllllIIlIIIlIlI + 0.1f);
            this.bipedRightLeg = new ModelRenderer(this, 0, 16);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f + lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllllllIIlIIIlIlI + 0.1f);
            this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
            this.bipedLeftLeg.mirror = true;
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f + lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllllllIIlIIIlIlI + 0.1f);
        }
        else {
            this.bipedHead = new ModelRenderer(this, 0, 0);
            this.bipedHead.setRotationPoint(0.0f, lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedHead.setTextureOffset(0, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, lllllllllllllIIlllllllIIlIIIlIlI);
            this.bipedHead.setTextureOffset(24, 0).addBox(-1.0f, -3.0f, -6.0f, 2, 4, 2, lllllllllllllIIlllllllIIlIIIlIlI);
            this.bipedBody = new ModelRenderer(this, 16, 20);
            this.bipedBody.setRotationPoint(0.0f, 0.0f + lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedBody.addBox(-4.0f, 0.0f, -3.0f, 8, 12, 6, lllllllllllllIIlllllllIIlIIIlIlI);
            this.bipedBody.setTextureOffset(0, 38).addBox(-4.0f, 0.0f, -3.0f, 8, 18, 6, lllllllllllllIIlllllllIIlIIIlIlI + 0.05f);
            this.bipedRightArm = new ModelRenderer(this, 44, 38);
            this.bipedRightArm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllllllIIlIIIlIlI);
            this.bipedRightArm.setRotationPoint(-5.0f, 2.0f + lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedLeftArm = new ModelRenderer(this, 44, 38);
            this.bipedLeftArm.mirror = true;
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllllllIIlIIIlIlI);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f + lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedRightLeg = new ModelRenderer(this, 0, 22);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f + lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllllllIIlIIIlIlI);
            this.bipedLeftLeg = new ModelRenderer(this, 0, 22);
            this.bipedLeftLeg.mirror = true;
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f + lllllllllllllIIlllllllIIlIIIlIIl, 0.0f);
            this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIIlllllllIIlIIIlIlI);
        }
    }
}
