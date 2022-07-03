package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;

public class ModelArmorStand extends ModelArmorStandArmor
{
    public /* synthetic */ ModelRenderer standWaist;
    public /* synthetic */ ModelRenderer standBase;
    public /* synthetic */ ModelRenderer standRightSide;
    public /* synthetic */ ModelRenderer standLeftSide;
    
    @Override
    public void render(final Entity llllllllllllllIlIIIllIIllIIllIII, final float llllllllllllllIlIIIllIIllIIlIlll, final float llllllllllllllIlIIIllIIllIIlIllI, final float llllllllllllllIlIIIllIIllIIIllII, final float llllllllllllllIlIIIllIIllIIIlIll, final float llllllllllllllIlIIIllIIllIIlIIll, final float llllllllllllllIlIIIllIIllIIlIIlI) {
        super.render(llllllllllllllIlIIIllIIllIIllIII, llllllllllllllIlIIIllIIllIIlIlll, llllllllllllllIlIIIllIIllIIlIllI, llllllllllllllIlIIIllIIllIIIllII, llllllllllllllIlIIIllIIllIIIlIll, llllllllllllllIlIIIllIIllIIlIIll, llllllllllllllIlIIIllIIllIIlIIlI);
        GlStateManager.pushMatrix();
        if (this.isChild) {
            final float llllllllllllllIlIIIllIIllIIlIIIl = 2.0f;
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllIlIIIllIIllIIlIIlI, 0.0f);
            this.standRightSide.render(llllllllllllllIlIIIllIIllIIlIIlI);
            this.standLeftSide.render(llllllllllllllIlIIIllIIllIIlIIlI);
            this.standWaist.render(llllllllllllllIlIIIllIIllIIlIIlI);
            this.standBase.render(llllllllllllllIlIIIllIIllIIlIIlI);
        }
        else {
            if (llllllllllllllIlIIIllIIllIIllIII.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            this.standRightSide.render(llllllllllllllIlIIIllIIllIIlIIlI);
            this.standLeftSide.render(llllllllllllllIlIIIllIIllIIlIIlI);
            this.standWaist.render(llllllllllllllIlIIIllIIllIIlIIlI);
            this.standBase.render(llllllllllllllIlIIIllIIllIIlIIlI);
        }
        GlStateManager.popMatrix();
    }
    
