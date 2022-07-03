package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.math.*;

public class ModelZombie extends ModelBiped
{
    public ModelZombie() {
        this(0.0f, false);
    }
    
    public ModelZombie(final float lllllllllllllIlIIlIIIlIIlllIIIll, final boolean lllllllllllllIlIIlIIIlIIllIlllll) {
        super(lllllllllllllIlIIlIIIlIIlllIIIll, 0.0f, 64, lllllllllllllIlIIlIIIlIIllIlllll ? 32 : 64);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlIIlIIIlIIllIlIIIl, final float lllllllllllllIlIIlIIIlIIllIIIlII, final float lllllllllllllIlIIlIIIlIIllIIIIll, final float lllllllllllllIlIIlIIIlIIllIIlllI, final float lllllllllllllIlIIlIIIlIIllIIIIIl, final float lllllllllllllIlIIlIIIlIIllIIIIII, final Entity lllllllllllllIlIIlIIIlIIlIllllll) {
        super.setRotationAngles(lllllllllllllIlIIlIIIlIIllIlIIIl, lllllllllllllIlIIlIIIlIIllIIIlII, lllllllllllllIlIIlIIIlIIllIIIIll, lllllllllllllIlIIlIIIlIIllIIlllI, lllllllllllllIlIIlIIIlIIllIIIIIl, lllllllllllllIlIIlIIIlIIllIIIIII, lllllllllllllIlIIlIIIlIIlIllllll);
        final boolean lllllllllllllIlIIlIIIlIIllIIlIlI = lllllllllllllIlIIlIIIlIIlIllllll instanceof EntityZombie && ((EntityZombie)lllllllllllllIlIIlIIIlIIlIllllll).isArmsRaised();
        final float lllllllllllllIlIIlIIIlIIllIIlIIl = MathHelper.sin(this.swingProgress * 3.1415927f);
        final float lllllllllllllIlIIlIIIlIIllIIlIII = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -(0.1f - lllllllllllllIlIIlIIIlIIllIIlIIl * 0.6f);
        this.bipedLeftArm.rotateAngleY = 0.1f - lllllllllllllIlIIlIIIlIIllIIlIIl * 0.6f;
        final float lllllllllllllIlIIlIIIlIIllIIIlll = -3.1415927f / (lllllllllllllIlIIlIIIlIIllIIlIlI ? 1.5f : 2.25f);
        this.bipedRightArm.rotateAngleX = lllllllllllllIlIIlIIIlIIllIIIlll;
        this.bipedLeftArm.rotateAngleX = lllllllllllllIlIIlIIIlIIllIIIlll;
        final ModelRenderer bipedRightArm = this.bipedRightArm;
        bipedRightArm.rotateAngleX += lllllllllllllIlIIlIIIlIIllIIlIIl * 1.2f - lllllllllllllIlIIlIIIlIIllIIlIII * 0.4f;
        final ModelRenderer bipedLeftArm = this.bipedLeftArm;
        bipedLeftArm.rotateAngleX += lllllllllllllIlIIlIIIlIIllIIlIIl * 1.2f - lllllllllllllIlIIlIIIlIIllIIlIII * 0.4f;
        final ModelRenderer bipedRightArm2 = this.bipedRightArm;
        bipedRightArm2.rotateAngleZ += MathHelper.cos(lllllllllllllIlIIlIIIlIIllIIIIll * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
        bipedLeftArm2.rotateAngleZ -= MathHelper.cos(lllllllllllllIlIIlIIIlIIllIIIIll * 0.09f) * 0.05f + 0.05f;
        final ModelRenderer bipedRightArm3 = this.bipedRightArm;
        bipedRightArm3.rotateAngleX += MathHelper.sin(lllllllllllllIlIIlIIIlIIllIIIIll * 0.067f) * 0.05f;
        final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
        bipedLeftArm3.rotateAngleX -= MathHelper.sin(lllllllllllllIlIIlIIIlIIllIIIIll * 0.067f) * 0.05f;
    }
}
