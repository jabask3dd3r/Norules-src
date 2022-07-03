package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelVillager extends ModelBase
{
    public /* synthetic */ ModelRenderer villagerHead;
    public /* synthetic */ ModelRenderer rightVillagerLeg;
    public /* synthetic */ ModelRenderer villagerNose;
    public /* synthetic */ ModelRenderer villagerBody;
    public /* synthetic */ ModelRenderer villagerArms;
    public /* synthetic */ ModelRenderer leftVillagerLeg;
    
    @Override
    public void render(final Entity llllllllllllllIIIIlIIlllIllIIlll, final float llllllllllllllIIIIlIIlllIllIIllI, final float llllllllllllllIIIIlIIlllIllIIlIl, final float llllllllllllllIIIIlIIlllIllIIlII, final float llllllllllllllIIIIlIIlllIllIIIll, final float llllllllllllllIIIIlIIlllIllIlIlI, final float llllllllllllllIIIIlIIlllIllIlIIl) {
        this.setRotationAngles(llllllllllllllIIIIlIIlllIllIIllI, llllllllllllllIIIIlIIlllIllIIlIl, llllllllllllllIIIIlIIlllIllIIlII, llllllllllllllIIIIlIIlllIllIIIll, llllllllllllllIIIIlIIlllIllIlIlI, llllllllllllllIIIIlIIlllIllIlIIl, llllllllllllllIIIIlIIlllIllIIlll);
        this.villagerHead.render(llllllllllllllIIIIlIIlllIllIlIIl);
        this.villagerBody.render(llllllllllllllIIIIlIIlllIllIlIIl);
        this.rightVillagerLeg.render(llllllllllllllIIIIlIIlllIllIlIIl);
        this.leftVillagerLeg.render(llllllllllllllIIIIlIIlllIllIlIIl);
        this.villagerArms.render(llllllllllllllIIIIlIIlllIllIlIIl);
    }
    
    public ModelVillager(final float llllllllllllllIIIIlIIllllIIIlIlI) {
        this(llllllllllllllIIIIlIIllllIIIlIlI, 0.0f, 64, 64);
    }
    
    public ModelVillager(final float llllllllllllllIIIIlIIllllIIIIIIl, final float llllllllllllllIIIIlIIllllIIIIIII, final int llllllllllllllIIIIlIIlllIllllIlI, final int llllllllllllllIIIIlIIlllIllllIIl) {
        this.villagerHead = new ModelRenderer(this).setTextureSize(llllllllllllllIIIIlIIlllIllllIlI, llllllllllllllIIIIlIIlllIllllIIl);
        this.villagerHead.setRotationPoint(0.0f, 0.0f + llllllllllllllIIIIlIIllllIIIIIII, 0.0f);
        this.villagerHead.setTextureOffset(0, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, llllllllllllllIIIIlIIllllIIIIIIl);
        this.villagerNose = new ModelRenderer(this).setTextureSize(llllllllllllllIIIIlIIlllIllllIlI, llllllllllllllIIIIlIIlllIllllIIl);
        this.villagerNose.setRotationPoint(0.0f, llllllllllllllIIIIlIIllllIIIIIII - 2.0f, 0.0f);
        this.villagerNose.setTextureOffset(24, 0).addBox(-1.0f, -1.0f, -6.0f, 2, 4, 2, llllllllllllllIIIIlIIllllIIIIIIl);
        this.villagerHead.addChild(this.villagerNose);
        this.villagerBody = new ModelRenderer(this).setTextureSize(llllllllllllllIIIIlIIlllIllllIlI, llllllllllllllIIIIlIIlllIllllIIl);
        this.villagerBody.setRotationPoint(0.0f, 0.0f + llllllllllllllIIIIlIIllllIIIIIII, 0.0f);
        this.villagerBody.setTextureOffset(16, 20).addBox(-4.0f, 0.0f, -3.0f, 8, 12, 6, llllllllllllllIIIIlIIllllIIIIIIl);
        this.villagerBody.setTextureOffset(0, 38).addBox(-4.0f, 0.0f, -3.0f, 8, 18, 6, llllllllllllllIIIIlIIllllIIIIIIl + 0.5f);
        this.villagerArms = new ModelRenderer(this).setTextureSize(llllllllllllllIIIIlIIlllIllllIlI, llllllllllllllIIIIlIIlllIllllIIl);
        this.villagerArms.setRotationPoint(0.0f, 0.0f + llllllllllllllIIIIlIIllllIIIIIII + 2.0f, 0.0f);
        this.villagerArms.setTextureOffset(44, 22).addBox(-8.0f, -2.0f, -2.0f, 4, 8, 4, llllllllllllllIIIIlIIllllIIIIIIl);
        this.villagerArms.setTextureOffset(44, 22).addBox(4.0f, -2.0f, -2.0f, 4, 8, 4, llllllllllllllIIIIlIIllllIIIIIIl);
        this.villagerArms.setTextureOffset(40, 38).addBox(-4.0f, 2.0f, -2.0f, 8, 4, 4, llllllllllllllIIIIlIIllllIIIIIIl);
        this.rightVillagerLeg = new ModelRenderer(this, 0, 22).setTextureSize(llllllllllllllIIIIlIIlllIllllIlI, llllllllllllllIIIIlIIlllIllllIIl);
        this.rightVillagerLeg.setRotationPoint(-2.0f, 12.0f + llllllllllllllIIIIlIIllllIIIIIII, 0.0f);
        this.rightVillagerLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllIIIIlIIllllIIIIIIl);
        this.leftVillagerLeg = new ModelRenderer(this, 0, 22).setTextureSize(llllllllllllllIIIIlIIlllIllllIlI, llllllllllllllIIIIlIIlllIllllIIl);
        this.leftVillagerLeg.mirror = true;
        this.leftVillagerLeg.setRotationPoint(2.0f, 12.0f + llllllllllllllIIIIlIIllllIIIIIII, 0.0f);
        this.leftVillagerLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, llllllllllllllIIIIlIIllllIIIIIIl);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIIlIIlllIlIlIIlI, final float llllllllllllllIIIIlIIlllIlIllIIl, final float llllllllllllllIIIIlIIlllIlIllIII, final float llllllllllllllIIIIlIIlllIlIlIlll, final float llllllllllllllIIIIlIIlllIlIIllll, final float llllllllllllllIIIIlIIlllIlIlIlIl, final Entity llllllllllllllIIIIlIIlllIlIlIlII) {
        this.villagerHead.rotateAngleY = llllllllllllllIIIIlIIlllIlIlIlll * 0.017453292f;
        this.villagerHead.rotateAngleX = llllllllllllllIIIIlIIlllIlIIllll * 0.017453292f;
        this.villagerArms.rotationPointY = 3.0f;
        this.villagerArms.rotationPointZ = -1.0f;
        this.villagerArms.rotateAngleX = -0.75f;
        this.rightVillagerLeg.rotateAngleX = MathHelper.cos(llllllllllllllIIIIlIIlllIlIlIIlI * 0.6662f) * 1.4f * llllllllllllllIIIIlIIlllIlIllIIl * 0.5f;
        this.leftVillagerLeg.rotateAngleX = MathHelper.cos(llllllllllllllIIIIlIIlllIlIlIIlI * 0.6662f + 3.1415927f) * 1.4f * llllllllllllllIIIIlIIlllIlIllIIl * 0.5f;
        this.rightVillagerLeg.rotateAngleY = 0.0f;
        this.leftVillagerLeg.rotateAngleY = 0.0f;
    }
}
