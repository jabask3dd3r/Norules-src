package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import java.util.*;

public class ModelGhast extends ModelBase
{
    /* synthetic */ ModelRenderer[] tentacles;
    /* synthetic */ ModelRenderer body;
    
    @Override
    public void render(final Entity lllllllllllllllIIIllIlIIlIIlIlIl, final float lllllllllllllllIIIllIlIIlIIlllIl, final float lllllllllllllllIIIllIlIIlIIlIIll, final float lllllllllllllllIIIllIlIIlIIllIll, final float lllllllllllllllIIIllIlIIlIIllIlI, final float lllllllllllllllIIIllIlIIlIIlIIII, final float lllllllllllllllIIIllIlIIlIIllIII) {
        this.setRotationAngles(lllllllllllllllIIIllIlIIlIIlllIl, lllllllllllllllIIIllIlIIlIIlIIll, lllllllllllllllIIIllIlIIlIIllIll, lllllllllllllllIIIllIlIIlIIllIlI, lllllllllllllllIIIllIlIIlIIlIIII, lllllllllllllllIIIllIlIIlIIllIII, lllllllllllllllIIIllIlIIlIIlIlIl);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.6f, 0.0f);
        this.body.render(lllllllllllllllIIIllIlIIlIIllIII);
        final String lllllllllllllllIIIllIlIIlIIIlIll;
        final String lllllllllllllllIIIllIlIIlIIIllII = (String)((ModelRenderer[])(Object)(lllllllllllllllIIIllIlIIlIIIlIll = (String)(Object)this.tentacles)).length;
        for (long lllllllllllllllIIIllIlIIlIIIllIl = 0; lllllllllllllllIIIllIlIIlIIIllIl < lllllllllllllllIIIllIlIIlIIIllII; ++lllllllllllllllIIIllIlIIlIIIllIl) {
            final ModelRenderer lllllllllllllllIIIllIlIIlIIlIlll = lllllllllllllllIIIllIlIIlIIIlIll[lllllllllllllllIIIllIlIIlIIIllIl];
            lllllllllllllllIIIllIlIIlIIlIlll.render(lllllllllllllllIIIllIlIIlIIllIII);
        }
        GlStateManager.popMatrix();
    }
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIIIllIlIIlIllIllI, final float lllllllllllllllIIIllIlIIlIllIlIl, final float lllllllllllllllIIIllIlIIlIllIlII, final float lllllllllllllllIIIllIlIIlIllIIll, final float lllllllllllllllIIIllIlIIlIllIIlI, final float lllllllllllllllIIIllIlIIlIllIIIl, final Entity lllllllllllllllIIIllIlIIlIllIIII) {
        for (int lllllllllllllllIIIllIlIIlIlIllll = 0; lllllllllllllllIIIllIlIIlIlIllll < this.tentacles.length; ++lllllllllllllllIIIllIlIIlIlIllll) {
            this.tentacles[lllllllllllllllIIIllIlIIlIlIllll].rotateAngleX = 0.2f * MathHelper.sin(lllllllllllllllIIIllIlIIlIllIlII * 0.3f + lllllllllllllllIIIllIlIIlIlIllll) + 0.4f;
        }
    }
    
    public ModelGhast() {
        this.tentacles = new ModelRenderer[9];
        final int lllllllllllllllIIIllIlIIllIIIlll = -16;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        final ModelRenderer body = this.body;
        body.rotationPointY += 8.0f;
        final Random lllllllllllllllIIIllIlIIllIIIllI = new Random(1660L);
        for (int lllllllllllllllIIIllIlIIllIIIlIl = 0; lllllllllllllllIIIllIlIIllIIIlIl < this.tentacles.length; ++lllllllllllllllIIIllIlIIllIIIlIl) {
            this.tentacles[lllllllllllllllIIIllIlIIllIIIlIl] = new ModelRenderer(this, 0, 0);
            final float lllllllllllllllIIIllIlIIllIIIlII = ((lllllllllllllllIIIllIlIIllIIIlIl % 3 - lllllllllllllllIIIllIlIIllIIIlIl / 3 % 2 * 0.5f + 0.25f) / 2.0f * 2.0f - 1.0f) * 5.0f;
            final float lllllllllllllllIIIllIlIIllIIIIll = (lllllllllllllllIIIllIlIIllIIIlIl / 3 / 2.0f * 2.0f - 1.0f) * 5.0f;
            final int lllllllllllllllIIIllIlIIllIIIIlI = lllllllllllllllIIIllIlIIllIIIllI.nextInt(7) + 8;
            this.tentacles[lllllllllllllllIIIllIlIIllIIIlIl].addBox(-1.0f, 0.0f, -1.0f, 2, lllllllllllllllIIIllIlIIllIIIIlI, 2);
            this.tentacles[lllllllllllllllIIIllIlIIllIIIlIl].rotationPointX = lllllllllllllllIIIllIlIIllIIIlII;
            this.tentacles[lllllllllllllllIIIllIlIIllIIIlIl].rotationPointZ = lllllllllllllllIIIllIlIIllIIIIll;
            this.tentacles[lllllllllllllllIIIllIlIIllIIIlIl].rotationPointY = 15.0f;
        }
    }
}
