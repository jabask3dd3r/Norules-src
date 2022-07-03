package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelHumanoidHead extends ModelSkeletonHead
{
    private final /* synthetic */ ModelRenderer head;
    
    @Override
    public void render(final Entity lllllllllllllIIIllIlIIIIIIIIIIII, final float lllllllllllllIIIllIIllllllllllll, final float lllllllllllllIIIllIIlllllllllllI, final float lllllllllllllIIIllIIllllllllllIl, final float lllllllllllllIIIllIIllllllllllII, final float lllllllllllllIIIllIlIIIIIIIIIIll, final float lllllllllllllIIIllIIlllllllllIlI) {
        super.render(lllllllllllllIIIllIlIIIIIIIIIIII, lllllllllllllIIIllIIllllllllllll, lllllllllllllIIIllIIlllllllllllI, lllllllllllllIIIllIIllllllllllIl, lllllllllllllIIIllIIllllllllllII, lllllllllllllIIIllIlIIIIIIIIIIll, lllllllllllllIIIllIIlllllllllIlI);
        this.head.render(lllllllllllllIIIllIIlllllllllIlI);
    }
    
    public ModelHumanoidHead() {
        super(0, 0, 64, 64);
        this.head = new ModelRenderer(this, 32, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.25f);
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIIIllIIllllllllIIII, final float lllllllllllllIIIllIIlllllllIllll, final float lllllllllllllIIIllIIlllllllIlllI, final float lllllllllllllIIIllIIlllllllIllIl, final float lllllllllllllIIIllIIlllllllIIlII, final float lllllllllllllIIIllIIlllllllIIIll, final Entity lllllllllllllIIIllIIlllllllIlIlI) {
        super.setRotationAngles(lllllllllllllIIIllIIllllllllIIII, lllllllllllllIIIllIIlllllllIllll, lllllllllllllIIIllIIlllllllIlllI, lllllllllllllIIIllIIlllllllIllIl, lllllllllllllIIIllIIlllllllIIlII, lllllllllllllIIIllIIlllllllIIIll, lllllllllllllIIIllIIlllllllIlIlI);
        this.head.rotateAngleY = this.skeletonHead.rotateAngleY;
        this.head.rotateAngleX = this.skeletonHead.rotateAngleX;
    }
}
