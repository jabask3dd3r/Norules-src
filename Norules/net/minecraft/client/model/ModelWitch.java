package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelWitch extends ModelVillager
{
    private final /* synthetic */ ModelRenderer mole;
    private final /* synthetic */ ModelRenderer witchHat;
    public /* synthetic */ boolean holdingItem;
    
    @Override
    public void setRotationAngles(final float llllllllllllIlllllIIIlIlIIllIlll, final float llllllllllllIlllllIIIlIlIIllIllI, final float llllllllllllIlllllIIIlIlIIlllllI, final float llllllllllllIlllllIIIlIlIIllIlII, final float llllllllllllIlllllIIIlIlIIllllII, final float llllllllllllIlllllIIIlIlIIllIIlI, final Entity llllllllllllIlllllIIIlIlIIllIIIl) {
        super.setRotationAngles(llllllllllllIlllllIIIlIlIIllIlll, llllllllllllIlllllIIIlIlIIllIllI, llllllllllllIlllllIIIlIlIIlllllI, llllllllllllIlllllIIIlIlIIllIlII, llllllllllllIlllllIIIlIlIIllllII, llllllllllllIlllllIIIlIlIIllIIlI, llllllllllllIlllllIIIlIlIIllIIIl);
        this.villagerNose.offsetX = 0.0f;
        this.villagerNose.offsetY = 0.0f;
        this.villagerNose.offsetZ = 0.0f;
        final float llllllllllllIlllllIIIlIlIIlllIIl = 0.01f * (llllllllllllIlllllIIIlIlIIllIIIl.getEntityId() % 10);
        this.villagerNose.rotateAngleX = MathHelper.sin(llllllllllllIlllllIIIlIlIIllIIIl.ticksExisted * llllllllllllIlllllIIIlIlIIlllIIl) * 4.5f * 0.017453292f;
        this.villagerNose.rotateAngleY = 0.0f;
        this.villagerNose.rotateAngleZ = MathHelper.cos(llllllllllllIlllllIIIlIlIIllIIIl.ticksExisted * llllllllllllIlllllIIIlIlIIlllIIl) * 2.5f * 0.017453292f;
        if (this.holdingItem) {
            this.villagerNose.rotateAngleX = -0.9f;
            this.villagerNose.offsetZ = -0.09375f;
            this.villagerNose.offsetY = 0.1875f;
        }
    }
    
    public ModelWitch(final float llllllllllllIlllllIIIlIlIlIIlllI) {
        super(llllllllllllIlllllIIIlIlIlIIlllI, 0.0f, 64, 128);
        this.mole = new ModelRenderer(this).setTextureSize(64, 128);
        this.mole.setRotationPoint(0.0f, -2.0f, 0.0f);
        this.mole.setTextureOffset(0, 0).addBox(0.0f, 3.0f, -6.75f, 1, 1, 1, -0.25f);
        this.villagerNose.addChild(this.mole);
        this.witchHat = new ModelRenderer(this).setTextureSize(64, 128);
        this.witchHat.setRotationPoint(-5.0f, -10.03125f, -5.0f);
        this.witchHat.setTextureOffset(0, 64).addBox(0.0f, 0.0f, 0.0f, 10, 2, 10);
        this.villagerHead.addChild(this.witchHat);
        final ModelRenderer llllllllllllIlllllIIIlIlIlIlIIlI = new ModelRenderer(this).setTextureSize(64, 128);
        llllllllllllIlllllIIIlIlIlIlIIlI.setRotationPoint(1.75f, -4.0f, 2.0f);
        llllllllllllIlllllIIIlIlIlIlIIlI.setTextureOffset(0, 76).addBox(0.0f, 0.0f, 0.0f, 7, 4, 7);
        llllllllllllIlllllIIIlIlIlIlIIlI.rotateAngleX = -0.05235988f;
        llllllllllllIlllllIIIlIlIlIlIIlI.rotateAngleZ = 0.02617994f;
        this.witchHat.addChild(llllllllllllIlllllIIIlIlIlIlIIlI);
        final ModelRenderer llllllllllllIlllllIIIlIlIlIlIIIl = new ModelRenderer(this).setTextureSize(64, 128);
        llllllllllllIlllllIIIlIlIlIlIIIl.setRotationPoint(1.75f, -4.0f, 2.0f);
        llllllllllllIlllllIIIlIlIlIlIIIl.setTextureOffset(0, 87).addBox(0.0f, 0.0f, 0.0f, 4, 4, 4);
        llllllllllllIlllllIIIlIlIlIlIIIl.rotateAngleX = -0.10471976f;
        llllllllllllIlllllIIIlIlIlIlIIIl.rotateAngleZ = 0.05235988f;
        llllllllllllIlllllIIIlIlIlIlIIlI.addChild(llllllllllllIlllllIIIlIlIlIlIIIl);
        final ModelRenderer llllllllllllIlllllIIIlIlIlIlIIII = new ModelRenderer(this).setTextureSize(64, 128);
        llllllllllllIlllllIIIlIlIlIlIIII.setRotationPoint(1.75f, -2.0f, 2.0f);
        llllllllllllIlllllIIIlIlIlIlIIII.setTextureOffset(0, 95).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1, 0.25f);
        llllllllllllIlllllIIIlIlIlIlIIII.rotateAngleX = -0.20943952f;
        llllllllllllIlllllIIIlIlIlIlIIII.rotateAngleZ = 0.10471976f;
        llllllllllllIlllllIIIlIlIlIlIIIl.addChild(llllllllllllIlllllIIIlIlIlIlIIII);
    }
}
