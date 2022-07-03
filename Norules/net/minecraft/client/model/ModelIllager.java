package net.minecraft.client.model;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class ModelIllager extends ModelBase
{
    public /* synthetic */ ModelRenderer field_191217_a;
    public /* synthetic */ ModelRenderer field_191222_f;
    public /* synthetic */ ModelRenderer field_191223_g;
    public /* synthetic */ ModelRenderer field_191221_e;
    public /* synthetic */ ModelRenderer field_193775_b;
    public /* synthetic */ ModelRenderer field_191220_d;
    public /* synthetic */ ModelRenderer field_191218_b;
    public /* synthetic */ ModelRenderer field_191224_h;
    public /* synthetic */ ModelRenderer field_191219_c;
    
    @Override
    public void render(final Entity lllllllllllllIlIIIllIlIIIllllIIl, final float lllllllllllllIlIIIllIlIIIllIllll, final float lllllllllllllIlIIIllIlIIIllIlllI, final float lllllllllllllIlIIIllIlIIIlllIllI, final float lllllllllllllIlIIIllIlIIIlllIlIl, final float lllllllllllllIlIIIllIlIIIlllIlII, final float lllllllllllllIlIIIllIlIIIllIlIlI) {
        this.setRotationAngles(lllllllllllllIlIIIllIlIIIllIllll, lllllllllllllIlIIIllIlIIIllIlllI, lllllllllllllIlIIIllIlIIIlllIllI, lllllllllllllIlIIIllIlIIIlllIlIl, lllllllllllllIlIIIllIlIIIlllIlII, lllllllllllllIlIIIllIlIIIllIlIlI, lllllllllllllIlIIIllIlIIIllllIIl);
        this.field_191217_a.render(lllllllllllllIlIIIllIlIIIllIlIlI);
        this.field_191218_b.render(lllllllllllllIlIIIllIlIIIllIlIlI);
        this.field_191220_d.render(lllllllllllllIlIIIllIlIIIllIlIlI);
        this.field_191221_e.render(lllllllllllllIlIIIllIlIIIllIlIlI);
        final AbstractIllager lllllllllllllIlIIIllIlIIIlllIIlI = (AbstractIllager)lllllllllllllIlIIIllIlIIIllllIIl;
        if (lllllllllllllIlIIIllIlIIIlllIIlI.func_193077_p() == AbstractIllager.IllagerArmPose.CROSSED) {
            this.field_191219_c.render(lllllllllllllIlIIIllIlIIIllIlIlI);
        }
        else {
            this.field_191223_g.render(lllllllllllllIlIIIllIlIIIllIlIlI);
            this.field_191224_h.render(lllllllllllllIlIIIllIlIIIllIlIlI);
        }
    }
    
    public ModelRenderer func_191216_a(final EnumHandSide lllllllllllllIlIIIllIlIIIlIIIllI) {
        return (lllllllllllllIlIIIllIlIIIlIIIllI == EnumHandSide.LEFT) ? this.field_191224_h : this.field_191223_g;
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlIIIllIlIIIlIlllIl, final float lllllllllllllIlIIIllIlIIIlIlllII, final float lllllllllllllIlIIIllIlIIIlIllIll, final float lllllllllllllIlIIIllIlIIIlIIllll, final float lllllllllllllIlIIIllIlIIIlIIlllI, final float lllllllllllllIlIIIllIlIIIlIllIII, final Entity lllllllllllllIlIIIllIlIIIlIIllIl) {
        this.field_191217_a.rotateAngleY = lllllllllllllIlIIIllIlIIIlIIllll * 0.017453292f;
        this.field_191217_a.rotateAngleX = lllllllllllllIlIIIllIlIIIlIIlllI * 0.017453292f;
        this.field_191219_c.rotationPointY = 3.0f;
        this.field_191219_c.rotationPointZ = -1.0f;
        this.field_191219_c.rotateAngleX = -0.75f;
        this.field_191220_d.rotateAngleX = MathHelper.cos(lllllllllllllIlIIIllIlIIIlIlllIl * 0.6662f) * 1.4f * lllllllllllllIlIIIllIlIIIlIlllII * 0.5f;
        this.field_191221_e.rotateAngleX = MathHelper.cos(lllllllllllllIlIIIllIlIIIlIlllIl * 0.6662f + 3.1415927f) * 1.4f * lllllllllllllIlIIIllIlIIIlIlllII * 0.5f;
        this.field_191220_d.rotateAngleY = 0.0f;
        this.field_191221_e.rotateAngleY = 0.0f;
        final AbstractIllager.IllagerArmPose lllllllllllllIlIIIllIlIIIlIlIllI = ((AbstractIllager)lllllllllllllIlIIIllIlIIIlIIllIl).func_193077_p();
        if (lllllllllllllIlIIIllIlIIIlIlIllI == AbstractIllager.IllagerArmPose.ATTACKING) {
            final float lllllllllllllIlIIIllIlIIIlIlIlIl = MathHelper.sin(this.swingProgress * 3.1415927f);
            final float lllllllllllllIlIIIllIlIIIlIlIlII = MathHelper.sin((1.0f - (1.0f - this.swingProgress) * (1.0f - this.swingProgress)) * 3.1415927f);
            this.field_191223_g.rotateAngleZ = 0.0f;
            this.field_191224_h.rotateAngleZ = 0.0f;
            this.field_191223_g.rotateAngleY = 0.15707964f;
            this.field_191224_h.rotateAngleY = -0.15707964f;
            if (((EntityLivingBase)lllllllllllllIlIIIllIlIIIlIIllIl).getPrimaryHand() == EnumHandSide.RIGHT) {
                this.field_191223_g.rotateAngleX = -1.8849558f + MathHelper.cos(lllllllllllllIlIIIllIlIIIlIllIll * 0.09f) * 0.15f;
                this.field_191224_h.rotateAngleX = -0.0f + MathHelper.cos(lllllllllllllIlIIIllIlIIIlIllIll * 0.19f) * 0.5f;
                final ModelRenderer field_191223_g = this.field_191223_g;
                field_191223_g.rotateAngleX += lllllllllllllIlIIIllIlIIIlIlIlIl * 2.2f - lllllllllllllIlIIIllIlIIIlIlIlII * 0.4f;
                final ModelRenderer field_191224_h = this.field_191224_h;
                field_191224_h.rotateAngleX += lllllllllllllIlIIIllIlIIIlIlIlIl * 1.2f - lllllllllllllIlIIIllIlIIIlIlIlII * 0.4f;
            }
            else {
                this.field_191223_g.rotateAngleX = -0.0f + MathHelper.cos(lllllllllllllIlIIIllIlIIIlIllIll * 0.19f) * 0.5f;
                this.field_191224_h.rotateAngleX = -1.8849558f + MathHelper.cos(lllllllllllllIlIIIllIlIIIlIllIll * 0.09f) * 0.15f;
                final ModelRenderer field_191223_g2 = this.field_191223_g;
                field_191223_g2.rotateAngleX += lllllllllllllIlIIIllIlIIIlIlIlIl * 1.2f - lllllllllllllIlIIIllIlIIIlIlIlII * 0.4f;
                final ModelRenderer field_191224_h2 = this.field_191224_h;
                field_191224_h2.rotateAngleX += lllllllllllllIlIIIllIlIIIlIlIlIl * 2.2f - lllllllllllllIlIIIllIlIIIlIlIlII * 0.4f;
            }
            final ModelRenderer field_191223_g3 = this.field_191223_g;
            field_191223_g3.rotateAngleZ += MathHelper.cos(lllllllllllllIlIIIllIlIIIlIllIll * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_191224_h3 = this.field_191224_h;
            field_191224_h3.rotateAngleZ -= MathHelper.cos(lllllllllllllIlIIIllIlIIIlIllIll * 0.09f) * 0.05f + 0.05f;
            final ModelRenderer field_191223_g4 = this.field_191223_g;
            field_191223_g4.rotateAngleX += MathHelper.sin(lllllllllllllIlIIIllIlIIIlIllIll * 0.067f) * 0.05f;
            final ModelRenderer field_191224_h4 = this.field_191224_h;
            field_191224_h4.rotateAngleX -= MathHelper.sin(lllllllllllllIlIIIllIlIIIlIllIll * 0.067f) * 0.05f;
        }
        else if (lllllllllllllIlIIIllIlIIIlIlIllI == AbstractIllager.IllagerArmPose.SPELLCASTING) {
            this.field_191223_g.rotationPointZ = 0.0f;
            this.field_191223_g.rotationPointX = -5.0f;
            this.field_191224_h.rotationPointZ = 0.0f;
            this.field_191224_h.rotationPointX = 5.0f;
            this.field_191223_g.rotateAngleX = MathHelper.cos(lllllllllllllIlIIIllIlIIIlIllIll * 0.6662f) * 0.25f;
            this.field_191224_h.rotateAngleX = MathHelper.cos(lllllllllllllIlIIIllIlIIIlIllIll * 0.6662f) * 0.25f;
            this.field_191223_g.rotateAngleZ = 2.3561945f;
            this.field_191224_h.rotateAngleZ = -2.3561945f;
            this.field_191223_g.rotateAngleY = 0.0f;
            this.field_191224_h.rotateAngleY = 0.0f;
        }
        else if (lllllllllllllIlIIIllIlIIIlIlIllI == AbstractIllager.IllagerArmPose.BOW_AND_ARROW) {
            this.field_191223_g.rotateAngleY = -0.1f + this.field_191217_a.rotateAngleY;
            this.field_191223_g.rotateAngleX = -1.5707964f + this.field_191217_a.rotateAngleX;
            this.field_191224_h.rotateAngleX = -0.9424779f + this.field_191217_a.rotateAngleX;
            this.field_191224_h.rotateAngleY = this.field_191217_a.rotateAngleY - 0.4f;
            this.field_191224_h.rotateAngleZ = 1.5707964f;
        }
    }
    
    public ModelIllager(final float lllllllllllllIlIIIllIlIIlIIIlIII, final float lllllllllllllIlIIIllIlIIlIIIIlll, final int lllllllllllllIlIIIllIlIIlIIIIllI, final int lllllllllllllIlIIIllIlIIlIIIlIll) {
        this.field_191217_a = new ModelRenderer(this).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        this.field_191217_a.setRotationPoint(0.0f, 0.0f + lllllllllllllIlIIIllIlIIlIIIIlll, 0.0f);
        this.field_191217_a.setTextureOffset(0, 0).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8, lllllllllllllIlIIIllIlIIlIIIlIII);
        this.field_193775_b = new ModelRenderer(this, 32, 0).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        this.field_193775_b.addBox(-4.0f, -10.0f, -4.0f, 8, 12, 8, lllllllllllllIlIIIllIlIIlIIIlIII + 0.45f);
        this.field_191217_a.addChild(this.field_193775_b);
        this.field_193775_b.showModel = false;
        this.field_191222_f = new ModelRenderer(this).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        this.field_191222_f.setRotationPoint(0.0f, lllllllllllllIlIIIllIlIIlIIIIlll - 2.0f, 0.0f);
        this.field_191222_f.setTextureOffset(24, 0).addBox(-1.0f, -1.0f, -6.0f, 2, 4, 2, lllllllllllllIlIIIllIlIIlIIIlIII);
        this.field_191217_a.addChild(this.field_191222_f);
        this.field_191218_b = new ModelRenderer(this).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        this.field_191218_b.setRotationPoint(0.0f, 0.0f + lllllllllllllIlIIIllIlIIlIIIIlll, 0.0f);
        this.field_191218_b.setTextureOffset(16, 20).addBox(-4.0f, 0.0f, -3.0f, 8, 12, 6, lllllllllllllIlIIIllIlIIlIIIlIII);
        this.field_191218_b.setTextureOffset(0, 38).addBox(-4.0f, 0.0f, -3.0f, 8, 18, 6, lllllllllllllIlIIIllIlIIlIIIlIII + 0.5f);
        this.field_191219_c = new ModelRenderer(this).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        this.field_191219_c.setRotationPoint(0.0f, 0.0f + lllllllllllllIlIIIllIlIIlIIIIlll + 2.0f, 0.0f);
        this.field_191219_c.setTextureOffset(44, 22).addBox(-8.0f, -2.0f, -2.0f, 4, 8, 4, lllllllllllllIlIIIllIlIIlIIIlIII);
        final ModelRenderer lllllllllllllIlIIIllIlIIlIIIlIlI = new ModelRenderer(this, 44, 22).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        lllllllllllllIlIIIllIlIIlIIIlIlI.mirror = true;
        lllllllllllllIlIIIllIlIIlIIIlIlI.addBox(4.0f, -2.0f, -2.0f, 4, 8, 4, lllllllllllllIlIIIllIlIIlIIIlIII);
        this.field_191219_c.addChild(lllllllllllllIlIIIllIlIIlIIIlIlI);
        this.field_191219_c.setTextureOffset(40, 38).addBox(-4.0f, 2.0f, -2.0f, 8, 4, 4, lllllllllllllIlIIIllIlIIlIIIlIII);
        this.field_191220_d = new ModelRenderer(this, 0, 22).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        this.field_191220_d.setRotationPoint(-2.0f, 12.0f + lllllllllllllIlIIIllIlIIlIIIIlll, 0.0f);
        this.field_191220_d.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIlIIIllIlIIlIIIlIII);
        this.field_191221_e = new ModelRenderer(this, 0, 22).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        this.field_191221_e.mirror = true;
        this.field_191221_e.setRotationPoint(2.0f, 12.0f + lllllllllllllIlIIIllIlIIlIIIIlll, 0.0f);
        this.field_191221_e.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, lllllllllllllIlIIIllIlIIlIIIlIII);
        this.field_191223_g = new ModelRenderer(this, 40, 46).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        this.field_191223_g.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllllIlIIIllIlIIlIIIlIII);
        this.field_191223_g.setRotationPoint(-5.0f, 2.0f + lllllllllllllIlIIIllIlIIlIIIIlll, 0.0f);
        this.field_191224_h = new ModelRenderer(this, 40, 46).setTextureSize(lllllllllllllIlIIIllIlIIlIIIIllI, lllllllllllllIlIIIllIlIIlIIIlIll);
        this.field_191224_h.mirror = true;
        this.field_191224_h.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, lllllllllllllIlIIIllIlIIlIIIlIII);
        this.field_191224_h.setRotationPoint(5.0f, 2.0f + lllllllllllllIlIIIllIlIIlIIIIlll, 0.0f);
    }
}
