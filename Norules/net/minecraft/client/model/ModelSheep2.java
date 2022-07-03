package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;

public class ModelSheep2 extends ModelQuadruped
{
    private /* synthetic */ float headRotationAngleX;
    
    @Override
    public void setRotationAngles(final float lllllllllllllIIllIllIlllllllIlIl, final float lllllllllllllIIllIllIlllllllIlII, final float lllllllllllllIIllIllIllllllIlIll, final float lllllllllllllIIllIllIllllllIlIlI, final float lllllllllllllIIllIllIllllllIlIIl, final float lllllllllllllIIllIllIlllllllIIII, final Entity lllllllllllllIIllIllIllllllIllll) {
        super.setRotationAngles(lllllllllllllIIllIllIlllllllIlIl, lllllllllllllIIllIllIlllllllIlII, lllllllllllllIIllIllIllllllIlIll, lllllllllllllIIllIllIllllllIlIlI, lllllllllllllIIllIllIllllllIlIIl, lllllllllllllIIllIllIlllllllIIII, lllllllllllllIIllIllIllllllIllll);
        this.head.rotateAngleX = this.headRotationAngleX;
    }
    
    public ModelSheep2() {
        super(12, 0.0f);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3.0f, -4.0f, -6.0f, 6, 6, 8, 0.0f);
        this.head.setRotationPoint(0.0f, 6.0f, -8.0f);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-4.0f, -10.0f, -7.0f, 8, 16, 6, 0.0f);
        this.body.setRotationPoint(0.0f, 5.0f, 2.0f);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllIIllIlllIIIIIIIIIlI, final float lllllllllllllIIllIlllIIIIIIIIIIl, final float lllllllllllllIIllIlllIIIIIIIIIII, final float lllllllllllllIIllIlllIIIIIIIIlII) {
        super.setLivingAnimations(lllllllllllllIIllIlllIIIIIIIIIlI, lllllllllllllIIllIlllIIIIIIIIIIl, lllllllllllllIIllIlllIIIIIIIIIII, lllllllllllllIIllIlllIIIIIIIIlII);
        this.head.rotationPointY = 6.0f + ((EntitySheep)lllllllllllllIIllIlllIIIIIIIIIlI).getHeadRotationPointY(lllllllllllllIIllIlllIIIIIIIIlII) * 9.0f;
        this.headRotationAngleX = ((EntitySheep)lllllllllllllIIllIlllIIIIIIIIIlI).getHeadRotationAngleX(lllllllllllllIIllIlllIIIIIIIIlII);
    }
}
