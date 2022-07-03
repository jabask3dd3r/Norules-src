package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.boss.*;

public class ModelDragon extends ModelBase
{
    private final /* synthetic */ ModelRenderer frontFoot;
    private /* synthetic */ float partialTicks;
    private final /* synthetic */ ModelRenderer frontLeg;
    private final /* synthetic */ ModelRenderer rearLegTip;
    private final /* synthetic */ ModelRenderer wingTip;
    private final /* synthetic */ ModelRenderer body;
    private final /* synthetic */ ModelRenderer jaw;
    private final /* synthetic */ ModelRenderer head;
    private final /* synthetic */ ModelRenderer rearLeg;
    private final /* synthetic */ ModelRenderer frontLegTip;
    private final /* synthetic */ ModelRenderer wing;
    private final /* synthetic */ ModelRenderer spine;
    private final /* synthetic */ ModelRenderer rearFoot;
    
    public ModelDragon(final float lllllllllllllIIIlIllIlIlIIIllIIl) {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.setTextureOffset("body.body", 0, 0);
        this.setTextureOffset("wing.skin", -56, 88);
        this.setTextureOffset("wingtip.skin", -56, 144);
        this.setTextureOffset("rearleg.main", 0, 0);
        this.setTextureOffset("rearfoot.main", 112, 0);
        this.setTextureOffset("rearlegtip.main", 196, 0);
        this.setTextureOffset("head.upperhead", 112, 30);
        this.setTextureOffset("wing.bone", 112, 88);
        this.setTextureOffset("head.upperlip", 176, 44);
        this.setTextureOffset("jaw.jaw", 176, 65);
        this.setTextureOffset("frontleg.main", 112, 104);
        this.setTextureOffset("wingtip.bone", 112, 136);
        this.setTextureOffset("frontfoot.main", 144, 104);
        this.setTextureOffset("neck.box", 192, 104);
        this.setTextureOffset("frontlegtip.main", 226, 138);
        this.setTextureOffset("body.scale", 220, 53);
        this.setTextureOffset("head.scale", 0, 0);
        this.setTextureOffset("neck.scale", 48, 0);
        this.setTextureOffset("head.nostril", 112, 0);
        final float lllllllllllllIIIlIllIlIlIIIllIII = -16.0f;
        this.head = new ModelRenderer(this, "head");
        this.head.addBox("upperlip", -6.0f, -1.0f, -24.0f, 12, 5, 16);
        this.head.addBox("upperhead", -8.0f, -8.0f, -10.0f, 16, 16, 16);
        this.head.mirror = true;
        this.head.addBox("scale", -5.0f, -12.0f, -4.0f, 2, 4, 6);
        this.head.addBox("nostril", -5.0f, -3.0f, -22.0f, 2, 2, 4);
        this.head.mirror = false;
        this.head.addBox("scale", 3.0f, -12.0f, -4.0f, 2, 4, 6);
        this.head.addBox("nostril", 3.0f, -3.0f, -22.0f, 2, 2, 4);
        this.jaw = new ModelRenderer(this, "jaw");
        this.jaw.setRotationPoint(0.0f, 4.0f, -8.0f);
        this.jaw.addBox("jaw", -6.0f, 0.0f, -16.0f, 12, 4, 16);
        this.head.addChild(this.jaw);
        this.spine = new ModelRenderer(this, "neck");
        this.spine.addBox("box", -5.0f, -5.0f, -5.0f, 10, 10, 10);
        this.spine.addBox("scale", -1.0f, -9.0f, -3.0f, 2, 4, 6);
        this.body = new ModelRenderer(this, "body");
        this.body.setRotationPoint(0.0f, 4.0f, 8.0f);
        this.body.addBox("body", -12.0f, 0.0f, -16.0f, 24, 24, 64);
        this.body.addBox("scale", -1.0f, -6.0f, -10.0f, 2, 6, 12);
        this.body.addBox("scale", -1.0f, -6.0f, 10.0f, 2, 6, 12);
        this.body.addBox("scale", -1.0f, -6.0f, 30.0f, 2, 6, 12);
        this.wing = new ModelRenderer(this, "wing");
        this.wing.setRotationPoint(-12.0f, 5.0f, 2.0f);
        this.wing.addBox("bone", -56.0f, -4.0f, -4.0f, 56, 8, 8);
        this.wing.addBox("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wingTip = new ModelRenderer(this, "wingtip");
        this.wingTip.setRotationPoint(-56.0f, 0.0f, 0.0f);
        this.wingTip.addBox("bone", -56.0f, -2.0f, -2.0f, 56, 4, 4);
        this.wingTip.addBox("skin", -56.0f, 0.0f, 2.0f, 56, 0, 56);
        this.wing.addChild(this.wingTip);
        this.frontLeg = new ModelRenderer(this, "frontleg");
        this.frontLeg.setRotationPoint(-12.0f, 20.0f, 2.0f);
        this.frontLeg.addBox("main", -4.0f, -4.0f, -4.0f, 8, 24, 8);
        this.frontLegTip = new ModelRenderer(this, "frontlegtip");
        this.frontLegTip.setRotationPoint(0.0f, 20.0f, -1.0f);
        this.frontLegTip.addBox("main", -3.0f, -1.0f, -3.0f, 6, 24, 6);
        this.frontLeg.addChild(this.frontLegTip);
        this.frontFoot = new ModelRenderer(this, "frontfoot");
        this.frontFoot.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.frontFoot.addBox("main", -4.0f, 0.0f, -12.0f, 8, 4, 16);
        this.frontLegTip.addChild(this.frontFoot);
        this.rearLeg = new ModelRenderer(this, "rearleg");
        this.rearLeg.setRotationPoint(-16.0f, 16.0f, 42.0f);
        this.rearLeg.addBox("main", -8.0f, -4.0f, -8.0f, 16, 32, 16);
        this.rearLegTip = new ModelRenderer(this, "rearlegtip");
        this.rearLegTip.setRotationPoint(0.0f, 32.0f, -4.0f);
        this.rearLegTip.addBox("main", -6.0f, -2.0f, 0.0f, 12, 32, 12);
        this.rearLeg.addChild(this.rearLegTip);
        this.rearFoot = new ModelRenderer(this, "rearfoot");
        this.rearFoot.setRotationPoint(0.0f, 31.0f, 4.0f);
        this.rearFoot.addBox("main", -9.0f, 0.0f, -20.0f, 18, 6, 24);
        this.rearLegTip.addChild(this.rearFoot);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllIIIlIllIlIlIIIlIIlI, final float lllllllllllllIIIlIllIlIlIIIlIIIl, final float lllllllllllllIIIlIllIlIlIIIlIIII, final float lllllllllllllIIIlIllIlIlIIIIllll) {
        this.partialTicks = lllllllllllllIIIlIllIlIlIIIIllll;
    }
    
    private float updateRotations(double lllllllllllllIIIlIllIlIIllIIllII) {
        while (lllllllllllllIIIlIllIlIIllIIllII >= 180.0) {
            lllllllllllllIIIlIllIlIIllIIllII -= 360.0;
        }
        while (lllllllllllllIIIlIllIlIIllIIllII < -180.0) {
            lllllllllllllIIIlIllIlIIllIIllII += 360.0;
        }
        return (float)lllllllllllllIIIlIllIlIIllIIllII;
    }
    
    @Override
    public void render(final Entity lllllllllllllIIIlIllIlIIllIlllll, final float lllllllllllllIIIlIllIlIIlllllIIl, final float lllllllllllllIIIlIllIlIIlllllIII, final float lllllllllllllIIIlIllIlIIllllIlll, final float lllllllllllllIIIlIllIlIIllllIllI, final float lllllllllllllIIIlIllIlIIllllIlIl, final float lllllllllllllIIIlIllIlIIllllIlII) {
        GlStateManager.pushMatrix();
        final EntityDragon lllllllllllllIIIlIllIlIIllllIIll = (EntityDragon)lllllllllllllIIIlIllIlIIllIlllll;
        final float lllllllllllllIIIlIllIlIIllllIIlI = lllllllllllllIIIlIllIlIIllllIIll.prevAnimTime + (lllllllllllllIIIlIllIlIIllllIIll.animTime - lllllllllllllIIIlIllIlIIllllIIll.prevAnimTime) * this.partialTicks;
        this.jaw.rotateAngleX = (float)(Math.sin(lllllllllllllIIIlIllIlIIllllIIlI * 6.2831855f) + 1.0) * 0.2f;
        float lllllllllllllIIIlIllIlIIllllIIIl = (float)(Math.sin(lllllllllllllIIIlIllIlIIllllIIlI * 6.2831855f - 1.0f) + 1.0);
        lllllllllllllIIIlIllIlIIllllIIIl = (lllllllllllllIIIlIllIlIIllllIIIl * lllllllllllllIIIlIllIlIIllllIIIl + lllllllllllllIIIlIllIlIIllllIIIl * 2.0f) * 0.05f;
        GlStateManager.translate(0.0f, lllllllllllllIIIlIllIlIIllllIIIl - 2.0f, -3.0f);
        GlStateManager.rotate(lllllllllllllIIIlIllIlIIllllIIIl * 2.0f, 1.0f, 0.0f, 0.0f);
        float lllllllllllllIIIlIllIlIIllllIIII = -30.0f;
        float lllllllllllllIIIlIllIlIIlllIllll = 0.0f;
        final float lllllllllllllIIIlIllIlIIlllIlllI = 1.5f;
        double[] lllllllllllllIIIlIllIlIIlllIllIl = lllllllllllllIIIlIllIlIIllllIIll.getMovementOffsets(6, this.partialTicks);
        final float lllllllllllllIIIlIllIlIIlllIllII = this.updateRotations(lllllllllllllIIIlIllIlIIllllIIll.getMovementOffsets(5, this.partialTicks)[0] - lllllllllllllIIIlIllIlIIllllIIll.getMovementOffsets(10, this.partialTicks)[0]);
        final float lllllllllllllIIIlIllIlIIlllIlIll = this.updateRotations(lllllllllllllIIIlIllIlIIllllIIll.getMovementOffsets(5, this.partialTicks)[0] + lllllllllllllIIIlIllIlIIlllIllII / 2.0f);
        float lllllllllllllIIIlIllIlIIlllIlIlI = lllllllllllllIIIlIllIlIIllllIIlI * 6.2831855f;
        lllllllllllllIIIlIllIlIIllllIIII = 20.0f;
        float lllllllllllllIIIlIllIlIIlllIlIIl = -12.0f;
        for (int lllllllllllllIIIlIllIlIIlllIlIII = 0; lllllllllllllIIIlIllIlIIlllIlIII < 5; ++lllllllllllllIIIlIllIlIIlllIlIII) {
            final double[] lllllllllllllIIIlIllIlIIlllIIlll = lllllllllllllIIIlIllIlIIllllIIll.getMovementOffsets(5 - lllllllllllllIIIlIllIlIIlllIlIII, this.partialTicks);
            final float lllllllllllllIIIlIllIlIIlllIIllI = (float)Math.cos(lllllllllllllIIIlIllIlIIlllIlIII * 0.45f + lllllllllllllIIIlIllIlIIlllIlIlI) * 0.15f;
            this.spine.rotateAngleY = this.updateRotations(lllllllllllllIIIlIllIlIIlllIIlll[0] - lllllllllllllIIIlIllIlIIlllIllIl[0]) * 0.017453292f * 1.5f;
            this.spine.rotateAngleX = lllllllllllllIIIlIllIlIIlllIIllI + lllllllllllllIIIlIllIlIIllllIIll.getHeadPartYOffset(lllllllllllllIIIlIllIlIIlllIlIII, lllllllllllllIIIlIllIlIIlllIllIl, lllllllllllllIIIlIllIlIIlllIIlll) * 0.017453292f * 1.5f * 5.0f;
            this.spine.rotateAngleZ = -this.updateRotations(lllllllllllllIIIlIllIlIIlllIIlll[0] - lllllllllllllIIIlIllIlIIlllIlIll) * 0.017453292f * 1.5f;
            this.spine.rotationPointY = lllllllllllllIIIlIllIlIIllllIIII;
            this.spine.rotationPointZ = lllllllllllllIIIlIllIlIIlllIlIIl;
            this.spine.rotationPointX = lllllllllllllIIIlIllIlIIlllIllll;
            lllllllllllllIIIlIllIlIIllllIIII += (float)(Math.sin(this.spine.rotateAngleX) * 10.0);
            lllllllllllllIIIlIllIlIIlllIlIIl -= (float)(Math.cos(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            lllllllllllllIIIlIllIlIIlllIllll -= (float)(Math.sin(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            this.spine.render(lllllllllllllIIIlIllIlIIllllIlII);
        }
        this.head.rotationPointY = lllllllllllllIIIlIllIlIIllllIIII;
        this.head.rotationPointZ = lllllllllllllIIIlIllIlIIlllIlIIl;
        this.head.rotationPointX = lllllllllllllIIIlIllIlIIlllIllll;
        double[] lllllllllllllIIIlIllIlIIlllIIlIl = lllllllllllllIIIlIllIlIIllllIIll.getMovementOffsets(0, this.partialTicks);
        this.head.rotateAngleY = this.updateRotations(lllllllllllllIIIlIllIlIIlllIIlIl[0] - lllllllllllllIIIlIllIlIIlllIllIl[0]) * 0.017453292f;
        this.head.rotateAngleX = this.updateRotations(lllllllllllllIIIlIllIlIIllllIIll.getHeadPartYOffset(6, lllllllllllllIIIlIllIlIIlllIllIl, lllllllllllllIIIlIllIlIIlllIIlIl)) * 0.017453292f * 1.5f * 5.0f;
        this.head.rotateAngleZ = -this.updateRotations(lllllllllllllIIIlIllIlIIlllIIlIl[0] - lllllllllllllIIIlIllIlIIlllIlIll) * 0.017453292f;
        this.head.render(lllllllllllllIIIlIllIlIIllllIlII);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-lllllllllllllIIIlIllIlIIlllIllII * 1.5f, 0.0f, 0.0f, 1.0f);
        GlStateManager.translate(0.0f, -1.0f, 0.0f);
        this.body.rotateAngleZ = 0.0f;
        this.body.render(lllllllllllllIIIlIllIlIIllllIlII);
        for (int lllllllllllllIIIlIllIlIIlllIIlII = 0; lllllllllllllIIIlIllIlIIlllIIlII < 2; ++lllllllllllllIIIlIllIlIIlllIIlII) {
            GlStateManager.enableCull();
            final float lllllllllllllIIIlIllIlIIlllIIIll = lllllllllllllIIIlIllIlIIllllIIlI * 6.2831855f;
            this.wing.rotateAngleX = 0.125f - (float)Math.cos(lllllllllllllIIIlIllIlIIlllIIIll) * 0.2f;
            this.wing.rotateAngleY = 0.25f;
            this.wing.rotateAngleZ = (float)(Math.sin(lllllllllllllIIIlIllIlIIlllIIIll) + 0.125) * 0.8f;
            this.wingTip.rotateAngleZ = -(float)(Math.sin(lllllllllllllIIIlIllIlIIlllIIIll + 2.0f) + 0.5) * 0.75f;
            this.rearLeg.rotateAngleX = 1.0f + lllllllllllllIIIlIllIlIIllllIIIl * 0.1f;
            this.rearLegTip.rotateAngleX = 0.5f + lllllllllllllIIIlIllIlIIllllIIIl * 0.1f;
            this.rearFoot.rotateAngleX = 0.75f + lllllllllllllIIIlIllIlIIllllIIIl * 0.1f;
            this.frontLeg.rotateAngleX = 1.3f + lllllllllllllIIIlIllIlIIllllIIIl * 0.1f;
            this.frontLegTip.rotateAngleX = -0.5f - lllllllllllllIIIlIllIlIIllllIIIl * 0.1f;
            this.frontFoot.rotateAngleX = 0.75f + lllllllllllllIIIlIllIlIIllllIIIl * 0.1f;
            this.wing.render(lllllllllllllIIIlIllIlIIllllIlII);
            this.frontLeg.render(lllllllllllllIIIlIllIlIIllllIlII);
            this.rearLeg.render(lllllllllllllIIIlIllIlIIllllIlII);
            GlStateManager.scale(-1.0f, 1.0f, 1.0f);
            if (lllllllllllllIIIlIllIlIIlllIIlII == 0) {
                GlStateManager.cullFace(GlStateManager.CullFace.FRONT);
            }
        }
        GlStateManager.popMatrix();
        GlStateManager.cullFace(GlStateManager.CullFace.BACK);
        GlStateManager.disableCull();
        float lllllllllllllIIIlIllIlIIlllIIIlI = -(float)Math.sin(lllllllllllllIIIlIllIlIIllllIIlI * 6.2831855f) * 0.0f;
        lllllllllllllIIIlIllIlIIlllIlIlI = lllllllllllllIIIlIllIlIIllllIIlI * 6.2831855f;
        lllllllllllllIIIlIllIlIIllllIIII = 10.0f;
        lllllllllllllIIIlIllIlIIlllIlIIl = 60.0f;
        lllllllllllllIIIlIllIlIIlllIllll = 0.0f;
        lllllllllllllIIIlIllIlIIlllIllIl = lllllllllllllIIIlIllIlIIllllIIll.getMovementOffsets(11, this.partialTicks);
        for (int lllllllllllllIIIlIllIlIIlllIIIIl = 0; lllllllllllllIIIlIllIlIIlllIIIIl < 12; ++lllllllllllllIIIlIllIlIIlllIIIIl) {
            lllllllllllllIIIlIllIlIIlllIIlIl = lllllllllllllIIIlIllIlIIllllIIll.getMovementOffsets(12 + lllllllllllllIIIlIllIlIIlllIIIIl, this.partialTicks);
            lllllllllllllIIIlIllIlIIlllIIIlI += (float)(Math.sin(lllllllllllllIIIlIllIlIIlllIIIIl * 0.45f + lllllllllllllIIIlIllIlIIlllIlIlI) * 0.05000000074505806);
            this.spine.rotateAngleY = (this.updateRotations(lllllllllllllIIIlIllIlIIlllIIlIl[0] - lllllllllllllIIIlIllIlIIlllIllIl[0]) * 1.5f + 180.0f) * 0.017453292f;
            this.spine.rotateAngleX = lllllllllllllIIIlIllIlIIlllIIIlI + (float)(lllllllllllllIIIlIllIlIIlllIIlIl[1] - lllllllllllllIIIlIllIlIIlllIllIl[1]) * 0.017453292f * 1.5f * 5.0f;
            this.spine.rotateAngleZ = this.updateRotations(lllllllllllllIIIlIllIlIIlllIIlIl[0] - lllllllllllllIIIlIllIlIIlllIlIll) * 0.017453292f * 1.5f;
            this.spine.rotationPointY = lllllllllllllIIIlIllIlIIllllIIII;
            this.spine.rotationPointZ = lllllllllllllIIIlIllIlIIlllIlIIl;
            this.spine.rotationPointX = lllllllllllllIIIlIllIlIIlllIllll;
            lllllllllllllIIIlIllIlIIllllIIII += (float)(Math.sin(this.spine.rotateAngleX) * 10.0);
            lllllllllllllIIIlIllIlIIlllIlIIl -= (float)(Math.cos(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            lllllllllllllIIIlIllIlIIlllIllll -= (float)(Math.sin(this.spine.rotateAngleY) * Math.cos(this.spine.rotateAngleX) * 10.0);
            this.spine.render(lllllllllllllIIIlIllIlIIllllIlII);
        }
        GlStateManager.popMatrix();
    }
}
