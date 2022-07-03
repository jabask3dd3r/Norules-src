package net.minecraft.client.model;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;

public class ModelWither extends ModelBase
{
    private final /* synthetic */ ModelRenderer[] heads;
    private final /* synthetic */ ModelRenderer[] upperBodyParts;
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlIIIIIlIIllIIIIlll, final float lllllllllllllIlIIIIIlIIllIIIIllI, final float lllllllllllllIlIIIIIlIIlIllllllI, final float lllllllllllllIlIIIIIlIIllIIIIlII, final float lllllllllllllIlIIIIIlIIlIlllllII, final float lllllllllllllIlIIIIIlIIllIIIIIlI, final Entity lllllllllllllIlIIIIIlIIllIIIIIIl) {
        final float lllllllllllllIlIIIIIlIIllIIIIIII = MathHelper.cos(lllllllllllllIlIIIIIlIIlIllllllI * 0.1f);
        this.upperBodyParts[1].rotateAngleX = (0.065f + 0.05f * lllllllllllllIlIIIIIlIIllIIIIIII) * 3.1415927f;
        this.upperBodyParts[2].setRotationPoint(-2.0f, 6.9f + MathHelper.cos(this.upperBodyParts[1].rotateAngleX) * 10.0f, -0.5f + MathHelper.sin(this.upperBodyParts[1].rotateAngleX) * 10.0f);
        this.upperBodyParts[2].rotateAngleX = (0.265f + 0.1f * lllllllllllllIlIIIIIlIIllIIIIIII) * 3.1415927f;
        this.heads[0].rotateAngleY = lllllllllllllIlIIIIIlIIllIIIIlII * 0.017453292f;
        this.heads[0].rotateAngleX = lllllllllllllIlIIIIIlIIlIlllllII * 0.017453292f;
    }
    
    @Override
    public void render(final Entity lllllllllllllIlIIIIIlIIllIIllIII, final float lllllllllllllIlIIIIIlIIllIlIIIIl, final float lllllllllllllIlIIIIIlIIllIlIIIII, final float lllllllllllllIlIIIIIlIIllIIlIlIl, final float lllllllllllllIlIIIIIlIIllIIlIlII, final float lllllllllllllIlIIIIIlIIllIIlllIl, final float lllllllllllllIlIIIIIlIIllIIlllII) {
        this.setRotationAngles(lllllllllllllIlIIIIIlIIllIlIIIIl, lllllllllllllIlIIIIIlIIllIlIIIII, lllllllllllllIlIIIIIlIIllIIlIlIl, lllllllllllllIlIIIIIlIIllIIlIlII, lllllllllllllIlIIIIIlIIllIIlllIl, lllllllllllllIlIIIIIlIIllIIlllII, lllllllllllllIlIIIIIlIIllIIllIII);
        Exception lllllllllllllIlIIIIIlIIllIIIlllI;
        boolean lllllllllllllIlIIIIIlIIllIIIllll = ((ModelRenderer[])(Object)(lllllllllllllIlIIIIIlIIllIIIlllI = (Exception)(Object)this.heads)).length != 0;
        for (float lllllllllllllIlIIIIIlIIllIIlIIII = 0; lllllllllllllIlIIIIIlIIllIIlIIII < (lllllllllllllIlIIIIIlIIllIIIllll ? 1 : 0); ++lllllllllllllIlIIIIIlIIllIIlIIII) {
            final ModelRenderer lllllllllllllIlIIIIIlIIllIIllIll = lllllllllllllIlIIIIIlIIllIIIlllI[lllllllllllllIlIIIIIlIIllIIlIIII];
            lllllllllllllIlIIIIIlIIllIIllIll.render(lllllllllllllIlIIIIIlIIllIIlllII);
        }
        lllllllllllllIlIIIIIlIIllIIIllll = (((ModelRenderer[])(Object)(lllllllllllllIlIIIIIlIIllIIIlllI = (Exception)(Object)this.upperBodyParts)).length != 0);
        for (float lllllllllllllIlIIIIIlIIllIIlIIII = 0; lllllllllllllIlIIIIIlIIllIIlIIII < (lllllllllllllIlIIIIIlIIllIIIllll ? 1 : 0); ++lllllllllllllIlIIIIIlIIllIIlIIII) {
            final ModelRenderer lllllllllllllIlIIIIIlIIllIIllIlI = lllllllllllllIlIIIIIlIIllIIIlllI[lllllllllllllIlIIIIIlIIllIIlIIII];
            lllllllllllllIlIIIIIlIIllIIllIlI.render(lllllllllllllIlIIIIIlIIllIIlllII);
        }
    }
    
    public ModelWither(final float lllllllllllllIlIIIIIlIIllIllIIII) {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.upperBodyParts = new ModelRenderer[3];
        (this.upperBodyParts[0] = new ModelRenderer(this, 0, 16)).addBox(-10.0f, 3.9f, -0.5f, 20, 3, 3, lllllllllllllIlIIIIIlIIllIllIIII);
        (this.upperBodyParts[1] = new ModelRenderer(this).setTextureSize(this.textureWidth, this.textureHeight)).setRotationPoint(-2.0f, 6.9f, -0.5f);
        this.upperBodyParts[1].setTextureOffset(0, 22).addBox(0.0f, 0.0f, 0.0f, 3, 10, 3, lllllllllllllIlIIIIIlIIllIllIIII);
        this.upperBodyParts[1].setTextureOffset(24, 22).addBox(-4.0f, 1.5f, 0.5f, 11, 2, 2, lllllllllllllIlIIIIIlIIllIllIIII);
        this.upperBodyParts[1].setTextureOffset(24, 22).addBox(-4.0f, 4.0f, 0.5f, 11, 2, 2, lllllllllllllIlIIIIIlIIllIllIIII);
        this.upperBodyParts[1].setTextureOffset(24, 22).addBox(-4.0f, 6.5f, 0.5f, 11, 2, 2, lllllllllllllIlIIIIIlIIllIllIIII);
        (this.upperBodyParts[2] = new ModelRenderer(this, 12, 22)).addBox(0.0f, 0.0f, 0.0f, 3, 6, 3, lllllllllllllIlIIIIIlIIllIllIIII);
        this.heads = new ModelRenderer[3];
        (this.heads[0] = new ModelRenderer(this, 0, 0)).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8, lllllllllllllIlIIIIIlIIllIllIIII);
        (this.heads[1] = new ModelRenderer(this, 32, 0)).addBox(-4.0f, -4.0f, -4.0f, 6, 6, 6, lllllllllllllIlIIIIIlIIllIllIIII);
        this.heads[1].rotationPointX = -8.0f;
        this.heads[1].rotationPointY = 4.0f;
        (this.heads[2] = new ModelRenderer(this, 32, 0)).addBox(-4.0f, -4.0f, -4.0f, 6, 6, 6, lllllllllllllIlIIIIIlIIllIllIIII);
        this.heads[2].rotationPointX = 10.0f;
        this.heads[2].rotationPointY = 4.0f;
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllIlIIIIIlIIlIlllIlIl, final float lllllllllllllIlIIIIIlIIlIlllIlII, final float lllllllllllllIlIIIIIlIIlIlllIIll, final float lllllllllllllIlIIIIIlIIlIlllIIlI) {
        final EntityWither lllllllllllllIlIIIIIlIIlIlllIIIl = (EntityWither)lllllllllllllIlIIIIIlIIlIlllIlIl;
        for (int lllllllllllllIlIIIIIlIIlIlllIIII = 1; lllllllllllllIlIIIIIlIIlIlllIIII < 3; ++lllllllllllllIlIIIIIlIIlIlllIIII) {
            this.heads[lllllllllllllIlIIIIIlIIlIlllIIII].rotateAngleY = (lllllllllllllIlIIIIIlIIlIlllIIIl.getHeadYRotation(lllllllllllllIlIIIIIlIIlIlllIIII - 1) - lllllllllllllIlIIIIIlIIlIlllIlIl.renderYawOffset) * 0.017453292f;
            this.heads[lllllllllllllIlIIIIIlIIlIlllIIII].rotateAngleX = lllllllllllllIlIIIIIlIIlIlllIIIl.getHeadXRotation(lllllllllllllIlIIIIIlIIlIlllIIII - 1) * 0.017453292f;
        }
    }
}