    public ModelArmorStand(final float llllllllllllllIlIIIllIIllIlllllI) {
        super(llllllllllllllIlIIIllIIllIlllllI, 64, 64);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-1.0f, -7.0f, -1.0f, 2, 7, 2, llllllllllllllIlIIIllIIllIlllllI);
        this.bipedHead.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedBody = new ModelRenderer(this, 0, 26);
        this.bipedBody.addBox(-6.0f, 0.0f, -1.5f, 12, 3, 3, llllllllllllllIlIIIllIIllIlllllI);
        this.bipedBody.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedRightArm = new ModelRenderer(this, 24, 0);
        this.bipedRightArm.addBox(-2.0f, -2.0f, -1.0f, 2, 12, 2, llllllllllllllIlIIIllIIllIlllllI);
        this.bipedRightArm.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.bipedLeftArm = new ModelRenderer(this, 32, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(0.0f, -2.0f, -1.0f, 2, 12, 2, llllllllllllllIlIIIllIIllIlllllI);
        this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
        this.bipedRightLeg = new ModelRenderer(this, 8, 0);
        this.bipedRightLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2, llllllllllllllIlIIIllIIllIlllllI);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(this, 40, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2, llllllllllllllIlIIIllIIllIlllllI);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f, 0.0f);
        this.standRightSide = new ModelRenderer(this, 16, 0);
        this.standRightSide.addBox(-3.0f, 3.0f, -1.0f, 2, 7, 2, llllllllllllllIlIIIllIIllIlllllI);
        this.standRightSide.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.standRightSide.showModel = true;
        this.standLeftSide = new ModelRenderer(this, 48, 16);
        this.standLeftSide.addBox(1.0f, 3.0f, -1.0f, 2, 7, 2, llllllllllllllIlIIIllIIllIlllllI);
        this.standLeftSide.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.standWaist = new ModelRenderer(this, 0, 48);
        this.standWaist.addBox(-4.0f, 10.0f, -1.0f, 8, 2, 2, llllllllllllllIlIIIllIIllIlllllI);
        this.standWaist.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.standBase = new ModelRenderer(this, 0, 32);
        this.standBase.addBox(-6.0f, 11.0f, -6.0f, 12, 1, 12, llllllllllllllIlIIIllIIllIlllllI);
        this.standBase.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.bipedHeadwear.showModel = false;
    }
    
    @Override
    public void postRenderArm(final float llllllllllllllIlIIIllIIlIlllllII, final EnumHandSide llllllllllllllIlIIIllIIlIllllIll) {
        final ModelRenderer llllllllllllllIlIIIllIIlIlllllll = this.getArmForSide(llllllllllllllIlIIIllIIlIllllIll);
        final boolean llllllllllllllIlIIIllIIlIllllllI = llllllllllllllIlIIIllIIlIlllllll.showModel;
        llllllllllllllIlIIIllIIlIlllllll.showModel = true;
        super.postRenderArm(llllllllllllllIlIIIllIIlIlllllII, llllllllllllllIlIIIllIIlIllllIll);
        llllllllllllllIlIIIllIIlIlllllll.showModel = llllllllllllllIlIIIllIIlIllllllI;
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIlIIIllIIllIllIIll, final float llllllllllllllIlIIIllIIllIlIlIIl, final float llllllllllllllIlIIIllIIllIlIlIII, final float llllllllllllllIlIIIllIIllIlIIlll, final float llllllllllllllIlIIIllIIllIlIllll, final float llllllllllllllIlIIIllIIllIlIIlIl, final Entity llllllllllllllIlIIIllIIllIlIIlII) {
        super.setRotationAngles(llllllllllllllIlIIIllIIllIllIIll, llllllllllllllIlIIIllIIllIlIlIIl, llllllllllllllIlIIIllIIllIlIlIII, llllllllllllllIlIIIllIIllIlIIlll, llllllllllllllIlIIIllIIllIlIllll, llllllllllllllIlIIIllIIllIlIIlIl, llllllllllllllIlIIIllIIllIlIIlII);
        if (llllllllllllllIlIIIllIIllIlIIlII instanceof EntityArmorStand) {
            final EntityArmorStand llllllllllllllIlIIIllIIllIlIllII = (EntityArmorStand)llllllllllllllIlIIIllIIllIlIIlII;
            this.bipedLeftArm.showModel = llllllllllllllIlIIIllIIllIlIllII.getShowArms();
            this.bipedRightArm.showModel = llllllllllllllIlIIIllIIllIlIllII.getShowArms();
            this.standBase.showModel = !llllllllllllllIlIIIllIIllIlIllII.hasNoBasePlate();
            this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f, 0.0f);
            this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f, 0.0f);
            this.standRightSide.rotateAngleX = 0.017453292f * llllllllllllllIlIIIllIIllIlIllII.getBodyRotation().getX();
            this.standRightSide.rotateAngleY = 0.017453292f * llllllllllllllIlIIIllIIllIlIllII.getBodyRotation().getY();
            this.standRightSide.rotateAngleZ = 0.017453292f * llllllllllllllIlIIIllIIllIlIllII.getBodyRotation().getZ();
            this.standLeftSide.rotateAngleX = 0.017453292f * llllllllllllllIlIIIllIIllIlIllII.getBodyRotation().getX();
            this.standLeftSide.rotateAngleY = 0.017453292f * llllllllllllllIlIIIllIIllIlIllII.getBodyRotation().getY();
            this.standLeftSide.rotateAngleZ = 0.017453292f * llllllllllllllIlIIIllIIllIlIllII.getBodyRotation().getZ();
            this.standWaist.rotateAngleX = 0.017453292f * llllllllllllllIlIIIllIIllIlIllII.getBodyRotation().getX();
            this.standWaist.rotateAngleY = 0.017453292f * llllllllllllllIlIIIllIIllIlIllII.getBodyRotation().getY();
            this.standWaist.rotateAngleZ = 0.017453292f * llllllllllllllIlIIIllIIllIlIllII.getBodyRotation().getZ();
            this.standBase.rotateAngleX = 0.0f;
            this.standBase.rotateAngleY = 0.017453292f * -llllllllllllllIlIIIllIIllIlIIlII.rotationYaw;
            this.standBase.rotateAngleZ = 0.0f;
        }
    }
    
    public ModelArmorStand() {
        this(0.0f);
    }
}
