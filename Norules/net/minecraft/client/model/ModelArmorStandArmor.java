package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.item.*;

public class ModelArmorStandArmor extends ModelBiped
{
    @Override
    public void setRotationAngles(final float lllllllllllllIlllIlllIllIlIIIlII, final float lllllllllllllIlllIlllIllIlIIIIll, final float lllllllllllllIlllIlllIllIlIIIIlI, final float lllllllllllllIlllIlllIllIlIIIIIl, final float lllllllllllllIlllIlllIllIlIIIIII, final float lllllllllllllIlllIlllIllIIllllll, final Entity lllllllllllllIlllIlllIllIIlllllI) {
        if (lllllllllllllIlllIlllIllIIlllllI instanceof EntityArmorStand) {
            final EntityArmorStand lllllllllllllIlllIlllIllIIllllIl = (EntityArmorStand)lllllllllllllIlllIlllIllIIlllllI;
            this.bipedHead.rotateAngleX = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getHeadRotation().getX();
            this.bipedHead.rotateAngleY = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getHeadRotation().getY();
            this.bipedHead.rotateAngleZ = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getHeadRotation().getZ();
            this.bipedHead.setRotationPoint(0.0f, 1.0f, 0.0f);
            this.bipedBody.rotateAngleX = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getBodyRotation().getX();
            this.bipedBody.rotateAngleY = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getBodyRotation().getY();
            this.bipedBody.rotateAngleZ = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getBodyRotation().getZ();
            this.bipedLeftArm.rotateAngleX = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getLeftArmRotation().getX();
            this.bipedLeftArm.rotateAngleY = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getLeftArmRotation().getY();
            this.bipedLeftArm.rotateAngleZ = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getLeftArmRotation().getZ();
            this.bipedRightArm.rotateAngleX = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getRightArmRotation().getX();
            this.bipedRightArm.rotateAngleY = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getRightArmRotation().getY();
            this.bipedRightArm.rotateAngleZ = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getRightArmRotation().getZ();
            this.bipedLeftLeg.rotateAngleX = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getLeftLegRotation().getX();
            this.bipedLeftLeg.rotateAngleY = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getLeftLegRotation().getY();
            this.bipedLeftLeg.rotateAngleZ = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getLeftLegRotation().getZ();
            this.bipedLeftLeg.setRotationPoint(1.9f, 11.0f, 0.0f);
            this.bipedRightLeg.rotateAngleX = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getRightLegRotation().getX();
            this.bipedRightLeg.rotateAngleY = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getRightLegRotation().getY();
            this.bipedRightLeg.rotateAngleZ = 0.017453292f * lllllllllllllIlllIlllIllIIllllIl.getRightLegRotation().getZ();
            this.bipedRightLeg.setRotationPoint(-1.9f, 11.0f, 0.0f);
            ModelBase.copyModelAngles(this.bipedHead, this.bipedHeadwear);
        }
    }
    
    protected ModelArmorStandArmor(final float lllllllllllllIlllIlllIllIlIIllll, final int lllllllllllllIlllIlllIllIlIIlIlI, final int lllllllllllllIlllIlllIllIlIIllIl) {
        super(lllllllllllllIlllIlllIllIlIIllll, 0.0f, lllllllllllllIlllIlllIllIlIIlIlI, lllllllllllllIlllIlllIllIlIIllIl);
    }
    
    public ModelArmorStandArmor() {
        this(0.0f);
    }
    
    public ModelArmorStandArmor(final float lllllllllllllIlllIlllIllIlIlIlIl) {
        this(lllllllllllllIlllIlllIllIlIlIlIl, 64, 32);
    }
}
