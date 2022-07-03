package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.renderer.*;

public class ModelLlama extends ModelQuadruped
{
    private final /* synthetic */ ModelRenderer field_191226_i;
    private final /* synthetic */ ModelRenderer field_191227_j;
    
    @Override
    public void render(final Entity llllllllllllllllllllIlllIIIIIlII, final float llllllllllllllllllllIllIllllIllI, final float llllllllllllllllllllIlllIIIIIIlI, final float llllllllllllllllllllIllIllllIlII, final float llllllllllllllllllllIlllIIIIIIII, final float llllllllllllllllllllIllIllllllll, final float llllllllllllllllllllIllIlllllllI) {
        final AbstractChestHorse llllllllllllllllllllIllIllllllIl = (AbstractChestHorse)llllllllllllllllllllIlllIIIIIlII;
        final boolean llllllllllllllllllllIllIllllllII = !llllllllllllllllllllIllIllllllIl.isChild() && llllllllllllllllllllIllIllllllIl.func_190695_dh();
        this.setRotationAngles(llllllllllllllllllllIllIllllIllI, llllllllllllllllllllIlllIIIIIIlI, llllllllllllllllllllIllIllllIlII, llllllllllllllllllllIlllIIIIIIII, llllllllllllllllllllIllIllllllll, llllllllllllllllllllIllIlllllllI, llllllllllllllllllllIlllIIIIIlII);
        if (this.isChild) {
            final float llllllllllllllllllllIllIlllllIll = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, this.childYOffset * llllllllllllllllllllIllIlllllllI, this.childZOffset * llllllllllllllllllllIllIlllllllI);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            final float llllllllllllllllllllIllIlllllIlI = 0.7f;
            GlStateManager.scale(0.71428573f, 0.64935064f, 0.7936508f);
            GlStateManager.translate(0.0f, 21.0f * llllllllllllllllllllIllIlllllllI, 0.22f);
            this.head.render(llllllllllllllllllllIllIlllllllI);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            final float llllllllllllllllllllIllIlllllIIl = 1.1f;
            GlStateManager.scale(0.625f, 0.45454544f, 0.45454544f);
            GlStateManager.translate(0.0f, 33.0f * llllllllllllllllllllIllIlllllllI, 0.0f);
            this.body.render(llllllllllllllllllllIllIlllllllI);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.45454544f, 0.41322312f, 0.45454544f);
            GlStateManager.translate(0.0f, 33.0f * llllllllllllllllllllIllIlllllllI, 0.0f);
            this.leg1.render(llllllllllllllllllllIllIlllllllI);
            this.leg2.render(llllllllllllllllllllIllIlllllllI);
            this.leg3.render(llllllllllllllllllllIllIlllllllI);
            this.leg4.render(llllllllllllllllllllIllIlllllllI);
            GlStateManager.popMatrix();
        }
        else {
            this.head.render(llllllllllllllllllllIllIlllllllI);
            this.body.render(llllllllllllllllllllIllIlllllllI);
            this.leg1.render(llllllllllllllllllllIllIlllllllI);
            this.leg2.render(llllllllllllllllllllIllIlllllllI);
            this.leg3.render(llllllllllllllllllllIllIlllllllI);
            this.leg4.render(llllllllllllllllllllIllIlllllllI);
        }
        if (llllllllllllllllllllIllIllllllII) {
            this.field_191226_i.render(llllllllllllllllllllIllIlllllllI);
            this.field_191227_j.render(llllllllllllllllllllIllIlllllllI);
        }
    }
    
    public ModelLlama(final float llllllllllllllllllllIlllIIIlIlIl) {
        super(15, llllllllllllllllllllIlllIIIlIlIl);
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.0f, -14.0f, -10.0f, 4, 4, 9, llllllllllllllllllllIlllIIIlIlIl);
        this.head.setRotationPoint(0.0f, 7.0f, -6.0f);
        this.head.setTextureOffset(0, 14).addBox(-4.0f, -16.0f, -6.0f, 8, 18, 6, llllllllllllllllllllIlllIIIlIlIl);
        this.head.setTextureOffset(17, 0).addBox(-4.0f, -19.0f, -4.0f, 3, 3, 2, llllllllllllllllllllIlllIIIlIlIl);
        this.head.setTextureOffset(17, 0).addBox(1.0f, -19.0f, -4.0f, 3, 3, 2, llllllllllllllllllllIlllIIIlIlIl);
        this.body = new ModelRenderer(this, 29, 0);
        this.body.addBox(-6.0f, -10.0f, -7.0f, 12, 18, 10, llllllllllllllllllllIlllIIIlIlIl);
        this.body.setRotationPoint(0.0f, 5.0f, 2.0f);
        this.field_191226_i = new ModelRenderer(this, 45, 28);
        this.field_191226_i.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3, llllllllllllllllllllIlllIIIlIlIl);
        this.field_191226_i.setRotationPoint(-8.5f, 3.0f, 3.0f);
        this.field_191226_i.rotateAngleY = 1.5707964f;
        this.field_191227_j = new ModelRenderer(this, 45, 41);
        this.field_191227_j.addBox(-3.0f, 0.0f, 0.0f, 8, 8, 3, llllllllllllllllllllIlllIIIlIlIl);
        this.field_191227_j.setRotationPoint(5.5f, 3.0f, 3.0f);
        this.field_191227_j.rotateAngleY = 1.5707964f;
        final int llllllllllllllllllllIlllIIIllIII = 4;
        final int llllllllllllllllllllIlllIIIlIlll = 14;
        this.leg1 = new ModelRenderer(this, 29, 29);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 14, 4, llllllllllllllllllllIlllIIIlIlIl);
        this.leg1.setRotationPoint(-2.5f, 10.0f, 6.0f);
        this.leg2 = new ModelRenderer(this, 29, 29);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 14, 4, llllllllllllllllllllIlllIIIlIlIl);
        this.leg2.setRotationPoint(2.5f, 10.0f, 6.0f);
        this.leg3 = new ModelRenderer(this, 29, 29);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 14, 4, llllllllllllllllllllIlllIIIlIlIl);
        this.leg3.setRotationPoint(-2.5f, 10.0f, -4.0f);
        this.leg4 = new ModelRenderer(this, 29, 29);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 14, 4, llllllllllllllllllllIlllIIIlIlIl);
        this.leg4.setRotationPoint(2.5f, 10.0f, -4.0f);
        final ModelRenderer leg1 = this.leg1;
        --leg1.rotationPointX;
        final ModelRenderer leg2 = this.leg2;
        ++leg2.rotationPointX;
        final ModelRenderer leg3 = this.leg1;
        leg3.rotationPointZ += 0.0f;
        final ModelRenderer leg4 = this.leg2;
        leg4.rotationPointZ += 0.0f;
        final ModelRenderer leg5 = this.leg3;
        --leg5.rotationPointX;
        final ModelRenderer leg6 = this.leg4;
        ++leg6.rotationPointX;
        final ModelRenderer leg7 = this.leg3;
        --leg7.rotationPointZ;
        final ModelRenderer leg8 = this.leg4;
        --leg8.rotationPointZ;
        this.childZOffset += 2.0f;
    }
}
