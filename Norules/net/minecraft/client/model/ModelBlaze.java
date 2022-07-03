package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelBlaze extends ModelBase
{
    private final /* synthetic */ ModelRenderer[] blazeSticks;
    private final /* synthetic */ ModelRenderer blazeHead;
    
    @Override
    public void render(final Entity llllllllllllllIIIIlIlIlIllIllllI, final float llllllllllllllIIIIlIlIlIlllIIlll, final float llllllllllllllIIIIlIlIlIlllIIllI, final float llllllllllllllIIIIlIlIlIlllIIlIl, final float llllllllllllllIIIIlIlIlIlllIIIll, final float llllllllllllllIIIIlIlIlIllIllIII, final float llllllllllllllIIIIlIlIlIlllIIIIl) {
        this.setRotationAngles(llllllllllllllIIIIlIlIlIlllIIlll, llllllllllllllIIIIlIlIlIlllIIllI, llllllllllllllIIIIlIlIlIlllIIlIl, llllllllllllllIIIIlIlIlIlllIIIll, llllllllllllllIIIIlIlIlIllIllIII, llllllllllllllIIIIlIlIlIlllIIIIl, llllllllllllllIIIIlIlIlIllIllllI);
        this.blazeHead.render(llllllllllllllIIIIlIlIlIlllIIIIl);
        final boolean llllllllllllllIIIIlIlIlIllIlIIIl;
        final boolean llllllllllllllIIIIlIlIlIllIlIIll = ((ModelRenderer[])(Object)(llllllllllllllIIIIlIlIlIllIlIIIl = (boolean)(Object)this.blazeSticks)).length != 0;
        for (char llllllllllllllIIIIlIlIlIllIlIlII = '\0'; llllllllllllllIIIIlIlIlIllIlIlII < (llllllllllllllIIIIlIlIlIllIlIIll ? 1 : 0); ++llllllllllllllIIIIlIlIlIllIlIlII) {
            final ModelRenderer llllllllllllllIIIIlIlIlIlllIIIII = llllllllllllllIIIIlIlIlIllIlIIIl[llllllllllllllIIIIlIlIlIllIlIlII];
            llllllllllllllIIIIlIlIlIlllIIIII.render(llllllllllllllIIIIlIlIlIlllIIIIl);
        }
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIIIlIlIlIlIllIllI, final float llllllllllllllIIIIlIlIlIlIllIlII, final float llllllllllllllIIIIlIlIlIlIllIIlI, final float llllllllllllllIIIIlIlIlIlIllIIIl, final float llllllllllllllIIIIlIlIlIlIllIIII, final float llllllllllllllIIIIlIlIlIlIlIlllI, final Entity llllllllllllllIIIIlIlIlIlIlIllII) {
        float llllllllllllllIIIIlIlIlIlIlIlIll = llllllllllllllIIIIlIlIlIlIllIIlI * 3.1415927f * -0.1f;
        for (int llllllllllllllIIIIlIlIlIlIlIlIlI = 0; llllllllllllllIIIIlIlIlIlIlIlIlI < 4; ++llllllllllllllIIIIlIlIlIlIlIlIlI) {
            this.blazeSticks[llllllllllllllIIIIlIlIlIlIlIlIlI].rotationPointY = -2.0f + MathHelper.cos((llllllllllllllIIIIlIlIlIlIlIlIlI * 2 + llllllllllllllIIIIlIlIlIlIllIIlI) * 0.25f);
            this.blazeSticks[llllllllllllllIIIIlIlIlIlIlIlIlI].rotationPointX = MathHelper.cos(llllllllllllllIIIIlIlIlIlIlIlIll) * 9.0f;
            this.blazeSticks[llllllllllllllIIIIlIlIlIlIlIlIlI].rotationPointZ = MathHelper.sin(llllllllllllllIIIIlIlIlIlIlIlIll) * 9.0f;
            ++llllllllllllllIIIIlIlIlIlIlIlIll;
        }
        llllllllllllllIIIIlIlIlIlIlIlIll = 0.7853982f + llllllllllllllIIIIlIlIlIlIllIIlI * 3.1415927f * 0.03f;
        for (int llllllllllllllIIIIlIlIlIlIlIlIII = 4; llllllllllllllIIIIlIlIlIlIlIlIII < 8; ++llllllllllllllIIIIlIlIlIlIlIlIII) {
            this.blazeSticks[llllllllllllllIIIIlIlIlIlIlIlIII].rotationPointY = 2.0f + MathHelper.cos((llllllllllllllIIIIlIlIlIlIlIlIII * 2 + llllllllllllllIIIIlIlIlIlIllIIlI) * 0.25f);
            this.blazeSticks[llllllllllllllIIIIlIlIlIlIlIlIII].rotationPointX = MathHelper.cos(llllllllllllllIIIIlIlIlIlIlIlIll) * 7.0f;
            this.blazeSticks[llllllllllllllIIIIlIlIlIlIlIlIII].rotationPointZ = MathHelper.sin(llllllllllllllIIIIlIlIlIlIlIlIll) * 7.0f;
            ++llllllllllllllIIIIlIlIlIlIlIlIll;
        }
        llllllllllllllIIIIlIlIlIlIlIlIll = 0.47123894f + llllllllllllllIIIIlIlIlIlIllIIlI * 3.1415927f * -0.05f;
        for (int llllllllllllllIIIIlIlIlIlIlIIlll = 8; llllllllllllllIIIIlIlIlIlIlIIlll < 12; ++llllllllllllllIIIIlIlIlIlIlIIlll) {
            this.blazeSticks[llllllllllllllIIIIlIlIlIlIlIIlll].rotationPointY = 11.0f + MathHelper.cos((llllllllllllllIIIIlIlIlIlIlIIlll * 1.5f + llllllllllllllIIIIlIlIlIlIllIIlI) * 0.5f);
            this.blazeSticks[llllllllllllllIIIIlIlIlIlIlIIlll].rotationPointX = MathHelper.cos(llllllllllllllIIIIlIlIlIlIlIlIll) * 5.0f;
            this.blazeSticks[llllllllllllllIIIIlIlIlIlIlIIlll].rotationPointZ = MathHelper.sin(llllllllllllllIIIIlIlIlIlIlIlIll) * 5.0f;
            ++llllllllllllllIIIIlIlIlIlIlIlIll;
        }
        this.blazeHead.rotateAngleY = llllllllllllllIIIIlIlIlIlIllIIIl * 0.017453292f;
        this.blazeHead.rotateAngleX = llllllllllllllIIIIlIlIlIlIllIIII * 0.017453292f;
    }
    
    public ModelBlaze() {
        this.blazeSticks = new ModelRenderer[12];
        for (int llllllllllllllIIIIlIlIlIlllllIII = 0; llllllllllllllIIIIlIlIlIlllllIII < this.blazeSticks.length; ++llllllllllllllIIIIlIlIlIlllllIII) {
            (this.blazeSticks[llllllllllllllIIIIlIlIlIlllllIII] = new ModelRenderer(this, 0, 16)).addBox(0.0f, 0.0f, 0.0f, 2, 8, 2);
        }
        this.blazeHead = new ModelRenderer(this, 0, 0);
        this.blazeHead.addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
    }
}
