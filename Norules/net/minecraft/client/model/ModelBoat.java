package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;

public class ModelBoat extends ModelBase implements IMultipassModel
{
    public /* synthetic */ ModelRenderer[] paddles;
    public /* synthetic */ ModelRenderer noWater;
    public /* synthetic */ ModelRenderer[] boatSides;
    private final /* synthetic */ int patchList;
    
    protected ModelRenderer makePaddle(final boolean llllllllllllllIlIIllIlIlllIllIlI) {
        final ModelRenderer llllllllllllllIlIIllIlIllllIIIII = new ModelRenderer(this, 62, llllllllllllllIlIIllIlIlllIllIlI ? 0 : 20).setTextureSize(128, 64);
        final int llllllllllllllIlIIllIlIlllIlllll = 20;
        final int llllllllllllllIlIIllIlIlllIllllI = 7;
        final int llllllllllllllIlIIllIlIlllIlllIl = 6;
        final float llllllllllllllIlIIllIlIlllIlllII = -5.0f;
        llllllllllllllIlIIllIlIllllIIIII.addBox(-1.0f, 0.0f, -5.0f, 2, 2, 18);
        llllllllllllllIlIIllIlIllllIIIII.addBox(llllllllllllllIlIIllIlIlllIllIlI ? -1.001f : 0.001f, -3.0f, 8.0f, 1, 6, 7);
        return llllllllllllllIlIIllIlIllllIIIII;
    }
    
    @Override
    public void render(final Entity llllllllllllllIlIIllIllIIIIIlIII, final float llllllllllllllIlIIllIlIlllllllIl, final float llllllllllllllIlIIllIllIIIIIIllI, final float llllllllllllllIlIIllIlIllllllIll, final float llllllllllllllIlIIllIllIIIIIIlII, final float llllllllllllllIlIIllIlIllllllIIl, final float llllllllllllllIlIIllIlIllllllIII) {
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        final EntityBoat llllllllllllllIlIIllIllIIIIIIIIl = (EntityBoat)llllllllllllllIlIIllIllIIIIIlIII;
        this.setRotationAngles(llllllllllllllIlIIllIlIlllllllIl, llllllllllllllIlIIllIllIIIIIIllI, llllllllllllllIlIIllIlIllllllIll, llllllllllllllIlIIllIllIIIIIIlII, llllllllllllllIlIIllIlIllllllIIl, llllllllllllllIlIIllIlIllllllIII, llllllllllllllIlIIllIllIIIIIlIII);
        for (int llllllllllllllIlIIllIllIIIIIIIII = 0; llllllllllllllIlIIllIllIIIIIIIII < 5; ++llllllllllllllIlIIllIllIIIIIIIII) {
            this.boatSides[llllllllllllllIlIIllIllIIIIIIIII].render(llllllllllllllIlIIllIlIllllllIII);
        }
        this.renderPaddle(llllllllllllllIlIIllIllIIIIIIIIl, 0, llllllllllllllIlIIllIlIllllllIII, llllllllllllllIlIIllIlIlllllllIl);
        this.renderPaddle(llllllllllllllIlIIllIllIIIIIIIIl, 1, llllllllllllllIlIIllIlIllllllIII, llllllllllllllIlIIllIlIlllllllIl);
    }
    
    protected void renderPaddle(final EntityBoat llllllllllllllIlIIllIlIlllIIIlIl, final int llllllllllllllIlIIllIlIlllIIlIll, final float llllllllllllllIlIIllIlIlllIIlIlI, final float llllllllllllllIlIIllIlIlllIIlIIl) {
        final float llllllllllllllIlIIllIlIlllIIlIII = llllllllllllllIlIIllIlIlllIIIlIl.getRowingTime(llllllllllllllIlIIllIlIlllIIlIll, llllllllllllllIlIIllIlIlllIIlIIl);
        final ModelRenderer llllllllllllllIlIIllIlIlllIIIlll = this.paddles[llllllllllllllIlIIllIlIlllIIlIll];
        llllllllllllllIlIIllIlIlllIIIlll.rotateAngleX = (float)MathHelper.clampedLerp(-1.0471975803375244, -0.2617993950843811, (MathHelper.sin(-llllllllllllllIlIIllIlIlllIIlIII) + 1.0f) / 2.0f);
        llllllllllllllIlIIllIlIlllIIIlll.rotateAngleY = (float)MathHelper.clampedLerp(-0.7853981633974483, 0.7853981633974483, (MathHelper.sin(-llllllllllllllIlIIllIlIlllIIlIII + 1.0f) + 1.0f) / 2.0f);
        if (llllllllllllllIlIIllIlIlllIIlIll == 1) {
            llllllllllllllIlIIllIlIlllIIIlll.rotateAngleY = 3.1415927f - llllllllllllllIlIIllIlIlllIIIlll.rotateAngleY;
        }
        llllllllllllllIlIIllIlIlllIIIlll.render(llllllllllllllIlIIllIlIlllIIlIlI);
    }
    
