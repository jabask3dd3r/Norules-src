package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelShulkerBullet extends ModelBase
{
    public /* synthetic */ ModelRenderer renderer;
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIlIIllllIIlllIIII, final float llllllllllllllIIlIIllllIIllIIlll, final float llllllllllllllIIlIIllllIIllIlllI, final float llllllllllllllIIlIIllllIIllIIlIl, final float llllllllllllllIIlIIllllIIllIIlII, final float llllllllllllllIIlIIllllIIllIIIll, final Entity llllllllllllllIIlIIllllIIllIIIlI) {
        super.setRotationAngles(llllllllllllllIIlIIllllIIlllIIII, llllllllllllllIIlIIllllIIllIIlll, llllllllllllllIIlIIllllIIllIlllI, llllllllllllllIIlIIllllIIllIIlIl, llllllllllllllIIlIIllllIIllIIlII, llllllllllllllIIlIIllllIIllIIIll, llllllllllllllIIlIIllllIIllIIIlI);
        this.renderer.rotateAngleY = llllllllllllllIIlIIllllIIllIIlIl * 0.017453292f;
        this.renderer.rotateAngleX = llllllllllllllIIlIIllllIIllIIlII * 0.017453292f;
    }
    
    public ModelShulkerBullet() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.renderer = new ModelRenderer(this);
        this.renderer.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -1.0f, 8, 8, 2, 0.0f);
        this.renderer.setTextureOffset(0, 10).addBox(-1.0f, -4.0f, -4.0f, 2, 8, 8, 0.0f);
        this.renderer.setTextureOffset(20, 0).addBox(-4.0f, -1.0f, -4.0f, 8, 2, 8, 0.0f);
        this.renderer.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity llllllllllllllIIlIIllllIlIIIIIII, final float llllllllllllllIIlIIllllIlIIIIlll, final float llllllllllllllIIlIIllllIlIIIIllI, final float llllllllllllllIIlIIllllIlIIIIlIl, final float llllllllllllllIIlIIllllIIlllllII, final float llllllllllllllIIlIIllllIIllllIll, final float llllllllllllllIIlIIllllIlIIIIIlI) {
        this.setRotationAngles(llllllllllllllIIlIIllllIlIIIIlll, llllllllllllllIIlIIllllIlIIIIllI, llllllllllllllIIlIIllllIlIIIIlIl, llllllllllllllIIlIIllllIIlllllII, llllllllllllllIIlIIllllIIllllIll, llllllllllllllIIlIIllllIlIIIIIlI, llllllllllllllIIlIIllllIlIIIIIII);
        this.renderer.render(llllllllllllllIIlIIllllIlIIIIIlI);
    }
}
