package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public class ModelVex extends ModelBiped
{
    protected /* synthetic */ ModelRenderer field_191229_a;
    protected /* synthetic */ ModelRenderer field_191230_b;
    
    @Override
    public void render(final Entity lllllllllllllllIlIlllIlllllIIllI, final float lllllllllllllllIlIlllIlllllIllIl, final float lllllllllllllllIlIlllIlllllIllII, final float lllllllllllllllIlIlllIlllllIIIll, final float lllllllllllllllIlIlllIlllllIIIlI, final float lllllllllllllllIlIlllIlllllIIIIl, final float lllllllllllllllIlIlllIlllllIlIII) {
        super.render(lllllllllllllllIlIlllIlllllIIllI, lllllllllllllllIlIlllIlllllIllIl, lllllllllllllllIlIlllIlllllIllII, lllllllllllllllIlIlllIlllllIIIll, lllllllllllllllIlIlllIlllllIIIlI, lllllllllllllllIlIlllIlllllIIIIl, lllllllllllllllIlIlllIlllllIlIII);
        this.field_191230_b.render(lllllllllllllllIlIlllIlllllIlIII);
        this.field_191229_a.render(lllllllllllllllIlIlllIlllllIlIII);
    }
    
    public ModelVex(final float lllllllllllllllIlIlllIlllllllIlI) {
        super(lllllllllllllllIlIlllIlllllllIlI, 0.0f, 64, 64);
        this.bipedLeftLeg.showModel = false;
        this.bipedHeadwear.showModel = false;
        this.bipedRightLeg = new ModelRenderer(this, 32, 0);
        this.bipedRightLeg.addBox(-1.0f, -1.0f, -2.0f, 6, 10, 4, 0.0f);
        this.bipedRightLeg.setRotationPoint(-1.9f, 12.0f, 0.0f);
        this.field_191230_b = new ModelRenderer(this, 0, 32);
        this.field_191230_b.addBox(-20.0f, 0.0f, 0.0f, 20, 12, 1);
        this.field_191229_a = new ModelRenderer(this, 0, 32);
        this.field_191229_a.mirror = true;
        this.field_191229_a.addBox(0.0f, 0.0f, 0.0f, 20, 12, 1);
    }
    
    public int func_191228_a() {
        return 23;
    }
    
    public ModelVex() {
        this(0.0f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIlIlllIllllIIllII, final float lllllllllllllllIlIlllIllllIlIlII, final float lllllllllllllllIlIlllIllllIIlIlI, final float lllllllllllllllIlIlllIllllIlIIlI, final float lllllllllllllllIlIlllIllllIIlIII, final float lllllllllllllllIlIlllIllllIlIIII, final Entity lllllllllllllllIlIlllIllllIIIllI) {
        super.setRotationAngles(lllllllllllllllIlIlllIllllIIllII, lllllllllllllllIlIlllIllllIlIlII, lllllllllllllllIlIlllIllllIIlIlI, lllllllllllllllIlIlllIllllIlIIlI, lllllllllllllllIlIlllIllllIIlIII, lllllllllllllllIlIlllIllllIlIIII, lllllllllllllllIlIlllIllllIIIllI);
        final EntityVex lllllllllllllllIlIlllIllllIIlllI = (EntityVex)lllllllllllllllIlIlllIllllIIIllI;
        if (lllllllllllllllIlIlllIllllIIlllI.func_190647_dj()) {
            if (lllllllllllllllIlIlllIllllIIlllI.getPrimaryHand() == EnumHandSide.RIGHT) {
                this.bipedRightArm.rotateAngleX = 3.7699115f;
            }
            else {
                this.bipedLeftArm.rotateAngleX = 3.7699115f;
            }
        }
        final ModelRenderer bipedRightLeg = this.bipedRightLeg;
        bipedRightLeg.rotateAngleX += 0.62831855f;
        this.field_191230_b.rotationPointZ = 2.0f;
        this.field_191229_a.rotationPointZ = 2.0f;
        this.field_191230_b.rotationPointY = 1.0f;
        this.field_191229_a.rotationPointY = 1.0f;
        this.field_191230_b.rotateAngleY = 0.47123894f + MathHelper.cos(lllllllllllllllIlIlllIllllIIlIlI * 0.8f) * 3.1415927f * 0.05f;
        this.field_191229_a.rotateAngleY = -this.field_191230_b.rotateAngleY;
        this.field_191229_a.rotateAngleZ = -0.47123894f;
        this.field_191229_a.rotateAngleX = 0.47123894f;
        this.field_191230_b.rotateAngleX = 0.47123894f;
        this.field_191230_b.rotateAngleZ = 0.47123894f;
    }
}
