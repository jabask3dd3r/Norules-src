package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelLeashKnot extends ModelBase
{
    public /* synthetic */ ModelRenderer knotRenderer;
    
    public ModelLeashKnot() {
        this(0, 0, 32, 32);
    }
    
    @Override
    public void render(final Entity lllllllllllllllIIIlllIlIIllIlIIl, final float lllllllllllllllIIIlllIlIIlllIIII, final float lllllllllllllllIIIlllIlIIllIllll, final float lllllllllllllllIIIlllIlIIllIlllI, final float lllllllllllllllIIIlllIlIIllIIlIl, final float lllllllllllllllIIIlllIlIIllIllII, final float lllllllllllllllIIIlllIlIIllIIIll) {
        this.setRotationAngles(lllllllllllllllIIIlllIlIIlllIIII, lllllllllllllllIIIlllIlIIllIllll, lllllllllllllllIIIlllIlIIllIlllI, lllllllllllllllIIIlllIlIIllIIlIl, lllllllllllllllIIIlllIlIIllIllII, lllllllllllllllIIIlllIlIIllIIIll, lllllllllllllllIIIlllIlIIllIlIIl);
        this.knotRenderer.render(lllllllllllllllIIIlllIlIIllIIIll);
    }
    
    public ModelLeashKnot(final int lllllllllllllllIIIlllIlIIllllllI, final int lllllllllllllllIIIlllIlIlIIIIIlI, final int lllllllllllllllIIIlllIlIlIIIIIIl, final int lllllllllllllllIIIlllIlIlIIIIIII) {
        this.textureWidth = lllllllllllllllIIIlllIlIlIIIIIIl;
        this.textureHeight = lllllllllllllllIIIlllIlIlIIIIIII;
        this.knotRenderer = new ModelRenderer(this, lllllllllllllllIIIlllIlIIllllllI, lllllllllllllllIIIlllIlIlIIIIIlI);
        this.knotRenderer.addBox(-3.0f, -6.0f, -3.0f, 6, 8, 6, 0.0f);
        this.knotRenderer.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIIIlllIlIIlIllIIl, final float lllllllllllllllIIIlllIlIIlIllIII, final float lllllllllllllllIIIlllIlIIlIIllll, final float lllllllllllllllIIIlllIlIIlIIlllI, final float lllllllllllllllIIIlllIlIIlIIllIl, final float lllllllllllllllIIIlllIlIIlIIllII, final Entity lllllllllllllllIIIlllIlIIlIlIIll) {
        super.setRotationAngles(lllllllllllllllIIIlllIlIIlIllIIl, lllllllllllllllIIIlllIlIIlIllIII, lllllllllllllllIIIlllIlIIlIIllll, lllllllllllllllIIIlllIlIIlIIlllI, lllllllllllllllIIIlllIlIIlIIllIl, lllllllllllllllIIIlllIlIIlIIllII, lllllllllllllllIIIlllIlIIlIlIIll);
        this.knotRenderer.rotateAngleY = lllllllllllllllIIIlllIlIIlIIlllI * 0.017453292f;
        this.knotRenderer.rotateAngleX = lllllllllllllllIIIlllIlIIlIIllIl * 0.017453292f;
    }
}
