package net.minecraft.client.model;

import net.minecraft.init.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelSkeleton extends ModelBiped
{
    public ModelSkeleton(final float llllllllllllllIIlIlIlIIlllIIlIII, final boolean llllllllllllllIIlIlIlIIlllIIIlII) {
        super(llllllllllllllIIlIlIlIIlllIIlIII, 0.0f, 64, 32);
        if (!llllllllllllllIIlIlIlIIlllIIIlII) {
            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-1.0f, -2.0f, -1.0f, 2, 12, 2, llllllllllllllIIlIlIlIIlllIIlIII);
            this.bipedRightArm.setRotationPoint(-5.0f, 2.0f, 0.0f);
            this.bipedLeftArm = new ModelRenderer(this, 40, 16);
            this.bipedLeftArm.mirror = true;
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -1.0f, 2, 12, 2, llllllllllllllIIlIlIlIIlllIIlIII);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.bipedRightLeg = new ModelRenderer(this, 0, 16);
            this.bipedRightLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2, llllllllllllllIIlIlIlIIlllIIlIII);
            this.bipedRightLeg.setRotationPoint(-2.0f, 12.0f, 0.0f);
            this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
            this.bipedLeftLeg.mirror = true;
            this.bipedLeftLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2, llllllllllllllIIlIlIlIIlllIIlIII);
            this.bipedLeftLeg.setRotationPoint(2.0f, 12.0f, 0.0f);
        }
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase llllllllllllllIIlIlIlIIllIlIllIl, final float llllllllllllllIIlIlIlIIllIlIllII, final float llllllllllllllIIlIlIlIIllIllIIIl, final float llllllllllllllIIlIlIlIIllIllIIII) {
        this.rightArmPose = ArmPose.EMPTY;
        this.leftArmPose = ArmPose.EMPTY;
        final ItemStack llllllllllllllIIlIlIlIIllIlIllll = llllllllllllllIIlIlIlIIllIlIllIl.getHeldItem(EnumHand.MAIN_HAND);
        if (llllllllllllllIIlIlIlIIllIlIllll.getItem() == Items.BOW && ((AbstractSkeleton)llllllllllllllIIlIlIlIIllIlIllIl).isSwingingArms()) {
            if (llllllllllllllIIlIlIlIIllIlIllIl.getPrimaryHand() == EnumHandSide.RIGHT) {
                this.rightArmPose = ArmPose.BOW_AND_ARROW;
            }
            else {
                this.leftArmPose = ArmPose.BOW_AND_ARROW;
            }
        }
        super.setLivingAnimations(llllllllllllllIIlIlIlIIllIlIllIl, llllllllllllllIIlIlIlIIllIlIllII, llllllllllllllIIlIlIlIIllIllIIIl, llllllllllllllIIlIlIlIIllIllIIII);
    }
    
    public ModelSkeleton() {
        this(0.0f, false);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIlIlIlIIlIlllIIII, final float llllllllllllllIIlIlIlIIllIIIIIIl, final float llllllllllllllIIlIlIlIIlIlllllll, final float llllllllllllllIIlIlIlIIlIllIlIll, final float llllllllllllllIIlIlIlIIlIlllllII, final float llllllllllllllIIlIlIlIIlIllllIlI, final Entity llllllllllllllIIlIlIlIIlIllllIII) {
        super.setRotationAngles(llllllllllllllIIlIlIlIIlIlllIIII, llllllllllllllIIlIlIlIIllIIIIIIl, llllllllllllllIIlIlIlIIlIlllllll, llllllllllllllIIlIlIlIIlIllIlIll, llllllllllllllIIlIlIlIIlIlllllII, llllllllllllllIIlIlIlIIlIllllIlI, llllllllllllllIIlIlIlIIlIllllIII);
        final ItemStack llllllllllllllIIlIlIlIIlIlllIlll = ((EntityLivingBase)llllllllllllllIIlIlIlIIlIllllIII).getHeldItemMainhand();
        final AbstractSkeleton llllllllllllllIIlIlIlIIlIlllIllI = (AbstractSkeleton)llllllllllllllIIlIlIlIIlIllllIII;
        if (llllllllllllllIIlIlIlIIlIlllIllI.isSwingingArms() && (llllllllllllllIIlIlIlIIlIlllIlll.func_190926_b() || llllllllllllllIIlIlIlIIlIlllIlll.getItem() != Items.BOW)) {
            final float llllllllllllllIIlIlIlIIlIlllIlII = MathHelper.sin(this.swingProgress * 3.1415927f);
            final float llllllllllllllIIlIlIlIIlIlllIIlI = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
            this.bipedRightArm.rotateAngleZ = 0.0f;
            this.bipedLeftArm.rotateAngleZ = 0.0f;
            this.bipedRightArm.rotateAngleY = -(0.1f - llllllllllllllIIlIlIlIIlIlllIlII * 0.6f);
            this.bipedLeftArm.rotateAngleY = 0.1f - llllllllllllllIIlIlIlIIlIlllIlII * 0.6f;
            this.bipedRightArm.rotateAngleX = -1.5707964f;
            this.bipedLeftArm.rotateAngleX = -1.5707964f;
            final ModelRenderer bipedRightArm = this.bipedRightArm;
            bipedRightArm.rotateAngleX -= llllllllllllllIIlIlIlIIlIlllIlII * 1.2f - llllllllllllllIIlIlIlIIlIlllIIlI * 0.4f;
            final ModelRenderer bipedLeftArm = this.bipedLeftArm;
            bipedLeftArm.rotateAngleX -= llllllllllllllIIlIlIlIIlIlllIlII * 1.2f - llllllllllllllIIlIlIlIIlIlllIIlI * 0.4f;
            final ModelRenderer bipedRightArm2 = this.bipedRightArm;
            bipedRightArm2.rotateAngleZ += MathHelper.cos(llllllllllllllIIlIlIlIIlIlllllll * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer bipedLeftArm2 = this.bipedLeftArm;
            bipedLeftArm2.rotateAngleZ -= MathHelper.cos(llllllllllllllIIlIlIlIIlIlllllll * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer bipedRightArm3 = this.bipedRightArm;
            bipedRightArm3.rotateAngleX += MathHelper.sin(llllllllllllllIIlIlIlIIlIlllllll * 0.067f) * 0.05f;
            final ModelRenderer bipedLeftArm3 = this.bipedLeftArm;
            bipedLeftArm3.rotateAngleX -= MathHelper.sin(llllllllllllllIIlIlIlIIlIlllllll * 0.067f) * 0.05f;
        }
    }
    
    @Override
    public void postRenderArm(final float llllllllllllllIIlIlIlIIlIlIlIllI, final EnumHandSide llllllllllllllIIlIlIlIIlIlIlIlIl) {
        final float llllllllllllllIIlIlIlIIlIlIllIIl = (llllllllllllllIIlIlIlIIlIlIlIlIl == EnumHandSide.RIGHT) ? 1.0f : -1.0f;
        final ModelRenderer armForSide;
        final ModelRenderer llllllllllllllIIlIlIlIIlIlIllIII = armForSide = this.getArmForSide(llllllllllllllIIlIlIlIIlIlIlIlIl);
        armForSide.rotationPointX += llllllllllllllIIlIlIlIIlIlIllIIl;
        llllllllllllllIIlIlIlIIlIlIllIII.postRender(llllllllllllllIIlIlIlIIlIlIlIllI);
        final ModelRenderer modelRenderer = llllllllllllllIIlIlIlIIlIlIllIII;
        modelRenderer.rotationPointX -= llllllllllllllIIlIlIlIIlIlIllIIl;
    }
}
