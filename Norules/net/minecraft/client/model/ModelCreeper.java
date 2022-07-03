package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelCreeper extends ModelBase
{
    public /* synthetic */ ModelRenderer head;
    public /* synthetic */ ModelRenderer leg4;
    public /* synthetic */ ModelRenderer creeperArmor;
    public /* synthetic */ ModelRenderer leg2;
    public /* synthetic */ ModelRenderer leg1;
    public /* synthetic */ ModelRenderer body;
    public /* synthetic */ ModelRenderer leg3;
    
    @Override
    public void render(final Entity llllllllllllIlllllIlIlIIlIlIlIll, final float llllllllllllIlllllIlIlIIlIlIlIlI, final float llllllllllllIlllllIlIlIIlIlIIIIl, final float llllllllllllIlllllIlIlIIlIlIIIII, final float llllllllllllIlllllIlIlIIlIIlllll, final float llllllllllllIlllllIlIlIIlIlIIllI, final float llllllllllllIlllllIlIlIIlIIlllIl) {
        this.setRotationAngles(llllllllllllIlllllIlIlIIlIlIlIlI, llllllllllllIlllllIlIlIIlIlIIIIl, llllllllllllIlllllIlIlIIlIlIIIII, llllllllllllIlllllIlIlIIlIIlllll, llllllllllllIlllllIlIlIIlIlIIllI, llllllllllllIlllllIlIlIIlIIlllIl, llllllllllllIlllllIlIlIIlIlIlIll);
        this.head.render(llllllllllllIlllllIlIlIIlIIlllIl);
        this.body.render(llllllllllllIlllllIlIlIIlIIlllIl);
        this.leg1.render(llllllllllllIlllllIlIlIIlIIlllIl);
        this.leg2.render(llllllllllllIlllllIlIlIIlIIlllIl);
        this.leg3.render(llllllllllllIlllllIlIlIIlIIlllIl);
        this.leg4.render(llllllllllllIlllllIlIlIIlIIlllIl);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllIlllllIlIlIIlIIlIllI, final float llllllllllllIlllllIlIlIIlIIIllIl, final float llllllllllllIlllllIlIlIIlIIlIlII, final float llllllllllllIlllllIlIlIIlIIlIIll, final float llllllllllllIlllllIlIlIIlIIIlIll, final float llllllllllllIlllllIlIlIIlIIlIIIl, final Entity llllllllllllIlllllIlIlIIlIIlIIII) {
        this.head.rotateAngleY = llllllllllllIlllllIlIlIIlIIlIIll * 0.017453292f;
        this.head.rotateAngleX = llllllllllllIlllllIlIlIIlIIIlIll * 0.017453292f;
        this.leg1.rotateAngleX = MathHelper.cos(llllllllllllIlllllIlIlIIlIIlIllI * 0.6662f) * 1.4f * llllllllllllIlllllIlIlIIlIIIllIl;
        this.leg2.rotateAngleX = MathHelper.cos(llllllllllllIlllllIlIlIIlIIlIllI * 0.6662f + 3.1415927f) * 1.4f * llllllllllllIlllllIlIlIIlIIIllIl;
        this.leg3.rotateAngleX = MathHelper.cos(llllllllllllIlllllIlIlIIlIIlIllI * 0.6662f + 3.1415927f) * 1.4f * llllllllllllIlllllIlIlIIlIIIllIl;
        this.leg4.rotateAngleX = MathHelper.cos(llllllllllllIlllllIlIlIIlIIlIllI * 0.6662f) * 1.4f * llllllllllllIlllllIlIlIIlIIIllIl;
    }
    
    public ModelCreeper() {
        this(0.0f);
    }
    
    public ModelCreeper(final float llllllllllllIlllllIlIlIIlIllIllI) {
        final int llllllllllllIlllllIlIlIIlIlllIII = 6;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, llllllllllllIlllllIlIlIIlIllIllI);
        this.head.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.creeperArmor = new ModelRenderer(this, 32, 0);
        this.creeperArmor.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, llllllllllllIlllllIlIlIIlIllIllI + 0.5f);
        this.creeperArmor.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, llllllllllllIlllllIlIlIIlIllIllI);
        this.body.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, llllllllllllIlllllIlIlIIlIllIllI);
        this.leg1.setRotationPoint(-2.0f, 18.0f, 4.0f);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, llllllllllllIlllllIlIlIIlIllIllI);
        this.leg2.setRotationPoint(2.0f, 18.0f, 4.0f);
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, llllllllllllIlllllIlIlIIlIllIllI);
        this.leg3.setRotationPoint(-2.0f, 18.0f, -4.0f);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, llllllllllllIlllllIlIlIIlIllIllI);
        this.leg4.setRotationPoint(2.0f, 18.0f, -4.0f);
    }
}
