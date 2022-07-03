package net.minecraft.client.model;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;

public class ModelMagmaCube extends ModelBase
{
    /* synthetic */ ModelRenderer[] segments;
    /* synthetic */ ModelRenderer core;
    
    public ModelMagmaCube() {
        this.segments = new ModelRenderer[8];
        for (int lllllllllllllIlIIlIlIlIIIIIllllI = 0; lllllllllllllIlIIlIlIlIIIIIllllI < this.segments.length; ++lllllllllllllIlIIlIlIlIIIIIllllI) {
            int lllllllllllllIlIIlIlIlIIIIIlllIl = 0;
            int lllllllllllllIlIIlIlIlIIIIIlllII;
            if ((lllllllllllllIlIIlIlIlIIIIIlllII = lllllllllllllIlIIlIlIlIIIIIllllI) == 2) {
                lllllllllllllIlIIlIlIlIIIIIlllIl = 24;
                lllllllllllllIlIIlIlIlIIIIIlllII = 10;
            }
            else if (lllllllllllllIlIIlIlIlIIIIIllllI == 3) {
                lllllllllllllIlIIlIlIlIIIIIlllIl = 24;
                lllllllllllllIlIIlIlIlIIIIIlllII = 19;
            }
            (this.segments[lllllllllllllIlIIlIlIlIIIIIllllI] = new ModelRenderer(this, lllllllllllllIlIIlIlIlIIIIIlllIl, lllllllllllllIlIIlIlIlIIIIIlllII)).addBox(-4.0f, (float)(16 + lllllllllllllIlIIlIlIlIIIIIllllI), -4.0f, 8, 1, 8);
        }
        this.core = new ModelRenderer(this, 0, 16);
        this.core.addBox(-2.0f, 18.0f, -2.0f, 4, 4, 4);
    }
    
    @Override
    public void setLivingAnimations(final EntityLivingBase lllllllllllllIlIIlIlIlIIIIIIlIII, final float lllllllllllllIlIIlIlIlIIIIIIllll, final float lllllllllllllIlIIlIlIlIIIIIIlllI, final float lllllllllllllIlIIlIlIlIIIIIIIlll) {
        final EntityMagmaCube lllllllllllllIlIIlIlIlIIIIIIllII = (EntityMagmaCube)lllllllllllllIlIIlIlIlIIIIIIlIII;
        float lllllllllllllIlIIlIlIlIIIIIIlIll = lllllllllllllIlIIlIlIlIIIIIIllII.prevSquishFactor + (lllllllllllllIlIIlIlIlIIIIIIllII.squishFactor - lllllllllllllIlIIlIlIlIIIIIIllII.prevSquishFactor) * lllllllllllllIlIIlIlIlIIIIIIIlll;
        if (lllllllllllllIlIIlIlIlIIIIIIlIll < 0.0f) {
            lllllllllllllIlIIlIlIlIIIIIIlIll = 0.0f;
        }
        for (int lllllllllllllIlIIlIlIlIIIIIIlIlI = 0; lllllllllllllIlIIlIlIlIIIIIIlIlI < this.segments.length; ++lllllllllllllIlIIlIlIlIIIIIIlIlI) {
            this.segments[lllllllllllllIlIIlIlIlIIIIIIlIlI].rotationPointY = -(4 - lllllllllllllIlIIlIlIlIIIIIIlIlI) * lllllllllllllIlIIlIlIlIIIIIIlIll * 1.7f;
        }
    }
    
    @Override
    public void render(final Entity lllllllllllllIlIIlIlIIllllllIllI, final float lllllllllllllIlIIlIlIIllllllIlIl, final float lllllllllllllIlIIlIlIIllllllIlII, final float lllllllllllllIlIIlIlIIlllllIlIlI, final float lllllllllllllIlIIlIlIIllllllIIlI, final float lllllllllllllIlIIlIlIIlllllIlIII, final float lllllllllllllIlIIlIlIIlllllIIlll) {
        this.setRotationAngles(lllllllllllllIlIIlIlIIllllllIlIl, lllllllllllllIlIIlIlIIllllllIlII, lllllllllllllIlIIlIlIIlllllIlIlI, lllllllllllllIlIIlIlIIllllllIIlI, lllllllllllllIlIIlIlIIlllllIlIII, lllllllllllllIlIIlIlIIlllllIIlll, lllllllllllllIlIIlIlIIllllllIllI);
        this.core.render(lllllllllllllIlIIlIlIIlllllIIlll);
        final int lllllllllllllIlIIlIlIIlllllIIIll;
        final char lllllllllllllIlIIlIlIIlllllIIlII = (char)((ModelRenderer[])(Object)(lllllllllllllIlIIlIlIIlllllIIIll = (int)(Object)this.segments)).length;
        for (boolean lllllllllllllIlIIlIlIIlllllIIlIl = false; (lllllllllllllIlIIlIlIIlllllIIlIl ? 1 : 0) < lllllllllllllIlIIlIlIIlllllIIlII; ++lllllllllllllIlIIlIlIIlllllIIlIl) {
            final ModelRenderer lllllllllllllIlIIlIlIIlllllIllll = lllllllllllllIlIIlIlIIlllllIIIll[lllllllllllllIlIIlIlIIlllllIIlIl];
            lllllllllllllIlIIlIlIIlllllIllll.render(lllllllllllllIlIIlIlIIlllllIIlll);
        }
    }
}
