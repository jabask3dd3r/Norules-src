package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelSkeletonHead extends ModelBase
{
    public /* synthetic */ ModelRenderer skeletonHead;
    
    public ModelSkeletonHead(final int lllllllllllllIlIIIlllIIIIlIllIlI, final int lllllllllllllIlIIIlllIIIIlIllllI, final int lllllllllllllIlIIIlllIIIIlIllIII, final int lllllllllllllIlIIIlllIIIIlIlllII) {
        this.textureWidth = lllllllllllllIlIIIlllIIIIlIllIII;
        this.textureHeight = lllllllllllllIlIIIlllIIIIlIlllII;
        this.skeletonHead = new ModelRenderer(this, lllllllllllllIlIIIlllIIIIlIllIlI, lllllllllllllIlIIIlllIIIIlIllllI);
        this.skeletonHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.skeletonHead.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllllIlIIIlllIIIIlIIllIl, final float lllllllllllllIlIIIlllIIIIlIIIlII, final float lllllllllllllIlIIIlllIIIIlIIlIll, final float lllllllllllllIlIIIlllIIIIlIIlIlI, final float lllllllllllllIlIIIlllIIIIlIIlIIl, final float lllllllllllllIlIIIlllIIIIlIIlIII, final float lllllllllllllIlIIIlllIIIIIllllll) {
        this.setRotationAngles(lllllllllllllIlIIIlllIIIIlIIIlII, lllllllllllllIlIIIlllIIIIlIIlIll, lllllllllllllIlIIIlllIIIIlIIlIlI, lllllllllllllIlIIIlllIIIIlIIlIIl, lllllllllllllIlIIIlllIIIIlIIlIII, lllllllllllllIlIIIlllIIIIIllllll, lllllllllllllIlIIIlllIIIIlIIllIl);
        this.skeletonHead.render(lllllllllllllIlIIIlllIIIIIllllll);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlIIIlllIIIIIlIllIl, final float lllllllllllllIlIIIlllIIIIIlIllII, final float lllllllllllllIlIIIlllIIIIIlIlIll, final float lllllllllllllIlIIIlllIIIIIlIlIlI, final float lllllllllllllIlIIIlllIIIIIllIIIl, final float lllllllllllllIlIIIlllIIIIIlIlIII, final Entity lllllllllllllIlIIIlllIIIIIlIIlll) {
        super.setRotationAngles(lllllllllllllIlIIIlllIIIIIlIllIl, lllllllllllllIlIIIlllIIIIIlIllII, lllllllllllllIlIIIlllIIIIIlIlIll, lllllllllllllIlIIIlllIIIIIlIlIlI, lllllllllllllIlIIIlllIIIIIllIIIl, lllllllllllllIlIIIlllIIIIIlIlIII, lllllllllllllIlIIIlllIIIIIlIIlll);
        this.skeletonHead.rotateAngleY = lllllllllllllIlIIIlllIIIIIlIlIlI * 0.017453292f;
        this.skeletonHead.rotateAngleX = lllllllllllllIlIIIlllIIIIIllIIIl * 0.017453292f;
    }
    
    public ModelSkeletonHead() {
        this(0, 35, 64, 64);
    }
}
