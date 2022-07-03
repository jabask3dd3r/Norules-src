package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelBook extends ModelBase
{
    public /* synthetic */ ModelRenderer coverRight;
    public /* synthetic */ ModelRenderer coverLeft;
    public /* synthetic */ ModelRenderer pagesRight;
    public /* synthetic */ ModelRenderer flippingPageLeft;
    public /* synthetic */ ModelRenderer bookSpine;
    public /* synthetic */ ModelRenderer flippingPageRight;
    public /* synthetic */ ModelRenderer pagesLeft;
    
    @Override
    public void render(final Entity lllllllllllllIlIllIllIllllllIlIl, final float lllllllllllllIlIllIllIllllllllII, final float lllllllllllllIlIllIllIllllllIIll, final float lllllllllllllIlIllIllIllllllIIlI, final float lllllllllllllIlIllIllIllllllIIIl, final float lllllllllllllIlIllIllIllllllIIII, final float lllllllllllllIlIllIllIllllllIlll) {
        this.setRotationAngles(lllllllllllllIlIllIllIllllllllII, lllllllllllllIlIllIllIllllllIIll, lllllllllllllIlIllIllIllllllIIlI, lllllllllllllIlIllIllIllllllIIIl, lllllllllllllIlIllIllIllllllIIII, lllllllllllllIlIllIllIllllllIlll, lllllllllllllIlIllIllIllllllIlIl);
        this.coverRight.render(lllllllllllllIlIllIllIllllllIlll);
        this.coverLeft.render(lllllllllllllIlIllIllIllllllIlll);
        this.bookSpine.render(lllllllllllllIlIllIllIllllllIlll);
        this.pagesRight.render(lllllllllllllIlIllIllIllllllIlll);
        this.pagesLeft.render(lllllllllllllIlIllIllIllllllIlll);
        this.flippingPageRight.render(lllllllllllllIlIllIllIllllllIlll);
        this.flippingPageLeft.render(lllllllllllllIlIllIllIllllllIlll);
    }
    
    public ModelBook() {
        this.coverRight = new ModelRenderer(this).setTextureOffset(0, 0).addBox(-6.0f, -5.0f, 0.0f, 6, 10, 0);
        this.coverLeft = new ModelRenderer(this).setTextureOffset(16, 0).addBox(0.0f, -5.0f, 0.0f, 6, 10, 0);
        this.pagesRight = new ModelRenderer(this).setTextureOffset(0, 10).addBox(0.0f, -4.0f, -0.99f, 5, 8, 1);
        this.pagesLeft = new ModelRenderer(this).setTextureOffset(12, 10).addBox(0.0f, -4.0f, -0.01f, 5, 8, 1);
        this.flippingPageRight = new ModelRenderer(this).setTextureOffset(24, 10).addBox(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.flippingPageLeft = new ModelRenderer(this).setTextureOffset(24, 10).addBox(0.0f, -4.0f, 0.0f, 5, 8, 0);
        this.bookSpine = new ModelRenderer(this).setTextureOffset(12, 0).addBox(-1.0f, -5.0f, 0.0f, 2, 10, 0);
        this.coverRight.setRotationPoint(0.0f, 0.0f, -1.0f);
        this.coverLeft.setRotationPoint(0.0f, 0.0f, 1.0f);
        this.bookSpine.rotateAngleY = 1.5707964f;
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlIllIllIlllllIIlll, final float lllllllllllllIlIllIllIlllllIIllI, final float lllllllllllllIlIllIllIlllllIIlIl, final float lllllllllllllIlIllIllIllllIllIll, final float lllllllllllllIlIllIllIlllllIIIll, final float lllllllllllllIlIllIllIlllllIIIlI, final Entity lllllllllllllIlIllIllIlllllIIIIl) {
        final float lllllllllllllIlIllIllIlllllIIIII = (MathHelper.sin(lllllllllllllIlIllIllIlllllIIlll * 0.02f) * 0.1f + 1.25f) * lllllllllllllIlIllIllIllllIllIll;
        this.coverRight.rotateAngleY = 3.1415927f + lllllllllllllIlIllIllIlllllIIIII;
        this.coverLeft.rotateAngleY = -lllllllllllllIlIllIllIlllllIIIII;
        this.pagesRight.rotateAngleY = lllllllllllllIlIllIllIlllllIIIII;
        this.pagesLeft.rotateAngleY = -lllllllllllllIlIllIllIlllllIIIII;
        this.flippingPageRight.rotateAngleY = lllllllllllllIlIllIllIlllllIIIII - lllllllllllllIlIllIllIlllllIIIII * 2.0f * lllllllllllllIlIllIllIlllllIIllI;
        this.flippingPageLeft.rotateAngleY = lllllllllllllIlIllIllIlllllIIIII - lllllllllllllIlIllIllIlllllIIIII * 2.0f * lllllllllllllIlIllIllIlllllIIlIl;
        this.pagesRight.rotationPointX = MathHelper.sin(lllllllllllllIlIllIllIlllllIIIII);
        this.pagesLeft.rotationPointX = MathHelper.sin(lllllllllllllIlIllIllIlllllIIIII);
        this.flippingPageRight.rotationPointX = MathHelper.sin(lllllllllllllIlIllIllIlllllIIIII);
        this.flippingPageLeft.rotationPointX = MathHelper.sin(lllllllllllllIlIllIllIlllllIIIII);
    }
}