    @Override
    public void renderMultipass(final Entity llllllllllllllIlIIllIlIlllllIIlI, final float llllllllllllllIlIIllIlIlllllIIIl, final float llllllllllllllIlIIllIlIlllllIIII, final float llllllllllllllIlIIllIlIllllIllll, final float llllllllllllllIlIIllIlIllllIlllI, final float llllllllllllllIlIIllIlIllllIllIl, final float llllllllllllllIlIIllIlIllllIllII) {
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.colorMask(false, false, false, false);
        this.noWater.render(llllllllllllllIlIIllIlIllllIllII);
        GlStateManager.colorMask(true, true, true, true);
    }
    
    public ModelBoat() {
        this.boatSides = new ModelRenderer[5];
        this.paddles = new ModelRenderer[2];
        this.patchList = GLAllocation.generateDisplayLists(1);
        this.boatSides[0] = new ModelRenderer(this, 0, 0).setTextureSize(128, 64);
        this.boatSides[1] = new ModelRenderer(this, 0, 19).setTextureSize(128, 64);
        this.boatSides[2] = new ModelRenderer(this, 0, 27).setTextureSize(128, 64);
        this.boatSides[3] = new ModelRenderer(this, 0, 35).setTextureSize(128, 64);
        this.boatSides[4] = new ModelRenderer(this, 0, 43).setTextureSize(128, 64);
        final int llllllllllllllIlIIllIllIIIIllllI = 32;
        final int llllllllllllllIlIIllIllIIIIlllIl = 6;
        final int llllllllllllllIlIIllIllIIIIlllII = 20;
        final int llllllllllllllIlIIllIllIIIIllIll = 4;
        final int llllllllllllllIlIIllIllIIIIllIlI = 28;
        this.boatSides[0].addBox(-14.0f, -9.0f, -3.0f, 28, 16, 3, 0.0f);
        this.boatSides[0].setRotationPoint(0.0f, 3.0f, 1.0f);
        this.boatSides[1].addBox(-13.0f, -7.0f, -1.0f, 18, 6, 2, 0.0f);
        this.boatSides[1].setRotationPoint(-15.0f, 4.0f, 4.0f);
        this.boatSides[2].addBox(-8.0f, -7.0f, -1.0f, 16, 6, 2, 0.0f);
        this.boatSides[2].setRotationPoint(15.0f, 4.0f, 0.0f);
        this.boatSides[3].addBox(-14.0f, -7.0f, -1.0f, 28, 6, 2, 0.0f);
        this.boatSides[3].setRotationPoint(0.0f, 4.0f, -9.0f);
        this.boatSides[4].addBox(-14.0f, -7.0f, -1.0f, 28, 6, 2, 0.0f);
        this.boatSides[4].setRotationPoint(0.0f, 4.0f, 9.0f);
        this.boatSides[0].rotateAngleX = 1.5707964f;
        this.boatSides[1].rotateAngleY = 4.712389f;
        this.boatSides[2].rotateAngleY = 1.5707964f;
        this.boatSides[3].rotateAngleY = 3.1415927f;
        (this.paddles[0] = this.makePaddle(true)).setRotationPoint(3.0f, -5.0f, 9.0f);
        (this.paddles[1] = this.makePaddle(false)).setRotationPoint(3.0f, -5.0f, -9.0f);
        this.paddles[1].rotateAngleY = 3.1415927f;
        this.paddles[0].rotateAngleZ = 0.19634955f;
        this.paddles[1].rotateAngleZ = 0.19634955f;
        this.noWater = new ModelRenderer(this, 0, 0).setTextureSize(128, 64);
        this.noWater.addBox(-14.0f, -9.0f, -3.0f, 28, 16, 3, 0.0f);
        this.noWater.setRotationPoint(0.0f, -3.0f, 1.0f);
        this.noWater.rotateAngleX = 1.5707964f;
    }
}
