package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelSquid extends ModelBase
{
    /* synthetic */ ModelRenderer[] squidTentacles;
    /* synthetic */ ModelRenderer squidBody;
    
    public ModelSquid() {
        this.squidTentacles = new ModelRenderer[8];
        final int lllllllllllllIlIIlIIlIllIIllIIIl = -16;
        this.squidBody = new ModelRenderer(this, 0, 0);
        this.squidBody.addBox(-6.0f, -8.0f, -6.0f, 12, 16, 12);
        final ModelRenderer squidBody = this.squidBody;
        squidBody.rotationPointY += 8.0f;
        for (int lllllllllllllIlIIlIIlIllIIllIIII = 0; lllllllllllllIlIIlIIlIllIIllIIII < this.squidTentacles.length; ++lllllllllllllIlIIlIIlIllIIllIIII) {
            this.squidTentacles[lllllllllllllIlIIlIIlIllIIllIIII] = new ModelRenderer(this, 48, 0);
            double lllllllllllllIlIIlIIlIllIIlIllll = lllllllllllllIlIIlIIlIllIIllIIII * 3.141592653589793 * 2.0 / this.squidTentacles.length;
            final float lllllllllllllIlIIlIIlIllIIlIlllI = (float)Math.cos(lllllllllllllIlIIlIIlIllIIlIllll) * 5.0f;
            final float lllllllllllllIlIIlIIlIllIIlIllIl = (float)Math.sin(lllllllllllllIlIIlIIlIllIIlIllll) * 5.0f;
            this.squidTentacles[lllllllllllllIlIIlIIlIllIIllIIII].addBox(-1.0f, 0.0f, -1.0f, 2, 18, 2);
            this.squidTentacles[lllllllllllllIlIIlIIlIllIIllIIII].rotationPointX = lllllllllllllIlIIlIIlIllIIlIlllI;
            this.squidTentacles[lllllllllllllIlIIlIIlIllIIllIIII].rotationPointZ = lllllllllllllIlIIlIIlIllIIlIllIl;
            this.squidTentacles[lllllllllllllIlIIlIIlIllIIllIIII].rotationPointY = 15.0f;
            lllllllllllllIlIIlIIlIllIIlIllll = lllllllllllllIlIIlIIlIllIIllIIII * 3.141592653589793 * -2.0 / this.squidTentacles.length + 1.5707963267948966;
            this.squidTentacles[lllllllllllllIlIIlIIlIllIIllIIII].rotateAngleY = (float)lllllllllllllIlIIlIIlIllIIlIllll;
        }
    }
    
    @Override
    public void render(final Entity lllllllllllllIlIIlIIlIlIlllllIll, final float lllllllllllllIlIIlIIlIlIlllllIlI, final float lllllllllllllIlIIlIIlIllIIIIIIlI, final float lllllllllllllIlIIlIIlIllIIIIIIIl, final float lllllllllllllIlIIlIIlIllIIIIIIII, final float lllllllllllllIlIIlIIlIlIllllIllI, final float lllllllllllllIlIIlIIlIlIllllIlIl) {
        this.setRotationAngles(lllllllllllllIlIIlIIlIlIlllllIlI, lllllllllllllIlIIlIIlIllIIIIIIlI, lllllllllllllIlIIlIIlIllIIIIIIIl, lllllllllllllIlIIlIIlIllIIIIIIII, lllllllllllllIlIIlIIlIlIllllIllI, lllllllllllllIlIIlIIlIlIllllIlIl, lllllllllllllIlIIlIIlIlIlllllIll);
        this.squidBody.render(lllllllllllllIlIIlIIlIlIllllIlIl);
        final short lllllllllllllIlIIlIIlIlIllllIIIl;
        final char lllllllllllllIlIIlIIlIlIllllIIlI = (char)((ModelRenderer[])(Object)(lllllllllllllIlIIlIIlIlIllllIIIl = (short)(Object)this.squidTentacles)).length;
        for (short lllllllllllllIlIIlIIlIlIllllIIll = 0; lllllllllllllIlIIlIIlIlIllllIIll < lllllllllllllIlIIlIIlIlIllllIIlI; ++lllllllllllllIlIIlIIlIlIllllIIll) {
            final ModelRenderer lllllllllllllIlIIlIIlIlIllllllIl = lllllllllllllIlIIlIIlIlIllllIIIl[lllllllllllllIlIIlIIlIlIllllIIll];
            lllllllllllllIlIIlIIlIlIllllllIl.render(lllllllllllllIlIIlIIlIlIllllIlIl);
        }
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllIlIIlIIlIllIIIlllll, final float lllllllllllllIlIIlIIlIllIIIllllI, final float lllllllllllllIlIIlIIlIllIIIlIllI, final float lllllllllllllIlIIlIIlIllIIIlllII, final float lllllllllllllIlIIlIIlIllIIIllIll, final float lllllllllllllIlIIlIIlIllIIIllIlI, final Entity lllllllllllllIlIIlIIlIllIIIllIIl) {
        final boolean lllllllllllllIlIIlIIlIllIIIlIIlI;
        final double lllllllllllllIlIIlIIlIllIIIlIIll = ((ModelRenderer[])(Object)(lllllllllllllIlIIlIIlIllIIIlIIlI = (boolean)(Object)this.squidTentacles)).length;
        for (float lllllllllllllIlIIlIIlIllIIIlIlII = 0; lllllllllllllIlIIlIIlIllIIIlIlII < lllllllllllllIlIIlIIlIllIIIlIIll; ++lllllllllllllIlIIlIIlIllIIIlIlII) {
            final ModelRenderer lllllllllllllIlIIlIIlIllIIIllIII = lllllllllllllIlIIlIIlIllIIIlIIlI[lllllllllllllIlIIlIIlIllIIIlIlII];
            lllllllllllllIlIIlIIlIllIIIllIII.rotateAngleX = lllllllllllllIlIIlIIlIllIIIlIllI;
        }
    }
}
