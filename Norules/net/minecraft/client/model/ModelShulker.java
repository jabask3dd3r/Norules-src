package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.math.*;

public class ModelShulker extends ModelBase
{
    public final /* synthetic */ ModelRenderer lid;
    public /* synthetic */ ModelRenderer head;
    public final /* synthetic */ ModelRenderer base;
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlllIlIlllIlIIllIlI, final float lllllllllllllIlllIlIlllIlIIllIIl, final float lllllllllllllIlllIlIlllIlIIIllIl, final float lllllllllllllIlllIlIlllIlIIlIlll, final float lllllllllllllIlllIlIlllIlIIIlIll, final float lllllllllllllIlllIlIlllIlIIlIlIl, final Entity lllllllllllllIlllIlIlllIlIIlIlII) {
        final EntityShulker lllllllllllllIlllIlIlllIlIIlIIll = (EntityShulker)lllllllllllllIlllIlIlllIlIIlIlII;
        final float lllllllllllllIlllIlIlllIlIIlIIlI = lllllllllllllIlllIlIlllIlIIIllIl - lllllllllllllIlllIlIlllIlIIlIIll.ticksExisted;
        final float lllllllllllllIlllIlIlllIlIIlIIIl = (0.5f + lllllllllllllIlllIlIlllIlIIlIIll.getClientPeekAmount(lllllllllllllIlllIlIlllIlIIlIIlI)) * 3.1415927f;
        final float lllllllllllllIlllIlIlllIlIIlIIII = -1.0f + MathHelper.sin(lllllllllllllIlllIlIlllIlIIlIIIl);
        float lllllllllllllIlllIlIlllIlIIIllll = 0.0f;
        if (lllllllllllllIlllIlIlllIlIIlIIIl > 3.1415927f) {
            lllllllllllllIlllIlIlllIlIIIllll = MathHelper.sin(lllllllllllllIlllIlIlllIlIIIllIl * 0.1f) * 0.7f;
        }
        this.lid.setRotationPoint(0.0f, 16.0f + MathHelper.sin(lllllllllllllIlllIlIlllIlIIlIIIl) * 8.0f + lllllllllllllIlllIlIlllIlIIIllll, 0.0f);
        if (lllllllllllllIlllIlIlllIlIIlIIll.getClientPeekAmount(lllllllllllllIlllIlIlllIlIIlIIlI) > 0.3f) {
            this.lid.rotateAngleY = lllllllllllllIlllIlIlllIlIIlIIII * lllllllllllllIlllIlIlllIlIIlIIII * lllllllllllllIlllIlIlllIlIIlIIII * lllllllllllllIlllIlIlllIlIIlIIII * 3.1415927f * 0.125f;
        }
        else {
            this.lid.rotateAngleY = 0.0f;
        }
        this.head.rotateAngleX = lllllllllllllIlllIlIlllIlIIIlIll * 0.017453292f;
        this.head.rotateAngleY = lllllllllllllIlllIlIlllIlIIlIlll * 0.017453292f;
    }
    
    public ModelShulker() {
        this.textureHeight = 64;
        this.textureWidth = 64;
        this.lid = new ModelRenderer(this);
        this.base = new ModelRenderer(this);
        this.head = new ModelRenderer(this);
        this.lid.setTextureOffset(0, 0).addBox(-8.0f, -16.0f, -8.0f, 16, 12, 16);
        this.lid.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.base.setTextureOffset(0, 28).addBox(-8.0f, -8.0f, -8.0f, 16, 8, 16);
        this.base.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.head.setTextureOffset(0, 52).addBox(-3.0f, 0.0f, -3.0f, 6, 6, 6);
        this.head.setRotationPoint(0.0f, 12.0f, 0.0f);
    }
    
    @Override
    public void render(final Entity lllllllllllllIlllIlIlllIlIIIIIIl, final float lllllllllllllIlllIlIlllIlIIIIIII, final float lllllllllllllIlllIlIlllIIlllllll, final float lllllllllllllIlllIlIlllIIllllllI, final float lllllllllllllIlllIlIlllIIlllllIl, final float lllllllllllllIlllIlIlllIIlllllII, final float lllllllllllllIlllIlIlllIIllllIll) {
        this.base.render(lllllllllllllIlllIlIlllIIllllIll);
        this.lid.render(lllllllllllllIlllIlIlllIIllllIll);
    }
}
