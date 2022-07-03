package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class ModelPlayer extends ModelBiped
{
    private final /* synthetic */ boolean smallArms;
    public /* synthetic */ ModelRenderer bipedLeftLegwear;
    private final /* synthetic */ ModelRenderer bipedDeadmau5Head;
    public /* synthetic */ ModelRenderer bipedLeftArmwear;
    public /* synthetic */ ModelRenderer bipedRightLegwear;
    public /* synthetic */ ModelRenderer bipedRightArmwear;
    private final /* synthetic */ ModelRenderer bipedCape;
    public /* synthetic */ ModelRenderer bipedBodyWear;
    
    public void renderDeadmau5Head(final float llllllllllllllIlllIlIIlIlIlIIllI) {
        ModelBase.copyModelAngles(this.bipedHead, this.bipedDeadmau5Head);
        this.bipedDeadmau5Head.rotationPointX = 0.0f;
        this.bipedDeadmau5Head.rotationPointY = 0.0f;
        this.bipedDeadmau5Head.render(llllllllllllllIlllIlIIlIlIlIIllI);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIlllIlIIlIlIIlIllI, final float llllllllllllllIlllIlIIlIlIIIllIl, final float llllllllllllllIlllIlIIlIlIIIllII, final float llllllllllllllIlllIlIIlIlIIIlIll, final float llllllllllllllIlllIlIIlIlIIlIIlI, final float llllllllllllllIlllIlIIlIlIIlIIIl, final Entity llllllllllllllIlllIlIIlIlIIIlIII) {
        super.setRotationAngles(llllllllllllllIlllIlIIlIlIIlIllI, llllllllllllllIlllIlIIlIlIIIllIl, llllllllllllllIlllIlIIlIlIIIllII, llllllllllllllIlllIlIIlIlIIIlIll, llllllllllllllIlllIlIIlIlIIlIIlI, llllllllllllllIlllIlIIlIlIIlIIIl, llllllllllllllIlllIlIIlIlIIIlIII);
        ModelBase.copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
        ModelBase.copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
        ModelBase.copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
        ModelBase.copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
        ModelBase.copyModelAngles(this.bipedBody, this.bipedBodyWear);
    }
    
    public ModelPlayer(final float llllllllllllllIlllIlIIlIllIIlIll, final boolean llllllllllllllIlllIlIIlIllIIlIlI) {
        super(llllllllllllllIlllIlIIlIllIIlIll, 0.0f, 64, 64);
        this.smallArms = llllllllllllllIlllIlIIlIllIIlIlI;
        this.bipedDeadmau5Head = new ModelRenderer(this, 24, 0);
        this.bipedDeadmau5Head.addBox(-3.0f, -6.0f, -1.0f, 6, 6, 1, llllllllllllllIlllIlIIlIllIIlIll);
        this.bipedCape = new ModelRenderer(this, 0, 0);
        this.bipedCape.setTextureSize(64, 32);
        this.bipedCape.addBox(-5.0f, 0.0f, -1.0f, 10, 16, 1, llllllllllllllIlllIlIIlIllIIlIll);
        if (llllllllllllllIlllIlIIlIllIIlIlI) {
            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 3, 12, 4, llllllllllllllIlllIlIIlIllIIlIll);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.5f, 0.0f);
            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-2.0f, -2.0f, -2.0f, 3, 12, 4, llllllllllllllIlllIlIIlIllIIlIll);
            this.bipedRightArm.setRotationPoint(-5.0f, 2.5f, 0.0f);
            this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
            this.bipedLeftArmwear.addBox(-1.0f, -2.0f, -2.0f, 3, 12, 4, llllllllllllllIlllIlIIlIllIIlIll + 0.25f);
            this.bipedLeftArmwear.setRotationPoint(5.0f, 2.5f, 0.0f);
            this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
            this.bipedRightArmwear.addBox(-2.0f, -2.0f, -2.0f, 3, 12, 4, llllllllllllllIlllIlIIlIllIIlIll + 0.25f);
            this.bipedRightArmwear.setRotationPoint(-5.0f, 2.5f, 10.0f);
        }
        else {
            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllllllIlllIlIIlIllIIlIll);
            this.bipedLeftArm.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
            this.bipedLeftArmwear.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllllllIlllIlIIlIllIIlIll + 0.25f);
            this.bipedLeftArmwear.setRotationPoint(5.0f, 2.0f, 0.0f);
            this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
            this.bipedRightArmwear.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, llllllllllllllIlllIlIIlIllIIlIll + 0.25f);
            this.bipedRightArmwear.setRotationPoint(-5.0f, 2.0f, 10.0f);
        }
        this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllIlllIlIIlIllIIlIll);
        this.bipedLeftLeg.setRotationPoint(1.9f, 12.0f, 0.0f);
        this.bipedLeftLegwear = new ModelRenderer(this, 0, 48);
        this.bipedLeftLegwear.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllIlllIlIIlIllIIlIll + 0.25f);
        this.bipedLeftLegwear.setRotationPoint(1.9f, 12.0f, 0.0f);
        this.bipedRightLegwear = new ModelRenderer(this, 0, 32);
        this.bipedRightLegwear.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllIlllIlIIlIllIIlIll + 0.25f);
        this.bipedRightLegwear.setRotationPoint(-1.9f, 12.0f, 0.0f);
        this.bipedBodyWear = new ModelRenderer(this, 16, 32);
        this.bipedBodyWear.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, llllllllllllllIlllIlIIlIllIIlIll + 0.25f);
        this.bipedBodyWear.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity llllllllllllllIlllIlIIlIlIllIIll, final float llllllllllllllIlllIlIIlIlIllIIlI, final float llllllllllllllIlllIlIIlIlIllIIIl, final float llllllllllllllIlllIlIIlIlIlllIIl, final float llllllllllllllIlllIlIIlIlIlIllll, final float llllllllllllllIlllIlIIlIlIllIlll, final float llllllllllllllIlllIlIIlIlIlIllIl) {
        super.render(llllllllllllllIlllIlIIlIlIllIIll, llllllllllllllIlllIlIIlIlIllIIlI, llllllllllllllIlllIlIIlIlIllIIIl, llllllllllllllIlllIlIIlIlIlllIIl, llllllllllllllIlllIlIIlIlIlIllll, llllllllllllllIlllIlIIlIlIllIlll, llllllllllllllIlllIlIIlIlIlIllIl);
        GlStateManager.pushMatrix();
        if (this.isChild) {
            final float llllllllllllllIlllIlIIlIlIllIlIl = 2.0f;
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            GlStateManager.translate(0.0f, 24.0f * llllllllllllllIlllIlIIlIlIlIllIl, 0.0f);
            this.bipedLeftLegwear.render(llllllllllllllIlllIlIIlIlIlIllIl);
            this.bipedRightLegwear.render(llllllllllllllIlllIlIIlIlIlIllIl);
            this.bipedLeftArmwear.render(llllllllllllllIlllIlIIlIlIlIllIl);
            this.bipedRightArmwear.render(llllllllllllllIlllIlIIlIlIlIllIl);
            this.bipedBodyWear.render(llllllllllllllIlllIlIIlIlIlIllIl);
        }
        else {
            if (llllllllllllllIlllIlIIlIlIllIIll.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            this.bipedLeftLegwear.render(llllllllllllllIlllIlIIlIlIlIllIl);
            this.bipedRightLegwear.render(llllllllllllllIlllIlIIlIlIlIllIl);
            this.bipedLeftArmwear.render(llllllllllllllIlllIlIIlIlIlIllIl);
            this.bipedRightArmwear.render(llllllllllllllIlllIlIIlIlIlIllIl);
            this.bipedBodyWear.render(llllllllllllllIlllIlIIlIlIlIllIl);
        }
        GlStateManager.popMatrix();
    }
    
    @Override
    public void setInvisible(final boolean llllllllllllllIlllIlIIlIlIIIIIlI) {
        super.setInvisible(llllllllllllllIlllIlIIlIlIIIIIlI);
        this.bipedLeftArmwear.showModel = false;
        this.bipedRightArmwear.showModel = false;
        this.bipedLeftLegwear.showModel = false;
        this.bipedRightLegwear.showModel = false;
        this.bipedBodyWear.showModel = false;
        this.bipedCape.showModel = false;
        this.bipedDeadmau5Head.showModel = false;
    }
    
    @Override
    public void postRenderArm(final float llllllllllllllIlllIlIIlIIlllIllI, final EnumHandSide llllllllllllllIlllIlIIlIIlllIlIl) {
        final ModelRenderer llllllllllllllIlllIlIIlIIllllIIl = this.getArmForSide(llllllllllllllIlllIlIIlIIlllIlIl);
        if (this.smallArms) {
            final float llllllllllllllIlllIlIIlIIllllIII = 0.5f * ((llllllllllllllIlllIlIIlIIlllIlIl == EnumHandSide.RIGHT) ? 1 : -1);
            final ModelRenderer modelRenderer = llllllllllllllIlllIlIIlIIllllIIl;
            modelRenderer.rotationPointX += llllllllllllllIlllIlIIlIIllllIII;
            llllllllllllllIlllIlIIlIIllllIIl.postRender(llllllllllllllIlllIlIIlIIlllIllI);
            final ModelRenderer modelRenderer2 = llllllllllllllIlllIlIIlIIllllIIl;
            modelRenderer2.rotationPointX -= llllllllllllllIlllIlIIlIIllllIII;
        }
        else {
            llllllllllllllIlllIlIIlIIllllIIl.postRender(llllllllllllllIlllIlIIlIIlllIllI);
        }
    }
    
    public void renderCape(final float llllllllllllllIlllIlIIlIlIlIIIlI) {
        this.bipedCape.render(llllllllllllllIlllIlIIlIlIlIIIlI);
    }
}
