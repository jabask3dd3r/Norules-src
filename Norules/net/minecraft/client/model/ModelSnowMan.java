package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelSnowMan extends ModelBase
{
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer bottomBody;
    public /* synthetic */ ModelRenderer leftHand;
    public /* synthetic */ ModelRenderer rightHand;
    public /* synthetic */ ModelRenderer body;
    
    @Override
    public void setRotationAngles(final float lllllllllllllIIlIlIIllllllIlIIIl, final float lllllllllllllIIlIlIIllllllIIIllI, final float lllllllllllllIIlIlIIllllllIIllll, final float lllllllllllllIIlIlIIllllllIIIlII, final float lllllllllllllIIlIlIIllllllIIIIll, final float lllllllllllllIIlIlIIllllllIIllII, final Entity lllllllllllllIIlIlIIllllllIIIIIl) {
        super.setRotationAngles(lllllllllllllIIlIlIIllllllIlIIIl, lllllllllllllIIlIlIIllllllIIIllI, lllllllllllllIIlIlIIllllllIIllll, lllllllllllllIIlIlIIllllllIIIlII, lllllllllllllIIlIlIIllllllIIIIll, lllllllllllllIIlIlIIllllllIIllII, lllllllllllllIIlIlIIllllllIIIIIl);
        this.head.rotateAngleY = lllllllllllllIIlIlIIllllllIIIlII * 0.017453292f;
        this.head.rotateAngleX = lllllllllllllIIlIlIIllllllIIIIll * 0.017453292f;
        this.body.rotateAngleY = lllllllllllllIIlIlIIllllllIIIlII * 0.017453292f * 0.25f;
        final float lllllllllllllIIlIlIIllllllIIlIlI = MathHelper.sin(this.body.rotateAngleY);
        final float lllllllllllllIIlIlIIllllllIIlIIl = MathHelper.cos(this.body.rotateAngleY);
        this.rightHand.rotateAngleZ = 1.0f;
        this.leftHand.rotateAngleZ = -1.0f;
        this.rightHand.rotateAngleY = 0.0f + this.body.rotateAngleY;
        this.leftHand.rotateAngleY = 3.1415927f + this.body.rotateAngleY;
        this.rightHand.rotationPointX = lllllllllllllIIlIlIIllllllIIlIIl * 5.0f;
        this.rightHand.rotationPointZ = -lllllllllllllIIlIlIIllllllIIlIlI * 5.0f;
        this.leftHand.rotationPointX = -lllllllllllllIIlIlIIllllllIIlIIl * 5.0f;
        this.leftHand.rotationPointZ = lllllllllllllIIlIlIIllllllIIlIlI * 5.0f;
    }
    
    public ModelSnowMan() {
        final float lllllllllllllIIlIlIIlllllllIIIIl = 4.0f;
        final float lllllllllllllIIlIlIIlllllllIIIII = 0.0f;
        this.head = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, -0.5f);
        this.head.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.rightHand = new ModelRenderer(this, 32, 0).setTextureSize(64, 64);
        this.rightHand.addBox(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.rightHand.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.leftHand = new ModelRenderer(this, 32, 0).setTextureSize(64, 64);
        this.leftHand.addBox(-1.0f, 0.0f, -1.0f, 12, 2, 2, -0.5f);
        this.leftHand.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.body = new ModelRenderer(this, 0, 16).setTextureSize(64, 64);
        this.body.addBox(-5.0f, -10.0f, -5.0f, 10, 10, 10, -0.5f);
        this.body.setRotationPoint(0.0f, 13.0f, 0.0f);
        this.bottomBody = new ModelRenderer(this, 0, 36).setTextureSize(64, 64);
        this.bottomBody.addBox(-6.0f, -12.0f, -6.0f, 12, 12, 12, -0.5f);
        this.bottomBody.setRotationPoint(0.0f, 24.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllllIIlIlIIlllllIlIllIl, final float lllllllllllllIIlIlIIlllllIlIllII, final float lllllllllllllIIlIlIIlllllIlIlIll, final float lllllllllllllIIlIlIIlllllIlIlIlI, final float lllllllllllllIIlIlIIlllllIlIlIIl, final float lllllllllllllIIlIlIIlllllIllIIII, final float lllllllllllllIIlIlIIlllllIlIIlll) {
        this.setRotationAngles(lllllllllllllIIlIlIIlllllIlIllII, lllllllllllllIIlIlIIlllllIlIlIll, lllllllllllllIIlIlIIlllllIlIlIlI, lllllllllllllIIlIlIIlllllIlIlIIl, lllllllllllllIIlIlIIlllllIllIIII, lllllllllllllIIlIlIIlllllIlIIlll, lllllllllllllIIlIlIIlllllIlIllIl);
        this.body.render(lllllllllllllIIlIlIIlllllIlIIlll);
        this.bottomBody.render(lllllllllllllIIlIlIIlllllIlIIlll);
        this.head.render(lllllllllllllIIlIlIIlllllIlIIlll);
        this.rightHand.render(lllllllllllllIIlIlIIlllllIlIIlll);
        this.leftHand.render(lllllllllllllIIlIlIIlllllIlIIlll);
    }
}
